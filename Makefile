PWD = $(shell pwd)
GOPATH_DIR = $(PWD)/gopath
SKYCOIN_DIR = gopath/src/github.com/skycoin/skycoin
SKYBUILD_DIR = $(SKYCOIN_DIR)/build
BUILDLIBC_DIR = $(SKYBUILD_DIR)/libskycoin
LIBC_DIR = $(SKYCOIN_DIR)/lib/cgo
LIBSWIG_DIR = swig
BUILD_DIR = build
BIN_DIR = $(SKYCOIN_DIR)/bin
INCLUDE_DIR = $(SKYCOIN_DIR)/include
FULL_PATH_LIB = $(PWD)/$(BUILDLIBC_DIR)

LIB_FILES = $(shell find $(SKYCOIN_DIR)/lib/cgo -type f -name "*.go")
SRC_FILES = $(shell find $(SKYCOIN_DIR)/src -type f -name "*.go")
SWIG_FILES = $(shell find $(LIBSWIG_DIR) -type f -name "*.i")
HEADER_FILES = $(shell find $(SKYCOIN_DIR)/include -type f -name "*.h")

configure:
	mkdir -p $(BUILD_DIR)/usr/tmp $(BUILD_DIR)/usr/lib $(BUILD_DIR)/usr/include
	mkdir -p $(BUILDLIBC_DIR) $(BIN_DIR) $(INCLUDE_DIR)

## Build libskycoin C client library
build-libc: configure
	rm -f $(BUILDLIBC_DIR)/libskycoin.a
	GOPATH="$(GOPATH_DIR)" make -C $(SKYCOIN_DIR) build-libc-static
	ls $(BUILDLIBC_DIR)
	rm -f swig/include/libskycoin.h
	mkdir -p swig/include
	grep -v _Complex $(INCLUDE_DIR)/libskycoin.h > swig/include/libskycoin.h

build-swig:
	#Generate structs.i from skytypes.gen.h
	rm -f $(LIBSWIG_DIR)/structs.i
	cp $(INCLUDE_DIR)/skytypes.gen.h $(LIBSWIG_DIR)/structs.i
	#sed -i 's/#/%/g' $(LIBSWIG_DIR)/structs.i
	{ \
		if [[ "$$(uname -s)" == "Darwin" ]]; then \
			sed -i '.kbk' 's/#/%/g' $(LIBSWIG_DIR)/structs.i ;\
		else \
			sed -i 's/#/%/g' $(LIBSWIG_DIR)/structs.i ;\
		fi \
	}
	rm -f swig/include/swig.h
	rm -f skycoinnet_wrap.c
	cp -v gopath/src/github.com/skycoin/skycoin/include/swig.h swig/include/
	rm -rfv src/main/java/skycoin/libjava
	mkdir -p src/main/java/skycoin/libjava
	swig  -DUSE_ASSERT_EXCEPTIONS -java -v -package skycoin.libjava -Iswig/include -I$(INCLUDE_DIR) -outdir src/main/java/skycoin/libjava -o skycoin_wrap.c $(LIBSWIG_DIR)/skycoin.i
 
build-libc-swig: build-libc build-swig

build-libjava:
	gcc -c -fpic -I /usr/lib/jvm/java-8-openjdk-amd64/include/  -I /usr/lib/jvm/java-8-openjdk-amd64/include/linux -I swig/include -I$(INCLUDE_DIR) skycoin_wrap.c
	gcc -shared skycoin_wrap.o $(BUILDLIBC_DIR)/libskycoin.a -o libskycoin.so
	sudo cp -fv libskycoin.so /lib
	
	
test: build-libc-swig build-libjava
	mvn clean
	mvn test
	mvn clean
PWD = $(shell pwd)
GOPATH_DIR = $(PWD)/gopath
SKYCOIN_DIR = gopath/src/github.com/skycoin/skycoin
SKYBUILD_DIR = $(SKYCOIN_DIR)/build
BUILDLIBC_DIR = $(SKYBUILD_DIR)/libskycoin
LIBC_DIR = $(SKYCOIN_DIR)/lib/cgo
LIBSWIG_DIR = $(SKYCOIN_DIR)/lib/swig
BUILD_DIR = build
BIN_DIR = $(SKYCOIN_DIR)/bin
INCLUDE_DIR = $(SKYCOIN_DIR)/include
FULL_PATH_LIB = $(PWD)/$(BUILDLIBC_DIR)
LD_LIBRARY_PATH=/usr/java/packages/lib/amd64:/usr/lib/x86_64-linux-gnu/jni:/lib/x86_64-linux-gnu:/usr/lib/x86_64-linux-gnu:/usr/lib/jni:/lib:/usr/lib:bin/skycoin:bin/test

LIB_FILES = $(shell find $(SKYCOIN_DIR)/lib/cgo -type f -name "*.go")
SRC_FILES = $(shell find $(SKYCOIN_DIR)/src -type f -name "*.go")
SWIG_FILES = $(shell find $(LIBSWIG_DIR) -type f -name "*.i")
HEADER_FILES = $(shell find $(SKYCOIN_DIR)/include -type f -name "*.h")
# LD_LIBRARY_PATH=libskycoin.so

configure:
	mkdir -p $(BUILD_DIR)/usr/tmp $(BUILD_DIR)/usr/lib $(BUILD_DIR)/usr/include
	mkdir -p $(BUILDLIBC_DIR) $(BIN_DIR) $(INCLUDE_DIR)

$(BUILDLIBC_DIR)/libskycoin.a: $(LIB_FILES) $(SRC_FILES) $(HEADER_FILES)
	rm -f $(BUILDLIBC_DIR)/libskycoin.a
	GOPATH="$(GOPATH_DIR)" make -C $(SKYCOIN_DIR) build-libc-static
	ls $(BUILDLIBC_DIR)
	rm -f swig/include/libskycoin.h
	mkdir -p swig
	mkdir -p swig/include
	grep -v _Complex $(INCLUDE_DIR)/libskycoin.h > swig/include/libskycoin.h

## Build libskycoin C client library
build-libc: configure $(BUILDLIBC_DIR)/libskycoin.a

build-swig: build-libc
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
	# rm -rf src/skycoin
	rm -rf bin/skycoin
	mkdir -p src/skycoin
	mkdir -p bin/skycoin
	swig  -DUSE_ASSERT_EXCEPTIONS -java -v -package skycoin -Iswig/include -I$(INCLUDE_DIR) -outdir src/skycoin -o src/skycoin/skycoin_wrap.c $(LIBSWIG_DIR)/skycoin.i
 
build-libjava: build-swig
	gcc -c -fpic -I /usr/lib/jvm/java-8-openjdk-amd64/include/  -I /usr/lib/jvm/java-8-openjdk-amd64/include/linux -I swig/include -I$(INCLUDE_DIR) src/skycoin/skycoin_wrap.c
	rm libskycoin.so
	gcc -shared skycoin_wrap.o $(BUILDLIBC_DIR)/libskycoin.a -o libskycoin.so
	cp -f libskycoin.so bin/
	cp -f libskycoin.so bin/skycoin
	cp -f libskycoin.so bin/test
	cp -f libskycoin.so src/skycoin
	javac -d bin/ src/skycoin/*.java
	jar cf skycoin.jar -C bin/ .
	cp -f skycoin.jar lib/
	
test: build-libjava
	# javac -d bin/test -cp /usr/share/java/junit4.jar:skycoin.jar src/test/simple.java
	# java -verbose:jni  -Djava.library.path=$(PWD) -cp .:/usr/share/java/junit-4.jar:/usr/share/java/hamcrest-core-1.3.jar:skycoin.jar:bin/skycoin  test.simple
	javac -cp lib/*:. src/test/simple.java
	java -cp lib/*:. org.junit.platform.console.ConsoleLauncher -p test.simple

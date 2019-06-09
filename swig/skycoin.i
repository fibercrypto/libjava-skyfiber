%module skycoin
%include "typemaps.i"

%{
	#define SWIG_FILE_WITH_INIT
	#include "libskycoin.h"
	#include "swig.h"
	#include "skyerrors.h"
%}
%include "/gopath/src/github.com/skycoin/libskycoin/lib/swig/common/common.i"
%include "/gopath/src/github.com/skycoin/libskycoin/lib/swig/static/static.i"
%include "java_typemap.i"
%include "java_structs_typemaps.i"
%include "java_basic.i"
%include "java_skycoin.mem.i"
%include "java_callback.i"

%include "swig.h"
/* Find the modified copy of libskycoin */
%include "libskycoin.h"
%include "structs.i"
%include "skyerrors.h"
// %include "base64.h"


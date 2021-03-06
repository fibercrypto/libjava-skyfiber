
/* Handle not as pointer is input. */
%typemap(in) Handle {
	$input =  (jlong*)&$1;
} 
%typemap(in) Handle* {
	$input =  (jlong*)&$1;
} 
%include "typemaps.i"
%include cpointer.i
%pointer_functions(GoSlice, GoSlicePtr);
%pointer_functions(GoUint8, GoUint8Ptr);
%pointer_functions(unsigned char, CharPtr);
%pointer_functions(_GoString_, GoStringPtr);
%pointer_functions(coin__Transaction, coin__TransactionPtr);
%pointer_functions(AddressUxOuts_Handle, AddressUxOuts__HandlePtr);
%pointer_functions(GoUint64, GoUint64Ptr);
%pointer_functions(GoInt, GoIntPtr);
%pointer_functions(GoUint16, GoUint16Ptr);
%pointer_functions(GoUint32, GoUint32Ptr);
%pointer_functions(cipher__Address, cipher__AddressPtr);
%pointer_functions(Transactions__Handle, Transactions__HandlePtr);
%pointer_functions(Transaction__Handle, Transaction__HandlePtr);
%pointer_functions(Block__Handle,Block__HandlePtr);
%pointer_functions(BlockHeader__Handle,BlockHeader__HandlePtr);
%pointer_functions(BlockBody__Handle,BlockBody__HandlePtr);
%pointer_functions(Signature_Handle,Signature_HandlePtr);
%pointer_functions(Number_Handle,Number_HandlePtr);
%pointer_functions(Distribution__Handle,Distribution__HandlePtr);
%pointer_functions(FeeCalculator, FeeCalculatorPtr);
%pointer_functions(FeeCalcFunc, FeeCalcFuncPtr);
%pointer_functions(coin__Block*, coin__BlockPtr);
%pointer_functions(Coin__Handle, Coin__HandlePtr);
%pointer_functions(Account__Handle, Account__HandlePtr);
%pointer_functions(PrivateKey__Handle, PrivateKey__HandlePtr);
%pointer_functions(PublicKey__Handle, PublicKey__HandlePtr);
%pointer_functions(Path__Handle, Path__HandlePtr);

/*GoString* parameter as reference */
%typemap(in, numinputs=0) GoString* (GoString temp) {
	temp.p = NULL;
	temp.n = 0;
	$1 = ($1_type)&temp;
}

/**
* Import library
**/
%include "typemaps.i"
// Pubkey
%typemap(jni,pre="cipher_PubKey tmp$javainput = new_cipher_PubKeyPtr();") (GoUint8_ (*) [33])  "cipher__PubKey*"
%typemap(jstype,pre="long tmp$javainput = cipher_PubKey.getCPtr ($javainput);") (GoUint8_ (*) [33])  "cipher_PubKey"
%typemap(javain,pre="long tmp$javainput = cipher_PubKey.getCPtr ($javainput);") (GoUint8_ (*) [33])  "tmp$javainput"

// Seckey
%typemap(jni,pre="cipher_SecKey tmp$javainput = new_cipher_SecKeyPtr();") (GoUint8_ (*) [32])  "cipher_SecKey*"
%typemap(jstype,pre=" long tmp$javainput = cipher_SecKey.getCPtr ($javainput);") (GoUint8_ (*) [32])  "cipher_SecKey"
%typemap(javain,pre="long tmp$javainput = cipher_SecKey.getCPtr ($javainput);") (GoUint8_ (*) [32])  "tmp$javainput"

// Sig
%typemap(jni,pre="cipher_Sig tmp$javainput = new cipher_Sig();") (GoUint8_ (*) [65])  "cipher_Sig*"
%typemap(jstype,pre=" long tmp$javainput = cipher_Sig.getCPtr ($javainput);") (GoUint8_ (*) [65])  "cipher_Sig"
%typemap(javain,pre="long tmp$javainput = cipher_Sig.getCPtr ($javainput);") (GoUint8_ (*) [65])  "tmp$javainput"

// cipher__Ripemd160
%typemap(jni,pre="cipher__Ripemd160 tmp$javainput = new_cipher_Ripemd160p();") (GoUint8_ (*) [20])  "cipher_Ripemd160*"
%typemap(jstype,pre=" long tmp$javainput = cipher_Ripemd160.getCPtr ($javainput);") (GoUint8_ (*) [20])  "cipher_Ripemd160"
%typemap(javain,pre="long tmp$javainput = cipher_Ripemd160.getCPtr ($javainput);") (GoUint8_ (*) [20])  "tmp$javainput"

// GoString
%typemap(jni,pre="GoString_ tmp$javainput = new_GoStringp_();") GoString_*  "GoString*"
%typemap(jstype,pre=" long tmp$javainput = _GoString_.getCPtr ($javainput);") GoString_*  "_GoString_"
%typemap(javain,pre="long tmp$javainput = _GoString_.getCPtr ($javainput);") GoString_*  "tmp$javainput"

// GoSlice
%typemap(jni) GoSlice_*  "GoSlice_ *"
%typemap(jstype,pre=" long tmp$javainput = GoSlice.getCPtr ($javainput);") GoSlice_*  "GoSlice"
%typemap(javain) GoSlice_*  "GoSlice.getCPtr ($javainput)"

// coin__UxArray
%typemap(jni) coin__UxArray*  "coin__UxArray *"
%typemap(jstype,pre=" long tmp$javainput = coin__UxArray.getCPtr ($javainput);") coin__UxArray*  "coin__UxArray"
%typemap(javain) coin__UxArray*  "coin__UxArray.getCPtr ($javainput)"

%apply unsigned short  {GoUint16, GoUint16_};
%apply unsigned long  {GoUintptr, __SIZE_TYPE__};
%apply short  {GoInt16, GoInt16_};
%apply unsigned char  {GoUint8_, GoUint8};
%apply unsigned int  {GoUint32_, GoUint32};
%apply signed char  {GoInt8_, GoInt8};
%apply unsigned long long  {GoUint64, GoUint64_,GoUint,GoUint_};
%apply long long  {GoInt64, GoInt64_,GoInt_, GoInt };
%apply int {GoInt32,GoInt32_,ptrdiff_t};
%apply int* {GoInt32*,GoInt32_*,ptrdiff_t*};
%apply float {GoFloat32};
%apply double {GoFloat64};


%typemap(freearg) (cipher_PubKeys* __in_pubKeys) {
  if ($1->data) free($1->data);
}

// Array
%include "arrays_java.i"
%apply int[] {int *};
%apply char[] {char *};

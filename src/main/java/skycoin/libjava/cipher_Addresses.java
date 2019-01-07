/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package skycoin.libjava;

public class cipher_Addresses {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected cipher_Addresses(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(cipher_Addresses obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        skycoinJNI.delete_cipher_Addresses(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public cipher__Address getAt(int i) {
    long cPtr = skycoinJNI.cipher_Addresses_getAt(swigCPtr, this, i);
    return (cPtr == 0) ? null : new cipher__Address(cPtr, false);
  }

  public int setAt(int i, cipher_Addresses addr) {
    return skycoinJNI.cipher_Addresses_setAt(swigCPtr, this, i, cipher_Addresses.getCPtr(addr), addr);
  }

  public int isEqual(cipher_Addresses a) {
    return skycoinJNI.cipher_Addresses_isEqual(swigCPtr, this, cipher_Addresses.getCPtr(a), a);
  }

  public void allocate(int n) {
    skycoinJNI.cipher_Addresses_allocate(swigCPtr, this, n);
  }

  public void release() {
    skycoinJNI.cipher_Addresses_release(swigCPtr, this);
  }

  public void setData(cipher__Address value) {
    skycoinJNI.cipher_Addresses_data_set(swigCPtr, this, cipher__Address.getCPtr(value), value);
  }

  public cipher__Address getData() {
    long cPtr = skycoinJNI.cipher_Addresses_data_get(swigCPtr, this);
    return (cPtr == 0) ? null : new cipher__Address(cPtr, false);
  }

  public void setCount(int value) {
    skycoinJNI.cipher_Addresses_count_set(swigCPtr, this, value);
  }

  public int getCount() {
    return skycoinJNI.cipher_Addresses_count_get(swigCPtr, this);
  }

  public cipher_Addresses() {
    this(skycoinJNI.new_cipher_Addresses(), true);
  }

}

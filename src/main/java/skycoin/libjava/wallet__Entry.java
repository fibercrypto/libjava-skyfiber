/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package skyfiber.libjava;

public class wallet__Entry {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected wallet__Entry(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(wallet__Entry obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        skycoinJNI.delete_wallet__Entry(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setAddress(cipher__Address value) {
    skycoinJNI.wallet__Entry_Address_set(swigCPtr, this, cipher__Address.getCPtr(value), value);
  }

  public cipher__Address getAddress() {
    long cPtr = skycoinJNI.wallet__Entry_Address_get(swigCPtr, this);
    return (cPtr == 0) ? null : new cipher__Address(cPtr, false);
  }

  public void setPublic(SWIGTYPE_p_GoUint8_ value) {
    skycoinJNI.wallet__Entry_Public_set(swigCPtr, this, SWIGTYPE_p_GoUint8_.getCPtr(value));
  }

  public SWIGTYPE_p_GoUint8_ getPublic() {
    long cPtr = skycoinJNI.wallet__Entry_Public_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_GoUint8_(cPtr, false);
  }

  public void setSecret(SWIGTYPE_p_GoUint8_ value) {
    skycoinJNI.wallet__Entry_Secret_set(swigCPtr, this, SWIGTYPE_p_GoUint8_.getCPtr(value));
  }

  public SWIGTYPE_p_GoUint8_ getSecret() {
    long cPtr = skycoinJNI.wallet__Entry_Secret_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_GoUint8_(cPtr, false);
  }

  public wallet__Entry() {
    this(skycoinJNI.new_wallet__Entry(), true);
  }

}

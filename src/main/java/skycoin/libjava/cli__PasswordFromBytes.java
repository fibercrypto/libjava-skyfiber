/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package skyfiber.libjava;

public class cli__PasswordFromBytes {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected cli__PasswordFromBytes(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(cli__PasswordFromBytes obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        skycoinJNI.delete_cli__PasswordFromBytes(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setData(SWIGTYPE_p_void value) {
    skycoinJNI.cli__PasswordFromBytes_data_set(swigCPtr, this, SWIGTYPE_p_void.getCPtr(value));
  }

  public SWIGTYPE_p_void getData() {
    long cPtr = skycoinJNI.cli__PasswordFromBytes_data_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_void(cPtr, false);
  }

  public void setLen(long value) {
    skycoinJNI.cli__PasswordFromBytes_len_set(swigCPtr, this, value);
  }

  public long getLen() {
    return skycoinJNI.cli__PasswordFromBytes_len_get(swigCPtr, this);
  }

  public void setCap(long value) {
    skycoinJNI.cli__PasswordFromBytes_cap_set(swigCPtr, this, value);
  }

  public long getCap() {
    return skycoinJNI.cli__PasswordFromBytes_cap_get(swigCPtr, this);
  }

  public cli__PasswordFromBytes() {
    this(skycoinJNI.new_cli__PasswordFromBytes(), true);
  }

}

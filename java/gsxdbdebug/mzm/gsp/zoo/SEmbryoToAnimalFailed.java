/*    */ package mzm.gsp.zoo;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SEmbryoToAnimalFailed
/*    */   extends __SEmbryoToAnimalFailed__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12615430;
/*    */   public static final int ERROR_DAY_NOT_ENOUGH = -1;
/*    */   public int retcode;
/*    */   public long animalid;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12615430;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SEmbryoToAnimalFailed() {}
/*    */   
/*    */ 
/*    */ 
/*    */   public SEmbryoToAnimalFailed(int _retcode_, long _animalid_)
/*    */   {
/* 39 */     this.retcode = _retcode_;
/* 40 */     this.animalid = _animalid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.retcode);
/* 49 */     _os_.marshal(this.animalid);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.retcode = _os_.unmarshal_int();
/* 55 */     this.animalid = _os_.unmarshal_long();
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof SEmbryoToAnimalFailed)) {
/* 65 */       SEmbryoToAnimalFailed _o_ = (SEmbryoToAnimalFailed)_o1_;
/* 66 */       if (this.retcode != _o_.retcode) return false;
/* 67 */       if (this.animalid != _o_.animalid) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += this.retcode;
/* 76 */     _h_ += (int)this.animalid;
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.retcode).append(",");
/* 84 */     _sb_.append(this.animalid).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SEmbryoToAnimalFailed _o_) {
/* 90 */     if (_o_ == this) return 0;
/* 91 */     int _c_ = 0;
/* 92 */     _c_ = this.retcode - _o_.retcode;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     _c_ = Long.signum(this.animalid - _o_.animalid);
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\zoo\SEmbryoToAnimalFailed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
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
/*    */ public class SGetAwardFailed
/*    */   extends __SGetAwardFailed__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12615443;
/*    */   public static final int ERROR_AWARD_NOT_EXIST = -1;
/*    */   public static final int ERROR_BAG_FULL = -2;
/*    */   public int retcode;
/*    */   public long animalid;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12615443;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SGetAwardFailed() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SGetAwardFailed(int _retcode_, long _animalid_)
/*    */   {
/* 40 */     this.retcode = _retcode_;
/* 41 */     this.animalid = _animalid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.retcode);
/* 50 */     _os_.marshal(this.animalid);
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 55 */     this.retcode = _os_.unmarshal_int();
/* 56 */     this.animalid = _os_.unmarshal_long();
/* 57 */     if (!_validator_()) {
/* 58 */       throw new VerifyError("validator failed");
/*    */     }
/* 60 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 64 */     if (_o1_ == this) return true;
/* 65 */     if ((_o1_ instanceof SGetAwardFailed)) {
/* 66 */       SGetAwardFailed _o_ = (SGetAwardFailed)_o1_;
/* 67 */       if (this.retcode != _o_.retcode) return false;
/* 68 */       if (this.animalid != _o_.animalid) return false;
/* 69 */       return true;
/*    */     }
/* 71 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 75 */     int _h_ = 0;
/* 76 */     _h_ += this.retcode;
/* 77 */     _h_ += (int)this.animalid;
/* 78 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 82 */     StringBuilder _sb_ = new StringBuilder();
/* 83 */     _sb_.append("(");
/* 84 */     _sb_.append(this.retcode).append(",");
/* 85 */     _sb_.append(this.animalid).append(",");
/* 86 */     _sb_.append(")");
/* 87 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SGetAwardFailed _o_) {
/* 91 */     if (_o_ == this) return 0;
/* 92 */     int _c_ = 0;
/* 93 */     _c_ = this.retcode - _o_.retcode;
/* 94 */     if (0 != _c_) return _c_;
/* 95 */     _c_ = Long.signum(this.animalid - _o_.animalid);
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\zoo\SGetAwardFailed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
/*    */ package mzm.gsp.petarena;
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
/*    */ public class SViewFightFailed
/*    */   extends __SViewFightFailed__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12628248;
/*    */   public static final int ERROR_NOT_FOUND = -1;
/*    */   public static final int ERROR_ACTIVITY_JOIN = -2;
/*    */   public static final int ERROR_IN_TEAM = -3;
/*    */   public long recordid;
/*    */   public int retcode;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12628248;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SViewFightFailed() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SViewFightFailed(long _recordid_, int _retcode_)
/*    */   {
/* 41 */     this.recordid = _recordid_;
/* 42 */     this.retcode = _retcode_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.recordid);
/* 51 */     _os_.marshal(this.retcode);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.recordid = _os_.unmarshal_long();
/* 57 */     this.retcode = _os_.unmarshal_int();
/* 58 */     if (!_validator_()) {
/* 59 */       throw new VerifyError("validator failed");
/*    */     }
/* 61 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 65 */     if (_o1_ == this) return true;
/* 66 */     if ((_o1_ instanceof SViewFightFailed)) {
/* 67 */       SViewFightFailed _o_ = (SViewFightFailed)_o1_;
/* 68 */       if (this.recordid != _o_.recordid) return false;
/* 69 */       if (this.retcode != _o_.retcode) return false;
/* 70 */       return true;
/*    */     }
/* 72 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 76 */     int _h_ = 0;
/* 77 */     _h_ += (int)this.recordid;
/* 78 */     _h_ += this.retcode;
/* 79 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 83 */     StringBuilder _sb_ = new StringBuilder();
/* 84 */     _sb_.append("(");
/* 85 */     _sb_.append(this.recordid).append(",");
/* 86 */     _sb_.append(this.retcode).append(",");
/* 87 */     _sb_.append(")");
/* 88 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SViewFightFailed _o_) {
/* 92 */     if (_o_ == this) return 0;
/* 93 */     int _c_ = 0;
/* 94 */     _c_ = Long.signum(this.recordid - _o_.recordid);
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     _c_ = this.retcode - _o_.retcode;
/* 97 */     if (0 != _c_) return _c_;
/* 98 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petarena\SViewFightFailed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
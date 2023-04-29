/*    */ package mzm.gsp.watchmoon;
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
/*    */ public class SInviteWatchmoonFailedRes
/*    */   extends __SInviteWatchmoonFailedRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12600849;
/*    */   public int rescode;
/*    */   public long errorroleid;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12600849;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SInviteWatchmoonFailedRes() {}
/*    */   
/*    */ 
/*    */   public SInviteWatchmoonFailedRes(int _rescode_, long _errorroleid_)
/*    */   {
/* 35 */     this.rescode = _rescode_;
/* 36 */     this.errorroleid = _errorroleid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 40 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 44 */     _os_.marshal(this.rescode);
/* 45 */     _os_.marshal(this.errorroleid);
/* 46 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 50 */     this.rescode = _os_.unmarshal_int();
/* 51 */     this.errorroleid = _os_.unmarshal_long();
/* 52 */     if (!_validator_()) {
/* 53 */       throw new VerifyError("validator failed");
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 59 */     if (_o1_ == this) return true;
/* 60 */     if ((_o1_ instanceof SInviteWatchmoonFailedRes)) {
/* 61 */       SInviteWatchmoonFailedRes _o_ = (SInviteWatchmoonFailedRes)_o1_;
/* 62 */       if (this.rescode != _o_.rescode) return false;
/* 63 */       if (this.errorroleid != _o_.errorroleid) return false;
/* 64 */       return true;
/*    */     }
/* 66 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 70 */     int _h_ = 0;
/* 71 */     _h_ += this.rescode;
/* 72 */     _h_ += (int)this.errorroleid;
/* 73 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 77 */     StringBuilder _sb_ = new StringBuilder();
/* 78 */     _sb_.append("(");
/* 79 */     _sb_.append(this.rescode).append(",");
/* 80 */     _sb_.append(this.errorroleid).append(",");
/* 81 */     _sb_.append(")");
/* 82 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SInviteWatchmoonFailedRes _o_) {
/* 86 */     if (_o_ == this) return 0;
/* 87 */     int _c_ = 0;
/* 88 */     _c_ = this.rescode - _o_.rescode;
/* 89 */     if (0 != _c_) return _c_;
/* 90 */     _c_ = Long.signum(this.errorroleid - _o_.errorroleid);
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\watchmoon\SInviteWatchmoonFailedRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
/*    */ package mzm.gsp.award;
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
/*    */ 
/*    */ public class SSyncOfflineExpReward
/*    */   extends __SSyncOfflineExpReward__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12583428;
/*    */   public int offlineminute;
/*    */   public int rewardexp;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12583428;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SSyncOfflineExpReward() {}
/*    */   
/*    */ 
/*    */   public SSyncOfflineExpReward(int _offlineminute_, int _rewardexp_)
/*    */   {
/* 37 */     this.offlineminute = _offlineminute_;
/* 38 */     this.rewardexp = _rewardexp_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.offlineminute);
/* 47 */     _os_.marshal(this.rewardexp);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.offlineminute = _os_.unmarshal_int();
/* 53 */     this.rewardexp = _os_.unmarshal_int();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SSyncOfflineExpReward)) {
/* 63 */       SSyncOfflineExpReward _o_ = (SSyncOfflineExpReward)_o1_;
/* 64 */       if (this.offlineminute != _o_.offlineminute) return false;
/* 65 */       if (this.rewardexp != _o_.rewardexp) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.offlineminute;
/* 74 */     _h_ += this.rewardexp;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.offlineminute).append(",");
/* 82 */     _sb_.append(this.rewardexp).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SSyncOfflineExpReward _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = this.offlineminute - _o_.offlineminute;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = this.rewardexp - _o_.rewardexp;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\SSyncOfflineExpReward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
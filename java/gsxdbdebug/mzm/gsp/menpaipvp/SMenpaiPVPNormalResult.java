/*    */ package mzm.gsp.menpaipvp;
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
/*    */ public class SMenpaiPVPNormalResult
/*    */   extends __SMenpaiPVPNormalResult__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12596226;
/*    */   public static final int ENTER_MENPAI_MAP__MAX_LOSE_TIMES = 1;
/*    */   public static final int ENTER_MENPAI_MAP__PARTICPATED = 2;
/*    */   public int result;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12596226;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SMenpaiPVPNormalResult() {}
/*    */   
/*    */ 
/*    */ 
/*    */   public SMenpaiPVPNormalResult(int _result_)
/*    */   {
/* 37 */     this.result = _result_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 45 */     _os_.marshal(this.result);
/* 46 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 50 */     this.result = _os_.unmarshal_int();
/* 51 */     if (!_validator_()) {
/* 52 */       throw new VerifyError("validator failed");
/*    */     }
/* 54 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 58 */     if (_o1_ == this) return true;
/* 59 */     if ((_o1_ instanceof SMenpaiPVPNormalResult)) {
/* 60 */       SMenpaiPVPNormalResult _o_ = (SMenpaiPVPNormalResult)_o1_;
/* 61 */       if (this.result != _o_.result) return false;
/* 62 */       return true;
/*    */     }
/* 64 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 68 */     int _h_ = 0;
/* 69 */     _h_ += this.result;
/* 70 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 74 */     StringBuilder _sb_ = new StringBuilder();
/* 75 */     _sb_.append("(");
/* 76 */     _sb_.append(this.result).append(",");
/* 77 */     _sb_.append(")");
/* 78 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SMenpaiPVPNormalResult _o_) {
/* 82 */     if (_o_ == this) return 0;
/* 83 */     int _c_ = 0;
/* 84 */     _c_ = this.result - _o_.result;
/* 85 */     if (0 != _c_) return _c_;
/* 86 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaipvp\SMenpaiPVPNormalResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
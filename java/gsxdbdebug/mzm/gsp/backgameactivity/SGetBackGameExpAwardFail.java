/*    */ package mzm.gsp.backgameactivity;
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
/*    */ public class SGetBackGameExpAwardFail
/*    */   extends __SGetBackGameExpAwardFail__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12620557;
/*    */   public static final int NOT_IN_BACK_GAME_ACTIVITY = -1;
/*    */   public static final int LOGIN_DAY_NOT_ENOUGH = -2;
/*    */   public static final int AWARD_ALREADY_GET = -3;
/*    */   public static final int AWARD_CFG_NOT_EXIST = -4;
/*    */   public static final int OFFER_AWARD_FAIL = -5;
/*    */   public int error_code;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12620557;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SGetBackGameExpAwardFail() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SGetBackGameExpAwardFail(int _error_code_)
/*    */   {
/* 42 */     this.error_code = _error_code_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.error_code);
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 55 */     this.error_code = _os_.unmarshal_int();
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof SGetBackGameExpAwardFail)) {
/* 65 */       SGetBackGameExpAwardFail _o_ = (SGetBackGameExpAwardFail)_o1_;
/* 66 */       if (this.error_code != _o_.error_code) return false;
/* 67 */       return true;
/*    */     }
/* 69 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 73 */     int _h_ = 0;
/* 74 */     _h_ += this.error_code;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.error_code).append(",");
/* 82 */     _sb_.append(")");
/* 83 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SGetBackGameExpAwardFail _o_) {
/* 87 */     if (_o_ == this) return 0;
/* 88 */     int _c_ = 0;
/* 89 */     _c_ = this.error_code - _o_.error_code;
/* 90 */     if (0 != _c_) return _c_;
/* 91 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\backgameactivity\SGetBackGameExpAwardFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
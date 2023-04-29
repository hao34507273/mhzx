/*    */ package mzm.gsp.luckystar;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class SLuckyStarNormalFail extends __SLuckyStarNormalFail__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12608514;
/*    */   public static final int ACTIVITY_CAN_NOT_JOIN = 1;
/*    */   public static final int ACTIVITY_CFG_NOT_EXIST = 2;
/*    */   public static final int ROLE_ACTIVITY_INFO_NULL = 3;
/*    */   public static final int ROLE_ACTIVITY_INFO_NOT_EXIST = 4;
/*    */   public static final int ROLE_GIFT_INFO_NOT_EXIST = 5;
/*    */   public static final int GIFT_CFG_NOT_EXIST = 6;
/*    */   public static final int BUY_TIMES_NOT_ENOUGH = 7;
/*    */   public static final int CURRENCY_NOT_ENOUGH = 8;
/*    */   public static final int CUT_CURRENCY_ERROR = 9;
/*    */   public static final int AWARDED_FAIL = 10;
/*    */   public static final int ACTIVE_NOT_ENOUGH = 11;
/*    */   public static final int LUCKY_STAR_FUNCTION_NOT_OPEN = 12;
/*    */   public static final int BUY_TIMES_NOT_VALID = 13;
/*    */   public int result;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12608514;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SLuckyStarNormalFail() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SLuckyStarNormalFail(int _result_)
/*    */   {
/* 50 */     this.result = _result_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 54 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 58 */     _os_.marshal(this.result);
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 63 */     this.result = _os_.unmarshal_int();
/* 64 */     if (!_validator_()) {
/* 65 */       throw new VerifyError("validator failed");
/*    */     }
/* 67 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 71 */     if (_o1_ == this) return true;
/* 72 */     if ((_o1_ instanceof SLuckyStarNormalFail)) {
/* 73 */       SLuckyStarNormalFail _o_ = (SLuckyStarNormalFail)_o1_;
/* 74 */       if (this.result != _o_.result) return false;
/* 75 */       return true;
/*    */     }
/* 77 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 81 */     int _h_ = 0;
/* 82 */     _h_ += this.result;
/* 83 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 87 */     StringBuilder _sb_ = new StringBuilder();
/* 88 */     _sb_.append("(");
/* 89 */     _sb_.append(this.result).append(",");
/* 90 */     _sb_.append(")");
/* 91 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SLuckyStarNormalFail _o_) {
/* 95 */     if (_o_ == this) return 0;
/* 96 */     int _c_ = 0;
/* 97 */     _c_ = this.result - _o_.result;
/* 98 */     if (0 != _c_) return _c_;
/* 99 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\luckystar\SLuckyStarNormalFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
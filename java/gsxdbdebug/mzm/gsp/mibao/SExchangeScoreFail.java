/*    */ package mzm.gsp.mibao;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ public class SExchangeScoreFail
/*    */   extends __SExchangeScoreFail__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12603404;
/*    */   public static final int ACTIVITY_CAN_NOT_JOIN = 1;
/*    */   public static final int EXCHANGE_TIMES_NOT_VALID = 2;
/*    */   public static final int EXCHANGE_CHANGE_NOT_VALID = 3;
/*    */   public static final int ACTIVITY_END_TIME_OUT = 4;
/*    */   public static final int CAN_NOT_DO_THIS = 5;
/*    */   public static final int BAO_KU_INFO_NULL = 6;
/*    */   public static final int EXCHANGE_CFG_NOT_EXIST = 7;
/*    */   public static final int EXCHANGE_TOO_FAST = 8;
/*    */   public static final int EXCHANGE_SCORE_NOT_ENOUGH = 9;
/*    */   public static final int AWARD_FAIL = 10;
/*    */   public int result;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12603404;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SExchangeScoreFail() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SExchangeScoreFail(int _result_)
/*    */   {
/* 47 */     this.result = _result_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 51 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 55 */     _os_.marshal(this.result);
/* 56 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 60 */     this.result = _os_.unmarshal_int();
/* 61 */     if (!_validator_()) {
/* 62 */       throw new VerifyError("validator failed");
/*    */     }
/* 64 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 68 */     if (_o1_ == this) return true;
/* 69 */     if ((_o1_ instanceof SExchangeScoreFail)) {
/* 70 */       SExchangeScoreFail _o_ = (SExchangeScoreFail)_o1_;
/* 71 */       if (this.result != _o_.result) return false;
/* 72 */       return true;
/*    */     }
/* 74 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 78 */     int _h_ = 0;
/* 79 */     _h_ += this.result;
/* 80 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 84 */     StringBuilder _sb_ = new StringBuilder();
/* 85 */     _sb_.append("(");
/* 86 */     _sb_.append(this.result).append(",");
/* 87 */     _sb_.append(")");
/* 88 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SExchangeScoreFail _o_) {
/* 92 */     if (_o_ == this) return 0;
/* 93 */     int _c_ = 0;
/* 94 */     _c_ = this.result - _o_.result;
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mibao\SExchangeScoreFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
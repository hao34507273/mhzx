/*     */ package mzm.gsp.mibao;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class SBuyMiBaoFail extends __SBuyMiBaoFail__ { public static final int PROTOCOL_TYPE = 12603400;
/*     */   public static final int NO_BUY_TIMES_LEFT = 1;
/*     */   public static final int LAST_AWARD_NOT_FINISH = 2;
/*     */   public static final int BUY_TIME_NOT_ENOUGH = 3;
/*     */   public static final int CURRENCY_NOT_EQUAL = 4;
/*     */   public static final int BUY_INDEX_ERROR = 5;
/*     */   public static final int BAG_FULL = 6;
/*     */   public static final int BUY_TIMES_ERROR = 7;
/*     */   public static final int CURRENCY_NOT_ENOUGH = 8;
/*     */   public static final int COST_CURRENCY_ERROR = 9;
/*     */   public static final int ACTIVITY_CAN_NOT_JOIN = 10;
/*     */   public static final int BAO_KU_INFO_NULL = 11;
/*     */   public static final int ACTIVITY_END_TIME_OUT = 12;
/*     */   public static final int TEN_TIMES_DRAW_TYPE_CFG_WRONG = 13;
/*     */   public static final int GRID_NUM_NOT_ENOUGH = 14;
/*     */   public static final int ITEM_PRICE_LESS_THEN_ZERO = 15;
/*     */   public static final int CLIENT_YUAN_BAO_NOT_SAME_WITH_SERVER = 16;
/*     */   public static final int CUT_YUAN_BAO_ERROR = 17;
/*     */   public int result;
/*     */   
/*     */   protected void process() {}
/*     */   
/*  27 */   public int getType() { return 12603400; }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SBuyMiBaoFail() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SBuyMiBaoFail(int _result_)
/*     */   {
/*  54 */     this.result = _result_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  58 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  62 */     _os_.marshal(this.result);
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  67 */     this.result = _os_.unmarshal_int();
/*  68 */     if (!_validator_()) {
/*  69 */       throw new VerifyError("validator failed");
/*     */     }
/*  71 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  75 */     if (_o1_ == this) return true;
/*  76 */     if ((_o1_ instanceof SBuyMiBaoFail)) {
/*  77 */       SBuyMiBaoFail _o_ = (SBuyMiBaoFail)_o1_;
/*  78 */       if (this.result != _o_.result) return false;
/*  79 */       return true;
/*     */     }
/*  81 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  85 */     int _h_ = 0;
/*  86 */     _h_ += this.result;
/*  87 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  91 */     StringBuilder _sb_ = new StringBuilder();
/*  92 */     _sb_.append("(");
/*  93 */     _sb_.append(this.result).append(",");
/*  94 */     _sb_.append(")");
/*  95 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SBuyMiBaoFail _o_) {
/*  99 */     if (_o_ == this) return 0;
/* 100 */     int _c_ = 0;
/* 101 */     _c_ = this.result - _o_.result;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mibao\SBuyMiBaoFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
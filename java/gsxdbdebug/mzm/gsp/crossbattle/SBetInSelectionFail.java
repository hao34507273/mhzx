/*     */ package mzm.gsp.crossbattle;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SBetInSelectionFail
/*     */   extends __SBetInSelectionFail__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12617041;
/*     */   public static final int MODULE_CLOSE_OR_ROLE_FORBIDDEN = -1;
/*     */   public static final int ROLE_STATUS_ERROR = -2;
/*     */   public static final int PARAM_ERROR = -3;
/*     */   public static final int CHECK_NPC_SERVICE_ERROR = -4;
/*     */   public static final int DB_ERROR = -5;
/*     */   public static final int COMMUNICATION_ERROR = 1;
/*     */   public static final int GET_STAGE_DATA_FAIL = 2;
/*     */   public static final int GET_STAGE_BET_DATA_FAIL = 3;
/*     */   public static final int NOT_IN_BET_TIME = 4;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12617041;
/*     */   }
/*     */   
/*     */ 
/*     */   public static final int FIGHT_END = 5;
/*     */   
/*     */   public static final int NO_FIGHT_CORPS_ID = 6;
/*     */   
/*     */   public static final int CANNOT_BET_ON_OWN_FIGHT = 7;
/*     */   
/*     */   public static final int ALREADY_BET = 8;
/*     */   
/*     */   public static final int MONEY_NOT_ENOUGH = 9;
/*     */   
/*     */   public static final int FIGHT_NOT_EXIST = 10;
/*     */   
/*     */   public static final int LEVEL_NOT_ENOUGH = 11;
/*     */   
/*     */   public static final int ALREADY_HAS_ROUND_RESULT = 12;
/*     */   
/*     */   public static final int DAILY_BET_TIMES_TO_UPPER_LIMIT = 13;
/*     */   
/*     */   public int res;
/*     */   
/*     */   public SBetInSelectionFail() {}
/*     */   
/*     */   public SBetInSelectionFail(int _res_)
/*     */   {
/*  55 */     this.res = _res_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  59 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  63 */     _os_.marshal(this.res);
/*  64 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  68 */     this.res = _os_.unmarshal_int();
/*  69 */     if (!_validator_()) {
/*  70 */       throw new VerifyError("validator failed");
/*     */     }
/*  72 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  76 */     if (_o1_ == this) return true;
/*  77 */     if ((_o1_ instanceof SBetInSelectionFail)) {
/*  78 */       SBetInSelectionFail _o_ = (SBetInSelectionFail)_o1_;
/*  79 */       if (this.res != _o_.res) return false;
/*  80 */       return true;
/*     */     }
/*  82 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  86 */     int _h_ = 0;
/*  87 */     _h_ += this.res;
/*  88 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  92 */     StringBuilder _sb_ = new StringBuilder();
/*  93 */     _sb_.append("(");
/*  94 */     _sb_.append(this.res).append(",");
/*  95 */     _sb_.append(")");
/*  96 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SBetInSelectionFail _o_) {
/* 100 */     if (_o_ == this) return 0;
/* 101 */     int _c_ = 0;
/* 102 */     _c_ = this.res - _o_.res;
/* 103 */     if (0 != _c_) return _c_;
/* 104 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\SBetInSelectionFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
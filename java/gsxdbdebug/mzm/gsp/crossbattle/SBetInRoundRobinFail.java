/*     */ package mzm.gsp.crossbattle;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class SBetInRoundRobinFail extends __SBetInRoundRobinFail__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12617038;
/*     */   public static final int MODULE_CLOSE_OR_ROLE_FORBIDDEN = -1;
/*     */   public static final int ROLE_STATUS_ERROR = -2;
/*     */   public static final int PARAM_ERROR = -3;
/*     */   public static final int CHECK_NPC_SERVICE_ERROR = -4;
/*     */   public static final int ACTIVITY_NOT_OPEN = 1;
/*     */   public static final int ACTIVITY_STAGE_ERROR = 2;
/*     */   public static final int NOT_IN_BET_TIME = 3;
/*     */   public static final int FIGHT_END = 4;
/*     */   public static final int GET_REGISTER_ROLE_LIST_FAIL = 5;
/*     */   public static final int CANNOT_BET_ON_OWN_FIGHT = 6;
/*     */   public static final int ALREADY_BET = 7;
/*     */   public static final int MONEY_NOT_ENOUGH = 8;
/*     */   public static final int FIGHT_NOT_EXIST = 9;
/*     */   public static final int LEVEL_NOT_ENOUGH = 10;
/*     */   public int res;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType() {
/*  27 */     return 12617038;
/*     */   }
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
/*     */   public SBetInRoundRobinFail() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SBetInRoundRobinFail(int _res_)
/*     */   {
/*  51 */     this.res = _res_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  55 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  59 */     _os_.marshal(this.res);
/*  60 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  64 */     this.res = _os_.unmarshal_int();
/*  65 */     if (!_validator_()) {
/*  66 */       throw new VerifyError("validator failed");
/*     */     }
/*  68 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  72 */     if (_o1_ == this) return true;
/*  73 */     if ((_o1_ instanceof SBetInRoundRobinFail)) {
/*  74 */       SBetInRoundRobinFail _o_ = (SBetInRoundRobinFail)_o1_;
/*  75 */       if (this.res != _o_.res) return false;
/*  76 */       return true;
/*     */     }
/*  78 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  82 */     int _h_ = 0;
/*  83 */     _h_ += this.res;
/*  84 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  88 */     StringBuilder _sb_ = new StringBuilder();
/*  89 */     _sb_.append("(");
/*  90 */     _sb_.append(this.res).append(",");
/*  91 */     _sb_.append(")");
/*  92 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SBetInRoundRobinFail _o_) {
/*  96 */     if (_o_ == this) return 0;
/*  97 */     int _c_ = 0;
/*  98 */     _c_ = this.res - _o_.res;
/*  99 */     if (0 != _c_) return _c_;
/* 100 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\SBetInRoundRobinFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
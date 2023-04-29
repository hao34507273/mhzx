/*     */ package mzm.gsp.treasurehunt;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class STreasureHuntNormalFail extends __STreasureHuntNormalFail__ { public static final int PROTOCOL_TYPE = 12633090;
/*     */   public static final int ERROR_ACTIVITY_CFG_NOT_EXIST = 1;
/*     */   public static final int ERROR_USER_INFO_NOT_EXIST = 2;
/*     */   public static final int ERROR_ACTIVITY_CAN_NOT_TAKE_IN = 3;
/*     */   public static final int ERROR_IN_OLD_TREASURE_WORLD = 4;
/*     */   public static final int ERROR_TREASURE_ALEARDY_PASS = 5;
/*     */   public static final int ERROR_TREASURE_CHAPTER_NOT_EXIST = 6;
/*     */   public static final int ERROR_CURRENT_CHAPTER_NOT_EXIST = 7;
/*     */   public static final int ERROR_ROLE_TREASURE_DATA_NOT_EXIST = 8;
/*     */   public static final int ERROR_SESSION_NOT_EXIST = 9;
/*     */   public static final int ERROR_STATUS_CAN_NOT_TACK_PART = 10;
/*     */   public static final int ERROR_SET_STATUS = 11;
/*     */   public static final int ERROR_TREASURE_HUNT_FAIL = 12;
/*     */   public static final int ERROR_FUNCTION_NOT_OPEN = 13;
/*     */   public static final int ERROR_TODAY_ACTIVITY_COUNT_MAX = 14;
/*     */   public static final int ERROR_NPC_SERVICE_NOT_VALID = 15;
/*     */   public static final int ERROR_TREASURE_HUNT_CAN_NOT_JOIN = 16;
/*     */   public static final int ERROR_IN_TREASURE_HUNT_CAN_NOT_JOIN = 17;
/*     */   public int result;
/*     */   
/*     */   protected void process() {}
/*     */   
/*  27 */   public int getType() { return 12633090; }
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
/*     */   public STreasureHuntNormalFail() {}
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
/*     */   public STreasureHuntNormalFail(int _result_)
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
/*  76 */     if ((_o1_ instanceof STreasureHuntNormalFail)) {
/*  77 */       STreasureHuntNormalFail _o_ = (STreasureHuntNormalFail)_o1_;
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
/*     */   public int compareTo(STreasureHuntNormalFail _o_) {
/*  99 */     if (_o_ == this) return 0;
/* 100 */     int _c_ = 0;
/* 101 */     _c_ = this.result - _o_.result;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\treasurehunt\STreasureHuntNormalFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
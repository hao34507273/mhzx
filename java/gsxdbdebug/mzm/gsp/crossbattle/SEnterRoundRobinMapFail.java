/*     */ package mzm.gsp.crossbattle;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class SEnterRoundRobinMapFail extends __SEnterRoundRobinMapFail__ { public static final int PROTOCOL_TYPE = 12616980;
/*     */   public static final int MODULE_CLOSE_OR_ROLE_FORBIDDEN = -1;
/*     */   public static final int ROLE_STATUS_ERROR = -2;
/*     */   public static final int PARAM_ERROR = -3;
/*     */   public static final int CHECK_NPC_SERVICE_ERROR = -4;
/*     */   public static final int DB_ERROR = -5;
/*     */   public static final int WORLD_ERROR = -6;
/*     */   public static final int ACTIVITY_NOT_OPEN = 1;
/*     */   public static final int ACTIVITY_STAGE_ERROR = 2;
/*     */   public static final int NOT_IN_TEAM = 3;
/*     */   public static final int TEAM_STATE_CHANGED = 4;
/*     */   public static final int ROLE_ID_NOT_TEAM_LEADER = 5;
/*     */   public static final int TEAM_MEMBER_NOT_ENOUGH = 6;
/*     */   public static final int NOT_IN_CORPS = 7;
/*     */   public static final int NOT_ALL_TEAM_MEMBER_IN_SAME_CORPS = 8;
/*     */   public static final int CAN_NOT_ATTEND_THIS_ROUND = 9;
/*     */   public static final int NOT_ALL_TEAM_MEMBER_REGISTER = 10;
/*     */   public static final int NOT_ALL_TEAM_MEMBER_NORMAL = 11;
/*     */   public int res;
/*     */   
/*     */   protected void process() {}
/*     */   
/*  27 */   public int getType() { return 12616980; }
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
/*     */   public SEnterRoundRobinMapFail() {}
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
/*     */   public SEnterRoundRobinMapFail(int _res_)
/*     */   {
/*  54 */     this.res = _res_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  58 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  62 */     _os_.marshal(this.res);
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  67 */     this.res = _os_.unmarshal_int();
/*  68 */     if (!_validator_()) {
/*  69 */       throw new VerifyError("validator failed");
/*     */     }
/*  71 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  75 */     if (_o1_ == this) return true;
/*  76 */     if ((_o1_ instanceof SEnterRoundRobinMapFail)) {
/*  77 */       SEnterRoundRobinMapFail _o_ = (SEnterRoundRobinMapFail)_o1_;
/*  78 */       if (this.res != _o_.res) return false;
/*  79 */       return true;
/*     */     }
/*  81 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  85 */     int _h_ = 0;
/*  86 */     _h_ += this.res;
/*  87 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  91 */     StringBuilder _sb_ = new StringBuilder();
/*  92 */     _sb_.append("(");
/*  93 */     _sb_.append(this.res).append(",");
/*  94 */     _sb_.append(")");
/*  95 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SEnterRoundRobinMapFail _o_) {
/*  99 */     if (_o_ == this) return 0;
/* 100 */     int _c_ = 0;
/* 101 */     _c_ = this.res - _o_.res;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\SEnterRoundRobinMapFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
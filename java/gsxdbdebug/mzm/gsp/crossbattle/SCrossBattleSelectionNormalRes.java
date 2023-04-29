/*     */ package mzm.gsp.crossbattle;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class SCrossBattleSelectionNormalRes extends __SCrossBattleSelectionNormalRes__ { public static final int PROTOCOL_TYPE = 12616994;
/*     */   public static final int PREPARE_ENTER_TIME_EXPIRED = 1;
/*     */   public static final int PREPARE_ENTER_MAP_NOT_JOIN_TEAM = 2;
/*     */   public static final int MATCH_FAIL = 3;
/*     */   public static final int SELECTION_ACTIVITY_DATA_NOT_FOUND = 4;
/*     */   public static final int SELECTION_FIGHT_ZONE_DATA_NOT_FOUND = 5;
/*     */   public static final int SELECTION_FIGHT_STAGE_DATA_NOT_FOUND = 6;
/*     */   public static final int SELECTION_FIGHT_CORPS_INFO_GET_ERROR = 7;
/*     */   public static final int SELECTION_FIGHT_GEN_TOKEN_ERROR = 8;
/*     */   public static final int SELECTION_FIGHT_ROAM_ROLE_DATA_ERROR = 9;
/*     */   public static final int SELECTION_FIGHT_INFO_GET_ERROR = 10;
/*     */   public static final int USER_ID_NOT_FOUND = 11;
/*     */   public static final int ACTIVITY_CFG_NOT_FOUND = 12;
/*     */   public static final int TEAM_NUMBER_NOT_VALID = 13;
/*     */   public static final int TEAM_NEED = 14;
/*     */   public static final int TEAM_MEMBER_NOT_SAME_WITH_SIGN_UP = 15;
/*     */   public static final int WORLD_NOT_EXIST = 16;
/*     */   public static final int INTO_WORLD_END_TIME_NOT_EXIST = 17;
/*     */   public static final int NOT_IN_CORPS = 18;
/*     */   
/*     */   protected void process() {}
/*     */   
/*  27 */   public int getType() { return 12616994; }
/*     */   
/*     */ 
/*     */   public static final int NOT_IN_FIGHT_ZONE = 19;
/*     */   
/*     */   public static final int ROAMED_USER_ID_NOT_FOUND = 20;
/*     */   
/*     */   public static final int ROAMED_CONTEXT_NOT_FOUND = 21;
/*     */   
/*     */   public static final int OWN_SERVER_LOGIN_NOT_FOUND_OPPONENT = 22;
/*     */   
/*     */   public static final int CAL_SELECTION_STAGE_FAIL = 23;
/*     */   
/*     */   public static final int QUERY_SIGN_UP_ROLE_LIST_FAIL = 24;
/*     */   
/*     */   public static final int SELECTION_FUNCTION_NOT_OPEN = 25;
/*     */   
/*     */   public static final int FIGHT_ZONE_ID_NOT_VALID = 26;
/*     */   
/*     */   public static final int KNOCK_OUT_CFG_NOT_FOUND = 27;
/*     */   
/*     */   public static final int KNOCK_OUT_HANDLER_NOT_FOUND = 28;
/*     */   
/*     */   public static final int CAL_FIGHT_TIMES_ERROR = 29;
/*     */   
/*     */   public static final int ALEARDY_RANK_UP = 30;
/*     */   
/*     */   public static final int ALEARDY_KNOCK_OUT = 31;
/*     */   
/*     */   public static final int ROLE_STATUS_ERROR = 32;
/*     */   
/*     */   public static final int GET_CORPS_INFO_ERROR = 33;
/*     */   
/*     */   public static final int TEAM_MEMBER_CAN_NOT_CLICK = 34;
/*     */   
/*     */   public static final int TEAM_CAN_NOT_INTO_GAME = 35;
/*     */   
/*     */   public static final int KNOCK_OUT_DATA_NOT_FOUND = 36;
/*     */   
/*     */   public int ret;
/*     */   
/*     */   public SCrossBattleSelectionNormalRes() {}
/*     */   
/*     */ 
/*     */   public SCrossBattleSelectionNormalRes(int _ret_)
/*     */   {
/*  73 */     this.ret = _ret_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  77 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  81 */     _os_.marshal(this.ret);
/*  82 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  86 */     this.ret = _os_.unmarshal_int();
/*  87 */     if (!_validator_()) {
/*  88 */       throw new VerifyError("validator failed");
/*     */     }
/*  90 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  94 */     if (_o1_ == this) return true;
/*  95 */     if ((_o1_ instanceof SCrossBattleSelectionNormalRes)) {
/*  96 */       SCrossBattleSelectionNormalRes _o_ = (SCrossBattleSelectionNormalRes)_o1_;
/*  97 */       if (this.ret != _o_.ret) return false;
/*  98 */       return true;
/*     */     }
/* 100 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 104 */     int _h_ = 0;
/* 105 */     _h_ += this.ret;
/* 106 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 110 */     StringBuilder _sb_ = new StringBuilder();
/* 111 */     _sb_.append("(");
/* 112 */     _sb_.append(this.ret).append(",");
/* 113 */     _sb_.append(")");
/* 114 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SCrossBattleSelectionNormalRes _o_) {
/* 118 */     if (_o_ == this) return 0;
/* 119 */     int _c_ = 0;
/* 120 */     _c_ = this.ret - _o_.ret;
/* 121 */     if (0 != _c_) return _c_;
/* 122 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\SCrossBattleSelectionNormalRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
/*     */ package mzm.gsp.crossbattle;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class SCrossBattleFinalNormalRes extends __SCrossBattleFinalNormalRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12617058;
/*     */   public static final int PREPARE_ENTER_TIME_EXPIRED = 1;
/*     */   public static final int PREPARE_ENTER_MAP_NOT_JOIN_TEAM = 2;
/*     */   public static final int MATCH_FAIL = 3;
/*     */   public static final int Final_ACTIVITY_DATA_NOT_FOUND = 4;
/*     */   public static final int Final_FIGHT_ZONE_DATA_NOT_FOUND = 5;
/*     */   public static final int Final_FIGHT_STAGE_DATA_NOT_FOUND = 6;
/*     */   public static final int Final_FIGHT_CORPS_INFO_GET_ERROR = 7;
/*     */   public static final int Final_FIGHT_GEN_TOKEN_ERROR = 8;
/*     */   public static final int Final_FIGHT_ROAM_ROLE_DATA_ERROR = 9;
/*     */   public static final int Final_FIGHT_INFO_GET_ERROR = 10;
/*     */   public static final int USER_ID_NOT_FOUND = 11;
/*     */   public static final int ACTIVITY_CFG_NOT_FOUND = 12;
/*     */   public static final int TEAM_NUMBER_NOT_VALID = 13;
/*     */   public static final int TEAM_NEED = 14;
/*     */   public static final int TEAM_MEMBER_NOT_SAME_WITH_SIGN_UP = 15;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType() {
/*  27 */     return 12617058;
/*     */   }
/*     */   
/*     */ 
/*     */   public static final int WORLD_NOT_EXIST = 16;
/*     */   
/*     */   public static final int INTO_WORLD_END_TIME_NOT_EXIST = 17;
/*     */   
/*     */   public static final int NOT_IN_CORPS = 18;
/*     */   
/*     */   public static final int NOT_IN_FIGHT_ZONE = 19;
/*     */   
/*     */   public static final int ROAMED_USER_ID_NOT_FOUND = 20;
/*     */   
/*     */   public static final int ROAMED_CONTEXT_NOT_FOUND = 21;
/*     */   
/*     */   public static final int OWN_SERVER_LOGIN_NOT_FOUND_OPPONENT = 22;
/*     */   
/*     */   public static final int CAL_Final_STAGE_FAIL = 23;
/*     */   
/*     */   public static final int QUERY_SIGN_UP_ROLE_LIST_FAIL = 24;
/*     */   
/*     */   public static final int Final_FUNCTION_NOT_OPEN = 25;
/*     */   
/*     */   public static final int FIGHT_ZONE_ID_NOT_VALID = 26;
/*     */   
/*     */   public static final int ALEARDY_RANK_UP = 30;
/*     */   
/*     */   public static final int ALEARDY_KNOCK_OUT = 31;
/*     */   
/*     */   public static final int TEAM_MEMBER_CAN_NOT_CLICK = 34;
/*     */   
/*     */   public static final int TEAM_CAN_NOT_INTO_GAME = 35;
/*     */   
/*     */   public static final int KNOCK_OUT_DATA_NOT_FOUND = 36;
/*     */   
/*     */   public int ret;
/*     */   public SCrossBattleFinalNormalRes() {}
/*     */   
/*     */   public SCrossBattleFinalNormalRes(int _ret_)
/*     */   {
/*  68 */     this.ret = _ret_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  72 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  76 */     _os_.marshal(this.ret);
/*  77 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  81 */     this.ret = _os_.unmarshal_int();
/*  82 */     if (!_validator_()) {
/*  83 */       throw new VerifyError("validator failed");
/*     */     }
/*  85 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  89 */     if (_o1_ == this) return true;
/*  90 */     if ((_o1_ instanceof SCrossBattleFinalNormalRes)) {
/*  91 */       SCrossBattleFinalNormalRes _o_ = (SCrossBattleFinalNormalRes)_o1_;
/*  92 */       if (this.ret != _o_.ret) return false;
/*  93 */       return true;
/*     */     }
/*  95 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  99 */     int _h_ = 0;
/* 100 */     _h_ += this.ret;
/* 101 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 105 */     StringBuilder _sb_ = new StringBuilder();
/* 106 */     _sb_.append("(");
/* 107 */     _sb_.append(this.ret).append(",");
/* 108 */     _sb_.append(")");
/* 109 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SCrossBattleFinalNormalRes _o_) {
/* 113 */     if (_o_ == this) return 0;
/* 114 */     int _c_ = 0;
/* 115 */     _c_ = this.ret - _o_.ret;
/* 116 */     if (0 != _c_) return _c_;
/* 117 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\SCrossBattleFinalNormalRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
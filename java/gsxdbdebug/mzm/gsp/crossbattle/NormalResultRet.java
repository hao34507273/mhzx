/*    */ package mzm.gsp.crossbattle;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class NormalResultRet
/*    */   implements Marshal, Comparable<NormalResultRet>
/*    */ {
/*    */   public static final int PREPARE_ENTER_TIME_EXPIRED = 1;
/*    */   public static final int PREPARE_ENTER_MAP_NOT_JOIN_TEAM = 2;
/*    */   public static final int MATCH_FAIL = 3;
/*    */   public static final int KNOCK_OUT_ACTIVITY_DATA_NOT_FOUND = 4;
/*    */   public static final int KNOCK_OUT_FIGHT_ZONE_DATA_NOT_FOUND = 5;
/*    */   public static final int KNOCK_OUT_FIGHT_STAGE_DATA_NOT_FOUND = 6;
/*    */   public static final int KNOCK_OUT_FIGHT_CORPS_INFO_GET_ERROR = 7;
/*    */   public static final int KNOCK_OUT_FIGHT_GEN_TOKEN_ERROR = 8;
/*    */   public static final int KNOCK_OUT_FIGHT_ROAM_ROLE_DATA_ERROR = 9;
/*    */   public static final int KNOCK_OUT_FIGHT_INFO_GET_ERROR = 10;
/*    */   public static final int USER_ID_NOT_FOUND = 11;
/*    */   public static final int ACTIVITY_CFG_NOT_FOUND = 12;
/*    */   public static final int TEAM_NUMBER_NOT_VALID = 13;
/*    */   public static final int TEAM_NEED = 14;
/*    */   public static final int TEAM_MEMBER_NOT_SAME_WITH_SIGN_UP = 15;
/*    */   public static final int WORLD_NOT_EXIST = 16;
/*    */   public static final int INTO_WORLD_END_TIME_NOT_EXIST = 17;
/*    */   public static final int NOT_IN_CORPS = 18;
/*    */   public static final int NOT_IN_FIGHT_ZONE = 19;
/*    */   public static final int ROAMED_USER_ID_NOT_FOUND = 20;
/*    */   public static final int ROAMED_CONTEXT_NOT_FOUND = 21;
/*    */   public static final int OWN_SERVER_LOGIN_NOT_FOUND_OPPONENT = 22;
/*    */   public static final int CAL_KNOCK_OUT_STAGE_FAIL = 23;
/*    */   public static final int QUERY_SIGN_UP_ROLE_LIST_FAIL = 24;
/*    */   public static final int KNOCK_OUT_FUNCTION_NOT_OPEN = 25;
/*    */   public static final int FIGHT_ZONE_ID_NOT_VALID = 26;
/*    */   public static final int KNOCK_OUT_CFG_NOT_FOUND = 27;
/*    */   public static final int KNOCK_OUT_HANDLER_NOT_FOUND = 28;
/*    */   public static final int CAL_FIGHT_TIMES_ERROR = 29;
/*    */   public static final int ALEARDY_RANK_UP = 30;
/*    */   public static final int ALEARDY_KNOCK_OUT = 31;
/*    */   public static final int ROLE_STATUS_ERROR = 32;
/*    */   public static final int TEAM_MEMBER_CAN_NOT_CLICK = 34;
/*    */   public static final int TEAM_CAN_NOT_INTO_GAME = 35;
/*    */   public static final int KNOCK_OUT_DATA_NOT_FOUND = 36;
/*    */   
/*    */   public final boolean _validator_()
/*    */   {
/* 50 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 54 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 58 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 62 */     if (_o1_ == this) return true;
/* 63 */     if ((_o1_ instanceof NormalResultRet)) {
/* 64 */       return true;
/*    */     }
/* 66 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 70 */     int _h_ = 0;
/* 71 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 75 */     StringBuilder _sb_ = new StringBuilder();
/* 76 */     _sb_.append("(");
/* 77 */     _sb_.append(")");
/* 78 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(NormalResultRet _o_) {
/* 82 */     if (_o_ == this) return 0;
/* 83 */     int _c_ = 0;
/* 84 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\NormalResultRet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
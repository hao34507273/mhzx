/*     */ package grc;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ErrorCodes
/*     */   implements Marshal, Comparable<ErrorCodes>
/*     */ {
/*     */   public static final int ERROR_SUCCEED = 0;
/*     */   public static final int ERROR_APPID_INVALID = 1;
/*     */   public static final int ERROR_ACCOUNT_INVALID = 2;
/*     */   public static final int ERROR_TOKEN_INVALID = 3;
/*     */   public static final int ERROR_SDK_ARGS = 4;
/*     */   public static final int ERROR_SDK_TRANS = 5;
/*     */   public static final int ERROR_SDK_BUSY = 6;
/*     */   public static final int ERROR_REDIS_STORE = 7;
/*     */   public static final int ERROR_NETWORK_TIMEOUT = 8;
/*     */   public static final int ERROR_OTHERS = 9;
/*     */   public static final int ERROR_REDIS_LOCK = 10;
/*     */   public static final int ERROR_PROFILE_INFO_KEY_NOT_EXIST = 100;
/*     */   public static final int ERROR_PROFILE_INFO_NOT_EXIST = 100;
/*     */   public static final int ERROR_FIGHTING_CAPACITY_CHART_KEY_NOT_EXIST = 101;
/*     */   public static final int ERROR_RECEIVE_GIFT_INFO_KEY_NOT_EXIST = 102;
/*     */   public static final int ERROR_GIFT_TYPE_INVALID = 110;
/*     */   public static final int ERROR_SENDER_IS_RECEIVER = 111;
/*     */   public static final int ERROR_RECEIVER_TURN_OFF_RECEIVE = 112;
/*     */   public static final int ERROR_MAX_SEND_TIMES_EVERYDAY = 113;
/*     */   public static final int ERROR_ALREADY_SENDED_TO_RECEIVER = 114;
/*     */   public static final int ERROR_MAX_RECEIVE_TIMES_EVERYDAY = 115;
/*     */   public static final int ERROR_VIP_FLAG_INVALID = 210;
/*     */   public static final int ERROR_VIP_PAY_TIMESTAMP_INVALID = 211;
/*     */   public static final int ERROR_INVITER_ALREADY_GEN_CODE = 400;
/*     */   public static final int ERROR_INVITER_NOT_GEN_CODE = 401;
/*     */   public static final int ERROR_INVITE_CODE_INVALID = 402;
/*     */   public static final int ERROR_OPENID_EQUALS_BETWEEN_INVITER_AND_INVITEE = 403;
/*     */   public static final int ERROR_CHANNEL_NOT_EQUAL_BETWEEN_INVITER_AND_INVITEE = 404;
/*     */   public static final int ERROR_INVITEE_ALREADY_USED = 405;
/*     */   public static final int ERROR_INVITEE_ALREADY_USE_THIS_CODE = 406;
/*     */   public static final int ERROR_DEVICEID_EQUALS_BETWEEN_INVITER_AND_INVITEE = 407;
/*     */   public static final int ERROR_INVITEE_INVALID = 410;
/*     */   public static final int ERROR_INVITEE_TOTAL_REBATE_BIND_YUANBAO_PARAM_INVALID = 411;
/*     */   public static final int ERROR_INVITEE_REBATE_BIND_YUANBAO_LIMIT_PARAM_INVALID = 412;
/*     */   public static final int ERROR_INVITEE_REBATE_BIND_YUANBAO_LIMIT = 413;
/*     */   public static final int ERROR_INVITEE_REBATE_BIND_YUANBAO_ALREADY_ADDED = 414;
/*     */   public static final int ERROR_INVITEE_TOTAL_GIFT_TIMES_PARAM_INVALID = 420;
/*     */   public static final int ERROR_INVITEE_GIFT_TIMES_ALREADY_ADDED = 421;
/*     */   public static final int ERROR_AWARD_INVITER_GIFT_MAX_TIMES_PARAM_INVALID = 422;
/*     */   public static final int ERROR_INVITER_TOTAL_COST_REBATE_BIND_YUANBAO_PARAM_INVALID = 430;
/*     */   public static final int ERROR_INVITER_DAILY_COST_REBATE_BIND_YUANBAO_LIMIT_PARAM_INVALID = 431;
/*     */   public static final int ERROR_INVITER_TOTAL_REBATE_BIND_YUANBAO_NOT_ENOUGH = 432;
/*     */   public static final int ERROR_INVITER_DAILY_COST_REBATE_BIND_YUANBAO_LIMIT = 433;
/*     */   public static final int ERROR_INVITER_TOTAL_GIFT_TIMES_NOT_ENOUGH = 440;
/*     */   public static final int ERROR_INVITER_TOTAL_GIFT_TIMES_LIMIT = 441;
/*     */   public static final int ERROR_NO_KNOCK_OUT_DATA = 500;
/*     */   public static final int ERROR_NO_POINT_DATA = 501;
/*     */   public static final int ERROR_NO_SELECTION_DATA = 502;
/*     */   public static final int ERROR_NO_CORPS_DATA = 504;
/*     */   public static final int ERROR_NOT_IN_RANK = 600;
/*     */   public static final int ERROR_NO_RNAK_DATA = 601;
/*     */   public static final int ERROR_CANNOT_BET = 611;
/*     */   public static final int ERROR_ALREADY_BET = 612;
/*     */   public static final int ERROR_RECALL_INVITED = 700;
/*     */   public static final int ERROR_RECALL_TODAY_FILLED = 701;
/*     */   public static final int ERROR_RECALL_FRIEND_FILLED = 702;
/*     */   public static final int ERROR_RECALL_LOGIN_TIME_FIELD = 703;
/*     */   public static final int ERROR_RECALL_LOGIN_TIME = 704;
/*     */   public static final int ERROR_RECALL_MAX_LEVEL_FIELD = 705;
/*     */   public static final int ERROR_RECALL_MAX_LEVEL = 706;
/*     */   public static final int ERROR_RECALL_NOT_FRIEND = 707;
/*     */   public static final int ERROR_RECALL_NOT_LOSS = 708;
/*     */   public static final int ERROR_RECALL_BIND_EXPIRED = 709;
/*     */   public static final int ERROR_RECALL_BINDED = 710;
/*     */   public static final int ERROR_RECALL_BIND_FULL = 711;
/*     */   public static final int ERROR_RECALL_FRIEND_BIND_FULL = 712;
/*     */   public static final int ERROR_RECALL_NOT_BIND = 713;
/*     */   public static final int ERROR_RECALL_BIND_MAILED = 714;
/*     */   public static final int ERROR_RECALL_FRIEND_PROFILE_NOT_FOUND = 715;
/*     */   public static final int ERROR_RECALL_BIND_TOGETHER_FILLED = 716;
/*     */   public static final int ERROR_RECALL_VITALITY_EXPIRE = 717;
/*     */   public static final int ERROR_RECALL_BIND_REWARD = 718;
/*     */   public static final int ERROR_RECALL_VITALITY_NOT_ENOUGH = 719;
/*     */   public static final int ERROR_RECALL_FRIEND_VITALITY_NOT_ENOUGH = 720;
/*     */   public static final int ERROR_RECALL_VITALITY_TIME = 721;
/*     */   public static final int ERROR_RECALL_REBATE_NOT_ENOUGH = 722;
/*     */   public static final int ERROR_RECALL_REBATE_MAX = 723;
/*     */   public static final int ERROR_INDIANA_NO_ROLE_INFO = 800;
/*     */   public static final int ERROR_INDIANA_NUMBER_NOT_MATCH = 801;
/*     */   public static final int ERROR_INDIANA_NUMBER_NOT_ENOUGH = 802;
/*     */   
/*     */   public final boolean _validator_()
/*     */   {
/*  97 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/* 101 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 105 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/* 109 */     if (_o1_ == this) return true;
/* 110 */     if ((_o1_ instanceof ErrorCodes)) {
/* 111 */       return true;
/*     */     }
/* 113 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 117 */     int _h_ = 0;
/* 118 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 122 */     StringBuilder _sb_ = new StringBuilder();
/* 123 */     _sb_.append("(");
/* 124 */     _sb_.append(")");
/* 125 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(ErrorCodes _o_) {
/* 129 */     if (_o_ == this) return 0;
/* 130 */     int _c_ = 0;
/* 131 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\grc\ErrorCodes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
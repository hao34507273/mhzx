/*     */ package hub;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DataTransferType
/*     */   implements Marshal, Comparable<DataTransferType>
/*     */ {
/*     */   public static final int GEN_ROAM_TOKEN = 1;
/*     */   public static final int ROAM_ROLE_DATA = 2;
/*     */   public static final int VALIDATE_ROAM_TOKEN = 3;
/*     */   public static final int LADDER_DATA_BACK = 4;
/*     */   public static final int ROAM_MATCH_CONTEXT = 5;
/*     */   public static final int JOIN_MATCH = 6;
/*     */   public static final int NOTIFY_MATCH_RESULT = 7;
/*     */   public static final int CANCEL_MATCH = 8;
/*     */   public static final int WAIT_NEXT_ROUND_MATCH = 9;
/*     */   public static final int CONFIRM_JOIN_MATCH = 10;
/*     */   public static final int REPORT_GAME_SERVER_BALANCE_INFO = 11;
/*     */   public static final int MODIFY_ROAM_SERVER_DATE = 15;
/*     */   public static final int TRANSFER_CHAT_CONTENT = 16;
/*     */   public static final int REPORT_CROSS_COMPETE_SIGN_UP = 100;
/*     */   public static final int CROSS_COMPETE_ROAM_SERVERS = 101;
/*     */   public static final int NOTIFY_CROSS_COMPETE_AGAINST = 102;
/*     */   public static final int REPORT_CROSS_COMPETE_FACTION_INFO = 103;
/*     */   public static final int ENTER_CROSS_COMPETE_MAP = 104;
/*     */   public static final int CROSS_COMPETE_ROLE_DATA_BACK = 105;
/*     */   public static final int NOTIFY_CROSS_COMPETE_RESULT = 106;
/*     */   public static final int CROSS_COMPETE_TEAM_DATA_BACK = 107;
/*     */   public static final int JOIN_SELECTION_OR_FINAL = 200;
/*     */   public static final int CONFIRM_JOIN_SELECTION_OR_FINAL = 201;
/*     */   public static final int SELECTION_OR_FINAL_WAIT_NEXT_ROUND_MATCH = 202;
/*     */   public static final int ROAM_SELECTION_OR_FINAL_CONTEXT = 203;
/*     */   public static final int NOTIFY_SELECTION_OR_FINAL_MATCH_RESULT = 204;
/*     */   public static final int SELECTION_OR_FINAL_DATA_BACK = 205;
/*     */   public static final int NOTIFY_SELECTION_OR_FINAL_BYE_REQ = 206;
/*     */   public static final int NOTIFY_SELECTION_OR_FINAL_FIGHT_BEGIN = 207;
/*     */   public static final int REPORT_CORPS_FIGHT_VALUE = 300;
/*     */   public static final int JOIN_POINT_RACE = 301;
/*     */   public static final int CONFIRM_JOIN_POINT_RACE = 302;
/*     */   public static final int ROAM_POINT_RACE_CONTEXT = 303;
/*     */   public static final int NOTIFY_POINT_RACE_RESULT = 304;
/*     */   public static final int NOTIFY_POINT_RACE_PENDING = 305;
/*     */   public static final int ROAM_POINT_RACE_DATA = 306;
/*     */   public static final int POINT_RACE_DATA_BACK = 307;
/*     */   public static final int UPDATE_POINT_RACE_CORPS = 308;
/*     */   public static final int REPORT_POINT_RACE_CORPS_CVC = 309;
/*     */   public static final int POINT_RACE_END = 310;
/*     */   public static final int POINT_RACE_QUERY = 311;
/*     */   public static final int SINGLE_CROSS_FIELD_JOIN_MATCH = 400;
/*     */   public static final int SINGLE_CROSS_FIELD_CONFIRM_JOIN_MATCH = 401;
/*     */   public static final int SINGLE_CROSS_FIELD_ROAM_MATCH_CONTEXT = 402;
/*     */   public static final int SINGLE_CROSS_FIELD_NOTIFY_MATCH_RESULT = 403;
/*     */   public static final int SINGLE_CROSS_FIELD_CANCEL_MATCH = 404;
/*     */   public static final int SINGLE_CROSS_FIELD_WAIT_NEXT_ROUND_MATCH = 405;
/*     */   public static final int SINGLE_CROSS_FIELD_DATA_BACK = 406;
/*     */   public static final int FRIENDS_CIRCLE_GIVE_GIFT = 500;
/*     */   public static final int FRIENDS_CIRCLE_TREAD = 501;
/*     */   public static final int FRIENDS_CIRCLE_TREAD_HISTORY_DELETE = 502;
/*     */   public static final int FRIENDS_CIRCLE_GIVE_GIFT_HISTORY_DELETE = 503;
/*     */   public static final int FRIENDS_CIRCLE_OPERATOR_BLACK_LIST = 504;
/*     */   public static final int RECALL_NOTIFY_BIND_FRIEND = 600;
/*     */   public static final int ALL_LOTTO_REPORT_CANDIDATE_INFO = 700;
/*     */   public static final int ALL_LOTTO_NOTIFY_AWARD_ROLE_INFO = 701;
/*     */   
/*     */   public final boolean _validator_()
/*     */   {
/*  73 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  77 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  81 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  85 */     if (_o1_ == this) return true;
/*  86 */     if ((_o1_ instanceof DataTransferType)) {
/*  87 */       return true;
/*     */     }
/*  89 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  93 */     int _h_ = 0;
/*  94 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  98 */     StringBuilder _sb_ = new StringBuilder();
/*  99 */     _sb_.append("(");
/* 100 */     _sb_.append(")");
/* 101 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(DataTransferType _o_) {
/* 105 */     if (_o_ == this) return 0;
/* 106 */     int _c_ = 0;
/* 107 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\DataTransferType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
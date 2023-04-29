/*     */ package mzm.gsp.apollo;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
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
/*     */   public static final int ERROR_MODULE_CLOSE_OR_ROLE_FORBIDDEN = 201;
/*     */   public static final int INVAILD_VOIP_ROOM_TYPE = 202;
/*     */   public static final int ERROR_ROLE_GAME_STATUS_ERROR = 203;
/*     */   public static final int ERROR_ROLE_NOT_IN_TEAM = 221;
/*     */   public static final int ERROR_TEAM_IS_DISSOLVED = 222;
/*     */   public static final int ERROR_ROLE_IN_OTHER_VOIP_ROOM = 223;
/*     */   public static final int ERROR_ROLE_NOT_IN_THIS_TEAM = 224;
/*     */   public static final int ERROR_REPEAT_REQ = 225;
/*     */   public static final int ERROR_ROLE_IN_VOIP_ROOM = 226;
/*     */   public static final int ERROR_ROLE_NOT_IN_THIS_VOIP_ROOM = 222;
/*     */   public static final int ERROR_DB_ERROR = 228;
/*     */   public static final int ERROR_ROOM_STATE_ERROR = 229;
/*     */   public static final int ERROR_ROLE_STATE_ERROR = 230;
/*     */   public static final int ERROR_DATA_NOT_MATCH = 231;
/*     */   public static final int ERROR_APOLLO_COMMUNICATION_ERROR = 232;
/*     */   public static final int ERROR_VOIP_CMD_CREATE_ROOM = -10012;
/*     */   public static final int ERROR_VOIP_CMD_JOIN_ROOM = -10013;
/*     */   public static final int ERROR_VOIP_CMD_EXIT_ROOM = -10014;
/*     */   public static final int ERROR_VOIP_CMD_CLOSE_ROOM = -10015;
/*     */   public static final int ERROR_VIOP_CMD_UNKNOWN = -10016;
/*     */   public static final int ERROR_VOIP_REQ_TIMEOUT = -10001;
/*     */   public static final int ERROR_VOIP_ERR_CDN_ERROR = 10001;
/*     */   public static final int ERROR_VOIP_ERR_INVALID_ARG = 10002;
/*     */   public static final int ERROR_VOIP_ERR_TIMEOUTED = 10003;
/*     */   public static final int ERROR_VOIP_ERR_SEND_REQ_TO_CDN_FAILED = 10004;
/*     */   public static final int ERROR_VOIP_ERR_ERROR_REQUEST = 10005;
/*     */   public static final int ERROR_VOIP_ERR_BUSINESSID_NOT_FOUND = 10006;
/*     */   public static final int ERROR_VOIP_ERR_CURL_ERROR = 10007;
/*     */   public static final int ERROR_ERROR_REQ_CMD_CREATE_LARGE_ROOM = -20010;
/*     */   public static final int ERROR_ERROR_REQ_CMD_ENTER_LARGE_ROOM = -20011;
/*     */   public static final int ERROR_ERROR_REQ_CMD_CLOSE_LARGE_ROOM = -20012;
/*     */   public static final int ERROR_ERROR_REQ_CMD_UNKNOWN = -20013;
/*     */   public static final int ERROR_ERROR_REQ_CMD_CHECK_ROOM_EXIST = -20014;
/*     */   public static final int ERROR_LARGE_ROOM_REQ_TIMEOUT = -20001;
/*     */   public static final int ERROR_LARGE_ROOM_ERROR_FAILED_TO_SEND_REQ_FOR_NO_CONNECTION_AVAIBLE = 20001;
/*     */   public static final int ERROR_LARGE_ROOM_ERROR_SESSION_TIMEOUT = 20002;
/*     */   public static final int ERROR_LARGE_ROOM_ERROR_NOT_ENOUGH_SESSION = 20003;
/*     */   public static final int ERROR_LARGE_ROOM_BUSINESS_FIXED_ROOM_ID_WRONG = 20004;
/*     */   public static final int ERROR_GET_AUTHKEY_TIMEOUT = -30001;
/*     */   public static final int ERROR_STT_LOCAL_TIMEOUT = -40001;
/*     */   
/*     */   public final boolean _validator_()
/*     */   {
/*  66 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  70 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  74 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  78 */     if (_o1_ == this) return true;
/*  79 */     if ((_o1_ instanceof ErrorCodes)) {
/*  80 */       return true;
/*     */     }
/*  82 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  86 */     int _h_ = 0;
/*  87 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  91 */     StringBuilder _sb_ = new StringBuilder();
/*  92 */     _sb_.append("(");
/*  93 */     _sb_.append(")");
/*  94 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(ErrorCodes _o_) {
/*  98 */     if (_o_ == this) return 0;
/*  99 */     int _c_ = 0;
/* 100 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\apollo\ErrorCodes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
/*     */ package csprovider;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ 
/*     */ public class DataBetweenGameAndSocialSpaceRes implements Marshal
/*     */ {
/*     */   public static final int ERROR_SUCCESS = 0;
/*     */   public static final int ERROR_PARAMETER_INVALID = 40001;
/*     */   public static final int ERROR_AUTH_INVALID = 40002;
/*     */   public static final int ERROR_TOKEN_INVALID = 40003;
/*     */   public static final int ERROR_STORE_FAILED = 40004;
/*     */   public static final int ERROR_QUERY_FAILED = 40005;
/*     */   public static final int ERROR_LOGIN_FAILED = 40006;
/*     */   public static final int ERROR_USER_EXISTED = 40007;
/*     */   public static final int ERROR_AWARDEE_ERROR = 40008;
/*     */   public static final int ERROR_GAMEID_NOT_EXIST = 40009;
/*     */   public static final int ERROR_COMMON_ERROR = 40010;
/*     */   public static final int ERROR_JSON_ERROR = 40011;
/*     */   public static final int ERROR_STATUS_ERROR = 40012;
/*     */   public static final int ERROR_DUPLICATE_ACTID_ERROR = 40013;
/*     */   public static final int ERROR_NOT_CONNECT_TO_GAMESERVER = 40014;
/*     */   public static final int ERROR_TIMEOUT_ERROR = 40015;
/*     */   public static final int ERROR_NOT_CONNECT_TO_CSPSERVER = 40016;
/*     */   public static final int ERROR_COMMUNICATION_ENCODEING_ERROR = 40017;
/*     */   public static final int ERROR_GAME_NOT_EXIST = 40018;
/*     */   public static final int ERROR_PARAMETER_ERROR = 40019;
/*     */   public static final int ERROR_TIMESTAMP_INVALID = 40020;
/*     */   public static final int ERROR_SIGN_INVALID = 40021;
/*     */   public static final int ERROR_ROLE_NOT_EXIST = 40022;
/*     */   public static final int ERROR_SPACE_NOT_OPEN = 40023;
/*     */   public static final int ERROR_INQUIRER_LEVEL_INVALID = 40024;
/*     */   public static final int ERROR_MOMENT_NOT_EXIST = 40025;
/*     */   public static final int ERROR_VOTE_RECORD_NOT_EXIST = 40026;
/*     */   public static final int ERROR_MOMENT_ROLEINFO_NOT_MATCHING = 40027;
/*     */   public static final int ERROR_SPACE_SETTING_NOT_EXIST = 40028;
/*     */   public static final int ERROR_REPLY_FORBID = 40029;
/*     */   public static final int ERROR_FRIENDSHIP_NOT_EXIST = 40030;
/*     */   public static final int ERROR_FRIENDSHIP_ALREADY_DELETE = 40031;
/*     */   public static final int ERROR_REPLY_NOT_EXIST = 40032;
/*     */   public static final int ERROR_REPLY_ROLEINFO_NOT_MATCHING = 40033;
/*     */   public static final int ERROR_ALREDY_STEP_SPACE = 40034;
/*     */   public static final int ERROR_OWNER_NOT_EXIST = 40035;
/*     */   public static final int ERROR_INQUIRER_NOT_EXIST = 40036;
/*     */   public static final int ERROR_GIFT_NOT_ENOUGH = 40037;
/*     */   public static final int ERROR_RANK_REFRESHING = 40038;
/*     */   public static final int ERROR_FORBID_TALKING = 40039;
/*     */   public static final int ERROR_MESSAGE_NOT_EXIST = 40040;
/*     */   public static final int ERROR_MESSAGE_ROLEINFO_NOT_MATCHING = 40041;
/*     */   public static final int ERROR_REQUEST_TOO_QUICKLY = 40042;
/*     */   public static final int ERROR_H5ACTIVITY_USER_CONEECT_TOO_QUICKLY = 40043;
/*     */   public static final int ERROR_PIC_NOT_EXIST = 40044;
/*     */   public static final int ERROR_NOT_HOT_MOMENT = 40045;
/*     */   public static final int ERROR_PARTIAL_HANDLE_ERROR = 40046;
/*     */   public static final int ERROR_NOT_IN_BKP_LIST = 40047;
/*     */   public static final int ERROR_OWNER_SEE_MOMENT = 40048;
/*     */   public static final int ERROR_MOMENT_ALREADY_DELET = 40049;
/*     */   public static final int ERROR_ALREADY_HOT_MOMENT = 40050;
/*     */   public static final int ERROR_URL_ILLEGAL = 40051;
/*     */   public static final int ERROR_DETECT_PIC_ERROR = 40052;
/*     */   public static final int ERROR_SUSPECT_PIC = 40053;
/*     */   public static final int ERROR_PORN_PIC = 40054;
/*     */   public static final int ERROR_REDIS_ERROR = 40055;
/*     */   public static final int ERROR_REPORT_TOO_QUICKLY = 40056;
/*     */   public static final int ERROR_PORTRAIT_NOT_EXIST = 40057;
/*     */   public static final int ERROR_UPLOAD_PIC_ERROR = 40058;
/*     */   public static final int ERROR_FILL_TYPE_ERROR = 40059;
/*     */   public static final int ERROR_FILL_TOO_LARGE = 40060;
/*     */   public static final int ERROR_HEAD_MOMENT_SIZE_ERROR = 40061;
/*     */   public static final int ERROR_HEAD_PIC_SIZE_ERROR = 40062;
/*     */   public static final int ERROR_SUBJECT_NOT_EXIST = 40063;
/*     */   public static final int ERROR_NO_SUBJECT_LAUCH = 40064;
/*     */   public static final int ERROR_MOMENT_NOT_MATCH_CURRENT_SUBJECT = 40065;
/*     */   public static final int ERROR_UPLOAD_FILE_ALREADY_EXIST = 40066;
/*     */   public static final int ERROR_UPLOAD_FILE_PATH_ERROR = 40067;
/*     */   public static final int ERROR_FUNC_FORBID = 40068;
/*     */   public static final int ERROR_COMMUNICATE_TOGAME_FAILED = 40069;
/*     */   public static final int ERROR_EXCEED_MAX_CACHE_COUNT = 40070;
/*     */   public static final int ERROR_USER_NOT_EXIST = 40071;
/*     */   public static final int ERROR_SERIAL_EXIST = 40072;
/*     */   public static final int ERROR_IN_BLACKLIST = 40073;
/*     */   public int retcode;
/*     */   public Octets result;
/*     */   public int reserved1;
/*     */   public Octets reserved2;
/*     */   
/*     */   public DataBetweenGameAndSocialSpaceRes()
/*     */   {
/*  90 */     this.retcode = 40010;
/*  91 */     this.result = new Octets();
/*  92 */     this.reserved2 = new Octets();
/*     */   }
/*     */   
/*     */   public DataBetweenGameAndSocialSpaceRes(int _retcode_, Octets _result_, int _reserved1_, Octets _reserved2_) {
/*  96 */     this.retcode = _retcode_;
/*  97 */     this.result = _result_;
/*  98 */     this.reserved1 = _reserved1_;
/*  99 */     this.reserved2 = _reserved2_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/* 103 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/* 107 */     _os_.marshal(this.retcode);
/* 108 */     _os_.marshal(this.result);
/* 109 */     _os_.marshal(this.reserved1);
/* 110 */     _os_.marshal(this.reserved2);
/* 111 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 115 */     this.retcode = _os_.unmarshal_int();
/* 116 */     this.result = _os_.unmarshal_Octets();
/* 117 */     this.reserved1 = _os_.unmarshal_int();
/* 118 */     this.reserved2 = _os_.unmarshal_Octets();
/* 119 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/* 123 */     if (_o1_ == this) return true;
/* 124 */     if ((_o1_ instanceof DataBetweenGameAndSocialSpaceRes)) {
/* 125 */       DataBetweenGameAndSocialSpaceRes _o_ = (DataBetweenGameAndSocialSpaceRes)_o1_;
/* 126 */       if (this.retcode != _o_.retcode) return false;
/* 127 */       if (!this.result.equals(_o_.result)) return false;
/* 128 */       if (this.reserved1 != _o_.reserved1) return false;
/* 129 */       if (!this.reserved2.equals(_o_.reserved2)) return false;
/* 130 */       return true;
/*     */     }
/* 132 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 136 */     int _h_ = 0;
/* 137 */     _h_ += this.retcode;
/* 138 */     _h_ += this.result.hashCode();
/* 139 */     _h_ += this.reserved1;
/* 140 */     _h_ += this.reserved2.hashCode();
/* 141 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 145 */     StringBuilder _sb_ = new StringBuilder();
/* 146 */     _sb_.append("(");
/* 147 */     _sb_.append(this.retcode).append(",");
/* 148 */     _sb_.append("B").append(this.result.size()).append(",");
/* 149 */     _sb_.append(this.reserved1).append(",");
/* 150 */     _sb_.append("B").append(this.reserved2.size()).append(",");
/* 151 */     _sb_.append(")");
/* 152 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\csprovider\DataBetweenGameAndSocialSpaceRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
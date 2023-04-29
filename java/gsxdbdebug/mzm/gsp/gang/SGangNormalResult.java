/*     */ package mzm.gsp.gang;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class SGangNormalResult extends __SGangNormalResult__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12589828;
/*     */   public static final int CREATE_GANG_ILLEGAL_NAME = 0;
/*     */   public static final int CREATE_GANG_ILLEGAL_PURPOSE = 1;
/*     */   public static final int CREATE_GANG_NEED_MORE_YUANBAO = 2;
/*     */   public static final int CREATE_SUCCESS = 3;
/*     */   public static final int SEARCH_GANG_NOT_FIND = 4;
/*     */   public static final int XUETU_NUM_FULL = 5;
/*     */   public static final int BANGZHONG_NUM_FULL = 6;
/*     */   public static final int REJECT_JOIN_GANG = 7;
/*     */   public static final int TARGET_ALREADY_JOIN_GANG = 8;
/*     */   public static final int TARGET_ALREADY_IN_APPLY_LIST = 9;
/*     */   public static final int QUIT_GANG_SUCCESS = 10;
/*     */   public static final int INVITE_JOIN_GANG_SUCCESS = 11;
/*     */   public static final int INVITE_SAME_GANG_ERROR = 12;
/*     */   public static final int ADD_APPLY_LIST_SUCCESS = 13;
/*     */   public static final int DONATE_SUCCESS = 14;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType() {
/*  27 */     return 12589828;
/*     */   }
/*     */   
/*     */ 
/*     */   public static final int GANG_RENAME_SUCCESS = 16;
/*     */   
/*     */   public static final int GANG_RENAME_NOT_COOL_DOWN = 17;
/*     */   
/*     */   public static final int GANG_CREATE_FAILED_NAME_DUPLICATE = 18;
/*     */   
/*     */   public static final int GANG_RENAME_FAILED_NAME_DUPLICATE = 19;
/*     */   
/*     */   public static final int XUE_TU_MAX_LEVEL_SET_SUCCESS = 20;
/*     */   
/*     */   public static final int TANHE_SUCCESS = 21;
/*     */   
/*     */   public static final int FORBIDDEN_TALK_MAX_COUNT = 22;
/*     */   
/*     */   public static final int KICK_MEMBER_MAX_COUNT = 23;
/*     */   
/*     */   public static final int KICK_MEMBER_NEED_MORE_VIGOR = 24;
/*     */   
/*     */   public static final int RENMING_ACTION_SUCCESS = 25;
/*     */   
/*     */   public static final int CHANGE_LEADER_ACTION_SUCCESS = 26;
/*     */   
/*     */   public static final int GANG_CHANGE_LEADER_ILLEGAL = 27;
/*     */   
/*     */   public static final int GANG_DESIGN_DUTY_SUCCESS = 28;
/*     */   
/*     */   public static final int GANG_ANNOUNCEMENT_TIMES_OUT = 29;
/*     */   
/*     */   public static final int CONFIRM_JOIN_GANG = 30;
/*     */   
/*     */   public static final int ERR_ALREADY_HAVE_GANG = 31;
/*     */   public static final int ERR_BUILDING_ALREADY_LEVELUP_SUCCESS = 32;
/*     */   public static final int ERR_TANHE_BANGZHU_OFFLINE_TIME_NOT_ENOUGH = 33;
/*     */   public static final int ERR_YAOCAI_IS_OUT_OF_SALE = 34;
/*     */   public static final int ERR_BAG_IS_FULL = 35;
/*     */   public static final int ERR_GET_MIFANG_JOIN_GANG_AFTER_TRIGGER = 36;
/*     */   public static final int FULI_GET_SUCCESS = 37;
/*     */   public static final int ERR_BUY_YAOCAI_NOT_EXIST = 38;
/*     */   public static final int ERR_VIGOR_NOT_ENOUGH = 39;
/*     */   public static final int ERR_GET_MIFANG_BANGGONG_NOT_ENOUGH = 40;
/*     */   public static final int ERR_FULI_COUNT_IS_MAX = 41;
/*     */   public static final int ERR_FULI_JOIN_NOT_AFTER_3_DAY = 42;
/*     */   public static final int ERR_REDEEM_BANGGONG_NOT_AFTER_3_DAY = 43;
/*     */   public static final int ERR_FULI_ALREADY_GET = 44;
/*     */   public static final int NONE_GANG = 45;
/*     */   public static final int GANG_INFO_ERROR = 46;
/*     */   public static final int DISMISS_SUCCESS = 47;
/*     */   public static final int DISMISS_FAIL = 48;
/*     */   public static final int MODIFIED_SIGN_STRING_SUCCESS = 49;
/*     */   public static final int MODIFIED_SIGN_STRING_FAIL = 50;
/*     */   public static final int CANT_SIGN_SAME_DAY = 51;
/*     */   public static final int CANT_DUIHUAN_BANGGONG_WITHMAX = 52;
/*     */   public static final int ERR_LIANYAO_YAOCAI_NOT_ENOUGH = 53;
/*     */   public static final int ERR_SIGN_STRING_HAS_SENSITIVE_WORDS = 54;
/*     */   public static final int ERR_DUTY_MEMBER_ENOUGH = 55;
/*     */   public static final int GANG_DESIGN_DUTY_FAIL = 56;
/*     */   public static final int GANG_NOT_EXIST = 57;
/*     */   public static final int YOU_NOT_IN_GANG_NOW = 58;
/*     */   public static final int YUAN_BAO_NOT_ENOUGH = 59;
/*     */   public static final int CUT_YUAN_BAO_FAIL = 60;
/*     */   public static final int STATUS_ERROR = 61;
/*     */   public static final int COMBINE_GANG_APPLY__NO_RIGHT = 101;
/*     */   public static final int COMBINE_GANG_APPLY__GANG_NOT_EXIST = 102;
/*     */   public static final int COMBINE_GANG_APPLY__ALREADY = 103;
/*     */   public static final int COMBINE_GANG_APPLY__APPLICANT = 104;
/*     */   public static final int COMBINE_GANG_APPLY__CROSS_COMPETE_SIGNUP = 105;
/*     */   public static final int COMBINE_GANG_APPLY_REP__NO_RIGHT = 111;
/*     */   public static final int COMBINE_GANG_APPLY_REP__TIMEOUT = 112;
/*     */   public static final int COMBINE_GANG_CANCEL__NO_RIGHT = 121;
/*     */   public static final int COMBINE_GANG_CANCEL__TIMEOUT = 122;
/*     */   public static final int GET_COMBINE_GANG_LIST__VITALITY = 131;
/*     */   public static final int CREATE_GANG_TEAM__NO_GANG = 201;
/*     */   public static final int CREATE_GANG_TEAM__IN_TEAM = 202;
/*     */   public static final int CREATE_GANG_TEAM__NAME_TOO_LONG = 203;
/*     */   public static final int CREATE_GANG_TEAM__NAME_ILLEGAL = 204;
/*     */   public static final int CREATE_GANG_TEAM__COOL_DOWN = 205;
/*     */   public static final int CHANGE_GANG_TEAM_NAME__NO_GANG = 211;
/*     */   public static final int CHANGE_GANG_TEAM_NAME__NOT_IN_TEAM = 212;
/*     */   public static final int CHANGE_GANG_TEAM_NAME__NOT_LEADER = 213;
/*     */   public static final int CHANGE_GANG_TEAM_NAME__NAME_TOO_LONG = 214;
/*     */   public static final int CHANGE_GANG_TEAM_NAME__NAME_ILLEGAL = 215;
/*     */   public static final int JOIN_GANG_TEAM__NO_GANG = 221;
/*     */   public static final int JOIN_GANG_TEAM__IN_TEAM = 222;
/*     */   public static final int JOIN_GANG_TEAM__TEAM_NOT_EXIST = 223;
/*     */   public static final int JOIN_GANG_TEAM__IN_APPLICANT_LIST = 224;
/*     */   public static final int JOIN_GANG_TEAM__TEAM_FULL = 225;
/*     */   public static final int JOIN_GANG_TEAM__SUCCEED = 226;
/*     */   public static final int AUTO_JOIN_GANG_TEAM__NO_GANG = 231;
/*     */   public static final int AUTO_JOIN_GANG_TEAM__IN_TEAM = 232;
/*     */   public static final int AUTO_JOIN_GANG_TEAM__SUCCEED = 233;
/*     */   public static final int JOIN_GANG_TEAM_REP__NO_GANG = 241;
/*     */   public static final int JOIN_GANG_TEAM_REP__NOT_IN_TEAM = 242;
/*     */   public static final int JOIN_GANG_TEAM_REP__NOT_LEADER = 243;
/*     */   public static final int JOIN_GANG_TEAM_REP__NOT_IN_APPLY_LIST = 244;
/*     */   public static final int JOIN_GANG_TEAM_REP__TEAM_FULL = 245;
/*     */   public static final int JOIN_GANG_TEAM_REP__APPLICANT_NOT_IN_GANG = 246;
/*     */   public static final int JOIN_GANG_TEAM_REP__APPLICANT_IN_TEAM = 247;
/*     */   public static final int INVITE_GANG_TEAM__NO_GANG = 251;
/*     */   public static final int INVITE_GANG_TEAM__NOT_IN_TEAM = 252;
/*     */   public static final int INVITE_GANG_TEAM__INVITEE_NOT_IN_GANG = 254;
/*     */   public static final int INVITE_GANG_TEAM__INVITEE_IN_TEAM = 255;
/*     */   public static final int INVITE_GANG_TEAM__INVITEE_OFFLINE = 256;
/*     */   public static final int INVITE_GANG_TEAM__SUCCEED = 257;
/*     */   public static final int INVITE_GANG_TEAM__ALREADY_INVITE = 258;
/*     */   public static final int INVITE_GANG_TEAM_REP__NO_GANG = 271;
/*     */   public static final int INVITE_GANG_TEAM_REP__IN_TEAM = 272;
/*     */   public static final int INVITE_GANG_TEAM_REP__TEAM_NOT_EXIST = 273;
/*     */   public static final int INVITE_GANG_TEAM_REP__TEAM_FULL = 274;
/*     */   public static final int INVITE_GANG_TEAM_REP__TIMEOUT = 275;
/*     */   public static final int INVITE_GANG_TEAM_REP__INVITER_NOT_IN_GANG = 276;
/*     */   public static final int INVITE_GANG_TEAM_REP__INVITER_NOT_IN_TEAM = 277;
/*     */   public static final int CHANGE_GANG_TEAM_LEADER__NO_GANG = 291;
/*     */   public static final int CHANGE_GANG_TEAM_LEADER__NOT_IN_TEAM = 292;
/*     */   public static final int CHANGE_GANG_TEAM_LEADER__NOT_LEADER = 293;
/*     */   public static final int CHANGE_GANG_TEAM_LEADER__NEW_LEADER_NOT_IN_TEAM = 294;
/*     */   public static final int CHANGE_GANG_TEAM_LEADER__NEW_LEADER_SELF = 295;
/*     */   public static final int LEAVE_GANG_TEAM__NO_GANG = 311;
/*     */   public static final int LEAVE_GANG_TEAM__NOT_IN_TEAM = 312;
/*     */   public static final int KICK_GANG_TEAM_MEMBER__NO_GANG = 321;
/*     */   public static final int KICK_GANG_TEAM_MEMBER__NOT_IN_TEAM = 322;
/*     */   public static final int KICK_GANG_TEAM_MEMBER__NOT_LEADER = 323;
/*     */   public static final int KICK_GANG_TEAM_MEMBER__MEMBER_NOT_IN_TEAM = 324;
/*     */   public static final int YUAN_BAO_TO_BANG_GONG_FUNCTION_NOT_OPEN = 331;
/*     */   public static final int YUAN_BAO_EXCHANGE_CFG_NOT_EXIST = 332;
/*     */   public static final int USER_ID_NOT_EXIST = 333;
/*     */   public static final int CLIENT_YUAN_BAO_NOT_SAME_WITH_SERVER = 334;
/*     */   public static final int NO_BANG_GONG_CAN_EXCHANGE = 335;
/*     */   public static final int BANG_GONG_EXCHANGE_OUT_LIMIT = 336;
/*     */   public int result;
/*     */   public java.util.ArrayList<String> args;
/*     */   public SGangNormalResult()
/*     */   {
/* 163 */     this.args = new java.util.ArrayList();
/*     */   }
/*     */   
/*     */   public SGangNormalResult(int _result_, java.util.ArrayList<String> _args_) {
/* 167 */     this.result = _result_;
/* 168 */     this.args = _args_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/* 172 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/* 176 */     _os_.marshal(this.result);
/* 177 */     _os_.compact_uint32(this.args.size());
/* 178 */     for (String _v_ : this.args) {
/* 179 */       _os_.marshal(_v_, "UTF-16LE");
/*     */     }
/* 181 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 185 */     this.result = _os_.unmarshal_int();
/* 186 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/* 188 */       String _v_ = _os_.unmarshal_String("UTF-16LE");
/* 189 */       this.args.add(_v_);
/*     */     }
/* 191 */     if (!_validator_()) {
/* 192 */       throw new VerifyError("validator failed");
/*     */     }
/* 194 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/* 198 */     if (_o1_ == this) return true;
/* 199 */     if ((_o1_ instanceof SGangNormalResult)) {
/* 200 */       SGangNormalResult _o_ = (SGangNormalResult)_o1_;
/* 201 */       if (this.result != _o_.result) return false;
/* 202 */       if (!this.args.equals(_o_.args)) return false;
/* 203 */       return true;
/*     */     }
/* 205 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 209 */     int _h_ = 0;
/* 210 */     _h_ += this.result;
/* 211 */     _h_ += this.args.hashCode();
/* 212 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 216 */     StringBuilder _sb_ = new StringBuilder();
/* 217 */     _sb_.append("(");
/* 218 */     _sb_.append(this.result).append(",");
/* 219 */     _sb_.append(this.args).append(",");
/* 220 */     _sb_.append(")");
/* 221 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\SGangNormalResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
/*     */ package mzm.gsp.idip;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class IdipRet
/*     */   implements Marshal, Comparable<IdipRet>
/*     */ {
/*     */   public static final int ERROR_SUCCEED = 0;
/*     */   public static final int ERROR_SUCCEED_BODY_EMPTY = 1;
/*     */   public static final int ERROR_EXP_NUM_SIGN = -1000;
/*     */   public static final int ERROR_EXP_ROLE_LEVEL_HAS_REACH_TOP_LIMIT = -1001;
/*     */   public static final int ERROR_EXP_NUM_CUT_NOT_ENOUGH = -1002;
/*     */   public static final int ERROR_EXP_CLEAR_FOR_AQIDIP = -1003;
/*     */   public static final int ERROR_JIFEN_NUM_SIGN = -1010;
/*     */   public static final int ERROR_JIFEN_TYPE_NOT_EXIST = -1011;
/*     */   public static final int ERROR_JIFEN_NUM_CUT_NOT_ENOUGH = -1012;
/*     */   public static final int ERROR_JIFEN_NUM_CLEAR_FOR_AQIDIP = -1013;
/*     */   public static final int ERROR_MONEY_NUM_SIGN = -1020;
/*     */   public static final int ERROR_MONEY_NUM_CUT_NOT_ENOUGH = -1021;
/*     */   public static final int ERROR_MONEY_NUM_HAS_REACH_TOP_LIMIT = -1022;
/*     */   public static final int ERROR_MONEY_NUM_REACH_TOP_LIMIT_FOR_AQIDIP = -1023;
/*     */   public static final int ERROR_MONEY_CLEAR_FOR_AQIDIP = -1024;
/*     */   public static final int ERROR_MONEY_TYPE_NOT_EXIST = -1025;
/*     */   public static final int ERROR_VIGOR_NUM_SIGN = -1030;
/*     */   public static final int ERROR_VIGOR_TYPE_NOT_EXIST = -1031;
/*     */   public static final int ERROR_VIGOR_NUM_CUT_NOT_ENOUGH = -1032;
/*     */   public static final int ERROR_VIGOR_NUM_HAS_REACH_TOP_LIMIT = -1033;
/*     */   public static final int ERROR_CLEAR_FOR_AQIDIP = -1034;
/*     */   public static final int ERROR_ZERO_ADD = -1035;
/*     */   public static final int ERROR_SEND_MAIL_ROLE_NOT_EXIST = -1040;
/*     */   public static final int ERROR_SEND_MAIL_TLOG_IS_NULL = -1041;
/*     */   public static final int ERROR_SEND_MAIL_ITEM_NOT_EXIST = -1042;
/*     */   public static final int ERROR_SEND_MAIL_CFG_ID_NOT_EXIST = -1043;
/*     */   public static final int ERROR_SEND_MAIL_ITEM_NUM_ERROR = -1044;
/*     */   public static final int ERROR_SEND_MAIL_TITLE_LEN_INVALID = -1045;
/*     */   public static final int ERROR_SEND_MAIL_CONTENT_LEN_INVALID = -1046;
/*     */   public static final int ERROR_SEND_MAIL_MONEY_NUM = -1047;
/*     */   public static final int ERROR_SEND_MAIL_NO_VALID_DATA = -1048;
/*     */   public static final int ERROR_SEND_MAIL_MONEY_TYPE_NOT_SUPPORT = -1049;
/*     */   public static final int ERROR_BAG_UN_KNOWN = -1050;
/*     */   public static final int ERROR_BAG_WRONG_ITEM_CFG = -1051;
/*     */   public static final int ERROR_BAG_ITEM_NUM_NOT_ENOUGH = -1052;
/*     */   public static final int ERROR_BAG_FULL = -1053;
/*     */   public static final int ERROR_BAGTYPE_NOT_EXIST = -1054;
/*     */   public static final int ERROR_BAG_EQUIPBAG_CAN_NOT_ADD_ITEM = -1055;
/*     */   public static final int ERROR_BAG_NOT_HAS_THE_ITEM = -1056;
/*     */   public static final int ERROR_BAG_ITEM_NUM_WRONG = -1057;
/*     */   public static final int ERROR_BAG_STORAGE_NOT_OPEN = -1058;
/*     */   public static final int CARRY_MAX_ERROR = -1059;
/*     */   public static final int ERROR_QUERY_PET_CFG_NOT_EXIST = -1060;
/*     */   public static final int ERROR_QUERY_PET_NOT_HAS_THE_PET = -1061;
/*     */   public static final int ERROR_BANG_GONG_ROLE_NOT_IN_BANG = -1070;
/*     */   public static final int ERROR_BANG_GONG_BANG_ERROR = -1071;
/*     */   public static final int ERROR_BANG_GONG_SIGN = -1072;
/*     */   public static final int ERROR_BANG_GONG_CUT_NOT_ENOUGH = -1073;
/*     */   public static final int ERROR_BANG_GONG_CLEAR_FOR_AQIDIP = -1074;
/*     */   public static final int ERROR_YUAN_BAO_SIGN = -1080;
/*     */   public static final int ERROR_YUAN_BAO_CUT_NOT_ENOUGH = -1081;
/*     */   public static final int ERROR_YUAN_BAO_DATA_NOT_CREATE = -1082;
/*     */   public static final int ERROR_CHANNEL_SIGN_LIMIT_FUN_SWITCH_STATUS_NOT_MATCH = -1090;
/*     */   public static final int ERROR_CHANNEL_LEN_INVALID = -1091;
/*     */   public static final int ERROR_BAN_REASON_LEN_INVALID = -1100;
/*     */   public static final int ERROR_BAN_TIME_SIGN = -1101;
/*     */   public static final int ERROR_CASHTYPE_NOT_EXIST = -1120;
/*     */   public static final int ERROR_STORAGE_EXP_NUM_SIGN = -1130;
/*     */   public static final int ERROR_STORAGE_EXP_CLEAR_FOR_AQIDIP = -1131;
/*     */   public static final int ERROR_RANK_TYPE_NOT_EXIT = -1140;
/*     */   public static final int ERROR_RANK_TIP_LEN_INVALID = -1141;
/*     */   public static final int ERROR_RANK_TIME_NUM_WRONG = -1142;
/*     */   public static final int ERROR_NOT_IN_RANK = -1143;
/*     */   public static final int ERROR_CHAT_TIME_NUM_WRONG = -1150;
/*     */   public static final int ERROR_MASK_REASON_LEN_INVALID = -1151;
/*     */   public static final int ERROR_ZERO_PROFIT_REASON_LEN_INVALID = -1160;
/*     */   public static final int ERROR_ZERO_PROFIT_TIME_NUM_WRONG = -1161;
/*     */   public static final int ERROR_SEND_CONTENT_LEN_INVALID = -1170;
/*     */   public static final int ERROR_BAN_PLAY_TIP_LEN_INVALID = -1180;
/*     */   public static final int ERROR_BAN_PLAY_TIME_NUM_WRONG = -1181;
/*     */   public static final int ERROR_BAN_PLAY_TYPE_NOT_EXIST = -1182;
/*     */   public static final int ERROR_MARQUEE_BEGIN_TIME_NUM_WRONG = -1190;
/*     */   public static final int ERROR_MARQUEE_END_TIME_NUM_WRONG = -1191;
/*     */   public static final int ERROR_MARQUEE_BEGIN_TIME_GREATER_THAN_END_TIME = -1192;
/*     */   public static final int ERROR_MARQUEE_TITLE_LEN_INVALID = -1193;
/*     */   public static final int ERROR_MARQUEE_CONTENT_LEN_INVALID = -1194;
/*     */   public static final int ERROR_MARQUEE_ROLLFRE_NUM_WRONG = -1195;
/*     */   public static final int ERROR_MARQUEE_ROLLNUM_NUM_WRONG = -1196;
/*     */   public static final int ERROR_MARQUEE_NOT_EXIST = -1197;
/*     */   public static final int ERROR_MARQUEE_PAGE_NUM_WRONG = -1198;
/*     */   public static final int ERROR_MARQUEE_ID_DUPLICATED = -1199;
/*     */   public static final int ERROR_SET_RANK_TYPE_NOT_EXIT = -1200;
/*     */   public static final int ERROR_SET_RANK_DATA_NUM_WRONG = -1201;
/*     */   public static final int ERROR_SET_RANK_DATA_UNSUPPORT = -1202;
/*     */   public static final int ERROR_ROLE_INFO_TYPE_NOT_EXIT = -1210;
/*     */   public static final int ERROR_LOCK_ROLE_INFO_CONTENT_LEN_INVALID = -1211;
/*     */   public static final int ERROR_LOCK_ROLE_INFO_TIME_NUM_WRONG = -1212;
/*     */   public static final int ERROR_LOCK_ROLE_INFO_NAME_WRONG = -1213;
/*     */   public static final int ERROR_LOCK_ROLE_INFO_NAME_SENSITIVE = -1214;
/*     */   public static final int ERROR_LOCK_ROLE_INFO_NAME_REPEAT = -1215;
/*     */   public static final int ERROR_LOCK_ROLE_INFO_NAME_SYSTEM = -1216;
/*     */   public static final int ERROR_NOTICE_TYPE_INVALID = -1220;
/*     */   public static final int ERROR_NOTICE_DISPLAY_TYPE_INVALID = -1221;
/*     */   public static final int ERROR_NOTICE_HREF_TYPE_INVALID = -1222;
/*     */   public static final int ERROR_NOTICE_SEND_TYPE_INVALID = -1223;
/*     */   public static final int ERROR_NOTICE_START_TIME_INVALID = -1224;
/*     */   public static final int ERROR_NOTICE_END_TIME_INVALID = -1225;
/*     */   public static final int ERROR_NOTICE_OPEN_SERVER_DAYS_INVALID = -1226;
/*     */   public static final int ERROR_NOTICE_CREAT_ROLE_DAYS_INVALID = -1227;
/*     */   public static final int ERROR_NOTICE_ROLE_LEVEL_INVALID = -1228;
/*     */   public static final int ERROR_NOTICE_SAVE_AMT_INVALID = -1229;
/*     */   public static final int ERROR_NOTICE_TAG_INVALID = -1230;
/*     */   public static final int ERROR_NOTICE_SORTID_INVALID = -1231;
/*     */   public static final int ERROR_NOTICE_NOT_EXIST = -1232;
/*     */   public static final int ERROR_NOTICE_QUERY_PAGE_INVALID = -1233;
/*     */   public static final int ERROR_NOTICE_UPDATE_FAILED = -1234;
/*     */   public static final int ERROR_NOTICE_DURATION_INVALID = -1235;
/*     */   public static final int ERROR_NOTICE_TITLE_LEN_INVALID = -1236;
/*     */   public static final int ERROR_NOTICE_CONTENT_LEN_INVALID = -1237;
/*     */   public static final int ERROR_NOTICE_HREF_TEXT_LEN_INVALID = -1238;
/*     */   public static final int ERROR_NOTICE_HREF_URL_LEN_INVALID = -1239;
/*     */   public static final int ERROR_NOTICE_PICTURE_URL_LEN_INVALID = -1240;
/*     */   public static final int ERROR_NOTICE_ID_DUPLICATED = -1241;
/*     */   public static final int ERROR_ACTIVITY_CODE = -1250;
/*     */   public static final int ERROR_BAN_ADD_FRIEND_TIME_NUM_WRONG = -1260;
/*     */   public static final int ERROR_BAN_ADD_FRIEND_REASON_LEN_INVALID = -1261;
/*     */   public static final int ERROR_GANG_ID_INVALID = -1270;
/*     */   public static final int ERROR_GANG_NOT_EXIST = -1271;
/*     */   public static final int ERROR_GANG_PAGE_NO_INVALID = -1272;
/*     */   public static final int ERROR_XIAN_LV_LENGTH_INVALID = -1280;
/*     */   public static final int ERROR_XIAN_LV_FORMAT = -1281;
/*     */   public static final int ERROR_NOT_OWN_THE_XIAN_LV = -1282;
/*     */   public static final int ERROR_ADD_INNER_SAVE_AMT_VALUE_INVALID = -1290;
/*     */   public static final int ERROR_ADD_INNER_SAVE_AMT_FAILED = -1291;
/*     */   public static final int ITEM_TIME_NOT_VALIE = -1300;
/*     */   public static final int BAG_NOT_SUPPORT_ITEM = -1400;
/*     */   public static final int ERROR_ROLE_NOT_OPEN_FRIENDS_CIRCLE = -1410;
/*     */   public static final int ERROR_ROLE_SET_ROLE_FRIENDS_CIRCLE_VALUE_NOT_MATCH = -1411;
/*     */   public static final int ERROR_SET_FRIENDS_CIRCLE_TYPE_ENUM_WRONG = -1412;
/*     */   public static final int ERROR_ROLE_NOT_FASHION_DRESS_DATA = -1420;
/*     */   public static final int ERROR_ITEM_CFG_NOT_EXIST = -1421;
/*     */   public static final int ERROR_ITEM_FASHION_DRESS_NOT_EXIST = -1422;
/*     */   public static final int ERROR_ROLE_NOT_DATA = -1423;
/*     */   public static final int ERROR_NOT_OWN_FASHION_DRESS = -1424;
/*     */   public static final int ERROR_ROLE_NOT_WING_DATA = -1430;
/*     */   public static final int ERROR_WING_CFG_NOT_EXIST = -1431;
/*     */   public static final int ERROR_NOT_OWN_WING = -1432;
/*     */   public static final int ERROR_ROLE_NOT_AIRCRAFT_DATA = -1440;
/*     */   public static final int ERROR_AIRCRAFT_CFG_NOT_EXIST = -1441;
/*     */   public static final int ERROR_AIRCRAFT_ROLE_DATA_NOT_EXIST = -1442;
/*     */   public static final int ERROR_AIRCRAFT_ROLE_NOT_OWN = -1443;
/*     */   public static final int ERROR_QUERY_MAIL_PAGE_INVALID = -1450;
/*     */   public static final int ERROR_DEL_MAIL_PARAMS_INVALID = -1460;
/*     */   public static final int ERROR_DEL_MAIL_FAILED = -1461;
/*     */   public static final int ERROR_GLOBAL_MAIL_PAGE_INVALID = -1470;
/*     */   public static final int ERROR_DEL_ALL_MAIL_PARAMS_INVALID = -1480;
/*     */   public static final int ERROR_DEL_ALL_MAIL_FAILED = -1481;
/*     */   public static final int ERROR_DEL_PET_ROLE_NOT_EXIST = -1490;
/*     */   public static final int ERROR_DEL_PET_INSTANCE_NOT_EXIST = -1491;
/*     */   public static final int ERROR_DEL_PET_CFG_NOT_EXIST = -1492;
/*     */   public static final int ERROR_DEL_PET_CFG_NOT_MATCH = -1493;
/*     */   public static final int ERROR_DEL_PET_ROLE_OWN_PET_EXIST = -1494;
/*     */   public static final int ERROR_DEL_PET_ROLE_NOT_OWN_PET_BAG = -1495;
/*     */   public static final int ERROR_DEL_PET_IN_FIGHT = -1496;
/*     */   public static final int ERROR_DEL_PET_IN_FIGHT_PET = -1497;
/*     */   public static final int ERROR_DEL_MOUNTS_ROLE_NOT_EXIST = -1500;
/*     */   public static final int ERROR_DEL_MOUNTS_INSTANCE_NOT_EXIST = -1501;
/*     */   public static final int ERROR_DEL_MOUNTS_CFG_NOT_EXIST = -1502;
/*     */   public static final int ERROR_DEL_MOUNTS_CFG_NOT_MATCH = -1503;
/*     */   public static final int ERROR_DEL_MOUNTS_ROLE_OWN_MOUNTS_EXIST = -1504;
/*     */   public static final int ERROR_DEL_MOUNTS_ROLE_NOT_OWN_MOUNTS_BAG = -1505;
/*     */   public static final int ERROR_REMOVE_CHAT_BUBBLE_PARAMS_INVALID = -1510;
/*     */   public static final int ERROR_REMOVE_CHAT_BUBBLE_NOT_EXIST = -1511;
/*     */   public static final int ERROR_REMOVE_ITEM_CONDITION_NOT_FOUND = -1520;
/*     */   public static final int ERROR_RESTART_KNOCKOUT_ACTIVITY_CFG_NOT_EXIST = -1530;
/*     */   public static final int ERROR_RESTART_KNOCKOUT_NOT_CURRENT_ACTIVITY = -1531;
/*     */   public static final int ERROR_RESTART_KNOCKOUT_KNOCKOUT_CFG_NOT_EXIST = -1532;
/*     */   public static final int ERROR_RESTART_KNOCKOUT_FIGHT_ZONE_NOT_VALID = -1533;
/*     */   public static final int ERROR_RESTART_KNOCKOUT_CURRENT_STAGE_ERROR = -1534;
/*     */   public static final int ERROR_RESTART_KNOCKOUT_KNOCK_OUT_NOT_BEGIN = -1535;
/*     */   public static final int ERROR_RESTART_KNOCKOUT_MAX_FIGHT_ID = -1536;
/*     */   public static final int ERROR_RESTART_KNOCKOUT_FIGHT_ID = -1537;
/*     */   public static final int ERROR_RESTART_KNOCKOUT_CAN_NOT_SET_PASS_TIME = -1538;
/*     */   public static final int ERROR_RESTART_KNOCKOUT_NEXT_STAGE_BEGIN_TIME = -1539;
/*     */   public static final int ERROR_RESTART_KNOCKOUT_FIGHT_END_TIME = -1540;
/*     */   public static final int ERROR_RESTART_KNOCKOUT_CURRENT_EXIST_PREPARE_WORLD = -1541;
/*     */   public static final int ERROR_RESTART_KNOCKOUT_GRC_SEND = -1542;
/*     */   public static final int ERROR_RESTART_KNOCKOUT_RESTART_TIME = -1543;
/*     */   public static final int ERROR_RESTART_KNOCKOUT_NOW_IS_ALL_RESTART = -1544;
/*     */   public static final int ERROR_RESTART_KNOCKOUT_FIGHT_ZONE_IS_ALEARDY_RESTART = -1545;
/*     */   public static final int ERROR_REFRESH_KNOCKOUT_ACTIVITY_CFG_NOT_EXIST = -1550;
/*     */   public static final int ERROR_REFRESH_KNOCKOUT_KNOCKOUT_CFG_NOT_EXIST = -1551;
/*     */   public static final int ERROR_REFRESH_KNOCKOUT_FIGHT_ZONE_NOT_VALID = -1552;
/*     */   public static final int ERROR_REFRESH_KNOCKOUT_CURRENT_STAGE_ERROR = -1553;
/*     */   public static final int ERROR_REFRESH_KNOCKOUT_GRC_SEND = -1554;
/*     */   public static final int ERROR_REMOVE_WU_SHI_NOT_EXIST = -1560;
/*     */   public static final int ERROR_REMOVE_WU_SHI_FRAGMENT_NOT_ENOUGH = -1561;
/*     */   public static final int ERROR_DRAW_CARNIVAL_ACTIVITY_INFO_NOT_EXIST = -1580;
/*     */   public static final int ERROR_DRAW_CARNIVAL_PASS_TYPE_ID_INFO_NOT_EXIST = -1581;
/*     */   public static final int ERROR_DRAW_CARNIVAL_PARAM_ERROR = -1582;
/*     */   
/*     */   public final boolean _validator_()
/*     */   {
/* 205 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/* 209 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 213 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/* 217 */     if (_o1_ == this) return true;
/* 218 */     if ((_o1_ instanceof IdipRet)) {
/* 219 */       return true;
/*     */     }
/* 221 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 225 */     int _h_ = 0;
/* 226 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 230 */     StringBuilder _sb_ = new StringBuilder();
/* 231 */     _sb_.append("(");
/* 232 */     _sb_.append(")");
/* 233 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(IdipRet _o_) {
/* 237 */     if (_o_ == this) return 0;
/* 238 */     int _c_ = 0;
/* 239 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\IdipRet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
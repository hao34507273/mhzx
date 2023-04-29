local OctetsStream = require("netio.OctetsStream")
local IdipRet = class("IdipRet")
IdipRet.ERROR_SUCCEED = 0
IdipRet.ERROR_SUCCEED_BODY_EMPTY = 1
IdipRet.ERROR_EXP_NUM_SIGN = -1000
IdipRet.ERROR_EXP_ROLE_LEVEL_HAS_REACH_TOP_LIMIT = -1001
IdipRet.ERROR_EXP_NUM_CUT_NOT_ENOUGH = -1002
IdipRet.ERROR_EXP_CLEAR_FOR_AQIDIP = -1003
IdipRet.ERROR_JIFEN_NUM_SIGN = -1010
IdipRet.ERROR_JIFEN_TYPE_NOT_EXIST = -1011
IdipRet.ERROR_JIFEN_NUM_CUT_NOT_ENOUGH = -1012
IdipRet.ERROR_JIFEN_NUM_CLEAR_FOR_AQIDIP = -1013
IdipRet.ERROR_MONEY_NUM_SIGN = -1020
IdipRet.ERROR_MONEY_NUM_CUT_NOT_ENOUGH = -1021
IdipRet.ERROR_MONEY_NUM_HAS_REACH_TOP_LIMIT = -1022
IdipRet.ERROR_MONEY_NUM_REACH_TOP_LIMIT_FOR_AQIDIP = -1023
IdipRet.ERROR_MONEY_CLEAR_FOR_AQIDIP = -1024
IdipRet.ERROR_MONEY_TYPE_NOT_EXIST = -1025
IdipRet.ERROR_VIGOR_NUM_SIGN = -1030
IdipRet.ERROR_VIGOR_TYPE_NOT_EXIST = -1031
IdipRet.ERROR_VIGOR_NUM_CUT_NOT_ENOUGH = -1032
IdipRet.ERROR_VIGOR_NUM_HAS_REACH_TOP_LIMIT = -1033
IdipRet.ERROR_CLEAR_FOR_AQIDIP = -1034
IdipRet.ERROR_ZERO_ADD = -1035
IdipRet.ERROR_SEND_MAIL_ROLE_NOT_EXIST = -1040
IdipRet.ERROR_SEND_MAIL_TLOG_IS_NULL = -1041
IdipRet.ERROR_SEND_MAIL_ITEM_NOT_EXIST = -1042
IdipRet.ERROR_SEND_MAIL_CFG_ID_NOT_EXIST = -1043
IdipRet.ERROR_SEND_MAIL_ITEM_NUM_ERROR = -1044
IdipRet.ERROR_SEND_MAIL_TITLE_LEN_INVALID = -1045
IdipRet.ERROR_SEND_MAIL_CONTENT_LEN_INVALID = -1046
IdipRet.ERROR_SEND_MAIL_MONEY_NUM = -1047
IdipRet.ERROR_SEND_MAIL_NO_VALID_DATA = -1048
IdipRet.ERROR_SEND_MAIL_MONEY_TYPE_NOT_SUPPORT = -1049
IdipRet.ERROR_BAG_UN_KNOWN = -1050
IdipRet.ERROR_BAG_WRONG_ITEM_CFG = -1051
IdipRet.ERROR_BAG_ITEM_NUM_NOT_ENOUGH = -1052
IdipRet.ERROR_BAG_FULL = -1053
IdipRet.ERROR_BAGTYPE_NOT_EXIST = -1054
IdipRet.ERROR_BAG_EQUIPBAG_CAN_NOT_ADD_ITEM = -1055
IdipRet.ERROR_BAG_NOT_HAS_THE_ITEM = -1056
IdipRet.ERROR_BAG_ITEM_NUM_WRONG = -1057
IdipRet.ERROR_BAG_STORAGE_NOT_OPEN = -1058
IdipRet.CARRY_MAX_ERROR = -1059
IdipRet.ERROR_QUERY_PET_CFG_NOT_EXIST = -1060
IdipRet.ERROR_QUERY_PET_NOT_HAS_THE_PET = -1061
IdipRet.ERROR_BANG_GONG_ROLE_NOT_IN_BANG = -1070
IdipRet.ERROR_BANG_GONG_BANG_ERROR = -1071
IdipRet.ERROR_BANG_GONG_SIGN = -1072
IdipRet.ERROR_BANG_GONG_CUT_NOT_ENOUGH = -1073
IdipRet.ERROR_BANG_GONG_CLEAR_FOR_AQIDIP = -1074
IdipRet.ERROR_YUAN_BAO_SIGN = -1080
IdipRet.ERROR_YUAN_BAO_CUT_NOT_ENOUGH = -1081
IdipRet.ERROR_YUAN_BAO_DATA_NOT_CREATE = -1082
IdipRet.ERROR_CHANNEL_SIGN_LIMIT_FUN_SWITCH_STATUS_NOT_MATCH = -1090
IdipRet.ERROR_CHANNEL_LEN_INVALID = -1091
IdipRet.ERROR_BAN_REASON_LEN_INVALID = -1100
IdipRet.ERROR_BAN_TIME_SIGN = -1101
IdipRet.ERROR_CASHTYPE_NOT_EXIST = -1120
IdipRet.ERROR_STORAGE_EXP_NUM_SIGN = -1130
IdipRet.ERROR_STORAGE_EXP_CLEAR_FOR_AQIDIP = -1131
IdipRet.ERROR_RANK_TYPE_NOT_EXIT = -1140
IdipRet.ERROR_RANK_TIP_LEN_INVALID = -1141
IdipRet.ERROR_RANK_TIME_NUM_WRONG = -1142
IdipRet.ERROR_NOT_IN_RANK = -1143
IdipRet.ERROR_CHAT_TIME_NUM_WRONG = -1150
IdipRet.ERROR_MASK_REASON_LEN_INVALID = -1151
IdipRet.ERROR_ZERO_PROFIT_REASON_LEN_INVALID = -1160
IdipRet.ERROR_ZERO_PROFIT_TIME_NUM_WRONG = -1161
IdipRet.ERROR_SEND_CONTENT_LEN_INVALID = -1170
IdipRet.ERROR_BAN_PLAY_TIP_LEN_INVALID = -1180
IdipRet.ERROR_BAN_PLAY_TIME_NUM_WRONG = -1181
IdipRet.ERROR_BAN_PLAY_TYPE_NOT_EXIST = -1182
IdipRet.ERROR_MARQUEE_BEGIN_TIME_NUM_WRONG = -1190
IdipRet.ERROR_MARQUEE_END_TIME_NUM_WRONG = -1191
IdipRet.ERROR_MARQUEE_BEGIN_TIME_GREATER_THAN_END_TIME = -1192
IdipRet.ERROR_MARQUEE_TITLE_LEN_INVALID = -1193
IdipRet.ERROR_MARQUEE_CONTENT_LEN_INVALID = -1194
IdipRet.ERROR_MARQUEE_ROLLFRE_NUM_WRONG = -1195
IdipRet.ERROR_MARQUEE_ROLLNUM_NUM_WRONG = -1196
IdipRet.ERROR_MARQUEE_NOT_EXIST = -1197
IdipRet.ERROR_MARQUEE_PAGE_NUM_WRONG = -1198
IdipRet.ERROR_MARQUEE_ID_DUPLICATED = -1199
IdipRet.ERROR_SET_RANK_TYPE_NOT_EXIT = -1200
IdipRet.ERROR_SET_RANK_DATA_NUM_WRONG = -1201
IdipRet.ERROR_SET_RANK_DATA_UNSUPPORT = -1202
IdipRet.ERROR_ROLE_INFO_TYPE_NOT_EXIT = -1210
IdipRet.ERROR_LOCK_ROLE_INFO_CONTENT_LEN_INVALID = -1211
IdipRet.ERROR_LOCK_ROLE_INFO_TIME_NUM_WRONG = -1212
IdipRet.ERROR_LOCK_ROLE_INFO_NAME_WRONG = -1213
IdipRet.ERROR_LOCK_ROLE_INFO_NAME_SENSITIVE = -1214
IdipRet.ERROR_LOCK_ROLE_INFO_NAME_REPEAT = -1215
IdipRet.ERROR_LOCK_ROLE_INFO_NAME_SYSTEM = -1216
IdipRet.ERROR_NOTICE_TYPE_INVALID = -1220
IdipRet.ERROR_NOTICE_DISPLAY_TYPE_INVALID = -1221
IdipRet.ERROR_NOTICE_HREF_TYPE_INVALID = -1222
IdipRet.ERROR_NOTICE_SEND_TYPE_INVALID = -1223
IdipRet.ERROR_NOTICE_START_TIME_INVALID = -1224
IdipRet.ERROR_NOTICE_END_TIME_INVALID = -1225
IdipRet.ERROR_NOTICE_OPEN_SERVER_DAYS_INVALID = -1226
IdipRet.ERROR_NOTICE_CREAT_ROLE_DAYS_INVALID = -1227
IdipRet.ERROR_NOTICE_ROLE_LEVEL_INVALID = -1228
IdipRet.ERROR_NOTICE_SAVE_AMT_INVALID = -1229
IdipRet.ERROR_NOTICE_TAG_INVALID = -1230
IdipRet.ERROR_NOTICE_SORTID_INVALID = -1231
IdipRet.ERROR_NOTICE_NOT_EXIST = -1232
IdipRet.ERROR_NOTICE_QUERY_PAGE_INVALID = -1233
IdipRet.ERROR_NOTICE_UPDATE_FAILED = -1234
IdipRet.ERROR_NOTICE_DURATION_INVALID = -1235
IdipRet.ERROR_NOTICE_TITLE_LEN_INVALID = -1236
IdipRet.ERROR_NOTICE_CONTENT_LEN_INVALID = -1237
IdipRet.ERROR_NOTICE_HREF_TEXT_LEN_INVALID = -1238
IdipRet.ERROR_NOTICE_HREF_URL_LEN_INVALID = -1239
IdipRet.ERROR_NOTICE_PICTURE_URL_LEN_INVALID = -1240
IdipRet.ERROR_NOTICE_ID_DUPLICATED = -1241
IdipRet.ERROR_ACTIVITY_CODE = -1250
IdipRet.ERROR_BAN_ADD_FRIEND_TIME_NUM_WRONG = -1260
IdipRet.ERROR_BAN_ADD_FRIEND_REASON_LEN_INVALID = -1261
IdipRet.ERROR_GANG_ID_INVALID = -1270
IdipRet.ERROR_GANG_NOT_EXIST = -1271
IdipRet.ERROR_GANG_PAGE_NO_INVALID = -1272
IdipRet.ERROR_XIAN_LV_LENGTH_INVALID = -1280
IdipRet.ERROR_XIAN_LV_FORMAT = -1281
IdipRet.ERROR_NOT_OWN_THE_XIAN_LV = -1282
IdipRet.ERROR_ADD_INNER_SAVE_AMT_VALUE_INVALID = -1290
IdipRet.ERROR_ADD_INNER_SAVE_AMT_FAILED = -1291
IdipRet.ITEM_TIME_NOT_VALIE = -1300
IdipRet.BAG_NOT_SUPPORT_ITEM = -1400
IdipRet.ERROR_ROLE_NOT_OPEN_FRIENDS_CIRCLE = -1410
IdipRet.ERROR_ROLE_SET_ROLE_FRIENDS_CIRCLE_VALUE_NOT_MATCH = -1411
IdipRet.ERROR_SET_FRIENDS_CIRCLE_TYPE_ENUM_WRONG = -1412
IdipRet.ERROR_ROLE_NOT_FASHION_DRESS_DATA = -1420
IdipRet.ERROR_ITEM_CFG_NOT_EXIST = -1421
IdipRet.ERROR_ITEM_FASHION_DRESS_NOT_EXIST = -1422
IdipRet.ERROR_ROLE_NOT_DATA = -1423
IdipRet.ERROR_NOT_OWN_FASHION_DRESS = -1424
IdipRet.ERROR_ROLE_NOT_WING_DATA = -1430
IdipRet.ERROR_WING_CFG_NOT_EXIST = -1431
IdipRet.ERROR_NOT_OWN_WING = -1432
IdipRet.ERROR_ROLE_NOT_AIRCRAFT_DATA = -1440
IdipRet.ERROR_AIRCRAFT_CFG_NOT_EXIST = -1441
IdipRet.ERROR_AIRCRAFT_ROLE_DATA_NOT_EXIST = -1442
IdipRet.ERROR_AIRCRAFT_ROLE_NOT_OWN = -1443
IdipRet.ERROR_QUERY_MAIL_PAGE_INVALID = -1450
IdipRet.ERROR_DEL_MAIL_PARAMS_INVALID = -1460
IdipRet.ERROR_DEL_MAIL_FAILED = -1461
IdipRet.ERROR_GLOBAL_MAIL_PAGE_INVALID = -1470
IdipRet.ERROR_DEL_ALL_MAIL_PARAMS_INVALID = -1480
IdipRet.ERROR_DEL_ALL_MAIL_FAILED = -1481
IdipRet.ERROR_DEL_PET_ROLE_NOT_EXIST = -1490
IdipRet.ERROR_DEL_PET_INSTANCE_NOT_EXIST = -1491
IdipRet.ERROR_DEL_PET_CFG_NOT_EXIST = -1492
IdipRet.ERROR_DEL_PET_CFG_NOT_MATCH = -1493
IdipRet.ERROR_DEL_PET_ROLE_OWN_PET_EXIST = -1494
IdipRet.ERROR_DEL_PET_ROLE_NOT_OWN_PET_BAG = -1495
IdipRet.ERROR_DEL_PET_IN_FIGHT = -1496
IdipRet.ERROR_DEL_PET_IN_FIGHT_PET = -1497
IdipRet.ERROR_DEL_MOUNTS_ROLE_NOT_EXIST = -1500
IdipRet.ERROR_DEL_MOUNTS_INSTANCE_NOT_EXIST = -1501
IdipRet.ERROR_DEL_MOUNTS_CFG_NOT_EXIST = -1502
IdipRet.ERROR_DEL_MOUNTS_CFG_NOT_MATCH = -1503
IdipRet.ERROR_DEL_MOUNTS_ROLE_OWN_MOUNTS_EXIST = -1504
IdipRet.ERROR_DEL_MOUNTS_ROLE_NOT_OWN_MOUNTS_BAG = -1505
IdipRet.ERROR_REMOVE_CHAT_BUBBLE_PARAMS_INVALID = -1510
IdipRet.ERROR_REMOVE_CHAT_BUBBLE_NOT_EXIST = -1511
IdipRet.ERROR_REMOVE_ITEM_CONDITION_NOT_FOUND = -1520
IdipRet.ERROR_RESTART_KNOCKOUT_ACTIVITY_CFG_NOT_EXIST = -1530
IdipRet.ERROR_RESTART_KNOCKOUT_NOT_CURRENT_ACTIVITY = -1531
IdipRet.ERROR_RESTART_KNOCKOUT_KNOCKOUT_CFG_NOT_EXIST = -1532
IdipRet.ERROR_RESTART_KNOCKOUT_FIGHT_ZONE_NOT_VALID = -1533
IdipRet.ERROR_RESTART_KNOCKOUT_CURRENT_STAGE_ERROR = -1534
IdipRet.ERROR_RESTART_KNOCKOUT_KNOCK_OUT_NOT_BEGIN = -1535
IdipRet.ERROR_RESTART_KNOCKOUT_MAX_FIGHT_ID = -1536
IdipRet.ERROR_RESTART_KNOCKOUT_FIGHT_ID = -1537
IdipRet.ERROR_RESTART_KNOCKOUT_CAN_NOT_SET_PASS_TIME = -1538
IdipRet.ERROR_RESTART_KNOCKOUT_NEXT_STAGE_BEGIN_TIME = -1539
IdipRet.ERROR_RESTART_KNOCKOUT_FIGHT_END_TIME = -1540
IdipRet.ERROR_RESTART_KNOCKOUT_CURRENT_EXIST_PREPARE_WORLD = -1541
IdipRet.ERROR_RESTART_KNOCKOUT_GRC_SEND = -1542
IdipRet.ERROR_RESTART_KNOCKOUT_RESTART_TIME = -1543
IdipRet.ERROR_RESTART_KNOCKOUT_NOW_IS_ALL_RESTART = -1544
IdipRet.ERROR_RESTART_KNOCKOUT_FIGHT_ZONE_IS_ALEARDY_RESTART = -1545
IdipRet.ERROR_REFRESH_KNOCKOUT_ACTIVITY_CFG_NOT_EXIST = -1550
IdipRet.ERROR_REFRESH_KNOCKOUT_KNOCKOUT_CFG_NOT_EXIST = -1551
IdipRet.ERROR_REFRESH_KNOCKOUT_FIGHT_ZONE_NOT_VALID = -1552
IdipRet.ERROR_REFRESH_KNOCKOUT_CURRENT_STAGE_ERROR = -1553
IdipRet.ERROR_REFRESH_KNOCKOUT_GRC_SEND = -1554
IdipRet.ERROR_REMOVE_WU_SHI_NOT_EXIST = -1560
IdipRet.ERROR_REMOVE_WU_SHI_FRAGMENT_NOT_ENOUGH = -1561
IdipRet.ERROR_DRAW_CARNIVAL_ACTIVITY_INFO_NOT_EXIST = -1580
IdipRet.ERROR_DRAW_CARNIVAL_PASS_TYPE_ID_INFO_NOT_EXIST = -1581
IdipRet.ERROR_DRAW_CARNIVAL_PARAM_ERROR = -1582
function IdipRet:ctor()
end
function IdipRet:marshal(os)
end
function IdipRet:unmarshal(os)
end
return IdipRet

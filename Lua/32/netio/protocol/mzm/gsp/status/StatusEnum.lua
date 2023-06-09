local OctetsStream = require("netio.OctetsStream")
local StatusEnum = class("StatusEnum")
StatusEnum.STATUS_FIGHT = 0
StatusEnum.STATUS_GATHER = 1
StatusEnum.STATUS_FLY = 2
StatusEnum.STATUS_RIDE = 3
StatusEnum.STATUS_MENPAI_PVP = 5
StatusEnum.STATUS_TEAM_NORMAL = 6
StatusEnum.STATUS_TEAM_TMP_LEAVE = 7
StatusEnum.STATUS_ARENA = 8
StatusEnum.STATUS_OBSERVE = 10
StatusEnum.STATUS_COMPETE = 11
StatusEnum.STATUS_PARASELENE = 12
StatusEnum.STATUS_SINGLE_INSTANCE = 13
StatusEnum.STATUS_MULTI_INSTANCE = 14
StatusEnum.STATUS_TRANSFER_GANG = 15
StatusEnum.STATUS_FIGHTPROTECTED = 16
StatusEnum.STATUS_COMPETE_PROTECTED = 17
StatusEnum.STATUS_SHOW_PET = 18
StatusEnum.STATUS_JIUXIAO = 19
StatusEnum.STATUS_KICKOUT_GANG = 20
StatusEnum.STATUS_LEAVE_GANG = 21
StatusEnum.STATUS_JINGJI_ACTIVITY = 22
StatusEnum.STATUS_COUPLE_RIDE = 25
StatusEnum.STATUS_BIGBOSS_ACTIVITY = 26
StatusEnum.STATUS_KEJU_ACTIVITY = 27
StatusEnum.STATUS_WATCH_MOON = 28
StatusEnum.STATUS_MARRIAGE_PARADE = 29
StatusEnum.STATUS_TRANSFOR_TO_MARRIAGE = 30
StatusEnum.STATUS_QMHW = 31
StatusEnum.STATUS_NORMAL_HUSONG = 32
StatusEnum.STATUS_SPECIAL_HUSONG = 33
StatusEnum.STATUS_HOME = 34
StatusEnum.STATUS_HOLD_BANQUEST = 35
StatusEnum.STATUS_MASSWEDDING_SPECIAL = 36
StatusEnum.STATUS_MARRY = 37
StatusEnum.STATUS_HOME_LEVEL = 38
StatusEnum.STATUS_MASSWEDDING = 39
StatusEnum.STATUS_CROSS_SERVER_MATCH = 40
StatusEnum.STATUS_CROSS_SERVER = 41
StatusEnum.STATUS_LADDER_MATCH = 42
StatusEnum.STATUS_LADDER_READY = 43
StatusEnum.STATUS_ROAM_SERVER = 44
StatusEnum.ACTION__ACTIVE_LEAVE_TEAM = 45
StatusEnum.ACTION__FIRE_TEAM_MEMBER = 46
StatusEnum.ACTION__ACTIVE_APPOINT_LEADER = 47
StatusEnum.ACTION__ACTIVE_TMP_LEAVE_TEAM = 48
StatusEnum.ACTION__ACTIVE_INVITE_OTHER = 49
StatusEnum.ACTION__ACTIVE_MATCH_TEAM = 50
StatusEnum.ACTION__ACTIVE_MATCH_MEMBER = 51
StatusEnum.ACTION__ACTIVE_WING_RANK_UP = 52
StatusEnum.ACTION__ACTIVE_WING_LV_UP = 53
StatusEnum.ACTION__ACTIVE_WING_RESET_SKILL = 54
StatusEnum.ACTION__ACTIVE_WING_RESET_PROP = 55
StatusEnum.ACTION__ACTIVE_OWN_PARTNER = 56
StatusEnum.ACTION__ACTIVE_LINE_UP_PARTNER = 57
StatusEnum.ACTION__ACTIVE_REMOVE_PARTNER = 58
StatusEnum.ACTION__ACTIVE_REPLACE_ZHENRONG = 59
StatusEnum.ACTION__ACTIVE_REFRESH_LOVE = 60
StatusEnum.ACTION__ACTIVE_REPLACE_LOVE = 61
StatusEnum.ACTION__ACTIVE_ADD_POINT = 62
StatusEnum.ACTION__ACTIVE_RP_ZHENFA = 63
StatusEnum.ACTION__ACTIVE_EXCHANGE_DISP = 64
StatusEnum.STATUS_FORBID_TEAM_ACTIVE_OPER = 65
StatusEnum.ACTION__MULTI_OCCUP_ACTIVATE = 66
StatusEnum.ACTION__MULTI_OCCUP_SWITCH = 67
StatusEnum.ACTION__EXCHANGE = 68
StatusEnum.ACTION_GROUP = 69
StatusEnum.ACTION__WORLDGOAL = 70
StatusEnum.ACTION_COUNTDOWN = 71
StatusEnum.ACTION_PERSONAL = 72
StatusEnum.ACTION_SNS = 73
StatusEnum.ACTION_LOGIN_AWARD_MODULE = 74
StatusEnum.ACTION_CAT = 75
StatusEnum.ACTION_LUCKY_BAG = 76
StatusEnum.ACTION_BACK_GAME = 77
StatusEnum.ACTION_ACHIEVEMENT = 78
StatusEnum.ACTION_COUPLE_DAILY = 79
StatusEnum.ACTION_SHI_TU = 80
StatusEnum.ACTION_MI_BAO = 81
StatusEnum.ACTION_FASHION_DRESS = 82
StatusEnum.ACTION_MOUNTS = 83
StatusEnum.ACTION_QING_YUAN = 84
StatusEnum.ACTION_ROLE_DYE = 85
StatusEnum.ACTION_QYXT = 86
StatusEnum.ACTION_RECALL_FRIEND = 87
StatusEnum.ACTION__LEITAI_PK_OTHERS = 88
StatusEnum.ACTION__LEITAI_PK_BY_OTHERS = 89
StatusEnum.ACTION__CLIENT_OFFLINE = 90
StatusEnum.ACTION__GANG_ROBBER = 91
StatusEnum.ACTION__SHENG_XIAO = 92
StatusEnum.ACTION__LUAN_SHI_YAO_MO = 93
StatusEnum.ACTION__YAO_SHOU_TU_XI = 94
StatusEnum.ACTION_SWORN = 95
StatusEnum.STATUS_ROAM_SERVER_LADDER = 96
StatusEnum.STATUS_LIMIT_MOVEMENT = 97
StatusEnum.ACTION_GANG_CREATE = 101
StatusEnum.ACTION_GANG_INVITE = 102
StatusEnum.ACTION_GANG_JOIN = 103
StatusEnum.ACTION_GUIDE = 131
StatusEnum.ACTION_LONGJING_TRANSFER = 132
StatusEnum.ACTION_DOUBLE_POINT = 133
StatusEnum.ACTION_MARKET = 134
StatusEnum.ACTION_SOC_CHANLLENGE = 135
StatusEnum.ACTION_OCP_EQUIP = 136
StatusEnum.ACTION_TIME_LIIMIT_AWARD = 137
StatusEnum.ACTION_SIGN_AWARD = 138
StatusEnum.ACTION_SHIMEN = 139
StatusEnum.ACTION_ZHENFA = 140
StatusEnum.ACTION_MALL = 141
StatusEnum.ACTION_GANG_SKILL = 142
StatusEnum.ACTION_BAOTU_ACTIVITY = 143
StatusEnum.ACTION_QUESTION = 144
StatusEnum.ACTION_BAITAN = 145
StatusEnum.ACTION_ZHENYAO_ACTIVITY = 146
StatusEnum.ACTION_USE_ITEM = 147
StatusEnum.ACTION_NPC_BUY = 148
StatusEnum.ACTION_USE_LOTTERY = 149
StatusEnum.ACTION_USE_BAOTU = 150
StatusEnum.ACTION_GANG_RACE = 151
StatusEnum.ACTION_STORYWALL = 152
StatusEnum.ACTION_MYSTERYS_SHOP = 153
StatusEnum.ACTION_GET_MONSTER_LOCATION = 160
StatusEnum.ACTION_LAND = 161
StatusEnum.ACTION_MAP_ITEM_GATHER = 162
StatusEnum.ACTION_MAP_MONSTER_START_FIGHT = 163
StatusEnum.ACTION_OBSERVE_MAP_MONSTER_FIGHT = 164
StatusEnum.ACTION_ROLE_CHANGE_DIRECTION = 165
StatusEnum.ACTION_SET_XUNLUO_STATE = 166
StatusEnum.ACTION_ROLE_MOVE = 167
StatusEnum.ACTION_MAP_TRANSFER = 168
StatusEnum.ACTION_USE_PLAY_EXPRESSION_ITEM = 169
StatusEnum.ACTION_PLAY_EXPRESSION = 170
StatusEnum.ACTION_ADD_FRIEND = 180
StatusEnum.ACTION_AGREE_ADD_FRIEND = 181
StatusEnum.ACTION_DELETE_FRIEND = 182
StatusEnum.ACTION_DISAGREE_APPLY_FRIEND = 183
StatusEnum.ACTION_FIND_STRANGER = 184
StatusEnum.ACTION_RECOMAND_FRIEND = 185
StatusEnum.ACTION_MENPAI_SKILL = 190
StatusEnum.ACTION_LIFE_SKILL = 191
StatusEnum.ACTION_XIULIAN_SKILL = 192
StatusEnum.ACTION_SHANGHUI_FUN = 193
StatusEnum.ACTION_CHATGIFT_FUN = 194
StatusEnum.ACTION_PET_EXCHANGE = 195
StatusEnum.ACTION_PET_HUASHENG = 196
StatusEnum.ACTION_PET_LEARN_SKILL = 197
StatusEnum.ACTION_PET_LIANGU = 198
StatusEnum.ACTION_PET_USEITEM_GROW = 199
StatusEnum.ACTION_PET_USEITEM_ZIZHI = 200
StatusEnum.ACTION_PET_USEITEM_LIFE = 201
StatusEnum.ACTION_PET_RELEASE = 202
StatusEnum.ACTION_REPORT_TLOG = 203
StatusEnum.ACTION_GET_BOUNTY = 204
StatusEnum.ACTION_REFRESH_BOUNTY = 205
StatusEnum.ACTION_GET_CIRCLE = 206
StatusEnum.ACTION_FACTION_HELP_CIRCLE = 207
StatusEnum.ACTION_CIRCLE_RENXING = 208
StatusEnum.ACTION_GET_FACTION_TASK = 209
StatusEnum.ACTION_REFRESH_TARGET = 210
StatusEnum.ACTION_GET_TARGET_AWARD = 211
StatusEnum.ACTION_GET_NEW_FUNCTION_AWARD = 212
StatusEnum.ACTION_GET_LEVEL_GUIDE_AWARD = 213
StatusEnum.ACTION_ADD_HUN_ITEM = 214
StatusEnum.ACTION_GET_HUN_AWARD = 215
StatusEnum.ACTION_CHALLENGE_QING = 216
StatusEnum.ACTION_RENAME_ROLE = 217
StatusEnum.ACTION_RESET_ROLE_PRO = 218
StatusEnum.ACTION_ADD_BAOSHIDU_MONEY = 219
StatusEnum.ACTION_ADD_BAOSHIDU_ITEM = 220
StatusEnum.ACTION_SWITCH_PROP_SYS = 221
StatusEnum.ACTION_USEALLROLEEXPITEM = 222
StatusEnum.ACTION_USEROLEEXPITEM = 223
StatusEnum.ACTION_USEVIGORITEM = 224
StatusEnum.ACTION_VIGORWORK = 225
StatusEnum.ACTION_JOIN_SEASON_SINGLE = 226
StatusEnum.ACTION_JOIN_SEASON_MULTI = 227
StatusEnum.ACTION_JOIN_SINGLE_TASK = 228
StatusEnum.ACTION_REPLACE_APPELLATION_PRO = 229
StatusEnum.ACTION_REPLACE_TITLE_OR_APPELLATION = 230
StatusEnum.ACTION_GETGIFT = 231
StatusEnum.ACTION_GET_LOGIN_AWARD = 232
StatusEnum.ACTION_GET_LOGIN_SUM_ACTIVITY_INFO = 233
StatusEnum.ACTION_GET_LOGIN_SUM_AWARD = 234
StatusEnum.ACTION_GET_LOGIN_SIGN_ACTIVITY_INFO = 235
StatusEnum.ACTION_GET_LOGIN_SIGN_AWARD = 236
StatusEnum.ACTION_ACTIVE_CREATE_TEAM = 237
StatusEnum.ACTION_GET_MASS_EXP_TASK = 238
StatusEnum.ACTION_MASS_EXP_FILL_GRID = 239
StatusEnum.ACTION_MASS_EXP_GET_AWARD = 240
StatusEnum.ACTION_MASS_EXP_TASK_END = 241
StatusEnum.ACTION_ACTIVE_CREATE_GROUP = 251
StatusEnum.ACTION_ACTIVE_INVITE_JOIN_GROUP = 252
StatusEnum.ACTION_ACTIVE_QUIT_GROUP = 253
StatusEnum.ACTION_ACTIVE_KICK_GROUP_MEMBER = 254
StatusEnum.ACTION_ACTIVE_DISSOLVE_GROUP = 255
StatusEnum.ACTION_ACTIVE_RENAME_GROUP = 256
StatusEnum.ACTION_ACTIVE_CHANGE_GROUP_ANNOUNCEMENT = 257
StatusEnum.ACTION_ACTIVE_SET_MESSAGE_STATE = 258
StatusEnum.ACTION_ACTIVE_GET_ROLE_GROUP_INFO = 259
StatusEnum.ACTION_ACTIVE_GET_SINGLE_GROUP_INFO = 260
StatusEnum.ACTION_BUY_LUCKY_STAR_GIFT = 271
StatusEnum.ACTION_ACTIVE_WING_COLOR = 281
StatusEnum.ACTION_ACTIVE_GET_OFF_WING = 282
StatusEnum.ACTION_ACTIVE_PUT_ON_WING = 283
StatusEnum.ACTION_ACTIVE_RP_WING_PRO_OR_SKILL = 284
StatusEnum.ACTION_ACTIVE_USE_GET_WING_ITEM = 285
StatusEnum.ACTION_ACTIVE_SET_TARGET_SKILL = 286
StatusEnum.ACTION__ACTIVE_SWITCH_OCC_WING_PLAN = 287
StatusEnum.ACTION__ACTIVE_RENAME_WING_PLAN = 288
StatusEnum.ACTION_GET_GRC_FRIEND_LIST = 291
StatusEnum.ACTION_GET_GRC_FRIEND_COUNT_AWARD = 292
StatusEnum.ACTION_GET_GRC_RECEIVE_GIFT_LIST = 293
StatusEnum.ACTION_GET_INVITE_FRIENDS_GIFT = 294
StatusEnum.ACTION_GET_INVITE_FRIENDS_INFO = 295
StatusEnum.ACTION_GET_INVITE_FRIENDS_REBATE_BIND_YUANBAO = 296
StatusEnum.ACTION_GET_SELF_PLAT_VIP_INFO = 297
StatusEnum.ACTION_GRC_RECEIVE_ALL_GIFT = 298
StatusEnum.ACTION_GRC_RECEIVE_GIFT = 299
StatusEnum.ACTION_GRC_SEND_GIFT = 300
StatusEnum.ACTION_GRC_TURN_ON_OFF = 301
StatusEnum.ACTION_GRC_UPDATE_ROLE_INFO = 302
StatusEnum.ACTION_REPORT_QQ_VIP_PAY_INFO = 303
StatusEnum.ACTION_APPLY_ORDER_ID = 311
StatusEnum.ACTION_DEL_FAILURE_ORDER = 312
StatusEnum.ACTION_GET_ACCUM_TOTAL_COST_ACTIVITY_AWARD = 313
StatusEnum.ACTION_GET_FIRST_RECHARGE_AWARD = 314
StatusEnum.ACTION_GET_LEVEL_GROWTH_FUND_ACTIVITY_AWARD = 315
StatusEnum.ACTION_GET_MONTH_CARD_ACTIVITY_AWARD = 316
StatusEnum.ACTION_GET_RMB_GIFT_BAG_ACTIVITY_AWARD = 317
StatusEnum.ACTION_GET_SAVE_AMT_ACTIVITY_AWARD = 318
StatusEnum.ACTION_USE_GIFT_CODE = 350
StatusEnum.ACTION_ACTIVE_JOIN_TEAM_VOIP_ROOM = 351
StatusEnum.ACTION_ACTIVE_REPORT_JOIN_AND_EXIT_TEAM_VOIP_ROOM = 352
StatusEnum.ACTION_BACK_GAME_GET_AWARD = 361
StatusEnum.ACTION_BACK_GAME_GET_AWARD_INFO = 362
StatusEnum.ACTION_BACK_GAME_BUY_GIFT = 363
StatusEnum.ACTION_QYXT_GET_QUESTION_INFO = 371
StatusEnum.ACTION_QYXT_ANSWER_QUESTION = 372
StatusEnum.ACTION_QYXT_HELP_ANSWER_QUESTION = 373
StatusEnum.ACTION_QYXT_SEEK_GANG_HELP = 374
StatusEnum.ACTION_QYXT_GET_EXTRA_AWARD = 375
StatusEnum.ACTION_RECALL_FRIEND_SEND_RECALL = 381
StatusEnum.ACTION_RECALL_FRIEND_GET_BIG_GIFT_AWARD = 382
StatusEnum.ACTION_RECALL_FRIEND_GET_SIGN_AWARD = 383
StatusEnum.ACTION_RECALL_FRIEND_GET_NUM_AWARD = 384
StatusEnum.ACTION_RECALL_GET_SIGN_INFO = 385
StatusEnum.ACTION_ACTIVE_ADJUST_DISPOSITION = 391
StatusEnum.ACTION_ACTIVE_TIP_BR_CAPTAIN = 392
StatusEnum.ACTION__ACTIVE_APPLY_TEAM_BY_MEMBER = 393
StatusEnum.ACTION__ACTIVE_APPLY_TEAM_BY_TEAMID = 394
StatusEnum.ACTION__ACTIVE_ANSWER_TEAM_INVITE = 395
StatusEnum.STATUS_HULA = 450
StatusEnum.ACTION_ACTIVE_GET_HULA_RANK = 451
StatusEnum.STATUS_SERVER_NOT_TIP_LOG_IN_AND_OFF = 411
StatusEnum.ACTION_GET_LOST_EXP_REQ = 471
StatusEnum.ACTION_PAY_NEW_YEAR = 491
StatusEnum.ACTION_ADDICTION_POPUP = 501
StatusEnum.ACTION_REPORT_ONLINE_TIME = 502
StatusEnum.ACTION_GET_DAILY_GIFT = 511
StatusEnum.ACTION_START_VISIBLE_MONSTER = 521
StatusEnum.ACTION_PET_BAG_ITEM_USE = 531
StatusEnum.ACTION_PET_FIGHT = 532
StatusEnum.ACTION_PET_REST = 533
StatusEnum.ACTION_COUPLE_DAILY_AGREE_OR_REFUSE_PINTU = 551
StatusEnum.ACTION_COUPLE_DAILY_AGREE_OR_REFUSE_XINYOULINGXI = 552
StatusEnum.ACTION_COUPLE_DAILY_ANSWER_XINYOULINGXI = 553
StatusEnum.ACTION_COUPLE_DAILY_CLOSE_PANEL = 554
StatusEnum.ACTION_COUPLE_DAILY_GET_AWARD = 555
StatusEnum.ACTION_COUPLE_DAILY_GET_DAILY_INFO = 556
StatusEnum.ACTION_COUPLE_DAILY_TAKE_DAILY_TASK = 557
StatusEnum.STATUS_COUPLY_DAILY = 558
StatusEnum.STATUS_COUPLE_DAILY_PIN_TU = 559
StatusEnum.ACTION_ACTIVE_VALUE_AWARD = 571
StatusEnum.ACTION_ACTIVE_START_MUSIC_GAME = 581
StatusEnum.ACTION_ACTIVE_STOP_MUSIC_GAME = 582
StatusEnum.ACTION_ACTIVE_REPORT_MUSIC_GAME_RESULT = 583
StatusEnum.ACTION_ACTIVE_ATTEND_FETUS_EDUCATION_MUSIC = 591
StatusEnum.ACTION_CHILDHOOD_CHOOSE_INTEREST = 601
StatusEnum.ACTION_CHILDHOOD_LEARN_COURSE = 602
StatusEnum.ACTION_CHILDHOOD_FINISH_COURSE = 603
StatusEnum.ACTION_CHILDHOOD_END_COURSE = 604
StatusEnum.ACTION_CHILDHOOD_CANCEL_COURSE = 605
StatusEnum.ACTION_CHILDHOOD_TO_ADULT = 606
StatusEnum.STATUS_INTERACTIVE_TASK = 650
StatusEnum.ACTION_ACTIVE_START_BUBBLE_GAME = 701
StatusEnum.ACTION_ACTIVE_STOP_BUBBLE_GAME = 702
StatusEnum.ACTION_ACTIVE_REPORT_BUBBLE_GAME_RESULT = 703
StatusEnum.ACTION_ACTIVE_ATTEND_PREPARE_PREGNANCY = 711
StatusEnum.ACTION_ACTIVE_ANSWER_PREPARE_PREGNANCY_INVITE = 712
StatusEnum.ACTION_ACTIVE_SHANG_GONG = 721
StatusEnum.ACTION_ACTIVE_QIU_QIAN = 726
StatusEnum.ACTION_ACTIVE_ATTEND_GUAN_YIN_SHANG_GONG = 731
StatusEnum.ACTION_ACTIVE_ATTEND_GUAN_YIN_QIU_QIAN = 732
StatusEnum.STATUS_GIVE_BIRTH = 750
StatusEnum.ACTION_CHILD_FASHION_BUY = 800
StatusEnum.ACTION_CHILD_FASHION_WEAR = 801
StatusEnum.ACTION_CHILD_FASHION_UNDRESS = 802
StatusEnum.ACTION_CHILD_FASHION_RENEWAL = 803
StatusEnum.ACTION_MAGIC_MARK = 821
StatusEnum.ACTION_AGREE_OR_REFUSE_PREGNANT_BELONG = 831
StatusEnum.ACTION_BABY_TO_CHILD = 832
StatusEnum.ACTION_CANCEL_CHILD_SHOW = 833
StatusEnum.ACTION_CARRY_CHILD = 834
StatusEnum.ACTION_CHANGE_CHILD_NAME = 835
StatusEnum.ACTION_CHILD_COME_TO_ME = 836
StatusEnum.ACTION_CHILD_SHOW = 837
StatusEnum.ACTION_FREE_CHILD = 838
StatusEnum.ACTION_GET_CHILD_DIARY = 839
StatusEnum.ACTION_GIVE_UP_BREED_CHILD = 840
StatusEnum.ACTION_MOVE_CHILD_HOME = 841
StatusEnum.ACTION_QUERY_CHILD = 842
StatusEnum.ACTION_SELECT_CHILD_BELONG = 843
StatusEnum.ACTION_START_BABY_CHILD_BREED = 844
StatusEnum.ACTION_WAKE_UP_BABY = 845
StatusEnum.ACTION_GET_CHILD_LOCATION = 846
StatusEnum.ACTION_USE_ADULT_CHILD_COMPENSATE_ITEM = 847
StatusEnum.ACTION_CHILDREN_RECALL = 848
StatusEnum.ACTION_ADULTHOOD = 881
StatusEnum.STATUS_PREGNANT = 901
StatusEnum.STATUS_SHOW_CHILD = 902
StatusEnum.ACTION_ACTIVE_ATTEND_MONEY_TREE = 903
StatusEnum.ACTION_ACTIVE_PLANT_TREE_GET_DETAIL_INFO = 911
StatusEnum.ACTION_ACTIVE_PLANT_TREE_REMOVE_SPECIAL_STATE = 912
StatusEnum.ACTION_ACTIVE_PLANT_TREE_ADD_POINT = 913
StatusEnum.ACTION_ACTIVE_PLANT_TREE_GET_SECTION_COMPLETE_AWARD = 914
StatusEnum.ACTION_ACTIVE_PLANT_TREE_GET_ACTIVITY_COMPLETE_AWARD = 915
StatusEnum.ACTION_ACTIVE_PLANT_TREE_GET_ONLINE_REWARD_POINT = 916
StatusEnum.ACTION_ACTIVE_PLANT_TREE_REFRESH_SPECIAL_STATE = 917
StatusEnum.ACTION_ACTIVE_PLANT_TREE_GET_RELATED_ROLE_SPECIAL_STATE = 918
StatusEnum.STATUS_MEMORY_COMPETITION = 921
StatusEnum.ACTION_MEMORY_COMPETITION_QUESTION_HELP = 922
StatusEnum.ACTION_MEMORY_COMPETITION_QUESTION_SEEK_HELP = 923
StatusEnum.ACTION_ANSWER_MEMORY_COMPETITION_QUESTION = 924
StatusEnum.ACTION_ATTEN_ROMANTIC_DANCE = 925
StatusEnum.ACTION_ACTIVE_FOOLS_DAY_MAKE_CHEST = 931
StatusEnum.ACTION_ACTIVE_FOOLS_DAY_OPEN_CHEST = 932
StatusEnum.ACTION_ACTIVE_FOOLS_DAY_GET_ACTIVITY_INFO = 933
StatusEnum.ACTION_ACTIVE_FOOLS_DAY_REFRESH_ALTERNATIVE_BUFF_CFG_IDS = 934
StatusEnum.ACTION_ACTIVE_FOOLS_DAY_GET_TITLE = 935
StatusEnum.ACTION_SIGN_PRECIOUS_DRAW_LOTTERY = 941
StatusEnum.ACTION_SIGN_PRECIOUS_FORCE_ARRIVE_BOX = 942
StatusEnum.ACTION_SIGN_PRECIOUS_OPEN_LUCKY_BOX = 943
StatusEnum.ACTION_ACTIVE_FEI_SHENG_ATTEND_COMMIT_ITEM_ACTIVITY = 951
StatusEnum.ACTION_ACTIVE_FEI_SHENG_GET_ITEM_IN_DEVELOP_ITEM_ACTIVITY = 952
StatusEnum.ACTION_ACTIVE_FEI_SHENG_DEVELOP_ITEM_IN_DEVELOP_ITEM_ACTIVITY = 953
StatusEnum.ACTION_ACTIVE_FEI_SHENG_COMMIT_ITEM_IN_DEVELOP_ITEM_ACTIVITY = 954
StatusEnum.ACTION_ACTIVE_FEI_SHENG_ATTEND_TASK_ACTIVITY = 955
StatusEnum.ACTION_ACTIVE_FEI_SHENG_ATTEND_QING_YUN_ZHI_ACTIVITY = 956
StatusEnum.ACTION_ACTIVE_FEI_SHENG_ATTEND_COMMIT_PET_ACTIVITY = 957
StatusEnum.ACTION_ACTIVE_FEI_SHENG_ATTEND_FIGHT_ACTIVITY = 958
StatusEnum.STATUS_FEI_SHENG_ATTEND_ZHU_XIAN_JIAN_ZHEN_ACTIVITY = 959
StatusEnum.ACTION_CHANGE_FAHSION_DRESS_PROPERTY = 971
StatusEnum.ACTION_EXTEND_FASHION_DRESS_TIME = 972
StatusEnum.ACTION_PUT_OFF_FASHION_DRESS = 973
StatusEnum.ACTION_PUT_ON_FASHION_DRESS = 974
StatusEnum.ACTION_SELECT_FASHION_DRESS_PROPERTY = 975
StatusEnum.ACTION_UN_SELECT_FASHION_DRESS_PROPERTY = 976
StatusEnum.ACTION_UNLOCK_FASHION_DRESS_PROPERTY = 977
StatusEnum.ACTION_AWARD_THEME_FASHION_DRESS = 978
StatusEnum.ACTION_ADD_CLOTH_COLOR = 991
StatusEnum.ACTION_DELETE_CLOTH = 992
StatusEnum.ACTION_GET_ROLE_CLOTH_LIST = 993
StatusEnum.ACTION_USE_THIS_DYE_COLOR = 994
StatusEnum.ACTION_MEN_PAI_STAR_GET_INFO = 1001
StatusEnum.ACTION_MEN_PAI_STAR_GET_VOTE_AWARD_INFO = 1002
StatusEnum.ACTION_MEN_PAI_STAR_START_CAMPAIGN_FIGHT = 1003
StatusEnum.ACTION_MEN_PAI_STAR_START_VOTE_FIGHT = 1004
StatusEnum.ACTION_MEN_PAI_STAR_SET_VOTE_AWARD_INFO = 1005
StatusEnum.ACTION_MEN_PAI_STAR_VOTE = 1006
StatusEnum.ACTION_MEN_PAI_STAR_CAMPAIGN_CHART = 1007
StatusEnum.ACTION_MEN_PAI_STAR_TARGET_ROLE_CAMPAIGN_CHART = 1008
StatusEnum.ACTION_MEN_PAI_STAR_WORLD_CANVASS = 1009
StatusEnum.ACTION_MEN_PAI_STAR_GANG_CANVASS = 1010
StatusEnum.ACTION_MEN_PAI_STAR_GET_STAR_CHART = 1011
StatusEnum.STATUS_FACTION_PVE = 1021
StatusEnum.ACTION_COST_ITEM_ADD_MOUNTS_SCORE = 1031
StatusEnum.ACTION_COST_MOUNTS_ADD_MOUNTS_SCORE = 1032
StatusEnum.ACTION_EXTEND_MOUNTS_TIME = 1033
StatusEnum.ACTION_MOUNTS_ACTIVE_STAR_LIFE = 1034
StatusEnum.ACTION_MOUNTS_BATTLE = 1035
StatusEnum.ACTION_MOUNTS_COST_ITEM_RANK_UP = 1036
StatusEnum.ACTION_MOUNTS_DYE = 1037
StatusEnum.ACTION_MOUNTS_PROTECT_PET = 1038
StatusEnum.ACTION_MOUNTS_REFRESH_PASSIVE_SKILL = 1039
StatusEnum.ACTION_MOUNTS_REPLACE_PASSIVE_SKILL = 1040
StatusEnum.ACTION_MOUNTS_REPLACE_PROTECT_PET = 1041
StatusEnum.ACTION_MOUNTS_SELECT_ORNAMENT = 1042
StatusEnum.ACTION_MOUNTS_SET_BATTLE_STATE = 1043
StatusEnum.ACTION_MOUNTS_UN_BATTLE = 1044
StatusEnum.ACTION_MOUNTS_UN_PROTECT_PET = 1045
StatusEnum.ACTION_MOUNTS_RIDE = 1046
StatusEnum.ACTION_UN_LOCK_MOUNTS = 1047
StatusEnum.ACTION_UN_RIDE_MOUNTS = 1048
StatusEnum.ACTION_PROTECT_PET_EXPAND_SIZE = 1049
StatusEnum.ACTION_RIDE_MULTI_ROLE_MOUNTS = 1050
StatusEnum.ACTION_UNRIDE_MULTI_ROLE_MOUNTS = 1051
StatusEnum.ACTION_QUERY_CHAT_IN_PACKET = 1052
StatusEnum.ACTION_ITEM_CLICK_REMOVE = 1061
StatusEnum.ACTION_GENIUS_GET_SERIES_INFO = 1071
StatusEnum.ACTION_GENIUS_SAVE_PLAN = 1072
StatusEnum.ACTION_GENIUS_SWITCH_PLAN = 1073
StatusEnum.ACTION_GENIUS_RESET_PLAN = 1074
StatusEnum.ACTION_GENIUS_USE_ITEM = 1075
StatusEnum.ACTION_LUCKY_BAG_EXCHANGE_SCORE = 1091
StatusEnum.ACTION_BLESS_GET_ACTIVITY_INFO = 1101
StatusEnum.ACTION_BLESS_ACTIVE_BLESS = 1102
StatusEnum.ACTION_AXE_ATTEND_AXE_ACTIVITY = 1111
StatusEnum.ACTION_AXE_USE_AXE_ITEM = 1112
StatusEnum.ACTION_AXE_UNLOCK_AXE_ACTIVITY = 1113
StatusEnum.STATUS_SINGLE_CROSS_TEAM_MATCH = 1121
StatusEnum.STATUS_TEAM_CROSS_TEAM_MATCH = 1122
StatusEnum.STATUS_TEAM_CROSS_TEAM_READY = 1123
StatusEnum.ACTION_GET_EXPLOIT_AWARD = 1131
StatusEnum.ACTION_ATTEND_MYSTERY_VISITOR_ACTIVITY = 1141
StatusEnum.ACTION_COURT_YARD_LEVEL_UP = 1151
StatusEnum.ACTION_RECECLE_FURNITURE = 1152
StatusEnum.ACTION_NPC_REWARD = 1181
StatusEnum.ACTION_ITEM_USE_EMBRYO = 1191
StatusEnum.ACTION_ANIMAL_EMBRYO_HATCH = 1192
StatusEnum.ACTION_ANIMAL_EMBRYO_TO_ANIMAL = 1193
StatusEnum.ACTION_ANIMAL_MATE = 1194
StatusEnum.ACTION_ANIMAL_GET_AWARD = 1195
StatusEnum.ACTION_ANIMAL_RENAME = 1196
StatusEnum.ACTION_ANIMAL_FREE = 1197
StatusEnum.ACTION_ANIMAL_GET_MATE_INFO = 1198
StatusEnum.ACTION_DRAW_AND_GUESS_DRAW = 1211
StatusEnum.ACTION_DRAW_AND_GUESS_GUESS = 1212
StatusEnum.ACTION_CREATE_CORPS = 1221
StatusEnum.ACTION_INVITE_CORPS = 1222
StatusEnum.ACTION_JOIN_CORPS = 1223
StatusEnum.ACTION_LEAVE_CORPS = 1224
StatusEnum.ACTION_FIRE_CORPS_MEMBER = 1225
StatusEnum.ACTION_CHANGE_CORPS_CAPTAIN = 1226
StatusEnum.ACTION_EDIT_CORPS = 1227
StatusEnum.ACTION_ACTIVE_CROSS_BATTLE_OWN_REGISTER = 1301
StatusEnum.ACTION_ACTIVE_CROSS_BATTLE_OWN_UNREGISTER = 1302
StatusEnum.ACTION_ACTIVE_CROSS_BATTLE_OWN_VOTE = 1303
StatusEnum.ACTION_ACTIVE_CROSS_BATTLE_OWN_CANVASS = 1304
StatusEnum.STATUS_CROSS_BATTLE_OWN_ROUND_ROBIN = 1305
StatusEnum.ACTION_FABAO_AUTO_RANK = 1351
StatusEnum.STATUS_LONNG_BOAT_RACE = 1361
StatusEnum.STATUS_SELECTION_OF_FINAL_MATCH = 1371
StatusEnum.ACTION_FLOOR_FIGHT = 1381
StatusEnum.ACTION_GET_CHILDREN_CHART = 1391
StatusEnum.ACTION_GET_CHILDREN_TOP_MODEL = 1392
StatusEnum.ACTION_ITEM_USE_SHAPE_SHIFT = 1401
StatusEnum.ACTION_ACTIVE_CROSS_BATTLE_ROUND_ROBIN_STAGE_BET = 1411
StatusEnum.ACTION_ACTIVE_CROSS_BATTLE_ROUND_ROBIN_STAGE_GET_BET_INFO = 1412
StatusEnum.ACTION_ACTIVE_CROSS_BATTLE_SELECTION_STAGE_BET = 1413
StatusEnum.ACTION_ACTIVE_CROSS_BATTLE_SELECTION_STAGE_GET_BET_INFO = 1414
StatusEnum.ACTION_ACTIVE_CROSS_BATTLE_FINAL_STAGE_BET = 1415
StatusEnum.ACTION_ACTIVE_CROSS_BATTLE_FINAL_STAGE_GET_BET_INFO = 1416
StatusEnum.ACTION_ACTIVE_CROSS_BATTLE_GET_BET_RANK = 1417
StatusEnum.ACTION_CROSS_BATTLE_DRAW_LOTS_ZONE = 1431
StatusEnum.STATUS_CROSS_SERVER_POINT_RACE = 1441
StatusEnum.ACTION_CROSS_BATTLE_POINT_RACE_READY = 1442
StatusEnum.ACTION_CROSS_BATTLE_POINT_GET_RANK = 1443
StatusEnum.ACTION_CROSS_BATTLE_POINT_GET_PANEL_INFO = 1444
StatusEnum.STATUS_ROAM_SERVER_POINT_RACE = 1445
StatusEnum.STATUS_CROSS_COMPETE = 1501
StatusEnum.STATUS_CROSS_COMPETE_ROAM = 1502
StatusEnum.STATUS_SINGLE_BATTLE = 1511
StatusEnum.STATUS_SINGLE_BATTLE_DEAD = 1512
StatusEnum.STATUS_SINGLE_BATTLE_REVIVE_PROTECT = 1513
StatusEnum.STATUS_SINGLE_BATTLE_GRABING = 1514
StatusEnum.ACTION_ACTIVE_LEAVE_SINGLE_BATTLE = 1515
StatusEnum.STATUS_SINGLE_BATTLE_GATHERING = 1516
StatusEnum.STATUS_CROSS_BATTLE_KNOCK_OUT_PREPARE = 1551
StatusEnum.ACTION_LEAVE_CROSS_BATTLE_KNOCK_OUT_MAP = 1552
StatusEnum.ACTION_GET_KNOCK_OUT_HISTORY_CORPS_INFO = 1553
StatusEnum.ACTION_GET_KNOCK_OUT_HISTORY_TOP_THREE_INFO = 1554
StatusEnum.ACTION_GET_KNOCK_OUT_HISTORY_FIGHT_INFO = 1555
StatusEnum.ACTION_GET_KNOCK_OUT_FIGHT_INFO = 1556
StatusEnum.ACTION_GET_KNOCK_OUT_FIGHT_STAGE_INFO = 1557
StatusEnum.ACTION_GET_KNOCK_OUT_PANEL_INFO = 1558
StatusEnum.ACTION_GET_OWN_SERVER_KNOCK_OUT_PANEL_INFO = 1559
StatusEnum.ACTION_ENTER_KNOCK_OUT_MAP = 1560
StatusEnum.STATUS_CHESS_GAME = 1561
StatusEnum.STATUS_CROSS_FIELD_MATCH = 1581
StatusEnum.ACTION_ACTIVE_GET_SINGLE_CROSS_FIELD_RANK = 1582
StatusEnum.STATUS_SINGLE_CROSS_FIELD_ROAM = 1583
StatusEnum.ACTION_ACTIVE_JOIN_SINGLE_CROSS_FIELD_MATCH = 1584
StatusEnum.ACTION_ACTIVE_CANCEL_SINGLE_CROSS_FIELD_MATCH = 1585
StatusEnum.ACTION_JEWEL_COMPOSE = 1601
StatusEnum.ACTION_JEWEL_COMPOSE_AUTO = 1602
StatusEnum.ACTION_JEWEL_MOUNT = 1603
StatusEnum.ACTION_JEWEL_UN_MOUNT = 1604
StatusEnum.ACTION_JEWEL_UPGRADE = 1605
StatusEnum.ACTION_JEWEL_TRANSFER_COUNT = 1606
StatusEnum.ACTION_JEWEL_TRANSFER_PRICE = 1607
StatusEnum.ACTION_JEWEL_TRANSFER = 1608
StatusEnum.ACTION_WUSHI_PUT_ON = 1611
StatusEnum.ACTION_WUSHI_PUT_OFF = 1612
StatusEnum.ACTION_WUSHI_UPGRADE = 1613
StatusEnum.ACTION_WUSHI_USE_ITEM = 1614
StatusEnum.STATUS_PK_ENABLED = 1621
StatusEnum.STATUS_PK_PROTECTION = 1622
StatusEnum.STATUS_PK_FORCE_PROTECTION = 1623
StatusEnum.ACTION_START_PK_ACTIVELY = 1624
StatusEnum.ACTION_START_PK_PASSIVELY = 1625
StatusEnum.ACTION_BUY_MORAL_VALUE = 1626
StatusEnum.ACTION_ACCEPT_MORAL_VALUE_TASK = 1627
StatusEnum.ACTION_USE_REVENGE_ITEM = 1628
StatusEnum.ACTION_USE_REVENGE_ITEM_ASSIGN_ROLE = 1629
StatusEnum.ACTION_SHITU_TASK = 1641
StatusEnum.ACTION_SHITU_ACTIVE_VALUE = 1642
StatusEnum.ACTION_SHITU_RECOMMEND = 1643
StatusEnum.STATUS_PK_HONGMING = 1651
StatusEnum.ACTION_WANTED = 1652
StatusEnum.ACTION_SHOW_WANTED_LIST = 1653
StatusEnum.ACTION_BE_WANTED = 1654
StatusEnum.ACTION_QUERY_WANTED_ROLE_STATUS = 1655
StatusEnum.STATUS_PK_PRISON = 1661
StatusEnum.STATUS_PK_PRISON_PROTECT = 1662
StatusEnum.ACTION_ENTER_PRISON_MAP = 1663
StatusEnum.ACTION_JAIL_BREAK = 1664
StatusEnum.ACTION_JAIL_DELIVERY = 1665
StatusEnum.ACTION_SHOW_PRISON_LIST = 1666
StatusEnum.ACTION_GET_IN_JAIL_LEFT_TIME = 1667
StatusEnum.ACTION_LEAVE_PRISON_MAP = 1668
StatusEnum.STATUS_LEAVE_TEAM_LEAVE_JAIL = 1669
StatusEnum.STATUS_LEAVE_TEAM_ENTER_JAIL = 1670
StatusEnum.ACTION_BACK_GAME_ACTIVITY_SIGN = 1671
StatusEnum.ACTION_BACK_GAME_ACTIVITY_GET_POINT_AWARD = 1672
StatusEnum.ACTION_BACK_GAME_ACTIVITY_GET_EXP_AWARD = 1673
StatusEnum.ACTION_BACK_GAME_ACTIVITY_ACCEPT_TASK = 1674
StatusEnum.ACTION_BACK_GAME_ACTIVITY_GET_AWARD = 1675
StatusEnum.ACTION_BACK_GAME_ACTIVITY_GITF_BUY = 1676
StatusEnum.ACTION_BACK_GAME_ACTIVITY_USE_MANEKI_TOKEN = 1677
StatusEnum.ACTION_GET_QUESTION_VOICE = 1681
StatusEnum.ACTION_ANSWER_QUESTION_VOICE = 1682
StatusEnum.ACTION_GET_LAST_QUESTION_VOICE = 1683
StatusEnum.ACTION_PARTNER_YUANSHEN_ATTACH_PARTNER = 1691
StatusEnum.ACTION_PARTNER_YUANSHEN_IMPROVE = 1692
StatusEnum.ACTION_AGREE_OR_REFUSE_QING_YUAN = 1701
StatusEnum.ACTION_CANCEL_QING_YUAN = 1702
StatusEnum.ACTION_GET_QING_YUAN = 1703
StatusEnum.ACTION_MAKE_QING_YUAN = 1704
StatusEnum.ACTION_RELIEVE_QING_YUAN = 1705
StatusEnum.ACTION_AGREE_OR_REFUSE_SHOU_TU = 1711
StatusEnum.ACTION_APPRENTICE_RELIEVE_SHI_TU_RELATION = 1712
StatusEnum.ACTION_CANCEL_SHOU_TU = 1713
StatusEnum.ACTION_CHU_SHI_CONDITION_CHECK = 1714
StatusEnum.ACTION_CHU_SHI_REQ = 1715
StatusEnum.ACTION_GET_APPRENTICE_NUM_AWARD = 1716
StatusEnum.ACTION_GET_CHU_SHI_APPRENTICE_INFO = 1717
StatusEnum.ACTION_GET_CLASS_MATE_INFO = 1718
StatusEnum.ACTION_GET_MASTER_CHART = 1719
StatusEnum.ACTION_MASTER_RELIEVE_SHI_TU_RELATION = 1720
StatusEnum.ACTION_PAY_RESPECT = 1721
StatusEnum.ACTION_REPLY_PAY_RESPECT = 1722
StatusEnum.ACTION_SHOU_TU_CONDITION_CHECK = 1723
StatusEnum.ACTION_SHOU_TU_REQ = 1724
StatusEnum.ACTION_LEGOUSHANGCHENG_GET_BUY_INFO = 1731
StatusEnum.ACTION_LEGOUSHANGCHENG_BUY_GOODS = 1732
StatusEnum.STATUS_ROAM_KNOCK_OUT = 1741
StatusEnum.ACTION_AVATAR_RELATED = 1751
StatusEnum.ACTION_CHINESE_VALENTINE = 1761
StatusEnum.ACTION_FLOWER_PARADE = 1771
StatusEnum.ACTION_PET_SOUL = 1800
StatusEnum.ACTION_PET_HUA_SHENG_YUAN_BAO_MAKE_UP_VICE = 1801
StatusEnum.ACTION_USE_CHAT_BUBBLE_ITEM = 1811
StatusEnum.ACTION_PUT_ON_CHAT_BUBBLE = 1812
StatusEnum.ACTION_PUT_OFF_CHAT_BUBBLE = 1813
StatusEnum.ACTION_BUY_FRIENDS_CIRCLE_TREASURE = 1821
StatusEnum.ACTION_GIVE_FRIENDS_CIRCLE_GIFT = 1822
StatusEnum.ACTION_PLACE_FRIENDS_CIRCLE_ORNAMENT_ITEM = 1823
StatusEnum.ACTION_TREAD_FRIENDS_CIRCLE = 1824
StatusEnum.ACTION_USE_ORNAMENT_ITEM = 1825
StatusEnum.ACTION_GET_POPULARITY_CHART = 1826
StatusEnum.STATUS_CROSS_SERVER_TREAD = 1827
StatusEnum.ACTION_FRIENDS_CIRCLE_ADD_BLACK = 1828
StatusEnum.ACTION_FRIENDS_CIRCLE_REMOVE_BLACK = 1829
StatusEnum.STATUS_FRIENDS_CIRCLE_REPAIR_TREAD = 1830
StatusEnum.STATUS_INTERACTION_INVITING = 1831
StatusEnum.STATUS_INTERACTION_INVITED = 1832
StatusEnum.ACTION_START_INTERACTION = 1833
StatusEnum.STATUS_INTERACTION_ACCEPTED = 1834
StatusEnum.ACTION_XIAO_HUI_KUAI_PAO_INNER_DRAW = 1841
StatusEnum.ACTION_XIAO_HUI_KUAI_PAO_INNER_INFO = 1842
StatusEnum.ACTION_XIAO_HUI_KUAI_PAO_OUTER_DRAW = 1843
StatusEnum.ACTION_XIAO_HUI_KUAI_PAO_OUTER_INFO = 1844
StatusEnum.ACTION_XIAO_HUI_KUAI_PAO_POINT_EXCHANGE = 1845
StatusEnum.ACTION_XIAO_HUI_KUAI_PAO_POINT_EXCHANGE_INFO = 1846
StatusEnum.ACTION_RECEIVE_BIRTHDAY_PRAY_REWARD = 1851
StatusEnum.STATUS_IN_INVITE = 1861
StatusEnum.ACTION_SEND_INVITE = 1862
StatusEnum.ACTION_APPLY_INVITE = 1863
StatusEnum.STATUS_IN_BREAK_EGG = 1864
StatusEnum.ACTION_BREAK_EGG = 1865
StatusEnum.ACTION_COOKIE_CAKE = 1871
StatusEnum.ACTION_SEND_SKY_LANTERN = 1881
StatusEnum.ACTION_PUT_ON_AIRCRAFT = 1891
StatusEnum.ACTION_TAKE_OFF_AIRCRAFT = 1892
StatusEnum.ACTION_DYE_AIRCRAFT = 1893
StatusEnum.ACTION_USE_AIRCRAFT = 1894
StatusEnum.ACTION_GET_GROUP_SHOPPING_INFO = 1901
StatusEnum.ACTION_CREATE_SHOPPING_GROUP = 1902
StatusEnum.ACTION_JOIN_SHOPPING_GROUP = 1903
StatusEnum.ACTION_GROUP_SHOPPING_DIRECT_BUY = 1904
StatusEnum.ACTION_YUAN_BAO_CHANGE_BANG_GONG = 1911
StatusEnum.ACTION_RECALL_RECALL_FRIEND = 1931
StatusEnum.ACTION_RECALL_BIND_FRIEND = 1932
StatusEnum.ACTION_RECALL_BIND_VITALITY_REWARD = 1933
StatusEnum.ACTION_RECALL_GET_BIND_VITALITY_INFO = 1934
StatusEnum.ACTION_RECALL_GET_BIND_REBATE = 1935
StatusEnum.ACTION_RECALL_GET_BIND_REBATE_INFO = 1936
StatusEnum.ACTION_ACTIVITY_POINT_EXCHANGE_GET_MANUAL_REFRESH_COUNT_INFO = 1951
StatusEnum.ACTION_ACTIVITY_POINT_EXCHANGE_MANUAL_REFRESH = 1952
StatusEnum.ACTION_ACTIVITY_POINT_EXCHANGE_GET_EXCHANGE_COUNT_INFO = 1953
StatusEnum.ACTION_ACTIVITY_POINT_EXCHANGE_GET_SOLD_OUT_INFO = 1954
StatusEnum.ACTION_ACTIVITY_POINT_EXCHANGE_GET_MALL_INFO = 1955
StatusEnum.ACTION_ACTIVITY_POINT_EXCHANGE_POINT_EXCHANGE = 1956
StatusEnum.ACTION_UNLOCK_CHANGE_MODEL_CARD = 1971
StatusEnum.ACTION_USE_CHANGE_MODEL_CARD = 1972
StatusEnum.ACTION_CANCEL_CHANGE_MODEL_CARD = 1973
StatusEnum.ACTION_SET_CHANGE_MODEL_CARD_VISIBLE = 1974
StatusEnum.ACTION_SET_CHANGE_MODEL_CARD_INVISIBLE = 1975
StatusEnum.ACTION_DECOMPOSE_CHANGE_MODEL_CARD = 1976
StatusEnum.ACTION_UPGRADE_CHANGE_MODEL_CARD = 1977
StatusEnum.ACTION_LOTTERY_CHANGE_MODEL_CARD = 1978
StatusEnum.ACTION_ACTIVE_ATTEND_INDIANA = 1991
StatusEnum.ACTION_ACTIVE_GET_ATTEND_INDIANA_NUM = 1992
StatusEnum.ACTION_ACTIVE_GET_INDIANA_AWARD_INFO = 1993
StatusEnum.ACTION_ACTIVE_GET_INDIANA_LOGS = 1994
StatusEnum.ACTION_ACTIVE_GET_ROLE_ATTEND_INDIANA_INFO = 1995
StatusEnum.STATUS_FRIENDS_CIRCLE_PLACE_TREASURE_BOX = 2001
StatusEnum.ACTION_LIFE_SKILL_ACTIVITY_CREATE = 2011
StatusEnum.ACTION_USE_EQUIPMENT_BLESS_ITEM = 2021
StatusEnum.ACTION_ACTIVE_GET_ALL_LOTTO_WARM_UP_AWARD = 2031
StatusEnum.ACTION_ACTIVE_GET_ALL_LOTTO_LOGS = 2032
StatusEnum.ACTION_AUCTION_BID = 2041
StatusEnum.ACTION_GET_AUCTION_INFO = 2042
StatusEnum.ACTION_GET_AUCTION_ITEM_INFO = 2043
StatusEnum.ACTION_GET_BID_RANK = 2044
StatusEnum.STATUS_COOK = 2051
StatusEnum.ACTION_ACTIVITY_COMPENSATE = 2061
StatusEnum.STATUS_BANDSTAND = 2081
StatusEnum.ACTION_PET_FIGHT_IMPROVE_FORMATION = 2091
StatusEnum.ACTION_PET_FIGHT_UNLOCK_SKILL = 2092
StatusEnum.ACTION_LIFE_SKILL_LEVEL_RESET = 2101
StatusEnum.ACTION_PET_ARENA_GET_INFO = 2111
StatusEnum.ACTION_PET_ARENA_REFRESH_OPPONENT = 2112
StatusEnum.ACTION_PET_ARENA_BUY_COUNT = 2113
StatusEnum.ACTION_PET_ARENA_GET_DEFEND_INFO = 2114
StatusEnum.ACTION_PET_ARENA_START_FIGHT = 2115
StatusEnum.ACTION_PET_ARENA_GET_CHART = 2116
StatusEnum.ACTION_PET_ARENA_GET_RECORD = 2117
StatusEnum.ACTION_PET_ARENA_VIEW_RECORD = 2118
StatusEnum.ACTION_PET_ARENA_GET_AWARD = 2119
StatusEnum.ACTION_PET_MARK_UNLOCK = 2131
StatusEnum.ACTION_PET_MARK_EQUIP = 2132
StatusEnum.ACTION_PET_MARK_UNEQUIP = 2133
StatusEnum.ACTION_PET_MARK_UPGRADE_WITH_MARK = 2134
StatusEnum.ACTION_PET_MARK_UPGRADE_WITH_ITEM = 2135
StatusEnum.ACTION_PET_MARK_UPGRADE_USE_ALL = 2136
StatusEnum.ACTION_PET_MARK_DECOMPOSE_MARK = 2137
StatusEnum.ACTION_PET_MARK_DECOMPOSE_ITEM = 2138
StatusEnum.ACTION_PET_MARK_DECOMPOSE_ALL = 2139
StatusEnum.ACTION_PET_MARK_LOTTERY = 2140
StatusEnum.STATUS_BALL_BATTLE_IN_PREPARE_MAP = 2161
StatusEnum.STATUS_BALL_BATTLE_IN_GAME_MAP = 2162
StatusEnum.STATUS_TREASURE_HUNT = 2191
StatusEnum.ACTION_ATTEND_TREASURE_HUNT = 2192
StatusEnum.ACTION_LEAVE_TREASURE_HUNT = 2193
StatusEnum.ACTION_TIME_LIMIT_GIFT__GET_GIFT_INFO = 2201
StatusEnum.ACTION_TIME_LIMIT_GIFT__GIFT_TO_FRIENDS = 2202
StatusEnum.ACTION_CHRISTMAS_STOCKING_INFO_GET = 2231
StatusEnum.ACTION_CHRISTMAS_STOCKING_HANG = 2232
StatusEnum.ACTION_CHRISTMAS_STOCKING_AWARD_GET = 2233
StatusEnum.ACTION_SWITCH_PET_MODEL = 2261
StatusEnum.ACTION_DELETE_PET_MODEL = 2262
StatusEnum.ACTION_DRAW_CARNIVAL__GET_DRAW_INFO = 2271
StatusEnum.ACTION_DRAW_CARNIVAL__DRAW = 2272
function StatusEnum:ctor()
end
function StatusEnum:marshal(os)
end
function StatusEnum:unmarshal(os)
end
return StatusEnum

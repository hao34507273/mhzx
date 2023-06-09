local UInt64 = require("Utility.UInt64")
local bit = require("bit")
local band = bit.band
_G.GP_MOVE_FLAG = {
  NONE = 0,
  NO_OPERATE = 32,
  NORMAL_SHIFT = 16,
  STOP = 64,
  WALK = 128,
  POS_NOTIFY = 256,
  RUN = 512,
  KNOCKBACK = 1024,
  DIR_DIFF = 2048,
  SHIFT_LEFT = 4096,
  EXTRA_SYNCPOS = 8192,
  SHIFT_RIGHT = 16384
}
_G.GP_STATE = {
  GP_STATE_BIND = LuaUInt64.Make(0, 1),
  GP_STATE_DEAD = LuaUInt64.Make(0, 2),
  GP_STATE_EXTEND = LuaUInt64.Make(0, 4),
  GP_STATE_ALIAS = LuaUInt64.Make(0, 8),
  GP_STATE_SCENE_SPECIAL_OBJECT = LuaUInt64.Make(0, 16),
  GP_STATE_VISUAL_EFFECT = LuaUInt64.Make(0, 32),
  GP_STATE_ACTION = LuaUInt64.Make(0, 64),
  GP_STATE_ALERT_MODE = LuaUInt64.Make(0, 128),
  GP_STATE_SPEC_BODY_SIZE = LuaUInt64.Make(0, 256),
  GP_STATE_ALIAS = LuaUInt64.Make(0, 512),
  GP_STATE_INVISIBLE = LuaUInt64.Make(0, 1024),
  GP_STATE_ADV_MODE = LuaUInt64.Make(0, 2048),
  GP_STATE_FAMILY = LuaUInt64.Make(0, 4096),
  GP_STATE_FACTION = LuaUInt64.Make(0, 8192),
  GP_STATE_BOOTH = LuaUInt64.Make(0, 16384),
  GP_STATE_TRANSFORM = LuaUInt64.Make(0, 32768),
  GP_STATE_TITLE = LuaUInt64.Make(0, 65536),
  GP_STATE_SPOUSE = LuaUInt64.Make(0, 131072),
  GP_STATE_BINDLOVER = LuaUInt64.Make(0, 262144),
  GP_STATE_FASHION = LuaUInt64.Make(0, 524288),
  GP_STATE_TEAM = LuaUInt64.Make(0, 1048576),
  GP_STATE_TEAMLEADER = LuaUInt64.Make(0, 2097152),
  GP_STATE_GAMEMASTER = LuaUInt64.Make(0, 4194304),
  GP_STATE_PVP_ENABLE = LuaUInt64.Make(0, 8388608),
  GP_STATE_IN_DUEL_MODE = LuaUInt64.Make(0, 16777216),
  GP_STATE_SUTRA = LuaUInt64.Make(0, 33554432),
  GP_STATE_INSTANCE_SPECTATE = LuaUInt64.Make(0, 67108864),
  GP_STATE_NPC_CORPSE = LuaUInt64.Make(0, 134217728),
  GP_STATE_NPC_NAME = LuaUInt64.Make(0, 268435456),
  GP_STATE_NPC_HERO = LuaUInt64.Make(0, 536870912),
  GP_STATE_NPC_HAVE_ASCR = LuaUInt64.Make(0, 1073741824),
  GP_STATE_ESCORT_CONVOY_NPC = LuaUInt64.Make(0, 2147483648),
  GP_STATE_NPC_SPECIALTY = LuaUInt64.Make(1, 0),
  GP_STATE_NPC_HAVE_OWNER = LuaUInt64.Make(2, 0),
  GP_STATE_NPC_INVINC_CANNOTSELECT = LuaUInt64.Make(4, 0),
  GP_STATE_HOME_UPGRADE = LuaUInt64.Make(16, 0),
  GP_STATE_LOCK_ALL = LuaUInt64.Make(32, 0),
  GP_STATE_ESCORT_TRAP = LuaUInt64.Make(64, 0),
  GP_STATE_IN_AUTO_MOVE = LuaUInt64.Make(128, 0),
  GP_STATE_RUSH = LuaUInt64.Make(2048, 0),
  GP_STATE_QINGGONG = LuaUInt64.Make(4096, 0),
  GP_STATE_NPC_PLAYER = LuaUInt64.Make(16384, 0),
  GP_LOST_CONNECT = LuaUInt64.Make(32768, 0),
  GP_STATE_IN_PARRY = LuaUInt64.Make(65536, 0),
  GP_STATE_IN_CHUPOZHAN = LuaUInt64.Make(131072, 0),
  GP_STATE_IN_AUTO_COMBAT = LuaUInt64.Make(262144, 0),
  GP_STATE_NATION_ESCORT = LuaUInt64.Make(524288, 0),
  GP_STATE_MOUNT = LuaUInt64.Make(1048576, 0),
  GP_STATE_QUIET = LuaUInt64.Make(2097152, 0),
  GP_STATE_ROAM_OBJECT = LuaUInt64.Make(2147483648, 0),
  GP_STATE_NATION_OFFICER = LuaUInt64.Make(4194304, 0)
}
do
  local OBJPREFLAG_PLAYER = LuaUInt64.Make(0, 0)
  local OBJPREFLAG_NPC = LuaUInt64.Make(16777216, 0)
  local OBJPREFLAG_MATTER = LuaUInt64.Make(33554432, 0)
  local OBJPREFLAG_SUBOBJECT = LuaUInt64.Make(50331648, 0)
  local OBJPREFLAG_ALL = LuaUInt64.Make(4278190080, 0)
  function _G.ISPLAYERID(nID)
    return LuaUInt64.And(nID, OBJPREFLAG_ALL) == OBJPREFLAG_PLAYER
  end
  function _G.ISNPCID(nID)
    return LuaUInt64.And(nID, OBJPREFLAG_ALL) == OBJPREFLAG_NPC
  end
  function _G.ISMATTERID(nID)
    return LuaUInt64.And(nID, OBJPREFLAG_ALL) == OBJPREFLAG_MATTER
  end
  function _G.ISSUBOBJECTID(nID)
    return LuaUInt64.And(nID, OBJPREFLAG_ALL) == OBJPREFLAG_SUBOBJECT
  end
end
_G.IVTRTYPE_ENUM = {
  IVTRTYPE_INVALID = -1,
  IVTRTYPE_EQUIPPACK = 0,
  IVTRTYPE_PACK = 1,
  IVTRTYPE_TASKITEM = 2,
  IVTRTYPE_MATERIAL = 3,
  IVTRTYPE_COUNT = 4
}
_G.GP_NPCSEV_TYPE = {
  GP_NPCSEV_NONE = 0,
  GP_NPCSEV_SELL = 1,
  GP_NPCSEV_BUY = 2,
  GP_NPCSEV_REPAIR = 3,
  GP_NPCSEV_EMBED = 4,
  GP_NPCSEV_TRANSMIT = 5,
  GP_NPCSEV_TASK_RETURN = 6,
  GP_NPCSEV_TASK_ACCEPT = 7,
  GP_NPCSEV_CLEAR_EMBED = 8,
  GP_NPCSEV_LEARNSKILL = 9,
  GP_NPCSEV_ADDON = 10,
  GP_NPCSEV_CLEAR_ADDON = 11,
  GP_NPCSEV_ENCHANT = 12,
  GP_NPCSEV_EQUIP_LEVELUP = 13,
  GP_NPCSEV_TRASHPSW = 14,
  GP_NPCSEV_OPENTRASH = 15,
  GP_NPCSEV_OPENFACTIONTRASH = 16,
  GP_NPCSEV_CLEAR_EQUIPLVL = 17,
  GP_NPCSEV_FACTION = 18,
  GP_NPCSEV_BOOTHSELL = 19,
  GP_NPCSEV_TRAVEL = 20,
  GP_NPCSEV_PURCHASE = 21,
  GP_NPCSEV_CLEAR_PROF = 22,
  GP_NPCSEV_SELECT_PROF = 23,
  GP_NPCSEV_MAKEHOLE = 24,
  GP_NPCSEV_MAIL = 25,
  GP_NPCSEV_ENTER_INSTANCE = 26,
  GP_NPCSEV_VENDUE = 27,
  GP_NPCSEV_DBLEXPTIME = 28,
  GP_NPCSEV_LEARNSKILLSEQ = 29,
  GP_NPCSEV_BINDITEM = 35,
  GP_NPCSEV_DESTROYBIND = 36,
  GP_NPCSEV_RESTOREBIND = 37,
  GP_NPCSEV_REINFORCE = 38,
  GP_NPCSEV_KAIGUANG = 39,
  GP_NPCSEV_ENCHASE = 40,
  GP_NPCSEV_BUYBACK = 47,
  GP_NPCSEV_TRANSMIT_BIGWORLD = 55,
  GP_NPCSEV_TRACE_PLAYER = 56,
  GP_NPCSEV_MARRIGE = 65,
  GP_NPCSEV_CHANGE_NATION = 119,
  GP_NPCSEV_NEW_AUCTION = 120,
  GP_ESCORT_CHANGE_CARGO = 122,
  GP_NPCSEV_EASY_MALL = 123,
  GP_NPCSEV_MINI_GAME = 124
}
_G.GP_MATTER_TYPE = {
  GP_MATTER_TYPE_MINE = 0,
  GP_MATTER_TYPE_DYNOBJ = 1,
  GP_MATTER_TYPE_LOOT = 2,
  GP_MATTER_TYPE_TRANSMIT = 3,
  GP_MATTER_TYPE_MONEY = 4,
  GP_MATTER_TYPE_BUFFBOX = 5,
  GP_MATTER_TYPE_ITEM = 6,
  GP_MATTER_TYPE_SOUL = 7,
  GP_MATTER_TYPE_TRAP = 8,
  GP_MATTER_TYPE_MARRIAGE_LOCK = 9,
  GP_MATTER_TYPE_DROP = 10,
  GP_MATTER_TYPE_HiddenTreasure = 11
}
_G.NETPRTC_PROC_RET = {
  NETPROCRET_FAIL = 0,
  NETPROCRET_SUCC = 1,
  NETPROCRET_POSTPONE_LOGIC = 2,
  NETPROCRET_FINISH_NOTREMOVE = 3,
  NETPROCRET_DELAY_SYNCSERVER = 4
}
_G.GP_SESSION_TYPE = {
  NULL = 0,
  LOOT = 1,
  USE_ITEM = 2,
  EMOTE = 3,
  GATHER = 4,
  ENCHANT = 5,
  SERVICE = 6,
  ATTACK = 7,
  KNOCKBACK = 9,
  PRODUCE = 10,
  ONLINE_PRACTICE = 11,
  ESCORT = 12,
  PARRY_YINGZHI = 13,
  CUSTOM_MOVE = 14,
  CHASE_TARGET = 15,
  BATTLE_CRUISE = 16,
  FOLLOW_MASTER = 17,
  WINE = 18,
  MOVE = 19,
  COUNT = 20
}
_G.ITEM_PICKUP_OWNER = {
  OWNER_PLAYER = 0,
  OWNER_TEAM = 1,
  OWNER_ROLL = 2,
  OWNER_ALL = 3,
  OWNER_MAFIA = 4
}
_G.IDLESTATE_MASK = {
  GP_IDLE_STATE_NONE = 0,
  GP_IDLE_STATE_ROOT = 1,
  GP_IDLE_STATE_SILENT = 2,
  GP_IDLE_STATE_DIET = 4,
  GP_IDLE_STATE_IDLE = 8,
  GP_IDLE_STATE_CG = 16,
  GP_IDLE_STATE_DIZZY = 15
}
_G.GP_MONEY_TYPE = {
  GPMONEYTYPE_BIND = 0,
  GPMONEYTYPE_TRADE = 1,
  GPMONEYTYPE_COUNT = 2
}
_G.GP_CT_SKILL_START = 1024
_G.GP_CT_MEDICINE_START = 600
_G.ATTACK_FLAG = {
  ATTACK_FLAG_INHIBITED = 16,
  ATTACK_FLAG_DEBUFF_RESIST = 64,
  ATTACK_FLAG_MISS = 512,
  ATTACK_FLAG_CRIT = 1024,
  ATTACK_FLAG_SHIELD = 2048,
  ATTACK_FLAG_PARRY = 4096,
  ATTACK_FLAG_BROKEN_PARRY = 8192,
  ATTACK_FLAG_CTRL_MOVE = 32768,
  ATTACK_FLAG_CTRL = 65536,
  ATTACK_FLAG_SYNC_POS = 262144,
  ATTACK_FLAG_CTRL_TURN = 524288,
  ATTACK_FLAG_CTRL_WEAK = 1048576,
  ATTACK_FLAG_CTRL_POZHAN = 2097152,
  ATTACK_FLAG_POFANG = 4194304
}
_G.REVIVE_TYPE = {
  BACK_TO_CITY = 0,
  CUR_LOCATION = 1,
  PERFECT = 2,
  GO_TO_ALLY = 3,
  NATION_WAR = 4
}
_G.RANKLIST_TID = {
  TPN_LEVEL = 1,
  TPN_LEVEL_OLDDAY = 2,
  TPN_MONEY = 3,
  TPN_MONEY_OLDDAY = 4,
  TPN_FIGHT = 5,
  TPN_FIGHT_N1 = 6,
  TPN_FIGHT_N2 = 7,
  TPN_FIGHT_N3 = 8,
  TPN_FIGHT_N4 = 9,
  TPN_FIGHT_N5 = 10,
  TPN_FIGHT_N6 = 11,
  TPN_FIGHT_OLDDAY = 12,
  TPN_FIGHT_OLDDAY_N1 = 13,
  TPN_FIGHT_OLDDAY_N2 = 14,
  TPN_FIGHT_OLDDAY_N3 = 15,
  TPN_FIGHT_OLDDAY_N4 = 16,
  TPN_FIGHT_OLDDAY_N5 = 17,
  TPN_FIGHT_OLDDAY_N6 = 18,
  TPN_FLOWER = 19,
  TPN_FLOWER_OLDDAY = 20,
  TPN_FLOWER_WEEK_N1 = 21,
  TPN_FLOWER_WEEK_N2 = 22,
  TPN_FLOWER_WEEK_N3 = 23,
  TPN_FLOWER_WEEK_N4 = 24,
  TPN_FLOWER_WEEK_N5 = 25,
  TPN_FLOWER_WEEK_N6 = 26,
  TPN_FLOWER_WEEK_N1_OLD = 27,
  TPN_FLOWER_WEEK_N2_OLD = 28,
  TPN_FLOWER_WEEK_N3_OLD = 29,
  TPN_FLOWER_WEEK_N4_OLD = 30,
  TPN_FLOWER_WEEK_N5_OLD = 31,
  TPN_FLOWER_WEEK_N6_OLD = 32,
  TPN_CARD_COLLECT = 33,
  TPN_CARD_COLLECT_OLD = 34,
  TPN_FIGHT_PROFESSION_1 = 35,
  TPN_FIGHT_PROFESSION_2 = 36,
  TPN_FIGHT_PROFESSION_3 = 37,
  TPN_FIGHT_PROFESSION_4 = 38,
  TPN_FIGHT_PROFESSION_1_OLD = 39,
  TPN_FIGHT_PROFESSION_2_OLD = 40,
  TPN_FIGHT_PROFESSION_3_OLD = 41,
  TPN_FIGHT_PROFESSION_4_OLD = 42,
  TPN_DUKE_N1 = 43,
  TPN_DUKE_N2 = 44,
  TPN_DUKE_N3 = 45,
  TPN_DUKE_N4 = 46,
  TPN_DUKE_N5 = 47,
  TPN_DUKE_N6 = 48,
  TPN_DUKE_N1_OLD = 49,
  TPN_DUKE_N2_OLD = 50,
  TPN_DUKE_N3_OLD = 51,
  TPN_DUKE_N4_OLD = 52,
  TPN_DUKE_N5_OLD = 53,
  TPN_DUKE_N6_OLD = 54,
  TPN_FACTION_INDUSTRY_N1 = 300,
  TPN_FACTION_INDUSTRY_N2 = 301,
  TPN_FACTION_INDUSTRY_N3 = 302,
  TPN_FACTION_INDUSTRY_N4 = 303,
  TPN_FACTION_INDUSTRY_N5 = 304,
  TPN_FACTION_INDUSTRY_N6 = 305,
  TPN_FACTION_INDUSTRY_N1_OLD = 306,
  TPN_FACTION_INDUSTRY_N2_OLD = 307,
  TPN_FACTION_INDUSTRY_N3_OLD = 308,
  TPN_FACTION_INDUSTRY_N4_OLD = 309,
  TPN_FACTION_INDUSTRY_N5_OLD = 310,
  TPN_FACTION_INDUSTRY_N6_OLD = 311,
  TPN_FACTION_INDUSTRY = 312,
  TPN_FACTION_INDUSTRY_OLD = 313,
  TPN_NATION_POWER = 100000,
  TPN_NATION_KING_MIND = 100001
}
_G.PROFESSION = {
  "\231\160\180\229\134\155",
  "\232\139\141\233\190\153",
  "\229\164\169\231\133\140",
  "\228\185\157\230\155\156"
}
_G.PKMode = {
  Peace = 0,
  Kill = 1,
  Crime = 2,
  Faction = 3,
  Nation = 4,
  Team = 5,
  Alliance = 6
}
_G.REGION_MASK = {
  SANCTUARY = 1,
  TRADE = 2,
  MARKET = 4,
  MOUNT = 8,
  DUEL = 16,
  MATCH = 32,
  SUMMON = 64,
  XYXW = 128,
  PK_NO_PUNISH = 256,
  INNER = 512,
  BIND = 1024,
  THROW = 2048,
  COUPLE_JUMP = 4096,
  PRACTICE = 8192,
  ITEM = 16384,
  RECONVERT = 32768,
  EQUIPMENT = 65536,
  TRANSMIT = 131072,
  AUTOFIGHT = 262144,
  ANQI = 524288
}
_G.GP_LEAVETEAM_REASON = {
  GP_LTR_LEAVE = 0,
  GP_LTR_KICKOUT = 1,
  GP_LTR_DISMISS = 2
}
_G.GP_MATCHQUIT_REASON = {
  MATCH_QUIT_REASON_WRONG_POS = 1,
  MATCH_QUIT_REASON_CANT_ENTER = 2,
  MATCH_QUIT_REASON_QUIT = 3,
  MATCH_QUIT_REASON_DENY = 4,
  MATCH_QUIT_REASON_CANT_TROOP_UP = 5,
  MATCH_QUIT_REASON_OFFLINE = 6,
  MATCH_QUIT_REASON_SUCCEED = 7,
  MATCH_QUIT_REASON_CREATE_TEAM = 8,
  MATCH_QUIT_REASON_TIMEOUT = 9
}
_G.MIRROR_STATE_MASK = {MS_FORBIT_MIRROR_STATE = 1, MS_IN_NATION_WAR = 2}
_G.REWARDS_TYPE = {
  CHECKIN = 1,
  ONLINE = 2,
  SERVER_OPEN = 3,
  MONTH_CARD = 4,
  ACTIVITY_MONTH = 5,
  ACTIVITY_DAY = 6,
  REWARD_WEAK = 7,
  REWARD_LOGIN_DAYS = 8
}
_G.SHOPPING_ERROR_CODE = {
  ERR_MALL_SUCC = 0,
  ERR_MALL_GOODS_CHECK_FAIL = 1,
  ERR_MALL_INVALID_REQUEST = 2,
  ERR_MALL_CAN_NOT_AFFORD = 3,
  ERR_MALL_INVENTORY_IS_FULL = 4,
  ERR_MALL_MAILBOX_FULL = 5,
  ERR_MALL_SERVER_NETWORK = 6,
  ERR_MALL_REPU_CAN_NOT_AFFORD = 7,
  ERR_MALL_GOODS_SELL_TIME_LIMIT = 10,
  ERR_MALL_PLAYER_PROP_DISMATCH = 11
}
_G.REPUID = {
  CHARM = 0,
  FAME = 1,
  SECT = 2,
  LIVE = 3,
  WULIN = 4,
  PK = 5,
  SECT_HIDE = 6,
  FACTION_CONTRIBUTION = 7,
  GENEROUS = 8,
  MONEY = 9,
  NATION_WAR = 10,
  VIP = 11,
  MONTH_ACTIVITY = 12,
  DAY_ACTIVITY = 13,
  FORCE = 14,
  FORCE_EXTENT = 15,
  FLOWER = 16,
  FLOWER_WEEk = 17,
  HUFU = 44,
  CARD_COLLECT = 45,
  DUKE_CREDIT = 46,
  ARENA_CREDIT = 47,
  DAY_DUKE = 51,
  EXP_TIME_LIMIT = 52
}
_G.CORP_REPUTATION_ID = {
  CRID_HOLY_BOSS_EXP = 1,
  CRID_WINE_QUALITY = 2,
  CRID_RANDOM_GUEST = 3,
  CRID_WINE_COUNT = 4
}
_G.GP_MISC = {
  GFX_STATE_PARAMS_COUNT = 8,
  FLOWER_SPEAKID = 49,
  FLOWER_SPEAKID_2 = 50
}
_G.PROFRESSIONPATHIDTABLE = {
  [1] = {
    [0] = 440,
    [1] = 441
  },
  [2] = {
    [0] = 438,
    [1] = 439
  },
  [3] = {
    [0] = 442,
    [1] = 443
  },
  [4] = {
    [0] = 444,
    [1] = 445
  }
}
_G.NATION_WAR_OPER = {
  ENTER_WAR = 1,
  ZHAOJI = 2,
  YANSHI_JIAXUE = 3,
  JIHUO = 4,
  TRANSMIT = 5
}
_G.NationWarStatus = {
  None = 0,
  Attack = 1,
  Defend = 2
}
_G.GP_INC_ITEM_TYPE = {
  INC_ITEM_TYPE_NULL = 0,
  INC_ITEM_TYPE_TASK = 1,
  INC_ITEM_TYPE_NPC_TRADE = 2,
  INC_ITEM_TYPE_PLAYER_TRADE = 3,
  INC_ITEM_TYPE_MARKET = 4,
  INC_ITEM_TYPE_PICKUP = 5,
  INC_ITEM_TYPE_LOTTERY = 6,
  INC_ITEM_TYPE_MAIL = 7,
  INC_ITEM_TYPE_PRODUCE = 8,
  INC_ITEM_TYPE_BUYBACK = 9,
  INC_ITEM_TYPE_UNINSTALL_STONE = 10,
  INC_ITEM_TYPE_MALL = 11,
  INC_ITEM_TYPE_CATCH_PET = 12,
  INC_ITEM_TYPE_ITEM_GEN = 13,
  INC_ITEM_TYPE_GIFT = 14,
  INC_ITEM_TYPE_MARRIAGE = 15,
  INC_ITEM_TYPE_SYNTHETIZE = 16,
  INC_ITEM_TYPE_PET_SKILL_TRANS = 17,
  INC_ITEM_TYPE_EQUIP_UNEMBED_STONE = 18,
  INC_ITEM_TYPE_ANALYZE_PRODUCT = 19,
  INC_ITEM_TYPE_PRACTICE = 20,
  INC_ITEM_TYPE_PICKUP_DROP = 21,
  INC_ITEM_TYPE_INSTANCE_LUCKYDRAW = 22,
  INC_ITEM_TYPE_ONLINE_GIFT = 23,
  INC_ITEM_TYPE_FLOURISH = 24,
  INC_ITEM_TYPE_TREASURE_MAP = 25,
  INC_ITEM_TYPE_MAFIA_LOG = 26,
  INC_ITEM_TYPE_PICKUP_SELF_DROP = 27,
  INC_ITEM_TYPE_ROB_ESCORT = 28,
  INC_ITEM_TYPE_REWARD = 29,
  INC_ITEM_TYPE_TREASURE_MAP_PRIZE = 30,
  INC_ITEM_TYPE_TREASURE_STEAL = 31,
  INC_ITEM_TYPE_CLUE_COMPOSE = 32,
  INC_ITEM_TYPE_BATTLEFIELD_SHOP = 33
}
_G.GP_DEC_ITEM_TYPE = {
  DEC_ITEM_TYPE_NULL = 0,
  DEC_ITEM_TYPE_TASK = 1,
  DEC_ITEM_TYPE_NPC_SELL = 2,
  DEC_ITEM_TYPE_NPC_BUY = 3,
  DEC_ITEM_TYPE_PLAYER_TRADE = 4,
  DEC_ITEM_TYPE_MARKET = 5,
  DEC_ITEM_TYPE_DEATH = 6,
  DEC_ITEM_TYPE_USE = 7,
  DEC_ITEM_TYPE_MAIL = 8,
  DEC_ITEM_TYPE_PRODUCE = 9,
  DEC_ITEM_TYPE_DESTROY = 10,
  DEC_ITEM_TYPE_GATHER = 11,
  DEC_ITEM_TYPE_EXPIRE = 12,
  DEC_ITEM_TYPE_AUTO_DEL = 13,
  DEC_ITEM_TYPE_GIFT = 14,
  DEC_ITEM_TYPE_MARRIAGE = 15,
  DEC_ITEM_TYPE_SYNTHETIZE = 16,
  DEC_ITEM_TYPE_DISSEAL_EQUIP = 17,
  DEC_ITEM_TYPE_KAIGUANG_EQUIP = 18,
  DEC_ITEM_TYPE_REINFORCE_EQUIP = 19,
  DEC_ITEM_TYPE_PET_SERVICE = 20,
  DEC_ITEM_TYPE_EQUIP_MAKE_HOLE = 21,
  DEC_ITEM_TYPE_EQUIP_EMBED_STONE = 22,
  DEC_ITEM_TYPE_EQUIP_UNEMBED_STONE = 23,
  DEC_ITEM_TYPE_HOME = 24,
  DEC_ITEM_TYPE_ANALYZE_PRODUCT = 25,
  DEC_ITEM_TYPE_TMP = 26,
  DEC_ITEM_TYPE_KUNGFU = 27,
  DEC_ITEM_TYPE_NPC_PURCHASE = 28,
  DEC_ITEM_TYPE_EQUIP_MAGIC_STONE = 29,
  DEC_ITEM_TYPE_MALL = 30,
  DEC_ITEM_TYPE_MAFIA = 31,
  DEC_ITEM_TYPE_ESCORT = 32,
  DEC_ITEM_GATHER_INFORMATION = 34,
  DEC_ITEM_SUBMIT_INFORMATION = 35,
  DEC_ITEM_MAFIATREASURE_ADVANCE = 36,
  DEC_ITEM_TYPE_TREASURE_STEAL = 37,
  DEC_ITEM_TYPE_TREASURE_TRAP = 38,
  DEC_ITEM_TYPE_PRODUCE_LEVELUP = 39,
  DEC_ITEM_TYPE_MAFIA_PARTY = 40,
  DEC_ITEM_TYPE_TASK_BY_TYPE = 41,
  DEC_ITEM_TYPE_CLUE_COMPOSE = 42,
  DEC_ITEM_TYPE_LEAVE_SCENE_DROP = 43,
  DEC_ITEM_TYPE_CLUE_FINAL = 44,
  DEC_ITEM_TYPE_BATTLEFIELD_SHOP = 45,
  DEC_ITEM_TYPE_JIACHI = 46,
  DEC_ITEM_TYPE_TXN = 47,
  DEC_ITEM_DIG_TREASURE = 48,
  DEC_ITEM_RESURRECT = 49,
  DEC_ITEM_TYPE_COUNT = 50
}
_G.GREETING_TYPE = {
  GREETING_INVITE = 1,
  GREETING_GRANT = 2,
  GREETING_THANKS = 3
}
_G.NetworkReachability = {
  NotReachable = 0,
  ReachableViaCarrierDataNetwork = 1,
  ReachableViaLocalAreaNetwork = 2
}
_G.Forbid = {
  FBD_FORBID_LOGIN = 100,
  FBD_FORBID_TALK = 101,
  FBD_FORBID_TRADE = 102,
  FBD_FORBID_SELL = 103,
  FBD_FORBID_SELLPTS = 104
}

_G.CHECKCASTSKILL_CODE = {
  CHKCASTSKL_FAILED = -1,
  CHKCASTSKL_OK = 0,
  CHKCASTSKL_INVALID_SKL = 1,
  CHKCASTSKL_INVALID_WEAPON = 2,
  CHKCASTSKL_NOTENOUGH_MP = 3,
  CHKCASTSKL_NOTENOUGH_RAGE = 4,
  CHKCASTSKL_NOTENOUGH_ITEM = 5,
  CHKCASTSKL_INVALID_TARGET = 6,
  CHKCASTSKL_TARGET_TOOFAR = 7,
  CHKCASTSKL_SKILL_COOLING = 8,
  CHKCASTSKL_SKILL_USING = 9,
  CHKCASTSKL_TARGET_TOONEAR = 10,
  CHKCASTSKL_TARGET_NOTFRONT = 11,
  CHKCASTSKL_HOST_STUN = 12,
  CHKCASTSKL_WRONG_SKLCASTSTATE = 13,
  CHKCASTSKL_NEED_TARGET = 14,
  CHKCASTSKL_HOST_DEAD = 15,
  CHKCASTSKL_HOST_FIGHT = 16,
  CHKCASTSKL_HOST_WRONGSTATE = 17,
  CHKCASTSKL_SKILLMOVE_CHKFAIL = 18,
  CHKCASTSKL_STATE_TRANSFAIL = 19,
  CHKCASTSKL_TARGET_NOTMATCH = 20,
  CHKCASTSKL_TARGET_HIGHLEVEL = 21,
  CHKCASTSKL_PETPACK_FULL = 22,
  CHKCASTSKL_VEHICLE_LIMIT = 23,
  CHKCASTSKL_POSSKL_INVALIDPOS = 24,
  CHKCASTSKL_EXEC_CMD = 25,
  CHKCASTSKL_NOTENOUGH_STRENGTH = 26,
  CHKCASTSKL_NO_BUFF = 27,
  CHKCASTSKL_QINGGONGSTATE_LIMIT = 28,
  CHKCASTSKL_TRANSFORMSTATE_LIMIT = 29,
  CHKCASTSKL_STANCE_LIMIT = 30,
  CHKCASTSKL_SUTRA_NOT_ACTIVATED = 31,
  CASTSKL_BEGIN = 100,
  CASTSKL_INVALID_ITEM = 101,
  CASTSKL_CANNOT_COMBO = 102,
  CASTSKL_NOTCAST_THISTIME = 103,
  CASTSKL_OK_SENT = 104,
  CASTSKL_WAITING_TO_BUFFER = 105,
  CASTSKL_BUFFERED_NOTSENT = 106,
  CASTSKL_TRACING = 107,
  CASTSKL_CHARGE_STARTED = 108,
  CASTSKL_CHARGING = 109,
  CASTSKL_CHARGE_STOPPED = 110,
  CASTSKL_PRESSUP_IGNORE = 111,
  CASTSKL_SKILLMASHING = 112
}
_G.e_SkillMove_Type = {
  MOVE_NONE = 0,
  MOVE_TO_TARGET_REDIR = 1,
  MOVE_TO_DIRECTION_REDIR = 2,
  MOVE_TO_TARGET_HOLDFACE = 3,
  MOVE_TO_DIRECTION_HOLDFACE = 4,
  MOVE_TO_RC_SUBOBJ_REDIR = 5,
  MOVE_TO_RC_SUBOBJ_HOLDFACE = 6,
  MOVE_TO_CLIENTPOS_REDIR = 7,
  MOVE_TO_CLIENTPOS_HOLDFACE = 8
}
_G.e_CastSkill = {
  CAST_PRIOR_ID = 0,
  CAST_PRIOR_POS = 1,
  CAST_PRIOR_MASK = 1,
  CAST_SELF_POS = 2,
  CAST_CTRL_END = 4
}
_G.SKILL_RANGE_TYPE = {
  RANGE_INVALID = -1,
  RANGE_TARGET_POINT = 0,
  RANGE_TARGET_BALL = 1,
  RANGE_SELF_POINT = 2,
  RANGE_SELF_LINE = 3,
  RANGE_SELF_SECTOR = 4,
  RANGE_SELF_BALL = 5,
  RANGE_SELF_RECT = 10,
  RANGE_TARGET_GRAB = 12,
  RANGE_SELF_CUTLINE = 13,
  RANGE_SELF_LINE_SELFTOTARGET = 14
}
_G.e_Skill_Type = {
  Client = 1,
  Server = 3,
  Mix = 4
}
_G.e_SkillTarget_Type = {Object = 0, None = 1}
_G.e_SkillMoveJumpInfo_Type = {
  Any = 0,
  Move = 1,
  Jump = 2
}
_G.e_Perform_Type = {
  Cancelable = 1,
  Root = 2,
  Verbose = 3
}
_G.e_Perform_Type2 = {
  Pray = 0,
  Perform = 1,
  PerformCharge = 11,
  PerformChannel = 12,
  Interval = 2,
  Cycle = 3,
  CycleMash = 31,
  MovableCycle = 4,
  MovableCharge = 41,
  MovablePerform = 42,
  StandHurtBreakCharge = 111,
  StandDodgeBreakCharge = 112,
  MoveHurtBreakCharge = 411,
  MoveDodgeBreak = 412
}
_G.e_ChangeSelfPos_Type = {
  None = 0,
  TurnToTarget = 1,
  TurnToDir = 2,
  Target = 3,
  Dir = 4
}
_G.e_SkillCacheState = {
  Replaceable = 0,
  Locked = 1,
  Runnable = 2
}
_G.PERFORM_FLAGS = {
  PERFORM_FLAGS_TARGET_LIST = 1,
  PERFORM_FLAGS_TARGET_MOVE = 2,
  PERFORM_FLAGS_TARGET_DIR = 4,
  PERFORM_FLAGS_PERSIST_MOVE = 8,
  PERFORM_FLAGS_1ST_PERFORM = 64
}
_G.REASON_CANNOT_CAST_SKILL = {
  CASTOK = 0,
  OUT_OF_RANGE = 1,
  HAS_ACTION = 2,
  IN_SEAL_MODE = 3,
  MOVING = 4,
  INVISIBLE = 5,
  COOLDOWN = 6,
  INCORRECT_STATE = 7,
  INVALID_TARGET = 8,
  INVALID_DIR = 9,
  LACK_MP = 10,
  LACK_RAGE = 11,
  PETXP_LACK = 12,
  LACK_STRENGTH = 13,
  LACK_ITEM = 14,
  INVALID_WEAPON = 15,
  IN_COMBAT = 16,
  UNKNOWN_CASTSKILL = 17,
  NOT_MOVABLE = 18,
  CANNOT_IN_QINGGONG = 19,
  NEED_PREVQINGGONG = 20,
  STANCE = 21,
  SUTRA = 22,
  RUSH = 23,
  MOUNT_CANT = 24,
  MOUNT_MUST = 25,
  CANNOTCASTSKILL_COUNT = 26
}
_G.CANCEL_SKILL_REASON = {CAST_ANOTHER_SKILL = 0, WALK_AWAY = 1}
_G.CAST_SKILL_RET = {
  Invalid = 0,
  OK = 1,
  Fail = 2,
  Error = 3,
  NotLearnt = 4,
  NotEnoughMP = 5
}
function _G.int(param)
  return math.floor(param)
end
_G.player = {}
function _G.player.skill_level(skillid)
  local Lplus = require("Lplus")
  local ECGame = Lplus.ForwardDeclare("ECGame")
  local player = ECGame.Instance().m_HostPlayer
  if player == nil then
    return 0
  end
  local skill = player:GetUserSkill(skillid)
  if skill == nil then
    return 0
  end
  return skill:GetLevel()
end

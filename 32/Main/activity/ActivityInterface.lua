local Lplus = require("Lplus")
local TimeCfgUtils = require("Main.Common.TimeCfgUtils")
local ActivityInterface = Lplus.Class("ActivityInterface")
local ActivityType = require("consts.mzm.gsp.activity.confbean.ActivityType")
local ActivityDisPlayType = require("consts.mzm.gsp.activity.confbean.ActivityDisPlayType")
local AbsoluteTimer = require("Main.Common.AbsoluteTimer")
local ActivityConst = require("netio.protocol.mzm.gsp.activity.ActivityConst")
local def = ActivityInterface.define
local instance
def.static("=>", ActivityInterface).Instance = function()
  if instance == nil then
    instance = ActivityInterface()
    instance:Init()
  end
  return instance
end
def.field("table")._activity_cfg_cache_list = nil
def.field("table")._activity_cfg_cache_map = nil
def.field("table")._activityInPeriod = nil
def.field("table")._activityInfos = nil
def.field("table")._daily = nil
def.field("table")._weekly = nil
def.field("table")._comingsoon = nil
def.field("table")._festival = nil
def.field("table")._holiday = nil
def.field("table")._timeLimit = nil
def.field("table")._single = nil
def.field("table")._team = nil
def.field("table")._gang = nil
def.field("table")._newActivitiesSet = nil
def.field("table")._newActivitiesVector = nil
def.field("boolean")._isLevelUpRefresh = false
def.field("table")._levelUpInfo = nil
def.field("table")._activityTipFunc = nil
def.field("table")._activityTipFuncEx = nil
def.field("table")._newLevelOpenActivitiesSet = nil
def.field("table")._newLevelOpenActivitiesVector = nil
def.field("table")._newHolidayActivitiesSet = nil
def.field("table")._newHolidayActivitiesVector = nil
def.field("table")._newSingleActivitiesSet = nil
def.field("table")._newSingleActivitiesVector = nil
def.field("table")._newTeamActivitiesSet = nil
def.field("table")._newTeamActivitiesVector = nil
def.field("table")._newGangActivitiesSet = nil
def.field("table")._newGangActivitiesVector = nil
def.field("table")._newTimeOpenActivitiesSet = nil
def.field("table")._newTimeOpenActivitiesVector = nil
def.field("table")._newFestivalActivitiesSet = nil
def.field("table")._newFestivalActivitiesVector = nil
def.field("table")._importantActivitiesSet = nil
def.field("table")._importantActivitiesVector = nil
def.field("boolean")._Inited = false
def.field("table")._MenpaiNPCs = nil
def.field("number")._RexXingCount = 0
def.field("table")._huanhunItemInfos = nil
def.field("number")._huanhunStatus = 0
def.field("table")._huanhunNextItem = nil
def.field("number")._seekHelpLeftCount = 0
def.field("number")._helpOtherLeftCount = 0
def.field("userdata")._huanhunTimeLimit = nil
def.field("table")._huanhunGangHelpInfo = nil
def.field("number")._lingqifengyinStatus = 0
def.field("number")._lingqifengyinOpenIndex = 0
def.field("number")._lingqifengyinStartTime = 0
def.field("number")._lingqifengyinEndTime = 0
def.field("number")._fengyinNormalLv = -1
def.field("number")._lingqifengyinTimerId = 0
def.field("number")._bountyCount = 0
def.field("number")._flushNeedNum = 0
def.field("table")._bountyTaskInfos = nil
def.field("number")._husongcfgid = 0
def.field("table")._husongMap = nil
def.field("number").husong_couple_npc_cfgid = 0
def.field("table")._activityRequirements = nil
def.field("table")._activityAllRequirements = nil
def.field("boolean")._activityReqsExpire = false
def.field("table")._activeDatas = nil
def.field("table")._awardActiveCfgids = nil
def.field("number")._currentTotalActive = 0
def.field("number")._singleCount = 0
def.field("number")._doubleCount = 0
def.field("boolean")._canExchangeMoshou = true
def.field("table").noAchieveLevelActivity = nil
def.field("table").activityTimerMap = nil
def.field("table").specialActivityControl = nil
def.field("table").activityRedPoint = nil
def.field("number").onlineBoxTimerId = 0
def.field("table").customCloseActivity = nil
def.field("number").npcExchangeItemId = 0
ActivityInterface.DigongGuaye_ACTIVITY_ID = 350000008
ActivityInterface.GangRobber_ACTIVITY_ID = 350000013
ActivityInterface.PhantomCave_ACTIVITY_ID = 350000016
ActivityInterface.GANG_BATTLE_ACTIVITYID = 0
ActivityInterface.JZJX_ACTIVITY_ID = 0
ActivityInterface.JZJX_ACTIVITY_NPC_ID = 0
ActivityInterface.JZJX_ENTER_WAITING_ROOM_SERVICE_ID = 0
ActivityInterface.JZJX_WAITING_ROOM_NPC_ID = 0
ActivityInterface.JZJX_ENTER_ACTIVITY_MAP_SERVICE_ID = 0
def.method().Init = function(self)
  local OccupationEnum = require("consts.mzm.gsp.occupation.confbean.SOccupationEnum")
  self._MenpaiNPCs = {}
  local menpaiNPC = {}
  menpaiNPC.occupationId = OccupationEnum.GUI_WANG_ZONG
  menpaiNPC.NPCID = constant.ShimenActivityCfgConsts.SHIMEN_GUIWANG_NPC_ID
  menpaiNPC.graphID = constant.ShimenActivityCfgConsts.SHIMEN_GUIWANG_GRAPH_ID
  self._MenpaiNPCs[menpaiNPC.occupationId] = menpaiNPC
  menpaiNPC = {}
  menpaiNPC.occupationId = OccupationEnum.QIN_GYUN_MEN
  menpaiNPC.NPCID = constant.ShimenActivityCfgConsts.SHIMEN_QINGYUN_NPC_ID
  menpaiNPC.graphID = constant.ShimenActivityCfgConsts.SHIMEN_QINGYUN_GRAPH_ID
  self._MenpaiNPCs[menpaiNPC.occupationId] = menpaiNPC
  menpaiNPC = {}
  menpaiNPC.occupationId = OccupationEnum.TIAN_YIN_SI
  menpaiNPC.NPCID = constant.ShimenActivityCfgConsts.SHIMEN_TIANYIN_NPC_ID
  menpaiNPC.graphID = constant.ShimenActivityCfgConsts.SHIMEN_TIANYIN_GRAPH_ID
  self._MenpaiNPCs[menpaiNPC.occupationId] = menpaiNPC
  menpaiNPC = {}
  menpaiNPC.occupationId = OccupationEnum.FEN_XIANG_GU
  menpaiNPC.NPCID = constant.ShimenActivityCfgConsts.SHIMEN_FENXIANG_NPC_ID
  menpaiNPC.graphID = constant.ShimenActivityCfgConsts.SHIMEN_FENXIANG_GRAPH_ID
  self._MenpaiNPCs[menpaiNPC.occupationId] = menpaiNPC
  menpaiNPC = {}
  menpaiNPC.occupationId = OccupationEnum.HE_HUAN_PAI
  menpaiNPC.NPCID = constant.ShimenActivityCfgConsts.SHIMEN_HEHUAN_NPC_ID
  menpaiNPC.graphID = constant.ShimenActivityCfgConsts.SHIMEN_HEHUAN_GRAPH_ID
  self._MenpaiNPCs[menpaiNPC.occupationId] = menpaiNPC
  menpaiNPC = {}
  menpaiNPC.occupationId = OccupationEnum.SHENG_WU_JIAO
  menpaiNPC.NPCID = constant.ShimenActivityCfgConsts.SHIMEN_SHENGWU_NPC_ID
  menpaiNPC.graphID = constant.ShimenActivityCfgConsts.SHIMEN_SHENGWU_GRAPH_ID
  self._MenpaiNPCs[menpaiNPC.occupationId] = menpaiNPC
  menpaiNPC = {}
  menpaiNPC.occupationId = OccupationEnum.CANG_YU_GE
  menpaiNPC.NPCID = constant.ShimenActivityCfgConsts.SHIMEN_CANGYU_NPC_ID
  menpaiNPC.graphID = constant.ShimenActivityCfgConsts.SHIMEN_CANGYU_GRAPH_ID
  self._MenpaiNPCs[menpaiNPC.occupationId] = menpaiNPC
  menpaiNPC = {}
  menpaiNPC.occupationId = OccupationEnum.LING_YIN_DIAN
  menpaiNPC.NPCID = constant.ShimenActivityCfgConsts.SHIMEN_LINGYINDIAN_NPC_ID
  menpaiNPC.graphID = constant.ShimenActivityCfgConsts.SHIMEN_LINGYINDIAN_GRAPH_ID
  self._MenpaiNPCs[menpaiNPC.occupationId] = menpaiNPC
  menpaiNPC = {}
  menpaiNPC.occupationId = OccupationEnum.YI_NENG_ZHE
  menpaiNPC.NPCID = constant.ShimenActivityCfgConsts.SHIMEN_YINENGZHE_NPC_ID
  menpaiNPC.graphID = constant.ShimenActivityCfgConsts.SHIMEN_YINENGZHE_GRAPH_ID
  self._MenpaiNPCs[menpaiNPC.occupationId] = menpaiNPC
  menpaiNPC = {}
  menpaiNPC.occupationId = OccupationEnum.WAN_DU_MEN
  menpaiNPC.NPCID = constant.ShimenActivityCfgConsts.SHIMEN_WANDUMEN_NPC_ID
  menpaiNPC.graphID = constant.ShimenActivityCfgConsts.SHIMEN_WANDUMEN_GRAPH_ID
  self._MenpaiNPCs[menpaiNPC.occupationId] = menpaiNPC
  menpaiNPC = {}
  menpaiNPC.occupationId = OccupationEnum.DAN_QING_GE
  menpaiNPC.NPCID = constant.ShimenActivityCfgConsts.SHIMEN_DANQINGGE_NPC_ID
  menpaiNPC.graphID = constant.ShimenActivityCfgConsts.SHIMEN_DANQINGGE_GRAPH_ID
  self._MenpaiNPCs[menpaiNPC.occupationId] = menpaiNPC
  menpaiNPC = {}
  menpaiNPC.occupationId = OccupationEnum.YIN_YANG_SHI
  menpaiNPC.NPCID = constant.ShimenActivityCfgConsts.SHIMEN_YINYANGSHI_NPC_ID
  menpaiNPC.graphID = constant.ShimenActivityCfgConsts.SHIMEN_YINYANGSHI_GRAPH_ID
  self._MenpaiNPCs[menpaiNPC.occupationId] = menpaiNPC
  Event.RegisterEvent(ModuleId.ITEM, gmodule.notifyId.item.Item_OnBagInfoSynchronized, ActivityInterface.OnBagInfoSynchronized)
  self:Reset()
end
def.method().Reset = function(self)
  self._activityInPeriod = {}
  self._activityInfos = {}
  self._daily = {}
  self._weekly = {}
  self._comingsoon = {}
  self._festival = {}
  self._holiday = {}
  self._timeLimit = {}
  self._single = {}
  self._team = {}
  self._gang = {}
  self._newActivitiesSet = {}
  self._newActivitiesVector = {}
  self._importantActivitiesSet = {}
  self._importantActivitiesVector = {}
  self._newLevelOpenActivitiesSet = {}
  self._newLevelOpenActivitiesVector = {}
  self._newHolidayActivitiesSet = {}
  self._newHolidayActivitiesVector = {}
  self._newSingleActivitiesSet = {}
  self._newSingleActivitiesVector = {}
  self._newTeamActivitiesSet = {}
  self._newTeamActivitiesVector = {}
  self._newGangActivitiesSet = {}
  self._newGangActivitiesVector = {}
  self._newTimeOpenActivitiesSet = {}
  self._newTimeOpenActivitiesVector = {}
  self._newFestivalActivitiesSet = {}
  self._newFestivalActivitiesVector = {}
  self._Inited = false
  self._RexXingCount = 0
  self._huanhunItemInfos = nil
  self._huanhunStatus = 0
  self._huanhunNextItem = nil
  self._seekHelpLeftCount = 0
  self._helpOtherLeftCount = 0
  self._huanhunTimeLimit = nil
  self._huanhunGangHelpInfo = {}
  self._lingqifengyinStatus = 0
  self._lingqifengyinOpenIndex = 0
  self._lingqifengyinStartTime = 0
  self._lingqifengyinEndTime = 0
  self._fengyinNormalLv = -1
  if self._lingqifengyinTimerId ~= 0 then
    GameUtil.RemoveGlobalTimer(self._lingqifengyinTimerId)
    self._lingqifengyinTimerId = 0
  end
  self._activityRequirements = {}
  self._activityAllRequirements = {}
  self._activityReqsExpire = false
  self._activeDatas = {}
  self._awardActiveCfgids = {}
  self._currentTotalActive = 0
  self._bountyCount = 0
  self._flushNeedNum = 0
  self._bountyTaskInfos = nil
  self._husongcfgid = 0
  self._husongMap = nil
  self._singleCount = 0
  self._doubleCount = 0
  self._levelUpInfo = nil
  self._isLevelUpRefresh = false
  self.noAchieveLevelActivity = {}
  if self.activityTimerMap then
    for _, v in pairs(self.activityTimerMap) do
      AbsoluteTimer.RemoveListener(v)
    end
  end
  self.activityTimerMap = {}
  self.specialActivityControl = {}
  self.activityRedPoint = {}
  if self.onlineBoxTimerId ~= 0 then
    GameUtil.RemoveGlobalTimer(self.onlineBoxTimerId)
    self.onlineBoxTimerId = 0
  end
  self.customCloseActivity = {}
  self.npcExchangeItemId = 0
end
def.static("table", "table").OnBagInfoSynchronized = function(p1, p2)
  instance._activityReqsExpire = true
end
def.method("number", "number").SetLevelUpInfo = function(self, fromLevel, toLevel)
  self._isLevelUpRefresh = true
  self._levelUpInfo = {}
  self._levelUpInfo.from = fromLevel
  self._levelUpInfo.to = toLevel
end
def.method("number", "number", "number", "number").SetActivityInfo = function(self, actvityId, count, awarded, clearTime)
  if count == 0 and awarded == false then
    self._activityInfos[actvityId] = nil
    return
  end
  local info = self._activityInfos[actvityId]
  if info == nil then
    info = {}
    self._activityInfos[actvityId] = info
  end
  info.actvityId = actvityId
  info.count = count
  info.awarded = awarded
  info.clearTime = clearTime
end
def.method("number", "number").SetActivityInfoCount = function(self, activityId, count)
  local info = self._activityInfos[activityId]
  if info then
    info.count = count
  end
end
def.method("number").ResetActivityInfo = function(self, activityId)
  local info = self._activityInfos[activityId]
  if info then
    info.count = 0
    info.awarded = false
    info.clearTime = GetServerTime()
  end
end
def.method("=>", "number").GetCurActive = function(self)
  return self._currentTotalActive
end
def.method("number", "=>", "table").GetActivityInfo = function(self, actvityId)
  local info = self._activityInfos[actvityId]
  return info
end
def.static("number", "=>", "table").GetActivityCfg = function(index)
  local ID = index + 350000000
  return ActivityInterface._GetActivityCfgById(ID)
end
def.static("number", "=>", "table").GetActivityCfgById = function(ID)
  local self = instance
  self._activity_cfg_cache_map = self._activity_cfg_cache_map or {}
  local cfg = self._activity_cfg_cache_map[ID]
  if cfg ~= nil then
    return cfg
  end
  cfg = ActivityInterface._GetActivityCfgById(ID)
  self._activity_cfg_cache_map[ID] = cfg
  return cfg
end
def.static("number", "=>", "table")._GetActivityCfgById = function(activityID)
  local record = DynamicData.GetRecord(CFG_PATH.DATA_ACTIVITY_CFG, activityID)
  if record == nil then
    warn("********************** _GetActivityCfgById return nil ID =", activityID)
    return nil
  end
  local cfg = ActivityInterface._DoLoadActivityCfg(record)
  return cfg
end
def.static("userdata", "=>", "table")._DoLoadActivityCfg = function(entry)
  local cfg = {}
  cfg.id = DynamicRecord.GetIntValue(entry, "id")
  cfg.activityName = DynamicRecord.GetStringValue(entry, "activityName")
  cfg.activityDes = DynamicRecord.GetStringValue(entry, "activityDes")
  cfg.timeDes = DynamicRecord.GetStringValue(entry, "timeDes")
  cfg.activityIcon = DynamicRecord.GetIntValue(entry, "activityIcon")
  cfg.activityType = DynamicRecord.GetIntValue(entry, "activityType")
  cfg.activityDisType = DynamicRecord.GetIntValue(entry, "activityDisType")
  cfg.activityDisType1 = DynamicRecord.GetIntValue(entry, "activityDisType")
  cfg.activitySort = DynamicRecord.GetIntValue(entry, "activitySort")
  cfg.jiaoBiaoId = DynamicRecord.GetIntValue(entry, "jiaoBiaoId")
  cfg.limitCount = DynamicRecord.GetIntValue(entry, "count")
  cfg.levelMax = DynamicRecord.GetIntValue(entry, "levelMax")
  cfg.levelMin = DynamicRecord.GetIntValue(entry, "levelMin")
  cfg.serverLevelMin = DynamicRecord.GetIntValue(entry, "serverLevelMin")
  cfg.couldBeSingleTeam = DynamicRecord.GetCharValue(entry, "couldBeSingleTeam") ~= 0
  cfg.hasOpenEffect = DynamicRecord.GetCharValue(entry, "hasOpenEffect") ~= 0
  cfg.notOpenDisplay = DynamicRecord.GetCharValue(entry, "notOpenDisplay") ~= 0
  cfg.activityDisLimitTimeid = DynamicRecord.GetIntValue(entry, "activityDisLimitTimeid")
  cfg.activityLimitTimeid = DynamicRecord.GetIntValue(entry, "activityLimitTimeid")
  cfg.bigReset = DynamicRecord.GetCharValue(entry, "bigReset") ~= 0
  cfg.resetDataBigTurn = DynamicRecord.GetIntValue(entry, "resetDataBigTurn")
  cfg.activityTimeCfgs = {}
  local rec2 = entry:GetStructValue("activityTimeIdsStruct")
  local count = rec2:GetVectorSize("activityTimeIds")
  for i = 1, count do
    local rec3 = rec2:GetVectorValueByIdx("activityTimeIds", i - 1)
    local id = rec3:GetIntValue("Id")
    if id ~= 0 then
      local timeDurationCommonCfg = TimeCfgUtils.GetTimeDurationCommonCfg(id)
      table.insert(cfg.activityTimeCfgs, timeDurationCommonCfg)
    end
  end
  local sortFn = function(l, r)
    local lvalue = l.timeCommonCfg.activeWeekDay * 10000 + l.timeCommonCfg.activeHour * 100 + l.timeCommonCfg.activeMinute
    local rvalue = r.timeCommonCfg.activeWeekDay * 10000 + r.timeCommonCfg.activeHour * 100 + r.timeCommonCfg.activeMinute
    return lvalue < rvalue
  end
  table.sort(cfg.activityTimeCfgs, sortFn)
  cfg.personMax = DynamicRecord.GetIntValue(entry, "personMax")
  cfg.personMin = DynamicRecord.GetIntValue(entry, "personMin")
  cfg.recommendAwardIcon = DynamicRecord.GetIntValue(entry, "recommendAwardIcon")
  cfg.recommendCount = DynamicRecord.GetIntValue(entry, "recommendCount")
  cfg.specialEffectId = DynamicRecord.GetIntValue(entry, "specialEffectId")
  cfg.wordTip = DynamicRecord.GetStringValue(entry, "wordTip")
  cfg.panelCfgid = DynamicRecord.GetIntValue(entry, "panelCfgid")
  cfg.timeDes = DynamicRecord.GetStringValue(entry, "timeDes")
  cfg.product = DynamicRecord.GetIntValue(entry, "product")
  cfg.awardActiveTimes = DynamicRecord.GetIntValue(entry, "awardActiveTimes")
  cfg.awardActiveValue = DynamicRecord.GetIntValue(entry, "awardActiveValue")
  cfg.subscribeRemindid = DynamicRecord.GetIntValue(entry, "subscribeRemindid")
  cfg.awardDisItems = {}
  local rec2 = entry:GetStructValue("awardDisItemsStruct")
  local count = rec2:GetVectorSize("awardDisItems")
  for i = 1, count do
    local rec3 = rec2:GetVectorValueByIdx("awardDisItems", i - 1)
    local id = rec3:GetIntValue("Id")
    if id ~= 0 then
      table.insert(cfg.awardDisItems, id)
    end
  end
  return cfg
end
def.method()._LoadAllActivity = function(self)
  self._activity_cfg_cache_list = {}
  self._activity_cfg_cache_map = {}
  local entries = DynamicData.GetTable(CFG_PATH.DATA_ACTIVITY_CFG)
  local count = DynamicDataTable.GetRecordsCount(entries)
  DynamicDataTable.FastGetRecordBegin(entries)
  for i = 0, count - 1 do
    local entry = DynamicDataTable.FastGetRecordByIdx(entries, i)
    local cfg = ActivityInterface._DoLoadActivityCfg(entry)
    table.insert(self._activity_cfg_cache_list, cfg)
    self._activity_cfg_cache_map[cfg.id] = cfg
  end
end
def.method("number", "=>", "boolean").GetActivityIsNew = function(self, activityId)
  if self._newHolidayActivitiesSet[activityId] ~= nil or self._newSingleActivitiesSet[activityId] ~= nil or self._newTeamActivitiesSet[activityId] ~= nil or self._newGangActivitiesSet[activityId] ~= nil or self._newTimeOpenActivitiesSet[activityId] ~= nil or self.activityRedPoint[activityId] then
    return true
  else
    return false
  end
end
def.method().RefreshActivityList = function(self)
  local heroProp = require("Main.Hero.Interface").GetHeroProp()
  if heroProp == nil then
    self._Inited = false
    return
  end
  local oldDailyList
  if self._daily ~= nil then
    oldDailyList = {}
    for k, v in pairs(self._daily) do
      oldDailyList[v.id] = v.id
    end
  end
  local oldWeeklyList
  if self._weekly ~= nil then
    oldWeeklyList = {}
    for k, v in pairs(self._weekly) do
      oldWeeklyList[v.id] = v.id
    end
  end
  local oldFestivalList
  if self._festival ~= nil then
    oldFestivalList = {}
    for k, v in pairs(self._festival) do
      oldFestivalList[v.id] = v.id
    end
  end
  local oldTimeLimitList
  if self._timeLimit ~= nil then
    oldTimeLimitList = {}
    for k, v in pairs(self._timeLimit) do
      oldTimeLimitList[v.id] = v.id
    end
  end
  local oldHolidayList
  if self._holiday ~= nil then
    oldHolidayList = {}
    for k, v in pairs(self._holiday) do
      oldHolidayList[v.id] = v.id
    end
  end
  local oldSingleList
  if self._single ~= nil then
    oldSingleList = {}
    for k, v in pairs(self._single) do
      oldSingleList[v.id] = v.id
    end
  end
  local oldTeamList
  if self._team ~= nil then
    oldTeamList = {}
    for k, v in pairs(self._team) do
      oldTeamList[v.id] = v.id
    end
  end
  local oldGangList
  if self._gang ~= nil then
    oldGangList = {}
    for k, v in pairs(self._gang) do
      oldGangList[v.id] = v.id
    end
  end
  self._daily = {}
  self._weekly = {}
  self._comingsoon = {}
  self._festival = {}
  self._holiday = {}
  self._timeLimit = {}
  self._single = {}
  self._team = {}
  self._gang = {}
  local newDailyList = {}
  local newWeeklyList = {}
  local newFestivalList = {}
  local newHolidayList = {}
  local newSingleList = {}
  local newTeamList = {}
  local newGangList = {}
  local newTimeLimitList = {}
  local lists = {}
  lists[ActivityDisPlayType.TimeLimit] = self._timeLimit
  lists[ActivityDisPlayType.Holiday] = self._holiday
  lists[ActivityDisPlayType.Single] = self._single
  lists[ActivityDisPlayType.Team] = self._team
  lists[ActivityDisPlayType.Gang] = self._gang
  if self._activity_cfg_cache_list == nil then
    self:_LoadAllActivity()
  end
  local nowSec = GetServerTime()
  local check_level = function(cfg, heroProp)
    if cfg.levelMax ~= 0 and heroProp.level > cfg.levelMax then
      return false
    end
    return true
  end
  local count = #self._activity_cfg_cache_list
  local serverLevelData = require("Main.Server.ServerModule").Instance():GetServerLevelInfo()
  local serverLevel = serverLevelData.level
  for i = 1, count do
    local cfg = self._activity_cfg_cache_list[i]
    local isForceClose = self:isForceCloseActivity(cfg.id)
    local isPause = self:isActivityPause(cfg.id)
    while true do
      if not (serverLevel >= cfg.serverLevelMin) or isForceClose or isPause or self.customCloseActivity[cfg.id] or cfg.activityType == ActivityType.Other then
        break
      end
      do
        local isForceOpen = self:isForceOpenActivity(cfg.id)
        if not isForceOpen then
          if not check_level(cfg, heroProp) then
            break
          end
          local timeLimitCommonCfg = TimeCfgUtils.GetTimeLimitCommonCfg(cfg.activityDisLimitTimeid)
          if timeLimitCommonCfg ~= nil then
            local beginTime = TimeCfgUtils.GetTimeSec(timeLimitCommonCfg.startYear, timeLimitCommonCfg.startMonth, timeLimitCommonCfg.startDay, timeLimitCommonCfg.startHour, timeLimitCommonCfg.startMinute, 0)
            local endTime = TimeCfgUtils.GetTimeSec(timeLimitCommonCfg.endYear, timeLimitCommonCfg.endMonth, timeLimitCommonCfg.endDay, timeLimitCommonCfg.endHour, timeLimitCommonCfg.endMinute, 0)
            if (nowSec >= beginTime and nowSec < endTime) == false then
              break
            end
          end
          if cfg.notOpenDisplay == false then
            local nowSec = GetServerTime()
            local inPeriod = cfg.activityType == ActivityType.Daily
            local isInDate = true
            if inPeriod == false then
              local isToday = false
              local nowTimeTable = AbsoluteTimer.GetServerTimeTable(nowSec)
              local nowDayWeek = nowTimeTable.wday
              if #cfg.activityTimeCfgs == 0 then
                if timeLimitCommonCfg then
                  local beginTime = TimeCfgUtils.GetTimeSec(timeLimitCommonCfg.startYear, timeLimitCommonCfg.startMonth, timeLimitCommonCfg.startDay, timeLimitCommonCfg.startHour, timeLimitCommonCfg.startMinute, 0)
                  local endTime = TimeCfgUtils.GetTimeSec(timeLimitCommonCfg.endYear, timeLimitCommonCfg.endMonth, timeLimitCommonCfg.endDay, timeLimitCommonCfg.endHour, timeLimitCommonCfg.endMinute, 0)
                  if nowSec < beginTime or nowSec >= endTime then
                    break
                  else
                    isToday = true
                  end
                else
                  isToday = true
                end
              end
              for idx, timeDurationCommonCfg in pairs(cfg.activityTimeCfgs) do
                if timeDurationCommonCfg.timeCommonCfg.activeWeekDay ~= 0 then
                  isToday = nowDayWeek == timeDurationCommonCfg.timeCommonCfg.activeWeekDay
                  inPeriod = isToday
                  if isToday == true then
                    break
                  end
                else
                  isToday = true
                  break
                end
              end
              if isToday == false then
                break
              end
            end
          end
        end
        if cfg.levelMin ~= 0 and heroProp.level < cfg.levelMin and not isForceOpen then
          table.insert(self._comingsoon, cfg)
          break
        end
        if cfg.activityType == ActivityType.Daily then
          table.insert(self._daily, cfg)
        end
        if cfg.activityType == ActivityType.TimeLimit then
          table.insert(self._weekly, cfg)
        end
        if cfg.activityType == ActivityType.Holiday then
          table.insert(self._festival, cfg)
        end
        if cfg.activityDisType ~= ActivityDisPlayType.Other then
          table.insert(lists[cfg.activityDisType], cfg)
        end
        if cfg.activityDisType1 ~= ActivityDisPlayType.Other and cfg.activityDisType1 ~= cfg.activityDisType and cfg.activityDisType1 ~= 0 then
          table.insert(lists[cfg.activityDisType1], cfg)
        end
        if cfg.activityType == ActivityType.Daily then
          if oldDailyList ~= nil and oldDailyList[cfg.id] == nil then
            table.insert(newDailyList, cfg.id)
          end
        elseif cfg.activityType == ActivityType.TimeLimit then
          if oldWeeklyList ~= nil and oldWeeklyList[cfg.id] == nil then
            table.insert(newWeeklyList, cfg.id)
          end
        elseif cfg.activityType == ActivityType.Holiday and oldFestivalList ~= nil and oldFestivalList[cfg.id] == nil then
          table.insert(newFestivalList, cfg.id)
        end
        if cfg.activityDisType == ActivityDisPlayType.Holiday then
          if oldHolidayList ~= nil and oldHolidayList[cfg.id] == nil then
            table.insert(newHolidayList, cfg)
          end
        elseif cfg.activityDisType == ActivityDisPlayType.Single then
          if oldSingleList ~= nil and oldSingleList[cfg.id] == nil then
            table.insert(newSingleList, cfg)
          end
        elseif cfg.activityDisType == ActivityDisPlayType.Team then
          if oldTeamList ~= nil and oldTeamList[cfg.id] == nil then
            table.insert(newTeamList, cfg)
          end
        elseif cfg.activityDisType == ActivityDisPlayType.Gang then
          if oldGangList ~= nil and oldGangList[cfg.id] == nil then
            table.insert(newGangList, cfg)
          end
        elseif cfg.activityDisType == ActivityDisPlayType.TimeLimit and oldTimeLimitList ~= nil and oldTimeLimitList[cfg.id] == nil then
          table.insert(newTimeLimitList, cfg)
        end
        if self._isLevelUpRefresh == true and self._levelUpInfo and self._levelUpInfo.from < cfg.levelMin and self._levelUpInfo.to >= cfg.levelMin then
          self._newLevelOpenActivitiesSet[cfg.id] = cfg.id
          table.insert(self._newLevelOpenActivitiesVector, cfg.id)
        end
      end
      break
    end
  end
  local sortFn = function(l, r)
    return l.levelMin < r.levelMin
  end
  table.sort(self._comingsoon, sortFn)
  if self._Inited == true then
    if #newHolidayList > 0 then
      self:UpdateNewActivityList(newHolidayList, self._newHolidayActivitiesSet, self._newHolidayActivitiesVector)
    end
    if #newSingleList > 0 then
      self:UpdateNewActivityList(newSingleList, self._newSingleActivitiesSet, self._newSingleActivitiesVector)
    end
    if #newTeamList > 0 then
      self:UpdateNewActivityList(newTeamList, self._newTeamActivitiesSet, self._newTeamActivitiesVector)
    end
    if #newGangList > 0 then
      self:UpdateNewActivityList(newGangList, self._newGangActivitiesSet, self._newGangActivitiesVector)
    end
    if #newTimeLimitList > 0 then
      self:UpdateNewActivityList(newTimeLimitList, self._newTimeOpenActivitiesSet, self._newTimeOpenActivitiesVector)
    end
  end
  self._Inited = true
  self._isLevelUpRefresh = false
  self._levelUpInfo = nil
end
def.method("table", "table", "table").UpdateNewActivityList = function(self, newList, newSet, newVector)
  for k, v in pairs(newList) do
    if v.activityType == ActivityType.TimeLimit then
      if self._activityInPeriod[v.id] ~= nil then
        newSet[v.id] = v.id
        table.insert(newVector, v.id)
      end
    elseif v.activityType == ActivityType.Holiday and ActivityInterface.GetActivityState(v.id) == 0 then
      newSet[v.id] = v.id
      table.insert(newVector, v.id)
    end
    self._newActivitiesSet[v.id] = v.id
    table.insert(self._newActivitiesVector, v.id)
  end
  Event.DispatchEvent(ModuleId.ACTIVITY, gmodule.notifyId.activity.Activity_ListChanged, newList)
end
def.method().RefreshImportantActivityList = function(self)
  self._importantActivitiesSet = {}
  self._importantActivitiesVector = {}
  self:_CheckImportantActivityCompleteRecommend(constant.ZhenYaoActivityCfgConsts.ZhenYao_ACTIVITY_ID)
  self:_CheckImportantActivityCompleteRecommend(constant.ShimenActivityCfgConsts.SHIMEN_ACTIVITY_ID)
  Event.DispatchEvent(ModuleId.ACTIVITY, gmodule.notifyId.activity.Activity_ImportantActivityChanged, nil)
end
def.method("number")._CheckImportantActivityCompleteRecommend = function(self, activityID)
  local enabled = false
  for idx, cfg in pairs(self._daily) do
    if cfg.id == activityID then
      enabled = true
      break
    end
  end
  if enabled == false then
    for idx, cfg in pairs(self._weekly) do
      if cfg.id == activityID then
        enabled = true
        break
      end
    end
  end
  if enabled == false then
    return
  end
  local info = self._activityInfos[activityID]
  if info ~= nil then
    local activityCfg = ActivityInterface.GetActivityCfgById(activityID)
    if info.count < activityCfg.recommendCount then
      self._importantActivitiesSet[activityID] = activityID
      table.insert(self._importantActivitiesVector, activityID)
    end
  end
end
def.method("=>", "table").GetDailyActivityList = function(self)
  return self._daily
end
def.method("=>", "table").GetWeeklyActivityList = function(self)
  return self._weekly
end
def.method("=>", "table").GetTimeLimitActivityList = function(self)
  return self._timeLimit
end
def.method("=>", "table").GetHolidayActivityList = function(self)
  return self._holiday
end
def.method("=>", "table").GetComingSoonActivityList = function(self)
  return self._comingsoon
end
def.method("=>", "table").GetFestivalActivityList = function(self)
  return self._festival
end
def.method("=>", "table").GetSingleActivityList = function(self)
  return self._single
end
def.method("=>", "table").GetTeamActivityList = function(self)
  return self._team
end
def.method("=>", "table").GetGangActivityList = function(self)
  return self._gang
end
def.method("number").removeActivity = function(self, activityId)
  local index = 0
  for i, v in ipairs(self._daily) do
    if v.id == activityId then
      index = i
      break
    end
  end
  if index ~= 0 then
    table.remove(self._daily, index)
    index = 0
  end
  for i, v in ipairs(self._weekly) do
    if v.id == activityId then
      index = i
      break
    end
  end
  if index ~= 0 then
    table.remove(self._weekly, index)
    index = 0
  end
  for i, v in ipairs(self._festival) do
    if v.id == activityId then
      index = i
      break
    end
  end
  if index ~= 0 then
    table.remove(self._festival, i)
  end
end
def.static("number", "=>", "number", "number").GetActivityBeginningAndEndingTime = function(ActivityID)
  local cfg = ActivityInterface.GetActivityCfgById(ActivityID)
  if cfg == nil then
    return 0, 0
  end
  local inPeriod = cfg.activityType == ActivityType.Daily
  if inPeriod == true then
    return 0, 0
  end
  local isInDate = true
  local nowSec = GetServerTime()
  local timeLimitCommonCfg = TimeCfgUtils.GetTimeLimitCommonCfg(cfg.activityLimitTimeid)
  if timeLimitCommonCfg ~= nil then
    local beginTime = TimeCfgUtils.GetTimeSec(timeLimitCommonCfg.startYear, timeLimitCommonCfg.startMonth, timeLimitCommonCfg.startDay, timeLimitCommonCfg.startHour, timeLimitCommonCfg.startMinute, 0)
    local endTime = TimeCfgUtils.GetTimeSec(timeLimitCommonCfg.endYear, timeLimitCommonCfg.endMonth, timeLimitCommonCfg.endDay, timeLimitCommonCfg.endHour, timeLimitCommonCfg.endMinute, 0)
    isInDate = nowSec >= beginTime and nowSec <= endTime
    if isInDate and #cfg.activityTimeCfgs == 0 then
      return beginTime, endTime
    end
  end
  if isInDate == false then
    return 0, 0
  end
  local isToday = false
  local curTimeTable = AbsoluteTimer.GetServerTimeTable(nowSec)
  local nowYear = curTimeTable.year
  local nowMonth = curTimeTable.month
  local nowDay = curTimeTable.day
  local nowDayWeek = curTimeTable.wday
  for idx, timeDurationCommonCfg in pairs(cfg.activityTimeCfgs) do
    while true do
      local start = false
      local stop = true
      local beginHour = timeDurationCommonCfg.timeCommonCfg.activeHour
      local beginMinute = timeDurationCommonCfg.timeCommonCfg.activeMinute
      if timeDurationCommonCfg.timeCommonCfg.activeWeekDay ~= 0 then
        isToday = nowDayWeek == timeDurationCommonCfg.timeCommonCfg.activeWeekDay
        inPeriod = isToday
        if isToday == true then
          local beginHour = timeDurationCommonCfg.timeCommonCfg.activeHour
          local beginMinute = timeDurationCommonCfg.timeCommonCfg.activeMinute
          local beginTime = TimeCfgUtils.GetTimeSec(nowYear, nowMonth, nowDay, beginHour, beginMinute, 0)
          local durationSec = timeDurationCommonCfg.lastHour * 3600 + timeDurationCommonCfg.lastMinute * 60
          local endTime = beginTime + durationSec
          start = nowSec >= beginTime
          stop = nowSec > endTime
          inPeriod = start == true and stop == false
          if inPeriod == true then
            do return beginTime, endTime end
            break
          end
        end
        break
      end
      isToday = true
      do
        local beginTime = TimeCfgUtils.GetTimeSec(nowYear, nowMonth, nowDay, beginHour, beginMinute, 0)
        local duration = timeDurationCommonCfg.lastDay * 86400 + timeDurationCommonCfg.lastHour * 3600 + timeDurationCommonCfg.lastMinute * 60
        local endTime = beginTime + duration
        start = nowSec >= beginTime
        stop = nowSec > endTime
        inPeriod = start == true and stop == false
        if inPeriod == true then
          return beginTime, endTime
        end
      end
      break
    end
  end
  return 0, 0
end
def.static("number", "=>", "number").GetActivityBeginningTime = function(ActivityID)
  local cfg = ActivityInterface.GetActivityCfgById(ActivityID)
  if cfg == nil then
    return 0
  end
  local inPeriod = cfg.activityType == ActivityType.Daily
  if inPeriod == true then
    return 0
  end
  local isInDate = true
  local nowSec = GetServerTime()
  local timeLimitCommonCfg = TimeCfgUtils.GetTimeLimitCommonCfg(cfg.activityLimitTimeid)
  if timeLimitCommonCfg ~= nil then
    local beginTime = TimeCfgUtils.GetTimeSec(timeLimitCommonCfg.startYear, timeLimitCommonCfg.startMonth, timeLimitCommonCfg.startDay, timeLimitCommonCfg.startHour, timeLimitCommonCfg.startMinute, 0)
    local endTime = TimeCfgUtils.GetTimeSec(timeLimitCommonCfg.endYear, timeLimitCommonCfg.endMonth, timeLimitCommonCfg.endDay, timeLimitCommonCfg.endHour, timeLimitCommonCfg.endMinute, 0)
    isInDate = nowSec >= beginTime and nowSec <= endTime
    if isInDate and #cfg.activityTimeCfgs == 0 then
      return beginTime
    end
  end
  if isInDate == false then
    return 0
  end
  local isToday = false
  local curTimeTable = AbsoluteTimer.GetServerTimeTable(nowSec)
  local nowYear = curTimeTable.year
  local nowMonth = curTimeTable.month
  local nowDay = curTimeTable.day
  local nowDayWeek = curTimeTable.wday
  for idx, timeDurationCommonCfg in pairs(cfg.activityTimeCfgs) do
    local start = false
    local stop = true
    local beginHour = timeDurationCommonCfg.timeCommonCfg.activeHour
    local beginMinute = timeDurationCommonCfg.timeCommonCfg.activeMinute
    if timeDurationCommonCfg.timeCommonCfg.activeWeekDay ~= 0 then
      isToday = nowDayWeek == timeDurationCommonCfg.timeCommonCfg.activeWeekDay
      inPeriod = isToday
      if isToday == true then
        local beginHour = timeDurationCommonCfg.timeCommonCfg.activeHour
        local beginMinute = timeDurationCommonCfg.timeCommonCfg.activeMinute
        local beginTime = TimeCfgUtils.GetTimeSec(nowYear, nowMonth, nowDay, beginHour, beginMinute, 0)
        local durationSec = timeDurationCommonCfg.lastHour * 3600 + timeDurationCommonCfg.lastMinute * 60
        local endTime = beginTime + durationSec
        start = nowSec >= beginTime
        stop = nowSec > endTime
        inPeriod = start == true and stop == false
        if inPeriod == true then
          return beginTime
        end
      end
    else
      isToday = true
      local beginTime = TimeCfgUtils.GetTimeSec(nowYear, nowMonth, nowDay, beginHour, beginMinute, 0)
      local duration = timeDurationCommonCfg.lastDay * 86400 + timeDurationCommonCfg.lastHour * 3600 + timeDurationCommonCfg.lastMinute * 60
      local endTime = beginTime + duration
      start = nowSec >= beginTime
      stop = nowSec > endTime
      inPeriod = start == true and stop == false
      if inPeriod == true then
        return beginTime
      end
    end
  end
  return 0
end
def.static("number", "=>", "number").GetActivityEndingTime = function(ActivityID)
  local cfg = ActivityInterface.GetActivityCfgById(ActivityID)
  if cfg == nil then
    return 0
  end
  local inPeriod = cfg.activityType == ActivityType.Daily
  if inPeriod == true then
    return 0
  end
  local isInDate = true
  local nowSec = GetServerTime()
  local timeLimitCommonCfg = TimeCfgUtils.GetTimeLimitCommonCfg(cfg.activityLimitTimeid)
  if timeLimitCommonCfg ~= nil then
    local beginTime = TimeCfgUtils.GetTimeSec(timeLimitCommonCfg.startYear, timeLimitCommonCfg.startMonth, timeLimitCommonCfg.startDay, timeLimitCommonCfg.startHour, timeLimitCommonCfg.startMinute, 0)
    local endTime = TimeCfgUtils.GetTimeSec(timeLimitCommonCfg.endYear, timeLimitCommonCfg.endMonth, timeLimitCommonCfg.endDay, timeLimitCommonCfg.endHour, timeLimitCommonCfg.endMinute, 0)
    isInDate = nowSec >= beginTime and nowSec <= endTime
    if isInDate and #cfg.activityTimeCfgs == 0 then
      return endTime
    end
  end
  if isInDate == false then
    return 0
  end
  local isToday = false
  local curTimeTable = AbsoluteTimer.GetServerTimeTable(nowSec)
  local nowYear = curTimeTable.year
  local nowMonth = curTimeTable.month
  local nowDay = curTimeTable.day
  local nowDayWeek = curTimeTable.wday
  for idx, timeDurationCommonCfg in pairs(cfg.activityTimeCfgs) do
    local start = false
    local stop = true
    local beginHour = timeDurationCommonCfg.timeCommonCfg.activeHour
    local beginMinute = timeDurationCommonCfg.timeCommonCfg.activeMinute
    if timeDurationCommonCfg.timeCommonCfg.activeWeekDay ~= 0 then
      isToday = nowDayWeek == timeDurationCommonCfg.timeCommonCfg.activeWeekDay
      inPeriod = isToday
      if isToday == true then
        local beginHour = timeDurationCommonCfg.timeCommonCfg.activeHour
        local beginMinute = timeDurationCommonCfg.timeCommonCfg.activeMinute
        local beginTime = TimeCfgUtils.GetTimeSec(nowYear, nowMonth, nowDay, beginHour, beginMinute, 0)
        local durationSec = timeDurationCommonCfg.lastHour * 3600 + timeDurationCommonCfg.lastMinute * 60
        local endTime = beginTime + durationSec
        start = nowSec >= beginTime
        stop = nowSec > endTime
        inPeriod = start == true and stop == false
        if inPeriod == true then
          return endTime
        end
      end
    else
      isToday = true
      local beginTime = TimeCfgUtils.GetTimeSec(nowYear, nowMonth, nowDay, beginHour, beginMinute, 0)
      local duration = timeDurationCommonCfg.lastDay * 86400 + timeDurationCommonCfg.lastHour * 3600 + timeDurationCommonCfg.lastMinute * 60
      local endTime = beginTime + duration
      start = nowSec >= beginTime
      stop = nowSec > endTime
      inPeriod = start == true and stop == false
      if inPeriod == true then
        return endTime
      end
    end
  end
  return 0
end
def.method("number", "=>", "table").GetMenpaiNPCData = function(self, occupation)
  local menpaiNPC = self._MenpaiNPCs[occupation]
  if menpaiNPC ~= nil then
    return menpaiNPC
  end
  return nil
end
def.static("number", "=>", "table").GetActivityVigorCfg = function(id)
  local record = DynamicData.GetRecord(CFG_PATH.DATA_ACTIVITY_VIGOR_CFG, id)
  if record == nil then
    return nil
  end
  local cfg = {}
  cfg.id = id
  cfg.maxCount = record:GetIntValue("maxCount")
  cfg.awardVigorTypeId = record:GetIntValue("awardVigorTypeId")
  cfg.desc = record:GetStringValue("desc")
  return cfg
end
def.static("number", "boolean", "=>", "boolean").CheckActivityConditionLevel = function(activityID, msg)
  local cfg = ActivityInterface.GetActivityCfgById(activityID)
  if cfg == nil then
    return false
  end
  local teamData = require("Main.Team.TeamData").Instance()
  local heroProp = require("Main.Hero.Interface").GetHeroProp()
  local ret = true
  if heroProp == nil then
    return false
  end
  if teamData:HasTeam() == true then
    local members = teamData:GetAllTeamMembers()
    local maxLevel = heroProp.level
    local minLevel = heroProp.level
    for k, v in pairs(members) do
      maxLevel = math.max(maxLevel, v.level)
      minLevel = math.min(minLevel, v.level)
    end
    if cfg.levelMax ~= 0 and maxLevel > cfg.levelMax then
      ret = false
      if msg == true then
        Toast(string.format(textRes.NPC[12], cfg.levelMax))
      end
    end
    if cfg.levelMin ~= 0 and minLevel < cfg.levelMin then
      ret = false
      if msg == true then
        Toast(string.format(textRes.NPC[13], cfg.levelMin))
      end
    end
  else
    if cfg.levelMax ~= 0 and heroProp.level > cfg.levelMax then
      ret = false
      if msg == true then
        Toast(string.format(textRes.NPC[18], cfg.levelMax))
      end
    end
    if cfg.levelMin ~= 0 and heroProp.level < cfg.levelMin then
      ret = false
      if msg == true then
        Toast(string.format(textRes.NPC[17], cfg.levelMin))
      end
    end
  end
  return ret
end
def.static("number", "boolean", "=>", "boolean").CheckActivityConditionTeamMemberCount = function(activityID, msg)
  local cfg = ActivityInterface.GetActivityCfgById(activityID)
  if cfg == nil then
    return false
  end
  local teamData = require("Main.Team.TeamData").Instance()
  local heroProp = require("Main.Hero.Interface").GetHeroProp()
  local ret = true
  if heroProp == nil then
    return false
  end
  if teamData:HasTeam() == true then
    if cfg.couldBeSingleTeam == false then
      Toast(string.format(textRes.NPC[15]))
      return false
    end
    local members = teamData:GetAllTeamMembers()
    local ST_NORMAL = require("netio.protocol.mzm.gsp.team.TeamMember").ST_NORMAL
    local memberCount = 0
    for k, v in pairs(members) do
      if v.status == ST_NORMAL then
        memberCount = memberCount + 1
      end
    end
    if memberCount > cfg.personMax then
      ret = false
      if msg == true then
        if cfg.personMax == 1 then
          Toast(string.format(textRes.NPC[15]))
        else
          Toast(string.format(textRes.NPC[19], cfg.personMax))
        end
      end
    end
    if memberCount < cfg.personMin then
      ret = false
      if msg == true then
        Toast(string.format(textRes.NPC[16], cfg.personMin))
      end
    end
  elseif 1 < cfg.personMin then
    ret = false
    if msg == true then
      Toast(string.format(textRes.NPC[16], cfg.personMin))
    end
  end
  return ret
end
def.static("number", "=>", "boolean").CheckActivityConditionFinishCount = function(activityID)
  local cfg = ActivityInterface.GetActivityCfgById(activityID)
  if cfg == nil then
    return false
  end
  local activityInfo = instance:GetActivityInfo(activityID)
  if activityInfo ~= nil and cfg.limitCount ~= 0 and activityInfo.count >= cfg.limitCount then
    return false
  end
  return true
end
def.static("number", "=>", "number").GetActivityState = function(activityID)
  local cfg = ActivityInterface.GetActivityCfgById(activityID)
  if cfg == nil then
    return -1
  end
  local inPeriod = cfg.activityType == ActivityType.Daily
  if inPeriod == true then
    return 0
  end
  local isInDate = true
  local nowSec = GetServerTime()
  local timeLimitCommonCfg = TimeCfgUtils.GetTimeLimitCommonCfg(cfg.activityLimitTimeid)
  if timeLimitCommonCfg ~= nil then
    local beginTime = TimeCfgUtils.GetTimeSec(timeLimitCommonCfg.startYear, timeLimitCommonCfg.startMonth, timeLimitCommonCfg.startDay, timeLimitCommonCfg.startHour, timeLimitCommonCfg.startMinute, 0)
    local endTime = TimeCfgUtils.GetTimeSec(timeLimitCommonCfg.endYear, timeLimitCommonCfg.endMonth, timeLimitCommonCfg.endDay, timeLimitCommonCfg.endHour, timeLimitCommonCfg.endMinute, 0)
    isInDate = nowSec >= beginTime and nowSec <= endTime
    if #cfg.activityTimeCfgs == 0 then
      if nowSec < beginTime then
        return -1
      elseif nowSec >= endTime then
        return 1
      else
        return 0
      end
    end
  end
  if isInDate == false then
    return -1
  end
  local isToday = false
  local curTimeTable = AbsoluteTimer.GetServerTimeTable(nowSec)
  local nowYear = curTimeTable.year
  local nowMonth = curTimeTable.month
  local nowDay = curTimeTable.day
  local nowDayWeek = curTimeTable.wday
  local ret = -1
  for idx, timeDurationCommonCfg in pairs(cfg.activityTimeCfgs) do
    while true do
      local start = false
      local stop = true
      local beginHour = timeDurationCommonCfg.timeCommonCfg.activeHour
      local beginMinute = timeDurationCommonCfg.timeCommonCfg.activeMinute
      if timeDurationCommonCfg.timeCommonCfg.activeWeekDay ~= 0 then
        isToday = nowDayWeek == timeDurationCommonCfg.timeCommonCfg.activeWeekDay
        inPeriod = isToday
        if isToday == true then
          do
            local beginHour = timeDurationCommonCfg.timeCommonCfg.activeHour
            local beginMinute = timeDurationCommonCfg.timeCommonCfg.activeMinute
            local beginTime = TimeCfgUtils.GetTimeSec(nowYear, nowMonth, nowDay, beginHour, beginMinute, 0)
            local durationSec = timeDurationCommonCfg.lastHour * 3600 + timeDurationCommonCfg.lastMinute * 60
            local endTime = beginTime + durationSec
            start = nowSec >= beginTime
            stop = nowSec > endTime
            inPeriod = start == true and stop == false
            if start == false then
              do return -1 end
              break
            end
            if inPeriod == true then
              do return 0 end
              break
            end
            if start == true and stop == true then
              ret = 1
            end
          end
          break
        end
        ret = -1
        break
      end
      isToday = true
      do
        local beginTime = TimeCfgUtils.GetTimeSec(nowYear, nowMonth, nowDay, beginHour, beginMinute, 0)
        local duration = timeDurationCommonCfg.lastDay * 86400 + timeDurationCommonCfg.lastHour * 3600 + timeDurationCommonCfg.lastMinute * 60
        local endTime = beginTime + duration
        start = nowSec >= beginTime
        stop = nowSec > endTime
        inPeriod = start == true and stop == false
        if start == false then
          ret = -1
          break
        end
        if inPeriod == true then
          do return 0 end
          break
        end
        if start == true and stop == true then
          ret = 1
        end
      end
      break
    end
  end
  return ret
end
def.method("number")._SetRexXingCount = function(self, count)
  self._RexXingCount = count
end
def.method("=>", "number").GetRexXingCount = function(self)
  return self._RexXingCount
end
def.method("number", "number", "number")._addActivityRequirements = function(self, activityID, requirementID, needCount)
  local requirements = self._activityRequirements[activityID]
  if requirements == nil then
    requirements = {}
    self._activityRequirements[activityID] = requirements
  end
  local requirement = requirements[requirementID]
  if requirement == nil then
    requirement = {}
    requirements[requirementID] = requirement
    requirement.activityID = activityID
    requirement.requirementID = requirementID
    requirement.needCount = 0
  end
  requirement.needCount = requirement.needCount + needCount
end
def.method()._refreshActivityRequirements = function(self)
  self._activityRequirements = {}
  local ItemInfo = require("netio.protocol.mzm.gsp.huanhun.ItemInfo")
  local SSynHuanhuiInfo = require("netio.protocol.mzm.gsp.huanhun.SSynHuanhuiInfo")
  if self._huanhunStatus == SSynHuanhuiInfo.ST_HUN__ACCEPT and self._huanhunItemInfos ~= nil then
    for k, v in pairs(self._huanhunItemInfos) do
      local done = v.taskState == ItemInfo.ST_TASK_DONE
      if done ~= true then
        self:_addActivityRequirements(constant.HuanHunMiShuConsts.HUANHUN_ACTIVITYID, v.itemCfgId, v.itemNum)
      end
    end
  end
  self:_refreshActivityRequirementsCount()
  self._activityReqsExpire = false
end
def.method()._refreshActivityRequirementsCount = function(self)
  local newAllRequirements = {}
  local BagInfo = require("netio.protocol.mzm.gsp.item.BagInfo")
  for activityID, requirements in pairs(self._activityRequirements) do
    for requirementID, requirement in pairs(requirements) do
      local requirementID = requirement.requirementID
      local allRequirements = newAllRequirements[requirementID]
      if allRequirements == nil then
        allRequirements = {}
        newAllRequirements[requirementID] = allRequirements
        allRequirements.requirementID = requirementID
        allRequirements.needCount = 0
      end
      allRequirements.needCount = allRequirements.needCount + requirement.needCount
    end
  end
  local ItemUtils = require("Main.Item.ItemUtils")
  local itemData = require("Main.Item.ItemData").Instance()
  local complete
  for requirementID, requirement in pairs(newAllRequirements) do
    local itemBase = ItemUtils.GetItemBase2(requirementID)
    if itemBase ~= nil then
      local count = itemData:GetNumberByItemId(BagInfo.BAG, requirementID)
      requirement.needCount = requirement.needCount - count
    else
      local items = itemData:FiltrateItems(BagInfo.BAG, requirementID, requirement.needCount)
      local count = #items
      requirement.needCount = requirement.needCount - count
    end
  end
  self._activityAllRequirements = {}
  for requirementID, requirement in pairs(newAllRequirements) do
    local itemBase = ItemUtils.GetItemBase2(requirementID)
    if requirement.needCount > 0 then
      self._activityAllRequirements[requirementID] = requirement
    end
  end
end
def.method("=>", "table").GetActivityRequirements = function(self)
  return self._activityRequirements
end
def.method("=>", "table").GetActivityAllRequirements = function(self)
  if self._activityReqsExpire then
    self:_refreshActivityRequirements()
  end
  return self._activityAllRequirements
end
def.method("number", "=>", "boolean").GetActivityIsOpen = function(self, activityid)
  return self._activityInPeriod[activityid] ~= nil
end
def.static("number", "=>", "table").GetRexXingNeed = function(count)
  local record = DynamicData.GetRecord(CFG_PATH.DATA_TASK_CIRCLE_COST_CONST, count)
  if record == nil then
    return nil
  end
  local cfg = {}
  cfg.renXingCount = record:GetIntValue("renXingCount")
  cfg.needXiaYi = record:GetIntValue("needXiaYi")
  cfg.needYuanBao = record:GetIntValue("needYuanBao")
  return cfg
end
def.method("number", "=>", "number").GetActivityActiveTimes = function(self, activityid)
  local times = self._activeDatas[activityid]
  return times or -1
end
def.method("number", "=>", "number").GetActivityActiveValue = function(self, activityID)
  local times = self._activeDatas[activityID]
  if times == nil then
    return 0
  end
  local cfg = ActivityInterface.GetActivityCfgById(activityID)
  if cfg == nil then
    warn("******* +++++++++++GetActivityActiveValue(", activityID, ") record == nil")
    return 0
  end
  local res = cfg.awardActiveValue * times
  return res
end
def.method("number", "=>", "boolean").GetActiveAwared = function(self, ActiveAwareid)
  return self._awardActiveCfgids[ActiveAwareid] ~= nil
end
def.static("number", "=>", "table").GetBountyViewCfg = function(taskID)
  local record = DynamicData.GetRecord(CFG_PATH.DATA_BOUNTY_VIEW_CFG, taskID)
  if record == nil then
    warn("******* +++++++++++GetBountyViewCfg(", taskID, ") record == nil")
    return nil
  end
  local cfg = {}
  cfg.taskID = record:GetIntValue("taskId")
  cfg.taskName = record:GetStringValue("taskName")
  cfg.itemIDs = {}
  local rec2 = record:GetStructValue("itemIdsStruct")
  local count = rec2:GetVectorSize("itemIds")
  for i = 1, count do
    local rec3 = rec2:GetVectorValueByIdx("itemIds", i - 1)
    local t = rec3:GetIntValue("itemId")
    if t ~= 0 then
      table.insert(cfg.itemIDs, t)
    end
  end
  return cfg
end
def.static("number", "=>", "table").GetActiveValueTipCfg = function(id)
  local record = DynamicData.GetRecord(CFG_PATH.DATA_ACTIVE_VALUE_TIP_CFG, id)
  if record == nil then
    return nil
  end
  local cfg = {}
  cfg.id = record:GetIntValue("id")
  cfg.needValue = record:GetIntValue("needValue")
  cfg.needLevel = record:GetIntValue("needLevel")
  cfg.content = record:GetStringValue("content")
  return cfg
end
ActivityInterface.TLP_ACTION_CONFIRM = 1
ActivityInterface.TLP_ACTION_CANCEL = 0
def.static("number", "=>", "table").GetTimeLimitTipCfg = function(id)
  local record = DynamicData.GetRecord(CFG_PATH.DATA_TIME_LIMIT_TIP_CFG, id)
  if record == nil then
    return nil
  end
  local cfg = {}
  cfg.id = record:GetIntValue("id")
  cfg.description = record:GetStringValue("description")
  cfg.popTimePerDay = record:GetIntValue("popTimePerDay")
  cfg.countDown = record:GetIntValue("countDown") or 0
  cfg.defaultActionWhenTimeout = record:GetIntValue("defaultConfirmWhenTimeout") or 0
  cfg.awardItemIds = {}
  local awardStruct = record:GetStructValue("awardDisItemsStruct")
  local count = awardStruct:GetVectorSize("awardItemIds")
  for i = 1, count do
    local rec = awardStruct:GetVectorValueByIdx("awardItemIds", i - 1)
    local itemId = rec:GetIntValue("Id")
    if itemId ~= 0 then
      table.insert(cfg.awardItemIds, itemId)
    end
  end
  return cfg
end
def.method("number", "=>", "boolean").isAchieveActivityLevel = function(self, activityId)
  local activityCfg = ActivityInterface.GetActivityCfgById(activityId)
  local serverLevelData = require("Main.Server.ServerModule").Instance():GetServerLevelInfo()
  local serverLevel = serverLevelData.level
  if serverLevel >= activityCfg.serverLevelMin then
    local myHero = require("Main.Hero.HeroModule").Instance()
    local heroProp = myHero:GetHeroProp()
    if heroProp then
      local myLevel = heroProp.level
      if myLevel >= activityCfg.levelMin and myLevel <= activityCfg.levelMax then
        return true
      end
    end
  end
  return false
end
def.method("number", "=>", "boolean").isActivityOpend = function(self, activityId)
  local isForceOpen = self:isForceOpenActivity(activityId)
  if isForceOpen then
    return true
  end
  local isForcePause = self:isActivityPause(activityId)
  if isForcePause then
    return false
  end
  local isForceClose = self:isForceCloseActivity(activityId)
  if isForceClose then
    return false
  end
  local activityCfg = ActivityInterface.GetActivityCfgById(activityId)
  if activityCfg == nil then
    warn("!!!!!!!!invalid activityId:", activityId)
    return false
  end
  if activityCfg.activityType == ActivityType.Daily then
    return true
  end
  local limitActivityId = activityCfg.activityLimitTimeid
  local curTime = GetServerTime()
  if limitActivityId ~= 0 then
    local timeLimitCommonCfg = TimeCfgUtils.GetTimeLimitCommonCfg(limitActivityId)
    if timeLimitCommonCfg ~= nil then
      local beginTime = TimeCfgUtils.GetTimeSec(timeLimitCommonCfg.startYear, timeLimitCommonCfg.startMonth, timeLimitCommonCfg.startDay, timeLimitCommonCfg.startHour, timeLimitCommonCfg.startMinute, 0)
      local endTime = TimeCfgUtils.GetTimeSec(timeLimitCommonCfg.endYear, timeLimitCommonCfg.endMonth, timeLimitCommonCfg.endDay, timeLimitCommonCfg.endHour, timeLimitCommonCfg.endMinute, 0)
      if curTime < beginTime or curTime > endTime then
        return false
      end
      if #activityCfg.activityTimeCfgs == 0 then
        if curTime >= beginTime and curTime < endTime then
          return true
        else
          return false
        end
      end
    end
  end
  local curTimeTable = AbsoluteTimer.GetServerTimeTable(curTime)
  local nowYear = curTimeTable.year
  local nowMonth = curTimeTable.month
  local nowDay = curTimeTable.day
  local nowDayWeek = curTimeTable.wday
  for i, timeDurationCommonCfg in pairs(activityCfg.activityTimeCfgs) do
    local isToday = true
    if timeDurationCommonCfg.timeCommonCfg.activeWeekDay ~= 0 then
      isToday = timeDurationCommonCfg.timeCommonCfg.activeWeekDay == nowDayWeek
    end
    if isToday then
      local beginHour = timeDurationCommonCfg.timeCommonCfg.activeHour
      local beginMinute = timeDurationCommonCfg.timeCommonCfg.activeMinute
      local beginTime = TimeCfgUtils.GetTimeSec(nowYear, nowMonth, nowDay, beginHour, beginMinute, 0)
      local durationSec = timeDurationCommonCfg.lastDay * 86400 + timeDurationCommonCfg.lastHour * 3600 + timeDurationCommonCfg.lastMinute * 60
      local endTime = beginTime + durationSec
      if curTime >= beginTime and curTime <= endTime then
        return true
      end
    end
  end
  return false
end
def.method("number", "=>", "boolean").isActivityOpend2 = function(self, activityId)
  local isForceOpen = self:isForceOpenActivity(activityId)
  if isForceOpen then
    return true
  end
  local isForcePause = self:isActivityPause(activityId)
  if isForcePause then
    return false
  end
  local isForceClose = self:isForceCloseActivity(activityId)
  if isForceClose then
    return false
  end
  local activityCfg = ActivityInterface.GetActivityCfgById(activityId)
  if activityCfg == nil then
    warn("!!!!!!!!invalid activityId:", activityId)
    return false
  end
  if activityCfg.activityType == ActivityType.Daily then
    return true
  end
  local openTime, activeTimeList, closeTime = self:getActivityStatusChangeTime(activityId)
  local curTime = GetServerTime()
  if openTime > 0 and openTime > curTime or closeTime > 0 and closeTime <= curTime then
    return false
  end
  for i, v in ipairs(activeTimeList) do
    if curTime >= v.beginTime and curTime < v.resetTime and openTime <= v.beginTime then
      return true
    end
  end
  return false
end
def.method("number", "=>", "boolean").IsInTime = function(self, activityId)
  local activityCfg = ActivityInterface.GetActivityCfgById(activityId)
  if activityCfg == nil then
    return false
  end
  local curTime = GetServerTime()
  local openTime, activeTimeList, closeTime = self:getActivityStatusChangeTime(activityId)
  if (openTime <= 0 or curTime >= openTime) and (closeTime <= 0 or curTime < closeTime) then
    return true
  else
    return false
  end
end
def.method("number", "number", "number", "=>", "boolean").isOpenWeekDay = function(self, activeWeekDay, durationDay, curWeekDay)
  if curWeekDay == activeWeekDay then
    return true
  end
  local endWeekDay = activeWeekDay + durationDay
  if endWeekDay <= 7 then
    if activeWeekDay <= curWeekDay and curWeekDay < endWeekDay then
      return true
    else
      return false
    end
  else
    local passDay = endWeekDay - 7
    if curWeekDay > passDay and curWeekDay < activeWeekDay then
      return false
    end
    return true
  end
end
def.method("number", "=>", "number", "table", "number").getActivityStatusChangeTime = function(self, activityId)
  local activityCfg = ActivityInterface.GetActivityCfgById(activityId)
  local limitActivityId = activityCfg.activityLimitTimeid
  local curTime = GetServerTime()
  local curTimeTable = AbsoluteTimer.GetServerTimeTable(curTime)
  local nowYear = curTimeTable.year
  local nowMonth = curTimeTable.month
  local nowDay = curTimeTable.day
  local nowDayWeek = curTimeTable.wday
  local curHour = curTimeTable.hour
  local curMin = curTimeTable.min
  local curSec = curTimeTable.sec
  local openTime = 0
  local resetTime = 0
  local closeTime = 0
  if limitActivityId == 0 then
  else
    local timeLimitCommonCfg = TimeCfgUtils.GetTimeLimitCommonCfg(limitActivityId)
    if timeLimitCommonCfg ~= nil then
      openTime = TimeCfgUtils.GetTimeSec(timeLimitCommonCfg.startYear, timeLimitCommonCfg.startMonth, timeLimitCommonCfg.startDay, timeLimitCommonCfg.startHour, timeLimitCommonCfg.startMinute, 0)
      closeTime = TimeCfgUtils.GetTimeSec(timeLimitCommonCfg.endYear, timeLimitCommonCfg.endMonth, timeLimitCommonCfg.endDay, timeLimitCommonCfg.endHour, timeLimitCommonCfg.endMinute, 0)
      if #activityCfg.activityTimeCfgs == 0 then
        return openTime, {
          {beginTime = openTime, resetTime = closeTime}
        }, closeTime
      end
    end
  end
  local activeTimeList = {}
  local isHaveTime = false
  local nextActiveTimeList = {}
  for i, timeDurationCommonCfg in pairs(activityCfg.activityTimeCfgs) do
    local isToday = true
    local weekDiffDay = 0
    local activeWeekDay = timeDurationCommonCfg.timeCommonCfg.activeWeekDay
    if activeWeekDay ~= 0 then
      local isOpenWeekDay = self:isOpenWeekDay(activeWeekDay, timeDurationCommonCfg.lastDay, nowDayWeek)
      if isOpenWeekDay then
        if nowDayWeek < activeWeekDay then
          weekDiffDay = activeWeekDay - nowDayWeek - 7
        else
          weekDiffDay = activeWeekDay - nowDayWeek
        end
      else
        weekDiffDay = activeWeekDay - nowDayWeek
        if weekDiffDay < 0 then
          weekDiffDay = weekDiffDay + 7
        end
      end
    end
    local activeHour = timeDurationCommonCfg.timeCommonCfg.activeHour
    local activeMinute = timeDurationCommonCfg.timeCommonCfg.activeMinute
    local beginTime = TimeCfgUtils.GetTimeSec(nowYear, nowMonth, nowDay, activeHour, activeMinute, 0)
    beginTime = beginTime + weekDiffDay * 86400
    local durationSec = timeDurationCommonCfg.lastDay * 86400 + timeDurationCommonCfg.lastHour * 3600 + timeDurationCommonCfg.lastMinute * 60
    local endTime = beginTime + durationSec
    local durationDayTime = 0
    if activeWeekDay == 0 then
      if 0 < timeDurationCommonCfg.lastDay then
        durationDayTime = timeDurationCommonCfg.lastDay * 86400
      else
        durationDayTime = 86400
      end
    else
      durationDayTime = 604800
    end
    local lastBeginTime = beginTime - durationDayTime
    local lastEndTime = endTime - durationDayTime
    if openTime <= lastBeginTime and (closeTime == 0 or closeTime > lastBeginTime) and curTime >= lastBeginTime and curTime <= lastEndTime then
      beginTime = lastBeginTime
      endTime = lastEndTime
    end
    if not isHaveTime and curTime < endTime then
      isHaveTime = true
    end
    table.insert(activeTimeList, {beginTime = beginTime, resetTime = endTime})
    table.insert(nextActiveTimeList, {
      beginTime = beginTime + durationDayTime,
      resetTime = endTime + durationDayTime
    })
  end
  if isHaveTime == false then
    activeTimeList = nextActiveTimeList
  end
  return openTime, activeTimeList, closeTime
end
def.method("number", "boolean").displayActivityTip = function(self, activityId, isServerStart)
  if _G.IsCrossingServer() then
    warn("!!!!!!isCrossingServer true")
    return
  end
  if self.customCloseActivity[activityId] then
    warn("!!!!!!!!!activity is closed:", activityId)
    return
  end
  local activityCfg = ActivityInterface.GetActivityCfgById(activityId)
  local myHero = require("Main.Hero.HeroModule").Instance()
  local myLevel = 1
  if myHero then
    local heroProp = myHero:GetHeroProp()
    if heroProp then
      myLevel = heroProp.level
    end
  end
  local serverLevelData = require("Main.Server.ServerModule").Instance():GetServerLevelInfo()
  local serverLevel = serverLevelData.level
  if activityCfg and activityCfg.panelCfgid ~= 0 and serverLevel >= activityCfg.serverLevelMin and myLevel >= activityCfg.levelMin and myLevel <= activityCfg.levelMax then
    local curTime = GetServerTime()
    local isOpen = self:isActivityOpend(activityId)
    if isServerStart or isOpen then
      if self._activityTipFunc and self._activityTipFunc[activityId] and not self._activityTipFunc[activityId]() then
        return
      end
      local tipFuncEx = self._activityTipFuncEx and self._activityTipFuncEx[activityId] or nil
      if tipFuncEx and not tipFuncEx(activityId) then
        return
      end
      local configPath = string.format("%s/%s", Application.persistentDataPath, "config/activity_tip.lua")
      local chunk, errorMsg = loadfile(configPath)
      local activityInfo = {}
      if chunk == nil then
        GameUtil.CreateDirectoryForFile(configPath)
      else
        activityInfo = chunk()
      end
      if activityInfo == nil then
        warn("!!!!!!!!!!!!loal file error:", errorMsg)
        return
      end
      local myRoleId = myHero:GetMyRoleId()
      local roleId = Int64.ToNumber(myRoleId)
      local myActivityInfo = activityInfo[roleId] or {}
      local info = myActivityInfo[activityId] or {}
      if type(info) == "number" then
        info = {}
      end
      local lastShowTime = info.time or 0
      local timeIdList = not info.timeIdList and {}
      local isShowTip = false
      local lastTimeTable = AbsoluteTimer.GetServerTimeTable(lastShowTime)
      local curTimeTable = AbsoluteTimer.GetServerTimeTable(curTime)
      if lastShowTime == 0 or lastTimeTable.year ~= curTimeTable.year or lastTimeTable.month ~= curTimeTable.month or lastTimeTable.day ~= curTimeTable.day then
        isShowTip = true
        timeIdList = {}
      else
        local timeLimitTipCfg = ActivityInterface.GetTimeLimitTipCfg(activityCfg.panelCfgid)
        if timeLimitTipCfg == nil then
          warn("!!!!!!!!!timeLimitTipCfg is nil:", activityCfg.panelCfgid)
          return
        end
        local num = timeLimitTipCfg.popTimePerDay
        if num > #timeIdList then
          isShowTip = true
        end
      end
      if isShowTip then
        local timeId
        local openTime, timeList, closeTime = self:getActivityStatusChangeTime(activityId)
        for i, v in pairs(timeList) do
          if curTime >= v.beginTime and curTime < v.resetTime then
            if activityCfg.activityTimeCfgs[i] then
              timeId = activityCfg.activityTimeCfgs[i].id
            else
              timeId = 1
            end
          end
        end
        if timeId then
          local isShown = false
          for _, v in ipairs(timeIdList) do
            if v == timeId then
              isShown = true
            end
          end
          if not isShown then
            table.insert(timeIdList, timeId)
            local limitActivityTip = require("Main.activity.ui.limitActivityTip").Instance()
            limitActivityTip:ShowDlg(activityId)
            myActivityInfo[activityId] = {time = curTime, timeIdList = timeIdList}
            activityInfo[roleId] = myActivityInfo
            require("Main.Common.LuaTableWriter").SaveTable("ActivityTipInfo", configPath, activityInfo)
          end
        end
      end
    end
  end
end
def.method("number").getOnlineAwardExpStart = function(self, endTime)
  local addExpTime = constant.OnlineTreasureBoxActivityConst.activityAddExpTime * 60
  self.onlineBoxTimerId = GameUtil.AddGlobalTimer(addExpTime, false, function()
    if endTime <= 0 then
      GameUtil.RemoveGlobalTimer(self.onlineBoxTimerId)
      self.onlineBoxTimerId = 0
      return
    end
    local req = require("netio.protocol.mzm.gsp.activity.CGetOnlineExpRewardReq").new()
    gmodule.network.sendProtocol(req)
    endTime = endTime - addExpTime
    warn("--------CGetOnlineExpRewardReq:", endTime)
  end)
end
def.method().initAllActivitTimer = function(self)
  self:_LoadAllActivity()
  self.noAchieveLevelActivity = {}
  for _, v in pairs(self._activity_cfg_cache_map) do
    if self:isAchieveActivityLevel(v.id) then
      self:setActivityTimer(v.id)
    else
      self.noAchieveLevelActivity[v.id] = v
    end
  end
end
def.method().refreshActivityTimer = function(self)
  if self.noAchieveLevelActivity then
    local activityIds = {}
    for i, v in pairs(self.noAchieveLevelActivity) do
      if v and self:isAchieveActivityLevel(v.id) then
        table.insert(activityIds, v.id)
      end
    end
    for _, v in ipairs(activityIds) do
      self:setActivityTimer(v)
      if self:isActivityOpend(v) then
        self:displayActivityTip(v, false)
      end
      self.noAchieveLevelActivity[v] = nil
    end
  end
end
def.method("number").setActivityTimer = function(self, activityId)
  if self.specialActivityControl[activityId] then
    return
  end
  local activityCfg = ActivityInterface.GetActivityCfgById(activityId)
  local curTime = GetServerTime()
  local openTime, activeTimeList, closeTime = self:getActivityStatusChangeTime(activityId)
  if curTime >= openTime and (closeTime == 0 or curTime < closeTime) then
    local isStart = false
    local startTime = 0
    for idx, timeInfo in ipairs(activeTimeList) do
      if curTime >= timeInfo.beginTime and curTime < timeInfo.resetTime then
        isStart = true
        self:addResetActivityTimer(activityId, timeInfo.resetTime, idx)
        break
      elseif curTime < timeInfo.beginTime and (startTime > timeInfo.beginTime or startTime == 0) then
        startTime = timeInfo.beginTime
      end
    end
    if not isStart and startTime > 0 then
      if curTime < startTime then
        self:addStartActivityTimer(activityId, startTime)
        return
      end
      if closeTime > 0 and curTime < closeTime then
        self:addCloseActivityTimer(activityId, closeTime)
      end
    end
  elseif openTime >= GetServerTime() then
    self:addOpenActivityTimer(activityId, openTime)
  end
end
def.method("number").setSpecialTimer = function(activityId)
  local isForceOpen = self:isForceOpenActivity(activityId)
  local info = self.specialActivityControl[activityId]
  if isForceOpen then
    self:addSpecialActivityEndTimer(activityId, info.endTime)
  end
end
def.method("number", "number").addOpenActivityTimer = function(self, activityId, openTime)
  local timerId = AbsoluteTimer.AddListener(1, 0, ActivityInterface.OnOpenActivity, {activityId = activityId}, openTime - GetServerTime())
  self.activityTimerMap[activityId] = timerId
end
def.method("number", "number").addStartActivityTimer = function(self, activityId, starTime)
  local timerId = AbsoluteTimer.AddListener(1, 0, ActivityInterface.OnStartActivity, {activityId = activityId}, starTime - GetServerTime())
  self.activityTimerMap[activityId] = timerId
end
def.method("number", "number", "number").addResetActivityTimer = function(self, activityId, resetTime, idx)
  local timerId = AbsoluteTimer.AddListener(1, 0, ActivityInterface.OnResetActivity, {activityId = activityId, index = idx}, resetTime - GetServerTime())
  self.activityTimerMap[activityId] = timerId
end
def.method("number", "number").addSpecialActivityEndTimer = function(self, activityId, endTime)
  local timerId = AbsoluteTimer.AddListener(1, 0, ActivityInterface.OnEndSpecialActivity, {activityId = activityId}, endTime - GetServerTime())
  self.activityTimerMap[activityId] = timerId
end
def.method("number", "number").addCloseActivityTimer = function(self, activityId, closeTime)
  local timerId = AbsoluteTimer.AddListener(1, 0, ActivityInterface.OnEndActivity, {activityId = activityId}, closeTime - GetServerTime())
  self.activityTimerMap[activityId] = timerId
end
def.static("table").OnOpenActivity = function(p)
  Event.DispatchEvent(ModuleId.ACTIVITY, gmodule.notifyId.activity.Activity_Open, {
    p.activityId
  })
  local openTime, activeTimeList, closeTime = instance:getActivityStatusChangeTime(p.activityId)
  local curTime = GetServerTime()
  for _, v in ipairs(activeTimeList) do
    if curTime >= v.beginTime and curTime < v.resetTime then
      ActivityInterface.OnStartActivity(p)
      return
    end
  end
  instance:setActivityTimer(p.activityId)
end
def.static("table").OnStartActivity = function(p)
  local protocols = require("Main.activity.ActivityProtocols")
  protocols.OnSynActivityStart({
    activityid = p.activityId
  })
  local openTime, activeTimeList, closeTime = instance:getActivityStatusChangeTime(p.activityId)
  local curTime = GetServerTime()
  for i, v in ipairs(activeTimeList) do
    if curTime >= v.beginTime and curTime < v.resetTime then
      instance:addResetActivityTimer(p.activityId, v.resetTime, i)
      break
    end
  end
end
def.method("number", "=>", "number").getBigTurnActivityClearTime = function(self, activityId)
  local info = instance:GetActivityInfo(activityId)
  local nextClearTime = 0
  if info then
    local lastClearTime = info.clearTime
    local activityCfg = ActivityInterface.GetActivityCfgById(activityId)
    local timeCfg = activityCfg.activityTimeCfgs[#activityCfg.activityTimeCfgs]
    local lastClearTimeTable = AbsoluteTimer.GetServerTimeTable(lastClearTime)
    local clearYear = lastClearTimeTable.year
    local clearMonth = lastClearTimeTable.month
    local clearDay = lastClearTimeTable.day
    local clearHour = lastClearTimeTable.hour
    local clearMin = lastClearTimeTable.min
    if timeCfg.timeCommonCfg.activeWeekDay ~= 0 then
      local clearDayWeek = lastClearTimeTable.wday
      for i, timeDurationCommonCfg in pairs(activityCfg.activityTimeCfgs) do
        local activeHour = timeDurationCommonCfg.timeCommonCfg.activeHour
        local activeMinute = timeDurationCommonCfg.timeCommonCfg.activeMinute
        if clearDayWeek == timeDurationCommonCfg.timeCommonCfg.activeWeekDay and clearHour == activeHour then
          local diff = timeCfg.timeCommonCfg.activeWeekDay - clearDayWeek
          local diffHour = timeCfg.timeCommonCfg.activeHour - clearHour
          local diffMin = timeCfg.timeCommonCfg.activeMinute - clearMin
          local durationSec = timeDurationCommonCfg.lastDay * 86400 + timeDurationCommonCfg.lastHour * 3600 + timeDurationCommonCfg.lastMinute * 60
          nextClearTime = lastClearTime + diff * 24 * 3600 + diffHour * 3600 + diffMin * 60 + durationSec + (activityCfg.resetDataBigTurn - 1) * 7 * 24 * 3600
          break
        end
      end
    else
      for i, timeDurationCommonCfg in pairs(activityCfg.activityTimeCfgs) do
        local activeHour = timeDurationCommonCfg.timeCommonCfg.activeHour
        local activeMinute = timeDurationCommonCfg.timeCommonCfg.activeMinute
        if clearHour == activeHour then
          local diffHour = timeCfg.timeCommonCfg.activeHour - clearHour
          local diffMin = timeCfg.timeCommonCfg.activeMinute - clearMin
          local durationSec = timeDurationCommonCfg.lastDay * 86400 + timeDurationCommonCfg.lastHour * 3600 + timeDurationCommonCfg.lastMinute * 60
          nextClearTime = lastClearTime + diffHour * 3600 + diffMin * 60 + durationSec + (activityCfg.resetDataBigTurn - 1) * 24 * 3600
          break
        end
      end
    end
  end
  return nextClearTime
end
def.static("table").OnResetActivity = function(p)
  local activityCfg = ActivityInterface.GetActivityCfgById(p.activityId)
  if activityCfg.activityType == ActivityType.Daily then
    instance:ResetActivityInfo(p.activityId)
    Event.DispatchEvent(ModuleId.ACTIVITY, gmodule.notifyId.activity.Activity_Reset, {
      p.activityId
    })
    instance:setActivityTimer(p.activityId)
  else
    local protocols = require("Main.activity.ActivityProtocols")
    protocols.OnSynActivityEnd({
      activityid = p.activityId
    })
    local openTime, activeTimeList, closeTime = instance:getActivityStatusChangeTime(p.activityId)
    if activityCfg.bigReset then
      if p.index == #activeTimeList then
        if activityCfg.resetDataBigTurn <= 1 then
          instance:ResetActivityInfo(p.activityId)
          Event.DispatchEvent(ModuleId.ACTIVITY, gmodule.notifyId.activity.Activity_Reset, {
            p.activityId
          })
        else
          local clearTime = instance:getBigTurnActivityClearTime(p.activityId)
          if GetServerTime() >= clearTime - 60 then
            instance:ResetActivityInfo(p.activityId)
            Event.DispatchEvent(ModuleId.ACTIVITY, gmodule.notifyId.activity.Activity_Reset, {
              p.activityId
            })
          end
        end
      end
    else
      instance:ResetActivityInfo(p.activityId)
      Event.DispatchEvent(ModuleId.ACTIVITY, gmodule.notifyId.activity.Activity_Reset, {
        p.activityId
      })
    end
    local curTime = GetServerTime()
    if closeTime ~= 0 and closeTime <= curTime then
      ActivityInterface.OnCloseActivity(p)
    else
      instance:setActivityTimer(p.activityId)
    end
  end
end
def.static("table").OnCloseActivity = function(p)
  instance:RefreshActivityList()
  Event.DispatchEvent(ModuleId.ACTIVITY, gmodule.notifyId.activity.Activity_Close, {
    p.activityId
  })
end
def.static("table").OnEndActivity = function(p)
  local protocols = require("Main.activity.ActivityProtocols")
  protocols.OnSynActivityEnd({
    activityid = p.activityId
  })
end
def.static("table").OnEndSpecialActivity = function(p)
  instance:setSpecialActivity(p.activityId, ActivityConst.OPEN_STATE_FORCE_CLOSE, 0)
  instance:RefreshActivityList()
  Event.DispatchEvent(ModuleId.ACTIVITY, gmodule.notifyId.activity.Special_Activity_Change, p)
end
def.method("number").removeActivityTimer = function(self, activityId)
  local timerId = self.activityTimerMap[activityId]
  if timeId then
    AbsoluteTimer.RemoveListener(timeId)
  end
end
def.method("number").addCustomCloseActivity = function(self, activityId)
  self.customCloseActivity = self.customCloseActivity or {}
  self.customCloseActivity[activityId] = true
  self:RefreshActivityList()
  Event.DispatchEvent(ModuleId.ACTIVITY, gmodule.notifyId.activity.Activity_ListChanged, {})
end
def.method("number").removeCustomCloseActivity = function(self, activityId)
  if self.customCloseActivity then
    self.customCloseActivity[activityId] = nil
    self:RefreshActivityList()
  end
end
def.method("number", "=>", "boolean").IsCustomCloseActivity = function(self, activityId)
  if self.customCloseActivity == nil then
    return false
  end
  return self.customCloseActivity[activityId] ~= nil
end
def.method("number", "number", "number").setSpecialActivity = function(self, activityId, openState, endTime)
  if openState == 0 then
    self.specialActivityControl[activityId] = nil
    self:removeActivityTimer(activityId)
    self:setActivityTimer(activityId)
    return
  end
  local info = {}
  info.openState = openState
  info.endTime = endTime
  self.specialActivityControl[activityId] = info
  if self:isForceOpenActivity(activityId) then
    self:removeActivityTimer(activityId)
    self:addSpecialActivityEndTimer(activityId, endTime)
  elseif self:isForceCloseActivity(activityId) then
    self:removeActivityTimer(activityId)
  end
end
def.method("number", "=>", "boolean").isForceOpenActivity = function(self, activityId)
  local info = self.specialActivityControl[activityId]
  if info then
    local num = bit.band(info.openState, ActivityConst.OPEN_STATE_FORCE_OPEN)
    if num > 0 then
      return true
    else
      return false
    end
  end
  return false
end
def.method("number", "=>", "boolean").isActivityPause = function(self, activityId)
  local info = self.specialActivityControl[activityId]
  if info then
    local num = bit.band(info.openState, ActivityConst.OPEN_STATE_PAUSE)
    if num > 0 then
      return true
    else
      return false
    end
  end
  return false
end
def.method("number", "=>", "boolean").isForceCloseActivity = function(self, activityId)
  local info = self.specialActivityControl[activityId]
  if info then
    local num = bit.band(info.openState, ActivityConst.OPEN_STATE_FORCE_CLOSE)
    if num > 0 then
      return true
    else
      return false
    end
  end
  return false
end
def.method("=>", "table").GetHuanhunGangHelpInfo = function(self)
  return self._huanhunGangHelpInfo
end
def.static("number", "=>", "table").GetSingleTaskCfg = function(activityId)
  local record = DynamicData.GetRecord(CFG_PATH.DATA_SINGLE_TASK_CFG, activityId)
  if record == nil then
    warn("********************** GetSingleTaskCfg return nil ID =", activityId)
    return nil
  end
  local cfg = {}
  cfg.activityId = record:GetIntValue("activityId")
  cfg.npcid = record:GetIntValue("npcid")
  cfg.serviceid = record:GetIntValue("serviceid")
  cfg.controller = record:GetIntValue("controller")
  cfg.guyNum = record:GetIntValue("guyNum")
  cfg.graphId = 0
  cfg.openId = record:GetIntValue("openId")
  cfg.graphLibId = record:GetIntValue("graphLibId")
  cfg.needHelp = record:GetCharValue("needHelp") ~= 0
  cfg.popTipPerCircle = record:GetCharValue("popTipPerCircle") == 0
  cfg.circleSum = record:GetIntValue("circleSum")
  return cfg
end
def.static("number", "=>", "table").GetSingleTaskGraphLibCfg = function(libId)
  local record = DynamicData.GetRecord(CFG_PATH.DATA_SINGLE_TASK_GRAPH_LIB_CFG, libId)
  if record == nil then
    warn("********************** GetSingleTaskGraphLibCfg return nil libId =", libId)
    return nil
  end
  local cfg = {}
  cfg.graphLibId = libId
  cfg.graphIds = {}
  local rec2 = record:GetStructValue("graphIdsStruct")
  local count = rec2:GetVectorSize("graphIds")
  for i = 1, count do
    local rec3 = rec2:GetVectorValueByIdx("graphIds", i - 1)
    local graphId = rec3:GetIntValue("graphId")
    table.insert(cfg.graphIds, graphId)
  end
  return cfg
end
def.static("number", "number", "=>", "number").GetSingleTaskActivityId = function(npcid, serviceid)
  local entries = DynamicData.GetTable(CFG_PATH.DATA_SINGLE_TASK_CFG)
  if entries == nil then
    warn("!!!!!!!!!no find cfg :", CFG_PATH.DATA_SINGLE_TASK_CFG)
    return 0
  end
  local activityId = 0
  DynamicDataTable.FastGetRecordBegin(entries)
  local recordCount = DynamicDataTable.GetRecordsCount(entries)
  for j = 1, recordCount do
    local record = DynamicDataTable.FastGetRecordByIdx(entries, j - 1)
    local curNpcid = record:GetIntValue("npcid")
    local curServiceid = record:GetIntValue("serviceid")
    if npcid == curNpcid and serviceid == curServiceid then
      activityId = record:GetIntValue("activityId")
      break
    end
  end
  DynamicDataTable.FastGetRecordEnd(entries)
  return activityId
end
def.static("number", "=>", "table").GetSingleTaskCfgByServiceId = function(serviceId)
  local entries = DynamicData.GetTable(CFG_PATH.DATA_SINGLE_TASK_CFG)
  if entries == nil then
    warn("!!!!!!!!!no find cfg :", CFG_PATH.DATA_SINGLE_TASK_CFG)
    return 0
  end
  local activityId = 0
  DynamicDataTable.FastGetRecordBegin(entries)
  local recordCount = DynamicDataTable.GetRecordsCount(entries)
  for j = 1, recordCount do
    local record = DynamicDataTable.FastGetRecordByIdx(entries, j - 1)
    local curServiceid = record:GetIntValue("serviceid")
    if serviceId == curServiceid then
      activityId = record:GetIntValue("activityId")
      break
    end
  end
  DynamicDataTable.FastGetRecordEnd(entries)
  return ActivityInterface.GetSingleTaskCfg(activityId)
end
def.static("=>", "table").GetSingleTaskAllCfgs = function()
  local entries = DynamicData.GetTable(CFG_PATH.DATA_SINGLE_TASK_CFG)
  if entries == nil then
    warn("!!!!!!!!!GetSingleTaskAllCfgs is nil :", CFG_PATH.DATA_SINGLE_TASK_CFG)
    return nil
  end
  local cfgs = {}
  DynamicDataTable.FastGetRecordBegin(entries)
  local recordCount = DynamicDataTable.GetRecordsCount(entries)
  for j = 1, recordCount do
    local record = DynamicDataTable.FastGetRecordByIdx(entries, j - 1)
    local activityId = record:GetIntValue("activityId")
    local cfg = ActivityInterface.GetSingleTaskCfg(activityId)
    if cfg then
      table.insert(cfgs, cfg)
    end
  end
  DynamicDataTable.FastGetRecordEnd(entries)
  return cfgs
end
def.method("number", "=>", "boolean", "number").isSpecialRecommendNum = function(self, activityId)
  local Feature = require("netio.protocol.mzm.gsp.open.ModuleFunSwitchInfo")
  local feature = require("Main.FeatureOpenList.FeatureOpenListModule").Instance()
  if activityId == constant.ZhenYaoActivityCfgConsts.ZhenYao_ACTIVITY_ID and feature:CheckFeatureOpen(Feature.TYPE_ZHENYAO_FIFTY_AWARD) then
    return true, constant.ZhenYaoActivityCfgConsts.ZhenYao_MAX_AWARD_COUNT2
  end
  return false, 0
end
def.static("=>", "table").GetActiveAwardCfg = function()
  local entries = DynamicData.GetTable(CFG_PATH.DATA_ACTIVITE_AWARD_CFG)
  local count = DynamicDataTable.GetRecordsCount(entries)
  DynamicDataTable.FastGetRecordBegin(entries)
  local cfgList = {}
  for i = 1, count do
    local record = DynamicDataTable.GetRecordByIdx(entries, i - 1)
    local level = record:GetIntValue("role_level")
    local rec2 = record:GetStructValue("activeAwardStruct")
    local num = rec2:GetVectorSize("activeAwardVector")
    local cfg = {}
    cfg.role_level = level
    cfg.awardList = {}
    for i = 1, num do
      local awardCfg = {}
      local rec3 = rec2:GetVectorValueByIdx("activeAwardVector", i - 1)
      awardCfg.id = rec3:GetIntValue("id")
      awardCfg.awardItemid = rec3:GetIntValue("awardItemid")
      awardCfg.activiteValue = rec3:GetIntValue("activiteValue")
      awardCfg.awardItemidCount = rec3:GetIntValue("awardItemidCount")
      awardCfg.awardIndex = rec3:GetIntValue("awardIndex")
      table.insert(cfg.awardList, awardCfg)
    end
    table.insert(cfgList, cfg)
  end
  table.sort(cfgList, function(cfg1, cfg2)
    return cfg1.role_level > cfg2.role_level
  end)
  local myLevel = 1
  local heroProp = require("Main.Hero.Interface").GetHeroProp()
  if heroProp ~= nil then
    myLevel = heroProp.level
  end
  for i, v in ipairs(cfgList) do
    if myLevel >= v.role_level then
      return v.awardList
    end
  end
  return nil
end
def.method("number", "=>", "boolean").isNpcExchangeWithinTime = function(self, exchangeId)
  local ItemUtils = require("Main.Item.ItemUtils")
  local exchangeCfg = ItemUtils.GetExchangeItemCfg(exchangeId)
  if exchangeCfg then
    local timeId = exchangeCfg.timeLimitCfgId
    if timeId == 0 then
      return true
    end
    local timeLimitCommonCfg = TimeCfgUtils.GetTimeLimitCommonCfg(timeId)
    local beginTime = TimeCfgUtils.GetTimeSec(timeLimitCommonCfg.startYear, timeLimitCommonCfg.startMonth, timeLimitCommonCfg.startDay, timeLimitCommonCfg.startHour, timeLimitCommonCfg.startMinute, 0)
    local endTime = TimeCfgUtils.GetTimeSec(timeLimitCommonCfg.endYear, timeLimitCommonCfg.endMonth, timeLimitCommonCfg.endDay, timeLimitCommonCfg.endHour, timeLimitCommonCfg.endMinute, 0)
    local curTime = _G.GetServerTime()
    if beginTime <= curTime and endTime > curTime then
      return true
    else
      return false
    end
  end
  return true
end
def.method("number", "=>", "boolean").isFinishActivity = function(self, activityId)
  local cfg = ActivityInterface.GetActivityCfgById(activityId)
  if cfg == nil then
    return false
  end
  local activityInfo = instance:GetActivityInfo(activityId)
  if activityInfo ~= nil and cfg.recommendCount > 0 and activityInfo.count >= cfg.recommendCount then
    return true
  end
  return false
end
ActivityInterface.Commit()
return ActivityInterface

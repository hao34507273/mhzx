local Lplus = require("Lplus")
local OccpGenderInfo = require("Main.TransSex.data.OccpGenderInfo")
local TransSexData = Lplus.Class("TransSexData")
local def = TransSexData.define
local _instance
def.static("=>", TransSexData).Instance = function()
  if _instance == nil then
    _instance = TransSexData()
  end
  return _instance
end
def.field("boolean")._isInfoSynced = false
def.field("table")._ownOccpGenderList = nil
def.field("number")._lastTransTime = 0
def.field("boolean")._isOpenGuide = false
def.method().Init = function(self)
  self:_Reset()
end
def.method()._Reset = function(self)
  self._isInfoSynced = false
  self._ownOccpGenderList = nil
  self._lastTransTime = 0
  self._isOpenGuide = false
end
def.method("table").SyncTransSexInfo = function(self, p)
  self._ownOccpGenderList = {}
  if p.occpations and #p.occpations > 0 then
    for i, info in ipairs(p.occpations) do
      local ogInfo = OccpGenderInfo.new(info.occupation, info.gender)
      table.insert(self._ownOccpGenderList, ogInfo)
    end
  end
  self._lastTransTime = p.last_convert_time
  self._isOpenGuide = 0 < p.is_guide_open
  self._isInfoSynced = true
  Event.DispatchEvent(ModuleId.TRANS_SEX, gmodule.notifyId.TransSex.TRANS_SEX_SYNC_INFO, nil)
end
def.method("=>", "table").GetOwnOccpGenderInfos = function(self)
  return self._ownOccpGenderList
end
def.method("number", "=>", "table").GetOccpGenderInfosByGender = function(self, gender)
  local result = {}
  if self._ownOccpGenderList then
    for i, info in ipairs(self._ownOccpGenderList) do
      if info.gender == gender then
        table.insert(result, info)
      end
    end
  end
  return result
end
def.method("=>", "number").GetLastTransSexTime = function(self)
  return self._lastTransTime
end
def.method("=>", "boolean").IsOpenGuide = function(self)
  return self._isOpenGuide
end
def.method("=>", "boolean").IsInfoSynced = function(self)
  return self._isInfoSynced
end
def.method("table", "table").OnLeaveWorld = function(self, p1, p2)
  self:_Reset()
end
TransSexData.Commit()
return TransSexData

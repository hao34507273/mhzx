local Lplus = require("Lplus")
local ModuleBase = require("Main.module.ModuleBase")
local ModuleFunSwitchInfo = require("netio.protocol.mzm.gsp.open.ModuleFunSwitchInfo")
local LuaPlayerPrefs = require("Main.Common.LuaPlayerPrefs")
local TransSexModule = Lplus.Extend(ModuleBase, "TransSexModule")
local instance
local def = TransSexModule.define
def.static("=>", TransSexModule).Instance = function()
  if instance == nil then
    instance = TransSexModule()
  end
  return instance
end
def.override().Init = function(self)
  ModuleBase.Init(self)
  require("Main.TransSex.TransSexProtocols").RegisterProtocols()
  require("Main.TransSex.TransSexMgr").Instance():Init()
  require("Main.TransSex.data.TransSexData").Instance():Init()
end
def.method("boolean", "=>", "boolean").IsOpen = function(self, bToast)
  local result = true
  if false == self:IsFeatrueOpen(bToast) then
    result = false
  elseif false == self:ReachMinLevel(bToast) then
    result = false
  end
  return result
end
def.method("boolean", "=>", "boolean").IsFeatrueOpen = function(self, bToast)
  local result = _G.IsFeatureOpen(ModuleFunSwitchInfo.TYPE_GENDER_CONVERT)
  if false == result and bToast then
    Toast(textRes.TransSex.FEATRUE_IDIP_NOT_OPEN)
  end
  return result
end
def.method("boolean", "=>", "boolean").ReachMinLevel = function(self, bToast)
  local result = false
  local heroProp = require("Main.Hero.Interface").GetHeroProp()
  local minOpenLevel = constant.CGenderConvertConsts.LEVLE_LIMIT
  if heroProp ~= nil then
    local rolelevel = heroProp.level
    result = minOpenLevel <= rolelevel
  end
  if bToast and false == result then
    Toast(string.format(textRes.TransSex.NOT_OPEN_LOW_LEVEL, minOpenLevel))
  end
  return result
end
def.method("=>", "boolean").NeedEqpsReddot = function(self)
  if _G.IsFeatureOpen(ModuleFunSwitchInfo.TYPE_GENDER_CONVERT) then
    return LuaPlayerPrefs.HasRoleKey(require("Main.TransSex.TransSexMgr").TRANS_SEX_SUCC_EFFECT)
  else
    return false
  end
end
def.method().ConsumeEqpsReddot = function(self)
  local TransSexMgr = require("Main.TransSex.TransSexMgr")
  if LuaPlayerPrefs.HasRoleKey(TransSexMgr.TRANS_SEX_SUCC_EFFECT) then
    warn("[TransSexModule:ConsumeEqpsReddot] consume reddot.")
    LuaPlayerPrefs.DeleteRoleKey(TransSexMgr.TRANS_SEX_SUCC_EFFECT)
    LuaPlayerPrefs.Save()
  end
end
return TransSexModule.Commit()

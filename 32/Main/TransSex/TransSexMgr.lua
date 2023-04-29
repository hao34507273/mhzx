local Lplus = require("Lplus")
local TransSexData = require("Main.TransSex.data.TransSexData")
local TransSexProtocols = require("Main.TransSex.TransSexProtocols")
local ModuleFunSwitchInfo = require("netio.protocol.mzm.gsp.open.ModuleFunSwitchInfo")
local LoadingMgr = require("Main.Common.LoadingMgr")
local LuaPlayerPrefs = require("Main.Common.LuaPlayerPrefs")
local EnterWorldAlertMgr = require("Main.Common.EnterWorldAlertMgr")
local TransSexMgr = Lplus.Class("TransSexMgr")
local def = TransSexMgr.define
local instance
def.static("=>", TransSexMgr).Instance = function()
  if instance == nil then
    instance = TransSexMgr()
  end
  return instance
end
def.const("string").TRANS_SEX_SUCC_CONFIRM = "trans_sex_succ_confirm"
def.const("string").TRANS_SEX_SUCC_EFFECT = "trans_sex_succ_effect"
def.method().Init = function(self)
  self:RegisterEvents()
  TransSexMgr.CustomNPCService()
end
def.method().RegisterEvents = function(self)
  Event.RegisterEvent(ModuleId.FEATURE, gmodule.notifyId.Feature.FeatureOpenInit, TransSexMgr.OnFeatureOpenInit)
  Event.RegisterEvent(ModuleId.FEATURE, gmodule.notifyId.Feature.FeatureOpenChange, TransSexMgr.OnFunctionOpenChange)
  Event.RegisterEvent(ModuleId.LOGIN, gmodule.notifyId.Login.ENTER_WORLD, TransSexMgr.OnEnterWorld)
  Event.RegisterEvent(ModuleId.LOGIN, gmodule.notifyId.Login.LEAVE_WORLD, TransSexMgr.OnLeaveWorld)
  Event.RegisterEvent(ModuleId.NPC, gmodule.notifyId.NPC.NPC_SERVICE, TransSexMgr.OnNPCService)
  Event.RegisterEvent(ModuleId.TRANS_SEX, gmodule.notifyId.TransSex.TRANS_SEX_SUCESS, TransSexMgr.OnGenderChange)
  Event.RegisterEvent(ModuleId.LOGIN, gmodule.notifyId.Login.LOGIN_LOADING_FINISHED, TransSexMgr.OnLoadingFinished)
  Event.RegisterEvent(ModuleId.TRANS_SEX, gmodule.notifyId.TransSex.TRANS_SEX_SYNC_INFO, TransSexMgr.OnSyncTransSexInfo)
  EnterWorldAlertMgr.Instance():RegisterEx(EnterWorldAlertMgr.CustomOrder.TransSexSucc, TransSexMgr.CheckTransSexSuccConfirm, self, {reconnectAlert = true})
end
def.static("table", "table").OnFeatureOpenInit = function(param, context)
  local isOpen = IsFeatureOpen(ModuleFunSwitchInfo.TYPE_GENDER_CONVERT)
  Event.DispatchEvent(ModuleId.PUBROLE, gmodule.notifyId.Pubrole.SET_NPC_ENABLE, {
    npcid = constant.CGenderConvertConsts.NPC_CFG_ID,
    show = isOpen
  })
end
def.static("table", "table").OnFunctionOpenChange = function(param, context)
  if param.feature == ModuleFunSwitchInfo.TYPE_GENDER_CONVERT then
    local isOpen = IsFeatureOpen(ModuleFunSwitchInfo.TYPE_GENDER_CONVERT)
    if not isOpen then
      local TransSexPanel = require("Main.TransSex.ui.TransSexPanel")
      if TransSexPanel.Instance():IsShow() then
        TransSexPanel.Instance():DestroyPanel()
      end
    end
    Event.DispatchEvent(ModuleId.PUBROLE, gmodule.notifyId.Pubrole.SET_NPC_ENABLE, {
      npcid = constant.CGenderConvertConsts.NPC_CFG_ID,
      show = isOpen
    })
  end
end
def.static("table", "table").OnEnterWorld = function(param, context)
end
def.static("table", "table").OnLeaveWorld = function(param, context)
  TransSexData.Instance():OnLeaveWorld(param, context)
end
def.static("table", "table").OnSyncTransSexInfo = function()
  TransSexMgr.Instance():TryShowTransSexSuccConfirm(false)
end
def.method().CheckTransSexSuccConfirm = function(self)
  self:TryShowTransSexSuccConfirm(true)
end
def.method("boolean").TryShowTransSexSuccConfirm = function(self, bNext)
  if not require("Main.TransSex.TransSexModule").Instance():IsFeatrueOpen(false) then
    warn("[TransSexMgr:TryShowTransSexSuccConfirm] IDIP closed!")
    if bNext then
      EnterWorldAlertMgr.Instance():Next()
    end
    return
  end
  if LuaPlayerPrefs.HasRoleKey(TransSexMgr.TRANS_SEX_SUCC_CONFIRM) then
    if TransSexData.Instance():IsInfoSynced() then
      LuaPlayerPrefs.DeleteRoleKey(TransSexMgr.TRANS_SEX_SUCC_CONFIRM)
      LuaPlayerPrefs.Save()
    end
  elseif bNext then
    EnterWorldAlertMgr.Instance():Next()
  end
end
def.static("table", "table").OnNPCService = function(param, context)
  local srvcId = param[1]
  local npcId = param[2]
  if npcId == constant.CGenderConvertConsts.NPC_CFG_ID and srvcId == constant.CGenderConvertConsts.CONVERT_SERVICE then
    if not require("Main.TransSex.TransSexModule").Instance():IsFeatrueOpen(true) then
      return
    end
    local TransSexPanel = require("Main.TransSex.ui.TransSexPanel")
    TransSexPanel.ShowPanel()
  end
end
def.static().CustomNPCService = function(self)
  local NPCInterface = require("Main.npc.NPCInterface")
  NPCInterface.Instance():RegisterNPCServiceCustomCondition(constant.CGenderConvertConsts.CONVERT_SERVICE, TransSexMgr.CheckTransSexOpen)
end
def.static("number", "=>", "boolean").CheckTransSexOpen = function(serviceId)
  return require("Main.TransSex.TransSexModule").Instance():IsFeatrueOpen(false)
end
local PreloadResType = {PROTOCOL = 1, PROTOCOL_FAKE = 2}
local protTimerId
def.static("table", "table").OnGenderChange = function(params, context)
  LuaPlayerPrefs.SetRoleInt(TransSexMgr.TRANS_SEX_SUCC_CONFIRM, 1)
  LuaPlayerPrefs.SetRoleInt(TransSexMgr.TRANS_SEX_SUCC_EFFECT, 1)
  LuaPlayerPrefs.Save()
  TransSexMgr.Instance():ReconnectAs(params.occupation, params.gender)
end
def.method("number", "number").ReconnectAs = function(self, occupation, gender)
  require("Main.Login.InWorldLoginMgr").Instance():Reconnect({needLoading = false})
  self:StartLoading(occupation, gender)
end
def.method("number", "number").StartLoading = function(self, occupation, gender)
  local loadingPanel = require("Main.TransSex.ui.TransSexLoadingPanel").Instance()
  local imagePath = require("Main.TransSex.TransSexUtils").GetLoadingImage(occupation, gender)
  loadingPanel:SetBackgroundImage(imagePath)
  LoadingMgr.Instance():StartLoadingEx(LoadingMgr.LoadingType.TransSex, {
    [PreloadResType.PROTOCOL] = 1,
    [PreloadResType.PROTOCOL_FAKE] = 80
  }, nil, nil, loadingPanel)
  local progress = 0
  local count = 0
  local function fakeProtoclUpdate(...)
    protTimerId = GameUtil.AddGlobalTimer(0.1, true, function()
      if protTimerId == nil then
        return
      end
      if LoadingMgr.Instance().loadingType ~= LoadingMgr.LoadingType.TransSex then
        protTimerId = nil
        return
      end
      progress = progress + 0.5
      count = count + 1
      local val = math.log10(1 + progress)
      if val >= 1 then
        val = 1
      end
      LoadingMgr.Instance():UpdateTaskProgress(PreloadResType.PROTOCOL_FAKE, val)
      if val < 1 then
        fakeProtoclUpdate()
      else
        protTimerId = nil
      end
    end)
  end
  fakeProtoclUpdate()
end
def.static("table", "table").OnLoadingFinished = function()
  if LoadingMgr.Instance().loadingType == LoadingMgr.LoadingType.TransSex then
    LoadingMgr.Instance():UpdateTaskProgress(PreloadResType.PROTOCOL, 1)
    LoadingMgr.Instance():UpdateTaskProgress(PreloadResType.PROTOCOL_FAKE, 1)
    protTimerId = nil
  end
end
TransSexMgr.Commit()
return TransSexMgr

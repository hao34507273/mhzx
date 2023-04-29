local Lplus = require("Lplus")
local ECPanelBase = require("GUI.ECPanelBase")
local SelectCharacterPanel = Lplus.Extend(ECPanelBase, "SelectCharacterPanel")
local def = SelectCharacterPanel.define
local instance
local LoginModule = gmodule.moduleMgr:GetModule(ModuleId.LOGIN)
local ECUIModel = require("Model.ECUIModel")
local GenderEnum = require("consts.mzm.gsp.occupation.confbean.SGenderEnum")
local OccupationEnum = require("consts.mzm.gsp.occupation.confbean.SOccupationEnum")
local LoginUtility = require("Main.Login.LoginUtility")
local ECSoundMan = require("Sound.ECSoundMan")
local PreRandom = require("Main.Common.PreRandom")
local ECPartComponent = require("Model.ECPartComponent")
local ZoomCameraHelper = require("Main.Common.ZoomCameraHelper")
local ECGame = require("Main.ECGame")
local EC = require("Types.Vector")
local GUIUtils = require("GUI.GUIUtils")
local ECMSDK = require("ProxySDK.ECMSDK")
local CommonConfirmDlg = require("GUI.CommonConfirmDlg")
local Vector = EC
local NOT_EXIST = -1
local BG_DEFAULT_SCALE = 0.8
local ModelTransformDir = {
  Up = -1,
  Middle = 0,
  Down = 1
}
local NAME_2DMODEL_ROOT = "2d model root"
local MODEL2D_DRAG_END_DISTANCE = 100
def.const("table").occupationOrderList = {}
def.field("number").selectedOccupation = NOT_EXIST
def.field("number").selectedGender = NOT_EXIST
def.field("string").enteredName = ""
def.field("table").model2d = nil
def.field("table").model3d = nil
def.field("boolean").isDrag = false
def.field("table").occupationIDTable = nil
def.field("userdata").bgTexture = nil
def.field("number").animatedTime = 0
def.field("boolean").isUserEntered = false
def.field("boolean").hasUserRandomName = false
def.field("table").catchedCreateRoleCfg = nil
def.field("table").zoomBGCam = nil
def.field("boolean").hasRandomRole = false
def.field("number").repositionTimer = 0
def.field("number").changeBGDelay = 0
def.field("userdata").m_mainFx = nil
def.field("userdata").m_leftWeaponFx = nil
def.field("userdata").m_rightWeaponFx = nil
def.field("userdata").m_createRoleScene = nil
def.field("userdata").m_createRoleCamObj = nil
def.field("userdata").m_CRRootObj = nil
def.field("userdata").m_2dModelRoot = nil
def.field("userdata").m_curSceneObj = nil
def.field("userdata").m_curRoleObj = nil
def.field("userdata").m_BGObj = nil
def.field("userdata").m_BGCameraObj = nil
def.field("userdata").m_CRCC = nil
def.field("table").uiObjs = nil
def.static("=>", SelectCharacterPanel).Instance = function()
  if instance == nil then
    instance = SelectCharacterPanel()
  end
  return instance
end
def.method().ShowPanel = function(self)
  if self.m_panel then
    self:DestroyPanel()
  end
  self.m_SyncLoad = true
  self:CreatePanel(RESPATH.PREFAB_LOGIN_CREATE_ROLE_PANEL_RES, 1)
end
def.static("table", "table").OnFeatureOpenChange = function(p)
  warn("CreatePanel OnFeatureOpenChange--------------------", p.feature, p.open)
  if p.feature == require("netio.protocol.mzm.gsp.open.ModuleFunSwitchInfo").TYPE_INVITE_FRIENDS then
    GUIUtils.SetActive(self.uiObjs.Group_Invite, p.open)
  end
end
def.override().OnCreate = function(self)
  LoginUtility.DestroyLoginBackground()
  Event.RegisterEvent(ModuleId.LOGIN, gmodule.notifyId.Login.LOGIN_ROLE_SUCCESS, SelectCharacterPanel.OnCreateRoleSucess)
  Event.RegisterEvent(ModuleId.LOGIN, gmodule.notifyId.Login.RESET_UI, SelectCharacterPanel.OnResetUI)
  Event.RegisterEvent(ModuleId.FEATURE, gmodule.notifyId.Feature.FeatureOpenPreChange, SelectCharacterPanel.OnFeatureOpenChange)
  self:Init()
end
def.method().HidePanel = function(self)
  self:DestroyPanel()
end
def.override().OnDestroy = function(self)
  Event.UnregisterEvent(ModuleId.LOGIN, gmodule.notifyId.Login.LOGIN_ROLE_SUCCESS, SelectCharacterPanel.OnCreateRoleSucess)
  Event.UnregisterEvent(ModuleId.LOGIN, gmodule.notifyId.Login.RESET_UI, SelectCharacterPanel.OnResetUI)
  Event.UnregisterEvent(ModuleId.FEATURE, gmodule.notifyId.Feature.FeatureOpenPreChange, SelectCharacterPanel.OnFeatureOpenChange)
  if self.repositionTimer ~= 0 then
    GameUtil.RemoveGlobalTimer(self.repositionTimer)
  end
  self.hasRandomRole = false
  self.hasUserRandomName = false
  self.occupationIDTable = nil
  if self.model2d then
    self.model2d:Destroy()
    self.model2d = nil
  end
  if self.model3d then
    self.model3d:Destroy()
    self.model3d = nil
  end
  if self.m_2dModelRoot then
    GameObject.Destroy(self.m_2dModelRoot)
    self.m_2dModelRoot = nil
  end
  if self.uiObjs.lockedObj then
    GameObject.Destroy(self.uiObjs.lockedObj)
  end
  local NameData = require("Main.Login.data.NameData")
  NameData.ClearData()
  self:DestroyCreateRoleScene()
  self.uiObjs = nil
end
def.method("string").onClick = function(self, id)
  if id == "Btn_Male" or id == "Btn_Female" then
    self:OnGenderButtonClick(id)
  elseif id == "Btn_Dice" then
    self.isUserEntered = false
    self:SetRandomName()
  elseif id == "Btn_Start" then
    self:OnStartGameButtonClick()
  elseif string.sub(id, 1, 10) == "Btn_School" then
    self:OnOccupationButtonClick(id)
  elseif id == "Btn_Right" then
    self:OnDownButtonClick()
  elseif id == "Btn_Left" then
    self:OnUpButtonClick()
  elseif id == "Btn_Back" then
    if platform == 1 then
      Time.timeScale = 0.01
      GameUtil.AddGlobalLateTimer(0.001, true, function()
        self:OnBackButtonClick()
      end)
    else
      self:OnBackButtonClick()
    end
  elseif string.sub(id, 1, #"Group_Skill") == "Group_Skill" then
    local index = tonumber(string.sub(id, #"Group_Skill" + 1, -1))
    self:OnSkillSelected(index)
  elseif id == "LockedObjIns" then
    self:OnLockedObjInsClicked()
  elseif id == "Model" then
    self:OnModelClicked()
  end
end
def.method("string", "userdata").onSubmit = function(self, id, ctrl)
  print(string.format("%s submit event: id = %s", tostring(self), id))
  if id == "Img_BgInput" then
    self.isUserEntered = true
    local uiInput = self.uiObjs.Group_RB:FindDirect("Img_BgInput"):GetComponent("UIInput")
    self.enteredName = uiInput:get_value()
    self:ValidEnteredName(self.enteredName)
    self.enteredName = _G.TrimIllegalChar(self.enteredName)
    uiInput:set_value(self.enteredName)
  end
end
def.method().Init = function(self)
  self.uiObjs = {}
  self.uiObjs.Img_Bg0 = self.m_panel:FindDirect("Img_Bg0")
  self.uiObjs.Img_Shi = self.uiObjs.Img_Bg0:FindDirect("Img_Shi")
  self.uiObjs.Group_RT = self.uiObjs.Img_Bg0:FindDirect("Group_RT")
  self.uiObjs.Group_RM = self.uiObjs.Img_Bg0:FindDirect("Group_RM")
  self.uiObjs.Group_RB = self.uiObjs.Img_Bg0:FindDirect("Group_RB")
  self.uiObjs.Group_Invite = self.uiObjs.Img_Bg0:FindDirect("Group_Invite")
  self.uiObjs.Img_BgSchool = self.uiObjs.Img_Bg0:FindDirect("Img_BgSchool")
  self.uiObjs.Model2d = self.uiObjs.Img_Bg0:FindDirect("Model1")
  self.uiObjs.Img_MenPai = self.uiObjs.Img_Bg0:FindDirect("Img_MenPai")
  self.uiObjs.Model3d = self.uiObjs.Group_RM:FindDirect("Img_BgCharacter/Model")
  self.uiObjs.uiInuptName = self.uiObjs.Group_RB:FindDirect("Img_BgInput"):GetComponent("UIInput")
  self.uiObjs.Img_MenPaiFeature = self.uiObjs.Group_RT:FindDirect("Group_SchoolDes/Img_MenPaiFeature")
  self.uiObjs.Group_SkillDes = self.uiObjs.Group_RM:FindDirect("Group_SkillDes")
  self.uiObjs.Img_Shi_Root = self.uiObjs.Img_Bg0:FindDirect("Img_Shi_Root")
  self.uiObjs.Img_Shi = self.uiObjs.Img_Shi_Root:FindDirect("Img_Shi")
  self.uiObjs.Btn_Start = self.uiObjs.Group_RB:FindDirect("Btn_Start")
  self.occupationIDTable = {
    Btn_School01 = OccupationEnum.GUI_WANG_ZONG,
    Btn_School02 = OccupationEnum.QIN_GYUN_MEN,
    Btn_School03 = OccupationEnum.TIAN_YIN_SI,
    Btn_School04 = OccupationEnum.FEN_XIANG_GU,
    Btn_School05 = OccupationEnum.HE_HUAN_PAI,
    Btn_School06 = OccupationEnum.SHENG_WU_JIAO
  }
  if IsFeatureOpen(require("netio.protocol.mzm.gsp.open.ModuleFunSwitchInfo").TYPE_INVITE_FRIENDS) then
    self:UpdateInviteField()
  else
    GUIUtils.SetActive(self.uiObjs.Group_Invite, false)
  end
  self:InitOccupationBtns()
  self.isUserEntered = false
  self:TouchGameObject(self.m_panel, self.m_parent)
end
def.method().InitOccupationBtns = function(self)
  local lockedObj = GameObject.GameObject("LockedObj")
  local uiWidget = lockedObj:AddComponent("UIWidget")
  uiWidget.autoResizeBoxCollider = true
  lockedObj:AddComponent("BoxCollider")
  lockedObj:SetActive(false)
  lockedObj.layer = self.m_panel.layer
  self.uiObjs.lockedObj = lockedObj
  local Btn_Male = self.uiObjs.Group_RT:FindDirect("Btn_Male")
  local Btn_Female = self.uiObjs.Group_RT:FindDirect("Btn_Female")
  self:AddLockedObjIns(Btn_Male, "LockedObjIns")
  self:AddLockedObjIns(Btn_Female, "LockedObjIns")
  for k, v in pairs(self.occupationIDTable) do
    local uiButton = self.uiObjs.Img_BgSchool:FindDirect(k):GetComponent("UIButton")
    if LoginUtility.Instance():IsOccupationUnlocked(v) then
      uiButton.isEnabled = true
    else
      uiButton.isEnabled = false
      self:AddLockedObjIns(uiButton.gameObject, "LockedObjIns")
    end
  end
end
def.method().UpdateInviteField = function(self)
  local sdkInfo = ECMSDK.GetMSDKInfo()
  local openid = sdkInfo.openId
  if platform == 0 then
    local userName = ECGame.Instance().m_UserName
    local s, e = userName:find("shadow")
    openid = userName:sub(1, s - 2)
  end
  local zoneid = require("netio.Network").m_zoneid
  local channel = "shadow"
  if _G.LoginPlatform == MSDK_LOGIN_PLATFORM.QQ then
    channel = "qq"
  elseif _G.LoginPlatform == MSDK_LOGIN_PLATFORM.WX then
    channel = "wechat"
  end
  local url = _G.GetDirVersionService("can_use_invite_code")
  url = _G.NormalizeHttpURL(url)
  warn(url, "~~~~~~~~~~~~~~", openid)
  if url and openid and zoneid then
    local postData = ("openid=%s&channel=%s&zoneid=%d"):format(openid, channel, zoneid)
    GameUtil.httpPost(url, 0, postData, function(success, url, postId, data)
      if success then
        warn(url, "UpdateInviteField..............", data:get_string())
        local json = require("Utility.json")
        local param = json.decode(data:get_string())
        if param.ret == 0 then
          if param.data == 0 then
            local roleList = LoginModule:GetRoleList()
            GUIUtils.SetActive(self.uiObjs.Group_Invite, (not roleList or #roleList == 0) and _G.LoginPlatform ~= MSDK_LOGIN_PLATFORM.GUEST)
          else
            GUIUtils.SetActive(self.uiObjs.Group_Invite, false)
          end
        else
          Debug.LogWarning("The other retcode is" .. param.ret)
        end
      else
        Debug.LogWarning("There is something wrong in the url or post body")
      end
    end, {})
  else
    GUIUtils.SetActive(self.uiObjs.Group_Invite, false)
    Debug.LogWarning("SelectCharacterPanel OnStartGameButtonClick openid is not exsit")
  end
end
def.method().AsyncLoadBackgroundImage = function(self)
  local resPath = LoginUtility.GetCreateRoleOccupationBGPath(self.selectedOccupation)
  GameUtil.AsyncLoad(resPath, function(ass)
    if ass == nil then
      return
    end
    if getmetatable(ass).name == "Texture2D" then
      warn("You are use old data, create role background isn't texture now.")
      return
    end
    GameUtil.AddGlobalTimer(self.changeBGDelay, true, function(...)
      if self.m_createRoleScene == nil then
        return
      end
      if self.m_curSceneObj and not self.m_curSceneObj.isnil then
        GameObject.Destroy(self.m_curSceneObj)
        self.m_curSceneObj = nil
      end
      local bg = GameObject.Instantiate(ass)
      bg.transform.parent = self.m_BGObj.transform
      bg.transform.localPosition = EC.Vector3.new(0, 0, 0)
      bg.transform.localRotation = Quaternion.Euler(EC.Vector3.new(0, 180, 0))
      self.m_curSceneObj = bg
    end)
  end)
end
def.method().RandomSelectRole = function(self)
  local unlockedRoleList = LoginUtility.Instance():GetUnlockedRoleList()
  local roleNum = #unlockedRoleList
  local index = PreRandom.Random(1, roleNum)
  self.selectedOccupation = unlockedRoleList[index].occupation
  self.selectedGender = unlockedRoleList[index].gender
  self:SelectOccupation(self.selectedOccupation, ModelTransformDir.Middle)
end
local repositionStoptimer = 0
def.method().UpdateToggleState = function(self)
  local aniDuration = 0
  local function SetToggleState(toggleEx, isFocus)
    toggleEx.value = isFocus
    local Img_Cloud = toggleEx.gameObject:FindChild("Img_Cloud")
    Img_Cloud:SetActive(isFocus)
    Img_Cloud.transform.localScale = EC.Vector3.zero
    if isFocus then
      local uiTweener = Img_Cloud:GetComponent("UITweener")
      uiTweener.tweenFactor = 0
      uiTweener:PlayForward()
      aniDuration = uiTweener.duration
    end
  end
  local function StopRepositionTimer()
    if self.repositionTimer ~= 0 then
      GameUtil.RemoveGlobalTimer(self.repositionTimer)
    end
  end
  local function StartRepositionTimer()
    StopRepositionTimer()
    local uiTable = self.uiObjs.Img_BgSchool:GetComponent("UITable")
    self.repositionTimer = GameUtil.AddGlobalLateTimer(0, false, function(...)
      if uiTable and not uiTable.isnil then
        uiTable:Reposition()
      end
    end)
  end
  local objName = ""
  for k, v in pairs(self.occupationIDTable) do
    local uiToggleEx = self.uiObjs.Img_BgSchool:FindDirect(k):GetComponent("UIToggleEx")
    if v == self.selectedOccupation then
      SetToggleState(uiToggleEx, true)
    else
      SetToggleState(uiToggleEx, false)
    end
  end
  StartRepositionTimer()
  if repositionStoptimer ~= 0 then
    GameUtil.RemoveGlobalTimer(repositionStoptimer)
    repositionStoptimer = 0
  end
  repositionStoptimer = GameUtil.AddGlobalTimer(aniDuration, true, function()
    StopRepositionTimer()
  end)
  self:UpdateGenderToggleState()
end
def.method().UpdateGenderToggleState = function(self)
  local value = false
  if self.selectedGender == GenderEnum.MALE then
    value = true
  end
  self.uiObjs.Group_RT:FindDirect("Btn_Male"):GetComponent("UIToggle"):set_value(value)
  self.uiObjs.Group_RT:FindDirect("Btn_Female"):GetComponent("UIToggle"):set_value(not value)
  local uiButton = self.uiObjs.Group_RT:FindDirect("Btn_Male"):GetComponent("UIButton")
  if LoginUtility.Instance():IsOccupationGenderUnlocked(self.selectedOccupation, GenderEnum.MALE) then
    uiButton.isEnabled = true
  else
    uiButton.isEnabled = false
  end
  local uiButton = self.uiObjs.Group_RT:FindDirect("Btn_Female"):GetComponent("UIButton")
  if LoginUtility.Instance():IsOccupationGenderUnlocked(self.selectedOccupation, GenderEnum.FEMALE) then
    uiButton.isEnabled = true
  else
    uiButton.isEnabled = false
  end
end
def.method("userdata").SetBtnColorAsDisabledColor = function(self, uiButton)
  uiButton.defaultColor = uiButton.disabledColor
  uiButton.hover = uiButton.disabledColor
  uiButton.pressed = uiButton.disabledColor
end
def.method("userdata").ResetBtnColor = function(self, uiButton)
  uiButton:ResetDefaultColor()
  uiButton.hover = uiButton.defaultColor
  uiButton.pressed = uiButton.defaultColor
end
def.method().UpdateRandomName = function(self)
  if self.isUserEntered or not self.hasUserRandomName then
    return
  end
  self:SetRandomName()
end
def.method().SetRandomName = function(self)
  self.hasUserRandomName = true
  local NameData = require("Main.Login.data.NameData")
  local name
  if self.selectedGender == GenderEnum.MALE then
    name = NameData.GetRandomMaleName()
  else
    name = NameData.GetRandomFemaleName()
  end
  self:SetName(name)
end
def.method("string").SetName = function(self, name)
  self.enteredName = name
  self.uiObjs.uiInuptName:set_value(name)
end
def.method("string").SetMenPaiDescibe = function(self, content)
  local spriteName = LoginUtility.GetOccupationImage2SpriteName(self.selectedOccupation)
  GUIUtils.SetSprite(self.uiObjs.Img_MenPai, spriteName)
  self:TweenWidgetAlpha(self.uiObjs.Img_MenPai)
  local spriteName = LoginUtility.GetOccupationDescSpriteName(self.selectedOccupation)
  GUIUtils.SetSprite(self.uiObjs.Img_MenPaiFeature, spriteName)
  self:TweenWidgetAlpha(self.uiObjs.Img_MenPaiFeature)
end
def.method("userdata").TweenWidgetAlpha = function(self, go)
  if go == nil or go.isnil then
    return
  end
  local duration = 1
  go:GetComponent("UIWidget").alpha = 0
  TweenAlpha.Begin(go, duration, 1)
end
def.method("number").UpdateModel = function(self, dir)
  self:Update2DUIModel(dir)
  self:Update3DUIModel()
  local audioId = self:GetRandomRoleAudio()
  ECSoundMan.Instance():Play2DInterruptSoundByID(audioId)
end
def.method("=>", "number").GetRandomRoleAudio = function(self)
  local cfg = self.catchedCreateRoleCfg
  local selected = math.random(1, #cfg.audioIdList)
  return cfg.audioIdList[selected]
end
local MODEL_2D_ORIGINAL_POS = EC.Vector3.new(-126, 5, 0)
def.method("number").Update2DUIModel = function(self, dir)
  local transformPos = {
    [ModelTransformDir.Up] = {
      old = {
        ["begin"] = nil,
        ["end"] = EC.Vector3.new(-241, 364, 0)
      },
      new = {
        ["begin"] = EC.Vector3.new(-276, -367, 0),
        ["end"] = MODEL_2D_ORIGINAL_POS
      }
    },
    [ModelTransformDir.Down] = {
      old = {
        ["begin"] = nil,
        ["end"] = EC.Vector3.new(-276, -367, 0)
      },
      new = {
        ["begin"] = EC.Vector3.new(-241, 364, 0),
        ["end"] = MODEL_2D_ORIGINAL_POS
      }
    }
  }
  transformPos[ModelTransformDir.Middle] = transformPos[ModelTransformDir.Down]
  local isMiddleTrans = false
  self.changeBGDelay = 0
  if isMiddleTrans or dir ~= ModelTransformDir.Middle then
    do
      local pos = transformPos[dir]
      local newModel2d = GameObject.Instantiate(self.uiObjs.Model2d)
      newModel2d.name = self.uiObjs.Model2d.name
      newModel2d.transform.parent = self.uiObjs.Img_Bg0.transform
      newModel2d.transform.localPosition = pos.new.begin
      newModel2d.transform.localScale = EC.Vector3.one * 0.1
      newModel2d:GetComponent("UIWidget").alpha = 0
      self.m_msgHandler:Touch(newModel2d)
      local duration = 0.3
      self.changeBGDelay = duration
      TweenScale.Begin(newModel2d, duration, EC.Vector3.one)
      TweenPosition.Begin(newModel2d, duration, pos.new["end"])
      TweenAlpha.Begin(newModel2d, duration, 1)
      local oldModel2d = self.uiObjs.Model2d
      TweenScale.Begin(oldModel2d, duration, EC.Vector3.one * 0.1)
      TweenPosition.Begin(oldModel2d, duration, pos.old["end"])
      TweenAlpha.Begin(oldModel2d, duration, 0)
      self.uiObjs.Model2d = newModel2d
      local new2dModelRoot = GameObject.GameObject(NAME_2DMODEL_ROOT)
      self.m_2dModelRoot.transform.localPosition = EC.Vector3.new(0, 0, 0)
      self.m_2dModelRoot.transform.localRotation = Quaternion.Euler(EC.Vector3.new(0, 0, 0))
      local old2dModelRoot = self.m_2dModelRoot
      self.m_2dModelRoot = new2dModelRoot
      local oldmodel2d = self.model2d
      GameUtil.AddGlobalTimer(duration, true, function()
        if oldmodel2d then
          oldmodel2d:Destroy()
        end
        if old2dModelRoot and not old2dModelRoot.isnil then
          GameObject.Destroy(old2dModelRoot)
        end
        if oldModel2d and not oldModel2d.isnil then
          GameObject.Destroy(oldModel2d)
        end
      end)
    end
  end
  local uiModel = self.uiObjs.Model2d:GetComponent("UIModel")
  local modelPath, modelId = LoginUtility.GetCreateRole2DModelPath(self.selectedOccupation, self.selectedGender)
  local m_2dModelRoot = self.m_2dModelRoot
  local model2d = ECUIModel.new(modelId)
  self.model2d = model2d
  model2d:Load(modelPath, function(ret)
    if ret == nil or ret ~= model2d then
      return
    end
    if m_2dModelRoot.isnil then
      return
    end
    local m = model2d.m_model
    model2d:Play("Idle_c")
    model2d:SetDir(180)
    m.transform.parent = m_2dModelRoot.transform
    m.transform.localPosition = EC.Vector3.new(0, 0, -0.8)
    m.transform.localRotation = Quaternion.Euler(EC.Vector3.new(-20, -180, 0))
    m:SetLayer(ClientDef_Layer.UI_Model1)
    uiModel.modelGameObject = m_2dModelRoot
    uiModel.mCanOverflow = true
  end)
end
def.method().Model2DTweenBack = function(self)
  if self.uiObjs.Model2d == nil then
    return
  end
  local duration = 0.2
  local oldModel2d = self.uiObjs.Model2d
  TweenPosition.Begin(oldModel2d, duration, MODEL_2D_ORIGINAL_POS)
end
def.method().Update3DUIModel = function(self)
  local uiModel = self.uiObjs.Model3d:GetComponent("UIModel")
  local modelPath, modelId = LoginUtility.GetCreateRoleModelPath(self.selectedOccupation, self.selectedGender)
  if self.model3d ~= nil then
    if self.model3d.m_model then
      local fx = self.model3d.m_model:FindDirect("fx")
      if fx then
        GameObject.Destroy(fx)
      end
    end
    self.model3d:Destroy()
  end
  self.model3d = ECUIModel.new(modelId)
  self.model3d:LoadUIModel(modelPath, function(ret)
    if ret == nil then
      return
    end
    local m = self.model3d.m_model
    local ani = m:GetComponent("Animation")
    if ani then
      ani.cullingType = AnimationCullingType.AlwaysAnimate
    end
    uiModel.modelGameObject = m
    uiModel.mCanOverflow = true
    local equipmentCfg = require("Main.Hero.HeroUtility").GetRoleInitEquipmentCfg(self.selectedOccupation, self.selectedGender)
    self.model3d:Play(ActionName.Stand)
    local ModelInfo = require("netio.protocol.mzm.gsp.pubdata.ModelInfo")
    local hairColorId = self.catchedCreateRoleCfg.defaultHairDryId
    local clothesColorId = self.catchedCreateRoleCfg.defaultClothDryId
    local modelInfo = ModelInfo.new(0, nil, {
      [ModelInfo.WEAPON] = equipmentCfg.weaponId or 0,
      [ModelInfo.HAIR_COLOR_ID] = hairColorId,
      [ModelInfo.CLOTH_COLOR_ID] = clothesColorId
    })
    _G.SetModelExtra(self.model3d, modelInfo)
    local fxId = self.catchedCreateRoleCfg.weaponFXId
    local res = _G.GetEffectRes(fxId)
    local resname = res and res.path or nil
    self.model3d:AttachEffectToWeapon(resname)
  end)
end
def.method().UpdateSceneModel = function(self)
end
def.method().DestroySceneModel = function(self)
  if self.m_curRoleObj then
    GameObject.Destroy(self.m_curRoleObj)
    self.m_curRoleObj = nil
  end
  if self.m_curSceneObj then
    GameObject.Destroy(self.m_curSceneObj)
    self.m_curSceneObj = nil
  end
end
local totaldy = 0
local isManualEnd = false
def.method("string").onDragStart = function(self, id)
  self.isDrag = true
  totaldy = 0
  isManualEnd = false
end
def.method("string").onDragEnd = function(self, id)
  self.isDrag = false
  if isManualEnd then
    isManualEnd = false
    return
  end
  if (id == "Model1" or id == "Img_Bg0") and self.model2d then
    if totaldy > MODEL2D_DRAG_END_DISTANCE then
      self:OnDownButtonClick()
    elseif totaldy < -MODEL2D_DRAG_END_DISTANCE then
      self:OnUpButtonClick()
    else
      self:Model2DTweenBack()
    end
  end
  totaldy = 0
end
def.method("string", "number", "number").onDrag = function(self, id, dx, dy)
  if self.isDrag == true then
    if id == "Model" and self.model3d then
      self.model3d:SetDir(self.model3d.m_ang - dx / 2)
    end
    totaldy = totaldy + dy
    if (id == "Model1" or id == "Img_Bg0") and self.uiObjs.Model2d then
      local model2d = self.uiObjs.Model2d
      local pos = model2d.transform.localPosition
      pos.y = pos.y + dy
      model2d.transform.localPosition = pos
      if math.abs(totaldy) > MODEL2D_DRAG_END_DISTANCE then
        self:onDragEnd(id)
        isManualEnd = true
      end
    end
  end
end
def.method().OnStartGameButtonClick = function(self)
  self.enteredName = self.uiObjs.uiInuptName:get_value()
  if self.enteredName == "" then
    Toast(textRes.Login[46])
    return
  end
  local state = self:ValidEnteredName(self.enteredName)
  if state == false then
    return
  end
  if SensitiveWordsFilter.ContainsSensitiveWord(self.enteredName) then
    Toast(textRes.Login[3])
  elseif SensitiveWordsFilter.ContainsSensitiveWord(self.enteredName, "Name") then
    Toast(textRes.Login[24])
  else
    self.uiObjs.Btn_Start:GetComponent("UIButton"):set_isEnabled(false)
    local roleList = LoginModule:GetRoleList()
    local toggleGO = self.uiObjs.Group_Invite:FindDirect("Toggle_Invite")
    if roleList and #roleList ~= 0 or not GUIUtils.IsToggle(toggleGO) then
      LoginModule:CreateRole(self.enteredName, self.selectedOccupation, self.selectedGender, "")
    else
      do
        local labelGO = toggleGO:FindDirect("Group_Select/Img_Bg/Label")
        local inviteCode = labelGO:GetComponent("UILabel").text
        inviteCode:gsub("%w+", function(s)
          inviteCode = s
        end)
        local function InvalidInviteCodeAction(errorCode)
          local tips = textRes.Login[112]
          if errorCode == 407 then
            tips = textRes.Login[116]
          elseif errorCode == 404 then
            if _G.LoginPlatform == MSDK_LOGIN_PLATFORM.QQ then
              tips = textRes.Login[115]
            elseif _G.LoginPlatform == MSDK_LOGIN_PLATFORM.WX then
              tips = textRes.Login[114]
            end
          end
          CommonConfirmDlg.ShowConfirmCoundDown("", tips, "", "", 0, 0, function(selection, tag)
            if selection == 1 then
              LoginModule:CreateRole(self.enteredName, self.selectedOccupation, self.selectedGender, "")
            else
              self.uiObjs.Btn_Start:GetComponent("UIButton"):set_isEnabled(true)
            end
          end, nil)
        end
        if inviteCode == " " then
          InvalidInviteCodeAction(0)
        else
          local sdkInfo = ECMSDK.GetMSDKInfo()
          local openid = sdkInfo.openId
          if platform == 0 then
            local userName = ECGame.Instance().m_UserName
            local s, e = userName:find("shadow")
            openid = userName:sub(1, s - 2)
          end
          local zoneid = require("netio.Network").m_zoneid
          local channel = "shadow"
          if _G.LoginPlatform == MSDK_LOGIN_PLATFORM.QQ then
            channel = "qq"
          elseif _G.LoginPlatform == MSDK_LOGIN_PLATFORM.WX then
            channel = "wechat"
          end
          local url = _G.GetDirVersionService("check_invite_code")
          url = _G.NormalizeHttpURL(url)
          local deviceid = SystemInfo.deviceUniqueIdentifier
          warn(url, "~~~~~~~~~~~~~~", openid, " ", deviceid)
          if url and openid and zoneid then
            local postData = ("invite_code=%s&openid=%s&channel=%s&zoneid=%d&deviceid=%s"):format(inviteCode, openid, channel, zoneid, deviceid)
            GameUtil.httpPost(url, 0, postData, function(success, url, postId, data)
              if success then
                warn(url, "Success..............", data:get_string())
                local json = require("Utility.json")
                local param = json.decode(data:get_string())
                if param.ret == 0 then
                  if param.data == 0 or param.data == 406 then
                    CommonConfirmDlg.ShowConfirmCoundDown("", textRes.Login[113], "", "", 0, 0, function(selection, tag)
                      if selection == 1 then
                        LoginModule:CreateRole(self.enteredName, self.selectedOccupation, self.selectedGender, inviteCode)
                      else
                        self.uiObjs.Btn_Start:GetComponent("UIButton"):set_isEnabled(true)
                      end
                    end, nil)
                  else
                    InvalidInviteCodeAction(param.data)
                  end
                else
                  Debug.LogWarning("The other retcode is" .. param.ret)
                end
              else
                Debug.LogWarning("There is something wrong in the url or post body")
              end
            end, {})
          else
            self.uiObjs.Btn_Start:GetComponent("UIButton"):set_isEnabled(true)
            Debug.LogWarning("SelectCharacterPanel OnStartGameButtonClick openid is not exsit")
          end
        end
      end
    end
  end
end
def.method("string").OnOccupationButtonClick = function(self, id)
  local occupationId = self.occupationIDTable[id]
  if self.selectedOccupation == occupationId then
    return
  end
  local isOccupationLocked = not LoginUtility.Instance():IsOccupationUnlocked(occupationId)
  if isOccupationLocked then
    self:OnLockedObjInsClicked()
    return
  end
  self:SelectOccupation(occupationId, ModelTransformDir.Down)
end
def.method("number", "number").SelectOccupation = function(self, occupationId, dir)
  self.animatedTime = 8
  self.selectedOccupation = occupationId
  local occupationList = LoginUtility.Instance():GetOccupationList()
  if not occupationList[self.selectedOccupation][self.selectedGender] then
    self.selectedGender = 3 - self.selectedGender
  end
  self.catchedCreateRoleCfg = LoginUtility.GetCreateRoleCfg(self.selectedOccupation, self.selectedGender)
  self:UpdateToggleState()
  self:UpdateModel(dir)
  self:UpdateOccupationImage()
  self:UpdateOccupationDesc()
  self:AsyncLoadBackgroundImage()
  self:UpdateOccupationSkills()
end
def.method("string").OnGenderButtonClick = function(self, id)
  local gender
  if id == "Btn_Male" then
    gender = GenderEnum.MALE
  else
    gender = GenderEnum.FEMALE
  end
  if self.selectedGender == gender then
    return
  end
  local isOccupationGenderLocked = not LoginUtility.Instance():IsOccupationGenderUnlocked(self.selectedOccupation, gender)
  if isOccupationGenderLocked then
    self:OnLockedObjInsClicked()
    return
  end
  self:SelectGender(gender)
end
def.method("number").SelectGender = function(self, gender)
  self.selectedGender = gender
  self.catchedCreateRoleCfg = LoginUtility.GetCreateRoleCfg(self.selectedOccupation, self.selectedGender)
  local dir = ModelTransformDir.Up
  if gender == _G.GenderEnum.MALE then
    dir = ModelTransformDir.Down
  end
  self:UpdateModel(dir)
  self:UpdateGenderToggleState()
  self:UpdateOccupationImage()
end
def.method("number").SelectOccupationOrGender = function(self, gender)
end
def.method().OnUpButtonClick = function(self)
  local left = self:GetNextOccupationAndGender(-1)
  if left.occupation == self.selectedOccupation then
    self:SelectGender(left.gender)
  else
    self.selectedGender = left.gender
    self:SelectOccupation(left.occupation, ModelTransformDir.Down)
  end
end
def.method().OnDownButtonClick = function(self)
  local right = self:GetNextOccupationAndGender(1)
  if right.occupation == self.selectedOccupation then
    self:SelectGender(right.gender)
  else
    self.selectedGender = right.gender
    self:SelectOccupation(right.occupation, ModelTransformDir.Up)
  end
end
def.method("=>", "number").GetRightOccupation = function(self)
  return self:_GetNextOccupation(1)
end
def.method("=>", "number").GetLeftOccupation = function(self)
  return self:_GetNextOccupation(-1)
end
def.method("number", "=>", "number")._GetNextOccupation = function(self, offset)
  if offset == 0 then
    return self.selectedOccupation
  end
  local occupationList = LoginUtility.Instance():GetOccupationList()
  local unlockedList = {}
  for occupationId, v in ipairs(occupationList) do
    if v[GenderEnum.MALE] or v[GenderEnum.FEMALE] then
      table.insert(unlockedList, occupationId)
    end
  end
  local unlockedCount = #unlockedList
  if unlockedCount == 0 then
    return 0
  end
  local curIndex = 1
  for i, occupationId in ipairs(unlockedList) do
    if self.selectedOccupation == occupationId then
      curIndex = i
      break
    end
  end
  local nextIndex = curIndex + offset
  while unlockedCount < nextIndex do
    nextIndex = nextIndex - unlockedCount
  end
  while nextIndex < 1 do
    nextIndex = nextIndex + unlockedCount
  end
  return unlockedList[nextIndex]
end
def.method("number", "=>", "table").GetNextOccupationAndGender = function(self, offset)
  if offset == 0 then
    return {
      occupation = self.selectedOccupation,
      gender = self.selectedGender
    }
  end
  local occupationList = LoginUtility.Instance():GetOccupationList()
  local unlockedList = {}
  for k, v in ipairs(occupationList) do
    if v[GenderEnum.MALE] then
      table.insert(unlockedList, {
        occupation = k,
        gender = GenderEnum.MALE
      })
    end
    if v[GenderEnum.FEMALE] then
      table.insert(unlockedList, {
        occupation = k,
        gender = GenderEnum.FEMALE
      })
    end
  end
  local unlockedCount = #unlockedList
  local curIndex = 1
  for i, v in ipairs(unlockedList) do
    if self.selectedOccupation == v.occupation and self.selectedGender == v.gender then
      curIndex = i
      break
    end
  end
  local nextIndex = curIndex + offset
  while unlockedCount < nextIndex do
    nextIndex = nextIndex - unlockedCount
  end
  while nextIndex < 1 do
    nextIndex = nextIndex + unlockedCount
  end
  return unlockedList[nextIndex]
end
def.method().OnBackButtonClick = function(self)
  Time.timeScale = 1
  self:HidePanel()
  if ECGame.Instance():GetHistoryGameState(-1) == _G.GameState.ChooseRole then
    require("Main.Login.ui.SelectRolePanel").Instance():ShowPanel()
  else
    LoginModule:Back2Login()
  end
end
def.static("table", "table").OnCreateRoleSucess = function(self)
  instance:HidePanel()
end
def.static("table", "table").OnResetUI = function(self)
  instance.uiObjs.Btn_Start:GetComponent("UIButton"):set_isEnabled(true)
end
def.method("number").Update = function(self, dt)
  if self.zoomBGCam then
    self.zoomBGCam:Update()
  end
end
def.method("number").UpdatePerSecond = function(self, dt)
  if self.model2d == nil then
    return
  end
  self.animatedTime = self.animatedTime + dt
  local INTERVAL = 12
  if INTERVAL < self.animatedTime then
    if self.model2d:IsPlaying("Stand_c") then
      self.model2d:CrossFade("Idle1_c", 0.5)
      self.model2d:CrossFadeQueued("Stand_c", 0.5)
    end
    self.animatedTime = self.animatedTime - INTERVAL
  end
end
def.method("string", "=>", "boolean").ValidEnteredName = function(self, enteredName)
  local NameValidator = require("Main.Common.NameValidator")
  local isValid, reason, _ = NameValidator.Instance():IsValid(enteredName)
  if isValid then
    return true
  else
    if reason == NameValidator.InvalidReason.TooShort then
      Toast(textRes.Login[15])
    elseif reason == NameValidator.InvalidReason.TooLong then
      Toast(textRes.Login[14])
    elseif reason == NameValidator.InvalidReason.NotInSection then
      Toast(textRes.Login[25])
    end
    return false
  end
end
def.method().UpdateOccupationImage = function(self)
  local uiTweener = self.uiObjs.Img_Shi_Root:GetComponent("UITweener")
  if uiTweener == nil then
    return
  end
  uiTweener.tweenFactor = 0
  uiTweener:PlayForward()
  local spriteName = require("Main.Login.LoginUtility").GetOccupationPoemSpriteName(self.selectedOccupation, self.selectedGender)
  local sprite = self.uiObjs.Img_Shi:GetComponent("UISprite")
  sprite:set_spriteName(spriteName)
end
def.method().UpdateOccupationDesc = function(self)
  local desc = self.catchedCreateRoleCfg.desc
  self:SetMenPaiDescibe(desc)
end
def.method().UpdateOccupationSkills = function(self)
  local cfg = self.catchedCreateRoleCfg
  local skillCount = 3
  for i = 1, skillCount do
    local skillId = cfg.skillIdList[i]
    self:SetSkill(i, skillId)
  end
  self:SetSkillDesc("")
end
def.method("number", "number").SetSkill = function(self, index, skillId)
  local GroupSkill = self.uiObjs.Group_SkillDes:FindDirect("Group_Skill" .. index)
  local uiTexture = GroupSkill:FindDirect("Texture_SkillIcon"):GetComponent("UITexture")
  local skillCfg = require("Main.Skill.SkillUtility").GetSkillCfg(skillId)
  local iconId = skillCfg.iconId
  require("GUI.GUIUtils").FillIcon(uiTexture, iconId)
  require("GUI.GUIUtils").SetCircularEffect(uiTexture)
end
def.method("number").OnSkillSelected = function(self, index)
  local cfg = self.catchedCreateRoleCfg
  local skillId = cfg.skillIdList[index]
  local GroupSkill = self.uiObjs.Group_SkillDes:FindDirect("Group_Skill" .. index)
  GroupSkill:GetComponent("UIToggle"):set_value(true)
  self:UpdateSkillDesc(skillId)
  if not self:IsPlayingSkill() then
    self:PlaySkill(skillId)
  end
end
def.method("number").PlaySkill = function(self, skillId)
  self.animatedTime = 8
  local occupationCfg = _G.GetOccupationCfg(self.selectedOccupation, self.selectedGender)
  local modelId = occupationCfg.modelId
  self.model3d.mModelId = modelId
  if self.model3d.m_model then
    local fx = self.model3d.m_model:FindDirect("fx")
    if fx then
      GameObject.Destroy(fx)
    end
  end
  _G.PlaySkillInUIModel(self.model3d, skillId, self.selectedGender)
  local FightUtils = require("Main.Fight.FightUtils")
  local fightMgr = require("Main.Fight.FightMgr").Instance()
  local skillcfg = fightMgr:GetSkillCfg(skillId)
  local playcfg = FightUtils.GetSkillPlayCfg(skillcfg.skillPlayid)
  local soundId = playcfg.maleSoundId
  local gender = self.selectedGender
  if gender == require("consts.mzm.gsp.occupation.confbean.SGenderEnum").FEMALE then
    soundId = playcfg.femaleSoundId
  end
  if soundId > 0 then
    fightMgr:PlaySoundEffect(soundId)
  end
end
def.method("string", "number", "=>", "userdata").AddChildEffect = function(self, effectPath, part)
  local pos = Vector.Vector3.new(0, 0, 0)
  local fx = require("Fx.ECFxMan").Instance():PlayAsChild(effectPath, self.model3d.m_model, pos, Quaternion.identity, -1, false, -1)
  if fx == nil then
    warn("can not request effect: " .. effectPath)
    return nil
  end
  fx:SetLayer(ClientDef_Layer.UI_Model1)
  return fx
end
def.method("=>", "boolean").IsPlayingSkill = function(self)
  if self.model3d:IsPlaying("Stand_c") or self.model3d:IsPlaying("Idle1_c") then
    return false
  end
  return true
end
def.method("number").UpdateSkillDesc = function(self, skillId)
  local skillCfg = require("Main.Skill.SkillUtility").GetSkillCfg(skillId)
  local text = string.format(textRes.Common[32], skillCfg.name, skillCfg.simpleDesc)
  self:SetSkillDesc(text)
end
def.method("string").SetSkillDesc = function(self, desc)
  local Label_SkillDes = self.uiObjs.Group_SkillDes:FindDirect("Label_SkillDes")
  Label_SkillDes:GetComponent("UILabel"):set_text(desc)
  self:TweenWidgetAlpha(Label_SkillDes)
end
def.method().UpdateOccupationFXs = function(self)
  if self.m_mainFx ~= nil then
    GameObject.Destroy(self.m_mainFx)
    self.m_mainFx = nil
  end
  local fxId = self.catchedCreateRoleCfg.mainFXId
  local path = _G.GetEffectRes(fxId).path
  self.m_mainFx = require("Fx.GUIFxMan").Instance():PlayAsChild(self.m_panel, path, 0, 0, -1, false)
end
def.method().PreloadOSkillEffects = function(self)
  local function preloadSkillEffect(skillId)
    local occupationCfg = _G.GetOccupationCfg(self.selectedOccupation, self.selectedGender)
    local modelId = occupationCfg.modelId
    local FightUtils = require("Main.Fight.FightUtils")
    local fightMgr = require("Main.Fight.FightMgr").Instance()
    local skillcfg = fightMgr:GetSkillCfg(skillId)
    local playcfg = FightUtils.GetSkillPlayCfg(skillcfg.skillPlayid)
    local actionPhaseCfg = FightUtils.GetSkillPlayPhaseCfg(playcfg.phases[1][2])
    local actionCfg = FightUtils.GetSkillActionCfg(modelId, actionPhaseCfg.action)
    for i, effect in ipairs(actionPhaseCfg.effects) do
      local effPlay = FightUtils.GetEffectPlayCfg(modelId, effect.effectId)
      if effPlay.attackEffectId > 0 then
        local effres = GetEffectRes(effPlay.attackEffectId)
        GameUtil.AsyncLoad(effres.path, function()
        end)
      end
    end
  end
  for index = 1, 3 do
    local cfg = self.catchedCreateRoleCfg
    local skillId = cfg.skillIdList[index]
    if skillId then
      preloadSkillEffect(skillId)
    end
  end
end
def.method("userdata", "string").AddLockedObjIns = function(self, parentObj, name)
  local lockedObjIns = GameObject.Instantiate(self.uiObjs.lockedObj)
  lockedObjIns:SetActive(true)
  local uiWidget = lockedObjIns:GetComponent("UIWidget")
  local parentUIWidget = parentObj:GetComponent("UIWidget")
  uiWidget.width, uiWidget.height = parentUIWidget.width, parentUIWidget.height
  uiWidget.depth = parentUIWidget.depth - 1
  uiWidget:ResizeCollider()
  lockedObjIns.transform.parent = parentObj.transform
  lockedObjIns.transform.localPosition = Vector.Vector3.zero
  lockedObjIns.transform.localScale = Vector.Vector3.one
  lockedObjIns.name = name
end
def.method().OnLockedObjInsClicked = function(self)
  Toast(textRes.Common[31])
end
def.method().OnModelClicked = function(self)
end
def.method().SetCreateRoleScene = function(self)
  self.m_createRoleScene = GameObject.GameObject("CreateRoleScene")
  self.m_createRoleScene.transform.parent = nil
  self.m_createRoleScene.transform.localPosition = EC.Vector3.new(-100, 0, 0)
  self.m_2dModelRoot = GameObject.GameObject("2d Model Root")
  self.m_2dModelRoot.transform.localPosition = EC.Vector3.new(0, 0, 0)
  self.m_2dModelRoot.transform.localRotation = Quaternion.Euler(EC.Vector3.new(0, 0, 0))
  self.m_BGObj = GameObject.GameObject("BG")
  self.m_BGObj.transform.parent = self.m_createRoleScene.transform
  self.m_BGObj.transform.localPosition = EC.Vector3.new(0, 0, 100)
  self.m_BGObj:SetLayer(ClientDef_Layer.Default)
  self:SetBGCamera()
end
def.method().DestroyCreateRoleScene = function(self)
  self:DestroyCreateRoleCamera()
  if self.m_createRoleScene then
    GameObject.Destroy(self.m_createRoleScene)
  end
end
def.method().SetCreateRoleCamera = function(self)
  if self.m_createRoleCamObj then
    self.m_createRoleCamObj:SetActive(true)
    return
  end
  local camobj = GameObject.GameObject("CreateRoleSceneCamera")
  local cam = camobj:AddComponent("Camera")
  cam.clearFlags = CameraClearFlags.Depth
  cam.orthographic = false
  cam.fieldOfView = 30
  cam.orthographicSize = 1.2
  cam.nearClipPlane = 0.3
  cam.farClipPlane = 100
  cam.depth = CameraDepth.CREATE_ROLE
  cam:set_cullingMask(get_cull_mask(ClientDef_Layer.UI_Model1))
  camobj.transform.parent = self.m_createRoleScene.transform
  camobj.localPosition = EC.Vector3.new(0.5, 1.945, -6.012)
  camobj.localRotation = Quaternion.Euler(EC.Vector3.new(10.6, 0, 0))
  self.m_CRCC = camobj:AddComponent("CRCameraController")
  self.m_createRoleCamObj = camobj
end
def.method().SetBGCamera = function(self)
  local camobj = GameObject.GameObject("BGCamera")
  local cam = camobj:AddComponent("Camera")
  cam.clearFlags = CameraClearFlags.Depth
  cam.orthographic = true
  cam.fieldOfView = 30
  cam.orthographicSize = 2.54
  cam.nearClipPlane = -30
  cam.farClipPlane = 10
  cam.depth = 1
  cam:set_cullingMask(get_cull_mask(ClientDef_Layer.Default))
  camobj.transform.parent = self.m_BGObj.transform
  camobj.localPosition = EC.Vector3.new(0, 2.55, 0)
  camobj.localRotation = Quaternion.Euler(EC.Vector3.new(0, 0, 0))
  self.m_BGCameraObj = camobj
end
def.method("number", "number").AdjustBGCamera = function(self, w, h)
  local camera = self.m_BGCameraObj:GetComponent("Camera")
  _G.AdjustBGCamera(camera, w, h)
  local originalSize = camera.orthographicSize
  local scaleSize = camera.orthographicSize * BG_DEFAULT_SCALE
  if self.zoomBGCam == nil then
    camera.orthographicSize = scaleSize
    self.zoomBGCam = ZoomCameraHelper.New(scaleSize, originalSize, scaleSize)
    self.zoomBGCam.camera = camera
    local t = self:GetCRCameraMoveTime()
    self.zoomBGCam.speed = (originalSize - scaleSize) / t
  else
    camera.orthographicSize = self.zoomBGCam.value
    self:ZoomInBGCamera()
  end
end
def.method().ZoomInBGCamera = function(self)
  if self.zoomBGCam then
    self.zoomBGCam:ZoomIn()
  end
end
def.method().ZoomOutBGCamera = function(self)
  if self.zoomBGCam then
    self.zoomBGCam:ZoomOut()
  end
end
def.method().DestroyCreateRoleCamera = function(self)
  if self.m_createRoleCamObj then
    GameObject.Destroy(self.m_createRoleCamObj)
    self.m_createRoleCamObj = nil
  end
end
def.method("number").StartMoveCRCamera = function(self, dir)
  if self.m_CRCC then
    self.m_CRCC:StartMove(dir)
  end
end
def.method("=>", "number").GetCRCameraMoveTime = function(self)
  if self.m_CRCC then
    return (self.m_CRCC.endFOV - self.m_CRCC.startFOV) / self.m_CRCC.FOVSpeed
  else
    return 0
  end
end
return SelectCharacterPanel.Commit()

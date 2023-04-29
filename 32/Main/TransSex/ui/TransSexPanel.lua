local Lplus = require("Lplus")
local ECPanelBase = require("GUI.ECPanelBase")
local GUIUtils = require("GUI.GUIUtils")
local GenderEnum = require("consts.mzm.gsp.occupation.confbean.SGenderEnum")
local CurrencyFactory = require("Main.Currency.CurrencyFactory")
local TransSexProtocols = require("Main.TransSex.TransSexProtocols")
local EC = require("Types.Vector3")
local ECUIModel = require("Model.ECUIModel")
local TeamData = require("Main.Team.TeamData")
local TransSexData = require("Main.TransSex.data.TransSexData")
local TransSexPanel = Lplus.Extend(ECPanelBase, "TransSexPanel")
local def = TransSexPanel.define
local instance
def.static("=>", TransSexPanel).Instance = function()
  if instance == nil then
    instance = TransSexPanel()
  end
  return instance
end
def.field("table")._uiObjs = nil
def.field("table")._modelLeft = nil
def.field("table")._modelRight = nil
def.field("table")._currencyData = nil
def.static().ShowPanel = function()
  TransSexPanel.Instance():CreatePanel(RESPATH.PREFAB_TRANS_SEX_PANEL, 2)
end
def.override().OnCreate = function(self)
  self:SetModal(true)
  self:_InitUI()
  self._currencyData = CurrencyFactory.Create(constant.CGenderConvertConsts.MONEY_TYPE)
  self:HandleEventListeners(true)
  self:UpdateUI()
end
def.method()._InitUI = function(self)
  self._uiObjs = {}
  self._uiObjs.Img_Model_Left = self.m_panel:FindDirect("Img_Bg0/Group_Left/Img_Model_Left")
  self._uiObjs.Img_Sex_Left = self.m_panel:FindDirect("Img_Bg0/Group_Left/Img_Sex")
  self._uiObjs.Img_Model_Right = self.m_panel:FindDirect("Img_Bg0/Group_Right/Img_Model_Right")
  self._uiObjs.Img_Sex_Right = self.m_panel:FindDirect("Img_Bg0/Group_Right/Img_Sex")
  self._uiObjs.Img_HaveMoney = self.m_panel:FindDirect("Img_Bg0/Group_Have/Img_MoneyIcon")
  self._uiObjs.Label_HaveMoney = self.m_panel:FindDirect("Img_Bg0/Group_Have/Label_MoneyNum")
  self._uiObjs.Img_NeedMoney = self.m_panel:FindDirect("Img_Bg0/Group_Cost/Img_MoneyIcon")
  self._uiObjs.Label_NeedMoney = self.m_panel:FindDirect("Img_Bg0/Group_Cost/Label_MoneyNum")
end
def.override("boolean").OnShow = function(self, show)
  if show then
  end
end
def.method().UpdateUI = function(self)
  self:UpdateModel()
  self:UpdateMoney()
end
def.override().OnDestroy = function(self)
  self:HandleEventListeners(false)
  self:_DestroyModels()
  self._uiObjs = nil
  self._currencyData = nil
end
def.method().UpdateModel = function(self)
  self:_DestroyModels()
  local heroProp = require("Main.Hero.Interface").GetHeroProp()
  if heroProp == nil then
    warn("[ERROR][TransSexPanel:UpdateModel] heroProp nil.")
    return
  end
  local occupation, gender = heroProp.occupation, heroProp.gender
  local genderTo = gender
  if gender == GenderEnum.MALE then
    genderTo = GenderEnum.FEMALE
  else
    genderTo = GenderEnum.MALE
  end
  self._modelLeft = self:ShowOccpGender(self._uiObjs.Img_Model_Left, self._uiObjs.Img_Sex_Left, occupation, gender)
  self._modelRight = self:ShowOccpGender(self._uiObjs.Img_Model_Right, self._uiObjs.Img_Sex_Right, occupation, genderTo)
end
def.method("userdata", "userdata", "number", "number", "=>", "table").ShowOccpGender = function(self, Img_Model, Img_Sex, occupation, gender)
  GUIUtils.SetSprite(Img_Sex, GUIUtils.GetSexIcon(gender))
  local uiModel = Img_Model:GetComponent("UIModel")
  uiModel.mDepressionAngle = 0
  if uiModel.mCanOverflow ~= nil then
    uiModel.mCanOverflow = true
  end
  local modelPath = GUIUtils.GetHeroHalfBodyPath(occupation, gender)
  local model = ECUIModel.new(0)
  model:LoadUIModel(modelPath, function(ret)
    if ret == nil then
      return
    end
    model:SetDir(180)
    uiModel.modelGameObject = model.m_model
    local camera = uiModel:get_modelCamera()
    camera:set_orthographic(true)
    camera.transform.localRotation = Quaternion.Euler(EC.Vector3.zero)
  end)
  return model
end
def.method()._DestroyModels = function(self)
  if not _G.IsNil(self._modelLeft) then
    self._modelLeft:Destroy()
  end
  if not _G.IsNil(self._modelRight) then
    self._modelRight:Destroy()
  end
end
def.method().UpdateMoney = function(self)
  local ownMoney = self._currencyData and self._currencyData:GetHaveNum() or Int64.new(0)
  self:ShowMoney(self._uiObjs.Img_HaveMoney, self._uiObjs.Label_HaveMoney, ownMoney)
  self:ShowMoney(self._uiObjs.Img_NeedMoney, self._uiObjs.Label_NeedMoney, Int64.new(constant.CGenderConvertConsts.MONEY_NUM))
end
def.method("userdata", "userdata", "userdata").ShowMoney = function(self, Img_Money, Label_Num, moneyNum)
  if self._currencyData then
    local currencySprite = self._currencyData:GetSpriteName()
    GUIUtils.SetSprite(Img_Money, currencySprite)
    GUIUtils.SetText(Label_Num, moneyNum and Int64.tostring(moneyNum) or "0")
  end
end
def.method("userdata").onClickObj = function(self, clickObj)
  local id = clickObj.name
  if id == "Btn_Close" then
    self:OnBtn_Close()
  elseif id == "Btn_Help" then
    self:OnBtn_Help()
  elseif id == "Btn_Confirm" then
    self:OnBtn_Confirm()
  end
end
def.method().OnBtn_Close = function(self)
  self:DestroyPanel()
end
def.method().OnBtn_Help = function(self)
  GUIUtils.ShowHoverScrollTip(constant.CGenderConvertConsts.TIP, 0, 0)
end
def.method().OnBtn_Confirm = function(self)
  if not require("Main.TransSex.TransSexModule").Instance():ReachMinLevel(true) then
    return
  end
  if TeamData.Instance():HasTeam() then
    Toast(textRes.TransSex.TRANS_SEX_FAIL_TEAM)
    return
  end
  local ownMoney = self._currencyData and self._currencyData:GetHaveNum() or Int64.new(0)
  local needMoney = Int64.new(constant.CGenderConvertConsts.MONEY_NUM)
  if Int64.gt(needMoney, ownMoney) then
    Toast(textRes.TransSex.TRANS_SEX_FAIL_LACK_MONEY)
    return
  end
  local isMarried = require("Main.Marriage.MarriageInterface").IsMarried()
  if isMarried then
    Toast(textRes.TransSex.TRANS_SEX_FAIL_MARRIAGE)
    return
  end
  local interval = _G.GetServerTime() - TransSexData.Instance():GetLastTransSexTime()
  local cd = constant.CGenderConvertConsts.CONVERT_CD_IN_HOUR * 3600
  if interval < cd then
    local errString = string.format(textRes.TransSex.TRANS_SEX_FAIL_CD, constant.CGenderConvertConsts.CONVERT_CD_IN_HOUR)
    Toast(errString)
    return
  end
  local currencyName = self._currencyData and self._currencyData:GetName() or ""
  local currencyStr = Int64.tostring(needMoney)
  local content = string.format(textRes.TransSex.TRANS_SEX_CONFIRM_CONTENT, currencyStr, currencyName, constant.CGenderConvertConsts.CONVERT_CD_IN_HOUR)
  require("GUI.CommonConfirmDlg").ShowConfirm(textRes.TransSex.TRANS_SEX_CONFIRM_TITLE, content, function(id, tag)
    if id == 1 then
      TransSexProtocols.SendCGenderConvert()
    end
  end, nil)
end
def.method("boolean").HandleEventListeners = function(self, isRigister)
  local eventFunc
  if isRigister then
    eventFunc = Event.RegisterEvent
    if self._currencyData then
      self._currencyData:RegisterCurrencyChangedEvent(TransSexPanel.OnMoneyUpdate)
    end
  else
    eventFunc = Event.UnregisterEvent
    if self._currencyData then
      self._currencyData:UnregisterCurrencyChangedEvent(TransSexPanel.OnMoneyUpdate)
    end
  end
  if eventFunc then
  end
end
def.static("table", "table").OnMoneyUpdate = function()
  local self = TransSexPanel.Instance()
  if self and self:IsShow() and self._currencyData then
    self:ShowMoney(self._uiObjs.Img_HaveMoney, self._uiObjs.Label_HaveMoney, self._currencyData:GetHaveNum())
  end
end
TransSexPanel.Commit()
return TransSexPanel

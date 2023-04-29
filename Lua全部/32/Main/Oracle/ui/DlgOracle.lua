local Lplus = require("Lplus")
local GUIUtils = require("GUI.GUIUtils")
local ECPanelBase = require("GUI.ECPanelBase")
local OracleModule = require("Main.Oracle.OracleModule")
local OccupationEnum = require("consts.mzm.gsp.occupation.confbean.SOccupationEnum")
local HeroInterface = require("Main.Hero.Interface")
local OracleData = require("Main.Oracle.data.OracleData")
local ModuleFunSwitchInfo = require("netio.protocol.mzm.gsp.open.ModuleFunSwitchInfo")
local OracleProtocols = require("Main.Oracle.OracleProtocols")
local OraclePage = require("Main.Oracle.ui.OraclePage")
local OracleUtils = require("Main.Oracle.OracleUtils")
local OracleTip
local DlgOracle = Lplus.Extend(ECPanelBase, "DlgOracle")
local def = DlgOracle.define
local instance
def.static("=>", DlgOracle).Instance = function()
  if instance == nil then
    OracleTip = require("Main.Oracle.ui.OracleTip")
    instance = DlgOracle()
  end
  return instance
end
def.field("table")._uiObjs = nil
def.field("table")._occpBtns = nil
def.field("number")._curOccupId = 0
def.field("boolean")._bDoubleOracles = false
def.field("table")._centerOracleCfg = nil
def.field(OraclePage)._centerPage = nil
def.field("table")._leftOracleCfg = nil
def.field(OraclePage)._leftPage = nil
def.field("table")._rightOracleCfg = nil
def.field(OraclePage)._rightPage = nil
def.static().ShowDlg = function()
  if not OracleModule.Instance():IsOpen(true) then
    if DlgOracle.Instance():IsShow() then
      DlgOracle.Instance():DestroyPanel()
    end
    return
  end
  if DlgOracle.Instance():IsShow() then
    return
  end
  DlgOracle.Instance():CreatePanel(RESPATH.PERFAB_DLG_ORACLE, 0)
end
def.override().OnCreate = function(self)
  self:SetModal(true)
  self:_InitUI()
end
def.method()._InitUI = function(self)
  self._uiObjs = {}
  self._uiObjs.centerAnchor = self.m_panel:FindDirect("Img_Bg0/Point_Skill_Center")
  self._uiObjs.leftAnchor = self.m_panel:FindDirect("Img_Bg0/Point_Skill_Left")
  self._uiObjs.rightAnchor = self.m_panel:FindDirect("Img_Bg0/Point_Skill_Right")
  self._uiObjs.ScrollView_Camp = self.m_panel:FindDirect("Img_Bg0/Group_Camp/ScrollView_Camp")
  self._uiObjs.uiScrollView = self._uiObjs.ScrollView_Camp:GetComponent("UIScrollView")
  self._occpBtns = {}
  local Group_Grid = self.m_panel:FindDirect("Img_Bg0/Group_Camp/ScrollView_Camp/Group_Grid")
  self._occpBtns[OccupationEnum.GUI_WANG_ZONG] = Group_Grid:FindDirect("Btn_Camp_1")
  self._occpBtns[OccupationEnum.QIN_GYUN_MEN] = Group_Grid:FindDirect("Btn_Camp_2")
  self._occpBtns[OccupationEnum.TIAN_YIN_SI] = Group_Grid:FindDirect("Btn_Camp_3")
  self._occpBtns[OccupationEnum.FEN_XIANG_GU] = Group_Grid:FindDirect("Btn_Camp_4")
  self._occpBtns[OccupationEnum.HE_HUAN_PAI] = Group_Grid:FindDirect("Btn_Camp_5")
  self._occpBtns[OccupationEnum.SHENG_WU_JIAO] = Group_Grid:FindDirect("Btn_Camp_6")
  self._occpBtns[OccupationEnum.CANG_YU_GE] = Group_Grid:FindDirect("Btn_Camp_7")
  self._occpBtns[OccupationEnum.LING_YIN_DIAN] = Group_Grid:FindDirect("Btn_Camp_8")
  self._occpBtns[OccupationEnum.YI_NENG_ZHE] = Group_Grid:FindDirect("Btn_Camp_9")
  self._occpBtns[OccupationEnum.WAN_DU_MEN] = Group_Grid:FindDirect("Btn_Camp_10")
  self._occpBtns[OccupationEnum.DAN_QING_GE] = Group_Grid:FindDirect("Btn_Camp_11")
  self._occpBtns[OccupationEnum.YIN_YANG_SHI] = Group_Grid:FindDirect("Btn_Camp_12")
end
def.override().OnDestroy = function(self)
  self:_Reset()
  self:_HideTip()
end
def.method()._HideTip = function(self)
  if OracleTip.Instance():IsShow() then
    OracleTip.Instance():DestroyPanel()
  end
end
def.method()._Reset = function(self)
  self._curOccupId = 0
  self._bDoubleOracles = false
  self._centerOracleCfg = nil
  if self._centerPage then
    self._centerPage:DestroyPanel()
    self._centerPage = nil
  end
  self._leftOracleCfg = nil
  if self._leftPage then
    self._leftPage:DestroyPanel()
    self._leftPage = nil
  end
  self._rightOracleCfg = nil
  if self._rightPage then
    self._rightPage:DestroyPanel()
    self._rightPage = nil
  end
end
def.override("boolean").OnShow = function(self, show)
  self:HandleEventListeners(show)
  if show then
    self:_SwitchOccuption(HeroInterface.GetHeroProp().occupation)
  else
    Event.DispatchEvent(ModuleId.ORACLE, gmodule.notifyId.Oracle.ORACLE_DLG_CLOSED, nil)
  end
end
def.method("boolean").HandleEventListeners = function(self, isRigister)
  local eventFunc
  if isRigister then
    eventFunc = Event.RegisterEvent
  else
    eventFunc = Event.UnregisterEvent
  end
  if eventFunc then
    eventFunc(ModuleId.ORACLE, gmodule.notifyId.Oracle.ON_GET_ORACLE_ALLOCATION, DlgOracle.OnGetOracleAllocation)
    eventFunc(ModuleId.FEATURE, gmodule.notifyId.Feature.FeatureOpenChange, DlgOracle.OnFunctionOpenChange)
    eventFunc(ModuleId.ORACLE, gmodule.notifyId.Oracle.ON_SWITCH_ORACLE_CHANGE, DlgOracle.OnSwitchOracle)
    eventFunc(ModuleId.ORACLE, gmodule.notifyId.Oracle.ORACLE_TOTAL_POINTS_CHANGE, DlgOracle.OnTotalPointsChange)
  end
end
def.static("table", "table").OnGetOracleAllocation = function(param, context)
  DlgOracle.Instance():_OnGetOracleAllocation(param, context)
end
def.method("table", "table")._OnGetOracleAllocation = function(self, param, context)
  if DlgOracle.Instance():IsShow() then
    if self._leftPage and self._leftOracleCfg and self._leftOracleCfg.id == param.oracleId then
      warn("[DlgOracle:_OnGetOracleAllocation] update left oracle page!")
      self._leftPage:UpdatePage()
    elseif self._rightPage and self._rightOracleCfg and self._rightOracleCfg.id == param.oracleId then
      warn("[DlgOracle:_OnGetOracleAllocation] update right oracle page!")
      self._rightPage:UpdatePage()
    elseif self._centerPage and self._centerOracleCfg and self._centerOracleCfg.id == param.oracleId then
      warn("[DlgOracle:_OnGetOracleAllocation] update center oracle page!")
      self._centerPage:UpdatePage()
    end
  end
  self:_HideTip()
end
def.static("table", "table").OnFunctionOpenChange = function(param, context)
  DlgOracle.Instance():_OnFunctionOpenChange(param, context)
end
def.method("table", "table")._OnFunctionOpenChange = function(self, param, context)
  if param.feature == ModuleFunSwitchInfo.TYPE_DOUBLE_GENIUS_SERIES then
    self:ShowOccpOracles(self._curOccupId)
  end
  self:_HideTip()
end
def.static("table", "table").OnSwitchOracle = function(param, context)
  DlgOracle.Instance():_OnSwitchOracle(param, context)
end
def.method("table", "table")._OnSwitchOracle = function(self, param, context)
  self:ShowOccpOracles(self._curOccupId)
  self:_HideTip()
end
def.static("table", "table").OnTotalPointsChange = function(param, context)
  DlgOracle.Instance():_OnTotalPointsChange(param, context)
end
def.method("table", "table")._OnTotalPointsChange = function(self, param, context)
  if self._bDoubleOracles then
    if self._leftPage then
      self._leftPage:UpdatePoints()
    end
    if self._rightPage then
      self._rightPage:UpdatePoints()
    end
  elseif self._centerPage then
    self._centerPage:UpdatePoints()
  end
end
def.method("number").ShowOccpOracles = function(self, occupationId)
  if occupationId ~= HeroInterface.GetHeroProp().occupation then
    Toast(textRes.Oracle.SWITCH_TO_OTHER_OCCUPATION)
  end
  self:_Reset()
  self._curOccupId = occupationId
  self._bDoubleOracles = OracleModule.Instance():IsDoubleOracle()
  if self._bDoubleOracles then
    self:_ShowOracle(OraclePage.ANCHOR_LEFT)
    self:_ShowOracle(OraclePage.ANCHOR_RIGHT)
  else
    self:_ShowOracle(OraclePage.ANCHOR_CENTER)
  end
end
def.method("number")._ShowOracle = function(self, anchorType)
  local oracleCfg, anchor
  if anchorType == OraclePage.ANCHOR_LEFT then
    self._leftOracleCfg = OracleData.Instance():GetOccpDefaultOracleCfg(self._curOccupId)
    oracleCfg = self._leftOracleCfg
    anchor = self._uiObjs.leftAnchor
  elseif anchorType == OraclePage.ANCHOR_RIGHT then
    self._rightOracleCfg = OracleData.Instance():GetOccpSecondOracleCfg(self._curOccupId)
    oracleCfg = self._rightOracleCfg
    anchor = self._uiObjs.rightAnchor
  elseif anchorType == OraclePage.ANCHOR_CENTER then
    self._centerOracleCfg = OracleData.Instance():GetOccpDefaultOracleCfg(self._curOccupId)
    oracleCfg = self._centerOracleCfg
    anchor = self._uiObjs.centerAnchor
  else
    error("[DlgOracle:_ShowOracle] wrong anchortype:", anchorType)
    return
  end
  if oracleCfg then
    local page = OraclePage.CreatePage(oracleCfg, anchor, anchorType)
    if anchorType == OraclePage.ANCHOR_LEFT then
      self._leftPage = page
    elseif anchorType == OraclePage.ANCHOR_RIGHT then
      self._rightPage = page
    elseif anchorType == OraclePage.ANCHOR_CENTER then
      self._centerPage = page
    end
  else
    error("[DlgOracle:_ShowOracle] oracleCfg nil for anchor:", anchor and anchor.name or nil)
  end
end
def.method("function")._CheckSaveAllocation = function(self, callback)
  local currentPage
  if self._bDoubleOracles then
    if self._leftPage and self._leftPage:IsCurrentOracle() then
      currentPage = self._leftPage
    elseif self._rightPage and self._rightPage:IsCurrentOracle() then
      currentPage = self._rightPage
    end
  elseif self._centerPage and self._centerPage:IsCurrentOracle() then
    currentPage = self._centerPage
  end
  if currentPage and currentPage:NeedSave() then
    require("GUI.CommonConfirmDlg").ShowConfirm(textRes.Oracle.ORACLE_RESET_CONFIRM_TITLE, textRes.Oracle.SAVE_ALLOCATION_CHANGE_CONFIRM, function(id, tag)
      if id == 1 then
        currentPage:DoSave()
      end
      if callback then
        callback()
      end
    end, nil)
  elseif callback then
    callback()
  end
end
def.method("string").onClick = function(self, id)
  if id == "Btn_Close" then
    self:OnBtn_Close()
  elseif id == "Btn_Help" then
    self:OnBtn_Help()
  else
    for occpId, btn in pairs(self._occpBtns) do
      if btn.name == id then
        self:_OnOccupationClicked(occpId, btn)
        break
      end
    end
  end
end
def.method().OnBtn_Close = function(self)
  self:_CheckSaveAllocation(function()
    self:DestroyPanel()
  end)
end
def.method().OnBtn_Help = function(self)
  local tipContent = require("Main.Common.TipsHelper").GetHoverTip(constant.COracleConsts.RULE_TIP_ID)
  local CommonUITipsDlg = require("GUI.CommonUITipsDlg")
  CommonUITipsDlg.Instance():ShowDlg(tipContent, {x = 0, y = 0})
end
def.method().OnBtn_Change = function(self)
  warn("[DlgOracle:OnBtn_Change] try switch oracle.")
  self:_CheckSaveAllocation(function()
    self:_DoSwitchOracle()
  end)
end
def.method()._DoSwitchOracle = function(self)
  if self._bDoubleOracles and self._curOccupId == HeroInterface.GetHeroProp().occupation then
    if self._leftPage and self._rightPage and self._leftOracleCfg and self._rightOracleCfg then
      do
        local targetOracleId = 0
        if self._leftPage:IsCurrentOracle() then
          targetOracleId = self._rightOracleCfg.id
        else
          targetOracleId = self._leftOracleCfg.id
        end
        if targetOracleId > 0 then
          warn("[DlgOracle:_DoSwitchOracle] switch to oracle:", targetOracleId)
          require("GUI.CommonConfirmDlg").ShowConfirm(textRes.Oracle.ORACLE_RESET_CONFIRM_TITLE, string.format(textRes.Oracle.ORACLE_SWITCH_CONFIRM_CONTENT, constant.COracleConsts.SWITCH_COST_GOLD), function(id, tag)
            if id == 1 then
              OracleProtocols.SendCSwitchPlan(targetOracleId)
            end
          end, nil)
        else
          warn("[DlgOracle:_DoSwitchOracle] targetOracleId invalid:", targetOracleId)
        end
      end
    else
      warn("[DlgOracle:_DoSwitchOracle] switch FAILED! Page or oracleCfg nil.")
    end
  else
    warn("[DlgOracle:_DoSwitchOracle] switch FAILED! self._bDoubleOracles = false.")
  end
end
def.method("number", "userdata")._OnOccupationClicked = function(self, occpId, btn)
  warn("[DlgOracle:_OnOccupationClicked] On Occupation Clicked.", occpId)
  self:_CheckSaveAllocation(function()
    self:_SwitchOccuption(occpId)
  end)
end
def.method("number")._SwitchOccuption = function(self, occupationId)
  if occupationId > 0 then
    warn("[DlgOracle:_SwitchOccuption] Switch occup to occpId:", occupationId)
    self:ShowOccpOracles(occupationId)
    local sprite
    for occpId, btn in pairs(self._occpBtns) do
      sprite = btn:FindDirect("Sprite")
      GUIUtils.SetActive(sprite, occupationId == occpId)
      if occupationId == occpId then
        self._uiObjs.uiScrollView:DragToMakeVisible(btn.transform, 128)
      end
    end
  else
    warn("[DlgOracle:_SwitchOccuption] Switch occup failed! occpId:", occpId)
  end
end
DlgOracle.Commit()
return DlgOracle

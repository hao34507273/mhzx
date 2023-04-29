local Lplus = require("Lplus")
local BaodianBasePanel = require("Main.Grow.ui.BaodianBasePanel")
local BaodianUtils = require("Main.Grow.BaodianUtils")
local GUIUtils = require("GUI.GUIUtils")
local HeroUtils = require("Main.Hero.HeroUtility")
local MenPaiEnum = require("consts.mzm.gsp.occupation.confbean.SOccupationEnum")
local GenderEnum = require("consts.mzm.gsp.occupation.confbean.SGenderEnum")
local BaodianJDPanel = Lplus.Extend(BaodianBasePanel, "BaodianJDPanel")
local def = BaodianJDPanel.define
def.field("number").mCurMenPai = 0
def.field("table").mCurPointInfo = nil
def.field("table").mUIObjs = nil
def.field("userdata").mParent = nil
local instance
def.static("=>", BaodianJDPanel).Instance = function()
  if instance == nil then
    instance = BaodianJDPanel()
  end
  return instance
end
def.override("userdata").ShowPanel = function(self, parentPanel)
  if self:IsShow() then
    return
  end
  self.mParent = parentPanel
  GameUtil.AddGlobalLateTimer(0, true, function()
    self:CreatePanel(RESPATH.PREFAB_BAODIAN_JIADIAN, 2)
  end)
end
def.override().OnCreate = function(self)
  if self.mParent == nil or self.mParent.isnil == true then
    self:DestroyPanel()
    return
  end
  self:InitData()
  self:InitUI()
  self:UpdateUI()
end
def.method().InitData = function(self)
  self.mCurMenPai = MenPaiEnum.GUI_WANG_ZONG
  self.mCurPointInfo = HeroUtils.GetRoleRecommandAssignPropCfg(self.mCurMenPai)
end
def.method().UpdateData = function(self)
  self.mCurPointInfo = HeroUtils.GetRoleRecommandAssignPropCfg(self.mCurMenPai)
end
def.method().InitUI = function(self)
  local OccpGrid = self.m_panel:FindDirect("Lead_BD_JD/Group_School/Group_Item/Scrollview/Grid")
  local GuiwangItem = OccpGrid:FindDirect("Tab_GW")
  GuiwangItem:GetComponent("UIToggle").value = true
  local ModuleFunSwitchInfo = require("netio.protocol.mzm.gsp.open.ModuleFunSwitchInfo")
  local bOpen = _G.IsFeatureOpen(ModuleFunSwitchInfo.TYPE_NEW_OCCUPATION_YI_NENG_ZHE)
  local YinengItem = OccpGrid:FindDirect("Tab_YN")
  GUIUtils.SetActive(YinengItem, bOpen)
  self.mUIObjs = {}
  local groupInfo = self.m_panel:FindDirect("Lead_BD_JD/Group_Info")
  local menpaiTip = groupInfo:FindDirect("Group_SchoolInfo/Label_Info")
  local menpaiName = groupInfo:FindDirect("Group_SchoolInfo/Label")
  self.mUIObjs.menpaiTip = menpaiTip
  self.mUIObjs.menpaiName = menpaiName
  local grouppoint = groupInfo:FindDirect("Group_SchoolPoint")
  local plan1 = grouppoint:FindDirect("Group_Plan1/Label_PlanNum")
  local desc1 = grouppoint:FindDirect("Group_Plan1/Label_PlanInfo")
  local plan2 = grouppoint:FindDirect("Group_Plan2/Label_PlanNum")
  local desc2 = grouppoint:FindDirect("Group_Plan2/Label_PlanInfo")
  local plan3 = grouppoint:FindDirect("Group_Plan3/Label_PlanNum")
  local desc3 = grouppoint:FindDirect("Group_Plan3/Label_PlanInfo")
  self.mUIObjs.plan = {}
  self.mUIObjs.desc = {}
  self.mUIObjs.plan[1] = plan1
  self.mUIObjs.desc[1] = desc1
  self.mUIObjs.plan[2] = plan2
  self.mUIObjs.desc[2] = desc2
  self.mUIObjs.plan[3] = plan3
  self.mUIObjs.desc[3] = desc3
end
def.method().UpdateUI = function(self)
  local curMenpaiName = GetOccupationName(self.mCurMenPai)
  self.mUIObjs.menpaiName:GetComponent("UILabel").text = curMenpaiName
  local curMenpaiDesc = GetOccupationCfg(self.mCurMenPai, GenderEnum.MALE).occupationDesc
  self.mUIObjs.menpaiTip:GetComponent("UILabel").text = curMenpaiDesc
  for i = 1, 3 do
    local points = {}
    local pointInfo = self.mCurPointInfo[i]
    points[1] = pointInfo.con
    points[2] = pointInfo.str
    points[3] = pointInfo.dex
    points[4] = pointInfo.sta
    points[5] = pointInfo.spi
    local desc = pointInfo.desc
    local pointdesc = ""
    for j = 1, 5 do
      if points[j] > 0 then
        pointdesc = pointdesc .. "    " .. string.format(textRes.Grow.JDName[j], points[j])
      end
    end
    self.mUIObjs.plan[i]:GetComponent("UILabel").text = pointdesc
    self.mUIObjs.desc[i]:GetComponent("UILabel").text = desc
  end
end
def.method("string").onClick = function(self, id)
  if id == "Tab_GW" then
    self:SetCurMenPai(MenPaiEnum.GUI_WANG_ZONG)
    self:UpdateData()
    self:UpdateUI()
  elseif id == "Tab_QY" then
    self:SetCurMenPai(MenPaiEnum.QIN_GYUN_MEN)
    self:UpdateData()
    self:UpdateUI()
  elseif id == "Tab_TY" then
    self:SetCurMenPai(MenPaiEnum.TIAN_YIN_SI)
    self:UpdateData()
    self:UpdateUI()
  elseif id == "Tab_FX" then
    self:SetCurMenPai(MenPaiEnum.FEN_XIANG_GU)
    self:UpdateData()
    self:UpdateUI()
  elseif id == "Tab_HH" then
    self:SetCurMenPai(MenPaiEnum.HE_HUAN_PAI)
    self:UpdateData()
    self:UpdateUI()
  elseif id == "Tab_SW" then
    self:SetCurMenPai(MenPaiEnum.SHENG_WU_JIAO)
    self:UpdateData()
    self:UpdateUI()
  elseif id == "Tab_CY" then
    self:SetCurMenPai(MenPaiEnum.CANG_YU_GE)
    self:UpdateData()
    self:UpdateUI()
  elseif id == "Tab_LY" then
    self:SetCurMenPai(MenPaiEnum.LING_YIN_DIAN)
    self:UpdateData()
    self:UpdateUI()
  elseif id == "Tab_YN" then
    self:SetCurMenPai(MenPaiEnum.YI_NENG_ZHE)
    self:UpdateData()
    self:UpdateUI()
  elseif id == "Tab_WD" then
    self:SetCurMenPai(MenPaiEnum.WAN_DU_MEN)
    self:UpdateData()
    self:UpdateUI()
  elseif id == "Tab_DQ" then
    self:SetCurMenPai(MenPaiEnum.DAN_QING_GE)
    self:UpdateData()
    self:UpdateUI()
  elseif id == "Tab_YY" then
    self:SetCurMenPai(MenPaiEnum.YIN_YANG_SHI)
    self:UpdateData()
    self:UpdateUI()
  end
end
def.method("number").SetCurMenPai = function(self, menpaiId)
  self.mCurMenPai = menpaiId
end
def.override().ReleaseUI = function(self)
end
def.override().OnDestroy = function(self)
  self:ReleaseUI()
  self.mCurMenPai = 0
  self.mCurPointInfo = nil
  self.mParent = nil
end
BaodianJDPanel.Commit()
return BaodianJDPanel

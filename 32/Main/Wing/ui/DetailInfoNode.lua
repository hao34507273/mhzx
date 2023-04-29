local Lplus = require("Lplus")
local TabNode = require("GUI.TabNode")
local DetailInfoNode = Lplus.Extend(TabNode, "DetailInfoNode")
local ECUIModel = require("Model.ECUIModel")
local ECPanelBase = require("GUI.ECPanelBase")
local WingModule = require("Main.Wing.WingModule")
local GUIUtils = require("GUI.GUIUtils")
local SkillUtility = require("Main.Skill.SkillUtility")
local WingUtils = require("Main.Wing.WingUtils")
local ItemUtils = require("Main.Item.ItemUtils")
local WingModel = require("Main.Wing.ui.WingModel")
local WingOutlookType = require("consts.mzm.gsp.wing.confbean.WingOutlookType")
local Vector = require("Types.Vector")
local LuaPlayerPrefs = require("Main.Common.LuaPlayerPrefs")
local def = DetailInfoNode.define
def.const("number").ONEPAGE = 3
def.const("number").ONEPAGEGRID = 8
def.field("table").wings = nil
def.field("number").curType = 1
def.field("number").currentPage = 1
def.field("number").currentPageGrid = 1
def.field("table").models = nil
def.field("table").right_model = nil
def.field("number").dragIndex = 0
def.field("boolean").gridShow = false
def.field("boolean").TryMode = false
def.field("table").lastPageItems = nil
def.field("table").items = nil
def.field("table").uiObjs = nil
def.field("boolean").m_isUIInited = false
def.field("number").wingId = 0
def.field("table").role_model = nil
def.field("number").wingTimerId = 0
def.override(ECPanelBase, "userdata").Init = function(self, base, node)
  TabNode.Init(self, base, node)
  self:InitUI()
end
def.override().OnShow = function(self)
  Event.RegisterEventWithContext(ModuleId.WING, gmodule.notifyId.Wing.WINGS_CHANGE, DetailInfoNode.OnWingChange, self)
  Event.RegisterEventWithContext(ModuleId.WING, gmodule.notifyId.Wing.WINGS_PHASE_CHANGE, DetailInfoNode.OnPhaseChange, self)
  Event.RegisterEventWithContext(ModuleId.WING, gmodule.notifyId.Wing.WINGS_DATA_CHANGE, DetailInfoNode.OnWingChange, self)
  Event.RegisterEventWithContext(ModuleId.IDIP, gmodule.notifyId.IDIP.ITEM_IDIP_INFO_CHANGE, DetailInfoNode.OnIDIPInfoChg, self)
  self:Reposition()
  self.models = {}
  for i = 1, DetailInfoNode.ONEPAGE do
    self.models[i] = WingModel()
  end
  if self.gridShow == false then
    self.m_node:FindDirect("Scroll View"):SetActive(true)
    self.m_node:FindDirect("Group_EZMode"):SetActive(false)
    self:SelectTypeAndPage(self.curType, self.currentPage, true)
  end
  self:setCurOccName()
  if self.gridShow then
    local wingData = WingModule.Instance():GetWingData()
    self:ShowRightAttr(self.wings[1], self.TryMode)
    self.m_node:FindDirect("Scroll View"):SetActive(false)
    self.m_node:FindDirect("Group_EZMode"):SetActive(true)
    local Img_Select = self.m_node:FindDirect("Group_EZMode/Group_Left/Group_List/Group_Item_1/Img_Select")
    Img_Select:SetActive(true)
    self:UpdatePage()
    self:SelectTypeAndPage(self.curType, self.currentPageGrid, true)
  end
  self:UpdateWing()
  local display_mode = LuaPlayerPrefs.GetRoleInt("wing_display_mode")
  if display_mode == 1 then
    self.gridShow = true
  elseif display_mode == 2 then
    self.gridShow = false
  end
  self:ChangeMode()
  self:ShowCur()
  self:StartWingTimer()
end
def.override().OnHide = function(self)
  Event.UnregisterEvent(ModuleId.WING, gmodule.notifyId.Wing.WINGS_CHANGE, DetailInfoNode.OnWingChange)
  Event.UnregisterEvent(ModuleId.WING, gmodule.notifyId.Wing.WINGS_DATA_CHANGE, DetailInfoNode.OnWingChange)
  Event.UnregisterEvent(ModuleId.WING, gmodule.notifyId.Wing.WINGS_PHASE_CHANGE, DetailInfoNode.OnPhaseChange)
  Event.UnregisterEvent(ModuleId.IDIP, gmodule.notifyId.IDIP.ITEM_IDIP_INFO_CHANGE, DetailInfoNode.OnIDIPInfoChg)
  self:StopWingTimer()
  if self.models then
    for k, v in ipairs(self.models) do
      v:Destroy()
    end
  end
  if self.right_model then
    self.right_model:Destroy()
  end
  if self.role_model then
    self.role_model:Destroy()
    self.role_model = nil
  end
end
def.method().setCurOccName = function(self)
  local Group_PlanWing = self.m_node:FindDirect("Group_PlanWing")
  if not _G.IsFeatureOpen(require("netio.protocol.mzm.gsp.open.ModuleFunSwitchInfo").TYPE_WING_OCC_PLAN) then
    Group_PlanWing:SetActive(false)
    return
  end
  local wingData = WingModule.Instance():GetWingData()
  local Label_PlanName = self.m_node:FindDirect("Group_PlanWing/Label_PlanName")
  Label_PlanName:GetComponent("UILabel"):set_text(wingData:GetOccNameById(wingData:GetCurOccupationId()))
end
def.method("table").OnPhaseChange = function(self, params)
  self:SelectTypeAndPage(self.curType, self.currentPage, true)
end
def.method("table").OnWingChange = function(self, params)
  self:UpdateWing()
end
local ItemSwitchInfo = require("netio.protocol.mzm.gsp.idip.ItemSwitchInfo")
local IDIPInterface = require("Main.IDIP.IDIPInterface")
def.method("table", "=>", "table")._filteOpenedWings = function(self, wings)
  if wings == nil then
    return nil
  end
  local retData = {}
  for k, wingId in ipairs(wings) do
    local wingCfg = WingUtils.GetWingCfg(wingId)
    local wingOutlook = WingUtils.GetWingViewCfg(wingCfg.outlook)
    local bOpen = IDIPInterface.IsItemIDIPOpen(ItemSwitchInfo.WING, wingOutlook.id)
    local wingData = WingModule.Instance():GetWingData()
    local wingInfo = wingData:GetWingByWingId(wingId)
    if wingInfo ~= nil or bOpen then
      table.insert(retData, wingId)
    end
  end
  return retData
end
def.method("number", "number", "boolean").SelectTypeAndPage = function(self, type, page, forceUpdate)
  local wingData = WingModule.Instance():GetWingData()
  local typeChange = false
  local pageChange = false
  if forceUpdate then
    if type == WingOutlookType.TY_SJ then
      self.curType = type
      typeChange = true
      self.wings = WingUtils.GetAllPromoteWingWithRank(wingData:GetPhase())
    elseif type == WingOutlookType.TY_WG then
      self.curType = type
      typeChange = true
      local wings = WingUtils.GetAllOtherWing()
      self.wings = self:_filteOpenedWings(wings) or {}
      table.sort(self.wings, function(a, b)
        if wingData:GetWingByWingId(a) and wingData:GetWingByWingId(b) then
          return a < b
        elseif wingData:GetWingByWingId(a) then
          return true
        elseif wingData:GetWingByWingId(b) then
          return false
        else
          return a < b
        end
      end)
    end
  elseif type > 0 and type ~= self.curType then
    if type == WingOutlookType.TY_SJ then
      self.curType = type
      typeChange = true
      self.wings = WingUtils.GetAllPromoteWingWithRank(wingData:GetPhase())
    elseif type == WingOutlookType.TY_WG then
      self.curType = type
      typeChange = true
      local wings = WingUtils.GetAllOtherWing()
      self.wings = self:_filteOpenedWings(wings) or {}
      table.sort(self.wings, function(a, b)
        if wingData:GetWingByWingId(a) and wingData:GetWingByWingId(b) then
          return a < b
        elseif wingData:GetWingByWingId(a) then
          return true
        elseif wingData:GetWingByWingId(b) then
          return false
        else
          return a < b
        end
      end)
    end
  end
  local pageCount = math.ceil(#self.wings / DetailInfoNode.ONEPAGE)
  page = math.min(math.max(1, page), pageCount)
  if self.gridShow then
    if self.currentPageGrid ~= page then
      self.currentPageGrid = page
      pageChange = true
    end
  elseif self.currentPage ~= page then
    self.currentPage = page
    pageChange = true
  end
  if typeChange then
    self:UpdateTab()
  end
  if typeChange or pageChange then
    if self.gridShow == false then
      self:UpdateArrowAndPoint()
    end
    self:UpdateWing()
  end
  if self.gridShow then
    self:UpdatePage()
  end
  self:UpdateArrowAndPoint()
end
def.method().InitUI = function(self)
  local list = self.m_node:FindDirect("Scroll View/List")
  local listCmp = list:GetComponent("UIList")
  if self.m_isUIInited then
    return false
  end
  self.uiObjs = {}
  self.uiObjs.Group_Left = self.m_node:FindDirect("Group_EZMode/Group_Left")
  self.uiObjs.Group_List = self.uiObjs.Group_Left:FindDirect("Group_List")
  self.uiObjs.Template_Group_Item = self.uiObjs.Group_List:FindDirect("Group_Item")
  self.uiObjs.Template_Group_Item:SetActive(false)
  listCmp:set_itemCount(DetailInfoNode.ONEPAGE)
  listCmp:Resize()
  self.m_isUIInited = true
  local Label_Page = self.m_node:FindDirect("Group_EZMode/Group_Left/Group_Page/Img_BgPage/Label_Page")
  local boxCollider = Label_Page:GetComponent("BoxCollider")
  if boxCollider == nil then
    boxCollider = Label_Page:AddComponent("BoxCollider")
    local uiWidget = Label_Page:GetComponent("UIWidget")
    uiWidget.autoResizeBoxCollider = true
    uiWidget:ResizeCollider()
    self.m_base.m_msgHandler:Touch(Label_Page)
  end
  if self.gridShow then
    self:ShowCur()
  end
end
def.method().Reposition = function(self)
  local list = self.m_node:FindDirect("Scroll View/List")
  local listCmp = list:GetComponent("UIList")
  listCmp:Reposition()
end
def.method().UpdateTab = function(self)
  if self.curType == WingOutlookType.TY_SJ then
    local normal = self.m_node:FindDirect("Btn_Normal")
    normal:GetComponent("UIToggle"):set_value(true)
    local special = self.m_node:FindDirect("Btn_Special")
    special:GetComponent("UIToggle"):set_value(false)
  elseif self.curType == WingOutlookType.TY_WG then
    local special = self.m_node:FindDirect("Btn_Special")
    special:GetComponent("UIToggle"):set_value(true)
    local normal = self.m_node:FindDirect("Btn_Normal")
    normal:GetComponent("UIToggle"):set_value(false)
  end
end
def.method().UpdateArrowAndPoint = function(self)
  local pageCount = math.ceil(#self.wings / DetailInfoNode.ONEPAGE)
  local pageCountGrid = math.ceil(#self.wings / DetailInfoNode.ONEPAGEGRID)
  local pointList = self.m_node:FindDirect("List_Point")
  if self.gridShow then
    pointList:SetActive(false)
  else
    local listCmp = pointList:GetComponent("UIList")
    listCmp:set_itemCount(pageCount)
    listCmp:Resize()
    self.items = listCmp:get_children()
    for i = 1, #self.items do
      local uiGo = self.items[i]
      if i == self.currentPage then
        uiGo:GetComponent("UIToggle"):set_value(true)
      end
    end
  end
  local leftArrow = self.m_node:FindDirect("Btn_Left")
  local rightArrow = self.m_node:FindDirect("Btn_Right")
  if self.gridShow == true then
    if 1 >= self.currentPageGrid then
      leftArrow:SetActive(false)
    else
      leftArrow:SetActive(true)
    end
    if pageCountGrid <= self.currentPageGrid then
      rightArrow:SetActive(false)
    else
      rightArrow:SetActive(true)
    end
  else
    if 1 >= self.currentPage then
      leftArrow:SetActive(false)
    else
      leftArrow:SetActive(true)
    end
    if pageCount <= self.currentPage then
      rightArrow:SetActive(false)
    else
      rightArrow:SetActive(true)
    end
  end
end
def.method().UpdatePage = function(self)
  local pageCount = math.ceil(#self.wings / DetailInfoNode.ONEPAGEGRID)
  local curPage = self.currentPageGrid
  local Label_Page = self.m_node:FindDirect("Group_EZMode/Group_Left/Group_Page/Img_BgPage/Label_Page")
  Label_Page:GetComponent("UILabel"):set_text(curPage .. "/" .. pageCount)
  local leftArrow = self.m_node:FindDirect("Btn_Left")
  local rightArrow = self.m_node:FindDirect("Btn_Right")
  if self.currentPageGrid <= 1 then
    leftArrow:SetActive(false)
  else
    leftArrow:SetActive(true)
  end
  if pageCount <= self.currentPageGrid then
    rightArrow:SetActive(false)
  else
    rightArrow:SetActive(true)
  end
  for i = 1, DetailInfoNode.ONEPAGEGRID do
    local Tab_Select = self.m_node:FindDirect(string.format("Group_EZMode/Group_Left/Group_List/Group_Item_%d/Img_Select", i))
    if Tab_Select then
      Tab_Select:SetActive(false)
    end
  end
end
def.method().UpdateWing = function(self)
  if self.gridShow == false then
    local curWingData = {}
    local start = (self.currentPage - 1) * DetailInfoNode.ONEPAGE + 1
    for i = start, start + DetailInfoNode.ONEPAGE - 1 do
      table.insert(curWingData, self.wings[i])
    end
    local list = self.m_node:FindDirect("Scroll View/List")
    for i = 1, DetailInfoNode.ONEPAGE do
      local wingUI = list:FindDirect("wing_" .. i)
      local wingId = curWingData[i] or 0
      if wingUI then
        self:FillWing(wingUI, wingId, i)
      end
    end
  else
    local curWingData = {}
    local start = (self.currentPageGrid - 1) * DetailInfoNode.ONEPAGEGRID + 1
    for i = start, start + DetailInfoNode.ONEPAGEGRID - 1 do
      table.insert(curWingData, self.wings[i])
    end
    self:SetItemList(curWingData)
    local list = self.m_node:FindDirect("Group_EZMode/Group_Left/Group_List")
    for i = 1, DetailInfoNode.ONEPAGEGRID do
      local wingUI = list:FindDirect("Group_Item_" .. i)
      local wingId = curWingData[i] or 0
      if wingUI then
        self:FillWingLeft(wingUI, wingId, i)
      end
    end
    local wing = self.wingId
    if wing > 0 then
      self:ShowRightAttr(wing, self.TryMode)
    elseif wing == 0 then
      self.wingId = self.wings[1]
      self:ShowRightAttr(self.wingId, self.TryMode)
    end
  end
  self:UpdateWingTimeInfo()
end
def.method().UpdateWingTimeInfo = function(self)
  if self.wings ~= nil then
    if self.gridShow == false then
      local curWingData = {}
      local start = (self.currentPage - 1) * DetailInfoNode.ONEPAGE + 1
      for i = start, start + DetailInfoNode.ONEPAGE - 1 do
        table.insert(curWingData, self.wings[i])
      end
      local list = self.m_node:FindDirect("Scroll View/List")
      for i = 1, DetailInfoNode.ONEPAGE do
        local wingUI = list:FindDirect("wing_" .. i)
        local wingId = curWingData[i] or 0
        if wingUI then
          self:FillWingTimeInfo(wingUI, wingId, i)
        end
      end
    else
      local Label_WingTime = self.m_node:FindDirect("Group_EZMode/Group_Right/Group_Preview/wing/Label_WingTime")
      GUIUtils.SetActive(Label_WingTime, true)
      local wingId = self.wingId
      local wingData = WingModule.Instance():GetWingData()
      if not wingData:HasWing(wingId) or wingData:IsWingForeverOwn(wingId) then
        GUIUtils.SetText(Label_WingTime, "")
      elseif wingData:IsWingExpired(wingId) then
        GUIUtils.SetText(Label_WingTime, textRes.Wing[66])
      else
        local expireTime = wingData:GetWingExpireTime(wingId)
        local leftTime = math.max(0, expireTime - _G.GetServerTime())
        GUIUtils.SetText(Label_WingTime, _G.SecondsToTimeText(leftTime))
      end
    end
  end
end
def.method().StartWingTimer = function(self)
  if self.wingTimerId > 0 then
    self:StopWingTimer()
  end
  self.wingTimerId = GameUtil.AddGlobalTimer(1, false, function()
    self:UpdateWingTimeInfo()
  end)
end
def.method().StopWingTimer = function(self)
  if self.wingTimerId > 0 then
    GameUtil.RemoveGlobalTimer(self.wingTimerId)
  end
  self.wingTimerId = 0
end
def.method("table").SetItemList = function(self, viewdata)
  local count = #viewdata
  self:ResizeGridList(count)
  for i, v in ipairs(viewdata) do
  end
end
def.method("number").ResizeGridList = function(self, size)
  local childCount = self.uiObjs.Group_List.childCount - 1
  if size > childCount then
    for i = childCount + 1, size do
      local Group_Item = GameObject.Instantiate(self.uiObjs.Template_Group_Item)
      Group_Item:SetActive(true)
      Group_Item.name = "Group_Item_" .. i
      Group_Item.transform.parent = self.uiObjs.Group_List.transform
      Group_Item.transform.localScale = Vector.Vector3.one
      self.m_base.m_msgHandler:Touch(Group_Item)
    end
  elseif size < childCount then
    for j = childCount, size + 1, -1 do
      local Group_Item = self.uiObjs.Group_List:GetChild(j)
      GameObject.Destroy(Group_Item)
    end
  end
  self.uiObjs.Group_List:GetComponent("UIGrid"):Reposition()
end
def.method("number", "table").SetItemInfo = function(self, index, itemInfo)
  local itemObj = self.uiObjs.Group_List:GetChild(index)
  local Label_Name = itemObj:FindDirect("Label_Name")
  local wingCfg = WingUtils.GetWingCfg(itemInfo)
  local wingOutlook = WingUtils.GetWingViewCfg(wingCfg.outlook)
  local wingItem = ItemUtils.GetItemBase(wingOutlook.fakeItemId)
  Label_Name:GetComponent("UILabel"):set_text(wingItem.name)
end
def.method().ChangeMode = function(self)
  if self.gridShow == true then
    self.m_node:FindDirect("Scroll View"):SetActive(false)
    self.m_node:FindDirect("Group_EZMode"):SetActive(true)
    self.m_node:FindDirect("Img_ChangeMode"):FindDirect("Img_List"):SetActive(false)
    self.m_node:FindDirect("Img_ChangeMode"):FindDirect("Img_Grid"):SetActive(true)
    local ezmode = self.m_node:FindDirect("Group_EZMode")
    ezmode:SetActive(true)
    local list = self.m_node:FindDirect("Scroll View/List")
    list:SetActive(false)
    self:UpdateWing()
    local pointList = self.m_node:FindDirect("List_Point")
    pointList:SetActive(false)
    self:ShowRightAttr(self.wings[1], self.TryMode)
    LuaPlayerPrefs.SetRoleInt("wing_display_mode", 1)
  else
    self.m_node:FindDirect("Scroll View"):SetActive(true)
    self.m_node:FindDirect("Group_EZMode"):SetActive(false)
    self:Reposition()
    self.m_node:FindDirect("Img_ChangeMode"):FindDirect("Img_List"):SetActive(true)
    self.m_node:FindDirect("Img_ChangeMode"):FindDirect("Img_Grid"):SetActive(false)
    local ezmode = self.m_node:FindDirect("Group_EZMode")
    ezmode:SetActive(false)
    local list = self.m_node:FindDirect("Scroll View/List")
    list:SetActive(true)
    self:UpdateWing()
    local pointList = self.m_node:FindDirect("List_Point")
    pointList:SetActive(true)
    LuaPlayerPrefs.SetRoleInt("wing_display_mode", 2)
  end
  if self.gridShow == false then
    self:SelectTypeAndPage(self.curType, self.currentPage, true)
  end
  self:setCurOccName()
  if self.gridShow then
    local wingData = WingModule.Instance():GetWingData()
    self:UpdatePage()
    self:SelectTypeAndPage(self.curType, self.currentPageGrid, true)
  end
  self:UpdateWing()
  if gridShow then
    self:ShowRightAttr(self.wings[1], self.TryMode)
    local Tab_1 = self.m_node:FindDirect("Group_EZMode/Group_Left/Group_List/Group_Item_1/Img_BgBuyItem")
    Tab_1:GetComponent("UIToggle").value = true
  end
end
def.method().ChangeTryMode = function(self)
  local wingData = WingModule.Instance():GetWingData()
  local wing = self.wingId
  if wing == 0 then
    self.wingId = wingData:GetCurWingId()
    wing = self.wingId
  end
  self:ShowRightAttr(wing, self.TryMode)
  local Label_Name = self.m_node:FindDirect("Group_EZMode/Group_Right/Group_Btn/Btn_TryMode/Label_Name")
  if self.TryMode then
    Label_Name:GetComponent("UILabel"):set_text(textRes.Wing[61])
  else
    Label_Name:GetComponent("UILabel"):set_text(textRes.Wing[60])
    if self.role_model then
      self.role_model:Destroy()
      self.role_model = nil
    end
  end
end
def.method("userdata", "number", "number").FillWing = function(self, wingUI, wingId, index)
  if wingId > 0 then
    wingUI:SetActive(true)
    local wingData = WingModule.Instance():GetWingData()
    local wingCfg = WingUtils.GetWingCfg(wingId)
    local wingOutlook = WingUtils.GetWingViewCfg(wingCfg.outlook)
    local wingItem = ItemUtils.GetItemBase(wingOutlook.fakeItemId)
    local wingInfo = wingData:GetWingByWingId(wingId)
    local bOpen = IDIPInterface.IsItemIDIPOpen(ItemSwitchInfo.WING, wingOutlook.id)
    local childCount = wingUI.childCount
    if wingInfo == nil and not bOpen then
      for i = 0, childCount - 1 do
        wingUI:GetChild(i):SetActive(false)
      end
      local obtainDesc = wingUI:FindDirect(string.format("Label_Get_%d", index))
      obtainDesc:SetActive(true)
      GUIUtils.SetText(obtainDesc, textRes.Wing[51])
      return
    end
    for i = 0, childCount - 1 do
      wingUI:GetChild(i):SetActive(true)
    end
    local m = self.models[index]
    local uiModel = wingUI:FindDirect(string.format("Model_Wing_%d", index))
    self:FillWingModel(uiModel, m, wingCfg.outlook, wingInfo and wingInfo.colorId or 0)
    local nameLabel = wingUI:FindDirect(string.format("Label_WingName_%d", index))
    nameLabel:GetComponent("UILabel"):set_text(wingItem.name)
    local obtainDesc = wingUI:FindDirect(string.format("Label_Get_%d", index))
    obtainDesc:GetComponent("UILabel"):set_text(wingCfg.gainDes)
    local colorBtn = wingUI:FindDirect(string.format("Btn_Color_%d", index))
    colorBtn:SetActive(wingInfo ~= nil)
    local dressBtn = wingUI:FindDirect(string.format("Btn_Dress_%d", index))
    local undressBtn = wingUI:FindDirect(string.format("Btn_Undress_%d", index))
    local dressedBtn = wingUI:FindDirect(string.format("Img_Dressed_%d", index))
    local tryBtn = wingUI:FindDirect(string.format("Btn_Try_%d", index))
    local previewBtn = wingUI:FindDirect(string.format("Group_Btn_%d", index))
    if wingInfo then
      if wingData:GetCurWingId() == wingId then
        dressBtn:SetActive(false)
        undressBtn:SetActive(true)
        dressedBtn:SetActive(true)
        tryBtn:SetActive(false)
      else
        dressBtn:SetActive(true)
        undressBtn:SetActive(false)
        dressedBtn:SetActive(false)
        tryBtn:SetActive(false)
      end
      previewBtn:SetActive(false)
    else
      dressBtn:SetActive(false)
      undressBtn:SetActive(false)
      dressedBtn:SetActive(false)
      tryBtn:SetActive(true)
      previewBtn:SetActive(true)
      local propPreview = previewBtn:FindDirect(string.format("Img_AttPre_%d", index))
      local skillPreview = previewBtn:FindDirect(string.format("Img_SkillPre_%d", index))
      if 0 < wingCfg.initProId then
        propPreview:SetActive(true)
      else
        propPreview:SetActive(false)
      end
      if 0 < wingCfg.initSkillLib then
        skillPreview:SetActive(true)
      else
        skillPreview:SetActive(false)
      end
    end
    local gray = wingUI:FindDirect(string.format("Gray_%d", index))
    gray:SetActive(wingInfo == nil)
    local lockLabel = wingUI:FindDirect(string.format("Label_Lock_%d", index))
    local unlockGroup = wingUI:FindDirect(string.format("Group_Unlocked_%d", index))
    if wingInfo then
      unlockGroup:SetActive(true)
      lockLabel:SetActive(false)
      local propLabel = unlockGroup:FindDirect(string.format("Label_Shuxing_%d", index))
      local skill1 = unlockGroup:FindDirect(string.format("Img_SkillBg1_%d", index))
      local skill2 = unlockGroup:FindDirect(string.format("Img_SkillBg2_%d", index))
      local props = wingInfo.props
      local skills = wingInfo.skills
      if props then
        local prefix = skills and "" or "        "
        propLabel:SetActive(true)
        local propStr = WingUtils.PropsToString(wingInfo.id, props, prefix)
        propLabel:GetComponent("UILabel"):set_text(propStr)
      else
        propLabel:SetActive(false)
      end
      if skills then
        local skillIcon
        if props then
          skill1:SetActive(false)
          skill2:SetActive(true)
          skillIcon = skill2
        else
          skill1:SetActive(true)
          skill2:SetActive(false)
          skillIcon = skill1
        end
        self:FillSkillIcon(skillIcon, skills[1], index)
      else
        skill1:SetActive(false)
        skill2:SetActive(false)
      end
      local reset0 = unlockGroup:FindDirect(string.format("Btn_Reset_%d", index))
      local reset1 = unlockGroup:FindDirect(string.format("Btn_ResetProperty_%d", index))
      local reset2 = unlockGroup:FindDirect(string.format("Btn_ResetSkill_%d", index))
      local resetType = WingUtils.GetResetType(wingCfg)
      if resetType == 3 then
        reset0:SetActive(false)
        reset1:SetActive(true)
        reset2:SetActive(true)
      elseif resetType == 2 then
        reset0:SetActive(true)
        reset1:SetActive(false)
        reset2:SetActive(false)
      elseif resetType == 1 then
        reset0:SetActive(true)
        reset1:SetActive(false)
        reset2:SetActive(false)
      elseif resetType == 0 then
        reset0:SetActive(false)
        reset1:SetActive(false)
        reset2:SetActive(false)
      end
    else
      unlockGroup:SetActive(false)
      lockLabel:SetActive(true)
      local unlockType = WingUtils.GetUnlockType(wingCfg)
      local text = textRes.Wing.UnlockDesc[unlockType]
      lockLabel:GetComponent("UILabel"):set_text(text)
    end
  else
    wingUI:SetActive(false)
  end
end
def.method("userdata", "number", "number").FillWingTimeInfo = function(self, wingUI, wingId, index)
  if wingUI == nil then
    return
  end
  if wingId > 0 then
    wingUI:SetActive(true)
    local wingData = WingModule.Instance():GetWingData()
    local Label_WingTime = wingUI:FindDirect(string.format("Label_WingTime_%d", index))
    if not wingData:HasWing(wingId) or wingData:IsWingForeverOwn(wingId) then
      GUIUtils.SetText(Label_WingTime, "")
    elseif wingData:IsWingExpired(wingId) then
      GUIUtils.SetText(Label_WingTime, textRes.Wing[66])
    else
      local expireTime = wingData:GetWingExpireTime(wingId)
      local leftTime = math.max(0, expireTime - _G.GetServerTime())
      GUIUtils.SetText(Label_WingTime, _G.SecondsToTimeText(leftTime))
    end
  else
    wingUI:SetActive(false)
  end
end
def.method("userdata", "number", "number").FillWingLeft = function(self, wingUI, wingId, index)
  if wingId > 0 then
    wingUI:SetActive(true)
    local wingData = WingModule.Instance():GetWingData()
    local wingCfg = WingUtils.GetWingCfg(wingId)
    local wingOutlook = WingUtils.GetWingViewCfg(wingCfg.outlook)
    local wingItem = ItemUtils.GetItemBase(wingOutlook.fakeItemId)
    local wingInfo = wingData:GetWingByWingId(wingId)
    local bOpen = IDIPInterface.IsItemIDIPOpen(ItemSwitchInfo.WING, wingOutlook.id)
    local childCount = wingUI.childCount
    local nameLabel = wingUI:FindDirect("Label_Name")
    nameLabel:GetComponent("UILabel"):set_text(wingItem.name)
    if self.curType == WingOutlookType.TY_WG and not wingInfo then
      local Label_Havenot = wingUI:FindDirect("Label_Havenot")
      Label_Havenot:SetActive(true)
      local obtainDesc = wingUI:FindDirect("Label_Level")
      obtainDesc:GetComponent("UILabel"):set_text("")
    elseif self.curType == WingOutlookType.TY_SJ or wingInfo then
      local obtainDesc = wingUI:FindDirect("Label_Level")
      obtainDesc:GetComponent("UILabel"):set_text(wingCfg.gainDes)
      local Label_Havenot = wingUI:FindDirect("Label_Havenot")
      Label_Havenot:SetActive(false)
    end
    local itemIcon = wingUI:FindDirect("Img_BgItem"):FindDirect("Texture_Icon")
    itemIcon:SetActive(true)
    local uiTexture = itemIcon:GetComponent("UITexture")
    GUIUtils.FillIcon(uiTexture, wingItem.icon)
  end
end
def.method("number", "boolean").ShowRightAttr = function(self, wingId, tryMode)
  local wingUI = self.m_node:FindDirect("Group_EZMode/Group_Right/Group_Preview/wing")
  if wingId > 0 then
    wingUI:SetActive(true)
    do
      local wingData = WingModule.Instance():GetWingData()
      local wingCfg = WingUtils.GetWingCfg(wingId)
      local wingOutlook = WingUtils.GetWingViewCfg(wingCfg.outlook)
      local wingItem = ItemUtils.GetItemBase(wingOutlook.fakeItemId)
      local wingInfo = wingData:GetWingByWingId(wingId)
      local bOpen = IDIPInterface.IsItemIDIPOpen(ItemSwitchInfo.WING, wingOutlook.id)
      local childCount = wingUI.childCount
      if self.right_model then
        self.right_model:Destroy()
      end
      if tryMode then
        local modelId = gmodule.moduleMgr:GetModule(ModuleId.HERO):GetMyModelId()
        local WingModelPanel = wingUI:FindDirect("Model_Wing")
        WingModelPanel.transform.localPosition = Vector.Vector3.new(0, 0, 0)
        local uiModel = WingModelPanel:GetComponent("UIModel")
        if self.role_model == nil then
          self.role_model = ECUIModel.new(modelId)
          self.role_model.m_bUncache = true
          self.role_model.m_uiModel = uiModel
          local tryModelInfo = gmodule.moduleMgr:GetModule(ModuleId.PUBROLE):GetRoleModelInfo(gmodule.moduleMgr:GetModule(ModuleId.HERO).roleId)
          _G.LoadModel(self.role_model, tryModelInfo, 0, 0, 180, false, false)
        end
        uiModel.mCanOverflow = true
        if self.role_model:IsInLoading() then
          self.role_model:AddOnLoadCallback("set_wing", function()
            self.role_model:SetWing(wingCfg.outlook, wingInfo and wingInfo.colorId or 0)
          end)
        else
          self.role_model:SetWing(wingCfg.outlook, wingInfo and wingInfo.colorId or 0)
        end
      else
        self.right_model = WingModel()
        local uiModel = wingUI:FindDirect("Model_Wing")
        uiModel.transform.localPosition = Vector.Vector3.new(0, 144, 0)
        self:FillWingModel(uiModel, self.right_model, wingCfg.outlook, wingInfo and wingInfo.colorId or 0)
      end
      local Label_WingName = wingUI:FindDirect("Label_WingName")
      Label_WingName:GetComponent("UILabel"):set_text(wingItem.name)
      if not tryMode then
        local Label_Get = wingUI:FindDirect("Label_Get")
        Label_Get:GetComponent("UILabel"):set_text(wingCfg.gainDes)
      else
        local Label_Get = wingUI:FindDirect("Label_Get")
        Label_Get:GetComponent("UILabel"):set_text("")
      end
      local colorBtn = wingUI:FindDirect("Btn_Color")
      colorBtn:SetActive(wingInfo ~= nil)
      local dressBtn = wingUI:FindDirect("Btn_Dress")
      local undressBtn = wingUI:FindDirect("Btn_Undress")
      local dressedBtn = wingUI:FindDirect("Img_Dressed")
      local tryBtn = wingUI:FindDirect("Btn_Try")
      local previewBtn = wingUI:FindDirect("Group_Btn")
      if wingInfo then
        if wingData:GetCurWingId() == wingId then
          dressBtn:SetActive(false)
          undressBtn:SetActive(true)
          dressedBtn:SetActive(true)
          tryBtn:SetActive(false)
        else
          dressBtn:SetActive(true)
          undressBtn:SetActive(false)
          dressedBtn:SetActive(false)
          tryBtn:SetActive(false)
        end
        previewBtn:SetActive(false)
      else
        dressBtn:SetActive(false)
        undressBtn:SetActive(false)
        dressedBtn:SetActive(false)
        tryBtn:SetActive(true)
        previewBtn:SetActive(true)
        local propPreview = previewBtn:FindDirect("Img_AttPre")
        local skillPreview = previewBtn:FindDirect("Img_SkillPre")
        if 0 < wingCfg.initProId then
          propPreview:SetActive(true)
        else
          propPreview:SetActive(false)
        end
        if 0 < wingCfg.initSkillLib then
          skillPreview:SetActive(true)
        else
          skillPreview:SetActive(false)
        end
      end
      local gray = wingUI:FindDirect("Gray")
      gray:SetActive(wingInfo == nil)
      if tryMode then
        gray:SetActive(false)
      end
      local Label_Lock = wingUI:FindDirect("Label_Lock")
      local Group_Unlocked = wingUI:FindDirect("Group_Unlocked")
      if wingInfo then
        Group_Unlocked:SetActive(true)
        Label_Lock:SetActive(false)
        local Label_Shuxing = Group_Unlocked:FindDirect("Label_Shuxing")
        local skill1 = Group_Unlocked:FindDirect("Img_SkillBg1")
        local skill2 = Group_Unlocked:FindDirect("Img_SkillBg2")
        local props = wingInfo.props
        local skills = wingInfo.skills
        if props then
          local prefix = skills and "" or "        "
          Label_Shuxing:SetActive(true)
          local propStr = WingUtils.PropsToString(wingInfo.id, props, prefix)
          if tryMode then
            Label_Shuxing:GetComponent("UILabel"):set_text("")
          else
            Label_Shuxing:GetComponent("UILabel"):set_text(propStr)
          end
        else
          Label_Shuxing:SetActive(false)
        end
        if tryMode then
          skill1:SetActive(false)
          skill2:SetActive(false)
          Group_Unlocked:FindDirect("Img_Line01"):SetActive(false)
          Group_Unlocked:FindDirect("Img_Line02"):SetActive(false)
        else
          if skills then
            local skillIcon
            if props then
              skill1:SetActive(false)
              skill2:SetActive(true)
              skillIcon = skill2
            else
              skill1:SetActive(true)
              skill2:SetActive(false)
              skillIcon = skill1
            end
            self:FillSkillIcon2(skillIcon, skills[1])
          else
            skill1:SetActive(false)
            skill2:SetActive(false)
          end
          Group_Unlocked:FindDirect("Img_Line01"):SetActive(true)
          Group_Unlocked:FindDirect("Img_Line02"):SetActive(true)
        end
        local reset0 = Group_Unlocked:FindDirect("Btn_Reset")
        local reset1 = Group_Unlocked:FindDirect("Btn_ResetProperty")
        local reset2 = Group_Unlocked:FindDirect("Btn_ResetSkill")
        local resetType = WingUtils.GetResetType(wingCfg)
        if resetType == 3 then
          reset0:SetActive(false)
          reset1:SetActive(true)
          reset2:SetActive(true)
        elseif resetType == 2 then
          reset0:SetActive(true)
          reset1:SetActive(false)
          reset2:SetActive(false)
        elseif resetType == 1 then
          reset0:SetActive(true)
          reset1:SetActive(false)
          reset2:SetActive(false)
        elseif resetType == 0 then
          reset0:SetActive(false)
          reset1:SetActive(false)
          reset2:SetActive(false)
        end
        if tryMode then
          reset0:SetActive(false)
          reset1:SetActive(false)
          reset2:SetActive(false)
        end
      else
        Group_Unlocked:SetActive(false)
        Label_Lock:SetActive(true)
        local unlockType = WingUtils.GetUnlockType(wingCfg)
        local text = textRes.Wing.UnlockDesc[unlockType]
        Label_Lock:GetComponent("UILabel"):set_text(text)
      end
    end
  else
    wingUI:SetActive(false)
  end
end
def.method().ShowCur = function(self)
  local wingData = WingModule.Instance():GetWingData()
  local wings_SJ = WingUtils.GetAllPromoteWingWithRank(wingData:GetPhase())
  local wings = WingUtils.GetAllOtherWing()
  local wings_WG = self:_filteOpenedWings(wings) or {}
  table.sort(wings_WG, function(a, b)
    if wingData:GetWingByWingId(a) and wingData:GetWingByWingId(b) then
      return a < b
    elseif wingData:GetWingByWingId(a) then
      return true
    elseif wingData:GetWingByWingId(b) then
      return false
    else
      return a < b
    end
  end)
  local flag = 0
  local wingindex = 0
  local index = 0
  for i = 1, #wings_SJ do
    if wings_SJ[i] == wingData:GetCurWingId() then
      self.wingId = wingData:GetCurWingId()
      wingindex = i
      flag = 1
      break
    end
  end
  for i = 1, #wings_WG do
    if wings_WG[i] == wingData:GetCurWingId() then
      self.wingId = wingData:GetCurWingId()
      wingindex = i
      flag = 2
      break
    end
  end
  local page = 0
  if self.gridShow then
    page = math.ceil(wingindex / DetailInfoNode.ONEPAGEGRID)
    index = wingindex - (page - 1) * DetailInfoNode.ONEPAGEGRID
  else
    page = math.ceil(wingindex / DetailInfoNode.ONEPAGE)
    index = wingindex - (page - 1) * DetailInfoNode.ONEPAGE
  end
  local nextType = 0
  if self.gridShow then
    if flag == 1 then
      nextType = WingOutlookType.TY_SJ
      self.wings = wings_SJ
      local Tab_SJ = self.m_node:FindDirect("Btn_Normal")
      Tab_SJ:GetComponent("UIToggle").value = true
      self:ShowRightAttr(wings_SJ[wingindex], self.TryMode)
      self.currentPageGrid = page
      local curWingData = {}
      local start = (self.currentPageGrid - 1) * DetailInfoNode.ONEPAGEGRID + 1
      for i = start, start + DetailInfoNode.ONEPAGEGRID - 1 do
        table.insert(curWingData, wings_SJ[i])
      end
      self:SetItemList(curWingData)
      local list = self.m_node:FindDirect("Group_EZMode/Group_Left/Group_List")
      for i = 1, DetailInfoNode.ONEPAGEGRID do
        local wingUI = list:FindDirect("Group_Item_" .. i)
        local wingId = curWingData[i] or 0
        if wingUI then
          self:FillWingLeft(wingUI, wingId, i)
        end
      end
    elseif flag == 2 then
      nextType = WingOutlookType.TY_WG
      self.wings = wings_WG
      local Tab_SP = self.m_node:FindDirect("Btn_Special")
      Tab_SP:GetComponent("UIToggle").value = true
      self:ShowRightAttr(wings_WG[wingindex], self.TryMode)
      self.currentPageGrid = page
      local curWingData = {}
      local start = (self.currentPageGrid - 1) * DetailInfoNode.ONEPAGEGRID + 1
      for i = start, start + DetailInfoNode.ONEPAGEGRID - 1 do
        table.insert(curWingData, wings_WG[i])
      end
      self:SetItemList(curWingData)
      local list = self.m_node:FindDirect("Group_EZMode/Group_Left/Group_List")
      for i = 1, DetailInfoNode.ONEPAGEGRID do
        local wingUI = list:FindDirect("Group_Item_" .. i)
        local wingId = curWingData[i] or 0
        if wingUI then
          self:FillWingLeft(wingUI, wingId, i)
        end
      end
    else
      Toast(textRes.Wing[62])
      return
    end
    self:UpdatePage()
    self:SelectTypeAndPage(nextType, page, false)
    local Img_Select = self.m_node:FindDirect(string.format("Group_EZMode/Group_Left/Group_List/Group_Item_%d/Img_Select", index))
    Img_Select:SetActive(true)
    local Img_BgBuyItem = self.m_node:FindDirect(string.format("Group_EZMode/Group_Left/Group_List/Group_Item_%d/Img_BgBuyItem", index))
    Img_BgBuyItem:GetComponent("UIToggle").value = true
  else
    if flag == 1 then
      nextType = WingOutlookType.TY_SJ
      self.wings = WingUtils.GetAllPromoteWingWithRank(wingData:GetPhase())
    elseif flag == 2 then
      nextType = WingOutlookType.TY_WG
      self.wings = self:_filteOpenedWings(wings) or {}
      table.sort(self.wings, function(a, b)
        if wingData:GetWingByWingId(a) and wingData:GetWingByWingId(b) then
          return a < b
        elseif wingData:GetWingByWingId(a) then
          return true
        elseif wingData:GetWingByWingId(b) then
          return false
        else
          return a < b
        end
      end)
    else
      Toast(textRes.Wing[62])
      return
    end
    self:UpdateTab()
    self:SelectTypeAndPage(nextType, page, false)
  end
end
def.method("userdata", "table", "number", "number").FillWingModel = function(self, uiModel, model, outlookId, wingDyeId)
  if uiModel == nil or model == nil then
    return
  end
  local uiModelCmp = uiModel:GetComponent("UIModel")
  if outlookId > 0 then
    model:Create(outlookId, wingDyeId, function()
      if uiModelCmp.isnil then
        return
      end
      uiModelCmp.mCanOverflow = true
      local camera = uiModelCmp:get_modelCamera()
      camera:set_orthographic(true)
      uiModelCmp.modelGameObject = model:GetModelGameObject()
    end)
  else
    model:Destroy()
  end
end
def.method("userdata", "number", "number").FillSkillIcon = function(self, uiGo, skillId, index)
  local tex = uiGo:FindDirect(string.format("Texture_%d", index))
  local skillCfg = skillId > 0 and SkillUtility.GetSkillCfg(skillId) or nil
  if skillCfg then
    tex:SetActive(true)
    local texCmp = tex:GetComponent("UITexture")
    GUIUtils.FillIcon(texCmp, skillCfg.iconId)
  else
    tex:SetActive(false)
  end
end
def.method("userdata", "number").FillSkillIcon2 = function(self, uiGo, skillId)
  local tex = uiGo:FindDirect("Texture")
  local skillCfg = skillId > 0 and SkillUtility.GetSkillCfg(skillId) or nil
  if skillCfg then
    tex:SetActive(true)
    local texCmp = tex:GetComponent("UITexture")
    GUIUtils.FillIcon(texCmp, skillCfg.iconId)
  else
    tex:SetActive(false)
  end
end
def.method().OnLabelPageClicked = function(self)
  local totalPage = math.ceil(#self.wings / DetailInfoNode.ONEPAGEGRID)
  if totalPage == 0 then
    return
  end
  local CommonDigitalKeyboard = require("GUI.CommonDigitalKeyboard")
  local val = 0
  CommonDigitalKeyboard.Instance():ShowPanel(function(key, tag)
    if self.uiObjs == nil then
      return
    end
    local getDisplayVal = function(val)
      local displayVal = val
      if displayVal <= 0 then
        displayVal = 1
      end
      return displayVal
    end
    local digital = tonumber(key)
    if digital then
      val = val * 10 + digital
      if val > totalPage then
        val = totalPage
        Toast(textRes.TradingArcade[2])
      end
      if val <= 0 then
        val = 1
      end
    elseif key == "DEL" then
      val = math.floor(val / 10)
    else
      local displayVal = getDisplayVal(val)
      self:SelectTypeAndPage(self.curType, displayVal, false)
    end
    local displayVal = getDisplayVal(val)
    local Label_Page = self.m_node:FindDirect("Group_EZMode/Group_Left/Group_Page/Img_BgPage/Label_Page")
    Label_Page:GetComponent("UILabel"):set_text(displayVal .. "/" .. totalPage)
  end, nil)
  CommonDigitalKeyboard.Instance():SetPos(0, 0)
end
def.override("userdata").onClickObj = function(self, clickobj)
  local id = clickobj.name
  if id == "Img_BgBuyItem" then
    local index = tonumber(string.sub(clickobj.parent.name, 12))
    local wingIndex = (self.currentPageGrid - 1) * DetailInfoNode.ONEPAGEGRID + index
    local wing = self.wings[wingIndex]
    local Tab_Select = self.m_node:FindDirect(string.format("Group_EZMode/Group_Left/Group_List/Group_Item_%d/Img_Select", index))
    if Tab_Select then
      Tab_Select:SetActive(true)
    end
    self.wingId = wing
    if wing then
      self:ShowRightAttr(wing, self.TryMode)
      self:UpdateWing()
    end
  elseif id == "Img_SkillBg1" or id == "Img_SkillBg2" then
    local wingId = self.wingId
    if wingId then
      local wing = WingModule.Instance():GetWingData():GetWingByWingId(wingId)
      local skillId = wing.skills and wing.skills[1] or 0
      if skillId > 0 then
        local cell = self.m_node:FindDirect("Group_EZMode/Group_Right/Group_Preview/wing/Group_Unlocked/" .. id)
        if cell then
          require("Main.Skill.SkillTipMgr").Instance():ShowTipByIdEx(skillId, cell, 0)
        end
      end
    end
  elseif id == "Btn_Color" then
    local wing = self.wingId
    if wing then
      WingModule.Instance():ShowDyeWingPanel(wing)
    end
  elseif id == "Btn_Dress" then
    local wing = self.wingId
    if wing then
      WingModule.Instance():ChangCurWing(wing)
    end
  elseif id == "Btn_Try" then
    local wing = self.wingId
    if wing then
      local wingViewCfg = WingUtils.GetWingOutlookCfgByWingId(wing)
      if wingViewCfg then
        local name = WingUtils.GetWingFakeItemByWingId(wing).name
        require("Main.Wing.ui.WingPanel").Instance():Show(false)
        require("Main.Item.ui.FittingRoomPanel").Instance():ShowWingsPanel(wingViewCfg.id, wingViewCfg.dyeId, name, function()
          require("Main.Wing.ui.WingPanel").Instance():Show(true)
        end)
      end
    end
  elseif id == "Btn_Undress" then
    local wing = self.wingId
    if wing then
      WingModule.Instance():ChangCurWing(0)
    end
  elseif id == "Btn_Reset" then
    local wing = self.wingId
    if wing then
      local wingCfg = WingUtils.GetWingCfg(wing)
      local type = WingUtils.GetResetType(wingCfg)
      if type == 1 then
        WingModule.Instance():ShowResetAttr(wing, false)
      elseif type == 2 then
        WingModule.Instance():ShowResetSkill(wing, false)
      end
    end
  elseif id == "Btn_ResetProperty" then
    local wing = self.wingId
    if wing then
      WingModule.Instance():ShowResetAttr(wing, false)
    end
  elseif id == "Btn_ResetSkill" then
    local wing = self.wingId
    if wing then
      WingModule.Instance():ShowResetSkill(wing, false)
    end
  elseif id == "Img_AttPre" then
    local wing = self.wingId
    if wing then
      WingUtils.ShowPropPreView(wing)
    end
  elseif id == "Img_SkillPre" then
    local wing = self.wingId
    if wing then
      local phase = WingUtils.WingIdToPhase(wing)
      if phase >= 0 then
        require("Main.Wing.ui.WingSkillGallery").ShowWingSkills(phase)
      else
        require("Main.Wing.ui.WingSkillGallery").ShowOneWingSkills(wing)
      end
    end
  end
end
def.override("string").onClick = function(self, id)
  if id == "Btn_Normal" then
    self:SelectTypeAndPage(WingOutlookType.TY_SJ, 1, false)
    if self.gridShow then
      self:UpdatePage()
    end
  elseif id == "Btn_Tips" then
    WingUtils.ShowQA(constant.WingConsts.OUT_LOOK_TIP_ID)
  elseif id == "Btn_Special" then
    self:SelectTypeAndPage(WingOutlookType.TY_WG, 1, false)
    if self.gridShow then
      self:UpdatePage()
    end
  elseif id == "Btn_Right" then
    if self.gridShow then
      self:SelectTypeAndPage(self.curType, self.currentPageGrid + 1, false)
    else
      self:SelectTypeAndPage(self.curType, self.currentPage + 1, false)
    end
    if self.gridShow then
      self:UpdatePage()
    end
  elseif id == "Btn_Left" then
    if self.gridShow then
      self:SelectTypeAndPage(self.curType, self.currentPageGrid - 1, false)
    else
      self:SelectTypeAndPage(self.curType, self.currentPage - 1, false)
    end
    if self.gridShow then
      self:UpdatePage()
    end
  elseif id == "Label_Page" then
    self:OnLabelPageClicked()
  elseif id == "Img_ChangeMode" then
    self.currentPage = 1
    self.currentPageGrid = 1
    self.gridShow = not self.gridShow
    self:ChangeMode()
    self:ShowCur()
  elseif id == "Btn_Back" then
    if 1 < self.currentPageGrid then
      self:SelectTypeAndPage(self.curType, self.currentPageGrid - 1, false)
      self:UpdatePage()
    end
  elseif id == "Btn_Next" then
    local pageCount = math.ceil(#self.wings / DetailInfoNode.ONEPAGEGRID)
    if pageCount > self.currentPageGrid then
      self:SelectTypeAndPage(self.curType, self.currentPageGrid + 1, false)
      self:UpdatePage()
    end
  elseif id == "Btn_TryMode" then
    self.TryMode = not self.TryMode
    self:ChangeTryMode()
  elseif string.sub(id, 1, 10) == "Btn_Reset_" then
    local index = tonumber(string.sub(id, 11))
    local wingIndex = (self.currentPage - 1) * DetailInfoNode.ONEPAGE + index
    local wing = self.wings[wingIndex]
    if wing then
      local wingCfg = WingUtils.GetWingCfg(wing)
      local type = WingUtils.GetResetType(wingCfg)
      if type == 1 then
        WingModule.Instance():ShowResetAttr(wing, false)
      elseif type == 2 then
        WingModule.Instance():ShowResetSkill(wing, false)
      end
    end
  elseif string.sub(id, 1, 18) == "Btn_ResetProperty_" then
    local index = tonumber(string.sub(id, 19))
    local wingIndex = (self.currentPage - 1) * DetailInfoNode.ONEPAGE + index
    local wing = self.wings[wingIndex]
    if wing then
      WingModule.Instance():ShowResetAttr(wing, false)
    end
  elseif string.sub(id, 1, 15) == "Btn_ResetSkill_" then
    local index = tonumber(string.sub(id, 16))
    local wingIndex = (self.currentPage - 1) * DetailInfoNode.ONEPAGE + index
    local wing = self.wings[wingIndex]
    warn("Btn_ResetSkill_", wingIndex, wing)
    if wing then
      WingModule.Instance():ShowResetSkill(wing, false)
    end
  elseif string.sub(id, 1, 10) == "Btn_Color_" then
    local index = tonumber(string.sub(id, 11))
    local wingIndex = (self.currentPage - 1) * DetailInfoNode.ONEPAGE + index
    local wing = self.wings[wingIndex]
    if wing then
      WingModule.Instance():ShowDyeWingPanel(wing)
    end
  elseif string.sub(id, 1, 10) == "Btn_Dress_" then
    local index = tonumber(string.sub(id, 11))
    local wingIndex = (self.currentPage - 1) * DetailInfoNode.ONEPAGE + index
    local wing = self.wings[wingIndex]
    if wing then
      WingModule.Instance():ChangCurWing(wing)
    end
  elseif string.sub(id, 1, 8) == "Btn_Try_" then
    local index = tonumber(string.sub(id, 9))
    local wingIndex = (self.currentPage - 1) * DetailInfoNode.ONEPAGE + index
    local wing = self.wings[wingIndex]
    if wing then
      local wingViewCfg = WingUtils.GetWingOutlookCfgByWingId(wing)
      if wingViewCfg then
        local name = WingUtils.GetWingFakeItemByWingId(wing).name
        require("Main.Wing.ui.WingPanel").Instance():Show(false)
        require("Main.Item.ui.FittingRoomPanel").Instance():ShowWingsPanel(wingViewCfg.id, wingViewCfg.dyeId, name, function()
          require("Main.Wing.ui.WingPanel").Instance():Show(true)
        end)
      end
    end
  elseif string.sub(id, 1, 11) == "Img_AttPre_" then
    local index = tonumber(string.sub(id, 12))
    local wingIndex = (self.currentPage - 1) * DetailInfoNode.ONEPAGE + index
    local wing = self.wings[wingIndex]
    if wing then
      WingUtils.ShowPropPreView(wing)
    end
  elseif string.sub(id, 1, 13) == "Img_SkillPre_" then
    local index = tonumber(string.sub(id, 14))
    local wingIndex = (self.currentPage - 1) * DetailInfoNode.ONEPAGE + index
    local wing = self.wings[wingIndex]
    if wing then
      local phase = WingUtils.WingIdToPhase(wing)
      if phase >= 0 then
        require("Main.Wing.ui.WingSkillGallery").ShowWingSkills(phase)
      else
        require("Main.Wing.ui.WingSkillGallery").ShowOneWingSkills(wing)
      end
    end
  elseif string.sub(id, 1, 12) == "Btn_Undress_" then
    local index = tonumber(string.sub(id, 13))
    local wingIndex = (self.currentPage - 1) * DetailInfoNode.ONEPAGE + index
    local wing = self.wings[wingIndex]
    if wing then
      WingModule.Instance():ChangCurWing(0)
    end
  elseif string.sub(id, 1, 13) == "Img_SkillBg1_" or string.sub(id, 1, 13) == "Img_SkillBg2_" then
    local index = tonumber(string.sub(id, 14))
    local wingIndex = (self.currentPage - 1) * DetailInfoNode.ONEPAGE + index
    local wingId = self.wings[wingIndex]
    if wingId then
      local wing = WingModule.Instance():GetWingData():GetWingByWingId(wingId)
      local skillId = wing.skills and wing.skills[1] or 0
      if skillId > 0 then
        local cell = self.m_node:FindDirect(string.format("Scroll View/List/wing_%d/Group_Unlocked_%d/%s", index, index, id))
        if cell then
          require("Main.Skill.SkillTipMgr").Instance():ShowTipByIdEx(skillId, cell, 0)
        end
      end
    end
  elseif id == "Btn_Cur" then
    self:ShowCur()
  end
end
def.override("string").onDragStart = function(self, id)
  if string.sub(id, 1, 11) == "Model_Wing_" then
    self.dragIndex = tonumber(string.sub(id, 12))
  end
end
def.override("string").onDragEnd = function(self, id)
  self.dragIndex = 0
end
def.override("string", "number", "number").onDrag = function(self, id, dx, dy)
  if self.dragIndex > 0 then
    local wingModel = self.models[self.dragIndex]
    wingModel:SetDir(wingModel:GetDir() - dx / 2)
  end
  if id == "Model_Wing" then
    if self.role_model ~= nil and self.role_model.m_model ~= nil then
      self.role_model:SetDir(self.role_model.m_ang - dx / 2)
    end
    if self.right_model ~= nil then
      self.right_model:SetDir(self.right_model:GetDir() - dx / 2)
    end
  end
end
def.method("table").OnIDIPInfoChg = function(self, p)
  if ItemSwitchInfo.WING == p.type then
    self:OnPhaseChange(nil)
    self:UpdateArrowAndPoint()
    self:UpdateWing()
  end
end
DetailInfoNode.Commit()
return DetailInfoNode

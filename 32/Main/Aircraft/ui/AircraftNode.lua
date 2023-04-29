local Lplus = require("Lplus")
local TabNode = require("GUI.TabNode")
local ECPanelBase = require("GUI.ECPanelBase")
local GUIUtils = require("GUI.GUIUtils")
local ECUIModel = require("Model.ECUIModel")
local AircraftData = require("Main.Aircraft.data.AircraftData")
local AircraftUIModel = require("Main.Aircraft.ui.AircraftUIModel")
local AircraftUtils = require("Main.Aircraft.AircraftUtils")
local ItemUtils = require("Main.Item.ItemUtils")
local AircraftProtocols = require("Main.Aircraft.AircraftProtocols")
local Vector3 = require("Types.Vector").Vector3
local TipsHelper = require("Main.Common.TipsHelper")
local LuaPlayerPrefs = require("Main.Common.LuaPlayerPrefs")
local AircraftNode = Lplus.Extend(TabNode, "AircraftNode")
local def = AircraftNode.define
def.const("number").COUNT_PER_PAGE = 3
def.const("number").UI_MODEL_MOUNT_Y = 75
def.const("number").UI_MODEL_DISMOUNT_Y = 125
def.field("table")._uiObjs = nil
def.field("table")._aircraftCfgList = nil
def.field("number")._pageCount = 0
def.field("number")._curPage = 0
def.field("number")._curMountIdx = 0
def.field("table")._modelList = nil
def.field(ECUIModel)._heroModel = nil
def.field("boolean")._isDrag = false
def.field(ECUIModel)._dragModel = nil
def.const("table").ShowType = {Flip = 1, Grid = 2}
def.field("number")._showType = 1
def.const("number").GRID_PER_PAGE = 8
def.field(ECUIModel)._gridModel = nil
def.field("number")._gridPage = 1
def.field("number")._gridPageCount = 1
def.field("number")._selectAircraft = 0
def.override(ECPanelBase, "userdata").Init = function(self, base, node)
  TabNode.Init(self, base, node)
  if LuaPlayerPrefs.HasGlobalKey("aircraft_show_type") then
    self._showType = LuaPlayerPrefs.GetGlobalInt("aircraft_show_type")
  end
end
def.method("=>", "boolean").IsShow = function(self)
  return self.isShow
end
def.override().OnShow = function(self)
  self:HandleEventListeners(true)
  self:InitUI()
  self:InitData()
  if self._showType == AircraftNode.ShowType.Flip then
    self._uiObjs.FlipStyle:SetActive(true)
    self._uiObjs.GridStyle:SetActive(false)
    local initPage, select = self:_GetInitPage()
    self._curMountIdx = select
    self:ShowPagePoints()
    self:ShowAircraftPage(initPage, true)
  elseif self._showType == AircraftNode.ShowType.Grid then
    self._uiObjs.FlipStyle:SetActive(false)
    self._uiObjs.GridStyle:SetActive(true)
    local initPage, select = self:_GetInitPage()
    self._selectAircraft = select > 0 and select or 1
    self._curMountIdx = self._selectAircraft
    self:ShowAircraftPage(initPage, true)
    self:ShowSelectAircraft()
  end
  self:UpdateCurrentAircraft()
  self:UpdateShowTypeBtn()
  self:UpdateAircraftAttrReddot()
  require("Main.Aircraft.AircraftModule").Instance():SetReddot(false)
end
def.method("number").SwitchViewType = function(self, showType)
  if self._showType == showType then
    return
  end
  self._showType = showType
  self:UpdateShowTypeBtn()
  if self._showType == AircraftNode.ShowType.Flip then
    self._uiObjs.FlipStyle:SetActive(true)
    self._uiObjs.GridStyle:SetActive(false)
    local initPage, select = self:_GetInitPage()
    self._curMountIdx = select
    if self._gridModel then
      self._gridModel:DetachRole()
      self._gridModel:Destroy()
      self._gridModel = nil
    end
    self:ShowPagePoints()
    self:ShowAircraftPage(initPage, true)
  elseif self._showType == AircraftNode.ShowType.Grid then
    self._uiObjs.FlipStyle:SetActive(false)
    self._uiObjs.GridStyle:SetActive(true)
    local initPage, select = self:_GetInitPage()
    self._selectAircraft = select > 0 and select or 1
    self._curMountIdx = self._selectAircraft
    self:_ClearPage()
    self:ShowAircraftPage(initPage, true)
    self:ShowSelectAircraft()
  end
end
def.method("=>", "number", "number")._GetInitPage = function(self)
  local cfgId = self.m_base:GetInitCfgId()
  if cfgId <= 0 then
    cfgId = AircraftData.Instance():GetCurrentAircraftId()
  end
  local initPage = self:_GetAircraftPage(cfgId)
  local index = self:_GetAircraftIdx(cfgId)
  return initPage, index
end
def.override().OnHide = function(self)
  self:HandleEventListeners(false)
  self._uiObjs = nil
  self._aircraftCfgList = nil
  self._isDrag = false
  self._dragModel = nil
  self:_ClearPage()
  if self._gridModel then
    self._gridModel:DetachRole()
    self._gridModel:Destroy()
    self._gridModel = nil
  end
  if not _G.IsNil(self._heroModel) then
    self._heroModel:Destroy()
    self._heroModel = nil
  end
  LuaPlayerPrefs.SetGlobalInt("aircraft_show_type", self._showType)
end
def.method().InitUI = function(self)
  self._uiObjs = {}
  self._uiObjs.Label_CurAircraft = self.m_node:FindDirect("Img_Bg/Group_CurFly/Label_CurItem")
  self._uiObjs.ImgCurAircraft = self.m_node:FindDirect("Img_Bg/Group_CurFly/Label_CurItem/Img_Here")
  self._uiObjs.Scroll_View = self.m_node:FindDirect("Img_Bg/Group_Item/Scroll View")
  self._uiObjs.uiScrollView = self._uiObjs.Scroll_View:GetComponent("UIScrollView")
  self._uiObjs.List = self._uiObjs.Scroll_View:FindDirect("List")
  self._uiObjs.uiList = self._uiObjs.List:GetComponent("UIList")
  self._uiObjs.List_Point = self.m_node:FindDirect("Img_Bg/Group_Item/List_Point")
  self._uiObjs.uiListPoint = self._uiObjs.List_Point:GetComponent("UIList")
  self._uiObjs.Btn_Left = self.m_node:FindDirect("Img_Bg/Group_Item/Btn_Left")
  self._uiObjs.Btn_Right = self.m_node:FindDirect("Img_Bg/Group_Item/Btn_Right")
  self._uiObjs.Btn_Effect = self.m_node:FindDirect("Img_Bg/Btn_Effect")
  self._uiObjs.Img_Red_Effect = self._uiObjs.Btn_Effect:FindDirect("Img_Red")
  self._uiObjs.FlipStyle = self.m_node:FindDirect("Img_Bg/Group_Item")
  self._uiObjs.GridStyle = self.m_node:FindDirect("Img_Bg/Group_ItemMode")
  self._uiObjs.SwitchBtn = self.m_node:FindDirect("Img_Bg/Btn_ChangeMode")
  self._uiObjs.SwitchBtnFlip = self._uiObjs.SwitchBtn:FindDirect("Img_List")
  self._uiObjs.SwitchBtnGrid = self._uiObjs.SwitchBtn:FindDirect("Img_Grid")
  self._uiObjs.ItemList = self._uiObjs.GridStyle:FindDirect("Group_Left/Group_List")
  self._uiObjs.PageNumber = self._uiObjs.GridStyle:FindDirect("Group_Left/Group_Page/Img_BgPage/Label_Page")
  self._uiObjs.Preview = self._uiObjs.GridStyle:FindDirect("Group_Right/Group_Preview")
  self._uiObjs.SingleModel = self._uiObjs.Preview:FindDirect("Model_Fly0")
end
def.method().InitData = function(self)
  self._aircraftCfgList = AircraftData.Instance():GetSortedAircraftCfgs()
  local count = self:_GetAircraftCount()
  self._pageCount = math.ceil(count / AircraftNode.COUNT_PER_PAGE)
  self._gridPageCount = math.ceil(count / AircraftNode.GRID_PER_PAGE)
end
def.method().UpdateShowTypeBtn = function(self)
  if self._showType == AircraftNode.ShowType.Flip then
    self._uiObjs.SwitchBtnFlip:SetActive(true)
    self._uiObjs.SwitchBtnGrid:SetActive(false)
  elseif self._showType == AircraftNode.ShowType.Grid then
    self._uiObjs.SwitchBtnFlip:SetActive(false)
    self._uiObjs.SwitchBtnGrid:SetActive(true)
  else
    self._uiObjs.SwitchBtn:SetActive(false)
  end
end
def.method("=>", "number")._GetAircraftCount = function(self)
  return self._aircraftCfgList and #self._aircraftCfgList or 0
end
def.method("number", "=>", "number")._GetAircraftPage = function(self, aircraftId)
  local idx = self:_GetAircraftIdx(aircraftId)
  local result = 1
  if idx > 0 then
    if self._showType == AircraftNode.ShowType.Flip then
      result = math.ceil(idx / AircraftNode.COUNT_PER_PAGE)
    elseif self._showType == AircraftNode.ShowType.Grid then
      result = math.ceil(idx / AircraftNode.GRID_PER_PAGE)
    end
  end
  return result
end
def.method("number", "=>", "number")._GetAircraftIdx = function(self, aircraftId)
  local result = 0
  if 0 < self:_GetAircraftCount() and aircraftId > 0 then
    for idx, aircraftCfg in ipairs(self._aircraftCfgList) do
      if aircraftCfg.id == aircraftId then
        result = idx
        break
      end
    end
  end
  return result
end
def.method().UpdateCurrentAircraft = function(self)
  local curAircraftId = AircraftData.Instance():GetCurrentAircraftId()
  local aircraftCfg = AircraftData.Instance():GetAircraftCfg(curAircraftId)
  if aircraftCfg then
    GUIUtils.SetText(self._uiObjs.Label_CurAircraft, aircraftCfg.name)
    GUIUtils.SetActive(self._uiObjs.ImgCurAircraft, true)
  else
    GUIUtils.SetText(self._uiObjs.Label_CurAircraft, textRes.Aircraft.CURRENT_AIRCRAFT_NONE)
    GUIUtils.SetActive(self._uiObjs.ImgCurAircraft, false)
  end
end
def.method().UpdateAircraftAttrReddot = function(self)
  GUIUtils.SetActive(self._uiObjs.Btn_Effect, false)
end
def.method().ShowPagePoints = function(self)
  self._uiObjs.uiListPoint.itemCount = self._pageCount
  self._uiObjs.uiListPoint:Resize()
  self._uiObjs.uiListPoint:Reposition()
  if self._pageCount > 1 then
    GUIUtils.SetActive(self._uiObjs.Btn_Left, true)
    GUIUtils.SetActive(self._uiObjs.Btn_Right, true)
  else
    GUIUtils.SetActive(self._uiObjs.Btn_Left, false)
    GUIUtils.SetActive(self._uiObjs.Btn_Right, false)
  end
end
def.method("number", "boolean").ShowAircraftPage = function(self, page, bForce)
  if self._showType == AircraftNode.ShowType.Flip then
    if not bForce and page == self._curPage then
      return
    end
    if page <= 0 or page > self._pageCount then
      warn("[ERROR][AircraftNode:ShowAircraftPage] invalid page:", page, self._pageCount)
      return
    end
    if page == 1 then
      GUIUtils.SetActive(self._uiObjs.Btn_Left, false)
    else
      GUIUtils.SetActive(self._uiObjs.Btn_Left, true)
    end
    if page == self._pageCount then
      GUIUtils.SetActive(self._uiObjs.Btn_Right, false)
    else
      GUIUtils.SetActive(self._uiObjs.Btn_Right, true)
    end
    self:_ClearPage()
    self._curPage = page
    local pointListItem = self._uiObjs.uiListPoint.children[page]
    if pointListItem then
      GUIUtils.Toggle(pointListItem, true)
    else
      warn("[ERROR][AircraftNode:ShowAircraftPage] pointListItem nil at page:", page)
    end
    local startIdx = (page - 1) * AircraftNode.COUNT_PER_PAGE + 1
    local endIdx = math.min(self:_GetAircraftCount(), page * AircraftNode.COUNT_PER_PAGE)
    if startIdx <= endIdx then
      self._uiObjs.uiList.itemCount = endIdx - startIdx + 1
      self._uiObjs.uiList:Resize()
      self._uiObjs.uiList:Reposition()
      for idx = startIdx, endIdx do
        local aircraftCfg = self._aircraftCfgList[idx]
        self:ShowAircraft(idx, aircraftCfg)
      end
    else
      warn("[ERROR][AircraftNode:ShowAircraftPage] show fail, startIdx, endIdx:", startIdx, endIdx)
    end
  elseif self._showType == AircraftNode.ShowType.Grid then
    if not bForce and page == self._gridPage then
      return
    end
    if page <= 0 or page > self._gridPageCount then
      warn("[ERROR][AircraftNode:ShowAircraftPage] invalid page:", page, self._gridPageCount)
      return
    end
    self._gridPage = page
    self._uiObjs.PageNumber:GetComponent("UILabel"):set_text(string.format("%d/%d", self._gridPage, self._gridPageCount))
    local startIdx = (page - 1) * AircraftNode.GRID_PER_PAGE + 1
    local endIdx = math.min(self:_GetAircraftCount(), page * AircraftNode.GRID_PER_PAGE)
    local count = endIdx - startIdx + 1
    local listCmp = self._uiObjs.ItemList:GetComponent("UIList")
    listCmp:set_itemCount(count)
    listCmp:Resize()
    local items = listCmp:get_children()
    for i = 1, count do
      local idx = startIdx + i - 1
      local aircraftCfg = self._aircraftCfgList[idx]
      self:FillAircraftItem(aircraftCfg, items[i], idx)
      self.m_base.m_msgHandler:Touch(items[i])
    end
  end
end
def.method("table", "userdata", "number").FillAircraftItem = function(self, aircraftCfg, uiGo, idx)
  uiGo:GetComponent("UIToggle"):set_value(idx == self._selectAircraft)
  uiGo:FindDirect("Label_Name"):GetComponent("UILabel"):set_text(aircraftCfg.name)
  local bCurrent = AircraftData.Instance():IsCurrentAircraft(aircraftCfg.id)
  local bHave = AircraftData.Instance():HaveAircraft(aircraftCfg.id)
  if bCurrent then
    uiGo:FindDirect("Label_Have"):GetComponent("UILabel"):set_text(textRes.Aircraft.AIRCRAFT_USE)
  elseif bHave then
    uiGo:FindDirect("Label_Have"):GetComponent("UILabel"):set_text(textRes.Aircraft.AIRCRAFT_HAVE)
  else
    local tipContent = TipsHelper.GetHoverTip(aircraftCfg.sourceTipId)
    uiGo:FindDirect("Label_Have"):GetComponent("UILabel"):set_text("[ff0000]" .. tipContent)
  end
  local tagName = self:GetAircraftSmallTag(aircraftCfg)
  local tag = uiGo:FindDirect("Img_Tag")
  if tagName ~= "" then
    tag:SetActive(true)
    tag:GetComponent("UISprite"):set_spriteName(tagName)
  else
    tag:SetActive(false)
  end
  local itemBase = ItemUtils.GetItemBase(aircraftCfg.itemId)
  local frame = uiGo:FindDirect("Img_BgItem")
  local tex = frame:FindDirect("Texture_Icon")
  frame:GetComponent("UISprite"):set_spriteName(string.format("Cell_%02d", itemBase.namecolor))
  GUIUtils.FillIcon(tex:GetComponent("UITexture"), itemBase.icon)
end
def.method("number", "table").ShowAircraft = function(self, cfgIdx, aircraftCfg)
  local listIdx = self:GetListIdx(cfgIdx)
  local listItem = self._uiObjs.uiList.children[listIdx]
  if nil == listItem then
    warn("[ERROR][AircraftNode:ShowAircraft] listItem nil at cfgIdx:", cfgIdx)
    return
  end
  if nil == aircraftCfg then
    warn("[ERROR][AircraftNode:ShowAircraft] aircraftCfg nil at cfgIdx:", cfgIdx)
    return
  end
  local Label_Name = listItem:FindDirect("Label_Name")
  GUIUtils.SetText(Label_Name, aircraftCfg.name)
  local Model = listItem:FindDirect("Model_Fly")
  Model.name = "Model_Fly" .. cfgIdx
  local oldPos = Model.localPosition
  local newPos = Vector3.new(oldPos.x, AircraftNode.UI_MODEL_DISMOUNT_Y, oldPos.z)
  Model.localPosition = newPos
  local uiModel = Model and Model:GetComponent("UIModel")
  self:FillAircraftModel(cfgIdx, aircraftCfg, uiModel)
  self:UpdateAircraftState(cfgIdx, aircraftCfg)
end
def.method("number", "table").UpdateAircraftState = function(self, cfgIdx, aircraftCfg)
  local listIdx = self:GetListIdx(cfgIdx)
  local listItem = self._uiObjs.uiList.children[listIdx]
  if nil == listItem then
    warn("[ERROR][AircraftNode:ShowAircraft] listItem nil at cfgIdx:", cfgIdx)
    return
  end
  if nil == aircraftCfg then
    warn("[ERROR][AircraftNode:ShowAircraft] aircraftCfg nil at cfgIdx:", cfgIdx)
    return
  end
  local bCurrent = AircraftData.Instance():IsCurrentAircraft(aircraftCfg.id)
  local bHave = AircraftData.Instance():HaveAircraft(aircraftCfg.id)
  local Label_Get = listItem:FindDirect("Label_Get")
  if bHave then
    GUIUtils.SetActive(Label_Get, false)
  else
    GUIUtils.SetActive(Label_Get, true)
    local tipContent = TipsHelper.GetHoverTip(aircraftCfg.sourceTipId)
    GUIUtils.SetText(Label_Get, tipContent or "")
  end
  local Img_Tag = listItem:FindDirect("Img_Tag")
  if self:IsMultiAircraftOpen() then
    Img_Tag:SetActive(true)
    Img_Tag:GetComponent("UISprite"):set_spriteName(self:GetAircraftTag(aircraftCfg))
  else
    Img_Tag:SetActive(false)
  end
  local Group_Unlocked = listItem:FindDirect("Group_Unlocked")
  local Group_locked = listItem:FindDirect("Group_locked")
  local Btn_Color = listItem:FindDirect("Btn_Color")
  local Btn_Undress = listItem:FindDirect("Btn_Undress")
  local Btn_Dress = listItem:FindDirect("Btn_Dress")
  local Btn_Try = listItem:FindDirect("Btn_Try")
  local Btn_Mapping = listItem:FindDirect("Btn_Mapping")
  if bHave then
    GUIUtils.SetActive(Group_Unlocked, true)
    GUIUtils.SetActive(Group_locked, false)
    GUIUtils.SetActive(Btn_Try, false)
    GUIUtils.SetActive(Btn_Color, true)
    local isBtn_MappingValid = false
    Btn_Mapping:SetActive(isBtn_MappingValid)
    local Label_Shuxing = Group_Unlocked:FindDirect("Label_Shuxing")
    local attrStr = AircraftUtils.GetAircraftAttrString(aircraftCfg)
    if aircraftCfg.props == nil or #aircraftCfg.props == 0 then
      attrStr = textRes.Aircraft.AIRCRAFT_ATTR_TITLE .. "\n" .. attrStr
    end
    GUIUtils.SetText(Label_Shuxing, attrStr)
    if bCurrent then
      GUIUtils.SetActive(Btn_Dress, false)
      GUIUtils.SetActive(Btn_Undress, true)
    else
      GUIUtils.SetActive(Btn_Undress, false)
      GUIUtils.SetActive(Btn_Dress, true)
    end
  else
    GUIUtils.SetActive(Group_Unlocked, false)
    GUIUtils.SetActive(Group_locked, true)
    GUIUtils.SetActive(Btn_Try, true)
    GUIUtils.SetActive(Btn_Color, false)
    GUIUtils.SetActive(Btn_Undress, false)
    GUIUtils.SetActive(Btn_Dress, false)
    Btn_Mapping:SetActive(false)
  end
  local Img_Dressed = listItem:FindDirect("Img_Dressed")
  GUIUtils.SetActive(Img_Dressed, bCurrent)
end
def.method().ShowSelectAircraft = function(self)
  if self._gridModel then
    self._gridModel:DetachRole()
    self._gridModel:Destroy()
    self._gridModel = nil
  end
  local aircraftCfg = self._aircraftCfgList[self._selectAircraft]
  local Label_Name = self._uiObjs.Preview:FindDirect("Label_Name")
  GUIUtils.SetText(Label_Name, aircraftCfg.name)
  local Model = self._uiObjs.SingleModel
  local oldPos = Model.localPosition
  local newPos = Vector3.new(oldPos.x, AircraftNode.UI_MODEL_DISMOUNT_Y, oldPos.z)
  Model.localPosition = newPos
  local uiModel = Model:GetComponent("UIModel")
  local colorId = AircraftData.Instance():GetAircraftColor(aircraftCfg.id)
  local aircraftModel = AircraftUIModel.new(aircraftCfg.id, colorId, uiModel)
  self._gridModel = aircraftModel
  aircraftModel:LoadWithCB(function(model)
    if _G.IsNil(model) then
      return
    end
    if not self.isShow or _G.IsNil(self.m_panel) or _G.IsNil(self.m_node) or _G.IsNil(uiModel) then
      aircraftModel:Destroy()
      return
    end
    if self._curMountIdx == self._selectAircraft then
      self:SetMountAircraft(self._selectAircraft, true)
    end
  end)
  self:UpdateSelectAircraftState(aircraftCfg)
end
def.method("table").UpdateSelectAircraftState = function(self, aircraftCfg)
  local listItem = self._uiObjs.Preview
  local bCurrent = AircraftData.Instance():IsCurrentAircraft(aircraftCfg.id)
  local bHave = AircraftData.Instance():HaveAircraft(aircraftCfg.id)
  local Label_Get = listItem:FindDirect("Label_Get")
  if bHave then
    GUIUtils.SetActive(Label_Get, false)
  else
    GUIUtils.SetActive(Label_Get, true)
    local tipContent = TipsHelper.GetHoverTip(aircraftCfg.sourceTipId)
    GUIUtils.SetText(Label_Get, tipContent or "")
  end
  local Img_Tag = listItem:FindDirect("Img_Tag")
  if self:IsMultiAircraftOpen() then
    Img_Tag:GetComponent("UISprite"):set_spriteName(self:GetAircraftTag(aircraftCfg))
  else
    Img_Tag:SetActive(false)
  end
  local Group_Unlocked = listItem:FindDirect("Group_Unlocked")
  local Group_locked = listItem:FindDirect("Group_locked")
  local Btn_Color = listItem:FindDirect("Btn_Color")
  local Btn_Undress = listItem:FindDirect("Btn_Undress")
  local Btn_Dress = listItem:FindDirect("Btn_Dress")
  local Btn_Try = listItem:FindDirect("Btn_Try")
  local Btn_Mapping = listItem:FindDirect("Btn_Mapping")
  if bHave then
    GUIUtils.SetActive(Group_Unlocked, true)
    GUIUtils.SetActive(Group_locked, false)
    GUIUtils.SetActive(Btn_Try, false)
    GUIUtils.SetActive(Btn_Color, true)
    local isBtn_MappingValid = false
    Btn_Mapping:SetActive(isBtn_MappingValid)
    local Label_Shuxing = Group_Unlocked:FindDirect("Label_Shuxing")
    local attrStr = AircraftUtils.GetAircraftAttrString(aircraftCfg)
    if aircraftCfg.props == nil or #aircraftCfg.props == 0 then
      attrStr = textRes.Aircraft.AIRCRAFT_ATTR_TITLE .. "\n" .. attrStr
    end
    GUIUtils.SetText(Label_Shuxing, attrStr)
    if bCurrent then
      GUIUtils.SetActive(Btn_Dress, false)
      GUIUtils.SetActive(Btn_Undress, true)
    else
      GUIUtils.SetActive(Btn_Undress, false)
      GUIUtils.SetActive(Btn_Dress, true)
    end
  else
    GUIUtils.SetActive(Group_Unlocked, false)
    GUIUtils.SetActive(Group_locked, true)
    GUIUtils.SetActive(Btn_Try, true)
    GUIUtils.SetActive(Btn_Color, false)
    GUIUtils.SetActive(Btn_Undress, false)
    GUIUtils.SetActive(Btn_Dress, false)
    Btn_Mapping:SetActive(false)
  end
  local Img_Dressed = listItem:FindDirect("Img_Dressed")
  GUIUtils.SetActive(Img_Dressed, bCurrent)
end
def.method("number", "=>", "number").GetListIdx = function(self, cfgIdx)
  local listIdx = cfgIdx - (self._curPage - 1) * AircraftNode.COUNT_PER_PAGE
  return listIdx
end
def.method("number", "=>", "number").GetCfgIdx = function(self, listIdx)
  local cfgIdx = listIdx + (self._curPage - 1) * AircraftNode.COUNT_PER_PAGE
  return cfgIdx
end
def.method()._ClearPage = function(self)
  if self._modelList then
    for _, model in pairs(self._modelList) do
      if not _G.IsNil(model) then
        model:DetachRole()
        model:Destroy()
      end
    end
    self._modelList = nil
  end
  if not _G.IsNil(self._uiObjs) and not _G.IsNil(self._uiObjs.uiList) then
    self._uiObjs.uiList.itemCount = 0
    self._uiObjs.uiList:Resize()
    self._uiObjs.uiList:Reposition()
  end
end
def.method("number", "table", "userdata").FillAircraftModel = function(self, idx, aircraftCfg, uiModel)
  if _G.IsNil(uiModel) then
    warn("[ERROR][AircraftNode:FillAircraftModel] uiModel nil at idx:", idx)
    return
  end
  if nil == self._modelList then
    self._modelList = {}
  end
  local colorId = AircraftData.Instance():GetAircraftColor(aircraftCfg.id)
  local aircraftModel = AircraftUIModel.new(aircraftCfg.id, colorId, uiModel)
  self._modelList[idx] = aircraftModel
  aircraftModel:LoadWithCB(function(model)
    if _G.IsNil(model) then
      return
    end
    if not self.isShow or _G.IsNil(self.m_panel) or _G.IsNil(self.m_node) or _G.IsNil(uiModel) then
      aircraftModel:Destroy()
      return
    end
    if self._curMountIdx == idx then
      self:SetMountAircraft(idx, true)
    end
  end)
end
def.method().LoadHeroModel = function(self)
  local heroProp = require("Main.Hero.Interface").GetHeroProp()
  if heroProp == nil then
    return
  end
  local modelId = gmodule.moduleMgr:GetModule(ModuleId.HERO):GetMyModelId()
  self._heroModel = ECUIModel.new(modelId)
  self._heroModel.m_bUncache = true
  local modelInfo = gmodule.moduleMgr:GetModule(ModuleId.PUBROLE):GetRoleModelInfo(gmodule.moduleMgr:GetModule(ModuleId.HERO).roleId)
  if modelInfo then
    local ModelInfo = require("netio.protocol.mzm.gsp.pubdata.ModelInfo")
    modelInfo.extraMap[ModelInfo.MAGIC_MARK] = nil
    self._heroModel:AddOnLoadCallback("AircraftNode", function()
      if not self.isShow or _G.IsNil(self.m_panel) or _G.IsNil(self.m_node) then
        self._heroModel:Destroy()
        self._heroModel = nil
        return
      end
      if _G.IsNil(self._heroModel) or _G.IsNil(self._heroModel.m_model) then
        return
      end
      if self._curMountIdx > 0 then
        self:SetMountAircraft(self._curMountIdx, true)
      end
    end)
    _G.LoadModel(self._heroModel, modelInfo, 0, 0, 180, false, false)
  else
    warn("[ERROR][AircraftNode:LoadHeroModel] modelInfo FOR HERO!")
  end
end
def.method("=>", ECUIModel).GetMountAircraftModel = function(self)
  local result
  if self._modelList and self._curMountIdx > 0 then
    result = self._modelList[self._curMountIdx]
  end
  return result
end
def.method(ECUIModel, "=>", "boolean").IsModelLoaded = function(self, ecUIModel)
  if not _G.IsNil(ecUIModel) and not ecUIModel:IsInLoading() then
    return true
  else
    return false
  end
end
def.method("number", "boolean").SetMountAircraft = function(self, aircraftIdx, bForce)
  if self._curMountIdx == aircraftIdx and not bForce then
    warn("[WARN][AircraftNode:SetMountAircraft] already mount on aircraftIdx:", aircraftIdx)
    return
  end
  if self._curMountIdx > 0 then
    self:DoAttachDetach(self._curMountIdx, false)
  end
  if aircraftIdx > 0 then
    if not _G.IsNil(self._heroModel) then
      if not self._heroModel:IsInLoading() then
        self:DoAttachDetach(aircraftIdx, true)
      else
      end
    else
      self:LoadHeroModel()
    end
  end
  self._curMountIdx = aircraftIdx
end
def.method("number", "boolean").DoAttachDetach = function(self, cfgIdx, bAttach)
  local Model, aircraftModel
  if self._showType == AircraftNode.ShowType.Flip then
    aircraftModel = self._modelList and self._modelList[cfgIdx]
    local listIdx = self:GetListIdx(cfgIdx)
    local listItem = self._uiObjs.uiList.children[listIdx]
    Model = listItem and listItem:FindDirect("Model_Fly" .. cfgIdx)
  else
    aircraftModel = self._gridModel
    Model = self._uiObjs.SingleModel
  end
  if _G.IsNil(Model) then
    return
  end
  if not self:IsModelLoaded(aircraftModel) then
    return
  end
  if not self:IsModelLoaded(self._heroModel) then
    warn("[ERROR][AircraftNode:DoAttachDetach] self._heroModel not loaded:", bAttach)
    return
  end
  if bAttach then
    local oldPos = Model.localPosition
    local newPos = Vector3.new(oldPos.x, AircraftNode.UI_MODEL_MOUNT_Y, oldPos.z)
    Model.localPosition = newPos
    aircraftModel:AttachRole(self._heroModel)
  else
    aircraftModel:DetachRole()
    local oldPos = Model.localPosition
    local newPos = Vector3.new(oldPos.x, AircraftNode.UI_MODEL_DISMOUNT_Y, oldPos.z)
    Model.localPosition = newPos
  end
end
def.override("userdata").onClickObj = function(self, clickObj)
  local id = clickObj.name
  if id == "Btn_Tips" then
    self:OnBtn_Help(id)
  elseif id == "Btn_Color" then
    self:OnBtn_Color(clickObj)
  elseif id == "Btn_Undress" then
    self:OnBtn_Undress(clickObj)
  elseif id == "Btn_Dress" then
    self:OnBtn_Dress(clickObj)
  elseif id == "Btn_Try" then
    self:OnBtn_Try(clickObj)
  elseif id == "Img_AttPre" then
    self:OnImg_AttPre(clickObj)
  elseif id == "Img_AttAll" then
    self:OnImg_AttAll(id)
  elseif id == "Btn_Left" then
    self:OnBtn_Left(id)
  elseif id == "Btn_Right" then
    self:OnBtn_Right(id)
  elseif id == "Btn_Back" then
    self:OnBtn_Back()
  elseif id == "Btn_Next" then
    self:OnBtn_Next()
  elseif id == "Label_CurItem" then
    self:OnLabel_CurItem(id)
  elseif id == "Btn_Effect" then
    self:OnBtn_Effect(id)
  elseif id == "Btn_Mapping" then
    self:OnBtn_Mapping(clickObj)
  elseif id == "Btn_ChangeMode" then
    self:OnBtn_ChangeMode()
  elseif string.find(id, "item_") == 1 then
    local index = tonumber(string.sub(id, 6))
    if index then
      self:OnBtn_Select(index)
    end
  end
end
def.method("string").OnBtn_Help = function(self, id)
  GUIUtils.ShowHoverTip(constant.CFeijianConsts.introduce_tips_cfg_id, 0, 0)
end
def.method("userdata").OnBtn_Color = function(self, clickObj)
  if _G.CheckCrossServerAndToast() then
    return false
  end
  local parent = clickObj and clickObj.parent
  if parent then
    local id = parent.name
    if id == "Group_Preview" then
      local aircraftCfg = self._aircraftCfgList and self._aircraftCfgList[self._selectAircraft]
      if aircraftCfg then
        local aircraftInfo = AircraftData.Instance():GetAircraftInfo(aircraftCfg.id)
        if aircraftInfo then
          require("Main.Aircraft.ui.AircraftDyePanel").ShowPanel(aircraftInfo)
        else
          warn("[ERROR][AircraftNode:OnBtn_Color] don't have aircraft:", aircraftCfg.id)
          Toast(textRes.Aircraft.AIRCRAFT_DYE_NOT_OWN)
        end
      else
        warn("[ERROR][AircraftNode:OnBtn_Color] aircraftCfg nil for cfgIdx:", self._selectAircraft)
      end
    elseif string.find(id, "item_") == 1 then
      local index = tonumber(string.sub(id, 6))
      local cfgIdx = self:GetCfgIdx(index)
      local aircraftCfg = self._aircraftCfgList and self._aircraftCfgList[cfgIdx]
      if aircraftCfg then
        local aircraftInfo = AircraftData.Instance():GetAircraftInfo(aircraftCfg.id)
        if aircraftInfo then
          require("Main.Aircraft.ui.AircraftDyePanel").ShowPanel(aircraftInfo)
        else
          warn("[ERROR][AircraftNode:OnBtn_Color] don't have aircraft:", aircraftCfg.id)
          Toast(textRes.Aircraft.AIRCRAFT_DYE_NOT_OWN)
        end
      else
        warn("[ERROR][AircraftNode:OnBtn_Color] aircraftCfg nil for cfgIdx:", cfgIdx)
      end
    end
  else
    warn("[ERROR][AircraftNode:OnBtn_Color] parent nil for clickObj:", clickObj and clickObj.name)
  end
end
def.method("userdata").OnBtn_Undress = function(self, clickObj)
  if _G.CheckCrossServerAndToast() then
    return false
  end
  local parent = clickObj and clickObj.parent
  if parent then
    local id = parent.name
    if id == "Group_Preview" then
      local aircraftCfg = self._aircraftCfgList and self._aircraftCfgList[self._selectAircraft]
      if aircraftCfg then
        if AircraftData.Instance():IsCurrentAircraft(aircraftCfg.id) then
          if require("Main.Hero.HeroModule").Instance().myRole:IsInState(RoleState.FLY) then
            Toast(textRes.Aircraft.AIRCRAFT_CHANGE_FAIL_FLYING)
            return
          else
            AircraftProtocols.SendCTakeOffAircraft()
          end
        else
          warn("[ERROR][AircraftNode:OnBtn_Undress] not current aircraft:", aircraftCfg.id, AircraftData.Instance():GetCurrentAircraftId())
          Toast(textRes.Aircraft.AIRCRAFT_UNDRESS_NOT_CUR)
        end
        if self._selectAircraft == self._curMountIdx then
          self:SetMountAircraft(0, false)
        end
      else
        warn("[ERROR][AircraftNode:OnBtn_Undress] aircraftCfg nil for cfgIdx:", self._selectAircraft)
      end
    elseif string.find(id, "item_") == 1 then
      local index = tonumber(string.sub(id, 6))
      local cfgIdx = self:GetCfgIdx(index)
      local aircraftCfg = self._aircraftCfgList and self._aircraftCfgList[cfgIdx]
      if aircraftCfg then
        if AircraftData.Instance():IsCurrentAircraft(aircraftCfg.id) then
          if require("Main.Hero.HeroModule").Instance().myRole:IsInState(RoleState.FLY) then
            Toast(textRes.Aircraft.AIRCRAFT_CHANGE_FAIL_FLYING)
            return
          else
            AircraftProtocols.SendCTakeOffAircraft()
          end
        else
          warn("[ERROR][AircraftNode:OnBtn_Undress] not current aircraft:", aircraftCfg.id, AircraftData.Instance():GetCurrentAircraftId())
          Toast(textRes.Aircraft.AIRCRAFT_UNDRESS_NOT_CUR)
        end
        if cfgIdx == self._curMountIdx then
          self:SetMountAircraft(0, false)
        end
      else
        warn("[ERROR][AircraftNode:OnBtn_Undress] aircraftCfg nil for cfgIdx:", cfgIdx)
      end
    end
  else
    warn("[ERROR][AircraftNode:OnBtn_Undress] parent nil for clickObj:", clickObj and clickObj.name)
  end
end
def.method("userdata").OnBtn_Dress = function(self, clickObj)
  if _G.CheckCrossServerAndToast() then
    return
  end
  local parent = clickObj and clickObj.parent
  if parent then
    local id = parent.name
    if id == "Group_Preview" then
      local aircraftCfg = self._aircraftCfgList and self._aircraftCfgList[self._selectAircraft]
      if aircraftCfg then
        if AircraftData.Instance():HaveAircraft(aircraftCfg.id) then
          if require("Main.Hero.HeroModule").Instance().myRole:IsInState(RoleState.FLY) then
            Toast(textRes.Aircraft.AIRCRAFT_CHANGE_FAIL_FLYING)
            return
          else
            AircraftProtocols.SendCPutOnAircraft(aircraftCfg.id)
          end
        else
          warn("[ERROR][AircraftNode:OnBtn_Dress] don't have aircraft:", aircraftCfg.id)
          Toast(textRes.Aircraft.AIRCRAFT_DRESS_NOT_OWN)
        end
        self:SetMountAircraft(self._selectAircraft, false)
      else
        warn("[ERROR][AircraftNode:OnBtn_Dress] aircraftCfg nil for cfgIdx:", self._selectAircraft)
      end
    elseif string.find(id, "item_") == 1 then
      local index = tonumber(string.sub(id, 6))
      local cfgIdx = self:GetCfgIdx(index)
      local aircraftCfg = self._aircraftCfgList and self._aircraftCfgList[cfgIdx]
      if aircraftCfg then
        if AircraftData.Instance():HaveAircraft(aircraftCfg.id) then
          if require("Main.Hero.HeroModule").Instance().myRole:IsInState(RoleState.FLY) then
            Toast(textRes.Aircraft.AIRCRAFT_CHANGE_FAIL_FLYING)
            return
          else
            AircraftProtocols.SendCPutOnAircraft(aircraftCfg.id)
          end
        else
          warn("[ERROR][AircraftNode:OnBtn_Dress] don't have aircraft:", aircraftCfg.id)
          Toast(textRes.Aircraft.AIRCRAFT_DRESS_NOT_OWN)
        end
        self:SetMountAircraft(cfgIdx, false)
      else
        warn("[ERROR][AircraftNode:OnBtn_Dress] aircraftCfg nil for cfgIdx:", cfgIdx)
      end
    end
  else
    warn("[ERROR][AircraftNode:OnBtn_Dress] parent nil for clickObj:", clickObj and clickObj.name)
  end
end
def.method("userdata").OnBtn_Try = function(self, clickObj)
  local parent = clickObj and clickObj.parent
  if parent then
    local id = parent.name
    if id == "Group_Preview" then
      self:SetMountAircraft(self._selectAircraft, false)
    elseif string.find(id, "item_") == 1 then
      local index = tonumber(string.sub(id, 6))
      if index then
        local cfgIdx = self:GetCfgIdx(index)
        self:SetMountAircraft(cfgIdx, false)
      end
    end
  else
    warn("[ERROR][AircraftNode:OnBtn_Try] parent nil for clickObj:", clickObj and clickObj.name)
  end
end
def.method("userdata").OnBtn_Mapping = function(self, clickObj)
  local parent = clickObj and clickObj.parent
  if parent then
    local id = parent.name
    if id == "Group_Preview" then
      local list = {}
      for k, v in pairs(self._aircraftCfgList) do
        local bHave = AircraftData.Instance():HaveAircraft(v.id)
        if bHave then
          list[k] = v.id
        end
      end
      local validTypeEnum = require("consts.mzm.gsp.modelcustomtexture.confbean.ObjectTypeEnum")
      local ModelCustomizeTexturePanel = require("Main.ModelCustomizeTexture.ui.ModelCustomizeTexturePanel")
      ModelCustomizeTexturePanel.Instance():ShowPanel(list, self._selectAircraft, validTypeEnum.AIRCRAFT)
    elseif string.find(id, "item_") == 1 then
      local index = tonumber(string.sub(id, 6))
      local cfgIdx = self:GetCfgIdx(index)
      local list = {}
      for k, v in pairs(self._aircraftCfgList) do
        local bHave = AircraftData.Instance():HaveAircraft(v.id)
        if bHave then
          list[k] = v.id
        end
      end
      local validTypeEnum = require("consts.mzm.gsp.modelcustomtexture.confbean.ObjectTypeEnum")
      local ModelCustomizeTexturePanel = require("Main.ModelCustomizeTexture.ui.ModelCustomizeTexturePanel")
      ModelCustomizeTexturePanel.Instance():ShowPanel(list, cfgIdx, validTypeEnum.AIRCRAFT)
    end
  end
end
def.method("userdata").OnImg_AttPre = function(self, clickObj)
  local parent = clickObj and clickObj.parent
  local parent = parent and parent.parent
  if parent then
    local id = parent.name
    if id == "Group_Preview" then
      local aircraftCfg = self._aircraftCfgList and self._aircraftCfgList[self._selectAircraft]
      if aircraftCfg then
        local title = textRes.Aircraft.AIRCRAFT_ATTR_PREVIEW_TITLE
        local content = AircraftUtils.GetAircraftAttrString(aircraftCfg)
        require("GUI.CommonTipWithTitle").Instance():ShowTargetTip(clickObj, title, content)
      else
        warn("[ERROR][AircraftNode:OnImg_AttPre] aircraftCfg nil for cfgIdx:", cfgIdx)
      end
    elseif string.find(id, "item_") == 1 then
      local index = tonumber(string.sub(id, 6))
      local cfgIdx = self:GetCfgIdx(index)
      local aircraftCfg = self._aircraftCfgList and self._aircraftCfgList[cfgIdx]
      if aircraftCfg then
        local title = textRes.Aircraft.AIRCRAFT_ATTR_PREVIEW_TITLE
        local content = AircraftUtils.GetAircraftAttrString(aircraftCfg)
        require("GUI.CommonTipWithTitle").Instance():ShowTargetTip(clickObj, title, content)
      else
        warn("[ERROR][AircraftNode:OnImg_AttPre] aircraftCfg nil for cfgIdx:", cfgIdx)
      end
    end
  else
    warn("[ERROR][AircraftNode:OnImg_AttPre] parent nil for clickObj:", clickObj and clickObj.name)
  end
end
def.method("string").OnImg_AttAll = function(self, id)
  require("Main.Aircraft.ui.AircraftAttrPanel").ShowPanel()
end
def.method("string").OnBtn_Left = function(self, id)
  self:ShowAircraftPage(self._curPage - 1, false)
end
def.method("string").OnBtn_Right = function(self, id)
  self:ShowAircraftPage(self._curPage + 1, false)
end
def.method().OnBtn_Back = function(self)
  self:ShowAircraftPage(self._gridPage - 1, true)
end
def.method().OnBtn_Next = function(self)
  self:ShowAircraftPage(self._gridPage + 1, true)
end
def.method("string").OnLabel_CurItem = function(self, id)
  if self._showType == AircraftNode.ShowType.Flip then
    local curAircraftId = AircraftData.Instance():GetCurrentAircraftId()
    self._curMountIdx = self:_GetAircraftIdx(curAircraftId)
    local page = self:_GetAircraftPage(curAircraftId)
    self:ShowAircraftPage(page, false)
  elseif self._showType == AircraftNode.ShowType.Grid then
    local currentId = AircraftData.Instance():GetCurrentAircraftId()
    local page = self:_GetAircraftPage(currentId)
    self._selectAircraft = self:_GetAircraftIdx(currentId)
    self._curMountIdx = self._selectAircraft
    self:ShowAircraftPage(page, true)
    self:ShowSelectAircraft()
  end
end
def.method("string").OnBtn_Effect = function(self, id)
  require("Main.Aircraft.AircraftModule").Instance():ConsumeAircraftAttrReddot()
  require("Main.Aircraft.ui.AircraftSelectAttrPanel").ShowPanel()
end
def.method().OnBtn_ChangeMode = function(self)
  if self._showType == AircraftNode.ShowType.Flip then
    self:SwitchViewType(AircraftNode.ShowType.Grid)
  elseif self._showType == AircraftNode.ShowType.Grid then
    self:SwitchViewType(AircraftNode.ShowType.Flip)
  end
end
def.method("number").OnBtn_Select = function(self, index)
  if self._showType == AircraftNode.ShowType.Grid then
    local idx = (self._gridPage - 1) * AircraftNode.GRID_PER_PAGE + index
    self._selectAircraft = idx
    self:ShowSelectAircraft()
  end
end
def.override("string").onDragStart = function(self, id)
  if string.find(id, "Model_Fly") then
    local index = tonumber(string.sub(id, 10))
    if index then
      if index > 0 then
        self._dragModel = self._modelList[index]
      else
        self._dragModel = self._gridModel
      end
      if not _G.IsNil(self._dragModel) then
        self._isDrag = true
      end
    end
  end
end
def.override("string").onDragEnd = function(self, id)
  self._isDrag = false
  self._dragModel = nil
end
def.override("string", "number", "number").onDrag = function(self, id, dx, dy)
  if self._isDrag == true and not _G.IsNil(self._dragModel) then
    self._dragModel:SetDir(self._dragModel.m_ang - dx / 2)
  end
end
def.method("boolean").HandleEventListeners = function(self, isRigister)
  local eventFunc
  if isRigister then
    Event.RegisterEventWithContext(ModuleId.AIRCRAFT, gmodule.notifyId.Aircraft.AIRCRAFT_INFO_CHANGE, AircraftNode.OnAircraftChange, self)
    Event.RegisterEventWithContext(ModuleId.AIRCRAFT, gmodule.notifyId.Aircraft.AIRCRAFT_MOUNT_CHANGE, AircraftNode.OnAircraftMountChange, self)
    Event.RegisterEventWithContext(ModuleId.AIRCRAFT, gmodule.notifyId.Aircraft.AIRCRAFT_DYE_CHANGE, AircraftNode.OnAircraftDyeChange, self)
  else
    Event.UnregisterEvent(ModuleId.AIRCRAFT, gmodule.notifyId.Aircraft.AIRCRAFT_INFO_CHANGE, AircraftNode.OnAircraftChange)
    Event.UnregisterEvent(ModuleId.AIRCRAFT, gmodule.notifyId.Aircraft.AIRCRAFT_MOUNT_CHANGE, AircraftNode.OnAircraftMountChange)
    Event.UnregisterEvent(ModuleId.AIRCRAFT, gmodule.notifyId.Aircraft.AIRCRAFT_DYE_CHANGE, AircraftNode.OnAircraftDyeChange)
  end
end
def.method("table").OnAircraftChange = function(self, params)
  if not _G.IsNil(self.m_node) and self.isShow then
    if self._showType == AircraftNode.ShowType.Flip then
      local startIdx = (self._curPage - 1) * AircraftNode.COUNT_PER_PAGE + 1
      local endIdx = math.min(self:_GetAircraftCount(), self._curPage * AircraftNode.COUNT_PER_PAGE)
      if startIdx <= endIdx then
        for cfgIdx = startIdx, endIdx do
          local aircraftCfg = self._aircraftCfgList[cfgIdx]
          self:UpdateAircraftState(cfgIdx, aircraftCfg)
        end
      end
    elseif self._showType == AircraftNode.ShowType.Grid then
      self:ShowAircraftPage(self._gridPage, true)
      local curAircraftId = AircraftData.Instance():GetCurrentAircraftId()
      if curAircraftId <= 0 or self._selectAircraft == self:_GetAircraftIdx(curAircraftId) then
        local cfg = self._aircraftCfgList[self._selectAircraft]
        self:UpdateSelectAircraftState(cfg)
      end
    end
  end
end
def.method("table").OnAircraftMountChange = function(self, params)
  if not _G.IsNil(self.m_node) and self.isShow then
    self:UpdateCurrentAircraft()
  end
end
def.method("table").OnAircraftDyeChange = function(self, params)
  if not _G.IsNil(self.m_node) and self.isShow then
    local aircraftId = params.aircraftId
    if self._showType == AircraftNode.ShowType.Flip then
      local startIdx = (self._curPage - 1) * AircraftNode.COUNT_PER_PAGE + 1
      local endIdx = math.min(self:_GetAircraftCount(), self._curPage * AircraftNode.COUNT_PER_PAGE)
      if startIdx <= endIdx then
        for cfgIdx = startIdx, endIdx do
          local aircraftCfg = self._aircraftCfgList[cfgIdx]
          if aircraftId == aircraftCfg.id then
            local aircraftModel = self._modelList and self._modelList[cfgIdx]
            if not _G.IsNil(aircraftModel) then
              local colorId = AircraftData.Instance():GetAircraftColor(aircraftId)
              aircraftModel:Dye(colorId)
            end
          end
        end
      end
    elseif self._showType == AircraftNode.ShowType.Grid then
      local cfg = self._aircraftCfgList[self._selectAircraft]
      if aircraftId == cfg.id and self._gridModel then
        local colorId = AircraftData.Instance():GetAircraftColor(aircraftId)
        self._gridModel:Dye(colorId)
      end
    end
  end
end
def.method("=>", "boolean").IsMultiAircraftOpen = function(self)
  return false
end
def.method("table", "=>", "string").GetAircraftTag = function(self, aircraftCfg)
  if aircraftCfg.maxOnRoleNum == 2 then
    return "fly_2"
  elseif aircraftCfg.maxOnRoleNum == 5 then
    return "fly_5"
  else
    return ""
  end
end
def.method("table", "=>", "string").GetAircraftSmallTag = function(self, aircraftCfg)
  if aircraftCfg.maxOnRoleNum == 2 then
    return "Img_Two"
  elseif aircraftCfg.maxOnRoleNum == 5 then
    return "Img_Five"
  else
    return ""
  end
end
AircraftNode.Commit()
return AircraftNode

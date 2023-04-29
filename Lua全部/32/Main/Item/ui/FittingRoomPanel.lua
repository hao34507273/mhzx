local Lplus = require("Lplus")
local ECPanelBase = require("GUI.ECPanelBase")
local HeroModule = require("Main.Hero.HeroModule")
local ItemModule = require("Main.Item.ItemModule")
local ECUIModel = require("Model.ECUIModel")
local ItemUtils = require("Main.Item.ItemUtils")
local FashionUtils = require("Main.Fashion.FashionUtils")
local ItemType = require("consts.mzm.gsp.item.confbean.ItemType")
local Vector = require("Types.Vector")
local FabaoUtils = require("Main.Fabao.FabaoUtils")
local FittingRoomMgr = require("Main.Item.FittingRoomMgr")
local FittingRoomPanel = Lplus.Extend(ECPanelBase, "FittingRoomPanel")
local def = FittingRoomPanel.define
def.field("number").mItemId = -1
def.field("number").mItemType = -1
def.field("string").mName = ""
def.field("table").mExtInfo = nil
def.field("number").mWingId = -1
def.field("number").mDyeId = -1
def.field("boolean").mViewType = false
def.field("table").itemModel = nil
def.field(ECUIModel).mUIModel = nil
def.field("function").closeCallback = nil
def.const("table").pos = {
  defaultpos = {
    0,
    120,
    0
  },
  magicmarkpos = {
    0,
    80,
    0
  },
  heropos = {
    0,
    0,
    180
  },
  aircraftpos = {
    0,
    80,
    0
  }
}
local instance
def.static("=>", FittingRoomPanel).Instance = function()
  if instance == nil then
    instance = FittingRoomPanel()
  end
  return instance
end
def.method("number", "number", "table").ShowPanel = function(self, itemType, itemId, itemInfo)
  if self:IsShow() then
    self:DestroyHeroModel()
    self:DestroyPanel()
  end
  if itemType == ItemType.WU_SHI_ITEM then
    local GodWeaponModule = require("Main.GodWeapon.GodWeaponModule")
    local DecorationMgr = require("Main.GodWeapon.DecorationMgr")
    local DecorationUtils = require("Main.GodWeapon.Decoration.DecorationUtils")
    if not GodWeaponModule.Instance():IsOpen(false) or not DecorationMgr.IsOwndGodWeapon() then
      Toast(textRes.Item.FittingRoomPanel.ErrorNoWS)
      return
    end
  end
  self.closeCallback = nil
  self:SetData(itemType, itemId, itemInfo)
  self:CreatePanel(RESPATH.PREFAB_FITTING_ROOM_PANEL, 2)
  self:SetModal(true)
end
def.method("number", "number", "string", "function").ShowWingsPanel = function(self, wingsId, dyeId, name, cb)
  if self:IsShow() then
    self:DestroyHeroModel()
    self:DestroyPanel()
  end
  self.closeCallback = cb
  self:SetWingsData(wingsId, dyeId, name)
  FittingRoomMgr.Instance():SetWingsData(wingsId, dyeId, name)
  self:CreatePanel(RESPATH.PREFAB_FITTING_ROOM_PANEL, 2)
end
def.override().OnCreate = function(self)
  local UIModel = self.m_panel:FindDirect("Img_Bg/Model"):GetComponent("UIModel")
  UIModel.modelCamera.depth = CameraDepth.UI2
  self:FillPanelInfo()
  self:SetModal(true)
end
def.method().FillPanelInfo = function(self)
  if self.mViewType then
    self.m_panel:FindDirect("Img_Bg/Btn_Quit"):SetActive(true)
    self.m_panel:FindDirect("Img_Bg/Btn_Try"):SetActive(false)
  elseif not self.mViewType then
    self.m_panel:FindDirect("Img_Bg/Btn_Try"):SetActive(true)
    self.m_panel:FindDirect("Img_Bg/Btn_Quit"):SetActive(false)
  end
  if self.mItemType == ItemType.PET_CHANGEMODEL_ITEM or self.mItemType == ItemType.CHANGE_MODEL_CARD_ITEM then
    self.m_panel:FindDirect("Img_Bg/Btn_Try"):SetActive(false)
    self.m_panel:FindDirect("Img_Bg/Btn_Quit"):SetActive(false)
  elseif self.mItemType == ItemType.AIR_CRAFT_ITEM and ItemUtils.GetItemBase(self.mItemId).itemTypeName == "\229\143\152\232\186\171\233\163\158\232\161\140\229\153\168" then
    self.m_panel:FindDirect("Img_Bg/Btn_Try"):SetActive(false)
    self.m_panel:FindDirect("Img_Bg/Btn_Quit"):SetActive(false)
  elseif self.mItemType == ItemType.RIDDER_ITEM and ItemUtils.GetItemBase(self.mItemId).itemTypeName == "\229\143\152\232\186\171\229\157\144\233\170\145" then
    self.m_panel:FindDirect("Img_Bg/Btn_Try"):SetActive(false)
    self.m_panel:FindDirect("Img_Bg/Btn_Quit"):SetActive(false)
  elseif self.mItemType == ItemType.FASHION_DRESS_ITEM then
    self.m_panel:FindDirect("Img_Bg/Btn_Try"):SetActive(false)
    self.m_panel:FindDirect("Img_Bg/Btn_Quit"):SetActive(false)
  end
  self:SetHeroName()
  self:SetItemName()
  self:SetItemType()
  if self.mViewType then
    self:UpdateHeroModel()
  elseif self.mItemType == ItemType.CHANGE_MODEL_CARD_ITEM then
    self:UpdateHeroModel()
  elseif self.mItemType == ItemType.FASHION_DRESS_ITEM then
    self:UpdateHeroModel()
  else
    self:UpdateItemModel()
  end
end
def.method().SetItemName = function(self)
  local label = self.m_panel:FindDirect("Img_Bg/Label_SuitName"):GetComponent("UILabel")
  label.text = self.mName
end
def.method().SetItemType = function(self)
  local sprite = self.m_panel:FindDirect("Img_Bg/Img_Category"):GetComponent("UISprite")
  if self.mItemType == ItemType.WING_VIEW_ITEM then
    sprite.spriteName = "Icon_01"
  elseif self.mItemType == ItemType.WU_SHI_ITEM then
    sprite.spriteName = "Icon_02"
  elseif self.mItemType == ItemType.FASHION_DRESS_ITEM then
    sprite.spriteName = "Icon_03"
  elseif self.mItemType == ItemType.FABAO_ITEM or self.mItemType == ItemType.FABAO_ARTIFACT_ITEM then
    sprite.spriteName = "Icon_04"
  elseif self.mItemType == ItemType.AIR_CRAFT_ITEM then
    sprite.spriteName = "Icon_05"
  elseif self.mItemType == ItemType.RIDDER_ITEM then
    sprite.spriteName = "Icon_06"
  elseif self.mItemType == ItemType.MAGIC_MARK then
    sprite.spriteName = "Icon_07"
  elseif self.mItemType == ItemType.CHANGE_MODEL_CARD_ITEM then
    sprite.spriteName = "Icon_09"
  elseif self.mItemType == ItemType.PET_CHANGEMODEL_ITEM then
    sprite.spriteName = "Icon_10"
  end
end
def.method().SetHeroName = function(self)
  local heroProp = HeroModule.Instance():GetHeroProp()
  local heroName = heroProp.name
  local nameLabel = self.m_panel:FindDirect("Img_Bg/Label_PlayerName"):GetComponent("UILabel")
  if nameLabel == nil then
    return
  end
  nameLabel.text = heroName
end
def.method().UpdateHeroModel = function(self)
  local model = self.m_panel:FindDirect("Img_Bg/Model")
  self:DestroyAllModels()
  self.mUIModel = FittingRoomMgr.Instance():ShowHeroTryModel(model, "FittingRoomPanel", self.mItemId, self.mItemType, FittingRoomPanel.pos.heropos)
end
def.method().UpdateItemModel = function(self)
  local model = self.m_panel:FindDirect("Img_Bg/Model")
  self:DestroyAllModels()
  if self.mItemType == ItemType.FASHION_DRESS_ITEM then
    self.mUIModel = FittingRoomMgr.Instance():ShowFashionItemTryModel(model, "FittingRoomPanel", self.mItemId, self.mItemType, FittingRoomPanel.pos.heropos)
  elseif self.mItemType == ItemType.AIR_CRAFT_ITEM then
    self.mUIModel = FittingRoomMgr.Instance():ShowAirCraftModel(model, "FittingRoomPanel", self.mItemId, self.mItemType, FittingRoomPanel.pos.aircraftpos)
  elseif self.mItemType == ItemType.PET_CHANGEMODEL_ITEM then
    self.itemModel = self:ShowPetChangeModel()
  else
    local position = FittingRoomPanel.pos.defaultpos
    if self.mItemType == ItemType.MAGIC_MARK then
      position = FittingRoomPanel.pos.magicmarkpos
    end
    self.itemModel = FittingRoomMgr.Instance():ShowItemTryModel(model, "FittingRoomPanel", self.mItemId, self.mItemType, position)
  end
end
def.method("=>", "table").ShowPetChangeModel = function(self)
  local modelId = ItemUtils.GetPetHuiZhiItemCfg(self.mItemId).modelId
  local colorId = ItemUtils.GetPetHuiZhiItemCfg(self.mItemId).colorId
  local modelPath = _G.GetModelPath(modelId)
  self.itemModel = ECUIModel.new(modelId)
  local model = self.m_panel:FindDirect("Img_Bg/Model")
  local uiModel = model:GetComponent("UIModel")
  self.itemModel:LoadUIModel(modelPath, function(ret)
    uiModel.modelGameObject = self.itemModel.m_model
    if uiModel.mCanOverflow ~= nil then
      uiModel.mCanOverflow = true
      local camera = uiModel:get_modelCamera()
      camera:set_orthographic(true)
    end
    if colorId > 0 then
      local colorcfg = _G.GetModelColorCfg(colorId)
      self.itemModel:SetColoration(colorcfg)
    else
      self.itemModel:SetColoration(nil)
    end
  end)
  return self.itemModel
end
def.method("number", "number", "table").SetData = function(self, itemType, itemId, itemInfo)
  self.mItemType = itemType
  self.mItemId = itemId
  self.mName = ItemUtils.GetItemBase(self.mItemId).name
  self.mExtInfo = itemInfo
end
def.method("number", "number", "string").SetWingsData = function(self, wingsId, dyeId, name)
  self.mItemType = ItemType.WING_VIEW_ITEM
  self.mName = name
  self.mWingId = wingsId
  self.mDyeId = dyeId
end
def.method().ReSetData = function(self)
  self.mItemId = -1
  self.mName = ""
  self.mItemType = -1
  self.mExtInfo = nil
  self.mWingId = -1
  self.mDyeId = -1
end
def.method("string", "number", "number").onDrag = function(self, id, dx, dy)
  if id == "Model" then
    if self.mUIModel ~= nil and self.mUIModel.m_model ~= nil then
      self.mUIModel:SetDir(self.mUIModel.m_ang - dx / 2)
    elseif self.itemModel ~= nil then
      self.itemModel:SetDir(self.itemModel:GetDir() - dx / 2)
    end
  end
end
def.method("string").onClick = function(self, id)
  if id == "Btn_Close" then
    self:DestroyHeroModel()
    self:DestroyAllModels()
    self:DestroyPanel()
  elseif id == "Btn_Try" then
    self.mViewType = true
    self:FillPanelInfo()
  elseif id == "Btn_Quit" then
    self.mViewType = false
    self:FillPanelInfo()
  end
end
def.method().DestroyHeroModel = function(self)
  self:ReSetData()
  if self.mUIModel then
    self.mUIModel:Destroy()
    self.mUIModel = nil
  end
end
def.method().DestroyAllModels = function(self)
  if self.itemModel then
    self.itemModel:Destroy()
    self.itemModel = nil
  end
  if self.mUIModel then
    self.mUIModel:Destroy()
    self.mUIModel = nil
  end
end
def.override().OnDestroy = function(self)
  self:DestroyHeroModel()
  self:DestroyAllModels()
  self.mViewType = false
  if self.closeCallback then
    self.closeCallback()
    self.closeCallback = nil
  end
end
FittingRoomPanel.Commit()
return FittingRoomPanel

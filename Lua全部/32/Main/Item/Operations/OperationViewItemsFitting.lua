local Lplus = require("Lplus")
local OperationBase = require("Main.Item.Operations.OperationBase")
local ItemTipsMgr = require("Main.Item.ItemTipsMgr")
local ItemModule = require("Main.Item.ItemModule")
local ItemUtils = require("Main.Item.ItemUtils")
local FittingRoomPanel = require("Main.Item.ui.FittingRoomPanel")
local OperationViewItemsFitting = Lplus.Extend(OperationBase, "OperationViewItemsFitting")
local def = OperationViewItemsFitting.define
def.field("number").mItemId = 0
def.field("number").mItemType = 0
def.field("table").mExtInfo = nil
def.override("number", "table", "table", "=>", "boolean").CanDispaly = function(self, source, item, itemBase)
  local ItemType = require("consts.mzm.gsp.item.confbean.ItemType")
  if itemBase.itemType == ItemType.RIDDER_ITEM then
    self.mItemId = itemBase.itemid
    self.mItemType = itemBase.itemType
    self.mExtInfo = item
    return true
  elseif itemBase.itemType == ItemType.AIR_CRAFT_ITEM then
    self.mItemId = itemBase.itemid
    self.mItemType = itemBase.itemType
    self.mExtInfo = item
    return true
  elseif itemBase.itemType == ItemType.MAGIC_MARK then
    self.mItemId = itemBase.itemid
    self.mItemType = itemBase.itemType
    self.mExtInfo = item
    return true
  elseif itemBase.itemType == ItemType.CHANGE_MODEL_CARD_ITEM then
    self.mItemId = itemBase.itemid
    self.mItemType = itemBase.itemType
    self.mExtInfo = item
    return true
  elseif itemBase.itemType == ItemType.PET_CHANGEMODEL_ITEM then
    self.mItemId = itemBase.itemid
    self.mItemType = itemBase.itemType
    self.mExtInfo = item
    return true
  elseif itemBase.itemType == ItemType.FABAO_ARTIFACT_ITEM then
    self.mItemId = itemBase.itemid
    self.mItemType = itemBase.itemType
    self.mExtInfo = item
    return true
  elseif itemBase.itemType == ItemType.WU_SHI_ITEM then
    local GodWeaponModule = require("Main.GodWeapon.GodWeaponModule")
    local DecorationMgr = require("Main.GodWeapon.DecorationMgr")
    local DecorationUtils = require("Main.GodWeapon.Decoration.DecorationUtils")
    if not GodWeaponModule.Instance():IsOpen(false) or not DecorationMgr.IsOwndGodWeapon() then
      return false
    else
      self.mItemId = itemBase.itemid
      self.mItemType = itemBase.itemType
      self.mExtInfo = item
      return true
    end
  elseif ItemUtils.IsShowViewItem(itemBase.itemType) then
    self.mItemId = itemBase.itemid
    self.mItemType = itemBase.itemType
    self.mExtInfo = item
    return true
  end
  return false
end
def.override("=>", "string").GetOperationName = function(self)
  return textRes.Item[9500]
end
def.override("number", "number", "userdata", "table", "=>", "boolean").Operate = function(self, bagId, itemKey, m_panel, context)
  local panelinstance = FittingRoomPanel.Instance()
  panelinstance:ShowPanel(self.mItemType, self.mItemId, self.mExtInfo)
  return true
end
OperationViewItemsFitting.Commit()
return OperationViewItemsFitting

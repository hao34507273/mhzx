local Lplus = require("Lplus")
local OperationBase = require("Main.Item.Operations.OperationBase")
local ItemTipsMgr = require("Main.Item.ItemTipsMgr")
local CommonConfirmDlg = require("GUI.CommonConfirmDlg")
local ItemInfo = require("netio.protocol.mzm.gsp.item.ItemInfo")
local ItemModule = require("Main.Item.ItemModule")
local MathHelper = require("Common.MathHelper")
local OperationCompositePetEquipment = Lplus.Extend(OperationBase, "OperationCompositePetEquipment")
local def = OperationCompositePetEquipment.define
def.field("number").itemType = -1
def.field("number").source = -1
def.override("number", "table", "table", "=>", "boolean").CanDispaly = function(self, source, item, itemBase)
  local ItemType = require("consts.mzm.gsp.item.confbean.ItemType")
  self.itemType = itemBase.itemType
  self.source = source
  if source == ItemTipsMgr.Source.Bag and itemBase.itemType == ItemType.PET_EQUIP then
    return true
  else
    return false
  end
end
def.override("=>", "string").GetOperationName = function(self)
  return textRes.Item[8115]
end
def.override("number", "number", "userdata", "table", "=>", "boolean").Operate = function(self, bagId, itemKey, m_panel, context)
  Event.DispatchEvent(ModuleId.PET, gmodule.notifyId.Pet.OPEN_PET_EQUIPMENT_OP_PANEL_REQ, {bagId, itemKey})
  return true
end
OperationCompositePetEquipment.Commit()
return OperationCompositePetEquipment

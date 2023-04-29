local Lplus = require("Lplus")
local OcpEquipmentMgr = Lplus.Class("OcpEquipmentMgr")
local def = OcpEquipmentMgr.define
local ItemUtils = require("Main.Item.ItemUtils")
local EquipUtils = require("Main.Equip.EquipUtils")
def.field("table").m_equipmentBags = nil
def.field("table").m_ocpEquipmentsReqs = nil
def.field("table").m_ocpModelInfos = nil
local _debug = false
local instance
def.static("=>", OcpEquipmentMgr).Instance = function()
  if instance == nil then
    instance = OcpEquipmentMgr()
    instance:Init()
  end
  return instance
end
def.method().Init = function(self)
  if not _debug then
    gmodule.network.registerProtocol("netio.protocol.mzm.gsp.ocpequip.SSynOcpEquipRes", OcpEquipmentMgr.OnSSynOcpEquipRes)
    gmodule.network.registerProtocol("netio.protocol.mzm.gsp.ocpequip.SPutOnOcpEquipRes", OcpEquipmentMgr.OnSPutOnOcpEquipRes)
    gmodule.network.registerProtocol("netio.protocol.mzm.gsp.ocpequip.SPutOffOcpEquipRes", OcpEquipmentMgr.OnSPutOffOcpEquipRes)
    gmodule.network.registerProtocol("netio.protocol.mzm.gsp.ocpequip.STransferStrengthFromOcpBagRes", OcpEquipmentMgr.OnSTransferStrengthFromOcpBagRes)
    gmodule.network.registerProtocol("netio.protocol.mzm.gsp.ocpequip.SCommonErrorInfo", OcpEquipmentMgr.OnSCommonErrorInfo)
  end
  Event.RegisterEvent(ModuleId.LOGIN, gmodule.notifyId.Login.LEAVE_WORLD, OcpEquipmentMgr.OnLeaveWorld)
end
def.method("number", "number", "=>", "table").GetOccupationBag = function(self, occupation, gender)
  if self.m_equipmentBags then
    local key = self:GetOccpGenderKey(occupation, gender)
    return self.m_equipmentBags[key]
  end
  return nil
end
def.method("number", "number", "=>", "table").GetOccupationEquipments = function(self, occupation, gender)
  local heroProp = _G.GetHeroProp()
  local equipments
  if heroProp.occupation == occupation and heroProp.gender == gender then
    equipments = gmodule.moduleMgr:GetModule(ModuleId.ITEM):GetHeroEquipments()
  else
    local occupationBag = self:GetOccupationBag(occupation, gender)
    if occupationBag then
      equipments = occupationBag.items
    end
  end
  return equipments
end
def.method("number", "number", "function").AsyncGetOccupationEquipments = function(self, occupation, gender, onFinish)
  local heroProp = _G.GetHeroProp()
  if heroProp.occupation == occupation and heroProp.gender == gender then
    local equipments = self:GetOccupationEquipments(occupation, gender)
    _G.SafeCallback(onFinish, equipments)
  else
    self.m_ocpEquipmentsReqs = self.m_ocpEquipmentsReqs or {}
    local key = self:GetOccpGenderKey(occupation, gender)
    self.m_ocpEquipmentsReqs[key] = onFinish
    self:CQueryOcpEquipReq(occupation, gender)
  end
end
def.method("number", "number", "=>", "string").GetOccpGenderKey = function(self, occupation, gender)
  return string.format("%d_%d", occupation, gender)
end
def.method("number", "number", "=>", "table").GetOccupationModelInfo = function(self, occupation, gender)
  if self.m_ocpModelInfos == nil then
    return nil
  end
  local key = self:GetOccpGenderKey(occupation, gender)
  return self.m_ocpModelInfos[occupation]
end
def.method().Clear = function(self)
  self.m_equipmentBags = nil
  self.m_ocpEquipmentsReqs = nil
  self.m_ocpModelInfos = nil
end
def.method("number", "number").CQueryOcpEquipReq = function(self, ocp, gender)
  if not _debug then
    local p = require("netio.protocol.mzm.gsp.ocpequip.CQueryOcpEquipReq").new(ocp, gender)
    gmodule.network.sendProtocol(p)
  else
    GameUtil.AddGlobalTimer(0, true, function(...)
      OcpEquipmentMgr.OnSSynOcpEquipRes({
        ocp = ocp,
        gender = gender,
        ocpequipbags = {
          items = {}
        }
      })
    end)
  end
end
def.method("number", "number", "userdata").CPutOnOcpEquipReq = function(self, ocp, gender, uuid)
  local p = require("netio.protocol.mzm.gsp.ocpequip.CPutOnOcpEquipReq").new(ocp, gender, uuid)
  gmodule.network.sendProtocol(p)
end
def.method("number", "number", "number").CPutOffOcpEquipReq = function(self, ocp, gender, key)
  local p = require("netio.protocol.mzm.gsp.ocpequip.CPutOffOcpEquipReq").new(ocp, gender, key)
  gmodule.network.sendProtocol(p)
end
def.static("table").OnSSynOcpEquipRes = function(p)
  local key = OcpEquipmentMgr.Instance():GetOccpGenderKey(p.ocp, p.gender)
  instance.m_equipmentBags = instance.m_equipmentBags or {}
  instance.m_equipmentBags[key] = p.ocpequipbags
  instance.m_ocpModelInfos = instance.m_ocpModelInfos or {}
  instance.m_ocpModelInfos[key] = p.modelinfo
  for itemKey, v in pairs(p.ocpequipbags.items) do
    v.position = itemKey
  end
  if instance.m_ocpEquipmentsReqs and instance.m_ocpEquipmentsReqs[key] then
    local callback = instance.m_ocpEquipmentsReqs[key]
    instance.m_ocpEquipmentsReqs[key] = nil
    local equipments = instance:GetOccupationEquipments(p.ocp, p.gender)
    _G.SafeCallback(callback, equipments)
  end
end
def.static("table").OnSPutOnOcpEquipRes = function(p)
  local equipmentBag = instance:GetOccupationBag(p.ocp, p.gender)
  if equipmentBag == nil then
    warn(string.format("OnSPutOnOcpEquipRes p.ocp=%d, p.gender=%d, p.key=%d equipmentBag is nil", p.ocp, p.gender, p.key))
    return
  end
  equipmentBag.items[p.key] = p.item
  p.item.position = p.key
  local params = {
    ocp = p.ocp,
    gender = p.gender,
    key = p.key
  }
  Event.DispatchEvent(ModuleId.EQUIP, gmodule.notifyId.Equip.Ocp_Equipment_Change, params)
  local item = p.item
  local itemBase = ItemUtils.GetItemBase(item.id)
  local color = EquipUtils.GetEquipDynamicColor(item, nil, itemBase)
  local toastStr
  local heroProp = _G.GetHeroProp()
  if heroProp.occupation ~= p.ocp then
    toastStr = textRes.Equip.OcpEquipment[2]
  else
    toastStr = textRes.Equip.OcpEquipment[6]
  end
  Toast(string.format(toastStr, require("Main.Chat.HtmlHelper").NameColor[color], ItemUtils.GetItemName(item, itemBase)))
end
def.static("table").OnSPutOffOcpEquipRes = function(p)
  local equipmentBag = instance:GetOccupationBag(p.ocp, p.gender)
  if equipmentBag == nil then
    warn(string.format("OnSPutOffOcpEquipRes p.ocp=%d, p.gender=%d, p.key=%d equipmentBag is nil", p.ocp, p.gender, p.key))
    return
  end
  local item = equipmentBag.items[p.key]
  equipmentBag.items[p.key] = nil
  local params = {
    ocp = p.ocp,
    gender = p.gender,
    key = p.key
  }
  Event.DispatchEvent(ModuleId.EQUIP, gmodule.notifyId.Equip.Ocp_Equipment_Change, params)
  local itemBase = ItemUtils.GetItemBase(item.id)
  local color = EquipUtils.GetEquipDynamicColor(item, nil, itemBase)
  local toastStr
  local heroProp = _G.GetHeroProp()
  if heroProp.occupation ~= p.ocp then
    toastStr = textRes.Equip.OcpEquipment[3]
  else
    toastStr = textRes.Equip.OcpEquipment[7]
  end
  Toast(string.format(toastStr, require("Main.Chat.HtmlHelper").NameColor[color], ItemUtils.GetItemName(item, itemBase)))
end
def.static("table").OnSTransferStrengthFromOcpBagRes = function(p)
  local occupationName = require("Main.TransSex.TransSexUtils").GetOccpGenderName(p.ocp, p.gender)
  local itemId = p.itemId
  local itemBase = ItemUtils.GetItemBase(itemId)
  local equipLevel = itemBase.useLevel
  local equipName = require("Main.Chat.HtmlHelper").GetColoredItemName(itemId)
  local text = string.format(textRes.Equip.OcpEquipment[5], occupationName, equipLevel, equipName)
  require("Main.Chat.PersonalHelper").SendOut(text)
end
def.static("table").OnSCommonErrorInfo = function(p)
  local text = textRes.Equip.OcpEquipment.SCommonErrorInfo[p.errorCode]
  if text then
    Toast(text)
  else
    warn(string.format("textRes.Equip.OcpEquipment.SCommonErrorInfo[%d] is nil", p.errorCode))
  end
end
def.static("table", "table").OnLeaveWorld = function()
  instance:Clear()
end
OcpEquipmentMgr.Commit()
return OcpEquipmentMgr

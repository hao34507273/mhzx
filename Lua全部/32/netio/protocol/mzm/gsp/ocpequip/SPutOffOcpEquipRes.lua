local SPutOffOcpEquipRes = class("SPutOffOcpEquipRes")
SPutOffOcpEquipRes.TYPEID = 12607746
function SPutOffOcpEquipRes:ctor(ocp, gender, key, itemId)
  self.id = 12607746
  self.ocp = ocp or nil
  self.gender = gender or nil
  self.key = key or nil
  self.itemId = itemId or nil
end
function SPutOffOcpEquipRes:marshal(os)
  os:marshalInt32(self.ocp)
  os:marshalInt32(self.gender)
  os:marshalInt32(self.key)
  os:marshalInt32(self.itemId)
end
function SPutOffOcpEquipRes:unmarshal(os)
  self.ocp = os:unmarshalInt32()
  self.gender = os:unmarshalInt32()
  self.key = os:unmarshalInt32()
  self.itemId = os:unmarshalInt32()
end
function SPutOffOcpEquipRes:sizepolicy(size)
  return size <= 65535
end
return SPutOffOcpEquipRes

local SPVEPetWheelFightStart = class("SPVEPetWheelFightStart")
SPVEPetWheelFightStart.TYPEID = 12594226
function SPVEPetWheelFightStart:ctor(recordid)
  self.id = 12594226
  self.recordid = recordid or nil
end
function SPVEPetWheelFightStart:marshal(os)
  os:marshalInt64(self.recordid)
end
function SPVEPetWheelFightStart:unmarshal(os)
  self.recordid = os:unmarshalInt64()
end
function SPVEPetWheelFightStart:sizepolicy(size)
  return size <= 65535
end
return SPVEPetWheelFightStart

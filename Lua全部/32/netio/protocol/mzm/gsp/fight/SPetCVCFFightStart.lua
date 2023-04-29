local SPetCVCFFightStart = class("SPetCVCFFightStart")
SPetCVCFFightStart.TYPEID = 12594237
function SPetCVCFFightStart:ctor(recordid)
  self.id = 12594237
  self.recordid = recordid or nil
end
function SPetCVCFFightStart:marshal(os)
  os:marshalInt64(self.recordid)
end
function SPetCVCFFightStart:unmarshal(os)
  self.recordid = os:unmarshalInt64()
end
function SPetCVCFFightStart:sizepolicy(size)
  return size <= 65535
end
return SPetCVCFFightStart

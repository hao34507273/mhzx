local CGenderConvert = class("CGenderConvert")
CGenderConvert.TYPEID = 12634370
function CGenderConvert:ctor()
  self.id = 12634370
end
function CGenderConvert:marshal(os)
end
function CGenderConvert:unmarshal(os)
end
function CGenderConvert:sizepolicy(size)
  return size <= 65535
end
return CGenderConvert

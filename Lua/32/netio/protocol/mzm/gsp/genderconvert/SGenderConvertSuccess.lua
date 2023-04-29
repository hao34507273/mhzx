local SGenderConvertSuccess = class("SGenderConvertSuccess")
SGenderConvertSuccess.TYPEID = 12634371
function SGenderConvertSuccess:ctor()
  self.id = 12634371
end
function SGenderConvertSuccess:marshal(os)
end
function SGenderConvertSuccess:unmarshal(os)
end
function SGenderConvertSuccess:sizepolicy(size)
  return size <= 65535
end
return SGenderConvertSuccess

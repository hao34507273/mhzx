local SGenderConvertFailed = class("SGenderConvertFailed")
SGenderConvertFailed.TYPEID = 12634369
SGenderConvertFailed.ERROR_LEVEL = -1
SGenderConvertFailed.ERROR_TEAM = -2
SGenderConvertFailed.ERROR_MARRIED = -3
SGenderConvertFailed.ERROR_CD = -4
SGenderConvertFailed.ERROR_MONEY = -5
SGenderConvertFailed.ERROR_SYSTEM = -6
SGenderConvertFailed.ERROR_IN_COUPLING_CORPS = -7
function SGenderConvertFailed:ctor(retcode)
  self.id = 12634369
  self.retcode = retcode or nil
end
function SGenderConvertFailed:marshal(os)
  os:marshalInt32(self.retcode)
end
function SGenderConvertFailed:unmarshal(os)
  self.retcode = os:unmarshalInt32()
end
function SGenderConvertFailed:sizepolicy(size)
  return size <= 65535
end
return SGenderConvertFailed

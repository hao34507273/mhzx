local BlessInfo = require("netio.protocol.mzm.gsp.bless.BlessInfo")
local SBlessSuccess = class("SBlessSuccess")
SBlessSuccess.TYPEID = 12614659
function SBlessSuccess:ctor(activity_cfgid, bless_info)
  self.id = 12614659
  self.activity_cfgid = activity_cfgid or nil
  self.bless_info = bless_info or BlessInfo.new()
end
function SBlessSuccess:marshal(os)
  os:marshalInt32(self.activity_cfgid)
  self.bless_info:marshal(os)
end
function SBlessSuccess:unmarshal(os)
  self.activity_cfgid = os:unmarshalInt32()
  self.bless_info = BlessInfo.new()
  self.bless_info:unmarshal(os)
end
function SBlessSuccess:sizepolicy(size)
  return size <= 65535
end
return SBlessSuccess

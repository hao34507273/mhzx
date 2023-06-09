local ParadeRoleInfo = require("netio.protocol.mzm.gsp.marriage.ParadeRoleInfo")
local SSynAllParadeMsg = class("SSynAllParadeMsg")
SSynAllParadeMsg.TYPEID = 12599861
function SSynAllParadeMsg:ctor(role1Info, role2Info, paradecfgid)
  self.id = 12599861
  self.role1Info = role1Info or ParadeRoleInfo.new()
  self.role2Info = role2Info or ParadeRoleInfo.new()
  self.paradecfgid = paradecfgid or nil
end
function SSynAllParadeMsg:marshal(os)
  self.role1Info:marshal(os)
  self.role2Info:marshal(os)
  os:marshalInt32(self.paradecfgid)
end
function SSynAllParadeMsg:unmarshal(os)
  self.role1Info = ParadeRoleInfo.new()
  self.role1Info:unmarshal(os)
  self.role2Info = ParadeRoleInfo.new()
  self.role2Info:unmarshal(os)
  self.paradecfgid = os:unmarshalInt32()
end
function SSynAllParadeMsg:sizepolicy(size)
  return size <= 65535
end
return SSynAllParadeMsg

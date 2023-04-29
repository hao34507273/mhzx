local ParadeRoleInfo = require("netio.protocol.mzm.gsp.marriage.ParadeRoleInfo")
local SBrocastRobMarriageParadeFail = class("SBrocastRobMarriageParadeFail")
SBrocastRobMarriageParadeFail.TYPEID = 12599853
function SBrocastRobMarriageParadeFail:ctor(failAttacker, role1Info, role2Info)
  self.id = 12599853
  self.failAttacker = failAttacker or ParadeRoleInfo.new()
  self.role1Info = role1Info or ParadeRoleInfo.new()
  self.role2Info = role2Info or ParadeRoleInfo.new()
end
function SBrocastRobMarriageParadeFail:marshal(os)
  self.failAttacker:marshal(os)
  self.role1Info:marshal(os)
  self.role2Info:marshal(os)
end
function SBrocastRobMarriageParadeFail:unmarshal(os)
  self.failAttacker = ParadeRoleInfo.new()
  self.failAttacker:unmarshal(os)
  self.role1Info = ParadeRoleInfo.new()
  self.role1Info:unmarshal(os)
  self.role2Info = ParadeRoleInfo.new()
  self.role2Info:unmarshal(os)
end
function SBrocastRobMarriageParadeFail:sizepolicy(size)
  return size <= 65535
end
return SBrocastRobMarriageParadeFail

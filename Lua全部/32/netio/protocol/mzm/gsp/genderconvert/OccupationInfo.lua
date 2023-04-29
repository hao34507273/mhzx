local OctetsStream = require("netio.OctetsStream")
local OccupationInfo = class("OccupationInfo")
function OccupationInfo:ctor(occupation, gender)
  self.occupation = occupation or nil
  self.gender = gender or nil
end
function OccupationInfo:marshal(os)
  os:marshalInt32(self.occupation)
  os:marshalInt32(self.gender)
end
function OccupationInfo:unmarshal(os)
  self.occupation = os:unmarshalInt32()
  self.gender = os:unmarshalInt32()
end
return OccupationInfo

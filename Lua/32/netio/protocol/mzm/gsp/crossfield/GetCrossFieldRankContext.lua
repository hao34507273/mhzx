local OctetsStream = require("netio.OctetsStream")
local GetCrossFieldRankContext = class("GetCrossFieldRankContext")
GetCrossFieldRankContext.OPER_TYPE_CLIENT_REQ = 0
GetCrossFieldRankContext.OPER_TYPE_RANK_AWARD = 1
function GetCrossFieldRankContext:ctor(oper_type, count, extra_info)
  self.oper_type = oper_type or nil
  self.count = count or nil
  self.extra_info = extra_info or nil
end
function GetCrossFieldRankContext:marshal(os)
  os:marshalUInt8(self.oper_type)
  os:marshalUInt8(self.count)
  os:marshalOctets(self.extra_info)
end
function GetCrossFieldRankContext:unmarshal(os)
  self.oper_type = os:unmarshalUInt8()
  self.count = os:unmarshalUInt8()
  self.extra_info = os:unmarshalOctets()
end
return GetCrossFieldRankContext

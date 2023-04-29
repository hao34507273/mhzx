local SNotifyTeamLeaderRecordFightEnd = class("SNotifyTeamLeaderRecordFightEnd")
SNotifyTeamLeaderRecordFightEnd.TYPEID = 12594239
function SNotifyTeamLeaderRecordFightEnd:ctor(recordid, extra_info)
  self.id = 12594239
  self.recordid = recordid or nil
  self.extra_info = extra_info or nil
end
function SNotifyTeamLeaderRecordFightEnd:marshal(os)
  os:marshalInt64(self.recordid)
  os:marshalOctets(self.extra_info)
end
function SNotifyTeamLeaderRecordFightEnd:unmarshal(os)
  self.recordid = os:unmarshalInt64()
  self.extra_info = os:unmarshalOctets()
end
function SNotifyTeamLeaderRecordFightEnd:sizepolicy(size)
  return size <= 65535
end
return SNotifyTeamLeaderRecordFightEnd

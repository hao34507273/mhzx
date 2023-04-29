local SSyncRealtimeRecordFightEndExtraInfo = class("SSyncRealtimeRecordFightEndExtraInfo")
SSyncRealtimeRecordFightEndExtraInfo.TYPEID = 12594232
function SSyncRealtimeRecordFightEndExtraInfo:ctor(recordid, fight_end_extra_info_content)
  self.id = 12594232
  self.recordid = recordid or nil
  self.fight_end_extra_info_content = fight_end_extra_info_content or nil
end
function SSyncRealtimeRecordFightEndExtraInfo:marshal(os)
  os:marshalInt64(self.recordid)
  os:marshalOctets(self.fight_end_extra_info_content)
end
function SSyncRealtimeRecordFightEndExtraInfo:unmarshal(os)
  self.recordid = os:unmarshalInt64()
  self.fight_end_extra_info_content = os:unmarshalOctets()
end
function SSyncRealtimeRecordFightEndExtraInfo:sizepolicy(size)
  return size <= 65535
end
return SSyncRealtimeRecordFightEndExtraInfo

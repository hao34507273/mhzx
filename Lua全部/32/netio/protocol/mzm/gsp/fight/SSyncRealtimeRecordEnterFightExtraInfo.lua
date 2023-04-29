local SSyncRealtimeRecordEnterFightExtraInfo = class("SSyncRealtimeRecordEnterFightExtraInfo")
SSyncRealtimeRecordEnterFightExtraInfo.TYPEID = 12594227
function SSyncRealtimeRecordEnterFightExtraInfo:ctor(recordid, enter_fight_extra_info_content)
  self.id = 12594227
  self.recordid = recordid or nil
  self.enter_fight_extra_info_content = enter_fight_extra_info_content or nil
end
function SSyncRealtimeRecordEnterFightExtraInfo:marshal(os)
  os:marshalInt64(self.recordid)
  os:marshalOctets(self.enter_fight_extra_info_content)
end
function SSyncRealtimeRecordEnterFightExtraInfo:unmarshal(os)
  self.recordid = os:unmarshalInt64()
  self.enter_fight_extra_info_content = os:unmarshalOctets()
end
function SSyncRealtimeRecordEnterFightExtraInfo:sizepolicy(size)
  return size <= 65535
end
return SSyncRealtimeRecordEnterFightExtraInfo

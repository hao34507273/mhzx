local SSyncRecordEnterFightExtraInfo = class("SSyncRecordEnterFightExtraInfo")
SSyncRecordEnterFightExtraInfo.TYPEID = 12594228
function SSyncRecordEnterFightExtraInfo:ctor(recordid, enter_fight_extra_info_content)
  self.id = 12594228
  self.recordid = recordid or nil
  self.enter_fight_extra_info_content = enter_fight_extra_info_content or nil
end
function SSyncRecordEnterFightExtraInfo:marshal(os)
  os:marshalInt64(self.recordid)
  os:marshalOctets(self.enter_fight_extra_info_content)
end
function SSyncRecordEnterFightExtraInfo:unmarshal(os)
  self.recordid = os:unmarshalInt64()
  self.enter_fight_extra_info_content = os:unmarshalOctets()
end
function SSyncRecordEnterFightExtraInfo:sizepolicy(size)
  return size <= 65535
end
return SSyncRecordEnterFightExtraInfo

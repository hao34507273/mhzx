local SSyncRecordFightEndExtraInfo = class("SSyncRecordFightEndExtraInfo")
SSyncRecordFightEndExtraInfo.TYPEID = 12594230
function SSyncRecordFightEndExtraInfo:ctor(recordid, fight_end_extra_info_content)
  self.id = 12594230
  self.recordid = recordid or nil
  self.fight_end_extra_info_content = fight_end_extra_info_content or nil
end
function SSyncRecordFightEndExtraInfo:marshal(os)
  os:marshalInt64(self.recordid)
  os:marshalOctets(self.fight_end_extra_info_content)
end
function SSyncRecordFightEndExtraInfo:unmarshal(os)
  self.recordid = os:unmarshalInt64()
  self.fight_end_extra_info_content = os:unmarshalOctets()
end
function SSyncRecordFightEndExtraInfo:sizepolicy(size)
  return size <= 65535
end
return SSyncRecordFightEndExtraInfo

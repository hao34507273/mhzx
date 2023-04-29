local SyncOcpGenderInfo = class("SyncOcpGenderInfo")
SyncOcpGenderInfo.TYPEID = 12634372
function SyncOcpGenderInfo:ctor(occpations, last_convert_time, is_guide_open)
  self.id = 12634372
  self.occpations = occpations or {}
  self.last_convert_time = last_convert_time or nil
  self.is_guide_open = is_guide_open or nil
end
function SyncOcpGenderInfo:marshal(os)
  os:marshalCompactUInt32(table.getn(self.occpations))
  for _, v in ipairs(self.occpations) do
    v:marshal(os)
  end
  os:marshalInt32(self.last_convert_time)
  os:marshalUInt8(self.is_guide_open)
end
function SyncOcpGenderInfo:unmarshal(os)
  for _size_ = os:unmarshalCompactUInt32(), 1, -1 do
    local BeanClazz = require("netio.protocol.mzm.gsp.genderconvert.OccupationInfo")
    local v = BeanClazz.new()
    v:unmarshal(os)
    table.insert(self.occpations, v)
  end
  self.last_convert_time = os:unmarshalInt32()
  self.is_guide_open = os:unmarshalUInt8()
end
function SyncOcpGenderInfo:sizepolicy(size)
  return size <= 65535
end
return SyncOcpGenderInfo

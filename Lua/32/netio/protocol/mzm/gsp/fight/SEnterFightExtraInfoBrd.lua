local SEnterFightExtraInfoBrd = class("SEnterFightExtraInfoBrd")
SEnterFightExtraInfoBrd.TYPEID = 12594231
SEnterFightExtraInfoBrd.ACTIVE_TEAM_INFO = 0
SEnterFightExtraInfoBrd.PASSIVE_TEAM_INFO = 1
function SEnterFightExtraInfoBrd:ctor(fightid, extra_infos)
  self.id = 12594231
  self.fightid = fightid or nil
  self.extra_infos = extra_infos or {}
end
function SEnterFightExtraInfoBrd:marshal(os)
  os:marshalInt64(self.fightid)
  local _size_ = 0
  for _, _ in pairs(self.extra_infos) do
    _size_ = _size_ + 1
  end
  os:marshalCompactUInt32(_size_)
  for k, v in pairs(self.extra_infos) do
    os:marshalInt32(k)
    os:marshalOctets(v)
  end
end
function SEnterFightExtraInfoBrd:unmarshal(os)
  self.fightid = os:unmarshalInt64()
  for _size_ = os:unmarshalCompactUInt32(), 1, -1 do
    local k = os:unmarshalInt32()
    local v = os:unmarshalOctets()
    self.extra_infos[k] = v
  end
end
function SEnterFightExtraInfoBrd:sizepolicy(size)
  return size <= 65535
end
return SEnterFightExtraInfoBrd

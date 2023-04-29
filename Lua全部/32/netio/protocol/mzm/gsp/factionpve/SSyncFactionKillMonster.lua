local SSyncFactionKillMonster = class("SSyncFactionKillMonster")
SSyncFactionKillMonster.TYPEID = 12613641
function SSyncFactionKillMonster:ctor(monsters)
  self.id = 12613641
  self.monsters = monsters or {}
end
function SSyncFactionKillMonster:marshal(os)
  local _size_ = 0
  for _, _ in pairs(self.monsters) do
    _size_ = _size_ + 1
  end
  os:marshalCompactUInt32(_size_)
  for k, v in pairs(self.monsters) do
    os:marshalInt32(k)
    os:marshalInt32(v)
  end
end
function SSyncFactionKillMonster:unmarshal(os)
  for _size_ = os:unmarshalCompactUInt32(), 1, -1 do
    local k = os:unmarshalInt32()
    local v = os:unmarshalInt32()
    self.monsters[k] = v
  end
end
function SSyncFactionKillMonster:sizepolicy(size)
  return size <= 65535
end
return SSyncFactionKillMonster

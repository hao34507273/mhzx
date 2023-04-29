local CSavePlan = class("CSavePlan")
CSavePlan.TYPEID = 12613893
function CSavePlan:ctor(genius_series_id, genius_skills)
  self.id = 12613893
  self.genius_series_id = genius_series_id or nil
  self.genius_skills = genius_skills or {}
end
function CSavePlan:marshal(os)
  os:marshalInt32(self.genius_series_id)
  local _size_ = 0
  for _, _ in pairs(self.genius_skills) do
    _size_ = _size_ + 1
  end
  os:marshalCompactUInt32(_size_)
  for k, v in pairs(self.genius_skills) do
    os:marshalInt32(k)
    os:marshalInt32(v)
  end
end
function CSavePlan:unmarshal(os)
  self.genius_series_id = os:unmarshalInt32()
  for _size_ = os:unmarshalCompactUInt32(), 1, -1 do
    local k = os:unmarshalInt32()
    local v = os:unmarshalInt32()
    self.genius_skills[k] = v
  end
end
function CSavePlan:sizepolicy(size)
  return size <= 65535
end
return CSavePlan

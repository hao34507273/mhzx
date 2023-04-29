local SSynTargetInfo = class("SSynTargetInfo")
SSynTargetInfo.TYPEID = 12596994
function SSynTargetInfo:ctor(targets)
  self.id = 12596994
  self.targets = targets or {}
end
function SSynTargetInfo:marshal(os)
  local _size_ = 0
  for _, _ in pairs(self.targets) do
    _size_ = _size_ + 1
  end
  os:marshalCompactUInt32(_size_)
  for k, v in pairs(self.targets) do
    os:marshalInt32(k)
    v:marshal(os)
  end
end
function SSynTargetInfo:unmarshal(os)
  for _size_ = os:unmarshalCompactUInt32(), 1, -1 do
    local k = os:unmarshalInt32()
    local BeanClazz = require("netio.protocol.mzm.gsp.grow.TargetInfo")
    local v = BeanClazz.new()
    v:unmarshal(os)
    self.targets[k] = v
  end
end
function SSynTargetInfo:sizepolicy(size)
  return size <= 65535
end
return SSynTargetInfo

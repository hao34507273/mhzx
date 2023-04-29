local SSyncPlayerScoreInfo = class("SSyncPlayerScoreInfo")
SSyncPlayerScoreInfo.TYPEID = 12629259
function SSyncPlayerScoreInfo:ctor(player_score_infos)
  self.id = 12629259
  self.player_score_infos = player_score_infos or {}
end
function SSyncPlayerScoreInfo:marshal(os)
  local _size_ = 0
  for _, _ in pairs(self.player_score_infos) do
    _size_ = _size_ + 1
  end
  os:marshalCompactUInt32(_size_)
  for k, v in pairs(self.player_score_infos) do
    os:marshalInt64(k)
    v:marshal(os)
  end
end
function SSyncPlayerScoreInfo:unmarshal(os)
  for _size_ = os:unmarshalCompactUInt32(), 1, -1 do
    local k = os:unmarshalInt64()
    local BeanClazz = require("netio.protocol.mzm.gsp.ballbattle.PlayerScoreInfo")
    local v = BeanClazz.new()
    v:unmarshal(os)
    self.player_score_infos[k] = v
  end
end
function SSyncPlayerScoreInfo:sizepolicy(size)
  return size <= 65535
end
return SSyncPlayerScoreInfo

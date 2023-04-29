local TeamInfo = require("netio.protocol.mzm.gsp.fight.TeamInfo")
local SSynPVEPetWheelFightStartInfo = class("SSynPVEPetWheelFightStartInfo")
SSynPVEPetWheelFightStartInfo.TYPEID = 12594233
function SSynPVEPetWheelFightStartInfo:ctor(sessionid, wheel_fight_cfg_id, team_info, active_pet_team_info, passive_pet_team_info)
  self.id = 12594233
  self.sessionid = sessionid or nil
  self.wheel_fight_cfg_id = wheel_fight_cfg_id or nil
  self.team_info = team_info or TeamInfo.new()
  self.active_pet_team_info = active_pet_team_info or {}
  self.passive_pet_team_info = passive_pet_team_info or {}
end
function SSynPVEPetWheelFightStartInfo:marshal(os)
  os:marshalInt64(self.sessionid)
  os:marshalInt32(self.wheel_fight_cfg_id)
  self.team_info:marshal(os)
  os:marshalCompactUInt32(table.getn(self.active_pet_team_info))
  for _, v in ipairs(self.active_pet_team_info) do
    v:marshal(os)
  end
  os:marshalCompactUInt32(table.getn(self.passive_pet_team_info))
  for _, v in ipairs(self.passive_pet_team_info) do
    v:marshal(os)
  end
end
function SSynPVEPetWheelFightStartInfo:unmarshal(os)
  self.sessionid = os:unmarshalInt64()
  self.wheel_fight_cfg_id = os:unmarshalInt32()
  self.team_info = TeamInfo.new()
  self.team_info:unmarshal(os)
  for _size_ = os:unmarshalCompactUInt32(), 1, -1 do
    local BeanClazz = require("netio.protocol.mzm.gsp.fight.PetFightTeamInfo")
    local v = BeanClazz.new()
    v:unmarshal(os)
    table.insert(self.active_pet_team_info, v)
  end
  for _size_ = os:unmarshalCompactUInt32(), 1, -1 do
    local BeanClazz = require("netio.protocol.mzm.gsp.fight.PetFightTeamInfo")
    local v = BeanClazz.new()
    v:unmarshal(os)
    table.insert(self.passive_pet_team_info, v)
  end
end
function SSynPVEPetWheelFightStartInfo:sizepolicy(size)
  return size <= 65535
end
return SSynPVEPetWheelFightStartInfo

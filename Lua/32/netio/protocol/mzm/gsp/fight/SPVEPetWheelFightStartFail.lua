local SPVEPetWheelFightStartFail = class("SPVEPetWheelFightStartFail")
SPVEPetWheelFightStartFail.TYPEID = 12594236
SPVEPetWheelFightStartFail.ROLE_IS_NOT_TEAM_LEADER = 1
SPVEPetWheelFightStartFail.SESSION_ID_NOT_MATCH = 2
SPVEPetWheelFightStartFail.DATA_IS_EXPIRED = 3
SPVEPetWheelFightStartFail.TEAM_CHANGE = 4
SPVEPetWheelFightStartFail.NO_PET_FIGHT_TEAM = 5
SPVEPetWheelFightStartFail.PET_FIGHT_TEAM_INFO_ERROR = 6
SPVEPetWheelFightStartFail.ENTER_FIGHT_ROLE_NUM_NOT_SATISFY = 7
function SPVEPetWheelFightStartFail:ctor(res, args)
  self.id = 12594236
  self.res = res or nil
  self.args = args or {}
end
function SPVEPetWheelFightStartFail:marshal(os)
  os:marshalInt32(self.res)
  os:marshalCompactUInt32(table.getn(self.args))
  for _, v in ipairs(self.args) do
    os:marshalString(v)
  end
end
function SPVEPetWheelFightStartFail:unmarshal(os)
  self.res = os:unmarshalInt32()
  for _size_ = os:unmarshalCompactUInt32(), 1, -1 do
    local v = os:unmarshalString()
    table.insert(self.args, v)
  end
end
function SPVEPetWheelFightStartFail:sizepolicy(size)
  return size <= 65535
end
return SPVEPetWheelFightStartFail

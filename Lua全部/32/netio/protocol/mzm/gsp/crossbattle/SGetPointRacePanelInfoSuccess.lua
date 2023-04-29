local SGetPointRacePanelInfoSuccess = class("SGetPointRacePanelInfoSuccess")
SGetPointRacePanelInfoSuccess.TYPEID = 12617047
function SGetPointRacePanelInfoSuccess:ctor(is_five_role_team, is_in_one_corps, is_can_join_point_race, is_role_same_with_sign_up)
  self.id = 12617047
  self.is_five_role_team = is_five_role_team or nil
  self.is_in_one_corps = is_in_one_corps or nil
  self.is_can_join_point_race = is_can_join_point_race or nil
  self.is_role_same_with_sign_up = is_role_same_with_sign_up or nil
end
function SGetPointRacePanelInfoSuccess:marshal(os)
  os:marshalUInt8(self.is_five_role_team)
  os:marshalUInt8(self.is_in_one_corps)
  os:marshalUInt8(self.is_can_join_point_race)
  os:marshalUInt8(self.is_role_same_with_sign_up)
end
function SGetPointRacePanelInfoSuccess:unmarshal(os)
  self.is_five_role_team = os:unmarshalUInt8()
  self.is_in_one_corps = os:unmarshalUInt8()
  self.is_can_join_point_race = os:unmarshalUInt8()
  self.is_role_same_with_sign_up = os:unmarshalUInt8()
end
function SGetPointRacePanelInfoSuccess:sizepolicy(size)
  return size <= 65535
end
return SGetPointRacePanelInfoSuccess

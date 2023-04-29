local CBetInSelectionReq = class("CBetInSelectionReq")
CBetInSelectionReq.TYPEID = 12617044
function CBetInSelectionReq:ctor(activity_cfg_id, fight_zone_id, selection_stage, fight_index, target_corps_id, sortid)
  self.id = 12617044
  self.activity_cfg_id = activity_cfg_id or nil
  self.fight_zone_id = fight_zone_id or nil
  self.selection_stage = selection_stage or nil
  self.fight_index = fight_index or nil
  self.target_corps_id = target_corps_id or nil
  self.sortid = sortid or nil
end
function CBetInSelectionReq:marshal(os)
  os:marshalInt32(self.activity_cfg_id)
  os:marshalInt32(self.fight_zone_id)
  os:marshalInt32(self.selection_stage)
  os:marshalInt32(self.fight_index)
  os:marshalInt64(self.target_corps_id)
  os:marshalInt32(self.sortid)
end
function CBetInSelectionReq:unmarshal(os)
  self.activity_cfg_id = os:unmarshalInt32()
  self.fight_zone_id = os:unmarshalInt32()
  self.selection_stage = os:unmarshalInt32()
  self.fight_index = os:unmarshalInt32()
  self.target_corps_id = os:unmarshalInt64()
  self.sortid = os:unmarshalInt32()
end
function CBetInSelectionReq:sizepolicy(size)
  return size <= 65535
end
return CBetInSelectionReq

local CResetSubSkill = class("CResetSubSkill")
CResetSubSkill.TYPEID = 12596512
function CResetSubSkill:ctor(index, skillIndex, subSkillIndex, isUseYuanbao, clientYuanbaoNum, clientNeedYuanbaoNum)
  self.id = 12596512
  self.index = index or nil
  self.skillIndex = skillIndex or nil
  self.subSkillIndex = subSkillIndex or nil
  self.isUseYuanbao = isUseYuanbao or nil
  self.clientYuanbaoNum = clientYuanbaoNum or nil
  self.clientNeedYuanbaoNum = clientNeedYuanbaoNum or nil
end
function CResetSubSkill:marshal(os)
  os:marshalInt32(self.index)
  os:marshalInt32(self.skillIndex)
  os:marshalInt32(self.subSkillIndex)
  os:marshalInt32(self.isUseYuanbao)
  os:marshalInt64(self.clientYuanbaoNum)
  os:marshalInt32(self.clientNeedYuanbaoNum)
end
function CResetSubSkill:unmarshal(os)
  self.index = os:unmarshalInt32()
  self.skillIndex = os:unmarshalInt32()
  self.subSkillIndex = os:unmarshalInt32()
  self.isUseYuanbao = os:unmarshalInt32()
  self.clientYuanbaoNum = os:unmarshalInt64()
  self.clientNeedYuanbaoNum = os:unmarshalInt32()
end
function CResetSubSkill:sizepolicy(size)
  return size <= 65535
end
return CResetSubSkill

local SGetCoupleDailyInfo = class("SGetCoupleDailyInfo")
SGetCoupleDailyInfo.TYPEID = 12602380
function SGetCoupleDailyInfo:ctor(taskList, finishTaskList, isAward)
  self.id = 12602380
  self.taskList = taskList or {}
  self.finishTaskList = finishTaskList or {}
  self.isAward = isAward or nil
end
function SGetCoupleDailyInfo:marshal(os)
  os:marshalCompactUInt32(table.getn(self.taskList))
  for _, v in ipairs(self.taskList) do
    os:marshalInt32(v)
  end
  os:marshalCompactUInt32(table.getn(self.finishTaskList))
  for _, v in ipairs(self.finishTaskList) do
    os:marshalInt32(v)
  end
  os:marshalInt32(self.isAward)
end
function SGetCoupleDailyInfo:unmarshal(os)
  for _size_ = os:unmarshalCompactUInt32(), 1, -1 do
    local v = os:unmarshalInt32()
    table.insert(self.taskList, v)
  end
  for _size_ = os:unmarshalCompactUInt32(), 1, -1 do
    local v = os:unmarshalInt32()
    table.insert(self.finishTaskList, v)
  end
  self.isAward = os:unmarshalInt32()
end
function SGetCoupleDailyInfo:sizepolicy(size)
  return size <= 65535
end
return SGetCoupleDailyInfo

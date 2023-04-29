local Lplus = require("Lplus")
local GroupOperationBase = require("Main.Group.operations.GroupOperationBase")
local GroupDissolveOperation = Lplus.Extend(GroupOperationBase, "GroupDissolveOperation")
local def = GroupDissolveOperation.define
def.field("userdata").m_GroupId = nil
def.override("userdata", "=>", "boolean").CanOperate = function(self, groupId)
  if nil == groupId then
    return false
  end
  local isGroupMaster = require("Main.Group.GroupModule").Instance():IsGroupMaster(groupId)
  if not isGroupMaster then
    return false
  end
  self.m_GroupId = groupId
  return true
end
def.override("=>", "string").GetOperationName = function(self)
  return textRes.Group.OperationName[3]
end
def.override("=>", "boolean").Operate = function(self)
  if nil == self.m_GroupId then
    return false
  end
  local GroupModule = require("Main.Group.GroupModule")
  local GroupProtocolMgr = require("Main.Group.GroupProtocolMgr")
  if not GroupModule.Instance():IsGroupExist(self.m_GroupId) then
    return false
  end
  local CommonConfirmDlg = require("GUI.CommonConfirmDlg")
  local basicInfo = GroupModule.Instance():GetGroupBasicInfo(self.m_GroupId)
  CommonConfirmDlg.ShowConfirm("", string.format(textRes.Group[26], basicInfo.groupName), function(select, tag)
    if 1 == select then
      GroupProtocolMgr.CDissolveGroupReq(self.m_GroupId)
    end
  end, nil)
  return true
end
GroupDissolveOperation.Commit()
return GroupDissolveOperation

local CUR_CLASS_NAME = (...)
local Lplus = require("Lplus")
local Operation = import(".Operation")
local OpenPresentPanelGift = Lplus.Extend(Operation, CUR_CLASS_NAME)
local def = OpenPresentPanelGift.define
def.override("table", "=>", "boolean").Operate = function(self, params)
  local list = require("Main.friend.FriendData").Instance():GetFriendList()
  if #list < 1 then
    Toast(textRes.Item[146])
    return true
  end
  Event.DispatchEvent(ModuleId.FRIEND, gmodule.notifyId.Friend.Friend_OnPresent, {1, nil})
  return false
end
return OpenPresentPanelGift.Commit()

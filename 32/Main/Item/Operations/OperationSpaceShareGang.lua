local Lplus = require("Lplus")
local OperationSpaceShareBase = require("Main.Item.Operations.OperationSpaceShareBase")
local ItemTipsMgr = require("Main.Item.ItemTipsMgr")
local EquipUtils = require("Main.Equip.EquipUtils")
local ItemModule = require("Main.Item.ItemModule")
local HtmlHelper = require("Main.Chat.HtmlHelper")
local ChatModule = require("Main.Chat.ChatModule")
local ChatConst = require("netio.protocol.mzm.gsp.chat.ChatConsts")
local OperationSpaceShareGang = Lplus.Extend(OperationSpaceShareBase, "OperationSpaceShareGang")
local def = OperationSpaceShareGang.define
def.override("number", "table", "table", "=>", "boolean").CanDispaly = function(self, source, item, itemBase)
  return true
end
def.override("=>", "string").GetOperationName = function(self)
  return textRes.Item[9523]
end
def.override("number", "number", "userdata", "table", "=>", "boolean").Operate = function(self, bagId, itemKey, m_panel, context)
  local content = self:ConvertChannelContent(context)
  ChatModule.Instance():SendChannelMsg(content, ChatConst.CHANNEL_FACTION, false)
  return true
end
OperationSpaceShareGang.Commit()
return OperationSpaceShareGang

local Lplus = require("Lplus")
local OperationBase = require("Main.Item.Operations.OperationBase")
local ItemTipsMgr = require("Main.Item.ItemTipsMgr")
local EquipUtils = require("Main.Equip.EquipUtils")
local ItemModule = require("Main.Item.ItemModule")
local HtmlHelper = require("Main.Chat.HtmlHelper")
local ChatModule = require("Main.Chat.ChatModule")
local ChatConst = require("netio.protocol.mzm.gsp.chat.ChatConsts")
local OperationSpaceShareBase = Lplus.Extend(OperationBase, "OperationSpaceShareBase")
local def = OperationSpaceShareBase.define
def.override("number", "table", "table", "=>", "boolean").CanDispaly = function(self, source, item, itemBase)
  return true
end
def.override("=>", "string").GetOperationName = function(self)
  return ""
end
def.override("number", "number", "userdata", "table", "=>", "boolean").Operate = function(self, bagId, itemKey, m_panel, context)
  return true
end
def.method("table", "=>", "string").ConvertChannelContent = function(self, context)
  local content = string.format("{ssmoment:%s,%s,%s}", context.ownerName, context.ownerId:tostring(), context.msgId:tostring())
  return content
end
OperationSpaceShareBase.Commit()
return OperationSpaceShareBase

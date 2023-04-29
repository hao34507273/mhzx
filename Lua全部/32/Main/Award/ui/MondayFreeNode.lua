local CUR_CLASS_NAME = (...)
local Lplus = require("Lplus")
local ECPanelBase = require("GUI.ECPanelBase")
local AloneNodeBase = require("Main.Award.ui.AloneNodeBase")
local MondayFreeNode = Lplus.Extend(AloneNodeBase, CUR_CLASS_NAME)
local MondayFreeMgr = require("Main.Award.mgr.MondayFreeMgr")
local def = MondayFreeNode.define
def.override(ECPanelBase, "userdata").Init = function(self, base, node)
  AloneNodeBase.Init(self, base, node)
end
def.override("=>", "boolean").IsOpen = function(self)
  return MondayFreeMgr.Instance():IsOpen()
end
def.override("=>", "boolean").IsHaveNotifyMessage = function(self)
  return MondayFreeMgr.Instance():IsHaveNotifyMessage()
end
def.override("=>", ECPanelBase).CreatePanel = function(self)
  self.panel = require("Main.Award.ui.MondayFreePanel").Instance()
  self.panel:ShowPanel()
  return self.panel
end
return MondayFreeNode.Commit()

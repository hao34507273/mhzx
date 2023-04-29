local Lplus = require("Lplus")
local ECPanelBase = require("GUI.ECPanelBase")
local WaitingTipCountDown = Lplus.Extend(ECPanelBase, "WaitingTipCountDown")
local EC = require("Types.Vector3")
local def = WaitingTipCountDown.define
def.field("string")._tip = ""
def.field("table").uiObjs = nil
def.field("number")._timerId = -1
def.field("number")._leftTime = 0
def.static("string", "number").ShowTip = function(content, duration)
  local self = WaitingTipCountDown._Instance()
  self._tip = content
  self._leftTime = duration
  if self.m_panel ~= nil and not self.m_panel.isnil then
    return
  end
  self:CreatePanel(RESPATH.PREFAB_COMMON_WAITING_PANEL, 0)
  self:SetModal(true)
end
def.static().HideTip = function()
  local self = WaitingTipCountDown._Instance()
  self:DestroyPanel()
end
local instance
def.static("=>", WaitingTipCountDown)._Instance = function()
  if instance == nil then
    instance = WaitingTipCountDown()
  end
  return instance
end
def.override().OnCreate = function(self)
  self:InitUI()
  self:UpdateTip()
  self:CreateTimer()
end
def.method().InitUI = function(self)
  self.uiObjs = {}
  self.uiObjs.Img_Bg0 = self.m_panel:FindDirect("Img_Bg0")
  self.uiObjs.Tex_Beauty = self.uiObjs.Img_Bg0:FindDirect("Tex_Beauty")
  self.uiObjs.Label = self.uiObjs.Img_Bg0:FindDirect("Label")
  self.uiObjs.Label.localPosition = EC.Vector3.zero
  self.m_panel:FindDirect("Img_Bg0/Container"):SetActive(false)
end
def.method().CreateTimer = function(self)
  self._timerId = GameUtil.AddGlobalTimer(1, false, function()
    self:UpdateTimer()
  end)
end
def.method().UpdateTimer = function(self)
  if self._leftTime <= 0 then
    self:DestroyPanel()
    return
  end
  self._leftTime = self._leftTime - 1
  self:UpdateTip()
end
def.override().OnDestroy = function(self)
  GameUtil.RemoveGlobalTimer(self._timerId)
  self._tip = ""
  self.uiObjs = nil
  self._timerId = -1
  self._leftTime = 0
end
def.method().UpdateTip = function(self)
  self.uiObjs.Label:GetComponent("UILabel").text = self._tip .. string.format("(%ds)", self._leftTime)
end
def.method("=>", "boolean").IsExistPanel = function(self)
  return self.m_panel ~= nil and not self.m_panel.isnil
end
WaitingTipCountDown.Commit()
return WaitingTipCountDown

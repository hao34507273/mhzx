local Lplus = require("Lplus")
local TransSexTestMgr = Lplus.Class("TransSexTestMgr")
local def = TransSexTestMgr.define
local instance
def.static("=>", TransSexTestMgr).Instance = function()
  if instance == nil then
    instance = TransSexTestMgr()
  end
  return instance
end
local clickCount = 0
local testMap
def.method().Init = function(self)
  self:RegisterTests()
  self:RegisterEvents()
end
def.method().RegisterTests = function(self)
  testMap = {}
  testMap[0] = {
    TransSexTestMgr.TestToast,
    TransSexTestMgr.TestTransSucc
  }
  testMap[1] = {}
  testMap[2] = {}
end
def.method().RegisterEvents = function(self)
  Event.RegisterEvent(ModuleId.LOGIN, gmodule.notifyId.Login.LEAVE_WORLD, TransSexTestMgr.OnLeaveWorld)
  Event.RegisterEvent(ModuleId.PUBROLE, gmodule.notifyId.Pubrole.HERO_CLICKMAP_FINDPATH, TransSexTestMgr.OnClickMapFindpath)
end
def.static("table", "table").OnLeaveWorld = function(param, context)
  clickCount = 0
end
def.static("table", "table").OnClickMapFindpath = function(param, context)
  clickCount = clickCount + 1
  local funcList = testMap[0]
  if funcList and #funcList > 0 then
    for _, func in ipairs(funcList) do
      func(param)
    end
  end
  local funcList = testMap[clickCount]
  if funcList and #funcList > 0 then
    for _, func in ipairs(funcList) do
      func(param)
    end
  end
end
def.static("table").TestTransSucc = function(param)
  warn("[TransSexTestMgr:TestTransSucc] TestTransSucc.")
  local heroProp = _G.GetHeroProp()
  if heroProp == nil then
    warn("[ERROR][TransSexTestMgr:TestTransSucc] heroProp NIL.")
    return
  end
  local GenderEnum = require("consts.mzm.gsp.occupation.confbean.SGenderEnum")
  local occupation = heroProp.occupation
  local gender = heroProp.gender
  if gender == GenderEnum.MALE then
    gender = GenderEnum.FEMALE
  else
    gender = GenderEnum.MALE
  end
  Event.DispatchEvent(ModuleId.TRANS_SEX, gmodule.notifyId.TransSex.TRANS_SEX_SUCESS, {occupation = occupation, gender = gender})
end
def.static("table").TestChatLink = function(param)
  warn("[TransSexTestMgr:TestChatLink] TestChatLink.")
  local ChatUtils = require("Main.Chat.ChatUtils")
  ChatUtils.GetChatLinkCount("test")
end
def.static("table").TestChat = function(param)
  warn("[TransSexTestMgr:TestChat] TestChat.")
  local ChatConst = require("netio.protocol.mzm.gsp.chat.ChatConsts")
  require("Main.Chat.ChatModule").Instance():SendChannelMsg("111", ChatConst.CHANNEL_ACTIVITY, false)
end
def.static("table").TestBullet = function(param)
  warn("[TransSexTestMgr:TestBullet] TestBullet.")
  require("Main.Chat.ScreenBulletMgr").Instance():SendMapBullet("111")
end
def.static("table").TestToast = function(param)
  warn("[TransSexTestMgr:TestToast] TestToast.")
  for i = 1, 10000 do
    Toast(tostring(i))
  end
end
def.static("table").TestSyncInfos = function(param)
  warn("[TransSexTestMgr:TestSyncInfos] TestSyncInfos.")
  local p = {}
  p.last_convert_time = 0
  p.occpations = {}
  table.insert(p.occpations, {occupation = 1, gender = 2})
  table.insert(p.occpations, {occupation = 3, gender = 2})
  local TransSexProtocols = require("Main.TransSex.TransSexProtocols")
  TransSexProtocols.OnSyncOcpGenderInfo(p)
end
def.static("table").TestLoading = function(param)
  warn("[TransSexTestMgr:TestLoading] TestLoading.")
  local heroProp = _G.GetHeroProp()
  if heroProp == nil then
    warn("[ERROR][TransSexTestMgr:TestLoading] heroProp NIL.")
    return
  end
  local GenderEnum = require("consts.mzm.gsp.occupation.confbean.SGenderEnum")
  local occupation = heroProp.occupation
  local gender = heroProp.gender
  require("Main.TransSex.TransSexMgr").Instance():ReconnectAs(occupation, gender)
end
def.static("table").TestNPCService = function(param)
  warn("[TransSexTestMgr:TestNPCService] TestNPCService.")
  Event.DispatchEvent(ModuleId.NPC, gmodule.notifyId.NPC.NPC_SERVICE, {
    constant.CGenderConvertConsts.CONVERT_SERVICE,
    constant.CGenderConvertConsts.NPC_CFG_ID
  })
end
TransSexTestMgr.Commit()
return TransSexTestMgr

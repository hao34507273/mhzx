local Lplus = require("Lplus")
local TransSexData = require("Main.TransSex.data.TransSexData")
local TransSexProtocols = Lplus.Class("TransSexProtocols")
local def = TransSexProtocols.define
def.static().RegisterProtocols = function()
  gmodule.network.registerProtocol("netio.protocol.mzm.gsp.genderconvert.SyncOcpGenderInfo", TransSexProtocols.OnSyncOcpGenderInfo)
  gmodule.network.registerProtocol("netio.protocol.mzm.gsp.genderconvert.SGenderConvertSuccess", TransSexProtocols.OnSGenderConvertSuccess)
  gmodule.network.registerProtocol("netio.protocol.mzm.gsp.genderconvert.SGenderConvertFailed", TransSexProtocols.OnSGenderConvertFailed)
end
def.static("table").OnSyncOcpGenderInfo = function(p)
  warn("[TransSexProtocols:OnSyncOcpGenderInfo] On SyncOcpGenderInfo:", p.occpations and #p.occpations or 0, p.last_convert_time, p.is_guide_open)
  TransSexData.Instance():SyncTransSexInfo(p)
end
def.static().SendCGenderConvert = function()
  warn("[TransSexProtocols:SendCGenderConvert] Send CGenderConvert.")
  local p = require("netio.protocol.mzm.gsp.genderconvert.CGenderConvert").new()
  gmodule.network.sendProtocol(p)
end
def.static("table").OnSGenderConvertSuccess = function(p)
  warn("[TransSexProtocols:OnSGenderConvertSuccess] On SGenderConvertSuccess.")
  local heroProp = _G.GetHeroProp()
  if heroProp == nil then
    warn("[ERROR][TransSexProtocols:OnSGenderConvertSuccess] heroProp NIL.")
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
def.static("table").OnSGenderConvertFailed = function(p)
  warn("[TransSexProtocols:OnSGenderConvertFailed] On SGenderConvertFailed! p.retcode:", p.retcode)
  local SGenderConvertFailed = require("netio.protocol.mzm.gsp.genderconvert.SGenderConvertFailed")
  local errString = textRes.TransSex.SGenderConvertFailed[p.retcode]
  if p.retcode == SGenderConvertFailed.ERROR_CD and errString then
    errString = string.format(errString, constant.CGenderConvertConsts.CONVERT_CD_IN_HOUR)
  end
  if errString then
    Toast(errString)
  end
end
TransSexProtocols.Commit()
return TransSexProtocols

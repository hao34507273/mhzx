local Lplus = require("Lplus")
local ModuleFunSwitchInfo = require("netio.protocol.mzm.gsp.open.ModuleFunSwitchInfo")
local TransSexUtils = Lplus.Class("TransSexUtils")
local def = TransSexUtils.define
def.static("number", "number", "=>", "string").GetLoadingImage = function(occupation, gender)
  return string.format("Arts/Image/Icons/Loading/menpai_%d_%d.png.u3dext", occupation, gender)
end
def.static("number", "number", "=>", "string").GetOccpGenderName = function(occupation, gender)
  local name = _G.GetOccupationName(occupation)
  if name and _G.IsFeatureOpen(ModuleFunSwitchInfo.TYPE_GENDER_CONVERT) and textRes.TransSex.TRANS_SEX_GENDER[gender] then
    name = name .. textRes.TransSex.TRANS_SEX_GENDER[gender]
  end
  return name
end
def.static("=>", "string").GetCurOccpGenderName = function()
  local result = ""
  local heroProp = _G.GetHeroProp()
  if heroProp then
    result = TransSexUtils.GetOccpGenderName(heroProp.occupation, heroProp.gender)
  end
  return result
end
TransSexUtils.Commit()
return TransSexUtils

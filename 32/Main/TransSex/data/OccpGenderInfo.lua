local CUR_CLASS_NAME = (...)
local Lplus = require("Lplus")
local OccpGenderInfo = Lplus.Class(CUR_CLASS_NAME)
local def = OccpGenderInfo.define
def.field("number").occupation = 0
def.field("number").gender = 0
def.final("number", "number", "=>", OccpGenderInfo).new = function(occupation, gender)
  local info = OccpGenderInfo()
  info.occupation = occupation
  info.gender = gender
  return info
end
def.virtual("=>", "string").GetName = function(self)
  local name = require("Main.TransSex.TransSexUtils").GetOccpGenderName(self.occupation, self.gender)
  local heroProp = _G.GetHeroProp()
  if name and heroProp and heroProp.occupation == self.occupation and heroProp.gender == self.gender then
    name = string.format("%s%s", name, textRes.Equip.OcpEquipment[1])
  end
  return name
end
return OccpGenderInfo.Commit()

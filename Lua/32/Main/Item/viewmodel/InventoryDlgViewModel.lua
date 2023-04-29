local Lplus = require("Lplus")
local OcpEquipmentMgr = require("Main.Equip.OcpEquipmentMgr")
local ModelInfo = require("netio.protocol.mzm.gsp.pubdata.ModelInfo")
local WearPos = require("consts.mzm.gsp.item.confbean.WearPos")
local ItemXStoreType = require("netio.protocol.mzm.gsp.item.ItemXStoreType")
local FashionDressConst = require("netio.protocol.mzm.gsp.fashiondress.FashionDressConst")
local EquipUtils = require("Main.Equip.EquipUtils")
local Feature = require("netio.protocol.mzm.gsp.open.ModuleFunSwitchInfo")
local TransSexData = require("Main.TransSex.data.TransSexData")
local InventoryDlgViewModel = Lplus.Class("InventoryDlgViewModel")
local def = InventoryDlgViewModel.define
local instance
def.static("=>", InventoryDlgViewModel).Instance = function()
  if instance == nil then
    instance = InventoryDlgViewModel()
  end
  return instance
end
def.method("=>", "boolean").IsMultiOccupationOpen = function(self)
  local isOpen = _G.IsFeatureOpen(Feature.TYPE_MULTI_OCCUPATION) or _G.IsFeatureOpen(Feature.TYPE_GENDER_CONVERT)
  return isOpen
end
def.method("number", "number", "=>", "table").GetOccupationEquipments = function(self, occupation, gender)
  local heroProp = _G.GetHeroProp()
  local heroEquipments = gmodule.moduleMgr:GetModule(ModuleId.ITEM):GetHeroEquipments()
  if heroProp.occupation == occupation and heroProp.gender == gender then
    return heroEquipments
  else
    local equipments = OcpEquipmentMgr.Instance():GetOccupationEquipments(occupation, gender)
    return equipments
  end
end
def.method("number", "number", "number", "=>", "number", "table").GetEquipmentByPosition = function(self, occupation, gender, position)
  local ItemModule = require("Main.Item.ItemModule")
  local heroProp = _G.GetHeroProp()
  if heroProp.occupation == occupation and heroProp.gender == gender then
    return ItemModule.Instance():GetItemByPosition(ItemModule.EQUIPBAG, position)
  else
    local equipments = self:GetOccupationEquipments(occupation, gender)
    if equipments then
      for k, v in pairs(equipments) do
        if v.position == position then
          return k, v
        end
      end
    end
    return -1, nil
  end
end
def.method("=>", "table").GetOwnOccpGenderInfos = function(self)
  local result
  if _G.IsFeatureOpen(Feature.TYPE_GENDER_CONVERT) then
    result = TransSexData.Instance():GetOwnOccpGenderInfos()
  else
    local heroProp = _G.GetHeroProp()
    result = TransSexData.Instance():GetOccpGenderInfosByGender(heroProp.gender)
  end
  return result
end
def.method("number", "number", "=>", "number").GetOccupationModelId = function(self, ocp, gender)
  local heroProp = _G.GetHeroProp()
  local modelId = gmodule.moduleMgr:GetModule(ModuleId.HERO):GetMyModelId()
  if heroProp.occupation ~= ocp or heroProp.gender ~= gender then
    local ocpCfg = _G.GetOccupationCfg(ocp, gender)
    if ocpCfg then
      modelId = ocpCfg.modelId
    end
  end
  return modelId
end
def.method("number", "number", "=>", "table").GetOccupationModelInfo = function(self, ocp, gender)
  local heroProp = _G.GetHeroProp()
  local modelInfo = gmodule.moduleMgr:GetModule(ModuleId.PUBROLE):GetRoleModelInfo(gmodule.moduleMgr:GetModule(ModuleId.HERO).roleId)
  if heroProp.occupation ~= ocp or heroProp.gender ~= gender then
    modelInfo = clone(modelInfo)
    local LoginUtility = require("Main.Login.LoginUtility")
    local createRoleCfg = LoginUtility.GetCreateRoleCfg(ocp, gender)
    modelInfo.extraMap[ModelInfo.HAIR_COLOR_ID] = createRoleCfg.defaultHairDryId
    modelInfo.extraMap[ModelInfo.CLOTH_COLOR_ID] = createRoleCfg.defaultClothDryId
    modelInfo.extraMap[ModelInfo.FASHION_DRESS_ID] = FashionDressConst.NO_FASHION_DRESS
    modelInfo.extraMap[ModelInfo.QILING_EFFECT_LEVEL] = self:GetOcpQiLingEffectLevel(ocp, gender)
    modelInfo.extraMap[ModelInfo.WEAPON] = nil
    local occupationBag = OcpEquipmentMgr.Instance():GetOccupationBag(ocp, gender)
    if occupationBag then
      local item = occupationBag.items[WearPos.WEAPON]
      if item then
        modelInfo.extraMap[ModelInfo.WEAPON] = item.id
        modelInfo.extraMap[ModelInfo.QILING_LEVEL] = item.extraMap[ItemXStoreType.STRENGTH_LEVEL] or 0
      end
    end
    local try_evaluate = function(dst, src, key)
      dst[key] = src[key] and src[key] or dst[key]
    end
    local socpModelInfo = OcpEquipmentMgr.Instance():GetOccupationModelInfo(ocp, gender)
    if socpModelInfo then
      try_evaluate(modelInfo.extraMap, socpModelInfo.extraMap, ModelInfo.HAIR_COLOR_ID)
      try_evaluate(modelInfo.extraMap, socpModelInfo.extraMap, ModelInfo.CLOTH_COLOR_ID)
      try_evaluate(modelInfo.extraMap, socpModelInfo.extraMap, ModelInfo.FASHION_DRESS_ID)
    end
  end
  return modelInfo
end
def.method("number", "number", "=>", "number").GetOcpQiLingEffectLevel = function(self, ocp, gender)
  local equipments = self:GetOccupationEquipments(ocp, gender)
  return EquipUtils.CalcQiLingEffectLevel(equipments)
end
def.method("number", "number", "function").AsyncLoadOccupationEquipments = function(self, occupation, gender, onFinish)
  OcpEquipmentMgr.Instance():AsyncGetOccupationEquipments(occupation, gender, function(equipments)
    if onFinish then
      onFinish(equipments)
    end
  end)
end
def.method().Clear = function(self)
  OcpEquipmentMgr.Instance():Clear()
end
InventoryDlgViewModel.Commit()
return InventoryDlgViewModel

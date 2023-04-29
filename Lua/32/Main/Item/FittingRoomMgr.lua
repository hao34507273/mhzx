local Lplus = require("Lplus")
local FittingRoomMgr = Lplus.Class("FittingRoomMgr")
local ECPanelBase = require("GUI.ECPanelBase")
local HeroModule = require("Main.Hero.HeroModule")
local ItemModule = require("Main.Item.ItemModule")
local ECUIModel = require("Model.ECUIModel")
local ItemUtils = require("Main.Item.ItemUtils")
local FashionUtils = require("Main.Fashion.FashionUtils")
local DecorationUtils = require("Main.GodWeapon.Decoration.DecorationUtils")
local DecorationData = require("Main.GodWeapon.Decoration.data.DecorationData")
local FabaoSpiritUtils = require("Main.FabaoSpirit.FabaoSpiritUtils")
local FabaoSpiritInterface = require("Main.FabaoSpirit.FabaoSpiritInterface")
local ItemType = require("consts.mzm.gsp.item.confbean.ItemType")
local Vector = require("Types.Vector")
local FabaoUtils = require("Main.Fabao.FabaoUtils")
local def = FittingRoomMgr.define
local _instance
def.field("number").mItemId = -1
def.field("number").mItemType = -1
def.field("string").mName = ""
def.field("table").mExtInfo = nil
def.field("number").mWingId = -1
def.field("number").mDyeId = -1
def.field("boolean").mViewType = false
def.field("table").itemModel = nil
def.field(ECUIModel).mUIModel = nil
def.field("function").closeCallback = nil
def.field("userdata").model = nil
def.field("table").position = nil
def.static("=>", FittingRoomMgr).Instance = function()
  if _instance == nil then
    _instance = FittingRoomMgr()
  end
  return _instance
end
def.method("userdata", "string", "number", "number", "table", "=>", ECUIModel).ShowHeroTryModel = function(self, model, panelName, itemId, itemType, position)
  self:DestroyAllModels()
  self.mItemId = itemId
  self.mItemType = itemType
  local uiModel = model:GetComponent("UIModel")
  if uiModel == nil or uiModel.isnil then
    return
  end
  local heroProp = require("Main.Hero.Interface").GetHeroProp()
  if heroProp == nil then
    return
  end
  if self.mItemType == ItemType.AIR_CRAFT_ITEM then
    model.transform.localScale = Vector.Vector3.new(0.8, 0.8, 0.8)
    do
      local aircraftId = ItemUtils.GetFeijianItem(itemId).aircraftId
      local AircraftData = require("Main.Aircraft.data.AircraftData")
      local AircraftUIModel = require("Main.Aircraft.ui.AircraftUIModel")
      local colorId = AircraftData.Instance():GetAircraftColor(aircraftId)
      local tattooIcon = AircraftData.Instance():GetAircraftTattoo(aircraftId)
      local modelId = gmodule.moduleMgr:GetModule(ModuleId.HERO):GetMyModelId()
      local heroModel = ECUIModel.new(modelId)
      self.mUIModel = heroModel
      local aircraftModel = AircraftUIModel.new(aircraftId, colorId, tattooIcon, uiModel)
      aircraftModel:LoadWithCB(function(model)
        if _G.IsNil(model) then
          return
        end
        modelId = gmodule.moduleMgr:GetModule(ModuleId.HERO):GetMyModelId()
        heroModel = ECUIModel.new(modelId)
        local modelInfo = gmodule.moduleMgr:GetModule(ModuleId.PUBROLE):GetRoleModelInfo(gmodule.moduleMgr:GetModule(ModuleId.HERO).roleId)
        if modelInfo then
          local ModelInfo = require("netio.protocol.mzm.gsp.pubdata.ModelInfo")
          modelInfo.extraMap[ModelInfo.MAGIC_MARK] = nil
        end
        local function AfterModelLoad()
          local m = heroModel.m_model
          uiModel.modelGameObject = m
          uiModel.mCanOverflow = true
          aircraftModel:AttachRole(heroModel)
        end
        heroModel:AddOnLoadCallback(panelName, AfterModelLoad)
        _G.LoadModel(heroModel, modelInfo, position[1], position[2], position[3], false, false)
      end)
      return aircraftModel
    end
  else
    do
      local tryModelInfo = self:GetTryModelInfo()
      if tryModelInfo == nil then
        return
      end
      local function AfterModelLoad()
        local m = self.mUIModel.m_model
        uiModel.modelGameObject = m
        uiModel.mCanOverflow = true
        if self.mUIModel ~= nil and self.mUIModel:IsLoaded() and tryModelInfo.wsModelInfo ~= nil then
          self.mUIModel:SetWeaponModel(tryModelInfo.wsModelInfo)
        end
        if self.mItemType == ItemType.RIDDER_ITEM then
          local MountsUtils = require("Main.Mounts.MountsUtils")
          local mountsStageCfg = MountsUtils.GetUnlockMountsByItemId(self.mItemId)
          local mountsCfg = MountsUtils.GetUnlockMountsByItemId(self.mItemId)
          local mountsCfgId = mountsCfg.mountsCfgId
          local modelRank = mountsCfg.mountsRank
          local allMounts = MountsUtils.GetAllMountsCfg()
          local defaultColor = allMounts[mountsCfgId].defaultDyeColorId
          if mountsStageCfg then
            self.mUIModel.m_uiModel = uiModel
            self.mUIModel:TrySetMount(mountsStageCfg.mountsCfgId, modelRank, defaultColor, 0, nil)
          end
        end
        if self.mItemType == ItemType.MAGIC_MARK then
          local magicmarkType = require("Main.MagicMark.MagicMarkModule").Instance():GetMagicMarkItemCfg(self.mItemId).magicType
          local modelId = require("Main.MagicMark.MagicMarkModule").Instance():GetMagicMarkTypeCfg(magicmarkType).modelId
          self.mUIModel:SetMagicMark(modelId)
        end
      end
      self.mUIModel = ECUIModel.new(tryModelInfo.modelid)
      self.mUIModel.m_bUncache = true
      self.mUIModel:AddOnLoadCallback(panelName, AfterModelLoad)
      model.transform.localPosition = Vector.Vector3.new(position[1], position[2], position[3])
      if self.mItemType == ItemType.RIDDER_ITEM then
        model.transform.localScale = Vector.Vector3.new(0.8, 0.8, 0.8)
      end
      _G.LoadModel(self.mUIModel, tryModelInfo, position[1], position[2], position[3], false, false)
    end
  end
  return self.mUIModel
end
def.method("=>", "table").GetTryModelInfo = function(self)
  local modelInfo = gmodule.moduleMgr:GetModule(ModuleId.PUBROLE):GetRoleModelInfo(gmodule.moduleMgr:GetModule(ModuleId.HERO).roleId)
  if modelInfo == nil then
    return nil
  end
  local ModelInfo = require("netio.protocol.mzm.gsp.pubdata.ModelInfo")
  if self.mItemType == ItemType.FASHION_DRESS_ITEM then
    modelInfo.extraMap[ModelInfo.EXTERIOR_ID] = nil
    local fashionItem = FashionUtils.GetFashionItemByUnlockItemId(self.mItemId)
    modelInfo.extraMap[ModelInfo.FASHION_DRESS_ID] = fashionItem.id
    local dyeColor = FashionUtils.GetFashionDyeColor(fashionItem.id)
    if dyeColor then
      modelInfo.extraMap[ModelInfo.HAIR_COLOR_ID] = dyeColor.hairId
      modelInfo.extraMap[ModelInfo.CLOTH_COLOR_ID] = dyeColor.clothId
    else
      modelInfo.extraMap[ModelInfo.HAIR_COLOR_ID] = nil
      modelInfo.extraMap[ModelInfo.CLOTH_COLOR_ID] = nil
    end
  elseif self.mItemType == ItemType.FABAO_ITEM then
    modelInfo.extraMap[ModelInfo.FABAO_LINGQI] = nil
    modelInfo.extraMap[ModelInfo.FABAO] = self.mItemId
  elseif self.mItemType == ItemType.WING_VIEW_ITEM then
    if self.mWingId ~= -1 then
      modelInfo.extraMap[ModelInfo.WING] = self.mWingId
      modelInfo.extraMap[ModelInfo.WING_COLOR_ID] = self.mDyeId
    else
      local outlookId, dyeId = ItemUtils.MapItemId2WingViewId(self.mItemId)
      if outlookId <= 0 then
        modelInfo.extraMap[ModelInfo.WING] = nil
        modelInfo.extraMap[ModelInfo.WING_COLOR_ID] = nil
      else
        modelInfo.extraMap[ModelInfo.WING] = outlookId
        modelInfo.extraMap[ModelInfo.WING_COLOR_ID] = dyeId
      end
    end
  elseif self.mItemType == ItemType.WU_SHI_ITEM then
    local GodWeaponModule = require("Main.GodWeapon.GodWeaponModule")
    local DecorationMgr = require("Main.GodWeapon.DecorationMgr")
    local DecorationUtils = require("Main.GodWeapon.Decoration.DecorationUtils")
    local cfgId = DecorationUtils.GetCfgIdByItemId(self.mItemId).cfgId
    local displayTypeId = DecorationUtils.GetWSBasicCfgById(cfgId).displayTypeId or 0
    modelInfo.wsModelInfo = DecorationMgr.GetData():GetDisplayCfgByModelId(displayTypeId, modelInfo.modelid)
  elseif self.mItemType == ItemType.RIDDER_ITEM then
    modelInfo.extraMap[ModelInfo.MAGIC_MARK] = nil
  elseif self.mItemType == ItemType.CHANGE_MODEL_CARD_ITEM then
    local cardCfg = require("Main.TurnedCard.TurnedCardUtils").GetChangeModelCardItemCfg(self.mItemId)
    modelInfo.extraMap[ModelInfo.CHANGE_MODEL_CARD_CFGID] = cardCfg.cardCfgId
    modelInfo.extraMap[ModelInfo.CHANGE_MODEL_CARD_LEVEL] = cardCfg.cardLevel
  elseif self.mItemType == ItemType.FABAO_ARTIFACT_ITEM then
    local artifactCfgId = FabaoSpiritUtils.GetItemCfgByItemId(self.mItemId).LQCfgId
    modelInfo.extraMap[ModelInfo.FABAO_LINGQI] = artifactCfgId
  end
  return modelInfo
end
def.method("userdata", "string", "number", "number", "table", "=>", ECUIModel).ShowFashionItemTryModel = function(self, model, panelName, itemId, itemType, position)
  self:DestroyAllModels()
  self.mItemId = itemId
  self.mItemType = itemType
  self.model = model
  self.position = position
  local uiModel = model:GetComponent("UIModel")
  if uiModel == nil or uiModel.isnil then
    return
  end
  local heroProp = require("Main.Hero.Interface").GetHeroProp()
  if heroProp == nil then
    return
  end
  if self.mItemType == ItemType.FASHION_DRESS_ITEM then
    self.mUIModel = self:ShowFashionModel()
  end
  return self.mUIModel
end
def.method("userdata", "string", "number", "number", "table", "=>", "table").ShowItemTryModel = function(self, model, panelName, itemId, itemType, position)
  self:DestroyAllModels()
  self.mItemId = itemId
  self.mItemType = itemType
  self.model = model
  self.position = position
  local uiModel = model:GetComponent("UIModel")
  if uiModel == nil or uiModel.isnil then
    return
  end
  local heroProp = require("Main.Hero.Interface").GetHeroProp()
  if heroProp == nil then
    return
  end
  if self.mItemType == ItemType.WING_VIEW_ITEM then
    self.itemModel = self:ShowWingModel()
  elseif self.mItemType == ItemType.FABAO_ITEM then
    self.itemModel = self:ShowFabaoModel()
  elseif self.mItemType == ItemType.WU_SHI_ITEM then
    self.itemModel = self:ShowWushiModel()
  elseif self.mItemType == ItemType.MAGIC_MARK then
    self.itemModel = self:ShowMagicMarkModel()
  elseif self.mItemType == ItemType.RIDDER_ITEM then
    self.itemModel = self:ShowRidderModel()
  elseif self.mItemType == ItemType.FABAO_ARTIFACT_ITEM then
    self.itemModel = self:ShowFabaoLingqiModel()
  end
  return self.itemModel
end
def.method("userdata", "string", "number", "number", "table", "=>", ECUIModel).ShowAirCraftModel = function(self, model, panelName, itemId, itemType, position)
  self:DestroyAllModels()
  self.mItemId = itemId
  self.mItemType = itemType
  self.model = model
  self.position = position
  model.transform.localPosition = Vector.Vector3.new(self.position[1], self.position[2], self.position[3])
  model.transform.localScale = Vector.Vector3.new(0.8, 0.8, 0.8)
  local uiModel = self.model:GetComponent("UIModel")
  local aircraftId = ItemUtils.GetFeijianItem(itemId).aircraftId
  local AircraftData = require("Main.Aircraft.data.AircraftData")
  local AircraftUIModel = require("Main.Aircraft.ui.AircraftUIModel")
  local colorId = AircraftData.Instance():GetAircraftColor(aircraftId)
  local tattooIcon = AircraftData.Instance():GetAircraftTattoo(aircraftId)
  local aircraftModel = AircraftUIModel.new(aircraftId, colorId, tattooIcon, uiModel)
  aircraftModel:LoadWithCB(function(model)
    if _G.IsNil(model) then
      return
    end
  end)
  return aircraftModel
end
def.method("=>", ECUIModel).ShowFashionModel = function(self)
  local uiModel = self.model:GetComponent("UIModel")
  if uiModel == nil or uiModel.isnil then
    return
  end
  local tryModelInfo = gmodule.moduleMgr:GetModule(ModuleId.PUBROLE):GetRoleModelInfo(gmodule.moduleMgr:GetModule(ModuleId.HERO).roleId)
  tryModelInfo = self:InitTryModelInfo(tryModelInfo)
  local ModelInfo = require("netio.protocol.mzm.gsp.pubdata.ModelInfo")
  tryModelInfo.extraMap[ModelInfo.EXTERIOR_ID] = nil
  local fashionItem = FashionUtils.GetFashionItemByUnlockItemId(self.mItemId)
  tryModelInfo.extraMap[ModelInfo.FASHION_DRESS_ID] = fashionItem.id
  local dyeColor = FashionUtils.GetFashionDyeColor(fashionItem.id)
  if dyeColor then
    tryModelInfo.extraMap[ModelInfo.HAIR_COLOR_ID] = dyeColor.hairId
    tryModelInfo.extraMap[ModelInfo.CLOTH_COLOR_ID] = dyeColor.clothId
  else
    tryModelInfo.extraMap[ModelInfo.HAIR_COLOR_ID] = nil
    tryModelInfo.extraMap[ModelInfo.CLOTH_COLOR_ID] = nil
  end
  if tryModelInfo == nil then
    return
  end
  local function AfterModelLoad()
    local m = self.mUIModel.m_model
    uiModel.modelGameObject = m
    uiModel.mCanOverflow = true
  end
  self:DestroyAllModels()
  self.mUIModel = ECUIModel.new(tryModelInfo.modelid)
  self.mUIModel.m_bUncache = true
  self.mUIModel:AddOnLoadCallback("FittingRoomPanel", AfterModelLoad)
  _G.LoadModel(self.mUIModel, tryModelInfo, self.position[1], self.position[2], self.position[3], false, false)
  return self.mUIModel
end
def.method("=>", "table").ShowWingModel = function(self)
  if self.mItemId == -1 then
    self:DestroyAllModels()
    self.itemModel = require("Main.Wing.ui.WingModel")()
    local model = self.model
    model.transform.localPosition = Vector.Vector3.new(self.position[1], self.position[2], self.position[3])
    self.itemModel = self:FillWingModel(model, self.itemModel, self.mWingId, self.mDyeId)
  else
    local wingId = ItemUtils.MapItemId2WingId(self.mItemId)
    local wingCfg = require("Main.Wing.WingUtils").GetWingCfg(wingId)
    local wingOutlookId = wingCfg.outlook
    local colorId = require("Main.Wing.WingUtils").GetWingViewCfg(wingOutlookId).dyeId
    self:DestroyAllModels()
    self.itemModel = require("Main.Wing.ui.WingModel")()
    local model = self.model
    model.transform.localPosition = Vector.Vector3.new(self.position[1], self.position[2], self.position[3])
    self.itemModel = self:FillWingModel(model, self.itemModel, wingOutlookId, colorId or 0)
  end
  return self.itemModel
end
def.method("=>", "table").ShowFabaoModel = function(self)
  local fabaoBase = require("Main.Item.ItemUtils").GetFabaoItem(self.mItemId)
  local modelId = fabaoBase.modelId
  local modelPath = GetModelPath(modelId)
  if nil == modelPath then
    return
  end
  local uiModelComponent = self.model:GetComponent("UIModel")
  local function SetModelStatus(uiModel)
    if nil == uiModel or nil == uiModel.m_model then
      return
    end
    local offsetCfg = FabaoUtils.GetFabaoModelOffset(modelId)
    uiModelComponent:set_mOffsetX(offsetCfg.offsetX)
    uiModelComponent:set_mOffsetY(offsetCfg.offsetY)
    uiModel:SetDir(180)
    uiModel:SetScale(1)
    uiModel:SetPos(0, 10)
    uiModelComponent.modelGameObject = uiModel.m_model
    local color = FabaoUtils.GetFabaoModelColor(self.mItemId)
    if color then
      local render = uiModel.m_model:GetComponentInChildren("SkinnedMeshRenderer")
      render.material:SetColor("_Tint", color)
    end
  end
  local function loadCallback(ret)
    if nil == self.itemModel then
      return
    end
    SetModelStatus(self.itemModel)
  end
  self:DestroyAllModels()
  self.itemModel = ECUIModel.new(modelId)
  self.itemModel.m_bUncache = true
  self.itemModel:LoadUIModel(modelPath, loadCallback)
  return self.itemModel
end
def.method("=>", "table").ShowFabaoLingqiModel = function(self)
  local artifactCfgId = FabaoSpiritUtils.GetItemCfgByItemId(self.mItemId).LQCfgId
  local LQBasicCfg = FabaoSpiritUtils.GetFabaoLQCfg(artifactCfgId)
  local model_id = LQBasicCfg.modelId
  local effectId = LQBasicCfg.boneEffectId
  local comUIModel = self.model:GetComponent("UIModel")
  self.model.transform.localPosition = Vector.Vector3.new(self.position[1], self.position[2], self.position[3])
  local modelPath, modelColor = _G.GetModelPath(model_id)
  if modelPath == nil or modelPath == "" then
    return nil
  end
  local function fun_afterload()
    comUIModel.modelGameObject = self.itemModel.m_model
    FabaoSpiritInterface._addBoneEffect(effectId, self.itemModel.m_model, {})
    if comUIModel.mCanOverflow ~= nil then
      comUIModel.mCanOverflow = true
      local cam = comUIModel:get_modelCamera()
      cam:set_orthographic(true)
    end
  end
  self.itemModel = ECUIModel.new(model_id)
  self.itemModel.m_bUncache = true
  self.itemModel:LoadUIModel(modelPath, function(ret)
    if not self.itemModel or not self.itemModel.m_model or self.itemModel.m_model.isnil then
      return nil
    end
    fun_afterload()
  end)
  return self.itemModel
end
def.method("=>", "table").ShowWushiModel = function(self)
  local cfgId = DecorationUtils.GetCfgIdByItemId(self.mItemId).cfgId
  local displayTypeId = DecorationUtils.GetWSBasicCfgById(cfgId).displayTypeId
  local gender = _G.GetHeroProp().gender
  local occupation = _G.GetHeroProp().occupation
  local outlookId = DecorationData.Instance():GetDisplayCfg(displayTypeId, occupation, gender).id
  self:DestroyAllModels()
  self.itemModel = require("Main.GodWeapon.Decoration.DecorationModel")()
  local model = self.model
  model.transform.localPosition = Vector.Vector3.new(self.position[1], self.position[2], self.position[3])
  model.transform.localRotation = Quaternion.Euler(Vector.Vector3.new(0, 0, 100))
  self.itemModel = self:FillWushiModel(model, self.itemModel, displayTypeId, occupation, gender)
  return self.itemModel
end
def.method("=>", "table").ShowMagicMarkModel = function(self)
  local magicmarkType = require("Main.MagicMark.MagicMarkModule").Instance():GetMagicMarkItemCfg(self.mItemId).magicType
  local modelId = require("Main.MagicMark.MagicMarkModule").Instance():GetMagicMarkTypeCfg(magicmarkType).modelId
  self:DestroyAllModels()
  self.itemModel = require("Main.MagicMark.MagicMarkModel")()
  local model = self.model
  model.transform.localPosition = Vector.Vector3.new(self.position[1], self.position[2], self.position[3])
  model.transform.localRotation = Quaternion.Euler(Vector.Vector3.new(0, 0, 100))
  self.itemModel = self:FillMagicMarkModel(model, self.itemModel, modelId)
  return self.itemModel
end
def.method("=>", "table").ShowRidderModel = function(self)
  self.model.transform.localScale = Vector.Vector3.new(0.8, 0.8, 0.8)
  local uiModel = self.model:GetComponent("UIModel")
  local MountsUtils = require("Main.Mounts.MountsUtils")
  local mountsCfg = MountsUtils.GetUnlockMountsByItemId(self.mItemId)
  local mountsCfgId = mountsCfg.mountsCfgId
  local modelRank = mountsCfg.mountsRank
  local allMounts = MountsUtils.GetAllMountsCfg()
  local defaultColor = allMounts[mountsCfgId].defaultDyeColorId
  local mountInfo = {
    mounts_cfg_id = mountsCfgId,
    model_rank = modelRank,
    color_id = defaultColor
  }
  self.itemModel = MountsUtils.LoadMountsModel(uiModel, mountInfo, function()
    if self.itemModel ~= nil then
      self.itemModel:SetDir(-135)
    end
  end)
  return self.itemModel
end
def.method("userdata", "table", "number", "number", "=>", "table").FillWingModel = function(self, uiModel, model, outlookId, wingDyeId)
  if uiModel == nil or model == nil then
    return
  end
  local uiModelCmp = uiModel:GetComponent("UIModel")
  if outlookId > 0 then
    model:Create(outlookId, wingDyeId, function()
      if uiModelCmp.isnil then
        return
      end
      uiModelCmp.mCanOverflow = true
      local camera = uiModelCmp:get_modelCamera()
      camera:set_orthographic(true)
      uiModelCmp.modelGameObject = model:GetModelGameObject()
    end)
  else
    model:Destroy()
  end
  return model
end
def.method("userdata", "table", "number", "number", "number", "=>", "table").FillWushiModel = function(self, uiModel, model, displayTypeId, occupation, gender)
  if uiModel == nil or model == nil then
    return
  end
  local uiModelCmp = uiModel:GetComponent("UIModel")
  local outlookId = DecorationData.Instance():GetDisplayCfg(displayTypeId, occupation, gender).id
  if outlookId > 0 then
    model:Create(displayTypeId, occupation, gender, function()
      if uiModelCmp.isnil then
        return
      end
      uiModelCmp.mCanOverflow = true
      local camera = uiModelCmp:get_modelCamera()
      camera:set_orthographic(true)
      uiModelCmp.modelGameObject = model:GetModelGameObject()
    end)
  else
    model:Destroy()
  end
  return model
end
def.method("userdata", "table", "number", "=>", "table").FillMagicMarkModel = function(self, uiModel, model, modelId)
  if uiModel == nil or model == nil then
    return
  end
  local uiModelCmp = uiModel:GetComponent("UIModel")
  if modelId > 0 then
    model:Create(modelId, function()
      if uiModelCmp.isnil then
        return
      end
      uiModelCmp.mCanOverflow = true
      model:SetDir(180)
      local camera = uiModelCmp:get_modelCamera()
      camera:set_orthographic(true)
      uiModelCmp.modelGameObject = model:GetModelGameObject()
    end)
  else
    model:Destroy()
  end
  return model
end
def.method("table", "=>", "table").InitTryModelInfo = function(self, info)
  local ModelInfo = require("netio.protocol.mzm.gsp.pubdata.ModelInfo")
  local result = {}
  result.name = info.name
  result.modelid = info.modelid
  result.extraMap = {}
  result.extraMap[ModelInfo.QILING_LEVEL] = info.extraMap[ModelInfo.QILING_LEVEL]
  result.extraMap[ModelInfo.MOUNTS_COLOR_ID] = info.extraMap[ModelInfo.MOUNTS_COLOR_ID]
  result.extraMap[ModelInfo.MOUNTS_RANK] = info.extraMap[ModelInfo.MOUNTS_RANK]
  result.extraMap[ModelInfo.GENDER] = info.extraMap[ModelInfo.GENDER]
  result.extraMap[ModelInfo.OCCUPATION] = info.extraMap[ModelInfo.OCCUPATION]
  result.extraMap[ModelInfo.MORAL_VALUE] = info.extraMap[ModelInfo.MORAL_VALUE]
  result.extraMap[ModelInfo.MOUNTS_ID] = info.extraMap[ModelInfo.MOUNTS_ID]
  return result
end
def.method("number", "number", "string").SetWingsData = function(self, wingsId, dyeId, name)
  self.mItemType = ItemType.WING_VIEW_ITEM
  self.mName = name
  self.mWingId = wingsId
  self.mDyeId = dyeId
end
def.method().DestroyAllModels = function(self)
  if self.itemModel then
    self.itemModel:Destroy()
    self.itemModel = nil
  end
  if self.mUIModel then
    self.mUIModel:Destroy()
    self.mUIModel = nil
  end
end
FittingRoomMgr.Commit()
return FittingRoomMgr

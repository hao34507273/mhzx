local Lplus = require("Lplus")
local EC = require("Types.Vector3")
local ECModel = require("Model.ECModel")
local ECPartComponent = Lplus.Class("ECPartComponent")
local EquipUtils = require("Main.Equip.EquipUtils")
local ECFxMan = require("Fx.ECFxMan")
local WeaponType = require("consts.mzm.gsp.item.confbean.WeaponType")
local def = ECPartComponent.define
ECPartComponent.PartType = require("consts.mzm.gsp.item.confbean.WearPos")
local WAN_DU_ROTATION_ADJUST = EC.Vector3.new(0, 180, -90)
def.const("string").RIGHT_WEAPON_BONE_NAME = "Bip01_RightWeapon"
def.const("string").LEFT_WEAPON_BONE_NAME = "Bip01_LeftWeapon"
def.const("string").RIGHT_WEAPON_NAME = "weapon_mainHand"
def.const("string").LEFT_WEAPON_NAME = "weapon_offHand"
def.field("number").weaponId = 0
def.field("table").charModel = nil
def.field("table").rightHand = nil
def.field("table").leftHand = nil
def.field("userdata").parentNode = nil
def.field("number").defaultLayer = 1
def.field("number").lightLevel = 1
def.field("boolean").m_visible = true
def.field("table").m_lightEffect = nil
def.field("table").modelInfo = nil
def.field("boolean").isStone = false
def.field("string").defaultAction = ActionName.Stand
def.static("table", "=>", ECPartComponent).new = function(model)
  local com = ECPartComponent()
  com.charModel = model
  com.defaultLayer = model.defaultLayer
  return com
end
def.method("string").PlayAnimation = function(self, aniName)
  if self.charModel == nil then
    return
  end
  if self.rightHand then
    if self.rightHand:HasAnimClip(aniName) then
      self.rightHand:Play(aniName)
    elseif self.rightHand:HasAnimClip(ActionName.Stand) then
      self.rightHand:Play(ActionName.Stand)
    elseif self.rightHand:HasAnimClip(ActionName.Attack1) then
      self.rightHand:Play(ActionName.Attack1)
    end
  end
  if self.leftHand == nil then
    return
  end
  if self.leftHand:HasAnimClip(aniName) then
    self.leftHand:Play(aniName)
  elseif self.leftHand:HasAnimClip(ActionName.Stand) then
    self.leftHand:Play(ActionName.Stand)
  elseif self.leftHand:HasAnimClip(ActionName.Attack1) then
    self.leftHand:Play(ActionName.Attack1)
  end
end
def.method("table").SetCharModel = function(self, model)
  self.charModel = model
  self.parentNode = nil
end
def.method("=>", "boolean").IsMainModelLoaded = function(self)
  if self.charModel == nil then
    return false
  end
  return self.charModel:IsObjLoaded()
end
def.method("number").SetLayer = function(self, layer)
  self.defaultLayer = layer
  if self.rightHand then
    self.rightHand:SetLayer(layer)
  end
  if self.leftHand then
    self.leftHand:SetLayer(layer)
  end
end
def.method("table").SetModelInfo = function(self, modelInfo)
  self.modelInfo = modelInfo
  self:DestroyModel()
  self:ReLoadRes()
end
def.method().LoadResBase = function(self)
  local partInfo = EquipUtils.GetEquipBasicInfo(self.weaponId)
  if partInfo == nil then
    return
  end
  local weapon_model_id = partInfo.equipmodel
  local offhandModelId = partInfo.assistModel
  if partInfo.weaponType == WeaponType.BOTH and partInfo.assistModel <= 0 then
    offhandModelId = partInfo.equipmodel
  end
  if self.modelInfo then
    if 0 <= self.modelInfo.equipModelId then
      weapon_model_id = self.modelInfo.equipModelId
    end
    if 0 <= self.modelInfo.offhandEquipModelCfgId then
      offhandModelId = self.modelInfo.offhandEquipModelCfgId
    end
  end
  local weapon_effect_id = partInfo.lightEffectId
  if self.modelInfo and self.modelInfo.effectId and 0 < self.modelInfo.effectId then
    weapon_effect_id = self.modelInfo.effectId
  end
  local equipRes = GetEquipmentModelCfg(weapon_model_id)
  if equipRes == nil or equipRes == "" then
    warn("[load weapon]respath is empty for id: ", weapon_model_id)
    return
  end
  local suffix = string.sub(equipRes, -7, -1)
  if string.lower(suffix) ~= ".prefab" then
    Debug.LogWarning(string.format("invalid weapon res: char_model_id(%d), weaponId(%d)", self.charModel.mModelId, weapon_model_id))
    return
  end
  local lightLevel = self.lightLevel
  if self.modelInfo then
    lightLevel = 0
  end
  local resname = equipRes .. ".u3dext"
  local ECModel = require("Model.ECModel")
  local model = ECModel.new(partInfo.equipmodel)
  model.parentNode = self.parentNode
  model.defaultLayer = self.defaultLayer
  if self.rightHand then
    self:RemoveAdditionalLightEffect(self.rightHand)
    self.rightHand:Destroy()
  end
  if self.leftHand then
    self:RemoveAdditionalLightEffect(self.leftHand)
    self.leftHand:Destroy()
  end
  if partInfo.weaponType == WeaponType.LEFT then
    self.leftHand = model
    model.m_Name = ECPartComponent.LEFT_WEAPON_NAME
  elseif partInfo.weaponType == WeaponType.RIGHT or partInfo.weaponType == WeaponType.BOTH then
    self.rightHand = model
    model.m_Name = ECPartComponent.RIGHT_WEAPON_NAME
  end
  local function onLoadObj(obj)
    if obj == nil then
      return
    end
    if self.charModel == nil or self.charModel.m_model == nil or self.weaponId == 0 then
      self:DestroyModel()
      return
    end
    local ret = self.charModel:AttachModel(model.m_Name, obj, self:GetAttachPos(partInfo.weaponType))
    if ret then
      obj:SetActive(self.charModel.m_visible and self.charModel.showModel and self.m_visible)
      if lightLevel > 0 then
        self:SetLightEffect(model, lightLevel)
      end
      self:AddAdditionalLightEffect(model, weapon_effect_id)
    else
      self:Destroy()
      return
    end
    local function OnLeftHandLoaded(m)
      if m == nil then
        return
      end
      if self.charModel == nil or self.charModel.m_model == nil or self.weaponId == 0 then
        return
      end
      local ret = self.charModel:AttachModel(m.m_Name, m, ECPartComponent.LEFT_WEAPON_BONE_NAME)
      if ret then
        m:SetActive(self.charModel.m_visible and self.charModel.showModel and self.m_visible)
        if lightLevel > 0 then
          self:SetLightEffect(m, lightLevel)
        end
        self:AddAdditionalLightEffect(m, weapon_effect_id)
      end
    end
    if offhandModelId > 0 then
      self.leftHand = ECModel.new(offhandModelId)
      self.leftHand.parentNode = self.parentNode
      self.leftHand.defaultLayer = self.defaultLayer
      self.leftHand.m_Name = ECPartComponent.LEFT_WEAPON_NAME
      local respath = GetEquipmentModelCfg(offhandModelId)
      self.leftHand:Load(respath .. ".u3dext", OnLeftHandLoaded)
    end
    if self.charModel.mModelId == WAN_DU_NV_MODEL_ID then
      local rotation = Quaternion.Euler(WAN_DU_ROTATION_ADJUST)
      self.rightHand:SetRotation(rotation)
      if self.leftHand then
        self.leftHand:SetRotation(rotation)
      end
      self:PlayAnimation(self.defaultAction)
    end
    if self.charModel.m_IsAlpha then
      self:SetAlpha(0.55)
    else
      self:CloseAlpha()
    end
    if self.isStone then
      self:TurnToStone()
    end
  end
  model:Load(resname, onLoadObj)
end
def.method("number").LoadSingleWeaponByModelId = function(self, modelId)
  local equipRes = GetEquipmentModelCfg(modelId)
  if equipRes == nil or equipRes == "" then
    warn("[LoadSingleWeaponByModelId]respath is empty for id: ", modelId)
    return
  end
  local suffix = string.sub(equipRes, -7, -1)
  if string.lower(suffix) ~= ".prefab" then
    Debug.LogWarning(string.format("invalid weapon res: char_model_id(%d), weaponId(%d)", self.charModel.mModelId, self.weaponId))
    return
  end
  local resname = equipRes .. ".u3dext"
  local ECModel = require("Model.ECModel")
  local model = ECModel.new(modelId)
  model.parentNode = self.parentNode
  model.defaultLayer = self.defaultLayer
  if self.rightHand then
    self:RemoveAdditionalLightEffect(self.rightHand)
    self.rightHand:Destroy()
  end
  self.rightHand = model
  self.rightHand.m_Name = ECPartComponent.RIGHT_WEAPON_NAME
  local function onLoadObj(obj)
    if obj == nil then
      return
    end
    if self.charModel == nil or self.charModel.m_model == nil or self.rightHand == nil then
      self:DestroyModel()
      return
    end
    local ret = self.charModel:AttachModel(self.rightHand.m_Name, obj, ECPartComponent.RIGHT_WEAPON_BONE_NAME)
    if ret then
      obj:SetActive(self.charModel.m_visible and self.charModel.showModel and self.m_visible)
    else
      self:Destroy()
      return
    end
  end
  model:Load(resname, onLoadObj)
end
def.method("table", "number").AddAdditionalLightEffect = function(self, parent, effId)
  if parent == nil or effId <= 0 then
    return
  end
  local eff = GetEffectRes(effId)
  if self.m_lightEffect == nil then
    self.m_lightEffect = {}
  end
  local function loaded(obj)
    if obj == nil then
      return
    end
    if parent:IsDestroyed() then
      return
    end
    local fx = ECFxMan.Instance():PlayAsChild(eff.path, parent.m_model, EC.Vector3.zero, Quaternion.identity, -1, false, self.defaultLayer)
    if fx then
      fx:GetComponent("FxOne"):set_Stable(true)
      self.m_lightEffect[tostring(parent)] = fx
      if self.charModel.mModelId == WAN_DU_NV_MODEL_ID then
        fx.parent = parent.m_model:FindDirect("Root/Bip01")
      end
    end
  end
  GameUtil.AsyncLoad(eff.path, loaded)
end
def.method("table").RemoveAdditionalLightEffect = function(self, parent)
  if self.m_lightEffect == nil or parent == nil then
    return
  end
  local k = tostring(parent)
  local fx = self.m_lightEffect[k]
  if fx == nil or fx.isnil then
    return
  end
  ECFxMan.Instance():Stop(fx)
  self.m_lightEffect[k] = nil
end
def.method("boolean").ScaleEquipLightEffect = function(self, isLarge)
  if self.m_lightEffect == nil then
    return
  end
  for _, fx in pairs(self.m_lightEffect) do
    if fx and not fx.isnil and fx.childCount > 0 then
      local effobj = fx:GetChild(0)
      if effobj then
        local largeObj = effobj:FindDirect("FX1.5")
        if largeObj then
          largeObj:SetActive(isLarge)
        end
        local smallObj = effobj:FindDirect("FX1.0")
        if smallObj then
          smallObj:SetActive(not isLarge)
        end
        if isLarge and largeObj and smallObj then
          for i = 1, largeObj.childCount do
            local child = largeObj:GetChild(i - 1)
            if i <= smallObj.childCount then
              child.localPosition = smallObj:GetChild(i - 1).localPosition
            end
          end
        end
      end
    end
  end
end
local weapon_color1 = Color.Color(0, 0, 0, 0)
local weapon_color2 = Color.Color(0, 0, 0, 0)
def.method("table", "number").SetLightEffect = function(self, parentModel, lv)
  local pm = parentModel.m_model
  if pm == nil then
    return
  end
  local color = lv > 0 and GetMostAppropriateLightLevel(parentModel.mModelId, lv)
  if color then
    AssignColor(weapon_color1, color.color1)
    AssignColor(weapon_color2, color.color2)
    self:SetLightValue(parentModel, weapon_color1, weapon_color2)
  else
    self:DisableLight(parentModel)
  end
end
def.method(ECModel, "userdata", "userdata").SetLightValue = function(self, m, color1, color2)
  if m.m_renderers == nil then
    return
  end
  for _, r in pairs(m.m_renderers) do
    r.material:EnableKeyword("FlowingLightOn")
    if color1 then
      r.material:SetColor("_FlowingColor", color1)
    end
    if color2 then
      r.material:SetColor("_FlowingColor2", color2)
    end
  end
end
def.method(ECModel).DisableLight = function(self, m)
  if m.m_renderers == nil then
    return
  end
  for _, r in pairs(m.m_renderers) do
    r.material:DisableKeyword("FlowingLightOn")
  end
end
def.method("number").ResetLightEffect = function(self, lv)
  if self.rightHand and not self.modelInfo then
    self:SetLightEffect(self.rightHand, lv)
  end
  if self.leftHand and not self.modelInfo then
    self:SetLightEffect(self.leftHand, lv)
  end
end
def.method("number", "number", "table").LoadRes = function(self, id, lightLevel, modelInfo)
  if self.weaponId == id and self.lightLevel == lightLevel then
    if self.rightHand == nil and self.weaponId > 0 then
      self.modelInfo = modelInfo
      self:ReLoadRes()
    end
    return
  end
  self:Destroy()
  self.weaponId = id
  self.lightLevel = lightLevel
  self.modelInfo = modelInfo
  self:ReLoadRes()
end
def.method().ReLoadRes = function(self)
  if self:IsMainModelLoaded() == false then
    if self.charModel then
      self.charModel:AddOnLoadCallback("Weapon", function()
        self:LoadResBase()
      end)
    end
    return
  end
  self:LoadResBase()
end
def.method(ECModel, "=>", "boolean").AttachToModel = function(self, model)
  self.charModel = model
  local ret = false
  if self.rightHand == nil and self.leftHand == nil and self.weaponId > 0 then
    ret = true
    self:ReLoadRes()
  elseif self.rightHand and self.rightHand.m_model and not self.rightHand.m_model.isnil then
    ret = self.charModel:AttachModel(self.rightHand.m_Name, self.rightHand, ECPartComponent.RIGHT_WEAPON_BONE_NAME)
    if ret then
      if self.leftHand then
        local off_ret = self.charModel:AttachModel(self.leftHand.m_Name, self.leftHand, ECPartComponent.LEFT_WEAPON_BONE_NAME)
        if not off_ret then
          self.leftHand:Destroy()
          self.leftHand = nil
        end
      elseif self.charModel.m_model:FindChild(ECPartComponent.LEFT_WEAPON_BONE_NAME) then
        self.leftHand = self.rightHand:Duplicate()
        self.leftHand.m_Name = ECPartComponent.LEFT_WEAPON_NAME
        self.charModel:AttachModel(self.leftHand.m_Name, self.leftHand, ECPartComponent.LEFT_WEAPON_BONE_NAME)
      end
    end
  elseif self.leftHand and self.leftHand.m_model and not self.leftHand.m_model.isnil then
    ret = self.charModel:AttachModel(self.leftHand.m_Name, self.leftHand, ECPartComponent.LEFT_WEAPON_BONE_NAME)
  end
  if not ret then
    self:DestroyModel()
  end
  return ret
end
def.method().Detach = function(self)
  if self.charModel == nil then
    return
  end
  if self.rightHand and self.rightHand.m_model then
    self.charModel:Detach(self.rightHand.m_Name)
    self.rightHand.m_model.localScale = EC.Vector3.one
  end
  if self.leftHand and self.leftHand.m_model then
    self.charModel:Detach(self.leftHand.m_Name)
    self.leftHand.m_model.localScale = EC.Vector3.one
  end
  self.charModel = nil
end
def.method().DestroyModel = function(self)
  if self.charModel and self.charModel:IsInLoading() then
    self.charModel:RemoveOnLoadCallback("Weapon")
  end
  if self.rightHand then
    self:RemoveAdditionalLightEffect(self.rightHand)
    local model = self.charModel and self.charModel:Detach(self.rightHand.m_Name)
    if model ~= nil then
      model:Destroy()
      model = nil
    else
      self.rightHand:Destroy()
    end
    self.rightHand = nil
  end
  if self.leftHand then
    self:RemoveAdditionalLightEffect(self.leftHand)
    local model = self.charModel and self.charModel:Detach(self.leftHand.m_Name)
    if model ~= nil then
      model:Destroy()
      model = nil
    else
      self.leftHand:Destroy()
    end
    self.leftHand = nil
  end
end
def.method().Destroy = function(self)
  self:DestroyModel()
  self.weaponId = 0
  self.lightLevel = 0
  self.modelInfo = nil
end
def.method("number").SetAlpha = function(self, alphaValue)
  if self.rightHand then
    self.rightHand:SetAlpha(alphaValue)
  end
  if self.leftHand then
    self.leftHand:SetAlpha(alphaValue)
  end
end
def.method("boolean").SetVisible = function(self, visible)
  self.m_visible = visible
  if self.rightHand then
    self.rightHand:SetVisible(visible)
  end
  if self.leftHand then
    self.leftHand:SetVisible(visible)
  end
end
def.method("number").ChangeAlpha = function(self, alphaValue)
  if self.rightHand then
    self.rightHand:ChangeAlpha(alphaValue)
  end
  if self.leftHand then
    self.leftHand:ChangeAlpha(alphaValue)
  end
end
def.method().CloseAlpha = function(self)
  if self.rightHand then
    self.rightHand:CloseAlpha()
  end
  if self.leftHand then
    self.leftHand:CloseAlpha()
  end
end
def.method("number", "=>", "string").GetAttachPos = function(self, weapon_type)
  if weapon_type == WeaponType.LEFT then
    return ECPartComponent.LEFT_WEAPON_BONE_NAME
  elseif weapon_type == WeaponType.RIGHT then
    return ECPartComponent.RIGHT_WEAPON_BONE_NAME
  elseif weapon_type == WeaponType.BOTH then
    return ECPartComponent.RIGHT_WEAPON_BONE_NAME
  else
    return ECPartComponent.RIGHT_WEAPON_BONE_NAME
  end
end
def.method().TurnToStone = function(self)
  self.isStone = true
  if self.rightHand then
    self.rightHand:TurnToStone()
  end
  if self.leftHand then
    self.leftHand:TurnToStone()
  end
end
def.method().RecoverFromStone = function(self)
  if self.rightHand then
    self.rightHand:RecoverFromStone()
  end
  if self.leftHand then
    self.leftHand:RecoverFromStone()
  end
  self.isStone = false
end
ECPartComponent.Commit()
return ECPartComponent

local Lplus = require("Lplus")
local StrategyBase = Lplus.Class("StrategyBase")
local ECGame = require("Main.ECGame")
local FlyModule = require("Main.Fly.FlyModule")
local EC = require("Types.Vector3")
local ECAirCraft = require("Main.Fly.FlyStrategy.ECAirCraft")
local ECPlayer = require("Model.ECPlayer")
local ECFxMan = require("Fx.ECFxMan")
local t_pos = EC.Vector3.new()
local def = StrategyBase.define
def.field("table").role = nil
def.field("table").cfg = nil
def.field("number").feijianId = 0
def.field("number").colorId = 0
def.field("number").skyScale = 1.5
def.field("number").upHeight = 3
def.field("boolean").dirty = false
def.field("table").t_pos = function()
  return EC.Vector3.new()
end
def.field("boolean").destroyed = false
def.method().Destroy = function(self)
  self.destroyed = true
end
def.method().SetDirty = function(self)
  self.dirty = true
end
def.method("number").SetFeijianId = function(self, id)
  self.feijianId = id
end
def.method("number").SetColorId = function(self, colorId)
  self.colorId = colorId
end
def.method("table").SetRole = function(self, role)
  self.role = role
end
def.method("table").SetCfg = function(self, cfg)
  self.cfg = cfg
end
def.method("=>", "boolean").IsValid = function(self)
  return self.role ~= nil and self.cfg ~= nil
end
def.method("=>", "boolean").IsShowFeijian = function(self)
  if self.role == nil then
    return false
  end
  return self.role.m_visible
end
def.method().LeaveMount = function(self)
  if self.role.flyState == 0 then
    self.role:LeaveMount()
  end
end
def.virtual("=>", "number").GetNameOffset = function(self)
  local feijianOffset = self.role.feijianModel:GetBoxHeight()
  if not (feijianOffset > 0) or not feijianOffset then
    feijianOffset = 1
  end
  return default_name_offset - feijianOffset
end
def.method().ReturnMount = function(self)
  if self.role.flyState == 0 then
    self.role:ReturnMount()
  end
end
def.method("=>", "boolean").CheckFeijianModel = function(self)
  if self.role.feijianModel == nil or _G.IsNil(self.role.feijianModel.m_model) then
    return false
  else
    return true
  end
end
def.method("=>", "boolean").CheckRoleModel = function(self)
  return not _G.IsNil(self.role.m_model)
end
def.virtual("number", "number", "function").FlyUp = function(self, x, y, callback)
  local function OnActionDone()
    if self.destroyed then
      return
    end
    if not self:CheckFeijianModel() then
      return
    end
    if not self:CheckRoleModel() then
      if self.role:IsInLoading() then
        self.role:AddOnLoadCallback("runpath", OnActionDone)
      end
      return
    end
    self.role.flyState = ECPlayer.FlyState.Flight
    self.role.flyPoint = nil
    self.role:SetLayer(ClientDef_Layer.FlyPlayer)
    self.role.feijianModel:SetLayer(ClientDef_Layer.FlyPlayer)
    self.role.feijianModel.m_model.localScale = Model_Default_Scale * self.skyScale
    local roleAttach = self.role.feijianModel:GetAttach(FlyModule.FlyTag)
    if roleAttach ~= nil then
      self.role.feijianModel:ChangeAttach(FlyModule.FlyTag, FlyModule.FlyTag, "HH_Point")
    else
      self.role.feijianModel:AttachModel(FlyModule.FlyTag, self.role, "HH_Point")
    end
    local commonMove = self.role:GetOrAddMovePathComp()
    commonMove:set_enabled(true)
    local animationName = self.role:HasAnimClip(FlyModule.FlyIdleAnimation) and FlyModule.FlyIdleAnimation or ActionName.FightStand
    if self.role:IsInState(RoleState.HUG) then
      animationName = FlyModule.FlyIdleHugAnimation
    end
    commonMove:set_MoveAnimationName(FlyModule.FlyIdleAnimation)
    commonMove:set_StandAnimationName(FlyModule.FlyIdleAnimation)
    self.role:Play(animationName)
    commonMove:set_IsAnimate(true)
    self.role.feijianModel:Play(FlyModule.FlyIdleAnimation)
    self.role.nameOffset = self:GetNameOffset()
    if self.role.m_uiNameHandle then
      self.role.m_uiNameHandle:GetComponent("HUDFollowTarget").offset = EC.Vector3.new(0, self.role.nameOffset, 0)
    end
    if callback then
      callback()
    end
  end
  local function OnLoadFeijianDone(ret)
    if self.destroyed then
      return
    end
    if ret == nil then
      return
    end
    if not self:CheckFeijianModel() then
      return
    end
    if not self:CheckRoleModel() then
      if self.role:IsInLoading() then
        self.role:AddOnLoadCallback("runpath", function(ret)
          OnLoadFeijianDone(ret)
        end)
      end
      return
    end
    self:LeaveMount()
    self.role.feijianModel:InitShadow()
    self.role.feijianModel.colorId = self.colorId
    self.role.feijianModel:SetColoration(nil)
    self.role:RemoveFlyComponent()
    if self.role:IsMe() then
      ECGame.Instance():ToSkyLayer()
      FlyModule.Instance():FlowCloud(0.001, "fly")
    end
    if not self:IsShowFeijian() then
      self.role.feijianModel:SetActive(false)
    end
    if not self.role.showModel then
      self.role.feijianModel:SetShowModel(false)
    end
    self.role.flyState = ECPlayer.FlyState.Up
    self.role.flyPoint = {x = x, y = y}
    local commonMove = self.role:GetOrAddMovePathComp()
    commonMove:Stop()
    commonMove:set_enabled(true)
    commonMove:set_IsAnimate(false)
    self.role.feijianModel:SetAnimCullingType(0)
    self.role:SetAnimCullingType(0)
    if self:IsShowFeijian() then
      self.role:AddEffectWithOffset(RESPATH.Feijian_Jump_Effect, 0)
    end
    local roleLocalRotation = self.role.m_model.localRotation
    local roleAttach = self.role.feijianModel:GetAttach(FlyModule.FlyTag)
    if roleAttach ~= nil then
      self.role.feijianModel:ChangeAttach(FlyModule.FlyTag, FlyModule.FlyTag, "Root")
    else
      self.role.feijianModel:AttachModel(FlyModule.FlyTag, self.role, "Root")
    end
    if self.cfg.effectPath and self.role.feijianEffect == nil then
      self.role.feijianEffect = self.role.feijianModel:AttachEffectToBone(self.cfg.effectPath, "Bip01")
      if self.role.feijianEffect then
        self.role.feijianEffect.transform.localRotation = Quaternion.Euler(EC.Vector3.new(0, 0, 0))
        self.role.feijianEffect:SetLayer(ClientDef_Layer.FlyPlayer)
        local FXModule = require("Main.FX.FXModule")
        FXModule.Instance():AddManagedFx(self.role.feijianEffect)
      end
    end
    local curX = self.role.m_node2d.localPosition.x
    local curY = self.role.m_node2d.localPosition.y
    local tweenCallback, runpathCallback
    if curX == x and curY == y then
      tweenCallback = OnActionDone
    else
      runpathCallback = OnActionDone
    end
    Set2DPosTo3D(curX, world_height - curY, self.t_pos)
    self.role.feijianModel.m_model.localPosition = self.t_pos
    self.role.feijianModel.m_model.localRotation = roleLocalRotation
    self.role.feijianModel:SetLayer(ClientDef_Layer.FlyPlayer)
    self.role:SetLayer(ClientDef_Layer.FlyPlayer)
    local y1 = self.role.feijianModel.m_model.transform.localPosition.y
    local y2 = 0 + self.upHeight
    YGameObjectTween.TweenGameObjectY(self.role.feijianModel.m_model, y1, y2, fly_up_time, fly_up_ani_time, tweenCallback)
    ScaleGameObjectTween.TweenGameObjectScale(self.role.feijianModel.m_model, self.role.feijianModel.m_model.transform.localScale, Model_Default_Scale * self.skyScale, fly_up_time)
    if self.role.feijianModel.mShadowObj and not self.role.feijianModel.mShadowObj.isnil then
      local shadowPosition = self.role.feijianModel.mShadowObj.transform.localPosition
      local shadowToPosition = EC.Vector3.new(shadowPosition.x, (0 - self.upHeight) / self.skyScale, shadowPosition.z)
      PositionGameObjectTween.TweenGameObjectPosition(self.role.feijianModel.mShadowObj, shadowPosition, shadowToPosition, fly_up_time)
    end
    if self.role.mShadowObj and not self.role.mShadowObj.isnil then
      self.role.mShadowObj:SetActive(false)
    end
    if self.role.mECFabaoComponent then
      self.role.mECFabaoComponent:FlyUp()
    end
    local pet = self.role:GetPet()
    if pet then
      local PubroleModule = require("Main.Pubrole.PubroleModule")
      PubroleModule.Instance():RoleStopFollow(pet)
      self.role:RemovePet()
    end
    if curX == x and curY == y then
      self.role.feijianModel:Play(FlyModule.FlyUpAnimation)
      local animationName = self.role:HasAnimClip(FlyModule.FlyUpAnimation) and FlyModule.FlyUpAnimation or ActionName.FightStand
      self.role:Play(animationName)
    else
      self.role.feijianModel:Play(FlyModule.FlyUpAnimation)
      local animationName = self.role:HasAnimClip(FlyModule.FlyUpAnimation) and FlyModule.FlyUpAnimation or ActionName.FightStand
      self.role:Play(animationName)
      local upSpeed = 0
      self.role.movePath, upSpeed = self.role:MakeFlyPathFixedTime(x, y, fly_up_ani_time)
      self.role:_RunPath(self.role.movePath, upSpeed, self.role.feijianModel.m_model, runpathCallback)
    end
  end
  local function doFly()
    if self.destroyed then
      return
    end
    if self.role:IsInState(RoleState.BEHUG) then
      return
    end
    if self.role.feijianModel == nil then
      self.role.feijianModel = ECAirCraft.new(0, self.role)
      self.role.feijianModel:Load2(self.cfg.modelPath, OnLoadFeijianDone, true)
    elseif not self.role.feijianModel:IsObjLoaded() then
      self.role.feijianModel:Destroy()
      self.role.feijianModel = ECAirCraft.new(0, self.role)
      self.role.feijianModel:Load2(self.cfg.modelPath, OnLoadFeijianDone, true)
    else
      OnLoadFeijianDone(self.role.feijianModel)
    end
  end
  if self.role.m_model == nil and self.role:IsInLoading() then
    self.role:AddOnLoadCallback("runpath", doFly)
  else
    doFly()
  end
end
def.virtual("number", "number", "function").FlyDown = function(self, x, y, callback)
  local function OnActionDone()
    if self.destroyed then
      return
    end
    if not self:CheckFeijianModel() then
      return
    end
    if not self:CheckRoleModel() then
      if self.role:IsInLoading() then
        self.role:AddOnLoadCallback("runpath", OnActionDone)
      end
      return
    end
    self.role.flyState = 0
    self.role.flyPoint = nil
    if self:IsShowFeijian() then
      self.role:AddEffectWithOffset(RESPATH.Feijian_Jump_Effect, 0)
    end
    self.role:SetAnimCullingType(1)
    local commonMove = self.role:GetOrAddMovePathComp()
    commonMove:set_enabled(true)
    commonMove:set_IsAnimate(true)
    commonMove:set_MoveAnimationName(ActionName.Run)
    commonMove:set_StandAnimationName(ActionName.Stand)
    self.role:Play(ActionName.Stand)
    self.role.nameOffset = default_name_offset
    if self.role.m_uiNameHandle then
      self.role.m_uiNameHandle:GetComponent("HUDFollowTarget").offset = EC.Vector3.new(0, self.role.nameOffset, 0)
    end
    local roleAttach = self.role.feijianModel:GetAttach(FlyModule.FlyTag)
    if roleAttach ~= nil then
      self.role.feijianModel:Detach(FlyModule.FlyTag)
    end
    if self.role.defaultParentNode then
      self.role:SetParentNode(self.role.defaultParentNode)
    end
    if self.role.mShadowObj and not self.role.mShadowObj.isnil then
      self.role.mShadowObj:SetActive(true)
    end
    local curX = self.role.m_node2d.localPosition.x
    local curY = self.role.m_node2d.localPosition.y
    Set2DPosTo3D(curX, world_height - curY, self.t_pos)
    local feijianLocalRotation = self.role.feijianModel.m_model.localRotation
    self.role.m_model.localScale = Model_Default_Scale
    self.role.m_model.localRotation = feijianLocalRotation
    self.role.m_model.localPosition = self.t_pos
    self.role.feijianModel:Destroy()
    self.role.feijianModel = nil
    ECFxMan.Instance():Stop(self.role.feijianEffect)
    self.role.feijianEffect = nil
    self:ReturnMount()
    if callback then
      callback()
    end
  end
  local function OnLoadFeijianDone(ret)
    if self.destroyed then
      return
    end
    if ret == nil then
      return
    end
    if not self:CheckFeijianModel() then
      return
    end
    if not self:CheckRoleModel() then
      if self.role:IsInLoading() then
        self.role:AddOnLoadCallback("runpath", function(ret)
          OnLoadFeijianDone(ret)
        end)
      end
      return
    end
    self.role.feijianModel:InitShadow()
    self.role.feijianModel.colorId = self.colorId
    self.role.feijianModel:SetColoration(nil)
    self.role:RemoveFlyComponent()
    if self.role:IsMe() then
      ECGame.Instance():ToGroundLayer()
      FlyModule.Instance():StopCloud("fly")
    end
    if not self:IsShowFeijian() then
      self.role.feijianModel:SetActive(false)
    end
    if not self.role.showModel then
      self.role.feijianModel:SetShowModel(false)
    end
    self.role.flyState = ECPlayer.FlyState.Down
    self.role.flyPoint = {x = x, y = y}
    local commonMove = self.role:GetOrAddMovePathComp()
    commonMove:Stop()
    commonMove:set_enabled(true)
    commonMove:set_IsAnimate(false)
    self.role.feijianModel:SetAnimCullingType(0)
    self.role:SetAnimCullingType(0)
    self.role:SetLayer(ClientDef_Layer.Player)
    self.role.feijianModel:SetLayer(ClientDef_Layer.Player)
    local roleAttach = self.role.feijianModel:GetAttach(FlyModule.FlyTag)
    if roleAttach ~= nil then
      self.role.feijianModel:ChangeAttach(FlyModule.FlyTag, FlyModule.FlyTag, "Root")
    else
      self.role.feijianModel:AttachModel(FlyModule.FlyTag, self.role, "Root")
    end
    if self.cfg.effectPath and self.role.feijianEffect == nil then
      self.role.feijianEffect = self.role.feijianModel:AttachEffectToBone(self.cfg.effectPath, "Bip01")
      if self.role.feijianEffect then
        self.role.feijianEffect.transform.localRotation = Quaternion.Euler(EC.Vector3.new(0, 0, 0))
        self.role.feijianEffect:SetLayer(ClientDef_Layer.FlyPlayer)
        local FXModule = require("Main.FX.FXModule")
        FXModule.Instance():AddManagedFx(self.role.feijianEffect)
      end
    end
    if self.role.mECFabaoComponent then
      self.role.mECFabaoComponent:FlyDown()
    end
    local curX = self.role.m_node2d.localPosition.x
    local curY = self.role.m_node2d.localPosition.y
    local tweenCallback, runpathCallback
    if curX == x and curY == y then
      tweenCallback = OnActionDone
    else
      runpathCallback = OnActionDone
    end
    local y1 = self.role.feijianModel.m_model.transform.localPosition.y
    YGameObjectTween.TweenGameObjectY(self.role.feijianModel.m_model, y1, 0, fly_down_time, fly_down_ani_time, tweenCallback)
    ScaleGameObjectTween.TweenGameObjectScale(self.role.feijianModel.m_model, self.role.feijianModel.m_model.transform.localScale, Model_Default_Scale, fly_down_time)
    if self.role.feijianModel.mShadowObj and not self.role.feijianModel.mShadowObj.isnil then
      local shadowPosition = self.role.feijianModel.mShadowObj.transform.localPosition
      local shadowToPosition = EC.Vector3.new(shadowPosition.x, 0, shadowPosition.z)
      PositionGameObjectTween.TweenGameObjectPosition(self.role.feijianModel.mShadowObj, shadowPosition, shadowToPosition, fly_down_time)
    end
    if self.role.mShadowObj and not self.role.mShadowObj.isnil then
      self.role.mShadowObj:SetActive(false)
    end
    if curX == x and curY == y then
      self.role.feijianModel:Play(FlyModule.FlyDownAnimation)
      local animationName = self.role:HasAnimClip(FlyModule.FlyDownAnimation) and FlyModule.FlyDownAnimation or ActionName.FightStand
      self.role:Play(animationName)
    else
      self.role.feijianModel:Play(FlyModule.FlyDownAnimation)
      local animationName = self.role:HasAnimClip(FlyModule.FlyDownAnimation) and FlyModule.FlyDownAnimation or ActionName.FightStand
      self.role:Play(animationName)
      local downSpeed = 0
      self.role.movePath, downSpeed = self.role:MakeFlyPathFixedTime(x, y, fly_down_ani_time)
      self.role:_RunPath(self.role.movePath, downSpeed, self.role.feijianModel.m_model, runpathCallback)
    end
  end
  local function doFly()
    if self.destroyed then
      return
    end
    if self.role:IsInState(RoleState.BEHUG) then
      return
    end
    if self.role.feijianModel == nil then
      self.role.feijianModel = ECAirCraft.new(0, self.role)
      self.role.feijianModel:Load2(self.cfg.modelPath, OnLoadFeijianDone, true)
    elseif not self.role.feijianModel:IsObjLoaded() then
      self.role.feijianModel:Destroy()
      self.role.feijianModel = ECAirCraft.new(0, self.role)
      self.role.feijianModel:Load2(self.cfg.modelPath, OnLoadFeijianDone, true)
    else
      OnLoadFeijianDone(self.role.feijianModel)
    end
  end
  if self.role.m_model == nil and self.role:IsInLoading() then
    self.role:AddOnLoadCallback("runpath", doFly)
  else
    doFly()
  end
end
def.virtual("number", "number", "function").FlyTo = function(self, x, y, callback)
  local function OnActionDone()
    if self.destroyed then
      return
    end
    if not self:CheckFeijianModel() then
      return
    end
    if not self:CheckRoleModel() then
      if self.role:IsInLoading() then
        self.role:AddOnLoadCallback("runpath", OnActionDone)
      end
      return
    end
    self.role.flyState = ECPlayer.FlyState.Flight
    self.role.flyPoint = nil
    if callback then
      callback()
    end
  end
  local function OnLoadFeijianDone(ret)
    if self.destroyed then
      return
    end
    if ret == nil then
      return
    end
    if not self:CheckFeijianModel() then
      return
    end
    if not self:CheckRoleModel() then
      if self.role:IsInLoading() then
        self.role:AddOnLoadCallback("runpath", function(ret)
          OnLoadFeijianDone(ret)
        end)
      end
      return
    end
    self:LeaveMount()
    self.role.feijianModel:InitShadow()
    self.role.feijianModel.colorId = self.colorId
    self.role.feijianModel:SetColoration(nil)
    self.role:RemoveFlyComponent()
    if self.role:IsMe() then
      ECGame.Instance():ResetSkyLayer()
      FlyModule.Instance():FlowCloud(0.001, "fly")
    end
    if not self:IsShowFeijian() then
      self.role.feijianModel:SetActive(false)
    end
    if not self.role.showModel then
      self.role.feijianModel:SetShowModel(false)
    end
    self.role.flyState = ECPlayer.FlyState.Flight
    self.role.flyPoint = {x = x, y = y}
    local commonMove = self.role:GetOrAddMovePathComp()
    commonMove:Stop()
    commonMove:set_enabled(true)
    commonMove:set_IsAnimate(true)
    commonMove:set_MoveAnimationName(FlyModule.FlyIdleAnimation)
    commonMove:set_StandAnimationName(FlyModule.FlyIdleAnimation)
    local animationName = self.role:HasAnimClip(FlyModule.FlyIdleAnimation) and FlyModule.FlyIdleAnimation or ActionName.FightStand
    if self.role:IsInState(RoleState.HUG) then
      animationName = FlyModule.FlyIdleHugAnimation
    end
    self.role:Play(animationName)
    self.role.nameOffset = self:GetNameOffset()
    if self.role.m_uiNameHandle then
      self.role.m_uiNameHandle:GetComponent("HUDFollowTarget").offset = EC.Vector3.new(0, self.role.nameOffset, 0)
    end
    self.role.feijianModel:SetAnimCullingType(0)
    self.role:SetAnimCullingType(0)
    self.role:SetLayer(ClientDef_Layer.FlyPlayer)
    self.role.feijianModel:SetLayer(ClientDef_Layer.FlyPlayer)
    if self.role.mECFabaoComponent then
      self.role.mECFabaoComponent:FlyUp()
    end
    self.role.feijianModel:Play(FlyModule.FlyIdleAnimation)
    if self.cfg.effectPath and self.role.feijianEffect == nil then
      self.role.feijianEffect = self.role.feijianModel:AttachEffectToBone(self.cfg.effectPath, "Bip01")
      if self.role.feijianEffect then
        self.role.feijianEffect.transform.localRotation = Quaternion.Euler(EC.Vector3.new(0, 0, 0))
        self.role.feijianEffect:SetLayer(ClientDef_Layer.FlyPlayer)
        local FXModule = require("Main.FX.FXModule")
        FXModule.Instance():AddManagedFx(self.role.feijianEffect)
      end
    end
    local roleAttach = self.role.feijianModel:GetAttach(FlyModule.FlyTag)
    if roleAttach ~= nil then
      self.role.feijianModel:ChangeAttach(FlyModule.FlyTag, FlyModule.FlyTag, "HH_Point")
    else
      self.role.feijianModel:AttachModel(FlyModule.FlyTag, self.role, "HH_Point")
    end
    local curX = self.role.m_node2d.localPosition.x
    local curY = self.role.m_node2d.localPosition.y
    Set2DPosTo3D(curX, world_height - curY, self.t_pos)
    local modelToPositin = EC.Vector3.new(self.t_pos.x, 0 + self.upHeight, self.t_pos.z)
    self.role.feijianModel.m_model.transform.localPosition = modelToPositin
    self.role.feijianModel.m_model.transform.localScale = Model_Default_Scale * self.skyScale
    if self.role.feijianModel.mShadowObj and not self.role.feijianModel.mShadowObj.isnil then
      local shadowPosition = self.role.feijianModel.mShadowObj.transform.localPosition
      local shadowToPosition = EC.Vector3.new(shadowPosition.x, 0 - self.upHeight / self.skyScale, shadowPosition.z)
      self.role.feijianModel.mShadowObj.transform.localPosition = shadowToPosition
    end
    if self.role.mShadowObj and not self.role.mShadowObj.isnil then
      self.role.mShadowObj:SetActive(false)
    end
    local pet = self.role:GetPet()
    if pet then
      local PubroleModule = require("Main.Pubrole.PubroleModule")
      PubroleModule.Instance():RoleStopFollow(pet)
      self.role:RemovePet()
    end
    self.role.movePath = self.role:MakeFlyPath(x, y)
    self.role:_RunPath(self.role.movePath, self.cfg.velocity, self.role.feijianModel.m_model, OnActionDone)
  end
  local function doFly()
    if self.destroyed then
      return
    end
    if self.role:IsInState(RoleState.BEHUG) then
      return
    end
    if self.role.feijianModel == nil then
      self.role.feijianModel = ECAirCraft.new(0, self.role)
      self.role.feijianModel:Load2(self.cfg.modelPath, OnLoadFeijianDone, true)
    elseif not self.role.feijianModel:IsObjLoaded() then
      self.role.feijianModel:Destroy()
      self.role.feijianModel = ECAirCraft.new(0, self.role)
      self.role.feijianModel:Load2(self.cfg.modelPath, OnLoadFeijianDone, true)
    else
      OnLoadFeijianDone(self.role.feijianModel)
    end
  end
  if self.role.m_model == nil and self.role:IsInLoading() then
    self.role:AddOnLoadCallback("runpath", doFly)
  else
    doFly()
  end
end
def.virtual("number", "number", "function").FlyAt = function(self, x, y, callback)
  local function OnLoadFeijianDone(ret)
    if self.destroyed then
      return
    end
    if ret == nil then
      return
    end
    if not self:CheckFeijianModel() then
      return
    end
    if not self:CheckRoleModel() then
      if self.role:IsInLoading() then
        self.role:AddOnLoadCallback("runpath", function(ret)
          OnLoadFeijianDone(ret)
        end)
      end
      return
    end
    self:LeaveMount()
    self.role.feijianModel:InitShadow()
    self.role.feijianModel.colorId = self.colorId
    self.role.feijianModel:SetColoration(nil)
    self.role:SetPos(x, y)
    self.role:RemoveFlyComponent()
    if self.role:IsMe() then
      ECGame.Instance():ResetSkyLayer()
      FlyModule.Instance():FlowCloud(0.001, "fly")
    end
    if not self:IsShowFeijian() then
      self.role.feijianModel:SetActive(false)
    end
    if not self.role.showModel then
      self.role.feijianModel:SetShowModel(false)
    end
    self.role.flyState = ECPlayer.FlyState.Flight
    self.role.flyPoint = nil
    local commonMove = self.role:GetOrAddMovePathComp()
    commonMove:Stop()
    commonMove:set_enabled(false)
    commonMove:set_IsAnimate(true)
    commonMove:set_MoveAnimationName(FlyModule.FlyIdleAnimation)
    commonMove:set_StandAnimationName(FlyModule.FlyIdleAnimation)
    local animationName = self.role:HasAnimClip(FlyModule.FlyIdleAnimation) and FlyModule.FlyIdleAnimation or ActionName.FightStand
    if self.role:IsInState(RoleState.HUG) then
      animationName = FlyModule.FlyIdleHugAnimation
    end
    self.role:Play(animationName)
    self.role.nameOffset = self:GetNameOffset()
    if self.role.m_uiNameHandle then
      self.role.m_uiNameHandle:GetComponent("HUDFollowTarget").offset = EC.Vector3.new(0, self.role.nameOffset, 0)
    end
    self.role.feijianModel:SetAnimCullingType(0)
    self.role:SetAnimCullingType(0)
    self.role:SetLayer(ClientDef_Layer.FlyPlayer)
    self.role.feijianModel:SetLayer(ClientDef_Layer.FlyPlayer)
    if self.role.mECFabaoComponent then
      self.role.mECFabaoComponent:FlyUp()
    end
    self.role.feijianModel:Play(FlyModule.FlyIdleAnimation)
    if self.cfg.effectPath and self.role.feijianEffect == nil then
      self.role.feijianEffect = self.role.feijianModel:AttachEffectToBone(self.cfg.effectPath, "Bip01")
      if self.role.feijianEffect then
        self.role.feijianEffect.transform.localRotation = Quaternion.Euler(EC.Vector3.new(0, 0, 0))
        self.role.feijianEffect:SetLayer(ClientDef_Layer.FlyPlayer)
        local FXModule = require("Main.FX.FXModule")
        FXModule.Instance():AddManagedFx(self.role.feijianEffect)
      end
    end
    local roleAttach = self.role.feijianModel:GetAttach(FlyModule.FlyTag)
    if roleAttach ~= nil then
      self.role.feijianModel:ChangeAttach(FlyModule.FlyTag, FlyModule.FlyTag, "HH_Point")
    else
      self.role.feijianModel:AttachModel(FlyModule.FlyTag, self.role, "HH_Point")
    end
    local curX = self.role.m_node2d.localPosition.x
    local curY = self.role.m_node2d.localPosition.y
    Set2DPosTo3D(curX, world_height - curY, self.t_pos)
    local modelPosition = self.t_pos
    local modelToPositin = EC.Vector3.new(modelPosition.x, 0 + self.upHeight, modelPosition.z)
    self.role.feijianModel.m_model.transform.localPosition = modelToPositin
    self.role.feijianModel.m_model.transform.localScale = Model_Default_Scale * self.skyScale
    if self.role.feijianModel.mShadowObj and not self.role.feijianModel.mShadowObj.isnil then
      local shadowPosition = self.role.feijianModel.mShadowObj.transform.localPosition
      local shadowToPosition = EC.Vector3.new(shadowPosition.x, 0 - self.upHeight / self.skyScale, shadowPosition.z)
      self.role.feijianModel.mShadowObj.transform.localPosition = shadowToPosition
    end
    if self.role.mShadowObj and not self.role.mShadowObj.isnil then
      self.role.mShadowObj:SetActive(false)
    end
    local pet = self.role:GetPet()
    if pet then
      local PubroleModule = require("Main.Pubrole.PubroleModule")
      PubroleModule.Instance():RoleStopFollow(pet)
      self.role:RemovePet()
    end
    if callback then
      return callback()
    end
  end
  local function doFly()
    if self.destroyed then
      return
    end
    if self.role:IsInState(RoleState.BEHUG) then
      return
    end
    if self.role.feijianModel == nil then
      self.role.feijianModel = ECAirCraft.new(0, self.role)
      self.role.feijianModel:Load2(self.cfg.modelPath, OnLoadFeijianDone, true)
    elseif not self.role.feijianModel:IsObjLoaded() then
      self.role.feijianModel:Destroy()
      self.role.feijianModel = ECAirCraft.new(0, self.role)
      self.role.feijianModel:Load2(self.cfg.modelPath, OnLoadFeijianDone, true)
    else
      OnLoadFeijianDone(self.role.feijianModel)
    end
  end
  if self.role.m_model == nil and self.role:IsInLoading() then
    self.role:AddOnLoadCallback("runpath", doFly)
  else
    doFly()
  end
end
def.virtual().Hug = function(self)
  if self.role == nil or self.role.huggedRole == nil then
    return
  end
  local function doHug()
    if self.role:IsInState(RoleState.HUG) and self.role.huggedRole:IsInState(RoleState.BEHUG) and self.role:IsLoaded() and self.role.huggedRole:IsLoaded() then
      if self.role.huggedRole.feijianModel then
        self.role.huggedRole:RemoveFlyComponent()
        self.role.huggedRole.feijianModel:Detach(FlyModule.FlyTag)
        self.role.huggedRole.feijianModel:Destroy()
        self.role.huggedRole.feijianModel = nil
      end
      if self.role:HasBone("HH_fly") then
        self.role:AttachModelEx("hug", self.role.huggedRole, "HH_fly", EC.Vector3.zero, EC.Vector3.zero)
      else
        self.role:CreateBone("HH_fly", "", EC.Vector3.new(0, 0, 0.8), EC.Vector3.zero)
        self.role:AttachModelEx("hug", self.role.huggedRole, "HH_fly", EC.Vector3.zero, EC.Vector3.zero)
      end
      if self.role:IsInState(RoleState.FLY) then
        self.role:Play(FlyModule.FlyIdleHugAnimation)
        if self.role.mECPartComponent then
          self.role.mECPartComponent:SetVisible(false)
        end
        self:BeHugged()
      end
      self.role:DoMoveAfter()
    end
  end
  local allLoaded = true
  if self.role.m_model == nil and self.role:IsInLoading() then
    allLoaded = false
    self.role:AddOnLoadCallback("hug", doHug)
  end
  if self.role.huggedRole.m_model == nil and self.role.huggedRole:IsInLoading() then
    allLoaded = false
    self.role.huggedRole:AddOnLoadCallback("hug", doHug)
  end
  if allLoaded then
    doHug()
  end
end
def.virtual().Unhug = function(self)
  if self.role == nil or self.role.huggedRole == nil then
    return
  end
  local huggedRole = self.role:Detach("hug")
  if self.role.mECPartComponent then
    self.role.mECPartComponent:SetVisible(true)
  end
  local curX = self.role.m_node2d.localPosition.x
  local curY = self.role.m_node2d.localPosition.y
  self.role:FlyAt(curX, curY, nil)
  self:BeUnhugged()
end
def.virtual().BeHugged = function(self)
  if self.role == nil or self.role.huggedRole == nil then
    return
  end
  if self.role.huggedRole:IsMe() then
    local ECGame = require("Main.ECGame")
    ECGame.Instance():ResetSkyLayer()
    FlyModule.Instance():FlowCloud(0.001, "fly")
  end
  local commonMove = self.role.huggedRole:GetOrAddMovePathComp()
  if commonMove then
    commonMove:set_enabled(false)
  end
  if self.role.huggedRole.m_model and not self.role.huggedRole.m_model.isnil then
    self.role.huggedRole.m_model.transform.localPosition = EC.Vector3.zero
    self.role.huggedRole.m_model.transform.localScale = EC.Vector3.one
    self.role.huggedRole.m_model.transform.localRotation = Quaternion.Euler(EC.Vector3.zero)
    self.role.huggedRole:SetLayer(ClientDef_Layer.FlyPlayer)
    self.role.huggedRole:Play(FlyModule.FlyIdleHugAnimation)
  end
  self.role.huggedRole:SetModelIsRender(true)
  self.role.huggedRole:SetBoneIsRender(true)
  if self.role.huggedRole.mShadowObj and not self.role.huggedRole.mShadowObj.isnil then
    self.role.huggedRole.mShadowObj:SetActive(false)
  end
  if self.role.huggedRole.mECPartComponent then
    self.role.huggedRole.mECPartComponent:SetVisible(false)
  end
end
def.virtual().BeUnhugged = function(self)
  if self.role == nil or self.role.huggedRole == nil then
    return
  end
  local pos = self.role.huggedRole:GetPos()
  if self.role.huggedRole.m_model and not self.role.huggedRole.m_model.isnil then
    self.role.huggedRole:SetParentNode(self.role.defaultParentNode)
    if pos then
      Set2DPosTo3D(pos.x, world_height - pos.y, self.t_pos)
      local p = EC.Vector3.new(self.t_pos.x, self.upHeight, self.t_pos.z)
      self.role.huggedRole.m_model.localPosition = p
      self.role.huggedRole.m_model.transform.localScale = EC.Vector3.one
      self.role.huggedRole.m_model.transform.localRotation = Quaternion.Euler(EC.Vector3.zero)
      self.role.huggedRole:SetLayer(ClientDef_Layer.FlyPlayer)
      self.role.huggedRole:Play(FlyModule.FlyIdleHugAnimation)
    end
    if self.role.m_model and not self.role.m_model.isnil then
      self.role.huggedRole.m_model.localRotation = self.role.m_model.localRotation
    end
  end
  if self.role.huggedRole.mShadowObj and not self.role.huggedRole.mShadowObj.isnil then
    self.role.huggedRole.mShadowObj:SetActive(true)
  end
  if self.role.huggedRole.mECPartComponent then
    self.role.huggedRole.mECPartComponent:SetVisible(true)
  end
  if pos then
    local feijianId = self.role.huggedRole:GetFeijianId()
    if feijianId > 0 then
      self.role.huggedRole:FlyAt(pos.x, pos.y, nil)
    else
      self.role.huggedRole:FlyDown(nil)
    end
  end
end
def.virtual("table", "table").FlyEscort = function(self, escortTarget, targetPos)
  local role = self.role
  if role:HasBone("HH_fly") then
    role:AttachModelEx("hug", escortTarget, "HH_fly", EC.Vector3.zero, EC.Vector3.zero)
  else
    role:CreateBone("HH_fly", "", EC.Vector3.new(0, 0, 0.8), EC.Vector3.zero)
    role:AttachModelEx("hug", escortTarget, "HH_fly", EC.Vector3.zero, EC.Vector3.zero)
  end
  role:Play(FlyModule.FlyIdleHugAnimation)
  role:SetState(RoleState.HUG)
  escortTarget:SetLayer(ClientDef_Layer.FlyPlayer)
  escortTarget:Play(FlyModule.FlyIdleHugAnimation)
  if escortTarget.mShadowObj then
    escortTarget.mShadowObj:SetActive(false)
  end
  if role.mECPartComponent then
    role.mECPartComponent:SetVisible(false)
  end
  if role:IsMe() then
    local heroModule = gmodule.moduleMgr:GetModule(ModuleId.HERO)
    local Space = require("consts.mzm.gsp.map.confbean.Space")
    if heroModule.escortTargetPos then
      heroModule:LockMove(false)
      heroModule.myRole:SetState(RoleState.ESCORT)
      heroModule:MoveToPos(0, heroModule.escortTargetPos.x, heroModule.escortTargetPos.y, Space.SKY, 0, MoveType.FLY, nil)
    end
  elseif targetPos then
    role:FlyTo(targetPos.x, targetPos.y, nil)
  end
end
StrategyBase.Commit()
return StrategyBase

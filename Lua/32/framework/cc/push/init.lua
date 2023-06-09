local CURRENT_MODULE_NAME = (...)
local providers = {"CocoPush", "UmengPush"}
for _, packageName in ipairs(providers) do
  local className = "push." .. packageName
  if not cc.Registry.exists(className) then
    cc.Registry.add(import("." .. packageName, CURRENT_MODULE_NAME), className)
  end
end
local push = class("cc.push")
local DEFAULT_PROVIDER_OBJECT_NAME = "push.default"
function push:ctor()
  cc(self):addComponent("components.behavior.EventProtocol"):exportMethods()
  self.events = import(".events", CURRENT_MODULE_NAME)
  self.umengAliasType = import(".UmengAliasType", CURRENT_MODULE_NAME)
  self.providers_ = {}
end
function push:start(name)
  if not self.providers_[name] then
    local providerFactoryClass = cc.Registry.newObject(name)
    local provider = providerFactoryClass.getInstance(self)
    if not provider then
      printError("cc.push:start() - create push provider failed")
      return
    end
    self.providers_[name] = provider
    if not self.providers_[DEFAULT_PROVIDER_OBJECT_NAME] then
      self.providers_[DEFAULT_PROVIDER_OBJECT_NAME] = provider
    end
  end
end
function push:stop(name)
  local provider = self:getProvider(name)
  if provider then
    provider:removeListener()
    self.providers_[name or DEFAULT_PROVIDER_OBJECT_NAME] = nil
  end
end
function push:doCommand(args)
  local provider = self:getProvider(name)
  if provider then
    provider:doCommand(args)
  end
end
function push:getProvider(name)
  name = name or DEFAULT_PROVIDER_OBJECT_NAME
  if self.providers_[name] then
    return self.providers_[name]
  end
  printError("cc.push:getProvider() - provider %s not exists", name)
end
return push

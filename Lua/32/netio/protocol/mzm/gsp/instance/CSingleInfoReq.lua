local CSingleInfoReq = class("CSingleInfoReq")
CSingleInfoReq.TYPEID = 12591374
function CSingleInfoReq:ctor(instanceCfgid, process)
  self.id = 12591374
  self.instanceCfgid = instanceCfgid or nil
  self.process = process or nil
end
function CSingleInfoReq:marshal(os)
  os:marshalInt32(self.instanceCfgid)
  os:marshalInt32(self.process)
end
function CSingleInfoReq:unmarshal(os)
  self.instanceCfgid = os:unmarshalInt32()
  self.process = os:unmarshalInt32()
end
function CSingleInfoReq:sizepolicy(size)
  return size <= 65535
end
return CSingleInfoReq

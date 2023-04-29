local CSignInReq = class("CSignInReq")
CSignInReq.TYPEID = 12593416
function CSignInReq:ctor(signday, current_yuan_bao_num, is_use_yuan_bao)
  self.id = 12593416
  self.signday = signday or nil
  self.current_yuan_bao_num = current_yuan_bao_num or nil
  self.is_use_yuan_bao = is_use_yuan_bao or nil
end
function CSignInReq:marshal(os)
  os:marshalInt32(self.signday)
  os:marshalInt64(self.current_yuan_bao_num)
  os:marshalInt32(self.is_use_yuan_bao)
end
function CSignInReq:unmarshal(os)
  self.signday = os:unmarshalInt32()
  self.current_yuan_bao_num = os:unmarshalInt64()
  self.is_use_yuan_bao = os:unmarshalInt32()
end
function CSignInReq:sizepolicy(size)
  return size <= 65535
end
return CSignInReq

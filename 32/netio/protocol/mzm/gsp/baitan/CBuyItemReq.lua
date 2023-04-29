local CBuyItemReq = class("CBuyItemReq")
CBuyItemReq.TYPEID = 12584961
function CBuyItemReq:ctor(index, itemid, num, price)
  self.id = 12584961
  self.index = index or nil
  self.itemid = itemid or nil
  self.num = num or nil
  self.price = price or nil
end
function CBuyItemReq:marshal(os)
  os:marshalInt32(self.index)
  os:marshalInt32(self.itemid)
  os:marshalInt32(self.num)
  os:marshalInt32(self.price)
end
function CBuyItemReq:unmarshal(os)
  self.index = os:unmarshalInt32()
  self.itemid = os:unmarshalInt32()
  self.num = os:unmarshalInt32()
  self.price = os:unmarshalInt32()
end
function CBuyItemReq:sizepolicy(size)
  return size <= 65535
end
return CBuyItemReq

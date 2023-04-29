local CUR_CLASS_NAME = (...)
local Lplus = require("Lplus")
local RankListData = Lplus.Class(CUR_CLASS_NAME)
local def = RankListData.define
def.const("number").OUT_OF_RANK_LIST = 0
def.field("table").list = nil
def.field("table").top3Data = nil
def.field("number").type = 0
def.field("table").requsetList = nil
def.field("number").selfRank = 0
def.field("dynamic").selfValue = 0
def.field("number").colCount = 4
def.field("number").top3Index = 4
def.final("number", "=>", RankListData).New = function(type)
  local obj = RankListData()
  obj.type = type
  return obj
end
def.virtual("=>", "boolean").IsOpen = function(self)
  return true
end
def.virtual("=>", "boolean").IsExpire = function(self)
  return true
end
def.method("number", "number", "function").ReqRankList = function(self, from, to, callback)
  if self.list and self.list[from] and not self:IsExpire() then
    if callback then
      callback(self)
    end
  else
    self:OnReqRankList(from, to, callback)
  end
end
def.virtual("number", "number", "function").OnReqRankList = function(self, from, to, callback)
end
def.virtual("table").UnmarshalProtocol = function(self, p)
end
def.method("function").ReqSelfRankInfo = function(self, callback)
  self:OnReqSelfRankInfo(callback)
end
def.virtual("function").OnReqSelfRankInfo = function(self, callback)
end
def.virtual("number").ReqTopNUnitInfo = function(self, number)
  if self.list == nil then
    warn("ranklist not init type = " .. self.type)
    return
  end
  local roleIdList = {}
  for i = 1, number do
    local v = self.list[i]
    if v == nil then
      break
    end
    local roleId = v.roleId and v.roleId or v.roleid
    if roleId == nil then
      break
    end
    table.insert(roleIdList, roleId)
  end
  local Top3Mgr = require("Main.RankList.Top3Mgr")
  Top3Mgr.Instance():ReqRoleModelList(self.type, roleIdList)
end
def.virtual("number", "number", "=>", "table").GetViewData = function(self, from, to)
  if not textRes.RankList.Title[self.type] then
    local title = {
      "empty",
      "empty",
      "empty",
      "empty"
    }
  end
  local viewData = self:GetListViewData(from, to) or {}
  viewData.title = title
  return viewData
end
def.virtual("number", "number", "=>", "table").GetListViewData = function(self, from, to)
  warn("ranklist data not spec, type = ", self.type)
  return nil
end
def.virtual("=>", "boolean").IsShowTop3 = function(self)
  return true
end
def.virtual("=>", "boolean").IsShowMyRank = function(self)
  return true
end
def.virtual("=>", "number").GetSelfRank = function(self)
  return self.selfRank
end
def.virtual("=>", "dynamic").GetSelfValue = function(self)
  return self.selfValue
end
def.virtual("number", "=>", "table").GetTopNViewData = function(self, number)
  local displayInfoList = self:GetViewData(1, RankListPanel.TOP_N)
  local top3Data = self.top3Data
  local displayDatas = {}
  for i = 1, RankListPanel.TOP_N do
    local displayInfo = displayInfoList[i]
    if displayInfo == nil then
      break
    end
    local titleAndValue = displayInfoList.title[self.top3Index]
    titleAndValue = string.format(textRes.RankList[2], titleAndValue) .. tostring(displayInfo[self.top3Index])
    local displayData = {
      titleAndValue = titleAndValue,
      name = tostring(displayInfo[2]),
      modelInfo = top3Data.list[i]
    }
    table.insert(displayDatas, displayData)
  end
end
def.virtual("number").ShowUnitInfo = function(self, index)
  local roleId = self:TryGetRoleId(index)
  if roleId then
    local RankUnitInfoMgr = require("Main.RankList.RankUnitInfoMgr")
    RankUnitInfoMgr.Instance():ShowRoleInfo(roleId)
  end
end
def.method("function").AddRequest = function(self, callback)
  self.requsetList = self.requsetList or {}
  for i, req in ipairs(self.requsetList) do
    if req == callback then
      return
    end
  end
  table.insert(self.requsetList, callback)
end
def.method().Callback = function(self)
  if self.requsetList == nil then
    return
  end
  for i, req in ipairs(self.requsetList) do
    req(self)
  end
  self.requsetList = {}
end
def.method("number", "=>", "userdata").TryGetRoleId = function(self, index)
  if self.list == nil then
    return nil
  end
  local v = self.list[index]
  if v == nil then
    return nil
  end
  local roleId = v.roleId and v.roleId or v.roleid
  return roleId
end
def.virtual("=>", "table").GetExtraInfo = function(self)
  return nil
end
return RankListData.Commit()

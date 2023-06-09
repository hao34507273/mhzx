local OctetsStream = require("netio.OctetsStream")
local BigBossErrorCode = require("netio.protocol.mzm.gsp.bigboss.BigBossErrorCode")
local GetBigBossRemoteRankContext = require("netio.protocol.mzm.gsp.bigboss.GetBigBossRemoteRankContext")
local GetBigBossRemoteRank_ClientReq = require("netio.protocol.mzm.gsp.bigboss.GetBigBossRemoteRank_ClientReq")
local GetRoleBigBossRemoteRankContext = require("netio.protocol.mzm.gsp.bigboss.GetRoleBigBossRemoteRankContext")
local GetRoleBigBossRemoteRank_ClientReq = require("netio.protocol.mzm.gsp.bigboss.GetRoleBigBossRemoteRank_ClientReq")
local ReportRoleBigBossRemoteRankInfoContext = require("netio.protocol.mzm.gsp.bigboss.ReportRoleBigBossRemoteRankInfoContext")
local RemoveRoleBigBossRemoteRankInfoContext = require("netio.protocol.mzm.gsp.bigboss.RemoveRoleBigBossRemoteRankInfoContext")
local BigBossImportBean = class("BigBossImportBean")
function BigBossImportBean:ctor(_BigBossErrorCode, _GetBigBossRemoteRankContext, _GetBigBossRemoteRank_ClientReq, _GetRoleBigBossRemoteRankContext, _GetRoleBigBossRemoteRank_ClientReq, _ReportRoleBigBossRemoteRankInfoContext, _RemoveRoleBigBossRemoteRankInfoContext)
  self._BigBossErrorCode = _BigBossErrorCode or BigBossErrorCode.new()
  self._GetBigBossRemoteRankContext = _GetBigBossRemoteRankContext or GetBigBossRemoteRankContext.new()
  self._GetBigBossRemoteRank_ClientReq = _GetBigBossRemoteRank_ClientReq or GetBigBossRemoteRank_ClientReq.new()
  self._GetRoleBigBossRemoteRankContext = _GetRoleBigBossRemoteRankContext or GetRoleBigBossRemoteRankContext.new()
  self._GetRoleBigBossRemoteRank_ClientReq = _GetRoleBigBossRemoteRank_ClientReq or GetRoleBigBossRemoteRank_ClientReq.new()
  self._ReportRoleBigBossRemoteRankInfoContext = _ReportRoleBigBossRemoteRankInfoContext or ReportRoleBigBossRemoteRankInfoContext.new()
  self._RemoveRoleBigBossRemoteRankInfoContext = _RemoveRoleBigBossRemoteRankInfoContext or RemoveRoleBigBossRemoteRankInfoContext.new()
end
function BigBossImportBean:marshal(os)
  self._BigBossErrorCode:marshal(os)
  self._GetBigBossRemoteRankContext:marshal(os)
  self._GetBigBossRemoteRank_ClientReq:marshal(os)
  self._GetRoleBigBossRemoteRankContext:marshal(os)
  self._GetRoleBigBossRemoteRank_ClientReq:marshal(os)
  self._ReportRoleBigBossRemoteRankInfoContext:marshal(os)
  self._RemoveRoleBigBossRemoteRankInfoContext:marshal(os)
end
function BigBossImportBean:unmarshal(os)
  self._BigBossErrorCode = BigBossErrorCode.new()
  self._BigBossErrorCode:unmarshal(os)
  self._GetBigBossRemoteRankContext = GetBigBossRemoteRankContext.new()
  self._GetBigBossRemoteRankContext:unmarshal(os)
  self._GetBigBossRemoteRank_ClientReq = GetBigBossRemoteRank_ClientReq.new()
  self._GetBigBossRemoteRank_ClientReq:unmarshal(os)
  self._GetRoleBigBossRemoteRankContext = GetRoleBigBossRemoteRankContext.new()
  self._GetRoleBigBossRemoteRankContext:unmarshal(os)
  self._GetRoleBigBossRemoteRank_ClientReq = GetRoleBigBossRemoteRank_ClientReq.new()
  self._GetRoleBigBossRemoteRank_ClientReq:unmarshal(os)
  self._ReportRoleBigBossRemoteRankInfoContext = ReportRoleBigBossRemoteRankInfoContext.new()
  self._ReportRoleBigBossRemoteRankInfoContext:unmarshal(os)
  self._RemoveRoleBigBossRemoteRankInfoContext = RemoveRoleBigBossRemoteRankInfoContext.new()
  self._RemoveRoleBigBossRemoteRankInfoContext:unmarshal(os)
end
return BigBossImportBean

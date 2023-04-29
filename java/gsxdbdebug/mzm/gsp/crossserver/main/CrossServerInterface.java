/*      */ package mzm.gsp.crossserver.main;
/*      */ 
/*      */ import com.goldhuman.Common.Octets;
/*      */ import hub.CrossCompeteEnterRole;
/*      */ import hub.CrossCompeteFactionDutyMembers;
/*      */ import hub.CrossCompeteSignUpFaction;
/*      */ import hub.CrossCompeteUserDataBack;
/*      */ import hub.DataBroadcast;
/*      */ import hub.DataTransferReq;
/*      */ import hub.DataTransferReqXidWrapper;
/*      */ import hub.DataTransferRsp;
/*      */ import hub.DataTransferRspXidWrapper;
/*      */ import hub.HubCorpsCVCInfo;
/*      */ import hub.NotifyIndianaAwardRoleInfo;
/*      */ import hub.RecallNotifyBindFriendReq;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import mzm.gsp.GameServer;
/*      */ import mzm.gsp.crossbattle.point.CorpsPointRaceInfo;
/*      */ import mzm.gsp.crossbattle.point.PointRaceInfo;
/*      */ import mzm.gsp.crossbattle.point.RolePointRaceMarkingInfo;
/*      */ import org.apache.log4j.Logger;
/*      */ 
/*      */ public class CrossServerInterface
/*      */ {
/*      */   public static void onDataTransferReq(DataTransferReq req)
/*      */   {
/*   28 */     DataTransferHandler<?, ?> handler = DataTransferHandlerManager.getInstance().getHandler(req.data_type);
/*   29 */     if (handler == null)
/*      */     {
/*   31 */       GameServer.logger().error(String.format("[crossserver]CrossServerInterface.onDataTransferReq@hanlder not register|direction=%d|xid=%d|src_id=%d|dst_id=%d|data_type=%d", new Object[] { Byte.valueOf(req.direction), Integer.valueOf(req.xid), Integer.valueOf(req.src_id), Integer.valueOf(req.dst_id), Integer.valueOf(req.data_type) }));
/*      */       
/*      */ 
/*      */ 
/*   35 */       return;
/*      */     }
/*      */     
/*      */     try
/*      */     {
/*   40 */       handler.onDataTransferReq(req, req.data);
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*   44 */       GameServer.logger().error(String.format("[crossserver]CrossServerInterface.onDataTransferReq@handle data transfer req error|direction=%d|xid=%d|src_id=%d|dst_id=%d|data_type=%d", new Object[] { Byte.valueOf(req.direction), Integer.valueOf(req.xid), Integer.valueOf(req.src_id), Integer.valueOf(req.dst_id), Integer.valueOf(req.data_type) }), e);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void onDataTransferTimeout(DataTransferReqXidWrapper reqXidWrapper, int code)
/*      */   {
/*   53 */     DataTransferReq req = reqXidWrapper.getProtocol();
/*   54 */     if (req == null)
/*      */     {
/*   56 */       GameServer.logger().error("[crossserver]CrossServerInterface.onDataTransferTimeout@req is null");
/*   57 */       return;
/*      */     }
/*      */     
/*   60 */     DataTransferHandler<?, ?> handler = DataTransferHandlerManager.getInstance().getHandler(req.data_type);
/*   61 */     if (handler == null)
/*      */     {
/*   63 */       GameServer.logger().error(String.format("[crossserver]CrossServerInterface.onDataTransferTimeout@hanlder not register|direction=%d|xid=%d|src_id=%d|dst_id=%d|data_type=%d|code=%d", new Object[] { Byte.valueOf(req.direction), Integer.valueOf(req.xid), Integer.valueOf(req.src_id), Integer.valueOf(req.dst_id), Integer.valueOf(req.data_type), Integer.valueOf(code) }));
/*      */       
/*      */ 
/*      */ 
/*   67 */       return;
/*      */     }
/*      */     
/*      */     try
/*      */     {
/*   72 */       handler.onDataTransferTimeout(reqXidWrapper, req.data, code);
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*   76 */       GameServer.logger().error(String.format("[crossserver]CrossServerInterface.onDataTransferTimeout@hanlder not register|direction=%d|xid=%d|src_id=%d|dst_id=%d|data_type=%d|code=%d", new Object[] { Byte.valueOf(req.direction), Integer.valueOf(req.xid), Integer.valueOf(req.src_id), Integer.valueOf(req.dst_id), Integer.valueOf(req.data_type), Integer.valueOf(code) }), e);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void onDataTransferRsp(DataTransferReqXidWrapper reqXidWrapper, DataTransferRspXidWrapper rspXidWrapper)
/*      */   {
/*   87 */     DataTransferReq req = reqXidWrapper.getProtocol();
/*   88 */     if (req == null)
/*      */     {
/*   90 */       GameServer.logger().error("[crossserver]CrossServerInterface.onDataTransferRsp@req is null");
/*   91 */       return;
/*      */     }
/*      */     
/*   94 */     DataTransferRsp rsp = rspXidWrapper.getProtocol();
/*   95 */     if (rsp == null)
/*      */     {
/*   97 */       GameServer.logger().error("[crossserver]CrossServerInterface.onDataTransferRsp@rsp is null");
/*   98 */       return;
/*      */     }
/*      */     
/*  101 */     DataTransferHandler<?, ?> handler = DataTransferHandlerManager.getInstance().getHandler(req.data_type);
/*  102 */     if (handler == null)
/*      */     {
/*  104 */       GameServer.logger().error(String.format("[crossserver]CrossServerInterface.onDataTransferRsp@handler not register|direction=%d|xid=%d|src_id=%d|dst_id=%d|data_type=%d|retcode=%d", new Object[] { Byte.valueOf(rsp.direction), Integer.valueOf(rsp.xid), Integer.valueOf(rsp.src_id), Integer.valueOf(rsp.dst_id), Integer.valueOf(rsp.data_type), Integer.valueOf(rsp.retcode) }));
/*      */       
/*      */ 
/*      */ 
/*  108 */       return;
/*      */     }
/*      */     
/*      */     try
/*      */     {
/*  113 */       handler.onDataTransferRsp(reqXidWrapper, req.data, rspXidWrapper, rsp.data);
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  117 */       GameServer.logger().error(String.format("[crossserver]CrossServerInterface.onDataTransferRsp@handle data transfer rsp error|direction=%d|xid=%d|src_id=%d|dst_id=%d|data_type=%d|retcode=%d", new Object[] { Byte.valueOf(rsp.direction), Integer.valueOf(rsp.xid), Integer.valueOf(rsp.src_id), Integer.valueOf(rsp.dst_id), Integer.valueOf(rsp.data_type), Integer.valueOf(rsp.retcode) }), e);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void onDataBroadcast(DataBroadcast broadcast)
/*      */   {
/*  126 */     DataBroadcastHandler<?> handler = DataBroadcastHandlerManager.getInstance().getHandler(broadcast.data_type);
/*  127 */     if (handler == null)
/*      */     {
/*  129 */       GameServer.logger().error(String.format("[crossserver]CrossServerInterface.onDataBroadcast@hanlder not register|direction=%d|seq=%d|src_id=%d|data_type=%d", new Object[] { Byte.valueOf(broadcast.direction), Integer.valueOf(broadcast.seq), Integer.valueOf(broadcast.src_id), Integer.valueOf(broadcast.data_type) }));
/*      */       
/*      */ 
/*      */ 
/*  133 */       return;
/*      */     }
/*      */     
/*      */     try
/*      */     {
/*  138 */       handler.onDataBroadcast(broadcast, broadcast.data);
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  142 */       GameServer.logger().error(String.format("[crossserver]CrossServerInterface.onDataBroadcast@handle data broadcast error|direction=%d|seq=%d|src_id=%d|data_type=%d", new Object[] { Byte.valueOf(broadcast.direction), Integer.valueOf(broadcast.seq), Integer.valueOf(broadcast.src_id), Integer.valueOf(broadcast.data_type) }), e);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static long match(int levelRange, long leaderRoleid, List<RoleMatchMarkingInfo> roleMatchMarkingInfos, MatchActivityContext activityContext)
/*      */   {
/*  164 */     MatchContext context = MatchContextManager.getInstance().createMatchContext(levelRange, leaderRoleid, roleMatchMarkingInfos, activityContext);
/*      */     
/*  166 */     long contextid = context.contextid;
/*  167 */     if (CrossServerManager.joinMatch(context))
/*      */     {
/*  169 */       return contextid;
/*      */     }
/*      */     
/*  172 */     MatchContextManager.getInstance().removeContext(contextid);
/*      */     
/*  174 */     return -1L;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean cancelMatch(long contextid)
/*      */   {
/*  187 */     MatchContext context = MatchContextManager.getInstance().getContext(contextid);
/*  188 */     if (context == null)
/*      */     {
/*  190 */       return false;
/*      */     }
/*      */     
/*  193 */     if (!CrossServerManager.cancelMatch(context))
/*      */     {
/*  195 */       return false;
/*      */     }
/*      */     
/*  198 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static MatchActivityContext getMatchActivityContext(long contextid)
/*      */   {
/*  211 */     MatchContext context = MatchContextManager.getInstance().getContext(contextid);
/*  212 */     if (context == null)
/*      */     {
/*  214 */       return null;
/*      */     }
/*  216 */     return context.activityContext;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static Long getLeaderid(int contextid)
/*      */   {
/*  229 */     MatchContext context = MatchContextManager.getInstance().getContext(contextid);
/*  230 */     if (context == null)
/*      */     {
/*  232 */       return null;
/*      */     }
/*  234 */     return Long.valueOf(context.leaderid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static List<RoleMatchMarkingInfo> getRoleMatchMarkingInfos(long contextid)
/*      */   {
/*  247 */     MatchContext context = MatchContextManager.getInstance().getContext(contextid);
/*  248 */     if (context == null)
/*      */     {
/*  250 */       return null;
/*      */     }
/*  252 */     return context.roleMatchMarkingInfos;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static Long getOpponentLeaderid(long contextid)
/*      */   {
/*  265 */     MatchContext context = MatchContextManager.getInstance().getContext(contextid);
/*  266 */     if (context == null)
/*      */     {
/*  268 */       return null;
/*      */     }
/*  270 */     return Long.valueOf(context.getOpponentLeaderid());
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static List<RoleMatchMarkingInfo> getOpponentRoleMatchMarkingInfos(long contextid)
/*      */   {
/*  283 */     MatchContext context = MatchContextManager.getInstance().getContext(contextid);
/*  284 */     if (context == null)
/*      */     {
/*  286 */       return null;
/*      */     }
/*  288 */     return context.getOpponentRoleMatchMarkingInfos();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static RoamType getRoamType(String userid)
/*      */   {
/*  303 */     return CrossServerManager.getRoamType(userid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static Long getRoamedInstanceid(String userid)
/*      */   {
/*  318 */     return CrossServerManager.getRoamedRoomInstanceid(userid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static RoamedMatchContext getRoamedMatchContext(long roamedInstanceid)
/*      */   {
/*  331 */     return RoamedMatchContextManager.getInstance().getRoamedMathContext(roamedInstanceid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void genRoamToken(RoamContext context)
/*      */   {
/*  341 */     CrossServerManager.genRoamToken(context);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean asyncCleanLadderRank(long rankid, Octets context)
/*      */   {
/*  356 */     return CrossServerManager.asyncCleanLadderRank(rankid, context);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean asyncReportLadderRankInfo(long rankid, long roleid, String roleName, int occupation, int displayRanking, int ranking, Octets context)
/*      */   {
/*  383 */     return CrossServerManager.asyncReportLadderRankInfo(rankid, roleid, roleName, occupation, displayRanking, ranking, context);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean asyncRemoveLadderRankInfo(long rankid, long roleid, Octets context)
/*      */   {
/*  402 */     return CrossServerManager.asyncRemoveLadderRankInfo(rankid, roleid, context);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean asyncGetLadderRoleRank(long rankid, long roleid, Octets context)
/*      */   {
/*  416 */     return CrossServerManager.asyncGetLadderRoleRank(rankid, roleid, context);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean asyncGetLadderRankRange(long rankid, int from, int to, Octets context)
/*      */   {
/*  434 */     return CrossServerManager.asyncGetLadderRankRange(rankid, from, to, context);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void onCleanRankInfoDone(int retcode, int rankType, long rankid, Octets context)
/*      */   {
/*  446 */     CrossServerManager.onCleanRankInfoDone(retcode, rankType, rankid, context);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void onRemoveRankInfoDone(int retcode, int rankType, long rankid, long chartObjid, Octets context)
/*      */   {
/*  460 */     CrossServerManager.onRemoveRankInfoDone(retcode, rankType, rankid, chartObjid, context);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void onReportRankInfoDone(int retcode, int rankType, long rankid, long chartObjid, Octets chartObjInfo, Octets context)
/*      */   {
/*  475 */     CrossServerManager.onReportRankInfoDone(retcode, rankType, rankid, chartObjid, chartObjInfo, context);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void onGetRankDone(int retcode, int rankType, long rankid, long chartObjid, Octets context, int rank)
/*      */   {
/*  490 */     CrossServerManager.onGetRankDone(retcode, rankType, rankid, chartObjid, context, rank);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void onGetRankRangeDone(int retcode, int rankType, long rankid, int from, int to, Octets context, int cardinality, List<byte[]> rankRangeInfos)
/*      */   {
/*  507 */     CrossServerManager.onGetRankRangeDone(retcode, rankType, rankid, from, to, context, cardinality, rankRangeInfos);
/*      */   }
/*      */   
/*      */   public static boolean reportGameServerBalanceInfo(int onlineNum)
/*      */   {
/*  512 */     return CrossServerManager.reportGameServerBalanceInfo(onlineNum);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean reportCrossCompeteSignUp(long startTime, List<CrossCompeteSignUpFaction> factions, boolean bForce)
/*      */   {
/*  526 */     return CrossServerManager.reportCrossCompeteSignUp(startTime, factions, bForce);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean requireCrossCompeteRoamServers(long startTime, List<Integer> competes)
/*      */   {
/*  540 */     return CrossServerManager.requireCrossCompeteRoamServers(startTime, competes);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean reportCrossCompeteFactionInfo(long factionid, String factionName, List<CrossCompeteFactionDutyMembers> dutyMembers, int designTitleid, int activeCount, int roamServerid)
/*      */   {
/*  561 */     return CrossServerManager.reportCrossCompeteFactionInfo(factionid, factionName, dutyMembers, designTitleid, activeCount, roamServerid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean enterCrossCompeteMap(long factionid, List<CrossCompeteEnterRole> roles, int roamServerid, boolean isTeam)
/*      */   {
/*  577 */     return CrossServerManager.enterCrossCompeteMap(factionid, roles, roamServerid, isTeam);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean crossCompeteRoleDataBack(long roleid, String userid, Octets userToken, int winTimes, int loseTimes, int escapeTimes, int winStreakAwardTimes, int treasureAward, int reason)
/*      */   {
/*  597 */     return CrossServerManager.crossCompeteRoleDataBack(roleid, userid, userToken, winTimes, loseTimes, escapeTimes, winStreakAwardTimes, treasureAward, reason);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean notifyCrossCompeteResult(long factionid, long winFactionid, long loseFactionid)
/*      */   {
/*  611 */     return CrossServerManager.notifyCrossCompeteResult(factionid, winFactionid, loseFactionid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean crossCompeteTeamBack(List<CrossCompeteUserDataBack> users)
/*      */   {
/*  622 */     return CrossServerManager.crossCompeteTeamBack(users);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean reportCrossBattleOwnResult(int activityCfgid, Map<Long, Octets> result)
/*      */   {
/*  636 */     return CrossServerManager.reportCrossBattleOwnResult(activityCfgid, result);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void onReportCrossBattleOwnResultDone(int retcode, int activityCfgid)
/*      */   {
/*  649 */     CrossServerManager.onReportCrossBattleOwnResultDone(retcode, activityCfgid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean clearCrossBattleOwnResult(int activityCfgid, Map<Long, Octets> result)
/*      */   {
/*  663 */     return CrossServerManager.clearCrossBattleOwnResult(activityCfgid, result);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void onClearCrossBattleOwnResultDone(int retcode, int activityCfgid)
/*      */   {
/*  676 */     CrossServerManager.onClearCrossBattleOwnResultDone(retcode, activityCfgid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean reportCorpsFightValue(int activityCfgid, int zoneNum, boolean force, Map<Long, Float> corpsFightValues)
/*      */   {
/*  689 */     return CrossServerManager.reportCorpsFightValue(activityCfgid, zoneNum, force, corpsFightValues);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean asyncGetCorpsZone(Octets context)
/*      */   {
/*  701 */     return CrossServerManager.asyncGetCorpsZone(context);
/*      */   }
/*      */   
/*      */   public static void onGetCorpsZoneDone(int retcode, Octets context, Map<Long, Integer> data)
/*      */   {
/*  706 */     CrossServerManager.onGetCorpsZoneDone(retcode, context, data);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static long joinPointRace(long corpsid, long leaderRoleid, List<RolePointRaceMarkingInfo> rolePointRaceMarkingInfos, PointRaceInfo pointRaceInfo)
/*      */   {
/*  726 */     PointRaceContext context = PointRaceContextManager.getInstance().createPointRaceContext(corpsid, leaderRoleid, rolePointRaceMarkingInfos, pointRaceInfo);
/*      */     
/*  728 */     long contextid = context.contextid;
/*  729 */     if (CrossServerManager.joinPointRace(context))
/*      */     {
/*  731 */       return contextid;
/*      */     }
/*  733 */     PointRaceContextManager.getInstance().removeContext(contextid);
/*  734 */     return -1L;
/*      */   }
/*      */   
/*      */   public static boolean roamPointRaceData(long contextid, hub.PointRaceCorpsInfo corpsInfo)
/*      */   {
/*  739 */     PointRaceContext context = PointRaceContextManager.getInstance().getContext(contextid);
/*  740 */     if (context == null)
/*      */     {
/*  742 */       return false;
/*      */     }
/*  744 */     return CrossServerManager.roamPointRaceData(context, corpsInfo);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean updatePointRaceCorps(int dstZoneid, int activityCfgid, int timePointCfgid, long corpsid, int win, int lose, int point, long updateTime)
/*      */   {
/*  762 */     return CrossServerManager.updatePointRaceCorps(dstZoneid, activityCfgid, timePointCfgid, corpsid, win, lose, point, updateTime);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean reportPointRaceCorpsCVC(int activityCfgid, int zone, int timePointCfgid, Map<Long, Map<Long, HubCorpsCVCInfo>> corpsCVCInfos)
/*      */   {
/*  777 */     return CrossServerManager.reportPointRaceCorpsCVC(activityCfgid, zone, timePointCfgid, corpsCVCInfos);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean asyncReportCorpsPointRace(Octets context)
/*      */   {
/*  789 */     return CrossServerManager.asyncReportCorpsPointRace(context);
/*      */   }
/*      */   
/*      */   public static void onReportCorpsPointRaceDone(int retcode, Octets context)
/*      */   {
/*  794 */     CrossServerManager.onReportCorpsPointRaceDone(retcode, context);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean notifyPointRaceEnd(int activityCfgid, int zone, int timePointCfgid)
/*      */   {
/*  807 */     return CrossServerManager.notifyPointRaceEnd(activityCfgid, zone, timePointCfgid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean asyncGetZonePointRace(int activityCfgid, int zone, Octets context)
/*      */   {
/*  820 */     return CrossServerManager.asyncGetZonePointRace(activityCfgid, zone, context);
/*      */   }
/*      */   
/*      */ 
/*      */   public static void onGetZonePointRaceDone(int retcode, int activityCfgid, int zone, Octets context, List<CorpsPointRaceInfo> corpsPointRaceInfos)
/*      */   {
/*  826 */     CrossServerManager.onGetZonePointRaceDone(retcode, activityCfgid, zone, context, corpsPointRaceInfos);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean asyncRemovePointRace(int activityCfgid, int zone, int timePointCfgid, Octets context)
/*      */   {
/*  841 */     return CrossServerManager.asyncRemovePointRace(activityCfgid, zone, timePointCfgid, context);
/*      */   }
/*      */   
/*      */ 
/*      */   public static void onRemovePointRaceDone(int retcode, int activityCfgid, int zone, int timePointCfgid, Octets context)
/*      */   {
/*  847 */     CrossServerManager.onRemovePointRaceDone(retcode, activityCfgid, zone, timePointCfgid, context);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static long joinSelectionOrFianl(int fightType, int fightStage, long leaderRoleid, int fightIndexId, KnockOutTeamInfo crossBattleTeamInfo, KnockOutProcessContext SelectionFinalPhaseContext)
/*      */   {
/*  858 */     KnockOutContext context = KnockOutContextManager.getInstance().createCrossBattleContext(fightType, fightStage, leaderRoleid, fightIndexId, crossBattleTeamInfo, SelectionFinalPhaseContext);
/*      */     
/*  860 */     long contextid = context.gameServerContextId;
/*  861 */     if (CrossServerManager.joinSelectionFinalMatch(context))
/*      */     {
/*  863 */       return contextid;
/*      */     }
/*      */     
/*      */ 
/*  867 */     KnockOutContextManager.getInstance().removeContext(contextid);
/*      */     
/*  869 */     return -1L;
/*      */   }
/*      */   
/*      */ 
/*      */   public static boolean notifySelectionFightBeign(long corpsId, int ownZoneId, int fightType, int fightStage, int fightIndexId, long fightRecordId)
/*      */   {
/*  875 */     return CrossServerManager.notifyKnockOutFightBegin(corpsId, ownZoneId, fightType, fightStage, fightIndexId, fightRecordId);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean treadFriendsCircle(long activeTreadRoleId, long beTrodRoleId, int beTrodRoleZoneId, boolean isCanGetMoreTreasureBox, boolean isAutoTread, long treadSerialId)
/*      */   {
/*  897 */     return CrossServerManager.treadFriendsCircle(activeTreadRoleId, beTrodRoleId, beTrodRoleZoneId, isCanGetMoreTreasureBox, isAutoTread, treadSerialId);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean giveFriendsCircleGift(long activeGiveRoleId, String activeGiveRoleName, long receiveRoleId, int receiveRoleZoneId, int giftItemCfgId, int giftGrade, int giftItemNum, int addPopularity, String giveGiftMessage, long giftSerialId)
/*      */     throws java.io.UnsupportedEncodingException
/*      */   {
/*  923 */     return CrossServerManager.giveFriendsCircleGfit(activeGiveRoleId, activeGiveRoleName, receiveRoleId, receiveRoleZoneId, giftItemCfgId, giftGrade, giftItemNum, addPopularity, giveGiftMessage, giftSerialId);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean deleteFriendsCircleTreadHistory(long activeTreadRoleId, long beTrodRoleId, long treadSerialId, int receiveRoleZoneId)
/*      */   {
/*  933 */     return CrossServerManager.deleteFriendsCircleTreadHistory(activeTreadRoleId, beTrodRoleId, treadSerialId, receiveRoleZoneId);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean deleteFriendsCircleGfitHistory(long activeGiveRoleId, long receiveRoleId, long giftSerialId, int receiveRoleZoneId)
/*      */   {
/*  943 */     return CrossServerManager.deleteFriendsCircleGfitHistory(activeGiveRoleId, receiveRoleId, giftSerialId, receiveRoleZoneId);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean operatorFriendsCircleBlacklist(long activeRoleId, long blackedRoleId, int blackRoleZoneId, int operator)
/*      */   {
/*  953 */     return CrossServerManager.operatorFriendsCircleBlacklist(activeRoleId, blackedRoleId, blackRoleZoneId, operator);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean setRoleRoamServerStatus(String userid, long roleid)
/*      */   {
/*  968 */     return CrossServerManager.setRoleRoamServerStatus(userid, roleid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void unsetRoleRoamServerStatus(String userid, long roleid)
/*      */   {
/*  982 */     CrossServerManager.unsetRoleRoamServerStatus(userid, roleid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void setUserRoamedInfo(String userid, RoamType roamType, long roamedRoomInstanceid)
/*      */   {
/*  994 */     CrossServerManager.setUserRoamedInfo(userid, roamType, roamedRoomInstanceid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void removeUserRoamedInfo(String userid, RoamType roamType)
/*      */   {
/* 1005 */     CrossServerManager.removeUserRoamedInfo(userid, roamType);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean removeUserRoamedInfo(String userid, RoamType roamType, long roamedRoomInstanceid)
/*      */   {
/* 1019 */     return CrossServerManager.removeUserRoamedInfo(userid, roamType, roamedRoomInstanceid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean setRoamServerDateForGM(int roamZoneid, String dateValue)
/*      */   {
/* 1031 */     return CrossServerManager.setRoamServerDateForGM(roamZoneid, dateValue);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean setServerDateForGM(String dateValue)
/*      */   {
/* 1042 */     return CrossServerManager.setServerDateForGM(dateValue);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static long joinSingleCrossFieldMatch(SingleCrossFieldRoamRoleInfo roleInfo, int activityCfgid)
/*      */   {
/* 1057 */     SingleCrossFieldContext context = SingleCrossFieldContextManager.getInstance().createContext(roleInfo, activityCfgid);
/*      */     
/* 1059 */     if (context == null)
/*      */     {
/* 1061 */       return -1L;
/*      */     }
/* 1063 */     long contextid = context.getContextid();
/* 1064 */     if (CrossServerManager.joinSingleCrossFieldMatch(context))
/*      */     {
/* 1066 */       return contextid;
/*      */     }
/* 1068 */     MatchContextManager.getInstance().removeContext(contextid);
/* 1069 */     return -1L;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static SingleCrossFieldContext getSingleCrossFieldContext(long contextid)
/*      */   {
/* 1081 */     return SingleCrossFieldContextManager.getInstance().getContext(contextid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean cancelSingleCrossFieldMatch(long contextid)
/*      */   {
/* 1094 */     SingleCrossFieldContext context = SingleCrossFieldContextManager.getInstance().getContext(contextid);
/* 1095 */     if (context == null)
/*      */     {
/* 1097 */       return false;
/*      */     }
/* 1099 */     if (context.isCanceling())
/*      */     {
/* 1101 */       return false;
/*      */     }
/* 1103 */     if (context.getProcess() != 0)
/*      */     {
/* 1105 */       return false;
/*      */     }
/* 1107 */     if (!CrossServerManager.cancelSingleCrossFieldMatch(context))
/*      */     {
/* 1109 */       return false;
/*      */     }
/* 1111 */     context.setIsCanceling(true);
/* 1112 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean reportRoleSingleCrossFieldRankInfo(long rankid, long roleid, String name, int occupation, int starNum, long timestamp, Octets context)
/*      */   {
/* 1139 */     return CrossServerManager.reportRoleSingleCrossFieldRankInfo(rankid, roleid, name, occupation, starNum, timestamp, context);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean getRoleSingleCrossFieldRankInfo(long rankid, long roleid, Octets context)
/*      */   {
/* 1157 */     return CrossServerManager.getRoleSingleCrossFieldRankInfo(rankid, roleid, context);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean getSingleCrossFieldRankRange(long rankid, int from, int to, Octets context)
/*      */   {
/* 1176 */     return CrossServerManager.getSingleCrossFieldRankRange(rankid, from, to, context);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean transferChatContent(int destZoneid, long roleid, int channel, long orgKey, Octets chatContent)
/*      */   {
/* 1197 */     return CrossServerManager.transferChatContent(destZoneid, roleid, channel, orgKey, chatContent);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean reportRoleCrossBattleBetWinRankInfo(long rankid, long roleid, String name, int occupation, long profit, long timestamp, Octets context)
/*      */   {
/* 1224 */     return CrossServerManager.reportRoleCrossBattleBetWinRankInfo(rankid, roleid, name, occupation, profit, timestamp, context);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean removeRoleCrossBattleBetWinRankInfo(long rankid, long roleid, Octets context)
/*      */   {
/* 1243 */     return CrossServerManager.removeRoleCrossBattleBetWinRankInfo(rankid, roleid, context);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean getRoleCrossBattleBetWinRankInfo(long rankid, long roleid, Octets context)
/*      */   {
/* 1260 */     return CrossServerManager.getRoleCrossBattleBetWinRankInfo(rankid, roleid, context);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean getCrossBattleBetWinRankRange(long rankid, int from, int to, Octets context)
/*      */   {
/* 1279 */     return CrossServerManager.getCrossBattleBetWinRankRange(rankid, from, to, context);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean reportRoleCrossBattleBetLoseRankInfo(long rankid, long roleid, String name, int occupation, long profit, long timestamp, Octets context)
/*      */   {
/* 1306 */     return CrossServerManager.reportRoleCrossBattleBetLoseRankInfo(rankid, roleid, name, occupation, profit, timestamp, context);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean removeRoleCrossBattleBetLoseRankInfo(long rankid, long roleid, Octets context)
/*      */   {
/* 1325 */     return CrossServerManager.removeRoleCrossBattleBetLoseRankInfo(rankid, roleid, context);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean getRoleCrossBattleBetLoseRankInfo(long rankid, long roleid, Octets context)
/*      */   {
/* 1342 */     return CrossServerManager.getRoleCrossBattleBetLoseRankInfo(rankid, roleid, context);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean getCrossBattleBetLoseRankRange(long rankid, int from, int to, Octets context)
/*      */   {
/* 1361 */     return CrossServerManager.getCrossBattleBetLoseRankRange(rankid, from, to, context);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean notifyBindFriend(int destZoneid, String userid, long roleid, RecallNotifyBindFriendReq reqData)
/*      */   {
/* 1376 */     return CrossServerManager.notifyBindFriend(destZoneid, userid, roleid, reqData);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void broadcastIndianaAwardRoleInfo(NotifyIndianaAwardRoleInfo data)
/*      */   {
/* 1386 */     CrossServerManager.broadcastIndianaAwardRoleInfo(data);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean reportAllLottoCandidateInfo(int activityCfgid, int turn, long roleid, String roleName, int occupation, int gender, int level, int avatarid, int avatarFrameid)
/*      */   {
/* 1416 */     return CrossServerManager.reportAllLottoCandidateInfo(activityCfgid, turn, roleid, roleName, occupation, gender, level, avatarid, avatarFrameid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean reportRoleBigBossRankInfo(long rankid, long roleid, String name, int occupation, int damagePoint, Octets context)
/*      */   {
/* 1442 */     return CrossServerManager.reportRoleBigBossRankInfo(rankid, roleid, name, occupation, damagePoint, context);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean removeRoleBigBossRankInfo(long rankid, long roleid, Octets context)
/*      */   {
/* 1460 */     return CrossServerManager.removeRoleBigBossRankInfo(rankid, roleid, context);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean getRoleBigBossRankInfo(long rankid, long roleid, Octets context)
/*      */   {
/* 1477 */     return CrossServerManager.getRoleBigBossRankInfo(rankid, roleid, context);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean getBigBossRankRange(long rankid, int from, int to, Octets context)
/*      */   {
/* 1496 */     return CrossServerManager.getBigBossRankRange(rankid, from, to, context);
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\CrossServerInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
/*      */ package mzm.gsp.crossbattle.knockout;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import com.goldhuman.Common.Octets;
/*      */ import hub.DataBroadcast;
/*      */ import hub.DataTransferReq;
/*      */ import hub.ExchangeDataHandlerInfo;
/*      */ import hub.FightResult;
/*      */ import hub.GHubHelper;
/*      */ import hub.NotifyCrossBattleFinalBulletion;
/*      */ import hub.SelectionOrFinalDataBackReq;
/*      */ import java.io.UnsupportedEncodingException;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.Collections;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Random;
/*      */ import java.util.Set;
/*      */ import java.util.concurrent.TimeUnit;
/*      */ import java.util.concurrent.locks.Lock;
/*      */ import java.util.concurrent.locks.ReadWriteLock;
/*      */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*      */ import mzm.event.TriggerEventsManger;
/*      */ import mzm.gsp.GameServer;
/*      */ import mzm.gsp.GameServerInfoManager;
/*      */ import mzm.gsp.bulletin.SBulletinInfo;
/*      */ import mzm.gsp.common.TimeCommonUtil;
/*      */ import mzm.gsp.common.confbean.STimePointCommonCfg;
/*      */ import mzm.gsp.crossbattle.CrossBattleSelectionMatchRoleInfo;
/*      */ import mzm.gsp.crossbattle.CrossBattleSelectionProcessInfo;
/*      */ import mzm.gsp.crossbattle.GetKnockOutContext;
/*      */ import mzm.gsp.crossbattle.GetKnockOutContext_Refresh;
/*      */ import mzm.gsp.crossbattle.SCrossBattleFinalNormalRes;
/*      */ import mzm.gsp.crossbattle.SCrossBattleSelectionNormalRes;
/*      */ import mzm.gsp.crossbattle.SNotifyKnockOutCorpsQualification;
/*      */ import mzm.gsp.crossbattle.SUpdateCrossBattleSelectionProcessInfo;
/*      */ import mzm.gsp.crossbattle.confbean.CrossBattleConsts;
/*      */ import mzm.gsp.crossbattle.confbean.FinalMatchBean;
/*      */ import mzm.gsp.crossbattle.confbean.KnockOutCfg;
/*      */ import mzm.gsp.crossbattle.confbean.SCrossBattleFinalCfg;
/*      */ import mzm.gsp.crossbattle.confbean.SCrossBattleFinalMatchCfg;
/*      */ import mzm.gsp.crossbattle.confbean.SCrossBattleKnockOutCfg;
/*      */ import mzm.gsp.crossbattle.event.GetFinalChampionMapStatue;
/*      */ import mzm.gsp.crossbattle.event.GetFinalChampionMapStatueArg;
/*      */ import mzm.gsp.crossbattle.own.CrossBattleOwnInterface;
/*      */ import mzm.gsp.crossbattle.point.CrossBattlePointInterface;
/*      */ import mzm.gsp.crossserver.main.KnockOutContext;
/*      */ import mzm.gsp.crossserver.main.KnockOutContextManager;
/*      */ import mzm.gsp.crossserver.main.KnockOutRoleInfo;
/*      */ import mzm.gsp.crossserver.main.RoamedKnockOutContext;
/*      */ import mzm.gsp.crossserver.main.RoamedKnockOutRoleInfo;
/*      */ import mzm.gsp.crossserver.main.RoamedKnockOutTeamInfo;
/*      */ import mzm.gsp.grc.main.GrcInterface;
/*      */ import mzm.gsp.online.main.LoginManager;
/*      */ import mzm.gsp.online.main.OnlineManager;
/*      */ import mzm.gsp.open.main.OpenInterface;
/*      */ import mzm.gsp.role.main.RoleInterface;
/*      */ import mzm.gsp.status.main.RoleStatusInterface;
/*      */ import mzm.gsp.tlog.TLogManager;
/*      */ import mzm.gsp.util.DateTimeUtils;
/*      */ import mzm.gsp.util.LogicProcedure;
/*      */ import mzm.gsp.util.Pair;
/*      */ import org.apache.log4j.Logger;
/*      */ import xbean.FightAgainstInfo;
/*      */ import xbean.FightStageInfo;
/*      */ import xbean.FightZoneInfo;
/*      */ import xdb.Executor;
/*      */ import xdb.Xdb;
/*      */ 
/*      */ public class CrossBattleKnockoutManager
/*      */ {
/*   75 */   static int GLOBAL_FIGHT_ZONE = 1;
/*      */   
/*   77 */   static Map<Long, KnockOutAbstainObserver> corpsId2AbstainObserverMap = Collections.synchronizedMap(new HashMap());
/*      */   
/*      */ 
/*   80 */   static ReadWriteLock locker = new ReentrantReadWriteLock();
/*      */   
/*   82 */   static Map<Long, Pair<Long, Integer>> roleIdKnockOutRestartMap = new HashMap();
/*   83 */   static RestartKnockOutObserver restartKnockOutObserver = null;
/*      */   
/*      */ 
/*   86 */   static Set<Long> ownServerNowKnockOutCorpsIdSet = null;
/*      */   
/*   88 */   private static Map<Integer, KnockOutHandler> knockOutFightEndHandlerMap = new HashMap();
/*      */   
/*      */   static
/*      */   {
/*   92 */     knockOutFightEndHandlerMap.put(Integer.valueOf(1), new KnockOutSelectionHandler());
/*   93 */     knockOutFightEndHandlerMap.put(Integer.valueOf(2), new KnockOutFinalHandler());
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
/*      */   public static int getFightZone(long corpsId, int activityCfgId, int knockoutType)
/*      */   {
/*  110 */     switch (knockoutType)
/*      */     {
/*      */     case 1: 
/*  113 */       int ownFightZoneId = CrossBattlePointInterface.getCorpsZone(activityCfgId, corpsId);
/*  114 */       if (ownFightZoneId <= 0)
/*      */       {
/*  116 */         return -1;
/*      */       }
/*  118 */       return ownFightZoneId;
/*      */     
/*      */     case 2: 
/*  121 */       return GLOBAL_FIGHT_ZONE;
/*      */     }
/*      */     
/*  124 */     return -1;
/*      */   }
/*      */   
/*      */ 
/*      */   static xio.Protocol getNormalRes(int knockOutType, int ret)
/*      */   {
/*  130 */     switch (knockOutType)
/*      */     {
/*      */     case 1: 
/*  133 */       SCrossBattleSelectionNormalRes sCrossBattleSelectionNormalRes = new SCrossBattleSelectionNormalRes(ret);
/*  134 */       return sCrossBattleSelectionNormalRes;
/*      */     
/*      */     case 2: 
/*  137 */       SCrossBattleFinalNormalRes sCrossBattleFinalNormalRes = new SCrossBattleFinalNormalRes(ret);
/*  138 */       return sCrossBattleFinalNormalRes;
/*      */     }
/*      */     
/*  141 */     return null;
/*      */   }
/*      */   
/*      */ 
/*      */   static int getMaxFightZone(int activityCfgId, int knockOutType)
/*      */   {
/*  147 */     switch (knockOutType)
/*      */     {
/*      */     case 1: 
/*  150 */       return CrossBattlePointInterface.getZoneNum();
/*      */     
/*      */     case 2: 
/*  153 */       return GLOBAL_FIGHT_ZONE;
/*      */     }
/*  155 */     return -1;
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
/*      */   public static List<Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>> getFinalInitFightRelationList(int activityCfgId)
/*      */   {
/*  170 */     List<Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>> finalInitFightRelationList = new ArrayList();
/*  171 */     SCrossBattleFinalCfg sCrossBattleFinalCfg = SCrossBattleFinalCfg.get(activityCfgId);
/*  172 */     if (sCrossBattleFinalCfg == null)
/*      */     {
/*  174 */       return finalInitFightRelationList;
/*      */     }
/*      */     
/*  177 */     SCrossBattleFinalMatchCfg sCrossBattleSelectionMatchCfg = SCrossBattleFinalMatchCfg.get(sCrossBattleFinalCfg.final_match_cfg_id);
/*  178 */     if (sCrossBattleSelectionMatchCfg == null)
/*      */     {
/*  180 */       return finalInitFightRelationList;
/*      */     }
/*  182 */     for (FinalMatchBean finalMatchBean : sCrossBattleSelectionMatchCfg.final_match_list)
/*      */     {
/*  184 */       Pair<Integer, Integer> aCorpsInfo = new Pair(Integer.valueOf(finalMatchBean.corps_a_fight_zone), Integer.valueOf(finalMatchBean.corps_a_zone_rank));
/*      */       
/*  186 */       Pair<Integer, Integer> bCorpsInfo = new Pair(Integer.valueOf(finalMatchBean.corps_b_fight_zone), Integer.valueOf(finalMatchBean.corps_b_zone_rank));
/*      */       
/*  188 */       Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> pair = new Pair(aCorpsInfo, bCorpsInfo);
/*      */       
/*      */ 
/*  191 */       finalInitFightRelationList.add(pair);
/*      */     }
/*      */     
/*  194 */     return finalInitFightRelationList;
/*      */   }
/*      */   
/*      */   static boolean isCanTakePartInKnockOut(long corpsId, FightZoneInfo xFightZoneInfo, int knockOutType)
/*      */   {
/*  199 */     Pair<Integer, Boolean> nowFinalStagePair = CrossBattleKnockoutInterface.getNowFightStage(knockOutType);
/*  200 */     if (nowFinalStagePair == null)
/*      */     {
/*  202 */       return false;
/*      */     }
/*      */     
/*  205 */     FightStageInfo xFightStageInfo = (FightStageInfo)xFightZoneInfo.getFight_stage_info_map().get(nowFinalStagePair.first);
/*  206 */     if (xFightStageInfo == null)
/*      */     {
/*  208 */       return false;
/*      */     }
/*      */     
/*  211 */     for (FightAgainstInfo xFightAgainstInfo : xFightStageInfo.getFight_against_info_map().values())
/*      */     {
/*  213 */       if ((xFightAgainstInfo.getA_corps_id() == corpsId) || (xFightAgainstInfo.getB_corps_id() == corpsId))
/*      */       {
/*  215 */         return true;
/*      */       }
/*      */     }
/*  218 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean doUnMatch(List<Long> roleids)
/*      */   {
/*  230 */     RoleStatusInterface.unsetStatus(roleids, 1371);
/*  231 */     RoleStatusInterface.unsetStatus(roleids, 40);
/*  232 */     RoleStatusInterface.unsetStatus(roleids, 1551);
/*  233 */     return true;
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
/*      */   public static void fillCrossBattleSelectionMatchInfo(CrossBattleSelectionMatchRoleInfo matchRoleInfo, RoamedKnockOutRoleInfo roamedRoleCrossBattleInfo)
/*      */     throws UnsupportedEncodingException
/*      */   {
/*  249 */     if (roamedRoleCrossBattleInfo.isLogined())
/*      */     {
/*  251 */       matchRoleInfo.process = 3;
/*      */     }
/*  253 */     else if (roamedRoleCrossBattleInfo.isDataPrepared())
/*      */     {
/*  255 */       matchRoleInfo.process = 2;
/*      */     }
/*      */     else
/*      */     {
/*  259 */       matchRoleInfo.process = 1;
/*      */     }
/*      */     
/*  262 */     matchRoleInfo.avatar_id = roamedRoleCrossBattleInfo.getAvatarId();
/*  263 */     matchRoleInfo.gender = roamedRoleCrossBattleInfo.getGender();
/*  264 */     matchRoleInfo.occupation = roamedRoleCrossBattleInfo.getOccupation();
/*      */     
/*  266 */     matchRoleInfo.role_level = roamedRoleCrossBattleInfo.getLevel();
/*  267 */     matchRoleInfo.role_name.setString(roamedRoleCrossBattleInfo.getRoleName(), "UTF-8");
/*  268 */     matchRoleInfo.roleid = roamedRoleCrossBattleInfo.getRoleid();
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
/*      */   public static mzm.gsp.crossserver.main.KnockOutTeamInfo getOpponentRoleMatchTeamInfo(long contextid)
/*      */   {
/*  281 */     KnockOutContext context = KnockOutContextManager.getInstance().getContext(contextid);
/*  282 */     if (context == null)
/*      */     {
/*  284 */       return null;
/*      */     }
/*  286 */     return context.getOpponentCrossBattleTeamInfo();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void goToCenterServerFail(Map<Long, String> role2Users, int errorCode)
/*      */   {
/*  297 */     List<Long> allRoles = new ArrayList(role2Users.keySet());
/*  298 */     RoleStatusInterface.unsetStatus(allRoles, 41);
/*      */     
/*  300 */     removeCancelMatchId(allRoles);
/*      */     
/*      */ 
/*  303 */     SCrossBattleSelectionNormalRes sCrossBattleSelectionNormalRes = new SCrossBattleSelectionNormalRes();
/*  304 */     sCrossBattleSelectionNormalRes.ret = errorCode;
/*  305 */     OnlineManager.getInstance().sendMulti(sCrossBattleSelectionNormalRes, allRoles);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void removeCancelMatchId(List<Long> roleids)
/*      */   {
/*  316 */     for (Iterator i$ = roleids.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*      */       
/*  318 */       xtable.Role2selectionfinalcontextid.remove(Long.valueOf(roleid));
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void onReturnOriginalServer(RoamedKnockOutContext roamedKnockOutContext, RoamedKnockOutTeamInfo teamInfo, RoamedKnockOutTeamInfo opponentTeamInfo, int zoneId, Map<Long, String> role2Users, List<Long> rolesList, Map<Long, ExchangeDataHandlerInfo> exchangeDateHandlerMap, boolean isWin, FightResult fightResult)
/*      */     throws UnsupportedEncodingException
/*      */   {
/*  331 */     int zoneid = GameServerInfoManager.getZoneidFromRoleid(((Long)rolesList.get(0)).longValue());
/*  332 */     onReturnOriginalServer(roamedKnockOutContext, teamInfo, opponentTeamInfo, role2Users, rolesList, exchangeDateHandlerMap, zoneid, isWin, fightResult);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void onReturnOriginalServer(RoamedKnockOutContext roamedContext, RoamedKnockOutTeamInfo ownTeamInfo, RoamedKnockOutTeamInfo opponentTeamInfo, Map<Long, String> role2Users, List<Long> roleIdList, Map<Long, ExchangeDataHandlerInfo> exchangeDateHandlerMap, int dstZoneid, boolean isWin, FightResult fightResult)
/*      */     throws UnsupportedEncodingException
/*      */   {
/*  342 */     SelectionOrFinalDataBackReq dataBackReq = new SelectionOrFinalDataBackReq();
/*  343 */     if (isWin)
/*      */     {
/*  345 */       dataBackReq.win_or_lose = 1;
/*      */     }
/*      */     else
/*      */     {
/*  349 */       dataBackReq.win_or_lose = 0;
/*      */     }
/*  351 */     dataBackReq.team_role_list.addAll(roleIdList);
/*  352 */     for (Iterator i$ = roleIdList.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*      */       
/*  354 */       String userId = (String)role2Users.get(Long.valueOf(roleId));
/*  355 */       if (userId == null)
/*      */       {
/*  357 */         StringBuilder sBuilder = new StringBuilder();
/*  358 */         sBuilder.append("[crossbattle_knockout]CrossBattleKnockoutManager.onReturnOriginalServer@user id not found");
/*  359 */         sBuilder.append("|data_back_req=").append(dataBackReq);
/*  360 */         sBuilder.append("|roam_context=").append(roamedContext);
/*  361 */         sBuilder.append("|own_team_info=").append(ownTeamInfo);
/*  362 */         sBuilder.append("|opponent_team_info=").append(opponentTeamInfo);
/*  363 */         sBuilder.append("|zone_id=").append(dstZoneid);
/*  364 */         sBuilder.append("|is_win=").append(isWin);
/*      */         
/*  366 */         GameServer.logger().info(sBuilder.toString());
/*      */       }
/*      */       else {
/*  369 */         dataBackReq.team_user_list.add(Octets.wrap(userId, "UTF-8"));
/*      */       } }
/*  371 */     dataBackReq.exchange_data_handler_info_map.putAll(exchangeDateHandlerMap);
/*      */     
/*  373 */     dataBackReq.fight_type = roamedContext.fightType;
/*  374 */     dataBackReq.fight_stage = roamedContext.fightStage;
/*  375 */     dataBackReq.fight_index_id = roamedContext.fightIndexId;
/*  376 */     dataBackReq.own_corps_id = ownTeamInfo.getCorpsId();
/*  377 */     dataBackReq.own_corps_name.setString(ownTeamInfo.getCorpsName(), "UTF-8");
/*  378 */     dataBackReq.opponent_corps_name.setString(opponentTeamInfo.getCorpsName(), "UTF-8");
/*  379 */     dataBackReq.opponent_corps_id = opponentTeamInfo.getCorpsId();
/*      */     
/*  381 */     DataTransferReq req = new DataTransferReq();
/*  382 */     req.direction = 0;
/*  383 */     req.data_type = 205;
/*  384 */     req.src_id = GameServerInfoManager.getZoneId();
/*  385 */     req.dst_id = dstZoneid;
/*  386 */     OctetsStream os = new OctetsStream();
/*  387 */     os.marshal(dataBackReq);
/*  388 */     req.data = os;
/*      */     
/*  390 */     if (!GHubHelper.sendDataTransferReq(req, true, 20))
/*      */     {
/*  392 */       StringBuilder sBuilder = new StringBuilder();
/*  393 */       sBuilder.append("[crossbattle_knockout]CrossBattleKnockoutManager.onReturnOriginalServer@can not transfor data");
/*  394 */       sBuilder.append("|data_back_req=").append(dataBackReq);
/*  395 */       sBuilder.append("|roam_context=").append(roamedContext);
/*  396 */       sBuilder.append("|own_team_info=").append(ownTeamInfo);
/*  397 */       sBuilder.append("|opponent_team_info=").append(opponentTeamInfo);
/*  398 */       sBuilder.append("|zone_id=").append(dstZoneid);
/*  399 */       sBuilder.append("|is_win=").append(isWin);
/*      */       
/*  401 */       GameServer.logger().error(sBuilder.toString());
/*      */       
/*  403 */       for (Iterator i$ = roleIdList.iterator(); i$.hasNext();) { final long roleid = ((Long)i$.next()).longValue();
/*      */         
/*  405 */         String userid = (String)role2Users.get(Long.valueOf(roleid));
/*  406 */         new LogicProcedure()
/*      */         {
/*      */ 
/*      */           protected boolean processImp()
/*      */             throws Exception
/*      */           {
/*  412 */             lock(xtable.User.getTable(), Arrays.asList(new String[] { this.val$userid }));
/*  413 */             LoginManager.getInstance().onReturnOrigianServer(this.val$userid, roleid);
/*  414 */             return true;
/*      */           }
/*      */         }.call();
/*      */       }
/*      */       
/*  419 */       Xdb.executor().schedule(new RRepeatReportKnockOutDataBack(dataBackReq, dstZoneid, 1), 60000L, TimeUnit.MILLISECONDS);
/*      */       
/*      */ 
/*  422 */       return;
/*      */     }
/*      */     
/*  425 */     StringBuilder sBuilder = new StringBuilder();
/*  426 */     sBuilder.append("[crossbattle_knockout]CrossBattleKnockoutManager.onReturnOriginalServer@send msg success");
/*  427 */     sBuilder.append("|data_back_req=").append(dataBackReq);
/*  428 */     sBuilder.append("|roam_context=").append(roamedContext);
/*  429 */     sBuilder.append("|own_team_info=").append(ownTeamInfo);
/*  430 */     sBuilder.append("|opponent_team_info=").append(opponentTeamInfo);
/*  431 */     sBuilder.append("|zone_id=").append(dstZoneid);
/*  432 */     sBuilder.append("|is_win=").append(isWin);
/*      */     
/*  434 */     GameServer.logger().info(sBuilder.toString());
/*      */   }
/*      */   
/*      */   private static class RRepeatReportKnockOutDataBack
/*      */     implements Runnable
/*      */   {
/*      */     private final SelectionOrFinalDataBackReq dataBackReq;
/*      */     private final int dstZoneId;
/*      */     private int repeatTimes;
/*      */     
/*      */     public RRepeatReportKnockOutDataBack(SelectionOrFinalDataBackReq dataBackReq, int dstZoneId, int repeatTimes)
/*      */     {
/*  446 */       this.dataBackReq = dataBackReq;
/*  447 */       this.dstZoneId = dstZoneId;
/*  448 */       this.repeatTimes = repeatTimes;
/*      */     }
/*      */     
/*      */ 
/*      */     public void run()
/*      */     {
/*  454 */       StringBuilder contextBuilder = new StringBuilder();
/*  455 */       contextBuilder.append("|data_back_req=").append(this.dataBackReq);
/*  456 */       contextBuilder.append("|dst_zone_id=").append(this.dstZoneId);
/*  457 */       contextBuilder.append("|repeat_times=").append(this.repeatTimes);
/*      */       
/*  459 */       DataTransferReq req = new DataTransferReq();
/*  460 */       req.direction = 0;
/*  461 */       req.data_type = 205;
/*  462 */       req.src_id = GameServerInfoManager.getZoneId();
/*  463 */       req.dst_id = this.dstZoneId;
/*  464 */       OctetsStream os = new OctetsStream();
/*  465 */       os.marshal(this.dataBackReq);
/*  466 */       req.data = os;
/*      */       
/*  468 */       if (!GHubHelper.sendDataTransferReq(req, true, 20))
/*      */       {
/*  470 */         StringBuilder sBuilder = new StringBuilder();
/*  471 */         sBuilder.append("[crossbattle_knockout]CrossBattleKnockOutManager.RRepeatReportKnockOutDataBack@send failed");
/*  472 */         sBuilder.append("context_builder=").append(contextBuilder.toString());
/*      */         
/*  474 */         GameServer.logger().info(sBuilder.toString());
/*      */         
/*  476 */         this.repeatTimes += 1;
/*  477 */         Xdb.executor().schedule(this, 60000L, TimeUnit.MILLISECONDS);
/*  478 */         return;
/*      */       }
/*      */       
/*  481 */       StringBuilder sBuilder = new StringBuilder();
/*  482 */       sBuilder.append("[crossbattle_knockout]CrossBattleKnockOutManager.RRepeatReportKnockOutDataBack@send success");
/*  483 */       sBuilder.append("context_builder=").append(contextBuilder.toString());
/*      */       
/*  485 */       GameServer.logger().info(sBuilder.toString());
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
/*      */   static void sendUpdateCrossMatchProcessInfo(List<KnockOutRoleInfo> selectionFinalRoleInfoList, int fightType, int process)
/*      */   {
/*  501 */     SUpdateCrossBattleSelectionProcessInfo updateCrossMatchProcessInfo = new SUpdateCrossBattleSelectionProcessInfo();
/*  502 */     updateCrossMatchProcessInfo.fight_type = fightType;
/*  503 */     List<Long> roleids = new ArrayList();
/*  504 */     for (KnockOutRoleInfo selectionFinalRoleInfo : selectionFinalRoleInfoList)
/*      */     {
/*  506 */       long roleid = selectionFinalRoleInfo.getRoleid();
/*  507 */       roleids.add(Long.valueOf(roleid));
/*  508 */       CrossBattleSelectionProcessInfo crossMatchProcessInfo = new CrossBattleSelectionProcessInfo();
/*  509 */       crossMatchProcessInfo.process = process;
/*  510 */       crossMatchProcessInfo.roleid = roleid;
/*  511 */       updateCrossMatchProcessInfo.process_infos.add(crossMatchProcessInfo);
/*      */     }
/*  513 */     OnlineManager.getInstance().sendMultiAtOnce(updateCrossMatchProcessInfo, roleids);
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
/*      */   static Pair<Long, Pair<Integer, Integer>> getWinCorpsId(Map<Integer, FightStageInfo> xFightStageInfoMap, long corpsIdA, long corpsIdB, int nowFightStage, int nowFightIndexId, int fightTimesEveryRound)
/*      */   {
/*  538 */     int nowRound = (nowFightStage - 1) / fightTimesEveryRound + 1;
/*      */     
/*      */ 
/*  541 */     List<FightAgainstInfo> xFightAgainstInfoList = new ArrayList();
/*  542 */     for (int stage = (nowRound - 1) * fightTimesEveryRound + 1; stage <= nowFightStage; stage++)
/*      */     {
/*  544 */       FightStageInfo xFightStageInfo = (FightStageInfo)xFightStageInfoMap.get(Integer.valueOf(stage));
/*  545 */       if (xFightStageInfo != null)
/*      */       {
/*  547 */         FightAgainstInfo xFightAgainstInfo = (FightAgainstInfo)xFightStageInfo.getFight_against_info_map().get(Integer.valueOf(nowFightIndexId));
/*      */         
/*  549 */         if (xFightAgainstInfo != null)
/*      */         {
/*  551 */           xFightAgainstInfoList.add(xFightAgainstInfo);
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*  556 */     int corpsIdAWinCounter = 0;
/*  557 */     int corpsIdBWinCounter = 0;
/*  558 */     for (FightAgainstInfo xFightAgainstInfo : xFightAgainstInfoList)
/*      */     {
/*  560 */       if ((xFightAgainstInfo.getA_corps_id() == corpsIdA) && (xFightAgainstInfo.getB_corps_id() == corpsIdB) && (xFightAgainstInfo.getCal_fight_result() != 0))
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  566 */         long winCorpsId = getWinCorpsId(xFightAgainstInfo);
/*      */         
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  572 */         if (winCorpsId == corpsIdA)
/*      */         {
/*  574 */           corpsIdAWinCounter++;
/*      */         }
/*  576 */         else if (winCorpsId == corpsIdB)
/*      */         {
/*  578 */           corpsIdBWinCounter++;
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  586 */     int leftFightTimes = fightTimesEveryRound - xFightAgainstInfoList.size();
/*      */     
/*  588 */     if (corpsIdAWinCounter - corpsIdBWinCounter > leftFightTimes)
/*      */     {
/*  590 */       return new Pair(Long.valueOf(corpsIdA), new Pair(Integer.valueOf(corpsIdAWinCounter), Integer.valueOf(corpsIdBWinCounter)));
/*      */     }
/*      */     
/*  593 */     if (corpsIdBWinCounter - corpsIdAWinCounter > leftFightTimes)
/*      */     {
/*  595 */       return new Pair(Long.valueOf(corpsIdB), new Pair(Integer.valueOf(corpsIdBWinCounter), Integer.valueOf(corpsIdAWinCounter)));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*  600 */     return new Pair(Long.valueOf(-1L), new Pair(Integer.valueOf(corpsIdAWinCounter), Integer.valueOf(corpsIdBWinCounter)));
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
/*      */   static long getWinCorpsId(FightAgainstInfo xFightAgainstInfo)
/*      */   {
/*  616 */     long corpsIdA = xFightAgainstInfo.getA_corps_id();
/*  617 */     long corpsIdB = xFightAgainstInfo.getB_corps_id();
/*  618 */     int calFightResult = xFightAgainstInfo.getCal_fight_result();
/*  619 */     if ((corpsIdA == 0L) || (corpsIdB == 0L) || (calFightResult == 0))
/*      */     {
/*  621 */       return -1L;
/*      */     }
/*      */     
/*  624 */     if ((calFightResult == FightResultEnum.A_ABSTAIN_WIN.fightResult) || (calFightResult == FightResultEnum.A_FIGHT_WIN.fightResult) || (calFightResult == FightResultEnum.A_BYE_WIN.fightResult))
/*      */     {
/*      */ 
/*      */ 
/*  628 */       return corpsIdA;
/*      */     }
/*      */     
/*  631 */     if ((calFightResult == FightResultEnum.A_ABSTAIN_LOSE.fightResult) || (calFightResult == FightResultEnum.A_FIGHT_LOSE.fightResult) || (calFightResult == FightResultEnum.B_BYE_WIN.fightResult))
/*      */     {
/*      */ 
/*      */ 
/*  635 */       return corpsIdB;
/*      */     }
/*      */     
/*  638 */     return -1L;
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
/*      */   static int getMaxFightIndexId(int teamSumNum, int stage, int fightTimesEveryRound)
/*      */   {
/*  654 */     int finalFightCount = 0;
/*  655 */     for (int index = 1; finalFightCount < fightTimesEveryRound * 2; index++)
/*      */     {
/*  657 */       if (index == stage)
/*      */       {
/*  659 */         return teamSumNum / 2;
/*      */       }
/*      */       
/*  662 */       if ((index % fightTimesEveryRound == 0) && (teamSumNum > 2))
/*      */       {
/*  664 */         teamSumNum /= 2;
/*      */       }
/*  666 */       else if (teamSumNum <= 2)
/*      */       {
/*  668 */         finalFightCount++;
/*      */       }
/*      */     }
/*      */     
/*  672 */     return -1;
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
/*      */   static boolean isCrossBattleHistorySwitchOpen(long roleId)
/*      */   {
/*  687 */     if (!OpenInterface.getOpenStatus(432))
/*      */     {
/*  689 */       return false;
/*      */     }
/*      */     
/*  692 */     if (OpenInterface.isBanPlay(roleId, 432))
/*      */     {
/*  694 */       OpenInterface.sendBanPlayMsg(roleId, 432);
/*  695 */       return false;
/*      */     }
/*      */     
/*  698 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   static void tlogAwardFinalServerRank(String userId, long roleId, long rank, int activityCfgId)
/*      */   {
/*  706 */     int roleLevel = RoleInterface.getLevel(roleId);
/*      */     
/*  708 */     StringBuilder sbLog = new StringBuilder();
/*  709 */     sbLog.append(GameServerInfoManager.getHostIP()).append('|');
/*  710 */     sbLog.append(userId).append('|');
/*  711 */     sbLog.append(roleId).append('|');
/*  712 */     sbLog.append(roleLevel).append('|');
/*      */     
/*  714 */     sbLog.append(rank).append('|');
/*  715 */     sbLog.append(activityCfgId);
/*  716 */     TLogManager.getInstance().addLog(roleId, "KnockOutFinalServerAwardStatis", sbLog.toString());
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
/*      */   static boolean isCrossBattleServerBuffSwitchOpen(long roleId)
/*      */   {
/*  729 */     if (!OpenInterface.getOpenStatus(567))
/*      */     {
/*  731 */       return false;
/*      */     }
/*      */     
/*  734 */     if (OpenInterface.isBanPlay(roleId, 567))
/*      */     {
/*  736 */       OpenInterface.sendBanPlayMsg(roleId, 567);
/*  737 */       return false;
/*      */     }
/*      */     
/*  740 */     return true;
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
/*      */   static boolean isCrossBattleServerMailAwardSwitchOpen(long roleId)
/*      */   {
/*  753 */     if (!OpenInterface.getOpenStatus(568))
/*      */     {
/*  755 */       return false;
/*      */     }
/*      */     
/*  758 */     if (OpenInterface.isBanPlay(roleId, 568))
/*      */     {
/*  760 */       OpenInterface.sendBanPlayMsg(roleId, 568);
/*  761 */       return false;
/*      */     }
/*  763 */     return true;
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
/*      */   static boolean isCrossBattleKnockOutSwitchOpen(long roleId, int activityCfgId, int knockOutType)
/*      */   {
/*  778 */     SCrossBattleKnockOutCfg sCrossBattleKnockOutCfg = SCrossBattleKnockOutCfg.get(activityCfgId);
/*  779 */     if (sCrossBattleKnockOutCfg == null)
/*      */     {
/*  781 */       return false;
/*      */     }
/*      */     
/*  784 */     KnockOutCfg knockOutCfg = (KnockOutCfg)sCrossBattleKnockOutCfg.knockOutTypeCfgMap.get(Integer.valueOf(knockOutType));
/*  785 */     if (knockOutCfg == null)
/*      */     {
/*  787 */       return false;
/*      */     }
/*      */     
/*  790 */     if (!OpenInterface.getOpenStatus(knockOutCfg.module_id))
/*      */     {
/*  792 */       return false;
/*      */     }
/*      */     
/*  795 */     if (OpenInterface.isBanPlay(roleId, knockOutCfg.module_id))
/*      */     {
/*  797 */       OpenInterface.sendBanPlayMsg(roleId, knockOutCfg.module_id);
/*  798 */       return false;
/*      */     }
/*      */     
/*  801 */     return true;
/*      */   }
/*      */   
/*      */   static boolean isCrossBattleKnockOutSwitchOpen(int activityCfgId, int knockOutType)
/*      */   {
/*  806 */     SCrossBattleKnockOutCfg sCrossBattleKnockOutCfg = SCrossBattleKnockOutCfg.get(activityCfgId);
/*  807 */     if (sCrossBattleKnockOutCfg == null)
/*      */     {
/*  809 */       return false;
/*      */     }
/*      */     
/*  812 */     KnockOutCfg knockOutCfg = (KnockOutCfg)sCrossBattleKnockOutCfg.knockOutTypeCfgMap.get(Integer.valueOf(knockOutType));
/*  813 */     if (knockOutCfg == null)
/*      */     {
/*  815 */       return false;
/*      */     }
/*      */     
/*  818 */     if (!OpenInterface.getOpenStatus(knockOutCfg.module_id))
/*      */     {
/*  820 */       return false;
/*      */     }
/*      */     
/*  823 */     return true;
/*      */   }
/*      */   
/*      */   static KnockOutHandler getKnockOutHandler(int knockOutType)
/*      */   {
/*  828 */     KnockOutHandler knockOutFightEndHandler = (KnockOutHandler)knockOutFightEndHandlerMap.get(Integer.valueOf(knockOutType));
/*  829 */     if (knockOutFightEndHandler == null)
/*      */     {
/*  831 */       return null;
/*      */     }
/*      */     
/*  834 */     return knockOutFightEndHandler;
/*      */   }
/*      */   
/*      */ 
/*      */   static int restartKnockOut(int activityCfgId, int knockOutType, int restartFightZoneId, int restartFightIndexId, long restartPrepareWorldBeginTime)
/*      */   {
/*  840 */     SCrossBattleKnockOutCfg sCrossBattleKnockOutCfg = SCrossBattleKnockOutCfg.get(activityCfgId);
/*  841 */     if (sCrossBattleKnockOutCfg == null)
/*      */     {
/*  843 */       return 64006;
/*      */     }
/*      */     
/*  846 */     if (activityCfgId != CrossBattleConsts.getInstance().CURRENT_ACTIVITY_CFG_ID)
/*      */     {
/*  848 */       return 64005;
/*      */     }
/*      */     
/*  851 */     KnockOutCfg knockOutCfg = (KnockOutCfg)sCrossBattleKnockOutCfg.knockOutTypeCfgMap.get(Integer.valueOf(knockOutType));
/*  852 */     if (knockOutCfg == null)
/*      */     {
/*  854 */       return 64004;
/*      */     }
/*      */     
/*  857 */     int maxFightZoneId = getMaxFightZone(activityCfgId, knockOutType);
/*  858 */     if (((restartFightZoneId < 0) || (restartFightZoneId > maxFightZoneId)) && (restartFightZoneId != -1))
/*      */     {
/*  860 */       return 64003;
/*      */     }
/*      */     
/*  863 */     Pair<Integer, Boolean> nowStagePair = CrossBattleKnockoutInterface.getNowFightStage(knockOutType);
/*  864 */     if (nowStagePair == null)
/*      */     {
/*  866 */       return 64002;
/*      */     }
/*      */     
/*  869 */     int fightStage = ((Integer)nowStagePair.first).intValue();
/*  870 */     if (fightStage < 1)
/*      */     {
/*  872 */       return 64001;
/*      */     }
/*  874 */     int maxFightIndexId = getMaxFightIndexId(knockOutCfg.need_team_size, fightStage, knockOutCfg.fight_times_every_stage);
/*      */     
/*  876 */     if (maxFightIndexId < 0)
/*      */     {
/*  878 */       return 64000;
/*      */     }
/*      */     
/*  881 */     if (((restartFightIndexId < 1) || (restartFightIndexId > maxFightIndexId)) && (restartFightZoneId != -1))
/*      */     {
/*  883 */       return 63999;
/*      */     }
/*      */     
/*  886 */     long currentTimeMillis = DateTimeUtils.getCurrTimeInMillis();
/*  887 */     if (currentTimeMillis >= restartPrepareWorldBeginTime)
/*      */     {
/*  889 */       return 63998;
/*      */     }
/*      */     
/*  892 */     long nextStageBeginTime = getNextStageBeginTime(knockOutCfg, knockOutType, fightStage);
/*  893 */     if (nextStageBeginTime < 0L)
/*      */     {
/*  895 */       return 63997;
/*      */     }
/*      */     
/*  898 */     long restartFightEndTime = restartPrepareWorldBeginTime + (knockOutCfg.fight_last_time + 10) * 60000L;
/*      */     
/*  900 */     if (restartFightEndTime >= nextStageBeginTime)
/*      */     {
/*  902 */       return 63996;
/*      */     }
/*      */     
/*  905 */     Long prepareWorldId = CrossBattleKnockOutPrepareWorldManager.getInstance().getPrepareWorldId();
/*  906 */     if (prepareWorldId != null)
/*      */     {
/*  908 */       return 63995;
/*      */     }
/*      */     
/*  911 */     int ret = updateResartKnockOutObserver(restartPrepareWorldBeginTime, activityCfgId, knockOutType, fightStage, restartFightZoneId == -1, restartFightZoneId, restartFightIndexId);
/*      */     
/*      */ 
/*  914 */     if (ret < 0)
/*      */     {
/*  916 */       return ret;
/*      */     }
/*      */     
/*  919 */     boolean isSendSuccess = GrcInterface.clearKnockOutData(activityCfgId, knockOutType, restartFightZoneId, fightStage, restartFightIndexId, maxFightZoneId, maxFightIndexId, restartPrepareWorldBeginTime, 0);
/*      */     
/*  921 */     if (!isSendSuccess)
/*      */     {
/*  923 */       return 63994;
/*      */     }
/*      */     
/*  926 */     StringBuilder sBuilder = new StringBuilder();
/*  927 */     sBuilder.append("[crossbattle_knockout]CrossBattleKnockOutManager.restartKnockOut");
/*  928 */     sBuilder.append("|activity_cfg_id=").append(activityCfgId);
/*  929 */     sBuilder.append("|knock_out_type=").append(knockOutType);
/*  930 */     sBuilder.append("|restart_fight_zone_id=").append(restartFightZoneId);
/*  931 */     sBuilder.append("|restart_fight_index_id=").append(restartFightIndexId);
/*  932 */     sBuilder.append("|restart_prepare_world_begin_time=").append(restartPrepareWorldBeginTime);
/*  933 */     sBuilder.append("|is_send_success=").append(isSendSuccess);
/*      */     
/*  935 */     GameServer.logger().info(sBuilder.toString());
/*  936 */     return 0;
/*      */   }
/*      */   
/*      */ 
/*      */   static void triggerGetFinalChampionMapStatue(boolean isSuccess, boolean nowIsHasStatue, int session, FightStageEndCorpsInfo fightStageEndCorpsInfo)
/*      */   {
/*  942 */     GetFinalChampionMapStatueArg getFinalChampionMapStatueArg = new GetFinalChampionMapStatueArg(isSuccess, nowIsHasStatue, session, new FightStageEndCorpsInfo());
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  947 */     TriggerEventsManger.getInstance().triggerEvent(new GetFinalChampionMapStatue(), getFinalChampionMapStatueArg);
/*      */   }
/*      */   
/*      */ 
/*      */   static int updateResartKnockOutObserver(long worldBeginTime, int activityCfgId, int knockOutType, int fightStage, boolean isRestartAllFightZone, int fightZoneId, int fightIndexId)
/*      */   {
/*  953 */     locker.writeLock().lock();
/*      */     try {
/*      */       long currentTimeMillis;
/*  956 */       if (restartKnockOutObserver == null)
/*      */       {
/*  958 */         currentTimeMillis = DateTimeUtils.getCurrTimeInMillis();
/*  959 */         restartKnockOutObserver = new RestartKnockOutObserver(worldBeginTime - currentTimeMillis, activityCfgId, knockOutType, fightStage, worldBeginTime);
/*      */ 
/*      */       }
/*  962 */       else if (worldBeginTime != restartKnockOutObserver.getRestartPrepareWorldBeginTime())
/*      */       {
/*  964 */         return 63993;
/*      */       }
/*      */       
/*  967 */       if (restartKnockOutObserver.isAllFightZoneRestart)
/*      */       {
/*  969 */         return 63992;
/*      */       }
/*      */       
/*  972 */       if (isRestartAllFightZone)
/*      */       {
/*  974 */         if (isRestartAllFightZone == restartKnockOutObserver.isAllFightZoneRestart)
/*      */         {
/*  976 */           return 63992;
/*      */         }
/*  978 */         restartKnockOutObserver.isAllFightZoneRestart = isRestartAllFightZone;
/*  979 */         return 1;
/*      */       }
/*      */       
/*  982 */       for (Pair<Integer, Integer> pair : restartKnockOutObserver.restartFightList)
/*      */       {
/*  984 */         if ((((Integer)pair.first).intValue() == fightZoneId) && (((Integer)pair.second).intValue() == fightIndexId))
/*      */         {
/*  986 */           return 63991;
/*      */         }
/*      */       }
/*      */       
/*  990 */       restartKnockOutObserver.restartFightList.add(new Pair(Integer.valueOf(fightZoneId), Integer.valueOf(fightIndexId)));
/*      */       
/*  992 */       return 1;
/*      */     }
/*      */     finally
/*      */     {
/*  996 */       locker.writeLock().unlock();
/*      */     }
/*      */   }
/*      */   
/*      */   static void clearRestartObserver()
/*      */   {
/* 1002 */     locker.writeLock().lock();
/*      */     try
/*      */     {
/* 1005 */       restartKnockOutObserver = null;
/*      */     }
/*      */     finally
/*      */     {
/* 1009 */       locker.writeLock().unlock();
/*      */     }
/*      */   }
/*      */   
/*      */   static int refreshKnockOutData(int activityCfgId, int knockOutType, int fightZoneId)
/*      */   {
/* 1015 */     SCrossBattleKnockOutCfg sCrossBattleKnockOutCfg = SCrossBattleKnockOutCfg.get(activityCfgId);
/* 1016 */     if (sCrossBattleKnockOutCfg == null)
/*      */     {
/* 1018 */       return 63986;
/*      */     }
/*      */     
/* 1021 */     KnockOutCfg knockOutCfg = (KnockOutCfg)sCrossBattleKnockOutCfg.knockOutTypeCfgMap.get(Integer.valueOf(knockOutType));
/* 1022 */     if (knockOutCfg == null)
/*      */     {
/* 1024 */       return 63985;
/*      */     }
/*      */     
/* 1027 */     int maxFightZoneId = CrossBattlePointInterface.getZoneNum();
/* 1028 */     if ((fightZoneId > maxFightZoneId) || ((fightZoneId < 0) && (fightZoneId != -1)))
/*      */     {
/* 1030 */       return 63984;
/*      */     }
/*      */     
/* 1033 */     GetKnockOutContext_Refresh refreshKnockOutContext = new GetKnockOutContext_Refresh();
/* 1034 */     OctetsStream octetsStream = new OctetsStream();
/* 1035 */     octetsStream.marshal(refreshKnockOutContext);
/*      */     
/* 1037 */     GetKnockOutContext getKnockOutContext = new GetKnockOutContext();
/* 1038 */     getKnockOutContext.oper_type = -1;
/* 1039 */     getKnockOutContext.content = octetsStream;
/*      */     
/* 1041 */     Pair<Integer, Boolean> nowFightStagePair = CrossBattleKnockoutInterface.getNowFightStage(knockOutType);
/* 1042 */     if (nowFightStagePair == null)
/*      */     {
/* 1044 */       return 63983;
/*      */     }
/*      */     
/* 1047 */     boolean isSendSuccess = GrcInterface.getCrossBattleKnockOutInfo(activityCfgId, knockOutType, fightZoneId, ((Integer)nowFightStagePair.first).intValue(), knockOutCfg.need_team_size, knockOutCfg.stage_time_point_cfg_id_list.size(), knockOutCfg.fight_times_every_stage, new OctetsStream().marshal(getKnockOutContext));
/*      */     
/*      */ 
/*      */ 
/* 1051 */     if (!isSendSuccess)
/*      */     {
/* 1053 */       return 63982;
/*      */     }
/*      */     
/* 1056 */     return 0;
/*      */   }
/*      */   
/*      */   static long getNextStageBeginTime(KnockOutCfg knockOutCfg, int knockOutType, int nowStage)
/*      */   {
/* 1061 */     KnockOutHandler knockOutHandler = getKnockOutHandler(knockOutType);
/* 1062 */     if (knockOutHandler == null)
/*      */     {
/* 1064 */       return -1L;
/*      */     }
/*      */     
/* 1067 */     if (nowStage == knockOutCfg.stage_time_point_cfg_id_list.size())
/*      */     {
/* 1069 */       return knockOutHandler.getNextKnockOutGameStartTime(CrossBattleConsts.getInstance().CURRENT_ACTIVITY_CFG_ID);
/*      */     }
/*      */     
/* 1072 */     if (nowStage > knockOutCfg.stage_time_point_cfg_id_list.size())
/*      */     {
/* 1074 */       return -1L;
/*      */     }
/*      */     
/* 1077 */     STimePointCommonCfg sTimePointCommonCfg = STimePointCommonCfg.get(((Integer)knockOutCfg.stage_time_point_cfg_id_list.get(nowStage)).intValue());
/* 1078 */     if (sTimePointCommonCfg == null)
/*      */     {
/* 1080 */       return -1L;
/*      */     }
/*      */     
/* 1083 */     return TimeCommonUtil.getTimePoint(sTimePointCommonCfg) - knockOutCfg.prepare_world_countdown * 60000L;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   static void addRoleKnockOutRestart(long roleId, long prepareWorldBeginTime, int knockOutType)
/*      */   {
/* 1090 */     locker.writeLock().lock();
/*      */     try
/*      */     {
/* 1093 */       roleIdKnockOutRestartMap.put(Long.valueOf(roleId), new Pair(Long.valueOf(prepareWorldBeginTime), Integer.valueOf(knockOutType)));
/*      */     }
/*      */     finally
/*      */     {
/* 1097 */       locker.writeLock().unlock();
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
/*      */   static Pair<Long, Integer> getRoleKnockOutRestartInfo(long roleId)
/*      */   {
/* 1111 */     locker.readLock().lock();
/*      */     try
/*      */     {
/* 1114 */       return (Pair)roleIdKnockOutRestartMap.get(Long.valueOf(roleId));
/*      */     }
/*      */     finally
/*      */     {
/* 1118 */       locker.readLock().unlock();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   static void clearRoleKnockOutRestartInfo()
/*      */   {
/* 1127 */     locker.writeLock().lock();
/*      */     try
/*      */     {
/* 1130 */       roleIdKnockOutRestartMap.clear();
/*      */     }
/*      */     finally
/*      */     {
/* 1134 */       locker.writeLock().unlock();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void initCorpsRoleInfoReportObserver(int activityCfgId)
/*      */   {
/* 1146 */     Map<Long, List<Long>> corps2RoleIdListMap = CrossBattleOwnInterface.getCrossBattleOwnPromotionCorpsRoleList(activityCfgId, false);
/*      */     
/*      */ 
/* 1149 */     new CorpsInfoReportObserver(7200L + Xdb.random().nextInt(200), activityCfgId, corps2RoleIdListMap);
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
/*      */   public static void broadcastFinalBulletin(int physicsZoneId, SBulletinInfo sBulletinInfo)
/*      */   {
/* 1163 */     NotifyCrossBattleFinalBulletion notifyCrossBattleFinalBulletion = new NotifyCrossBattleFinalBulletion();
/* 1164 */     notifyCrossBattleFinalBulletion.zone_id = physicsZoneId;
/* 1165 */     notifyCrossBattleFinalBulletion.bulletin_content = sBulletinInfo.marshal(new OctetsStream());
/*      */     
/* 1167 */     DataBroadcast dataBroadcast = new DataBroadcast();
/* 1168 */     dataBroadcast.direction = 0;
/* 1169 */     dataBroadcast.src_id = GameServerInfoManager.getZoneId();
/* 1170 */     dataBroadcast.data_type = 4;
/* 1171 */     dataBroadcast.data = notifyCrossBattleFinalBulletion.marshal(new OctetsStream());
/* 1172 */     GHubHelper.broadcast(dataBroadcast);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void checkCanJoinNowStageKnockOut(long roleId, long corpsId)
/*      */   {
/* 1184 */     long currentTimeMillis = DateTimeUtils.getCurrTimeInMillis();
/* 1185 */     int currentActivityCfgId = CrossBattleConsts.getInstance().CURRENT_ACTIVITY_CFG_ID;
/*      */     
/*      */ 
/* 1188 */     long lastFinalStageFightBeginTime = CrossBattleKnockoutInterface.getCrossBattleKnockOutLastStageEnterTime(currentActivityCfgId, 2);
/*      */     
/* 1190 */     if (currentTimeMillis > lastFinalStageFightBeginTime)
/*      */     {
/* 1192 */       return;
/*      */     }
/*      */     
/*      */ 
/* 1196 */     long canGetKnockOutSelectionTime = CrossBattleKnockoutInterface.getKnockOutCanGetInfoTime(currentActivityCfgId, 1);
/*      */     
/* 1198 */     if (canGetKnockOutSelectionTime > currentTimeMillis)
/*      */     {
/* 1200 */       return;
/*      */     }
/*      */     
/* 1203 */     int knockOutType = 1;
/*      */     
/* 1205 */     long lastSelectionStageFightBeginTime = CrossBattleKnockoutInterface.getCrossBattleKnockOutLastStageEnterTime(currentActivityCfgId, 1);
/*      */     
/*      */ 
/* 1208 */     if (currentTimeMillis > lastSelectionStageFightBeginTime)
/*      */     {
/* 1210 */       knockOutType = 2;
/*      */     }
/*      */     
/* 1213 */     SCrossBattleKnockOutCfg sCrossBattleKnockOutCfg = SCrossBattleKnockOutCfg.get(currentActivityCfgId);
/* 1214 */     if (sCrossBattleKnockOutCfg == null)
/*      */     {
/* 1216 */       return;
/*      */     }
/*      */     
/* 1219 */     KnockOutCfg selectionKnockOutCfg = (KnockOutCfg)sCrossBattleKnockOutCfg.knockOutTypeCfgMap.get(Integer.valueOf(1));
/* 1220 */     if (selectionKnockOutCfg == null)
/*      */     {
/* 1222 */       return;
/*      */     }
/*      */     
/* 1225 */     KnockOutCfg knockOutCfg = (KnockOutCfg)sCrossBattleKnockOutCfg.knockOutTypeCfgMap.get(Integer.valueOf(knockOutType));
/* 1226 */     if (knockOutCfg == null)
/*      */     {
/* 1228 */       return;
/*      */     }
/*      */     
/*      */ 
/* 1232 */     if (!isCrossBattleKnockOutSwitchOpen(currentActivityCfgId, knockOutType))
/*      */     {
/* 1234 */       return;
/*      */     }
/*      */     
/* 1237 */     locker.readLock().lock();
/*      */     try
/*      */     {
/* 1240 */       if (ownServerNowKnockOutCorpsIdSet != null)
/*      */       {
/* 1242 */         if (ownServerNowKnockOutCorpsIdSet.contains(Long.valueOf(corpsId)))
/*      */         {
/* 1244 */           SNotifyKnockOutCorpsQualification notifyKnockOutCorpsQualication = new SNotifyKnockOutCorpsQualification(knockOutType, 1);
/*      */           
/*      */ 
/*      */ 
/* 1248 */           OnlineManager.getInstance().send(roleId, notifyKnockOutCorpsQualication);
/*      */         }
/*      */         
/*      */       }
/*      */       else
/*      */       {
/* 1254 */         Pair<Integer, Boolean> nowFightStagePair = CrossBattleKnockoutInterface.getNowFightStage(knockOutType);
/* 1255 */         if (nowFightStagePair == null) {
/*      */           return;
/*      */         }
/*      */         
/* 1259 */         int nowFightStage = ((Integer)nowFightStagePair.first).intValue();
/* 1260 */         int maxFightIndexId = getMaxFightIndexId(knockOutCfg.need_team_size, nowFightStage + 1, knockOutCfg.fight_times_every_stage);
/*      */         
/* 1262 */         if (maxFightIndexId < 0) {
/*      */           return;
/*      */         }
/*      */         
/*      */ 
/* 1267 */         int maxFightZone = getMaxFightZone(currentActivityCfgId, knockOutType);
/* 1268 */         if (maxFightZone < 0) {
/*      */           return;
/*      */         }
/*      */         
/*      */ 
/* 1273 */         int maxSelectinStage = selectionKnockOutCfg.stage_time_point_cfg_id_list.size();
/*      */         
/* 1275 */         boolean isSendSuccess = GrcInterface.getKnockOutQualificationCorpsIdList(currentActivityCfgId, knockOutType, nowFightStage + 1, maxFightIndexId, maxFightZone, selectionKnockOutCfg.need_team_size, maxSelectinStage, GameServerInfoManager.getZoneIds(), roleId, corpsId);
/*      */         
/*      */ 
/*      */ 
/* 1279 */         StringBuilder sBuilder = new StringBuilder();
/* 1280 */         sBuilder.append("[crossbattle_knockout]CrossBattleKnockOutManager.checkCanJoinNowStageKnockOut@req get knockout qualification");
/* 1281 */         sBuilder.append("|role_id=").append(roleId);
/* 1282 */         sBuilder.append("|corps_id=").append(corpsId);
/* 1283 */         sBuilder.append("|current_activity_cfg_id=").append(currentActivityCfgId);
/* 1284 */         sBuilder.append("|knock_out_type=").append(knockOutType);
/* 1285 */         sBuilder.append("|now_fight_stage=").append(nowFightStage);
/* 1286 */         sBuilder.append("|is_send_success=").append(isSendSuccess);
/*      */         
/* 1288 */         GameServer.logger().info(sBuilder.toString());
/*      */       }
/*      */     }
/*      */     finally
/*      */     {
/* 1293 */       locker.readLock().unlock();
/*      */     }
/*      */   }
/*      */   
/*      */   static void updateCanJoinNowStageKnockOutCorpsIdSet(Set<Long> corpsIdSet)
/*      */   {
/* 1299 */     locker.writeLock().lock();
/*      */     try
/*      */     {
/* 1302 */       if (ownServerNowKnockOutCorpsIdSet == null)
/*      */       {
/* 1304 */         ownServerNowKnockOutCorpsIdSet = new java.util.HashSet(corpsIdSet);
/*      */       }
/*      */       else
/*      */       {
/* 1308 */         ownServerNowKnockOutCorpsIdSet.clear();
/* 1309 */         ownServerNowKnockOutCorpsIdSet.addAll(corpsIdSet);
/*      */       }
/*      */     }
/*      */     finally
/*      */     {
/* 1314 */       locker.writeLock().unlock();
/*      */     }
/*      */   }
/*      */   
/*      */   static void clearCanJoinNowStageKnockOutCorpsIdSet()
/*      */   {
/* 1320 */     locker.writeLock().lock();
/*      */     try
/*      */     {
/* 1323 */       ownServerNowKnockOutCorpsIdSet = null;
/*      */     }
/*      */     finally
/*      */     {
/* 1327 */       locker.writeLock().unlock();
/*      */     }
/*      */   }
/*      */   
/*      */   static void removeCanJoinNowStageKnockOutCorpsIdSet(long corpsId)
/*      */   {
/* 1333 */     locker.writeLock().lock();
/*      */     try
/*      */     {
/* 1336 */       if ((ownServerNowKnockOutCorpsIdSet == null) || (!ownServerNowKnockOutCorpsIdSet.remove(Long.valueOf(corpsId))))
/*      */       {
/* 1338 */         StringBuilder sBuilder = new StringBuilder();
/* 1339 */         sBuilder.append("[crossbattle]CrossBattleKnockOutManager.removeCanJoinNowStageKnockOutCorpsIdSet@remove fail");
/* 1340 */         sBuilder.append("|corpsId=").append(corpsId);
/* 1341 */         sBuilder.append("|corps_id_set=").append(ownServerNowKnockOutCorpsIdSet);
/*      */         
/* 1343 */         GameServer.logger().info(sBuilder.toString());
/*      */       }
/*      */       else
/*      */       {
/* 1347 */         StringBuilder sBuilder = new StringBuilder();
/* 1348 */         sBuilder.append("[crossbattle]CrossBattleKnockOutManager.removeCanJoinNowStageKnockOutCorpsIdSet@remove success");
/* 1349 */         sBuilder.append("|corpsId=").append(corpsId);
/* 1350 */         sBuilder.append("|corps_id_set=").append(ownServerNowKnockOutCorpsIdSet);
/* 1351 */         GameServer.logger().info(sBuilder.toString());
/*      */       }
/*      */     }
/*      */     finally {
/* 1355 */       locker.writeLock().unlock();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean isWinByFightResult(int fightResult)
/*      */   {
/* 1367 */     if ((fightResult == SignalFightResultEnum.ABSTAIN_WIN.fightResult) || (fightResult == SignalFightResultEnum.BYE_WIN.fightResult) || (fightResult == SignalFightResultEnum.FIGHT_WIN.fightResult))
/*      */     {
/*      */ 
/*      */ 
/* 1371 */       return true;
/*      */     }
/*      */     
/* 1374 */     return false;
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
/*      */   static boolean isByeWin(FightAgainstInfo xFightAgainstInfo)
/*      */   {
/* 1387 */     if ((xFightAgainstInfo.getCal_fight_result() == FightResultEnum.A_BYE_WIN.fightResult) || (xFightAgainstInfo.getCal_fight_result() == FightResultEnum.B_BYE_WIN.fightResult))
/*      */     {
/*      */ 
/* 1390 */       return true;
/*      */     }
/*      */     
/* 1393 */     return false;
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
/*      */   static boolean isAllBye(FightAgainstInfo xFightAgainstInfo)
/*      */   {
/* 1406 */     if (xFightAgainstInfo.getCal_fight_result() == FightResultEnum.ALL_BYE.fightResult)
/*      */     {
/* 1408 */       return true;
/*      */     }
/*      */     
/* 1411 */     return false;
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\knockout\CrossBattleKnockoutManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
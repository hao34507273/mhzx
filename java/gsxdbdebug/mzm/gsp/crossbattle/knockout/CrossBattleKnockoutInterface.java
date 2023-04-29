/*      */ package mzm.gsp.crossbattle.knockout;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import com.goldhuman.Common.Octets;
/*      */ import hub.ExchangeDataHandlerInfo;
/*      */ import java.io.UnsupportedEncodingException;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Calendar;
/*      */ import java.util.Collection;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Set;
/*      */ import java.util.concurrent.TimeUnit;
/*      */ import mzm.event.TriggerEventsManger;
/*      */ import mzm.gsp.GameServer;
/*      */ import mzm.gsp.GameServerInfoManager;
/*      */ import mzm.gsp.activity.main.ActivityInterface;
/*      */ import mzm.gsp.bulletin.SBulletinInfo;
/*      */ import mzm.gsp.changemodelcard.main.ChangeModelCardInterface;
/*      */ import mzm.gsp.common.TimeCommonUtil;
/*      */ import mzm.gsp.common.confbean.STimePointCommonCfg;
/*      */ import mzm.gsp.corps.CorpsBriefInfo;
/*      */ import mzm.gsp.corps.CorpsDetailInfo;
/*      */ import mzm.gsp.corps.CorpsMemberDetailInfo;
/*      */ import mzm.gsp.corps.SGetCorpsDetailInfoRep;
/*      */ import mzm.gsp.crossbattle.CorpsMemberInfo;
/*      */ import mzm.gsp.crossbattle.GetKnockOutContext;
/*      */ import mzm.gsp.crossbattle.GetKnockOutContext_ReportFightResult;
/*      */ import mzm.gsp.crossbattle.SCrossBattleSelectionNormalRes;
/*      */ import mzm.gsp.crossbattle.SGetCrossBattleFinalHistoryCorpsInfo;
/*      */ import mzm.gsp.crossbattle.confbean.CrossBattleConsts;
/*      */ import mzm.gsp.crossbattle.confbean.FinalMatchBean;
/*      */ import mzm.gsp.crossbattle.confbean.KnockOutCfg;
/*      */ import mzm.gsp.crossbattle.confbean.SCrossBattleFinalBuffCfg;
/*      */ import mzm.gsp.crossbattle.confbean.SCrossBattleFinalCfg;
/*      */ import mzm.gsp.crossbattle.confbean.SCrossBattleFinalMatchCfg;
/*      */ import mzm.gsp.crossbattle.confbean.SCrossBattleKnockOutCfg;
/*      */ import mzm.gsp.crossbattle.confbean.SCrossBattleSelectionCfg;
/*      */ import mzm.gsp.crossbattle.confbean.SCrossBattleSelectionMatchCfg;
/*      */ import mzm.gsp.crossbattle.confbean.SelectionFinalConsts;
/*      */ import mzm.gsp.crossbattle.confbean.SelectionMatchBean;
/*      */ import mzm.gsp.crossbattle.event.GetFightStageCorpsIdList;
/*      */ import mzm.gsp.crossbattle.event.GetFightStageCorpsIdListArg;
/*      */ import mzm.gsp.crossbattle.event.GetFightStageEndCorpsInfo;
/*      */ import mzm.gsp.crossbattle.event.GetFightStageEndCorpsInfoArg;
/*      */ import mzm.gsp.crossbattle.event.GetKnockOutInfoArg;
/*      */ import mzm.gsp.crossbattle.event.KnockOutFinalChampionBorn;
/*      */ import mzm.gsp.crossbattle.event.KnockOutFinalChampionBornArg;
/*      */ import mzm.gsp.crossbattle.main.CrossBattleOneByOneManager;
/*      */ import mzm.gsp.crossbattle.point.CrossBattlePointInterface;
/*      */ import mzm.gsp.crossserver.main.KnockOutFightEndSession;
/*      */ import mzm.gsp.grc.main.GrcInterface;
/*      */ import mzm.gsp.online.main.LoginManager;
/*      */ import mzm.gsp.online.main.OnlineManager;
/*      */ import mzm.gsp.pubdata.ModelInfo;
/*      */ import mzm.gsp.util.DateTimeUtils;
/*      */ import mzm.gsp.util.Pair;
/*      */ import org.apache.log4j.Logger;
/*      */ import org.json.JSONArray;
/*      */ import org.json.JSONObject;
/*      */ import xbean.CrossBattleKnockoutActivityInfo;
/*      */ import xbean.CrossBattleKnockoutInfo;
/*      */ import xbean.FightAgainstInfo;
/*      */ import xbean.FightStageInfo;
/*      */ import xbean.FightZoneInfo;
/*      */ import xdb.Executor;
/*      */ import xdb.Xdb;
/*      */ import xtable.Cross_battle_knockout;
/*      */ 
/*      */ public class CrossBattleKnockoutInterface
/*      */ {
/*      */   public static boolean onSelectionOrFinalEnd(KnockOutEndContext context)
/*      */   {
/*   77 */     int activityCfgId = CrossBattleConsts.getInstance().CURRENT_ACTIVITY_CFG_ID;
/*      */     
/*   79 */     KnockOutEndContextManager.getInstance().putKeys(context.allUserIdList, context);
/*   80 */     mzm.gsp.status.main.RoleStatusInterface.setStatus(context.allRoleIdList, 65, false);
/*      */     
/*      */ 
/*   83 */     new KnockOutFightEndSession(SelectionFinalConsts.getInstance().return_own_server_leave_seconds, 0L, context.allRoleIdList, context.allUserIdList);
/*      */     
/*      */ 
/*   86 */     for (int index = 0; 
/*   87 */         index < context.allRoleIdList.size(); index++)
/*      */     {
/*   89 */       long roleId = ((Long)context.allRoleIdList.get(index)).longValue();
/*   90 */       String userId = (String)context.allUserIdList.get(index);
/*      */       
/*   92 */       LoginManager.getInstance().onRoleCrossEnd(userId, roleId);
/*      */       
/*      */ 
/*   95 */       ChangeModelCardInterface.consumePVPFightCount(roleId, 1);
/*      */       
/*   97 */       ExchangeDataHandlerInfo exchangeDataHandlerInfo = (ExchangeDataHandlerInfo)context.exchangeDataHandlerInfo.get(Long.valueOf(roleId));
/*   98 */       if (exchangeDataHandlerInfo != null)
/*      */       {
/*  100 */         mzm.gsp.crossserver.main.ReturnFromRoamServerHandlerManager.unboxData(userId, roleId, (ExchangeDataHandlerInfo)context.exchangeDataHandlerInfo.get(Long.valueOf(roleId)));
/*      */       }
/*      */     }
/*      */     
/*  104 */     int fightZoneId = CrossBattleKnockoutManager.getFightZone(context.ownCorpsId, activityCfgId, context.fightType);
/*  105 */     if (fightZoneId < 0)
/*      */     {
/*  107 */       return true;
/*      */     }
/*      */     
/*  110 */     SCrossBattleKnockOutCfg sCrossBattleKnockOutCfg = SCrossBattleKnockOutCfg.get(activityCfgId);
/*  111 */     if (sCrossBattleKnockOutCfg == null)
/*      */     {
/*  113 */       return true;
/*      */     }
/*      */     
/*  116 */     KnockOutCfg knockOutCfg = (KnockOutCfg)sCrossBattleKnockOutCfg.knockOutTypeCfgMap.get(Integer.valueOf(context.fightType));
/*  117 */     if (knockOutCfg == null)
/*      */     {
/*  119 */       return true;
/*      */     }
/*      */     
/*  122 */     int fightResult = context.winOrLose == 1 ? SignalFightResultEnum.FIGHT_WIN.fightResult : SignalFightResultEnum.FIGHT_LOSE.fightResult;
/*      */     
/*      */ 
/*  125 */     boolean isReportSuccess = GrcInterface.reportCrossBattleKnockOutFightResult(activityCfgId, context.fightType, fightZoneId, context.fightStage, context.ownCorpsId, context.ownCorpsName, context.opponentCorpsId, context.opponentCorpsName, context.fightIndexId, knockOutCfg.stage_name_list.size(), knockOutCfg.fight_times_every_stage, String.valueOf(fightResult));
/*      */     
/*      */ 
/*      */ 
/*  129 */     if (!isReportSuccess)
/*      */     {
/*  131 */       Xdb.executor().schedule(new RRepeatReportCrossBattleKnockOutFightResult(activityCfgId, context.fightType, fightZoneId, context.fightStage, context.ownCorpsId, context.ownCorpsName, context.opponentCorpsId, context.opponentCorpsName, context.fightIndexId, knockOutCfg.stage_name_list.size(), knockOutCfg.fight_times_every_stage, String.valueOf(fightResult), 1), 60000L, TimeUnit.MILLISECONDS);
/*      */       
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  141 */       StringBuilder logBuilder = new StringBuilder();
/*  142 */       logBuilder.append("[crossbattle]CrossBattleKnockoutInterface.onSelectionOrFinalEnd@report fight result fail");
/*  143 */       logBuilder.append("|is_report_success=").append(isReportSuccess);
/*  144 */       logBuilder.append("|knock_out_end_context=").append(context.toString());
/*      */       
/*  146 */       GameServer.logger().info(logBuilder.toString());
/*      */     }
/*      */     else
/*      */     {
/*  150 */       StringBuilder logBuilder = new StringBuilder();
/*  151 */       logBuilder.append("[crossbattle]CrossBattleKnockoutInterface.onSelectionOrFinalEnd@report fight result success");
/*  152 */       logBuilder.append("|is_report_success=").append(isReportSuccess);
/*  153 */       logBuilder.append("|knock_out_end_context=").append(context.toString());
/*      */       
/*  155 */       GameServer.logger().info(logBuilder.toString());
/*      */     }
/*      */     
/*  158 */     KnockOutTLogManager.tlogKnockOutFightResult(activityCfgId, context.fightType, fightZoneId, context.fightStage, context.fightIndexId, context.ownCorpsId, context.ownCorpsName, context.opponentCorpsId, context.opponentCorpsName, fightResult);
/*      */     
/*      */ 
/*  161 */     return true;
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
/*      */   public static List<Pair<Integer, Integer>> getSelectinInitFightRelationList(int activityCfgId)
/*      */   {
/*  174 */     List<Pair<Integer, Integer>> selectionInitFightRelationList = new ArrayList();
/*  175 */     SCrossBattleSelectionCfg sCrossBattleSelectionCfg = SCrossBattleSelectionCfg.get(activityCfgId);
/*  176 */     if (sCrossBattleSelectionCfg == null)
/*      */     {
/*  178 */       return selectionInitFightRelationList;
/*      */     }
/*      */     
/*  181 */     SCrossBattleSelectionMatchCfg sCrossBattleSelectionMatchCfg = SCrossBattleSelectionMatchCfg.get(sCrossBattleSelectionCfg.selection_match_cfg_id);
/*  182 */     if (sCrossBattleSelectionMatchCfg == null)
/*      */     {
/*  184 */       return selectionInitFightRelationList;
/*      */     }
/*  186 */     for (SelectionMatchBean selectionMatchBean : sCrossBattleSelectionMatchCfg.selection_match_list)
/*      */     {
/*  188 */       Pair<Integer, Integer> pair = new Pair(Integer.valueOf(selectionMatchBean.corps_a_rank), Integer.valueOf(selectionMatchBean.corps_b_rank));
/*      */       
/*  190 */       selectionInitFightRelationList.add(pair);
/*      */     }
/*      */     
/*  193 */     return selectionInitFightRelationList;
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
/*      */   public static boolean isNeedForceInit(int activityCfgId, int knockOutType)
/*      */   {
/*  207 */     KnockOutHandler knockOutHandler = CrossBattleKnockoutManager.getKnockOutHandler(knockOutType);
/*      */     
/*  209 */     long currentTimeMillis = DateTimeUtils.getCurrTimeInMillis();
/*      */     
/*  211 */     long knockOutBeginTime = knockOutHandler.getKnockOutBeginTime(activityCfgId);
/*      */     
/*  213 */     return knockOutBeginTime <= currentTimeMillis;
/*      */   }
/*      */   
/*      */ 
/*      */   public static List<Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>> getFinalInitFightRelationList(int activityCfgId)
/*      */   {
/*  219 */     List<Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>> finalInitFightRelationList = new ArrayList();
/*  220 */     SCrossBattleFinalCfg sCrossBattleFinalCfg = SCrossBattleFinalCfg.get(activityCfgId);
/*  221 */     if (sCrossBattleFinalCfg == null)
/*      */     {
/*  223 */       return null;
/*      */     }
/*      */     
/*  226 */     SCrossBattleFinalMatchCfg sCrossBattleFinalMatchCfg = SCrossBattleFinalMatchCfg.get(sCrossBattleFinalCfg.final_match_cfg_id);
/*  227 */     if (sCrossBattleFinalMatchCfg == null)
/*      */     {
/*  229 */       return null;
/*      */     }
/*      */     
/*  232 */     for (FinalMatchBean finalMatchBean : sCrossBattleFinalMatchCfg.final_match_list)
/*      */     {
/*  234 */       Pair<Integer, Integer> corpsIdAPair = new Pair(Integer.valueOf(finalMatchBean.corps_a_fight_zone), Integer.valueOf(finalMatchBean.corps_a_zone_rank));
/*      */       
/*      */ 
/*  237 */       Pair<Integer, Integer> corpsIdBPair = new Pair(Integer.valueOf(finalMatchBean.corps_b_fight_zone), Integer.valueOf(finalMatchBean.corps_b_zone_rank));
/*      */       
/*      */ 
/*  240 */       Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> pair = new Pair(corpsIdAPair, corpsIdBPair);
/*      */       
/*      */ 
/*      */ 
/*  244 */       finalInitFightRelationList.add(pair);
/*      */     }
/*      */     
/*  247 */     return finalInitFightRelationList;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static Pair<Integer, Boolean> getNowFightStage(int knockOutType)
/*      */   {
/*  258 */     int currentActivityCfgId = CrossBattleConsts.getInstance().CURRENT_ACTIVITY_CFG_ID;
/*  259 */     return getNowFightStage(currentActivityCfgId, knockOutType);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static Pair<Integer, Boolean> getNowFightStage(int activityCfgId, int knockOutType)
/*      */   {
/*  270 */     SCrossBattleKnockOutCfg sCrossBattleKnockOutCfg = SCrossBattleKnockOutCfg.get(activityCfgId);
/*  271 */     if (sCrossBattleKnockOutCfg == null)
/*      */     {
/*  273 */       return null;
/*      */     }
/*      */     
/*  276 */     KnockOutCfg knockOutCfg = (KnockOutCfg)sCrossBattleKnockOutCfg.knockOutTypeCfgMap.get(Integer.valueOf(knockOutType));
/*  277 */     if (knockOutCfg == null)
/*      */     {
/*  279 */       return null;
/*      */     }
/*      */     
/*  282 */     long currentTimeMillis = DateTimeUtils.getCurrTimeInMillis();
/*  283 */     int stageSize = knockOutCfg.stage_time_point_cfg_id_list.size();
/*      */     
/*  285 */     for (int nowStage = 0; nowStage < stageSize; nowStage++)
/*      */     {
/*  287 */       int beginTimePointCfgId = ((Integer)knockOutCfg.stage_time_point_cfg_id_list.get(nowStage)).intValue();
/*      */       
/*  289 */       STimePointCommonCfg sTimePointCommonCfgBegin = STimePointCommonCfg.get(beginTimePointCfgId);
/*  290 */       if (sTimePointCommonCfgBegin == null)
/*      */       {
/*  292 */         GameServer.logger().error(String.format("[crossbattle_selection]CrossBattleKnockOutInterface.process@activity cfg time data not found|activity_cfg_id=%d|time_point_cfg_id=%d", new Object[] { Integer.valueOf(activityCfgId), Integer.valueOf(beginTimePointCfgId) }));
/*      */         
/*      */ 
/*      */ 
/*  296 */         return null;
/*      */       }
/*      */       
/*  299 */       long selectionStageTimeFirst = TimeCommonUtil.getTimePoint(sTimePointCommonCfgBegin) - knockOutCfg.prepare_world_countdown * 60000L;
/*      */       
/*  301 */       if (currentTimeMillis < selectionStageTimeFirst)
/*      */       {
/*  303 */         return new Pair(Integer.valueOf(nowStage), Boolean.valueOf(false));
/*      */       }
/*      */       
/*  306 */       long selectionStageNeedRereshTime = selectionStageTimeFirst + (knockOutCfg.prepare_world_countdown + knockOutCfg.fight_last_time + 10) * 60000L;
/*      */       
/*      */ 
/*      */ 
/*  310 */       if ((currentTimeMillis >= selectionStageTimeFirst) && (currentTimeMillis < selectionStageNeedRereshTime))
/*      */       {
/*  312 */         return new Pair(Integer.valueOf(nowStage + 1), Boolean.valueOf(true));
/*      */       }
/*      */       
/*  315 */       Integer finalStageTimeCfgId = null;
/*  316 */       if (nowStage + 1 < stageSize)
/*      */       {
/*  318 */         finalStageTimeCfgId = (Integer)knockOutCfg.stage_time_point_cfg_id_list.get(nowStage + 1);
/*      */       }
/*      */       
/*  321 */       if (finalStageTimeCfgId == null)
/*      */       {
/*  323 */         return new Pair(Integer.valueOf(nowStage + 1), Boolean.valueOf(false));
/*      */       }
/*      */     }
/*      */     
/*  327 */     return null;
/*      */   }
/*      */   
/*      */   public static void stopAbstainObserver(long corpsId)
/*      */   {
/*  332 */     KnockOutAbstainObserver observer = (KnockOutAbstainObserver)CrossBattleKnockoutManager.corpsId2AbstainObserverMap.get(Long.valueOf(corpsId));
/*  333 */     if (observer != null)
/*      */     {
/*  335 */       observer.stopTimer();
/*  336 */       CrossBattleKnockoutManager.corpsId2AbstainObserverMap.remove(Long.valueOf(corpsId));
/*  337 */       StringBuilder logBuilder = new StringBuilder();
/*  338 */       logBuilder.append("[crossbattle_knockout]CrossBattleKnockoutInterface.stopAbstainObserver@stop abstain observer");
/*  339 */       logBuilder.append(observer);
/*  340 */       GameServer.logger().info(logBuilder);
/*      */     }
/*      */     else
/*      */     {
/*  344 */       StringBuilder logBuilder = new StringBuilder();
/*  345 */       logBuilder.append("[crossbattle_knockout]CrossBattleKnockoutInterface.stopAbstainObserver@stop abstain observer fail");
/*  346 */       logBuilder.append("corps_id=").append(corpsId);
/*  347 */       GameServer.logger().info(logBuilder);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void fillNextStageTimeMailContextArgs(KnockOutCfg knockOutCfg, int selectionStage, List<String> contextArgList)
/*      */   {
/*  356 */     int timePointCfgId = ((Integer)knockOutCfg.stage_time_point_cfg_id_list.get(selectionStage - 1)).intValue();
/*  357 */     STimePointCommonCfg timePointCommonCfg = STimePointCommonCfg.get(timePointCfgId);
/*  358 */     if (timePointCommonCfg != null)
/*      */     {
/*  360 */       long nextStagePrepareTime = TimeCommonUtil.getTimePoint(timePointCommonCfg) - knockOutCfg.prepare_world_countdown * 60000L;
/*      */       
/*      */ 
/*  363 */       Calendar calendar = TimeCommonUtil.getCalendar(nextStagePrepareTime);
/*      */       
/*  365 */       contextArgList.add(String.valueOf(calendar.get(1)));
/*  366 */       contextArgList.add(String.valueOf(calendar.get(2) + 1));
/*  367 */       contextArgList.add(String.valueOf(calendar.get(5)));
/*  368 */       contextArgList.add(String.valueOf(calendar.get(11)));
/*  369 */       contextArgList.add(String.format("%02d", new Object[] { Integer.valueOf(calendar.get(12)) }));
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
/*      */   public static void initKnockOutData(int retcode, int activityCfgId, int knockOutType, int fightZoneId, String knockOutJsonStr, Octets context)
/*      */   {
/*  390 */     new PInitKnockOutData(retcode, activityCfgId, knockOutType, fightZoneId, knockOutJsonStr).call();
/*      */     
/*  392 */     GetKnockOutInfoArg getKnockOutInfoArg = new GetKnockOutInfoArg(activityCfgId, knockOutType, fightZoneId, context, retcode);
/*      */     
/*      */ 
/*  395 */     TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.crossbattle.event.GetKnockOutInfo(), getKnockOutInfoArg, CrossBattleOneByOneManager.getInstance().getTaskOneByOne(Integer.valueOf(activityCfgId)));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public static void onGetFightStageCorpsIdList(int retcode, int activityCfgId, int knockOutType, int fightStage, Set<Long> corpsIdSet, Octets context)
/*      */   {
/*  402 */     GetFightStageCorpsIdListArg getFightStageCorpsIdListArg = new GetFightStageCorpsIdListArg(activityCfgId, knockOutType, fightStage, corpsIdSet, context, retcode);
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  407 */     TriggerEventsManger.getInstance().triggerEvent(new GetFightStageCorpsIdList(), getFightStageCorpsIdListArg, CrossBattleOneByOneManager.getInstance().getTaskOneByOne(Integer.valueOf(activityCfgId)));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public static void initKnockOutOwnServerData(int retcode, long roleId, int activityCfgId, int knockOutType, int fightStage, String knockOutOwnServerJsonStr)
/*      */   {
/*  414 */     new PInitKnockOutOwnServerData(retcode, roleId, activityCfgId, knockOutType, fightStage, knockOutOwnServerJsonStr).call();
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
/*      */   public static int getKnockOutStageFightNum(int activityCfgId, int knockOutType, int knockOutStage)
/*      */   {
/*  429 */     SCrossBattleKnockOutCfg sCrossBattleKnockOutCfg = SCrossBattleKnockOutCfg.get(activityCfgId);
/*  430 */     if (sCrossBattleKnockOutCfg == null)
/*      */     {
/*  432 */       return -1;
/*      */     }
/*      */     
/*  435 */     KnockOutCfg knockOutCfg = (KnockOutCfg)sCrossBattleKnockOutCfg.knockOutTypeCfgMap.get(Integer.valueOf(knockOutType));
/*  436 */     if (knockOutCfg == null)
/*      */     {
/*  438 */       return -1;
/*      */     }
/*      */     
/*  441 */     return CrossBattleKnockoutManager.getMaxFightIndexId(knockOutCfg.need_team_size, knockOutStage, knockOutCfg.fight_times_every_stage);
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
/*      */   public static int getKnockOutStageSize(int activityCfgId, int knockOutType)
/*      */   {
/*  455 */     SCrossBattleKnockOutCfg sCrossBattleKnockOutCfg = SCrossBattleKnockOutCfg.get(activityCfgId);
/*  456 */     if (sCrossBattleKnockOutCfg == null)
/*      */     {
/*  458 */       return -1;
/*      */     }
/*      */     
/*  461 */     KnockOutCfg knockOutCfg = (KnockOutCfg)sCrossBattleKnockOutCfg.knockOutTypeCfgMap.get(Integer.valueOf(knockOutType));
/*  462 */     if (knockOutCfg == null)
/*      */     {
/*  464 */       return -1;
/*      */     }
/*  466 */     return knockOutCfg.stage_name_list.size();
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
/*      */   public static long getKnockOutStageFightBeginTime(int activityCfgId, int knockOutType, int fightStage)
/*      */   {
/*  481 */     SCrossBattleKnockOutCfg sCrossBattleKnockOutCfg = SCrossBattleKnockOutCfg.get(activityCfgId);
/*  482 */     if (sCrossBattleKnockOutCfg == null)
/*      */     {
/*  484 */       return -1L;
/*      */     }
/*      */     
/*  487 */     KnockOutCfg knockOutCfg = (KnockOutCfg)sCrossBattleKnockOutCfg.knockOutTypeCfgMap.get(Integer.valueOf(knockOutType));
/*  488 */     if (knockOutCfg == null)
/*      */     {
/*  490 */       return -1L;
/*      */     }
/*  492 */     int timePointCfgId = ((Integer)knockOutCfg.stage_time_point_cfg_id_list.get(fightStage - 1)).intValue();
/*      */     
/*  494 */     STimePointCommonCfg sTimePointCommonCfg = STimePointCommonCfg.get(timePointCfgId);
/*  495 */     if (sTimePointCommonCfg == null)
/*      */     {
/*  497 */       return -1L;
/*      */     }
/*      */     
/*  500 */     return TimeCommonUtil.getTimePoint(sTimePointCommonCfg);
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
/*      */   public static CrossBattleFightZoneInfo getCrossBattleKnockOutFightZoneInfo(int activityCfgId, int knockOutType, int fightZoneId)
/*      */   {
/*  516 */     if (!isFightZoneValid(fightZoneId, knockOutType))
/*      */     {
/*  518 */       return null;
/*      */     }
/*      */     
/*  521 */     long globalActivityCfgid = GameServerInfoManager.toGlobalId(activityCfgId);
/*  522 */     CrossBattleKnockoutActivityInfo xCrossBattleKnockoutActivityInfo = Cross_battle_knockout.get(Long.valueOf(globalActivityCfgid));
/*  523 */     if (xCrossBattleKnockoutActivityInfo == null)
/*      */     {
/*  525 */       return null;
/*      */     }
/*      */     
/*  528 */     CrossBattleKnockoutInfo xCrossBattleKnockoutInfo = (CrossBattleKnockoutInfo)xCrossBattleKnockoutActivityInfo.getKnockout_info_map().get(Integer.valueOf(knockOutType));
/*      */     
/*  530 */     if (xCrossBattleKnockoutInfo == null)
/*      */     {
/*  532 */       return null;
/*      */     }
/*      */     
/*  535 */     FightZoneInfo xFightZoneInfo = (FightZoneInfo)xCrossBattleKnockoutInfo.getFight_zone_info_map().get(Integer.valueOf(fightZoneId));
/*  536 */     if (xFightZoneInfo == null)
/*      */     {
/*  538 */       return null;
/*      */     }
/*      */     
/*  541 */     SCrossBattleKnockOutCfg sCrossBattleKnockOutCfg = SCrossBattleKnockOutCfg.get(activityCfgId);
/*  542 */     if (sCrossBattleKnockOutCfg == null)
/*      */     {
/*  544 */       return null;
/*      */     }
/*      */     
/*  547 */     KnockOutCfg knockOutCfg = (KnockOutCfg)sCrossBattleKnockOutCfg.knockOutTypeCfgMap.get(Integer.valueOf(knockOutType));
/*  548 */     if (knockOutCfg == null)
/*      */     {
/*  550 */       return null;
/*      */     }
/*      */     
/*  553 */     return new CrossBattleFightZoneInfo(xFightZoneInfo, knockOutCfg);
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
/*      */   public static boolean getCrossBattleKnockOutInfo(int activityCfgId, int knockOutType, int fightZoneId, Octets octets)
/*      */   {
/*  571 */     SCrossBattleKnockOutCfg sCrossBattleKnockOutCfg = SCrossBattleKnockOutCfg.get(activityCfgId);
/*  572 */     if (sCrossBattleKnockOutCfg == null)
/*      */     {
/*  574 */       return false;
/*      */     }
/*      */     
/*  577 */     KnockOutCfg knockOutCfg = (KnockOutCfg)sCrossBattleKnockOutCfg.knockOutTypeCfgMap.get(Integer.valueOf(knockOutType));
/*  578 */     if (knockOutCfg == null)
/*      */     {
/*  580 */       return false;
/*      */     }
/*      */     
/*  583 */     Pair<Integer, Boolean> nowFightStagePair = getNowFightStage(knockOutType);
/*  584 */     if (nowFightStagePair == null)
/*      */     {
/*  586 */       return false;
/*      */     }
/*      */     
/*  589 */     boolean isFightZoneValid = isFightZoneValid(fightZoneId, knockOutType);
/*  590 */     if (!isFightZoneValid)
/*      */     {
/*  592 */       return false;
/*      */     }
/*      */     
/*  595 */     int maxTeamNum = knockOutCfg.need_team_size;
/*  596 */     int maxStage = knockOutCfg.stage_name_list.size();
/*      */     
/*  598 */     return GrcInterface.getCrossBattleKnockOutInfo(activityCfgId, knockOutType, fightZoneId, ((Integer)nowFightStagePair.first).intValue(), maxTeamNum, maxStage, knockOutCfg.fight_times_every_stage, octets);
/*      */   }
/*      */   
/*      */ 
/*      */   public static boolean isFightZoneValid(int fightZoneId, int knockOutType)
/*      */   {
/*  604 */     switch (knockOutType)
/*      */     {
/*      */     case 1: 
/*  607 */       if ((fightZoneId <= 0) || (fightZoneId > CrossBattlePointInterface.getZoneNum()))
/*      */       {
/*  609 */         return false;
/*      */       }
/*      */       
/*      */ 
/*  613 */       return true;
/*      */     
/*      */     case 2: 
/*  616 */       if (fightZoneId != CrossBattleKnockoutManager.GLOBAL_FIGHT_ZONE)
/*      */       {
/*  618 */         return false;
/*      */       }
/*      */       
/*      */ 
/*  622 */       return true;
/*      */     }
/*      */     
/*  625 */     return false;
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
/*      */   public static long getCrossBattleKnockOutStageCalTime(int activityCfgId, int knockOutType, int fightStage)
/*      */   {
/*  641 */     SCrossBattleKnockOutCfg sCrossBattleKnockOutCfg = SCrossBattleKnockOutCfg.get(activityCfgId);
/*  642 */     if (sCrossBattleKnockOutCfg == null)
/*      */     {
/*  644 */       return -1L;
/*      */     }
/*      */     
/*  647 */     KnockOutCfg knockOutCfg = (KnockOutCfg)sCrossBattleKnockOutCfg.knockOutTypeCfgMap.get(Integer.valueOf(knockOutType));
/*  648 */     if (knockOutCfg == null)
/*      */     {
/*  650 */       return -1L;
/*      */     }
/*      */     
/*  653 */     if (fightStage > knockOutCfg.stage_time_point_cfg_id_list.size())
/*      */     {
/*  655 */       return -1L;
/*      */     }
/*      */     
/*  658 */     int timePointCfgId = ((Integer)knockOutCfg.stage_time_point_cfg_id_list.get(fightStage - 1)).intValue();
/*      */     
/*  660 */     STimePointCommonCfg sTimePointCommonCfg = STimePointCommonCfg.get(timePointCfgId);
/*  661 */     if (sTimePointCommonCfg == null)
/*      */     {
/*  663 */       return -1L;
/*      */     }
/*      */     
/*  666 */     long selectionStageTime = TimeCommonUtil.getTimePoint(sTimePointCommonCfg);
/*      */     
/*  668 */     long stageCalTime = selectionStageTime + knockOutCfg.fight_last_time * 60000L + 600000L;
/*      */     
/*      */ 
/*  671 */     return stageCalTime;
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
/*      */   public static String getCrossBattleKnockOutStageName(int activityCfgId, int knockOutType, int fightStage)
/*      */   {
/*  688 */     SCrossBattleKnockOutCfg sCrossBattleKnockOutCfg = SCrossBattleKnockOutCfg.get(activityCfgId);
/*  689 */     if (sCrossBattleKnockOutCfg == null)
/*      */     {
/*  691 */       return null;
/*      */     }
/*      */     
/*  694 */     KnockOutCfg knockOutCfg = (KnockOutCfg)sCrossBattleKnockOutCfg.knockOutTypeCfgMap.get(Integer.valueOf(knockOutType));
/*  695 */     if (knockOutCfg == null)
/*      */     {
/*  697 */       return null;
/*      */     }
/*      */     
/*  700 */     if (fightStage > knockOutCfg.stage_name_list.size())
/*      */     {
/*  702 */       return null;
/*      */     }
/*      */     
/*  705 */     return (String)knockOutCfg.stage_name_list.get(fightStage - 1);
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
/*      */   public static long getCrossBattleKnockOutStageTime(int activityCfgId, int knockOutType, int fightStage)
/*      */   {
/*  723 */     SCrossBattleKnockOutCfg sCrossBattleKnockOutCfg = SCrossBattleKnockOutCfg.get(activityCfgId);
/*  724 */     if (sCrossBattleKnockOutCfg == null)
/*      */     {
/*  726 */       return -1L;
/*      */     }
/*      */     
/*  729 */     KnockOutCfg knockOutCfg = (KnockOutCfg)sCrossBattleKnockOutCfg.knockOutTypeCfgMap.get(Integer.valueOf(knockOutType));
/*  730 */     if (knockOutCfg == null)
/*      */     {
/*  732 */       return -1L;
/*      */     }
/*      */     
/*  735 */     if (fightStage > knockOutCfg.stage_time_point_cfg_id_list.size())
/*      */     {
/*  737 */       return -1L;
/*      */     }
/*      */     
/*  740 */     int timePointCfgid = ((Integer)knockOutCfg.stage_time_point_cfg_id_list.get(fightStage - 1)).intValue();
/*  741 */     STimePointCommonCfg sTimePointCommonCfg = STimePointCommonCfg.get(timePointCfgid);
/*  742 */     if (sTimePointCommonCfg == null)
/*      */     {
/*  744 */       return -1L;
/*      */     }
/*      */     
/*  747 */     return TimeCommonUtil.getTimePoint(sTimePointCommonCfg) - knockOutCfg.prepare_world_countdown * 60000L;
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
/*      */   public static long getCrossBattleKnockOutLastStageEnterTime(int activityCfgId, int knockOutType)
/*      */   {
/*  763 */     SCrossBattleKnockOutCfg sCrossBattleKnockOutCfg = SCrossBattleKnockOutCfg.get(activityCfgId);
/*  764 */     if (sCrossBattleKnockOutCfg == null)
/*      */     {
/*  766 */       return -1L;
/*      */     }
/*      */     
/*  769 */     KnockOutCfg knockOutCfg = (KnockOutCfg)sCrossBattleKnockOutCfg.knockOutTypeCfgMap.get(Integer.valueOf(knockOutType));
/*  770 */     if (knockOutCfg == null)
/*      */     {
/*  772 */       return -1L;
/*      */     }
/*      */     
/*  775 */     int fightStageSize = knockOutCfg.stage_time_point_cfg_id_list.size();
/*  776 */     int lastTimePointCfgId = ((Integer)knockOutCfg.stage_time_point_cfg_id_list.get(fightStageSize - 1)).intValue();
/*  777 */     STimePointCommonCfg sTimePointCommonCfg = STimePointCommonCfg.get(lastTimePointCfgId);
/*  778 */     if (sTimePointCommonCfg == null)
/*      */     {
/*  780 */       return -1L;
/*      */     }
/*      */     
/*  783 */     return TimeCommonUtil.getTimePoint(sTimePointCommonCfg);
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
/*      */   public static long getCrossBattleKnockOutStageLastEnterTime(int activityCfgId, int knockOutType, int fightStage)
/*      */   {
/*  802 */     SCrossBattleKnockOutCfg sCrossBattleKnockOutCfg = SCrossBattleKnockOutCfg.get(activityCfgId);
/*  803 */     if (sCrossBattleKnockOutCfg == null)
/*      */     {
/*  805 */       return -1L;
/*      */     }
/*      */     
/*  808 */     KnockOutCfg knockOutCfg = (KnockOutCfg)sCrossBattleKnockOutCfg.knockOutTypeCfgMap.get(Integer.valueOf(knockOutType));
/*  809 */     if (knockOutCfg == null)
/*      */     {
/*  811 */       return -1L;
/*      */     }
/*      */     
/*  814 */     if (fightStage > knockOutCfg.stage_time_point_cfg_id_list.size())
/*      */     {
/*  816 */       return -1L;
/*      */     }
/*      */     
/*  819 */     int timePointCfgid = ((Integer)knockOutCfg.stage_time_point_cfg_id_list.get(fightStage - 1)).intValue();
/*  820 */     STimePointCommonCfg sTimePointCommonCfg = STimePointCommonCfg.get(timePointCfgid);
/*  821 */     if (sTimePointCommonCfg == null)
/*      */     {
/*  823 */       return -1L;
/*      */     }
/*      */     
/*  826 */     return TimeCommonUtil.getTimePoint(sTimePointCommonCfg);
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
/*      */   public static int getFightZoneId(int activityCfgId, int knockOutType, long corpsId)
/*      */   {
/*  843 */     return CrossBattleKnockoutManager.getFightZone(corpsId, activityCfgId, knockOutType);
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
/*      */   public static void onGetNotifyCrossBattleRestartCorpsIdList(int activityCfgId, int knockOutType, boolean isRestartAllFightZone, List<Pair<Integer, Integer>> restartFightList, long worldBeginTime, int fightStage, Map<Long, Pair<Long, String>> corpsIdMap, int type)
/*      */   {
/*  867 */     switch (type)
/*      */     {
/*      */     case 1: 
/*  870 */       new PRestartKnockOutSendMail(activityCfgId, knockOutType, worldBeginTime, fightStage, corpsIdMap).call();
/*  871 */       break;
/*      */     
/*      */     case 2: 
/*  874 */       Set<Long> corpsIdSet = corpsIdMap.keySet();
/*  875 */       new POnGetNotifyCorpsIdSet(knockOutType, fightStage, corpsIdSet, true).call();
/*  876 */       break;
/*      */     }
/*      */     
/*      */   }
/*      */   
/*      */ 
/*      */   public static void sendGetCorpsInfoFail(long roleId)
/*      */   {
/*  884 */     SCrossBattleSelectionNormalRes normalRes = new SCrossBattleSelectionNormalRes();
/*  885 */     normalRes.ret = 33;
/*      */     
/*  887 */     OnlineManager.getInstance().send(roleId, normalRes);
/*      */   }
/*      */   
/*      */   public static void sendGetCorpInfo(long roleId, long corpsId, String corpsInfoJson)
/*      */     throws UnsupportedEncodingException
/*      */   {
/*  893 */     JSONObject jsonObject = new JSONObject(corpsInfoJson);
/*      */     
/*  895 */     SGetCorpsDetailInfoRep rsp = new SGetCorpsDetailInfoRep();
/*      */     
/*  897 */     if (jsonObject.has("declaration"))
/*      */     {
/*  899 */       String declaration = jsonObject.getString("declaration");
/*  900 */       rsp.corpsdetailinfo.corpsbriefinfo.declaration.setString(declaration, "UTF-8");
/*      */     }
/*      */     
/*  903 */     if (jsonObject.has("createTime"))
/*      */     {
/*  905 */       int createTime = jsonObject.getInt("createTime");
/*  906 */       rsp.corpsdetailinfo.corpsbriefinfo.createtime = createTime;
/*      */     }
/*      */     
/*  909 */     if (jsonObject.has("badge"))
/*      */     {
/*  911 */       int badge = jsonObject.getInt("badge");
/*  912 */       rsp.corpsdetailinfo.corpsbriefinfo.corpsbadgeid = badge;
/*      */     }
/*      */     
/*  915 */     if (jsonObject.has("name"))
/*      */     {
/*  917 */       String corpsName = jsonObject.getString("name");
/*  918 */       rsp.corpsdetailinfo.corpsbriefinfo.name.setString(corpsName, "UTF-8");
/*      */     }
/*      */     
/*  921 */     rsp.corpsdetailinfo.corpsbriefinfo.corpsid = corpsId;
/*      */     
/*  923 */     JSONArray roleInfoArray = jsonObject.getJSONArray("role_array");
/*  924 */     int roleSize = roleInfoArray.length();
/*      */     
/*  926 */     for (int index = 0; index < roleSize; index++)
/*      */     {
/*  928 */       CorpsMemberDetailInfo corpsMemberDetailInfo = new CorpsMemberDetailInfo();
/*  929 */       JSONObject roleJsonObj = roleInfoArray.getJSONObject(index);
/*      */       
/*  931 */       if (roleJsonObj.has("role_id"))
/*      */       {
/*  933 */         long memberRoleId = roleJsonObj.getLong("role_id");
/*  934 */         corpsMemberDetailInfo.baseinfo.roleid = memberRoleId;
/*  935 */         rsp.corpsdetailinfo.members.put(Long.valueOf(memberRoleId), corpsMemberDetailInfo);
/*      */         
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  942 */         if (roleJsonObj.has("gender"))
/*      */         {
/*  944 */           int gender = roleJsonObj.getInt("gender");
/*  945 */           corpsMemberDetailInfo.baseinfo.gender = gender;
/*      */         }
/*      */         
/*  948 */         if (roleJsonObj.has("level"))
/*      */         {
/*  950 */           int roleLevel = roleJsonObj.getInt("level");
/*  951 */           corpsMemberDetailInfo.baseinfo.level = roleLevel;
/*      */         }
/*      */         
/*  954 */         if (roleJsonObj.has("name"))
/*      */         {
/*  956 */           String roleName = roleJsonObj.getString("name");
/*  957 */           corpsMemberDetailInfo.baseinfo.name.setString(roleName, "UTF-8");
/*      */         }
/*      */         
/*  960 */         if (roleJsonObj.has("occupation"))
/*      */         {
/*  962 */           int occupationId = roleJsonObj.getInt("occupation");
/*  963 */           corpsMemberDetailInfo.baseinfo.occupationid = occupationId;
/*      */         }
/*      */         
/*  966 */         if (roleJsonObj.has("duty"))
/*      */         {
/*  968 */           int duty = roleJsonObj.getInt("duty");
/*  969 */           corpsMemberDetailInfo.baseinfo.duty = duty;
/*      */         }
/*      */         
/*  972 */         if (roleJsonObj.has("last_logoff_time"))
/*      */         {
/*  974 */           int lastLogoffTime = roleJsonObj.getInt("last_logoff_time");
/*  975 */           corpsMemberDetailInfo.baseinfo.offlinetime = lastLogoffTime;
/*      */         }
/*      */         
/*  978 */         if (roleJsonObj.has("join_time"))
/*      */         {
/*  980 */           int joinTime = roleJsonObj.getInt("join_time");
/*  981 */           corpsMemberDetailInfo.baseinfo.jointime = joinTime;
/*      */         }
/*      */         
/*  984 */         if (roleJsonObj.has("mf_rank"))
/*      */         {
/*  986 */           int mfRank = roleJsonObj.getInt("mf_rank");
/*  987 */           corpsMemberDetailInfo.otherinfo.mfvrank = mfRank;
/*      */         }
/*      */         
/*  990 */         if (roleJsonObj.has("avatarId"))
/*      */         {
/*  992 */           int avatarId = roleJsonObj.getInt("avatarId");
/*  993 */           corpsMemberDetailInfo.baseinfo.avatarid = avatarId;
/*      */         }
/*      */         
/*  996 */         if (roleJsonObj.has("fight_value"))
/*      */         {
/*  998 */           int fightValue = roleJsonObj.getInt("fight_value");
/*  999 */           corpsMemberDetailInfo.otherinfo.multifightvalue = fightValue;
/*      */         }
/*      */       }
/*      */     }
/* 1003 */     OnlineManager.getInstance().send(roleId, rsp);
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
/*      */   public static void onGetHistoryCorpsInfo(int ret, long corpsId, String corpsInfoJson, Octets octets)
/*      */   {
/* 1016 */     FightStageEndCorpsInfo corpsInfo = new FightStageEndCorpsInfo();
/* 1017 */     if (corpsInfoJson != null)
/*      */     {
/* 1019 */       JSONObject jsonObject = new JSONObject(corpsInfoJson);
/*      */       
/* 1021 */       corpsInfo.corpsId = corpsId;
/* 1022 */       if (jsonObject.has("badge"))
/*      */       {
/* 1024 */         int badge = jsonObject.getInt("badge");
/* 1025 */         corpsInfo.corpsBadgeId = badge;
/*      */       }
/*      */       
/* 1028 */       if (jsonObject.has("name"))
/*      */       {
/* 1030 */         String corpsName = jsonObject.getString("name");
/* 1031 */         corpsInfo.corpsName = corpsName;
/*      */       }
/*      */       
/* 1034 */       if (jsonObject.has("zoneid"))
/*      */       {
/* 1036 */         int zoneId = jsonObject.getInt("zoneid");
/* 1037 */         corpsInfo.corpsZoneId = zoneId;
/*      */       }
/*      */       
/* 1040 */       JSONArray roleInfoArray = jsonObject.getJSONArray("role_array");
/* 1041 */       int roleSize = roleInfoArray == null ? 0 : roleInfoArray.length();
/*      */       
/* 1043 */       for (int index = 0; index < roleSize; index++)
/*      */       {
/* 1045 */         FightStageEndCorpsInfo.CorpsMemberInfoObj corpsMemberInfo = new FightStageEndCorpsInfo.CorpsMemberInfoObj();
/* 1046 */         JSONObject roleJsonObj = roleInfoArray.getJSONObject(index);
/*      */         
/* 1048 */         if (roleJsonObj.has("role_id"))
/*      */         {
/* 1050 */           long memberRoleId = roleJsonObj.getLong("role_id");
/* 1051 */           corpsMemberInfo.roleId = memberRoleId;
/*      */         }
/*      */         
/* 1054 */         if (roleJsonObj.has("gender"))
/*      */         {
/* 1056 */           int gender = roleJsonObj.getInt("gender");
/* 1057 */           corpsMemberInfo.gender = gender;
/*      */         }
/*      */         
/* 1060 */         if (roleJsonObj.has("level"))
/*      */         {
/* 1062 */           int roleLevel = roleJsonObj.getInt("level");
/* 1063 */           corpsMemberInfo.roleLevel = roleLevel;
/*      */         }
/*      */         
/* 1066 */         if (roleJsonObj.has("name"))
/*      */         {
/* 1068 */           String roleName = roleJsonObj.getString("name");
/* 1069 */           corpsMemberInfo.roleName = roleName;
/*      */         }
/*      */         
/* 1072 */         if (roleJsonObj.has("occupation"))
/*      */         {
/* 1074 */           int occupationId = roleJsonObj.getInt("occupation");
/* 1075 */           corpsMemberInfo.occupation = occupationId;
/*      */         }
/*      */         
/* 1078 */         if (roleJsonObj.has("duty"))
/*      */         {
/* 1080 */           int duty = roleJsonObj.getInt("duty");
/* 1081 */           corpsMemberInfo.duty = duty;
/*      */         }
/*      */         
/* 1084 */         if (roleJsonObj.has("join_time"))
/*      */         {
/* 1086 */           int joinTime = roleJsonObj.getInt("join_time");
/* 1087 */           corpsMemberInfo.joinTime = joinTime;
/*      */         }
/*      */         
/* 1090 */         if (roleJsonObj.has("avatarId"))
/*      */         {
/* 1092 */           int avatarId = roleJsonObj.getInt("avatarId");
/* 1093 */           corpsMemberInfo.avatarId = avatarId;
/*      */         }
/*      */         
/* 1096 */         if (roleJsonObj.has("fight_value"))
/*      */         {
/* 1098 */           int fightValue = roleJsonObj.getInt("fight_value");
/* 1099 */           corpsMemberInfo.roleFightValue = fightValue;
/*      */         }
/*      */         
/* 1102 */         if (roleJsonObj.has("model_id"))
/*      */         {
/* 1104 */           int modelId = roleJsonObj.getInt("model_id");
/* 1105 */           corpsMemberInfo.modelInfo.modelid = modelId;
/*      */         }
/*      */         
/* 1108 */         if (roleJsonObj.has("model_info_name"))
/*      */         {
/* 1110 */           String modelInfoName = roleJsonObj.getString("model_info_name");
/* 1111 */           corpsMemberInfo.modelInfo.name = modelInfoName;
/*      */         }
/*      */         
/* 1114 */         if (roleJsonObj.has("model_property"))
/*      */         {
/* 1116 */           String modelPropertyJsonStr = roleJsonObj.getString("model_property");
/* 1117 */           JSONObject modelPropertyJson = new JSONObject(modelPropertyJsonStr);
/*      */           
/* 1119 */           JSONArray jsonArray = modelPropertyJson.getJSONArray("extra_property_array");
/* 1120 */           for (int propertyIndex = 0; propertyIndex < jsonArray.length(); propertyIndex++)
/*      */           {
/* 1122 */             JSONObject propertyJsonObject = jsonArray.getJSONObject(propertyIndex);
/*      */             
/* 1124 */             int key = propertyJsonObject.getInt("key");
/* 1125 */             int value = propertyJsonObject.getInt("value");
/*      */             
/* 1127 */             corpsMemberInfo.modelInfo.extramap.put(Integer.valueOf(key), Integer.valueOf(value));
/*      */           }
/*      */         }
/* 1130 */         corpsInfo.corpsMemberSet.add(corpsMemberInfo);
/*      */       }
/*      */     }
/*      */     
/* 1134 */     GetFightStageEndCorpsInfoArg arg = new GetFightStageEndCorpsInfoArg(ret, corpsId, corpsInfo, octets);
/*      */     
/* 1136 */     TriggerEventsManger.getInstance().triggerEvent(new GetFightStageEndCorpsInfo(), arg);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void sendHistoryCorpInfo(int session, int rank, long roleId, long corpsId, FightStageEndCorpsInfo corpsInfo)
/*      */     throws UnsupportedEncodingException
/*      */   {
/* 1145 */     SGetCrossBattleFinalHistoryCorpsInfo rsp = new SGetCrossBattleFinalHistoryCorpsInfo();
/* 1146 */     rsp.session = session;
/* 1147 */     rsp.rank = rank;
/* 1148 */     rsp.corps_id = corpsId;
/* 1149 */     rsp.corps_badge_id = corpsInfo.corpsBadgeId;
/* 1150 */     rsp.corps_name.setString(corpsInfo.corpsName, "UTF-8");
/* 1151 */     rsp.corps_zone_id = corpsInfo.corpsZoneId;
/*      */     
/* 1153 */     for (FightStageEndCorpsInfo.CorpsMemberInfoObj corpsMemberInfoObj : corpsInfo.corpsMemberSet)
/*      */     {
/* 1155 */       CorpsMemberInfo corpsMemberInfo = new CorpsMemberInfo();
/*      */       
/* 1157 */       corpsMemberInfo.roleid = corpsMemberInfoObj.roleId;
/* 1158 */       corpsMemberInfo.gender = corpsMemberInfoObj.gender;
/* 1159 */       corpsMemberInfo.role_level = corpsMemberInfoObj.roleLevel;
/* 1160 */       corpsMemberInfo.role_name.setString(corpsMemberInfoObj.roleName, "UTF-8");
/* 1161 */       corpsMemberInfo.occupation = corpsMemberInfoObj.occupation;
/* 1162 */       corpsMemberInfo.duty = corpsMemberInfoObj.duty;
/* 1163 */       corpsMemberInfo.join_time = corpsMemberInfoObj.joinTime;
/* 1164 */       corpsMemberInfo.avatar_id = corpsMemberInfoObj.avatarId;
/* 1165 */       corpsMemberInfo.role_fight_value = corpsMemberInfoObj.roleFightValue;
/* 1166 */       corpsMemberInfo.role_model_info = corpsMemberInfoObj.modelInfo;
/* 1167 */       rsp.corps_member_set.add(corpsMemberInfo);
/*      */     }
/*      */     
/* 1170 */     OnlineManager.getInstance().send(roleId, rsp);
/*      */   }
/*      */   
/*      */   public static void initCorpsRoleInfoReportObserver()
/*      */   {
/* 1175 */     for (SCrossBattleKnockOutCfg sCrossBattleKnockOutCfg : SCrossBattleKnockOutCfg.getAll().values())
/*      */     {
/* 1177 */       int activityCfgId = sCrossBattleKnockOutCfg.activity_cfg_id;
/* 1178 */       if (ActivityInterface.isActivityOpen(activityCfgId))
/*      */       {
/* 1180 */         CrossBattleKnockoutManager.initCorpsRoleInfoReportObserver(activityCfgId);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void onRoundCorpsRankUp(int activityCfgId)
/*      */   {
/* 1193 */     CrossBattleKnockoutManager.initCorpsRoleInfoReportObserver(activityCfgId);
/*      */   }
/*      */   
/*      */ 
/*      */   public static void onReportCrossBattleFightResult(int activityCfgId, int knockOutType, int fightZoneId, long ownCorpsId, String ownCorpsName, long opponentCorpsId, String opponentCorpsName, int nowFightStage, int fightIndexId, String fightResult)
/*      */     throws UnsupportedEncodingException
/*      */   {
/* 1200 */     GetKnockOutContext_ReportFightResult context = new GetKnockOutContext_ReportFightResult();
/* 1201 */     context.corps_id = ownCorpsId;
/* 1202 */     context.corps_name.setString(ownCorpsName, "UTF-8");
/* 1203 */     context.opponent_corps_id = opponentCorpsId;
/* 1204 */     context.opponent_corps_name.setString(opponentCorpsName, "UTF-8");
/* 1205 */     context.fight_stage = nowFightStage;
/* 1206 */     context.fight_index_id = fightIndexId;
/* 1207 */     context.corps_fight_result = Integer.valueOf(fightResult).intValue();
/*      */     
/* 1209 */     OctetsStream octetsStream = new OctetsStream();
/* 1210 */     octetsStream.marshal(context);
/*      */     
/* 1212 */     GetKnockOutContext getKnockOutContext = new GetKnockOutContext();
/* 1213 */     getKnockOutContext.oper_type = 8;
/* 1214 */     getKnockOutContext.content = octetsStream;
/*      */     
/* 1216 */     Pair<Integer, Boolean> nowFightStagePair = getNowFightStage(knockOutType);
/* 1217 */     if (nowFightStagePair == null)
/*      */     {
/* 1219 */       return;
/*      */     }
/*      */     
/* 1222 */     SCrossBattleKnockOutCfg sCrossBattleKnockOutCfg = SCrossBattleKnockOutCfg.get(activityCfgId);
/* 1223 */     if (sCrossBattleKnockOutCfg == null)
/*      */     {
/* 1225 */       return;
/*      */     }
/*      */     
/* 1228 */     KnockOutCfg knockOutCfg = (KnockOutCfg)sCrossBattleKnockOutCfg.knockOutTypeCfgMap.get(Integer.valueOf(knockOutType));
/* 1229 */     if (knockOutCfg == null)
/*      */     {
/* 1231 */       return;
/*      */     }
/*      */     
/* 1234 */     int nowKnockOutStage = ((Integer)nowFightStagePair.first).intValue();
/* 1235 */     GrcInterface.getCrossBattleKnockOutInfo(activityCfgId, knockOutType, fightZoneId, nowKnockOutStage, knockOutCfg.need_team_size, knockOutCfg.stage_name_list.size(), knockOutCfg.fight_times_every_stage, new OctetsStream().marshal(getKnockOutContext));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public static void onNotifyCrossBattleFinalBulletin(int physicsZoneId, SBulletinInfo sBulletinInfo)
/*      */   {
/* 1242 */     if (GameServerInfoManager.isRoamServer())
/*      */     {
/* 1244 */       return;
/*      */     }
/*      */     
/* 1247 */     if (GameServerInfoManager.isValidZone(physicsZoneId))
/*      */     {
/* 1249 */       return;
/*      */     }
/*      */     
/* 1252 */     mzm.gsp.bulletin.main.BulletinInterface.sendBulletin(sBulletinInfo);
/*      */     
/* 1254 */     if (sBulletinInfo.bulletintype == 44)
/*      */     {
/* 1256 */       String rank = (String)sBulletinInfo.params.get(Integer.valueOf(31));
/* 1257 */       if ((rank != null) && (rank.equals("1")))
/*      */       {
/* 1259 */         KnockOutFinalChampionBornArg arg = new KnockOutFinalChampionBornArg();
/* 1260 */         TriggerEventsManger.getInstance().triggerEvent(new KnockOutFinalChampionBorn(), arg);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public static long getKnockOutCanGetInfoTime(int activityCfgId, int knockOutType)
/*      */   {
/* 1267 */     KnockOutHandler knockOutHandler = CrossBattleKnockoutManager.getKnockOutHandler(knockOutType);
/* 1268 */     if (knockOutHandler == null)
/*      */     {
/* 1270 */       return Long.MAX_VALUE;
/*      */     }
/*      */     
/* 1273 */     return knockOutHandler.getCanGetKnockOutInfoTime(activityCfgId);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean isAleardyHasRoundResult(int activityCfgId, int knockOutType, int fightZoneId, int fightStage, int fightIndexId)
/*      */   {
/* 1282 */     long globalActivityCfgId = GameServerInfoManager.toGlobalId(activityCfgId);
/* 1283 */     CrossBattleKnockoutActivityInfo xCrossBattleKnockoutActivityInfo = Cross_battle_knockout.get(Long.valueOf(globalActivityCfgId));
/* 1284 */     if (xCrossBattleKnockoutActivityInfo == null)
/*      */     {
/* 1286 */       return false;
/*      */     }
/*      */     
/* 1289 */     CrossBattleKnockoutInfo xCrossBattleKnockoutInfo = (CrossBattleKnockoutInfo)xCrossBattleKnockoutActivityInfo.getKnockout_info_map().get(Integer.valueOf(knockOutType));
/*      */     
/* 1291 */     if (xCrossBattleKnockoutInfo == null)
/*      */     {
/* 1293 */       return false;
/*      */     }
/*      */     
/* 1296 */     FightZoneInfo xFightZoneInfo = (FightZoneInfo)xCrossBattleKnockoutInfo.getFight_zone_info_map().get(Integer.valueOf(fightZoneId));
/* 1297 */     if (xFightZoneInfo == null)
/*      */     {
/* 1299 */       return false;
/*      */     }
/*      */     
/* 1302 */     Map<Integer, FightStageInfo> xFightStageInfoMap = xFightZoneInfo.getFight_stage_info_map();
/*      */     
/* 1304 */     FightStageInfo xFightStageInfo = (FightStageInfo)xFightStageInfoMap.get(Integer.valueOf(fightStage));
/* 1305 */     if (xFightStageInfo == null)
/*      */     {
/* 1307 */       return false;
/*      */     }
/*      */     
/* 1310 */     FightAgainstInfo xFightAgainstInfo = (FightAgainstInfo)xFightStageInfo.getFight_against_info_map().get(Integer.valueOf(fightIndexId));
/* 1311 */     if (xFightAgainstInfo == null)
/*      */     {
/* 1313 */       return false;
/*      */     }
/*      */     
/* 1316 */     SCrossBattleKnockOutCfg sCrossBattleKnockOutCfg = SCrossBattleKnockOutCfg.get(activityCfgId);
/* 1317 */     if (sCrossBattleKnockOutCfg == null)
/*      */     {
/* 1319 */       return false;
/*      */     }
/*      */     
/* 1322 */     KnockOutCfg knockOutCfg = (KnockOutCfg)sCrossBattleKnockOutCfg.knockOutTypeCfgMap.get(Integer.valueOf(knockOutType));
/* 1323 */     if (knockOutCfg == null)
/*      */     {
/* 1325 */       return false;
/*      */     }
/*      */     
/* 1328 */     if (fightStage % knockOutCfg.fight_times_every_stage == 0)
/*      */     {
/* 1330 */       return false;
/*      */     }
/*      */     
/* 1333 */     Pair<Long, Pair<Integer, Integer>> winCorpsPair = CrossBattleKnockoutManager.getWinCorpsId(xFightStageInfoMap, xFightAgainstInfo.getA_corps_id(), xFightAgainstInfo.getB_corps_id(), fightStage, fightIndexId, knockOutCfg.fight_times_every_stage);
/*      */     
/*      */ 
/*      */ 
/* 1337 */     if (((Long)winCorpsPair.first).longValue() != -1L)
/*      */     {
/* 1339 */       return true;
/*      */     }
/*      */     
/* 1342 */     return false;
/*      */   }
/*      */   
/*      */   public static int refreshKnockOutData(int activityCfgId, int knockOutType, int fightZoneId)
/*      */   {
/* 1347 */     return CrossBattleKnockoutManager.refreshKnockOutData(activityCfgId, knockOutType, fightZoneId);
/*      */   }
/*      */   
/*      */ 
/*      */   public static int restartKnockOut(int activityCfgId, int knockOutType, int restartFightZoneId, int restartFightIndexId, long restartPrepareWorldBeginTime)
/*      */   {
/* 1353 */     return CrossBattleKnockoutManager.restartKnockOut(activityCfgId, knockOutType, restartFightZoneId, restartFightIndexId, restartPrepareWorldBeginTime);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public static void notifyKnockOutQualificationCorpsIdSet(long roleId, long corpsId, int knockOutType, Set<Long> nowQualifiactionCorpsIdSet)
/*      */   {
/* 1360 */     PNotifyKnockOutQualifiaction pNotifyKnockOutQualifiaction = new PNotifyKnockOutQualifiaction(roleId, corpsId, knockOutType, nowQualifiactionCorpsIdSet);
/*      */     
/*      */ 
/* 1363 */     pNotifyKnockOutQualifiaction.call();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void getCrossBattleChampionCorpsInfo()
/*      */   {
/* 1371 */     int currentCrossBattleSession = CrossBattleConsts.getInstance().cross_battle_session_num;
/*      */     
/* 1373 */     new PQueryCrossBattleFinalChampion(currentCrossBattleSession).execute();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void onActivityEnd(int activityCfgId)
/*      */   {
/* 1381 */     new POnCrossBattleActivityEnd(activityCfgId).execute();
/*      */   }
/*      */   
/*      */   public static void initFinalServerAward()
/*      */   {
/* 1386 */     for (SCrossBattleFinalCfg sCrossBattleFinalCfg : SCrossBattleFinalCfg.getAll().values())
/*      */     {
/* 1388 */       int activityCfgId = sCrossBattleFinalCfg.activity_cfg_id;
/*      */       
/* 1390 */       new PTryStartFinalAwardObserver(activityCfgId).execute();
/*      */     }
/*      */   }
/*      */   
/*      */   public static boolean isFinalServerAwardBuff(int buffId)
/*      */   {
/* 1396 */     SCrossBattleFinalBuffCfg sCrossBattleFinalBuffCfg = (SCrossBattleFinalBuffCfg)SCrossBattleFinalBuffCfg.getAll().values().iterator().next();
/*      */     
/* 1398 */     return sCrossBattleFinalBuffCfg.buff_id_set.contains(Integer.valueOf(buffId));
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
/*      */   public static boolean isCrossBattleServerBuffSwitchOpen(long roleId)
/*      */   {
/* 1413 */     return CrossBattleKnockoutManager.isCrossBattleServerBuffSwitchOpen(roleId);
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\knockout\CrossBattleKnockoutInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
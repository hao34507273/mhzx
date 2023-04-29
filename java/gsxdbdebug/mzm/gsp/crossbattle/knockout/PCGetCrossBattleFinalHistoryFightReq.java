/*     */ package mzm.gsp.crossbattle.knockout;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.TreeMap;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.crossbattle.CorpsInfo;
/*     */ import mzm.gsp.crossbattle.GetKnockOutContext;
/*     */ import mzm.gsp.crossbattle.SCrossBattleHistoryNormalRes;
/*     */ import mzm.gsp.crossbattle.SGetCrossBattleFinalHistoryInfo;
/*     */ import mzm.gsp.crossbattle.SGetCrossBattleTopThreeInfo;
/*     */ import mzm.gsp.crossbattle.SNotifyFinalResultOut;
/*     */ import mzm.gsp.crossbattle.confbean.CrossBattleConsts;
/*     */ import mzm.gsp.crossbattle.confbean.KnockOutCfg;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattleHistoryCfg;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattleKnockOutCfg;
/*     */ import mzm.gsp.crossbattle.main.CrossBattleOneByOneManager;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.Pair;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.CrossBattleKnockoutActivityInfo;
/*     */ import xbean.CrossBattleKnockoutInfo;
/*     */ import xbean.FightCorpsInfo;
/*     */ import xbean.FightStageInfo;
/*     */ import xbean.FightZoneInfo;
/*     */ import xtable.Cross_battle_knockout;
/*     */ 
/*     */ public class PCGetCrossBattleFinalHistoryFightReq extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int session;
/*     */   private final int req_type;
/*     */   private int activityCfgId;
/*     */   
/*     */   public PCGetCrossBattleFinalHistoryFightReq(long roleId, int session, int type)
/*     */   {
/*  44 */     this.roleId = roleId;
/*  45 */     this.session = session;
/*  46 */     this.req_type = type;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  52 */     if (!CrossBattleKnockoutManager.isCrossBattleHistorySwitchOpen(this.roleId))
/*     */     {
/*  54 */       onGetCrossBattleFinalHistoryFightFailed(2);
/*  55 */       return false;
/*     */     }
/*     */     
/*  58 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 1555, false, true))
/*     */     {
/*  60 */       onGetCrossBattleFinalHistoryFightFailed(-1);
/*  61 */       return false;
/*     */     }
/*     */     
/*  64 */     if (this.session > CrossBattleConsts.getInstance().cross_battle_session_num)
/*     */     {
/*  66 */       Map<String, Object> extraMap = new HashMap();
/*  67 */       extraMap.put("current_session", Integer.valueOf(CrossBattleConsts.getInstance().cross_battle_session_num));
/*     */       
/*  69 */       onGetCrossBattleFinalHistoryFightFailed(8, extraMap);
/*  70 */       return false;
/*     */     }
/*     */     
/*  73 */     SCrossBattleHistoryCfg sCrossBattleHistoryCfg = SCrossBattleHistoryCfg.get(this.session);
/*  74 */     if (sCrossBattleHistoryCfg == null)
/*     */     {
/*  76 */       onGetCrossBattleFinalHistoryFightFailed(9);
/*  77 */       return false;
/*     */     }
/*     */     
/*  80 */     this.activityCfgId = sCrossBattleHistoryCfg.activity_cfg_id;
/*  81 */     SCrossBattleKnockOutCfg sCrossBattleKnockOutCfg = SCrossBattleKnockOutCfg.get(this.activityCfgId);
/*  82 */     if (sCrossBattleKnockOutCfg == null)
/*     */     {
/*  84 */       onGetCrossBattleFinalHistoryFightFailed(6);
/*  85 */       return false;
/*     */     }
/*     */     
/*  88 */     KnockOutCfg knockOutCfg = (KnockOutCfg)sCrossBattleKnockOutCfg.knockOutTypeCfgMap.get(Integer.valueOf(2));
/*  89 */     if (knockOutCfg == null)
/*     */     {
/*  91 */       onGetCrossBattleFinalHistoryFightFailed(7);
/*  92 */       return false;
/*     */     }
/*     */     
/*  95 */     long globalActivityCfgId = GameServerInfoManager.toGlobalId(this.activityCfgId);
/*     */     
/*  97 */     CrossBattleKnockoutActivityInfo xCrossBattleKnockoutActivityInfo = Cross_battle_knockout.get(Long.valueOf(globalActivityCfgId));
/*     */     
/*  99 */     CrossBattleKnockoutInfo xCrossBattleKnockoutInfo = null;
/* 100 */     if (xCrossBattleKnockoutActivityInfo != null)
/*     */     {
/* 102 */       xCrossBattleKnockoutInfo = (CrossBattleKnockoutInfo)xCrossBattleKnockoutActivityInfo.getKnockout_info_map().get(Integer.valueOf(2));
/*     */     }
/*     */     
/* 105 */     FightZoneInfo xFightZoneInfo = null;
/* 106 */     if (xCrossBattleKnockoutInfo != null)
/*     */     {
/* 108 */       xFightZoneInfo = (FightZoneInfo)xCrossBattleKnockoutInfo.getFight_zone_info_map().get(Integer.valueOf(CrossBattleKnockoutManager.GLOBAL_FIGHT_ZONE));
/*     */     }
/*     */     
/* 111 */     if ((xCrossBattleKnockoutActivityInfo == null) || (xCrossBattleKnockoutInfo == null) || (xFightZoneInfo == null))
/*     */     {
/* 113 */       KnockOutHandler knockOutHandler = CrossBattleKnockoutManager.getKnockOutHandler(2);
/* 114 */       if (knockOutHandler == null)
/*     */       {
/* 116 */         onGetCrossBattleFinalHistoryFightFailed(13);
/* 117 */         return false;
/*     */       }
/*     */       
/* 120 */       long canGetKnockOutInfoTime = knockOutHandler.getCanGetKnockOutInfoTime(this.activityCfgId);
/* 121 */       if (canGetKnockOutInfoTime > mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis())
/*     */       {
/*     */ 
/* 124 */         onGetCrossBattleFinalHistoryFightFailed(15);
/* 125 */         return false;
/*     */       }
/* 127 */       mzm.gsp.crossbattle.GetKnockOutContext_GetFinalHistoryFightInfo context = new mzm.gsp.crossbattle.GetKnockOutContext_GetFinalHistoryFightInfo(this.session, this.roleId, this.req_type);
/*     */       
/*     */ 
/*     */ 
/* 131 */       OctetsStream octetsStream = new OctetsStream();
/* 132 */       octetsStream.marshal(context);
/*     */       
/* 134 */       GetKnockOutContext getKnockOutContext = new GetKnockOutContext();
/* 135 */       getKnockOutContext.oper_type = 11;
/* 136 */       getKnockOutContext.content = octetsStream;
/*     */       
/* 138 */       Pair<Integer, Boolean> nowFightStagePair = CrossBattleKnockoutInterface.getNowFightStage(this.activityCfgId, 2);
/*     */       
/* 140 */       if (nowFightStagePair == null)
/*     */       {
/* 142 */         onGetCrossBattleFinalHistoryFightFailed(7);
/* 143 */         return false;
/*     */       }
/*     */       
/* 146 */       int nowKnockOutStage = ((Integer)nowFightStagePair.first).intValue();
/* 147 */       boolean isSendSuccess = mzm.gsp.grc.main.GrcInterface.getCrossBattleKnockOutInfo(this.activityCfgId, 2, CrossBattleKnockoutManager.GLOBAL_FIGHT_ZONE, nowKnockOutStage, knockOutCfg.need_team_size, knockOutCfg.stage_name_list.size(), knockOutCfg.fight_times_every_stage, new OctetsStream().marshal(getKnockOutContext));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 152 */       if (!isSendSuccess)
/*     */       {
/* 154 */         onGetCrossBattleFinalHistoryFightFailed(11);
/*     */       }
/* 156 */       return isSendSuccess;
/*     */     }
/*     */     
/* 159 */     CrossBattleOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(this.activityCfgId), new PNotifyCrossBattleFinalHistoryFight(this.roleId, this.session, this.req_type));
/*     */     
/*     */ 
/* 162 */     StringBuilder sb = new StringBuilder();
/* 163 */     sb.append("[crossbattle_knockout]PCGetCrossBattleFinalHistoryFightReq.processImp@get cross battle final history fight req success");
/* 164 */     sb.append("|role_id=").append(this.roleId);
/* 165 */     sb.append("|session=").append(this.session);
/*     */     
/* 167 */     GameServer.logger().info(sb.toString());
/*     */     
/* 169 */     return true;
/*     */   }
/*     */   
/*     */   private void onGetCrossBattleFinalHistoryFightFailed(int ret)
/*     */   {
/* 174 */     onGetCrossBattleFinalHistoryFightFailed(ret, null);
/*     */   }
/*     */   
/*     */   private void onGetCrossBattleFinalHistoryFightFailed(int ret, Map<String, Object> extraMap)
/*     */   {
/* 179 */     StringBuilder sb = new StringBuilder();
/* 180 */     sb.append("[crossbattle_knockout]PCGetCrossBattleFinalHistoryFightReq.processImp@error");
/* 181 */     sb.append("|ret=").append(ret);
/* 182 */     sb.append("|role_id=").append(this.roleId);
/* 183 */     sb.append("|activity_cfg_id=").append(this.activityCfgId);
/* 184 */     sb.append("|session=").append(this.session);
/*     */     
/* 186 */     if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */     {
/* 188 */       for (Map.Entry<String, Object> entry : extraMap.entrySet())
/*     */       {
/* 190 */         sb.append("|").append((String)entry.getKey()).append("=").append(entry.getValue());
/*     */       }
/*     */     }
/*     */     
/* 194 */     GameServer.logger().error(sb.toString());
/* 195 */     if (this.req_type != 3)
/*     */     {
/* 197 */       SCrossBattleHistoryNormalRes sCrossBattleHistoryNormalRes = new SCrossBattleHistoryNormalRes();
/* 198 */       sCrossBattleHistoryNormalRes.ret = ret;
/*     */       
/* 200 */       OnlineManager.getInstance().sendAtOnce(this.roleId, sCrossBattleHistoryNormalRes);
/*     */     }
/*     */   }
/*     */   
/*     */   public static class PNotifyCrossBattleFinalHistoryFight
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final long roleId;
/*     */     private final int session;
/*     */     private final int reqType;
/*     */     private int activityCfgId;
/*     */     
/*     */     public PNotifyCrossBattleFinalHistoryFight(long roleId, int session, int reqType)
/*     */     {
/* 214 */       this.roleId = roleId;
/* 215 */       this.session = session;
/* 216 */       this.reqType = reqType;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 222 */       if (!CrossBattleKnockoutManager.isCrossBattleHistorySwitchOpen(this.roleId))
/*     */       {
/* 224 */         onNotifyFailed(2);
/* 225 */         return false;
/*     */       }
/*     */       
/* 228 */       if (this.session > CrossBattleConsts.getInstance().cross_battle_session_num)
/*     */       {
/* 230 */         Map<String, Object> extraMap = new HashMap();
/* 231 */         extraMap.put("current_session", Integer.valueOf(CrossBattleConsts.getInstance().cross_battle_session_num));
/*     */         
/* 233 */         onNotifyFailed(8, extraMap);
/* 234 */         return false;
/*     */       }
/* 236 */       SCrossBattleHistoryCfg sCrossBattleHistoryCfg = SCrossBattleHistoryCfg.get(this.session);
/* 237 */       if (sCrossBattleHistoryCfg == null)
/*     */       {
/* 239 */         return false;
/*     */       }
/*     */       
/* 242 */       this.activityCfgId = sCrossBattleHistoryCfg.activity_cfg_id;
/*     */       
/* 244 */       SCrossBattleKnockOutCfg sCrossBattleKnockOutCfg = SCrossBattleKnockOutCfg.get(this.activityCfgId);
/* 245 */       if (sCrossBattleKnockOutCfg == null)
/*     */       {
/* 247 */         onNotifyFailed(6);
/* 248 */         return false;
/*     */       }
/*     */       
/* 251 */       KnockOutCfg knockOutCfg = (KnockOutCfg)sCrossBattleKnockOutCfg.knockOutTypeCfgMap.get(Integer.valueOf(2));
/* 252 */       if (knockOutCfg == null)
/*     */       {
/* 254 */         onNotifyFailed(7);
/* 255 */         return false;
/*     */       }
/*     */       
/* 258 */       this.activityCfgId = sCrossBattleHistoryCfg.activity_cfg_id;
/*     */       
/* 260 */       String userId = mzm.gsp.role.main.RoleInterface.getUserId(this.roleId);
/* 261 */       lock(xdb.Lockeys.get(xtable.User.getTable(), userId));
/*     */       
/* 263 */       long globalActivityCfgid = GameServerInfoManager.toGlobalId(this.activityCfgId);
/* 264 */       CrossBattleKnockoutActivityInfo xCrossBattleKnockoutActivityInfo = Cross_battle_knockout.get(Long.valueOf(globalActivityCfgid));
/*     */       
/* 266 */       if (xCrossBattleKnockoutActivityInfo == null)
/*     */       {
/* 268 */         onNotifyFailed(3);
/* 269 */         return false;
/*     */       }
/*     */       
/* 272 */       CrossBattleKnockoutInfo xCrossBattleKnockoutInfo = (CrossBattleKnockoutInfo)xCrossBattleKnockoutActivityInfo.getKnockout_info_map().get(Integer.valueOf(2));
/*     */       
/* 274 */       if (xCrossBattleKnockoutInfo == null)
/*     */       {
/* 276 */         onNotifyFailed(4);
/* 277 */         return false;
/*     */       }
/*     */       
/* 280 */       FightZoneInfo xFightZoneInfo = (FightZoneInfo)xCrossBattleKnockoutInfo.getFight_zone_info_map().get(Integer.valueOf(CrossBattleKnockoutManager.GLOBAL_FIGHT_ZONE));
/*     */       
/* 282 */       if (xFightZoneInfo == null)
/*     */       {
/* 284 */         onNotifyFailed(5);
/* 285 */         return false;
/*     */       }
/*     */       
/* 288 */       Pair<Integer, Boolean> nowFightStagePair = CrossBattleKnockoutInterface.getNowFightStage(this.activityCfgId, 2);
/*     */       
/* 290 */       if (nowFightStagePair == null)
/*     */       {
/* 292 */         onNotifyFailed(7);
/* 293 */         return false;
/*     */       }
/*     */       
/* 296 */       int nowFightStage = ((Integer)nowFightStagePair.first).intValue();
/*     */       
/* 298 */       int championFirstStage = knockOutCfg.stage_time_point_cfg_id_list.size() - knockOutCfg.fight_times_every_stage + 1;
/*     */       
/* 300 */       if (((Integer)nowFightStagePair.first).intValue() < championFirstStage)
/*     */       {
/* 302 */         onNotifyFailed(16);
/* 303 */         return false;
/*     */       }
/*     */       
/* 306 */       FightStageInfo xFightStageInfo = (FightStageInfo)xFightZoneInfo.getFight_stage_info_map().get(Integer.valueOf(championFirstStage));
/* 307 */       if (xFightStageInfo == null)
/*     */       {
/* 309 */         onNotifyFailed(18);
/* 310 */         return false;
/*     */       }
/*     */       
/* 313 */       xbean.FightAgainstInfo xFightAgainstInfo = (xbean.FightAgainstInfo)xFightStageInfo.getFight_against_info_map().get(Integer.valueOf(1));
/* 314 */       if (xFightAgainstInfo == null)
/*     */       {
/* 316 */         onNotifyFailed(19);
/* 317 */         return false;
/*     */       }
/*     */       
/* 320 */       Pair<Long, Pair<Integer, Integer>> winPair = CrossBattleKnockoutManager.getWinCorpsId(xFightZoneInfo.getFight_stage_info_map(), xFightAgainstInfo.getA_corps_id(), xFightAgainstInfo.getB_corps_id(), nowFightStage, 1, knockOutCfg.fight_times_every_stage);
/*     */       
/*     */ 
/* 323 */       boolean isByeWin = CrossBattleKnockoutManager.isByeWin(xFightAgainstInfo);
/* 324 */       boolean isAllByeWin = CrossBattleKnockoutManager.isAllBye(xFightAgainstInfo);
/* 325 */       if ((((Long)winPair.first).longValue() == -1L) && (nowFightStage % knockOutCfg.fight_times_every_stage != 0) && (!isByeWin) && (!isAllByeWin))
/*     */       {
/* 327 */         onNotifyFailed(17);
/* 328 */         return false;
/*     */       }
/*     */       
/*     */ 
/* 332 */       if (this.reqType == 1)
/*     */       {
/* 334 */         notifyFinalHistoryFightInfo(xFightZoneInfo);
/*     */       }
/* 336 */       else if (this.reqType == 2)
/*     */       {
/* 338 */         notifyFinalHistoryTopThreeInfo(xFightZoneInfo, xFightAgainstInfo, winPair, knockOutCfg);
/*     */       }
/* 340 */       else if (this.reqType == 3)
/*     */       {
/* 342 */         SNotifyFinalResultOut sNotifyFinalResultOut = new SNotifyFinalResultOut();
/* 343 */         OnlineManager.getInstance().send(this.roleId, sNotifyFinalResultOut);
/*     */       }
/*     */       
/* 346 */       StringBuilder sb = new StringBuilder();
/* 347 */       sb.append("[crossbattle_knockout]PNotifyCrossBattleFinalHistoryFight.processImp@get success");
/* 348 */       sb.append("|role_id=").append(this.roleId);
/* 349 */       sb.append("|session=").append(this.session);
/* 350 */       sb.append("|activity_cfg_id=").append(this.activityCfgId);
/* 351 */       sb.append("|req_type=").append(this.reqType);
/*     */       
/* 353 */       GameServer.logger().info(sb.toString());
/*     */       
/* 355 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     private void notifyFinalHistoryTopThreeInfo(FightZoneInfo xFightZoneInfo, xbean.FightAgainstInfo xFightAgainstInfo, Pair<Long, Pair<Integer, Integer>> winPair, KnockOutCfg knockOutCfg)
/*     */       throws UnsupportedEncodingException
/*     */     {
/* 375 */       Map<Long, FightCorpsInfo> xFightCorpsInfoMap = xFightZoneInfo.getFight_corps_info_map();
/*     */       
/* 377 */       SGetCrossBattleTopThreeInfo sGetCrossBattleTopThreeInfo = new SGetCrossBattleTopThreeInfo();
/* 378 */       sGetCrossBattleTopThreeInfo.session = this.session;
/*     */       
/*     */ 
/* 381 */       long xChampionFightCorpsIdA = xFightAgainstInfo.getA_corps_id();
/*     */       
/* 383 */       long xChampionFightCorpsIdB = xFightAgainstInfo.getB_corps_id();
/*     */       
/* 385 */       CorpsInfo championCorpsIdACorpsInfo = new CorpsInfo();
/* 386 */       FightCorpsInfo xFightChampionCorpsAInfo = (FightCorpsInfo)xFightCorpsInfoMap.get(Long.valueOf(xChampionFightCorpsIdA));
/* 387 */       if (xFightChampionCorpsAInfo != null)
/*     */       {
/* 389 */         championCorpsIdACorpsInfo.zone_id = xFightChampionCorpsAInfo.getCorps_zone_id();
/* 390 */         championCorpsIdACorpsInfo.corps_id = xFightChampionCorpsAInfo.getCorps_id();
/* 391 */         championCorpsIdACorpsInfo.corps_icon = xFightChampionCorpsAInfo.getCorps_badge_id();
/* 392 */         championCorpsIdACorpsInfo.corps_name.setString(xFightChampionCorpsAInfo.getCorps_name(), "UTF-8");
/*     */       }
/*     */       
/* 395 */       CorpsInfo championCorpsIdBCorpsInfo = new CorpsInfo();
/* 396 */       FightCorpsInfo xFightChampionCorpsBInfo = (FightCorpsInfo)xFightCorpsInfoMap.get(Long.valueOf(xChampionFightCorpsIdB));
/* 397 */       if (xFightChampionCorpsBInfo != null)
/*     */       {
/* 399 */         championCorpsIdBCorpsInfo.zone_id = xFightChampionCorpsBInfo.getCorps_zone_id();
/* 400 */         championCorpsIdBCorpsInfo.corps_id = xFightChampionCorpsBInfo.getCorps_id();
/* 401 */         championCorpsIdBCorpsInfo.corps_icon = xFightChampionCorpsBInfo.getCorps_badge_id();
/* 402 */         championCorpsIdBCorpsInfo.corps_name.setString(xFightChampionCorpsBInfo.getCorps_name(), "UTF-8");
/*     */       }
/*     */       
/* 405 */       boolean championIsByeWin = CrossBattleKnockoutManager.isByeWin(xFightAgainstInfo);
/*     */       
/*     */ 
/* 408 */       if ((((Long)winPair.first).longValue() == -1L) && (!championIsByeWin))
/*     */       {
/* 410 */         if (xChampionFightCorpsIdA > 0L)
/*     */         {
/* 412 */           sGetCrossBattleTopThreeInfo.second_place_corps.add(championCorpsIdACorpsInfo);
/*     */         }
/*     */         
/* 415 */         if (xChampionFightCorpsIdB > 0L)
/*     */         {
/* 417 */           sGetCrossBattleTopThreeInfo.second_place_corps.add(championCorpsIdBCorpsInfo);
/*     */         }
/*     */         
/*     */ 
/*     */       }
/* 422 */       else if ((((Long)winPair.first).longValue() == xChampionFightCorpsIdA) || ((championIsByeWin) && (xFightAgainstInfo.getCal_fight_result() == FightResultEnum.A_BYE_WIN.fightResult)))
/*     */       {
/*     */ 
/* 425 */         if (xChampionFightCorpsIdA > 0L)
/*     */         {
/* 427 */           sGetCrossBattleTopThreeInfo.champion_corps.add(championCorpsIdACorpsInfo);
/*     */         }
/* 429 */         if (xChampionFightCorpsIdB > 0L)
/*     */         {
/* 431 */           sGetCrossBattleTopThreeInfo.second_place_corps.add(championCorpsIdBCorpsInfo);
/*     */         }
/*     */       }
/*     */       else
/*     */       {
/* 436 */         if (xChampionFightCorpsIdB > 0L)
/*     */         {
/* 438 */           sGetCrossBattleTopThreeInfo.champion_corps.add(championCorpsIdBCorpsInfo);
/*     */         }
/*     */         
/* 441 */         if (xChampionFightCorpsIdA > 0L)
/*     */         {
/* 443 */           sGetCrossBattleTopThreeInfo.second_place_corps.add(championCorpsIdACorpsInfo);
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 448 */       int thirdPlaceLastStage = knockOutCfg.stage_time_point_cfg_id_list.size() - knockOutCfg.fight_times_every_stage;
/*     */       
/* 450 */       FightStageInfo xThirdPlaceFightStageInfo = (FightStageInfo)xFightZoneInfo.getFight_stage_info_map().get(Integer.valueOf(thirdPlaceLastStage));
/*     */       
/* 452 */       if (xThirdPlaceFightStageInfo == null)
/*     */       {
/* 454 */         onNotifyFailed(20);
/* 455 */         return;
/*     */       }
/*     */       
/* 458 */       xbean.FightAgainstInfo xThirdPlaceFightAgainstInfo = (xbean.FightAgainstInfo)xThirdPlaceFightStageInfo.getFight_against_info_map().get(Integer.valueOf(1));
/*     */       
/* 460 */       if (xThirdPlaceFightAgainstInfo == null)
/*     */       {
/* 462 */         onNotifyFailed(21);
/* 463 */         return;
/*     */       }
/*     */       
/* 466 */       long thirdPlaceAgainstACorpsId = xThirdPlaceFightAgainstInfo.getA_corps_id();
/* 467 */       long thirdPlaceAgainstBCorpsId = xThirdPlaceFightAgainstInfo.getB_corps_id();
/* 468 */       Pair<Long, Pair<Integer, Integer>> thirdPlaceWinPair = CrossBattleKnockoutManager.getWinCorpsId(xFightZoneInfo.getFight_stage_info_map(), thirdPlaceAgainstACorpsId, thirdPlaceAgainstBCorpsId, thirdPlaceLastStage, 1, knockOutCfg.fight_times_every_stage);
/*     */       
/*     */ 
/*     */ 
/* 472 */       if (((Long)thirdPlaceWinPair.first).longValue() != -1L)
/*     */       {
/* 474 */         FightCorpsInfo xFightThirdPlaceCorpsAInfo = (FightCorpsInfo)xFightCorpsInfoMap.get(thirdPlaceWinPair.first);
/*     */         
/* 476 */         CorpsInfo thirdPlaceCorpsAInfo = new CorpsInfo();
/* 477 */         thirdPlaceCorpsAInfo.zone_id = xFightThirdPlaceCorpsAInfo.getCorps_zone_id();
/* 478 */         thirdPlaceCorpsAInfo.corps_id = xFightThirdPlaceCorpsAInfo.getCorps_id();
/* 479 */         thirdPlaceCorpsAInfo.corps_icon = xFightThirdPlaceCorpsAInfo.getCorps_badge_id();
/* 480 */         thirdPlaceCorpsAInfo.corps_name.setString(xFightThirdPlaceCorpsAInfo.getCorps_name(), "UTF-8");
/*     */         
/* 482 */         sGetCrossBattleTopThreeInfo.third_place_corps.add(thirdPlaceCorpsAInfo);
/*     */       }
/*     */       
/* 485 */       OnlineManager.getInstance().send(this.roleId, sGetCrossBattleTopThreeInfo);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     private void notifyFinalHistoryFightInfo(FightZoneInfo xFightZoneInfo)
/*     */       throws UnsupportedEncodingException
/*     */     {
/* 496 */       SGetCrossBattleFinalHistoryInfo sFinalHistoryInfo = new SGetCrossBattleFinalHistoryInfo();
/* 497 */       sFinalHistoryInfo.session = this.session;
/* 498 */       Map<Long, FightCorpsInfo> xFightCorpsInfoMap = xFightZoneInfo.getFight_corps_info_map();
/*     */       
/* 500 */       for (Map.Entry<Long, FightCorpsInfo> entry : xFightCorpsInfoMap.entrySet())
/*     */       {
/* 502 */         FightCorpsInfo xFightCorpsInfo = (FightCorpsInfo)entry.getValue();
/*     */         
/* 504 */         CorpsInfo corpsInfo = new CorpsInfo();
/* 505 */         corpsInfo.zone_id = xFightCorpsInfo.getCorps_zone_id();
/* 506 */         corpsInfo.corps_id = xFightCorpsInfo.getCorps_id();
/* 507 */         corpsInfo.corps_icon = xFightCorpsInfo.getCorps_badge_id();
/* 508 */         corpsInfo.corps_name.setString(xFightCorpsInfo.getCorps_name(), "UTF-8");
/*     */         
/* 510 */         sFinalHistoryInfo.final_fight_corps_map.put(entry.getKey(), corpsInfo);
/*     */       }
/*     */       
/* 513 */       for (Map.Entry<Integer, FightStageInfo> stage2FightInfoEntry : xFightZoneInfo.getFight_stage_info_map().entrySet())
/*     */       {
/* 515 */         FightStageInfo xFightStageInfo = (FightStageInfo)stage2FightInfoEntry.getValue();
/* 516 */         int xStage = ((Integer)stage2FightInfoEntry.getKey()).intValue();
/*     */         
/* 518 */         TreeMap<Integer, mzm.gsp.crossbattle.FightAgainstInfo> knockOutFightInfoMap = new TreeMap();
/* 519 */         for (Map.Entry<Integer, xbean.FightAgainstInfo> indexId2FightInfoEntry : xFightStageInfo.getFight_against_info_map().entrySet())
/*     */         {
/* 521 */           int xfightIndexId = ((Integer)indexId2FightInfoEntry.getKey()).intValue();
/* 522 */           xbean.FightAgainstInfo xFightAgainstInfo = (xbean.FightAgainstInfo)indexId2FightInfoEntry.getValue();
/*     */           
/* 524 */           mzm.gsp.crossbattle.FightAgainstInfo fightAgainstInfo = new mzm.gsp.crossbattle.FightAgainstInfo();
/* 525 */           fightAgainstInfo.corps_a_id = xFightAgainstInfo.getA_corps_id();
/* 526 */           fightAgainstInfo.corps_b_id = xFightAgainstInfo.getB_corps_id();
/*     */           
/* 528 */           fightAgainstInfo.corps_a_state = xFightAgainstInfo.getA_corps_id_result();
/* 529 */           fightAgainstInfo.corps_b_state = xFightAgainstInfo.getB_corps_id_result();
/* 530 */           fightAgainstInfo.cal_fight_result = xFightAgainstInfo.getCal_fight_result();
/* 531 */           fightAgainstInfo.record_id = xFightAgainstInfo.getRecord_id();
/*     */           
/* 533 */           knockOutFightInfoMap.put(Integer.valueOf(xfightIndexId), fightAgainstInfo);
/*     */         }
/* 535 */         ArrayList<mzm.gsp.crossbattle.FightAgainstInfo> knockOutFightInfoList = new ArrayList();
/* 536 */         knockOutFightInfoList.addAll(knockOutFightInfoMap.values());
/*     */         
/* 538 */         sFinalHistoryInfo.final_stage_fight_info_map.put(Integer.valueOf(xStage), new mzm.gsp.crossbattle.KnockOutStageFightInfo(knockOutFightInfoList));
/*     */       }
/*     */       
/*     */ 
/* 542 */       OnlineManager.getInstance().send(this.roleId, sFinalHistoryInfo);
/*     */     }
/*     */     
/*     */     private void onNotifyFailed(int ret)
/*     */     {
/* 547 */       onNotifyFailed(ret, null);
/*     */     }
/*     */     
/*     */     private void onNotifyFailed(int ret, Map<String, Object> extraMap)
/*     */     {
/* 552 */       StringBuilder sb = new StringBuilder();
/* 553 */       sb.append("[crossbattle_knockout]PNotifyCrossBattleFinalHistoryFight.processImp@error");
/* 554 */       sb.append("|ret=").append(ret);
/* 555 */       sb.append("|role_id=").append(this.roleId);
/* 556 */       sb.append("|session=").append(this.session);
/* 557 */       sb.append("|activity_cfg_id=").append(this.activityCfgId);
/* 558 */       sb.append("|req_type=").append(this.reqType);
/*     */       
/* 560 */       if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */       {
/* 562 */         for (Map.Entry<String, Object> entry : extraMap.entrySet())
/*     */         {
/* 564 */           sb.append("|").append((String)entry.getKey()).append("=").append(entry.getValue());
/*     */         }
/*     */       }
/*     */       
/* 568 */       GameServer.logger().error(sb.toString());
/*     */       
/* 570 */       if (this.reqType != 3)
/*     */       {
/* 572 */         SCrossBattleHistoryNormalRes sCrossBattleHistoryNormalRes = new SCrossBattleHistoryNormalRes();
/* 573 */         sCrossBattleHistoryNormalRes.ret = ret;
/*     */         
/* 575 */         OnlineManager.getInstance().sendAtOnce(this.roleId, sCrossBattleHistoryNormalRes);
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\knockout\PCGetCrossBattleFinalHistoryFightReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
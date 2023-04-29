/*     */ package mzm.gsp.crossbattle.knockout;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.corps.main.CorpsInterface;
/*     */ import mzm.gsp.crossbattle.confbean.KnockOutCfg;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattleKnockOutCfg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.Pair;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.CrossBattleKnockoutActivityInfo;
/*     */ import xbean.CrossBattleKnockoutInfo;
/*     */ import xbean.CrossBattleKnockoutLocalRankInfo;
/*     */ import xbean.FightAgainstInfo;
/*     */ import xbean.FightStageInfo;
/*     */ import xbean.FightZoneInfo;
/*     */ import xbean.Pod;
/*     */ 
/*     */ public class POnCrossBattleActivityEnd extends LogicProcedure
/*     */ {
/*     */   private final int activityCfgId;
/*     */   
/*     */   public POnCrossBattleActivityEnd(int activityCfgId)
/*     */   {
/*  32 */     this.activityCfgId = activityCfgId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  38 */     SCrossBattleKnockOutCfg sCrossBattleKnockOutCfg = SCrossBattleKnockOutCfg.get(this.activityCfgId);
/*  39 */     if (sCrossBattleKnockOutCfg == null)
/*     */     {
/*  41 */       onCrossBattleActivityEndFail(-1);
/*  42 */       return false;
/*     */     }
/*     */     
/*  45 */     KnockOutCfg knockOutCfg = (KnockOutCfg)sCrossBattleKnockOutCfg.knockOutTypeCfgMap.get(Integer.valueOf(2));
/*  46 */     if (knockOutCfg == null)
/*     */     {
/*  48 */       onCrossBattleActivityEndFail(-2);
/*  49 */       return false;
/*     */     }
/*     */     
/*  52 */     if (!mzm.gsp.open.main.OpenInterface.getOpenStatus(knockOutCfg.module_id))
/*     */     {
/*  54 */       onCrossBattleActivityEndFail(-3);
/*  55 */       return false;
/*     */     }
/*     */     
/*  58 */     long globalActivityCfgid = GameServerInfoManager.toGlobalId(this.activityCfgId);
/*  59 */     CrossBattleKnockoutActivityInfo xCrossBattleKnockoutActivityInfo = xtable.Cross_battle_knockout.get(Long.valueOf(globalActivityCfgid));
/*     */     
/*  61 */     CrossBattleKnockoutInfo xCrossBattleKnockoutInfo = null;
/*  62 */     if (xCrossBattleKnockoutActivityInfo != null)
/*     */     {
/*  64 */       xCrossBattleKnockoutInfo = (CrossBattleKnockoutInfo)xCrossBattleKnockoutActivityInfo.getKnockout_info_map().get(Integer.valueOf(2));
/*     */     }
/*     */     
/*  67 */     FightZoneInfo xFightZoneInfo = null;
/*  68 */     if (xCrossBattleKnockoutInfo != null)
/*     */     {
/*  70 */       xFightZoneInfo = (FightZoneInfo)xCrossBattleKnockoutInfo.getFight_zone_info_map().get(Integer.valueOf(1));
/*     */     }
/*     */     
/*  73 */     if ((xCrossBattleKnockoutActivityInfo == null) || (xCrossBattleKnockoutInfo == null) || (xFightZoneInfo == null))
/*     */     {
/*  75 */       mzm.gsp.crossbattle.GetKnockOutContext_FinalServerAward context = new mzm.gsp.crossbattle.GetKnockOutContext_FinalServerAward();
/*  76 */       OctetsStream octetsStream = new OctetsStream();
/*  77 */       octetsStream.marshal(context);
/*     */       
/*  79 */       mzm.gsp.crossbattle.GetKnockOutContext getKnockOutContext = new mzm.gsp.crossbattle.GetKnockOutContext();
/*  80 */       getKnockOutContext.oper_type = 14;
/*  81 */       getKnockOutContext.content = octetsStream;
/*     */       
/*  83 */       Pair<Integer, Boolean> nowFightStagePair = CrossBattleKnockoutInterface.getNowFightStage(this.activityCfgId, 2);
/*     */       
/*  85 */       if (nowFightStagePair == null)
/*     */       {
/*  87 */         onCrossBattleActivityEndFail(-4);
/*  88 */         return false;
/*     */       }
/*     */       
/*  91 */       int nowKnockOutStage = ((Integer)nowFightStagePair.first).intValue();
/*  92 */       return mzm.gsp.grc.main.GrcInterface.getCrossBattleKnockOutInfo(this.activityCfgId, 2, 1, nowKnockOutStage, knockOutCfg.need_team_size, knockOutCfg.stage_name_list.size(), knockOutCfg.fight_times_every_stage, new OctetsStream().marshal(getKnockOutContext));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  97 */     new PInitCrossBattleFinalServerAwardInfo(this.activityCfgId).call();
/*     */     
/*  99 */     onCrossBattleActivityEndFail(0);
/* 100 */     return true;
/*     */   }
/*     */   
/*     */   private void onCrossBattleActivityEndFail(int ret)
/*     */   {
/* 105 */     StringBuilder sBuilder = new StringBuilder();
/* 106 */     sBuilder.append("[crossbattle]PCGetCrossBattleKnockOutPanelInfo.processImp@on fail");
/* 107 */     sBuilder.append("|activity_cfg_id=").append(this.activityCfgId);
/* 108 */     sBuilder.append("|ret=").append(ret);
/*     */     
/* 110 */     GameServer.logger().info(sBuilder.toString());
/*     */   }
/*     */   
/*     */ 
/*     */   public static class PInitCrossBattleFinalServerAwardInfo
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final int activityCfgId;
/*     */     
/*     */ 
/*     */     public PInitCrossBattleFinalServerAwardInfo(int activityCfgId)
/*     */     {
/* 122 */       this.activityCfgId = activityCfgId;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 128 */       SCrossBattleKnockOutCfg sCrossBattleKnockOutCfg = SCrossBattleKnockOutCfg.get(this.activityCfgId);
/* 129 */       if (sCrossBattleKnockOutCfg == null)
/*     */       {
/* 131 */         onInitCrossBattleFinalServerAwardInfoFail(-1);
/* 132 */         return false;
/*     */       }
/*     */       
/* 135 */       KnockOutCfg knockOutCfg = (KnockOutCfg)sCrossBattleKnockOutCfg.knockOutTypeCfgMap.get(Integer.valueOf(2));
/* 136 */       if (knockOutCfg == null)
/*     */       {
/* 138 */         onInitCrossBattleFinalServerAwardInfoFail(-2);
/* 139 */         return false;
/*     */       }
/*     */       
/* 142 */       if (!mzm.gsp.open.main.OpenInterface.getOpenStatus(knockOutCfg.module_id))
/*     */       {
/* 144 */         onInitCrossBattleFinalServerAwardInfoFail(-3);
/* 145 */         return false;
/*     */       }
/*     */       
/* 148 */       long globalActivityCfgid = GameServerInfoManager.toGlobalId(this.activityCfgId);
/* 149 */       CrossBattleKnockoutActivityInfo xCrossBattleKnockoutActivityInfo = xtable.Cross_battle_knockout.get(Long.valueOf(globalActivityCfgid));
/* 150 */       if (xCrossBattleKnockoutActivityInfo == null)
/*     */       {
/* 152 */         onInitCrossBattleFinalServerAwardInfoFail(-4);
/* 153 */         return false;
/*     */       }
/*     */       
/* 156 */       CrossBattleKnockoutInfo xCrossBattleKnockoutInfo = (CrossBattleKnockoutInfo)xCrossBattleKnockoutActivityInfo.getKnockout_info_map().get(Integer.valueOf(2));
/*     */       
/* 158 */       if (xCrossBattleKnockoutInfo == null)
/*     */       {
/* 160 */         onInitCrossBattleFinalServerAwardInfoFail(-5);
/* 161 */         return false;
/*     */       }
/*     */       
/* 164 */       FightZoneInfo xFightZoneInfo = (FightZoneInfo)xCrossBattleKnockoutInfo.getFight_zone_info_map().get(Integer.valueOf(1));
/* 165 */       if (xFightZoneInfo == null)
/*     */       {
/* 167 */         onInitCrossBattleFinalServerAwardInfoFail(-6);
/* 168 */         return false;
/*     */       }
/*     */       
/* 171 */       int nowFightStage = knockOutCfg.stage_time_point_cfg_id_list.size();
/*     */       
/* 173 */       int championFirstStage = knockOutCfg.stage_time_point_cfg_id_list.size() - knockOutCfg.fight_times_every_stage + 1;
/*     */       
/*     */ 
/* 176 */       FightStageInfo xFightStageInfo = (FightStageInfo)xFightZoneInfo.getFight_stage_info_map().get(Integer.valueOf(championFirstStage));
/* 177 */       if (xFightStageInfo == null)
/*     */       {
/* 179 */         onInitCrossBattleFinalServerAwardInfoFail(-7);
/* 180 */         return false;
/*     */       }
/*     */       
/* 183 */       FightAgainstInfo xFightAgainstInfo = (FightAgainstInfo)xFightStageInfo.getFight_against_info_map().get(Integer.valueOf(1));
/* 184 */       if (xFightAgainstInfo == null)
/*     */       {
/* 186 */         onInitCrossBattleFinalServerAwardInfoFail(-8);
/* 187 */         return false;
/*     */       }
/*     */       
/* 190 */       Pair<Long, Pair<Integer, Integer>> winPair = CrossBattleKnockoutManager.getWinCorpsId(xFightZoneInfo.getFight_stage_info_map(), xFightAgainstInfo.getA_corps_id(), xFightAgainstInfo.getB_corps_id(), nowFightStage, 1, knockOutCfg.fight_times_every_stage);
/*     */       
/*     */ 
/*     */ 
/* 194 */       Map<Integer, List<Long>> topThreeCorpsIdMap = new HashMap();
/*     */       
/* 196 */       long xChampionFightCorpsIdA = xFightAgainstInfo.getA_corps_id();
/*     */       
/* 198 */       long xChampionFightCorpsIdB = xFightAgainstInfo.getB_corps_id();
/*     */       
/* 200 */       boolean championIsByeWin = CrossBattleKnockoutManager.isByeWin(xFightAgainstInfo);
/*     */       
/*     */ 
/*     */ 
/* 204 */       if ((((Long)winPair.first).longValue() == -1L) && (!championIsByeWin))
/*     */       {
/*     */ 
/* 207 */         List<Long> secondPlaceCorpsIdList = new ArrayList();
/* 208 */         if (xChampionFightCorpsIdA > 0L)
/*     */         {
/* 210 */           secondPlaceCorpsIdList.add(Long.valueOf(xChampionFightCorpsIdA));
/*     */         }
/*     */         
/* 213 */         if (xChampionFightCorpsIdB > 0L)
/*     */         {
/* 215 */           secondPlaceCorpsIdList.add(Long.valueOf(xChampionFightCorpsIdB));
/*     */         }
/* 217 */         topThreeCorpsIdMap.put(Integer.valueOf(2), secondPlaceCorpsIdList);
/*     */ 
/*     */ 
/*     */       }
/* 221 */       else if ((((Long)winPair.first).longValue() == xChampionFightCorpsIdA) || ((championIsByeWin) && (xFightAgainstInfo.getCal_fight_result() == FightResultEnum.A_BYE_WIN.fightResult)))
/*     */       {
/*     */ 
/* 224 */         if (xChampionFightCorpsIdA > 0L)
/*     */         {
/* 226 */           topThreeCorpsIdMap.put(Integer.valueOf(1), Arrays.asList(new Long[] { Long.valueOf(xChampionFightCorpsIdA) }));
/*     */         }
/*     */         
/* 229 */         if (xChampionFightCorpsIdB > 0L)
/*     */         {
/* 231 */           topThreeCorpsIdMap.put(Integer.valueOf(2), Arrays.asList(new Long[] { Long.valueOf(xChampionFightCorpsIdB) }));
/*     */         }
/*     */       }
/*     */       else
/*     */       {
/* 236 */         if (xChampionFightCorpsIdB > 0L)
/*     */         {
/* 238 */           topThreeCorpsIdMap.put(Integer.valueOf(1), Arrays.asList(new Long[] { Long.valueOf(xChampionFightCorpsIdB) }));
/*     */         }
/*     */         
/* 241 */         if (xChampionFightCorpsIdA > 0L)
/*     */         {
/* 243 */           topThreeCorpsIdMap.put(Integer.valueOf(2), Arrays.asList(new Long[] { Long.valueOf(xChampionFightCorpsIdA) }));
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 248 */       int thirdPlaceLastStage = knockOutCfg.stage_time_point_cfg_id_list.size() - knockOutCfg.fight_times_every_stage;
/*     */       
/* 250 */       FightStageInfo xThirdPlaceFightStageInfo = (FightStageInfo)xFightZoneInfo.getFight_stage_info_map().get(Integer.valueOf(thirdPlaceLastStage));
/*     */       
/* 252 */       if (xThirdPlaceFightStageInfo == null)
/*     */       {
/* 254 */         onInitCrossBattleFinalServerAwardInfoFail(-9);
/* 255 */         return false;
/*     */       }
/*     */       
/*     */ 
/* 259 */       FightAgainstInfo xThirdPlaceFightAgainstInfo = (FightAgainstInfo)xThirdPlaceFightStageInfo.getFight_against_info_map().get(Integer.valueOf(1));
/*     */       
/* 261 */       if (xThirdPlaceFightAgainstInfo == null)
/*     */       {
/* 263 */         onInitCrossBattleFinalServerAwardInfoFail(-10);
/* 264 */         return false;
/*     */       }
/*     */       
/* 267 */       long thirdPlaceAgainstACorpsId = xThirdPlaceFightAgainstInfo.getA_corps_id();
/* 268 */       long thirdPlaceAgainstBCorpsId = xThirdPlaceFightAgainstInfo.getB_corps_id();
/* 269 */       Pair<Long, Pair<Integer, Integer>> thirdPlaceWinPair = CrossBattleKnockoutManager.getWinCorpsId(xFightZoneInfo.getFight_stage_info_map(), thirdPlaceAgainstACorpsId, thirdPlaceAgainstBCorpsId, thirdPlaceLastStage, 1, knockOutCfg.fight_times_every_stage);
/*     */       
/*     */ 
/*     */ 
/* 273 */       if (((Long)thirdPlaceWinPair.first).longValue() != -1L)
/*     */       {
/* 275 */         topThreeCorpsIdMap.put(Integer.valueOf(3), Arrays.asList(new Long[] { (Long)thirdPlaceWinPair.first }));
/*     */       }
/*     */       
/* 278 */       if (!topThreeCorpsIdMap.isEmpty())
/*     */       {
/* 280 */         new POnCrossBattleActivityEnd.PInitCrossBattleFinalServerAwardByCorps(topThreeCorpsIdMap, this.activityCfgId).execute();
/*     */       }
/*     */       
/* 283 */       StringBuilder sBuilder = new StringBuilder();
/* 284 */       sBuilder.append("[crossbattle]PInitCrossBattleFinalServerAwardInfo.processImp@get result success");
/* 285 */       sBuilder.append("|activity_cfg_id=").append(this.activityCfgId);
/* 286 */       sBuilder.append("|key=").append(topThreeCorpsIdMap.keySet());
/* 287 */       sBuilder.append("|value=").append(topThreeCorpsIdMap.values());
/*     */       
/* 289 */       GameServer.logger().info(sBuilder.toString());
/* 290 */       return true;
/*     */     }
/*     */     
/*     */     private void onInitCrossBattleFinalServerAwardInfoFail(int ret)
/*     */     {
/* 295 */       StringBuilder sBuilder = new StringBuilder();
/* 296 */       sBuilder.append("[crossbattle]PInitCrossBattleFinalServerAwardInfo.processImp@on fail");
/* 297 */       sBuilder.append("|activity_cfg_id=").append(this.activityCfgId);
/* 298 */       sBuilder.append("|ret=").append(ret);
/*     */       
/* 300 */       GameServer.logger().info(sBuilder.toString());
/*     */     }
/*     */   }
/*     */   
/*     */   private static class PInitCrossBattleFinalServerAwardByCorps extends LogicProcedure
/*     */   {
/*     */     private final Map<Integer, List<Long>> topThreeCorpsMap;
/*     */     private final int activityCfgId;
/*     */     
/*     */     public PInitCrossBattleFinalServerAwardByCorps(Map<Integer, List<Long>> topThreeCorpsMap, int activityCfgId)
/*     */     {
/* 311 */       this.topThreeCorpsMap = topThreeCorpsMap;
/* 312 */       this.activityCfgId = activityCfgId;
/*     */     }
/*     */     
/*     */ 
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 319 */       Set<Long> corpsIdSet = new java.util.HashSet();
/* 320 */       for (List<Long> corpsIdList : this.topThreeCorpsMap.values())
/*     */       {
/* 322 */         corpsIdSet.addAll(corpsIdList);
/*     */       }
/* 324 */       lock(xtable.Corps.getTable(), corpsIdSet);
/*     */       
/* 326 */       long globalActivityCfgid = GameServerInfoManager.toGlobalId(this.activityCfgId);
/*     */       
/* 328 */       xbean.CrossBattleKnockoutActivityLocalInfo xKnockoutLocalInfo = xtable.Cross_battle_knockout_local.get(Long.valueOf(globalActivityCfgid));
/* 329 */       if (xKnockoutLocalInfo == null)
/*     */       {
/* 331 */         xKnockoutLocalInfo = Pod.newCrossBattleKnockoutActivityLocalInfo();
/* 332 */         xtable.Cross_battle_knockout_local.add(Long.valueOf(globalActivityCfgid), xKnockoutLocalInfo);
/*     */       }
/*     */       
/* 335 */       Map<Integer, CrossBattleKnockoutLocalRankInfo> xLocalRankInfoMap = xKnockoutLocalInfo.getAward_server_info_map();
/*     */       
/* 337 */       List<Long> championCorpsIdList = (List)this.topThreeCorpsMap.get(Integer.valueOf(1));
/* 338 */       if (championCorpsIdList != null)
/*     */       {
/* 340 */         long championCorpsid = ((Long)championCorpsIdList.get(0)).longValue();
/* 341 */         if (null != CorpsInterface.getCorpsInfoByCorpsId(championCorpsid, true))
/*     */         {
/* 343 */           CrossBattleKnockoutLocalRankInfo localRankInfo = Pod.newCrossBattleKnockoutLocalRankInfo();
/* 344 */           localRankInfo.setIs_server_buff_install(false);
/* 345 */           localRankInfo.getValid_zone_id_set().addAll(GameServerInfoManager.getZoneIds());
/*     */           
/* 347 */           xLocalRankInfoMap.put(Integer.valueOf(1), localRankInfo);
/*     */         }
/*     */       }
/*     */       
/* 351 */       boolean isSecondPlaceServer = false;
/*     */       
/* 353 */       List<Long> secondPlaceCorpsIdList = (List)this.topThreeCorpsMap.get(Integer.valueOf(2));
/* 354 */       if (secondPlaceCorpsIdList != null)
/*     */       {
/* 356 */         long firstSecondCorpsId = ((Long)secondPlaceCorpsIdList.get(0)).longValue();
/* 357 */         if (null != CorpsInterface.getCorpsInfoByCorpsId(firstSecondCorpsId, true))
/*     */         {
/* 359 */           CrossBattleKnockoutLocalRankInfo localRankInfo = Pod.newCrossBattleKnockoutLocalRankInfo();
/* 360 */           localRankInfo.setIs_server_buff_install(false);
/* 361 */           localRankInfo.getValid_zone_id_set().addAll(GameServerInfoManager.getZoneIds());
/*     */           
/* 363 */           xLocalRankInfoMap.put(Integer.valueOf(2), localRankInfo);
/*     */           
/* 365 */           isSecondPlaceServer = true;
/*     */         }
/*     */         
/* 368 */         if (secondPlaceCorpsIdList.size() == 2)
/*     */         {
/* 370 */           long secondPlaceCorpsId = ((Long)secondPlaceCorpsIdList.get(1)).longValue();
/* 371 */           if (null != CorpsInterface.getCorpsInfoByCorpsId(secondPlaceCorpsId, true))
/*     */           {
/* 373 */             if (isSecondPlaceServer)
/*     */             {
/* 375 */               CrossBattleKnockoutLocalRankInfo localRankInfo = Pod.newCrossBattleKnockoutLocalRankInfo();
/* 376 */               localRankInfo.setIs_server_buff_install(false);
/* 377 */               localRankInfo.getValid_zone_id_set().addAll(GameServerInfoManager.getZoneIds());
/*     */               
/* 379 */               xLocalRankInfoMap.put(Integer.valueOf(3), localRankInfo);
/*     */ 
/*     */             }
/*     */             else
/*     */             {
/*     */ 
/* 385 */               CrossBattleKnockoutLocalRankInfo localRankInfo = Pod.newCrossBattleKnockoutLocalRankInfo();
/* 386 */               localRankInfo.setIs_server_buff_install(false);
/* 387 */               localRankInfo.getValid_zone_id_set().addAll(GameServerInfoManager.getZoneIds());
/*     */               
/* 389 */               xLocalRankInfoMap.put(Integer.valueOf(2), localRankInfo);
/*     */               
/* 391 */               isSecondPlaceServer = true;
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 398 */       List<Long> thirdPlaceCorpsIdList = (List)this.topThreeCorpsMap.get(Integer.valueOf(3));
/* 399 */       if (thirdPlaceCorpsIdList != null)
/*     */       {
/* 401 */         long thirdPlaceCorpsid = ((Long)thirdPlaceCorpsIdList.get(0)).longValue();
/* 402 */         if (null != CorpsInterface.getCorpsInfoByCorpsId(thirdPlaceCorpsid, true))
/*     */         {
/* 404 */           CrossBattleKnockoutLocalRankInfo localRankInfo = Pod.newCrossBattleKnockoutLocalRankInfo();
/* 405 */           localRankInfo.setIs_server_buff_install(false);
/* 406 */           localRankInfo.getValid_zone_id_set().addAll(GameServerInfoManager.getZoneIds());
/*     */           
/* 408 */           xLocalRankInfoMap.put(Integer.valueOf(4), localRankInfo);
/*     */         }
/*     */       }
/*     */       
/* 412 */       new PTryStartFinalAwardObserver(this.activityCfgId).execute();
/*     */       
/* 414 */       StringBuilder sBuilder = new StringBuilder();
/* 415 */       sBuilder.append("[crossbattle_knockout]POnCrossBattleActivityEnd.PInitCrossBattleFinalServerAwardByCorps.processImp@handle server award success");
/* 416 */       sBuilder.append("|top_three_corps_key=").append(this.topThreeCorpsMap.keySet());
/* 417 */       sBuilder.append("|top_three_corps_value=").append(this.topThreeCorpsMap.values());
/* 418 */       sBuilder.append("|cross_battle_knockout_local=").append(xKnockoutLocalInfo);
/* 419 */       sBuilder.append("|rank_key=").append(xLocalRankInfoMap.keySet());
/* 420 */       sBuilder.append("|rank_value=").append(xLocalRankInfoMap.values());
/* 421 */       sBuilder.append("|activity_cfg_id=").append(this.activityCfgId);
/*     */       
/* 423 */       GameServer.logger().info(sBuilder.toString());
/*     */       
/* 425 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\knockout\POnCrossBattleActivityEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
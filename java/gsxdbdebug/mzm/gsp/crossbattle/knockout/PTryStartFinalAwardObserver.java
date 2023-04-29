/*     */ package mzm.gsp.crossbattle.knockout;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.crossbattle.confbean.RankAwardBuffList;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattleFinalServerAwardCfg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import xbean.CrossBattleKnockoutActivityLocalInfo;
/*     */ import xbean.CrossBattleKnockoutLocalRankInfo;
/*     */ import xtable.Cross_battle_knockout_local;
/*     */ 
/*     */ public class PTryStartFinalAwardObserver extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final int activityCfgId;
/*     */   
/*     */   public PTryStartFinalAwardObserver(int activityCfgId)
/*     */   {
/*  22 */     this.activityCfgId = activityCfgId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  28 */     long globalActivityCfgid = mzm.gsp.GameServerInfoManager.toGlobalId(this.activityCfgId);
/*     */     
/*  30 */     CrossBattleKnockoutActivityLocalInfo xKnockoutLocalInfo = Cross_battle_knockout_local.get(Long.valueOf(globalActivityCfgid));
/*  31 */     if (xKnockoutLocalInfo == null)
/*     */     {
/*  33 */       onFail(-1);
/*  34 */       return false;
/*     */     }
/*     */     
/*  37 */     SCrossBattleFinalServerAwardCfg sFinalServerAwardCfg = SCrossBattleFinalServerAwardCfg.get(this.activityCfgId);
/*  38 */     if (sFinalServerAwardCfg == null)
/*     */     {
/*  40 */       onFail(-2);
/*  41 */       return false;
/*     */     }
/*     */     
/*  44 */     Map<Integer, CrossBattleKnockoutLocalRankInfo> xLocalRankInfoMap = xKnockoutLocalInfo.getAward_server_info_map();
/*  45 */     if (xLocalRankInfoMap.isEmpty())
/*     */     {
/*  47 */       onFail(-3);
/*  48 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  52 */     Map<Integer, Set<Integer>> rank2validZoneIdSetMap = new HashMap();
/*  53 */     for (Map.Entry<Integer, CrossBattleKnockoutLocalRankInfo> entry : xLocalRankInfoMap.entrySet())
/*     */     {
/*  55 */       int rank = ((Integer)entry.getKey()).intValue();
/*  56 */       CrossBattleKnockoutLocalRankInfo xCrossBattleKnockoutLocalRankInfo = (CrossBattleKnockoutLocalRankInfo)entry.getValue();
/*     */       
/*  58 */       rank2validZoneIdSetMap.put(Integer.valueOf(rank), new java.util.HashSet(xCrossBattleKnockoutLocalRankInfo.getValid_zone_id_set()));
/*     */     }
/*     */     
/*  61 */     CrossBattleFinalServerAwardManager.addNewActivityServerAwardInfo(this.activityCfgId, rank2validZoneIdSetMap);
/*     */     
/*  63 */     long currentTimeMillis = DateTimeUtils.getCurrTimeInMillis();
/*  64 */     long activityEndTime = ActivityInterface.getActivityLimitTimeEnd(this.activityCfgId);
/*  65 */     if (currentTimeMillis + 2000L < activityEndTime)
/*     */     {
/*  67 */       Map<String, Object> extraMap = new HashMap();
/*  68 */       extraMap.put("current_time_millis", Long.valueOf(currentTimeMillis));
/*  69 */       extraMap.put("activity_end_time", Long.valueOf(activityEndTime));
/*     */       
/*  71 */       onFail(-4, extraMap);
/*  72 */       return false;
/*     */     }
/*     */     
/*  75 */     boolean isNeedMailAwardItem = true;
/*  76 */     long lastStageEndTimeMillis = activityEndTime + 86400000L * sFinalServerAwardCfg.open_interval_day_after_activity_end;
/*     */     
/*     */ 
/*  79 */     for (int recordRank = 1; recordRank <= 4; recordRank++)
/*     */     {
/*  81 */       CrossBattleKnockoutLocalRankInfo xLocalRankInfo = (CrossBattleKnockoutLocalRankInfo)xKnockoutLocalInfo.getAward_server_info_map().get(Integer.valueOf(recordRank));
/*     */       
/*  83 */       if (xLocalRankInfo != null)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*  88 */         int realRank = recordRank >= 3 ? recordRank - 1 : recordRank;
/*     */         
/*  90 */         boolean isAleardyInstallBuff = xLocalRankInfo.getIs_server_buff_install();
/*     */         
/*  92 */         long newEndTimeMillis = tryTriggerObserver(realRank, recordRank, sFinalServerAwardCfg, lastStageEndTimeMillis, currentTimeMillis, isNeedMailAwardItem, isAleardyInstallBuff);
/*     */         
/*     */ 
/*  95 */         lastStageEndTimeMillis = newEndTimeMillis;
/*     */         
/*  97 */         isNeedMailAwardItem = false;
/*     */       }
/*     */     }
/* 100 */     onFail(0);
/* 101 */     return true;
/*     */   }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private long tryTriggerObserver(int realRank, int recordRank, SCrossBattleFinalServerAwardCfg sFinalServerAwardCfg, long lastStageEndTimeMillis, long currentTimeMillis, boolean isNeedMailAwardItem, boolean isAleardyInstall)
/*     */   {
/* 124 */     RankAwardBuffList rankAwardBuffList = (RankAwardBuffList)sFinalServerAwardCfg.rank_2_award_buff_map.get(Integer.valueOf(realRank));
/* 125 */     long newEndTimeMillis = lastStageEndTimeMillis;
/* 126 */     if (rankAwardBuffList != null)
/*     */     {
/* 128 */       newEndTimeMillis = lastStageEndTimeMillis + 86400000L * rankAwardBuffList.buff_last_day;
/*     */       
/* 130 */       if (isAleardyInstall)
/*     */       {
/* 132 */         return newEndTimeMillis;
/*     */       }
/*     */       
/* 135 */       if (lastStageEndTimeMillis > currentTimeMillis)
/*     */       {
/*     */ 
/* 138 */         long intervalMillis = lastStageEndTimeMillis - currentTimeMillis;
/* 139 */         new FinalServerDelayAwardObserver(recordRank == 3 ? intervalMillis + 2000L : intervalMillis, this.activityCfgId, realRank, newEndTimeMillis, isNeedMailAwardItem, recordRank);
/*     */ 
/*     */ 
/*     */       }
/* 143 */       else if (newEndTimeMillis > currentTimeMillis)
/*     */       {
/* 145 */         new FinalServerDelayAwardObserver(0L, this.activityCfgId, realRank, newEndTimeMillis, isNeedMailAwardItem, recordRank);
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/*     */ 
/* 151 */         Map<String, Object> extraMap = new HashMap();
/* 152 */         extraMap.put("rank", Integer.valueOf(realRank));
/*     */         
/* 154 */         onFail(-5);
/*     */       }
/*     */     }
/*     */     
/* 158 */     return newEndTimeMillis;
/*     */   }
/*     */   
/*     */   private void onFail(int ret)
/*     */   {
/* 163 */     onFail(ret, null);
/*     */   }
/*     */   
/*     */   private void onFail(int ret, Map<String, Object> extraMap)
/*     */   {
/* 168 */     StringBuilder sBuilder = new StringBuilder();
/* 169 */     sBuilder.append("[crossbattle_final]PTryStartFinalAwardObserver.processImp@on fail");
/* 170 */     sBuilder.append("|ret=").append(ret);
/* 171 */     sBuilder.append("|activity_cfg_id=").append(this.activityCfgId);
/*     */     
/* 173 */     if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */     {
/* 175 */       for (Map.Entry<String, Object> entry : extraMap.entrySet())
/*     */       {
/* 177 */         sBuilder.append('|').append((String)entry.getKey()).append('=').append(entry.getValue());
/*     */       }
/*     */     }
/*     */     
/* 181 */     GameServer.logger().info(sBuilder.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\knockout\PTryStartFinalAwardObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
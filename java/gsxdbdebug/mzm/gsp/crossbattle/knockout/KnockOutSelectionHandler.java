/*     */ package mzm.gsp.crossbattle.knockout;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import mzm.gsp.activity.confbean.SActivityCfg;
/*     */ import mzm.gsp.bulletin.SBulletinInfo;
/*     */ import mzm.gsp.bulletin.main.BulletinInterface;
/*     */ import mzm.gsp.common.TimeCommonUtil;
/*     */ import mzm.gsp.common.confbean.STimePointCommonCfg;
/*     */ import mzm.gsp.crossbattle.SEnterCrossBattleSelectionMapSuccess;
/*     */ import mzm.gsp.crossbattle.SLoginNotifySelectionFightRes;
/*     */ import mzm.gsp.crossbattle.SNotifySelectionBegin;
/*     */ import mzm.gsp.crossbattle.confbean.CrossBattleConsts;
/*     */ import mzm.gsp.crossbattle.confbean.KnockOutCfg;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattleKnockOutCfg;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattlePointCfg;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattleStageDurationCfg;
/*     */ import xio.Protocol;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class KnockOutSelectionHandler
/*     */   extends KnockOutHandler
/*     */ {
/*     */   public void sendChampionBulletionInfo(String corpsName, int fightZoneId, int physicsZoneId)
/*     */   {
/*  31 */     SBulletinInfo sChampionBulletinInfo = new SBulletinInfo();
/*  32 */     sChampionBulletinInfo.bulletintype = 41;
/*  33 */     sChampionBulletinInfo.params.put(Integer.valueOf(29), corpsName);
/*  34 */     sChampionBulletinInfo.params.put(Integer.valueOf(32), String.valueOf(fightZoneId));
/*  35 */     sChampionBulletinInfo.params.put(Integer.valueOf(31), String.valueOf(1));
/*     */     
/*  37 */     BulletinInterface.sendBulletin(sChampionBulletinInfo);
/*     */   }
/*     */   
/*     */ 
/*     */   public void sendSecondPlaceBulletionInfo(String corpsName, int fightZoneId, int physicsZoneId)
/*     */   {
/*  43 */     SBulletinInfo sSecondBulletinInfo = new SBulletinInfo();
/*  44 */     sSecondBulletinInfo.bulletintype = 41;
/*  45 */     sSecondBulletinInfo.params.put(Integer.valueOf(29), corpsName);
/*  46 */     sSecondBulletinInfo.params.put(Integer.valueOf(32), String.valueOf(fightZoneId));
/*  47 */     sSecondBulletinInfo.params.put(Integer.valueOf(31), String.valueOf(2));
/*     */     
/*  49 */     BulletinInterface.sendBulletin(sSecondBulletinInfo);
/*     */   }
/*     */   
/*     */ 
/*     */   public void sendThirdPlaceBulletionInfo(String corpsName, int fightZoneId, int physicsZoneId)
/*     */   {
/*  55 */     SBulletinInfo sThirdBulltinInfo = new SBulletinInfo();
/*  56 */     sThirdBulltinInfo.bulletintype = 41;
/*  57 */     sThirdBulltinInfo.params.put(Integer.valueOf(29), corpsName);
/*  58 */     sThirdBulltinInfo.params.put(Integer.valueOf(32), String.valueOf(fightZoneId));
/*  59 */     sThirdBulltinInfo.params.put(Integer.valueOf(31), String.valueOf(3));
/*     */     
/*  61 */     BulletinInterface.sendBulletin(sThirdBulltinInfo);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<String> getTitleContextArgsList(int fightZoneId)
/*     */   {
/*  67 */     List<String> contextArgList = new ArrayList();
/*  68 */     contextArgList.add(CrossBattleConsts.getInstance().cross_battle_session);
/*  69 */     contextArgList.add(String.valueOf(fightZoneId));
/*     */     
/*  71 */     long awardTime = getKnockOutEndTime(CrossBattleConsts.getInstance().CURRENT_ACTIVITY_CFG_ID);
/*  72 */     Calendar calendar = TimeCommonUtil.getCalendar(awardTime);
/*     */     
/*  74 */     contextArgList.add(String.valueOf(calendar.get(1)));
/*  75 */     contextArgList.add(String.valueOf(calendar.get(2) + 1));
/*  76 */     contextArgList.add(String.valueOf(calendar.get(5)));
/*  77 */     return contextArgList;
/*     */   }
/*     */   
/*     */ 
/*     */   void sendRankUpNextStageBulletionInfo(String corpsName, int zoneId)
/*     */   {
/*  83 */     SBulletinInfo sRankUpFinalBulltinInfo = new SBulletinInfo();
/*  84 */     sRankUpFinalBulltinInfo.bulletintype = 40;
/*  85 */     sRankUpFinalBulltinInfo.params.put(Integer.valueOf(29), corpsName);
/*     */     
/*  87 */     BulletinInterface.sendBulletin(sRankUpFinalBulltinInfo);
/*     */   }
/*     */   
/*     */ 
/*     */   void sendRankUpChampionStageBulletionInfo(String corpsName, int physicalZoneId)
/*     */   {
/*  93 */     SBulletinInfo sBulletinInfo = new SBulletinInfo();
/*  94 */     sBulletinInfo.bulletintype = 51;
/*  95 */     sBulletinInfo.params.put(Integer.valueOf(29), corpsName);
/*  96 */     sBulletinInfo.params.put(Integer.valueOf(33), String.valueOf(physicalZoneId));
/*     */     
/*  98 */     BulletinInterface.sendBulletin(sBulletinInfo);
/*     */   }
/*     */   
/*     */ 
/*     */   void sendRankUpNextFightStageBulletionInfo(String corpsName, int maxFightIndexId)
/*     */   {
/* 104 */     SBulletinInfo sBulletinInfo = new SBulletinInfo();
/* 105 */     sBulletinInfo.bulletintype = 39;
/* 106 */     sBulletinInfo.params.put(Integer.valueOf(30), String.valueOf(maxFightIndexId));
/* 107 */     sBulletinInfo.params.put(Integer.valueOf(29), corpsName);
/*     */     
/* 109 */     BulletinInterface.sendBulletin(sBulletinInfo);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   Protocol getNotifyKnockOutBeginProtocol()
/*     */   {
/* 116 */     SNotifySelectionBegin sNotifySelectionBegin = new SNotifySelectionBegin();
/* 117 */     return sNotifySelectionBegin;
/*     */   }
/*     */   
/*     */ 
/*     */   List<String> getByeRankUpContextArgsList(KnockOutCfg knockOutCfg, int nowStage, int nextStage)
/*     */   {
/* 123 */     List<String> contextArgsList = new ArrayList();
/* 124 */     contextArgsList.add(knockOutCfg.stage_name_list.get(nextStage - 1));
/* 125 */     CrossBattleKnockoutInterface.fillNextStageTimeMailContextArgs(knockOutCfg, nextStage, contextArgsList);
/* 126 */     return contextArgsList;
/*     */   }
/*     */   
/*     */ 
/*     */   Protocol getEnterPrepareWorldProtocol(int leftSeconds)
/*     */   {
/* 132 */     SEnterCrossBattleSelectionMapSuccess enterSelectionMapSuccess = new SEnterCrossBattleSelectionMapSuccess();
/* 133 */     enterSelectionMapSuccess.left_seconds = leftSeconds;
/* 134 */     return enterSelectionMapSuccess;
/*     */   }
/*     */   
/*     */ 
/*     */   Protocol getNotifyFightResult(int winOrLose, int isRankUp)
/*     */   {
/* 140 */     SLoginNotifySelectionFightRes sLoginNotifySelectionFightRes = new SLoginNotifySelectionFightRes();
/* 141 */     sLoginNotifySelectionFightRes.is_rank_up = isRankUp;
/* 142 */     sLoginNotifySelectionFightRes.ret = winOrLose;
/*     */     
/* 144 */     return sLoginNotifySelectionFightRes;
/*     */   }
/*     */   
/*     */ 
/*     */   long getKnockOutEndTime(int activityCfgId)
/*     */   {
/* 150 */     SActivityCfg activityCfg = SActivityCfg.get(activityCfgId);
/* 151 */     if (activityCfg == null)
/*     */     {
/* 153 */       return -1L;
/*     */     }
/*     */     
/* 156 */     SCrossBattleStageDurationCfg sCrossBattleStageDurationCfg = SCrossBattleStageDurationCfg.get(activityCfgId);
/* 157 */     if (sCrossBattleStageDurationCfg == null)
/*     */     {
/* 159 */       return -1L;
/*     */     }
/*     */     
/* 162 */     long activityStartTimestamp = TimeCommonUtil.getLimitTimeBegin(activityCfg.activityLimitTimeid);
/*     */     
/* 164 */     return activityStartTimestamp + (sCrossBattleStageDurationCfg.registerStageDurationInDay + sCrossBattleStageDurationCfg.voteStageDurationInDay + sCrossBattleStageDurationCfg.roundRobinStageDurationInDay + sCrossBattleStageDurationCfg.zoneDivideStageDurationInDay + sCrossBattleStageDurationCfg.zonePointStageDurationInDay + sCrossBattleStageDurationCfg.roundSelectionStageDurationInDay) * 86400000L;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   long getNextKnockOutGameStartTime(int activityCfgId)
/*     */   {
/* 176 */     SCrossBattleKnockOutCfg sCrossBattleKnockOutCfg = SCrossBattleKnockOutCfg.get(activityCfgId);
/* 177 */     if (sCrossBattleKnockOutCfg == null)
/*     */     {
/* 179 */       return -1L;
/*     */     }
/*     */     
/* 182 */     KnockOutCfg knockOutCfg = (KnockOutCfg)sCrossBattleKnockOutCfg.knockOutTypeCfgMap.get(Integer.valueOf(2));
/* 183 */     if (knockOutCfg == null)
/*     */     {
/* 185 */       return -1L;
/*     */     }
/*     */     
/* 188 */     if (knockOutCfg.stage_time_point_cfg_id_list.isEmpty())
/*     */     {
/* 190 */       return -1L;
/*     */     }
/*     */     
/* 193 */     STimePointCommonCfg sTimePointCommonCfg = STimePointCommonCfg.get(((Integer)knockOutCfg.stage_time_point_cfg_id_list.get(0)).intValue());
/* 194 */     if (sTimePointCommonCfg == null)
/*     */     {
/* 196 */       return -1L;
/*     */     }
/*     */     
/* 199 */     return TimeCommonUtil.getTimePoint(sTimePointCommonCfg) - knockOutCfg.prepare_world_countdown * 60000L;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   List<String> getRestartKnockOutMailContextArgs(KnockOutCfg knockOutCfg, int fightZoneId, int fightStage, long opponentCorpsId, String opponentCorpsName, long prepareWorldBeginTime)
/*     */   {
/* 207 */     List<String> contextArgsList = new ArrayList();
/* 208 */     String fightStageName = (String)knockOutCfg.stage_name_list.get(fightStage - 1);
/*     */     
/* 210 */     contextArgsList.add(String.valueOf(fightZoneId));
/* 211 */     contextArgsList.add(fightStageName);
/* 212 */     contextArgsList.add(opponentCorpsName);
/* 213 */     contextArgsList.add(String.valueOf(opponentCorpsId));
/*     */     
/* 215 */     Calendar calendar = TimeCommonUtil.getCalendar(prepareWorldBeginTime);
/*     */     
/* 217 */     contextArgsList.add(String.valueOf(calendar.get(1)));
/* 218 */     contextArgsList.add(String.valueOf(calendar.get(2) + 1));
/* 219 */     contextArgsList.add(String.valueOf(calendar.get(5)));
/* 220 */     contextArgsList.add(String.valueOf(calendar.get(11)));
/* 221 */     contextArgsList.add(String.format("%02d", new Object[] { Integer.valueOf(calendar.get(12)) }));
/* 222 */     return contextArgsList;
/*     */   }
/*     */   
/*     */ 
/*     */   long getKnockOutBeginTime(int activityCfgId)
/*     */   {
/* 228 */     SActivityCfg activityCfg = SActivityCfg.get(activityCfgId);
/* 229 */     if (activityCfg == null)
/*     */     {
/* 231 */       return -1L;
/*     */     }
/*     */     
/* 234 */     long activityStartTimestamp = TimeCommonUtil.getLimitTimeBegin(activityCfg.activityLimitTimeid);
/*     */     
/* 236 */     SCrossBattleStageDurationCfg sCrossBattleStageDurationCfg = SCrossBattleStageDurationCfg.get(activityCfgId);
/* 237 */     if (sCrossBattleStageDurationCfg == null)
/*     */     {
/* 239 */       return -1L;
/*     */     }
/*     */     
/* 242 */     return activityStartTimestamp + (sCrossBattleStageDurationCfg.registerStageDurationInDay + sCrossBattleStageDurationCfg.voteStageDurationInDay + sCrossBattleStageDurationCfg.roundRobinStageDurationInDay + sCrossBattleStageDurationCfg.zoneDivideStageDurationInDay + sCrossBattleStageDurationCfg.zonePointStageDurationInDay) * 86400000L;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   long getCanGetKnockOutInfoTime(int activityCfgId)
/*     */   {
/* 253 */     SCrossBattlePointCfg sCrossBattlePointCfg = SCrossBattlePointCfg.get(activityCfgId);
/* 254 */     if (sCrossBattlePointCfg == null)
/*     */     {
/* 256 */       return Long.MAX_VALUE;
/*     */     }
/*     */     
/* 259 */     STimePointCommonCfg sTimePointCommonCfg = STimePointCommonCfg.get(sCrossBattlePointCfg.endTimePoint);
/* 260 */     if (sTimePointCommonCfg == null)
/*     */     {
/* 262 */       return Long.MAX_VALUE;
/*     */     }
/*     */     
/* 265 */     return TimeCommonUtil.getTimePoint(sTimePointCommonCfg) + 3600000L;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\knockout\KnockOutSelectionHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
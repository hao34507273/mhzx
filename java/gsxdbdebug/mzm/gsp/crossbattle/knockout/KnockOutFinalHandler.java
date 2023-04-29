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
/*     */ import mzm.gsp.crossbattle.SEnterCrossBattleFinalMapSuccess;
/*     */ import mzm.gsp.crossbattle.SLoginNotifyFinalFightRes;
/*     */ import mzm.gsp.crossbattle.SNotifyFinalBegin;
/*     */ import mzm.gsp.crossbattle.confbean.CrossBattleConsts;
/*     */ import mzm.gsp.crossbattle.confbean.KnockOutCfg;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattleKnockOutCfg;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattleStageDurationCfg;
/*     */ import xio.Protocol;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class KnockOutFinalHandler
/*     */   extends KnockOutHandler
/*     */ {
/*     */   public void sendChampionBulletionInfo(String ownCorpsName, int fightZoneId, int physicalZoneId)
/*     */   {
/*  30 */     SBulletinInfo sChampionBulletinInfo = new SBulletinInfo();
/*  31 */     sChampionBulletinInfo.bulletintype = 44;
/*  32 */     sChampionBulletinInfo.params.put(Integer.valueOf(29), ownCorpsName);
/*  33 */     sChampionBulletinInfo.params.put(Integer.valueOf(31), String.valueOf(1));
/*  34 */     sChampionBulletinInfo.params.put(Integer.valueOf(33), String.valueOf(physicalZoneId));
/*     */     
/*  36 */     BulletinInterface.sendBulletin(sChampionBulletinInfo);
/*     */     
/*  38 */     CrossBattleKnockoutManager.broadcastFinalBulletin(physicalZoneId, sChampionBulletinInfo);
/*     */   }
/*     */   
/*     */ 
/*     */   public void sendSecondPlaceBulletionInfo(String ownCorpsName, int fightZoneId, int physicalZoneId)
/*     */   {
/*  44 */     SBulletinInfo sSecondBulletinInfo = new SBulletinInfo();
/*  45 */     sSecondBulletinInfo.bulletintype = 44;
/*  46 */     sSecondBulletinInfo.params.put(Integer.valueOf(29), ownCorpsName);
/*  47 */     sSecondBulletinInfo.params.put(Integer.valueOf(31), String.valueOf(2));
/*  48 */     sSecondBulletinInfo.params.put(Integer.valueOf(33), String.valueOf(physicalZoneId));
/*  49 */     BulletinInterface.sendBulletin(sSecondBulletinInfo);
/*     */     
/*  51 */     CrossBattleKnockoutManager.broadcastFinalBulletin(physicalZoneId, sSecondBulletinInfo);
/*     */   }
/*     */   
/*     */ 
/*     */   public void sendThirdPlaceBulletionInfo(String ownCorpsName, int fightZoneId, int physicalZoneId)
/*     */   {
/*  57 */     SBulletinInfo sThirdBulltinInfo = new SBulletinInfo();
/*  58 */     sThirdBulltinInfo.bulletintype = 44;
/*  59 */     sThirdBulltinInfo.params.put(Integer.valueOf(29), ownCorpsName);
/*  60 */     sThirdBulltinInfo.params.put(Integer.valueOf(31), String.valueOf(3));
/*  61 */     sThirdBulltinInfo.params.put(Integer.valueOf(33), String.valueOf(physicalZoneId));
/*     */     
/*  63 */     BulletinInterface.sendBulletin(sThirdBulltinInfo);
/*     */     
/*  65 */     CrossBattleKnockoutManager.broadcastFinalBulletin(physicalZoneId, sThirdBulltinInfo);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<String> getTitleContextArgsList(int fightZoneId)
/*     */   {
/*  71 */     List<String> contextArgList = new ArrayList();
/*  72 */     contextArgList.add(CrossBattleConsts.getInstance().cross_battle_session);
/*     */     
/*  74 */     long awardTime = getKnockOutEndTime(CrossBattleConsts.getInstance().CURRENT_ACTIVITY_CFG_ID);
/*  75 */     Calendar calendar = TimeCommonUtil.getCalendar(awardTime);
/*     */     
/*  77 */     contextArgList.add(String.valueOf(calendar.get(1)));
/*  78 */     contextArgList.add(String.valueOf(calendar.get(2) + 1));
/*  79 */     contextArgList.add(String.valueOf(calendar.get(5)));
/*  80 */     return contextArgList;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   void sendRankUpNextStageBulletionInfo(String corpsName, int physicalZoneId) {}
/*     */   
/*     */ 
/*     */ 
/*     */   void sendRankUpChampionStageBulletionInfo(String corpsName, int physicalZoneId)
/*     */   {
/*  92 */     SBulletinInfo sBulletinInfo = new SBulletinInfo();
/*  93 */     sBulletinInfo.bulletintype = 45;
/*  94 */     sBulletinInfo.params.put(Integer.valueOf(29), corpsName);
/*  95 */     sBulletinInfo.params.put(Integer.valueOf(33), String.valueOf(physicalZoneId));
/*     */     
/*  97 */     BulletinInterface.sendBulletin(sBulletinInfo);
/*     */     
/*  99 */     CrossBattleKnockoutManager.broadcastFinalBulletin(physicalZoneId, sBulletinInfo);
/*     */   }
/*     */   
/*     */ 
/*     */   void sendRankUpNextFightStageBulletionInfo(String corpsName, int maxFightIndexId)
/*     */   {
/* 105 */     SBulletinInfo sBulletinInfo = new SBulletinInfo();
/* 106 */     sBulletinInfo.bulletintype = 43;
/* 107 */     sBulletinInfo.params.put(Integer.valueOf(30), String.valueOf(maxFightIndexId));
/* 108 */     sBulletinInfo.params.put(Integer.valueOf(29), corpsName);
/*     */     
/* 110 */     BulletinInterface.sendBulletin(sBulletinInfo);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   Protocol getNotifyKnockOutBeginProtocol()
/*     */   {
/* 117 */     SNotifyFinalBegin sNotifyFinalBegin = new SNotifyFinalBegin();
/* 118 */     return sNotifyFinalBegin;
/*     */   }
/*     */   
/*     */ 
/*     */   List<String> getByeRankUpContextArgsList(KnockOutCfg knockOutCfg, int nowStage, int nextStage)
/*     */   {
/* 124 */     List<String> contextArgsList = new ArrayList();
/* 125 */     contextArgsList.add(knockOutCfg.stage_name_list.get(nowStage - 1));
/* 126 */     contextArgsList.add(knockOutCfg.stage_name_list.get(nextStage - 1));
/*     */     
/* 128 */     CrossBattleKnockoutInterface.fillNextStageTimeMailContextArgs(knockOutCfg, nextStage, contextArgsList);
/* 129 */     return contextArgsList;
/*     */   }
/*     */   
/*     */ 
/*     */   Protocol getEnterPrepareWorldProtocol(int leftSeconds)
/*     */   {
/* 135 */     SEnterCrossBattleFinalMapSuccess enterCrossBattleFinalMapSuccess = new SEnterCrossBattleFinalMapSuccess();
/* 136 */     enterCrossBattleFinalMapSuccess.left_seconds = leftSeconds;
/* 137 */     return enterCrossBattleFinalMapSuccess;
/*     */   }
/*     */   
/*     */ 
/*     */   Protocol getNotifyFightResult(int winOrLose, int isRankUp)
/*     */   {
/* 143 */     SLoginNotifyFinalFightRes loginNotifyFinalFightRes = new SLoginNotifyFinalFightRes();
/* 144 */     loginNotifyFinalFightRes.is_rank_up = isRankUp;
/* 145 */     loginNotifyFinalFightRes.ret = winOrLose;
/* 146 */     return loginNotifyFinalFightRes;
/*     */   }
/*     */   
/*     */ 
/*     */   long getKnockOutEndTime(int activityCfgId)
/*     */   {
/* 152 */     SActivityCfg activityCfg = SActivityCfg.get(activityCfgId);
/* 153 */     if (activityCfg == null)
/*     */     {
/* 155 */       return -1L;
/*     */     }
/*     */     
/* 158 */     SCrossBattleStageDurationCfg sCrossBattleStageDurationCfg = SCrossBattleStageDurationCfg.get(activityCfgId);
/* 159 */     if (sCrossBattleStageDurationCfg == null)
/*     */     {
/* 161 */       return -1L;
/*     */     }
/*     */     
/* 164 */     long activityStartTimestamp = TimeCommonUtil.getLimitTimeBegin(activityCfg.activityLimitTimeid);
/*     */     
/* 166 */     return activityStartTimestamp + (sCrossBattleStageDurationCfg.registerStageDurationInDay + sCrossBattleStageDurationCfg.voteStageDurationInDay + sCrossBattleStageDurationCfg.roundRobinStageDurationInDay + sCrossBattleStageDurationCfg.zoneDivideStageDurationInDay + sCrossBattleStageDurationCfg.zonePointStageDurationInDay + sCrossBattleStageDurationCfg.roundSelectionStageDurationInDay + sCrossBattleStageDurationCfg.roundFinalStageDurationInDay) * 86400000L;
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
/*     */   long getNextKnockOutGameStartTime(int activityCfgId)
/*     */   {
/* 179 */     SActivityCfg sActivityCfg = SActivityCfg.get(activityCfgId);
/* 180 */     if (sActivityCfg == null)
/*     */     {
/* 182 */       return -1L;
/*     */     }
/*     */     
/* 185 */     long activityEndTime = TimeCommonUtil.getLimitTimeEnd(sActivityCfg.activityLimitTimeid);
/*     */     
/* 187 */     return activityEndTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   List<String> getRestartKnockOutMailContextArgs(KnockOutCfg knockOutCfg, int fightZoneId, int fightStage, long opponentCorpsId, String opponentCorpsName, long prepareWorldBeginTime)
/*     */   {
/* 194 */     List<String> contextArgsList = new ArrayList();
/* 195 */     String fightStageName = (String)knockOutCfg.stage_name_list.get(fightStage - 1);
/*     */     
/* 197 */     contextArgsList.add(fightStageName);
/* 198 */     contextArgsList.add(opponentCorpsName);
/* 199 */     contextArgsList.add(String.valueOf(opponentCorpsId));
/*     */     
/* 201 */     Calendar calendar = TimeCommonUtil.getCalendar(prepareWorldBeginTime);
/*     */     
/* 203 */     contextArgsList.add(String.valueOf(calendar.get(1)));
/* 204 */     contextArgsList.add(String.valueOf(calendar.get(2) + 1));
/* 205 */     contextArgsList.add(String.valueOf(calendar.get(5)));
/* 206 */     contextArgsList.add(String.valueOf(calendar.get(11)));
/* 207 */     contextArgsList.add(String.format("%02d", new Object[] { Integer.valueOf(calendar.get(12)) }));
/* 208 */     return contextArgsList;
/*     */   }
/*     */   
/*     */ 
/*     */   long getKnockOutBeginTime(int activityCfgId)
/*     */   {
/* 214 */     SActivityCfg activityCfg = SActivityCfg.get(activityCfgId);
/* 215 */     if (activityCfg == null)
/*     */     {
/* 217 */       return -1L;
/*     */     }
/*     */     
/* 220 */     SCrossBattleStageDurationCfg sCrossBattleStageDurationCfg = SCrossBattleStageDurationCfg.get(activityCfgId);
/* 221 */     if (sCrossBattleStageDurationCfg == null)
/*     */     {
/* 223 */       return -1L;
/*     */     }
/*     */     
/* 226 */     long activityStartTimestamp = TimeCommonUtil.getLimitTimeBegin(activityCfg.activityLimitTimeid);
/*     */     
/* 228 */     return activityStartTimestamp + (sCrossBattleStageDurationCfg.registerStageDurationInDay + sCrossBattleStageDurationCfg.voteStageDurationInDay + sCrossBattleStageDurationCfg.roundRobinStageDurationInDay + sCrossBattleStageDurationCfg.zoneDivideStageDurationInDay + sCrossBattleStageDurationCfg.zonePointStageDurationInDay + sCrossBattleStageDurationCfg.roundSelectionStageDurationInDay) * 86400000L;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   long getCanGetKnockOutInfoTime(int activityCfgId)
/*     */   {
/* 240 */     SCrossBattleKnockOutCfg sCrossBattleKnockOutCfg = SCrossBattleKnockOutCfg.get(activityCfgId);
/* 241 */     if (sCrossBattleKnockOutCfg == null)
/*     */     {
/* 243 */       return Long.MAX_VALUE;
/*     */     }
/*     */     
/* 246 */     KnockOutCfg knockOutCfg = (KnockOutCfg)sCrossBattleKnockOutCfg.knockOutTypeCfgMap.get(Integer.valueOf(1));
/* 247 */     if (knockOutCfg == null)
/*     */     {
/* 249 */       return Long.MAX_VALUE;
/*     */     }
/*     */     
/* 252 */     int stageSize = knockOutCfg.stage_time_point_cfg_id_list.size();
/* 253 */     int lastTimePointCfgId = ((Integer)knockOutCfg.stage_time_point_cfg_id_list.get(stageSize - 1)).intValue();
/* 254 */     STimePointCommonCfg sTimePointCommonCfg = STimePointCommonCfg.get(lastTimePointCfgId);
/* 255 */     if (sTimePointCommonCfg == null)
/*     */     {
/* 257 */       return Long.MAX_VALUE;
/*     */     }
/*     */     
/* 260 */     return TimeCommonUtil.getTimePoint(sTimePointCommonCfg) + (knockOutCfg.fight_last_time + 60) * 60000L;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\knockout\KnockOutFinalHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
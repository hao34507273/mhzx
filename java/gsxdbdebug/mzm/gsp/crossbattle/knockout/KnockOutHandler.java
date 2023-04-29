/*     */ package mzm.gsp.crossbattle.knockout;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.List;
/*     */ import mzm.gsp.common.TimeCommonUtil;
/*     */ import mzm.gsp.crossbattle.confbean.CrossBattleConsts;
/*     */ import mzm.gsp.crossbattle.confbean.KnockOutCfg;
/*     */ import xio.Protocol;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class KnockOutHandler
/*     */ {
/*     */   abstract long getKnockOutBeginTime(int paramInt);
/*     */   
/*     */   abstract void sendChampionBulletionInfo(String paramString, int paramInt1, int paramInt2);
/*     */   
/*     */   abstract void sendSecondPlaceBulletionInfo(String paramString, int paramInt1, int paramInt2);
/*     */   
/*     */   abstract void sendThirdPlaceBulletionInfo(String paramString, int paramInt1, int paramInt2);
/*     */   
/*     */   abstract void sendRankUpNextStageBulletionInfo(String paramString, int paramInt);
/*     */   
/*     */   abstract void sendRankUpChampionStageBulletionInfo(String paramString, int paramInt);
/*     */   
/*     */   abstract void sendRankUpNextFightStageBulletionInfo(String paramString, int paramInt);
/*     */   
/*     */   abstract List<String> getTitleContextArgsList(int paramInt);
/*     */   
/*     */   List<String> getAbstainKnockOutMailContextArgsList(long opponentCorpsId, String opponentCorpsName, int maxFightIndex)
/*     */   {
/*  72 */     List<String> contextArgsList = new ArrayList();
/*  73 */     contextArgsList.add(opponentCorpsName);
/*  74 */     contextArgsList.add(String.valueOf(opponentCorpsId));
/*     */     
/*  76 */     contextArgsList.add(String.valueOf(maxFightIndex * 2));
/*  77 */     long awardTime = getKnockOutEndTime(CrossBattleConsts.getInstance().CURRENT_ACTIVITY_CFG_ID);
/*  78 */     Calendar calendar = TimeCommonUtil.getCalendar(awardTime);
/*     */     
/*  80 */     contextArgsList.add(String.valueOf(calendar.get(1)));
/*  81 */     contextArgsList.add(String.valueOf(calendar.get(2) + 1));
/*  82 */     contextArgsList.add(String.valueOf(calendar.get(5)));
/*  83 */     return contextArgsList;
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
/*     */   abstract Protocol getNotifyKnockOutBeginProtocol();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   abstract Protocol getEnterPrepareWorldProtocol(int paramInt);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   abstract List<String> getByeRankUpContextArgsList(KnockOutCfg paramKnockOutCfg, int paramInt1, int paramInt2);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   List<String> getWinRoundMailContextArgsList(KnockOutCfg knockOutCfg, int winScore, int failScore, int nextStage, String opponentCorpsName, long opponentCorpsId, boolean isSignalFightRule)
/*     */   {
/* 127 */     List<String> contextArgList = new ArrayList();
/* 128 */     contextArgList.add(opponentCorpsName);
/* 129 */     contextArgList.add(String.valueOf(opponentCorpsId));
/*     */     
/* 131 */     if (!isSignalFightRule)
/*     */     {
/* 133 */       contextArgList.add(String.format("%d:%d", new Object[] { Integer.valueOf(winScore), Integer.valueOf(failScore) }));
/*     */     }
/*     */     
/* 136 */     String stageName = (String)knockOutCfg.stage_name_list.get(nextStage - 1);
/* 137 */     contextArgList.add(stageName);
/*     */     
/* 139 */     CrossBattleKnockoutInterface.fillNextStageTimeMailContextArgs(knockOutCfg, nextStage, contextArgList);
/*     */     
/* 141 */     return contextArgList;
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
/*     */ 
/*     */   List<String> get4To2FailMailCOntextArgsList(KnockOutCfg knockOutCfg, int winScore, int failScore, int nextStage, String opponentCorpsName, long opponentCorpsId, boolean isSignalFightRule)
/*     */   {
/* 165 */     List<String> contextArgList = new ArrayList();
/* 166 */     contextArgList.add(opponentCorpsName);
/* 167 */     contextArgList.add(String.valueOf(opponentCorpsId));
/*     */     
/* 169 */     if (!isSignalFightRule)
/*     */     {
/* 171 */       contextArgList.add(String.format("%d:%d", new Object[] { Integer.valueOf(failScore), Integer.valueOf(winScore) }));
/*     */     }
/*     */     
/* 174 */     CrossBattleKnockoutInterface.fillNextStageTimeMailContextArgs(knockOutCfg, nextStage, contextArgList);
/*     */     
/* 176 */     return contextArgList;
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
/*     */   List<String> getFailRoundMailContextArgsList(int winScore, int failScore, String opponentCorpsName, long opponentCorpsId, int nowMaxFightIndexId, boolean isSignalFightRule)
/*     */   {
/* 197 */     List<String> contextArgList = new ArrayList();
/* 198 */     contextArgList.add(opponentCorpsName);
/* 199 */     contextArgList.add(String.valueOf(opponentCorpsId));
/*     */     
/* 201 */     if (!isSignalFightRule)
/*     */     {
/* 203 */       contextArgList.add(String.format("%d:%d", new Object[] { Integer.valueOf(failScore), Integer.valueOf(winScore) }));
/*     */     }
/*     */     
/* 206 */     contextArgList.add(String.valueOf(nowMaxFightIndexId * 2));
/*     */     
/* 208 */     long awardTime = getKnockOutEndTime(CrossBattleConsts.getInstance().CURRENT_ACTIVITY_CFG_ID);
/* 209 */     Calendar calendar = TimeCommonUtil.getCalendar(awardTime);
/*     */     
/* 211 */     contextArgList.add(String.valueOf(calendar.get(1)));
/* 212 */     contextArgList.add(String.valueOf(calendar.get(2) + 1));
/* 213 */     contextArgList.add(String.valueOf(calendar.get(5)));
/* 214 */     return contextArgList;
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
/*     */   List<String> getFightMailContxtArgsList(KnockOutCfg knockOutCfg, int nowStage, String opponentCorpsName, long opponentCorpsId)
/*     */   {
/* 235 */     List<String> contextArgsList = new ArrayList();
/* 236 */     contextArgsList.add(opponentCorpsName);
/* 237 */     contextArgsList.add(String.valueOf(opponentCorpsId));
/*     */     
/* 239 */     String nowStageName = (String)knockOutCfg.stage_name_list.get(nowStage - 1);
/* 240 */     contextArgsList.add(nowStageName);
/*     */     
/* 242 */     String nextStageName = (String)knockOutCfg.stage_name_list.get(nowStage);
/* 243 */     contextArgsList.add(nextStageName);
/*     */     
/* 245 */     CrossBattleKnockoutInterface.fillNextStageTimeMailContextArgs(knockOutCfg, nowStage + 1, contextArgsList);
/*     */     
/* 247 */     return contextArgsList;
/*     */   }
/*     */   
/*     */   List<String> getAwardMailContextArgsList(KnockOutCfg knockOutCfg, int nowMailTitleIndex)
/*     */   {
/* 252 */     List<String> contextArgsList = new ArrayList();
/*     */     
/* 254 */     contextArgsList.add(CrossBattleConsts.getInstance().cross_battle_session);
/*     */     
/* 256 */     contextArgsList.add(knockOutCfg.stage_award_mail_title_list.get(nowMailTitleIndex - 1));
/*     */     
/* 258 */     return contextArgsList;
/*     */   }
/*     */   
/*     */   abstract Protocol getNotifyFightResult(int paramInt1, int paramInt2);
/*     */   
/*     */   abstract long getKnockOutEndTime(int paramInt);
/*     */   
/*     */   abstract long getNextKnockOutGameStartTime(int paramInt);
/*     */   
/*     */   abstract List<String> getRestartKnockOutMailContextArgs(KnockOutCfg paramKnockOutCfg, int paramInt1, int paramInt2, long paramLong1, String paramString, long paramLong2);
/*     */   
/*     */   abstract long getCanGetKnockOutInfoTime(int paramInt);
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\knockout\KnockOutHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
/*     */ package mzm.gsp.crossbattle.knockout;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.crossbattle.GetKnockOutContext;
/*     */ import mzm.gsp.crossbattle.GetKnockOutContext_ReportFightResult;
/*     */ import mzm.gsp.crossbattle.confbean.KnockOutCfg;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattleKnockOutCfg;
/*     */ import mzm.gsp.crossbattle.event.KnockOutFightEnd;
/*     */ import mzm.gsp.crossbattle.event.KnockOutFightEndArg;
/*     */ import mzm.gsp.crossbattle.event.KnockOutFinalChampionBorn;
/*     */ import mzm.gsp.crossbattle.event.KnockOutFinalChampionBornArg;
/*     */ import mzm.gsp.crossbattle.event.KnockOutSignalFightEnd;
/*     */ import mzm.gsp.crossbattle.event.KnockOutSignalFightEndArg;
/*     */ import mzm.gsp.crossbattle.own.CrossBattleOwnInterface;
/*     */ import mzm.gsp.crossbattle.point.CrossBattlePointInterface;
/*     */ import mzm.gsp.grc.main.GrcInterface;
/*     */ import mzm.gsp.mail.main.MailAttachment;
/*     */ import mzm.gsp.mail.main.MailInterface;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.Pair;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.CrossBattleKnockoutActivityInfo;
/*     */ import xbean.CrossBattleKnockoutInfo;
/*     */ import xbean.FightAgainstInfo;
/*     */ import xbean.FightCorpsInfo;
/*     */ import xbean.FightStageInfo;
/*     */ import xbean.FightZoneInfo;
/*     */ import xdb.Executor;
/*     */ import xdb.Xdb;
/*     */ import xtable.Cross_battle_knockout;
/*     */ import xtable.Role2properties;
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
/*     */ public class POnReportKnockOutFightResult
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final int activityCfgId;
/*     */   private final int knockOutType;
/*     */   private final int fightZoneId;
/*     */   private final int fightStage;
/*     */   private final int fightIndexId;
/*     */   private final long corpsId;
/*     */   private final String ownCorpsName;
/*     */   private final long opponentCorpsId;
/*     */   private final String opponentCorpsName;
/*     */   private final int corpsFightResult;
/*     */   private final int repeatTimes;
/*     */   
/*     */   public POnReportKnockOutFightResult(int activityCfgId, int knockOutType, int fightZoneId, int fightStage, int fightIndexId, long corpsId, String ownCorpsName, long opponentCorpsId, String opponentCorpsName, int corpsFightResult, int repeatTimes)
/*     */   {
/*  99 */     this.activityCfgId = activityCfgId;
/* 100 */     this.knockOutType = knockOutType;
/* 101 */     this.fightZoneId = fightZoneId;
/* 102 */     this.fightStage = fightStage;
/* 103 */     this.fightIndexId = fightIndexId;
/* 104 */     this.corpsId = corpsId;
/* 105 */     this.ownCorpsName = ownCorpsName;
/* 106 */     this.opponentCorpsId = opponentCorpsId;
/* 107 */     this.opponentCorpsName = opponentCorpsName;
/* 108 */     this.corpsFightResult = corpsFightResult;
/* 109 */     this.repeatTimes = repeatTimes;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/* 115 */     List<Long> roleIdList = CrossBattleOwnInterface.getCrossBattleRegisterRoleList(this.corpsId, this.activityCfgId, false);
/*     */     
/* 117 */     if (roleIdList == null)
/*     */     {
/* 119 */       reportLog(-1);
/* 120 */       return false;
/*     */     }
/* 122 */     lock(Role2properties.getTable(), roleIdList);
/*     */     
/* 124 */     SCrossBattleKnockOutCfg sCrossBattleKnockOutCfg = SCrossBattleKnockOutCfg.get(this.activityCfgId);
/* 125 */     if (sCrossBattleKnockOutCfg == null)
/*     */     {
/* 127 */       reportLog(-2);
/* 128 */       return false;
/*     */     }
/*     */     
/* 131 */     KnockOutCfg knockOutCfg = (KnockOutCfg)sCrossBattleKnockOutCfg.knockOutTypeCfgMap.get(Integer.valueOf(this.knockOutType));
/* 132 */     if (knockOutCfg == null)
/*     */     {
/* 134 */       reportLog(-3);
/* 135 */       return false;
/*     */     }
/*     */     
/* 138 */     long globalActivityCfgid = GameServerInfoManager.toGlobalId(this.activityCfgId);
/* 139 */     CrossBattleKnockoutActivityInfo xCrossBattleKnockoutActivityInfo = Cross_battle_knockout.get(Long.valueOf(globalActivityCfgid));
/* 140 */     if (xCrossBattleKnockoutActivityInfo == null)
/*     */     {
/* 142 */       reportLog(-4);
/* 143 */       return false;
/*     */     }
/*     */     
/* 146 */     CrossBattleKnockoutInfo xCrossBattleKnockoutInfo = (CrossBattleKnockoutInfo)xCrossBattleKnockoutActivityInfo.getKnockout_info_map().get(Integer.valueOf(this.knockOutType));
/*     */     
/* 148 */     if (xCrossBattleKnockoutInfo == null)
/*     */     {
/* 150 */       reportLog(-5);
/* 151 */       return false;
/*     */     }
/*     */     
/* 154 */     FightZoneInfo xFightZoneInfo = (FightZoneInfo)xCrossBattleKnockoutInfo.getFight_zone_info_map().get(Integer.valueOf(this.fightZoneId));
/* 155 */     if (xFightZoneInfo == null)
/*     */     {
/* 157 */       reportLog(-6);
/* 158 */       return false;
/*     */     }
/*     */     
/* 161 */     FightStageInfo xFightStageInfo = (FightStageInfo)xFightZoneInfo.getFight_stage_info_map().get(Integer.valueOf(this.fightStage));
/* 162 */     if (xFightStageInfo == null)
/*     */     {
/* 164 */       reportLog(-7);
/* 165 */       return false;
/*     */     }
/*     */     
/* 168 */     FightAgainstInfo xFightAgainstInfo = (FightAgainstInfo)xFightStageInfo.getFight_against_info_map().get(Integer.valueOf(this.fightIndexId));
/* 169 */     if (xFightAgainstInfo == null)
/*     */     {
/* 171 */       reportLog(-8);
/* 172 */       return false;
/*     */     }
/*     */     
/* 175 */     int corpsFightResult = 0;
/* 176 */     if (xFightAgainstInfo.getA_corps_id() == this.corpsId)
/*     */     {
/* 178 */       corpsFightResult = xFightAgainstInfo.getA_corps_id_result();
/*     */     }
/* 180 */     else if (xFightAgainstInfo.getB_corps_id() == this.corpsId)
/*     */     {
/* 182 */       corpsFightResult = xFightAgainstInfo.getB_corps_id_result();
/*     */     }
/*     */     
/* 185 */     if (corpsFightResult == 0)
/*     */     {
/* 187 */       reportLog(-9);
/* 188 */       return false;
/*     */     }
/*     */     
/* 191 */     FightCorpsInfo xFightCorpsInfo = (FightCorpsInfo)xFightZoneInfo.getFight_corps_info_map().get(Long.valueOf(this.corpsId));
/* 192 */     if (xFightCorpsInfo == null)
/*     */     {
/* 194 */       reportLog(-100);
/* 195 */       return false;
/*     */     }
/*     */     
/* 198 */     long corpsIdA = xFightAgainstInfo.getA_corps_id();
/* 199 */     long corpsIdB = xFightAgainstInfo.getB_corps_id();
/*     */     
/* 201 */     if (xFightAgainstInfo.getCal_fight_result() == 0)
/*     */     {
/* 203 */       if (this.repeatTimes < 10)
/*     */       {
/* 205 */         Xdb.executor().schedule(new RRepeatCheckResult(this.activityCfgId, this.knockOutType, this.fightZoneId, this.fightStage, this.fightIndexId, this.corpsId, this.opponentCorpsName, this.ownCorpsName, this.opponentCorpsId, corpsFightResult, this.repeatTimes + 1), 5000L, TimeUnit.MILLISECONDS);
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 212 */       reportLog(-10);
/* 213 */       return false;
/*     */     }
/*     */     
/* 216 */     Pair<Long, Pair<Integer, Integer>> winCorpsIdPair = CrossBattleKnockoutManager.getWinCorpsId(xFightZoneInfo.getFight_stage_info_map(), corpsIdA, corpsIdB, this.fightStage, this.fightIndexId, knockOutCfg.fight_times_every_stage);
/*     */     
/*     */ 
/* 219 */     if (winCorpsIdPair == null)
/*     */     {
/* 221 */       reportLog(-11);
/* 222 */       return false;
/*     */     }
/*     */     
/* 225 */     if ((((Long)winCorpsIdPair.first).longValue() == -1L) && (this.fightStage % knockOutCfg.fight_times_every_stage == 0))
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 233 */       int mySocre = 0;
/* 234 */       int opponentScore = 0;
/* 235 */       if (corpsIdA == this.corpsId)
/*     */       {
/* 237 */         mySocre = ((Integer)((Pair)winCorpsIdPair.second).first).intValue();
/* 238 */         opponentScore = ((Integer)((Pair)winCorpsIdPair.second).second).intValue();
/*     */       }
/* 240 */       else if (corpsIdB == this.corpsId)
/*     */       {
/* 242 */         mySocre = ((Integer)((Pair)winCorpsIdPair.second).second).intValue();
/* 243 */         opponentScore = ((Integer)((Pair)winCorpsIdPair.second).first).intValue();
/*     */       }
/*     */       
/* 246 */       handleRoundResultEmail(knockOutCfg, roleIdList, false, mySocre, opponentScore, this.fightStage, knockOutCfg.stage_name_list.size(), knockOutCfg.fight_times_every_stage, xFightCorpsInfo.getCorps_zone_id(), true);
/*     */ 
/*     */ 
/*     */ 
/*     */     }
/* 251 */     else if (((Long)winCorpsIdPair.first).longValue() == -1L)
/*     */     {
/* 253 */       long fightWinCorpsId = CrossBattleKnockoutManager.getWinCorpsId(xFightAgainstInfo);
/* 254 */       if (fightWinCorpsId < 0L)
/*     */       {
/* 256 */         handleAbstainEmail(knockOutCfg, roleIdList, false, this.fightStage, knockOutCfg.stage_name_list.size(), knockOutCfg.fight_times_every_stage);
/*     */ 
/*     */       }
/* 259 */       else if ((xFightAgainstInfo.getCal_fight_result() == FightResultEnum.A_ABSTAIN_WIN.fightResult) || (xFightAgainstInfo.getCal_fight_result() == FightResultEnum.A_ABSTAIN_LOSE.fightResult))
/*     */       {
/*     */ 
/* 262 */         handleAbstainEmail(knockOutCfg, roleIdList, fightWinCorpsId == this.corpsId, this.fightStage, knockOutCfg.stage_name_list.size(), knockOutCfg.fight_times_every_stage);
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/* 267 */         handleFightResultEmail(knockOutCfg, roleIdList, fightWinCorpsId == this.corpsId, this.fightStage, knockOutCfg.stage_name_list.size(), knockOutCfg.fight_times_every_stage);
/*     */       }
/*     */       
/*     */ 
/*     */     }
/* 272 */     else if (((Long)winCorpsIdPair.first).longValue() == this.corpsId)
/*     */     {
/* 274 */       handleRoundResultEmail(knockOutCfg, roleIdList, true, ((Integer)((Pair)winCorpsIdPair.second).first).intValue(), ((Integer)((Pair)winCorpsIdPair.second).second).intValue(), this.fightStage, knockOutCfg.stage_name_list.size(), knockOutCfg.fight_times_every_stage, xFightCorpsInfo.getCorps_zone_id(), false);
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/*     */ 
/* 280 */       handleRoundResultEmail(knockOutCfg, roleIdList, false, ((Integer)((Pair)winCorpsIdPair.second).first).intValue(), ((Integer)((Pair)winCorpsIdPair.second).second).intValue(), this.fightStage, knockOutCfg.stage_name_list.size(), knockOutCfg.fight_times_every_stage, xFightCorpsInfo.getCorps_zone_id(), false);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 285 */     Map<String, Object> extraMap = new HashMap();
/* 286 */     extraMap.put("win_corps_id", winCorpsIdPair.first);
/* 287 */     extraMap.put("win_score", ((Pair)winCorpsIdPair.second).first);
/* 288 */     extraMap.put("lost_score", ((Pair)winCorpsIdPair.second).second);
/*     */     
/* 290 */     reportLog(1, extraMap);
/*     */     
/* 292 */     new PKickOutInstance(roleIdList, knockOutCfg).execute();
/*     */     
/* 294 */     boolean isWin = CrossBattleKnockoutManager.isWinByFightResult(corpsFightResult);
/* 295 */     KnockOutSignalFightEndArg knockOutSignalFightEndArg = new KnockOutSignalFightEndArg(this.activityCfgId, this.corpsId, this.knockOutType, this.fightStage, isWin);
/*     */     
/*     */ 
/*     */ 
/* 299 */     TriggerEventsManger.getInstance().triggerEvent(new KnockOutSignalFightEnd(), knockOutSignalFightEndArg);
/* 300 */     return true;
/*     */   }
/*     */   
/*     */   private void reportLog(int ret)
/*     */   {
/* 305 */     reportLog(ret, null);
/*     */   }
/*     */   
/*     */ 
/*     */   private void reportLog(int ret, Map<String, Object> extraMap)
/*     */   {
/* 311 */     StringBuilder sBuilder = new StringBuilder();
/* 312 */     sBuilder.append("[crossbattle_knockout]POnReportKnockOutFightResult.processImp@handle report knock out fight result");
/* 313 */     sBuilder.append("|ret=").append(ret);
/* 314 */     sBuilder.append("|activity_cfg_id=").append(this.activityCfgId);
/* 315 */     sBuilder.append("|knock_out_type=").append(this.knockOutType);
/* 316 */     sBuilder.append("|fight_zone_id=").append(this.fightZoneId);
/* 317 */     sBuilder.append("|fight_stage=").append(this.fightStage);
/* 318 */     sBuilder.append("|fight_index_id=").append(this.fightIndexId);
/* 319 */     sBuilder.append("|corps_id=").append(this.corpsId);
/* 320 */     sBuilder.append("|own_corps_name").append(this.ownCorpsName);
/* 321 */     sBuilder.append("|opponent_corps_id=").append(this.opponentCorpsId);
/* 322 */     sBuilder.append("|opponent_corps_name=").append(this.opponentCorpsName);
/* 323 */     sBuilder.append("|corps_fight_result=").append(this.corpsFightResult);
/* 324 */     sBuilder.append("|repeat_times=").append(this.repeatTimes);
/*     */     
/* 326 */     if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */     {
/* 328 */       for (Map.Entry<String, Object> entry : extraMap.entrySet())
/*     */       {
/* 330 */         sBuilder.append("|").append((String)entry.getKey()).append("=").append(entry.getValue());
/*     */       }
/*     */     }
/*     */     
/* 334 */     GameServer.logger().info(sBuilder.toString());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void handleAbstainKnockOutEmail(KnockOutCfg knockOutCfg, List<Long> roleIdList)
/*     */   {
/* 346 */     KnockOutHandler knockOutHandler = CrossBattleKnockoutManager.getKnockOutHandler(this.knockOutType);
/* 347 */     if (knockOutHandler == null)
/*     */     {
/* 349 */       reportLog(-13);
/* 350 */       return;
/*     */     }
/*     */     
/* 353 */     int maxFightIndex = CrossBattleKnockoutManager.getMaxFightIndexId(knockOutCfg.need_team_size, this.fightStage, knockOutCfg.fight_times_every_stage);
/*     */     
/* 355 */     if (maxFightIndex < 0)
/*     */     {
/* 357 */       reportLog(-14);
/* 358 */       return;
/*     */     }
/*     */     
/* 361 */     List<String> contextArgsList = knockOutHandler.getAbstainKnockOutMailContextArgsList(this.opponentCorpsId, this.opponentCorpsName, maxFightIndex);
/*     */     
/* 363 */     int mailCfgId = knockOutCfg.abstain_knock_out_mail_cfg_id;
/*     */     
/* 365 */     for (Iterator i$ = roleIdList.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/* 367 */       MailInterface.synBuildAndSendMail(roleId, mailCfgId, null, contextArgsList, new TLogArg(LogReason.CROSS_BATTLE_KNOCK_OUT_FAIL, this.knockOutType));
/*     */     }
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
/*     */   private void handleAbstainEmail(KnockOutCfg knockOutCfg, List<Long> roleIdList, boolean isWin, int nowFightStage, int maxFightStage, int fightTimesEveryRound)
/*     */   {
/* 381 */     KnockOutHandler knockOutHandler = CrossBattleKnockoutManager.getKnockOutHandler(this.knockOutType);
/* 382 */     if (knockOutHandler == null)
/*     */     {
/* 384 */       reportLog(-13);
/* 385 */       return;
/*     */     }
/*     */     
/* 388 */     int maxFightIndex = CrossBattleKnockoutManager.getMaxFightIndexId(knockOutCfg.need_team_size, this.fightStage, knockOutCfg.fight_times_every_stage);
/*     */     
/* 390 */     if (maxFightIndex < 0)
/*     */     {
/* 392 */       reportLog(-14);
/* 393 */       return;
/*     */     }
/*     */     
/* 396 */     TLogArg tLogArg = isWin ? new TLogArg(LogReason.CROSS_BATTLE_KNOCK_OUT_WIN, this.knockOutType) : new TLogArg(LogReason.CROSS_BATTLE_KNOCK_OUT_FAIL, this.knockOutType);
/*     */     
/*     */ 
/* 399 */     int mailCfgId = isWin ? knockOutCfg.abstain_win_mail_cfg_id : knockOutCfg.abstain_lose_mail_cfg_id;
/* 400 */     List<String> contextArgsList = knockOutHandler.getFightMailContxtArgsList(knockOutCfg, nowFightStage, this.opponentCorpsName, this.opponentCorpsId);
/*     */     
/*     */ 
/* 403 */     for (Iterator i$ = roleIdList.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/* 405 */       MailInterface.synBuildAndSendMail(roleId, mailCfgId, null, contextArgsList, tLogArg);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private void handleFightResultEmail(KnockOutCfg knockOutCfg, List<Long> roleIdList, boolean isWin, int nowFightStage, int maxFightStage, int fightTimesEveryRound)
/*     */   {
/* 412 */     KnockOutHandler fightEndHandler = CrossBattleKnockoutManager.getKnockOutHandler(this.knockOutType);
/* 413 */     if (fightEndHandler == null)
/*     */     {
/* 415 */       reportLog(-15);
/* 416 */       return;
/*     */     }
/*     */     
/* 419 */     TLogArg tLogArg = isWin ? new TLogArg(LogReason.CROSS_BATTLE_KNOCK_OUT_WIN, this.knockOutType) : new TLogArg(LogReason.CROSS_BATTLE_KNOCK_OUT_FAIL, this.knockOutType);
/*     */     
/*     */ 
/* 422 */     int mailCfgId = isWin ? knockOutCfg.fight_win_mail_cfg_id : knockOutCfg.fight_lose_mail_cfg_id;
/* 423 */     List<String> contextArgList = fightEndHandler.getFightMailContxtArgsList(knockOutCfg, nowFightStage, this.opponentCorpsName, this.opponentCorpsId);
/*     */     
/*     */ 
/*     */ 
/* 427 */     for (Iterator i$ = roleIdList.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/* 429 */       MailInterface.synBuildAndSendMail(roleId, mailCfgId, null, contextArgList, new MailAttachment(), tLogArg);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void handleRoundResultEmail(KnockOutCfg knockOutCfg, List<Long> roleIdList, boolean isWin, int winScore, int failScore, int nowFightStage, int maxFightStage, int fightTimesEveryRound, int physicalZoneId, boolean isDraw)
/*     */   {
/* 439 */     int nowMaxFightIndexId = CrossBattleKnockoutInterface.getKnockOutStageFightNum(this.activityCfgId, this.knockOutType, this.fightStage);
/*     */     
/*     */ 
/* 442 */     KnockOutHandler fightEndHandler = CrossBattleKnockoutManager.getKnockOutHandler(this.knockOutType);
/* 443 */     if (fightEndHandler == null)
/*     */     {
/* 445 */       reportLog(-16);
/* 446 */       return;
/*     */     }
/*     */     
/* 449 */     int fightZoneId = CrossBattleKnockoutManager.getFightZone(this.corpsId, this.activityCfgId, this.knockOutType);
/* 450 */     if (fightZoneId < 0)
/*     */     {
/* 452 */       reportLog(-17);
/* 453 */       return;
/*     */     }
/*     */     
/*     */ 
/* 457 */     boolean isSignalFightRule = fightTimesEveryRound == 1;
/*     */     
/* 459 */     TLogArg tLogArg = isWin ? new TLogArg(LogReason.CROSS_BATTLE_KNOCK_OUT_WIN, this.knockOutType) : new TLogArg(LogReason.CROSS_BATTLE_KNOCK_OUT_FAIL, this.knockOutType);
/*     */     
/*     */ 
/* 462 */     List<String> contextArgList = null;
/*     */     
/* 464 */     int nowFightRound = (nowFightStage - 1) / fightTimesEveryRound + 1;
/* 465 */     int maxRound = maxFightStage / fightTimesEveryRound;
/*     */     
/* 467 */     boolean isThirdStage = nowFightRound == maxRound - 1;
/* 468 */     boolean isChampionStage = nowFightRound == maxRound;
/* 469 */     boolean is4_to_2Stage = nowFightRound == maxRound - 2;
/* 470 */     boolean is8_to_4Stage = nowFightRound == maxRound - 3;
/*     */     
/* 472 */     int mailCfgId = 0;
/* 473 */     int nextStage = 0;
/* 474 */     if ((isThirdStage) || (isChampionStage))
/*     */     {
/* 476 */       contextArgList = fightEndHandler.getTitleContextArgsList(fightZoneId);
/*     */       
/* 478 */       if (isThirdStage)
/*     */       {
/* 480 */         mailCfgId = isWin ? knockOutCfg.third_place_mail_cfg_id : knockOutCfg.last_winner_mail_cfg_id;
/*     */       }
/*     */       else
/*     */       {
/* 484 */         mailCfgId = isWin ? knockOutCfg.champion_mail_cfg_id : knockOutCfg.second_place_mail_cfg_id;
/*     */       }
/*     */     }
/* 487 */     else if ((is4_to_2Stage) && (!isDraw))
/*     */     {
/* 489 */       if (isWin)
/*     */       {
/*     */ 
/*     */ 
/* 493 */         nextStage = (nowFightRound + 1) * fightTimesEveryRound + 1;
/* 494 */         mailCfgId = knockOutCfg.rank_up_mail_cfg_id;
/* 495 */         contextArgList = fightEndHandler.getWinRoundMailContextArgsList(knockOutCfg, winScore, failScore, nextStage, this.opponentCorpsName, this.opponentCorpsId, isSignalFightRule);
/*     */ 
/*     */       }
/* 498 */       else if (!isDraw)
/*     */       {
/*     */ 
/*     */ 
/* 502 */         nextStage = nowFightRound * fightTimesEveryRound + 1;
/* 503 */         mailCfgId = knockOutCfg._4_to_2_fail_mail_cfg_id;
/* 504 */         contextArgList = fightEndHandler.get4To2FailMailCOntextArgsList(knockOutCfg, winScore, failScore, nextStage, this.opponentCorpsName, this.opponentCorpsId, isSignalFightRule);
/*     */       }
/*     */       
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 511 */       if ((isSignalFightRule) && ((this.corpsFightResult == SignalFightResultEnum.ABSTAIN_LOSE.fightResult) || (this.corpsFightResult == SignalFightResultEnum.ABSTAIN_WIN.fightResult)))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 516 */         mailCfgId = isWin ? knockOutCfg.abstain_rank_up_mail_cfg_id : knockOutCfg.abstain_knock_out_mail_cfg_id;
/*     */       }
/*     */       else
/*     */       {
/* 520 */         mailCfgId = isWin ? knockOutCfg.rank_up_mail_cfg_id : knockOutCfg.konck_out_mail_cfg_id;
/*     */       }
/*     */       
/* 523 */       if (isWin)
/*     */       {
/* 525 */         nextStage = nowFightRound * fightTimesEveryRound + 1;
/* 526 */         contextArgList = fightEndHandler.getWinRoundMailContextArgsList(knockOutCfg, winScore, failScore, nextStage, this.opponentCorpsName, this.opponentCorpsId, isSignalFightRule);
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/* 531 */         contextArgList = fightEndHandler.getFailRoundMailContextArgsList(winScore, failScore, this.opponentCorpsName, this.opponentCorpsId, nowMaxFightIndexId, isSignalFightRule);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 538 */     for (Iterator i$ = roleIdList.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/* 540 */       MailInterface.synBuildAndSendMail(roleId, mailCfgId, null, contextArgList, new MailAttachment(), tLogArg);
/*     */     }
/*     */     
/* 543 */     if (isChampionStage)
/*     */     {
/*     */ 
/* 546 */       if (isWin)
/*     */       {
/* 548 */         fightEndHandler.sendChampionBulletionInfo(this.ownCorpsName, this.fightZoneId, physicalZoneId);
/*     */       }
/*     */       else
/*     */       {
/* 552 */         fightEndHandler.sendSecondPlaceBulletionInfo(this.ownCorpsName, this.fightZoneId, physicalZoneId);
/*     */       }
/*     */       
/* 555 */       if (((!isWin) && (isDraw)) || (isWin))
/*     */       {
/* 557 */         KnockOutFinalChampionBornArg arg = new KnockOutFinalChampionBornArg();
/* 558 */         TriggerEventsManger.getInstance().triggerEvent(new KnockOutFinalChampionBorn(), arg);
/*     */       }
/*     */       
/*     */     }
/* 562 */     else if (isThirdStage)
/*     */     {
/* 564 */       if (isWin)
/*     */       {
/* 566 */         fightEndHandler.sendThirdPlaceBulletionInfo(this.ownCorpsName, this.fightZoneId, physicalZoneId);
/*     */       }
/*     */     }
/* 569 */     else if (is4_to_2Stage)
/*     */     {
/* 571 */       if (isWin)
/*     */       {
/* 573 */         fightEndHandler.sendRankUpChampionStageBulletionInfo(this.ownCorpsName, physicalZoneId);
/*     */ 
/*     */       }
/*     */       
/*     */ 
/*     */     }
/* 579 */     else if (isWin)
/*     */     {
/* 581 */       fightEndHandler.sendRankUpNextFightStageBulletionInfo(this.ownCorpsName, nowMaxFightIndexId);
/*     */     }
/*     */     
/*     */ 
/* 585 */     int zoneNum = CrossBattlePointInterface.getZoneNum();
/* 586 */     if (((knockOutCfg.need_team_size / zoneNum == 4) && (is8_to_4Stage)) || ((knockOutCfg.need_team_size / zoneNum == 2) && (is4_to_2Stage)))
/*     */     {
/*     */ 
/* 589 */       if (isWin)
/*     */       {
/* 591 */         fightEndHandler.sendRankUpNextStageBulletionInfo(this.ownCorpsName, physicalZoneId);
/*     */       }
/*     */     }
/*     */     
/* 595 */     int rank = 0;
/* 596 */     if (isThirdStage)
/*     */     {
/* 598 */       rank = 3;
/*     */     }
/* 600 */     else if (isChampionStage)
/*     */     {
/* 602 */       rank = 1;
/*     */     }
/*     */     else
/*     */     {
/* 606 */       rank = nowMaxFightIndexId * 2;
/*     */     }
/*     */     
/* 609 */     KnockOutFightEndArg knockOutFinalFightEndArg = new KnockOutFightEndArg(this.corpsId, this.knockOutType, this.fightZoneId, rank, isWin, isDraw);
/*     */     
/*     */ 
/* 612 */     TriggerEventsManger.getInstance().triggerEvent(new KnockOutFightEnd(), knockOutFinalFightEndArg);
/*     */     
/* 614 */     KnockOutTLogManager.tlogKnockOutRankUp(this.activityCfgId, this.knockOutType, this.fightZoneId, this.fightStage, this.fightIndexId, this.corpsId, isWin ? 1 : 0);
/*     */   }
/*     */   
/*     */ 
/*     */   private static class RRepeatCheckResult
/*     */     implements Runnable
/*     */   {
/*     */     private final int activityCfgId;
/*     */     
/*     */     private final int knockOutType;
/*     */     private final int fightZoneId;
/*     */     private final int fightStage;
/*     */     private final int fightIndexId;
/*     */     private final long corpsId;
/*     */     private final String opponentCorpsName;
/*     */     private final String ownCorpsName;
/*     */     private final long opponentCorpsId;
/*     */     private final int corpsFightResult;
/*     */     private final int repeatTimes;
/*     */     
/*     */     public RRepeatCheckResult(int activityCfgId, int knockOutType, int fightZoneId, int fightStage, int fightIndexId, long corpsId, String opponentCorpsName, String ownCorpsName, long opponentCorpsId, int corpsFightResult, int repeatTimes)
/*     */     {
/* 636 */       this.activityCfgId = activityCfgId;
/* 637 */       this.knockOutType = knockOutType;
/* 638 */       this.fightZoneId = fightZoneId;
/* 639 */       this.fightStage = fightStage;
/* 640 */       this.fightIndexId = fightIndexId;
/* 641 */       this.corpsId = corpsId;
/* 642 */       this.opponentCorpsName = opponentCorpsName;
/* 643 */       this.ownCorpsName = ownCorpsName;
/* 644 */       this.opponentCorpsId = opponentCorpsId;
/* 645 */       this.corpsFightResult = corpsFightResult;
/* 646 */       this.repeatTimes = repeatTimes;
/*     */     }
/*     */     
/*     */ 
/*     */     public void run()
/*     */     {
/* 652 */       GetKnockOutContext_ReportFightResult context = new GetKnockOutContext_ReportFightResult();
/* 653 */       context.corps_id = this.corpsId;
/*     */       try
/*     */       {
/* 656 */         context.corps_name.setString(this.ownCorpsName, "UTF-8");
/* 657 */         context.opponent_corps_name.setString(this.opponentCorpsName, "UTF-8");
/*     */       }
/*     */       catch (UnsupportedEncodingException e)
/*     */       {
/* 661 */         e.printStackTrace();
/*     */       }
/* 663 */       context.opponent_corps_id = this.opponentCorpsId;
/* 664 */       context.fight_stage = this.fightStage;
/* 665 */       context.fight_index_id = this.fightIndexId;
/* 666 */       context.corps_fight_result = this.corpsFightResult;
/* 667 */       context.repeat_times = this.repeatTimes;
/* 668 */       OctetsStream octetsStream = new OctetsStream();
/* 669 */       octetsStream.marshal(context);
/*     */       
/* 671 */       GetKnockOutContext getKnockOutContext = new GetKnockOutContext();
/* 672 */       getKnockOutContext.oper_type = 8;
/* 673 */       getKnockOutContext.content = octetsStream;
/*     */       
/* 675 */       Pair<Integer, Boolean> nowFightStagePair = CrossBattleKnockoutInterface.getNowFightStage(this.knockOutType);
/* 676 */       if (nowFightStagePair == null)
/*     */       {
/* 678 */         return;
/*     */       }
/*     */       
/* 681 */       SCrossBattleKnockOutCfg sCrossBattleKnockOutCfg = SCrossBattleKnockOutCfg.get(this.activityCfgId);
/* 682 */       if (sCrossBattleKnockOutCfg == null)
/*     */       {
/* 684 */         return;
/*     */       }
/*     */       
/* 687 */       KnockOutCfg knockOutCfg = (KnockOutCfg)sCrossBattleKnockOutCfg.knockOutTypeCfgMap.get(Integer.valueOf(this.knockOutType));
/* 688 */       if (knockOutCfg == null)
/*     */       {
/* 690 */         return;
/*     */       }
/*     */       
/* 693 */       int nowKnockOutStage = ((Integer)nowFightStagePair.first).intValue();
/* 694 */       GrcInterface.getCrossBattleKnockOutInfo(this.activityCfgId, this.knockOutType, this.fightZoneId, nowKnockOutStage, knockOutCfg.need_team_size, knockOutCfg.stage_name_list.size(), knockOutCfg.fight_times_every_stage, new OctetsStream().marshal(getKnockOutContext));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private static class PKickOutInstance
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final List<Long> roleIdList;
/*     */     private final KnockOutCfg knockOutCfg;
/*     */     
/*     */     public PKickOutInstance(List<Long> roleIdList, KnockOutCfg knockOutCfg)
/*     */     {
/* 707 */       this.roleIdList = roleIdList;
/* 708 */       this.knockOutCfg = knockOutCfg;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 714 */       lock(Role2properties.getTable(), this.roleIdList);
/*     */       
/* 716 */       for (Iterator i$ = this.roleIdList.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */         
/* 718 */         Long mapInstanceId = Long.valueOf(MapInterface.getRoleWorldInstanceId(roleId));
/* 719 */         Long prepareWorldId = CrossBattleKnockOutPrepareWorldManager.getInstance().getPrepareWorldId();
/* 720 */         if ((prepareWorldId != null) && (mapInstanceId == prepareWorldId))
/*     */         {
/* 722 */           Long teamId = TeamInterface.getTeamidByRoleid(roleId, false);
/* 723 */           if (teamId != null)
/*     */           {
/* 725 */             List<Long> teamMemberRoleList = TeamInterface.getTeamMemberList(teamId.longValue(), false);
/* 726 */             long teamLeaderId = ((Long)teamMemberRoleList.get(0)).longValue();
/* 727 */             MapInterface.forceTransferToScene(teamLeaderId, MapInterface.getCenterWorldid(), this.knockOutCfg.out_map_cfg_id, this.knockOutCfg.out_map_transfer_x, this.knockOutCfg.out_map_transfer_y);
/*     */             
/*     */ 
/* 730 */             break;
/*     */           }
/*     */         }
/*     */       }
/* 734 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\knockout\POnReportKnockOutFightResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
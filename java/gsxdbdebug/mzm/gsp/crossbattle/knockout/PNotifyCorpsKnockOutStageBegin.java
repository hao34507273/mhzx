/*     */ package mzm.gsp.crossbattle.knockout;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.crossbattle.confbean.CrossBattleConsts;
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
/*     */ import mzm.gsp.mail.main.MailInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.Pair;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.CrossBattleKnockoutActivityInfo;
/*     */ import xbean.CrossBattleKnockoutInfo;
/*     */ import xbean.FightAgainstInfo;
/*     */ import xbean.FightCorpsInfo;
/*     */ import xbean.FightStageInfo;
/*     */ import xbean.FightZoneInfo;
/*     */ import xio.Protocol;
/*     */ import xtable.Cross_battle_knockout;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PNotifyCorpsKnockOutStageBegin
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long corpsId;
/*     */   private final int fightStage;
/*     */   private final int knockOutType;
/*     */   
/*     */   public PNotifyCorpsKnockOutStageBegin(long corpsId, int fightStage, int knockOutType)
/*     */   {
/*  51 */     this.corpsId = corpsId;
/*  52 */     this.fightStage = fightStage;
/*  53 */     this.knockOutType = knockOutType;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  60 */     int activityCfgId = CrossBattleConsts.getInstance().CURRENT_ACTIVITY_CFG_ID;
/*  61 */     if (!CrossBattleKnockoutManager.isCrossBattleKnockOutSwitchOpen(activityCfgId, this.knockOutType))
/*     */     {
/*  63 */       onNotifyCorpsSelectionStageBeginFail(25);
/*  64 */       return false;
/*     */     }
/*     */     
/*  67 */     SCrossBattleKnockOutCfg sCrossBattleKnockOutCfg = SCrossBattleKnockOutCfg.get(activityCfgId);
/*  68 */     if (sCrossBattleKnockOutCfg == null)
/*     */     {
/*  70 */       onNotifyCorpsSelectionStageBeginFail(12);
/*  71 */       return false;
/*     */     }
/*     */     
/*  74 */     KnockOutCfg knockOutCfg = (KnockOutCfg)sCrossBattleKnockOutCfg.knockOutTypeCfgMap.get(Integer.valueOf(this.knockOutType));
/*  75 */     if (knockOutCfg == null)
/*     */     {
/*  77 */       onNotifyCorpsSelectionStageBeginFail(27);
/*  78 */       return false;
/*     */     }
/*     */     
/*  81 */     KnockOutHandler knockOutHandler = CrossBattleKnockoutManager.getKnockOutHandler(this.knockOutType);
/*  82 */     if (knockOutHandler == null)
/*     */     {
/*  84 */       onNotifyCorpsSelectionStageBeginFail(28);
/*  85 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  89 */     List<Long> roleIdList = CrossBattleOwnInterface.getCrossBattleRegisterRoleList(this.corpsId, activityCfgId, true);
/*  90 */     if (roleIdList == null)
/*     */     {
/*  92 */       onNotifyCorpsSelectionStageBeginFail(24);
/*  93 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  97 */     int corpsFightZoneId = CrossBattleKnockoutManager.getFightZone(this.corpsId, activityCfgId, this.knockOutType);
/*  98 */     if (corpsFightZoneId <= 0)
/*     */     {
/* 100 */       onNotifyCorpsSelectionStageBeginFail(19);
/* 101 */       return false;
/*     */     }
/*     */     
/* 104 */     long globalActivityCfgid = GameServerInfoManager.toGlobalId(activityCfgId);
/* 105 */     CrossBattleKnockoutActivityInfo xCrossBattleKnockoutActivityInfo = Cross_battle_knockout.get(Long.valueOf(globalActivityCfgid));
/* 106 */     if (xCrossBattleKnockoutActivityInfo == null)
/*     */     {
/* 108 */       onNotifyCorpsSelectionStageBeginFail(4);
/* 109 */       return false;
/*     */     }
/*     */     
/* 112 */     CrossBattleKnockoutInfo xCrossBattleKnockoutInfo = (CrossBattleKnockoutInfo)xCrossBattleKnockoutActivityInfo.getKnockout_info_map().get(Integer.valueOf(this.knockOutType));
/*     */     
/* 114 */     if (xCrossBattleKnockoutInfo == null)
/*     */     {
/* 116 */       onNotifyCorpsSelectionStageBeginFail(5);
/* 117 */       return false;
/*     */     }
/*     */     
/* 120 */     FightZoneInfo xFightZoneInfo = (FightZoneInfo)xCrossBattleKnockoutInfo.getFight_zone_info_map().get(Integer.valueOf(corpsFightZoneId));
/* 121 */     if (xFightZoneInfo == null)
/*     */     {
/* 123 */       return false;
/*     */     }
/*     */     
/* 126 */     FightCorpsInfo xFightCorpsInfo = (FightCorpsInfo)xFightZoneInfo.getFight_corps_info_map().get(Long.valueOf(this.corpsId));
/* 127 */     if (xFightCorpsInfo == null)
/*     */     {
/* 129 */       return false;
/*     */     }
/*     */     
/* 132 */     FightStageInfo xFightStageInfo = (FightStageInfo)xFightZoneInfo.getFight_stage_info_map().get(Integer.valueOf(this.fightStage));
/* 133 */     if (xFightStageInfo == null)
/*     */     {
/* 135 */       onNotifyCorpsSelectionStageBeginFail(6);
/* 136 */       return false;
/*     */     }
/*     */     
/* 139 */     int nowMaxFightIndexId = CrossBattleKnockoutManager.getMaxFightIndexId(knockOutCfg.need_team_size, this.fightStage, knockOutCfg.fight_times_every_stage);
/*     */     
/* 141 */     if (nowMaxFightIndexId < 0)
/*     */     {
/* 143 */       onNotifyCorpsSelectionStageBeginFail(29);
/* 144 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 148 */     int maxFightStage = knockOutCfg.stage_name_list.size();
/* 149 */     Map<Integer, FightAgainstInfo> xFightAganistInfoMap = xFightStageInfo.getFight_against_info_map();
/* 150 */     for (Map.Entry<Integer, FightAgainstInfo> entry : xFightAganistInfoMap.entrySet())
/*     */     {
/* 152 */       int fightIndexId = ((Integer)entry.getKey()).intValue();
/*     */       
/* 154 */       FightAgainstInfo xFightAgainstInfo = (FightAgainstInfo)entry.getValue();
/* 155 */       if ((xFightAgainstInfo.getA_corps_id() == this.corpsId) || (xFightAgainstInfo.getB_corps_id() == this.corpsId))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 160 */         if ((this.fightStage > 1) && (this.fightStage % knockOutCfg.fight_times_every_stage != 1) && (knockOutCfg.fight_times_every_stage != 1))
/*     */         {
/*     */ 
/* 163 */           long corpsIdA = xFightAgainstInfo.getA_corps_id();
/* 164 */           long corpsIdB = xFightAgainstInfo.getB_corps_id();
/*     */           
/* 166 */           Pair<Long, Pair<Integer, Integer>> winCorpsIdPair = CrossBattleKnockoutManager.getWinCorpsId(xFightZoneInfo.getFight_stage_info_map(), corpsIdA, corpsIdB, this.fightStage - 1, fightIndexId, knockOutCfg.fight_times_every_stage);
/*     */           
/*     */ 
/* 169 */           if ((winCorpsIdPair != null) && (((Long)winCorpsIdPair.first).longValue() != -1L)) {
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */         else
/*     */         {
/* 176 */           int fightResult = xFightAgainstInfo.getCal_fight_result();
/* 177 */           if ((fightResult == FightResultEnum.A_BYE_WIN.fightResult) || (fightResult == FightResultEnum.B_BYE_WIN.fightResult))
/*     */           {
/* 179 */             int nowFightRound = (this.fightStage - 1) / knockOutCfg.fight_times_every_stage + 1;
/* 180 */             int maxRound = maxFightStage / knockOutCfg.fight_times_every_stage;
/*     */             
/* 182 */             boolean isFirstFightEveryRound = (this.fightStage % knockOutCfg.fight_times_every_stage == 1) || (knockOutCfg.fight_times_every_stage == 1);
/*     */             
/* 184 */             if (isFirstFightEveryRound)
/*     */             {
/*     */ 
/*     */ 
/*     */ 
/* 189 */               boolean isThirdStage = nowFightRound == maxRound - 1;
/* 190 */               boolean isChampionStage = nowFightRound == maxRound;
/* 191 */               boolean is4_to_2Stage = nowFightRound == maxRound - 2;
/* 192 */               boolean is8_to_4Stage = nowFightRound == maxRound - 3;
/*     */               
/* 194 */               int mailCfgId = 0;
/* 195 */               List<String> contextArgsList = null;
/* 196 */               if (is4_to_2Stage)
/*     */               {
/* 198 */                 mailCfgId = knockOutCfg.bye_rank_up_mail_cfg_id;
/* 199 */                 int championStage = (nowFightRound + 1) * knockOutCfg.fight_times_every_stage + 1;
/*     */                 
/* 201 */                 contextArgsList = knockOutHandler.getByeRankUpContextArgsList(knockOutCfg, this.fightStage, championStage);
/* 202 */                 knockOutHandler.sendRankUpChampionStageBulletionInfo(xFightCorpsInfo.getCorps_name(), xFightCorpsInfo.getCorps_zone_id());
/*     */ 
/*     */               }
/* 205 */               else if ((isChampionStage) || (isThirdStage))
/*     */               {
/*     */ 
/* 208 */                 if (isThirdStage)
/*     */                 {
/* 210 */                   mailCfgId = knockOutCfg.third_place_mail_cfg_id;
/* 211 */                   knockOutHandler.sendThirdPlaceBulletionInfo(xFightCorpsInfo.getCorps_name(), corpsFightZoneId, xFightCorpsInfo.getCorps_zone_id());
/*     */ 
/*     */                 }
/*     */                 else
/*     */                 {
/* 216 */                   mailCfgId = knockOutCfg.champion_mail_cfg_id;
/* 217 */                   knockOutHandler.sendChampionBulletionInfo(xFightCorpsInfo.getCorps_name(), corpsFightZoneId, xFightCorpsInfo.getCorps_zone_id());
/*     */                   
/*     */ 
/* 220 */                   KnockOutFinalChampionBornArg arg = new KnockOutFinalChampionBornArg();
/* 221 */                   TriggerEventsManger.getInstance().triggerEvent(new KnockOutFinalChampionBorn(), arg);
/*     */                 }
/* 223 */                 contextArgsList = knockOutHandler.getTitleContextArgsList(corpsFightZoneId);
/*     */               }
/*     */               else
/*     */               {
/* 227 */                 mailCfgId = knockOutCfg.bye_rank_up_mail_cfg_id;
/*     */                 
/* 229 */                 int nextStage = nowFightRound * knockOutCfg.fight_times_every_stage + 1;
/* 230 */                 contextArgsList = knockOutHandler.getByeRankUpContextArgsList(knockOutCfg, this.fightStage, nextStage);
/* 231 */                 knockOutHandler.sendRankUpNextFightStageBulletionInfo(xFightCorpsInfo.getCorps_name(), nowMaxFightIndexId);
/*     */               }
/*     */               
/* 234 */               int zoneNum = CrossBattlePointInterface.getZoneNum();
/* 235 */               if (((knockOutCfg.need_team_size / zoneNum == 4) && (is8_to_4Stage)) || ((knockOutCfg.need_team_size / zoneNum == 2) && (is4_to_2Stage)))
/*     */               {
/*     */ 
/*     */ 
/*     */ 
/* 240 */                 knockOutHandler.sendRankUpNextStageBulletionInfo(xFightCorpsInfo.getCorps_name(), corpsFightZoneId);
/*     */               }
/*     */               
/* 243 */               Protocol notifyFightResult = knockOutHandler.getNotifyFightResult(1, 1);
/* 244 */               OnlineManager.getInstance().sendMulti(notifyFightResult, roleIdList);
/*     */               
/* 246 */               for (Iterator i$ = roleIdList.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */                 
/* 248 */                 MailInterface.asynBuildAndSendMail(roleId, mailCfgId, null, contextArgsList, new TLogArg(LogReason.CROSS_BATTLE_KNOCK_OUT_WIN));
/*     */               }
/*     */               
/*     */ 
/* 252 */               int rank = 0;
/* 253 */               if (isThirdStage)
/*     */               {
/* 255 */                 rank = 3;
/*     */               }
/* 257 */               else if (isChampionStage)
/*     */               {
/* 259 */                 rank = 1;
/*     */               }
/*     */               else
/*     */               {
/* 263 */                 rank = nowMaxFightIndexId * 2;
/*     */               }
/*     */               
/* 266 */               KnockOutFightEndArg knockOutFinalFightEndArg = new KnockOutFightEndArg(this.corpsId, this.knockOutType, corpsFightZoneId, rank, true, false);
/*     */               
/*     */ 
/*     */ 
/* 270 */               TriggerEventsManger.getInstance().triggerEvent(new KnockOutFightEnd(), knockOutFinalFightEndArg);
/*     */               
/* 272 */               KnockOutSignalFightEndArg knockOutSignalFightEndArg = new KnockOutSignalFightEndArg(activityCfgId, this.corpsId, this.knockOutType, this.fightStage, true);
/*     */               
/*     */ 
/*     */ 
/* 276 */               TriggerEventsManger.getInstance().triggerEvent(new KnockOutSignalFightEnd(), knockOutSignalFightEndArg);
/*     */               
/* 278 */               StringBuilder sBuilder = new StringBuilder();
/* 279 */               sBuilder.append("[crossbattle_knockout]PNotifyCorpsKnockOutStageBegin.processImp@bye win");
/* 280 */               sBuilder.append("|activity_cfg_id=").append(activityCfgId);
/* 281 */               sBuilder.append("|knock_out_type=").append(this.knockOutType);
/* 282 */               sBuilder.append("|corps_fight_zone_id=").append(corpsFightZoneId);
/* 283 */               sBuilder.append("|fight_stage=").append(this.fightStage);
/* 284 */               sBuilder.append("|fight_index_id=").append(fightIndexId);
/* 285 */               sBuilder.append("|corps_id=").append(this.corpsId);
/* 286 */               sBuilder.append("|fight_result=").append(fightResult);
/*     */               
/* 288 */               GameServer.logger().info(sBuilder.toString());
/*     */               
/* 290 */               KnockOutTLogManager.tlogKnockOutRankUp(activityCfgId, this.knockOutType, corpsFightZoneId, this.fightStage, fightIndexId, this.corpsId, 1);
/*     */             }
/*     */           }
/*     */           else
/*     */           {
/* 295 */             Protocol notifyKnockOutBegin = knockOutHandler.getNotifyKnockOutBeginProtocol();
/*     */             
/* 297 */             OnlineManager.getInstance().sendMulti(notifyKnockOutBegin, roleIdList);
/*     */             
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 305 */             long abstainTimeMills = CrossBattleKnockOutPrepareWorldManager.getInstance().getPrepareWorldLastEnterTime().longValue() + 60000L + 500L;
/*     */             
/*     */ 
/*     */ 
/* 309 */             long currentTimeMillis = DateTimeUtils.getCurrTimeInMillis();
/*     */             
/*     */ 
/* 312 */             long leftTimeMillis = abstainTimeMills - currentTimeMillis;
/*     */             
/* 314 */             long opponentCorpsId = this.corpsId == xFightAgainstInfo.getA_corps_id() ? xFightAgainstInfo.getB_corps_id() : xFightAgainstInfo.getA_corps_id();
/*     */             
/* 316 */             FightCorpsInfo xOwnFightCorpsInfo = (FightCorpsInfo)xFightZoneInfo.getFight_corps_info_map().get(Long.valueOf(this.corpsId));
/* 317 */             FightCorpsInfo xOpponentFightCorpsInfo = (FightCorpsInfo)xFightZoneInfo.getFight_corps_info_map().get(Long.valueOf(opponentCorpsId));
/*     */             
/* 319 */             if ((xOpponentFightCorpsInfo == null) || (xOwnFightCorpsInfo == null))
/*     */             {
/* 321 */               return false;
/*     */             }
/*     */             
/*     */ 
/* 325 */             KnockOutAbstainObserver abstainObserver = new KnockOutAbstainObserver(leftTimeMillis, this.corpsId, xOwnFightCorpsInfo.getCorps_name(), opponentCorpsId, xOpponentFightCorpsInfo.getCorps_name(), this.knockOutType, this.fightStage, fightIndexId);
/*     */             
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 333 */             CrossBattleKnockoutManager.corpsId2AbstainObserverMap.put(Long.valueOf(this.corpsId), abstainObserver);
/*     */             
/* 335 */             StringBuilder sBuilder = new StringBuilder();
/* 336 */             sBuilder.append("[crossbattle_knockout]PNotifyCorpsKnockOutStageBegin.processImp@start abstain observer");
/* 337 */             sBuilder.append("|activity_cfg_id=").append(activityCfgId);
/* 338 */             sBuilder.append("|knock_out_type=").append(this.knockOutType);
/* 339 */             sBuilder.append("|fight_stage=").append(this.fightStage);
/* 340 */             sBuilder.append("|fight_index_id=").append(fightIndexId);
/* 341 */             sBuilder.append("|corps_id=").append(this.corpsId);
/* 342 */             sBuilder.append("|opponent_corps_id=").append(opponentCorpsId);
/* 343 */             sBuilder.append("|corps_name=").append(xOwnFightCorpsInfo.getCorps_name());
/* 344 */             sBuilder.append("|opponent_corps_name=").append(xOpponentFightCorpsInfo.getCorps_name());
/*     */             
/* 346 */             GameServer.logger().info(sBuilder.toString());
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 352 */     return true;
/*     */   }
/*     */   
/*     */   private void onNotifyCorpsSelectionStageBeginFail(int ret)
/*     */   {
/* 357 */     StringBuilder sb = new StringBuilder();
/* 358 */     sb.append("[crossbattle_knockout]PNotifyCorpsKnockOutStageBegin.processImp@error");
/* 359 */     sb.append("|ret=").append(ret);
/* 360 */     sb.append("|knoco_out_type=").append(this.knockOutType);
/* 361 */     sb.append("|corps_id=").append(this.corpsId);
/* 362 */     sb.append("|fight_stage=").append(this.fightStage);
/*     */     
/* 364 */     GameServer.logger().error(sb.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\knockout\PNotifyCorpsKnockOutStageBegin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
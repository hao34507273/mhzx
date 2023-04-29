/*     */ package mzm.gsp.crossbattle.bet;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.crossbattle.FightAgainstInfo;
/*     */ import mzm.gsp.crossbattle.RemoveRoleCrossBattleBetRankInfoContext;
/*     */ import mzm.gsp.crossbattle.ReportRoleCrossBattleBetRankInfoContext;
/*     */ import mzm.gsp.crossbattle.SBetInFinalSuccess;
/*     */ import mzm.gsp.crossbattle.SBetInSelectionSuccess;
/*     */ import mzm.gsp.crossbattle.SSynBetTimes;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattleKnockoutBetCfg;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattleKnockoutBetInfo;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattleOwnCfg;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattleRoundRobinBetCfg;
/*     */ import mzm.gsp.crossbattle.knockout.CrossBattleFightZoneInfo;
/*     */ import mzm.gsp.crossbattle.knockout.CrossBattleKnockoutInterface;
/*     */ import mzm.gsp.crossbattle.main.CrossBattleOneByOneManager;
/*     */ import mzm.gsp.crossbattle.own.CrossBattleOwnInfo;
/*     */ import mzm.gsp.crossbattle.own.CrossBattleOwnInterface;
/*     */ import mzm.gsp.crossbattle.own.CrossBattleRoundRobinFightInfo;
/*     */ import mzm.gsp.crossbattle.own.CrossBattleRoundRobinRoundInfo;
/*     */ import mzm.gsp.crossserver.main.CrossServerInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.CrossBattleKnockoutBet;
/*     */ import xbean.CrossBattleRoundRobinBet;
/*     */ import xbean.KnockoutFightBetInfo;
/*     */ import xbean.KnockoutStageBetInfo;
/*     */ import xbean.KnockoutTypeBetInfo;
/*     */ import xbean.KnockoutZoneBetInfo;
/*     */ import xbean.Pod;
/*     */ import xbean.RoleCrossBattleBetProfitInfo;
/*     */ import xbean.RoleCrossBattleBetSeasonProfitInfo;
/*     */ import xbean.RoleCrossBattleBetTimesInfo;
/*     */ import xbean.RoleKnockoutFightBetInfo;
/*     */ import xbean.RoundRobinFightBetInfo;
/*     */ import xtable.Cross_battle_konckout_bets;
/*     */ import xtable.Cross_battle_round_robin_bets;
/*     */ import xtable.Role_cross_battle_bet_season_profot_infos;
/*     */ 
/*     */ public class CrossBattleBetManager
/*     */ {
/*  54 */   static final Logger logger = Logger.getLogger("crossbattle_bet");
/*  55 */   static volatile boolean postInitFlag = false;
/*  56 */   static int GRC_RETRY_INTERVAL = 60;
/*  57 */   static int GRC_MAX_TRY_TIMES = 3;
/*  58 */   static int GRC_MAX_DELAY = 300;
/*  59 */   static int GET_REMOTE_RANK_MIN_DELAY_IN_SECOND = 1800;
/*  60 */   static int GET_REMOTE_RANK_MAX_DELAY_IN_SECOND = 2100;
/*     */   
/*     */   static void postInit()
/*     */   {
/*  64 */     postInitFlag = true;
/*  65 */     if (GameServerInfoManager.isRoamServer())
/*     */     {
/*  67 */       return;
/*     */     }
/*  69 */     for (Iterator i$ = SCrossBattleRoundRobinBetCfg.getAll().keySet().iterator(); i$.hasNext();) { int activityCfgid = ((Integer)i$.next()).intValue();
/*     */       
/*  71 */       if (isCrossBattleRoundRobinBetSwitchOpen(activityCfgid))
/*     */       {
/*  73 */         CrossBattleOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(activityCfgid), new PTrySettleRoundRobinBet(activityCfgid));
/*     */       }
/*     */     }
/*     */     
/*  77 */     for (Iterator i$ = SCrossBattleKnockoutBetCfg.getAll().keySet().iterator(); i$.hasNext();) { int activityCfgid = ((Integer)i$.next()).intValue();
/*     */       
/*  79 */       if (isCrossBattleKnockoutBetSwitchOpen(activityCfgid, 1))
/*     */       {
/*  81 */         for (int fightZoneid = 1; fightZoneid < getKnockoutFightZoneNum(1); fightZoneid++)
/*     */         {
/*  83 */           for (int stage = 1; stage < CrossBattleKnockoutInterface.getKnockOutStageSize(activityCfgid, 1); 
/*  84 */               stage++)
/*     */           {
/*  86 */             if (DateTimeUtils.getCurrTimeInMillis() >= CrossBattleKnockoutInterface.getCrossBattleKnockOutStageCalTime(activityCfgid, 1, stage))
/*     */             {
/*     */ 
/*  89 */               CrossBattleOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(activityCfgid), new PTrySettleKnockoutStageBet(activityCfgid, 1, fightZoneid, stage, 1));
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*  97 */       if (isCrossBattleKnockoutBetSwitchOpen(activityCfgid, 2))
/*     */       {
/*  99 */         for (int fightZoneid = 1; fightZoneid < getKnockoutFightZoneNum(2); fightZoneid++)
/*     */         {
/* 101 */           for (int stage = 1; stage < CrossBattleKnockoutInterface.getKnockOutStageSize(activityCfgid, 2); 
/* 102 */               stage++)
/*     */           {
/* 104 */             if (DateTimeUtils.getCurrTimeInMillis() >= CrossBattleKnockoutInterface.getCrossBattleKnockOutStageCalTime(activityCfgid, 2, stage))
/*     */             {
/*     */ 
/* 107 */               CrossBattleOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(activityCfgid), new PTrySettleKnockoutStageBet(activityCfgid, 2, fightZoneid, stage, 1));
/*     */             }
/*     */           }
/*     */         }
/*     */       }
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
/*     */   static boolean isCrossBattleRoundRobinBetSwitchOpen(int activityCfgid)
/*     */   {
/* 125 */     SCrossBattleRoundRobinBetCfg cfg = SCrossBattleRoundRobinBetCfg.get(activityCfgid);
/* 126 */     if (cfg == null)
/*     */     {
/* 128 */       return false;
/*     */     }
/* 130 */     if (!OpenInterface.getOpenStatus(cfg.moduleid))
/*     */     {
/* 132 */       return false;
/*     */     }
/* 134 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isCrossBattleRoundRobinBetSwitchOpenForRole(long roleid, int activityCfgid)
/*     */   {
/* 146 */     SCrossBattleRoundRobinBetCfg cfg = SCrossBattleRoundRobinBetCfg.get(activityCfgid);
/* 147 */     if (cfg == null)
/*     */     {
/* 149 */       return false;
/*     */     }
/* 151 */     if (!OpenInterface.getOpenStatus(cfg.moduleid))
/*     */     {
/* 153 */       return false;
/*     */     }
/* 155 */     if (OpenInterface.isBanPlay(roleid, cfg.moduleid))
/*     */     {
/* 157 */       OpenInterface.sendBanPlayMsg(roleid, cfg.moduleid);
/* 158 */       return false;
/*     */     }
/* 160 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void initXCrossBattleRoundRobinBet(int activityCfgid)
/*     */   {
/* 172 */     CrossBattleOwnInfo crossBattleOwnInfo = CrossBattleOwnInterface.getCrossBattleOwnInfo(activityCfgid, true);
/* 173 */     if ((crossBattleOwnInfo == null) || (crossBattleOwnInfo.getRoundRobinRoundInfoList().isEmpty()))
/*     */     {
/* 175 */       return;
/*     */     }
/* 177 */     long globalActivityCfgid = GameServerInfoManager.toGlobalId(activityCfgid);
/* 178 */     CrossBattleRoundRobinBet xCrossBattleRoundRobinBet = Cross_battle_round_robin_bets.get(Long.valueOf(globalActivityCfgid));
/* 179 */     if (xCrossBattleRoundRobinBet != null)
/*     */     {
/* 181 */       return;
/*     */     }
/* 183 */     xCrossBattleRoundRobinBet = Pod.newCrossBattleRoundRobinBet();
/* 184 */     Cross_battle_round_robin_bets.insert(Long.valueOf(globalActivityCfgid), xCrossBattleRoundRobinBet);
/* 185 */     for (CrossBattleRoundRobinRoundInfo crossBattleRoundRobinRoundInfo : crossBattleOwnInfo.getRoundRobinRoundInfoList())
/*     */     {
/* 187 */       xRoundRobinRoundBetInfo = Pod.newRoundRobinRoundBetInfo();
/* 188 */       xCrossBattleRoundRobinBet.getRound_bet_infos().add(xRoundRobinRoundBetInfo);
/* 189 */       for (CrossBattleRoundRobinFightInfo crossBattleRoundRobinFightInfo : crossBattleRoundRobinRoundInfo.getRoundRobinFightInfoList())
/*     */       {
/* 191 */         RoundRobinFightBetInfo xRoundRobinFightBetInfo = Pod.newRoundRobinFightBetInfo();
/* 192 */         xRoundRobinRoundBetInfo.getFight_bet_infos().add(xRoundRobinFightBetInfo);
/* 193 */         xRoundRobinFightBetInfo.setCorps_a_id(crossBattleRoundRobinFightInfo.getCorpsAid());
/* 194 */         xRoundRobinFightBetInfo.setCorps_b_id(crossBattleRoundRobinFightInfo.getCorpsBid());
/* 195 */         xRoundRobinFightBetInfo.setState(crossBattleRoundRobinFightInfo.getState());
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     xbean.RoundRobinRoundBetInfo xRoundRobinRoundBetInfo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isInRoundRobinBetTime(int activityCfgid, int roundIndex)
/*     */   {
/* 209 */     SCrossBattleOwnCfg cfg = SCrossBattleOwnCfg.get(activityCfgid);
/* 210 */     if (cfg == null)
/*     */     {
/*     */ 
/* 213 */       return false;
/*     */     }
/* 215 */     if ((roundIndex <= 0) || (roundIndex > cfg.round_robin_time_points.size()))
/*     */     {
/*     */ 
/* 218 */       return false;
/*     */     }
/* 220 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 221 */     long fightStartTimestamp = mzm.gsp.common.TimeCommonUtil.getTimePoint(mzm.gsp.common.confbean.STimePointCommonCfg.get(((Integer)cfg.round_robin_time_points.get(roundIndex - 1)).intValue()));
/* 222 */     long dayStartTimestamp = DateTimeUtils.getBeginTimeOfCurrDay(fightStartTimestamp);
/* 223 */     if ((now >= fightStartTimestamp) || (now < dayStartTimestamp))
/*     */     {
/* 225 */       return false;
/*     */     }
/* 227 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isRoundRobinFightEnd(int state)
/*     */   {
/* 238 */     return (state != 0) && (state != 1);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isRoundRobinFightAWin(int state)
/*     */   {
/* 249 */     return (state == 2) || (state == 5);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isRoundRobinFightBWin(int state)
/*     */   {
/* 260 */     return (state == 3) || (state == 4);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isRoundRobinFightTie(int state)
/*     */   {
/* 271 */     return (state == 6) || (state == 7);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static SCrossBattleKnockoutBetInfo getCrossBattleKnockoutBetInfo(int activityCfgid, int knockoutType)
/*     */   {
/* 283 */     SCrossBattleKnockoutBetCfg cfg = SCrossBattleKnockoutBetCfg.get(activityCfgid);
/* 284 */     if (cfg == null)
/*     */     {
/* 286 */       return null;
/*     */     }
/* 288 */     return (SCrossBattleKnockoutBetInfo)cfg.knockout_bet_infos.get(Integer.valueOf(knockoutType));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isCrossBattleKnockoutBetSwitchOpen(int activityCfgid, int knockoutType)
/*     */   {
/* 299 */     SCrossBattleKnockoutBetInfo cfg = getCrossBattleKnockoutBetInfo(activityCfgid, knockoutType);
/* 300 */     if (cfg == null)
/*     */     {
/* 302 */       return false;
/*     */     }
/* 304 */     if (!OpenInterface.getOpenStatus(cfg.moduleid))
/*     */     {
/* 306 */       return false;
/*     */     }
/* 308 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isCrossBattleKnockoutBetSwitchOpenForRole(long roleid, int activityCfgid, int knockoutType)
/*     */   {
/* 320 */     SCrossBattleKnockoutBetInfo cfg = getCrossBattleKnockoutBetInfo(activityCfgid, knockoutType);
/* 321 */     if (cfg == null)
/*     */     {
/* 323 */       return false;
/*     */     }
/* 325 */     if (!OpenInterface.getOpenStatus(cfg.moduleid))
/*     */     {
/* 327 */       return false;
/*     */     }
/* 329 */     if (OpenInterface.isBanPlay(roleid, cfg.moduleid))
/*     */     {
/* 331 */       OpenInterface.sendBanPlayMsg(roleid, cfg.moduleid);
/* 332 */       return false;
/*     */     }
/* 334 */     return true;
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
/*     */   static void refreshXKnockoutStageBetInfo(int activityCfgid, int knockoutType, int fightZoneid, int stage, List<FightAgainstInfo> fightInfos)
/*     */   {
/* 350 */     long globalActivityCfgid = GameServerInfoManager.toGlobalId(activityCfgid);
/* 351 */     CrossBattleKnockoutBet xCrossBattleKnockoutBet = Cross_battle_konckout_bets.get(Long.valueOf(globalActivityCfgid));
/* 352 */     if (xCrossBattleKnockoutBet == null)
/*     */     {
/* 354 */       xCrossBattleKnockoutBet = Pod.newCrossBattleKnockoutBet();
/* 355 */       Cross_battle_konckout_bets.insert(Long.valueOf(globalActivityCfgid), xCrossBattleKnockoutBet);
/*     */     }
/* 357 */     KnockoutTypeBetInfo xKnockoutTypeBetInfo = (KnockoutTypeBetInfo)xCrossBattleKnockoutBet.getKnockout_type_bet_infos().get(Integer.valueOf(knockoutType));
/* 358 */     if (xKnockoutTypeBetInfo == null)
/*     */     {
/* 360 */       xKnockoutTypeBetInfo = Pod.newKnockoutTypeBetInfo();
/* 361 */       xCrossBattleKnockoutBet.getKnockout_type_bet_infos().put(Integer.valueOf(knockoutType), xKnockoutTypeBetInfo);
/*     */     }
/* 363 */     KnockoutZoneBetInfo xKnockoutZoneBetInfo = (KnockoutZoneBetInfo)xKnockoutTypeBetInfo.getZone_bet_infos().get(Integer.valueOf(fightZoneid));
/* 364 */     if (xKnockoutZoneBetInfo == null)
/*     */     {
/* 366 */       xKnockoutZoneBetInfo = Pod.newKnockoutZoneBetInfo();
/* 367 */       xKnockoutTypeBetInfo.getZone_bet_infos().put(Integer.valueOf(fightZoneid), xKnockoutZoneBetInfo);
/*     */     }
/* 369 */     KnockoutStageBetInfo xKnockoutStageBetInfo = (KnockoutStageBetInfo)xKnockoutZoneBetInfo.getStage_bet_infos().get(Integer.valueOf(stage));
/* 370 */     if (xKnockoutStageBetInfo == null)
/*     */     {
/* 372 */       xKnockoutStageBetInfo = Pod.newKnockoutStageBetInfo();
/* 373 */       xKnockoutZoneBetInfo.getStage_bet_infos().put(Integer.valueOf(stage), xKnockoutStageBetInfo);
/*     */     }
/* 375 */     for (int fightIndex = 1; fightIndex <= fightInfos.size(); fightIndex++)
/*     */     {
/* 377 */       FightAgainstInfo fightInfo = (FightAgainstInfo)fightInfos.get(fightIndex - 1);
/* 378 */       KnockoutFightBetInfo xKnockoutFightBetInfo = (KnockoutFightBetInfo)xKnockoutStageBetInfo.getFight_bet_infos().get(Integer.valueOf(fightIndex));
/* 379 */       if (xKnockoutFightBetInfo == null)
/*     */       {
/* 381 */         xKnockoutFightBetInfo = Pod.newKnockoutFightBetInfo();
/* 382 */         xKnockoutStageBetInfo.getFight_bet_infos().put(Integer.valueOf(fightIndex), xKnockoutFightBetInfo);
/*     */       }
/* 384 */       if ((xKnockoutFightBetInfo.getA_corps_id() > 0L) && (xKnockoutFightBetInfo.getB_corps_id() > 0L) && (fightInfo.corps_a_id > 0L) && (fightInfo.corps_b_id > 0L) && ((xKnockoutFightBetInfo.getA_corps_id() != fightInfo.corps_a_id) || (xKnockoutFightBetInfo.getB_corps_id() != fightInfo.corps_b_id)))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 390 */         logger.error(String.format("[crossbattle_bet]CrossBattleBetManager.refreshXKnockoutStageBetInfo@corps id error|activity_cfg_id=%d|knockout_type=%d|fightZoneid=%d|stage=%d|fight_index=%d|bet_corps_a_id=%d|bet_corps_b_id=%d|fight_corps_a_id=%d|fight_corps_b_id=%d", new Object[] { Integer.valueOf(activityCfgid), Integer.valueOf(knockoutType), Integer.valueOf(fightZoneid), Integer.valueOf(stage), Integer.valueOf(fightIndex), Long.valueOf(xKnockoutFightBetInfo.getA_corps_id()), Long.valueOf(xKnockoutFightBetInfo.getB_corps_id()), Long.valueOf(fightInfo.corps_a_id), Long.valueOf(fightInfo.corps_b_id) }));
/*     */         
/*     */ 
/*     */ 
/* 394 */         return;
/*     */       }
/* 396 */       xKnockoutFightBetInfo.setA_corps_id(fightInfo.corps_a_id);
/* 397 */       xKnockoutFightBetInfo.setB_corps_id(fightInfo.corps_b_id);
/* 398 */       if (!xKnockoutFightBetInfo.getHas_set_cal_fight_result())
/*     */       {
/* 400 */         xKnockoutFightBetInfo.setCal_fight_result(fightInfo.cal_fight_result);
/*     */       }
/* 402 */       if (DateTimeUtils.getCurrTimeInMillis() >= CrossBattleKnockoutInterface.getCrossBattleKnockOutStageCalTime(activityCfgid, knockoutType, stage))
/*     */       {
/*     */ 
/* 405 */         xKnockoutFightBetInfo.setHas_set_cal_fight_result(true);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isKnockoutFightAWin(int result)
/*     */   {
/* 418 */     return (result == 1) || (result == 3);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isKnockoutFightBWin(int result)
/*     */   {
/* 429 */     return (result == 2) || (result == 4);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isKnockoutFightTie(int result)
/*     */   {
/* 440 */     return (result == 7) || (result == 0);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isSelectionFightByeEnd(int result)
/*     */   {
/* 451 */     return (result == 5) || (result == 6) || (result == 8);
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
/*     */   static KnockoutStageBetInfo getXKnockoutStageBetInfo(int activityCfgid, int knockoutType, int fightZoneid, int stage)
/*     */   {
/* 467 */     long globalActivityCfgid = GameServerInfoManager.toGlobalId(activityCfgid);
/* 468 */     CrossBattleKnockoutBet xCrossBattleKnockoutBet = Cross_battle_konckout_bets.get(Long.valueOf(globalActivityCfgid));
/* 469 */     if (xCrossBattleKnockoutBet == null)
/*     */     {
/* 471 */       return null;
/*     */     }
/* 473 */     KnockoutTypeBetInfo xKnockoutTypeBetInfo = (KnockoutTypeBetInfo)xCrossBattleKnockoutBet.getKnockout_type_bet_infos().get(Integer.valueOf(knockoutType));
/*     */     
/* 475 */     if (xKnockoutTypeBetInfo == null)
/*     */     {
/* 477 */       return null;
/*     */     }
/* 479 */     KnockoutZoneBetInfo xKnockoutZoneBetInfo = (KnockoutZoneBetInfo)xKnockoutTypeBetInfo.getZone_bet_infos().get(Integer.valueOf(fightZoneid));
/* 480 */     if (xKnockoutZoneBetInfo == null)
/*     */     {
/* 482 */       return null;
/*     */     }
/* 484 */     return (KnockoutStageBetInfo)xKnockoutZoneBetInfo.getStage_bet_infos().get(Integer.valueOf(stage));
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
/*     */   static KnockoutStageBetInfo getXKnockoutStageBetInfo(long globalActivityCfgid, int knockoutType, int fightZoneid, int stage)
/*     */   {
/* 500 */     CrossBattleKnockoutBet xCrossBattleKnockoutBet = Cross_battle_konckout_bets.get(Long.valueOf(globalActivityCfgid));
/* 501 */     if (xCrossBattleKnockoutBet == null)
/*     */     {
/* 503 */       return null;
/*     */     }
/* 505 */     KnockoutTypeBetInfo xKnockoutTypeBetInfo = (KnockoutTypeBetInfo)xCrossBattleKnockoutBet.getKnockout_type_bet_infos().get(Integer.valueOf(knockoutType));
/*     */     
/* 507 */     if (xKnockoutTypeBetInfo == null)
/*     */     {
/* 509 */       return null;
/*     */     }
/* 511 */     KnockoutZoneBetInfo xKnockoutZoneBetInfo = (KnockoutZoneBetInfo)xKnockoutTypeBetInfo.getZone_bet_infos().get(Integer.valueOf(fightZoneid));
/* 512 */     if (xKnockoutZoneBetInfo == null)
/*     */     {
/* 514 */       return null;
/*     */     }
/* 516 */     return (KnockoutStageBetInfo)xKnockoutZoneBetInfo.getStage_bet_infos().get(Integer.valueOf(stage));
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
/*     */   static boolean isInKnockoutBetTime(int activityCfgid, int knockoutType, int stage)
/*     */   {
/* 529 */     SCrossBattleKnockoutBetInfo cfg = getCrossBattleKnockoutBetInfo(activityCfgid, knockoutType);
/* 530 */     if (cfg == null)
/*     */     {
/*     */ 
/* 533 */       return false;
/*     */     }
/* 535 */     if ((stage <= 0) || (stage > CrossBattleKnockoutInterface.getKnockOutStageSize(activityCfgid, knockoutType)))
/*     */     {
/*     */ 
/* 538 */       return false;
/*     */     }
/* 540 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 541 */     long fightStartTimestamp = CrossBattleKnockoutInterface.getKnockOutStageFightBeginTime(activityCfgid, knockoutType, stage);
/*     */     
/* 543 */     long dayStartTimestamp = DateTimeUtils.getBeginTimeOfCurrDay(fightStartTimestamp);
/* 544 */     if ((now >= fightStartTimestamp) || (now < dayStartTimestamp))
/*     */     {
/* 546 */       return false;
/*     */     }
/* 548 */     return true;
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
/*     */   static int betInKnockout(long roleid, int activityCfgid, int knockoutType, int fightZoneid, int stage, int fightIndex, long betCorpsid, int sortid, CrossBattleFightZoneInfo fightZoneInfo)
/*     */   {
/* 570 */     SCrossBattleKnockoutBetInfo cfg = getCrossBattleKnockoutBetInfo(activityCfgid, knockoutType);
/* 571 */     if ((cfg == null) || (!cfg.bet_infos.containsKey(Integer.valueOf(sortid))))
/*     */     {
/*     */ 
/* 574 */       return -3;
/*     */     }
/*     */     
/* 577 */     long currTimeInMillis = DateTimeUtils.getCurrTimeInMillis();
/* 578 */     RoleCrossBattleBetTimesInfo xRoleCrossBattleBetTimesInfo = xtable.Role_cross_battle_bet_times_infos.get(Long.valueOf(roleid));
/* 579 */     if (xRoleCrossBattleBetTimesInfo == null)
/*     */     {
/* 581 */       xRoleCrossBattleBetTimesInfo = Pod.newRoleCrossBattleBetTimesInfo();
/* 582 */       xRoleCrossBattleBetTimesInfo.setTimestamp(currTimeInMillis);
/* 583 */       xtable.Role_cross_battle_bet_times_infos.insert(Long.valueOf(roleid), xRoleCrossBattleBetTimesInfo);
/*     */     }
/* 585 */     if (DateTimeUtils.needDailyReset(xRoleCrossBattleBetTimesInfo.getTimestamp(), currTimeInMillis, 0))
/*     */     {
/* 587 */       xRoleCrossBattleBetTimesInfo.setTimes(0);
/* 588 */       xRoleCrossBattleBetTimesInfo.setTimestamp(currTimeInMillis);
/*     */     }
/* 590 */     if (xRoleCrossBattleBetTimesInfo.getTimes() >= mzm.gsp.crossbattle.confbean.CrossBattleConsts.getInstance().DAILY_BET_TIMES_UPPER_LIMIT)
/*     */     {
/*     */ 
/* 593 */       return 13;
/*     */     }
/* 595 */     xRoleCrossBattleBetTimesInfo.setTimes(xRoleCrossBattleBetTimesInfo.getTimes() + 1);
/*     */     
/* 597 */     SSynBetTimes sSynBetTimes = new SSynBetTimes();
/* 598 */     sSynBetTimes.times = 0;
/* 599 */     OnlineManager.getInstance().send(roleid, sSynBetTimes);
/*     */     
/*     */ 
/* 602 */     switch (cfg.bet_cost_type)
/*     */     {
/*     */     case 2: 
/* 605 */       long gold = RoleInterface.getGold(roleid);
/* 606 */       if (gold < ((Integer)cfg.bet_infos.get(Integer.valueOf(sortid))).intValue())
/*     */       {
/*     */ 
/* 609 */         return 9;
/*     */       }
/* 611 */       if (!RoleInterface.cutGold(roleid, ((Integer)cfg.bet_infos.get(Integer.valueOf(sortid))).intValue(), new mzm.gsp.tlog.TLogArg(knockoutType == 1 ? LogReason.CROSS_BATTLE_SELECTION_STAGE_BET_COST : LogReason.CROSS_BATTLE_FINAL_STAGE_BET_COST, activityCfgid)))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 619 */         return 9;
/*     */       }
/*     */       
/*     */       break;
/*     */     default: 
/* 624 */       return -3;
/*     */     }
/*     */     
/* 627 */     List<FightAgainstInfo> fightInfos = fightZoneInfo.getStagefightAgainstList(stage);
/* 628 */     refreshXKnockoutStageBetInfo(activityCfgid, knockoutType, fightZoneid, stage, fightInfos);
/* 629 */     if (CrossBattleKnockoutInterface.isAleardyHasRoundResult(activityCfgid, knockoutType, fightZoneid, stage - 1, fightIndex))
/*     */     {
/*     */ 
/*     */ 
/* 633 */       return 12;
/*     */     }
/* 635 */     KnockoutStageBetInfo xKnockoutStageBetInfo = getXKnockoutStageBetInfo(activityCfgid, knockoutType, fightZoneid, stage);
/*     */     
/* 637 */     if (xKnockoutStageBetInfo == null)
/*     */     {
/*     */ 
/* 640 */       return -5;
/*     */     }
/* 642 */     KnockoutFightBetInfo xKnockoutFightBetInfo = (KnockoutFightBetInfo)xKnockoutStageBetInfo.getFight_bet_infos().get(Integer.valueOf(fightIndex));
/* 643 */     if ((xKnockoutFightBetInfo.getA_corps_id() <= 0L) || (xKnockoutFightBetInfo.getB_corps_id() <= 0L))
/*     */     {
/*     */ 
/* 646 */       return 6;
/*     */     }
/* 648 */     if (xKnockoutFightBetInfo.getHas_set_cal_fight_result())
/*     */     {
/*     */ 
/* 651 */       return 5;
/*     */     }
/* 653 */     if ((betCorpsid != xKnockoutFightBetInfo.getA_corps_id()) && (betCorpsid != xKnockoutFightBetInfo.getB_corps_id()))
/*     */     {
/*     */ 
/* 656 */       return -3;
/*     */     }
/* 658 */     List<Long> corpsARegisterList = CrossBattleOwnInterface.getCrossBattleRegisterRoleList(xKnockoutFightBetInfo.getA_corps_id(), activityCfgid, true);
/*     */     
/* 660 */     List<Long> corpsBRegisterList = CrossBattleOwnInterface.getCrossBattleRegisterRoleList(xKnockoutFightBetInfo.getB_corps_id(), activityCfgid, true);
/*     */     
/* 662 */     if (((corpsARegisterList != null) && (corpsARegisterList.contains(Long.valueOf(roleid)))) || ((corpsBRegisterList != null) && (corpsBRegisterList.contains(Long.valueOf(roleid)))))
/*     */     {
/*     */ 
/*     */ 
/* 666 */       return 7;
/*     */     }
/* 668 */     if (xKnockoutFightBetInfo.getRole_bet_infos().containsKey(Long.valueOf(roleid)))
/*     */     {
/*     */ 
/* 671 */       return 8;
/*     */     }
/* 673 */     RoleKnockoutFightBetInfo xRoleKnockoutFightBetInfo = Pod.newRoleKnockoutFightBetInfo();
/* 674 */     xRoleKnockoutFightBetInfo.setBet_corps_id(betCorpsid);
/* 675 */     xRoleKnockoutFightBetInfo.setBet_money_num(((Integer)cfg.bet_infos.get(Integer.valueOf(sortid))).intValue());
/* 676 */     xKnockoutFightBetInfo.getRole_bet_infos().put(Long.valueOf(roleid), xRoleKnockoutFightBetInfo);
/*     */     
/* 678 */     switch (knockoutType)
/*     */     {
/*     */ 
/*     */     case 1: 
/* 682 */       SBetInSelectionSuccess protocol = new SBetInSelectionSuccess();
/* 683 */       protocol.activity_cfg_id = activityCfgid;
/* 684 */       protocol.fight_zone_id = fightZoneid;
/* 685 */       protocol.selection_stage = stage;
/* 686 */       protocol.fight_index = fightIndex;
/* 687 */       protocol.target_corps_id = betCorpsid;
/* 688 */       protocol.sortid = sortid;
/* 689 */       OnlineManager.getInstance().send(roleid, protocol);
/*     */       
/* 691 */       break;
/*     */     
/*     */     case 2: 
/* 694 */       SBetInFinalSuccess protocol = new SBetInFinalSuccess();
/* 695 */       protocol.activity_cfg_id = activityCfgid;
/* 696 */       protocol.stage = stage;
/* 697 */       protocol.fight_index = fightIndex;
/* 698 */       protocol.target_corps_id = betCorpsid;
/* 699 */       protocol.sortid = sortid;
/* 700 */       OnlineManager.getInstance().send(roleid, protocol);
/*     */       
/* 702 */       break;
/*     */     
/*     */     default: 
/* 705 */       return -3; }
/*     */     
/* 707 */     new PReportRoleKnockoutBetInfo(roleid, activityCfgid, knockoutType, fightZoneid, stage, fightIndex, betCorpsid, ((Integer)cfg.bet_infos.get(Integer.valueOf(sortid))).intValue(), 1).call();
/*     */     
/* 709 */     return 0;
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
/*     */   static int settleKnockoutStageBet(int activityCfgid, int knockoutType, int fightZoneid, int stage, CrossBattleFightZoneInfo fightZoneInfo)
/*     */   {
/* 726 */     SCrossBattleKnockoutBetInfo cfg = getCrossBattleKnockoutBetInfo(activityCfgid, knockoutType);
/* 727 */     if (cfg == null)
/*     */     {
/*     */ 
/* 730 */       return -3;
/*     */     }
/* 732 */     List<FightAgainstInfo> fightInfos = fightZoneInfo.getStagefightAgainstList(stage);
/* 733 */     refreshXKnockoutStageBetInfo(activityCfgid, knockoutType, fightZoneid, stage, fightInfos);
/* 734 */     KnockoutStageBetInfo xKnockoutStageBetInfo = getXKnockoutStageBetInfo(activityCfgid, knockoutType, fightZoneid, stage);
/*     */     
/* 736 */     if (xKnockoutStageBetInfo == null)
/*     */     {
/*     */ 
/* 739 */       return -5;
/*     */     }
/* 741 */     Set<Long> roleids = new java.util.HashSet();
/* 742 */     for (int fightIndex = 1; fightIndex <= xKnockoutStageBetInfo.getFight_bet_infos().size(); fightIndex++)
/*     */     {
/* 744 */       KnockoutFightBetInfo xKnockoutFightBetInfo = (KnockoutFightBetInfo)xKnockoutStageBetInfo.getFight_bet_infos().get(Integer.valueOf(fightIndex));
/* 745 */       for (Map.Entry<Long, RoleKnockoutFightBetInfo> entry : xKnockoutFightBetInfo.getRole_bet_infos().entrySet())
/*     */       {
/* 747 */         long roleid = ((Long)entry.getKey()).longValue();
/* 748 */         RoleKnockoutFightBetInfo xRoleKnockoutFightBetInfo = (RoleKnockoutFightBetInfo)entry.getValue();
/* 749 */         if (!xRoleKnockoutFightBetInfo.getHas_got_mail())
/*     */         {
/* 751 */           roleids.add(Long.valueOf(roleid));
/*     */         }
/*     */       }
/*     */     }
/* 755 */     for (Iterator i$ = roleids.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */       
/* 757 */       new SendKnockoutStageBetMailSession(1 + xdb.Xdb.random().nextInt(GRC_MAX_DELAY), roleid, activityCfgid, knockoutType, fightZoneid, stage);
/*     */     }
/*     */     
/* 760 */     return 0;
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
/*     */   static int calculateReturnMoneyNum(double corpsABetMoneySum, double corpsBBetMoneySum, boolean isRoleBetOnCorpsA, double roleBetMoneyNum, boolean isAWin, double winMultiple, double MaxReturnMoneyNum)
/*     */   {
/* 779 */     if ((corpsABetMoneySum < 0.0D) || (corpsBBetMoneySum < 0.0D) || (roleBetMoneyNum <= 0.0D))
/*     */     {
/* 781 */       return 0;
/*     */     }
/* 783 */     if (((isAWin) && (roleBetMoneyNum > corpsABetMoneySum)) || ((!isAWin) && (roleBetMoneyNum > corpsBBetMoneySum)))
/*     */     {
/* 785 */       return 0;
/*     */     }
/* 787 */     if ((isAWin) && (isRoleBetOnCorpsA))
/*     */     {
/* 789 */       double result = (corpsABetMoneySum + corpsBBetMoneySum) * winMultiple * roleBetMoneyNum / corpsABetMoneySum;
/* 790 */       if (result > MaxReturnMoneyNum)
/* 791 */         return (int)MaxReturnMoneyNum;
/* 792 */       return (int)result;
/*     */     }
/* 794 */     if ((!isAWin) && (!isRoleBetOnCorpsA))
/*     */     {
/* 796 */       double result = (corpsABetMoneySum + corpsBBetMoneySum) * winMultiple * roleBetMoneyNum / corpsBBetMoneySum;
/* 797 */       if (result > MaxReturnMoneyNum)
/* 798 */         return (int)MaxReturnMoneyNum;
/* 799 */       return (int)result;
/*     */     }
/* 801 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getKnockoutFightZoneNum(int knockoutType)
/*     */   {
/* 813 */     switch (knockoutType)
/*     */     {
/*     */     case 1: 
/* 816 */       return mzm.gsp.crossbattle.point.CrossBattlePointInterface.getZoneNum();
/*     */     case 2: 
/* 818 */       return 1;
/*     */     }
/* 820 */     return -1;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isCrossBattleBetRankSwitchOpen()
/*     */   {
/* 831 */     if (!OpenInterface.getOpenStatus(485))
/*     */     {
/* 833 */       return false;
/*     */     }
/* 835 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isCrossBattleBetRankSwitchOpenForRole(long roleid)
/*     */   {
/* 846 */     if (!OpenInterface.getOpenStatus(485))
/*     */     {
/* 848 */       return false;
/*     */     }
/* 850 */     if (OpenInterface.isBanPlay(roleid, 485))
/*     */     {
/* 852 */       OpenInterface.sendBanPlayMsg(roleid, 485);
/* 853 */       return false;
/*     */     }
/* 855 */     return true;
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
/*     */   static void updateRoleBetProfitInfo(int activityCfgid, long roleid, long addProfit)
/*     */   {
/* 869 */     if (activityCfgid == 350010000)
/*     */     {
/*     */ 
/* 872 */       return;
/*     */     }
/* 874 */     RoleCrossBattleBetSeasonProfitInfo xRoleCrossBattleBetSeasonProfitInfo = Role_cross_battle_bet_season_profot_infos.get(Long.valueOf(roleid));
/* 875 */     if (xRoleCrossBattleBetSeasonProfitInfo == null)
/*     */     {
/* 877 */       xRoleCrossBattleBetSeasonProfitInfo = Pod.newRoleCrossBattleBetSeasonProfitInfo();
/* 878 */       Role_cross_battle_bet_season_profot_infos.insert(Long.valueOf(roleid), xRoleCrossBattleBetSeasonProfitInfo);
/*     */     }
/* 880 */     RoleCrossBattleBetProfitInfo xRoleCrossBattleBetProfitInfo = (RoleCrossBattleBetProfitInfo)xRoleCrossBattleBetSeasonProfitInfo.getProfit_infos().get(Integer.valueOf(activityCfgid));
/*     */     
/* 882 */     if (xRoleCrossBattleBetProfitInfo == null)
/*     */     {
/* 884 */       xRoleCrossBattleBetProfitInfo = Pod.newRoleCrossBattleBetProfitInfo();
/* 885 */       xRoleCrossBattleBetSeasonProfitInfo.getProfit_infos().put(Integer.valueOf(activityCfgid), xRoleCrossBattleBetProfitInfo);
/*     */     }
/* 887 */     xRoleCrossBattleBetProfitInfo.setProfit(xRoleCrossBattleBetProfitInfo.getProfit() + addProfit);
/* 888 */     xRoleCrossBattleBetProfitInfo.setTimestamp(DateTimeUtils.getCurrTimeInMillis());
/* 889 */     reportRoleBetRankInfo(activityCfgid, roleid, RoleInterface.getName(roleid), RoleInterface.getOccupationId(roleid), xRoleCrossBattleBetProfitInfo.getProfit(), xRoleCrossBattleBetProfitInfo.getTimestamp(), 1);
/*     */     
/* 891 */     logger.info(String.format("[crossbattle]CrossBattleBetManager.refreshRoleBetProfitInfo@refresh role bet profit info|activity_cfg_id=%d|roleid=%d|add_profit=%d|profit=%d|timestamp=%d", new Object[] { Integer.valueOf(activityCfgid), Long.valueOf(roleid), Long.valueOf(addProfit), Long.valueOf(xRoleCrossBattleBetProfitInfo.getProfit()), Long.valueOf(xRoleCrossBattleBetProfitInfo.getTimestamp()) }));
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
/*     */   static void reportRoleBetRankInfo(int activityCfgid, long roleid, String name, int occupation, long profit, long timestamp, int count)
/*     */   {
/* 911 */     if ((count <= 0L) || (count >= 127) || (count > GRC_MAX_TRY_TIMES))
/*     */     {
/* 913 */       return;
/*     */     }
/* 915 */     if (profit > 0L)
/*     */     {
/* 917 */       ReportRoleCrossBattleBetRankInfoContext context = new ReportRoleCrossBattleBetRankInfoContext();
/* 918 */       context.count = ((byte)count);
/* 919 */       OctetsStream os = new OctetsStream();
/* 920 */       context.marshal(os);
/* 921 */       boolean ret = CrossServerInterface.reportRoleCrossBattleBetWinRankInfo(activityCfgid, roleid, RoleInterface.getName(roleid), RoleInterface.getOccupationId(roleid), profit, timestamp, os);
/*     */       
/* 923 */       if (!ret)
/*     */       {
/* 925 */         logger.error(String.format("[crossbattle]CrossBattleBetManager.reportRoleBetRankInfo@report role cross battle bet win rank info fail|count=%d|activity_cfg_id=%d|roleid=%d|profit=%d|timestamp=%d", new Object[] { Byte.valueOf(context.count), Integer.valueOf(activityCfgid), Long.valueOf(roleid), Long.valueOf(profit), Long.valueOf(timestamp) }));
/*     */       }
/*     */       
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 932 */       RemoveRoleCrossBattleBetRankInfoContext context = new RemoveRoleCrossBattleBetRankInfoContext();
/* 933 */       context.count = ((byte)count);
/* 934 */       OctetsStream os = new OctetsStream();
/* 935 */       context.marshal(os);
/* 936 */       boolean ret = CrossServerInterface.removeRoleCrossBattleBetWinRankInfo(activityCfgid, roleid, os);
/* 937 */       if (!ret)
/*     */       {
/* 939 */         logger.error(String.format("[crossbattle]CrossBattleBetManager.reportRoleBetRankInfo@remove role cross battle bet win rank info fail|count=%d|activity_cfg_id=%d|roleid=%d|profit=%d|timestamp=%d", new Object[] { Byte.valueOf(context.count), Integer.valueOf(activityCfgid), Long.valueOf(roleid), Long.valueOf(profit), Long.valueOf(timestamp) }));
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 945 */     if (profit < 0L)
/*     */     {
/* 947 */       ReportRoleCrossBattleBetRankInfoContext context = new ReportRoleCrossBattleBetRankInfoContext();
/* 948 */       context.count = ((byte)count);
/* 949 */       OctetsStream os = new OctetsStream();
/* 950 */       context.marshal(os);
/* 951 */       boolean ret = CrossServerInterface.reportRoleCrossBattleBetLoseRankInfo(activityCfgid, roleid, RoleInterface.getName(roleid), RoleInterface.getOccupationId(roleid), profit, timestamp, os);
/*     */       
/* 953 */       if (!ret)
/*     */       {
/* 955 */         logger.error(String.format("[crossbattle]CrossBattleBetManager.reportRoleBetRankInfo@report role cross battle bet lose rank info fail|count=%d|activity_cfg_id=%d|roleid=%d|profit=%d|timestamp=%d", new Object[] { Byte.valueOf(context.count), Integer.valueOf(activityCfgid), Long.valueOf(roleid), Long.valueOf(profit), Long.valueOf(timestamp) }));
/*     */       }
/*     */       
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 962 */       RemoveRoleCrossBattleBetRankInfoContext context = new RemoveRoleCrossBattleBetRankInfoContext();
/* 963 */       context.count = ((byte)count);
/* 964 */       OctetsStream os = new OctetsStream();
/* 965 */       context.marshal(os);
/* 966 */       boolean ret = CrossServerInterface.removeRoleCrossBattleBetLoseRankInfo(activityCfgid, roleid, os);
/* 967 */       if (!ret)
/*     */       {
/* 969 */         logger.error(String.format("[crossbattle]CrossBattleBetManager.reportRoleBetRankInfo@remove role cross battle bet lose rank info fail|count=%d|activity_cfg_id=%d|roleid=%d|profit=%d|timestamp=%d", new Object[] { Byte.valueOf(context.count), Integer.valueOf(activityCfgid), Long.valueOf(roleid), Long.valueOf(profit), Long.valueOf(timestamp) }));
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\bet\CrossBattleBetManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
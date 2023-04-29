/*     */ package mzm.gsp.crossbattle.bet;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.crossbattle.RoundRobinFightInfo;
/*     */ import mzm.gsp.crossbattle.SGetRoundRobinRoundBetInfoFail;
/*     */ import mzm.gsp.crossbattle.SGetRoundRobinRoundBetInfoSuccess;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattleRoundRobinBetCfg;
/*     */ import mzm.gsp.crossbattle.own.CrossBattleOwnInfo;
/*     */ import mzm.gsp.crossbattle.own.CrossBattleOwnInterface;
/*     */ import mzm.gsp.crossbattle.own.CrossBattleRoundRobinFightInfo;
/*     */ import mzm.gsp.crossbattle.own.CrossBattleRoundRobinRoundInfo;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.CrossBattleRoundRobinBet;
/*     */ import xbean.RoleRoundRobinFightBetInfo;
/*     */ import xbean.RoundRobinRoundBetInfo;
/*     */ import xtable.Cross_battle_round_robin_bets;
/*     */ 
/*     */ public class PCGetRoundRobinRoundBetInfo extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int activityCfgid;
/*     */   private final int roundIndex;
/*     */   
/*     */   public PCGetRoundRobinRoundBetInfo(long roleid, int activityCfgid, int roundIndex)
/*     */   {
/*  32 */     this.roleid = roleid;
/*  33 */     this.activityCfgid = activityCfgid;
/*  34 */     this.roundIndex = roundIndex;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  40 */     SCrossBattleRoundRobinBetCfg cfg = SCrossBattleRoundRobinBetCfg.get(this.activityCfgid);
/*  41 */     if (cfg == null)
/*     */     {
/*     */ 
/*  44 */       onFail(-3, null);
/*  45 */       return false;
/*     */     }
/*  47 */     if (!CrossBattleBetManager.isCrossBattleRoundRobinBetSwitchOpenForRole(this.roleid, this.activityCfgid))
/*     */     {
/*     */ 
/*  50 */       onFail(-1, null);
/*  51 */       return false;
/*     */     }
/*  53 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleid, 1412, true))
/*     */     {
/*     */ 
/*     */ 
/*  57 */       onFail(-2, null);
/*  58 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  62 */     CrossBattleOwnInfo crossBattleOwnInfo = CrossBattleOwnInterface.getCrossBattleOwnInfo(this.activityCfgid, true);
/*  63 */     if (crossBattleOwnInfo == null)
/*     */     {
/*     */ 
/*  66 */       onFail(1, null);
/*  67 */       return false;
/*     */     }
/*  69 */     CrossBattleBetManager.initXCrossBattleRoundRobinBet(this.activityCfgid);
/*  70 */     long globalActivityCfgid = GameServerInfoManager.toGlobalId(this.activityCfgid);
/*  71 */     CrossBattleRoundRobinBet xCrossBattleRoundRobinBet = Cross_battle_round_robin_bets.get(Long.valueOf(globalActivityCfgid));
/*  72 */     if (xCrossBattleRoundRobinBet == null)
/*     */     {
/*     */ 
/*  75 */       onFail(2, null);
/*  76 */       return false;
/*     */     }
/*  78 */     if ((this.roundIndex <= 0) || (this.roundIndex > xCrossBattleRoundRobinBet.getRound_bet_infos().size()) || (this.roundIndex > crossBattleOwnInfo.getRoundRobinRoundInfoList().size()))
/*     */     {
/*     */ 
/*     */ 
/*  82 */       onFail(-3, null);
/*  83 */       return false;
/*     */     }
/*  85 */     RoundRobinRoundBetInfo xRoundRobinRoundBetInfo = (RoundRobinRoundBetInfo)xCrossBattleRoundRobinBet.getRound_bet_infos().get(this.roundIndex - 1);
/*     */     
/*  87 */     CrossBattleRoundRobinRoundInfo crossBattleRoundRobinRoundInfo = crossBattleOwnInfo.getRoundRobinRoundInfo(this.roundIndex);
/*  88 */     SGetRoundRobinRoundBetInfoSuccess protocol = new SGetRoundRobinRoundBetInfoSuccess();
/*  89 */     protocol.activity_cfg_id = this.activityCfgid;
/*  90 */     protocol.round_index = this.roundIndex;
/*  91 */     protocol.stage = crossBattleRoundRobinRoundInfo.getStage();
/*  92 */     for (CrossBattleRoundRobinFightInfo crossBattleRoundRobinFightInfo : crossBattleRoundRobinRoundInfo.getRoundRobinFightInfoList())
/*     */     {
/*  94 */       long corpsAid = crossBattleRoundRobinFightInfo.getCorpsAid();
/*  95 */       long corpsBid = crossBattleRoundRobinFightInfo.getCorpsBid();
/*  96 */       boolean isBetInfoExist = false;
/*  97 */       for (xbean.RoundRobinFightBetInfo xRoundRobinFightBetInfo : xRoundRobinRoundBetInfo.getFight_bet_infos())
/*     */       {
/*  99 */         if ((xRoundRobinFightBetInfo.getCorps_a_id() == corpsAid) && (xRoundRobinFightBetInfo.getCorps_b_id() == corpsBid))
/*     */         {
/* 101 */           isBetInfoExist = true;
/* 102 */           mzm.gsp.crossbattle.RoundRobinFightBetInfo fightBetInfo = new mzm.gsp.crossbattle.RoundRobinFightBetInfo();
/* 103 */           protocol.fight_bet_infos.add(fightBetInfo);
/* 104 */           crossBattleOwnInfo.fillCorpsBriefInfo(fightBetInfo.fight_info.corps_a_brief_info, corpsAid);
/* 105 */           crossBattleOwnInfo.fillCorpsBriefInfo(fightBetInfo.fight_info.corps_b_brief_info, corpsBid);
/* 106 */           if (CrossBattleBetManager.isRoundRobinFightEnd(xRoundRobinFightBetInfo.getState()))
/*     */           {
/* 108 */             fightBetInfo.fight_info.state = xRoundRobinFightBetInfo.getState();
/*     */           }
/*     */           else
/*     */           {
/* 112 */             fightBetInfo.fight_info.state = crossBattleRoundRobinFightInfo.getState();
/*     */           }
/* 114 */           fightBetInfo.corps_a_bet_money_sum = xRoundRobinFightBetInfo.getCorps_a_bet_money_sum();
/* 115 */           fightBetInfo.corps_b_bet_money_sum = xRoundRobinFightBetInfo.getCorps_b_bet_money_sum();
/* 116 */           RoleRoundRobinFightBetInfo xRoleRoundRobinFightBetInfo = (RoleRoundRobinFightBetInfo)xRoundRobinFightBetInfo.getRole_bet_infos().get(Long.valueOf(this.roleid));
/*     */           
/* 118 */           if (xRoleRoundRobinFightBetInfo == null)
/*     */           {
/* 120 */             fightBetInfo.bet_corps_id = -1L;
/* 121 */             fightBetInfo.role_bet_money_num = -1; break;
/*     */           }
/*     */           
/*     */ 
/* 125 */           fightBetInfo.bet_corps_id = xRoleRoundRobinFightBetInfo.getBet_corps_id();
/* 126 */           fightBetInfo.role_bet_money_num = xRoleRoundRobinFightBetInfo.getMoney_num();
/*     */           
/* 128 */           break;
/*     */         }
/*     */       }
/* 131 */       if (!isBetInfoExist)
/*     */       {
/*     */ 
/* 134 */         return false;
/*     */       }
/*     */     }
/* 137 */     OnlineManager.getInstance().send(this.roleid, protocol);
/*     */     
/* 139 */     StringBuilder sb = new StringBuilder();
/* 140 */     sb.append(String.format("[crossbattle_bet]PCGetRoundRobinRoundBetInfo.processImp@get round robin round bet info success|roleid=%d|activity_cfg_id=%d|roundindex=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.roundIndex) }));
/*     */     
/*     */ 
/* 143 */     CrossBattleBetManager.logger.info(sb.toString());
/* 144 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/* 149 */     StringBuilder sb = new StringBuilder();
/* 150 */     sb.append(String.format("[crossbattle_bet]PCGetRoundRobinRoundBetInfo.processImp@get round robin round bet info fail|roleid=%d|activity_cfg_id=%d|roundindex=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.roundIndex), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 153 */     if (extraInfo != null)
/*     */     {
/* 155 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 157 */         sb.append("|").append((String)entry.getKey());
/* 158 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 161 */     CrossBattleBetManager.logger.info(sb.toString());
/* 162 */     if (res > 0)
/*     */     {
/* 164 */       SGetRoundRobinRoundBetInfoFail protocol = new SGetRoundRobinRoundBetInfoFail();
/* 165 */       protocol.res = res;
/* 166 */       OnlineManager.getInstance().sendAtOnce(this.roleid, protocol);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\bet\PCGetRoundRobinRoundBetInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
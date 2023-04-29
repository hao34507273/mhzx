/*     */ package mzm.gsp.crossbattle.bet;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattleRoundRobinBetCfg;
/*     */ import mzm.gsp.crossbattle.main.CrossBattleOneByOneManager;
/*     */ import mzm.gsp.crossbattle.own.CrossBattleOwnInfo;
/*     */ import mzm.gsp.crossbattle.own.CrossBattleOwnInterface;
/*     */ import mzm.gsp.crossbattle.own.CrossBattleRoundRobinFightInfo;
/*     */ import mzm.gsp.crossbattle.own.CrossBattleRoundRobinRoundInfo;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.CrossBattleRoundRobinBet;
/*     */ import xbean.RoleRoundRobinFightBetInfo;
/*     */ import xbean.RoundRobinFightBetInfo;
/*     */ import xbean.RoundRobinRoundBetInfo;
/*     */ import xtable.Cross_battle_round_robin_bets;
/*     */ 
/*     */ public class PTrySettleRoundRobinBet extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final int activityCfgid;
/*     */   
/*     */   public PTrySettleRoundRobinBet(int activityCfgid)
/*     */   {
/*  25 */     this.activityCfgid = activityCfgid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  31 */     SCrossBattleRoundRobinBetCfg cfg = SCrossBattleRoundRobinBetCfg.get(this.activityCfgid);
/*  32 */     if (cfg == null)
/*     */     {
/*     */ 
/*  35 */       onFail(-3, null);
/*  36 */       return false;
/*     */     }
/*  38 */     if (!CrossBattleBetManager.isCrossBattleRoundRobinBetSwitchOpen(this.activityCfgid))
/*     */     {
/*     */ 
/*  41 */       onFail(-1, null);
/*  42 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  46 */     CrossBattleOwnInfo crossBattleOwnInfo = CrossBattleOwnInterface.getCrossBattleOwnInfo(this.activityCfgid, true);
/*  47 */     if (crossBattleOwnInfo == null)
/*     */     {
/*     */ 
/*  50 */       onFail(1, null);
/*  51 */       return false;
/*     */     }
/*  53 */     CrossBattleBetManager.initXCrossBattleRoundRobinBet(this.activityCfgid);
/*  54 */     long globalActivityCfgid = mzm.gsp.GameServerInfoManager.toGlobalId(this.activityCfgid);
/*  55 */     CrossBattleRoundRobinBet xCrossBattleRoundRobinBet = Cross_battle_round_robin_bets.get(Long.valueOf(globalActivityCfgid));
/*  56 */     if (xCrossBattleRoundRobinBet == null)
/*     */     {
/*     */ 
/*  59 */       onFail(2, null);
/*  60 */       return false; }
/*     */     CrossBattleRoundRobinRoundInfo crossBattleRoundRobinRoundInfo;
/*  62 */     for (int i = 0; i < xCrossBattleRoundRobinBet.getRound_bet_infos().size(); i++)
/*     */     {
/*  64 */       RoundRobinRoundBetInfo xRoundRobinRoundBetInfo = (RoundRobinRoundBetInfo)xCrossBattleRoundRobinBet.getRound_bet_infos().get(i);
/*  65 */       crossBattleRoundRobinRoundInfo = crossBattleOwnInfo.getRoundRobinRoundInfo(i + 1);
/*  66 */       for (RoundRobinFightBetInfo xRoundRobinFightBetInfo : xRoundRobinRoundBetInfo.getFight_bet_infos())
/*     */       {
/*  68 */         long corpsAid = xRoundRobinFightBetInfo.getCorps_a_id();
/*  69 */         long corpsBid = xRoundRobinFightBetInfo.getCorps_b_id();
/*  70 */         if (CrossBattleBetManager.isRoundRobinFightEnd(xRoundRobinFightBetInfo.getState()))
/*     */         {
/*  72 */           for (Map.Entry<Long, RoleRoundRobinFightBetInfo> entry : xRoundRobinFightBetInfo.getRole_bet_infos().entrySet())
/*     */           {
/*  74 */             long roleid = ((Long)entry.getKey()).longValue();
/*  75 */             RoleRoundRobinFightBetInfo xRoleRoundRobinFightBetInfo = (RoleRoundRobinFightBetInfo)entry.getValue();
/*  76 */             if (!xRoleRoundRobinFightBetInfo.getHas_got_mail())
/*     */             {
/*  78 */               CrossBattleOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(this.activityCfgid), new PSendRoundRobinBetMail(roleid, this.activityCfgid, i + 1, corpsAid, corpsBid));
/*     */             }
/*     */           }
/*     */           
/*  82 */           StringBuilder sb = new StringBuilder();
/*  83 */           sb.append(String.format("[crossbattle_bet]PTrySettleRoundRobinBet.processImp@fight already end|activity_cfg_id=%d|round_index=%d|corps_a_id=%d|corps_b_id=%d|state=%d", new Object[] { Integer.valueOf(this.activityCfgid), Integer.valueOf(i + 1), Long.valueOf(corpsAid), Long.valueOf(corpsBid), Integer.valueOf(xRoundRobinFightBetInfo.getState()) }));
/*     */           
/*     */ 
/*  86 */           CrossBattleBetManager.logger.info(sb.toString());
/*     */         }
/*     */         else {
/*  89 */           boolean isFightExist = false;
/*  90 */           for (CrossBattleRoundRobinFightInfo crossBattleRoundRobinFightInfo : crossBattleRoundRobinRoundInfo.getRoundRobinFightInfoList())
/*     */           {
/*  92 */             if ((crossBattleRoundRobinFightInfo.getCorpsAid() == corpsAid) && (crossBattleRoundRobinFightInfo.getCorpsBid() == corpsBid))
/*     */             {
/*     */ 
/*  95 */               isFightExist = true;
/*  96 */               if (!CrossBattleBetManager.isRoundRobinFightEnd(crossBattleRoundRobinFightInfo.getState()))
/*     */               {
/*  98 */                 StringBuilder sb = new StringBuilder();
/*  99 */                 sb.append(String.format("[crossbattle_bet]PTrySettleRoundRobinBet.processImp@fight not end|activity_cfg_id=%d|round_index=%d|corps_a_id=%d|corps_b_id=%d|state=%d", new Object[] { Integer.valueOf(this.activityCfgid), Integer.valueOf(i + 1), Long.valueOf(corpsAid), Long.valueOf(corpsBid), Integer.valueOf(xRoundRobinFightBetInfo.getState()) }));
/*     */                 
/*     */ 
/* 102 */                 CrossBattleBetManager.logger.info(sb.toString());
/* 103 */                 break;
/*     */               }
/* 105 */               xRoundRobinFightBetInfo.setState(crossBattleRoundRobinFightInfo.getState());
/* 106 */               for (Map.Entry<Long, RoleRoundRobinFightBetInfo> entry : xRoundRobinFightBetInfo.getRole_bet_infos().entrySet())
/*     */               {
/* 108 */                 long roleid = ((Long)entry.getKey()).longValue();
/* 109 */                 RoleRoundRobinFightBetInfo xRoleRoundRobinFightBetInfo = (RoleRoundRobinFightBetInfo)entry.getValue();
/* 110 */                 if (!xRoleRoundRobinFightBetInfo.getHas_got_mail())
/*     */                 {
/* 112 */                   CrossBattleOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(this.activityCfgid), new PSendRoundRobinBetMail(roleid, this.activityCfgid, i + 1, corpsAid, corpsBid));
/*     */                 }
/*     */               }
/*     */               
/* 116 */               StringBuilder sb = new StringBuilder();
/* 117 */               sb.append(String.format("[crossbattle_bet]PTrySettleRoundRobinBet.processImp@fight end|activity_cfg_id=%d|round_index=%d|corps_a_id=%d|corps_b_id=%d|state=%d", new Object[] { Integer.valueOf(this.activityCfgid), Integer.valueOf(i + 1), Long.valueOf(corpsAid), Long.valueOf(corpsBid), Integer.valueOf(xRoundRobinFightBetInfo.getState()) }));
/*     */               
/*     */ 
/* 120 */               CrossBattleBetManager.logger.info(sb.toString());
/* 121 */               break;
/*     */             }
/*     */           }
/* 124 */           if (!isFightExist)
/*     */           {
/*     */ 
/* 127 */             onFail(4, null);
/* 128 */             return false;
/*     */           }
/*     */         }
/*     */       } }
/* 132 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/* 137 */     StringBuilder sb = new StringBuilder();
/* 138 */     sb.append(String.format("[crossbattle_bet]PTrySettleRoundRobinBet.processImp@try settle round robin bet fail|activity_cfg_id=%d|res=%d", new Object[] { Integer.valueOf(this.activityCfgid), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 141 */     if (extraInfo != null)
/*     */     {
/* 143 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 145 */         sb.append("|").append((String)entry.getKey());
/* 146 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 149 */     CrossBattleBetManager.logger.info(sb.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\bet\PTrySettleRoundRobinBet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
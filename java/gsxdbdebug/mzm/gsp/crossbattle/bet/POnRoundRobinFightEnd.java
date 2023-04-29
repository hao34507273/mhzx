/*     */ package mzm.gsp.crossbattle.bet;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattleRoundRobinBetCfg;
/*     */ import mzm.gsp.crossbattle.event.RoundRobinFightEndArg;
/*     */ import mzm.gsp.crossbattle.main.CrossBattleOneByOneManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.CrossBattleRoundRobinBet;
/*     */ import xbean.RoleRoundRobinFightBetInfo;
/*     */ import xbean.RoundRobinFightBetInfo;
/*     */ import xbean.RoundRobinRoundBetInfo;
/*     */ 
/*     */ public class POnRoundRobinFightEnd extends mzm.gsp.crossbattle.event.RoundRobinFightEndProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  20 */     SCrossBattleRoundRobinBetCfg cfg = SCrossBattleRoundRobinBetCfg.get(((RoundRobinFightEndArg)this.arg).activityCfgid);
/*  21 */     if (cfg == null)
/*     */     {
/*     */ 
/*  24 */       onFail(-3, null);
/*  25 */       return false;
/*     */     }
/*     */     
/*  28 */     CrossBattleBetManager.initXCrossBattleRoundRobinBet(((RoundRobinFightEndArg)this.arg).activityCfgid);
/*  29 */     long globalActivityCfgid = GameServerInfoManager.toGlobalId(((RoundRobinFightEndArg)this.arg).activityCfgid);
/*  30 */     CrossBattleRoundRobinBet xCrossBattleRoundRobinBet = xtable.Cross_battle_round_robin_bets.get(Long.valueOf(globalActivityCfgid));
/*  31 */     if (xCrossBattleRoundRobinBet == null)
/*     */     {
/*     */ 
/*  34 */       onFail(2, null);
/*  35 */       return false;
/*     */     }
/*  37 */     if ((((RoundRobinFightEndArg)this.arg).roundIndex <= 0) || (((RoundRobinFightEndArg)this.arg).roundIndex > xCrossBattleRoundRobinBet.getRound_bet_infos().size()))
/*     */     {
/*     */ 
/*  40 */       onFail(-3, null);
/*  41 */       return false;
/*     */     }
/*  43 */     RoundRobinRoundBetInfo xRoundRobinRoundBetInfo = (RoundRobinRoundBetInfo)xCrossBattleRoundRobinBet.getRound_bet_infos().get(((RoundRobinFightEndArg)this.arg).roundIndex - 1);
/*     */     
/*  45 */     boolean isFightExist = false;
/*  46 */     for (RoundRobinFightBetInfo xRoundRobinFightBetInfo : xRoundRobinRoundBetInfo.getFight_bet_infos())
/*     */     {
/*  48 */       if ((xRoundRobinFightBetInfo.getCorps_a_id() == ((RoundRobinFightEndArg)this.arg).corpsAid) && (xRoundRobinFightBetInfo.getCorps_b_id() == ((RoundRobinFightEndArg)this.arg).corpsBid))
/*     */       {
/*     */ 
/*  51 */         isFightExist = true;
/*  52 */         if (CrossBattleBetManager.isRoundRobinFightEnd(xRoundRobinFightBetInfo.getState()))
/*     */         {
/*     */ 
/*  55 */           onFail(3, null);
/*  56 */           return false;
/*     */         }
/*  58 */         xRoundRobinFightBetInfo.setState(((RoundRobinFightEndArg)this.arg).state);
/*  59 */         if (CrossBattleBetManager.isCrossBattleRoundRobinBetSwitchOpen(((RoundRobinFightEndArg)this.arg).activityCfgid))
/*     */         {
/*  61 */           for (Map.Entry<Long, RoleRoundRobinFightBetInfo> entry : xRoundRobinFightBetInfo.getRole_bet_infos().entrySet())
/*     */           {
/*  63 */             long roleid = ((Long)entry.getKey()).longValue();
/*  64 */             RoleRoundRobinFightBetInfo xRoleRoundRobinFightBetInfo = (RoleRoundRobinFightBetInfo)entry.getValue();
/*  65 */             if (!xRoleRoundRobinFightBetInfo.getHas_got_mail())
/*     */             {
/*  67 */               CrossBattleOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(((RoundRobinFightEndArg)this.arg).activityCfgid), new PSendRoundRobinBetMail(roleid, ((RoundRobinFightEndArg)this.arg).activityCfgid, ((RoundRobinFightEndArg)this.arg).roundIndex, ((RoundRobinFightEndArg)this.arg).corpsAid, ((RoundRobinFightEndArg)this.arg).corpsBid));
/*     */             }
/*     */           }
/*     */         }
/*     */         
/*     */ 
/*     */ 
/*  74 */         StringBuilder sb = new StringBuilder();
/*  75 */         sb.append(String.format("[crossbattle_bet]POnRoundRobinFightEnd.processImp@round robin fight end process success|activity_cfg_id=%d|round_index=%d|corps_a_id=%d|corps_b_id=%d|state=%d", new Object[] { Integer.valueOf(((RoundRobinFightEndArg)this.arg).activityCfgid), Integer.valueOf(((RoundRobinFightEndArg)this.arg).roundIndex), Long.valueOf(((RoundRobinFightEndArg)this.arg).corpsAid), Long.valueOf(((RoundRobinFightEndArg)this.arg).corpsBid), Integer.valueOf(((RoundRobinFightEndArg)this.arg).state) }));
/*     */         
/*     */ 
/*  78 */         CrossBattleBetManager.logger.info(sb.toString());
/*  79 */         break;
/*     */       }
/*     */     }
/*  82 */     if (!isFightExist)
/*     */     {
/*     */ 
/*  85 */       onFail(4, null);
/*  86 */       return false;
/*     */     }
/*  88 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/*  93 */     StringBuilder sb = new StringBuilder();
/*  94 */     sb.append(String.format("[crossbattle_bet]POnRoundRobinFightEnd.processImp@round robin fight end process fail|activity_cfg_id=%d|round_index=%d|corps_a_id=%d|corps_b_id=%d|state=%d|res=%d", new Object[] { Integer.valueOf(((RoundRobinFightEndArg)this.arg).activityCfgid), Integer.valueOf(((RoundRobinFightEndArg)this.arg).roundIndex), Long.valueOf(((RoundRobinFightEndArg)this.arg).corpsAid), Long.valueOf(((RoundRobinFightEndArg)this.arg).corpsBid), Integer.valueOf(((RoundRobinFightEndArg)this.arg).state), Integer.valueOf(res) }));
/*     */     
/*     */ 
/*  97 */     if (extraInfo != null)
/*     */     {
/*  99 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 101 */         sb.append("|").append((String)entry.getKey());
/* 102 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 105 */     CrossBattleBetManager.logger.info(sb.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\bet\POnRoundRobinFightEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
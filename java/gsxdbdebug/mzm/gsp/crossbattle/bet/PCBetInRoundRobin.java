/*     */ package mzm.gsp.crossbattle.bet;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.crossbattle.SBetInRoundRobinFail;
/*     */ import mzm.gsp.crossbattle.SBetInRoundRobinSuccess;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattleRoundRobinBetCfg;
/*     */ import mzm.gsp.crossbattle.own.CrossBattleOwnInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.CrossBattleRoundRobinBet;
/*     */ import xbean.RoleRoundRobinFightBetInfo;
/*     */ import xbean.RoundRobinFightBetInfo;
/*     */ import xbean.RoundRobinRoundBetInfo;
/*     */ import xtable.Basic;
/*     */ import xtable.Cross_battle_round_robin_bets;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCBetInRoundRobin extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int activityCfgid;
/*     */   private final int roundIndex;
/*     */   private final long targetCorpsid;
/*     */   private final int sortid;
/*     */   
/*     */   public PCBetInRoundRobin(long roleid, int activityCfgid, int roundIndex, long targetCorpsid, int sortid)
/*     */   {
/*  36 */     this.roleid = roleid;
/*  37 */     this.activityCfgid = activityCfgid;
/*  38 */     this.roundIndex = roundIndex;
/*  39 */     this.targetCorpsid = targetCorpsid;
/*  40 */     this.sortid = sortid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  46 */     if (this.targetCorpsid < 0L)
/*     */     {
/*     */ 
/*  49 */       onFail(-3, null);
/*  50 */       return false;
/*     */     }
/*  52 */     SCrossBattleRoundRobinBetCfg cfg = SCrossBattleRoundRobinBetCfg.get(this.activityCfgid);
/*  53 */     if ((cfg == null) || (!cfg.bet_infos.containsKey(Integer.valueOf(this.sortid))))
/*     */     {
/*     */ 
/*  56 */       onFail(-3, null);
/*  57 */       return false;
/*     */     }
/*  59 */     if (!CrossBattleBetManager.isCrossBattleRoundRobinBetSwitchOpenForRole(this.roleid, this.activityCfgid))
/*     */     {
/*     */ 
/*  62 */       onFail(-1, null);
/*  63 */       return false;
/*     */     }
/*  65 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleid, 1411, true))
/*     */     {
/*     */ 
/*     */ 
/*  69 */       onFail(-2, null);
/*  70 */       return false;
/*     */     }
/*     */     
/*  73 */     String userid = RoleInterface.getUserId(this.roleid);
/*     */     
/*  75 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*     */     
/*  77 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*  78 */     if (RoleInterface.getLevel(this.roleid) < cfg.bet_level_limit)
/*     */     {
/*     */ 
/*  81 */       onFail(10, null);
/*  82 */       return false;
/*     */     }
/*     */     
/*  85 */     switch (cfg.bet_cost_type)
/*     */     {
/*     */     case 2: 
/*  88 */       long gold = RoleInterface.getGold(this.roleid);
/*  89 */       if (gold < ((Integer)cfg.bet_infos.get(Integer.valueOf(this.sortid))).intValue())
/*     */       {
/*     */ 
/*  92 */         onFail(8, null);
/*  93 */         return false;
/*     */       }
/*  95 */       if (!RoleInterface.cutGold(this.roleid, ((Integer)cfg.bet_infos.get(Integer.valueOf(this.sortid))).intValue(), new TLogArg(LogReason.CROSS_BATTLE_ROUND_ROBIN_STAGE_BET_COST, this.activityCfgid)))
/*     */       {
/*     */ 
/*     */ 
/*  99 */         onFail(8, null);
/* 100 */         return false;
/*     */       }
/*     */       
/*     */       break;
/*     */     default: 
/* 105 */       onFail(-3, null);
/* 106 */       return false;
/*     */     }
/*     */     
/* 109 */     CrossBattleBetManager.initXCrossBattleRoundRobinBet(this.activityCfgid);
/* 110 */     long globalActivityCfgid = GameServerInfoManager.toGlobalId(this.activityCfgid);
/* 111 */     CrossBattleRoundRobinBet xCrossBattleRoundRobinBet = Cross_battle_round_robin_bets.get(Long.valueOf(globalActivityCfgid));
/* 112 */     if (xCrossBattleRoundRobinBet == null)
/*     */     {
/*     */ 
/* 115 */       onFail(2, null);
/* 116 */       return false;
/*     */     }
/* 118 */     if ((this.roundIndex <= 0) || (this.roundIndex > xCrossBattleRoundRobinBet.getRound_bet_infos().size()))
/*     */     {
/*     */ 
/* 121 */       onFail(-3, null);
/* 122 */       return false;
/*     */     }
/* 124 */     if (!CrossBattleBetManager.isInRoundRobinBetTime(this.activityCfgid, this.roundIndex))
/*     */     {
/*     */ 
/* 127 */       onFail(3, null);
/* 128 */       return false;
/*     */     }
/* 130 */     RoundRobinRoundBetInfo xRoundRobinRoundBetInfo = (RoundRobinRoundBetInfo)xCrossBattleRoundRobinBet.getRound_bet_infos().get(this.roundIndex - 1);
/*     */     
/* 132 */     boolean isFightExist = false;
/* 133 */     for (RoundRobinFightBetInfo xRoundRobinFightBetInfo : xRoundRobinRoundBetInfo.getFight_bet_infos())
/*     */     {
/* 135 */       if ((xRoundRobinFightBetInfo.getCorps_a_id() == this.targetCorpsid) || (xRoundRobinFightBetInfo.getCorps_b_id() == this.targetCorpsid))
/*     */       {
/*     */ 
/* 138 */         isFightExist = true;
/* 139 */         if (CrossBattleBetManager.isRoundRobinFightEnd(xRoundRobinFightBetInfo.getState()))
/*     */         {
/*     */ 
/* 142 */           onFail(4, null);
/* 143 */           return false;
/*     */         }
/* 145 */         List<Long> corpsARegisterList = CrossBattleOwnInterface.getCrossBattleRegisterRoleList(xRoundRobinFightBetInfo.getCorps_a_id(), this.activityCfgid, true);
/*     */         
/* 147 */         List<Long> corpsBRegisterList = CrossBattleOwnInterface.getCrossBattleRegisterRoleList(xRoundRobinFightBetInfo.getCorps_b_id(), this.activityCfgid, true);
/*     */         
/* 149 */         if ((corpsARegisterList == null) || (corpsBRegisterList == null))
/*     */         {
/*     */ 
/* 152 */           onFail(5, null);
/* 153 */           return false;
/*     */         }
/* 155 */         if ((corpsARegisterList.contains(Long.valueOf(this.roleid))) || (corpsBRegisterList.contains(Long.valueOf(this.roleid))))
/*     */         {
/*     */ 
/* 158 */           onFail(6, null);
/* 159 */           return false;
/*     */         }
/* 161 */         if (xRoundRobinFightBetInfo.getRole_bet_infos().containsKey(Long.valueOf(this.roleid)))
/*     */         {
/*     */ 
/* 164 */           onFail(7, null);
/* 165 */           return false;
/*     */         }
/* 167 */         RoleRoundRobinFightBetInfo xRoleRoundRobinFightBetInfo = xbean.Pod.newRoleRoundRobinFightBetInfo();
/* 168 */         xRoleRoundRobinFightBetInfo.setBet_corps_id(this.targetCorpsid);
/* 169 */         xRoleRoundRobinFightBetInfo.setMoney_num(((Integer)cfg.bet_infos.get(Integer.valueOf(this.sortid))).intValue());
/* 170 */         xRoundRobinFightBetInfo.getRole_bet_infos().put(Long.valueOf(this.roleid), xRoleRoundRobinFightBetInfo);
/* 171 */         if (this.targetCorpsid == xRoundRobinFightBetInfo.getCorps_a_id())
/*     */         {
/* 173 */           xRoundRobinFightBetInfo.setCorps_a_bet_money_sum(xRoundRobinFightBetInfo.getCorps_a_bet_money_sum() + ((Integer)cfg.bet_infos.get(Integer.valueOf(this.sortid))).intValue());
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/* 178 */           xRoundRobinFightBetInfo.setCorps_b_bet_money_sum(xRoundRobinFightBetInfo.getCorps_b_bet_money_sum() + ((Integer)cfg.bet_infos.get(Integer.valueOf(this.sortid))).intValue());
/*     */         }
/*     */         
/*     */ 
/* 182 */         SBetInRoundRobinSuccess protocol = new SBetInRoundRobinSuccess();
/* 183 */         protocol.activity_cfg_id = this.activityCfgid;
/* 184 */         protocol.round_index = this.roundIndex;
/* 185 */         protocol.target_corps_id = this.targetCorpsid;
/* 186 */         protocol.sortid = this.sortid;
/* 187 */         protocol.corps_a_bet_money_sum = xRoundRobinFightBetInfo.getCorps_a_bet_money_sum();
/* 188 */         protocol.corps_b_bet_money_sum = xRoundRobinFightBetInfo.getCorps_b_bet_money_sum();
/* 189 */         OnlineManager.getInstance().send(this.roleid, protocol);
/*     */         
/* 191 */         StringBuilder sb = new StringBuilder();
/* 192 */         sb.append(String.format("[crossbattle_bet]PCBetInRoundRobin.processImp@bet int round robin success|roleid=%d|activity_cfg_id=%d|round_index=%d|target_corps_id=%d|sortid=%d|money_num=%d|corps_a_id=%d|corps_b_id=%d|corps_a_bet_money_sum=%d|corps_b_bet_money_sum=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.roundIndex), Long.valueOf(this.targetCorpsid), Integer.valueOf(this.sortid), cfg.bet_infos.get(Integer.valueOf(this.sortid)), Long.valueOf(xRoundRobinFightBetInfo.getCorps_a_id()), Long.valueOf(xRoundRobinFightBetInfo.getCorps_b_id()), Long.valueOf(xRoundRobinFightBetInfo.getCorps_a_bet_money_sum()), Long.valueOf(xRoundRobinFightBetInfo.getCorps_b_bet_money_sum()) }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 198 */         CrossBattleBetManager.logger.info(sb.toString());
/* 199 */         CrossBattleBetTLogManager.addRoundRobinBetTLog(this.roleid, this.activityCfgid, 1, this.roundIndex, xRoundRobinFightBetInfo.getCorps_a_id(), xRoundRobinFightBetInfo.getCorps_b_id(), xRoundRobinFightBetInfo.getState(), this.targetCorpsid, ((Integer)cfg.bet_infos.get(Integer.valueOf(this.sortid))).intValue());
/*     */         
/*     */ 
/*     */ 
/* 203 */         break;
/*     */       }
/*     */     }
/* 206 */     if (!isFightExist)
/*     */     {
/*     */ 
/* 209 */       onFail(-3, null);
/* 210 */       return false;
/*     */     }
/* 212 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/* 217 */     StringBuilder sb = new StringBuilder();
/* 218 */     sb.append(String.format("[crossbattle_bet]PCBetInRoundRobin.processImp@bet int round robin fail|roleid=%d|activity_cfg_id=%d|round_index=%d|target_corps_id=%d|sortid=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.roundIndex), Long.valueOf(this.targetCorpsid), Integer.valueOf(this.sortid), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 221 */     if (extraInfo != null)
/*     */     {
/* 223 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 225 */         sb.append("|").append((String)entry.getKey());
/* 226 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 229 */     CrossBattleBetManager.logger.info(sb.toString());
/* 230 */     if (res > 0)
/*     */     {
/* 232 */       SBetInRoundRobinFail protocol = new SBetInRoundRobinFail();
/* 233 */       protocol.res = res;
/* 234 */       OnlineManager.getInstance().sendAtOnce(this.roleid, protocol);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\bet\PCBetInRoundRobin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
/*     */ package mzm.gsp.crossbattle.own;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.crossbattle.SWatchRoundRobinFightFail;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattleOwnCfg;
/*     */ import mzm.gsp.fight.main.FightInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.CrossBattleOwn;
/*     */ import xbean.RoundRobinFightInfo;
/*     */ import xbean.RoundRobinRoundInfo;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCWatchRoundRobinFight extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int activityCfgid;
/*     */   private final int roundIndex;
/*     */   private final long corpsAid;
/*     */   private final long corpsBid;
/*     */   private final long watchCorpsid;
/*     */   
/*     */   public PCWatchRoundRobinFight(long roleid, int activityCfgid, int roundIndex, long corpsAid, long corpsBid, long watchCorpsid)
/*     */   {
/*  31 */     this.roleid = roleid;
/*  32 */     this.activityCfgid = activityCfgid;
/*  33 */     this.roundIndex = roundIndex;
/*  34 */     this.corpsAid = corpsAid;
/*  35 */     this.corpsBid = corpsBid;
/*  36 */     this.watchCorpsid = watchCorpsid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  42 */     if ((this.corpsAid <= 0L) || (this.corpsBid <= 0L) || ((this.watchCorpsid != this.corpsAid) && (this.watchCorpsid != this.corpsBid)))
/*     */     {
/*     */ 
/*     */ 
/*  46 */       onFail(-3, null);
/*  47 */       return false;
/*     */     }
/*  49 */     if (!CrossBattleOwnManager.isCrossBattleRoundRobinStageSwitchOpenForRole(this.roleid, this.activityCfgid))
/*     */     {
/*     */ 
/*  52 */       onFail(-1, null);
/*  53 */       return false;
/*     */     }
/*  55 */     SCrossBattleOwnCfg cfg = SCrossBattleOwnCfg.get(this.activityCfgid);
/*  56 */     if (cfg == null)
/*     */     {
/*     */ 
/*  59 */       onFail(-3, null);
/*  60 */       return false;
/*     */     }
/*     */     
/*  63 */     String userid = RoleInterface.getUserId(this.roleid);
/*     */     
/*  65 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*     */     
/*  67 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*     */     
/*     */ 
/*  70 */     if (!CrossBattleOwnManager.isInRoundRobinStage(this.activityCfgid))
/*     */     {
/*     */ 
/*  73 */       onFail(2, null);
/*  74 */       return false;
/*     */     }
/*     */     
/*  77 */     long globalActivityCfgid = GameServerInfoManager.toGlobalId(this.activityCfgid);
/*  78 */     CrossBattleOwn xCrossBattleOwn = xtable.Cross_battle_owns.get(Long.valueOf(globalActivityCfgid));
/*  79 */     if ((this.roundIndex <= 0) || (this.roundIndex > xCrossBattleOwn.getRound_robin_round_infos().size()))
/*     */     {
/*     */ 
/*  82 */       onFail(-3, null);
/*  83 */       return false;
/*     */     }
/*  85 */     RoundRobinRoundInfo xRoundRobinRoundInfo = (RoundRobinRoundInfo)xCrossBattleOwn.getRound_robin_round_infos().get(this.roundIndex - 1);
/*     */     
/*  87 */     boolean isFightExist = false;
/*  88 */     for (RoundRobinFightInfo xRoundRobinFightInfo : xRoundRobinRoundInfo.getFight_infos())
/*     */     {
/*  90 */       if ((xRoundRobinFightInfo.getCorps_a_id() == this.corpsAid) && (xRoundRobinFightInfo.getCorps_b_id() == this.corpsBid))
/*     */       {
/*  92 */         if ((xRoundRobinFightInfo.getState() != 1) || (xRoundRobinFightInfo.getCorps_a_watch_roleid() <= 0L) || (xRoundRobinFightInfo.getCorps_b_watch_roleid() <= 0L))
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*  97 */           onFail(4, null);
/*  98 */           return false;
/*     */         }
/* 100 */         if (this.watchCorpsid == this.corpsAid)
/*     */         {
/* 102 */           FightInterface.observeFight(this.roleid, xRoundRobinFightInfo.getCorps_a_watch_roleid());
/*     */         }
/*     */         else
/*     */         {
/* 106 */           FightInterface.observeFight(this.roleid, xRoundRobinFightInfo.getCorps_b_watch_roleid());
/*     */         }
/* 108 */         isFightExist = true;
/* 109 */         break;
/*     */       }
/*     */     }
/* 112 */     if (!isFightExist)
/*     */     {
/*     */ 
/* 115 */       onFail(3, null);
/* 116 */       return false;
/*     */     }
/*     */     
/* 119 */     StringBuilder sb = new StringBuilder();
/* 120 */     sb.append(String.format("[crossbattle_own]PCWatchRoundRobinFight.processImp@watch round robin fight success|roleid=%d|activity_cfg_id=%d|roundindex=%d|corps_a_id=%d|corps_b_id=%d|watch_corps_id=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.roundIndex), Long.valueOf(this.corpsAid), Long.valueOf(this.corpsBid), Long.valueOf(this.watchCorpsid) }));
/*     */     
/*     */ 
/* 123 */     CrossBattleOwnManager.logger.info(sb.toString());
/* 124 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/* 129 */     StringBuilder sb = new StringBuilder();
/* 130 */     sb.append(String.format("[crossbattle_own]PCWatchRoundRobinFight.processImp@watch round robin fight fail|roleid=%d|activity_cfg_id=%d|roundindex=%d|corps_a_id=%d|corps_b_id=%d|watch_corps_id=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.roundIndex), Long.valueOf(this.corpsAid), Long.valueOf(this.corpsBid), Long.valueOf(this.watchCorpsid), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 133 */     if (extraInfo != null)
/*     */     {
/* 135 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 137 */         sb.append("|").append((String)entry.getKey());
/* 138 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 141 */     CrossBattleOwnManager.logger.info(sb.toString());
/* 142 */     if (res > 0)
/*     */     {
/* 144 */       SWatchRoundRobinFightFail protocol = new SWatchRoundRobinFightFail();
/* 145 */       protocol.res = res;
/* 146 */       OnlineManager.getInstance().sendAtOnce(this.roleid, protocol);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\own\PCWatchRoundRobinFight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
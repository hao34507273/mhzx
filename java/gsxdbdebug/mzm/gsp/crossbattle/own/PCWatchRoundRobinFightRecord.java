/*     */ package mzm.gsp.crossbattle.own;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.crossbattle.SWatchRoundRobinFightRecordFail;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattleOwnCfg;
/*     */ import mzm.gsp.fight.main.FightInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.CrossBattleOwn;
/*     */ import xbean.RoundRobinFightInfo;
/*     */ import xbean.RoundRobinRoundInfo;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCWatchRoundRobinFightRecord extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int activityCfgid;
/*     */   private final int roundIndex;
/*     */   private final long corpsAid;
/*     */   private final long corpsBid;
/*     */   
/*     */   public PCWatchRoundRobinFightRecord(long roleid, int activityCfgid, int roundIndex, long corpsAid, long corpsBid)
/*     */   {
/*  29 */     this.roleid = roleid;
/*  30 */     this.activityCfgid = activityCfgid;
/*  31 */     this.roundIndex = roundIndex;
/*  32 */     this.corpsAid = corpsAid;
/*  33 */     this.corpsBid = corpsBid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  39 */     if ((this.corpsAid <= 0L) || (this.corpsBid <= 0L))
/*     */     {
/*     */ 
/*  42 */       onFail(-3, null);
/*  43 */       return false;
/*     */     }
/*  45 */     if (!CrossBattleOwnManager.isCrossBattleRoundRobinStageSwitchOpenForRole(this.roleid, this.activityCfgid))
/*     */     {
/*     */ 
/*  48 */       onFail(-1, null);
/*  49 */       return false;
/*     */     }
/*  51 */     SCrossBattleOwnCfg cfg = SCrossBattleOwnCfg.get(this.activityCfgid);
/*  52 */     if (cfg == null)
/*     */     {
/*     */ 
/*  55 */       onFail(-3, null);
/*  56 */       return false;
/*     */     }
/*     */     
/*  59 */     String userid = mzm.gsp.role.main.RoleInterface.getUserId(this.roleid);
/*     */     
/*  61 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*     */     
/*  63 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*     */     
/*     */ 
/*  66 */     if (!CrossBattleOwnManager.isActivityOpen(this.activityCfgid))
/*     */     {
/*     */ 
/*  69 */       onFail(1, null);
/*  70 */       return false;
/*     */     }
/*     */     
/*  73 */     long globalActivityCfgid = GameServerInfoManager.toGlobalId(this.activityCfgid);
/*  74 */     CrossBattleOwn xCrossBattleOwn = xtable.Cross_battle_owns.get(Long.valueOf(globalActivityCfgid));
/*  75 */     if ((this.roundIndex <= 0) || (this.roundIndex > xCrossBattleOwn.getRound_robin_round_infos().size()))
/*     */     {
/*     */ 
/*  78 */       onFail(-3, null);
/*  79 */       return false;
/*     */     }
/*  81 */     RoundRobinRoundInfo xRoundRobinRoundInfo = (RoundRobinRoundInfo)xCrossBattleOwn.getRound_robin_round_infos().get(this.roundIndex - 1);
/*     */     
/*  83 */     boolean isFightExist = false;
/*  84 */     for (RoundRobinFightInfo xRoundRobinFightInfo : xRoundRobinRoundInfo.getFight_infos())
/*     */     {
/*  86 */       if ((xRoundRobinFightInfo.getCorps_a_id() == this.corpsAid) && (xRoundRobinFightInfo.getCorps_b_id() == this.corpsBid))
/*     */       {
/*  88 */         if (xRoundRobinFightInfo.getRecordid() <= 0L)
/*     */         {
/*     */ 
/*  91 */           onFail(4, null);
/*  92 */           return false;
/*     */         }
/*  94 */         FightInterface.watchFightRecord(this.roleid, xRoundRobinFightInfo.getRecordid());
/*  95 */         isFightExist = true;
/*  96 */         break;
/*     */       }
/*     */     }
/*  99 */     if (!isFightExist)
/*     */     {
/*     */ 
/* 102 */       onFail(3, null);
/* 103 */       return false;
/*     */     }
/*     */     
/* 106 */     StringBuilder sb = new StringBuilder();
/* 107 */     sb.append(String.format("[crossbattle_own]PCWatchRoundRobinFightRecord.processImp@watch round robin fight record success|roleid=%d|activity_cfg_id=%d|roundindex=%d|corps_a_id=%d|corps_b_id=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.roundIndex), Long.valueOf(this.corpsAid), Long.valueOf(this.corpsBid) }));
/*     */     
/*     */ 
/* 110 */     CrossBattleOwnManager.logger.info(sb.toString());
/* 111 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/* 116 */     StringBuilder sb = new StringBuilder();
/* 117 */     sb.append(String.format("[crossbattle_own]PCWatchRoundRobinFightRecord.processImp@watch round robin fight record fail|roleid=%d|activity_cfg_id=%d|roundindex=%d|corps_a_id=%d|corps_b_id=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.roundIndex), Long.valueOf(this.corpsAid), Long.valueOf(this.corpsBid), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 120 */     if (extraInfo != null)
/*     */     {
/* 122 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 124 */         sb.append("|").append((String)entry.getKey());
/* 125 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 128 */     CrossBattleOwnManager.logger.info(sb.toString());
/* 129 */     if (res > 0)
/*     */     {
/* 131 */       SWatchRoundRobinFightRecordFail protocol = new SWatchRoundRobinFightRecordFail();
/* 132 */       protocol.res = res;
/* 133 */       OnlineManager.getInstance().sendAtOnce(this.roleid, protocol);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\own\PCWatchRoundRobinFightRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
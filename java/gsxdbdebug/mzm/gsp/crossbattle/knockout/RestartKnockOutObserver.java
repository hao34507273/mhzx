/*     */ package mzm.gsp.crossbattle.knockout;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.crossbattle.confbean.KnockOutCfg;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattleKnockOutCfg;
/*     */ import mzm.gsp.grc.main.GrcInterface;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.timer.main.MilliObserver;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.Pair;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class RestartKnockOutObserver
/*     */   extends MilliObserver
/*     */ {
/*     */   private final int activityCfgId;
/*     */   private final int knockOutType;
/*     */   private final int fightStage;
/*     */   private final long restartPrepareWorldBeginTime;
/*  27 */   public boolean isAllFightZoneRestart = false;
/*     */   
/*  29 */   public List<Pair<Integer, Integer>> restartFightList = new ArrayList();
/*     */   
/*     */ 
/*     */   public RestartKnockOutObserver(long intervalMilliSeconds, int activityCfgId, int knockOutType, int fightStage, long restartPrepareWorldBeginTime)
/*     */   {
/*  34 */     super(intervalMilliSeconds);
/*  35 */     this.activityCfgId = activityCfgId;
/*  36 */     this.knockOutType = knockOutType;
/*  37 */     this.fightStage = fightStage;
/*  38 */     this.restartPrepareWorldBeginTime = restartPrepareWorldBeginTime;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean update()
/*     */   {
/*  44 */     new POnRestartKnockOut(this.activityCfgId, this.knockOutType, this.fightStage, this.isAllFightZoneRestart, this.restartFightList, this.restartPrepareWorldBeginTime).execute();
/*     */     
/*  46 */     return false;
/*     */   }
/*     */   
/*     */   public long getRestartPrepareWorldBeginTime()
/*     */   {
/*  51 */     return this.restartPrepareWorldBeginTime;
/*     */   }
/*     */   
/*     */ 
/*     */   private static class POnRestartKnockOut
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final int activityCfgId;
/*     */     
/*     */     private final int knockOutType;
/*     */     
/*     */     private final int fightStage;
/*     */     
/*     */     private final boolean isAllFightZoneRestart;
/*     */     private final List<Pair<Integer, Integer>> restartFightList;
/*     */     private final long restartPrepareWorldBeginTime;
/*     */     
/*     */     public POnRestartKnockOut(int activityCfgId, int knockOutType, int fightStage, boolean isAllFightZoneRestart, List<Pair<Integer, Integer>> restartFightList, long restartPrepareWorldBeginTime)
/*     */     {
/*  70 */       this.activityCfgId = activityCfgId;
/*  71 */       this.knockOutType = knockOutType;
/*  72 */       this.fightStage = fightStage;
/*  73 */       this.isAllFightZoneRestart = isAllFightZoneRestart;
/*  74 */       this.restartFightList = restartFightList;
/*  75 */       this.restartPrepareWorldBeginTime = restartPrepareWorldBeginTime;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  81 */       SCrossBattleKnockOutCfg sCrossBattleKnockOutCfg = SCrossBattleKnockOutCfg.get(this.activityCfgId);
/*  82 */       if (sCrossBattleKnockOutCfg == null)
/*     */       {
/*  84 */         return false;
/*     */       }
/*     */       
/*  87 */       KnockOutCfg knockOutCfg = (KnockOutCfg)sCrossBattleKnockOutCfg.knockOutTypeCfgMap.get(Integer.valueOf(this.knockOutType));
/*  88 */       if (knockOutCfg == null)
/*     */       {
/*  90 */         return false;
/*     */       }
/*     */       
/*  93 */       int maxFightZoneId = CrossBattleKnockoutManager.getMaxFightZone(this.activityCfgId, this.knockOutType);
/*  94 */       if (maxFightZoneId < 0)
/*     */       {
/*  96 */         return false;
/*     */       }
/*     */       
/*  99 */       int maxFightIndexId = CrossBattleKnockoutManager.getMaxFightIndexId(knockOutCfg.need_team_size, this.fightStage, knockOutCfg.fight_times_every_stage);
/*     */       
/* 101 */       if (maxFightIndexId < 0)
/*     */       {
/* 103 */         return false;
/*     */       }
/*     */       
/* 106 */       long worldId = MapInterface.createWorld(Arrays.asList(new Integer[] { Integer.valueOf(knockOutCfg.prepare_map_cfg_id) }));
/*     */       
/*     */ 
/* 109 */       CrossBattleKnockOutMapTeamHandler teamHandler = new CrossBattleKnockOutMapTeamHandler();
/* 110 */       TeamInterface.registerJoinTeam(worldId, teamHandler);
/*     */       
/* 112 */       long endTime = this.restartPrepareWorldBeginTime + knockOutCfg.prepare_world_countdown * 60000L;
/*     */       
/* 114 */       CrossBattleKnockOutPrepareWorldManager.getInstance().setPrepareWorldId(worldId, endTime, this.knockOutType, true);
/*     */       
/*     */ 
/* 117 */       new POnCrossBattleKnockOutStageStart.KnockOutMatchMillObserver(endTime - DateTimeUtils.getCurrTimeInMillis() + 2000L, this.knockOutType, this.fightStage);
/*     */       
/*     */ 
/* 120 */       boolean isSendSuccess = GrcInterface.getNotifyKnockOutRestartCorpsIdList(this.restartPrepareWorldBeginTime, this.activityCfgId, this.knockOutType, this.isAllFightZoneRestart, this.restartFightList, this.fightStage, maxFightIndexId, maxFightZoneId, GameServerInfoManager.getZoneIds(), 2);
/*     */       
/*     */ 
/*     */ 
/* 124 */       CrossBattleKnockoutManager.clearRestartObserver();
/*     */       
/* 126 */       StringBuilder sBuilder = new StringBuilder();
/* 127 */       sBuilder.append("[crossbattle_knockout]PRestartKnockOutObserver.processImp@knock out restart");
/* 128 */       sBuilder.append("|is_send_success=").append(isSendSuccess);
/* 129 */       sBuilder.append("|activity_cfg_id=").append(this.activityCfgId);
/* 130 */       sBuilder.append("|knock_out_type=").append(this.knockOutType);
/* 131 */       sBuilder.append("|fight_stage=").append(this.fightStage);
/* 132 */       sBuilder.append("|is_all_fight_zone_start=").append(this.isAllFightZoneRestart);
/* 133 */       if ((this.restartFightList != null) && (!this.restartFightList.isEmpty()))
/*     */       {
/* 135 */         for (Pair<Integer, Integer> fightPair : this.restartFightList)
/*     */         {
/* 137 */           sBuilder.append("|fight_zone_id=").append(fightPair.first);
/* 138 */           sBuilder.append("|fight_index_id=").append(fightPair.second);
/*     */         }
/*     */       }
/* 141 */       sBuilder.append("|restart_world_begin_time=").append(this.restartPrepareWorldBeginTime);
/*     */       
/* 143 */       GameServer.logger().info(sBuilder.toString());
/*     */       
/* 145 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\knockout\RestartKnockOutObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
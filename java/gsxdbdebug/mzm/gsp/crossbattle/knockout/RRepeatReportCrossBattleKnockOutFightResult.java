/*     */ package mzm.gsp.crossbattle.knockout;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.crossbattle.own.CrossBattleOwnInterface;
/*     */ import mzm.gsp.grc.main.GrcInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Executor;
/*     */ import xdb.Xdb;
/*     */ 
/*     */ public class RRepeatReportCrossBattleKnockOutFightResult implements Runnable
/*     */ {
/*     */   private final int activityCfgId;
/*     */   private final int knockOutType;
/*     */   private final int fightZoneId;
/*     */   private final int fightStage;
/*     */   private final long ownCorpsId;
/*     */   private final String ownCorpsName;
/*     */   private final long opponentCorpsId;
/*     */   private final String opponentCorpsName;
/*     */   private final int fightIndexId;
/*     */   private final int maxFightStage;
/*     */   private final int fightTimesEveryRound;
/*     */   private final String result;
/*     */   private int repeatTimes;
/*     */   
/*     */   public RRepeatReportCrossBattleKnockOutFightResult(int activityCfgId, int knockOutType, int fightZoneId, int fightStage, long ownCorpsId, String ownCorpsName, long opponentCorpsId, String opponentCorpsName, int fightIndexId, int maxFightStage, int fightTimesEveryRound, String result, int repeatTimes)
/*     */   {
/*  32 */     this.activityCfgId = activityCfgId;
/*  33 */     this.knockOutType = knockOutType;
/*  34 */     this.fightZoneId = fightZoneId;
/*  35 */     this.fightStage = fightStage;
/*  36 */     this.ownCorpsId = ownCorpsId;
/*  37 */     this.ownCorpsName = ownCorpsName;
/*  38 */     this.opponentCorpsId = opponentCorpsId;
/*  39 */     this.opponentCorpsName = opponentCorpsName;
/*  40 */     this.fightIndexId = fightIndexId;
/*  41 */     this.maxFightStage = maxFightStage;
/*  42 */     this.fightTimesEveryRound = fightTimesEveryRound;
/*  43 */     this.result = result;
/*  44 */     this.repeatTimes = repeatTimes;
/*     */   }
/*     */   
/*     */ 
/*     */   public void run()
/*     */   {
/*  50 */     StringBuilder contextBuilder = new StringBuilder();
/*  51 */     contextBuilder.append("|activity_cfg_id=").append(this.activityCfgId);
/*  52 */     contextBuilder.append("|knock_out_type=").append(this.knockOutType);
/*  53 */     contextBuilder.append("|fight_zone_id=").append(this.fightZoneId);
/*  54 */     contextBuilder.append("|own_corps_id=").append(this.ownCorpsId);
/*  55 */     contextBuilder.append("|own_corps_name=").append(this.ownCorpsName);
/*  56 */     contextBuilder.append("|opponent_corps_id=").append(this.opponentCorpsId);
/*  57 */     contextBuilder.append("|opponent_corps_name=").append(this.opponentCorpsName);
/*  58 */     contextBuilder.append("|fight_index_id=").append(this.fightIndexId);
/*  59 */     contextBuilder.append("|max_fight_stage=").append(this.maxFightStage);
/*  60 */     contextBuilder.append("|fight_times_every_roune=").append(this.fightTimesEveryRound);
/*  61 */     contextBuilder.append("|result=").append(this.result);
/*  62 */     contextBuilder.append("|repeat_times=").append(this.repeatTimes);
/*     */     
/*  64 */     boolean isSendSuccess = GrcInterface.reportCrossBattleKnockOutFightResult(this.activityCfgId, this.knockOutType, this.fightZoneId, this.fightStage, this.ownCorpsId, this.ownCorpsName, this.opponentCorpsId, this.opponentCorpsName, this.fightIndexId, this.maxFightStage, this.fightTimesEveryRound, this.result);
/*     */     
/*     */ 
/*     */ 
/*  68 */     if (!isSendSuccess)
/*     */     {
/*  70 */       this.repeatTimes += 1;
/*  71 */       Xdb.executor().schedule(this, 60000L, TimeUnit.MILLISECONDS);
/*     */       
/*  73 */       StringBuilder sBuilder = new StringBuilder();
/*  74 */       sBuilder.append("[crossbattle_knockout]RRepeatReportCrossBattleKnockOutFightResult.send failed");
/*  75 */       sBuilder.append(contextBuilder.toString());
/*     */       
/*  77 */       GameServer.logger().info(sBuilder.toString());
/*  78 */       return;
/*     */     }
/*     */     
/*  81 */     new PNotifyFightResult(this.ownCorpsId, this.opponentCorpsId, this.activityCfgId, this.fightIndexId, this.knockOutType, this.fightStage).execute();
/*     */     
/*     */ 
/*  84 */     StringBuilder sBuilder = new StringBuilder();
/*  85 */     sBuilder.append("[crossbattle_knockout]RRepeatReportCrossBattleKnockOutFightResult.send success");
/*  86 */     sBuilder.append("context=").append(contextBuilder.toString());
/*     */     
/*  88 */     GameServer.logger().info(sBuilder.toString());
/*     */   }
/*     */   
/*     */   private static class PNotifyFightResult
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final long corpsId;
/*     */     private final long opponentCorpsId;
/*     */     private final int nowActivityCfgId;
/*     */     private final int fightIndexId;
/*     */     private final int knockOutType;
/*     */     private final int fightStage;
/*     */     
/*     */     public PNotifyFightResult(long corpsId, long opponentCorpsId, int nowActivityCfgId, int fightIndexId, int knockOutType, int fightStage)
/*     */     {
/* 103 */       this.corpsId = corpsId;
/* 104 */       this.opponentCorpsId = opponentCorpsId;
/* 105 */       this.nowActivityCfgId = nowActivityCfgId;
/* 106 */       this.fightIndexId = fightIndexId;
/* 107 */       this.knockOutType = knockOutType;
/* 108 */       this.fightStage = fightStage;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 114 */       List<Long> roleIdList = CrossBattleOwnInterface.getCrossBattleRegisterRoleList(this.corpsId, this.nowActivityCfgId, true);
/*     */       
/*     */       Iterator i$;
/* 117 */       if ((roleIdList != null) && (!roleIdList.isEmpty()))
/*     */       {
/* 119 */         for (i$ = roleIdList.iterator(); i$.hasNext();) { final long roleId = ((Long)i$.next()).longValue();
/*     */           
/* 121 */           Xdb.executor().schedule(new Runnable()
/*     */           {
/*     */ 
/*     */ 
/*     */             public void run() {
/* 126 */               new PQueryToNotifyFightResult(roleId, RRepeatReportCrossBattleKnockOutFightResult.PNotifyFightResult.this.corpsId, RRepeatReportCrossBattleKnockOutFightResult.PNotifyFightResult.this.opponentCorpsId, RRepeatReportCrossBattleKnockOutFightResult.PNotifyFightResult.this.knockOutType, RRepeatReportCrossBattleKnockOutFightResult.PNotifyFightResult.this.fightStage, RRepeatReportCrossBattleKnockOutFightResult.PNotifyFightResult.this.fightIndexId, 0).execute(); } }, 2000L, TimeUnit.MILLISECONDS);
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 132 */       return false;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\knockout\RRepeatReportCrossBattleKnockOutFightResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
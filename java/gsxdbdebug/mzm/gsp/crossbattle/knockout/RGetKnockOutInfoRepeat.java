/*    */ package mzm.gsp.crossbattle.knockout;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import mzm.gsp.grc.main.GrcInterface;
/*    */ import xdb.Executor;
/*    */ import xdb.Xdb;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RGetKnockOutInfoRepeat
/*    */   implements Runnable
/*    */ {
/*    */   private final int activityCfgId;
/*    */   private final int knockOutType;
/*    */   private final int fightZoneId;
/*    */   private final int fightStage;
/*    */   private final int needTeamSize;
/*    */   private final int maxStageSize;
/*    */   private final int fightTimesEveryStage;
/*    */   private final Octets context;
/*    */   private int repeatTimes;
/*    */   
/*    */   public RGetKnockOutInfoRepeat(int activityCfgId, int knockOutType, int fightZoneId, int fightStage, int needTeamSize, int maxStageSize, int fightTimesEveryStage, Octets context, int repeatTimes)
/*    */   {
/* 28 */     this.activityCfgId = activityCfgId;
/* 29 */     this.knockOutType = knockOutType;
/* 30 */     this.fightZoneId = fightZoneId;
/* 31 */     this.fightStage = fightStage;
/* 32 */     this.needTeamSize = needTeamSize;
/* 33 */     this.maxStageSize = maxStageSize;
/* 34 */     this.fightTimesEveryStage = fightTimesEveryStage;
/* 35 */     this.context = context;
/* 36 */     this.repeatTimes = repeatTimes;
/*    */   }
/*    */   
/*    */ 
/*    */   public void run()
/*    */   {
/* 42 */     boolean isSendSuccess = GrcInterface.getCrossBattleKnockOutInfo(this.activityCfgId, this.knockOutType, this.fightZoneId, this.fightStage, this.needTeamSize, this.maxStageSize, this.fightTimesEveryStage, new OctetsStream().marshal(this.context));
/*    */     
/*    */ 
/* 45 */     if (!isSendSuccess)
/*    */     {
/* 47 */       if (this.repeatTimes < 10)
/*    */       {
/* 49 */         this.repeatTimes += 1;
/* 50 */         Xdb.executor().schedule(this, 60000L, TimeUnit.MILLISECONDS);
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\knockout\RGetKnockOutInfoRepeat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
/*    */ package mzm.gsp.crossbattle.bet;
/*    */ 
/*    */ import mzm.gsp.crossbattle.main.CrossBattleOneByOneManager;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TrySettleKnockoutStageBetSession
/*    */   extends Session
/*    */ {
/*    */   private final int activityCfgid;
/*    */   private final int knockoutType;
/*    */   private final int fightZoneid;
/*    */   private final int stage;
/*    */   private final int tryTimes;
/*    */   
/*    */   public TrySettleKnockoutStageBetSession(long interval, long roleid, int activityCfgid, int knockoutType, int fightZoneid, int stage, int tryTimes)
/*    */   {
/* 21 */     super(interval, roleid);
/* 22 */     this.activityCfgid = activityCfgid;
/* 23 */     this.knockoutType = knockoutType;
/* 24 */     this.fightZoneid = fightZoneid;
/* 25 */     this.stage = stage;
/* 26 */     this.tryTimes = tryTimes;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 32 */     CrossBattleOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(this.activityCfgid), new PTrySettleKnockoutStageBet(this.activityCfgid, this.knockoutType, this.fightZoneid, this.stage, this.tryTimes));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\bet\TrySettleKnockoutStageBetSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
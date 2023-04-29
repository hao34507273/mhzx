/*    */ package mzm.gsp.crossbattle.bet;
/*    */ 
/*    */ import mzm.gsp.crossbattle.main.CrossBattleOneByOneManager;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ReportRoleKnockoutBetInfoSession
/*    */   extends Session
/*    */ {
/*    */   private final int activityCfgid;
/*    */   private final int knockoutType;
/*    */   private final int fightZoneid;
/*    */   private final int stage;
/*    */   private final int fightIndex;
/*    */   private final long betCorpsid;
/*    */   private final int betMoneyNum;
/*    */   private final int tryTimes;
/*    */   
/*    */   public ReportRoleKnockoutBetInfoSession(long interval, long roleid, int activityCfgid, int knockoutType, int fightZoneid, int stage, int fightIndex, long betCorpsid, int betMoneyNum, int tryTimes)
/*    */   {
/* 25 */     super(interval, roleid);
/* 26 */     this.activityCfgid = activityCfgid;
/* 27 */     this.knockoutType = knockoutType;
/* 28 */     this.fightZoneid = fightZoneid;
/* 29 */     this.stage = stage;
/* 30 */     this.fightIndex = fightIndex;
/* 31 */     this.betCorpsid = betCorpsid;
/* 32 */     this.betMoneyNum = betMoneyNum;
/* 33 */     this.tryTimes = tryTimes;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 39 */     CrossBattleOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(this.activityCfgid), new PReportRoleKnockoutBetInfo(getOwerId(), this.activityCfgid, this.knockoutType, this.fightZoneid, this.stage, this.fightIndex, this.betCorpsid, this.betMoneyNum, this.tryTimes));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\bet\ReportRoleKnockoutBetInfoSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
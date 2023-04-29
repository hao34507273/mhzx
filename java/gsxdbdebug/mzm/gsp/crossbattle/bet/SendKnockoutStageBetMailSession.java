/*    */ package mzm.gsp.crossbattle.bet;
/*    */ 
/*    */ import mzm.gsp.crossbattle.main.CrossBattleOneByOneManager;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SendKnockoutStageBetMailSession
/*    */   extends Session
/*    */ {
/*    */   private final int activityCfgid;
/*    */   private final int knockoutType;
/*    */   private final int fightZoneid;
/*    */   private final int stage;
/*    */   
/*    */   public SendKnockoutStageBetMailSession(long interval, long roleid, int activityCfgid, int knockoutType, int fightZoneid, int stage)
/*    */   {
/* 20 */     super(interval, roleid);
/* 21 */     this.activityCfgid = activityCfgid;
/* 22 */     this.knockoutType = knockoutType;
/* 23 */     this.fightZoneid = fightZoneid;
/* 24 */     this.stage = stage;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 30 */     CrossBattleOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(this.activityCfgid), new PSendKnockoutStageBetMail(getOwerId(), this.activityCfgid, this.knockoutType, this.fightZoneid, this.stage));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\bet\SendKnockoutStageBetMailSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
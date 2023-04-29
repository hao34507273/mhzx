/*    */ package mzm.gsp.coupledaily.main;
/*    */ 
/*    */ import mzm.gsp.fight.main.FightContext;
/*    */ 
/*    */ class CoupleDailyFightContext implements FightContext
/*    */ {
/*    */   public final long leaderRoleId;
/*    */   public final long partnerRoleId;
/*    */   public final int fightCfgId;
/*    */   
/*    */   public CoupleDailyFightContext(long leaderRoleId, long partnerRoleId, int fightCfgId)
/*    */   {
/* 13 */     this.leaderRoleId = leaderRoleId;
/* 14 */     this.partnerRoleId = partnerRoleId;
/* 15 */     this.fightCfgId = fightCfgId;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean isRecordEnable()
/*    */   {
/* 21 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\coupledaily\main\CoupleDailyFightContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
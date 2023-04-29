/*    */ package mzm.gsp.coupledaily.main;
/*    */ 
/*    */ import mzm.gsp.paraselene.event.JigsawContext;
/*    */ 
/*    */ class CoupleDailyJigsawContext implements JigsawContext
/*    */ {
/*    */   public final long leaderRoleId;
/*    */   public final long partnerRoleId;
/*    */   public final int pinTuTaskCfgId;
/*    */   
/*    */   public CoupleDailyJigsawContext(long leaderRoleId, long partnerRoleId, int pinTuTaskCfgId)
/*    */   {
/* 13 */     this.leaderRoleId = leaderRoleId;
/* 14 */     this.partnerRoleId = partnerRoleId;
/* 15 */     this.pinTuTaskCfgId = pinTuTaskCfgId;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\coupledaily\main\CoupleDailyJigsawContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
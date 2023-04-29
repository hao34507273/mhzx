/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.mounts.event.MountsRankUpArg;
/*    */ import mzm.gsp.mounts.event.MountsRankUpProcedure;
/*    */ 
/*    */ public class POnMountsRankUp
/*    */   extends MountsRankUpProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     AchievementManager.updateGoalTypeState(((MountsRankUpArg)this.arg).roleId, 5900, null, "POnMountsRankUp.processImp@handle MOUNTS_SPECIFC_STAR success");
/*    */     
/*    */ 
/* 14 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnMountsRankUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.mounts.event.NewMountsGetArg;
/*    */ import mzm.gsp.mounts.event.NewMountsGetProcedure;
/*    */ 
/*    */ public class POnNewMountsGet
/*    */   extends NewMountsGetProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     AchievementManager.updateGoalTypeState(((NewMountsGetArg)this.arg).roleId, 5900, null, "POnNewMountsGet.processImp@handle MOUNTS_SPECIFC_STAR success");
/*    */     
/*    */ 
/* 14 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnNewMountsGet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
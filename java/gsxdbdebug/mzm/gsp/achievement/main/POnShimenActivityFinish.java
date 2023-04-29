/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.achievement.main.goaltype.ShiMenHandUpItemCount.Context;
/*    */ import mzm.gsp.shimen.event.ShimenActivityArg;
/*    */ import mzm.gsp.shimen.event.ShimenActivityFinishedProcedure;
/*    */ 
/*    */ public class POnShimenActivityFinish
/*    */   extends ShimenActivityFinishedProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 12 */     AchievementManager.updateGoalTypeState(((ShimenActivityArg)this.arg).getRoleid(), 2400, Integer.valueOf(((ShimenActivityArg)this.arg).getActivityId()), "POnShimenActivityFinish.processImp@handle ACTIVITY_JOIN finish");
/*    */     
/*    */ 
/*    */ 
/* 16 */     ShiMenHandUpItemCount.Context context = new ShiMenHandUpItemCount.Context(((ShimenActivityArg)this.arg).getNewcount(), ((ShimenActivityArg)this.arg).getHandUpItemInfos());
/* 17 */     AchievementManager.updateGoalTypeState(((ShimenActivityArg)this.arg).getRoleid(), 2410, context, "POnShimenActivityFinish.processImp@handle SHIMEN_HAND_UP_ITEM_COUNT finish");
/*    */     
/*    */ 
/* 20 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnShimenActivityFinish.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
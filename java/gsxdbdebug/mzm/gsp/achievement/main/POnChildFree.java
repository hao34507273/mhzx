/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.children.event.ChildFreeArg;
/*    */ import mzm.gsp.children.event.ChildFreeProcedure;
/*    */ 
/*    */ public class POnChildFree
/*    */   extends ChildFreeProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */   {
/* 11 */     AchievementManager.updateGoalTypeState(((ChildFreeArg)this.arg).roleId, 5500, null, "POnChildFree.processImp@handle CHILD_COUNT finish");
/*    */     
/*    */ 
/* 14 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnChildFree.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
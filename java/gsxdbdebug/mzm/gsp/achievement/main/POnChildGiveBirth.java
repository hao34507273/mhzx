/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.children.event.ChildGiveBirthArg;
/*    */ import mzm.gsp.children.event.ChildGiveBirthProcedure;
/*    */ 
/*    */ public class POnChildGiveBirth
/*    */   extends ChildGiveBirthProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */   {
/* 11 */     AchievementManager.updateGoalTypeState(((ChildGiveBirthArg)this.arg).belongRoleId, 5500, null, "POnChildGiveBirth.processImp@handle CHILD_COUNT finish");
/*    */     
/*    */ 
/* 14 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnChildGiveBirth.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
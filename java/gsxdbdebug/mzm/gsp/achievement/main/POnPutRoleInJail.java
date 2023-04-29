/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.prison.event.PutRoleInJailArg;
/*    */ import mzm.gsp.prison.event.PutRoleInJailProcedure;
/*    */ 
/*    */ public class POnPutRoleInJail
/*    */   extends PutRoleInJailProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */   {
/* 11 */     AchievementManager.updateGoalTypeState(((PutRoleInJailArg)this.arg).roleId, 5700, Integer.valueOf(1), "POnPutRoleInJail.processImp@handle PUT_IN_PRISON_COUNT sucess");
/*    */     
/*    */ 
/* 14 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnPutRoleInJail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
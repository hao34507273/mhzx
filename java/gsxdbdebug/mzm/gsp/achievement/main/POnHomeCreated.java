/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.homeland.event.CreateHomeArg;
/*    */ import mzm.gsp.homeland.event.CreateHomeEventProcedure;
/*    */ 
/*    */ 
/*    */ public class POnHomeCreated
/*    */   extends CreateHomeEventProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */   {
/* 13 */     if (((CreateHomeArg)this.arg).partnerRoleId > 0L)
/*    */     {
/*    */ 
/* 16 */       AchievementManager.collectLocks(Arrays.asList(new Long[] { Long.valueOf(((CreateHomeArg)this.arg).partnerRoleId), Long.valueOf(((CreateHomeArg)this.arg).ownerRoleId) }));
/*    */       
/* 18 */       AchievementManager.updateGoalTypeState(((CreateHomeArg)this.arg).partnerRoleId, 5602, Integer.valueOf(((CreateHomeArg)this.arg).homeLevel), "POnHomeCreated.processImp@handle HOME_LEVEL success");
/*    */     }
/*    */     
/*    */ 
/* 22 */     AchievementManager.updateGoalTypeState(((CreateHomeArg)this.arg).ownerRoleId, 5602, Integer.valueOf(((CreateHomeArg)this.arg).homeLevel), "POnHomeCreated.processImp@handle HOME_LEVEL success");
/*    */     
/*    */ 
/* 25 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnHomeCreated.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
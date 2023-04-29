/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.homeland.event.HomeLevelUpArg;
/*    */ import mzm.gsp.homeland.event.HomeLevelUpProcedure;
/*    */ import mzm.gsp.marriage.main.MarriageInterface;
/*    */ 
/*    */ public class POnHomeLevelUp
/*    */   extends HomeLevelUpProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */   {
/* 13 */     long partnerRoleId = MarriageInterface.getMarriedRoleid(((HomeLevelUpArg)this.arg).roleId, false);
/*    */     
/* 15 */     if (partnerRoleId > 0L)
/*    */     {
/*    */ 
/* 18 */       AchievementManager.collectLocks(Arrays.asList(new Long[] { Long.valueOf(((HomeLevelUpArg)this.arg).roleId), Long.valueOf(partnerRoleId) }));
/*    */       
/* 20 */       AchievementManager.updateGoalTypeState(partnerRoleId, 5602, Integer.valueOf(((HomeLevelUpArg)this.arg).newHomeLevel), "POnHomeLevelUp.processImp@handle HOME_LEVEL success");
/*    */     }
/*    */     
/*    */ 
/* 24 */     AchievementManager.updateGoalTypeState(((HomeLevelUpArg)this.arg).roleId, 5602, Integer.valueOf(((HomeLevelUpArg)this.arg).newHomeLevel), "POnHomeLevelUp.processImp@handle HOME_LEVEL success");
/*    */     
/*    */ 
/* 27 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnHomeLevelUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
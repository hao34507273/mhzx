/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.homeland.event.FengShuiArg;
/*    */ import mzm.gsp.homeland.event.FengShuiChangeEventProcedure;
/*    */ 
/*    */ 
/*    */ public class POnFengShuiChange
/*    */   extends FengShuiChangeEventProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */   {
/* 13 */     if (((FengShuiArg)this.arg).partnerRoleId > 0L)
/*    */     {
/*    */ 
/* 16 */       AchievementManager.collectLocks(Arrays.asList(new Long[] { Long.valueOf(((FengShuiArg)this.arg).ownerRoleId), Long.valueOf(((FengShuiArg)this.arg).partnerRoleId) }));
/*    */       
/* 18 */       AchievementManager.updateGoalTypeState(((FengShuiArg)this.arg).partnerRoleId, 5604, Integer.valueOf(((FengShuiArg)this.arg).newFengshui), "POnFengShuiChange.processImp@handle HOME_FENGSHUI_VALUE success");
/*    */     }
/*    */     
/*    */ 
/* 22 */     AchievementManager.updateGoalTypeState(((FengShuiArg)this.arg).ownerRoleId, 5604, Integer.valueOf(((FengShuiArg)this.arg).newFengshui), "POnFengShuiChange.processImp@handle HOME_FENGSHUI_VALUE success");
/*    */     
/*    */ 
/* 25 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnFengShuiChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
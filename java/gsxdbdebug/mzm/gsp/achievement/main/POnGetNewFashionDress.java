/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.fashiondress.event.GetNewFashionDressArg;
/*    */ import mzm.gsp.fashiondress.event.GetNewFashionDressProcedure;
/*    */ 
/*    */ public class POnGetNewFashionDress
/*    */   extends GetNewFashionDressProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */   {
/* 11 */     AchievementManager.updateGoalTypeState(((GetNewFashionDressArg)this.arg).roleId, 5804, null, "POnGetNewFashionDress.processImp@handle FASHION_OWN success");
/*    */     
/*    */ 
/* 14 */     AchievementManager.updateGoalTypeState(((GetNewFashionDressArg)this.arg).roleId, 5805, null, "POnGetNewFashionDress.processImp@handle FASHION_SPECIFIC_OWN success");
/*    */     
/* 16 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnGetNewFashionDress.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
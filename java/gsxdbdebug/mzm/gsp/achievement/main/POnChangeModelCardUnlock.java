/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.changemodelcard.event.ChangeModelCardUnlockArg;
/*    */ import mzm.gsp.changemodelcard.event.ChangeModelCardUnlockProcedure;
/*    */ 
/*    */ public class POnChangeModelCardUnlock
/*    */   extends ChangeModelCardUnlockProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     AchievementManager.updateGoalTypeState(((ChangeModelCardUnlockArg)this.arg).roleId, 3308, null, "POnChangeModelCardUnlock.processImp@handle CHANGE_MODEL_CARD_CLASS_LEVEL_QUALITY_NUM success");
/*    */     
/*    */ 
/*    */ 
/* 15 */     AchievementManager.updateGoalTypeState(((ChangeModelCardUnlockArg)this.arg).roleId, 3310, null, "POnChangeModelCardUnlock.processImp@handle CHANGE_MODEL_CARD_SPECIFIC_OWN success");
/*    */     
/*    */ 
/*    */ 
/* 19 */     AchievementManager.updateGoalTypeState(((ChangeModelCardUnlockArg)this.arg).roleId, 3309, null, "POnChangeModelCardUnlock.processImp@handle CHANGE_MODEL_CARD_CLASS_TYPE_NUM success");
/*    */     
/*    */ 
/* 22 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnChangeModelCardUnlock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
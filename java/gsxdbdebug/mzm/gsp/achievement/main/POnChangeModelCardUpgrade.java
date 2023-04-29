/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.changemodelcard.event.ChangeModelCardUpgradeArg;
/*    */ import mzm.gsp.changemodelcard.event.ChangeModelCardUpgradeProcedure;
/*    */ 
/*    */ public class POnChangeModelCardUpgrade
/*    */   extends ChangeModelCardUpgradeProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     AchievementManager.updateGoalTypeState(((ChangeModelCardUpgradeArg)this.arg).roleId, 3308, null, "POnChangeModelCardUnlock.processImp@handle CHANGE_MODEL_CARD_CLASS_LEVEL_QUALITY_NUM success");
/*    */     
/*    */ 
/* 14 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnChangeModelCardUpgrade.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
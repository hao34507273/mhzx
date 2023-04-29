/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.zoo.event.AnimalStageChangeArg;
/*    */ import mzm.gsp.zoo.event.AnimalStageChangeProcedure;
/*    */ 
/*    */ public class POnAnimalStageChange
/*    */   extends AnimalStageChangeProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     AchievementManager.updateGoalTypeState(((AnimalStageChangeArg)this.arg).roleid, 5601, null, "POnAnimalStageChange.processImp@handle ANIMAL_STAR finish");
/*    */     
/*    */ 
/* 14 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnAnimalStageChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.zoo.event.AnimalMateArg;
/*    */ import mzm.gsp.zoo.event.AnimalMateProcedure;
/*    */ 
/*    */ public class POnAnimalMate
/*    */   extends AnimalMateProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     AchievementManager.updateGoalTypeState(((AnimalMateArg)this.arg).roleid, 5600, Integer.valueOf(1), "POnAnimalMate.processImp@handle ANIMAL_MATE_COUNT finish");
/*    */     
/*    */ 
/* 14 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnAnimalMate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
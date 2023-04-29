/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.zoo.event.AnimalDisappearArg;
/*    */ import mzm.gsp.zoo.event.AnimalDisappearProcedure;
/*    */ 
/*    */ public class POnRemoveAnimal
/*    */   extends AnimalDisappearProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     AchievementManager.updateGoalTypeState(((AnimalDisappearArg)this.arg).roleid, 5601, null, "POnRemoveAnimal.processImp@handle ANIMAL_STAR finish");
/*    */     
/*    */ 
/* 14 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnRemoveAnimal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
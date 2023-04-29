/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.zoo.event.AnimalCreateArg;
/*    */ import mzm.gsp.zoo.event.AnimalCreateProcedure;
/*    */ 
/*    */ public class POnAddAnimal
/*    */   extends AnimalCreateProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     AchievementManager.updateGoalTypeState(((AnimalCreateArg)this.arg).roleid, 5601, null, "POnAddAnimal.processImp@handle ANIMAL_STAR finish");
/*    */     
/*    */ 
/* 14 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnAddAnimal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
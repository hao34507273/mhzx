/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.pet.event.PetCatchEventArg;
/*    */ import mzm.gsp.pet.event.PetCatchEventProcedure;
/*    */ 
/*    */ public class POnPetCatch
/*    */   extends PetCatchEventProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */   {
/* 11 */     if (((PetCatchEventArg)this.arg).isCatched)
/*    */     {
/* 13 */       AchievementManager.updateGoalTypeState(((PetCatchEventArg)this.arg).roleId, 5401, Integer.valueOf(((PetCatchEventArg)this.arg).petCfgId), "POnPetCatch.updateState@handle PET_ACCUMULATE_CATCH success");
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 18 */     AchievementManager.updateGoalTypeState(((PetCatchEventArg)this.arg).roleId, 5406, Integer.valueOf(((PetCatchEventArg)this.arg).isCatched ? 1 : 0), "POnPetCatch.updateState@handle PET_COMBO_CATCH success");
/*    */     
/*    */ 
/* 21 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnPetCatch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
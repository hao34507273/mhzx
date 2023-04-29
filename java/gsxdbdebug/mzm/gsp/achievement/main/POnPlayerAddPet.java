/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.pet.event.PetEventArg;
/*    */ import mzm.gsp.pet.event.PlayerAddPetProcedure;
/*    */ 
/*    */ public class POnPlayerAddPet
/*    */   extends PlayerAddPetProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     AchievementManager.updateGoalTypeState(((PetEventArg)this.arg).roleId, 2, Long.valueOf(((PetEventArg)this.arg).petId), "POnPlayerAddPet.processImp@handle PET_OWN success");
/*    */     
/*    */ 
/*    */ 
/* 15 */     AchievementManager.updateGoalTypeState(((PetEventArg)this.arg).roleId, 5403, Long.valueOf(((PetEventArg)this.arg).petId), "POnPlayerAddPet.processImp@handle PET_SPECIFIC_OWN success");
/*    */     
/*    */ 
/*    */ 
/* 19 */     AchievementManager.updateGoalTypeState(((PetEventArg)this.arg).roleId, 5404, Long.valueOf(((PetEventArg)this.arg).petId), "POnPlayerAddPet.processImp@handle PET_SKILL_NUM success");
/*    */     
/* 21 */     AchievementManager.updateGoalTypeState(((PetEventArg)this.arg).roleId, 5405, Long.valueOf(((PetEventArg)this.arg).petId), "POnPlayerAddPet.processImp@handle PET_TYPE_SKILL_NUM success");
/*    */     
/*    */ 
/* 24 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnPlayerAddPet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
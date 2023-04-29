/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.pet.event.PetEventArg;
/*    */ import mzm.gsp.pet.event.PlayerDeletePetProcedure;
/*    */ import mzm.gsp.pet.main.PetDeleteTLogEnum;
/*    */ 
/*    */ public class POnPlayerDeletePet
/*    */   extends PlayerDeletePetProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */   {
/* 12 */     if (((PetEventArg)this.arg).enventType == PetDeleteTLogEnum.SHOP_SELL.value)
/*    */     {
/* 14 */       AchievementManager.updateGoalTypeState(((PetEventArg)this.arg).roleId, 5400, Integer.valueOf(1), "POnPlayerDeletePet.processImp@handle handle PET_SELL_STORE success");
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 19 */     AchievementManager.updateGoalTypeState(((PetEventArg)this.arg).roleId, 5403, Long.valueOf(((PetEventArg)this.arg).petId), "POnPlayerDeletePet.processImp@handle handle PET_SPECIFIC_OWN success");
/*    */     
/*    */ 
/*    */ 
/* 23 */     AchievementManager.updateGoalTypeState(((PetEventArg)this.arg).roleId, 5404, Long.valueOf(((PetEventArg)this.arg).petId), "POnPlayerDeletePet.processImp@handle PET_SKILL_NUM success");
/*    */     
/* 25 */     AchievementManager.updateGoalTypeState(((PetEventArg)this.arg).roleId, 5405, Long.valueOf(((PetEventArg)this.arg).petId), "POnPlayerDeletePet.processImp@handle PET_TYPE_SKILL_NUM success");
/*    */     
/*    */ 
/* 28 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnPlayerDeletePet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
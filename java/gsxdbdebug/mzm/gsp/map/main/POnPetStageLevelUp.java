/*    */ package mzm.gsp.map.main;
/*    */ 
/*    */ import mzm.gsp.map.MapModelInfo;
/*    */ import mzm.gsp.map.main.message.MMH_PetAppearanceChange;
/*    */ import mzm.gsp.pet.event.PetStageLevelUpEventArg;
/*    */ import mzm.gsp.pet.main.Pet;
/*    */ import mzm.gsp.pet.main.PetInterface;
/*    */ 
/*    */ public class POnPetStageLevelUp extends mzm.gsp.pet.event.PetStageLevelUpProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     if (!PetInterface.isShowPet(((PetStageLevelUpEventArg)this.arg).roleId, ((PetStageLevelUpEventArg)this.arg).petId))
/*    */     {
/* 15 */       return false;
/*    */     }
/*    */     
/* 18 */     Pet pet = PetInterface.getShowPet(((PetStageLevelUpEventArg)this.arg).roleId, false);
/* 19 */     if ((pet == null) || (pet.getId() != ((PetStageLevelUpEventArg)this.arg).petId))
/*    */     {
/* 21 */       return false;
/*    */     }
/*    */     
/* 24 */     MapModelInfo petMapModelInfo = new MapModelInfo();
/* 25 */     pet.getMapModel(petMapModelInfo);
/* 26 */     new MMH_PetAppearanceChange(((PetStageLevelUpEventArg)this.arg).roleId, ((PetStageLevelUpEventArg)this.arg).petId, petMapModelInfo, 5).execute();
/*    */     
/*    */ 
/* 29 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\POnPetStageLevelUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
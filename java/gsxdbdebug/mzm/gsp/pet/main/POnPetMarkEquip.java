/*    */ package mzm.gsp.pet.main;
/*    */ 
/*    */ import mzm.gsp.petmark.event.PetMarkEquipArg;
/*    */ 
/*    */ public class POnPetMarkEquip extends mzm.gsp.petmark.event.PetMarkEquipProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception {
/*  8 */     xbean.PetBag xPetBag = xtable.Role2petbag.get(Long.valueOf(((PetMarkEquipArg)this.arg).roleId));
/*  9 */     if (xPetBag == null) {
/* 10 */       return false;
/*    */     }
/* 12 */     xbean.Pet xPet = (xbean.Pet)xPetBag.getPetmap().get(Long.valueOf(((PetMarkEquipArg)this.arg).petId));
/* 13 */     if (xPet == null) {
/* 14 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 18 */     PetOutFightObj pet = new PetOutFightObj(((PetMarkEquipArg)this.arg).roleId, xPet);
/* 19 */     pet.updatePetMark();
/* 20 */     xPet.setIsbinded(1);
/* 21 */     pet.syncPetInfo();
/*    */     
/* 23 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\POnPetMarkEquip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
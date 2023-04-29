/*    */ package mzm.gsp.pet.main;
/*    */ 
/*    */ import mzm.gsp.petmark.event.PetMarkUnequipArg;
/*    */ 
/*    */ public class POnPetMarkUnequip extends mzm.gsp.petmark.event.PetMarkUnequipProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception {
/*  8 */     xbean.PetBag xPetBag = xtable.Role2petbag.get(Long.valueOf(((PetMarkUnequipArg)this.arg).roleId));
/*    */     
/* 10 */     if (xPetBag != null)
/*    */     {
/* 12 */       xbean.Pet xPet = (xbean.Pet)xPetBag.getPetmap().get(Long.valueOf(((PetMarkUnequipArg)this.arg).petId));
/* 13 */       if (xPet == null)
/*    */       {
/* 15 */         xbean.PetDepot xPetDepot = xtable.Role2petdepot.get(Long.valueOf(((PetMarkUnequipArg)this.arg).roleId));
/* 16 */         if (null == xPetDepot)
/*    */         {
/* 18 */           return false;
/*    */         }
/* 20 */         xPet = (xbean.Pet)xPetDepot.getPetmap().get(Long.valueOf(((PetMarkUnequipArg)this.arg).petId));
/*    */       }
/*    */     }
/*    */     else
/*    */     {
/* 25 */       return false;
/*    */     }
/*    */     xbean.Pet xPet;
/* 28 */     if (xPet == null)
/*    */     {
/* 30 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 34 */     PetOutFightObj pet = new PetOutFightObj(((PetMarkUnequipArg)this.arg).roleId, xPet);
/* 35 */     pet.updatePetMark();
/* 36 */     pet.syncPetInfo();
/*    */     
/* 38 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\POnPetMarkUnequip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
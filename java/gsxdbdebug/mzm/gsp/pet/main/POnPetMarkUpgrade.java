/*    */ package mzm.gsp.pet.main;
/*    */ 
/*    */ import mzm.gsp.petmark.event.PetMarkUpgradeArg;
/*    */ 
/*    */ public class POnPetMarkUpgrade extends mzm.gsp.petmark.event.PetMarkUpgradeProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/*  9 */     if (((PetMarkUpgradeArg)this.arg).petId == 0L)
/*    */     {
/* 11 */       return false;
/*    */     }
/*    */     
/* 14 */     xbean.PetBag xPetBag = xtable.Role2petbag.get(Long.valueOf(((PetMarkUpgradeArg)this.arg).roleId));
/* 15 */     if (xPetBag == null)
/*    */     {
/* 17 */       return false;
/*    */     }
/* 19 */     xbean.Pet xPet = (xbean.Pet)xPetBag.getPetmap().get(Long.valueOf(((PetMarkUpgradeArg)this.arg).petId));
/* 20 */     if (xPet == null)
/*    */     {
/* 22 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 26 */     PetOutFightObj pet = new PetOutFightObj(((PetMarkUpgradeArg)this.arg).roleId, xPet);
/* 27 */     pet.updatePetMark();
/* 28 */     pet.syncPetInfo();
/*    */     
/* 30 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\POnPetMarkUpgrade.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
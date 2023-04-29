/*   */ package mzm.gsp.pet.main;
/*   */ 
/*   */ import mzm.gsp.pet.event.PetFanShengEventArg;
/*   */ 
/*   */ public class POnPetFanSheng extends mzm.gsp.pet.event.PetFanShengProcedure
/*   */ {
/*   */   protected boolean processImp() throws Exception {
/* 8 */     PetFightInterface.clearPetFightDataForCertainPet(((PetFanShengEventArg)this.arg).roleId, ((PetFanShengEventArg)this.arg).oldPetId);
/* 9 */     return true;
/*   */   }
/*   */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\POnPetFanSheng.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
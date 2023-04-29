/*    */ package mzm.gsp.pet.main;
/*    */ 
/*    */ import mzm.gsp.pet.event.PetEventArg;
/*    */ 
/*    */ public class POnPetMoveToDepot extends mzm.gsp.pet.event.PetMoveToDepotProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception {
/*  8 */     long roleId = ((PetEventArg)this.arg).roleId;
/*  9 */     long petId = ((PetEventArg)this.arg).petId;
/*    */     
/*    */ 
/* 12 */     PetFightInterface.clearPetFightDataForCertainPet(roleId, petId);
/*    */     
/* 14 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\POnPetMoveToDepot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
/*    */ package mzm.gsp.map.main;
/*    */ 
/*    */ import mzm.gsp.map.main.message.MMH_PetAppearanceChange;
/*    */ import mzm.gsp.pet.event.PetEventArg;
/*    */ import mzm.gsp.pet.main.Pet;
/*    */ import mzm.gsp.pet.main.PetInterface;
/*    */ 
/*    */ public class POnPlayerDeletePet extends mzm.gsp.pet.event.PlayerDeletePetProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 12 */     if (!PetInterface.isShowPet(((PetEventArg)this.arg).roleId, ((PetEventArg)this.arg).petId))
/*    */     {
/* 14 */       return false;
/*    */     }
/*    */     
/* 17 */     Pet pet = PetInterface.getShowPet(((PetEventArg)this.arg).roleId, false);
/* 18 */     if ((pet == null) || (pet.getId() != ((PetEventArg)this.arg).petId))
/*    */     {
/* 20 */       return false;
/*    */     }
/*    */     
/* 23 */     new MMH_PetAppearanceChange(((PetEventArg)this.arg).roleId, ((PetEventArg)this.arg).petId, null, 3).execute();
/*    */     
/* 25 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\POnPlayerDeletePet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
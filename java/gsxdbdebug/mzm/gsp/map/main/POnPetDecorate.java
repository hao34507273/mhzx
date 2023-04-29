/*    */ package mzm.gsp.map.main;
/*    */ 
/*    */ import mzm.gsp.map.MapModelInfo;
/*    */ import mzm.gsp.map.main.message.MMH_PetAppearanceChange;
/*    */ import mzm.gsp.pet.event.PetEventArg;
/*    */ import mzm.gsp.pet.main.Pet;
/*    */ import mzm.gsp.pet.main.PetInterface;
/*    */ 
/*    */ public class POnPetDecorate extends mzm.gsp.pet.event.PetDecorateProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     if (!PetInterface.isShowPet(((PetEventArg)this.arg).roleId, ((PetEventArg)this.arg).petId))
/*    */     {
/* 15 */       return false;
/*    */     }
/*    */     
/* 18 */     Pet pet = PetInterface.getShowPet(((PetEventArg)this.arg).roleId, false);
/* 19 */     if ((pet == null) || (pet.getId() != ((PetEventArg)this.arg).petId))
/*    */     {
/* 21 */       return false;
/*    */     }
/*    */     
/* 24 */     MapModelInfo petModelInfo = new MapModelInfo();
/* 25 */     pet.getMapModel(petModelInfo);
/* 26 */     new MMH_PetAppearanceChange(((PetEventArg)this.arg).roleId, ((PetEventArg)this.arg).petId, petModelInfo, 0).execute();
/*    */     
/* 28 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\POnPetDecorate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
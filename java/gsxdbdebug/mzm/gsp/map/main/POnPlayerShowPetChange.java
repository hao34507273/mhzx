/*    */ package mzm.gsp.map.main;
/*    */ 
/*    */ import mzm.gsp.map.MapModelInfo;
/*    */ import mzm.gsp.map.main.message.MMH_PetAppearanceChange;
/*    */ import mzm.gsp.pet.event.PetEventArg;
/*    */ import mzm.gsp.pet.event.PlayerShowPetChangeProcedure;
/*    */ import mzm.gsp.pet.main.Pet;
/*    */ 
/*    */ public class POnPlayerShowPetChange extends PlayerShowPetChangeProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     Pet pet = mzm.gsp.pet.main.PetInterface.getShowPet(((PetEventArg)this.arg).roleId, false);
/* 14 */     if (pet == null)
/*    */     {
/* 16 */       new MMH_PetAppearanceChange(((PetEventArg)this.arg).roleId, ((PetEventArg)this.arg).petId, null, 2).execute();
/*    */     }
/*    */     else
/*    */     {
/* 20 */       MapModelInfo mapModelInfo = new MapModelInfo();
/* 21 */       pet.getMapModel(mapModelInfo);
/* 22 */       new MMH_PetAppearanceChange(((PetEventArg)this.arg).roleId, ((PetEventArg)this.arg).petId, mapModelInfo, 1).execute();
/*    */     }
/*    */     
/* 25 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\POnPlayerShowPetChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
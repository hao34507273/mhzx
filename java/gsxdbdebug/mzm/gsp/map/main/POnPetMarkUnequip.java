/*   */ package mzm.gsp.map.main;
/*   */ 
/*   */ import mzm.gsp.petmark.event.PetMarkUnequipArg;
/*   */ 
/*   */ public class POnPetMarkUnequip extends mzm.gsp.petmark.event.PetMarkUnequipProcedure
/*   */ {
/*   */   protected boolean processImp() throws Exception {
/* 8 */     return MapManager.onPetMarkChange(((PetMarkUnequipArg)this.arg).roleId, ((PetMarkUnequipArg)this.arg).petId);
/*   */   }
/*   */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\POnPetMarkUnequip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
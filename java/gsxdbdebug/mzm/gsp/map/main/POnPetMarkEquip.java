/*   */ package mzm.gsp.map.main;
/*   */ 
/*   */ import mzm.gsp.petmark.event.PetMarkEquipArg;
/*   */ 
/*   */ public class POnPetMarkEquip extends mzm.gsp.petmark.event.PetMarkEquipProcedure
/*   */ {
/*   */   protected boolean processImp() throws Exception {
/* 8 */     return MapManager.onPetMarkChange(((PetMarkEquipArg)this.arg).roleId, ((PetMarkEquipArg)this.arg).petId);
/*   */   }
/*   */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\POnPetMarkEquip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
/*    */ package mzm.gsp.pet.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.Pet;
/*    */ import xbean.PetBag;
/*    */ import xtable.Role2petbag;
/*    */ 
/*    */ public class PSetAutoAddFlagReq extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final long petId;
/*    */   private final boolean openFlag;
/*    */   
/*    */   public PSetAutoAddFlagReq(long roleId, long petId, boolean openFlag)
/*    */   {
/* 16 */     this.roleId = roleId;
/* 17 */     this.petId = petId;
/* 18 */     this.openFlag = openFlag;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 24 */     if (!PetManager.isPetSwitchOpenForRole(this.roleId)) {
/* 25 */       return false;
/*    */     }
/*    */     
/* 28 */     PetBag xPetBag = Role2petbag.get(Long.valueOf(this.roleId));
/* 29 */     if (xPetBag == null) {
/* 30 */       return false;
/*    */     }
/* 32 */     Pet xPet = (Pet)xPetBag.getPetmap().get(Long.valueOf(this.petId));
/* 33 */     if (xPet == null) {
/* 34 */       return false;
/*    */     }
/* 36 */     xPet.setIsautospecialpoint(this.openFlag);
/*    */     
/* 38 */     PetOutFightObj outFightObj = new PetOutFightObj(this.roleId, xPet);
/* 39 */     int oldMp = outFightObj.getFinalMaxMP();
/* 40 */     int oldHp = outFightObj.getFinalMaxHP();
/* 41 */     outFightObj.autoSpecialPoint();
/* 42 */     int changeMp = outFightObj.getFinalMaxMP() - oldMp;
/* 43 */     int changeHp = outFightObj.getFinalMaxHP() - oldHp;
/* 44 */     outFightObj.setHP(outFightObj.getHP() + changeHp);
/* 45 */     outFightObj.setMP(outFightObj.getMP() + changeMp);
/* 46 */     outFightObj.updateOutFightProperty();
/* 47 */     outFightObj.syncPetInfo();
/* 48 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\PSetAutoAddFlagReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
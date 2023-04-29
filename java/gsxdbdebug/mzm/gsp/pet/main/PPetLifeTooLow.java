/*    */ package mzm.gsp.pet.main;
/*    */ 
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.pet.SPetNormalResult;
/*    */ import mzm.gsp.pet.SSyncPetStateChange;
/*    */ import mzm.gsp.pet.confbean.PetConstants;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.Pet;
/*    */ import xbean.PetBag;
/*    */ import xtable.Role2petbag;
/*    */ 
/*    */ public class PPetLifeTooLow extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PPetLifeTooLow(long roleId)
/*    */   {
/* 18 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 24 */     PetBag xPetBag = Role2petbag.get(Long.valueOf(this.roleId));
/* 25 */     if (xPetBag == null) {
/* 26 */       return false;
/*    */     }
/* 28 */     long petId = xPetBag.getFightpet();
/* 29 */     if (petId <= 0L) {
/* 30 */       return false;
/*    */     }
/* 32 */     Pet xPet = (Pet)xPetBag.getPetmap().get(Long.valueOf(petId));
/* 33 */     if (xPet == null) {
/* 34 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 38 */     if (xPet.getLife() == -1) {
/* 39 */       return false;
/*    */     }
/*    */     
/* 42 */     if (xPet.getLife() >= PetConstants.getInstance().PET_JOIN_FIGHT_MIN_LIFE) {
/* 43 */       return false;
/*    */     }
/* 45 */     xPetBag.setFightpet(-1L);
/* 46 */     SPetNormalResult normalResult = new SPetNormalResult();
/* 47 */     normalResult.result = 2;
/* 48 */     OnlineManager.getInstance().send(this.roleId, normalResult);
/* 49 */     SSyncPetStateChange petStateChange = new SSyncPetStateChange();
/* 50 */     petStateChange.petid = petId;
/* 51 */     petStateChange.state = 3;
/* 52 */     OnlineManager.getInstance().send(this.roleId, petStateChange);
/* 53 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\PPetLifeTooLow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
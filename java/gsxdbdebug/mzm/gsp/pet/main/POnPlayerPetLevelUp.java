/*    */ package mzm.gsp.pet.main;
/*    */ 
/*    */ import mzm.gsp.pet.event.PetEventArg;
/*    */ 
/*    */ public class POnPlayerPetLevelUp extends mzm.gsp.pet.event.PlayerPetLevelUpProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/*  9 */     PetOutFightObj obj = PetInterface.getPetOutFightObjById(((PetEventArg)this.arg).roleId, ((PetEventArg)this.arg).petId);
/* 10 */     obj.setMP(obj.getFinalMaxMP());
/* 11 */     obj.setHP(obj.getFinalMaxHP());
/* 12 */     mzm.gsp.pet.SSyncPetInfoChange change = new mzm.gsp.pet.SSyncPetInfoChange();
/* 13 */     obj.fillPetInfo(change.petinfo);
/* 14 */     mzm.gsp.online.main.OnlineManager.getInstance().send(((PetEventArg)this.arg).roleId, change);
/* 15 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\POnPlayerPetLevelUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
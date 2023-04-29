/*   */ package mzm.gsp.fight.main;
/*   */ 
/*   */ import mzm.gsp.pet.event.PetEventArg;
/*   */ 
/*   */ public class POnPetJoinFight extends mzm.gsp.pet.event.PetJoinFightProcedure {
/*   */   protected boolean processImp() throws Exception {
/* 7 */     FightManager.onPetJoinFight(((PetEventArg)this.arg).roleId, ((PetEventArg)this.arg).petId);
/* 8 */     return true;
/*   */   }
/*   */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\POnPetJoinFight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
/*    */ package mzm.gsp.fight.main;
/*    */ 
/*    */ import mzm.gsp.pet.event.PetEventArg;
/*    */ 
/*    */ public class POnPlayerDeletePet extends mzm.gsp.pet.event.PlayerDeletePetProcedure {
/*    */   protected boolean processImp() throws Exception {
/*  7 */     Fight fight = FightManager.getFightByRoleid(((PetEventArg)this.arg).roleId);
/*  8 */     if (fight != null) {
/*  9 */       lock(xtable.Basic.getTable(), fight.getLockRoles());
/*    */     }
/* 11 */     xbean.FightCache fightCache = xtable.Rolefightcache.get(Long.valueOf(((PetEventArg)this.arg).roleId));
/* 12 */     if (fightCache == null) {
/* 13 */       return false;
/*    */     }
/* 15 */     if (fightCache.getPet_default_skills().containsKey(Long.valueOf(((PetEventArg)this.arg).petId))) {
/* 16 */       fightCache.getPet_default_skills().remove(Long.valueOf(((PetEventArg)this.arg).petId));
/* 17 */       FightInterface.syncAutoState(((PetEventArg)this.arg).roleId);
/*    */     }
/*    */     
/* 20 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\POnPlayerDeletePet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
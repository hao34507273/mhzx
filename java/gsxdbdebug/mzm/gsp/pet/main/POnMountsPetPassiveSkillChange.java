/*    */ package mzm.gsp.pet.main;
/*    */ 
/*    */ import mzm.gsp.mounts.event.MountsPetPassiveSkillChangeArg;
/*    */ import mzm.gsp.mounts.event.MountsPetPassiveSkillChangeProcedure;
/*    */ 
/*    */ 
/*    */ public class POnMountsPetPassiveSkillChange
/*    */   extends MountsPetPassiveSkillChangeProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 13 */     long roleId = ((MountsPetPassiveSkillChangeArg)this.arg).getRoleId();
/* 14 */     long petId = ((MountsPetPassiveSkillChangeArg)this.arg).getPetId();
/*    */     
/* 16 */     PetOutFightObj petOutFightObj = PetInterface.getPetOutFightObjById(roleId, petId);
/* 17 */     if (petOutFightObj == null) {
/* 18 */       PetManager.logDebug("POnMountsPetPassiveSkillChange.processImp@petid is null|roleid=%d|petid=%d", new Object[] { Long.valueOf(roleId), Long.valueOf(petId) });
/* 19 */       return false;
/*    */     }
/* 21 */     petOutFightObj.updatePassiveSkill();
/*    */     
/* 23 */     petOutFightObj.syncPetInfo();
/* 24 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\POnMountsPetPassiveSkillChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
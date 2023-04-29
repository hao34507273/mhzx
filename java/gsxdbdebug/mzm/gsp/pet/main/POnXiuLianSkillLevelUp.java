/*    */ package mzm.gsp.pet.main;
/*    */ 
/*    */ import mzm.gsp.xiulian.event.XiuLianSkillArg;
/*    */ 
/*    */ public class POnXiuLianSkillLevelUp extends mzm.gsp.xiulian.event.XiuLianSkillLevelUpProcedure {
/*    */   protected boolean processImp() throws Exception {
/*  7 */     xbean.PetBag xPetBag = xtable.Role2petbag.get(Long.valueOf(((XiuLianSkillArg)this.arg).roleId));
/*  8 */     for (xbean.Pet xPet : xPetBag.getPetmap().values()) {
/*  9 */       PetOutFightObj petOutFightObj = new PetOutFightObj(((XiuLianSkillArg)this.arg).roleId, xPet);
/* 10 */       petOutFightObj.updatePassiveSkill();
/* 11 */       petOutFightObj.syncPetInfo();
/*    */     }
/* 13 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\POnXiuLianSkillLevelUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
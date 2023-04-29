/*    */ package mzm.gsp.pet.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.pet.SPetFightSetSkillFail;
/*    */ import mzm.gsp.pet.SPetFightSetSkillSuccess;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.Pet;
/*    */ import xbean.RolePetFightSkill;
/*    */ 
/*    */ public class PPetFightSetSkill extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final long petId;
/*    */   private final int skillId;
/*    */   
/*    */   public PPetFightSetSkill(long roleId, long petId, int skillId)
/*    */   {
/* 22 */     this.roleId = roleId;
/* 23 */     this.petId = petId;
/* 24 */     this.skillId = skillId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 30 */     if (!PetFightManager.isEnabled())
/*    */     {
/* 32 */       return false;
/*    */     }
/* 34 */     if (!PetFightManager.isFightSkillEnabled())
/*    */     {
/* 36 */       return false;
/*    */     }
/* 38 */     if (!PetFightManager.isRoleLevelEnough(this.roleId))
/*    */     {
/* 40 */       return false;
/*    */     }
/* 42 */     Pet xPet = PetInterface.getXPetById(this.roleId, this.petId, true);
/* 43 */     if (xPet == null)
/*    */     {
/* 45 */       onFail(1);
/* 46 */       PetFightManager.logError("PPetFightSetSkill.processImp()@pet not exists|roleid=%d|petid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.petId) });
/* 47 */       return false;
/*    */     }
/* 49 */     if (xPet.getIsbinded() == 0)
/*    */     {
/* 51 */       onFail(2);
/* 52 */       PetFightManager.logError("PPetFightSetSkill.processImp()@pet not bound|roleid=%d|petid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.petId) });
/* 53 */       return false;
/*    */     }
/*    */     
/* 56 */     RolePetFightSkill xRolePetFightSkill = PetFightManager.getOrCreateRolePetFightSkill(this.roleId);
/* 57 */     if ((this.skillId != 0) && (!xRolePetFightSkill.getSkills().contains(Integer.valueOf(this.skillId))))
/*    */     {
/* 59 */       onFail(3);
/* 60 */       PetFightManager.logError("PPetFightSetSkill.processImp()@skill not available|roleid=%d|petid=%d", new Object[0]);
/* 61 */       return false;
/*    */     }
/* 63 */     Iterator<Map.Entry<Long, Integer>> iterator = xRolePetFightSkill.getPet2skill().entrySet().iterator();
/* 64 */     while (iterator.hasNext())
/*    */     {
/* 66 */       Map.Entry<Long, Integer> entry = (Map.Entry)iterator.next();
/* 67 */       if (((Integer)entry.getValue()).intValue() == this.skillId)
/*    */       {
/* 69 */         iterator.remove();
/* 70 */         break;
/*    */       }
/*    */     }
/* 73 */     if (this.skillId != 0)
/*    */     {
/* 75 */       xRolePetFightSkill.getPet2skill().put(Long.valueOf(this.petId), Integer.valueOf(this.skillId));
/*    */     }
/* 77 */     onSuccess();
/* 78 */     PetFightManager.logInfo("PPetFightSetSkill.processImp()@success|roleid=%d|petid=%d|skillid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.petId), Integer.valueOf(this.skillId) });
/* 79 */     return true;
/*    */   }
/*    */   
/*    */   private void onSuccess()
/*    */   {
/* 84 */     SPetFightSetSkillSuccess success = new SPetFightSetSkillSuccess();
/* 85 */     success.pet_id = this.petId;
/* 86 */     success.skill_id = this.skillId;
/* 87 */     OnlineManager.getInstance().send(this.roleId, success);
/*    */   }
/*    */   
/*    */   private void onFail(int reason)
/*    */   {
/* 92 */     SPetFightSetSkillFail fail = new SPetFightSetSkillFail();
/* 93 */     fail.reason = reason;
/* 94 */     fail.pet_id = this.petId;
/* 95 */     fail.skill_id = this.skillId;
/* 96 */     OnlineManager.getInstance().sendAtOnce(this.roleId, fail);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\PPetFightSetSkill.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
/*    */ package mzm.gsp.pet.main;
/*    */ 
/*    */ import java.util.Set;
/*    */ import mzm.gsp.mall.main.JifenOperateResult;
/*    */ import mzm.gsp.mall.main.MallInterface;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.pet.SPetFightUnlockSkillFail;
/*    */ import mzm.gsp.pet.SPetFightUnlockSkillSuccess;
/*    */ import mzm.gsp.pet.confbean.SPetFightSkillCfg;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.RolePetFightSkill;
/*    */ 
/*    */ 
/*    */ public class PPetFightUnlockSkill
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int skillId;
/*    */   
/*    */   public PPetFightUnlockSkill(long roleId, int skillId)
/*    */   {
/* 25 */     this.roleId = roleId;
/* 26 */     this.skillId = skillId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 32 */     if (!PetFightManager.isEnabled())
/*    */     {
/* 34 */       return false;
/*    */     }
/* 36 */     if (!PetFightManager.isFightSkillEnabled())
/*    */     {
/* 38 */       return false;
/*    */     }
/* 40 */     if (!PetFightManager.isRoleLevelEnough(this.roleId))
/*    */     {
/* 42 */       return false;
/*    */     }
/* 44 */     SPetFightSkillCfg skillCfg = SPetFightSkillCfg.get(this.skillId);
/* 45 */     if (skillCfg == null)
/*    */     {
/* 47 */       return false;
/*    */     }
/* 49 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 2092, true))
/*    */     {
/* 51 */       return false;
/*    */     }
/*    */     
/* 54 */     RolePetFightSkill xRolePetFightSkill = PetFightManager.getOrCreateRolePetFightSkill(this.roleId);
/* 55 */     if (xRolePetFightSkill.getSkills().contains(Integer.valueOf(this.skillId)))
/*    */     {
/* 57 */       return false;
/*    */     }
/* 59 */     long currentPetFightScore = MallInterface.getJifen(this.roleId, 14);
/* 60 */     if (currentPetFightScore < skillCfg.unlockScore)
/*    */     {
/* 62 */       onFail(1);
/* 63 */       PetFightManager.logError("PPetFightUnlockSkill.processImp()@insufficient score|roleid=%d|current_score=%d|unlock_score=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(currentPetFightScore), Integer.valueOf(skillCfg.unlockScore) });
/*    */       
/*    */ 
/* 66 */       return false;
/*    */     }
/* 68 */     TLogArg tLogArg = new TLogArg(LogReason.PET_FIGHT_UNLOCK_SKILL);
/* 69 */     if (!MallInterface.cutJifen(this.roleId, skillCfg.unlockScore, 14, tLogArg).isSuccess())
/*    */     {
/* 71 */       onFail(1);
/* 72 */       PetFightManager.logError("PPetFightUnlockSkill.processImp()@insufficient score|roleid=%d|current_score=%d|unlock_score=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(currentPetFightScore), Integer.valueOf(skillCfg.unlockScore) });
/*    */       
/*    */ 
/* 75 */       return false;
/*    */     }
/* 77 */     xRolePetFightSkill.getSkills().add(Integer.valueOf(this.skillId));
/* 78 */     onSuccess();
/* 79 */     PetFightManager.logInfo("PPetFightUnlockSkill.processImp()@success|roleid=%d|skillid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.skillId) });
/* 80 */     return true;
/*    */   }
/*    */   
/*    */   private void onSuccess()
/*    */   {
/* 85 */     SPetFightUnlockSkillSuccess success = new SPetFightUnlockSkillSuccess();
/* 86 */     success.skill_id = this.skillId;
/* 87 */     OnlineManager.getInstance().send(this.roleId, success);
/* 88 */     PetFightManager.tlogUnlockSkill(this.roleId, this.skillId);
/*    */   }
/*    */   
/*    */   private void onFail(int reason)
/*    */   {
/* 93 */     SPetFightUnlockSkillFail fail = new SPetFightUnlockSkillFail();
/* 94 */     fail.reason = reason;
/* 95 */     fail.skill_id = this.skillId;
/* 96 */     OnlineManager.getInstance().sendAtOnce(this.roleId, fail);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\PPetFightUnlockSkill.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
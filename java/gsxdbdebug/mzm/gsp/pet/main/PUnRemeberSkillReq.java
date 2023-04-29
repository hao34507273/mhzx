/*    */ package mzm.gsp.pet.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.pet.SRUnemeberSkillBookRes;
/*    */ import mzm.gsp.pet.confbean.PetConstants;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogManager;
/*    */ import xbean.Pet;
/*    */ import xbean.PetBag;
/*    */ import xtable.Role2petbag;
/*    */ 
/*    */ public class PUnRemeberSkillReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final long petId;
/*    */   final int skillid;
/*    */   
/*    */   public PUnRemeberSkillReq(long roleId, long petId, int skillid)
/*    */   {
/* 23 */     this.roleId = roleId;
/* 24 */     this.petId = petId;
/* 25 */     this.skillid = skillid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 30 */     if (!PetManager.isPetSwitchOpenForRole(this.roleId)) {
/* 31 */       return false;
/*    */     }
/* 33 */     PetBag xPetBag = Role2petbag.get(Long.valueOf(this.roleId));
/* 34 */     Pet xPet = (Pet)xPetBag.getPetmap().get(Long.valueOf(this.petId));
/* 35 */     if ((xPet == null) || ((xPet.getRememberskillid() == -1) && (!RememberSkillManager.isRememberSkill(this.petId, this.skillid)))) {
/* 36 */       return false;
/*    */     }
/* 38 */     if (!RoleInterface.cutSilver(this.roleId, PetConstants.getInstance().PET_UNREMEMBER_SKILL_COST_SILVER, new mzm.gsp.tlog.TLogArg(LogReason.PET_SKILL_JIECHU_MINGJI_REM))) {
/* 39 */       PetManager.logDebug("PUnRemeberSkillReq.processImp@cutSilver error|roleid=%d|cutSilver=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(PetConstants.getInstance().PET_UNREMEMBER_SKILL_COST_SILVER) });
/* 40 */       return false;
/*    */     }
/* 42 */     if (this.skillid == xPet.getRememberskillid()) {
/* 43 */       xPet.setRememberskillid(-1);
/*    */     } else {
/* 45 */       RememberSkillManager.remeoveSkill(this.petId, this.skillid);
/*    */     }
/* 47 */     SRUnemeberSkillBookRes sRUnemeberSkillBookRes = new SRUnemeberSkillBookRes();
/* 48 */     sRUnemeberSkillBookRes.petid = this.petId;
/* 49 */     sRUnemeberSkillBookRes.skillid = this.skillid;
/* 50 */     OnlineManager.getInstance().send(this.roleId, sRUnemeberSkillBookRes);
/* 51 */     PetManager.logInfo("PUnRemeberSkillReq.processImp@pet skill unremeberskill success！|" + this.roleId + "|" + this.petId + "|" + xPet.getTemplateid() + "|" + xPet.getLevel() + "|" + this.skillid, new Object[0]);
/* 52 */     TLogManager.getInstance().addLog(this.roleId, "PetUnRemeberSkill", PetManager.createTLog(new Object[] { GameServerInfoManager.getHostIP(), RoleInterface.getUserId(this.roleId), Long.valueOf(this.roleId), Long.valueOf(this.petId), Integer.valueOf(xPet.getTemplateid()), Integer.valueOf(this.skillid) }));
/* 53 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\PUnRemeberSkillReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
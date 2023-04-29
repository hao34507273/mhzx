/*    */ package mzm.gsp.pet.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.pet.SPetFightSetTeamFormationFail;
/*    */ import mzm.gsp.pet.SPetFightSetTeamFormationSuccess;
/*    */ import mzm.gsp.pet.confbean.SPetFightConsts;
/*    */ import xbean.PetFightFormationInfo;
/*    */ import xbean.PetFightTeamInfo;
/*    */ import xbean.RolePetFightFormation;
/*    */ 
/*    */ public class PPetFightSetTeamFormation extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int teamNo;
/*    */   private final int formationId;
/*    */   
/*    */   public PPetFightSetTeamFormation(long roleId, int teamNo, int formationId)
/*    */   {
/* 20 */     this.roleId = roleId;
/* 21 */     this.teamNo = teamNo;
/* 22 */     this.formationId = formationId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 28 */     if (!PetFightManager.isEnabled())
/*    */     {
/* 30 */       return false;
/*    */     }
/* 32 */     if (!PetFightManager.isRoleLevelEnough(this.roleId))
/*    */     {
/* 34 */       return false;
/*    */     }
/* 36 */     if (!PetFightManager.isTeamNumberValid(this.teamNo))
/*    */     {
/* 38 */       return false;
/*    */     }
/*    */     
/* 41 */     if (this.formationId != SPetFightConsts.getInstance().DEFAULT_FORMATION_ID)
/*    */     {
/* 43 */       RolePetFightFormation xRolePetFightFormation = PetFightManager.getRolePetFightFormation(this.roleId, true);
/* 44 */       if (xRolePetFightFormation == null)
/*    */       {
/* 46 */         onFail(1);
/* 47 */         PetFightManager.logError("PPetFightSetTeamFormation.processImp()@formation not available|roleid=%d|formationid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.formationId) });
/*    */         
/*    */ 
/* 50 */         return false;
/*    */       }
/* 52 */       PetFightFormationInfo xPetFightFormationInfo = (PetFightFormationInfo)xRolePetFightFormation.getFormation_info().get(Integer.valueOf(this.formationId));
/*    */       
/* 54 */       if (xPetFightFormationInfo == null)
/*    */       {
/* 56 */         onFail(1);
/* 57 */         PetFightManager.logError("PPetFightSetTeamFormation.processImp()@formation not available|roleid=%d|formationid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.formationId) });
/*    */         
/*    */ 
/* 60 */         return false;
/*    */       }
/* 62 */       if (xPetFightFormationInfo.getLevel() < 1)
/*    */       {
/* 64 */         onFail(1);
/* 65 */         PetFightManager.logError("PPetFightSetTeamFormation.processImp()@formation not available|roleid=%d|formationid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.formationId) });
/*    */         
/*    */ 
/* 68 */         return false;
/*    */       }
/*    */     }
/*    */     
/* 72 */     xbean.RolePetFightTeam xRolePetFightTeam = PetFightManager.getOrCreateRolePetFightTeam(this.roleId);
/* 73 */     PetFightTeamInfo xPetFightTeamInfo = PetFightManager.getOrCreatePetFightTeamInfo(xRolePetFightTeam, this.teamNo);
/* 74 */     xPetFightTeamInfo.setFormation_id(this.formationId);
/*    */     
/* 76 */     onSuccess();
/* 77 */     PetFightManager.logInfo("PPetFightSetTeamFormation.processImp()@success|roleid=%d|team=%d|formationid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.teamNo), Integer.valueOf(this.formationId) });
/*    */     
/* 79 */     return true;
/*    */   }
/*    */   
/*    */   private void onSuccess()
/*    */   {
/* 84 */     SPetFightSetTeamFormationSuccess success = new SPetFightSetTeamFormationSuccess();
/* 85 */     success.team = this.teamNo;
/* 86 */     success.formation_id = this.formationId;
/* 87 */     OnlineManager.getInstance().send(this.roleId, success);
/*    */   }
/*    */   
/*    */   private void onFail(int reason)
/*    */   {
/* 92 */     SPetFightSetTeamFormationFail fail = new SPetFightSetTeamFormationFail();
/* 93 */     fail.reason = reason;
/* 94 */     fail.team = this.teamNo;
/* 95 */     fail.formation_id = this.formationId;
/* 96 */     OnlineManager.getInstance().sendAtOnce(this.roleId, fail);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\PPetFightSetTeamFormation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
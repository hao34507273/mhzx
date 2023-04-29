/*    */ package mzm.gsp.pet.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.event.TriggerEventsManger;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.pet.SPetFightSetDefenseTeamFail;
/*    */ import mzm.gsp.pet.SPetFightSetDefenseTeamSuccess;
/*    */ import mzm.gsp.pet.event.PetFightDefenseTeamChanged;
/*    */ import mzm.gsp.pet.event.PetFightDefenseTeamChangedArg;
/*    */ import mzm.gsp.role.main.RoleOneByOneManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.PetFightTeamInfo;
/*    */ import xbean.RolePetFightTeam;
/*    */ 
/*    */ public class PPetFightSetDefenseTeam extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int teamNo;
/*    */   
/*    */   public PPetFightSetDefenseTeam(long roleId, int teamNo)
/*    */   {
/* 22 */     this.roleId = roleId;
/* 23 */     this.teamNo = teamNo;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 29 */     if (!PetFightManager.isEnabled())
/*    */     {
/* 31 */       return false;
/*    */     }
/* 33 */     if (!PetFightManager.isRoleLevelEnough(this.roleId))
/*    */     {
/* 35 */       return false;
/*    */     }
/* 37 */     if (!PetFightManager.isTeamNumberValid(this.teamNo))
/*    */     {
/* 39 */       return false;
/*    */     }
/*    */     
/* 42 */     RolePetFightTeam xRolePetFightTeam = PetFightManager.getRolePetFightTeam(this.roleId, true);
/* 43 */     if (xRolePetFightTeam == null)
/*    */     {
/* 45 */       onFail(1);
/* 46 */       PetFightManager.logError("PPetFightSetDefenseTeam.processImp()@set empty team as defense team|roleid=%d|team=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.teamNo) });
/*    */       
/* 48 */       return false;
/*    */     }
/* 50 */     PetFightTeamInfo xPetFightTeamInfo = (PetFightTeamInfo)xRolePetFightTeam.getTeam_info().get(Integer.valueOf(this.teamNo));
/* 51 */     if ((xPetFightTeamInfo == null) || (xPetFightTeamInfo.getPosition2pet().size() == 0))
/*    */     {
/* 53 */       onFail(1);
/* 54 */       PetFightManager.logError("PPetFightSetDefenseTeam.processImp()@set empty team as defense team|roleid=%d|team=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.teamNo) });
/*    */       
/* 56 */       return false;
/*    */     }
/*    */     
/* 59 */     xRolePetFightTeam.setDefense_team(this.teamNo);
/* 60 */     onSuccess();
/* 61 */     PetFightManager.logInfo("PPetFightSetDefenseTeam.processImp()@success|roleid=%d|team=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.teamNo) });
/* 62 */     return true;
/*    */   }
/*    */   
/*    */   private void onSuccess()
/*    */   {
/* 67 */     SPetFightSetDefenseTeamSuccess success = new SPetFightSetDefenseTeamSuccess();
/* 68 */     success.team = this.teamNo;
/* 69 */     OnlineManager.getInstance().send(this.roleId, success);
/*    */     
/* 71 */     TriggerEventsManger.getInstance().triggerEvent(new PetFightDefenseTeamChanged(), new PetFightDefenseTeamChangedArg(this.roleId, this.teamNo), RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.roleId)));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   private void onFail(int reason)
/*    */   {
/* 78 */     SPetFightSetDefenseTeamFail fail = new SPetFightSetDefenseTeamFail();
/* 79 */     fail.reason = reason;
/* 80 */     fail.team = this.teamNo;
/* 81 */     OnlineManager.getInstance().sendAtOnce(this.roleId, fail);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\PPetFightSetDefenseTeam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
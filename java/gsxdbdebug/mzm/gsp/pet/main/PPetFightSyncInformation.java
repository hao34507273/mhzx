/*    */ package mzm.gsp.pet.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.HashSet;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.pet.PetFightInfo;
/*    */ import mzm.gsp.pet.PetFightSkillInfo;
/*    */ import mzm.gsp.pet.SSyncPetFightInformation;
/*    */ import mzm.gsp.pet.confbean.SPetFightConsts;
/*    */ import xbean.RolePetFightFormation;
/*    */ import xbean.RolePetFightSkill;
/*    */ import xbean.RolePetFightTeam;
/*    */ 
/*    */ class PPetFightSyncInformation extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   PPetFightSyncInformation(long roleId)
/*    */   {
/* 22 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 28 */     if (!PetFightManager.isRoleLevelEnough(this.roleId))
/*    */     {
/* 30 */       return false;
/*    */     }
/*    */     
/* 33 */     SSyncPetFightInformation syncPetFightInformation = new SSyncPetFightInformation();
/* 34 */     PetFightInfo info = syncPetFightInformation.info;
/*    */     
/*    */ 
/* 37 */     RolePetFightTeam xRolePetFightTeam = PetFightManager.getRolePetFightTeam(this.roleId, true);
/* 38 */     if (xRolePetFightTeam == null)
/*    */     {
/* 40 */       info.defense_team = -1;
/*    */     }
/*    */     else
/*    */     {
/* 44 */       info.defense_team = xRolePetFightTeam.getDefense_team();
/* 45 */       for (Map.Entry<Integer, xbean.PetFightTeamInfo> entry : xRolePetFightTeam.getTeam_info().entrySet())
/*    */       {
/* 47 */         int teamNo = ((Integer)entry.getKey()).intValue();
/* 48 */         xbean.PetFightTeamInfo xPetFightTeamInfo = (xbean.PetFightTeamInfo)entry.getValue();
/* 49 */         mzm.gsp.pet.PetFightTeamInfo petFightTeamInfo = new mzm.gsp.pet.PetFightTeamInfo();
/* 50 */         petFightTeamInfo.formation_id = xPetFightTeamInfo.getFormation_id();
/* 51 */         petFightTeamInfo.position2pet.putAll(xPetFightTeamInfo.getPosition2pet());
/* 52 */         info.team_info.put(Integer.valueOf(teamNo), petFightTeamInfo);
/*    */       }
/*    */     }
/*    */     
/*    */ 
/* 57 */     RolePetFightFormation xRolePetFightFormation = PetFightManager.getRolePetFightFormation(this.roleId, true);
/* 58 */     if (xRolePetFightFormation != null)
/*    */     {
/* 60 */       for (Map.Entry<Integer, xbean.PetFightFormationInfo> entry : xRolePetFightFormation.getFormation_info().entrySet())
/*    */       {
/* 62 */         int formationId = ((Integer)entry.getKey()).intValue();
/* 63 */         xbean.PetFightFormationInfo xPetFightFormationInfo = (xbean.PetFightFormationInfo)entry.getValue();
/* 64 */         mzm.gsp.pet.PetFightFormationInfo petFightFormationInfo = new mzm.gsp.pet.PetFightFormationInfo();
/* 65 */         petFightFormationInfo.level = xPetFightFormationInfo.getLevel();
/* 66 */         petFightFormationInfo.exp = xPetFightFormationInfo.getExp();
/* 67 */         info.formation_info.put(Integer.valueOf(formationId), petFightFormationInfo);
/*    */       }
/*    */     }
/* 70 */     mzm.gsp.pet.PetFightFormationInfo defaultFormationInfo = new mzm.gsp.pet.PetFightFormationInfo();
/* 71 */     info.formation_info.put(Integer.valueOf(SPetFightConsts.getInstance().DEFAULT_FORMATION_ID), defaultFormationInfo);
/*    */     
/*    */ 
/* 74 */     RolePetFightSkill xRolePetFightSkill = PetFightManager.getRolePetFightSkill(this.roleId, true);
/* 75 */     if (xRolePetFightSkill == null)
/*    */     {
/* 77 */       info.skill_info.skills.addAll(PetFightManager.getFreePetFightSkills());
/*    */     }
/*    */     else
/*    */     {
/* 81 */       info.skill_info.skills.addAll(xRolePetFightSkill.getSkills());
/* 82 */       info.skill_info.pet2skill.putAll(xRolePetFightSkill.getPet2skill());
/*    */     }
/*    */     
/* 85 */     OnlineManager.getInstance().send(this.roleId, syncPetFightInformation);
/* 86 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\PPetFightSyncInformation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
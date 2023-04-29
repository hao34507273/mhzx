/*     */ package mzm.gsp.pet.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.pet.confbean.PetFightFormationImproveCfg;
/*     */ import mzm.gsp.pet.confbean.PetFightFormationLevelInfo;
/*     */ import mzm.gsp.pet.confbean.SPetFightConsts;
/*     */ import mzm.gsp.pet.confbean.SPetFightFormationCfg;
/*     */ import xbean.PetFightFormationInfo;
/*     */ import xbean.PetFightTeamInfo;
/*     */ import xbean.RolePetFightFormation;
/*     */ import xbean.RolePetFightSkill;
/*     */ import xbean.RolePetFightTeam;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PetFightInterface
/*     */ {
/*     */   public static PetFightTeam getPetFightTeam(long roleId, int teamNo, boolean holdLock)
/*     */   {
/*  32 */     if (!PetFightManager.isTeamNumberValid(teamNo))
/*     */     {
/*  34 */       return null;
/*     */     }
/*     */     
/*  37 */     RolePetFightTeam xRolePetFightTeam = PetFightManager.getRolePetFightTeam(roleId, holdLock);
/*  38 */     if (xRolePetFightTeam == null)
/*     */     {
/*  40 */       return new PetFightTeam(SPetFightConsts.getInstance().DEFAULT_FORMATION_ID, 0);
/*     */     }
/*  42 */     PetFightTeamInfo xPetFightTeamInfo = (PetFightTeamInfo)xRolePetFightTeam.getTeam_info().get(Integer.valueOf(teamNo));
/*  43 */     if (xPetFightTeamInfo == null)
/*     */     {
/*  45 */       return new PetFightTeam(SPetFightConsts.getInstance().DEFAULT_FORMATION_ID, 0);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  51 */     RolePetFightFormation xRolePetFightFormation = PetFightManager.getRolePetFightFormation(roleId, holdLock);
/*  52 */     int formationLevel; int formationId; int formationLevel; if (xRolePetFightFormation == null)
/*     */     {
/*  54 */       int formationId = SPetFightConsts.getInstance().DEFAULT_FORMATION_ID;
/*  55 */       formationLevel = 0;
/*     */     }
/*     */     else
/*     */     {
/*  59 */       PetFightFormationInfo xPetFightFormationInfo = (PetFightFormationInfo)xRolePetFightFormation.getFormation_info().get(Integer.valueOf(xPetFightTeamInfo.getFormation_id()));
/*     */       int formationLevel;
/*  61 */       if (xPetFightFormationInfo == null)
/*     */       {
/*  63 */         int formationId = SPetFightConsts.getInstance().DEFAULT_FORMATION_ID;
/*  64 */         formationLevel = 0;
/*     */       }
/*     */       else
/*     */       {
/*  68 */         formationId = xPetFightTeamInfo.getFormation_id();
/*  69 */         formationLevel = xPetFightFormationInfo.getLevel();
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*  74 */     PetFightTeam result = new PetFightTeam(formationId, formationLevel);
/*  75 */     Map<Integer, PetFightTeam.Position> rawPositions = new HashMap();
/*  76 */     RolePetFightSkill xRolePetFightSkill = PetFightManager.getRolePetFightSkill(roleId, holdLock);
/*  77 */     for (Map.Entry<Integer, Long> entry : xPetFightTeamInfo.getPosition2pet().entrySet())
/*     */     {
/*  79 */       long petId = ((Long)entry.getValue()).longValue();
/*     */       int petFightSkillId;
/*  81 */       int petFightSkillId; if (xRolePetFightSkill == null)
/*     */       {
/*  83 */         petFightSkillId = 0;
/*     */       }
/*     */       else {
/*     */         int petFightSkillId;
/*  87 */         if (xRolePetFightSkill.getPet2skill().containsKey(Long.valueOf(petId)))
/*     */         {
/*  89 */           petFightSkillId = ((Integer)xRolePetFightSkill.getPet2skill().get(Long.valueOf(petId))).intValue();
/*     */         }
/*     */         else
/*     */         {
/*  93 */           petFightSkillId = 0;
/*     */         }
/*     */       }
/*  96 */       PetFightTeam.Position position = new PetFightTeam.Position(petId, petFightSkillId, ((Integer)entry.getKey()).intValue());
/*  97 */       rawPositions.put(entry.getKey(), position);
/*     */     }
/*     */     
/*     */ 
/* 101 */     if (formationId != SPetFightConsts.getInstance().DEFAULT_FORMATION_ID)
/*     */     {
/* 103 */       PetFightFormationImproveCfg improveCfg = PetFightFormationImproveCfg.get(formationId);
/* 104 */       if ((improveCfg == null) || (formationLevel >= improveCfg.levels.size()))
/*     */       {
/* 106 */         return result;
/*     */       }
/* 108 */       PetFightFormationLevelInfo levelInfo = (PetFightFormationLevelInfo)improveCfg.levels.get(formationLevel);
/* 109 */       if (rawPositions.containsKey(Integer.valueOf(1)))
/*     */       {
/* 111 */         for (int i = 0; i < levelInfo.position1Attrs.size(); i++)
/*     */         {
/* 113 */           ((PetFightTeam.Position)rawPositions.get(Integer.valueOf(1))).properties.put(levelInfo.position1Attrs.get(i), levelInfo.position1Values.get(i));
/*     */         }
/*     */       }
/* 116 */       if (rawPositions.containsKey(Integer.valueOf(2)))
/*     */       {
/* 118 */         for (int i = 0; i < levelInfo.position2Attrs.size(); i++)
/*     */         {
/* 120 */           ((PetFightTeam.Position)rawPositions.get(Integer.valueOf(2))).properties.put(levelInfo.position2Attrs.get(i), levelInfo.position2Values.get(i));
/*     */         }
/*     */       }
/* 123 */       if (rawPositions.containsKey(Integer.valueOf(3)))
/*     */       {
/* 125 */         for (int i = 0; i < levelInfo.position3Attrs.size(); i++)
/*     */         {
/* 127 */           ((PetFightTeam.Position)rawPositions.get(Integer.valueOf(3))).properties.put(levelInfo.position3Attrs.get(i), levelInfo.position3Values.get(i));
/*     */         }
/*     */       }
/* 130 */       if (rawPositions.containsKey(Integer.valueOf(4)))
/*     */       {
/* 132 */         for (int i = 0; i < levelInfo.position4Attrs.size(); i++)
/*     */         {
/* 134 */           ((PetFightTeam.Position)rawPositions.get(Integer.valueOf(4))).properties.put(levelInfo.position4Attrs.get(i), levelInfo.position4Values.get(i));
/*     */         }
/*     */       }
/* 137 */       if (rawPositions.containsKey(Integer.valueOf(5)))
/*     */       {
/* 139 */         for (int i = 0; i < levelInfo.position5Attrs.size(); i++)
/*     */         {
/* 141 */           ((PetFightTeam.Position)rawPositions.get(Integer.valueOf(5))).properties.put(levelInfo.position5Attrs.get(i), levelInfo.position5Values.get(i));
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 147 */     SPetFightFormationCfg formationCfg = SPetFightFormationCfg.get(formationId);
/* 148 */     if (formationCfg == null)
/*     */     {
/* 150 */       return result;
/*     */     }
/* 152 */     if (rawPositions.containsKey(Integer.valueOf(1)))
/*     */     {
/* 154 */       result.positions.put(Integer.valueOf(formationCfg.position1), rawPositions.get(Integer.valueOf(1)));
/*     */     }
/* 156 */     if (rawPositions.containsKey(Integer.valueOf(2)))
/*     */     {
/* 158 */       result.positions.put(Integer.valueOf(formationCfg.position2), rawPositions.get(Integer.valueOf(2)));
/*     */     }
/* 160 */     if (rawPositions.containsKey(Integer.valueOf(3)))
/*     */     {
/* 162 */       result.positions.put(Integer.valueOf(formationCfg.position3), rawPositions.get(Integer.valueOf(3)));
/*     */     }
/* 164 */     if (rawPositions.containsKey(Integer.valueOf(4)))
/*     */     {
/* 166 */       result.positions.put(Integer.valueOf(formationCfg.position4), rawPositions.get(Integer.valueOf(4)));
/*     */     }
/* 168 */     if (rawPositions.containsKey(Integer.valueOf(5)))
/*     */     {
/* 170 */       result.positions.put(Integer.valueOf(formationCfg.position5), rawPositions.get(Integer.valueOf(5)));
/*     */     }
/*     */     
/* 173 */     return result;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static PetFightTeam getPetFightDefenseTeam(long roleId, boolean holdLock)
/*     */   {
/* 184 */     RolePetFightTeam xRolePetFightTeam = PetFightManager.getRolePetFightTeam(roleId, holdLock);
/* 185 */     if (xRolePetFightTeam == null)
/*     */     {
/* 187 */       return null;
/*     */     }
/* 189 */     int teamNo = xRolePetFightTeam.getDefense_team();
/* 190 */     if (teamNo == -1)
/*     */     {
/* 192 */       return null;
/*     */     }
/* 194 */     return getPetFightTeam(roleId, teamNo, holdLock);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isPetInDefenseTeam(long roleId, long petId, boolean holdLock)
/*     */   {
/* 206 */     return PetFightManager.isPetInDefenseTeam(roleId, petId, holdLock);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void clearPetFightDataForCertainPet(long roleId, long petId)
/*     */   {
/* 217 */     PetFightManager.clearPetFightDataForCertainPet(roleId, petId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static List<Integer> getAvailableGridsFromFormation(int formationId)
/*     */   {
/* 225 */     SPetFightFormationCfg formationCfg = SPetFightFormationCfg.get(formationId);
/* 226 */     if (formationCfg == null)
/*     */     {
/* 228 */       return null;
/*     */     }
/* 230 */     List<Integer> grids = new ArrayList();
/* 231 */     grids.add(Integer.valueOf(formationCfg.position1));
/* 232 */     grids.add(Integer.valueOf(formationCfg.position2));
/* 233 */     grids.add(Integer.valueOf(formationCfg.position3));
/* 234 */     grids.add(Integer.valueOf(formationCfg.position4));
/* 235 */     grids.add(Integer.valueOf(formationCfg.position5));
/* 236 */     return grids;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\PetFightInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
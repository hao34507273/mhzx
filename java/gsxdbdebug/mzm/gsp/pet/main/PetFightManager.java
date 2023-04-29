/*     */ package mzm.gsp.pet.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.pet.SSyncPetFightPosition;
/*     */ import mzm.gsp.pet.SSyncPetFightSkill;
/*     */ import mzm.gsp.pet.confbean.SPetFightConsts;
/*     */ import mzm.gsp.pet.confbean.SPetFightSkillCfg;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.PetFightFormationInfo;
/*     */ import xbean.PetFightTeamInfo;
/*     */ import xbean.Pod;
/*     */ import xbean.RolePetFightFormation;
/*     */ import xbean.RolePetFightSkill;
/*     */ import xbean.RolePetFightTeam;
/*     */ import xtable.Role2pet_fight_formation;
/*     */ import xtable.Role2pet_fight_skill;
/*     */ import xtable.Role2pet_fight_team;
/*     */ 
/*     */ class PetFightManager
/*     */ {
/*     */   static final int UNDEFINED_DEFENSE_TEAM_NUMBER = -1;
/*     */   static final int MIN_LEVEL_OF_AVAILABLE_FORMATION = 1;
/*  33 */   private static final Logger LOGGER = Logger.getLogger(PetFightManager.class);
/*     */   private static final String IMPROVE_FORMATION = "ImprovePetFightFormation";
/*     */   private static final String UNLOCK_SKILL = "UnlockPetFightSkill";
/*     */   
/*  37 */   static void logInfo(String str, Object... args) { LOGGER.info("[PetFight]" + String.format(str, args)); }
/*     */   
/*     */ 
/*     */   static void logError(String str, Object... args)
/*     */   {
/*  42 */     LOGGER.error("[PetFight]" + String.format(str, args));
/*     */   }
/*     */   
/*     */   private static void tlog(long roleId, String event, Object... args)
/*     */   {
/*  47 */     String userId = RoleInterface.getUserId(roleId);
/*  48 */     if (userId == null)
/*     */     {
/*  50 */       return;
/*     */     }
/*  52 */     List<Object> list = new ArrayList();
/*  53 */     list.add(mzm.gsp.GameServerInfoManager.getHostIP());
/*  54 */     list.add(userId);
/*  55 */     list.add(Long.valueOf(roleId));
/*  56 */     list.add(Integer.valueOf(RoleInterface.getLevel(roleId)));
/*  57 */     java.util.Collections.addAll(list, args);
/*  58 */     TLogManager.getInstance().addLog(userId, event, list.toArray());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static void tlogImproveFormation(long roleId, int formationId, int level, int exp)
/*     */   {
/*  65 */     tlog(roleId, "ImprovePetFightFormation", new Object[] { Integer.valueOf(formationId), Integer.valueOf(level), Integer.valueOf(exp) });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static void tlogUnlockSkill(long roleId, int skillId)
/*     */   {
/*  72 */     tlog(roleId, "UnlockPetFightSkill", new Object[] { Integer.valueOf(skillId) });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isEnabled()
/*     */   {
/*  80 */     return OpenInterface.getOpenStatus(559);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isFightSkillEnabled()
/*     */   {
/*  88 */     return OpenInterface.getOpenStatus(576);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isRoleLevelEnough(long roleId)
/*     */   {
/*  96 */     return RoleInterface.getLevel(roleId) >= SPetFightConsts.getInstance().OPEN_LEVEL;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isTeamNumberValid(int teamNo)
/*     */   {
/* 104 */     return (1 <= teamNo) && (teamNo <= SPetFightConsts.getInstance().MAX_TEAM_NUMBER);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isPositionValid(int position)
/*     */   {
/* 112 */     return (1 <= position) && (position <= SPetFightConsts.getInstance().MAX_POSITION_NUMBER);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static RolePetFightTeam getRolePetFightTeam(long roleId, boolean holdLock)
/*     */   {
/* 120 */     return holdLock ? Role2pet_fight_team.get(Long.valueOf(roleId)) : Role2pet_fight_team.select(Long.valueOf(roleId));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static RolePetFightTeam getOrCreateRolePetFightTeam(long roleId)
/*     */   {
/* 128 */     RolePetFightTeam xRolePetFightTeam = Role2pet_fight_team.get(Long.valueOf(roleId));
/* 129 */     if (xRolePetFightTeam == null)
/*     */     {
/* 131 */       xRolePetFightTeam = Pod.newRolePetFightTeam();
/* 132 */       Role2pet_fight_team.insert(Long.valueOf(roleId), xRolePetFightTeam);
/*     */     }
/* 134 */     return xRolePetFightTeam;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static PetFightTeamInfo getOrCreatePetFightTeamInfo(RolePetFightTeam xRolePetFightTeam, int teamNo)
/*     */   {
/* 142 */     PetFightTeamInfo xPetFightTeamInfo = (PetFightTeamInfo)xRolePetFightTeam.getTeam_info().get(Integer.valueOf(teamNo));
/* 143 */     if (xPetFightTeamInfo == null)
/*     */     {
/* 145 */       xPetFightTeamInfo = Pod.newPetFightTeamInfo();
/* 146 */       xPetFightTeamInfo.setFormation_id(SPetFightConsts.getInstance().DEFAULT_FORMATION_ID);
/* 147 */       xRolePetFightTeam.getTeam_info().put(Integer.valueOf(teamNo), xPetFightTeamInfo);
/*     */     }
/* 149 */     return xPetFightTeamInfo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static RolePetFightFormation getRolePetFightFormation(long roleId, boolean holdLock)
/*     */   {
/* 157 */     return holdLock ? Role2pet_fight_formation.get(Long.valueOf(roleId)) : Role2pet_fight_formation.select(Long.valueOf(roleId));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static RolePetFightFormation getOrCreateRolePetFightFormation(long roleId)
/*     */   {
/* 165 */     RolePetFightFormation xRolePetFightFormation = Role2pet_fight_formation.get(Long.valueOf(roleId));
/* 166 */     if (xRolePetFightFormation == null)
/*     */     {
/* 168 */       xRolePetFightFormation = Pod.newRolePetFightFormation();
/* 169 */       Role2pet_fight_formation.insert(Long.valueOf(roleId), xRolePetFightFormation);
/*     */     }
/* 171 */     return xRolePetFightFormation;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static PetFightFormationInfo getOrCreatePetFightFormationInfo(RolePetFightFormation xRolePetFightFormation, int formationId)
/*     */   {
/* 180 */     PetFightFormationInfo xPetFightFormationInfo = (PetFightFormationInfo)xRolePetFightFormation.getFormation_info().get(Integer.valueOf(formationId));
/* 181 */     if (xPetFightFormationInfo == null)
/*     */     {
/* 183 */       xPetFightFormationInfo = Pod.newPetFightFormationInfo();
/* 184 */       xRolePetFightFormation.getFormation_info().put(Integer.valueOf(formationId), xPetFightFormationInfo);
/*     */     }
/* 186 */     return xPetFightFormationInfo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static RolePetFightSkill getRolePetFightSkill(long roleId, boolean holdLock)
/*     */   {
/* 194 */     return holdLock ? Role2pet_fight_skill.get(Long.valueOf(roleId)) : Role2pet_fight_skill.select(Long.valueOf(roleId));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static RolePetFightSkill getOrCreateRolePetFightSkill(long roleId)
/*     */   {
/* 202 */     RolePetFightSkill xRolePetFightSkill = Role2pet_fight_skill.get(Long.valueOf(roleId));
/* 203 */     if (xRolePetFightSkill == null)
/*     */     {
/* 205 */       xRolePetFightSkill = Pod.newRolePetFightSkill();
/* 206 */       xRolePetFightSkill.getSkills().addAll(getFreePetFightSkills());
/* 207 */       Role2pet_fight_skill.insert(Long.valueOf(roleId), xRolePetFightSkill);
/*     */     }
/* 209 */     return xRolePetFightSkill;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static Set<Integer> getFreePetFightSkills()
/*     */   {
/* 217 */     Set<Integer> skills = new java.util.HashSet();
/* 218 */     for (SPetFightSkillCfg petFightSkillCfg : SPetFightSkillCfg.getAll().values())
/*     */     {
/* 220 */       if (petFightSkillCfg.unlockScore == 0)
/*     */       {
/* 222 */         skills.add(Integer.valueOf(petFightSkillCfg.id));
/*     */       }
/*     */     }
/* 225 */     return skills;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isPetInDefenseTeam(long roleId, long petId, boolean holdLock)
/*     */   {
/* 233 */     RolePetFightTeam xRolePetFightTeam = getRolePetFightTeam(roleId, holdLock);
/* 234 */     if (xRolePetFightTeam == null)
/*     */     {
/* 236 */       return false;
/*     */     }
/* 238 */     int defenseTeamNo = xRolePetFightTeam.getDefense_team();
/* 239 */     if (defenseTeamNo == -1)
/*     */     {
/* 241 */       return false;
/*     */     }
/* 243 */     PetFightTeamInfo xPetFightTeamInfo = (PetFightTeamInfo)xRolePetFightTeam.getTeam_info().get(Integer.valueOf(defenseTeamNo));
/* 244 */     if (xPetFightTeamInfo == null)
/*     */     {
/* 246 */       return false;
/*     */     }
/* 248 */     return xPetFightTeamInfo.getPosition2pet().values().contains(Long.valueOf(petId));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void clearPetFightDataForCertainPet(long roleId, long petId)
/*     */   {
/* 258 */     RolePetFightTeam xRolePetFightTeam = getRolePetFightTeam(roleId, true);
/* 259 */     if (xRolePetFightTeam != null)
/*     */     {
/* 261 */       for (Map.Entry<Integer, PetFightTeamInfo> entry : xRolePetFightTeam.getTeam_info().entrySet())
/*     */       {
/* 263 */         int teamNo = ((Integer)entry.getKey()).intValue();
/* 264 */         PetFightTeamInfo xPetFightTeamInfo = (PetFightTeamInfo)entry.getValue();
/*     */         
/* 266 */         int positionToClear = -1;
/* 267 */         for (Map.Entry<Integer, Long> e : xPetFightTeamInfo.getPosition2pet().entrySet())
/*     */         {
/* 269 */           if (((Long)e.getValue()).longValue() == petId)
/*     */           {
/* 271 */             positionToClear = ((Integer)e.getKey()).intValue();
/* 272 */             break;
/*     */           }
/*     */         }
/* 275 */         if (positionToClear != -1)
/*     */         {
/* 277 */           xPetFightTeamInfo.getPosition2pet().remove(Integer.valueOf(positionToClear));
/* 278 */           SSyncPetFightPosition sync = new SSyncPetFightPosition();
/* 279 */           sync.team = teamNo;
/* 280 */           sync.position2pet.putAll(xPetFightTeamInfo.getPosition2pet());
/* 281 */           OnlineManager.getInstance().send(roleId, sync);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 287 */     RolePetFightSkill xRolePetFightSkill = getRolePetFightSkill(roleId, true);
/* 288 */     if (xRolePetFightSkill != null)
/*     */     {
/* 290 */       if (xRolePetFightSkill.getPet2skill().remove(Long.valueOf(petId)) != null)
/*     */       {
/* 292 */         SSyncPetFightSkill sync = new SSyncPetFightSkill();
/* 293 */         sync.pet2skill.putAll(xRolePetFightSkill.getPet2skill());
/* 294 */         OnlineManager.getInstance().send(roleId, sync);
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\PetFightManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
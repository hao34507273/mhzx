/*     */ package mzm.gsp.achievement.main.goaltype;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.achievement.confbean.GoalParameter;
/*     */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*     */ import mzm.gsp.pet.main.PetInterface;
/*     */ import xbean.AchievementInfo;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PetSkillNum
/*     */   extends AbstractGoalType
/*     */ {
/*     */   public int getType()
/*     */   {
/*  24 */     return 5404;
/*     */   }
/*     */   
/*     */ 
/*     */   public void initParams(AchievementInfo xAchievementInfo)
/*     */   {
/*  30 */     xAchievementInfo.getGoal_parameters().add(Integer.valueOf(0));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean updateState(long roleId, AchievementInfo xAchievementInfo, SAchievementGoalCfg sAchievementGoalCfg, Object context)
/*     */   {
/*  37 */     int goalPetCfgId = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(0)).parameter;
/*  38 */     long petId = ((Long)context).longValue();
/*  39 */     int petCfgId = PetInterface.getPetCfgIdByPetId(roleId, petId);
/*     */     
/*  41 */     if (petCfgId <= 0)
/*     */     {
/*  43 */       if (null != xAchievementInfo.getGoal_parameters_extra().remove(Long.valueOf(petId)))
/*     */       {
/*  45 */         int oldNum = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/*  46 */         xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(Math.max(0, oldNum - 1)));
/*  47 */         return true;
/*     */       }
/*  49 */       return false;
/*     */     }
/*     */     
/*  52 */     if ((goalPetCfgId != 0) && (goalPetCfgId != petCfgId))
/*     */     {
/*  54 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  58 */     int goalSkillNum = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(1)).parameter;
/*  59 */     int skillNum = PetInterface.getPetSkillNum(roleId, petId);
/*  60 */     if (skillNum < goalSkillNum)
/*     */     {
/*  62 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  66 */     Map<Long, String> goalParameterExtra = xAchievementInfo.getGoal_parameters_extra();
/*  67 */     if (null != goalParameterExtra.get(Long.valueOf(petId)))
/*     */     {
/*  69 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  73 */     List<Integer> goalParameters = xAchievementInfo.getGoal_parameters();
/*  74 */     int oldNum = ((Integer)goalParameters.get(0)).intValue();
/*  75 */     goalParameters.set(0, Integer.valueOf(oldNum + 1));
/*  76 */     goalParameterExtra.put(Long.valueOf(petId), String.valueOf(petId));
/*     */     
/*  78 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected boolean innerCheckGoalState(long roleId, SAchievementGoalCfg sAchievementGoalCfg, AchievementInfo xAchievementInfo, List<Integer> goalParameters)
/*     */   {
/*  85 */     Collection<Long> petIds = PetInterface.getPetList(roleId, true);
/*  86 */     Map<Long, String> goalParameterExtra = xAchievementInfo.getGoal_parameters_extra();
/*  87 */     int goalPetCfgId = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(0)).parameter;
/*  88 */     int goalSkillNum = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(1)).parameter;
/*  89 */     int nowNum = 0;
/*  90 */     for (Iterator i$ = petIds.iterator(); i$.hasNext();) { long petId = ((Long)i$.next()).longValue();
/*     */       
/*  92 */       int petCfgId = PetInterface.getPetCfgIdByPetId(roleId, petId);
/*  93 */       if ((goalPetCfgId == 0) || (petCfgId == goalPetCfgId))
/*     */       {
/*     */ 
/*     */ 
/*  97 */         int skillNum = PetInterface.getPetSkillNum(roleId, petId);
/*  98 */         if (goalSkillNum <= skillNum)
/*     */         {
/*     */ 
/*     */ 
/* 102 */           nowNum++;
/* 103 */           if (null == goalParameterExtra.get(Long.valueOf(petId)))
/*     */           {
/*     */ 
/*     */ 
/* 107 */             goalParameterExtra.put(Long.valueOf(petId), String.valueOf(petId)); }
/*     */         } } }
/* 109 */     int oldNum = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/* 110 */     if (oldNum == nowNum)
/*     */     {
/* 112 */       return false;
/*     */     }
/* 114 */     int goalNum = ((Integer)goalParameters.get(0)).intValue();
/* 115 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(Math.min(goalNum, nowNum)));
/*     */     
/* 117 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\PetSkillNum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
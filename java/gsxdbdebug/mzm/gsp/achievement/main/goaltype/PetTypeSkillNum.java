/*     */ package mzm.gsp.achievement.main.goaltype;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.achievement.confbean.GoalParameter;
/*     */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*     */ import mzm.gsp.pet.main.Pet;
/*     */ import mzm.gsp.pet.main.PetInterface;
/*     */ import xbean.AchievementInfo;
/*     */ 
/*     */ public class PetTypeSkillNum extends AbstractGoalType
/*     */ {
/*     */   public int getType()
/*     */   {
/*  18 */     return 5405;
/*     */   }
/*     */   
/*     */ 
/*     */   public void initParams(AchievementInfo xAchievementInfo)
/*     */   {
/*  24 */     xAchievementInfo.getGoal_parameters().add(Integer.valueOf(0));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean updateState(long roleId, AchievementInfo xAchievementInfo, SAchievementGoalCfg sAchievementGoalCfg, Object context)
/*     */   {
/*  31 */     long petId = ((Long)context).longValue();
/*  32 */     Pet pet = PetInterface.getPetById(roleId, petId);
/*     */     
/*  34 */     if (null == pet)
/*     */     {
/*  36 */       if (null != xAchievementInfo.getGoal_parameters_extra().remove(Long.valueOf(petId)))
/*     */       {
/*  38 */         int oldNum = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/*  39 */         xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(Math.max(0, oldNum - 1)));
/*  40 */         return true;
/*     */       }
/*  42 */       return false;
/*     */     }
/*  44 */     int petType = pet.getPetType();
/*     */     
/*  46 */     if (!PetOwn.getNeedPetTypes(sAchievementGoalCfg).contains(Integer.valueOf(petType)))
/*     */     {
/*  48 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  52 */     int goalSkillNum = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(1)).parameter;
/*  53 */     int skillNum = PetInterface.getPetSkillNum(roleId, petId);
/*  54 */     if (skillNum < goalSkillNum)
/*     */     {
/*  56 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  60 */     Map<Long, String> goalParameterExtra = xAchievementInfo.getGoal_parameters_extra();
/*  61 */     if (null != goalParameterExtra.get(Long.valueOf(petId)))
/*     */     {
/*  63 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  67 */     List<Integer> goalParameters = xAchievementInfo.getGoal_parameters();
/*  68 */     int oldNum = ((Integer)goalParameters.get(0)).intValue();
/*  69 */     goalParameters.set(0, Integer.valueOf(oldNum + 1));
/*  70 */     goalParameterExtra.put(Long.valueOf(petId), String.valueOf(petId));
/*     */     
/*  72 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected boolean innerCheckGoalState(long roleId, SAchievementGoalCfg sAchievementGoalCfg, AchievementInfo xAchievementInfo, List<Integer> goalParameters)
/*     */   {
/*  79 */     Collection<Long> petIds = PetInterface.getPetList(roleId, true);
/*  80 */     Map<Long, String> goalParameterExtra = xAchievementInfo.getGoal_parameters_extra();
/*  81 */     Collection<Integer> goalPetTypes = PetOwn.getNeedPetTypes(sAchievementGoalCfg);
/*  82 */     int goalSkillNum = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(1)).parameter;
/*  83 */     int nowNum = 0;
/*  84 */     for (Iterator i$ = petIds.iterator(); i$.hasNext();) { long petId = ((Long)i$.next()).longValue();
/*     */       
/*  86 */       Pet pet = PetInterface.getPetById(roleId, petId);
/*  87 */       int petType = pet.getPetType();
/*  88 */       if (goalPetTypes.contains(Integer.valueOf(petType)))
/*     */       {
/*     */ 
/*     */ 
/*  92 */         int skillNum = PetInterface.getPetSkillNum(roleId, petId);
/*  93 */         if (goalSkillNum <= skillNum)
/*     */         {
/*     */ 
/*     */ 
/*  97 */           nowNum++;
/*  98 */           if (null == goalParameterExtra.get(Long.valueOf(petId)))
/*     */           {
/*     */ 
/*     */ 
/* 102 */             goalParameterExtra.put(Long.valueOf(petId), String.valueOf(petId)); }
/*     */         } } }
/* 104 */     int oldNum = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/* 105 */     if (oldNum == nowNum)
/*     */     {
/* 107 */       return false;
/*     */     }
/* 109 */     int goalNum = ((Integer)goalParameters.get(0)).intValue();
/* 110 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(Math.min(goalNum, nowNum)));
/*     */     
/* 112 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\PetTypeSkillNum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
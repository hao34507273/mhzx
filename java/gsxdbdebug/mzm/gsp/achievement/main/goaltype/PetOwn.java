/*     */ package mzm.gsp.achievement.main.goaltype;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import mzm.gsp.achievement.confbean.GoalParameter;
/*     */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*     */ import mzm.gsp.pet.main.Pet;
/*     */ import mzm.gsp.pet.main.PetInterface;
/*     */ import xbean.AchievementInfo;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PetOwn
/*     */   extends AbstractGoalType
/*     */ {
/*     */   public int getType()
/*     */   {
/*  21 */     return 2;
/*     */   }
/*     */   
/*     */ 
/*     */   public void initParams(AchievementInfo xAchievementInfo)
/*     */   {
/*  27 */     xAchievementInfo.getGoal_parameters().add(Integer.valueOf(0));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean innerCheckGoalState(long roleId, SAchievementGoalCfg sAchievementGoalCfg, AchievementInfo xAchievementInfo, List<Integer> goalParameters)
/*     */   {
/*  35 */     List<Integer> petTypeList = getNeedPetTypes(sAchievementGoalCfg);
/*  36 */     if (petTypeList == null)
/*     */     {
/*  38 */       return false;
/*     */     }
/*  40 */     int rolePetNum = PetInterface.getTypePetCount(roleId, petTypeList);
/*     */     
/*  42 */     int goalPetNum = ((Integer)goalParameters.get(0)).intValue();
/*  43 */     int oldPetNum = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/*  44 */     if (oldPetNum == rolePetNum)
/*     */     {
/*  46 */       return false;
/*     */     }
/*  48 */     if (oldPetNum < rolePetNum)
/*     */     {
/*  50 */       xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(Math.min(goalPetNum, rolePetNum)));
/*     */     }
/*  52 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean updateState(long roleId, AchievementInfo xAchievementInfo, SAchievementGoalCfg sAchievementGoalCfg, Object context)
/*     */   {
/*  60 */     long petId = ((Long)context).longValue();
/*  61 */     Pet pet = PetInterface.getPetByPetId(roleId, petId, true);
/*  62 */     if (pet == null)
/*     */     {
/*  64 */       return false;
/*     */     }
/*  66 */     if (!getNeedPetTypes(sAchievementGoalCfg).contains(Integer.valueOf(pet.getPetType())))
/*     */     {
/*  68 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  72 */     int oldTimes = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/*  73 */     int goalTimes = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(1)).parameter;
/*  74 */     int newTimes = oldTimes + 1;
/*  75 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(Math.min(goalTimes, newTimes)));
/*     */     
/*  77 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static List<Integer> getNeedPetTypes(SAchievementGoalCfg cfg)
/*     */   {
/*  89 */     if (cfg.goalType != 2)
/*     */     {
/*  91 */       return null;
/*     */     }
/*     */     
/*  94 */     List<GoalParameter> parameters = cfg.goalParameters;
/*  95 */     if ((parameters == null) || (parameters.size() == 0))
/*     */     {
/*  97 */       return null;
/*     */     }
/*     */     
/* 100 */     int petType = ((GoalParameter)parameters.get(0)).parameter;
/* 101 */     if ((petType <= 0) || (petType >= 32))
/*     */     {
/* 103 */       return null;
/*     */     }
/*     */     
/* 106 */     List<Integer> petTypes = new ArrayList();
/* 107 */     if (4 == (0x4 & petType))
/*     */     {
/* 109 */       petTypes.add(Integer.valueOf(2));
/*     */     }
/* 111 */     if (2 == (0x2 & petType))
/*     */     {
/* 113 */       petTypes.add(Integer.valueOf(1));
/*     */     }
/* 115 */     if (1 == (0x1 & petType))
/*     */     {
/* 117 */       petTypes.add(Integer.valueOf(0));
/*     */     }
/* 119 */     if (16 == (0x10 & petType))
/*     */     {
/* 121 */       petTypes.add(Integer.valueOf(3));
/*     */     }
/* 123 */     if (8 == (0x8 & petType))
/*     */     {
/* 125 */       petTypes.add(Integer.valueOf(4));
/*     */     }
/*     */     
/* 128 */     return petTypes;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\PetOwn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
/*     */ package mzm.gsp.achievement.main.goaltype;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.achievement.confbean.GoalParameter;
/*     */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*     */ import xbean.AchievementInfo;
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
/*     */ public abstract class AbstractFightResult
/*     */   extends AbstractGoalType
/*     */ {
/*     */   private static enum FightType
/*     */   {
/*  28 */     PVE(1),  PVP(2),  PVC(4);
/*     */     
/*     */     private int value;
/*     */     
/*     */     private FightType(int value) {
/*  33 */       this.value = value;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void initParams(AchievementInfo xAchievementInfo)
/*     */   {
/*  40 */     xAchievementInfo.getGoal_parameters().add(Integer.valueOf(0));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean updateState(long roleId, AchievementInfo xAchievementInfo, SAchievementGoalCfg sAchievementGoalCfg, Object ctx)
/*     */   {
/*  47 */     Context context = (Context)ctx;
/*     */     
/*  49 */     int goalFightType = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(0)).parameter;
/*  50 */     int fightType = getFightTypeEnum(context.fightType).value;
/*  51 */     if ((goalFightType & fightType) == 0)
/*     */     {
/*  53 */       return false;
/*     */     }
/*     */     
/*  56 */     List<Integer> validConditionIds = new LinkedList();
/*     */     
/*  58 */     for (int i = 2; i < sAchievementGoalCfg.goalParameters.size(); i++)
/*     */     {
/*  60 */       GoalParameter parameter = (GoalParameter)sAchievementGoalCfg.goalParameters.get(i);
/*  61 */       if (parameter.parameter != 0)
/*     */       {
/*  63 */         validConditionIds.add(Integer.valueOf(parameter.parameter));
/*     */       }
/*     */     }
/*  66 */     int validCount = context.getValidCount(validConditionIds);
/*     */     
/*     */ 
/*  69 */     int oldTimes = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/*  70 */     int goalTimes = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(1)).parameter;
/*  71 */     int newTimes = oldTimes + validCount;
/*  72 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(Math.min(goalTimes, newTimes)));
/*  73 */     return true;
/*     */   }
/*     */   
/*     */   private final FightType getFightTypeEnum(int fightType)
/*     */   {
/*  78 */     switch (fightType)
/*     */     {
/*     */     case 1: 
/*  81 */       return FightType.PVP;
/*     */     case 2: 
/*  83 */       return FightType.PVC;
/*     */     }
/*  85 */     return FightType.PVE;
/*     */   }
/*     */   
/*     */ 
/*     */   public static class Context
/*     */   {
/*     */     public final int fightType;
/*     */     
/*     */     private final Map<Integer, Integer> countMap;
/*     */     
/*     */ 
/*     */     public Context(int fightType, Map<Integer, Integer> countMap)
/*     */     {
/*  98 */       this.fightType = fightType;
/*  99 */       this.countMap = countMap;
/*     */     }
/*     */     
/*     */     public int getValidCount(Collection<Integer> conditionIds)
/*     */     {
/* 104 */       int result = 0;
/* 105 */       Iterator i$; Iterator i$; if (conditionIds.size() == 0)
/*     */       {
/*     */ 
/* 108 */         for (i$ = this.countMap.values().iterator(); i$.hasNext();) { int count = ((Integer)i$.next()).intValue();
/*     */           
/* 110 */           result += count;
/*     */         }
/*     */         
/*     */       }
/*     */       else {
/* 115 */         for (i$ = conditionIds.iterator(); i$.hasNext();) { int conditionId = ((Integer)i$.next()).intValue();
/*     */           
/* 117 */           result += ((Integer)this.countMap.get(Integer.valueOf(conditionId))).intValue();
/*     */         }
/*     */       }
/* 120 */       return result;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\AbstractFightResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
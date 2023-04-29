/*     */ package mzm.gsp.achievement.main.goaltype;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.achievement.confbean.GoalParameter;
/*     */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*     */ import xbean.AchievementInfo;
/*     */ 
/*     */ public class FloorKillMonsterInSameRound
/*     */   extends AbstractGoalType
/*     */ {
/*     */   public int getType()
/*     */   {
/*  19 */     return 5117;
/*     */   }
/*     */   
/*     */ 
/*     */   public void initParams(AchievementInfo xAchievementInfo)
/*     */   {
/*  25 */     xAchievementInfo.getGoal_parameters().add(Integer.valueOf(0));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean updateState(long roleId, AchievementInfo xAchievementInfo, SAchievementGoalCfg sAchievementGoalCfg, Object ctx)
/*     */   {
/*  32 */     Context context = (Context)ctx;
/*     */     
/*  34 */     int goalActivityId = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(0)).parameter;
/*  35 */     int goalFloor = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(1)).parameter;
/*  36 */     if (((goalActivityId != 0) && (context.activityId != goalActivityId)) || ((goalFloor != 0) && (context.floor != goalFloor)))
/*     */     {
/*  38 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  42 */     List<Integer> goalMonsterIds = new ArrayList();
/*  43 */     for (int i = 3; i < sAchievementGoalCfg.goalParameters.size(); i++)
/*     */     {
/*  45 */       int param = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(i)).parameter;
/*  46 */       if (param > 0)
/*     */       {
/*  48 */         goalMonsterIds.add(Integer.valueOf(param));
/*     */       }
/*     */     }
/*  51 */     if (!context.dieInSameRound(goalMonsterIds))
/*     */     {
/*  53 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  57 */     int oldCount = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/*  58 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(oldCount + 1));
/*     */     
/*  60 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public static class Context
/*     */   {
/*     */     public final int activityId;
/*     */     
/*     */     public final int floor;
/*     */     
/*     */     private final Map<Integer, List<Integer>> monsterDeadInRound;
/*     */     
/*     */     public Context(int activityId, int floor, Map<Integer, List<Integer>> monsterDeadInRound)
/*     */     {
/*  74 */       this.activityId = activityId;
/*  75 */       this.floor = floor;
/*  76 */       this.monsterDeadInRound = monsterDeadInRound;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public boolean dieInSameRound(Collection<Integer> monsterIds)
/*     */     {
/*  89 */       Set<Integer> totalDieRoundSet = new HashSet();
/*     */       
/*     */ 
/*  92 */       for (Iterator i$ = monsterIds.iterator(); i$.hasNext();) { int monsterId = ((Integer)i$.next()).intValue();
/*     */         
/*  94 */         Collection<Integer> monsterDieRoundSet = (Collection)this.monsterDeadInRound.get(Integer.valueOf(monsterId));
/*     */         
/*  96 */         if ((null == monsterDieRoundSet) || (monsterDieRoundSet.size() == 0))
/*     */         {
/*  98 */           return false;
/*     */         }
/* 100 */         totalDieRoundSet.addAll(monsterDieRoundSet);
/*     */       }
/*     */       
/* 103 */       if (totalDieRoundSet.size() == 1)
/*     */       {
/* 105 */         return true;
/*     */       }
/*     */       
/*     */ 
/* 109 */       return false;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\FloorKillMonsterInSameRound.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
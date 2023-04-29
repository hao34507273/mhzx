/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collection;
/*    */ import java.util.Iterator;
/*    */ import java.util.LinkedList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.achievement.confbean.GoalParameter;
/*    */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*    */ import xbean.AchievementInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FightAccumulateKillMonster
/*    */   extends AbstractGoalType
/*    */ {
/*    */   public int getType()
/*    */   {
/* 23 */     return 5104;
/*    */   }
/*    */   
/*    */ 
/*    */   public void initParams(AchievementInfo xAchievementInfo)
/*    */   {
/* 29 */     xAchievementInfo.getGoal_parameters().add(Integer.valueOf(0));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean updateState(long roleId, AchievementInfo xAchievementInfo, SAchievementGoalCfg sAchievementGoalCfg, Object ctx)
/*    */   {
/* 37 */     List<Integer> goalMonsterCfgIds = new LinkedList();
/* 38 */     for (int i = 1; i < sAchievementGoalCfg.goalParameters.size(); i++)
/*    */     {
/* 40 */       GoalParameter parameter = (GoalParameter)sAchievementGoalCfg.goalParameters.get(i);
/* 41 */       if (parameter.parameter != 0)
/*    */       {
/* 43 */         goalMonsterCfgIds.add(Integer.valueOf(parameter.parameter));
/*    */       }
/*    */     }
/*    */     
/*    */ 
/* 48 */     Context context = (Context)ctx;
/* 49 */     int killTimes = context.getMonsterCount(goalMonsterCfgIds);
/* 50 */     if (killTimes == 0)
/*    */     {
/* 52 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 56 */     int targetTimes = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(0)).parameter;
/* 57 */     int oldTimes = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/* 58 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(Math.min(oldTimes + killTimes, targetTimes)));
/*    */     
/* 60 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public static class Context
/*    */   {
/*    */     private final Collection<Integer> monsterCfgIds;
/*    */     
/*    */ 
/*    */ 
/*    */     public Context(Collection<Integer> monsterCfgIds)
/*    */     {
/* 74 */       this.monsterCfgIds = monsterCfgIds;
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     public int getMonsterCount(Collection<Integer> goalMonsterCfgIds)
/*    */     {
/* 86 */       if (goalMonsterCfgIds.size() == 0)
/*    */       {
/* 88 */         return this.monsterCfgIds.size();
/*    */       }
/* 90 */       int res = 0;
/* 91 */       for (Iterator i$ = this.monsterCfgIds.iterator(); i$.hasNext();) { int monsterCfgId = ((Integer)i$.next()).intValue();
/*    */         
/* 93 */         if (goalMonsterCfgIds.contains(Integer.valueOf(monsterCfgId)))
/*    */         {
/* 95 */           res++;
/*    */         }
/*    */       }
/* 98 */       return res;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\FightAccumulateKillMonster.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collection;
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
/*    */ 
/*    */ 
/*    */ public class FightKillMonsterInRound
/*    */   extends AbstractGoalType
/*    */ {
/*    */   public int getType()
/*    */   {
/* 24 */     return 5114;
/*    */   }
/*    */   
/*    */ 
/*    */   public void initParams(AchievementInfo xAchievementInfo)
/*    */   {
/* 30 */     xAchievementInfo.getGoal_parameters().add(Integer.valueOf(0));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean updateState(long roleId, AchievementInfo xAchievementInfo, SAchievementGoalCfg sAchievementGoalCfg, Object ctx)
/*    */   {
/* 37 */     Context context = (Context)ctx;
/*    */     
/*    */ 
/* 40 */     int limitRound = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(1)).parameter;
/* 41 */     if (context.fightRound > limitRound)
/*    */     {
/* 43 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 47 */     List<Integer> goalMonsterCfgIds = new LinkedList();
/* 48 */     for (int i = 2; i < sAchievementGoalCfg.goalParameters.size(); i++)
/*    */     {
/* 50 */       GoalParameter parameter = (GoalParameter)sAchievementGoalCfg.goalParameters.get(i);
/* 51 */       if (parameter.parameter != 0)
/*    */       {
/* 53 */         goalMonsterCfgIds.add(Integer.valueOf(parameter.parameter));
/*    */       }
/*    */     }
/* 56 */     int killCount = context.getMonsterCount(goalMonsterCfgIds);
/* 57 */     if (killCount == 0)
/*    */     {
/* 59 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 63 */     int goalCount = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(0)).parameter;
/* 64 */     int oldCount = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/* 65 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(Math.min(goalCount, oldCount + killCount)));
/*    */     
/* 67 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   public static class Context
/*    */   {
/*    */     public final int fightRound;
/*    */     
/*    */     private final FightAccumulateKillMonster.Context context;
/*    */     
/*    */ 
/*    */     public Context(int fightRound, List<Integer> monsterCfgIds)
/*    */     {
/* 80 */       this.fightRound = fightRound;
/* 81 */       this.context = new FightAccumulateKillMonster.Context(monsterCfgIds);
/*    */     }
/*    */     
/*    */     public int getMonsterCount(Collection<Integer> goalMonsterCfgIds)
/*    */     {
/* 86 */       return this.context.getMonsterCount(goalMonsterCfgIds);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\FightKillMonsterInRound.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
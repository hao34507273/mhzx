/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Map;
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
/*    */ public class FightOneFightKillSpecificMonster
/*    */   extends AbstractGoalType
/*    */ {
/*    */   public int getType()
/*    */   {
/* 21 */     return 5137;
/*    */   }
/*    */   
/*    */ 
/*    */   public void initParams(AchievementInfo xAchievementInfo)
/*    */   {
/* 27 */     xAchievementInfo.getGoal_parameters().add(Integer.valueOf(0));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean updateState(long roleId, AchievementInfo xAchievementInfo, SAchievementGoalCfg sAchievementGoalCfg, Object ctx)
/*    */   {
/* 34 */     FightMonsterDeadRoundContext context = (FightMonsterDeadRoundContext)ctx;
/*    */     
/* 36 */     int targetFightCfgId = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(1)).parameter;
/* 37 */     if ((targetFightCfgId != context.fightCfgId) && (targetFightCfgId != 0))
/*    */     {
/* 39 */       return false;
/*    */     }
/*    */     
/* 42 */     int totalDieCount = 0;
/* 43 */     for (int i = 2; i < sAchievementGoalCfg.goalParameters.size(); i++)
/*    */     {
/* 45 */       int targetMonsterCfgId = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(i)).parameter;
/* 46 */       List<Integer> monsterDeadRounds = (List)context.mounsterCfgId2DeadRounds.get(Integer.valueOf(targetMonsterCfgId));
/* 47 */       if (null != monsterDeadRounds)
/*    */       {
/*    */ 
/*    */ 
/* 51 */         totalDieCount += monsterDeadRounds.size();
/*    */       }
/*    */     }
/* 54 */     int oldCount = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/* 55 */     if (oldCount >= totalDieCount)
/*    */     {
/* 57 */       return false;
/*    */     }
/* 59 */     int targetCount = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(0)).parameter;
/* 60 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(Math.min(targetCount, totalDieCount)));
/*    */     
/* 62 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\FightOneFightKillSpecificMonster.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
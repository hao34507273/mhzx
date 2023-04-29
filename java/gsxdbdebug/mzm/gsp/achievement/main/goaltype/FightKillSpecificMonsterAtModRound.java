/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collection;
/*    */ import java.util.Iterator;
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
/*    */ 
/*    */ public class FightKillSpecificMonsterAtModRound
/*    */   extends AbstractGoalType
/*    */ {
/*    */   public int getType()
/*    */   {
/* 24 */     return 5142;
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
/* 37 */     FightMonsterDeadRoundContext context = (FightMonsterDeadRoundContext)ctx;
/*    */     
/* 39 */     int targetFightCfgId = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(4)).parameter;
/* 40 */     if ((targetFightCfgId != context.fightCfgId) && (targetFightCfgId != 0))
/*    */     {
/* 42 */       return false;
/*    */     }
/*    */     
/* 45 */     int killNum = 0;
/* 46 */     int divisor = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(1)).parameter;
/* 47 */     int minRemainder = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(2)).parameter;
/* 48 */     int maxRemainder = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(3)).parameter;
/* 49 */     Iterator i$; for (int i = 5; i < sAchievementGoalCfg.goalParameters.size(); i++)
/*    */     {
/* 51 */       int goalMonsterCfgId = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(i)).parameter;
/* 52 */       if (goalMonsterCfgId != 0)
/*    */       {
/*    */ 
/*    */ 
/*    */ 
/* 57 */         Collection<Integer> deadRounds = (Collection)context.mounsterCfgId2DeadRounds.get(Integer.valueOf(goalMonsterCfgId));
/* 58 */         if (null != deadRounds)
/*    */         {
/*    */ 
/*    */ 
/*    */ 
/* 63 */           for (i$ = deadRounds.iterator(); i$.hasNext();) { int deadRound = ((Integer)i$.next()).intValue();
/*    */             
/* 65 */             if (isRoundMatch(deadRound, divisor, minRemainder, maxRemainder))
/*    */             {
/* 67 */               killNum++; }
/*    */           }
/*    */         }
/*    */       }
/*    */     }
/* 72 */     int oldKillNum = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/* 73 */     if (oldKillNum == killNum)
/*    */     {
/* 75 */       return false;
/*    */     }
/*    */     
/* 78 */     int targetKillNum = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(0)).parameter;
/* 79 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(Math.min(targetKillNum, killNum)));
/*    */     
/* 81 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private boolean isRoundMatch(int round, int divisor, int minRemainder, int maxRemainder)
/*    */   {
/* 96 */     int remainder = round % divisor;
/* 97 */     return (remainder >= minRemainder) && (remainder <= maxRemainder);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\FightKillSpecificMonsterAtModRound.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
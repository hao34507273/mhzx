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
/*    */ public class FightKillSpecificMonsterAtRound
/*    */   extends AbstractGoalType
/*    */ {
/*    */   public int getType()
/*    */   {
/* 22 */     return 5141;
/*    */   }
/*    */   
/*    */ 
/*    */   public void initParams(AchievementInfo xAchievementInfo)
/*    */   {
/* 28 */     xAchievementInfo.getGoal_parameters().add(Integer.valueOf(0));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean updateState(long roleId, AchievementInfo xAchievementInfo, SAchievementGoalCfg sAchievementGoalCfg, Object ctx)
/*    */   {
/* 35 */     FightMonsterDeadRoundContext context = (FightMonsterDeadRoundContext)ctx;
/*    */     
/* 37 */     int targetFightCfgId = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(2)).parameter;
/* 38 */     if ((targetFightCfgId != context.fightCfgId) && (targetFightCfgId != 0))
/*    */     {
/* 40 */       return false;
/*    */     }
/*    */     
/* 43 */     int killNum = 0;
/* 44 */     int targetDeadRound = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(1)).parameter;
/* 45 */     Iterator i$; for (int i = 3; i < sAchievementGoalCfg.goalParameters.size(); i++)
/*    */     {
/* 47 */       int goalMonsterCfgId = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(i)).parameter;
/* 48 */       if (goalMonsterCfgId != 0)
/*    */       {
/*    */ 
/*    */ 
/*    */ 
/* 53 */         Collection<Integer> deadRounds = (Collection)context.mounsterCfgId2DeadRounds.get(Integer.valueOf(goalMonsterCfgId));
/* 54 */         if (null != deadRounds)
/*    */         {
/*    */ 
/*    */ 
/*    */ 
/* 59 */           for (i$ = deadRounds.iterator(); i$.hasNext();) { int deadRound = ((Integer)i$.next()).intValue();
/*    */             
/* 61 */             if (deadRound == targetDeadRound)
/*    */             {
/* 63 */               killNum++; }
/*    */           }
/*    */         }
/*    */       }
/*    */     }
/* 68 */     int oldKillNum = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/* 69 */     if (oldKillNum == killNum)
/*    */     {
/* 71 */       return false;
/*    */     }
/*    */     
/* 74 */     int targetKillNum = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(0)).parameter;
/* 75 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(Math.min(targetKillNum, killNum)));
/*    */     
/* 77 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\FightKillSpecificMonsterAtRound.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
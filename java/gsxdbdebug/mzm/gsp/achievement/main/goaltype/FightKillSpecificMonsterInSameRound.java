/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collection;
/*    */ import java.util.HashMap;
/*    */ import java.util.HashSet;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.achievement.confbean.GoalParameter;
/*    */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*    */ import xbean.AchievementInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FightKillSpecificMonsterInSameRound
/*    */   extends AbstractGoalType
/*    */ {
/*    */   public int getType()
/*    */   {
/* 26 */     return 5136;
/*    */   }
/*    */   
/*    */ 
/*    */   public void initParams(AchievementInfo xAchievementInfo)
/*    */   {
/* 32 */     xAchievementInfo.getGoal_parameters().add(Integer.valueOf(0));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean updateState(long roleId, AchievementInfo xAchievementInfo, SAchievementGoalCfg sAchievementGoalCfg, Object ctx)
/*    */   {
/* 39 */     FightMonsterDeadRoundContext context = (FightMonsterDeadRoundContext)ctx;
/*    */     
/* 41 */     int targetFightCfgId = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(1)).parameter;
/* 42 */     if ((targetFightCfgId != context.fightCfgId) && (targetFightCfgId != 0))
/*    */     {
/* 44 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 48 */     Set<Integer> targetMonsterCfgIds = new HashSet();
/* 49 */     for (int i = 2; i < sAchievementGoalCfg.goalParameters.size(); i++)
/*    */     {
/* 51 */       int targetMonsterId = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(i)).parameter;
/* 52 */       if (targetMonsterId > 0)
/*    */       {
/* 54 */         targetMonsterCfgIds.add(Integer.valueOf(targetMonsterId));
/*    */       }
/*    */     }
/*    */     
/* 58 */     Map<Integer, Integer> round2KillNum = new HashMap();
/* 59 */     for (Map.Entry<Integer, List<Integer>> entry : context.mounsterCfgId2DeadRounds.entrySet())
/*    */     {
/* 61 */       if (targetMonsterCfgIds.contains(entry.getKey()))
/*    */       {
/* 63 */         for (i$ = ((List)entry.getValue()).iterator(); i$.hasNext();) { int dieRound = ((Integer)i$.next()).intValue();
/*    */           
/* 65 */           int newNum = null == round2KillNum.get(Integer.valueOf(dieRound)) ? 1 : ((Integer)round2KillNum.get(Integer.valueOf(dieRound))).intValue() + 1;
/* 66 */           round2KillNum.put(Integer.valueOf(dieRound), Integer.valueOf(newNum));
/*    */         }
/*    */       }
/*    */     }
/*    */     Iterator i$;
/* 71 */     int newNum = 0;
/* 72 */     for (Iterator i$ = round2KillNum.values().iterator(); i$.hasNext();) { int killNum = ((Integer)i$.next()).intValue();
/*    */       
/* 74 */       newNum = Math.max(killNum, newNum);
/*    */     }
/*    */     
/* 77 */     int oldNum = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/* 78 */     if (oldNum >= newNum)
/*    */     {
/* 80 */       return false;
/*    */     }
/* 82 */     int targetCount = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(0)).parameter;
/* 83 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(Math.min(targetCount, newNum)));
/*    */     
/* 85 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\FightKillSpecificMonsterInSameRound.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
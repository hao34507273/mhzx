/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collection;
/*    */ import java.util.Collections;
/*    */ import java.util.HashSet;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import java.util.Set;
/*    */ import java.util.TreeMap;
/*    */ import mzm.gsp.achievement.confbean.GoalParameter;
/*    */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*    */ import xbean.AchievementInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FightKillSpecificMonsterLast
/*    */   extends AbstractGoalType
/*    */ {
/*    */   public int getType()
/*    */   {
/* 25 */     return 5139;
/*    */   }
/*    */   
/*    */ 
/*    */   public void initParams(AchievementInfo xAchievementInfo)
/*    */   {
/* 31 */     xAchievementInfo.getGoal_parameters().add(Integer.valueOf(0));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean updateState(long roleId, AchievementInfo xAchievementInfo, SAchievementGoalCfg sAchievementGoalCfg, Object ctx)
/*    */   {
/* 38 */     FightMonsterDeadRoundContext context = (FightMonsterDeadRoundContext)ctx;
/*    */     
/* 40 */     int targetFightCfgId = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(1)).parameter;
/* 41 */     if ((targetFightCfgId != context.fightCfgId) && (targetFightCfgId != 0))
/*    */     {
/* 43 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 47 */     TreeMap<Integer, Set<Integer>> deadRound2MonsterCfgIds = new TreeMap();
/* 48 */     for (Map.Entry<Integer, List<Integer>> entry : context.mounsterCfgId2DeadRounds.entrySet())
/*    */     {
/* 50 */       monsterCfgId = ((Integer)entry.getKey()).intValue();
/* 51 */       for (i$ = ((List)entry.getValue()).iterator(); i$.hasNext();) { int round = ((Integer)i$.next()).intValue();
/*    */         
/* 53 */         Set<Integer> monsterCfgIds = (Set)deadRound2MonsterCfgIds.get(Integer.valueOf(round));
/* 54 */         if (null == monsterCfgIds)
/*    */         {
/* 56 */           monsterCfgIds = new HashSet();
/* 57 */           deadRound2MonsterCfgIds.put(Integer.valueOf(round), monsterCfgIds);
/*    */         }
/* 59 */         monsterCfgIds.add(Integer.valueOf(monsterCfgId));
/*    */       }
/*    */     }
/*    */     int monsterCfgId;
/*    */     Iterator i$;
/* 64 */     Set<Integer> targetMonsterCfgIds = new HashSet();
/* 65 */     for (int i = 2; i < sAchievementGoalCfg.goalParameters.size(); i++)
/*    */     {
/* 67 */       int targetMonsterId = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(i)).parameter;
/* 68 */       if (targetMonsterId > 0)
/*    */       {
/* 70 */         targetMonsterCfgIds.add(Integer.valueOf(targetMonsterId));
/*    */       }
/*    */     }
/*    */     
/*    */ 
/* 75 */     boolean killedTargetMonster = false;
/* 76 */     for (Map.Entry<Integer, Set<Integer>> entry : deadRound2MonsterCfgIds.entrySet())
/*    */     {
/* 78 */       if (!Collections.disjoint((Collection)entry.getValue(), targetMonsterCfgIds))
/*    */       {
/* 80 */         killedTargetMonster = true;
/*    */       }
/*    */       
/* 83 */       if ((killedTargetMonster) && (!targetMonsterCfgIds.containsAll((Collection)entry.getValue())))
/*    */       {
/* 85 */         return false;
/*    */       }
/*    */     }
/*    */     
/*    */ 
/* 90 */     int oldNum = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/* 91 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(oldNum + 1));
/*    */     
/* 93 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\FightKillSpecificMonsterLast.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
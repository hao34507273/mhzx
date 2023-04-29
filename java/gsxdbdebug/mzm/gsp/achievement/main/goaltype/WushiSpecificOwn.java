/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collection;
/*    */ import java.util.Iterator;
/*    */ import java.util.LinkedList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.achievement.confbean.GoalParameter;
/*    */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*    */ import mzm.gsp.superequipment.wushi.confbean.WuShiCfg;
/*    */ import mzm.gsp.superequipment.wushi.main.WuShiInterface;
/*    */ import xbean.AchievementInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WushiSpecificOwn
/*    */   extends AbstractGoalType
/*    */ {
/*    */   public int getType()
/*    */   {
/* 24 */     return 3015;
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
/*    */   public boolean updateState(long roleId, AchievementInfo xAchievementInfo, SAchievementGoalCfg sAchievementGoalCfg, Object context)
/*    */   {
/* 37 */     Collection<Integer> ownWushiCfgIds = WuShiInterface.getRoleActivatedWuShiCfgIds(roleId, true);
/* 38 */     Collection<Integer> ownWushiTypes = new LinkedList();
/* 39 */     for (Iterator i$ = ownWushiCfgIds.iterator(); i$.hasNext();) { int ownWushiCfgId = ((Integer)i$.next()).intValue();
/*    */       
/* 41 */       ownWushiTypes.add(Integer.valueOf(WuShiCfg.get(ownWushiCfgId).typeId));
/*    */     }
/* 43 */     int newNum = 0;
/* 44 */     int targetWushiTypeId; Iterator i$; for (int i = 1; i < sAchievementGoalCfg.goalParameters.size(); i++)
/*    */     {
/* 46 */       int targetWushiCfgId = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(i)).parameter;
/* 47 */       if (targetWushiCfgId == 0) {
/*    */         break;
/*    */       }
/*    */       
/* 51 */       targetWushiTypeId = WuShiCfg.get(targetWushiCfgId).typeId;
/* 52 */       for (i$ = ownWushiTypes.iterator(); i$.hasNext();) { int typeId = ((Integer)i$.next()).intValue();
/*    */         
/* 54 */         if (typeId == targetWushiTypeId)
/*    */         {
/* 56 */           newNum++;
/*    */         }
/*    */       }
/*    */     }
/*    */     
/* 61 */     int oldNum = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/* 62 */     if (newNum == oldNum)
/*    */     {
/* 64 */       return false;
/*    */     }
/*    */     
/* 67 */     int goalNum = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(0)).parameter;
/* 68 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(Math.min(goalNum, newNum)));
/* 69 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean innerCheckGoalState(long roleId, SAchievementGoalCfg sAchievementGoalCfg, AchievementInfo xAchievementInfo, List<Integer> goalParameters)
/*    */   {
/* 75 */     return updateState(roleId, xAchievementInfo, sAchievementGoalCfg, null);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\WushiSpecificOwn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
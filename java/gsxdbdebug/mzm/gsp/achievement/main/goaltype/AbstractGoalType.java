/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*    */ import mzm.gsp.achievement.confbean.SAchievementGoalParameterCfg;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.AchievementInfo;
/*    */ import xbean.ActivityAchievementInfo;
/*    */ import xbean.Pod;
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
/*    */ public abstract class AbstractGoalType
/*    */   implements IGoalType
/*    */ {
/*    */   protected boolean innerCheckGoalState(long roleId, SAchievementGoalCfg sAchievementGoalCfg, AchievementInfo xAchievementInfo, List<Integer> goalParameters)
/*    */   {
/* 28 */     return false;
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
/*    */   public final boolean correctState(long roleId, SAchievementGoalCfg sAchievementGoalCfg, ActivityAchievementInfo xActivityAchievementInfo)
/*    */   {
/* 43 */     int goalCfgId = sAchievementGoalCfg.id;
/* 44 */     SAchievementGoalParameterCfg sAchievementGoalParameterCfg = SAchievementGoalParameterCfg.get(goalCfgId);
/* 45 */     if (sAchievementGoalParameterCfg == null)
/*    */     {
/* 47 */       return false;
/*    */     }
/* 49 */     List<Integer> goalParameters = sAchievementGoalParameterCfg.parameterList;
/* 50 */     AchievementInfo xAchievementInfo = (AchievementInfo)xActivityAchievementInfo.getGoal_info().get(Integer.valueOf(goalCfgId));
/*    */     
/* 52 */     if ((null == xAchievementInfo) || (xAchievementInfo.getGoal_parameters().isEmpty()))
/*    */     {
/* 54 */       xAchievementInfo = Pod.newAchievementInfo();
/* 55 */       xAchievementInfo.setGoal_state(1);
/*    */       
/* 57 */       initParams(xAchievementInfo);
/* 58 */       xActivityAchievementInfo.getGoal_info().put(Integer.valueOf(goalCfgId), xAchievementInfo);
/*    */ 
/*    */     }
/* 61 */     else if (xAchievementInfo.getGoal_state() != 1)
/*    */     {
/* 63 */       return false;
/*    */     }
/*    */     
/*    */     boolean result;
/*    */     try
/*    */     {
/* 69 */       result = innerCheckGoalState(roleId, sAchievementGoalCfg, xAchievementInfo, goalParameters);
/*    */     }
/*    */     catch (RuntimeException e)
/*    */     {
/* 73 */       GameServer.logger().warn(String.format("[achievement]AbstractGoalType.correctState@achievement inner check exception, e=%s,goalCfgId=%d,xAchievementInfo=%s,roleId=%d", new Object[] { e, Integer.valueOf(sAchievementGoalCfg.id), xAchievementInfo, Long.valueOf(roleId) }));
/*    */       
/*    */ 
/*    */ 
/*    */ 
/* 78 */       xAchievementInfo = Pod.newAchievementInfo();
/* 79 */       xAchievementInfo.setGoal_state(1);
/* 80 */       initParams(xAchievementInfo);
/* 81 */       xActivityAchievementInfo.getGoal_info().put(Integer.valueOf(goalCfgId), xAchievementInfo);
/* 82 */       result = innerCheckGoalState(roleId, sAchievementGoalCfg, xAchievementInfo, goalParameters);
/*    */     }
/* 84 */     return result;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\AbstractGoalType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
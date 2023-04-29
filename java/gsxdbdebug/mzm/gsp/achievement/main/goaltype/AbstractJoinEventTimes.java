/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*    */ import xbean.AchievementInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class AbstractJoinEventTimes
/*    */   extends AbstractGoalType
/*    */ {
/*    */   public void initParams(AchievementInfo xAchievementInfo)
/*    */   {
/* 17 */     xAchievementInfo.getGoal_parameters().add(Integer.valueOf(0));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean updateState(long roleId, AchievementInfo xAchievementInfo, SAchievementGoalCfg sAchievementGoalCfg, Object ctx)
/*    */   {
/* 24 */     Context context = (Context)ctx;
/*    */     
/* 26 */     Map<Long, String> xGoalParameterMap = xAchievementInfo.getGoal_parameters_extra();
/* 27 */     String eventJoinTimeStr = String.valueOf(context.eventJoinTime);
/* 28 */     String lastEventJoinTime = (String)xGoalParameterMap.get(Long.valueOf(context.instanceCfgId));
/* 29 */     if ((lastEventJoinTime != null) && (lastEventJoinTime.equals(eventJoinTimeStr)))
/*    */     {
/* 31 */       return false;
/*    */     }
/*    */     
/* 34 */     xGoalParameterMap.put(Long.valueOf(context.instanceCfgId), eventJoinTimeStr);
/* 35 */     int oldFinishTimes = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/* 36 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(oldFinishTimes + 1));
/*    */     
/* 38 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   public static class Context
/*    */   {
/*    */     public final long eventJoinTime;
/*    */     
/*    */     public final int instanceCfgId;
/*    */     
/*    */ 
/*    */     public Context(long eventJoinTime, int instanceCfgId)
/*    */     {
/* 51 */       this.eventJoinTime = eventJoinTime;
/* 52 */       this.instanceCfgId = instanceCfgId;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\AbstractJoinEventTimes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.activity.main.ActivityJoinResult;
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import xbean.ActivityAchievementInfo;
/*    */ import xbean.Role2AchievementInfo;
/*    */ import xtable.Role2achievement;
/*    */ 
/*    */ public class POnRoleLogin extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 15 */     long roleId = ((Long)this.arg).longValue();
/* 16 */     String userId = mzm.gsp.role.main.RoleInterface.getUserId(roleId);
/* 17 */     AchievementManager.collectLocksToCorrectAchievement(roleId);
/*    */     
/*    */ 
/* 20 */     Role2AchievementInfo xRole2AchievementInfo = Role2achievement.get(Long.valueOf(roleId));
/*    */     
/*    */ 
/* 23 */     if (null == xRole2AchievementInfo)
/*    */     {
/* 25 */       xRole2AchievementInfo = xbean.Pod.newRole2AchievementInfo();
/* 26 */       Role2achievement.insert(Long.valueOf(roleId), xRole2AchievementInfo);
/*    */     }
/*    */     
/* 29 */     DouDouSongLiActivityHandler.DouDouSongLiFixServerOpen(roleId, xRole2AchievementInfo);
/*    */     
/*    */ 
/* 32 */     AchievementHandler.fixAchievement(roleId, xRole2AchievementInfo);
/*    */     
/*    */ 
/* 35 */     boolean statusValid = AchievementManager.checkMutexStatus(roleId, false, true);
/*    */     
/* 37 */     for (Map.Entry<Integer, ActivityAchievementInfo> xActivityEntry : xRole2AchievementInfo.getActivity_achievement_info().entrySet())
/*    */     {
/* 39 */       int activityId = ((Integer)xActivityEntry.getKey()).intValue();
/*    */       
/*    */ 
/* 42 */       boolean switchOpen = AchievementManager.isAchievementSwitchOpen(roleId, activityId, "POnRoleLogin.processImp");
/*    */       
/* 44 */       ActivityAchievementInfo xActivityAchievementInfo = (ActivityAchievementInfo)xActivityEntry.getValue();
/* 45 */       ActivityJoinResult activityJoinResult = mzm.gsp.activity.main.ActivityInterface.canJoinAndCheckInitActivityData(userId, roleId, activityId);
/*    */       
/* 47 */       if ((switchOpen) && (activityJoinResult.isCanJoin()) && (statusValid))
/*    */       {
/* 49 */         AchievementManager.correctAchievementGoalStateOnLogin(roleId, activityId, xActivityAchievementInfo);
/*    */       }
/*    */       
/* 52 */       if (AchievementManager.isNeedSync(roleId, activityId, xActivityAchievementInfo))
/*    */       {
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 58 */         AchievementManager.synAchievementInfo(roleId, activityId, xActivityAchievementInfo);
/*    */       }
/*    */     }
/* 61 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
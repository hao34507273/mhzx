/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*    */ import mzm.gsp.friend.main.FriendInterface;
/*    */ import xbean.AchievementInfo;
/*    */ 
/*    */ public class ReachFriendPointCount
/*    */   extends AbstractDoneOneEventLevelTimes
/*    */ {
/*    */   public int getType()
/*    */   {
/* 15 */     return 310;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected boolean innerCheckGoalState(long roleId, SAchievementGoalCfg sAchievementGoalCfg, AchievementInfo xAchievementInfo, List<Integer> goalParameters)
/*    */   {
/* 22 */     int goalFriendPoint = ((Integer)goalParameters.get(1)).intValue();
/* 23 */     Map<Long, String> paramExtra = xAchievementInfo.getGoal_parameters_extra();
/* 24 */     paramExtra.clear();
/* 25 */     List<Long> friendIds = FriendInterface.getAllFriends(roleId, true);
/* 26 */     int maxFriendPoint = 0;
/* 27 */     for (Iterator i$ = friendIds.iterator(); i$.hasNext();) { long friendId = ((Long)i$.next()).longValue();
/*    */       
/* 29 */       int friendPoint = FriendInterface.getRelationValue(roleId, friendId, true);
/* 30 */       maxFriendPoint = Math.max(maxFriendPoint, friendPoint);
/* 31 */       if (friendPoint >= goalFriendPoint)
/*    */       {
/* 33 */         paramExtra.put(Long.valueOf(friendId), String.valueOf(friendId));
/*    */       }
/*    */       else
/*    */       {
/* 37 */         paramExtra.remove(Long.valueOf(friendId));
/*    */       }
/*    */     }
/*    */     
/*    */ 
/* 42 */     int goalFriendNum = ((Integer)goalParameters.get(0)).intValue();
/* 43 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(Math.min(paramExtra.size(), goalFriendNum)));
/* 44 */     xAchievementInfo.getGoal_parameters().set(1, Integer.valueOf(Math.min(goalFriendPoint, maxFriendPoint)));
/*    */     
/* 46 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\ReachFriendPointCount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
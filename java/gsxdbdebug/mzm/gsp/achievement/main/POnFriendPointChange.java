/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.friend.event.FriendPointChangeArg;
/*    */ import mzm.gsp.friend.event.FriendPointChangeProcedure;
/*    */ import mzm.gsp.marriage.main.MarriageInterface;
/*    */ 
/*    */ 
/*    */ public class POnFriendPointChange
/*    */   extends FriendPointChangeProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */   {
/* 14 */     AchievementManager.collectLocks(Arrays.asList(new Long[] { Long.valueOf(((FriendPointChangeArg)this.arg).roleid1), Long.valueOf(((FriendPointChangeArg)this.arg).roleid2) }));
/*    */     
/*    */ 
/* 17 */     if (MarriageInterface.isMarriageRelation(((FriendPointChangeArg)this.arg).roleid1, ((FriendPointChangeArg)this.arg).roleid2))
/*    */     {
/* 19 */       AchievementManager.updateGoalTypeState(((FriendPointChangeArg)this.arg).roleid1, 309, Integer.valueOf(((FriendPointChangeArg)this.arg).totalPoint), "POnFriendPointChange.processImp@handle MARRY_FRIEND_POINT finish");
/*    */       
/* 21 */       AchievementManager.updateGoalTypeState(((FriendPointChangeArg)this.arg).roleid2, 309, Integer.valueOf(((FriendPointChangeArg)this.arg).totalPoint), "POnFriendPointChange.processImp@handle MARRY_FRIEND_POINT finish");
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 26 */     AchievementManager.updateGoalTypeState(((FriendPointChangeArg)this.arg).roleid1, 310, Integer.valueOf(((FriendPointChangeArg)this.arg).totalPoint), "POnFriendPointChange.processImp@handle REACH_FRIEND_POINT_COUNT finish");
/*    */     
/* 28 */     AchievementManager.updateGoalTypeState(((FriendPointChangeArg)this.arg).roleid2, 310, Integer.valueOf(((FriendPointChangeArg)this.arg).totalPoint), "POnFriendPointChange.processImp@handle REACH_FRIEND_POINT_COUNT finish");
/*    */     
/*    */ 
/* 31 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnFriendPointChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
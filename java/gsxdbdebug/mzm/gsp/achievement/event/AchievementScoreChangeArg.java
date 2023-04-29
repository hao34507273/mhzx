/*    */ package mzm.gsp.achievement.event;
/*    */ 
/*    */ public class AchievementScoreChangeArg
/*    */ {
/*    */   public final long roleId;
/*    */   public final int activityId;
/*    */   public final int nowScore;
/*    */   
/*    */   public AchievementScoreChangeArg(long roleId, int activityId, int nowScore)
/*    */   {
/* 11 */     this.roleId = roleId;
/* 12 */     this.activityId = activityId;
/* 13 */     this.nowScore = nowScore;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\event\AchievementScoreChangeArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
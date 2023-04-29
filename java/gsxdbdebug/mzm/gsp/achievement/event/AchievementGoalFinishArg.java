/*    */ package mzm.gsp.achievement.event;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AchievementGoalFinishArg
/*    */ {
/*    */   public final long roleId;
/*    */   
/*    */ 
/*    */ 
/*    */   public final int activityCfgId;
/*    */   
/*    */ 
/*    */ 
/*    */   public final int goalCfgId;
/*    */   
/*    */ 
/*    */ 
/*    */   public AchievementGoalFinishArg(long roleId, int activityCfgId, int goalCfgId)
/*    */   {
/* 22 */     this.roleId = roleId;
/* 23 */     this.activityCfgId = activityCfgId;
/* 24 */     this.goalCfgId = goalCfgId;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\event\AchievementGoalFinishArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
/*    */ package mzm.gsp.achievement.event;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AchievementMailAwardArg
/*    */ {
/*    */   public long roleId;
/*    */   
/*    */ 
/*    */ 
/*    */   public long leftTime;
/*    */   
/*    */ 
/*    */   public int activityCfgId;
/*    */   
/*    */ 
/*    */   public int mailCfgId;
/*    */   
/*    */ 
/*    */ 
/*    */   public AchievementMailAwardArg(long roleId, long leftTime, int activityCfgId, int mailCfgId)
/*    */   {
/* 24 */     this.roleId = roleId;
/* 25 */     this.leftTime = leftTime;
/* 26 */     this.activityCfgId = activityCfgId;
/* 27 */     this.mailCfgId = mailCfgId;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\event\AchievementMailAwardArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
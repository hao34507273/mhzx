/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.online.event.PlayerOfflineProcedure;
/*    */ import xbean.Role2AchievementObserver;
/*    */ import xtable.Role2achievementobserver;
/*    */ 
/*    */ public class POnRoleLogoff extends PlayerOfflineProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 12 */     Role2AchievementObserver xRole2AchievementObserver = Role2achievementobserver.get((Long)this.arg);
/* 13 */     if (xRole2AchievementObserver != null)
/*    */     {
/* 15 */       for (Map.Entry<Integer, PAchievementActivityFinishMailAward.AchievementAwardMailObserver> entry : xRole2AchievementObserver.getObserver_map().entrySet())
/*    */       {
/* 17 */         ((PAchievementActivityFinishMailAward.AchievementAwardMailObserver)entry.getValue()).stopTimer();
/*    */       }
/* 19 */       Role2achievementobserver.remove((Long)this.arg);
/*    */     }
/*    */     
/*    */ 
/* 23 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnRoleLogoff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
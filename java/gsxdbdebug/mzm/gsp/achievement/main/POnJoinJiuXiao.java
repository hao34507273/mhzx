/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import mzm.gsp.jiuxiao.event.JoinJiuXiaoArg;
/*    */ 
/*    */ public class POnJoinJiuXiao extends mzm.gsp.jiuxiao.event.JoinJiuXiaoEventProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 10 */     if (((JoinJiuXiaoArg)this.arg).floor <= 0)
/*    */     {
/* 12 */       return true;
/*    */     }
/*    */     
/* 15 */     AchievementManager.collectLocks(((JoinJiuXiaoArg)this.arg).joinRoles);
/*    */     
/* 17 */     for (Iterator i$ = ((JoinJiuXiaoArg)this.arg).joinRoles.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */       
/*    */ 
/* 20 */       AchievementManager.updateGoalTypeState(roleId, 2401, Integer.valueOf(((JoinJiuXiaoArg)this.arg).activityid), "POnJoinJiuXiao.processImp@handle ACTIVITY_JOIN_ONLY success");
/*    */     }
/*    */     
/*    */ 
/* 24 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnJoinJiuXiao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
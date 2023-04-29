/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.watchmoon.confbean.SWatchmoonConsts;
/*    */ import mzm.gsp.watchmoon.event.WatchMoonFinishArg;
/*    */ import mzm.gsp.watchmoon.event.WatchMoonFinishEventProcedure;
/*    */ 
/*    */ public class POnWatchMoonActivityFinish extends WatchMoonFinishEventProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     AchievementManager.collectLocks(((WatchMoonFinishArg)this.arg).roleList);
/*    */     
/* 15 */     for (Iterator i$ = ((WatchMoonFinishArg)this.arg).roleList.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */       
/*    */ 
/* 18 */       AchievementManager.updateGoalTypeState(roleId, 2400, Integer.valueOf(SWatchmoonConsts.getInstance().ACTIVITY_ID), "POnWatchMoonActivityFinish.processImp@handle ACTIVITY_JOIN finish");
/*    */     }
/*    */     
/*    */ 
/* 22 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnWatchMoonActivityFinish.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
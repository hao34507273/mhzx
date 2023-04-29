/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import mzm.gsp.zhenyao.event.ZhenyaoActivityArg;
/*    */ import mzm.gsp.zhenyao.event.ZhenyaoActivityFinishedProcedure;
/*    */ 
/*    */ public class POnZhenyaoActivityFinish extends ZhenyaoActivityFinishedProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     AchievementManager.collectLocks(((ZhenyaoActivityArg)this.arg).getRoleids());
/*    */     
/*    */ 
/* 14 */     for (Iterator i$ = ((ZhenyaoActivityArg)this.arg).getRoleids().iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */       
/* 16 */       AchievementManager.updateGoalTypeState(roleId, 2400, Integer.valueOf(((ZhenyaoActivityArg)this.arg).getActivityId()), "POnWatchMoonActivityFinish.processImp@handle ACTIVITY_JOIN finish");
/*    */     }
/*    */     
/*    */ 
/* 20 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnZhenyaoActivityFinish.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
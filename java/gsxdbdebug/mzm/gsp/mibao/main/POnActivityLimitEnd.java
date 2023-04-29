/*    */ package mzm.gsp.mibao.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.activity.event.ActivityLimitTimeEndArg;
/*    */ import mzm.gsp.activity.event.ActivityLimitTimeEndProcedure;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.mibao.confbean.BaoKuConsts;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ 
/*    */ public class POnActivityLimitEnd extends ActivityLimitTimeEndProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 16 */     int activityCfgId = ((ActivityLimitTimeEndArg)this.arg).activityid;
/*    */     
/* 18 */     if (activityCfgId != BaoKuConsts.getInstance().miBaoActivityId)
/*    */     {
/* 20 */       return false;
/*    */     }
/* 22 */     long nowActivityLimitBeginTime = ActivityInterface.getActivityLimitTimeBegin(activityCfgId);
/* 23 */     long nowActivityLimitEndTime = ActivityInterface.getActivityLimitTimeEnd(activityCfgId);
/*    */     
/* 25 */     List<Long> roleIdList = OnlineManager.getInstance().getAllRolesInWorld();
/* 26 */     for (Iterator i$ = roleIdList.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */       
/* 28 */       NoneRealTimeTaskManager.getInstance().addTask(new PExchangeScoreWhenActivityEnd(roleId, nowActivityLimitBeginTime, nowActivityLimitEndTime));
/*    */     }
/*    */     
/* 31 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mibao\main\POnActivityLimitEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
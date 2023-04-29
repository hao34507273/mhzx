/*    */ package mzm.gsp.instance.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ 
/*    */ public class POnActivityPause extends mzm.gsp.activity.event.ActivityPauseProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/*    */     Iterator i$;
/*    */     Iterator i$;
/* 11 */     if (((mzm.gsp.activity.event.ActivityPauseArg)this.arg).activityid == mzm.gsp.instance.confbean.SInstanceConsts.getInstance().SINGLE_INSTANCE_ACTIVITY_TYPE_ID) {
/* 12 */       for (i$ = mzm.gsp.online.main.OnlineManager.getInstance().getAllRolesInWorld().iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 13 */         mzm.gsp.util.NoneRealTimeTaskManager.getInstance().addTask(new LeaveSingleInstanceLogicProcedure(roleid));
/*    */       }
/*    */     } else {
/* 16 */       int instanceCfgid = InstanceCfgManager.getOperaInstanceCfgIdByActivityid(((mzm.gsp.activity.event.ActivityPauseArg)this.arg).activityid);
/* 17 */       if (instanceCfgid <= 0) {
/* 18 */         return false;
/*    */       }
/* 20 */       for (i$ = mzm.gsp.online.main.OnlineManager.getInstance().getAllRolesInWorld().iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 21 */         mzm.gsp.util.NoneRealTimeTaskManager.getInstance().addTask(new LeaveTeamInstanceLogicProcedure(roleid, ((mzm.gsp.activity.event.ActivityPauseArg)this.arg).activityid));
/*    */       }
/*    */     }
/*    */     
/* 25 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\instance\main\POnActivityPause.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
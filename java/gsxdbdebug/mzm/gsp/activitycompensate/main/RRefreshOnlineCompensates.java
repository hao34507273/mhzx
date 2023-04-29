/*    */ package mzm.gsp.activitycompensate.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class RRefreshOnlineCompensates
/*    */   extends LogicRunnable
/*    */ {
/*    */   public void process()
/*    */     throws Exception
/*    */   {
/* 19 */     List<Long> roleList = OnlineManager.getInstance().getAllRolesInWorld();
/* 20 */     for (Iterator i$ = roleList.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 21 */       new RRefreshRoleCompensates(roleid).run();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activitycompensate\main\RRefreshOnlineCompensates.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
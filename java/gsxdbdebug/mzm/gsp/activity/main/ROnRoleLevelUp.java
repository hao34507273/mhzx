/*    */ package mzm.gsp.activity.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.role.event.RoleLevelUpArg;
/*    */ import xbean.ActivityGlobalBean;
/*    */ import xbean.OpenBeanStore;
/*    */ 
/*    */ public class ROnRoleLevelUp extends mzm.gsp.role.event.RoleLevelUpRunnable
/*    */ {
/*    */   public void process() throws Exception
/*    */   {
/* 16 */     ActivityGlobalBean xActivityGlobalBean = xtable.Activity.select(Long.valueOf(mzm.gsp.GameServerInfoManager.getLocalId()));
/* 17 */     if (xActivityGlobalBean == null) {
/* 18 */       return;
/*    */     }
/*    */     
/* 21 */     long roleId = ((RoleLevelUpArg)this.arg).roleId;
/* 22 */     String userid = mzm.gsp.role.main.RoleInterface.getUserId(roleId);
/* 23 */     List<xbean.Activity> xActivities = new java.util.ArrayList();
/*    */     
/*    */ 
/* 26 */     xbean.Activity xActivity = xtable.User2activity.select(userid);
/* 27 */     if (xActivity == null) {
/* 28 */       xActivity = xbean.Pod.newActivityData();
/*    */     }
/* 30 */     xActivities.add(xActivity);
/*    */     
/*    */ 
/*    */ 
/* 34 */     xbean.Activity xActivity = xtable.Role2activity.select(Long.valueOf(roleId));
/* 35 */     if (xActivity == null) {
/* 36 */       xActivity = xbean.Pod.newActivityData();
/*    */     }
/* 38 */     xActivities.add(xActivity);
/*    */     
/*    */ 
/* 41 */     long curTime = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/* 42 */     for (xbean.Activity xActivity : xActivities)
/*    */     {
/* 44 */       Set<Integer> initActivityids = new java.util.HashSet();
/*    */       
/* 46 */       for (Map.Entry<Integer, OpenBeanStore> activityBeanEntry : xActivityGlobalBean.getActivityopenmap().entrySet()) {
/* 47 */         int activityid = ((Integer)activityBeanEntry.getKey()).intValue();
/* 48 */         OpenBeanStore xOpenBeanStore = (OpenBeanStore)activityBeanEntry.getValue();
/*    */         
/* 50 */         if ((!xActivity.getActivitymap().containsKey(Integer.valueOf(activityid))) && 
/* 51 */           (curTime < xOpenBeanStore.getEndtime()) && (ActivityManager.isInActivityLevel(userid, roleId, activityid))) {
/* 52 */           initActivityids.add(Integer.valueOf(activityid));
/*    */         }
/*    */       }
/*    */       
/* 56 */       for (i$ = initActivityids.iterator(); i$.hasNext();) { int activityid = ((Integer)i$.next()).intValue();
/* 57 */         new ActivityInitProcedure(activityid, userid, roleId).call();
/*    */       }
/*    */     }
/*    */     Iterator i$;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\main\ROnRoleLevelUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
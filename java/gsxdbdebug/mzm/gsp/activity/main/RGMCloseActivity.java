/*    */ package mzm.gsp.activity.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ import xbean.ActivityGlobalBean;
/*    */ import xbean.OpenBeanStore;
/*    */ import xtable.Activity;
/*    */ 
/*    */ public class RGMCloseActivity extends mzm.gsp.util.LogicRunnable
/*    */ {
/*    */   private int activityId;
/*    */   
/*    */   public RGMCloseActivity(int activityId)
/*    */   {
/* 16 */     this.activityId = activityId;
/*    */   }
/*    */   
/*    */   public void process() throws Exception
/*    */   {
/* 21 */     ActivityManager.onActivityEnd(this.activityId);
/* 22 */     NoneRealTimeTaskManager.getInstance().addTask(new mzm.gsp.util.LogicProcedure()
/*    */     {
/*    */       protected boolean processImp() throws Exception {
/* 25 */         ActivityGlobalBean xActivityGlobalBean = Activity.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 26 */         if (xActivityGlobalBean != null) {
/* 27 */           OpenBeanStore xOpenBeanStore = (OpenBeanStore)xActivityGlobalBean.getActivityopenmap().get(Integer.valueOf(RGMCloseActivity.this.activityId));
/* 28 */           if (xOpenBeanStore != null) {
/* 29 */             xOpenBeanStore.setEndtime(mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis());
/*    */           }
/*    */         }
/* 32 */         return true;
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\main\RGMCloseActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
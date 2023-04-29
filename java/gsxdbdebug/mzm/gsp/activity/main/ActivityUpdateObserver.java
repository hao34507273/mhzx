/*    */ package mzm.gsp.activity.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import xbean.OpenBeanStore;
/*    */ import xbean.StageBean;
/*    */ 
/*    */ class ActivityUpdateObserver extends mzm.gsp.timer.main.Observer
/*    */ {
/*    */   public ActivityUpdateObserver(long intervalSeconds)
/*    */   {
/* 12 */     super(intervalSeconds);
/*    */   }
/*    */   
/*    */   public boolean update()
/*    */   {
/* 17 */     xdb.Procedure.execute(new mzm.gsp.util.LogicProcedure()
/*    */     {
/*    */       protected boolean processImp() throws Exception
/*    */       {
/* 21 */         xbean.ActivityGlobalBean xActivityGlobalBean = xtable.Activity.get(Long.valueOf(mzm.gsp.GameServerInfoManager.getLocalId()));
/* 22 */         long curTime; if (xActivityGlobalBean != null) {
/* 23 */           curTime = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/* 24 */           for (Map.Entry<Integer, OpenBeanStore> entry : xActivityGlobalBean.getActivityopenmap().entrySet())
/*    */           {
/* 26 */             OpenBeanStore xOpenBeanStore = (OpenBeanStore)entry.getValue();
/* 27 */             if (curTime < xOpenBeanStore.getEndtime()) {
/* 28 */               xOpenBeanStore.setActivityduration(xOpenBeanStore.getActivityduration() + 20);
/*    */               
/* 30 */               for (Map.Entry<Integer, StageBean> stageEntry : xOpenBeanStore.getStagemap().entrySet())
/*    */               {
/* 32 */                 StageBean xStageBean = (StageBean)stageEntry.getValue();
/* 33 */                 xStageBean.setDuration(xStageBean.getDuration() + 20);
/*    */               }
/*    */             }
/*    */           }
/*    */         }
/*    */         
/* 39 */         return true;
/*    */       }
/* 41 */     });
/* 42 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\main\ActivityUpdateObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
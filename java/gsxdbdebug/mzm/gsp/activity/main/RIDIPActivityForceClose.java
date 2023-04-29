/*    */ package mzm.gsp.activity.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.activity.SynActivitySpecialControlChangeRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.ActivityGlobalBean;
/*    */ import xbean.OpenBeanStore;
/*    */ import xdb.Executor;
/*    */ 
/*    */ public class RIDIPActivityForceClose extends mzm.gsp.util.LogicRunnable
/*    */ {
/*    */   private final int activityid;
/*    */   private final boolean doOrRecovery;
/* 16 */   private ActivityForIDIPResult activityForIDIPResult = ActivityForIDIPResult.UNKNOWN_ERROR;
/*    */   
/*    */   public RIDIPActivityForceClose(int activityid, boolean doOrRecovery) {
/* 19 */     this.activityid = activityid;
/* 20 */     this.doOrRecovery = doOrRecovery;
/*    */   }
/*    */   
/*    */   public ActivityForIDIPResult getResult() {
/* 24 */     return this.activityForIDIPResult;
/*    */   }
/*    */   
/*    */   public void process() throws Exception
/*    */   {
/*    */     try
/*    */     {
/* 31 */       if (this.doOrRecovery) {
/* 32 */         ActivityManager.onActivityEnd(this.activityid);
/*    */       }
/* 34 */       new mzm.gsp.util.LogicProcedure()
/*    */       {
/*    */         protected boolean processImp() throws Exception
/*    */         {
/* 38 */           long localid = mzm.gsp.GameServerInfoManager.getLocalId();
/*    */           
/* 40 */           ActivityGlobalBean xActivityGlobalBean = xtable.Activity.get(Long.valueOf(localid));
/* 41 */           if (xActivityGlobalBean == null) {
/* 42 */             xActivityGlobalBean = xbean.Pod.newActivityGlobalBean();
/* 43 */             xtable.Activity.insert(Long.valueOf(localid), xActivityGlobalBean);
/*    */           }
/*    */           
/* 46 */           OpenBeanStore xOpenBeanStore = (OpenBeanStore)xActivityGlobalBean.getActivityopenmap().get(Integer.valueOf(RIDIPActivityForceClose.this.activityid));
/* 47 */           if (xOpenBeanStore == null) {
/* 48 */             xOpenBeanStore = xbean.Pod.newOpenBeanStore();
/* 49 */             long curTime = DateTimeUtils.getCurrTimeInMillis();
/* 50 */             xOpenBeanStore.setCleardatatime(curTime);
/* 51 */             xOpenBeanStore.setEndtime(curTime);
/* 52 */             xActivityGlobalBean.getActivityopenmap().put(Integer.valueOf(RIDIPActivityForceClose.this.activityid), xOpenBeanStore);
/*    */           }
/* 54 */           if (RIDIPActivityForceClose.this.doOrRecovery) {
/* 55 */             xOpenBeanStore.setOpenstate(xOpenBeanStore.getOpenstate() | 0x4);
/*    */             
/* 57 */             xOpenBeanStore.setOpenstate(xOpenBeanStore.getOpenstate() & 0xFFFFFFFD);
/*    */             
/* 59 */             xOpenBeanStore.setEndtime(DateTimeUtils.getCurrTimeInMillis());
/*    */           } else {
/* 61 */             xOpenBeanStore.setOpenstate(xOpenBeanStore.getOpenstate() & 0xFFFFFFFB);
/*    */           }
/*    */           
/*    */ 
/*    */ 
/* 66 */           SynActivitySpecialControlChangeRes controlChangeRes = new SynActivitySpecialControlChangeRes();
/* 67 */           ActivityManager.fillSpecialControlData(controlChangeRes.specialcontroldata, RIDIPActivityForceClose.this.activityid, xOpenBeanStore);
/*    */           
/* 69 */           OnlineManager.getInstance().sendAll(controlChangeRes);
/*    */           
/* 71 */           RIDIPActivityForceClose.this.activityForIDIPResult = ActivityForIDIPResult.SUCCESS;
/*    */           
/* 73 */           GameServer.logger().info(String.format("excute force close activity success|activityid=%d|doOrRecovery=%b", new Object[] { Integer.valueOf(RIDIPActivityForceClose.this.activityid), Boolean.valueOf(RIDIPActivityForceClose.this.doOrRecovery) }));
/*    */           
/*    */ 
/* 76 */           return true;
/*    */         }
/*    */       }.call();
/*    */     } catch (Exception e) {
/* 80 */       GameServer.logger().error("[Activity]RIDIPActivityForceClose.process@force close error", e);
/*    */     } finally {
/* 82 */       synchronized (this) {
/*    */         try {
/* 84 */           notifyAll();
/*    */         } catch (Exception e) {
/* 86 */           GameServer.logger().error("[Activity]RIDIPActivityForceClose.process@notifyall error", e);
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   public void call() {
/* 93 */     synchronized (this) {
/* 94 */       Executor.getInstance().execute(this);
/*    */       try {
/* 96 */         wait();
/*    */       } catch (InterruptedException e) {
/* 98 */         notifyAll();
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\main\RIDIPActivityForceClose.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
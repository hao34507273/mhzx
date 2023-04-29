/*    */ package mzm.gsp.activity.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.activity.SynActivitySpecialControlChangeRes;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.ActivityGlobalBean;
/*    */ import xbean.OpenBeanStore;
/*    */ 
/*    */ public class RIDIPActivityClose extends mzm.gsp.util.LogicRunnable
/*    */ {
/*    */   private final int activityid;
/* 13 */   private ActivityForIDIPResult activityForIDIPResult = ActivityForIDIPResult.UNKNOWN_ERROR;
/*    */   
/*    */   public RIDIPActivityClose(int activityid) {
/* 16 */     this.activityid = activityid;
/*    */   }
/*    */   
/*    */   public ActivityForIDIPResult getResult() {
/* 20 */     return this.activityForIDIPResult;
/*    */   }
/*    */   
/*    */   public void process() throws Exception
/*    */   {
/*    */     try {
/* 26 */       ActivityGlobalBean xSelectActivityGlobalBean = xtable.Activity.select(Long.valueOf(GameServerInfoManager.getLocalId()));
/*    */       
/* 28 */       if (xSelectActivityGlobalBean != null) {
/* 29 */         OpenBeanStore xSelectOpenBeanStore = (OpenBeanStore)xSelectActivityGlobalBean.getActivityopenmap().get(Integer.valueOf(this.activityid));
/*    */         
/* 31 */         if (xSelectOpenBeanStore == null) {
/* 32 */           this.activityForIDIPResult = ActivityForIDIPResult.ACTIVITY_NOT_IN_FORCE_OPEN; return;
/*    */         }
/*    */         
/* 35 */         if (!ActivityManager.isForceOpenState(xSelectOpenBeanStore.getOpenstate())) {
/* 36 */           this.activityForIDIPResult = ActivityForIDIPResult.ACTIVITY_NOT_IN_FORCE_OPEN; return;
/*    */         }
/*    */       }
/*    */       else
/*    */       {
/* 41 */         this.activityForIDIPResult = ActivityForIDIPResult.ACTIVITY_NOT_IN_FORCE_OPEN; return;
/*    */       }
/*    */       
/*    */ 
/* 45 */       ActivityManager.onActivityEnd(this.activityid);
/*    */       
/* 47 */       new mzm.gsp.util.LogicProcedure()
/*    */       {
/*    */         protected boolean processImp() throws Exception
/*    */         {
/* 51 */           ActivityGlobalBean xActivityGlobalBean = xtable.Activity.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*    */           
/* 53 */           if (xActivityGlobalBean != null) {
/* 54 */             OpenBeanStore xOpenBeanStore = (OpenBeanStore)xActivityGlobalBean.getActivityopenmap().get(Integer.valueOf(RIDIPActivityClose.this.activityid));
/* 55 */             if (xOpenBeanStore != null) {
/* 56 */               xOpenBeanStore.setEndtime(mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis());
/*    */               
/*    */ 
/* 59 */               SynActivitySpecialControlChangeRes controlChangeRes = new SynActivitySpecialControlChangeRes();
/* 60 */               ActivityManager.fillSpecialControlData(controlChangeRes.specialcontroldata, RIDIPActivityClose.this.activityid, xOpenBeanStore);
/*    */               
/* 62 */               mzm.gsp.online.main.OnlineManager.getInstance().sendAll(controlChangeRes);
/*    */             }
/*    */           }
/* 65 */           RIDIPActivityClose.this.activityForIDIPResult = ActivityForIDIPResult.SUCCESS;
/*    */           
/* 67 */           GameServer.logger().info(String.format("excute close activity success|activityid=%d", new Object[] { Integer.valueOf(RIDIPActivityClose.this.activityid) }));
/* 68 */           return true;
/*    */         }
/*    */       }.call();
/*    */     }
/*    */     catch (Exception e) {
/* 73 */       GameServer.logger().error("[Activity]RIDIPActivityClose.process@activity close error", e);
/*    */     } finally {
/* 75 */       synchronized (this) {
/*    */         try {
/* 77 */           notifyAll();
/*    */         } catch (Exception e) {
/* 79 */           GameServer.logger().error("[Activity]RIDIPActivityClose.process@notifyall error", e);
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   public void call()
/*    */   {
/* 87 */     synchronized (this) {
/* 88 */       xdb.Executor.getInstance().execute(this);
/*    */       try {
/* 90 */         wait();
/*    */       } catch (InterruptedException e) {
/* 92 */         notifyAll();
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\main\RIDIPActivityClose.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
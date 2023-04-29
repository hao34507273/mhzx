/*    */ package mzm.gsp.qingfu.main;
/*    */ 
/*    */ import gnet.GDeliveryManager;
/*    */ import java.util.concurrent.RunnableScheduledFuture;
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import mzm.gsp.GameServer;
/*    */ import org.apache.log4j.Logger;
/*    */ import xdb.Executor;
/*    */ import xdb.Xdb;
/*    */ import xio.Protocol;
/*    */ 
/*    */ public class RNotifyAuany implements Runnable
/*    */ {
/*    */   protected String fullUID;
/*    */   protected Protocol core;
/*    */   
/*    */   public void run()
/*    */   {
/* 19 */     xio.Xio xio = GDeliveryManager.getInstance().get();
/* 20 */     if (xio == null)
/*    */     {
/* 22 */       int delay = Xdb.random().nextInt(30) + 30;
/* 23 */       RunnableScheduledFuture<?> future = (RunnableScheduledFuture)Xdb.executor().schedule(this, delay, TimeUnit.SECONDS);
/*    */       
/*    */ 
/* 26 */       QingfuManager.putFuture(this.fullUID, future);
/*    */       
/* 28 */       GameServer.logger().info(String.format("[tencent]Tencent.RNotifyAuany.run@xio is null|full_user_identity=%s", new Object[] { this.fullUID }));
/*    */       
/*    */ 
/* 31 */       return;
/*    */     }
/*    */     
/* 34 */     RunnableScheduledFuture<?> future = (RunnableScheduledFuture)Xdb.executor().scheduleAtFixedRate(this, 30L, 30L, TimeUnit.SECONDS);
/*    */     
/*    */ 
/* 37 */     QingfuManager.putFuture(this.fullUID, future);
/*    */     
/* 39 */     this.core.send(xio);
/*    */     
/* 41 */     GameServer.logger().info(String.format("[tencent]Tencent.RNotifyAuany.run@notify auany done|full_user_identity=%s", new Object[] { this.fullUID }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\main\RNotifyAuany.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
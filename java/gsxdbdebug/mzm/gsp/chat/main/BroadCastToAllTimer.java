/*    */ package mzm.gsp.chat.main;
/*    */ 
/*    */ import java.util.concurrent.LinkedBlockingQueue;
/*    */ import java.util.concurrent.atomic.AtomicInteger;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.timer.main.MilliObserver;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ import xdb.Executor;
/*    */ import xdb.Xdb;
/*    */ import xio.Protocol;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class BroadCastToAllTimer
/*    */   extends MilliObserver
/*    */ {
/*    */   private static LinkedBlockingQueue<Protocol> protocolCachedQueue;
/* 20 */   private static final AtomicInteger auAtomicInteger = new AtomicInteger(0);
/*    */   
/*    */   BroadCastToAllTimer(long intervalMilliSeconds) {
/* 23 */     super(intervalMilliSeconds);
/*    */   }
/*    */   
/*    */   static void init(int cacheSize) {
/* 27 */     protocolCachedQueue = new LinkedBlockingQueue(cacheSize);
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean update()
/*    */   {
/* 33 */     Xdb.executor().execute(new LogicRunnable()
/*    */     {
/*    */       public void process() throws Exception
/*    */       {
/* 37 */         int realSize = 0;
/* 38 */         int dealSize = ChatArgs.getInstance().perInterval;
/* 39 */         if (dealSize > BroadCastToAllTimer.protocolCachedQueue.size()) {
/* 40 */           dealSize = BroadCastToAllTimer.protocolCachedQueue.size();
/*    */         }
/* 42 */         for (int i = 0; i < dealSize; i++) {
/* 43 */           Protocol protocol = (Protocol)BroadCastToAllTimer.protocolCachedQueue.poll();
/* 44 */           if (protocol != null) {
/* 45 */             OnlineManager.getInstance().sendAll(protocol);
/* 46 */             realSize++;
/*    */           }
/*    */         }
/* 49 */         BroadCastToAllTimer.auAtomicInteger.set(realSize);
/*    */       }
/* 51 */     });
/* 52 */     return true;
/*    */   }
/*    */   
/*    */   static void add(Protocol protocol) {
/* 56 */     if (auAtomicInteger.getAndIncrement() <= ChatArgs.getInstance().perInterval) {
/* 57 */       OnlineManager.getInstance().sendAll(protocol);
/*    */     } else {
/* 59 */       protocolCachedQueue.offer(protocol);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\main\BroadCastToAllTimer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
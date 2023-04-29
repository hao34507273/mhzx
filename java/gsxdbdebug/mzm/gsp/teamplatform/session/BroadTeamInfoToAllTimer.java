/*    */ package mzm.gsp.teamplatform.session;
/*    */ 
/*    */ import java.util.concurrent.LinkedBlockingQueue;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.teamplatform.match.MatchArgs;
/*    */ import mzm.gsp.timer.main.MilliObserver;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ import xdb.Executor;
/*    */ import xdb.Xdb;
/*    */ import xio.Protocol;
/*    */ 
/*    */ 
/*    */ public class BroadTeamInfoToAllTimer
/*    */   extends MilliObserver
/*    */ {
/*    */   private static LinkedBlockingQueue<Protocol> protocolCachedQueue;
/*    */   
/*    */   public BroadTeamInfoToAllTimer(long intervalMilliSeconds)
/*    */   {
/* 20 */     super(intervalMilliSeconds);
/*    */   }
/*    */   
/*    */   public static void init(int cacheSize) {
/* 24 */     protocolCachedQueue = new LinkedBlockingQueue(cacheSize);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean update()
/*    */   {
/* 31 */     Xdb.executor().execute(new LogicRunnable()
/*    */     {
/*    */       public void process() throws Exception
/*    */       {
/* 35 */         int dealSize = MatchArgs.getInstance().dealSize;
/* 36 */         if (dealSize > BroadTeamInfoToAllTimer.protocolCachedQueue.size()) {
/* 37 */           dealSize = BroadTeamInfoToAllTimer.protocolCachedQueue.size();
/*    */         }
/* 39 */         for (int i = 0; i < dealSize; i++) {
/* 40 */           Protocol protocol = (Protocol)BroadTeamInfoToAllTimer.protocolCachedQueue.poll();
/* 41 */           if (protocol != null) {
/* 42 */             OnlineManager.getInstance().sendAll(protocol);
/*    */           }
/*    */         }
/*    */       }
/* 46 */     });
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public static void add(Protocol protocol) {
/* 51 */     protocolCachedQueue.offer(protocol);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\teamplatform\session\BroadTeamInfoToAllTimer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
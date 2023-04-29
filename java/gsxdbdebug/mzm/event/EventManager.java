/*    */ package mzm.event;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ 
/*  5 */ public class EventManager<T> { private final ArrayList<EventListener<T>> listners = new ArrayList();
/*    */   
/*    */   public synchronized void register(final EventHandler<T> handler)
/*    */   {
/*  9 */     this.listners.add(new EventProcedure()
/*    */     {
/*    */       protected boolean processImp()
/*    */         throws Exception
/*    */       {
/* 14 */         handler.handle(this.arg);
/* 15 */         return true;
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public synchronized void register(EventProcedure<T> proc) {
/* 21 */     this.listners.add(proc);
/*    */   }
/*    */   
/*    */   public synchronized void register(EventRunnable<T> runnable)
/*    */   {
/* 26 */     this.listners.add(runnable);
/*    */   }
/*    */   
/*    */   public synchronized java.util.List<EventListener<T>> getHandlers()
/*    */   {
/* 31 */     return java.util.Collections.unmodifiableList(this.listners);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\event\EventManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
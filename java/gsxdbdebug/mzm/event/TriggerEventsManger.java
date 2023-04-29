/*     */ package mzm.event;
/*     */ 
/*     */ import java.util.LinkedList;
/*     */ import mzm.gsp.util.TaskOneByOne;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TriggerEventsManger
/*     */ {
/*  16 */   private static TriggerEventsManger instance = new TriggerEventsManger();
/*     */   
/*     */   public static TriggerEventsManger getInstance() {
/*  19 */     return instance;
/*     */   }
/*     */   
/*  22 */   private static final ThreadLocal<LinkedList<EventLocalStore>> localEvents = new ThreadLocal();
/*     */   
/*     */ 
/*     */   private static final class EventLocalStore
/*     */   {
/*     */     public final BasicEvent event;
/*     */     
/*     */     public final TaskOneByOne taskOneByOne;
/*     */     
/*     */ 
/*     */     EventLocalStore(BasicEvent event, TaskOneByOne taskOneByOne)
/*     */     {
/*  34 */       this.event = event;
/*  35 */       this.taskOneByOne = taskOneByOne;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int triggerBeforeTransaction()
/*     */   {
/*  43 */     LinkedList<EventLocalStore> events = (LinkedList)localEvents.get();
/*  44 */     if (events == null)
/*  45 */       localEvents.set(events = new LinkedList());
/*  46 */     return events.size();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public <T> boolean triggerAfterTransaction(boolean bSuccess, int savePoint, int nestCount)
/*     */   {
/*  60 */     LinkedList<EventLocalStore> events = (LinkedList)localEvents.get();
/*  61 */     if (events != null) {
/*  62 */       if (nestCount == 0) {
/*     */         try {
/*  64 */           if (bSuccess) {
/*  65 */             for (EventLocalStore eventLocalStore : events) {
/*  66 */               triggerEventAtOnce(eventLocalStore.event, eventLocalStore.event.getArg(), eventLocalStore.taskOneByOne);
/*     */             }
/*     */           }
/*     */         } finally {
/*  70 */           localEvents.set(null);
/*  71 */           events.clear();
/*     */         }
/*     */         
/*     */       }
/*  75 */       else if ((!bSuccess) && (savePoint >= 0)) {
/*  76 */         for (int i = events.size() - 1; i >= savePoint; i--)
/*  77 */           events.remove(i);
/*     */       }
/*     */     }
/*  80 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public <T> void triggerEvent(BasicEvent<T> event, T arg)
/*     */   {
/*  90 */     triggerEvent(event, arg, null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public <T> void triggerEvent(BasicEvent<T> event, T arg, TaskOneByOne taskOneByOne)
/*     */   {
/* 100 */     LinkedList<EventLocalStore> events = (LinkedList)localEvents.get();
/* 101 */     if (events != null) {
/* 102 */       event.setArg(arg);
/* 103 */       EventLocalStore eventLocalStore = new EventLocalStore(event, taskOneByOne);
/* 104 */       events.add(eventLocalStore);
/*     */     }
/*     */     else {
/* 107 */       triggerEventAtOnce(event, arg, taskOneByOne);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public <T> void triggerEventAtOnce(BasicEvent<T> event, T arg)
/*     */   {
/* 118 */     triggerEventAtOnce(event, arg, null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public <T> void triggerEventAtOnce(BasicEvent<T> event, T arg, TaskOneByOne taskOneByOne)
/*     */   {
/* 128 */     event.asyncTrigger(arg, taskOneByOne);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\event\TriggerEventsManger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
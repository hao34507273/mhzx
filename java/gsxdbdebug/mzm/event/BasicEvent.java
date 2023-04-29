/*     */ package mzm.event;
/*     */ 
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.util.TaskOneByOne;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Executor;
/*     */ import xdb.Xdb;
/*     */ 
/*     */ public abstract class BasicEvent<Arg> implements IEvent<Arg>
/*     */ {
/*  11 */   Logger logger = Logger.getLogger(BasicEvent.class);
/*     */   
/*     */   private Arg arg;
/*  14 */   private boolean bSequentialed = false;
/*     */   
/*     */   public abstract EventManager<Arg> getEventManager();
/*     */   
/*     */   public Arg getArg()
/*     */   {
/*  20 */     return (Arg)this.arg;
/*     */   }
/*     */   
/*     */   public void setArg(Arg arg)
/*     */   {
/*  25 */     this.arg = arg;
/*     */   }
/*     */   
/*     */   protected boolean isInValid() {
/*  29 */     return getEventManager() == null;
/*     */   }
/*     */   
/*     */   java.util.concurrent.ScheduledFuture<?> asyncTrigger(final Arg arg, TaskOneByOne taskOneByOne)
/*     */   {
/*  34 */     if (isInValid()) {
/*  35 */       return null;
/*     */     }
/*     */     
/*  38 */     if (taskOneByOne != null) {
/*  39 */       for (EventListener<Arg> handler : getEventManager().getHandlers()) {
/*  40 */         if ((handler instanceof EventProcedure)) {
/*     */           try {
/*  42 */             EventProcedure<Arg> thisProc = (EventProcedure)handler.clone();
/*  43 */             thisProc.setArg(arg);
/*  44 */             taskOneByOne.add(thisProc);
/*     */           } catch (Exception e) {
/*  46 */             this.logger.error("Clone Event Procedure Exception! Event : " + this, e);
/*     */           }
/*  48 */         } else if ((handler instanceof EventRunnable)) {
/*     */           try {
/*  50 */             EventRunnable<Arg> thisRunn = (EventRunnable)handler.clone();
/*  51 */             thisRunn.setArg(arg);
/*  52 */             taskOneByOne.add(thisRunn);
/*     */           } catch (Exception e) {
/*  54 */             this.logger.error("Clone Event Runnable Exception! Event : " + this, e);
/*     */           }
/*     */         } else {
/*  57 */           this.logger.error("Unknown Event Handler Type : " + handler + ", Evnet : " + this);
/*     */         }
/*     */       }
/*  60 */       return null;
/*     */     }
/*  62 */     Xdb.executor().schedule(new mzm.gsp.util.LogicRunnable()
/*     */     {
/*     */       public void process() throws Exception
/*     */       {
/*  66 */         for (EventListener<Arg> handler : BasicEvent.this.getEventManager().getHandlers())
/*  67 */           if ((handler instanceof EventProcedure)) {
/*     */             try {
/*  69 */               EventProcedure<Arg> thisProc = (EventProcedure)handler.clone();
/*  70 */               thisProc.setArg(arg);
/*  71 */               thisProc.call();
/*     */             } catch (Exception e) {
/*  73 */               BasicEvent.this.logger.error("Clone Event Procedure Exception! Event : " + this, e);
/*     */             }
/*  75 */           } else if ((handler instanceof EventRunnable)) {
/*     */             try {
/*  77 */               EventRunnable<Arg> thisRunn = (EventRunnable)handler.clone();
/*  78 */               thisRunn.setArg(arg);
/*  79 */               thisRunn.run();
/*     */             } catch (Exception e) {
/*  81 */               BasicEvent.this.logger.error("Clone Event Runnable Exception! Event : " + this, e);
/*     */             }
/*     */           } else
/*  84 */             BasicEvent.this.logger.error("Unknown Event Handler Type : " + handler + ", Evnet : " + this); } }, 0L, TimeUnit.SECONDS);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean getSequential()
/*     */   {
/*  96 */     return this.bSequentialed;
/*     */   }
/*     */   
/*     */   public void setSequential(boolean sequential)
/*     */   {
/* 101 */     this.bSequentialed = sequential;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\event\BasicEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
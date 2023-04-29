/*     */ package mzm.gsp.util;
/*     */ 
/*     */ import java.util.LinkedList;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Executor;
/*     */ import xdb.Procedure;
/*     */ import xdb.Procedure.Done;
/*     */ import xdb.Xdb;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TaskOneByOne
/*     */ {
/*  17 */   private static Logger logger = Logger.getLogger(TaskOneByOne.class);
/*     */   
/*     */   private int capacity;
/*  20 */   private LinkedList<Task> oneByOne = new LinkedList();
/*  21 */   private Procedure.Done<LogicProcedure> procedureDone = new Procedure.Done() {
/*     */     public void doDone(LogicProcedure p) {
/*  23 */       TaskOneByOne.this.doDone();
/*     */     }
/*     */   };
/*     */   
/*     */   public TaskOneByOne()
/*     */   {
/*  29 */     this.capacity = 0;
/*     */   }
/*     */   
/*     */   public TaskOneByOne(int capacity) {
/*  33 */     this.capacity = capacity;
/*     */   }
/*     */   
/*     */   private void doDone()
/*     */   {
/*  38 */     synchronized (this) {
/*  39 */       this.oneByOne.removeFirst();
/*  40 */       if (this.oneByOne.size() > 0) {
/*  41 */         Task task = (Task)this.oneByOne.peekFirst();
/*  42 */         if (task.procedure != null) {
/*  43 */           Procedure.execute(task.procedure, this.procedureDone);
/*     */         }
/*     */         else {
/*  46 */           Xdb.executor().execute(task.runnable);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean add(LogicProcedure p)
/*     */   {
/*  59 */     if (p == null) {
/*  60 */       return false;
/*     */     }
/*  62 */     synchronized (this) {
/*  63 */       if ((this.capacity > 0) && (this.oneByOne.size() >= this.capacity)) {
/*  64 */         logger.error(getClass().getName() + " out of capacity! maxSize=" + this.capacity + ", unhandled task=" + p);
/*  65 */         return false;
/*     */       }
/*  67 */       this.oneByOne.addLast(new Task(p));
/*  68 */       if (this.oneByOne.size() == 1) {
/*  69 */         Procedure.execute(((Task)this.oneByOne.peekFirst()).procedure, this.procedureDone);
/*     */       }
/*     */     }
/*  72 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean add(LogicRunnable r)
/*     */   {
/*  81 */     if (r == null) {
/*  82 */       return false;
/*     */     }
/*  84 */     synchronized (this) {
/*  85 */       if ((this.capacity > 0) && (this.oneByOne.size() >= this.capacity)) {
/*  86 */         logger.error(getClass().getName() + "out of capacity! maxSize=" + this.capacity + ", unhandled task=" + r);
/*  87 */         return false;
/*     */       }
/*  89 */       this.oneByOne.addLast(new Task(r));
/*  90 */       if (this.oneByOne.size() == 1) {
/*  91 */         Xdb.executor().execute(((Task)this.oneByOne.peekFirst()).runnable);
/*     */       }
/*     */     }
/*  94 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int size()
/*     */   {
/* 103 */     return this.oneByOne.size();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCapacity(int capacity)
/*     */   {
/* 111 */     this.capacity = capacity;
/*     */   }
/*     */   
/*     */   private class RunnableWithDone implements Runnable
/*     */   {
/*     */     private Runnable r;
/*     */     
/*     */     public RunnableWithDone(Runnable r)
/*     */     {
/* 120 */       this.r = r;
/*     */     }
/*     */     
/*     */     public void run()
/*     */     {
/*     */       try {
/* 126 */         this.r.run();
/*     */       } catch (Exception e) {
/* 128 */         TaskOneByOne.logger.error("Runnable error.", e);
/*     */       }
/*     */       
/* 131 */       doDone();
/*     */     }
/*     */     
/*     */     public void doDone() {
/* 135 */       TaskOneByOne.this.doDone();
/*     */     }
/*     */   }
/*     */   
/*     */   private class Task {
/*     */     LogicProcedure procedure;
/*     */     TaskOneByOne.RunnableWithDone runnable;
/*     */     
/*     */     public Task(LogicProcedure p) {
/* 144 */       this.procedure = p;
/*     */     }
/*     */     
/*     */     public Task(Runnable r) {
/* 148 */       this.runnable = new TaskOneByOne.RunnableWithDone(TaskOneByOne.this, r);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\util\TaskOneByOne.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
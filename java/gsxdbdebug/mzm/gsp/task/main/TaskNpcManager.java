/*     */ package mzm.gsp.task.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.locks.Lock;
/*     */ import java.util.concurrent.locks.ReadWriteLock;
/*     */ import mzm.gsp.GameServer;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class TaskNpcManager
/*     */ {
/*  14 */   private static TaskNpcManager instance = new TaskNpcManager();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static TaskNpcManager getInstance()
/*     */   {
/*  22 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  28 */   private final Map<Integer, TaskNpcLibIdHandler> taskNPCLibHandlers = new HashMap();
/*     */   
/*  30 */   private final ReadWriteLock lock = new java.util.concurrent.locks.ReentrantReadWriteLock();
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
/*     */ 
/*     */ 
/*     */   boolean registerTaskNpcLibHandler(int npcLibId, TaskNpcLibIdHandler handler)
/*     */   {
/*  45 */     if (!RoleTaskManager.containsNpcLibId(npcLibId))
/*     */     {
/*  47 */       GameServer.logger().error(String.format("[task]TaskNpcManager.registerTaskNpcLibHandler@ npcLibId is illegal!|npcLibId=%d", new Object[] { Integer.valueOf(npcLibId) }));
/*     */       
/*  49 */       return false;
/*     */     }
/*  51 */     if (handler == null)
/*     */     {
/*  53 */       GameServer.logger().error(String.format("[task]TaskNpcManager.registerTaskNpcLibHandler@ handler is null!|npcLibId=%d", new Object[] { Integer.valueOf(npcLibId) }));
/*     */       
/*  55 */       return false;
/*     */     }
/*  57 */     TaskNpcLibIdHandler previousHandler = null;
/*  58 */     this.lock.writeLock().lock();
/*     */     try
/*     */     {
/*  61 */       previousHandler = (TaskNpcLibIdHandler)this.taskNPCLibHandlers.get(Integer.valueOf(npcLibId));
/*  62 */       if (previousHandler == null)
/*     */       {
/*  64 */         this.taskNPCLibHandlers.put(Integer.valueOf(npcLibId), handler);
/*     */       }
/*     */     }
/*     */     finally
/*     */     {
/*  69 */       this.lock.writeLock().unlock();
/*     */     }
/*  71 */     if (previousHandler != null)
/*     */     {
/*  73 */       GameServer.logger().error(String.format("[task]TaskNpcManager.registerTaskNpcLibHandler@ duplicate register!|npcLibId=%d|previousHandler=%s|currentHandler=%s", new Object[] { Integer.valueOf(npcLibId), previousHandler.getClass().getName(), handler.getClass().getName() }));
/*     */       
/*     */ 
/*     */ 
/*  77 */       return false;
/*     */     }
/*  79 */     return true;
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
/*     */   TaskNpcLibIdHandler getTaskNpcLibIdHandler(int npcLibId)
/*     */   {
/*  92 */     this.lock.readLock().lock();
/*     */     try
/*     */     {
/*  95 */       return (TaskNpcLibIdHandler)this.taskNPCLibHandlers.get(Integer.valueOf(npcLibId));
/*     */     }
/*     */     finally
/*     */     {
/*  99 */       this.lock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean checkRegisterComplete()
/*     */   {
/* 112 */     Set<Integer> allNpcLibIds = RoleTaskManager.getAllTaskNpcLibId();
/* 113 */     Set<Integer> notRegsiterNpcLibIds = new java.util.HashSet();
/* 114 */     this.lock.readLock().lock();
/*     */     try
/*     */     {
/* 117 */       for (i$ = allNpcLibIds.iterator(); i$.hasNext();) { int npcLibId = ((Integer)i$.next()).intValue();
/*     */         
/* 119 */         if (this.taskNPCLibHandlers.get(Integer.valueOf(npcLibId)) == null)
/*     */         {
/*     */ 
/*     */ 
/* 123 */           notRegsiterNpcLibIds.add(Integer.valueOf(npcLibId));
/*     */         }
/*     */       }
/*     */     } finally {
/*     */       Iterator i$;
/* 128 */       this.lock.readLock().unlock();
/*     */     }
/* 130 */     if (notRegsiterNpcLibIds.size() > 0)
/*     */     {
/* 132 */       GameServer.logger().error(String.format("[task]TaskNpcManager.checkRegisterComplete@ not register npcIds=%s", new Object[] { notRegsiterNpcLibIds.toString() }));
/*     */       
/*     */ 
/* 135 */       return false;
/*     */     }
/* 137 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\main\TaskNpcManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
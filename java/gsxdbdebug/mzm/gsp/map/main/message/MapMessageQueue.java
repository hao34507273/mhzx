/*     */ package mzm.gsp.map.main.message;
/*     */ 
/*     */ import java.util.concurrent.LinkedBlockingQueue;
/*     */ import java.util.concurrent.atomic.AtomicBoolean;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.LogicRunnable;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class MapMessageQueue implements Runnable
/*     */ {
/*  12 */   private static MapMessageQueue instance = null;
/*     */   private final Thread thread;
/*     */   
/*     */   public static MapMessageQueue getInstance() {
/*  16 */     return instance;
/*     */   }
/*     */   
/*     */   public static void init()
/*     */   {
/*     */     try
/*     */     {
/*  23 */       instance = new MapMessageQueue();
/*  24 */       instance.start();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  28 */       throw new RuntimeException(e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void exit()
/*     */   {
/*  34 */     if (instance != null)
/*     */     {
/*  36 */       instance.stop();
/*     */     }
/*     */   }
/*     */   
/*     */   private static class MapMsgHandlerDoneProcedure<T extends AbstractMapMsgHandler> extends LogicProcedure
/*     */   {
/*     */     private final MapMsgHandlerDone<T> done;
/*     */     private final T mmh;
/*     */     
/*     */     public MapMsgHandlerDoneProcedure(MapMsgHandlerDone<T> done, T mmh)
/*     */     {
/*  47 */       this.done = done;
/*  48 */       this.mmh = mmh;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  54 */       return this.done.onMapMsgHandlerDone(this.mmh);
/*     */     }
/*     */   }
/*     */   
/*     */   private static class MapMsgHandlerDoneRunnable<T extends AbstractMapMsgHandler> extends LogicRunnable
/*     */   {
/*     */     private final MapMsgHandlerDone<T> done;
/*     */     private final T mmh;
/*     */     
/*     */     public MapMsgHandlerDoneRunnable(MapMsgHandlerDone<T> done, T mmh)
/*     */     {
/*  65 */       this.done = done;
/*  66 */       this.mmh = mmh;
/*     */     }
/*     */     
/*     */     public void process()
/*     */       throws Exception
/*     */     {
/*  72 */       this.done.onMapMsgHandlerDone(this.mmh);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*  77 */   private final AtomicBoolean isRunning = new AtomicBoolean(true);
/*  78 */   private final LinkedBlockingQueue<AbstractMapMsgHandler> messages = new LinkedBlockingQueue();
/*     */   
/*     */   private MapMessageQueue()
/*     */   {
/*  82 */     this.thread = new Thread(this, "map_message");
/*     */   }
/*     */   
/*     */   private void start()
/*     */   {
/*  87 */     this.thread.setDaemon(true);
/*  88 */     this.thread.start();
/*     */   }
/*     */   
/*     */   private void stop()
/*     */   {
/*  93 */     this.isRunning.set(false);
/*     */     
/*     */     try
/*     */     {
/*  97 */       this.messages.add(new MMH_Null());
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 101 */       GameServer.logger().warn("[map]MapMessageQueue.stop@stop ignore exception", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public int getMapMsgQueueSize()
/*     */   {
/* 107 */     return this.messages.size();
/*     */   }
/*     */   
/*     */   boolean postMessage(AbstractMapMsgHandler handler)
/*     */   {
/* 112 */     if (handler == null)
/*     */     {
/* 114 */       return false;
/*     */     }
/*     */     
/* 117 */     if (!this.isRunning.get())
/*     */     {
/* 119 */       GameServer.logger().warn("[map]MapMessageQueue.postMessage@add message failed, because map message thread not running");
/*     */       
/*     */ 
/* 122 */       return false;
/*     */     }
/*     */     
/*     */     try
/*     */     {
/* 127 */       this.messages.put(handler);
/*     */       
/* 129 */       return true;
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 133 */       GameServer.logger().error("[map]MapMessageQueue.postMessage@add message error", e);
/*     */     }
/*     */     
/* 136 */     return false;
/*     */   }
/*     */   
/*     */   boolean addMessage(AbstractMapMsgHandler handler)
/*     */   {
/* 141 */     if (handler == null)
/*     */     {
/* 143 */       return false;
/*     */     }
/*     */     
/* 146 */     if (!this.isRunning.get())
/*     */     {
/* 148 */       GameServer.logger().warn("[map]MapMessageQueue.addMessage@add message failed, because map message thread not running");
/*     */       
/*     */ 
/* 151 */       return false;
/*     */     }
/*     */     
/* 154 */     if (this.thread.getId() == Thread.currentThread().getId())
/*     */     {
/* 156 */       GameServer.logger().warn("[map]MapMessageQueue.addMessage@should not invoke addMessage method in map thread", new RuntimeException().fillInStackTrace());
/*     */       
/*     */ 
/* 159 */       handler.run();
/*     */       
/* 161 */       done(handler);
/*     */       
/* 163 */       return true;
/*     */     }
/*     */     
/* 166 */     synchronized (handler)
/*     */     {
/*     */       try
/*     */       {
/* 170 */         this.messages.put(handler);
/*     */         
/* 172 */         handler.wait();
/*     */         
/* 174 */         return true;
/*     */       }
/*     */       catch (Exception e)
/*     */       {
/* 178 */         GameServer.logger().error("[map]MapMessageQueue.addMessage@add message error", e);
/*     */         
/* 180 */         handler.notifyAll();
/*     */         
/* 182 */         return false;
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void run()
/*     */   {
/* 190 */     while (this.isRunning.get())
/*     */     {
/*     */       try
/*     */       {
/* 194 */         AbstractMapMsgHandler handler = (AbstractMapMsgHandler)this.messages.take();
/*     */         try
/*     */         {
/* 197 */           handler.run();
/*     */         }
/*     */         finally
/*     */         {
/* 201 */           done(handler);
/*     */         }
/*     */       }
/*     */       catch (Throwable t)
/*     */       {
/* 206 */         GameServer.logger().error("[map]MapMessageQueue.run@handle message error", t);
/*     */       }
/*     */     }
/*     */     
/* 210 */     releaseAllMonitors();
/*     */   }
/*     */   
/*     */   private final void releaseAllMonitors()
/*     */   {
/* 215 */     AbstractMapMsgHandler handler = null;
/* 216 */     while ((handler = (AbstractMapMsgHandler)this.messages.poll()) != null)
/*     */     {
/*     */       try
/*     */       {
/* 220 */         synchronized (handler)
/*     */         {
/* 222 */           handler.notifyAll();
/*     */         }
/*     */       }
/*     */       catch (Exception e)
/*     */       {
/* 227 */         GameServer.logger().error("[map]MapMessageQueue.releaseAllMonitors@map message handler notify all error", e);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private final void done(AbstractMapMsgHandler handler)
/*     */   {
/*     */     try
/*     */     {
/* 236 */       synchronized (handler)
/*     */       {
/* 238 */         handler.notifyAll();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 243 */       GameServer.logger().error("[map]MapMessageQueue.done@map message handler notify all error", e);
/*     */     }
/*     */     
/* 246 */     MapMsgHandlerDone<AbstractMapMsgHandler> done = handler.getMapMsgHandlerDone();
/* 247 */     if (done != null)
/*     */     {
/* 249 */       if (done.isCallInProcedure())
/*     */       {
/* 251 */         new MapMsgHandlerDoneProcedure(done, handler).execute();
/*     */       }
/*     */       else
/*     */       {
/* 255 */         new MapMsgHandlerDoneRunnable(done, handler).execute();
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MapMessageQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
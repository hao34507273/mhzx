/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import java.util.ArrayDeque;
/*    */ import java.util.concurrent.locks.ReentrantLock;
/*    */ 
/*    */ 
/*    */ public class MessageQueue<T>
/*    */ {
/*    */   ArrayDeque<T> inputQueue;
/*    */   ArrayDeque<T> outputQueue;
/* 11 */   ReentrantLock inputLock = new ReentrantLock();
/* 12 */   ReentrantLock outputLock = new ReentrantLock();
/*    */   
/*    */   public MessageQueue()
/*    */   {
/* 16 */     this.inputQueue = new ArrayDeque();
/* 17 */     this.outputQueue = new ArrayDeque();
/*    */   }
/*    */   
/*    */   public void put(T e)
/*    */   {
/* 22 */     this.inputLock.lock();
/* 23 */     this.inputQueue.addLast(e);
/* 24 */     this.inputLock.unlock();
/*    */   }
/*    */   
/*    */   public T take()
/*    */   {
/* 29 */     this.outputLock.lock();
/* 30 */     if (!this.outputQueue.isEmpty())
/*    */     {
/* 32 */       T t = this.outputQueue.pollFirst();
/* 33 */       this.outputLock.unlock();
/*    */       
/* 35 */       return t;
/*    */     }
/*    */     
/*    */ 
/*    */     for (;;)
/*    */     {
/* 41 */       this.inputLock.lock();
/* 42 */       if (!this.inputQueue.isEmpty())
/*    */         break;
/* 44 */       this.inputLock.unlock();
/*    */       try
/*    */       {
/* 47 */         Thread.sleep(1L);
/*    */       }
/*    */       catch (Exception e) {}
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 55 */     ArrayDeque<T> t = this.outputQueue;
/* 56 */     this.outputQueue = this.inputQueue;
/* 57 */     this.inputQueue = t;
/*    */     
/* 59 */     this.inputLock.unlock();
/*    */     
/* 61 */     T r = this.outputQueue.pollFirst();
/*    */     
/* 63 */     this.outputLock.unlock();
/*    */     
/* 65 */     return r;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getInputQueueMutableSize()
/*    */   {
/* 73 */     return this.inputQueue.size();
/*    */   }
/*    */   
/*    */   public int getOutputQueueMutableSize()
/*    */   {
/* 78 */     return this.outputQueue.size();
/*    */   }
/*    */   
/*    */   public int mutableSize()
/*    */   {
/* 83 */     return getInputQueueMutableSize() + getOutputQueueMutableSize();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MessageQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
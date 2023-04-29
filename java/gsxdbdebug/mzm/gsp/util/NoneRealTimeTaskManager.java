/*    */ package mzm.gsp.util;
/*    */ 
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class NoneRealTimeTaskManager
/*    */ {
/* 12 */   private static NoneRealTimeTaskManager instance = new NoneRealTimeTaskManager();
/* 13 */   private static Logger logger = Logger.getLogger(NoneRealTimeTaskManager.class);
/*    */   
/*    */   public static NoneRealTimeTaskManager getInstance() {
/* 16 */     return instance;
/*    */   }
/*    */   
/* 19 */   private TaskOneByOne oneByOne = new TaskOneByOne();
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void addTask(LogicProcedure p)
/*    */   {
/* 31 */     this.oneByOne.add(p);
/* 32 */     if (logger.isDebugEnabled()) {
/* 33 */       logger.debug("add procedure task: " + p);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void addTask(LogicRunnable r)
/*    */   {
/* 43 */     this.oneByOne.add(r);
/* 44 */     if (logger.isDebugEnabled()) {
/* 45 */       logger.info("add runnable task: " + r);
/*    */     }
/*    */   }
/*    */   
/*    */   public int taskSize()
/*    */   {
/* 51 */     return this.oneByOne.size();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\util\NoneRealTimeTaskManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
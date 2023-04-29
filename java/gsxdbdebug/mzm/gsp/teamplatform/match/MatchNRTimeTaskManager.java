/*    */ package mzm.gsp.teamplatform.match;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ import mzm.gsp.util.TaskOneByOne;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MatchNRTimeTaskManager
/*    */ {
/* 18 */   private static MatchNRTimeTaskManager instance = new MatchNRTimeTaskManager();
/* 19 */   private static Logger logger = Logger.getLogger(MatchNRTimeTaskManager.class);
/*    */   
/*    */   public static MatchNRTimeTaskManager getInstance()
/*    */   {
/* 23 */     return instance;
/*    */   }
/*    */   
/* 26 */   private TaskOneByOne oneByOne = new TaskOneByOne();
/*    */   
/*    */ 
/*    */ 
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
/* 41 */     this.oneByOne.add(p);
/* 42 */     if (logger.isDebugEnabled()) {}
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void addTask(LogicRunnable r)
/*    */   {
/* 55 */     this.oneByOne.add(r);
/* 56 */     if (logger.isDebugEnabled())
/*    */     {
/* 58 */       logger.info("add runnable task: " + r);
/*    */     }
/*    */   }
/*    */   
/*    */   public int taskSize()
/*    */   {
/* 64 */     return this.oneByOne.size();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\teamplatform\match\MatchNRTimeTaskManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
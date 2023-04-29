/*    */ package mzm.gsp.group.main;
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
/*    */ public class GroupAsynTaskManager
/*    */ {
/* 17 */   private static GroupAsynTaskManager instance = new GroupAsynTaskManager();
/* 18 */   private static Logger logger = Logger.getLogger(GroupAsynTaskManager.class);
/*    */   
/*    */   public static GroupAsynTaskManager getInstance()
/*    */   {
/* 22 */     return instance;
/*    */   }
/*    */   
/* 25 */   private TaskOneByOne oneByOne = new TaskOneByOne();
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void addTask(LogicProcedure p)
/*    */   {
/* 34 */     this.oneByOne.add(p);
/* 35 */     if (logger.isDebugEnabled())
/*    */     {
/* 37 */       logger.debug("add procedure task: " + p);
/*    */     }
/*    */   }
/*    */   
/*    */   public void addTask(LogicRunnable r)
/*    */   {
/* 43 */     this.oneByOne.add(r);
/* 44 */     if (logger.isDebugEnabled())
/*    */     {
/* 46 */       logger.info("add runnable task: " + r);
/*    */     }
/*    */   }
/*    */   
/*    */   public int taskSize()
/*    */   {
/* 52 */     return this.oneByOne.size();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\group\main\GroupAsynTaskManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
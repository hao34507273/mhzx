/*    */ package mzm.gsp.personal.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ import mzm.gsp.util.TaskOneByOne;
/*    */ 
/*    */ public class UpdateCacheOneByOne
/*    */ {
/*  8 */   private static final UpdateCacheOneByOne instance = new UpdateCacheOneByOne();
/*    */   
/*    */   public static UpdateCacheOneByOne getInstance()
/*    */   {
/* 12 */     return instance;
/*    */   }
/*    */   
/* 15 */   private TaskOneByOne tasks = new TaskOneByOne();
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean add(LogicRunnable r)
/*    */   {
/* 23 */     return this.tasks.add(r);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\personal\main\UpdateCacheOneByOne.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
/*    */ package mzm.gsp.children.main;
/*    */ 
/*    */ import mzm.gsp.util.TaskOneByOne;
/*    */ 
/*    */ public class ChildrenEventOneByOne
/*    */ {
/*  7 */   private TaskOneByOne oneByOne = new TaskOneByOne();
/*    */   
/*  9 */   private static final ChildrenEventOneByOne instance = new ChildrenEventOneByOne();
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static ChildrenEventOneByOne getInstance()
/*    */   {
/* 17 */     return instance;
/*    */   }
/*    */   
/*    */   public TaskOneByOne getOneByOne()
/*    */   {
/* 22 */     return this.oneByOne;
/*    */   }
/*    */   
/*    */   public int taskSize()
/*    */   {
/* 27 */     return this.oneByOne.size();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\main\ChildrenEventOneByOne.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
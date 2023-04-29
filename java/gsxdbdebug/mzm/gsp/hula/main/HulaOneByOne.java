/*    */ package mzm.gsp.hula.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.util.TaskOneByOne;
/*    */ 
/*    */ 
/*    */ public class HulaOneByOne
/*    */ {
/*  9 */   private static HulaOneByOne instance = new HulaOneByOne();
/*    */   
/*    */   public static HulaOneByOne getInstance()
/*    */   {
/* 13 */     return instance;
/*    */   }
/*    */   
/* 16 */   private final TaskOneByOne oneByOne = new TaskOneByOne();
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   void excute(LogicProcedure p)
/*    */   {
/* 25 */     this.oneByOne.add(p);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\hula\main\HulaOneByOne.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
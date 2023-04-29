/*    */ package mzm.gsp.personal.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public abstract class SearchBaseProcedure
/*    */   extends LogicProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/*    */     try
/*    */     {
/* 12 */       return search();
/*    */     }
/*    */     finally
/*    */     {
/* 16 */       SearchTaskOneByOne.getInstance().onTaskDone();
/*    */     }
/*    */   }
/*    */   
/*    */   protected abstract boolean search()
/*    */     throws Exception;
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\personal\main\SearchBaseProcedure.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
/*    */ package mzm.gsp.christmasstocking.main;
/*    */ 
/*    */ import mzm.gsp.timer.main.Observer;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class RemoveTreeObserver extends Observer
/*    */ {
/*    */   public RemoveTreeObserver(long intervalSeconds)
/*    */   {
/* 10 */     super(intervalSeconds);
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean update()
/*    */   {
/* 16 */     new PRemoveTree(null).execute();
/* 17 */     return false;
/*    */   }
/*    */   
/*    */   private class PRemoveTree extends LogicProcedure
/*    */   {
/*    */     private PRemoveTree() {}
/*    */     
/*    */     protected boolean processImp() throws Exception
/*    */     {
/* 26 */       ChristmasStockingManager.triggerTreeRemoveEvent();
/*    */       
/* 28 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\christmasstocking\main\RemoveTreeObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
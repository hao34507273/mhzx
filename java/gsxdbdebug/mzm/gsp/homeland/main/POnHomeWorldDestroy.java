/*    */ package mzm.gsp.homeland.main;
/*    */ 
/*    */ import mzm.gsp.map.event.WorldDestroyEventProcedure;
/*    */ 
/*    */ public class POnHomeWorldDestroy
/*    */   extends WorldDestroyEventProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 10 */     HomelandManager.onHomeWorldDestroy(((Long)this.arg).longValue());
/*    */     
/* 12 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\main\POnHomeWorldDestroy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
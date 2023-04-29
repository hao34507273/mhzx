/*    */ package mzm.gsp.homeland.main;
/*    */ 
/*    */ import mzm.gsp.cat.event.CatRecoveryToItemArg;
/*    */ 
/*    */ public class POnCatRecycle extends mzm.gsp.cat.event.CatRecoveryToItemProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/*  9 */     HomelandManager.catRemove(((CatRecoveryToItemArg)this.arg).roleid, ((CatRecoveryToItemArg)this.arg).catid);
/* 10 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\main\POnCatRecycle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
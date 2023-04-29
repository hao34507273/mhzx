/*    */ package mzm.gsp.homeland.main;
/*    */ 
/*    */ import mzm.gsp.cat.event.CatCreateArg;
/*    */ import mzm.gsp.cat.event.CatCreateProcedure;
/*    */ 
/*    */ public class PRestoreCatIntoYardOnCreate
/*    */   extends CatCreateProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     HomelandManager.restoreCatIntoYart(((CatCreateArg)this.arg).roleid);
/* 12 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\main\PRestoreCatIntoYardOnCreate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
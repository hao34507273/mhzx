/*    */ package mzm.gsp.homeland.main;
/*    */ 
/*    */ import mzm.gsp.cat.event.CatExploreEndArg;
/*    */ 
/*    */ public class PRestoreCatIntoYardOnExploreEnd extends mzm.gsp.cat.event.CatExploreEndProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception {
/*  8 */     HomelandManager.catExploreEnd(((CatExploreEndArg)this.arg).roleid, ((CatExploreEndArg)this.arg).catid);
/*    */     
/* 10 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\main\PRestoreCatIntoYardOnExploreEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
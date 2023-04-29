/*    */ package mzm.gsp.homeland.main;
/*    */ 
/*    */ import mzm.gsp.cat.event.SendCatToExploreArg;
/*    */ 
/*    */ public class POnCatOut extends mzm.gsp.cat.event.SendCatToExploreProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/*  9 */     HomelandManager.catExploreOut(((SendCatToExploreArg)this.arg).roleid, ((SendCatToExploreArg)this.arg).catid);
/* 10 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\main\POnCatOut.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
/*    */ package mzm.gsp.homeland.main;
/*    */ 
/*    */ import mzm.gsp.homeland.event.MysteryVisitorDisappearArg;
/*    */ 
/*    */ public class POnMysteryVisitorDisappear extends mzm.gsp.homeland.event.MysteryVisitorDisappearProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/*  9 */     HomelandManager.mysteryVisitorDisappear(((MysteryVisitorDisappearArg)this.arg).roleid);
/* 10 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\main\POnMysteryVisitorDisappear.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
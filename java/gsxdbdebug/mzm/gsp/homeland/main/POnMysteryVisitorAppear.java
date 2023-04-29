/*    */ package mzm.gsp.homeland.main;
/*    */ 
/*    */ import mzm.gsp.homeland.event.MysteryVisitorAppearArg;
/*    */ 
/*    */ public class POnMysteryVisitorAppear extends mzm.gsp.homeland.event.MysteryVisitorAppearProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/*  9 */     HomelandManager.mysteryVisitorAppear(((MysteryVisitorAppearArg)this.arg).roleid);
/* 10 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\main\POnMysteryVisitorAppear.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
/*    */ package mzm.gsp.homeland.main;
/*    */ 
/*    */ import mzm.gsp.children.event.ChildUndressFashionArg;
/*    */ 
/*    */ public class POnChildUndressFashionChanged extends mzm.gsp.children.event.ChildUndressFashionProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/*  9 */     HomelandManager.childUnDressedFashioned(((ChildUndressFashionArg)this.arg).roleid, ((ChildUndressFashionArg)this.arg).childid, ((ChildUndressFashionArg)this.arg).fashionCfgid);
/* 10 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\main\POnChildUndressFashionChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
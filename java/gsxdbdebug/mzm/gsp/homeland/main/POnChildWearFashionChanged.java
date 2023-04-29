/*    */ package mzm.gsp.homeland.main;
/*    */ 
/*    */ import mzm.gsp.children.event.ChildWearFashionArg;
/*    */ 
/*    */ public class POnChildWearFashionChanged extends mzm.gsp.children.event.ChildWearFashionProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/*  9 */     HomelandManager.childWearOnFashion(((ChildWearFashionArg)this.arg).roleid, ((ChildWearFashionArg)this.arg).childid, ((ChildWearFashionArg)this.arg).oldFashionCfgid, ((ChildWearFashionArg)this.arg).newFashionCfgid);
/* 10 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\main\POnChildWearFashionChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
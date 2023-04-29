/*    */ package mzm.gsp.homeland.main;
/*    */ 
/*    */ import mzm.gsp.children.event.ChildPeriodChangeArg;
/*    */ 
/*    */ public class POnChildPeriodChanged extends mzm.gsp.children.event.ChildPeriodChangeProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/*  9 */     HomelandManager.childChangePeriod(((ChildPeriodChangeArg)this.arg).roleId, ((ChildPeriodChangeArg)this.arg).childId);
/* 10 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\main\POnChildPeriodChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
/*    */ package mzm.gsp.homeland.main;
/*    */ 
/*    */ import mzm.gsp.children.event.ChildNameChangeArg;
/*    */ 
/*    */ public class POnChildNameChanged extends mzm.gsp.children.event.ChildNameChangeProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/*  9 */     HomelandManager.childChangeName(((ChildNameChangeArg)this.arg).roleId, ((ChildNameChangeArg)this.arg).childId);
/* 10 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\main\POnChildNameChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
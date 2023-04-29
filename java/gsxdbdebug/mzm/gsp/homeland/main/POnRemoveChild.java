/*    */ package mzm.gsp.homeland.main;
/*    */ 
/*    */ import mzm.gsp.children.event.RemoveChildFromHomeArg;
/*    */ 
/*    */ public class POnRemoveChild extends mzm.gsp.children.event.RemoveChildFromHomeProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/*  9 */     HomelandManager.removeChild(((RemoveChildFromHomeArg)this.arg).roleId, ((RemoveChildFromHomeArg)this.arg).childId);
/* 10 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\main\POnRemoveChild.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
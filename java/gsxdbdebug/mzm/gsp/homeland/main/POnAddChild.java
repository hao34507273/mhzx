/*    */ package mzm.gsp.homeland.main;
/*    */ 
/*    */ import mzm.gsp.children.event.AddChildIntoHomeArg;
/*    */ 
/*    */ public class POnAddChild extends mzm.gsp.children.event.AddChildIntoHomeProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/*  9 */     HomelandManager.addChild(((AddChildIntoHomeArg)this.arg).roleId, ((AddChildIntoHomeArg)this.arg).childId, ((AddChildIntoHomeArg)this.arg).mapCfgId, ((AddChildIntoHomeArg)this.arg).positionX, ((AddChildIntoHomeArg)this.arg).positionY, ((AddChildIntoHomeArg)this.arg).childAddHomeReason);
/* 10 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\main\POnAddChild.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
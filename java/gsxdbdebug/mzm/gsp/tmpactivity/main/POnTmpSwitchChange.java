/*    */ package mzm.gsp.tmpactivity.main;
/*    */ 
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.map.main.ControllerInterface;
/*    */ import mzm.gsp.open.event.OpenChangeComplexArg;
/*    */ import mzm.gsp.open.event.OpenChangeProcedure;
/*    */ 
/*    */ public class POnTmpSwitchChange
/*    */   extends OpenChangeProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     if (((OpenChangeComplexArg)this.arg).getType() != 52)
/*    */     {
/* 15 */       return false;
/*    */     }
/* 17 */     if (!ActivityInterface.isActivityOpen(TmpActivityManager.getActivityId()))
/*    */     {
/* 19 */       return false;
/*    */     }
/* 21 */     if (((OpenChangeComplexArg)this.arg).isOpen())
/*    */     {
/* 23 */       ControllerInterface.triggerController(TmpActivityManager.getNpcControllerId());
/*    */     }
/*    */     else
/*    */     {
/* 27 */       new POnActivityEnd().execute();
/*    */     }
/* 29 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\tmpactivity\main\POnTmpSwitchChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
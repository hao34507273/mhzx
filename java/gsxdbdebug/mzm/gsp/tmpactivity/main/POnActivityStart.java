/*    */ package mzm.gsp.tmpactivity.main;
/*    */ 
/*    */ import mzm.gsp.map.main.ControllerInterface;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnActivityStart
/*    */   extends LogicProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 22 */     if (OpenInterface.getOpenStatus(52))
/*    */     {
/* 24 */       ControllerInterface.triggerController(TmpActivityManager.getNpcControllerId());
/*    */     }
/*    */     
/* 27 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\tmpactivity\main\POnActivityStart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
/*    */ package mzm.gsp.drawcarnival.main;
/*    */ 
/*    */ import mzm.gsp.drawcarnival.confbean.SDrawCarnivalConsts;
/*    */ import mzm.gsp.open.event.OpenChangeComplexArg;
/*    */ import mzm.gsp.open.event.OpenChangeProcedure;
/*    */ 
/*    */ public class POnOpenChange
/*    */   extends OpenChangeProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 12 */     if (((OpenChangeComplexArg)this.arg).getType() != 592)
/*    */     {
/* 14 */       return false;
/*    */     }
/* 16 */     DrawCarnivalOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(SDrawCarnivalConsts.getInstance().ACTIVITY_ID), new PTriggerOrCollectChests(((OpenChangeComplexArg)this.arg).isOpen()));
/*    */     
/*    */ 
/* 19 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\drawcarnival\main\POnOpenChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
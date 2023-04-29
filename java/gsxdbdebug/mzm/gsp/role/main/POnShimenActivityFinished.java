/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import mzm.gsp.shimen.event.ShimenActivityArg;
/*    */ import mzm.gsp.shimen.event.ShimenActivityFinishedProcedure;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ 
/*    */ public class POnShimenActivityFinished
/*    */   extends ShimenActivityFinishedProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     RoleVigorManager.getInstance().awardAward(((ShimenActivityArg)this.arg).getRoleid(), 0, new TLogArg(LogReason.VIGOR_ADD__SHIMEN, 0));
/*    */     
/* 15 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\POnShimenActivityFinished.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
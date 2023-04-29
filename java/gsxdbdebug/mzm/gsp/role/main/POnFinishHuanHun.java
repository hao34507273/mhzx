/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import mzm.gsp.huanhun.event.FinishHuanHunArg;
/*    */ import mzm.gsp.huanhun.event.FinishHuanHunProcedure;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ 
/*    */ public class POnFinishHuanHun
/*    */   extends FinishHuanHunProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     RoleVigorManager.getInstance().awardAward(((FinishHuanHunArg)this.arg).getRoleId(), 7, new TLogArg(LogReason.VIGOR_ADD__HUANHUN, 0));
/*    */     
/* 15 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\POnFinishHuanHun.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
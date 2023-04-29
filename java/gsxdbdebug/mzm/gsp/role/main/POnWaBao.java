/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import mzm.gsp.baotu.event.WaBaoArg;
/*    */ import mzm.gsp.baotu.event.WaBaoProcedure;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ 
/*    */ public class POnWaBao
/*    */   extends WaBaoProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     RoleVigorManager.getInstance().awardAward(((WaBaoArg)this.arg).roleId, 4, new TLogArg(LogReason.VIGOR_ADD__WABAO, 0));
/* 14 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\POnWaBao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import mzm.gsp.jingji.event.JingjiActivityArg;
/*    */ import mzm.gsp.jingji.event.JingjiActivityFinishedProcedure;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ 
/*    */ public class POnJingjiActivityFinished
/*    */   extends JingjiActivityFinishedProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     RoleVigorManager.getInstance().awardAward(((JingjiActivityArg)this.arg).getRoleid(), 9, new TLogArg(LogReason.VIGOR_ADD__JINGJI, 0));
/*    */     
/* 15 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\POnJingjiActivityFinished.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
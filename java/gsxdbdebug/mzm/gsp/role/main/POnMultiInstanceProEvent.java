/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import mzm.gsp.instance.event.MultiInstanceProArg;
/*    */ import mzm.gsp.instance.event.MultiInstanceProEventProcedure;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ 
/*    */ public class POnMultiInstanceProEvent
/*    */   extends MultiInstanceProEventProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     if (!((MultiInstanceProArg)this.arg).isFirstTime)
/*    */     {
/* 15 */       return false;
/*    */     }
/* 17 */     RoleVigorManager.getInstance().awardAward(((MultiInstanceProArg)this.arg).roleid, 10, new TLogArg(LogReason.VIGOR_ADD__MULTI_INSTANCE, 0));
/*    */     
/* 19 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\POnMultiInstanceProEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
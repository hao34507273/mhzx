/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import mzm.gsp.instance.event.SingleFightArg;
/*    */ import mzm.gsp.instance.event.SingleInstanceFightEventProcedure;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ 
/*    */ public class POnSingleInstanceFightEvent
/*    */   extends SingleInstanceFightEventProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     if (!((SingleFightArg)this.arg).win)
/*    */     {
/* 15 */       return false;
/*    */     }
/* 17 */     RoleVigorManager.getInstance().awardAward(((SingleFightArg)this.arg).roleid, 8, new TLogArg(LogReason.VIGOR_ADD__SINGLE_INSTANCE, 0));
/*    */     
/* 19 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\POnSingleInstanceFightEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
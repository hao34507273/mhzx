/*    */ package mzm.gsp.corps.main;
/*    */ 
/*    */ import mzm.gsp.corps.confbean.CorpsConsts;
/*    */ import mzm.gsp.corps.event.LeaveCorpsEventArg;
/*    */ import mzm.gsp.corps.event.LeaveCorpsProcedure;
/*    */ import mzm.gsp.title.main.TitleInterface;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnLeaveCorps
/*    */   extends LeaveCorpsProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 18 */     TitleInterface.removeAppllation(((LeaveCorpsEventArg)this.arg).getRoleId(), CorpsConsts.getInstance().CORPS_APPELLATION_ID);
/* 19 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\main\POnLeaveCorps.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
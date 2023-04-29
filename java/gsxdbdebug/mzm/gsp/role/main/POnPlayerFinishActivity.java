/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import mzm.gsp.question.event.PlayerFinishActivityProcedure;
/*    */ import mzm.gsp.question.event.QuestionArg;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ 
/*    */ public class POnPlayerFinishActivity
/*    */   extends PlayerFinishActivityProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     RoleVigorManager.getInstance().awardAward(((QuestionArg)this.arg).roleId, 2, new TLogArg(LogReason.VIGOR_ADD__ZHUXIANQIYUAN, 0));
/*    */     
/* 15 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\POnPlayerFinishActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
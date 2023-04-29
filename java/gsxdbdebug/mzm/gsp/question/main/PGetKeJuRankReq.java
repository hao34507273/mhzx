/*    */ package mzm.gsp.question.main;
/*    */ 
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.question.CGetKeJuRankReq;
/*    */ import mzm.gsp.question.SKeJuRankRes;
/*    */ import mzm.gsp.question.confbean.KeJuQuestionConsts;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PGetKeJuRankReq
/*    */   extends AbsQuestionProcedure<CGetKeJuRankReq>
/*    */ {
/*    */   public PGetKeJuRankReq(CGetKeJuRankReq protocol)
/*    */   {
/* 17 */     super(protocol);
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 23 */     if (ActivityInterface.isActivityOpen(KeJuQuestionConsts.getInstance().ACTIVITY_ID))
/*    */     {
/* 25 */       return false;
/*    */     }
/* 27 */     SKeJuRankRes res = KeJuQuestionManager.getInstance().getKeJuRankRes();
/* 28 */     if (res == null)
/* 29 */       return false;
/* 30 */     OnlineManager.getInstance().send(this.roleId, res);
/* 31 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\main\PGetKeJuRankReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
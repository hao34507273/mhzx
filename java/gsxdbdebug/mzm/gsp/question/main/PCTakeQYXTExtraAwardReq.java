/*    */ package mzm.gsp.question.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.item.main.POfferLotteryResult;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PCTakeQYXTExtraAwardReq extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public PCTakeQYXTExtraAwardReq(long roleid)
/*    */   {
/* 13 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 19 */     if (!QYXTQuestionActivity.checkMutexStatus(this.roleid))
/*    */     {
/* 21 */       return false;
/*    */     }
/*    */     
/* 24 */     boolean ret = new POfferLotteryResult(this.roleid, 4).call();
/* 25 */     if (!ret) {
/* 26 */       GameServer.logger().info(String.format("[QYXT]PCTakeQYXTExtraAwardReq.processImp@lottery award false|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*    */     }
/*    */     
/* 29 */     return ret;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\main\PCTakeQYXTExtraAwardReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
/*    */ package mzm.gsp.flowerparade.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.FlowerParade;
/*    */ import xdb.Procedure;
/*    */ 
/*    */ public class PFlowerParadeCountDownEnd extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   final int activityId;
/*    */   
/*    */   public PFlowerParadeCountDownEnd(int activityId)
/*    */   {
/* 14 */     this.activityId = activityId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 21 */     long localid = mzm.gsp.GameServerInfoManager.getLocalId();
/* 22 */     FlowerParade xFlowerParade = xtable.Flowerparade.get(Long.valueOf(localid));
/* 23 */     if (xFlowerParade == null)
/*    */     {
/* 25 */       GameServer.logger().info(String.format("[flowerparade]PFlowerParadeCountDownEnd.processImp@count down end with xtable Flowerparade null|activityid=%d|localid=%d", new Object[] { Integer.valueOf(this.activityId), Long.valueOf(localid) }));
/*    */       
/*    */ 
/*    */ 
/* 29 */       return false;
/*    */     }
/* 31 */     xFlowerParade.setSessionidcountdown(0L);
/* 32 */     GameServer.logger().info(String.format("[flowerparade]PFlowerParadeCountDownEnd.processImp@count down end|paradeinstance=%d|activityid=%d", new Object[] { Long.valueOf(xFlowerParade.getFlowerinstanceid()), Integer.valueOf(this.activityId) }));
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 37 */     Procedure.execute(new PFlowerParadeMove(this.activityId));
/*    */     
/* 39 */     Procedure.execute(new PFlowerParadeUpdateFollowers(this.activityId));
/* 40 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\flowerparade\main\PFlowerParadeCountDownEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
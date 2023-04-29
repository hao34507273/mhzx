/*    */ package mzm.gsp.flowerparade.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import xbean.FlowerParade;
/*    */ 
/*    */ public class PFlowerParadeRestEnd extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final int activityId;
/*    */   
/*    */   public PFlowerParadeRestEnd(int activityId)
/*    */   {
/* 13 */     this.activityId = activityId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 19 */     long localid = GameServerInfoManager.getLocalId();
/* 20 */     FlowerParade xFlowerParade = xtable.Flowerparade.get(Long.valueOf(localid));
/* 21 */     if (xFlowerParade == null)
/*    */     {
/* 23 */       return false;
/*    */     }
/*    */     
/* 26 */     xFlowerParade.setSessionidrest(0L);
/* 27 */     int posIndex = xFlowerParade.getToposindex();
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 38 */     xdb.Procedure.execute(new PFlowerParadeMove(this.activityId));
/*    */     
/* 40 */     GameServer.logger().info(String.format("[flowerparade]PFlowerParadeRestEnd.processImp@rest end|activityid=%d|paradeinstanceid=%d|posIndex=posIndex", new Object[] { Integer.valueOf(this.activityId), Long.valueOf(xFlowerParade.getFlowerinstanceid()), Integer.valueOf(posIndex) }));
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 45 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\flowerparade\main\PFlowerParadeRestEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
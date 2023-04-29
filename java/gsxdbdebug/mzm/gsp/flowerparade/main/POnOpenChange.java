/*    */ package mzm.gsp.flowerparade.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.activity4.confbean.FlowerParadeConstCfg;
/*    */ import mzm.gsp.open.event.OpenChangeComplexArg;
/*    */ import mzm.gsp.open.event.OpenChangeProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class POnOpenChange extends OpenChangeProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     if (((OpenChangeComplexArg)this.arg).getType() != 518)
/*    */     {
/* 15 */       return false;
/*    */     }
/* 17 */     if (((OpenChangeComplexArg)this.arg).isOpen())
/*    */     {
/* 19 */       return true;
/*    */     }
/* 21 */     int activityId = FlowerParadeConstCfg.getInstance().activityId;
/* 22 */     GameServer.logger().info(String.format("[flowerparade]POnOpenChange.processImp@flowerparade open close|activityid=%d", new Object[] { Integer.valueOf(activityId) }));
/*    */     
/* 24 */     FlowerParadeManager.stopFlowerParade(activityId);
/* 25 */     FlowerParadeManager.onActivityEnd(activityId);
/* 26 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\flowerparade\main\POnOpenChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
/*    */ package mzm.gsp.online.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class PGM_ClearExtuteLoginQueue
/*    */   extends LogicProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 13 */     LoginAssistManager.getInstance().gm_clearExcuteLoginQueue();
/* 14 */     GameServer.logger().info("ExcuteLoginQueue size" + LoginAssistManager.getInstance().getExcuteLoginSize());
/* 15 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\online\main\PGM_ClearExtuteLoginQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
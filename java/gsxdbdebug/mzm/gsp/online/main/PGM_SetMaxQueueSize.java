/*    */ package mzm.gsp.online.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class PGM_SetMaxQueueSize extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final int maxQueueSize;
/*    */   
/*    */   public PGM_SetMaxQueueSize(int maxQueueSize)
/*    */   {
/* 12 */     this.maxQueueSize = maxQueueSize;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 18 */     if (this.maxQueueSize <= 0)
/*    */     {
/* 20 */       GameServer.logger().error(String.format("[gm]PGM_SetMaxQueueSize.processImp@maxQueueSize <= 0|maxQueueSize=%d", new Object[] { Integer.valueOf(this.maxQueueSize) }));
/*    */       
/* 22 */       return false;
/*    */     }
/*    */     
/* 25 */     LoginManager.getInstance().setQueueSize(this.maxQueueSize);
/* 26 */     GameServer.logger().info(String.format("[gm]PGM_SetMaxQueueSize.processImp@set maxQueueSize success|maxQueueSize=%d", new Object[] { Integer.valueOf(this.maxQueueSize) }));
/*    */     
/* 28 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\online\main\PGM_SetMaxQueueSize.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
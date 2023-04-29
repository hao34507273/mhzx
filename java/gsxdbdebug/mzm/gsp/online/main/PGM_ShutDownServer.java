/*    */ package mzm.gsp.online.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PGM_ShutDownServer
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final int delaySeconds;
/*    */   
/*    */   public PGM_ShutDownServer(int delaySeconds)
/*    */   {
/* 15 */     this.delaySeconds = delaySeconds;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 20 */     GameServer.stop(this.delaySeconds);
/*    */     
/* 22 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\online\main\PGM_ShutDownServer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
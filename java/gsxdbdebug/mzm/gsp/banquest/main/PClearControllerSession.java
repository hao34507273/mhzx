/*    */ package mzm.gsp.banquest.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xdb.Procedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PClearControllerSession
/*    */   extends Session
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PClearControllerSession(long interval, long roleId)
/*    */   {
/* 19 */     super(interval, roleId);
/* 20 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 26 */     Procedure.execute(new ClearRoleController(null));
/*    */   }
/*    */   
/*    */   private class ClearRoleController extends LogicProcedure
/*    */   {
/*    */     private ClearRoleController() {}
/*    */     
/*    */     protected boolean processImp() throws Exception
/*    */     {
/* 35 */       GameServer.logger().info(String.format("[banquest]ClearRoleController.processImp@ begin do clear controller!|roleId=%d", new Object[] { Long.valueOf(PClearControllerSession.this.roleId) }));
/*    */       
/*    */ 
/*    */ 
/* 39 */       BanquestManager.clearController(PClearControllerSession.this.roleId);
/* 40 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\banquest\main\PClearControllerSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
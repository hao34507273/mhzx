/*    */ package mzm.gsp.config.main;
/*    */ 
/*    */ import mzm.gsp.CfgManager;
/*    */ import mzm.gsp.GameServer;
/*    */ import xdb.Xdb;
/*    */ 
/*    */ public class POnConfigReloaded extends mzm.gsp.config.event.ConfigReloadedProcedure
/*    */ {
/*    */   static class RCleanOldConfigs implements Runnable
/*    */   {
/*    */     public void run()
/*    */     {
/* 13 */       CfgManager.getInstance().resetOldAll(false);
/*    */       
/* 15 */       GameServer.logger().info(String.format("[cfg]POnConfigReloaded.RCleanOldConfigs.run@clean old configs success", new Object[0]));
/*    */     }
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 22 */     Xdb.executor().execute(new RCleanOldConfigs());
/*    */     
/* 24 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\config\main\POnConfigReloaded.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
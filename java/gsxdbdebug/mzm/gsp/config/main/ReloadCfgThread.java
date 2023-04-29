/*    */ package mzm.gsp.config.main;
/*    */ 
/*    */ import mzm.event.TriggerEventsManger;
/*    */ import mzm.gsp.CfgManager;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.config.event.ConfigReloaded;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class ReloadCfgThread extends Thread
/*    */ {
/*    */   private static class RReloadCfg implements Runnable
/*    */   {
/*    */     private final boolean loadXml;
/*    */     
/*    */     public RReloadCfg(boolean loadXml)
/*    */     {
/* 17 */       this.loadXml = loadXml;
/*    */     }
/*    */     
/*    */ 
/*    */     public void run()
/*    */     {
/*    */       try
/*    */       {
/* 25 */         GameServer.logger().info(String.format("[cfg]ReloadCfgThread.RReloadCfg.run@begin reload all cfg|is_load_xml=%b", new Object[] { Boolean.valueOf(this.loadXml) }));
/*    */         
/*    */ 
/* 28 */         if (this.loadXml)
/*    */         {
/* 30 */           CfgManager.getInstance().reLoadAll(false);
/*    */         }
/*    */         else
/*    */         {
/* 34 */           CfgManager.getInstance().reLoadBny(false);
/*    */         }
/*    */         
/* 37 */         ConfigReloaded event = new ConfigReloaded();
/* 38 */         TriggerEventsManger.getInstance().triggerEventAtOnce(event, Long.valueOf(mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis()));
/*    */         
/* 40 */         GameServer.logger().info(String.format("[cfg]ReloadCfgThread.RReloadCfg.run@reload all cfg success|is_load_xml=%b", new Object[] { Boolean.valueOf(this.loadXml) }));
/*    */ 
/*    */       }
/*    */       catch (Exception e)
/*    */       {
/* 45 */         GameServer.logger().error(String.format("[cfg]ReloadCfgThread.RReloadCfg.run@load all cfg fail|is_load_xml=%b", new Object[] { Boolean.valueOf(this.loadXml) }), e);
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public ReloadCfgThread(boolean loadXml)
/*    */   {
/* 59 */     super(new RReloadCfg(loadXml));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\config\main\ReloadCfgThread.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
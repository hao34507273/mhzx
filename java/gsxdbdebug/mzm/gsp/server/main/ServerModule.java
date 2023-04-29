/*    */ package mzm.gsp.server.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.event.Module;
/*    */ import mzm.event.PostModuleInitListner;
/*    */ import mzm.gsp.GameServer;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ public class ServerModule
/*    */   implements Module, PostModuleInitListner
/*    */ {
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 15 */     if (AvailableStringArgs.init() < 0)
/*    */     {
/* 17 */       GameServer.logger().error("载入有效字符串检查配置失败");
/* 18 */       return -1;
/*    */     }
/*    */     
/* 21 */     ServerManager.init();
/* 22 */     ServerManager.initServerLever();
/*    */     
/* 24 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public int exit()
/*    */   {
/* 31 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public int cleanupForMerge()
/*    */   {
/* 38 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 45 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public void postInit()
/*    */   {
/* 51 */     new TlogServerStateObserver(ServerManager.getServerStateSynInteval());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\server\main\ServerModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
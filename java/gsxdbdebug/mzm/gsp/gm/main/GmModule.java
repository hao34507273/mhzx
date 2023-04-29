/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.event.Module;
/*    */ import mzm.gsp.GameServer;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class GmModule
/*    */   implements Module
/*    */ {
/*    */   public int cleanupForMerge()
/*    */   {
/* 13 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int exit()
/*    */   {
/* 19 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 25 */     if (GMAuthManager.init(GameServer.getGamedataDir() + "/" + (String)envs.get("gmauthfile")) < 0)
/*    */     {
/* 27 */       return -1;
/*    */     }
/*    */     
/* 30 */     if (GMDebugCmdManager.init(GameServer.getGamedataDir() + "/" + (String)envs.get("gmdebugfile")) < 0)
/*    */     {
/* 32 */       return -1;
/*    */     }
/*    */     
/* 35 */     String str = System.getProperty("com.zulong.mhzx.allgmon");
/* 36 */     if (str != null)
/*    */     {
/* 38 */       GmManager.getInstance().openDebugEnv();
/* 39 */       GameServer.logger().warn("所有人都有GM权限!");
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 45 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 51 */     return 0;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\GmModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
/*    */ package mzm.gsp.npc.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.event.Module;
/*    */ import mzm.event.PostModuleInitListner;
/*    */ 
/*    */ public class NpcModule
/*    */   implements Module, PostModuleInitListner
/*    */ {
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 12 */     NpcManager.init();
/*    */     
/* 14 */     NpcTradeManager.init();
/* 15 */     NpcServiceManager.init();
/* 16 */     return 0;
/*    */   }
/*    */   
/*    */   public int exit()
/*    */   {
/* 21 */     return 0;
/*    */   }
/*    */   
/*    */   public int cleanupForMerge()
/*    */   {
/* 26 */     return 0;
/*    */   }
/*    */   
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 31 */     return 0;
/*    */   }
/*    */   
/*    */   public void postInit()
/*    */   {
/* 36 */     NpcTradeManager.postInit();
/* 37 */     NpcServiceManager.postInit();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\npc\main\NpcModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
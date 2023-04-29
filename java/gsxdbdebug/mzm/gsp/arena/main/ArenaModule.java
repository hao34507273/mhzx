/*    */ package mzm.gsp.arena.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.event.Module;
/*    */ import mzm.event.PostModuleInitListner;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ArenaModule
/*    */   implements Module, PostModuleInitListner
/*    */ {
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 19 */     ArenaManager.init();
/*    */     
/*    */ 
/* 22 */     ActivityInterface.registerActivityByLogicType(21, new ArenaActivityHandler());
/*    */     
/* 24 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int exit()
/*    */   {
/* 30 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int cleanupForMerge()
/*    */   {
/* 36 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 42 */     return 0;
/*    */   }
/*    */   
/*    */   public void postInit()
/*    */   {
/* 47 */     ArenaConfigManager.getInstance().postInit();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\arena\main\ArenaModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
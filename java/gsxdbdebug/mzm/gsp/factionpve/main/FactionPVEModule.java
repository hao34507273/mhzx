/*    */ package mzm.gsp.factionpve.main;
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
/*    */ 
/*    */ public class FactionPVEModule
/*    */   implements Module, PostModuleInitListner
/*    */ {
/*    */   public int cleanupForMerge()
/*    */   {
/* 20 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int exit()
/*    */   {
/* 26 */     return 0;
/*    */   }
/*    */   
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 31 */     FactionPVEManager.init();
/*    */     
/* 33 */     ActivityInterface.registerActivityByLogicType(90, new FactionPVEActivityHandler());
/*    */     
/*    */ 
/* 36 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 42 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public void postInit()
/*    */   {
/* 48 */     new RInitAllFactionPVE().run();
/*    */     
/* 50 */     new WeekBeginRemindObserver();
/*    */     
/* 52 */     new WeekEndRemindObserver();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\factionpve\main\FactionPVEModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
/*    */ package mzm.gsp.grow.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.event.Module;
/*    */ import mzm.event.PostModuleInitListner;
/*    */ import mzm.gsp.grow.LevelGuide.LevelGuideManager;
/*    */ import mzm.gsp.grow.daytarget.DayTargetManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GrowModule
/*    */   implements Module, PostModuleInitListner
/*    */ {
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 20 */     TargetManager.initSEveryDayTargetCfg();
/* 21 */     LevelGuideManager.levelGuideInit();
/* 22 */     DayTargetManager.init();
/* 23 */     return 0;
/*    */   }
/*    */   
/*    */   public int exit()
/*    */   {
/* 28 */     return 0;
/*    */   }
/*    */   
/*    */   public int cleanupForMerge()
/*    */   {
/* 33 */     return 0;
/*    */   }
/*    */   
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 38 */     return 0;
/*    */   }
/*    */   
/*    */   public void postInit() {
/*    */     try {
/*    */       
/*    */     }
/*    */     catch (Exception e) {
/* 46 */       throw new RuntimeException(e);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grow\main\GrowModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
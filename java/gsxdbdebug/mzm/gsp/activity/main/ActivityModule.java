/*    */ package mzm.gsp.activity.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.event.Module;
/*    */ import mzm.event.PostModuleInitListner;
/*    */ 
/*    */ public class ActivityModule
/*    */   implements Module, PostModuleInitListner
/*    */ {
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 12 */     boolean init = ActivityManager.init();
/* 13 */     if (!init) {
/* 14 */       throw new RuntimeException("活动模块启动出错!");
/*    */     }
/* 16 */     ActivityLogStatus.checkActivityLogStatus();
/* 17 */     return 0;
/*    */   }
/*    */   
/*    */   public int exit()
/*    */   {
/* 22 */     return 0;
/*    */   }
/*    */   
/*    */   public int cleanupForMerge()
/*    */   {
/* 27 */     return 0;
/*    */   }
/*    */   
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 32 */     return 0;
/*    */   }
/*    */   
/*    */   public void postInit() {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\main\ActivityModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
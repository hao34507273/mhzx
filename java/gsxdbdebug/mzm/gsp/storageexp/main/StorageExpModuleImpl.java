/*    */ package mzm.gsp.storageexp.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.event.Module;
/*    */ import mzm.event.PostModuleInitListner;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.storageexp.activity.LostActivityManager;
/*    */ import mzm.gsp.storageexp.activity.LostExpActivityHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class StorageExpModuleImpl
/*    */   implements Module, PostModuleInitListner
/*    */ {
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 21 */     ActivityInterface.registerActivityByLogicType(66, new LostExpActivityHandler());
/* 22 */     LostActivityManager.getInstance().rgAllActivityHandler();
/* 23 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int exit()
/*    */   {
/* 29 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int cleanupForMerge()
/*    */   {
/* 35 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 41 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public void postInit()
/*    */   {
/* 47 */     StorageExpManager.getInstance().init();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\storageexp\main\StorageExpModuleImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
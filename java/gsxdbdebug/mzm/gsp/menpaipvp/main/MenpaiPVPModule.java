/*    */ package mzm.gsp.menpaipvp.main;
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
/*    */ public class MenpaiPVPModule
/*    */   implements Module, PostModuleInitListner
/*    */ {
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 20 */     MenpaiPVPConfigManager.getInstance().init();
/*    */     
/*    */ 
/* 23 */     ActivityInterface.registerActivityByLogicType(19, new MenpaiPVPActivityHandler());
/*    */     
/* 25 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int exit()
/*    */   {
/* 31 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int cleanupForMerge()
/*    */   {
/* 37 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 43 */     return 0;
/*    */   }
/*    */   
/*    */   public void postInit()
/*    */   {
/* 48 */     MenpaiPVPConfigManager.getInstance().postInit();
/*    */     
/* 50 */     MenpaiPVPManager.init();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaipvp\main\MenpaiPVPModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
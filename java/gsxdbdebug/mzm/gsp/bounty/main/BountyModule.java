/*    */ package mzm.gsp.bounty.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.event.Module;
/*    */ import mzm.event.PostModuleInitListner;
/*    */ import mzm.gsp.activitycompensate.main.ActivityCompensateInterface;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BountyModule
/*    */   implements Module, PostModuleInitListner
/*    */ {
/*    */   public void postInit()
/*    */   {
/* 16 */     BountyManager.check();
/*    */   }
/*    */   
/*    */ 
/*    */   public int init(Map<String, String> envs)
/*    */   {
/*    */     try
/*    */     {
/* 24 */       BountyManager.initCfg();
/*    */     }
/*    */     catch (Exception e)
/*    */     {
/* 28 */       throw new RuntimeException(e);
/*    */     }
/*    */     
/* 31 */     ActivityCompensateInterface.registerCompensateHandler(3, new BountyActivityInit());
/* 32 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public int exit()
/*    */   {
/* 39 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public int cleanupForMerge()
/*    */   {
/* 46 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 53 */     return 0;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bounty\main\BountyModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
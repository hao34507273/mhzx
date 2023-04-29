/*    */ package mzm.gsp.singletask.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.event.Module;
/*    */ import mzm.event.PostModuleInitListner;
/*    */ import mzm.gsp.activity.confbean.SingleTaskCfg;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.map.main.ControllerInterface;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SingleTaskModule
/*    */   implements Module, PostModuleInitListner
/*    */ {
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 25 */     ActivityInterface.registerActivityByLogicType(52, new PSingleTaskActivityInit());
/* 26 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int exit()
/*    */   {
/* 32 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int cleanupForMerge()
/*    */   {
/* 38 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 44 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void postInit()
/*    */   {
/* 51 */     for (SingleTaskCfg cfg : SingleTaskCfg.getAll().values())
/*    */     {
/* 53 */       if ((!ActivityInterface.isActivityOpen(cfg.activityId)) || (!OpenInterface.getOpenStatus(cfg.openId)))
/*    */       {
/* 55 */         ControllerInterface.collectController(cfg.controller);
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singletask\main\SingleTaskModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
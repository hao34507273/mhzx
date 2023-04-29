/*    */ package mzm.gsp.zhenyao.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.event.Module;
/*    */ import mzm.event.PostModuleInitListner;
/*    */ import mzm.gsp.activity.confbean.ZhenYaoActivityCfgConsts;
/*    */ import mzm.gsp.activitycompensate.main.ActivityCompensateInterface;
/*    */ import mzm.gsp.task.main.TaskInterface;
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
/*    */ 
/*    */ 
/*    */ public class ZhenyaoModule
/*    */   implements Module, PostModuleInitListner
/*    */ {
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 26 */     ZhenyaoManager.init();
/*    */     
/* 28 */     ActivityCompensateInterface.registerCompensateHandler(1, new ZhenYaoCompensateHandler());
/*    */     
/* 30 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int exit()
/*    */   {
/* 36 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int cleanupForMerge()
/*    */   {
/* 42 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 48 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public void postInit()
/*    */   {
/* 54 */     TaskInterface.setFightType(ZhenYaoActivityCfgConsts.getInstance().GRAPH_ID, 10);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\zhenyao\main\ZhenyaoModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
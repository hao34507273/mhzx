/*    */ package mzm.gsp.task.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.event.Module;
/*    */ import mzm.event.PostModuleInitListner;
/*    */ import mzm.gsp.task.ban.BanGraphInterface;
/*    */ import mzm.gsp.task.condition.ConditionEnum;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TaskModule
/*    */   implements Module, PostModuleInitListner
/*    */ {
/* 21 */   private static final Logger logger = Logger.getLogger(TaskModule.class);
/*    */   
/*    */ 
/*    */ 
/*    */   public int init(Map<String, String> envs)
/*    */   {
/*    */     try
/*    */     {
/* 29 */       TaskManager.getInstance().init();
/* 30 */       TaskSetManager.getInstance().init();
/* 31 */       GraphManager.getInstance().init();
/* 32 */       BanGraphInterface.initCacheBanGraphInfo();
/* 33 */       logger.info("初始化任务模块成功!");
/*    */     }
/*    */     catch (Exception e)
/*    */     {
/* 37 */       logger.error("任务模块出错", e);
/* 38 */       throw new RuntimeException("任务模块出错");
/*    */     }
/* 40 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int exit()
/*    */   {
/* 46 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int cleanupForMerge()
/*    */   {
/* 52 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 58 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public void postInit()
/*    */   {
/* 64 */     TaskManager.getInstance().checkCfg();
/* 65 */     TaskSetManager.getInstance().checkCfg();
/* 66 */     GraphManager.getInstance().checkCfg();
/* 67 */     ConditionEnum.check();
/* 68 */     if (!TaskNpcManager.getInstance().checkRegisterComplete())
/*    */     {
/* 70 */       throw new RuntimeException("任务NPC类id注册检查报错！详情查看Error日志！");
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\main\TaskModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
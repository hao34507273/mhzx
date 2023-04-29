/*    */ package mzm.gsp.redgift.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.event.Module;
/*    */ import mzm.event.PostModuleInitListner;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RedGiftActivityModule
/*    */   implements Module, PostModuleInitListner
/*    */ {
/* 14 */   private static final Logger logger = Logger.getLogger(RedGiftActivityModule.class);
/*    */   
/*    */ 
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 19 */     ActivityInterface.registerActivityByLogicType(39);
/* 20 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int exit()
/*    */   {
/* 26 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int cleanupForMerge()
/*    */   {
/* 32 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 38 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public void postInit()
/*    */   {
/* 44 */     RedGiftManager.postInit();
/* 45 */     logger.info("初始化红包模块成功!");
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\redgift\main\RedGiftActivityModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
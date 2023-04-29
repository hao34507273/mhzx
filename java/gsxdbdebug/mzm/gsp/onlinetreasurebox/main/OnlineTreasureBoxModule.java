/*    */ package mzm.gsp.onlinetreasurebox.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.event.Module;
/*    */ import mzm.event.PostModuleInitListner;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ public class OnlineTreasureBoxModule
/*    */   implements Module, PostModuleInitListner
/*    */ {
/* 12 */   private static final Logger logger = Logger.getLogger(OnlineTreasureBoxModule.class);
/*    */   
/*    */ 
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 17 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int exit()
/*    */   {
/* 23 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int cleanupForMerge()
/*    */   {
/* 29 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 35 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public void postInit()
/*    */   {
/* 41 */     OnlineTreasureBoxManager.postInit();
/* 42 */     logger.info("在线宝箱奖励初始化!");
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\onlinetreasurebox\main\OnlineTreasureBoxModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
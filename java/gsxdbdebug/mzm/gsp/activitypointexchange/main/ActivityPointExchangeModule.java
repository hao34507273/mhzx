/*    */ package mzm.gsp.activitypointexchange.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.event.Module;
/*    */ import mzm.event.PostModuleInitListner;
/*    */ 
/*    */ 
/*    */ public class ActivityPointExchangeModule
/*    */   implements Module, PostModuleInitListner
/*    */ {
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 13 */     ActivityPointExchangeManager.loadGlobalInfoMapFromDB();
/*    */     
/* 15 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int exit()
/*    */   {
/* 21 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int cleanupForMerge()
/*    */   {
/* 27 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 33 */     return 0;
/*    */   }
/*    */   
/*    */   public void postInit() {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activitypointexchange\main\ActivityPointExchangeModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
/*    */ package mzm.gsp.banquest.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.event.Module;
/*    */ import mzm.event.PostModuleInitListner;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BanquestModule
/*    */   implements Module, PostModuleInitListner
/*    */ {
/*    */   public void postInit() {}
/*    */   
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 20 */     BanquestManager.initBanquestModule();
/* 21 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public int exit()
/*    */   {
/* 28 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public int cleanupForMerge()
/*    */   {
/* 35 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 42 */     return 0;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\banquest\main\BanquestModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
/*    */ package mzm.gsp.zhenfa.main;
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
/*    */ 
/*    */ public class ZhenfaModule
/*    */   implements Module, PostModuleInitListner
/*    */ {
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 19 */     ZhenfaManager.init();
/* 20 */     return 0;
/*    */   }
/*    */   
/*    */   public int exit()
/*    */   {
/* 25 */     return 0;
/*    */   }
/*    */   
/*    */   public int cleanupForMerge()
/*    */   {
/* 30 */     return 0;
/*    */   }
/*    */   
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 35 */     return 0;
/*    */   }
/*    */   
/*    */   public void postInit() {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\zhenfa\main\ZhenfaModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
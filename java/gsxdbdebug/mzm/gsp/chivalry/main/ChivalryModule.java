/*    */ package mzm.gsp.chivalry.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.event.Module;
/*    */ import mzm.event.PostModuleInitListner;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ChivalryModule
/*    */   implements Module, PostModuleInitListner
/*    */ {
/*    */   public void postInit()
/*    */   {
/*    */     try
/*    */     {
/*    */       
/*    */     }
/*    */     catch (Exception e)
/*    */     {
/* 20 */       throw new RuntimeException(e);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 27 */     ChivalryManager.initCfg();
/* 28 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public int exit()
/*    */   {
/* 35 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public int cleanupForMerge()
/*    */   {
/* 42 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 49 */     return 0;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chivalry\main\ChivalryModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
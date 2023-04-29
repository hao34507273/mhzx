/*    */ package mzm.gsp.sensitive.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.event.Module;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SensitiveModule
/*    */   implements Module
/*    */ {
/*    */   public int cleanupForMerge()
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
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 28 */     SensitiveArgs.init();
/* 29 */     SensitiveManager.getInstance().init();
/*    */     
/* 31 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 37 */     return 0;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\sensitive\main\SensitiveModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
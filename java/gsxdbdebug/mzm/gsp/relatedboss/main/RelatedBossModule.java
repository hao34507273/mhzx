/*    */ package mzm.gsp.relatedboss.main;
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
/*    */ 
/*    */ public class RelatedBossModule
/*    */   implements Module
/*    */ {
/*    */   public int cleanupForMerge()
/*    */   {
/* 18 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int exit()
/*    */   {
/* 24 */     return 0;
/*    */   }
/*    */   
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 29 */     RelatedBossManager.init();
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


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\relatedboss\main\RelatedBossModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
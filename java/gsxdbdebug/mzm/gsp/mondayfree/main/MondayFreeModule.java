/*    */ package mzm.gsp.mondayfree.main;
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
/*    */ public class MondayFreeModule
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
/* 28 */     MondayFreeManager.init();
/* 29 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 35 */     return 0;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mondayfree\main\MondayFreeModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
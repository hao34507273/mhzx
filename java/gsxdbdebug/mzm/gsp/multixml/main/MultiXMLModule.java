/*    */ package mzm.gsp.multixml.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.event.Module;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MultiXMLModule
/*    */   implements Module
/*    */ {
/*    */   public int cleanupForMerge()
/*    */   {
/* 13 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int exit()
/*    */   {
/* 19 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 25 */     MultiXMLManager.init();
/* 26 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 32 */     return 0;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\multixml\main\MultiXMLModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
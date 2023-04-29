/*    */ package mzm.gsp.seasontask.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.event.Module;
/*    */ import mzm.event.PostModuleInitListner;
/*    */ 
/*    */ public class SeasontaskModule
/*    */   implements Module, PostModuleInitListner
/*    */ {
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 12 */     SummerTaskManager.init();
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
/*    */   public int cleanupForMerge()
/*    */   {
/* 25 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 31 */     return 0;
/*    */   }
/*    */   
/*    */   public void postInit()
/*    */   {
/* 36 */     SummerTaskManager.check();
/* 37 */     SummerTaskManager.process();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\seasontask\main\SeasontaskModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
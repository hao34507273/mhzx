/*    */ package mzm.gsp.circletask.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.event.Module;
/*    */ 
/*    */ 
/*    */ public class CircleTaskModule
/*    */   implements Module
/*    */ {
/*    */   public int init(Map<String, String> envs)
/*    */   {
/*    */     try
/*    */     {
/* 14 */       CircleTaskManager.getInstance().init();
/*    */     } catch (Exception e) {
/* 16 */       throw new RuntimeException(e);
/*    */     }
/* 18 */     return 0;
/*    */   }
/*    */   
/*    */   public int exit()
/*    */   {
/* 23 */     return 0;
/*    */   }
/*    */   
/*    */   public int cleanupForMerge()
/*    */   {
/* 28 */     return 0;
/*    */   }
/*    */   
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 33 */     return 0;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\circletask\main\CircleTaskModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
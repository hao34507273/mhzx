/*    */ package mzm.gsp.timer.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.event.Module;
/*    */ 
/*    */ public class TimerModule implements Module
/*    */ {
/*    */   public int init(Map<String, String> argvs)
/*    */   {
/* 10 */     TimerArgs.init();
/*    */     
/* 12 */     TimerManager.init();
/*    */     
/*    */ 
/* 15 */     DiskSpaceChecker.init();
/*    */     
/* 17 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int exit()
/*    */   {
/* 23 */     TimerManager.exit();
/*    */     
/* 25 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int cleanupForMerge()
/*    */   {
/* 36 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 42 */     return 0;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\timer\main\TimerModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
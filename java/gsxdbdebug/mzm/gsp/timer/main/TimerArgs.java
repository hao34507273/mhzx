/*    */ package mzm.gsp.timer.main;
/*    */ 
/*    */ import mzm.gsp.confConverter.ConfManager;
/*    */ 
/*    */ 
/*    */ class TimerArgs
/*    */ {
/*    */   private static volatile TimerArgs instance;
/*    */   int timerInterval;
/*    */   int taskPollInterval;
/*    */   int removeInvalidInterval;
/*    */   
/*    */   static TimerArgs getInstance()
/*    */   {
/* 15 */     if (instance == null) {
/* 16 */       synchronized (TimerArgs.class) {
/* 17 */         if (instance == null) {
/* 18 */           init();
/*    */         }
/*    */       }
/*    */     }
/* 22 */     return instance;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static void init()
/*    */   {
/* 31 */     instance = (TimerArgs)ConfManager.getInstance().getconf("mzm.gsp.timer.main.TimerArgs");
/* 32 */     if (instance == null) {
/* 33 */       throw new RuntimeException("TimeArgs文件不存在！");
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\timer\main\TimerArgs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
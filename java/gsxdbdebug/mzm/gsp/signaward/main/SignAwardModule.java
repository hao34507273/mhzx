/*    */ package mzm.gsp.signaward.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.event.Module;
/*    */ import mzm.event.PostModuleInitListner;
/*    */ import mzm.gsp.signaward.confbean.SignAwardCfgConsts;
/*    */ import mzm.gsp.timer.main.DateObserver.MyDate;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SignAwardModule
/*    */   implements Module, PostModuleInitListner
/*    */ {
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 16 */     SignAwardManager.init();
/*    */     
/* 18 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int exit()
/*    */   {
/* 24 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int cleanupForMerge()
/*    */   {
/* 30 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 36 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void postInit()
/*    */   {
/* 43 */     DateObserver.MyDate dayDate = new DateObserver.MyDate(-1, -1, -1, 0);
/* 44 */     new DayOberver(dayDate);
/*    */     
/* 46 */     new OnlineTimeObserver(SignAwardCfgConsts.getInstance().ONLINE_TIME_INTERVAL);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\signaward\main\SignAwardModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
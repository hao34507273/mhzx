/*    */ package mzm.gsp.jingji.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.event.Module;
/*    */ import mzm.event.PostModuleInitListner;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.activitycompensate.main.ActivityCompensateInterface;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class JingjiModule
/*    */   implements Module, PostModuleInitListner
/*    */ {
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 17 */     JingjiManager.init();
/*    */     
/* 19 */     JingJiRankManager.init();
/*    */     
/* 21 */     ActivityInterface.registerActivityByLogicType(22, new JingjiActivityInit());
/*    */     
/* 23 */     ActivityCompensateInterface.registerCompensateHandler(22, new JingjiCompensateHandler());
/*    */     
/* 25 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int exit()
/*    */   {
/* 31 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int cleanupForMerge()
/*    */   {
/* 37 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 43 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public void postInit()
/*    */   {
/* 49 */     long interval = JingjiManager.computeSeasonObserverInterval();
/* 50 */     new JingjiSeasonObserver(interval);
/*    */     
/* 52 */     FightMatchManager.init();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\jingji\main\JingjiModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
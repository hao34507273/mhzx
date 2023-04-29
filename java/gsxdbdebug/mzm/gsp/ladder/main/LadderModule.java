/*    */ package mzm.gsp.ladder.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.event.Module;
/*    */ import mzm.event.PostModuleInitListner;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ 
/*    */ 
/*    */ public class LadderModule
/*    */   implements Module, PostModuleInitListner
/*    */ {
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 14 */     int sessionEndDelayReportSec = Integer.parseInt(((String)envs.get("sessionEndDelayReportSec")).trim());
/* 15 */     LadderManager.sessionEndDelayReportSec = sessionEndDelayReportSec;
/* 16 */     ActivityInterface.registerActivityByLogicType(61, new LadderHandler());
/* 17 */     LadderManager.init();
/* 18 */     LadderRankManager.getInstance().init();
/* 19 */     return 0;
/*    */   }
/*    */   
/*    */   public int exit()
/*    */   {
/* 24 */     return 0;
/*    */   }
/*    */   
/*    */   public int cleanupForMerge()
/*    */   {
/* 29 */     return 0;
/*    */   }
/*    */   
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 34 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public void postInit()
/*    */   {
/* 40 */     LadderRankManager.getInstance().postInit();
/* 41 */     LadderManager.postInit();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ladder\main\LadderModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
/*    */ package mzm.gsp.qmhw.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.event.Module;
/*    */ import mzm.event.PostModuleInitListner;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ import xbean.QMHWActivity;
/*    */ import xtable.Qmhw;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class QMHWModule
/*    */   implements Module, PostModuleInitListner
/*    */ {
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 20 */     QMHWManager.init();
/* 21 */     QMHWChart.init();
/* 22 */     ActivityInterface.registerActivityByLogicType(38, new QMHWActivityHandler());
/* 23 */     return 0;
/*    */   }
/*    */   
/*    */   public int exit()
/*    */   {
/* 28 */     return 0;
/*    */   }
/*    */   
/*    */   public int cleanupForMerge()
/*    */   {
/* 33 */     return 0;
/*    */   }
/*    */   
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 38 */     return 0;
/*    */   }
/*    */   
/*    */   public void postInit()
/*    */   {
/* 43 */     QMHWActivity xQmhwActivity = Qmhw.select(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 44 */     if (xQmhwActivity == null) {
/* 45 */       return;
/*    */     }
/* 47 */     if (xQmhwActivity.getHandleresult() == 1) {
/* 48 */       NoneRealTimeTaskManager.getInstance().addTask(new PQMHWEndResult(-1L, false));
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qmhw\main\QMHWModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
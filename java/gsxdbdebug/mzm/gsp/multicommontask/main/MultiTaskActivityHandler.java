/*    */ package mzm.gsp.multicommontask.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.activity.main.ActivityHandler;
/*    */ import mzm.gsp.activity.main.ActivityHandler.ActivityStartType;
/*    */ import mzm.gsp.activity3.confbean.SMultiLineTaskCfg;
/*    */ import mzm.gsp.map.main.ControllerInterface;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.task.main.TaskInterface;
/*    */ import xbean.AllMultiTaskInfo;
/*    */ import xbean.CommonMultiTaskInfo;
/*    */ import xbean.Pod;
/*    */ import xtable.Role2commonmultiinfo;
/*    */ 
/*    */ public class MultiTaskActivityHandler implements ActivityHandler
/*    */ {
/*    */   public void initData(String userid, long roleId, int turn, int activityid)
/*    */   {
/* 19 */     AllMultiTaskInfo xAllInfos = Role2commonmultiinfo.get(Long.valueOf(roleId));
/* 20 */     if (xAllInfos == null)
/*    */     {
/* 22 */       Role2commonmultiinfo.insert(Long.valueOf(roleId), xAllInfos = Pod.newAllMultiTaskInfo());
/*    */     }
/* 24 */     CommonMultiTaskInfo xActivityInfo = (CommonMultiTaskInfo)xAllInfos.getActivity2info().get(Integer.valueOf(activityid));
/* 25 */     if (xActivityInfo == null)
/*    */     {
/* 27 */       xAllInfos.getActivity2info().put(Integer.valueOf(activityid), xActivityInfo = Pod.newCommonMultiTaskInfo());
/*    */     }
/*    */     
/* 30 */     xActivityInfo.setTurn(0);
/* 31 */     xActivityInfo.getFinishsteps().clear();
/*    */     
/* 33 */     SMultiLineTaskCfg cfg = SMultiLineTaskCfg.get(activityid);
/* 34 */     if (cfg != null)
/*    */     {
/* 36 */       TaskInterface.closeActivityGraphWithoutEvent(roleId, cfg.graphId);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public mzm.gsp.award.main.AwardReason getRecommendAwardReason()
/*    */   {
/* 44 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public java.util.List<mzm.gsp.activity.main.ActivityStage> getActivityStages()
/*    */   {
/* 51 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */   public void onActivityStart(ActivityHandler.ActivityStartType activityStartType, int activityid)
/*    */   {
/* 57 */     SMultiLineTaskCfg cfg = SMultiLineTaskCfg.get(activityid);
/* 58 */     if (cfg == null)
/*    */     {
/* 60 */       return;
/*    */     }
/* 62 */     if (!OpenInterface.getOpenStatus(cfg.openId))
/*    */     {
/* 64 */       return;
/*    */     }
/* 66 */     ControllerInterface.triggerController(cfg.controller);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void onActivityStageStart(int stage, boolean startAgain, int activityid) {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void onActivityEnd(int activityid)
/*    */   {
/* 79 */     SMultiLineTaskCfg cfg = SMultiLineTaskCfg.get(activityid);
/* 80 */     if (cfg == null)
/*    */     {
/* 82 */       return;
/*    */     }
/* 84 */     ControllerInterface.collectController(cfg.controller);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\multicommontask\main\MultiTaskActivityHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
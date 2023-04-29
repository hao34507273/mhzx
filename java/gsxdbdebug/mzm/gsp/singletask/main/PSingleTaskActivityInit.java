/*    */ package mzm.gsp.singletask.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.activity.confbean.SingleTaskCfg;
/*    */ import mzm.gsp.activity.main.ActivityHandler;
/*    */ import mzm.gsp.activity.main.ActivityHandler.ActivityStartType;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.task.main.TaskInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.AllActivityInfo;
/*    */ import xbean.Pod;
/*    */ import xbean.SingleActivityInfo;
/*    */ import xtable.Role2singleinfo;
/*    */ 
/*    */ public class PSingleTaskActivityInit implements ActivityHandler
/*    */ {
/*    */   public void initData(String userId, long roleId, int turn, int activityid)
/*    */   {
/* 20 */     AllActivityInfo xActivityInfo = Role2singleinfo.get(Long.valueOf(roleId));
/* 21 */     if (xActivityInfo == null)
/*    */     {
/* 23 */       xActivityInfo = Pod.newAllActivityInfo();
/* 24 */       Role2singleinfo.insert(Long.valueOf(roleId), xActivityInfo);
/*    */     }
/* 26 */     SingleActivityInfo xSingleInfo = (SingleActivityInfo)xActivityInfo.getActivitydata().get(Integer.valueOf(activityid));
/* 27 */     if (xSingleInfo == null)
/*    */     {
/* 29 */       xSingleInfo = Pod.newSingleActivityInfo();
/* 30 */       xActivityInfo.getActivitydata().put(Integer.valueOf(activityid), xSingleInfo);
/*    */     }
/* 32 */     int lastGraphId = xSingleInfo.getLastgraphid();
/* 33 */     if (lastGraphId > 0)
/*    */     {
/* 35 */       TaskInterface.closeActivityGraphWithoutEvent(roleId, lastGraphId);
/*    */     }
/* 37 */     SingleTaskCfg cfg = SingleTaskManager.getSingleTaskCfg(activityid);
/* 38 */     if (cfg == null)
/*    */     {
/* 40 */       GameServer.logger().error(String.format("[singleTask]PSingleTaskActivityInit.initData@ cfg not exist!|activityId=%d", new Object[] { Integer.valueOf(activityid) }));
/*    */       
/* 42 */       return;
/*    */     }
/* 44 */     int newGraphId = SingleTaskManager.getNewGraphId(cfg, lastGraphId);
/* 45 */     if (newGraphId <= 0)
/*    */     {
/* 47 */       GameServer.logger().error(String.format("[singleTask]PSingleTaskActivityInit.initData@ get new graphId err!|roleId=%d|activityId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(activityid) }));
/*    */       
/*    */ 
/* 50 */       return;
/*    */     }
/* 52 */     xSingleInfo.setLastgraphid(newGraphId);
/*    */   }
/*    */   
/*    */ 
/*    */   public mzm.gsp.award.main.AwardReason getRecommendAwardReason()
/*    */   {
/* 58 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */   public java.util.List<mzm.gsp.activity.main.ActivityStage> getActivityStages()
/*    */   {
/* 64 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */   public void onActivityStart(ActivityHandler.ActivityStartType activityStartType, int activityid)
/*    */   {
/* 70 */     SingleTaskCfg cfg = SingleTaskManager.getSingleTaskCfg(activityid);
/* 71 */     if (cfg == null)
/*    */     {
/* 73 */       GameServer.logger().error(String.format("[singleTask]PSingleTaskActivityInit.onActivityStart@ cfg not exist!|activityId=%d", new Object[] { Integer.valueOf(activityid) }));
/*    */       
/*    */ 
/* 76 */       return;
/*    */     }
/* 78 */     if (!OpenInterface.getOpenStatus(cfg.openId))
/*    */     {
/* 80 */       return;
/*    */     }
/* 82 */     mzm.gsp.map.main.ControllerInterface.triggerController(cfg.controller);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void onActivityStageStart(int stage, boolean startAgain, int activityid) {}
/*    */   
/*    */ 
/*    */ 
/*    */   public void onActivityEnd(int activityid)
/*    */   {
/* 94 */     new POnActivityClosed(activityid).execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singletask\main\PSingleTaskActivityInit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
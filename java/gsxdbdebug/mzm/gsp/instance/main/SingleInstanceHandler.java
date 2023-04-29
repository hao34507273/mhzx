/*    */ package mzm.gsp.instance.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.activity.main.ActivityHandler.ActivityStartType;
/*    */ import mzm.gsp.instance.SSynSingleInstanceInfo;
/*    */ import mzm.gsp.instance.SingleInfo;
/*    */ import mzm.gsp.instance.confbean.SInstanceCfg;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ import xbean.InstanceBean;
/*    */ import xbean.InstanceCacheBean;
/*    */ import xtable.Role2instance;
/*    */ 
/*    */ public class SingleInstanceHandler implements mzm.gsp.activity.main.ActivityHandler
/*    */ {
/*    */   public void initData(String userid, long roleId, int turn, int activityid)
/*    */   {
/* 22 */     InstanceBean xInstanceBean = Role2instance.get(Long.valueOf(roleId));
/* 23 */     if (xInstanceBean == null) {
/* 24 */       xInstanceBean = xbean.Pod.newInstanceBean();
/* 25 */       Role2instance.insert(Long.valueOf(roleId), xInstanceBean);
/* 26 */       long curTime = DateTimeUtils.getCurrTimeInMillis();
/* 27 */       InstanceManager.initInstanceBean(xInstanceBean, curTime);
/*    */     }
/* 29 */     SingleInstance.onDataUpdate(roleId, xInstanceBean);
/*    */     
/* 31 */     Long instanceUuid = xtable.Role2instanceuuid.get(Long.valueOf(roleId));
/* 32 */     if (instanceUuid != null)
/*    */     {
/* 34 */       InstanceCacheBean xInstanceCacheBean = xtable.Instance.get(instanceUuid);
/*    */       
/* 36 */       SInstanceCfg instanceCfg = SInstanceCfg.get(xInstanceCacheBean.getInstancecfgid());
/* 37 */       if (instanceCfg.instanceType == 1) {
/* 38 */         SingleInstance.onleaveInstance(roleId, instanceUuid.longValue(), xInstanceCacheBean, xInstanceBean);
/*    */       }
/*    */     }
/* 41 */     if ((!OpenInterface.getOpenStatus(4)) || (OpenInterface.isBanPlay(roleId, 4)))
/*    */     {
/* 43 */       return;
/*    */     }
/*    */     
/* 46 */     SSynSingleInstanceInfo synSingleInstanceInfo = new SSynSingleInstanceInfo();
/* 47 */     synSingleInstanceInfo.singlefailtime = xInstanceBean.getSinglefailtime();
/* 48 */     for (Map.Entry<Integer, xbean.SingleInstance> entry : xInstanceBean.getSingleinstancemap().entrySet()) {
/* 49 */       xbean.SingleInstance singleInstance = (xbean.SingleInstance)entry.getValue();
/* 50 */       SingleInfo singleInfo = new SingleInfo();
/* 51 */       SingleInstance.fillInSingleInfo(singleInfo, singleInstance.getHighprocess(), singleInstance.getCurprocess(), singleInstance.getFinishtimes(), ((Integer)entry.getKey()).intValue(), singleInstance.getSign());
/*    */       
/*    */ 
/* 54 */       synSingleInstanceInfo.singleinstanceinfo.add(singleInfo);
/*    */     }
/* 56 */     OnlineManager.getInstance().send(roleId, synSingleInstanceInfo);
/*    */   }
/*    */   
/*    */   public mzm.gsp.award.main.AwardReason getRecommendAwardReason()
/*    */   {
/* 61 */     return null;
/*    */   }
/*    */   
/*    */   public java.util.List<mzm.gsp.activity.main.ActivityStage> getActivityStages()
/*    */   {
/* 66 */     return null;
/*    */   }
/*    */   
/*    */   public void onActivityStart(ActivityHandler.ActivityStartType activityStartType, int activityid)
/*    */   {
/* 71 */     for (Iterator i$ = OnlineManager.getInstance().getAllRolesInWorld().iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 72 */       NoneRealTimeTaskManager.getInstance().addTask(new LeaveSingleInstanceLogicProcedure(roleid));
/*    */     }
/*    */   }
/*    */   
/*    */   public void onActivityStageStart(int stage, boolean startAgain, int activityid) {}
/*    */   
/*    */   public void onActivityEnd(int activityid) {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\instance\main\SingleInstanceHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
/*    */ package mzm.gsp.activity.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.gm.SGMMessageTipRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ import xbean.ActivityGlobalBean;
/*    */ import xbean.OpenBeanStore;
/*    */ import xtable.Activity;
/*    */ 
/*    */ public class PGMOnStartActivity extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private int activityId;
/*    */   private long roleid;
/*    */   
/*    */   public PGMOnStartActivity(int activityId, long roleid)
/*    */   {
/* 19 */     this.activityId = activityId;
/* 20 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 25 */     mzm.gsp.activity.confbean.SActivityCfg activityCfg = mzm.gsp.activity.confbean.SActivityCfg.get(this.activityId);
/* 26 */     if (activityCfg == null) {
/* 27 */       return false;
/*    */     }
/*    */     
/* 30 */     int curStage = Integer.MAX_VALUE;
/* 31 */     ActivityGlobalBean xActivityGlobalBean = Activity.select(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 32 */     if (xActivityGlobalBean != null) {
/* 33 */       OpenBeanStore xOpenBeanStore = (OpenBeanStore)xActivityGlobalBean.getActivityopenmap().get(Integer.valueOf(this.activityId));
/* 34 */       if (xOpenBeanStore != null) {
/* 35 */         curStage = xOpenBeanStore.getStage();
/*    */       }
/*    */     }
/*    */     
/* 39 */     ActivityStage beforeActivityStage = ActivityManager.getActivityStage(this.activityId, -1);
/* 40 */     if (beforeActivityStage == null) {
/* 41 */       if (curStage != Integer.MAX_VALUE) {
/* 42 */         SGMMessageTipRes gmMessageTipRes = new SGMMessageTipRes();
/* 43 */         gmMessageTipRes.result = 2;
/* 44 */         gmMessageTipRes.args.add(curStage + "");
/* 45 */         OnlineManager.getInstance().sendAtOnce(this.roleid, gmMessageTipRes);
/* 46 */         return false;
/*    */       }
/*    */     } else {
/* 49 */       int nextStage = curStage + 1;
/* 50 */       if (0 != nextStage) {
/* 51 */         SGMMessageTipRes gmMessageTipRes = new SGMMessageTipRes();
/* 52 */         gmMessageTipRes.result = 3;
/* 53 */         gmMessageTipRes.args.add("" + nextStage);
/* 54 */         OnlineManager.getInstance().sendAtOnce(this.roleid, gmMessageTipRes);
/* 55 */         return false;
/*    */       }
/*    */     }
/* 58 */     long curTime = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/*    */     
/* 60 */     ActivityGlobalBean xOpenBean = Activity.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 61 */     if (xOpenBean != null) {
/* 62 */       OpenBeanStore xOpenBeanStore = (OpenBeanStore)xOpenBean.getActivityopenmap().get(Integer.valueOf(this.activityId));
/* 63 */       if (xOpenBeanStore != null) {
/* 64 */         if (xOpenBeanStore.getEndtime() > curTime) {
/* 65 */           if (mzm.gsp.GameServer.logger().isDebugEnabled())
/* 66 */             mzm.gsp.GameServer.logger().debug("gm命令操作:活动已经在开启中了，无须再次开启!!!activityid:" + this.activityId);
/* 67 */           return false;
/*    */         }
/* 69 */         xOpenBean.getActivityopenmap().remove(Integer.valueOf(this.activityId));
/*    */       }
/*    */     }
/*    */     
/* 73 */     NoneRealTimeTaskManager.getInstance().addTask(new ActivityForceOpenLogicProcedure(this.activityId, ActivityManager.getActivityDurationMinute(this.activityId)));
/*    */     
/* 75 */     NoneRealTimeTaskManager.getInstance().addTask(new mzm.gsp.util.LogicRunnable()
/*    */     {
/*    */       public void process() throws Exception
/*    */       {
/* 79 */         mzm.gsp.activity.SynActivityStart synActivityStart = new mzm.gsp.activity.SynActivityStart();
/* 80 */         synActivityStart.activityid = PGMOnStartActivity.this.activityId;
/* 81 */         OnlineManager.getInstance().sendAll(synActivityStart);
/*    */       }
/*    */       
/* 84 */     });
/* 85 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\main\PGMOnStartActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
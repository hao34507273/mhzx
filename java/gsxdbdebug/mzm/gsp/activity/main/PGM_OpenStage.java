/*    */ package mzm.gsp.activity.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.gm.SGMMessageTipRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.OpenBeanStore;
/*    */ 
/*    */ public class PGM_OpenStage extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private int activityid;
/*    */   private int stage;
/*    */   private long roleid;
/*    */   
/*    */   public PGM_OpenStage(long roleid, int activityId, int stage)
/*    */   {
/* 19 */     this.activityid = activityId;
/* 20 */     this.stage = stage;
/* 21 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 26 */     if (this.stage == 0) {
/* 27 */       if (GameServer.logger().isDebugEnabled())
/* 28 */         GameServer.logger().debug("活动开启了之后就已经处于0阶段了，根本没必要再用Gm指令开启阶段!!");
/* 29 */       SGMMessageTipRes gmMessageTipRes = new SGMMessageTipRes();
/* 30 */       gmMessageTipRes.result = 1;
/* 31 */       OnlineManager.getInstance().sendAtOnce(this.roleid, gmMessageTipRes);
/* 32 */       return false;
/*    */     }
/*    */     
/* 35 */     int curStage = Integer.MAX_VALUE;
/* 36 */     xbean.ActivityGlobalBean xActivityGlobalBean = xtable.Activity.select(Long.valueOf(mzm.gsp.GameServerInfoManager.getLocalId()));
/* 37 */     if (xActivityGlobalBean != null) {
/* 38 */       OpenBeanStore xOpenBeanStore = (OpenBeanStore)xActivityGlobalBean.getActivityopenmap().get(Integer.valueOf(this.activityid));
/* 39 */       if (xOpenBeanStore != null) {
/* 40 */         curStage = xOpenBeanStore.getStage();
/*    */       }
/*    */     }
/* 43 */     java.util.List<ActivityStage> stages = ActivityManager.getActivityStages(this.activityid);
/* 44 */     if ((stages == null) || (stages.size() <= 0)) {
/* 45 */       SGMMessageTipRes gmMessageTipRes = new SGMMessageTipRes();
/* 46 */       gmMessageTipRes.result = 5;
/* 47 */       OnlineManager.getInstance().sendAtOnce(this.roleid, gmMessageTipRes);
/* 48 */       return false;
/*    */     }
/* 50 */     ActivityStage beforeActivityStage = ActivityManager.getActivityStage(this.activityid, this.stage - 1);
/* 51 */     if ((beforeActivityStage == null) && (this.stage < 0)) {
/* 52 */       if (curStage != Integer.MAX_VALUE) {
/* 53 */         SGMMessageTipRes gmMessageTipRes = new SGMMessageTipRes();
/* 54 */         gmMessageTipRes.result = 2;
/* 55 */         gmMessageTipRes.args.add("" + curStage);
/* 56 */         OnlineManager.getInstance().sendAtOnce(this.roleid, gmMessageTipRes);
/* 57 */         return false;
/*    */       }
/*    */     } else {
/* 60 */       int nextStage = curStage + 1;
/* 61 */       if (this.stage != nextStage) {
/* 62 */         SGMMessageTipRes gmMessageTipRes = new SGMMessageTipRes();
/* 63 */         gmMessageTipRes.result = 3;
/* 64 */         gmMessageTipRes.args.add("" + curStage);
/* 65 */         OnlineManager.getInstance().sendAtOnce(this.roleid, gmMessageTipRes);
/* 66 */         return false;
/*    */       }
/*    */     }
/* 69 */     if (this.stage < 0) {
/* 70 */       if (ActivityInterface.isActivityOpen(this.activityid)) {
/* 71 */         SGMMessageTipRes gmMessageTipRes = new SGMMessageTipRes();
/* 72 */         gmMessageTipRes.result = 1;
/* 73 */         OnlineManager.getInstance().sendAtOnce(this.roleid, gmMessageTipRes);
/* 74 */         return false;
/*    */       }
/* 76 */       NoneRealTimeTaskManager.getInstance().addTask(new BeforeActivityStartStageProcedure(this.activityid, this.stage, mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis()));
/*    */     }
/*    */     else
/*    */     {
/* 80 */       NoneRealTimeTaskManager.getInstance().addTask(new ActivityStageProcedure(this.activityid, this.stage));
/*    */     }
/* 82 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\main\PGM_OpenStage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
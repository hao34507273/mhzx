/*    */ package mzm.gsp.visiblemonsterfight.main.robber;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.activity.SSyncGangRobberCounter;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.gang.main.GangInterface;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.timer.main.Observer;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ import mzm.gsp.visiblemonsterfight.confbean.SGangRobberConst;
/*    */ import xbean.GangRobber;
/*    */ import xtable.Gangrobber;
/*    */ 
/*    */ public class ActivityWarningObserver extends Observer
/*    */ {
/*    */   public ActivityWarningObserver()
/*    */   {
/* 20 */     super(SGangRobberConst.getInstance().ROBBER_COUNT_NOTIFY_INTERVAL);
/*    */   }
/*    */   
/*    */   public boolean update()
/*    */   {
/* 25 */     NoneRealTimeTaskManager.getInstance().addTask(new mzm.gsp.util.LogicRunnable()
/*    */     {
/*    */       public void process()
/*    */         throws Exception
/*    */       {
/* 30 */         GangRobber xGangRobber = Gangrobber.select(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 31 */         if (xGangRobber == null) {
/* 32 */           return;
/*    */         }
/* 34 */         if (!ActivityInterface.isActivityOpen(SGangRobberConst.getInstance().ACTIVITYID)) {
/* 35 */           ActivityWarningObserver.this.stopTimer();
/* 36 */           return;
/*    */         }
/* 38 */         for (Long gangId : xGangRobber.getGangrobberdatas().keySet()) {
/* 39 */           SSyncGangRobberCounter sSyncGangRobberCounter = new SSyncGangRobberCounter();
/* 40 */           int sceneId = GangInterface.getGangMapId(gangId.longValue());
/* 41 */           sSyncGangRobberCounter.count = MapInterface.getMonsterCountInMap(sceneId);
/* 42 */           OnlineManager.getInstance().sendMulti(sSyncGangRobberCounter, GangInterface.getGangMemberList(gangId.longValue()));
/*    */         }
/*    */         
/*    */       }
/* 46 */     });
/* 47 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\visiblemonsterfight\main\robber\ActivityWarningObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
/*    */ package mzm.gsp.jiuxiao.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import mzm.gsp.activity.confbean.SJueZhanJiuXiaoConsts;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.bulletin.SBulletinInfo;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ 
/*    */ class JiuXiaoTipSession extends Session
/*    */ {
/*    */   public JiuXiaoTipSession(long interval, int activityid)
/*    */   {
/* 16 */     super(interval, activityid);
/*    */   }
/*    */   
/*    */   protected void onTimeOut()
/*    */   {
/* 21 */     NoneRealTimeTaskManager.getInstance().addTask(new LogicRunnable()
/*    */     {
/*    */       public void process()
/*    */       {
/* 25 */         int activityid = (int)JiuXiaoTipSession.this.getOwerId();
/* 26 */         if (!ActivityInterface.isActivityOpen(activityid)) {
/* 27 */           return;
/*    */         }
/* 29 */         long endTime = ActivityInterface.getActivityEndTime(activityid);
/* 30 */         int befroeEndMinute = (int)((endTime - mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis() + 30000L) / 60L / 1000L);
/* 31 */         if (befroeEndMinute <= 0) {
/* 32 */           return;
/*    */         }
/*    */         
/* 35 */         SBulletinInfo bulletinInfo = new SBulletinInfo();
/* 36 */         bulletinInfo.bulletintype = 17;
/* 37 */         bulletinInfo.params.put(Integer.valueOf(14), befroeEndMinute + "");
/* 38 */         bulletinInfo.params.put(Integer.valueOf(27), String.valueOf(activityid));
/* 39 */         OnlineManager.getInstance().sendAll(bulletinInfo);
/*    */         
/*    */ 
/* 42 */         int nextBeforeTime = befroeEndMinute - SJueZhanJiuXiaoConsts.getInstance().nextTipEndIntervalTime;
/* 43 */         if (nextBeforeTime > 0) {
/* 44 */           long intervalSec = SJueZhanJiuXiaoConsts.getInstance().nextTipEndIntervalTime * 60;
/* 45 */           new JiuXiaoTipSession(intervalSec, activityid);
/*    */         }
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\jiuxiao\main\JiuXiaoTipSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
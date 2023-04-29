/*    */ package mzm.gsp.jiuxiao.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.timer.main.Observer;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import xbean.JiuXiaoActivityBean;
/*    */ import xbean.JiuXiaoActivityInfo;
/*    */ 
/*    */ class JiuXiaoAwardObserver extends Observer
/*    */ {
/*    */   private long worldid;
/*    */   private int activityid;
/*    */   
/*    */   public JiuXiaoAwardObserver(long intervalSeconds, long world, int activityid)
/*    */   {
/* 20 */     super(intervalSeconds);
/* 21 */     this.worldid = world;
/* 22 */     this.activityid = activityid;
/*    */   }
/*    */   
/*    */   public boolean update()
/*    */   {
/* 27 */     xdb.Procedure.execute(new mzm.gsp.util.LogicProcedure()
/*    */     {
/*    */       protected boolean processImp() throws Exception
/*    */       {
/* 31 */         if (!mzm.gsp.activity.main.ActivityInterface.isActivityOpen(JiuXiaoAwardObserver.this.activityid)) {
/* 32 */           JiuXiaoAwardObserver.this.stopTimer();
/* 33 */           return false;
/*    */         }
/*    */         
/* 36 */         JiuXiaoActivityBean xJiuxiaoActivityBean = xtable.Jiuxiaotable.select(Long.valueOf(GameServerInfoManager.getLocalId()));
/*    */         Iterator i$;
/* 38 */         if (xJiuxiaoActivityBean != null) {
/* 39 */           JiuXiaoActivityInfo xJiuXiaoActivityInfo = (JiuXiaoActivityInfo)xJiuxiaoActivityBean.getActivityinfomap().get(Integer.valueOf(JiuXiaoAwardObserver.this.activityid));
/*    */           
/* 41 */           if (xJiuXiaoActivityInfo == null) {
/* 42 */             JiuXiaoAwardObserver.this.stopTimer();
/* 43 */             return false;
/*    */           }
/* 45 */           if (JiuXiaoAwardObserver.this.worldid != xJiuXiaoActivityInfo.getWorldid()) {
/* 46 */             JiuXiaoAwardObserver.this.stopTimer();
/* 47 */             return false;
/*    */           }
/* 49 */           for (i$ = JiuXiaoCfgManager.getJiuXiaoAllMapidsByActivityid(JiuXiaoAwardObserver.this.activityid).iterator(); i$.hasNext();) { int mapid = ((Integer)i$.next()).intValue();
/* 50 */             List<Long> roleList = MapInterface.getRoleList(JiuXiaoAwardObserver.this.worldid, mapid);
/* 51 */             int awardid = JiuXiaoCfgManager.getMapAwardid(JiuXiaoAwardObserver.this.activityid, mapid);
/* 52 */             if ((awardid > 0) && (roleList.size() > 0)) {
/* 53 */               mzm.gsp.award.main.AwardInterface.awardToAllNoneRealTime(roleList, awardid, -1, false, true, new mzm.gsp.award.main.AwardReason(LogReason.JIU_XIAO_FIX_AWARD));
/*    */             }
/*    */           }
/*    */         }
/*    */         
/* 58 */         return true;
/*    */       }
/* 60 */     });
/* 61 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\jiuxiao\main\JiuXiaoAwardObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
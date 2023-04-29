/*    */ package mzm.gsp.zhenyao.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.activity.main.ActivityHandler;
/*    */ import mzm.gsp.activity.main.ActivityHandler.ActivityStartType;
/*    */ import mzm.gsp.activity.main.ActivityStage;
/*    */ import mzm.gsp.award.main.AwardReason;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import xbean.Pod;
/*    */ import xbean.ZhenyaoCount;
/*    */ import xtable.Role2zhenyaocount;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ZhenyaoActivityInit
/*    */   implements ActivityHandler
/*    */ {
/*    */   public void initData(String userid, long roleId, int turn, int activityid)
/*    */   {
/* 24 */     ZhenyaoCount xCount = Role2zhenyaocount.get(Long.valueOf(roleId));
/* 25 */     int count = -1;
/* 26 */     if (xCount == null)
/*    */     {
/* 28 */       xCount = Pod.newZhenyaoCount();
/* 29 */       Role2zhenyaocount.insert(Long.valueOf(roleId), xCount);
/*    */ 
/*    */     }
/*    */     else
/*    */     {
/* 34 */       count = xCount.getZhenyaocount();
/*    */     }
/* 36 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*    */     
/* 38 */     ZhenyaoManager.computeReserveExp(userid, roleId, count, turn);
/* 39 */     xCount.setCleantime(now);
/* 40 */     xCount.setDoublecount(0);
/* 41 */     xCount.setSinglecount(0);
/* 42 */     xCount.setZhenyaocount(0);
/* 43 */     ZhenyaoManager.synXYaoData2Client(roleId, xCount);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public AwardReason getRecommendAwardReason()
/*    */   {
/* 50 */     return new AwardReason(LogReason.ZHENGYAO_ACTIVITY_RECOMMEND_ADD, 0);
/*    */   }
/*    */   
/*    */ 
/*    */   public List<ActivityStage> getActivityStages()
/*    */   {
/* 56 */     return null;
/*    */   }
/*    */   
/*    */   public void onActivityStart(ActivityHandler.ActivityStartType activityStartType, int activityid) {}
/*    */   
/*    */   public void onActivityStageStart(int stageIndex, boolean startAgain, int activityid) {}
/*    */   
/*    */   public void onActivityEnd(int activityid) {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\zhenyao\main\ZhenyaoActivityInit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
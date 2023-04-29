/*    */ package mzm.gsp.shitu.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.activity.main.ActivityHandler.ActivityStartType;
/*    */ import mzm.gsp.activity.main.ActivityStage;
/*    */ import mzm.gsp.award.main.AwardReason;
/*    */ import xbean.ApprenticeInfo;
/*    */ import xbean.role2ShiTuInfo;
/*    */ import xtable.Role2shitu;
/*    */ 
/*    */ public class PayRespectActivityHandler implements mzm.gsp.activity.main.ActivityHandler
/*    */ {
/*    */   public void initData(String userid, long roleId, int turn, int activityid)
/*    */   {
/* 15 */     role2ShiTuInfo xRole2ShiTuInfo = Role2shitu.get(Long.valueOf(roleId));
/* 16 */     if (xRole2ShiTuInfo == null)
/*    */     {
/* 18 */       return;
/*    */     }
/* 20 */     ApprenticeInfo xApprenticeInfo = xRole2ShiTuInfo.getApprenticeinfo();
/* 21 */     xApprenticeInfo.setNow_pay_respect_times(0);
/*    */   }
/*    */   
/*    */ 
/*    */   public AwardReason getRecommendAwardReason()
/*    */   {
/* 27 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */   public List<ActivityStage> getActivityStages()
/*    */   {
/* 33 */     return null;
/*    */   }
/*    */   
/*    */   public void onActivityStart(ActivityHandler.ActivityStartType activityStartType, int activityid) {}
/*    */   
/*    */   public void onActivityStageStart(int stage, boolean startAgain, int activityid) {}
/*    */   
/*    */   public void onActivityEnd(int activityid) {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\main\PayRespectActivityHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
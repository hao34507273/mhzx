/*    */ package mzm.gsp.coupledaily.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.activity.main.ActivityHandler;
/*    */ import mzm.gsp.activity.main.ActivityHandler.ActivityStartType;
/*    */ import mzm.gsp.activity.main.ActivityStage;
/*    */ import mzm.gsp.award.main.AwardReason;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.CoupleQuestionInfo;
/*    */ import xbean.Pod;
/*    */ import xbean.Role2CoupleDailyInfo;
/*    */ import xtable.Role2coupledaily;
/*    */ 
/*    */ public class CoupleDailyActivityHandler implements ActivityHandler
/*    */ {
/*    */   public void initData(String userId, long roleId, int turn, int activityid)
/*    */   {
/* 19 */     Role2CoupleDailyInfo xRole2CoupleDailyInfo = Role2coupledaily.get(Long.valueOf(roleId));
/* 20 */     if (xRole2CoupleDailyInfo == null)
/*    */     {
/* 22 */       xRole2CoupleDailyInfo = Pod.newRole2CoupleDailyInfo();
/* 23 */       Role2coupledaily.add(Long.valueOf(roleId), xRole2CoupleDailyInfo);
/*    */     }
/*    */     
/*    */ 
/* 27 */     CoupleQuestionInfo xCoupleQuestionInfo = xRole2CoupleDailyInfo.getCouplequestioninfo();
/* 28 */     xCoupleQuestionInfo.setCurrentquestionidx(-1);
/* 29 */     xCoupleQuestionInfo.getQuestionlist().clear();
/*    */     
/* 31 */     xRole2CoupleDailyInfo.setIsawarded(0);
/* 32 */     xRole2CoupleDailyInfo.setPartnerroleid(0L);
/* 33 */     xRole2CoupleDailyInfo.getTasklist().clear();
/*    */     
/* 35 */     GameServer.logger().info(String.format("[coupledaily]CoupleDailyActivityHandler.initRoleData@clear role couple daily activity data success|role_id=%d|turn=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(turn) }));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public AwardReason getRecommendAwardReason()
/*    */   {
/* 44 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */   public List<ActivityStage> getActivityStages()
/*    */   {
/* 50 */     return null;
/*    */   }
/*    */   
/*    */   public void onActivityStart(ActivityHandler.ActivityStartType activityStartType, int activityid) {}
/*    */   
/*    */   public void onActivityStageStart(int stage, boolean startAgain, int activityid) {}
/*    */   
/*    */   public void onActivityEnd(int activityid) {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\coupledaily\main\CoupleDailyActivityHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
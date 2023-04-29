/*    */ package mzm.gsp.birthdaypray.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.activity.main.ActivityHandler;
/*    */ import mzm.gsp.activity.main.ActivityHandler.ActivityStartType;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.activity.main.ActivityLimitTimeStageEnum;
/*    */ import mzm.gsp.activity.main.ActivityStage;
/*    */ import mzm.gsp.award.main.AwardReason;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleOneByOneManager;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import xbean.WorldCounterInfo;
/*    */ import xtable.Worldcounter;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BirthdayPrayActivityHandler
/*    */   implements ActivityHandler
/*    */ {
/*    */   public List<ActivityStage> getActivityStages()
/*    */   {
/* 25 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */   public AwardReason getRecommendAwardReason()
/*    */   {
/* 31 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void initData(String userid, long roleId, int turn, int activityid) {}
/*    */   
/*    */ 
/*    */ 
/*    */   public void onActivityEnd(int activityid)
/*    */   {
/* 43 */     if (!BirthdayPrayManager.isBirthdayPraySwitchOpen(activityid)) {
/*    */       return;
/*    */     }
/*    */     WorldCounterInfo xWorldCounterInfo;
/* 47 */     if (ActivityInterface.getActivityLimitTimeStage(activityid, DateTimeUtils.getCurrTimeInMillis()) == ActivityLimitTimeStageEnum.LIMIT_TIME_AFTER)
/*    */     {
/* 49 */       long globalIndex = GameServerInfoManager.toGlobalId(activityid);
/*    */       
/* 51 */       xWorldCounterInfo = Worldcounter.select(Long.valueOf(globalIndex));
/* 52 */       if (xWorldCounterInfo == null)
/*    */       {
/* 54 */         return;
/*    */       }
/* 56 */       List<Long> onlineRoles = OnlineManager.getInstance().getAllRolesInWorld();
/* 57 */       for (Long roleid : onlineRoles)
/*    */       {
/* 59 */         RoleOneByOneManager.getInstance().addLogicProcedure(roleid, new PSendRewardMail(roleid.longValue(), activityid, xWorldCounterInfo));
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   public void onActivityStageStart(int stage, boolean startAgain, int activityid) {}
/*    */   
/*    */   public void onActivityStart(ActivityHandler.ActivityStartType activityStartType, int activityid) {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\birthdaypray\main\BirthdayPrayActivityHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
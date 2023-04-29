/*    */ package mzm.gsp.floor.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.activity.main.ActivityHandler;
/*    */ import mzm.gsp.activity.main.ActivityHandler.ActivityStartType;
/*    */ import mzm.gsp.activity.main.ActivityStage;
/*    */ import xbean.RoleFloorActivityInfo;
/*    */ import xbean.RoleFloorInfo;
/*    */ import xtable.Role2flooractivity;
/*    */ 
/*    */ public class FloorActivityInit implements ActivityHandler
/*    */ {
/*    */   public void initData(String userid, long roleId, int turn, int activityid)
/*    */   {
/* 15 */     RoleFloorActivityInfo xRoleActivityInfo = Role2flooractivity.get(Long.valueOf(roleId));
/* 16 */     if (xRoleActivityInfo == null)
/*    */     {
/* 18 */       return;
/*    */     }
/* 20 */     RoleFloorInfo xRoleFloorInfo = (RoleFloorInfo)xRoleActivityInfo.getActivityinfo().get(Integer.valueOf(activityid));
/* 21 */     if (xRoleFloorInfo == null)
/*    */     {
/* 23 */       return;
/*    */     }
/*    */     
/* 26 */     xRoleFloorInfo.getFloor2info().clear();
/*    */     
/* 28 */     xRoleActivityInfo.getHelpdata().clear();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public mzm.gsp.award.main.AwardReason getRecommendAwardReason()
/*    */   {
/* 35 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public java.util.List<ActivityStage> getActivityStages()
/*    */   {
/* 42 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */   public void onActivityStart(ActivityHandler.ActivityStartType activityStartType, int activityid)
/*    */   {
/* 48 */     if (!activityStartType.isBigTurn())
/*    */     {
/* 50 */       return;
/*    */     }
/* 52 */     new PClearGlobalData(activityid).execute();
/*    */   }
/*    */   
/*    */   public void onActivityStageStart(int stage, boolean startAgain, int activityid) {}
/*    */   
/*    */   public void onActivityEnd(int activityid) {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\floor\main\FloorActivityInit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
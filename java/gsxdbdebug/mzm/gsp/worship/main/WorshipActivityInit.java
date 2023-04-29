/*    */ package mzm.gsp.worship.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.activity.confbean.WorShipConst;
/*    */ import mzm.gsp.activity.main.ActivityHandler;
/*    */ import mzm.gsp.activity.main.ActivityHandler.ActivityStartType;
/*    */ import mzm.gsp.activity.main.ActivityStage;
/*    */ import mzm.gsp.award.main.AwardReason;
/*    */ import xbean.RoleWorshipInfo;
/*    */ import xtable.Role2worship;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WorshipActivityInit
/*    */   implements ActivityHandler
/*    */ {
/*    */   public void initData(String userId, long roleId, int turn, int activityid)
/*    */   {
/* 22 */     if (activityid != WorShipConst.getInstance().activityId)
/*    */     {
/* 24 */       return;
/*    */     }
/* 26 */     RoleWorshipInfo xRoleWorshipInfo = Role2worship.get(Long.valueOf(roleId));
/* 27 */     if (xRoleWorshipInfo == null)
/*    */     {
/* 29 */       return;
/*    */     }
/* 31 */     xRoleWorshipInfo.setWorshipid(0);
/* 32 */     xRoleWorshipInfo.getLastcycledata().clear();
/* 33 */     xRoleWorshipInfo.getLastcycledata().putAll(xRoleWorshipInfo.getThiscycledata());
/* 34 */     xRoleWorshipInfo.getThiscycledata().clear();
/*    */   }
/*    */   
/*    */ 
/*    */   public AwardReason getRecommendAwardReason()
/*    */   {
/* 40 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */   public List<ActivityStage> getActivityStages()
/*    */   {
/* 46 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void onActivityStart(ActivityHandler.ActivityStartType activityStartType, int activityid) {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void onActivityStageStart(int stageIndex, boolean startAgain, int activityid) {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void onActivityEnd(int activityid)
/*    */   {
/* 65 */     if (activityid != WorShipConst.getInstance().activityId)
/*    */     {
/* 67 */       return;
/*    */     }
/* 69 */     new RClearAllFactionData().execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\worship\main\WorshipActivityInit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
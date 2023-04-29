/*    */ package mzm.gsp.grow.daytarget;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.activity.main.ActivityHandler;
/*    */ import mzm.gsp.activity.main.ActivityHandler.ActivityStartType;
/*    */ import mzm.gsp.activity.main.ActivityStage;
/*    */ import mzm.gsp.award.main.AwardReason;
/*    */ import mzm.gsp.grow.confbean.TargetConsts;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class DayTargetActivityHandler
/*    */   implements ActivityHandler
/*    */ {
/*    */   public void initData(String userId, long roleId, int turn, int activityid)
/*    */   {
/* 18 */     RoleDayInfo roleDayInfo = new RoleDayInfo(roleId, true);
/* 19 */     if (!roleDayInfo.hasXData())
/*    */     {
/* 21 */       return;
/*    */     }
/*    */     
/* 24 */     DayTargetManager.flushNewTargets(roleDayInfo, 3);
/*    */     
/* 26 */     if (roleDayInfo.getAllTarget().size() != TargetConsts.getInstance().FLUSH_NUM)
/*    */     {
/* 28 */       GameServer.logger().error(String.format("[dayTarget]DayTargetActivityHandler.initRoleData@ targets num not enough!|needNum=%d|ownNum=%d", new Object[] { Integer.valueOf(TargetConsts.getInstance().FLUSH_NUM), Integer.valueOf(roleDayInfo.getAllTarget().size()) }));
/*    */       
/*    */ 
/*    */ 
/* 32 */       return;
/*    */     }
/*    */     
/* 35 */     DayTargetManager.synAllTargets(roleDayInfo);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public AwardReason getRecommendAwardReason()
/*    */   {
/* 42 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public List<ActivityStage> getActivityStages()
/*    */   {
/* 49 */     return null;
/*    */   }
/*    */   
/*    */   public void onActivityStart(ActivityHandler.ActivityStartType activityStartType, int activityid) {}
/*    */   
/*    */   public void onActivityStageStart(int stage, boolean startAgain, int activityid) {}
/*    */   
/*    */   public void onActivityEnd(int activityid) {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grow\daytarget\DayTargetActivityHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
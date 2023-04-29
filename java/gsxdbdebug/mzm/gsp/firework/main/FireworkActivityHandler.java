/*    */ package mzm.gsp.firework.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.activity.main.ActivityHandler;
/*    */ import mzm.gsp.activity.main.ActivityHandler.ActivityStartType;
/*    */ import mzm.gsp.activity.main.ActivityStage;
/*    */ import mzm.gsp.activity3.confbean.SFireworkCfg;
/*    */ import mzm.gsp.award.main.AwardReason;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FireworkActivityHandler
/*    */   implements ActivityHandler
/*    */ {
/*    */   public void initData(String userid, long roleId, int turn, int activityid) {}
/*    */   
/*    */   public AwardReason getRecommendAwardReason()
/*    */   {
/* 24 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */   public List<ActivityStage> getActivityStages()
/*    */   {
/* 30 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */   public void onActivityStart(ActivityHandler.ActivityStartType activityStartType, int activityid)
/*    */   {
/* 36 */     if (GameServerInfoManager.isRoamServer())
/*    */     {
/*    */ 
/* 39 */       return;
/*    */     }
/* 41 */     SFireworkCfg cfg = SFireworkCfg.get(activityid);
/* 42 */     if (cfg == null)
/*    */     {
/* 44 */       return;
/*    */     }
/* 46 */     if (!OpenInterface.getOpenStatus(cfg.switchId))
/*    */     {
/* 48 */       FireworkManager.loggerInfo("FireworkActivityHandler.onActivityStart@ not open!|activityId=%d", new Object[] { Integer.valueOf(activityid) });
/* 49 */       return;
/*    */     }
/* 51 */     FireworkManager.initActivity(activityid, OperFireorkReason.ACTIVITY_START);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void onActivityStageStart(int stage, boolean startAgain, int activityid) {}
/*    */   
/*    */ 
/*    */ 
/*    */   public void onActivityEnd(int activityid)
/*    */   {
/* 63 */     FireworkManager.stopActivity(activityid, OperFireorkReason.ACTIVITY_END);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\firework\main\FireworkActivityHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
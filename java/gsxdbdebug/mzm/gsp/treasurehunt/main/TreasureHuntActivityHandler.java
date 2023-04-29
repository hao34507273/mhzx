/*    */ package mzm.gsp.treasurehunt.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.activity.main.ActivityHandler;
/*    */ import mzm.gsp.activity.main.ActivityHandler.ActivityStartType;
/*    */ import mzm.gsp.map.main.ControllerInterface;
/*    */ import mzm.gsp.treasurehunt.confbean.STreasureHuntCfg;
/*    */ import xbean.Role2TreasureHuntInfo;
/*    */ import xbean.RoleTreasureHuntActivityInfo;
/*    */ import xtable.Role2treasurehunt;
/*    */ 
/*    */ public class TreasureHuntActivityHandler implements ActivityHandler
/*    */ {
/*    */   public void initData(String userid, long roleId, int turn, int activityid)
/*    */   {
/* 17 */     Role2TreasureHuntInfo xRole2TreasureHuntInfo = Role2treasurehunt.get(Long.valueOf(roleId));
/* 18 */     if (xRole2TreasureHuntInfo == null)
/*    */     {
/* 20 */       return;
/*    */     }
/*    */     
/* 23 */     RoleTreasureHuntActivityInfo xRoleTreasureHuntActivityInfo = (RoleTreasureHuntActivityInfo)xRole2TreasureHuntInfo.getTreasure_hunt_activity_map().get(Integer.valueOf(activityid));
/*    */     
/* 25 */     if (xRoleTreasureHuntActivityInfo != null)
/*    */     {
/* 27 */       xRoleTreasureHuntActivityInfo.getAwarded_chapter_id_set().clear();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   public mzm.gsp.award.main.AwardReason getRecommendAwardReason()
/*    */   {
/* 34 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */   public java.util.List<mzm.gsp.activity.main.ActivityStage> getActivityStages()
/*    */   {
/* 40 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */   public void onActivityStart(ActivityHandler.ActivityStartType activityStartType, int activityid)
/*    */   {
/* 46 */     if (!TreasureHuntManager.isActivitySwitchOpen(activityid))
/*    */     {
/* 48 */       return;
/*    */     }
/*    */     
/* 51 */     STreasureHuntCfg sTreasureHuntCfg = STreasureHuntCfg.get(activityid);
/* 52 */     if (sTreasureHuntCfg == null)
/*    */     {
/* 54 */       return;
/*    */     }
/* 56 */     ControllerInterface.triggerController(sTreasureHuntCfg.npc_controller_id);
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
/* 68 */     STreasureHuntCfg sTreasureHuntCfg = STreasureHuntCfg.get(activityid);
/* 69 */     if (sTreasureHuntCfg == null)
/*    */     {
/* 71 */       return;
/*    */     }
/* 73 */     ControllerInterface.collectController(sTreasureHuntCfg.npc_controller_id);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\treasurehunt\main\TreasureHuntActivityHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
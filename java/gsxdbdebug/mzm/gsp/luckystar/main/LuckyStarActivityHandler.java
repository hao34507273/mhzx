/*    */ package mzm.gsp.luckystar.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.activity.main.ActivityHandler.ActivityStartType;
/*    */ import xbean.LuckyStarInfo;
/*    */ import xbean.Role2LuckyStarInfo;
/*    */ import xtable.Role2luckystar;
/*    */ 
/*    */ public class LuckyStarActivityHandler implements mzm.gsp.activity.main.ActivityHandler
/*    */ {
/*    */   public void initData(String userid, long roleId, int turn, int activityid)
/*    */   {
/* 14 */     Role2LuckyStarInfo xRole2LuckyStarInfo = Role2luckystar.get(Long.valueOf(roleId));
/* 15 */     if (xRole2LuckyStarInfo == null)
/*    */     {
/* 17 */       return;
/*    */     }
/*    */     
/* 20 */     LuckyStarInfo xLuckyStarInfo = (LuckyStarInfo)xRole2LuckyStarInfo.getLucky_star_info_map().get(Integer.valueOf(activityid));
/* 21 */     if (xLuckyStarInfo == null)
/*    */     {
/* 23 */       return;
/*    */     }
/*    */     
/* 26 */     xLuckyStarInfo.getBuy_gift_info_list().clear();
/*    */   }
/*    */   
/*    */ 
/*    */   public mzm.gsp.award.main.AwardReason getRecommendAwardReason()
/*    */   {
/* 32 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */   public List<mzm.gsp.activity.main.ActivityStage> getActivityStages()
/*    */   {
/* 38 */     return null;
/*    */   }
/*    */   
/*    */   public void onActivityStart(ActivityHandler.ActivityStartType activityStartType, int activityid) {}
/*    */   
/*    */   public void onActivityStageStart(int stage, boolean startAgain, int activityid) {}
/*    */   
/*    */   public void onActivityEnd(int activityid) {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\luckystar\main\LuckyStarActivityHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
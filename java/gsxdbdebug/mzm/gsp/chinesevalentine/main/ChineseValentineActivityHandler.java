/*    */ package mzm.gsp.chinesevalentine.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.activity.main.ActivityHandler;
/*    */ import mzm.gsp.activity.main.ActivityHandler.ActivityStartType;
/*    */ import mzm.gsp.activity.main.ActivityStage;
/*    */ import mzm.gsp.award.main.AwardReason;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.ChineseValentineAwardRecord;
/*    */ import xtable.Role2chinesevalentineaward;
/*    */ 
/*    */ public class ChineseValentineActivityHandler implements ActivityHandler
/*    */ {
/*    */   public void initData(String userid, long roleId, int turn, int activityid)
/*    */   {
/* 16 */     GameServer.logger().info(String.format("[chinesevalentine]ChineseValentineActivityHandler.initData@log|roleid=%d|turn=%d|activityid=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(turn), Integer.valueOf(activityid) }));
/*    */     
/*    */ 
/* 19 */     ChineseValentineAwardRecord xChineseValentineAwardRecord = Role2chinesevalentineaward.get(Long.valueOf(roleId));
/* 20 */     if (xChineseValentineAwardRecord != null)
/*    */     {
/* 22 */       xChineseValentineAwardRecord.setAwardcount(0);
/* 23 */       xChineseValentineAwardRecord.setTimestamp(0L);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public AwardReason getRecommendAwardReason()
/*    */   {
/* 31 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public java.util.List<ActivityStage> getActivityStages()
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


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chinesevalentine\main\ChineseValentineActivityHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
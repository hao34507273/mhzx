/*    */ package mzm.gsp.chess.main;
/*    */ 
/*    */ import mzm.gsp.activity.main.ActivityHandler;
/*    */ import mzm.gsp.activity.main.ActivityHandler.ActivityStartType;
/*    */ import mzm.gsp.activity.main.ActivityStage;
/*    */ import mzm.gsp.activity3.confbean.ChessActivityConsts;
/*    */ import mzm.gsp.award.main.AwardReason;
/*    */ import mzm.gsp.map.main.ControllerInterface;
/*    */ import mzm.gsp.npc.confbean.SNpc;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.ChessActivityInfo;
/*    */ import xtable.Role2chessactivityinfo;
/*    */ 
/*    */ class ChessActivityHandler implements ActivityHandler
/*    */ {
/*    */   public void initData(String userid, long roleId, int turn, int activityid)
/*    */   {
/* 19 */     ChessActivityInfo xChessActivityInfo = Role2chessactivityinfo.get(Long.valueOf(roleId));
/* 20 */     if (null == xChessActivityInfo)
/*    */     {
/* 22 */       return;
/*    */     }
/* 24 */     xChessActivityInfo.setToday_win_count(0);
/* 25 */     xChessActivityInfo.setToday_lose_count(0);
/* 26 */     xChessActivityInfo.setToday_draw_count(0);
/*    */   }
/*    */   
/*    */ 
/*    */   public AwardReason getRecommendAwardReason()
/*    */   {
/* 32 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */   public java.util.List<ActivityStage> getActivityStages()
/*    */   {
/* 38 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void onActivityStart(ActivityHandler.ActivityStartType activityStartType, int activityid)
/*    */   {
/* 45 */     if (!OpenInterface.getOpenStatus(396))
/*    */     {
/* 47 */       return;
/*    */     }
/* 49 */     int npcId = ChessActivityConsts.getInstance().NPC_ID;
/* 50 */     SNpc sNpc = SNpc.get(npcId);
/* 51 */     if (null == sNpc)
/*    */     {
/* 53 */       String logstr = String.format("[chess]ChessActivityHandler.onActivityStart@npc cfg not exsists|npcId=%d", new Object[] { Integer.valueOf(npcId) });
/*    */       
/* 55 */       ChessActivityManager.logger.error(logstr);
/* 56 */       return;
/*    */     }
/* 58 */     ControllerInterface.triggerController(sNpc.controllerId);
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
/* 70 */     int npcId = ChessActivityConsts.getInstance().NPC_ID;
/* 71 */     SNpc sNpc = SNpc.get(npcId);
/* 72 */     if (null == sNpc)
/*    */     {
/* 74 */       String logstr = String.format("[chess]ChessActivityHandler.onActivityEnd@npc cfg not exsists|npcId=%d", new Object[] { Integer.valueOf(npcId) });
/* 75 */       ChessActivityManager.logger.error(logstr);
/* 76 */       return;
/*    */     }
/* 78 */     ControllerInterface.collectController(sNpc.controllerId);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chess\main\ChessActivityHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
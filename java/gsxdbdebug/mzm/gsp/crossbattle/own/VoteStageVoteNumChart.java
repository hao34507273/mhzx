/*    */ package mzm.gsp.crossbattle.own;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.chart.main.NoneRoleKeyRankManagerNew;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.AttendCorpsInfo;
/*    */ import xbean.CrossBattleOwn;
/*    */ import xtable.Cross_battle_owns;
/*    */ 
/*    */ 
/*    */ public class VoteStageVoteNumChart
/*    */   extends NoneRoleKeyRankManagerNew<Long, VoteStageVoteNumChartObj>
/*    */ {
/*    */   private final int activityCfgid;
/*    */   
/*    */   public VoteStageVoteNumChart(int activityCfgid)
/*    */   {
/* 20 */     super(48);
/* 21 */     this.activityCfgid = activityCfgid;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void rankDataFromDB()
/*    */   {
/* 28 */     long globalActivityCfgid = GameServerInfoManager.toGlobalId(this.activityCfgid);
/* 29 */     CrossBattleOwn xCrossBattleOwn = Cross_battle_owns.get(Long.valueOf(globalActivityCfgid));
/* 30 */     if ((xCrossBattleOwn == null) || (xCrossBattleOwn.getStage() == -1) || (xCrossBattleOwn.getStage() == 0))
/*    */     {
/*    */ 
/* 33 */       return;
/*    */     }
/* 35 */     for (Map.Entry<Long, AttendCorpsInfo> entry : xCrossBattleOwn.getAttend_corps_infos().entrySet())
/*    */     {
/* 37 */       long corpsid = ((Long)entry.getKey()).longValue();
/* 38 */       AttendCorpsInfo xAttendCorpsInfo = (AttendCorpsInfo)entry.getValue();
/* 39 */       rank(new VoteStageVoteNumChartObj(corpsid, xAttendCorpsInfo.getVote_stage_start_average_fight_value(), xAttendCorpsInfo.getVote_num(), xAttendCorpsInfo.getVote_num_timestamp()));
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void saveToDB() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void addRankRoleForIDIP(long roleid)
/*    */   {
/* 53 */     CrossBattleOwnManager.logger.info(String.format("[crossbattle_own]VoteStageVoteNumChart.addRankRoleForIDIP@unspported operation", new Object[0]));
/*    */   }
/*    */   
/*    */ 
/*    */   public void clearRoleRankData(long roleid)
/*    */   {
/* 59 */     CrossBattleOwnManager.logger.info(String.format("[crossbattle_own]VoteStageVoteNumChart.clearRoleRankData@unspported operation", new Object[0]));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\own\VoteStageVoteNumChart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
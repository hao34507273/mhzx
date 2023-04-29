/*    */ package mzm.gsp.ladder.main;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ import java.util.Random;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.chart.main.RankInterface;
/*    */ import mzm.gsp.crossserver.main.CrossServerInterface;
/*    */ import mzm.gsp.ladder.GetLadderRankRangeContext;
/*    */ import mzm.gsp.ladder.GetLadderRankRange_SendRankAward;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.util.CommonUtils;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ import org.apache.log4j.Logger;
/*    */ import xdb.Xdb;
/*    */ 
/*    */ public class GetLadderRemoteRankRangeSession
/*    */   extends Session
/*    */ {
/*    */   private final int chartType;
/*    */   
/*    */   public GetLadderRemoteRankRangeSession(long interval, long rankid, int chartType)
/*    */   {
/* 24 */     super(interval, rankid);
/* 25 */     this.chartType = chartType;
/* 26 */     GameServer.logger().info(String.format("[ladder]GetLadderRemoteRankRangeSession@start get ladder remote rank range session|interval=%d|season_start_timestamp=%d|level_range=%d|chart_type=%d", new Object[] { Long.valueOf(interval), Integer.valueOf(CommonUtils.getLongHigh(rankid)), Integer.valueOf(CommonUtils.getLongLow(rankid)), Integer.valueOf(chartType) }));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 35 */     new RGetLadderRomoteRankRange(getOwerId(), this.chartType).execute();
/*    */   }
/*    */   
/*    */   class RGetLadderRomoteRankRange extends LogicRunnable
/*    */   {
/*    */     private final long rankid;
/*    */     private final int chartType;
/*    */     
/*    */     public RGetLadderRomoteRankRange(long rankid, int chartType)
/*    */     {
/* 45 */       this.rankid = rankid;
/* 46 */       this.chartType = chartType;
/*    */     }
/*    */     
/*    */     public void process()
/*    */       throws Exception
/*    */     {
/* 52 */       int rank = RankInterface.getAwardRank(this.chartType);
/* 53 */       if (rank < 0)
/*    */       {
/* 55 */         return;
/*    */       }
/* 57 */       GetLadderRankRangeContext context = new GetLadderRankRangeContext();
/* 58 */       context.oper_type = 1;
/* 59 */       context.count = 1;
/* 60 */       GetLadderRankRange_SendRankAward content = new GetLadderRankRange_SendRankAward();
/* 61 */       content.chart_type = this.chartType;
/* 62 */       context.content.replace(content.marshal(new OctetsStream()));
/* 63 */       if (!CrossServerInterface.asyncGetLadderRankRange(this.rankid, 0, rank, context.marshal(new OctetsStream())))
/*    */       {
/*    */ 
/* 66 */         GameServer.logger().error(String.format("[ladder]GetLadderRemoteRankRangeSession.RGetLadderRomoteRankRange.process@communication error|season_start_timestamp=%d|level_range=%d|from=%d|to=%d|chart_type=%d", new Object[] { Integer.valueOf(CommonUtils.getLongHigh(this.rankid)), Integer.valueOf(CommonUtils.getLongLow(this.rankid)), Integer.valueOf(0), Integer.valueOf(rank), Integer.valueOf(this.chartType) }));
/*    */         
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 72 */         new GetLadderRemoteRankRangeSession(LadderManager.GRC_MIN_DELAY_IN_SECOND + Xdb.random().nextInt(LadderManager.GRC_MAX_DELAY_IN_SECOND - LadderManager.GRC_MIN_DELAY_IN_SECOND), this.rankid, this.chartType);
/*    */         
/*    */ 
/*    */ 
/* 76 */         return;
/*    */       }
/* 78 */       GameServer.logger().info(String.format("[ladder]GetLadderRemoteRankRangeSession.RGetLadderRomoteRankRange.process@get ladder rank from grc|season_start_timestamp=%d|level_range=%d|from=%d|to=%d|chart_type=%d", new Object[] { Integer.valueOf(CommonUtils.getLongHigh(this.rankid)), Integer.valueOf(CommonUtils.getLongLow(this.rankid)), Integer.valueOf(0), Integer.valueOf(rank), Integer.valueOf(this.chartType) }));
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ladder\main\GetLadderRemoteRankRangeSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
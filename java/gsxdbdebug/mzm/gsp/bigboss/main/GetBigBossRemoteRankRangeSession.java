/*    */ package mzm.gsp.bigboss.main;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.Random;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.bigboss.GetBigBossRemoteRankContext;
/*    */ import mzm.gsp.bigboss.confbean.SBigbossRemoteChartTypeCfg;
/*    */ import mzm.gsp.chart.main.RankInterface;
/*    */ import mzm.gsp.crossserver.main.CrossServerInterface;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.util.CommonUtils;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ import org.apache.log4j.Logger;
/*    */ import xdb.Xdb;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GetBigBossRemoteRankRangeSession
/*    */   extends Session
/*    */ {
/*    */   public GetBigBossRemoteRankRangeSession(long interval, long rankid)
/*    */   {
/* 24 */     super(interval, rankid);
/* 25 */     int occupation = CommonUtils.getLongHigh(rankid);
/* 26 */     long startTimestamp = CommonUtils.getLongLow(rankid) * 1000L;
/* 27 */     GameServer.logger().info(String.format("[bigboss]GetBigBossRemoteRankRangeSession@start get big boss remote rank range session|interval=%d|occupation=%d|start_timestamp=%s", new Object[] { Long.valueOf(interval), Integer.valueOf(occupation), DateTimeUtils.formatTimestamp(startTimestamp) }));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 36 */     new RGetRomoteRankRange(getOwerId()).execute();
/*    */   }
/*    */   
/*    */   class RGetRomoteRankRange extends LogicRunnable
/*    */   {
/*    */     private final long rankid;
/*    */     
/*    */     public RGetRomoteRankRange(long rankid)
/*    */     {
/* 45 */       this.rankid = rankid;
/*    */     }
/*    */     
/*    */     public void process()
/*    */       throws Exception
/*    */     {
/* 51 */       int occupation = CommonUtils.getLongHigh(this.rankid);
/* 52 */       long startTimestamp = CommonUtils.getLongLow(this.rankid) * 1000L;
/* 53 */       SBigbossRemoteChartTypeCfg cfg = SBigbossRemoteChartTypeCfg.get(occupation);
/* 54 */       if (cfg == null)
/*    */       {
/* 56 */         return;
/*    */       }
/* 58 */       int rank = RankInterface.getAwardRank(cfg.remote_chart_type);
/* 59 */       if (rank < 0)
/*    */       {
/* 61 */         return;
/*    */       }
/* 63 */       GetBigBossRemoteRankContext context = new GetBigBossRemoteRankContext();
/* 64 */       context.oper_type = 1;
/* 65 */       context.count = 1;
/* 66 */       if (!CrossServerInterface.getBigBossRankRange(this.rankid, 0, rank, context.marshal(new OctetsStream())))
/*    */       {
/*    */ 
/* 69 */         GameServer.logger().error(String.format("[bigboss]GetBigBossRemoteRankRangeSession.RGetRomoteRankRange.process@communication error|occupation=%d|start_timestamp=%s|from=%d|to=%d", new Object[] { Integer.valueOf(occupation), DateTimeUtils.formatTimestamp(startTimestamp), Integer.valueOf(0), Integer.valueOf(rank) }));
/*    */         
/*    */ 
/*    */ 
/*    */ 
/* 74 */         new GetBigBossRemoteRankRangeSession(BigbossManager.GET_REMOTE_RANK_MIN_DELAY_IN_SECOND + Xdb.random().nextInt(BigbossManager.GET_REMOTE_RANK_MAX_DELAY_IN_SECOND - BigbossManager.GET_REMOTE_RANK_MIN_DELAY_IN_SECOND), this.rankid);
/*    */         
/*    */ 
/*    */ 
/* 78 */         return;
/*    */       }
/* 80 */       GameServer.logger().info(String.format("[bigboss]GetBigBossRemoteRankRangeSession.RGetRomoteRankRange.process@get big boss remote rank from grc|occupation=%d|start_timestamp=%s|from=%d|to=%d", new Object[] { Integer.valueOf(occupation), DateTimeUtils.formatTimestamp(startTimestamp), Integer.valueOf(0), Integer.valueOf(rank) }));
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bigboss\main\GetBigBossRemoteRankRangeSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
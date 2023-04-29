/*     */ package mzm.gsp.crossbattle.bet;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.Random;
/*     */ import mzm.gsp.chart.main.RankInterface;
/*     */ import mzm.gsp.crossbattle.GetCrossBattleBetRankContext;
/*     */ import mzm.gsp.crossserver.main.CrossServerInterface;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.util.LogicRunnable;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Xdb;
/*     */ 
/*     */ 
/*     */ public class GetRemoteRankRangeSession
/*     */   extends Session
/*     */ {
/*     */   private final int chartType;
/*     */   
/*     */   public GetRemoteRankRangeSession(long interval, long rankid, int chartType)
/*     */   {
/*  21 */     super(interval, rankid);
/*  22 */     this.chartType = chartType;
/*  23 */     CrossBattleBetManager.logger.info(String.format("[crossbattle]GetRemoteRankRangeSession@start get remote rank range session|interval=%d|rankid=%d|chart_type=%d", new Object[] { Long.valueOf(interval), Long.valueOf(rankid), Integer.valueOf(chartType) }));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void onTimeOut()
/*     */   {
/*  31 */     new RGetRomoteRankRange(getOwerId(), this.chartType).execute();
/*     */   }
/*     */   
/*     */   class RGetRomoteRankRange extends LogicRunnable
/*     */   {
/*     */     private final long rankid;
/*     */     private final int chartType;
/*     */     
/*     */     public RGetRomoteRankRange(long rankid, int chartType)
/*     */     {
/*  41 */       this.rankid = rankid;
/*  42 */       this.chartType = chartType;
/*     */     }
/*     */     
/*     */     public void process()
/*     */       throws Exception
/*     */     {
/*  48 */       if (this.chartType == 50)
/*     */       {
/*  50 */         int rank = RankInterface.getAwardRank(50);
/*  51 */         if (rank < 0)
/*     */         {
/*  53 */           return;
/*     */         }
/*  55 */         GetCrossBattleBetRankContext context = new GetCrossBattleBetRankContext();
/*  56 */         context.oper_type = 1;
/*  57 */         context.count = 1;
/*  58 */         if (!CrossServerInterface.getCrossBattleBetWinRankRange(this.rankid, 0, rank, context.marshal(new OctetsStream())))
/*     */         {
/*     */ 
/*     */ 
/*  62 */           CrossBattleBetManager.logger.error(String.format("[crossbattle]GetRemoteRankRangeSession.RGetRomoteRankRange.process@communication error|rankid=%d|chart_type=%d|from=%d|to=%d", new Object[] { Long.valueOf(this.rankid), Integer.valueOf(this.chartType), Integer.valueOf(0), Integer.valueOf(rank) }));
/*     */           
/*     */ 
/*     */ 
/*  66 */           new GetRemoteRankRangeSession(CrossBattleBetManager.GET_REMOTE_RANK_MIN_DELAY_IN_SECOND + Xdb.random().nextInt(CrossBattleBetManager.GET_REMOTE_RANK_MAX_DELAY_IN_SECOND - CrossBattleBetManager.GET_REMOTE_RANK_MIN_DELAY_IN_SECOND), this.rankid, this.chartType);
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*  71 */           return;
/*     */         }
/*  73 */         CrossBattleBetManager.logger.info(String.format("[crossbattle]GetRemoteRankRangeSession.RGetRomoteRankRange.process@get cross battle bet rank from grc|rankid=%d|chart_type=%d|from=%d|to=%d", new Object[] { Long.valueOf(this.rankid), Integer.valueOf(this.chartType), Integer.valueOf(0), Integer.valueOf(rank) }));
/*     */         
/*     */ 
/*  76 */         return;
/*     */       }
/*  78 */       if (this.chartType == 51)
/*     */       {
/*  80 */         int rank = RankInterface.getAwardRank(51);
/*  81 */         if (rank < 0)
/*     */         {
/*  83 */           return;
/*     */         }
/*  85 */         GetCrossBattleBetRankContext context = new GetCrossBattleBetRankContext();
/*  86 */         context.oper_type = 1;
/*  87 */         context.count = 1;
/*  88 */         if (!CrossServerInterface.getCrossBattleBetLoseRankRange(this.rankid, 0, rank, context.marshal(new OctetsStream())))
/*     */         {
/*     */ 
/*     */ 
/*  92 */           CrossBattleBetManager.logger.error(String.format("[crossbattle]GetRemoteRankRangeSession.RGetRomoteRankRange.process@communication error|rankid=%d|chart_type=%d|from=%d|to=%d", new Object[] { Long.valueOf(this.rankid), Integer.valueOf(this.chartType), Integer.valueOf(0), Integer.valueOf(rank) }));
/*     */           
/*     */ 
/*     */ 
/*  96 */           new GetRemoteRankRangeSession(CrossBattleBetManager.GET_REMOTE_RANK_MIN_DELAY_IN_SECOND + Xdb.random().nextInt(CrossBattleBetManager.GET_REMOTE_RANK_MAX_DELAY_IN_SECOND - CrossBattleBetManager.GET_REMOTE_RANK_MIN_DELAY_IN_SECOND), this.rankid, this.chartType);
/*     */           
/*     */ 
/*     */ 
/*     */ 
/* 101 */           return;
/*     */         }
/* 103 */         CrossBattleBetManager.logger.info(String.format("[crossbattle]GetRemoteRankRangeSession.RGetRomoteRankRange.process@get cross battle bet rank from grc|rankid=%d|chart_type=%d|from=%d|to=%d", new Object[] { Long.valueOf(this.rankid), Integer.valueOf(this.chartType), Integer.valueOf(0), Integer.valueOf(rank) }));
/*     */         
/*     */ 
/* 106 */         return;
/*     */       }
/* 108 */       CrossBattleBetManager.logger.info(String.format("[crossbattle]GetRemoteRankRangeSession.RGetRomoteRankRange.process@chart type error|rankid=%d|chart_type=%d", new Object[] { Long.valueOf(this.rankid), Integer.valueOf(this.chartType) }));
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\bet\GetRemoteRankRangeSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
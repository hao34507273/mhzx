/*    */ package mzm.gsp.crossfield.main;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.Random;
/*    */ import mzm.gsp.chart.main.RankInterface;
/*    */ import mzm.gsp.crossfield.GetCrossFieldRankContext;
/*    */ import mzm.gsp.crossserver.main.CrossServerInterface;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ import org.apache.log4j.Logger;
/*    */ import xdb.Xdb;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GetRemoteRankRangeSession
/*    */   extends Session
/*    */ {
/*    */   public GetRemoteRankRangeSession(long interval, long rankid)
/*    */   {
/* 20 */     super(interval, rankid);
/* 21 */     CrossFieldManager.logger.info(String.format("[crossfield]GetRemoteRankRangeSession@start get remote rank range session|interval=%d|rankid=%d", new Object[] { Long.valueOf(interval), Long.valueOf(rankid) }));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 29 */     new RGetRomoteRankRange(getOwerId()).execute();
/*    */   }
/*    */   
/*    */   class RGetRomoteRankRange extends LogicRunnable
/*    */   {
/*    */     private final long rankid;
/*    */     
/*    */     public RGetRomoteRankRange(long rankid)
/*    */     {
/* 38 */       this.rankid = rankid;
/*    */     }
/*    */     
/*    */     public void process()
/*    */       throws Exception
/*    */     {
/* 44 */       int rank = RankInterface.getAwardRank(40);
/* 45 */       if (rank < 0)
/*    */       {
/* 47 */         return;
/*    */       }
/* 49 */       GetCrossFieldRankContext context = new GetCrossFieldRankContext();
/* 50 */       context.oper_type = 1;
/* 51 */       context.count = 1;
/* 52 */       if (!CrossServerInterface.getSingleCrossFieldRankRange(this.rankid, 0, rank, context.marshal(new OctetsStream())))
/*    */       {
/*    */ 
/* 55 */         CrossFieldManager.logger.error(String.format("[crossfield]GetRemoteRankRangeSession.RGetRomoteRankRange.process@communication error|rankid=%d|from=%d|to=%d", new Object[] { Long.valueOf(this.rankid), Integer.valueOf(0), Integer.valueOf(rank) }));
/*    */         
/*    */ 
/*    */ 
/* 59 */         new GetRemoteRankRangeSession(CrossFieldManager.GET_REMOTE_RANK_MIN_DELAY_IN_SECOND + Xdb.random().nextInt(CrossFieldManager.GET_REMOTE_RANK_MAX_DELAY_IN_SECOND - CrossFieldManager.GET_REMOTE_RANK_MIN_DELAY_IN_SECOND), this.rankid);
/*    */         
/*    */ 
/*    */ 
/* 63 */         return;
/*    */       }
/* 65 */       CrossFieldManager.logger.info(String.format("[crossfield]GetRemoteRankRangeSession.RGetRomoteRankRange.process@get single cross field rank from grc|rankid=%d|from=%d|to=%d", new Object[] { Long.valueOf(this.rankid), Integer.valueOf(0), Integer.valueOf(rank) }));
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossfield\main\GetRemoteRankRangeSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
/*    */ package mzm.gsp.ladder.main;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.crossserver.event.CleanLadderRankDoneArg;
/*    */ import mzm.gsp.crossserver.event.CleanLadderRankDoneProcedure;
/*    */ import mzm.gsp.crossserver.main.CrossServerInterface;
/*    */ import mzm.gsp.ladder.CleanLadderRankContext;
/*    */ import mzm.gsp.util.CommonUtils;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class POnCleanLadderRankDone extends CleanLadderRankDoneProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 16 */     CleanLadderRankContext context = new CleanLadderRankContext();
/* 17 */     context.unmarshal(new OctetsStream(((CleanLadderRankDoneArg)this.arg).getContext()));
/* 18 */     if (((CleanLadderRankDoneArg)this.arg).isSucceed())
/*    */     {
/* 20 */       GameServer.logger().info(String.format("[Ladder]POnRemoveLadderRankInfoDone.processImp@clean ladder rank success|count=%d|code=%d|season_begin_timestamp=%d|level_range=%d", new Object[] { Integer.valueOf(context.count), Integer.valueOf(((CleanLadderRankDoneArg)this.arg).getRetCode()), Integer.valueOf(CommonUtils.getLongHigh(((CleanLadderRankDoneArg)this.arg).getRankid())), Integer.valueOf(CommonUtils.getLongLow(((CleanLadderRankDoneArg)this.arg).getRankid())) }));
/*    */       
/*    */ 
/*    */ 
/*    */ 
/* 25 */       return true;
/*    */     }
/* 27 */     GameServer.logger().info(String.format("[Ladder]POnRemoveLadderRankInfoDone.processImp@clean ladder rank fail|count=%d|code=%d|season_begin_timestamp=%d|level_range=%d", new Object[] { Integer.valueOf(context.count), Integer.valueOf(((CleanLadderRankDoneArg)this.arg).getRetCode()), Integer.valueOf(CommonUtils.getLongHigh(((CleanLadderRankDoneArg)this.arg).getRankid())), Integer.valueOf(CommonUtils.getLongLow(((CleanLadderRankDoneArg)this.arg).getRankid())) }));
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 33 */     if (!((CleanLadderRankDoneArg)this.arg).isTimeout())
/*    */     {
/* 35 */       return false;
/*    */     }
/* 37 */     if (context.count < LadderManager.GRC_MAX_TRY_TIMES)
/*    */     {
/* 39 */       context.count += 1;
/* 40 */       OctetsStream os = new OctetsStream();
/* 41 */       context.marshal(os);
/* 42 */       CrossServerInterface.asyncCleanLadderRank(((CleanLadderRankDoneArg)this.arg).getRankid(), os);
/*    */     }
/* 44 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ladder\main\POnCleanLadderRankDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
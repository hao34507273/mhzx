/*    */ package mzm.gsp.ladder.main;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.crossserver.event.GetLadderRoleRankDoneArg;
/*    */ import mzm.gsp.ladder.GetLadderRoleRankContext;
/*    */ import mzm.gsp.ladder.GetLadderRoleRank_SelfReq;
/*    */ import mzm.gsp.ladder.SLadderSelfRankRes;
/*    */ import mzm.gsp.ladder.confbean.SLadderGradeCfg;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.Ladder;
/*    */ 
/*    */ public class POnGetLadderRoleRankDone extends mzm.gsp.crossserver.event.GetLadderRoleRankDoneProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 18 */     GetLadderRoleRankContext getLadderRoleRankContext = new GetLadderRoleRankContext();
/* 19 */     getLadderRoleRankContext.unmarshal(new OctetsStream(((GetLadderRoleRankDoneArg)this.arg).getContext()));
/* 20 */     int levelRange = mzm.gsp.util.CommonUtils.getLongLow(((GetLadderRoleRankDoneArg)this.arg).getRankid());
/* 21 */     SLadderGradeCfg cfg = SLadderGradeCfg.get(levelRange);
/* 22 */     if (cfg == null)
/*    */     {
/* 24 */       return false;
/*    */     }
/* 26 */     switch (getLadderRoleRankContext.oper_type) {
/*    */     case 0: 
/* 28 */       GetLadderRoleRank_SelfReq selfReq = new GetLadderRoleRank_SelfReq();
/* 29 */       selfReq.unmarshal(new OctetsStream(getLadderRoleRankContext.content));
/* 30 */       if (((GetLadderRoleRankDoneArg)this.arg).isSucceed()) {
/* 31 */         sendResult(cfg.remoteChartType, ((GetLadderRoleRankDoneArg)this.arg).rank());
/* 32 */         return true;
/*    */       }
/* 34 */       GameServer.logger().info(String.format("[Ladder]POnGetLadderRoleRankDone.processImp@get ladder role rank fail|type=%d|roleid=%d|errorCode=%d|count=%d", new Object[] { Integer.valueOf(getLadderRoleRankContext.oper_type), Long.valueOf(((GetLadderRoleRankDoneArg)this.arg).getRoleid()), Integer.valueOf(((GetLadderRoleRankDoneArg)this.arg).getRetCode()), Integer.valueOf(getLadderRoleRankContext.count) }));
/*    */       
/*    */ 
/*    */ 
/*    */ 
/* 39 */       if (((GetLadderRoleRankDoneArg)this.arg).isNotInRank()) {
/* 40 */         sendResult(cfg.remoteChartType, -1);
/* 41 */         return true;
/*    */       }
/* 43 */       if (!((GetLadderRoleRankDoneArg)this.arg).isTimeout()) {
/* 44 */         return false;
/*    */       }
/* 46 */       if (getLadderRoleRankContext.count >= LadderManager.GRC_MAX_TRY_TIMES) {
/* 47 */         return false;
/*    */       }
/* 49 */       getLadderRoleRankContext.count += 1;
/* 50 */       OctetsStream selfReqOs = new OctetsStream();
/* 51 */       selfReq.marshal(selfReqOs);
/* 52 */       getLadderRoleRankContext.content = selfReqOs;
/*    */       
/* 54 */       OctetsStream ladderRoleRankContextOs = new OctetsStream();
/* 55 */       getLadderRoleRankContext.marshal(ladderRoleRankContextOs);
/* 56 */       mzm.gsp.crossserver.main.CrossServerInterface.asyncGetLadderRoleRank(((GetLadderRoleRankDoneArg)this.arg).getRankid(), ((GetLadderRoleRankDoneArg)this.arg).getRoleid(), ladderRoleRankContextOs);
/*    */       
/*    */ 
/* 59 */       break;
/*    */     
/*    */     default: 
/* 62 */       GameServer.logger().info(String.format("[Ladder]POnGetLadderRoleRankDone.processImp@do not handle type|type=%d", new Object[] { Integer.valueOf(getLadderRoleRankContext.oper_type) }));
/*    */     }
/*    */     
/*    */     
/*    */ 
/* 67 */     return true;
/*    */   }
/*    */   
/*    */   private void sendResult(int chartType, int rank) {
/* 71 */     SLadderSelfRankRes ladderSelfRankRes = new SLadderSelfRankRes();
/* 72 */     if (rank >= 0) {
/* 73 */       rank++;
/*    */     }
/* 75 */     ladderSelfRankRes.rank = rank;
/* 76 */     ladderSelfRankRes.ranktype = chartType;
/* 77 */     Ladder xLadder = LadderManager.getAndInitXLadder(((GetLadderRoleRankDoneArg)this.arg).getRoleid(), false);
/* 78 */     if (xLadder != null) {
/* 79 */       ladderSelfRankRes.score = LadderManager.getScore(((GetLadderRoleRankDoneArg)this.arg).getRoleid(), xLadder);
/* 80 */       ladderSelfRankRes.stage = xLadder.getStage();
/*    */     }
/* 82 */     OnlineManager.getInstance().send(((GetLadderRoleRankDoneArg)this.arg).getRoleid(), ladderSelfRankRes);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ladder\main\POnGetLadderRoleRankDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
/*    */ package mzm.gsp.ladder.main;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ import mzm.gsp.crossserver.main.CrossServerInterface;
/*    */ import mzm.gsp.ladder.GetLadderRoleRankContext;
/*    */ import mzm.gsp.ladder.GetLadderRoleRank_SelfReq;
/*    */ import mzm.gsp.ladder.SLadderSelfRankRes;
/*    */ import mzm.gsp.ladder.confbean.SLadderRankCfg;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import xbean.Ladder;
/*    */ import xtable.Role2ladder;
/*    */ 
/*    */ public class PCLadderSelfRankReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int rankType;
/*    */   
/*    */   public PCLadderSelfRankReq(long roleid, int ranktype)
/*    */   {
/* 22 */     this.roleid = roleid;
/* 23 */     this.rankType = ranktype;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 28 */     if (!OpenInterface.getOpenStatus(188))
/*    */     {
/* 30 */       return false;
/*    */     }
/* 32 */     if (LadderManager.checkInCross(this.roleid))
/*    */     {
/* 34 */       return false;
/*    */     }
/* 36 */     SLadderRankCfg cfg = SLadderRankCfg.get(this.rankType);
/* 37 */     if (cfg == null)
/*    */     {
/* 39 */       return false;
/*    */     }
/* 41 */     if (!cfg.isLocal) {
/* 42 */       Long beforeTime = LadderManager.getBeforeSessionTimeMilSec(mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis());
/* 43 */       if (beforeTime == null) {
/* 44 */         SLadderSelfRankRes ladderSelfRankRes = new SLadderSelfRankRes();
/* 45 */         ladderSelfRankRes.rank = -1;
/* 46 */         ladderSelfRankRes.ranktype = this.rankType;
/* 47 */         OnlineManager.getInstance().send(this.roleid, ladderSelfRankRes);
/* 48 */         return false;
/*    */       }
/* 50 */       GetLadderRoleRankContext getLadderRoleRankContext = new GetLadderRoleRankContext();
/* 51 */       getLadderRoleRankContext.oper_type = 0;
/* 52 */       getLadderRoleRankContext.count = 1;
/*    */       
/* 54 */       GetLadderRoleRank_SelfReq selfReq = new GetLadderRoleRank_SelfReq();
/* 55 */       selfReq.roleid = this.roleid;
/* 56 */       OctetsStream selfReqOs = new OctetsStream();
/* 57 */       selfReq.marshal(selfReqOs);
/*    */       
/* 59 */       getLadderRoleRankContext.content.replace(selfReqOs);
/*    */       
/* 61 */       OctetsStream ladderRoleRankContextOs = new OctetsStream();
/* 62 */       getLadderRoleRankContext.marshal(ladderRoleRankContextOs);
/*    */       
/* 64 */       CrossServerInterface.asyncGetLadderRoleRank(LadderManager.getRemoteRankid(beforeTime.longValue(), cfg.level), this.roleid, ladderRoleRankContextOs);
/*    */       
/* 66 */       return true;
/*    */     }
/*    */     
/* 69 */     int rank = LadderRankManager.getInstance().getRankByChartType(this.roleid, cfg.chartType);
/* 70 */     SLadderSelfRankRes ladderSelfRankRes = new SLadderSelfRankRes();
/* 71 */     ladderSelfRankRes.rank = (rank + 1);
/* 72 */     ladderSelfRankRes.ranktype = this.rankType;
/* 73 */     Ladder xLadder = Role2ladder.select(Long.valueOf(this.roleid));
/* 74 */     if (xLadder != null) {
/* 75 */       ladderSelfRankRes.score = LadderManager.getScore(this.roleid, xLadder);
/* 76 */       ladderSelfRankRes.stage = xLadder.getStage();
/*    */     }
/* 78 */     OnlineManager.getInstance().send(this.roleid, ladderSelfRankRes);
/* 79 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ladder\main\PCLadderSelfRankReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
/*     */ package mzm.gsp.ladder.main;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import mzm.gsp.crossserver.main.CrossServerInterface;
/*     */ import mzm.gsp.ladder.GetLadderRankRangeContext;
/*     */ import mzm.gsp.ladder.GetLadderRankRange_ClientReq;
/*     */ import mzm.gsp.ladder.LadderRankRoleData;
/*     */ import mzm.gsp.ladder.SLadderRankRes;
/*     */ import mzm.gsp.ladder.confbean.SLadderRankCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.Ladder;
/*     */ import xtable.Role2ladder;
/*     */ 
/*     */ public class PCLadderRankReq extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int rankType;
/*     */   private int fromNO;
/*     */   private final int toNO;
/*     */   
/*     */   public PCLadderRankReq(long roleid, int ranktype, int fromno, int tono)
/*     */   {
/*  28 */     this.roleid = roleid;
/*  29 */     this.rankType = ranktype;
/*  30 */     this.fromNO = fromno;
/*  31 */     this.toNO = tono;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  36 */     if (!OpenInterface.getOpenStatus(188))
/*     */     {
/*  38 */       return false;
/*     */     }
/*  40 */     if (LadderManager.checkInCross(this.roleid))
/*     */     {
/*  42 */       return false;
/*     */     }
/*  44 */     SLadderRankCfg cfg = SLadderRankCfg.get(this.rankType);
/*  45 */     if (cfg == null)
/*     */     {
/*  47 */       return false;
/*     */     }
/*     */     
/*  50 */     if (this.fromNO <= 0) {
/*  51 */       return false;
/*     */     }
/*  53 */     if (this.fromNO > this.toNO) {
/*  54 */       return false;
/*     */     }
/*     */     
/*  57 */     if (!cfg.isLocal) {
/*  58 */       Long beforeSeasonTime = LadderManager.getBeforeSessionTimeMilSec(mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis());
/*  59 */       if (beforeSeasonTime == null) {
/*  60 */         SLadderRankRes ladderRankRes = new SLadderRankRes();
/*  61 */         ladderRankRes.ranktype = this.rankType;
/*  62 */         OnlineManager.getInstance().sendAtOnce(this.roleid, ladderRankRes);
/*  63 */         return false;
/*     */       }
/*  65 */       GetLadderRankRangeContext getLadderRankRangeContext = new GetLadderRankRangeContext();
/*  66 */       getLadderRankRangeContext.oper_type = 0;
/*  67 */       getLadderRankRangeContext.count = 1;
/*     */       
/*  69 */       GetLadderRankRange_ClientReq clientReq = new GetLadderRankRange_ClientReq();
/*  70 */       clientReq.roleid = this.roleid;
/*  71 */       OctetsStream clientReqOs = new OctetsStream();
/*  72 */       clientReq.marshal(clientReqOs);
/*     */       
/*  74 */       getLadderRankRangeContext.content = clientReqOs;
/*     */       
/*  76 */       OctetsStream ladderRankRangeContextOs = new OctetsStream();
/*  77 */       getLadderRankRangeContext.marshal(ladderRankRangeContextOs);
/*     */       
/*  79 */       CrossServerInterface.asyncGetLadderRankRange(LadderManager.getRemoteRankid(beforeSeasonTime.longValue(), cfg.level), this.fromNO - 1, this.toNO - 1, ladderRankRangeContextOs);
/*     */       
/*  81 */       return true;
/*     */     }
/*     */     
/*  84 */     List<LadderChartObj> ladderChartObjs = LadderRankManager.getInstance().getchartObjsByChartType(cfg.chartType, this.fromNO - 1, this.toNO - 1);
/*     */     
/*     */ 
/*  87 */     SLadderRankRes ladderRankRes = new SLadderRankRes();
/*  88 */     ladderRankRes.ranktype = this.rankType;
/*  89 */     for (int i = 0; i < ladderChartObjs.size(); i++) {
/*  90 */       LadderChartObj ladderChartObj = (LadderChartObj)ladderChartObjs.get(i);
/*  91 */       long roleid = ladderChartObj.roleid;
/*  92 */       Ladder xLadder = Role2ladder.select(Long.valueOf(ladderChartObj.roleid));
/*  93 */       if (xLadder == null) {
/*  94 */         this.fromNO -= 1;
/*     */       }
/*     */       else {
/*  97 */         LadderRankRoleData ladderRankRoleData = new LadderRankRoleData();
/*  98 */         ladderRankRoleData.occupation = RoleInterface.getOccupationId(roleid);
/*  99 */         ladderRankRoleData.rank = (this.fromNO + i);
/* 100 */         ladderRankRoleData.roleid = roleid;
/* 101 */         ladderRankRoleData.rolename = RoleInterface.getName(roleid);
/* 102 */         ladderRankRoleData.score = LadderManager.getScore(roleid, xLadder);
/* 103 */         ladderRankRoleData.stage = xLadder.getStage();
/* 104 */         ladderRankRes.rankdatas.add(ladderRankRoleData);
/*     */       } }
/* 106 */     OnlineManager.getInstance().send(this.roleid, ladderRankRes);
/* 107 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ladder\main\PCLadderRankReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
/*     */ package mzm.gsp.ladder.main;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.crossserver.event.GetLadderRankRangeDoneArg;
/*     */ import mzm.gsp.ladder.GetLadderRankRangeContext;
/*     */ import mzm.gsp.ladder.GetLadderRankRange_ClientReq;
/*     */ import mzm.gsp.ladder.GetLadderRankRange_SendRankAward;
/*     */ import mzm.gsp.ladder.LadderRankRoleData;
/*     */ import mzm.gsp.ladder.SLadderRankRes;
/*     */ import mzm.gsp.ladder.confbean.SLadderGradeCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.util.CommonUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.CrossLadderLevelRangeRankBackup;
/*     */ import xbean.CrossLadderRankAwardInfo;
/*     */ import xbean.CrossLadderSeasonRankBackup;
/*     */ 
/*     */ public class POnGetLadderRankRangeDone extends mzm.gsp.crossserver.event.GetLadderRankRangeDoneProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  26 */     GetLadderRankRangeContext ladderRankRangeContext = new GetLadderRankRangeContext();
/*  27 */     ladderRankRangeContext.unmarshal(new OctetsStream(((GetLadderRankRangeDoneArg)this.arg).getContext()));
/*  28 */     long seasonBeginTimestamp = CommonUtils.getLongHigh(((GetLadderRankRangeDoneArg)this.arg).getRankid()) * 1000L;
/*  29 */     int levelRange = CommonUtils.getLongLow(((GetLadderRankRangeDoneArg)this.arg).getRankid());
/*  30 */     SLadderGradeCfg cfg = SLadderGradeCfg.get(levelRange);
/*  31 */     if (cfg == null)
/*     */     {
/*  33 */       return false;
/*     */     }
/*  35 */     switch (ladderRankRangeContext.oper_type) {
/*     */     case 0: 
/*  37 */       GetLadderRankRange_ClientReq clientReq = new GetLadderRankRange_ClientReq();
/*  38 */       clientReq.unmarshal(new OctetsStream(ladderRankRangeContext.content));
/*  39 */       if (((GetLadderRankRangeDoneArg)this.arg).isSucceed()) {
/*  40 */         ArrayList<LadderRankRoleData> list = ((GetLadderRankRangeDoneArg)this.arg).rankRange();
/*  41 */         sendLadderRankData(clientReq.roleid, cfg.remoteChartType, ((GetLadderRankRangeDoneArg)this.arg).getFrom() + 1, list);
/*  42 */         return true;
/*     */       }
/*     */       
/*  45 */       GameServer.logger().info(String.format("[Ladder]POnGetLadderRankRangeDone.processImp@get ladder rank range fall|errorcode=%d|rankid=%d|from=%d|to=%d|roleid=%d|count=%d", new Object[] { Integer.valueOf(((GetLadderRankRangeDoneArg)this.arg).getRetCode()), Long.valueOf(((GetLadderRankRangeDoneArg)this.arg).getRankid()), Integer.valueOf(((GetLadderRankRangeDoneArg)this.arg).getFrom()), Integer.valueOf(((GetLadderRankRangeDoneArg)this.arg).getTo()), Long.valueOf(clientReq.roleid), Integer.valueOf(ladderRankRangeContext.count) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  51 */       if (((GetLadderRankRangeDoneArg)this.arg).isNoRankData()) {
/*  52 */         sendLadderRankData(clientReq.roleid, cfg.remoteChartType, ((GetLadderRankRangeDoneArg)this.arg).getFrom() + 1, null);
/*  53 */         return true;
/*     */       }
/*  55 */       if (!((GetLadderRankRangeDoneArg)this.arg).isTimeout()) {
/*  56 */         return false;
/*     */       }
/*  58 */       if (ladderRankRangeContext.count >= LadderManager.GRC_MAX_TRY_TIMES) {
/*  59 */         return false;
/*     */       }
/*     */       
/*  62 */       ladderRankRangeContext.count += 1;
/*  63 */       OctetsStream clientReqOs = new OctetsStream();
/*  64 */       clientReq.marshal(clientReqOs);
/*  65 */       ladderRankRangeContext.content = clientReqOs;
/*     */       
/*  67 */       OctetsStream ladderRankRangeContextOs = new OctetsStream();
/*  68 */       ladderRankRangeContext.marshal(ladderRankRangeContextOs);
/*     */       
/*  70 */       mzm.gsp.crossserver.main.CrossServerInterface.asyncGetLadderRankRange(((GetLadderRankRangeDoneArg)this.arg).getRankid(), ((GetLadderRankRangeDoneArg)this.arg).getFrom(), ((GetLadderRankRangeDoneArg)this.arg).getTo(), ladderRankRangeContextOs);
/*     */       
/*  72 */       return true;
/*     */     
/*     */ 
/*     */     case 1: 
/*  76 */       GetLadderRankRange_SendRankAward content = new GetLadderRankRange_SendRankAward();
/*  77 */       content.unmarshal(new OctetsStream(ladderRankRangeContext.content));
/*  78 */       if ((!((GetLadderRankRangeDoneArg)this.arg).isSucceed()) && (!((GetLadderRankRangeDoneArg)this.arg).isNoRankData()))
/*     */       {
/*  80 */         GameServer.logger().error(String.format("[Ladder]POnGetLadderRankRangeDone.processImp@get ladder rank range fail|errorcode=%d|rankid=%d|from=%d|to=%d|count=%d", new Object[] { Integer.valueOf(((GetLadderRankRangeDoneArg)this.arg).getRetCode()), Long.valueOf(((GetLadderRankRangeDoneArg)this.arg).getRankid()), Integer.valueOf(((GetLadderRankRangeDoneArg)this.arg).getFrom()), Integer.valueOf(((GetLadderRankRangeDoneArg)this.arg).getTo()), Integer.valueOf(ladderRankRangeContext.count) }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*  85 */         if (!((GetLadderRankRangeDoneArg)this.arg).isTimeout())
/*     */         {
/*  87 */           return false;
/*     */         }
/*  89 */         if (ladderRankRangeContext.count >= LadderManager.GRC_MAX_TRY_TIMES)
/*     */         {
/*  91 */           return false;
/*     */         }
/*     */         
/*  94 */         ladderRankRangeContext.count += 1;
/*  95 */         OctetsStream ladderRankRangeContextOs = new OctetsStream();
/*  96 */         ladderRankRangeContext.marshal(ladderRankRangeContextOs);
/*     */         
/*  98 */         mzm.gsp.crossserver.main.CrossServerInterface.asyncGetLadderRankRange(((GetLadderRankRangeDoneArg)this.arg).getRankid(), ((GetLadderRankRangeDoneArg)this.arg).getFrom(), ((GetLadderRankRangeDoneArg)this.arg).getTo(), ladderRankRangeContextOs);
/*     */         
/* 100 */         return false;
/*     */       }
/* 102 */       List<LadderRankRoleData> rankDatas = new ArrayList();
/* 103 */       if (((GetLadderRankRangeDoneArg)this.arg).rankRange() != null)
/*     */       {
/* 105 */         rankDatas.addAll(((GetLadderRankRangeDoneArg)this.arg).rankRange());
/*     */       }
/* 107 */       int rank = mzm.gsp.chart.main.RankInterface.getAwardRank(content.chart_type);
/* 108 */       if (rank < 0)
/*     */       {
/*     */ 
/* 111 */         return false;
/*     */       }
/*     */       
/* 114 */       long localid = mzm.gsp.GameServerInfoManager.getLocalId();
/* 115 */       xbean.CrossLadderRankBackup xCrossLadderRankBackup = xtable.Cross_ladder_rank_backups.get(Long.valueOf(localid));
/* 116 */       if (xCrossLadderRankBackup == null)
/*     */       {
/*     */ 
/* 119 */         return false;
/*     */       }
/* 121 */       CrossLadderSeasonRankBackup xCrossLadderSeasonRankBackup = (CrossLadderSeasonRankBackup)xCrossLadderRankBackup.getBackups().get(Long.valueOf(seasonBeginTimestamp));
/*     */       
/* 123 */       if (xCrossLadderSeasonRankBackup == null)
/*     */       {
/*     */ 
/* 126 */         return false;
/*     */       }
/* 128 */       CrossLadderLevelRangeRankBackup xCrossLadderLevelRangeRankBackup = (CrossLadderLevelRangeRankBackup)xCrossLadderSeasonRankBackup.getLevel_range_rank_backups().get(Integer.valueOf(levelRange));
/*     */       
/* 130 */       if (xCrossLadderLevelRangeRankBackup == null)
/*     */       {
/*     */ 
/* 133 */         return false;
/*     */       }
/* 135 */       CrossLadderRankAwardInfo xCrossLadderRankAwardInfo = (CrossLadderRankAwardInfo)xCrossLadderLevelRangeRankBackup.getRank_award_infos().get(Integer.valueOf(content.chart_type));
/*     */       
/* 137 */       if ((xCrossLadderRankAwardInfo == null) || (xCrossLadderRankAwardInfo.getIs_data_complete()))
/*     */       {
/*     */ 
/* 140 */         return false;
/*     */       }
/* 142 */       xCrossLadderRankAwardInfo.setIs_data_complete(true);
/* 143 */       for (int i = 0; (i < rankDatas.size()) && (i <= rank); i++)
/*     */       {
/* 145 */         long roleid = ((LadderRankRoleData)rankDatas.get(i)).roleid;
/* 146 */         if (mzm.gsp.GameServerInfoManager.isRoleInOwnServer(roleid))
/*     */         {
/*     */ 
/*     */ 
/* 150 */           if (!xCrossLadderRankAwardInfo.getRole_rank_award_infos().containsKey(Long.valueOf(roleid)))
/*     */           {
/*     */ 
/*     */ 
/* 154 */             xbean.RoleCrossLadderRankAwardInfo xRoleCrossLadderRankAwardInfo = xbean.Pod.newRoleCrossLadderRankAwardInfo();
/* 155 */             xRoleCrossLadderRankAwardInfo.setRank(i);
/* 156 */             xCrossLadderRankAwardInfo.getRole_rank_award_infos().put(Long.valueOf(roleid), xRoleCrossLadderRankAwardInfo);
/*     */             
/* 158 */             if (mzm.gsp.open.main.OpenInterface.getOpenStatus(188))
/*     */             {
/* 160 */               LadderRankManager.getInstance().sendRankAward(roleid, seasonBeginTimestamp, levelRange, content.chart_type); }
/*     */           } }
/*     */       }
/* 163 */       return true;
/*     */     }
/*     */     
/* 166 */     GameServer.logger().error(String.format("[Ladder]POnGetLadderRankRangeDone.processImp@not handled type|type=%d", new Object[] { Integer.valueOf(ladderRankRangeContext.oper_type) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 171 */     return true;
/*     */   }
/*     */   
/*     */   private void sendLadderRankData(long roleid, int chartType, int fromNO, ArrayList<LadderRankRoleData> list) {
/* 175 */     SLadderRankRes ladderRankRes = new SLadderRankRes();
/* 176 */     ladderRankRes.ranktype = chartType;
/* 177 */     if (list == null) {
/* 178 */       OnlineManager.getInstance().send(roleid, ladderRankRes);
/* 179 */       return;
/*     */     }
/* 181 */     for (int i = 0; i < list.size(); i++) {
/* 182 */       LadderRankRoleData ladderRankRoleData = (LadderRankRoleData)list.get(i);
/* 183 */       ladderRankRoleData.rank = (fromNO + i);
/* 184 */       ladderRankRes.rankdatas.add(ladderRankRoleData);
/*     */     }
/* 186 */     OnlineManager.getInstance().send(roleid, ladderRankRes);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ladder\main\POnGetLadderRankRangeDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
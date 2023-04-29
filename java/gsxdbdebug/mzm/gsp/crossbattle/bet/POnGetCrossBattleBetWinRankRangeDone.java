/*     */ package mzm.gsp.crossbattle.bet;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.crossbattle.CrossBattleBetRankData;
/*     */ import mzm.gsp.crossbattle.GetCrossBattleBetRankContext;
/*     */ import mzm.gsp.crossbattle.GetCrossBattleBetRank_ClientReq;
/*     */ import mzm.gsp.crossbattle.SGetCrossBattleBetRankFail;
/*     */ import mzm.gsp.crossbattle.SGetCrossBattleBetRankSuccess;
/*     */ import mzm.gsp.crossserver.event.GetCrossBattleBetWinRankRangeDoneArg;
/*     */ import mzm.gsp.crossserver.main.CrossServerInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.CrossBattleBetRankAwardInfo;
/*     */ import xbean.CrossBattleBetRankBackup;
/*     */ import xbean.CrossBattleBetSeasonRankBackup;
/*     */ import xbean.Pod;
/*     */ import xbean.RoleCrossBattleBetRankAwardInfo;
/*     */ import xtable.Cross_battle_bet_rank_backups;
/*     */ 
/*     */ public class POnGetCrossBattleBetWinRankRangeDone extends mzm.gsp.crossserver.event.GetCrossBattleBetWinRankRangeDoneProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  28 */     GetCrossBattleBetRankContext context = new GetCrossBattleBetRankContext();
/*  29 */     context.unmarshal(OctetsStream.wrap(((GetCrossBattleBetWinRankRangeDoneArg)this.arg).getContext()));
/*  30 */     switch (context.oper_type)
/*     */     {
/*     */ 
/*     */     case 0: 
/*  34 */       GetCrossBattleBetRank_ClientReq extraInfo = new GetCrossBattleBetRank_ClientReq();
/*  35 */       extraInfo.unmarshal(OctetsStream.wrap(context.extra_info));
/*  36 */       long roleid = extraInfo.roleid;
/*  37 */       if ((!((GetCrossBattleBetWinRankRangeDoneArg)this.arg).isSucceed()) && (!((GetCrossBattleBetWinRankRangeDoneArg)this.arg).isNoRankData()))
/*     */       {
/*  39 */         if (!((GetCrossBattleBetWinRankRangeDoneArg)this.arg).isTimeout())
/*     */         {
/*  41 */           SGetCrossBattleBetRankFail protocol = new SGetCrossBattleBetRankFail();
/*  42 */           protocol.res = 10;
/*  43 */           OnlineManager.getInstance().sendAtOnce(roleid, protocol);
/*  44 */           CrossBattleBetManager.logger.info(String.format("[crossbattle]POnGetCrossBattleBetWinRankRangeDone.processImp@get cross battle bet win rank fail|count=%d|roleid=%d|rankid=%d", new Object[] { Byte.valueOf(context.count), Long.valueOf(roleid), Long.valueOf(((GetCrossBattleBetWinRankRangeDoneArg)this.arg).getRankid()) }));
/*     */           
/*     */ 
/*  47 */           return false;
/*     */         }
/*  49 */         CrossBattleBetManager.logger.info(String.format("[crossbattle]POnGetCrossBattleBetWinRankRangeDone.processImp@get cross battle bet win rank timeout|count=%d|roleid=%d|rankid=%d", new Object[] { Byte.valueOf(context.count), Long.valueOf(roleid), Long.valueOf(((GetCrossBattleBetWinRankRangeDoneArg)this.arg).getRankid()) }));
/*     */         
/*     */ 
/*  52 */         if (context.count < CrossBattleBetManager.GRC_MAX_TRY_TIMES)
/*     */         {
/*  54 */           GetCrossBattleBetRankContext tmp255_254 = context;tmp255_254.count = ((byte)(tmp255_254.count + 1));
/*  55 */           if (!CrossServerInterface.getCrossBattleBetWinRankRange(((GetCrossBattleBetWinRankRangeDoneArg)this.arg).getRankid(), ((GetCrossBattleBetWinRankRangeDoneArg)this.arg).getFrom(), ((GetCrossBattleBetWinRankRangeDoneArg)this.arg).getTo(), context.marshal(new OctetsStream())))
/*     */           {
/*     */ 
/*     */ 
/*  59 */             SGetCrossBattleBetRankFail protocol = new SGetCrossBattleBetRankFail();
/*  60 */             protocol.res = 10;
/*  61 */             OnlineManager.getInstance().sendAtOnce(roleid, protocol);
/*  62 */             CrossBattleBetManager.logger.info(String.format("[crossbattle]POnGetCrossBattleBetWinRankRangeDone.processImp@communication error|count=%d|roleid=%d|rankid=%d", new Object[] { Byte.valueOf(context.count), Long.valueOf(roleid), Long.valueOf(((GetCrossBattleBetWinRankRangeDoneArg)this.arg).getRankid()) }));
/*     */             
/*     */ 
/*  65 */             return false;
/*     */           }
/*  67 */           CrossBattleBetManager.logger.info(String.format("[crossbattle]POnGetCrossBattleBetWinRankRangeDone.processImp@get cross battle bet win rank from grc|count=%d|roleid=%d|rankid=%d", new Object[] { Byte.valueOf(context.count), Long.valueOf(roleid), Long.valueOf(((GetCrossBattleBetWinRankRangeDoneArg)this.arg).getRankid()) }));
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/*     */ 
/*  73 */           SGetCrossBattleBetRankFail protocol = new SGetCrossBattleBetRankFail();
/*  74 */           protocol.res = 10;
/*  75 */           OnlineManager.getInstance().sendAtOnce(roleid, protocol);
/*     */         }
/*  77 */         return false;
/*     */       }
/*  79 */       sendResult(roleid, (int)((GetCrossBattleBetWinRankRangeDoneArg)this.arg).getRankid(), ((GetCrossBattleBetWinRankRangeDoneArg)this.arg).getFrom() + 1, ((GetCrossBattleBetWinRankRangeDoneArg)this.arg).getRankRange());
/*  80 */       CrossBattleBetManager.logger.info(String.format("[crossbattle]POnGetCrossBattleBetWinRankRangeDone.processImp@get cross battle bet win rank success|count=%d|roleid=%d|rankid=%d", new Object[] { Byte.valueOf(context.count), Long.valueOf(roleid), Long.valueOf(((GetCrossBattleBetWinRankRangeDoneArg)this.arg).getRankid()) }));
/*     */       
/*     */ 
/*  83 */       return true;
/*     */     
/*     */ 
/*     */     case 1: 
/*  87 */       if ((!((GetCrossBattleBetWinRankRangeDoneArg)this.arg).isSucceed()) && (!((GetCrossBattleBetWinRankRangeDoneArg)this.arg).isNoRankData()))
/*     */       {
/*  89 */         if (!((GetCrossBattleBetWinRankRangeDoneArg)this.arg).isTimeout())
/*     */         {
/*  91 */           CrossBattleBetManager.logger.info(String.format("[crossbattle]POnGetCrossBattleBetWinRankRangeDone.processImp@get cross battle bet win rank fail|count=%d|rankid=%d", new Object[] { Byte.valueOf(context.count), Long.valueOf(((GetCrossBattleBetWinRankRangeDoneArg)this.arg).getRankid()) }));
/*     */           
/*     */ 
/*  94 */           return false;
/*     */         }
/*  96 */         CrossBattleBetManager.logger.info(String.format("[crossbattle]POnGetCrossBattleBetWinRankRangeDone.processImp@get cross battle bet win rank timeout|count=%d|rankid=%d", new Object[] { Byte.valueOf(context.count), Long.valueOf(((GetCrossBattleBetWinRankRangeDoneArg)this.arg).getRankid()) }));
/*     */         
/*     */ 
/*  99 */         if (context.count < CrossBattleBetManager.GRC_MAX_TRY_TIMES)
/*     */         {
/* 101 */           GetCrossBattleBetRankContext tmp689_688 = context;tmp689_688.count = ((byte)(tmp689_688.count + 1));
/* 102 */           if (!CrossServerInterface.getCrossBattleBetWinRankRange(((GetCrossBattleBetWinRankRangeDoneArg)this.arg).getRankid(), ((GetCrossBattleBetWinRankRangeDoneArg)this.arg).getFrom(), ((GetCrossBattleBetWinRankRangeDoneArg)this.arg).getTo(), context.marshal(new OctetsStream())))
/*     */           {
/*     */ 
/*     */ 
/* 106 */             CrossBattleBetManager.logger.info(String.format("[crossbattle]POnGetCrossBattleBetWinRankRangeDone.processImp@communication error|count=%d|rankid=%d", new Object[] { Byte.valueOf(context.count), Long.valueOf(((GetCrossBattleBetWinRankRangeDoneArg)this.arg).getRankid()) }));
/*     */             
/*     */ 
/* 109 */             return false;
/*     */           }
/* 111 */           CrossBattleBetManager.logger.info(String.format("[crossbattle]POnGetCrossBattleBetWinRankRangeDone.processImp@get cross battle bet win from grc|count=%d|rankid=%d", new Object[] { Byte.valueOf(context.count), Long.valueOf(((GetCrossBattleBetWinRankRangeDoneArg)this.arg).getRankid()) }));
/*     */         }
/*     */         
/*     */ 
/* 115 */         return false;
/*     */       }
/* 117 */       int rank = mzm.gsp.chart.main.RankInterface.getAwardRank(50);
/* 118 */       if (rank < 0)
/*     */       {
/*     */ 
/* 121 */         return false;
/*     */       }
/* 123 */       int activityCfgid = (int)((GetCrossBattleBetWinRankRangeDoneArg)this.arg).getRankid();
/*     */       
/* 125 */       CrossBattleBetRankBackup xCrossBattleBetRankBackup = Cross_battle_bet_rank_backups.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 126 */       if (xCrossBattleBetRankBackup == null)
/*     */       {
/*     */ 
/* 129 */         return false;
/*     */       }
/* 131 */       CrossBattleBetSeasonRankBackup xCrossBattleBetSeasonRankBackup = (CrossBattleBetSeasonRankBackup)xCrossBattleBetRankBackup.getBackups().get(Integer.valueOf(activityCfgid));
/*     */       
/* 133 */       if (xCrossBattleBetSeasonRankBackup == null)
/*     */       {
/*     */ 
/* 136 */         return false;
/*     */       }
/* 138 */       CrossBattleBetRankAwardInfo xCrossBattleBetRankAwardInfo = (CrossBattleBetRankAwardInfo)xCrossBattleBetSeasonRankBackup.getRank_award_infos().get(Integer.valueOf(50));
/*     */       
/* 140 */       if ((xCrossBattleBetRankAwardInfo != null) && (xCrossBattleBetRankAwardInfo.getIs_data_complete()))
/*     */       {
/*     */ 
/* 143 */         return false;
/*     */       }
/* 145 */       if (xCrossBattleBetRankAwardInfo == null)
/*     */       {
/* 147 */         xCrossBattleBetRankAwardInfo = Pod.newCrossBattleBetRankAwardInfo();
/* 148 */         xCrossBattleBetSeasonRankBackup.getRank_award_infos().put(Integer.valueOf(50), xCrossBattleBetRankAwardInfo);
/*     */       }
/*     */       
/* 151 */       xCrossBattleBetRankAwardInfo.setIs_data_complete(true);
/* 152 */       for (int i = 0; (i < ((GetCrossBattleBetWinRankRangeDoneArg)this.arg).getRankRange().size()) && (i <= rank); i++)
/*     */       {
/* 154 */         long roleid = ((CrossBattleBetRankData)((GetCrossBattleBetWinRankRangeDoneArg)this.arg).getRankRange().get(i)).roleid;
/* 155 */         if (GameServerInfoManager.isRoleInOwnServer(roleid))
/*     */         {
/*     */ 
/*     */ 
/* 159 */           if (!xCrossBattleBetRankAwardInfo.getRole_rank_award_infos().containsKey(Long.valueOf(roleid)))
/*     */           {
/*     */ 
/*     */ 
/* 163 */             RoleCrossBattleBetRankAwardInfo xRoleCrossBattleBetRankAwardInfo = Pod.newRoleCrossBattleBetRankAwardInfo();
/* 164 */             xRoleCrossBattleBetRankAwardInfo.setRank(i);
/* 165 */             xCrossBattleBetRankAwardInfo.getRole_rank_award_infos().put(Long.valueOf(roleid), xRoleCrossBattleBetRankAwardInfo);
/* 166 */             if (CrossBattleBetManager.isCrossBattleBetRankSwitchOpenForRole(roleid))
/*     */             {
/* 168 */               CrossBattleBetChartManager.getInstance().sendRankAward(roleid, activityCfgid, 50); }
/*     */           }
/*     */         }
/*     */       }
/* 172 */       CrossBattleBetManager.logger.info(String.format("[crossbattle]POnGetCrossBattleBetWinRankRangeDone.processImp@send cross battle bet win rank award|count=%d|rankid=%d", new Object[] { Byte.valueOf(context.count), Long.valueOf(((GetCrossBattleBetWinRankRangeDoneArg)this.arg).getRankid()) }));
/*     */       
/*     */ 
/* 175 */       return true;
/*     */     }
/*     */     
/* 178 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void sendResult(long roleid, int activityCfgid, int startPos, List<CrossBattleBetRankData> rankRange)
/*     */   {
/* 185 */     SGetCrossBattleBetRankSuccess protocol = new SGetCrossBattleBetRankSuccess();
/* 186 */     protocol.rank_type = 50;
/* 187 */     protocol.activity_cfg_id = activityCfgid;
/* 188 */     for (int i = 0; i < rankRange.size(); i++)
/*     */     {
/* 190 */       CrossBattleBetRankData rankData = (CrossBattleBetRankData)rankRange.get(i);
/* 191 */       rankData.rank = (startPos + i);
/*     */     }
/* 193 */     protocol.rank_list.addAll(rankRange);
/* 194 */     OnlineManager.getInstance().send(roleid, protocol);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\bet\POnGetCrossBattleBetWinRankRangeDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
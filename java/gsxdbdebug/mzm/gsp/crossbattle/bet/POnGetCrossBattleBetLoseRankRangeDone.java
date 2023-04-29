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
/*     */ import mzm.gsp.crossserver.event.GetCrossBattleBetLoseRankRangeDoneArg;
/*     */ import mzm.gsp.crossserver.event.GetCrossBattleBetLoseRankRangeDoneProcedure;
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
/*     */ public class POnGetCrossBattleBetLoseRankRangeDone extends GetCrossBattleBetLoseRankRangeDoneProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  29 */     GetCrossBattleBetRankContext context = new GetCrossBattleBetRankContext();
/*  30 */     context.unmarshal(OctetsStream.wrap(((GetCrossBattleBetLoseRankRangeDoneArg)this.arg).getContext()));
/*  31 */     switch (context.oper_type)
/*     */     {
/*     */ 
/*     */     case 0: 
/*  35 */       GetCrossBattleBetRank_ClientReq extraInfo = new GetCrossBattleBetRank_ClientReq();
/*  36 */       extraInfo.unmarshal(OctetsStream.wrap(context.extra_info));
/*  37 */       long roleid = extraInfo.roleid;
/*  38 */       if ((!((GetCrossBattleBetLoseRankRangeDoneArg)this.arg).isSucceed()) && (!((GetCrossBattleBetLoseRankRangeDoneArg)this.arg).isNoRankData()))
/*     */       {
/*  40 */         if (!((GetCrossBattleBetLoseRankRangeDoneArg)this.arg).isTimeout())
/*     */         {
/*  42 */           SGetCrossBattleBetRankFail protocol = new SGetCrossBattleBetRankFail();
/*  43 */           protocol.res = 10;
/*  44 */           OnlineManager.getInstance().sendAtOnce(roleid, protocol);
/*  45 */           CrossBattleBetManager.logger.info(String.format("[crossbattle]POnGetCrossBattleBetLoseRankRangeDone.processImp@get cross battle bet lose rank fail|count=%d|roleid=%d|rankid=%d", new Object[] { Byte.valueOf(context.count), Long.valueOf(roleid), Long.valueOf(((GetCrossBattleBetLoseRankRangeDoneArg)this.arg).getRankid()) }));
/*     */           
/*     */ 
/*  48 */           return false;
/*     */         }
/*  50 */         CrossBattleBetManager.logger.info(String.format("[crossbattle]POnGetCrossBattleBetLoseRankRangeDone.processImp@get cross battle bet lose rank timeout|count=%d|roleid=%d|rankid=%d", new Object[] { Byte.valueOf(context.count), Long.valueOf(roleid), Long.valueOf(((GetCrossBattleBetLoseRankRangeDoneArg)this.arg).getRankid()) }));
/*     */         
/*     */ 
/*  53 */         if (context.count < CrossBattleBetManager.GRC_MAX_TRY_TIMES)
/*     */         {
/*  55 */           GetCrossBattleBetRankContext tmp255_254 = context;tmp255_254.count = ((byte)(tmp255_254.count + 1));
/*  56 */           if (!CrossServerInterface.getCrossBattleBetLoseRankRange(((GetCrossBattleBetLoseRankRangeDoneArg)this.arg).getRankid(), ((GetCrossBattleBetLoseRankRangeDoneArg)this.arg).getFrom(), ((GetCrossBattleBetLoseRankRangeDoneArg)this.arg).getTo(), context.marshal(new OctetsStream())))
/*     */           {
/*     */ 
/*     */ 
/*  60 */             SGetCrossBattleBetRankFail protocol = new SGetCrossBattleBetRankFail();
/*  61 */             protocol.res = 10;
/*  62 */             OnlineManager.getInstance().sendAtOnce(roleid, protocol);
/*  63 */             CrossBattleBetManager.logger.info(String.format("[crossbattle]POnGetCrossBattleBetLoseRankRangeDone.processImp@communication error|count=%d|roleid=%d|rankid=%d", new Object[] { Byte.valueOf(context.count), Long.valueOf(roleid), Long.valueOf(((GetCrossBattleBetLoseRankRangeDoneArg)this.arg).getRankid()) }));
/*     */             
/*     */ 
/*  66 */             return false;
/*     */           }
/*  68 */           CrossBattleBetManager.logger.info(String.format("[crossbattle]POnGetCrossBattleBetLoseRankRangeDone.processImp@get cross battle bet lose rank from grc|count=%d|roleid=%d|rankid=%d", new Object[] { Byte.valueOf(context.count), Long.valueOf(roleid), Long.valueOf(((GetCrossBattleBetLoseRankRangeDoneArg)this.arg).getRankid()) }));
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/*     */ 
/*  74 */           SGetCrossBattleBetRankFail protocol = new SGetCrossBattleBetRankFail();
/*  75 */           protocol.res = 10;
/*  76 */           OnlineManager.getInstance().sendAtOnce(roleid, protocol);
/*     */         }
/*  78 */         return false;
/*     */       }
/*  80 */       sendResult(roleid, (int)((GetCrossBattleBetLoseRankRangeDoneArg)this.arg).getRankid(), ((GetCrossBattleBetLoseRankRangeDoneArg)this.arg).getFrom() + 1, ((GetCrossBattleBetLoseRankRangeDoneArg)this.arg).getRankRange());
/*  81 */       CrossBattleBetManager.logger.info(String.format("[crossbattle]POnGetCrossBattleBetLoseRankRangeDone.processImp@get cross battle bet lose rank success|count=%d|roleid=%d|rankid=%d", new Object[] { Byte.valueOf(context.count), Long.valueOf(roleid), Long.valueOf(((GetCrossBattleBetLoseRankRangeDoneArg)this.arg).getRankid()) }));
/*     */       
/*     */ 
/*  84 */       return true;
/*     */     
/*     */ 
/*     */     case 1: 
/*  88 */       if ((!((GetCrossBattleBetLoseRankRangeDoneArg)this.arg).isSucceed()) && (!((GetCrossBattleBetLoseRankRangeDoneArg)this.arg).isNoRankData()))
/*     */       {
/*  90 */         if (!((GetCrossBattleBetLoseRankRangeDoneArg)this.arg).isTimeout())
/*     */         {
/*  92 */           CrossBattleBetManager.logger.info(String.format("[crossbattle]POnGetCrossBattleBetLoseRankRangeDone.processImp@get cross battle bet lose rank fail|count=%d|rankid=%d", new Object[] { Byte.valueOf(context.count), Long.valueOf(((GetCrossBattleBetLoseRankRangeDoneArg)this.arg).getRankid()) }));
/*     */           
/*     */ 
/*  95 */           return false;
/*     */         }
/*  97 */         CrossBattleBetManager.logger.info(String.format("[crossbattle]POnGetCrossBattleBetLoseRankRangeDone.processImp@get cross battle bet lose rank timeout|count=%d|rankid=%d", new Object[] { Byte.valueOf(context.count), Long.valueOf(((GetCrossBattleBetLoseRankRangeDoneArg)this.arg).getRankid()) }));
/*     */         
/*     */ 
/* 100 */         if (context.count < CrossBattleBetManager.GRC_MAX_TRY_TIMES)
/*     */         {
/* 102 */           GetCrossBattleBetRankContext tmp689_688 = context;tmp689_688.count = ((byte)(tmp689_688.count + 1));
/* 103 */           if (!CrossServerInterface.getCrossBattleBetLoseRankRange(((GetCrossBattleBetLoseRankRangeDoneArg)this.arg).getRankid(), ((GetCrossBattleBetLoseRankRangeDoneArg)this.arg).getFrom(), ((GetCrossBattleBetLoseRankRangeDoneArg)this.arg).getTo(), context.marshal(new OctetsStream())))
/*     */           {
/*     */ 
/*     */ 
/* 107 */             CrossBattleBetManager.logger.info(String.format("[crossbattle]POnGetCrossBattleBetLoseRankRangeDone.processImp@communication error|count=%d|rankid=%d", new Object[] { Byte.valueOf(context.count), Long.valueOf(((GetCrossBattleBetLoseRankRangeDoneArg)this.arg).getRankid()) }));
/*     */             
/*     */ 
/* 110 */             return false;
/*     */           }
/* 112 */           CrossBattleBetManager.logger.info(String.format("[crossbattle]POnGetCrossBattleBetLoseRankRangeDone.processImp@get cross battle bet lose from grc|count=%d|rankid=%d", new Object[] { Byte.valueOf(context.count), Long.valueOf(((GetCrossBattleBetLoseRankRangeDoneArg)this.arg).getRankid()) }));
/*     */         }
/*     */         
/*     */ 
/* 116 */         return false;
/*     */       }
/* 118 */       int rank = mzm.gsp.chart.main.RankInterface.getAwardRank(51);
/* 119 */       if (rank < 0)
/*     */       {
/*     */ 
/* 122 */         return false;
/*     */       }
/* 124 */       int activityCfgid = (int)((GetCrossBattleBetLoseRankRangeDoneArg)this.arg).getRankid();
/*     */       
/* 126 */       CrossBattleBetRankBackup xCrossBattleBetRankBackup = Cross_battle_bet_rank_backups.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 127 */       if (xCrossBattleBetRankBackup == null)
/*     */       {
/*     */ 
/* 130 */         return false;
/*     */       }
/* 132 */       CrossBattleBetSeasonRankBackup xCrossBattleBetSeasonRankBackup = (CrossBattleBetSeasonRankBackup)xCrossBattleBetRankBackup.getBackups().get(Integer.valueOf(activityCfgid));
/*     */       
/* 134 */       if (xCrossBattleBetSeasonRankBackup == null)
/*     */       {
/*     */ 
/* 137 */         return false;
/*     */       }
/* 139 */       CrossBattleBetRankAwardInfo xCrossBattleBetRankAwardInfo = (CrossBattleBetRankAwardInfo)xCrossBattleBetSeasonRankBackup.getRank_award_infos().get(Integer.valueOf(51));
/*     */       
/* 141 */       if ((xCrossBattleBetRankAwardInfo != null) && (xCrossBattleBetRankAwardInfo.getIs_data_complete()))
/*     */       {
/*     */ 
/* 144 */         return false;
/*     */       }
/* 146 */       if (xCrossBattleBetRankAwardInfo == null)
/*     */       {
/* 148 */         xCrossBattleBetRankAwardInfo = Pod.newCrossBattleBetRankAwardInfo();
/* 149 */         xCrossBattleBetSeasonRankBackup.getRank_award_infos().put(Integer.valueOf(51), xCrossBattleBetRankAwardInfo);
/*     */       }
/*     */       
/* 152 */       xCrossBattleBetRankAwardInfo.setIs_data_complete(true);
/* 153 */       for (int i = 0; (i < ((GetCrossBattleBetLoseRankRangeDoneArg)this.arg).getRankRange().size()) && (i <= rank); i++)
/*     */       {
/* 155 */         long roleid = ((CrossBattleBetRankData)((GetCrossBattleBetLoseRankRangeDoneArg)this.arg).getRankRange().get(i)).roleid;
/* 156 */         if (GameServerInfoManager.isRoleInOwnServer(roleid))
/*     */         {
/*     */ 
/*     */ 
/* 160 */           if (!xCrossBattleBetRankAwardInfo.getRole_rank_award_infos().containsKey(Long.valueOf(roleid)))
/*     */           {
/*     */ 
/*     */ 
/* 164 */             RoleCrossBattleBetRankAwardInfo xRoleCrossBattleBetRankAwardInfo = Pod.newRoleCrossBattleBetRankAwardInfo();
/* 165 */             xRoleCrossBattleBetRankAwardInfo.setRank(i);
/* 166 */             xCrossBattleBetRankAwardInfo.getRole_rank_award_infos().put(Long.valueOf(roleid), xRoleCrossBattleBetRankAwardInfo);
/* 167 */             if (CrossBattleBetManager.isCrossBattleBetRankSwitchOpenForRole(roleid))
/*     */             {
/* 169 */               CrossBattleBetChartManager.getInstance().sendRankAward(roleid, activityCfgid, 51); }
/*     */           }
/*     */         }
/*     */       }
/* 173 */       CrossBattleBetManager.logger.info(String.format("[crossbattle]POnGetCrossBattleBetLoseRankRangeDone.processImp@send cross battle bet lose rank award|count=%d|rankid=%d", new Object[] { Byte.valueOf(context.count), Long.valueOf(((GetCrossBattleBetLoseRankRangeDoneArg)this.arg).getRankid()) }));
/*     */       
/*     */ 
/* 176 */       return true;
/*     */     }
/*     */     
/* 179 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void sendResult(long roleid, int activityCfgid, int startPos, List<CrossBattleBetRankData> rankRange)
/*     */   {
/* 186 */     SGetCrossBattleBetRankSuccess protocol = new SGetCrossBattleBetRankSuccess();
/* 187 */     protocol.rank_type = 51;
/* 188 */     protocol.activity_cfg_id = activityCfgid;
/* 189 */     for (int i = 0; i < rankRange.size(); i++)
/*     */     {
/* 191 */       CrossBattleBetRankData rankData = (CrossBattleBetRankData)rankRange.get(i);
/* 192 */       rankData.rank = (startPos + i);
/*     */     }
/* 194 */     protocol.rank_list.addAll(rankRange);
/* 195 */     OnlineManager.getInstance().send(roleid, protocol);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\bet\POnGetCrossBattleBetLoseRankRangeDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
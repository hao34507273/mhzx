/*     */ package mzm.gsp.crossfield.main;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.crossfield.CrossFieldRankData;
/*     */ import mzm.gsp.crossfield.GetCrossFieldRankContext;
/*     */ import mzm.gsp.crossfield.GetCrossFieldRank_ClientReq;
/*     */ import mzm.gsp.crossfield.SGetCrossFieldRankFail;
/*     */ import mzm.gsp.crossfield.SGetCrossFieldRankSuccess;
/*     */ import mzm.gsp.crossserver.event.GetSingleCrossFieldRankRangeDoneArg;
/*     */ import mzm.gsp.crossserver.main.CrossServerInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.util.TaskOneByOne;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Pod;
/*     */ import xbean.RoleSingleCrossFieldRankAwardInfo;
/*     */ import xbean.SingleCrossFieldRankAwardInfo;
/*     */ import xbean.SingleCrossFieldRankBackup;
/*     */ import xbean.SingleCrossFieldSeasonRankBackup;
/*     */ 
/*     */ public class POnGetSingleCrossFieldRankRangeDone extends mzm.gsp.crossserver.event.GetSingleCrossFieldRankRangeDoneProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  28 */     GetCrossFieldRankContext context = new GetCrossFieldRankContext();
/*  29 */     context.unmarshal(OctetsStream.wrap(((GetSingleCrossFieldRankRangeDoneArg)this.arg).getContext()));
/*  30 */     switch (context.oper_type)
/*     */     {
/*     */ 
/*     */     case 0: 
/*  34 */       GetCrossFieldRank_ClientReq extraInfo = new GetCrossFieldRank_ClientReq();
/*  35 */       extraInfo.unmarshal(OctetsStream.wrap(context.extra_info));
/*  36 */       long roleid = extraInfo.roleid;
/*  37 */       if ((!((GetSingleCrossFieldRankRangeDoneArg)this.arg).isSucceed()) && (!((GetSingleCrossFieldRankRangeDoneArg)this.arg).isNoRankData()))
/*     */       {
/*  39 */         if (!((GetSingleCrossFieldRankRangeDoneArg)this.arg).isTimeout())
/*     */         {
/*  41 */           SGetCrossFieldRankFail protocol = new SGetCrossFieldRankFail();
/*  42 */           protocol.res = 9;
/*  43 */           OnlineManager.getInstance().sendAtOnce(roleid, protocol);
/*  44 */           CrossFieldManager.logger.info(String.format("[crossfield]POnGetSingleCrossFieldRankRangeDone.processImp@get single cross field rank fail|count=%d|roleid=%d|rankid=%d", new Object[] { Byte.valueOf(context.count), Long.valueOf(roleid), Long.valueOf(((GetSingleCrossFieldRankRangeDoneArg)this.arg).getRankid()) }));
/*     */           
/*     */ 
/*  47 */           return false;
/*     */         }
/*  49 */         CrossFieldManager.logger.info(String.format("[crossfield]POnGetSingleCrossFieldRankRangeDone.processImp@get single cross field rank timeout|count=%d|roleid=%d|rankid=%d", new Object[] { Byte.valueOf(context.count), Long.valueOf(roleid), Long.valueOf(((GetSingleCrossFieldRankRangeDoneArg)this.arg).getRankid()) }));
/*     */         
/*     */ 
/*  52 */         if (context.count < CrossFieldManager.GRC_MAX_TRY_TIMES)
/*     */         {
/*  54 */           GetCrossFieldRankContext tmp255_254 = context;tmp255_254.count = ((byte)(tmp255_254.count + 1));
/*  55 */           if (!CrossServerInterface.getSingleCrossFieldRankRange(((GetSingleCrossFieldRankRangeDoneArg)this.arg).getRankid(), ((GetSingleCrossFieldRankRangeDoneArg)this.arg).getFrom(), ((GetSingleCrossFieldRankRangeDoneArg)this.arg).getTo(), context.marshal(new OctetsStream())))
/*     */           {
/*     */ 
/*     */ 
/*  59 */             SGetCrossFieldRankFail protocol = new SGetCrossFieldRankFail();
/*  60 */             protocol.res = 9;
/*  61 */             OnlineManager.getInstance().sendAtOnce(roleid, protocol);
/*  62 */             CrossFieldManager.logger.info(String.format("[crossfield]POnGetSingleCrossFieldRankRangeDone.processImp@communication error|count=%d|roleid=%d|rankid=%d", new Object[] { Byte.valueOf(context.count), Long.valueOf(roleid), Long.valueOf(((GetSingleCrossFieldRankRangeDoneArg)this.arg).getRankid()) }));
/*     */             
/*     */ 
/*  65 */             return false;
/*     */           }
/*  67 */           CrossFieldManager.logger.info(String.format("[crossfield]POnGetSingleCrossFieldRankRangeDone.processImp@get single cross field rank from grc|count=%d|roleid=%d|rankid=%d", new Object[] { Byte.valueOf(context.count), Long.valueOf(roleid), Long.valueOf(((GetSingleCrossFieldRankRangeDoneArg)this.arg).getRankid()) }));
/*     */         }
/*     */         
/*     */ 
/*  71 */         return false;
/*     */       }
/*  73 */       sendResult(roleid, ((GetSingleCrossFieldRankRangeDoneArg)this.arg).getFrom() + 1, ((GetSingleCrossFieldRankRangeDoneArg)this.arg).getRankRange());
/*  74 */       CrossFieldManager.logger.info(String.format("[crossfield]POnGetSingleCrossFieldRankRangeDone.processImp@get single cross field rank success|count=%d|roleid=%d|rankid=%d", new Object[] { Byte.valueOf(context.count), Long.valueOf(roleid), Long.valueOf(((GetSingleCrossFieldRankRangeDoneArg)this.arg).getRankid()) }));
/*     */       
/*     */ 
/*  77 */       return true;
/*     */     
/*     */ 
/*     */     case 1: 
/*  81 */       if ((!((GetSingleCrossFieldRankRangeDoneArg)this.arg).isSucceed()) && (!((GetSingleCrossFieldRankRangeDoneArg)this.arg).isNoRankData()))
/*     */       {
/*  83 */         if (!((GetSingleCrossFieldRankRangeDoneArg)this.arg).isTimeout())
/*     */         {
/*  85 */           CrossFieldManager.logger.info(String.format("[crossfield]POnGetSingleCrossFieldRankRangeDone.processImp@get single cross field rank fail|count=%d|rankid=%d", new Object[] { Byte.valueOf(context.count), Long.valueOf(((GetSingleCrossFieldRankRangeDoneArg)this.arg).getRankid()) }));
/*     */           
/*     */ 
/*  88 */           return false;
/*     */         }
/*  90 */         CrossFieldManager.logger.info(String.format("[crossfield]POnGetSingleCrossFieldRankRangeDone.processImp@get single cross field rank timeout|count=%d|rankid=%d", new Object[] { Byte.valueOf(context.count), Long.valueOf(((GetSingleCrossFieldRankRangeDoneArg)this.arg).getRankid()) }));
/*     */         
/*     */ 
/*  93 */         if (context.count < CrossFieldManager.GRC_MAX_TRY_TIMES)
/*     */         {
/*  95 */           GetCrossFieldRankContext tmp649_648 = context;tmp649_648.count = ((byte)(tmp649_648.count + 1));
/*  96 */           if (!CrossServerInterface.getSingleCrossFieldRankRange(((GetSingleCrossFieldRankRangeDoneArg)this.arg).getRankid(), ((GetSingleCrossFieldRankRangeDoneArg)this.arg).getFrom(), ((GetSingleCrossFieldRankRangeDoneArg)this.arg).getTo(), context.marshal(new OctetsStream())))
/*     */           {
/*     */ 
/*     */ 
/* 100 */             CrossFieldManager.logger.info(String.format("[crossfield]POnGetSingleCrossFieldRankRangeDone.processImp@communication error|count=%d|rankid=%d", new Object[] { Byte.valueOf(context.count), Long.valueOf(((GetSingleCrossFieldRankRangeDoneArg)this.arg).getRankid()) }));
/*     */             
/*     */ 
/* 103 */             return false;
/*     */           }
/* 105 */           CrossFieldManager.logger.info(String.format("[crossfield]POnGetSingleCrossFieldRankRangeDone.processImp@get single cross field rank from grc|count=%d|rankid=%d", new Object[] { Byte.valueOf(context.count), Long.valueOf(((GetSingleCrossFieldRankRangeDoneArg)this.arg).getRankid()) }));
/*     */         }
/*     */         
/*     */ 
/* 109 */         return false;
/*     */       }
/* 111 */       int rank = mzm.gsp.chart.main.RankInterface.getAwardRank(40);
/* 112 */       if (rank < 0)
/*     */       {
/*     */ 
/* 115 */         return false;
/*     */       }
/* 117 */       int season = (int)((GetSingleCrossFieldRankRangeDoneArg)this.arg).getRankid();
/* 118 */       SingleCrossFieldRankBackup xSingleCrossFieldRankBackup = xtable.Single_cross_field_rank_backups.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 119 */       if (xSingleCrossFieldRankBackup == null)
/*     */       {
/*     */ 
/* 122 */         return false;
/*     */       }
/* 124 */       SingleCrossFieldSeasonRankBackup xSingleCrossFieldSeasonRankBackup = (SingleCrossFieldSeasonRankBackup)xSingleCrossFieldRankBackup.getBackups().get(Integer.valueOf(season));
/*     */       
/* 126 */       if (xSingleCrossFieldSeasonRankBackup == null)
/*     */       {
/*     */ 
/* 129 */         return false;
/*     */       }
/* 131 */       SingleCrossFieldRankAwardInfo xRemoteSingleCrossFieldRankAwardInfo = (SingleCrossFieldRankAwardInfo)xSingleCrossFieldSeasonRankBackup.getRank_award_infos().get(Integer.valueOf(40));
/*     */       
/* 133 */       if ((xRemoteSingleCrossFieldRankAwardInfo != null) && (xRemoteSingleCrossFieldRankAwardInfo.getIs_data_complete()))
/*     */       {
/*     */ 
/*     */ 
/* 137 */         return false;
/*     */       }
/* 139 */       if (xRemoteSingleCrossFieldRankAwardInfo == null)
/*     */       {
/* 141 */         xRemoteSingleCrossFieldRankAwardInfo = Pod.newSingleCrossFieldRankAwardInfo();
/* 142 */         xSingleCrossFieldSeasonRankBackup.getRank_award_infos().put(Integer.valueOf(40), xRemoteSingleCrossFieldRankAwardInfo);
/*     */       }
/*     */       
/*     */ 
/* 146 */       xRemoteSingleCrossFieldRankAwardInfo.setIs_data_complete(true);
/* 147 */       for (int i = 0; (i < ((GetSingleCrossFieldRankRangeDoneArg)this.arg).getRankRange().size()) && (i <= rank); i++)
/*     */       {
/* 149 */         long roleid = ((CrossFieldRankData)((GetSingleCrossFieldRankRangeDoneArg)this.arg).getRankRange().get(i)).roleid;
/* 150 */         if (GameServerInfoManager.isRoleInOwnServer(roleid))
/*     */         {
/*     */ 
/*     */ 
/* 154 */           if (!xRemoteSingleCrossFieldRankAwardInfo.getRole_rank_award_infos().containsKey(Long.valueOf(roleid)))
/*     */           {
/*     */ 
/*     */ 
/* 158 */             RoleSingleCrossFieldRankAwardInfo xRoleSingleCrossFieldRankAwardInfo = Pod.newRoleSingleCrossFieldRankAwardInfo();
/* 159 */             xRoleSingleCrossFieldRankAwardInfo.setRank(i);
/* 160 */             xRemoteSingleCrossFieldRankAwardInfo.getRole_rank_award_infos().put(Long.valueOf(roleid), xRoleSingleCrossFieldRankAwardInfo);
/*     */             
/* 162 */             if (CrossFieldManager.isCrossFieldSwitchOpenForRole(roleid))
/*     */             {
/* 164 */               SingleCrossFieldChartManager.getInstance().getRankOneByOne().add(new PSendRankAward(roleid, season, 40));
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/* 169 */       CrossFieldManager.logger.info(String.format("[crossfield]POnGetSingleCrossFieldRankRangeDone.processImp@send single cross field rank award|count=%d|rankid=%d", new Object[] { Byte.valueOf(context.count), Long.valueOf(((GetSingleCrossFieldRankRangeDoneArg)this.arg).getRankid()) }));
/*     */       
/*     */ 
/* 172 */       return true;
/*     */     }
/*     */     
/* 175 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   private void sendResult(long roleid, int startPos, List<CrossFieldRankData> rankRange)
/*     */   {
/* 181 */     SGetCrossFieldRankSuccess protocol = new SGetCrossFieldRankSuccess();
/* 182 */     protocol.rank_type = 40;
/* 183 */     for (int i = 0; i < rankRange.size(); i++)
/*     */     {
/* 185 */       CrossFieldRankData rankData = (CrossFieldRankData)rankRange.get(i);
/* 186 */       rankData.rank = (startPos + i);
/*     */     }
/* 188 */     protocol.rank_list.addAll(rankRange);
/* 189 */     OnlineManager.getInstance().send(roleid, protocol);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossfield\main\POnGetSingleCrossFieldRankRangeDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
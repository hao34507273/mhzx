/*     */ package mzm.gsp.crossbattle.bet;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.crossbattle.GetRoleCrossBattleBetRankContext;
/*     */ import mzm.gsp.crossbattle.SGetRoleCrossBattleBetRankFail;
/*     */ import mzm.gsp.crossbattle.SGetRoleCrossBattleBetRankSuccess;
/*     */ import mzm.gsp.crossserver.event.GetRoleCrossBattleBetLoseRankInfoDoneArg;
/*     */ import mzm.gsp.crossserver.event.GetRoleCrossBattleBetLoseRankInfoDoneProcedure;
/*     */ import mzm.gsp.crossserver.main.CrossServerInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.RoleCrossBattleBetProfitInfo;
/*     */ import xbean.RoleCrossBattleBetSeasonProfitInfo;
/*     */ import xtable.Role_cross_battle_bet_season_profot_infos;
/*     */ 
/*     */ public class POnGetRoleCrossBattleBetLoseRankInfoDone
/*     */   extends GetRoleCrossBattleBetLoseRankInfoDoneProcedure
/*     */ {
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  23 */     GetRoleCrossBattleBetRankContext context = new GetRoleCrossBattleBetRankContext();
/*  24 */     context.unmarshal(OctetsStream.wrap(((GetRoleCrossBattleBetLoseRankInfoDoneArg)this.arg).getContext()));
/*  25 */     switch (context.oper_type)
/*     */     {
/*     */ 
/*     */     case 0: 
/*  29 */       if ((!((GetRoleCrossBattleBetLoseRankInfoDoneArg)this.arg).isSucceed()) && (!((GetRoleCrossBattleBetLoseRankInfoDoneArg)this.arg).isNotInRank()))
/*     */       {
/*  31 */         if (!((GetRoleCrossBattleBetLoseRankInfoDoneArg)this.arg).isTimeout())
/*     */         {
/*  33 */           SGetRoleCrossBattleBetRankFail protocol = new SGetRoleCrossBattleBetRankFail();
/*  34 */           protocol.res = 10;
/*  35 */           OnlineManager.getInstance().sendAtOnce(((GetRoleCrossBattleBetLoseRankInfoDoneArg)this.arg).getRoleid(), protocol);
/*  36 */           CrossBattleBetManager.logger.error(String.format("[crossbattle]POnGetRoleCrossBattleBetLoseRankInfoDone.processImp@get role cross battle bet lose rank fail|count=%d|roleid=%d|rankid=%d", new Object[] { Byte.valueOf(context.count), Long.valueOf(((GetRoleCrossBattleBetLoseRankInfoDoneArg)this.arg).getRoleid()), Long.valueOf(((GetRoleCrossBattleBetLoseRankInfoDoneArg)this.arg).getRankid()) }));
/*     */           
/*     */ 
/*  39 */           return false;
/*     */         }
/*  41 */         CrossBattleBetManager.logger.error(String.format("[crossbattle]POnGetRoleCrossBattleBetLoseRankInfoDone.processImp@get role cross battle bet lose rank timeout|count=%d|roleid=%d|rankid=%d", new Object[] { Byte.valueOf(context.count), Long.valueOf(((GetRoleCrossBattleBetLoseRankInfoDoneArg)this.arg).getRoleid()), Long.valueOf(((GetRoleCrossBattleBetLoseRankInfoDoneArg)this.arg).getRankid()) }));
/*     */         
/*     */ 
/*  44 */         if (context.count < CrossBattleBetManager.GRC_MAX_TRY_TIMES)
/*     */         {
/*  46 */           GetRoleCrossBattleBetRankContext tmp246_245 = context;tmp246_245.count = ((byte)(tmp246_245.count + 1));
/*  47 */           if (!CrossServerInterface.getRoleCrossBattleBetLoseRankInfo(((GetRoleCrossBattleBetLoseRankInfoDoneArg)this.arg).getRankid(), ((GetRoleCrossBattleBetLoseRankInfoDoneArg)this.arg).getRoleid(), context.marshal(new OctetsStream())))
/*     */           {
/*     */ 
/*     */ 
/*  51 */             SGetRoleCrossBattleBetRankFail protocol = new SGetRoleCrossBattleBetRankFail();
/*  52 */             protocol.res = 10;
/*  53 */             OnlineManager.getInstance().sendAtOnce(((GetRoleCrossBattleBetLoseRankInfoDoneArg)this.arg).getRoleid(), protocol);
/*  54 */             CrossBattleBetManager.logger.error(String.format("[crossbattle]POnGetRoleCrossBattleBetLoseRankInfoDone.processImp@communication error|count=%d|roleid=%d|rankid=%d", new Object[] { Byte.valueOf(context.count), Long.valueOf(((GetRoleCrossBattleBetLoseRankInfoDoneArg)this.arg).getRoleid()), Long.valueOf(((GetRoleCrossBattleBetLoseRankInfoDoneArg)this.arg).getRankid()) }));
/*     */             
/*     */ 
/*  57 */             return false;
/*     */           }
/*  59 */           CrossBattleBetManager.logger.info(String.format("[crossbattle]POnGetRoleCrossBattleBetLoseRankInfoDone.processImp@get role cross battle bet lose rank from grc|count=%d|roleid=%d|rankid=%d", new Object[] { Byte.valueOf(context.count), Long.valueOf(((GetRoleCrossBattleBetLoseRankInfoDoneArg)this.arg).getRoleid()), Long.valueOf(((GetRoleCrossBattleBetLoseRankInfoDoneArg)this.arg).getRankid()) }));
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/*     */ 
/*  65 */           SGetRoleCrossBattleBetRankFail protocol = new SGetRoleCrossBattleBetRankFail();
/*  66 */           protocol.res = 10;
/*  67 */           OnlineManager.getInstance().sendAtOnce(((GetRoleCrossBattleBetLoseRankInfoDoneArg)this.arg).getRoleid(), protocol);
/*     */         }
/*  69 */         return false;
/*     */       }
/*  71 */       SGetRoleCrossBattleBetRankSuccess protocol = new SGetRoleCrossBattleBetRankSuccess();
/*  72 */       protocol.rank_type = 51;
/*  73 */       protocol.activity_cfg_id = ((int)((GetRoleCrossBattleBetLoseRankInfoDoneArg)this.arg).getRankid());
/*  74 */       if (((GetRoleCrossBattleBetLoseRankInfoDoneArg)this.arg).isSucceed())
/*     */       {
/*  76 */         protocol.rank = (((GetRoleCrossBattleBetLoseRankInfoDoneArg)this.arg).getRank() + 1);
/*     */       }
/*     */       else
/*     */       {
/*  80 */         protocol.rank = 0;
/*     */       }
/*  82 */       protocol.profit = 0L;
/*  83 */       protocol.timestamp = 0;
/*  84 */       RoleCrossBattleBetSeasonProfitInfo xRoleCrossBattleBetSeasonProfitInfo = Role_cross_battle_bet_season_profot_infos.get(Long.valueOf(((GetRoleCrossBattleBetLoseRankInfoDoneArg)this.arg).getRoleid()));
/*  85 */       if (xRoleCrossBattleBetSeasonProfitInfo != null)
/*     */       {
/*  87 */         RoleCrossBattleBetProfitInfo xRoleCrossBattleBetProfitInfo = (RoleCrossBattleBetProfitInfo)xRoleCrossBattleBetSeasonProfitInfo.getProfit_infos().get(Integer.valueOf(protocol.activity_cfg_id));
/*     */         
/*  89 */         if (xRoleCrossBattleBetProfitInfo != null)
/*     */         {
/*  91 */           protocol.profit = xRoleCrossBattleBetProfitInfo.getProfit();
/*  92 */           protocol.timestamp = ((int)(xRoleCrossBattleBetProfitInfo.getTimestamp() / 1000L));
/*     */         }
/*     */       }
/*  95 */       OnlineManager.getInstance().send(((GetRoleCrossBattleBetLoseRankInfoDoneArg)this.arg).getRoleid(), protocol);
/*  96 */       CrossBattleBetManager.logger.info(String.format("[crossbattle]POnGetRoleCrossBattleBetLoseRankInfoDone.processImp@get role cross battle bet lose rank success|count=%d|roleid=%d|rankid=%d|rank=%d", new Object[] { Byte.valueOf(context.count), Long.valueOf(((GetRoleCrossBattleBetLoseRankInfoDoneArg)this.arg).getRoleid()), Long.valueOf(((GetRoleCrossBattleBetLoseRankInfoDoneArg)this.arg).getRankid()), Integer.valueOf(protocol.rank) }));
/*     */       
/*     */ 
/*  99 */       return true;
/*     */     }
/*     */     
/* 102 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\bet\POnGetRoleCrossBattleBetLoseRankInfoDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
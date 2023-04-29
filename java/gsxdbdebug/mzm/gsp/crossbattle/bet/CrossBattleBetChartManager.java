/*     */ package mzm.gsp.crossbattle.bet;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Random;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.chart.main.RankInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.TaskOneByOne;
/*     */ import xbean.CrossBattleBetRankAwardInfo;
/*     */ import xbean.CrossBattleBetRankBackup;
/*     */ import xbean.CrossBattleBetSeasonRankBackup;
/*     */ import xbean.Pod;
/*     */ import xbean.RoleCrossBattleBetRankAwardInfo;
/*     */ import xdb.Xdb;
/*     */ import xtable.Cross_battle_bet_rank_backups;
/*     */ 
/*     */ public class CrossBattleBetChartManager
/*     */ {
/*  22 */   private static CrossBattleBetChartManager instance = new CrossBattleBetChartManager();
/*     */   private final TaskOneByOne rankOneByOne;
/*     */   
/*     */   static CrossBattleBetChartManager getInstance() {
/*  26 */     return instance;
/*     */   }
/*     */   
/*  29 */   public CrossBattleBetChartManager() { this.rankOneByOne = new TaskOneByOne(); }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   void postInit()
/*     */   {
/*  36 */     if (GameServerInfoManager.isRoamServer())
/*     */     {
/*  38 */       return;
/*     */     }
/*  40 */     new PCheckAndGetRemoteRank().call();
/*  41 */     new PCheckAndSendAward().call();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void checkAndGetRemoteRank()
/*     */   {
/*  50 */     this.rankOneByOne.add(new PCheckAndGetRemoteRank());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void checkAndSendAward()
/*     */   {
/*  59 */     this.rankOneByOne.add(new PCheckAndSendAward());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void onActivityEnd(int activityCfgid)
/*     */   {
/*  70 */     this.rankOneByOne.add(new POnActivityEnd(activityCfgid));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void sendRankAward(long roleid, int activityCfgid, int chartType)
/*     */   {
/*  83 */     this.rankOneByOne.add(new PSendRankAward(roleid, activityCfgid, chartType));
/*     */   }
/*     */   
/*     */   class POnActivityEnd extends LogicProcedure
/*     */   {
/*     */     private final int activityCfgid;
/*     */     
/*     */     public POnActivityEnd(int activityCfgid)
/*     */     {
/*  92 */       this.activityCfgid = activityCfgid;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  98 */       if (mzm.gsp.crossbattle.confbean.SCrossBattleStageDurationCfg.get(this.activityCfgid) == null)
/*     */       {
/*     */ 
/* 101 */         return false;
/*     */       }
/* 103 */       long localid = GameServerInfoManager.getLocalId();
/*     */       
/* 105 */       lock(Cross_battle_bet_rank_backups.getTable(), Arrays.asList(new Long[] { Long.valueOf(localid) }));
/*     */       
/* 107 */       CrossBattleBetRankBackup xCrossBattleBetRankBackup = Cross_battle_bet_rank_backups.get(Long.valueOf(localid));
/* 108 */       if (xCrossBattleBetRankBackup == null)
/*     */       {
/* 110 */         xCrossBattleBetRankBackup = Pod.newCrossBattleBetRankBackup();
/* 111 */         Cross_battle_bet_rank_backups.insert(Long.valueOf(localid), xCrossBattleBetRankBackup);
/*     */       }
/* 113 */       if (xCrossBattleBetRankBackup.getBackups().containsKey(Integer.valueOf(this.activityCfgid)))
/*     */       {
/*     */ 
/* 116 */         return false;
/*     */       }
/*     */       
/* 119 */       CrossBattleBetSeasonRankBackup xCrossBattleBetSeasonRankBackup = Pod.newCrossBattleBetSeasonRankBackup();
/* 120 */       xCrossBattleBetRankBackup.getBackups().put(Integer.valueOf(this.activityCfgid), xCrossBattleBetSeasonRankBackup);
/*     */       
/* 122 */       if (RankInterface.getAwardRank(50) >= 0)
/*     */       {
/* 124 */         new GetRemoteRankRangeSession(CrossBattleBetManager.GET_REMOTE_RANK_MIN_DELAY_IN_SECOND + Xdb.random().nextInt(CrossBattleBetManager.GET_REMOTE_RANK_MAX_DELAY_IN_SECOND - CrossBattleBetManager.GET_REMOTE_RANK_MIN_DELAY_IN_SECOND), this.activityCfgid, 50);
/*     */ 
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/*     */ 
/*     */ 
/* 132 */         CrossBattleBetRankAwardInfo xWinCrossBattleBetRankAwardInfo = Pod.newCrossBattleBetRankAwardInfo();
/* 133 */         xWinCrossBattleBetRankAwardInfo.setIs_data_complete(true);
/* 134 */         xCrossBattleBetSeasonRankBackup.getRank_award_infos().put(Integer.valueOf(50), xWinCrossBattleBetRankAwardInfo);
/*     */       }
/*     */       
/*     */ 
/* 138 */       if (RankInterface.getAwardRank(51) >= 0)
/*     */       {
/* 140 */         new GetRemoteRankRangeSession(CrossBattleBetManager.GET_REMOTE_RANK_MIN_DELAY_IN_SECOND + Xdb.random().nextInt(CrossBattleBetManager.GET_REMOTE_RANK_MAX_DELAY_IN_SECOND - CrossBattleBetManager.GET_REMOTE_RANK_MIN_DELAY_IN_SECOND), this.activityCfgid, 51);
/*     */ 
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/*     */ 
/*     */ 
/* 148 */         CrossBattleBetRankAwardInfo xLoseCrossBattleBetRankAwardInfo = Pod.newCrossBattleBetRankAwardInfo();
/* 149 */         xLoseCrossBattleBetRankAwardInfo.setIs_data_complete(true);
/* 150 */         xCrossBattleBetSeasonRankBackup.getRank_award_infos().put(Integer.valueOf(51), xLoseCrossBattleBetRankAwardInfo);
/*     */       }
/*     */       
/*     */ 
/* 154 */       CrossBattleBetManager.logger.info(String.format("[crossbattle]CrossBattleBetChartManager.POnActivityEnd.processImp@activity end|activity_cfg_id=%d", new Object[] { Integer.valueOf(this.activityCfgid) }));
/*     */       
/*     */ 
/* 157 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   class PCheckAndSendAward extends LogicProcedure
/*     */   {
/*     */     PCheckAndSendAward() {}
/*     */     
/*     */     protected boolean processImp() throws Exception
/*     */     {
/* 167 */       if (!CrossBattleBetManager.isCrossBattleBetRankSwitchOpen())
/*     */       {
/* 169 */         return false;
/*     */       }
/*     */       
/* 172 */       long localid = GameServerInfoManager.getLocalId();
/*     */       
/* 174 */       lock(Cross_battle_bet_rank_backups.getTable(), Arrays.asList(new Long[] { Long.valueOf(localid) }));
/*     */       
/* 176 */       CrossBattleBetRankBackup xCrossBattleBetRankBackup = Cross_battle_bet_rank_backups.get(Long.valueOf(localid));
/* 177 */       if (xCrossBattleBetRankBackup == null)
/*     */       {
/* 179 */         return false;
/*     */       }
/* 181 */       for (Map.Entry<Integer, CrossBattleBetSeasonRankBackup> entry : xCrossBattleBetRankBackup.getBackups().entrySet())
/*     */       {
/* 183 */         activityCfgid = ((Integer)entry.getKey()).intValue();
/* 184 */         CrossBattleBetSeasonRankBackup xCrossBattleBetSeasonRankBackup = (CrossBattleBetSeasonRankBackup)entry.getValue();
/* 185 */         CrossBattleBetRankAwardInfo xWinCrossBattleBetRankAwardInfo = (CrossBattleBetRankAwardInfo)xCrossBattleBetSeasonRankBackup.getRank_award_infos().get(Integer.valueOf(50));
/*     */         
/* 187 */         if (xWinCrossBattleBetRankAwardInfo != null)
/*     */         {
/* 189 */           for (Map.Entry<Long, RoleCrossBattleBetRankAwardInfo> roleEntry : xWinCrossBattleBetRankAwardInfo.getRole_rank_award_infos().entrySet())
/*     */           {
/* 191 */             long roleid = ((Long)roleEntry.getKey()).longValue();
/* 192 */             RoleCrossBattleBetRankAwardInfo xRoleCrossBattleBetRankAwardInfo = (RoleCrossBattleBetRankAwardInfo)roleEntry.getValue();
/* 193 */             if ((xRoleCrossBattleBetRankAwardInfo != null) && (!xRoleCrossBattleBetRankAwardInfo.getAwarded()))
/*     */             {
/* 195 */               CrossBattleBetChartManager.this.sendRankAward(roleid, activityCfgid, 50);
/*     */             }
/*     */           }
/*     */         }
/* 199 */         CrossBattleBetRankAwardInfo xLoseCrossBattleBetRankAwardInfo = (CrossBattleBetRankAwardInfo)xCrossBattleBetSeasonRankBackup.getRank_award_infos().get(Integer.valueOf(51));
/*     */         
/* 201 */         if (xLoseCrossBattleBetRankAwardInfo != null)
/*     */         {
/* 203 */           for (Map.Entry<Long, RoleCrossBattleBetRankAwardInfo> roleEntry : xLoseCrossBattleBetRankAwardInfo.getRole_rank_award_infos().entrySet())
/*     */           {
/* 205 */             long roleid = ((Long)roleEntry.getKey()).longValue();
/* 206 */             RoleCrossBattleBetRankAwardInfo xRoleCrossBattleBetRankAwardInfo = (RoleCrossBattleBetRankAwardInfo)roleEntry.getValue();
/* 207 */             if ((xRoleCrossBattleBetRankAwardInfo != null) && (!xRoleCrossBattleBetRankAwardInfo.getAwarded()))
/*     */             {
/* 209 */               CrossBattleBetChartManager.this.sendRankAward(roleid, activityCfgid, 51); }
/*     */           }
/*     */         }
/*     */       }
/*     */       int activityCfgid;
/* 214 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   class PCheckAndGetRemoteRank extends LogicProcedure
/*     */   {
/*     */     PCheckAndGetRemoteRank() {}
/*     */     
/*     */     protected boolean processImp() throws Exception
/*     */     {
/* 224 */       long now = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/* 225 */       long localid = GameServerInfoManager.getLocalId();
/*     */       
/* 227 */       lock(Cross_battle_bet_rank_backups.getTable(), Arrays.asList(new Long[] { Long.valueOf(localid) }));
/*     */       
/* 229 */       CrossBattleBetRankBackup xCrossBattleBetRankBackup = Cross_battle_bet_rank_backups.get(Long.valueOf(localid));
/* 230 */       if (xCrossBattleBetRankBackup == null)
/*     */       {
/* 232 */         xCrossBattleBetRankBackup = Pod.newCrossBattleBetRankBackup();
/* 233 */         Cross_battle_bet_rank_backups.insert(Long.valueOf(localid), xCrossBattleBetRankBackup);
/*     */       }
/* 235 */       for (Iterator i$ = mzm.gsp.crossbattle.confbean.SCrossBattleStageDurationCfg.getAll().keySet().iterator(); i$.hasNext();) { int activityCfgid = ((Integer)i$.next()).intValue();
/*     */         
/* 237 */         mzm.gsp.activity.confbean.SActivityCfg activityCfg = mzm.gsp.activity.main.ActivityInterface.getActivityCfg(activityCfgid);
/* 238 */         if ((activityCfg != null) && 
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 243 */           (now >= mzm.gsp.common.TimeCommonUtil.getLimitTimeEnd(activityCfg.activityLimitTimeid)))
/*     */         {
/*     */ 
/*     */ 
/* 247 */           CrossBattleBetSeasonRankBackup xCrossBattleBetSeasonRankBackup = (CrossBattleBetSeasonRankBackup)xCrossBattleBetRankBackup.getBackups().get(Integer.valueOf(activityCfgid));
/*     */           
/* 249 */           if (xCrossBattleBetSeasonRankBackup == null)
/*     */           {
/* 251 */             xCrossBattleBetSeasonRankBackup = Pod.newCrossBattleBetSeasonRankBackup();
/* 252 */             xCrossBattleBetRankBackup.getBackups().put(Integer.valueOf(activityCfgid), xCrossBattleBetSeasonRankBackup);
/*     */           }
/* 254 */           CrossBattleBetRankAwardInfo xWinCrossBattleBetRankAwardInfo = (CrossBattleBetRankAwardInfo)xCrossBattleBetSeasonRankBackup.getRank_award_infos().get(Integer.valueOf(50));
/*     */           
/* 256 */           if ((xWinCrossBattleBetRankAwardInfo == null) || (!xWinCrossBattleBetRankAwardInfo.getIs_data_complete()))
/*     */           {
/*     */ 
/* 259 */             if (RankInterface.getAwardRank(50) >= 0)
/*     */             {
/* 261 */               new GetRemoteRankRangeSession(CrossBattleBetManager.GET_REMOTE_RANK_MIN_DELAY_IN_SECOND + Xdb.random().nextInt(CrossBattleBetManager.GET_REMOTE_RANK_MAX_DELAY_IN_SECOND - CrossBattleBetManager.GET_REMOTE_RANK_MIN_DELAY_IN_SECOND), activityCfgid, 50);
/*     */ 
/*     */ 
/*     */             }
/*     */             else
/*     */             {
/*     */ 
/*     */ 
/* 269 */               if (xWinCrossBattleBetRankAwardInfo == null)
/*     */               {
/* 271 */                 xWinCrossBattleBetRankAwardInfo = Pod.newCrossBattleBetRankAwardInfo();
/* 272 */                 xCrossBattleBetSeasonRankBackup.getRank_award_infos().put(Integer.valueOf(50), xWinCrossBattleBetRankAwardInfo);
/*     */               }
/*     */               
/*     */ 
/* 276 */               xWinCrossBattleBetRankAwardInfo.setIs_data_complete(true);
/*     */             }
/*     */           }
/*     */           
/* 280 */           CrossBattleBetRankAwardInfo xLoseCrossBattleBetRankAwardInfo = (CrossBattleBetRankAwardInfo)xCrossBattleBetSeasonRankBackup.getRank_award_infos().get(Integer.valueOf(51));
/*     */           
/* 282 */           if ((xLoseCrossBattleBetRankAwardInfo == null) || (!xLoseCrossBattleBetRankAwardInfo.getIs_data_complete()))
/*     */           {
/*     */ 
/* 285 */             if (RankInterface.getAwardRank(51) >= 0)
/*     */             {
/* 287 */               new GetRemoteRankRangeSession(CrossBattleBetManager.GET_REMOTE_RANK_MIN_DELAY_IN_SECOND + Xdb.random().nextInt(CrossBattleBetManager.GET_REMOTE_RANK_MAX_DELAY_IN_SECOND - CrossBattleBetManager.GET_REMOTE_RANK_MIN_DELAY_IN_SECOND), activityCfgid, 51);
/*     */ 
/*     */ 
/*     */             }
/*     */             else
/*     */             {
/*     */ 
/*     */ 
/* 295 */               if (xLoseCrossBattleBetRankAwardInfo == null)
/*     */               {
/* 297 */                 xLoseCrossBattleBetRankAwardInfo = Pod.newCrossBattleBetRankAwardInfo();
/* 298 */                 xCrossBattleBetSeasonRankBackup.getRank_award_infos().put(Integer.valueOf(51), xLoseCrossBattleBetRankAwardInfo);
/*     */               }
/*     */               
/*     */ 
/* 302 */               xLoseCrossBattleBetRankAwardInfo.setIs_data_complete(true);
/*     */             } }
/*     */         }
/*     */       }
/* 306 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\bet\CrossBattleBetChartManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
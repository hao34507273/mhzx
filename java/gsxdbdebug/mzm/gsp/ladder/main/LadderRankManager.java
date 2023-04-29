/*     */ package mzm.gsp.ladder.main;
/*     */ 
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.NavigableMap;
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.ladder.confbean.SLadderGradeCfg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.TaskOneByOne;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.CrossLadderLevelRangeRankBackup;
/*     */ import xbean.CrossLadderRank;
/*     */ import xbean.CrossLadderRankAwardInfo;
/*     */ import xbean.CrossLadderRankBackup;
/*     */ import xbean.CrossLadderSeasonRankBackup;
/*     */ import xbean.Ladder;
/*     */ import xbean.Pod;
/*     */ import xbean.RoleCrossLadderRankAwardInfo;
/*     */ import xdb.Xdb;
/*     */ 
/*     */ public class LadderRankManager
/*     */ {
/*     */   static final int PROTECT_DURATION_IN_MINUTE = 60;
/*  30 */   private static LadderRankManager instance = new LadderRankManager();
/*     */   private volatile long rankSeasonBeginTimestamp;
/*     */   private final Map<Integer, LadderChart> allLevelCharts;
/*     */   
/*  34 */   static LadderRankManager getInstance() { return instance; }
/*     */   
/*     */   public LadderRankManager() {
/*  37 */     this.rankSeasonBeginTimestamp = -1L;
/*  38 */     this.allLevelCharts = new java.util.HashMap();
/*  39 */     this.allTypeCharts = new java.util.HashMap();
/*  40 */     this.rankOneByOne = new TaskOneByOne();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   void init()
/*     */   {
/*  47 */     if (GameServerInfoManager.isRoamServer())
/*     */     {
/*  49 */       return;
/*     */     }
/*  51 */     if (this.allLevelCharts.isEmpty())
/*     */     {
/*  53 */       for (SLadderGradeCfg cfg : SLadderGradeCfg.getAll().values())
/*     */       {
/*  55 */         LadderChart chart = new LadderChart(cfg.localChartType);
/*  56 */         this.allLevelCharts.put(Integer.valueOf(cfg.level), chart);
/*  57 */         this.allTypeCharts.put(Integer.valueOf(cfg.localChartType), chart);
/*     */       }
/*     */       
/*     */     }
/*     */     else {
/*  62 */       throw new RuntimeException("初始化跨服天梯本服排行榜错误！！！");
/*     */     }
/*     */     
/*  65 */     if (!new PInitRankData().call())
/*     */     {
/*  67 */       throw new RuntimeException("初始化跨服天梯排行榜错误！！！");
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   void postInit()
/*     */   {
/*  76 */     if (GameServerInfoManager.isRoamServer())
/*     */     {
/*  78 */       return;
/*     */     }
/*     */     
/*  81 */     new PCheckAndGetRemoteRank().call();
/*     */     
/*  83 */     long now = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/*  84 */     Long currentSeasonBeginTimestamp = LadderManager.getBeforeSessionTimeMilSec(now);
/*  85 */     if ((currentSeasonBeginTimestamp != null) && (currentSeasonBeginTimestamp.longValue() > this.rankSeasonBeginTimestamp))
/*     */     {
/*  87 */       new POnSeasonBegin(currentSeasonBeginTimestamp.longValue()).call();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   void checkAndGetRemoteRank()
/*     */   {
/*  96 */     this.rankOneByOne.add(new PCheckAndGetRemoteRank());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void rank(long roleid, long seasonBeginTimestamp)
/*     */   {
/* 107 */     if (seasonBeginTimestamp <= 0L)
/*     */     {
/* 109 */       return;
/*     */     }
/* 111 */     if (seasonBeginTimestamp > this.rankSeasonBeginTimestamp)
/*     */     {
/* 113 */       this.rankOneByOne.add(new POnSeasonBegin(seasonBeginTimestamp));
/* 114 */       this.rankOneByOne.add(new PRankRole(roleid, seasonBeginTimestamp, true));
/*     */     }
/* 116 */     else if (seasonBeginTimestamp == this.rankSeasonBeginTimestamp)
/*     */     {
/* 118 */       this.rankOneByOne.add(new PRankRole(roleid, seasonBeginTimestamp, true));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void onSeasonStart(long seasonBeginTimestamp)
/*     */   {
/* 129 */     this.rankOneByOne.add(new POnSeasonBegin(seasonBeginTimestamp));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   void saveToDB()
/*     */   {
/* 137 */     this.rankOneByOne.add(new PSaveToDB());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   int getRankByLevelRange(long roleid, int levelRange)
/*     */   {
/* 149 */     return ((LadderChart)this.allLevelCharts.get(Integer.valueOf(levelRange))).getRank(Long.valueOf(roleid));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   int getRankByChartType(long roleid, int chartType)
/*     */   {
/* 161 */     return ((LadderChart)this.allTypeCharts.get(Integer.valueOf(chartType))).getRank(Long.valueOf(roleid));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private final Map<Integer, LadderChart> allTypeCharts;
/*     */   
/*     */ 
/*     */   private final TaskOneByOne rankOneByOne;
/*     */   
/*     */ 
/*     */   List<LadderChartObj> getchartObjsByLevelRange(int levelRange, int from, int to)
/*     */   {
/* 174 */     return ((LadderChart)this.allLevelCharts.get(Integer.valueOf(levelRange))).getRankObjs(from, to);
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
/*     */   List<LadderChartObj> getchartObjsByChartType(int chartType, int from, int to)
/*     */   {
/* 187 */     return ((LadderChart)this.allTypeCharts.get(Integer.valueOf(chartType))).getRankObjs(from, to);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void checkAndSendAward()
/*     */   {
/* 197 */     this.rankOneByOne.add(new PCheckAndSendAward());
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
/*     */   void sendRankAward(long roleid, long seasonBeginTimestamp, int levelRange, int chartType)
/*     */   {
/* 210 */     this.rankOneByOne.add(new PSendRankAward(roleid, seasonBeginTimestamp, levelRange, chartType));
/*     */   }
/*     */   
/*     */   class ReportAllRankRoleSession extends mzm.gsp.timer.main.Session
/*     */   {
/*     */     public ReportAllRankRoleSession(long interval)
/*     */     {
/* 217 */       super(0L);
/* 218 */       GameServer.logger().info(String.format("[ladder]LadderRankManager.ReportAllRankRoleSession@start report all rank role session|interval=%d", new Object[] { Long.valueOf(interval) }));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     public void onTimeOut()
/*     */     {
/* 226 */       LadderRankManager.this.rankOneByOne.add(new mzm.gsp.util.LogicRunnable()
/*     */       {
/*     */ 
/*     */         public void process()
/*     */           throws Exception
/*     */         {
/* 232 */           Set<Long> rankRoleids = new HashSet();
/* 233 */           for (LadderChart chart : LadderRankManager.this.allLevelCharts.values())
/*     */           {
/* 235 */             List<LadderChartObj> chartObjs = chart.getAllChartObjs();
/* 236 */             for (LadderChartObj chartObj : chartObjs)
/*     */             {
/* 238 */               rankRoleids.add(chartObj.getKey());
/*     */             }
/*     */           }
/* 241 */           for (Iterator i$ = rankRoleids.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */             
/* 243 */             LadderRankManager.this.rankOneByOne.add(new LadderRankManager.PReportRoleRank(LadderRankManager.this, roleid));
/*     */           }
/*     */         }
/*     */       });
/*     */     }
/*     */   }
/*     */   
/*     */   class PReportRoleRank extends LogicProcedure
/*     */   {
/*     */     private final long roleid;
/*     */     
/*     */     public PReportRoleRank(long roleid)
/*     */     {
/* 256 */       this.roleid = roleid;
/*     */     }
/*     */     
/*     */ 
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 263 */       Ladder xLadder = LadderManager.getAndInitXLadder(this.roleid, true);
/* 264 */       if (xLadder == null)
/*     */       {
/* 266 */         return false;
/*     */       }
/* 268 */       Long roleSeasonBeginTimestamp = LadderManager.getBeforeSessionTimeMilSec(xLadder.getInittime());
/* 269 */       if ((roleSeasonBeginTimestamp == null) || (roleSeasonBeginTimestamp.longValue() != LadderRankManager.this.rankSeasonBeginTimestamp))
/*     */       {
/*     */ 
/* 272 */         return false;
/*     */       }
/* 274 */       int score = LadderManager.getScore(this.roleid, xLadder);
/* 275 */       LadderManager.reportRoleLadderInfo(this.roleid, xLadder, score, roleSeasonBeginTimestamp);
/* 276 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   class CleanRankSession extends mzm.gsp.timer.main.Session
/*     */   {
/*     */     private final Set<Integer> deleteLevelRanges;
/*     */     
/*     */     public CleanRankSession(long arg3, Set<Integer> arg5)
/*     */     {
/* 286 */       super(seasonBeginTimestamp);
/* 287 */       this.deleteLevelRanges = deleteLevelRanges;
/* 288 */       GameServer.logger().info(String.format("[ladder]LadderRankManager.CleanRankSession@start clean session|interval=%d|season_begin_timestamp=%d|delete_level_ranges=%s", new Object[] { Long.valueOf(interval), Long.valueOf(seasonBeginTimestamp), deleteLevelRanges.toString() }));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     public void onTimeOut()
/*     */     {
/* 296 */       for (Iterator i$ = this.deleteLevelRanges.iterator(); i$.hasNext();) { int deleteLevelRange = ((Integer)i$.next()).intValue();
/*     */         
/* 298 */         mzm.gsp.ladder.CleanLadderRankContext context = new mzm.gsp.ladder.CleanLadderRankContext();
/* 299 */         context.count = 1;
/* 300 */         if (!mzm.gsp.crossserver.main.CrossServerInterface.asyncCleanLadderRank(LadderManager.getRemoteRankid(getOwerId(), deleteLevelRange), context.marshal(new com.goldhuman.Common.Marshal.OctetsStream())))
/*     */         {
/*     */ 
/*     */ 
/* 304 */           GameServer.logger().error(String.format("[ladder]LadderRankManager.CleanRankSession.onTimeOut@communication error|season_start_timestamp|level_range=%d", new Object[] { Long.valueOf(getOwerId()), Integer.valueOf(deleteLevelRange) }));
/*     */           
/*     */ 
/*     */ 
/*     */ 
/* 309 */           new CleanRankSession(LadderRankManager.this, LadderManager.GRC_MIN_DELAY_IN_SECOND + Xdb.random().nextInt(LadderManager.GRC_MAX_DELAY_IN_SECOND - LadderManager.GRC_MIN_DELAY_IN_SECOND), getOwerId(), this.deleteLevelRanges);
/*     */           
/*     */ 
/*     */ 
/* 313 */           return;
/*     */         }
/* 315 */         GameServer.logger().info(String.format("[ladder]LadderRankManager.CleanRankSession.onTimeOut@clean ladder rank in grc|season_start_timestamp|level_range=%d", new Object[] { Long.valueOf(getOwerId()), Integer.valueOf(deleteLevelRange) }));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   class PInitRankData
/*     */     extends LogicProcedure
/*     */   {
/*     */     PInitRankData() {}
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 328 */       long now = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/* 329 */       Long currentSeasonBeginTimestamp = LadderManager.getBeforeSessionTimeMilSec(now);
/* 330 */       if (currentSeasonBeginTimestamp == null)
/*     */       {
/*     */ 
/* 333 */         GameServer.logger().error(String.format("[ladder]LadderRankManager.PInitRankData.processImp@not in season", new Object[0]));
/* 334 */         return false;
/*     */       }
/*     */       
/* 337 */       long localid = GameServerInfoManager.getLocalId();
/* 338 */       CrossLadderRank xCrossLadderRank = xtable.Cross_ladder_ranks.get(Long.valueOf(localid));
/* 339 */       if (xCrossLadderRank == null)
/*     */       {
/*     */ 
/* 342 */         LadderRankManager.this.rankSeasonBeginTimestamp = currentSeasonBeginTimestamp.longValue();
/* 343 */         xbean.LadderRank xLadderRank = xtable.Ladderrank.get(Long.valueOf(localid));
/* 344 */         if (xLadderRank == null)
/*     */         {
/*     */ 
/* 347 */           GameServer.logger().info(String.format("[ladder]LadderRankManager.PInitRankData.processImp@old rank in db is null", new Object[0]));
/*     */           
/* 349 */           return true;
/*     */         }
/* 351 */         Long dbSeasonBeginTimestamp = LadderManager.getBeforeSessionTimeMilSec(xLadderRank.getInittime());
/* 352 */         if ((dbSeasonBeginTimestamp == null) || (currentSeasonBeginTimestamp.longValue() != dbSeasonBeginTimestamp.longValue()))
/*     */         {
/*     */ 
/*     */ 
/* 356 */           GameServer.logger().error(String.format("[ladder]LadderRankManager.PInitRankData.processImp@db season is not equal to current season|db_season_begin_timestamp=%d|current_season_begin_timestamp=%d", new Object[] { Long.valueOf(dbSeasonBeginTimestamp == null ? -1L : dbSeasonBeginTimestamp.longValue()), currentSeasonBeginTimestamp }));
/*     */           
/*     */ 
/*     */ 
/* 360 */           return false;
/*     */         }
/* 362 */         Long nextSeasonBeginTimestamp = LadderManager.getNextSessionTimeMilSec(currentSeasonBeginTimestamp.longValue());
/* 363 */         if ((nextSeasonBeginTimestamp != null) && (nextSeasonBeginTimestamp.longValue() - now <= 3600000L))
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/* 368 */           GameServer.logger().info(String.format("[ladder]LadderRankManager.PInitRankData.processImp@interval between current and season end is too small|db_season_begin_timestamp=%d|current_season_begin_timestamp=%d|next_season_begin_timestamp=%d", new Object[] { Long.valueOf(dbSeasonBeginTimestamp == null ? -1L : dbSeasonBeginTimestamp.longValue()), currentSeasonBeginTimestamp, nextSeasonBeginTimestamp }));
/*     */           
/*     */ 
/*     */ 
/*     */ 
/* 373 */           return false;
/*     */         }
/* 375 */         for (xbean.LadderRankRole xLadderRankRole : xLadderRank.getRanklist())
/*     */         {
/*     */ 
/* 378 */           long roleid = xLadderRankRole.getRoleid();
/* 379 */           Ladder xLadder = LadderManager.getAndInitXLadder(roleid, false);
/* 380 */           if (xLadder != null)
/*     */           {
/*     */ 
/*     */ 
/* 384 */             int levelRange = LadderManager.getLevelRange(mzm.gsp.role.main.RoleInterface.getLevel(roleid));
/* 385 */             if (levelRange > 0)
/*     */             {
/*     */ 
/*     */ 
/* 389 */               int score = LadderManager.getScore(roleid, xLadder);
/* 390 */               LadderChartObj ladderChartObj = new LadderChartObj(roleid, score, xLadder.getStage());
/* 391 */               ((LadderChart)LadderRankManager.this.allLevelCharts.get(Integer.valueOf(levelRange))).rank(ladderChartObj);
/*     */             } } }
/* 393 */         new LadderRankManager.ReportAllRankRoleSession(LadderRankManager.this, LadderManager.GRC_MIN_DELAY_IN_SECOND + Xdb.random().nextInt(LadderManager.GRC_MAX_DELAY_IN_SECOND - LadderManager.GRC_MIN_DELAY_IN_SECOND));
/*     */         
/*     */ 
/* 396 */         return true;
/*     */       }
/*     */       
/* 399 */       LadderRankManager.this.rankSeasonBeginTimestamp = xCrossLadderRank.getSeason_begin_timestamp();
/* 400 */       boolean isLevelRangeCfgChanged = false;
/* 401 */       Set<Integer> dbLevelRanges = new HashSet(xCrossLadderRank.getLevel_range_ranks().keySet());
/* 402 */       Set<Integer> cfgLevelRanges = new HashSet(SLadderGradeCfg.getAll().keySet());
/* 403 */       if ((dbLevelRanges.size() != cfgLevelRanges.size()) || (!dbLevelRanges.containsAll(cfgLevelRanges)))
/*     */       {
/*     */ 
/* 406 */         isLevelRangeCfgChanged = true;
/* 407 */         if (currentSeasonBeginTimestamp.longValue() != LadderRankManager.this.rankSeasonBeginTimestamp)
/*     */         {
/*     */ 
/* 410 */           GameServer.logger().info(String.format("[ladder]LadderRankManager.PInitRankData.processImp@db season is not equal to current season|db_season_begin_timestamp=%d|current_season_begin_timestamp=%d", new Object[] { Long.valueOf(LadderRankManager.this.rankSeasonBeginTimestamp), currentSeasonBeginTimestamp }));
/*     */           
/*     */ 
/*     */ 
/* 414 */           return false;
/*     */         }
/* 416 */         Long nextSeasonBeginTimestamp = LadderManager.getNextSessionTimeMilSec(currentSeasonBeginTimestamp.longValue());
/* 417 */         if ((nextSeasonBeginTimestamp != null) && (nextSeasonBeginTimestamp.longValue() - now <= 3600000L))
/*     */         {
/*     */ 
/*     */ 
/* 421 */           GameServer.logger().info(String.format("[ladder]LadderRankManager.PInitRankData.processImp@interval between current and season end is too small|db_season_begin_timestamp=%d|current_season_begin_timestamp=%d|next_season_begin_timestamp=%d", new Object[] { Long.valueOf(LadderRankManager.this.rankSeasonBeginTimestamp), currentSeasonBeginTimestamp, nextSeasonBeginTimestamp }));
/*     */           
/*     */ 
/*     */ 
/*     */ 
/* 426 */           return false;
/*     */         }
/* 428 */         Set<Integer> deleteLevelRanges = new HashSet(dbLevelRanges);
/* 429 */         deleteLevelRanges.removeAll(cfgLevelRanges);
/* 430 */         new LadderRankManager.CleanRankSession(LadderRankManager.this, LadderManager.GRC_MIN_DELAY_IN_SECOND + Xdb.random().nextInt(LadderManager.GRC_MAX_DELAY_IN_SECOND - LadderManager.GRC_MIN_DELAY_IN_SECOND), LadderRankManager.this.rankSeasonBeginTimestamp, deleteLevelRanges);
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 435 */       for (xbean.CrossLadderRankList xCrossLadderRankList : xCrossLadderRank.getLevel_range_ranks().values())
/*     */       {
/* 437 */         for (i$ = xCrossLadderRankList.getRank_list().iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */           
/*     */ 
/* 440 */           Ladder xLadder = xtable.Role2ladder.select(Long.valueOf(roleid));
/* 441 */           if (xLadder != null)
/*     */           {
/*     */ 
/*     */ 
/* 445 */             Long roleSeasonBeginTimestamp = LadderManager.getBeforeSessionTimeMilSec(xLadder.getInittime());
/* 446 */             if ((roleSeasonBeginTimestamp != null) && (roleSeasonBeginTimestamp.longValue() == LadderRankManager.this.rankSeasonBeginTimestamp))
/*     */             {
/*     */ 
/*     */ 
/*     */ 
/* 451 */               int levelRange = LadderManager.getLevelRange(mzm.gsp.role.main.RoleInterface.getLevel(roleid));
/* 452 */               if (levelRange > 0)
/*     */               {
/*     */ 
/*     */ 
/* 456 */                 int score = LadderManager.getScore(roleid, xLadder);
/* 457 */                 LadderChartObj ladderChartObj = new LadderChartObj(roleid, score, xLadder.getStage());
/* 458 */                 ((LadderChart)LadderRankManager.this.allLevelCharts.get(Integer.valueOf(levelRange))).rank(ladderChartObj);
/*     */               } } } } }
/*     */       Iterator i$;
/* 461 */       if (isLevelRangeCfgChanged)
/*     */       {
/* 463 */         new LadderRankManager.ReportAllRankRoleSession(LadderRankManager.this, LadderManager.GRC_MIN_DELAY_IN_SECOND + Xdb.random().nextInt(LadderManager.GRC_MAX_DELAY_IN_SECOND - LadderManager.GRC_MIN_DELAY_IN_SECOND));
/*     */       }
/*     */       
/*     */ 
/* 467 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   class PCheckAndGetRemoteRank extends LogicProcedure
/*     */   {
/*     */     PCheckAndGetRemoteRank() {}
/*     */     
/*     */     protected boolean processImp() throws Exception {
/* 476 */       long now = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/* 477 */       Long currentSeasonBeginTimestamp = LadderManager.getBeforeSessionTimeMilSec(now);
/*     */       
/* 479 */       long localid = GameServerInfoManager.getLocalId();
/* 480 */       CrossLadderRankBackup xCrossLadderRankBackup = xtable.Cross_ladder_rank_backups.get(Long.valueOf(localid));
/* 481 */       if (xCrossLadderRankBackup == null)
/*     */       {
/* 483 */         xCrossLadderRankBackup = Pod.newCrossLadderRankBackup();
/* 484 */         if (currentSeasonBeginTimestamp != null)
/*     */         {
/* 486 */           xCrossLadderRankBackup.setInit_season_begin_timestamp(currentSeasonBeginTimestamp.longValue());
/*     */         }
/* 488 */         xtable.Cross_ladder_rank_backups.insert(Long.valueOf(localid), xCrossLadderRankBackup);
/*     */       }
/* 490 */       for (Iterator i$ = LadderManager.getPreSeasonBeginTimestamp(now).iterator(); i$.hasNext();) { seasonBeginTimestamp = ((Long)i$.next()).longValue();
/*     */         
/* 492 */         if (seasonBeginTimestamp >= xCrossLadderRankBackup.getInit_season_begin_timestamp())
/*     */         {
/*     */ 
/*     */ 
/* 496 */           CrossLadderSeasonRankBackup xCrossLadderSeasonRankBackup = (CrossLadderSeasonRankBackup)xCrossLadderRankBackup.getBackups().get(Long.valueOf(seasonBeginTimestamp));
/*     */           
/* 498 */           if (xCrossLadderSeasonRankBackup != null)
/*     */           {
/*     */ 
/*     */ 
/* 502 */             for (Map.Entry<Integer, CrossLadderLevelRangeRankBackup> entry : xCrossLadderSeasonRankBackup.getLevel_range_rank_backups().entrySet())
/*     */             {
/* 504 */               int levelRange = ((Integer)entry.getKey()).intValue();
/* 505 */               CrossLadderLevelRangeRankBackup xCrossLadderLevelRangeRankBackup = (CrossLadderLevelRangeRankBackup)entry.getValue();
/* 506 */               SLadderGradeCfg cfg = SLadderGradeCfg.get(levelRange);
/* 507 */               if (cfg != null)
/*     */               {
/*     */ 
/*     */ 
/* 511 */                 CrossLadderRankAwardInfo xCrossLadderRankAwardInfo = (CrossLadderRankAwardInfo)xCrossLadderLevelRangeRankBackup.getRank_award_infos().get(Integer.valueOf(cfg.remoteChartType));
/*     */                 
/* 513 */                 if ((xCrossLadderRankAwardInfo != null) && (!xCrossLadderRankAwardInfo.getIs_data_complete()))
/*     */                 {
/*     */ 
/*     */ 
/*     */ 
/* 518 */                   if (mzm.gsp.chart.main.RankInterface.getAwardRank(cfg.remoteChartType) >= 0)
/*     */                   {
/* 520 */                     new GetLadderRemoteRankRangeSession(LadderManager.GRC_MIN_DELAY_IN_SECOND + Xdb.random().nextInt(LadderManager.GRC_MAX_DELAY_IN_SECOND - LadderManager.GRC_MIN_DELAY_IN_SECOND), LadderManager.getRemoteRankid(seasonBeginTimestamp, levelRange), cfg.remoteChartType);
/*     */ 
/*     */ 
/*     */                   }
/*     */                   else
/*     */                   {
/*     */ 
/*     */ 
/* 528 */                     xCrossLadderRankAwardInfo.setIs_data_complete(true); } }
/*     */               }
/*     */             } } } }
/*     */       long seasonBeginTimestamp;
/* 532 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   class POnSeasonBegin extends LogicProcedure
/*     */   {
/*     */     private final long seasonBeginTimestamp;
/*     */     
/*     */     public POnSeasonBegin(long seasonBeginTimestamp)
/*     */     {
/* 542 */       this.seasonBeginTimestamp = seasonBeginTimestamp;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 548 */       if (this.seasonBeginTimestamp <= 0L)
/*     */       {
/* 550 */         return false;
/*     */       }
/* 552 */       if (LadderRankManager.this.rankSeasonBeginTimestamp >= this.seasonBeginTimestamp)
/*     */       {
/*     */ 
/* 555 */         return false;
/*     */       }
/* 557 */       Long firstSeasonBeginTimestamp = LadderManager.getFirstSeasonBeginTimestamp();
/* 558 */       if (firstSeasonBeginTimestamp == null)
/*     */       {
/* 560 */         return false;
/*     */       }
/* 562 */       if (this.seasonBeginTimestamp == firstSeasonBeginTimestamp.longValue())
/*     */       {
/* 564 */         LadderRankManager.this.rankSeasonBeginTimestamp = firstSeasonBeginTimestamp.longValue();
/* 565 */         GameServer.logger().info(String.format("[ladder]LadderRankManager.POnSeasonStart.processImp@first season do not have award|season_begin_timestamp=%d", new Object[] { Long.valueOf(this.seasonBeginTimestamp) }));
/*     */         
/*     */ 
/*     */ 
/* 569 */         return true;
/*     */       }
/*     */       
/* 572 */       new LadderRankManager.PBackUpRankDataAndAward(LadderRankManager.this, LadderRankManager.this.rankSeasonBeginTimestamp).call();
/* 573 */       LadderRankManager.this.rankSeasonBeginTimestamp = this.seasonBeginTimestamp;
/* 574 */       Set<Long> rankRoleids = new HashSet();
/* 575 */       for (LadderChart chart : LadderRankManager.this.allLevelCharts.values())
/*     */       {
/* 577 */         List<LadderChartObj> chartObjs = chart.getAllChartObjs();
/* 578 */         for (LadderChartObj chartObj : chartObjs)
/*     */         {
/* 580 */           rankRoleids.add(chartObj.getKey());
/*     */         }
/*     */       }
/* 583 */       for (Iterator i$ = rankRoleids.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */         
/* 585 */         LadderRankManager.this.rankOneByOne.add(new LadderRankManager.PRankRole(LadderRankManager.this, roleid, LadderRankManager.this.rankSeasonBeginTimestamp, false));
/*     */       }
/*     */       
/* 588 */       new LadderRankManager.ReportAllRankRoleSession(LadderRankManager.this, LadderManager.GRC_MIN_DELAY_IN_SECOND + Xdb.random().nextInt(LadderManager.GRC_MAX_DELAY_IN_SECOND - LadderManager.GRC_MIN_DELAY_IN_SECOND));
/*     */       
/* 590 */       LadderRankManager.this.saveToDB();
/* 591 */       GameServer.logger().info(String.format("[ladder]LadderRankManager.POnSeasonStart.processImp@season begin|season_begin_timestamp=%d", new Object[] { Long.valueOf(this.seasonBeginTimestamp) }));
/*     */       
/*     */ 
/* 594 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   class PBackUpRankDataAndAward
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final long seasonBeginTimestamp;
/*     */     
/*     */     public PBackUpRankDataAndAward(long seasonBeginTimestamp)
/*     */     {
/* 605 */       this.seasonBeginTimestamp = seasonBeginTimestamp;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 611 */       if (this.seasonBeginTimestamp <= 0L)
/*     */       {
/* 613 */         return false;
/*     */       }
/*     */       
/* 616 */       long localid = GameServerInfoManager.getLocalId();
/* 617 */       CrossLadderRankBackup xCrossLadderRankBackup = xtable.Cross_ladder_rank_backups.get(Long.valueOf(localid));
/* 618 */       if (xCrossLadderRankBackup == null)
/*     */       {
/*     */ 
/* 621 */         GameServer.logger().error(String.format("[ladder]LadderRankManager.PBackUpRankDataAndAward.processImp@rank backup is null|season_begin_timestamp=%d", new Object[] { Long.valueOf(this.seasonBeginTimestamp) }));
/*     */         
/*     */ 
/*     */ 
/* 625 */         return false;
/*     */       }
/* 627 */       if (this.seasonBeginTimestamp < xCrossLadderRankBackup.getInit_season_begin_timestamp())
/*     */       {
/*     */ 
/* 630 */         GameServer.logger().error(String.format("[ladder]LadderRankManager.PBackUpRankDataAndAward.processImp@season before init season do not need award|season_begin_timestamp=%d|init_season_begin_timestamp=%d", new Object[] { Long.valueOf(this.seasonBeginTimestamp), Long.valueOf(xCrossLadderRankBackup.getInit_season_begin_timestamp()) }));
/*     */         
/*     */ 
/*     */ 
/* 634 */         return false;
/*     */       }
/* 636 */       if (xCrossLadderRankBackup.getBackups().containsKey(Long.valueOf(this.seasonBeginTimestamp)))
/*     */       {
/*     */ 
/* 639 */         GameServer.logger().error(String.format("[ladder]LadderRankManager.PBackUpRankDataAndAward.processImp@season chart has been backuped|season_begin_timestamp=%d", new Object[] { Long.valueOf(this.seasonBeginTimestamp) }));
/*     */         
/*     */ 
/*     */ 
/* 643 */         return false;
/*     */       }
/* 645 */       CrossLadderSeasonRankBackup xCrossLadderSeasonRankBackup = Pod.newCrossLadderSeasonRankBackup();
/* 646 */       xCrossLadderRankBackup.getBackups().put(Long.valueOf(this.seasonBeginTimestamp), xCrossLadderSeasonRankBackup);
/*     */       
/* 648 */       for (SLadderGradeCfg cfg : SLadderGradeCfg.getAll().values())
/*     */       {
/* 650 */         CrossLadderLevelRangeRankBackup xCrossLadderLevelRangeRankBackup = Pod.newCrossLadderLevelRangeRankBackup();
/* 651 */         xCrossLadderSeasonRankBackup.getLevel_range_rank_backups().put(Integer.valueOf(cfg.level), xCrossLadderLevelRangeRankBackup);
/* 652 */         List<LadderChartObj> chartObjs = ((LadderChart)LadderRankManager.this.allLevelCharts.get(Integer.valueOf(cfg.level))).getAllChartObjs();
/* 653 */         for (LadderChartObj chartObj : chartObjs)
/*     */         {
/* 655 */           xCrossLadderLevelRangeRankBackup.getLocal_rank_list().add(chartObj.getKey());
/*     */         }
/*     */         
/* 658 */         CrossLadderRankAwardInfo xLocalCrossLadderRankAwardInfo = Pod.newCrossLadderRankAwardInfo();
/* 659 */         xLocalCrossLadderRankAwardInfo.setIs_data_complete(true);
/* 660 */         xCrossLadderLevelRangeRankBackup.getRank_award_infos().put(Integer.valueOf(cfg.localChartType), xLocalCrossLadderRankAwardInfo);
/* 661 */         int rank = mzm.gsp.chart.main.RankInterface.getAwardRank(cfg.localChartType);
/* 662 */         if (rank >= 0)
/*     */         {
/* 664 */           for (int i = 0; (i < chartObjs.size()) && (i <= rank); i++)
/*     */           {
/* 666 */             long roleid = ((LadderChartObj)chartObjs.get(i)).getKey().longValue();
/* 667 */             RoleCrossLadderRankAwardInfo xRoleCrossLadderRankAwardInfo = Pod.newRoleCrossLadderRankAwardInfo();
/* 668 */             xRoleCrossLadderRankAwardInfo.setRank(i);
/* 669 */             xLocalCrossLadderRankAwardInfo.getRole_rank_award_infos().put(Long.valueOf(roleid), xRoleCrossLadderRankAwardInfo);
/* 670 */             if (mzm.gsp.open.main.OpenInterface.getOpenStatus(188))
/*     */             {
/* 672 */               LadderRankManager.this.sendRankAward(roleid, this.seasonBeginTimestamp, cfg.level, cfg.localChartType);
/*     */             }
/*     */           }
/*     */         }
/*     */         
/* 677 */         CrossLadderRankAwardInfo xRemoteCrossLadderRankAwardInfo = Pod.newCrossLadderRankAwardInfo();
/* 678 */         xCrossLadderLevelRangeRankBackup.getRank_award_infos().put(Integer.valueOf(cfg.remoteChartType), xRemoteCrossLadderRankAwardInfo);
/* 679 */         if (mzm.gsp.chart.main.RankInterface.getAwardRank(cfg.remoteChartType) >= 0)
/*     */         {
/* 681 */           new GetLadderRemoteRankRangeSession(LadderManager.GRC_MIN_DELAY_IN_SECOND + Xdb.random().nextInt(LadderManager.GRC_MAX_DELAY_IN_SECOND - LadderManager.GRC_MIN_DELAY_IN_SECOND), LadderManager.getRemoteRankid(this.seasonBeginTimestamp, cfg.level), cfg.remoteChartType);
/*     */ 
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/*     */ 
/*     */ 
/* 689 */           xRemoteCrossLadderRankAwardInfo.setIs_data_complete(true);
/*     */         }
/*     */       }
/* 692 */       GameServer.logger().info(String.format("[ladder]LadderRankManager.PBackUpRankDataAndAward.processImp@backup ladder rank|season_begin_timestamp=%d|level_ranges=%s", new Object[] { Long.valueOf(this.seasonBeginTimestamp), SLadderGradeCfg.getAll().keySet().toString() }));
/*     */       
/*     */ 
/*     */ 
/* 696 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   class PRankRole extends LogicProcedure
/*     */   {
/*     */     private final long roleid;
/*     */     private final long seasonBeginTimestamp;
/*     */     private final boolean needReport;
/*     */     
/*     */     public PRankRole(long roleid, long seasonBeginTimestamp, boolean needReport)
/*     */     {
/* 708 */       this.roleid = roleid;
/* 709 */       this.seasonBeginTimestamp = seasonBeginTimestamp;
/* 710 */       this.needReport = needReport;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 716 */       if ((this.seasonBeginTimestamp <= 0L) || (this.seasonBeginTimestamp != LadderRankManager.this.rankSeasonBeginTimestamp))
/*     */       {
/* 718 */         return false;
/*     */       }
/*     */       
/* 721 */       Ladder xLadder = LadderManager.getAndInitXLadder(this.roleid, true);
/* 722 */       if (xLadder == null)
/*     */       {
/* 724 */         return false;
/*     */       }
/* 726 */       Long roleSeasonBeginTimestamp = LadderManager.getBeforeSessionTimeMilSec(xLadder.getInittime());
/* 727 */       if ((roleSeasonBeginTimestamp == null) || (roleSeasonBeginTimestamp.longValue() != this.seasonBeginTimestamp))
/*     */       {
/* 729 */         return false;
/*     */       }
/* 731 */       int levelRange = LadderManager.getLevelRange(mzm.gsp.role.main.RoleInterface.getLevel(this.roleid));
/* 732 */       if (levelRange <= 0)
/*     */       {
/* 734 */         return false;
/*     */       }
/* 736 */       int score = LadderManager.getScore(this.roleid, xLadder);
/* 737 */       LadderChartObj ladderChartObj = new LadderChartObj(this.roleid, score, xLadder.getStage());
/* 738 */       ((LadderChart)LadderRankManager.this.allLevelCharts.get(Integer.valueOf(levelRange))).rank(ladderChartObj);
/* 739 */       for (Iterator i$ = SLadderGradeCfg.getAll().keySet().iterator(); i$.hasNext();) { int otherLevelRange = ((Integer)i$.next()).intValue();
/*     */         
/* 741 */         if (otherLevelRange != levelRange)
/*     */         {
/*     */ 
/*     */ 
/* 745 */           ((LadderChart)LadderRankManager.this.allLevelCharts.get(Integer.valueOf(otherLevelRange))).removeByRoleid(this.roleid, false); }
/*     */       }
/* 747 */       GameServer.logger().info(String.format("[ladder]LadderRankManager.PRankRole.processImp@add role to rank|roleid=%d|season_begin_timestamp=%d|level_range=%d|stage=%d|score=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.seasonBeginTimestamp), Integer.valueOf(levelRange), Integer.valueOf(xLadder.getStage()), Integer.valueOf(score) }));
/*     */       
/*     */ 
/*     */ 
/* 751 */       if (this.needReport)
/*     */       {
/* 753 */         LadderManager.reportRoleLadderInfo(this.roleid, xLadder, score, roleSeasonBeginTimestamp);
/*     */       }
/* 755 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   class PSaveToDB extends LogicProcedure
/*     */   {
/*     */     PSaveToDB() {}
/*     */     
/*     */     protected boolean processImp() throws Exception {
/* 764 */       if (LadderRankManager.this.rankSeasonBeginTimestamp <= 0L)
/*     */       {
/* 766 */         return false;
/*     */       }
/*     */       
/* 769 */       long localid = GameServerInfoManager.getLocalId();
/* 770 */       CrossLadderRank xCrossLadderRank = xtable.Cross_ladder_ranks.get(Long.valueOf(localid));
/* 771 */       if (xCrossLadderRank == null)
/*     */       {
/* 773 */         xCrossLadderRank = Pod.newCrossLadderRank();
/* 774 */         xtable.Cross_ladder_ranks.insert(Long.valueOf(localid), xCrossLadderRank);
/*     */       }
/* 776 */       xCrossLadderRank.setSeason_begin_timestamp(LadderRankManager.this.rankSeasonBeginTimestamp);
/* 777 */       xCrossLadderRank.getLevel_range_ranks().clear();
/* 778 */       for (Map.Entry<Integer, LadderChart> entry : LadderRankManager.this.allLevelCharts.entrySet())
/*     */       {
/* 780 */         int levelRange = ((Integer)entry.getKey()).intValue();
/* 781 */         LadderChart chart = (LadderChart)entry.getValue();
/* 782 */         xCrossLadderRankList = Pod.newCrossLadderRankList();
/* 783 */         xCrossLadderRank.getLevel_range_ranks().put(Integer.valueOf(levelRange), xCrossLadderRankList);
/* 784 */         for (LadderChartObj chartObj : chart.getAllChartObjs())
/*     */         {
/* 786 */           xCrossLadderRankList.getRank_list().add(chartObj.getKey()); }
/*     */       }
/*     */       xbean.CrossLadderRankList xCrossLadderRankList;
/* 789 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   class PCheckAndSendAward extends LogicProcedure
/*     */   {
/*     */     PCheckAndSendAward() {}
/*     */     
/*     */     protected boolean processImp() throws Exception {
/* 798 */       if (!mzm.gsp.open.main.OpenInterface.getOpenStatus(188))
/*     */       {
/* 800 */         return false;
/*     */       }
/*     */       
/* 803 */       long localid = GameServerInfoManager.getLocalId();
/*     */       
/* 805 */       CrossLadderRankBackup xCrossLadderRankBackup = xtable.Cross_ladder_rank_backups.get(Long.valueOf(localid));
/* 806 */       if (xCrossLadderRankBackup == null)
/*     */       {
/* 808 */         return false;
/*     */       }
/* 810 */       for (Map.Entry<Long, CrossLadderSeasonRankBackup> seasonEntry : xCrossLadderRankBackup.getBackups().entrySet())
/*     */       {
/* 812 */         seasonBeginTimestamp = ((Long)seasonEntry.getKey()).longValue();
/* 813 */         CrossLadderSeasonRankBackup xCrossLadderSeasonRankBackup = (CrossLadderSeasonRankBackup)seasonEntry.getValue();
/* 814 */         for (Map.Entry<Integer, CrossLadderLevelRangeRankBackup> levelEntry : xCrossLadderSeasonRankBackup.getLevel_range_rank_backups().entrySet())
/*     */         {
/* 816 */           levelRange = ((Integer)levelEntry.getKey()).intValue();
/* 817 */           CrossLadderLevelRangeRankBackup xCrossLadderLevelRangeRankBackup = (CrossLadderLevelRangeRankBackup)levelEntry.getValue();
/* 818 */           for (Map.Entry<Integer, CrossLadderRankAwardInfo> awardInfoEntry : xCrossLadderLevelRangeRankBackup.getRank_award_infos().entrySet())
/*     */           {
/* 820 */             chartType = ((Integer)awardInfoEntry.getKey()).intValue();
/* 821 */             CrossLadderRankAwardInfo xCrossLadderRankAwardInfo = (CrossLadderRankAwardInfo)awardInfoEntry.getValue();
/* 822 */             for (Map.Entry<Long, RoleCrossLadderRankAwardInfo> roleEntry : xCrossLadderRankAwardInfo.getRole_rank_award_infos().entrySet())
/*     */             {
/* 824 */               long roleid = ((Long)roleEntry.getKey()).longValue();
/* 825 */               RoleCrossLadderRankAwardInfo xRoleCrossLadderRankAwardInfo = (RoleCrossLadderRankAwardInfo)roleEntry.getValue();
/* 826 */               if ((xRoleCrossLadderRankAwardInfo != null) && (!xRoleCrossLadderRankAwardInfo.getAwarded()))
/*     */               {
/*     */ 
/*     */ 
/* 830 */                 LadderRankManager.this.sendRankAward(roleid, seasonBeginTimestamp, levelRange, chartType); }
/*     */             } } } }
/*     */       long seasonBeginTimestamp;
/*     */       int levelRange;
/*     */       int chartType;
/* 835 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ladder\main\LadderRankManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
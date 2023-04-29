/*     */ package mzm.gsp.crossfield.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.chart.main.RankInterface;
/*     */ import mzm.gsp.crossfield.confbean.SCrossFieldGradeCfg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.TaskOneByOne;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Pod;
/*     */ import xbean.RoleSingleCrossFieldInfo;
/*     */ import xbean.RoleSingleCrossFieldRankAwardInfo;
/*     */ import xbean.RoleSingleCrossFieldSeasonInfo;
/*     */ import xbean.SingleCrossFieldRank;
/*     */ import xbean.SingleCrossFieldRankAwardInfo;
/*     */ import xbean.SingleCrossFieldRankBackup;
/*     */ import xbean.SingleCrossFieldSeasonRankBackup;
/*     */ import xtable.Single_cross_field_rank_backups;
/*     */ import xtable.Single_cross_field_ranks;
/*     */ 
/*     */ public class SingleCrossFieldChartManager
/*     */ {
/*  27 */   private static SingleCrossFieldChartManager instance = new SingleCrossFieldChartManager();
/*     */   
/*     */   private volatile int rankSeason;
/*     */   
/*  31 */   static SingleCrossFieldChartManager getInstance() { return instance; }
/*     */   
/*     */   public SingleCrossFieldChartManager() {
/*  34 */     this.rankSeason = -1;
/*  35 */     this.chart = null;
/*  36 */     this.rankOneByOne = new TaskOneByOne();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   void init()
/*     */   {
/*  43 */     if (GameServerInfoManager.isRoamServer())
/*     */     {
/*  45 */       return;
/*     */     }
/*  47 */     if (this.chart == null)
/*     */     {
/*  49 */       this.chart = new SingleCrossFieldChart(39);
/*     */     }
/*     */     else
/*     */     {
/*  53 */       throw new RuntimeException("初始化跨服战场本服排行榜错误！！！");
/*     */     }
/*     */     
/*  56 */     new PInitRankData().call();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   void postInit()
/*     */   {
/*  64 */     if (GameServerInfoManager.isRoamServer())
/*     */     {
/*  66 */       return;
/*     */     }
/*     */     
/*  69 */     new PCheckAndGetRemoteRank().call();
/*     */     
/*  71 */     int currentSeason = CrossFieldManager.getCurrentSeason(DateTimeUtils.getCurrTimeInMillis());
/*  72 */     if ((currentSeason > 0) && (currentSeason > this.rankSeason))
/*     */     {
/*  74 */       new POnSeasonStart(currentSeason).call();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   void checkAndGetRemoteRank()
/*     */   {
/*  83 */     this.rankOneByOne.add(new PCheckAndGetRemoteRank());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void rank(long roleid, int season)
/*     */   {
/*  94 */     if (season <= 0)
/*     */     {
/*  96 */       return;
/*     */     }
/*  98 */     if (season > this.rankSeason)
/*     */     {
/* 100 */       this.rankOneByOne.add(new POnSeasonStart(season));
/* 101 */       this.rankOneByOne.add(new PRankRole(roleid, season));
/*     */     }
/* 103 */     else if (season == this.rankSeason)
/*     */     {
/* 105 */       this.rankOneByOne.add(new PRankRole(roleid, season));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void onSeasonStart(int season)
/*     */   {
/* 116 */     this.rankOneByOne.add(new POnSeasonStart(season));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   void saveToDB()
/*     */   {
/* 124 */     this.rankOneByOne.add(new PSaveToDB());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   int getRank(long roleid)
/*     */   {
/* 135 */     return this.chart.getRank(Long.valueOf(roleid));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private SingleCrossFieldChart chart;
/*     */   
/*     */ 
/*     */   private final TaskOneByOne rankOneByOne;
/*     */   
/*     */   List<SingleCrossFieldChartObj> getchartObjs(int from, int to)
/*     */   {
/* 147 */     return this.chart.getRankObjs(from, to);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   TaskOneByOne getRankOneByOne()
/*     */   {
/* 157 */     return this.rankOneByOne;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void checkAndSendAward(long roleid)
/*     */   {
/* 167 */     this.rankOneByOne.add(new PCheckAndSendAward(roleid));
/*     */   }
/*     */   
/*     */   class PInitRankData extends LogicProcedure
/*     */   {
/*     */     PInitRankData() {}
/*     */     
/*     */     protected boolean processImp() throws Exception
/*     */     {
/* 176 */       SingleCrossFieldRank xSingleCrossFieldRank = Single_cross_field_ranks.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 177 */       if (xSingleCrossFieldRank == null)
/*     */       {
/* 179 */         return false;
/*     */       }
/* 181 */       SingleCrossFieldChartManager.this.rankSeason = xSingleCrossFieldRank.getSeason();
/* 182 */       for (Iterator i$ = xSingleCrossFieldRank.getRank_list().iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */         
/*     */ 
/* 185 */         RoleSingleCrossFieldSeasonInfo xRoleSingleCrossFieldSeasonInfo = CrossFieldManager.getXRoleSingleCrossFieldSeasonInfo(roleid, xSingleCrossFieldRank.getSeason(), false);
/*     */         
/* 187 */         if (xRoleSingleCrossFieldSeasonInfo != null)
/*     */         {
/*     */ 
/*     */ 
/* 191 */           SingleCrossFieldChartObj chartObj = new SingleCrossFieldChartObj(roleid, xRoleSingleCrossFieldSeasonInfo.getStar_num(), xRoleSingleCrossFieldSeasonInfo.getStar_num_timestamp());
/*     */           
/*     */ 
/*     */ 
/* 195 */           SingleCrossFieldChartManager.this.chart.rank(chartObj);
/*     */         } }
/* 197 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   class POnSeasonStart
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final int season;
/*     */     
/*     */     public POnSeasonStart(int season)
/*     */     {
/* 208 */       this.season = season;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 214 */       if (this.season <= 0)
/*     */       {
/* 216 */         return false;
/*     */       }
/* 218 */       if (SingleCrossFieldChartManager.this.rankSeason >= this.season)
/*     */       {
/*     */ 
/* 221 */         return false;
/*     */       }
/* 223 */       if (this.season == 1)
/*     */       {
/* 225 */         SingleCrossFieldChartManager.this.rankSeason = 1;
/* 226 */         CrossFieldManager.logger.info(String.format("[crossfield]SingleCrossFieldChartManager.POnSeasonStart.processImp@first season do not have award|season=%d", new Object[] { Integer.valueOf(this.season) }));
/*     */         
/*     */ 
/* 229 */         return true;
/*     */       }
/* 231 */       List<SingleCrossFieldChartObj> chartObjs = SingleCrossFieldChartManager.this.chart.getAllChartObjs();
/*     */       
/* 233 */       new SingleCrossFieldChartManager.PBackUpRankDataAndAward(SingleCrossFieldChartManager.this, SingleCrossFieldChartManager.this.rankSeason, chartObjs).call();
/* 234 */       SingleCrossFieldChartManager.this.rankSeason = this.season;
/* 235 */       SingleCrossFieldChartManager.this.chart.clear();
/* 236 */       SingleCrossFieldChartManager.this.rankOneByOne.add(new LogicProcedure()
/*     */       {
/*     */         protected boolean processImp()
/*     */           throws Exception
/*     */         {
/* 241 */           SingleCrossFieldChartManager.this.chart.saveToDB();
/* 242 */           return true;
/*     */         }
/* 244 */       });
/* 245 */       CrossFieldManager.logger.info(String.format("[crossfield]SingleCrossFieldChartManager.POnSeasonStart.processImp@season start|season=%d", new Object[] { Integer.valueOf(this.season) }));
/*     */       
/* 247 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   class PBackUpRankDataAndAward
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final int season;
/*     */     private final List<SingleCrossFieldChartObj> chartObjs;
/*     */     
/*     */     public PBackUpRankDataAndAward(List<SingleCrossFieldChartObj> season)
/*     */     {
/* 259 */       this.season = season;
/* 260 */       this.chartObjs = chartObjs;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 266 */       if (this.season <= 0)
/*     */       {
/* 268 */         return false;
/*     */       }
/*     */       
/* 271 */       long localid = GameServerInfoManager.getLocalId();
/* 272 */       SingleCrossFieldRankBackup xSingleCrossFieldRankBackup = Single_cross_field_rank_backups.get(Long.valueOf(localid));
/* 273 */       if (xSingleCrossFieldRankBackup == null)
/*     */       {
/* 275 */         xSingleCrossFieldRankBackup = Pod.newSingleCrossFieldRankBackup();
/* 276 */         Single_cross_field_rank_backups.insert(Long.valueOf(localid), xSingleCrossFieldRankBackup);
/*     */       }
/* 278 */       if (xSingleCrossFieldRankBackup.getBackups().containsKey(Integer.valueOf(this.season)))
/*     */       {
/*     */ 
/* 281 */         CrossFieldManager.logger.error(String.format("[crossfield]SingleCrossFieldChartManager.PBackUpRankDataAndAward.processImp@season chart has been backuped|season=%d", new Object[] { Integer.valueOf(this.season) }));
/*     */         
/*     */ 
/* 284 */         return false;
/*     */       }
/* 286 */       SingleCrossFieldSeasonRankBackup xSingleCrossFieldSeasonRankBackup = Pod.newSingleCrossFieldSeasonRankBackup();
/* 287 */       xSingleCrossFieldRankBackup.getBackups().put(Integer.valueOf(this.season), xSingleCrossFieldSeasonRankBackup);
/* 288 */       for (SingleCrossFieldChartObj chartObj : this.chartObjs)
/*     */       {
/* 290 */         xSingleCrossFieldSeasonRankBackup.getLocal_rank_list().add(chartObj.getKey());
/*     */       }
/*     */       
/* 293 */       for (Iterator i$ = mzm.gsp.online.main.OnlineManager.getInstance().getAllRolesInWorld().iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */         
/* 295 */         if (CrossFieldManager.isCrossFieldSwitchOpenForRole(roleid))
/*     */         {
/* 297 */           SingleCrossFieldChartManager.this.rankOneByOne.add(new PSendGradeAward(roleid, this.season));
/*     */         }
/*     */       }
/*     */       
/* 301 */       SingleCrossFieldRankAwardInfo xLocalSingleCrossFieldRankAwardInfo = Pod.newSingleCrossFieldRankAwardInfo();
/* 302 */       xLocalSingleCrossFieldRankAwardInfo.setIs_data_complete(true);
/* 303 */       xSingleCrossFieldSeasonRankBackup.getRank_award_infos().put(Integer.valueOf(39), xLocalSingleCrossFieldRankAwardInfo);
/*     */       
/* 305 */       int rank = RankInterface.getAwardRank(39);
/* 306 */       if (rank >= 0)
/*     */       {
/* 308 */         for (int i = 0; (i < this.chartObjs.size()) && (i <= rank); i++)
/*     */         {
/* 310 */           long roleid = ((SingleCrossFieldChartObj)this.chartObjs.get(i)).getRoleid();
/* 311 */           RoleSingleCrossFieldRankAwardInfo xRoleSingleCrossFieldRankAwardInfo = Pod.newRoleSingleCrossFieldRankAwardInfo();
/* 312 */           xRoleSingleCrossFieldRankAwardInfo.setRank(i);
/* 313 */           xLocalSingleCrossFieldRankAwardInfo.getRole_rank_award_infos().put(Long.valueOf(roleid), xRoleSingleCrossFieldRankAwardInfo);
/*     */           
/* 315 */           if (CrossFieldManager.isCrossFieldSwitchOpenForRole(roleid))
/*     */           {
/* 317 */             SingleCrossFieldChartManager.this.rankOneByOne.add(new PSendRankAward(roleid, this.season, 39));
/*     */           }
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 325 */       if (RankInterface.getAwardRank(40) >= 0)
/*     */       {
/* 327 */         new GetRemoteRankRangeSession(CrossFieldManager.GET_REMOTE_RANK_MIN_DELAY_IN_SECOND + xdb.Xdb.random().nextInt(CrossFieldManager.GET_REMOTE_RANK_MAX_DELAY_IN_SECOND - CrossFieldManager.GET_REMOTE_RANK_MIN_DELAY_IN_SECOND), this.season);
/*     */ 
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/*     */ 
/* 334 */         SingleCrossFieldRankAwardInfo xRemoteSingleCrossFieldRankAwardInfo = Pod.newSingleCrossFieldRankAwardInfo();
/* 335 */         xRemoteSingleCrossFieldRankAwardInfo.setIs_data_complete(true);
/* 336 */         xSingleCrossFieldSeasonRankBackup.getRank_award_infos().put(Integer.valueOf(40), xRemoteSingleCrossFieldRankAwardInfo);
/*     */       }
/*     */       
/* 339 */       CrossFieldManager.logger.info(String.format("[crossfield]SingleCrossFieldChartManager.PBackUpRankDataAndAward.processImp@back up rank|season=%d", new Object[] { Integer.valueOf(this.season) }));
/*     */       
/*     */ 
/* 342 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   class PRankRole extends LogicProcedure
/*     */   {
/*     */     private final long roleid;
/*     */     private final int season;
/*     */     
/*     */     public PRankRole(long roleid, int season)
/*     */     {
/* 353 */       this.roleid = roleid;
/* 354 */       this.season = season;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 360 */       if ((this.season <= 0) || (this.season != SingleCrossFieldChartManager.this.rankSeason))
/*     */       {
/* 362 */         return false;
/*     */       }
/*     */       
/* 365 */       RoleSingleCrossFieldSeasonInfo xRoleSingleCrossFieldSeasonInfo = CrossFieldManager.getXRoleSingleCrossFieldSeasonInfo(this.roleid, this.season, true);
/*     */       
/* 367 */       if (xRoleSingleCrossFieldSeasonInfo == null)
/*     */       {
/* 369 */         return false;
/*     */       }
/* 371 */       SingleCrossFieldChartObj chartObj = new SingleCrossFieldChartObj(this.roleid, xRoleSingleCrossFieldSeasonInfo.getStar_num(), xRoleSingleCrossFieldSeasonInfo.getStar_num_timestamp());
/*     */       
/*     */ 
/*     */ 
/* 375 */       SingleCrossFieldChartManager.this.chart.rank(chartObj);
/* 376 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   class PSaveToDB extends LogicProcedure
/*     */   {
/*     */     PSaveToDB() {}
/*     */     
/*     */     protected boolean processImp() throws Exception
/*     */     {
/* 386 */       if (SingleCrossFieldChartManager.this.rankSeason <= 0)
/*     */       {
/* 388 */         return false;
/*     */       }
/* 390 */       List<SingleCrossFieldChartObj> chartObjs = SingleCrossFieldChartManager.this.chart.getAllChartObjs();
/* 391 */       long localid = GameServerInfoManager.getLocalId();
/* 392 */       SingleCrossFieldRank xSingleCrossFieldRank = Single_cross_field_ranks.get(Long.valueOf(localid));
/* 393 */       if (xSingleCrossFieldRank == null)
/*     */       {
/* 395 */         xSingleCrossFieldRank = Pod.newSingleCrossFieldRank();
/* 396 */         Single_cross_field_ranks.insert(Long.valueOf(localid), xSingleCrossFieldRank);
/*     */       }
/* 398 */       xSingleCrossFieldRank.setSeason(SingleCrossFieldChartManager.this.rankSeason);
/* 399 */       xSingleCrossFieldRank.getRank_list().clear();
/* 400 */       for (SingleCrossFieldChartObj chartObj : chartObjs)
/*     */       {
/* 402 */         xSingleCrossFieldRank.getRank_list().add(Long.valueOf(chartObj.getRoleid()));
/*     */       }
/* 404 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   class PCheckAndSendAward
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final long roleid;
/*     */     
/*     */     public PCheckAndSendAward(long roleid)
/*     */     {
/* 415 */       this.roleid = roleid;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 421 */       if (!CrossFieldManager.isCrossFieldSwitchOpenForRole(this.roleid))
/*     */       {
/* 423 */         return false;
/*     */       }
/* 425 */       int currentSeason = CrossFieldManager.getCurrentSeason(DateTimeUtils.getCurrTimeInMillis());
/* 426 */       if (currentSeason <= 1)
/*     */       {
/* 428 */         return false;
/*     */       }
/*     */       
/* 431 */       long localid = GameServerInfoManager.getLocalId();
/*     */       
/* 433 */       lock(Single_cross_field_rank_backups.getTable(), Arrays.asList(new Long[] { Long.valueOf(localid) }));
/* 434 */       String userid = mzm.gsp.role.main.RoleInterface.getUserId(this.roleid);
/*     */       
/* 436 */       lock(xtable.User.getTable(), Arrays.asList(new String[] { userid }));
/*     */       
/* 438 */       lock(xtable.Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*     */       
/* 440 */       SingleCrossFieldRankBackup xSingleCrossFieldRankBackup = Single_cross_field_rank_backups.get(Long.valueOf(localid));
/* 441 */       if (xSingleCrossFieldRankBackup != null)
/*     */       {
/* 443 */         for (int season = 1; season < currentSeason; season++)
/*     */         {
/* 445 */           SingleCrossFieldSeasonRankBackup xSingleCrossFieldSeasonRankBackup = (SingleCrossFieldSeasonRankBackup)xSingleCrossFieldRankBackup.getBackups().get(Integer.valueOf(season));
/*     */           
/* 447 */           if (xSingleCrossFieldSeasonRankBackup != null)
/*     */           {
/*     */ 
/*     */ 
/* 451 */             SingleCrossFieldRankAwardInfo xLocalSingleCrossFieldRankAwardInfo = (SingleCrossFieldRankAwardInfo)xSingleCrossFieldSeasonRankBackup.getRank_award_infos().get(Integer.valueOf(39));
/*     */             
/* 453 */             if (xLocalSingleCrossFieldRankAwardInfo != null)
/*     */             {
/* 455 */               RoleSingleCrossFieldRankAwardInfo xRoleSingleCrossFieldRankAwardInfo = (RoleSingleCrossFieldRankAwardInfo)xLocalSingleCrossFieldRankAwardInfo.getRole_rank_award_infos().get(Long.valueOf(this.roleid));
/*     */               
/* 457 */               if ((xRoleSingleCrossFieldRankAwardInfo != null) && (!xRoleSingleCrossFieldRankAwardInfo.getAwarded()))
/*     */               {
/* 459 */                 RankInterface.sendChartAward(userid, this.roleid, 39, xRoleSingleCrossFieldRankAwardInfo.getRank());
/*     */                 
/*     */ 
/* 462 */                 xRoleSingleCrossFieldRankAwardInfo.setAwarded(true);
/* 463 */                 CrossFieldManager.logger.info(String.format("[crossfield]SingleCrossFieldChartManager.PCheckAndSendAward.processImp@send rank award success|roleid=%d|season=%d|chart_type=%d|rank=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(season), Integer.valueOf(39), Integer.valueOf(xRoleSingleCrossFieldRankAwardInfo.getRank()) }));
/*     */                 
/*     */ 
/*     */ 
/* 467 */                 CrossFieldTLogManager.addRankAwardTLog(this.roleid, season, 39, xRoleSingleCrossFieldRankAwardInfo.getRank());
/*     */               }
/*     */             }
/*     */             
/*     */ 
/* 472 */             SingleCrossFieldRankAwardInfo xRemoteSingleCrossFieldRankAwardInfo = (SingleCrossFieldRankAwardInfo)xSingleCrossFieldSeasonRankBackup.getRank_award_infos().get(Integer.valueOf(40));
/*     */             
/* 474 */             if (xRemoteSingleCrossFieldRankAwardInfo != null)
/*     */             {
/* 476 */               RoleSingleCrossFieldRankAwardInfo xRoleSingleCrossFieldRankAwardInfo = (RoleSingleCrossFieldRankAwardInfo)xRemoteSingleCrossFieldRankAwardInfo.getRole_rank_award_infos().get(Long.valueOf(this.roleid));
/*     */               
/* 478 */               if ((xRoleSingleCrossFieldRankAwardInfo != null) && (!xRoleSingleCrossFieldRankAwardInfo.getAwarded()))
/*     */               {
/* 480 */                 RankInterface.sendChartAward(userid, this.roleid, 40, xRoleSingleCrossFieldRankAwardInfo.getRank());
/*     */                 
/*     */ 
/* 483 */                 xRoleSingleCrossFieldRankAwardInfo.setAwarded(true);
/* 484 */                 CrossFieldManager.logger.info(String.format("[crossfield]SingleCrossFieldChartManager.PCheckAndSendAward.processImp@send rank award success|roleid=%d|season=%d|chart_type=%d|rank=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(season), Integer.valueOf(40), Integer.valueOf(xRoleSingleCrossFieldRankAwardInfo.getRank()) }));
/*     */                 
/*     */ 
/*     */ 
/* 488 */                 CrossFieldTLogManager.addRankAwardTLog(this.roleid, season, 40, xRoleSingleCrossFieldRankAwardInfo.getRank());
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 496 */       for (int season = 1; season < currentSeason; season++)
/*     */       {
/* 498 */         RoleSingleCrossFieldInfo xRoleSingleCrossFieldInfo = xtable.Role_single_cross_field_infos.get(Long.valueOf(this.roleid));
/* 499 */         if (xRoleSingleCrossFieldInfo == null)
/*     */         {
/* 501 */           xRoleSingleCrossFieldInfo = Pod.newRoleSingleCrossFieldInfo();
/* 502 */           xRoleSingleCrossFieldInfo.setWeekly_point_sum_timestamp(DateTimeUtils.getCurrTimeInMillis());
/* 503 */           xRoleSingleCrossFieldInfo.setDaily_award_times_timestamp(DateTimeUtils.getCurrTimeInMillis());
/* 504 */           xtable.Role_single_cross_field_infos.insert(Long.valueOf(this.roleid), xRoleSingleCrossFieldInfo);
/*     */         }
/* 506 */         RoleSingleCrossFieldSeasonInfo xRoleSingleCrossFieldSeasonInfo = (RoleSingleCrossFieldSeasonInfo)xRoleSingleCrossFieldInfo.getSeason_infos().get(Integer.valueOf(season));
/*     */         
/* 508 */         if (xRoleSingleCrossFieldSeasonInfo == null)
/*     */         {
/* 510 */           xRoleSingleCrossFieldSeasonInfo = Pod.newRoleSingleCrossFieldSeasonInfo();
/* 511 */           xRoleSingleCrossFieldSeasonInfo.setStar_num_timestamp(DateTimeUtils.getCurrTimeInMillis());
/* 512 */           xRoleSingleCrossFieldInfo.getSeason_infos().put(Integer.valueOf(season), xRoleSingleCrossFieldSeasonInfo);
/*     */         }
/*     */         
/* 515 */         if (!xRoleSingleCrossFieldSeasonInfo.getAwarded())
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/* 520 */           java.util.TreeMap<Integer, SCrossFieldGradeCfg> treeMap = (java.util.TreeMap)SCrossFieldGradeCfg.getAll();
/* 521 */           java.util.Map.Entry<Integer, SCrossFieldGradeCfg> entry = treeMap.floorEntry(Integer.valueOf(xRoleSingleCrossFieldSeasonInfo.getStar_num()));
/* 522 */           if ((entry == null) || (((SCrossFieldGradeCfg)entry.getValue()).fix_award_id <= 0))
/*     */           {
/* 524 */             CrossFieldManager.logger.info(String.format("[crossfield]SingleCrossFieldChartManager.PCheckAndSendAward.processImp@no grade award|roleid=%d|season=%d|star_num=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(season), Integer.valueOf(xRoleSingleCrossFieldSeasonInfo.getStar_num()) }));
/*     */             
/*     */ 
/* 527 */             xRoleSingleCrossFieldSeasonInfo.setAwarded(true);
/*     */           }
/*     */           else
/*     */           {
/* 531 */             mzm.gsp.award.main.AwardReason awardReason = new mzm.gsp.award.main.AwardReason(mzm.gsp.tlog.LogReason.SINGLE_CROSS_FIELD_GRADE_AWARD, season);
/* 532 */             mzm.gsp.award.main.AwardModel awardModel = mzm.gsp.award.main.AwardInterface.awardFixAward(((SCrossFieldGradeCfg)entry.getValue()).fix_award_id, userid, this.roleid, false, true, awardReason);
/*     */             
/* 534 */             if (awardModel == null)
/*     */             {
/*     */ 
/* 537 */               CrossFieldManager.logger.info(String.format("[crossfield]SingleCrossFieldChartManager.PCheckAndSendAward.processImp@send grade award fail|roleid=%d|season=%d|star_num=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(season), Integer.valueOf(xRoleSingleCrossFieldSeasonInfo.getStar_num()) }));
/*     */               
/*     */ 
/* 540 */               return false;
/*     */             }
/* 542 */             xRoleSingleCrossFieldSeasonInfo.setAwarded(true);
/*     */             
/* 544 */             CrossFieldManager.logger.info(String.format("[crossfield]SingleCrossFieldChartManager.PCheckAndSendAward.processImp@send grade award success|roleid=%d|season=%d|star_num=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(season), Integer.valueOf(xRoleSingleCrossFieldSeasonInfo.getStar_num()) }));
/*     */           }
/*     */         }
/*     */       }
/* 548 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   class PCheckAndGetRemoteRank extends LogicProcedure
/*     */   {
/*     */     PCheckAndGetRemoteRank() {}
/*     */     
/*     */     protected boolean processImp() throws Exception
/*     */     {
/* 558 */       int currentSeason = CrossFieldManager.getCurrentSeason(DateTimeUtils.getCurrTimeInMillis());
/* 559 */       if (currentSeason <= 1)
/*     */       {
/* 561 */         return false;
/*     */       }
/* 563 */       long localid = GameServerInfoManager.getLocalId();
/*     */       
/* 565 */       lock(Single_cross_field_rank_backups.getTable(), Arrays.asList(new Long[] { Long.valueOf(localid) }));
/*     */       
/* 567 */       SingleCrossFieldRankBackup xSingleCrossFieldRankBackup = Single_cross_field_rank_backups.get(Long.valueOf(localid));
/* 568 */       if (xSingleCrossFieldRankBackup == null)
/*     */       {
/* 570 */         return false;
/*     */       }
/* 572 */       for (int season = 1; season < currentSeason; season++)
/*     */       {
/* 574 */         SingleCrossFieldSeasonRankBackup xSingleCrossFieldSeasonRankBackup = (SingleCrossFieldSeasonRankBackup)xSingleCrossFieldRankBackup.getBackups().get(Integer.valueOf(season));
/*     */         
/* 576 */         if (xSingleCrossFieldSeasonRankBackup != null)
/*     */         {
/*     */ 
/*     */ 
/* 580 */           SingleCrossFieldRankAwardInfo xRemoteSingleCrossFieldRankAwardInfo = (SingleCrossFieldRankAwardInfo)xSingleCrossFieldSeasonRankBackup.getRank_award_infos().get(Integer.valueOf(40));
/*     */           
/* 582 */           if ((xRemoteSingleCrossFieldRankAwardInfo == null) || (!xRemoteSingleCrossFieldRankAwardInfo.getIs_data_complete()))
/*     */           {
/*     */ 
/*     */ 
/*     */ 
/* 587 */             if (RankInterface.getAwardRank(40) >= 0)
/*     */             {
/* 589 */               new GetRemoteRankRangeSession(CrossFieldManager.GET_REMOTE_RANK_MIN_DELAY_IN_SECOND + xdb.Xdb.random().nextInt(CrossFieldManager.GET_REMOTE_RANK_MAX_DELAY_IN_SECOND - CrossFieldManager.GET_REMOTE_RANK_MIN_DELAY_IN_SECOND), season);
/*     */               
/*     */ 
/*     */ 
/* 593 */               CrossFieldManager.logger.info(String.format("[crossfield]SingleCrossFieldChartManager.PCheckAndGetRemoteRank.processImp@get romote rank from grc|season=%d", new Object[] { Integer.valueOf(season) }));
/*     */ 
/*     */             }
/*     */             else
/*     */             {
/*     */ 
/* 599 */               if (xRemoteSingleCrossFieldRankAwardInfo == null)
/*     */               {
/* 601 */                 xRemoteSingleCrossFieldRankAwardInfo = Pod.newSingleCrossFieldRankAwardInfo();
/* 602 */                 xSingleCrossFieldSeasonRankBackup.getRank_award_infos().put(Integer.valueOf(40), xRemoteSingleCrossFieldRankAwardInfo);
/*     */               }
/*     */               
/*     */ 
/* 606 */               xRemoteSingleCrossFieldRankAwardInfo.setIs_data_complete(true);
/*     */             } }
/*     */         } }
/* 609 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossfield\main\SingleCrossFieldChartManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
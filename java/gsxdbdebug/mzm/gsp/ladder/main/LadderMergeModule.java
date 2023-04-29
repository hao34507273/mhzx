/*     */ package mzm.gsp.ladder.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.NavigableMap;
/*     */ import mzm.gsp.MergeMain;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.CrossLadderLevelRangeRankBackup;
/*     */ import xbean.CrossLadderRank;
/*     */ import xbean.CrossLadderRankAwardInfo;
/*     */ import xbean.CrossLadderRankBackup;
/*     */ import xbean.CrossLadderSeasonRankBackup;
/*     */ import xtable.Cross_ladder_rank_backups;
/*     */ import xtable.Cross_ladder_ranks;
/*     */ 
/*     */ public class LadderMergeModule implements mzm.gsp.MergeModule
/*     */ {
/*     */   public List<xdb.Table> getHandleTables()
/*     */   {
/*  21 */     List<xdb.Table> tables = new java.util.ArrayList();
/*  22 */     tables.add(xtable.Role2ladder.getTable());
/*  23 */     tables.add(xtable.Ladderrank.getTable());
/*  24 */     tables.add(xtable.Ladderrankbackup.getTable());
/*  25 */     tables.add(Cross_ladder_ranks.getTable());
/*  26 */     tables.add(Cross_ladder_rank_backups.getTable());
/*  27 */     return tables;
/*     */   }
/*     */   
/*     */   public boolean handleMerge()
/*     */   {
/*  32 */     new PHandleRankData().call();
/*  33 */     new PHandleBackUpRankData().call();
/*  34 */     if (!new PMergeRank().call())
/*     */     {
/*  36 */       return false;
/*     */     }
/*  38 */     if (!new PMergeRankBackup().call())
/*     */     {
/*  40 */       return false;
/*     */     }
/*  42 */     return true;
/*     */   }
/*     */   
/*     */   class PMergeRank extends mzm.gsp.util.LogicProcedure
/*     */   {
/*     */     PMergeRank() {}
/*     */     
/*     */     protected boolean processImp() throws Exception {
/*  50 */       long mainZoneid = MergeMain.getMainZoneid();
/*  51 */       long viceZoneid = MergeMain.getViceZoneid();
/*  52 */       java.util.Set<Long> zoneids = new java.util.HashSet();
/*  53 */       zoneids.add(Long.valueOf(mainZoneid));
/*  54 */       zoneids.add(Long.valueOf(viceZoneid));
/*  55 */       lock(Cross_ladder_ranks.getTable(), zoneids);
/*  56 */       CrossLadderRank xMainCrossLadderRank = Cross_ladder_ranks.get(Long.valueOf(mainZoneid));
/*  57 */       CrossLadderRank xViceCrossLadderRank = Cross_ladder_ranks.get(Long.valueOf(viceZoneid));
/*     */       
/*  59 */       if ((xMainCrossLadderRank == null) && (xViceCrossLadderRank == null))
/*     */       {
/*  61 */         MergeMain.logger().info(String.format("[ladder]LadderMergeModule.PMergeRank.processImp@main server and vice server have no data|main_zone_id|vice_zone_id", new Object[] { Long.valueOf(mainZoneid), Long.valueOf(viceZoneid) }));
/*     */         
/*     */ 
/*     */ 
/*  65 */         return true;
/*     */       }
/*     */       
/*  68 */       if ((xMainCrossLadderRank != null) && (xViceCrossLadderRank == null))
/*     */       {
/*  70 */         MergeMain.logger().info(String.format("[ladder]LadderMergeModule.PMergeRank.processImp@vice server has no data|main_zone_id=%d|vice_zone_id=%d", new Object[] { Long.valueOf(mainZoneid), Long.valueOf(viceZoneid) }));
/*     */         
/*     */ 
/*     */ 
/*  74 */         return true;
/*     */       }
/*     */       
/*  77 */       if ((xMainCrossLadderRank == null) && (xViceCrossLadderRank != null))
/*     */       {
/*  79 */         MergeMain.logger().info(String.format("[ladder]LadderMergeModule.PMergeRank.processImp@main server has no data|main_zone_id=%d|vice_zone_id=%d", new Object[] { Long.valueOf(mainZoneid), Long.valueOf(viceZoneid) }));
/*     */         
/*     */ 
/*     */ 
/*  83 */         Cross_ladder_ranks.remove(Long.valueOf(viceZoneid));
/*  84 */         Cross_ladder_ranks.insert(Long.valueOf(mainZoneid), xViceCrossLadderRank.copy());
/*  85 */         return true;
/*     */       }
/*     */       
/*  88 */       if (xMainCrossLadderRank.getSeason_begin_timestamp() != xViceCrossLadderRank.getSeason_begin_timestamp())
/*     */       {
/*  90 */         MergeMain.logger().error(String.format("[ladder]LadderMergeModule.PMergeRank.processImp@season not match|main_zone_id=%d|vice_zone_id=%d|main_season_begin_timestamp=%d|vice_season_begin_timestamp=%d", new Object[] { Long.valueOf(mainZoneid), Long.valueOf(viceZoneid), Long.valueOf(xMainCrossLadderRank.getSeason_begin_timestamp()), Long.valueOf(xViceCrossLadderRank.getSeason_begin_timestamp()) }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*  95 */         return false;
/*     */       }
/*  97 */       for (Map.Entry<Integer, xbean.CrossLadderRankList> entry : xMainCrossLadderRank.getLevel_range_ranks().entrySet())
/*     */       {
/*  99 */         int levelRange = ((Integer)entry.getKey()).intValue();
/* 100 */         xbean.CrossLadderRankList xMainCrossLadderRankList = (xbean.CrossLadderRankList)entry.getValue();
/* 101 */         xbean.CrossLadderRankList xViceCrossLadderRankList = (xbean.CrossLadderRankList)xViceCrossLadderRank.getLevel_range_ranks().remove(Integer.valueOf(levelRange));
/*     */         
/* 103 */         if (xViceCrossLadderRankList == null)
/*     */         {
/* 105 */           MergeMain.logger().error(String.format("[ladder]LadderMergeModule.PMergeRank.processImp@vice server does not have level range data|main_zone_id=%d|vice_zone_id=%d|season_begin_timestamp=%d|level_range=%d", new Object[] { Long.valueOf(mainZoneid), Long.valueOf(viceZoneid), Long.valueOf(xMainCrossLadderRank.getSeason_begin_timestamp()), Integer.valueOf(levelRange) }));
/*     */           
/*     */ 
/*     */ 
/* 109 */           return false;
/*     */         }
/* 111 */         xMainCrossLadderRankList.getRank_list().addAll(xViceCrossLadderRankList.getRank_list());
/*     */       }
/* 113 */       if (!xViceCrossLadderRank.getLevel_range_ranks().isEmpty())
/*     */       {
/* 115 */         MergeMain.logger().error(String.format("[ladder]LadderMergeModule.PMergeRank.processImp@vice server has left level ranges|main_zone_id=%d|vice_zone_id=%d|season_begin_timestamp=%d|left_level_ranges=%s", new Object[] { Long.valueOf(mainZoneid), Long.valueOf(viceZoneid), Long.valueOf(xMainCrossLadderRank.getSeason_begin_timestamp()), xViceCrossLadderRank.getLevel_range_ranks().keySet().toString() }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 120 */         return false;
/*     */       }
/* 122 */       Cross_ladder_ranks.remove(Long.valueOf(viceZoneid));
/* 123 */       MergeMain.logger().info(String.format("[ladder]LadderMergeModule.PMergeRank.processImp@main server and vice server have data|main_zone_id=%d|vice_zone_id=%d", new Object[] { Long.valueOf(mainZoneid), Long.valueOf(viceZoneid) }));
/*     */       
/*     */ 
/*     */ 
/* 127 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   class PMergeRankBackup extends mzm.gsp.util.LogicProcedure
/*     */   {
/*     */     PMergeRankBackup() {}
/*     */     
/*     */     protected boolean processImp() throws Exception {
/* 136 */       long mainZoneid = MergeMain.getMainZoneid();
/* 137 */       long viceZoneid = MergeMain.getViceZoneid();
/* 138 */       java.util.Set<Long> zoneids = new java.util.HashSet();
/* 139 */       zoneids.add(Long.valueOf(mainZoneid));
/* 140 */       zoneids.add(Long.valueOf(viceZoneid));
/* 141 */       lock(Cross_ladder_rank_backups.getTable(), zoneids);
/* 142 */       CrossLadderRankBackup xMainCrossLadderRankBackup = Cross_ladder_rank_backups.get(Long.valueOf(mainZoneid));
/* 143 */       CrossLadderRankBackup xViceCrossLadderRankBackup = Cross_ladder_rank_backups.get(Long.valueOf(viceZoneid));
/*     */       
/* 145 */       if ((xMainCrossLadderRankBackup == null) && (xViceCrossLadderRankBackup == null))
/*     */       {
/* 147 */         MergeMain.logger().info(String.format("[ladder]LadderMergeModule.PMergeRankBackup.processImp@main server and vice server have no data|main_zone_id=%d|vice_zone_id=%d", new Object[] { Long.valueOf(mainZoneid), Long.valueOf(viceZoneid) }));
/*     */         
/*     */ 
/*     */ 
/* 151 */         return true;
/*     */       }
/*     */       
/* 154 */       if ((xMainCrossLadderRankBackup != null) && (xViceCrossLadderRankBackup == null))
/*     */       {
/* 156 */         MergeMain.logger().info(String.format("[ladder]LadderMergeModule.PMergeRankBackup.processImp@vice server has no data|main_zone_id=%d|vice_zone_id=%d", new Object[] { Long.valueOf(mainZoneid), Long.valueOf(viceZoneid) }));
/*     */         
/*     */ 
/*     */ 
/* 160 */         return true;
/*     */       }
/*     */       
/* 163 */       xMainCrossLadderRankBackup.setInit_season_begin_timestamp(Math.min(xMainCrossLadderRankBackup.getInit_season_begin_timestamp(), xViceCrossLadderRankBackup.getInit_season_begin_timestamp()));
/*     */       
/*     */ 
/* 166 */       if ((xMainCrossLadderRankBackup == null) && (xViceCrossLadderRankBackup != null))
/*     */       {
/* 168 */         Cross_ladder_rank_backups.remove(Long.valueOf(viceZoneid));
/* 169 */         Cross_ladder_rank_backups.insert(Long.valueOf(mainZoneid), xViceCrossLadderRankBackup.copy());
/* 170 */         MergeMain.logger().info(String.format("[ladder]LadderMergeModule.PMergeRankBackup.processImp@main server has no data|main_zone_id=%d|vice_zone_id=%d", new Object[] { Long.valueOf(mainZoneid), Long.valueOf(viceZoneid) }));
/*     */         
/*     */ 
/*     */ 
/* 174 */         return true;
/*     */       }
/*     */       
/* 177 */       for (Map.Entry<Long, CrossLadderSeasonRankBackup> seasonEntry : xMainCrossLadderRankBackup.getBackups().entrySet())
/*     */       {
/* 179 */         long seasonBeginTimestamp = ((Long)seasonEntry.getKey()).longValue();
/* 180 */         CrossLadderSeasonRankBackup xMainCrossLadderSeasonRankBackup = (CrossLadderSeasonRankBackup)seasonEntry.getValue();
/* 181 */         CrossLadderSeasonRankBackup xViceCrossLadderSeasonRankBackup = (CrossLadderSeasonRankBackup)xViceCrossLadderRankBackup.getBackups().remove(Long.valueOf(seasonBeginTimestamp));
/*     */         
/* 183 */         if (xViceCrossLadderSeasonRankBackup == null)
/*     */         {
/* 185 */           MergeMain.logger().info(String.format("[ladder]LadderMergeModule.PMergeRankBackup.processImp@vice server has no season data|main_zone_id=%d|vice_zone_id=%d|season_begin_timestamp=%d", new Object[] { Long.valueOf(mainZoneid), Long.valueOf(viceZoneid), Long.valueOf(seasonBeginTimestamp) }));
/*     */ 
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/*     */ 
/* 192 */           for (Map.Entry<Integer, CrossLadderLevelRangeRankBackup> levelEntry : xMainCrossLadderSeasonRankBackup.getLevel_range_rank_backups().entrySet())
/*     */           {
/* 194 */             int levelRange = ((Integer)levelEntry.getKey()).intValue();
/* 195 */             CrossLadderLevelRangeRankBackup xMainCrossLadderLevelRangeRankBackup = (CrossLadderLevelRangeRankBackup)levelEntry.getValue();
/* 196 */             CrossLadderLevelRangeRankBackup xViceCrossLadderLevelRangeRankBackup = (CrossLadderLevelRangeRankBackup)xViceCrossLadderSeasonRankBackup.getLevel_range_rank_backups().remove(Integer.valueOf(levelRange));
/*     */             
/* 198 */             if (xViceCrossLadderLevelRangeRankBackup == null)
/*     */             {
/* 200 */               MergeMain.logger().error(String.format("[ladder]LadderMergeModule.PMergeRankBackup.processImp@vice server has no level range data|main_zone_id=%d|vice_zone_id=%d|season_begin_timestamp=%d|level_range=%d", new Object[] { Long.valueOf(mainZoneid), Long.valueOf(viceZoneid), Long.valueOf(seasonBeginTimestamp), Integer.valueOf(levelRange) }));
/*     */               
/*     */ 
/*     */ 
/* 204 */               return false;
/*     */             }
/* 206 */             xMainCrossLadderLevelRangeRankBackup.getLocal_rank_list().addAll(xViceCrossLadderLevelRangeRankBackup.getLocal_rank_list());
/*     */             
/* 208 */             for (Map.Entry<Integer, CrossLadderRankAwardInfo> awardEntry : xMainCrossLadderLevelRangeRankBackup.getRank_award_infos().entrySet())
/*     */             {
/* 210 */               int chartType = ((Integer)awardEntry.getKey()).intValue();
/* 211 */               CrossLadderRankAwardInfo xMainCrossLadderRankAwardInfo = (CrossLadderRankAwardInfo)awardEntry.getValue();
/* 212 */               CrossLadderRankAwardInfo xViceCrossLadderRankAwardInfo = (CrossLadderRankAwardInfo)xViceCrossLadderLevelRangeRankBackup.getRank_award_infos().remove(Integer.valueOf(chartType));
/*     */               
/* 214 */               if (xViceCrossLadderRankAwardInfo == null)
/*     */               {
/* 216 */                 MergeMain.logger().error(String.format("[ladder]LadderMergeModule.PMergeRankBackup.processImp@vice server has no level range award data|main_zone_id=%d|vice_zone_id=%d|season_begin_timestamp=%d|level_range=%d|chart_type=%d", new Object[] { Long.valueOf(mainZoneid), Long.valueOf(viceZoneid), Long.valueOf(seasonBeginTimestamp), Integer.valueOf(levelRange), Integer.valueOf(chartType) }));
/*     */                 
/*     */ 
/*     */ 
/* 220 */                 return false;
/*     */               }
/* 222 */               mzm.gsp.ladder.confbean.SLadderRankCfg cfg = mzm.gsp.ladder.confbean.SLadderRankCfg.get(chartType);
/* 223 */               if (cfg == null)
/*     */               {
/* 225 */                 MergeMain.logger().error(String.format("[ladder]LadderMergeModule.PMergeRankBackup.processImp@no ladder rank cfg|main_zone_id=%d|vice_zone_id=%d|season_begin_timestamp=%d|level_range=%d|chart_type=%d", new Object[] { Long.valueOf(mainZoneid), Long.valueOf(viceZoneid), Long.valueOf(seasonBeginTimestamp), Integer.valueOf(levelRange), Integer.valueOf(chartType) }));
/*     */                 
/*     */ 
/*     */ 
/* 229 */                 return false;
/*     */               }
/* 231 */               if (cfg.isLocal)
/*     */               {
/* 233 */                 if ((!xMainCrossLadderRankAwardInfo.getIs_data_complete()) || (!xViceCrossLadderRankAwardInfo.getIs_data_complete()))
/*     */                 {
/*     */ 
/* 236 */                   MergeMain.logger().error(String.format("[ladder]LadderMergeModule.PMergeRankBackup.processImp@local rank award info error|main_zone_id=%d|vice_zone_id=%d|season_begin_timestamp=%d|level_range=%d|chart_type=%d", new Object[] { Long.valueOf(mainZoneid), Long.valueOf(viceZoneid), Long.valueOf(seasonBeginTimestamp), Integer.valueOf(levelRange), Integer.valueOf(chartType) }));
/*     */                   
/*     */ 
/*     */ 
/* 240 */                   return false;
/*     */                 }
/*     */                 
/*     */ 
/*     */               }
/* 245 */               else if (!xViceCrossLadderRankAwardInfo.getIs_data_complete())
/*     */               {
/* 247 */                 xMainCrossLadderRankAwardInfo.setIs_data_complete(false);
/*     */               }
/*     */               
/* 250 */               for (Map.Entry<Long, xbean.RoleCrossLadderRankAwardInfo> roleEntry : xViceCrossLadderRankAwardInfo.getRole_rank_award_infos().entrySet())
/*     */               {
/* 252 */                 xMainCrossLadderRankAwardInfo.getRole_rank_award_infos().put(roleEntry.getKey(), ((xbean.RoleCrossLadderRankAwardInfo)roleEntry.getValue()).copy());
/*     */               }
/*     */               
/* 255 */               MergeMain.logger().info(String.format("[ladder]LadderMergeModule.PMergeRankBackup.processImp@season rank backup merged|main_zone_id=%d|vice_zone_id=%d|season_begin_timestamp=%d|level_range=%d|chart_type=%d", new Object[] { Long.valueOf(mainZoneid), Long.valueOf(viceZoneid), Long.valueOf(seasonBeginTimestamp), Integer.valueOf(levelRange), Integer.valueOf(chartType) }));
/*     */             }
/*     */             
/*     */ 
/*     */ 
/* 260 */             if (!xViceCrossLadderLevelRangeRankBackup.getRank_award_infos().isEmpty())
/*     */             {
/* 262 */               MergeMain.logger().error(String.format("[ladder]LadderMergeModule.PMergeRankBackup.processImp@vice server has left chart type|main_zone_id=%d|vice_zone_id=%d|season_begin_timestamp=%d|level_range=%d|chart_types=%s", new Object[] { Long.valueOf(mainZoneid), Long.valueOf(viceZoneid), Long.valueOf(seasonBeginTimestamp), Integer.valueOf(levelRange), xViceCrossLadderLevelRangeRankBackup.getRank_award_infos().keySet().toString() }));
/*     */               
/*     */ 
/*     */ 
/*     */ 
/* 267 */               return false;
/*     */             }
/*     */           }
/* 270 */           if (!xViceCrossLadderSeasonRankBackup.getLevel_range_rank_backups().isEmpty())
/*     */           {
/* 272 */             MergeMain.logger().error(String.format("[ladder]LadderMergeModule.PMergeRankBackup.processImp@vice server has left level range|main_zone_id=%d|vice_zone_id=%d|season_begin_timestamp=%d|level_ranges=%s", new Object[] { Long.valueOf(mainZoneid), Long.valueOf(viceZoneid), Long.valueOf(seasonBeginTimestamp), xViceCrossLadderSeasonRankBackup.getLevel_range_rank_backups().keySet().toString() }));
/*     */             
/*     */ 
/*     */ 
/*     */ 
/* 277 */             return false;
/*     */           }
/*     */         }
/*     */       }
/* 281 */       for (Map.Entry<Long, CrossLadderSeasonRankBackup> entry : xViceCrossLadderRankBackup.getBackups().entrySet())
/*     */       {
/* 283 */         long seasonBeginTimestamp = ((Long)entry.getKey()).longValue();
/* 284 */         CrossLadderSeasonRankBackup xViceCrossLadderSeasonRankBackup = (CrossLadderSeasonRankBackup)entry.getValue();
/* 285 */         xMainCrossLadderRankBackup.getBackups().put(Long.valueOf(seasonBeginTimestamp), xViceCrossLadderSeasonRankBackup.copy());
/* 286 */         MergeMain.logger().info(String.format("[ladder]LadderMergeModule.PMergeRankBackup.processImp@main server has no season data|main_zone_id=%d|vice_zone_id=%d|season_begin_timestamp=%d", new Object[] { Long.valueOf(mainZoneid), Long.valueOf(viceZoneid), Long.valueOf(seasonBeginTimestamp) }));
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 291 */       Cross_ladder_rank_backups.remove(Long.valueOf(viceZoneid));
/* 292 */       MergeMain.logger().info(String.format("[ladder]LadderMergeModule.PMergeRankBackup.processImp@main server and vice server have data|main_zone_id=%d|vice_zone_id=%d", new Object[] { Long.valueOf(mainZoneid), Long.valueOf(viceZoneid) }));
/*     */       
/*     */ 
/*     */ 
/* 296 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ladder\main\LadderMergeModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
/*     */ package mzm.gsp.crossfield.main;
/*     */ 
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.MergeMain;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.RoleSingleCrossFieldRankAwardInfo;
/*     */ import xbean.SingleCrossFieldRank;
/*     */ import xbean.SingleCrossFieldRankAwardInfo;
/*     */ import xbean.SingleCrossFieldRankBackup;
/*     */ import xbean.SingleCrossFieldSeasonRankBackup;
/*     */ import xdb.Table;
/*     */ import xtable.Single_cross_field_rank_backups;
/*     */ import xtable.Single_cross_field_ranks;
/*     */ 
/*     */ public class CrossFieldMergeModule implements mzm.gsp.MergeModule
/*     */ {
/*     */   public List<Table> getHandleTables()
/*     */   {
/*  24 */     return java.util.Arrays.asList(new Table[] { xtable.Role_single_cross_field_infos.getTable(), Single_cross_field_ranks.getTable(), Single_cross_field_rank_backups.getTable() });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean handleMerge()
/*     */   {
/*  32 */     if (!new PMergeRank().call())
/*     */     {
/*  34 */       return false;
/*     */     }
/*  36 */     if (!new PMergeRankBackup().call())
/*     */     {
/*  38 */       return false;
/*     */     }
/*  40 */     return true;
/*     */   }
/*     */   
/*     */   class PMergeRank extends LogicProcedure
/*     */   {
/*     */     PMergeRank() {}
/*     */     
/*     */     protected boolean processImp() throws Exception
/*     */     {
/*  49 */       long mainZoneid = MergeMain.getMainZoneid();
/*  50 */       long viceZoneid = MergeMain.getViceZoneid();
/*  51 */       Set<Long> zoneids = new HashSet();
/*  52 */       zoneids.add(Long.valueOf(mainZoneid));
/*  53 */       zoneids.add(Long.valueOf(viceZoneid));
/*  54 */       lock(Single_cross_field_ranks.getTable(), zoneids);
/*  55 */       SingleCrossFieldRank xMainSingleCrossFieldRank = Single_cross_field_ranks.get(Long.valueOf(mainZoneid));
/*  56 */       SingleCrossFieldRank xViceSingleCrossFieldRank = Single_cross_field_ranks.get(Long.valueOf(viceZoneid));
/*     */       
/*  58 */       if ((xMainSingleCrossFieldRank == null) && (xViceSingleCrossFieldRank == null))
/*     */       {
/*  60 */         MergeMain.logger().info(String.format("[crossfield]CrossFieldMergeModule.PMergeRank.processImp@main server and vice server have no data|main_zone_id|vice_zone_id", new Object[] { Long.valueOf(mainZoneid), Long.valueOf(viceZoneid) }));
/*     */         
/*     */ 
/*     */ 
/*  64 */         return true;
/*     */       }
/*     */       
/*  67 */       if ((xMainSingleCrossFieldRank != null) && (xViceSingleCrossFieldRank == null))
/*     */       {
/*  69 */         MergeMain.logger().info(String.format("[crossfield]CrossFieldMergeModule.PMergeRank.processImp@vice server has no data|main_zone_id=%d|vice_zone_id=%d", new Object[] { Long.valueOf(mainZoneid), Long.valueOf(viceZoneid) }));
/*     */         
/*     */ 
/*     */ 
/*  73 */         return true;
/*     */       }
/*     */       
/*  76 */       if ((xMainSingleCrossFieldRank == null) && (xViceSingleCrossFieldRank != null))
/*     */       {
/*  78 */         MergeMain.logger().info(String.format("[crossfield]CrossFieldMergeModule.PMergeRank.processImp@main server has no data|main_zone_id=%d|vice_zone_id=%d", new Object[] { Long.valueOf(mainZoneid), Long.valueOf(viceZoneid) }));
/*     */         
/*     */ 
/*     */ 
/*  82 */         Single_cross_field_ranks.remove(Long.valueOf(viceZoneid));
/*  83 */         Single_cross_field_ranks.insert(Long.valueOf(mainZoneid), xViceSingleCrossFieldRank.copy());
/*  84 */         return true;
/*     */       }
/*     */       
/*  87 */       if (xMainSingleCrossFieldRank.getSeason() != xViceSingleCrossFieldRank.getSeason())
/*     */       {
/*  89 */         MergeMain.logger().error(String.format("[crossfield]CrossFieldMergeModule.PMergeRank.processImp@season not match|main_zone_id=%d|vice_zone_id=%d|main_season=%d|vice_season=%d", new Object[] { Long.valueOf(mainZoneid), Long.valueOf(viceZoneid), Integer.valueOf(xMainSingleCrossFieldRank.getSeason()), Integer.valueOf(xViceSingleCrossFieldRank.getSeason()) }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*  94 */         return false;
/*     */       }
/*  96 */       xMainSingleCrossFieldRank.getRank_list().addAll(xViceSingleCrossFieldRank.getRank_list());
/*  97 */       Single_cross_field_ranks.remove(Long.valueOf(viceZoneid));
/*  98 */       MergeMain.logger().info(String.format("[crossfield]CrossFieldMergeModule.PMergeRank.processImp@main server and vice server have data|main_zone_id=%d|vice_zone_id=%d", new Object[] { Long.valueOf(mainZoneid), Long.valueOf(viceZoneid) }));
/*     */       
/*     */ 
/*     */ 
/* 102 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   class PMergeRankBackup extends LogicProcedure
/*     */   {
/*     */     PMergeRankBackup() {}
/*     */     
/*     */     protected boolean processImp() throws Exception
/*     */     {
/* 112 */       long mainZoneid = MergeMain.getMainZoneid();
/* 113 */       long viceZoneid = MergeMain.getViceZoneid();
/* 114 */       Set<Long> zoneids = new HashSet();
/* 115 */       zoneids.add(Long.valueOf(mainZoneid));
/* 116 */       zoneids.add(Long.valueOf(viceZoneid));
/* 117 */       lock(Single_cross_field_rank_backups.getTable(), zoneids);
/* 118 */       SingleCrossFieldRankBackup xMainSingleCrossFieldRankBackup = Single_cross_field_rank_backups.get(Long.valueOf(mainZoneid));
/* 119 */       SingleCrossFieldRankBackup xViceSingleCrossFieldRankBackup = Single_cross_field_rank_backups.get(Long.valueOf(viceZoneid));
/*     */       
/* 121 */       if ((xMainSingleCrossFieldRankBackup == null) && (xViceSingleCrossFieldRankBackup == null))
/*     */       {
/* 123 */         MergeMain.logger().info(String.format("[crossfield]CrossFieldMergeModule.PMergeRankBackup.processImp@main server and vice server have no data|main_zone_id=%d|vice_zone_id=%d", new Object[] { Long.valueOf(mainZoneid), Long.valueOf(viceZoneid) }));
/*     */         
/*     */ 
/*     */ 
/* 127 */         return true;
/*     */       }
/*     */       
/* 130 */       if ((xMainSingleCrossFieldRankBackup != null) && (xViceSingleCrossFieldRankBackup == null))
/*     */       {
/* 132 */         MergeMain.logger().info(String.format("[crossfield]CrossFieldMergeModule.PMergeRankBackup.processImp@vice server has no data|main_zone_id=%d|vice_zone_id=%d", new Object[] { Long.valueOf(mainZoneid), Long.valueOf(viceZoneid) }));
/*     */         
/*     */ 
/*     */ 
/* 136 */         return true;
/*     */       }
/*     */       
/* 139 */       if ((xMainSingleCrossFieldRankBackup == null) && (xViceSingleCrossFieldRankBackup != null))
/*     */       {
/* 141 */         Single_cross_field_rank_backups.remove(Long.valueOf(viceZoneid));
/* 142 */         Single_cross_field_rank_backups.insert(Long.valueOf(mainZoneid), xViceSingleCrossFieldRankBackup.copy());
/* 143 */         MergeMain.logger().info(String.format("[crossfield]CrossFieldMergeModule.PMergeRankBackup.processImp@main server has no data|main_zone_id=%d|vice_zone_id=%d", new Object[] { Long.valueOf(mainZoneid), Long.valueOf(viceZoneid) }));
/*     */         
/*     */ 
/*     */ 
/* 147 */         return true;
/*     */       }
/*     */       
/* 150 */       for (Map.Entry<Integer, SingleCrossFieldSeasonRankBackup> entry : xMainSingleCrossFieldRankBackup.getBackups().entrySet())
/*     */       {
/* 152 */         int season = ((Integer)entry.getKey()).intValue();
/* 153 */         SingleCrossFieldSeasonRankBackup xMainSingleCrossFieldSeasonRankBackup = (SingleCrossFieldSeasonRankBackup)entry.getValue();
/* 154 */         SingleCrossFieldSeasonRankBackup xViceSingleCrossFieldSeasonRankBackup = (SingleCrossFieldSeasonRankBackup)xViceSingleCrossFieldRankBackup.getBackups().remove(Integer.valueOf(season));
/*     */         
/* 156 */         if (xViceSingleCrossFieldSeasonRankBackup == null)
/*     */         {
/* 158 */           MergeMain.logger().info(String.format("[crossfield]CrossFieldMergeModule.PMergeRankBackup.processImp@vice server has no season data|main_zone_id=%d|vice_zone_id=%d|season=%d", new Object[] { Long.valueOf(mainZoneid), Long.valueOf(viceZoneid), Integer.valueOf(season) }));
/*     */ 
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/*     */ 
/* 165 */           xMainSingleCrossFieldSeasonRankBackup.getLocal_rank_list().addAll(xViceSingleCrossFieldSeasonRankBackup.getLocal_rank_list());
/*     */           
/*     */ 
/* 168 */           SingleCrossFieldRankAwardInfo xMainLocalSingleCrossFieldRankAwardInfo = (SingleCrossFieldRankAwardInfo)xMainSingleCrossFieldSeasonRankBackup.getRank_award_infos().get(Integer.valueOf(39));
/*     */           
/* 170 */           SingleCrossFieldRankAwardInfo xViceLocalSingleCrossFieldRankAwardInfo = (SingleCrossFieldRankAwardInfo)xViceSingleCrossFieldSeasonRankBackup.getRank_award_infos().get(Integer.valueOf(39));
/*     */           
/* 172 */           if ((xMainLocalSingleCrossFieldRankAwardInfo == null) || (xViceLocalSingleCrossFieldRankAwardInfo == null))
/*     */           {
/* 174 */             MergeMain.logger().error(String.format("[crossfield]CrossFieldMergeModule.PMergeRankBackup.processImp@local rank award info null|main_zone_id=%d|vice_zone_id=%d|season=%d", new Object[] { Long.valueOf(mainZoneid), Long.valueOf(viceZoneid), Integer.valueOf(season) }));
/*     */             
/*     */ 
/*     */ 
/* 178 */             return false;
/*     */           }
/* 180 */           if ((!xMainLocalSingleCrossFieldRankAwardInfo.getIs_data_complete()) || (!xViceLocalSingleCrossFieldRankAwardInfo.getIs_data_complete()))
/*     */           {
/*     */ 
/* 183 */             MergeMain.logger().error(String.format("[crossfield]CrossFieldMergeModule.PMergeRankBackup.processImp@local rank award info error|main_zone_id=%d|vice_zone_id=%d|season=%d", new Object[] { Long.valueOf(mainZoneid), Long.valueOf(viceZoneid), Integer.valueOf(season) }));
/*     */             
/*     */ 
/*     */ 
/* 187 */             return false;
/*     */           }
/*     */           
/* 190 */           for (Map.Entry<Long, RoleSingleCrossFieldRankAwardInfo> roleEntry : xViceLocalSingleCrossFieldRankAwardInfo.getRole_rank_award_infos().entrySet())
/*     */           {
/* 192 */             xMainLocalSingleCrossFieldRankAwardInfo.getRole_rank_award_infos().put(roleEntry.getKey(), ((RoleSingleCrossFieldRankAwardInfo)roleEntry.getValue()).copy());
/*     */           }
/*     */           
/*     */ 
/* 196 */           SingleCrossFieldRankAwardInfo xMainRemoteSingleCrossFieldRankAwardInfo = (SingleCrossFieldRankAwardInfo)xMainSingleCrossFieldSeasonRankBackup.getRank_award_infos().get(Integer.valueOf(40));
/*     */           
/* 198 */           SingleCrossFieldRankAwardInfo xViceRemoteSingleCrossFieldRankAwardInfo = (SingleCrossFieldRankAwardInfo)xViceSingleCrossFieldSeasonRankBackup.getRank_award_infos().get(Integer.valueOf(40));
/*     */           
/* 200 */           if ((xMainRemoteSingleCrossFieldRankAwardInfo == null) && (xViceRemoteSingleCrossFieldRankAwardInfo == null))
/*     */           {
/* 202 */             MergeMain.logger().info(String.format("[crossfield]CrossFieldMergeModule.PMergeRankBackup.processImp@main and vice remote rank award info null|main_zone_id=%d|vice_zone_id=%d|season=%d", new Object[] { Long.valueOf(mainZoneid), Long.valueOf(viceZoneid), Integer.valueOf(season) }));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           }
/* 208 */           else if ((xMainRemoteSingleCrossFieldRankAwardInfo != null) && (xViceRemoteSingleCrossFieldRankAwardInfo == null))
/*     */           {
/* 210 */             xMainRemoteSingleCrossFieldRankAwardInfo.setIs_data_complete(false);
/* 211 */             MergeMain.logger().info(String.format("[crossfield]CrossFieldMergeModule.PMergeRankBackup.processImp@vice remote rank award info null|main_zone_id=%d|vice_zone_id=%d|season=%d", new Object[] { Long.valueOf(mainZoneid), Long.valueOf(viceZoneid), Integer.valueOf(season) }));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           }
/* 217 */           else if ((xMainRemoteSingleCrossFieldRankAwardInfo == null) && (xViceRemoteSingleCrossFieldRankAwardInfo != null))
/*     */           {
/* 219 */             xViceRemoteSingleCrossFieldRankAwardInfo.setIs_data_complete(false);
/* 220 */             xMainSingleCrossFieldSeasonRankBackup.getRank_award_infos().put(Integer.valueOf(40), xViceRemoteSingleCrossFieldRankAwardInfo.copy());
/*     */             
/*     */ 
/* 223 */             MergeMain.logger().info(String.format("[crossfield]CrossFieldMergeModule.PMergeRankBackup.processImp@main remote rank award info null|main_zone_id=%d|vice_zone_id=%d|season=%d", new Object[] { Long.valueOf(mainZoneid), Long.valueOf(viceZoneid), Integer.valueOf(season) }));
/*     */ 
/*     */           }
/*     */           else
/*     */           {
/*     */ 
/* 229 */             if (!xViceRemoteSingleCrossFieldRankAwardInfo.getIs_data_complete())
/*     */             {
/* 231 */               xMainRemoteSingleCrossFieldRankAwardInfo.setIs_data_complete(false);
/*     */             }
/* 233 */             for (Map.Entry<Long, RoleSingleCrossFieldRankAwardInfo> roleEntry : xViceRemoteSingleCrossFieldRankAwardInfo.getRole_rank_award_infos().entrySet())
/*     */             {
/* 235 */               xMainLocalSingleCrossFieldRankAwardInfo.getRole_rank_award_infos().put(roleEntry.getKey(), ((RoleSingleCrossFieldRankAwardInfo)roleEntry.getValue()).copy());
/*     */             }
/*     */             
/* 238 */             MergeMain.logger().info(String.format("[crossfield]CrossFieldMergeModule.PMergeRankBackup.processImp@season rank backup merged|main_zone_id=%d|vice_zone_id=%d|season=%d", new Object[] { Long.valueOf(mainZoneid), Long.valueOf(viceZoneid), Integer.valueOf(season) }));
/*     */           }
/*     */         }
/*     */       }
/*     */       
/* 243 */       for (Map.Entry<Integer, SingleCrossFieldSeasonRankBackup> entry : xViceSingleCrossFieldRankBackup.getBackups().entrySet())
/*     */       {
/* 245 */         int season = ((Integer)entry.getKey()).intValue();
/* 246 */         SingleCrossFieldSeasonRankBackup xViceSingleCrossFieldSeasonRankBackup = (SingleCrossFieldSeasonRankBackup)entry.getValue();
/* 247 */         xMainSingleCrossFieldRankBackup.getBackups().put(Integer.valueOf(season), xViceSingleCrossFieldSeasonRankBackup.copy());
/* 248 */         MergeMain.logger().info(String.format("[crossfield]CrossFieldMergeModule.PMergeRankBackup.processImp@main server has no season data|main_zone_id=%d|vice_zone_id=%d|season=%d", new Object[] { Long.valueOf(mainZoneid), Long.valueOf(viceZoneid), Integer.valueOf(season) }));
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 253 */       Single_cross_field_rank_backups.remove(Long.valueOf(viceZoneid));
/* 254 */       MergeMain.logger().info(String.format("[crossfield]CrossFieldMergeModule.PMergeRankBackup.processImp@main server and vice server have data|main_zone_id=%d|vice_zone_id=%d", new Object[] { Long.valueOf(mainZoneid), Long.valueOf(viceZoneid) }));
/*     */       
/*     */ 
/*     */ 
/* 258 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossfield\main\CrossFieldMergeModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
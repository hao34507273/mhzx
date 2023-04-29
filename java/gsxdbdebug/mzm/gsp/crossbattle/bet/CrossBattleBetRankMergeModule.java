/*     */ package mzm.gsp.crossbattle.bet;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashSet;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.MergeMain;
/*     */ import mzm.gsp.MergeModule;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.CrossBattleBetRankAwardInfo;
/*     */ import xbean.CrossBattleBetRankBackup;
/*     */ import xbean.CrossBattleBetSeasonRankBackup;
/*     */ import xbean.RoleCrossBattleBetRankAwardInfo;
/*     */ import xdb.Table;
/*     */ import xtable.Cross_battle_bet_rank_backups;
/*     */ import xtable.Role_cross_battle_bet_season_profot_infos;
/*     */ 
/*     */ public class CrossBattleBetRankMergeModule implements MergeModule
/*     */ {
/*     */   public java.util.List<Table> getHandleTables()
/*     */   {
/*  24 */     return Arrays.asList(new Table[] { Role_cross_battle_bet_season_profot_infos.getTable(), Cross_battle_bet_rank_backups.getTable() });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean handleMerge()
/*     */   {
/*  31 */     if (!new PMergeRankBackup().call())
/*     */     {
/*  33 */       return false;
/*     */     }
/*  35 */     return true;
/*     */   }
/*     */   
/*     */   class PMergeRankBackup extends LogicProcedure
/*     */   {
/*     */     PMergeRankBackup() {}
/*     */     
/*     */     protected boolean processImp() throws Exception
/*     */     {
/*  44 */       long mainZoneid = MergeMain.getMainZoneid();
/*  45 */       long viceZoneid = MergeMain.getViceZoneid();
/*  46 */       Set<Long> zoneids = new HashSet();
/*  47 */       zoneids.add(Long.valueOf(mainZoneid));
/*  48 */       zoneids.add(Long.valueOf(viceZoneid));
/*  49 */       lock(Cross_battle_bet_rank_backups.getTable(), zoneids);
/*  50 */       CrossBattleBetRankBackup xMainCrossBattleBetRankBackup = Cross_battle_bet_rank_backups.get(Long.valueOf(mainZoneid));
/*  51 */       CrossBattleBetRankBackup xViceCrossBattleBetRankBackup = Cross_battle_bet_rank_backups.get(Long.valueOf(viceZoneid));
/*     */       
/*  53 */       if ((xMainCrossBattleBetRankBackup == null) && (xViceCrossBattleBetRankBackup == null))
/*     */       {
/*  55 */         MergeMain.logger().info(String.format("[crossbattle]CrossBattleBetRankMergeModule.PMergeRankBackup.processImp@main server and vice server have no data|main_zone_id=%d|vice_zone_id=%d", new Object[] { Long.valueOf(mainZoneid), Long.valueOf(viceZoneid) }));
/*     */         
/*     */ 
/*     */ 
/*  59 */         return true;
/*     */       }
/*     */       
/*  62 */       if ((xMainCrossBattleBetRankBackup != null) && (xViceCrossBattleBetRankBackup == null))
/*     */       {
/*  64 */         MergeMain.logger().info(String.format("[crossbattle]CrossBattleBetRankMergeModule.PMergeRankBackup.processImp@vice server has no data|main_zone_id=%d|vice_zone_id=%d", new Object[] { Long.valueOf(mainZoneid), Long.valueOf(viceZoneid) }));
/*     */         
/*     */ 
/*     */ 
/*  68 */         return true;
/*     */       }
/*     */       
/*  71 */       if ((xMainCrossBattleBetRankBackup == null) && (xViceCrossBattleBetRankBackup != null))
/*     */       {
/*  73 */         Cross_battle_bet_rank_backups.remove(Long.valueOf(viceZoneid));
/*  74 */         Cross_battle_bet_rank_backups.insert(Long.valueOf(mainZoneid), xViceCrossBattleBetRankBackup.copy());
/*  75 */         MergeMain.logger().info(String.format("[crossbattle]CrossBattleBetRankMergeModule.PMergeRankBackup.processImp@main server has no data|main_zone_id=%d|vice_zone_id=%d", new Object[] { Long.valueOf(mainZoneid), Long.valueOf(viceZoneid) }));
/*     */         
/*     */ 
/*     */ 
/*  79 */         return true;
/*     */       }
/*     */       
/*  82 */       for (Map.Entry<Integer, CrossBattleBetSeasonRankBackup> entry : xMainCrossBattleBetRankBackup.getBackups().entrySet())
/*     */       {
/*  84 */         int activityCfgid = ((Integer)entry.getKey()).intValue();
/*  85 */         CrossBattleBetSeasonRankBackup xMainCrossBattleBetSeasonRankBackup = (CrossBattleBetSeasonRankBackup)entry.getValue();
/*  86 */         CrossBattleBetSeasonRankBackup xViceCrossBattleBetSeasonRankBackup = (CrossBattleBetSeasonRankBackup)xViceCrossBattleBetRankBackup.getBackups().remove(Integer.valueOf(activityCfgid));
/*     */         
/*  88 */         if (xViceCrossBattleBetSeasonRankBackup == null)
/*     */         {
/*  90 */           MergeMain.logger().error(String.format("[crossbattle]CrossBattleBetRankMergeModule.PMergeRankBackup.processImp@vice server has no activity data|main_zone_id=%d|vice_zone_id=%d|activity_cfg_id=%d", new Object[] { Long.valueOf(mainZoneid), Long.valueOf(viceZoneid), Integer.valueOf(activityCfgid) }));
/*     */           
/*     */ 
/*     */ 
/*  94 */           return false;
/*     */         }
/*     */         
/*  97 */         CrossBattleBetRankAwardInfo xMainWinCrossBattleBetRankAwardInfo = (CrossBattleBetRankAwardInfo)xMainCrossBattleBetSeasonRankBackup.getRank_award_infos().get(Integer.valueOf(50));
/*     */         
/*  99 */         CrossBattleBetRankAwardInfo xViceWinCrossBattleBetRankAwardInfo = (CrossBattleBetRankAwardInfo)xViceCrossBattleBetSeasonRankBackup.getRank_award_infos().get(Integer.valueOf(50));
/*     */         
/* 101 */         if ((xMainWinCrossBattleBetRankAwardInfo != null) || (xViceWinCrossBattleBetRankAwardInfo != null))
/*     */         {
/*     */ 
/*     */ 
/* 105 */           if ((xMainWinCrossBattleBetRankAwardInfo != null) && (xViceWinCrossBattleBetRankAwardInfo == null))
/*     */           {
/* 107 */             xMainWinCrossBattleBetRankAwardInfo.setIs_data_complete(false);
/*     */           }
/* 109 */           else if ((xMainWinCrossBattleBetRankAwardInfo == null) && (xViceWinCrossBattleBetRankAwardInfo != null))
/*     */           {
/* 111 */             xViceWinCrossBattleBetRankAwardInfo.setIs_data_complete(false);
/* 112 */             xMainCrossBattleBetSeasonRankBackup.getRank_award_infos().put(Integer.valueOf(50), xViceWinCrossBattleBetRankAwardInfo.copy());
/*     */ 
/*     */           }
/*     */           else
/*     */           {
/*     */ 
/* 118 */             if (!xViceWinCrossBattleBetRankAwardInfo.getIs_data_complete())
/*     */             {
/* 120 */               xMainWinCrossBattleBetRankAwardInfo.setIs_data_complete(false);
/*     */             }
/* 122 */             for (Map.Entry<Long, RoleCrossBattleBetRankAwardInfo> roleEntry : xViceWinCrossBattleBetRankAwardInfo.getRole_rank_award_infos().entrySet())
/*     */             {
/* 124 */               xMainWinCrossBattleBetRankAwardInfo.getRole_rank_award_infos().put(roleEntry.getKey(), ((RoleCrossBattleBetRankAwardInfo)roleEntry.getValue()).copy());
/*     */             }
/*     */             
/* 127 */             MergeMain.logger().info(String.format("[crossbattle]CrossBattleBetRankMergeModule.PMergeRankBackup.processImp@activity win rank backup merged|main_zone_id=%d|vice_zone_id=%d|activity_cfg_id=%d", new Object[] { Long.valueOf(mainZoneid), Long.valueOf(viceZoneid), Integer.valueOf(activityCfgid) }));
/*     */           }
/*     */         }
/*     */         
/*     */ 
/*     */ 
/* 133 */         CrossBattleBetRankAwardInfo xMainLoseCrossBattleBetRankAwardInfo = (CrossBattleBetRankAwardInfo)xMainCrossBattleBetSeasonRankBackup.getRank_award_infos().get(Integer.valueOf(51));
/*     */         
/* 135 */         CrossBattleBetRankAwardInfo xViceLoseCrossBattleBetRankAwardInfo = (CrossBattleBetRankAwardInfo)xViceCrossBattleBetSeasonRankBackup.getRank_award_infos().get(Integer.valueOf(51));
/*     */         
/* 137 */         if ((xMainLoseCrossBattleBetRankAwardInfo != null) || (xViceLoseCrossBattleBetRankAwardInfo != null))
/*     */         {
/*     */ 
/*     */ 
/* 141 */           if ((xMainLoseCrossBattleBetRankAwardInfo != null) && (xViceLoseCrossBattleBetRankAwardInfo == null))
/*     */           {
/* 143 */             xMainLoseCrossBattleBetRankAwardInfo.setIs_data_complete(false);
/*     */           }
/* 145 */           else if ((xMainLoseCrossBattleBetRankAwardInfo == null) && (xViceLoseCrossBattleBetRankAwardInfo != null))
/*     */           {
/* 147 */             xViceLoseCrossBattleBetRankAwardInfo.setIs_data_complete(false);
/* 148 */             xMainCrossBattleBetSeasonRankBackup.getRank_award_infos().put(Integer.valueOf(51), xViceLoseCrossBattleBetRankAwardInfo.copy());
/*     */ 
/*     */           }
/*     */           else
/*     */           {
/*     */ 
/* 154 */             if (!xViceLoseCrossBattleBetRankAwardInfo.getIs_data_complete())
/*     */             {
/* 156 */               xMainLoseCrossBattleBetRankAwardInfo.setIs_data_complete(false);
/*     */             }
/* 158 */             for (Map.Entry<Long, RoleCrossBattleBetRankAwardInfo> roleEntry : xViceLoseCrossBattleBetRankAwardInfo.getRole_rank_award_infos().entrySet())
/*     */             {
/* 160 */               xMainLoseCrossBattleBetRankAwardInfo.getRole_rank_award_infos().put(roleEntry.getKey(), ((RoleCrossBattleBetRankAwardInfo)roleEntry.getValue()).copy());
/*     */             }
/*     */             
/* 163 */             MergeMain.logger().info(String.format("[crossbattle]CrossBattleBetRankMergeModule.PMergeRankBackup.processImp@activity lose rank backup merged|main_zone_id=%d|vice_zone_id=%d|activity_cfg_id=%d", new Object[] { Long.valueOf(mainZoneid), Long.valueOf(viceZoneid), Integer.valueOf(activityCfgid) }));
/*     */           }
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 169 */       if (!xViceCrossBattleBetRankBackup.getBackups().isEmpty())
/*     */       {
/* 171 */         MergeMain.logger().error(String.format("[crossbattle]CrossBattleBetRankMergeModule.PMergeRankBackup.processImp@vice server has left activity rank backup|main_zone_id=%d|vice_zone_id=%d|left_activity_cfg_ids=%s", new Object[] { Long.valueOf(mainZoneid), Long.valueOf(viceZoneid), xViceCrossBattleBetRankBackup.getBackups().keySet().toString() }));
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 176 */       Cross_battle_bet_rank_backups.remove(Long.valueOf(viceZoneid));
/* 177 */       MergeMain.logger().info(String.format("[crossbattle]CrossBattleBetRankMergeModule.PMergeRankBackup.processImp@main server and vice server have data|main_zone_id=%d|vice_zone_id=%d", new Object[] { Long.valueOf(mainZoneid), Long.valueOf(viceZoneid) }));
/*     */       
/*     */ 
/*     */ 
/* 181 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\bet\CrossBattleBetRankMergeModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
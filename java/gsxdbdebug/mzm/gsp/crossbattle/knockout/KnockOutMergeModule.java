/*     */ package mzm.gsp.crossbattle.knockout;
/*     */ 
/*     */ import java.util.HashSet;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.MergeMain;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattleKnockOutCfg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.CrossBattleKnockoutActivityLocalInfo;
/*     */ import xbean.CrossBattleKnockoutLocalInfo;
/*     */ import xbean.CrossBattleKnockoutLocalRankInfo;
/*     */ import xbean.FightZoneLocalInfo;
/*     */ import xtable.Cross_battle_knockout_local;
/*     */ 
/*     */ public class KnockOutMergeModule implements mzm.gsp.MergeModule
/*     */ {
/*     */   public java.util.List<xdb.Table> getHandleTables()
/*     */   {
/*  22 */     return java.util.Arrays.asList(new xdb.Table[] { Cross_battle_knockout_local.getTable(), xtable.Role2crossbattlefinalaward.getTable() });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean handleMerge()
/*     */   {
/*  29 */     for (SCrossBattleKnockOutCfg sCrossBattleKnockOutCfg : SCrossBattleKnockOutCfg.getAll().values())
/*     */     {
/*  31 */       if (!new PMergeKnockOutData(sCrossBattleKnockOutCfg.activity_cfg_id).call())
/*     */       {
/*  33 */         return false;
/*     */       }
/*     */     }
/*  36 */     return true;
/*     */   }
/*     */   
/*     */   private static class PMergeKnockOutData extends mzm.gsp.util.LogicProcedure
/*     */   {
/*     */     private final long activityCfgId;
/*     */     
/*     */     public PMergeKnockOutData(long activityCfgId)
/*     */     {
/*  45 */       this.activityCfgId = activityCfgId;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  51 */       long mainZoneid = MergeMain.getMainZoneid();
/*  52 */       long viceZoneid = MergeMain.getViceZoneid();
/*  53 */       long mainKey = GameServerInfoManager.toGlobalId(this.activityCfgId, mainZoneid);
/*  54 */       long viceKey = GameServerInfoManager.toGlobalId(this.activityCfgId, viceZoneid);
/*     */       
/*  56 */       HashSet<Long> keys = new HashSet();
/*  57 */       keys.add(Long.valueOf(mainKey));
/*  58 */       keys.add(Long.valueOf(viceKey));
/*  59 */       lock(Cross_battle_knockout_local.getTable(), keys);
/*     */       
/*  61 */       CrossBattleKnockoutActivityLocalInfo xMainCrossBattleKnockOut = Cross_battle_knockout_local.get(Long.valueOf(mainKey));
/*  62 */       CrossBattleKnockoutActivityLocalInfo xViceCrossBattleKnockOut = Cross_battle_knockout_local.get(Long.valueOf(viceKey));
/*     */       
/*     */ 
/*  65 */       if ((xMainCrossBattleKnockOut == null) && (xViceCrossBattleKnockOut == null))
/*     */       {
/*  67 */         MergeMain.logger().info(String.format("[crossbattle_knockout]PMergeKnockOutData.processImp@main server and vice server have no data|activity_cfg_id=%d|main_zone_id=%d|vice_zone_id=%d", new Object[] { Long.valueOf(this.activityCfgId), Long.valueOf(mainZoneid), Long.valueOf(viceZoneid) }));
/*     */         
/*     */ 
/*     */ 
/*  71 */         return true;
/*     */       }
/*     */       
/*     */ 
/*  75 */       if ((xMainCrossBattleKnockOut != null) && (xViceCrossBattleKnockOut == null))
/*     */       {
/*  77 */         MergeMain.logger().info(String.format("[crossbattle_knockout]PMergeKnockOutData.processImp@main server has data vice server have no data|activity_cfg_id=%d|main_zone_id=%d|vice_zone_id=%d", new Object[] { Long.valueOf(this.activityCfgId), Long.valueOf(mainZoneid), Long.valueOf(viceZoneid) }));
/*     */         
/*     */ 
/*     */ 
/*  81 */         return true;
/*     */       }
/*     */       
/*     */ 
/*  85 */       if ((xMainCrossBattleKnockOut == null) && (xViceCrossBattleKnockOut != null))
/*     */       {
/*  87 */         Cross_battle_knockout_local.remove(Long.valueOf(viceKey));
/*  88 */         Cross_battle_knockout_local.insert(Long.valueOf(mainKey), xViceCrossBattleKnockOut.copy());
/*     */         
/*  90 */         MergeMain.logger().info(String.format("[crossbattle_knockout]PMergeKnockOutData.processImp@main server has no data but vice server have data|activity_cfg_id=%d|main_zone_id=%d|vice_zone_id=%d", new Object[] { Long.valueOf(this.activityCfgId), Long.valueOf(mainZoneid), Long.valueOf(viceZoneid) }));
/*     */         
/*     */ 
/*     */ 
/*  94 */         return true;
/*     */       }
/*     */       
/*     */ 
/*  98 */       Cross_battle_knockout_local.remove(Long.valueOf(viceKey));
/*     */       
/* 100 */       Map<Integer, CrossBattleKnockoutLocalInfo> xViceKnockOutMap = xViceCrossBattleKnockOut.getKnockout_info_map();
/* 101 */       for (Map.Entry<Integer, CrossBattleKnockoutLocalInfo> entry : xViceKnockOutMap.entrySet())
/*     */       {
/* 103 */         int knockOutType = ((Integer)entry.getKey()).intValue();
/* 104 */         CrossBattleKnockoutLocalInfo xViceCrossBattleKnockoutLocalInfo = (CrossBattleKnockoutLocalInfo)entry.getValue();
/*     */         
/* 106 */         xMainCrossBattleKnockoutLocalInfo = (CrossBattleKnockoutLocalInfo)xMainCrossBattleKnockOut.getKnockout_info_map().get(Integer.valueOf(knockOutType));
/*     */         
/* 108 */         if (xMainCrossBattleKnockoutLocalInfo == null)
/*     */         {
/* 110 */           xMainCrossBattleKnockOut.getKnockout_info_map().put(Integer.valueOf(knockOutType), xViceCrossBattleKnockoutLocalInfo.copy());
/*     */         }
/*     */         else
/*     */         {
/* 114 */           for (Map.Entry<Integer, FightZoneLocalInfo> xViceFightZoneLocalInfoEntry : xViceCrossBattleKnockoutLocalInfo.getFight_zone_info_map().entrySet())
/*     */           {
/* 116 */             int fightZoneId = ((Integer)xViceFightZoneLocalInfoEntry.getKey()).intValue();
/* 117 */             FightZoneLocalInfo xViceFightZoneLocalInfo = (FightZoneLocalInfo)xViceFightZoneLocalInfoEntry.getValue();
/*     */             
/* 119 */             FightZoneLocalInfo xMainFightZoneLocalInfo = (FightZoneLocalInfo)xMainCrossBattleKnockoutLocalInfo.getFight_zone_info_map().get(Integer.valueOf(fightZoneId));
/*     */             
/* 121 */             if (xMainFightZoneLocalInfo == null)
/*     */             {
/* 123 */               xMainCrossBattleKnockoutLocalInfo.getFight_zone_info_map().put(Integer.valueOf(fightZoneId), xViceFightZoneLocalInfo.copy());
/*     */ 
/*     */             }
/*     */             else
/*     */             {
/* 128 */               xMainFightZoneLocalInfo.getAward_corps_id_set().addAll(xViceFightZoneLocalInfo.getAward_corps_id_set());
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */       
/*     */       CrossBattleKnockoutLocalInfo xMainCrossBattleKnockoutLocalInfo;
/* 135 */       for (Map.Entry<Integer, CrossBattleKnockoutLocalInfo> entry : xMainCrossBattleKnockOut.getKnockout_info_map().entrySet())
/*     */       {
/* 137 */         StringBuilder sBuilder = new StringBuilder();
/* 138 */         sBuilder.append("[crossbattle_knockout]PMergeKnockOutData.processImp@merge vice corps award data");
/* 139 */         sBuilder.append("|activity_cfg_id=").append(this.activityCfgId);
/* 140 */         sBuilder.append("|knockout_type=").append(entry.getKey());
/*     */         
/* 142 */         for (Map.Entry<Integer, FightZoneLocalInfo> entry2 : ((CrossBattleKnockoutLocalInfo)entry.getValue()).getFight_zone_info_map().entrySet())
/*     */         {
/* 144 */           sBuilder.append("|fight_zone_id=").append(entry2.getKey());
/* 145 */           sBuilder.append("|award_corps_id_set=").append(((FightZoneLocalInfo)entry2.getValue()).getAward_corps_id_set());
/*     */         }
/* 147 */         GameServer.logger().info(sBuilder.toString());
/*     */       }
/*     */       
/*     */ 
/* 151 */       for (Map.Entry<Integer, CrossBattleKnockoutLocalRankInfo> entry : xViceCrossBattleKnockOut.getAward_server_info_map().entrySet())
/*     */       {
/* 153 */         int rank = ((Integer)entry.getKey()).intValue();
/* 154 */         CrossBattleKnockoutLocalRankInfo xViceCrossBattleKnockoutLocalRankInfo = (CrossBattleKnockoutLocalRankInfo)entry.getValue();
/*     */         
/* 156 */         CrossBattleKnockoutLocalRankInfo xMainCrossBattleKnockoutLocalRankInfo = (CrossBattleKnockoutLocalRankInfo)xMainCrossBattleKnockOut.getAward_server_info_map().get(Integer.valueOf(rank));
/*     */         
/* 158 */         if (xMainCrossBattleKnockoutLocalRankInfo == null)
/*     */         {
/* 160 */           xMainCrossBattleKnockOut.getAward_server_info_map().put(Integer.valueOf(rank), xViceCrossBattleKnockoutLocalRankInfo.copy());
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/* 165 */           xMainCrossBattleKnockoutLocalRankInfo.getValid_zone_id_set().addAll(xViceCrossBattleKnockoutLocalRankInfo.getValid_zone_id_set());
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 170 */       StringBuilder sBuilder = new StringBuilder();
/* 171 */       sBuilder.append("[crossbattle_knockout]PMergeKnockOutData.processImp@merge vice final server award data");
/* 172 */       sBuilder.append("|activity_cfg_id=").append(this.activityCfgId);
/* 173 */       for (Map.Entry<Integer, CrossBattleKnockoutLocalRankInfo> entry : xMainCrossBattleKnockOut.getAward_server_info_map().entrySet())
/*     */       {
/* 175 */         sBuilder.append("|rank=").append(entry.getKey());
/* 176 */         sBuilder.append("|is_buff_install=").append(((CrossBattleKnockoutLocalRankInfo)entry.getValue()).getIs_server_buff_install());
/* 177 */         sBuilder.append("|valid_zone_id=").append(((CrossBattleKnockoutLocalRankInfo)entry.getValue()).getValid_zone_id_set());
/*     */       }
/*     */       
/* 180 */       GameServer.logger().info(sBuilder.toString());
/*     */       
/* 182 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\knockout\KnockOutMergeModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
/*     */ package mzm.gsp.crossbattle.knockout;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.TreeMap;
/*     */ import mzm.gsp.crossbattle.CorpsInfo;
/*     */ import mzm.gsp.crossbattle.confbean.KnockOutCfg;
/*     */ import xbean.FightCorpsInfo;
/*     */ import xbean.FightStageInfo;
/*     */ import xbean.FightZoneInfo;
/*     */ 
/*     */ public class CrossBattleFightZoneInfo
/*     */ {
/*     */   private final FightZoneInfo xFightZoneInfo;
/*     */   private final KnockOutCfg knockOutCfg;
/*     */   
/*     */   public CrossBattleFightZoneInfo(FightZoneInfo xFightZoneInfo, KnockOutCfg knockOutCfg)
/*     */   {
/*  20 */     this.xFightZoneInfo = xFightZoneInfo;
/*  21 */     this.knockOutCfg = knockOutCfg;
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
/*     */ 
/*     */ 
/*     */   public boolean fillKnockOutFightCorpsInfo(Map<Long, CorpsInfo> corpsInfoMap)
/*     */     throws java.io.UnsupportedEncodingException
/*     */   {
/*  37 */     if (corpsInfoMap == null)
/*     */     {
/*  39 */       return false;
/*     */     }
/*     */     
/*  42 */     Map<Long, FightCorpsInfo> xFightCorpsInfoMap = this.xFightZoneInfo.getFight_corps_info_map();
/*     */     
/*  44 */     for (Map.Entry<Long, FightCorpsInfo> entry : xFightCorpsInfoMap.entrySet())
/*     */     {
/*  46 */       FightCorpsInfo xFightCorpsInfo = (FightCorpsInfo)entry.getValue();
/*     */       
/*  48 */       CorpsInfo corpsInfo = new CorpsInfo();
/*  49 */       corpsInfo.zone_id = xFightCorpsInfo.getCorps_zone_id();
/*  50 */       corpsInfo.corps_id = xFightCorpsInfo.getCorps_id();
/*  51 */       corpsInfoMap.put(entry.getKey(), corpsInfo);
/*     */       
/*  53 */       corpsInfo.corps_icon = xFightCorpsInfo.getCorps_badge_id();
/*  54 */       corpsInfo.corps_name.setString(xFightCorpsInfo.getCorps_name(), "UTF-8");
/*     */     }
/*     */     
/*  57 */     return true;
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
/*     */   public boolean fillFightZoneInfo(int fightStage, List<mzm.gsp.crossbattle.FightAgainstInfo> fightAgainstList)
/*     */   {
/*  70 */     if (fightAgainstList == null)
/*     */     {
/*  72 */       return false;
/*     */     }
/*     */     
/*  75 */     if (fightStage > this.xFightZoneInfo.getFight_stage_info_map().size())
/*     */     {
/*  77 */       return false;
/*     */     }
/*  79 */     Map<Integer, FightStageInfo> xFightStageInfoMap = this.xFightZoneInfo.getFight_stage_info_map();
/*     */     
/*  81 */     FightStageInfo xFightStageInfo = (FightStageInfo)xFightStageInfoMap.get(Integer.valueOf(fightStage));
/*  82 */     if (this.xFightZoneInfo == null)
/*     */     {
/*  84 */       return false;
/*     */     }
/*     */     
/*  87 */     TreeMap<Integer, mzm.gsp.crossbattle.FightAgainstInfo> fightAgainstMap = new TreeMap();
/*  88 */     for (Map.Entry<Integer, xbean.FightAgainstInfo> entry : xFightStageInfo.getFight_against_info_map().entrySet())
/*     */     {
/*  90 */       int fightIndexId = ((Integer)entry.getKey()).intValue();
/*  91 */       xbean.FightAgainstInfo xfightAgainst = (xbean.FightAgainstInfo)entry.getValue();
/*  92 */       long corpsIdA = xfightAgainst.getA_corps_id();
/*  93 */       long corpsIdB = xfightAgainst.getB_corps_id();
/*     */       
/*  95 */       if ((xfightAgainst.getCal_fight_result() == 0) && (fightStage % this.knockOutCfg.fight_times_every_stage != 1) && (this.knockOutCfg.fight_times_every_stage != 1))
/*     */       {
/*     */ 
/*  98 */         mzm.gsp.util.Pair<Long, mzm.gsp.util.Pair<Integer, Integer>> winCorpsPair = CrossBattleKnockoutManager.getWinCorpsId(xFightStageInfoMap, corpsIdA, corpsIdB, fightStage, fightIndexId, this.knockOutCfg.fight_times_every_stage);
/*     */         
/* 100 */         if (((Long)winCorpsPair.first).longValue() != -1L)
/*     */         {
/* 102 */           corpsIdA = -1L;
/* 103 */           corpsIdB = -1L;
/*     */         }
/*     */       }
/*     */       
/* 107 */       mzm.gsp.crossbattle.FightAgainstInfo fightAgainst = new mzm.gsp.crossbattle.FightAgainstInfo();
/* 108 */       fightAgainst.corps_a_id = corpsIdA;
/* 109 */       fightAgainst.corps_b_id = corpsIdB;
/*     */       
/* 111 */       if (xfightAgainst.getFight_status() == 2)
/*     */       {
/* 113 */         fightAgainst.corps_a_state = 7;
/* 114 */         fightAgainst.corps_b_state = 7;
/*     */       }
/*     */       else
/*     */       {
/* 118 */         fightAgainst.corps_a_state = xfightAgainst.getA_corps_id_result();
/* 119 */         fightAgainst.corps_b_state = xfightAgainst.getB_corps_id_result();
/*     */       }
/*     */       
/* 122 */       fightAgainstMap.put(Integer.valueOf(fightIndexId), fightAgainst);
/*     */     }
/* 124 */     fightAgainstList.addAll(fightAgainstMap.values());
/*     */     
/* 126 */     return true;
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
/*     */   public List<mzm.gsp.crossbattle.FightAgainstInfo> getStagefightAgainstList(int selectionStage)
/*     */   {
/* 139 */     if (selectionStage > this.xFightZoneInfo.getFight_stage_info_map().size())
/*     */     {
/* 141 */       return null;
/*     */     }
/*     */     
/* 144 */     FightStageInfo xFightStageInfo = (FightStageInfo)this.xFightZoneInfo.getFight_stage_info_map().get(Integer.valueOf(selectionStage));
/* 145 */     if (xFightStageInfo == null)
/*     */     {
/* 147 */       return null;
/*     */     }
/*     */     
/* 150 */     TreeMap<Integer, mzm.gsp.crossbattle.FightAgainstInfo> fightAgainstMap = new TreeMap();
/* 151 */     for (Map.Entry<Integer, xbean.FightAgainstInfo> entry : xFightStageInfo.getFight_against_info_map().entrySet())
/*     */     {
/* 153 */       int fightIndexId = ((Integer)entry.getKey()).intValue();
/* 154 */       xbean.FightAgainstInfo xFightAgainstInfo = (xbean.FightAgainstInfo)entry.getValue();
/*     */       
/* 156 */       mzm.gsp.crossbattle.FightAgainstInfo fightAgainst = new mzm.gsp.crossbattle.FightAgainstInfo();
/* 157 */       fightAgainst.corps_a_id = xFightAgainstInfo.getA_corps_id();
/* 158 */       fightAgainst.corps_b_id = xFightAgainstInfo.getB_corps_id();
/*     */       
/* 160 */       if (xFightAgainstInfo.getFight_status() == 2)
/*     */       {
/* 162 */         fightAgainst.corps_a_state = 7;
/* 163 */         fightAgainst.corps_b_state = 7;
/*     */       }
/*     */       else
/*     */       {
/* 167 */         fightAgainst.corps_a_state = xFightAgainstInfo.getA_corps_id_result();
/* 168 */         fightAgainst.corps_b_state = xFightAgainstInfo.getB_corps_id_result();
/*     */       }
/*     */       
/* 171 */       fightAgainst.cal_fight_result = xFightAgainstInfo.getCal_fight_result();
/* 172 */       fightAgainstMap.put(Integer.valueOf(fightIndexId), fightAgainst);
/*     */     }
/*     */     
/* 175 */     return new java.util.ArrayList(fightAgainstMap.values());
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
/*     */   public String getCorpsName(long corpsId)
/*     */   {
/* 188 */     FightCorpsInfo xFightCorpsInfo = (FightCorpsInfo)this.xFightZoneInfo.getFight_corps_info_map().get(Long.valueOf(corpsId));
/* 189 */     if (xFightCorpsInfo == null)
/*     */     {
/* 191 */       return new String();
/*     */     }
/*     */     
/* 194 */     return xFightCorpsInfo.getCorps_name();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\knockout\CrossBattleFightZoneInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
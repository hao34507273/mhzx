/*     */ package mzm.gsp.crossbattle.bet;
/*     */ 
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.MergeMain;
/*     */ import mzm.gsp.MergeModule;
/*     */ import mzm.gsp.crossbattle.knockout.CrossBattleKnockoutInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.CrossBattleKnockoutBet;
/*     */ import xbean.KnockoutFightBetInfo;
/*     */ import xbean.KnockoutStageBetInfo;
/*     */ import xbean.KnockoutTypeBetInfo;
/*     */ import xbean.KnockoutZoneBetInfo;
/*     */ import xbean.Pod;
/*     */ import xbean.RoleKnockoutFightBetInfo;
/*     */ import xdb.Table;
/*     */ import xtable.Cross_battle_konckout_bets;
/*     */ 
/*     */ public class CrossBattleKnockoutBetMergeModule implements MergeModule
/*     */ {
/*     */   public java.util.List<Table> getHandleTables()
/*     */   {
/*  27 */     return java.util.Arrays.asList(new Table[] { Cross_battle_konckout_bets.getTable(), xtable.Role_cross_battle_bet_times_infos.getTable() });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean handleMerge()
/*     */   {
/*  34 */     for (Iterator i$ = mzm.gsp.crossbattle.confbean.SCrossBattleKnockoutBetCfg.getAll().keySet().iterator(); i$.hasNext();) { int activityCfgid = ((Integer)i$.next()).intValue();
/*     */       
/*  36 */       if (!new PMerge(activityCfgid).call())
/*     */       {
/*  38 */         return false;
/*     */       }
/*     */     }
/*  41 */     return true;
/*     */   }
/*     */   
/*     */   private class PMerge extends mzm.gsp.util.LogicProcedure
/*     */   {
/*     */     private final int activityCfgid;
/*     */     
/*     */     public PMerge(int activityCfgid)
/*     */     {
/*  50 */       this.activityCfgid = activityCfgid;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  56 */       long mainZoneid = MergeMain.getMainZoneid();
/*  57 */       long viceZoneid = MergeMain.getViceZoneid();
/*  58 */       long mainKey = GameServerInfoManager.toGlobalId(this.activityCfgid, mainZoneid);
/*  59 */       long viceKey = GameServerInfoManager.toGlobalId(this.activityCfgid, viceZoneid);
/*     */       
/*  61 */       HashSet<Long> keys = new HashSet();
/*  62 */       keys.add(Long.valueOf(mainKey));
/*  63 */       keys.add(Long.valueOf(viceKey));
/*  64 */       lock(Cross_battle_konckout_bets.getTable(), keys);
/*     */       
/*  66 */       CrossBattleKnockoutBet xMainCrossBattleKnockoutBet = Cross_battle_konckout_bets.get(Long.valueOf(mainKey));
/*  67 */       CrossBattleKnockoutBet xViceCrossBattleKnockoutBet = Cross_battle_konckout_bets.get(Long.valueOf(viceKey));
/*     */       
/*     */ 
/*  70 */       if ((xMainCrossBattleKnockoutBet == null) && (xViceCrossBattleKnockoutBet == null))
/*     */       {
/*  72 */         MergeMain.logger().info(String.format("[crossbattle_bet]PMerge.processImp@main server and vice server have no data|activity_cfg_id=%d", new Object[] { Integer.valueOf(this.activityCfgid) }));
/*     */         
/*     */ 
/*     */ 
/*  76 */         return true;
/*     */       }
/*     */       
/*  79 */       if ((xMainCrossBattleKnockoutBet != null) && (xViceCrossBattleKnockoutBet == null))
/*     */       {
/*  81 */         MergeMain.logger().info(String.format("[crossbattle_bet]PMerge.processImp@vice server has no data|activity_cfg_id=%d", new Object[] { Integer.valueOf(this.activityCfgid) }));
/*     */         
/*     */ 
/*  84 */         return true;
/*     */       }
/*     */       
/*  87 */       if ((xMainCrossBattleKnockoutBet == null) && (xViceCrossBattleKnockoutBet != null))
/*     */       {
/*  89 */         Cross_battle_konckout_bets.remove(Long.valueOf(viceKey));
/*  90 */         Cross_battle_konckout_bets.insert(Long.valueOf(mainKey), xViceCrossBattleKnockoutBet.copy());
/*  91 */         MergeMain.logger().info(String.format("[crossbattle_bet]PMerge.processImp@main server has no data|activity_cfg_id=%d", new Object[] { Integer.valueOf(this.activityCfgid) }));
/*     */         
/*     */ 
/*  94 */         return true;
/*     */       }
/*     */       
/*  97 */       xtable.Cross_battle_owns.remove(Long.valueOf(viceKey));
/*  98 */       for (int knockoutType = 1; knockoutType <= 2; knockoutType++)
/*     */       {
/* 100 */         for (int fightZoneid = 1; fightZoneid <= CrossBattleBetManager.getKnockoutFightZoneNum(knockoutType); fightZoneid++)
/*     */         {
/* 102 */           for (int stage = 1; stage <= CrossBattleKnockoutInterface.getKnockOutStageSize(this.activityCfgid, knockoutType); stage++)
/*     */           {
/* 104 */             KnockoutStageBetInfo xMainKnockoutStageBetInfo = CrossBattleBetManager.getXKnockoutStageBetInfo(mainKey, knockoutType, fightZoneid, stage);
/*     */             
/* 106 */             KnockoutStageBetInfo xViceKnockoutStageBetInfo = CrossBattleBetManager.getXKnockoutStageBetInfo(viceKey, knockoutType, fightZoneid, stage);
/*     */             
/*     */ 
/* 109 */             if ((xMainKnockoutStageBetInfo == null) && (xViceKnockoutStageBetInfo == null))
/*     */             {
/* 111 */               MergeMain.logger().info(String.format("[crossbattle_bet]PMerge.processImp@main server and vice server have no stage data|activity_cfg_id=%d|knockout_type=%d|fight_zone_id=%d|stage=%d", new Object[] { Integer.valueOf(this.activityCfgid), Integer.valueOf(knockoutType), Integer.valueOf(fightZoneid), Integer.valueOf(stage) }));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             }
/* 118 */             else if ((xMainKnockoutStageBetInfo != null) && (xViceKnockoutStageBetInfo == null))
/*     */             {
/* 120 */               MergeMain.logger().info(String.format("[crossbattle_bet]PMerge.processImp@vice server has no stage data|activity_cfg_id=%d|knockout_type=%d|fight_zone_id=%d|stage=%d", new Object[] { Integer.valueOf(this.activityCfgid), Integer.valueOf(knockoutType), Integer.valueOf(fightZoneid), Integer.valueOf(stage) }));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             }
/* 127 */             else if ((xMainKnockoutStageBetInfo == null) && (xViceKnockoutStageBetInfo != null))
/*     */             {
/* 129 */               KnockoutTypeBetInfo xKnockoutTypeBetInfo = (KnockoutTypeBetInfo)xMainCrossBattleKnockoutBet.getKnockout_type_bet_infos().get(Integer.valueOf(knockoutType));
/*     */               
/* 131 */               if (xKnockoutTypeBetInfo == null)
/*     */               {
/* 133 */                 xKnockoutTypeBetInfo = Pod.newKnockoutTypeBetInfo();
/* 134 */                 xMainCrossBattleKnockoutBet.getKnockout_type_bet_infos().put(Integer.valueOf(knockoutType), xKnockoutTypeBetInfo);
/*     */               }
/* 136 */               KnockoutZoneBetInfo xKnockoutZoneBetInfo = (KnockoutZoneBetInfo)xKnockoutTypeBetInfo.getZone_bet_infos().get(Integer.valueOf(fightZoneid));
/*     */               
/* 138 */               if (xKnockoutZoneBetInfo == null)
/*     */               {
/* 140 */                 xKnockoutZoneBetInfo = Pod.newKnockoutZoneBetInfo();
/* 141 */                 xKnockoutTypeBetInfo.getZone_bet_infos().put(Integer.valueOf(fightZoneid), xKnockoutZoneBetInfo);
/*     */               }
/* 143 */               xKnockoutZoneBetInfo.getStage_bet_infos().put(Integer.valueOf(stage), xViceKnockoutStageBetInfo.copy());
/* 144 */               MergeMain.logger().info(String.format("[crossbattle_bet]PMerge.processImp@main server has no stage data|activity_cfg_id=%d|knockout_type=%d|fight_zone_id=%d|stage=%d", new Object[] { Integer.valueOf(this.activityCfgid), Integer.valueOf(knockoutType), Integer.valueOf(fightZoneid), Integer.valueOf(stage) }));
/*     */             }
/*     */             else
/*     */             {
/*     */               KnockoutFightBetInfo xMainKnockoutFightBetInfo;
/*     */               
/*     */ 
/* 151 */               for (int fightIndex = 1; fightIndex <= CrossBattleKnockoutInterface.getKnockOutStageFightNum(this.activityCfgid, knockoutType, stage); 
/* 152 */                   fightIndex++)
/*     */               {
/* 154 */                 xMainKnockoutFightBetInfo = (KnockoutFightBetInfo)xMainKnockoutStageBetInfo.getFight_bet_infos().get(Integer.valueOf(fightIndex));
/*     */                 
/* 156 */                 KnockoutFightBetInfo xViceKnockoutFightBetInfo = (KnockoutFightBetInfo)xViceKnockoutStageBetInfo.getFight_bet_infos().get(Integer.valueOf(fightIndex));
/*     */                 
/* 158 */                 if ((!xMainKnockoutFightBetInfo.getHas_set_cal_fight_result()) && (xViceKnockoutFightBetInfo.getHas_set_cal_fight_result()))
/*     */                 {
/*     */ 
/* 161 */                   xMainKnockoutFightBetInfo.setCal_fight_result(xViceKnockoutFightBetInfo.getCal_fight_result());
/* 162 */                   xMainKnockoutFightBetInfo.setHas_set_cal_fight_result(true);
/*     */                 }
/* 164 */                 for (Map.Entry<Long, RoleKnockoutFightBetInfo> entry : xViceKnockoutFightBetInfo.getRole_bet_infos().entrySet())
/*     */                 {
/* 166 */                   xMainKnockoutFightBetInfo.getRole_bet_infos().put(entry.getKey(), ((RoleKnockoutFightBetInfo)entry.getValue()).copy());
/*     */                 }
/*     */               }
/* 169 */               MergeMain.logger().info(String.format("[crossbattle_bet]PMerge.processImp@main server and vice server have stage data|activity_cfg_id=%d|knockout_type=%d|fight_zone_id=%d|stage=%d", new Object[] { Integer.valueOf(this.activityCfgid), Integer.valueOf(knockoutType), Integer.valueOf(fightZoneid), Integer.valueOf(stage) }));
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 176 */       MergeMain.logger().info(String.format("[crossbattle_bet]PMerge.processImp@main server and vice server have data|activity_cfg_id=%d", new Object[] { Integer.valueOf(this.activityCfgid) }));
/*     */       
/*     */ 
/*     */ 
/* 180 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\bet\CrossBattleKnockoutBetMergeModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
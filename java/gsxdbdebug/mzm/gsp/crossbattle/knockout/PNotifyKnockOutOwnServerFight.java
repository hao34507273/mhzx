/*     */ package mzm.gsp.crossbattle.knockout;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.TreeMap;
/*     */ import mzm.gsp.crossbattle.CorpsInfo;
/*     */ import mzm.gsp.crossbattle.SGetSelectionStageOwnServerFightSuccess;
/*     */ import mzm.gsp.crossbattle.confbean.KnockOutCfg;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattleKnockOutCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import xbean.CrossBattleKnockoutOwnServerActivityInfo;
/*     */ import xbean.CrossBattleOwnServerKnockoutInfo;
/*     */ import xbean.FightCorpsInfo;
/*     */ import xbean.FightOwnServerStageInfo;
/*     */ 
/*     */ public class PNotifyKnockOutOwnServerFight extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int activityCfgId;
/*     */   private final int fightStage;
/*     */   private final int knockOutType;
/*     */   
/*     */   public PNotifyKnockOutOwnServerFight(long roleId, int activityCfgId, int fightStage, int knockOutType)
/*     */   {
/*  26 */     this.roleId = roleId;
/*  27 */     this.activityCfgId = activityCfgId;
/*  28 */     this.fightStage = fightStage;
/*  29 */     this.knockOutType = knockOutType;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  35 */     SCrossBattleKnockOutCfg sCrossBattleKnockOutCfg = SCrossBattleKnockOutCfg.get(this.activityCfgId);
/*  36 */     if (sCrossBattleKnockOutCfg == null)
/*     */     {
/*  38 */       return false;
/*     */     }
/*     */     
/*  41 */     KnockOutCfg knockOutCfg = (KnockOutCfg)sCrossBattleKnockOutCfg.knockOutTypeCfgMap.get(Integer.valueOf(this.knockOutType));
/*  42 */     if (knockOutCfg == null)
/*     */     {
/*  44 */       return false;
/*     */     }
/*     */     
/*  47 */     long globalActivityCfgId = mzm.gsp.GameServerInfoManager.toGlobalId(this.activityCfgId);
/*  48 */     CrossBattleKnockoutOwnServerActivityInfo xKnockoutOwnServerActivityInfo = xtable.Cross_battle_knockout_own_server.get(Long.valueOf(globalActivityCfgId));
/*  49 */     if (xKnockoutOwnServerActivityInfo == null)
/*     */     {
/*  51 */       return false;
/*     */     }
/*     */     
/*  54 */     CrossBattleOwnServerKnockoutInfo xOwnServerKnockoutInfo = (CrossBattleOwnServerKnockoutInfo)xKnockoutOwnServerActivityInfo.getKnockout_info_map().get(Integer.valueOf(this.knockOutType));
/*     */     
/*  56 */     if (xOwnServerKnockoutInfo == null)
/*     */     {
/*  58 */       return false;
/*     */     }
/*     */     
/*  61 */     SGetSelectionStageOwnServerFightSuccess success = new SGetSelectionStageOwnServerFightSuccess();
/*  62 */     success.selection_stage = this.fightStage;
/*  63 */     Map<Long, CorpsInfo> corpsInfoMap = new HashMap();
/*  64 */     Map<Long, FightCorpsInfo> xFightCorpsInfoMap = xOwnServerKnockoutInfo.getFight_corps_info_map();
/*  65 */     for (Map.Entry<Long, FightCorpsInfo> entry : xFightCorpsInfoMap.entrySet())
/*     */     {
/*  67 */       FightCorpsInfo xFightCorpsInfo = (FightCorpsInfo)entry.getValue();
/*     */       
/*  69 */       CorpsInfo corpsInfo = new CorpsInfo();
/*  70 */       corpsInfo.zone_id = xFightCorpsInfo.getCorps_zone_id();
/*  71 */       corpsInfo.corps_id = xFightCorpsInfo.getCorps_id();
/*  72 */       corpsInfo.corps_icon = xFightCorpsInfo.getCorps_badge_id();
/*  73 */       corpsInfo.corps_name.setString(xFightCorpsInfo.getCorps_name(), "UTF-8");
/*     */       
/*  75 */       corpsInfoMap.put(entry.getKey(), corpsInfo);
/*     */     }
/*     */     
/*  78 */     mzm.gsp.util.Pair<Integer, Boolean> nowFightStagePair = CrossBattleKnockoutInterface.getNowFightStage(this.knockOutType);
/*  79 */     if (nowFightStagePair == null)
/*     */     {
/*  81 */       return false;
/*     */     }
/*     */     
/*  84 */     FightOwnServerStageInfo xFightOwnServerStageInfo = (FightOwnServerStageInfo)xOwnServerKnockoutInfo.getFight_stage_info_map().get(Integer.valueOf(this.fightStage));
/*     */     
/*  86 */     if (xFightOwnServerStageInfo == null)
/*     */     {
/*  88 */       return false;
/*     */     }
/*     */     
/*  91 */     TreeMap<Integer, mzm.gsp.crossbattle.FightAgainstInfo> selectionFightInfoMap = new TreeMap();
/*  92 */     int index = 1;
/*  93 */     for (xbean.FightAgainstInfo xFightAgainistInfo : xFightOwnServerStageInfo.getFight_against_info_list())
/*     */     {
/*  95 */       mzm.gsp.crossbattle.FightAgainstInfo fightAgainstInfo = new mzm.gsp.crossbattle.FightAgainstInfo();
/*  96 */       fightAgainstInfo.corps_a_id = xFightAgainistInfo.getA_corps_id();
/*  97 */       fightAgainstInfo.corps_b_id = xFightAgainistInfo.getB_corps_id();
/*     */       
/*  99 */       if (xFightAgainistInfo.getFight_status() == 2)
/*     */       {
/* 101 */         fightAgainstInfo.corps_a_state = 7;
/* 102 */         fightAgainstInfo.corps_b_state = 7;
/*     */       }
/*     */       else
/*     */       {
/* 106 */         fightAgainstInfo.corps_a_state = xFightAgainistInfo.getA_corps_id_result();
/* 107 */         fightAgainstInfo.corps_b_state = xFightAgainistInfo.getB_corps_id_result();
/*     */       }
/*     */       
/* 110 */       fightAgainstInfo.cal_fight_result = xFightAgainistInfo.getCal_fight_result();
/* 111 */       fightAgainstInfo.record_id = xFightAgainistInfo.getRecord_id();
/*     */       
/* 113 */       selectionFightInfoMap.put(Integer.valueOf(index++), fightAgainstInfo);
/*     */     }
/*     */     
/* 116 */     success.selection_fight_corps_map.putAll(corpsInfoMap);
/* 117 */     success.selection_stage_fight_info.fight_info_list.addAll(selectionFightInfoMap.values());
/*     */     
/* 119 */     OnlineManager.getInstance().send(this.roleId, success);
/*     */     
/* 121 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\knockout\PNotifyKnockOutOwnServerFight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
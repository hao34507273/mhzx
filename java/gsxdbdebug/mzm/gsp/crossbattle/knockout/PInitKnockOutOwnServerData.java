/*     */ package mzm.gsp.crossbattle.knockout;
/*     */ 
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattleKnockOutCfg;
/*     */ import org.json.JSONArray;
/*     */ import org.json.JSONObject;
/*     */ import xbean.CrossBattleKnockoutOwnServerActivityInfo;
/*     */ import xbean.CrossBattleOwnServerKnockoutInfo;
/*     */ import xbean.FightAgainstInfo;
/*     */ import xbean.FightCorpsInfo;
/*     */ import xbean.FightOwnServerStageInfo;
/*     */ import xbean.Pod;
/*     */ import xtable.Cross_battle_knockout_own_server;
/*     */ 
/*     */ public class PInitKnockOutOwnServerData extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final int retcode;
/*     */   private final long roleId;
/*     */   private final int activityCfgId;
/*     */   private final int knockOutType;
/*     */   private final int fightStage;
/*     */   private final String knockOutOwnServerJsonStr;
/*     */   
/*     */   public PInitKnockOutOwnServerData(int retcode, long roleId, int activityCfgId, int knockOutType, int fightStage, String knockOutOwnServerJsonStr)
/*     */   {
/*  27 */     this.retcode = retcode;
/*  28 */     this.roleId = roleId;
/*  29 */     this.activityCfgId = activityCfgId;
/*  30 */     this.knockOutType = knockOutType;
/*  31 */     this.fightStage = fightStage;
/*  32 */     this.knockOutOwnServerJsonStr = knockOutOwnServerJsonStr;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  38 */     if (this.retcode != 0)
/*     */     {
/*  40 */       return false;
/*     */     }
/*     */     
/*  43 */     SCrossBattleKnockOutCfg sCrossBattleKnockOutCfg = SCrossBattleKnockOutCfg.get(this.activityCfgId);
/*  44 */     if (sCrossBattleKnockOutCfg == null)
/*     */     {
/*  46 */       return false;
/*     */     }
/*     */     
/*  49 */     long globalActivityCfgId = GameServerInfoManager.toGlobalId(this.activityCfgId);
/*  50 */     CrossBattleKnockoutOwnServerActivityInfo xKnockoutOwnServerActivityInfo = Cross_battle_knockout_own_server.get(Long.valueOf(globalActivityCfgId));
/*  51 */     if (xKnockoutOwnServerActivityInfo == null)
/*     */     {
/*  53 */       xKnockoutOwnServerActivityInfo = Pod.newCrossBattleKnockoutOwnServerActivityInfo();
/*  54 */       Cross_battle_knockout_own_server.add(Long.valueOf(globalActivityCfgId), xKnockoutOwnServerActivityInfo);
/*     */     }
/*     */     
/*  57 */     CrossBattleOwnServerKnockoutInfo xCrossBattleOwnServerKnockoutInfo = (CrossBattleOwnServerKnockoutInfo)xKnockoutOwnServerActivityInfo.getKnockout_info_map().get(Integer.valueOf(this.knockOutType));
/*     */     
/*  59 */     if (xCrossBattleOwnServerKnockoutInfo == null)
/*     */     {
/*  61 */       xCrossBattleOwnServerKnockoutInfo = Pod.newCrossBattleOwnServerKnockoutInfo();
/*  62 */       xKnockoutOwnServerActivityInfo.getKnockout_info_map().put(Integer.valueOf(this.knockOutType), xCrossBattleOwnServerKnockoutInfo);
/*     */     }
/*     */     
/*  65 */     FightOwnServerStageInfo xOldFightStageInfo = (FightOwnServerStageInfo)xCrossBattleOwnServerKnockoutInfo.getFight_stage_info_map().get(Integer.valueOf(this.fightStage));
/*     */     
/*  67 */     if (xOldFightStageInfo != null)
/*     */     {
/*  69 */       xCrossBattleOwnServerKnockoutInfo.getFight_corps_info_map().remove(Integer.valueOf(this.fightStage));
/*     */     }
/*     */     
/*  72 */     FightOwnServerStageInfo xFightStageInfo = Pod.newFightOwnServerStageInfo();
/*  73 */     xCrossBattleOwnServerKnockoutInfo.getFight_stage_info_map().put(Integer.valueOf(this.fightStage), xFightStageInfo);
/*     */     
/*  75 */     int maxFightZoneId = CrossBattleKnockoutManager.getMaxFightZone(this.activityCfgId, this.knockOutType);
/*  76 */     if (maxFightZoneId < 0)
/*     */     {
/*  78 */       return false;
/*     */     }
/*     */     
/*  81 */     JSONObject jsonObject = new JSONObject(this.knockOutOwnServerJsonStr);
/*  82 */     for (int fightZoneId = 1; fightZoneId <= maxFightZoneId; fightZoneId++)
/*     */     {
/*  84 */       JSONArray indexJsonArray = jsonObject.getJSONArray(String.valueOf(fightZoneId));
/*  85 */       int arraySize = indexJsonArray.length();
/*  86 */       for (int index = 0; index < arraySize; index++)
/*     */       {
/*  88 */         JSONObject fightIndexJsonObject = indexJsonArray.getJSONObject(index);
/*     */         
/*  90 */         FightAgainstInfo xFightAgainstInfo = Pod.newFightAgainstInfo();
/*     */         
/*  92 */         if (fightIndexJsonObject.has("a_corps_id"))
/*     */         {
/*  94 */           long aCorpsId = fightIndexJsonObject.getLong("a_corps_id");
/*  95 */           xFightAgainstInfo.setA_corps_id(aCorpsId);
/*     */         }
/*     */         
/*  98 */         if (fightIndexJsonObject.has("b_corps_id"))
/*     */         {
/* 100 */           long bCorpsId = fightIndexJsonObject.getLong("b_corps_id");
/* 101 */           xFightAgainstInfo.setB_corps_id(bCorpsId);
/*     */         }
/*     */         
/* 104 */         if (fightIndexJsonObject.has("a_corps_result"))
/*     */         {
/* 106 */           int a_corps_result = fightIndexJsonObject.getInt("a_corps_result");
/* 107 */           xFightAgainstInfo.setA_corps_id_result(a_corps_result);
/*     */         }
/*     */         
/* 110 */         if (fightIndexJsonObject.has("b_corps_result"))
/*     */         {
/* 112 */           int b_corps_result = fightIndexJsonObject.getInt("b_corps_result");
/* 113 */           xFightAgainstInfo.setB_corps_id_result(b_corps_result);
/*     */         }
/*     */         
/* 116 */         if (fightIndexJsonObject.has("cal_result"))
/*     */         {
/* 118 */           Integer fightResult = Integer.valueOf(fightIndexJsonObject.getInt("cal_result"));
/* 119 */           xFightAgainstInfo.setCal_fight_result(fightResult.intValue());
/*     */         }
/*     */         
/* 122 */         if (fightIndexJsonObject.has("fight_status"))
/*     */         {
/* 124 */           Integer fightStatus = Integer.valueOf(fightIndexJsonObject.getInt("fight_status"));
/* 125 */           xFightAgainstInfo.setFight_status(fightStatus.intValue());
/*     */         }
/*     */         
/* 128 */         if (fightIndexJsonObject.has("fight_record_id"))
/*     */         {
/* 130 */           Long fightRecordId = Long.valueOf(fightIndexJsonObject.getLong("fight_record_id"));
/* 131 */           xFightAgainstInfo.setRecord_id(fightRecordId.longValue());
/*     */         }
/* 133 */         xFightStageInfo.getFight_against_info_list().add(xFightAgainstInfo);
/*     */       }
/*     */     }
/*     */     
/* 137 */     JSONArray corpsIdArray = jsonObject.getJSONArray("corps_id_array");
/* 138 */     int corpsIdLength = corpsIdArray.length();
/* 139 */     for (int index = 0; index < corpsIdLength; index++)
/*     */     {
/* 141 */       FightCorpsInfo xFightCorpsInfo = Pod.newFightCorpsInfo();
/* 142 */       JSONObject corpsJsonObj = corpsIdArray.getJSONObject(index);
/* 143 */       int zoneId = corpsJsonObj.getInt("zone_id");
/* 144 */       long corpsId = corpsJsonObj.getLong("corps_id");
/* 145 */       String corpsName = corpsJsonObj.getString("corps_name");
/* 146 */       int corpsBadgeId = corpsJsonObj.getInt("corps_badge_id");
/*     */       
/* 148 */       xFightCorpsInfo.setCorps_id(corpsId);
/* 149 */       xFightCorpsInfo.setCorps_zone_id(zoneId);
/* 150 */       xFightCorpsInfo.setCorps_name(corpsName);
/* 151 */       xFightCorpsInfo.setCorps_badge_id(corpsBadgeId);
/*     */       
/* 153 */       xCrossBattleOwnServerKnockoutInfo.getFight_corps_info_map().put(Long.valueOf(corpsId), xFightCorpsInfo);
/*     */     }
/*     */     
/* 156 */     new PNotifyKnockOutOwnServerFight(this.roleId, this.activityCfgId, this.fightStage, this.knockOutType).execute();
/* 157 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\knockout\PInitKnockOutOwnServerData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
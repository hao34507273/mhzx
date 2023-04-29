/*     */ package mzm.gsp.crossbattle.knockout;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.crossbattle.confbean.KnockOutCfg;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattleKnockOutCfg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import org.json.JSONArray;
/*     */ import org.json.JSONObject;
/*     */ import xbean.CrossBattleKnockoutActivityInfo;
/*     */ import xbean.CrossBattleKnockoutInfo;
/*     */ import xbean.FightAgainstInfo;
/*     */ import xbean.FightCorpsInfo;
/*     */ import xbean.FightStageInfo;
/*     */ import xbean.FightZoneInfo;
/*     */ import xbean.Pod;
/*     */ import xtable.Cross_battle_knockout;
/*     */ 
/*     */ class PInitKnockOutData extends LogicProcedure
/*     */ {
/*     */   private final int retCode;
/*     */   private final int activityCfgId;
/*     */   private final int knockOutType;
/*     */   private final int fightZoneId;
/*     */   private final String knockJsonStr;
/*     */   
/*     */   public PInitKnockOutData(int retCode, int activityCfgId, int knockOutType, int fightZoneId, String selectionJsonStr)
/*     */   {
/*  32 */     this.retCode = retCode;
/*  33 */     this.activityCfgId = activityCfgId;
/*  34 */     this.knockOutType = knockOutType;
/*  35 */     this.fightZoneId = fightZoneId;
/*  36 */     this.knockJsonStr = selectionJsonStr;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  42 */     if (this.retCode != 0)
/*     */     {
/*  44 */       onFail(-1);
/*  45 */       return false;
/*     */     }
/*     */     
/*  48 */     if ((this.knockOutType == 2) && (this.fightZoneId != CrossBattleKnockoutManager.GLOBAL_FIGHT_ZONE))
/*     */     {
/*  50 */       onFail(-2);
/*  51 */       return false;
/*     */     }
/*     */     
/*  54 */     SCrossBattleKnockOutCfg sCrossBattleKnockOutCfg = SCrossBattleKnockOutCfg.get(this.activityCfgId);
/*  55 */     if (sCrossBattleKnockOutCfg == null)
/*     */     {
/*  57 */       onFail(-3);
/*  58 */       return false;
/*     */     }
/*     */     
/*  61 */     KnockOutCfg knockOutCfg = (KnockOutCfg)sCrossBattleKnockOutCfg.knockOutTypeCfgMap.get(Integer.valueOf(this.knockOutType));
/*  62 */     if (knockOutCfg == null)
/*     */     {
/*  64 */       onFail(-4);
/*  65 */       return false;
/*     */     }
/*     */     
/*  68 */     long globalActivityCfgid = GameServerInfoManager.toGlobalId(this.activityCfgId);
/*     */     
/*  70 */     CrossBattleKnockoutActivityInfo xCrossBattleKnockoutActivityInfo = Cross_battle_knockout.get(Long.valueOf(globalActivityCfgid));
/*  71 */     if (xCrossBattleKnockoutActivityInfo == null)
/*     */     {
/*  73 */       xCrossBattleKnockoutActivityInfo = Pod.newCrossBattleKnockoutActivityInfo();
/*  74 */       Cross_battle_knockout.add(Long.valueOf(globalActivityCfgid), xCrossBattleKnockoutActivityInfo);
/*     */     }
/*     */     
/*  77 */     CrossBattleKnockoutInfo xCrossBattleKnockoutInfo = (CrossBattleKnockoutInfo)xCrossBattleKnockoutActivityInfo.getKnockout_info_map().get(Integer.valueOf(this.knockOutType));
/*     */     
/*  79 */     if (xCrossBattleKnockoutInfo == null)
/*     */     {
/*  81 */       xCrossBattleKnockoutInfo = Pod.newCrossBattleKnockoutInfo();
/*  82 */       xCrossBattleKnockoutActivityInfo.getKnockout_info_map().put(Integer.valueOf(this.knockOutType), xCrossBattleKnockoutInfo);
/*     */     }
/*     */     
/*  85 */     FightZoneInfo xOldFightZoneInfo = (FightZoneInfo)xCrossBattleKnockoutInfo.getFight_zone_info_map().get(Integer.valueOf(this.fightZoneId));
/*  86 */     if (xOldFightZoneInfo != null)
/*     */     {
/*  88 */       xCrossBattleKnockoutInfo.getFight_zone_info_map().remove(Integer.valueOf(this.fightZoneId));
/*     */     }
/*     */     
/*  91 */     FightZoneInfo xFightZoneInfo = Pod.newFightZoneInfo();
/*  92 */     xCrossBattleKnockoutInfo.getFight_zone_info_map().put(Integer.valueOf(this.fightZoneId), xFightZoneInfo);
/*     */     
/*  94 */     JSONObject jsonObject = new JSONObject(this.knockJsonStr);
/*     */     
/*     */ 
/*  97 */     JSONArray corpsIdArray = jsonObject.getJSONArray("corps_id_array");
/*  98 */     int corpsIdLength = corpsIdArray.length();
/*  99 */     for (int index = 0; index < corpsIdLength; index++)
/*     */     {
/* 101 */       FightCorpsInfo xFightCorpsInfo = Pod.newFightCorpsInfo();
/* 102 */       JSONObject corpsJsonObj = corpsIdArray.getJSONObject(index);
/* 103 */       int zoneId = corpsJsonObj.getInt("zone_id");
/* 104 */       long corpsId = corpsJsonObj.getLong("corps_id");
/* 105 */       String corpsName = corpsJsonObj.getString("corps_name");
/* 106 */       int corpsBadgeId = corpsJsonObj.getInt("corps_badge_id");
/*     */       
/* 108 */       xFightCorpsInfo.setCorps_id(corpsId);
/* 109 */       xFightCorpsInfo.setCorps_zone_id(zoneId);
/* 110 */       xFightCorpsInfo.setCorps_name(corpsName);
/* 111 */       xFightCorpsInfo.setCorps_badge_id(corpsBadgeId);
/*     */       
/* 113 */       xFightZoneInfo.getFight_corps_info_map().put(Long.valueOf(corpsId), xFightCorpsInfo);
/*     */     }
/*     */     
/* 116 */     JSONArray stageJsonArray = jsonObject.getJSONArray("stage_array");
/* 117 */     int stageLength = stageJsonArray.length();
/* 118 */     for (int index = 0; index < stageLength; index++)
/*     */     {
/* 120 */       JSONObject stageJsonObj = stageJsonArray.getJSONObject(index);
/* 121 */       int stage = stageJsonObj.getInt("stage");
/*     */       
/* 123 */       FightStageInfo xFightStageInfo = Pod.newFightStageInfo();
/* 124 */       xFightZoneInfo.getFight_stage_info_map().put(Integer.valueOf(stage), xFightStageInfo);
/*     */       
/* 126 */       JSONArray fightIndexJsonArray = stageJsonObj.getJSONArray("index_array");
/* 127 */       int fightIndexLength = fightIndexJsonArray.length();
/*     */       
/* 129 */       for (int fightIndexId = 0; fightIndexId < fightIndexLength; fightIndexId++)
/*     */       {
/* 131 */         JSONObject fightIndexJsonObject = fightIndexJsonArray.getJSONObject(fightIndexId);
/* 132 */         int fightIndex = fightIndexJsonObject.getInt("index");
/* 133 */         FightAgainstInfo xFightAgainstInfo = Pod.newFightAgainstInfo();
/*     */         
/* 135 */         if (fightIndexJsonObject.has("a_corps_id"))
/*     */         {
/* 137 */           long aCorpsId = fightIndexJsonObject.getLong("a_corps_id");
/* 138 */           xFightAgainstInfo.setA_corps_id(aCorpsId);
/*     */         }
/*     */         
/* 141 */         if (fightIndexJsonObject.has("b_corps_id"))
/*     */         {
/* 143 */           long bCorpsId = fightIndexJsonObject.getLong("b_corps_id");
/* 144 */           xFightAgainstInfo.setB_corps_id(bCorpsId);
/*     */         }
/*     */         
/* 147 */         if (fightIndexJsonObject.has("a_corps_result"))
/*     */         {
/* 149 */           int a_corps_result = fightIndexJsonObject.getInt("a_corps_result");
/* 150 */           xFightAgainstInfo.setA_corps_id_result(a_corps_result);
/*     */         }
/*     */         
/* 153 */         if (fightIndexJsonObject.has("b_corps_result"))
/*     */         {
/* 155 */           int b_corps_result = fightIndexJsonObject.getInt("b_corps_result");
/* 156 */           xFightAgainstInfo.setB_corps_id_result(b_corps_result);
/*     */         }
/*     */         
/* 159 */         if (fightIndexJsonObject.has("cal_result"))
/*     */         {
/* 161 */           Integer fightResult = Integer.valueOf(fightIndexJsonObject.getInt("cal_result"));
/* 162 */           xFightAgainstInfo.setCal_fight_result(fightResult.intValue());
/*     */         }
/*     */         
/* 165 */         if (fightIndexJsonObject.has("fight_status"))
/*     */         {
/* 167 */           Integer fightStatus = Integer.valueOf(fightIndexJsonObject.getInt("fight_status"));
/* 168 */           xFightAgainstInfo.setFight_status(fightStatus.intValue());
/*     */         }
/*     */         
/* 171 */         if (fightIndexJsonObject.has("fight_record_id"))
/*     */         {
/* 173 */           String fightRecordId = fightIndexJsonObject.getString("fight_record_id");
/* 174 */           xFightAgainstInfo.setRecord_id(Long.valueOf(fightRecordId).longValue());
/*     */         }
/*     */         
/* 177 */         xFightStageInfo.getFight_against_info_map().put(Integer.valueOf(fightIndex), xFightAgainstInfo);
/*     */       }
/*     */     }
/* 180 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int ret)
/*     */   {
/* 185 */     StringBuilder sBuilder = new StringBuilder();
/* 186 */     sBuilder.append("[crossbattle_knockout]PInitKnockOutData.processImp@get knockout data fail");
/* 187 */     sBuilder.append("|ret_code=").append(this.retCode);
/* 188 */     sBuilder.append("|activity_cfg_id=").append(this.activityCfgId);
/* 189 */     sBuilder.append("|knockout_type=").append(this.knockOutType);
/* 190 */     sBuilder.append("|fight_zone_id=").append(this.fightZoneId);
/* 191 */     sBuilder.append("|knock_out_json=").append(this.knockJsonStr);
/* 192 */     sBuilder.append("|ret=").append(ret);
/*     */     
/* 194 */     GameServer.logger().error(sBuilder.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\knockout\PInitKnockOutData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
/*     */ package mzm.gsp.crossbattle.knockout;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.TreeMap;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.crossbattle.CorpsInfo;
/*     */ import mzm.gsp.crossbattle.KnockOutStageFightInfo;
/*     */ import mzm.gsp.crossbattle.SCrossBattleSelectionNormalRes;
/*     */ import mzm.gsp.crossbattle.SGetCrossBattleFinalFightSuccess;
/*     */ import mzm.gsp.crossbattle.SGetCrossBattleSelectionFightSuccess;
/*     */ import mzm.gsp.crossbattle.confbean.CrossBattleConsts;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.util.Pair;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.CrossBattleKnockoutActivityInfo;
/*     */ import xbean.CrossBattleKnockoutInfo;
/*     */ import xbean.FightCorpsInfo;
/*     */ import xbean.FightStageInfo;
/*     */ import xbean.FightZoneInfo;
/*     */ import xio.Protocol;
/*     */ 
/*     */ public class PCGetCrossBattleKnockOutFightReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int knockOutType;
/*     */   private int nowActivityCfgId;
/*     */   private int nowFightZone;
/*     */   
/*     */   public PCGetCrossBattleKnockOutFightReq(long roleId, int activityCfgId, int knockOutType)
/*     */   {
/*  34 */     this.roleId = roleId;
/*  35 */     this.knockOutType = knockOutType;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  41 */     this.nowActivityCfgId = CrossBattleConsts.getInstance().CURRENT_ACTIVITY_CFG_ID;
/*     */     
/*  43 */     if (!CrossBattleKnockoutManager.isCrossBattleKnockOutSwitchOpen(this.roleId, this.nowActivityCfgId, this.knockOutType))
/*     */     {
/*  45 */       onNotifyFailed(25);
/*  46 */       return false;
/*     */     }
/*     */     
/*  49 */     String userId = mzm.gsp.role.main.RoleInterface.getUserId(this.roleId);
/*  50 */     lock(xdb.Lockeys.get(xtable.User.getTable(), userId));
/*     */     
/*  52 */     long corpsId = mzm.gsp.corps.main.CorpsInterface.getRoleCorpsId(this.roleId, true);
/*     */     
/*  54 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 1556, true, true))
/*     */     {
/*  56 */       return false;
/*     */     }
/*     */     
/*  59 */     long globalActivityCfgid = mzm.gsp.GameServerInfoManager.toGlobalId(this.nowActivityCfgId);
/*  60 */     CrossBattleKnockoutActivityInfo xCrossBattleKnockoutActivityInfo = xtable.Cross_battle_knockout.get(Long.valueOf(globalActivityCfgid));
/*     */     
/*  62 */     if (xCrossBattleKnockoutActivityInfo == null)
/*     */     {
/*  64 */       onNotifyFailed(4);
/*  65 */       return false;
/*     */     }
/*     */     
/*  68 */     this.nowFightZone = CrossBattleKnockoutManager.getFightZone(corpsId, this.nowActivityCfgId, this.knockOutType);
/*  69 */     if (this.nowFightZone < 0)
/*     */     {
/*  71 */       return false;
/*     */     }
/*     */     
/*  74 */     CrossBattleKnockoutInfo xCrossBattleKnockoutInfo = (CrossBattleKnockoutInfo)xCrossBattleKnockoutActivityInfo.getKnockout_info_map().get(Integer.valueOf(this.knockOutType));
/*     */     
/*  76 */     if (xCrossBattleKnockoutInfo == null)
/*     */     {
/*  78 */       onNotifyFailed(5);
/*  79 */       return false;
/*     */     }
/*     */     
/*  82 */     FightZoneInfo xFightZoneInfo = (FightZoneInfo)xCrossBattleKnockoutInfo.getFight_zone_info_map().get(Integer.valueOf(this.nowFightZone));
/*  83 */     if (xFightZoneInfo == null)
/*     */     {
/*  85 */       return false;
/*     */     }
/*     */     
/*  88 */     Map<Long, CorpsInfo> corpsInfoMap = new HashMap();
/*  89 */     Map<Long, FightCorpsInfo> xFightCorpsInfoMap = xFightZoneInfo.getFight_corps_info_map();
/*     */     
/*  91 */     for (Map.Entry<Long, FightCorpsInfo> entry : xFightCorpsInfoMap.entrySet())
/*     */     {
/*  93 */       FightCorpsInfo xFightCorpsInfo = (FightCorpsInfo)entry.getValue();
/*     */       
/*  95 */       CorpsInfo corpsInfo = new CorpsInfo();
/*  96 */       corpsInfo.zone_id = xFightCorpsInfo.getCorps_zone_id();
/*  97 */       corpsInfo.corps_id = xFightCorpsInfo.getCorps_id();
/*  98 */       corpsInfo.corps_icon = xFightCorpsInfo.getCorps_badge_id();
/*  99 */       corpsInfo.corps_name.setString(xFightCorpsInfo.getCorps_name(), "UTF-8");
/*     */       
/* 101 */       corpsInfoMap.put(entry.getKey(), corpsInfo);
/*     */     }
/* 103 */     Map<Integer, KnockOutStageFightInfo> knockOutStageFightInfoMap = new HashMap();
/* 104 */     for (Map.Entry<Integer, FightStageInfo> stage2FightInfoEntry : xFightZoneInfo.getFight_stage_info_map().entrySet())
/*     */     {
/* 106 */       FightStageInfo xFightStageInfo = (FightStageInfo)stage2FightInfoEntry.getValue();
/* 107 */       int xStage = ((Integer)stage2FightInfoEntry.getKey()).intValue();
/*     */       
/* 109 */       TreeMap<Integer, mzm.gsp.crossbattle.FightAgainstInfo> selectionFightInfoMap = new TreeMap();
/* 110 */       for (Map.Entry<Integer, xbean.FightAgainstInfo> indexId2FightInfoEntry : xFightStageInfo.getFight_against_info_map().entrySet())
/*     */       {
/* 112 */         int xfightIndexId = ((Integer)indexId2FightInfoEntry.getKey()).intValue();
/* 113 */         xbean.FightAgainstInfo xFightAgainstInfo = (xbean.FightAgainstInfo)indexId2FightInfoEntry.getValue();
/*     */         
/* 115 */         mzm.gsp.crossbattle.FightAgainstInfo fightAgainstInfo = new mzm.gsp.crossbattle.FightAgainstInfo();
/* 116 */         fightAgainstInfo.corps_a_id = xFightAgainstInfo.getA_corps_id();
/* 117 */         fightAgainstInfo.corps_b_id = xFightAgainstInfo.getB_corps_id();
/*     */         
/* 119 */         fightAgainstInfo.corps_a_state = xFightAgainstInfo.getA_corps_id_result();
/* 120 */         fightAgainstInfo.corps_b_state = xFightAgainstInfo.getB_corps_id_result();
/* 121 */         fightAgainstInfo.cal_fight_result = xFightAgainstInfo.getCal_fight_result();
/* 122 */         selectionFightInfoMap.put(Integer.valueOf(xfightIndexId), fightAgainstInfo);
/*     */       }
/* 124 */       ArrayList<mzm.gsp.crossbattle.FightAgainstInfo> selectionFightInfoList = new ArrayList();
/* 125 */       selectionFightInfoList.addAll(selectionFightInfoMap.values());
/*     */       
/* 127 */       knockOutStageFightInfoMap.put(Integer.valueOf(xStage), new KnockOutStageFightInfo(selectionFightInfoList));
/*     */     }
/*     */     
/* 130 */     Pair<Integer, Boolean> nowSelectionStagePair = CrossBattleKnockoutInterface.getNowFightStage(this.knockOutType);
/* 131 */     if (nowSelectionStagePair == null)
/*     */     {
/* 133 */       return false;
/*     */     }
/*     */     
/* 136 */     Protocol protocol = getFightStageInfoProtocol(corpsInfoMap, knockOutStageFightInfoMap, this.nowFightZone, ((Integer)nowSelectionStagePair.first).intValue());
/*     */     
/*     */ 
/* 139 */     OnlineManager.getInstance().send(this.roleId, protocol);
/*     */     
/* 141 */     StringBuilder sb = new StringBuilder();
/* 142 */     sb.append("[crossbattle_selection]PCGetCrossBattleSelectionFightReq.processImp@get success");
/* 143 */     sb.append("|role_id=").append(this.roleId);
/* 144 */     sb.append("|activity_cfg_id=").append(this.nowActivityCfgId);
/* 145 */     sb.append("|now_fight_zone=").append(this.nowFightZone);
/*     */     
/* 147 */     GameServer.logger().info(sb.toString());
/*     */     
/* 149 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private Protocol getFightStageInfoProtocol(Map<Long, CorpsInfo> corpsInfoMap, Map<Integer, KnockOutStageFightInfo> stageFightInfoMap, int fightZoneId, int nowStage)
/*     */   {
/* 156 */     switch (this.knockOutType)
/*     */     {
/*     */     case 1: 
/* 159 */       SGetCrossBattleSelectionFightSuccess selectionSuccess = new SGetCrossBattleSelectionFightSuccess();
/* 160 */       selectionSuccess.selection_fight_corps_map.putAll(corpsInfoMap);
/* 161 */       selectionSuccess.selection_stage = nowStage;
/* 162 */       selectionSuccess.selection_stage_fight_info_map.putAll(stageFightInfoMap);
/* 163 */       return selectionSuccess;
/*     */     
/*     */     case 2: 
/* 166 */       SGetCrossBattleFinalFightSuccess finalSuccess = new SGetCrossBattleFinalFightSuccess();
/* 167 */       finalSuccess.final_fight_corps_map.putAll(corpsInfoMap);
/* 168 */       finalSuccess.final_stage = nowStage;
/* 169 */       finalSuccess.final_stage_fight_info_map.putAll(stageFightInfoMap);
/* 170 */       return finalSuccess;
/*     */     }
/* 172 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */   private void onNotifyFailed(int ret)
/*     */   {
/* 178 */     onNotifyFailed(ret, null);
/*     */   }
/*     */   
/*     */   private void onNotifyFailed(int ret, Map<String, Object> extraMap)
/*     */   {
/* 183 */     StringBuilder sb = new StringBuilder();
/* 184 */     sb.append("[crossbattle_selection]PCGetCrossBattleSelectionFightReq.processImp@error");
/* 185 */     sb.append("|role_id=").append(this.roleId);
/* 186 */     sb.append("|ret=").append(ret);
/* 187 */     sb.append("|activity_cfg_id=").append(this.nowActivityCfgId);
/* 188 */     sb.append("|now_fight_zone=").append(this.nowFightZone);
/*     */     
/* 190 */     if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */     {
/* 192 */       for (Map.Entry<String, Object> entry : extraMap.entrySet())
/*     */       {
/* 194 */         sb.append("|").append((String)entry.getKey()).append("=").append(entry.getValue());
/*     */       }
/*     */     }
/*     */     
/* 198 */     GameServer.logger().error(sb.toString());
/*     */     
/* 200 */     SCrossBattleSelectionNormalRes sCrossBattleSelectionNormalRes = new SCrossBattleSelectionNormalRes();
/* 201 */     sCrossBattleSelectionNormalRes.ret = ret;
/*     */     
/* 203 */     OnlineManager.getInstance().sendAtOnce(this.roleId, sCrossBattleSelectionNormalRes);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\knockout\PCGetCrossBattleKnockOutFightReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
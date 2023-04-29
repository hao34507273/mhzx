/*     */ package mzm.gsp.crossbattle.knockout;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.TreeMap;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.crossbattle.CorpsInfo;
/*     */ import mzm.gsp.crossbattle.GetKnockOutContext;
/*     */ import mzm.gsp.crossbattle.GetKnockOutContext_GetSpecialFightZoneStage;
/*     */ import mzm.gsp.crossbattle.KnockOutStageFightInfo;
/*     */ import mzm.gsp.crossbattle.SGetCrossBattleFinalFightStageSuccess;
/*     */ import mzm.gsp.crossbattle.SGetCrossBattleSelectionFightStageSuccess;
/*     */ import mzm.gsp.crossbattle.confbean.CrossBattleConsts;
/*     */ import mzm.gsp.crossbattle.confbean.KnockOutCfg;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattleKnockOutCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.Pair;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.CrossBattleKnockoutActivityInfo;
/*     */ import xbean.CrossBattleKnockoutInfo;
/*     */ import xbean.FightCorpsInfo;
/*     */ import xbean.FightStageInfo;
/*     */ import xbean.FightZoneInfo;
/*     */ import xio.Protocol;
/*     */ import xtable.Cross_battle_knockout;
/*     */ 
/*     */ public class PCGetCrossBattleKnockOutFightStageReq extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int knockOutType;
/*     */   private final int fightZoneId;
/*     */   private final int fightStage;
/*     */   private int activityCfgId;
/*     */   
/*     */   public PCGetCrossBattleKnockOutFightStageReq(long roleId, int fightZoneId, int selectionStage, int knockOutType)
/*     */   {
/*  43 */     this.roleId = roleId;
/*  44 */     this.knockOutType = knockOutType;
/*  45 */     this.fightZoneId = fightZoneId;
/*  46 */     this.fightStage = selectionStage;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  52 */     int maxFightZondId = mzm.gsp.crossbattle.point.CrossBattlePointInterface.getZoneNum();
/*  53 */     if ((this.fightZoneId < 0) || (this.fightZoneId > maxFightZondId))
/*     */     {
/*  55 */       onGetCrossBattleSelectionFightStageReqFail(26);
/*  56 */       return false;
/*     */     }
/*     */     
/*  59 */     this.activityCfgId = CrossBattleConsts.getInstance().CURRENT_ACTIVITY_CFG_ID;
/*  60 */     if (!CrossBattleKnockoutManager.isCrossBattleKnockOutSwitchOpen(this.roleId, this.activityCfgId, this.knockOutType))
/*     */     {
/*  62 */       onGetCrossBattleSelectionFightStageReqFail(25);
/*  63 */       return false;
/*     */     }
/*     */     
/*  66 */     SCrossBattleKnockOutCfg sCrossBattleKnockOutCfg = SCrossBattleKnockOutCfg.get(this.activityCfgId);
/*  67 */     if (sCrossBattleKnockOutCfg == null)
/*     */     {
/*  69 */       onGetCrossBattleSelectionFightStageReqFail(12);
/*  70 */       return false;
/*     */     }
/*     */     
/*  73 */     KnockOutCfg knockOutCfg = (KnockOutCfg)sCrossBattleKnockOutCfg.knockOutTypeCfgMap.get(Integer.valueOf(this.knockOutType));
/*  74 */     if (knockOutCfg == null)
/*     */     {
/*  76 */       return false;
/*     */     }
/*     */     
/*  79 */     Pair<Integer, Boolean> pair = CrossBattleKnockoutInterface.getNowFightStage(this.knockOutType);
/*  80 */     if (pair == null)
/*     */     {
/*  82 */       onGetCrossBattleSelectionFightStageReqFail(23);
/*  83 */       return false;
/*     */     }
/*     */     
/*  86 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 1557, true, true))
/*     */     {
/*  88 */       return false;
/*     */     }
/*     */     
/*  91 */     boolean isNeedRefresh = ((Boolean)pair.second).booleanValue();
/*     */     
/*  93 */     long globalActivityCfgid = GameServerInfoManager.toGlobalId(this.activityCfgId);
/*  94 */     CrossBattleKnockoutActivityInfo xCrossBattleKnockoutActivityInfo = Cross_battle_knockout.get(Long.valueOf(globalActivityCfgid));
/*     */     
/*  96 */     CrossBattleKnockoutInfo xCrossBattleKnockoutInfo = null;
/*  97 */     if (xCrossBattleKnockoutActivityInfo != null)
/*     */     {
/*  99 */       xCrossBattleKnockoutInfo = (CrossBattleKnockoutInfo)xCrossBattleKnockoutActivityInfo.getKnockout_info_map().get(Integer.valueOf(this.knockOutType));
/*     */     }
/*     */     
/* 102 */     FightZoneInfo xFightZoneInfo = null;
/* 103 */     if (xCrossBattleKnockoutInfo != null)
/*     */     {
/* 105 */       xFightZoneInfo = (FightZoneInfo)xCrossBattleKnockoutInfo.getFight_zone_info_map().get(Integer.valueOf(this.fightZoneId));
/*     */     }
/*     */     
/* 108 */     if ((xCrossBattleKnockoutActivityInfo == null) || (xCrossBattleKnockoutInfo == null) || (xFightZoneInfo == null) || (isNeedRefresh))
/*     */     {
/*     */ 
/* 111 */       GetKnockOutContext_GetSpecialFightZoneStage getSpecialFightZoneStage = new GetKnockOutContext_GetSpecialFightZoneStage(this.roleId, this.fightStage);
/*     */       
/*     */ 
/* 114 */       OctetsStream octetsStream = new OctetsStream();
/* 115 */       octetsStream.marshal(getSpecialFightZoneStage);
/*     */       
/* 117 */       GetKnockOutContext getKnockOutContext = new GetKnockOutContext();
/* 118 */       getKnockOutContext.oper_type = 1;
/* 119 */       getKnockOutContext.content = octetsStream;
/*     */       
/* 121 */       int nowFightStage = ((Integer)pair.first).intValue();
/* 122 */       return mzm.gsp.grc.main.GrcInterface.getCrossBattleKnockOutInfo(this.activityCfgId, this.knockOutType, this.fightZoneId, nowFightStage, knockOutCfg.need_team_size, knockOutCfg.stage_time_point_cfg_id_list.size(), knockOutCfg.fight_times_every_stage, new OctetsStream().marshal(getKnockOutContext));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 127 */     new PNotifyGetCrossBattleKnockOutFightStageReq(this.roleId, this.activityCfgId, this.knockOutType, this.fightZoneId, this.fightStage).execute();
/*     */     
/* 129 */     return true;
/*     */   }
/*     */   
/*     */   private void onGetCrossBattleSelectionFightStageReqFail(int ret)
/*     */   {
/* 134 */     StringBuilder sb = new StringBuilder();
/* 135 */     sb.append("[crossbattle_selection]PCGetCrossBattleSelectionFightStageReq.processImp@error");
/* 136 */     sb.append("ret=").append(ret);
/* 137 */     sb.append("role_id=").append(this.roleId);
/* 138 */     sb.append("activity_cfg_id=").append(this.activityCfgId);
/* 139 */     sb.append("fight_zone_id=").append(this.fightZoneId);
/* 140 */     sb.append("selection_stage=").append(this.fightStage);
/*     */     
/* 142 */     GameServer.logger().error(sb.toString());
/*     */     
/* 144 */     Protocol normalRes = CrossBattleKnockoutManager.getNormalRes(this.knockOutType, ret);
/*     */     
/* 146 */     OnlineManager.getInstance().sendAtOnce(this.roleId, normalRes);
/*     */   }
/*     */   
/*     */   public static class PNotifyGetCrossBattleKnockOutFightStageReq
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final long roleId;
/*     */     private final int activityCfgId;
/*     */     private final int knockOutType;
/*     */     private final int fightZoneId;
/*     */     private final int fightStage;
/*     */     
/*     */     public PNotifyGetCrossBattleKnockOutFightStageReq(long roleId, int activityCfgId, int knockOutType, int fightZoneId, int selectionStage)
/*     */     {
/* 160 */       this.roleId = roleId;
/* 161 */       this.activityCfgId = activityCfgId;
/* 162 */       this.knockOutType = knockOutType;
/* 163 */       this.fightZoneId = fightZoneId;
/* 164 */       this.fightStage = selectionStage;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 170 */       String userId = mzm.gsp.role.main.RoleInterface.getUserId(this.roleId);
/* 171 */       lock(xdb.Lockeys.get(xtable.User.getTable(), userId));
/*     */       
/* 173 */       long globalActivityCfgid = GameServerInfoManager.toGlobalId(this.activityCfgId);
/* 174 */       CrossBattleKnockoutActivityInfo xCrossBattleKnockoutActivityInfo = Cross_battle_knockout.get(Long.valueOf(globalActivityCfgid));
/* 175 */       if (xCrossBattleKnockoutActivityInfo == null)
/*     */       {
/* 177 */         onNotifyFailed(4);
/* 178 */         return false;
/*     */       }
/*     */       
/* 181 */       CrossBattleKnockoutInfo xCrossBattleKnockoutInfo = (CrossBattleKnockoutInfo)xCrossBattleKnockoutActivityInfo.getKnockout_info_map().get(Integer.valueOf(this.knockOutType));
/*     */       
/* 183 */       if (xCrossBattleKnockoutInfo == null)
/*     */       {
/* 185 */         return false;
/*     */       }
/*     */       
/* 188 */       FightZoneInfo xFightZoneInfo = (FightZoneInfo)xCrossBattleKnockoutInfo.getFight_zone_info_map().get(Integer.valueOf(this.fightZoneId));
/* 189 */       if (xFightZoneInfo == null)
/*     */       {
/* 191 */         onNotifyFailed(5);
/* 192 */         return false;
/*     */       }
/*     */       
/* 195 */       SCrossBattleKnockOutCfg sCrossBattleKnockOutCfg = SCrossBattleKnockOutCfg.get(this.activityCfgId);
/* 196 */       if (sCrossBattleKnockOutCfg == null)
/*     */       {
/* 198 */         return false;
/*     */       }
/*     */       
/* 201 */       KnockOutCfg knockOutCfg = (KnockOutCfg)sCrossBattleKnockOutCfg.knockOutTypeCfgMap.get(Integer.valueOf(this.knockOutType));
/* 202 */       if (knockOutCfg == null)
/*     */       {
/* 204 */         return false;
/*     */       }
/*     */       
/* 207 */       Map<Long, CorpsInfo> corpsInfoMap = new HashMap();
/* 208 */       Map<Long, FightCorpsInfo> xFightCorpsInfoMap = xFightZoneInfo.getFight_corps_info_map();
/* 209 */       for (Map.Entry<Long, FightCorpsInfo> entry : xFightCorpsInfoMap.entrySet())
/*     */       {
/* 211 */         FightCorpsInfo xFightCorpsInfo = (FightCorpsInfo)entry.getValue();
/*     */         
/* 213 */         CorpsInfo corpsInfo = new CorpsInfo();
/* 214 */         corpsInfo.zone_id = xFightCorpsInfo.getCorps_zone_id();
/* 215 */         corpsInfo.corps_id = xFightCorpsInfo.getCorps_id();
/* 216 */         corpsInfo.corps_icon = xFightCorpsInfo.getCorps_badge_id();
/* 217 */         corpsInfo.corps_name.setString(xFightCorpsInfo.getCorps_name(), "UTF-8");
/*     */         
/* 219 */         corpsInfoMap.put(entry.getKey(), corpsInfo);
/*     */       }
/*     */       
/* 222 */       FightStageInfo xFightStageInfo = (FightStageInfo)xFightZoneInfo.getFight_stage_info_map().get(Integer.valueOf(this.fightStage));
/* 223 */       if (xFightStageInfo == null)
/*     */       {
/* 225 */         onNotifyFailed(6);
/* 226 */         return false;
/*     */       }
/*     */       
/* 229 */       Pair<Integer, Boolean> nowFightStagePair = CrossBattleKnockoutInterface.getNowFightStage(this.knockOutType);
/* 230 */       if (nowFightStagePair == null)
/*     */       {
/* 232 */         return false;
/*     */       }
/*     */       
/* 235 */       TreeMap<Integer, mzm.gsp.crossbattle.FightAgainstInfo> selectionFightInfoMap = new TreeMap();
/* 236 */       for (Map.Entry<Integer, xbean.FightAgainstInfo> entry : xFightStageInfo.getFight_against_info_map().entrySet())
/*     */       {
/* 238 */         int fightIndexId = ((Integer)entry.getKey()).intValue();
/* 239 */         xbean.FightAgainstInfo xSelectionFightInfo = (xbean.FightAgainstInfo)entry.getValue();
/*     */         
/* 241 */         mzm.gsp.crossbattle.FightAgainstInfo xFightAgainstInfo = new mzm.gsp.crossbattle.FightAgainstInfo();
/* 242 */         xFightAgainstInfo.corps_a_id = xSelectionFightInfo.getA_corps_id();
/* 243 */         xFightAgainstInfo.corps_b_id = xSelectionFightInfo.getB_corps_id();
/* 244 */         xFightAgainstInfo.record_id = xSelectionFightInfo.getRecord_id();
/* 245 */         if (xSelectionFightInfo.getFight_status() == 2)
/*     */         {
/* 247 */           xFightAgainstInfo.corps_a_state = 7;
/* 248 */           xFightAgainstInfo.corps_b_state = 7;
/*     */         }
/*     */         else
/*     */         {
/* 252 */           xFightAgainstInfo.corps_a_state = xSelectionFightInfo.getA_corps_id_result();
/* 253 */           xFightAgainstInfo.corps_b_state = xSelectionFightInfo.getB_corps_id_result();
/*     */         }
/*     */         
/*     */ 
/* 257 */         if ((xFightAgainstInfo.corps_a_state == 0) && (xFightAgainstInfo.corps_b_state == 0) && (xFightAgainstInfo.cal_fight_result == 0) && (knockOutCfg.fight_times_every_stage != 1) && (this.fightStage % knockOutCfg.fight_times_every_stage != 1))
/*     */         {
/*     */ 
/*     */ 
/* 261 */           Pair<Long, Pair<Integer, Integer>> getWinCorpsIdPair = CrossBattleKnockoutManager.getWinCorpsId(xFightZoneInfo.getFight_stage_info_map(), xFightAgainstInfo.corps_a_id, xFightAgainstInfo.corps_b_id, this.fightStage - 1, fightIndexId, knockOutCfg.fight_times_every_stage);
/*     */           
/*     */ 
/*     */ 
/* 265 */           if ((getWinCorpsIdPair != null) && (((Long)getWinCorpsIdPair.first).longValue() != -1L)) {}
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/* 270 */           selectionFightInfoMap.put(Integer.valueOf(fightIndexId), xFightAgainstInfo);
/*     */         }
/*     */       }
/* 273 */       Protocol successProtocol = getStageInfoProtocol(corpsInfoMap, selectionFightInfoMap.values());
/* 274 */       OnlineManager.getInstance().send(this.roleId, successProtocol);
/*     */       
/* 276 */       StringBuilder sb = new StringBuilder();
/* 277 */       sb.append("[crossbattle_knockout]PNotifyCrossBattleSelectionFightZoneStageRes.processImp@get success");
/* 278 */       sb.append("|role_id=").append(this.roleId);
/* 279 */       sb.append("|fight_zone_id=").append(this.fightZoneId);
/* 280 */       sb.append("|selection_stage=").append(this.fightStage);
/* 281 */       sb.append("|activity_cfg_id=").append(this.activityCfgId);
/*     */       
/* 283 */       GameServer.logger().info(sb.toString());
/* 284 */       return true;
/*     */     }
/*     */     
/*     */     private void onNotifyFailed(int ret)
/*     */     {
/* 289 */       onNotifyFailed(ret, null);
/*     */     }
/*     */     
/*     */     private void onNotifyFailed(int ret, Map<String, Object> extraMap)
/*     */     {
/* 294 */       StringBuilder sb = new StringBuilder();
/* 295 */       sb.append("[crossbattle_selection]PNotifyCrossBattleSelectionFightZoneStageRes.processImp@error");
/* 296 */       sb.append("|role_id=").append(this.roleId);
/* 297 */       sb.append("|ret=").append(ret);
/* 298 */       sb.append("|fight_zone_id=").append(this.fightZoneId);
/* 299 */       sb.append("|selection_stage=").append(this.fightStage);
/* 300 */       sb.append("|activity_cfg_id=").append(this.activityCfgId);
/*     */       
/* 302 */       if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */       {
/* 304 */         for (Map.Entry<String, Object> entry : extraMap.entrySet())
/*     */         {
/* 306 */           sb.append("|").append((String)entry.getKey()).append("=").append(entry.getValue());
/*     */         }
/*     */       }
/*     */       
/* 310 */       GameServer.logger().error(sb.toString());
/*     */       
/* 312 */       Protocol normalRes = CrossBattleKnockoutManager.getNormalRes(this.knockOutType, ret);
/*     */       
/* 314 */       OnlineManager.getInstance().sendAtOnce(this.roleId, normalRes);
/*     */     }
/*     */     
/*     */ 
/*     */     private Protocol getStageInfoProtocol(Map<Long, CorpsInfo> corpsInfoMap, Collection<mzm.gsp.crossbattle.FightAgainstInfo> fightAgainstInfoList)
/*     */     {
/* 320 */       switch (this.knockOutType)
/*     */       {
/*     */       case 1: 
/* 323 */         SGetCrossBattleSelectionFightStageSuccess selectionSuccess = new SGetCrossBattleSelectionFightStageSuccess();
/* 324 */         selectionSuccess.fight_zone_id = this.fightZoneId;
/* 325 */         selectionSuccess.selection_fight_corps_map.putAll(corpsInfoMap);
/* 326 */         selectionSuccess.selection_stage = this.fightStage;
/* 327 */         selectionSuccess.selection_stage_fight_info.fight_info_list.addAll(fightAgainstInfoList);
/* 328 */         return selectionSuccess;
/*     */       
/*     */       case 2: 
/* 331 */         SGetCrossBattleFinalFightStageSuccess finalSuccess = new SGetCrossBattleFinalFightStageSuccess();
/* 332 */         finalSuccess.fight_zone_id = this.fightZoneId;
/* 333 */         finalSuccess.final_fight_corps_map.putAll(corpsInfoMap);
/* 334 */         finalSuccess.final_stage = this.fightStage;
/* 335 */         finalSuccess.final_stage_fight_info.fight_info_list.addAll(fightAgainstInfoList);
/* 336 */         return finalSuccess;
/*     */       }
/*     */       
/* 339 */       return null;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\knockout\PCGetCrossBattleKnockOutFightStageReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
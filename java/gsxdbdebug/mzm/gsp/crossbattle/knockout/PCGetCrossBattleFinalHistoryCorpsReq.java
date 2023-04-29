/*     */ package mzm.gsp.crossbattle.knockout;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.crossbattle.GetFightStageEndCorpsInfo;
/*     */ import mzm.gsp.crossbattle.GetFightStageEndCorpsInfo_FinalHistory;
/*     */ import mzm.gsp.crossbattle.GetKnockOutContext;
/*     */ import mzm.gsp.crossbattle.GetKnockOutContext_GetFinalHistoryTopThreeCorpsInfo;
/*     */ import mzm.gsp.crossbattle.SCrossBattleHistoryNormalRes;
/*     */ import mzm.gsp.crossbattle.confbean.CrossBattleConsts;
/*     */ import mzm.gsp.crossbattle.confbean.KnockOutCfg;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattleHistoryCfg;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattleKnockOutCfg;
/*     */ import mzm.gsp.crossbattle.main.CrossBattleOneByOneManager;
/*     */ import mzm.gsp.grc.main.GrcInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.Pair;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.CrossBattleKnockoutActivityInfo;
/*     */ import xbean.CrossBattleKnockoutInfo;
/*     */ import xbean.FightAgainstInfo;
/*     */ import xbean.FightStageInfo;
/*     */ import xbean.FightZoneInfo;
/*     */ import xtable.Cross_battle_knockout;
/*     */ 
/*     */ public class PCGetCrossBattleFinalHistoryCorpsReq extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int rank;
/*     */   private final int session;
/*     */   private final long corpsId;
/*     */   private int activityCfgId;
/*     */   
/*     */   public PCGetCrossBattleFinalHistoryCorpsReq(long roleId, int session, int rank, long corpsId)
/*     */   {
/*  42 */     this.roleId = roleId;
/*  43 */     this.session = session;
/*  44 */     this.rank = rank;
/*  45 */     this.corpsId = corpsId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  51 */     if (!CrossBattleKnockoutManager.isCrossBattleHistorySwitchOpen(this.roleId))
/*     */     {
/*  53 */       onGetCrossBattleFinalHistoryCorpsFail(2);
/*  54 */       return false;
/*     */     }
/*     */     
/*  57 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 1553, true, true))
/*     */     {
/*  59 */       return false;
/*     */     }
/*     */     
/*  62 */     if (this.session > CrossBattleConsts.getInstance().cross_battle_session_num)
/*     */     {
/*  64 */       Map<String, Object> extraMap = new HashMap();
/*  65 */       extraMap.put("current_session", Integer.valueOf(CrossBattleConsts.getInstance().cross_battle_session_num));
/*     */       
/*  67 */       onGetCrossBattleFinalHistoryCorpsFail(8, extraMap);
/*  68 */       return false;
/*     */     }
/*     */     
/*  71 */     SCrossBattleHistoryCfg sCrossBattleHistoryCfg = SCrossBattleHistoryCfg.get(this.session);
/*  72 */     if (sCrossBattleHistoryCfg == null)
/*     */     {
/*  74 */       onGetCrossBattleFinalHistoryCorpsFail(9);
/*  75 */       return false;
/*     */     }
/*     */     
/*  78 */     this.activityCfgId = sCrossBattleHistoryCfg.activity_cfg_id;
/*  79 */     SCrossBattleKnockOutCfg sCrossBattleKnockOutCfg = SCrossBattleKnockOutCfg.get(this.activityCfgId);
/*  80 */     if (sCrossBattleKnockOutCfg == null)
/*     */     {
/*  82 */       onGetCrossBattleFinalHistoryCorpsFail(6);
/*  83 */       return false;
/*     */     }
/*     */     
/*  86 */     KnockOutCfg knockOutCfg = (KnockOutCfg)sCrossBattleKnockOutCfg.knockOutTypeCfgMap.get(Integer.valueOf(2));
/*  87 */     if (knockOutCfg == null)
/*     */     {
/*  89 */       onGetCrossBattleFinalHistoryCorpsFail(7);
/*  90 */       return false;
/*     */     }
/*     */     
/*  93 */     long globalActivityCfgId = GameServerInfoManager.toGlobalId(this.activityCfgId);
/*     */     
/*  95 */     CrossBattleKnockoutActivityInfo xCrossBattleKnockoutActivityInfo = Cross_battle_knockout.get(Long.valueOf(globalActivityCfgId));
/*     */     
/*  97 */     CrossBattleKnockoutInfo xCrossBattleKnockoutInfo = null;
/*  98 */     if (xCrossBattleKnockoutActivityInfo != null)
/*     */     {
/* 100 */       xCrossBattleKnockoutInfo = (CrossBattleKnockoutInfo)xCrossBattleKnockoutActivityInfo.getKnockout_info_map().get(Integer.valueOf(2));
/*     */     }
/*     */     
/* 103 */     FightZoneInfo xFightZoneInfo = null;
/* 104 */     if (xCrossBattleKnockoutInfo != null)
/*     */     {
/* 106 */       xFightZoneInfo = (FightZoneInfo)xCrossBattleKnockoutInfo.getFight_zone_info_map().get(Integer.valueOf(CrossBattleKnockoutManager.GLOBAL_FIGHT_ZONE));
/*     */     }
/*     */     
/* 109 */     if ((xCrossBattleKnockoutActivityInfo == null) || (xCrossBattleKnockoutInfo == null) || (xFightZoneInfo == null))
/*     */     {
/* 111 */       KnockOutHandler knockOutHandler = CrossBattleKnockoutManager.getKnockOutHandler(2);
/* 112 */       if (knockOutHandler == null)
/*     */       {
/* 114 */         onGetCrossBattleFinalHistoryCorpsFail(13);
/* 115 */         return false;
/*     */       }
/*     */       
/* 118 */       long canGetKnockOutInfoTime = knockOutHandler.getCanGetKnockOutInfoTime(this.activityCfgId);
/* 119 */       if (canGetKnockOutInfoTime < mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis())
/*     */       {
/* 121 */         onGetCrossBattleFinalHistoryCorpsFail(15);
/* 122 */         return false;
/*     */       }
/* 124 */       GetKnockOutContext_GetFinalHistoryTopThreeCorpsInfo context = new GetKnockOutContext_GetFinalHistoryTopThreeCorpsInfo(this.session, this.roleId, this.rank, this.corpsId);
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 129 */       OctetsStream octetsStream = new OctetsStream();
/* 130 */       octetsStream.marshal(context);
/*     */       
/* 132 */       GetKnockOutContext getKnockOutContext = new GetKnockOutContext();
/* 133 */       getKnockOutContext.oper_type = 12;
/* 134 */       getKnockOutContext.content = octetsStream;
/*     */       
/* 136 */       Pair<Integer, Boolean> nowFightStagePair = CrossBattleKnockoutInterface.getNowFightStage(this.activityCfgId, 2);
/*     */       
/* 138 */       if (nowFightStagePair == null)
/*     */       {
/* 140 */         onGetCrossBattleFinalHistoryCorpsFail(7);
/* 141 */         return false;
/*     */       }
/*     */       
/* 144 */       int nowKnockOutStage = ((Integer)nowFightStagePair.first).intValue();
/* 145 */       boolean isSendSuccess = GrcInterface.getCrossBattleKnockOutInfo(this.activityCfgId, 2, CrossBattleKnockoutManager.GLOBAL_FIGHT_ZONE, nowKnockOutStage, knockOutCfg.need_team_size, knockOutCfg.stage_name_list.size(), knockOutCfg.fight_times_every_stage, new OctetsStream().marshal(getKnockOutContext));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 150 */       if (!isSendSuccess)
/*     */       {
/* 152 */         onGetCrossBattleFinalHistoryCorpsFail(11);
/*     */       }
/* 154 */       return isSendSuccess;
/*     */     }
/*     */     
/* 157 */     CrossBattleOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(this.activityCfgId), new PNotifyCrossBattleFinalHistoryCorps(this.roleId, this.session, this.rank, this.corpsId));
/*     */     
/*     */ 
/* 160 */     StringBuilder sb = new StringBuilder();
/* 161 */     sb.append("[crossbattle_knockout]PCGetCrossBattleFinalHistoryCorpsReq.processImp@get cross battle final history fight req success");
/* 162 */     sb.append("|role_id=").append(this.roleId);
/* 163 */     sb.append("|session=").append(this.session);
/*     */     
/* 165 */     GameServer.logger().info(sb.toString());
/* 166 */     return true;
/*     */   }
/*     */   
/*     */   private void onGetCrossBattleFinalHistoryCorpsFail(int ret)
/*     */   {
/* 171 */     onGetCrossBattleFinalHistoryCorpsFail(ret, null);
/*     */   }
/*     */   
/*     */   private void onGetCrossBattleFinalHistoryCorpsFail(int ret, Map<String, Object> extraMap)
/*     */   {
/* 176 */     StringBuilder sb = new StringBuilder();
/* 177 */     sb.append("[crossbattle_knockout]PCGetCrossBattleFinalHistoryCorpsReq.processImp@error");
/* 178 */     sb.append("|ret=").append(ret);
/* 179 */     sb.append("|role_id=").append(this.roleId);
/* 180 */     sb.append("|session=").append(this.session);
/* 181 */     sb.append("|rank=").append(this.rank);
/* 182 */     sb.append("|corps_id=").append(this.corpsId);
/*     */     
/* 184 */     if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */     {
/* 186 */       for (Map.Entry<String, Object> entry : extraMap.entrySet())
/*     */       {
/* 188 */         sb.append("|").append((String)entry.getKey()).append("=").append(entry.getValue());
/*     */       }
/*     */     }
/*     */     
/* 192 */     GameServer.logger().error(sb.toString());
/*     */     
/* 194 */     SCrossBattleHistoryNormalRes sCrossBattleHistoryNormalRes = new SCrossBattleHistoryNormalRes();
/* 195 */     sCrossBattleHistoryNormalRes.ret = ret;
/*     */     
/* 197 */     OnlineManager.getInstance().sendAtOnce(this.roleId, sCrossBattleHistoryNormalRes);
/*     */   }
/*     */   
/*     */ 
/*     */   public static class PNotifyCrossBattleFinalHistoryCorps
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final long roleId;
/*     */     
/*     */     private final int rank;
/*     */     
/*     */     private final int session;
/*     */     private final long corpsId;
/*     */     private int activityCfgId;
/*     */     
/*     */     public PNotifyCrossBattleFinalHistoryCorps(long roleId, int session, int rank, long corpsId)
/*     */     {
/* 214 */       this.roleId = roleId;
/* 215 */       this.session = session;
/* 216 */       this.rank = rank;
/* 217 */       this.corpsId = corpsId;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 223 */       if (!CrossBattleKnockoutManager.isCrossBattleHistorySwitchOpen(this.roleId))
/*     */       {
/* 225 */         onNotifyCrossBattleFinalHistoryCorpsFail(2);
/* 226 */         return false;
/*     */       }
/*     */       
/* 229 */       if (this.session > CrossBattleConsts.getInstance().cross_battle_session_num)
/*     */       {
/* 231 */         Map<String, Object> extraMap = new HashMap();
/* 232 */         extraMap.put("current_session", Integer.valueOf(CrossBattleConsts.getInstance().cross_battle_session_num));
/*     */         
/* 234 */         onNotifyCrossBattleFinalHistoryCorpsFail(8, extraMap);
/* 235 */         return false;
/*     */       }
/*     */       
/* 238 */       SCrossBattleHistoryCfg sCrossBattleHistoryCfg = SCrossBattleHistoryCfg.get(this.session);
/* 239 */       if (sCrossBattleHistoryCfg == null)
/*     */       {
/* 241 */         onNotifyCrossBattleFinalHistoryCorpsFail(9);
/* 242 */         return false;
/*     */       }
/*     */       
/* 245 */       this.activityCfgId = sCrossBattleHistoryCfg.activity_cfg_id;
/* 246 */       SCrossBattleKnockOutCfg sCrossBattleKnockOutCfg = SCrossBattleKnockOutCfg.get(this.activityCfgId);
/* 247 */       if (sCrossBattleKnockOutCfg == null)
/*     */       {
/* 249 */         onNotifyCrossBattleFinalHistoryCorpsFail(6);
/* 250 */         return false;
/*     */       }
/*     */       
/* 253 */       KnockOutCfg knockOutCfg = (KnockOutCfg)sCrossBattleKnockOutCfg.knockOutTypeCfgMap.get(Integer.valueOf(2));
/* 254 */       if (knockOutCfg == null)
/*     */       {
/* 256 */         onNotifyCrossBattleFinalHistoryCorpsFail(7);
/* 257 */         return false;
/*     */       }
/*     */       
/* 260 */       long globalActivityCfgId = GameServerInfoManager.toGlobalId(this.activityCfgId);
/*     */       
/* 262 */       CrossBattleKnockoutActivityInfo xCrossBattleKnockoutActivityInfo = Cross_battle_knockout.get(Long.valueOf(globalActivityCfgId));
/* 263 */       if (xCrossBattleKnockoutActivityInfo == null)
/*     */       {
/* 265 */         onNotifyCrossBattleFinalHistoryCorpsFail(3);
/* 266 */         return false;
/*     */       }
/*     */       
/* 269 */       CrossBattleKnockoutInfo xCrossBattleKnockoutInfo = (CrossBattleKnockoutInfo)xCrossBattleKnockoutActivityInfo.getKnockout_info_map().get(Integer.valueOf(2));
/*     */       
/* 271 */       if (xCrossBattleKnockoutInfo == null)
/*     */       {
/* 273 */         onNotifyCrossBattleFinalHistoryCorpsFail(4);
/* 274 */         return false;
/*     */       }
/*     */       
/* 277 */       FightZoneInfo xFightZoneInfo = (FightZoneInfo)xCrossBattleKnockoutInfo.getFight_zone_info_map().get(Integer.valueOf(CrossBattleKnockoutManager.GLOBAL_FIGHT_ZONE));
/*     */       
/* 279 */       if (xFightZoneInfo == null)
/*     */       {
/* 281 */         onNotifyCrossBattleFinalHistoryCorpsFail(5);
/* 282 */         return false;
/*     */       }
/*     */       
/* 285 */       Pair<Integer, Boolean> nowFightStagePair = CrossBattleKnockoutInterface.getNowFightStage(this.activityCfgId, 2);
/*     */       
/* 287 */       if (nowFightStagePair == null)
/*     */       {
/* 289 */         onNotifyCrossBattleFinalHistoryCorpsFail(7);
/* 290 */         return false;
/*     */       }
/*     */       
/*     */ 
/* 294 */       int nowFightStage = ((Integer)nowFightStagePair.first).intValue();
/*     */       
/* 296 */       int championFirstStage = knockOutCfg.stage_time_point_cfg_id_list.size() - knockOutCfg.fight_times_every_stage + 1;
/*     */       
/* 298 */       if (((Integer)nowFightStagePair.first).intValue() < championFirstStage)
/*     */       {
/* 300 */         onNotifyCrossBattleFinalHistoryCorpsFail(16);
/* 301 */         return false;
/*     */       }
/*     */       
/* 304 */       FightStageInfo xFightStageInfo = (FightStageInfo)xFightZoneInfo.getFight_stage_info_map().get(Integer.valueOf(championFirstStage));
/* 305 */       if (xFightStageInfo == null)
/*     */       {
/* 307 */         onNotifyCrossBattleFinalHistoryCorpsFail(18);
/* 308 */         return false;
/*     */       }
/*     */       
/* 311 */       FightAgainstInfo xFightAgainstInfo = (FightAgainstInfo)xFightStageInfo.getFight_against_info_map().get(Integer.valueOf(1));
/* 312 */       if (xFightAgainstInfo == null)
/*     */       {
/* 314 */         onNotifyCrossBattleFinalHistoryCorpsFail(19);
/* 315 */         return false;
/*     */       }
/*     */       
/*     */ 
/* 319 */       Pair<Long, Pair<Integer, Integer>> winPair = CrossBattleKnockoutManager.getWinCorpsId(xFightZoneInfo.getFight_stage_info_map(), xFightAgainstInfo.getA_corps_id(), xFightAgainstInfo.getB_corps_id(), nowFightStage, 1, knockOutCfg.fight_times_every_stage);
/*     */       
/*     */ 
/* 322 */       boolean isByeWin = CrossBattleKnockoutManager.isByeWin(xFightAgainstInfo);
/* 323 */       if ((((Long)winPair.first).longValue() == -1L) && (nowFightStage % knockOutCfg.fight_times_every_stage != 0) && (!isByeWin))
/*     */       {
/* 325 */         onNotifyCrossBattleFinalHistoryCorpsFail(17);
/* 326 */         return false;
/*     */       }
/* 328 */       GetFightStageEndCorpsInfo_FinalHistory context = new GetFightStageEndCorpsInfo_FinalHistory(this.roleId, this.rank, this.session);
/*     */       
/*     */ 
/* 331 */       OctetsStream octetsStream = new OctetsStream();
/* 332 */       octetsStream.marshal(context);
/*     */       
/* 334 */       GetFightStageEndCorpsInfo getKnockOutContext = new GetFightStageEndCorpsInfo();
/* 335 */       getKnockOutContext.oper_type = 1;
/* 336 */       getKnockOutContext.content = octetsStream;
/*     */       
/* 338 */       int totalStageSize = knockOutCfg.stage_time_point_cfg_id_list.size();
/* 339 */       boolean isSendSuccess = false;
/* 340 */       if ((this.rank == 1) || (this.rank == 2))
/*     */       {
/* 342 */         if (this.rank == 1)
/*     */         {
/* 344 */           if ((((Long)winPair.first).longValue() == -1L) && (!isByeWin))
/*     */           {
/* 346 */             onNotifyCrossBattleFinalHistoryCorpsFail(23);
/* 347 */             return false;
/*     */           }
/*     */           
/* 350 */           if ((((Long)winPair.first).longValue() != this.corpsId) && (!isByeWin))
/*     */           {
/* 352 */             Map<String, Object> extraMap = new HashMap();
/* 353 */             extraMap.put("win_pair_first", winPair.first);
/* 354 */             extraMap.put("champion_fight_a_corps_id", Long.valueOf(xFightAgainstInfo.getA_corps_id()));
/* 355 */             extraMap.put("champion_fight_b_corps_id", Long.valueOf(xFightAgainstInfo.getB_corps_id()));
/*     */             
/* 357 */             onNotifyCrossBattleFinalHistoryCorpsFail(24, extraMap);
/*     */             
/* 359 */             return false;
/*     */           }
/*     */           
/* 362 */           if (isByeWin)
/*     */           {
/* 364 */             if (((xFightAgainstInfo.getA_corps_id() != this.corpsId) && (xFightAgainstInfo.getCal_fight_result() == FightResultEnum.A_BYE_WIN.fightResult)) || ((xFightAgainstInfo.getB_corps_id() != this.corpsId) && (xFightAgainstInfo.getCal_fight_result() == FightResultEnum.B_BYE_WIN.fightResult)))
/*     */             {
/*     */ 
/* 367 */               Map<String, Object> extraMap = new HashMap();
/* 368 */               extraMap.put("win_pair_first", winPair.first);
/* 369 */               extraMap.put("champion_fight_a_corps_id", Long.valueOf(xFightAgainstInfo.getA_corps_id()));
/* 370 */               extraMap.put("champion_fight_b_corps_id", Long.valueOf(xFightAgainstInfo.getB_corps_id()));
/*     */               
/* 372 */               onNotifyCrossBattleFinalHistoryCorpsFail(24, extraMap);
/*     */               
/* 374 */               return false;
/*     */             }
/*     */           }
/*     */         }
/* 378 */         else if (this.rank == 2)
/*     */         {
/* 380 */           if ((((Long)winPair.first).longValue() == -1L) && (this.corpsId != xFightAgainstInfo.getA_corps_id()) && (this.corpsId != xFightAgainstInfo.getB_corps_id()))
/*     */           {
/*     */ 
/* 383 */             Map<String, Object> extraMap = new HashMap();
/* 384 */             extraMap.put("win_pair_first", winPair.first);
/* 385 */             extraMap.put("champion_fight_a_corps_id", Long.valueOf(xFightAgainstInfo.getA_corps_id()));
/* 386 */             extraMap.put("champion_fight_b_corps_id", Long.valueOf(xFightAgainstInfo.getB_corps_id()));
/*     */             
/* 388 */             onNotifyCrossBattleFinalHistoryCorpsFail(25, extraMap);
/*     */             
/* 390 */             return false;
/*     */           }
/*     */           
/* 393 */           if (((((Long)winPair.first).longValue() == xFightAgainstInfo.getA_corps_id()) && (this.corpsId != xFightAgainstInfo.getB_corps_id())) || ((((Long)winPair.first).longValue() == xFightAgainstInfo.getB_corps_id()) && (this.corpsId != xFightAgainstInfo.getA_corps_id())))
/*     */           {
/*     */ 
/* 396 */             Map<String, Object> extraMap = new HashMap();
/* 397 */             extraMap.put("win_pair_first", winPair.first);
/* 398 */             extraMap.put("champion_fight_a_corps_id", Long.valueOf(xFightAgainstInfo.getA_corps_id()));
/* 399 */             extraMap.put("champion_fight_b_corps_id", Long.valueOf(xFightAgainstInfo.getB_corps_id()));
/*     */             
/* 401 */             onNotifyCrossBattleFinalHistoryCorpsFail(25, extraMap);
/*     */             
/* 403 */             return false;
/*     */           }
/*     */         }
/*     */         
/* 407 */         int lastFightStage = -1;
/* 408 */         if (isByeWin)
/*     */         {
/* 410 */           lastFightStage = totalStageSize - knockOutCfg.fight_times_every_stage + 1;
/*     */         }
/*     */         else
/*     */         {
/* 414 */           for (int lastStage = totalStageSize; lastStage > totalStageSize - knockOutCfg.fight_times_every_stage; lastStage--)
/*     */           {
/* 416 */             FightStageInfo xTempFightStageInfo = (FightStageInfo)xFightZoneInfo.getFight_stage_info_map().get(Integer.valueOf(lastStage));
/* 417 */             if (xTempFightStageInfo != null)
/*     */             {
/* 419 */               FightAgainstInfo xTempFightAgainstInfo = (FightAgainstInfo)xTempFightStageInfo.getFight_against_info_map().get(Integer.valueOf(1));
/*     */               
/* 421 */               if ((xTempFightAgainstInfo != null) && (xTempFightAgainstInfo.getCal_fight_result() != 0))
/*     */               {
/* 423 */                 lastFightStage = lastStage;
/* 424 */                 break;
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/*     */         
/* 430 */         isSendSuccess = GrcInterface.getCrossBattleStageFightEndCorpsInfo(this.activityCfgId, 2, lastFightStage, this.corpsId, new OctetsStream().marshal(getKnockOutContext));
/*     */ 
/*     */       }
/* 433 */       else if (this.rank == 3)
/*     */       {
/* 435 */         int thirdPlaceLastStage = knockOutCfg.stage_time_point_cfg_id_list.size() - knockOutCfg.fight_times_every_stage;
/*     */         
/* 437 */         FightStageInfo xThirdPlaceFightStageInfo = (FightStageInfo)xFightZoneInfo.getFight_stage_info_map().get(Integer.valueOf(thirdPlaceLastStage));
/*     */         
/* 439 */         if (xThirdPlaceFightStageInfo == null)
/*     */         {
/* 441 */           onNotifyCrossBattleFinalHistoryCorpsFail(20);
/* 442 */           return false;
/*     */         }
/*     */         
/* 445 */         FightAgainstInfo xThirdPlaceFightAgainstInfo = (FightAgainstInfo)xThirdPlaceFightStageInfo.getFight_against_info_map().get(Integer.valueOf(1));
/*     */         
/* 447 */         if (xThirdPlaceFightAgainstInfo == null)
/*     */         {
/* 449 */           onNotifyCrossBattleFinalHistoryCorpsFail(21);
/* 450 */           return false;
/*     */         }
/*     */         
/* 453 */         long thirdPlaceAgainstACorpsId = xThirdPlaceFightAgainstInfo.getA_corps_id();
/* 454 */         long thirdPlaceAgainstBCorpsId = xThirdPlaceFightAgainstInfo.getB_corps_id();
/* 455 */         Pair<Long, Pair<Integer, Integer>> thirdPlaceWinPair = CrossBattleKnockoutManager.getWinCorpsId(xFightZoneInfo.getFight_stage_info_map(), thirdPlaceAgainstACorpsId, thirdPlaceAgainstBCorpsId, thirdPlaceLastStage, 1, knockOutCfg.fight_times_every_stage);
/*     */         
/*     */ 
/* 458 */         if (((Long)thirdPlaceWinPair.first).longValue() != this.corpsId)
/*     */         {
/* 460 */           onNotifyCrossBattleFinalHistoryCorpsFail(26);
/* 461 */           return false;
/*     */         }
/*     */         
/* 464 */         boolean thirdIsByeWin = CrossBattleKnockoutManager.isByeWin(xThirdPlaceFightAgainstInfo);
/*     */         
/* 466 */         int lastFightStage = -1;
/*     */         
/* 468 */         if (thirdIsByeWin)
/*     */         {
/* 470 */           lastFightStage = totalStageSize - 2 * knockOutCfg.fight_times_every_stage + 1;
/*     */         }
/*     */         else
/*     */         {
/* 474 */           for (int lastStage = totalStageSize - knockOutCfg.fight_times_every_stage; 
/* 475 */               lastStage > totalStageSize - 2 * knockOutCfg.fight_times_every_stage; lastStage--)
/*     */           {
/* 477 */             FightStageInfo xTempFightStageInfo = (FightStageInfo)xFightZoneInfo.getFight_stage_info_map().get(Integer.valueOf(lastStage));
/* 478 */             if (xTempFightStageInfo != null)
/*     */             {
/* 480 */               FightAgainstInfo xTempFightAgainstInfo = (FightAgainstInfo)xTempFightStageInfo.getFight_against_info_map().get(Integer.valueOf(1));
/*     */               
/* 482 */               if ((xTempFightAgainstInfo != null) && (xTempFightAgainstInfo.getCal_fight_result() != 0))
/*     */               {
/* 484 */                 lastFightStage = lastStage;
/* 485 */                 break;
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/*     */         
/* 491 */         isSendSuccess = GrcInterface.getCrossBattleStageFightEndCorpsInfo(this.activityCfgId, 2, lastFightStage, this.corpsId, new OctetsStream().marshal(getKnockOutContext));
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/* 496 */         onNotifyCrossBattleFinalHistoryCorpsFail(22);
/* 497 */         return false;
/*     */       }
/*     */       
/* 500 */       StringBuilder sb = new StringBuilder();
/* 501 */       sb.append("[crossbattle_knockout]PNotifyCrossBattleFinalHistoryCorps.processImp@send grc req");
/* 502 */       sb.append("|role_id=").append(this.roleId);
/* 503 */       sb.append("|session=").append(this.session);
/* 504 */       sb.append("|rank=").append(this.rank);
/* 505 */       sb.append("|corps_id=").append(this.corpsId);
/* 506 */       sb.append("|is_send_success=").append(isSendSuccess);
/*     */       
/* 508 */       GameServer.logger().info(sb.toString());
/* 509 */       return true;
/*     */     }
/*     */     
/*     */     private void onNotifyCrossBattleFinalHistoryCorpsFail(int ret)
/*     */     {
/* 514 */       onNotifyCrossBattleFinalHistoryCorpsFail(ret, null);
/*     */     }
/*     */     
/*     */     private void onNotifyCrossBattleFinalHistoryCorpsFail(int ret, Map<String, Object> extraMap)
/*     */     {
/* 519 */       StringBuilder sb = new StringBuilder();
/* 520 */       sb.append("[crossbattle_knockout]PNotifyCrossBattleFinalHistoryCorps.processImp@error");
/* 521 */       sb.append("|ret=").append(ret);
/* 522 */       sb.append("|role_id=").append(this.roleId);
/* 523 */       sb.append("|session=").append(this.session);
/* 524 */       sb.append("|rank=").append(this.rank);
/* 525 */       sb.append("|corps_id=").append(this.corpsId);
/*     */       
/* 527 */       if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */       {
/* 529 */         for (Map.Entry<String, Object> entry : extraMap.entrySet())
/*     */         {
/* 531 */           sb.append("|").append((String)entry.getKey()).append("=").append(entry.getValue());
/*     */         }
/*     */       }
/*     */       
/* 535 */       GameServer.logger().error(sb.toString());
/*     */       
/* 537 */       SCrossBattleHistoryNormalRes sCrossBattleHistoryNormalRes = new SCrossBattleHistoryNormalRes();
/* 538 */       sCrossBattleHistoryNormalRes.ret = ret;
/*     */       
/* 540 */       OnlineManager.getInstance().sendAtOnce(this.roleId, sCrossBattleHistoryNormalRes);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\knockout\PCGetCrossBattleFinalHistoryCorpsReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
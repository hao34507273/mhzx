/*     */ package mzm.gsp.crossbattle.knockout;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.crossbattle.GetKnockOutContext;
/*     */ import mzm.gsp.crossbattle.GetKnockOutContext_Award;
/*     */ import mzm.gsp.crossbattle.confbean.KnockOutCfg;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattleKnockOutCfg;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.Pair;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.CrossBattleKnockoutActivityInfo;
/*     */ import xbean.CrossBattleKnockoutActivityLocalInfo;
/*     */ import xbean.CrossBattleKnockoutInfo;
/*     */ import xbean.CrossBattleKnockoutLocalInfo;
/*     */ import xbean.FightAgainstInfo;
/*     */ import xbean.FightStageInfo;
/*     */ import xbean.FightZoneInfo;
/*     */ import xbean.FightZoneLocalInfo;
/*     */ import xbean.Pod;
/*     */ import xtable.Cross_battle_knockout;
/*     */ 
/*     */ public class PTryKnockOutAward extends LogicProcedure
/*     */ {
/*     */   private final int activityCfgId;
/*     */   private final int knockOutType;
/*     */   private final Set<Long> corpsIdSet;
/*     */   
/*     */   public PTryKnockOutAward(int activityCfgId, int knockOutType, Set<Long> corpsIdSet)
/*     */   {
/*  40 */     this.activityCfgId = activityCfgId;
/*  41 */     this.knockOutType = knockOutType;
/*  42 */     this.corpsIdSet = corpsIdSet;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  48 */     StringBuilder contextBuilder = new StringBuilder();
/*  49 */     contextBuilder.append("[crossbattle_knockout]PTryKnockOutAward.processImp@into try knock out award");
/*  50 */     contextBuilder.append("|activity_cfg_id=").append(this.activityCfgId);
/*  51 */     contextBuilder.append("|knock_out_type=").append(this.knockOutType);
/*  52 */     contextBuilder.append("|corps_id_set=").append(this.corpsIdSet.toString());
/*     */     
/*  54 */     GameServer.logger().info(contextBuilder.toString());
/*     */     
/*  56 */     if (!CrossBattleKnockoutManager.isCrossBattleKnockOutSwitchOpen(this.activityCfgId, this.knockOutType))
/*     */     {
/*  58 */       onFail(25);
/*  59 */       return false;
/*     */     }
/*     */     
/*  62 */     SCrossBattleKnockOutCfg sCrossBattleKnockOutCfg = SCrossBattleKnockOutCfg.get(this.activityCfgId);
/*  63 */     if (sCrossBattleKnockOutCfg == null)
/*     */     {
/*  65 */       onFail(-1);
/*  66 */       return false;
/*     */     }
/*     */     
/*  69 */     KnockOutCfg knockOutCfg = (KnockOutCfg)sCrossBattleKnockOutCfg.knockOutTypeCfgMap.get(Integer.valueOf(this.knockOutType));
/*  70 */     if (knockOutCfg == null)
/*     */     {
/*  72 */       onFail(-2);
/*  73 */       return false;
/*     */     }
/*     */     
/*  76 */     long activityGlobalId = mzm.gsp.GameServerInfoManager.toGlobalId(this.activityCfgId);
/*     */     
/*  78 */     CrossBattleKnockoutActivityInfo xCrossBattleKnockoutActivityInfo = Cross_battle_knockout.get(Long.valueOf(activityGlobalId));
/*     */     
/*  80 */     CrossBattleKnockoutInfo xCrossBattleKnockoutInfo = null;
/*  81 */     if (xCrossBattleKnockoutActivityInfo != null)
/*     */     {
/*  83 */       xCrossBattleKnockoutInfo = (CrossBattleKnockoutInfo)xCrossBattleKnockoutActivityInfo.getKnockout_info_map().get(Integer.valueOf(this.knockOutType));
/*     */     }
/*     */     
/*  86 */     for (Iterator i$ = this.corpsIdSet.iterator(); i$.hasNext();) { long corpsId = ((Long)i$.next()).longValue();
/*     */       
/*  88 */       int fightZoneId = CrossBattleKnockoutManager.getFightZone(corpsId, this.activityCfgId, this.knockOutType);
/*  89 */       if (fightZoneId < 0)
/*     */       {
/*  91 */         onFail(-3);
/*     */       }
/*     */       else
/*     */       {
/*  95 */         FightZoneInfo xFightZoneInfo = null;
/*  96 */         if (xCrossBattleKnockoutInfo != null)
/*     */         {
/*  98 */           xFightZoneInfo = (FightZoneInfo)xCrossBattleKnockoutInfo.getFight_zone_info_map().get(Integer.valueOf(fightZoneId));
/*     */         }
/*     */         
/* 101 */         if ((xCrossBattleKnockoutActivityInfo == null) || (xCrossBattleKnockoutInfo == null) || (xFightZoneInfo == null))
/*     */         {
/* 103 */           GetKnockOutContext_Award context = new GetKnockOutContext_Award(corpsId);
/* 104 */           OctetsStream octetsStream = new OctetsStream();
/* 105 */           octetsStream.marshal(context);
/*     */           
/* 107 */           GetKnockOutContext getKnockOutContext = new GetKnockOutContext();
/* 108 */           getKnockOutContext.oper_type = 10;
/* 109 */           getKnockOutContext.content = octetsStream;
/*     */           
/* 111 */           boolean isSendSuccess = mzm.gsp.grc.main.GrcInterface.getCrossBattleKnockOutInfo(this.activityCfgId, this.knockOutType, fightZoneId, 1, knockOutCfg.need_team_size, knockOutCfg.stage_name_list.size(), knockOutCfg.fight_times_every_stage, new OctetsStream().marshal(getKnockOutContext));
/*     */           
/*     */ 
/* 114 */           if (!isSendSuccess)
/*     */           {
/* 116 */             xdb.Xdb.executor().schedule(new RGetKnockOutInfoRepeat(this.activityCfgId, this.knockOutType, fightZoneId, 1, knockOutCfg.need_team_size, knockOutCfg.stage_name_list.size(), knockOutCfg.fight_times_every_stage, new OctetsStream().marshal(getKnockOutContext), 1), 1000L, java.util.concurrent.TimeUnit.MILLISECONDS);
/*     */           }
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 124 */           StringBuilder queryKnockOutContext = new StringBuilder();
/* 125 */           contextBuilder.append("[crossbattle_knockout]PTryKnockOutAward.processImp@query knock out data");
/* 126 */           contextBuilder.append("|activity_cfg_id=").append(this.activityCfgId);
/* 127 */           contextBuilder.append("|knock_out_type=").append(this.knockOutType);
/* 128 */           contextBuilder.append("|corps_id_set=").append(this.corpsIdSet.toString());
/* 129 */           contextBuilder.append("|corps_id=").append(corpsId);
/* 130 */           contextBuilder.append("|fight_zone_id=").append(fightZoneId);
/*     */           
/* 132 */           GameServer.logger().info(queryKnockOutContext.toString());
/*     */         }
/*     */         else
/*     */         {
/* 136 */           new PKnockOutAward(this.activityCfgId, this.knockOutType, corpsId).execute();
/*     */           
/* 138 */           StringBuilder queryKnockOutContext = new StringBuilder();
/* 139 */           contextBuilder.append("[crossbattle_knockout]PTryKnockOutAward.processImp@execute award knock out data");
/* 140 */           contextBuilder.append("|activity_cfg_id=").append(this.activityCfgId);
/* 141 */           contextBuilder.append("|knock_out_type=").append(this.knockOutType);
/* 142 */           contextBuilder.append("|corps_id_set=").append(this.corpsIdSet.toString());
/* 143 */           contextBuilder.append("|corps_id=").append(corpsId);
/* 144 */           contextBuilder.append("|fight_zone_id=").append(fightZoneId);
/*     */           
/* 146 */           GameServer.logger().info(queryKnockOutContext.toString());
/*     */         }
/*     */       } }
/* 149 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int ret)
/*     */   {
/* 154 */     onFail(ret, null);
/*     */   }
/*     */   
/*     */   private void onFail(int ret, Map<String, Object> extraMap)
/*     */   {
/* 159 */     StringBuilder stringBuilder = new StringBuilder();
/* 160 */     stringBuilder.append("[crossbattle_knockout]PTryKnockOutAward.processImp@error");
/* 161 */     stringBuilder.append("|ret=").append(ret);
/* 162 */     stringBuilder.append("|activity_cfg_id=").append(this.activityCfgId);
/* 163 */     stringBuilder.append("|knock_out_type=").append(this.knockOutType);
/* 164 */     stringBuilder.append("|corps_id_set=").append(this.corpsIdSet.toString());
/*     */     
/* 166 */     if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */     {
/* 168 */       for (Map.Entry<String, Object> entry : extraMap.entrySet())
/*     */       {
/* 170 */         stringBuilder.append("|").append((String)entry.getKey()).append("|").append(entry.getValue());
/*     */       }
/*     */     }
/*     */     
/* 174 */     GameServer.logger().error(stringBuilder.toString());
/*     */   }
/*     */   
/*     */ 
/*     */   static class PKnockOutAward
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final int activityCfgId;
/*     */     private final int knockOutType;
/*     */     private final long corpsId;
/*     */     
/*     */     public PKnockOutAward(int activityCfgId, int knockOutType, long corpsId)
/*     */     {
/* 187 */       this.activityCfgId = activityCfgId;
/* 188 */       this.knockOutType = knockOutType;
/* 189 */       this.corpsId = corpsId;
/*     */     }
/*     */     
/*     */ 
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 196 */       List<Long> roleIdList = mzm.gsp.crossbattle.own.CrossBattleOwnInterface.getCrossBattleRegisterRoleList(this.corpsId, this.activityCfgId, false);
/*     */       
/* 198 */       if (roleIdList == null)
/*     */       {
/* 200 */         onFail(-1);
/* 201 */         return false;
/*     */       }
/* 203 */       lock(xtable.Role2properties.getTable(), roleIdList);
/*     */       
/* 205 */       SCrossBattleKnockOutCfg sCrossBattleKnockOutCfg = SCrossBattleKnockOutCfg.get(this.activityCfgId);
/* 206 */       if (sCrossBattleKnockOutCfg == null)
/*     */       {
/* 208 */         onFail(-2);
/* 209 */         return false;
/*     */       }
/*     */       
/* 212 */       KnockOutCfg knockOutCfg = (KnockOutCfg)sCrossBattleKnockOutCfg.knockOutTypeCfgMap.get(Integer.valueOf(this.knockOutType));
/* 213 */       if (knockOutCfg == null)
/*     */       {
/* 215 */         onFail(-3);
/* 216 */         return false;
/*     */       }
/*     */       
/* 219 */       long activityGlobalId = mzm.gsp.GameServerInfoManager.toGlobalId(this.activityCfgId);
/*     */       
/* 221 */       CrossBattleKnockoutActivityInfo xCrossBattleKnockoutActivityInfo = Cross_battle_knockout.get(Long.valueOf(activityGlobalId));
/* 222 */       if (xCrossBattleKnockoutActivityInfo == null)
/*     */       {
/* 224 */         onFail(-4);
/* 225 */         return false;
/*     */       }
/*     */       
/* 228 */       CrossBattleKnockoutInfo xCrossBattleKnockoutInfo = (CrossBattleKnockoutInfo)xCrossBattleKnockoutActivityInfo.getKnockout_info_map().get(Integer.valueOf(this.knockOutType));
/*     */       
/* 230 */       if (xCrossBattleKnockoutInfo == null)
/*     */       {
/* 232 */         onFail(-5);
/* 233 */         return false;
/*     */       }
/*     */       
/* 236 */       int fightZoneId = CrossBattleKnockoutManager.getFightZone(this.corpsId, this.activityCfgId, this.knockOutType);
/* 237 */       if (fightZoneId < 0)
/*     */       {
/* 239 */         onFail(-6);
/* 240 */         return false;
/*     */       }
/*     */       
/* 243 */       KnockOutHandler knockOutHandler = CrossBattleKnockoutManager.getKnockOutHandler(this.knockOutType);
/* 244 */       if (knockOutHandler == null)
/*     */       {
/* 246 */         onFail(-7);
/* 247 */         return false;
/*     */       }
/*     */       
/* 250 */       FightZoneInfo xFightZoneInfo = (FightZoneInfo)xCrossBattleKnockoutInfo.getFight_zone_info_map().get(Integer.valueOf(fightZoneId));
/* 251 */       if (xFightZoneInfo == null)
/*     */       {
/* 253 */         onFail(-8);
/* 254 */         return false;
/*     */       }
/*     */       
/* 257 */       CrossBattleKnockoutActivityLocalInfo xCrossBattleKnockoutActivityLocalInfo = xtable.Cross_battle_knockout_local.get(Long.valueOf(activityGlobalId));
/* 258 */       if (xCrossBattleKnockoutActivityLocalInfo == null)
/*     */       {
/* 260 */         xCrossBattleKnockoutActivityLocalInfo = Pod.newCrossBattleKnockoutActivityLocalInfo();
/* 261 */         xtable.Cross_battle_knockout_local.add(Long.valueOf(activityGlobalId), xCrossBattleKnockoutActivityLocalInfo);
/*     */       }
/*     */       
/* 264 */       CrossBattleKnockoutLocalInfo xCrossBattleKnockoutLocalInfo = (CrossBattleKnockoutLocalInfo)xCrossBattleKnockoutActivityLocalInfo.getKnockout_info_map().get(Integer.valueOf(this.knockOutType));
/*     */       
/* 266 */       if (xCrossBattleKnockoutLocalInfo == null)
/*     */       {
/* 268 */         xCrossBattleKnockoutLocalInfo = Pod.newCrossBattleKnockoutLocalInfo();
/* 269 */         xCrossBattleKnockoutActivityLocalInfo.getKnockout_info_map().put(Integer.valueOf(this.knockOutType), xCrossBattleKnockoutLocalInfo);
/*     */       }
/*     */       
/*     */ 
/* 273 */       FightZoneLocalInfo xFightZoneLocalInfo = (FightZoneLocalInfo)xCrossBattleKnockoutLocalInfo.getFight_zone_info_map().get(Integer.valueOf(fightZoneId));
/*     */       
/* 275 */       if (xFightZoneLocalInfo == null)
/*     */       {
/* 277 */         xFightZoneLocalInfo = Pod.newFightZoneLocalInfo();
/* 278 */         xCrossBattleKnockoutLocalInfo.getFight_zone_info_map().put(Integer.valueOf(fightZoneId), xFightZoneLocalInfo);
/*     */       }
/*     */       
/* 281 */       if (xFightZoneLocalInfo.getAward_corps_id_set().contains(Long.valueOf(this.corpsId)))
/*     */       {
/* 283 */         Map<String, Object> extraMap = new HashMap();
/* 284 */         extraMap.put("award_corps_id", xFightZoneLocalInfo.getAward_corps_id_set().toString());
/*     */         
/* 286 */         onFail(-9, extraMap);
/* 287 */         return true;
/*     */       }
/*     */       
/* 290 */       int maxFightStage = knockOutCfg.stage_time_point_cfg_id_list.size();
/*     */       
/* 292 */       int maxFightRound = knockOutCfg.stage_time_point_cfg_id_list.size() / knockOutCfg.fight_times_every_stage;
/*     */       
/* 294 */       boolean isFound = false;
/* 295 */       int fightRound; boolean is4To2Round; boolean isChampionRound; boolean isThirdPlaceRound; for (int fightStage = 1; (fightStage <= maxFightStage) && (!isFound); fightStage++)
/*     */       {
/* 297 */         FightStageInfo xFightStageInfo = (FightStageInfo)xFightZoneInfo.getFight_stage_info_map().get(Integer.valueOf(fightStage));
/* 298 */         if (xFightStageInfo == null)
/*     */         {
/* 300 */           Map<String, Object> extraMap = new HashMap();
/* 301 */           extraMap.put("fight_stage", Integer.valueOf(fightStage));
/* 302 */           extraMap.put("fight_stage_list", xFightZoneInfo.getFight_stage_info_map().keySet().toString());
/*     */           
/* 304 */           onFail(-10, extraMap);
/*     */ 
/*     */ 
/*     */         }
/* 308 */         else if (fightStage % knockOutCfg.fight_times_every_stage == 0)
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/* 313 */           fightRound = (fightStage - 1) / knockOutCfg.fight_times_every_stage + 1;
/* 314 */           is4To2Round = fightRound == maxFightRound - 2;
/* 315 */           isChampionRound = fightRound == maxFightRound;
/* 316 */           isThirdPlaceRound = fightRound == maxFightRound - 1;
/*     */           
/* 318 */           for (Map.Entry<Integer, FightAgainstInfo> entry : xFightStageInfo.getFight_against_info_map().entrySet())
/*     */           {
/* 320 */             int fightIndexId = ((Integer)entry.getKey()).intValue();
/* 321 */             FightAgainstInfo xFightAgainstInfo = (FightAgainstInfo)entry.getValue();
/*     */             
/* 323 */             if ((xFightAgainstInfo.getA_corps_id() == this.corpsId) || (xFightAgainstInfo.getB_corps_id() == this.corpsId))
/*     */             {
/* 325 */               Pair<Long, Pair<Integer, Integer>> winCorpsPair = CrossBattleKnockoutManager.getWinCorpsId(xFightZoneInfo.getFight_stage_info_map(), xFightAgainstInfo.getA_corps_id(), xFightAgainstInfo.getB_corps_id(), fightStage, fightIndexId, knockOutCfg.fight_times_every_stage);
/*     */               
/*     */ 
/*     */ 
/*     */ 
/* 330 */               if ((!isChampionRound) && (!isThirdPlaceRound) && 
/*     */               
/* 332 */                 (winCorpsPair != null) && (((Long)winCorpsPair.first).longValue() == this.corpsId)) {
/*     */                 break;
/*     */               }
/*     */               
/*     */ 
/*     */ 
/*     */ 
/* 339 */               int mailContextArgIndex = 0;
/*     */               
/* 341 */               if (is4To2Round)
/*     */               {
/* 343 */                 if (((Long)winCorpsPair.first).longValue() != -1L)
/*     */                   break;
/* 345 */                 mailContextArgIndex = fightRound;
/*     */               }
/*     */               
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 353 */               if (isThirdPlaceRound)
/*     */               {
/* 355 */                 if ((((Long)winCorpsPair.first).longValue() == -1L) || (((Long)winCorpsPair.first).longValue() != this.corpsId))
/*     */                 {
/* 357 */                   mailContextArgIndex = fightRound - 1;
/*     */                 }
/*     */                 else
/*     */                 {
/* 361 */                   mailContextArgIndex = fightRound;
/*     */                 }
/*     */               }
/* 364 */               else if (isChampionRound)
/*     */               {
/* 366 */                 if ((((Long)winCorpsPair.first).longValue() == -1L) || (((Long)winCorpsPair.first).longValue() != this.corpsId))
/*     */                 {
/* 368 */                   mailContextArgIndex = fightRound;
/*     */                 }
/*     */                 else
/*     */                 {
/* 372 */                   mailContextArgIndex = fightRound + 1;
/*     */                 }
/*     */                 
/*     */               }
/*     */               else {
/* 377 */                 mailContextArgIndex = fightRound;
/*     */               }
/* 379 */               int fixAwardId = ((Integer)knockOutCfg.stage_award_fix_id_list.get(mailContextArgIndex - 1)).intValue();
/*     */               
/* 381 */               AwardReason awardReason = new AwardReason(LogReason.CROSS_BATTLE_AWARD);
/* 382 */               awardReason.setJustQuery(true);
/* 383 */               for (Iterator i$ = roleIdList.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */                 
/* 385 */                 mzm.gsp.award.main.AwardModel awardModel = mzm.gsp.award.main.AwardInterface.getRoleFixAwardModel(fixAwardId, roleId, awardReason);
/* 386 */                 if (awardModel == null)
/*     */                 {
/* 388 */                   Map<String, Object> extraMap = new HashMap();
/* 389 */                   extraMap.put("award_fix_id", Integer.valueOf(fixAwardId));
/* 390 */                   extraMap.put("mail_context_arg_index", Integer.valueOf(mailContextArgIndex));
/* 391 */                   extraMap.put("fight_stage", Integer.valueOf(fightStage));
/* 392 */                   extraMap.put("fight_round", Integer.valueOf(fightRound));
/* 393 */                   extraMap.put("fight_index_id", Integer.valueOf(fightIndexId));
/*     */                   
/* 395 */                   onFail(-11, extraMap);
/*     */                 }
/*     */                 else
/*     */                 {
/* 399 */                   mzm.gsp.mail.main.MailAttachment mailAttachment = mzm.gsp.award.main.AwardInterface.getMailAttachmentBy(awardModel);
/*     */                   
/* 401 */                   List<String> contextArgsList = knockOutHandler.getAwardMailContextArgsList(knockOutCfg, mailContextArgIndex);
/*     */                   
/* 403 */                   mzm.gsp.mail.main.MailInterface.synBuildAndSendMail(roleId, knockOutCfg.rank_award_mail_cfg_id, null, contextArgsList, mailAttachment, new mzm.gsp.tlog.TLogArg(LogReason.CROSS_BATTLE_AWARD, this.knockOutType));
/*     */                   
/*     */ 
/*     */ 
/* 407 */                   KnockOutTLogManager.tlogAwardKnockOutRole(roleId, this.activityCfgId, this.knockOutType, fightZoneId, this.corpsId, fixAwardId, mailContextArgIndex);
/*     */                 }
/*     */               }
/* 410 */               isFound = true;
/*     */               
/* 412 */               xFightZoneLocalInfo.getAward_corps_id_set().add(Long.valueOf(this.corpsId));
/*     */               
/* 414 */               StringBuilder stringBuilder = new StringBuilder();
/* 415 */               stringBuilder.append("[crossbattle_knockout]PKnockOutAward.processImp@award success");
/* 416 */               stringBuilder.append("|activity_cfg_id=").append(this.activityCfgId);
/* 417 */               stringBuilder.append("|knock_out_type=").append(this.knockOutType);
/* 418 */               stringBuilder.append("|corps_id=").append(this.corpsId);
/* 419 */               stringBuilder.append("|award_id=").append(fixAwardId);
/* 420 */               stringBuilder.append("|mail_context_arg_index=").append(mailContextArgIndex);
/* 421 */               stringBuilder.append("|fight_stage=").append(fightStage);
/* 422 */               stringBuilder.append("|fight_index_id=").append(fightIndexId);
/* 423 */               stringBuilder.append("|role_id_list=").append(roleIdList.toString());
/*     */               
/* 425 */               GameServer.logger().info(stringBuilder.toString());
/*     */               
/* 427 */               KnockOutTLogManager.tlogKnockOutAward(this.activityCfgId, this.knockOutType, fightZoneId, this.corpsId, fixAwardId, mailContextArgIndex);
/*     */               
/* 429 */               break;
/*     */             }
/*     */           }
/*     */         } }
/* 433 */       return true;
/*     */     }
/*     */     
/*     */     private void onFail(int ret)
/*     */     {
/* 438 */       onFail(ret, null);
/*     */     }
/*     */     
/*     */     private void onFail(int ret, Map<String, Object> extraMap)
/*     */     {
/* 443 */       StringBuilder stringBuilder = new StringBuilder();
/* 444 */       stringBuilder.append("[crossbattle_knockout]PKnockOutAward.processImp@error");
/* 445 */       stringBuilder.append("|ret=").append(ret);
/* 446 */       stringBuilder.append("|activity_cfg_id=").append(this.activityCfgId);
/* 447 */       stringBuilder.append("|knock_out_type=").append(this.knockOutType);
/* 448 */       stringBuilder.append("|corps_id=").append(this.corpsId);
/*     */       
/* 450 */       if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */       {
/* 452 */         for (Map.Entry<String, Object> entry : extraMap.entrySet())
/*     */         {
/* 454 */           stringBuilder.append("|").append((String)entry.getKey()).append("|").append(entry.getValue());
/*     */         }
/*     */       }
/*     */       
/* 458 */       GameServer.logger().error(stringBuilder.toString());
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\knockout\PTryKnockOutAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
/*     */ package mzm.gsp.crossbattle.knockout;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.crossbattle.CrossBattleSelectionMatchInfo;
/*     */ import mzm.gsp.crossbattle.CrossBattleSelectionMatchRoleInfo;
/*     */ import mzm.gsp.crossbattle.CrossBattleSelectionProcessInfo;
/*     */ import mzm.gsp.crossbattle.SCrossBattleSelectionMatchRoleInfo;
/*     */ import mzm.gsp.crossbattle.SCrossBattleSelectionNormalRes;
/*     */ import mzm.gsp.crossbattle.SNotifyCrossBattleKnockOutRestart;
/*     */ import mzm.gsp.crossbattle.SUpdateCrossBattleSelectionProcessInfo;
/*     */ import mzm.gsp.crossbattle.confbean.CrossBattleConsts;
/*     */ import mzm.gsp.crossbattle.confbean.KnockOutCfg;
/*     */ import mzm.gsp.crossbattle.confbean.RankAwardMailItemBean;
/*     */ import mzm.gsp.crossbattle.confbean.RankAwardMailItemList;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattleFinalServerAwardCfg;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattleKnockOutCfg;
/*     */ import mzm.gsp.crossbattle.main.CrossBattleOneByOneManager;
/*     */ import mzm.gsp.crossserver.main.CrossServerInterface;
/*     */ import mzm.gsp.crossserver.main.KnockOutContext;
/*     */ import mzm.gsp.crossserver.main.KnockOutContextManager;
/*     */ import mzm.gsp.crossserver.main.KnockOutProcessContext;
/*     */ import mzm.gsp.crossserver.main.KnockOutRoleInfo;
/*     */ import mzm.gsp.crossserver.main.KnockOutTeamInfo;
/*     */ import mzm.gsp.crossserver.main.RoamType;
/*     */ import mzm.gsp.crossserver.main.RoamedKnockOutContext;
/*     */ import mzm.gsp.crossserver.main.RoamedKnockOutContextManager;
/*     */ import mzm.gsp.crossserver.main.RoamedKnockOutRoleInfo;
/*     */ import mzm.gsp.crossserver.main.RoamedKnockOutTeamInfo;
/*     */ import mzm.gsp.mail.main.MailAttachment;
/*     */ import mzm.gsp.mail.main.MailInterface;
/*     */ import mzm.gsp.mail.main.SendMailRet;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.online.event.PlayerLoginRunnable;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.LogicRunnable;
/*     */ import mzm.gsp.util.Pair;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.CrossBattleFinalAwardInfo;
/*     */ import xbean.Pod;
/*     */ import xbean.RoleCrossBattleFinalAwardInfo;
/*     */ import xtable.Role2crossbattlefinalaward;
/*     */ 
/*     */ public class POnSelectionRoleLogin extends PlayerLoginRunnable
/*     */ {
/*     */   public void process() throws Exception
/*     */   {
/*  61 */     new PKnockOutTeamCheck(((Long)this.arg).longValue()).execute();
/*     */     
/*     */ 
/*  64 */     new RKnockOutLoginCheckForRestart(((Long)this.arg).longValue()).execute();
/*     */     
/*     */ 
/*  67 */     new RKnockoutLoginCheckBeforeMatch(((Long)this.arg).longValue()).execute();
/*     */     
/*     */ 
/*  70 */     new PKnockooutLoginCheckAfterMatch(((Long)this.arg).longValue()).execute();
/*     */     
/*     */ 
/*  73 */     new PKnockoutRomanLogin(((Long)this.arg).longValue()).execute();
/*     */     
/*     */ 
/*  76 */     new PReturnOwnServer(((Long)this.arg).longValue()).execute();
/*     */     
/*     */ 
/*  79 */     new RNotifyFinalChampionOut(((Long)this.arg).longValue()).execute();
/*     */     
/*     */ 
/*  82 */     new PSendFinalSeverMailAward(((Long)this.arg).longValue()).execute();
/*     */   }
/*     */   
/*     */   public static class PSendFinalSeverMailAward extends LogicProcedure
/*     */   {
/*     */     private final long roleId;
/*     */     private String userId;
/*     */     private int roleLevel;
/*     */     
/*     */     public PSendFinalSeverMailAward(long roleId)
/*     */     {
/*  93 */       this.roleId = roleId;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  99 */       this.userId = RoleInterface.getUserId(this.roleId);
/* 100 */       if (this.userId == null)
/*     */       {
/* 102 */         return false;
/*     */       }
/* 104 */       lock(xdb.Lockeys.get(xtable.User.getTable(), this.userId));
/*     */       
/* 106 */       if (!CrossBattleKnockoutManager.isCrossBattleServerMailAwardSwitchOpen(this.roleId))
/*     */       {
/* 108 */         StringBuilder sBuilder = new StringBuilder();
/* 109 */         sBuilder.append("[crossbattle_knockout]PSendFinalSeverMailAward.processImp@switch is close");
/* 110 */         sBuilder.append("|role_id=").append(this.roleId);
/*     */         
/* 112 */         GameServer.logger().info(sBuilder.toString());
/* 113 */         return false;
/*     */       }
/*     */       
/* 116 */       RoleCrossBattleFinalAwardInfo xRoleCrossBattleFinalAwardInfo = Role2crossbattlefinalaward.get(Long.valueOf(this.roleId));
/*     */       
/* 118 */       this.roleLevel = RoleInterface.getLevel(this.roleId);
/*     */       
/* 120 */       long currentTimeMillis = DateTimeUtils.getCurrTimeInMillis();
/*     */       
/* 122 */       for (Iterator i$ = mzm.gsp.crossbattle.confbean.SCrossBattleFinalCfg.getAll().keySet().iterator(); i$.hasNext();) { int activityCfgId = ((Integer)i$.next()).intValue();
/*     */         
/* 124 */         SCrossBattleFinalServerAwardCfg sCrossBattleFinalServerAwardCfg = SCrossBattleFinalServerAwardCfg.get(activityCfgId);
/* 125 */         if (sCrossBattleFinalServerAwardCfg != null)
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/* 130 */           Map<Integer, Set<Integer>> rank2validZoneIdMap = CrossBattleFinalServerAwardManager.getFinalServerAwardInfo(activityCfgId);
/* 131 */           if ((rank2validZoneIdMap != null) && 
/*     */           
/*     */ 
/*     */ 
/*     */ 
/* 136 */             (!rank2validZoneIdMap.isEmpty()))
/*     */           {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 142 */             Set<Integer> championValidZoneIdSet = (Set)rank2validZoneIdMap.get(Integer.valueOf(1));
/* 143 */             Set<Integer> secondPlaceValidZoneIdSet = (Set)rank2validZoneIdMap.get(Integer.valueOf(2));
/* 144 */             Set<Integer> doublePlaceValidZoneIdSet = (Set)rank2validZoneIdMap.get(Integer.valueOf(3));
/* 145 */             Set<Integer> thirdPlaceValidZoneIdSet = (Set)rank2validZoneIdMap.get(Integer.valueOf(4));
/*     */             
/* 147 */             long activityLimitEndTime = ActivityInterface.getActivityLimitTimeEnd(activityCfgId);
/* 148 */             long canAwardItemTime = activityLimitEndTime + 86400000L * sCrossBattleFinalServerAwardCfg.open_interval_day_after_activity_end;
/*     */             
/*     */ 
/* 151 */             if (currentTimeMillis >= canAwardItemTime)
/*     */             {
/*     */ 
/*     */ 
/*     */ 
/* 156 */               int roleRealZoneId = GameServerInfoManager.getZoneidFromRoleid(this.roleId);
/*     */               
/* 158 */               if (xRoleCrossBattleFinalAwardInfo == null)
/*     */               {
/* 160 */                 xRoleCrossBattleFinalAwardInfo = Pod.newRoleCrossBattleFinalAwardInfo();
/* 161 */                 Role2crossbattlefinalaward.add(Long.valueOf(this.roleId), xRoleCrossBattleFinalAwardInfo);
/*     */               }
/*     */               
/* 164 */               CrossBattleFinalAwardInfo xCrossBattleFinalAwardInfo = (CrossBattleFinalAwardInfo)xRoleCrossBattleFinalAwardInfo.getActivity_award_map().get(Integer.valueOf(activityCfgId));
/*     */               
/* 166 */               if (xCrossBattleFinalAwardInfo == null)
/*     */               {
/* 168 */                 xCrossBattleFinalAwardInfo = Pod.newCrossBattleFinalAwardInfo();
/* 169 */                 xRoleCrossBattleFinalAwardInfo.getActivity_award_map().put(Integer.valueOf(activityCfgId), xCrossBattleFinalAwardInfo);
/*     */               }
/*     */               
/* 172 */               Set<Integer> xCheckedRankSet = xCrossBattleFinalAwardInfo.getChecked_award_rank_set();
/*     */               
/* 174 */               if ((championValidZoneIdSet != null) && (championValidZoneIdSet.contains(Integer.valueOf(roleRealZoneId))) && (!xCheckedRankSet.contains(Integer.valueOf(1))))
/*     */               {
/*     */ 
/* 177 */                 boolean isSendMailSuccess = sendMailAward(sCrossBattleFinalServerAwardCfg, 1, 1, activityCfgId);
/*     */                 
/* 179 */                 if (isSendMailSuccess)
/*     */                 {
/* 181 */                   xCheckedRankSet.add(Integer.valueOf(1));
/*     */                 }
/*     */               }
/*     */               
/* 185 */               if ((secondPlaceValidZoneIdSet != null) && (secondPlaceValidZoneIdSet.contains(Integer.valueOf(roleRealZoneId))) && (!xCheckedRankSet.contains(Integer.valueOf(2))))
/*     */               {
/*     */ 
/* 188 */                 boolean isSendMailSuccess = sendMailAward(sCrossBattleFinalServerAwardCfg, 2, 2, activityCfgId);
/*     */                 
/* 190 */                 if (isSendMailSuccess)
/*     */                 {
/* 192 */                   xCheckedRankSet.add(Integer.valueOf(2));
/*     */                 }
/*     */               }
/*     */               
/* 196 */               if ((doublePlaceValidZoneIdSet != null) && (doublePlaceValidZoneIdSet.contains(Integer.valueOf(roleRealZoneId))) && (!xCheckedRankSet.contains(Integer.valueOf(3))))
/*     */               {
/*     */ 
/* 199 */                 boolean isSendMailSuccess = sendMailAward(sCrossBattleFinalServerAwardCfg, 2, 3, activityCfgId);
/*     */                 
/* 201 */                 if (isSendMailSuccess)
/*     */                 {
/* 203 */                   xCheckedRankSet.add(Integer.valueOf(3));
/*     */                 }
/*     */               }
/*     */               
/* 207 */               if ((thirdPlaceValidZoneIdSet != null) && (thirdPlaceValidZoneIdSet.contains(Integer.valueOf(roleRealZoneId))) && (!xCheckedRankSet.contains(Integer.valueOf(4))))
/*     */               {
/*     */ 
/* 210 */                 boolean isSendMailSuccess = sendMailAward(sCrossBattleFinalServerAwardCfg, 3, 4, activityCfgId);
/*     */                 
/* 212 */                 if (isSendMailSuccess)
/*     */                 {
/* 214 */                   xCheckedRankSet.add(Integer.valueOf(4)); }
/*     */               }
/*     */             }
/*     */           }
/*     */         } }
/* 219 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     private boolean sendMailAward(SCrossBattleFinalServerAwardCfg sCrossBattleFinalServerAwardCfg, int realRank, int recordRank, int activityCfgId)
/*     */     {
/* 228 */       RankAwardMailItemList rankAwardMailItemList = (RankAwardMailItemList)sCrossBattleFinalServerAwardCfg.rank_2_award_item_map.get(Integer.valueOf(realRank));
/* 229 */       if (rankAwardMailItemList == null)
/*     */       {
/* 231 */         return false;
/*     */       }
/*     */       
/* 234 */       if (this.roleLevel < sCrossBattleFinalServerAwardCfg.gift_item_min_level)
/*     */       {
/* 236 */         return true;
/*     */       }
/*     */       
/* 239 */       MailAttachment mailAttachment = MailInterface.createMailAttachment();
/* 240 */       for (RankAwardMailItemBean rankAwardMailItemBean : rankAwardMailItemList.award_item_list)
/*     */       {
/* 242 */         mailAttachment.addItem(rankAwardMailItemBean.award_item_id, rankAwardMailItemBean.award_item_num);
/*     */       }
/*     */       
/* 245 */       SendMailRet sendMailRet = MailInterface.synBuildAndSendMail(this.roleId, rankAwardMailItemList.award_item_mail_cfg_id, new ArrayList(), new ArrayList(), mailAttachment, new mzm.gsp.tlog.TLogArg(mzm.gsp.tlog.LogReason.CROSS_SERVER_FINAL_SERVER_AWARD));
/*     */       
/*     */ 
/* 248 */       if (!sendMailRet.isOK())
/*     */       {
/* 250 */         return false;
/*     */       }
/*     */       
/* 253 */       CrossBattleKnockoutManager.tlogAwardFinalServerRank(this.userId, this.roleId, recordRank, activityCfgId);
/*     */       
/* 255 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   private static class RNotifyFinalChampionOut extends LogicRunnable
/*     */   {
/*     */     private final long roleId;
/*     */     
/*     */     public RNotifyFinalChampionOut(long roleId)
/*     */     {
/* 265 */       this.roleId = roleId;
/*     */     }
/*     */     
/*     */     public void process()
/*     */       throws Exception
/*     */     {
/* 271 */       int crossBattleSessionNum = CrossBattleConsts.getInstance().cross_battle_session_num;
/* 272 */       int activityCfgId = CrossBattleConsts.getInstance().CURRENT_ACTIVITY_CFG_ID;
/*     */       
/* 274 */       long activityEndTime = ActivityInterface.getActivityLimitTimeEnd(activityCfgId);
/* 275 */       if (DateTimeUtils.getCurrTimeInMillis() < activityEndTime)
/*     */       {
/* 277 */         CrossBattleOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(CrossBattleConsts.getInstance().CURRENT_ACTIVITY_CFG_ID), new PCGetCrossBattleFinalHistoryFightReq(this.roleId, crossBattleSessionNum, 3));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private static class PKnockOutTeamCheck
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final long roleId;
/*     */     
/*     */ 
/*     */     public PKnockOutTeamCheck(long roleId)
/*     */     {
/* 291 */       this.roleId = roleId;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 297 */       Long mapInstanceId = Long.valueOf(MapInterface.getRoleWorldInstanceId(this.roleId));
/*     */       
/* 299 */       if (mapInstanceId == CrossBattleKnockOutPrepareWorldManager.getInstance().getPrepareWorldId())
/*     */       {
/* 301 */         Integer knockOutType = CrossBattleKnockOutPrepareWorldManager.getInstance().getKnockOutType();
/* 302 */         if (knockOutType == null)
/*     */         {
/* 304 */           return false;
/*     */         }
/*     */         
/* 307 */         SCrossBattleKnockOutCfg sCrossBattleKnockOutCfg = SCrossBattleKnockOutCfg.get(CrossBattleConsts.getInstance().CURRENT_ACTIVITY_CFG_ID);
/* 308 */         if (sCrossBattleKnockOutCfg == null)
/*     */         {
/* 310 */           return false;
/*     */         }
/*     */         
/* 313 */         KnockOutCfg knockOutCfg = (KnockOutCfg)sCrossBattleKnockOutCfg.knockOutTypeCfgMap.get(knockOutType);
/* 314 */         if (knockOutCfg == null)
/*     */         {
/* 316 */           return false;
/*     */         }
/*     */         
/* 319 */         Long teamId = TeamInterface.getTeamidByRoleid(this.roleId, false);
/* 320 */         if (teamId == null)
/*     */         {
/* 322 */           RoleStatusInterface.unsetStatus(this.roleId, 1551);
/* 323 */           MapInterface.forceTransferToScene(this.roleId, MapInterface.getBigWorldid(), knockOutCfg.out_map_cfg_id, knockOutCfg.out_map_transfer_x, knockOutCfg.out_map_transfer_y, null);
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/* 328 */           List<Long> teamMemberList = TeamInterface.getTeamMemberList(teamId.longValue(), false);
/* 329 */           lock(xtable.Role2properties.getTable(), teamMemberList);
/*     */           
/*     */ 
/* 332 */           TeamInterface.returnTeam(this.roleId);
/*     */         }
/*     */       }
/* 335 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private static class RKnockOutLoginCheckForRestart
/*     */     extends LogicRunnable
/*     */   {
/*     */     private final long roleId;
/*     */     
/*     */     public RKnockOutLoginCheckForRestart(long roleId)
/*     */     {
/* 347 */       this.roleId = roleId;
/*     */     }
/*     */     
/*     */     public void process()
/*     */       throws Exception
/*     */     {
/* 353 */       if (GameServerInfoManager.isRoamServer())
/*     */       {
/* 355 */         return;
/*     */       }
/*     */       
/* 358 */       new POnSelectionRoleLogin.PNotifyKnockOutQualification(this.roleId).call();
/*     */       
/* 360 */       Pair<Long, Integer> pair = CrossBattleKnockoutManager.getRoleKnockOutRestartInfo(this.roleId);
/* 361 */       if (pair == null)
/*     */       {
/* 363 */         return;
/*     */       }
/*     */       
/* 366 */       SCrossBattleKnockOutCfg sCrossBattleKnockOutCfg = SCrossBattleKnockOutCfg.get(CrossBattleConsts.getInstance().CURRENT_ACTIVITY_CFG_ID);
/* 367 */       if (sCrossBattleKnockOutCfg == null)
/*     */       {
/* 369 */         return;
/*     */       }
/*     */       
/* 372 */       KnockOutCfg knockOutCfg = (KnockOutCfg)sCrossBattleKnockOutCfg.knockOutTypeCfgMap.get(pair.second);
/* 373 */       if (knockOutCfg == null)
/*     */       {
/* 375 */         return;
/*     */       }
/*     */       
/* 378 */       SNotifyCrossBattleKnockOutRestart knocokOutRestart = new SNotifyCrossBattleKnockOutRestart();
/* 379 */       knocokOutRestart.fight_type = ((Integer)pair.second).intValue();
/* 380 */       knocokOutRestart.prepare_world_begin_time = (((Long)pair.first).longValue() / 1000L);
/* 381 */       knocokOutRestart.prepare_world_end_time = ((((Long)pair.first).longValue() + knockOutCfg.prepare_world_countdown * 60000L) / 1000L);
/*     */       
/*     */ 
/* 384 */       OnlineManager.getInstance().send(this.roleId, knocokOutRestart);
/*     */     }
/*     */   }
/*     */   
/*     */   private static class PNotifyKnockOutQualification extends LogicProcedure
/*     */   {
/*     */     private final long roleId;
/*     */     
/*     */     public PNotifyKnockOutQualification(long roleId)
/*     */     {
/* 394 */       this.roleId = roleId;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 400 */       long corpsId = mzm.gsp.corps.main.CorpsInterface.getRoleCorpsId(this.roleId, true);
/*     */       
/* 402 */       if (corpsId < 0L)
/*     */       {
/* 404 */         return false;
/*     */       }
/*     */       
/* 407 */       CrossBattleKnockoutManager.checkCanJoinNowStageKnockOut(this.roleId, corpsId);
/* 408 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private static class RKnockoutLoginCheckBeforeMatch
/*     */     extends LogicRunnable
/*     */   {
/*     */     private final long roleId;
/*     */     
/*     */     public RKnockoutLoginCheckBeforeMatch(long roleId)
/*     */     {
/* 420 */       this.roleId = roleId;
/*     */     }
/*     */     
/*     */     public void process()
/*     */       throws Exception
/*     */     {
/* 426 */       if (GameServerInfoManager.isRoamServer())
/*     */       {
/* 428 */         return;
/*     */       }
/*     */       
/* 431 */       Long worldInstanceId = Long.valueOf(MapInterface.getRoleWorldInstanceId(this.roleId));
/* 432 */       if (worldInstanceId != CrossBattleKnockOutPrepareWorldManager.getInstance().getPrepareWorldId())
/*     */       {
/* 434 */         return;
/*     */       }
/*     */       
/* 437 */       Long lastEnterTime = CrossBattleKnockOutPrepareWorldManager.getInstance().getPrepareWorldLastEnterTime();
/* 438 */       if (lastEnterTime == null)
/*     */       {
/* 440 */         return;
/*     */       }
/*     */       
/* 443 */       Integer knockOutType = CrossBattleKnockOutPrepareWorldManager.getInstance().getKnockOutType();
/* 444 */       if (knockOutType == null)
/*     */       {
/* 446 */         return;
/*     */       }
/*     */       
/* 449 */       KnockOutHandler knockOutHandler = CrossBattleKnockoutManager.getKnockOutHandler(knockOutType.intValue());
/* 450 */       if (knockOutHandler == null)
/*     */       {
/* 452 */         return;
/*     */       }
/*     */       
/* 455 */       int leftSeconds = (int)((lastEnterTime.longValue() - DateTimeUtils.getCurrTimeInMillis()) / 1000L);
/* 456 */       xio.Protocol enterPrepareWorldProtocol = knockOutHandler.getEnterPrepareWorldProtocol(leftSeconds);
/*     */       
/* 458 */       OnlineManager.getInstance().send(this.roleId, enterPrepareWorldProtocol);
/*     */     }
/*     */   }
/*     */   
/*     */   private static class PKnockooutLoginCheckAfterMatch
/*     */     extends LogicRunnable
/*     */   {
/*     */     private final long roleId;
/*     */     
/*     */     public PKnockooutLoginCheckAfterMatch(long roleId)
/*     */     {
/* 469 */       this.roleId = roleId;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void process()
/*     */       throws Exception
/*     */     {
/* 477 */       Long contextid = xtable.Role2selectionfinalcontextid.select(Long.valueOf(this.roleId));
/* 478 */       if (contextid == null)
/*     */       {
/* 480 */         return;
/*     */       }
/*     */       
/* 483 */       KnockOutContext context = KnockOutContextManager.getInstance().getContext(contextid.longValue());
/* 484 */       if (context == null)
/*     */       {
/* 486 */         return;
/*     */       }
/*     */       
/* 489 */       KnockOutProcessContext processContext = context.getSelectionFinalPhaseContext();
/* 490 */       if (processContext == null)
/*     */       {
/* 492 */         return;
/*     */       }
/*     */       
/*     */ 
/* 496 */       KnockOutTeamInfo opponentTeamInfo = context.getOpponentCrossBattleTeamInfo();
/* 497 */       if ((opponentTeamInfo == null) || (opponentTeamInfo.getCrossBattleRoleInfoList().isEmpty()))
/*     */       {
/* 499 */         onSelectionLoginCheckAfterMatch(22);
/* 500 */         return;
/*     */       }
/* 502 */       KnockOutTeamInfo ownTeamInfo = context.getCrossBattleTeamInfo();
/*     */       
/* 504 */       SCrossBattleSelectionMatchRoleInfo selectionMatchRoleInfo = new SCrossBattleSelectionMatchRoleInfo();
/* 505 */       selectionMatchRoleInfo.fight_stage = context.fightStage;
/* 506 */       selectionMatchRoleInfo.fight_type = context.fightType;
/* 507 */       selectionMatchRoleInfo.matchteamainfos.corps_icon = ownTeamInfo.getCorpsBadgeId();
/* 508 */       selectionMatchRoleInfo.matchteamainfos.corps_id = ownTeamInfo.getCorpsId();
/* 509 */       selectionMatchRoleInfo.matchteamainfos.corps_name.setString(ownTeamInfo.getCorpsName(), "UTF-8");
/* 510 */       selectionMatchRoleInfo.matchteamainfos.corps_zone_id = ownTeamInfo.getZoneId();
/* 511 */       for (KnockOutRoleInfo roleCrossBattleInfo : ownTeamInfo.getCrossBattleRoleInfoList())
/*     */       {
/* 513 */         Integer process = processContext.getRoleProcess(roleCrossBattleInfo.getRoleid());
/* 514 */         if (process == null)
/*     */         {
/* 516 */           process = Integer.valueOf(0);
/*     */         }
/*     */         
/* 519 */         CrossBattleSelectionMatchRoleInfo matchRoleInfo = new CrossBattleSelectionMatchRoleInfo();
/* 520 */         fillSelectionFinalMatchInfo(matchRoleInfo, roleCrossBattleInfo, process.intValue());
/* 521 */         selectionMatchRoleInfo.matchteamainfos.match_role_list.add(matchRoleInfo);
/*     */       }
/*     */       
/* 524 */       selectionMatchRoleInfo.matchteambinfos.corps_zone_id = opponentTeamInfo.getZoneId();
/* 525 */       selectionMatchRoleInfo.matchteambinfos.corps_icon = opponentTeamInfo.getCorpsBadgeId();
/* 526 */       selectionMatchRoleInfo.matchteambinfos.corps_name.setString(opponentTeamInfo.getCorpsName(), "UTF-8");
/* 527 */       selectionMatchRoleInfo.matchteambinfos.corps_id = opponentTeamInfo.getCorpsId();
/* 528 */       for (KnockOutRoleInfo roleCrossBattleInfo : opponentTeamInfo.getCrossBattleRoleInfoList())
/*     */       {
/* 530 */         Integer process = processContext.getRoleProcess(roleCrossBattleInfo.getRoleid());
/* 531 */         if (process == null)
/*     */         {
/* 533 */           process = Integer.valueOf(0);
/*     */         }
/*     */         
/* 536 */         CrossBattleSelectionMatchRoleInfo matchRoleInfo = new CrossBattleSelectionMatchRoleInfo();
/* 537 */         fillSelectionFinalMatchInfo(matchRoleInfo, roleCrossBattleInfo, process.intValue());
/* 538 */         selectionMatchRoleInfo.matchteambinfos.match_role_list.add(matchRoleInfo);
/*     */       }
/* 540 */       OnlineManager.getInstance().send(this.roleId, selectionMatchRoleInfo);
/*     */     }
/*     */     
/*     */     public void fillSelectionFinalMatchInfo(CrossBattleSelectionMatchRoleInfo matchRoleInfo, KnockOutRoleInfo roleCrossBattleInfo, int process)
/*     */       throws java.io.UnsupportedEncodingException
/*     */     {
/* 546 */       matchRoleInfo.avatar_id = roleCrossBattleInfo.getAvatarId();
/* 547 */       matchRoleInfo.gender = roleCrossBattleInfo.getGender();
/* 548 */       matchRoleInfo.occupation = roleCrossBattleInfo.getOccupation();
/* 549 */       matchRoleInfo.process = process;
/* 550 */       matchRoleInfo.role_level = roleCrossBattleInfo.getLevel();
/* 551 */       matchRoleInfo.role_name.setString(roleCrossBattleInfo.getRoleName(), "UTF-8");
/* 552 */       matchRoleInfo.roleid = roleCrossBattleInfo.getRoleid();
/*     */     }
/*     */     
/*     */     private void onSelectionLoginCheckAfterMatch(int ret)
/*     */     {
/* 557 */       StringBuilder sb = new StringBuilder();
/* 558 */       sb.append("[crossbattle_selection]POnSelectionRoleLogin.onPSelectionLoginCheckAfterMatch");
/* 559 */       sb.append("|role_id=").append(this.roleId);
/* 560 */       sb.append("|ret=").append(ret);
/*     */       
/* 562 */       GameServer.logger().error(sb.toString());
/*     */       
/* 564 */       SCrossBattleSelectionNormalRes sCrossBattleSelectionNormalRes = new SCrossBattleSelectionNormalRes();
/* 565 */       sCrossBattleSelectionNormalRes.ret = ret;
/* 566 */       OnlineManager.getInstance().send(this.roleId, sCrossBattleSelectionNormalRes);
/*     */     }
/*     */   }
/*     */   
/*     */   private static class PKnockoutRomanLogin
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final long roleId;
/*     */     
/*     */     public PKnockoutRomanLogin(long roleId)
/*     */     {
/* 577 */       this.roleId = roleId;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 583 */       if (!GameServerInfoManager.isRoamServer())
/*     */       {
/* 585 */         return false;
/*     */       }
/*     */       
/* 588 */       String userid = RoleInterface.getUserId(this.roleId);
/* 589 */       if (userid == null)
/*     */       {
/* 591 */         onSelectionRomanLoginFail(20);
/* 592 */         return false;
/*     */       }
/*     */       
/*     */ 
/* 596 */       RoamedKnockOutContext roamedContext = (RoamedKnockOutContext)CrossBattleMatchRomaContextManager.getInstance().getValue(Long.valueOf(this.roleId));
/* 597 */       if (roamedContext == null)
/*     */       {
/* 599 */         roamedContext = getRoamedMatchContext(userid);
/*     */       }
/* 601 */       if (roamedContext == null)
/*     */       {
/* 603 */         onSelectionRomanLoginFail(21);
/* 604 */         return false;
/*     */       }
/*     */       
/*     */ 
/* 608 */       SCrossBattleSelectionMatchRoleInfo selectionMatchInfo = new SCrossBattleSelectionMatchRoleInfo();
/* 609 */       selectionMatchInfo.fight_type = roamedContext.fightType;
/* 610 */       selectionMatchInfo.fight_stage = roamedContext.fightStage;
/* 611 */       Set<Long> allRoleids = new java.util.HashSet();
/*     */       
/* 613 */       RoamedKnockOutTeamInfo ownTeamInfo = roamedContext.crossBattleTeamInfo;
/* 614 */       selectionMatchInfo.matchteamainfos.corps_icon = ownTeamInfo.getCorpsBadgeId();
/* 615 */       selectionMatchInfo.matchteamainfos.corps_id = ownTeamInfo.getCorpsId();
/* 616 */       selectionMatchInfo.matchteamainfos.corps_name.setString(ownTeamInfo.getCorpsName(), "UTF-8");
/* 617 */       selectionMatchInfo.matchteamainfos.corps_zone_id = ownTeamInfo.getPhysZoneId();
/*     */       
/* 619 */       for (RoamedKnockOutRoleInfo roamedRoleCrossBattleInfo : roamedContext.crossBattleTeamInfo.getCrossBattleRoleInfoList())
/*     */       {
/* 621 */         CrossBattleSelectionMatchRoleInfo matchRoleInfo = new CrossBattleSelectionMatchRoleInfo();
/* 622 */         CrossBattleKnockoutManager.fillCrossBattleSelectionMatchInfo(matchRoleInfo, roamedRoleCrossBattleInfo);
/* 623 */         selectionMatchInfo.matchteamainfos.match_role_list.add(matchRoleInfo);
/* 624 */         allRoleids.add(Long.valueOf(roamedRoleCrossBattleInfo.getRoleid()));
/*     */       }
/*     */       
/* 627 */       RoamedKnockOutTeamInfo opponentTeamInfo = roamedContext.opponentCrossBattleTeamInfo;
/*     */       
/* 629 */       selectionMatchInfo.matchteambinfos.corps_icon = opponentTeamInfo.getCorpsBadgeId();
/* 630 */       selectionMatchInfo.matchteambinfos.corps_id = opponentTeamInfo.getCorpsId();
/* 631 */       selectionMatchInfo.matchteambinfos.corps_name.setString(opponentTeamInfo.getCorpsName(), "UTF-8");
/* 632 */       selectionMatchInfo.matchteambinfos.corps_zone_id = opponentTeamInfo.getPhysZoneId();
/* 633 */       for (RoamedKnockOutRoleInfo roamedRoleCrossBattleInfo : roamedContext.opponentCrossBattleTeamInfo.getCrossBattleRoleInfoList())
/*     */       {
/* 635 */         CrossBattleSelectionMatchRoleInfo matchRoleInfo = new CrossBattleSelectionMatchRoleInfo();
/* 636 */         CrossBattleKnockoutManager.fillCrossBattleSelectionMatchInfo(matchRoleInfo, roamedRoleCrossBattleInfo);
/* 637 */         selectionMatchInfo.matchteambinfos.match_role_list.add(matchRoleInfo);
/* 638 */         allRoleids.add(Long.valueOf(roamedRoleCrossBattleInfo.getRoleid()));
/*     */       }
/* 640 */       OnlineManager.getInstance().send(this.roleId, selectionMatchInfo);
/*     */       
/*     */ 
/*     */ 
/* 644 */       SUpdateCrossBattleSelectionProcessInfo updateProcessInfo = new SUpdateCrossBattleSelectionProcessInfo();
/* 645 */       updateProcessInfo.fight_type = roamedContext.fightType;
/* 646 */       CrossBattleSelectionProcessInfo crossMatchProcessInfo = new CrossBattleSelectionProcessInfo();
/* 647 */       crossMatchProcessInfo.process = 3;
/* 648 */       crossMatchProcessInfo.roleid = this.roleId;
/*     */       
/* 650 */       updateProcessInfo.process_infos.add(crossMatchProcessInfo);
/*     */       
/* 652 */       OnlineManager.getInstance().sendMulti(updateProcessInfo, allRoleids);
/*     */       
/* 654 */       StringBuilder sb = new StringBuilder();
/* 655 */       sb.append("[crossbattle_selectionfinal]POnSelectionRoleLogin.PSelectionRomanLogin@roam login success");
/* 656 */       sb.append("|role_id=").append(this.roleId);
/* 657 */       sb.append("|roam_cross_battle_context=").append(roamedContext);
/* 658 */       GameServer.logger().info(sb.toString());
/*     */       
/* 660 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     private RoamedKnockOutContext getRoamedMatchContext(String userid)
/*     */     {
/* 673 */       RoamType roamType = CrossServerInterface.getRoamType(userid);
/* 674 */       if ((roamType == null) || (roamType != RoamType.CROSS_BATTLE_SELECTION_FINAL))
/*     */       {
/* 676 */         GameServer.logger().info(String.format("[crossbattle_selection]POnRoleLogin.processImp@do not have roam type|userid=%s", new Object[] { userid }));
/*     */         
/* 678 */         return null;
/*     */       }
/*     */       
/* 681 */       Long roamedInstanceId = CrossServerInterface.getRoamedInstanceid(userid);
/* 682 */       if (roamedInstanceId == null)
/*     */       {
/* 684 */         GameServer.logger().info(String.format("[crossbattle_selection]POnRoleLogin.processImp@do not have roamed instanceId|userid=%s", new Object[] { userid }));
/*     */         
/*     */ 
/* 687 */         return null;
/*     */       }
/*     */       
/* 690 */       RoamedKnockOutContext roamedCrossBattleContext = RoamedKnockOutContextManager.getInstance().getRoamedMathContext(roamedInstanceId.longValue());
/*     */       
/* 692 */       if (roamedCrossBattleContext == null)
/*     */       {
/* 694 */         GameServer.logger().info(String.format("[crossbattle_selection]POnRoleLogin.processImp@do not has roamed match context|userid=%s", new Object[] { userid }));
/*     */         
/*     */ 
/*     */ 
/* 698 */         return null;
/*     */       }
/* 700 */       return roamedCrossBattleContext;
/*     */     }
/*     */     
/*     */     private void onSelectionRomanLoginFail(int ret)
/*     */     {
/* 705 */       StringBuilder sb = new StringBuilder();
/* 706 */       sb.append("[crossbattle_selectionfinal]POnSelectionRoleLogin.PSelectionRomanLogin@roam login failed");
/* 707 */       sb.append("|role_id=").append(this.roleId);
/*     */       
/* 709 */       GameServer.logger().error(sb.toString());
/*     */       
/* 711 */       SCrossBattleSelectionNormalRes sCrossBattleSelectionNormalRes = new SCrossBattleSelectionNormalRes();
/* 712 */       sCrossBattleSelectionNormalRes.ret = ret;
/*     */       
/* 714 */       OnlineManager.getInstance().send(this.roleId, sCrossBattleSelectionNormalRes);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private static class PReturnOwnServer
/*     */     extends LogicRunnable
/*     */   {
/*     */     private final long roleId;
/*     */     
/*     */     public PReturnOwnServer(long roleId)
/*     */     {
/* 726 */       this.roleId = roleId;
/*     */     }
/*     */     
/*     */     public void process()
/*     */       throws Exception
/*     */     {
/* 732 */       String userId = RoleInterface.getUserId(this.roleId);
/*     */       
/*     */ 
/* 735 */       final KnockOutEndContext knoutOutFightEndContext = (KnockOutEndContext)KnockOutEndContextManager.getInstance().getValue(userId);
/* 736 */       if (knoutOutFightEndContext == null)
/*     */       {
/* 738 */         return;
/*     */       }
/*     */       
/* 741 */       int nowActivityCfgId = CrossBattleConsts.getInstance().CURRENT_ACTIVITY_CFG_ID;
/* 742 */       SCrossBattleKnockOutCfg sCrossBattleKnockOutCfg = SCrossBattleKnockOutCfg.get(nowActivityCfgId);
/* 743 */       if (sCrossBattleKnockOutCfg == null)
/*     */       {
/* 745 */         return;
/*     */       }
/*     */       
/* 748 */       KnockOutCfg knockOutCfg = (KnockOutCfg)sCrossBattleKnockOutCfg.knockOutTypeCfgMap.get(Integer.valueOf(knoutOutFightEndContext.fightType));
/* 749 */       if (knockOutCfg == null)
/*     */       {
/* 751 */         return;
/*     */       }
/*     */       
/* 754 */       MapInterface.forceTransferToScene(this.roleId, MapInterface.getCenterWorldid(), knockOutCfg.out_map_cfg_id, knockOutCfg.out_map_transfer_x, knockOutCfg.out_map_transfer_y);
/*     */       
/*     */ 
/* 757 */       knoutOutFightEndContext.addOnlineRole(this.roleId);
/*     */       
/*     */ 
/* 760 */       xdb.Xdb.executor().schedule(new PQueryToNotifyFightResult(this.roleId, knoutOutFightEndContext.ownCorpsId, knoutOutFightEndContext.opponentCorpsId, knoutOutFightEndContext.fightType, knoutOutFightEndContext.fightStage, knoutOutFightEndContext.fightIndexId, knoutOutFightEndContext.winOrLose), 1200L, java.util.concurrent.TimeUnit.MILLISECONDS);
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 767 */       boolean ret = new PCheckTeamPro(this.roleId).call();
/* 768 */       if (!ret)
/*     */       {
/* 770 */         List<Long> teamList = new ArrayList();
/* 771 */         teamList.addAll(knoutOutFightEndContext.allRoleIdList);
/* 772 */         teamList.remove(Long.valueOf(this.roleId));
/* 773 */         teamList.add(0, Long.valueOf(this.roleId));
/*     */         
/*     */ 
/* 776 */         TeamInterface.formatCreateTeamAsTmpLeave(knoutOutFightEndContext.getLeaderid(), teamList);
/*     */         
/* 778 */         GameServer.logger().info(String.format("[crossbattle_knockout]PReturnOwnServer.processImp@format create team|roleids=%s", new Object[] { teamList }));
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 783 */       boolean checkTeamAgain = new PCheckTeamPro(this.roleId).call();
/* 784 */       if (checkTeamAgain)
/*     */       {
/*     */ 
/* 787 */         new PReturnTeamPro(this.roleId).call();
/*     */         
/* 789 */         GameServer.logger().info(String.format("[crossbattle_knockout]PReturnOwnServer.processImp@return team!|roleid=%d|all_role_id_list=%s", new Object[] { Long.valueOf(this.roleId), knoutOutFightEndContext.allRoleIdList.toString() }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 794 */         if (this.roleId == knoutOutFightEndContext.getLeaderid())
/*     */         {
/* 796 */           new PAppointLeaderPro(this.roleId).call();
/*     */           
/* 798 */           GameServer.logger().info(String.format("[crossbattle_knockout]PReturnOwnServer.processImp@appoint leader!|roleid=%d|all_role_id_list=%s", new Object[] { Long.valueOf(this.roleId), knoutOutFightEndContext.allRoleIdList.toString() }));
/*     */         }
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 805 */         boolean isAllOnline = knoutOutFightEndContext.isAllOnline();
/* 806 */         if (isAllOnline)
/*     */         {
/* 808 */           new PDesignTeamPro(this.roleId, knoutOutFightEndContext.allRoleIdList).call();
/*     */           
/* 810 */           new LogicProcedure()
/*     */           {
/*     */ 
/*     */             protected boolean processImp()
/*     */               throws Exception
/*     */             {
/* 816 */               lock(xtable.Role2properties.getTable(), knoutOutFightEndContext.allRoleIdList);
/* 817 */               for (Iterator i$ = knoutOutFightEndContext.allRoleIdList.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */                 
/* 819 */                 RoleStatusInterface.unsetStatus(roleid, 65);
/* 820 */                 RoleStatusInterface.unsetStatus(roleid, 1551);
/*     */               }
/* 822 */               return true;
/*     */             }
/* 824 */           }.call();
/* 825 */           GameServer.logger().info(String.format("[crossbattle_knockout]PReturnOwnServer.processImp@is all online!|roleid=%d|all_role_id_list=%s", new Object[] { Long.valueOf(this.roleId), knoutOutFightEndContext.allRoleIdList.toString() }));
/*     */         }
/*     */         
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/*     */ 
/* 833 */         GameServer.logger().info(String.format("[crossbattle_knockout]PReturnOwnServer.processImp@check again,do not has team!|roleid=%d", new Object[] { Long.valueOf(this.roleId) }));
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     private static class PCheckTeamPro
/*     */       extends LogicProcedure
/*     */     {
/*     */       private final long roleid;
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */       PCheckTeamPro(long roleid)
/*     */       {
/* 851 */         this.roleid = roleid;
/*     */       }
/*     */       
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/* 857 */         return TeamInterface.isRoleInTeam(this.roleid, true);
/*     */       }
/*     */     }
/*     */     
/*     */     private static class PReturnTeamPro
/*     */       extends LogicProcedure
/*     */     {
/*     */       private final long roleid;
/*     */       
/*     */       PReturnTeamPro(long roleid)
/*     */       {
/* 868 */         this.roleid = roleid;
/*     */       }
/*     */       
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/* 874 */         TeamInterface.returnTeam(this.roleid);
/*     */         
/* 876 */         GameServer.logger().info(String.format("[Ladder]ROnRoleLogin.processImp@team role return team|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */         
/*     */ 
/* 879 */         return true;
/*     */       }
/*     */     }
/*     */     
/*     */     private static class PAppointLeaderPro
/*     */       extends LogicProcedure
/*     */     {
/*     */       private final long roleid;
/*     */       
/*     */       PAppointLeaderPro(long roleid)
/*     */       {
/* 890 */         this.roleid = roleid;
/*     */       }
/*     */       
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/* 896 */         Long teamid = TeamInterface.getTeamidByRoleid(this.roleid, false);
/* 897 */         if (teamid != null)
/*     */         {
/* 899 */           long oldLeaderid = TeamInterface.getTeamLeaderByTeamid(teamid.longValue(), false);
/* 900 */           TeamInterface.appointLeader(teamid.longValue(), this.roleid);
/*     */           
/* 902 */           GameServer.logger().info(String.format("[cross_battle_selection]PAppointLeaderPro.processImp@appoint leader leader|roleid=%d|oldLeaderid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(oldLeaderid) }));
/*     */         }
/*     */         
/*     */ 
/*     */ 
/* 907 */         return true;
/*     */       }
/*     */     }
/*     */     
/*     */     private static class PDesignTeamPro
/*     */       extends LogicProcedure
/*     */     {
/*     */       private final long roleid;
/*     */       private final List<Long> allRoles;
/*     */       
/*     */       PDesignTeamPro(long roleid, List<Long> allRoles)
/*     */       {
/* 919 */         this.roleid = roleid;
/* 920 */         this.allRoles = allRoles;
/*     */       }
/*     */       
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/* 926 */         Long teamId = TeamInterface.getTeamidByRoleid(this.roleid, false);
/* 927 */         if (teamId != null)
/*     */         {
/* 929 */           TeamInterface.designTeam(teamId.longValue(), this.allRoles);
/*     */         }
/*     */         else
/*     */         {
/* 933 */           GameServer.logger().info(String.format("[cross_battle_selection]PDesignTeamPro.processImp@role is not in team|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */         }
/*     */         
/*     */ 
/* 937 */         return true;
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\knockout\POnSelectionRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
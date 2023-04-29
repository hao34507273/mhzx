/*     */ package mzm.gsp.worldgoal.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.confbean.SActivityCfg;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityLimitTimeStageEnum;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.mail.main.MailInterface;
/*     */ import mzm.gsp.mail.main.SendMailRet;
/*     */ import mzm.gsp.map.main.ControllerInterface;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.map.main.scene.object.MapEntityType;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.worldgoal.confbean.SWorldGoalCfg;
/*     */ import mzm.gsp.worldgoal.confbean.SWorldGoalCommitItemSumAwardCfg;
/*     */ import mzm.gsp.worldgoal.confbean.SWorldGoalItemCfg;
/*     */ import mzm.gsp.worldgoal.confbean.SectionInfo;
/*     */ import mzm.gsp.worldgoal.event.SectionPonitChange;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Pod;
/*     */ import xbean.RoleWorldGoalInfo;
/*     */ import xbean.Section;
/*     */ import xbean.WorldGoal;
/*     */ import xbean.WorldGoalActivityInfo;
/*     */ import xtable.Role2worldgoalinfo;
/*     */ import xtable.Worldgoals;
/*     */ 
/*     */ public class WorldGoalManager
/*     */ {
/*  45 */   static volatile boolean postInitFlag = false;
/*  46 */   static Logger logger = Logger.getLogger("worldgoal");
/*     */   
/*     */   static void init()
/*     */   {
/*  50 */     WorldGoalActivityHandler handler = new WorldGoalActivityHandler();
/*  51 */     ActivityInterface.registerActivityByLogicType(58, handler);
/*     */   }
/*     */   
/*     */   static void postInit()
/*     */   {
/*  56 */     postInitFlag = true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isWorldGoalSwitchOpen(int activityCfgid)
/*     */   {
/*  66 */     if (!OpenInterface.getOpenStatus(168))
/*     */     {
/*  68 */       return false;
/*     */     }
/*  70 */     SWorldGoalCfg cfg = SWorldGoalCfg.get(activityCfgid);
/*  71 */     if (cfg == null)
/*     */     {
/*  73 */       return false;
/*     */     }
/*  75 */     if (!OpenInterface.getOpenStatus(cfg.moduleid))
/*     */     {
/*  77 */       return false;
/*     */     }
/*  79 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isWorldGoalSwitchOpenForRole(long roleid, int activityCfgid)
/*     */   {
/*  90 */     if (!OpenInterface.getOpenStatus(168))
/*     */     {
/*  92 */       return false;
/*     */     }
/*  94 */     SWorldGoalCfg cfg = SWorldGoalCfg.get(activityCfgid);
/*  95 */     if (cfg == null)
/*     */     {
/*  97 */       return false;
/*     */     }
/*  99 */     if (!OpenInterface.getOpenStatus(cfg.moduleid))
/*     */     {
/* 101 */       return false;
/*     */     }
/* 103 */     if (OpenInterface.isBanPlay(roleid, 168))
/*     */     {
/* 105 */       OpenInterface.sendBanPlayMsg(roleid, 168);
/* 106 */       return false;
/*     */     }
/* 108 */     if (OpenInterface.isBanPlay(roleid, cfg.moduleid))
/*     */     {
/* 110 */       OpenInterface.sendBanPlayMsg(roleid, cfg.moduleid);
/* 111 */       return false;
/*     */     }
/* 113 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean checkRoleStatus(long roleid)
/*     */   {
/* 124 */     return RoleStatusInterface.checkCanSetStatus(roleid, 70, true);
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
/*     */   static int getRoleCanCommitNum(String userid, long roleid, int activityCfgid)
/*     */   {
/* 139 */     return ActivityInterface.getActivityCfg(activityCfgid).count - ActivityInterface.getActivityCount(userid, roleid, activityCfgid, true);
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
/*     */   static int getActivityCanCommitPoint(int activityCfgid)
/*     */   {
/* 152 */     SWorldGoalCfg cfg = SWorldGoalCfg.get(activityCfgid);
/* 153 */     long globalActivityCfgid = GameServerInfoManager.toGlobalId(activityCfgid);
/* 154 */     WorldGoal xWorldGoal = Worldgoals.get(Long.valueOf(globalActivityCfgid));
/* 155 */     if ((xWorldGoal.getCurrent_section_id() == cfg.section_num) && (((Section)xWorldGoal.getSections().get(Integer.valueOf(cfg.section_num))).getPoint() >= ((SectionInfo)cfg.section_infos.get(Integer.valueOf(cfg.section_num))).section_total_point))
/*     */     {
/*     */ 
/* 158 */       return 0;
/*     */     }
/*     */     
/* 161 */     int activityCanCommitPoint = ((SectionInfo)cfg.section_infos.get(Integer.valueOf(xWorldGoal.getCurrent_section_id()))).section_total_point - ((Section)xWorldGoal.getSections().get(Integer.valueOf(xWorldGoal.getCurrent_section_id()))).getPoint();
/*     */     
/* 163 */     for (int i = xWorldGoal.getCurrent_section_id() + 1; i <= cfg.section_num; i++)
/*     */     {
/* 165 */       activityCanCommitPoint += ((SectionInfo)cfg.section_infos.get(Integer.valueOf(i))).section_total_point;
/*     */     }
/* 167 */     return activityCanCommitPoint;
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
/*     */   static int getSectionCanCommitPoint(int activityCfgid, int sectionid)
/*     */   {
/* 181 */     long globalActivityCfgid = GameServerInfoManager.toGlobalId(activityCfgid);
/* 182 */     WorldGoal xWorldGoal = Worldgoals.get(Long.valueOf(globalActivityCfgid));
/* 183 */     if (xWorldGoal.getCurrent_section_id() < sectionid)
/*     */     {
/* 185 */       return -1;
/*     */     }
/* 187 */     if (xWorldGoal.getCurrent_section_id() == sectionid)
/*     */     {
/* 189 */       return ((SectionInfo)SWorldGoalCfg.get(activityCfgid).section_infos.get(Integer.valueOf(sectionid))).section_total_point - ((Section)xWorldGoal.getSections().get(Integer.valueOf(sectionid))).getPoint();
/*     */     }
/*     */     
/* 192 */     return 0;
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
/*     */ 
/*     */ 
/*     */   static int commitItemAtNPC(long roleid, int activityCfgid, int maxCommitNum, Map<Integer, Integer> itemid2Commitnum)
/*     */   {
/* 209 */     int realCommitNum = 0;
/* 210 */     List<Integer> itemids = ItemInterface.getSamePriceItems(SWorldGoalCfg.get(activityCfgid).same_price_item_id);
/* 211 */     for (Iterator i$ = itemids.iterator(); i$.hasNext();) { int itemid = ((Integer)i$.next()).intValue();
/*     */       
/* 213 */       while (ItemInterface.removeItemById(roleid, itemid, 1, new TLogArg(LogReason.WORLD_GOAL_COMMIT_ITEM_REMOVE)))
/*     */       {
/* 215 */         itemid2Commitnum.put(Integer.valueOf(itemid), Integer.valueOf(itemid2Commitnum.get(Integer.valueOf(itemid)) == null ? 1 : ((Integer)itemid2Commitnum.get(Integer.valueOf(itemid))).intValue() + 1));
/* 216 */         realCommitNum++; if (realCommitNum >= maxCommitNum)
/*     */           break;
/*     */       }
/* 219 */       if (realCommitNum >= maxCommitNum)
/*     */         break;
/*     */     }
/* 222 */     return realCommitNum;
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
/*     */ 
/*     */ 
/*     */   static int commitItemAtEntity(long roleid, int activityCfgid, int maxCommitNum, Map<Integer, Integer> itemid2Commitnum, int maxCommitPoint)
/*     */   {
/* 239 */     int realCommitPoint = 0;
/* 240 */     int realCommitNum = 0;
/* 241 */     List<Integer> itemids = ItemInterface.getSamePriceItems(SWorldGoalCfg.get(activityCfgid).same_price_item_id);
/* 242 */     for (Iterator i$ = itemids.iterator(); i$.hasNext();) { int itemid = ((Integer)i$.next()).intValue();
/*     */       
/* 244 */       SWorldGoalItemCfg cfg = SWorldGoalItemCfg.get(itemid);
/* 245 */       if (cfg == null)
/*     */       {
/* 247 */         return -1;
/*     */       }
/* 249 */       while (ItemInterface.removeItemById(roleid, itemid, 1, new TLogArg(LogReason.WORLD_GOAL_COMMIT_ITEM_REMOVE)))
/*     */       {
/* 251 */         realCommitPoint += cfg.point;
/* 252 */         itemid2Commitnum.put(Integer.valueOf(itemid), Integer.valueOf(itemid2Commitnum.get(Integer.valueOf(itemid)) == null ? 1 : ((Integer)itemid2Commitnum.get(Integer.valueOf(itemid))).intValue() + 1));
/* 253 */         realCommitNum++; if (realCommitNum < maxCommitNum) { if (realCommitPoint >= maxCommitPoint) {
/*     */             break;
/*     */           }
/*     */         }
/*     */       }
/* 258 */       if ((realCommitNum >= maxCommitNum) || (realCommitPoint >= maxCommitPoint)) {
/*     */         break;
/*     */       }
/*     */     }
/*     */     
/* 263 */     return realCommitNum;
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
/*     */ 
/*     */   static boolean sendCommitItemAward(String userid, long roleid, int activityCfgid, Map<Integer, Integer> itemid2Commitnum)
/*     */   {
/* 279 */     for (Map.Entry<Integer, Integer> entry : itemid2Commitnum.entrySet())
/*     */     {
/* 281 */       int itemid = ((Integer)entry.getKey()).intValue();
/* 282 */       int num = ((Integer)entry.getValue()).intValue();
/* 283 */       SWorldGoalItemCfg cfg = SWorldGoalItemCfg.get(itemid);
/* 284 */       if (cfg == null)
/*     */       {
/*     */ 
/* 287 */         return false;
/*     */       }
/* 289 */       if (cfg.award_id > 0)
/*     */       {
/*     */ 
/*     */ 
/* 293 */         for (int i = 0; i < num; i++)
/*     */         {
/* 295 */           AwardReason awardReason = new AwardReason(LogReason.WORLD_GOAL_COMMIT_ITEM_AWARD, activityCfgid);
/* 296 */           AwardModel awardModel = AwardInterface.award(cfg.award_id, userid, roleid, true, true, awardReason);
/* 297 */           if (awardModel == null)
/*     */           {
/*     */ 
/* 300 */             return false; }
/*     */         }
/*     */       }
/*     */     }
/* 304 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getRealCommitPoint(Map<Integer, Integer> itemid2Commitnum)
/*     */   {
/* 315 */     int realCommitPoint = 0;
/* 316 */     for (Map.Entry<Integer, Integer> entry : itemid2Commitnum.entrySet())
/*     */     {
/* 318 */       int itemid = ((Integer)entry.getKey()).intValue();
/* 319 */       int num = ((Integer)entry.getValue()).intValue();
/* 320 */       SWorldGoalItemCfg cfg = SWorldGoalItemCfg.get(itemid);
/* 321 */       if (cfg == null)
/*     */       {
/*     */ 
/* 324 */         return -1;
/*     */       }
/* 326 */       realCommitPoint += cfg.point * num;
/*     */     }
/* 328 */     return realCommitPoint;
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
/*     */   static void updateActivityInfoAndSendMail(int activityCfgid, int realCommitNum, long now)
/*     */   {
/* 342 */     SWorldGoalCfg cfg = SWorldGoalCfg.get(activityCfgid);
/* 343 */     long globalActivityCfgid = GameServerInfoManager.toGlobalId(activityCfgid);
/* 344 */     WorldGoal xWorldGoal = Worldgoals.get(Long.valueOf(globalActivityCfgid));
/* 345 */     int needAdddPoint = realCommitNum;
/* 346 */     while (needAdddPoint > 0)
/*     */     {
/* 348 */       int currentSectionid = xWorldGoal.getCurrent_section_id();
/* 349 */       int currentSectionPoint = ((Section)xWorldGoal.getSections().get(Integer.valueOf(currentSectionid))).getPoint();
/* 350 */       int currentSectionTotalPoint = ((SectionInfo)cfg.section_infos.get(Integer.valueOf(currentSectionid))).section_total_point;
/* 351 */       int currentSectionNeedPoint = currentSectionTotalPoint - currentSectionPoint;
/* 352 */       if (needAdddPoint < currentSectionNeedPoint)
/*     */       {
/*     */ 
/* 355 */         ((Section)xWorldGoal.getSections().get(Integer.valueOf(currentSectionid))).setPoint(currentSectionPoint + needAdddPoint);
/* 356 */         ((Section)xWorldGoal.getSections().get(Integer.valueOf(currentSectionid))).setTimestamp(now);
/* 357 */         needAdddPoint = 0;
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/* 362 */         ((Section)xWorldGoal.getSections().get(Integer.valueOf(currentSectionid))).setPoint(currentSectionPoint + currentSectionNeedPoint);
/* 363 */         ((Section)xWorldGoal.getSections().get(Integer.valueOf(currentSectionid))).setTimestamp(now);
/* 364 */         if (currentSectionid < cfg.section_num)
/*     */         {
/*     */ 
/* 367 */           Section xSection = Pod.newSection();
/* 368 */           xSection.setPoint(0);
/* 369 */           xSection.setTimestamp(now);
/* 370 */           xWorldGoal.getSections().put(Integer.valueOf(currentSectionid + 1), xSection);
/* 371 */           xWorldGoal.setCurrent_section_id(currentSectionid + 1);
/*     */         }
/* 373 */         needAdddPoint -= currentSectionNeedPoint;
/*     */       }
/*     */       
/* 376 */       TriggerEventsManger.getInstance().triggerEvent(new SectionPonitChange(), new mzm.gsp.worldgoal.event.SectionPonitChangeArg(activityCfgid, currentSectionid, ((Section)xWorldGoal.getSections().get(Integer.valueOf(currentSectionid))).getPoint(), ((Section)xWorldGoal.getSections().get(Integer.valueOf(currentSectionid))).getTimestamp()), WorldGoalOneByOneManager.getInstance().getTaskOneByOne(Integer.valueOf(activityCfgid)));
/*     */     }
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
/*     */ 
/*     */ 
/*     */   static void addCommitRole(int activityCfgid, long roleid)
/*     */   {
/* 394 */     long globalActivityCfgid = GameServerInfoManager.toGlobalId(activityCfgid);
/* 395 */     WorldGoal xWorldGoal = Worldgoals.get(Long.valueOf(globalActivityCfgid));
/* 396 */     xWorldGoal.getCommit_roles().add(Long.valueOf(roleid));
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
/*     */ 
/*     */   static boolean sendAwardMail(long roleid, int activityCfgid, int sectionid)
/*     */   {
/* 412 */     SWorldGoalCfg cfg = SWorldGoalCfg.get(activityCfgid);
/* 413 */     if ((sectionid < 1) || (sectionid > cfg.section_num + 1))
/*     */     {
/* 415 */       return false; }
/*     */     int mailCfgid;
/*     */     boolean isSectionComplete;
/*     */     int mailCfgid;
/* 419 */     if (sectionid == cfg.section_num + 1)
/*     */     {
/* 421 */       boolean isSectionComplete = false;
/* 422 */       mailCfgid = cfg.activity_complete_award_mail_id;
/*     */     }
/*     */     else
/*     */     {
/* 426 */       isSectionComplete = true;
/* 427 */       mailCfgid = ((SectionInfo)cfg.section_infos.get(Integer.valueOf(sectionid))).section_complete_award_mail_id;
/*     */     }
/*     */     
/* 430 */     RoleWorldGoalInfo xRoleWorldGoalInfo = Role2worldgoalinfo.get(Long.valueOf(roleid));
/* 431 */     if (xRoleWorldGoalInfo == null)
/*     */     {
/* 433 */       xRoleWorldGoalInfo = Pod.newRoleWorldGoalInfo();
/* 434 */       Role2worldgoalinfo.insert(Long.valueOf(roleid), xRoleWorldGoalInfo);
/*     */     }
/* 436 */     WorldGoalActivityInfo xWorldGoalActivityInfo = (WorldGoalActivityInfo)xRoleWorldGoalInfo.getWorld_goal_activity_infos().get(Integer.valueOf(activityCfgid));
/*     */     
/* 438 */     if (xWorldGoalActivityInfo == null)
/*     */     {
/* 440 */       xWorldGoalActivityInfo = Pod.newWorldGoalActivityInfo();
/* 441 */       xRoleWorldGoalInfo.getWorld_goal_activity_infos().put(Integer.valueOf(activityCfgid), xWorldGoalActivityInfo);
/*     */     }
/* 443 */     if (xWorldGoalActivityInfo.getAward_section_ids().contains(Integer.valueOf(sectionid)))
/*     */     {
/* 445 */       return false;
/*     */     }
/* 447 */     if (mailCfgid > 0)
/*     */     {
/* 449 */       TLogArg tLogArg = new TLogArg(isSectionComplete ? LogReason.WORLD_GOAL_SECTION_COMPLETE_AWARD : LogReason.WORLD_GOAL_ACTIVITY_COMPLETE_AWARD, activityCfgid);
/*     */       
/* 451 */       SendMailRet sendMailRet = MailInterface.synBuildAndSendMail(roleid, mailCfgid, null, null, tLogArg);
/* 452 */       if (!sendMailRet.isOK())
/*     */       {
/* 454 */         return false;
/*     */       }
/*     */     }
/* 457 */     xWorldGoalActivityInfo.getAward_section_ids().add(Integer.valueOf(sectionid));
/* 458 */     return true;
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
/*     */   static void initActivity(int activityCfgid, boolean tryStartEntityAndObserver, ReasonEnum reason)
/*     */   {
/* 471 */     logger.info(String.format("[worldgoal]WorldGoalActivityHandler.onActivityStart@world goal activity init|activity_cfg_id=%d|try_start_entity_and_observer=%b|reason=%d", new Object[] { Integer.valueOf(activityCfgid), Boolean.valueOf(tryStartEntityAndObserver), Integer.valueOf(reason.value) }));
/*     */     
/*     */ 
/*     */ 
/* 475 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 476 */     boolean isNeedStartEntityAndObserver = false;
/*     */     
/* 478 */     if (tryStartEntityAndObserver)
/*     */     {
/* 480 */       if (ActivityInterface.getActivityLimitTimeStage(activityCfgid, now) != ActivityLimitTimeStageEnum.LIMIT_TIME_NOW)
/*     */       {
/* 482 */         return;
/*     */       }
/* 484 */       isNeedStartEntityAndObserver = true;
/*     */     }
/*     */     
/* 487 */     long globalActivityCfgid = GameServerInfoManager.toGlobalId(activityCfgid);
/* 488 */     WorldGoal xWorldGoal = Worldgoals.get(Long.valueOf(globalActivityCfgid));
/*     */     
/* 490 */     if (xWorldGoal == null)
/*     */     {
/* 492 */       isNeedStartEntityAndObserver = true;
/*     */       
/* 494 */       xWorldGoal = Pod.newWorldGoal();
/* 495 */       Worldgoals.insert(Long.valueOf(globalActivityCfgid), xWorldGoal);
/* 496 */       Section xSection = Pod.newSection();
/* 497 */       xSection.setPoint(0);
/* 498 */       xSection.setTimestamp(now);
/* 499 */       xWorldGoal.getSections().put(Integer.valueOf(1), xSection);
/* 500 */       xWorldGoal.setCurrent_section_id(1);
/*     */     }
/*     */     
/* 503 */     if (!isNeedStartEntityAndObserver)
/*     */     {
/* 505 */       return;
/*     */     }
/*     */     
/*     */ 
/* 509 */     SWorldGoalCfg cfg = SWorldGoalCfg.get(activityCfgid);
/* 510 */     if (cfg.activity_type == 1)
/*     */     {
/* 512 */       xWorldGoal.setWorld_id(MapInterface.getBigWorldid());
/*     */     }
/*     */     else
/*     */     {
/* 516 */       Set<Integer> mapCfgids = new HashSet();
/* 517 */       for (SectionInfo sectionInfo : cfg.section_infos.values())
/*     */       {
/* 519 */         mapCfgids.add(Integer.valueOf(sectionInfo.map_cfg_id));
/*     */       }
/* 521 */       xWorldGoal.setWorld_id(MapInterface.createWorld(mapCfgids));
/*     */     }
/* 523 */     for (Map.Entry<Integer, SectionInfo> entry : cfg.section_infos.entrySet())
/*     */     {
/* 525 */       int sectionid = ((Integer)entry.getKey()).intValue();
/* 526 */       int point = 0;
/* 527 */       long timestamp = 0L;
/* 528 */       if (sectionid <= xWorldGoal.getCurrent_section_id())
/*     */       {
/* 530 */         point = ((Section)xWorldGoal.getSections().get(Integer.valueOf(sectionid))).getPoint();
/* 531 */         timestamp = ((Section)xWorldGoal.getSections().get(Integer.valueOf(sectionid))).getTimestamp();
/*     */       }
/*     */       else
/*     */       {
/* 535 */         point = 0;
/* 536 */         timestamp = now;
/*     */       }
/* 538 */       Map<Integer, Integer> intExtraInfoEntries = new HashMap();
/* 539 */       intExtraInfoEntries.put(Integer.valueOf(400), Integer.valueOf(point));
/* 540 */       intExtraInfoEntries.put(Integer.valueOf(401), Integer.valueOf((int)(timestamp / 1000L)));
/* 541 */       MapInterface.addMapEntity(MapEntityType.MGT_WORLD_GOAL_INFO, WorldGoalMapEntityInstanceManager.getInstanceid(activityCfgid, sectionid), xWorldGoal.getWorld_id(), ((SectionInfo)entry.getValue()).map_cfg_id, ((SectionInfo)entry.getValue()).x, ((SectionInfo)entry.getValue()).y, WorldGoalCfgManager.getCfgid(activityCfgid, sectionid, point), intExtraInfoEntries, null, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 548 */     ControllerInterface.triggerOrReSpawn(xWorldGoal.getWorld_id(), cfg.npc_controller_id);
/*     */     
/* 550 */     if (cfg.item_controller_id > 0)
/*     */     {
/* 552 */       ControllerInterface.triggerWorldControllerWithMaxSpawnNum(xWorldGoal.getWorld_id(), cfg.item_controller_id, cfg.item_refresh_num);
/*     */     }
/*     */     
/*     */ 
/* 556 */     if (cfg.monster_controller_id > 0)
/*     */     {
/* 558 */       ControllerInterface.triggerOrReSpawn(xWorldGoal.getWorld_id(), cfg.monster_controller_id);
/*     */     }
/*     */     
/* 561 */     WorldGoalObserverManager.getInstance().startObserver(xWorldGoal.getWorld_id(), activityCfgid);
/*     */     
/* 563 */     WorldGoalFightHandlerManager.getInstance().registerHandler(xWorldGoal.getWorld_id(), activityCfgid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void stopActivity(int activityCfgid, ReasonEnum reason)
/*     */   {
/* 575 */     long globalActivityCfgid = GameServerInfoManager.toGlobalId(activityCfgid);
/* 576 */     WorldGoal xWorldGoal = Worldgoals.get(Long.valueOf(globalActivityCfgid));
/* 577 */     if (xWorldGoal == null)
/*     */     {
/* 579 */       return;
/*     */     }
/* 581 */     logger.info(String.format("[worldgoal]WorldGoalManager.onActivityRealEnd@world goal activity stop|activity_cfg_id=%d|reason=%d", new Object[] { Integer.valueOf(activityCfgid), Integer.valueOf(reason.value) }));
/*     */     
/*     */ 
/* 584 */     SWorldGoalCfg cfg = SWorldGoalCfg.get(activityCfgid);
/*     */     
/* 586 */     for (Iterator i$ = WorldGoalMapEntityInstanceManager.getInstanceids(activityCfgid).iterator(); i$.hasNext();) { long entityInstanceid = ((Long)i$.next()).longValue();
/*     */       
/* 588 */       MapInterface.removeMapEntity(MapEntityType.MGT_WORLD_GOAL_INFO, entityInstanceid, null);
/*     */     }
/*     */     
/*     */ 
/* 592 */     WorldGoalObserverManager.getInstance().stopObserver(activityCfgid);
/*     */     
/* 594 */     ControllerInterface.collectController(cfg.npc_controller_id);
/* 595 */     if (cfg.item_controller_id > 0)
/*     */     {
/* 597 */       ControllerInterface.collectController(cfg.item_controller_id);
/*     */     }
/* 599 */     if (cfg.monster_controller_id > 0)
/*     */     {
/* 601 */       ControllerInterface.collectController(cfg.monster_controller_id);
/*     */     }
/*     */     
/* 604 */     WorldGoalFightHandlerManager.getInstance().unregisterHandler(xWorldGoal.getWorld_id(), activityCfgid);
/*     */     
/* 606 */     if (cfg.transfer_map_cfg_id > 0)
/*     */     {
/* 608 */       for (SectionInfo sectionInfo : cfg.section_infos.values())
/*     */       {
/* 610 */         MapInterface.forceTransferAllRole(MapInterface.getAllSingleRoleAndTeamLeaderInWorld(xWorldGoal.getWorld_id(), sectionInfo.map_cfg_id), MapInterface.getBigWorldid(), cfg.transfer_map_cfg_id, cfg.transfer_x, cfg.transfer_y);
/*     */       }
/*     */     }
/*     */     
/*     */     Iterator i$;
/*     */     
/* 616 */     if ((SWorldGoalCommitItemSumAwardCfg.get(activityCfgid) != null) && (reason == ReasonEnum.ACTIVITY_END))
/*     */     {
/* 618 */       for (i$ = xWorldGoal.getCommit_roles().iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */         
/* 620 */         WorldGoalOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(activityCfgid), new PSendCommitItemSumAward(roleid, activityCfgid));
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 625 */     if (xWorldGoal.getWorld_id() != MapInterface.getBigWorldid())
/*     */     {
/* 627 */       MapInterface.destroyWorld(xWorldGoal.getWorld_id());
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\worldgoal\main\WorldGoalManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
/*     */ package mzm.gsp.qingyunzhi.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.fight.main.FightInterface;
/*     */ import mzm.gsp.item.main.access.ItemAccessManager;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.qingyunzhi.SQingNormalResult;
/*     */ import mzm.gsp.qingyunzhi.SSynQingProgress;
/*     */ import mzm.gsp.qingyunzhi.SSynQingSingleProgress;
/*     */ import mzm.gsp.qingyunzhi.confbean.QingConsts;
/*     */ import mzm.gsp.qingyunzhi.confbean.SQingYunZhiCfg;
/*     */ import mzm.gsp.qingyunzhi.confbean.STQingYunZhiCfg;
/*     */ import mzm.gsp.qingyunzhi.confbean.STSection2Data;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.QingData;
/*     */ import xtable.Role2qingyun;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RoleQingManager
/*     */ {
/*  34 */   static Logger logger = Logger.getLogger("qingyunzhi");
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  40 */   static Map<Integer, Map<Integer, Integer>> nSection2cfg = new HashMap();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  46 */   static Map<Integer, Map<Integer, Integer>> eSection2cfg = new HashMap();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void loggerError(String errorMsg)
/*     */   {
/*  55 */     logger.error(errorMsg);
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
/*     */   static Map<Integer, Integer> getSection2cfgId(int challengeType, int chapterNum)
/*     */   {
/*  69 */     Map<Integer, Integer> section2cfgId = new HashMap();
/*  70 */     STQingYunZhiCfg cfg = STQingYunZhiCfg.get(challengeType);
/*  71 */     if (cfg == null)
/*     */     {
/*  73 */       GameServer.logger().error(String.format("[qingyunzhi]RoleQingManager.getSection2cfgId@ not support challengeType!|challengeType=%d|chapterNum=%d", new Object[] { Integer.valueOf(challengeType), Integer.valueOf(chapterNum) }));
/*     */       
/*     */ 
/*     */ 
/*  77 */       return section2cfgId;
/*     */     }
/*  79 */     STSection2Data section2Data = (STSection2Data)cfg.chapterNum.get(Integer.valueOf(chapterNum));
/*  80 */     if (section2Data == null)
/*     */     {
/*  82 */       GameServer.logger().error(String.format("[qingyunzhi]RoleQingManager.getSection2cfgId@ no this chapter 2 section2Data!|challengeType=%d|chapterNum=%d", new Object[] { Integer.valueOf(challengeType), Integer.valueOf(chapterNum) }));
/*     */       
/*     */ 
/*     */ 
/*  86 */       return section2cfgId;
/*     */     }
/*  88 */     return section2Data.sectionNum2SQingYunZhiCfgId;
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
/*     */   static int getSQingYunZhiCfgId(int challengeType, int chapterNum, int sectionNum)
/*     */   {
/* 101 */     Map<Integer, Integer> section2cfgId = getSection2cfgId(challengeType, chapterNum);
/* 102 */     if ((section2cfgId == null) || (section2cfgId.size() == 0))
/*     */     {
/* 104 */       GameServer.logger().error(String.format("[qingyunzhi]RoleQingManager.getSQingYunZhiCfgId@ no this chapter 2 section2Data!|challengeType=%d|chapterNum=%d|sectionNum=%d", new Object[] { Integer.valueOf(challengeType), Integer.valueOf(chapterNum), Integer.valueOf(sectionNum) }));
/*     */       
/*     */ 
/*     */ 
/* 108 */       return -1;
/*     */     }
/* 110 */     Integer cfgId = (Integer)section2cfgId.get(Integer.valueOf(sectionNum));
/* 111 */     return cfgId == null ? -1 : cfgId.intValue();
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
/*     */   static SQingYunZhiCfg getSQingYunZhiCfg(int challengeType, int chapterNum, int sectionNum)
/*     */   {
/* 124 */     int cfgId = getSQingYunZhiCfgId(challengeType, chapterNum, sectionNum);
/* 125 */     if (cfgId <= 0)
/*     */     {
/* 127 */       return null;
/*     */     }
/* 129 */     return SQingYunZhiCfg.get(cfgId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void init()
/*     */   {
/* 138 */     regAwardAccess(QingConsts.getInstance().ELITE_ACTIVITYID, 2);
/* 139 */     regAwardAccess(QingConsts.getInstance().ACTIVITYID, 1);
/* 140 */     regAwardAccess(QingConsts.getInstance().HERO_ACTIVITYID, 3);
/*     */     
/* 142 */     ActivityInterface.registerActivityByLogicType(24, new NormalQingActivityHandler());
/* 143 */     ActivityInterface.registerActivityByLogicType(40, new EliteQingActivityHandler());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void regAwardAccess(int activityId, int type)
/*     */   {
/* 151 */     for (Iterator i$ = getNeedTipAwardIds(type).iterator(); i$.hasNext();) { int fixAwardId = ((Integer)i$.next()).intValue();
/*     */       
/* 153 */       ItemAccessManager.registerActivityFixReward(activityId, fixAwardId);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static Set<Integer> getNeedTipAwardIds(int type)
/*     */   {
/* 165 */     Set<Integer> awardIds = (Set)getNeedTipAwardIds().get(Integer.valueOf(type));
/* 166 */     return awardIds == null ? new HashSet() : awardIds;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static Map<Integer, Set<Integer>> getNeedTipAwardIds()
/*     */   {
/* 176 */     Map<Integer, Set<Integer>> awardIds = new HashMap();
/* 177 */     for (SQingYunZhiCfg cfg : SQingYunZhiCfg.getAll().values())
/*     */     {
/* 179 */       if ((cfg.isAwardAccessTip) && 
/*     */       
/*     */ 
/*     */ 
/* 183 */         (cfg.fixAwardId > 0))
/*     */       {
/*     */ 
/*     */ 
/* 187 */         Set<Integer> eachIds = (Set)awardIds.get(Integer.valueOf(cfg.challengeType));
/* 188 */         if (eachIds == null)
/*     */         {
/* 190 */           eachIds = new HashSet();
/* 191 */           awardIds.put(Integer.valueOf(cfg.challengeType), eachIds);
/*     */         }
/* 193 */         eachIds.add(Integer.valueOf(cfg.fixAwardId));
/*     */       } }
/* 195 */     return awardIds;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void check() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isFightCfgExist(int fightCfgid)
/*     */   {
/* 213 */     return FightInterface.getFightCfg(fightCfgid) != null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int changeToProType(int xType)
/*     */   {
/* 224 */     switch (xType)
/*     */     {
/*     */     case 1: 
/* 227 */       return 1;
/*     */     
/*     */     case 2: 
/* 230 */       return 2;
/*     */     case 3: 
/* 232 */       return 3;
/*     */     }
/*     */     
/* 235 */     return -1;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int changeToXType(int pType)
/*     */   {
/* 247 */     switch (pType)
/*     */     {
/*     */     case 1: 
/* 250 */       return 1;
/*     */     
/*     */     case 2: 
/* 253 */       return 2;
/*     */     case 3: 
/* 255 */       return 3;
/*     */     }
/*     */     
/* 258 */     return -1;
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
/*     */   static int getFightCfgIdBy(int outPostType, int chapter_on, int section_on)
/*     */   {
/* 273 */     SQingYunZhiCfg cfg = getQingCfgByPType(outPostType, chapter_on, section_on);
/* 274 */     if (cfg == null)
/*     */     {
/* 276 */       return -1;
/*     */     }
/* 278 */     return cfg.fightCfgId;
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
/*     */   static SQingYunZhiCfg getQingCfgByPType(int outPostType, int chapter_on, int section_on)
/*     */   {
/* 293 */     return getSQingYunZhiCfg(outPostType, chapter_on, section_on);
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
/*     */   private static SQingYunZhiCfg getQingCfgByXTpe(int xType, int chapter_on, int section_on)
/*     */   {
/* 307 */     int pType = changeToProType(xType);
/* 308 */     if (pType < 0)
/*     */     {
/* 310 */       return null;
/*     */     }
/* 312 */     return getQingCfgByPType(pType, chapter_on, section_on);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean canChallengeQing(int xType, List<Long> normalMembers, int chapter_on, int section_on, int openLevel)
/*     */   {
/* 322 */     long leaderId = ((Long)normalMembers.get(0)).longValue();
/* 323 */     for (Iterator i$ = normalMembers.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/* 325 */       QingData xQingData = Role2qingyun.get(Long.valueOf(roleId));
/* 326 */       if (!canChallengeQing(roleId, xType, xQingData, chapter_on, section_on))
/*     */       {
/* 328 */         if (roleId == leaderId)
/*     */         {
/* 330 */           sendNormalResult(leaderId, 1, new String[0]);
/*     */         }
/*     */         else
/*     */         {
/* 334 */           sendNormalResult(leaderId, 2, new String[] { RoleInterface.getName(roleId) });
/*     */         }
/* 336 */         return false;
/*     */       }
/* 338 */       int level = RoleInterface.getLevel(roleId);
/* 339 */       if (level < openLevel)
/*     */       {
/* 341 */         sendNormalResult(leaderId, 2, new String[] { RoleInterface.getName(roleId) });
/* 342 */         return false;
/*     */       }
/*     */     }
/* 345 */     return true;
/*     */   }
/*     */   
/*     */   static boolean canChallengeQing(long roleId, int xType, QingData xQingData, int chapter_on, int section_on)
/*     */   {
/* 350 */     return compareProcess(roleId, xType, xQingData, chapter_on, section_on) >= 0;
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
/*     */   static boolean isProcessing(long roleId, int xType, QingData xQingData, int chapter_on, int section_on)
/*     */   {
/* 365 */     return compareProcess(roleId, xType, xQingData, chapter_on, section_on) == 0;
/*     */   }
/*     */   
/*     */   static boolean isProcessing(int chapter_on, int section_on, xbean.Progress xProgress, int xType)
/*     */   {
/* 370 */     return compareProcess(chapter_on, section_on, xProgress, xType) == 0;
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
/*     */ 
/*     */ 
/*     */ 
/*     */   static int compareProcess(long roleId, int xType, QingData xQingData, int chapter_on, int section_on)
/*     */   {
/* 390 */     if (xQingData == null)
/*     */     {
/*     */ 
/* 393 */       return -1;
/*     */     }
/* 395 */     xbean.Progress xProgress = (xbean.Progress)xQingData.getType2progress().get(Integer.valueOf(xType));
/* 396 */     return compareProcess(chapter_on, section_on, xProgress, xType);
/*     */   }
/*     */   
/*     */   static int compareProcess(int chapter_on, int section_on, xbean.Progress xProgress, int xType)
/*     */   {
/* 401 */     if (xProgress == null)
/*     */     {
/*     */ 
/* 404 */       return -1;
/*     */     }
/* 406 */     return compareby(chapter_on, section_on, xProgress.getChapter(), xProgress.getSection(), xType);
/*     */   }
/*     */   
/*     */   static int compareby(int chapter_on, int section_on, int chapterOwn, int sectionOwn, int xType)
/*     */   {
/* 411 */     if (chapter_on == chapterOwn)
/*     */     {
/* 413 */       int needSection = section_on - 1;
/* 414 */       if (needSection > sectionOwn)
/*     */       {
/* 416 */         return -1;
/*     */       }
/* 418 */       if (needSection < sectionOwn)
/*     */       {
/* 420 */         return 1;
/*     */       }
/* 422 */       return 0;
/*     */     }
/* 424 */     if (chapter_on < chapterOwn)
/*     */     {
/* 426 */       return 1;
/*     */     }
/* 428 */     if ((chapter_on == chapterOwn + 1) && (section_on == 1))
/*     */     {
/* 430 */       return compareAtNextChapter(chapterOwn, sectionOwn, xType);
/*     */     }
/*     */     
/*     */ 
/* 434 */     return -1;
/*     */   }
/*     */   
/*     */ 
/*     */   private static int compareAtNextChapter(int chapterOwn, int sectionOwn, int xType)
/*     */   {
/* 440 */     if ((chapterOwn == 0) && (sectionOwn == 0))
/*     */     {
/* 442 */       return 0;
/*     */     }
/* 444 */     int section_temp = sectionOwn + 1;
/* 445 */     if (getQingCfgByXTpe(xType, chapterOwn, section_temp) == null)
/*     */     {
/* 447 */       return 0;
/*     */     }
/* 449 */     return -1;
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
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isPassed(long roleId, int xType, QingData xQingData, int chapter_on, int section_on)
/*     */   {
/* 469 */     if (xQingData == null)
/*     */     {
/* 471 */       return false;
/*     */     }
/* 473 */     xbean.Progress xProgress = (xbean.Progress)xQingData.getType2progress().get(Integer.valueOf(xType));
/* 474 */     return isPassed(chapter_on, section_on, xProgress, xType);
/*     */   }
/*     */   
/*     */   private static boolean isPassed(int chapter_on, int section_on, xbean.Progress xProgress, int xType)
/*     */   {
/* 479 */     if (xProgress == null)
/*     */     {
/* 481 */       return false;
/*     */     }
/* 483 */     return isPassed(chapter_on, section_on, xProgress.getChapter(), xProgress.getSection(), xType);
/*     */   }
/*     */   
/*     */   private static boolean isPassed(int chapter_on, int section_on, int chapterOwn, int sectionOwn, int xType)
/*     */   {
/* 488 */     if (chapter_on > chapterOwn)
/*     */     {
/* 490 */       return false;
/*     */     }
/* 492 */     if (chapter_on < chapterOwn)
/*     */     {
/* 494 */       return true;
/*     */     }
/* 496 */     return section_on <= sectionOwn;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean addProcess(long roleId, xbean.Progress xProgress, int xType)
/*     */   {
/* 508 */     int oldChapter = xProgress.getChapter();
/* 509 */     int oldSection = xProgress.getSection();
/*     */     
/* 511 */     if ((oldChapter == 0) && (oldSection == 0))
/*     */     {
/* 513 */       xProgress.setChapter(1);
/* 514 */       xProgress.setSection(1);
/* 515 */       return true;
/*     */     }
/* 517 */     Map<Integer, Integer> sections = getSection2cfgId(xType, oldChapter);
/* 518 */     if ((sections == null) || (sections.size() == 0))
/*     */     {
/* 520 */       return false;
/*     */     }
/* 522 */     int newSection = oldSection + 1;
/* 523 */     Integer cfgId = (Integer)sections.get(Integer.valueOf(newSection));
/* 524 */     if (cfgId == null)
/*     */     {
/* 526 */       return setNewChapter(xProgress, oldChapter, xType);
/*     */     }
/* 528 */     xProgress.setSection(newSection);
/* 529 */     return true;
/*     */   }
/*     */   
/*     */   private static boolean setNewChapter(xbean.Progress xProgress, int oldChapter, int type)
/*     */   {
/* 534 */     int newChapter = oldChapter + 1;
/* 535 */     Map<Integer, Integer> newSections = getSection2cfgId(type, newChapter);
/* 536 */     if (newSections == null)
/*     */     {
/* 538 */       return false;
/*     */     }
/* 540 */     if (newSections.get(Integer.valueOf(1)) == null)
/*     */     {
/* 542 */       return false;
/*     */     }
/* 544 */     xProgress.setChapter(newChapter);
/* 545 */     xProgress.setSection(1);
/* 546 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getAwardIdBy(int xType, int chapter, int section)
/*     */   {
/* 558 */     SQingYunZhiCfg cfg = getQingCfgByXTpe(xType, chapter, section);
/* 559 */     if (cfg == null)
/*     */     {
/* 561 */       return -1;
/*     */     }
/* 563 */     return cfg.fixAwardId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getQingOpenLevel(int xType)
/*     */   {
/* 574 */     switch (xType)
/*     */     {
/*     */     case 1: 
/* 577 */       return QingConsts.getInstance().NORMAL_OPEN_LEVEL;
/*     */     
/*     */     case 2: 
/* 580 */       return QingConsts.getInstance().ELITE_OPEN_LEVEL;
/*     */     
/*     */     case 3: 
/* 583 */       return QingConsts.getInstance().HERO_OPEN_LEVEL;
/*     */     }
/*     */     
/* 586 */     return -1;
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
/*     */   static int getChapterOpenLevel(int xType, int chapter)
/*     */   {
/* 599 */     SQingYunZhiCfg cfg = getQingCfgByXTpe(xType, chapter, 1);
/* 600 */     if (cfg == null)
/*     */     {
/* 602 */       return -1;
/*     */     }
/* 604 */     return cfg.openLevel;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void sendNormalResult(long roleid, int result, String... args)
/*     */   {
/* 616 */     SQingNormalResult pro = new SQingNormalResult();
/* 617 */     pro.result = result;
/* 618 */     for (String arg : args)
/*     */     {
/* 620 */       pro.args.add(arg);
/*     */     }
/* 622 */     OnlineManager.getInstance().sendAtOnce(roleid, pro);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean addProgress(long roleId, xbean.Progress xProgress, int xType)
/*     */   {
/* 634 */     if (!addProcess(roleId, xProgress, xType))
/*     */     {
/* 636 */       loggerError(String.format("[qingyunzhi]RoleQingManager.addProgress@addProgress error!roleId=%d|type=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(xType) }));
/*     */       
/* 638 */       return false;
/*     */     }
/* 640 */     synQingSingleProcess(roleId, xProgress, xType);
/* 641 */     return true;
/*     */   }
/*     */   
/*     */   static void synQingSingleProcess(long roleId, xbean.Progress xProgress, int xType)
/*     */   {
/* 646 */     SSynQingSingleProgress singleProgress = new SSynQingSingleProgress();
/* 647 */     singleProgress.chapter = xProgress.getChapter();
/* 648 */     singleProgress.section = xProgress.getSection();
/* 649 */     int pType = changeToProType(xType);
/* 650 */     if (pType < 0) {}
/*     */     
/*     */ 
/*     */ 
/* 654 */     singleProgress.outposttype = pType;
/*     */     
/* 656 */     OnlineManager.getInstance().send(roleId, singleProgress);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void synQingDataToClient(long roleId, QingData xQingData)
/*     */   {
/* 667 */     int roleLevel = RoleInterface.getLevel(roleId);
/* 668 */     SSynQingProgress synQingProgress = new SSynQingProgress();
/* 669 */     for (Iterator i$ = xQingData.getType2progress().keySet().iterator(); i$.hasNext();) { int xType = ((Integer)i$.next()).intValue();
/*     */       
/* 671 */       fillPQingData(xQingData, roleLevel, xType, synQingProgress);
/*     */     }
/* 673 */     if (synQingProgress.type2progress.size() == 0)
/*     */     {
/* 675 */       return;
/*     */     }
/* 677 */     OnlineManager.getInstance().send(roleId, synQingProgress);
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
/*     */   static boolean fillPQingData(QingData xQingData, int roleLevel, int xType, SSynQingProgress synQingProgress)
/*     */   {
/* 691 */     int openLevel = getQingOpenLevel(xType);
/* 692 */     if (openLevel < 0)
/*     */     {
/*     */ 
/* 695 */       return false;
/*     */     }
/* 697 */     if (openLevel > roleLevel)
/*     */     {
/*     */ 
/* 700 */       return false;
/*     */     }
/* 702 */     xbean.Progress p = (xbean.Progress)xQingData.getType2progress().get(Integer.valueOf(xType));
/* 703 */     if (p == null)
/*     */     {
/*     */ 
/* 706 */       return false;
/*     */     }
/* 708 */     mzm.gsp.qingyunzhi.Progress progress = new mzm.gsp.qingyunzhi.Progress();
/* 709 */     progress.chapter = p.getChapter();
/* 710 */     progress.section = p.getSection();
/*     */     
/* 712 */     synQingProgress.type2progress.put(Integer.valueOf(xType), progress);
/* 713 */     return true;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void tlogQing(long roleId, int type, int chapter_unLock, int section_unLock, int chapter, int section, int status, long passTime)
/*     */   {
/* 738 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 739 */     String userid = RoleInterface.getUserId(roleId);
/* 740 */     int rolelevel = RoleInterface.getLevel(roleId);
/*     */     
/* 742 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d|%d|%d|%d|%d", new Object[] { vGameIP, userid, Long.valueOf(roleId), Integer.valueOf(rolelevel), Integer.valueOf(type), Integer.valueOf(chapter_unLock), Integer.valueOf(section_unLock), Integer.valueOf(chapter), Integer.valueOf(section), Integer.valueOf(status), Long.valueOf(passTime) });
/*     */     
/* 744 */     TLogManager.getInstance().addLog(roleId, "QingYun", logStr);
/*     */   }
/*     */   
/*     */   static void tlogAllRoleQingInfo(int xType, Collection<Long> allRoles, int status, int chapter, int section, long passTime)
/*     */   {
/* 749 */     for (Iterator i$ = allRoles.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/* 751 */       QingData xQingData = Role2qingyun.select(Long.valueOf(roleId));
/* 752 */       if (xQingData != null)
/*     */       {
/*     */ 
/*     */ 
/* 756 */         xbean.Progress p = (xbean.Progress)xQingData.getType2progress().get(Integer.valueOf(xType));
/* 757 */         if (p != null)
/*     */         {
/*     */ 
/*     */ 
/* 761 */           int chapter_own = p.getChapter();
/* 762 */           int section_own = p.getSection();
/* 763 */           tlogQing(roleId, xType, chapter_own, section_own, chapter, section, status, passTime);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingyunzhi\main\RoleQingManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
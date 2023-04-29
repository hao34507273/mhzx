/*     */ package mzm.gsp.chat.question;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.STopNGetNbAward;
/*     */ import mzm.gsp.activity.confbean.SWorldQuestionLib;
/*     */ import mzm.gsp.activity.confbean.SWorldQuestionTime;
/*     */ import mzm.gsp.activity.confbean.WorldQuestionConsts;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.item.main.access.ItemAccessManager;
/*     */ import mzm.gsp.itembulletin.main.ItemBulletinInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.util.CommonUtils;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Pod;
/*     */ import xbean.WAwardBean;
/*     */ import xbean.WorldQuestionBean;
/*     */ import xtable.Worldquestion;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WorldQuestion
/*     */ {
/*  45 */   private static WorldQuestion instance = new WorldQuestion();
/*     */   
/*     */   public static WorldQuestion getInstance()
/*     */   {
/*  49 */     return instance;
/*     */   }
/*     */   
/*     */   public void postInit()
/*     */   {
/*  54 */     check();
/*  55 */     setOpenTime();
/*  56 */     initActivityOpen();
/*  57 */     process();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void init()
/*     */   {
/*  64 */     ActivityInterface.registerActivityByLogicType(35, new WorldQuestionActivityPro());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void check()
/*     */   {
/*  73 */     if (!AwardInterface.hasAwardId(getNormalAwardId()))
/*     */     {
/*  75 */       throw new RuntimeException("世界答题常量表，配置的基础奖励不存在！awardId:" + getNormalAwardId());
/*     */     }
/*  77 */     if (!AwardInterface.hasAwardId(getNBAwardId()))
/*     */     {
/*  79 */       throw new RuntimeException("世界答题常量表，配置的特殊奖励不存在！awardId:" + getNBAwardId());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void process()
/*     */   {
/*  89 */     ItemAccessManager.registerActivityReward(getActivityId(), getNBAwardId());
/*  90 */     ItemAccessManager.registerActivityReward(getActivityId(), getNormalAwardId());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   void setOpenTime()
/*     */   {
/*  98 */     if (GameServerInfoManager.isRoamServer())
/*     */     {
/* 100 */       GameServer.logger().info(String.format("[worldquestion]WorldQuestion.setOpenTime@isRoamServer!", new Object[0]));
/* 101 */       return;
/*     */     }
/* 103 */     for (SWorldQuestionTime time : SWorldQuestionTime.getAll().values())
/*     */     {
/* 105 */       int timeCfgId = time.commontimeId;
/* 106 */       if (timeCfgId > 0)
/*     */       {
/*     */ 
/*     */ 
/* 110 */         new RefreshObserve(timeCfgId);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   void initActivityOpen()
/*     */   {
/* 119 */     if (!ActivityInterface.isActivityOpen(getActivityId()))
/*     */     {
/* 121 */       return;
/*     */     }
/*     */     
/* 124 */     new PSetNewQuestionNoticTime().execute();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   List<WAwardBean> getAwardRoleData(boolean remainQWLock)
/*     */   {
/* 136 */     WorldQuestionBean xWQBean = getWorldQuestionBean(remainQWLock);
/* 137 */     if (xWQBean == null)
/*     */     {
/* 139 */       return null;
/*     */     }
/* 141 */     return xWQBean.getRoleawarddata();
/*     */   }
/*     */   
/*     */   WorldQuestionBean getWorldQuestionBean(boolean remainQWLock)
/*     */   {
/* 146 */     long localId = GameServerInfoManager.getLocalId();
/* 147 */     WorldQuestionBean xWQBean = null;
/* 148 */     if (remainQWLock)
/*     */     {
/* 150 */       xWQBean = Worldquestion.get(Long.valueOf(localId));
/*     */     }
/*     */     else
/*     */     {
/* 154 */       xWQBean = Worldquestion.select(Long.valueOf(localId));
/*     */     }
/* 156 */     if ((xWQBean == null) && (remainQWLock))
/*     */     {
/* 158 */       Worldquestion.add(Long.valueOf(localId), Pod.newWorldQuestionBean());
/* 159 */       xWQBean = Worldquestion.get(Long.valueOf(localId));
/*     */     }
/* 161 */     return xWQBean;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static enum AddRes
/*     */   {
/* 172 */     SUC, 
/* 173 */     NO_XDATA, 
/* 174 */     CONTAINS, 
/* 175 */     TO_MAX;
/*     */     
/*     */     private AddRes() {}
/*     */   }
/*     */   
/*     */   AddRes addAwardRole(long roleId) {
/* 181 */     List<WAwardBean> xAwardRoleData = getAwardRoleData(true);
/* 182 */     if (xAwardRoleData == null)
/*     */     {
/* 184 */       return AddRes.NO_XDATA;
/*     */     }
/* 186 */     return addAwardRole(roleId, xAwardRoleData);
/*     */   }
/*     */   
/*     */   private AddRes addAwardRole(long roleId, List<WAwardBean> xAwardRoleData)
/*     */   {
/* 191 */     if (alreadyGetAward(roleId, xAwardRoleData))
/*     */     {
/* 193 */       return AddRes.CONTAINS;
/*     */     }
/* 195 */     if (xAwardRoleData.size() >= awardNumMax())
/*     */     {
/* 197 */       return AddRes.TO_MAX;
/*     */     }
/* 199 */     addRole2XData(roleId, xAwardRoleData);
/* 200 */     return AddRes.SUC;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean alreadyGetAward(long roleId, List<WAwardBean> xAwardRoleData)
/*     */   {
/* 212 */     for (WAwardBean xAwardBean : xAwardRoleData)
/*     */     {
/* 214 */       if (xAwardBean.getRoleid() == roleId)
/*     */       {
/* 216 */         return true;
/*     */       }
/*     */     }
/* 219 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void addRole2XData(long roleId, List<WAwardBean> xAwardRoleData)
/*     */   {
/* 230 */     WAwardBean xAwardBean = Pod.newWAwardBean();
/* 231 */     xAwardBean.setRoleid(roleId);
/* 232 */     xAwardRoleData.add(xAwardBean);
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
/*     */   boolean addRoleItems(long roleId, Map<Integer, Integer> itemMap, WorldQuestionBean xWQBean, boolean isNb)
/*     */   {
/* 246 */     if (xWQBean == null)
/*     */     {
/* 248 */       return false;
/*     */     }
/* 250 */     List<WAwardBean> xWAwardBeans = xWQBean.getRoleawarddata();
/* 251 */     if ((xWAwardBeans == null) || (xWAwardBeans.size() == 0))
/*     */     {
/* 253 */       return false;
/*     */     }
/* 255 */     for (int index = 0; index < xWAwardBeans.size(); index++)
/*     */     {
/* 257 */       WAwardBean xAwardBean = (WAwardBean)xWAwardBeans.get(index);
/* 258 */       if (xAwardBean.getRoleid() == roleId)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 267 */         return addAwardItem(itemMap, isNb, xAwardBean); }
/*     */     }
/* 269 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void topNGetAwardBro(long roleId, Map<Integer, Integer> itemMap, int index)
/*     */   {
/* 281 */     STopNGetNbAward bro = new STopNGetNbAward();
/* 282 */     bro.roleid = roleId;
/* 283 */     bro.rolename = RoleInterface.getName(roleId);
/* 284 */     bro.items.putAll(itemMap);
/* 285 */     bro.rank = (index + 1);
/* 286 */     OnlineManager.getInstance().sendAll(bro);
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
/*     */   private boolean addAwardItem(Map<Integer, Integer> itemMap, boolean isNb, WAwardBean xAwardBean)
/*     */   {
/* 299 */     if (isNb)
/*     */     {
/* 301 */       xAwardBean.getNbitems().putAll(itemMap);
/*     */     }
/*     */     else
/*     */     {
/* 305 */       xAwardBean.getNmitems().putAll(itemMap);
/*     */     }
/* 307 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean isDuringQuestionTime()
/*     */   {
/* 319 */     WorldQuestionBean xWQBean = getWorldQuestionBean(false);
/* 320 */     if (xWQBean == null)
/*     */     {
/* 322 */       return false;
/*     */     }
/* 324 */     return xWQBean.getGoing();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean answerRight(long roleId, String answer, int questionId)
/*     */   {
/* 335 */     String right = getAnswer(questionId);
/* 336 */     if (right == null)
/*     */     {
/* 338 */       GameServer.logger().error(String.format("[worldQuestion]WorldQuestion.answerRight@ answer wrong!|roleId=%d|answer=%s|questionId=%d|", new Object[] { Long.valueOf(roleId), answer, Integer.valueOf(questionId) }));
/*     */     }
/*     */     
/*     */ 
/* 342 */     if (right.equals(answer.trim()))
/*     */     {
/* 344 */       return true;
/*     */     }
/* 346 */     if (GameServer.logger().isDebugEnabled())
/*     */     {
/* 348 */       GameServer.logger().debug(String.format("[worldQuestion]WorldQuestion.answerRight@ answer wrong!|roleId=%d|answer=%s|right=%s||questionId=%d|", new Object[] { Long.valueOf(roleId), answer, right, Integer.valueOf(questionId) }));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 353 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean doNBAward(long roleId, String userId, WorldQuestionBean xWQBean)
/*     */   {
/* 365 */     AwardReason reason = new AwardReason(LogReason.WORLD_QUESTION_FRIST_AWARD_ADD);
/* 366 */     AwardModel am = AwardInterface.getRoleAwardModel(getNBAwardId(), roleId, -1, reason);
/* 367 */     if (am == null)
/*     */     {
/* 369 */       return false;
/*     */     }
/* 371 */     Map<Integer, Integer> itemMap = am.getItemMap();
/* 372 */     if (itemMap.size() != 0)
/*     */     {
/* 374 */       if (!addRoleItems(roleId, itemMap, xWQBean, true))
/*     */       {
/* 376 */         return false;
/*     */       }
/*     */     }
/* 379 */     return AwardInterface.awardToRoleByAwardModel(userId, roleId, am, false, true, reason);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean doNormalAward(long roleId, String userId, WorldQuestionBean xWQBean)
/*     */   {
/* 391 */     AwardReason reason = new AwardReason(LogReason.WORLD_QUESTION_NORMAL_AWARD_ADD);
/* 392 */     AwardModel am = AwardInterface.getRoleAwardModel(getNormalAwardId(), roleId, -1, reason);
/* 393 */     if (am == null)
/*     */     {
/* 395 */       return false;
/*     */     }
/* 397 */     Map<Integer, Integer> treasureItemMap = getTreasureItems(am.getItemMap());
/* 398 */     if (treasureItemMap.size() != 0)
/*     */     {
/* 400 */       if (!addRoleItems(roleId, treasureItemMap, xWQBean, false))
/*     */       {
/* 402 */         return false;
/*     */       }
/*     */     }
/* 405 */     return AwardInterface.awardToRoleByAwardModel(userId, roleId, am, false, true, reason);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   Map<Integer, Integer> getTreasureItems(Map<Integer, Integer> itemMap)
/*     */   {
/* 416 */     Map<Integer, Integer> treasureItemMap = new HashMap();
/* 417 */     if ((itemMap == null) || (itemMap.size() == 0))
/*     */     {
/* 419 */       return treasureItemMap;
/*     */     }
/* 421 */     Iterator<Map.Entry<Integer, Integer>> it = itemMap.entrySet().iterator();
/* 422 */     while (it.hasNext())
/*     */     {
/* 424 */       Map.Entry<Integer, Integer> entry = (Map.Entry)it.next();
/* 425 */       int itemId = ((Integer)entry.getKey()).intValue();
/* 426 */       if (ItemBulletinInterface.needBulletin(itemId))
/*     */       {
/*     */ 
/*     */ 
/* 430 */         treasureItemMap.put(Integer.valueOf(itemId), entry.getValue()); }
/*     */     }
/* 432 */     return treasureItemMap;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean clearQuestionData()
/*     */   {
/* 442 */     WorldQuestionBean xWQData = getWorldQuestionBean(true);
/* 443 */     xWQData.setLasttime(0L);
/* 444 */     xWQData.setNexttime(0L);
/* 445 */     xWQData.setGoing(false);
/* 446 */     xWQData.getRoleawarddata().clear();
/* 447 */     xWQData.getOldquestionids().clear();
/* 448 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   Map<Integer, Integer> getHMSOf(long mills)
/*     */   {
/* 459 */     Calendar calendar = DateTimeUtils.getCalendar();
/* 460 */     calendar.setTimeInMillis(mills + 30000L);
/*     */     
/* 462 */     Map<Integer, Integer> timeMap = new HashMap();
/* 463 */     timeMap.put(Integer.valueOf(11), Integer.valueOf(calendar.get(11)));
/* 464 */     timeMap.put(Integer.valueOf(12), Integer.valueOf(calendar.get(12)));
/* 465 */     timeMap.put(Integer.valueOf(13), Integer.valueOf(calendar.get(13)));
/* 466 */     return timeMap;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   int getNBAwardId()
/*     */   {
/* 476 */     return WorldQuestionConsts.getInstance().NB_AWARD_ID;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   int getNormalAwardId()
/*     */   {
/* 486 */     return WorldQuestionConsts.getInstance().NORMAL_AWARD_ID;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   String getAnswer(int questionId)
/*     */   {
/* 496 */     SWorldQuestionLib cfg = SWorldQuestionLib.get(questionId);
/* 497 */     if (cfg == null)
/*     */     {
/* 499 */       return null;
/*     */     }
/* 501 */     return cfg.answer.trim();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean isQuestionExist(int questionId)
/*     */   {
/* 512 */     return SWorldQuestionLib.get(questionId) != null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   int awardNumMax()
/*     */   {
/* 522 */     return WorldQuestionConsts.getInstance().NORMAL_AWARD_ROLE_NUM;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   int getActivityId()
/*     */   {
/* 532 */     return WorldQuestionConsts.getInstance().ACTIVITYID;
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
/*     */   boolean isWQOpen(long roleId, boolean sendMsg)
/*     */   {
/* 546 */     if (!OpenInterface.getOpenStatus(51))
/*     */     {
/* 548 */       return false;
/*     */     }
/* 550 */     if (OpenInterface.isBanPlay(roleId, 51))
/*     */     {
/* 552 */       if (sendMsg)
/*     */       {
/* 554 */         OpenInterface.sendBanPlayMsg(roleId, 51);
/*     */       }
/* 556 */       return false;
/*     */     }
/* 558 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   List<Long> getAllAwardRoleIds(WorldQuestionBean xWQBean)
/*     */   {
/* 569 */     if (xWQBean == null)
/*     */     {
/* 571 */       return Collections.emptyList();
/*     */     }
/* 573 */     List<Long> allMembers = new ArrayList();
/* 574 */     for (WAwardBean xWAwardBean : xWQBean.getRoleawarddata())
/*     */     {
/* 576 */       allMembers.add(Long.valueOf(xWAwardBean.getRoleid()));
/*     */     }
/* 578 */     return allMembers;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   List<Long> randomAwardMembers(WorldQuestionBean xWQBean)
/*     */   {
/* 589 */     List<Long> allAwardMembers = getInstance().getAllAwardRoleIds(xWQBean);
/* 590 */     if ((allAwardMembers == null) || (allAwardMembers.size() == 0))
/*     */     {
/* 592 */       return Collections.emptyList();
/*     */     }
/* 594 */     List<Long> randomMembers = new ArrayList();
/* 595 */     CommonUtils.regionRandomByMutableArray((ArrayList)allAwardMembers, getNeedRandomNum(), randomMembers);
/* 596 */     return randomMembers;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean isWQRanAwardOpen()
/*     */   {
/* 606 */     return OpenInterface.getOpenStatus(366);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean isDayAwardMaxOpen()
/*     */   {
/* 616 */     return OpenInterface.getOpenStatus(372);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   int getDayAwardNBCount()
/*     */   {
/* 626 */     return WorldQuestionConsts.getInstance().NB_AWARD_MAX_PER_DAY;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   int getNeedRandomNum()
/*     */   {
/* 636 */     if (this.isDebug)
/*     */     {
/* 638 */       return this.randomNum_debug;
/*     */     }
/* 640 */     return WorldQuestionConsts.getInstance().RANDOM_AWARD_GUY_NUM;
/*     */   }
/*     */   
/*     */ 
/* 644 */   private volatile boolean isDebug = false;
/*     */   
/* 646 */   private volatile int randomNum_debug = WorldQuestionConsts.getInstance().RANDOM_AWARD_GUY_NUM;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void setDebugRandomNum(int num)
/*     */   {
/* 655 */     setDebugModel();
/* 656 */     this.randomNum_debug = num;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void setDebugModel()
/*     */   {
/* 664 */     this.isDebug = true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\question\WorldQuestion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
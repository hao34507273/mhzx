/*      */ package mzm.gsp.children.main;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import com.goldhuman.Common.Octets;
/*      */ import java.io.UnsupportedEncodingException;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.Collection;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.LinkedList;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import java.util.Random;
/*      */ import java.util.Set;
/*      */ import mzm.event.BasicEvent;
/*      */ import mzm.event.TriggerEventsManger;
/*      */ import mzm.gsp.GameServer;
/*      */ import mzm.gsp.GameServerInfoManager;
/*      */ import mzm.gsp.children.ChildBean;
/*      */ import mzm.gsp.children.ChildHoodInfo;
/*      */ import mzm.gsp.children.SChildAbortionNotify;
/*      */ import mzm.gsp.children.SChildNormalFail;
/*      */ import mzm.gsp.children.SSyncBreedInfo;
/*      */ import mzm.gsp.children.SSyncChildrenInfo;
/*      */ import mzm.gsp.children.childhood.ChildhoodManager;
/*      */ import mzm.gsp.children.confbean.BabyOperatorPropertyBean;
/*      */ import mzm.gsp.children.confbean.SBabyOperatorCfg;
/*      */ import mzm.gsp.children.confbean.SBabyPropertyCfg;
/*      */ import mzm.gsp.children.confbean.SChildrenConsts;
/*      */ import mzm.gsp.children.confbean.SChildrenEquipInitCfg;
/*      */ import mzm.gsp.children.confbean.SChildrenOccupationSkillIndexCfg;
/*      */ import mzm.gsp.children.event.AddChildIntoHome;
/*      */ import mzm.gsp.children.event.AddChildIntoHomeArg;
/*      */ import mzm.gsp.children.event.ChildAddHomeReason;
/*      */ import mzm.gsp.children.event.ChildBabyPeriodBreedTimerArg;
/*      */ import mzm.gsp.children.event.ChildRatingChange;
/*      */ import mzm.gsp.children.event.ChildRatingChangeArg;
/*      */ import mzm.gsp.children.event.ChildShowModelChange;
/*      */ import mzm.gsp.children.event.GiveBirthTimerEvent;
/*      */ import mzm.gsp.children.event.GiveBirthTimerEventArg;
/*      */ import mzm.gsp.children.event.RoleChildRatingChange;
/*      */ import mzm.gsp.children.event.RoleChildRatingChangeArg;
/*      */ import mzm.gsp.children.fashion.FashionManager;
/*      */ import mzm.gsp.item.ItemInfo;
/*      */ import mzm.gsp.item.confbean.SChildrenEquipItemCfg;
/*      */ import mzm.gsp.item.main.ChildrenEquipItem;
/*      */ import mzm.gsp.item.main.ItemInterface;
/*      */ import mzm.gsp.item.main.PetEquipmentItem;
/*      */ import mzm.gsp.mail.main.MailInterface;
/*      */ import mzm.gsp.marriage.main.MarriageInterface;
/*      */ import mzm.gsp.marriage.main.MarriageInterface.PregnantState;
/*      */ import mzm.gsp.online.main.OnlineManager;
/*      */ import mzm.gsp.open.main.OpenInterface;
/*      */ import mzm.gsp.pet.confbean.SPetSkillColorCfg;
/*      */ import mzm.gsp.pet.confbean.SPetSkillScoreCfg;
/*      */ import mzm.gsp.qingfu.main.CostResult;
/*      */ import mzm.gsp.qingfu.main.CostType;
/*      */ import mzm.gsp.qingfu.main.QingfuInterface;
/*      */ import mzm.gsp.role.main.RoleInterface;
/*      */ import mzm.gsp.role.main.RoleOneByOneManager;
/*      */ import mzm.gsp.status.main.RoleStatusInterface;
/*      */ import mzm.gsp.tlog.LogReason;
/*      */ import mzm.gsp.tlog.TLogArg;
/*      */ import mzm.gsp.tlog.TLogManager;
/*      */ import mzm.gsp.util.CommonUtils;
/*      */ import mzm.gsp.util.DateTimeUtils;
/*      */ import org.apache.log4j.Logger;
/*      */ import xbean.BreedObserver;
/*      */ import xbean.ChildGrowthDiaryInfo;
/*      */ import xbean.ChildInfo;
/*      */ import xbean.ChildhoodInfo;
/*      */ import xbean.GiveBirthObserver;
/*      */ import xbean.Item;
/*      */ import xbean.Pod;
/*      */ import xbean.Role2ChildrenInfo;
/*      */ import xdb.Lockeys;
/*      */ import xdb.Xdb;
/*      */ import xtable.Breedobservers;
/*      */ import xtable.Children;
/*      */ import xtable.Childrengrowthdiary;
/*      */ import xtable.Givebirthobservers;
/*      */ import xtable.Role2children;
/*      */ 
/*      */ public class ChildrenManager
/*      */ {
/*      */   static final int RATE_TEN_THOUSAND = 10000;
/*      */   static final int GROW_GROWTH = 1;
/*      */   static final int GROW_APITITUDE = 2;
/*      */   static final int GROW_CHARACTER = 3;
/*      */   static final int STUDY_COMMON_SKILL = 1;
/*      */   static final int STUDY_SPECIAL_SKILL = 2;
/*      */   static final int CHILDREN_EQUIP_RANDOM_PROP = 1;
/*      */   static final int CHILDREN_EQUIP_LEVEL_UP = 2;
/*      */   static final int CHILDREN_EQUIP_STAGE_UP = 3;
/*      */   
/*      */   public static boolean isChildrenFunLevelOpen(long roleid)
/*      */   {
/*  100 */     long roleLevel = RoleInterface.getLevel(roleid);
/*      */     
/*  102 */     if (roleLevel < SChildrenConsts.getInstance().children_function_open_level)
/*      */     {
/*  104 */       return false;
/*      */     }
/*      */     
/*  107 */     return true;
/*      */   }
/*      */   
/*      */   public static boolean isFunOpen(long roleid)
/*      */   {
/*  112 */     if (!OpenInterface.getOpenStatus(209))
/*      */     {
/*  114 */       return false;
/*      */     }
/*  116 */     if (OpenInterface.isBanPlay(roleid, 209))
/*      */     {
/*  118 */       OpenInterface.sendBanPlayMsg(roleid, 209);
/*  119 */       return false;
/*      */     }
/*  121 */     return true;
/*      */   }
/*      */   
/*      */   public static boolean canDoAction(long roleid, int action)
/*      */   {
/*  126 */     return RoleStatusInterface.checkCanSetStatus(roleid, action, true);
/*      */   }
/*      */   
/*      */   static int getRandomGender()
/*      */   {
/*  131 */     int randomResult = Xdb.random().nextInt(2);
/*  132 */     if (randomResult == 1)
/*      */     {
/*  134 */       return 2;
/*      */     }
/*      */     
/*      */ 
/*  138 */     return 1;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static Role2ChildrenInfo initAndGetChildrenInfo(long roleId)
/*      */   {
/*  149 */     Role2ChildrenInfo xRole2ChildrenInfo = Role2children.get(Long.valueOf(roleId));
/*  150 */     if (xRole2ChildrenInfo == null)
/*      */     {
/*  152 */       xRole2ChildrenInfo = Pod.newRole2ChildrenInfo();
/*  153 */       Role2children.add(Long.valueOf(roleId), xRole2ChildrenInfo);
/*      */     }
/*      */     
/*  156 */     return xRole2ChildrenInfo;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static Role2ChildrenInfo getRole2ChildrenInfo(long roleId, boolean isRemainRolelock)
/*      */   {
/*  171 */     Role2ChildrenInfo xRole2ChildrenInfo = null;
/*  172 */     if (isRemainRolelock)
/*      */     {
/*  174 */       xRole2ChildrenInfo = Role2children.get(Long.valueOf(roleId));
/*      */     }
/*      */     else
/*      */     {
/*  178 */       xRole2ChildrenInfo = Role2children.select(Long.valueOf(roleId));
/*      */     }
/*      */     
/*  181 */     return xRole2ChildrenInfo;
/*      */   }
/*      */   
/*      */   static int getAndRefreshPeriodRecallTimes(Role2ChildrenInfo xRole2ChildrenInfo)
/*      */   {
/*  186 */     if (xRole2ChildrenInfo == null)
/*      */     {
/*  188 */       return 0;
/*      */     }
/*      */     
/*  191 */     long currentTimeMillis = DateTimeUtils.getCurrTimeInMillis();
/*      */     
/*  193 */     if (!DateTimeUtils.isInSameMonth(xRole2ChildrenInfo.getRecall_period_refresh_time(), currentTimeMillis))
/*      */     {
/*  195 */       xRole2ChildrenInfo.setRecall_period_refresh_time(currentTimeMillis);
/*  196 */       xRole2ChildrenInfo.setPeriod_recall_times(0);
/*      */     }
/*      */     
/*  199 */     return xRole2ChildrenInfo.getPeriod_recall_times();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static <T> void trigChildrenEvent(BasicEvent<T> event, T arg)
/*      */   {
/*  214 */     TriggerEventsManger.getInstance().triggerEvent(event, arg, ChildrenEventOneByOne.getInstance().getOneByOne());
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static BreedInfo getBreedInfo(long roleId, boolean isRemainLock)
/*      */   {
/*  230 */     long marrigeId = MarriageInterface.getMarriedId(roleId, isRemainLock);
/*  231 */     if (marrigeId > 0L)
/*      */     {
/*  233 */       MarriageInterface.PregnantState pregnantState = MarriageInterface.getPregnantState(marrigeId, isRemainLock);
/*  234 */       if (pregnantState != null)
/*      */       {
/*  236 */         BreedInfo breedInfo = new BreedInfo(0, pregnantState.nowScore, pregnantState.step, pregnantState.giveBirthScoreEnoughTime, pregnantState.belongRoleId);
/*      */         
/*      */ 
/*  239 */         return breedInfo;
/*      */       }
/*      */     }
/*      */     
/*  243 */     Role2ChildrenInfo xRole2ChildrenInfo = null;
/*  244 */     if (isRemainLock)
/*      */     {
/*  246 */       xRole2ChildrenInfo = Role2children.get(Long.valueOf(roleId));
/*      */     }
/*      */     else
/*      */     {
/*  250 */       xRole2ChildrenInfo = Role2children.select(Long.valueOf(roleId));
/*      */     }
/*      */     
/*  253 */     if (xRole2ChildrenInfo != null)
/*      */     {
/*  255 */       int signalWayChildScore = xRole2ChildrenInfo.getSignal_way_child_score();
/*  256 */       if (signalWayChildScore > 0)
/*      */       {
/*  258 */         BreedInfo breedInfo = new BreedInfo(1, signalWayChildScore, 1, 0L, roleId);
/*      */         
/*  260 */         return breedInfo;
/*      */       }
/*      */     }
/*      */     
/*  264 */     return null;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void fillChildBean(long roleid, long childid, ChildInfo xChildInfo, ChildBean childBean, boolean needAudultInfo)
/*      */   {
/*  281 */     int childPeriod = xChildInfo.getChild_period();
/*  282 */     childBean.child_id = childid;
/*      */     try
/*      */     {
/*  285 */       childBean.child_name.setString(xChildInfo.getChild_name(), "UTF-8");
/*      */     }
/*      */     catch (UnsupportedEncodingException e) {}
/*      */     
/*      */ 
/*      */ 
/*  291 */     childBean.child_gender = xChildInfo.getChild_gender();
/*  292 */     childBean.child_period = childPeriod;
/*  293 */     childBean.child_belong_role_id = xChildInfo.getOwn_role_id();
/*  294 */     childBean.child_another_parent_role_id = xChildInfo.getAnother_parent_role_id();
/*      */     
/*  296 */     if (childPeriod == 0)
/*      */     {
/*  298 */       childBean.child_period_info = getBabyPeriodInfo(xChildInfo.getBaby_period_info());
/*      */     }
/*  300 */     else if (childPeriod == 1)
/*      */     {
/*  302 */       ChildHoodInfo childHoodInfo = ChildhoodManager.getChildhoodInfo(xChildInfo.getChildhood_info());
/*  303 */       OctetsStream os = new OctetsStream();
/*  304 */       childHoodInfo.marshal(os);
/*  305 */       childBean.child_period_info = os;
/*      */     }
/*  307 */     else if (childPeriod == 2)
/*      */     {
/*  309 */       if (needAudultInfo)
/*      */       {
/*  311 */         mzm.gsp.children.AdulthoodInfo adulthoodInfo = new mzm.gsp.children.AdulthoodInfo();
/*      */         
/*  313 */         ChildrenOutFightObj childrenOutFightObj = getChildrenOutFightObj(xChildInfo.getOwn_role_id(), childid, xChildInfo);
/*      */         
/*  315 */         fillAdulthoodInfo(roleid, adulthoodInfo, xChildInfo, childrenOutFightObj);
/*  316 */         OctetsStream os = new OctetsStream();
/*  317 */         adulthoodInfo.marshal(os);
/*  318 */         childBean.child_period_info = os;
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*  323 */     fillChildModelInfo(childBean.child_model_cfg_id_map, xChildInfo);
/*      */     
/*  325 */     FashionManager.fillFashionInfo(childBean, xChildInfo);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   static void fillChildModelInfo(Map<Integer, Integer> childModelInfoMap, ChildInfo xChildInfo)
/*      */   {
/*  333 */     int childPeriod = xChildInfo.getChild_period();
/*  334 */     if (childPeriod >= 0)
/*      */     {
/*  336 */       xbean.BabyPeriodInfo xBabyPeriodInfo = xChildInfo.getBaby_period_info();
/*  337 */       childModelInfoMap.put(Integer.valueOf(0), Integer.valueOf(xBabyPeriodInfo.getBaby_model_cfg_id()));
/*      */     }
/*      */     
/*  340 */     if (childPeriod >= 1)
/*      */     {
/*  342 */       ChildhoodInfo xChildhoodInfo = xChildInfo.getChildhood_info();
/*  343 */       childModelInfoMap.put(Integer.valueOf(1), Integer.valueOf(xChildhoodInfo.getChild_hood_model_cfg_id()));
/*      */     }
/*      */     
/*  346 */     if (childPeriod >= 2)
/*      */     {
/*  348 */       xbean.AdulthoodInfo xAdulthoodInfo = getXChildAdulthoodInfo(xChildInfo);
/*  349 */       if (xAdulthoodInfo != null)
/*      */       {
/*  351 */         childModelInfoMap.put(Integer.valueOf(2), Integer.valueOf(xAdulthoodInfo.getModelcfgid()));
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   static OctetsStream getBabyPeriodInfo(xbean.BabyPeriodInfo xBabyPeriodInfo)
/*      */   {
/*  358 */     mzm.gsp.children.BabyPeriodInfo babyPeriodInfo = new mzm.gsp.children.BabyPeriodInfo();
/*  359 */     babyPeriodInfo.health_score = xBabyPeriodInfo.getHealth_score();
/*  360 */     babyPeriodInfo.remain_operator = xBabyPeriodInfo.getBaby_period_operator();
/*  361 */     long serviceTime = SChildrenConsts.getInstance().baby_sleep_hours * 3600000L;
/*  362 */     long passTime = DateTimeUtils.getCurrTimeInMillis() - xBabyPeriodInfo.getBaby_period_operator_start_time();
/*  363 */     babyPeriodInfo.remain_seconds = ((serviceTime - passTime) / 1000L);
/*      */     
/*  365 */     Map<Integer, Integer> xBabyPropertyMap = xBabyPeriodInfo.getBaby_property_info_map();
/*  366 */     for (Map.Entry<Integer, Integer> entry : xBabyPropertyMap.entrySet())
/*      */     {
/*  368 */       babyPeriodInfo.baby_property_info_map.put(entry.getKey(), entry.getValue());
/*      */     }
/*      */     
/*  371 */     if (xBabyPeriodInfo.getAuto_breed())
/*      */     {
/*  373 */       babyPeriodInfo.breed_type = 1;
/*      */     }
/*      */     else
/*      */     {
/*  377 */       babyPeriodInfo.breed_type = 0;
/*      */     }
/*      */     
/*  380 */     OctetsStream os = new OctetsStream();
/*  381 */     babyPeriodInfo.marshal(os);
/*  382 */     return os;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static List<Long> getChildIdList(long roleId, long marriedRoleId, boolean isRemainLock)
/*      */   {
/*  397 */     Role2ChildrenInfo xRole2ChildrenInfo = null;
/*  398 */     if (isRemainLock)
/*      */     {
/*  400 */       xRole2ChildrenInfo = Role2children.get(Long.valueOf(roleId));
/*      */     }
/*      */     else
/*      */     {
/*  404 */       xRole2ChildrenInfo = Role2children.select(Long.valueOf(roleId));
/*      */     }
/*      */     
/*  407 */     List<Long> allChildIdList = null;
/*  408 */     if (xRole2ChildrenInfo != null)
/*      */     {
/*  410 */       allChildIdList = new ArrayList();
/*  411 */       allChildIdList.addAll(xRole2ChildrenInfo.getChild_id_list());
/*      */     }
/*      */     
/*  414 */     if (marriedRoleId > 0L)
/*      */     {
/*  416 */       Role2ChildrenInfo xMarriedChildrenInfo = null;
/*  417 */       if (isRemainLock)
/*      */       {
/*  419 */         xMarriedChildrenInfo = Role2children.get(Long.valueOf(marriedRoleId));
/*      */       }
/*      */       else
/*      */       {
/*  423 */         xMarriedChildrenInfo = Role2children.select(Long.valueOf(marriedRoleId));
/*      */       }
/*      */       
/*  426 */       if (xMarriedChildrenInfo != null)
/*      */       {
/*  428 */         if (allChildIdList == null)
/*      */         {
/*  430 */           allChildIdList = new ArrayList();
/*      */         }
/*  432 */         allChildIdList.addAll(xMarriedChildrenInfo.getChild_id_list());
/*      */       }
/*      */     }
/*      */     
/*  436 */     return allChildIdList;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean costCurrencyValue(long roleId, int currencyType, long costValue)
/*      */   {
/*  453 */     String userId = RoleInterface.getUserId(roleId);
/*  454 */     Lockeys.lock(Lockeys.get(xtable.User.getTable(), userId));
/*  455 */     switch (currencyType)
/*      */     {
/*      */     case 1: 
/*  458 */       CostResult costResult = QingfuInterface.costYuanbao(userId, roleId, (int)costValue, CostType.COST_BIND_BABY_BREED, new TLogArg(LogReason.CHILDREN_BABY_BREED_COST_YUAN_BAO));
/*      */       
/*      */ 
/*  461 */       return costResult == CostResult.Success;
/*      */     
/*      */     case 2: 
/*  464 */       return RoleInterface.cutGold(roleId, costValue, new TLogArg(LogReason.CHILDREN_BABY_BREED_COST_GOLD));
/*      */     
/*      */     case 3: 
/*  467 */       return RoleInterface.cutSilver(roleId, costValue, new TLogArg(LogReason.CHILDREN_BABY_BREED_COST_SILVER));
/*      */     
/*      */     case 5: 
/*  470 */       return RoleInterface.cutGoldIngot(roleId, costValue, new TLogArg(LogReason.CHILDREN_BABY_BREED_COST_JIN_DING));
/*      */     
/*      */     case 4: 
/*  473 */       return RoleInterface.cutVigor(roleId, (int)costValue, new TLogArg(LogReason.CHILDREN_BABY_BREED_COST_VIGOR));
/*      */     }
/*      */     
/*  476 */     GameServer.logger().error(String.format("[children]ChildrenManager.costCurrencyValue@not support the currency type|role_id=%d|currency_type=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(currencyType) }));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  482 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */   public static int refreshAndGetHealthValue(long roleId, long childId, xbean.BabyPeriodInfo xBabyPeriodInfo, long currentTimeMillis)
/*      */   {
/*  488 */     Map<Integer, Integer> xBabyPropertyMap = xBabyPeriodInfo.getBaby_property_info_map();
/*      */     
/*  490 */     long currentDayBeginTime = DateTimeUtils.getBeginTimeOfCurrDay(currentTimeMillis);
/*  491 */     long lastRefreshTime = xBabyPeriodInfo.getHealth_refresh_time();
/*  492 */     long nextDayHealthRefreshTime = DateTimeUtils.getBeginTimeOfNextDay(lastRefreshTime);
/*  493 */     while (currentDayBeginTime >= nextDayHealthRefreshTime)
/*      */     {
/*      */ 
/*      */ 
/*  497 */       if (!xBabyPeriodInfo.getAuto_breed())
/*      */       {
/*  499 */         long deltaHours = (nextDayHealthRefreshTime - lastRefreshTime) / 3600000L;
/*      */         
/*  501 */         cutBabyPropertyValueByHours(xBabyPropertyMap, (int)deltaHours);
/*      */       }
/*      */       
/*  504 */       if (canAddHealthScore(xBabyPropertyMap))
/*      */       {
/*  506 */         int newHealthScore = xBabyPeriodInfo.getHealth_score() + SChildrenConsts.getInstance().baby_health_value_add_value_one_day;
/*      */         
/*  508 */         int realHealthScore = newHealthScore >= SChildrenConsts.getInstance().baby_to_childhood_need_health_value ? SChildrenConsts.getInstance().baby_to_childhood_need_health_value : newHealthScore;
/*      */         
/*  510 */         xBabyPeriodInfo.setHealth_score(realHealthScore);
/*      */         
/*  512 */         tlogBabyHealthScore(roleId, childId, realHealthScore);
/*      */       }
/*      */       
/*  515 */       xBabyPeriodInfo.setHealth_refresh_time(nextDayHealthRefreshTime);
/*  516 */       lastRefreshTime = nextDayHealthRefreshTime;
/*  517 */       nextDayHealthRefreshTime = DateTimeUtils.getBeginTimeOfNextDay(lastRefreshTime + 1L);
/*      */     }
/*      */     
/*  520 */     long newRefreshTime = xBabyPeriodInfo.getHealth_refresh_time() > currentDayBeginTime ? xBabyPeriodInfo.getHealth_refresh_time() : currentDayBeginTime;
/*      */     
/*      */ 
/*  523 */     if (!xBabyPeriodInfo.getAuto_breed())
/*      */     {
/*  525 */       long deltaHoursToday = (currentTimeMillis - newRefreshTime) / 3600000L;
/*  526 */       if (deltaHoursToday > 0L)
/*      */       {
/*  528 */         cutBabyPropertyValueByHours(xBabyPropertyMap, (int)deltaHoursToday);
/*  529 */         xBabyPeriodInfo.setHealth_refresh_time(xBabyPeriodInfo.getHealth_refresh_time() + deltaHoursToday * 3600000L);
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*  534 */     return xBabyPeriodInfo.getHealth_score();
/*      */   }
/*      */   
/*      */   public static void cutBabyPropertyValueByHours(Map<Integer, Integer> xBabyPropertyMap, int hours)
/*      */   {
/*  539 */     for (Map.Entry<Integer, SBabyPropertyCfg> entry : SBabyPropertyCfg.getAll().entrySet())
/*      */     {
/*  541 */       int propertyType = ((Integer)entry.getKey()).intValue();
/*  542 */       int cutPropertyValue = ((SBabyPropertyCfg)entry.getValue()).reduce_every_hour * hours;
/*  543 */       Integer oldPropertyValue = (Integer)xBabyPropertyMap.get(Integer.valueOf(propertyType));
/*  544 */       if (oldPropertyValue != null)
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*  549 */         int newPropertyValue = oldPropertyValue.intValue() - cutPropertyValue;
/*      */         
/*  551 */         xBabyPropertyMap.put(Integer.valueOf(propertyType), Integer.valueOf(newPropertyValue > 0 ? newPropertyValue : 0));
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public static boolean canAddHealthScore(Map<Integer, Integer> xBabyPropertyMap) {
/*  557 */     for (Map.Entry<Integer, SBabyPropertyCfg> entry : SBabyPropertyCfg.getAll().entrySet())
/*      */     {
/*  559 */       int operator = ((Integer)entry.getKey()).intValue();
/*  560 */       SBabyPropertyCfg sBabyPropertyCfg = (SBabyPropertyCfg)entry.getValue();
/*  561 */       Integer nowValue = (Integer)xBabyPropertyMap.get(Integer.valueOf(operator));
/*  562 */       if ((nowValue == null) || (nowValue.intValue() < sBabyPropertyCfg.min_value_for_health))
/*      */       {
/*  564 */         return false;
/*      */       }
/*      */     }
/*  567 */     return true;
/*      */   }
/*      */   
/*      */   static void onBabyPeriodLogin(long roleId, long childId, ChildInfo xChildInfo)
/*      */   {
/*  572 */     if ((xChildInfo == null) || (xChildInfo.getChild_period() != 0))
/*      */     {
/*  574 */       return;
/*      */     }
/*      */     
/*  577 */     long currentTimeMillis = DateTimeUtils.getCurrTimeInMillis();
/*  578 */     xbean.BabyPeriodInfo xBabyPeriodInfo = xChildInfo.getBaby_period_info();
/*      */     
/*  580 */     int xBabyPeriodOperator = xBabyPeriodInfo.getBaby_period_operator();
/*      */     
/*  582 */     if (xBabyPeriodOperator != -1)
/*      */     {
/*  584 */       long xBabyPeriodStartTime = xBabyPeriodInfo.getBaby_period_operator_start_time();
/*  585 */       SBabyOperatorCfg sBabyOperatorCfg = SBabyOperatorCfg.get(xBabyPeriodOperator);
/*  586 */       if (sBabyOperatorCfg != null)
/*      */       {
/*  588 */         long periodEndTime = xBabyPeriodStartTime + sBabyOperatorCfg.operator_cd_time;
/*  589 */         if (currentTimeMillis > periodEndTime)
/*      */         {
/*  591 */           refreshAndGetHealthValue(roleId, childId, xBabyPeriodInfo, periodEndTime);
/*      */           
/*  593 */           xBabyPeriodInfo.setBaby_period_operator(-1);
/*  594 */           xBabyPeriodInfo.setBaby_period_operator_start_time(0L);
/*      */           
/*  596 */           handleBabyPeriodObserverEnd(roleId, childId, xBabyPeriodOperator, xBabyPeriodInfo);
/*      */         }
/*      */         else
/*      */         {
/*  600 */           ChildBabyPeriodBreedTimerArg breedArg = new ChildBabyPeriodBreedTimerArg(periodEndTime - currentTimeMillis, roleId, childId, xBabyPeriodOperator, xBabyPeriodStartTime);
/*      */           
/*      */ 
/*  603 */           trigChildrenEvent(new mzm.gsp.children.event.ChildBabyPeriodBreedTimer(), breedArg);
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*  608 */     refreshAndGetHealthValue(roleId, childId, xBabyPeriodInfo, currentTimeMillis);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void checkBabyModelCfgId(ChildInfo xChildInfo)
/*      */   {
/*  619 */     xbean.BabyPeriodInfo xBabyPeriodInfo = xChildInfo.getBaby_period_info();
/*  620 */     if (xBabyPeriodInfo.getBaby_model_cfg_id() <= 0)
/*      */     {
/*  622 */       int gender = xChildInfo.getChild_gender();
/*  623 */       if (gender == 2)
/*      */       {
/*  625 */         xBabyPeriodInfo.setBaby_model_cfg_id(SChildrenConsts.getInstance().GIRL_BABY_BASE_CFG_ID);
/*      */       }
/*      */       else
/*      */       {
/*  629 */         xBabyPeriodInfo.setBaby_model_cfg_id(SChildrenConsts.getInstance().BOY_BABY_BASE_CFG_ID);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   static void handleBabyPeriodObserverEnd(long roleId, long childId, int operator, xbean.BabyPeriodInfo xBabyPeriodInfo)
/*      */   {
/*  637 */     SBabyOperatorCfg sBabyOperatorCfg = (SBabyOperatorCfg)SBabyOperatorCfg.getAll().get(Integer.valueOf(operator));
/*  638 */     if (sBabyOperatorCfg == null)
/*      */     {
/*  640 */       return;
/*      */     }
/*      */     
/*  643 */     Map<Integer, Integer> intParameterMap = new HashMap();
/*  644 */     intParameterMap.put(Integer.valueOf(4), Integer.valueOf(operator));
/*  645 */     Map<Integer, Integer> xBabyPeriodPropertyMap = xBabyPeriodInfo.getBaby_property_info_map();
/*  646 */     for (BabyOperatorPropertyBean propertyBean : sBabyOperatorCfg.add_property_list)
/*      */     {
/*  648 */       int addPropertyType = propertyBean.add_property_type;
/*  649 */       SBabyPropertyCfg sBabyPropertyCfg = SBabyPropertyCfg.get(addPropertyType);
/*  650 */       if (sBabyPropertyCfg != null)
/*      */       {
/*      */ 
/*      */ 
/*  654 */         int addPropertyValue = propertyBean.add_property_type_value;
/*  655 */         intParameterMap.put(Integer.valueOf(addPropertyType), Integer.valueOf(addPropertyValue));
/*  656 */         Integer oldValue = (Integer)xBabyPeriodPropertyMap.get(Integer.valueOf(propertyBean.add_property_type));
/*  657 */         if (oldValue != null)
/*      */         {
/*  659 */           int newValue = addPropertyValue + oldValue.intValue();
/*  660 */           xBabyPeriodPropertyMap.put(Integer.valueOf(addPropertyType), Integer.valueOf(newValue >= sBabyPropertyCfg.max_value ? sBabyPropertyCfg.max_value : newValue));
/*      */ 
/*      */         }
/*      */         else
/*      */         {
/*  665 */           xBabyPeriodPropertyMap.put(Integer.valueOf(addPropertyType), Integer.valueOf(addPropertyValue >= sBabyPropertyCfg.max_value ? sBabyPropertyCfg.max_value : addPropertyValue));
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*  670 */     if (operator == 3)
/*      */     {
/*  672 */       Integer tiredValue = (Integer)xBabyPeriodPropertyMap.get(Integer.valueOf(3));
/*  673 */       if (tiredValue != null)
/*      */       {
/*  675 */         int cutValue = SChildrenConsts.getInstance().baby_sleep_hours * SChildrenConsts.getInstance().baby_sleep_reduce_tired__every_hour;
/*      */         
/*  677 */         int newValue = tiredValue.intValue() - cutValue;
/*  678 */         int realValue = newValue > 0 ? newValue : 0;
/*  679 */         xBabyPeriodPropertyMap.put(Integer.valueOf(3), Integer.valueOf(realValue));
/*  680 */         intParameterMap.put(Integer.valueOf(3), Integer.valueOf(realValue - tiredValue.intValue()));
/*      */       }
/*      */     }
/*  683 */     ChildrenInterface.fillChildGrowthDiary(childId, intParameterMap, null, 0);
/*      */   }
/*      */   
/*      */   static ChildInfo generatorChild(long belongRoleId, long currentTimeMillis)
/*      */   {
/*  688 */     ChildInfo xChildInfo = Pod.newChildInfo();
/*  689 */     xChildInfo.setChild_gender(getRandomGender());
/*  690 */     xChildInfo.setAnother_parent_role_id(-1L);
/*      */     
/*  692 */     xbean.BabyPeriodInfo xBabyPeriodInfo = xChildInfo.getBaby_period_info();
/*  693 */     if (xChildInfo.getChild_gender() == 2)
/*      */     {
/*  695 */       xChildInfo.setChild_name(SChildrenConsts.getInstance().girl_default_name);
/*  696 */       xBabyPeriodInfo.setBaby_model_cfg_id(SChildrenConsts.getInstance().GIRL_BABY_BASE_CFG_ID);
/*      */     }
/*      */     else
/*      */     {
/*  700 */       xChildInfo.setChild_name(SChildrenConsts.getInstance().boy_default_name);
/*  701 */       xBabyPeriodInfo.setBaby_model_cfg_id(SChildrenConsts.getInstance().BOY_BABY_BASE_CFG_ID);
/*      */     }
/*      */     
/*  704 */     xChildInfo.setHome_state(1);
/*  705 */     xChildInfo.setChild_period(0);
/*      */     
/*  707 */     for (Map.Entry<Integer, SBabyPropertyCfg> babyPropertyEntry : SBabyPropertyCfg.getAll().entrySet())
/*      */     {
/*  709 */       int propertyType = ((Integer)babyPropertyEntry.getKey()).intValue();
/*  710 */       int propertyInitValue = ((SBabyPropertyCfg)babyPropertyEntry.getValue()).init_value;
/*  711 */       xBabyPeriodInfo.getBaby_property_info_map().put(Integer.valueOf(propertyType), Integer.valueOf(propertyInitValue));
/*      */     }
/*  713 */     xBabyPeriodInfo.setBaby_period_operator(-1);
/*      */     
/*  715 */     long currentDayBeginTime = DateTimeUtils.getBeginTimeOfCurrDay(currentTimeMillis);
/*  716 */     long delatHours = (currentTimeMillis - currentDayBeginTime) / 3600000L;
/*  717 */     xBabyPeriodInfo.setHealth_refresh_time(currentDayBeginTime + delatHours * 3600000L);
/*      */     
/*  719 */     xBabyPeriodInfo.setAuto_breed(false);
/*      */     
/*  721 */     TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.children.event.ChildGiveBirth(), new mzm.gsp.children.event.ChildGiveBirthArg(belongRoleId, xChildInfo.getChild_gender()), RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(belongRoleId)));
/*      */     
/*      */ 
/*  724 */     return xChildInfo;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static ChildGrowthDiaryInfo generatorChildGrowthDiary(long currentTimeMillis, long childId)
/*      */   {
/*  738 */     ChildGrowthDiaryInfo xChildGrowthDiaryInfo = Pod.newChildGrowthDiaryInfo();
/*  739 */     xChildGrowthDiaryInfo.setGive_birth_time(currentTimeMillis);
/*  740 */     Childrengrowthdiary.add(Long.valueOf(childId), xChildGrowthDiaryInfo);
/*      */     
/*  742 */     return xChildGrowthDiaryInfo;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getOwnChildSize(long roleId, boolean isRemainRoleLock)
/*      */   {
/*  757 */     Role2ChildrenInfo xRole2ChildrenInfo = null;
/*  758 */     if (isRemainRoleLock)
/*      */     {
/*  760 */       xRole2ChildrenInfo = Role2children.get(Long.valueOf(roleId));
/*      */     }
/*      */     else
/*      */     {
/*  764 */       xRole2ChildrenInfo = Role2children.select(Long.valueOf(roleId));
/*      */     }
/*      */     
/*  767 */     if (xRole2ChildrenInfo == null)
/*      */     {
/*  769 */       return 0;
/*      */     }
/*      */     
/*  772 */     return xRole2ChildrenInfo.getChild_id_list().size() - xRole2ChildrenInfo.getTotal_discard_child_num();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void syncChildrenInfo(long roleId, long marriedRoleId, List<Long> childIdList, SSyncChildrenInfo sSyncChildrenInfo, int syncType)
/*      */   {
/*  788 */     sSyncChildrenInfo.sync_type = syncType;
/*      */     
/*  790 */     syncBreedInfo(roleId, marriedRoleId);
/*      */     
/*  792 */     for (Iterator i$ = childIdList.iterator(); i$.hasNext();) { long childId = ((Long)i$.next()).longValue();
/*      */       
/*  794 */       ChildInfo xChildInfo = Children.get(Long.valueOf(childId));
/*  795 */       if (xChildInfo != null)
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*  800 */         repairChildAnotherParent(roleId, marriedRoleId, childId, xChildInfo);
/*      */         
/*      */ 
/*  803 */         checkChildModelCfg(childId, xChildInfo);
/*      */         
/*  805 */         if (!xChildInfo.getIs_discard())
/*      */         {
/*      */ 
/*  808 */           onBabyPeriodLogin(roleId, childId, xChildInfo);
/*      */         }
/*      */         
/*      */ 
/*  812 */         ChildhoodManager.onLogin(childId, xChildInfo);
/*      */         
/*  814 */         ChildBean childBean = new ChildBean();
/*  815 */         if ((xChildInfo.getCarry_role_id() == roleId) || ((xChildInfo.getIs_discard()) && (xChildInfo.getOwn_role_id() == roleId)))
/*      */         {
/*      */ 
/*  818 */           fillChildBean(xChildInfo.getOwn_role_id(), childId, xChildInfo, childBean, true);
/*      */         }
/*      */         else
/*      */         {
/*  822 */           fillChildBean(xChildInfo.getOwn_role_id(), childId, xChildInfo, childBean, false);
/*      */         }
/*      */         
/*  825 */         sSyncChildrenInfo.child_info_map.put(Long.valueOf(childId), childBean);
/*      */         
/*  827 */         if (xChildInfo.getIs_discard())
/*      */         {
/*  829 */           sSyncChildrenInfo.discard_child_map.put(Long.valueOf(childId), Long.valueOf(xChildInfo.getDiscard_time())); }
/*      */       }
/*      */     }
/*  832 */     OnlineManager.getInstance().send(roleId, sSyncChildrenInfo);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void repairChildAnotherParent(long roleId, long marriedRoleId, long childId, ChildInfo xChildInfo)
/*      */   {
/*  848 */     if (marriedRoleId > 0L)
/*      */     {
/*  850 */       return;
/*      */     }
/*      */     
/*  853 */     if ((xChildInfo.getOwn_role_id() == roleId) && (xChildInfo.getAnother_parent_role_id() != -1L))
/*      */     {
/*      */ 
/*  856 */       xChildInfo.setAnother_parent_role_id(-1L);
/*  857 */       tlogRepairChildAnotherParent(roleId, childId);
/*      */     }
/*      */   }
/*      */   
/*      */   private static void tlogRepairChildAnotherParent(long roleId, long childId)
/*      */   {
/*  863 */     String userId = RoleInterface.getUserId(roleId);
/*      */     
/*  865 */     int roleLevel = RoleInterface.getLevel(roleId);
/*      */     
/*  867 */     StringBuilder sbLog = new StringBuilder();
/*  868 */     sbLog.append(GameServerInfoManager.getHostIP()).append('|');
/*  869 */     sbLog.append(userId).append('|');
/*  870 */     sbLog.append(roleId).append('|');
/*  871 */     sbLog.append(roleLevel).append('|');
/*      */     
/*  873 */     sbLog.append(childId);
/*      */     
/*  875 */     TLogManager.getInstance().addLog(roleId, "ChildAnotherParentRepairStatis", sbLog.toString());
/*      */   }
/*      */   
/*      */ 
/*      */   public static void tlogRepairPositionPostion(long roleId, long anotherParentRoleId, long childId, int mapCfgId, int positionX, int positionY)
/*      */   {
/*  881 */     String userId = RoleInterface.getUserId(roleId);
/*      */     
/*  883 */     StringBuilder sbLog = new StringBuilder();
/*  884 */     sbLog.append(GameServerInfoManager.getHostIP()).append('|');
/*  885 */     sbLog.append(userId).append('|');
/*  886 */     sbLog.append(roleId).append('|');
/*  887 */     sbLog.append(anotherParentRoleId).append('|');
/*  888 */     sbLog.append(mapCfgId).append('|');
/*  889 */     sbLog.append(positionX).append('|');
/*  890 */     sbLog.append(positionY).append('|');
/*  891 */     sbLog.append(childId);
/*      */     
/*  893 */     TLogManager.getInstance().addLog(roleId, "ChildPositionRepairStatis", sbLog.toString());
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void syncBreedInfo(long roleId, long marriedRoleId)
/*      */   {
/*  904 */     SSyncBreedInfo sSyncBreedInfo = new SSyncBreedInfo();
/*      */     
/*  906 */     BreedInfo breedInfo = getBreedInfo(roleId, true);
/*  907 */     if (breedInfo == null)
/*      */     {
/*  909 */       sSyncBreedInfo.breed_state = 2;
/*  910 */       sSyncBreedInfo.step = 1;
/*  911 */       OnlineManager.getInstance().send(roleId, sSyncBreedInfo);
/*      */       
/*  913 */       return;
/*      */     }
/*      */     
/*  916 */     int gender = RoleInterface.getGender(roleId);
/*  917 */     if (gender == 2)
/*      */     {
/*  919 */       if ((breedInfo != null) && (breedInfo.breed_state == 0) && (breedInfo.step >= 3))
/*      */       {
/*      */ 
/*  922 */         RoleStatusInterface.setStatus(roleId, 901, false);
/*      */       }
/*      */     }
/*      */     
/*  926 */     sSyncBreedInfo.breed_state = breedInfo.breed_state;
/*  927 */     sSyncBreedInfo.score = breedInfo.score;
/*  928 */     sSyncBreedInfo.step = breedInfo.step;
/*      */     
/*  930 */     if ((sSyncBreedInfo.breed_state == 0) && (sSyncBreedInfo.step == 4))
/*      */     {
/*      */ 
/*  933 */       long marrigeId = MarriageInterface.getMarriedId(roleId, true);
/*      */       
/*  935 */       long currentTimeMillis = DateTimeUtils.getCurrTimeInMillis();
/*  936 */       long giveBirthScoreEnoughTime = MarriageInterface.getGiveBirthScoreEnoughTime(marrigeId, true);
/*      */       
/*  938 */       long remainMillSeconds = 86400000L * SChildrenConsts.getInstance().give_birth_days - (currentTimeMillis - giveBirthScoreEnoughTime);
/*      */       
/*      */ 
/*  941 */       if (remainMillSeconds > 0L)
/*      */       {
/*  943 */         GiveBirthTimerEventArg arg = new GiveBirthTimerEventArg(roleId, remainMillSeconds, marrigeId, marriedRoleId, giveBirthScoreEnoughTime);
/*      */         
/*      */ 
/*  946 */         TriggerEventsManger.getInstance().triggerEvent(new GiveBirthTimerEvent(), arg);
/*      */         
/*  948 */         sSyncBreedInfo.remain_give_birth_seconds = (remainMillSeconds / 1000L);
/*      */       }
/*      */       else
/*      */       {
/*  952 */         MarriageInterface.clearMarriagePregnant(marrigeId);
/*      */         
/*      */ 
/*  955 */         List<String> titleArgList = new ArrayList();
/*  956 */         List<String> contextArgList = new ArrayList();
/*      */         
/*  958 */         MailInterface.synBuildAndSendMail(roleId, SChildrenConsts.getInstance().abortion_notify_mail_id, titleArgList, contextArgList, null, new TLogArg(LogReason.CHILDREN_ABORTION_NOTIFY_MAIL));
/*      */         
/*  960 */         MailInterface.synBuildAndSendMail(marriedRoleId, SChildrenConsts.getInstance().abortion_notify_mail_id, titleArgList, contextArgList, null, new TLogArg(LogReason.CHILDREN_ABORTION_NOTIFY_MAIL));
/*      */         
/*      */ 
/*  963 */         sSyncBreedInfo.breed_state = 2;
/*  964 */         sSyncBreedInfo.step = 1;
/*      */       }
/*      */     }
/*  967 */     OnlineManager.getInstance().send(roleId, sSyncBreedInfo);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void checkChildModelCfg(long childId, ChildInfo xChildInfo)
/*      */   {
/*  980 */     int childPeriod = xChildInfo.getChild_period();
/*  981 */     if (childPeriod == 0)
/*      */     {
/*  983 */       checkBabyModelCfgId(xChildInfo);
/*      */     }
/*  985 */     else if (childPeriod == 1)
/*      */     {
/*  987 */       checkBabyModelCfgId(xChildInfo);
/*  988 */       ChildhoodManager.checkModelCfgid(childId, xChildInfo);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   static void notifyChildAbortion(long roleId, long partnerRoleId, int reason)
/*      */   {
/*  995 */     List<String> titleArgList = new ArrayList();
/*  996 */     List<String> contextArgList = new ArrayList();
/*      */     
/*      */ 
/*  999 */     MailInterface.synBuildAndSendMail(roleId, SChildrenConsts.getInstance().abortion_notify_mail_id, titleArgList, contextArgList, null, new TLogArg(LogReason.CHILDREN_ABORTION_NOTIFY_MAIL));
/*      */     
/*      */ 
/* 1002 */     MailInterface.synBuildAndSendMail(partnerRoleId, SChildrenConsts.getInstance().abortion_notify_mail_id, titleArgList, contextArgList, null, new TLogArg(LogReason.CHILDREN_ABORTION_NOTIFY_MAIL));
/*      */     
/*      */ 
/* 1005 */     tlogCoupleChildAbortion(roleId, partnerRoleId, reason);
/*      */     
/* 1007 */     SChildAbortionNotify sChildAbortionNotify = new SChildAbortionNotify();
/* 1008 */     OnlineManager.getInstance().sendMulti(sChildAbortionNotify, Arrays.asList(new Long[] { Long.valueOf(roleId), Long.valueOf(partnerRoleId) }));
/*      */   }
/*      */   
/*      */   static void tlogSignalWayGetChildren(String userId, long roleId, long childId)
/*      */   {
/* 1013 */     int roleLevel = RoleInterface.getLevel(roleId);
/*      */     
/* 1015 */     StringBuilder sbLog = new StringBuilder();
/* 1016 */     sbLog.append(GameServerInfoManager.getHostIP()).append('|');
/* 1017 */     sbLog.append(userId).append('|');
/* 1018 */     sbLog.append(roleId).append('|');
/* 1019 */     sbLog.append(roleLevel).append('|');
/*      */     
/* 1021 */     sbLog.append(childId);
/*      */     
/* 1023 */     TLogManager.getInstance().addLog(roleId, "SignalWayGetChildStatis", sbLog.toString());
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void onBabyChildLogoff(long roleid, long marriedRoleid, List<Long> childIdList)
/*      */   {
/* 1038 */     if ((marriedRoleid > 0L) && (OnlineManager.getInstance().isOnline(marriedRoleid)))
/*      */     {
/* 1040 */       return;
/*      */     }
/*      */     
/* 1043 */     for (Iterator i$ = childIdList.iterator(); i$.hasNext();) { long childid = ((Long)i$.next()).longValue();
/*      */       
/* 1045 */       cancelBreedChildObserver(childid);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void cancelBreedChildObserver(long childId)
/*      */   {
/* 1057 */     BreedObserver xBreedObserver = Breedobservers.get(Long.valueOf(childId));
/* 1058 */     if (xBreedObserver != null)
/*      */     {
/* 1060 */       BabyPeriodBreedObserver observer = xBreedObserver.getObserver();
/* 1061 */       if (observer != null)
/*      */       {
/* 1063 */         observer.stopTimer();
/*      */       }
/* 1065 */       Breedobservers.remove(Long.valueOf(childId));
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void handleBagChildLogoff(long ownRoleId, Role2ChildrenInfo xOwnRole2ChildrenInfo)
/*      */   {
/* 1080 */     if (xOwnRole2ChildrenInfo == null)
/*      */     {
/* 1082 */       return;
/*      */     }
/*      */     
/* 1085 */     if (GameServerInfoManager.isRoamServer())
/*      */     {
/* 1087 */       return;
/*      */     }
/*      */     
/* 1090 */     List<Long> xBagChildIdList = xOwnRole2ChildrenInfo.getChild_bag_id_list();
/* 1091 */     Iterator<Long> iter = xBagChildIdList.iterator();
/* 1092 */     while (iter.hasNext())
/*      */     {
/* 1094 */       long childId = ((Long)iter.next()).longValue();
/* 1095 */       ChildInfo xChildInfo = Children.get(Long.valueOf(childId));
/* 1096 */       if ((xChildInfo != null) && 
/*      */       
/*      */ 
/*      */ 
/*      */ 
/* 1101 */         (xChildInfo.getOwn_role_id() != ownRoleId))
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/* 1106 */         iter.remove();
/*      */         
/*      */ 
/* 1109 */         xChildInfo.setCarry_role_id(-1L);
/*      */         
/* 1111 */         xChildInfo.setHome_state(1);
/* 1112 */         xChildInfo.setPosition_x(-1);
/* 1113 */         xChildInfo.setPosition_y(-1);
/*      */         
/* 1115 */         if (xOwnRole2ChildrenInfo.getShow_child_id() == childId)
/*      */         {
/* 1117 */           xOwnRole2ChildrenInfo.setShow_child_id(-1L);
/* 1118 */           trigChildrenEvent(new ChildShowModelChange(), new mzm.gsp.children.event.ChildShowModelChangeArg(ownRoleId, mzm.gsp.children.event.ChildShowModelChangeReason.REMOVE));
/*      */         }
/*      */         
/*      */ 
/* 1122 */         int homeMapCfgId = mzm.gsp.homeland.main.HomelandInterface.getCurrentHomeMapId(ownRoleId);
/*      */         
/* 1124 */         trigChildrenEvent(new AddChildIntoHome(), new AddChildIntoHomeArg(ownRoleId, childId, homeMapCfgId, ChildAddHomeReason.GIVE_BIRTH));
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void handleGiveBirthObserverLogoff(long roleId, long marriedRoleId, long marriageId)
/*      */   {
/* 1136 */     if ((marriedRoleId < 0L) || (marriageId < 0L))
/*      */     {
/* 1138 */       return;
/*      */     }
/*      */     
/* 1141 */     if (OnlineManager.getInstance().isOnline(marriedRoleId))
/*      */     {
/* 1143 */       return;
/*      */     }
/*      */     
/* 1146 */     cancelGiveBirthObserver(marriageId);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void cancelGiveBirthObserver(long marriageId)
/*      */   {
/* 1156 */     if (marriageId < 0L)
/*      */     {
/* 1158 */       return;
/*      */     }
/* 1160 */     GiveBirthObserver xGiveBirthObserver = Givebirthobservers.get(Long.valueOf(marriageId));
/* 1161 */     if (xGiveBirthObserver != null)
/*      */     {
/* 1163 */       GiveBirthTimeOutObserver observer = xGiveBirthObserver.getObserver();
/* 1164 */       if (observer != null)
/*      */       {
/* 1166 */         observer.stopTimer();
/*      */       }
/* 1168 */       Givebirthobservers.remove(Long.valueOf(marriageId));
/*      */     }
/*      */   }
/*      */   
/*      */   static void tlogCoupleWayGetChildren(long roleId, long partnerRoleId, long childId, long ownRoleId)
/*      */   {
/* 1174 */     String userId = RoleInterface.getUserId(roleId);
/* 1175 */     String partnerUserId = RoleInterface.getUserId(partnerRoleId);
/*      */     
/* 1177 */     int roleLevel = RoleInterface.getLevel(roleId);
/* 1178 */     long partnerRoleLevel = RoleInterface.getLevel(partnerRoleId);
/*      */     
/* 1180 */     StringBuilder sbLog = new StringBuilder();
/* 1181 */     sbLog.append(GameServerInfoManager.getHostIP()).append('|');
/* 1182 */     sbLog.append(userId).append('|');
/* 1183 */     sbLog.append(roleId).append('|');
/* 1184 */     sbLog.append(roleLevel).append('|');
/*      */     
/* 1186 */     sbLog.append(childId).append('|');
/* 1187 */     sbLog.append(partnerUserId).append('|');
/* 1188 */     sbLog.append(partnerRoleId).append('|');
/* 1189 */     sbLog.append(partnerRoleLevel).append('|');
/* 1190 */     sbLog.append(ownRoleId);
/*      */     
/* 1192 */     TLogManager.getInstance().addLog(roleId, "CoupleWayGetChildStatis", sbLog.toString());
/*      */   }
/*      */   
/*      */ 
/*      */   static void tlogGiveUpBreed(String userId, long roleId, int breedType, int breedStep, int breedScore)
/*      */   {
/* 1198 */     int roleLevel = RoleInterface.getLevel(roleId);
/*      */     
/* 1200 */     StringBuilder sbLog = new StringBuilder();
/* 1201 */     sbLog.append(GameServerInfoManager.getHostIP()).append('|');
/* 1202 */     sbLog.append(userId).append('|');
/* 1203 */     sbLog.append(roleId).append('|');
/* 1204 */     sbLog.append(roleLevel).append('|');
/*      */     
/* 1206 */     sbLog.append(breedType).append('|');
/* 1207 */     sbLog.append(breedStep).append('|');
/* 1208 */     sbLog.append(breedScore);
/*      */     
/* 1210 */     TLogManager.getInstance().addLog(roleId, "GiveUpBreedStatis", sbLog.toString());
/*      */   }
/*      */   
/*      */   static void tlogCoupleBreedFinishStep(long roleId, long partnerRoleId, int step)
/*      */   {
/* 1215 */     String userId = RoleInterface.getUserId(roleId);
/* 1216 */     String partnerUserId = RoleInterface.getUserId(partnerRoleId);
/*      */     
/* 1218 */     int roleLevel = RoleInterface.getLevel(roleId);
/* 1219 */     long partnerRoleLevel = RoleInterface.getLevel(partnerRoleId);
/*      */     
/* 1221 */     StringBuilder sbLog = new StringBuilder();
/* 1222 */     sbLog.append(GameServerInfoManager.getHostIP()).append('|');
/* 1223 */     sbLog.append(userId).append('|');
/* 1224 */     sbLog.append(roleId).append('|');
/* 1225 */     sbLog.append(roleLevel).append('|');
/*      */     
/* 1227 */     sbLog.append(partnerUserId).append('|');
/* 1228 */     sbLog.append(partnerRoleId).append('|');
/* 1229 */     sbLog.append(partnerRoleLevel).append('|');
/* 1230 */     sbLog.append(step);
/*      */     
/* 1232 */     TLogManager.getInstance().addLog(roleId, "CoupleBreedFinishStepStatis", sbLog.toString());
/*      */   }
/*      */   
/*      */   static void tlogBabyBreedOperator(String userId, long roleId, long childId, int operator)
/*      */   {
/* 1237 */     int roleLevel = RoleInterface.getLevel(roleId);
/*      */     
/* 1239 */     StringBuilder sbLog = new StringBuilder();
/* 1240 */     sbLog.append(GameServerInfoManager.getHostIP()).append('|');
/* 1241 */     sbLog.append(userId).append('|');
/* 1242 */     sbLog.append(roleId).append('|');
/* 1243 */     sbLog.append(roleLevel).append('|');
/*      */     
/* 1245 */     sbLog.append(childId).append('|');
/* 1246 */     sbLog.append(operator);
/*      */     
/* 1248 */     TLogManager.getInstance().addLog(roleId, "BabyBreedOperatorStatis", sbLog.toString());
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   static void tlogChildOperator(String userId, long roleId, long childId, int operator, int showPeriod)
/*      */   {
/* 1255 */     int roleLevel = RoleInterface.getLevel(roleId);
/*      */     
/* 1257 */     StringBuilder sbLog = new StringBuilder();
/* 1258 */     sbLog.append(GameServerInfoManager.getHostIP()).append('|');
/* 1259 */     sbLog.append(userId).append('|');
/* 1260 */     sbLog.append(roleId).append('|');
/* 1261 */     sbLog.append(roleLevel).append('|');
/*      */     
/* 1263 */     sbLog.append(childId).append('|');
/* 1264 */     sbLog.append(operator).append('|');
/* 1265 */     sbLog.append(showPeriod);
/*      */     
/* 1267 */     TLogManager.getInstance().addLog(roleId, "ChildOperatorStatis", sbLog.toString());
/*      */   }
/*      */   
/*      */ 
/*      */   static void tlogChildChangeName(String userId, long roleId, long childId, String oldName, String newName)
/*      */   {
/* 1273 */     int roleLevel = RoleInterface.getLevel(roleId);
/*      */     
/* 1275 */     StringBuilder sbLog = new StringBuilder();
/* 1276 */     sbLog.append(GameServerInfoManager.getHostIP()).append('|');
/* 1277 */     sbLog.append(userId).append('|');
/* 1278 */     sbLog.append(roleId).append('|');
/* 1279 */     sbLog.append(roleLevel).append('|');
/*      */     
/* 1281 */     sbLog.append(childId).append('|');
/* 1282 */     sbLog.append(oldName).append('|');
/* 1283 */     sbLog.append(newName);
/*      */     
/* 1285 */     TLogManager.getInstance().addLog(roleId, "ChildChangNameStatis", sbLog.toString());
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void tlogBabyHealthScore(long roleId, long childId, int nowHealthScore)
/*      */   {
/* 1297 */     String userId = RoleInterface.getUserId(roleId);
/* 1298 */     int roleLevel = RoleInterface.getLevel(roleId);
/*      */     
/* 1300 */     StringBuilder sbLog = new StringBuilder();
/* 1301 */     sbLog.append(GameServerInfoManager.getHostIP()).append('|');
/* 1302 */     sbLog.append(userId).append('|');
/* 1303 */     sbLog.append(roleId).append('|');
/* 1304 */     sbLog.append(roleLevel).append('|');
/*      */     
/* 1306 */     sbLog.append(childId).append('|');
/* 1307 */     sbLog.append(nowHealthScore);
/*      */     
/* 1309 */     TLogManager.getInstance().addLog(roleId, "BabyHealthScoreStatis", sbLog.toString());
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void tlogSingleBreedScoreChange(long roleId, int nowScore)
/*      */   {
/* 1319 */     String userId = RoleInterface.getUserId(roleId);
/* 1320 */     int roleLevel = RoleInterface.getLevel(roleId);
/*      */     
/* 1322 */     StringBuilder sbLog = new StringBuilder();
/* 1323 */     sbLog.append(GameServerInfoManager.getHostIP()).append('|');
/* 1324 */     sbLog.append(userId).append('|');
/* 1325 */     sbLog.append(roleId).append('|');
/* 1326 */     sbLog.append(roleLevel).append('|');
/*      */     
/* 1328 */     sbLog.append(nowScore);
/*      */     
/* 1330 */     TLogManager.getInstance().addLog(roleId, "SingleBreedScoreChangeStatis", sbLog.toString());
/*      */   }
/*      */   
/*      */   static void tlogCoupleBreedStepScore(long roleId, long partnerRoleId, int step, int score)
/*      */   {
/* 1335 */     String userId = RoleInterface.getUserId(roleId);
/* 1336 */     String partnerUserId = RoleInterface.getUserId(partnerRoleId);
/*      */     
/* 1338 */     int roleLevel = RoleInterface.getLevel(roleId);
/* 1339 */     long partnerRoleLevel = RoleInterface.getLevel(partnerRoleId);
/*      */     
/* 1341 */     StringBuilder sbLog = new StringBuilder();
/* 1342 */     sbLog.append(GameServerInfoManager.getHostIP()).append('|');
/* 1343 */     sbLog.append(userId).append('|');
/* 1344 */     sbLog.append(roleId).append('|');
/* 1345 */     sbLog.append(roleLevel).append('|');
/*      */     
/* 1347 */     sbLog.append(partnerUserId).append('|');
/* 1348 */     sbLog.append(partnerRoleId).append('|');
/* 1349 */     sbLog.append(partnerRoleLevel).append('|');
/* 1350 */     sbLog.append(step).append('|');
/* 1351 */     sbLog.append(score);
/*      */     
/* 1353 */     TLogManager.getInstance().addLog(roleId, "CoupleBreedScoreChangeStatis", sbLog.toString());
/*      */   }
/*      */   
/*      */   static void tlogCoupleChildAbortion(long roleId, long partnerRoleId, int reason)
/*      */   {
/* 1358 */     String userId = RoleInterface.getUserId(roleId);
/* 1359 */     String partnerUserId = RoleInterface.getUserId(partnerRoleId);
/*      */     
/* 1361 */     int roleLevel = RoleInterface.getLevel(roleId);
/* 1362 */     long partnerRoleLevel = RoleInterface.getLevel(partnerRoleId);
/*      */     
/* 1364 */     StringBuilder sbLog = new StringBuilder();
/* 1365 */     sbLog.append(GameServerInfoManager.getHostIP()).append('|');
/* 1366 */     sbLog.append(userId).append('|');
/* 1367 */     sbLog.append(roleId).append('|');
/* 1368 */     sbLog.append(roleLevel).append('|');
/*      */     
/* 1370 */     sbLog.append(partnerUserId).append('|');
/* 1371 */     sbLog.append(partnerRoleId).append('|');
/* 1372 */     sbLog.append(partnerRoleLevel).append('|');
/* 1373 */     sbLog.append(reason);
/*      */     
/* 1375 */     TLogManager.getInstance().addLog(roleId, "CoupleChildAbortionStatis", sbLog.toString());
/*      */   }
/*      */   
/*      */   static int getShowChildrenCfgid(int showPhase, ChildInfo xChildInfo)
/*      */   {
/* 1380 */     int gender = xChildInfo.getChild_gender();
/* 1381 */     if (showPhase == 0)
/*      */     {
/* 1383 */       int modelCfgid = xChildInfo.getBaby_period_info().getBaby_model_cfg_id();
/* 1384 */       if (modelCfgid <= 0)
/*      */       {
/* 1386 */         if (gender == 2)
/*      */         {
/* 1388 */           return SChildrenConsts.getInstance().GIRL_BABY_BASE_CFG_ID;
/*      */         }
/* 1390 */         if (gender == 1)
/*      */         {
/* 1392 */           return SChildrenConsts.getInstance().BOY_BABY_BASE_CFG_ID;
/*      */         }
/*      */         
/*      */ 
/* 1396 */         return -1;
/*      */       }
/*      */       
/* 1399 */       return modelCfgid;
/*      */     }
/* 1401 */     if (showPhase == 1)
/*      */     {
/* 1403 */       int modelCfgid = xChildInfo.getChildhood_info().getChild_hood_model_cfg_id();
/* 1404 */       if (modelCfgid <= 0)
/*      */       {
/* 1406 */         if (gender == 2)
/*      */         {
/* 1408 */           return SChildrenConsts.getInstance().GIRL_CHILDHOOD_BASE_CFG_ID;
/*      */         }
/* 1410 */         if (gender == 1)
/*      */         {
/* 1412 */           return SChildrenConsts.getInstance().BOY_CHILDHOOD_BASE_CFG_ID;
/*      */         }
/*      */         
/*      */ 
/* 1416 */         return -1;
/*      */       }
/*      */       
/* 1419 */       return modelCfgid;
/*      */     }
/* 1421 */     if (showPhase == 2)
/*      */     {
/* 1423 */       xbean.AdulthoodInfo xAdulthoodInfo = getXChildAdulthoodInfo(xChildInfo);
/* 1424 */       if (xAdulthoodInfo == null)
/*      */       {
/* 1426 */         return -1;
/*      */       }
/* 1428 */       return xAdulthoodInfo.getModelcfgid();
/*      */     }
/*      */     
/*      */ 
/* 1432 */     return -1;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean canOperChildInAdult(long roleid, long childid, boolean retainLock)
/*      */   {
/* 1447 */     Role2ChildrenInfo xRole2ChildrenInfo = null;
/* 1448 */     if (retainLock)
/*      */     {
/* 1450 */       xRole2ChildrenInfo = Role2children.get(Long.valueOf(roleid));
/*      */     }
/*      */     else
/*      */     {
/* 1454 */       xRole2ChildrenInfo = Role2children.select(Long.valueOf(roleid));
/*      */     }
/* 1456 */     if (xRole2ChildrenInfo == null)
/*      */     {
/* 1458 */       return false;
/*      */     }
/* 1460 */     if (!xRole2ChildrenInfo.getChild_bag_id_list().contains(Long.valueOf(childid)))
/*      */     {
/* 1462 */       return false;
/*      */     }
/* 1464 */     ChildInfo xChildInfo = null;
/* 1465 */     if (retainLock)
/*      */     {
/* 1467 */       xChildInfo = Children.get(Long.valueOf(childid));
/*      */     }
/*      */     else
/*      */     {
/* 1471 */       xChildInfo = Children.select(Long.valueOf(childid));
/*      */     }
/* 1473 */     if (xChildInfo == null)
/*      */     {
/* 1475 */       return false;
/*      */     }
/*      */     
/* 1478 */     return xChildInfo.getOwn_role_id() == roleid;
/*      */   }
/*      */   
/*      */   static boolean checkOperChildInAdultStatus(long roleid)
/*      */   {
/* 1483 */     return RoleStatusInterface.checkCanSetStatus(roleid, 881, true);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean checkChildrenDiscardOnOperate(long roleId, ChildInfo xChildInfo)
/*      */   {
/* 1495 */     if (xChildInfo.getIs_discard())
/*      */     {
/* 1497 */       SChildNormalFail sChildNormalFail = new SChildNormalFail();
/* 1498 */       sChildNormalFail.result = 72;
/*      */       
/* 1500 */       OnlineManager.getInstance().sendAtOnce(roleId, sChildNormalFail);
/*      */       
/* 1502 */       GameServer.logger().error(String.format("[children]ChildrenManager.checkChildrenDiscardOnOperate@child is discard|role_id=%", new Object[] { Long.valueOf(roleId) }));
/*      */       
/* 1504 */       return false;
/*      */     }
/* 1506 */     return true;
/*      */   }
/*      */   
/*      */   static boolean isChildAdultHoodSwithOpen(long roleid)
/*      */   {
/* 1511 */     if (!OpenInterface.getOpenStatus(223))
/*      */     {
/* 1513 */       return false;
/*      */     }
/* 1515 */     if (OpenInterface.isBanPlay(roleid, 223))
/*      */     {
/* 1517 */       OpenInterface.sendBanPlayMsg(roleid, 223);
/* 1518 */       return false;
/*      */     }
/* 1520 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void stepInAdulthood(int childrenModelCfgid, ChildInfo xChildInfo, Map<Integer, Integer> aptMap)
/*      */   {
/* 1532 */     xbean.AdulthoodInfo xAdulthoodInfo = getXChildAdulthoodInfo(xChildInfo);
/* 1533 */     if (xAdulthoodInfo == null)
/*      */     {
/* 1535 */       xAdulthoodInfo = Pod.newAdulthoodInfo();
/* 1536 */       xChildInfo.getAdulthood_info().add(xAdulthoodInfo);
/*      */     }
/* 1538 */     xChildInfo.setChild_period(2);
/* 1539 */     xAdulthoodInfo.setGrow((float)SChildrenConsts.getInstance().child_default_grow_value);
/* 1540 */     xAdulthoodInfo.getAptitudeinitmap().putAll(aptMap);
/* 1541 */     xAdulthoodInfo.setModelcfgid(childrenModelCfgid);
/* 1542 */     xAdulthoodInfo.setCharacter(SChildrenConsts.getInstance().child_grow_character_init);
/* 1543 */     SChildrenEquipInitCfg childrenEquipInitCfg = SChildrenEquipInitCfg.get(childrenModelCfgid);
/* 1544 */     for (Iterator i$ = childrenEquipInitCfg.equipids.iterator(); i$.hasNext();) { int equipid = ((Integer)i$.next()).intValue();
/*      */       
/* 1546 */       if (equipid != 0)
/*      */       {
/*      */ 
/*      */ 
/* 1550 */         List<Item> items = ItemInterface.createXItem(equipid, 1);
/* 1551 */         ChildrenEquipItem childrenEquipItem = new ChildrenEquipItem((Item)items.get(0));
/* 1552 */         SChildrenEquipItemCfg childrenEquipItemCfg = SChildrenEquipItemCfg.get(childrenEquipItem.getCfgId());
/* 1553 */         xAdulthoodInfo.getEquipitem().put(Integer.valueOf(childrenEquipItemCfg.wearPos), childrenEquipItem.getItem());
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static ChildrenOutFightObj getChildrenOutFightObj(long roleid, long childid, ChildInfo xChildInfo)
/*      */   {
/* 1568 */     return new ChildrenOutFightObj(roleid, childid, xChildInfo);
/*      */   }
/*      */   
/*      */   static boolean checkPrefPoint(long roleid, Map<Integer, Integer> propMap)
/*      */   {
/* 1573 */     int totalValue = 0;
/*      */     
/* 1575 */     for (Map.Entry<Integer, Integer> entry : propMap.entrySet())
/*      */     {
/* 1577 */       int key = ((Integer)entry.getKey()).intValue();
/* 1578 */       int value = ((Integer)entry.getValue()).intValue();
/* 1579 */       if (value < 0)
/*      */       {
/* 1581 */         GameServer.logger().error(String.format("[Children]ChildrenManager.checkPrefPoint@set value error|value=%d|roleid=%d", new Object[] { Integer.valueOf(value), Long.valueOf(roleid) }));
/*      */         
/*      */ 
/* 1584 */         return false;
/*      */       }
/* 1586 */       if (value > SChildrenConsts.getInstance().child_auto_set_potential_point)
/*      */       {
/* 1588 */         GameServer.logger().error(String.format("[Children]ChildrenManager.checkPrefPoint@set value error|value=%d|roleid=%d", new Object[] { Integer.valueOf(value), Long.valueOf(roleid) }));
/*      */         
/*      */ 
/* 1591 */         return false;
/*      */       }
/* 1593 */       totalValue += value;
/* 1594 */       switch (key)
/*      */       {
/*      */       case 25: 
/*      */         break;
/*      */       case 26: 
/*      */         break;
/*      */       case 27: 
/*      */         break;
/*      */       case 28: 
/*      */         break;
/*      */       case 29: 
/*      */         break;
/*      */       default: 
/* 1607 */         GameServer.logger().error(String.format("[Children]ChildrenManager.checkPrefPoint@can not set this prop|type=%d|roleid=%d", new Object[] { Integer.valueOf(key), Long.valueOf(roleid) }));
/*      */         
/*      */ 
/* 1610 */         return false;
/*      */       }
/*      */     }
/* 1613 */     if (totalValue != SChildrenConsts.getInstance().child_auto_set_potential_point)
/*      */     {
/* 1615 */       GameServer.logger().error(String.format("[Children]ChildrenManager.checkPrefPoint@total value is wrong|roleid=%d|valueMap=%s", new Object[] { Long.valueOf(roleid), propMap }));
/*      */       
/*      */ 
/* 1618 */       return false;
/*      */     }
/* 1620 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   static void fillAdulthoodInfo(long roleid, mzm.gsp.children.AdulthoodInfo auAdulthoodInfo, ChildInfo xChildInfo, ChildrenOutFightObj childrenOutFightObj)
/*      */   {
/* 1626 */     xbean.AdulthoodInfo xAdulthoodInfo = getXChildAdulthoodInfo(xChildInfo);
/* 1627 */     if (xAdulthoodInfo == null)
/*      */     {
/* 1629 */       return;
/*      */     }
/* 1631 */     childrenOutFightObj.fillFinalPropertyMap(auAdulthoodInfo.propmap);
/* 1632 */     for (Iterator i$ = xAdulthoodInfo.getAptitudeinitmap().keySet().iterator(); i$.hasNext();) { int type = ((Integer)i$.next()).intValue();
/*      */       
/* 1634 */       int value = childrenOutFightObj.getAptValue(type);
/* 1635 */       auAdulthoodInfo.aptitudeinitmap.put(Integer.valueOf(type), Integer.valueOf(value));
/*      */     }
/* 1637 */     auAdulthoodInfo.character = xAdulthoodInfo.getCharacter();
/* 1638 */     auAdulthoodInfo.fightskills.addAll(xAdulthoodInfo.getFightskills());
/* 1639 */     auAdulthoodInfo.grow = xAdulthoodInfo.getGrow();
/* 1640 */     auAdulthoodInfo.occupation = xAdulthoodInfo.getOccupation();
/* 1641 */     auAdulthoodInfo.occupationskill2value.putAll(xAdulthoodInfo.getOccupationskill2value());
/* 1642 */     auAdulthoodInfo.potentialpoint = xAdulthoodInfo.getPotentialpoint();
/* 1643 */     auAdulthoodInfo.propset.putAll(xAdulthoodInfo.getBasepropset());
/* 1644 */     auAdulthoodInfo.skillbookskills.addAll(xAdulthoodInfo.getSkillbookskills());
/* 1645 */     auAdulthoodInfo.specialskillid = xAdulthoodInfo.getSpecialskillid();
/* 1646 */     auAdulthoodInfo.unlockskillposnum = xAdulthoodInfo.getUnlockskillposnum();
/* 1647 */     auAdulthoodInfo.useaptitudeitemcount = xAdulthoodInfo.getUseaptitudeitemcount();
/* 1648 */     auAdulthoodInfo.usegrowthitemcount = xAdulthoodInfo.getUsegrowthitemcount();
/* 1649 */     auAdulthoodInfo.level = RoleInterface.getLevel(roleid);
/* 1650 */     for (Map.Entry<Integer, Item> entry : xAdulthoodInfo.getEquipitem().entrySet())
/*      */     {
/* 1652 */       int pos = ((Integer)entry.getKey()).intValue();
/* 1653 */       Item xItem = (Item)entry.getValue();
/* 1654 */       ItemInfo itemInfo = new ItemInfo();
/* 1655 */       ItemInterface.fillInItemInfoBean(itemInfo, xItem);
/* 1656 */       auAdulthoodInfo.equipitem.put(Integer.valueOf(pos), itemInfo);
/*      */     }
/* 1658 */     for (Map.Entry<Integer, Item> entry : xAdulthoodInfo.getEquippetitem().entrySet())
/*      */     {
/* 1660 */       int pos = ((Integer)entry.getKey()).intValue();
/* 1661 */       Item xItem = (Item)entry.getValue();
/* 1662 */       ItemInfo itemInfo = new ItemInfo();
/* 1663 */       ItemInterface.fillInItemInfoBean(itemInfo, xItem);
/* 1664 */       auAdulthoodInfo.equippetitem.put(Integer.valueOf(pos), itemInfo);
/*      */     }
/*      */   }
/*      */   
/*      */   static xbean.AdulthoodInfo getXChildAdulthoodInfo(ChildInfo xChildInfo)
/*      */   {
/* 1670 */     if (xChildInfo == null)
/*      */     {
/* 1672 */       return null;
/*      */     }
/* 1674 */     if (xChildInfo.getAdulthood_info().size() <= 0)
/*      */     {
/* 1676 */       return null;
/*      */     }
/* 1678 */     return (xbean.AdulthoodInfo)xChildInfo.getAdulthood_info().get(0);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getChildrenWeaponCfgid(ChildInfo xChildInfo)
/*      */   {
/* 1689 */     xbean.AdulthoodInfo xAdulthoodInfo = getXChildAdulthoodInfo(xChildInfo);
/* 1690 */     return getChildrenWeaponCfgid(xAdulthoodInfo);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getChildrenWeaponCfgid(xbean.AdulthoodInfo xAdulthoodInfo)
/*      */   {
/* 1701 */     if (xAdulthoodInfo == null)
/*      */     {
/* 1703 */       return 0;
/*      */     }
/* 1705 */     Item xItem = (Item)xAdulthoodInfo.getEquipitem().get(Integer.valueOf(1));
/* 1706 */     if (xItem == null)
/*      */     {
/* 1708 */       return 0;
/*      */     }
/* 1710 */     int weaponCfgid = xItem.getCfgid();
/* 1711 */     if (SChildrenEquipItemCfg.get(weaponCfgid) == null)
/*      */     {
/* 1713 */       return 0;
/*      */     }
/* 1715 */     return weaponCfgid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getChildrenEquipMinLevel(xbean.AdulthoodInfo xAdulthoodInfo)
/*      */   {
/* 1726 */     if (xAdulthoodInfo == null)
/*      */     {
/* 1728 */       return 0;
/*      */     }
/* 1730 */     int minLevel = Integer.MAX_VALUE;
/* 1731 */     Set<Map.Entry<Integer, Item>> set = xAdulthoodInfo.getEquipitem().entrySet();
/* 1732 */     for (Map.Entry<Integer, Item> entry : set)
/*      */     {
/* 1734 */       ChildrenEquipItem childrenEquipItem = new ChildrenEquipItem((Item)entry.getValue());
/* 1735 */       int level = childrenEquipItem.getLevel();
/* 1736 */       minLevel = minLevel > level ? level : minLevel;
/*      */     }
/* 1738 */     return minLevel;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getChildrenEquipMaxLevel(xbean.AdulthoodInfo xAdulthoodInfo)
/*      */   {
/* 1749 */     if (xAdulthoodInfo == null)
/*      */     {
/* 1751 */       return 0;
/*      */     }
/* 1753 */     int maxLevel = -1;
/* 1754 */     Set<Map.Entry<Integer, Item>> set = xAdulthoodInfo.getEquipitem().entrySet();
/* 1755 */     for (Map.Entry<Integer, Item> entry : set)
/*      */     {
/* 1757 */       ChildrenEquipItem childrenEquipItem = new ChildrenEquipItem((Item)entry.getValue());
/* 1758 */       int level = childrenEquipItem.getLevel();
/* 1759 */       maxLevel = maxLevel < level ? level : maxLevel;
/*      */     }
/* 1761 */     return maxLevel;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int getRoleChildrenEquipMinLevel(long roleId)
/*      */   {
/* 1774 */     Role2ChildrenInfo xRole2ChildrenInfo = getRole2ChildrenInfo(roleId, true);
/* 1775 */     if (xRole2ChildrenInfo == null)
/*      */     {
/* 1777 */       return Integer.MAX_VALUE;
/*      */     }
/*      */     
/* 1780 */     List<Long> childIdList = xRole2ChildrenInfo.getChild_id_list();
/* 1781 */     if (childIdList.isEmpty())
/*      */     {
/* 1783 */       return Integer.MAX_VALUE;
/*      */     }
/*      */     
/* 1786 */     Lockeys.lock(Children.getTable(), childIdList);
/* 1787 */     int minLevel = Integer.MAX_VALUE;
/* 1788 */     for (Iterator i$ = childIdList.iterator(); i$.hasNext();) { long childId = ((Long)i$.next()).longValue();
/*      */       
/* 1790 */       ChildInfo xChildInfo = Children.get(Long.valueOf(childId));
/* 1791 */       if ((xChildInfo != null) && 
/*      */       
/*      */ 
/*      */ 
/*      */ 
/* 1796 */         (!xChildInfo.getIs_discard()))
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/* 1801 */         xbean.AdulthoodInfo xAdulthoodInfo = getXChildAdulthoodInfo(xChildInfo);
/* 1802 */         if (xAdulthoodInfo != null)
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/* 1807 */           int childMinEquipLevel = getChildrenEquipMinLevel(xAdulthoodInfo);
/*      */           
/* 1809 */           minLevel = childMinEquipLevel < minLevel ? childMinEquipLevel : minLevel;
/*      */         } } }
/* 1811 */     return minLevel;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int getRoleChildrenEquipMaxLevel(long roleId)
/*      */   {
/* 1824 */     Role2ChildrenInfo xRole2ChildrenInfo = getRole2ChildrenInfo(roleId, true);
/* 1825 */     if (xRole2ChildrenInfo == null)
/*      */     {
/* 1827 */       return -1;
/*      */     }
/*      */     
/* 1830 */     List<Long> childIdList = xRole2ChildrenInfo.getChild_id_list();
/* 1831 */     if (childIdList.isEmpty())
/*      */     {
/* 1833 */       return -1;
/*      */     }
/*      */     
/* 1836 */     Lockeys.lock(Children.getTable(), childIdList);
/* 1837 */     int maxLevel = -1;
/* 1838 */     for (Iterator i$ = childIdList.iterator(); i$.hasNext();) { long childId = ((Long)i$.next()).longValue();
/*      */       
/* 1840 */       ChildInfo xChildInfo = Children.get(Long.valueOf(childId));
/* 1841 */       if ((xChildInfo != null) && 
/*      */       
/*      */ 
/*      */ 
/*      */ 
/* 1846 */         (!xChildInfo.getIs_discard()))
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/* 1851 */         xbean.AdulthoodInfo xAdulthoodInfo = getXChildAdulthoodInfo(xChildInfo);
/* 1852 */         if (xAdulthoodInfo != null)
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/* 1857 */           int childMaxEquipLevel = getChildrenEquipMaxLevel(xAdulthoodInfo);
/*      */           
/* 1859 */           maxLevel = childMaxEquipLevel > maxLevel ? childMaxEquipLevel : maxLevel;
/*      */         } } }
/* 1861 */     return maxLevel;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static double getChildAptitudeRating(xbean.AdulthoodInfo xAdulthoodInfo)
/*      */   {
/* 1872 */     List<Integer> aptitudeValueList = new LinkedList();
/* 1873 */     aptitudeValueList.addAll(xAdulthoodInfo.getAptitudechangemap().values());
/* 1874 */     aptitudeValueList.addAll(xAdulthoodInfo.getAptitudeinitmap().values());
/* 1875 */     int totalAptitude = 0;
/* 1876 */     for (Iterator i$ = aptitudeValueList.iterator(); i$.hasNext();) { int aptitude = ((Integer)i$.next()).intValue();
/* 1877 */       totalAptitude += aptitude; }
/* 1878 */     double aptitudeRatio = SChildrenConsts.getInstance().child_rating_aptitude_ratio * 1.0D / CommonUtils.WAN_PERCENT;
/* 1879 */     return totalAptitude * aptitudeRatio;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static double getChildGrowRating(xbean.AdulthoodInfo xAdulthoodInfo)
/*      */   {
/* 1890 */     double growRatio = SChildrenConsts.getInstance().child_rating_grow_ratio * 1.0D / CommonUtils.WAN_PERCENT;
/* 1891 */     return xAdulthoodInfo.getGrow() * growRatio;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static double getCommonSkillRating(xbean.AdulthoodInfo xAdulthoodInfo)
/*      */   {
/* 1902 */     List<Integer> totalSkills = new LinkedList();
/*      */     
/* 1904 */     totalSkills.addAll(xAdulthoodInfo.getSkillbookskills());
/*      */     
/* 1906 */     Item xItem = (Item)xAdulthoodInfo.getEquippetitem().get(Integer.valueOf(2));
/* 1907 */     if (xItem != null)
/*      */     {
/* 1909 */       PetEquipmentItem petEquipmentItem = new PetEquipmentItem(xItem);
/* 1910 */       totalSkills.addAll(petEquipmentItem.getSkills());
/*      */     }
/* 1912 */     double totalRating = 0.0D;
/* 1913 */     for (Iterator i$ = totalSkills.iterator(); i$.hasNext();) { int skillId = ((Integer)i$.next()).intValue();
/*      */       
/* 1915 */       SPetSkillScoreCfg petSkillScoreCfg = SPetSkillScoreCfg.get(skillId);
/* 1916 */       if (null != petSkillScoreCfg)
/*      */       {
/*      */ 
/*      */ 
/* 1920 */         SPetSkillColorCfg petSkillcolorCfg = SPetSkillColorCfg.get(petSkillScoreCfg.skillLevel);
/* 1921 */         if (null != petSkillcolorCfg)
/*      */         {
/*      */ 
/*      */ 
/* 1925 */           double lowSkillRatio = SChildrenConsts.getInstance().child_rating_low_skill_ratio * 1.0D / CommonUtils.WAN_PERCENT;
/*      */           
/* 1927 */           double highSkillRatio = SChildrenConsts.getInstance().child_rating_high_skill_ratio * 1.0D / CommonUtils.WAN_PERCENT;
/*      */           
/* 1929 */           double superSkillRatio = SChildrenConsts.getInstance().child_rating_super_skill_ratio * 1.0D / CommonUtils.WAN_PERCENT;
/*      */           
/* 1931 */           switch (petSkillcolorCfg.skillLevel)
/*      */           {
/*      */           case 0: 
/* 1934 */             totalRating += lowSkillRatio;
/* 1935 */             break;
/*      */           case 1: 
/* 1937 */             totalRating += highSkillRatio;
/* 1938 */             break;
/*      */           case 2: 
/* 1940 */             totalRating += superSkillRatio; }
/*      */         }
/*      */       }
/*      */     }
/* 1944 */     return 1.0D + totalRating;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static double getOccupationSkillRating(xbean.AdulthoodInfo xAdulthoodInfo)
/*      */   {
/* 1955 */     int occupation = xAdulthoodInfo.getOccupation();
/* 1956 */     if (occupation <= 0)
/*      */     {
/* 1958 */       return 0.0D;
/*      */     }
/* 1960 */     Map<Integer, Integer> occupationSkillMap = xAdulthoodInfo.getOccupationskill2value();
/* 1961 */     int totalLevel = 0;
/* 1962 */     for (Integer skillLevel : occupationSkillMap.values()) {
/* 1963 */       totalLevel += skillLevel.intValue();
/*      */     }
/* 1965 */     SChildrenOccupationSkillIndexCfg skillIndexCfg = SChildrenOccupationSkillIndexCfg.get(occupation);
/* 1966 */     if (null != skillIndexCfg)
/*      */     {
/* 1968 */       totalLevel += skillIndexCfg.index2Skill.size() - occupationSkillMap.size();
/*      */     }
/* 1970 */     double occupationSkillRatio = SChildrenConsts.getInstance().child_rating_occupation_skill_ratio * 1.0D / CommonUtils.WAN_PERCENT;
/*      */     
/* 1972 */     return totalLevel * occupationSkillRatio;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static double getSpecialSkillRating(xbean.AdulthoodInfo xAdulthoodInfo)
/*      */   {
/* 1983 */     if (0 == xAdulthoodInfo.getSpecialskillid())
/*      */     {
/* 1985 */       return 0.0D;
/*      */     }
/* 1987 */     double specialSkillRatio = SChildrenConsts.getInstance().child_rating_special_skill_ratio * 1.0D / CommonUtils.WAN_PERCENT;
/*      */     
/* 1989 */     return 1.0D * specialSkillRatio;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static double getEquipLevelRating(xbean.AdulthoodInfo xAdulthoodInfo)
/*      */   {
/* 2000 */     Map<Integer, Item> equipMap = xAdulthoodInfo.getEquipitem();
/* 2001 */     int totalLevel = 0;
/* 2002 */     for (Item xItem : equipMap.values())
/*      */     {
/* 2004 */       ChildrenEquipItem childrenEquipItem = new ChildrenEquipItem(xItem);
/* 2005 */       totalLevel += childrenEquipItem.getLevel();
/*      */     }
/* 2007 */     double equipLevelRatio = SChildrenConsts.getInstance().child_rating_equip_level_ratio * 1.0D / CommonUtils.WAN_PERCENT;
/*      */     
/* 2009 */     return totalLevel * equipLevelRatio;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   static int getChildRating(long childId, boolean retainLock)
/*      */   {
/*      */     ChildInfo xChildInfo;
/*      */     
/*      */ 
/*      */     ChildInfo xChildInfo;
/*      */     
/*      */ 
/* 2022 */     if (retainLock)
/*      */     {
/* 2024 */       xChildInfo = Children.get(Long.valueOf(childId));
/*      */     }
/*      */     else
/*      */     {
/* 2028 */       xChildInfo = Children.select(Long.valueOf(childId));
/*      */     }
/* 2030 */     if (null == xChildInfo)
/*      */     {
/* 2032 */       return 0;
/*      */     }
/*      */     
/* 2035 */     return getChildRating(xChildInfo, false);
/*      */   }
/*      */   
/*      */   static int getChildRating(ChildInfo xChildInfo, boolean isContainDiscard)
/*      */   {
/* 2040 */     if (xChildInfo.getChild_period() != 2)
/*      */     {
/* 2042 */       return 0;
/*      */     }
/* 2044 */     if (0 == xChildInfo.getAdulthood_info().size())
/*      */     {
/* 2046 */       return 0;
/*      */     }
/*      */     
/* 2049 */     if ((xChildInfo.getIs_discard()) && (!isContainDiscard))
/*      */     {
/* 2051 */       return 0;
/*      */     }
/*      */     
/* 2054 */     xbean.AdulthoodInfo xAdulthoodInfo = (xbean.AdulthoodInfo)xChildInfo.getAdulthood_info().get(0);
/*      */     
/* 2056 */     double aptitudeRating = getChildAptitudeRating(xAdulthoodInfo);
/* 2057 */     double growRating = getChildGrowRating(xAdulthoodInfo);
/* 2058 */     double commonSkillRating = getCommonSkillRating(xAdulthoodInfo);
/* 2059 */     double occupationSkillRating = getOccupationSkillRating(xAdulthoodInfo);
/* 2060 */     double specialSkillRating = getSpecialSkillRating(xAdulthoodInfo);
/* 2061 */     double equipLevelRating = getEquipLevelRating(xAdulthoodInfo);
/*      */     
/* 2063 */     double childRating = (aptitudeRating + growRating) * commonSkillRating + specialSkillRating + equipLevelRating + occupationSkillRating;
/* 2064 */     return (int)Math.ceil(childRating);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   static int getTotalChildrenRating(long roleId, boolean retainLock)
/*      */   {
/*      */     Role2ChildrenInfo xRole2ChildrenInfo;
/*      */     
/*      */ 
/*      */     Role2ChildrenInfo xRole2ChildrenInfo;
/*      */     
/*      */ 
/* 2077 */     if (retainLock)
/*      */     {
/* 2079 */       xRole2ChildrenInfo = Role2children.get(Long.valueOf(roleId));
/*      */     }
/*      */     else
/*      */     {
/* 2083 */       xRole2ChildrenInfo = Role2children.select(Long.valueOf(roleId));
/*      */     }
/* 2085 */     if (null == xRole2ChildrenInfo)
/*      */     {
/* 2087 */       return 0;
/*      */     }
/* 2089 */     return xRole2ChildrenInfo.getTotal_rating();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getBestChildRating(long roleId)
/*      */   {
/* 2101 */     Role2ChildrenInfo xRole2ChildrenInfo = Role2children.get(Long.valueOf(roleId));
/* 2102 */     if (null == xRole2ChildrenInfo)
/*      */     {
/* 2104 */       return 0;
/*      */     }
/* 2106 */     List<Long> childIdList = xRole2ChildrenInfo.getChild_id_list();
/* 2107 */     Lockeys.lock(Lockeys.get(Children.getTable(), childIdList));
/* 2108 */     int bestRating = 0;
/* 2109 */     for (Iterator i$ = childIdList.iterator(); i$.hasNext();) { long childId = ((Long)i$.next()).longValue();
/*      */       
/* 2111 */       int childRating = getChildRating(childId, true);
/* 2112 */       bestRating = Math.max(bestRating, childRating);
/*      */     }
/* 2114 */     return bestRating;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getBestChildRatingRank(long roleId)
/*      */   {
/* 2125 */     int res = -1;
/* 2126 */     Role2ChildrenInfo xRole2ChildrenInfo = Role2children.get(Long.valueOf(roleId));
/* 2127 */     if (null == xRole2ChildrenInfo)
/*      */     {
/* 2129 */       return res;
/*      */     }
/* 2131 */     List<Long> childIdList = xRole2ChildrenInfo.getChild_id_listAsData();
/* 2132 */     for (Iterator i$ = childIdList.iterator(); i$.hasNext();) { long childId = ((Long)i$.next()).longValue();
/*      */       
/* 2134 */       int rank = ChildrenRatingRankManager.getInstance().getRank(Long.valueOf(childId));
/* 2135 */       if (-1 != rank)
/*      */       {
/*      */ 
/*      */ 
/* 2139 */         if (-1 == res)
/*      */         {
/* 2141 */           res = rank;
/*      */         }
/*      */         else
/* 2144 */           res = Math.min(rank, res); }
/*      */     }
/* 2146 */     return res;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void triggerChildRatingChange(long roleId, long childId, boolean byDelete)
/*      */   {
/* 2158 */     ChildRatingChange event = new ChildRatingChange();
/* 2159 */     ChildRatingChangeArg arg = new ChildRatingChangeArg(roleId, childId, byDelete);
/* 2160 */     TriggerEventsManger.getInstance().triggerEvent(event, arg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(roleId)));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static Map<Long, Integer> getRoleAllChildrenRating(long roleId)
/*      */   {
/* 2171 */     Map<Long, Integer> child2RatingMap = new HashMap();
/* 2172 */     Role2ChildrenInfo xRole2ChildrenInfo = Role2children.get(Long.valueOf(roleId));
/* 2173 */     if (null == xRole2ChildrenInfo)
/*      */     {
/* 2175 */       return child2RatingMap;
/*      */     }
/* 2177 */     List<Long> childIdList = xRole2ChildrenInfo.getChild_id_list();
/* 2178 */     Lockeys.lock(Lockeys.get(Children.getTable(), childIdList));
/* 2179 */     for (Iterator i$ = childIdList.iterator(); i$.hasNext();) { long childId = ((Long)i$.next()).longValue();
/*      */       
/* 2181 */       int rating = getChildRating(childId, true);
/* 2182 */       if (0 != rating)
/*      */       {
/* 2184 */         child2RatingMap.put(Long.valueOf(childId), Integer.valueOf(rating));
/*      */       }
/*      */     }
/* 2187 */     return child2RatingMap;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void updateTotalRating(long roleId, Collection<Integer> childRatingCollection)
/*      */   {
/* 2198 */     Role2ChildrenInfo xRole2ChildrenInfo = Role2children.get(Long.valueOf(roleId));
/* 2199 */     if (null == xRole2ChildrenInfo)
/*      */     {
/* 2201 */       return;
/*      */     }
/* 2203 */     int totalRating = 0;
/* 2204 */     LinkedList<Integer> ratingList = new LinkedList(childRatingCollection);
/* 2205 */     java.util.Collections.sort(ratingList);
/* 2206 */     for (int i = 0; i < SChildrenConsts.getInstance().child_rating_compute_count; i++)
/*      */     {
/* 2208 */       Integer bestRating = (Integer)ratingList.pollLast();
/* 2209 */       if (null == bestRating) {
/*      */         break;
/*      */       }
/*      */       
/* 2213 */       totalRating += bestRating.intValue();
/*      */     }
/* 2215 */     xRole2ChildrenInfo.setTotal_rating(totalRating);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void onRoleRatingChange(long roleId, long changeChildId, boolean byDelete)
/*      */   {
/* 2229 */     Map<Long, Integer> child2RatingMap = getRoleAllChildrenRating(roleId);
/*      */     
/* 2231 */     updateTotalRating(roleId, child2RatingMap.values());
/*      */     
/* 2233 */     RoleChildRatingChange event = new RoleChildRatingChange();
/* 2234 */     RoleChildRatingChangeArg arg = new RoleChildRatingChangeArg(roleId);
/* 2235 */     TriggerEventsManger.getInstance().triggerEvent(event, arg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(roleId)));
/*      */     
/* 2237 */     if (byDelete)
/*      */     {
/* 2239 */       ChildrenRatingRankManager.getInstance().deleteChildRankData(changeChildId);
/*      */     }
/*      */     else
/*      */     {
/* 2243 */       if (null == child2RatingMap.get(Long.valueOf(changeChildId)))
/*      */       {
/* 2245 */         return;
/*      */       }
/* 2247 */       ChildrenRatingRankManager.getInstance().rank(roleId, changeChildId, ((Integer)child2RatingMap.get(Long.valueOf(changeChildId))).intValue());
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void refreshRoleRating(long roleId)
/*      */   {
/* 2260 */     Map<Long, Integer> child2RatingMap = getRoleAllChildrenRating(roleId);
/*      */     
/* 2262 */     updateTotalRating(roleId, child2RatingMap.values());
/*      */     
/* 2264 */     RoleChildRatingChange event = new RoleChildRatingChange();
/* 2265 */     RoleChildRatingChangeArg arg = new RoleChildRatingChangeArg(roleId);
/* 2266 */     TriggerEventsManger.getInstance().triggerEvent(event, arg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(roleId)));
/*      */     
/* 2268 */     for (Map.Entry<Long, Integer> entry : child2RatingMap.entrySet())
/*      */     {
/* 2270 */       ChildrenRatingRankManager.getInstance().rank(roleId, ((Long)entry.getKey()).longValue(), ((Integer)entry.getValue()).intValue());
/*      */     }
/*      */   }
/*      */   
/*      */   public static void asynRemChildOutFightData(long roleid, long childid)
/*      */   {
/* 2276 */     new PRemChildOutfightData(roleid, childid).execute();
/*      */   }
/*      */   
/*      */ 
/*      */   static void tlogAdultPropPref(long roleid, long childid, Map<Integer, Integer> prefMap)
/*      */   {
/* 2282 */     String vGameIp = GameServerInfoManager.getHostIP();
/* 2283 */     String userid = RoleInterface.getUserId(roleid);
/* 2284 */     int level = RoleInterface.getLevel(roleid);
/* 2285 */     int prop1 = 0;
/* 2286 */     int prop2 = 0;
/* 2287 */     int prop3 = 0;
/* 2288 */     int prop4 = 0;
/* 2289 */     int prop5 = 0;
/* 2290 */     if (prefMap.containsKey(Integer.valueOf(25)))
/*      */     {
/* 2292 */       prop1 = ((Integer)prefMap.get(Integer.valueOf(25))).intValue();
/*      */     }
/* 2294 */     if (prefMap.containsKey(Integer.valueOf(26)))
/*      */     {
/* 2296 */       prop2 = ((Integer)prefMap.get(Integer.valueOf(26))).intValue();
/*      */     }
/* 2298 */     if (prefMap.containsKey(Integer.valueOf(27)))
/*      */     {
/* 2300 */       prop3 = ((Integer)prefMap.get(Integer.valueOf(27))).intValue();
/*      */     }
/* 2302 */     if (prefMap.containsKey(Integer.valueOf(28)))
/*      */     {
/* 2304 */       prop4 = ((Integer)prefMap.get(Integer.valueOf(28))).intValue();
/*      */     }
/* 2306 */     if (prefMap.containsKey(Integer.valueOf(29)))
/*      */     {
/* 2308 */       prop5 = ((Integer)prefMap.get(Integer.valueOf(29))).intValue();
/*      */     }
/* 2310 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d|%d|%d|%d", new Object[] { vGameIp, userid, Long.valueOf(roleid), Integer.valueOf(level), Long.valueOf(childid), Integer.valueOf(prop1), Integer.valueOf(prop2), Integer.valueOf(prop3), Integer.valueOf(prop4), Integer.valueOf(prop5) });
/*      */     
/* 2312 */     TLogManager.getInstance().addLog(roleid, "ChildAdulthoodPropPref", logStr);
/*      */   }
/*      */   
/*      */ 
/*      */   static void tlogAdultSelectOccupation(long roleid, long childid, int occupationid)
/*      */   {
/* 2318 */     String vGameIp = GameServerInfoManager.getHostIP();
/* 2319 */     String userid = RoleInterface.getUserId(roleid);
/* 2320 */     int level = RoleInterface.getLevel(roleid);
/* 2321 */     String logStr = String.format("%s|%s|%d|%d|%d|%d", new Object[] { vGameIp, userid, Long.valueOf(roleid), Integer.valueOf(level), Long.valueOf(childid), Integer.valueOf(occupationid) });
/* 2322 */     TLogManager.getInstance().addLog(roleid, "ChildAdulthoodSelectOccupation", logStr);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void tlogAdultGrow(long roleid, long childid, int operType, int aptType, float beforeValue, float afterValue, float changeValue)
/*      */   {
/* 2333 */     String vGameIp = GameServerInfoManager.getHostIP();
/* 2334 */     String userid = RoleInterface.getUserId(roleid);
/* 2335 */     int level = RoleInterface.getLevel(roleid);
/* 2336 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d|%f|%f|%f", new Object[] { vGameIp, userid, Long.valueOf(roleid), Integer.valueOf(level), Long.valueOf(childid), Integer.valueOf(operType), Integer.valueOf(aptType), Float.valueOf(beforeValue), Float.valueOf(afterValue), Float.valueOf(changeValue) });
/*      */     
/* 2338 */     TLogManager.getInstance().addLog(roleid, "ChildAdulthoodGrow", logStr);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void tlogAdultStudySkill(long roleid, long childid, int skillType, int studySkillid, int replaceSkillid)
/*      */   {
/* 2347 */     String vGameIp = GameServerInfoManager.getHostIP();
/* 2348 */     String userid = RoleInterface.getUserId(roleid);
/* 2349 */     int level = RoleInterface.getLevel(roleid);
/* 2350 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d|%d", new Object[] { vGameIp, userid, Long.valueOf(roleid), Integer.valueOf(level), Long.valueOf(childid), Integer.valueOf(skillType), Integer.valueOf(studySkillid), Integer.valueOf(replaceSkillid) });
/*      */     
/* 2352 */     TLogManager.getInstance().addLog(roleid, "ChildStudySkill", logStr);
/*      */   }
/*      */   
/*      */ 
/*      */   static void tlogAdultOccupationSkillLevelUp(long roleid, long childid, int skillid, int beforeLv, int afterLv)
/*      */   {
/* 2358 */     String vGameIp = GameServerInfoManager.getHostIP();
/* 2359 */     String userid = RoleInterface.getUserId(roleid);
/* 2360 */     int level = RoleInterface.getLevel(roleid);
/* 2361 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d|%d", new Object[] { vGameIp, userid, Long.valueOf(roleid), Integer.valueOf(level), Long.valueOf(childid), Integer.valueOf(skillid), Integer.valueOf(beforeLv), Integer.valueOf(afterLv) });
/*      */     
/* 2363 */     TLogManager.getInstance().addLog(roleid, "ChildOccupationSkillLevelUp", logStr);
/*      */   }
/*      */   
/*      */ 
/*      */   static void tlogAdultUnLockSkillPos(long roleid, long childid, int beforeNum, int afterNum)
/*      */   {
/* 2369 */     String vGameIp = GameServerInfoManager.getHostIP();
/* 2370 */     String userid = RoleInterface.getUserId(roleid);
/* 2371 */     int level = RoleInterface.getLevel(roleid);
/* 2372 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d", new Object[] { vGameIp, userid, Long.valueOf(roleid), Integer.valueOf(level), Long.valueOf(childid), Integer.valueOf(beforeNum), Integer.valueOf(afterNum) });
/* 2373 */     TLogManager.getInstance().addLog(roleid, "ChildUnLockSkillPos", logStr);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   static void tlogAdultChangeOccupation(long roleid, long childid, int oldOccupation, int newOccupation, String oldFightSkills, String newFightSkills, String oldOccSkills, String oldOccSkillLvs, String newOccSkills, String newOccSkillLvs)
/*      */   {
/* 2381 */     String vGameIp = GameServerInfoManager.getHostIP();
/* 2382 */     String userid = RoleInterface.getUserId(roleid);
/* 2383 */     int level = RoleInterface.getLevel(roleid);
/* 2384 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d|%s|%s|%s|%s|%s|%s", new Object[] { vGameIp, userid, Long.valueOf(roleid), Integer.valueOf(level), Long.valueOf(childid), Integer.valueOf(oldOccupation), Integer.valueOf(newOccupation), oldFightSkills, newFightSkills, oldOccSkills, oldOccSkillLvs, newOccSkills, newOccSkillLvs });
/*      */     
/*      */ 
/* 2387 */     TLogManager.getInstance().addLog(roleid, "ChildAdulthoodChangeOccupation", logStr);
/*      */   }
/*      */   
/*      */ 
/*      */   static void tlogAdultWearPetEquip(long roleid, long childid, int pos, long uuid, int cfgid)
/*      */   {
/* 2393 */     String vGameIp = GameServerInfoManager.getHostIP();
/* 2394 */     String userid = RoleInterface.getUserId(roleid);
/* 2395 */     int level = RoleInterface.getLevel(roleid);
/* 2396 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d|%d", new Object[] { vGameIp, userid, Long.valueOf(roleid), Integer.valueOf(level), Long.valueOf(childid), Integer.valueOf(pos), Long.valueOf(uuid), Integer.valueOf(cfgid) });
/* 2397 */     TLogManager.getInstance().addLog(roleid, "ChildAdulthoodWearPetEquip", logStr);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void tlogAdultEquipOper(long roleid, long childid, long uuid, int cfgid, int pos, int operType, int original, int now, int originalExtra1, int nowExtra1)
/*      */   {
/* 2408 */     String vGameIp = GameServerInfoManager.getHostIP();
/* 2409 */     String userid = RoleInterface.getUserId(roleid);
/* 2410 */     int level = RoleInterface.getLevel(roleid);
/* 2411 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d|%d|%d|%d|%d|%d|%d", new Object[] { vGameIp, userid, Long.valueOf(roleid), Integer.valueOf(level), Long.valueOf(childid), Long.valueOf(uuid), Integer.valueOf(cfgid), Integer.valueOf(pos), Integer.valueOf(operType), Integer.valueOf(original), Integer.valueOf(now), Integer.valueOf(originalExtra1), Integer.valueOf(nowExtra1) });
/*      */     
/* 2413 */     TLogManager.getInstance().addLog(roleid, "ChildAdulthoodEquipOper", logStr);
/*      */   }
/*      */   
/*      */ 
/*      */   static void tlogAdultRefreshAmulet(long roleid, long childid, long uuid, int cfgid, String beforeSkills, String afterSkills)
/*      */   {
/* 2419 */     String vGameIp = GameServerInfoManager.getHostIP();
/* 2420 */     String userid = RoleInterface.getUserId(roleid);
/* 2421 */     int level = RoleInterface.getLevel(roleid);
/* 2422 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d|%s|%s", new Object[] { vGameIp, userid, Long.valueOf(roleid), Integer.valueOf(level), Long.valueOf(childid), Long.valueOf(uuid), Integer.valueOf(cfgid), beforeSkills, afterSkills });
/*      */     
/* 2424 */     TLogManager.getInstance().addLog(roleid, "ChildAdulthoodEquipAmulet", logStr);
/*      */   }
/*      */   
/*      */   static void tlogBabyAutoBreed(String userid, long roleid, int level, long childid, int healthValue)
/*      */   {
/* 2429 */     TLogManager.getInstance().addLog(userid, "BabyAutoBreed", new Object[] { GameServerInfoManager.getHostIP(), userid, Long.valueOf(roleid), Integer.valueOf(level), Long.valueOf(childid), Integer.valueOf(healthValue) });
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\main\ChildrenManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
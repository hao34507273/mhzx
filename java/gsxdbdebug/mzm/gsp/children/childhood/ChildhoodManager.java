/*     */ package mzm.gsp.children.childhood;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Random;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.children.ChildHoodInfo;
/*     */ import mzm.gsp.children.confbean.CourseEffectInfo;
/*     */ import mzm.gsp.children.confbean.InterestEffectInfo;
/*     */ import mzm.gsp.children.confbean.QualityInfo;
/*     */ import mzm.gsp.children.confbean.SChildHoodConst;
/*     */ import mzm.gsp.children.confbean.SChildrenConsts;
/*     */ import mzm.gsp.children.confbean.SCourseCfg;
/*     */ import mzm.gsp.children.confbean.SDrawLotsCfg;
/*     */ import mzm.gsp.children.confbean.SInterestCfg;
/*     */ import mzm.gsp.children.confbean.SQualityCfg;
/*     */ import mzm.gsp.children.main.ChildrenInterface;
/*     */ import mzm.gsp.common.TimeCommonUtil;
/*     */ import mzm.gsp.common.confbean.STimeCommonCfg;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.homeland.main.HomelandInterface;
/*     */ import mzm.gsp.mail.main.MailInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.qingfu.main.CostResult;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.timer.main.Observer;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.ChildInfo;
/*     */ import xbean.ChildhoodInfo;
/*     */ import xbean.DailyCourseInfo;
/*     */ import xbean.Pod;
/*     */ import xdb.Xdb;
/*     */ import xio.Protocol;
/*     */ import xtable.Courseobservers;
/*     */ 
/*     */ public class ChildhoodManager
/*     */ {
/*     */   public static boolean isFunOpen(long roleid)
/*     */   {
/*  54 */     return isFunOpen(roleid, 222);
/*     */   }
/*     */   
/*     */   public static boolean isFunOpen(long roleid, int moduleid)
/*     */   {
/*  59 */     if (!OpenInterface.getOpenStatus(moduleid))
/*     */     {
/*  61 */       return false;
/*     */     }
/*  63 */     if (OpenInterface.isBanPlay(roleid, moduleid))
/*     */     {
/*  65 */       OpenInterface.sendBanPlayMsg(roleid, moduleid);
/*  66 */       return false;
/*     */     }
/*  68 */     return true;
/*     */   }
/*     */   
/*     */   static boolean canDoAction(long roleid, int action)
/*     */   {
/*  73 */     return RoleStatusInterface.checkCanSetStatus(roleid, action, true);
/*     */   }
/*     */   
/*     */ 
/*     */   static boolean checkCourse(DailyCourseInfo xDailyCourseInfo, long time)
/*     */   {
/*  79 */     long lastStudyTime = xDailyCourseInfo.getLast_time();
/*  80 */     STimeCommonCfg timeCommonCfg = TimeCommonUtil.getCommonCfg(SChildHoodConst.getInstance().RESET_TIME_CFG_ID);
/*  81 */     if (DateTimeUtils.needDailyReset(lastStudyTime, time, timeCommonCfg.activeHour, timeCommonCfg.activeMinute))
/*     */     {
/*  83 */       xDailyCourseInfo.setNum(0);
/*     */     }
/*     */     
/*     */ 
/*  87 */     if (xDailyCourseInfo.getNum() >= SChildHoodConst.getInstance().DAILY_NUM)
/*     */     {
/*  89 */       return false;
/*     */     }
/*  91 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public static boolean isCrit(int curTotalCritNum, int curTotalNum)
/*     */   {
/*  97 */     int totalCritNum = SChildHoodConst.getInstance().CRIT_NUM;
/*  98 */     if (curTotalCritNum >= totalCritNum)
/*     */     {
/* 100 */       return false;
/*     */     }
/*     */     
/* 103 */     int totalNum = SChildHoodConst.getInstance().TOTAL_NUM;
/* 104 */     if (curTotalNum >= totalNum)
/*     */     {
/* 106 */       return false;
/*     */     }
/*     */     
/* 109 */     int limit = totalNum - curTotalNum;
/* 110 */     int num = totalCritNum - curTotalCritNum;
/*     */     
/* 112 */     Random random = Xdb.random();
/* 113 */     int r = random.nextInt(limit);
/* 114 */     if (r < num)
/*     */     {
/* 116 */       return true;
/*     */     }
/* 118 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static void onCourseEnd(ChildInfo xChildInfo, int courseType, boolean isCrit, long endCourseTime)
/*     */   {
/* 125 */     ChildhoodInfo xChildhoodInfo = xChildInfo.getChildhood_info();
/*     */     
/*     */ 
/* 128 */     DailyCourseInfo xDailyCourseInfo = xChildhoodInfo.getDaily_curse();
/* 129 */     checkCourse(xDailyCourseInfo, endCourseTime);
/* 130 */     xDailyCourseInfo.setLast_time(endCourseTime);
/* 131 */     xDailyCourseInfo.setNum(xDailyCourseInfo.getNum() + 1);
/*     */     
/*     */ 
/* 134 */     xChildhoodInfo.getCur_course().setCourse_type(0);
/*     */     
/*     */ 
/* 137 */     Map<Integer, xbean.CourseInfo> xCourseInfos = xChildhoodInfo.getCourses();
/* 138 */     xbean.CourseInfo xCourseInfo = (xbean.CourseInfo)xCourseInfos.get(Integer.valueOf(courseType));
/* 139 */     if (xCourseInfo == null)
/*     */     {
/* 141 */       xCourseInfo = Pod.newCourseInfo();
/* 142 */       xCourseInfos.put(Integer.valueOf(courseType), xCourseInfo);
/*     */     }
/* 144 */     xCourseInfo.setNum(xCourseInfo.getNum() + 1);
/* 145 */     if (isCrit)
/*     */     {
/* 147 */       xCourseInfo.setCrit_num(xCourseInfo.getCrit_num() + 1);
/* 148 */       xChildhoodInfo.setTotal_crit_num(xChildhoodInfo.getTotal_crit_num() + 1);
/*     */     }
/*     */     
/* 151 */     xChildhoodInfo.setTotal_num(xChildhoodInfo.getTotal_num() + 1);
/*     */   }
/*     */   
/*     */   static boolean cutCurrency(String userid, long roleid, int type, int num, TLogArg tLogArg)
/*     */   {
/* 156 */     boolean result = true;
/* 157 */     switch (type)
/*     */     {
/*     */     case 1: 
/* 160 */       CostResult costResult = QingfuInterface.costYuanbao(userid, roleid, num, CostType.COST_BIND_FIRST_CHILDHOOD_STUDY_COURSE, tLogArg);
/*     */       
/* 162 */       if (costResult != CostResult.Success)
/*     */       {
/* 164 */         result = false;
/* 165 */         GameServer.logger().error(String.format("[childhood]ChildhoodManager.cost@cost yuanbao failed|userid=%s|roleid=%d|num=%d|code=%d|desc=%s", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(num), Integer.valueOf(costResult.code), costResult.desc }));
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */       break;
/*     */     case 2: 
/* 172 */       result = RoleInterface.cutGold(roleid, num, tLogArg);
/* 173 */       break;
/*     */     case 3: 
/* 175 */       result = RoleInterface.cutSilver(roleid, num, tLogArg);
/* 176 */       break;
/*     */     case 5: 
/* 178 */       result = RoleInterface.cutGoldIngot(roleid, num, tLogArg);
/* 179 */       break;
/*     */     case 0: 
/* 181 */       result = false;
/* 182 */       break;
/*     */     case 4: 
/* 184 */       result = GangInterface.cutBangGong(roleid, num, tLogArg);
/* 185 */       break;
/*     */     default: 
/* 187 */       result = false;
/*     */     }
/*     */     
/* 190 */     if (!result)
/*     */     {
/* 192 */       GameServer.logger().error(String.format("[childhood]ChildhoodManager.cutCurrency@cost currency failed|userid=%s|roleid=%d|money_type=%d|num=%d", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(type), Integer.valueOf(num) }));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 197 */     return result;
/*     */   }
/*     */   
/*     */   public static void startCourseObserver(long ownerRoleid, long childid, long seconds)
/*     */   {
/* 202 */     xbean.CourseObserver xCourseObserver = Courseobservers.get(Long.valueOf(childid));
/* 203 */     if (xCourseObserver == null)
/*     */     {
/* 205 */       xCourseObserver = Pod.newCourseObserver();
/* 206 */       Courseobservers.insert(Long.valueOf(childid), xCourseObserver);
/*     */     }
/* 208 */     if (xCourseObserver.getObserver() != null)
/*     */     {
/* 210 */       xCourseObserver.getObserver().stopTimer();
/*     */     }
/* 212 */     xCourseObserver.setObserver(new CourseObserver(ownerRoleid, childid, seconds));
/*     */   }
/*     */   
/*     */   public static void cancelCourseObserver(long childid)
/*     */   {
/* 217 */     xbean.CourseObserver xCourseObserver = Courseobservers.get(Long.valueOf(childid));
/* 218 */     if (xCourseObserver != null)
/*     */     {
/* 220 */       Observer observer = xCourseObserver.getObserver();
/* 221 */       if (observer != null)
/*     */       {
/* 223 */         observer.stopTimer();
/* 224 */         xCourseObserver.setObserver(null);
/*     */       }
/*     */     }
/* 227 */     Courseobservers.remove(Long.valueOf(childid));
/*     */   }
/*     */   
/*     */   public static boolean checkChild(ChildInfo xChildInfo, long operateRoleid, long marriedRoleid)
/*     */   {
/* 232 */     long ownerRoleid = xChildInfo.getOwn_role_id();
/* 233 */     if (ownerRoleid == operateRoleid)
/*     */     {
/* 235 */       if (marriedRoleid == -1L)
/*     */       {
/* 237 */         return xChildInfo.getAnother_parent_role_id() == -1L;
/*     */       }
/*     */       
/*     */ 
/* 241 */       return xChildInfo.getAnother_parent_role_id() == marriedRoleid;
/*     */     }
/*     */     
/* 244 */     if (ownerRoleid == marriedRoleid)
/*     */     {
/* 246 */       return xChildInfo.getAnother_parent_role_id() == operateRoleid;
/*     */     }
/*     */     
/*     */ 
/* 250 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   static int randomInterest(int oldInterest)
/*     */   {
/* 256 */     List<Integer> all = new ArrayList(SDrawLotsCfg.getAll().keySet());
/* 257 */     if (oldInterest != 0)
/*     */     {
/* 259 */       all.remove(Integer.valueOf(oldInterest));
/*     */     }
/* 261 */     List<Integer> list = randomList(all, 1);
/* 262 */     if (list.isEmpty())
/*     */     {
/* 264 */       return -1;
/*     */     }
/*     */     
/*     */ 
/* 268 */     return ((Integer)list.get(0)).intValue();
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
/*     */   private static List<Integer> randomList(List<Integer> list, int count)
/*     */   {
/* 281 */     int size = list.size();
/* 282 */     if ((count > size) || (size == 0) || (count == 0))
/*     */     {
/* 284 */       return Collections.emptyList();
/*     */     }
/*     */     
/* 287 */     if (size == count)
/*     */     {
/* 289 */       return list;
/*     */     }
/*     */     
/* 292 */     Random random = Xdb.random();
/* 293 */     int i = size; for (int j = 0; j < count; j++)
/*     */     {
/* 295 */       Collections.swap(list, i - 1, random.nextInt(i));i--;
/*     */     }
/*     */     
/* 298 */     return list.subList(size - count, size);
/*     */   }
/*     */   
/*     */ 
/*     */   static void asyncSendCourseMail(long childid, ChildInfo xChildInfo, int courseType, String courseName)
/*     */   {
/* 304 */     TLogArg tLogArg = new TLogArg(LogReason.CHILDHOOD_COURSE_MAIL);
/* 305 */     List<String> contentArgs = new ArrayList();
/* 306 */     contentArgs.add(xChildInfo.getChild_name());
/* 307 */     contentArgs.add(courseName);
/*     */     
/* 309 */     MailInterface.asynBuildAndSendMail(xChildInfo.getOwn_role_id(), SChildHoodConst.getInstance().COURSE_MAIL_CFG_ID, null, contentArgs, tLogArg);
/*     */     
/* 311 */     long anotherRoleid = xChildInfo.getAnother_parent_role_id();
/* 312 */     if (anotherRoleid > 0L)
/*     */     {
/* 314 */       MailInterface.asynBuildAndSendMail(anotherRoleid, SChildHoodConst.getInstance().COURSE_MAIL_CFG_ID, null, contentArgs, tLogArg);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void onLogin(long childid, ChildInfo xChildInfo)
/*     */   {
/* 321 */     if (GameServerInfoManager.isRoamServer())
/*     */     {
/* 323 */       return;
/*     */     }
/*     */     
/* 326 */     if (xChildInfo.getChild_period() != 1)
/*     */     {
/* 328 */       return;
/*     */     }
/* 330 */     ChildhoodInfo xChildhoodInfo = xChildInfo.getChildhood_info();
/* 331 */     DailyCourseInfo xDailyCourseInfo = xChildhoodInfo.getDaily_curse();
/* 332 */     checkCourseObserver(childid, xChildInfo);
/* 333 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 334 */     checkCourse(xDailyCourseInfo, now);
/*     */   }
/*     */   
/*     */ 
/*     */   public static void checkModelCfgid(long childid, ChildInfo xChildInfo)
/*     */   {
/* 340 */     ChildhoodInfo xChildhoodInfo = xChildInfo.getChildhood_info();
/* 341 */     if (xChildhoodInfo.getChild_hood_model_cfg_id() <= 0)
/*     */     {
/* 343 */       int gender = xChildInfo.getChild_gender();
/* 344 */       if (gender == 2)
/*     */       {
/* 346 */         xChildhoodInfo.setChild_hood_model_cfg_id(SChildrenConsts.getInstance().GIRL_CHILDHOOD_BASE_CFG_ID);
/*     */       }
/* 348 */       else if (gender == 1)
/*     */       {
/* 350 */         xChildhoodInfo.setChild_hood_model_cfg_id(SChildrenConsts.getInstance().BOY_CHILDHOOD_BASE_CFG_ID);
/*     */       }
/*     */       else
/*     */       {
/* 354 */         GameServer.logger().error(String.format("[childhood]ChildhoodManager.onLogin@gender error|roleid=%d|childid=%d|gender=%d", new Object[] { Long.valueOf(xChildInfo.getOwn_role_id()), Long.valueOf(childid), Integer.valueOf(gender) }));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static void onLogoff(long roleid, long marriedRoleid, List<Long> childIdList)
/*     */   {
/* 363 */     if ((marriedRoleid > 0L) && (OnlineManager.getInstance().isOnline(marriedRoleid)))
/*     */     {
/* 365 */       return;
/*     */     }
/*     */     
/* 368 */     for (Iterator i$ = childIdList.iterator(); i$.hasNext();) { long childid = ((Long)i$.next()).longValue();
/*     */       
/* 370 */       ChildInfo xChildInfo = xtable.Children.get(Long.valueOf(childid));
/* 371 */       if (xChildInfo != null)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 376 */         if (xChildInfo.getChild_period() == 1)
/*     */         {
/* 378 */           ChildhoodInfo xChildhoodInfo = xChildInfo.getChildhood_info();
/* 379 */           xbean.CourseStudyInfo xCourseStudyInfo = xChildhoodInfo.getCur_course();
/* 380 */           int courseType = xCourseStudyInfo.getCourse_type();
/* 381 */           if (courseType != 0)
/*     */           {
/* 383 */             cancelCourseObserver(childid);
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public static void onDiscard(long childid, ChildInfo xChildInfo) {
/* 391 */     if (xChildInfo.getChild_period() == 1)
/*     */     {
/* 393 */       ChildhoodInfo xChildhoodInfo = xChildInfo.getChildhood_info();
/* 394 */       xbean.CourseStudyInfo xCourseStudyInfo = xChildhoodInfo.getCur_course();
/* 395 */       int courseType = xCourseStudyInfo.getCourse_type();
/* 396 */       if (courseType != 0)
/*     */       {
/* 398 */         cancelCourseObserver(childid);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public static ChildHoodInfo getChildhoodInfo(ChildhoodInfo xChildhoodInfo)
/*     */   {
/* 405 */     ChildHoodInfo childHoodInfo = new ChildHoodInfo();
/*     */     
/* 407 */     childHoodInfo.interest = xChildhoodInfo.getInterest();
/* 408 */     childHoodInfo.daily_num = xChildhoodInfo.getDaily_curse().getNum();
/*     */     
/* 410 */     xbean.CourseStudyInfo xCourseStudyInfo = xChildhoodInfo.getCur_course();
/* 411 */     mzm.gsp.children.CourseStudyInfo courseStudyInfo = new mzm.gsp.children.CourseStudyInfo();
/* 412 */     courseStudyInfo.course_type = xCourseStudyInfo.getCourse_type();
/* 413 */     courseStudyInfo.time = ((int)TimeUnit.MILLISECONDS.toSeconds(xCourseStudyInfo.getTime()));
/* 414 */     childHoodInfo.cur_course = courseStudyInfo;
/*     */     
/* 416 */     Map<Integer, xbean.CourseInfo> xCourses = xChildhoodInfo.getCourses();
/* 417 */     for (Map.Entry<Integer, xbean.CourseInfo> xEntry : xCourses.entrySet())
/*     */     {
/* 419 */       xbean.CourseInfo xCourseInfo = (xbean.CourseInfo)xEntry.getValue();
/* 420 */       childHoodInfo.courses.put(xEntry.getKey(), new mzm.gsp.children.CourseInfo(xCourseInfo.getNum(), xCourseInfo.getCrit_num()));
/*     */     }
/*     */     
/* 423 */     return childHoodInfo;
/*     */   }
/*     */   
/*     */   private static void checkCourseObserver(long childid, ChildInfo xChildInfo)
/*     */   {
/* 428 */     if (xChildInfo.getChild_period() == 1)
/*     */     {
/* 430 */       long ownerRoleid = xChildInfo.getOwn_role_id();
/* 431 */       ChildhoodInfo xChildhoodInfo = xChildInfo.getChildhood_info();
/* 432 */       xbean.CourseStudyInfo xCourseStudyInfo = xChildhoodInfo.getCur_course();
/* 433 */       int courseType = xCourseStudyInfo.getCourse_type();
/* 434 */       if (courseType != 0)
/*     */       {
/* 436 */         SCourseCfg courseCfg = SCourseCfg.get(courseType);
/* 437 */         if (courseCfg == null)
/*     */         {
/* 439 */           GameServer.logger().error(String.format("[childhood]ChildhoodManager.checkCourseObserver@course_cfg is null|owner_roleid=%d|another_parent_roleid=%d|childid=%d|course_type=%d", new Object[] { Long.valueOf(ownerRoleid), Long.valueOf(xChildInfo.getAnother_parent_role_id()), Long.valueOf(childid), Integer.valueOf(courseType) }));
/*     */           
/*     */ 
/*     */ 
/* 443 */           return;
/*     */         }
/* 445 */         long now = DateTimeUtils.getCurrTimeInMillis();
/* 446 */         long startTime = xCourseStudyInfo.getTime();
/* 447 */         long delay = TimeUnit.MILLISECONDS.toSeconds(startTime + TimeUnit.MINUTES.toMillis(courseCfg.studyTime) - now);
/*     */         
/* 449 */         if (delay > 0L)
/*     */         {
/* 451 */           startCourseObserver(ownerRoleid, childid, delay);
/*     */         }
/*     */         else
/*     */         {
/* 455 */           long endTime = xCourseStudyInfo.getTime() + TimeUnit.MINUTES.toMillis(courseCfg.studyTime);
/*     */           
/* 457 */           boolean isCrit = isCrit(xChildhoodInfo.getTotal_crit_num(), xChildhoodInfo.getTotal_num());
/*     */           
/* 459 */           onCourseEnd(xChildInfo, courseType, isCrit, endTime);
/*     */           
/* 461 */           courseRecord(childid, courseType, isCrit, endTime);
/*     */           
/* 463 */           asyncSendCourseMail(childid, xChildInfo, courseType, courseCfg.name);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public static boolean checkHomeWorldid(long roleid, boolean remainLock)
/*     */   {
/* 471 */     return HomelandInterface.getHomeWorldIdByRoleId(roleid, remainLock) != -1L;
/*     */   }
/*     */   
/*     */   public static void sendProtocol(long roleid, long marriedRoleid, Protocol msg)
/*     */   {
/* 476 */     OnlineManager.getInstance().send(roleid, msg);
/* 477 */     if ((marriedRoleid > 0L) && (OnlineManager.getInstance().isOnline(marriedRoleid)))
/*     */     {
/* 479 */       OnlineManager.getInstance().send(marriedRoleid, msg);
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
/*     */   static boolean checkCanLearnCourse(int courseType, ChildhoodInfo xChildhoodInfo)
/*     */   {
/* 492 */     if (xChildhoodInfo == null)
/*     */     {
/* 494 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 498 */     Map<Integer, Integer> interests = getInterestValues(xChildhoodInfo);
/*     */     
/* 500 */     SCourseCfg courseCfg = SCourseCfg.get(courseType);
/* 501 */     for (CourseEffectInfo courseEffectInfo : courseCfg.interests)
/*     */     {
/* 503 */       int interestType = courseEffectInfo.interestType;
/* 504 */       Integer interestValue = (Integer)interests.get(Integer.valueOf(interestType));
/* 505 */       if (interestValue == null)
/*     */       {
/* 507 */         return true;
/*     */       }
/*     */       
/* 510 */       SInterestCfg interestCfg = SInterestCfg.get(interestType);
/* 511 */       if (interestValue.intValue() < interestCfg.limit)
/*     */       {
/*     */ 
/* 514 */         return true;
/*     */       }
/*     */     }
/* 517 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static Map<Integer, Integer> getInterestValues(ChildhoodInfo xChildhoodInfo)
/*     */   {
/* 528 */     Map<Integer, xbean.CourseInfo> xCourses = xChildhoodInfo.getCourses();
/* 529 */     if (xCourses.isEmpty())
/*     */     {
/* 531 */       return Collections.emptyMap();
/*     */     }
/*     */     
/*     */ 
/* 535 */     Map<Integer, Integer> interests = new HashMap();
/* 536 */     for (Map.Entry<Integer, xbean.CourseInfo> xEntry : xCourses.entrySet())
/*     */     {
/* 538 */       xbean.CourseInfo xCourseInfo = (xbean.CourseInfo)xEntry.getValue();
/* 539 */       num = xCourseInfo.getNum();
/* 540 */       critNum = xCourseInfo.getCrit_num();
/* 541 */       int courseType = ((Integer)xEntry.getKey()).intValue();
/*     */       
/* 543 */       SCourseCfg courseCfg = SCourseCfg.get(courseType);
/* 544 */       for (CourseEffectInfo courseEffectInfo : courseCfg.interests)
/*     */       {
/* 546 */         int interestType = courseEffectInfo.interestType;
/* 547 */         Integer interestValue = (Integer)interests.get(Integer.valueOf(interestType));
/* 548 */         if (interestValue == null)
/*     */         {
/* 550 */           interestValue = Integer.valueOf(courseEffectInfo.interestValue * num + courseEffectInfo.critValue * critNum);
/*     */         }
/*     */         else
/*     */         {
/* 554 */           interestValue = Integer.valueOf(interestValue.intValue() + (courseEffectInfo.interestValue * num + courseEffectInfo.critValue * critNum));
/*     */         }
/* 556 */         interests.put(Integer.valueOf(interestType), interestValue);
/*     */       }
/*     */     }
/*     */     int num;
/*     */     int critNum;
/* 561 */     Map<Integer, Integer> result = new HashMap(interests);
/* 562 */     for (Map.Entry<Integer, Integer> entry : interests.entrySet())
/*     */     {
/* 564 */       int interestType = ((Integer)entry.getKey()).intValue();
/* 565 */       int interestValue = ((Integer)entry.getValue()).intValue();
/* 566 */       SInterestCfg interestCfg = SInterestCfg.get(interestType);
/* 567 */       if (interestValue > interestCfg.limit)
/*     */       {
/* 569 */         result.put(Integer.valueOf(interestType), Integer.valueOf(interestCfg.limit));
/*     */       }
/*     */     }
/*     */     
/* 573 */     return result;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Map<Integer, Integer> getQuality(ChildhoodInfo xChildhoodInfo)
/*     */   {
/* 584 */     if (xChildhoodInfo == null)
/*     */     {
/* 586 */       return null;
/*     */     }
/*     */     
/*     */ 
/* 590 */     Map<Integer, Integer> interests = getInterestValues(xChildhoodInfo);
/*     */     
/*     */ 
/* 593 */     fillDrawLotsEffect(xChildhoodInfo.getInterest(), interests);
/*     */     
/*     */ 
/* 596 */     for (SInterestCfg interestCfg : SInterestCfg.getAll().values())
/*     */     {
/* 598 */       int interestType = interestCfg.interestType;
/* 599 */       if (interests.get(Integer.valueOf(interestType)) == null)
/*     */       {
/* 601 */         interests.put(Integer.valueOf(interestType), Integer.valueOf(0));
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 606 */     Map<Integer, Integer> qualities = new HashMap();
/* 607 */     for (SQualityCfg qualityCfg : SQualityCfg.getAll().values())
/*     */     {
/* 609 */       int interestType = qualityCfg.interestType;
/* 610 */       Integer value = (Integer)interests.get(Integer.valueOf(interestType));
/* 611 */       if ((value != null) && 
/*     */       
/*     */ 
/*     */ 
/* 615 */         (value.intValue() == qualityCfg.interest))
/*     */       {
/*     */ 
/*     */ 
/* 619 */         for (QualityInfo qualityInfo : qualityCfg.qualities)
/*     */         {
/* 621 */           int qualityType = qualityInfo.qualityType;
/* 622 */           int n = random(qualityInfo.min, qualityInfo.max);
/* 623 */           Integer quality = (Integer)qualities.get(Integer.valueOf(qualityType));
/* 624 */           if (quality == null)
/*     */           {
/* 626 */             qualities.put(Integer.valueOf(qualityType), Integer.valueOf(n));
/*     */           }
/*     */           else
/*     */           {
/* 630 */             qualities.put(Integer.valueOf(qualityType), Integer.valueOf(quality.intValue() + n));
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 635 */     return qualities;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void fillDrawLotsEffect(int drawLotsCfgid, Map<Integer, Integer> interests)
/*     */   {
/* 646 */     if (interests == null)
/*     */     {
/* 648 */       return;
/*     */     }
/* 650 */     SDrawLotsCfg drawLotsCfg = SDrawLotsCfg.get(drawLotsCfgid);
/* 651 */     if (drawLotsCfg == null)
/*     */     {
/* 653 */       return;
/*     */     }
/* 655 */     for (InterestEffectInfo effectInfo : drawLotsCfg.interests)
/*     */     {
/* 657 */       int interestType = effectInfo.interestType;
/* 658 */       Integer interestValue = (Integer)interests.get(Integer.valueOf(interestType));
/* 659 */       if (interestValue == null)
/*     */       {
/* 661 */         interestValue = Integer.valueOf(effectInfo.interestValue);
/*     */       }
/*     */       else
/*     */       {
/* 665 */         interestValue = Integer.valueOf(interestValue.intValue() + effectInfo.interestValue);
/*     */       }
/* 667 */       interests.put(Integer.valueOf(interestType), interestValue);
/*     */     }
/*     */   }
/*     */   
/*     */   private static int random(int min, int max)
/*     */   {
/* 673 */     int n = max - min;
/* 674 */     if (n == 0)
/*     */     {
/* 676 */       return min;
/*     */     }
/* 678 */     if (n > 0)
/*     */     {
/* 680 */       Random random = Xdb.random();
/* 681 */       return random.nextInt(n + 1) + min;
/*     */     }
/*     */     
/*     */ 
/* 685 */     return n;
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
/*     */   static void courseRecord(long childid, int courseType, boolean isCrit, long time)
/*     */   {
/* 698 */     Map<Integer, Integer> intParameters = new HashMap();
/* 699 */     intParameters.put(Integer.valueOf(0), Integer.valueOf(courseType));
/* 700 */     intParameters.put(Integer.valueOf(1), Integer.valueOf(isCrit ? 1 : 0));
/* 701 */     ChildrenInterface.fillChildGrowthDiary(childid, intParameters, null, 3, time);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\childhood\ChildhoodManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
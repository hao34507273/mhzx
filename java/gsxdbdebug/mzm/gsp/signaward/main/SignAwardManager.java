/*      */ package mzm.gsp.signaward.main;
/*      */ 
/*      */ import java.text.ParseException;
/*      */ import java.text.SimpleDateFormat;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collections;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import java.util.Random;
/*      */ import java.util.Set;
/*      */ import java.util.TreeMap;
/*      */ import java.util.concurrent.TimeUnit;
/*      */ import mzm.event.TriggerEventsManger;
/*      */ import mzm.gsp.GameServer;
/*      */ import mzm.gsp.GameServerInfoManager;
/*      */ import mzm.gsp.activity2.confbean.SRomanticDanceConsts;
/*      */ import mzm.gsp.award.main.AwardModel;
/*      */ import mzm.gsp.awardpool.main.AwardPoolInterface;
/*      */ import mzm.gsp.awardpool.main.AwardPoolResultData;
/*      */ import mzm.gsp.item.main.LotteryManager;
/*      */ import mzm.gsp.online.main.OnlineManager;
/*      */ import mzm.gsp.open.main.OpenInterface;
/*      */ import mzm.gsp.qingfu.main.CostResult;
/*      */ import mzm.gsp.qingfu.main.QingfuInterface;
/*      */ import mzm.gsp.role.main.RoleInterface;
/*      */ import mzm.gsp.signaward.SLevelAwardRes;
/*      */ import mzm.gsp.signaward.SLoginAwardRes;
/*      */ import mzm.gsp.signaward.SSignAwardErrorInfo;
/*      */ import mzm.gsp.signaward.SSignInRes;
/*      */ import mzm.gsp.signaward.SSynAwardedRes;
/*      */ import mzm.gsp.signaward.SSynOnlineTimeRes;
/*      */ import mzm.gsp.signaward.confbean.Date2SignAward;
/*      */ import mzm.gsp.signaward.confbean.ItemId2Count;
/*      */ import mzm.gsp.signaward.confbean.SCashSigncountCfg;
/*      */ import mzm.gsp.signaward.confbean.SGiftCode;
/*      */ import mzm.gsp.signaward.confbean.SLevelmenpaisex2Award;
/*      */ import mzm.gsp.signaward.confbean.SLoginAward;
/*      */ import mzm.gsp.signaward.confbean.SOnlineAward;
/*      */ import mzm.gsp.signaward.event.LevelUpAwardEvent;
/*      */ import mzm.gsp.signaward.event.SignArg;
/*      */ import mzm.gsp.signprecious.confbean.SChessBoxAwardCfg;
/*      */ import mzm.gsp.signprecious.confbean.SChessBoxBuffAwardCfg;
/*      */ import mzm.gsp.signprecious.confbean.SChessItemAwardCfg;
/*      */ import mzm.gsp.signprecious.confbean.SSignPreciousConsts;
/*      */ import mzm.gsp.status.main.RoleStatusInterface;
/*      */ import mzm.gsp.tlog.LogReason;
/*      */ import mzm.gsp.tlog.TLogArg;
/*      */ import mzm.gsp.tlog.TLogManager;
/*      */ import mzm.gsp.util.CommonUtils;
/*      */ import mzm.gsp.util.DateTimeUtils;
/*      */ import org.apache.log4j.Logger;
/*      */ import xbean.LevelAward;
/*      */ import xbean.LoginAward;
/*      */ import xbean.OnlineAward;
/*      */ import xbean.Openserver;
/*      */ import xbean.Pod;
/*      */ import xbean.RoleGiftCards;
/*      */ import xbean.Sign;
/*      */ import xdb.Xdb;
/*      */ import xtable.Role2giftcards;
/*      */ import xtable.Role2levelaward;
/*      */ import xtable.Role2loginaward;
/*      */ 
/*      */ class SignAwardManager
/*      */ {
/*   69 */   static Logger logger = null;
/*      */   
/*      */   static void init()
/*      */   {
/*   73 */     logger = Logger.getLogger("signaward");
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static List<ItemId2Count> getAwardByTime(int time)
/*      */   {
/*   84 */     SOnlineAward onlineAward = SOnlineAward.get(time);
/*   85 */     if (onlineAward == null)
/*      */     {
/*   87 */       return new ArrayList();
/*      */     }
/*      */     
/*      */ 
/*   91 */     return onlineAward.itemIdCountList;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private static int getYmd(int year, int month, int day)
/*      */   {
/*   98 */     return year * 10000 + month * 100 + day;
/*      */   }
/*      */   
/*      */   private static int getLevelUpKey(int level, int menpai, int sex)
/*      */   {
/*  103 */     return level * 1000 + menpai * 100 + sex;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static SGiftCode getSGiftCode(int cardtype, int parenttype)
/*      */   {
/*  115 */     for (SGiftCode g : SGiftCode.getAll().values())
/*      */     {
/*  117 */       if ((g.cardtype == cardtype) && (g.parenttype == parenttype))
/*      */       {
/*  119 */         return g;
/*      */       }
/*      */     }
/*  122 */     return null;
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
/*      */   static Date2SignAward getSSignAward(int ymd)
/*      */   {
/*  136 */     return Date2SignAward.get(ymd);
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
/*      */   static SLevelmenpaisex2Award getSlevelUpAward(int level, int menpai, int sex)
/*      */   {
/*  149 */     int key = getLevelUpKey(level, menpai, sex);
/*  150 */     return SLevelmenpaisex2Award.get(key);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static SLoginAward getSLoginAward(int logincount)
/*      */   {
/*  162 */     return SLoginAward.get(logincount);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static Set<Integer> getAllLoginDaysCanAward()
/*      */   {
/*  172 */     return new java.util.HashSet(SLoginAward.getAll().keySet());
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
/*      */   static boolean signIn(Sign sign, int signday, long signtime)
/*      */   {
/*  188 */     sign.setSigntime(signtime);
/*  189 */     sign.setSignday(signday);
/*  190 */     sign.setSigncount(sign.getSigncount() + 1);
/*  191 */     return true;
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
/*      */   static boolean replenishSignIn(Sign sign, int signday, long signtime)
/*      */   {
/*  207 */     sign.setFillincount(sign.getFillincount() - 1);
/*  208 */     sign.setSigntime(signtime);
/*  209 */     sign.setSignday(signday);
/*  210 */     sign.setSigncount(sign.getSigncount() + 1);
/*  211 */     return true;
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
/*      */   static boolean isTodaySignIn(Sign xSign, long curtime)
/*      */   {
/*  225 */     if (xSign == null)
/*      */     {
/*  227 */       return false;
/*      */     }
/*  229 */     long signTime = xSign.getSigntime();
/*  230 */     if (signTime == 0L)
/*      */     {
/*  232 */       return false;
/*      */     }
/*      */     
/*  235 */     return DateTimeUtils.isInSameDay(xSign.getSigntime(), curtime);
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
/*      */   static boolean addLoginAward(long roleid, int loginday)
/*      */   {
/*  248 */     LoginAward loginAward = Role2loginaward.get(Long.valueOf(roleid));
/*  249 */     if (loginAward == null)
/*      */     {
/*      */ 
/*  252 */       return false;
/*      */     }
/*      */     
/*  255 */     loginAward.getDayawardlist().add(Integer.valueOf(loginday));
/*  256 */     return true;
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
/*      */   static boolean addLoginDay(long roleid, long logintime)
/*      */   {
/*  269 */     LoginAward loginAward = Role2loginaward.get(Long.valueOf(roleid));
/*  270 */     if (loginAward == null)
/*      */     {
/*  272 */       loginAward = Pod.newLoginAward();
/*  273 */       Role2loginaward.insert(Long.valueOf(roleid), loginAward);
/*      */     }
/*      */     
/*  276 */     loginAward.setLoginday(loginAward.getLoginday() + 1);
/*  277 */     loginAward.setLogintime(logintime);
/*  278 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static long getLoginTime(long roleid)
/*      */   {
/*  289 */     LoginAward loginAward = Role2loginaward.get(Long.valueOf(roleid));
/*  290 */     if (loginAward == null)
/*      */     {
/*  292 */       return 0L;
/*      */     }
/*      */     
/*  295 */     return loginAward.getLogintime();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getLoginDay(long roleid)
/*      */   {
/*  306 */     LoginAward loginAward = Role2loginaward.get(Long.valueOf(roleid));
/*  307 */     if (loginAward == null)
/*      */     {
/*  309 */       return 0;
/*      */     }
/*      */     
/*  312 */     return loginAward.getLoginday();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static List<Integer> getLoginAward(long roleid)
/*      */   {
/*  324 */     LoginAward loginAward = Role2loginaward.get(Long.valueOf(roleid));
/*  325 */     if (loginAward == null)
/*      */     {
/*  327 */       return new ArrayList();
/*      */     }
/*      */     
/*  330 */     return loginAward.getDayawardlist();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static List<Integer> getCanAwardDays(long roleid)
/*      */   {
/*  341 */     LoginAward loginAward = Role2loginaward.get(Long.valueOf(roleid));
/*  342 */     if (loginAward == null)
/*      */     {
/*  344 */       return new ArrayList();
/*      */     }
/*  346 */     int loginday = loginAward.getLoginday();
/*  347 */     List<Integer> awardedList = loginAward.getDayawardlist();
/*      */     
/*  349 */     Set<Integer> allSet = getAllLoginDaysCanAward();
/*  350 */     List<Integer> canGet = new ArrayList();
/*  351 */     for (Integer i : allSet)
/*      */     {
/*  353 */       if (i.intValue() <= loginday)
/*      */       {
/*  355 */         canGet.add(i);
/*      */       }
/*      */     }
/*  358 */     canGet.removeAll(awardedList);
/*  359 */     return canGet;
/*      */   }
/*      */   
/*      */   static void sendSLoginAwardRes(long roleid, Map<Integer, Integer> itemid2countMap)
/*      */   {
/*  364 */     SLoginAwardRes res = new SLoginAwardRes();
/*  365 */     res.loginday = getLoginDay(roleid);
/*  366 */     res.awardeddays.addAll(getLoginAward(roleid));
/*  367 */     res.canawarddays.addAll(getCanAwardDays(roleid));
/*  368 */     if ((itemid2countMap != null) && (!itemid2countMap.isEmpty()))
/*      */     {
/*  370 */       res.item2num.putAll(itemid2countMap);
/*      */     }
/*  372 */     OnlineManager.getInstance().send(roleid, res);
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
/*      */ 
/*      */ 
/*      */   static void sendSSignInRes(long roleId, Sign xSign, long currentMillTime, int itemId, int itemNum)
/*      */   {
/*  391 */     SSignInRes sSignInRes = new SSignInRes();
/*  392 */     sSignInRes.fillincount = xSign.getFillincount();
/*  393 */     sSignInRes.signcount = xSign.getSigncount();
/*  394 */     sSignInRes.signday = xSign.getSignday();
/*  395 */     sSignInRes.issignedtoday = (isTodaySignIn(xSign, currentMillTime) ? 1 : 0);
/*  396 */     sSignInRes.currentdate = getYmd(DateTimeUtils.getYear(currentMillTime), DateTimeUtils.getMonth(currentMillTime) + 1, DateTimeUtils.getDay(currentMillTime));
/*      */     
/*  398 */     if (itemId != 0)
/*      */     {
/*  400 */       sSignInRes.item2num.put(Integer.valueOf(itemId), Integer.valueOf(itemNum));
/*      */     }
/*  402 */     sSignInRes.current_precious_cell_num = xSign.getCurrent_precious_cell_num();
/*  403 */     sSignInRes.current_precious_cell_buff_id = xSign.getCurrent_precious_box_buff_id();
/*  404 */     if (xSign.getBox_sign_award_state() >= 2)
/*      */     {
/*  406 */       sSignInRes.is_first_box_aleardy_get = 1;
/*      */     }
/*  408 */     OnlineManager.getInstance().send(roleId, sSignInRes);
/*      */   }
/*      */   
/*      */   static void sendSLevelAwardRes(long roleid, Map<Integer, Integer> itemid2countMap)
/*      */   {
/*  413 */     SLevelAwardRes res = new SLevelAwardRes();
/*  414 */     res.awardedlevels.addAll(getLevelAwards(roleid));
/*  415 */     if ((itemid2countMap != null) && (!itemid2countMap.isEmpty()))
/*      */     {
/*  417 */       res.item2num.putAll(itemid2countMap);
/*      */     }
/*      */     
/*  420 */     OnlineManager.getInstance().send(roleid, res);
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
/*      */   static void sendSSynOnlineTimeRes(long roleid, int onlinetime)
/*      */   {
/*  433 */     SSynOnlineTimeRes res = new SSynOnlineTimeRes();
/*  434 */     res.onlinetime = onlinetime;
/*      */     
/*  436 */     OnlineManager.getInstance().send(roleid, res);
/*      */   }
/*      */   
/*      */ 
/*      */   static void sendSSynAwardedRes(long roleid, OnlineAward xOnlineAward, Map<Integer, Integer> itemid2countMap)
/*      */   {
/*  442 */     SSynAwardedRes res = new SSynAwardedRes();
/*      */     
/*  444 */     res.awardedtimes.addAll(xOnlineAward.getOnlineawardlist());
/*  445 */     if ((itemid2countMap != null) && (!itemid2countMap.isEmpty()))
/*      */     {
/*  447 */       res.item2num.putAll(itemid2countMap);
/*      */     }
/*  449 */     OnlineManager.getInstance().send(roleid, res);
/*      */   }
/*      */   
/*      */   static void sendErrorProtocal(long roleid, int rescode)
/*      */   {
/*  454 */     SSignAwardErrorInfo awardErrorInfo = new SSignAwardErrorInfo();
/*  455 */     awardErrorInfo.rescode = rescode;
/*  456 */     OnlineManager.getInstance().sendAtOnce(roleid, awardErrorInfo);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean addLevelAward(long roleid, int level)
/*      */   {
/*  468 */     LevelAward levelAward = Role2levelaward.get(Long.valueOf(roleid));
/*  469 */     if (levelAward == null)
/*      */     {
/*  471 */       levelAward = Pod.newLevelAward();
/*  472 */       Role2levelaward.insert(Long.valueOf(roleid), levelAward);
/*      */     }
/*  474 */     if (levelAward.getLevelawardlist().contains(Integer.valueOf(level)))
/*      */     {
/*  476 */       return false;
/*      */     }
/*  478 */     levelAward.getLevelawardlist().add(Integer.valueOf(level));
/*  479 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static List<Integer> getLevelAwards(long roleid)
/*      */   {
/*  490 */     LevelAward levelAward = Role2levelaward.get(Long.valueOf(roleid));
/*  491 */     if (levelAward == null)
/*      */     {
/*  493 */       return new ArrayList();
/*      */     }
/*      */     
/*  496 */     return levelAward.getLevelawardlist();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void resetOnlineAward(OnlineAward xOnlineAward, long logintime)
/*      */   {
/*  508 */     xOnlineAward.setLogintime(logintime);
/*  509 */     xOnlineAward.setOnlinetime(0L);
/*      */     
/*  511 */     xOnlineAward.getOnlineawardlist().clear();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean isCardnumberUsed(long roleid, String cardnumber)
/*      */   {
/*  523 */     RoleGiftCards xRoleGiftCards = Role2giftcards.get(Long.valueOf(roleid));
/*  524 */     if (xRoleGiftCards == null)
/*      */     {
/*  526 */       return false;
/*      */     }
/*  528 */     if (xRoleGiftCards.getCards().containsKey(cardnumber))
/*      */     {
/*  530 */       return true;
/*      */     }
/*  532 */     return false;
/*      */   }
/*      */   
/*      */   static void triggerSignEvent(long roleid, int signday, int itemid, int count, boolean isResign)
/*      */   {
/*  537 */     TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.signaward.event.SignEvent(), new SignArg(roleid, signday, itemid, count, isResign));
/*      */   }
/*      */   
/*      */ 
/*      */   static void triggerLoginAwardEvent(long roleid, int loginday)
/*      */   {
/*  543 */     TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.signaward.event.LoginAwardEvent(), new mzm.gsp.signaward.event.LoginAwardArg(roleid, loginday));
/*      */   }
/*      */   
/*      */ 
/*      */   static void triggerLevelUpAwardEvent(long roleid, int level)
/*      */   {
/*  549 */     TriggerEventsManger.getInstance().triggerEvent(new LevelUpAwardEvent(), new mzm.gsp.signaward.event.LevelUpAwardArg(roleid, level));
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
/*      */   static boolean hasOnlineTimeAward(OnlineAward onlineAward)
/*      */   {
/*  562 */     List<Integer> canaward = new ArrayList();
/*  563 */     long onlinetime = onlineAward.getOnlinetime();
/*  564 */     for (Iterator i$ = SOnlineAward.getAll().keySet().iterator(); i$.hasNext();) { int min = ((Integer)i$.next()).intValue();
/*      */       
/*  566 */       if (TimeUnit.MINUTES.toSeconds(min) <= onlinetime)
/*      */       {
/*  568 */         canaward.add(Integer.valueOf(min));
/*      */       }
/*      */     }
/*      */     
/*  572 */     canaward.removeAll(onlineAward.getOnlineawardlist());
/*  573 */     return canaward.size() > 0;
/*      */   }
/*      */   
/*      */   static boolean useGiftbag(String userid, long roleid, int rewardid, TLogArg logArg)
/*      */   {
/*  578 */     AwardModel awardModel = mzm.gsp.award.main.AwardInterface.awardFixAward(rewardid, userid, roleid, true, true, new mzm.gsp.award.main.AwardReason(logArg.getLogReason(), logArg.getSubReason()));
/*      */     
/*  580 */     return awardModel != null;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static List<Integer> getAwardedDays(long roleid)
/*      */   {
/*  592 */     Openserver openserver = xtable.Role2openserver.get(Long.valueOf(roleid));
/*  593 */     if (openserver == null)
/*      */     {
/*  595 */       return null;
/*      */     }
/*  597 */     return openserver.getAwardeddays();
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
/*      */   static void tlogSign(long roleid, int awardid, int signday, int status, int isUseYuanBao, int currentCellNum)
/*      */   {
/*  611 */     String vGameIP = GameServerInfoManager.getHostIP();
/*  612 */     String userid = RoleInterface.getUserId(roleid);
/*  613 */     int rolelevel = RoleInterface.getLevel(roleid);
/*      */     
/*  615 */     int cellBoxType = 0;
/*  616 */     SChessBoxAwardCfg sChessBoxAwardCfg = SChessBoxAwardCfg.get(currentCellNum);
/*  617 */     if (sChessBoxAwardCfg != null)
/*      */     {
/*  619 */       cellBoxType = sChessBoxAwardCfg.cell_award_type;
/*      */     }
/*      */     
/*  622 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d|%d|%d", new Object[] { vGameIP, userid, Long.valueOf(roleid), Integer.valueOf(rolelevel), Integer.valueOf(awardid), Integer.valueOf(signday), Integer.valueOf(status), Integer.valueOf(isUseYuanBao), Integer.valueOf(cellBoxType) });
/*      */     
/*  624 */     TLogManager.getInstance().addLog(roleid, "Sign", logStr);
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
/*      */   static void tlogLevelAward(long roleid, int awardid, int awardlevel)
/*      */   {
/*  638 */     String vGameIP = GameServerInfoManager.getHostIP();
/*  639 */     String userid = RoleInterface.getUserId(roleid);
/*  640 */     int rolelevel = RoleInterface.getLevel(roleid);
/*      */     
/*  642 */     String logStr = String.format("%s|%s|%d|%d|%d|%d", new Object[] { vGameIP, userid, Long.valueOf(roleid), Integer.valueOf(rolelevel), Integer.valueOf(awardid), Integer.valueOf(awardlevel) });
/*      */     
/*      */ 
/*  645 */     TLogManager.getInstance().addLog(roleid, "LevelAward", logStr);
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
/*      */   static void tlogLoginAward(long roleid, int awardid, int day)
/*      */   {
/*  659 */     String vGameIP = GameServerInfoManager.getHostIP();
/*  660 */     String userid = RoleInterface.getUserId(roleid);
/*  661 */     int rolelevel = RoleInterface.getLevel(roleid);
/*      */     
/*  663 */     String logStr = String.format("%s|%s|%d|%d|%d|%d", new Object[] { vGameIP, userid, Long.valueOf(roleid), Integer.valueOf(rolelevel), Integer.valueOf(awardid), Integer.valueOf(day) });
/*      */     
/*      */ 
/*  666 */     TLogManager.getInstance().addLog(roleid, "LoginAward", logStr);
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
/*      */   static void tlogOnlineAward(long roleid, int awardid, int onlinetime)
/*      */   {
/*  680 */     String vGameIP = GameServerInfoManager.getHostIP();
/*  681 */     String userid = RoleInterface.getUserId(roleid);
/*  682 */     int rolelevel = RoleInterface.getLevel(roleid);
/*      */     
/*  684 */     String logStr = String.format("%s|%s|%d|%d|%d|%d", new Object[] { vGameIP, userid, Long.valueOf(roleid), Integer.valueOf(rolelevel), Integer.valueOf(awardid), Integer.valueOf(onlinetime) });
/*      */     
/*      */ 
/*  687 */     TLogManager.getInstance().addLog(roleid, "OnlineAward", logStr);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getAwardfillcount(long cashcount)
/*      */   {
/*  698 */     Map<Integer, SCashSigncountCfg> map = SCashSigncountCfg.getAll();
/*  699 */     if ((map instanceof TreeMap))
/*      */     {
/*  701 */       TreeMap<Integer, SCashSigncountCfg> treeMap = (TreeMap)map;
/*  702 */       Integer floorKey = (Integer)treeMap.floorKey(Integer.valueOf((int)cashcount));
/*  703 */       if (floorKey == null)
/*      */       {
/*  705 */         return 0;
/*      */       }
/*  707 */       return SCashSigncountCfg.get(floorKey.intValue()).signcount;
/*      */     }
/*      */     
/*      */ 
/*  711 */     List<Integer> cashcounts = new ArrayList(SCashSigncountCfg.getAll().keySet());
/*  712 */     Collections.sort(cashcounts);
/*      */     
/*  714 */     int k = -1;
/*  715 */     for (int i = 0; i < cashcounts.size(); i++)
/*      */     {
/*  717 */       int yuanbaonum = ((Integer)cashcounts.get(i)).intValue();
/*  718 */       if (yuanbaonum > cashcount) {
/*      */         break;
/*      */       }
/*      */       
/*  722 */       if (yuanbaonum <= cashcount)
/*      */       {
/*  724 */         k = yuanbaonum;
/*      */       }
/*      */     }
/*  727 */     if (k == -1)
/*      */     {
/*  729 */       return 0;
/*      */     }
/*  731 */     return SCashSigncountCfg.get(k).signcount;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   static boolean isSignSwitchOpenForRole(long roleid)
/*      */   {
/*  738 */     if (!OpenInterface.getOpenStatus(34))
/*      */     {
/*  740 */       return false;
/*      */     }
/*  742 */     if (OpenInterface.isBanPlay(roleid, 34))
/*      */     {
/*  744 */       OpenInterface.sendBanPlayMsg(roleid, 34);
/*  745 */       return false;
/*      */     }
/*  747 */     return true;
/*      */   }
/*      */   
/*      */   static boolean isLevelAwardSwitchOpenForRole(long roleid)
/*      */   {
/*  752 */     if (!OpenInterface.getOpenStatus(35))
/*      */     {
/*  754 */       return false;
/*      */     }
/*  756 */     if (OpenInterface.isBanPlay(roleid, 35))
/*      */     {
/*  758 */       OpenInterface.sendBanPlayMsg(roleid, 35);
/*  759 */       return false;
/*      */     }
/*  761 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   static boolean isLoginAwardSwitchOpenForRole(long roleid)
/*      */   {
/*  767 */     if (!OpenInterface.getOpenStatus(36))
/*      */     {
/*  769 */       return false;
/*      */     }
/*  771 */     if (OpenInterface.isBanPlay(roleid, 36))
/*      */     {
/*  773 */       OpenInterface.sendBanPlayMsg(roleid, 36);
/*  774 */       return false;
/*      */     }
/*  776 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   static boolean isOnlineAwardSwitchOpenForRole(long roleid)
/*      */   {
/*  782 */     if (!OpenInterface.getOpenStatus(37))
/*      */     {
/*  784 */       return false;
/*      */     }
/*  786 */     if (OpenInterface.isBanPlay(roleid, 37))
/*      */     {
/*  788 */       OpenInterface.sendBanPlayMsg(roleid, 37);
/*  789 */       return false;
/*      */     }
/*  791 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   static boolean isSignDayAvailable(long now, SignDayBean signDayBean)
/*      */   {
/*  798 */     int todayYear = DateTimeUtils.getYear(now);
/*  799 */     int todayMonth = DateTimeUtils.getMonth(now);
/*  800 */     int todayDay = DateTimeUtils.getDay(now);
/*      */     
/*  802 */     if (todayYear != signDayBean.getYear())
/*      */     {
/*  804 */       return false;
/*      */     }
/*      */     
/*  807 */     if (todayMonth != signDayBean.getMonth())
/*      */     {
/*  809 */       return false;
/*      */     }
/*  811 */     if (todayDay < signDayBean.getDay())
/*      */     {
/*  813 */       return false;
/*      */     }
/*  815 */     return true;
/*      */   }
/*      */   
/*      */   static boolean isSignDayFormatRight(int d)
/*      */   {
/*      */     try
/*      */     {
/*  822 */       SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
/*  823 */       sdf.setLenient(false);
/*  824 */       sdf.parse(String.valueOf(d));
/*  825 */       return true;
/*      */     }
/*      */     catch (ParseException e) {}
/*      */     
/*  829 */     return false;
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
/*      */   static boolean isAlreadySignDayAndSignDayRight(int alreadySignDay, int signDay)
/*      */   {
/*  845 */     long old = DateTimeUtils.valueOf(alreadySignDay + "00");
/*  846 */     long signtime = DateTimeUtils.valueOf(signDay + "00");
/*      */     
/*  848 */     int diff = DateTimeUtils.diffDays(signtime, old);
/*      */     
/*  850 */     if (Math.abs(diff) != 1)
/*      */     {
/*      */ 
/*  853 */       return false;
/*      */     }
/*  855 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean isRoleStateCanGetAward(long roleid)
/*      */   {
/*  867 */     return RoleStatusInterface.checkCanSetStatus(roleid, 138, true);
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
/*      */   static boolean isSignPreciousSwitchOpen(long roleId)
/*      */   {
/*  880 */     if (!OpenInterface.getOpenStatus(271))
/*      */     {
/*  882 */       GameServer.logger().info(String.format("[sign]SignAwardManager.isSignPreciousSwitchOpen@sign precious system switch closed|role_id=%d", new Object[] { Long.valueOf(roleId) }));
/*      */       
/*      */ 
/*      */ 
/*      */ 
/*  887 */       return false;
/*      */     }
/*      */     
/*  890 */     if (OpenInterface.isBanPlay(roleId, 271))
/*      */     {
/*  892 */       GameServer.logger().info(String.format("[sign]SignAwardManager.isSignPreciousSwitchOpen@sign precious system is ban play|role_id=%d", new Object[] { Long.valueOf(roleId) }));
/*      */       
/*      */ 
/*      */ 
/*      */ 
/*  897 */       OpenInterface.sendBanPlayMsg(roleId, 271);
/*  898 */       return false;
/*      */     }
/*      */     
/*  901 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   static boolean handleSignPrecious(String userId, long roleId, Sign xSign, int roleLevel, long clientYuanBao, int isUseYuanBao)
/*      */   {
/*  908 */     if (xSign.getLucky_box_sign_box_buff_id() > 0)
/*      */     {
/*  910 */       xSign.setLucky_box_sign_box_buff_id(0);
/*      */     }
/*      */     
/*  913 */     if (xSign.getCurrent_precious_box_buff_id() > 0)
/*      */     {
/*  915 */       xSign.setCurrent_precious_box_buff_id(0);
/*      */     }
/*      */     
/*  918 */     if (xSign.getLucky_box_gold_precious_cfg_id() > 0)
/*      */     {
/*  920 */       xSign.setLucky_box_gold_precious_cfg_id(0);
/*      */     }
/*      */     
/*  923 */     if (isUseYuanBao == 1)
/*      */     {
/*  925 */       if (xSign.getBox_sign_award_state() == 0)
/*      */       {
/*  927 */         onSignInFail(roleId, 30, null);
/*  928 */         return false;
/*      */       }
/*      */       
/*  931 */       boolean forceArriveResult = forceArriveBox(xSign, userId, roleId, clientYuanBao);
/*  932 */       if (forceArriveResult)
/*      */       {
/*  934 */         xSign.setBox_sign_award_state(4);
/*  935 */         return true;
/*      */       }
/*      */       
/*      */ 
/*  939 */       return false;
/*      */     }
/*      */     
/*      */ 
/*  943 */     int currentPreciousCellNum = xSign.getCurrent_precious_cell_num();
/*      */     
/*  945 */     int randomDice = getRandomDice(currentPreciousCellNum);
/*      */     
/*      */ 
/*  948 */     if (xSign.getBox_sign_award_state() == 0)
/*      */     {
/*  950 */       int leftCellNum = 6 - currentPreciousCellNum;
/*  951 */       if ((xSign.getSigncount() >= SSignPreciousConsts.getInstance().arrive_first_box_max_days) || (leftCellNum <= randomDice))
/*      */       {
/*      */ 
/*  954 */         xSign.setBox_sign_award_state(1);
/*  955 */         randomDice = leftCellNum;
/*      */       }
/*      */     }
/*      */     
/*  959 */     int nowCellNum = currentPreciousCellNum + randomDice;
/*      */     
/*  961 */     int realCellNum = nowCellNum > SSignPreciousConsts.getInstance().cell_total_num ? nowCellNum % SSignPreciousConsts.getInstance().cell_total_num : nowCellNum;
/*      */     
/*      */ 
/*  964 */     SChessItemAwardCfg sChessItemAwardCfg = SChessItemAwardCfg.get(realCellNum);
/*  965 */     if (sChessItemAwardCfg != null)
/*      */     {
/*  967 */       AwardPoolResultData awardPoolResultData = AwardPoolInterface.getAwardPoolData(sChessItemAwardCfg.award_pool_class_id, roleId, roleLevel);
/*      */       
/*      */ 
/*  970 */       boolean ret = LotteryManager.addLottery(roleId, 9, 0, awardPoolResultData, new TLogArg(LogReason.SIGN_PRECIOUS_AWARD_ITEM), SRomanticDanceConsts.getInstance().delay_award_seconds);
/*      */       
/*      */ 
/*  973 */       if (!ret)
/*      */       {
/*  975 */         onSignInFail(roleId, 28, null);
/*  976 */         return false;
/*      */       }
/*      */     }
/*      */     else
/*      */     {
/*  981 */       SChessBoxAwardCfg sChessBoxAwardCfg = SChessBoxAwardCfg.get(realCellNum);
/*  982 */       if (sChessBoxAwardCfg == null)
/*      */       {
/*  984 */         Map<String, Object> extraMap = new HashMap();
/*  985 */         extraMap.put("real_cell_num", Integer.valueOf(realCellNum));
/*  986 */         onSignInFail(roleId, 13, extraMap);
/*      */         
/*  988 */         return false;
/*      */       }
/*      */       
/*  991 */       SChessBoxBuffAwardCfg sChessBoxBuffAwardCfg = SChessBoxBuffAwardCfg.get(sChessBoxAwardCfg.cell_award_type);
/*  992 */       if (sChessBoxBuffAwardCfg == null)
/*      */       {
/*  994 */         Map<String, Object> extraMap = new HashMap();
/*  995 */         extraMap.put("cell_award_type", Integer.valueOf(sChessBoxAwardCfg.cell_award_type));
/*  996 */         onSignInFail(roleId, 13, extraMap);
/*      */         
/*  998 */         return false;
/*      */       }
/*      */       
/* 1001 */       Map.Entry<Integer, Integer> entry = getRandomBuffEntry(roleId, sChessBoxBuffAwardCfg.random_map);
/* 1002 */       if (entry == null)
/*      */       {
/* 1004 */         onSignInFail(roleId, 13);
/*      */         
/* 1006 */         return false;
/*      */       }
/* 1008 */       xSign.setCurrent_precious_box_buff_id(((Integer)entry.getValue()).intValue());
/* 1009 */       if (xSign.getBox_sign_award_state() != 1)
/*      */       {
/* 1011 */         xSign.setBox_sign_award_state(3);
/*      */       }
/*      */     }
/*      */     
/* 1015 */     xSign.setCurrent_precious_cell_num(realCellNum);
/*      */     
/* 1017 */     return true;
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
/*      */ 
/*      */ 
/*      */   private static boolean forceArriveBox(Sign xSign, String userId, long roleId, long clientYuanBao)
/*      */   {
/* 1036 */     int xCurrentCellNum = xSign.getCurrent_precious_cell_num();
/*      */     
/* 1038 */     TreeMap<Integer, SChessBoxAwardCfg> sChessBoxAwardCfgMap = (TreeMap)SChessBoxAwardCfg.getAll();
/* 1039 */     Map.Entry<Integer, SChessBoxAwardCfg> arriveBoxEntry = null;
/* 1040 */     if (xCurrentCellNum == SSignPreciousConsts.getInstance().cell_total_num)
/*      */     {
/* 1042 */       arriveBoxEntry = sChessBoxAwardCfgMap.firstEntry();
/*      */ 
/*      */     }
/*      */     else
/*      */     {
/* 1047 */       arriveBoxEntry = sChessBoxAwardCfgMap.higherEntry(Integer.valueOf(xCurrentCellNum));
/*      */     }
/* 1049 */     if (arriveBoxEntry == null)
/*      */     {
/* 1051 */       Map<String, Object> extraMap = new HashMap();
/* 1052 */       extraMap.put("current_cell_num", Integer.valueOf(xCurrentCellNum));
/*      */       
/* 1054 */       onSignInFail(roleId, 22, extraMap);
/* 1055 */       return false;
/*      */     }
/*      */     
/* 1058 */     int nextCellNum = ((Integer)arriveBoxEntry.getKey()).intValue();
/* 1059 */     if (nextCellNum - xCurrentCellNum > 6)
/*      */     {
/* 1061 */       Map<String, Object> extraMap = new HashMap();
/* 1062 */       extraMap.put("current_cell_num", Integer.valueOf(xCurrentCellNum));
/* 1063 */       extraMap.put("next_cell_num", Integer.valueOf(nextCellNum));
/*      */       
/* 1065 */       onSignInFail(roleId, 21, extraMap);
/* 1066 */       return false;
/*      */     }
/*      */     
/* 1069 */     SChessBoxAwardCfg sChessBoxAwardCfg = (SChessBoxAwardCfg)arriveBoxEntry.getValue();
/*      */     
/* 1071 */     long currentYuanBao = QingfuInterface.getBalance(userId, true);
/* 1072 */     if (currentYuanBao != clientYuanBao)
/*      */     {
/* 1074 */       Map<String, Object> extraMap = new HashMap();
/* 1075 */       extraMap.put("client_yuan_bao", Long.valueOf(clientYuanBao));
/* 1076 */       extraMap.put("current_yuan_bao", Long.valueOf(currentYuanBao));
/*      */       
/* 1078 */       onSignInFail(roleId, 11, extraMap);
/* 1079 */       return false;
/*      */     }
/*      */     
/* 1082 */     int costYuanBao = sChessBoxAwardCfg.arrive_cost_yuan_bao;
/* 1083 */     if (currentYuanBao < costYuanBao)
/*      */     {
/* 1085 */       Map<String, Object> extraMap = new HashMap();
/* 1086 */       extraMap.put("cell_num", Integer.valueOf(xCurrentCellNum));
/* 1087 */       extraMap.put("current_yuan_bao", Long.valueOf(currentYuanBao));
/* 1088 */       extraMap.put("need_yuan_bao", Integer.valueOf(costYuanBao));
/*      */       
/* 1090 */       onSignInFail(roleId, 18, extraMap);
/* 1091 */       return false;
/*      */     }
/*      */     
/* 1094 */     SChessBoxBuffAwardCfg sChessBoxBuffAwardCfg = SChessBoxBuffAwardCfg.get(sChessBoxAwardCfg.cell_award_type);
/*      */     
/* 1096 */     Map.Entry<Integer, Integer> randomBuffEntry = getRandomBuffEntry(roleId, sChessBoxBuffAwardCfg.random_map);
/* 1097 */     if (randomBuffEntry == null)
/*      */     {
/* 1099 */       Map<String, Object> extraMap = new HashMap();
/* 1100 */       extraMap.put("cell_num", Integer.valueOf(xCurrentCellNum));
/* 1101 */       extraMap.put("box_award_type", Integer.valueOf(sChessBoxAwardCfg.cell_award_type));
/*      */       
/* 1103 */       onSignInFail(roleId, 13, extraMap);
/* 1104 */       return false;
/*      */     }
/*      */     
/* 1107 */     CostResult costResult = QingfuInterface.costYuanbao(userId, roleId, costYuanBao, mzm.gsp.qingfu.main.CostType.COST_BIND_FIRST_SIGN_PRECIOUS_FORCE_ARRIVE, new TLogArg(LogReason.SIGN_PRECIOUS_FAST_ARRIVE_COST_YUAN_BAO));
/*      */     
/*      */ 
/* 1110 */     if (costResult != CostResult.Success)
/*      */     {
/* 1112 */       Map<String, Object> extraMap = new HashMap();
/* 1113 */       extraMap.put("code", Integer.valueOf(costResult.code));
/* 1114 */       extraMap.put("des", costResult.desc);
/*      */       
/* 1116 */       onSignInFail(roleId, 19, extraMap);
/* 1117 */       return false;
/*      */     }
/*      */     
/* 1120 */     xSign.setCurrent_precious_cell_num(nextCellNum);
/* 1121 */     xSign.setCurrent_precious_box_buff_id(((Integer)randomBuffEntry.getValue()).intValue());
/*      */     
/* 1123 */     return true;
/*      */   }
/*      */   
/*      */   private static void onSignInFail(long roleId, int ret)
/*      */   {
/* 1128 */     onSignInFail(roleId, ret, null);
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
/*      */   private static void onSignInFail(long roleId, int ret, Map<String, ?> extraMap)
/*      */   {
/* 1142 */     StringBuilder sbLog = new StringBuilder();
/* 1143 */     sbLog.append("[sign]SignAwardManager.processImp@sign in failed");
/* 1144 */     sbLog.append("|ret=").append(ret);
/* 1145 */     sbLog.append("|role_id=").append(roleId);
/* 1146 */     if ((extraMap != null) && (!extraMap.isEmpty()))
/*      */     {
/* 1148 */       for (Map.Entry<String, ?> entry : extraMap.entrySet())
/*      */       {
/* 1150 */         sbLog.append('|').append((String)entry.getKey()).append('=').append(entry.getValue());
/*      */       }
/*      */     }
/* 1153 */     GameServer.logger().error(sbLog.toString());
/*      */     
/* 1155 */     SSignAwardErrorInfo sSignAwardErrorInfo = new SSignAwardErrorInfo();
/* 1156 */     sSignAwardErrorInfo.rescode = ret;
/*      */     
/* 1158 */     OnlineManager.getInstance().sendAtOnce(roleId, sSignAwardErrorInfo);
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
/*      */   private static int getRandomDice(int currentCellNum)
/*      */   {
/* 1171 */     TreeMap<Integer, SChessBoxAwardCfg> boxAwardTreeMap = (TreeMap)SChessBoxAwardCfg.getAll();
/* 1172 */     Map.Entry<Integer, SChessBoxAwardCfg> nearBoxEntry = null;
/* 1173 */     if (currentCellNum == SSignPreciousConsts.getInstance().cell_total_num)
/*      */     {
/* 1175 */       nearBoxEntry = boxAwardTreeMap.firstEntry();
/*      */ 
/*      */     }
/*      */     else
/*      */     {
/* 1180 */       nearBoxEntry = boxAwardTreeMap.higherEntry(Integer.valueOf(currentCellNum));
/*      */     }
/* 1182 */     if (nearBoxEntry == null)
/*      */     {
/* 1184 */       return Xdb.random().nextInt(6) + 1;
/*      */     }
/*      */     
/* 1187 */     int nextBoxDistance = ((Integer)nearBoxEntry.getKey()).intValue() - currentCellNum;
/* 1188 */     int randomBoxResult = Xdb.random().nextInt(CommonUtils.WAN_PERCENT);
/* 1189 */     if (nextBoxDistance <= 6)
/*      */     {
/* 1191 */       if (randomBoxResult < ((SChessBoxAwardCfg)nearBoxEntry.getValue()).arrive_rate)
/*      */       {
/* 1193 */         return nextBoxDistance;
/*      */       }
/*      */     }
/*      */     
/* 1197 */     List<Integer> randomDiceList = new ArrayList();
/* 1198 */     for (int index = 1; index <= 6; index++)
/*      */     {
/* 1200 */       if (nextBoxDistance != index)
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/* 1205 */         randomDiceList.add(Integer.valueOf(index));
/*      */       }
/*      */     }
/* 1208 */     randomBoxResult = Xdb.random().nextInt(randomDiceList.size());
/*      */     
/* 1210 */     return ((Integer)randomDiceList.get(randomBoxResult)).intValue();
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
/*      */   static Map.Entry<Integer, Integer> getRandomBuffEntry(long roleId, TreeMap<Integer, Integer> randomBuffMap)
/*      */   {
/* 1224 */     List<Integer> optionBuffIdList = new ArrayList(randomBuffMap.values());
/* 1225 */     List<Integer> aleardyInstalledBuffIdList = mzm.gsp.buff.main.BuffInterface.contains(roleId, optionBuffIdList, true);
/* 1226 */     Map.Entry<Integer, Integer> randomBuffEntry = null;
/* 1227 */     TreeMap<Integer, Integer> copyBuffMap = new TreeMap();
/* 1228 */     int baseRate = 0;
/* 1229 */     int previousRate = 0;
/*      */     
/* 1231 */     for (Map.Entry<Integer, Integer> entry : randomBuffMap.entrySet())
/*      */     {
/* 1233 */       int tempBaseRate = ((Integer)entry.getKey()).intValue();
/* 1234 */       int buffId = ((Integer)entry.getValue()).intValue();
/* 1235 */       if (aleardyInstalledBuffIdList.contains(Integer.valueOf(buffId)))
/*      */       {
/* 1237 */         previousRate = tempBaseRate;
/*      */       }
/*      */       else
/*      */       {
/* 1241 */         baseRate += tempBaseRate - previousRate;
/* 1242 */         copyBuffMap.put(Integer.valueOf(baseRate), Integer.valueOf(buffId));
/* 1243 */         previousRate = tempBaseRate;
/*      */       }
/*      */     }
/* 1246 */     Integer randomSum = (Integer)copyBuffMap.lastKey();
/* 1247 */     if (randomSum != null)
/*      */     {
/* 1249 */       int randomResult = Xdb.random().nextInt(randomSum.intValue());
/* 1250 */       randomBuffEntry = copyBuffMap.ceilingEntry(Integer.valueOf(randomResult));
/*      */     }
/*      */     
/* 1253 */     if (randomBuffEntry == null)
/*      */     {
/* 1255 */       Map<String, Object> extraMap = new HashMap();
/* 1256 */       extraMap.put("aleardy_buff_id_list", aleardyInstalledBuffIdList.toString());
/* 1257 */       extraMap.put("option_buff_list", optionBuffIdList.toString());
/* 1258 */       onSignInFail(roleId, 13, extraMap);
/*      */     }
/*      */     
/* 1261 */     return randomBuffEntry;
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\signaward\main\SignAwardManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
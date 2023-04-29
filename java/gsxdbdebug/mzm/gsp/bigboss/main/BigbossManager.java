/*     */ package mzm.gsp.bigboss.main;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import java.util.TreeMap;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.bigboss.BigbossRankData;
/*     */ import mzm.gsp.bigboss.RemoveRoleBigBossRemoteRankInfoContext;
/*     */ import mzm.gsp.bigboss.ReportRoleBigBossRemoteRankInfoContext;
/*     */ import mzm.gsp.bigboss.SBigbossChartRes;
/*     */ import mzm.gsp.bigboss.SErrorInfo;
/*     */ import mzm.gsp.bigboss.SSynBigbossData;
/*     */ import mzm.gsp.bigboss.SSynBigbossDataChanged;
/*     */ import mzm.gsp.bigboss.confbean.SBigboss;
/*     */ import mzm.gsp.bigboss.confbean.SBigbossAward;
/*     */ import mzm.gsp.bigboss.confbean.SBigbossCfgConsts;
/*     */ import mzm.gsp.bigboss.confbean.SOcp2ChartType;
/*     */ import mzm.gsp.crossserver.main.CrossServerInterface;
/*     */ import mzm.gsp.fight.main.FightInterface;
/*     */ import mzm.gsp.idip.main.IdipManager;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.CommonUtils;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.BigBoss;
/*     */ import xbean.BigBossActivity;
/*     */ import xtable.Bigbossactivity;
/*     */ import xtable.Role2bigboss;
/*     */ 
/*     */ public class BigbossManager
/*     */ {
/*  47 */   static final Logger logger = Logger.getLogger("bigboss");
/*  48 */   static int GRC_MAX_TRY_TIMES = 3;
/*  49 */   static int GET_REMOTE_RANK_MIN_DELAY_IN_SECOND = 10;
/*  50 */   static int GET_REMOTE_RANK_MAX_DELAY_IN_SECOND = 30;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void postInit() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getMonsterId(int sortid)
/*     */   {
/*  65 */     SBigboss bigboss = SBigboss.get(sortid);
/*  66 */     if (bigboss == null)
/*     */     {
/*  68 */       return -1;
/*     */     }
/*  70 */     return FightInterface.getFightFirstMonsterid(bigboss.fightId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getFightId(int sortid)
/*     */   {
/*  82 */     SBigboss bigboss = SBigboss.get(sortid);
/*  83 */     if (bigboss == null)
/*     */     {
/*  85 */       return -1;
/*     */     }
/*  87 */     return bigboss.fightId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getNextsortId(int curSortid)
/*     */   {
/*  99 */     Map<Integer, SBigboss> map = SBigboss.getAll();
/* 100 */     if ((map instanceof TreeMap))
/*     */     {
/* 102 */       TreeMap<Integer, SBigboss> treeMap = (TreeMap)map;
/* 103 */       Integer next = (Integer)treeMap.higherKey(Integer.valueOf(curSortid));
/* 104 */       if (next == null)
/*     */       {
/* 106 */         next = (Integer)treeMap.firstKey();
/*     */       }
/* 108 */       return next.intValue();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 113 */     List<Integer> list = new ArrayList();
/* 114 */     list.addAll(map.keySet());
/* 115 */     Collections.sort(list);
/*     */     
/* 117 */     int index = list.indexOf(Integer.valueOf(curSortid));
/* 118 */     if ((index == -1) || (index == list.size() - 1))
/*     */     {
/* 120 */       return ((Integer)list.get(0)).intValue();
/*     */     }
/*     */     
/*     */ 
/* 124 */     return ((Integer)list.get(index + 1)).intValue();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getRewardIdByRank(int rank)
/*     */   {
/* 132 */     for (SBigbossAward bigbossAward : SBigbossAward.getAll().values())
/*     */     {
/* 134 */       if ((bigbossAward.minRank <= rank) && (rank <= bigbossAward.maxRank))
/*     */       {
/* 136 */         return bigbossAward.rewardid;
/*     */       }
/*     */     }
/* 139 */     return -1;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static BigBoss getBigboss(long roleid, boolean islock)
/*     */   {
/* 151 */     BigBoss bigBoss = null;
/* 152 */     if (islock)
/*     */     {
/* 154 */       bigBoss = Role2bigboss.get(Long.valueOf(roleid));
/*     */     }
/*     */     else
/*     */     {
/* 158 */       bigBoss = Role2bigboss.select(Long.valueOf(roleid));
/*     */     }
/* 160 */     return bigBoss;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean decChallenagecount(BigBoss xBigBoss, int count)
/*     */   {
/* 172 */     if (count <= 0)
/*     */     {
/* 174 */       return false;
/*     */     }
/*     */     
/* 177 */     if (xBigBoss == null)
/*     */     {
/* 179 */       return false;
/*     */     }
/*     */     
/* 182 */     if (xBigBoss.getRestbuycount() + xBigBoss.getChallengecount() < count)
/*     */     {
/* 184 */       return false;
/*     */     }
/* 186 */     if (xBigBoss.getChallengecount() >= count)
/*     */     {
/* 188 */       xBigBoss.setChallengecount(xBigBoss.getChallengecount() - count);
/*     */     }
/*     */     else
/*     */     {
/* 192 */       xBigBoss.setChallengecount(0);
/* 193 */       xBigBoss.setRestbuycount(xBigBoss.getRestbuycount() - (count - xBigBoss.getChallengecount()));
/*     */     }
/* 195 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getTotalChallengecount(BigBoss xBigBoss)
/*     */   {
/* 207 */     if (xBigBoss == null)
/*     */     {
/* 209 */       return 0;
/*     */     }
/*     */     
/* 212 */     return xBigBoss.getRestbuycount() + xBigBoss.getChallengecount();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getDamagePoint(long roleid, int ocp)
/*     */   {
/* 224 */     BigBoss bigBoss = getBigboss(roleid, false);
/* 225 */     if (bigBoss == null)
/*     */     {
/* 227 */       return 0;
/*     */     }
/*     */     
/* 230 */     Integer point = (Integer)bigBoss.getOcp2damagepoint().get(Integer.valueOf(ocp));
/* 231 */     if (point == null)
/*     */     {
/* 233 */       return 0;
/*     */     }
/*     */     
/*     */ 
/* 237 */     return point.intValue();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getDamagePoint(BigBoss xBigBoss, int ocp)
/*     */   {
/* 249 */     if (xBigBoss == null)
/*     */     {
/* 251 */       return 0;
/*     */     }
/*     */     
/* 254 */     Integer point = (Integer)xBigBoss.getOcp2damagepoint().get(Integer.valueOf(ocp));
/* 255 */     if (point == null)
/*     */     {
/* 257 */       return 0;
/*     */     }
/*     */     
/*     */ 
/* 261 */     return point.intValue();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static long getStarttime(long roleid)
/*     */   {
/* 273 */     Long startTime = Role2bigboss.selectStarttime(Long.valueOf(roleid));
/* 274 */     if (startTime == null)
/*     */     {
/* 276 */       return 0L;
/*     */     }
/*     */     
/* 279 */     return startTime.longValue();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean setDamagePoint(long roleid, int ocp, int point)
/*     */   {
/* 291 */     if (point < 0)
/*     */     {
/* 293 */       return false;
/*     */     }
/* 295 */     BigBoss bigBoss = getBigboss(roleid, true);
/* 296 */     if (bigBoss == null)
/*     */     {
/* 298 */       return false;
/*     */     }
/* 300 */     bigBoss.setDamagepoint(0);
/* 301 */     bigBoss.getOcp2damagepoint().clear();
/* 302 */     bigBoss.getOcp2damagepoint().put(Integer.valueOf(ocp), Integer.valueOf(point));
/* 303 */     return true;
/*     */   }
/*     */   
/*     */   static void sendErrorInfo(long roleid, int rescode)
/*     */   {
/* 308 */     SErrorInfo errorInfo = new SErrorInfo();
/* 309 */     errorInfo.errorcode = rescode;
/* 310 */     OnlineManager.getInstance().sendAtOnce(roleid, errorInfo);
/*     */   }
/*     */   
/*     */   static long getActivityStarttime()
/*     */   {
/* 315 */     return ActivityInterface.getActivityStartTime(SBigbossCfgConsts.getInstance().ACTIVITYID);
/*     */   }
/*     */   
/*     */   static long getActivityEndTime()
/*     */   {
/* 320 */     return ActivityInterface.getActivityEndTime(SBigbossCfgConsts.getInstance().ACTIVITYID);
/*     */   }
/*     */   
/*     */   static long getNextActivityStartTime()
/*     */   {
/* 325 */     return ActivityInterface.getNextActivityStartTime(SBigbossCfgConsts.getInstance().ACTIVITYID);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void synBigbossActivityData(long roleid, int ocp, BigBoss xBigBoss, long endtime, int monstersortid, long starttime)
/*     */   {
/* 336 */     int targetOcp = ocp;
/* 337 */     SSynBigbossData sSynBigbossData = new SSynBigbossData();
/*     */     
/* 339 */     sSynBigbossData.challengecount = (xBigBoss.getChallengecount() + xBigBoss.getRestbuycount());
/* 340 */     if (xBigBoss.getOcp2damagepoint().isEmpty())
/*     */     {
/* 342 */       sSynBigbossData.damagepoint = 0;
/* 343 */       sSynBigbossData.rank = 0;
/*     */     }
/*     */     else
/*     */     {
/* 347 */       Map.Entry<Integer, Integer> entry = (Map.Entry)xBigBoss.getOcp2damagepoint().entrySet().iterator().next();
/* 348 */       targetOcp = ((Integer)entry.getKey()).intValue();
/* 349 */       sSynBigbossData.damagepoint = ((Integer)entry.getValue()).intValue();
/* 350 */       sSynBigbossData.rank = (BigbossChartManager.getInstance().getRank(targetOcp, roleid) + 1);
/*     */     }
/* 352 */     sSynBigbossData.ocp = targetOcp;
/* 353 */     sSynBigbossData.monsterid = getMonsterId(monstersortid);
/* 354 */     sSynBigbossData.nextmonsterid = getMonsterId(getNextsortId(monstersortid));
/* 355 */     sSynBigbossData.totalbuycount = xBigBoss.getBuycount();
/* 356 */     sSynBigbossData.starttime = (starttime / 1000L);
/* 357 */     sSynBigbossData.endtime = (endtime / 1000L);
/* 358 */     sSynBigbossData.nextstarttime = (starttime / 1000L + TimeUnit.DAYS.toSeconds(7L));
/*     */     
/* 360 */     OnlineManager.getInstance().send(roleid, sSynBigbossData);
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
/*     */   static void synBigbossActivityDataChanged(long roleid, int delta, int ocp, BigBoss xBigBoss, int roleRank)
/*     */   {
/* 375 */     if (xBigBoss == null)
/*     */     {
/* 377 */       return;
/*     */     }
/* 379 */     SSynBigbossDataChanged sSynBigbossData = new SSynBigbossDataChanged();
/* 380 */     sSynBigbossData.ocp = ocp;
/* 381 */     sSynBigbossData.delta = delta;
/* 382 */     sSynBigbossData.challengecount = (xBigBoss.getChallengecount() + xBigBoss.getRestbuycount());
/* 383 */     sSynBigbossData.damagepoint = getDamagePoint(xBigBoss, ocp);
/* 384 */     sSynBigbossData.rank = (roleRank + 1);
/* 385 */     OnlineManager.getInstance().send(roleid, sSynBigbossData);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void onActivityEnd()
/*     */   {
/* 393 */     new Session(GET_REMOTE_RANK_MIN_DELAY_IN_SECOND, 0L)
/*     */     {
/*     */ 
/*     */       protected void onTimeOut()
/*     */       {
/* 398 */         BigbossChartManager.getInstance().offerAwardRole();
/*     */       }
/*     */     };
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getBigbossActivityMonsterSordId()
/*     */   {
/* 410 */     BigBossActivity bigBossActivity = Bigbossactivity.select(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 411 */     if (bigBossActivity == null)
/*     */     {
/* 413 */       return -1;
/*     */     }
/* 415 */     return bigBossActivity.getMonsterid();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void onActivityStart(boolean startagain)
/*     */   {
/* 423 */     new BigbossActivityStart(startagain).execute();
/*     */   }
/*     */   
/*     */   private static class BigbossActivityStart extends LogicProcedure
/*     */   {
/*     */     private boolean startagain;
/*     */     
/*     */     public BigbossActivityStart(boolean startagain)
/*     */     {
/* 432 */       this.startagain = startagain;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 438 */       long cur = DateTimeUtils.getCurrTimeInMillis();
/* 439 */       if (!this.startagain)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 445 */         BigBossActivity bigBossActivity = Bigbossactivity.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*     */         
/* 447 */         if (bigBossActivity == null)
/*     */         {
/* 449 */           bigBossActivity = xbean.Pod.newBigBossActivity();
/* 450 */           Bigbossactivity.insert(Long.valueOf(GameServerInfoManager.getLocalId()), bigBossActivity);
/* 451 */           int sortid = -1;
/* 452 */           int nextsortid = BigbossManager.getNextsortId(sortid);
/* 453 */           bigBossActivity.setMonsterid(nextsortid);
/* 454 */           bigBossActivity.setStarttime(cur);
/*     */         }
/*     */         else
/*     */         {
/* 458 */           int sortid = bigBossActivity.getMonsterid();
/* 459 */           int nextsortid = BigbossManager.getNextsortId(sortid);
/* 460 */           bigBossActivity.setMonsterid(nextsortid);
/* 461 */           bigBossActivity.setStarttime(cur);
/*     */         }
/* 463 */         BigbossChartManager.getInstance().clear();
/*     */       }
/* 465 */       BigBossFightManager.getInstance().onActivityStart();
/*     */       
/* 467 */       return true;
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
/*     */   static long getBulletinInterval()
/*     */   {
/* 480 */     return TimeUnit.MINUTES.toSeconds(SBigbossCfgConsts.getInstance().BOSS_HP_BULLETIN_INTERVAL);
/*     */   }
/*     */   
/*     */   static int getDecHpRate(int i)
/*     */   {
/* 485 */     if ((i < 0) || (i >= SBigbossCfgConsts.getInstance().hprates.size()))
/*     */     {
/* 487 */       return 0;
/*     */     }
/* 489 */     return ((Integer)SBigbossCfgConsts.getInstance().hprates.get(i)).intValue();
/*     */   }
/*     */   
/*     */   static int getBulletinCount()
/*     */   {
/* 494 */     return SBigbossCfgConsts.getInstance().hprates.size();
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
/*     */   static void synRankDatas(int ocp, long roleid, int startpos, int num)
/*     */   {
/* 507 */     SBigbossChartRes res = new SBigbossChartRes();
/* 508 */     res.startpos = startpos;
/* 509 */     res.num = num;
/* 510 */     res.ocp = ocp;
/* 511 */     res.point = getDamagePoint(roleid, ocp);
/* 512 */     res.myrank = (BigbossChartManager.getInstance().getRank(ocp, roleid) + 1);
/* 513 */     res.ranklist.addAll(getRankDatasFromstartpos(ocp, startpos, num));
/* 514 */     OnlineManager.getInstance().send(roleid, res);
/*     */   }
/*     */   
/*     */   private static List<BigbossRankData> getRankDatasFromstartpos(int ocp, int startpos, int num)
/*     */   {
/* 519 */     List<BigbossRankData> ranklist = new ArrayList();
/* 520 */     List<RoleBigBossChart> list = BigbossChartManager.getInstance().getRankDatasFromstartpos(ocp, startpos, num);
/* 521 */     if (list == null)
/*     */     {
/* 523 */       return ranklist;
/*     */     }
/*     */     
/* 526 */     int i = startpos;
/* 527 */     for (RoleBigBossChart roleBigbossChart : list)
/*     */     {
/* 529 */       BigbossRankData rankdata = new BigbossRankData();
/* 530 */       fillBigbossRankData(rankdata, roleBigbossChart, ocp, i);
/* 531 */       ranklist.add(rankdata);
/* 532 */       i++;
/*     */     }
/* 534 */     return ranklist;
/*     */   }
/*     */   
/*     */   private static void fillBigbossRankData(BigbossRankData rankdata, RoleBigBossChart roleBigbossChart, int ocp, int rank)
/*     */   {
/* 539 */     rankdata.damagepoint = roleBigbossChart.getDamagePoint();
/* 540 */     rankdata.roleid = roleBigbossChart.getKey().longValue();
/* 541 */     rankdata.step = 0;
/* 542 */     rankdata.name = RoleInterface.getName(roleBigbossChart.getKey().longValue());
/* 543 */     rankdata.occupationid = ocp;
/* 544 */     rankdata.rank = rank;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isBigBossSwitchOpenForRole(long roleid)
/*     */   {
/* 555 */     if (!OpenInterface.getOpenStatus(14))
/*     */     {
/* 557 */       return false;
/*     */     }
/* 559 */     if (OpenInterface.isBanPlay(roleid, 14))
/*     */     {
/* 561 */       OpenInterface.sendBanPlayMsg(roleid, 14);
/* 562 */       return false;
/*     */     }
/* 564 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isBigBossRemoteChartSwitchOpenForRole(long roleid)
/*     */   {
/* 576 */     if (!OpenInterface.getOpenStatus(563))
/*     */     {
/* 578 */       return false;
/*     */     }
/* 580 */     if (OpenInterface.isBanPlay(roleid, 563))
/*     */     {
/* 582 */       OpenInterface.sendBanPlayMsg(roleid, 563);
/* 583 */       return false;
/*     */     }
/* 585 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isRoleStateCanJoinBigbossActivity(long roleid)
/*     */   {
/* 596 */     return RoleStatusInterface.checkCanSetStatus(roleid, 26, true);
/*     */   }
/*     */   
/*     */   static void clearRoleOtherOcpPoint(long roleid, BigBoss xBigBoss, int roleOcp, long startTimestamp)
/*     */   {
/* 601 */     StringBuffer sb = new StringBuffer();
/* 602 */     for (Map.Entry<Integer, Integer> entry : xBigBoss.getOcp2damagepoint().entrySet())
/*     */     {
/* 604 */       sb.append(entry.getKey()).append("=").append(entry.getValue()).append(",");
/* 605 */       if ((startTimestamp > 0L) && (((Integer)entry.getKey()).intValue() != roleOcp))
/*     */       {
/* 607 */         removeRoleBigBossRankInfo(CommonUtils.getLong(((Integer)entry.getKey()).intValue(), (int)(startTimestamp / 1000L)), roleid, 1);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 612 */     BigbossChartManager.getInstance().removeRoleFromAllRank(roleid);
/*     */     
/* 614 */     String logstr = String.format("[bigboss]clearRoleOtherOcpPoint.processImp@clear role from all rank|roleid=%d|ocp=%d|%s", new Object[] { Long.valueOf(roleid), Integer.valueOf(roleOcp), sb.toString() });
/*     */     
/*     */ 
/* 617 */     logger.info(logstr);
/*     */     
/* 619 */     xBigBoss.getOcp2damagepoint().clear();
/*     */   }
/*     */   
/*     */   static boolean isBanRank(long roleid)
/*     */   {
/* 624 */     for (SOcp2ChartType ocp2ChartType : SOcp2ChartType.getAll().values())
/*     */     {
/* 626 */       if (IdipManager.isBanRank(roleid, ocp2ChartType.charttype))
/*     */       {
/* 628 */         return true;
/*     */       }
/*     */     }
/* 631 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   static void reportRoleBigBossRankInfo(long rankid, long roleid, String name, int occupation, int damagePoint, int count)
/*     */   {
/* 637 */     if ((count <= 0) || (count >= 127) || (count > GRC_MAX_TRY_TIMES))
/*     */     {
/* 639 */       return;
/*     */     }
/* 641 */     if (damagePoint <= 0)
/*     */     {
/* 643 */       removeRoleBigBossRankInfo(rankid, roleid, count);
/* 644 */       return;
/*     */     }
/* 646 */     ReportRoleBigBossRemoteRankInfoContext context = new ReportRoleBigBossRemoteRankInfoContext();
/* 647 */     context.count = ((byte)count);
/* 648 */     OctetsStream os = new OctetsStream();
/* 649 */     context.marshal(os);
/* 650 */     boolean ret = CrossServerInterface.reportRoleBigBossRankInfo(rankid, roleid, name, occupation, damagePoint, os);
/* 651 */     if (!ret)
/*     */     {
/* 653 */       GameServer.logger().error(String.format("[bigboss]BigbossManager.reportRoleBigBossRankInfo@report role big boss rank info fail|count=%d|occupation=%d|start_timestamp=%s|roleid=%d|damage_point=%d", new Object[] { Byte.valueOf(context.count), Integer.valueOf(CommonUtils.getLongHigh(rankid)), DateTimeUtils.formatTimestamp(CommonUtils.getLongLow(rankid) * 1000L), Long.valueOf(roleid), Integer.valueOf(damagePoint) }));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void removeRoleBigBossRankInfo(long rankid, long roleid, int count)
/*     */   {
/* 663 */     if ((count <= 0) || (count >= 127) || (count > GRC_MAX_TRY_TIMES))
/*     */     {
/* 665 */       return;
/*     */     }
/* 667 */     RemoveRoleBigBossRemoteRankInfoContext context = new RemoveRoleBigBossRemoteRankInfoContext();
/* 668 */     context.count = ((byte)count);
/* 669 */     OctetsStream os = new OctetsStream();
/* 670 */     context.marshal(os);
/* 671 */     boolean ret = CrossServerInterface.removeRoleBigBossRankInfo(rankid, roleid, os);
/* 672 */     if (!ret)
/*     */     {
/* 674 */       GameServer.logger().error(String.format("[bigboss]BigbossManager.removeRoleBigBossRankInfo@remove role big boss rank info fail|count=%d|occupation=%d|start_timestamp=%s|roleid=%d", new Object[] { Byte.valueOf(context.count), Integer.valueOf(CommonUtils.getLongHigh(rankid)), DateTimeUtils.formatTimestamp(CommonUtils.getLongLow(rankid) * 1000L), Long.valueOf(roleid) }));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void addRemoteRankAwardTLog(long roleid, String startTimestamp, int occupation, int rank, boolean awarded)
/*     */   {
/* 685 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 686 */     String userid = RoleInterface.getUserId(roleid);
/* 687 */     int rolelevel = RoleInterface.getLevel(roleid);
/* 688 */     String logStr = String.format("%s|%s|%d|%d|%s|%d|%d|%d", new Object[] { vGameIP, userid, Long.valueOf(roleid), Integer.valueOf(rolelevel), startTimestamp, Integer.valueOf(occupation), Integer.valueOf(rank), Integer.valueOf(awarded ? 1 : 0) });
/*     */     
/* 690 */     TLogManager.getInstance().addLog(roleid, "BigBossRemoteRankAwardForServer", logStr);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bigboss\main\BigbossManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
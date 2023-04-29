/*      */ package mzm.gsp.jingji.main;
/*      */ 
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collections;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import java.util.Set;
/*      */ import java.util.TreeMap;
/*      */ import java.util.concurrent.TimeUnit;
/*      */ import mzm.gsp.GameServerInfoManager;
/*      */ import mzm.gsp.activity.confbean.JingjiActivityCfgConsts;
/*      */ import mzm.gsp.activity.confbean.SJingjiBadageCfg;
/*      */ import mzm.gsp.activity.confbean.SJingjiPhaseCfg;
/*      */ import mzm.gsp.activity.confbean.SJingjiPointRankAward;
/*      */ import mzm.gsp.activity.confbean.SJingjiWinPointCfg;
/*      */ import mzm.gsp.award.main.AwardInterface;
/*      */ import mzm.gsp.award.main.AwardModel;
/*      */ import mzm.gsp.award.main.AwardReason;
/*      */ import mzm.gsp.item.main.access.ItemAccessManager;
/*      */ import mzm.gsp.jingji.OpponentInfo;
/*      */ import mzm.gsp.jingji.RoleJingjiRankData;
/*      */ import mzm.gsp.jingji.SBuyChallengeCountRes;
/*      */ import mzm.gsp.jingji.SErrorInfo;
/*      */ import mzm.gsp.jingji.SGetRoleJingjiRankRes;
/*      */ import mzm.gsp.jingji.SJIngjiNoAwardRes;
/*      */ import mzm.gsp.jingji.SResOpponentInfo;
/*      */ import mzm.gsp.jingji.SSynJingjiData;
/*      */ import mzm.gsp.jingji.SSynJingjiSeasonEndtime;
/*      */ import mzm.gsp.jingji.SsynJingjiDataChanged;
/*      */ import mzm.gsp.jingji.SsynRewardChanged;
/*      */ import mzm.gsp.mall.main.MallInterface;
/*      */ import mzm.gsp.online.main.OnlineManager;
/*      */ import mzm.gsp.open.main.OpenInterface;
/*      */ import mzm.gsp.role.main.Role;
/*      */ import mzm.gsp.role.main.RoleInterface;
/*      */ import mzm.gsp.status.main.RoleStatusInterface;
/*      */ import mzm.gsp.storageexp.main.StorageExpInterface;
/*      */ import mzm.gsp.tlog.LogReason;
/*      */ import mzm.gsp.tlog.TLogManager;
/*      */ import mzm.gsp.util.CommonUtils;
/*      */ import mzm.gsp.util.DateTimeUtils;
/*      */ import mzm.gsp.util.LogicProcedure;
/*      */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*      */ import mzm.gsp.util.Pair;
/*      */ import org.apache.log4j.Logger;
/*      */ import xbean.JingJiDailyRank;
/*      */ import xbean.JingjiPvp;
/*      */ import xbean.Opponent;
/*      */ import xbean.Pod;
/*      */ import xtable.Jingjidailytrankbackup;
/*      */ import xtable.Role2jingjipvp;
/*      */ import xtable.Role2opponent;
/*      */ 
/*      */ public class JingjiManager
/*      */ {
/*   58 */   static final Logger logger = Logger.getLogger("Jingji");
/*      */   
/*      */   private static final double WAN = 10000.0D;
/*      */   static final long ROBOT_ROLE_ID = 0L;
/*      */   
/*      */   static void init()
/*      */   {
/*   65 */     registerRewardItemAccess();
/*   66 */     new PJingjiInit(null).call();
/*      */   }
/*      */   
/*      */   private static class PJingjiInit
/*      */     extends LogicProcedure
/*      */   {
/*      */     protected boolean processImp()
/*      */       throws Exception
/*      */     {
/*   75 */       long key = GameServerInfoManager.getLocalId();
/*   76 */       JingJiDailyRank xJingJiDailyRank = Jingjidailytrankbackup.get(Long.valueOf(key));
/*   77 */       if (xJingJiDailyRank == null)
/*      */       {
/*   79 */         xJingJiDailyRank = Pod.newJingJiDailyRank();
/*   80 */         xJingJiDailyRank.setTime(DateTimeUtils.getCurrTimeInMillis());
/*   81 */         Jingjidailytrankbackup.insert(Long.valueOf(key), xJingJiDailyRank);
/*      */       }
/*      */       List<Integer> ranks;
/*   84 */       if (!xJingJiDailyRank.getRole_ranks().isEmpty())
/*      */       {
/*      */ 
/*   87 */         ranks = new ArrayList(SJingjiPointRankAward.getAll().keySet());
/*   88 */         Collections.sort(ranks);
/*      */         
/*   90 */         for (Map.Entry<Long, Integer> xEntry : xJingJiDailyRank.getRole_ranks().entrySet())
/*      */         {
/*   92 */           long roleid = ((Long)xEntry.getKey()).longValue();
/*   93 */           int rank = ((Integer)xEntry.getValue()).intValue();
/*      */           
/*   95 */           for (int j = 0; j < ranks.size(); j++)
/*      */           {
/*   97 */             int maxRank = ((Integer)ranks.get(j)).intValue();
/*   98 */             if (rank <= maxRank)
/*      */             {
/*  100 */               int rewardid = SJingjiPointRankAward.get(maxRank).rewardid;
/*  101 */               NoneRealTimeTaskManager.getInstance().addTask(new PRoleDailyAward(roleid, rewardid, rank));
/*      */             }
/*      */           }
/*      */         }
/*      */       }
/*      */       
/*  107 */       return true;
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void registerRewardItemAccess()
/*      */   {
/*  116 */     int activityId = JingjiActivityCfgConsts.getInstance().ACTIVITYID;
/*  117 */     ItemAccessManager.registerActivityReward(activityId, JingjiActivityCfgConsts.getInstance().SUCCESS_REWARDID);
/*  118 */     ItemAccessManager.registerActivityReward(activityId, JingjiActivityCfgConsts.getInstance().FAIL_REWARDID);
/*  119 */     for (SJingjiPhaseCfg jingjiPhaseCfg : SJingjiPhaseCfg.getAll().values())
/*      */     {
/*  121 */       ItemAccessManager.registerActivityFixReward(activityId, jingjiPhaseCfg.firstWinRewardId);
/*  122 */       ItemAccessManager.registerActivityFixReward(activityId, jingjiPhaseCfg.fiveFightRewardId);
/*  123 */       ItemAccessManager.registerActivityFixReward(activityId, jingjiPhaseCfg.seasonRewardId);
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
/*      */   static int getBadageId(int rank)
/*      */   {
/*  136 */     Map<Integer, SJingjiBadageCfg> map = SJingjiBadageCfg.getAll();
/*  137 */     if ((map instanceof TreeMap))
/*      */     {
/*  139 */       TreeMap<Integer, SJingjiBadageCfg> treeMap = (TreeMap)map;
/*  140 */       Map.Entry<Integer, SJingjiBadageCfg> entry = treeMap.ceilingEntry(Integer.valueOf(rank));
/*  141 */       if (entry == null)
/*      */       {
/*  143 */         return -1;
/*      */       }
/*  145 */       return ((SJingjiBadageCfg)entry.getValue()).badage;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*  150 */     List<Integer> ranks = new ArrayList(map.keySet());
/*  151 */     Collections.sort(ranks);
/*  152 */     for (int i = 0; i < ranks.size(); i++)
/*      */     {
/*  154 */       if (rank <= ((Integer)ranks.get(i)).intValue())
/*      */       {
/*  156 */         return SJingjiBadageCfg.get(((Integer)ranks.get(i)).intValue()).badage;
/*      */       }
/*      */     }
/*  159 */     return -1;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getMaxWingPoint()
/*      */   {
/*  171 */     return SJingjiPhaseCfg.get(5).maxWinPoint;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getPhaseByWingPoint(int winPoint)
/*      */   {
/*  182 */     for (Iterator i$ = SJingjiPhaseCfg.getAll().keySet().iterator(); i$.hasNext();) { int phase = ((Integer)i$.next()).intValue();
/*      */       
/*  184 */       SJingjiPhaseCfg jingjiPhaseCfg = SJingjiPhaseCfg.get(phase);
/*  185 */       if ((jingjiPhaseCfg.minWinPoint <= winPoint) && (winPoint <= jingjiPhaseCfg.maxWinPoint))
/*      */       {
/*  187 */         return jingjiPhaseCfg.pahse;
/*      */       }
/*      */     }
/*  190 */     return -1;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static SJingjiPhaseCfg getJingjiPhaseCfgByWingPoint(int winPoint)
/*      */   {
/*  201 */     for (Iterator i$ = SJingjiPhaseCfg.getAll().keySet().iterator(); i$.hasNext();) { int phase = ((Integer)i$.next()).intValue();
/*      */       
/*  203 */       SJingjiPhaseCfg jingjiPhaseCfg = SJingjiPhaseCfg.get(phase);
/*  204 */       if ((jingjiPhaseCfg.minWinPoint <= winPoint) && (winPoint <= jingjiPhaseCfg.maxWinPoint))
/*      */       {
/*  206 */         return jingjiPhaseCfg;
/*      */       }
/*      */     }
/*  209 */     return null;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getKValueByWingPoint(int winPoint)
/*      */   {
/*  220 */     for (SJingjiWinPointCfg jingji : SJingjiWinPointCfg.getAll().values())
/*      */     {
/*  222 */       if ((jingji.minWinPoint <= winPoint) && (winPoint <= jingji.maxWinPoint))
/*      */       {
/*  224 */         return jingji.kValue;
/*      */       }
/*      */     }
/*      */     
/*  228 */     return 0;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static SJingjiPhaseCfg getJingjiPhaseCfgByPhase(int phase)
/*      */   {
/*  239 */     return SJingjiPhaseCfg.get(phase);
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
/*      */   static JingjiPvp getJingjiPvp(long roleid, boolean islock)
/*      */   {
/*  252 */     if (islock)
/*      */     {
/*  254 */       JingjiPvp jingjiData = Role2jingjipvp.get(Long.valueOf(roleid));
/*  255 */       return jingjiData;
/*      */     }
/*      */     
/*      */ 
/*  259 */     JingjiPvp jingjiData = Role2jingjipvp.select(Long.valueOf(roleid));
/*  260 */     return jingjiData;
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
/*      */   static boolean insertJingjiData(long roleid, int chllengecount, int jifen, int winpoint, int lastseasonphase, long seasonstarttime)
/*      */   {
/*  278 */     JingjiPvp jingjiData = Role2jingjipvp.get(Long.valueOf(roleid));
/*  279 */     if (jingjiData == null)
/*      */     {
/*  281 */       jingjiData = Pod.newJingjiPvp();
/*  282 */       Role2jingjipvp.insert(Long.valueOf(roleid), jingjiData);
/*      */     }
/*  284 */     jingjiData.setChallengecount(chllengecount);
/*  285 */     jingjiData.setJifen(jifen);
/*  286 */     jingjiData.setWinpoint(winpoint);
/*  287 */     jingjiData.setLastseasonphase(lastseasonphase);
/*  288 */     jingjiData.setFirstvictoryrewardid(-1);
/*  289 */     jingjiData.setFivefightrewardid(-1);
/*  290 */     jingjiData.setLastseasonendtime(seasonstarttime);
/*  291 */     jingjiData.setInittime(DateTimeUtils.getCurrTimeInMillis());
/*  292 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static long getRoleLastseasonendtime(long roleid)
/*      */   {
/*  303 */     JingjiPvp jingjiData = Role2jingjipvp.select(Long.valueOf(roleid));
/*  304 */     if (jingjiData == null)
/*      */     {
/*  306 */       return 0L;
/*      */     }
/*  308 */     return jingjiData.getLastseasonendtime();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static JingjiPvp getJingjiData(long roleid)
/*      */   {
/*  320 */     JingjiPvp jingjiData = Role2jingjipvp.get(Long.valueOf(roleid));
/*  321 */     return jingjiData;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getChallengeCount(long roleid)
/*      */   {
/*  332 */     JingjiPvp jingjiData = Role2jingjipvp.get(Long.valueOf(roleid));
/*  333 */     if (jingjiData == null)
/*      */     {
/*  335 */       return 0;
/*      */     }
/*  337 */     return jingjiData.getChallengecount();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean setChallengeCount(long roleid, int num)
/*      */   {
/*  349 */     if (num < 0)
/*      */     {
/*  351 */       return false;
/*      */     }
/*  353 */     JingjiPvp jingjiData = Role2jingjipvp.get(Long.valueOf(roleid));
/*  354 */     if (jingjiData == null)
/*      */     {
/*  356 */       return false;
/*      */     }
/*  358 */     jingjiData.setChallengecount(num);
/*  359 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getBuychallengecount(long roleid)
/*      */   {
/*  370 */     JingjiPvp jingjiData = Role2jingjipvp.get(Long.valueOf(roleid));
/*  371 */     if (jingjiData == null)
/*      */     {
/*  373 */       return 0;
/*      */     }
/*  375 */     return jingjiData.getBuychallengecount();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean setBuychallengecount(long roleid, int num)
/*      */   {
/*  387 */     if (num < 0)
/*      */     {
/*  389 */       return false;
/*      */     }
/*  391 */     JingjiPvp jingjiData = Role2jingjipvp.get(Long.valueOf(roleid));
/*  392 */     if (jingjiData == null)
/*      */     {
/*  394 */       return false;
/*      */     }
/*  396 */     jingjiData.setBuychallengecount(num);
/*  397 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean addBuyChallengeCount(long roleid, int addnum)
/*      */   {
/*  409 */     if (addnum <= 0)
/*      */     {
/*  411 */       return false;
/*      */     }
/*  413 */     JingjiPvp jingjiData = Role2jingjipvp.get(Long.valueOf(roleid));
/*  414 */     if (jingjiData == null)
/*      */     {
/*  416 */       return false;
/*      */     }
/*  418 */     jingjiData.setBuychallengecount(addnum + jingjiData.getBuychallengecount());
/*  419 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getBuyCount(long roleid)
/*      */   {
/*  430 */     JingjiPvp jingjiData = Role2jingjipvp.get(Long.valueOf(roleid));
/*  431 */     if (jingjiData == null)
/*      */     {
/*  433 */       return 0;
/*      */     }
/*  435 */     return jingjiData.getBuycount();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean addBuyCount(long roleid, int addnum)
/*      */   {
/*  447 */     if (addnum <= 0)
/*      */     {
/*  449 */       return false;
/*      */     }
/*  451 */     JingjiPvp jingjiData = Role2jingjipvp.get(Long.valueOf(roleid));
/*  452 */     if (jingjiData == null)
/*      */     {
/*  454 */       return false;
/*      */     }
/*  456 */     jingjiData.setBuycount(addnum + jingjiData.getBuycount());
/*  457 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean setBuyCount(long roleid, int addnum)
/*      */   {
/*  469 */     if (addnum < 0)
/*      */     {
/*  471 */       return false;
/*      */     }
/*  473 */     JingjiPvp jingjiData = Role2jingjipvp.get(Long.valueOf(roleid));
/*  474 */     if (jingjiData == null)
/*      */     {
/*  476 */       return false;
/*      */     }
/*  478 */     jingjiData.setBuycount(addnum);
/*  479 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getTotalChallengeCount(long roleid)
/*      */   {
/*  490 */     return getChallengeCount(roleid) + getBuychallengecount(roleid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean decChallengeCount(long roleid, int num)
/*      */   {
/*  502 */     if (getTotalChallengeCount(roleid) < num)
/*      */     {
/*  504 */       return false;
/*      */     }
/*  506 */     int sysChallengecount = getChallengeCount(roleid);
/*  507 */     if (sysChallengecount >= num)
/*      */     {
/*  509 */       setChallengeCount(roleid, sysChallengecount - num);
/*      */ 
/*      */     }
/*      */     else
/*      */     {
/*  514 */       setChallengeCount(roleid, 0);
/*  515 */       setBuychallengecount(roleid, getBuychallengecount(roleid) - (num - sysChallengecount));
/*      */     }
/*      */     
/*  518 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getJifen(long roleid, boolean islock)
/*      */   {
/*  530 */     JingjiPvp jingjiData = null;
/*  531 */     if (islock)
/*      */     {
/*  533 */       jingjiData = Role2jingjipvp.get(Long.valueOf(roleid));
/*      */     }
/*      */     else
/*      */     {
/*  537 */       jingjiData = Role2jingjipvp.select(Long.valueOf(roleid));
/*      */     }
/*      */     
/*  540 */     if (jingjiData == null)
/*      */     {
/*  542 */       return 0;
/*      */     }
/*  544 */     return jingjiData.getJifen();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean setJifen(long roleid, int num)
/*      */   {
/*  556 */     if (num < 0)
/*      */     {
/*  558 */       return false;
/*      */     }
/*  560 */     JingjiPvp jingjiData = Role2jingjipvp.get(Long.valueOf(roleid));
/*  561 */     if (jingjiData == null)
/*      */     {
/*  563 */       return false;
/*      */     }
/*  565 */     jingjiData.setJifen(num);
/*  566 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getFirstvictoryrewardid(long roleid)
/*      */   {
/*  577 */     JingjiPvp jingjiData = Role2jingjipvp.get(Long.valueOf(roleid));
/*  578 */     if (jingjiData == null)
/*      */     {
/*  580 */       return -1;
/*      */     }
/*  582 */     return jingjiData.getFirstvictoryrewardid();
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
/*      */   static boolean setFirstvictoryrewardid(long roleid, int rewardid)
/*      */   {
/*  595 */     JingjiPvp jingjiData = Role2jingjipvp.get(Long.valueOf(roleid));
/*  596 */     if (jingjiData == null)
/*      */     {
/*  598 */       return false;
/*      */     }
/*  600 */     jingjiData.setFirstvictoryrewardid(rewardid);
/*  601 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getFivefightrewardid(long roleid)
/*      */   {
/*  612 */     JingjiPvp jingjiData = Role2jingjipvp.get(Long.valueOf(roleid));
/*  613 */     if (jingjiData == null)
/*      */     {
/*  615 */       return -1;
/*      */     }
/*  617 */     return jingjiData.getFivefightrewardid();
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
/*      */   static boolean setFivefightrewardid(long roleid, int rewardid)
/*      */   {
/*  630 */     JingjiPvp jingjiData = Role2jingjipvp.get(Long.valueOf(roleid));
/*  631 */     if (jingjiData == null)
/*      */     {
/*  633 */       return false;
/*      */     }
/*  635 */     jingjiData.setFivefightrewardid(rewardid);
/*  636 */     return true;
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
/*      */   static int getWinpoint(long roleid, boolean islock)
/*      */   {
/*  649 */     if (islock)
/*      */     {
/*  651 */       JingjiPvp jingjiData = Role2jingjipvp.get(Long.valueOf(roleid));
/*  652 */       if (jingjiData == null)
/*      */       {
/*  654 */         return 0;
/*      */       }
/*  656 */       return jingjiData.getWinpoint();
/*      */     }
/*      */     
/*      */ 
/*  660 */     JingjiPvp jingjiData = Role2jingjipvp.select(Long.valueOf(roleid));
/*  661 */     if (jingjiData == null)
/*      */     {
/*  663 */       return 0;
/*      */     }
/*  665 */     return jingjiData.getWinpoint();
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
/*      */   static int getWinpoint(long roleid, long seasonStartTime)
/*      */   {
/*  680 */     JingjiPvp jingjiData = Role2jingjipvp.select(Long.valueOf(roleid));
/*  681 */     if (jingjiData == null)
/*      */     {
/*  683 */       return 0;
/*      */     }
/*  685 */     if (jingjiData.getLastseasonendtime() < seasonStartTime)
/*      */     {
/*  687 */       return 0;
/*      */     }
/*      */     
/*      */ 
/*  691 */     return jingjiData.getWinpoint();
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
/*      */   static boolean setWinpoint(long roleid, int num)
/*      */   {
/*  705 */     if (num < 0)
/*      */     {
/*  707 */       return false;
/*      */     }
/*  709 */     JingjiPvp jingjiData = Role2jingjipvp.get(Long.valueOf(roleid));
/*  710 */     if (jingjiData == null)
/*      */     {
/*  712 */       return false;
/*      */     }
/*  714 */     jingjiData.setWinpoint(num);
/*  715 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean addWinpoint(long roleid, int addnum)
/*      */   {
/*  727 */     if (addnum <= 0)
/*      */     {
/*  729 */       return false;
/*      */     }
/*  731 */     JingjiPvp jingjiData = Role2jingjipvp.get(Long.valueOf(roleid));
/*  732 */     if (jingjiData == null)
/*      */     {
/*  734 */       return false;
/*      */     }
/*  736 */     jingjiData.setWinpoint(addnum + jingjiData.getWinpoint());
/*  737 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean addJifen(long roleid, int addnum)
/*      */   {
/*  749 */     if (addnum <= 0)
/*      */     {
/*  751 */       return false;
/*      */     }
/*  753 */     JingjiPvp jingjiData = Role2jingjipvp.get(Long.valueOf(roleid));
/*  754 */     if (jingjiData == null)
/*      */     {
/*  756 */       return false;
/*      */     }
/*  758 */     jingjiData.setJifen(addnum + jingjiData.getJifen());
/*  759 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean addVictorycount(long roleid, int addnum)
/*      */   {
/*  771 */     if (addnum <= 0)
/*      */     {
/*  773 */       return false;
/*      */     }
/*  775 */     JingjiPvp jingjiData = Role2jingjipvp.get(Long.valueOf(roleid));
/*  776 */     if (jingjiData == null)
/*      */     {
/*  778 */       return false;
/*      */     }
/*  780 */     jingjiData.setVictorycount(addnum + jingjiData.getVictorycount());
/*  781 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean setVictorycount(long roleid, int num)
/*      */   {
/*  793 */     if (num < 0)
/*      */     {
/*  795 */       return false;
/*      */     }
/*  797 */     JingjiPvp jingjiData = Role2jingjipvp.get(Long.valueOf(roleid));
/*  798 */     if (jingjiData == null)
/*      */     {
/*  800 */       return false;
/*      */     }
/*  802 */     jingjiData.setVictorycount(num);
/*  803 */     return true;
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
/*      */   static int getVictorycount(long roleid)
/*      */   {
/*  816 */     JingjiPvp jingjiData = Role2jingjipvp.get(Long.valueOf(roleid));
/*  817 */     if (jingjiData == null)
/*      */     {
/*  819 */       return 0;
/*      */     }
/*  821 */     return jingjiData.getVictorycount();
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
/*      */   static boolean addFightcount(long roleid, int addnum)
/*      */   {
/*  834 */     if (addnum <= 0)
/*      */     {
/*  836 */       return false;
/*      */     }
/*  838 */     JingjiPvp jingjiData = Role2jingjipvp.get(Long.valueOf(roleid));
/*  839 */     if (jingjiData == null)
/*      */     {
/*  841 */       return false;
/*      */     }
/*  843 */     jingjiData.setFightcount(addnum + jingjiData.getFightcount());
/*  844 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean setFightcount(long roleid, int num)
/*      */   {
/*  856 */     if (num < 0)
/*      */     {
/*  858 */       return false;
/*      */     }
/*  860 */     JingjiPvp jingjiData = Role2jingjipvp.get(Long.valueOf(roleid));
/*  861 */     if (jingjiData == null)
/*      */     {
/*  863 */       return false;
/*      */     }
/*  865 */     jingjiData.setFightcount(num);
/*  866 */     return true;
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
/*      */   static int getFightcount(long roleid)
/*      */   {
/*  879 */     JingjiPvp jingjiData = Role2jingjipvp.select(Long.valueOf(roleid));
/*  880 */     if (jingjiData == null)
/*      */     {
/*  882 */       return -1;
/*      */     }
/*  884 */     return jingjiData.getFightcount();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static long getLastSeasonEndtime(long roleid)
/*      */   {
/*  896 */     JingjiPvp jingjiData = Role2jingjipvp.select(Long.valueOf(roleid));
/*  897 */     if (jingjiData == null)
/*      */     {
/*  899 */       return 0L;
/*      */     }
/*  901 */     return jingjiData.getLastseasonendtime();
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
/*      */   static boolean setLastSeasonEndtime(long roleid, long seasonendtime)
/*      */   {
/*  914 */     JingjiPvp jingjiData = Role2jingjipvp.get(Long.valueOf(roleid));
/*  915 */     if (jingjiData == null)
/*      */     {
/*  917 */       return false;
/*      */     }
/*  919 */     jingjiData.setLastseasonendtime(seasonendtime);
/*  920 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean isSendbulletin(long roleid)
/*      */   {
/*  932 */     JingjiPvp jingjiData = Role2jingjipvp.get(Long.valueOf(roleid));
/*  933 */     if (jingjiData == null)
/*      */     {
/*  935 */       return false;
/*      */     }
/*  937 */     return jingjiData.getIssendbulletin();
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
/*      */   static boolean setIsSendbulletin(long roleid, boolean issendBulletin)
/*      */   {
/*  951 */     JingjiPvp jingjiData = Role2jingjipvp.get(Long.valueOf(roleid));
/*  952 */     if (jingjiData == null)
/*      */     {
/*  954 */       return false;
/*      */     }
/*  956 */     jingjiData.setIssendbulletin(issendBulletin);
/*  957 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getLastseasonphase(long roleid)
/*      */   {
/*  968 */     JingjiPvp jingjiData = Role2jingjipvp.get(Long.valueOf(roleid));
/*  969 */     if (jingjiData == null)
/*      */     {
/*  971 */       return 0;
/*      */     }
/*  973 */     return jingjiData.getLastseasonphase();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean setLastseasonphase(long roleid, int phase)
/*      */   {
/*  985 */     if (phase < 0)
/*      */     {
/*  987 */       return false;
/*      */     }
/*  989 */     JingjiPvp jingjiData = Role2jingjipvp.get(Long.valueOf(roleid));
/*  990 */     if (jingjiData == null)
/*      */     {
/*  992 */       return false;
/*      */     }
/*  994 */     jingjiData.setLastseasonphase(phase);
/*  995 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getLastseasonrank(long roleid)
/*      */   {
/* 1006 */     JingjiPvp jingjiData = Role2jingjipvp.get(Long.valueOf(roleid));
/* 1007 */     if (jingjiData == null)
/*      */     {
/* 1009 */       return 0;
/*      */     }
/* 1011 */     return jingjiData.getLastseasonrank();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean setLastseasonrank(long roleid, int rank)
/*      */   {
/* 1023 */     if (rank < 0)
/*      */     {
/* 1025 */       return false;
/*      */     }
/* 1027 */     JingjiPvp jingjiData = Role2jingjipvp.get(Long.valueOf(roleid));
/* 1028 */     if (jingjiData == null)
/*      */     {
/* 1030 */       return false;
/*      */     }
/* 1032 */     jingjiData.setLastseasonrank(rank);
/* 1033 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void synJingjiData(long roleid, JingjiPvp jingjiData)
/*      */   {
/* 1043 */     SSynJingjiData sSynJingjiData = new SSynJingjiData();
/* 1044 */     sSynJingjiData.winpoint = jingjiData.getWinpoint();
/* 1045 */     sSynJingjiData.phase = getPhaseByWingPoint(sSynJingjiData.winpoint);
/* 1046 */     sSynJingjiData.totalbuycount = jingjiData.getBuycount();
/* 1047 */     sSynJingjiData.challengecount = (jingjiData.getChallengecount() + jingjiData.getBuychallengecount());
/* 1048 */     sSynJingjiData.dayjifen = jingjiData.getJifen();
/* 1049 */     sSynJingjiData.totaljifen = MallInterface.getJifen(roleid, 2);
/* 1050 */     sSynJingjiData.lastseasonphase = jingjiData.getLastseasonphase();
/*      */     
/* 1052 */     int first = getFirstvictoryrewardid(roleid);
/* 1053 */     if ((first == 0) || (first == -1))
/*      */     {
/* 1055 */       sSynJingjiData.isfirstvictoty = first;
/*      */     }
/*      */     else
/*      */     {
/* 1059 */       sSynJingjiData.isfirstvictoty = 1;
/*      */     }
/* 1061 */     int five = getFivefightrewardid(roleid);
/* 1062 */     if ((five == 0) || (five == -1))
/*      */     {
/* 1064 */       sSynJingjiData.isfivefight = five;
/*      */     }
/*      */     else
/*      */     {
/* 1068 */       sSynJingjiData.isfivefight = 1;
/*      */     }
/*      */     
/* 1071 */     sSynJingjiData.lastseasonphase = getLastseasonphase(roleid);
/*      */     
/* 1073 */     RoleJingjiChartInterface.rank(roleid, sSynJingjiData.winpoint);
/* 1074 */     int rank = RoleJingjiChartInterface.getRank(roleid);
/*      */     
/* 1076 */     sSynJingjiData.rank = (rank + 1);
/* 1077 */     OnlineManager.getInstance().send(roleid, sSynJingjiData);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void aSynSeasonEndTime(long roleid)
/*      */   {
/* 1088 */     new SynSeasonEndTimePro(roleid).execute();
/*      */   }
/*      */   
/*      */   private static class SynSeasonEndTimePro
/*      */     extends LogicProcedure
/*      */   {
/*      */     private long roleid;
/*      */     
/*      */     public SynSeasonEndTimePro(long roleid)
/*      */     {
/* 1098 */       this.roleid = roleid;
/*      */     }
/*      */     
/*      */     protected boolean processImp()
/*      */       throws Exception
/*      */     {
/* 1104 */       JingjiManager.synJingjiSeasonEndTime(this.roleid);
/* 1105 */       return true;
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
/*      */   static void asynAddTotalCount(int addnum)
/*      */   {
/* 1118 */     new AddJingjiTotalCountPro(addnum).execute();
/*      */   }
/*      */   
/*      */ 
/*      */   private static class AddJingjiTotalCountPro
/*      */     extends LogicProcedure
/*      */   {
/*      */     private final int add;
/*      */     
/*      */     public AddJingjiTotalCountPro(int add)
/*      */     {
/* 1129 */       this.add = add;
/*      */     }
/*      */     
/*      */     protected boolean processImp()
/*      */       throws Exception
/*      */     {
/* 1135 */       if (this.add <= 0)
/*      */       {
/* 1137 */         return false;
/*      */       }
/* 1139 */       xbean.Jingji jingji = xtable.Jingji.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 1140 */       if (jingji == null)
/*      */       {
/* 1142 */         return false;
/*      */       }
/* 1144 */       jingji.setTotalcount(jingji.getTotalcount() + this.add);
/* 1145 */       return true;
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getTotalCount()
/*      */   {
/* 1157 */     xbean.Jingji jingji = xtable.Jingji.select(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 1158 */     if (jingji == null)
/*      */     {
/* 1160 */       return 0;
/*      */     }
/* 1162 */     return jingji.getTotalcount();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void synJingjiSeasonEndTime(long roleid)
/*      */   {
/* 1172 */     SSynJingjiSeasonEndtime seasonEndtime = new SSynJingjiSeasonEndtime();
/* 1173 */     long seasonStartTime = getSeasonStarttime();
/* 1174 */     if (isMondayZeroTime(seasonStartTime))
/*      */     {
/* 1176 */       seasonEndtime.seasonendtime = TimeUnit.MILLISECONDS.toSeconds(getSeasonPersistTime() + seasonStartTime);
/*      */ 
/*      */     }
/*      */     else
/*      */     {
/* 1181 */       seasonEndtime.seasonendtime = TimeUnit.MILLISECONDS.toSeconds(getNextMondayZeroTime(seasonStartTime));
/*      */     }
/*      */     
/* 1184 */     OnlineManager.getInstance().send(roleid, seasonEndtime);
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
/*      */   static boolean asynRefreshMatchOpponent(long roleid, int roleLevel, int mulitFight, int winPoint, long autoFreshTime, long lastFreshTime)
/*      */   {
/* 1202 */     if ((autoFreshTime == -1L) && (lastFreshTime == -1L))
/*      */     {
/* 1204 */       return false;
/*      */     }
/* 1206 */     new RefreshOpponentPro(roleid, roleLevel, mulitFight, winPoint, autoFreshTime, lastFreshTime).execute();
/*      */     
/* 1208 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   private static class RefreshOpponentPro
/*      */     extends LogicProcedure
/*      */   {
/*      */     private final long roleid;
/*      */     
/*      */     private final int roleLevel;
/*      */     private final int mulitFight;
/*      */     private final int winPoint;
/*      */     private final long autoFreshTime;
/*      */     private final long lastFreshTime;
/*      */     
/*      */     public RefreshOpponentPro(long roleid, int roleLevel, int mulitFight, int winPoint, long autoFreshTime, long lastFreshTime)
/*      */     {
/* 1225 */       this.roleid = roleid;
/* 1226 */       this.roleLevel = roleLevel;
/* 1227 */       this.mulitFight = mulitFight;
/* 1228 */       this.winPoint = winPoint;
/* 1229 */       this.autoFreshTime = autoFreshTime;
/* 1230 */       this.lastFreshTime = lastFreshTime;
/*      */     }
/*      */     
/*      */     protected boolean processImp()
/*      */       throws Exception
/*      */     {
/* 1236 */       List<Long> roleList = new ArrayList();
/* 1237 */       int ranksize = RoleJingjiChartInterface.getRankSize();
/* 1238 */       if (ranksize > JingjiActivityCfgConsts.getInstance().MIN_COMPETITOR_FOR_DELETE_ROBOT_PLAYER)
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1246 */         int myrank = RoleJingjiChartInterface.getRank(this.roleid);
/* 1247 */         int from = 0;
/* 1248 */         int to = 0;
/*      */         
/* 1250 */         if (myrank == -1)
/*      */         {
/* 1252 */           roleList.addAll(JingjiManager.matchOpponent(this.roleid, this.mulitFight, this.winPoint));
/*      */         }
/*      */         else
/*      */         {
/* 1256 */           from = Math.max(0, myrank - JingjiActivityCfgConsts.getInstance().OPPONENT_RANK_DELTA);
/* 1257 */           to = Math.min(myrank + JingjiActivityCfgConsts.getInstance().OPPONENT_RANK_DELTA, ranksize - 1);
/* 1258 */           roleList.addAll(RoleJingjiChartInterface.getRankData(from, to));
/* 1259 */           roleList.remove(Long.valueOf(this.roleid));
/*      */         }
/*      */       }
/*      */       
/* 1263 */       List<Long> opponentList = new ArrayList();
/* 1264 */       CommonUtils.regionRandom(roleList, Math.min(JingjiActivityCfgConsts.getInstance().COMPETITOR_NUM, roleList.size()), opponentList);
/*      */       
/*      */ 
/* 1267 */       JingjiManager.aSynAddOpponent(this.roleid, opponentList, this.autoFreshTime, this.lastFreshTime);
/* 1268 */       JingjiManager.aSynOpponentInfo(this.roleid, this.roleLevel, opponentList);
/* 1269 */       return true;
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
/*      */   static List<Long> matchOpponent(long roleId, int mulitFight, int winPoint)
/*      */   {
/* 1282 */     return FightMatchManager.matchOpponents(roleId, mulitFight, winPoint);
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
/*      */   private static void aSynAddOpponent(long roleid, List<Long> roleList, long autoFreshTime, long lastFreshTime)
/*      */   {
/* 1296 */     new AddOpponentPro(roleid, roleList, autoFreshTime, lastFreshTime).execute();
/*      */   }
/*      */   
/*      */ 
/*      */   private static class AddOpponentPro
/*      */     extends LogicProcedure
/*      */   {
/*      */     private final long roleid;
/*      */     private final List<Long> roleList;
/*      */     private final long autoFreshTime;
/*      */     private final long lastFreshTime;
/*      */     
/*      */     public AddOpponentPro(long roleid, List<Long> roleList, long autoFreshTime, long lastFreshTime)
/*      */     {
/* 1310 */       this.roleid = roleid;
/* 1311 */       this.roleList = new ArrayList(roleList);
/* 1312 */       this.autoFreshTime = autoFreshTime;
/* 1313 */       this.lastFreshTime = lastFreshTime;
/*      */     }
/*      */     
/*      */     protected boolean processImp()
/*      */       throws Exception
/*      */     {
/* 1319 */       Opponent xOpponent = Role2opponent.get(Long.valueOf(this.roleid));
/* 1320 */       if (xOpponent == null)
/*      */       {
/* 1322 */         xOpponent = Pod.newOpponent();
/* 1323 */         Role2opponent.insert(Long.valueOf(this.roleid), xOpponent);
/*      */       }
/*      */       
/* 1326 */       if (this.autoFreshTime != -1L)
/*      */       {
/* 1328 */         xOpponent.setAutofreshtime(this.autoFreshTime);
/*      */       }
/*      */       
/* 1331 */       if (this.lastFreshTime != -1L)
/*      */       {
/* 1333 */         xOpponent.setLastfreshtime(this.lastFreshTime);
/*      */       }
/*      */       
/* 1336 */       if (this.roleList.size() < JingjiActivityCfgConsts.getInstance().COMPETITOR_NUM)
/*      */       {
/* 1338 */         this.roleList.add(Long.valueOf(0L));
/*      */       }
/* 1340 */       xOpponent.getOpponentroleids().clear();
/* 1341 */       xOpponent.getOpponentroleids().addAll(this.roleList);
/* 1342 */       return true;
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
/*      */   static List<OpponentInfo> getOpponentInfos(List<Long> roleList, int roleLevel, long seasonStartTime)
/*      */   {
/* 1357 */     int ranksize = RoleJingjiChartInterface.getRankSize();
/*      */     
/* 1359 */     List<OpponentInfo> opponentList = getRoleOpponent(roleList, ranksize, seasonStartTime);
/* 1360 */     if (opponentList.size() < JingjiActivityCfgConsts.getInstance().COMPETITOR_NUM)
/*      */     {
/* 1362 */       List<OpponentInfo> robots = getRobotOpponent(JingjiActivityCfgConsts.getInstance().COMPETITOR_NUM - opponentList.size(), roleLevel);
/*      */       
/* 1364 */       opponentList.addAll(robots);
/*      */     }
/* 1366 */     return opponentList;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static List<OpponentInfo> getRobotOpponent(int num, int rolelevel)
/*      */   {
/* 1378 */     List<OpponentInfo> opponentlist = new ArrayList();
/* 1379 */     for (int i = 0; i < num; i++)
/*      */     {
/* 1381 */       OpponentInfo opponentInfo = new OpponentInfo();
/* 1382 */       opponentInfo.opponenttype = 2;
/*      */       
/* 1384 */       opponentInfo.level = rolelevel;
/* 1385 */       opponentInfo.phase = 1;
/* 1386 */       opponentInfo.roleid = 0L;
/* 1387 */       opponentInfo.rank = 0;
/* 1388 */       opponentlist.add(opponentInfo);
/*      */     }
/* 1390 */     return opponentlist;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static List<OpponentInfo> getRoleOpponent(List<Long> roleList, int ranksize, long seasonStartTime)
/*      */   {
/* 1401 */     List<OpponentInfo> opponentlist = new ArrayList();
/* 1402 */     if ((roleList == null) || (roleList.isEmpty()))
/*      */     {
/* 1404 */       return opponentlist;
/*      */     }
/* 1406 */     int min = Math.min(JingjiActivityCfgConsts.getInstance().COMPETITOR_NUM, roleList.size());
/* 1407 */     for (int i = 0; i < min; i++)
/*      */     {
/*      */ 
/* 1410 */       long roleid = ((Long)roleList.get(i)).longValue();
/* 1411 */       if (roleid != 0L)
/*      */       {
/*      */ 
/*      */ 
/* 1415 */         int rank = RoleJingjiChartInterface.getRank(roleid) + 1;
/* 1416 */         OpponentInfo opponentInfo = new OpponentInfo();
/* 1417 */         if ((rank > 0) && (rank <= JingjiActivityCfgConsts.getInstance().MIN_RANK_FOR_MYSTERIOUS_PLAYER) && (ranksize >= JingjiActivityCfgConsts.getInstance().MIN_COMPETITOR_FOR_DISPLAY_MYSTERIOUS_PLAYER))
/*      */         {
/*      */ 
/* 1420 */           opponentInfo.opponenttype = 3;
/*      */         }
/*      */         else
/*      */         {
/* 1424 */           opponentInfo.opponenttype = 1;
/* 1425 */           opponentInfo.sex = RoleInterface.getGender(roleid);
/* 1426 */           opponentInfo.occupation = RoleInterface.getOccupationId(roleid);
/*      */         }
/*      */         
/* 1429 */         opponentInfo.level = RoleInterface.getLevel(roleid);
/*      */         
/* 1431 */         int phase = getPhaseByWingPoint(getWinpoint(roleid, seasonStartTime));
/* 1432 */         if (phase == -1)
/*      */         {
/* 1434 */           opponentInfo.phase = 1;
/*      */         }
/*      */         else
/*      */         {
/* 1438 */           opponentInfo.phase = phase;
/*      */         }
/* 1440 */         opponentInfo.roleid = roleid;
/* 1441 */         opponentInfo.rank = rank;
/* 1442 */         opponentlist.add(opponentInfo);
/*      */       }
/*      */     }
/* 1445 */     return opponentlist;
/*      */   }
/*      */   
/*      */   static boolean isOpponentRight(long roleid, long opponentid)
/*      */   {
/* 1450 */     Opponent opponent = Role2opponent.select(Long.valueOf(roleid));
/* 1451 */     if (opponent == null)
/*      */     {
/* 1453 */       return false;
/*      */     }
/*      */     
/* 1456 */     return (opponent.getOpponentroleids().isEmpty()) || (opponent.getOpponentroleids().contains(Long.valueOf(opponentid)));
/*      */   }
/*      */   
/*      */ 
/*      */   static boolean canFresh(long roleid)
/*      */   {
/* 1462 */     Opponent opponent = Role2opponent.select(Long.valueOf(roleid));
/* 1463 */     if (opponent == null)
/*      */     {
/* 1465 */       return false;
/*      */     }
/*      */     
/* 1468 */     return DateTimeUtils.getCurrTimeInMillis() - opponent.getLastfreshtime() > getFreshInterval();
/*      */   }
/*      */   
/*      */   static long getFreshInterval()
/*      */   {
/* 1473 */     return TimeUnit.SECONDS.toMillis(JingjiActivityCfgConsts.getInstance().COMPETITOR_REFRESH_TIME);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void aSynOpponentInfo(long roleid, int roleLevel, List<Long> roleList)
/*      */   {
/* 1484 */     new SynOpponentInfoPro(roleid, roleLevel, roleList).execute();
/*      */   }
/*      */   
/*      */ 
/*      */   private static class SynOpponentInfoPro
/*      */     extends LogicProcedure
/*      */   {
/*      */     private final long roleid;
/*      */     private final int roleLevel;
/*      */     private List<Long> roleList;
/*      */     
/*      */     public SynOpponentInfoPro(long roleid, int roleLevel, List<Long> roleList)
/*      */     {
/* 1497 */       this.roleid = roleid;
/* 1498 */       this.roleLevel = roleLevel;
/* 1499 */       this.roleList = roleList;
/*      */     }
/*      */     
/*      */     protected boolean processImp()
/*      */       throws Exception
/*      */     {
/* 1505 */       SResOpponentInfo res = new SResOpponentInfo();
/* 1506 */       long seasonStarttime = JingjiManager.getSeasonStarttime();
/* 1507 */       res.opponentlist.addAll(JingjiManager.getOpponentInfos(this.roleList, this.roleLevel, seasonStarttime));
/* 1508 */       OnlineManager.getInstance().send(this.roleid, res);
/* 1509 */       return true;
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void synJingjiDataChanged(long roleid, int winpointdelta, boolean iswin)
/*      */   {
/* 1521 */     SsynJingjiDataChanged jingjiDataChanged = new SsynJingjiDataChanged();
/* 1522 */     jingjiDataChanged.iswin = (iswin ? 1 : 0);
/* 1523 */     jingjiDataChanged.winpoint = getWinpoint(roleid, true);
/* 1524 */     jingjiDataChanged.phase = getPhaseByWingPoint(jingjiDataChanged.winpoint);
/* 1525 */     jingjiDataChanged.challengecount = getTotalChallengeCount(roleid);
/* 1526 */     jingjiDataChanged.dayjifen = getJifen(roleid, true);
/* 1527 */     jingjiDataChanged.totaljifen = MallInterface.getJifen(roleid, 2);
/* 1528 */     jingjiDataChanged.rank = (RoleJingjiChartInterface.getRank(roleid) + 1);
/* 1529 */     jingjiDataChanged.winpointdelta = winpointdelta;
/*      */     
/* 1531 */     OnlineManager.getInstance().send(roleid, jingjiDataChanged);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void synRewardChanged(long roleid)
/*      */   {
/* 1541 */     SsynRewardChanged rewardChanged = new SsynRewardChanged();
/* 1542 */     int first = getFirstvictoryrewardid(roleid);
/* 1543 */     if ((first == 0) || (first == -1))
/*      */     {
/* 1545 */       rewardChanged.isfirstvictoty = first;
/*      */     }
/*      */     else
/*      */     {
/* 1549 */       rewardChanged.isfirstvictoty = 1;
/*      */     }
/* 1551 */     int five = getFivefightrewardid(roleid);
/* 1552 */     if ((five == 0) || (five == -1))
/*      */     {
/* 1554 */       rewardChanged.isfivefight = five;
/*      */     }
/*      */     else
/*      */     {
/* 1558 */       rewardChanged.isfivefight = 1;
/*      */     }
/* 1560 */     rewardChanged.lastseasonphase = getLastseasonphase(roleid);
/* 1561 */     OnlineManager.getInstance().send(roleid, rewardChanged);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static long getSeasonStarttime()
/*      */   {
/* 1571 */     xbean.Jingji jingji = xtable.Jingji.select(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 1572 */     if (jingji == null)
/*      */     {
/* 1574 */       return 0L;
/*      */     }
/* 1576 */     return jingji.getSeasonstarttime();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static Pair<Long, Integer> getSeasonStarttimeAndMergeClear()
/*      */   {
/* 1587 */     xbean.Jingji jingji = xtable.Jingji.select(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 1588 */     if (jingji == null)
/*      */     {
/* 1590 */       return new Pair(Long.valueOf(0L), Integer.valueOf(0));
/*      */     }
/* 1592 */     return new Pair(Long.valueOf(jingji.getSeasonstarttime()), Integer.valueOf(jingji.getMerge_clear()));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void setSeasonStarttime(long starttime)
/*      */   {
/* 1601 */     xbean.Jingji jingji = xtable.Jingji.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 1602 */     if (jingji == null)
/*      */     {
/* 1604 */       jingji = Pod.newJingji();
/* 1605 */       jingji.setMerge_clear(0);
/* 1606 */       xtable.Jingji.insert(Long.valueOf(GameServerInfoManager.getLocalId()), jingji);
/*      */     }
/* 1608 */     jingji.setSeasonstarttime(starttime);
/* 1609 */     jingji.setMerge_clear(0);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static long getSeasonPersistTime()
/*      */   {
/* 1619 */     return TimeUnit.DAYS.toMillis(JingjiActivityCfgConsts.getInstance().JINGJI_SEASON_PERSIST_DAY);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static long computeSeasonObserverInterval()
/*      */   {
/* 1630 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 1631 */     long nextMondayTime = getNextMondayZeroTime(now);
/* 1632 */     long starttime = getSeasonStarttime();
/* 1633 */     long seasonPersistTime = getSeasonPersistTime();
/*      */     
/* 1635 */     if (starttime == 0L)
/*      */     {
/* 1637 */       new InitSeasonStartTimePro(nextMondayTime - seasonPersistTime).call();
/* 1638 */       return TimeUnit.MILLISECONDS.toSeconds(nextMondayTime - now);
/*      */     }
/*      */     
/*      */ 
/* 1642 */     if (isMondayZeroTime(starttime))
/*      */     {
/* 1644 */       if (now - starttime >= seasonPersistTime)
/*      */       {
/* 1646 */         new InitSeasonStartTimePro(nextMondayTime - seasonPersistTime).call();
/* 1647 */         return TimeUnit.MILLISECONDS.toSeconds(nextMondayTime - now);
/*      */       }
/*      */       
/*      */ 
/* 1651 */       return TimeUnit.MILLISECONDS.toSeconds(starttime + seasonPersistTime - now);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/* 1656 */     return TimeUnit.MILLISECONDS.toSeconds(nextMondayTime - now);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   static long getNextMondayZeroTime(long curTime)
/*      */   {
/* 1663 */     long nextMondayTime = DateTimeUtils.getWeeklyResetTime(curTime, 2, 0) + TimeUnit.DAYS.toMillis(7L);
/* 1664 */     return nextMondayTime;
/*      */   }
/*      */   
/*      */   static boolean isMondayZeroTime(long timeMills)
/*      */   {
/* 1669 */     return timeMills == DateTimeUtils.getTimeInWeek(timeMills, 2, 0);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void seasonEndInitRoleData(JingjiPvp xJingjiPvp, long seasonEndtime)
/*      */   {
/* 1679 */     int winPoint = xJingjiPvp.getWinpoint();
/*      */     
/* 1681 */     int phase = getPhaseByWingPoint(winPoint);
/* 1682 */     xJingjiPvp.setLastseasonphase(phase);
/* 1683 */     xJingjiPvp.setWinpoint(JingjiActivityCfgConsts.getInstance().INIT_WING_POINT_NUM);
/* 1684 */     xJingjiPvp.setLastseasonendtime(seasonEndtime);
/* 1685 */     xJingjiPvp.setIssendbulletin(false);
/* 1686 */     xJingjiPvp.setMerge_cleared(0);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void synBuyChallengeCount(long roleid, int buycount)
/*      */   {
/* 1698 */     SBuyChallengeCountRes res = new SBuyChallengeCountRes();
/* 1699 */     res.buycount = buycount;
/* 1700 */     res.challengecount = getTotalChallengeCount(roleid);
/* 1701 */     res.totalbuycount = getBuyCount(roleid);
/* 1702 */     OnlineManager.getInstance().send(roleid, res);
/*      */   }
/*      */   
/*      */   static void sendErrorInfo(long roleid, int rescode)
/*      */   {
/* 1707 */     SErrorInfo errorInfo = new SErrorInfo();
/* 1708 */     errorInfo.errorcode = rescode;
/* 1709 */     OnlineManager.getInstance().sendAtOnce(roleid, errorInfo);
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
/*      */   static void computeReserveExp(String userId, long roleid, int jingjicount, int turn)
/*      */   {
/* 1725 */     if (jingjicount < 0)
/*      */     {
/* 1727 */       return;
/*      */     }
/*      */     
/* 1730 */     if (!mzm.gsp.activity.main.ActivityInterface.isInActivityLevel(userId, roleid, JingjiActivityCfgConsts.getInstance().ACTIVITYID))
/*      */     {
/* 1732 */       return;
/*      */     }
/*      */     
/* 1735 */     int count = getJingjiRecommendCount() * turn;
/*      */     
/* 1737 */     if (jingjicount >= 0)
/*      */     {
/* 1739 */       int c = getJingjiRecommendCount() - jingjicount;
/* 1740 */       if (c > 0)
/*      */       {
/* 1742 */         count += c;
/*      */       }
/*      */     }
/*      */     
/* 1746 */     if (count <= 0)
/*      */     {
/* 1748 */       return;
/*      */     }
/* 1750 */     AwardReason reason = new AwardReason(LogReason.JINGJI_DAY_STORAGE_AWARD, JingjiActivityCfgConsts.getInstance().FAIL_REWARDID);
/*      */     
/* 1752 */     reason.setJustQuery(true);
/* 1753 */     AwardModel award = AwardInterface.getRoleAwardModel(JingjiActivityCfgConsts.getInstance().FAIL_REWARDID, roleid, -1, reason);
/*      */     
/* 1755 */     if (award == null)
/*      */     {
/* 1757 */       return;
/*      */     }
/* 1759 */     int addexp = (int)(award.getRoleExp() * count * (JingjiActivityCfgConsts.getInstance().EXP_CHANGE_RATE / 10000.0D));
/*      */     
/* 1761 */     if (addexp > 0)
/*      */     {
/* 1763 */       StorageExpInterface.addStorageExp(roleid, addexp);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   static int getJingjiRecommendCount()
/*      */   {
/* 1770 */     int count = JingjiActivityCfgConsts.getInstance().DAY_OFFER_CHALLENGE_COUNT;
/* 1771 */     return count;
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
/*      */   static void synRankDatas(long roleid, int startpos, int num)
/*      */   {
/* 1784 */     SGetRoleJingjiRankRes res = new SGetRoleJingjiRankRes();
/* 1785 */     res.point = getWinpoint(roleid, false);
/* 1786 */     res.myrank = (JingJiRankManager.getInstance().getRank(Long.valueOf(roleid)) + 1);
/* 1787 */     res.ranklist.addAll(getRankDatasFromstartpos(startpos, num));
/* 1788 */     OnlineManager.getInstance().send(roleid, res);
/*      */   }
/*      */   
/*      */   private static List<RoleJingjiRankData> getRankDatasFromstartpos(int startpos, int num)
/*      */   {
/* 1793 */     List<RoleJingjiChart> list = JingJiRankManager.getInstance().getRankObjs(startpos - 1, startpos + num - 2);
/*      */     
/* 1795 */     List<RoleJingjiRankData> ranklist = new ArrayList();
/* 1796 */     int i = startpos;
/* 1797 */     for (RoleJingjiChart roleJingjiChart : list)
/*      */     {
/* 1799 */       Role role = RoleInterface.getRole(roleJingjiChart.getKey().longValue(), false);
/* 1800 */       RoleJingjiRankData rankdata = new RoleJingjiRankData();
/* 1801 */       rankdata.winpoint = roleJingjiChart.getWinPoint();
/* 1802 */       rankdata.roleid = roleJingjiChart.getKey().longValue();
/* 1803 */       rankdata.name = role.getName();
/* 1804 */       rankdata.phase = getPhaseByWingPoint(rankdata.winpoint);
/* 1805 */       rankdata.no = i;
/* 1806 */       ranklist.add(rankdata);
/* 1807 */       i++;
/*      */     }
/* 1809 */     return ranklist;
/*      */   }
/*      */   
/*      */ 
/*      */   static void offerDayJingjiAward()
/*      */   {
/* 1815 */     long now = DateTimeUtils.getCurrTimeInMillis() + 1000L;
/* 1816 */     List<RoleJingjiChart> roleJifenCharts = JingJiRankManager.getInstance().getAllChartObjs();
/* 1817 */     List<RoleJingjiChart> roleJifenChartsFromCache = JingjiRankCache.getInstance().getAndClearRoleJingjiChartList(now);
/*      */     
/* 1819 */     List<RoleJingjiChart> targetRoleJingjiCharts = null;
/* 1820 */     if ((roleJifenChartsFromCache != null) && (!roleJifenChartsFromCache.isEmpty()))
/*      */     {
/* 1822 */       targetRoleJingjiCharts = roleJifenChartsFromCache;
/* 1823 */       String logStr = String.format("[jingji]JingjiManager.offerDayJingjiAward@get rank list from cache", new Object[0]);
/* 1824 */       logger.info(logStr);
/*      */     }
/*      */     else
/*      */     {
/* 1828 */       targetRoleJingjiCharts = roleJifenCharts;
/* 1829 */       String logStr = String.format("[jingji]JingjiManager.offerDayJingjiAward@get rank list from rank", new Object[0]);
/* 1830 */       logger.info(logStr);
/*      */     }
/*      */     
/* 1833 */     NoneRealTimeTaskManager.getInstance().addTask(new PDailyRankAward(targetRoleJingjiCharts, now));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void sendNoAwardRes(long roleid)
/*      */   {
/* 1843 */     SJIngjiNoAwardRes res = new SJIngjiNoAwardRes();
/* 1844 */     OnlineManager.getInstance().send(roleid, res);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean isJingjiSwitchOpenForRole(long roleid)
/*      */   {
/* 1855 */     if (!OpenInterface.getOpenStatus(8))
/*      */     {
/* 1857 */       return false;
/*      */     }
/* 1859 */     if (OpenInterface.isBanPlay(roleid, 8))
/*      */     {
/* 1861 */       OpenInterface.sendBanPlayMsg(roleid, 8);
/* 1862 */       return false;
/*      */     }
/* 1864 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean isRoleStateCanJoinJIngjiActivity(long roleid)
/*      */   {
/* 1876 */     return RoleStatusInterface.checkCanSetStatus(roleid, 22, false);
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
/*      */   static int getJingjiRestExp(long roleid, int finishCount)
/*      */   {
/* 1890 */     int reccount = getJingjiRecommendCount();
/* 1891 */     if ((finishCount < 0) || (finishCount > getJingjiRecommendCount()))
/*      */     {
/* 1893 */       return 0;
/*      */     }
/* 1895 */     int delta = reccount - finishCount;
/* 1896 */     int ringExp = getExpByRing(roleid, false);
/* 1897 */     int addexp = ringExp * delta;
/* 1898 */     return addexp;
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
/*      */   static int getExpByRing(long roleid, boolean isWing)
/*      */   {
/* 1911 */     int rewardid = 0;
/* 1912 */     if (isWing)
/*      */     {
/* 1914 */       rewardid = JingjiActivityCfgConsts.getInstance().SUCCESS_REWARDID;
/*      */     }
/*      */     else
/*      */     {
/* 1918 */       rewardid = JingjiActivityCfgConsts.getInstance().FAIL_REWARDID;
/*      */     }
/* 1920 */     AwardReason reason = new AwardReason(LogReason.JINGJI_DAY_STORAGE_AWARD, rewardid);
/* 1921 */     reason.setJustQuery(true);
/* 1922 */     AwardModel award = AwardInterface.getRoleAwardModel(rewardid, roleid, -1, reason);
/* 1923 */     if (award == null)
/*      */     {
/* 1925 */       return 0;
/*      */     }
/* 1927 */     return award.getRoleExp();
/*      */   }
/*      */   
/*      */ 
/*      */   static double getRate()
/*      */   {
/* 1933 */     return JingjiActivityCfgConsts.getInstance().RETURN_BACK_EXP_CHANGE_RATE / 10000.0D;
/*      */   }
/*      */   
/*      */   static void addTLog(long roleid, String logName, Object... logColumns)
/*      */   {
/* 1938 */     String vGameIp = GameServerInfoManager.getHostIP();
/* 1939 */     int roleLevel = RoleInterface.getLevel(roleid);
/* 1940 */     String userid = RoleInterface.getUserId(roleid);
/*      */     
/* 1942 */     StringBuilder logStr = new StringBuilder();
/* 1943 */     logStr.append(vGameIp);
/* 1944 */     logStr.append("|").append(userid);
/* 1945 */     logStr.append("|").append(roleid);
/* 1946 */     logStr.append("|").append(roleLevel);
/*      */     
/* 1948 */     for (Object colum : logColumns)
/*      */     {
/* 1950 */       logStr.append("|").append(colum);
/*      */     }
/*      */     
/* 1953 */     TLogManager.getInstance().addLog(roleid, logName, logStr.toString());
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\jingji\main\JingjiManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
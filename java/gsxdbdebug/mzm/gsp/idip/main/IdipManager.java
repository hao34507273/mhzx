/*      */ package mzm.gsp.idip.main;
/*      */ 
/*      */ import com.goldhuman.Common.Octets;
/*      */ import gnet.link.Onlines;
/*      */ import java.io.UnsupportedEncodingException;
/*      */ import java.text.SimpleDateFormat;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import java.util.Set;
/*      */ import java.util.concurrent.TimeUnit;
/*      */ import java.util.concurrent.locks.Lock;
/*      */ import java.util.concurrent.locks.ReadWriteLock;
/*      */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*      */ import java.util.regex.Matcher;
/*      */ import java.util.regex.Pattern;
/*      */ import mzm.event.TriggerEventsManger;
/*      */ import mzm.gsp.GameServer;
/*      */ import mzm.gsp.GameServerInfoManager;
/*      */ import mzm.gsp.bigboss.confbean.SOcp2ChartType;
/*      */ import mzm.gsp.buff.main.BuffInterface;
/*      */ import mzm.gsp.friend.main.FriendInterface;
/*      */ import mzm.gsp.idip.SIdipAddZeroProfit;
/*      */ import mzm.gsp.idip.SIdipBanPlay;
/*      */ import mzm.gsp.idip.SIdipBanRank;
/*      */ import mzm.gsp.idip.SIdipClearSay;
/*      */ import mzm.gsp.idip.SIdipRoleBanPlayInfo;
/*      */ import mzm.gsp.idip.SIdipUnbanPlay;
/*      */ import mzm.gsp.idip.SIdipUnbanRank;
/*      */ import mzm.gsp.idip.event.BanPlay;
/*      */ import mzm.gsp.idip.event.UnbanPlay;
/*      */ import mzm.gsp.item.main.ItemInterface;
/*      */ import mzm.gsp.online.main.OnlineManager;
/*      */ import mzm.gsp.personal.main.PersonalInterface;
/*      */ import mzm.gsp.role.main.RoleInterface;
/*      */ import mzm.gsp.role.main.RoleOneByOneManager;
/*      */ import mzm.gsp.timer.main.Observer;
/*      */ import mzm.gsp.tlog.TLogManager;
/*      */ import mzm.gsp.util.DateTimeUtils;
/*      */ import mzm.gsp.util.LogicProcedure;
/*      */ import org.apache.log4j.Logger;
/*      */ import xbean.IdipConfigInfo;
/*      */ import xbean.IdipForbidInfo;
/*      */ import xbean.Pod;
/*      */ import xbean.RoleInfoForbid;
/*      */ import xbean.RolePlayForbid;
/*      */ import xbean.RoleRankForbid;
/*      */ import xtable.Idipconfig;
/*      */ 
/*      */ public class IdipManager
/*      */ {
/*   53 */   private static boolean idipPressureTest = false;
/*      */   
/*      */   private static final long SECOND_OF_MILLSSECONDS = 1000L;
/*      */   
/*      */   private static final String ENCODING = "UTF-8";
/*   58 */   private static final Map<Long, Map<Integer, IdipForbidData>> banRankCacheMap = new HashMap();
/*   59 */   private static final ReadWriteLock banRankLock = new ReentrantReadWriteLock();
/*   60 */   private static final Map<Long, Map<Integer, Observer>> unbanRankObservers = new HashMap();
/*      */   
/*      */ 
/*   63 */   private static final Map<Long, IdipForbidData> zeroProfitCacheMap = new HashMap();
/*   64 */   private static final ReadWriteLock zeroProfitLock = new ReentrantReadWriteLock();
/*   65 */   private static final Lock zeroProfitObserverLock = new java.util.concurrent.locks.ReentrantLock();
/*   66 */   private static final Map<Long, Observer> unbanZeroProfitObservers = new HashMap();
/*      */   
/*      */   private static final int ZERO_PROFIT_BUFFID = 701299000;
/*      */   
/*   70 */   private static final Map<Long, Map<Integer, IdipForbidData>> banPlayCacheMap = new HashMap();
/*   71 */   private static final ReadWriteLock banPlayLock = new ReentrantReadWriteLock();
/*   72 */   private static final Map<Long, Map<Integer, Observer>> unbanPlayObservers = new HashMap();
/*      */   
/*      */ 
/*   75 */   private static final Map<Long, Map<Integer, IdipForbidData>> lockRoleInfoCacheMap = new HashMap();
/*   76 */   private static final ReadWriteLock roleInfoCacheLock = new ReentrantReadWriteLock();
/*   77 */   private static final Map<Long, Map<Integer, Observer>> unlockRoleInfoObservers = new HashMap();
/*      */   
/*      */   public static final int Chat_Newer = 1;
/*      */   public static final int Chat_Faction = 2;
/*      */   public static final int Chat_Team = 3;
/*      */   
/*      */   static void init()
/*      */   {
/*   85 */     String propertyValue = System.getProperty("com.zulong.mhzx.idip_pressure_test");
/*   86 */     if (propertyValue != null)
/*      */     {
/*   88 */       idipPressureTest = true;
/*      */     }
/*      */     
/*      */ 
/*   92 */     new PIdipInit(null).call();
/*      */   }
/*      */   
/*      */   static boolean isIDIPPressureTest()
/*      */   {
/*   97 */     return idipPressureTest;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static class PIdipInit
/*      */     extends LogicProcedure
/*      */   {
/*      */     protected boolean processImp()
/*      */       throws Exception
/*      */     {
/*  112 */       IdipManager.access$100();
/*      */       
/*  114 */       IdipManager.access$200();
/*      */       
/*  116 */       IdipManager.access$300();
/*      */       
/*  118 */       IdipManager.access$400();
/*      */       
/*  120 */       return true;
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void banRankInit()
/*      */   {
/*  129 */     IdipConfigInfo xIdipConfigInfo = Idipconfig.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  130 */     if (xIdipConfigInfo == null)
/*      */     {
/*  132 */       return;
/*      */     }
/*      */     
/*  135 */     banRankLock.writeLock().lock();
/*      */     try
/*      */     {
/*  138 */       long now = DateTimeUtils.getCurrTimeInMillis();
/*  139 */       Map<Long, RoleRankForbid> xRankForbids = xIdipConfigInfo.getRank_forbids();
/*  140 */       Iterator<Map.Entry<Long, RoleRankForbid>> rankForbids = xRankForbids.entrySet().iterator();
/*  141 */       while (rankForbids.hasNext())
/*      */       {
/*  143 */         Map.Entry<Long, RoleRankForbid> roleForbidEntry = (Map.Entry)rankForbids.next();
/*  144 */         long roleId = ((Long)roleForbidEntry.getKey()).longValue();
/*      */         
/*  146 */         Map<Integer, IdipForbidInfo> forbidsMap = ((RoleRankForbid)roleForbidEntry.getValue()).getForbids();
/*  147 */         Iterator<Map.Entry<Integer, IdipForbidInfo>> iterator = forbidsMap.entrySet().iterator();
/*  148 */         while (iterator.hasNext())
/*      */         {
/*  150 */           Map.Entry<Integer, IdipForbidInfo> forbidEntry = (Map.Entry)iterator.next();
/*  151 */           IdipForbidInfo xIdipForbidInfo = (IdipForbidInfo)forbidEntry.getValue();
/*  152 */           int rankType = ((Integer)forbidEntry.getKey()).intValue();
/*  153 */           if (xIdipForbidInfo.getExpiretime() <= now)
/*      */           {
/*  155 */             iterator.remove();
/*      */ 
/*      */           }
/*      */           else
/*      */           {
/*      */ 
/*  161 */             Map<Integer, IdipForbidData> rankForbidCache = (Map)banRankCacheMap.get(Long.valueOf(roleId));
/*  162 */             if (rankForbidCache == null)
/*      */             {
/*  164 */               rankForbidCache = new HashMap();
/*  165 */               banRankCacheMap.put(Long.valueOf(roleId), rankForbidCache);
/*      */             }
/*  167 */             rankForbidCache.put(Integer.valueOf(rankType), new IdipForbidData(xIdipForbidInfo));
/*      */             
/*  169 */             unbanRankObserver(roleId, rankType, (xIdipForbidInfo.getExpiretime() - now) / 1000L);
/*      */           }
/*      */         }
/*  172 */         if (forbidsMap.isEmpty())
/*      */         {
/*  174 */           rankForbids.remove();
/*      */         }
/*      */       }
/*      */     }
/*      */     finally
/*      */     {
/*  180 */       banRankLock.writeLock().unlock();
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
/*      */   static boolean addBanRank(long roleId, int rankType, long seconds, String reason)
/*      */   {
/*  195 */     IdipConfigInfo xIdipConfigInfo = Idipconfig.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  196 */     if (xIdipConfigInfo == null)
/*      */     {
/*  198 */       xIdipConfigInfo = Pod.newIdipConfigInfo();
/*  199 */       Idipconfig.add(Long.valueOf(GameServerInfoManager.getLocalId()), xIdipConfigInfo);
/*      */     }
/*      */     
/*  202 */     RoleRankForbid xRoleRankForbid = (RoleRankForbid)xIdipConfigInfo.getRank_forbids().get(Long.valueOf(roleId));
/*  203 */     if (xRoleRankForbid == null)
/*      */     {
/*  205 */       xRoleRankForbid = Pod.newRoleRankForbid();
/*  206 */       xIdipConfigInfo.getRank_forbids().put(Long.valueOf(roleId), xRoleRankForbid);
/*      */     }
/*  208 */     IdipForbidInfo xIdipForbidInfo = (IdipForbidInfo)xRoleRankForbid.getForbids().get(Integer.valueOf(rankType));
/*  209 */     if (xIdipForbidInfo == null)
/*      */     {
/*  211 */       xIdipForbidInfo = Pod.newIdipForbidInfo();
/*  212 */       xRoleRankForbid.getForbids().put(Integer.valueOf(rankType), xIdipForbidInfo);
/*      */     }
/*  214 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*  215 */     long expireTime = TimeUnit.SECONDS.toMillis(seconds) + now;
/*  216 */     xIdipForbidInfo.setStarttime(now);
/*  217 */     xIdipForbidInfo.setExpiretime(expireTime);
/*  218 */     xIdipForbidInfo.setReason(reason);
/*      */     
/*      */ 
/*  221 */     banRankLock.writeLock().lock();
/*      */     try
/*      */     {
/*  224 */       Map<Integer, IdipForbidData> rankForbidCache = (Map)banRankCacheMap.get(Long.valueOf(roleId));
/*  225 */       if (rankForbidCache == null)
/*      */       {
/*  227 */         rankForbidCache = new HashMap();
/*  228 */         banRankCacheMap.put(Long.valueOf(roleId), rankForbidCache);
/*      */       }
/*  230 */       IdipForbidData idipForbidData = (IdipForbidData)rankForbidCache.get(Integer.valueOf(rankType));
/*  231 */       if (idipForbidData == null)
/*      */       {
/*  233 */         idipForbidData = new IdipForbidData();
/*  234 */         rankForbidCache.put(Integer.valueOf(rankType), idipForbidData);
/*      */       }
/*  236 */       idipForbidData.setStartTime(now);
/*  237 */       idipForbidData.setExpireTime(expireTime);
/*  238 */       idipForbidData.setReason(reason);
/*      */     }
/*      */     finally
/*      */     {
/*  242 */       banRankLock.writeLock().unlock();
/*      */     }
/*      */     
/*      */ 
/*  246 */     unbanRankObserver(roleId, rankType, seconds);
/*      */     
/*  248 */     if (OnlineManager.getInstance().isOnline(roleId))
/*      */     {
/*      */ 
/*  251 */       sendBanRankMsg(roleId, xIdipForbidInfo, rankType);
/*      */     }
/*      */     
/*  254 */     GameServer.logger().info(String.format("add forbid rank|roleId=%d|rankType=%d|startTime=%d|seconds=%d|reason=%s", new Object[] { Long.valueOf(roleId), Integer.valueOf(rankType), Long.valueOf(now), Long.valueOf(seconds), reason }));
/*      */     
/*      */ 
/*  257 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean banRankAll(long roleId, long seconds, String reason)
/*      */   {
/*  269 */     for (RankType rankType : )
/*      */     {
/*  271 */       addBanRank(roleId, rankType.getValue(), seconds, reason);
/*      */     }
/*  273 */     GameServer.logger().info(String.format("ban rank all|roleId=%d|seconds=%d|reason=%s", new Object[] { Long.valueOf(roleId), Long.valueOf(seconds), reason }));
/*  274 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void unbanRankObserver(long roleId, int rankType, long seconds)
/*      */   {
/*  286 */     Observer unbanRankObserver = new UnbanRankObserver(roleId, rankType, seconds);
/*  287 */     Map<Integer, Observer> commands = (Map)unbanRankObservers.get(Long.valueOf(roleId));
/*  288 */     if (commands == null)
/*      */     {
/*  290 */       commands = new HashMap();
/*  291 */       unbanRankObservers.put(Long.valueOf(roleId), commands);
/*      */     }
/*  293 */     Observer oldObserver = (Observer)commands.put(Integer.valueOf(rankType), unbanRankObserver);
/*  294 */     if (oldObserver != null)
/*      */     {
/*  296 */       oldObserver.stopTimer();
/*  297 */       oldObserver = null;
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void cancelUnbanRankObserver(long roleId, int rankType)
/*      */   {
/*  309 */     Map<Integer, Observer> commands = (Map)unbanRankObservers.get(Long.valueOf(roleId));
/*  310 */     if (commands == null)
/*      */     {
/*  312 */       return;
/*      */     }
/*  314 */     Observer oldObserver = (Observer)commands.remove(Integer.valueOf(rankType));
/*  315 */     if (oldObserver != null)
/*      */     {
/*  317 */       oldObserver.stopTimer();
/*  318 */       oldObserver = null;
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
/*      */   static void removeBanRank(long roleId, int rankType)
/*      */   {
/*  332 */     new PRemoveBanRank(roleId, rankType).execute();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void removeBanRankAll(long roleId)
/*      */   {
/*  342 */     for (int chartType = 0; chartType <= 14; chartType++)
/*      */     {
/*  344 */       removeBanRank(roleId, chartType);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   static class PRemoveBanRank
/*      */     extends LogicProcedure
/*      */   {
/*      */     private final long roleId;
/*      */     
/*      */ 
/*      */     private final int rankType;
/*      */     
/*      */ 
/*      */     public PRemoveBanRank(long roleId, int rankType)
/*      */     {
/*  361 */       this.rankType = rankType;
/*  362 */       this.roleId = roleId;
/*      */     }
/*      */     
/*      */ 
/*      */     protected boolean processImp()
/*      */       throws Exception
/*      */     {
/*  369 */       IdipConfigInfo xIdipConfigInfo = Idipconfig.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  370 */       if (xIdipConfigInfo == null)
/*      */       {
/*  372 */         return false;
/*      */       }
/*  374 */       if (xIdipConfigInfo.getRank_forbids().get(Long.valueOf(this.roleId)) == null)
/*      */       {
/*  376 */         return false;
/*      */       }
/*  378 */       if (((RoleRankForbid)xIdipConfigInfo.getRank_forbids().get(Long.valueOf(this.roleId))).getForbids().remove(Integer.valueOf(this.rankType)) == null)
/*      */       {
/*  380 */         return false;
/*      */       }
/*      */       
/*      */ 
/*  384 */       IdipManager.banRankLock.writeLock().lock();
/*      */       try
/*      */       {
/*  387 */         Map<Integer, IdipForbidData> rankForbidCache = (Map)IdipManager.banRankCacheMap.get(Long.valueOf(this.roleId));
/*  388 */         boolean bool; if (rankForbidCache == null)
/*      */         {
/*  390 */           return false;
/*      */         }
/*  392 */         if (rankForbidCache.remove(Integer.valueOf(this.rankType)) == null)
/*      */         {
/*  394 */           return false;
/*      */         }
/*      */       }
/*      */       finally
/*      */       {
/*  399 */         IdipManager.banRankLock.writeLock().unlock();
/*      */       }
/*      */       
/*      */ 
/*  403 */       IdipManager.cancelUnbanRankObserver(this.roleId, this.rankType);
/*      */       
/*  405 */       if (OnlineManager.getInstance().isOnline(this.roleId))
/*      */       {
/*      */ 
/*  408 */         IdipManager.sendUnbanRankMsg(this.roleId, this.rankType);
/*      */       }
/*      */       
/*  411 */       GameServer.logger().info(String.format("remove ban rank|roleId=%d|rankType=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.rankType) }));
/*      */       
/*      */ 
/*  414 */       IdipManager.addRoleRankAsync(this.roleId, this.rankType);
/*      */       
/*  416 */       return true;
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
/*      */   private static void addRoleRankAsync(long roleId, int rankType)
/*      */   {
/*  430 */     mzm.gsp.chart.main.RankInterface.addRoleRankForIDIP(roleId, rankType);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void sendBanRankMsg(long roleId, IdipForbidInfo xForbidInfo, int rankType)
/*      */   {
/*  442 */     SIdipBanRank sIdipBanRank = new SIdipBanRank();
/*  443 */     sIdipBanRank.ranktype = rankType;
/*      */     try
/*      */     {
/*  446 */       sIdipBanRank.reason.setString(xForbidInfo.getReason(), "UTF-8");
/*      */     }
/*      */     catch (UnsupportedEncodingException e) {}
/*      */     
/*      */ 
/*      */ 
/*  452 */     sIdipBanRank.unbantime = (xForbidInfo.getExpiretime() / 1000L);
/*  453 */     OnlineManager.getInstance().send(roleId, sIdipBanRank);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void sendUnbanRankMsg(long roleId, int rankType)
/*      */   {
/*  464 */     SIdipUnbanRank sIdipUnbanRank = new SIdipUnbanRank();
/*  465 */     sIdipUnbanRank.ranktype = rankType;
/*  466 */     OnlineManager.getInstance().send(roleId, sIdipUnbanRank);
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
/*      */   public static boolean isBanRank(long roleId, int rankType)
/*      */   {
/*  479 */     banRankLock.readLock().lock();
/*      */     try
/*      */     {
/*  482 */       Map<Integer, IdipForbidData> rankForbidCache = (Map)banRankCacheMap.get(Long.valueOf(roleId));
/*  483 */       boolean bool; if (rankForbidCache == null)
/*      */       {
/*  485 */         return false;
/*      */       }
/*  487 */       return rankForbidCache.containsKey(Integer.valueOf(rankType));
/*      */     }
/*      */     finally
/*      */     {
/*  491 */       banRankLock.readLock().unlock();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void zeroProfitInit()
/*      */   {
/*  500 */     IdipConfigInfo xIdipConfigInfo = Idipconfig.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  501 */     if (xIdipConfigInfo == null)
/*      */     {
/*  503 */       return;
/*      */     }
/*      */     
/*  506 */     zeroProfitLock.writeLock().lock();
/*      */     try
/*      */     {
/*  509 */       Map<Long, IdipForbidInfo> xZeroProfits = xIdipConfigInfo.getZero_profits();
/*  510 */       long now = DateTimeUtils.getCurrTimeInMillis();
/*  511 */       Iterator<Map.Entry<Long, IdipForbidInfo>> it = xZeroProfits.entrySet().iterator();
/*  512 */       while (it.hasNext())
/*      */       {
/*  514 */         Map.Entry<Long, IdipForbidInfo> entry = (Map.Entry)it.next();
/*  515 */         IdipForbidInfo xIdipForbidInfo = (IdipForbidInfo)entry.getValue();
/*  516 */         long roleId = ((Long)entry.getKey()).longValue();
/*  517 */         zeroProfitCacheMap.put(Long.valueOf(roleId), new IdipForbidData(xIdipForbidInfo));
/*      */         
/*  519 */         if (xIdipForbidInfo.getExpiretime() > now)
/*      */         {
/*  521 */           unbanZeroProfitObserver(roleId, (xIdipForbidInfo.getExpiretime() - now) / 1000L);
/*      */         }
/*      */       }
/*      */     }
/*      */     finally
/*      */     {
/*  527 */       zeroProfitLock.writeLock().unlock();
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
/*      */   static boolean addZeroProfit(long roleId, int seconds, String reason)
/*      */   {
/*  542 */     IdipConfigInfo xIdipConfigInfo = Idipconfig.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  543 */     if (xIdipConfigInfo == null)
/*      */     {
/*  545 */       xIdipConfigInfo = Pod.newIdipConfigInfo();
/*  546 */       Idipconfig.add(Long.valueOf(GameServerInfoManager.getLocalId()), xIdipConfigInfo);
/*      */     }
/*      */     
/*  549 */     IdipForbidInfo xIdipForbidInfo = (IdipForbidInfo)xIdipConfigInfo.getZero_profits().get(Long.valueOf(roleId));
/*  550 */     if (xIdipForbidInfo == null)
/*      */     {
/*  552 */       xIdipForbidInfo = Pod.newIdipForbidInfo();
/*  553 */       xIdipConfigInfo.getZero_profits().put(Long.valueOf(roleId), xIdipForbidInfo);
/*      */     }
/*  555 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*  556 */     long expireTime = TimeUnit.SECONDS.toMillis(seconds) + now;
/*  557 */     xIdipForbidInfo.setStarttime(now);
/*  558 */     xIdipForbidInfo.setExpiretime(expireTime);
/*  559 */     xIdipForbidInfo.setReason(reason);
/*      */     
/*      */ 
/*  562 */     zeroProfitLock.writeLock().lock();
/*      */     try
/*      */     {
/*  565 */       IdipForbidData idipForbidData = (IdipForbidData)zeroProfitCacheMap.get(Long.valueOf(roleId));
/*  566 */       if (idipForbidData == null)
/*      */       {
/*  568 */         idipForbidData = new IdipForbidData();
/*  569 */         zeroProfitCacheMap.put(Long.valueOf(roleId), idipForbidData);
/*      */       }
/*  571 */       idipForbidData.setStartTime(now);
/*  572 */       idipForbidData.setExpireTime(expireTime);
/*  573 */       idipForbidData.setReason(reason);
/*      */     }
/*      */     finally
/*      */     {
/*  577 */       zeroProfitLock.writeLock().unlock();
/*      */     }
/*      */     
/*      */ 
/*  581 */     unbanZeroProfitObserver(roleId, seconds);
/*      */     
/*  583 */     if (OnlineManager.getInstance().isOnline(roleId))
/*      */     {
/*  585 */       BuffInterface.installBuffAsyc(roleId, 701299000);
/*      */       
/*  587 */       sendAddZeroProfitMsg(roleId, xIdipForbidInfo);
/*      */     }
/*      */     
/*  590 */     GameServer.logger().info(String.format("add zero profit|roleId=%d|startTime=%d|seconds=%d|reason=%s", new Object[] { Long.valueOf(roleId), Long.valueOf(now), Integer.valueOf(seconds), reason }));
/*      */     
/*      */ 
/*  593 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void unbanZeroProfitObserver(long roleId, long seconds)
/*      */   {
/*  604 */     Observer observer = new UnbanZeroProfitObserver(roleId, seconds);
/*  605 */     zeroProfitObserverLock.lock();
/*      */     try
/*      */     {
/*  608 */       Observer oldObserver = (Observer)unbanZeroProfitObservers.put(Long.valueOf(roleId), observer);
/*  609 */       if (oldObserver != null)
/*      */       {
/*  611 */         oldObserver.stopTimer();
/*  612 */         oldObserver = null;
/*      */       }
/*      */     }
/*      */     finally
/*      */     {
/*  617 */       zeroProfitObserverLock.unlock();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void cancelUnbanZeroProfitObserver(long roleId)
/*      */   {
/*  628 */     zeroProfitObserverLock.lock();
/*      */     try
/*      */     {
/*  631 */       Observer oldObserver = (Observer)unbanZeroProfitObservers.remove(Long.valueOf(roleId));
/*  632 */       if (oldObserver != null)
/*      */       {
/*  634 */         oldObserver.stopTimer();
/*  635 */         oldObserver = null;
/*      */       }
/*      */     }
/*      */     finally
/*      */     {
/*  640 */       zeroProfitObserverLock.unlock();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void uninstallZeroProfitBuff(long roleId)
/*      */   {
/*  651 */     new PUninstallZeroProftBuff(roleId).execute();
/*      */   }
/*      */   
/*      */   private static class PUninstallZeroProftBuff
/*      */     extends LogicProcedure
/*      */   {
/*      */     private final long roleId;
/*      */     
/*      */     public PUninstallZeroProftBuff(long roleId)
/*      */     {
/*  661 */       this.roleId = roleId;
/*      */     }
/*      */     
/*      */     protected boolean processImp()
/*      */       throws Exception
/*      */     {
/*  667 */       IdipManager.cancelUnbanZeroProfitObserver(this.roleId);
/*      */       
/*      */ 
/*  670 */       BuffInterface.uninstallBufAsyc(this.roleId, 701299000);
/*  671 */       if (OnlineManager.getInstance().isOnline(this.roleId))
/*      */       {
/*      */ 
/*  674 */         IdipManager.sendRemoveZeroProfitMsg(this.roleId);
/*      */         
/*  676 */         IdipManager.removeZeroProfit(this.roleId);
/*      */       }
/*  678 */       GameServer.logger().info(String.format("uninstall zero profit buff|roleId=%d", new Object[] { Long.valueOf(this.roleId) }));
/*  679 */       return true;
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
/*      */   private static void removeZeroProfit(long roleId)
/*      */   {
/*  692 */     new PRemoveZeroProfit(roleId).execute();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private static class PRemoveZeroProfit
/*      */     extends LogicProcedure
/*      */   {
/*      */     private final long roleId;
/*      */     
/*      */ 
/*      */ 
/*      */     public PRemoveZeroProfit(long roleId)
/*      */     {
/*  707 */       this.roleId = roleId;
/*      */     }
/*      */     
/*      */ 
/*      */     protected boolean processImp()
/*      */       throws Exception
/*      */     {
/*  714 */       IdipConfigInfo xIdipConfigInfo = Idipconfig.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  715 */       if (xIdipConfigInfo == null)
/*      */       {
/*  717 */         return false;
/*      */       }
/*  719 */       if (xIdipConfigInfo.getZero_profits().remove(Long.valueOf(this.roleId)) == null)
/*      */       {
/*  721 */         return false;
/*      */       }
/*      */       
/*      */ 
/*  725 */       IdipManager.zeroProfitLock.writeLock().lock();
/*      */       try
/*      */       {
/*  728 */         if (IdipManager.zeroProfitCacheMap.remove(Long.valueOf(this.roleId)) == null)
/*      */         {
/*  730 */           return false;
/*      */         }
/*      */       }
/*      */       finally
/*      */       {
/*  735 */         IdipManager.zeroProfitLock.writeLock().unlock();
/*      */       }
/*      */       
/*  738 */       GameServer.logger().info(String.format("remove zero profit|roleId=%d", new Object[] { Long.valueOf(this.roleId) }));
/*  739 */       return true;
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
/*      */   public static long zeroProfitExpireTime(long roleId)
/*      */   {
/*  752 */     zeroProfitLock.readLock().lock();
/*      */     try
/*      */     {
/*  755 */       IdipForbidData info = (IdipForbidData)zeroProfitCacheMap.get(Long.valueOf(roleId));
/*  756 */       long l; if (info != null)
/*      */       {
/*  758 */         return info.getExpireTime();
/*      */       }
/*  760 */       return 0L;
/*      */     }
/*      */     finally
/*      */     {
/*  764 */       zeroProfitLock.readLock().unlock();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean isZeroProfit(long roleId)
/*      */   {
/*  776 */     long expireTime = zeroProfitExpireTime(roleId);
/*  777 */     if (expireTime == 0L)
/*      */     {
/*  779 */       return false;
/*      */     }
/*  781 */     if (expireTime > DateTimeUtils.getCurrTimeInMillis())
/*      */     {
/*  783 */       return true;
/*      */     }
/*  785 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void zeroProfitMsg(long roleId)
/*      */   {
/*  796 */     zeroProfitLock.readLock().lock();
/*      */     try
/*      */     {
/*  799 */       IdipForbidData info = (IdipForbidData)zeroProfitCacheMap.get(Long.valueOf(roleId));
/*  800 */       if ((info != null) && (info.getExpireTime() > DateTimeUtils.getCurrTimeInMillis()))
/*      */       {
/*  802 */         sendZeroProfitPromptMsg(roleId, info);
/*      */       }
/*      */     }
/*      */     finally
/*      */     {
/*  807 */       zeroProfitLock.readLock().unlock();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void checkZeroProfitLogin(long roleId)
/*      */   {
/*  818 */     long expireTime = zeroProfitExpireTime(roleId);
/*  819 */     if (expireTime == 0L)
/*      */     {
/*  821 */       return;
/*      */     }
/*      */     
/*  824 */     if (expireTime > DateTimeUtils.getCurrTimeInMillis())
/*      */     {
/*  826 */       BuffInterface.installBuffAsyc(roleId, 701299000);
/*      */ 
/*      */     }
/*      */     else
/*      */     {
/*  831 */       removeZeroProfit(roleId);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void checkZeroProfitLogoff(long roleId)
/*      */   {
/*  842 */     long expireTime = zeroProfitExpireTime(roleId);
/*  843 */     if (expireTime == 0L)
/*      */     {
/*  845 */       return;
/*      */     }
/*  847 */     BuffInterface.uninstallBuf(roleId, 701299000);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void relieveZeroProfit(long roleId)
/*      */   {
/*  858 */     new PRelieveProfit(roleId).execute();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private static class PRelieveProfit
/*      */     extends LogicProcedure
/*      */   {
/*      */     private final long roleId;
/*      */     
/*      */ 
/*      */ 
/*      */     public PRelieveProfit(long roleId)
/*      */     {
/*  873 */       this.roleId = roleId;
/*      */     }
/*      */     
/*      */ 
/*      */     protected boolean processImp()
/*      */       throws Exception
/*      */     {
/*  880 */       IdipConfigInfo xIdipConfigInfo = Idipconfig.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  881 */       if (xIdipConfigInfo == null)
/*      */       {
/*  883 */         return false;
/*      */       }
/*  885 */       IdipForbidInfo xIdipForbidInfo = (IdipForbidInfo)xIdipConfigInfo.getZero_profits().get(Long.valueOf(this.roleId));
/*  886 */       if (xIdipForbidInfo == null)
/*      */       {
/*  888 */         return false;
/*      */       }
/*  890 */       long now = DateTimeUtils.getCurrTimeInMillis();
/*  891 */       xIdipForbidInfo.setExpiretime(now);
/*      */       
/*      */ 
/*  894 */       IdipManager.zeroProfitLock.writeLock().lock();
/*      */       try
/*      */       {
/*  897 */         ((IdipForbidData)IdipManager.zeroProfitCacheMap.get(Long.valueOf(this.roleId))).setExpireTime(now);
/*      */       }
/*      */       finally
/*      */       {
/*  901 */         IdipManager.zeroProfitLock.writeLock().unlock();
/*      */       }
/*      */       
/*      */ 
/*  905 */       IdipManager.cancelUnbanZeroProfitObserver(this.roleId);
/*      */       
/*  907 */       if (OnlineManager.getInstance().isOnline(this.roleId))
/*      */       {
/*  909 */         BuffInterface.uninstallBufAsyc(this.roleId, 701299000);
/*      */         
/*  911 */         IdipManager.sendRemoveZeroProfitMsg(this.roleId);
/*      */       }
/*      */       
/*  914 */       GameServer.logger().info(String.format("relieve zero profit|roleId=%d", new Object[] { Long.valueOf(this.roleId) }));
/*  915 */       return true;
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
/*      */   private static void sendAddZeroProfitMsg(long roleId, IdipForbidInfo xForbidInfo)
/*      */   {
/*  928 */     SIdipAddZeroProfit sIdipAddZeroProfit = new SIdipAddZeroProfit();
/*      */     try
/*      */     {
/*  931 */       sIdipAddZeroProfit.reason.setString(xForbidInfo.getReason(), "UTF-8");
/*      */     }
/*      */     catch (UnsupportedEncodingException e) {}
/*      */     
/*      */ 
/*      */ 
/*  937 */     sIdipAddZeroProfit.unbantime = (xForbidInfo.getExpiretime() / 1000L);
/*  938 */     OnlineManager.getInstance().send(roleId, sIdipAddZeroProfit);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void sendZeroProfitPromptMsg(long roleId, IdipForbidData forbidData)
/*      */   {
/*  949 */     SIdipAddZeroProfit sIdipAddZeroProfit = new SIdipAddZeroProfit();
/*      */     try
/*      */     {
/*  952 */       sIdipAddZeroProfit.reason.setString(forbidData.getReason(), "UTF-8");
/*      */     }
/*      */     catch (UnsupportedEncodingException e) {}
/*      */     
/*      */ 
/*      */ 
/*  958 */     sIdipAddZeroProfit.unbantime = (forbidData.getExpireTime() / 1000L);
/*  959 */     OnlineManager.getInstance().send(roleId, sIdipAddZeroProfit);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void sendRemoveZeroProfitMsg(long roleId)
/*      */   {
/*  969 */     mzm.gsp.idip.SIdipRemoveProfit sIdipRemoveProfit = new mzm.gsp.idip.SIdipRemoveProfit();
/*  970 */     OnlineManager.getInstance().send(roleId, sIdipRemoveProfit);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void banPlayInit()
/*      */   {
/*  978 */     IdipConfigInfo xIdipConfigInfo = Idipconfig.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  979 */     if (xIdipConfigInfo == null)
/*      */     {
/*  981 */       return;
/*      */     }
/*      */     
/*  984 */     banPlayLock.writeLock().lock();
/*      */     try
/*      */     {
/*  987 */       long now = DateTimeUtils.getCurrTimeInMillis();
/*  988 */       Map<Long, RolePlayForbid> xPlayForbids = xIdipConfigInfo.getPlay_forbids();
/*  989 */       Iterator<Map.Entry<Long, RolePlayForbid>> playForbids = xPlayForbids.entrySet().iterator();
/*  990 */       while (playForbids.hasNext())
/*      */       {
/*  992 */         Map.Entry<Long, RolePlayForbid> roleForbidEntry = (Map.Entry)playForbids.next();
/*  993 */         long roleId = ((Long)roleForbidEntry.getKey()).longValue();
/*      */         
/*  995 */         Map<Integer, IdipForbidInfo> forbidsMap = ((RolePlayForbid)roleForbidEntry.getValue()).getForbids();
/*  996 */         Iterator<Map.Entry<Integer, IdipForbidInfo>> iterator = forbidsMap.entrySet().iterator();
/*  997 */         while (iterator.hasNext())
/*      */         {
/*  999 */           Map.Entry<Integer, IdipForbidInfo> forbidEntry = (Map.Entry)iterator.next();
/* 1000 */           IdipForbidInfo xIdipForbidInfo = (IdipForbidInfo)forbidEntry.getValue();
/* 1001 */           if (xIdipForbidInfo.getExpiretime() <= now)
/*      */           {
/* 1003 */             iterator.remove();
/*      */           }
/*      */           else
/*      */           {
/* 1007 */             int playType = ((Integer)forbidEntry.getKey()).intValue();
/* 1008 */             Map<Integer, IdipForbidData> playForbidCache = (Map)banPlayCacheMap.get(Long.valueOf(roleId));
/* 1009 */             if (playForbidCache == null)
/*      */             {
/* 1011 */               playForbidCache = new HashMap();
/* 1012 */               banPlayCacheMap.put(Long.valueOf(roleId), playForbidCache);
/*      */             }
/* 1014 */             playForbidCache.put(Integer.valueOf(playType), new IdipForbidData(xIdipForbidInfo));
/*      */             
/* 1016 */             unbanPlayObserver(roleId, playType, (xIdipForbidInfo.getExpiretime() - now) / 1000L);
/*      */           }
/*      */         }
/*      */         
/* 1020 */         if (forbidsMap.isEmpty())
/*      */         {
/* 1022 */           playForbids.remove();
/*      */         }
/*      */       }
/*      */     }
/*      */     finally
/*      */     {
/* 1028 */       banPlayLock.writeLock().unlock();
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
/*      */   static boolean addBanPlay(long roleId, int playType, int seconds, String reason)
/*      */   {
/* 1043 */     IdipConfigInfo xIdipConfigInfo = Idipconfig.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 1044 */     if (xIdipConfigInfo == null)
/*      */     {
/* 1046 */       xIdipConfigInfo = Pod.newIdipConfigInfo();
/* 1047 */       Idipconfig.add(Long.valueOf(GameServerInfoManager.getLocalId()), xIdipConfigInfo);
/*      */     }
/*      */     
/* 1050 */     RolePlayForbid xRolePlayForbid = (RolePlayForbid)xIdipConfigInfo.getPlay_forbids().get(Long.valueOf(roleId));
/* 1051 */     if (xRolePlayForbid == null)
/*      */     {
/* 1053 */       xRolePlayForbid = Pod.newRolePlayForbid();
/* 1054 */       xIdipConfigInfo.getPlay_forbids().put(Long.valueOf(roleId), xRolePlayForbid);
/*      */     }
/*      */     
/* 1057 */     IdipForbidInfo xIdipForbidInfo = (IdipForbidInfo)xRolePlayForbid.getForbids().get(Integer.valueOf(playType));
/* 1058 */     if (xIdipForbidInfo == null)
/*      */     {
/* 1060 */       xIdipForbidInfo = Pod.newIdipForbidInfo();
/* 1061 */       xRolePlayForbid.getForbids().put(Integer.valueOf(playType), xIdipForbidInfo);
/*      */     }
/* 1063 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 1064 */     long expireTime = TimeUnit.SECONDS.toMillis(seconds) + now;
/* 1065 */     xIdipForbidInfo.setStarttime(now);
/* 1066 */     xIdipForbidInfo.setExpiretime(expireTime);
/* 1067 */     xIdipForbidInfo.setReason(reason);
/*      */     
/*      */ 
/* 1070 */     banPlayLock.writeLock().lock();
/*      */     try
/*      */     {
/* 1073 */       Map<Integer, IdipForbidData> playForbidCache = (Map)banPlayCacheMap.get(Long.valueOf(roleId));
/* 1074 */       if (playForbidCache == null)
/*      */       {
/* 1076 */         playForbidCache = new HashMap();
/* 1077 */         banPlayCacheMap.put(Long.valueOf(roleId), playForbidCache);
/*      */       }
/* 1079 */       IdipForbidData idipForbidData = (IdipForbidData)playForbidCache.get(Integer.valueOf(playType));
/* 1080 */       if (idipForbidData == null)
/*      */       {
/* 1082 */         idipForbidData = new IdipForbidData();
/* 1083 */         playForbidCache.put(Integer.valueOf(playType), idipForbidData);
/*      */       }
/* 1085 */       idipForbidData.setStartTime(now);
/* 1086 */       idipForbidData.setExpireTime(expireTime);
/* 1087 */       idipForbidData.setReason(reason);
/*      */     }
/*      */     finally
/*      */     {
/* 1091 */       banPlayLock.writeLock().unlock();
/*      */     }
/*      */     
/*      */ 
/* 1095 */     BanPlay banPlayEvent = new BanPlay();
/* 1096 */     banPlayEvent.setSequential(true);
/* 1097 */     TriggerEventsManger.getInstance().triggerEvent(banPlayEvent, new mzm.gsp.idip.event.BanPlayArg(roleId, playType), RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(roleId)));
/*      */     
/*      */ 
/*      */ 
/* 1101 */     unbanPlayObserver(roleId, playType, seconds);
/*      */     
/* 1103 */     if (OnlineManager.getInstance().isOnline(roleId))
/*      */     {
/*      */ 
/* 1106 */       sendBanPlayMsg(roleId, xIdipForbidInfo, playType);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/* 1111 */     GameServer.logger().info(String.format("add ban play|roleId=%d|playType=%d|startTime=%d|seconds=%d|reason=%s", new Object[] { Long.valueOf(roleId), Integer.valueOf(playType), Long.valueOf(now), Integer.valueOf(seconds), reason }));
/*      */     
/*      */ 
/* 1114 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void unbanPlayObserver(long roleId, int playType, long seconds)
/*      */   {
/* 1126 */     Observer unbanPlayObserver = new UnbanPlayObserver(roleId, playType, seconds);
/* 1127 */     Map<Integer, Observer> commands = (Map)unbanPlayObservers.get(Long.valueOf(roleId));
/* 1128 */     if (commands == null)
/*      */     {
/* 1130 */       commands = new HashMap();
/* 1131 */       unbanPlayObservers.put(Long.valueOf(roleId), commands);
/*      */     }
/* 1133 */     Observer oldObserver = (Observer)commands.put(Integer.valueOf(playType), unbanPlayObserver);
/* 1134 */     if (oldObserver != null)
/*      */     {
/* 1136 */       oldObserver.stopTimer();
/* 1137 */       oldObserver = null;
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void cancelUnbanPlayObserver(long roleId, int playType)
/*      */   {
/* 1149 */     Map<Integer, Observer> commands = (Map)unbanPlayObservers.get(Long.valueOf(roleId));
/* 1150 */     if (commands == null)
/*      */     {
/* 1152 */       return;
/*      */     }
/* 1154 */     Observer oldObserver = (Observer)commands.remove(Integer.valueOf(playType));
/* 1155 */     if (oldObserver != null)
/*      */     {
/* 1157 */       oldObserver.stopTimer();
/* 1158 */       oldObserver = null;
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
/*      */   static boolean banPlayAll(long roleId, int seconds, String reason)
/*      */   {
/* 1172 */     for (int type = 0; type <= 592; type++)
/*      */     {
/* 1174 */       addBanPlay(roleId, type, seconds, reason);
/*      */     }
/* 1176 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void removeBanPlay(long roleId, int playType)
/*      */   {
/* 1188 */     new PRemoveBanPlay(roleId, playType).execute();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void removeBanPlayAll(long roleId)
/*      */   {
/* 1198 */     for (int type = 0; type <= 592; type++)
/*      */     {
/* 1200 */       removeBanPlay(roleId, type);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   static class PRemoveBanPlay
/*      */     extends LogicProcedure
/*      */   {
/*      */     private final long roleId;
/*      */     
/*      */ 
/*      */     private final int playType;
/*      */     
/*      */ 
/*      */     public PRemoveBanPlay(long roleId, int playType)
/*      */     {
/* 1217 */       this.roleId = roleId;
/* 1218 */       this.playType = playType;
/*      */     }
/*      */     
/*      */ 
/*      */     protected boolean processImp()
/*      */       throws Exception
/*      */     {
/* 1225 */       IdipConfigInfo xIdipConfigInfo = Idipconfig.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 1226 */       if (xIdipConfigInfo == null)
/*      */       {
/* 1228 */         return false;
/*      */       }
/* 1230 */       if (xIdipConfigInfo.getPlay_forbids().get(Long.valueOf(this.roleId)) == null)
/*      */       {
/* 1232 */         return false;
/*      */       }
/* 1234 */       if (((RolePlayForbid)xIdipConfigInfo.getPlay_forbids().get(Long.valueOf(this.roleId))).getForbids().remove(Integer.valueOf(this.playType)) == null)
/*      */       {
/* 1236 */         return false;
/*      */       }
/*      */       
/*      */ 
/* 1240 */       IdipManager.banPlayLock.writeLock().lock();
/*      */       try
/*      */       {
/* 1243 */         Map<Integer, IdipForbidData> playForbidCache = (Map)IdipManager.banPlayCacheMap.get(Long.valueOf(this.roleId));
/* 1244 */         boolean bool; if (playForbidCache == null)
/*      */         {
/* 1246 */           return false;
/*      */         }
/* 1248 */         if (playForbidCache.remove(Integer.valueOf(this.playType)) == null)
/*      */         {
/* 1250 */           return false;
/*      */         }
/*      */       }
/*      */       finally
/*      */       {
/* 1255 */         IdipManager.banPlayLock.writeLock().unlock();
/*      */       }
/*      */       
/*      */ 
/* 1259 */       UnbanPlay unbanPlayEvent = new UnbanPlay();
/* 1260 */       unbanPlayEvent.setSequential(true);
/* 1261 */       TriggerEventsManger.getInstance().triggerEvent(unbanPlayEvent, new mzm.gsp.idip.event.UnbanPlayArg(this.roleId, this.playType), RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.roleId)));
/*      */       
/*      */ 
/*      */ 
/* 1265 */       IdipManager.cancelUnbanPlayObserver(this.roleId, this.playType);
/*      */       
/* 1267 */       if (OnlineManager.getInstance().isOnline(this.roleId))
/*      */       {
/*      */ 
/* 1270 */         IdipManager.sendUnbanPlayMsg(this.roleId, this.playType);
/*      */       }
/*      */       
/* 1273 */       GameServer.logger().info(String.format("remove ban play|roleId=%d|playType=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.playType) }));
/*      */       
/* 1275 */       return true;
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
/*      */   public static void banPlayMsg(long roleId, int playType)
/*      */   {
/* 1289 */     banPlayLock.readLock().lock();
/*      */     try
/*      */     {
/* 1292 */       Map<Integer, IdipForbidData> playForbidCache = (Map)banPlayCacheMap.get(Long.valueOf(roleId));
/* 1293 */       if (playForbidCache == null) {
/*      */         return;
/*      */       }
/*      */       
/* 1297 */       IdipForbidData idipForbidData = (IdipForbidData)playForbidCache.get(Integer.valueOf(playType));
/* 1298 */       if (idipForbidData != null)
/*      */       {
/* 1300 */         sendBanPlayPromptMsg(roleId, idipForbidData, playType);
/*      */       }
/*      */     }
/*      */     finally
/*      */     {
/* 1305 */       banPlayLock.readLock().unlock();
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
/*      */   private static void sendBanPlayPromptMsg(long roleId, IdipForbidData idipForbidData, int playType)
/*      */   {
/* 1318 */     SIdipBanPlay sIdipBanPlay = new SIdipBanPlay();
/* 1319 */     sIdipBanPlay.playtype = playType;
/*      */     try
/*      */     {
/* 1322 */       sIdipBanPlay.reason.setString(idipForbidData.getReason(), "UTF-8");
/*      */     }
/*      */     catch (UnsupportedEncodingException e) {}
/*      */     
/*      */ 
/*      */ 
/* 1328 */     sIdipBanPlay.unbantime = (idipForbidData.getExpireTime() / 1000L);
/* 1329 */     OnlineManager.getInstance().sendAtOnce(roleId, sIdipBanPlay);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public static final int Chat_Map = 4;
/*      */   
/*      */ 
/*      */   public static final int Chat_World = 5;
/*      */   
/*      */ 
/*      */   public static final int Chat_Someone = 6;
/*      */   
/*      */ 
/*      */   public static final int Chat_In_Room = 7;
/*      */   
/*      */   public static void banPlayQueryMsg(long targetRoleId, long banRoleId, String banRoleName, int playType)
/*      */   {
/* 1347 */     banPlayLock.readLock().lock();
/*      */     try
/*      */     {
/* 1350 */       Map<Integer, IdipForbidData> playForbidCache = (Map)banPlayCacheMap.get(Long.valueOf(banRoleId));
/* 1351 */       if (playForbidCache == null) {
/*      */         return;
/*      */       }
/*      */       
/* 1355 */       IdipForbidData idipForbidData = (IdipForbidData)playForbidCache.get(Integer.valueOf(playType));
/* 1356 */       if (idipForbidData != null)
/*      */       {
/* 1358 */         sendBanPlayQueryMsg(targetRoleId, banRoleName, idipForbidData, playType);
/*      */       }
/*      */     }
/*      */     finally
/*      */     {
/* 1363 */       banPlayLock.readLock().unlock();
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
/*      */   private static void sendBanPlayQueryMsg(long roleId, String name, IdipForbidData idipForbidData, int playType)
/*      */   {
/* 1377 */     SIdipRoleBanPlayInfo roleBanPlayInfo = new SIdipRoleBanPlayInfo();
/* 1378 */     roleBanPlayInfo.playtype = playType;
/*      */     try
/*      */     {
/* 1381 */       roleBanPlayInfo.name.setString(name, "UTF-8");
/* 1382 */       roleBanPlayInfo.reason.setString(idipForbidData.getReason(), "UTF-8");
/*      */     }
/*      */     catch (UnsupportedEncodingException e) {}
/*      */     
/*      */ 
/*      */ 
/* 1388 */     roleBanPlayInfo.unbantime = (idipForbidData.getExpireTime() / 1000L);
/* 1389 */     OnlineManager.getInstance().sendAtOnce(roleId, roleBanPlayInfo);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void sendBanPlayMsg(long roleId, IdipForbidInfo xForbidInfo, int playType)
/*      */   {
/* 1401 */     SIdipBanPlay sIdipBanPlay = new SIdipBanPlay();
/* 1402 */     sIdipBanPlay.playtype = playType;
/*      */     try
/*      */     {
/* 1405 */       sIdipBanPlay.reason.setString(xForbidInfo.getReason(), "UTF-8");
/*      */     }
/*      */     catch (UnsupportedEncodingException e) {}
/*      */     
/*      */ 
/*      */ 
/* 1411 */     sIdipBanPlay.unbantime = (xForbidInfo.getExpiretime() / 1000L);
/* 1412 */     OnlineManager.getInstance().sendAtOnce(roleId, sIdipBanPlay);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void sendUnbanPlayMsg(long roleId, int playType)
/*      */   {
/* 1423 */     SIdipUnbanPlay sIdipUnbanPlay = new SIdipUnbanPlay();
/* 1424 */     sIdipUnbanPlay.playtype = playType;
/* 1425 */     OnlineManager.getInstance().send(roleId, sIdipUnbanPlay);
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
/*      */   public static boolean isBanPlay(long roleId, int playType)
/*      */   {
/* 1438 */     banPlayLock.readLock().lock();
/*      */     try
/*      */     {
/* 1441 */       Map<Integer, IdipForbidData> playForbidCache = (Map)banPlayCacheMap.get(Long.valueOf(roleId));
/* 1442 */       boolean bool; if (playForbidCache == null)
/*      */       {
/* 1444 */         return false;
/*      */       }
/* 1446 */       return playForbidCache.containsKey(Integer.valueOf(playType));
/*      */     }
/*      */     finally
/*      */     {
/* 1450 */       banPlayLock.readLock().unlock();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static final int Chat_In_Trumpet = 8;
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public static final int Chat_In_Friend = 9;
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public static final int CHAT_SEND_ADD_FRIEND_REQ = 101;
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public static final int CHAT_CHANGE_SIGN = 102;
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public static final int CHAT_SNS_RELEASE_ADVERT = 103;
/*      */   
/*      */ 
/*      */ 
/*      */   public static final int CHAT_REFUSE_ADD_FRIEND = 104;
/*      */   
/*      */ 
/*      */ 
/*      */   private static final String regEx = "[\t\r\n `~!@#$%^&*()+=|{}:;',//[//].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
/*      */   
/*      */ 
/*      */ 
/*      */   public static void chatTLog(long roleId, long gangId, long teamId, long strangerId, int type, Octets title, Octets content)
/*      */   {
/* 1492 */     if ((type >= 1) && (type <= 9))
/*      */     {
/* 1494 */       if (mzm.gsp.online.main.ForbidInfoManager.isForbidTalk(roleId))
/*      */       {
/* 1496 */         return;
/*      */       }
/*      */     }
/*      */     
/* 1500 */     StringBuilder tLogStr = new StringBuilder();
/*      */     
/* 1502 */     String userId = RoleInterface.getUserId(roleId);
/* 1503 */     String OpenID = Onlines.getInstance().findOpenid(userId);
/*      */     
/* 1505 */     tLogStr.append(OpenID).append('|');
/*      */     
/* 1507 */     tLogStr.append(roleId).append('|');
/* 1508 */     tLogStr.append(RoleInterface.getLevel(roleId)).append('|');
/* 1509 */     tLogStr.append(RoleInterface.getFightValue(roleId)).append('|');
/* 1510 */     tLogStr.append(gangId).append('|');
/* 1511 */     tLogStr.append(RoleInterface.getName(roleId)).append('|');
/*      */     
/* 1513 */     String sign = PersonalInterface.getSign(roleId, false);
/* 1514 */     if (sign.isEmpty())
/*      */     {
/* 1516 */       tLogStr.append(0).append('|');
/*      */     }
/*      */     else
/*      */     {
/* 1520 */       tLogStr.append(StringFilter(sign)).append('|');
/*      */     }
/* 1522 */     tLogStr.append(RoleInterface.getIpStr(roleId)).append('|');
/* 1523 */     tLogStr.append(teamId).append('|');
/*      */     
/* 1525 */     if (strangerId == 0L)
/*      */     {
/* 1527 */       tLogStr.append(0).append('|');
/* 1528 */       tLogStr.append(0).append('|');
/* 1529 */       tLogStr.append(0).append('|');
/* 1530 */       tLogStr.append(0).append('|');
/*      */     }
/*      */     else
/*      */     {
/* 1534 */       tLogStr.append(Onlines.getInstance().findOpenid(RoleInterface.getUserId(strangerId))).append('|');
/* 1535 */       tLogStr.append(strangerId).append('|');
/* 1536 */       tLogStr.append(RoleInterface.getLevel(strangerId)).append('|');
/* 1537 */       tLogStr.append(RoleInterface.getName(strangerId)).append('|');
/*      */     }
/*      */     
/* 1540 */     tLogStr.append(type).append('|');
/*      */     
/* 1542 */     if (title == null)
/*      */     {
/* 1544 */       tLogStr.append(0).append('|');
/*      */     }
/*      */     else
/*      */     {
/* 1548 */       tLogStr.append(StringFilter(title.getString("UTF-8"))).append('|');
/*      */     }
/*      */     
/* 1551 */     if (content == null)
/*      */     {
/* 1553 */       tLogStr.append(0).append('|');
/*      */     }
/*      */     else
/*      */     {
/* 1557 */       tLogStr.append(contentFilter(content.getString("UTF-8"))).append('|');
/*      */     }
/*      */     
/*      */ 
/* 1561 */     String picUrl = PersonalInterface.getHeadImageURL(roleId, false);
/* 1562 */     if (picUrl.isEmpty())
/*      */     {
/* 1564 */       tLogStr.append(0).append('|');
/*      */     }
/*      */     else
/*      */     {
/* 1568 */       tLogStr.append(picUrl).append('|');
/*      */     }
/*      */     
/* 1571 */     if ((type == 101) || (type == 104))
/*      */     {
/* 1573 */       tLogStr.append(FriendInterface.getApplyOthersCountToday(roleId, false)).append('|');
/* 1574 */       tLogStr.append(FriendInterface.getApplyOtherRefuseCountToday(roleId, false));
/*      */     }
/*      */     else
/*      */     {
/* 1578 */       tLogStr.append(0).append('|');
/* 1579 */       tLogStr.append(0);
/*      */     }
/*      */     
/* 1582 */     TLogManager.getInstance().addLogSec(roleId, "SecTalkFlow", tLogStr.toString());
/*      */   }
/*      */   
/*      */ 
/*      */ 
/* 1587 */   private static final Pattern p = Pattern.compile("[\t\r\n `~!@#$%^&*()+=|{}:;',//[//].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]");
/*      */   private static final String contentRegEx = "[{][a-z]+:.*?[}]";
/*      */   
/*      */   private static String StringFilter(String str) {
/* 1591 */     Matcher m = p.matcher(str);
/* 1592 */     String result = m.replaceAll("");
/* 1593 */     if (result.isEmpty())
/*      */     {
/* 1595 */       return "0";
/*      */     }
/* 1597 */     return result;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/* 1602 */   private static final Pattern pattern = Pattern.compile("[{][a-z]+:.*?[}]");
/*      */   public static final int ADD_BLACK = 1;
/*      */   public static final int REMOVE_BLACK = 2;
/*      */   
/* 1606 */   private static String contentFilter(String str) { Matcher m = pattern.matcher(str);
/* 1607 */     String result = m.replaceAll("").replaceAll("\\|", "");
/* 1608 */     if (result.isEmpty())
/*      */     {
/* 1610 */       return "0";
/*      */     }
/* 1612 */     return result;
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
/*      */   public static void addFriendTLogAsync(long roleid, String name, String picUrl, String info, String receiverOpenId, long receiverRoleId, long receiverRoleLevel, String receiverRoleName)
/*      */   {
/* 1630 */     new PAddFriendTLog(roleid, name, picUrl, info, receiverOpenId, receiverRoleId, receiverRoleLevel, receiverRoleName).execute();
/*      */   }
/*      */   
/*      */ 
/*      */   private static class PAddFriendTLog
/*      */     extends LogicProcedure
/*      */   {
/*      */     private final long roleid;
/*      */     private final String name;
/*      */     private final String picUrl;
/*      */     private final String info;
/*      */     private final String receiverOpenId;
/*      */     private final long receiverRoleId;
/*      */     private final long receiverRoleLevel;
/*      */     private final String receiverRoleName;
/*      */     
/*      */     public PAddFriendTLog(long roleid, String name, String picUrl, String info, String receiverOpenId, long receiverRoleId, long receiverRoleLevel, String receiverRoleName)
/*      */     {
/* 1648 */       this.roleid = roleid;
/* 1649 */       this.name = name;
/* 1650 */       this.picUrl = picUrl;
/* 1651 */       this.info = info;
/* 1652 */       this.receiverOpenId = receiverOpenId;
/* 1653 */       this.receiverRoleId = receiverRoleId;
/* 1654 */       this.receiverRoleLevel = receiverRoleLevel;
/* 1655 */       this.receiverRoleName = receiverRoleName;
/*      */     }
/*      */     
/*      */     protected boolean processImp()
/*      */       throws Exception
/*      */     {
/* 1661 */       StringBuilder tLogStr = new StringBuilder();
/*      */       
/* 1663 */       String userId = RoleInterface.getUserId(this.roleid);
/* 1664 */       String OpenID = Onlines.getInstance().findOpenid(userId);
/*      */       
/* 1666 */       tLogStr.append(OpenID).append('|');
/*      */       
/* 1668 */       tLogStr.append(this.roleid).append('|');
/* 1669 */       tLogStr.append(this.name).append('|');
/* 1670 */       tLogStr.append(this.picUrl).append('|');
/* 1671 */       tLogStr.append(IdipManager.StringFilter(this.info)).append('|');
/*      */       
/* 1673 */       tLogStr.append(this.receiverOpenId).append('|');
/* 1674 */       tLogStr.append(this.receiverRoleId).append('|');
/* 1675 */       tLogStr.append(this.receiverRoleLevel).append('|');
/* 1676 */       tLogStr.append(this.receiverRoleName);
/*      */       
/* 1678 */       TLogManager.getInstance().addLogSec(this.roleid, "SecPlayerAddFriend", tLogStr.toString());
/* 1679 */       return true;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void blackListTLogAsync(long roleId, long blackRoleId, int mode)
/*      */   {
/* 1698 */     new PBlackListTLog(roleId, blackRoleId, mode).execute();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private static class PBlackListTLog
/*      */     extends LogicProcedure
/*      */   {
/*      */     private final long roleId;
/*      */     
/*      */ 
/*      */     private final long blackRoleId;
/*      */     
/*      */     private final int mode;
/*      */     
/*      */ 
/*      */     public PBlackListTLog(long roleId, long blackRoleId, int mode)
/*      */     {
/* 1716 */       this.roleId = roleId;
/* 1717 */       this.blackRoleId = blackRoleId;
/* 1718 */       this.mode = mode;
/*      */     }
/*      */     
/*      */ 
/*      */     protected boolean processImp()
/*      */       throws Exception
/*      */     {
/* 1725 */       StringBuilder tLogStr = new StringBuilder();
/*      */       
/* 1727 */       String userId = RoleInterface.getUserId(this.roleId);
/* 1728 */       String OpenID = Onlines.getInstance().findOpenid(userId);
/*      */       
/* 1730 */       tLogStr.append(OpenID).append('|');
/*      */       
/* 1732 */       tLogStr.append(this.roleId).append('|');
/* 1733 */       tLogStr.append(RoleInterface.getName(this.roleId)).append('|');
/*      */       
/* 1735 */       String BlackUserId = RoleInterface.getUserId(this.blackRoleId);
/* 1736 */       String BlackOpenID = Onlines.getInstance().findOpenid(BlackUserId);
/* 1737 */       tLogStr.append(BlackOpenID).append('|');
/* 1738 */       tLogStr.append(RoleInterface.getName(this.blackRoleId)).append('|');
/* 1739 */       tLogStr.append(this.blackRoleId).append('|');
/*      */       
/* 1741 */       tLogStr.append(this.mode).append('|');
/*      */       
/*      */ 
/* 1744 */       String picUrl = PersonalInterface.getHeadImageURL(this.roleId, false);
/* 1745 */       if (picUrl.isEmpty())
/*      */       {
/* 1747 */         tLogStr.append(0);
/*      */       }
/*      */       else
/*      */       {
/* 1751 */         tLogStr.append(picUrl);
/*      */       }
/*      */       
/* 1754 */       TLogManager.getInstance().addLogSec(this.roleId, "SecBlackListFlow", tLogStr.toString());
/* 1755 */       return true;
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
/*      */   public static void secBattleTLog(long roleId, String logStr)
/*      */   {
/* 1768 */     String userId = RoleInterface.getUserId(roleId);
/* 1769 */     String OpenID = Onlines.getInstance().findOpenid(userId);
/*      */     
/* 1771 */     String log = String.format("%s|%s", new Object[] { OpenID, logStr });
/*      */     
/* 1773 */     TLogManager.getInstance().addLogSec(roleId, "SecBattleFlow", log);
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
/*      */ 
/*      */ 
/*      */   public static void baitanSellTLogAsync(long sellerRoleid, int itemId, int num, int price, Set<Long> uuids, long shoppingId, long lengthTime, int dealMainType, int dealSubType, int dealLevel)
/*      */   {
/* 1794 */     new PBaitanSellTLog(sellerRoleid, itemId, num, price, uuids, shoppingId, lengthTime, dealMainType, dealSubType, dealLevel).execute();
/*      */   }
/*      */   
/*      */ 
/*      */   private static class PBaitanSellTLog
/*      */     extends LogicProcedure
/*      */   {
/*      */     private final long roleId;
/*      */     
/*      */     private final int itemId;
/*      */     
/*      */     private final int num;
/*      */     
/*      */     private final int price;
/*      */     
/*      */     private final Set<Long> uuids;
/*      */     
/*      */     private final long shoppingId;
/*      */     
/*      */     private final String timeLimit;
/*      */     
/*      */     private final int dealMainType;
/*      */     private final int dealSubType;
/*      */     private final int dealLevel;
/*      */     
/*      */     public PBaitanSellTLog(long sellerRoleid, int itemId, int num, int price, Set<Long> uuids, long shoppingId, long lengthTime, int DealMainType, int DealSubType, int DealLevel)
/*      */     {
/* 1821 */       this.roleId = sellerRoleid;
/* 1822 */       this.itemId = itemId;
/* 1823 */       this.num = num;
/* 1824 */       this.price = price;
/* 1825 */       this.uuids = uuids;
/* 1826 */       this.shoppingId = shoppingId;
/*      */       
/* 1828 */       SimpleDateFormat sdf = DateTimeUtils.getSimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/* 1829 */       long time = DateTimeUtils.getCurrTimeInMillis();
/* 1830 */       this.timeLimit = sdf.format(Long.valueOf(time + TimeUnit.SECONDS.toMillis(lengthTime)));
/*      */       
/* 1832 */       this.dealMainType = DealMainType;
/* 1833 */       this.dealSubType = DealSubType;
/* 1834 */       this.dealLevel = DealLevel;
/*      */     }
/*      */     
/*      */     protected boolean processImp()
/*      */       throws Exception
/*      */     {
/* 1840 */       StringBuilder tLogStr = new StringBuilder();
/*      */       
/*      */ 
/* 1843 */       String userId = RoleInterface.getUserId(this.roleId);
/* 1844 */       String openId = Onlines.getInstance().findOpenid(userId);
/* 1845 */       tLogStr.append(openId).append('|');
/*      */       
/*      */ 
/* 1848 */       tLogStr.append(this.roleId).append('|');
/* 1849 */       tLogStr.append(RoleInterface.getOccupationId(this.roleId)).append('|');
/* 1850 */       tLogStr.append(RoleInterface.getLevel(this.roleId)).append('|');
/* 1851 */       tLogStr.append(RoleInterface.getIpStr(this.roleId)).append('|');
/*      */       
/*      */ 
/*      */ 
/* 1855 */       tLogStr.append(1).append('|');
/* 1856 */       tLogStr.append(this.shoppingId).append('|');
/*      */       
/* 1858 */       tLogStr.append(2).append('|');
/*      */       
/* 1860 */       tLogStr.append(this.dealMainType).append('|');
/* 1861 */       tLogStr.append(this.dealSubType).append('|');
/*      */       
/* 1863 */       tLogStr.append(3).append('|');
/* 1864 */       tLogStr.append(this.price).append('|');
/* 1865 */       tLogStr.append(this.num).append('|');
/* 1866 */       tLogStr.append(this.itemId).append('|');
/*      */       
/* 1868 */       if (this.uuids.size() == 0)
/*      */       {
/* 1870 */         tLogStr.append(0).append('|');
/*      */       }
/*      */       else
/*      */       {
/* 1874 */         StringBuilder uuidStringBuilder = new StringBuilder();
/* 1875 */         for (Iterator i$ = this.uuids.iterator(); i$.hasNext();) { long uuid = ((Long)i$.next()).longValue();
/*      */           
/* 1877 */           uuidStringBuilder.append(uuid).append(',');
/*      */         }
/* 1879 */         tLogStr.append(uuidStringBuilder.substring(0, uuidStringBuilder.length() - 1)).append('|');
/*      */       }
/*      */       
/* 1882 */       tLogStr.append(this.dealLevel).append('|');
/* 1883 */       tLogStr.append(ItemInterface.getColor(this.itemId)).append('|');
/* 1884 */       tLogStr.append(this.timeLimit).append('|');
/*      */       
/*      */ 
/* 1887 */       String picUrl = PersonalInterface.getHeadImageURL(this.roleId, false);
/* 1888 */       if (picUrl.isEmpty())
/*      */       {
/* 1890 */         tLogStr.append(0);
/*      */       }
/*      */       else
/*      */       {
/* 1894 */         tLogStr.append(picUrl);
/*      */       }
/*      */       
/* 1897 */       TLogManager.getInstance().addLogSec(this.roleId, "SecBusinessShopShowFlow", tLogStr.toString());
/* 1898 */       return true;
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
/*      */   public static void baitanBuyTLogAsync(long buyerRoleId, long sellerRoleId, int itemId, int num, int price, Set<Long> uuids, long shoppingId, int dealMainType, int dealSubType, int dealLevel)
/*      */   {
/* 1925 */     new PBaitanBuyTLog(buyerRoleId, sellerRoleId, itemId, num, price, uuids, shoppingId, dealMainType, dealSubType, dealLevel).execute();
/*      */   }
/*      */   
/*      */ 
/*      */   private static class PBaitanBuyTLog
/*      */     extends LogicProcedure
/*      */   {
/*      */     private final long buyerRoleId;
/*      */     
/*      */     private final long sellerRoleId;
/*      */     
/*      */     private final int itemId;
/*      */     
/*      */     private final int num;
/*      */     
/*      */     private final int price;
/*      */     
/*      */     private final Set<Long> uuids;
/*      */     
/*      */     private final long shoppingId;
/*      */     
/*      */     private final int dealMainType;
/*      */     private final int dealSubType;
/*      */     private final int dealLevel;
/*      */     
/*      */     public PBaitanBuyTLog(long buyerRoleId, long sellerRoleId, int itemId, int num, int price, Set<Long> uuids, long shoppingId, int DealMainType, int DealSubType, int DealLevel)
/*      */     {
/* 1952 */       this.buyerRoleId = buyerRoleId;
/* 1953 */       this.sellerRoleId = sellerRoleId;
/* 1954 */       this.itemId = itemId;
/* 1955 */       this.num = num;
/* 1956 */       this.price = price;
/* 1957 */       this.uuids = uuids;
/* 1958 */       this.shoppingId = shoppingId;
/* 1959 */       this.dealMainType = DealMainType;
/* 1960 */       this.dealSubType = DealSubType;
/* 1961 */       this.dealLevel = DealLevel;
/*      */     }
/*      */     
/*      */     protected boolean processImp()
/*      */       throws Exception
/*      */     {
/* 1967 */       StringBuilder tLogStr = new StringBuilder();
/*      */       
/*      */ 
/* 1970 */       if (this.buyerRoleId == 0L)
/*      */       {
/*      */ 
/* 1973 */         tLogStr.append(0).append('|');
/*      */         
/* 1975 */         tLogStr.append(0).append('|');
/* 1976 */         tLogStr.append(0).append('|');
/* 1977 */         tLogStr.append(0).append('|');
/* 1978 */         tLogStr.append(0).append('|');
/* 1979 */         tLogStr.append(0).append('|');
/* 1980 */         tLogStr.append(0).append('|');
/*      */       }
/*      */       else
/*      */       {
/* 1984 */         String BuyerRoleUid = RoleInterface.getUserId(this.buyerRoleId);
/* 1985 */         String BuyerOpenID = Onlines.getInstance().findOpenid(BuyerRoleUid);
/*      */         
/*      */ 
/* 1988 */         tLogStr.append(BuyerOpenID).append('|');
/*      */         
/* 1990 */         tLogStr.append(BuyerOpenID).append('|');
/* 1991 */         tLogStr.append(this.buyerRoleId).append('|');
/* 1992 */         tLogStr.append(RoleInterface.getOccupationId(this.buyerRoleId)).append('|');
/* 1993 */         tLogStr.append(RoleInterface.getLevel(this.buyerRoleId)).append('|');
/* 1994 */         tLogStr.append(RoleInterface.getFightValue(this.buyerRoleId)).append('|');
/* 1995 */         tLogStr.append(RoleInterface.getIpStr(this.buyerRoleId)).append('|');
/*      */       }
/*      */       
/*      */ 
/* 1999 */       if (this.sellerRoleId == 0L)
/*      */       {
/* 2001 */         tLogStr.append(0).append('|');
/* 2002 */         tLogStr.append(0).append('|');
/* 2003 */         tLogStr.append(0).append('|');
/* 2004 */         tLogStr.append(0).append('|');
/* 2005 */         tLogStr.append(0).append('|');
/* 2006 */         tLogStr.append(0).append('|');
/*      */       }
/*      */       else
/*      */       {
/* 2010 */         String SellerRoleUid = RoleInterface.getUserId(this.sellerRoleId);
/* 2011 */         String SellerOpenID = Onlines.getInstance().findOpenid(SellerRoleUid);
/* 2012 */         tLogStr.append(SellerOpenID).append('|');
/* 2013 */         tLogStr.append(this.sellerRoleId).append('|');
/* 2014 */         tLogStr.append(RoleInterface.getOccupationId(this.sellerRoleId)).append('|');
/* 2015 */         tLogStr.append(RoleInterface.getLevel(this.sellerRoleId)).append('|');
/* 2016 */         tLogStr.append(RoleInterface.getFightValue(this.sellerRoleId)).append('|');
/* 2017 */         tLogStr.append(RoleInterface.getIpStr(this.sellerRoleId)).append('|');
/*      */       }
/*      */       
/*      */ 
/*      */ 
/* 2022 */       tLogStr.append(1).append('|');
/* 2023 */       tLogStr.append(this.shoppingId).append('|');
/*      */       
/* 2025 */       tLogStr.append(2).append('|');
/*      */       
/* 2027 */       tLogStr.append(this.dealMainType).append('|');
/* 2028 */       tLogStr.append(this.dealSubType).append('|');
/*      */       
/* 2030 */       tLogStr.append(3).append('|');
/* 2031 */       tLogStr.append(this.price).append('|');
/* 2032 */       tLogStr.append(this.num).append('|');
/* 2033 */       tLogStr.append(this.itemId).append('|');
/*      */       
/* 2035 */       if (this.uuids.size() == 0)
/*      */       {
/* 2037 */         tLogStr.append(0).append('|');
/*      */       }
/*      */       else
/*      */       {
/* 2041 */         StringBuilder uuidStringBuilder = new StringBuilder();
/* 2042 */         for (Iterator i$ = this.uuids.iterator(); i$.hasNext();) { long uuid = ((Long)i$.next()).longValue();
/*      */           
/* 2044 */           uuidStringBuilder.append(uuid).append(',');
/*      */         }
/* 2046 */         tLogStr.append(uuidStringBuilder.substring(0, uuidStringBuilder.length() - 1)).append('|');
/*      */       }
/*      */       
/* 2049 */       tLogStr.append(this.dealLevel).append('|');
/* 2050 */       tLogStr.append(ItemInterface.getColor(this.itemId)).append('|');
/*      */       
/*      */ 
/* 2053 */       String picUrl = PersonalInterface.getHeadImageURL(this.buyerRoleId, false);
/* 2054 */       if (picUrl.isEmpty())
/*      */       {
/* 2056 */         tLogStr.append(0);
/*      */       }
/*      */       else
/*      */       {
/* 2060 */         tLogStr.append(picUrl);
/*      */       }
/*      */       
/* 2063 */       TLogManager.getInstance().addLogSec(this.buyerRoleId, "SecBusinessShopDealFlow", tLogStr.toString());
/*      */       
/* 2065 */       return true;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void marketSellTLogAsync(long sellerRoleid, int itemId, int num, int price, Set<Long> uuids, long shoppingId, long lengthTime, int dealMainType, int dealSubType, int level, int productType, int quality)
/*      */   {
/* 2089 */     new PMarketSellTLog(sellerRoleid, itemId, num, price, uuids, shoppingId, lengthTime, dealMainType, dealSubType, level, productType, quality).execute();
/*      */   }
/*      */   
/*      */ 
/*      */   private static class PMarketSellTLog
/*      */     extends LogicProcedure
/*      */   {
/*      */     private final long sellerRoleId;
/*      */     
/*      */     private final int itemId;
/*      */     
/*      */     private final long shoppingId;
/*      */     
/*      */     private final int num;
/*      */     
/*      */     private final int price;
/*      */     
/*      */     private final Set<Long> uuids;
/*      */     
/*      */     private final int dealMainType;
/*      */     
/*      */     private final int dealSubType;
/*      */     private final int level;
/*      */     private final String timeLimit;
/*      */     private final int productType;
/*      */     private final int quality;
/*      */     
/*      */     public PMarketSellTLog(long sellerRoleId, int itemId, int num, int price, Set<Long> uuids, long shoppingId, long lengthTime, int DealMainType, int DealSubType, int itemLevel, int productType, int quality)
/*      */     {
/* 2118 */       this.sellerRoleId = sellerRoleId;
/* 2119 */       this.itemId = itemId;
/* 2120 */       this.num = num;
/* 2121 */       this.price = price;
/* 2122 */       this.uuids = uuids;
/* 2123 */       this.shoppingId = shoppingId;
/* 2124 */       this.dealMainType = DealMainType;
/* 2125 */       this.dealSubType = DealSubType;
/* 2126 */       this.level = itemLevel;
/*      */       
/* 2128 */       SimpleDateFormat sdf = DateTimeUtils.getSimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/* 2129 */       long time = DateTimeUtils.getCurrTimeInMillis();
/* 2130 */       this.timeLimit = sdf.format(Long.valueOf(time + TimeUnit.SECONDS.toMillis(lengthTime)));
/*      */       
/* 2132 */       this.productType = productType;
/* 2133 */       this.quality = quality;
/*      */     }
/*      */     
/*      */     protected boolean processImp()
/*      */       throws Exception
/*      */     {
/* 2139 */       StringBuilder tLogStr = new StringBuilder();
/*      */       
/*      */ 
/*      */ 
/* 2143 */       if (this.sellerRoleId <= 0L)
/*      */       {
/* 2145 */         tLogStr.append(0).append('|');
/*      */         
/* 2147 */         tLogStr.append(0).append('|');
/* 2148 */         tLogStr.append(0).append('|');
/* 2149 */         tLogStr.append(0).append('|');
/* 2150 */         tLogStr.append(0).append('|');
/*      */       }
/*      */       else
/*      */       {
/* 2154 */         String userId = RoleInterface.getUserId(this.sellerRoleId);
/* 2155 */         String openID = Onlines.getInstance().findOpenid(userId);
/* 2156 */         tLogStr.append(openID).append('|');
/*      */         
/* 2158 */         tLogStr.append(this.sellerRoleId).append('|');
/* 2159 */         tLogStr.append(RoleInterface.getOccupationId(this.sellerRoleId)).append('|');
/* 2160 */         tLogStr.append(RoleInterface.getLevel(this.sellerRoleId)).append('|');
/* 2161 */         tLogStr.append(RoleInterface.getIpStr(this.sellerRoleId)).append('|');
/*      */       }
/*      */       
/*      */ 
/*      */ 
/* 2166 */       tLogStr.append(2).append('|');
/* 2167 */       tLogStr.append(this.shoppingId).append('|');
/*      */       
/* 2169 */       tLogStr.append(this.productType).append('|');
/*      */       
/* 2171 */       tLogStr.append(this.dealMainType).append('|');
/* 2172 */       tLogStr.append(this.dealSubType).append('|');
/*      */       
/* 2174 */       tLogStr.append(2).append('|');
/* 2175 */       tLogStr.append(this.price).append('|');
/* 2176 */       tLogStr.append(this.num).append('|');
/* 2177 */       tLogStr.append(this.itemId).append('|');
/*      */       
/* 2179 */       if (this.uuids.size() == 0)
/*      */       {
/* 2181 */         tLogStr.append(0).append('|');
/*      */       }
/*      */       else
/*      */       {
/* 2185 */         StringBuilder uuidStringBuilder = new StringBuilder();
/* 2186 */         for (Iterator i$ = this.uuids.iterator(); i$.hasNext();) { long uuid = ((Long)i$.next()).longValue();
/*      */           
/* 2188 */           uuidStringBuilder.append(uuid).append(',');
/*      */         }
/* 2190 */         tLogStr.append(uuidStringBuilder.substring(0, uuidStringBuilder.length() - 1)).append('|');
/*      */       }
/*      */       
/* 2193 */       tLogStr.append(this.level).append('|');
/* 2194 */       tLogStr.append(this.quality).append('|');
/* 2195 */       tLogStr.append(this.timeLimit).append('|');
/*      */       
/*      */ 
/* 2198 */       if (this.sellerRoleId > 0L)
/*      */       {
/* 2200 */         String picUrl = PersonalInterface.getHeadImageURL(this.sellerRoleId, false);
/* 2201 */         if (picUrl.isEmpty())
/*      */         {
/* 2203 */           tLogStr.append(0);
/*      */         }
/*      */         else
/*      */         {
/* 2207 */           tLogStr.append(picUrl);
/*      */         }
/*      */       }
/*      */       else
/*      */       {
/* 2212 */         tLogStr.append(0);
/*      */       }
/*      */       
/* 2215 */       TLogManager.getInstance().addLogSec(this.sellerRoleId, "SecBusinessShopShowFlow", tLogStr.toString());
/*      */       
/* 2217 */       return true;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void marketBuyTLogAsync(long buyerRoleId, long sellerRoleId, int itemId, int num, int price, Set<Long> uuids, long shoppingId, int dealMainType, int dealSubType, int level, int productType, int quality)
/*      */   {
/* 2241 */     new PMarketBuyTLog(buyerRoleId, sellerRoleId, itemId, num, price, uuids, shoppingId, dealMainType, dealSubType, level, productType, quality).execute();
/*      */   }
/*      */   
/*      */ 
/*      */   private static class PMarketBuyTLog
/*      */     extends LogicProcedure
/*      */   {
/*      */     private final long buyerRoleId;
/*      */     
/*      */     private final long sellerRoleId;
/*      */     
/*      */     private final int itemId;
/*      */     
/*      */     private final int num;
/*      */     
/*      */     private final int price;
/*      */     
/*      */     private final Set<Long> uuids;
/*      */     
/*      */     private final long shoppingId;
/*      */     
/*      */     private final int dealMainType;
/*      */     private final int dealSubType;
/*      */     private final int level;
/*      */     private final int productType;
/*      */     private final int quality;
/*      */     
/*      */     public PMarketBuyTLog(long buyerRoleId, long sellerRoleId, int itemId, int num, int price, Set<Long> uuids, long shoppingId, int dealMainType, int dealSubType, int level, int productType, int quality)
/*      */     {
/* 2270 */       this.buyerRoleId = buyerRoleId;
/* 2271 */       this.sellerRoleId = sellerRoleId;
/* 2272 */       this.itemId = itemId;
/* 2273 */       this.num = num;
/* 2274 */       this.price = price;
/* 2275 */       this.uuids = uuids;
/* 2276 */       this.shoppingId = shoppingId;
/* 2277 */       this.dealMainType = dealMainType;
/* 2278 */       this.dealSubType = dealSubType;
/* 2279 */       this.level = level;
/* 2280 */       this.productType = productType;
/* 2281 */       this.quality = quality;
/*      */     }
/*      */     
/*      */     protected boolean processImp()
/*      */       throws Exception
/*      */     {
/* 2287 */       StringBuilder tLogStr = new StringBuilder();
/*      */       
/*      */ 
/* 2290 */       if (this.buyerRoleId <= 0L)
/*      */       {
/*      */ 
/* 2293 */         tLogStr.append(0).append('|');
/*      */         
/* 2295 */         tLogStr.append(0).append('|');
/* 2296 */         tLogStr.append(0).append('|');
/* 2297 */         tLogStr.append(0).append('|');
/* 2298 */         tLogStr.append(0).append('|');
/* 2299 */         tLogStr.append(0).append('|');
/* 2300 */         tLogStr.append(0).append('|');
/*      */       }
/*      */       else
/*      */       {
/* 2304 */         String BuyerUserId = RoleInterface.getUserId(this.buyerRoleId);
/* 2305 */         String BuyerOpenID = Onlines.getInstance().findOpenid(BuyerUserId);
/* 2306 */         tLogStr.append(BuyerOpenID).append('|');
/*      */         
/*      */ 
/* 2309 */         tLogStr.append(BuyerOpenID).append('|');
/* 2310 */         tLogStr.append(this.buyerRoleId).append('|');
/* 2311 */         tLogStr.append(RoleInterface.getOccupationId(this.buyerRoleId)).append('|');
/* 2312 */         tLogStr.append(RoleInterface.getLevel(this.buyerRoleId)).append('|');
/* 2313 */         tLogStr.append(RoleInterface.getFightValue(this.buyerRoleId)).append('|');
/* 2314 */         tLogStr.append(RoleInterface.getIpStr(this.buyerRoleId)).append('|');
/*      */       }
/*      */       
/*      */ 
/* 2318 */       if (this.sellerRoleId <= 0L)
/*      */       {
/* 2320 */         tLogStr.append(0).append('|');
/* 2321 */         tLogStr.append(0).append('|');
/* 2322 */         tLogStr.append(0).append('|');
/* 2323 */         tLogStr.append(0).append('|');
/* 2324 */         tLogStr.append(0).append('|');
/* 2325 */         tLogStr.append(0).append('|');
/*      */       }
/*      */       else
/*      */       {
/* 2329 */         String SellerUserId = RoleInterface.getUserId(this.sellerRoleId);
/* 2330 */         String SellerOpenID = Onlines.getInstance().findOpenid(SellerUserId);
/* 2331 */         tLogStr.append(SellerOpenID).append('|');
/* 2332 */         tLogStr.append(this.sellerRoleId).append('|');
/* 2333 */         tLogStr.append(RoleInterface.getOccupationId(this.sellerRoleId)).append('|');
/* 2334 */         tLogStr.append(RoleInterface.getLevel(this.sellerRoleId)).append('|');
/* 2335 */         tLogStr.append(RoleInterface.getFightValue(this.sellerRoleId)).append('|');
/* 2336 */         tLogStr.append(RoleInterface.getIpStr(this.sellerRoleId)).append('|');
/*      */       }
/*      */       
/*      */ 
/*      */ 
/* 2341 */       tLogStr.append(2).append('|');
/* 2342 */       tLogStr.append(this.shoppingId).append('|');
/*      */       
/* 2344 */       tLogStr.append(this.productType).append('|');
/*      */       
/* 2346 */       tLogStr.append(this.dealMainType).append('|');
/* 2347 */       tLogStr.append(this.dealSubType).append('|');
/*      */       
/* 2349 */       tLogStr.append(4).append('|');
/* 2350 */       tLogStr.append(this.price).append('|');
/* 2351 */       tLogStr.append(this.num).append('|');
/* 2352 */       tLogStr.append(this.itemId).append('|');
/*      */       
/* 2354 */       if (this.uuids.size() == 0)
/*      */       {
/* 2356 */         tLogStr.append(0).append('|');
/*      */       }
/*      */       else
/*      */       {
/* 2360 */         StringBuilder uuidStringBuilder = new StringBuilder();
/* 2361 */         for (Iterator i$ = this.uuids.iterator(); i$.hasNext();) { long uuid = ((Long)i$.next()).longValue();
/*      */           
/* 2363 */           uuidStringBuilder.append(uuid).append(',');
/*      */         }
/* 2365 */         tLogStr.append(uuidStringBuilder.substring(0, uuidStringBuilder.length() - 1)).append('|');
/*      */       }
/*      */       
/* 2368 */       tLogStr.append(this.level).append('|');
/* 2369 */       tLogStr.append(this.quality).append('|');
/*      */       
/*      */ 
/* 2372 */       if (this.buyerRoleId > 0L)
/*      */       {
/* 2374 */         String picUrl = PersonalInterface.getHeadImageURL(this.buyerRoleId, false);
/* 2375 */         if (picUrl.isEmpty())
/*      */         {
/* 2377 */           tLogStr.append(0);
/*      */         }
/*      */         else
/*      */         {
/* 2381 */           tLogStr.append(picUrl);
/*      */         }
/*      */       }
/*      */       else
/*      */       {
/* 2386 */         tLogStr.append(0);
/*      */       }
/*      */       
/* 2389 */       TLogManager.getInstance().addLogSec(this.buyerRoleId, "SecBusinessShopDealFlow", tLogStr.toString());
/*      */       
/* 2391 */       return true;
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
/*      */   public static void giveItemTLogAsync(long giveRoleid, long receiveRoleid, Map<Integer, Set<Long>> itemId2uuids)
/*      */   {
/* 2404 */     new PGiveItemTLog(giveRoleid, receiveRoleid, itemId2uuids).execute();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private static class PGiveItemTLog
/*      */     extends LogicProcedure
/*      */   {
/*      */     private final long roleId;
/*      */     
/*      */ 
/*      */     private final long receiveRoleId;
/*      */     
/*      */     private final Map<Integer, Set<Long>> itemId2uuids;
/*      */     
/*      */ 
/*      */     public PGiveItemTLog(long roleId, long recevieRoleId, Map<Integer, Set<Long>> itemId2uuids)
/*      */     {
/* 2422 */       this.roleId = roleId;
/* 2423 */       this.receiveRoleId = recevieRoleId;
/* 2424 */       this.itemId2uuids = itemId2uuids;
/*      */     }
/*      */     
/*      */     protected boolean processImp()
/*      */       throws Exception
/*      */     {
/* 2430 */       StringBuilder logStr = new StringBuilder();
/*      */       
/*      */ 
/* 2433 */       String InviteUserId = RoleInterface.getUserId(this.roleId);
/* 2434 */       String InviteOpenID = Onlines.getInstance().findOpenid(InviteUserId);
/* 2435 */       logStr.append(InviteOpenID).append('|');
/* 2436 */       logStr.append(this.roleId).append('|');
/* 2437 */       logStr.append(RoleInterface.getOccupationId(this.roleId)).append('|');
/* 2438 */       logStr.append(RoleInterface.getLevel(this.roleId)).append('|');
/* 2439 */       logStr.append(RoleInterface.getFightValue(this.roleId)).append('|');
/* 2440 */       logStr.append(RoleInterface.getIpStr(this.roleId)).append('|');
/*      */       
/*      */ 
/* 2443 */       if (this.itemId2uuids.size() > 0)
/*      */       {
/* 2445 */         StringBuilder itemIds = new StringBuilder();
/* 2446 */         StringBuilder itemNums = new StringBuilder();
/* 2447 */         StringBuilder itemUUIDs = new StringBuilder();
/* 2448 */         StringBuilder itemLevels = new StringBuilder();
/* 2449 */         StringBuilder itemQualitys = new StringBuilder();
/* 2450 */         for (Map.Entry<Integer, Set<Long>> entry : this.itemId2uuids.entrySet())
/*      */         {
/* 2452 */           int itemid = ((Integer)entry.getKey()).intValue();
/* 2453 */           itemIds.append(itemid).append(',');
/* 2454 */           itemLevels.append(ItemInterface.getUseLevel(itemid)).append(',');
/* 2455 */           itemQualitys.append(ItemInterface.getColor(itemid)).append(',');
/*      */           
/* 2457 */           Set<Long> uuids = (Set)entry.getValue();
/* 2458 */           itemNums.append(uuids.size()).append(',');
/* 2459 */           for (i$ = uuids.iterator(); i$.hasNext();) { long uuid = ((Long)i$.next()).longValue();
/*      */             
/* 2461 */             itemUUIDs.append(uuid).append(',');
/*      */           } }
/*      */         Iterator i$;
/* 2464 */         logStr.append(itemIds.substring(0, itemIds.length() - 1)).append('|');
/* 2465 */         logStr.append(itemNums.substring(0, itemNums.length() - 1)).append('|');
/* 2466 */         logStr.append(itemUUIDs.substring(0, itemUUIDs.length() - 1)).append('|');
/* 2467 */         logStr.append(itemLevels.substring(0, itemLevels.length() - 1)).append('|');
/* 2468 */         logStr.append(itemQualitys.substring(0, itemQualitys.length() - 1)).append('|');
/*      */       }
/*      */       else
/*      */       {
/* 2472 */         logStr.append(0).append('|');
/* 2473 */         logStr.append(0).append('|');
/* 2474 */         logStr.append(0).append('|');
/* 2475 */         logStr.append(0).append('|');
/* 2476 */         logStr.append(0).append('|');
/*      */       }
/*      */       
/*      */ 
/* 2480 */       logStr.append(0).append('|');
/*      */       
/* 2482 */       logStr.append(0).append('|');
/*      */       
/* 2484 */       logStr.append(0).append('|');
/*      */       
/*      */ 
/* 2487 */       String AcceptUserId = RoleInterface.getUserId(this.receiveRoleId);
/* 2488 */       String AcceptOpenID = Onlines.getInstance().findOpenid(AcceptUserId);
/* 2489 */       logStr.append(AcceptOpenID).append('|');
/* 2490 */       logStr.append(this.receiveRoleId).append('|');
/* 2491 */       logStr.append(RoleInterface.getOccupationId(this.receiveRoleId)).append('|');
/* 2492 */       logStr.append(RoleInterface.getLevel(this.receiveRoleId)).append('|');
/* 2493 */       logStr.append(RoleInterface.getFightValue(this.receiveRoleId)).append('|');
/* 2494 */       logStr.append(RoleInterface.getIpStr(this.receiveRoleId)).append('|');
/*      */       
/*      */ 
/* 2497 */       logStr.append(0).append('|');
/* 2498 */       logStr.append(0).append('|');
/* 2499 */       logStr.append(0).append('|');
/* 2500 */       logStr.append(0).append('|');
/* 2501 */       logStr.append(0).append('|');
/*      */       
/*      */ 
/* 2504 */       logStr.append(0).append('|');
/*      */       
/* 2506 */       logStr.append(0).append('|');
/*      */       
/* 2508 */       logStr.append(0).append('|');
/*      */       
/*      */ 
/* 2511 */       String picUrl = PersonalInterface.getHeadImageURL(this.roleId, false);
/* 2512 */       if (picUrl.isEmpty())
/*      */       {
/* 2514 */         logStr.append(0);
/*      */       }
/*      */       else
/*      */       {
/* 2518 */         logStr.append(picUrl);
/*      */       }
/*      */       
/* 2521 */       TLogManager.getInstance().addLogSec(this.roleId, "SecBusinessShopP2PFlow", logStr.toString());
/* 2522 */       return true;
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void lockRoleInfoInit()
/*      */   {
/* 2531 */     IdipConfigInfo xIdipConfigInfo = Idipconfig.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 2532 */     if (xIdipConfigInfo == null)
/*      */     {
/* 2534 */       return;
/*      */     }
/*      */     
/* 2537 */     roleInfoCacheLock.writeLock().lock();
/*      */     try
/*      */     {
/* 2540 */       long now = DateTimeUtils.getCurrTimeInMillis();
/* 2541 */       Map<Long, RoleInfoForbid> xLockInfoForbids = xIdipConfigInfo.getInfo_forbids();
/* 2542 */       Iterator<Map.Entry<Long, RoleInfoForbid>> infoForbids = xLockInfoForbids.entrySet().iterator();
/* 2543 */       while (infoForbids.hasNext())
/*      */       {
/* 2545 */         Map.Entry<Long, RoleInfoForbid> roleForbidEntry = (Map.Entry)infoForbids.next();
/* 2546 */         long roleId = ((Long)roleForbidEntry.getKey()).longValue();
/*      */         
/* 2548 */         Map<Integer, IdipForbidInfo> forbidsMap = ((RoleInfoForbid)roleForbidEntry.getValue()).getForbids();
/* 2549 */         Iterator<Map.Entry<Integer, IdipForbidInfo>> iterator = forbidsMap.entrySet().iterator();
/* 2550 */         while (iterator.hasNext())
/*      */         {
/* 2552 */           Map.Entry<Integer, IdipForbidInfo> forbidEntry = (Map.Entry)iterator.next();
/* 2553 */           IdipForbidInfo xIdipForbidInfo = (IdipForbidInfo)forbidEntry.getValue();
/* 2554 */           if (xIdipForbidInfo.getExpiretime() <= now)
/*      */           {
/* 2556 */             iterator.remove();
/*      */           }
/*      */           else
/*      */           {
/* 2560 */             int infoType = ((Integer)forbidEntry.getKey()).intValue();
/* 2561 */             Map<Integer, IdipForbidData> lockRoleInfoCache = (Map)lockRoleInfoCacheMap.get(Long.valueOf(roleId));
/* 2562 */             if (lockRoleInfoCache == null)
/*      */             {
/* 2564 */               lockRoleInfoCache = new HashMap();
/* 2565 */               lockRoleInfoCacheMap.put(Long.valueOf(roleId), lockRoleInfoCache);
/*      */             }
/* 2567 */             lockRoleInfoCache.put(Integer.valueOf(infoType), new IdipForbidData(xIdipForbidInfo));
/*      */             
/* 2569 */             unlockRoleInfoObserver(roleId, infoType, (xIdipForbidInfo.getExpiretime() - now) / 1000L);
/*      */           }
/*      */         }
/*      */         
/* 2573 */         if (forbidsMap.isEmpty())
/*      */         {
/* 2575 */           infoForbids.remove();
/*      */         }
/*      */       }
/*      */     }
/*      */     finally
/*      */     {
/* 2581 */       roleInfoCacheLock.writeLock().unlock();
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
/*      */ 
/*      */   static boolean addLockRoleInfo(long roleId, int infoType, long seconds, String reason)
/*      */   {
/* 2597 */     IdipConfigInfo xIdipConfigInfo = Idipconfig.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 2598 */     if (xIdipConfigInfo == null)
/*      */     {
/* 2600 */       xIdipConfigInfo = Pod.newIdipConfigInfo();
/* 2601 */       Idipconfig.add(Long.valueOf(GameServerInfoManager.getLocalId()), xIdipConfigInfo);
/*      */     }
/*      */     
/* 2604 */     RoleInfoForbid xRoleInfoForbid = (RoleInfoForbid)xIdipConfigInfo.getInfo_forbids().get(Long.valueOf(roleId));
/* 2605 */     if (xRoleInfoForbid == null)
/*      */     {
/* 2607 */       xRoleInfoForbid = Pod.newRoleInfoForbid();
/* 2608 */       xIdipConfigInfo.getInfo_forbids().put(Long.valueOf(roleId), xRoleInfoForbid);
/*      */     }
/* 2610 */     IdipForbidInfo xIdipForbidInfo = (IdipForbidInfo)xRoleInfoForbid.getForbids().get(Integer.valueOf(infoType));
/* 2611 */     if (xIdipForbidInfo == null)
/*      */     {
/* 2613 */       xIdipForbidInfo = Pod.newIdipForbidInfo();
/* 2614 */       xRoleInfoForbid.getForbids().put(Integer.valueOf(infoType), xIdipForbidInfo);
/*      */     }
/* 2616 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 2617 */     long expireTime = TimeUnit.SECONDS.toMillis(seconds) + now;
/* 2618 */     xIdipForbidInfo.setStarttime(now);
/* 2619 */     xIdipForbidInfo.setExpiretime(expireTime);
/* 2620 */     xIdipForbidInfo.setReason(reason);
/*      */     
/*      */ 
/* 2623 */     roleInfoCacheLock.writeLock().lock();
/*      */     try
/*      */     {
/* 2626 */       Map<Integer, IdipForbidData> roleInfoForbidCache = (Map)lockRoleInfoCacheMap.get(Long.valueOf(roleId));
/* 2627 */       if (roleInfoForbidCache == null)
/*      */       {
/* 2629 */         roleInfoForbidCache = new HashMap();
/* 2630 */         lockRoleInfoCacheMap.put(Long.valueOf(roleId), roleInfoForbidCache);
/*      */       }
/* 2632 */       IdipForbidData idipForbidData = (IdipForbidData)roleInfoForbidCache.get(Integer.valueOf(infoType));
/* 2633 */       if (idipForbidData == null)
/*      */       {
/* 2635 */         idipForbidData = new IdipForbidData();
/* 2636 */         roleInfoForbidCache.put(Integer.valueOf(infoType), idipForbidData);
/*      */       }
/* 2638 */       idipForbidData.setStartTime(now);
/* 2639 */       idipForbidData.setExpireTime(expireTime);
/* 2640 */       idipForbidData.setReason(reason);
/*      */     }
/*      */     finally
/*      */     {
/* 2644 */       roleInfoCacheLock.writeLock().unlock();
/*      */     }
/*      */     
/*      */ 
/* 2648 */     unlockRoleInfoObserver(roleId, infoType, seconds);
/*      */     
/* 2650 */     GameServer.logger().info(String.format("add lock role info|roleId=%d|infoType=%d|startTime=%d|seconds=%d|reason=%s", new Object[] { Long.valueOf(roleId), Integer.valueOf(infoType), Long.valueOf(now), Long.valueOf(seconds), reason }));
/*      */     
/*      */ 
/* 2653 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void unlockRoleInfoObserver(long roleId, int infoType, long seconds)
/*      */   {
/* 2665 */     Observer unlockRoleInfoObserver = new UnlockRoleInfoObserver(roleId, infoType, seconds);
/* 2666 */     Map<Integer, Observer> commands = (Map)unlockRoleInfoObservers.get(Long.valueOf(roleId));
/* 2667 */     if (commands == null)
/*      */     {
/* 2669 */       commands = new HashMap();
/* 2670 */       unlockRoleInfoObservers.put(Long.valueOf(roleId), commands);
/*      */     }
/* 2672 */     Observer oldObserver = (Observer)commands.put(Integer.valueOf(infoType), unlockRoleInfoObserver);
/* 2673 */     if (oldObserver != null)
/*      */     {
/* 2675 */       oldObserver.stopTimer();
/* 2676 */       oldObserver = null;
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void cancelUnlockRoleInfoObserver(long roleId, int infoType)
/*      */   {
/* 2688 */     Map<Integer, Observer> commands = (Map)unlockRoleInfoObservers.get(Long.valueOf(roleId));
/* 2689 */     if (commands == null)
/*      */     {
/* 2691 */       return;
/*      */     }
/* 2693 */     Observer oldObserver = (Observer)commands.remove(Integer.valueOf(infoType));
/* 2694 */     if (oldObserver != null)
/*      */     {
/* 2696 */       oldObserver.stopTimer();
/* 2697 */       oldObserver = null;
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void removeLockRoleInfo(long roleId, int infoType)
/*      */   {
/* 2709 */     new PRemoveLockRoleInfo(roleId, infoType).execute();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private static class PRemoveLockRoleInfo
/*      */     extends LogicProcedure
/*      */   {
/*      */     private final long roleId;
/*      */     
/*      */ 
/*      */     private final int infoType;
/*      */     
/*      */ 
/*      */     public PRemoveLockRoleInfo(long roleId, int infoType)
/*      */     {
/* 2725 */       this.roleId = roleId;
/* 2726 */       this.infoType = infoType;
/*      */     }
/*      */     
/*      */ 
/*      */     protected boolean processImp()
/*      */       throws Exception
/*      */     {
/* 2733 */       IdipConfigInfo xIdipConfigInfo = Idipconfig.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 2734 */       if (xIdipConfigInfo == null)
/*      */       {
/* 2736 */         return false;
/*      */       }
/* 2738 */       if (xIdipConfigInfo.getInfo_forbids().get(Long.valueOf(this.roleId)) == null)
/*      */       {
/* 2740 */         return false;
/*      */       }
/* 2742 */       if (((RoleInfoForbid)xIdipConfigInfo.getInfo_forbids().get(Long.valueOf(this.roleId))).getForbids().remove(Integer.valueOf(this.infoType)) == null)
/*      */       {
/* 2744 */         return false;
/*      */       }
/*      */       
/*      */ 
/* 2748 */       IdipManager.roleInfoCacheLock.writeLock().lock();
/*      */       try
/*      */       {
/* 2751 */         Map<Integer, IdipForbidData> infoForbidCache = (Map)IdipManager.lockRoleInfoCacheMap.get(Long.valueOf(this.roleId));
/* 2752 */         boolean bool; if (infoForbidCache == null)
/*      */         {
/* 2754 */           return false;
/*      */         }
/* 2756 */         if (infoForbidCache.remove(Integer.valueOf(this.infoType)) == null)
/*      */         {
/* 2758 */           return false;
/*      */         }
/*      */       }
/*      */       finally
/*      */       {
/* 2763 */         IdipManager.roleInfoCacheLock.writeLock().unlock();
/*      */       }
/*      */       
/*      */ 
/* 2767 */       IdipManager.cancelUnlockRoleInfoObserver(this.roleId, this.infoType);
/*      */       
/* 2769 */       GameServer.logger().info(String.format("remove lock role info|roleId=%d|infoType=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.infoType) }));
/*      */       
/* 2771 */       return true;
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
/*      */   public static boolean isLockRoleInfo(long roleId, int infoType)
/*      */   {
/* 2786 */     roleInfoCacheLock.readLock().lock();
/*      */     try
/*      */     {
/* 2789 */       Map<Integer, IdipForbidData> lockInfoCache = (Map)lockRoleInfoCacheMap.get(Long.valueOf(roleId));
/* 2790 */       boolean bool; if (lockInfoCache == null)
/*      */       {
/* 2792 */         return false;
/*      */       }
/* 2794 */       return lockInfoCache.containsKey(Integer.valueOf(infoType));
/*      */     }
/*      */     finally
/*      */     {
/* 2798 */       roleInfoCacheLock.readLock().unlock();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void sendClearSayToAll(long roleId)
/*      */   {
/* 2809 */     SIdipClearSay sIdipClearSay = new SIdipClearSay();
/* 2810 */     sIdipClearSay.roleid = roleId;
/* 2811 */     OnlineManager.getInstance().sendAll(sIdipClearSay);
/*      */   }
/*      */   
/*      */   public static int getBigBossChartType(long roleid)
/*      */   {
/* 2816 */     int occupationid = RoleInterface.getOccupationId(roleid);
/* 2817 */     SOcp2ChartType ocp2ChartType = SOcp2ChartType.get(occupationid);
/* 2818 */     if (ocp2ChartType == null)
/*      */     {
/* 2820 */       return -1;
/*      */     }
/* 2822 */     return ocp2ChartType.charttype;
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\IdipManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
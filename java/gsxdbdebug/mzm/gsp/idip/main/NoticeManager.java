/*     */ package mzm.gsp.idip.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import java.util.concurrent.locks.Lock;
/*     */ import java.util.concurrent.locks.ReadWriteLock;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.idip.NoticeInfo;
/*     */ import mzm.gsp.idip.SSyncDelNotice;
/*     */ import mzm.gsp.idip.SSyncNotice;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.timer.main.Observer;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import xbean.IdipConfigInfo;
/*     */ import xbean.IdipNoticeInfo;
/*     */ import xbean.IdipNoticeObserver;
/*     */ import xbean.Pod;
/*     */ import xtable.Idipconfig;
/*     */ import xtable.Idipnotice;
/*     */ import xtable.Idipnoticeobservers;
/*     */ 
/*     */ public class NoticeManager
/*     */ {
/*     */   private static final String ENCODING = "UTF-8";
/*  32 */   private static final ReadWriteLock noticeCacheLock = new java.util.concurrent.locks.ReentrantReadWriteLock();
/*  33 */   private static final Map<Long, NoticeDataInfo> noticeCacheMap = new HashMap();
/*     */   
/*  35 */   private static final Map<QueryNoticeInfo, List<NoticeDataInfo>> queryNoticeCache = new HashMap();
/*     */   
/*  37 */   static final long DURATION_MILLI_SECONDS = TimeUnit.MINUTES.toMillis(30L);
/*     */   
/*     */   static void init()
/*     */   {
/*  41 */     new PNoticeInit(null).call();
/*     */   }
/*     */   
/*     */   private static class PNoticeInit
/*     */     extends mzm.gsp.util.LogicProcedure
/*     */   {
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  50 */       IdipConfigInfo xIdipConfigInfo = Idipconfig.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  51 */       if (xIdipConfigInfo == null)
/*     */       {
/*  53 */         return false;
/*     */       }
/*     */       
/*  56 */       NoticeManager.noticeCacheLock.writeLock().lock();
/*     */       try
/*     */       {
/*  59 */         Set<Long> noticeIds = xIdipConfigInfo.getNotices();
/*  60 */         if (noticeIds.isEmpty())
/*     */         {
/*  62 */           return true;
/*     */         }
/*     */         
/*     */ 
/*  66 */         lock(xdb.Lockeys.get(Idipnotice.getTable(), noticeIds));
/*  67 */         Object iterator = noticeIds.iterator();
/*  68 */         long now = DateTimeUtils.getCurrTimeInMillis();
/*  69 */         while (((Iterator)iterator).hasNext())
/*     */         {
/*  71 */           Long noticeId = (Long)((Iterator)iterator).next();
/*     */           
/*  73 */           IdipNoticeInfo xIdipNoticeInfo = Idipnotice.get(noticeId);
/*  74 */           if ((xIdipNoticeInfo.getEndtime() == 0L) || (xIdipNoticeInfo.getEndtime() > now))
/*     */           {
/*  76 */             NoticeManager.noticeCacheMap.put(noticeId, NoticeManager.transToNoticeDataInfo(xIdipNoticeInfo, noticeId.longValue()));
/*  77 */             if (xIdipNoticeInfo.getStarttime() > now)
/*     */             {
/*  79 */               NoticeManager.addNoticeObserver(noticeId.longValue(), xIdipNoticeInfo.getStarttime(), true);
/*     */ 
/*     */ 
/*     */             }
/*  83 */             else if (xIdipNoticeInfo.getEndtime() != 0L)
/*     */             {
/*  85 */               NoticeManager.addNoticeObserver(noticeId.longValue(), xIdipNoticeInfo.getEndtime(), false);
/*     */             }
/*     */             
/*     */           }
/*     */           else
/*     */           {
/*  91 */             ((Iterator)iterator).remove();
/*  92 */             Idipnotice.remove(noticeId);
/*     */           }
/*     */         }
/*     */       }
/*     */       finally
/*     */       {
/*  98 */         NoticeManager.noticeCacheLock.writeLock().unlock();
/*     */       }
/*     */       
/* 101 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   private static NoticeDataInfo transToNoticeDataInfo(IdipNoticeInfo xIdipNoticeInfo, long noticeId)
/*     */   {
/* 107 */     NoticeDataInfo notice = new NoticeDataInfo();
/* 108 */     notice.noticeId = noticeId;
/* 109 */     notice.noticeType = xIdipNoticeInfo.getNoticetype();
/* 110 */     notice.displayType = xIdipNoticeInfo.getDisplaytype();
/* 111 */     notice.hrefType = xIdipNoticeInfo.getHreftype();
/* 112 */     notice.hrefText = xIdipNoticeInfo.getHreftext();
/* 113 */     notice.hrefUrl = xIdipNoticeInfo.getHrefurl();
/* 114 */     notice.sendType = xIdipNoticeInfo.getSendtype();
/* 115 */     notice.noticeTitle = xIdipNoticeInfo.getNoticetitle();
/* 116 */     notice.noticeContent = xIdipNoticeInfo.getNoticecontent();
/* 117 */     notice.pictureUrl = xIdipNoticeInfo.getPictureurl();
/* 118 */     notice.startTime = xIdipNoticeInfo.getStarttime();
/* 119 */     notice.endTime = xIdipNoticeInfo.getEndtime();
/* 120 */     notice.minOpenServerDays = xIdipNoticeInfo.getMinopenserverdays();
/* 121 */     notice.maxOpenServerDays = xIdipNoticeInfo.getMaxopenserverdays();
/* 122 */     notice.minCreateRoleDays = xIdipNoticeInfo.getMincreatroledays();
/* 123 */     notice.maxCreateRoleDays = xIdipNoticeInfo.getMaxcreatroledays();
/* 124 */     notice.minRoleLevel = xIdipNoticeInfo.getMinrolelevel();
/* 125 */     notice.maxRoleLevel = xIdipNoticeInfo.getMaxrolelevel();
/* 126 */     notice.minSaveAmt = xIdipNoticeInfo.getMinsaveamt();
/* 127 */     notice.maxSaveAmt = xIdipNoticeInfo.getMaxsaveamt();
/* 128 */     notice.noticeTag = xIdipNoticeInfo.getNoticetag();
/* 129 */     notice.badge = xIdipNoticeInfo.getBadge();
/* 130 */     notice.noticeSortID = xIdipNoticeInfo.getNoticesortid();
/* 131 */     return notice;
/*     */   }
/*     */   
/*     */ 
/*     */   static boolean addNotice(NoticeDataInfo notice)
/*     */   {
/* 137 */     IdipConfigInfo xIdipConfigInfo = Idipconfig.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 138 */     if (xIdipConfigInfo == null)
/*     */     {
/* 140 */       xIdipConfigInfo = Pod.newIdipConfigInfo();
/* 141 */       Idipconfig.add(Long.valueOf(GameServerInfoManager.getLocalId()), xIdipConfigInfo);
/*     */     }
/*     */     
/* 144 */     long noticeId = notice.noticeId;
/* 145 */     if (xIdipConfigInfo.getNotices().contains(Long.valueOf(noticeId)))
/*     */     {
/* 147 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 151 */     IdipNoticeInfo xIdipNoticeInfo = Pod.newIdipNoticeInfo();
/* 152 */     fillXIdipNoticeInfo(xIdipNoticeInfo, notice);
/* 153 */     Idipnotice.insert(Long.valueOf(noticeId), xIdipNoticeInfo);
/*     */     
/* 155 */     Set<Long> notices = xIdipConfigInfo.getNotices();
/* 156 */     notices.add(Long.valueOf(noticeId));
/*     */     
/*     */ 
/* 159 */     noticeCacheLock.writeLock().lock();
/*     */     try
/*     */     {
/* 162 */       noticeCacheMap.put(Long.valueOf(noticeId), notice);
/*     */       
/* 164 */       queryNoticeCache.clear();
/*     */     }
/*     */     finally
/*     */     {
/* 168 */       noticeCacheLock.writeLock().unlock();
/*     */     }
/*     */     
/*     */ 
/* 172 */     addNoticeObserver(noticeId, notice.startTime, true);
/*     */     
/* 174 */     return true;
/*     */   }
/*     */   
/*     */   private static void addNoticeObserver(long noticeId, long time, boolean isSend)
/*     */   {
/* 179 */     IdipNoticeObserver xIdipNoticeObserver = Idipnoticeobservers.get(Long.valueOf(noticeId));
/* 180 */     if (xIdipNoticeObserver == null)
/*     */     {
/* 182 */       xIdipNoticeObserver = Pod.newIdipNoticeObserver();
/* 183 */       Idipnoticeobservers.insert(Long.valueOf(noticeId), xIdipNoticeObserver);
/*     */     }
/* 185 */     if (xIdipNoticeObserver.getObserver() != null)
/*     */     {
/* 187 */       xIdipNoticeObserver.getObserver().stopTimer();
/*     */     }
/*     */     
/* 190 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 191 */     long delay = time - now;
/* 192 */     long interval = delay > 0L ? TimeUnit.MILLISECONDS.toSeconds(delay) : 0L;
/* 193 */     Observer noticeObserver = isSend ? new SendNoticeObserver(interval, noticeId, time) : new DelNoticeObserver(interval, noticeId, time);
/*     */     
/* 195 */     xIdipNoticeObserver.setObserver(noticeObserver);
/*     */   }
/*     */   
/*     */   private static void clearNoticeObserver(long noticeId)
/*     */   {
/* 200 */     IdipNoticeObserver xIdipNoticeObserver = Idipnoticeobservers.get(Long.valueOf(noticeId));
/* 201 */     if (xIdipNoticeObserver != null)
/*     */     {
/* 203 */       if (xIdipNoticeObserver.getObserver() != null)
/*     */       {
/* 205 */         xIdipNoticeObserver.getObserver().stopTimer();
/*     */       }
/*     */     }
/* 208 */     Idipnoticeobservers.remove(Long.valueOf(noticeId));
/*     */   }
/*     */   
/*     */   private static void fillXIdipNoticeInfo(IdipNoticeInfo xIdipNoticeInfo, NoticeDataInfo notice)
/*     */   {
/* 213 */     xIdipNoticeInfo.setNoticetype(notice.noticeType);
/* 214 */     xIdipNoticeInfo.setDisplaytype(notice.displayType);
/* 215 */     xIdipNoticeInfo.setHreftype(notice.hrefType);
/* 216 */     xIdipNoticeInfo.setHreftext(notice.hrefText);
/* 217 */     xIdipNoticeInfo.setHrefurl(notice.hrefUrl);
/* 218 */     xIdipNoticeInfo.setSendtype(notice.sendType);
/* 219 */     xIdipNoticeInfo.setNoticetitle(notice.noticeTitle);
/* 220 */     xIdipNoticeInfo.setNoticecontent(notice.noticeContent);
/* 221 */     xIdipNoticeInfo.setPictureurl(notice.pictureUrl);
/* 222 */     xIdipNoticeInfo.setStarttime(notice.startTime);
/* 223 */     xIdipNoticeInfo.setEndtime(notice.endTime);
/* 224 */     xIdipNoticeInfo.setMinopenserverdays(notice.minOpenServerDays);
/* 225 */     xIdipNoticeInfo.setMaxopenserverdays(notice.maxOpenServerDays);
/* 226 */     xIdipNoticeInfo.setMincreatroledays(notice.minCreateRoleDays);
/* 227 */     xIdipNoticeInfo.setMaxcreatroledays(notice.maxCreateRoleDays);
/* 228 */     xIdipNoticeInfo.setMinrolelevel(notice.minRoleLevel);
/* 229 */     xIdipNoticeInfo.setMaxrolelevel(notice.maxRoleLevel);
/* 230 */     xIdipNoticeInfo.setMinsaveamt(notice.minSaveAmt);
/* 231 */     xIdipNoticeInfo.setMaxsaveamt(notice.maxSaveAmt);
/* 232 */     xIdipNoticeInfo.setNoticetag(notice.noticeTag);
/* 233 */     xIdipNoticeInfo.setBadge(notice.badge);
/* 234 */     xIdipNoticeInfo.setNoticesortid(notice.noticeSortID);
/*     */   }
/*     */   
/*     */ 
/*     */   static List<NoticeDataInfo> getCurrentNotices(long startTime)
/*     */   {
/* 240 */     List<NoticeDataInfo> result = new ArrayList();
/* 241 */     noticeCacheLock.readLock().lock();
/*     */     try
/*     */     {
/* 244 */       for (NoticeDataInfo notice : noticeCacheMap.values())
/*     */       {
/* 246 */         if (notice.startTime <= startTime)
/*     */         {
/* 248 */           result.add(notice);
/*     */         }
/*     */       }
/* 251 */       return result;
/*     */     }
/*     */     finally
/*     */     {
/* 255 */       noticeCacheLock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   static boolean containsNotice(long noticeId)
/*     */   {
/* 262 */     noticeCacheLock.readLock().lock();
/*     */     try
/*     */     {
/* 265 */       return noticeCacheMap.containsKey(Long.valueOf(noticeId));
/*     */     }
/*     */     finally
/*     */     {
/* 269 */       noticeCacheLock.readLock().unlock();
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
/*     */   static NoticeDataInfo getNotice(long noticeId)
/*     */   {
/* 282 */     noticeCacheLock.readLock().lock();
/*     */     try
/*     */     {
/* 285 */       return (NoticeDataInfo)noticeCacheMap.get(Long.valueOf(noticeId));
/*     */     }
/*     */     finally
/*     */     {
/* 289 */       noticeCacheLock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   static List<NoticeDataInfo> queryNotices(long startTime, long endTime, int page)
/*     */   {
/* 295 */     List<NoticeDataInfo> list = queryNotices(startTime, endTime);
/*     */     
/* 297 */     int fromIndex = (page - 1) * 5;
/* 298 */     if (fromIndex >= list.size())
/*     */     {
/* 300 */       return java.util.Collections.emptyList();
/*     */     }
/*     */     
/*     */ 
/* 304 */     int toIndex = fromIndex + 5;
/* 305 */     if (toIndex > list.size())
/*     */     {
/* 307 */       toIndex = list.size();
/*     */     }
/* 309 */     return list.subList(fromIndex, toIndex);
/*     */   }
/*     */   
/*     */ 
/*     */   private static List<NoticeDataInfo> queryNotices(long startTime, long endTime)
/*     */   {
/* 315 */     QueryNoticeInfo queryNoticeInfo = new QueryNoticeInfo(startTime, endTime);
/*     */     
/* 317 */     List<NoticeDataInfo> list = null;
/*     */     
/* 319 */     noticeCacheLock.readLock().lock();
/*     */     List<NoticeDataInfo> localList1;
/*     */     try
/*     */     {
/* 323 */       list = (List)queryNoticeCache.get(queryNoticeInfo);
/* 324 */       if (list != null)
/*     */       {
/* 326 */         return list;
/*     */       }
/*     */     }
/*     */     finally
/*     */     {
/* 331 */       noticeCacheLock.readLock().unlock();
/*     */     }
/*     */     
/*     */ 
/* 335 */     noticeCacheLock.writeLock().lock();
/*     */     
/*     */     try
/*     */     {
/* 339 */       list = (List)queryNoticeCache.get(queryNoticeInfo);
/* 340 */       if (list != null)
/*     */       {
/* 342 */         return list;
/*     */       }
/*     */       
/* 345 */       list = new ArrayList();
/* 346 */       for (NoticeDataInfo notice : noticeCacheMap.values())
/*     */       {
/* 348 */         if (notice.startTime >= startTime)
/*     */         {
/* 350 */           if (endTime == 0L)
/*     */           {
/* 352 */             if (notice.endTime == 0L)
/*     */             {
/* 354 */               list.add(notice);
/*     */             }
/*     */             
/*     */ 
/*     */           }
/* 359 */           else if ((notice.endTime != 0L) && (notice.endTime <= endTime))
/*     */           {
/* 361 */             list.add(notice);
/*     */           }
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 367 */       java.util.Collections.sort(list);
/* 368 */       queryNoticeCache.put(queryNoticeInfo, list);
/*     */     }
/*     */     finally
/*     */     {
/* 372 */       noticeCacheLock.writeLock().unlock();
/*     */     }
/* 374 */     return list;
/*     */   }
/*     */   
/*     */   static void delNotice(long noticeId, long endTimeTag)
/*     */   {
/* 379 */     new PDelNotice(noticeId, endTimeTag).execute();
/*     */   }
/*     */   
/*     */   static void forceDelNotice(long noticeId)
/*     */   {
/* 384 */     new PDelNotice(noticeId).execute();
/*     */   }
/*     */   
/*     */   private static class PDelNotice extends mzm.gsp.util.LogicProcedure
/*     */   {
/*     */     private final long noticeId;
/*     */     private final long endTimeTag;
/*     */     
/*     */     public PDelNotice(long noticeId, long endTimeTag)
/*     */     {
/* 394 */       this.noticeId = noticeId;
/* 395 */       this.endTimeTag = endTimeTag;
/*     */     }
/*     */     
/*     */     public PDelNotice(long noticeId)
/*     */     {
/* 400 */       this(noticeId, -1L);
/*     */     }
/*     */     
/*     */ 
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 407 */       IdipConfigInfo xIdipConfigInfo = Idipconfig.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 408 */       if (xIdipConfigInfo == null)
/*     */       {
/* 410 */         return false;
/*     */       }
/*     */       
/* 413 */       Set<Long> noticeIds = xIdipConfigInfo.getNotices();
/* 414 */       if (!noticeIds.contains(Long.valueOf(this.noticeId)))
/*     */       {
/* 416 */         return false;
/*     */       }
/*     */       
/* 419 */       IdipNoticeInfo xIdipNoticeInfo = Idipnotice.get(Long.valueOf(this.noticeId));
/* 420 */       if (this.endTimeTag != -1L)
/*     */       {
/* 422 */         if (this.endTimeTag != xIdipNoticeInfo.getEndtime())
/*     */         {
/* 424 */           return false;
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 429 */       noticeIds.remove(Long.valueOf(this.noticeId));
/* 430 */       Idipnotice.remove(Long.valueOf(this.noticeId));
/*     */       
/*     */ 
/* 433 */       NoticeManager.clearNoticeObserver(this.noticeId);
/*     */       
/* 435 */       if (xIdipNoticeInfo.getStarttime() <= DateTimeUtils.getCurrTimeInMillis())
/*     */       {
/*     */ 
/* 438 */         NoticeManager.sendDelNoticeToAll(this.noticeId);
/*     */       }
/*     */       
/*     */ 
/* 442 */       NoticeManager.noticeCacheLock.writeLock().lock();
/*     */       try
/*     */       {
/* 445 */         NoticeManager.noticeCacheMap.remove(Long.valueOf(this.noticeId));
/*     */         
/* 447 */         NoticeManager.queryNoticeCache.clear();
/*     */       }
/*     */       finally
/*     */       {
/* 451 */         NoticeManager.noticeCacheLock.writeLock().unlock();
/*     */       }
/*     */       
/* 454 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   static boolean updateNoitce(long noticeId, NoticeDataInfo newNotice)
/*     */   {
/* 461 */     IdipConfigInfo xIdipConfigInfo = Idipconfig.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 462 */     if (xIdipConfigInfo == null)
/*     */     {
/* 464 */       return false;
/*     */     }
/*     */     
/* 467 */     Set<Long> noticeIds = xIdipConfigInfo.getNotices();
/* 468 */     if (!noticeIds.contains(Long.valueOf(noticeId)))
/*     */     {
/* 470 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 474 */     IdipNoticeInfo xIdipNoticeInfo = Idipnotice.get(Long.valueOf(noticeId));
/* 475 */     fillXIdipNoticeInfo(xIdipNoticeInfo, newNotice);
/*     */     
/*     */ 
/* 478 */     NoticeDataInfo oldNotice = null;
/* 479 */     noticeCacheLock.writeLock().lock();
/*     */     try
/*     */     {
/* 482 */       oldNotice = (NoticeDataInfo)noticeCacheMap.put(Long.valueOf(noticeId), newNotice);
/*     */       
/* 484 */       queryNoticeCache.clear();
/*     */     }
/*     */     finally
/*     */     {
/* 488 */       noticeCacheLock.writeLock().unlock();
/*     */     }
/*     */     
/*     */ 
/* 492 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 493 */     if ((oldNotice.startTime <= now) && (newNotice.startTime > now))
/*     */     {
/*     */ 
/* 496 */       sendDelNoticeToAll(noticeId);
/*     */     }
/*     */     
/*     */ 
/* 500 */     addNoticeObserver(noticeId, newNotice.startTime, true);
/*     */     
/* 502 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   static void onSendNoticeHandler(long noticeId, long startTimeTag)
/*     */   {
/* 508 */     IdipNoticeObserver xIdipNoticeObserver = Idipnoticeobservers.get(Long.valueOf(noticeId));
/* 509 */     if (xIdipNoticeObserver == null)
/*     */     {
/* 511 */       return;
/*     */     }
/* 513 */     if (xIdipNoticeObserver.getObserver() == null)
/*     */     {
/* 515 */       return;
/*     */     }
/*     */     
/* 518 */     NoticeDataInfo notice = getNotice(noticeId);
/* 519 */     if (notice != null)
/*     */     {
/*     */ 
/* 522 */       if (notice.startTime != startTimeTag)
/*     */       {
/* 524 */         return;
/*     */       }
/* 526 */       sendNoticeToAll(notice);
/* 527 */       if (notice.endTime != 0L)
/*     */       {
/* 529 */         addNoticeObserver(noticeId, notice.endTime, false);
/*     */       }
/*     */       else
/*     */       {
/* 533 */         Idipnoticeobservers.remove(Long.valueOf(noticeId));
/*     */       }
/* 535 */       return;
/*     */     }
/*     */   }
/*     */   
/*     */   private static void sendNoticeToAll(NoticeDataInfo notice)
/*     */   {
/* 541 */     SSyncNotice msg = new SSyncNotice();
/* 542 */     msg.notice = transToNoticeInfo(notice);
/* 543 */     OnlineManager.getInstance().sendAllAtOnce(msg);
/*     */   }
/*     */   
/*     */   static NoticeInfo transToNoticeInfo(NoticeDataInfo notice)
/*     */   {
/* 548 */     NoticeInfo noticeInfo = new NoticeInfo();
/* 549 */     noticeInfo.noticeid = notice.noticeId;
/* 550 */     noticeInfo.noticetype = notice.noticeType;
/* 551 */     noticeInfo.displaytype = notice.displayType;
/* 552 */     noticeInfo.hreftype = notice.hrefType;
/* 553 */     noticeInfo.sendtype = notice.sendType;
/*     */     try
/*     */     {
/* 556 */       noticeInfo.hreftext.setString(notice.hrefText, "UTF-8");
/* 557 */       noticeInfo.hrefurl.setString(notice.hrefUrl, "UTF-8");
/* 558 */       noticeInfo.noticetitle.setString(notice.noticeTitle, "UTF-8");
/* 559 */       noticeInfo.pictureurl.setString(notice.pictureUrl, "UTF-8");
/*     */     }
/*     */     catch (UnsupportedEncodingException e) {}
/*     */     
/*     */ 
/*     */ 
/* 565 */     noticeInfo.starttime = TimeUnit.MILLISECONDS.toSeconds(notice.startTime);
/* 566 */     noticeInfo.endtime = TimeUnit.MILLISECONDS.toSeconds(notice.endTime);
/* 567 */     noticeInfo.minopenserverdays = notice.minOpenServerDays;
/* 568 */     noticeInfo.maxopenserverdays = notice.maxOpenServerDays;
/* 569 */     noticeInfo.mincreatroledays = notice.minCreateRoleDays;
/* 570 */     noticeInfo.maxcreatroledays = notice.maxCreateRoleDays;
/* 571 */     noticeInfo.minrolelevel = notice.minRoleLevel;
/* 572 */     noticeInfo.maxrolelevel = notice.maxRoleLevel;
/* 573 */     noticeInfo.minsaveamt = notice.minSaveAmt;
/* 574 */     noticeInfo.maxsaveamt = notice.maxSaveAmt;
/* 575 */     noticeInfo.noticetag = notice.noticeTag;
/* 576 */     noticeInfo.badge = (notice.badge ? 1 : 0);
/* 577 */     noticeInfo.noticesortid = notice.noticeSortID;
/* 578 */     return noticeInfo;
/*     */   }
/*     */   
/*     */   private static void sendDelNoticeToAll(long noticeId)
/*     */   {
/* 583 */     SSyncDelNotice msg = new SSyncDelNotice();
/* 584 */     msg.noticeid = noticeId;
/* 585 */     OnlineManager.getInstance().sendAll(msg);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\NoticeManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
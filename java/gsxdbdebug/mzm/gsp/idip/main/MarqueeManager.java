/*     */ package mzm.gsp.idip.main;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.timer.main.Observer;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.IdipConfigInfo;
/*     */ import xbean.IdipMarqueeInfo;
/*     */ import xbean.IdipMarqueeObserver;
/*     */ import xbean.Pod;
/*     */ import xtable.Idipconfig;
/*     */ import xtable.Idipmarquee;
/*     */ import xtable.Idipmarqueeobservers;
/*     */ 
/*     */ public class MarqueeManager
/*     */ {
/*  24 */   private static final Map<QueryMarqueeInfo, List<MarqueeDataInfo>> queryMarqueeCache = new HashMap();
/*     */   
/*     */ 
/*     */   static void init()
/*     */   {
/*  29 */     new PMarqueeInit(null).call();
/*     */   }
/*     */   
/*     */   private static class PMarqueeInit
/*     */     extends LogicProcedure
/*     */   {
/*     */     protected boolean processImp() throws Exception
/*     */     {
/*  37 */       IdipConfigInfo xIdipConfigInfo = Idipconfig.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  38 */       if (xIdipConfigInfo == null)
/*     */       {
/*  40 */         return false;
/*     */       }
/*     */       
/*  43 */       Set<Long> marqueeIds = xIdipConfigInfo.getMarquees();
/*  44 */       if (marqueeIds.isEmpty())
/*     */       {
/*  46 */         return true;
/*     */       }
/*     */       
/*     */ 
/*  50 */       lock(xdb.Lockeys.get(Idipmarquee.getTable(), marqueeIds));
/*  51 */       Iterator<Long> iterator = marqueeIds.iterator();
/*  52 */       long now = DateTimeUtils.getCurrTimeInMillis();
/*  53 */       while (iterator.hasNext())
/*     */       {
/*  55 */         Long marqueeId = (Long)iterator.next();
/*  56 */         IdipMarqueeInfo xIdipMarqueeInfo = Idipmarquee.get(marqueeId);
/*  57 */         if (xIdipMarqueeInfo.getEnd_time() > now)
/*     */         {
/*     */ 
/*  60 */           if ((xIdipMarqueeInfo.getRollnum() == -1) || (xIdipMarqueeInfo.getReal_num() < xIdipMarqueeInfo.getRollnum()))
/*     */           {
/*     */ 
/*  63 */             long indexId = xIdipMarqueeInfo.getIndexid();
/*  64 */             if (indexId == 0L)
/*     */             {
/*  66 */               indexId = -marqueeId.longValue();
/*  67 */               xIdipMarqueeInfo.setIndexid(indexId);
/*     */             }
/*     */             
/*     */ 
/*  71 */             MarqueeIndexCache.getInstance().put(indexId, marqueeId.longValue());
/*     */             
/*  73 */             MarqueeManager.sendMarqueeObserver(marqueeId.longValue(), xIdipMarqueeInfo.getBegin_time(), xIdipMarqueeInfo.getRollfre(), xIdipMarqueeInfo.getVersion());
/*     */ 
/*     */           }
/*     */           else
/*     */           {
/*  78 */             iterator.remove();
/*  79 */             Idipmarquee.remove(marqueeId);
/*     */           }
/*     */         }
/*     */         else
/*     */         {
/*  84 */           iterator.remove();
/*  85 */           Idipmarquee.remove(marqueeId);
/*     */         }
/*     */       }
/*     */       
/*  89 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void addMarquee(MarqueeDataInfo marquee)
/*     */   {
/* 100 */     IdipConfigInfo xIdipConfigInfo = Idipconfig.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 101 */     if (xIdipConfigInfo == null)
/*     */     {
/* 103 */       xIdipConfigInfo = Pod.newIdipConfigInfo();
/* 104 */       Idipconfig.add(Long.valueOf(GameServerInfoManager.getLocalId()), xIdipConfigInfo);
/*     */     }
/*     */     
/*     */ 
/* 108 */     IdipMarqueeInfo xIdipMarqueeInfo = Pod.newIdipMarqueeInfo();
/* 109 */     fillXIdipMarqueeInfo(xIdipMarqueeInfo, marquee);
/* 110 */     Long marqueeId = Idipmarquee.insert(xIdipMarqueeInfo);
/* 111 */     marquee.setMarqueeId(marqueeId.longValue());
/* 112 */     xIdipConfigInfo.getMarquees().add(marqueeId);
/*     */     
/*     */ 
/* 115 */     sendMarqueeObserver(marqueeId.longValue(), marquee.getBeginTime(), marquee.getRollFre(), xIdipMarqueeInfo.getVersion());
/*     */     
/*     */ 
/* 118 */     MarqueeIndexCache.getInstance().put(marquee.getIndexId(), marqueeId.longValue());
/*     */     
/*     */ 
/* 121 */     queryMarqueeCache.clear();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean updateMarquee(long marqueeId, MarqueeDataInfo newMarquee)
/*     */   {
/* 129 */     IdipConfigInfo xIdipConfigInfo = Idipconfig.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 130 */     if (xIdipConfigInfo == null)
/*     */     {
/* 132 */       return false;
/*     */     }
/*     */     
/* 135 */     Set<Long> marqueeIds = xIdipConfigInfo.getMarquees();
/* 136 */     if (!marqueeIds.contains(Long.valueOf(marqueeId)))
/*     */     {
/* 138 */       return false;
/*     */     }
/*     */     
/* 141 */     IdipMarqueeInfo xIdipMarqueeInfo = Idipmarquee.get(Long.valueOf(marqueeId));
/* 142 */     if (xIdipMarqueeInfo == null)
/*     */     {
/* 144 */       return false;
/*     */     }
/* 146 */     fillXIdipMarqueeInfo(xIdipMarqueeInfo, newMarquee);
/*     */     
/*     */ 
/* 149 */     sendMarqueeObserver(marqueeId, newMarquee.getBeginTime(), newMarquee.getRollFre(), xIdipMarqueeInfo.getVersion());
/*     */     
/*     */ 
/* 152 */     queryMarqueeCache.clear();
/*     */     
/* 154 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean forceDeleteMarquee(long marqueeId)
/*     */   {
/* 165 */     return doDeleteMarquee(marqueeId, -1);
/*     */   }
/*     */   
/*     */   static List<MarqueeDataInfo> queryMarquees(long beginTime, long endTime, int page)
/*     */   {
/* 170 */     List<MarqueeDataInfo> list = queryMarquees(beginTime, endTime);
/*     */     
/* 172 */     int fromIndex = (page - 1) * 5;
/* 173 */     if (fromIndex >= list.size())
/*     */     {
/* 175 */       return Collections.emptyList();
/*     */     }
/*     */     
/*     */ 
/* 179 */     int toIndex = fromIndex + 5;
/* 180 */     if (toIndex > list.size())
/*     */     {
/* 182 */       toIndex = list.size();
/*     */     }
/* 184 */     return list.subList(fromIndex, toIndex);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private static List<MarqueeDataInfo> queryMarquees(long beginTime, long endTime)
/*     */   {
/* 191 */     IdipConfigInfo xIdipConfigInfo = Idipconfig.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 192 */     if (xIdipConfigInfo == null)
/*     */     {
/* 194 */       return Collections.emptyList();
/*     */     }
/*     */     
/* 197 */     Set<Long> marqueeIds = xIdipConfigInfo.getMarquees();
/* 198 */     if (marqueeIds.isEmpty())
/*     */     {
/* 200 */       return Collections.emptyList();
/*     */     }
/*     */     
/* 203 */     QueryMarqueeInfo queryMarqueeInfo = new QueryMarqueeInfo(beginTime, endTime);
/* 204 */     List<MarqueeDataInfo> list = null;
/* 205 */     list = (List)queryMarqueeCache.get(queryMarqueeInfo);
/* 206 */     if (list != null)
/*     */     {
/* 208 */       return list;
/*     */     }
/*     */     
/*     */ 
/* 212 */     list = new java.util.ArrayList();
/* 213 */     Iterator<Long> iterator = marqueeIds.iterator();
/* 214 */     while (iterator.hasNext())
/*     */     {
/* 216 */       Long marqueeId = (Long)iterator.next();
/*     */       
/* 218 */       IdipMarqueeInfo xIdipMarqueeInfo = Idipmarquee.select(marqueeId);
/* 219 */       if (xIdipMarqueeInfo != null)
/*     */       {
/* 221 */         long marqueeBeginTime = xIdipMarqueeInfo.getBegin_time();
/* 222 */         long marqueeEndTime = xIdipMarqueeInfo.getEnd_time();
/* 223 */         if ((marqueeBeginTime >= beginTime) && (marqueeEndTime <= endTime))
/*     */         {
/* 225 */           MarqueeDataInfo marqueeDataInfo = trans(marqueeId.longValue(), xIdipMarqueeInfo);
/* 226 */           list.add(marqueeDataInfo);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 232 */     Collections.sort(list);
/* 233 */     queryMarqueeCache.put(queryMarqueeInfo, list);
/*     */     
/* 235 */     return list;
/*     */   }
/*     */   
/*     */   private static MarqueeDataInfo trans(long marqueeid, IdipMarqueeInfo xIdipMarqueeInfo)
/*     */   {
/* 240 */     long marqueeBeginTime = xIdipMarqueeInfo.getBegin_time();
/* 241 */     long marqueeEndTime = xIdipMarqueeInfo.getEnd_time();
/* 242 */     String mailTitle = xIdipMarqueeInfo.getMail_title();
/* 243 */     String mailContent = xIdipMarqueeInfo.getMail_content();
/* 244 */     int rollFree = xIdipMarqueeInfo.getRollfre();
/* 245 */     int rollNum = xIdipMarqueeInfo.getRollnum();
/* 246 */     long indexId = xIdipMarqueeInfo.getIndexid();
/* 247 */     MarqueeDataInfo marqueeDataInfo = new MarqueeDataInfo(marqueeBeginTime, marqueeEndTime, mailTitle, mailContent, rollFree, rollNum, indexId);
/*     */     
/* 249 */     marqueeDataInfo.setMarqueeId(marqueeid);
/* 250 */     return marqueeDataInfo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void sendMarquee(long marqueeId, int version)
/*     */   {
/* 261 */     new PSendMarquee(marqueeId, version).execute();
/*     */   }
/*     */   
/*     */   private static class PSendMarquee extends LogicProcedure
/*     */   {
/*     */     private final long marqueeId;
/*     */     private final int version;
/*     */     
/*     */     public PSendMarquee(long marqueeId, int version)
/*     */     {
/* 271 */       this.marqueeId = marqueeId;
/* 272 */       this.version = version;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 278 */       IdipMarqueeObserver xIdipMarqueeObserver = Idipmarqueeobservers.get(Long.valueOf(this.marqueeId));
/* 279 */       if (xIdipMarqueeObserver == null)
/*     */       {
/* 281 */         return false;
/*     */       }
/* 283 */       if (xIdipMarqueeObserver.getObserver() == null)
/*     */       {
/* 285 */         return false;
/*     */       }
/*     */       
/* 288 */       IdipMarqueeInfo xIdipMarqueeInfo = Idipmarquee.get(Long.valueOf(this.marqueeId));
/* 289 */       if (xIdipMarqueeInfo == null)
/*     */       {
/* 291 */         return false;
/*     */       }
/*     */       
/* 294 */       if (xIdipMarqueeInfo.getVersion() != this.version)
/*     */       {
/* 296 */         return false;
/*     */       }
/*     */       
/*     */ 
/* 300 */       xIdipMarqueeInfo.setReal_num(xIdipMarqueeInfo.getReal_num() + 1);
/*     */       
/* 302 */       if ((xIdipMarqueeInfo.getRollnum() != -1) && (xIdipMarqueeInfo.getReal_num() >= xIdipMarqueeInfo.getRollnum()))
/*     */       {
/*     */ 
/* 305 */         new MarqueeManager.PDeleteMarquee(this.marqueeId, this.version).execute();
/*     */       }
/* 307 */       else if (DateTimeUtils.getCurrTimeInMillis() + TimeUnit.SECONDS.toMillis(xIdipMarqueeInfo.getRollfre()) > xIdipMarqueeInfo.getEnd_time())
/*     */       {
/*     */ 
/* 310 */         new MarqueeManager.PDeleteMarquee(this.marqueeId, this.version).execute();
/*     */       }
/*     */       
/*     */ 
/* 314 */       mzm.gsp.bulletin.main.BulletinInterface.sendNotice(xIdipMarqueeInfo.getMail_content());
/*     */       
/* 316 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   private static class PDeleteMarquee extends LogicProcedure
/*     */   {
/*     */     private final long marqueeId;
/*     */     private final int version;
/*     */     
/*     */     public PDeleteMarquee(long marqueeId, int version)
/*     */     {
/* 327 */       this.marqueeId = marqueeId;
/* 328 */       this.version = version;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 334 */       return MarqueeManager.doDeleteMarquee(this.marqueeId, this.version);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private static boolean doDeleteMarquee(long marqueeId, int version)
/*     */   {
/* 342 */     IdipConfigInfo xIdipConfigInfo = Idipconfig.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 343 */     if (xIdipConfigInfo == null)
/*     */     {
/* 345 */       return false;
/*     */     }
/*     */     
/* 348 */     Set<Long> marqueeIds = xIdipConfigInfo.getMarquees();
/* 349 */     if (!marqueeIds.contains(Long.valueOf(marqueeId)))
/*     */     {
/* 351 */       return false;
/*     */     }
/*     */     
/* 354 */     IdipMarqueeInfo xIdipMarqueeInfo = Idipmarquee.get(Long.valueOf(marqueeId));
/* 355 */     if (version != -1)
/*     */     {
/* 357 */       if (version != xIdipMarqueeInfo.getVersion())
/*     */       {
/* 359 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 364 */     marqueeIds.remove(Long.valueOf(marqueeId));
/* 365 */     Idipmarquee.remove(Long.valueOf(marqueeId));
/*     */     
/*     */ 
/* 368 */     clearMarqueeObserver(marqueeId);
/*     */     
/*     */ 
/* 371 */     MarqueeIndexCache.getInstance().removeByValue(marqueeId);
/*     */     
/*     */ 
/* 374 */     queryMarqueeCache.clear();
/*     */     
/* 376 */     return true;
/*     */   }
/*     */   
/*     */   private static void sendMarqueeObserver(long marqueeId, long beginTime, int rollFre, int version)
/*     */   {
/* 381 */     IdipMarqueeObserver xIdipMarqueeObserver = Idipmarqueeobservers.get(Long.valueOf(marqueeId));
/* 382 */     if (xIdipMarqueeObserver == null)
/*     */     {
/* 384 */       xIdipMarqueeObserver = Pod.newIdipMarqueeObserver();
/* 385 */       Idipmarqueeobservers.insert(Long.valueOf(marqueeId), xIdipMarqueeObserver);
/*     */     }
/*     */     
/* 388 */     if (xIdipMarqueeObserver.getObserver() != null)
/*     */     {
/* 390 */       xIdipMarqueeObserver.getObserver().stopTimer();
/*     */     }
/*     */     
/*     */ 
/* 394 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 395 */     long delay = beginTime - now;
/* 396 */     long interval = delay > 0L ? TimeUnit.MILLISECONDS.toSeconds(delay) : 0L;
/*     */     
/* 398 */     Observer sendMarqueeObserver = new SendMarqueeObserver(marqueeId, interval, rollFre, version);
/* 399 */     xIdipMarqueeObserver.setObserver(sendMarqueeObserver);
/*     */   }
/*     */   
/*     */   private static void clearMarqueeObserver(long marqueeId)
/*     */   {
/* 404 */     IdipMarqueeObserver xIdipMarqueeObserver = Idipmarqueeobservers.get(Long.valueOf(marqueeId));
/* 405 */     if (xIdipMarqueeObserver != null)
/*     */     {
/* 407 */       if (xIdipMarqueeObserver.getObserver() != null)
/*     */       {
/* 409 */         xIdipMarqueeObserver.getObserver().stopTimer();
/*     */       }
/*     */     }
/* 412 */     Idipmarqueeobservers.remove(Long.valueOf(marqueeId));
/*     */   }
/*     */   
/*     */   private static void fillXIdipMarqueeInfo(IdipMarqueeInfo xIdipMarqueeInfo, MarqueeDataInfo marquee)
/*     */   {
/* 417 */     xIdipMarqueeInfo.setBegin_time(marquee.getBeginTime());
/* 418 */     xIdipMarqueeInfo.setEnd_time(marquee.getEndTime());
/* 419 */     xIdipMarqueeInfo.setMail_title(marquee.getMailTitle());
/* 420 */     xIdipMarqueeInfo.setMail_content(marquee.getMailContent());
/* 421 */     xIdipMarqueeInfo.setRollfre(marquee.getRollFre());
/* 422 */     xIdipMarqueeInfo.setRollnum(marquee.getRollNum());
/* 423 */     xIdipMarqueeInfo.setReal_num(0);
/* 424 */     xIdipMarqueeInfo.setVersion(xIdipMarqueeInfo.getVersion() + 1);
/* 425 */     xIdipMarqueeInfo.setIndexid(marquee.getIndexId());
/*     */   }
/*     */   
/*     */   static boolean contains(long marqueeId)
/*     */   {
/* 430 */     IdipMarqueeInfo xIdipMarqueeInfo = Idipmarquee.select(Long.valueOf(marqueeId));
/* 431 */     return xIdipMarqueeInfo != null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\MarqueeManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
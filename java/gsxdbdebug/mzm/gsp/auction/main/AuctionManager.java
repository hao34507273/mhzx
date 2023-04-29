/*     */ package mzm.gsp.auction.main;
/*     */ 
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import java.util.TreeMap;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.confbean.SActivityCfg;
/*     */ import mzm.gsp.auction.ItemInfo;
/*     */ import mzm.gsp.auction.confbean.AuctionConsts;
/*     */ import mzm.gsp.auction.confbean.OrigAuctionItemCfg;
/*     */ import mzm.gsp.auction.confbean.SAuctionActivityCfg;
/*     */ import mzm.gsp.auction.confbean.SAuctionActivityInfo;
/*     */ import mzm.gsp.auction.confbean.SAuctionActivityTurnCfg;
/*     */ import mzm.gsp.auction.confbean.SAuctionItemCfg;
/*     */ import mzm.gsp.auction.confbean.SItemInfo;
/*     */ import mzm.gsp.auction.confbean.SItemInfoList;
/*     */ import mzm.gsp.auction.confbean.SItemTypeInfo;
/*     */ import mzm.gsp.auction.confbean.STurnInfo;
/*     */ import mzm.gsp.auction.event.AuctionBidWinEvent;
/*     */ import mzm.gsp.bulletin.SBulletinInfo;
/*     */ import mzm.gsp.bulletin.main.BulletinInterface;
/*     */ import mzm.gsp.common.TimeCommonUtil;
/*     */ import mzm.gsp.common.confbean.STimeDurationCommonCfg;
/*     */ import mzm.gsp.item.confbean.SItemCfg;
/*     */ import mzm.gsp.mail.main.MailAttachment;
/*     */ import mzm.gsp.mail.main.MailInterface;
/*     */ import mzm.gsp.mail.main.SendMailRet;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.AucItemInfo;
/*     */ import xbean.AuctionActivityInfo;
/*     */ import xbean.AuctionMergeInfo;
/*     */ import xbean.AuctionPeriodInfo;
/*     */ import xbean.AuctionTurnInfo;
/*     */ import xbean.Pod;
/*     */ import xtable.Auctionactivityinfo;
/*     */ 
/*     */ public class AuctionManager
/*     */ {
/*     */   static final String CHARSET = "utf-8";
/*     */   
/*     */   static void initActivityData(int activityId, int mailId, LogReason logReason)
/*     */   {
/*  61 */     if (GameServerInfoManager.isRoamServer())
/*     */     {
/*  63 */       return;
/*     */     }
/*  65 */     long currentTimeStamp = DateTimeUtils.getCurrTimeInMillis();
/*  66 */     ActivityPeriod currentActivityPeriod = getCurrentActivityPeriod(activityId);
/*  67 */     if (currentActivityPeriod == null)
/*     */     {
/*  69 */       return;
/*     */     }
/*     */     
/*  72 */     AuctionActivityInfo xAuctionActivityInfo = getAuctionActivityInfoCreateIfNotExist(activityId, currentActivityPeriod);
/*     */     
/*     */ 
/*  75 */     initAuctionInfo(activityId, xAuctionActivityInfo, currentActivityPeriod, mailId, logReason);
/*     */     
/*  77 */     GameServer.logger().info(String.format("[auction]AuctionManager.initActivityData@activityId=%d|currentTime=%s|currentActivityPeriod=%s|mailId=%d|logReason=%d", new Object[] { Integer.valueOf(activityId), DateTimeUtils.getSimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(currentTimeStamp)), currentActivityPeriod, Integer.valueOf(mailId), Integer.valueOf(logReason.value) }));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static ActivityPeriod getCurrentActivityPeriod(int activityId)
/*     */   {
/*  85 */     long currentTimeStamp = DateTimeUtils.getCurrTimeInMillis();
/*     */     
/*  87 */     SActivityCfg sActivityCfg = SActivityCfg.get(activityId);
/*  88 */     if (sActivityCfg == null)
/*     */     {
/*  90 */       return null;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  96 */     ActivityPeriod activityPeriod = null;
/*     */     
/*  98 */     for (int i = 0; i < sActivityCfg.activityTimeIds.size(); i++)
/*     */     {
/* 100 */       STimeDurationCommonCfg timeDurationCommonCfg = STimeDurationCommonCfg.get(((Integer)sActivityCfg.activityTimeIds.get(i)).intValue());
/* 101 */       long durationTime = TimeUnit.MINUTES.toMillis(TimeCommonUtil.getDurationMinute(timeDurationCommonCfg));
/* 102 */       long lastStartTimeStamp = TimeCommonUtil.getBeforeStartTime(currentTimeStamp, timeDurationCommonCfg);
/* 103 */       long endTimeStamp = lastStartTimeStamp + durationTime;
/* 104 */       if ((currentTimeStamp >= lastStartTimeStamp) && (currentTimeStamp < endTimeStamp))
/*     */       {
/* 106 */         activityPeriod = new ActivityPeriod();
/* 107 */         activityPeriod.timeIdIndex = i;
/* 108 */         activityPeriod.startTimeStamp = lastStartTimeStamp;
/* 109 */         activityPeriod.endTimeStamp = endTimeStamp;
/* 110 */         return activityPeriod;
/*     */       }
/*     */     }
/* 113 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */   static SAuctionActivityInfo getSAuctionActivityInfo(int activityId, ActivityPeriod activityPeriod)
/*     */   {
/* 119 */     SAuctionActivityCfg auctionActivityCfg = SAuctionActivityCfg.get(activityId);
/* 120 */     if (auctionActivityCfg == null)
/*     */     {
/* 122 */       return null;
/*     */     }
/*     */     
/* 125 */     SAuctionActivityInfo auctionActivityInfo = (SAuctionActivityInfo)auctionActivityCfg.activityTimeIndex2activityInfo.get(Integer.valueOf(activityPeriod.timeIdIndex + 1));
/*     */     
/* 127 */     if (auctionActivityInfo == null)
/*     */     {
/* 129 */       return null;
/*     */     }
/* 131 */     return auctionActivityInfo;
/*     */   }
/*     */   
/*     */   static SAuctionActivityTurnCfg getSAuctionActivityTurnCfg(int activityId, ActivityPeriod activityPeriod)
/*     */   {
/* 136 */     SAuctionActivityInfo auctionActivityInfo = getSAuctionActivityInfo(activityId, activityPeriod);
/* 137 */     if (auctionActivityInfo == null)
/*     */     {
/* 139 */       return null;
/*     */     }
/* 141 */     return SAuctionActivityTurnCfg.get(auctionActivityInfo.turnTypeId);
/*     */   }
/*     */   
/*     */   static SItemTypeInfo getSItemTypeInfo(STurnInfo turnInfo)
/*     */   {
/* 146 */     SAuctionItemCfg auctionItemCfg = SAuctionItemCfg.get(turnInfo.itemSumTypeId);
/* 147 */     if (auctionItemCfg == null)
/*     */     {
/* 149 */       return null;
/*     */     }
/* 151 */     int serverLevel = mzm.gsp.server.main.ServerInterface.getCurrentServerLevel();
/* 152 */     GameServer.logger().info(String.format("[auction]AuctionManager.getSItemTypeInfo@serverLevel=%d", new Object[] { Integer.valueOf(serverLevel) }));
/*     */     
/* 154 */     Map.Entry<Integer, SItemTypeInfo> itemTypeInfoEntry = auctionItemCfg.serverLevel2itemTypeInfo.floorEntry(Integer.valueOf(serverLevel));
/*     */     
/* 156 */     if (itemTypeInfoEntry == null)
/*     */     {
/* 158 */       return null;
/*     */     }
/* 160 */     return (SItemTypeInfo)itemTypeInfoEntry.getValue();
/*     */   }
/*     */   
/*     */   static SItemInfo randomItemInfo(SItemInfoList itemInfoList)
/*     */   {
/* 165 */     int random = xdb.Xdb.random().nextInt(itemInfoList.weightSum);
/* 166 */     int weightSum = 0;
/* 167 */     for (SItemInfo itemInfo : itemInfoList.itemInfoList)
/*     */     {
/* 169 */       weightSum += itemInfo.itemWeight;
/* 170 */       if (random < weightSum)
/*     */       {
/* 172 */         return itemInfo;
/*     */       }
/*     */     }
/* 175 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */   static void initAuctionInfo(int activityId, AuctionActivityInfo xAuctionActivityInfo, ActivityPeriod currentActivityPeriod, int mailId, LogReason logReason)
/*     */   {
/* 181 */     AuctionPeriodInfo xCurrentPeriodInfo = xAuctionActivityInfo.getCurrentperiodinfo();
/* 182 */     AuctionPeriodInfo xLastInfo = xAuctionActivityInfo.getLastperiodinfo();
/* 183 */     long currentTimeStamp = DateTimeUtils.getCurrTimeInMillis();
/*     */     
/* 185 */     if (xCurrentPeriodInfo.getPeriodendtimestamp() <= currentTimeStamp)
/*     */     {
/*     */ 
/* 188 */       GameServer.logger().info(String.format("[auction]AuctionManager.initAuctionInfo@ activity expire|activityId=%d", new Object[] { Integer.valueOf(activityId) }));
/*     */       
/*     */ 
/*     */ 
/* 192 */       checkPeriodAuctionItemAndRefund(activityId, xCurrentPeriodInfo, mailId, logReason);
/*     */       
/*     */ 
/* 195 */       copyAuctionPeriodInfo(xCurrentPeriodInfo, xLastInfo);
/*     */       
/*     */ 
/* 198 */       resetAuctionPeriodInfo(currentActivityPeriod, xCurrentPeriodInfo);
/*     */     }
/*     */     
/* 201 */     int currPeriodStatus = xCurrentPeriodInfo.getStatus();
/* 202 */     if (currPeriodStatus == 1)
/*     */     {
/* 204 */       return;
/*     */     }
/*     */     
/* 207 */     SAuctionActivityTurnCfg auctionActivityTurnCfg = getSAuctionActivityTurnCfg(activityId, currentActivityPeriod);
/*     */     
/* 209 */     if (auctionActivityTurnCfg == null)
/*     */     {
/* 211 */       return;
/*     */     }
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
/* 223 */     SimpleDateFormat simpleDateFormat = DateTimeUtils.getSimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/* 224 */     for (Map.Entry<Integer, STurnInfo> entry : auctionActivityTurnCfg.turnIndex2turnInfo.entrySet())
/*     */     {
/* 226 */       STurnInfo turnInfo = (STurnInfo)entry.getValue();
/* 227 */       turnIndex = ((Integer)entry.getKey()).intValue();
/*     */       AuctionTurnInfo xAuctionTurnInfo;
/* 229 */       if (xCurrentPeriodInfo.getTurnindex2turninfo().containsKey(Integer.valueOf(turnIndex)))
/*     */       {
/* 231 */         xAuctionTurnInfo = (AuctionTurnInfo)xCurrentPeriodInfo.getTurnindex2turninfo().get(Integer.valueOf(turnIndex));
/*     */         
/* 233 */         GameServer.logger().info(String.format("[auction]AuctionManager.initAuctionInfo@auction reopen|activityId=%d|turnIndex=%d|currentTimeStamp=%s|turnStartTimeStamp=%s|turnEndTimeStamp=%s", new Object[] { Integer.valueOf(activityId), Integer.valueOf(turnIndex), simpleDateFormat.format(Long.valueOf(currentTimeStamp)), simpleDateFormat.format(Long.valueOf(xAuctionTurnInfo.getTurnstarttimestamp())), simpleDateFormat.format(Long.valueOf(xAuctionTurnInfo.getTurnendtimestamp())) }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 239 */         if (currentTimeStamp < xAuctionTurnInfo.getTurnstarttimestamp())
/*     */         {
/*     */ 
/* 242 */           GameServer.logger().info(String.format("[auction]AuctionManager.initAuctionInfo@activity turn not begin|activityId=%d|turnIndex=%d", new Object[] { Integer.valueOf(activityId), Integer.valueOf(turnIndex) }));
/*     */           
/*     */ 
/*     */ 
/* 246 */           for (AucItemInfo xAucItemInfo : xAuctionTurnInfo.getTemplateid2iteminfo().values())
/*     */           {
/*     */ 
/* 249 */             startAuctionItemBeforeBidEndSession(xAucItemInfo, activityId, turnIndex);
/*     */           }
/*     */           
/*     */         }
/* 253 */         else if (currentTimeStamp > xAuctionTurnInfo.getTurnendtimestamp())
/*     */         {
/* 255 */           GameServer.logger().info(String.format("[auction]AuctionManager.initAuctionInfo@activity turn ended|activityId=%d|turnIndex=%d", new Object[] { Integer.valueOf(activityId), Integer.valueOf(turnIndex) }));
/*     */           
/*     */ 
/*     */ 
/*     */ 
/* 260 */           for (AucItemInfo xAucItemInfo : xAuctionTurnInfo.getTemplateid2iteminfo().values())
/*     */           {
/* 262 */             refundBidderWhenClose(activityId, turnIndex, xCurrentPeriodInfo, xAuctionTurnInfo, xAucItemInfo, mailId, logReason);
/*     */           }
/*     */           
/*     */         }
/*     */         else
/*     */         {
/* 268 */           GameServer.logger().info(String.format("[auction]AuctionManager.initAuctionInfo@activity turn is on|activityId=%d|turnIndex=%d", new Object[] { Integer.valueOf(activityId), Integer.valueOf(turnIndex) }));
/*     */           
/*     */ 
/*     */ 
/* 272 */           for (AucItemInfo xAucItemInfo : xAuctionTurnInfo.getTemplateid2iteminfo().values())
/*     */           {
/*     */ 
/* 275 */             refundBidderWhenClose(activityId, turnIndex, xCurrentPeriodInfo, xAuctionTurnInfo, xAucItemInfo, mailId, logReason);
/*     */             
/*     */ 
/* 278 */             if (xAucItemInfo.getBidendtimestamp() > currentTimeStamp)
/*     */             {
/*     */ 
/*     */ 
/*     */ 
/* 283 */               startAuctionItemBeforeBidEndSession(xAucItemInfo, activityId, turnIndex);
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */       else
/*     */       {
/* 290 */         GameServer.logger().info(String.format("[auction]AuctionManager.initAuctionInfo@new activity start|activityId=%d", new Object[] { Integer.valueOf(activityId) }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 295 */         STimeDurationCommonCfg timeDurationCommonCfg = STimeDurationCommonCfg.get(turnInfo.turnTimeId);
/* 296 */         if (timeDurationCommonCfg != null)
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 303 */           turnStartTimeStamp = TimeCommonUtil.getNextStartTime(currentTimeStamp, timeDurationCommonCfg.timeCommonCfgId, true);
/* 304 */           if (turnStartTimeStamp > currentActivityPeriod.endTimeStamp)
/*     */           {
/*     */ 
/* 307 */             turnStartTimeStamp = TimeCommonUtil.getBeforeStartTime(currentTimeStamp, timeDurationCommonCfg.timeCommonCfgId);
/*     */           }
/*     */           
/* 310 */           if (turnStartTimeStamp > currentActivityPeriod.endTimeStamp)
/*     */           {
/* 312 */             GameServer.logger().error(String.format("[auction]AuctionManager.initAuctionInfo@activity turn error|activityId=%d|turnIndex=%d|turnStartTimeStamp=%s|currentActivityPeriod=%s", new Object[] { Integer.valueOf(activityId), Integer.valueOf(turnIndex), simpleDateFormat.format(Long.valueOf(turnStartTimeStamp)), currentActivityPeriod }));
/*     */ 
/*     */           }
/*     */           else
/*     */           {
/*     */ 
/* 318 */             SItemTypeInfo itemTypeInfo = getSItemTypeInfo(turnInfo);
/* 319 */             if (itemTypeInfo != null)
/*     */             {
/*     */ 
/*     */ 
/*     */ 
/* 324 */               xAuctionTurnInfo = Pod.newAuctionTurnInfo();
/* 325 */               xAuctionTurnInfo.setTurnstarttimestamp(turnStartTimeStamp);
/* 326 */               xAuctionTurnInfo.setTurnendtimestamp(turnStartTimeStamp + TimeCommonUtil.getDurationMillis(timeDurationCommonCfg));
/* 327 */               xCurrentPeriodInfo.getTurnindex2turninfo().put(Integer.valueOf(turnIndex), xAuctionTurnInfo);
/*     */               
/* 329 */               GameServer.logger().info(String.format("[auction]AuctionManager.initAuctionInfo@auction turn|activityId=%d|turnIndex=%d|turnStartTimeStamp=%s|turnEndTimeStamp=%s", new Object[] { Integer.valueOf(activityId), Integer.valueOf(turnIndex), simpleDateFormat.format(Long.valueOf(xAuctionTurnInfo.getTurnstarttimestamp())), simpleDateFormat.format(Long.valueOf(xAuctionTurnInfo.getTurnendtimestamp())) }));
/*     */               
/*     */ 
/*     */ 
/*     */ 
/* 334 */               for (Map.Entry<Integer, SItemInfoList> itemInfoListEntry : itemTypeInfo.itemTypeId2itemInfoList.entrySet())
/*     */               {
/* 336 */                 SItemInfoList itemInfoList = (SItemInfoList)itemInfoListEntry.getValue();
/* 337 */                 SItemInfo itemInfo = randomItemInfo(itemInfoList);
/* 338 */                 if (itemInfo != null)
/*     */                 {
/*     */ 
/*     */ 
/*     */ 
/* 343 */                   AucItemInfo xAucItemInfo = Pod.newAucItemInfo();
/* 344 */                   xAucItemInfo.setItemcfgid(itemInfo.id);
/* 345 */                   xAucItemInfo.setBidendtimestamp(turnStartTimeStamp + TimeUnit.SECONDS.toMillis(itemInfo.bidBaseTime));
/* 346 */                   xAucItemInfo.setBidendfinaltimestamp(xAucItemInfo.getBidendtimestamp() + TimeUnit.SECONDS.toMillis(itemInfo.bidOverTimeUnit * itemInfo.bidOverTimeMaxCount));
/*     */                   
/* 348 */                   xAuctionTurnInfo.getTemplateid2iteminfo().put(Integer.valueOf(itemInfo.id), xAucItemInfo);
/*     */                   
/*     */ 
/* 351 */                   startAuctionItemBeforeBidEndSession(xAucItemInfo, activityId, turnIndex);
/*     */                 }
/*     */               }
/*     */             }
/*     */           } } } }
/*     */     int turnIndex;
/*     */     long turnStartTimeStamp;
/*     */     AuctionTurnInfo xAuctionTurnInfo; }
/*     */   
/* 360 */   private static void resetAuctionPeriodInfo(ActivityPeriod activityPeriod, AuctionPeriodInfo xCurrentPeriodInfo) { xCurrentPeriodInfo.setPeriodstarttimestamp(activityPeriod.startTimeStamp);
/* 361 */     xCurrentPeriodInfo.setPeriodendtimestamp(activityPeriod.endTimeStamp);
/* 362 */     xCurrentPeriodInfo.setStatus(0);
/* 363 */     xCurrentPeriodInfo.getTurnindex2turninfo().clear();
/*     */   }
/*     */   
/*     */   static void copyAuctionPeriodInfo(AuctionPeriodInfo xFrom, AuctionPeriodInfo xTo)
/*     */   {
/* 368 */     xTo.setStatus(xFrom.getStatus());
/* 369 */     xTo.setPeriodstarttimestamp(xFrom.getPeriodstarttimestamp());
/* 370 */     xTo.setPeriodendtimestamp(xFrom.getPeriodendtimestamp());
/* 371 */     xTo.getTurnindex2turninfo().clear();
/* 372 */     for (Map.Entry<Integer, AuctionTurnInfo> entry : xFrom.getTurnindex2turninfo().entrySet())
/*     */     {
/* 374 */       xTo.getTurnindex2turninfo().put(entry.getKey(), ((AuctionTurnInfo)entry.getValue()).copy());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   static void copyAuctionRoleId2MergeInfo(Map<Long, AuctionMergeInfo> xFromMap, Map<Long, AuctionMergeInfo> xToMap)
/*     */   {
/* 381 */     for (Map.Entry<Long, AuctionMergeInfo> entry : xFromMap.entrySet())
/*     */     {
/* 383 */       xToMap.put(entry.getKey(), ((AuctionMergeInfo)entry.getValue()).copy());
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
/*     */   static AuctionActivityInfo getAuctionActivityInfoCreateIfNotExist(int activityId, ActivityPeriod currentActivityPeriod)
/*     */   {
/* 396 */     long globalTableKeyId = GameServerInfoManager.toGlobalId(activityId);
/*     */     
/* 398 */     AuctionActivityInfo xAuctionActivityInfo = Auctionactivityinfo.get(Long.valueOf(globalTableKeyId));
/* 399 */     if (xAuctionActivityInfo == null)
/*     */     {
/* 401 */       xAuctionActivityInfo = Pod.newAuctionActivityInfo();
/*     */       
/* 403 */       AuctionPeriodInfo xCurrentPeriodInfo = xAuctionActivityInfo.getCurrentperiodinfo();
/* 404 */       xCurrentPeriodInfo.setPeriodstarttimestamp(currentActivityPeriod.startTimeStamp);
/* 405 */       xCurrentPeriodInfo.setPeriodendtimestamp(currentActivityPeriod.endTimeStamp);
/* 406 */       xCurrentPeriodInfo.setStatus(0);
/*     */       
/* 408 */       Auctionactivityinfo.insert(Long.valueOf(globalTableKeyId), xAuctionActivityInfo);
/*     */     }
/* 410 */     return xAuctionActivityInfo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void checkPeriodAuctionItemAndRefund(int activityId, AuctionPeriodInfo xAuctionPeriodInfo, int mailId, LogReason logReason)
/*     */   {
/* 421 */     if (xAuctionPeriodInfo.getStatus() == 1)
/*     */     {
/* 423 */       return;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 428 */     for (Iterator i$ = xAuctionPeriodInfo.getTurnindex2turninfo().entrySet().iterator(); i$.hasNext();) { entry = (Map.Entry)i$.next();
/*     */       
/* 430 */       xAuctionTurnInfo = (AuctionTurnInfo)entry.getValue();
/* 431 */       for (AucItemInfo xAucItemInfo : xAuctionTurnInfo.getTemplateid2iteminfo().values())
/*     */       {
/* 433 */         refundBidderWhenClose(activityId, ((Integer)entry.getKey()).intValue(), xAuctionPeriodInfo, xAuctionTurnInfo, xAucItemInfo, mailId, logReason);
/*     */       }
/*     */     }
/*     */     Map.Entry<Integer, AuctionTurnInfo> entry;
/*     */     AuctionTurnInfo xAuctionTurnInfo;
/* 438 */     xAuctionPeriodInfo.setStatus(1);
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
/*     */   static boolean sendAuctionItemToRole(int activityId, int turnIndex, AuctionPeriodInfo xAuctionPeriodInfo, AuctionTurnInfo xAuctionTurnInfo, AucItemInfo xAucItemInfo)
/*     */   {
/* 455 */     GameServer.logger().info(String.format("[auction]AuctionManager.sendAuctionItemToRole@send item to role|roleId=%d|itemCfgId=%d|isSend=%d", new Object[] { Long.valueOf(xAucItemInfo.getBidderroleid()), Integer.valueOf(xAucItemInfo.getItemcfgid()), Integer.valueOf(xAucItemInfo.getIssend()) }));
/*     */     
/*     */ 
/*     */ 
/* 459 */     if ((xAucItemInfo.getIssend() == 1) || (xAucItemInfo.getBidderroleid() == 0L))
/*     */     {
/* 461 */       return false;
/*     */     }
/* 463 */     OrigAuctionItemCfg auctionItemCfg = OrigAuctionItemCfg.get(xAucItemInfo.getItemcfgid());
/* 464 */     if (auctionItemCfg == null)
/*     */     {
/* 466 */       return false;
/*     */     }
/* 468 */     SItemCfg itemCfg = SItemCfg.get(auctionItemCfg.itemCfgId);
/* 469 */     if (itemCfg == null)
/*     */     {
/* 471 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 475 */     int mailId = AuctionConsts.getInstance().WIN_BID_MAIL_ID;
/* 476 */     MailAttachment mailAttachment = new MailAttachment();
/* 477 */     mailAttachment.addItem(auctionItemCfg.itemCfgId, 1, auctionItemCfg.itemBindType == 1);
/* 478 */     SendMailRet sendMailRet = MailInterface.synBuildAndSendMail(xAucItemInfo.getBidderroleid(), mailId, new ArrayList(), Collections.singletonList(itemCfg.name), mailAttachment, new TLogArg(LogReason.AUCTION_BID_WIN_SEND_ITEM));
/*     */     
/*     */ 
/* 481 */     if (!sendMailRet.isOK())
/*     */     {
/* 483 */       return false;
/*     */     }
/*     */     
/* 486 */     xAucItemInfo.setIssend(1);
/*     */     
/* 488 */     sendBulletinInfo(xAucItemInfo.getBidderrolename(), Collections.singletonMap(Integer.valueOf(auctionItemCfg.itemCfgId), Integer.valueOf(1)), 50);
/*     */     
/*     */ 
/*     */ 
/* 492 */     AuctionTLogManager.tLogAuctionSendItemLog(xAucItemInfo.getBidderroleid(), activityId, xAuctionPeriodInfo.getPeriodstarttimestamp(), xAuctionPeriodInfo.getPeriodendtimestamp(), turnIndex, xAuctionTurnInfo.getTurnstarttimestamp(), xAuctionTurnInfo.getTurnendtimestamp(), xAucItemInfo.getItemcfgid(), xAucItemInfo.getBidendtimestamp(), xAucItemInfo.getMaxbidprice());
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 498 */     TriggerEventsManger.getInstance().triggerEvent(new AuctionBidWinEvent(), new mzm.gsp.auction.event.AuctionBidWinEventArg(xAucItemInfo.getBidderroleid(), activityId, turnIndex, xAucItemInfo.getMaxbidprice(), xAucItemInfo.getItemcfgid()));
/*     */     
/*     */ 
/*     */ 
/* 502 */     return true;
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
/*     */   static void startAuctionItemBeforeBidEndSession(AucItemInfo xAucItemInfo, int activityId, int turnIndex)
/*     */   {
/* 517 */     OrigAuctionItemCfg auctionItemCfg = OrigAuctionItemCfg.get(xAucItemInfo.getItemcfgid());
/* 518 */     if (auctionItemCfg == null)
/*     */     {
/* 520 */       return;
/*     */     }
/* 522 */     startAuctionItemBeforeBidEndSession(auctionItemCfg, xAucItemInfo, activityId, turnIndex);
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
/*     */   static void startAuctionItemBeforeBidEndSession(OrigAuctionItemCfg auctionItemCfg, AucItemInfo xAucItemInfo, int activityId, int turnIndex)
/*     */   {
/* 535 */     SimpleDateFormat simpleDateFormat = DateTimeUtils.getSimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/* 536 */     long currentTimeStamp = DateTimeUtils.getCurrTimeInMillis();
/* 537 */     GameServer.logger().info(String.format("[auction]AuctionManager.startAuctionItemBeforeBidEndSession@auction item|activityId=%d|turnIndex=%d|templateId=%d|itemEndTimeStamp=%s|itemFinalEndTimeStamp=%s|currentTimeStamp=%s", new Object[] { Integer.valueOf(activityId), Integer.valueOf(turnIndex), Integer.valueOf(xAucItemInfo.getItemcfgid()), simpleDateFormat.format(Long.valueOf(xAucItemInfo.getBidendtimestamp())), simpleDateFormat.format(Long.valueOf(xAucItemInfo.getBidendfinaltimestamp())), simpleDateFormat.format(Long.valueOf(currentTimeStamp)) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 542 */     if (TimeUnit.MILLISECONDS.toSeconds(xAucItemInfo.getBidendtimestamp()) <= TimeUnit.MILLISECONDS.toSeconds(currentTimeStamp)) {
/*     */       return;
/*     */     }
/*     */     
/*     */     Session session;
/*     */     
/*     */     Session session;
/* 549 */     if (TimeUnit.MILLISECONDS.toSeconds(xAucItemInfo.getBidendtimestamp()) - TimeUnit.MILLISECONDS.toSeconds(DateTimeUtils.getCurrTimeInMillis()) - auctionItemCfg.bidEndCountDownTime <= 0L)
/*     */     {
/*     */ 
/* 552 */       session = new AuctionItemBidEndSession(TimeUnit.MILLISECONDS.toSeconds(xAucItemInfo.getBidendtimestamp()) - TimeUnit.MILLISECONDS.toSeconds(DateTimeUtils.getCurrTimeInMillis()), xAucItemInfo.getItemcfgid(), activityId, turnIndex, auctionItemCfg.id);
/*     */ 
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/*     */ 
/* 559 */       session = new AuctionItemBeforeBidEndSession(TimeUnit.MILLISECONDS.toSeconds(xAucItemInfo.getBidendtimestamp()) - TimeUnit.MILLISECONDS.toSeconds(DateTimeUtils.getCurrTimeInMillis()) - auctionItemCfg.bidEndCountDownTime, xAucItemInfo.getItemcfgid(), activityId, turnIndex, auctionItemCfg.id);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 565 */     xAucItemInfo.setBidendsessionid(session.getSessionId());
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
/*     */   static void sendBulletinInfo(String roleName, Map<Integer, Integer> itemId2Count, int bulletinType)
/*     */   {
/* 578 */     GameServer.logger().info(String.format("[auction]AuctionManager.sendBulletinInfo@ bid win", new Object[0]));
/*     */     
/*     */ 
/*     */ 
/* 582 */     for (Map.Entry<Integer, Integer> entry : itemId2Count.entrySet())
/*     */     {
/* 584 */       int itemId = ((Integer)entry.getKey()).intValue();
/* 585 */       if (mzm.gsp.itembulletin.main.ItemBulletinInterface.needBulletin(itemId))
/*     */       {
/*     */ 
/*     */ 
/* 589 */         SBulletinInfo bulletinInfo = new SBulletinInfo();
/* 590 */         bulletinInfo.bulletintype = bulletinType;
/* 591 */         bulletinInfo.params.put(Integer.valueOf(1), roleName);
/* 592 */         bulletinInfo.params.put(Integer.valueOf(4), String.valueOf(itemId));
/* 593 */         bulletinInfo.params.put(Integer.valueOf(15), String.valueOf(entry.getValue()));
/* 594 */         BulletinInterface.sendBulletin(bulletinInfo);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void sendBulletinInfo(int itemCfgId, int bulletinType)
/*     */   {
/* 607 */     SBulletinInfo bulletinInfo = new SBulletinInfo();
/* 608 */     bulletinInfo.bulletintype = bulletinType;
/* 609 */     bulletinInfo.params.put(Integer.valueOf(4), String.valueOf(itemCfgId));
/* 610 */     BulletinInterface.sendBulletin(bulletinInfo);
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
/*     */   static AucItemInfo getAucItemInfo(int activityId, int turnIndex, int auctionItemCfgId, boolean isHoldAuctionLock)
/*     */   {
/* 623 */     AuctionTurnInfo xAuctionTurnInfo = getAuctionTurnInfo(activityId, turnIndex, isHoldAuctionLock);
/* 624 */     if (xAuctionTurnInfo == null)
/*     */     {
/* 626 */       return null;
/*     */     }
/* 628 */     return (AucItemInfo)xAuctionTurnInfo.getTemplateid2iteminfo().get(Integer.valueOf(auctionItemCfgId));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static AuctionTurnInfo getAuctionTurnInfo(int activityId, int turnIndex, boolean isHoldAuctionLock)
/*     */   {
/* 639 */     AuctionActivityInfo xAuctionActivityInfo = getAuctionActivityInfo(activityId, isHoldAuctionLock);
/*     */     
/* 641 */     if (xAuctionActivityInfo == null)
/*     */     {
/* 643 */       return null;
/*     */     }
/* 645 */     AuctionPeriodInfo xCurrentPeriodInfo = xAuctionActivityInfo.getCurrentperiodinfo();
/* 646 */     return (AuctionTurnInfo)xCurrentPeriodInfo.getTurnindex2turninfo().get(Integer.valueOf(turnIndex));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static AuctionActivityInfo getAuctionActivityInfo(int activityId, boolean isHoldAuctionLock)
/*     */   {
/* 656 */     long globalTableKeyId = GameServerInfoManager.toGlobalId(activityId);
/* 657 */     return isHoldAuctionLock ? Auctionactivityinfo.get(Long.valueOf(globalTableKeyId)) : Auctionactivityinfo.select(Long.valueOf(globalTableKeyId));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static ItemInfo getItemInfo(AucItemInfo xAucItemInfo)
/*     */     throws UnsupportedEncodingException
/*     */   {
/* 670 */     ItemInfo itemInfo = new ItemInfo();
/* 671 */     itemInfo.biddercount = xAucItemInfo.getBidderroleidset().size();
/* 672 */     itemInfo.bidderroleid = xAucItemInfo.getBidderroleid();
/* 673 */     itemInfo.biddername.setString(xAucItemInfo.getBidderrolename(), "utf-8");
/* 674 */     itemInfo.itemcfgid = xAucItemInfo.getItemcfgid();
/* 675 */     itemInfo.maxbidprice = xAucItemInfo.getMaxbidprice();
/* 676 */     itemInfo.bidendtimestamp = TimeUnit.MILLISECONDS.toSeconds(xAucItemInfo.getBidendtimestamp());
/* 677 */     return itemInfo;
/*     */   }
/*     */   
/*     */   public static Boolean checkMoneyForRole(String userId, long roleId, int moneyType, long moneyToCut, boolean isBindYuanBao)
/*     */   {
/* 682 */     long roleMoneyCount = getMoneyForRole(userId, roleId, moneyType, isBindYuanBao);
/* 683 */     return Boolean.valueOf(roleMoneyCount >= moneyToCut);
/*     */   }
/*     */   
/*     */   public static long getMoneyForRole(String userId, long roleId, int moneyType, boolean isBindYuanBao)
/*     */   {
/* 688 */     switch (moneyType)
/*     */     {
/*     */     case 3: 
/* 691 */       return RoleInterface.getSilver(roleId);
/*     */     case 2: 
/* 693 */       return RoleInterface.getGold(roleId);
/*     */     case 5: 
/* 695 */       return RoleInterface.getGoldIngot(roleId);
/*     */     case 1: 
/* 697 */       if (isBindYuanBao)
/*     */       {
/* 699 */         return QingfuInterface.getBalance(userId, true);
/*     */       }
/*     */       
/* 702 */       return QingfuInterface.getYuanbao(userId, true);
/*     */     case 4: 
/* 704 */       return mzm.gsp.gang.main.GangInterface.getBangGong(roleId);
/*     */     }
/* 706 */     return -1L;
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
/*     */   static boolean refundBidderWhenExceed(int activityId, int turnIndex, long newBidderRoleId, long newBidderMoneyCount, AuctionPeriodInfo xAuctionPeriodInfo, AuctionTurnInfo xAuctionTurnInfo, AucItemInfo xAucItemInfo)
/*     */   {
/* 726 */     int itemCfgId = xAucItemInfo.getItemcfgid();
/* 727 */     OrigAuctionItemCfg auctionItemCfg = OrigAuctionItemCfg.get(itemCfgId);
/* 728 */     if (auctionItemCfg == null)
/*     */     {
/* 730 */       return false;
/*     */     }
/*     */     
/* 733 */     long lastBidderRoleId = xAucItemInfo.getBidderroleid();
/* 734 */     if (lastBidderRoleId != 0L)
/*     */     {
/* 736 */       SItemCfg itemCfg = SItemCfg.get(auctionItemCfg.itemCfgId);
/* 737 */       if (itemCfg == null)
/*     */       {
/* 739 */         return false;
/*     */       }
/*     */       
/*     */ 
/* 743 */       int mailId = AuctionConsts.getInstance().LOSE_BID_MAIL_ID;
/* 744 */       MailAttachment mailAttachment = new MailAttachment();
/*     */       
/* 746 */       fillMailAttachment(auctionItemCfg, (int)xAucItemInfo.getMaxbidprice(), mailAttachment);
/*     */       
/* 748 */       List<String> mailContentArgList = new ArrayList();
/* 749 */       mailContentArgList.add(itemCfg.name);
/* 750 */       mailContentArgList.add(getMoneyNameFromMoneyType(auctionItemCfg.moneyType));
/* 751 */       mailContentArgList.add(String.valueOf(activityId));
/* 752 */       mailContentArgList.add(String.valueOf(turnIndex));
/* 753 */       mailContentArgList.add(String.valueOf(auctionItemCfg.id));
/*     */       
/* 755 */       SendMailRet sendMailRet = MailInterface.synBuildAndSendMail(lastBidderRoleId, mailId, new ArrayList(), mailContentArgList, mailAttachment, new TLogArg(LogReason.AUCTION_BID_LOSE_REFUND));
/*     */       
/* 757 */       if (!sendMailRet.isOK())
/*     */       {
/* 759 */         SimpleDateFormat simpleDateFormat = DateTimeUtils.getSimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/* 760 */         GameServer.logger().error(String.format("[auction]AuctionManager@refundBidderWhenExceed send mail fail|roleId=%d|mailId=%d|auctionItemId=%d|moneyCount=%d|activityId=%d|activityPeriodStartTimeStamp=%s|activityPeriodEndTimeStamp=%s|turnIndex=%d|turnStartTimeStamp=%s|turnEndTimeStamp=%s", new Object[] { Long.valueOf(lastBidderRoleId), Integer.valueOf(mailId), Integer.valueOf(xAucItemInfo.getItemcfgid()), Long.valueOf(xAucItemInfo.getMaxbidprice()), Integer.valueOf(activityId), simpleDateFormat.format(Long.valueOf(xAuctionPeriodInfo.getPeriodstarttimestamp())), simpleDateFormat.format(Long.valueOf(xAuctionPeriodInfo.getPeriodendtimestamp())), Integer.valueOf(turnIndex), simpleDateFormat.format(Long.valueOf(xAuctionTurnInfo.getTurnstarttimestamp())), simpleDateFormat.format(Long.valueOf(xAuctionTurnInfo.getTurnendtimestamp())) }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 770 */         return false;
/*     */       }
/*     */       
/* 773 */       AuctionTLogManager.tLogAuctionRefund(activityId, xAuctionPeriodInfo.getPeriodstarttimestamp(), xAuctionPeriodInfo.getPeriodendtimestamp(), turnIndex, xAuctionTurnInfo.getTurnstarttimestamp(), xAuctionTurnInfo.getTurnendtimestamp(), itemCfgId, lastBidderRoleId, xAucItemInfo.getMaxbidprice(), mailId, LogReason.AUCTION_BID_LOSE_REFUND.value, String.valueOf(newBidderRoleId) + "#" + newBidderMoneyCount);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 780 */     xAucItemInfo.setMaxbidprice(newBidderMoneyCount);
/* 781 */     xAucItemInfo.setBidderroleid(newBidderRoleId);
/* 782 */     String roleName = RoleInterface.getName(newBidderRoleId);
/* 783 */     xAucItemInfo.setBidderrolename(roleName == null ? "" : roleName);
/* 784 */     xAucItemInfo.getBidderroleidset().add(Long.valueOf(newBidderRoleId));
/*     */     
/*     */ 
/* 787 */     SimpleDateFormat simpleDateFormat = DateTimeUtils.getSimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/*     */     
/* 789 */     long currentTimeStamp = DateTimeUtils.getCurrTimeInMillis();
/* 790 */     long leftBidTimeInSecond = TimeUnit.MILLISECONDS.toSeconds(xAucItemInfo.getBidendtimestamp() - currentTimeStamp);
/* 791 */     GameServer.logger().info(String.format("[auction]AuctionManager.refundBidderWhenExceed@ oldBidEndTimeStamp=%s|currentTimeStamp=%s|leftBidTimeInSecond=%d", new Object[] { simpleDateFormat.format(Long.valueOf(xAucItemInfo.getBidendtimestamp())), simpleDateFormat.format(Long.valueOf(currentTimeStamp)), Long.valueOf(leftBidTimeInSecond) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 796 */     if ((leftBidTimeInSecond <= auctionItemCfg.bidEndCountDownTime) && (xAucItemInfo.getBidendtimestamp() < xAucItemInfo.getBidendfinaltimestamp()))
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/* 801 */       xAucItemInfo.setBidendtimestamp(xAucItemInfo.getBidendtimestamp() + TimeUnit.SECONDS.toMillis(auctionItemCfg.bidOverTimeUnit));
/*     */       
/*     */ 
/*     */ 
/* 805 */       Session.removeSession(xAucItemInfo.getBidendsessionid(), itemCfgId);
/*     */       
/* 807 */       startAuctionItemBeforeBidEndSession(auctionItemCfg, xAucItemInfo, activityId, turnIndex);
/*     */     }
/*     */     
/* 810 */     return true;
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
/*     */   static boolean refundBidderWhenClose(int activityId, int turnIndex, AuctionPeriodInfo xAuctionPeriodInfo, AuctionTurnInfo xAuctionTurnInfo, AucItemInfo xAucItemInfo, int mailId, LogReason logReason)
/*     */   {
/* 824 */     if (xAucItemInfo.getIssend() == 1)
/*     */     {
/* 826 */       return true;
/*     */     }
/*     */     
/* 829 */     OrigAuctionItemCfg auctionItemCfg = OrigAuctionItemCfg.get(xAucItemInfo.getItemcfgid());
/* 830 */     if (auctionItemCfg == null)
/*     */     {
/* 832 */       return false;
/*     */     }
/*     */     
/* 835 */     long bidderRoleId = xAucItemInfo.getBidderroleid();
/* 836 */     if (bidderRoleId == 0L)
/*     */     {
/* 838 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 843 */     MailAttachment mailAttachment = new MailAttachment();
/* 844 */     fillMailAttachment(auctionItemCfg, (int)xAucItemInfo.getMaxbidprice(), mailAttachment);
/*     */     
/* 846 */     String moneyName = getMoneyNameFromMoneyType(auctionItemCfg.moneyType);
/*     */     
/*     */ 
/* 849 */     List<String> mailTitleArgList = new ArrayList();
/* 850 */     mailTitleArgList.add(moneyName);
/*     */     
/*     */ 
/* 853 */     List<String> mailContentArgList = new ArrayList();
/* 854 */     mailContentArgList.add(moneyName);
/*     */     
/*     */ 
/* 857 */     MailInterface.asynBuildAndSendMail(bidderRoleId, mailId, mailTitleArgList, mailContentArgList, mailAttachment, new TLogArg(logReason));
/*     */     
/*     */ 
/* 860 */     AuctionTLogManager.tLogAuctionRefund(activityId, xAuctionPeriodInfo.getPeriodstarttimestamp(), xAuctionPeriodInfo.getPeriodendtimestamp(), turnIndex, xAuctionTurnInfo.getTurnstarttimestamp(), xAuctionTurnInfo.getTurnendtimestamp(), xAucItemInfo.getItemcfgid(), bidderRoleId, xAucItemInfo.getMaxbidprice(), mailId, logReason.value, "");
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 866 */     xAucItemInfo.getBidderroleidset().clear();
/* 867 */     xAucItemInfo.setBidderroleid(0L);
/* 868 */     xAucItemInfo.setBidderrolename("");
/* 869 */     xAucItemInfo.setMaxbidprice(0L);
/*     */     
/*     */ 
/* 872 */     xAucItemInfo.setBidendtimestamp(xAuctionTurnInfo.getTurnstarttimestamp() + TimeUnit.SECONDS.toMillis(auctionItemCfg.bidBaseTime));
/*     */     
/*     */ 
/*     */ 
/* 876 */     Session.removeSession(xAucItemInfo.getBidendsessionid(), xAucItemInfo.getItemcfgid());
/* 877 */     xAucItemInfo.setBidendsessionid(0L);
/*     */     
/* 879 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   static void fillMailAttachment(OrigAuctionItemCfg auctionItemCfg, int moneyCount, MailAttachment mailAttachment)
/*     */   {
/* 885 */     switch (auctionItemCfg.moneyType)
/*     */     {
/*     */     case 1: 
/* 888 */       if (auctionItemCfg.yuanBaoType == 2)
/*     */       {
/* 890 */         mailAttachment.setBindYuanBao(moneyCount);
/*     */       }
/*     */       else
/*     */       {
/* 894 */         mailAttachment.setYuanBao(moneyCount);
/*     */       }
/* 896 */       break;
/*     */     case 2: 
/* 898 */       mailAttachment.setGold(moneyCount);
/* 899 */       break;
/*     */     case 3: 
/* 901 */       mailAttachment.setSilver(moneyCount);
/* 902 */       break;
/*     */     case 5: 
/* 904 */       mailAttachment.setGoldIngot(moneyCount);
/* 905 */       break;
/*     */     case 4: default: 
/* 907 */       GameServer.logger().error(String.format("[auction]AuctionManager.fillMailAttachment@no support money type for mail attachment|moneyType=%d", new Object[] { Integer.valueOf(auctionItemCfg.moneyType) }));
/*     */     }
/*     */     
/*     */   }
/*     */   
/*     */ 
/*     */   static long getBidderRoleId(int activityId, int turnIndex, int itemCfgId, boolean isHoldAuctionLock)
/*     */   {
/* 915 */     AucItemInfo xAucItemInfo = getAucItemInfo(activityId, turnIndex, itemCfgId, isHoldAuctionLock);
/* 916 */     if (xAucItemInfo == null)
/*     */     {
/* 918 */       return 0L;
/*     */     }
/* 920 */     return xAucItemInfo.getBidderroleid();
/*     */   }
/*     */   
/*     */   static String getMoneyNameFromMoneyType(int moneyType)
/*     */   {
/* 925 */     switch (moneyType)
/*     */     {
/*     */     case 1: 
/* 928 */       return "元宝";
/*     */     case 2: 
/* 930 */       return "金币";
/*     */     case 3: 
/* 932 */       return "银币";
/*     */     case 4: 
/* 934 */       return "帮贡";
/*     */     case 5: 
/* 936 */       return "金锭";
/*     */     }
/* 938 */     return "";
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\auction\main\AuctionManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
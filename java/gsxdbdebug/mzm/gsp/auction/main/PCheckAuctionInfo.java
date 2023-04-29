/*     */ package mzm.gsp.auction.main;
/*     */ 
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.auction.confbean.AuctionConsts;
/*     */ import mzm.gsp.auction.confbean.OrigAuctionItemCfg;
/*     */ import mzm.gsp.mail.main.MailAttachment;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import xbean.AuctionActivityInfo;
/*     */ import xbean.AuctionMergeInfo;
/*     */ import xbean.AuctionPeriodInfo;
/*     */ import xbean.AuctionRefundInfo;
/*     */ import xtable.Auctionactivityinfo;
/*     */ 
/*     */ public class PCheckAuctionInfo extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   final int activityId;
/*     */   
/*     */   public PCheckAuctionInfo(int activityId)
/*     */   {
/*  29 */     this.activityId = activityId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  35 */     long globalTableKeyId = GameServerInfoManager.toGlobalId(this.activityId);
/*     */     
/*     */ 
/*  38 */     AuctionActivityInfo xAuctionActivityInfo = Auctionactivityinfo.get(Long.valueOf(globalTableKeyId));
/*  39 */     if (xAuctionActivityInfo == null)
/*     */     {
/*  41 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  45 */     AuctionPeriodInfo xCurrentPeriodInfo = xAuctionActivityInfo.getCurrentperiodinfo();
/*  46 */     long currentTimeStamp = DateTimeUtils.getCurrTimeInMillis();
/*  47 */     if (xCurrentPeriodInfo.getPeriodendtimestamp() < currentTimeStamp)
/*     */     {
/*     */ 
/*  50 */       AuctionManager.checkPeriodAuctionItemAndRefund(this.activityId, xCurrentPeriodInfo, AuctionConsts.getInstance().SERVER_CLOSE_REFUND_MAIL_ID, LogReason.AUCTION_SERVER_CLOSE_REFUND);
/*     */     }
/*     */     
/*     */ 
/*  54 */     AuctionOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(this.activityId), new PCheckAuctionMergeInfo(this.activityId));
/*     */     
/*  56 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   static class PCheckAuctionMergeInfo
/*     */     extends mzm.gsp.util.LogicProcedure
/*     */   {
/*     */     final int activityId;
/*     */     
/*     */ 
/*     */     PCheckAuctionMergeInfo(int activityId)
/*     */     {
/*  68 */       this.activityId = activityId;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  74 */       long globalTableKeyId = GameServerInfoManager.toGlobalId(this.activityId);
/*     */       
/*     */ 
/*  77 */       AuctionActivityInfo xAuctionActivityInfo = Auctionactivityinfo.select(Long.valueOf(globalTableKeyId));
/*  78 */       if (xAuctionActivityInfo == null)
/*     */       {
/*  80 */         return false;
/*     */       }
/*     */       
/*  83 */       Map<Long, AuctionMergeInfo> xAuctionMergeInfoMap = xAuctionActivityInfo.getRoleid2mergeinfo();
/*  84 */       Set<Long> roleIdsToLock = new HashSet();
/*     */       
/*  86 */       for (Map.Entry<Long, AuctionMergeInfo> entry : xAuctionMergeInfoMap.entrySet())
/*     */       {
/*  88 */         roleIdsToLock.add(entry.getKey());
/*     */       }
/*     */       
/*     */ 
/*  92 */       lock(xtable.Basic.getTable(), roleIdsToLock);
/*     */       
/*  94 */       lock(xdb.Lockeys.get(Auctionactivityinfo.getTable(), Long.valueOf(globalTableKeyId)));
/*     */       
/*     */ 
/*  97 */       Set<Long> roleIds = new HashSet();
/*  98 */       for (Map.Entry<Long, AuctionMergeInfo> entry : xAuctionMergeInfoMap.entrySet())
/*     */       {
/* 100 */         roleIds.add(entry.getKey());
/*     */       }
/* 102 */       if ((roleIds.size() != roleIdsToLock.size()) || (!roleIds.containsAll(roleIdsToLock)))
/*     */       {
/* 104 */         return false;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 114 */       Iterator<Map.Entry<Long, AuctionMergeInfo>> xAuctionMergeInfoEntryIterator = xAuctionMergeInfoMap.entrySet().iterator();
/*     */       
/*     */ 
/*     */ 
/* 118 */       while (xAuctionMergeInfoEntryIterator.hasNext())
/*     */       {
/* 120 */         Map.Entry<Long, AuctionMergeInfo> xAuctionMergeInfoEntry = (Map.Entry)xAuctionMergeInfoEntryIterator.next();
/* 121 */         long roleId = ((Long)xAuctionMergeInfoEntry.getKey()).longValue();
/* 122 */         AuctionMergeInfo xAuctionMergeInfo = (AuctionMergeInfo)xAuctionMergeInfoEntry.getValue();
/*     */         
/* 124 */         Iterator<AuctionRefundInfo> xAuctionRefundInfoListIterator = xAuctionMergeInfo.getRefundinfolist().iterator();
/* 125 */         while (xAuctionRefundInfoListIterator.hasNext())
/*     */         {
/* 127 */           AuctionRefundInfo xAuctionRefundInfo = (AuctionRefundInfo)xAuctionRefundInfoListIterator.next();
/* 128 */           OrigAuctionItemCfg auctionItemCfg = OrigAuctionItemCfg.get(xAuctionRefundInfo.getItemcfgid());
/* 129 */           if (auctionItemCfg != null)
/*     */           {
/*     */ 
/*     */ 
/* 133 */             MailAttachment mailAttachment = new MailAttachment();
/* 134 */             AuctionManager.fillMailAttachment(auctionItemCfg, (int)xAuctionRefundInfo.getMoneycount(), mailAttachment);
/*     */             
/* 136 */             String moneyName = AuctionManager.getMoneyNameFromMoneyType(auctionItemCfg.moneyType);
/*     */             
/*     */ 
/* 139 */             List<String> mailTitleArgList = new ArrayList();
/* 140 */             mailTitleArgList.add(moneyName);
/*     */             
/*     */ 
/* 143 */             List<String> mailContentArgList = new ArrayList();
/* 144 */             mailContentArgList.add(moneyName);
/*     */             
/* 146 */             mzm.gsp.mail.main.SendMailRet sendMailRet = mzm.gsp.mail.main.MailInterface.synBuildAndSendMail(roleId, AuctionConsts.getInstance().SERVER_MERGE_REFUND_MAIL_ID, mailTitleArgList, mailContentArgList, mailAttachment, new mzm.gsp.tlog.TLogArg(LogReason.AUCTION_SERVER_MERGE_REFUND));
/*     */             
/*     */ 
/* 149 */             if (sendMailRet.isOK())
/*     */             {
/* 151 */               xAuctionRefundInfoListIterator.remove();
/* 152 */               AuctionTLogManager.tLogAuctionRefund(this.activityId, xAuctionRefundInfo.getActivityperiodstarttimestamp(), xAuctionRefundInfo.getActivityperiodendtimestamp(), xAuctionRefundInfo.getTurnindex(), xAuctionRefundInfo.getTurnstarttimestamp(), xAuctionRefundInfo.getTurnendtimestamp(), xAuctionRefundInfo.getItemcfgid(), roleId, xAuctionRefundInfo.getMoneycount(), AuctionConsts.getInstance().SERVER_MERGE_REFUND_MAIL_ID, LogReason.AUCTION_SERVER_MERGE_REFUND.value, "");
/*     */ 
/*     */ 
/*     */ 
/*     */             }
/*     */             else
/*     */             {
/*     */ 
/*     */ 
/* 161 */               SimpleDateFormat simpleDateFormat = DateTimeUtils.getSimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/* 162 */               mzm.gsp.GameServer.logger().error(String.format("[auction]PCheckAuctionInfo.PCheckAuctionMergeInfo@processImp send mail fail|roleId=%d|mailId=%d|auctionItemId=%d|moneyCount=%d|activityId=%d|activityPeriodStartTimeStamp=%s|activityPeriodEndTimeStamp=%s|turnIndex=%d|turnStartTimeStamp=%s|turnEndTimeStamp=%s", new Object[] { Long.valueOf(roleId), Integer.valueOf(AuctionConsts.getInstance().SERVER_MERGE_REFUND_MAIL_ID), Integer.valueOf(xAuctionRefundInfo.getItemcfgid()), Long.valueOf(xAuctionRefundInfo.getMoneycount()), Integer.valueOf(this.activityId), simpleDateFormat.format(Long.valueOf(xAuctionRefundInfo.getActivityperiodstarttimestamp())), simpleDateFormat.format(Long.valueOf(xAuctionRefundInfo.getActivityperiodendtimestamp())), Integer.valueOf(xAuctionRefundInfo.getTurnindex()), simpleDateFormat.format(Long.valueOf(xAuctionRefundInfo.getTurnstarttimestamp())), simpleDateFormat.format(Long.valueOf(xAuctionRefundInfo.getTurnendtimestamp())) }));
/*     */             }
/*     */           }
/*     */         }
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
/* 177 */         if (xAuctionMergeInfo.getRefundinfolist().isEmpty())
/*     */         {
/* 179 */           xAuctionMergeInfoEntryIterator.remove();
/*     */         }
/*     */       }
/* 182 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\auction\main\PCheckAuctionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
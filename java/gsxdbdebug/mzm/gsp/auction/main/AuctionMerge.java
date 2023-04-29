/*     */ package mzm.gsp.auction.main;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import xbean.AucItemInfo;
/*     */ import xbean.AuctionActivityInfo;
/*     */ import xbean.AuctionMergeInfo;
/*     */ import xbean.AuctionPeriodInfo;
/*     */ import xbean.AuctionRefundInfo;
/*     */ import xbean.AuctionTurnInfo;
/*     */ import xtable.Auctionactivityinfo;
/*     */ 
/*     */ public class AuctionMerge implements mzm.gsp.MergeModule
/*     */ {
/*     */   public List<xdb.Table> getHandleTables()
/*     */   {
/*  21 */     List<xdb.Table> result = new java.util.ArrayList();
/*  22 */     result.add(Auctionactivityinfo.getTable());
/*  23 */     return result;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean handleMerge()
/*     */   {
/*  29 */     return new PAuctionMerge().call();
/*     */   }
/*     */   
/*     */   class PAuctionMerge extends mzm.gsp.util.LogicProcedure
/*     */   {
/*     */     PAuctionMerge() {}
/*     */     
/*     */     protected boolean processImp() throws Exception
/*     */     {
/*  38 */       Set<Integer> activityIdSet = mzm.gsp.auction.confbean.SAuctionActivityCfg.getAll().keySet();
/*  39 */       if ((activityIdSet == null) || (activityIdSet.isEmpty()))
/*     */       {
/*  41 */         return false;
/*     */       }
/*     */       
/*  44 */       long mainZoneId = mzm.gsp.MergeMain.getMainZoneid();
/*  45 */       long viceZoneId = mzm.gsp.MergeMain.getViceZoneid();
/*     */       
/*  47 */       Set<Long> mainKeySet = new java.util.HashSet();
/*  48 */       Set<Long> viceKeySet = new java.util.HashSet();
/*     */       
/*  50 */       for (Iterator i$ = activityIdSet.iterator(); i$.hasNext();) { int activityId = ((Integer)i$.next()).intValue();
/*     */         
/*  52 */         mainKeySet.add(Long.valueOf(GameServerInfoManager.toGlobalId(activityId, mainZoneId)));
/*  53 */         viceKeySet.add(Long.valueOf(GameServerInfoManager.toGlobalId(activityId, viceZoneId)));
/*     */       }
/*     */       
/*  56 */       Set<Long> totalKeySet = new java.util.HashSet(mainKeySet.size() + viceKeySet.size());
/*  57 */       totalKeySet.addAll(mainKeySet);
/*  58 */       totalKeySet.addAll(viceKeySet);
/*     */       
/*  60 */       lock(Auctionactivityinfo.getTable(), totalKeySet);
/*     */       
/*     */ 
/*     */ 
/*  64 */       for (Iterator i$ = activityIdSet.iterator(); i$.hasNext();) { int activityId = ((Integer)i$.next()).intValue();
/*     */         
/*  66 */         long viceKey = GameServerInfoManager.toGlobalId(activityId, viceZoneId);
/*  67 */         AuctionActivityInfo xViceAuctionActivityInfo = Auctionactivityinfo.get(Long.valueOf(viceKey));
/*  68 */         if (xViceAuctionActivityInfo != null)
/*     */         {
/*     */ 
/*     */ 
/*  72 */           long mainKey = GameServerInfoManager.toGlobalId(activityId, mainZoneId);
/*  73 */           AuctionActivityInfo xMainActionActivityInfo = Auctionactivityinfo.get(Long.valueOf(mainKey));
/*  74 */           if (xMainActionActivityInfo == null)
/*     */           {
/*  76 */             xMainActionActivityInfo = xbean.Pod.newAuctionActivityInfo();
/*  77 */             Auctionactivityinfo.insert(Long.valueOf(mainKey), xMainActionActivityInfo);
/*     */             
/*  79 */             AuctionManager.copyAuctionPeriodInfo(xViceAuctionActivityInfo.getCurrentperiodinfo(), xMainActionActivityInfo.getCurrentperiodinfo());
/*     */             
/*  81 */             AuctionManager.copyAuctionPeriodInfo(xViceAuctionActivityInfo.getLastperiodinfo(), xMainActionActivityInfo.getLastperiodinfo());
/*     */             
/*  83 */             AuctionManager.copyAuctionRoleId2MergeInfo(xViceAuctionActivityInfo.getRoleid2mergeinfo(), xMainActionActivityInfo.getRoleid2mergeinfo());
/*     */ 
/*     */ 
/*     */           }
/*     */           else
/*     */           {
/*     */ 
/*  90 */             AuctionMerge.this.addMergeInfo(xViceAuctionActivityInfo.getRoleid2mergeinfo(), xViceAuctionActivityInfo.getCurrentperiodinfo());
/*     */             
/*  92 */             AuctionManager.copyAuctionRoleId2MergeInfo(xViceAuctionActivityInfo.getRoleid2mergeinfo(), xMainActionActivityInfo.getRoleid2mergeinfo());
/*     */           }
/*     */         }
/*     */       }
/*     */       
/*  97 */       for (Iterator i$ = viceKeySet.iterator(); i$.hasNext();) { long vKey = ((Long)i$.next()).longValue();
/*     */         
/*  99 */         Auctionactivityinfo.remove(Long.valueOf(vKey));
/*     */       }
/*     */       
/* 102 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void addMergeInfo(Map<Long, AuctionMergeInfo> roleId2MergeInfo, AuctionPeriodInfo xAuctionPeriodInfo)
/*     */   {
/* 110 */     if (xAuctionPeriodInfo.getStatus() == 1)
/*     */     {
/* 112 */       return;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 120 */     for (Iterator i$ = xAuctionPeriodInfo.getTurnindex2turninfo().entrySet().iterator(); i$.hasNext();) { entry = (Map.Entry)i$.next();
/*     */       
/* 122 */       xAuctionTurnInfo = (AuctionTurnInfo)entry.getValue();
/* 123 */       for (AucItemInfo xAucItemInfo : xAuctionTurnInfo.getTemplateid2iteminfo().values())
/*     */       {
/* 125 */         if (xAucItemInfo.getIssend() != 1)
/*     */         {
/*     */ 
/*     */ 
/* 129 */           long roleId = xAucItemInfo.getBidderroleid();
/* 130 */           if (roleId != 0L)
/*     */           {
/*     */             AuctionMergeInfo xAuctionMergeInfo;
/*     */             AuctionMergeInfo xAuctionMergeInfo;
/* 134 */             if (roleId2MergeInfo.containsKey(Long.valueOf(roleId)))
/*     */             {
/* 136 */               xAuctionMergeInfo = (AuctionMergeInfo)roleId2MergeInfo.get(Long.valueOf(roleId));
/*     */             }
/*     */             else
/*     */             {
/* 140 */               xAuctionMergeInfo = xbean.Pod.newAuctionMergeInfo();
/* 141 */               roleId2MergeInfo.put(Long.valueOf(roleId), xAuctionMergeInfo);
/*     */             }
/* 143 */             List<AuctionRefundInfo> auctionRefundInfoList = xAuctionMergeInfo.getRefundinfolist();
/* 144 */             AuctionRefundInfo xAuctionRefundInfo = xbean.Pod.newAuctionRefundInfo();
/*     */             
/* 146 */             xAuctionRefundInfo.setActivityperiodstarttimestamp(xAuctionPeriodInfo.getPeriodstarttimestamp());
/* 147 */             xAuctionRefundInfo.setActivityperiodendtimestamp(xAuctionPeriodInfo.getPeriodendtimestamp());
/* 148 */             xAuctionRefundInfo.setTurnindex(((Integer)entry.getKey()).intValue());
/* 149 */             xAuctionRefundInfo.setTurnstarttimestamp(xAuctionTurnInfo.getTurnstarttimestamp());
/* 150 */             xAuctionRefundInfo.setTurnendtimestamp(xAuctionTurnInfo.getTurnendtimestamp());
/* 151 */             xAuctionRefundInfo.setItemcfgid(xAucItemInfo.getItemcfgid());
/* 152 */             xAuctionRefundInfo.setMoneycount(xAucItemInfo.getMaxbidprice());
/*     */             
/* 154 */             auctionRefundInfoList.add(xAuctionRefundInfo); } } } }
/*     */     Map.Entry<Integer, AuctionTurnInfo> entry;
/*     */     AuctionTurnInfo xAuctionTurnInfo;
/* 157 */     xAuctionPeriodInfo.setStatus(1);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\auction\main\AuctionMerge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
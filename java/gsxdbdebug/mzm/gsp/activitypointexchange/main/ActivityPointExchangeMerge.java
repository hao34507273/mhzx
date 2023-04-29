/*     */ package mzm.gsp.activitypointexchange.main;
/*     */ 
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.MergeMain;
/*     */ import mzm.gsp.activitypointexchange.confbean.TActivityPointExchangeActivityCfg;
/*     */ import xbean.ActivityPointExchangeGlobalInfo;
/*     */ import xbean.ActivityPointExchangeMallGlobalInfo;
/*     */ import xtable.Activity2activitypointexchangeglobalinfo;
/*     */ 
/*     */ public class ActivityPointExchangeMerge implements mzm.gsp.MergeModule
/*     */ {
/*  17 */   private static final org.apache.log4j.Logger LOGGER = org.apache.log4j.Logger.getLogger(ActivityPointExchangeMerge.class);
/*     */   
/*     */ 
/*     */   public List<xdb.Table> getHandleTables()
/*     */   {
/*  22 */     List<xdb.Table> result = new java.util.ArrayList();
/*  23 */     result.add(xtable.Role2activitypointexchangeinfo.getTable());
/*  24 */     result.add(Activity2activitypointexchangeglobalinfo.getTable());
/*  25 */     return result;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean handleMerge()
/*     */   {
/*  31 */     if (!new GlobalInfoMerge().call())
/*     */     {
/*  33 */       return false;
/*     */     }
/*     */     
/*  36 */     return true;
/*     */   }
/*     */   
/*     */   class GlobalInfoMerge extends mzm.gsp.util.LogicProcedure
/*     */   {
/*     */     GlobalInfoMerge() {}
/*     */     
/*     */     protected boolean processImp() throws Exception {
/*  44 */       long mainZoneId = MergeMain.getMainZoneid();
/*  45 */       long viceZoneId = MergeMain.getViceZoneid();
/*     */       
/*  47 */       Set<Long> mainKeySet = new HashSet();
/*  48 */       Set<Long> viceKeySet = new HashSet();
/*     */       
/*  50 */       for (Iterator i$ = TActivityPointExchangeActivityCfg.getAll().keySet().iterator(); i$.hasNext();) { int activityId = ((Integer)i$.next()).intValue();
/*     */         
/*  52 */         mainKeySet.add(Long.valueOf(GameServerInfoManager.toGlobalId(activityId, mainZoneId)));
/*  53 */         viceKeySet.add(Long.valueOf(GameServerInfoManager.toGlobalId(activityId, viceZoneId)));
/*     */       }
/*     */       
/*  56 */       Set<Long> totalKeySet = new HashSet(mainKeySet.size() + viceKeySet.size());
/*  57 */       totalKeySet.addAll(mainKeySet);
/*  58 */       totalKeySet.addAll(viceKeySet);
/*     */       
/*  60 */       lock(Activity2activitypointexchangeglobalinfo.getTable(), totalKeySet);
/*     */       
/*     */ 
/*     */ 
/*  64 */       Set<Integer> mallCfgIdSet = new HashSet();
/*     */       
/*     */ 
/*     */ 
/*  68 */       for (Iterator i$ = TActivityPointExchangeActivityCfg.getAll().keySet().iterator(); i$.hasNext();) { int activityId = ((Integer)i$.next()).intValue();
/*     */         
/*  70 */         long viceKey = GameServerInfoManager.toGlobalId(activityId, viceZoneId);
/*  71 */         xViceGlobalInfo = Activity2activitypointexchangeglobalinfo.get(Long.valueOf(viceKey));
/*  72 */         if (xViceGlobalInfo != null)
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*  77 */           long mainKey = GameServerInfoManager.toGlobalId(activityId, mainZoneId);
/*  78 */           xMainGlobalInfo = Activity2activitypointexchangeglobalinfo.get(Long.valueOf(mainKey));
/*  79 */           if (xMainGlobalInfo == null)
/*     */           {
/*  81 */             xMainGlobalInfo = xbean.Pod.newActivityPointExchangeGlobalInfo();
/*  82 */             Activity2activitypointexchangeglobalinfo.insert(Long.valueOf(mainKey), xMainGlobalInfo);
/*     */           }
/*     */           
/*  85 */           mallCfgIdSet.clear();
/*  86 */           mallCfgIdSet.addAll(xMainGlobalInfo.getMallcfgid2mallinfo().keySet());
/*  87 */           mallCfgIdSet.addAll(xViceGlobalInfo.getMallcfgid2mallinfo().keySet());
/*     */           
/*  89 */           for (i$ = mallCfgIdSet.iterator(); i$.hasNext();) { int mallCfgId = ((Integer)i$.next()).intValue();
/*     */             
/*  91 */             if (xViceGlobalInfo.getMallcfgid2mallinfo().containsKey(Integer.valueOf(mallCfgId)))
/*     */             {
/*     */ 
/*     */ 
/*  95 */               ActivityPointExchangeMallGlobalInfo xViceMallGlobalInfo = (ActivityPointExchangeMallGlobalInfo)xViceGlobalInfo.getMallcfgid2mallinfo().get(Integer.valueOf(mallCfgId));
/*     */               ActivityPointExchangeMallGlobalInfo xMainMallGlobalInfo;
/*  97 */               if (!xMainGlobalInfo.getMallcfgid2mallinfo().containsKey(Integer.valueOf(mallCfgId)))
/*     */               {
/*  99 */                 ActivityPointExchangeMallGlobalInfo xMainMallGlobalInfo = xbean.Pod.newActivityPointExchangeMallGlobalInfo();
/* 100 */                 xMainGlobalInfo.getMallcfgid2mallinfo().put(Integer.valueOf(mallCfgId), xMainMallGlobalInfo);
/*     */               }
/*     */               else
/*     */               {
/* 104 */                 xMainMallGlobalInfo = (ActivityPointExchangeMallGlobalInfo)xMainGlobalInfo.getMallcfgid2mallinfo().get(Integer.valueOf(mallCfgId));
/*     */               }
/* 106 */               xMainMallGlobalInfo.getSoldoutgoodscfgidset().addAll(xViceMallGlobalInfo.getSoldoutgoodscfgidset()); } } } }
/*     */       ActivityPointExchangeGlobalInfo xViceGlobalInfo;
/*     */       ActivityPointExchangeGlobalInfo xMainGlobalInfo;
/*     */       Iterator i$;
/* 110 */       for (Iterator i$ = viceKeySet.iterator(); i$.hasNext();) { long vKey = ((Long)i$.next()).longValue();
/*     */         
/* 112 */         Activity2activitypointexchangeglobalinfo.remove(Long.valueOf(vKey));
/*     */       }
/* 114 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activitypointexchange\main\ActivityPointExchangeMerge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
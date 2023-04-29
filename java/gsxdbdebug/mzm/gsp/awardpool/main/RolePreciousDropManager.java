/*     */ package mzm.gsp.awardpool.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.awardpool.confbean.SPreciousDropCfg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import xbean.IdCounter;
/*     */ import xbean.ItemSubid2Count;
/*     */ import xbean.Pod;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RolePreciousDropManager
/*     */ {
/*     */   static List<Integer> getPreciousItemSubIdsFrom(Map<Integer, Integer> itemSubId2PreciousCfgId, ItemSubid2Count xItemSubid2Count)
/*     */   {
/*  24 */     if ((itemSubId2PreciousCfgId == null) || (itemSubId2PreciousCfgId.isEmpty()))
/*     */     {
/*  26 */       return null;
/*     */     }
/*  28 */     List<Integer> canRandonPreciousSubIds = new ArrayList();
/*  29 */     for (Iterator i$ = itemSubId2PreciousCfgId.keySet().iterator(); i$.hasNext();) { int itemSubid = ((Integer)i$.next()).intValue();
/*     */       
/*     */ 
/*  32 */       SPreciousDropCfg peCfg = SPreciousDropCfg.get(((Integer)itemSubId2PreciousCfgId.get(Integer.valueOf(itemSubid))).intValue());
/*  33 */       if (peCfg != null)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*  38 */         IdCounter xIdCounter = (IdCounter)xItemSubid2Count.getItemsubid2count().get(Integer.valueOf(itemSubid));
/*  39 */         if (xIdCounter == null)
/*     */         {
/*  41 */           xIdCounter = Pod.newIdCounter();
/*  42 */           xIdCounter.setModifytime(DateTimeUtils.getCurrTimeInMillis());
/*  43 */           xItemSubid2Count.getItemsubid2count().put(Integer.valueOf(itemSubid), xIdCounter);
/*     */         }
/*     */         
/*     */ 
/*  47 */         int unHitCount = xIdCounter.getUnhitcount();
/*     */         
/*  49 */         int dropCount = xIdCounter.getDropcount();
/*     */         
/*  51 */         int roleMaxDropCount = 0;
/*  52 */         int roleDropNeedCount = 0;
/*  53 */         if (xIdCounter.getHistorydropcount() >= peCfg.roleMaxDropCount1)
/*     */         {
/*  55 */           roleMaxDropCount = peCfg.roleMaxDropCount2;
/*  56 */           roleDropNeedCount = peCfg.roleDropNeedCount2;
/*     */         }
/*     */         else
/*     */         {
/*  60 */           roleMaxDropCount = peCfg.roleMaxDropCount1;
/*  61 */           roleDropNeedCount = peCfg.roleDropNeedCount1;
/*     */         }
/*     */         
/*  64 */         if ((dropCount < roleMaxDropCount) && 
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*  69 */           (unHitCount >= roleDropNeedCount))
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  75 */           canRandonPreciousSubIds.add(Integer.valueOf(itemSubid));
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*  80 */     return canRandonPreciousSubIds;
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
/*     */   static void addRoleDropCount(long roleId, List<Integer> dropedPreciousItemSubId, ItemSubid2Count xItemSubid2Count)
/*     */   {
/*  93 */     for (Iterator i$ = dropedPreciousItemSubId.iterator(); i$.hasNext();) { int itemsubid = ((Integer)i$.next()).intValue();
/*     */       
/*     */ 
/*  96 */       IdCounter xIdCounter = (IdCounter)xItemSubid2Count.getItemsubid2count().get(Integer.valueOf(itemsubid));
/*  97 */       if (xIdCounter != null)
/*     */       {
/*     */ 
/*     */ 
/* 101 */         xIdCounter.setUnhitcount(0);
/* 102 */         xIdCounter.setDropcount(xIdCounter.getDropcount() + 1);
/* 103 */         xIdCounter.setHistorydropcount(xIdCounter.getHistorydropcount() + 1);
/* 104 */         xIdCounter.setModifytime(DateTimeUtils.getCurrTimeInMillis());
/*     */         
/* 106 */         AwardPoolManager.tlogRoleDrop(roleId, itemsubid, xIdCounter.getDropcount(), xIdCounter.getHistorydropcount(), xIdCounter.getUnhitcount(), true);
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
/*     */ 
/*     */ 
/*     */   static void addRoleUnHitCount(long roleId, Map<Integer, Integer> unHitItemSubId2PreciousId, ItemSubid2Count xItemSubid2Count)
/*     */   {
/* 121 */     if ((unHitItemSubId2PreciousId == null) || (unHitItemSubId2PreciousId.isEmpty()))
/*     */     {
/* 123 */       return;
/*     */     }
/* 125 */     for (Iterator i$ = unHitItemSubId2PreciousId.keySet().iterator(); i$.hasNext();) { int itemsubid = ((Integer)i$.next()).intValue();
/*     */       
/*     */ 
/* 128 */       IdCounter xIdCounter = (IdCounter)xItemSubid2Count.getItemsubid2count().get(Integer.valueOf(itemsubid));
/* 129 */       if (xIdCounter != null)
/*     */       {
/*     */ 
/*     */ 
/* 133 */         xIdCounter.setUnhitcount(xIdCounter.getUnhitcount() + 1);
/*     */         
/* 135 */         xIdCounter.setModifytime(DateTimeUtils.getCurrTimeInMillis());
/*     */         
/* 137 */         AwardPoolManager.tlogRoleDrop(roleId, itemsubid, xIdCounter.getDropcount(), xIdCounter.getHistorydropcount(), xIdCounter.getUnhitcount(), false);
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
/*     */ 
/*     */ 
/*     */   static void resetRoleDropCount(List<Integer> dropedPreciousItemSubId, ItemSubid2Count xItemSubid2Count)
/*     */   {
/* 152 */     for (Iterator i$ = dropedPreciousItemSubId.iterator(); i$.hasNext();) { int itemsubid = ((Integer)i$.next()).intValue();
/*     */       
/*     */ 
/* 155 */       IdCounter xIdCounter = (IdCounter)xItemSubid2Count.getItemsubid2count().get(Integer.valueOf(itemsubid));
/* 156 */       if (xIdCounter != null)
/*     */       {
/*     */ 
/*     */ 
/* 160 */         xIdCounter.setUnhitcount(0);
/* 161 */         xIdCounter.setDropcount(0);
/* 162 */         xIdCounter.setModifytime(DateTimeUtils.getCurrTimeInMillis());
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
/*     */ 
/*     */   static void setUnHitCount(List<Integer> dropedPreciousItemSubId, ItemSubid2Count xItemSubid2Count, int unHitCount)
/*     */   {
/* 176 */     for (Iterator i$ = dropedPreciousItemSubId.iterator(); i$.hasNext();) { int itemsubid = ((Integer)i$.next()).intValue();
/*     */       
/*     */ 
/* 179 */       IdCounter xIdCounter = (IdCounter)xItemSubid2Count.getItemsubid2count().get(Integer.valueOf(itemsubid));
/* 180 */       if (xIdCounter != null)
/*     */       {
/*     */ 
/*     */ 
/* 184 */         xIdCounter.setUnhitcount(unHitCount);
/* 185 */         xIdCounter.setModifytime(DateTimeUtils.getCurrTimeInMillis());
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\awardpool\main\RolePreciousDropManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
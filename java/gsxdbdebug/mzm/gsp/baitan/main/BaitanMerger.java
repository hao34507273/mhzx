/*     */ package mzm.gsp.baitan.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.MergeMain;
/*     */ import xbean.Channels;
/*     */ import xbean.Prices;
/*     */ import xtable.Item2prices;
/*     */ import xtable.Item2sales;
/*     */ 
/*     */ public class BaitanMerger implements mzm.gsp.MergeModule
/*     */ {
/*     */   public List<xdb.Table> getHandleTables()
/*     */   {
/*  19 */     List<xdb.Table> tables = new ArrayList();
/*  20 */     tables.add(xtable.Role2grid.getTable());
/*     */     
/*  22 */     tables.add(xtable.Roleshoppinginfo.getTable());
/*  23 */     tables.add(xtable.Channel2shoppingid.getTable());
/*     */     
/*  25 */     tables.add(Item2sales.getTable());
/*     */     
/*  27 */     tables.add(Item2prices.getTable());
/*  28 */     return tables;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean handleMerge()
/*     */   {
/*  35 */     boolean ret = new Merge_Item2sales_Pro(null).call();
/*  36 */     if (!ret)
/*     */     {
/*  38 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  42 */     ret = new Merge_Item2prices_Pro(null).call();
/*     */     
/*  44 */     return ret;
/*     */   }
/*     */   
/*     */ 
/*     */   private static class Merge_Item2sales_Pro
/*     */     extends mzm.gsp.util.LogicProcedure
/*     */   {
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  54 */       long viceZoneId = MergeMain.getViceZoneid();
/*     */       
/*  56 */       List<Long> viceKeys = new ArrayList();
/*     */       
/*  58 */       for (Iterator i$ = mzm.gsp.baitan.confbean.SItemId2BaitanItemCfgid.getAll().keySet().iterator(); i$.hasNext();) { int itemid = ((Integer)i$.next()).intValue();
/*     */         
/*     */ 
/*  61 */         long viceKey = GameServerInfoManager.toGlobalId(itemid, viceZoneId);
/*  62 */         viceKeys.add(Long.valueOf(viceKey));
/*     */       }
/*     */       
/*     */ 
/*  66 */       lock(Item2sales.getTable(), viceKeys);
/*     */       
/*  68 */       for (Iterator i$ = viceKeys.iterator(); i$.hasNext();) { long viceKey = ((Long)i$.next()).longValue();
/*     */         
/*  70 */         Item2sales.remove(Long.valueOf(viceKey));
/*     */       }
/*  72 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private static class Merge_Item2prices_Pro
/*     */     extends mzm.gsp.util.LogicProcedure
/*     */   {
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  84 */       long viceZoneId = MergeMain.getViceZoneid();
/*  85 */       long mainZoneId = MergeMain.getMainZoneid();
/*     */       
/*  87 */       List<Long> mainKeys = new ArrayList();
/*  88 */       List<Long> viceKeys = new ArrayList();
/*     */       
/*  90 */       for (Iterator i$ = mzm.gsp.baitan.confbean.SItemId2BaitanItemCfgid.getAll().keySet().iterator(); i$.hasNext();) { int itemid = ((Integer)i$.next()).intValue();
/*     */         
/*     */ 
/*  93 */         long viceKey = GameServerInfoManager.toGlobalId(itemid, viceZoneId);
/*  94 */         viceKeys.add(Long.valueOf(viceKey));
/*  95 */         long mainKey = GameServerInfoManager.toGlobalId(itemid, mainZoneId);
/*  96 */         mainKeys.add(Long.valueOf(mainKey));
/*     */       }
/*     */       
/*  99 */       List<Long> totalKeys = new ArrayList(mainKeys.size() + viceKeys.size());
/* 100 */       totalKeys.addAll(mainKeys);
/* 101 */       totalKeys.addAll(viceKeys);
/* 102 */       lock(Item2prices.getTable(), totalKeys);
/*     */       
/* 104 */       for (Iterator i$ = mzm.gsp.baitan.confbean.SItemId2BaitanItemCfgid.getAll().keySet().iterator(); i$.hasNext();) { int itemid = ((Integer)i$.next()).intValue();
/*     */         
/*     */ 
/* 107 */         long viceKey = GameServerInfoManager.toGlobalId(itemid, viceZoneId);
/*     */         
/* 109 */         xVicePrices = Item2prices.get(Long.valueOf(viceKey));
/* 110 */         if ((xVicePrices != null) && (!xVicePrices.getPrice2channels().isEmpty()))
/*     */         {
/*     */ 
/*     */ 
/* 114 */           long mainKey = GameServerInfoManager.toGlobalId(itemid, mainZoneId);
/*     */           
/* 116 */           xMainPrices = Item2prices.get(Long.valueOf(mainKey));
/* 117 */           if (xMainPrices == null)
/*     */           {
/* 119 */             xMainPrices = xbean.Pod.newPrices();
/* 120 */             Item2prices.insert(Long.valueOf(mainKey), xMainPrices);
/*     */           }
/* 122 */           for (i$ = xVicePrices.getPrice2channels().keySet().iterator(); i$.hasNext();) { int vicePrice = ((Integer)i$.next()).intValue();
/*     */             
/* 124 */             Channels xMainChannels = (Channels)xMainPrices.getPrice2channels().get(Integer.valueOf(vicePrice));
/* 125 */             if (xMainChannels == null)
/*     */             {
/* 127 */               xMainChannels = xbean.Pod.newChannels();
/* 128 */               xMainPrices.getPrice2channels().put(Integer.valueOf(vicePrice), xMainChannels);
/*     */             }
/* 130 */             Channels xViceChannels = (Channels)xVicePrices.getPrice2channels().get(Integer.valueOf(vicePrice));
/* 131 */             xMainChannels.getChannels().addAll(xViceChannels.getChannels());
/*     */           } } }
/*     */       Prices xVicePrices;
/*     */       Prices xMainPrices;
/*     */       Iterator i$;
/* 136 */       for (Iterator i$ = viceKeys.iterator(); i$.hasNext();) { long viceKey = ((Long)i$.next()).longValue();
/*     */         
/* 138 */         Item2prices.remove(Long.valueOf(viceKey));
/*     */       }
/* 140 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\baitan\main\BaitanMerger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
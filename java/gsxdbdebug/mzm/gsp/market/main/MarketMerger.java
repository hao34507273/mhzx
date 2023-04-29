/*     */ package mzm.gsp.market.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.MergeMain;
/*     */ import mzm.gsp.market.confbean.SMarketItemCfg;
/*     */ import mzm.gsp.market.confbean.SMarketPetCfg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.MarketChannelIds;
/*     */ import xtable.Item2marketchannelids;
/*     */ import xtable.Pet2marketchannelids;
/*     */ 
/*     */ public class MarketMerger implements mzm.gsp.MergeModule
/*     */ {
/*     */   public List<xdb.Table> getHandleTables()
/*     */   {
/*  21 */     List<xdb.Table> tables = new ArrayList();
/*     */     
/*  23 */     tables.add(xtable.Role2marketinfo.getTable());
/*  24 */     tables.add(xtable.Role2auctioninfo.getTable());
/*     */     
/*  26 */     tables.add(xtable.Role2marketlog.getTable());
/*  27 */     tables.add(xtable.Role2customized.getTable());
/*     */     
/*  29 */     tables.add(Item2marketchannelids.getTable());
/*  30 */     tables.add(xtable.Marketitem.getTable());
/*  31 */     tables.add(xtable.Marketitemid2auction.getTable());
/*  32 */     tables.add(xtable.Marketitemid2concernrole.getTable());
/*     */     
/*  34 */     tables.add(Pet2marketchannelids.getTable());
/*  35 */     tables.add(xtable.Marketpet.getTable());
/*  36 */     tables.add(xtable.Marketpetid2auction.getTable());
/*  37 */     tables.add(xtable.Marketpetid2concernrole.getTable());
/*     */     
/*  39 */     tables.add(xtable.Channel2marketids.getTable());
/*  40 */     return tables;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean handleMerge()
/*     */   {
/*  47 */     boolean ret = new Merge_Item2marketchannelids_Pro(null).call();
/*  48 */     if (!ret)
/*     */     {
/*  50 */       return false;
/*     */     }
/*  52 */     ret = new Merge_Pet2marketchannelids_Pro(null).call();
/*  53 */     return ret;
/*     */   }
/*     */   
/*     */ 
/*     */   private static class Merge_Item2marketchannelids_Pro
/*     */     extends LogicProcedure
/*     */   {
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  63 */       long viceZoneId = MergeMain.getViceZoneid();
/*  64 */       long mainZoneId = MergeMain.getMainZoneid();
/*     */       
/*  66 */       List<Long> mainKeys = new ArrayList();
/*  67 */       List<Long> viceKeys = new ArrayList();
/*     */       
/*  69 */       for (SMarketItemCfg marketItemCfg : SMarketItemCfg.getAll().values())
/*     */       {
/*     */ 
/*  72 */         long viceKey = GameServerInfoManager.toGlobalId(marketItemCfg.itemid, viceZoneId);
/*  73 */         viceKeys.add(Long.valueOf(viceKey));
/*  74 */         long mainKey = GameServerInfoManager.toGlobalId(marketItemCfg.itemid, mainZoneId);
/*  75 */         mainKeys.add(Long.valueOf(mainKey));
/*     */       }
/*     */       
/*  78 */       List<Long> totalKeys = new ArrayList(mainKeys.size() + viceKeys.size());
/*  79 */       totalKeys.addAll(mainKeys);
/*  80 */       totalKeys.addAll(viceKeys);
/*  81 */       lock(Item2marketchannelids.getTable(), totalKeys);
/*     */       
/*  83 */       for (SMarketItemCfg marketItemCfg : SMarketItemCfg.getAll().values())
/*     */       {
/*     */ 
/*  86 */         long viceKey = GameServerInfoManager.toGlobalId(marketItemCfg.itemid, viceZoneId);
/*     */         
/*  88 */         MarketChannelIds xViceChannels = Item2marketchannelids.get(Long.valueOf(viceKey));
/*  89 */         if (xViceChannels != null)
/*     */         {
/*     */ 
/*     */ 
/*  93 */           long mainKey = GameServerInfoManager.toGlobalId(marketItemCfg.itemid, mainZoneId);
/*     */           
/*  95 */           MarketChannelIds xMainChannels = Item2marketchannelids.get(Long.valueOf(mainKey));
/*  96 */           if (xMainChannels == null)
/*     */           {
/*  98 */             xMainChannels = xbean.Pod.newMarketChannelIds();
/*  99 */             Item2marketchannelids.insert(Long.valueOf(mainKey), xMainChannels);
/*     */           }
/*     */           
/* 102 */           xMainChannels.getChannel_ids().addAll(xViceChannels.getChannel_ids());
/* 103 */           if (DateTimeUtils.isInSameDay(xMainChannels.getSupply_time(), xViceChannels.getSupply_time()))
/*     */           {
/* 105 */             xMainChannels.setSupply_num(xMainChannels.getSupply_num() + xViceChannels.getSupply_num());
/* 106 */             xMainChannels.setSupply_skill_equip_num(xMainChannels.getSupply_skill_equip_num() + xViceChannels.getSupply_skill_equip_num());
/*     */           }
/*     */         }
/*     */       }
/*     */       
/* 111 */       for (Iterator i$ = viceKeys.iterator(); i$.hasNext();) { long viceKey = ((Long)i$.next()).longValue();
/*     */         
/* 113 */         Item2marketchannelids.remove(Long.valueOf(viceKey));
/*     */       }
/* 115 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private static class Merge_Pet2marketchannelids_Pro
/*     */     extends LogicProcedure
/*     */   {
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 127 */       long viceZoneId = MergeMain.getViceZoneid();
/* 128 */       long mainZoneId = MergeMain.getMainZoneid();
/*     */       
/* 130 */       List<Long> mainKeys = new ArrayList();
/* 131 */       List<Long> viceKeys = new ArrayList();
/*     */       
/* 133 */       for (SMarketPetCfg marketPetCfg : SMarketPetCfg.getAll().values())
/*     */       {
/*     */ 
/* 136 */         long viceKey = GameServerInfoManager.toGlobalId(marketPetCfg.petid, viceZoneId);
/* 137 */         viceKeys.add(Long.valueOf(viceKey));
/* 138 */         long mainKey = GameServerInfoManager.toGlobalId(marketPetCfg.petid, mainZoneId);
/* 139 */         mainKeys.add(Long.valueOf(mainKey));
/*     */       }
/*     */       
/* 142 */       List<Long> totalKeys = new ArrayList(mainKeys.size() + viceKeys.size());
/* 143 */       totalKeys.addAll(mainKeys);
/* 144 */       totalKeys.addAll(viceKeys);
/* 145 */       lock(Pet2marketchannelids.getTable(), totalKeys);
/*     */       
/* 147 */       for (SMarketPetCfg marketPetCfg : SMarketPetCfg.getAll().values())
/*     */       {
/*     */ 
/* 150 */         long viceKey = GameServerInfoManager.toGlobalId(marketPetCfg.petid, viceZoneId);
/*     */         
/* 152 */         MarketChannelIds xViceChannels = Pet2marketchannelids.get(Long.valueOf(viceKey));
/* 153 */         if (xViceChannels != null)
/*     */         {
/*     */ 
/*     */ 
/* 157 */           long mainKey = GameServerInfoManager.toGlobalId(marketPetCfg.petid, mainZoneId);
/*     */           
/* 159 */           MarketChannelIds xMainChannels = Pet2marketchannelids.get(Long.valueOf(mainKey));
/* 160 */           if (xMainChannels == null)
/*     */           {
/* 162 */             xMainChannels = xbean.Pod.newMarketChannelIds();
/* 163 */             Pet2marketchannelids.insert(Long.valueOf(mainKey), xMainChannels);
/*     */           }
/*     */           
/* 166 */           xMainChannels.getChannel_ids().addAll(xViceChannels.getChannel_ids());
/* 167 */           if (DateTimeUtils.isInSameDay(xMainChannels.getSupply_time(), xViceChannels.getSupply_time()))
/*     */           {
/* 169 */             xMainChannels.setSupply_num(xMainChannels.getSupply_num() + xViceChannels.getSupply_num());
/* 170 */             xMainChannels.setSupply_skill_equip_num(xMainChannels.getSupply_skill_equip_num() + xViceChannels.getSupply_skill_equip_num());
/*     */           }
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 176 */       for (Iterator i$ = viceKeys.iterator(); i$.hasNext();) { long viceKey = ((Long)i$.next()).longValue();
/*     */         
/* 178 */         Pet2marketchannelids.remove(Long.valueOf(viceKey));
/*     */       }
/* 180 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\main\MarketMerger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
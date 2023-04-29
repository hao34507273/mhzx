/*     */ package mzm.gsp.huanhun.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.confbean.SHuanHunMiShuItemCfg;
/*     */ import mzm.gsp.activity.confbean.STHunLevelData;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Xdb;
/*     */ 
/*     */ public class HuanhunInitManager
/*     */ {
/*  20 */   static int RATE_SUM_WAN = 10000;
/*     */   
/*  22 */   static int BOX_NUM = 8;
/*     */   
/*     */   static void init()
/*     */   {
/*     */     try
/*     */     {
/*  28 */       initCfg();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  32 */       throw new RuntimeException(e);
/*     */     }
/*     */   }
/*     */   
/*     */   static boolean initCfg() throws Exception
/*     */   {
/*  38 */     ActivityInterface.registerActivityByLogicType(23, new HunTaskActivityInit());
/*  39 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static SHuanHunMiShuItemCfg ranOneItemCfg(int level)
/*     */   {
/*  50 */     return ranOneItemCfg(getSTHunLevelData(level));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static SHuanHunMiShuItemCfg ranOneItemCfg(STHunLevelData cfg)
/*     */   {
/*  61 */     if (cfg == null)
/*     */     {
/*  63 */       return null;
/*     */     }
/*  65 */     int ran = Xdb.random().nextInt(cfg.weightSum);
/*  66 */     int value = 0;
/*  67 */     for (Iterator i$ = cfg.sHunCfgId.iterator(); i$.hasNext();) { int itemCfgId = ((Integer)i$.next()).intValue();
/*     */       
/*  69 */       SHuanHunMiShuItemCfg sg = SHuanHunMiShuItemCfg.get(itemCfgId);
/*  70 */       value += sg.itemRate;
/*  71 */       if (value > ran)
/*     */       {
/*  73 */         return sg;
/*     */       }
/*     */     }
/*  76 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean containsLevel(int levelKey, int level)
/*     */   {
/*  88 */     int levelLow = levelKey / RATE_SUM_WAN;
/*  89 */     int levelHigh = levelKey % RATE_SUM_WAN;
/*  90 */     if ((level >= levelLow) && (level <= levelHigh))
/*     */     {
/*  92 */       return true;
/*     */     }
/*  94 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static STHunLevelData getSTHunLevelData(int level)
/*     */   {
/* 105 */     for (Iterator i$ = STHunLevelData.getAll().keySet().iterator(); i$.hasNext();) { int levelKey = ((Integer)i$.next()).intValue();
/*     */       
/* 107 */       if (containsLevel(levelKey, level))
/*     */       {
/*     */ 
/*     */ 
/* 111 */         return STHunLevelData.get(levelKey); }
/*     */     }
/* 113 */     GameServer.logger().error(String.format("[hun]HuanhunInitManager.getSTHunLevelData@ no STHunLevelData 2 level!|level=%d", new Object[] { Integer.valueOf(level) }));
/*     */     
/* 115 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int ranItemIdInCfg(int itemSelectId)
/*     */   {
/* 126 */     List<Integer> itemList = ItemInterface.getSamePriceItems(itemSelectId);
/* 127 */     int seed = itemList.size();
/* 128 */     Random random = Xdb.random();
/* 129 */     int ran = random.nextInt(seed);
/*     */     
/* 131 */     return ((Integer)itemList.get(ran)).intValue();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isWantItem(List<Integer> itemIds, int itemSelectId)
/*     */   {
/* 143 */     return ItemInterface.getSamePriceItems(itemSelectId).containsAll(itemIds);
/*     */   }
/*     */   
/*     */   static boolean isWantItem(Integer itemId, int itemSelectId)
/*     */   {
/* 148 */     List<Integer> sameList = ItemInterface.getSamePriceItems(itemSelectId);
/* 149 */     return sameList.contains(itemId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static Map<Integer, SingleItemInfo> getNeedItemMap(long roleId)
/*     */   {
/* 160 */     Map<Integer, SingleItemInfo> needItemMap = new HashMap();
/*     */     
/* 162 */     int level = RoleInterface.getLevel(roleId);
/* 163 */     STHunLevelData hunLevelData = getSTHunLevelData(level);
/* 164 */     if (hunLevelData == null)
/*     */     {
/* 166 */       GameServer.logger().error(String.format("[hun]HuanhunInitManager.getNeedItemMap@ get STHunLevelData error!|roleId=%d|level=%d ", new Object[] { Long.valueOf(roleId), Integer.valueOf(level) }));
/*     */       
/*     */ 
/* 169 */       return needItemMap;
/*     */     }
/*     */     
/* 172 */     for (int i = 1; i <= BOX_NUM; i++)
/*     */     {
/* 174 */       SHuanHunMiShuItemCfg itemCfg = ranOneItemCfg(hunLevelData);
/* 175 */       if (itemCfg == null)
/*     */       {
/* 177 */         GameServer.logger().error(String.format("[hun]HuanhunInitManager.getNeedItemMap@ get itemCfg error!|roleId=%d|level=%d ", new Object[] { Long.valueOf(roleId), Integer.valueOf(level) }));
/*     */         
/*     */ 
/* 180 */         return new HashMap();
/*     */       }
/* 182 */       SingleItemInfo sItemInfo = new SingleItemInfo();
/* 183 */       sItemInfo.setItemIdType(itemCfg.selectType);
/* 184 */       sItemInfo.setItemNum(itemCfg.itemNum);
/* 185 */       if (itemCfg.selectType != 1)
/*     */       {
/* 187 */         sItemInfo.setItemId(ranItemIdInCfg(itemCfg.selectCfgId));
/*     */       }
/*     */       else
/*     */       {
/* 191 */         sItemInfo.setItemId(itemCfg.selectCfgId);
/*     */       }
/* 193 */       needItemMap.put(Integer.valueOf(i), sItemInfo);
/*     */     }
/*     */     
/* 196 */     if (needItemMap.size() != BOX_NUM)
/*     */     {
/* 198 */       GameServer.logger().error(String.format("[hun]HuanhunInitManager.getNeedItemMap@ get need items num not enough!|roleId=%d|level=%d|itemNum=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(level), Integer.valueOf(needItemMap.size()) }));
/*     */       
/*     */ 
/*     */ 
/* 202 */       return new HashMap();
/*     */     }
/*     */     
/* 205 */     return needItemMap;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\huanhun\main\HuanhunInitManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
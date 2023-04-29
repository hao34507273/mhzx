/*     */ package mzm.gsp.fabao.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.fabao.confbean.SFabaoConstants;
/*     */ import mzm.gsp.item.ItemInfo;
/*     */ import mzm.gsp.item.confbean.SFabaoItem;
/*     */ import mzm.gsp.item.confbean.SLongJingItem;
/*     */ import mzm.gsp.item.main.FabaoItem;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.ItemStoreEnum;
/*     */ import mzm.gsp.skill.main.Skill;
/*     */ import mzm.gsp.skill.main.SkillInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Item;
/*     */ import xbean.LongJing;
/*     */ import xbean.RoleFabaoSysInfo;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FabaoInterface
/*     */ {
/*     */   public static int getRandomRankSkillid(SFabaoItem sFabaoItem)
/*     */   {
/*  35 */     return FabaoManager.getRandomRankSkillid(sFabaoItem);
/*     */   }
/*     */   
/*     */   public static int getRandomWashSkillid(SFabaoItem sFabaoItem) {
/*  39 */     return FabaoManager.getRandomWashSkillid(sFabaoItem);
/*     */   }
/*     */   
/*     */   public static boolean isFabaoItem(int fabaoItemid) {
/*  43 */     return SFabaoItem.get(fabaoItemid) != null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getRoleDisplayFabaoid(long roleId, boolean retainLock)
/*     */   {
/*  54 */     RoleFabaoSysInfo xRoleFabaoSysInfo = FabaoManager.getRoleFabaoSysInfo(roleId, retainLock);
/*  55 */     if (xRoleFabaoSysInfo == null) {
/*  56 */       return 0;
/*     */     }
/*  58 */     int fabaoType = xRoleFabaoSysInfo.getDisfabaotype();
/*  59 */     Item xItem = (Item)xRoleFabaoSysInfo.getFabaomap().get(Integer.valueOf(fabaoType));
/*  60 */     if (xItem == null) {
/*  61 */       return 0;
/*     */     }
/*  63 */     return xItem.getCfgid();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Map<Integer, Integer> getFabaoSysPro(long roleid, boolean retainLock)
/*     */   {
/*  75 */     RoleFabaoSysInfo xRoleFabaoSysInfo = FabaoManager.getRoleFabaoSysInfo(roleid, retainLock);
/*  76 */     if (xRoleFabaoSysInfo == null) {
/*  77 */       return Collections.EMPTY_MAP;
/*     */     }
/*  79 */     Map<Integer, Integer> proMap = new HashMap();
/*  80 */     for (Item xItem : xRoleFabaoSysInfo.getFabaomap().values()) {
/*  81 */       FabaoItem fabaoItem = new FabaoItem(xItem);
/*  82 */       FabaoManager.addAllMap(proMap, fabaoItem.getProMap());
/*     */     }
/*  84 */     FabaoManager.addAllMap(proMap, FabaoManager.getExtraProMap(roleid, xRoleFabaoSysInfo));
/*  85 */     for (LongJing xlongJing : xRoleFabaoSysInfo.getLongjingmap().values()) {
/*  86 */       for (Item xItem : xlongJing.getLongjingitems().values()) {
/*  87 */         SLongJingItem sLongJingItem = SLongJingItem.get(xItem.getCfgid());
/*  88 */         if (sLongJingItem != null) {
/*  89 */           FabaoManager.addAllMap(proMap, sLongJingItem.attrMap);
/*     */         }
/*     */       }
/*     */     }
/*  93 */     return proMap;
/*     */   }
/*     */   
/*     */   public static List<Skill> getFaBaoSysSkills(long roleid, boolean retainLock)
/*     */   {
/*  98 */     RoleFabaoSysInfo xRoleFabaoSysInfo = FabaoManager.getRoleFabaoSysInfo(roleid, retainLock);
/*  99 */     if (xRoleFabaoSysInfo == null) {
/* 100 */       return Collections.EMPTY_LIST;
/*     */     }
/* 102 */     List<Skill> skills = new ArrayList();
/* 103 */     for (Item xItem : xRoleFabaoSysInfo.getFabaomap().values()) {
/* 104 */       FabaoItem fabaoItem = new FabaoItem(xItem);
/* 105 */       int skillid = fabaoItem.getOwnSkillId();
/* 106 */       int skillLv = SFabaoItem.get(fabaoItem.getCfgId()).rank;
/* 107 */       Skill skill = SkillInterface.getSkill(skillid, skillLv);
/* 108 */       if (skill != null) {
/* 109 */         skills.add(skill);
/*     */       }
/*     */     }
/* 112 */     return skills;
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
/*     */   public static ItemInfo getFabaoItemInfo(long roleid, long fabaoUuid, boolean retainLock)
/*     */   {
/* 125 */     ItemInfo itemInfo = null;
/* 126 */     RoleFabaoSysInfo xRoleFabaoSysInfo = FabaoManager.getRoleFabaoSysInfo(roleid, retainLock);
/* 127 */     if (xRoleFabaoSysInfo != null) {
/* 128 */       for (Map.Entry<Integer, Item> entry : xRoleFabaoSysInfo.getFabaomap().entrySet()) {
/* 129 */         Item xItem = (Item)entry.getValue();
/* 130 */         if (xItem.getUuid().contains(Long.valueOf(fabaoUuid))) {
/* 131 */           itemInfo = new ItemInfo();
/* 132 */           ItemInterface.fillInItemInfoBean(itemInfo, xItem);
/* 133 */           return itemInfo;
/*     */         }
/*     */       }
/*     */     }
/* 137 */     itemInfo = ItemInterface.getItemInfo(roleid, fabaoUuid, retainLock);
/* 138 */     return itemInfo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static ItemInfo getDisPlayFabaoItemInfo(long roleid, boolean retainLock)
/*     */   {
/* 149 */     RoleFabaoSysInfo xRoleFabaoSysInfo = FabaoManager.getRoleFabaoSysInfo(roleid, retainLock);
/* 150 */     if (xRoleFabaoSysInfo != null) {
/* 151 */       int disPlayType = xRoleFabaoSysInfo.getDisfabaotype();
/* 152 */       Item xItem = (Item)xRoleFabaoSysInfo.getFabaomap().get(Integer.valueOf(disPlayType));
/* 153 */       if (xItem == null) {
/* 154 */         return null;
/*     */       }
/* 156 */       ItemInfo itemInfo = new ItemInfo();
/* 157 */       ItemInterface.fillInItemInfoBean(itemInfo, xItem);
/* 158 */       return itemInfo;
/*     */     }
/*     */     
/* 161 */     return null;
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
/*     */   public static int getEquipFaBaoRankLv(long roleid, int fabaoType, boolean retainLock)
/*     */   {
/* 174 */     RoleFabaoSysInfo xRoleFabaoSysInfo = FabaoManager.getRoleFabaoSysInfo(roleid, retainLock);
/* 175 */     if (xRoleFabaoSysInfo != null) {
/* 176 */       Item xItem = (Item)xRoleFabaoSysInfo.getFabaomap().get(Integer.valueOf(fabaoType));
/* 177 */       if (xItem == null) {
/* 178 */         return -1;
/*     */       }
/* 180 */       SFabaoItem sFabaoItem = SFabaoItem.get(xItem.getCfgid());
/* 181 */       if (sFabaoItem == null) {
/* 182 */         GameServer.logger().error("[FaBao]FabaoInterface.getEquipFaBaoRankLv@fabao item is null!!");
/* 183 */         return -1;
/*     */       }
/* 185 */       return sFabaoItem.rank;
/*     */     }
/*     */     
/*     */ 
/* 189 */     return -1;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getNormalAverageRankLv(long roleid, boolean retainLock)
/*     */   {
/* 201 */     RoleFabaoSysInfo xRoleFabaoSysInfo = FabaoManager.getRoleFabaoSysInfo(roleid, retainLock);
/* 202 */     if (xRoleFabaoSysInfo != null) {
/* 203 */       int totalRank = 0;
/* 204 */       int trulySize = 0;
/* 205 */       for (Map.Entry<Integer, Item> fabaoEntry : xRoleFabaoSysInfo.getFabaomap().entrySet()) {
/* 206 */         int fabaoType = ((Integer)fabaoEntry.getKey()).intValue();
/* 207 */         if (!SFabaoConstants.getInstance().specialTypes.contains(Integer.valueOf(fabaoType)))
/*     */         {
/*     */ 
/* 210 */           Item xItem = (Item)fabaoEntry.getValue();
/* 211 */           SFabaoItem sFabaoItem = SFabaoItem.get(xItem.getCfgid());
/* 212 */           if (sFabaoItem == null) {
/* 213 */             GameServer.logger().error("[FaBao]FabaoInterface.getEquipFaBaoRankLv@fabao item is null!!");
/*     */           }
/*     */           else {
/* 216 */             totalRank += sFabaoItem.rank;
/* 217 */             trulySize++;
/*     */           }
/*     */         } }
/* 220 */       if (trulySize <= 0) {
/* 221 */         return 0;
/*     */       }
/* 223 */       return totalRank / trulySize;
/*     */     }
/* 225 */     return 0;
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
/*     */   public static Map<Integer, Integer> getEquipFabaoCfgIds(long roleid, boolean retainLock)
/*     */   {
/* 238 */     RoleFabaoSysInfo xRoleFabaoSysInfo = FabaoManager.getRoleFabaoSysInfo(roleid, retainLock);
/* 239 */     if ((xRoleFabaoSysInfo == null) || (xRoleFabaoSysInfo.getFabaomap().size() <= 0))
/*     */     {
/* 241 */       return Collections.EMPTY_MAP;
/*     */     }
/* 243 */     Map<Integer, Integer> equipFabaoCfgIds = new HashMap(xRoleFabaoSysInfo.getFabaomap().size());
/*     */     
/* 245 */     for (Map.Entry<Integer, Item> fabaoEntry : xRoleFabaoSysInfo.getFabaomap().entrySet())
/*     */     {
/* 247 */       Item item = (Item)fabaoEntry.getValue();
/* 248 */       if (item != null)
/*     */       {
/* 250 */         equipFabaoCfgIds.put(fabaoEntry.getKey(), Integer.valueOf(item.getCfgid()));
/*     */       }
/*     */     }
/* 253 */     return equipFabaoCfgIds;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static RoleFabaoSysInfo getEquipFaBaoSysInfo(long roleId, boolean isHoldRoleLock)
/*     */   {
/* 265 */     return FabaoManager.getRoleFabaoSysInfo(roleId, isHoldRoleLock);
/*     */   }
/*     */   
/*     */   public static Map<Integer, Map<Integer, Integer>> getFaBaoLevelInfo(RoleFabaoSysInfo xRoleFabaoSysInfo)
/*     */   {
/* 270 */     Map<Integer, Map<Integer, Integer>> result = new HashMap();
/* 271 */     if (xRoleFabaoSysInfo == null)
/*     */     {
/* 273 */       return result;
/*     */     }
/*     */     
/* 276 */     for (Map.Entry<Integer, Item> entry : xRoleFabaoSysInfo.getFabaomap().entrySet())
/*     */     {
/* 278 */       Item xItem = (Item)entry.getValue();
/* 279 */       result.put(entry.getKey(), Collections.singletonMap(Integer.valueOf(xItem.getCfgid()), xItem.getExtra().get(Integer.valueOf(ItemStoreEnum.FABAO_CUR_LV.getStoreType()))));
/*     */     }
/* 281 */     return result;
/*     */   }
/*     */   
/*     */   public static Map<Integer, List<Integer>> getEquipLongJingInfo(RoleFabaoSysInfo xRoleFabaoSysInfo)
/*     */   {
/* 286 */     Map<Integer, List<Integer>> result = new HashMap();
/* 287 */     if (xRoleFabaoSysInfo == null)
/*     */     {
/* 289 */       return result;
/*     */     }
/* 291 */     for (Map.Entry<Integer, LongJing> entry : xRoleFabaoSysInfo.getLongjingmap().entrySet())
/*     */     {
/* 293 */       result.put(entry.getKey(), FabaoManager.getLongJingCfgIdList(((LongJing)entry.getValue()).getLongjingitems()));
/*     */     }
/* 295 */     return result;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabao\main\FabaoInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
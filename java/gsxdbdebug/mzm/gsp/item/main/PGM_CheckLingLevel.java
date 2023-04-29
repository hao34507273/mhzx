/*     */ package mzm.gsp.item.main;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.gm.main.GmManager;
/*     */ import mzm.gsp.item.confbean.SItemEquipCfg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Bag;
/*     */ import xbean.OcpEquipBag;
/*     */ import xtable.Role2ocpequipbag;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PGM_CheckLingLevel
/*     */ {
/*     */   public static int checkLingLevel(long roleid, long uuid, int currentLevel)
/*     */   {
/*  21 */     return checkLingLevel(0L, roleid, uuid, currentLevel);
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
/*     */   public static int checkLingLevel(long gmRoleid, long roleid, long uuid, int currentLevel)
/*     */   {
/*  35 */     RoleEquipBag equipBag = ItemManager.getRoleEquipBag(roleid);
/*  36 */     int r = checkLevel(equipBag, gmRoleid, roleid, uuid, currentLevel);
/*  37 */     if (r != -1)
/*     */     {
/*  39 */       return r;
/*     */     }
/*     */     
/*  42 */     RoleItemBag itemBag = ItemManager.getRoleItemBag(roleid);
/*  43 */     r = checkLevel(itemBag, gmRoleid, roleid, uuid, currentLevel);
/*  44 */     if (r != -1)
/*     */     {
/*  46 */       return r;
/*     */     }
/*  48 */     List<Integer> storageids = ItemInterface.getOpenStorageids(roleid, true);
/*  49 */     for (Iterator i$ = storageids.iterator(); i$.hasNext();) { int storageid = ((Integer)i$.next()).intValue();
/*     */       
/*     */ 
/*  52 */       RoleStorageBag bag = ItemManager.getRoleStorageBag(roleid, storageid);
/*  53 */       if (bag != null)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*  58 */         r = checkLevel(bag, gmRoleid, roleid, uuid, currentLevel);
/*  59 */         if (r != -1)
/*     */         {
/*  61 */           return r;
/*     */         }
/*     */       }
/*     */     }
/*  65 */     OcpEquipBag xOcpEquipBag = Role2ocpequipbag.get(Long.valueOf(roleid));
/*  66 */     Iterator i$; if (xOcpEquipBag != null)
/*     */     {
/*  68 */       for (i$ = xOcpEquipBag.getOcp2equipbag().keySet().iterator(); i$.hasNext();) { int ocp = ((Integer)i$.next()).intValue();
/*     */         
/*  70 */         Bag xBag = (Bag)xOcpEquipBag.getOcp2equipbag().get(Integer.valueOf(ocp));
/*     */         
/*  72 */         RoleEquipBag xRoleEquipBag = new RoleEquipBag(xBag);
/*  73 */         r = checkLevel(xRoleEquipBag, gmRoleid, roleid, uuid, currentLevel);
/*  74 */         if (r != -1)
/*     */         {
/*  76 */           return r;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*  82 */     return -1;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static int checkLevel(RoleItemBag bag, long gmRoleid, long roleid, long uuid, int currentLevel)
/*     */   {
/*  93 */     BasicItem item = bag.getItemByUuid(uuid);
/*  94 */     if (item != null)
/*     */     {
/*  96 */       EquipmentItem equipmentItem = (EquipmentItem)item;
/*  97 */       int oldLevel = equipmentItem.getStrengthLevel();
/*  98 */       if (oldLevel != currentLevel)
/*     */       {
/* 100 */         if (gmRoleid != 0L)
/*     */         {
/* 102 */           GmManager.getInstance().sendResultToGM(gmRoleid, String.format("玩家 [%d] 装备uuid[%d] 的当前启灵等级 %d 不等于 目标等级%d", new Object[] { Long.valueOf(roleid), Long.valueOf(uuid), Integer.valueOf(oldLevel), Integer.valueOf(currentLevel) }));
/*     */         }
/*     */         
/*     */ 
/* 106 */         return 1;
/*     */       }
/*     */       
/*     */ 
/* 110 */       if (gmRoleid != 0L)
/*     */       {
/* 112 */         GmManager.getInstance().sendResultToGM(gmRoleid, String.format("玩家 [%d] 装备uuid[%d] 的当前启灵等级 %d 等于 目标等级%d 验证通过", new Object[] { Long.valueOf(roleid), Long.valueOf(uuid), Integer.valueOf(oldLevel), Integer.valueOf(currentLevel) }));
/*     */       }
/*     */       
/* 115 */       return 0;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 121 */     if (gmRoleid != 0L)
/*     */     {
/* 123 */       GmManager.getInstance().sendResultToGM(gmRoleid, String.format("玩家 [%d] 装备uuid[%d] 不存在", new Object[] { Long.valueOf(roleid), Long.valueOf(uuid) }));
/*     */     }
/* 125 */     return -1;
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
/*     */   public static int setLingLevel(long roleid, long uuid, int strengthLevel)
/*     */   {
/* 139 */     return setLingLevel(0L, roleid, uuid, strengthLevel);
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
/*     */   public static int setLingLevel(long gmRoleid, long roleid, long uuid, int strengthLevel)
/*     */   {
/* 153 */     if (strengthLevel < 0)
/*     */     {
/* 155 */       if (gmRoleid != 0L)
/*     */       {
/* 157 */         GmManager.getInstance().sendResultToGM(gmRoleid, String.format("灵等级参数错误 %d", new Object[] { Long.valueOf(roleid), Integer.valueOf(strengthLevel) }));
/*     */       }
/* 159 */       return 1;
/*     */     }
/* 161 */     RoleEquipBag equipBag = ItemManager.getRoleEquipBag(roleid);
/* 162 */     int r = setLevel(equipBag, gmRoleid, roleid, uuid, strengthLevel);
/* 163 */     if (r != -1)
/*     */     {
/* 165 */       return r;
/*     */     }
/*     */     
/* 168 */     RoleItemBag itemBag = ItemManager.getRoleItemBag(roleid);
/* 169 */     r = setLevel(itemBag, gmRoleid, roleid, uuid, strengthLevel);
/* 170 */     if (r != -1)
/*     */     {
/* 172 */       return r;
/*     */     }
/* 174 */     List<Integer> storageids = ItemInterface.getOpenStorageids(roleid, true);
/* 175 */     for (Iterator i$ = storageids.iterator(); i$.hasNext();) { int storageid = ((Integer)i$.next()).intValue();
/*     */       
/*     */ 
/* 178 */       RoleStorageBag bag = ItemManager.getRoleStorageBag(roleid, storageid);
/* 179 */       if (bag != null)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 184 */         r = setLevel(bag, gmRoleid, roleid, uuid, strengthLevel);
/* 185 */         if (r != -1)
/*     */         {
/* 187 */           return r;
/*     */         }
/*     */       }
/*     */     }
/* 191 */     OcpEquipBag xOcpEquipBag = Role2ocpequipbag.get(Long.valueOf(roleid));
/* 192 */     Iterator i$; if (xOcpEquipBag != null)
/*     */     {
/* 194 */       for (i$ = xOcpEquipBag.getOcp2equipbag().keySet().iterator(); i$.hasNext();) { int ocp = ((Integer)i$.next()).intValue();
/*     */         
/* 196 */         Bag xBag = (Bag)xOcpEquipBag.getOcp2equipbag().get(Integer.valueOf(ocp));
/*     */         
/* 198 */         RoleEquipBag xRoleEquipBag = new RoleEquipBag(xBag);
/* 199 */         r = setLevel(xRoleEquipBag, gmRoleid, roleid, uuid, strengthLevel);
/* 200 */         if (r != -1)
/*     */         {
/* 202 */           return r;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 208 */     return -1;
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
/*     */   private static int setLevel(RoleItemBag bag, long gmRoleid, long roleid, long uuid, int strengthLevel)
/*     */   {
/* 222 */     BasicItem item = bag.getItemByUuid(uuid);
/* 223 */     if (item != null)
/*     */     {
/* 225 */       EquipmentItem equipmentItem = (EquipmentItem)item;
/* 226 */       int oldLevel = equipmentItem.getStrengthLevel();
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
/* 237 */       equipmentItem.setStrengthLevel(strengthLevel);
/* 238 */       if (gmRoleid != 0L)
/*     */       {
/* 240 */         String logString = String.format("玩家 [%d] 装备uuid[%d]的启灵等级由[%d]级 设置为[%d]级", new Object[] { Long.valueOf(roleid), Long.valueOf(uuid), Integer.valueOf(oldLevel), Integer.valueOf(strengthLevel) });
/*     */         
/* 242 */         GmManager.getInstance().sendResultToGM(gmRoleid, logString);
/* 243 */         String logString2 = String.format("PGM_CheckLingLevel.setLevel@roleid=%d|uuid=%d|oldlevel=%d|newlevel=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(uuid), Integer.valueOf(oldLevel), Integer.valueOf(strengthLevel) });
/*     */         
/* 245 */         ItemManager.logger.info(logString2);
/*     */       }
/*     */       
/* 248 */       return 0;
/*     */     }
/*     */     
/*     */ 
/* 252 */     return -1;
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
/*     */   public static int setLingLevelByItemId(long roleid, int itemId, int strengthLevel)
/*     */   {
/* 267 */     return setLingLevelByItemId(0L, roleid, itemId, strengthLevel);
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
/*     */   public static int setLingLevelByItemId(long gmRoleid, long roleid, int itemId, int strengthLevel)
/*     */   {
/* 281 */     if (strengthLevel < 0)
/*     */     {
/* 283 */       if (gmRoleid != 0L)
/*     */       {
/* 285 */         GmManager.getInstance().sendResultToGM(gmRoleid, String.format("灵等级参数错误 %d", new Object[] { Long.valueOf(roleid), Integer.valueOf(strengthLevel) }));
/*     */       }
/* 287 */       return 1;
/*     */     }
/* 289 */     RoleEquipBag equipBag = ItemManager.getRoleEquipBag(roleid);
/* 290 */     int r = setLevelByItemId(equipBag, gmRoleid, roleid, itemId, strengthLevel);
/* 291 */     if (r != -1)
/*     */     {
/* 293 */       return r;
/*     */     }
/*     */     
/* 296 */     RoleItemBag itemBag = ItemManager.getRoleItemBag(roleid);
/* 297 */     r = setLevelByItemId(itemBag, gmRoleid, roleid, itemId, strengthLevel);
/* 298 */     if (r != -1)
/*     */     {
/* 300 */       return r;
/*     */     }
/* 302 */     List<Integer> storageids = ItemInterface.getOpenStorageids(roleid, true);
/* 303 */     for (Iterator i$ = storageids.iterator(); i$.hasNext();) { int storageid = ((Integer)i$.next()).intValue();
/*     */       
/*     */ 
/* 306 */       RoleStorageBag bag = ItemManager.getRoleStorageBag(roleid, storageid);
/* 307 */       if (bag != null)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 312 */         r = setLevelByItemId(bag, gmRoleid, roleid, itemId, strengthLevel);
/* 313 */         if (r != -1)
/*     */         {
/* 315 */           return r;
/*     */         }
/*     */       }
/*     */     }
/* 319 */     OcpEquipBag xOcpEquipBag = Role2ocpequipbag.get(Long.valueOf(roleid));
/* 320 */     Iterator i$; if (xOcpEquipBag != null)
/*     */     {
/* 322 */       for (i$ = xOcpEquipBag.getOcp2equipbag().keySet().iterator(); i$.hasNext();) { int ocp = ((Integer)i$.next()).intValue();
/*     */         
/* 324 */         Bag xBag = (Bag)xOcpEquipBag.getOcp2equipbag().get(Integer.valueOf(ocp));
/*     */         
/* 326 */         RoleEquipBag xRoleEquipBag = new RoleEquipBag(xBag);
/* 327 */         r = setLevelByItemId(xRoleEquipBag, gmRoleid, roleid, itemId, strengthLevel);
/* 328 */         if (r != -1)
/*     */         {
/* 330 */           return r;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 336 */     return -1;
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
/*     */   private static int setLevelByItemId(RoleItemBag bag, long gmRoleid, long roleid, int itemId, int strengthLevel)
/*     */   {
/* 351 */     SItemEquipCfg targetItemEquipCfg = SItemEquipCfg.get(itemId);
/* 352 */     if (targetItemEquipCfg == null)
/*     */     {
/* 354 */       if (gmRoleid != 0L)
/*     */       {
/* 356 */         GmManager.getInstance().sendResultToGM(gmRoleid, String.format("参数itemId 错误 %d", new Object[] { Integer.valueOf(itemId) }));
/*     */       }
/* 358 */       return -1;
/*     */     }
/*     */     
/* 361 */     Map<Integer, BasicItem> itemMap = bag.getAllItems(false);
/* 362 */     for (BasicItem item : itemMap.values())
/*     */     {
/* 364 */       SItemEquipCfg itemEquipCfg = SItemEquipCfg.get(item.getCfgId());
/*     */       
/* 366 */       if ((itemEquipCfg != null) && ((item instanceof EquipmentItem)) && 
/*     */       
/*     */ 
/*     */ 
/* 370 */         (targetItemEquipCfg.wearpos == itemEquipCfg.wearpos))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 375 */         EquipmentItem equipmentItem = (EquipmentItem)item;
/* 376 */         int oldLevel = equipmentItem.getStrengthLevel();
/* 377 */         if (oldLevel < strengthLevel)
/*     */         {
/* 379 */           equipmentItem.setStrengthLevel(strengthLevel);
/* 380 */           if (gmRoleid != 0L)
/*     */           {
/* 382 */             String logString = String.format("玩家 [%d] 装备id[%d] 装备部位 [%d] 的启灵等级由[%d]级 设置为[%d]级", new Object[] { Long.valueOf(roleid), Integer.valueOf(itemId), Integer.valueOf(itemEquipCfg.wearpos), Integer.valueOf(oldLevel), Integer.valueOf(strengthLevel) });
/*     */             
/*     */ 
/* 385 */             GmManager.getInstance().sendResultToGM(gmRoleid, logString);
/* 386 */             String logString2 = String.format("PGM_CheckLingLevel.setLevelByItemId@roleid=%d|uuid=%d|itemid=%d|wearpos=%d|oldlevel=%d|newlevel=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(equipmentItem.getTlogUuid()), Integer.valueOf(itemId), Integer.valueOf(itemEquipCfg.wearpos), Integer.valueOf(oldLevel), Integer.valueOf(strengthLevel) });
/*     */             
/*     */ 
/* 389 */             ItemManager.logger.info(logString2);
/*     */           }
/* 391 */           return 0;
/*     */         }
/*     */       }
/*     */     }
/* 395 */     return -1;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PGM_CheckLingLevel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
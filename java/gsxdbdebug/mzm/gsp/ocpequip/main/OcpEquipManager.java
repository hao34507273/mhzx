/*     */ package mzm.gsp.ocpequip.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.item.confbean.SItemEquipCfg;
/*     */ import mzm.gsp.item.main.BasicItem;
/*     */ import mzm.gsp.item.main.EquipmentItem;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.ItemOperateResult;
/*     */ import mzm.gsp.item.main.RoleEquipBag;
/*     */ import mzm.gsp.multioccupation.main.MultiOccupInterface;
/*     */ import mzm.gsp.ocpequip.SCommonErrorInfo;
/*     */ import mzm.gsp.ocpequip.STransferStrengthFromOcpBagRes;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.role.main.RoleOneByOneManager;
/*     */ import mzm.gsp.server.main.ServerInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.superequipment.confbean.SSuperEquipmentConsts;
/*     */ import mzm.gsp.superequipment.event.SuperEquipmentDataExchanged;
/*     */ import mzm.gsp.superequipment.event.SuperEquipmentDataExchangedArg;
/*     */ import mzm.gsp.superequipment.main.SuperEquipmentInterface;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Bag;
/*     */ import xbean.Item;
/*     */ import xbean.OcpEquipBag;
/*     */ import xbean.Pod;
/*     */ import xtable.Role2ocpequipbag;
/*     */ 
/*     */ 
/*     */ public class OcpEquipManager
/*     */ {
/*  40 */   static final Logger logger = Logger.getLogger("ocpequip");
/*     */   
/*     */   static boolean activeNewOccupation(long paramLong, int paramInt1, int paramInt2)
/*     */   {
/*  44 */     int i = RoleInterface.getGender(paramLong);
/*  45 */     if (getEquipXBagByOcp(paramLong, paramInt1, i) != null) {} boolean bool = getEquipXBagByOcp(paramLong, paramInt1, i == 1 ? 2 : 1) != null;
/*  46 */     if (bool) {
/*  47 */       bool = switchOccupation(paramLong, paramInt1, paramInt2, i);
/*     */     }
/*  49 */     return bool;
/*     */   }
/*     */   
/*     */   static Bag getEquipXBagByOcp(long paramLong, int paramInt1, int paramInt2)
/*     */   {
/*  54 */     return getEquipXBagByOcp(paramLong, paramInt1, paramInt2, true);
/*     */   }
/*     */   
/*     */   static Bag getEquipXBagByOcp(long paramLong, OcpEquipBag paramOcpEquipBag, int paramInt1, int paramInt2, boolean paramBoolean)
/*     */   {
/*  59 */     if (paramOcpEquipBag == null) {
/*  60 */       return null;
/*     */     }
/*  62 */     int i = paramInt1 * 100 + paramInt2;
/*  63 */     Bag localBag = (Bag)paramOcpEquipBag.getOcp2equipbag().get(Integer.valueOf(paramInt1));
/*  64 */     if (localBag != null)
/*     */     {
/*  66 */       paramOcpEquipBag.getOcp2equipbag().remove(Integer.valueOf(paramInt1));
/*  67 */       paramOcpEquipBag.getOcp2equipbag().put(Integer.valueOf(i), localBag);
/*     */     }
/*     */     else
/*     */     {
/*  71 */       localBag = (Bag)paramOcpEquipBag.getOcp2equipbag().get(Integer.valueOf(i));
/*     */     }
/*  73 */     if ((localBag == null) && (paramBoolean))
/*     */     {
/*  75 */       localBag = Pod.newBag();
/*  76 */       int j = ItemInterface.getEquipBagCapacity();
/*  77 */       if (j <= 0)
/*     */       {
/*  79 */         String str = String.format("[ocpequip]OcpEquipManager.getEquipXBagByOcp@get bag capacity error|roleid=%d|ocp=%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1) });
/*     */         
/*  81 */         logger.error(str);
/*  82 */         return null;
/*     */       }
/*  84 */       localBag.setCapacity(j);
/*  85 */       paramOcpEquipBag.getOcp2equipbag().put(Integer.valueOf(i), localBag);
/*     */     }
/*  87 */     return localBag;
/*     */   }
/*     */   
/*     */   static Bag getEquipXBagByOcp(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
/*     */   {
/*  92 */     OcpEquipBag localOcpEquipBag = Role2ocpequipbag.get(Long.valueOf(paramLong));
/*  93 */     if (localOcpEquipBag == null)
/*     */     {
/*  95 */       localOcpEquipBag = Pod.newOcpEquipBag();
/*  96 */       Role2ocpequipbag.insert(Long.valueOf(paramLong), localOcpEquipBag);
/*     */     }
/*  98 */     return getEquipXBagByOcp(paramLong, localOcpEquipBag, paramInt1, paramInt2, paramBoolean);
/*     */   }
/*     */   
/*     */   static Bag removeEquipXBagByOcp(long paramLong, int paramInt1, int paramInt2)
/*     */   {
/* 103 */     OcpEquipBag localOcpEquipBag = Role2ocpequipbag.get(Long.valueOf(paramLong));
/* 104 */     if (localOcpEquipBag == null) {
/* 105 */       return null;
/*     */     }
/*     */     Bag localBag;
/* 108 */     if (localOcpEquipBag.getOcp2equipbag().containsKey(Integer.valueOf(paramInt1)))
/*     */     {
/* 110 */       localBag = (Bag)localOcpEquipBag.getOcp2equipbag().remove(Integer.valueOf(paramInt1));
/*     */     }
/*     */     else
/*     */     {
/* 114 */       int i = paramInt1 * 100 + paramInt2;
/* 115 */       localBag = (Bag)localOcpEquipBag.getOcp2equipbag().remove(Integer.valueOf(i));
/*     */     }
/*     */     
/* 118 */     return localBag;
/*     */   }
/*     */   
/*     */   static boolean switchOccupation(long paramLong, int paramInt1, int paramInt2, int paramInt3)
/*     */   {
/* 123 */     RoleEquipBag localRoleEquipBag = ItemInterface.getRoleEquipBag(paramLong);
/* 124 */     if (localRoleEquipBag == null) {
/* 125 */       return false;
/*     */     }
/* 127 */     Bag localBag1 = removeEquipXBagByOcp(paramLong, paramInt1, paramInt3);
/* 128 */     if (localBag1 == null) {
/* 129 */       return false;
/*     */     }
/* 131 */     Bag localBag2 = getEquipXBagByOcp(paramLong, paramInt2, paramInt3);
/* 132 */     if (localBag2 == null) {
/* 133 */       return false;
/*     */     }
/* 135 */     String str = String.format("[ocpequip]OcpEquipManager.switchOccupation@role switch ocp|roleid=%d|new_occupation=%d|old_occupation=%d|gender=%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
/*     */     
/* 137 */     logger.info(str);
/*     */     
/* 139 */     moveItemBetWeenBags(paramLong, localRoleEquipBag.getXBag(), localBag2);
/* 140 */     moveItemBetWeenBags(paramLong, localBag1, localRoleEquipBag.getXBag());
/* 141 */     transferStengthLevel(paramLong, paramInt2, paramInt1, localBag2, localRoleEquipBag.getXBag());
/* 142 */     transferSuperEquipmentData(paramLong, paramInt2, paramInt1, localBag2, localRoleEquipBag.getXBag());
/* 143 */     return true;
/*     */   }
/*     */   
/*     */   static boolean switchGender(long paramLong, int paramInt1, int paramInt2, int paramInt3)
/*     */   {
/* 148 */     RoleEquipBag localRoleEquipBag = ItemInterface.getRoleEquipBag(paramLong);
/* 149 */     if (localRoleEquipBag == null) {
/* 150 */       return false;
/*     */     }
/*     */     
/* 153 */     for (Object localObject1 = MultiOccupInterface.getOccupList(paramLong, false).iterator(); ((Iterator)localObject1).hasNext();) { localObject2 = (Integer)((Iterator)localObject1).next();
/*     */       
/* 155 */       getEquipXBagByOcp(paramLong, ((Integer)localObject2).intValue(), paramInt2);
/* 156 */       getEquipXBagByOcp(paramLong, ((Integer)localObject2).intValue(), paramInt3);
/*     */     }
/*     */     
/* 159 */     localObject1 = removeEquipXBagByOcp(paramLong, paramInt1, paramInt2);
/* 160 */     if (localObject1 == null) {
/* 161 */       localObject1 = getEquipXBagByOcp(paramLong, paramInt1, paramInt2);
/*     */     }
/* 163 */     Object localObject2 = getEquipXBagByOcp(paramLong, paramInt1, paramInt3);
/* 164 */     if (localObject2 == null) {
/* 165 */       return false;
/*     */     }
/* 167 */     String str = String.format("[ocpequip]OcpEquipManager.switchOccupation@role switch gender|roleid=%d|occupation=%d|new_gender=%d|old_gender=%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
/*     */     
/* 169 */     logger.info(str);
/*     */     
/* 171 */     moveItemBetWeenBags(paramLong, localRoleEquipBag.getXBag(), (Bag)localObject2);
/* 172 */     moveItemBetWeenBags(paramLong, (Bag)localObject1, localRoleEquipBag.getXBag());
/* 173 */     transferStengthLevel(paramLong, paramInt1, paramInt1, (Bag)localObject2, localRoleEquipBag.getXBag());
/* 174 */     transferSuperEquipmentData(paramLong, paramInt1, paramInt1, (Bag)localObject2, localRoleEquipBag.getXBag());
/* 175 */     return true;
/*     */   }
/*     */   
/*     */   static void moveItemBetWeenBags(long paramLong, Bag paramBag1, Bag paramBag2)
/*     */   {
/* 180 */     for (int i = 0; i <= 5; i++)
/*     */     {
/* 182 */       Item localItem1 = (Item)paramBag1.getItems().remove(Integer.valueOf(i));
/* 183 */       if (localItem1 != null)
/*     */       {
/* 185 */         Item localItem2 = localItem1.toBean();
/* 186 */         long l = 0L;
/* 187 */         if (!localItem2.getUuid().isEmpty()) {
/* 188 */           l = ((Long)localItem2.getUuid().iterator().next()).longValue();
/*     */         }
/* 190 */         paramBag2.getItems().put(Integer.valueOf(i), localItem2);
/* 191 */         String str = String.format("[ocpequip]OcpEquipManager.moveItemBetWeenBags@role move item from src to des bag|roleid=%d|wearpos=%d|itemid=%d|uuid=%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(i), Integer.valueOf(localItem2.getCfgid()), Long.valueOf(l) });
/*     */         
/* 193 */         logger.info(str);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   static void transferStengthLevel(long paramLong, int paramInt1, int paramInt2, Bag paramBag1, Bag paramBag2)
/*     */   {
/* 200 */     for (int i = 0; i <= 5; i++)
/*     */     {
/* 202 */       Item localItem1 = (Item)paramBag1.getItems().get(Integer.valueOf(i));
/* 203 */       Item localItem2 = (Item)paramBag2.getItems().get(Integer.valueOf(i));
/* 204 */       if ((localItem2 != null) && (localItem1 != null))
/*     */       {
/* 206 */         EquipmentItem localEquipmentItem1 = new EquipmentItem(localItem1);
/* 207 */         EquipmentItem localEquipmentItem2 = new EquipmentItem(localItem2);
/* 208 */         if (localEquipmentItem1.getStrengthLevel() > localEquipmentItem2.getStrengthLevel())
/*     */         {
/* 210 */           SItemEquipCfg localSItemEquipCfg1 = SItemEquipCfg.get(localItem1.getCfgid());
/* 211 */           SItemEquipCfg localSItemEquipCfg2 = SItemEquipCfg.get(localItem2.getCfgid());
/* 212 */           if ((localSItemEquipCfg1 != null) && (localSItemEquipCfg2 != null))
/*     */           {
/* 214 */             boolean bool = ItemInterface.canTransferStrengthLevel(paramLong, localSItemEquipCfg1, localSItemEquipCfg2, false);
/* 215 */             String str1; if (!bool)
/*     */             {
/* 217 */               str1 = String.format("[ocpequip]OcpEquipManager.transferStengthLevel@can not transfer strength level|roleid=%d|wearpos=%d|src_itemid=%d|src_uuid=%d|src_strength_level=%d|target_itemid=%d|target_uuid=%d|target_strength_level=%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(i), Integer.valueOf(localItem1.getCfgid()), Long.valueOf(localEquipmentItem1.getTlogUuid()), Integer.valueOf(localEquipmentItem1.getStrengthLevel()), Integer.valueOf(localItem2.getCfgid()), Long.valueOf(localEquipmentItem2.getTlogUuid()), Integer.valueOf(localEquipmentItem2.getStrengthLevel()) });
/*     */               
/* 219 */               logger.info(str1);
/*     */             }
/*     */             else
/*     */             {
/* 223 */               str1 = localEquipmentItem2.getAccumulationQiLinExtraString();
/* 224 */               ItemInterface.exchangeEquipAccumulationQilinInfo(localEquipmentItem1, localEquipmentItem2);
/*     */               
/* 226 */               String str2 = String.format("[ocpequip]OcpEquipManager.transferStengthLevel@transfer strength level|roleid=%d|wearpos=%d|src_itemid=%d|src_uuid=%d|src_strength_level=%d|target_itemid=%d|target_uuid=%d|target_strength_level=%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(i), Integer.valueOf(localItem1.getCfgid()), Long.valueOf(localEquipmentItem1.getTlogUuid()), Integer.valueOf(localEquipmentItem2.getStrengthLevel()), Integer.valueOf(localItem2.getCfgid()), Long.valueOf(localEquipmentItem2.getTlogUuid()), Integer.valueOf(localEquipmentItem1.getStrengthLevel()) });
/*     */               
/* 228 */               logger.info(str2);
/*     */               
/* 230 */               tlogOcpEquipTransferLin(paramLong, paramInt1, paramInt2, localItem1.getCfgid(), localItem2.getCfgid(), localEquipmentItem1.getTlogUuid(), localEquipmentItem2.getTlogUuid(), localEquipmentItem1.getStrengthLevel(), localEquipmentItem2.getStrengthLevel(), str1, localEquipmentItem2.getAccumulationQiLinExtraString());
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private static void transferSuperEquipmentData(long paramLong, int paramInt1, int paramInt2, Bag paramBag1, Bag paramBag2)
/*     */   {
/* 240 */     if (!OpenInterface.getOpenStatus(382)) {
/* 241 */       return;
/*     */     }
/* 243 */     if (RoleInterface.getLevel(paramLong) < SSuperEquipmentConsts.getInstance().OPEN_ROLE_LEVEL) {
/* 244 */       return;
/*     */     }
/* 246 */     if (ServerInterface.getCurrentServerLevel() < SSuperEquipmentConsts.getInstance().OPEN_SERVER_LEVEL) {
/* 247 */       return;
/*     */     }
/* 249 */     for (int i = 0; i <= 5; i++)
/*     */     {
/* 251 */       Item localItem1 = (Item)paramBag1.getItems().get(Integer.valueOf(i));
/* 252 */       Item localItem2 = (Item)paramBag2.getItems().get(Integer.valueOf(i));
/* 253 */       if ((localItem1 != null) && (localItem2 != null))
/*     */       {
/* 255 */         EquipmentItem localEquipmentItem1 = new EquipmentItem(localItem1);
/* 256 */         int j = localEquipmentItem1.getSuperEquipmentStage();
/* 257 */         int k = localEquipmentItem1.getSuperEquipmentLevel();
/* 258 */         HashMap localHashMap1 = new HashMap(localEquipmentItem1.getSuperEquipmentImproveStageCostMap());
/*     */         
/* 260 */         HashMap localHashMap2 = new HashMap(localEquipmentItem1.getSuperEquipmentImproveLevelCostMap());
/*     */         
/* 262 */         HashMap localHashMap3 = new HashMap(localEquipmentItem1.getJewelMap());
/* 263 */         int m = localEquipmentItem1.getBlessLevel();
/* 264 */         int n = localEquipmentItem1.getBlessExp();
/*     */         
/* 266 */         EquipmentItem localEquipmentItem2 = new EquipmentItem(localItem2);
/* 267 */         int i1 = localEquipmentItem2.getSuperEquipmentStage();
/* 268 */         int i2 = localEquipmentItem2.getSuperEquipmentLevel();
/* 269 */         HashMap localHashMap4 = new HashMap(localEquipmentItem2.getSuperEquipmentImproveStageCostMap());
/*     */         
/* 271 */         HashMap localHashMap5 = new HashMap(localEquipmentItem2.getSuperEquipmentImproveLevelCostMap());
/*     */         
/* 273 */         HashMap localHashMap6 = new HashMap(localEquipmentItem2.getJewelMap());
/* 274 */         int i3 = localEquipmentItem2.getBlessLevel();
/* 275 */         int i4 = localEquipmentItem2.getBlessExp();
/* 276 */         if ((SuperEquipmentInterface.meetLowestConditionsForSuperEquipment(localEquipmentItem2)) && 
/* 277 */           (localEquipmentItem1.getSuperEquipmentStage() >= localEquipmentItem2.getSuperEquipmentStage()))
/*     */         {
/* 279 */           int i5 = 0;
/* 280 */           if (localEquipmentItem1.getSuperEquipmentStage() > localEquipmentItem2.getSuperEquipmentStage())
/*     */           {
/* 282 */             localEquipmentItem1.setSuperEquipmentStage(i1);
/* 283 */             localEquipmentItem2.setSuperEquipmentStage(j);
/* 284 */             localEquipmentItem1.getSuperEquipmentImproveStageCostMap().clear();
/* 285 */             localEquipmentItem2.getSuperEquipmentImproveStageCostMap().clear();
/* 286 */             localEquipmentItem1.getSuperEquipmentImproveStageCostMap().putAll(localHashMap4);
/* 287 */             localEquipmentItem2.getSuperEquipmentImproveStageCostMap().putAll(localHashMap1);
/* 288 */             i5 = 1;
/*     */           }
/* 290 */           if (localEquipmentItem1.getSuperEquipmentLevel() > localEquipmentItem2.getSuperEquipmentLevel())
/*     */           {
/* 292 */             localEquipmentItem1.setSuperEquipmentLevel(i2);
/* 293 */             localEquipmentItem2.setSuperEquipmentLevel(k);
/* 294 */             localEquipmentItem1.getSuperEquipmentImproveLevelCostMap().clear();
/* 295 */             localEquipmentItem2.getSuperEquipmentImproveLevelCostMap().clear();
/* 296 */             localEquipmentItem1.getSuperEquipmentImproveLevelCostMap().putAll(localHashMap5);
/* 297 */             localEquipmentItem2.getSuperEquipmentImproveLevelCostMap().putAll(localHashMap2);
/* 298 */             i5 = 1;
/*     */           }
/* 300 */           if (i5 != 0)
/*     */           {
/* 302 */             localEquipmentItem1.getJewelMap().clear();
/* 303 */             localEquipmentItem2.getJewelMap().clear();
/* 304 */             localEquipmentItem1.getJewelMap().putAll(localHashMap6);
/* 305 */             localEquipmentItem2.getJewelMap().putAll(localHashMap3);
/* 306 */             localEquipmentItem1.setBlessLevel(i3);
/* 307 */             localEquipmentItem1.setBlessExp(i4);
/* 308 */             localEquipmentItem2.setBlessLevel(m);
/* 309 */             localEquipmentItem2.setBlessExp(n);
/*     */             
/* 311 */             tlogTransferSuperEquipmentData(paramLong, localEquipmentItem1.getFirstUuid().longValue(), localEquipmentItem2.getFirstUuid().longValue());
/* 312 */             triggerTransferSuperEquipmentData(paramLong, localEquipmentItem1.getFirstUuid().longValue(), localEquipmentItem2.getFirstUuid().longValue());
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   static boolean genderConvert(long paramLong, int paramInt1, int paramInt2)
/*     */   {
/* 322 */     int i = RoleInterface.getOccupationId(paramLong);
/* 323 */     boolean bool = getEquipXBagByOcp(paramLong, i, paramInt1) != null;
/* 324 */     if (bool) {
/* 325 */       bool = switchGender(paramLong, i, paramInt1, paramInt2);
/*     */     }
/* 327 */     return bool;
/*     */   }
/*     */   
/*     */   static boolean addItemIntoOcpEquipBag(long paramLong, int paramInt, Item paramItem)
/*     */   {
/* 332 */     int i = RoleInterface.getGender(paramLong);
/* 333 */     Bag localBag = getEquipXBagByOcp(paramLong, paramInt, i);
/* 334 */     if (localBag == null) {
/* 335 */       return false;
/*     */     }
/* 337 */     RoleEquipBag localRoleEquipBag = new RoleEquipBag(localBag);
/* 338 */     ItemOperateResult localItemOperateResult = localRoleEquipBag.addItem(paramItem);
/* 339 */     return localItemOperateResult.success();
/*     */   }
/*     */   
/*     */   static BasicItem removeItemFromOcpEquipBag(long paramLong, int paramInt1, int paramInt2)
/*     */   {
/* 344 */     int i = RoleInterface.getGender(paramLong);
/* 345 */     Bag localBag = getEquipXBagByOcp(paramLong, paramInt1, i);
/* 346 */     if (localBag == null) {
/* 347 */       return null;
/*     */     }
/* 349 */     RoleEquipBag localRoleEquipBag = new RoleEquipBag(localBag);
/* 350 */     return localRoleEquipBag.removeByGrid(paramInt2);
/*     */   }
/*     */   
/*     */   static BasicItem getItemFromOcpEquipBag(long paramLong, int paramInt1, int paramInt2)
/*     */   {
/* 355 */     int i = RoleInterface.getGender(paramLong);
/* 356 */     Bag localBag = getEquipXBagByOcp(paramLong, paramInt1, i);
/* 357 */     if (localBag == null) {
/* 358 */       return null;
/*     */     }
/* 360 */     RoleEquipBag localRoleEquipBag = new RoleEquipBag(localBag);
/* 361 */     return localRoleEquipBag.get(paramInt2);
/*     */   }
/*     */   
/*     */   static TransferStrengthLevelBean transferStrengthFromOtherOcpBag(long paramLong, int paramInt, EquipmentItem paramEquipmentItem)
/*     */   {
/* 366 */     if (!isOcpEquipTransferLinSwitchOpenForRole(paramLong)) {
/* 367 */       return null;
/*     */     }
/* 369 */     OcpEquipBag localOcpEquipBag = Role2ocpequipbag.get(Long.valueOf(paramLong));
/* 370 */     if (localOcpEquipBag == null)
/*     */     {
/* 372 */       localOcpEquipBag = Pod.newOcpEquipBag();
/* 373 */       Role2ocpequipbag.insert(Long.valueOf(paramLong), localOcpEquipBag);
/*     */     }
/* 375 */     int i = paramEquipmentItem.getStrengthLevel();
/* 376 */     int j = -1;
/* 377 */     int k = RoleInterface.getGender(paramLong);
/* 378 */     for (Object localObject1 = localOcpEquipBag.getOcp2equipbag().keySet().iterator(); ((Iterator)localObject1).hasNext();)
/*     */     {
/* 380 */       m = ((Integer)((Iterator)localObject1).next()).intValue();
/* 381 */       int n = m;
/* 382 */       int i1 = k;
/* 383 */       if (n > 100)
/*     */       {
/* 385 */         n = m / 100;
/* 386 */         i1 = m % 100;
/*     */       }
/*     */       
/* 389 */       localObject2 = (Bag)localOcpEquipBag.getOcp2equipbag().get(Integer.valueOf(m));
/* 390 */       Item localItem2 = (Item)((Bag)localObject2).getItems().get(Integer.valueOf(paramInt));
/* 391 */       if (localItem2 != null)
/*     */       {
/* 393 */         localObject3 = new EquipmentItem(localItem2);
/* 394 */         if (((EquipmentItem)localObject3).getStrengthLevel() > i)
/*     */         {
/* 396 */           i = ((EquipmentItem)localObject3).getStrengthLevel();
/* 397 */           j = n;
/* 398 */           k = i1; } } }
/*     */     int m;
/*     */     Object localObject2;
/*     */     Object localObject3;
/* 402 */     if ((j != -1) && (i > paramEquipmentItem.getStrengthLevel()))
/*     */     {
/* 404 */       localObject1 = (Bag)localOcpEquipBag.getOcp2equipbag().get(Integer.valueOf(j));
/* 405 */       if (localObject1 == null)
/*     */       {
/* 407 */         m = j * 100 + k;
/* 408 */         localObject1 = (Bag)localOcpEquipBag.getOcp2equipbag().get(Integer.valueOf(m));
/*     */       }
/* 410 */       Item localItem1 = (Item)((Bag)localObject1).getItems().get(Integer.valueOf(paramInt));
/* 411 */       if (localItem1 != null)
/*     */       {
/* 413 */         EquipmentItem localEquipmentItem = new EquipmentItem(localItem1);
/* 414 */         SItemEquipCfg localSItemEquipCfg = SItemEquipCfg.get(localItem1.getCfgid());
/* 415 */         localObject2 = SItemEquipCfg.get(paramEquipmentItem.getCfgId());
/* 416 */         if ((localSItemEquipCfg == null) || (localObject2 == null)) {
/* 417 */           return null;
/*     */         }
/* 419 */         boolean bool = ItemInterface.canTransferStrengthLevel(paramLong, localSItemEquipCfg, (SItemEquipCfg)localObject2, false);
/* 420 */         if (!bool)
/*     */         {
/* 422 */           localObject3 = String.format("[ocpequip]OcpEquipManager.transferStrengthFromOtherOcpBag@can not transfer strength level|roleid=%d|wearpos=%d|src_itemid=%d|src_uuid=%d|src_strength_level=%d|target_itemid=%d|target_uuid=%d|target_strength_level=%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt), Integer.valueOf(localEquipmentItem.getCfgId()), Long.valueOf(localEquipmentItem.getTlogUuid()), Integer.valueOf(localEquipmentItem.getStrengthLevel()), Integer.valueOf(paramEquipmentItem.getCfgId()), Long.valueOf(paramEquipmentItem.getTlogUuid()), Integer.valueOf(paramEquipmentItem.getStrengthLevel()) });
/*     */           
/* 424 */           logger.info(localObject3);
/* 425 */           return null;
/*     */         }
/* 427 */         long l1 = localEquipmentItem.getFirstUuid().longValue();
/* 428 */         long l2 = paramEquipmentItem.getFirstUuid().longValue();
/*     */         
/* 430 */         String str = String.format("[ocpequip]OcpEquipManager.transferStrengthFromOtherOcpBag@transfer strength from other ocp bag success|roleid=%d|ocp=%d|uuid=%d|itemid=%d|wearpos=%d|strength_level=%d|be_transfered_ocp=%d|be_transfered_itemid=%d|be_transfered_uuid=%d|be_transfered_strength_level=%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(RoleInterface.getOccupationId(paramLong)), Long.valueOf(l2), Integer.valueOf(paramEquipmentItem.getCfgId()), Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(localEquipmentItem.getCfgId()), Long.valueOf(l1), Integer.valueOf(localEquipmentItem.getStrengthLevel()) });
/*     */         
/* 432 */         logger.info(str);
/*     */         
/* 434 */         STransferStrengthFromOcpBagRes localSTransferStrengthFromOcpBagRes = new STransferStrengthFromOcpBagRes();
/* 435 */         localSTransferStrengthFromOcpBagRes.ocp = j;
/* 436 */         localSTransferStrengthFromOcpBagRes.gender = k;
/* 437 */         localSTransferStrengthFromOcpBagRes.itemid = localEquipmentItem.getCfgId();
/* 438 */         localSTransferStrengthFromOcpBagRes.key = paramInt;
/* 439 */         localSTransferStrengthFromOcpBagRes.strengthlevel = i;
/* 440 */         OnlineManager.getInstance().send(paramLong, localSTransferStrengthFromOcpBagRes);
/*     */         
/* 442 */         ItemInterface.exchangeEquipAccumulationQilinInfo(localEquipmentItem, paramEquipmentItem);
/*     */         
/* 444 */         return new TransferStrengthLevelBean(j, l1, i, localEquipmentItem.getCfgId());
/*     */       }
/* 446 */       return null;
/*     */     }
/* 448 */     return null;
/*     */   }
/*     */   
/*     */   static void transferSuperEquipmentDataFromOtherOcpBag(long paramLong, int paramInt, EquipmentItem paramEquipmentItem)
/*     */   {
/* 453 */     OcpEquipBag localOcpEquipBag = Role2ocpequipbag.get(Long.valueOf(paramLong));
/* 454 */     if (localOcpEquipBag == null) {
/* 455 */       return;
/*     */     }
/* 457 */     Object localObject1 = null;
/* 458 */     for (Bag localBag : localOcpEquipBag.getOcp2equipbag().values())
/*     */     {
/* 460 */       localObject2 = (Item)localBag.getItems().get(Integer.valueOf(paramInt));
/* 461 */       if (localObject2 != null)
/*     */       {
/* 463 */         localObject3 = new EquipmentItem((Item)localObject2);
/* 464 */         if ((localObject1 == null) || (((EquipmentItem)localObject3).getSuperEquipmentLevel() > ((EquipmentItem)localObject1).getSuperEquipmentLevel()) || ((((EquipmentItem)localObject3).getSuperEquipmentLevel() == ((EquipmentItem)localObject1).getSuperEquipmentLevel()) && (((EquipmentItem)localObject3).getSuperEquipmentStage() > ((EquipmentItem)localObject1).getSuperEquipmentStage()))) {
/* 465 */           localObject1 = localObject3;
/*     */         }
/*     */       }
/*     */     }
/* 469 */     if (localObject1 == null) {
/* 470 */       return;
/*     */     }
/* 472 */     if (((EquipmentItem)localObject1).getSuperEquipmentLevel() < paramEquipmentItem.getSuperEquipmentLevel()) {
/* 473 */       return;
/*     */     }
/* 475 */     if ((((EquipmentItem)localObject1).getSuperEquipmentLevel() == paramEquipmentItem.getSuperEquipmentLevel()) && (((EquipmentItem)localObject1).getSuperEquipmentStage() <= paramEquipmentItem.getSuperEquipmentStage())) {
/* 476 */       return;
/*     */     }
/* 478 */     int i = ((EquipmentItem)localObject1).getSuperEquipmentStage();
/* 479 */     int j = ((EquipmentItem)localObject1).getSuperEquipmentLevel();
/* 480 */     Object localObject2 = new HashMap(((EquipmentItem)localObject1).getSuperEquipmentImproveStageCostMap());
/*     */     
/* 482 */     Object localObject3 = new HashMap(((EquipmentItem)localObject1).getSuperEquipmentImproveLevelCostMap());
/*     */     
/* 484 */     HashMap localHashMap1 = new HashMap(((EquipmentItem)localObject1).getJewelMap());
/* 485 */     int k = ((EquipmentItem)localObject1).getBlessLevel();
/* 486 */     int m = ((EquipmentItem)localObject1).getBlessExp();
/*     */     
/* 488 */     int n = paramEquipmentItem.getSuperEquipmentStage();
/* 489 */     int i1 = paramEquipmentItem.getSuperEquipmentLevel();
/* 490 */     HashMap localHashMap2 = new HashMap(paramEquipmentItem.getSuperEquipmentImproveStageCostMap());
/*     */     
/* 492 */     HashMap localHashMap3 = new HashMap(paramEquipmentItem.getSuperEquipmentImproveLevelCostMap());
/*     */     
/* 494 */     HashMap localHashMap4 = new HashMap(paramEquipmentItem.getJewelMap());
/* 495 */     int i2 = paramEquipmentItem.getBlessLevel();
/* 496 */     int i3 = paramEquipmentItem.getBlessExp();
/*     */     
/* 498 */     ((EquipmentItem)localObject1).setSuperEquipmentStage(n);
/* 499 */     ((EquipmentItem)localObject1).setSuperEquipmentLevel(i1);
/* 500 */     paramEquipmentItem.setSuperEquipmentStage(i);
/* 501 */     paramEquipmentItem.setSuperEquipmentLevel(j);
/*     */     
/* 503 */     ((EquipmentItem)localObject1).getSuperEquipmentImproveStageCostMap().clear();
/* 504 */     ((EquipmentItem)localObject1).getSuperEquipmentImproveLevelCostMap().clear();
/* 505 */     paramEquipmentItem.getSuperEquipmentImproveStageCostMap().clear();
/* 506 */     paramEquipmentItem.getSuperEquipmentImproveLevelCostMap().clear();
/* 507 */     ((EquipmentItem)localObject1).getSuperEquipmentImproveStageCostMap().putAll(localHashMap2);
/* 508 */     ((EquipmentItem)localObject1).getSuperEquipmentImproveLevelCostMap().putAll(localHashMap3);
/* 509 */     paramEquipmentItem.getSuperEquipmentImproveStageCostMap().putAll((Map)localObject2);
/* 510 */     paramEquipmentItem.getSuperEquipmentImproveLevelCostMap().putAll((Map)localObject3);
/*     */     
/* 512 */     ((EquipmentItem)localObject1).getJewelMap().clear();
/* 513 */     paramEquipmentItem.getJewelMap().clear();
/* 514 */     ((EquipmentItem)localObject1).getJewelMap().putAll(localHashMap4);
/* 515 */     paramEquipmentItem.getJewelMap().putAll(localHashMap1);
/*     */     
/* 517 */     ((EquipmentItem)localObject1).setBlessLevel(i2);
/* 518 */     ((EquipmentItem)localObject1).setBlessExp(i3);
/* 519 */     paramEquipmentItem.setBlessLevel(k);
/* 520 */     paramEquipmentItem.setBlessExp(m);
/*     */     
/* 522 */     tlogTransferSuperEquipmentData(paramLong, ((EquipmentItem)localObject1).getFirstUuid().longValue(), paramEquipmentItem.getFirstUuid().longValue());
/* 523 */     triggerTransferSuperEquipmentData(paramLong, ((EquipmentItem)localObject1).getFirstUuid().longValue(), paramEquipmentItem.getFirstUuid().longValue());
/*     */   }
/*     */   
/*     */   static boolean hasOcp(long paramLong, int paramInt)
/*     */   {
/* 528 */     return MultiOccupInterface.hasOccupation(paramLong, paramInt, false);
/*     */   }
/*     */   
/*     */   static void sendScommonErrorRes(long paramLong, int paramInt)
/*     */   {
/* 533 */     SCommonErrorInfo localSCommonErrorInfo = new SCommonErrorInfo();
/* 534 */     localSCommonErrorInfo.errorcode = paramInt;
/* 535 */     OnlineManager.getInstance().sendAtOnce(paramLong, localSCommonErrorInfo);
/*     */   }
/*     */   
/*     */   static void tlogOcpEquipOn(long paramLong1, int paramInt1, EquipmentItem paramEquipmentItem, int paramInt2, int paramInt3, long paramLong2, int paramInt4)
/*     */   {
/* 540 */     String str1 = GameServerInfoManager.getHostIP();
/* 541 */     String str2 = RoleInterface.getUserId(paramLong1);
/* 542 */     int i = RoleInterface.getLevel(paramLong1);
/*     */     
/* 544 */     Object[] arrayOfObject = { str1, str2, Long.valueOf(paramLong1), Integer.valueOf(i), Integer.valueOf(paramEquipmentItem.getCfgId()), Integer.valueOf(paramInt2), Long.valueOf(paramEquipmentItem.getTlogUuid()), paramEquipmentItem.getTlogExtraString(), paramEquipmentItem.getTlogHunProString(), Integer.valueOf(paramInt1), Integer.valueOf(paramEquipmentItem.getStrengthLevel()), Integer.valueOf(paramInt3), Long.valueOf(paramLong2), Integer.valueOf(paramInt4) };
/*     */     
/* 546 */     TLogManager.getInstance().addLog(paramLong1, "OcpEquipon", arrayOfObject);
/*     */   }
/*     */   
/*     */   static void tlogOcpEquipOff(long paramLong, int paramInt1, EquipmentItem paramEquipmentItem, int paramInt2)
/*     */   {
/* 551 */     String str1 = GameServerInfoManager.getHostIP();
/* 552 */     String str2 = RoleInterface.getUserId(paramLong);
/* 553 */     int i = RoleInterface.getLevel(paramLong);
/* 554 */     Object[] arrayOfObject = { str1, str2, Long.valueOf(paramLong), Integer.valueOf(i), Integer.valueOf(paramEquipmentItem.getCfgId()), Integer.valueOf(paramInt2), Long.valueOf(paramEquipmentItem.getTlogUuid()), paramEquipmentItem.getTlogExtraString(), paramEquipmentItem.getTlogHunProString(), Integer.valueOf(paramInt1), Integer.valueOf(paramEquipmentItem.getStrengthLevel()) };
/*     */     
/* 556 */     TLogManager.getInstance().addLog(paramLong, "OcpEquipoff", arrayOfObject);
/*     */   }
/*     */   
/*     */   public static boolean isOcpEquipOnSwitchOpenForRole(long paramLong)
/*     */   {
/* 561 */     if (!OpenInterface.getOpenStatus(180)) {
/* 562 */       return false;
/*     */     }
/* 564 */     if (OpenInterface.isBanPlay(paramLong, 180))
/*     */     {
/* 566 */       OpenInterface.sendBanPlayMsg(paramLong, 180);
/* 567 */       return false;
/*     */     }
/* 569 */     return true;
/*     */   }
/*     */   
/*     */   public static boolean isOcpEquipOffSwitchOpenForRole(long paramLong)
/*     */   {
/* 574 */     if (!OpenInterface.getOpenStatus(181)) {
/* 575 */       return false;
/*     */     }
/* 577 */     if (OpenInterface.isBanPlay(paramLong, 181))
/*     */     {
/* 579 */       OpenInterface.sendBanPlayMsg(paramLong, 181);
/* 580 */       return false;
/*     */     }
/* 582 */     return true;
/*     */   }
/*     */   
/*     */   public static boolean isOcpEquipTransferLinSwitchOpenForRole(long paramLong)
/*     */   {
/* 587 */     if (!OpenInterface.getOpenStatus(182)) {
/* 588 */       return false;
/*     */     }
/* 590 */     if (OpenInterface.isBanPlay(paramLong, 182)) {
/* 591 */       return false;
/*     */     }
/* 593 */     return true;
/*     */   }
/*     */   
/*     */   static boolean isRoleStateCanOperateOcpEquip(long paramLong)
/*     */   {
/* 598 */     return RoleStatusInterface.checkCanSetStatus(paramLong, 136, true);
/*     */   }
/*     */   
/*     */   static void tlogOcpEquipTransferLin(long paramLong1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong2, long paramLong3, int paramInt5, int paramInt6, String paramString1, String paramString2)
/*     */   {
/* 603 */     String str1 = GameServerInfoManager.getHostIP();
/* 604 */     String str2 = RoleInterface.getUserId(paramLong1);
/* 605 */     int i = RoleInterface.getLevel(paramLong1);
/*     */     
/* 607 */     Object[] arrayOfObject = { str1, str2, Long.valueOf(paramLong1), Integer.valueOf(i), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Long.valueOf(paramLong2), Long.valueOf(paramLong3), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), paramString1, paramString2 };
/*     */     
/* 609 */     TLogManager.getInstance().addLog(paramLong1, "OcpEquipTransferLin", arrayOfObject);
/*     */   }
/*     */   
/*     */   private static void tlogTransferSuperEquipmentData(long paramLong1, long paramLong2, long paramLong3)
/*     */   {
/* 614 */     String str1 = GameServerInfoManager.getHostIP();
/* 615 */     String str2 = RoleInterface.getUserId(paramLong1);
/* 616 */     int i = RoleInterface.getLevel(paramLong1);
/*     */     
/* 618 */     Object[] arrayOfObject = { str1, str2, Long.valueOf(paramLong1), Integer.valueOf(i), Long.valueOf(paramLong2), Long.valueOf(paramLong3), Integer.valueOf(1) };
/* 619 */     TLogManager.getInstance().addLog(paramLong1, "SuperEquipmentExchangeData", arrayOfObject);
/*     */   }
/*     */   
/*     */   private static void triggerTransferSuperEquipmentData(long paramLong1, long paramLong2, long paramLong3)
/*     */   {
/* 624 */     TriggerEventsManger.getInstance().triggerEvent(new SuperEquipmentDataExchanged(), new SuperEquipmentDataExchangedArg(paramLong1, paramLong2, paramLong3, true), RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(paramLong1)));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ocpequip\main\OcpEquipManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
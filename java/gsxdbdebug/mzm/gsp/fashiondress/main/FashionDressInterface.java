/*     */ package mzm.gsp.fashiondress.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import java.util.TreeMap;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.fashiondress.confbean.ExtraInfo;
/*     */ import mzm.gsp.fashiondress.confbean.Pro2Value;
/*     */ import mzm.gsp.fashiondress.confbean.SFashionDressCfg;
/*     */ import mzm.gsp.fashiondress.confbean.SThemeFashionDressCfg;
/*     */ import mzm.gsp.fashiondress.confbean.SThemeFashionDressPropCfg;
/*     */ import mzm.gsp.fashiondress.event.FashionDressModelArg;
/*     */ import mzm.gsp.fashiondress.event.PassiveSkillChangeArg;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.roledye.main.RoleDyeInterface;
/*     */ import mzm.gsp.skill.confbean.SPassiveSkillCfg;
/*     */ import mzm.gsp.skill.main.PassiveSkill;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.FashionDressInfo;
/*     */ import xbean.Pod;
/*     */ import xbean.Role2FashionDressInfo;
/*     */ import xbean.TransferOccupationFashionDress;
/*     */ import xtable.Role2fashiondress;
/*     */ 
/*     */ public class FashionDressInterface
/*     */ {
/*     */   public static int getWearFashionDress(long paramLong, boolean paramBoolean)
/*     */   {
/*  36 */     Role2FashionDressInfo localRole2FashionDressInfo = null;
/*  37 */     if (paramBoolean) {
/*  38 */       localRole2FashionDressInfo = Role2fashiondress.get(Long.valueOf(paramLong));
/*     */     } else {
/*  40 */       localRole2FashionDressInfo = Role2fashiondress.select(Long.valueOf(paramLong));
/*     */     }
/*  42 */     if (localRole2FashionDressInfo == null) {
/*  43 */       return -1;
/*     */     }
/*  45 */     return localRole2FashionDressInfo.getCurrent_fashion_dress_cfg_id();
/*     */   }
/*     */   
/*     */   public static Map<Integer, Integer> getFashionDressPassiveSkillMap(long paramLong, boolean paramBoolean)
/*     */   {
/*  50 */     List localList = FashionDressManager.getFashionDressPassiveSkillIdList(paramLong, paramBoolean);
/*     */     
/*  52 */     HashMap localHashMap = new HashMap();
/*  53 */     if (localList.isEmpty()) {
/*  54 */       return localHashMap;
/*     */     }
/*  56 */     for (Integer localInteger : localList) {
/*  57 */       localHashMap.put(localInteger, Integer.valueOf(1));
/*     */     }
/*  59 */     return localHashMap;
/*     */   }
/*     */   
/*     */   public static Map<Integer, Integer> getThemeFashionDressRoleProperty(long paramLong, boolean paramBoolean)
/*     */   {
/*  64 */     Object localObject1 = null;
/*  65 */     if (!FashionDressManager.isThemeFashionDressSwitchOpenForRole(paramLong)) {
/*  66 */       return (Map<Integer, Integer>)localObject1;
/*     */     }
/*  68 */     Role2FashionDressInfo localRole2FashionDressInfo = null;
/*  69 */     if (paramBoolean) {
/*  70 */       localRole2FashionDressInfo = Role2fashiondress.get(Long.valueOf(paramLong));
/*     */     } else {
/*  72 */       localRole2FashionDressInfo = Role2fashiondress.select(Long.valueOf(paramLong));
/*     */     }
/*  74 */     if (localRole2FashionDressInfo == null) {
/*  75 */       return (Map<Integer, Integer>)localObject1;
/*     */     }
/*  77 */     for (SThemeFashionDressCfg localSThemeFashionDressCfg : SThemeFashionDressCfg.getAll().values())
/*     */     {
/*  79 */       int i = 0;
/*  80 */       for (Object localObject2 = localSThemeFashionDressCfg.unlock_theme_fashion_dress_type_list.iterator(); ((Iterator)localObject2).hasNext();)
/*     */       {
/*  82 */         int j = ((Integer)((Iterator)localObject2).next()).intValue();
/*  83 */         if (localRole2FashionDressInfo.getOwn_unlock_theme_fashion_dress_type_set().contains(Integer.valueOf(j))) {
/*  84 */           i++;
/*     */         }
/*     */       }
/*  87 */       localObject2 = SThemeFashionDressPropCfg.get(localSThemeFashionDressCfg.id);
/*  88 */       if (localObject2 != null)
/*     */       {
/*  90 */         Map.Entry localEntry = ((SThemeFashionDressPropCfg)localObject2).extra_infos.floorEntry(Integer.valueOf(i));
/*  91 */         if (localEntry != null) {
/*  92 */           for (Pro2Value localPro2Value : ((ExtraInfo)localEntry.getValue()).prop_list)
/*     */           {
/*  94 */             if (localObject1 == null) {
/*  95 */               localObject1 = new HashMap();
/*     */             }
/*  97 */             Integer localInteger = (Integer)((Map)localObject1).get(Integer.valueOf(localPro2Value.protype));
/*  98 */             int k = localInteger == null ? localPro2Value.provalue : localInteger.intValue() + localPro2Value.provalue;
/*  99 */             ((Map)localObject1).put(Integer.valueOf(localPro2Value.protype), Integer.valueOf(k));
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 104 */     return (Map<Integer, Integer>)localObject1;
/*     */   }
/*     */   
/*     */   public static List<PassiveSkill> getFashionDressPassiveSkillList(long paramLong, boolean paramBoolean)
/*     */   {
/* 109 */     ArrayList localArrayList = new ArrayList();
/*     */     
/* 111 */     List localList = FashionDressManager.getFashionDressPassiveSkillIdList(paramLong, paramBoolean);
/* 112 */     if (localList.isEmpty()) {
/* 113 */       return localArrayList;
/*     */     }
/* 115 */     for (Integer localInteger : localList)
/*     */     {
/* 117 */       PassiveSkill localPassiveSkill = new PassiveSkill(SPassiveSkillCfg.get(localInteger.intValue()), 1);
/* 118 */       localArrayList.add(localPassiveSkill);
/*     */     }
/* 120 */     return localArrayList;
/*     */   }
/*     */   
/*     */   public static void changeRoleClothAndModel(long paramLong, int paramInt)
/*     */   {
/* 125 */     RoleDyeInterface.setRoleClothColor(paramLong, paramInt);
/*     */     
/* 127 */     FashionDressManager.triggerModelChangeEvent(new FashionDressModelArg(paramLong));
/*     */   }
/*     */   
/*     */   public static boolean activeNewOccupation(long paramLong, int paramInt1, int paramInt2)
/*     */   {
/* 132 */     if (paramInt1 == paramInt2)
/*     */     {
/* 134 */       GameServer.logger().error(String.format("[fashiondress]FashionDressInterface.activeNewOccupation@new occupation same with current occupation|role_id=%d|new_occupation=%d|old_occupation=%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
/*     */       
/* 136 */       return false;
/*     */     }
/* 138 */     Role2FashionDressInfo localRole2FashionDressInfo = Role2fashiondress.get(Long.valueOf(paramLong));
/* 139 */     if (localRole2FashionDressInfo == null)
/*     */     {
/* 141 */       localRole2FashionDressInfo = Pod.newRole2FashionDressInfo();
/* 142 */       localRole2FashionDressInfo.setCurrent_fashion_dress_cfg_id(-1);
/* 143 */       Role2fashiondress.add(Long.valueOf(paramLong), localRole2FashionDressInfo);
/*     */     }
/*     */     
/* 146 */     int i = RoleInterface.getGender(paramLong);
/* 147 */     int j = paramInt1 * 100 + i;
/* 148 */     int k = paramInt2 * 100 + i;
/* 149 */     Map localMap1 = localRole2FashionDressInfo.getTransfer_occupation_fashion_dress_map();
/* 150 */     if ((localMap1.containsKey(Integer.valueOf(paramInt1))) || (localMap1.containsKey(Integer.valueOf(j))))
/*     */     {
/* 152 */       GameServer.logger().error(String.format("[fashiondress]FashionDressInterface.activeNewOccupation@aleardy has new occupation fashion dress|role_id=%d|new_occupation=%d|old_occupation=%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
/*     */       
/* 154 */       return false;
/*     */     }
/* 156 */     Map localMap2 = localRole2FashionDressInfo.getFashion_dress_map();
/* 157 */     Set localSet = localRole2FashionDressInfo.getActivate_property_set();
/*     */     
/* 159 */     TransferOccupationFashionDress localTransferOccupationFashionDress = Pod.newTransferOccupationFashionDress();
/* 160 */     localTransferOccupationFashionDress.setCurrent_fashion_dress_cfg_id(localRole2FashionDressInfo.getCurrent_fashion_dress_cfg_id());
/* 161 */     localTransferOccupationFashionDress.getActivate_property_set().addAll(localSet);
/* 162 */     for (Iterator localIterator = localMap2.entrySet().iterator(); localIterator.hasNext();) { localObject = (Map.Entry)localIterator.next();
/* 163 */       localTransferOccupationFashionDress.getFashion_dress_map().put(((Map.Entry)localObject).getKey(), ((FashionDressInfo)((Map.Entry)localObject).getValue()).copy()); }
/*     */     Object localObject;
/* 165 */     localMap1.put(Integer.valueOf(k), localTransferOccupationFashionDress);
/*     */     
/* 167 */     localRole2FashionDressInfo.setCurrent_fashion_dress_cfg_id(-1);
/* 168 */     localSet.clear();
/* 169 */     localMap2.clear();
/*     */     
/* 171 */     for (localIterator = localTransferOccupationFashionDress.getFashion_dress_map().entrySet().iterator(); localIterator.hasNext();) { localObject = (Map.Entry)localIterator.next();
/*     */       
/* 173 */       i1 = ((Integer)((Map.Entry)localObject).getKey()).intValue();
/*     */       
/* 175 */       int i2 = FashionDressManager.getNewOccupationFashionDress(i1, paramInt1, i);
/* 176 */       if (i2 <= 0)
/*     */       {
/* 178 */         GameServer.logger().error(String.format("[fashiondress]FashionDressInterface.activeNewOccupation@not found new occupation fashion dress cfg id|role_id=%d|new_occupation=%d|old_occupation=%d|old_fashion_dress_cfg_id=%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i1) }));
/*     */         
/* 180 */         return false;
/*     */       }
/* 182 */       SFashionDressCfg localSFashionDressCfg1 = SFashionDressCfg.get(i1);
/* 183 */       SFashionDressCfg localSFashionDressCfg2 = SFashionDressCfg.get(i2);
/* 184 */       if (localSFashionDressCfg1.effectTime != localSFashionDressCfg2.effectTime)
/*     */       {
/* 186 */         GameServer.logger().error(String.format("[fashiondress]FashionDressInterface.activeNewOccupation@new fashion dress effect time not match|role_id=%d|new_occupation=%d|old_occupation=%d|old_fashion_dress_cfg_id=%d|new_fashion_dress_cfg_id=%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i1), Integer.valueOf(i2) }));
/*     */         
/* 188 */         return false;
/*     */       }
/* 190 */       FashionDressInfo localFashionDressInfo = (FashionDressInfo)((Map.Entry)localObject).getValue();
/*     */       
/* 192 */       localMap2.put(Integer.valueOf(i2), localFashionDressInfo.copy()); }
/*     */     int i1;
/* 194 */     for (localIterator = localTransferOccupationFashionDress.getActivate_property_set().iterator(); localIterator.hasNext();) { localObject = (Integer)localIterator.next();
/*     */       
/* 196 */       i1 = FashionDressManager.getNewOccupationFashionDress(((Integer)localObject).intValue(), paramInt1, i);
/* 197 */       if (i1 <= 0)
/*     */       {
/* 199 */         GameServer.logger().error(String.format("[fashiondress]FashionDressInterface.activeNewOccupation@not found new occupation fashion dress cfg id|role_id=%d|new_occupation=%d|old_occupation=%d|old_fashion_dress_cfg_id=%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), localObject }));
/*     */         
/* 201 */         return false;
/*     */       }
/* 203 */       localSet.add(Integer.valueOf(i1));
/*     */     }
/* 205 */     int m = localTransferOccupationFashionDress.getCurrent_fashion_dress_cfg_id();
/* 206 */     if (m != -1)
/*     */     {
/* 208 */       int n = FashionDressManager.getNewOccupationFashionDress(m, paramInt1, i);
/* 209 */       if (n > 0)
/*     */       {
/* 211 */         localRole2FashionDressInfo.setCurrent_fashion_dress_cfg_id(n);
/*     */       }
/*     */       else
/*     */       {
/* 215 */         GameServer.logger().error(String.format("[fashiondress]FashionDressInterface.activeNewOccupation@not found new occupation fashion dress cfg id|role_id=%d|new_occupation=%d|old_occupation=%d|old_fashion_dress_cfg_id=%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(m) }));
/*     */         
/* 217 */         return false;
/*     */       }
/*     */     }
/* 220 */     FashionDressManager.triggerModelChangeEvent(new FashionDressModelArg(paramLong, FashionDressChangeReasonEnum.CHANGE_OCCUPATION));
/*     */     
/* 222 */     FashionDressManager.triggerPassiveSkillChangeEvent(new PassiveSkillChangeArg(paramLong, FashionDressChangeReasonEnum.CHANGE_OCCUPATION));
/*     */     
/* 224 */     GameServer.logger().info(String.format("[fashiondress]FashionDressInterface.activeNewOccupation@|role_id=%d|new_occupation=%d|old_occupation=%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
/*     */     
/* 226 */     return true;
/*     */   }
/*     */   
/*     */   public static boolean switchOccupation(long paramLong, int paramInt1, int paramInt2)
/*     */   {
/* 231 */     if (paramInt1 == paramInt2)
/*     */     {
/* 233 */       GameServer.logger().error(String.format("[fashiondress]FashionDressInterface.switchOccupation@new occupation same with old occupation|role_id=%d|new_occupation=%d|old_occupation=%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
/*     */       
/* 235 */       return false;
/*     */     }
/*     */     
/* 238 */     Role2FashionDressInfo localRole2FashionDressInfo = Role2fashiondress.get(Long.valueOf(paramLong));
/* 239 */     if (localRole2FashionDressInfo == null)
/*     */     {
/* 241 */       GameServer.logger().error(String.format("[fashiondress]FashionDressInterface.switchOccupation@role fashion dress info is null|role_id=%d|new_occupation=%d|old_occupation=%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
/*     */       
/* 243 */       return false;
/*     */     }
/*     */     
/* 246 */     int i = RoleInterface.getGender(paramLong);
/* 247 */     int j = paramInt1 * 100 + i;
/* 248 */     int k = paramInt2 * 100 + i;
/* 249 */     Map localMap1 = localRole2FashionDressInfo.getTransfer_occupation_fashion_dress_map();
/* 250 */     if (localMap1.containsKey(Integer.valueOf(paramInt1)))
/*     */     {
/* 252 */       localTransferOccupationFashionDress1 = (TransferOccupationFashionDress)localMap1.remove(Integer.valueOf(paramInt1));
/* 253 */       localMap1.put(Integer.valueOf(j), localTransferOccupationFashionDress1);
/*     */     }
/*     */     
/* 256 */     TransferOccupationFashionDress localTransferOccupationFashionDress1 = (TransferOccupationFashionDress)localMap1.remove(Integer.valueOf(j));
/* 257 */     if (localTransferOccupationFashionDress1 == null)
/*     */     {
/* 259 */       GameServer.logger().error(String.format("[fashiondress]FashionDressInterface.switchOccupation@not contains new occupation|role_id=%d|new_occupation=%d|old_occupation=%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
/*     */       
/* 261 */       return activeNewOccupation(paramLong, paramInt1, paramInt2);
/*     */     }
/* 263 */     Map localMap2 = localRole2FashionDressInfo.getFashion_dress_map();
/* 264 */     Set localSet = localRole2FashionDressInfo.getActivate_property_set();
/*     */     
/* 266 */     TransferOccupationFashionDress localTransferOccupationFashionDress2 = Pod.newTransferOccupationFashionDress();
/* 267 */     localTransferOccupationFashionDress2.setCurrent_fashion_dress_cfg_id(localRole2FashionDressInfo.getCurrent_fashion_dress_cfg_id());
/* 268 */     localTransferOccupationFashionDress2.getActivate_property_set().addAll(localSet);
/* 269 */     for (Iterator localIterator = localMap2.entrySet().iterator(); localIterator.hasNext();) { localEntry = (Map.Entry)localIterator.next();
/* 270 */       localTransferOccupationFashionDress2.getFashion_dress_map().put(localEntry.getKey(), ((FashionDressInfo)localEntry.getValue()).copy()); }
/*     */     Map.Entry localEntry;
/* 272 */     localMap1.put(Integer.valueOf(k), localTransferOccupationFashionDress2);
/*     */     
/* 274 */     localMap2.clear();
/* 275 */     localSet.clear();
/* 276 */     localRole2FashionDressInfo.setCurrent_fashion_dress_cfg_id(localTransferOccupationFashionDress1.getCurrent_fashion_dress_cfg_id());
/*     */     
/* 278 */     localSet.addAll(localTransferOccupationFashionDress1.getActivate_property_set());
/* 279 */     for (localIterator = localTransferOccupationFashionDress1.getFashion_dress_map().entrySet().iterator(); localIterator.hasNext();) { localEntry = (Map.Entry)localIterator.next();
/* 280 */       localMap2.put(localEntry.getKey(), ((FashionDressInfo)localEntry.getValue()).copy());
/*     */     }
/* 282 */     FashionDressManager.triggerModelChangeEvent(new FashionDressModelArg(paramLong, FashionDressChangeReasonEnum.CHANGE_OCCUPATION));
/*     */     
/* 284 */     FashionDressManager.triggerPassiveSkillChangeEvent(new PassiveSkillChangeArg(paramLong, FashionDressChangeReasonEnum.CHANGE_OCCUPATION));
/*     */     
/* 286 */     GameServer.logger().info(String.format("[fashiondress]FashionDressInterface.switchOccupation@|role_id=%d|new_occupation=%d|old_occupation=%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
/*     */     
/* 288 */     return true;
/*     */   }
/*     */   
/*     */   public static boolean switchGender(long paramLong, int paramInt1, int paramInt2)
/*     */   {
/* 293 */     int i = RoleInterface.getOccupationId(paramLong);
/* 294 */     int j = i * 100 + paramInt1;
/* 295 */     int k = i * 100 + paramInt2;
/*     */     
/* 297 */     Role2FashionDressInfo localRole2FashionDressInfo = Role2fashiondress.get(Long.valueOf(paramLong));
/* 298 */     if (localRole2FashionDressInfo == null)
/*     */     {
/* 300 */       localRole2FashionDressInfo = Pod.newRole2FashionDressInfo();
/* 301 */       localRole2FashionDressInfo.setCurrent_fashion_dress_cfg_id(-1);
/* 302 */       Role2fashiondress.add(Long.valueOf(paramLong), localRole2FashionDressInfo);
/*     */     }
/* 304 */     Map localMap = localRole2FashionDressInfo.getTransfer_occupation_fashion_dress_map();
/*     */     
/*     */ 
/* 307 */     for (Object localObject1 = mzm.gsp.multioccupation.main.MultiOccupInterface.getOccupList(paramLong, false).iterator(); ((Iterator)localObject1).hasNext();) { localObject2 = (Integer)((Iterator)localObject1).next();
/*     */       
/* 309 */       if (localMap.containsKey(Integer.valueOf(((Integer)localObject2).intValue())))
/*     */       {
/* 311 */         localObject3 = (TransferOccupationFashionDress)localMap.remove(Integer.valueOf(((Integer)localObject2).intValue()));
/* 312 */         int m = ((Integer)localObject2).intValue() * 100 + paramInt2;
/* 313 */         localMap.put(Integer.valueOf(m), localObject3); } }
/*     */     Object localObject2;
/*     */     Object localObject3;
/*     */     Iterator localIterator2;
/* 317 */     Map.Entry localEntry; if (!localMap.containsKey(Integer.valueOf(j)))
/*     */     {
/* 319 */       GameServer.logger().info("[fashiondress]FashionDressInterface.switchGender@create fashiondress");
/*     */       
/* 321 */       localObject1 = localRole2FashionDressInfo.getFashion_dress_map();
/* 322 */       localObject2 = localRole2FashionDressInfo.getActivate_property_set();
/*     */       
/* 324 */       localObject3 = Pod.newTransferOccupationFashionDress();
/* 325 */       ((TransferOccupationFashionDress)localObject3).setCurrent_fashion_dress_cfg_id(localRole2FashionDressInfo.getCurrent_fashion_dress_cfg_id());
/* 326 */       ((TransferOccupationFashionDress)localObject3).getActivate_property_set().addAll((Collection)localObject2);
/* 327 */       for (Iterator localIterator1 = ((Map)localObject1).entrySet().iterator(); localIterator1.hasNext();) { localObject4 = (Map.Entry)localIterator1.next();
/* 328 */         ((TransferOccupationFashionDress)localObject3).getFashion_dress_map().put(((Map.Entry)localObject4).getKey(), ((FashionDressInfo)((Map.Entry)localObject4).getValue()).copy()); }
/*     */       Object localObject4;
/* 330 */       localMap.put(Integer.valueOf(k), localObject3);
/*     */       
/* 332 */       localRole2FashionDressInfo.setCurrent_fashion_dress_cfg_id(-1);
/* 333 */       ((Set)localObject2).clear();
/* 334 */       ((Map)localObject1).clear();
/*     */       
/* 336 */       for (localIterator1 = ((TransferOccupationFashionDress)localObject3).getFashion_dress_map().entrySet().iterator(); localIterator1.hasNext();) { localObject4 = (Map.Entry)localIterator1.next();
/*     */         
/* 338 */         i2 = ((Integer)((Map.Entry)localObject4).getKey()).intValue();
/* 339 */         int i3 = FashionDressManager.getNewOccupationFashionDress(i2, i, paramInt1);
/*     */         
/* 341 */         if (i3 <= 0)
/*     */         {
/* 343 */           GameServer.logger().error(String.format("[fashiondress]FashionDressInterface.switchGender@not found occupation fashion dress cfg id|role_id=%d|occupation=%d|gender=%d|old_fashion_dress_cfg_id=%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(i), Integer.valueOf(paramInt1), Integer.valueOf(i2) }));
/*     */           
/* 345 */           return false;
/*     */         }
/* 347 */         SFashionDressCfg localSFashionDressCfg1 = SFashionDressCfg.get(i2);
/* 348 */         SFashionDressCfg localSFashionDressCfg2 = SFashionDressCfg.get(i3);
/* 349 */         if (localSFashionDressCfg1.effectTime != localSFashionDressCfg2.effectTime)
/*     */         {
/* 351 */           GameServer.logger().error(String.format("[fashiondress]FashionDressInterface.switchGender@new fashion dress effect time not match|role_id=%d|occupation=%d|gender=%d|old_fashion_dress_cfg_id=%d|new_fashion_dress_cfg_id=%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(i), Integer.valueOf(paramInt1), Integer.valueOf(i2), Integer.valueOf(i3) }));
/*     */           
/* 353 */           return false;
/*     */         }
/* 355 */         FashionDressInfo localFashionDressInfo = (FashionDressInfo)((Map.Entry)localObject4).getValue();
/*     */         
/* 357 */         ((Map)localObject1).put(Integer.valueOf(i3), localFashionDressInfo.copy());
/*     */       }
/*     */       int i2;
/* 360 */       for (localIterator1 = ((TransferOccupationFashionDress)localObject3).getActivate_property_set().iterator(); localIterator1.hasNext();) { localObject4 = (Integer)localIterator1.next();
/*     */         
/* 362 */         i2 = FashionDressManager.getNewOccupationFashionDress(((Integer)localObject4).intValue(), i, paramInt1);
/* 363 */         if (i2 <= 0)
/*     */         {
/* 365 */           GameServer.logger().error(String.format("[fashiondress]FashionDressInterface.switchGender@not found occupation fashion dress cfg id|role_id=%d|occupation=%d|gender=%d|old_fashion_dress_cfg_id=%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(i), Integer.valueOf(paramInt1), localObject4 }));
/*     */           
/* 367 */           return false;
/*     */         }
/* 369 */         ((Set)localObject2).add(Integer.valueOf(i2));
/*     */       }
/*     */       
/* 372 */       int n = ((TransferOccupationFashionDress)localObject3).getCurrent_fashion_dress_cfg_id();
/* 373 */       if (n != -1)
/*     */       {
/* 375 */         int i1 = FashionDressManager.getNewOccupationFashionDress(n, i, paramInt1);
/* 376 */         if (i1 > 0)
/*     */         {
/* 378 */           localRole2FashionDressInfo.setCurrent_fashion_dress_cfg_id(i1);
/*     */         }
/*     */         else
/*     */         {
/* 382 */           GameServer.logger().error(String.format("[fashiondress]FashionDressInterface.switchGender@not found occupation fashion dress cfg id|role_id=%d|occupation=%d|gender=%d|old_fashion_dress_cfg_id=%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(i), Integer.valueOf(paramInt1), Integer.valueOf(n) }));
/*     */           
/* 384 */           return false;
/*     */         }
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/* 390 */       GameServer.logger().info("[fashiondress]FashionDressInterface.switchGender@exist fashiondress");
/*     */       
/* 392 */       localObject1 = (TransferOccupationFashionDress)localMap.remove(Integer.valueOf(j));
/* 393 */       if (localObject1 == null)
/*     */       {
/* 395 */         GameServer.logger().error(String.format("[fashiondress]FashionDressInterface.switchGender@not contains occupation|role_id=%d|occupation=%d|gender=%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(i), Integer.valueOf(paramInt1) }));
/*     */         
/* 397 */         return false;
/*     */       }
/* 399 */       localObject2 = localRole2FashionDressInfo.getFashion_dress_map();
/* 400 */       localObject3 = localRole2FashionDressInfo.getActivate_property_set();
/*     */       
/* 402 */       TransferOccupationFashionDress localTransferOccupationFashionDress = Pod.newTransferOccupationFashionDress();
/* 403 */       localTransferOccupationFashionDress.setCurrent_fashion_dress_cfg_id(localRole2FashionDressInfo.getCurrent_fashion_dress_cfg_id());
/* 404 */       localTransferOccupationFashionDress.getActivate_property_set().addAll((Collection)localObject3);
/* 405 */       for (localIterator2 = ((Map)localObject2).entrySet().iterator(); localIterator2.hasNext();) { localEntry = (Map.Entry)localIterator2.next();
/* 406 */         localTransferOccupationFashionDress.getFashion_dress_map().put(localEntry.getKey(), ((FashionDressInfo)localEntry.getValue()).copy());
/*     */       }
/* 408 */       localMap.put(Integer.valueOf(k), localTransferOccupationFashionDress);
/*     */       
/* 410 */       ((Map)localObject2).clear();
/* 411 */       ((Set)localObject3).clear();
/* 412 */       localRole2FashionDressInfo.setCurrent_fashion_dress_cfg_id(((TransferOccupationFashionDress)localObject1).getCurrent_fashion_dress_cfg_id());
/*     */       
/* 414 */       ((Set)localObject3).addAll(((TransferOccupationFashionDress)localObject1).getActivate_property_set());
/* 415 */       for (localIterator2 = ((TransferOccupationFashionDress)localObject1).getFashion_dress_map().entrySet().iterator(); localIterator2.hasNext();) { localEntry = (Map.Entry)localIterator2.next();
/* 416 */         ((Map)localObject2).put(localEntry.getKey(), ((FashionDressInfo)localEntry.getValue()).copy());
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 421 */     FashionDressManager.triggerModelChangeEvent(new FashionDressModelArg(paramLong, FashionDressChangeReasonEnum.CHANGE_OCCUPATION));
/* 422 */     FashionDressManager.triggerPassiveSkillChangeEvent(new PassiveSkillChangeArg(paramLong, FashionDressChangeReasonEnum.CHANGE_OCCUPATION));
/*     */     
/* 424 */     GameServer.logger().info(String.format("[fashiondress]FashionDressInterface.switchGender@|role_id=%d|occupation=%d|gender=%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(i), Integer.valueOf(paramInt1) }));
/*     */     
/* 426 */     return true;
/*     */   }
/*     */   
/*     */   public static int getRoleOccupationFashionDressCfgId(long paramLong, int paramInt, boolean paramBoolean)
/*     */   {
/* 431 */     int i = RoleInterface.getOccupationId(paramLong);
/* 432 */     Role2FashionDressInfo localRole2FashionDressInfo = null;
/* 433 */     if (paramBoolean) {
/* 434 */       localRole2FashionDressInfo = Role2fashiondress.get(Long.valueOf(paramLong));
/*     */     } else {
/* 436 */       localRole2FashionDressInfo = Role2fashiondress.select(Long.valueOf(paramLong));
/*     */     }
/* 438 */     if (localRole2FashionDressInfo == null) {
/* 439 */       return -1;
/*     */     }
/* 441 */     if (i == paramInt) {
/* 442 */       return localRole2FashionDressInfo.getCurrent_fashion_dress_cfg_id();
/*     */     }
/* 444 */     Map localMap = localRole2FashionDressInfo.getTransfer_occupation_fashion_dress_map();
/* 445 */     TransferOccupationFashionDress localTransferOccupationFashionDress = (TransferOccupationFashionDress)localMap.get(Integer.valueOf(paramInt));
/* 446 */     if (localTransferOccupationFashionDress == null) {
/* 447 */       int j = RoleInterface.getGender(paramLong);
/* 448 */       localTransferOccupationFashionDress = (TransferOccupationFashionDress)localMap.get(Integer.valueOf(paramInt * 100 + j));
/*     */     }
/* 450 */     if (localTransferOccupationFashionDress == null) {
/* 451 */       return -1;
/*     */     }
/* 453 */     return localTransferOccupationFashionDress.getCurrent_fashion_dress_cfg_id();
/*     */   }
/*     */   
/*     */   public static Set<Integer> getOwnFashionDressType(long paramLong, boolean paramBoolean)
/*     */   {
/* 458 */     return FashionDressManager.getOwnFashionDressTypeSet(paramLong, paramBoolean);
/*     */   }
/*     */   
/*     */   public static int removeFashionDress(long paramLong, int paramInt)
/*     */   {
/* 463 */     return FashionDressManager.removeFashionDress(paramLong, paramInt);
/*     */   }
/*     */   
/*     */   public static Set<Integer> calculateRoleEntireThemeFashionDressCfgids(Set<Integer> paramSet)
/*     */   {
/* 468 */     HashSet localHashSet = new HashSet();
/* 469 */     if (paramSet == null) {
/* 470 */       return localHashSet;
/*     */     }
/* 472 */     for (SThemeFashionDressCfg localSThemeFashionDressCfg : SThemeFashionDressCfg.getAll().values()) {
/* 473 */       if (paramSet.containsAll(localSThemeFashionDressCfg.unlock_theme_fashion_dress_type_list)) {
/* 474 */         localHashSet.add(Integer.valueOf(localSThemeFashionDressCfg.id));
/*     */       }
/*     */     }
/* 477 */     return localHashSet;
/*     */   }
/*     */   
/*     */   public static int calculateRoleThemeFashionDressUnlockNum(int paramInt, Set<Integer> paramSet)
/*     */   {
/* 482 */     if (paramSet == null) {
/* 483 */       return 0;
/*     */     }
/* 485 */     SThemeFashionDressCfg localSThemeFashionDressCfg = SThemeFashionDressCfg.get(paramInt);
/* 486 */     if (localSThemeFashionDressCfg == null) {
/* 487 */       return -1;
/*     */     }
/* 489 */     int i = 0;
/* 490 */     for (Iterator localIterator = localSThemeFashionDressCfg.unlock_theme_fashion_dress_type_list.iterator(); localIterator.hasNext();)
/*     */     {
/* 492 */       int j = ((Integer)localIterator.next()).intValue();
/* 493 */       if (paramSet.contains(Integer.valueOf(j))) {
/* 494 */         i++;
/*     */       }
/*     */     }
/* 497 */     return i;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fashiondress\main\FashionDressInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
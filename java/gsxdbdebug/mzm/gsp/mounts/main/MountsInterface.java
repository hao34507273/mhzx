/*     */ package mzm.gsp.mounts.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.TreeMap;
/*     */ import mzm.gsp.mounts.SUnRideMountsSuccess;
/*     */ import mzm.gsp.mounts.confbean.MountsRankInfoBean;
/*     */ import mzm.gsp.mounts.confbean.MountsStarLifeLevelBean;
/*     */ import mzm.gsp.mounts.confbean.MountsStarLifePropertyBean;
/*     */ import mzm.gsp.mounts.confbean.SMountsCfg;
/*     */ import mzm.gsp.mounts.confbean.SMountsRankCfg;
/*     */ import mzm.gsp.mounts.confbean.SMountsStarLifeCfg;
/*     */ import mzm.gsp.mounts.event.RideMountsModelChangeArg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import xbean.AppearenceMountsInfo;
/*     */ import xbean.BattleMountsInfo;
/*     */ import xbean.MultiRoleMounts;
/*     */ import xbean.PassiveSkillInfo;
/*     */ import xbean.Role2MountsInfo;
/*     */ import xtable.Role2mounts;
/*     */ import xtable.Team2multirolemounts;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MountsInterface
/*     */ {
/*     */   public static void unRideMounts(long roleId)
/*     */   {
/*  34 */     Role2MountsInfo xRole2MountsInfo = Role2mounts.get(Long.valueOf(roleId));
/*  35 */     if (xRole2MountsInfo == null)
/*     */     {
/*  37 */       return;
/*     */     }
/*     */     
/*  40 */     if (xRole2MountsInfo.getCurrent_ride_mounts_id() == 0L)
/*     */     {
/*  42 */       return;
/*     */     }
/*     */     
/*  45 */     long rideMountsId = xRole2MountsInfo.getCurrent_ride_mounts_id();
/*  46 */     xRole2MountsInfo.setCurrent_ride_mounts_id(0L);
/*  47 */     xbean.MountsInfo xMountsInfo = (xbean.MountsInfo)xRole2MountsInfo.getMounts_info_map().get(Long.valueOf(rideMountsId));
/*  48 */     if (xMountsInfo == null)
/*     */     {
/*  50 */       return;
/*     */     }
/*     */     
/*  53 */     SUnRideMountsSuccess sUnRideMountsSuccess = new SUnRideMountsSuccess();
/*  54 */     sUnRideMountsSuccess.mounts_id = rideMountsId;
/*  55 */     OnlineManager.getInstance().send(roleId, sUnRideMountsSuccess);
/*     */     
/*  57 */     MountsManager.triggerRideMountsModelChangeEvent(new RideMountsModelChangeArg(roleId, 0, -1, -1, 1));
/*     */     
/*     */ 
/*  60 */     MultiRoleMountsManager.onRoleUnrideMounts(roleId, 0);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   public static mzm.gsp.mounts.MountsInfo getMountsInfoByMountsId(long roleId, long mountsId, boolean isRemainRoleLock)
/*     */   {
/*  78 */     Role2MountsInfo xRole2MountsInfo = null;
/*  79 */     if (isRemainRoleLock)
/*     */     {
/*  81 */       xRole2MountsInfo = Role2mounts.get(Long.valueOf(roleId));
/*     */     }
/*     */     else
/*     */     {
/*  85 */       xRole2MountsInfo = Role2mounts.select(Long.valueOf(roleId));
/*     */     }
/*     */     
/*  88 */     if (xRole2MountsInfo == null)
/*     */     {
/*  90 */       return null;
/*     */     }
/*     */     
/*  93 */     xbean.MountsInfo xMountsInfo = (xbean.MountsInfo)xRole2MountsInfo.getMounts_info_map().get(Long.valueOf(mountsId));
/*     */     
/*  95 */     if (xMountsInfo == null)
/*     */     {
/*  97 */       return null;
/*     */     }
/*     */     
/* 100 */     mzm.gsp.mounts.MountsInfo sMountsInfo = new mzm.gsp.mounts.MountsInfo();
/* 101 */     MountsManager.fillMountsInfoProtocol(xMountsInfo, sMountsInfo);
/* 102 */     return sMountsInfo;
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
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Map<Integer, Integer> getCurrentMountsRoleProperty(long roleId, boolean isRemainRoleLock)
/*     */   {
/* 120 */     Map<Integer, Integer> propertyValueMap = new HashMap();
/* 121 */     Role2MountsInfo xRole2MountsInfo = null;
/* 122 */     if (isRemainRoleLock)
/*     */     {
/* 124 */       xRole2MountsInfo = Role2mounts.get(Long.valueOf(roleId));
/*     */     }
/*     */     else
/*     */     {
/* 128 */       xRole2MountsInfo = Role2mounts.select(Long.valueOf(roleId));
/*     */     }
/*     */     
/* 131 */     if (xRole2MountsInfo == null)
/*     */     {
/* 133 */       return propertyValueMap;
/*     */     }
/*     */     
/* 136 */     Map<Long, xbean.MountsInfo> xMountsInfoMap = xRole2MountsInfo.getMounts_info_map();
/*     */     
/* 138 */     for (BattleMountsInfo xBattleMountsInfo : xRole2MountsInfo.getBattle_mounts_info_map().values())
/*     */     {
/* 140 */       xbean.MountsInfo xMountsInfo = (xbean.MountsInfo)xMountsInfoMap.get(Long.valueOf(xBattleMountsInfo.getMounts_id()));
/* 141 */       if (xMountsInfo != null)
/*     */       {
/*     */ 
/*     */ 
/* 145 */         int mountsCfgId = xMountsInfo.getMounts_cfg_id();
/*     */         
/* 147 */         SMountsRankCfg sMountsRankCfg = SMountsRankCfg.get(mountsCfgId);
/* 148 */         if (sMountsRankCfg != null)
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 154 */           MountsRankInfoBean mountsRankInfoBean = (MountsRankInfoBean)sMountsRankCfg.mountsRankMapInfo.get(Integer.valueOf(xMountsInfo.getMounts_rank()));
/* 155 */           if (mountsRankInfoBean != null)
/*     */           {
/*     */ 
/*     */ 
/*     */ 
/* 160 */             fillPropertyMap(propertyValueMap, mountsRankInfoBean.propertyMap);
/*     */             
/*     */ 
/* 163 */             SMountsStarLifeCfg sMountsStarLifeCfg = SMountsStarLifeCfg.get(mountsCfgId);
/* 164 */             if (sMountsStarLifeCfg != null)
/*     */             {
/*     */ 
/*     */ 
/*     */ 
/* 169 */               int currentStarLevel = xMountsInfo.getCurrent_mounts_star_level();
/* 170 */               currentMaxStarNum = xMountsInfo.getCurrent_max_star_num();
/*     */               
/* 172 */               MountsStarLifeLevelBean currentMountsStarLifeLevelBean = (MountsStarLifeLevelBean)sMountsStarLifeCfg.starLifeLevelMap.get(Integer.valueOf(currentStarLevel));
/* 173 */               if (currentMountsStarLifeLevelBean != null)
/*     */               {
/*     */ 
/*     */ 
/* 177 */                 for (Map.Entry<Integer, MountsStarLifePropertyBean> entry : currentMountsStarLifeLevelBean.starNumMap.entrySet())
/*     */                 {
/* 179 */                   if (((Integer)entry.getKey()).intValue() > currentMaxStarNum) {
/*     */                     break;
/*     */                   }
/*     */                   
/* 183 */                   fillPropertyMap(propertyValueMap, ((MountsStarLifePropertyBean)entry.getValue()).propertyMap);
/*     */                 }
/*     */                 
/*     */ 
/* 187 */                 MountsStarLifeLevelBean lastMountsStarLifeLevelBean = (MountsStarLifeLevelBean)sMountsStarLifeCfg.starLifeLevelMap.get(Integer.valueOf(currentStarLevel - 1));
/* 188 */                 if (lastMountsStarLifeLevelBean != null)
/*     */                 {
/*     */ 
/*     */ 
/* 192 */                   for (Map.Entry<Integer, MountsStarLifePropertyBean> entry : lastMountsStarLifeLevelBean.starNumMap.entrySet())
/*     */                   {
/* 194 */                     if (((Integer)entry.getKey()).intValue() > currentMaxStarNum)
/*     */                     {
/*     */ 
/*     */ 
/* 198 */                       fillPropertyMap(propertyValueMap, ((MountsStarLifePropertyBean)entry.getValue()).propertyMap); } } }
/*     */               }
/*     */             }
/*     */           } } } }
/*     */     int currentMaxStarNum;
/* 203 */     for (Map.Entry<Long, AppearenceMountsInfo> entry : xRole2MountsInfo.getAppearence_mounts_info_map().entrySet())
/*     */     {
/* 205 */       long mountsId = ((Long)entry.getKey()).longValue();
/* 206 */       xbean.MountsInfo xMountsInfo = (xbean.MountsInfo)xRole2MountsInfo.getMounts_info_map().get(Long.valueOf(mountsId));
/* 207 */       if (xMountsInfo != null)
/*     */       {
/*     */ 
/*     */ 
/* 211 */         SMountsRankCfg sMountsRankCfg = SMountsRankCfg.get(xMountsInfo.getMounts_cfg_id());
/* 212 */         if (sMountsRankCfg != null)
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/* 217 */           MountsRankInfoBean mountsRankInfoBean = (MountsRankInfoBean)sMountsRankCfg.mountsRankMapInfo.get(Integer.valueOf(xMountsInfo.getMounts_rank()));
/* 218 */           if (mountsRankInfoBean != null)
/*     */           {
/*     */ 
/*     */ 
/* 222 */             fillPropertyMap(propertyValueMap, mountsRankInfoBean.propertyMap); }
/*     */         } } }
/* 224 */     return propertyValueMap;
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
/*     */   private static void fillPropertyMap(Map<Integer, Integer> propertyMap, Map<Integer, Integer> addProperty)
/*     */   {
/* 237 */     for (Map.Entry<Integer, Integer> entry : addProperty.entrySet())
/*     */     {
/* 239 */       int propertyKey = ((Integer)entry.getKey()).intValue();
/* 240 */       int propertyValue = ((Integer)entry.getValue()).intValue();
/* 241 */       Integer oldValue = (Integer)propertyMap.get(Integer.valueOf(propertyKey));
/* 242 */       if (oldValue != null)
/*     */       {
/* 244 */         propertyMap.put(Integer.valueOf(propertyKey), Integer.valueOf(oldValue.intValue() + propertyValue));
/*     */       }
/*     */       else
/*     */       {
/* 248 */         propertyMap.put(Integer.valueOf(propertyKey), Integer.valueOf(propertyValue));
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static List<Integer> getMountsEffectPassiveSkillOnPet(long roleId, long petId, boolean isRemainRolelock)
/*     */   {
/* 268 */     Role2MountsInfo xRole2MountsInfo = null;
/* 269 */     if (isRemainRolelock)
/*     */     {
/* 271 */       xRole2MountsInfo = Role2mounts.get(Long.valueOf(roleId));
/*     */     }
/*     */     else
/*     */     {
/* 275 */       xRole2MountsInfo = Role2mounts.select(Long.valueOf(roleId));
/*     */     }
/*     */     
/* 278 */     if (xRole2MountsInfo == null)
/*     */     {
/* 280 */       return null;
/*     */     }
/*     */     
/* 283 */     Map<Integer, BattleMountsInfo> xBattleMountsInfoMap = xRole2MountsInfo.getBattle_mounts_info_map();
/* 284 */     long mountsId = 0L;
/* 285 */     for (BattleMountsInfo xBattleMountsInfo : xBattleMountsInfoMap.values())
/*     */     {
/* 287 */       if (xBattleMountsInfo.getProtect_pet_id_list().contains(Long.valueOf(petId)))
/*     */       {
/* 289 */         mountsId = xBattleMountsInfo.getMounts_id();
/*     */       }
/*     */     }
/*     */     
/* 293 */     if (mountsId == 0L)
/*     */     {
/* 295 */       return null;
/*     */     }
/*     */     
/* 298 */     xbean.MountsInfo xMountsInfo = (xbean.MountsInfo)xRole2MountsInfo.getMounts_info_map().get(Long.valueOf(mountsId));
/* 299 */     if (xMountsInfo == null)
/*     */     {
/* 301 */       return null;
/*     */     }
/*     */     
/* 304 */     List<Integer> passiveSkillList = new ArrayList();
/* 305 */     for (PassiveSkillInfo xPassiveSkillInfo : xMountsInfo.getMounts_passive_skill_list())
/*     */     {
/* 307 */       passiveSkillList.add(Integer.valueOf(xPassiveSkillInfo.getPassive_skill_cfg_id()));
/*     */     }
/* 309 */     return passiveSkillList;
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
/*     */ 
/*     */   public static Map<Long, List<Integer>> getProtectPetMap(long roleId, boolean isRemainRoleLock)
/*     */   {
/* 325 */     Map<Long, List<Integer>> protectPetMap = new HashMap();
/* 326 */     Role2MountsInfo xRole2MountsInfo = null;
/* 327 */     if (isRemainRoleLock)
/*     */     {
/* 329 */       xRole2MountsInfo = Role2mounts.get(Long.valueOf(roleId));
/*     */     }
/*     */     else
/*     */     {
/* 333 */       xRole2MountsInfo = Role2mounts.select(Long.valueOf(roleId));
/*     */     }
/*     */     
/* 336 */     if (xRole2MountsInfo == null)
/*     */     {
/* 338 */       return protectPetMap;
/*     */     }
/*     */     
/* 341 */     Map<Long, xbean.MountsInfo> xMountsInfoMap = xRole2MountsInfo.getMounts_info_map();
/* 342 */     for (BattleMountsInfo xBattleMountsInfo : xRole2MountsInfo.getBattle_mounts_info_map().values())
/*     */     {
/* 344 */       mountsId = xBattleMountsInfo.getMounts_id();
/* 345 */       for (i$ = xBattleMountsInfo.getProtect_pet_id_list().iterator(); i$.hasNext();) { long petId = ((Long)i$.next()).longValue();
/*     */         
/* 347 */         xbean.MountsInfo xMountsInfo = (xbean.MountsInfo)xMountsInfoMap.get(Long.valueOf(mountsId));
/* 348 */         if (xMountsInfo != null)
/*     */         {
/*     */ 
/*     */ 
/* 352 */           List<Integer> passiveSkillList = new ArrayList();
/* 353 */           for (PassiveSkillInfo xPassiveSkillInfo : xMountsInfo.getMounts_passive_skill_list())
/*     */           {
/* 355 */             passiveSkillList.add(Integer.valueOf(xPassiveSkillInfo.getPassive_skill_cfg_id()));
/*     */           }
/* 357 */           protectPetMap.put(Long.valueOf(petId), passiveSkillList);
/*     */         } } }
/*     */     long mountsId;
/*     */     Iterator i$;
/* 361 */     return protectPetMap;
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
/*     */ 
/*     */   public static ChiefBattleMountsObj getChiefBattlMounts(long roleId, boolean isRemainRoleLock)
/*     */   {
/* 377 */     Role2MountsInfo xRole2MountsInfo = null;
/* 378 */     if (isRemainRoleLock)
/*     */     {
/* 380 */       xRole2MountsInfo = Role2mounts.get(Long.valueOf(roleId));
/*     */     }
/*     */     else
/*     */     {
/* 384 */       xRole2MountsInfo = Role2mounts.select(Long.valueOf(roleId));
/*     */     }
/* 386 */     if (xRole2MountsInfo == null)
/*     */     {
/* 388 */       return null;
/*     */     }
/*     */     
/* 391 */     int chiefMountsCellId = xRole2MountsInfo.getCurrent_chief_battle_mounts();
/* 392 */     BattleMountsInfo xBattleMountsInfo = (BattleMountsInfo)xRole2MountsInfo.getBattle_mounts_info_map().get(Integer.valueOf(chiefMountsCellId));
/* 393 */     if (xBattleMountsInfo == null)
/*     */     {
/* 395 */       return null;
/*     */     }
/* 397 */     long mountsId = xBattleMountsInfo.getMounts_id();
/* 398 */     xbean.MountsInfo xMountsInfo = (xbean.MountsInfo)xRole2MountsInfo.getMounts_info_map().get(Long.valueOf(mountsId));
/* 399 */     if (xMountsInfo == null)
/*     */     {
/* 401 */       return null;
/*     */     }
/* 403 */     int mountsCfgId = xMountsInfo.getMounts_cfg_id();
/* 404 */     int mountsRank = xMountsInfo.getMounts_rank();
/*     */     
/* 406 */     SMountsRankCfg sMountsRankCfg = SMountsRankCfg.get(mountsCfgId);
/* 407 */     if (sMountsRankCfg == null)
/*     */     {
/* 409 */       return null;
/*     */     }
/*     */     
/* 412 */     MountsRankInfoBean mountsRankInfoBean = (MountsRankInfoBean)sMountsRankCfg.mountsRankMapInfo.get(Integer.valueOf(mountsRank));
/* 413 */     if ((mountsRankInfoBean == null) || (mountsRankInfoBean.activeSkillCfgId == 0))
/*     */     {
/* 415 */       return null;
/*     */     }
/*     */     
/* 418 */     Map<Integer, Integer> activeSkillMap = new HashMap();
/* 419 */     activeSkillMap.put(Integer.valueOf(mountsRankInfoBean.activeSkillCfgId), Integer.valueOf(mountsRankInfoBean.activeSkillLevel));
/*     */     
/* 421 */     ChiefBattleMountsObj chiefBattleMountsObj = new ChiefBattleMountsObj(mountsId, mountsRank, mountsCfgId, activeSkillMap);
/*     */     
/* 423 */     return chiefBattleMountsObj;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static class ChiefBattleMountsObj
/*     */   {
/*     */     private final long mountsId;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     private final int mountsCfgId;
/*     */     
/*     */ 
/*     */ 
/*     */     private final int mountsRank;
/*     */     
/*     */ 
/*     */ 
/* 445 */     private Map<Integer, Integer> mountsActiveSkillMap = new HashMap();
/*     */     
/*     */ 
/*     */     public ChiefBattleMountsObj(long mountsId, int mountsRank, int mountsCfgId, Map<Integer, Integer> mountsActiveSkillMap)
/*     */     {
/* 450 */       this.mountsId = mountsId;
/* 451 */       this.mountsRank = mountsRank;
/* 452 */       this.mountsCfgId = mountsCfgId;
/* 453 */       this.mountsActiveSkillMap.putAll(mountsActiveSkillMap);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     public long getMountsId()
/*     */     {
/* 461 */       return this.mountsId;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     public int getMountsRank()
/*     */     {
/* 469 */       return this.mountsRank;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     public int getMountsCfgId()
/*     */     {
/* 477 */       return this.mountsCfgId;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getMountsActiveSkillMap()
/*     */     {
/* 485 */       return this.mountsActiveSkillMap;
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
/*     */ 
/*     */ 
/*     */ 
/*     */   public static RideMountsObj getRideMountsObj(long roleId, boolean isRemainRoleLock)
/*     */   {
/* 502 */     Role2MountsInfo xRole2MountsInfo = null;
/* 503 */     if (isRemainRoleLock)
/*     */     {
/* 505 */       xRole2MountsInfo = Role2mounts.get(Long.valueOf(roleId));
/*     */     }
/*     */     else
/*     */     {
/* 509 */       xRole2MountsInfo = Role2mounts.select(Long.valueOf(roleId));
/*     */     }
/*     */     
/* 512 */     if ((xRole2MountsInfo == null) || (xRole2MountsInfo.getCurrent_ride_mounts_id() == 0L))
/*     */     {
/* 514 */       return new RideMountsObj(0, -1, -1, -1, 0, 0L);
/*     */     }
/* 516 */     long currentMountsId = xRole2MountsInfo.getCurrent_ride_mounts_id();
/* 517 */     xbean.MountsInfo xMountsInfo = (xbean.MountsInfo)xRole2MountsInfo.getMounts_info_map().get(Long.valueOf(currentMountsId));
/* 518 */     if (xMountsInfo == null)
/*     */     {
/* 520 */       return new RideMountsObj(0, -1, -1, -1, 0, 0L);
/*     */     }
/*     */     
/* 523 */     if (xMountsInfo.getCurrent_ornament_rank() == 0)
/*     */     {
/* 525 */       xMountsInfo.setCurrent_ornament_rank(xMountsInfo.getMounts_rank());
/*     */     }
/*     */     
/* 528 */     int mountsSpeed = getMountsSpeed(xMountsInfo.getMounts_cfg_id(), xMountsInfo.getMounts_rank(), xRole2MountsInfo);
/* 529 */     return new RideMountsObj(xMountsInfo.getMounts_cfg_id(), xMountsInfo.getCurrent_ornament_rank(), xMountsInfo.getMounts_rank(), xMountsInfo.getMounts_dye_color_id(), mountsSpeed, currentMountsId);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static int getMountsSpeed(int mountsCfgId, int mountsRank, Role2MountsInfo xRole2MountsInfo)
/*     */   {
/* 548 */     SMountsCfg sMountsCfg = SMountsCfg.get(mountsCfgId);
/* 549 */     if (sMountsCfg == null)
/*     */     {
/* 551 */       return 0;
/*     */     }
/*     */     
/* 554 */     int mountsSpeed = getMountsSpeed(mountsCfgId, mountsRank);
/* 555 */     if (sMountsCfg.mountsType == 6)
/*     */     {
/*     */ 
/* 558 */       for (Map.Entry<Long, xbean.MountsInfo> entry : xRole2MountsInfo.getMounts_info_map().entrySet())
/*     */       {
/* 560 */         xbean.MountsInfo xMountsInfo = (xbean.MountsInfo)entry.getValue();
/* 561 */         int speed = getMountsSpeed(xMountsInfo.getMounts_cfg_id(), xMountsInfo.getMounts_rank());
/* 562 */         if (speed > mountsSpeed)
/*     */         {
/* 564 */           mountsSpeed = speed;
/*     */         }
/*     */       }
/*     */     }
/* 568 */     return mountsSpeed;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getMountsSpeed(int mountsCfgId, int mountsRank)
/*     */   {
/* 576 */     SMountsRankCfg sMountsRankCfg = SMountsRankCfg.get(mountsCfgId);
/* 577 */     if (sMountsRankCfg == null)
/*     */     {
/* 579 */       return 0;
/*     */     }
/*     */     
/* 582 */     MountsRankInfoBean mountsRankInfoBean = (MountsRankInfoBean)sMountsRankCfg.mountsRankMapInfo.get(Integer.valueOf(mountsRank));
/* 583 */     if (mountsRankInfoBean == null)
/*     */     {
/* 585 */       return 0;
/*     */     }
/* 587 */     return mountsRankInfoBean.speed;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static class RideMountsObj
/*     */   {
/*     */     private final int mountsCfgId;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     private final int mountsOrnamentRank;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     private final int mountsRank;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     private final int mountsDyeColorId;
/*     */     
/*     */ 
/*     */ 
/*     */     private final int mountsSpeed;
/*     */     
/*     */ 
/*     */ 
/*     */     private final long mountsId;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     public RideMountsObj(int mountsCfgId, int mountsOrnamentRank, int mountsRank, int mountsDyeColorId, int mountsSpeed, long mountsId)
/*     */     {
/* 626 */       this.mountsCfgId = mountsCfgId;
/* 627 */       this.mountsOrnamentRank = mountsOrnamentRank;
/* 628 */       this.mountsRank = mountsRank;
/* 629 */       this.mountsDyeColorId = mountsDyeColorId;
/* 630 */       this.mountsSpeed = mountsSpeed;
/* 631 */       this.mountsId = mountsId;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     public int getMountsCfgId()
/*     */     {
/* 639 */       return this.mountsCfgId;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     public int getMountsRank()
/*     */     {
/* 647 */       return this.mountsOrnamentRank;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     public int getColorId()
/*     */     {
/* 655 */       return this.mountsDyeColorId;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public int getMountsSpeed()
/*     */     {
/* 665 */       return this.mountsSpeed;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     public long getMountsId()
/*     */     {
/* 673 */       return this.mountsId;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getMountsTypeMaxRank(long roleId, int mountsCfgId, boolean isRemainRolelock)
/*     */   {
/* 691 */     Role2MountsInfo xRole2MountsInfo = null;
/* 692 */     if (isRemainRolelock)
/*     */     {
/* 694 */       xRole2MountsInfo = Role2mounts.get(Long.valueOf(roleId));
/*     */     }
/*     */     else
/*     */     {
/* 698 */       xRole2MountsInfo = Role2mounts.select(Long.valueOf(roleId));
/*     */     }
/*     */     
/* 701 */     if (xRole2MountsInfo == null)
/*     */     {
/* 703 */       return 0;
/*     */     }
/*     */     
/* 706 */     int maxMountsRank = 0;
/* 707 */     Map<Long, xbean.MountsInfo> xMountsInfoMap = xRole2MountsInfo.getMounts_info_map();
/* 708 */     for (xbean.MountsInfo xMountsInfo : xMountsInfoMap.values())
/*     */     {
/* 710 */       if (xMountsInfo.getMounts_cfg_id() == mountsCfgId)
/*     */       {
/* 712 */         int mountsRank = xMountsInfo.getMounts_rank();
/* 713 */         if (mountsRank > maxMountsRank)
/*     */         {
/* 715 */           maxMountsRank = mountsRank;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 720 */     return maxMountsRank;
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
/*     */   public static MultiRoleMountsInfo getMultiRoleMountsInfo(long teamId, boolean retainLock)
/*     */   {
/* 733 */     return MultiRoleMountsManager.getMultiRoleMountsInfo(teamId, retainLock);
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
/*     */   public static boolean isOnMultiRoleMounts(long roleId, boolean retainLock)
/*     */   {
/* 747 */     Long teamId = TeamInterface.getTeamidByRoleid(roleId, retainLock);
/* 748 */     if (null == teamId)
/*     */     {
/* 750 */       return false;
/*     */     }
/*     */     MultiRoleMounts xMultiRoleMounts;
/*     */     MultiRoleMounts xMultiRoleMounts;
/* 754 */     if (retainLock)
/*     */     {
/* 756 */       xMultiRoleMounts = Team2multirolemounts.get(teamId);
/*     */     }
/*     */     else
/*     */     {
/* 760 */       xMultiRoleMounts = Team2multirolemounts.select(teamId);
/*     */     }
/*     */     
/* 763 */     if (null == xMultiRoleMounts)
/*     */     {
/* 765 */       return false;
/*     */     }
/*     */     
/* 768 */     if (xMultiRoleMounts.getRole_ids().size() == 1)
/*     */     {
/* 770 */       return false;
/*     */     }
/*     */     
/* 773 */     int roleNum = 0;
/* 774 */     for (Iterator i$ = xMultiRoleMounts.getRole_ids().iterator(); i$.hasNext();) { long mountRoleId = ((Long)i$.next()).longValue();
/*     */       
/* 776 */       if (mountRoleId > 0L)
/*     */       {
/* 778 */         roleNum++;
/*     */       }
/*     */     }
/* 781 */     if (roleNum <= 1)
/*     */     {
/* 783 */       return false;
/*     */     }
/*     */     
/* 786 */     if (!xMultiRoleMounts.getRole_ids().contains(Long.valueOf(roleId)))
/*     */     {
/* 788 */       return false;
/*     */     }
/*     */     
/* 791 */     return true;
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
/*     */ 
/*     */   public static int getMountsNumMinRank(long roleId, int minRank, boolean isRemainRoleLock)
/*     */   {
/* 807 */     return MountsManager.getMountsNumMinRank(roleId, minRank, -1, isRemainRoleLock);
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
/*     */ 
/*     */ 
/*     */   public static int getMountsNumMinRank(long roleId, int minRank, int mountsCfgId, boolean isRemainRoleLock)
/*     */   {
/* 824 */     return MountsManager.getMountsNumMinRank(roleId, minRank, mountsCfgId, isRemainRoleLock);
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
/*     */ 
/*     */ 
/*     */   public static int removeMounts(long roleId, int mountsUnlockItemCfgId, long mountsId)
/*     */   {
/* 841 */     return MountsManager.removeMounts(roleId, mountsUnlockItemCfgId, mountsId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Map<Integer, Integer> getMountCfgId2maxRank(long roleId, boolean isRemainRoleLock)
/*     */   {
/* 852 */     Map<Integer, Integer> result = new TreeMap();
/* 853 */     Role2MountsInfo xRole2MountsInfo = isRemainRoleLock ? Role2mounts.get(Long.valueOf(roleId)) : Role2mounts.select(Long.valueOf(roleId));
/*     */     
/*     */ 
/*     */ 
/* 857 */     if (xRole2MountsInfo == null)
/*     */     {
/* 859 */       return result;
/*     */     }
/*     */     
/* 862 */     Map<Long, xbean.MountsInfo> xMountsInfoMap = xRole2MountsInfo.getMounts_info_map();
/*     */     
/*     */ 
/* 865 */     for (Map.Entry<Long, xbean.MountsInfo> entry : xMountsInfoMap.entrySet())
/*     */     {
/* 867 */       xbean.MountsInfo xMountsInfo = (xbean.MountsInfo)entry.getValue();
/* 868 */       int maxRank; int maxRank; if (result.containsKey(Integer.valueOf(xMountsInfo.getMounts_cfg_id())))
/*     */       {
/* 870 */         maxRank = Math.max(((Integer)result.get(Integer.valueOf(xMountsInfo.getMounts_cfg_id()))).intValue(), xMountsInfo.getMounts_rank());
/*     */       }
/*     */       else
/*     */       {
/* 874 */         maxRank = xMountsInfo.getMounts_rank();
/*     */       }
/* 876 */       result.put(Integer.valueOf(xMountsInfo.getMounts_cfg_id()), Integer.valueOf(maxRank));
/*     */     }
/* 878 */     return result;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mounts\main\MountsInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
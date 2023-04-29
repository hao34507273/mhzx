/*     */ package mzm.gsp.petmark.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.petmark.SSynPetMarkUnequip;
/*     */ import mzm.gsp.petmark.confbean.SPetMarkConstants;
/*     */ import mzm.gsp.petmark.confbean.SPetMarkLevelBean;
/*     */ import mzm.gsp.petmark.confbean.SPetMarkLevelCfg;
/*     */ import mzm.gsp.petmark.event.PetMarkAdd;
/*     */ import mzm.gsp.petmark.event.PetMarkAddArg;
/*     */ import mzm.gsp.petmark.event.PetMarkEquip;
/*     */ import mzm.gsp.petmark.event.PetMarkEquipArg;
/*     */ import mzm.gsp.petmark.event.PetMarkRemove;
/*     */ import mzm.gsp.petmark.event.PetMarkRemoveArg;
/*     */ import mzm.gsp.petmark.event.PetMarkUnequip;
/*     */ import mzm.gsp.petmark.event.PetMarkUnequipArg;
/*     */ import mzm.gsp.petmark.event.PetMarkUpgradeArg;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.role.main.RoleOneByOneManager;
/*     */ import xbean.PetMarkInfo;
/*     */ import xbean.Pod;
/*     */ import xbean.Role2PetMarkInfo;
/*     */ import xtable.Role2petmark;
/*     */ 
/*     */ public class PetMarkManager
/*     */ {
/*     */   public static enum AddPetMarkReason
/*     */   {
/*  32 */     UNLOCK(1),  UPGRADE_COST_HIGHER_LEVEL(2);
/*     */     
/*     */     public final int value;
/*     */     
/*     */     private AddPetMarkReason(int value)
/*     */     {
/*  38 */       this.value = value;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static enum RemovePetMarkReason
/*     */   {
/*  47 */     LEVEL_UP(1),  DECOMPOSE(2),  IDIP(3);
/*     */     
/*     */     public final int value;
/*     */     
/*     */     private RemovePetMarkReason(int value)
/*     */     {
/*  53 */       this.value = value;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static enum UnequipPetMarkReason
/*     */   {
/*  62 */     ACTIVE(1),  REMOVE(2),  REPLACE(3),  OTHER_EQUIP(4),  PET_REMOVE(5),  IDIP(6);
/*     */     
/*     */     public final int value;
/*     */     
/*     */     private UnequipPetMarkReason(int value)
/*     */     {
/*  68 */       this.value = value;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isPetMarkOpen(long roleId)
/*     */   {
/*  80 */     if (!OpenInterface.getOpenStatus(565))
/*     */     {
/*  82 */       return false;
/*     */     }
/*  84 */     if (OpenInterface.isBanPlay(roleId, 565))
/*     */     {
/*  86 */       OpenInterface.sendBanPlayMsg(roleId, 565);
/*  87 */       return false;
/*     */     }
/*  89 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static Role2PetMarkInfo getRolePetMarkInfo(long roleId)
/*     */   {
/* 100 */     Role2PetMarkInfo xRole2PetMarkInfo = Role2petmark.get(Long.valueOf(roleId));
/* 101 */     if (null == xRole2PetMarkInfo)
/*     */     {
/* 103 */       xRole2PetMarkInfo = Pod.newRole2PetMarkInfo();
/* 104 */       Role2petmark.add(Long.valueOf(roleId), xRole2PetMarkInfo);
/*     */     }
/* 106 */     return xRole2PetMarkInfo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean checkRoleLevel(long roleId)
/*     */   {
/* 118 */     int roleLevel = RoleInterface.getLevel(roleId);
/* 119 */     return roleLevel >= SPetMarkConstants.getInstance().OPEN_LEVEL;
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
/*     */   static long addPetMark(long roleId, Role2PetMarkInfo xRole2PetMarkInfo, int petMarkCfgId, int petMarkLevel, AddPetMarkReason reason)
/*     */   {
/* 134 */     PetMarkInfo xPetMarkInfo = Pod.newPetMarkInfo();
/* 135 */     xPetMarkInfo.setPet_mark_cfg_id(petMarkCfgId);
/* 136 */     xPetMarkInfo.setLevel(petMarkLevel);
/* 137 */     long newId = xRole2PetMarkInfo.getNext_pet_mark_id();
/* 138 */     xRole2PetMarkInfo.setNext_pet_mark_id(newId + 1L);
/* 139 */     xRole2PetMarkInfo.getPetmarkid2info().put(Long.valueOf(newId), xPetMarkInfo);
/*     */     
/*     */ 
/* 142 */     PetMarkAddArg arg = new PetMarkAddArg(roleId, newId, petMarkCfgId, petMarkLevel);
/* 143 */     TriggerEventsManger.getInstance().triggerEvent(new PetMarkAdd(), arg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(roleId)));
/*     */     
/*     */ 
/*     */ 
/* 147 */     PetMarkTLogManager.addPetMarkAddTLog(roleId, newId, petMarkCfgId, petMarkLevel, reason);
/*     */     
/* 149 */     return newId;
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
/*     */   static void removePetMark(long roleId, long petMarkId, Role2PetMarkInfo xRole2PetMarkInfo, RemovePetMarkReason reason)
/*     */   {
/* 164 */     unequipPetMark(roleId, petMarkId, xRole2PetMarkInfo, UnequipPetMarkReason.REMOVE);
/*     */     
/*     */ 
/* 167 */     xRole2PetMarkInfo.getPetmarkid2info().remove(Long.valueOf(petMarkId));
/*     */     
/*     */ 
/* 170 */     PetMarkRemoveArg arg = new PetMarkRemoveArg(roleId, petMarkId, reason);
/* 171 */     TriggerEventsManger.getInstance().triggerEvent(new PetMarkRemove(), arg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(roleId)));
/*     */     
/*     */ 
/*     */ 
/* 175 */     PetMarkTLogManager.addPetMarkRemoveTLog(roleId, petMarkId, reason);
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
/*     */   static boolean unequipPetMark(long roleId, long petMarkId, Role2PetMarkInfo xRole2PetMarkInfo, UnequipPetMarkReason reason)
/*     */   {
/* 191 */     PetMarkInfo xPetMarkInfo = (PetMarkInfo)xRole2PetMarkInfo.getPetmarkid2info().get(Long.valueOf(petMarkId));
/* 192 */     if (null == xPetMarkInfo)
/*     */     {
/* 194 */       return false;
/*     */     }
/*     */     
/* 197 */     long equipedPetId = xPetMarkInfo.getPet_id();
/* 198 */     if (equipedPetId <= 0L)
/*     */     {
/* 200 */       return true;
/*     */     }
/*     */     
/* 203 */     xPetMarkInfo.setPet_id(0L);
/* 204 */     xRole2PetMarkInfo.getPetid2petmarkid().remove(Long.valueOf(equipedPetId));
/*     */     
/*     */ 
/* 207 */     int petMarkCfgId = xPetMarkInfo.getPet_mark_cfg_id();
/* 208 */     int level = xPetMarkInfo.getLevel();
/* 209 */     PetMarkUnequipArg arg = new PetMarkUnequipArg(roleId, equipedPetId, petMarkId, petMarkCfgId, level);
/* 210 */     TriggerEventsManger.getInstance().triggerEvent(new PetMarkUnequip(), arg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(roleId)));
/*     */     
/*     */ 
/*     */ 
/* 214 */     SSynPetMarkUnequip proto = new SSynPetMarkUnequip();
/* 215 */     proto.pet_mark_id = petMarkId;
/* 216 */     proto.pet_id = equipedPetId;
/* 217 */     OnlineManager.getInstance().send(roleId, proto);
/*     */     
/*     */ 
/* 220 */     PetMarkTLogManager.addPetMarkUnequipTLog(roleId, petMarkId, equipedPetId, reason);
/*     */     
/* 222 */     return true;
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
/*     */   static boolean equipPetMark(long roleId, long petMarkId, long petId, Role2PetMarkInfo xRole2PetMarkInfo)
/*     */   {
/* 237 */     if (null != xRole2PetMarkInfo.getPetid2petmarkid().get(Long.valueOf(petId)))
/*     */     {
/* 239 */       return false;
/*     */     }
/*     */     
/* 242 */     PetMarkInfo xPetMarkInfo = (PetMarkInfo)xRole2PetMarkInfo.getPetmarkid2info().get(Long.valueOf(petMarkId));
/* 243 */     if (null == xPetMarkInfo)
/*     */     {
/* 245 */       return false;
/*     */     }
/*     */     
/* 248 */     if (xPetMarkInfo.getPet_id() > 0L)
/*     */     {
/* 250 */       return false;
/*     */     }
/*     */     
/* 253 */     xPetMarkInfo.setPet_id(petId);
/* 254 */     xRole2PetMarkInfo.getPetid2petmarkid().put(Long.valueOf(petId), Long.valueOf(petMarkId));
/*     */     
/*     */ 
/* 257 */     int petMarkCfgId = xPetMarkInfo.getPet_mark_cfg_id();
/* 258 */     int level = xPetMarkInfo.getLevel();
/* 259 */     PetMarkEquipArg arg = new PetMarkEquipArg(roleId, petId, petMarkId, petMarkCfgId, level);
/* 260 */     TriggerEventsManger.getInstance().triggerEvent(new PetMarkEquip(), arg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(roleId)));
/*     */     
/*     */ 
/*     */ 
/* 264 */     PetMarkTLogManager.addPetMarkEquipTLog(roleId, petMarkId, petId);
/*     */     
/* 266 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean addPetMarkExp(long roleId, long petMarkId, PetMarkInfo xPetMarkInfo, int addExp)
/*     */   {
/* 278 */     int petMarkCfgId = xPetMarkInfo.getPet_mark_cfg_id();
/* 279 */     int level = xPetMarkInfo.getLevel();
/* 280 */     int exp = xPetMarkInfo.getExp();
/* 281 */     int newExp = exp + addExp;
/* 282 */     int newLevel = level;
/* 283 */     SPetMarkLevelCfg sPetMarkLevelCfg = SPetMarkLevelCfg.get(petMarkCfgId);
/* 284 */     SPetMarkLevelBean sPetMarkLevelBean = (SPetMarkLevelBean)sPetMarkLevelCfg.level2Bean.get(Integer.valueOf(level));
/* 285 */     while ((sPetMarkLevelBean.upgradeExp > 0) && (newExp >= sPetMarkLevelBean.upgradeExp))
/*     */     {
/* 287 */       newLevel++;
/* 288 */       newExp -= sPetMarkLevelBean.upgradeExp;
/* 289 */       sPetMarkLevelBean = (SPetMarkLevelBean)sPetMarkLevelCfg.level2Bean.get(Integer.valueOf(newLevel));
/*     */     }
/* 291 */     xPetMarkInfo.setLevel(newLevel);
/* 292 */     xPetMarkInfo.setExp(newExp);
/*     */     
/*     */ 
/* 295 */     long petId = xPetMarkInfo.getPet_id();
/* 296 */     if (newLevel != level)
/*     */     {
/* 298 */       PetMarkUpgradeArg arg = new PetMarkUpgradeArg(roleId, petId, petMarkId, petMarkCfgId, level);
/* 299 */       TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.petmark.event.PetMarkUpgrade(), arg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(roleId)));
/*     */       
/* 301 */       return true;
/*     */     }
/* 303 */     return false;
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
/*     */   static boolean isLevelMax(SPetMarkLevelCfg sPetMarkLevelCfg, int level)
/*     */   {
/* 316 */     if (((SPetMarkLevelBean)sPetMarkLevelCfg.level2Bean.get(Integer.valueOf(level))).upgradeExp == 0)
/*     */     {
/* 318 */       return true;
/*     */     }
/*     */     
/* 321 */     int maxLevel = SPetMarkConstants.getInstance().PET_MARK_MAX_LEVEL;
/* 322 */     if (level >= maxLevel)
/*     */     {
/* 324 */       return true;
/*     */     }
/*     */     
/* 327 */     return false;
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
/*     */   static boolean isLevelMaxByRoleLevel(long roleId, SPetMarkLevelCfg sPetMarkLevelCfg, int level)
/*     */   {
/* 342 */     int roleLevel = RoleInterface.getLevel(roleId);
/* 343 */     if (((SPetMarkLevelBean)sPetMarkLevelCfg.level2Bean.get(Integer.valueOf(level + 1))).needRoleLevel > roleLevel)
/*     */     {
/* 345 */       return true;
/*     */     }
/*     */     
/* 348 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petmark\main\PetMarkManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
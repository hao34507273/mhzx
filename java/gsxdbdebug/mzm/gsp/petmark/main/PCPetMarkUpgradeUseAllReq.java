/*     */ package mzm.gsp.petmark.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.item.main.BasicItem;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.RolePetMarkBag;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.petmark.SPetMarkUpgradeUseAllFail;
/*     */ import mzm.gsp.petmark.SPetMarkUpgradeUseAllSuccess;
/*     */ import mzm.gsp.petmark.confbean.SPetMarkCfg;
/*     */ import mzm.gsp.petmark.confbean.SPetMarkConstants;
/*     */ import mzm.gsp.petmark.confbean.SPetMarkItemCfg;
/*     */ import mzm.gsp.petmark.confbean.SPetMarkLevelBean;
/*     */ import mzm.gsp.petmark.confbean.SPetMarkLevelCfg;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Role2PetMarkInfo;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PCPetMarkUpgradeUseAllReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long mainPetMarkId;
/*     */   private int mainPetMarkCfgId;
/*     */   
/*     */   public PCPetMarkUpgradeUseAllReq(long roleId, long mainPetMarkId)
/*     */   {
/*  49 */     this.roleId = roleId;
/*  50 */     this.mainPetMarkId = mainPetMarkId;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  57 */     if (!PetMarkManager.isPetMarkOpen(this.roleId))
/*     */     {
/*  59 */       String logstr = String.format("[petmark]PCPetMarkUpgradeUseAllReq.processImp@function not open|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  61 */       GameServer.logger().info(logstr);
/*  62 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  66 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 2136, true))
/*     */     {
/*  68 */       String logstr = String.format("[petmark]PCPetMarkUpgradeUseAllReq.processImp@status error|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  70 */       GameServer.logger().info(logstr);
/*  71 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  75 */     if (!PetMarkManager.checkRoleLevel(this.roleId))
/*     */     {
/*  77 */       onFail(-1);
/*  78 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  82 */     Role2PetMarkInfo xRole2PetMarkInfo = PetMarkManager.getRolePetMarkInfo(this.roleId);
/*  83 */     xbean.PetMarkInfo xMainPetMarkInfo = (xbean.PetMarkInfo)xRole2PetMarkInfo.getPetmarkid2info().get(Long.valueOf(this.mainPetMarkId));
/*  84 */     if (null == xMainPetMarkInfo)
/*     */     {
/*  86 */       onFail(-2);
/*  87 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  91 */     int mainPetMarkCfgId = xMainPetMarkInfo.getPet_mark_cfg_id();
/*  92 */     int mainPetMarkLevel = xMainPetMarkInfo.getLevel();
/*  93 */     SPetMarkLevelCfg mainPetMarkLevelCfg = SPetMarkLevelCfg.get(mainPetMarkCfgId);
/*  94 */     if (PetMarkManager.isLevelMax(mainPetMarkLevelCfg, mainPetMarkLevel))
/*     */     {
/*  96 */       onFail(-3);
/*  97 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 101 */     if (PetMarkManager.isLevelMaxByRoleLevel(this.roleId, mainPetMarkLevelCfg, mainPetMarkLevel))
/*     */     {
/* 103 */       onFail(-6);
/* 104 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 108 */     this.mainPetMarkCfgId = mainPetMarkCfgId;
/* 109 */     SPetMarkCfg sMainPetMarkCfg = SPetMarkCfg.get(mainPetMarkCfgId);
/* 110 */     List<UpgradeCostable> upgradeCosts = new LinkedList();
/*     */     
/* 112 */     for (Map.Entry<Long, xbean.PetMarkInfo> entry : xRole2PetMarkInfo.getPetmarkid2info().entrySet())
/*     */     {
/* 114 */       if (((Long)entry.getKey()).longValue() != this.mainPetMarkId)
/*     */       {
/*     */ 
/*     */ 
/* 118 */         xbean.PetMarkInfo xPetMarkInfo = (xbean.PetMarkInfo)entry.getValue();
/* 119 */         SPetMarkCfg sPetMarkCfg = SPetMarkCfg.get(xPetMarkInfo.getPet_mark_cfg_id());
/* 120 */         if ((sPetMarkCfg.quality == sMainPetMarkCfg.quality) && (xPetMarkInfo.getPet_id() <= 0L))
/*     */         {
/*     */ 
/*     */ 
/* 124 */           upgradeCosts.add(new UpgradeCostablePetMark(((Long)entry.getKey()).longValue(), sPetMarkCfg, xPetMarkInfo.getLevel(), xPetMarkInfo.getExp())); }
/*     */       }
/*     */     }
/* 127 */     RolePetMarkBag rolePetMarkItemBag = ItemInterface.getRolePetMarkBag(this.roleId);
/* 128 */     Set<Integer> ownPetMarkItemCfgIds = new HashSet();
/* 129 */     if (null != rolePetMarkItemBag)
/*     */     {
/* 131 */       for (BasicItem item : rolePetMarkItemBag.getAllItems(false).values())
/*     */       {
/* 133 */         int petMarkItemCfgId = item.getCfgId();
/* 134 */         if (!ownPetMarkItemCfgIds.contains(Integer.valueOf(petMarkItemCfgId)))
/*     */         {
/* 136 */           ownPetMarkItemCfgIds.add(Integer.valueOf(petMarkItemCfgId));
/* 137 */           SPetMarkItemCfg sPetMarkItemCfg = SPetMarkItemCfg.get(petMarkItemCfgId);
/* 138 */           if (null != sPetMarkItemCfg)
/*     */           {
/*     */ 
/*     */ 
/*     */ 
/* 143 */             SPetMarkCfg sPetMarkCfg = SPetMarkCfg.get(sPetMarkItemCfg.petMarkCfgId);
/* 144 */             if (sPetMarkCfg.quality == sMainPetMarkCfg.quality)
/*     */             {
/*     */ 
/*     */ 
/* 148 */               upgradeCosts.add(new UpgradeCostableItem(sPetMarkItemCfg, sPetMarkCfg));
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 154 */     if (upgradeCosts.isEmpty())
/*     */     {
/* 156 */       onFail(-4);
/* 157 */       return false;
/*     */     }
/* 159 */     Collections.sort(upgradeCosts);
/*     */     
/*     */ 
/* 162 */     int reduceRatio = SPetMarkConstants.getInstance().DIFFRENT_MARK_EXP_REDUSE_RATIO;
/* 163 */     List<Long> addPetMarkIds = new LinkedList();
/* 164 */     List<Long> costPetMarkIds = new LinkedList();
/* 165 */     Map<Integer, Integer> costItemCfgId2Num = new HashMap();
/* 166 */     int totalAddExp = 0;
/* 167 */     for (UpgradeCostable upgradeCost : upgradeCosts)
/*     */     {
/*     */ 
/* 170 */       int newLevel = xMainPetMarkInfo.getLevel();
/* 171 */       if ((PetMarkManager.isLevelMax(mainPetMarkLevelCfg, newLevel)) || (PetMarkManager.isLevelMaxByRoleLevel(this.roleId, mainPetMarkLevelCfg, newLevel))) {
/*     */         break;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 178 */       if (upgradeCost.getType() == UpgradeCostableType.PET_MARK)
/*     */       {
/*     */ 
/* 181 */         UpgradeCostablePetMark costablePetMark = (UpgradeCostablePetMark)upgradeCost;
/*     */         
/* 183 */         int costPetMarkCfgId = costablePetMark.petMarkCfgId;
/* 184 */         int costPetMarkLevel = costablePetMark.level;
/* 185 */         int costPetMarkExp = costablePetMark.exp;
/* 186 */         SPetMarkLevelBean sCostPetMarkLevelBean = (SPetMarkLevelBean)SPetMarkLevelCfg.get(costPetMarkCfgId).level2Bean.get(Integer.valueOf(costPetMarkLevel));
/* 187 */         int addExp = sCostPetMarkLevelBean.provideExp + costPetMarkExp;
/*     */         
/*     */ 
/* 190 */         if ((!costablePetMark.isGeneral()) && (costPetMarkLevel > mainPetMarkLevel))
/*     */         {
/*     */ 
/* 193 */           SPetMarkLevelBean sAddPetMarkLevelBean = (SPetMarkLevelBean)SPetMarkLevelCfg.get(costPetMarkCfgId).level2Bean.get(Integer.valueOf(1));
/* 194 */           addExp -= sAddPetMarkLevelBean.provideExp;
/* 195 */           addPetMarkIds.add(Long.valueOf(PetMarkManager.addPetMark(this.roleId, xRole2PetMarkInfo, costPetMarkCfgId, 1, PetMarkManager.AddPetMarkReason.UPGRADE_COST_HIGHER_LEVEL)));
/*     */         }
/*     */         
/*     */ 
/*     */ 
/* 200 */         if (mainPetMarkCfgId != costPetMarkCfgId)
/*     */         {
/* 202 */           addExp /= reduceRatio;
/*     */         }
/*     */         
/*     */ 
/* 206 */         PetMarkManager.addPetMarkExp(this.roleId, this.mainPetMarkId, xMainPetMarkInfo, addExp);
/*     */         
/*     */ 
/* 209 */         PetMarkManager.removePetMark(this.roleId, costablePetMark.petMarkId, xRole2PetMarkInfo, PetMarkManager.RemovePetMarkReason.LEVEL_UP);
/*     */         
/*     */ 
/*     */ 
/* 213 */         costPetMarkIds.add(Long.valueOf(costablePetMark.petMarkId));
/* 214 */         totalAddExp += addExp;
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/* 219 */         UpgradeCostableItem costableItem = (UpgradeCostableItem)upgradeCost;
/* 220 */         SPetMarkItemCfg costPetMarkItemCfg = SPetMarkItemCfg.get(costableItem.itemCfgId);
/* 221 */         int itemNum = ItemInterface.getItemNumberById(this.roleId, 340600009, costableItem.itemCfgId);
/*     */         int singleAddExp;
/*     */         int singleAddExp;
/* 224 */         if (costableItem.petMarkCfgId == mainPetMarkCfgId)
/*     */         {
/* 226 */           singleAddExp = costPetMarkItemCfg.provideExp;
/*     */         }
/*     */         else
/*     */         {
/* 230 */           singleAddExp = costPetMarkItemCfg.provideExp / reduceRatio;
/*     */         }
/*     */         
/*     */ 
/* 234 */         int remainNum = itemNum;
/* 235 */         while (remainNum > 0)
/*     */         {
/* 237 */           remainNum--;
/* 238 */           if (PetMarkManager.addPetMarkExp(this.roleId, this.mainPetMarkId, xMainPetMarkInfo, singleAddExp))
/*     */           {
/* 240 */             if (!PetMarkManager.isLevelMax(mainPetMarkLevelCfg, xMainPetMarkInfo.getLevel())) { if (PetMarkManager.isLevelMaxByRoleLevel(this.roleId, mainPetMarkLevelCfg, xMainPetMarkInfo.getLevel())) {
/*     */                 break;
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 251 */         int costNum = itemNum - remainNum;
/* 252 */         TLogArg logArg = new TLogArg(LogReason.PET_MARK_UPGRADE_COST);
/* 253 */         if (!ItemInterface.removeItemById(this.roleId, 340600009, costableItem.itemCfgId, costNum, logArg))
/*     */         {
/* 255 */           onFail(-5);
/* 256 */           return false;
/*     */         }
/*     */         
/*     */ 
/* 260 */         costItemCfgId2Num.put(Integer.valueOf(costableItem.itemCfgId), Integer.valueOf(costNum));
/* 261 */         totalAddExp += singleAddExp * costNum;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 266 */     onSuccess(totalAddExp, addPetMarkIds, xRole2PetMarkInfo, costPetMarkIds, costItemCfgId2Num);
/*     */     
/* 268 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void onSuccess(int totalAddExp, Collection<Long> addPetMarkIds, Role2PetMarkInfo xRole2PetMarkInfo, Collection<Long> costPetMarkIds, Map<Integer, Integer> costItemCfgId2Num)
/*     */   {
/* 276 */     xbean.PetMarkInfo xMainPetMarkInfo = (xbean.PetMarkInfo)xRole2PetMarkInfo.getPetmarkid2info().get(Long.valueOf(this.mainPetMarkId));
/* 277 */     SPetMarkUpgradeUseAllSuccess proto = new SPetMarkUpgradeUseAllSuccess();
/* 278 */     proto.main_pet_mark_id = this.mainPetMarkId;
/* 279 */     proto.add_exp = totalAddExp;
/* 280 */     proto.now_level = xMainPetMarkInfo.getLevel();
/* 281 */     proto.now_exp = xMainPetMarkInfo.getExp();
/* 282 */     for (Iterator i$ = addPetMarkIds.iterator(); i$.hasNext();) { long addPetMarkId = ((Long)i$.next()).longValue();
/*     */       
/* 284 */       xbean.PetMarkInfo xAddPetMarkInfo = (xbean.PetMarkInfo)xRole2PetMarkInfo.getPetmarkid2info().get(Long.valueOf(addPetMarkId));
/* 285 */       mzm.gsp.petmark.PetMarkInfo petMarkInfoBean = new mzm.gsp.petmark.PetMarkInfo();
/* 286 */       petMarkInfoBean.pet_mark_cfg_id = xAddPetMarkInfo.getPet_mark_cfg_id();
/* 287 */       petMarkInfoBean.level = xAddPetMarkInfo.getLevel();
/* 288 */       petMarkInfoBean.exp = xAddPetMarkInfo.getExp();
/* 289 */       petMarkInfoBean.pet_id = xAddPetMarkInfo.getPet_id();
/* 290 */       proto.new_pet_mark_info_map.put(Long.valueOf(addPetMarkId), petMarkInfoBean);
/*     */     }
/* 292 */     proto.cost_pet_mark_ids.addAll(costPetMarkIds);
/* 293 */     proto.cost_item_map.putAll(costItemCfgId2Num);
/*     */     
/* 295 */     OnlineManager.getInstance().send(this.roleId, proto);
/*     */     
/*     */ 
/* 298 */     String logstr = String.format("[petmark]PCPetMarkUpgradeUseAllReq.onSuccess@PCPetMarkUpgradeUseAllReq success|roleId=%d,mainPetMarkId=%d,addExp=%d,xPetMarkInfo=%s", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.mainPetMarkId), Integer.valueOf(totalAddExp), xMainPetMarkInfo });
/*     */     
/*     */ 
/* 301 */     GameServer.logger().info(logstr);
/*     */     
/*     */ 
/* 304 */     PetMarkTLogManager.addPetMarkUpgradeTLog(this.roleId, this.mainPetMarkId, xMainPetMarkInfo.getPet_mark_cfg_id(), xMainPetMarkInfo.getLevel(), xMainPetMarkInfo.getExp(), totalAddExp);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void onFail(int errorCode)
/*     */   {
/* 311 */     SPetMarkUpgradeUseAllFail proto = new SPetMarkUpgradeUseAllFail();
/* 312 */     proto.error_code = errorCode;
/* 313 */     OnlineManager.getInstance().sendAtOnce(this.roleId, proto);
/*     */     
/*     */ 
/* 316 */     String logstr = String.format("[petmark]PCPetMarkUpgradeUseAllReq.onFail@PCPetMarkUpgradeUseAllReq failed|roleId=%d,petMarkId=%d,reason=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.mainPetMarkId), Integer.valueOf(errorCode) });
/*     */     
/*     */ 
/* 319 */     GameServer.logger().info(logstr);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static enum UpgradeCostableType
/*     */   {
/* 328 */     ITEM(1),  PET_MARK(2);
/*     */     
/*     */     public final int value;
/*     */     
/*     */     private UpgradeCostableType(int value)
/*     */     {
/* 334 */       this.value = value;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private abstract class UpgradeCostable
/*     */     implements Comparable<UpgradeCostable>
/*     */   {
/*     */     private UpgradeCostable() {}
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     abstract PCPetMarkUpgradeUseAllReq.UpgradeCostableType getType();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     abstract boolean isGeneral();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     abstract int getPetMarkCfgId();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     abstract int getLevel();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     public int compareTo(UpgradeCostable obj)
/*     */     {
/* 374 */       if ((PCPetMarkUpgradeUseAllReq.this.mainPetMarkCfgId == obj.getPetMarkCfgId()) && (PCPetMarkUpgradeUseAllReq.this.mainPetMarkCfgId != getPetMarkCfgId()))
/*     */       {
/* 376 */         return 1;
/*     */       }
/* 378 */       if ((PCPetMarkUpgradeUseAllReq.this.mainPetMarkCfgId != obj.getPetMarkCfgId()) && (PCPetMarkUpgradeUseAllReq.this.mainPetMarkCfgId == getPetMarkCfgId()))
/*     */       {
/* 380 */         return -1;
/*     */       }
/*     */       
/*     */ 
/* 384 */       if ((obj.isGeneral()) && (!isGeneral()))
/*     */       {
/* 386 */         return 1;
/*     */       }
/* 388 */       if ((!obj.isGeneral()) && (isGeneral()))
/*     */       {
/* 390 */         return -1;
/*     */       }
/*     */       
/*     */ 
/* 394 */       if (obj.getLevel() != getLevel())
/*     */       {
/* 396 */         return obj.getLevel() > getLevel() ? 1 : -1;
/*     */       }
/*     */       
/*     */ 
/* 400 */       if (obj.getType().value != getType().value)
/*     */       {
/* 402 */         return obj.getType().value > getType().value ? 1 : -1;
/*     */       }
/*     */       
/*     */ 
/* 406 */       if (obj.getPetMarkCfgId() != getPetMarkCfgId())
/*     */       {
/* 408 */         return obj.getPetMarkCfgId() > getPetMarkCfgId() ? 1 : -1;
/*     */       }
/*     */       
/* 411 */       return 0;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private class UpgradeCostablePetMark
/*     */     extends PCPetMarkUpgradeUseAllReq.UpgradeCostable
/*     */   {
/*     */     private final int level;
/*     */     
/*     */     private final int exp;
/*     */     
/*     */     private final int petMarkCfgId;
/*     */     
/*     */     private final boolean general;
/*     */     
/*     */     private final long petMarkId;
/*     */     
/*     */     UpgradeCostablePetMark(long petMarkId, SPetMarkCfg sPetMarkCfg, int level, int exp)
/*     */     {
/* 431 */       super(null);
/* 432 */       this.petMarkId = petMarkId;
/* 433 */       this.level = level;
/* 434 */       this.exp = exp;
/* 435 */       this.petMarkCfgId = sPetMarkCfg.id;
/* 436 */       this.general = (sPetMarkCfg.type == 2);
/*     */     }
/*     */     
/*     */ 
/*     */     int getLevel()
/*     */     {
/* 442 */       return this.level;
/*     */     }
/*     */     
/*     */ 
/*     */     int getPetMarkCfgId()
/*     */     {
/* 448 */       return this.petMarkCfgId;
/*     */     }
/*     */     
/*     */ 
/*     */     PCPetMarkUpgradeUseAllReq.UpgradeCostableType getType()
/*     */     {
/* 454 */       return PCPetMarkUpgradeUseAllReq.UpgradeCostableType.PET_MARK;
/*     */     }
/*     */     
/*     */ 
/*     */     boolean isGeneral()
/*     */     {
/* 460 */       return this.general;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private class UpgradeCostableItem
/*     */     extends PCPetMarkUpgradeUseAllReq.UpgradeCostable
/*     */   {
/*     */     private final int level;
/*     */     
/*     */     private final int petMarkCfgId;
/*     */     
/*     */     private final boolean general;
/*     */     
/*     */     public final int itemCfgId;
/*     */     
/*     */     UpgradeCostableItem(SPetMarkItemCfg sPetMarkItemCfg, SPetMarkCfg sPetMarkCfg)
/*     */     {
/* 478 */       super(null);
/* 479 */       this.level = sPetMarkItemCfg.level;
/* 480 */       this.petMarkCfgId = sPetMarkItemCfg.petMarkCfgId;
/* 481 */       this.general = (sPetMarkCfg.type == 2);
/* 482 */       this.itemCfgId = sPetMarkItemCfg.itemId;
/*     */     }
/*     */     
/*     */ 
/*     */     int getLevel()
/*     */     {
/* 488 */       return this.level;
/*     */     }
/*     */     
/*     */ 
/*     */     int getPetMarkCfgId()
/*     */     {
/* 494 */       return this.petMarkCfgId;
/*     */     }
/*     */     
/*     */ 
/*     */     PCPetMarkUpgradeUseAllReq.UpgradeCostableType getType()
/*     */     {
/* 500 */       return PCPetMarkUpgradeUseAllReq.UpgradeCostableType.ITEM;
/*     */     }
/*     */     
/*     */ 
/*     */     boolean isGeneral()
/*     */     {
/* 506 */       return this.general;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petmark\main\PCPetMarkUpgradeUseAllReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
/*     */ package mzm.gsp.pet.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.item.main.BasicItem;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.PetEquipmentItem;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.pet.SPetEquipItemRes;
/*     */ import mzm.gsp.pet.confbean.PetConstants;
/*     */ import mzm.gsp.petequip.confbean.SPetEquipItem;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.Item;
/*     */ import xbean.Pet;
/*     */ import xbean.PetBag;
/*     */ import xbean.PetEquipBag;
/*     */ import xtable.Role2petbag;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PPetEquipItemReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long petId;
/*     */   private final int itemKey;
/*     */   
/*     */   public PPetEquipItemReq(long roleId, long petId, int itemKey)
/*     */   {
/*  38 */     this.roleId = roleId;
/*  39 */     this.petId = petId;
/*  40 */     this.itemKey = itemKey;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  46 */     if (!PetManager.isPetSwitchOpenForRole(this.roleId)) {
/*  47 */       return false;
/*     */     }
/*     */     
/*  50 */     PetBag xPetBag = Role2petbag.get(Long.valueOf(this.roleId));
/*  51 */     if (xPetBag == null) {
/*  52 */       return false;
/*     */     }
/*  54 */     Pet xPet = (Pet)xPetBag.getPetmap().get(Long.valueOf(this.petId));
/*  55 */     if (xPet == null) {
/*  56 */       return false;
/*     */     }
/*  58 */     if (xPet.getLevel() < PetConstants.getInstance().PET_CAN_EQUIP_LEVEL) {
/*  59 */       return false;
/*     */     }
/*  61 */     Map<Integer, Item> xEquipMap = xPet.getEquipbag().getEquip2item();
/*  62 */     Map<Integer, Item> oldXEquipMap = new HashMap();
/*  63 */     oldXEquipMap.putAll(xEquipMap);
/*     */     
/*  65 */     BasicItem preivewItem = ItemInterface.getItem(this.roleId, this.itemKey);
/*  66 */     if (preivewItem == null) {
/*  67 */       return false;
/*     */     }
/*     */     
/*  70 */     BasicItem item = ItemInterface.getAndRemoveItemInBag(this.roleId, this.itemKey, 1, new TLogArg(LogReason.PET_EQUIP_REM, preivewItem.getCfgId()));
/*  71 */     if (item == null) {
/*  72 */       PetManager.logDebug("PPetEquipItemReq.processImp@not have item num|roleid=%d|itemKey=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemKey) });
/*  73 */       return false;
/*     */     }
/*  75 */     Item xPetEquip = item.getItem();
/*  76 */     if (xPetEquip == null) {
/*  77 */       return false;
/*     */     }
/*  79 */     SPetEquipItem sPetEquipItem = SPetEquipItem.get(xPetEquip.getCfgid());
/*  80 */     if (sPetEquipItem == null) {
/*  81 */       return false;
/*     */     }
/*     */     
/*  84 */     SPetEquipItemRes res = new SPetEquipItemRes();
/*     */     
/*  86 */     PetOutFightObj pet = new PetOutFightObj(this.roleId, xPet);
/*  87 */     switch (sPetEquipItem.equipType)
/*     */     {
/*     */ 
/*     */     case 2: 
/*  91 */       xEquipMap.remove(Integer.valueOf(2));
/*  92 */       xEquipMap.put(Integer.valueOf(2), xPetEquip);
/*  93 */       pet.updatePassiveSkill();
/*  94 */       res.wearpos = 2;
/*  95 */       break;
/*     */     case 0: 
/*  97 */       xEquipMap.put(Integer.valueOf(0), xPetEquip);
/*  98 */       res.wearpos = 0;
/*  99 */       break;
/*     */     case 1: 
/* 101 */       xEquipMap.put(Integer.valueOf(1), xPetEquip);
/* 102 */       res.wearpos = 1;
/* 103 */       break;
/*     */     default: 
/* 105 */       return false; }
/*     */     
/* 107 */     pet.updateEquipment();
/* 108 */     xPet.setIsbinded(1);
/* 109 */     pet.syncPetInfo();
/* 110 */     res.petid = this.petId;
/* 111 */     OnlineManager.getInstance().send(this.roleId, res);
/*     */     
/* 113 */     long replaceEquipItemId = 0L;
/* 114 */     int replaceEquipItemCfgId = 0;
/* 115 */     Item replaceEquipItem = (Item)oldXEquipMap.get(Integer.valueOf(res.wearpos));
/* 116 */     if (replaceEquipItem != null) {
/* 117 */       replaceEquipItemCfgId = replaceEquipItem.getCfgid();
/* 118 */       replaceEquipItemId = ((Long)replaceEquipItem.getUuid().iterator().next()).longValue();
/*     */     }
/* 120 */     int equipSkillId1 = 0;
/* 121 */     int equipSkillId2 = 0;
/*     */     
/* 123 */     PetEquipmentItem petEquipmentItem = (PetEquipmentItem)item;
/* 124 */     if (petEquipmentItem != null) {
/* 125 */       List<Integer> skills = petEquipmentItem.getSkills();
/* 126 */       if (skills.size() > 0) {
/* 127 */         equipSkillId1 = ((Integer)skills.get(0)).intValue();
/*     */       }
/* 129 */       if (skills.size() > 1) {
/* 130 */         equipSkillId2 = ((Integer)skills.get(1)).intValue();
/*     */       }
/*     */     }
/*     */     
/* 134 */     TLogManager.getInstance().addLog(this.roleId, "PetEquipItem", PetManager.createTLog(new Object[] { GameServerInfoManager.getHostIP(), RoleInterface.getUserId(this.roleId), Long.valueOf(this.roleId), Long.valueOf(this.petId), Long.valueOf(xPet.getId()), Integer.valueOf(item.getCfgId()), item.getFirstUuid(), Integer.valueOf(res.wearpos), Long.valueOf(replaceEquipItemId), Integer.valueOf(replaceEquipItemCfgId), Integer.valueOf(equipSkillId1), Integer.valueOf(equipSkillId2) }));
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
/* 150 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\PPetEquipItemReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
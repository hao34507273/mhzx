/*     */ package mzm.gsp.pet.main;
/*     */ 
/*     */ import java.util.LinkedList;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.item.confbean.SPetSoulExpItem;
/*     */ import mzm.gsp.item.main.BasicItem;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.pet.SPetSoulAddExpErrorRes;
/*     */ import mzm.gsp.pet.SPetSoulAddExpRes;
/*     */ import mzm.gsp.pet.confbean.PetConstants;
/*     */ import mzm.gsp.petsoul.confbean.SPetSoulCfg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Pet;
/*     */ import xbean.PetBag;
/*     */ import xbean.PetSoul;
/*     */ import xtable.Role2petbag;
/*     */ 
/*     */ public class PCPetSoulAddExpReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long petId;
/*     */   private final int soulPos;
/*     */   private final int itemId;
/*     */   private final int useAll;
/*     */   
/*     */   public PCPetSoulAddExpReq(long roleId, long petId, int soulPos, int itemId, int useAll)
/*     */   {
/*  30 */     this.roleId = roleId;
/*  31 */     this.petId = petId;
/*  32 */     this.soulPos = soulPos;
/*  33 */     this.itemId = itemId;
/*  34 */     this.useAll = useAll;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  40 */     if (!PetManager.isPetSwitchOpenForRole(this.roleId)) {
/*  41 */       return false;
/*     */     }
/*  43 */     if (!PetManager.isPetSoulOpen(this.roleId)) {
/*  44 */       return false;
/*     */     }
/*     */     
/*  47 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 1800, true)) {
/*  48 */       return false;
/*     */     }
/*     */     
/*  51 */     PetBag xPetBag = Role2petbag.get(Long.valueOf(this.roleId));
/*  52 */     if (xPetBag == null) {
/*  53 */       return false;
/*     */     }
/*  55 */     Pet xPet = (Pet)xPetBag.getPetmap().get(Long.valueOf(this.petId));
/*  56 */     if (xPet == null) {
/*  57 */       return false;
/*     */     }
/*     */     
/*  60 */     Map<Integer, PetSoul> xSoulMap = xPet.getSoulbag().getSoulmap();
/*     */     
/*     */ 
/*  63 */     PetSoul xPetSoul = (PetSoul)xSoulMap.get(Integer.valueOf(this.soulPos));
/*  64 */     if (xPetSoul == null) {
/*  65 */       sendError(2);
/*  66 */       return false;
/*     */     }
/*  68 */     int petSoulOldLevel = xPetSoul.getLevel();
/*     */     
/*  70 */     if (petSoulOldLevel >= PetConstants.getInstance().PET_SOUL_MAX_LEVEL) {
/*  71 */       sendError(3);
/*  72 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  76 */     int petLevel = xPet.getLevel();
/*  77 */     if (petSoulOldLevel >= petLevel) {
/*  78 */       sendError(4);
/*  79 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  83 */     SPetSoulExpItem soulItemCfg = SPetSoulExpItem.get(this.itemId);
/*  84 */     if (soulItemCfg == null) {
/*  85 */       GameServer.logger().info(String.format("[petsoul]PCPetSoulAddExpReq.processImp@not found itemcfg|roleid=%d|itemid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemId) }));
/*     */       
/*     */ 
/*  88 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  92 */     SPetSoulCfg petSoulCfg = PetManager.getPetSoulCfg(this.soulPos, xPetSoul.getLevel() + 1);
/*  93 */     if (petSoulCfg == null) {
/*  94 */       return false;
/*     */     }
/*     */     
/*  97 */     if (!petSoulCfg.itemList.contains(Integer.valueOf(soulItemCfg.type))) {
/*  98 */       GameServer.logger().info(String.format("[petsoul]PCPetSoulAddExpReq.processImp@error item type|roleid=%d|reqitemid=%d|reqitemtype=%d|soulPos=%d|soullevel=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemId), Integer.valueOf(soulItemCfg.type), Integer.valueOf(this.soulPos), Integer.valueOf(xPetSoul.getLevel()) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 103 */       sendError(5);
/* 104 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 108 */     BasicItem basicItem = ItemInterface.getItemByCfgId(this.roleId, this.itemId);
/* 109 */     if ((basicItem == null) || (basicItem.getNumber() < 1)) {
/* 110 */       sendError(1);
/* 111 */       return false;
/*     */     }
/*     */     
/* 114 */     PetSoul xPetSoulOld = xPetSoul.copy();
/* 115 */     int maxUseCount = this.useAll == 0 ? 1 : basicItem.getNumber();
/* 116 */     int usedItemCount = 0;
/* 117 */     int finalExp = xPetSoul.getExp();
/* 118 */     int finalLevel = xPetSoul.getLevel();
/*     */     
/* 120 */     int maxLevel = Math.min(PetConstants.getInstance().PET_SOUL_MAX_LEVEL, petLevel);
/* 121 */     SPetSoulCfg levelUpCfg = petSoulCfg;
/* 122 */     for (int i = 0; i < maxUseCount; i++) {
/* 123 */       finalExp += soulItemCfg.addExpNum;
/* 124 */       while (finalExp >= levelUpCfg.exp)
/*     */       {
/* 126 */         finalLevel++;
/* 127 */         finalExp -= levelUpCfg.exp;
/* 128 */         if (finalLevel >= maxLevel) {
/* 129 */           finalLevel = maxLevel;
/* 130 */           finalExp = 0;
/*     */         }
/*     */         else {
/* 133 */           levelUpCfg = PetManager.getPetSoulCfg(this.soulPos, finalLevel + 1);
/* 134 */           if (!levelUpCfg.itemList.contains(Integer.valueOf(soulItemCfg.type))) {
/* 135 */             finalExp = 0;
/*     */           }
/*     */         }
/*     */       }
/* 139 */       usedItemCount++;
/* 140 */       if (finalLevel >= maxLevel) {
/*     */         break;
/*     */       }
/* 143 */       levelUpCfg = PetManager.getPetSoulCfg(this.soulPos, finalLevel + 1);
/* 144 */       if (!levelUpCfg.itemList.contains(Integer.valueOf(soulItemCfg.type))) {
/*     */         break;
/*     */       }
/*     */     }
/*     */     
/* 149 */     if (!ItemInterface.removeItemById(this.roleId, this.itemId, usedItemCount, new mzm.gsp.tlog.TLogArg(mzm.gsp.tlog.LogReason.PET_SOUL_LEVEL_UP_COST, this.itemId)))
/*     */     {
/* 151 */       return false;
/*     */     }
/*     */     
/* 154 */     xPetSoul.setExp(finalExp);
/* 155 */     xPetSoul.setLevel(finalLevel);
/*     */     
/* 157 */     PetOutFightObj pet = new PetOutFightObj(this.roleId, xPet);
/* 158 */     pet.updateSoul();
/* 159 */     xPet.setIsbinded(1);
/* 160 */     pet.syncPetInfo();
/*     */     
/* 162 */     SPetSoulAddExpRes protocol = new SPetSoulAddExpRes(this.petId, this.soulPos, finalLevel, finalExp);
/* 163 */     OnlineManager.getInstance().send(this.roleId, protocol);
/* 164 */     GameServer.logger().info(String.format("[petsoul]PCPetSoulAddExpReq.processImp@allexp|roleid=%d|itemid=%d|soulpos=%d|useditemcount=%d|exp=%d|level=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemId), Integer.valueOf(this.soulPos), Integer.valueOf(usedItemCount), Integer.valueOf(finalExp), Integer.valueOf(finalLevel) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 169 */     PetManager.tLogPetSoulAddExp(this.roleId, this.petId, this.soulPos, this.itemId, usedItemCount, xPetSoul, xPetSoulOld);
/* 170 */     return true;
/*     */   }
/*     */   
/*     */   private void sendError(int code) {
/* 174 */     SPetSoulAddExpErrorRes protocol = new SPetSoulAddExpErrorRes(code);
/* 175 */     OnlineManager.getInstance().sendAtOnce(this.roleId, protocol);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\PCPetSoulAddExpReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
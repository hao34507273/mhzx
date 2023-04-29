/*     */ package mzm.gsp.pet.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.item.confbean.SPetExpItem;
/*     */ import mzm.gsp.item.confbean.SPetGrowItem;
/*     */ import mzm.gsp.item.confbean.SPetLifeItem;
/*     */ import mzm.gsp.item.main.BasicItem;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.pet.SPetNormalResult;
/*     */ import mzm.gsp.pet.SUseExpItemRes;
/*     */ import mzm.gsp.pet.SUseGrowItemRes;
/*     */ import mzm.gsp.pet.SUseLifeItemRes;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Pet;
/*     */ import xbean.PetBag;
/*     */ import xdb.Xdb;
/*     */ import xtable.Role2petbag;
/*     */ 
/*     */ public class PUsePetItemReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long petId;
/*     */   private final int itemKey;
/*     */   private final int actionType;
/*  33 */   private final float GROW_RATE = 10000.0F;
/*     */   
/*     */   public PUsePetItemReq(long roleId, long petId, int itemKey, int actionType) {
/*  36 */     this.roleId = roleId;
/*  37 */     this.petId = petId;
/*  38 */     this.itemKey = itemKey;
/*  39 */     this.actionType = actionType;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  45 */     if (!PetManager.isPetSwitchOpenForRole(this.roleId)) {
/*  46 */       return false;
/*     */     }
/*  48 */     boolean ret = false;
/*  49 */     switch (this.actionType)
/*     */     {
/*     */     case 0: 
/*  52 */       ret = useExpItem();
/*  53 */       break;
/*     */     
/*     */     case 2: 
/*  56 */       if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 199, true)) {
/*  57 */         Set<Integer> statusSet = RoleStatusInterface.getStatusSet(this.roleId);
/*  58 */         GameServer.logger().error(String.format("[pet]PUsePetItemReq.processImp@ role in STATUS_ROAM not use fun!|roleid=%d|status_set=%s", new Object[] { Long.valueOf(this.roleId), statusSet }));
/*     */         
/*  60 */         return false;
/*     */       }
/*  62 */       ret = useGrowItem();
/*  63 */       break;
/*     */     
/*     */     case 1: 
/*  66 */       if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 201, true)) {
/*  67 */         Set<Integer> statusSet = RoleStatusInterface.getStatusSet(this.roleId);
/*  68 */         GameServer.logger().error(String.format("[pet]PUsePetItemReq.processImp@ role in STATUS_ROAM not use fun!|roleid=%d|status_set=%s", new Object[] { Long.valueOf(this.roleId), statusSet }));
/*     */         
/*     */ 
/*  71 */         return false;
/*     */       }
/*  73 */       ret = useLifeItem();
/*     */     }
/*     */     
/*  76 */     return ret;
/*     */   }
/*     */   
/*     */   private int getRandomValue(int min, int max) {
/*  80 */     if (min == max) {
/*  81 */       return min;
/*     */     }
/*  83 */     return Xdb.random().nextInt(max - min) + min;
/*     */   }
/*     */   
/*     */   private boolean useExpItem()
/*     */   {
/*  88 */     PetBag xPetBag = Role2petbag.get(Long.valueOf(this.roleId));
/*  89 */     if (xPetBag == null) {
/*  90 */       PetManager.logDebug("PUsePetItemReq.useExpItem@xPetBag is null|roleid=%d|petId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.petId) });
/*  91 */       return false;
/*     */     }
/*  93 */     Pet xPet = (Pet)xPetBag.getPetmap().get(Long.valueOf(this.petId));
/*  94 */     if (xPet == null) {
/*  95 */       PetManager.logDebug("PUsePetItemReq.useExpItem@xPet is null|roleid=%d|petId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.petId) });
/*  96 */       return false;
/*     */     }
/*     */     
/*  99 */     PetOutFightObj obj = new PetOutFightObj(this.roleId, xPet);
/*     */     
/* 101 */     if (obj.getMaxLevel() <= obj.getLevel()) {
/* 102 */       SPetNormalResult result = new SPetNormalResult();
/* 103 */       result.result = 8;
/* 104 */       OnlineManager.getInstance().sendAtOnce(this.roleId, result);
/* 105 */       return false;
/*     */     }
/*     */     
/* 108 */     BasicItem basicItem = ItemInterface.getItem(this.roleId, this.itemKey);
/* 109 */     if (basicItem == null) {
/* 110 */       return false;
/*     */     }
/* 112 */     SPetExpItem sPetExpItem = SPetExpItem.get(basicItem.getCfgId());
/* 113 */     if (sPetExpItem == null) {
/* 114 */       return false;
/*     */     }
/*     */     
/* 117 */     if (!ItemInterface.removeItemByUuid(this.roleId, basicItem.getFirstUuid().longValue(), 1, new TLogArg(LogReason.PET_USE_EXP_REM, basicItem.getCfgId()))) {
/* 118 */       PetManager.logDebug("PUsePetItemReq.processImp@removeitemerror|roleid=%d|itemid=%d", new Object[] { Long.valueOf(this.roleId), basicItem.getFirstUuid() });
/* 119 */       return false;
/*     */     }
/* 121 */     int addExp = getRandomValue(sPetExpItem.lowExpLimit, sPetExpItem.maxExpLimit);
/*     */     
/* 123 */     PetInterface.setPetBindSync(this.roleId, xPet);
/*     */     
/* 125 */     SUseExpItemRes res = new SUseExpItemRes();
/* 126 */     res.addexp = addExp;
/* 127 */     res.petid = this.petId;
/* 128 */     OnlineManager.getInstance().send(this.roleId, res);
/* 129 */     obj.addExp(addExp);
/*     */     
/* 131 */     return true;
/*     */   }
/*     */   
/*     */   private boolean useLifeItem()
/*     */   {
/* 136 */     BasicItem basicItem = ItemInterface.getItem(this.roleId, this.itemKey);
/* 137 */     if (basicItem == null) {
/* 138 */       PetManager.logDebug("PUsePetItemReq.useLifeItem@not have item|roleid=%d|itemid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemKey) });
/* 139 */       return false;
/*     */     }
/* 141 */     SPetLifeItem sPetLifeItem = SPetLifeItem.get(basicItem.getCfgId());
/* 142 */     if (sPetLifeItem == null) {
/* 143 */       PetManager.logDebug("PUsePetItemReq.useLifeItem@not have SPetLifeItem|roleid=%d|cfgid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(basicItem.getCfgId()) });
/* 144 */       return false;
/*     */     }
/*     */     
/* 147 */     if (!ItemInterface.removeItemByUuid(this.roleId, basicItem.getFirstUuid().longValue(), 1, new TLogArg(LogReason.PET_USE_LIFE_ITEM_REM, basicItem.getCfgId()))) {
/* 148 */       PetManager.logDebug("PUsePetItemReq.useLifeItem@cast item error |roleid=%d|itemKey=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemKey) });
/* 149 */       return false;
/*     */     }
/* 151 */     int addLife = getRandomValue(sPetLifeItem.petMinLifeLimit, sPetLifeItem.petMaxLifeLimit);
/*     */     
/* 153 */     PetBag xPetBag = Role2petbag.get(Long.valueOf(this.roleId));
/* 154 */     if (xPetBag == null) {
/* 155 */       PetManager.logDebug("PUsePetItemReq.useLifeItem@xPetBag is null|roleid=%d|petId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.petId) });
/* 156 */       return false;
/*     */     }
/* 158 */     Pet xPet = (Pet)xPetBag.getPetmap().get(Long.valueOf(this.petId));
/* 159 */     if (xPet == null) {
/* 160 */       PetManager.logDebug("PUsePetItemReq.useLifeItem@not have this pet |roleid=%d|petId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.petId) });
/* 161 */       return false;
/*     */     }
/* 163 */     boolean needBindSyn = false;
/* 164 */     if (xPet.getIsbinded() == 0) {
/* 165 */       xPet.setIsbinded(1);
/* 166 */       needBindSyn = true;
/*     */     }
/*     */     
/* 169 */     PetOutFightObj petOutFightObj = new PetOutFightObj(this.roleId, xPet);
/* 170 */     if (needBindSyn) {
/* 171 */       petOutFightObj.syncPetInfo();
/*     */     }
/* 173 */     SUseLifeItemRes res = new SUseLifeItemRes();
/* 174 */     res.addlife = addLife;
/* 175 */     res.petid = this.petId;
/* 176 */     OnlineManager.getInstance().send(this.roleId, res);
/* 177 */     return petOutFightObj.addLife(addLife);
/*     */   }
/*     */   
/*     */   private boolean useGrowItem()
/*     */   {
/* 182 */     BasicItem basicItem = ItemInterface.getItem(this.roleId, this.itemKey);
/* 183 */     if (basicItem == null) {
/* 184 */       PetManager.logDebug("PUsePetItemReq.useGrowItem@not have item|roleid=%d|itemid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemKey) });
/* 185 */       return false;
/*     */     }
/* 187 */     SPetGrowItem growItemCfg = SPetGrowItem.get(basicItem.getCfgId());
/* 188 */     if (growItemCfg == null) {
/* 189 */       PetManager.logDebug("PUsePetItemReq.useGrowItem@not have SPetLifeItem|roleid=%d|itemid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemKey) });
/* 190 */       return false;
/*     */     }
/*     */     
/* 193 */     float addGrow = growItemCfg.addGrowValueMinLimit / 10000.0F;
/* 194 */     int max = growItemCfg.addGrowValueMaxLimit;
/* 195 */     int min = growItemCfg.addGrowValueMinLimit;
/* 196 */     if (max > min) {
/* 197 */       addGrow = (Xdb.random().nextInt(max - min) + min) / 10000.0F;
/*     */     }
/* 199 */     PetBag xPetBag = Role2petbag.get(Long.valueOf(this.roleId));
/* 200 */     if (xPetBag == null) {
/* 201 */       PetManager.logDebug("PUsePetItemReq.useGrowItem@xPetBag is null|roleid=%d|petId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.petId) });
/* 202 */       return false;
/*     */     }
/* 204 */     Pet xPet = (Pet)xPetBag.getPetmap().get(Long.valueOf(this.petId));
/* 205 */     if (xPet == null) {
/* 206 */       PetManager.logDebug("PUsePetItemReq.useGrowItem@not have this pet|roleid=%d|petId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.petId) });
/* 207 */       return false;
/*     */     }
/* 209 */     PetCfg petCfg = PetManager.getInstance().getPetCfg(xPet.getTemplateid());
/* 210 */     if (petCfg == null) {
/* 211 */       return false;
/*     */     }
/*     */     
/* 214 */     if (xPet.getGrowitemusenum() >= petCfg.getGrowItemLimit()) {
/* 215 */       SPetNormalResult sPetNormalResult = new SPetNormalResult();
/* 216 */       sPetNormalResult.result = 26;
/* 217 */       OnlineManager.getInstance().sendAtOnce(this.roleId, sPetNormalResult);
/* 218 */       return false;
/*     */     }
/*     */     
/* 221 */     if (xPet.getGrow() >= petCfg.getMaxGrow()) {
/* 222 */       SPetNormalResult sPetNormalResult = new SPetNormalResult();
/* 223 */       sPetNormalResult.result = 10;
/* 224 */       OnlineManager.getInstance().sendAtOnce(this.roleId, sPetNormalResult);
/* 225 */       return false;
/*     */     }
/*     */     
/* 228 */     if (!ItemInterface.removeItemByUuid(this.roleId, basicItem.getFirstUuid().longValue(), 1, new TLogArg(LogReason.PET_USE_GROW_ITEM_REM, basicItem.getCfgId()))) {
/* 229 */       SPetNormalResult sPetNormalResult = new SPetNormalResult();
/* 230 */       sPetNormalResult.result = 27;
/* 231 */       OnlineManager.getInstance().sendAtOnce(this.roleId, sPetNormalResult);
/* 232 */       return false;
/*     */     }
/* 234 */     float oldGrow = xPet.getGrow();
/* 235 */     float newGrow = oldGrow + addGrow;
/* 236 */     xPet.setGrow(oldGrow + addGrow);
/* 237 */     if (xPet.getGrow() > petCfg.getMaxGrow()) {
/* 238 */       xPet.setGrow(petCfg.getMaxGrow());
/*     */     }
/*     */     
/* 241 */     PetOutFightObj petOutFightObj = new PetOutFightObj(this.roleId, xPet);
/* 242 */     xPet.setIsbinded(1);
/* 243 */     petOutFightObj.syncPetInfo();
/* 244 */     xPet.setGrowitemusenum(xPet.getGrowitemusenum() + 1);
/* 245 */     SUseGrowItemRes res = new SUseGrowItemRes();
/* 246 */     res.addgrow = addGrow;
/* 247 */     res.petid = this.petId;
/* 248 */     int leftNum = petCfg.getGrowItemLimit() - xPet.getGrowitemusenum();
/* 249 */     if (leftNum < 0) {
/* 250 */       leftNum = 0;
/*     */     }
/* 252 */     res.growitemleft = leftNum;
/* 253 */     OnlineManager.getInstance().send(this.roleId, res);
/*     */     
/* 255 */     TLogManager.getInstance().addLog(this.roleId, "PetGrowthUse", PetManager.createTLog(new Object[] { mzm.gsp.GameServerInfoManager.getHostIP(), mzm.gsp.role.main.RoleInterface.getUserId(this.roleId), Long.valueOf(this.roleId), Long.valueOf(this.petId), Integer.valueOf(petCfg.getId()), Integer.valueOf(basicItem.getCfgId()), Float.valueOf(oldGrow), Float.valueOf(newGrow), Integer.valueOf(leftNum) }));
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
/* 267 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\PUsePetItemReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
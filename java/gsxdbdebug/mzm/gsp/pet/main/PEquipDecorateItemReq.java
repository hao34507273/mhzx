/*     */ package mzm.gsp.pet.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.item.confbean.SPetDecorateItemCfg;
/*     */ import mzm.gsp.item.main.BasicItem;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.pet.SPetNormalResult;
/*     */ import mzm.gsp.pet.event.PetDecorate;
/*     */ import mzm.gsp.pet.event.PetEventArg;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.Aptitude;
/*     */ import xbean.Item;
/*     */ import xbean.Pet;
/*     */ import xbean.PetBag;
/*     */ import xbean.PetEquipBag;
/*     */ import xtable.Role2petbag;
/*     */ 
/*     */ public class PEquipDecorateItemReq extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long petId;
/*     */   private final int itemKey;
/*     */   
/*     */   public PEquipDecorateItemReq(long roleId, long petId, int itemKey)
/*     */   {
/*  34 */     this.roleId = roleId;
/*  35 */     this.petId = petId;
/*  36 */     this.itemKey = itemKey;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  42 */     if (!PetManager.isPetSwitchOpenForRole(this.roleId)) {
/*  43 */       return false;
/*     */     }
/*     */     
/*  46 */     BasicItem itemInfo = ItemInterface.getItem(this.roleId, 340600000, this.itemKey);
/*  47 */     if (itemInfo == null) {
/*  48 */       return false;
/*     */     }
/*     */     
/*  51 */     SPetDecorateItemCfg cfg = SPetDecorateItemCfg.get(itemInfo.getCfgId());
/*  52 */     if ((cfg == null) || (cfg.type != 16)) {
/*  53 */       return false;
/*     */     }
/*     */     
/*  56 */     PetBag xPetBag = Role2petbag.get(Long.valueOf(this.roleId));
/*  57 */     if (xPetBag == null) {
/*  58 */       return false;
/*     */     }
/*  60 */     Pet xPet = (Pet)xPetBag.getPetmap().get(Long.valueOf(this.petId));
/*  61 */     if (xPet == null) {
/*  62 */       return false;
/*     */     }
/*  64 */     PetCfg petCfg = PetManager.getInstance().getPetCfg(xPet.getTemplateid());
/*  65 */     if (petCfg == null) {
/*  66 */       return false;
/*     */     }
/*  68 */     if (cfg.petCatchLevel != petCfg.getCarrayLevel()) {
/*  69 */       PetManager.logDebug("PEquipDecorateItemReq.processImp@carraylevel not match|roleid=%d|itemCatchLevel=%d|petCatchLevel=%d|petid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(cfg.petCatchLevel), Integer.valueOf(petCfg.getCarrayLevel()), Long.valueOf(this.petId) });
/*  70 */       return false;
/*     */     }
/*  72 */     if (cfg.id != petCfg.getPetDecorateId()) {
/*  73 */       SPetNormalResult normalResult = new SPetNormalResult();
/*  74 */       normalResult.result = 22;
/*  75 */       OnlineManager.getInstance().sendAtOnce(this.roleId, normalResult);
/*  76 */       return false;
/*     */     }
/*  78 */     xPet.setIsbinded(1);
/*     */     
/*  80 */     BasicItem item = ItemInterface.getAndRemoveItemInBag(this.roleId, this.itemKey, 1, new TLogArg(LogReason.PET_EQUIP_DECORATE_REM, itemInfo.getCfgId()));
/*  81 */     if (item == null) {
/*  82 */       PetManager.logDebug("PEquipDecorateItemReq.processImp@bag not have item|roleid=%d|itemid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemKey) });
/*  83 */       return false;
/*     */     }
/*  85 */     Item xItem = item.getItem();
/*  86 */     PetEquipBag xPetEquipBag = xPet.getEquipbag();
/*  87 */     xPetEquipBag.getEquip2item().put(Integer.valueOf(3), xItem);
/*     */     
/*  89 */     for (Map.Entry<Integer, Integer> aptEntry : xPet.getAptitude().getAptmap().entrySet()) {
/*  90 */       xPet.getAptitude().getAptmap().put(aptEntry.getKey(), Integer.valueOf(((Integer)aptEntry.getValue()).intValue() + cfg.addRealAptMaxLimit));
/*     */     }
/*     */     
/*  93 */     PetOutFightObj pet = new PetOutFightObj(this.roleId, xPet);
/*  94 */     pet.updateEquipment();
/*  95 */     pet.syncPetInfo();
/*  96 */     if (xPetBag.getShowpet() == this.petId) {
/*  97 */       PetEventArg arg = new PetEventArg();
/*  98 */       arg.petId = this.petId;
/*  99 */       arg.roleId = this.roleId;
/* 100 */       TriggerEventsManger.getInstance().triggerEvent(new PetDecorate(), arg);
/*     */     }
/* 102 */     SPetNormalResult normalResult = new SPetNormalResult();
/* 103 */     normalResult.result = 14;
/* 104 */     OnlineManager.getInstance().send(this.roleId, normalResult);
/*     */     
/*     */ 
/* 107 */     TLogManager.getInstance().addLog(this.roleId, "PetEquipItem", PetManager.createTLog(new Object[] { GameServerInfoManager.getHostIP(), RoleInterface.getUserId(this.roleId), Long.valueOf(this.roleId), Long.valueOf(this.petId), Long.valueOf(xPet.getId()), Integer.valueOf(item.getCfgId()), item.getFirstUuid(), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }));
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
/* 121 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\PEquipDecorateItemReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
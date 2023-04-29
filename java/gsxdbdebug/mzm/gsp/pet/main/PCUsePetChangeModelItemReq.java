/*     */ package mzm.gsp.pet.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.item.confbean.SItemPetChangeItemCfg;
/*     */ import mzm.gsp.item.main.BasicItem;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.pet.SPetNormalResult;
/*     */ import mzm.gsp.pet.SUsePetChangeModelItemSuccess;
/*     */ import mzm.gsp.pet.confbean.PetConstants;
/*     */ import mzm.gsp.pet.event.PetChangeModelEvent;
/*     */ import mzm.gsp.pet.event.PetChangeModelEventArg;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.role.main.RoleOneByOneManager;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import xbean.Pet;
/*     */ import xbean.PetBag;
/*     */ import xbean.Role2PetBean;
/*     */ import xtable.Role2petbag;
/*     */ 
/*     */ public class PCUsePetChangeModelItemReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long petId;
/*     */   private final int itemkey;
/*     */   
/*     */   public PCUsePetChangeModelItemReq(long roleId, long petId, int itemkey)
/*     */   {
/*  33 */     this.roleId = roleId;
/*  34 */     this.petId = petId;
/*  35 */     this.itemkey = itemkey;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  41 */     if (!PetManager.isPetSwitchOpenForRole(this.roleId)) {
/*  42 */       return false;
/*     */     }
/*     */     
/*  45 */     if (!PetManager.isPetChangeModelOpenForRole(this.roleId)) {
/*  46 */       return false;
/*     */     }
/*     */     
/*  49 */     PetBag xPetBag = Role2petbag.get(Long.valueOf(this.roleId));
/*  50 */     if (xPetBag == null) {
/*  51 */       PetManager.logDebug("PCUsePetChangeModelItemReq.processImp@ petbag error!|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*  52 */       return false;
/*     */     }
/*     */     
/*  55 */     Pet xPet = (Pet)xPetBag.getPetmap().get(Long.valueOf(this.petId));
/*  56 */     if (xPet == null) {
/*  57 */       PetManager.logDebug("PCUsePetChangeModelItemReq.processImp@ pet data error!|roleid=%d|petId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.petId) });
/*  58 */       return false;
/*     */     }
/*     */     
/*  61 */     if (xPet.getOwnextramodelcfgids().size() >= PetConstants.getInstance().OWN_MAX_EXTRA_MODEL_NUM)
/*     */     {
/*  63 */       SPetNormalResult normalResult = new SPetNormalResult();
/*  64 */       normalResult.result = 72;
/*  65 */       OnlineManager.getInstance().sendAtOnce(this.roleId, normalResult);
/*  66 */       PetManager.logDebug("PCUsePetChangeModelItemReq.processImp@pet own max extra model num!|roleid=%d|petId=%d|ownExtraModelNum=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.petId), Integer.valueOf(xPet.getOwnextramodelcfgids().size()) });
/*     */       
/*     */ 
/*  69 */       return false;
/*     */     }
/*     */     
/*  72 */     PetCfg petCfg = PetManager.getInstance().getPetCfg(xPet.getTemplateid());
/*  73 */     if (petCfg == null) {
/*  74 */       PetManager.logDebug("PCUsePetChangeModelItemReq.processImp@ pet cfg data error!|roleid=%d|petId=%d|petCfgId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.petId), Integer.valueOf(xPet.getTemplateid()) });
/*  75 */       return false;
/*     */     }
/*     */     
/*  78 */     int roleLevel = RoleInterface.getLevel(this.roleId);
/*  79 */     if (roleLevel < petCfg.getCarrayLevel()) {
/*  80 */       SPetNormalResult normalResult = new SPetNormalResult();
/*  81 */       normalResult.result = 67;
/*  82 */       OnlineManager.getInstance().sendAtOnce(this.roleId, normalResult);
/*  83 */       PetManager.logDebug("PCUsePetChangeModelItemReq.processImp@carry level error can not use item!|roleid=%d|petId=%d|petCfgId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.petId), Integer.valueOf(xPet.getTemplateid()) });
/*  84 */       return false;
/*     */     }
/*     */     
/*  87 */     if (petCfg.isWild()) {
/*  88 */       SPetNormalResult normalResult = new SPetNormalResult();
/*  89 */       normalResult.result = 47;
/*  90 */       OnlineManager.getInstance().sendAtOnce(this.roleId, normalResult);
/*  91 */       PetManager.logDebug("PCUsePetChangeModelItemReq.processImp@pet is wild can not use item!|roleid=%d|petId=%d|petCfgId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.petId), Integer.valueOf(xPet.getTemplateid()) });
/*  92 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  96 */     BasicItem basicItem = ItemInterface.getItem(this.roleId, this.itemkey);
/*  97 */     if (basicItem == null) {
/*  98 */       PetManager.logDebug("PCUsePetChangeModelItemReq.processImp@use item not existed|roleid=%d|itemid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemkey) });
/*  99 */       return false;
/*     */     }
/* 101 */     SItemPetChangeItemCfg sItemPetChangeItemCfg = SItemPetChangeItemCfg.get(basicItem.getCfgId());
/* 102 */     if (sItemPetChangeItemCfg == null) {
/* 103 */       PetManager.logDebug("PCUsePetChangeModelItemReq.processImp@use item not existed|roleid=%d|itemid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemkey) });
/* 104 */       return false;
/*     */     }
/*     */     
/* 107 */     if (xPet.getOwnextramodelcfgids().contains(Integer.valueOf(basicItem.getCfgId())))
/*     */     {
/* 109 */       SPetNormalResult normalResult = new SPetNormalResult();
/* 110 */       normalResult.result = 73;
/* 111 */       OnlineManager.getInstance().sendAtOnce(this.roleId, normalResult);
/* 112 */       PetManager.logDebug("PCUsePetChangeModelItemReq.processImp@pet own model already!|roleid=%d|petId=%d|itemCfgId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.petId), Integer.valueOf(basicItem.getCfgId()) });
/*     */       
/* 114 */       return false;
/*     */     }
/*     */     
/* 117 */     if ((sItemPetChangeItemCfg.cannotUseList.size() > 0) && (sItemPetChangeItemCfg.cannotUseList.contains(Integer.valueOf(xPet.getTemplateid())))) {
/* 118 */       SPetNormalResult normalResult = new SPetNormalResult();
/* 119 */       normalResult.result = 68;
/* 120 */       OnlineManager.getInstance().sendAtOnce(this.roleId, normalResult);
/* 121 */       PetManager.logDebug("PCUsePetChangeModelItemReq.processImp@use item not allow use with this pet!|roleid=%d|itemid=%d|petId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemkey), Long.valueOf(this.petId) });
/* 122 */       return false;
/*     */     }
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
/* 149 */     if (mzm.gsp.fight.main.FightInterface.isInFight(this.roleId))
/*     */     {
/* 151 */       Role2PetBean role2PetBean = xtable.Role2petoutfightbean.get(Long.valueOf(this.roleId));
/* 152 */       role2PetBean.setAction(this);
/* 153 */       SPetNormalResult normalResult = new SPetNormalResult();
/* 154 */       normalResult.result = 19;
/* 155 */       OnlineManager.getInstance().sendAtOnce(this.roleId, normalResult);
/* 156 */       PetManager.logDebug("PCUsePetChangeModelItemReq.processImp@ role in fight after fight use item!|roleid=%d|petId=%d|petCfgId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.petId), Integer.valueOf(xPet.getTemplateid()) });
/* 157 */       return true;
/*     */     }
/*     */     
/* 160 */     boolean removeFlag = ItemInterface.removeItemByUuid(this.roleId, basicItem.getFirstUuid().longValue(), 1, new TLogArg(mzm.gsp.tlog.LogReason.PET_STAGE_LEVEL_UP_REM, basicItem.getCfgId()));
/* 161 */     if (!removeFlag) {
/* 162 */       SPetNormalResult normalResult = new SPetNormalResult();
/* 163 */       normalResult.result = 69;
/* 164 */       OnlineManager.getInstance().sendAtOnce(this.roleId, normalResult);
/* 165 */       PetManager.logDebug("PCUsePetChangeModelItemReq.processImp@ remove use item error!|roleid=%d|petId=%d|itemId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.petId), basicItem.getFirstUuid() });
/* 166 */       return false;
/*     */     }
/*     */     
/* 169 */     xPet.setExtramodelcfgid(basicItem.getCfgId());
/* 170 */     xPet.getOwnextramodelcfgids().add(Integer.valueOf(basicItem.getCfgId()));
/*     */     
/* 172 */     PetOutFightObj petOutFightObj = new PetOutFightObj(this.roleId, xPet);
/* 173 */     petOutFightObj.updateOutFightProperty();
/* 174 */     petOutFightObj.syncPetInfo();
/*     */     
/* 176 */     SPetNormalResult normalResult = new SPetNormalResult();
/* 177 */     normalResult.result = 52;
/* 178 */     OnlineManager.getInstance().sendAtOnce(this.roleId, normalResult);
/*     */     
/*     */ 
/*     */ 
/* 182 */     SUsePetChangeModelItemSuccess sUsePetChangeModelItemSuccess = new SUsePetChangeModelItemSuccess();
/* 183 */     sUsePetChangeModelItemSuccess.pet_id = this.petId;
/* 184 */     OnlineManager.getInstance().send(this.roleId, sUsePetChangeModelItemSuccess);
/*     */     
/*     */ 
/* 187 */     PetChangeModelEventArg arg = new PetChangeModelEventArg();
/* 188 */     arg.roleId = this.roleId;
/* 189 */     arg.petId = this.petId;
/* 190 */     arg.changeModelId = sItemPetChangeItemCfg.modelId;
/* 191 */     arg.colorId = sItemPetChangeItemCfg.colorId;
/* 192 */     arg.outlookId = sItemPetChangeItemCfg.modelFigureCfgId;
/*     */     
/* 194 */     TriggerEventsManger.getInstance().triggerEvent(new PetChangeModelEvent(), arg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.roleId)));
/*     */     
/*     */ 
/* 197 */     TLogManager.getInstance().addLog(this.roleId, "PetUseModelChangeItemTLog", PetManager.createTLog(new Object[] { GameServerInfoManager.getHostIP(), RoleInterface.getUserId(this.roleId), Long.valueOf(this.roleId), Long.valueOf(this.petId), Integer.valueOf(petCfg.getId()), basicItem.getFirstUuid(), Integer.valueOf(basicItem.getCfgId()) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 207 */     PetManager.logInfo("PCGetPetModelItemReq.processImp@use pet model item success!|" + this.roleId + "|" + this.petId + "|" + basicItem.getFirstUuid(), new Object[0]);
/* 208 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\PCUsePetChangeModelItemReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
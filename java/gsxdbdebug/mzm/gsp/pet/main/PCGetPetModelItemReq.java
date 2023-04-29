/*     */ package mzm.gsp.pet.main;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.fight.main.FightInterface;
/*     */ import mzm.gsp.item.confbean.SItemPetChangeItemCfg;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.ItemOperateResult;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.pet.SPetNormalResult;
/*     */ import mzm.gsp.pet.SSyncPetStateChange;
/*     */ import mzm.gsp.pet.confbean.PetGetHuiJuanItemCostCfg;
/*     */ import mzm.gsp.pet.event.PetEventArg;
/*     */ import mzm.gsp.pet.event.PlayerDeletePet;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.role.main.RoleOneByOneManager;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.Pet;
/*     */ import xbean.PetBag;
/*     */ import xtable.Role2petbag;
/*     */ 
/*     */ public class PCGetPetModelItemReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long petId;
/*     */   private final int iscostyuanbao;
/*     */   private final long curyuanbao;
/*     */   private final int costyuanbao;
/*     */   
/*     */   public PCGetPetModelItemReq(long roleId, long petId, int iscostyuanbao, long curyuanbao, int costyuanbao)
/*     */   {
/*  40 */     this.roleId = roleId;
/*  41 */     this.petId = petId;
/*  42 */     this.iscostyuanbao = iscostyuanbao;
/*  43 */     this.curyuanbao = curyuanbao;
/*  44 */     this.costyuanbao = costyuanbao;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  50 */     if (!PetManager.isPetSwitchOpenForRole(this.roleId)) {
/*  51 */       return false;
/*     */     }
/*     */     
/*  54 */     if (!PetManager.isPetChangeModelOpenForRole(this.roleId)) {
/*  55 */       return false;
/*     */     }
/*     */     
/*  58 */     if (PetFightInterface.isPetInDefenseTeam(this.roleId, this.petId, false))
/*     */     {
/*  60 */       SPetNormalResult p = new SPetNormalResult();
/*  61 */       p.result = 300;
/*  62 */       OnlineManager.getInstance().sendAtOnce(this.roleId, p);
/*  63 */       PetManager.logDebug("PCGetPetModelItemReq.processImp()@last pet in defense team|roleid=%d|petid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.petId) });
/*     */       
/*  65 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  69 */     String userid = RoleInterface.getUserId(this.roleId);
/*     */     
/*  71 */     if (this.curyuanbao != QingfuInterface.getBalance(userid, true)) {
/*  72 */       PetManager.logDebug("PCGetPetModelItemReq.processImp@PCGetPetModelItemReq yuanbaonum not match|roleid=%d|cyuanbao=%d|syuanbao=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.curyuanbao), Long.valueOf(QingfuInterface.getBalance(userid, true)) });
/*  73 */       return false;
/*     */     }
/*     */     
/*  76 */     PetBag xPetBag = Role2petbag.get(Long.valueOf(this.roleId));
/*  77 */     if (xPetBag == null) {
/*  78 */       PetManager.logDebug("PCGetPetModelItemReq.processImp@ petbag error!|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*  79 */       return false;
/*     */     }
/*     */     
/*  82 */     Pet xPet = (Pet)xPetBag.getPetmap().get(Long.valueOf(this.petId));
/*  83 */     if (xPet == null) {
/*  84 */       PetManager.logDebug("PCGetPetModelItemReq.processImp@ pet data error!|roleid=%d|petId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.petId) });
/*  85 */       return false;
/*     */     }
/*     */     
/*  88 */     if (xPet.getExtramodelcfgid() != 0) {
/*  89 */       SPetNormalResult normalResult = new SPetNormalResult();
/*  90 */       normalResult.result = 63;
/*  91 */       OnlineManager.getInstance().sendAtOnce(this.roleId, normalResult);
/*  92 */       PetManager.logDebug("PCGetPetModelItemReq.processImp@pet is model changed can not get item!|roleid=%d|petId=%d|petCfgId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.petId), Integer.valueOf(xPet.getTemplateid()) });
/*  93 */       return false;
/*     */     }
/*  95 */     PetCfg petCfg = PetManager.getInstance().getPetCfg(xPet.getTemplateid());
/*  96 */     if (petCfg == null) {
/*  97 */       PetManager.logDebug("PCGetPetModelItemReq.processImp@ pet cfg data error!|roleid=%d|petId=%d|petCfgId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.petId), Integer.valueOf(xPet.getTemplateid()) });
/*  98 */       return false;
/*     */     }
/*     */     
/* 101 */     int roleLevel = RoleInterface.getLevel(this.roleId);
/* 102 */     if (roleLevel < petCfg.getCarrayLevel()) {
/* 103 */       SPetNormalResult normalResult = new SPetNormalResult();
/* 104 */       normalResult.result = 62;
/* 105 */       OnlineManager.getInstance().sendAtOnce(this.roleId, normalResult);
/* 106 */       PetManager.logDebug("PCGetPetModelItemReq.processImp@carry level error can not get item!|roleid=%d|petId=%d|petCfgId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.petId), Integer.valueOf(xPet.getTemplateid()) });
/* 107 */       return false;
/*     */     }
/*     */     
/* 110 */     if (petCfg.isWild()) {
/* 111 */       SPetNormalResult normalResult = new SPetNormalResult();
/* 112 */       normalResult.result = 40;
/* 113 */       OnlineManager.getInstance().sendAtOnce(this.roleId, normalResult);
/* 114 */       PetManager.logDebug("PCGetPetModelItemReq.processImp@pet is wild can not get item!|roleid=%d|petId=%d|petCfgId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.petId), Integer.valueOf(xPet.getTemplateid()) });
/* 115 */       return false;
/*     */     }
/*     */     
/* 118 */     if (FightInterface.isInFight(this.roleId)) {
/* 119 */       SPetNormalResult normalResult = new SPetNormalResult();
/* 120 */       normalResult.result = 43;
/* 121 */       OnlineManager.getInstance().sendAtOnce(this.roleId, normalResult);
/* 122 */       PetManager.logDebug("PCGetPetModelItemReq.processImp@ role in fight can not get item!|roleid=%d|petId=%d|petCfgId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.petId), Integer.valueOf(xPet.getTemplateid()) });
/* 123 */       return false;
/*     */     }
/*     */     
/* 126 */     if (xPetBag.getFightpet() == xPet.getId()) {
/* 127 */       SPetNormalResult normalResult = new SPetNormalResult();
/* 128 */       normalResult.result = 44;
/* 129 */       OnlineManager.getInstance().sendAtOnce(this.roleId, normalResult);
/* 130 */       PetManager.logDebug("PCGetPetModelItemReq.processImp@ pet in fight can not get item!|roleid=%d|petId=%d|petCfgId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.petId), Integer.valueOf(xPet.getTemplateid()) });
/* 131 */       return false;
/*     */     }
/*     */     
/* 134 */     if (xPetBag.getShowpet() == xPet.getId()) {
/* 135 */       SPetNormalResult normalResult = new SPetNormalResult();
/* 136 */       normalResult.result = 45;
/* 137 */       OnlineManager.getInstance().sendAtOnce(this.roleId, normalResult);
/* 138 */       PetManager.logDebug("PCGetPetModelItemReq.processImp@ pet in show can not get item!|roleid=%d|petId=%d|petCfgId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.petId), Integer.valueOf(xPet.getTemplateid()) });
/* 139 */       return false;
/*     */     }
/*     */     
/* 142 */     SItemPetChangeItemCfg sItemPetChangeItemCfg = SItemPetChangeItemCfg.get(petCfg.getHuiJuanItemId());
/* 143 */     if (sItemPetChangeItemCfg == null) {
/* 144 */       PetManager.logDebug("PCGetPetModelItemReq.processImp@ SItemPetChangeItemCfg error!|roleid=%d|petId=%d|petCfgId=%d|huijuanitemCfgId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.petId), Integer.valueOf(xPet.getTemplateid()), Integer.valueOf(petCfg.getHuiJuanItemId()) });
/* 145 */       return false;
/*     */     }
/*     */     
/* 148 */     PetGetHuiJuanItemCostCfg petGetHuiJuanItemCostCfg = null;
/* 149 */     for (PetGetHuiJuanItemCostCfg costCfg : PetGetHuiJuanItemCostCfg.getAll().values()) {
/* 150 */       if (costCfg.petType == petCfg.getPetType()) {
/* 151 */         petGetHuiJuanItemCostCfg = costCfg;
/*     */       }
/*     */     }
/* 154 */     if (petGetHuiJuanItemCostCfg == null) {
/* 155 */       PetManager.logDebug("PCGetPetModelItemReq.processImp@ PetGetHuiJuanItemCostCfg error!|roleid=%d|petId=%d|petCfgId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.petId), Integer.valueOf(xPet.getTemplateid()) });
/* 156 */       return false;
/*     */     }
/*     */     
/* 159 */     int curItemNum = ItemInterface.getItemNumberByType(this.roleId, 340600000, petGetHuiJuanItemCostCfg.costType, true);
/* 160 */     int costNum = 0;
/* 161 */     int costYuanbao = 0;
/* 162 */     if (this.iscostyuanbao == 1) {
/* 163 */       notifyNormalFail(71);
/* 164 */       return false;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 200 */     if (curItemNum < petGetHuiJuanItemCostCfg.costNum) {
/* 201 */       SPetNormalResult normalResult = new SPetNormalResult();
/* 202 */       normalResult.result = 41;
/* 203 */       OnlineManager.getInstance().sendAtOnce(this.roleId, normalResult);
/* 204 */       return false;
/*     */     }
/*     */     
/* 207 */     if (!ItemInterface.removeItemsByType(this.roleId, petGetHuiJuanItemCostCfg.costType, petGetHuiJuanItemCostCfg.costNum, new TLogArg(LogReason.PET_GET_CHANGE_MODEL_REM, petGetHuiJuanItemCostCfg.costType))) {
/* 208 */       PetManager.logDebug("PCGetPetModelItemReq.processImp@not have item with itemNum!|" + petGetHuiJuanItemCostCfg.costNum + "|" + petGetHuiJuanItemCostCfg.costType + "|" + this.roleId + "|" + this.petId, new Object[0]);
/* 209 */       SPetNormalResult normalResult = new SPetNormalResult();
/* 210 */       normalResult.result = 37;
/* 211 */       OnlineManager.getInstance().sendAtOnce(this.roleId, normalResult);
/* 212 */       return false;
/*     */     }
/* 214 */     costNum = petGetHuiJuanItemCostCfg.costNum;
/*     */     
/*     */ 
/* 217 */     Pet xDelPet = (Pet)xPetBag.getPetmap().remove(Long.valueOf(this.petId));
/* 218 */     if (xDelPet == null) {
/* 219 */       PetManager.logDebug("PCGetPetModelItemReq.processImp@delete pet error!|" + this.roleId + "|" + this.petId, new Object[0]);
/* 220 */       return false;
/*     */     }
/*     */     
/* 223 */     ItemOperateResult itemOperateResult = ItemInterface.addItem(this.roleId, petCfg.getHuiJuanItemId(), 1, new TLogArg(LogReason.PET_GET_CHANGE_MODEL_ADD, petCfg.getHuiJuanItemId()));
/* 224 */     if (!itemOperateResult.success()) {
/* 225 */       SPetNormalResult normalResult = new SPetNormalResult();
/* 226 */       normalResult.result = 66;
/* 227 */       OnlineManager.getInstance().sendAtOnce(this.roleId, normalResult);
/* 228 */       return false;
/*     */     }
/*     */     
/* 231 */     Set<Long> itemSet = (Set)itemOperateResult.getChangedItemId2Uuids().get(Integer.valueOf(petCfg.getHuiJuanItemId()));
/* 232 */     Long itemId = (Long)itemSet.iterator().next();
/* 233 */     if (itemId == null) {
/* 234 */       SPetNormalResult normalResult = new SPetNormalResult();
/* 235 */       normalResult.result = 66;
/* 236 */       OnlineManager.getInstance().sendAtOnce(this.roleId, normalResult);
/* 237 */       return false;
/*     */     }
/*     */     
/* 240 */     PetEventArg arg = new PetEventArg();
/* 241 */     arg.roleId = this.roleId;
/* 242 */     arg.petId = this.petId;
/* 243 */     arg.enventType = PetDeleteTLogEnum.GET_MODEL.value;
/* 244 */     TriggerEventsManger.getInstance().triggerEvent(new PlayerDeletePet(), arg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.roleId)));
/*     */     
/* 246 */     PetManager.addPetDeleteTlog(this.roleId, this.petId, petCfg.getId(), PetDeleteTLogEnum.GET_MODEL);
/*     */     
/* 248 */     TLogManager.getInstance().addLog(this.roleId, "PetGetModelItemTLog", PetManager.createTLog(new Object[] { GameServerInfoManager.getHostIP(), RoleInterface.getUserId(this.roleId), Long.valueOf(this.roleId), Long.valueOf(this.petId), Integer.valueOf(petCfg.getId()), Integer.valueOf(petGetHuiJuanItemCostCfg.costType), Integer.valueOf(costNum), Long.valueOf(itemId.longValue()), Integer.valueOf(petCfg.getHuiJuanItemId()), Integer.valueOf(costYuanbao) }));
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
/* 261 */     SPetNormalResult normalResult = new SPetNormalResult();
/* 262 */     normalResult.result = 46;
/* 263 */     OnlineManager.getInstance().sendAtOnce(this.roleId, normalResult);
/*     */     
/* 265 */     SSyncPetStateChange petStateChange = new SSyncPetStateChange();
/* 266 */     petStateChange.petid = this.petId;
/* 267 */     petStateChange.state = 2;
/* 268 */     OnlineManager.getInstance().send(this.roleId, petStateChange);
/*     */     
/* 270 */     PetManager.logInfo("PCGetPetModelItemReq.processImp@get pet model item success!|" + this.roleId + "|" + this.petId, new Object[0]);
/*     */     
/* 272 */     return true;
/*     */   }
/*     */   
/*     */   private void notifyNormalFail(int ret)
/*     */   {
/* 277 */     SPetNormalResult normalResult = new SPetNormalResult();
/* 278 */     normalResult.result = ret;
/* 279 */     OnlineManager.getInstance().sendAtOnce(this.roleId, normalResult);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\PCGetPetModelItemReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
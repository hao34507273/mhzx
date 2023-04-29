/*     */ package mzm.gsp.pet.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.fight.main.FightInterface;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.pet.SPetNormalResult;
/*     */ import mzm.gsp.pet.confbean.PetConstants;
/*     */ import mzm.gsp.pet.event.PetUnChangeModelEvent;
/*     */ import mzm.gsp.pet.event.PetUnChangeModelEventArg;
/*     */ import mzm.gsp.qingfu.main.CostResult;
/*     */ import mzm.gsp.qingfu.main.CostType;
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
/*     */ public class PCCancelPetModelChangeItemReq extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long petId;
/*     */   private final int iscostyuanbao;
/*     */   private final long curyuanbao;
/*     */   private final int costyuanbao;
/*     */   
/*     */   public PCCancelPetModelChangeItemReq(long roleId, long petId, int iscostyuanbao, long curyuanbao, int costyuanbao)
/*     */   {
/*  36 */     this.roleId = roleId;
/*  37 */     this.petId = petId;
/*  38 */     this.iscostyuanbao = iscostyuanbao;
/*  39 */     this.curyuanbao = curyuanbao;
/*  40 */     this.costyuanbao = costyuanbao;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  46 */     if (!PetManager.isPetSwitchOpenForRole(this.roleId)) {
/*  47 */       return false;
/*     */     }
/*     */     
/*  50 */     if (!PetManager.isPetChangeModelOpenForRole(this.roleId)) {
/*  51 */       return false;
/*     */     }
/*     */     
/*  54 */     String userid = RoleInterface.getUserId(this.roleId);
/*     */     
/*  56 */     if (this.curyuanbao != QingfuInterface.getBalance(userid, true)) {
/*  57 */       PetManager.logDebug("PCCancelPetModelChangeItemReq.processImp@PCGetPetModelItemReq yuanbaonum not match|roleid=%d|cyuanbao=%d|syuanbao=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.curyuanbao), Long.valueOf(QingfuInterface.getBalance(userid, true)) });
/*  58 */       return false;
/*     */     }
/*     */     
/*  61 */     PetBag xPetBag = Role2petbag.get(Long.valueOf(this.roleId));
/*  62 */     if (xPetBag == null) {
/*  63 */       PetManager.logDebug("PCCancelPetModelChangeItemReq.processImp@ petbag error!|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*  64 */       return false;
/*     */     }
/*     */     
/*  67 */     Pet xPet = (Pet)xPetBag.getPetmap().get(Long.valueOf(this.petId));
/*  68 */     if (xPet == null) {
/*  69 */       PetManager.logDebug("PCCancelPetModelChangeItemReq.processImp@ pet data error!|roleid=%d|petId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.petId) });
/*  70 */       return false;
/*     */     }
/*     */     
/*  73 */     if (xPet.getExtramodelcfgid() == 0) {
/*  74 */       SPetNormalResult normalResult = new SPetNormalResult();
/*  75 */       normalResult.result = 53;
/*  76 */       OnlineManager.getInstance().sendAtOnce(this.roleId, normalResult);
/*  77 */       PetManager.logDebug("PCCancelPetModelChangeItemReq.processImp@pet is not model changed can not cancel!|roleid=%d|petId=%d|petCfgId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.petId), Integer.valueOf(xPet.getTemplateid()) });
/*  78 */       return false;
/*     */     }
/*  80 */     PetCfg petCfg = PetManager.getInstance().getPetCfg(xPet.getTemplateid());
/*  81 */     if (petCfg == null) {
/*  82 */       PetManager.logDebug("PCCancelPetModelChangeItemReq.processImp@ pet cfg data error!|roleid=%d|petId=%d|petCfgId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.petId), Integer.valueOf(xPet.getTemplateid()) });
/*  83 */       return false;
/*     */     }
/*     */     
/*  86 */     int roleLevel = RoleInterface.getLevel(this.roleId);
/*  87 */     if (roleLevel < petCfg.getCarrayLevel()) {
/*  88 */       SPetNormalResult normalResult = new SPetNormalResult();
/*  89 */       normalResult.result = 70;
/*  90 */       OnlineManager.getInstance().sendAtOnce(this.roleId, normalResult);
/*  91 */       PetManager.logDebug("PCCancelPetModelChangeItemReq.processImp@carry level error can not cannel model change!|roleid=%d|petId=%d|petCfgId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.petId), Integer.valueOf(xPet.getTemplateid()) });
/*  92 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  96 */     if (FightInterface.isInFight(this.roleId)) {
/*  97 */       SPetNormalResult normalResult = new SPetNormalResult();
/*  98 */       normalResult.result = 56;
/*  99 */       OnlineManager.getInstance().sendAtOnce(this.roleId, normalResult);
/* 100 */       PetManager.logDebug("PCCancelPetModelChangeItemReq.processImp@ role in fight can not cannel model change!|roleid=%d|petId=%d|petCfgId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.petId), Integer.valueOf(xPet.getTemplateid()) });
/* 101 */       return false;
/*     */     }
/*     */     
/* 104 */     if (xPetBag.getFightpet() == xPet.getId()) {
/* 105 */       SPetNormalResult normalResult = new SPetNormalResult();
/* 106 */       normalResult.result = 57;
/* 107 */       OnlineManager.getInstance().sendAtOnce(this.roleId, normalResult);
/* 108 */       PetManager.logDebug("PCCancelPetModelChangeItemReq.processImp@ pet in fight can not cannel model change!|roleid=%d|petId=%d|petCfgId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.petId), Integer.valueOf(xPet.getTemplateid()) });
/* 109 */       return false;
/*     */     }
/*     */     
/* 112 */     if (xPetBag.getShowpet() == xPet.getId()) {
/* 113 */       SPetNormalResult normalResult = new SPetNormalResult();
/* 114 */       normalResult.result = 58;
/* 115 */       OnlineManager.getInstance().sendAtOnce(this.roleId, normalResult);
/* 116 */       PetManager.logDebug("PCCancelPetModelChangeItemReq.processImp@ pet in show can not cannel model change!|roleid=%d|petId=%d|petCfgId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.petId), Integer.valueOf(xPet.getTemplateid()) });
/* 117 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 121 */     int curItemNum = ItemInterface.getItemNumberById(this.roleId, 340600000, PetConstants.getInstance().CANCEL_PET_CHANGEMODEL_ITEM_ID, true);
/* 122 */     int costNum = 0;
/* 123 */     int costYuanbao = 0;
/* 124 */     if (this.iscostyuanbao == 1) {
/* 125 */       if (curItemNum < PetConstants.getInstance().CANCEL_PET_CHANGEMODEL_ITEM_COST_NUM) {
/* 126 */         costNum = curItemNum;
/* 127 */         int yuanbaoNum = (PetConstants.getInstance().CANCEL_PET_CHANGEMODEL_ITEM_COST_NUM - curItemNum) * ItemInterface.getItemYuanBaoPrice(PetConstants.getInstance().CANCEL_PET_CHANGEMODEL_ITEM_ID);
/* 128 */         if (yuanbaoNum != this.costyuanbao) {
/* 129 */           PetManager.logDebug("PCCancelPetModelChangeItemReq.processImp@costyuanbao not equal to real cost yuanbao!|" + this.roleId + "|" + this.petId, new Object[0]);
/* 130 */           SPetNormalResult normalResult = new SPetNormalResult();
/* 131 */           normalResult.result = 61;
/* 132 */           OnlineManager.getInstance().sendAtOnce(this.roleId, normalResult);
/* 133 */           return false;
/*     */         }
/*     */         
/*     */ 
/* 137 */         if (QingfuInterface.costYuanbao(userid, this.roleId, yuanbaoNum, CostType.COST_BIND_FIRST_PET_CANCEL_MODEL_CHANGE, new TLogArg(LogReason.PET_CANCEL_CHANGE_MODEL_REM, yuanbaoNum)) != CostResult.Success) {
/* 138 */           PetManager.logDebug("PCCancelPetModelChangeItemReq.processImp@yuanbao not enough|roleid=%d|yuanbaoNum=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(yuanbaoNum) });
/* 139 */           return false;
/*     */         }
/* 141 */         if (costNum > 0)
/*     */         {
/* 143 */           if (!ItemInterface.removeItemById(this.roleId, PetConstants.getInstance().CANCEL_PET_CHANGEMODEL_ITEM_ID, costNum, new TLogArg(LogReason.PET_CANCEL_CHANGE_MODEL_REM, PetConstants.getInstance().CANCEL_PET_CHANGEMODEL_ITEM_ID))) {
/* 144 */             PetManager.logDebug("PCCancelPetModelChangeItemReq.processImp@not have item with itemNum!|" + PetConstants.getInstance().CANCEL_PET_CHANGEMODEL_ITEM_COST_NUM + "|" + PetConstants.getInstance().CANCEL_PET_CHANGEMODEL_ITEM_ID + "|" + this.roleId + "|" + this.petId, new Object[0]);
/* 145 */             SPetNormalResult normalResult = new SPetNormalResult();
/* 146 */             normalResult.result = 54;
/* 147 */             OnlineManager.getInstance().sendAtOnce(this.roleId, normalResult);
/* 148 */             return false;
/*     */           }
/*     */         }
/*     */       } else {
/* 152 */         PetManager.logDebug("PCCancelPetModelChangeItemReq.processImp@costitem not enough and not use yuanbao!|" + this.roleId + "|" + this.petId, new Object[0]);
/* 153 */         SPetNormalResult normalResult = new SPetNormalResult();
/* 154 */         normalResult.result = 64;
/* 155 */         OnlineManager.getInstance().sendAtOnce(this.roleId, normalResult);
/* 156 */         return false;
/*     */       }
/*     */     } else {
/* 159 */       if (curItemNum < PetConstants.getInstance().CANCEL_PET_CHANGEMODEL_ITEM_COST_NUM) {
/* 160 */         SPetNormalResult normalResult = new SPetNormalResult();
/* 161 */         normalResult.result = 54;
/* 162 */         OnlineManager.getInstance().sendAtOnce(this.roleId, normalResult);
/* 163 */         return false;
/*     */       }
/*     */       
/* 166 */       if (!ItemInterface.removeItemById(this.roleId, PetConstants.getInstance().CANCEL_PET_CHANGEMODEL_ITEM_ID, PetConstants.getInstance().CANCEL_PET_CHANGEMODEL_ITEM_COST_NUM, new TLogArg(LogReason.PET_CANCEL_CHANGE_MODEL_REM, PetConstants.getInstance().CANCEL_PET_CHANGEMODEL_ITEM_ID))) {
/* 167 */         PetManager.logDebug("PCCancelPetModelChangeItemReq.processImp@not have item with itemNum!|" + PetConstants.getInstance().CANCEL_PET_CHANGEMODEL_ITEM_COST_NUM + "|" + PetConstants.getInstance().CANCEL_PET_CHANGEMODEL_ITEM_ID + "|" + this.roleId + "|" + this.petId, new Object[0]);
/* 168 */         SPetNormalResult normalResult = new SPetNormalResult();
/* 169 */         normalResult.result = 54;
/* 170 */         OnlineManager.getInstance().sendAtOnce(this.roleId, normalResult);
/* 171 */         return false;
/*     */       }
/* 173 */       costNum = PetConstants.getInstance().CANCEL_PET_CHANGEMODEL_ITEM_COST_NUM;
/*     */     }
/*     */     
/* 176 */     xPet.setExtramodelcfgid(0);
/*     */     
/*     */ 
/* 179 */     PetOutFightObj petOutFightObj = new PetOutFightObj(this.roleId, xPet);
/* 180 */     petOutFightObj.updateOutFightProperty();
/* 181 */     petOutFightObj.syncPetInfo();
/*     */     
/* 183 */     SPetNormalResult normalResult = new SPetNormalResult();
/* 184 */     normalResult.result = 59;
/* 185 */     OnlineManager.getInstance().sendAtOnce(this.roleId, normalResult);
/*     */     
/* 187 */     PetUnChangeModelEventArg arg = new PetUnChangeModelEventArg();
/* 188 */     arg.roleId = this.roleId;
/* 189 */     arg.petId = this.petId;
/* 190 */     TriggerEventsManger.getInstance().triggerEvent(new PetUnChangeModelEvent(), arg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.roleId)));
/*     */     
/*     */ 
/* 193 */     TLogManager.getInstance().addLog(this.roleId, "PetCancelModelChangeItemTLog", PetManager.createTLog(new Object[] { GameServerInfoManager.getHostIP(), RoleInterface.getUserId(this.roleId), Long.valueOf(this.roleId), Long.valueOf(this.petId), Integer.valueOf(petCfg.getId()), Integer.valueOf(PetConstants.getInstance().CANCEL_PET_CHANGEMODEL_ITEM_ID), Integer.valueOf(costNum), Integer.valueOf(costYuanbao) }));
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
/* 204 */     PetManager.logInfo("PCCancelPetModelChangeItemReq.processImp@cancel pet model change success!|" + this.roleId + "|" + this.petId + "|" + PetConstants.getInstance().CANCEL_PET_CHANGEMODEL_ITEM_ID, new Object[0]);
/* 205 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\PCCancelPetModelChangeItemReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
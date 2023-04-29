/*     */ package mzm.gsp.pet.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.item.main.ItemBanTrade;
/*     */ import mzm.gsp.item.main.ItemBanTrade.TradeTypeEnum;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.pet.SPetNormalResult;
/*     */ import mzm.gsp.pet.SSellPetRes;
/*     */ import mzm.gsp.pet.SSyncPetStateChange;
/*     */ import mzm.gsp.pet.confbean.PetShopConstants;
/*     */ import mzm.gsp.pet.event.PetEventArg;
/*     */ import mzm.gsp.pet.event.PlayerDeletePet;
/*     */ import mzm.gsp.pet.event.PlayerShowPetChange;
/*     */ import mzm.gsp.role.main.ModMoneyResult;
/*     */ import mzm.gsp.role.main.ModMoneyResult.ErrorResult;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.Pet;
/*     */ import xbean.PetBag;
/*     */ import xbean.PetShopBean;
/*     */ import xbean.Pod;
/*     */ import xtable.Role2petbag;
/*     */ import xtable.Role2petshop;
/*     */ 
/*     */ public class PSellPetReq extends LogicProcedure
/*     */ {
/*     */   private static final int SELL_BASE_RATE = 10000;
/*     */   private long roleId;
/*     */   private long petId;
/*     */   
/*     */   public PSellPetReq(long roleId, long petId)
/*     */   {
/*  36 */     this.roleId = roleId;
/*  37 */     this.petId = petId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  43 */     if (!PetManager.isPetSwitchOpenForRole(this.roleId)) {
/*  44 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  48 */     PetShopBean xPetShopBean = Role2petshop.get(Long.valueOf(this.roleId));
/*  49 */     if (xPetShopBean == null) {
/*  50 */       xPetShopBean = Pod.newPetShopBean();
/*     */     }
/*  52 */     long inNow = System.currentTimeMillis();
/*  53 */     long inTimestamp = PetManager.getBeginningOfDay(xPetShopBean.getTimestamp()) + 86400000L;
/*  54 */     if (inNow > inTimestamp) {
/*  55 */       xPetShopBean.setSellcount(0);
/*  56 */       xPetShopBean.setTimestamp(inNow);
/*     */     }
/*     */     
/*  59 */     if (xPetShopBean.getSellcount() >= PetShopConstants.getInstance().SELL_PER_DAY_LIMIT) {
/*  60 */       SPetNormalResult result = new SPetNormalResult();
/*  61 */       result.result = 17;
/*  62 */       OnlineManager.getInstance().sendAtOnce(this.roleId, result);
/*  63 */       return false;
/*     */     }
/*  65 */     xPetShopBean.setSellcount(xPetShopBean.getSellcount() + 1);
/*  66 */     PetBag xPetBag = Role2petbag.get(Long.valueOf(this.roleId));
/*  67 */     Pet xPet = (Pet)xPetBag.getPetmap().get(Long.valueOf(this.petId));
/*  68 */     if (xPet == null) {
/*  69 */       return false;
/*     */     }
/*  71 */     PetCfg petCfg = PetManager.getInstance().getPetCfg(xPet.getTemplateid());
/*  72 */     if (petCfg == null) {
/*  73 */       return false;
/*     */     }
/*  75 */     if (!PetManager.getInstance().isInShop(xPet.getTemplateid())) {
/*  76 */       return false;
/*     */     }
/*  78 */     if (petCfg.getPetType() != 0) {
/*  79 */       return false;
/*     */     }
/*     */     
/*  82 */     if (ItemBanTrade.getInstance().isBanTrade(ItemBanTrade.TradeTypeEnum.PET_SHOP.value, xPet.getTemplateid())) {
/*  83 */       ItemBanTrade.getInstance().sendTipToTole(this.roleId, petCfg.getName());
/*  84 */       return false;
/*     */     }
/*     */     
/*  87 */     if (this.petId == xPetBag.getFightpet()) {
/*  88 */       return false;
/*     */     }
/*  90 */     int sellPrice = (int)(PetShopConstants.getInstance().SELL_2_BUY_RATE * petCfg.getBuyPrice() / 10000L);
/*     */     
/*  92 */     ModMoneyResult addSRes = RoleInterface.addSilverWithinMax(this.roleId, sellPrice, new TLogArg(LogReason.PET_SELL_ADD));
/*  93 */     if (!addSRes.isSucceed()) {
/*  94 */       if (addSRes.getRes() == ModMoneyResult.ErrorResult.ERROR_MONEY_NUM_HAS_REACH_TOP_LIMIT) {
/*  95 */         SPetNormalResult result = new SPetNormalResult();
/*  96 */         result.result = 23;
/*  97 */         OnlineManager.getInstance().sendAtOnce(this.roleId, result);
/*     */       }
/*  99 */       return false;
/*     */     }
/* 101 */     xPetBag.getPetmap().remove(Long.valueOf(this.petId));
/* 102 */     if (this.petId == xPetBag.getShowpet()) {
/* 103 */       xPetBag.setShowpet(-1L);
/* 104 */       SSyncPetStateChange change = new SSyncPetStateChange();
/* 105 */       change.petid = this.petId;
/* 106 */       change.state = 4;
/* 107 */       OnlineManager.getInstance().send(this.roleId, change);
/* 108 */       PetEventArg arg = new PetEventArg();
/* 109 */       arg.petId = this.petId;
/* 110 */       arg.roleId = this.roleId;
/* 111 */       TriggerEventsManger.getInstance().triggerEvent(new PlayerShowPetChange(), arg);
/*     */     }
/* 113 */     SSyncPetStateChange change = new SSyncPetStateChange();
/* 114 */     change.petid = this.petId;
/* 115 */     change.state = 2;
/* 116 */     OnlineManager.getInstance().send(this.roleId, change);
/* 117 */     SSellPetRes res = new SSellPetRes();
/* 118 */     res.addmoney = sellPrice;
/* 119 */     res.petcfgid = petCfg.getId();
/* 120 */     OnlineManager.getInstance().send(this.roleId, res);
/*     */     
/* 122 */     PetManager.logInfo("PSellPetReq.processImp@sell pet success！|" + this.roleId + "|" + this.petId + "|" + xPet.getTemplateid() + "|" + xPet.getLevel() + "|" + sellPrice, new Object[0]);
/*     */     
/* 124 */     PlayerDeletePet playerDeletePet = new PlayerDeletePet();
/* 125 */     PetEventArg arg = new PetEventArg();
/* 126 */     arg.roleId = this.roleId;
/* 127 */     arg.petId = this.petId;
/* 128 */     arg.enventType = PetDeleteTLogEnum.SHOP_SELL.value;
/* 129 */     TriggerEventsManger.getInstance().triggerEvent(playerDeletePet, arg);
/*     */     
/*     */ 
/* 132 */     PetManager.addPetDeleteTlog(this.roleId, xPet.getId(), xPet.getTemplateid(), PetDeleteTLogEnum.SHOP_SELL);
/*     */     
/* 134 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\PSellPetReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
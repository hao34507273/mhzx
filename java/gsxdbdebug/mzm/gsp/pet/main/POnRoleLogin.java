/*     */ package mzm.gsp.pet.main;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.bag.confbean.SBagCfg;
/*     */ import mzm.gsp.bag.confbean.SBagExpendCfg;
/*     */ import mzm.gsp.item.main.ItemBanTrade;
/*     */ import mzm.gsp.item.main.ItemBanTrade.TradeTypeEnum;
/*     */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.pet.PetInfo;
/*     */ import mzm.gsp.pet.SSyncBanPetList;
/*     */ import mzm.gsp.pet.SSyncPetBagList;
/*     */ import mzm.gsp.pet.SSyncPetDepotInfo;
/*     */ import mzm.gsp.pet.SSyncPetShopCanSellNum;
/*     */ import mzm.gsp.pet.confbean.PetConstants;
/*     */ import mzm.gsp.pet.confbean.PetShopConstants;
/*     */ import mzm.gsp.pet.confbean.RemmberSkill;
/*     */ import xbean.Pet;
/*     */ import xbean.PetBag;
/*     */ import xbean.PetDepot;
/*     */ import xbean.PetShopBean;
/*     */ import xtable.Role2petshop;
/*     */ 
/*     */ public class POnRoleLogin extends PlayerLoginProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  32 */     PetBag xPetBag = xtable.Role2petbag.get((Long)this.arg);
/*  33 */     if (xPetBag == null) {
/*  34 */       xPetBag = PetManager.getInstance().createPetBag(((Long)this.arg).longValue());
/*     */     }
/*  36 */     PetDepot xPetDepot = xtable.Role2petdepot.get((Long)this.arg);
/*  37 */     if (xPetDepot == null) {
/*  38 */       xPetDepot = PetManager.getInstance().createDepot(((Long)this.arg).longValue());
/*     */     }
/*  40 */     SBagCfg sBagCfg = SBagCfg.get(340600003);
/*  41 */     int expandCount = (xPetBag.getBagsize() - sBagCfg.initcapacity) / sBagCfg.addCount;
/*  42 */     SBagExpendCfg expandCfg = null;
/*  43 */     Iterator<SBagExpendCfg> i$ = SBagExpendCfg.getAll().values().iterator();
/*     */     
/*  45 */     while (i$.hasNext())
/*     */     {
/*     */ 
/*  48 */       SBagExpendCfg cfg = (SBagExpendCfg)i$.next();
/*  49 */       if ((cfg.bagId == sBagCfg.id) && (cfg.expendCount == expandCount)) {
/*  50 */         expandCfg = cfg;
/*  51 */         break;
/*     */       }
/*     */     }
/*  54 */     SSyncPetBagList sSyncPetBagList = new SSyncPetBagList();
/*  55 */     sSyncPetBagList.bagsize = xPetBag.getBagsize();
/*  56 */     sSyncPetBagList.fightpetid = xPetBag.getFightpet();
/*  57 */     sSyncPetBagList.showpetid = xPetBag.getShowpet();
/*  58 */     if (expandCfg != null) {
/*  59 */       sSyncPetBagList.expandcount = expandCfg.expendCount;
/*     */     }
/*  61 */     for (RemmberSkill skill : PetConstants.getInstance().PET_REMBER_SKILL_ITEM_IDS) {
/*  62 */       sSyncPetBagList.rememberItems.put(Integer.valueOf(skill.index), Integer.valueOf(skill.id));
/*     */     }
/*  64 */     for (Pet xPet : xPetBag.getPetmap().values()) {
/*  65 */       int extramodelcfgid = xPet.getExtramodelcfgid();
/*  66 */       if ((extramodelcfgid > 0) && (!xPet.getOwnextramodelcfgids().contains(Integer.valueOf(extramodelcfgid)))) {
/*  67 */         xPet.getOwnextramodelcfgids().add(Integer.valueOf(extramodelcfgid));
/*     */       }
/*  69 */       PetOutFightObj pet = new PetOutFightObj(((Long)this.arg).longValue(), xPet);
/*  70 */       PetInfo petInfo = new PetInfo();
/*  71 */       pet.fillPetInfo(petInfo);
/*  72 */       sSyncPetBagList.petlist.add(petInfo);
/*     */     }
/*  74 */     OnlineManager.getInstance().send(((Long)this.arg).longValue(), sSyncPetBagList);
/*  75 */     SBagCfg sDepotCfg = SBagCfg.get(340600004);
/*  76 */     SSyncPetDepotInfo sSyncPetDepotInfo = new SSyncPetDepotInfo();
/*  77 */     int expandCount2 = (xPetDepot.getDepotsize() - sDepotCfg.initcapacity) / sDepotCfg.addCount;
/*  78 */     SBagExpendCfg expandCfg2 = null;
/*  79 */     Iterator<SBagExpendCfg> i$2 = SBagExpendCfg.getAll().values().iterator();
/*     */     
/*  81 */     while (i$2.hasNext())
/*     */     {
/*     */ 
/*  84 */       SBagExpendCfg cfg2 = (SBagExpendCfg)i$2.next();
/*  85 */       if ((cfg2.bagId == sDepotCfg.id) && (cfg2.expendCount == expandCount2)) {
/*  86 */         expandCfg2 = cfg2;
/*  87 */         break;
/*     */       }
/*     */     }
/*  90 */     if (expandCfg2 != null) {
/*  91 */       sSyncPetBagList.expandcount = expandCfg2.expendCount;
/*     */     }
/*  93 */     sSyncPetDepotInfo.depotsize = xPetDepot.getDepotsize();
/*  94 */     for (Pet xPet2 : xPetDepot.getPetmap().values()) {
/*  95 */       int extramodelcfgid2 = xPet2.getExtramodelcfgid();
/*  96 */       if ((extramodelcfgid2 > 0) && (!xPet2.getOwnextramodelcfgids().contains(Integer.valueOf(extramodelcfgid2)))) {
/*  97 */         xPet2.getOwnextramodelcfgids().add(Integer.valueOf(extramodelcfgid2));
/*     */       }
/*  99 */       PetOutFightObj pet2 = new PetOutFightObj(((Long)this.arg).longValue(), xPet2);
/* 100 */       PetInfo petInfo2 = new PetInfo();
/* 101 */       pet2.fillPetInfo(petInfo2);
/* 102 */       sSyncPetDepotInfo.petlist.add(petInfo2);
/*     */     }
/* 104 */     OnlineManager.getInstance().send(((Long)this.arg).longValue(), sSyncPetDepotInfo);
/* 105 */     PetShopBean xPetShopBean = Role2petshop.get((Long)this.arg);
/* 106 */     if (xPetShopBean == null) {
/* 107 */       xPetShopBean = xbean.Pod.newPetShopBean();
/* 108 */       Role2petshop.add((Long)this.arg, xPetShopBean);
/*     */     }
/* 110 */     long inNow = System.currentTimeMillis();
/* 111 */     long inTimestamp = PetManager.getBeginningOfDay(xPetShopBean.getTimestamp()) + 86400000L;
/* 112 */     if (inNow > inTimestamp) {
/* 113 */       xPetShopBean.setSellcount(0);
/* 114 */       xPetShopBean.setTimestamp(inNow);
/*     */     }
/* 116 */     SSyncPetShopCanSellNum sSyncPetShopCanSellNum = new SSyncPetShopCanSellNum();
/* 117 */     sSyncPetShopCanSellNum.cansellnum = (PetShopConstants.getInstance().SELL_PER_DAY_LIMIT - xPetShopBean.getSellcount());
/* 118 */     OnlineManager.getInstance().send(((Long)this.arg).longValue(), sSyncPetShopCanSellNum);
/* 119 */     java.util.Set<Integer> banPetSet = ItemBanTrade.getInstance().getBanTradeIds(ItemBanTrade.TradeTypeEnum.PET_SHOP.value);
/* 120 */     SSyncBanPetList sSyncBanPetList = new SSyncBanPetList();
/* 121 */     sSyncBanPetList.banpetlist.addAll(banPetSet);
/* 122 */     OnlineManager.getInstance().send(((Long)this.arg).longValue(), sSyncBanPetList);
/* 123 */     PetManager.checkPetPointError(((Long)this.arg).longValue(), xPetBag.getPetmap(), xPetDepot.getPetmap());
/* 124 */     new PPetFightSyncInformation(((Long)this.arg).longValue()).execute();
/* 125 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
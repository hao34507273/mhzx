/*     */ package mzm.gsp.pet.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.item.main.ItemBanTrade;
/*     */ import mzm.gsp.item.main.ItemBanTrade.TradeTypeEnum;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.pet.SBuyPetRes;
/*     */ import mzm.gsp.pet.confbean.PetShopConstants;
/*     */ import mzm.gsp.pet.confbean.SPetCfg;
/*     */ import mzm.gsp.pet.event.PetMallBuyEvent;
/*     */ import mzm.gsp.pet.event.PetMallBuyEventArg;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.role.main.RoleOneByOneManager;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.PetBag;
/*     */ import xtable.Role2petbag;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PBuyPetReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private long roleId;
/*     */   private int petCfgId;
/*     */   
/*     */   public PBuyPetReq(long roleId, int petCfgId)
/*     */   {
/*  34 */     this.roleId = roleId;
/*  35 */     this.petCfgId = petCfgId;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  42 */     if (!PetManager.isPetSwitchOpenForRole(this.roleId))
/*     */     {
/*  44 */       return false;
/*     */     }
/*     */     
/*  47 */     PetBag xPetBag = Role2petbag.get(Long.valueOf(this.roleId));
/*  48 */     if (xPetBag.getPetmap().size() >= xPetBag.getBagsize())
/*     */     {
/*  50 */       PetManager.logDebug("PBuyPetReq.processImp@PetBag size is max |roleid=%d|petbagsize=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(xPetBag.getPetmap().size()) });
/*     */       
/*  52 */       return false;
/*     */     }
/*  54 */     if (!PetManager.getInstance().isInShop(this.petCfgId))
/*     */     {
/*  56 */       PetManager.logDebug("PBuyPetReq.processImp@buy pet not sell in shop|roleid=%d|petcfgid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.petCfgId) });
/*  57 */       return false;
/*     */     }
/*  59 */     PetCfg petCfg = PetManager.getInstance().getPetCfg(this.petCfgId);
/*  60 */     if (petCfg == null)
/*     */     {
/*  62 */       return false;
/*     */     }
/*     */     
/*  65 */     SPetCfg sPetCfg = SPetCfg.get(this.petCfgId);
/*  66 */     if (sPetCfg == null)
/*     */     {
/*  68 */       return false;
/*     */     }
/*     */     
/*  71 */     int idipSwithId = sPetCfg.pet_open_idip_switch;
/*  72 */     if (!PetManager.isPetLevelOpenForRole(this.roleId, idipSwithId))
/*     */     {
/*  74 */       return false;
/*     */     }
/*     */     
/*  77 */     if (petCfg.getPetType() != 0)
/*     */     {
/*  79 */       return false;
/*     */     }
/*     */     
/*  82 */     if (ItemBanTrade.getInstance().isBanTrade(ItemBanTrade.TradeTypeEnum.PET_SHOP.value, this.petCfgId))
/*     */     {
/*  84 */       ItemBanTrade.getInstance().sendTipToTole(this.roleId, petCfg.getName());
/*  85 */       return false;
/*     */     }
/*     */     
/*  88 */     if (RoleInterface.getLevel(this.roleId) + PetShopConstants.getInstance().CAN_BUY_MORE_THAN_ROLE_LEVEL < petCfg.getCarrayLevel())
/*     */     {
/*  90 */       PetManager.logDebug("PBuyPetReq.processImp@buy pet carrylevel error|roleid=%d|petcfgid=%d|rolelevel=%d|petcarraylevel=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.petCfgId), Integer.valueOf(RoleInterface.getLevel(this.roleId)), Integer.valueOf(petCfg.getCarrayLevel()) });
/*     */       
/*     */ 
/*  93 */       return false;
/*     */     }
/*     */     
/*  96 */     if (!RoleInterface.cutSilver(this.roleId, petCfg.getBuyPrice(), new TLogArg(LogReason.PET_NPC_SHOP_REM, this.petCfgId)))
/*     */     {
/*  98 */       PetManager.logDebug("PBuyPetReq.processImp@not have enough silver|roleid=%d|costsilver=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(petCfg.getBuyPrice()) });
/*     */       
/* 100 */       return false;
/*     */     }
/*     */     
/* 103 */     long petId = PetInterface.addPetAndRandomPoint(this.roleId, this.petCfgId, petCfg.getCarrayLevel(), true);
/*     */     
/* 105 */     if (petId < 0L)
/*     */     {
/* 107 */       PetManager.logDebug("PBuyPetReq.processImp@pet create error|roleid=%d|petcfgid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.petCfgId) });
/* 108 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 112 */     List<Integer> skillList = PetInterface.getPetNativeSkillList(this.roleId, petId);
/* 113 */     String hostIp = GameServerInfoManager.getHostIP();
/* 114 */     String userId = RoleInterface.getUserId(this.roleId);
/* 115 */     PetManager.addPetGetTlog(this.roleId, hostIp, userId, petId, this.petCfgId, PetGetTLogEnum.SHOP_BUY, skillList.size());
/* 116 */     PetManager.addPetSkillChangeTlog(this.roleId, hostIp, userId, petId, this.petCfgId, PetSkillChangeLogEnum.INIT, skillList);
/*     */     
/* 118 */     SBuyPetRes res = new SBuyPetRes();
/* 119 */     res.petcfgid = this.petCfgId;
/* 120 */     OnlineManager.getInstance().send(this.roleId, res);
/*     */     
/* 122 */     TriggerEventsManger.getInstance().triggerEvent(new PetMallBuyEvent(), new PetMallBuyEventArg(this.roleId, this.petCfgId, petId), RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.roleId)));
/*     */     
/*     */ 
/*     */ 
/* 126 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\PBuyPetReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
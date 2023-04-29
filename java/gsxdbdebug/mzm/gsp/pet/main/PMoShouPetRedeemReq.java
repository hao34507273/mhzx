/*     */ package mzm.gsp.pet.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.bulletin.SBulletinInfo;
/*     */ import mzm.gsp.bulletin.main.BulletinInterface;
/*     */ import mzm.gsp.item.main.BasicItem;
/*     */ import mzm.gsp.item.main.ItemBanTrade;
/*     */ import mzm.gsp.item.main.ItemBanTrade.TradeTypeEnum;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.ItemOperateResult;
/*     */ import mzm.gsp.item.main.ItemOperateResult.ChangeItemInfo;
/*     */ import mzm.gsp.npc.main.NpcInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.pet.SPetNormalResult;
/*     */ import mzm.gsp.pet.confbean.PetConstants;
/*     */ import mzm.gsp.pet.confbean.RedeemCostItem;
/*     */ import mzm.gsp.pet.confbean.SPetRedeemCostItemCfg;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class PMoShouPetRedeemReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int petcfgid;
/*     */   
/*     */   public PMoShouPetRedeemReq(long roleId, int petcfgid)
/*     */   {
/*  37 */     this.roleId = roleId;
/*  38 */     this.petcfgid = petcfgid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  44 */     if (!PetManager.isPetSwitchOpenForRole(this.roleId)) {
/*  45 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  49 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 195, true)) {
/*  50 */       Set<Integer> statusSet = RoleStatusInterface.getStatusSet(this.roleId);
/*  51 */       GameServer.logger().error(String.format("[pet]PMoShouPetRedeemReq.processImp@ role in STATUS_ROAM not use fun!|roleid=%d|status_set=%s", new Object[] { Long.valueOf(this.roleId), statusSet }));
/*     */       
/*     */ 
/*  54 */       return false;
/*     */     }
/*  56 */     if (!NpcInterface.checkNpcService(PetConstants.getInstance().MOSHOU_PET_REDEEM_NPCID, 150205303, this.roleId)) {
/*  57 */       return false;
/*     */     }
/*  59 */     PetCfg petCfg = PetManager.getInstance().getPetCfg(this.petcfgid);
/*  60 */     if (petCfg == null) {
/*  61 */       return false;
/*     */     }
/*  63 */     if (!petCfg.isMoShou()) {
/*  64 */       return false;
/*     */     }
/*     */     
/*  67 */     if (ItemBanTrade.getInstance().isBanTrade(ItemBanTrade.TradeTypeEnum.PET_SHOP.value, this.petcfgid)) {
/*  68 */       ItemBanTrade.getInstance().sendTipToTole(this.roleId, petCfg.getName());
/*  69 */       return false;
/*     */     }
/*  71 */     SPetRedeemCostItemCfg costItemCfg = PetManager.getInstance().getPetRedeemCostItemCfg(this.petcfgid);
/*  72 */     if (costItemCfg == null) return false;
/*  73 */     RedeemCostItem item = null;
/*  74 */     int itemId = -1;
/*  75 */     for (RedeemCostItem costItem : costItemCfg.itemCostList) {
/*  76 */       ItemOperateResult result = ItemInterface.removeItemsByItemType(this.roleId, costItem.itemTypeId, costItem.itemNum, new TLogArg(LogReason.PET_MOSHOU_REDEEM_REM));
/*  77 */       if (!result.success()) {
/*  78 */         PetManager.logDebug("PMoShouPetRedeemReq.processImp@remove item error|roleid=%d|itemTypeId=%d|itemNum=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(costItem.itemTypeId), Integer.valueOf(costItem.itemNum) });
/*  79 */         return false;
/*     */       }
/*  81 */       if (result.getChangeItemInfoList().isEmpty()) {
/*  82 */         return false;
/*     */       }
/*  84 */       itemId = ((ItemOperateResult.ChangeItemInfo)result.getChangeItemInfoList().get(0)).basicItem.getCfgId();
/*  85 */       item = costItem;
/*     */     }
/*  87 */     if ((item == null) || (itemId == -1)) {
/*  88 */       return false;
/*     */     }
/*     */     
/*  91 */     long petId = PetInterface.addPet(this.roleId, this.petcfgid, 1);
/*  92 */     if (petId < 0L) {
/*  93 */       SPetNormalResult sPetNormalResult = new SPetNormalResult();
/*  94 */       sPetNormalResult.result = 16;
/*  95 */       OnlineManager.getInstance().sendAtOnce(this.roleId, sPetNormalResult);
/*  96 */       return false;
/*     */     }
/*  98 */     SBulletinInfo sBulletinInfo = new SBulletinInfo();
/*  99 */     sBulletinInfo.bulletintype = 26;
/* 100 */     sBulletinInfo.params.put(Integer.valueOf(1), RoleInterface.getName(this.roleId));
/* 101 */     sBulletinInfo.params.put(Integer.valueOf(15), item.itemNum + "");
/* 102 */     sBulletinInfo.params.put(Integer.valueOf(4), itemId + "");
/* 103 */     sBulletinInfo.params.put(Integer.valueOf(21), this.petcfgid + "");
/* 104 */     BulletinInterface.sendBulletin(sBulletinInfo);
/*     */     
/*     */ 
/* 107 */     String hostIp = GameServerInfoManager.getHostIP();
/* 108 */     String userId = RoleInterface.getUserId(this.roleId);
/* 109 */     List<Integer> skillList = PetInterface.getPetNativeSkillList(this.roleId, petId);
/* 110 */     PetManager.addPetGetTlog(this.roleId, hostIp, userId, petId, this.petcfgid, PetGetTLogEnum.MOSHOU_NPC, skillList.size());
/* 111 */     PetManager.addPetSkillChangeTlog(this.roleId, hostIp, userId, petId, this.petcfgid, PetSkillChangeLogEnum.INIT, skillList);
/*     */     
/* 113 */     PetManager.logInfo("PMoShouPetRedeemReq.processImp@exchange moshou pet success!" + this.roleId + "|" + petId + "|" + itemId, new Object[0]);
/*     */     
/* 115 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\PMoShouPetRedeemReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
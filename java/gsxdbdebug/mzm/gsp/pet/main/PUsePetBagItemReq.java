/*     */ package mzm.gsp.pet.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.item.confbean.SPetBagItem;
/*     */ import mzm.gsp.item.main.BasicItem;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.pet.SPetNormalResult;
/*     */ import mzm.gsp.pet.SUsePetBagItemRes;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PUsePetBagItemReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private long roleId;
/*     */   private int itemKey;
/*     */   
/*     */   public PUsePetBagItemReq(long roleId, int itemKey)
/*     */   {
/*  31 */     this.roleId = roleId;
/*  32 */     this.itemKey = itemKey;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  38 */     if (!PetManager.isPetSwitchOpenForRole(this.roleId)) {
/*  39 */       return false;
/*     */     }
/*     */     
/*  42 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 531, true)) {
/*  43 */       Set<Integer> statusSet = RoleStatusInterface.getStatusSet(this.roleId);
/*  44 */       GameServer.logger().error(String.format("[pet]PUsePetBagItemReq.processImp@ role in STATUS_ROAM not use fun!|roleid=%d|status_set=%s", new Object[] { Long.valueOf(this.roleId), statusSet }));
/*     */       
/*  46 */       return false;
/*     */     }
/*     */     
/*  49 */     BasicItem basicItem = ItemInterface.getItem(this.roleId, this.itemKey);
/*     */     
/*  51 */     if (basicItem == null) {
/*  52 */       return false;
/*     */     }
/*  54 */     SPetBagItem sPetBagItem = SPetBagItem.get(basicItem.getCfgId());
/*     */     
/*  56 */     if (sPetBagItem == null) {
/*  57 */       return false;
/*     */     }
/*     */     
/*  60 */     if (!PetInterface.isCanCarray(sPetBagItem.petId, RoleInterface.getLevel(this.roleId))) {
/*  61 */       SPetNormalResult result = new SPetNormalResult();
/*  62 */       result.result = 20;
/*  63 */       OnlineManager.getInstance().sendAtOnce(this.roleId, result);
/*  64 */       return false;
/*     */     }
/*  66 */     long itemId = basicItem.getFirstUuid().longValue();
/*  67 */     int cfgId = basicItem.getCfgId();
/*     */     
/*  69 */     if (!ItemInterface.removeItemByUuid(this.roleId, basicItem.getFirstUuid().longValue(), 1, new TLogArg(LogReason.PET_USE_BAOBAODAI_REM, basicItem.getCfgId()))) {
/*  70 */       PetManager.logDebug("PUsePetBagItemReq.processImp@removeitemerror|roleid=%d|itemid=%d", new Object[] { Long.valueOf(this.roleId), basicItem.getFirstUuid() });
/*  71 */       return false;
/*     */     }
/*  73 */     int petLevel = 0;
/*  74 */     switch (sPetBagItem.petLevel)
/*     */     {
/*     */     case 0: 
/*  77 */       petLevel = 0;
/*  78 */       break;
/*     */     case 1: 
/*  80 */       petLevel = PetInterface.getPetCfgByCfgId(sPetBagItem.petId).getCarrayLevel();
/*  81 */       break;
/*     */     case 2: 
/*  83 */       petLevel = RoleInterface.getLevel(this.roleId);
/*  84 */       break;
/*  85 */     default:  return false;
/*     */     }
/*  87 */     long result = PetInterface.addPetAndRandomPoint(this.roleId, sPetBagItem.petId, petLevel, false);
/*     */     
/*  89 */     if (result == -3L) {
/*  90 */       SPetNormalResult normalResult = new SPetNormalResult();
/*  91 */       normalResult.result = 16;
/*  92 */       OnlineManager.getInstance().sendAtOnce(this.roleId, normalResult);
/*  93 */       return false;
/*     */     }
/*  95 */     SUsePetBagItemRes res = new SUsePetBagItemRes();
/*  96 */     res.petcfgid = sPetBagItem.petId;
/*  97 */     OnlineManager.getInstance().send(this.roleId, res);
/*     */     
/*  99 */     String hostIp = GameServerInfoManager.getHostIP();
/* 100 */     String userId = RoleInterface.getUserId(this.roleId);
/* 101 */     int skillNum = PetInterface.getPetSkillNum(this.roleId, result);
/*     */     
/* 103 */     StringBuilder tlogStr = new StringBuilder();
/* 104 */     tlogStr.append(hostIp).append("|").append(userId).append("|").append(this.roleId).append("|").append(result).append("|").append(sPetBagItem.petId).append("|").append(PetGetTLogEnum.PET_ITEM_BAG).append("|").append(skillNum).append("|").append(itemId).append("|").append(cfgId);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 113 */     TLogManager.getInstance().addLog(this.roleId, "PetGet", tlogStr.toString());
/*     */     
/* 115 */     PetManager.logInfo("PUsePetBagItemReq.processImp@use pet bag item success！" + this.roleId + "|" + res.petcfgid + "|" + petLevel + "|" + this.itemKey, new Object[0]);
/* 116 */     List<Integer> skillList = PetInterface.getPetNativeSkillList(this.roleId, result);
/* 117 */     PetManager.addPetSkillChangeTlog(this.roleId, hostIp, userId, result, sPetBagItem.petId, PetSkillChangeLogEnum.INIT, skillList);
/* 118 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\PUsePetBagItemReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
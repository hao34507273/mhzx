/*     */ package mzm.gsp.pet.main;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.item.main.BasicItem;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.ItemOperateResult;
/*     */ import mzm.gsp.item.main.ItemOperateResult.ChangeItemInfo;
/*     */ import mzm.gsp.item.main.PetEquipmentItem;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.pet.SMergePetEquipRes;
/*     */ import mzm.gsp.petequip.confbean.SPetEquipItem;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class PMergePetEquipReq extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int itemKey1;
/*     */   private final int itemKey2;
/*     */   
/*     */   public PMergePetEquipReq(long roleId, int itemKey1, int itemKey2)
/*     */   {
/*  31 */     this.roleId = roleId;
/*  32 */     this.itemKey1 = itemKey1;
/*  33 */     this.itemKey2 = itemKey2;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  39 */     if (!PetManager.isPetSwitchOpenForRole(this.roleId)) {
/*  40 */       return false;
/*     */     }
/*     */     
/*  43 */     BasicItem basicItem1 = ItemInterface.getItem(this.roleId, this.itemKey1);
/*  44 */     if (basicItem1 == null) {
/*  45 */       return false;
/*     */     }
/*     */     
/*  48 */     BasicItem basicItem2 = ItemInterface.getItem(this.roleId, this.itemKey2);
/*  49 */     if (basicItem2 == null) {
/*  50 */       return false;
/*     */     }
/*  52 */     SPetEquipItem sPetEquipItem1 = SPetEquipItem.get(basicItem1.getCfgId());
/*  53 */     SPetEquipItem sPetEquipItem2 = SPetEquipItem.get(basicItem2.getCfgId());
/*  54 */     if ((sPetEquipItem1 == null) || (sPetEquipItem2 == null)) {
/*  55 */       return false;
/*     */     }
/*  57 */     if (sPetEquipItem1.equipLevel != sPetEquipItem2.equipLevel) {
/*  58 */       return false;
/*     */     }
/*  60 */     if (sPetEquipItem1.equipType != sPetEquipItem2.equipType) {
/*  61 */       return false;
/*     */     }
/*  63 */     TLogArg remArg = new TLogArg(LogReason.PET_MERGE_EQUIP_REM, basicItem1.getCfgId());
/*  64 */     long item1uuid = basicItem1.getFirstUuid().longValue();
/*  65 */     long item2uuid = basicItem2.getFirstUuid().longValue();
/*     */     
/*  67 */     if ((!ItemInterface.removeItemByUuid(this.roleId, basicItem1.getFirstUuid().longValue(), 1, remArg)) || (!ItemInterface.removeItemByUuid(this.roleId, basicItem2.getFirstUuid().longValue(), 1, remArg))) {
/*  68 */       PetManager.logDebug("PMergePetEquipReq.processImp@not have item num|roleid=%d|itemid=%d", new Object[] { Long.valueOf(this.roleId), basicItem1.getFirstUuid() });
/*  69 */       return false;
/*     */     }
/*     */     
/*  72 */     Integer newPetEquipCfg = PetManager.getInstance().randomEquipId(sPetEquipItem1.equipType, sPetEquipItem1.equipLevel);
/*  73 */     if (newPetEquipCfg == null) {
/*  74 */       if (GameServer.logger().isInfoEnabled()) {
/*  75 */         GameServer.logger().info("PMergePetEquipReq 获取新的配置id 错误~！");
/*     */       }
/*  77 */       return false;
/*     */     }
/*     */     
/*  80 */     ItemOperateResult result = ItemInterface.addItem(this.roleId, newPetEquipCfg.intValue(), 1, new TLogArg(LogReason.PET_MERGE_EQUIP_ADD, newPetEquipCfg.intValue()));
/*  81 */     SMergePetEquipRes res = new SMergePetEquipRes();
/*  82 */     res.itemkey = ((ItemOperateResult.ChangeItemInfo)result.getChangeItemInfoList().get(0)).grid;
/*  83 */     OnlineManager.getInstance().send(this.roleId, res);
/*     */     
/*  85 */     PetManager.logInfo("PMergePetEquipReq.processImp@merge pet equip success!|" + this.roleId + "|" + sPetEquipItem1.id + "|" + sPetEquipItem2.id + "|" + res.itemkey, new Object[0]);
/*     */     
/*     */ 
/*  88 */     Set<Long> uuids = (Set)result.getChangedItemId2Uuids().get(newPetEquipCfg);
/*  89 */     long uuid = ((Long)uuids.iterator().next()).longValue();
/*  90 */     PetEquipmentItem petEquipmentItem = (PetEquipmentItem)ItemInterface.getItemByUuid(this.roleId, uuid);
/*  91 */     if (petEquipmentItem != null) {
/*  92 */       TLogManager.getInstance().addLog(this.roleId, "PetEquipMergeTLog", PetManager.createTLog(new Object[] { GameServerInfoManager.getHostIP(), RoleInterface.getUserId(this.roleId), Long.valueOf(this.roleId), Long.valueOf(uuid), newPetEquipCfg, Long.valueOf(item1uuid), Integer.valueOf(basicItem1.getCfgId()), Long.valueOf(item2uuid), Integer.valueOf(basicItem2.getCfgId()), Integer.valueOf(petEquipmentItem.getStoreAttriAType()), Integer.valueOf(petEquipmentItem.getStoreAttriAValue()), Integer.valueOf(petEquipmentItem.getStoreAttriBType()), Integer.valueOf(petEquipmentItem.getStoreAttriBValue()) }));
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
/* 110 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\PMergePetEquipReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
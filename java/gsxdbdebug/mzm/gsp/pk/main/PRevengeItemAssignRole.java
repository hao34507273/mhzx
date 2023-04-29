/*     */ package mzm.gsp.pk.main;
/*     */ 
/*     */ import mzm.gsp.item.confbean.SPKRevengeItemCfg;
/*     */ import mzm.gsp.item.main.BasicItem;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.ItemStoreEnum;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.pk.SRevengeItemAssignRoleFail;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.util.CommonUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PRevengeItemAssignRole
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int bagId;
/*     */   private final int grid;
/*     */   private final String targetNameOrRoleId;
/*     */   
/*     */   public PRevengeItemAssignRole(long roleId, int bagId, int grid, String targetNameOrRoleId)
/*     */   {
/*  27 */     this.roleId = roleId;
/*  28 */     this.bagId = bagId;
/*  29 */     this.grid = grid;
/*  30 */     this.targetNameOrRoleId = targetNameOrRoleId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  36 */     if (PKManager.isNotEnable()) {
/*  37 */       return false;
/*     */     }
/*  39 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 1629, true)) {
/*  40 */       return false;
/*     */     }
/*  42 */     long targetRoleId = checkTargetRoleId();
/*  43 */     if (targetRoleId == -1L) {
/*  44 */       return false;
/*     */     }
/*     */     
/*  47 */     BasicItem basicItem = ItemInterface.getItem(this.roleId, this.bagId, this.grid);
/*  48 */     if (basicItem == null)
/*     */     {
/*  50 */       return false;
/*     */     }
/*  52 */     SPKRevengeItemCfg itemCfg = SPKRevengeItemCfg.get(basicItem.getCfgId());
/*  53 */     if (itemCfg == null)
/*     */     {
/*  55 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  59 */     if ((basicItem.getExtra(ItemStoreEnum.REVENGE_ITEM_BIND_HIGH) != null) || (basicItem.getExtra(ItemStoreEnum.REVENGE_ITEM_BIND_LOW) != null))
/*     */     {
/*     */ 
/*  62 */       notifyFail(3);
/*  63 */       PKLogManager.error(String.format("PRevengeItemAssignRole.processImp()@already assigned|roleid=%d|bagid=%d|grid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.bagId), Integer.valueOf(this.grid) }));
/*     */       
/*  65 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  69 */     basicItem.setExtra(ItemStoreEnum.REVENGE_ITEM_BIND_HIGH, CommonUtils.getLongHigh(targetRoleId));
/*  70 */     basicItem.setExtra(ItemStoreEnum.REVENGE_ITEM_BIND_LOW, CommonUtils.getLongLow(targetRoleId));
/*  71 */     basicItem.setExtra(ItemStoreEnum.REVENGE_ITEM_AVAILABLE_TIMES, itemCfg.maxQueryTime);
/*  72 */     PKLogManager.tlogRevengeItemBindTarget(this.roleId, targetRoleId);
/*  73 */     PKLogManager.info(String.format("PRevengeItemAssignRole.processImp()@target assigned|roleid=%d|target_roleid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(targetRoleId) }));
/*     */     
/*  75 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private long checkTargetRoleId()
/*     */   {
/*  83 */     if (this.targetNameOrRoleId.isEmpty()) {
/*  84 */       return -1L;
/*     */     }
/*     */     
/*     */     long targetRoleId;
/*  88 */     if (!this.targetNameOrRoleId.matches("\\d+"))
/*     */     {
/*  90 */       long targetRoleId = RoleInterface.getRoleIdByName(this.targetNameOrRoleId);
/*  91 */       if (targetRoleId == -1L)
/*     */       {
/*  93 */         notifyFail(1);
/*  94 */         PKLogManager.error(String.format("PRevengeItemAssignRole.processImp()@target not found|target_name=%s", new Object[] { this.targetNameOrRoleId }));
/*     */         
/*  96 */         return -1L;
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/*     */       try
/*     */       {
/* 103 */         targetRoleId = Long.valueOf(this.targetNameOrRoleId).longValue();
/*     */       }
/*     */       catch (NumberFormatException e)
/*     */       {
/* 107 */         PKLogManager.error("PRevengeItemAssignRole.processImp()@number format exception");
/* 108 */         return -1L;
/*     */       }
/*     */     }
/*     */     
/* 112 */     if (targetRoleId == this.roleId)
/*     */     {
/* 114 */       notifyFail(2);
/* 115 */       PKLogManager.error(String.format("PRevengeItemAssignRole.processImp()@cannot assign self|roleid=%d", new Object[] { Long.valueOf(this.roleId) }));
/* 116 */       return -1L;
/*     */     }
/*     */     
/* 119 */     if (!RoleInterface.isRoleExist(targetRoleId, false))
/*     */     {
/* 121 */       PKLogManager.error(String.format("PRevengeItemAssignRole.processImp()@target not found|target_roleid=%d", new Object[] { Long.valueOf(targetRoleId) }));
/*     */       
/* 123 */       notifyFail(1);
/* 124 */       return -1L;
/*     */     }
/*     */     
/* 127 */     return targetRoleId;
/*     */   }
/*     */   
/*     */   private void notifyFail(int retcode)
/*     */   {
/* 132 */     SRevengeItemAssignRoleFail sRevengeItemAssignRoleFail = new SRevengeItemAssignRoleFail();
/* 133 */     sRevengeItemAssignRoleFail.retcode = retcode;
/* 134 */     OnlineManager.getInstance().sendAtOnce(this.roleId, sRevengeItemAssignRoleFail);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pk\main\PRevengeItemAssignRole.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
/*     */ package mzm.gsp.superequipment.main;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import mzm.gsp.item.main.BasicItem;
/*     */ import mzm.gsp.item.main.EquipmentItem;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.superequipment.confbean.SuperEquipmentLevelBean;
/*     */ import mzm.gsp.superequipment.confbean.SuperEquipmentLevelRequiredItem;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.LogicRunnable;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RGMSuperEquipmentImproveLevel
/*     */   extends LogicRunnable
/*     */ {
/*     */   private final long gmRoleId;
/*     */   private final long roleId;
/*     */   private final int bagId;
/*     */   private final int grid;
/*     */   private final boolean useYuanbao;
/*     */   
/*     */   public RGMSuperEquipmentImproveLevel(long gmRoleId, long roleId, int bagId, int grid, boolean useYuanbao)
/*     */   {
/*  30 */     this.gmRoleId = gmRoleId;
/*  31 */     this.roleId = roleId;
/*  32 */     this.bagId = bagId;
/*  33 */     this.grid = grid;
/*  34 */     this.useYuanbao = useYuanbao;
/*     */   }
/*     */   
/*     */   private class Container {
/*  38 */     boolean ok = false;
/*     */     long requiredYuanbao;
/*     */     long roleCurrency;
/*     */     
/*     */     private Container() {}
/*     */   }
/*     */   
/*     */   public void process() throws Exception {
/*  46 */     if (!OpenInterface.getOpenStatus(382)) {
/*  47 */       SuperEquipmentManager.sendCommonTip(this.gmRoleId, "功能开关未开启");
/*  48 */       return;
/*     */     }
/*     */     
/*  51 */     final Container container = new Container(null);
/*  52 */     new LogicProcedure()
/*     */     {
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/*  57 */         if (!SuperEquipmentManager.checkBasicConditions(RGMSuperEquipmentImproveLevel.this.roleId)) {
/*  58 */           return false;
/*     */         }
/*     */         
/*  61 */         String userId = RoleInterface.getUserId(RGMSuperEquipmentImproveLevel.this.roleId);
/*  62 */         if (userId == null)
/*  63 */           return false;
/*  64 */         lock(User.getTable(), Collections.singleton(userId));
/*     */         
/*     */ 
/*  67 */         BasicItem basicItem = ItemInterface.getItem(RGMSuperEquipmentImproveLevel.this.roleId, RGMSuperEquipmentImproveLevel.this.bagId, RGMSuperEquipmentImproveLevel.this.grid);
/*  68 */         if (basicItem == null)
/*  69 */           return false;
/*  70 */         if (!(basicItem instanceof EquipmentItem)) {
/*  71 */           return false;
/*     */         }
/*  73 */         EquipmentItem item = (EquipmentItem)basicItem;
/*  74 */         if (!SuperEquipmentManager.canImproveLevel(item))
/*  75 */           return false;
/*  76 */         SuperEquipmentLevelBean nextLevelBean = SuperEquipmentManager.getNextLevelBean(item);
/*  77 */         if (nextLevelBean == null) {
/*  78 */           return false;
/*     */         }
/*  80 */         container.ok = true;
/*  81 */         container.requiredYuanbao = RGMSuperEquipmentImproveLevel.this.calculateRequiredYuanbao(nextLevelBean);
/*  82 */         container.roleCurrency = SuperEquipmentManager.getRoleCurrencyForImproving(RGMSuperEquipmentImproveLevel.this.roleId, nextLevelBean.requiredCurrencyType);
/*     */         
/*     */ 
/*  85 */         return true;
/*     */       }
/*     */     }.call();
/*     */     
/*  89 */     if (container.ok)
/*     */     {
/*  91 */       boolean result = new PImproveSuperEquipmentLevel(this.roleId, this.bagId, this.grid, this.useYuanbao, container.requiredYuanbao, container.roleCurrency).call();
/*     */       
/*  93 */       if (result)
/*     */       {
/*  95 */         SuperEquipmentManager.sendCommonTip(this.gmRoleId, "GM升级操作成功");
/*  96 */         return;
/*     */       }
/*     */     }
/*  99 */     SuperEquipmentManager.sendCommonTip(this.gmRoleId, "GM升级操作失败");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private int calculateRequiredYuanbao(SuperEquipmentLevelBean nextLevelBean)
/*     */   {
/* 107 */     int yuanbao = 0;
/* 108 */     for (SuperEquipmentLevelRequiredItem requiredItem : nextLevelBean.requiredItems)
/*     */     {
/* 110 */       int lackedNum = requiredItem.num - ItemInterface.getItemNumberById(this.roleId, requiredItem.id);
/* 111 */       if (lackedNum > 0)
/* 112 */         yuanbao += ItemInterface.getItemYuanBaoPrice(requiredItem.id) * lackedNum;
/*     */     }
/* 114 */     return yuanbao;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\superequipment\main\RGMSuperEquipmentImproveLevel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
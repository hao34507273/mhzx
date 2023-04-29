/*    */ package mzm.gsp.superequipment.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.item.confbean.SItemCfg;
/*    */ import mzm.gsp.item.main.BasicItem;
/*    */ import mzm.gsp.item.main.EquipmentItem;
/*    */ import mzm.gsp.item.main.ItemInterface;
/*    */ import mzm.gsp.item.main.RoleEquipBag;
/*    */ import mzm.gsp.item.main.RoleItemBag;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ public class PGMListSuperEquipment
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long gmRoleId;
/*    */   private final long roleId;
/*    */   
/*    */   public PGMListSuperEquipment(long gmRoleId, long roleId)
/*    */   {
/* 23 */     this.gmRoleId = gmRoleId;
/* 24 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 30 */     if (!OpenInterface.getOpenStatus(382)) {
/* 31 */       SuperEquipmentManager.sendCommonTip(this.gmRoleId, "功能开关未开启");
/* 32 */       return false;
/*    */     }
/*    */     
/* 35 */     RoleEquipBag equipBag = ItemInterface.getRoleEquipBag(this.roleId);
/* 36 */     RoleItemBag itemBag = ItemInterface.getRoleItemBag(this.roleId);
/* 37 */     if ((equipBag == null) || (itemBag == null)) {
/* 38 */       return false;
/*    */     }
/* 40 */     for (Map.Entry<Integer, BasicItem> e : equipBag.getAllItems(false).entrySet())
/*    */     {
/* 42 */       if ((e.getValue() instanceof EquipmentItem))
/*    */       {
/* 44 */         EquipmentItem item = (EquipmentItem)e.getValue();
/* 45 */         if (SuperEquipmentManager.isSuperEquipment(item))
/*    */         {
/* 47 */           addSuperEquipmentInfo(340600001, ((Integer)e.getKey()).intValue(), item);
/*    */         }
/* 49 */         else if (SuperEquipmentManager.isPotentialSuperEquipment(item))
/*    */         {
/* 51 */           addPotentialSuperEquipmentInfo(340600001, ((Integer)e.getKey()).intValue(), item);
/*    */         }
/*    */       }
/*    */     }
/*    */     
/* 56 */     for (Map.Entry<Integer, BasicItem> e : itemBag.getAllItems(false).entrySet())
/*    */     {
/* 58 */       if ((e.getValue() instanceof EquipmentItem))
/*    */       {
/* 60 */         EquipmentItem item = (EquipmentItem)e.getValue();
/* 61 */         if (SuperEquipmentManager.isSuperEquipment(item))
/*    */         {
/* 63 */           addSuperEquipmentInfo(340600000, ((Integer)e.getKey()).intValue(), item);
/*    */         }
/* 65 */         else if (SuperEquipmentManager.isPotentialSuperEquipment(item))
/*    */         {
/* 67 */           addPotentialSuperEquipmentInfo(340600000, ((Integer)e.getKey()).intValue(), item);
/*    */         }
/*    */       }
/*    */     }
/*    */     
/* 72 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   private void addSuperEquipmentInfo(int bagId, int grid, EquipmentItem item)
/*    */   {
/* 78 */     SItemCfg itemCfg = SItemCfg.get(item.getCfgId());
/* 79 */     if (itemCfg == null) {
/* 80 */       return;
/*    */     }
/* 82 */     String str = String.format("(%d %d) 神兵: %s (uuid: %d) (%d阶%d级)", new Object[] { Integer.valueOf(bagId), Integer.valueOf(grid), itemCfg.name, item.getFirstUuid(), Integer.valueOf(item.getSuperEquipmentStage()), Integer.valueOf(item.getSuperEquipmentLevel()) });
/*    */     
/* 84 */     SuperEquipmentManager.sendCommonTip(this.gmRoleId, str);
/* 85 */     SuperEquipmentManager.info(str, new Object[0]);
/*    */   }
/*    */   
/*    */   private void addPotentialSuperEquipmentInfo(int bagId, int grid, EquipmentItem item)
/*    */   {
/* 90 */     SItemCfg itemCfg = SItemCfg.get(item.getCfgId());
/* 91 */     if (itemCfg == null) {
/* 92 */       return;
/*    */     }
/* 94 */     String str = String.format("(%d %d) 准神兵: %s (uuid: %d)", new Object[] { Integer.valueOf(bagId), Integer.valueOf(grid), itemCfg.name, item.getFirstUuid() });
/* 95 */     SuperEquipmentManager.sendCommonTip(this.gmRoleId, str);
/* 96 */     SuperEquipmentManager.info(str, new Object[0]);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\superequipment\main\PGMListSuperEquipment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
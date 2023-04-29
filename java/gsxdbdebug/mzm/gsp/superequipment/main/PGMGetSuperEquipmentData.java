/*    */ package mzm.gsp.superequipment.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.item.main.BasicItem;
/*    */ import mzm.gsp.item.main.EquipmentItem;
/*    */ import mzm.gsp.item.main.ItemInterface;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PGMGetSuperEquipmentData
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long gmRoleId;
/*    */   private final long roleId;
/*    */   private final int bagId;
/*    */   private final int grid;
/*    */   
/*    */   public PGMGetSuperEquipmentData(long gmRoleId, long roleId, int bagId, int grid)
/*    */   {
/* 25 */     this.gmRoleId = gmRoleId;
/* 26 */     this.roleId = roleId;
/* 27 */     this.bagId = bagId;
/* 28 */     this.grid = grid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 34 */     if (!OpenInterface.getOpenStatus(382)) {
/* 35 */       SuperEquipmentManager.sendCommonTip(this.gmRoleId, "功能开关未开启");
/* 36 */       return false;
/*    */     }
/*    */     
/* 39 */     BasicItem basicItem = ItemInterface.getItem(this.roleId, this.bagId, this.grid);
/* 40 */     if (basicItem == null)
/*    */     {
/* 42 */       SuperEquipmentManager.sendCommonTip(this.gmRoleId, "道具不存在");
/* 43 */       return false;
/*    */     }
/*    */     
/* 46 */     if (!(basicItem instanceof EquipmentItem))
/*    */     {
/* 48 */       SuperEquipmentManager.sendCommonTip(this.gmRoleId, "不是装备道具");
/* 49 */       return false;
/*    */     }
/*    */     
/* 52 */     EquipmentItem item = (EquipmentItem)basicItem;
/* 53 */     SuperEquipmentManager.sendCommonTip(this.gmRoleId, String.format("阶级: %d | 等级: %d", new Object[] { Integer.valueOf(item.getSuperEquipmentStage()), Integer.valueOf(item.getSuperEquipmentLevel()) }));
/*    */     
/*    */ 
/* 56 */     StringBuilder stageBuilder = new StringBuilder();
/* 57 */     stageBuilder.append("升阶消耗状况: ");
/* 58 */     for (Map.Entry<Integer, Integer> e : item.getSuperEquipmentImproveStageCostMap().entrySet())
/* 59 */       stageBuilder.append(String.format("%d=%d, ", new Object[] { e.getKey(), e.getValue() }));
/* 60 */     SuperEquipmentManager.sendCommonTip(this.gmRoleId, stageBuilder.toString());
/*    */     
/* 62 */     StringBuilder levelBuilder = new StringBuilder();
/* 63 */     levelBuilder.append("升级消耗情况: ");
/* 64 */     for (Map.Entry<Integer, Integer> e : item.getSuperEquipmentImproveLevelCostMap().entrySet())
/* 65 */       levelBuilder.append(String.format("%d=%d, ", new Object[] { e.getKey(), e.getValue() }));
/* 66 */     SuperEquipmentManager.sendCommonTip(this.gmRoleId, levelBuilder.toString());
/*    */     
/* 68 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\superequipment\main\PGMGetSuperEquipmentData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
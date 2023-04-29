/*    */ package mzm.gsp.superequipment.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.item.main.BasicItem;
/*    */ import mzm.gsp.item.main.EquipmentItem;
/*    */ import mzm.gsp.item.main.ItemInterface;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.superequipment.confbean.SSuperEquipmentLevelCfg;
/*    */ import mzm.gsp.superequipment.confbean.SSuperEquipmentStageCfg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PGMSetSuperEquipmentData
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long gmRoleId;
/*    */   private final long roleId;
/*    */   private final int bagId;
/*    */   private final int grid;
/*    */   private final int stage;
/*    */   private final int level;
/*    */   
/*    */   public PGMSetSuperEquipmentData(long gmRoleId, long roleId, int bagId, int grid, int stage, int level)
/*    */   {
/* 29 */     this.gmRoleId = gmRoleId;
/* 30 */     this.roleId = roleId;
/* 31 */     this.bagId = bagId;
/* 32 */     this.grid = grid;
/* 33 */     this.stage = stage;
/* 34 */     this.level = level;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 40 */     if (!OpenInterface.getOpenStatus(382)) {
/* 41 */       SuperEquipmentManager.sendCommonTip(this.gmRoleId, "功能开关未开启");
/* 42 */       return false;
/*    */     }
/*    */     
/* 45 */     BasicItem basicItem = ItemInterface.getItem(this.roleId, this.bagId, this.grid);
/* 46 */     if (basicItem == null)
/*    */     {
/* 48 */       SuperEquipmentManager.sendCommonTip(this.gmRoleId, "道具不存在");
/* 49 */       return false;
/*    */     }
/*    */     
/* 52 */     if (!(basicItem instanceof EquipmentItem))
/*    */     {
/* 54 */       SuperEquipmentManager.sendCommonTip(this.gmRoleId, "不是装备道具");
/* 55 */       return false;
/*    */     }
/* 57 */     EquipmentItem item = (EquipmentItem)basicItem;
/*    */     
/* 59 */     if ((this.stage != 0) && (SSuperEquipmentStageCfg.get(this.stage) == null))
/*    */     {
/* 61 */       SuperEquipmentManager.sendCommonTip(this.gmRoleId, "阶级无效");
/* 62 */       return false;
/*    */     }
/*    */     
/* 65 */     SSuperEquipmentLevelCfg levelCfg = SSuperEquipmentLevelCfg.get(ItemInterface.getEquipWearpos(item.getCfgId()));
/*    */     
/* 67 */     if (levelCfg == null)
/*    */     {
/* 69 */       SuperEquipmentManager.sendCommonTip(this.gmRoleId, "装备位置无效");
/* 70 */       return false;
/*    */     }
/* 72 */     if ((this.level != 0) && (levelCfg.level2cfg.get(Integer.valueOf(this.level)) == null))
/*    */     {
/* 74 */       SuperEquipmentManager.sendCommonTip(this.gmRoleId, "等级无效");
/* 75 */       return false;
/*    */     }
/*    */     
/* 78 */     item.setSuperEquipmentStage(this.stage);
/* 79 */     item.setSuperEquipmentLevel(this.level);
/* 80 */     item.getSuperEquipmentImproveStageCostMap().clear();
/* 81 */     item.getSuperEquipmentImproveLevelCostMap().clear();
/*    */     
/* 83 */     SuperEquipmentManager.sendCommonTip(this.gmRoleId, "修改神兵数据成功");
/*    */     
/* 85 */     SuperEquipmentManager.tlogImproveStage(this.roleId, item);
/* 86 */     SuperEquipmentManager.tlogImproveLevel(this.roleId, item);
/*    */     
/* 88 */     SuperEquipmentManager.triggerStageImproved(this.roleId, item, this.bagId == 340600001);
/* 89 */     SuperEquipmentManager.triggerLevelImproved(this.roleId, item, this.bagId == 340600001);
/*    */     
/* 91 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\superequipment\main\PGMSetSuperEquipmentData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
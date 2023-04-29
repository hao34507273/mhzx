/*    */ package mzm.gsp.equipmentbless.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.item.main.BasicItem;
/*    */ import mzm.gsp.item.main.EquipmentItem;
/*    */ import mzm.gsp.item.main.ItemInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGM_SetBlessLevel extends LogicProcedure
/*    */ {
/*    */   private final long gmRoleId;
/*    */   private final long roleId;
/*    */   private final int bagId;
/*    */   private final int grid;
/*    */   private final int level;
/*    */   
/*    */   public PGM_SetBlessLevel(long gmRoleId, long roleId, int bagId, int grid, int level)
/*    */   {
/* 19 */     this.gmRoleId = gmRoleId;
/* 20 */     this.roleId = roleId;
/* 21 */     this.bagId = bagId;
/* 22 */     this.grid = grid;
/* 23 */     this.level = level;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 29 */     BasicItem basicItem = ItemInterface.getItem(this.roleId, this.bagId, this.grid);
/* 30 */     if (basicItem == null)
/*    */     {
/* 32 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "指定的道具不存在");
/* 33 */       return false;
/*    */     }
/* 35 */     if (!(basicItem instanceof EquipmentItem))
/*    */     {
/* 37 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "指定的道具不是装备物品");
/* 38 */       return false;
/*    */     }
/* 40 */     EquipmentItem equipmentItem = (EquipmentItem)basicItem;
/* 41 */     int oldLevel = equipmentItem.getBlessLevel();
/* 42 */     equipmentItem.setBlessLevel(this.level);
/* 43 */     equipmentItem.setBlessExp(0);
/* 44 */     if (oldLevel != this.level)
/*    */     {
/* 46 */       EquipmentBlessManager.triggerEquipmentBlessLevelUpdated(this.roleId, equipmentItem.getFirstUuid().longValue(), oldLevel, this.level);
/*    */     }
/* 48 */     GmManager.getInstance().sendResultToGM(this.gmRoleId, String.format("已重置装备物品的祝福等级为%d", new Object[] { Integer.valueOf(this.level) }));
/* 49 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\equipmentbless\main\PGM_SetBlessLevel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
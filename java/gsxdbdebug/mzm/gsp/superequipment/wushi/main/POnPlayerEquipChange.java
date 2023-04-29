/*    */ package mzm.gsp.superequipment.wushi.main;
/*    */ 
/*    */ import java.util.Set;
/*    */ import mzm.gsp.item.event.PlayerEquipChangeProcedure;
/*    */ import mzm.gsp.item.main.EquipChangeArg;
/*    */ import mzm.gsp.item.main.EquipmentItem;
/*    */ import mzm.gsp.item.main.ItemInterface;
/*    */ 
/*    */ public class POnPlayerEquipChange extends PlayerEquipChangeProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     if (!((EquipChangeArg)this.arg).changedWearPos.contains(Integer.valueOf(0)))
/*    */     {
/* 15 */       return false;
/*    */     }
/* 17 */     EquipmentItem equipmentItem = ItemInterface.getRoleEquipByWearPos(((EquipChangeArg)this.arg).roleId, 0, true);
/* 18 */     if ((equipmentItem == null) || (equipmentItem.getSuperEquipmentStage() <= 0))
/*    */     {
/* 20 */       return WuShiManager.putOffWuShi(((EquipChangeArg)this.arg).roleId);
/*    */     }
/*    */     
/* 23 */     return WuShiManager.sendWuShiAward(((EquipChangeArg)this.arg).roleId);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\superequipment\wushi\main\POnPlayerEquipChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
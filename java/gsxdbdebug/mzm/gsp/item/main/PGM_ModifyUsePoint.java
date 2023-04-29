/*    */ package mzm.gsp.item.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PGM_ModifyUsePoint
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int wearPos;
/*    */   private final int newUsePoint;
/*    */   
/*    */   public PGM_ModifyUsePoint(long roleid, int wearPos, int newUsePoint)
/*    */   {
/* 16 */     this.roleId = roleid;
/* 17 */     this.wearPos = wearPos;
/* 18 */     this.newUsePoint = newUsePoint;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 24 */     RoleEquipBag equipBag = ItemManager.getRoleEquipBag(this.roleId);
/* 25 */     if (equipBag == null)
/*    */     {
/* 27 */       return false;
/*    */     }
/*    */     
/* 30 */     BasicItem desItem = equipBag.get(this.wearPos);
/* 31 */     if (!(desItem instanceof EquipmentItem))
/*    */     {
/* 33 */       return false;
/*    */     }
/*    */     
/* 36 */     EquipmentItem equipmentItem = (EquipmentItem)desItem;
/* 37 */     equipmentItem.setExtra(ItemStoreEnum.USE_POINT_VALUE, this.newUsePoint);
/*    */     
/* 39 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PGM_ModifyUsePoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
/*    */ package mzm.gsp.ocpequip.main;
/*    */ 
/*    */ import mzm.gsp.item.main.EquipmentItem;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.superequipment.main.SuperEquipmentInterface;
/*    */ 
/*    */ public class OcpEquipInterface
/*    */ {
/*    */   public static boolean activeNewOccupation(long paramLong, int paramInt1, int paramInt2)
/*    */   {
/* 12 */     return OcpEquipManager.activeNewOccupation(paramLong, paramInt1, paramInt2);
/*    */   }
/*    */   
/*    */   public static boolean switchOccupation(long paramLong, int paramInt1, int paramInt2)
/*    */   {
/* 17 */     int i = RoleInterface.getGender(paramLong);
/* 18 */     return OcpEquipManager.switchOccupation(paramLong, paramInt1, paramInt2, i);
/*    */   }
/*    */   
/*    */   public static boolean genderConvert(long paramLong, int paramInt1, int paramInt2)
/*    */   {
/* 23 */     return OcpEquipManager.genderConvert(paramLong, paramInt1, paramInt2);
/*    */   }
/*    */   
/*    */   public static TransferStrengthLevelBean transferStrengthFromOtherOcpBag(long paramLong, int paramInt, EquipmentItem paramEquipmentItem)
/*    */   {
/* 28 */     return OcpEquipManager.transferStrengthFromOtherOcpBag(paramLong, paramInt, paramEquipmentItem);
/*    */   }
/*    */   
/*    */   public static void transferSuperEquipmentDataFromOtherOcpBag(long paramLong, int paramInt, EquipmentItem paramEquipmentItem)
/*    */   {
/* 33 */     if (!OpenInterface.getOpenStatus(382)) {
/* 34 */       return;
/*    */     }
/* 36 */     if (SuperEquipmentInterface.meetLowestConditionsForSuperEquipment(paramEquipmentItem)) {
/* 37 */       OcpEquipManager.transferSuperEquipmentDataFromOtherOcpBag(paramLong, paramInt, paramEquipmentItem);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ocpequip\main\OcpEquipInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
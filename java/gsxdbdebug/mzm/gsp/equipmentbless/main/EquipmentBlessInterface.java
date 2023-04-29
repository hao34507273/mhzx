/*    */ package mzm.gsp.equipmentbless.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.item.main.RoleEquipBag;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EquipmentBlessInterface
/*    */ {
/*    */   public static Map<Integer, Integer> getProperties(RoleEquipBag equipBag)
/*    */   {
/* 22 */     return EquipmentBlessManager.getPropertiesFromBlessedEquipments(equipBag);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static int getRoleBlessedEquipmentNumberWithGivenLevel(long roleId, int level)
/*    */   {
/* 32 */     return EquipmentBlessManager.getFilteredRoleBlessedEquipmentNumber(roleId, level);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static int getRoleHighestBlessLevel(long roleId)
/*    */   {
/* 42 */     return EquipmentBlessManager.getFilteredRoleHighestBlessLevel(roleId);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\equipmentbless\main\EquipmentBlessInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
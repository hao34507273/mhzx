/*    */ package mzm.gsp.superequipment.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.item.main.EquipmentItem;
/*    */ import mzm.gsp.item.main.RoleEquipBag;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SuperEquipmentInterface
/*    */ {
/*    */   public static Map<Integer, Integer> getProperties(RoleEquipBag equipBag)
/*    */   {
/* 18 */     return SuperEquipmentManager.getProperties(equipBag);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public static int getMaxStrengthLevel(int stage)
/*    */   {
/* 26 */     return SuperEquipmentManager.getMaxStrengthLevel(stage);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public static int getMinStageFromRoleEquipments(long roleId)
/*    */   {
/* 34 */     return SuperEquipmentManager.getMinStageFromRoleEquipments(roleId);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public static boolean meetLowestConditionsForSuperEquipment(EquipmentItem item)
/*    */   {
/* 42 */     return SuperEquipmentManager.meetLowestConditionsForSuperEquipment(item);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\superequipment\main\SuperEquipmentInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
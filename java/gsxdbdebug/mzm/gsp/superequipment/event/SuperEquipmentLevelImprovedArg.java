/*    */ package mzm.gsp.superequipment.event;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SuperEquipmentLevelImprovedArg
/*    */ {
/*    */   public final long roleId;
/*    */   
/*    */ 
/*    */ 
/*    */   public final long uuid;
/*    */   
/*    */ 
/*    */ 
/*    */   public final int level;
/*    */   
/*    */ 
/*    */ 
/*    */   public final boolean isEquipped;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SuperEquipmentLevelImprovedArg(long roleId, long uuid, int level, boolean isEquipped)
/*    */   {
/* 27 */     this.roleId = roleId;
/* 28 */     this.uuid = uuid;
/* 29 */     this.level = level;
/* 30 */     this.isEquipped = isEquipped;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\superequipment\event\SuperEquipmentLevelImprovedArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
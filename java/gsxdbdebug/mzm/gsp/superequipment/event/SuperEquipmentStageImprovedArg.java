/*    */ package mzm.gsp.superequipment.event;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SuperEquipmentStageImprovedArg
/*    */ {
/*    */   public final long roleId;
/*    */   
/*    */ 
/*    */ 
/*    */   public final long uuid;
/*    */   
/*    */ 
/*    */ 
/*    */   public final int stage;
/*    */   
/*    */ 
/*    */ 
/*    */   public final boolean isEquipped;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SuperEquipmentStageImprovedArg(long roleId, long uuid, int stage, boolean isEquipped)
/*    */   {
/* 27 */     this.roleId = roleId;
/* 28 */     this.uuid = uuid;
/* 29 */     this.stage = stage;
/* 30 */     this.isEquipped = isEquipped;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\superequipment\event\SuperEquipmentStageImprovedArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
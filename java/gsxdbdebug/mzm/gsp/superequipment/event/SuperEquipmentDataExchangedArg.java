/*    */ package mzm.gsp.superequipment.event;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SuperEquipmentDataExchangedArg
/*    */ {
/*    */   public final long roleId;
/*    */   
/*    */ 
/*    */ 
/*    */   public final long srcUUID;
/*    */   
/*    */ 
/*    */ 
/*    */   public final long dstUUID;
/*    */   
/*    */ 
/*    */ 
/*    */   public final boolean isSwitchingOccupation;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SuperEquipmentDataExchangedArg(long roleId, long srcUUID, long dstUUID)
/*    */   {
/* 27 */     this.roleId = roleId;
/* 28 */     this.srcUUID = srcUUID;
/* 29 */     this.dstUUID = dstUUID;
/* 30 */     this.isSwitchingOccupation = true;
/*    */   }
/*    */   
/*    */   public SuperEquipmentDataExchangedArg(long roleId, long srcUUID, long dstUUID, boolean isSwitchingOccupation)
/*    */   {
/* 35 */     this.roleId = roleId;
/* 36 */     this.srcUUID = srcUUID;
/* 37 */     this.dstUUID = dstUUID;
/* 38 */     this.isSwitchingOccupation = isSwitchingOccupation;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\superequipment\event\SuperEquipmentDataExchangedArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
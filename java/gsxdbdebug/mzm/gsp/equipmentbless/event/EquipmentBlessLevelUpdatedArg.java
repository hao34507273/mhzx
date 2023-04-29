/*    */ package mzm.gsp.equipmentbless.event;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EquipmentBlessLevelUpdatedArg
/*    */ {
/*    */   public final long roleId;
/*    */   
/*    */ 
/*    */   public final long equipmentUUID;
/*    */   
/*    */   public final int oldLevel;
/*    */   
/*    */   public final int newLevel;
/*    */   
/*    */ 
/*    */   public EquipmentBlessLevelUpdatedArg(long roleId, long equipmentUUID, int oldLevel, int newLevel)
/*    */   {
/* 19 */     this.roleId = roleId;
/* 20 */     this.equipmentUUID = equipmentUUID;
/* 21 */     this.oldLevel = oldLevel;
/* 22 */     this.newLevel = newLevel;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\equipmentbless\event\EquipmentBlessLevelUpdatedArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
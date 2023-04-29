/*    */ package mzm.gsp.singlebattle.grab;
/*    */ 
/*    */ public class EventArg_GrabPositionSuc
/*    */ {
/*    */   private final long roleId;
/*    */   private final int positionCfgId;
/*    */   private final boolean isPositionFirstGrabed;
/*    */   
/*    */   public EventArg_GrabPositionSuc(long roleId, int positionCfgId, boolean isPositionFirstGrabed)
/*    */   {
/* 11 */     this.roleId = roleId;
/* 12 */     this.positionCfgId = positionCfgId;
/* 13 */     this.isPositionFirstGrabed = isPositionFirstGrabed;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public long getRoleId()
/*    */   {
/* 23 */     return this.roleId;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getPositionCfgId()
/*    */   {
/* 33 */     return this.positionCfgId;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean isFirstGrab()
/*    */   {
/* 43 */     return this.isPositionFirstGrabed;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\grab\EventArg_GrabPositionSuc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
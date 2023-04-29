/*    */ package mzm.gsp.map.main;
/*    */ 
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum CloneRoleNpcModelType
/*    */ {
/* 10 */   MEN_PAI(true), 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 15 */   QI_MAI_HUI_WU(true), 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 20 */   MEN_PAI_STAR(true), 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 25 */   GANG(false);
/*    */   
/*    */   public final boolean cachable;
/*    */   
/*    */   private CloneRoleNpcModelType(boolean cachable)
/*    */   {
/* 31 */     this.cachable = cachable;
/*    */   }
/*    */   
/*    */   public long toKey()
/*    */   {
/* 36 */     return GameServerInfoManager.toGlobalId(ordinal() + 1);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\CloneRoleNpcModelType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
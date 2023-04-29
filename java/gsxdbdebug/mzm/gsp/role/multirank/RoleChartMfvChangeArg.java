/*    */ package mzm.gsp.role.multirank;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RoleChartMfvChangeArg
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */ 
/*    */   private final int beforeMultiFightValue;
/*    */   
/*    */   private final int currentMultiFightValue;
/*    */   
/*    */ 
/*    */   public RoleChartMfvChangeArg(long roleId, int beforeMultiFightValue, int currentMultiFightValue)
/*    */   {
/* 17 */     this.roleId = roleId;
/* 18 */     this.beforeMultiFightValue = beforeMultiFightValue;
/* 19 */     this.currentMultiFightValue = currentMultiFightValue;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public long getRoleId()
/*    */   {
/* 29 */     return this.roleId;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getBeforeMultiFightValue()
/*    */   {
/* 39 */     return this.beforeMultiFightValue;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getCurrentMultiFightValue()
/*    */   {
/* 49 */     return this.currentMultiFightValue;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\multirank\RoleChartMfvChangeArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
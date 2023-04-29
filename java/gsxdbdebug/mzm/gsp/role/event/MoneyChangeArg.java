/*    */ package mzm.gsp.role.event;
/*    */ 
/*    */ 
/*    */ public class MoneyChangeArg
/*    */ {
/*    */   private final long roleId;
/*    */   private final long oldValue;
/*    */   private final long newValue;
/*    */   
/*    */   public MoneyChangeArg(long roleId, long oldValue, long newValue)
/*    */   {
/* 12 */     this.roleId = roleId;
/* 13 */     this.oldValue = oldValue;
/* 14 */     this.newValue = newValue;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public long getRoleId()
/*    */   {
/* 24 */     return this.roleId;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public long getOldValue()
/*    */   {
/* 34 */     return this.oldValue;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public long getNewValue()
/*    */   {
/* 44 */     return this.newValue;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\event\MoneyChangeArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
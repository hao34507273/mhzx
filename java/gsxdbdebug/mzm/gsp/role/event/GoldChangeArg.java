/*    */ package mzm.gsp.role.event;
/*    */ 
/*    */ public class GoldChangeArg
/*    */ {
/*    */   private final long roleId;
/*    */   private final long oldValue;
/*    */   private final long newValue;
/*    */   
/*    */   public GoldChangeArg(long roleId, long oldValue, long newValue)
/*    */   {
/* 11 */     this.roleId = roleId;
/* 12 */     this.oldValue = oldValue;
/* 13 */     this.newValue = newValue;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public long getRoleId()
/*    */   {
/* 22 */     return this.roleId;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public long getOldValue()
/*    */   {
/* 31 */     return this.oldValue;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public long getNewValue()
/*    */   {
/* 40 */     return this.newValue;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\event\GoldChangeArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
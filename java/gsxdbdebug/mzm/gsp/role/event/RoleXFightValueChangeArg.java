/*    */ package mzm.gsp.role.event;
/*    */ 
/*    */ public class RoleXFightValueChangeArg
/*    */ {
/*    */   private final long roleId;
/*    */   private final int oldFightValue;
/*    */   private final int newFightValue;
/*    */   
/*    */   public RoleXFightValueChangeArg(long roleId, int oldFightValue, int newFightValue)
/*    */   {
/* 11 */     this.roleId = roleId;
/* 12 */     this.oldFightValue = oldFightValue;
/* 13 */     this.newFightValue = newFightValue;
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
/*    */   public int getOldFightValue()
/*    */   {
/* 31 */     return this.oldFightValue;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getNewFightValue()
/*    */   {
/* 40 */     return this.newFightValue;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\event\RoleXFightValueChangeArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
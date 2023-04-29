/*    */ package mzm.gsp.role.changemodel;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ExteriorReplaceArg
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */ 
/*    */   private final int oldChangeId;
/*    */   
/*    */ 
/*    */   private final int newChangeId;
/*    */   
/*    */ 
/*    */   public ExteriorReplaceArg(long roleId, int oldChangeId, int newChangeId)
/*    */   {
/* 18 */     this.roleId = roleId;
/* 19 */     this.oldChangeId = oldChangeId;
/* 20 */     this.newChangeId = newChangeId;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public long getRoleId()
/*    */   {
/* 30 */     return this.roleId;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getOldChangeId()
/*    */   {
/* 40 */     return this.oldChangeId;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getNewChangeId()
/*    */   {
/* 50 */     return this.newChangeId;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\changemodel\ExteriorReplaceArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
/*    */ package mzm.gsp.shitu.event;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BaiShiArg
/*    */ {
/*    */   private final long masterRoleId;
/*    */   
/*    */   private final long apprenticeRoleId;
/*    */   
/*    */   private final boolean isSuccess;
/*    */   
/*    */ 
/*    */   public BaiShiArg(long masterRoleId, long apprenticeRoleId, boolean isSuccess)
/*    */   {
/* 16 */     this.masterRoleId = masterRoleId;
/* 17 */     this.apprenticeRoleId = apprenticeRoleId;
/* 18 */     this.isSuccess = isSuccess;
/*    */   }
/*    */   
/*    */   public long getMasterRoleId()
/*    */   {
/* 23 */     return this.masterRoleId;
/*    */   }
/*    */   
/*    */   public long getApprenticeRoleId()
/*    */   {
/* 28 */     return this.apprenticeRoleId;
/*    */   }
/*    */   
/*    */   public boolean isSuccess()
/*    */   {
/* 33 */     return this.isSuccess;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\event\BaiShiArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
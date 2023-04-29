/*    */ package mzm.gsp.homeland.event;
/*    */ 
/*    */ 
/*    */ public class CleanlinessArg
/*    */ {
/*    */   public final long ownerRoleId;
/*    */   
/*    */   public final long partnerRoleId;
/*    */   
/*    */   public final int oldCleanliness;
/*    */   public final int newCleanliness;
/*    */   
/*    */   public CleanlinessArg(long ownerRoleId, long partnerRoleid, int oldCleanliness, int newCleanliness)
/*    */   {
/* 15 */     this.ownerRoleId = ownerRoleId;
/* 16 */     this.partnerRoleId = partnerRoleid;
/* 17 */     this.oldCleanliness = oldCleanliness;
/* 18 */     this.newCleanliness = newCleanliness;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\event\CleanlinessArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
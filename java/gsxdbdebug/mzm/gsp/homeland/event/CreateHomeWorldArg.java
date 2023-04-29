/*    */ package mzm.gsp.homeland.event;
/*    */ 
/*    */ 
/*    */ public class CreateHomeWorldArg
/*    */ {
/*    */   public final long ownerRoleId;
/*    */   
/*    */   public final long partnerRoleId;
/*    */   
/*    */   public final long homeWorldId;
/*    */   
/*    */ 
/*    */   public CreateHomeWorldArg(long ownerRoleId, long partnerRoleid, long homeWorldId)
/*    */   {
/* 15 */     this.ownerRoleId = ownerRoleId;
/* 16 */     this.partnerRoleId = partnerRoleid;
/* 17 */     this.homeWorldId = homeWorldId;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\event\CreateHomeWorldArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
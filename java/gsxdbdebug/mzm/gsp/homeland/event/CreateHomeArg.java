/*    */ package mzm.gsp.homeland.event;
/*    */ 
/*    */ 
/*    */ public class CreateHomeArg
/*    */ {
/*    */   public final long ownerRoleId;
/*    */   
/*    */   public final long partnerRoleId;
/*    */   
/*    */   public final int homeLevel;
/*    */   
/*    */ 
/*    */   public CreateHomeArg(long ownerRoleId, long partnerRoleid, int homeLevel)
/*    */   {
/* 15 */     this.ownerRoleId = ownerRoleId;
/* 16 */     this.partnerRoleId = partnerRoleid;
/* 17 */     this.homeLevel = homeLevel;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\event\CreateHomeArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
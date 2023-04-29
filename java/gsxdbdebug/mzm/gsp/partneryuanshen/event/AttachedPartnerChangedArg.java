/*    */ package mzm.gsp.partneryuanshen.event;
/*    */ 
/*    */ 
/*    */ public class AttachedPartnerChangedArg
/*    */ {
/*    */   public final long roleId;
/*    */   
/*    */   public final int position;
/*    */   
/*    */   public final int oldPartnerId;
/*    */   public final int newPartnerId;
/*    */   
/*    */   public AttachedPartnerChangedArg(long roleId, int position, int oldPartnerId, int newPartnerId)
/*    */   {
/* 15 */     this.roleId = roleId;
/* 16 */     this.position = position;
/* 17 */     this.oldPartnerId = oldPartnerId;
/* 18 */     this.newPartnerId = newPartnerId;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\partneryuanshen\event\AttachedPartnerChangedArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
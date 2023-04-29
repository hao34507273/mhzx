/*    */ package mzm.gsp.avatar.event;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class OwnedAvatarCountChangedArg
/*    */ {
/*    */   public final long roleId;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public final Reason reason;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public OwnedAvatarCountChangedArg(long roleId, Reason reason)
/*    */   {
/* 21 */     this.roleId = roleId;
/* 22 */     this.reason = reason;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public static enum Reason
/*    */   {
/* 30 */     AVATAR_UNLOCKED, 
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 35 */     AVATAR_EXPIRED, 
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 40 */     OCCUPATION_CHANGED, 
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 45 */     REMOVED_BY_COMMAND;
/*    */     
/*    */     private Reason() {}
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\avatar\event\OwnedAvatarCountChangedArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
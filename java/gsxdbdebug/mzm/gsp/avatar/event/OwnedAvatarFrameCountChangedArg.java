/*    */ package mzm.gsp.avatar.event;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class OwnedAvatarFrameCountChangedArg
/*    */ {
/*    */   public final long roleId;
/*    */   
/*    */ 
/*    */   public final Reason reason;
/*    */   
/*    */ 
/*    */ 
/*    */   public OwnedAvatarFrameCountChangedArg(long roleId, Reason reason)
/*    */   {
/* 17 */     this.roleId = roleId;
/* 18 */     this.reason = reason;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public static enum Reason
/*    */   {
/* 26 */     AVATAR_FRAME_UNLOCKED, 
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 31 */     AVATAR_FRAME_EXPIRED, 
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 36 */     OCCUPATION_CHANGED, 
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 41 */     REMOVED_BY_COMMAND;
/*    */     
/*    */     private Reason() {}
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\avatar\event\OwnedAvatarFrameCountChangedArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
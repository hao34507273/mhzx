/*    */ package mzm.gsp.avatar.event;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AvatarFrameChangedArg
/*    */ {
/*    */   public final long roleId;
/*    */   
/*    */ 
/*    */ 
/*    */   public final int avatarFrameId;
/*    */   
/*    */ 
/*    */ 
/*    */   public final Reason reason;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public AvatarFrameChangedArg(long roleId, int avatarFrameId, Reason reason)
/*    */   {
/* 23 */     this.roleId = roleId;
/* 24 */     this.avatarFrameId = avatarFrameId;
/* 25 */     this.reason = reason;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public static enum Reason
/*    */   {
/* 33 */     SET_BY_PLAYER, 
/*    */     
/*    */ 
/*    */ 
/* 37 */     FRAME_EXPIRED, 
/*    */     
/*    */ 
/*    */ 
/* 41 */     OCCUPATION_CHANGED, 
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 46 */     REMOVED_BY_COMMAND;
/*    */     
/*    */     private Reason() {}
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\avatar\event\AvatarFrameChangedArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
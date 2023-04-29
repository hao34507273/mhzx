/*    */ package mzm.gsp.avatar.event;
/*    */ 
/*    */ public class ActivateAvatarArg
/*    */ {
/*    */   public static final int BY_PLAYER = 0;
/*    */   public static final int EXPIRED = 1;
/*    */   public static final int OCCUPATION_MISMATCH = 2;
/*    */   public static final int REMOVED = 4;
/*    */   public final long roleId;
/*    */   public final int reason;
/*    */   
/*    */   public ActivateAvatarArg(long roleId, int reason) {
/* 13 */     this.roleId = roleId;
/* 14 */     this.reason = reason;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\avatar\event\ActivateAvatarArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
/*    */ package mzm.gsp.avatar.frame;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.avatar.SSetAvatarFrameFail;
/*    */ import mzm.gsp.avatar.SSetAvatarFrameSuccess;
/*    */ import mzm.gsp.avatar.event.AvatarFrameChangedArg.Reason;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.RoleAvatarFrame;
/*    */ 
/*    */ public class PSetAvatarFrame
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int avatarFrameId;
/*    */   
/*    */   public PSetAvatarFrame(long roleId, int avatarFrameId)
/*    */   {
/* 19 */     this.roleId = roleId;
/* 20 */     this.avatarFrameId = avatarFrameId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 26 */     if (AvatarFrameManager.isNotEnabled())
/* 27 */       return false;
/* 28 */     if (AvatarFrameManager.inStatusCannotDoRelatedActions(this.roleId))
/* 29 */       return false;
/* 30 */     if (AvatarFrameManager.notMeetRequiredLevel(this.roleId)) {
/* 31 */       return false;
/*    */     }
/*    */     
/* 34 */     RoleAvatarFrame xRoleAvatarFrame = AvatarFrameManager.getRoleAvatarFrame(this.roleId, true);
/*    */     
/* 36 */     if ((xRoleAvatarFrame == null) || (!xRoleAvatarFrame.getAvatar_frames().containsKey(Integer.valueOf(this.avatarFrameId))))
/*    */     {
/* 38 */       AvatarFrameLogger.error("PSetAvatarFrame.processImp()@locked or expired|roleid=%d|avatar_frame_cfgid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.avatarFrameId) });
/*    */       
/* 40 */       notifyFail(1);
/* 41 */       return false;
/*    */     }
/*    */     
/* 44 */     xRoleAvatarFrame.setCurrent_avatar_frame(this.avatarFrameId);
/* 45 */     notifySuccess();
/* 46 */     AvatarFrameManager.triggerAvatarFrameChanged(this.roleId, this.avatarFrameId, AvatarFrameChangedArg.Reason.SET_BY_PLAYER);
/* 47 */     AvatarFrameLogger.useAvatarFrame(this.roleId, this.avatarFrameId);
/* 48 */     AvatarFrameLogger.info("PSetAvatarFrame.processImp()@success|roleid=%d|avatar_frame_cfgid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.avatarFrameId) });
/* 49 */     return true;
/*    */   }
/*    */   
/*    */   private void notifySuccess()
/*    */   {
/* 54 */     SSetAvatarFrameSuccess protocol = new SSetAvatarFrameSuccess();
/* 55 */     protocol.avatar_frame_id = this.avatarFrameId;
/* 56 */     OnlineManager.getInstance().send(this.roleId, protocol);
/*    */   }
/*    */   
/*    */   private void notifyFail(int retcode)
/*    */   {
/* 61 */     SSetAvatarFrameFail protocol = new SSetAvatarFrameFail();
/* 62 */     protocol.retcode = retcode;
/* 63 */     OnlineManager.getInstance().sendAtOnce(this.roleId, protocol);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\avatar\frame\PSetAvatarFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
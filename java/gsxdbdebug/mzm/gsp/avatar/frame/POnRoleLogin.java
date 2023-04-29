/*    */ package mzm.gsp.avatar.frame;
/*    */ 
/*    */ import java.util.LinkedList;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.avatar.AvatarFrameInfo;
/*    */ import mzm.gsp.avatar.SSyncAvatarFrameInfo;
/*    */ import mzm.gsp.avatar.confbean.SAvatarFrameConsts;
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import xbean.RoleAvatarFrame;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnRoleLogin
/*    */   extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 22 */     RoleAvatarFrame xRoleAvatarFrame = AvatarFrameManager.getRoleAvatarFrame(((Long)this.arg).longValue(), true);
/* 23 */     if (xRoleAvatarFrame != null)
/*    */     {
/* 25 */       AvatarFrameExpireManager.cleanExpiredAvatarFrames(xRoleAvatarFrame, ((Long)this.arg).longValue());
/* 26 */       Map<Integer, Long> xSessionMap = AvatarFrameManager.getOrCreateRoleAvatarFrameSessionMap(((Long)this.arg).longValue());
/* 27 */       AvatarFrameExpireManager.startSessions(xRoleAvatarFrame, xSessionMap, ((Long)this.arg).longValue());
/*    */     }
/* 29 */     syncRoleAvatarFrame(xRoleAvatarFrame);
/* 30 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private void syncRoleAvatarFrame(RoleAvatarFrame xRoleAvatarFrame)
/*    */   {
/* 39 */     SSyncAvatarFrameInfo protocol = new SSyncAvatarFrameInfo();
/* 40 */     if (xRoleAvatarFrame == null)
/*    */     {
/* 42 */       int defaultAvatarFrameId = SAvatarFrameConsts.getInstance().DEFAULT_AVATAR_FRAME_ID;
/* 43 */       protocol.current_avatar_frame_id = defaultAvatarFrameId;
/* 44 */       AvatarFrameInfo info = new AvatarFrameInfo();
/* 45 */       info.id = defaultAvatarFrameId;
/* 46 */       info.expire_time = 0;
/* 47 */       protocol.unlocked_avatar_frame.add(info);
/*    */     }
/*    */     else
/*    */     {
/* 51 */       protocol.current_avatar_frame_id = xRoleAvatarFrame.getCurrent_avatar_frame();
/* 52 */       for (Map.Entry<Integer, Integer> entry : xRoleAvatarFrame.getAvatar_frames().entrySet())
/*    */       {
/* 54 */         AvatarFrameInfo info = new AvatarFrameInfo();
/* 55 */         info.id = ((Integer)entry.getKey()).intValue();
/* 56 */         info.expire_time = ((Integer)entry.getValue()).intValue();
/* 57 */         protocol.unlocked_avatar_frame.add(info);
/*    */       }
/*    */     }
/* 60 */     OnlineManager.getInstance().send(((Long)this.arg).longValue(), protocol);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\avatar\frame\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
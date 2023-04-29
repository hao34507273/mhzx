/*    */ package mzm.gsp.avatar.frame;
/*    */ 
/*    */ import mzm.gsp.avatar.confbean.SAvatarFrameCfg;
/*    */ import mzm.gsp.avatar.confbean.SAvatarFrameConsts;
/*    */ import mzm.gsp.avatar.event.AvatarFrameChangedArg.Reason;
/*    */ import mzm.gsp.avatar.event.OwnedAvatarFrameCountChangedArg.Reason;
/*    */ import mzm.gsp.genderconvert.main.GenderConvertHandler;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.RoleAvatarFrame;
/*    */ 
/*    */ public class AvatarFrameGenderConvertHandler
/*    */   implements GenderConvertHandler
/*    */ {
/*    */   public boolean onActivateGenderConvert(long paramLong, int paramInt1, int paramInt2)
/*    */   {
/* 16 */     return new PHandleAvatarFrameOnGenderChanged(paramLong, paramInt1, null).call();
/*    */   }
/*    */   
/*    */   private class PHandleAvatarFrameOnGenderChanged
/*    */     extends LogicProcedure
/*    */   {
/*    */     private final long roleId;
/*    */     private final int gender;
/*    */     
/*    */     private PHandleAvatarFrameOnGenderChanged(long paramLong, int paramInt)
/*    */     {
/* 27 */       this.roleId = paramLong;
/* 28 */       this.gender = paramInt;
/*    */     }
/*    */     
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 34 */       RoleAvatarFrame localRoleAvatarFrame = AvatarFrameManager.getRoleAvatarFrame(this.roleId, true);
/* 35 */       if (localRoleAvatarFrame == null) {
/* 36 */         return true;
/*    */       }
/* 38 */       SAvatarFrameCfg localSAvatarFrameCfg = SAvatarFrameCfg.get(localRoleAvatarFrame.getCurrent_avatar_frame());
/* 39 */       if (localSAvatarFrameCfg == null) {
/* 40 */         return true;
/*    */       }
/* 42 */       if ((localSAvatarFrameCfg.genderLimit != 0) && (localSAvatarFrameCfg.genderLimit != this.gender))
/*    */       {
/* 44 */         int i = SAvatarFrameConsts.getInstance().DEFAULT_AVATAR_FRAME_ID;
/* 45 */         localRoleAvatarFrame.setCurrent_avatar_frame(i);
/* 46 */         AvatarFrameManager.triggerAvatarFrameChanged(this.roleId, i, AvatarFrameChangedArg.Reason.OCCUPATION_CHANGED);
/*    */       }
/* 48 */       if (AvatarFrameInterface.getAvatarFrameCount(this.roleId, true, true) != AvatarFrameInterface.getAvatarFrameCount(this.roleId, false, true)) {
/* 49 */         AvatarFrameManager.triggerOwnedAvatarFrameCountChanged(this.roleId, OwnedAvatarFrameCountChangedArg.Reason.OCCUPATION_CHANGED);
/*    */       }
/* 51 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\avatar\frame\AvatarFrameGenderConvertHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
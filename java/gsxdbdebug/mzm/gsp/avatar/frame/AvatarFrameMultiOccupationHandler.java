/*    */ package mzm.gsp.avatar.frame;
/*    */ 
/*    */ import mzm.gsp.avatar.confbean.SAvatarFrameCfg;
/*    */ import mzm.gsp.avatar.confbean.SAvatarFrameConsts;
/*    */ import mzm.gsp.avatar.event.AvatarFrameChangedArg.Reason;
/*    */ import mzm.gsp.avatar.event.OwnedAvatarFrameCountChangedArg.Reason;
/*    */ import mzm.gsp.multioccupation.main.MultiOccupHandler;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.RoleAvatarFrame;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AvatarFrameMultiOccupationHandler
/*    */   implements MultiOccupHandler
/*    */ {
/*    */   public boolean onActivateNewOccupation(long roleid, int newOccup, int oldOccup)
/*    */   {
/* 19 */     return new PHandleAvatarFrameOnOccupationChanged(roleid, newOccup, null).call();
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean onSwitchOccupation(long roleid, int newOccup, int oldOccup)
/*    */   {
/* 25 */     return new PHandleAvatarFrameOnOccupationChanged(roleid, newOccup, null).call();
/*    */   }
/*    */   
/*    */   private class PHandleAvatarFrameOnOccupationChanged extends LogicProcedure
/*    */   {
/*    */     private final long roleId;
/*    */     private final int occupationId;
/*    */     
/*    */     private PHandleAvatarFrameOnOccupationChanged(long roleId, int occupationId)
/*    */     {
/* 35 */       this.roleId = roleId;
/* 36 */       this.occupationId = occupationId;
/*    */     }
/*    */     
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 42 */       RoleAvatarFrame xRoleAvatarFrame = AvatarFrameManager.getRoleAvatarFrame(this.roleId, true);
/* 43 */       if (xRoleAvatarFrame == null)
/* 44 */         return true;
/* 45 */       SAvatarFrameCfg cfg = SAvatarFrameCfg.get(xRoleAvatarFrame.getCurrent_avatar_frame());
/* 46 */       if (cfg == null)
/* 47 */         return true;
/* 48 */       if ((cfg.factionLimit != 0) && (cfg.factionLimit != this.occupationId))
/*    */       {
/* 50 */         int defaultAvatarFrameId = SAvatarFrameConsts.getInstance().DEFAULT_AVATAR_FRAME_ID;
/* 51 */         xRoleAvatarFrame.setCurrent_avatar_frame(defaultAvatarFrameId);
/* 52 */         AvatarFrameManager.triggerAvatarFrameChanged(this.roleId, defaultAvatarFrameId, AvatarFrameChangedArg.Reason.OCCUPATION_CHANGED);
/*    */       }
/*    */       
/* 55 */       if (AvatarFrameInterface.getAvatarFrameCount(this.roleId, true, true) != AvatarFrameInterface.getAvatarFrameCount(this.roleId, false, true))
/*    */       {
/*    */ 
/* 58 */         AvatarFrameManager.triggerOwnedAvatarFrameCountChanged(this.roleId, OwnedAvatarFrameCountChangedArg.Reason.OCCUPATION_CHANGED);
/*    */       }
/*    */       
/* 61 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\avatar\frame\AvatarFrameMultiOccupationHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
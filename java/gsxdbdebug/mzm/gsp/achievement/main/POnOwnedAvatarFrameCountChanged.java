/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.avatar.event.OwnedAvatarFrameCountChangedArg;
/*    */ import mzm.gsp.avatar.event.OwnedAvatarFrameCountChangedProcedure;
/*    */ 
/*    */ public class POnOwnedAvatarFrameCountChanged
/*    */   extends OwnedAvatarFrameCountChangedProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */   {
/* 11 */     AchievementManager.updateGoalTypeState(((OwnedAvatarFrameCountChangedArg)this.arg).roleId, 5806, null, "POnOwnedAvatarFrameCountChanged.processImp@handle AVATAR_FRAME_OWN success");
/*    */     
/*    */ 
/*    */ 
/* 15 */     AchievementManager.updateGoalTypeState(((OwnedAvatarFrameCountChangedArg)this.arg).roleId, 5807, null, "POnOwnedAvatarFrameCountChanged.processImp@handle AVATAR_FRAME_SPECIFIC_OWN success");
/*    */     
/*    */ 
/* 18 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnOwnedAvatarFrameCountChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
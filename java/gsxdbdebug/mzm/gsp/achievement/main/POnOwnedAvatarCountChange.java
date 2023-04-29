/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.avatar.event.OwnedAvatarCountChangedArg;
/*    */ import mzm.gsp.avatar.event.OwnedAvatarCountChangedProcedure;
/*    */ 
/*    */ public class POnOwnedAvatarCountChange extends OwnedAvatarCountChangedProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */   {
/* 10 */     AchievementManager.updateGoalTypeState(((OwnedAvatarCountChangedArg)this.arg).roleId, 5802, null, "POnOwnedAvatarCountChange.processImp@handle AVATAR_OWN success");
/*    */     
/*    */ 
/* 13 */     AchievementManager.updateGoalTypeState(((OwnedAvatarCountChangedArg)this.arg).roleId, 5803, null, "POnOwnedAvatarCountChange.processImp@handle AVATAR_SPECIFIC_OWN success");
/*    */     
/*    */ 
/* 16 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnOwnedAvatarCountChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
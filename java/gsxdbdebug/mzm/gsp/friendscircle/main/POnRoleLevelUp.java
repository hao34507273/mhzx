/*    */ package mzm.gsp.friendscircle.main;
/*    */ 
/*    */ import mzm.gsp.friends_circle.confbean.SFriendsCircleConsts;
/*    */ import mzm.gsp.role.event.RoleLevelUpArg;
/*    */ import mzm.gsp.role.event.RoleLevelUpProcedure;
/*    */ 
/*    */ public class POnRoleLevelUp
/*    */   extends RoleLevelUpProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 12 */     long roleId = ((RoleLevelUpArg)this.arg).roleId;
/*    */     
/* 14 */     if (!FriendsCircleManager.isFriendsCircleSwitchOpen(roleId, 451, false))
/*    */     {
/* 16 */       return false;
/*    */     }
/*    */     
/* 19 */     if (!FriendsCircleManager.isRoleLevelFriendsCircleOpen(roleId))
/*    */     {
/* 21 */       return false;
/*    */     }
/*    */     
/* 24 */     int functionOpenRoleLevel = SFriendsCircleConsts.getInstance().friends_circle_open_role_level;
/* 25 */     if ((((RoleLevelUpArg)this.arg).oldLevel <= functionOpenRoleLevel) && (((RoleLevelUpArg)this.arg).newLevel >= functionOpenRoleLevel))
/*    */     {
/* 27 */       FriendsCircleManager.reportRoleInfo(roleId, null);
/*    */       
/* 29 */       return true;
/*    */     }
/*    */     
/* 32 */     FriendsCircleManager.reportRoleLevelInfo(roleId);
/*    */     
/* 34 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friendscircle\main\POnRoleLevelUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
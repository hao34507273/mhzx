/*    */ package mzm.gsp.friendscircle.main;
/*    */ 
/*    */ import mzm.gsp.gang.event.CreateGangProcedure;
/*    */ import mzm.gsp.gang.event.GangArg;
/*    */ 
/*    */ public class POnGangInfoChange
/*    */   extends CreateGangProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     long roleId = ((GangArg)this.arg).roleId;
/*    */     
/* 13 */     if (!FriendsCircleManager.isRoleLevelFriendsCircleOpen(roleId))
/*    */     {
/* 15 */       return false;
/*    */     }
/*    */     
/* 18 */     if (!FriendsCircleManager.isFriendsCircleSwitchOpen(roleId, 451, false))
/*    */     {
/* 20 */       return false;
/*    */     }
/*    */     
/* 23 */     FriendsCircleManager.reportRoleGangInfo(roleId);
/* 24 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friendscircle\main\POnGangInfoChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
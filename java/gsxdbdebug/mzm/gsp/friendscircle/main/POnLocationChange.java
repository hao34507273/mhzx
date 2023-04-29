/*    */ package mzm.gsp.friendscircle.main;
/*    */ 
/*    */ import mzm.gsp.personal.Location;
/*    */ import mzm.gsp.personal.event.LocationArg;
/*    */ import mzm.gsp.personal.event.LocationChangeProcedure;
/*    */ 
/*    */ public class POnLocationChange extends LocationChangeProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     long roleId = ((LocationArg)this.arg).roleId;
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
/* 23 */     FriendsCircleManager.reportRoleLocationInfo(roleId, ((LocationArg)this.arg).newLocation.province, ((LocationArg)this.arg).newLocation.city);
/* 24 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friendscircle\main\POnLocationChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
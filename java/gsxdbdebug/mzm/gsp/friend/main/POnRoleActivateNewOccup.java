/*    */ package mzm.gsp.friend.main;
/*    */ 
/*    */ import mzm.gsp.multioccupation.event.ActivateNewOccupArg;
/*    */ 
/*    */ public class POnRoleActivateNewOccup extends mzm.gsp.multioccupation.event.ActivateNewOccupProcedure {
/*    */   protected boolean processImp() throws Exception {
/*  7 */     long roleid = ((ActivateNewOccupArg)this.arg).roleid;
/*  8 */     RoleFriend roleFriend = RoleFriendManager.getRoleFriend(roleid, true);
/*  9 */     RoleFriendManager.onRoleOccupChange(roleFriend, ((ActivateNewOccupArg)this.arg).newOccup);
/* 10 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friend\main\POnRoleActivateNewOccup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
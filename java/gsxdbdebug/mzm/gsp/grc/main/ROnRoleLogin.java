/*    */ package mzm.gsp.grc.main;
/*    */ 
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.online.event.PlayerLoginRunnable;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xdb.Lockeys;
/*    */ import xtable.User;
/*    */ 
/*    */ public class ROnRoleLogin extends PlayerLoginRunnable
/*    */ {
/*    */   public void process() throws Exception
/*    */   {
/* 13 */     if (GameServerInfoManager.isRoamServer())
/*    */     {
/* 15 */       return;
/*    */     }
/*    */     
/* 18 */     long roleid = ((Long)this.arg).longValue();
/* 19 */     String userid = mzm.gsp.role.main.RoleInterface.getUserId(roleid);
/* 20 */     if (userid == null)
/*    */     {
/* 22 */       return;
/*    */     }
/*    */     
/* 25 */     new POnRoleLoginForAddLoginPrivilageAward(userid, roleid).call();
/*    */     
/* 27 */     new POnRoleLoginForFriends(userid, roleid).call();
/*    */     
/* 29 */     new POnRoleLoginForInvitee(userid, roleid).call();
/*    */     
/* 31 */     new PStatisInviteeDoneShimenTotalTimes(userid, roleid).call();
/*    */     
/* 33 */     new PTryAddInviteFriendsGiftTimes(userid, roleid).call();
/*    */     
/* 35 */     new PTryAddInviteFriendsRebateBindYuanbao(userid, roleid).call();
/*    */     
/* 37 */     new POnRoleLoginForInviter(userid, roleid).call();
/*    */   }
/*    */   
/*    */   static class POnRoleLoginForAddLoginPrivilageAward extends LogicProcedure
/*    */   {
/*    */     private final String userid;
/*    */     private final long roleid;
/*    */     
/*    */     public POnRoleLoginForAddLoginPrivilageAward(String userid, long roleid)
/*    */     {
/* 47 */       this.userid = userid;
/* 48 */       this.roleid = roleid;
/*    */     }
/*    */     
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 54 */       if (!GrcManager.isOpenPrivilege(this.roleid))
/*    */       {
/* 56 */         return false;
/*    */       }
/*    */       
/*    */ 
/* 60 */       Lockeys.lock(Lockeys.get(User.getTable(), this.userid));
/*    */       
/* 62 */       GrcManager.tryUpdateLoginPrivilege(this.userid);
/*    */       
/* 64 */       return GrcManager.tryAddLoginPrivilegeAward(this.userid, this.roleid);
/*    */     }
/*    */   }
/*    */   
/*    */   static class POnRoleLoginForFriends extends LogicProcedure
/*    */   {
/*    */     private final String userid;
/*    */     private final long roleid;
/*    */     
/*    */     public POnRoleLoginForFriends(String userid, long roleid)
/*    */     {
/* 75 */       this.userid = userid;
/* 76 */       this.roleid = roleid;
/*    */     }
/*    */     
/*    */ 
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 83 */       Lockeys.lock(Lockeys.get(User.getTable(), this.userid));
/*    */       
/* 85 */       GrcManager.syncGrcFriendsCountAwardInfo(this.userid, this.roleid);
/*    */       
/* 87 */       GrcManager.tryCalcTopRole(this.userid, this.roleid);
/*    */       
/* 89 */       GrcManager.sendGrcInfoOnLogin(this.userid, this.roleid);
/*    */       
/* 91 */       GrcManager.reportRoles(this.userid);
/*    */       
/* 93 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\main\ROnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
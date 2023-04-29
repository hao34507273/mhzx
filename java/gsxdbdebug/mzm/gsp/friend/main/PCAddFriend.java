/*    */ package mzm.gsp.friend.main;
/*    */ 
/*    */ import mzm.gsp.friend.SFriendNeedValidate;
/*    */ import mzm.gsp.online.main.ForbidInfoManager;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xdb.Procedure;
/*    */ 
/*    */ public class PCAddFriend extends LogicProcedure
/*    */ {
/*    */   private long roleid;
/*    */   private long addFriendid;
/*    */   
/*    */   public PCAddFriend(long roleid, long addFriendid)
/*    */   {
/* 18 */     this.roleid = roleid;
/* 19 */     this.addFriendid = addFriendid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 24 */     String userid = RoleInterface.getUserId(this.roleid);
/* 25 */     if (ForbidInfoManager.isForbidUserFriend(userid))
/*    */     {
/* 27 */       return false;
/*    */     }
/* 29 */     if (ForbidInfoManager.isForbidFriend(this.roleid))
/*    */     {
/* 31 */       return false;
/*    */     }
/* 33 */     boolean ret = RoleStatusInterface.checkCanSetStatus(this.roleid, 180, true);
/* 34 */     if (!ret) {
/* 35 */       return false;
/*    */     }
/*    */     
/* 38 */     if (!RoleInterface.isRoleExist(this.addFriendid, false)) {
/* 39 */       RoleFriendManager.sendError(this.roleid, 13, new String[0]);
/* 40 */       return false;
/*    */     }
/* 42 */     if (!RoleFriendManager.meetLevelRequirementToAddFriend(this.roleid, this.addFriendid))
/*    */     {
/* 44 */       RoleFriendManager.sendError(this.roleid, 22, new String[] { String.valueOf(RoleFriendManager.getAddFriendRequiredLevel(this.addFriendid)) });
/*    */       
/*    */ 
/* 47 */       return false;
/*    */     }
/* 49 */     if (RoleFriendManager.getFriendSet(this.addFriendid))
/*    */     {
/* 51 */       SFriendNeedValidate sFriendNeedValidate = new SFriendNeedValidate();
/* 52 */       sFriendNeedValidate.roleid = this.addFriendid;
/* 53 */       sFriendNeedValidate.name = RoleInterface.getName(this.addFriendid);
/* 54 */       OnlineManager.getInstance().sendAtOnce(this.roleid, sFriendNeedValidate);
/* 55 */       return false;
/*    */     }
/* 57 */     Procedure.execute(new PCAppplyAddFriend(this.roleid, this.addFriendid, ""));
/*    */     
/* 59 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friend\main\PCAddFriend.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
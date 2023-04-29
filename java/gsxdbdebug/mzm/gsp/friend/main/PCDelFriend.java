/*    */ package mzm.gsp.friend.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.marriage.main.MarriageInterface;
/*    */ import mzm.gsp.qingyuan.main.QingYuanInterface;
/*    */ import mzm.gsp.shitu.main.ShiTuInterface;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.sworn.main.SwornInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xtable.Role2friend;
/*    */ 
/*    */ public class PCDelFriend extends LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   private long friendId;
/*    */   
/*    */   public PCDelFriend(long roleId, long friendId)
/*    */   {
/* 21 */     this.roleId = roleId;
/* 22 */     this.friendId = friendId;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 27 */     GameServer.logger().info(String.format("[Friend]PCDelFriend.processImp@del friend|roleid=%d|friendid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.friendId) }));
/*    */     
/* 29 */     boolean ret = RoleStatusInterface.checkCanSetStatus(this.roleId, 182, true);
/* 30 */     if (!ret) {
/* 31 */       return false;
/*    */     }
/* 33 */     lock(Role2friend.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId), Long.valueOf(this.friendId) }));
/* 34 */     if (SwornInterface.isSameSworn(this.roleId, this.friendId)) {
/* 35 */       RoleFriendManager.sendError(this.roleId, 12, new String[0]);
/* 36 */       return false;
/*    */     }
/* 38 */     if (MarriageInterface.getMarriedRoleid(this.roleId) == this.friendId) {
/* 39 */       RoleFriendManager.sendError(this.roleId, 14, new String[0]);
/* 40 */       return false;
/*    */     }
/* 42 */     if (ShiTuInterface.isExistShiTuRelation(this.roleId, this.friendId)) {
/* 43 */       RoleFriendManager.sendError(this.roleId, 15, new String[0]);
/* 44 */       return false;
/*    */     }
/* 46 */     if (QingYuanInterface.isExistQingYuanRelation(this.roleId, this.friendId))
/*    */     {
/* 48 */       RoleFriendManager.sendError(this.roleId, 16, new String[0]);
/* 49 */       return false;
/*    */     }
/* 51 */     RoleFriend roleFriend0 = RoleFriendManager.getRoleFriend(this.roleId, true);
/* 52 */     RoleFriend roleFriend1 = RoleFriendManager.getRoleFriend(this.friendId, true);
/* 53 */     return RoleFriendManager.delFriend(roleFriend0, roleFriend1);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friend\main\PCDelFriend.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
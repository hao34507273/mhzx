/*    */ package mzm.gsp.friend.main;
/*    */ 
/*    */ import xbean.FriendInfo;
/*    */ 
/*    */ public class PGM_AddFriendPoint extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   private String friendName;
/*    */   private int friendPoint;
/*    */   
/*    */   public PGM_AddFriendPoint(long roleId, String friendName, int friendPoint)
/*    */   {
/* 13 */     this.roleId = roleId;
/* 14 */     this.friendName = friendName;
/* 15 */     this.friendPoint = friendPoint;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 20 */     Long friendId = xtable.Name2roleid.select(this.friendName);
/* 21 */     if (friendId == null) {
/* 22 */       return false;
/*    */     }
/* 24 */     lock(xtable.Role2friend.getTable(), java.util.Arrays.asList(new Long[] { friendId, Long.valueOf(this.roleId) }));
/* 25 */     int canAdd = this.friendPoint;
/* 26 */     RoleFriend roleFriend0 = RoleFriendManager.getRoleFriend(this.roleId, true);
/* 27 */     if (roleFriend0.containsRole(friendId.longValue())) {
/* 28 */       FriendInfo friendInfo = (FriendInfo)roleFriend0.getFriendTotalInfo().getFriendinfomap().get(friendId);
/* 29 */       int toMax = mzm.gsp.friend.confbean.SFriendConsts.getInstance().maxQinMiDu - friendInfo.getRelationvalue();
/* 30 */       canAdd = Math.min(toMax, canAdd);
/* 31 */       friendInfo.setRelationvalue(friendInfo.getRelationvalue() + canAdd);
/*    */     }
/*    */     
/* 34 */     RoleFriend roleFriend1 = RoleFriendManager.getRoleFriend(friendId.longValue(), true);
/* 35 */     if (roleFriend1.containsRole(this.roleId)) {
/* 36 */       FriendInfo friendInfo = (FriendInfo)roleFriend1.getFriendTotalInfo().getFriendinfomap().get(Long.valueOf(this.roleId));
/* 37 */       int toMax = mzm.gsp.friend.confbean.SFriendConsts.getInstance().maxQinMiDu - friendInfo.getRelationvalue();
/* 38 */       canAdd = Math.min(toMax, canAdd);
/* 39 */       friendInfo.setRelationvalue(friendInfo.getRelationvalue() + canAdd);
/*    */     }
/*    */     
/* 42 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friend\main\PGM_AddFriendPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
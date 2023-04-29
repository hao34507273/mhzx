/*    */ package mzm.gsp.friend.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ 
/*    */ public class PGM_SetFriendPoint extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   private String friendName;
/*    */   private int friendPoint;
/*    */   
/*    */   public PGM_SetFriendPoint(long roleId, String friendName, int friendPoint)
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
/* 24 */     lock(xtable.Role2friend.getTable(), Arrays.asList(new Long[] { friendId, Long.valueOf(this.roleId) }));
/* 25 */     RoleFriend roleFriend0 = RoleFriendManager.getRoleFriend(this.roleId, true);
/* 26 */     RoleFriend roleFriend1 = RoleFriendManager.getRoleFriend(friendId.longValue(), true);
/* 27 */     RoleFriendManager.setFriendValue(roleFriend0, roleFriend1, this.friendPoint);
/* 28 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friend\main\PGM_SetFriendPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
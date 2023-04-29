/*    */ package mzm.gsp.friend.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class FriendDataDayProcedure extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   FriendDataDayProcedure(long roleId) {
/* 10 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 16 */     RoleFriend roleFriend = RoleFriendManager.getRoleFriend(this.roleId, true);
/* 17 */     return RoleFriendManager.checkAndclearDayData(roleFriend);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friend\main\FriendDataDayProcedure.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
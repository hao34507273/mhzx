/*    */ package mzm.gsp.friend.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ 
/*    */ public class PGM_ClearAll extends mzm.gsp.util.LogicRunnable
/*    */ {
/*    */   private long roleid;
/*    */   
/*    */   public PGM_ClearAll(long roleid) {
/* 10 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   public void process() throws Exception
/*    */   {
/* 15 */     RoleFriend roleFriend = RoleFriendManager.getRoleFriend(this.roleid, false);
/* 16 */     Iterator i$; if (roleFriend.friendSize() > 0) {
/* 17 */       for (i$ = roleFriend.getFriendTotalInfo().getFriendinfomap().keySet().iterator(); i$.hasNext();) { long friendid = ((Long)i$.next()).longValue();
/* 18 */         mzm.gsp.Role.addRoleProcedure(this.roleid, new PCDelFriend(this.roleid, friendid));
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friend\main\PGM_ClearAll.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
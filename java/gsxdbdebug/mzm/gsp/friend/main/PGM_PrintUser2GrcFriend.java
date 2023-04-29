/*    */ package mzm.gsp.friend.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import xbean.RoleGrcFriendInfo;
/*    */ import xbean.UserGrcFriendInfo;
/*    */ import xtable.User2grc_friend;
/*    */ 
/*    */ public class PGM_PrintUser2GrcFriend extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long gmRoleId;
/*    */   private final long roleId;
/*    */   
/*    */   public PGM_PrintUser2GrcFriend(long gmRoleId, long roleId)
/*    */   {
/* 17 */     this.gmRoleId = gmRoleId;
/* 18 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 24 */     String userId = mzm.gsp.role.main.RoleInterface.getUserId(this.roleId);
/* 25 */     if (userId == null)
/*    */     {
/* 27 */       return false;
/*    */     }
/* 29 */     UserGrcFriendInfo xUserGrcFriendInfo = User2grc_friend.get(userId);
/* 30 */     if (xUserGrcFriendInfo == null)
/*    */     {
/* 32 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, String.format("角色%d没有GRC好友信息", new Object[] { Long.valueOf(this.roleId) }));
/* 33 */       return true;
/*    */     }
/* 35 */     for (Map.Entry<Integer, RoleGrcFriendInfo> entry : xUserGrcFriendInfo.getZone2ids().entrySet())
/*    */     {
/* 37 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, String.format("begin: zone %d", new Object[] { entry.getKey() }));
/* 38 */       for (Long roleId : ((RoleGrcFriendInfo)entry.getValue()).getIds())
/*    */       {
/* 40 */         GmManager.getInstance().sendResultToGM(this.gmRoleId, String.format("roleId: %d", new Object[] { roleId }));
/*    */       }
/* 42 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, String.format("end: zone %d", new Object[] { entry.getKey() }));
/*    */     }
/* 44 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friend\main\PGM_PrintUser2GrcFriend.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
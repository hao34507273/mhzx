/*    */ package mzm.gsp.friend.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.blacklist.main.BlacklistInterface;
/*    */ import mzm.gsp.chat.main.ChatInterface;
/*    */ import mzm.gsp.friend.SDisAgreeRes;
/*    */ import mzm.gsp.friend.confbean.SFriendConsts;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xtable.Role2friend;
/*    */ 
/*    */ public class PCAgreeApply extends LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   private long strangerId;
/*    */   
/*    */   public PCAgreeApply(long roleId, long strangerId)
/*    */   {
/* 20 */     this.roleId = roleId;
/* 21 */     this.strangerId = strangerId;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 26 */     boolean checkRet = mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 181, true);
/* 27 */     if (!checkRet) {
/* 28 */       return false;
/*    */     }
/*    */     
/* 31 */     lock(Role2friend.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId), Long.valueOf(this.strangerId) }));
/* 32 */     RoleApply roleApply = RoleFriendManager.getRoleApply(this.roleId, true);
/* 33 */     if ((BlacklistInterface.isInBlacklist(this.roleId, this.strangerId)) || (BlacklistInterface.isInBlacklist(this.strangerId, this.roleId)))
/*    */     {
/* 35 */       if (roleApply.containsRole(this.strangerId)) {
/* 36 */         roleApply.getApplyInfoMap().getApplymap().remove(Long.valueOf(this.strangerId));
/* 37 */         SDisAgreeRes sDisAgreeRes = new SDisAgreeRes();
/* 38 */         sDisAgreeRes.strangerid = this.strangerId;
/* 39 */         OnlineManager.getInstance().send(this.roleId, sDisAgreeRes);
/* 40 */         return true;
/*    */       }
/* 42 */       return false;
/*    */     }
/* 44 */     RoleFriend roleFriend = RoleFriendManager.getRoleFriend(this.roleId, true);
/* 45 */     RoleFriend roleOtherFriend = RoleFriendManager.getRoleFriend(this.strangerId, true);
/* 46 */     boolean ret = RoleFriendManager.agreeApply(roleApply, roleFriend, roleOtherFriend);
/* 47 */     if (ret) {
/* 48 */       ChatInterface.chatToSbNoneRealTime(this.roleId, this.strangerId, SFriendConsts.getInstance().addFriendChatId);
/*    */     }
/* 50 */     return ret;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friend\main\PCAgreeApply.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
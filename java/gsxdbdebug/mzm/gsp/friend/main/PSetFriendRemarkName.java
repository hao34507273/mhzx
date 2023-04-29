/*    */ package mzm.gsp.friend.main;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.friend.SFriendNormalResult;
/*    */ import mzm.gsp.friend.SSetFriendRemarkNameSuccess;
/*    */ import mzm.gsp.friend.confbean.SFriendConsts;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.server.main.AvailableStringArgs;
/*    */ import mzm.gsp.util.CommonUtils;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.FriendInfo;
/*    */ import xbean.FriendTotalInfo;
/*    */ import xtable.Role2friend;
/*    */ 
/*    */ public class PSetFriendRemarkName extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final long friendRoleId;
/*    */   private final String friendRemarkName;
/*    */   
/*    */   public PSetFriendRemarkName(long roleId, long friendRoleId, String friendRemarkName)
/*    */   {
/* 25 */     this.roleId = roleId;
/* 26 */     this.friendRoleId = friendRoleId;
/* 27 */     this.friendRemarkName = friendRemarkName;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 33 */     if (!mzm.gsp.open.main.OpenInterface.getOpenStatus(547))
/*    */     {
/* 35 */       return false;
/*    */     }
/*    */     
/* 38 */     if (Math.ceil(CommonUtils.getUTF16Length(this.friendRemarkName) / 2.0D) > SFriendConsts.getInstance().friendRemarkNameMaxLength)
/*    */     {
/*    */ 
/* 41 */       onFail(32);
/* 42 */       return false;
/*    */     }
/* 44 */     if (!this.friendRemarkName.isEmpty())
/*    */     {
/* 46 */       if (mzm.gsp.sensitive.main.SensitiveInterface.isNameSensitive(this.friendRemarkName))
/*    */       {
/* 48 */         onFail(33);
/* 49 */         return false;
/*    */       }
/*    */       
/* 52 */       if (!AvailableStringArgs.getInstance().isStringUsable(this.friendRemarkName))
/*    */       {
/* 54 */         onFail(34);
/* 55 */         return false;
/*    */       }
/*    */     }
/*    */     
/* 59 */     FriendTotalInfo xFriendTotalInfo = Role2friend.get(Long.valueOf(this.roleId));
/* 60 */     if (xFriendTotalInfo == null)
/*    */     {
/* 62 */       onFail(31);
/* 63 */       return false;
/*    */     }
/* 65 */     FriendInfo xFriendInfo = (FriendInfo)xFriendTotalInfo.getFriendinfomap().get(Long.valueOf(this.friendRoleId));
/* 66 */     if (xFriendInfo == null)
/*    */     {
/* 68 */       onFail(31);
/* 69 */       return false;
/*    */     }
/* 71 */     xFriendInfo.setRemarkname(this.friendRemarkName);
/* 72 */     onSuccess();
/* 73 */     return true;
/*    */   }
/*    */   
/*    */   private void onSuccess() throws java.io.UnsupportedEncodingException
/*    */   {
/* 78 */     SSetFriendRemarkNameSuccess success = new SSetFriendRemarkNameSuccess();
/* 79 */     success.friendid = this.friendRoleId;
/* 80 */     success.remarkname.setString(this.friendRemarkName, "UTF-8");
/* 81 */     OnlineManager.getInstance().send(this.roleId, success);
/* 82 */     GameServer.logger().info(String.format("[Friend]PSetFriendRemarkName.onSuccess()@success|roleid=%d|friend_roleid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.friendRoleId) }));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   private void onFail(int reason)
/*    */   {
/* 89 */     SFriendNormalResult fail = new SFriendNormalResult();
/* 90 */     fail.result = reason;
/* 91 */     OnlineManager.getInstance().sendAtOnce(this.roleId, fail);
/* 92 */     GameServer.logger().error(String.format("[Friend]PSetFriendRemarkName.onFail()@fail|roleid=%d|friend_roleid=%d|reason=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.friendRoleId), Integer.valueOf(reason) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friend\main\PSetFriendRemarkName.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
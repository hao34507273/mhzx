/*    */ package mzm.gsp.marriage.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.friend.main.FriendInterface;
/*    */ import mzm.gsp.marriage.SCanSendGiftToFriend;
/*    */ import mzm.gsp.marriage.confbean.SMarriageConsts;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import org.apache.log4j.Logger;
/*    */ import xtable.Role2marriage;
/*    */ 
/*    */ public class PCCanSendGiftToFriend extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private long roleid;
/*    */   private long friendid;
/*    */   
/*    */   public PCCanSendGiftToFriend(long roleid, long friendid)
/*    */   {
/* 20 */     this.roleid = roleid;
/* 21 */     this.friendid = friendid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 26 */     lock(Role2marriage.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid), Long.valueOf(this.friendid) }));
/* 27 */     boolean isFriend = FriendInterface.isFriend(this.roleid, this.friendid, true);
/* 28 */     if (!isFriend) {
/* 29 */       GameServer.logger().info(String.format("PCSendGiftToFriend.processImp@they are not friends!", new Object[0]));
/* 30 */       return false;
/*    */     }
/* 32 */     SCanSendGiftToFriend canSendGiftToFriend = new SCanSendGiftToFriend();
/* 33 */     Long marriageId = Role2marriage.get(Long.valueOf(this.friendid));
/* 34 */     if (marriageId == null) {
/* 35 */       canSendGiftToFriend.ret = 3;
/* 36 */       canSendGiftToFriend.friendid = this.friendid;
/* 37 */       OnlineManager.getInstance().sendAtOnce(this.roleid, canSendGiftToFriend);
/* 38 */       return false;
/*    */     }
/* 40 */     xbean.Marriage xMarriage = xtable.Marriage.get(marriageId);
/* 41 */     if (xMarriage == null) {
/* 42 */       GameServer.logger().error(String.format("PCSendGiftToFriend.processImp@marriage date wrong|roleid=%d", new Object[] { Long.valueOf(this.friendid) }));
/*    */       
/* 44 */       return false;
/*    */     }
/* 46 */     long time = xMarriage.getMarrytime() + SMarriageConsts.getInstance().giftTime * 60000;
/*    */     
/* 48 */     if (mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis() > time) {
/* 49 */       canSendGiftToFriend.ret = 2;
/* 50 */       canSendGiftToFriend.friendid = this.friendid;
/* 51 */       OnlineManager.getInstance().sendAtOnce(this.roleid, canSendGiftToFriend);
/* 52 */       return false;
/*    */     }
/* 54 */     if (xMarriage.getRoleida() == this.friendid) {
/* 55 */       if (xMarriage.getFriendainfos().containsKey(Long.valueOf(this.roleid))) {
/* 56 */         canSendGiftToFriend.ret = 1;
/* 57 */         canSendGiftToFriend.friendid = this.friendid;
/* 58 */         OnlineManager.getInstance().sendAtOnce(this.roleid, canSendGiftToFriend);
/* 59 */         return false;
/*    */       }
/*    */     }
/* 62 */     else if (xMarriage.getFriendbinfos().containsKey(Long.valueOf(this.roleid))) {
/* 63 */       canSendGiftToFriend.ret = 1;
/* 64 */       canSendGiftToFriend.friendid = this.friendid;
/* 65 */       OnlineManager.getInstance().sendAtOnce(this.roleid, canSendGiftToFriend);
/* 66 */       return false;
/*    */     }
/*    */     
/* 69 */     canSendGiftToFriend.ret = 0;
/* 70 */     canSendGiftToFriend.friendid = this.friendid;
/* 71 */     OnlineManager.getInstance().send(this.roleid, canSendGiftToFriend);
/* 72 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\marriage\main\PCCanSendGiftToFriend.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
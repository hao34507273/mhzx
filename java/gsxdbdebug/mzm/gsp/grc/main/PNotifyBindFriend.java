/*    */ package mzm.gsp.grc.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.util.CommonUtils;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PNotifyBindFriend extends LogicProcedure
/*    */ {
/*    */   private final String userid;
/*    */   private final long roleid;
/*    */   private final BindFriendResponse response;
/*    */   
/*    */   public PNotifyBindFriend(String userid, long roleid, BindFriendResponse response)
/*    */   {
/* 15 */     this.userid = userid;
/* 16 */     this.roleid = roleid;
/* 17 */     this.response = response;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 23 */     String openid = CommonUtils.getOpenId(this.userid);
/* 24 */     long friendRoleid = this.response.roleid;
/* 25 */     int friendZoneid = this.response.zoneid;
/* 26 */     RecallFriendManager.notifyFriend(openid, this.userid, this.roleid, friendRoleid, friendZoneid, this.response.vitalityInfo, this.response.friendVitalityInfo);
/*    */     
/*    */ 
/* 29 */     GameServer.logger().info(String.format("[recall]PNotifyBindFriend.processImp@success|roleid=%d|friend_roleid=%d|friend_zoneid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(friendRoleid), Integer.valueOf(friendZoneid) }));
/*    */     
/*    */ 
/* 32 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\main\PNotifyBindFriend.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
/*    */ package mzm.gsp.grc.main;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.util.CommonUtils;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class RSendBindMail extends LogicRunnable
/*    */ {
/*    */   private final String userid;
/*    */   private final long roleid;
/*    */   private final String friendOpenid;
/*    */   
/*    */   public RSendBindMail(String userid, long roleid, String friendOpenid)
/*    */   {
/* 17 */     this.userid = userid;
/* 18 */     this.roleid = roleid;
/* 19 */     this.friendOpenid = friendOpenid;
/*    */   }
/*    */   
/*    */   public void process()
/*    */     throws Exception
/*    */   {
/* 25 */     String openid = CommonUtils.getOpenId(this.userid);
/* 26 */     long serialNo = RecallFriendManager.getSerialNo();
/*    */     
/* 28 */     SendFriendMailContext context = new SendFriendMailContext();
/* 29 */     context.count = 1;
/* 30 */     context.roleid = this.roleid;
/* 31 */     OctetsStream osContext = new OctetsStream();
/* 32 */     context.marshal(osContext);
/*    */     
/* 34 */     boolean ret = GrcManager.sendBindMail(openid, this.friendOpenid, serialNo, osContext);
/* 35 */     GameServer.logger().info(String.format("[recall]RSendBindMail.process@send bind mail|openid=%s|friend_openid=%s|roleid=%d|ret=%b", new Object[] { openid, this.friendOpenid, Long.valueOf(this.roleid), Boolean.valueOf(ret) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\main\RSendBindMail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
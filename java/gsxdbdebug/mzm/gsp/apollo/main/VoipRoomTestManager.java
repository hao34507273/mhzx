/*    */ package mzm.gsp.apollo.main;
/*    */ 
/*    */ import apollo.ApolloJoinVoipRoomRsp;
/*    */ import com.goldhuman.Common.Octets;
/*    */ import java.io.UnsupportedEncodingException;
/*    */ 
/*    */ public class VoipRoomTestManager
/*    */ {
/*    */   static void onApolloCreateVoipRoomRsp(String userid, long roleid, Octets context)
/*    */   {
/*    */     try
/*    */     {
/* 13 */       apollo.ApolloCreateVoipRoomRsp rsp = new apollo.ApolloCreateVoipRoomRsp();
/* 14 */       rsp.retcode = 0;
/* 15 */       rsp.account.setString(userid, "UTF-8");
/* 16 */       rsp.roleid = roleid;
/* 17 */       rsp.room_id = 10000L;
/* 18 */       rsp.async_data.replace(context);
/* 19 */       ApolloInterface.onApolloCreateVoipRoomRsp(rsp);
/*    */     }
/*    */     catch (UnsupportedEncodingException e) {}
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static void onApolloCloseVoipRoomRsp(String userid, long createrid, long roomid, Octets context)
/*    */   {
/*    */     try
/*    */     {
/* 32 */       apollo.ApolloCloseVoipRoomRsp rsp = new apollo.ApolloCloseVoipRoomRsp();
/* 33 */       rsp.retcode = 0;
/* 34 */       rsp.account.setString(userid, "UTF-8");
/* 35 */       rsp.roleid = createrid;
/* 36 */       rsp.room_id = roomid;
/* 37 */       rsp.async_data.replace(context);
/* 38 */       ApolloInterface.onApolloCloseVoipRoomRsp(rsp);
/*    */     }
/*    */     catch (UnsupportedEncodingException e) {}
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static void onApolloJoinVoipRoomRsp(String userid, long roleid, long roomid, Octets context)
/*    */   {
/*    */     try
/*    */     {
/* 51 */       ApolloJoinVoipRoomRsp rsp = new ApolloJoinVoipRoomRsp();
/* 52 */       rsp.retcode = 0;
/* 53 */       rsp.account.setString(userid, "UTF-8");
/* 54 */       rsp.roleid = roleid;
/* 55 */       rsp.room_id = roomid;
/* 56 */       rsp.user_access.open_id.setString(mzm.gsp.util.CommonUtils.getOpenId(userid), "UTF-8");
/* 57 */       rsp.user_access.member_id = 100;
/* 58 */       rsp.user_access.room_key = 200L;
/* 59 */       rsp.user_access.extra_data = 300L;
/* 60 */       Octets ip1 = new Octets();
/* 61 */       ip1.setString("zulong.com.1", "UTF-8");
/* 62 */       Octets ip2 = new Octets();
/* 63 */       ip2.setString("zulong.com.2", "UTF-8");
/* 64 */       Octets ip3 = new Octets();
/* 65 */       ip3.setString("zulong.com.3", "UTF-8");
/* 66 */       rsp.user_access.access_ip_list.add(ip1);
/* 67 */       rsp.user_access.access_ip_list.add(ip2);
/* 68 */       rsp.user_access.access_ip_list.add(ip3);
/* 69 */       rsp.async_data.replace(context);
/* 70 */       ApolloInterface.onApolloJoinVoipRoomRsp(rsp);
/*    */     }
/*    */     catch (UnsupportedEncodingException e) {}
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static void onApolloExitVoipRoomRsp(String userid, long roleid, long roomid, Octets context)
/*    */   {
/*    */     try
/*    */     {
/* 83 */       apollo.ApolloExitVoipRoomRsp rsp = new apollo.ApolloExitVoipRoomRsp();
/* 84 */       rsp.retcode = 0;
/* 85 */       rsp.account.setString(userid, "UTF-8");
/* 86 */       rsp.roleid = roleid;
/* 87 */       rsp.room_id = roomid;
/* 88 */       rsp.member_id = 100;
/* 89 */       rsp.user_open_id.setString(mzm.gsp.util.CommonUtils.getOpenId(userid), "UTF-8");
/* 90 */       rsp.member_count_after_exit = 10;
/* 91 */       rsp.async_data.replace(context);
/* 92 */       ApolloInterface.onApolloExitVoipRoomRsp(rsp);
/*    */     }
/*    */     catch (UnsupportedEncodingException e) {}
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\apollo\main\VoipRoomTestManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
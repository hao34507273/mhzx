/*    */ package gnet;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import gnet.link.Onlines;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.apollo.main.ApolloInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GdeliveryHelper
/*    */ {
/*    */   public static void regisGameServer()
/*    */   {
/* 18 */     int dbVersion = GameServerInfoManager.getDbVersion();
/* 19 */     if (dbVersion < 1)
/*    */     {
/* 21 */       return;
/*    */     }
/*    */     
/* 24 */     List<Integer> zoneids = GameServerInfoManager.getZoneIds();
/* 25 */     GDeliveryManager mgr = GDeliveryManager.getInstance();
/* 26 */     if (mgr == null)
/*    */     {
/* 28 */       return;
/*    */     }
/*    */     
/* 31 */     RegisGameServerArg arg = new RegisGameServerArg();
/* 32 */     arg.version = dbVersion;
/* 33 */     arg.serverids.addAll(zoneids);
/* 34 */     RegisGameServer rpc = new RegisGameServer(arg);
/* 35 */     if (!mgr.send(rpc))
/*    */     {
/* 37 */       GameServer.logger().warn(String.format("GdeliveryHelper.regisGameServer@send rpc failed|db_version=%d|zone_ids=%s", new Object[] { Integer.valueOf(dbVersion), zoneids.toString() }));
/*    */       
/*    */ 
/* 40 */       return;
/*    */     }
/*    */     
/* 43 */     GameServer.logger().warn(String.format("GdeliveryHelper.regisGameServer@send rpc success|db_version=%d|zone_ids=%s", new Object[] { Integer.valueOf(dbVersion), zoneids.toString() }));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static void onRegisGameServerRsp(RegisGameServerArg arg, RegisGameServerRes res) {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static void sentUserInfoReq(String userid)
/*    */   {
/* 61 */     UserInfoReq core = new UserInfoReq(Octets.wrap(userid, "UTF-8"));
/*    */     
/* 63 */     GDeliveryManager.getInstance().send(core);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static void userInfoRevecier(UserInfoRep userInfoRep)
/*    */   {
/* 73 */     String userid = userInfoRep.userid.getString("UTF-8");
/*    */     
/* 75 */     Onlines.getInstance().insertUserInfo(userid, userInfoRep);
/* 76 */     if (userInfoRep.blisgm == 1)
/*    */     {
/* 78 */       gmLoginIn2(userInfoRep);
/*    */     }
/*    */     
/*    */ 
/* 82 */     GameServer.logger().info(String.format("[deliveryclient]GdeliveryHelper.receive@user info|userid=%s|retcode=%d|loginip=%d|blisgm=%d|auth=%s|algorithm=%d|func=%d|funcparm=%d|gender=%d|device_info=%s|extinfo=%s", new Object[] { userid, Integer.valueOf(userInfoRep.retcode), Integer.valueOf(userInfoRep.loginip), Byte.valueOf(userInfoRep.blisgm), userInfoRep.auth.toString(), Integer.valueOf(userInfoRep.algorithm), Integer.valueOf(userInfoRep.func), Integer.valueOf(userInfoRep.funcparm), Byte.valueOf(userInfoRep.gender), userInfoRep.device_info.getString("UTF-8"), userInfoRep.extinfo.getString("UTF-8") }));
/*    */   }
/*    */   
/*    */   public static void getRetSN(GetAddCashSNReq input) {}
/*    */   
/*    */   public static void getRetSN2(GetAddCashSN2Req input) {}
/*    */   
/*    */   public static void addCash(AddCash input) {}
/*    */   
/*    */   public static void GMLoginIn(QueryUserPrivilege3_Re input) {}
/*    */   
/*    */   public static void sendAuSysMail(SysSendMail2 p) {}
/*    */   
/*    */   public static void queryUserId(QueryUserid2Req p) {}
/*    */   
/*    */   public static void getRoleList(PassportGetRoleListReq protocol) {}
/*    */   
/*    */   public static void gmLoginIn2(UserInfoRep input) {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\gnet\GdeliveryHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
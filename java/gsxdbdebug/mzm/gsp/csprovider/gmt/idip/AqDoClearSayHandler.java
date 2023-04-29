/*    */ package mzm.gsp.csprovider.gmt.idip;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import csprovider.DataBetweenCspAndGame_Re;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.csprovider.gmt.GmtCmdManager;
/*    */ import mzm.gsp.csprovider.main.Retcode;
/*    */ import mzm.gsp.idip.SIdipClearSay;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.tlog.TLogManager;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class AqDoClearSayHandler implements IdipHandler
/*    */ {
/*    */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp) throws Exception
/*    */   {
/* 19 */     String userid = (String)params.get(0);
/* 20 */     long roleid = IdipGmtUtil.getRoleid((String)params.get(1));
/*    */     
/* 22 */     xbean.User xUser = xtable.User.get(userid);
/* 23 */     if (null == xUser)
/*    */     {
/* 25 */       int retcode = Retcode.ACCOUNT_NOT_EXIST.value;
/* 26 */       rsp.retcode = retcode;
/* 27 */       Response response = IdipGmtUtil.getResponse(retcode, "user not found");
/* 28 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */       
/* 30 */       GameServer.logger().error(String.format("[gmt]AqDoClearSayHandler.execute@user not found|userid=%s|roleid=%d", new Object[] { userid, Long.valueOf(roleid) }));
/*    */       
/* 32 */       return;
/*    */     }
/*    */     
/* 35 */     if ((!RoleInterface.isRoleExist(roleid, true)) || (!xUser.getRoleids().contains(Long.valueOf(roleid))))
/*    */     {
/* 37 */       int retcode = Retcode.ROLE_NOT_EXIST.value;
/* 38 */       rsp.retcode = retcode;
/* 39 */       Response response = IdipGmtUtil.getResponse(retcode, "role not found");
/* 40 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */       
/* 42 */       GameServer.logger().error(String.format("[gmt]AqDoClearSayHandler.execute@role not found|userid=%s|user_role_list=%s|roleid=%d", new Object[] { userid, xUser.getRoleids().toString(), Long.valueOf(roleid) }));
/*    */       
/*    */ 
/* 45 */       return;
/*    */     }
/*    */     
/*    */ 
/* 49 */     SIdipClearSay idipClearSay = new SIdipClearSay();
/* 50 */     idipClearSay.roleid = roleid;
/* 51 */     OnlineManager.getInstance().sendAll(idipClearSay);
/*    */     
/* 53 */     rsp.retcode = Retcode.SUCCESS.value;
/* 54 */     Response response = new Response();
/* 55 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */     
/* 57 */     TLogManager.getInstance().addLog(userid, "GMTAqDoClearSay", new Object[] { userid, Long.valueOf(roleid) });
/*    */     
/* 59 */     GameServer.logger().info(String.format("[gmt]AqDoClearSayHandler.execute@clear say done|userid=%s|roleid=%d", new Object[] { userid, Long.valueOf(roleid) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\AqDoClearSayHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
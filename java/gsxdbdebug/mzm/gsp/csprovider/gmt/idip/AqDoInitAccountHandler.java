/*    */ package mzm.gsp.csprovider.gmt.idip;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import csprovider.DataBetweenCspAndGame_Re;
/*    */ import gnet.link.Onlines;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.csprovider.gmt.GmtCmdManager;
/*    */ import mzm.gsp.csprovider.main.Retcode;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.tlog.TLogManager;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class AqDoInitAccountHandler
/*    */   implements IdipHandler
/*    */ {
/*    */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp)
/*    */     throws Exception
/*    */   {
/* 20 */     String userid = (String)params.get(0);
/* 21 */     long roleid = IdipGmtUtil.getRoleid((String)params.get(1));
/*    */     
/* 23 */     xbean.User xUser = xtable.User.get(userid);
/* 24 */     if (null == xUser)
/*    */     {
/* 26 */       int retcode = Retcode.ACCOUNT_NOT_EXIST.value;
/* 27 */       rsp.retcode = retcode;
/* 28 */       Response response = IdipGmtUtil.getResponse(retcode, "user not found");
/* 29 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */       
/* 31 */       GameServer.logger().error(String.format("[gmt]AqDoInitAccountHandler.execute@user not found|userid=%s|roleid=%d", new Object[] { userid, Long.valueOf(roleid) }));
/*    */       
/* 33 */       return;
/*    */     }
/*    */     
/* 36 */     if ((!RoleInterface.isRoleExist(roleid, true)) || (!xUser.getRoleids().contains(Long.valueOf(roleid))))
/*    */     {
/* 38 */       int retcode = Retcode.ROLE_NOT_EXIST.value;
/* 39 */       rsp.retcode = retcode;
/* 40 */       Response response = IdipGmtUtil.getResponse(retcode, "role not found");
/* 41 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */       
/* 43 */       GameServer.logger().error(String.format("[gmt]AqDoInitAccountHandler.execute@role not found|user_id=%s|user_role_list=%s|roleid=%d", new Object[] { userid, xUser.getRoleids().toString(), Long.valueOf(roleid) }));
/*    */       
/*    */ 
/* 46 */       return;
/*    */     }
/*    */     
/*    */ 
/* 50 */     Onlines.getInstance().kick(Long.valueOf(roleid), 2049);
/*    */     
/* 52 */     RoleInterface.removeRoleForIDIP(roleid);
/*    */     
/* 54 */     rsp.retcode = Retcode.SUCCESS.value;
/* 55 */     Response response = new Response();
/* 56 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */     
/* 58 */     TLogManager.getInstance().addLog(userid, "GMTAqDoInitAccount", new Object[] { userid, Long.valueOf(roleid) });
/*    */     
/* 60 */     GameServer.logger().info(String.format("[gmt]AqDoInitAccountHandler.execute@do init account done|userid=%s|roleid=%d", new Object[] { userid, Long.valueOf(roleid) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\AqDoInitAccountHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
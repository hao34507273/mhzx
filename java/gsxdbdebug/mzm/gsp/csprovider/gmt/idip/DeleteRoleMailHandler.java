/*    */ package mzm.gsp.csprovider.gmt.idip;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import csprovider.DataBetweenCspAndGame_Re;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.csprovider.gmt.GmtCmdManager;
/*    */ import mzm.gsp.csprovider.main.Retcode;
/*    */ import mzm.gsp.mail.main.MailInterface;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class DeleteRoleMailHandler implements IdipHandler
/*    */ {
/*    */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp) throws Exception
/*    */   {
/* 17 */     String userid = (String)params.get(0);
/* 18 */     long roleid = IdipGmtUtil.getRoleid((String)params.get(1));
/* 19 */     String tagid = (String)params.get(2);
/* 20 */     int mailid = Integer.parseInt((String)params.get(3));
/*    */     
/* 22 */     xbean.User xUser = xtable.User.get(userid);
/* 23 */     if (null == xUser)
/*    */     {
/* 25 */       int retcode = Retcode.ACCOUNT_NOT_EXIST.value;
/* 26 */       rsp.retcode = retcode;
/* 27 */       Response response = IdipGmtUtil.getResponse(retcode, "user not found");
/* 28 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */       
/* 30 */       GameServer.logger().error(String.format("[gmt]DeleteRoleMailHandler.execute@user not found|userid=%s|roleid=%d|tagid=%s|mailid=%d", new Object[] { userid, Long.valueOf(roleid), tagid, Integer.valueOf(mailid) }));
/*    */       
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
/* 43 */       GameServer.logger().error(String.format("[gmt]DeleteRoleMailHandler.execute@role not found|userid=%s|user_role_list=%s|roleid=%d|tagid=%s|mailid=%d", new Object[] { userid, xUser.getRoleids().toString(), Long.valueOf(roleid), tagid, Integer.valueOf(mailid) }));
/*    */       
/*    */ 
/*    */ 
/* 47 */       return;
/*    */     }
/*    */     
/* 50 */     if ((tagid.isEmpty()) && (mailid <= 0))
/*    */     {
/* 52 */       int retcode = Retcode.DELETE_ROLE_MAIL_PARAMS_INVALID.value;
/* 53 */       rsp.retcode = retcode;
/* 54 */       Response response = IdipGmtUtil.getResponse(retcode, "params invalid");
/* 55 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */       
/* 57 */       GameServer.logger().error(String.format("[gmt]DeleteRoleMailHandler.execute@params invalid|userid=%s|roleid=%d|tagid=%s|mailid=%d", new Object[] { userid, Long.valueOf(roleid), tagid, Integer.valueOf(mailid) }));
/*    */       
/*    */ 
/* 60 */       return;
/*    */     }
/*    */     
/* 63 */     if (!MailInterface.delMailForIdip(roleid, mailid, tagid))
/*    */     {
/* 65 */       int retcode = Retcode.DELETE_ROLE_MAIL_FALIED.value;
/* 66 */       rsp.retcode = retcode;
/* 67 */       Response response = IdipGmtUtil.getResponse(retcode, "delete failed");
/* 68 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */       
/* 70 */       GameServer.logger().error(String.format("[gmt]DeleteRoleMailHandler.execute@del failed|userid=%s|roleid=%d|tagid=%s|mailid=%d", new Object[] { userid, Long.valueOf(roleid), tagid, Integer.valueOf(mailid) }));
/*    */       
/*    */ 
/* 73 */       return;
/*    */     }
/*    */     
/* 76 */     rsp.retcode = Retcode.SUCCESS.value;
/* 77 */     Response response = new Response();
/* 78 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */     
/* 80 */     GameServer.logger().info(String.format("[gmt]DeleteRoleMailHandler.execute@delete role mail success|userid=%s|roleid=%d|tagid=%s|mailid=%d", new Object[] { userid, Long.valueOf(roleid), tagid, Integer.valueOf(mailid) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\DeleteRoleMailHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
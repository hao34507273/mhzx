/*    */ package mzm.gsp.csprovider.gmt.idip;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import csprovider.DataBetweenCspAndGame_Re;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.csprovider.gmt.GmtCmdManager;
/*    */ import mzm.gsp.csprovider.main.Retcode;
/*    */ import mzm.gsp.online.main.ForbidInfoManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class UnbanUserHandler implements IdipHandler
/*    */ {
/*    */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp) throws Exception
/*    */   {
/* 17 */     String userid = (String)params.get(0);
/* 18 */     long roleid = IdipGmtUtil.getRoleid((String)params.get(1));
/*    */     
/* 20 */     xbean.User xUser = xtable.User.get(userid);
/* 21 */     if (null == xUser)
/*    */     {
/* 23 */       int retcode = Retcode.ACCOUNT_NOT_EXIST.value;
/* 24 */       rsp.retcode = retcode;
/* 25 */       Response response = IdipGmtUtil.getResponse(retcode, "user not found");
/* 26 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */       
/* 28 */       GameServer.logger().error(String.format("[gmt]UnbanUserHandler.execute@user not found|userid=%s|roleid=%d", new Object[] { userid, Long.valueOf(roleid) }));
/*    */       
/* 30 */       return;
/*    */     }
/*    */     
/* 33 */     if (roleid > 0L)
/*    */     {
/*    */ 
/* 36 */       if ((!RoleInterface.isRoleExist(roleid, true)) || (!xUser.getRoleids().contains(Long.valueOf(roleid))))
/*    */       {
/* 38 */         int retcode = Retcode.ROLE_NOT_EXIST.value;
/* 39 */         rsp.retcode = retcode;
/* 40 */         Response response = IdipGmtUtil.getResponse(retcode, "role not found");
/* 41 */         rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */         
/* 43 */         GameServer.logger().error(String.format("[gmt]UnbanUserHandler.execute@role not found|userid=%s|roleid=%d", new Object[] { userid, Long.valueOf(roleid) }));
/*    */         
/* 45 */         return;
/*    */       }
/* 47 */       ForbidInfoManager.unforbidRole(roleid);
/*    */ 
/*    */     }
/*    */     else
/*    */     {
/* 52 */       ForbidInfoManager.unforbidUser(userid);
/*    */     }
/*    */     
/* 55 */     rsp.retcode = Retcode.SUCCESS.value;
/* 56 */     Response response = new Response();
/* 57 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */     
/* 59 */     GameServer.logger().info(String.format("[gmt]UnbanUserHandler.execute@unban user or role success|userid=%s|roleid=%d", new Object[] { userid, Long.valueOf(roleid) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\UnbanUserHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
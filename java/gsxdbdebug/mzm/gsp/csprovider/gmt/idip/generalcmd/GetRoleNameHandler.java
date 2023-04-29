/*    */ package mzm.gsp.csprovider.gmt.idip.generalcmd;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import csprovider.DataBetweenCspAndGame_Re;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.csprovider.gmt.GmtCmdManager;
/*    */ import mzm.gsp.csprovider.gmt.idip.IdipGmtUtil;
/*    */ import mzm.gsp.csprovider.gmt.idip.IdipHandler;
/*    */ import mzm.gsp.csprovider.gmt.idip.Response;
/*    */ import mzm.gsp.csprovider.main.Retcode;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class GetRoleNameHandler implements IdipHandler
/*    */ {
/*    */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp) throws Exception
/*    */   {
/* 19 */     long roleid = IdipGmtUtil.getRoleid((String)params.get(0));
/*    */     
/* 21 */     if (!RoleInterface.isRoleExist(roleid, true))
/*    */     {
/* 23 */       int retcode = Retcode.ROLE_NOT_EXIST.value;
/* 24 */       rsp.retcode = retcode;
/* 25 */       Response response = IdipGmtUtil.getResponse(retcode, "role not found");
/* 26 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */       
/* 28 */       GameServer.logger().error(String.format("[gmt]GetRoleNameHandler.execute@query roleid not exist|roleid=%d", new Object[] { Long.valueOf(roleid) }));
/* 29 */       return;
/*    */     }
/*    */     
/* 32 */     String roleName = RoleInterface.getName(roleid);
/*    */     
/* 34 */     rsp.retcode = Retcode.SUCCESS.value;
/* 35 */     Response response = new Response();
/* 36 */     response.msg = String.format("roleName=%s", new Object[] { roleName });
/* 37 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */     
/* 39 */     GameServer.logger().info(String.format("[gmt]GetRoleNameHandler.execute@get role name done|roleid=%d|role_name=%s", new Object[] { Long.valueOf(roleid), roleName }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\generalcmd\GetRoleNameHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
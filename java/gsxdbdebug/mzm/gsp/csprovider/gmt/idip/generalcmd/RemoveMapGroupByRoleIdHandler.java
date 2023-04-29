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
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class RemoveMapGroupByRoleIdHandler implements IdipHandler
/*    */ {
/*    */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp) throws Exception
/*    */   {
/* 20 */     long roleid = IdipGmtUtil.getRoleid((String)params.get(0));
/* 21 */     if (!RoleInterface.isRoleExist(roleid, false))
/*    */     {
/* 23 */       int retcode = Retcode.ROLE_NOT_EXIST.value;
/* 24 */       rsp.retcode = retcode;
/* 25 */       Response response = IdipGmtUtil.getResponse(retcode, "role not found");
/* 26 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */       
/* 28 */       GameServer.logger().error(String.format("[gmt]RemoveMapGroupByRoleIdHandler.execute@role not found|roleid=%d", new Object[] { Long.valueOf(roleid) }));
/*    */       
/* 30 */       return;
/*    */     }
/*    */     
/* 33 */     MapInterface.removeMapGroupByRoleid(roleid);
/*    */     
/* 35 */     rsp.retcode = Retcode.SUCCESS.value;
/* 36 */     Response response = new Response();
/* 37 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */     
/* 39 */     GameServer.logger().info(String.format("[gmt]RemoveMapGroupByRoleIdHandler.execute@remove map gorup done|roleid=%d", new Object[] { Long.valueOf(roleid) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\generalcmd\RemoveMapGroupByRoleIdHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
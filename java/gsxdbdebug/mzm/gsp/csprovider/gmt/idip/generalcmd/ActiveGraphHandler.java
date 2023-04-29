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
/*    */ import mzm.gsp.task.main.IDIP_ActivieGraphRes;
/*    */ import mzm.gsp.task.main.TaskInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class ActiveGraphHandler implements IdipHandler
/*    */ {
/*    */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp) throws Exception
/*    */   {
/* 21 */     long roleid = Long.parseLong((String)params.get(0));
/* 22 */     int graphid = Integer.parseInt((String)params.get(1));
/*    */     
/* 24 */     if (!RoleInterface.isRoleExist(roleid, false))
/*    */     {
/* 26 */       int retcode = Retcode.ROLE_NOT_EXIST.value;
/* 27 */       rsp.retcode = retcode;
/* 28 */       Response response = IdipGmtUtil.getResponse(retcode, "role not found");
/* 29 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */       
/* 31 */       GameServer.logger().error(String.format("[gmt]ActiveGraphHandler.execute@active graph failed|graphid=%d|roleid=%d", new Object[] { Integer.valueOf(graphid), Long.valueOf(roleid) }));
/*    */       
/* 33 */       return;
/*    */     }
/*    */     
/* 36 */     IDIP_ActivieGraphRes result = TaskInterface.idipActiveGraph(roleid, graphid);
/* 37 */     if (!result.isActiveSuc())
/*    */     {
/* 39 */       int retcode = Retcode.ACTIVE_GRAPH_FAILED.value;
/* 40 */       rsp.retcode = retcode;
/* 41 */       Response response = IdipGmtUtil.getResponse(retcode, "active graph failed");
/* 42 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */       
/* 44 */       GameServer.logger().error(String.format("[gmt]ActiveGraphHandler.execute@active graph failed|graphid=%d|roleid=%d|retcode=%d", new Object[] { Integer.valueOf(graphid), Long.valueOf(roleid), Integer.valueOf(result.getReasonValue()) }));
/*    */       
/*    */ 
/* 47 */       return;
/*    */     }
/*    */     
/* 50 */     rsp.retcode = Retcode.SUCCESS.value;
/* 51 */     Response response = new Response();
/* 52 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */     
/* 54 */     GameServer.logger().info(String.format("[gmt]ActiveGraphHandler.execute@active graph done|roleid=%d|graphid=%d", new Object[] { Integer.valueOf(graphid), Long.valueOf(roleid) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\generalcmd\ActiveGraphHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
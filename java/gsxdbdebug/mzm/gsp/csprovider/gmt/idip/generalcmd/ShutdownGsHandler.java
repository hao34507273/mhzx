/*    */ package mzm.gsp.csprovider.gmt.idip.generalcmd;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import csprovider.DataBetweenCspAndGame_Re;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.csprovider.gmt.GmtCmdManager;
/*    */ import mzm.gsp.csprovider.gmt.idip.IdipHandler;
/*    */ import mzm.gsp.csprovider.gmt.idip.Response;
/*    */ import mzm.gsp.csprovider.main.Retcode;
/*    */ import mzm.gsp.online.main.PGM_ShutDownServer;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class ShutdownGsHandler implements IdipHandler
/*    */ {
/*    */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp) throws Exception
/*    */   {
/* 18 */     int delaySeconds = Integer.valueOf((String)params.get(0)).intValue();
/* 19 */     if (delaySeconds < 0)
/*    */     {
/* 21 */       int retcode = Retcode.SHUTDOWN_GS_DELAY_SECONDS_LESS_THAN_ZERO.value;
/* 22 */       rsp.retcode = retcode;
/* 23 */       Response response = mzm.gsp.csprovider.gmt.idip.IdipGmtUtil.getResponse(retcode, "shutdown gs delaySeconds < 0");
/* 24 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */       
/* 26 */       GameServer.logger().error(String.format("[gmt]ShutdownGsHandler.execute@shutdown gs delaySeconds < 0|delay_seconds=%d", new Object[] { Integer.valueOf(delaySeconds) }));
/*    */       
/* 28 */       return;
/*    */     }
/*    */     
/* 31 */     boolean result = new PGM_ShutDownServer(delaySeconds).call();
/* 32 */     String retMsg = null;
/* 33 */     if (result)
/*    */     {
/* 35 */       rsp.retcode = Retcode.SUCCESS.value;
/* 36 */       retMsg = String.format("gs will shutdown after %d second", new Object[] { Integer.valueOf(delaySeconds) });
/*    */     }
/*    */     else
/*    */     {
/* 40 */       rsp.retcode = Retcode.SHUTDOWN_GS_FAIL.value;
/* 41 */       retMsg = "shutdown gs fail";
/*    */     }
/*    */     
/* 44 */     Response response = new Response();
/* 45 */     response.msg = retMsg;
/* 46 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */     
/* 48 */     GameServer.logger().info(String.format("[gmt]ShutdownGsHandler.execute@shutdown gs done|ret=%d|ret_msg=%s|delaySeconds=%d|result=%b", new Object[] { Integer.valueOf(rsp.retcode), retMsg, Integer.valueOf(delaySeconds), Boolean.valueOf(result) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\generalcmd\ShutdownGsHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
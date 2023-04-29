/*    */ package mzm.gsp.csprovider.gmt.idip.generalcmd;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import csprovider.DataBetweenCspAndGame_Re;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.csprovider.gmt.GmtCmdManager;
/*    */ import mzm.gsp.csprovider.gmt.idip.IdipGmtUtil;
/*    */ import mzm.gsp.csprovider.gmt.idip.Response;
/*    */ import mzm.gsp.csprovider.main.Retcode;
/*    */ import mzm.gsp.online.main.PGM_SetMaxQueueSize;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class SetMaxQueueSizeHandler implements mzm.gsp.csprovider.gmt.idip.IdipHandler
/*    */ {
/*    */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp) throws Exception
/*    */   {
/* 18 */     int maxQueueSize = Integer.parseInt((String)params.get(0));
/* 19 */     if (maxQueueSize <= 0)
/*    */     {
/* 21 */       int retcode = Retcode.MAX_QUEUE_SIZE_INVALID.value;
/* 22 */       rsp.retcode = retcode;
/* 23 */       Response response = IdipGmtUtil.getResponse(retcode, "max queue size <= 0");
/* 24 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */       
/* 26 */       GameServer.logger().error(String.format("[gmt]SetMaxQueueSizeHandler.execute@maxQueueSize <= 0|maxQueueSize=%d", new Object[] { Integer.valueOf(maxQueueSize) }));
/*    */       
/* 28 */       return;
/*    */     }
/*    */     
/* 31 */     if (!new PGM_SetMaxQueueSize(maxQueueSize).call())
/*    */     {
/* 33 */       int retcode = Retcode.SET_MAX_QUEUE_SIZE_FAILED.value;
/* 34 */       rsp.retcode = retcode;
/* 35 */       Response response = IdipGmtUtil.getResponse(retcode, "set max queue size failed");
/* 36 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */       
/* 38 */       GameServer.logger().error(String.format("[gmt]SetMaxQueueSizeHandler.execute@set max queue size failed|maxQueueSize=%d", new Object[] { Integer.valueOf(maxQueueSize) }));
/*    */       
/* 40 */       return;
/*    */     }
/*    */     
/* 43 */     rsp.retcode = Retcode.SUCCESS.value;
/* 44 */     Response response = new Response();
/* 45 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */     
/* 47 */     GameServer.logger().info(String.format("[gmt]SetMaxQueueSizeHandler.execute@set max queue size done|maxQueueSize=%d", new Object[] { Integer.valueOf(maxQueueSize) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\generalcmd\SetMaxQueueSizeHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
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
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class GetMapProtocolSendQueueSizeHandler implements IdipHandler
/*    */ {
/*    */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp) throws Exception
/*    */   {
/* 18 */     int number = MapInterface.getMapProtocolSendQueueSize();
/*    */     
/* 20 */     rsp.retcode = Retcode.SUCCESS.value;
/* 21 */     String retMsg = String.format("mapProtocolSendQueueSize=%d", new Object[] { Integer.valueOf(number) });
/* 22 */     Response response = new Response();
/* 23 */     response.msg = retMsg;
/* 24 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */     
/* 26 */     GameServer.logger().info(String.format("[gmt]GetMapProtocolSendQueueSizeHandler.execute@get map_protocol_send_queue_size done|map_protocol_send_queue_size=%d", new Object[] { Integer.valueOf(number) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\generalcmd\GetMapProtocolSendQueueSizeHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
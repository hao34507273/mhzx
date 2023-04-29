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
/*    */ import org.apache.log4j.Logger;
/*    */ import xdb.Xdb;
/*    */ 
/*    */ public class SetRemoteFlushRecordSpeedHandler implements IdipHandler
/*    */ {
/*    */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp) throws Exception
/*    */   {
/* 18 */     Integer speed = Integer.valueOf((String)params.get(0));
/*    */     
/* 20 */     if (speed.intValue() <= 0)
/*    */     {
/* 22 */       int retcode = Retcode.REMOTE_FLUSH_RECORD_SPEED_LESS_THAN_ZERO.value;
/* 23 */       rsp.retcode = retcode;
/* 24 */       Response response = mzm.gsp.csprovider.gmt.idip.IdipGmtUtil.getResponse(retcode, "speed <= 0");
/* 25 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */       
/* 27 */       GameServer.logger().error(String.format("[gmt]SetRemoteFlushRecordSpeedHandler.execute@speed <= 0|speed=%d", new Object[] { speed }));
/* 28 */       return;
/*    */     }
/*    */     
/* 31 */     Xdb.getInstance().getConf().setRemoteFlushRecordSpeed(speed.intValue());
/*    */     
/* 33 */     rsp.retcode = Retcode.SUCCESS.value;
/* 34 */     String retMsg = String.format("remote flush record speed = %d", new Object[] { speed });
/* 35 */     Response response = new Response();
/* 36 */     response.msg = retMsg;
/* 37 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */     
/* 39 */     GameServer.logger().info(String.format("[gmt]SetRemoteFlushRecordSpeedHandler.executeCmd@set remote flush record speed done|speed=%d", new Object[] { speed }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\generalcmd\SetRemoteFlushRecordSpeedHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
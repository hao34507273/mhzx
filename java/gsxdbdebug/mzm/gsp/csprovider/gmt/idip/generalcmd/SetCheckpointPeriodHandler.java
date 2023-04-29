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
/*    */ import xdb.XdbConf;
/*    */ 
/*    */ public class SetCheckpointPeriodHandler implements IdipHandler
/*    */ {
/*    */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp) throws Exception
/*    */   {
/* 19 */     Integer period = Integer.valueOf((String)params.get(0));
/*    */     
/* 21 */     if (period.intValue() <= 60)
/*    */     {
/* 23 */       int retcode = Retcode.CHECK_POINT_PERIOD_TOO_LITTLE.value;
/* 24 */       rsp.retcode = retcode;
/* 25 */       Response response = mzm.gsp.csprovider.gmt.idip.IdipGmtUtil.getResponse(retcode, "period <= 60");
/* 26 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */       
/* 28 */       GameServer.logger().error(String.format("[gmt]SetCheckpointPeriodHandler.execute@period <= 0|period=%d", new Object[] { period }));
/* 29 */       return;
/*    */     }
/*    */     
/* 32 */     Xdb.getInstance().getConf().setCheckpointPeriod(period.intValue() * 1000);
/*    */     
/* 34 */     rsp.retcode = Retcode.SUCCESS.value;
/* 35 */     String retMsg = String.format("checkpoint period = %d", new Object[] { period });
/* 36 */     Response response = new Response();
/* 37 */     response.msg = retMsg;
/* 38 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */     
/* 40 */     GameServer.logger().info(String.format("[gmt]SetCheckpointPeriodHandler.execute@set checkpoint period done|period=%d", new Object[] { period }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\generalcmd\SetCheckpointPeriodHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
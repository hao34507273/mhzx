/*    */ package mzm.gsp.csprovider.gmt.idip.generalcmd;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import csprovider.DataBetweenCspAndGame_Re;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.activity.main.ActivityForIDIPResult;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.csprovider.gmt.GmtCmdManager;
/*    */ import mzm.gsp.csprovider.gmt.idip.IdipGmtUtil;
/*    */ import mzm.gsp.csprovider.gmt.idip.IdipHandler;
/*    */ import mzm.gsp.csprovider.gmt.idip.Response;
/*    */ import mzm.gsp.csprovider.main.Retcode;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class ActivityCloseHandler implements IdipHandler
/*    */ {
/*    */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp) throws Exception
/*    */   {
/* 20 */     int activityCfgid = Integer.parseInt((String)params.get(0));
/* 21 */     ActivityForIDIPResult result = ActivityInterface.closeActivityForIDIP(activityCfgid);
/* 22 */     if (result != ActivityForIDIPResult.SUCCESS)
/*    */     {
/* 24 */       int retcode = Retcode.CLOSE_ACTIVITY_FAILED.value;
/* 25 */       rsp.retcode = retcode;
/* 26 */       Response response = IdipGmtUtil.getResponse(retcode, result.retString);
/* 27 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */       
/* 29 */       GameServer.logger().error(String.format("[gmt]ActivityCloseHandler.execute@close activity failed|ret=%d|ret_msg=%s|activity_cfgid=%d", new Object[] { Integer.valueOf(result.retCode), result.retString, Integer.valueOf(activityCfgid) }));
/*    */       
/*    */ 
/*    */ 
/* 33 */       return;
/*    */     }
/*    */     
/* 36 */     rsp.retcode = Retcode.SUCCESS.value;
/* 37 */     Response response = new Response();
/* 38 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */     
/* 40 */     GameServer.logger().info(String.format("[gmt]ActivityCloseHandler.execute@close activity done|activity_cfgid=%d", new Object[] { Integer.valueOf(activityCfgid) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\generalcmd\ActivityCloseHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
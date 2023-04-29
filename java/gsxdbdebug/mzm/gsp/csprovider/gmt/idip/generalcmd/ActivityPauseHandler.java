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
/*    */ public class ActivityPauseHandler implements IdipHandler
/*    */ {
/*    */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp) throws Exception
/*    */   {
/* 20 */     int activityCfgid = Integer.parseInt((String)params.get(0));
/* 21 */     boolean pause = Integer.parseInt((String)params.get(1)) == 1;
/* 22 */     ActivityForIDIPResult result = ActivityInterface.pauseActivityForIDIP(activityCfgid, pause);
/* 23 */     if (result != ActivityForIDIPResult.SUCCESS)
/*    */     {
/* 25 */       int retcode = Retcode.PAUSE_ACTIVITY_INVALID.value;
/* 26 */       rsp.retcode = retcode;
/* 27 */       Response response = IdipGmtUtil.getResponse(retcode, result.retString);
/* 28 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */       
/* 30 */       GameServer.logger().error(String.format("[gmt]ActivityPauseHandler.execute@pause activity failed|ret=%d|ret_msg=%s|activity_cfgid=%d|pause=%b", new Object[] { Integer.valueOf(result.retCode), result.retString, Integer.valueOf(activityCfgid), Boolean.valueOf(pause) }));
/*    */       
/*    */ 
/*    */ 
/* 34 */       return;
/*    */     }
/*    */     
/* 37 */     rsp.retcode = Retcode.SUCCESS.value;
/* 38 */     Response response = new Response();
/* 39 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */     
/* 41 */     GameServer.logger().info(String.format("[gmt]ActivityPauseHandler.execute@pause activity done|activity_cfgid=%d|pause=%b", new Object[] { Integer.valueOf(activityCfgid), Boolean.valueOf(pause) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\generalcmd\ActivityPauseHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
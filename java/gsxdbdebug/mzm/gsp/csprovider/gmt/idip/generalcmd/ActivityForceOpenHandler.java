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
/*    */ public class ActivityForceOpenHandler implements IdipHandler
/*    */ {
/*    */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp) throws Exception
/*    */   {
/* 20 */     int activityCfgid = Integer.parseInt((String)params.get(0));
/* 21 */     int minute = Integer.parseInt((String)params.get(1));
/*    */     
/* 23 */     if ((minute <= 0) && (minute != -1))
/*    */     {
/* 25 */       int retcode = Retcode.FORCE_OPEN_ACTIVITY_MINUTE_INVALID.value;
/* 26 */       rsp.retcode = retcode;
/* 27 */       Response response = IdipGmtUtil.getResponse(retcode, "minute <= 0 && minute != -1");
/* 28 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */       
/* 30 */       GameServer.logger().error(String.format("[gmt]ActivityForceOpenHandler.execute@minute invalid|activity_cfgid=%d|minute=%d", new Object[] { Integer.valueOf(activityCfgid), Integer.valueOf(minute) }));
/*    */       
/*    */ 
/* 33 */       return;
/*    */     }
/*    */     
/* 36 */     ActivityForIDIPResult result = null;
/* 37 */     if (minute == -1)
/*    */     {
/* 39 */       result = ActivityInterface.forceOpenActivityForIDIP(activityCfgid);
/*    */     }
/*    */     else
/*    */     {
/* 43 */       result = ActivityInterface.forceOpenActivityForIDIP(activityCfgid, minute);
/*    */     }
/*    */     
/* 46 */     if (result != ActivityForIDIPResult.SUCCESS)
/*    */     {
/* 48 */       int retcode = Retcode.FORCE_OPEN_ACTIVITY_FAILED.value;
/* 49 */       rsp.retcode = retcode;
/* 50 */       Response response = IdipGmtUtil.getResponse(retcode, result.retString);
/* 51 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */       
/* 53 */       GameServer.logger().error(String.format("[gmt]ActivityForceOpenHandler.execute@force open activity failed|ret=%d|ret_msg=%s|activity_cfgid=%d|minute=%d", new Object[] { Integer.valueOf(result.retCode), result.retString, Integer.valueOf(activityCfgid), Integer.valueOf(minute) }));
/*    */       
/*    */ 
/*    */ 
/* 57 */       return;
/*    */     }
/*    */     
/* 60 */     rsp.retcode = Retcode.SUCCESS.value;
/* 61 */     Response response = new Response();
/* 62 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */     
/* 64 */     GameServer.logger().info(String.format("[gmt]ActivityForceOpenHandler.execute@force open activity done|activity_cfgid=%d|minute=%d", new Object[] { Integer.valueOf(activityCfgid), Integer.valueOf(minute) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\generalcmd\ActivityForceOpenHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
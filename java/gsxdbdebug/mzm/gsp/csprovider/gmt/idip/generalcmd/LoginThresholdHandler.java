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
/*    */ import mzm.gsp.online.main.PGM_SetIntervalLoginNum;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class LoginThresholdHandler implements IdipHandler
/*    */ {
/*    */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp) throws Exception
/*    */   {
/* 19 */     Integer number = Integer.valueOf((String)params.get(0));
/* 20 */     if (number.intValue() <= 0)
/*    */     {
/* 22 */       int retcode = Retcode.INTERVAL_LOGIN_NUM_LESS_THAN_ZERO.value;
/* 23 */       rsp.retcode = retcode;
/* 24 */       Response response = IdipGmtUtil.getResponse(retcode, "interval_login_num <= 0");
/* 25 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */       
/* 27 */       GameServer.logger().error(String.format("[gmt]LoginThresholdHandler.execute@interval_login_num <= 0|interval_login_num=%d", new Object[] { number }));
/*    */       
/* 29 */       return;
/*    */     }
/*    */     
/* 32 */     boolean result = new PGM_SetIntervalLoginNum(number.intValue()).call();
/* 33 */     String retMsg = null;
/* 34 */     if (result)
/*    */     {
/* 36 */       retMsg = String.format("intervalLoginNum=%d", new Object[] { number });
/*    */     }
/*    */     else
/*    */     {
/* 40 */       retMsg = "set interval login num error";
/*    */     }
/*    */     
/* 43 */     Response response = new Response();
/* 44 */     response.msg = retMsg;
/* 45 */     rsp.retcode = Retcode.SUCCESS.value;
/* 46 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */     
/* 48 */     GameServer.logger().info(String.format("[gmt]LoginThresholdHandler.execute@set interval_login_num done|interval_login_num=%d|result=%b", new Object[] { number, Boolean.valueOf(result) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\generalcmd\LoginThresholdHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
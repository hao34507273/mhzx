/*    */ package mzm.gsp.csprovider.gmt.idip.generalcmd;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import csprovider.DataBetweenCspAndGame_Re;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.csprovider.gmt.GmtCmdManager;
/*    */ import mzm.gsp.csprovider.gmt.idip.Response;
/*    */ import mzm.gsp.csprovider.main.Retcode;
/*    */ import mzm.gsp.online.main.PGM_SetAccountNumlimit;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class AccountLimitHandler implements mzm.gsp.csprovider.gmt.idip.IdipHandler
/*    */ {
/*    */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp) throws Exception
/*    */   {
/* 17 */     boolean limit = Integer.valueOf((String)params.get(0)).intValue() == 1;
/*    */     
/* 19 */     boolean result = new PGM_SetAccountNumlimit(limit).call();
/* 20 */     String retMsg = null;
/* 21 */     if (result)
/*    */     {
/* 23 */       rsp.retcode = Retcode.SUCCESS.value;
/* 24 */       retMsg = String.format("accountNumLimit=%b", new Object[] { Boolean.valueOf(limit ? 1 : false) });
/*    */     }
/*    */     else
/*    */     {
/* 28 */       rsp.retcode = Retcode.ACCOUNT_LIMIT_FAILED.value;
/* 29 */       retMsg = "account limit error";
/*    */     }
/* 31 */     Response response = new Response();
/* 32 */     response.retcode = rsp.retcode;
/* 33 */     response.msg = retMsg;
/* 34 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */     
/* 36 */     GameServer.logger().info(String.format("[gmt]AccountLimitReq.execute@set account_limit done|account_limit=%b|result=%b", new Object[] { Boolean.valueOf(limit), Boolean.valueOf(result) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\generalcmd\AccountLimitHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
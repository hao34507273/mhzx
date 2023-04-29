/*    */ package mzm.gsp.csprovider.gmt.idip.generalcmd;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import csprovider.DataBetweenCspAndGame_Re;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.chart.main.PGM_SetSaveDBIntervalSec;
/*    */ import mzm.gsp.csprovider.gmt.GmtCmdManager;
/*    */ import mzm.gsp.csprovider.gmt.idip.IdipGmtUtil;
/*    */ import mzm.gsp.csprovider.gmt.idip.IdipHandler;
/*    */ import mzm.gsp.csprovider.gmt.idip.Response;
/*    */ import mzm.gsp.csprovider.main.Retcode;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class SetRankDBTimerHandler
/*    */   implements IdipHandler
/*    */ {
/*    */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp) throws Exception
/*    */   {
/* 20 */     int number = Integer.valueOf((String)params.get(0)).intValue();
/*    */     
/* 22 */     if (number < 60)
/*    */     {
/* 24 */       String retMsg = String.format("save_rankdb_interval_sec < MIN_INTERVAL_SEC %d", new Object[] { Integer.valueOf(60) });
/*    */       
/* 26 */       int retcode = Retcode.RANK_DB_TIMER_INTERVAL_TOO_MIN.value;
/* 27 */       rsp.retcode = retcode;
/* 28 */       Response response = IdipGmtUtil.getResponse(retcode, retMsg);
/* 29 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */       
/* 31 */       GameServer.logger().error(String.format("[gmt]SetRankDBTimerHandler.execute@save_rankdb_interval_sec must >= MIN_INTERVAL_SEC %d|save_rankdb_interval_sec=%d", new Object[] { Integer.valueOf(60), Integer.valueOf(number) }));
/*    */       
/*    */ 
/*    */ 
/* 35 */       return;
/*    */     }
/*    */     
/* 38 */     boolean result = new PGM_SetSaveDBIntervalSec(number).call();
/* 39 */     String retMsg = null;
/* 40 */     if (result)
/*    */     {
/* 42 */       rsp.retcode = Retcode.SUCCESS.value;
/* 43 */       retMsg = String.format("intervalSec=%d", new Object[] { Integer.valueOf(number) });
/*    */     }
/*    */     else
/*    */     {
/* 47 */       rsp.retcode = Retcode.SET_RANK_DB_TIMER_INTERVAL_FAIL.value;
/* 48 */       retMsg = "set rank db timer intrval fail";
/*    */     }
/*    */     
/* 51 */     Response response = new Response();
/* 52 */     response.retcode = rsp.retcode;
/* 53 */     response.msg = retMsg;
/* 54 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */     
/* 56 */     GameServer.logger().info(String.format("[gmt]SetRankDBTimerHandler.execute@set save_rankdb_interval_sec done|save_rankdb_interval_sec=%d|result=%b", new Object[] { Integer.valueOf(number), Boolean.valueOf(result) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\generalcmd\SetRankDBTimerHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
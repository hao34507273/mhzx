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
/*    */ import mzm.gsp.online.main.PGM_SetMaxPalyerNum;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class MaxOnlineHandler implements IdipHandler
/*    */ {
/*    */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp) throws Exception
/*    */   {
/* 18 */     int number = Integer.valueOf((String)params.get(0)).intValue();
/* 19 */     if (number <= 0)
/*    */     {
/* 21 */       int retcode = Retcode.MAX_ONLINE_NUM_LESS_THAN_ZERO.value;
/* 22 */       rsp.retcode = retcode;
/* 23 */       Response response = mzm.gsp.csprovider.gmt.idip.IdipGmtUtil.getResponse(retcode, "max_online <= 0");
/* 24 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */       
/* 26 */       GameServer.logger().error(String.format("[gmt]MaxOnlineHandler.execute@max_online <= 0|max_online=%d", new Object[] { Integer.valueOf(number) }));
/* 27 */       return;
/*    */     }
/*    */     
/* 30 */     boolean result = new PGM_SetMaxPalyerNum(number).call();
/* 31 */     String retMsg = null;
/* 32 */     if (result)
/*    */     {
/* 34 */       rsp.retcode = Retcode.SUCCESS.value;
/* 35 */       retMsg = String.format("maxOnline=%d", new Object[] { Integer.valueOf(number) });
/*    */     }
/*    */     else
/*    */     {
/* 39 */       rsp.retcode = Retcode.SET_MAX_ONLINE_NUM_FAILED.value;
/* 40 */       retMsg = "set max player num error";
/*    */     }
/* 42 */     Response response = new Response();
/* 43 */     response.retcode = rsp.retcode;
/* 44 */     response.msg = retMsg;
/* 45 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */     
/* 47 */     GameServer.logger().info(String.format("[gmt]MaxOnlineHandler.execute@set max_online done|max_online_num=%d|result=%b", new Object[] { Integer.valueOf(number), Boolean.valueOf(result) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\generalcmd\MaxOnlineHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
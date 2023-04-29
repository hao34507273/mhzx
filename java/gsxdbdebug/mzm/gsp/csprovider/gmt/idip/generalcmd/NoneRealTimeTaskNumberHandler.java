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
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class NoneRealTimeTaskNumberHandler implements IdipHandler
/*    */ {
/*    */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp) throws Exception
/*    */   {
/* 18 */     int number = NoneRealTimeTaskManager.getInstance().taskSize();
/* 19 */     rsp.retcode = Retcode.SUCCESS.value;
/* 20 */     String retMsg = String.format("noneRealTimeTaskNumber=%d", new Object[] { Integer.valueOf(number) });
/* 21 */     Response response = new Response();
/* 22 */     response.msg = retMsg;
/* 23 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */     
/* 25 */     GameServer.logger().info(String.format("[gmt]NoneRealTimeTaskNumberHandler.execute@get none_real_time_task_number done|none_real_time_task_number=%d", new Object[] { Integer.valueOf(number) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\generalcmd\NoneRealTimeTaskNumberHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
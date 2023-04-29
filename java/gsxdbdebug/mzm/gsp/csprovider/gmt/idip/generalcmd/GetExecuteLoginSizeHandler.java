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
/*    */ import mzm.gsp.online.main.LoginAssistManager;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class GetExecuteLoginSizeHandler
/*    */   implements IdipHandler
/*    */ {
/*    */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp) throws Exception
/*    */   {
/* 19 */     int size = LoginAssistManager.getInstance().getExcuteLoginSize();
/*    */     
/* 21 */     rsp.retcode = Retcode.SUCCESS.value;
/* 22 */     String retMsg = String.format("executeLoginSize=%d", new Object[] { Integer.valueOf(size) });
/* 23 */     Response response = new Response();
/* 24 */     response.msg = retMsg;
/* 25 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */     
/* 27 */     GameServer.logger().info(String.format("[gmt]GetExecuteLoginSizeHandler.execute@get execute login size success|ret=%d|ret_msg=%s|execute_login_size=%d", new Object[] { Integer.valueOf(rsp.retcode), retMsg, Integer.valueOf(size) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\generalcmd\GetExecuteLoginSizeHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
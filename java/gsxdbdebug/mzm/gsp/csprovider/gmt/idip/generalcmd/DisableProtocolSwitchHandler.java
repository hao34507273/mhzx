/*    */ package mzm.gsp.csprovider.gmt.idip.generalcmd;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import csprovider.DataBetweenCspAndGame_Re;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.csprovider.gmt.GmtCmdManager;
/*    */ import mzm.gsp.csprovider.gmt.idip.IdipHandler;
/*    */ import mzm.gsp.csprovider.gmt.idip.Response;
/*    */ import mzm.gsp.csprovider.main.Retcode;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class DisableProtocolSwitchHandler
/*    */   implements IdipHandler
/*    */ {
/*    */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp) throws Exception
/*    */   {
/* 19 */     boolean result = false;
/* 20 */     Integer switchInteger = Integer.valueOf((String)params.get(0));
/* 21 */     boolean switchValue = switchInteger.intValue() == 1;
/*    */     
/* 23 */     Integer protocolId = Integer.valueOf((String)params.get(1));
/* 24 */     if (switchValue)
/*    */     {
/* 26 */       result = GameServerInfoManager.addDisableProtocol(protocolId.intValue());
/*    */     }
/*    */     else
/*    */     {
/* 30 */       result = GameServerInfoManager.removeDisableProtocol(protocolId.intValue());
/*    */     }
/*    */     
/* 33 */     String retMsg = null;
/* 34 */     if (result)
/*    */     {
/* 36 */       rsp.retcode = Retcode.SUCCESS.value;
/* 37 */       retMsg = String.format("%s %d protocol", new Object[] { switchValue ? "disable" : "enable", protocolId });
/*    */     }
/*    */     else
/*    */     {
/* 41 */       rsp.retcode = Retcode.BAN_OR_FREE_PROTOCOL_FAIL.value;
/* 42 */       retMsg = String.format("%s %d protocol fail", new Object[] { switchValue ? "disable" : "enable", protocolId });
/*    */     }
/*    */     
/* 45 */     Response response = new Response();
/* 46 */     response.msg = retMsg;
/* 47 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */     
/* 49 */     GameServer.logger().info(String.format("[gmt]DisableProtocolSwitchHandler.execute@disable protocol switch done|ret=%d|ret_msg=%s|result=%b", new Object[] { Integer.valueOf(rsp.retcode), retMsg, Boolean.valueOf(result) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\generalcmd\DisableProtocolSwitchHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
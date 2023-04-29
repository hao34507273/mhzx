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
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class CloseGmHandler implements IdipHandler
/*    */ {
/*    */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp) throws Exception
/*    */   {
/* 19 */     if (!GmManager.getInstance().closeDebugEnvForIDIP())
/*    */     {
/* 21 */       int retcode = Retcode.CLOSE_GM_FAILED.value;
/* 22 */       rsp.retcode = retcode;
/* 23 */       Response response = IdipGmtUtil.getResponse(retcode, "close gm failed");
/* 24 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */       
/* 26 */       GameServer.logger().error("[gmt]CloseGmHandler.execute@close gm failed");
/* 27 */       return;
/*    */     }
/*    */     
/* 30 */     rsp.retcode = Retcode.SUCCESS.value;
/* 31 */     Response response = new Response();
/* 32 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */     
/* 34 */     GameServer.logger().info("[gmt]CloseGmHandler.execute@close gm done");
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\generalcmd\CloseGmHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
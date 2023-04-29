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
/*    */ import mzm.gsp.online.main.PGM_ClearExtuteLoginQueue;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class ClearExecuteLoginQueueHandler implements IdipHandler
/*    */ {
/*    */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp) throws Exception
/*    */   {
/* 18 */     new PGM_ClearExtuteLoginQueue().execute();
/*    */     
/* 20 */     rsp.retcode = Retcode.SUCCESS.value;
/* 21 */     Response response = new Response();
/* 22 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */     
/* 24 */     GameServer.logger().info("[gmt]ClearExecuteLoginQueueHandler.execute@clear execute login queue done");
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\generalcmd\ClearExecuteLoginQueueHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
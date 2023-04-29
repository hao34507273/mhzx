/*    */ package mzm.gsp.csprovider.gmt.idip.generalcmd;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import csprovider.DataBetweenCspAndGame_Re;
/*    */ import gnet.link.Onlines;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.csprovider.gmt.GmtCmdManager;
/*    */ import mzm.gsp.csprovider.gmt.idip.IdipHandler;
/*    */ import mzm.gsp.csprovider.gmt.idip.Response;
/*    */ import mzm.gsp.csprovider.main.Retcode;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class OutputDirectAllocationHandler
/*    */   implements IdipHandler
/*    */ {
/*    */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp) throws Exception
/*    */   {
/* 19 */     long value = Onlines.getInstance().getOutputAllocation();
/*    */     
/* 21 */     rsp.retcode = Retcode.SUCCESS.value;
/* 22 */     String retMsg = String.format("outputAllocation=%d", new Object[] { Long.valueOf(value) });
/* 23 */     Response response = new Response();
/* 24 */     response.msg = retMsg;
/* 25 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */     
/* 27 */     GameServer.logger().info(String.format("[gmt]OutputDirectAllocationHandler.execute@get output_allocation done|output_allocation=%d", new Object[] { Long.valueOf(value) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\generalcmd\OutputDirectAllocationHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
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
/*    */ import org.apache.log4j.Logger;
/*    */ import xdb.Trace;
/*    */ 
/*    */ public class SetXdbTraceLevelHandler implements IdipHandler
/*    */ {
/*    */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp) throws Exception
/*    */   {
/* 19 */     int xdbTraceLevel = Integer.parseInt((String)params.get(0));
/*    */     
/* 21 */     Trace trace = null;
/* 22 */     switch (xdbTraceLevel)
/*    */     {
/*    */     case 0: 
/* 25 */       trace = Trace.DEBUG;
/* 26 */       break;
/*    */     
/*    */     case 1: 
/* 29 */       trace = Trace.INFO;
/* 30 */       break;
/*    */     
/*    */     case 2: 
/* 33 */       trace = Trace.WARN;
/* 34 */       break;
/*    */     
/*    */     case 3: 
/* 37 */       trace = Trace.ERROR;
/* 38 */       break;
/*    */     
/*    */     case 4: 
/* 41 */       trace = Trace.FATAL;
/* 42 */       break;
/*    */     
/*    */     default: 
/* 45 */       int retcode = Retcode.XDB_TRACE_LEVEL_INVALID.value;
/* 46 */       rsp.retcode = retcode;
/* 47 */       Response response = IdipGmtUtil.getResponse(retcode, "xdb trace level invalid");
/* 48 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */       
/* 50 */       GameServer.logger().error(String.format("[gmt]SetXdbTraceLevelHandler.execute@xdb_trace_level invalid|xdb_trace_level=%d", new Object[] { Integer.valueOf(xdbTraceLevel) }));
/*    */       
/*    */ 
/* 53 */       return;
/*    */     }
/*    */     
/* 56 */     Trace.set(trace);
/* 57 */     rsp.retcode = Retcode.SUCCESS.value;
/* 58 */     Response response = new Response();
/* 59 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */     
/* 61 */     GameServer.logger().info(String.format("[gmt]SetXdbTraceLevelHandler.execute@set xdb trace level done|xdb_trace_level=%d", new Object[] { Integer.valueOf(xdbTraceLevel) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\generalcmd\SetXdbTraceLevelHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
/*    */ package mzm.gsp.csprovider.gmt.idip.generalcmd;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import csprovider.DataBetweenCspAndGame_Re;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.csprovider.gmt.GmtCmdManager;
/*    */ import mzm.gsp.csprovider.gmt.idip.Response;
/*    */ import mzm.gsp.csprovider.main.Retcode;
/*    */ import org.apache.log4j.Logger;
/*    */ import xdb.Xdb;
/*    */ 
/*    */ public class SetAllowDumpSqlLoggerStatisDetailHandler implements mzm.gsp.csprovider.gmt.idip.IdipHandler
/*    */ {
/*    */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp) throws Exception
/*    */   {
/* 17 */     boolean isAllow = Integer.valueOf((String)params.get(0)).intValue() == 1;
/*    */     
/* 19 */     Xdb.getInstance().getConf().setAllowDumpSqlLoggerStatisDetail(isAllow);
/*    */     
/* 21 */     rsp.retcode = Retcode.SUCCESS.value;
/* 22 */     String retMsg = String.format("AllowDumpSqlLoggerStatisDetail = %b", new Object[] { Boolean.valueOf(isAllow) });
/* 23 */     Response response = new Response();
/* 24 */     response.msg = retMsg;
/* 25 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */     
/* 27 */     GameServer.logger().info(String.format("[idip]SetAllowDumpSqlLoggerStatisDetailHandler.execute@set allow dump sqlLogger statis detail done|isAllow=%b", new Object[] { Boolean.valueOf(isAllow) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\generalcmd\SetAllowDumpSqlLoggerStatisDetailHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
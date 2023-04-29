/*    */ package mzm.gsp.csprovider.gmt.idip.generalcmd;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import csprovider.DataBetweenCspAndGame_Re;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.crossbattle.own.CrossBattleOwnInterface;
/*    */ import mzm.gsp.crossbattle.own.QueryResult;
/*    */ import mzm.gsp.csprovider.gmt.GmtCmdManager;
/*    */ import mzm.gsp.csprovider.gmt.idip.IdipGmtUtil;
/*    */ import mzm.gsp.csprovider.gmt.idip.IdipHandler;
/*    */ import mzm.gsp.csprovider.gmt.idip.Response;
/*    */ import mzm.gsp.csprovider.main.Retcode;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class CrossBattleOwnQueryReportResultHandler implements IdipHandler
/*    */ {
/*    */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp) throws Exception
/*    */   {
/* 20 */     int activityCfgid = Integer.parseInt((String)params.get(0));
/*    */     
/* 22 */     QueryResult queryResult = CrossBattleOwnInterface.queryReportCrossBattleOwnResultInfoByIdip(activityCfgid);
/* 23 */     rsp.retcode = Retcode.SUCCESS.value;
/* 24 */     Response response = IdipGmtUtil.getResponse(Retcode.SUCCESS.value, queryResult.desc);
/* 25 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */     
/* 27 */     GameServer.logger().info(String.format("[gmt]CrossBattleOwnQueryReportResultHandler.execute@query done|activity_cfgid=%d|retcode=%d", new Object[] { Integer.valueOf(activityCfgid), Integer.valueOf(queryResult.code) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\generalcmd\CrossBattleOwnQueryReportResultHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
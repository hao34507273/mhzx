/*    */ package mzm.gsp.csprovider.gmt.idip.generalcmd;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import csprovider.DataBetweenCspAndGame_Re;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.crossbattle.point.PReportCorpsFightValue;
/*    */ import mzm.gsp.csprovider.gmt.GmtCmdManager;
/*    */ import mzm.gsp.csprovider.gmt.idip.IdipGmtUtil;
/*    */ import mzm.gsp.csprovider.gmt.idip.IdipHandler;
/*    */ import mzm.gsp.csprovider.gmt.idip.Response;
/*    */ import mzm.gsp.csprovider.main.Retcode;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class CrossBattlePointRaceReportFightHandler implements IdipHandler
/*    */ {
/*    */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp) throws Exception
/*    */   {
/* 19 */     int activityCfgid = Integer.parseInt((String)params.get(0));
/* 20 */     boolean ret = new PReportCorpsFightValue(activityCfgid, true).call();
/* 21 */     if (!ret)
/*    */     {
/* 23 */       rsp.retcode = Retcode.SUCCESS.value;
/* 24 */       Response response = IdipGmtUtil.getResponse(Retcode.SUCCESS.value, "report failed");
/* 25 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */       
/* 27 */       GameServer.logger().error(String.format("[gmt]CrossBattlePointRaceReportFightHandler.execute@failed|activity_cfgid=%d", new Object[] { Integer.valueOf(activityCfgid) }));
/*    */       
/* 29 */       return;
/*    */     }
/*    */     
/* 32 */     rsp.retcode = Retcode.SUCCESS.value;
/* 33 */     Response response = new Response();
/* 34 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */     
/* 36 */     GameServer.logger().info(String.format("[gmt]CrossBattlePointRaceReportFightHandler.execute@handle done|activity_cfgid=%d", new Object[] { Integer.valueOf(activityCfgid) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\generalcmd\CrossBattlePointRaceReportFightHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
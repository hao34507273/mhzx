/*    */ package mzm.gsp.csprovider.gmt.idip.generalcmd;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import csprovider.DataBetweenCspAndGame_Re;
/*    */ import java.util.List;
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.crossbattle.own.CrossBattleOwnInterface;
/*    */ import mzm.gsp.crossbattle.own.RestartResult;
/*    */ import mzm.gsp.csprovider.gmt.GmtCmdManager;
/*    */ import mzm.gsp.csprovider.gmt.idip.IdipGmtUtil;
/*    */ import mzm.gsp.csprovider.gmt.idip.IdipHandler;
/*    */ import mzm.gsp.csprovider.gmt.idip.Response;
/*    */ import mzm.gsp.csprovider.main.Retcode;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class CrossBattleOwnRestartRoundRobinHandler implements IdipHandler
/*    */ {
/*    */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp) throws Exception
/*    */   {
/* 21 */     int activityCfgid = Integer.parseInt((String)params.get(0));
/* 22 */     int roundIndex = Integer.parseInt((String)params.get(1));
/* 23 */     int restartLevel = Integer.parseInt((String)params.get(2));
/* 24 */     long timestamp = TimeUnit.SECONDS.toMillis(Integer.parseInt((String)params.get(3)));
/*    */     
/* 26 */     RestartResult restartResult = CrossBattleOwnInterface.restartRoundRobinRoundByIdip(activityCfgid, roundIndex, restartLevel, timestamp);
/*    */     
/* 28 */     if (restartResult != RestartResult.Success)
/*    */     {
/* 30 */       rsp.retcode = Retcode.SUCCESS.value;
/* 31 */       Response response = IdipGmtUtil.getResponse(Retcode.SUCCESS.value, restartResult.desc);
/* 32 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */       
/* 34 */       GameServer.logger().error(String.format("[gmt]CrossBattleOwnRestartRoundRobinHandler.execute@failed|activity_cfgid=%d|round_index=%d|restart_level=%d|timestamp=%d|retcode=%d", new Object[] { Integer.valueOf(activityCfgid), Integer.valueOf(roundIndex), Integer.valueOf(restartLevel), Long.valueOf(timestamp), Integer.valueOf(restartResult.code) }));
/*    */       
/*    */ 
/*    */ 
/* 38 */       return;
/*    */     }
/*    */     
/* 41 */     rsp.retcode = Retcode.SUCCESS.value;
/* 42 */     Response response = new Response();
/* 43 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */     
/* 45 */     GameServer.logger().info(String.format("[gmt]CrossBattleOwnRestartRoundRobinHandler.execute@done|activity_cfgid=%d|round_index=%d|restart_level=%d|timestamp=%d", new Object[] { Integer.valueOf(activityCfgid), Integer.valueOf(roundIndex), Integer.valueOf(restartLevel), Long.valueOf(timestamp) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\generalcmd\CrossBattleOwnRestartRoundRobinHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
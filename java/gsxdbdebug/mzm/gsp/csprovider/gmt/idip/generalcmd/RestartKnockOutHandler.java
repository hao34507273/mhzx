/*    */ package mzm.gsp.csprovider.gmt.idip.generalcmd;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import csprovider.DataBetweenCspAndGame_Re;
/*    */ import java.util.List;
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.crossbattle.knockout.CrossBattleKnockoutInterface;
/*    */ import mzm.gsp.csprovider.gmt.GmtCmdManager;
/*    */ import mzm.gsp.csprovider.gmt.idip.IdipGmtUtil;
/*    */ import mzm.gsp.csprovider.gmt.idip.IdipHandler;
/*    */ import mzm.gsp.csprovider.gmt.idip.Response;
/*    */ import mzm.gsp.csprovider.main.Retcode;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class RestartKnockOutHandler implements IdipHandler
/*    */ {
/*    */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp) throws Exception
/*    */   {
/* 20 */     int activityCfgid = Integer.parseInt((String)params.get(0));
/* 21 */     int knockOutType = Integer.parseInt((String)params.get(1));
/* 22 */     int restartFightZoneId = Integer.parseInt((String)params.get(2));
/* 23 */     int restartFightIndexId = Integer.parseInt((String)params.get(3));
/*    */     
/* 25 */     long time = TimeUnit.SECONDS.toMillis(Integer.parseInt((String)params.get(4)));
/* 26 */     int result = CrossBattleKnockoutInterface.restartKnockOut(activityCfgid, knockOutType, restartFightZoneId, restartFightIndexId, time);
/*    */     
/* 28 */     if (result < 0)
/*    */     {
/* 30 */       rsp.retcode = Retcode.SUCCESS.value;
/* 31 */       Response response = IdipGmtUtil.getResponse(Retcode.SUCCESS.value, String.format("restart knockout failed result=%d", new Object[] { Integer.valueOf(result) }));
/* 32 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */       
/* 34 */       GameServer.logger().error(String.format("[gmt]RestartKnockOutHandler.execute@handle failed|activity_cfgid=%d|type=%d|fight_zoneid=%d|fight_indexid=%d|begin_timestamp=%d|retcode=%d", new Object[] { Integer.valueOf(activityCfgid), Integer.valueOf(knockOutType), Integer.valueOf(restartFightZoneId), Integer.valueOf(restartFightIndexId), Long.valueOf(time), Integer.valueOf(result) }));
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
/* 45 */     GameServer.logger().info(String.format("[gmt]RestartKnockOutHandler.executeCmd@handle success|activity_cfgid=%d|type=%d|fight_zoneid=%d|fight_indexid=%d|begin_timestamp=%d|retcode=%d", new Object[] { Integer.valueOf(activityCfgid), Integer.valueOf(knockOutType), Integer.valueOf(restartFightZoneId), Integer.valueOf(restartFightIndexId), Long.valueOf(time), Integer.valueOf(result) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\generalcmd\RestartKnockOutHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
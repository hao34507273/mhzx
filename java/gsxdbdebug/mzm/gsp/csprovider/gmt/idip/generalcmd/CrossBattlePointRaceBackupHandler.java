/*    */ package mzm.gsp.csprovider.gmt.idip.generalcmd;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import csprovider.DataBetweenCspAndGame_Re;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.crossbattle.point.BackupResult;
/*    */ import mzm.gsp.crossbattle.point.CrossBattlePointInterface;
/*    */ import mzm.gsp.csprovider.gmt.GmtCmdManager;
/*    */ import mzm.gsp.csprovider.gmt.idip.IdipGmtUtil;
/*    */ import mzm.gsp.csprovider.gmt.idip.IdipHandler;
/*    */ import mzm.gsp.csprovider.gmt.idip.Response;
/*    */ import mzm.gsp.csprovider.main.Retcode;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class CrossBattlePointRaceBackupHandler implements IdipHandler
/*    */ {
/*    */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp) throws Exception
/*    */   {
/* 20 */     int activityCfgid = Integer.parseInt((String)params.get(0));
/* 21 */     int zone = Integer.parseInt((String)params.get(1));
/* 22 */     int index = Integer.parseInt((String)params.get(2));
/*    */     
/* 24 */     BackupResult backupResult = CrossBattlePointInterface.pointRaceBackup(activityCfgid, zone, index);
/* 25 */     if (backupResult != BackupResult.Success)
/*    */     {
/* 27 */       rsp.retcode = Retcode.SUCCESS.value;
/* 28 */       Response response = IdipGmtUtil.getResponse(Retcode.SUCCESS.value, backupResult.desc);
/* 29 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */       
/* 31 */       GameServer.logger().error(String.format("[gmt]CrossBattlePointRaceBackupHandler.execute@failed|activity_cfgid=%d|zone=%d|index=%d|retcode=%d", new Object[] { Integer.valueOf(activityCfgid), Integer.valueOf(zone), Integer.valueOf(index), Integer.valueOf(backupResult.code) }));
/*    */       
/*    */ 
/*    */ 
/* 35 */       return;
/*    */     }
/*    */     
/* 38 */     rsp.retcode = Retcode.SUCCESS.value;
/* 39 */     Response response = new Response();
/* 40 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */     
/* 42 */     GameServer.logger().info(String.format("[gmt]CrossBattlePointRaceBackupHandler.execute@done|activity_cfgid=%d|zone=%d|index=%d", new Object[] { Integer.valueOf(activityCfgid), Integer.valueOf(zone), Integer.valueOf(index) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\generalcmd\CrossBattlePointRaceBackupHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
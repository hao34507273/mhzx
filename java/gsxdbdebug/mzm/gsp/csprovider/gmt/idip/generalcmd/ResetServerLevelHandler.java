/*    */ package mzm.gsp.csprovider.gmt.idip.generalcmd;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import csprovider.DataBetweenCspAndGame_Re;
/*    */ import java.util.List;
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.csprovider.gmt.GmtCmdManager;
/*    */ import mzm.gsp.csprovider.gmt.idip.IdipGmtUtil;
/*    */ import mzm.gsp.csprovider.gmt.idip.IdipHandler;
/*    */ import mzm.gsp.csprovider.gmt.idip.Response;
/*    */ import mzm.gsp.csprovider.main.Retcode;
/*    */ import mzm.gsp.server.main.PGM_ResetServeLevel;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class ResetServerLevelHandler implements IdipHandler
/*    */ {
/*    */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp) throws Exception
/*    */   {
/* 21 */     int newlevel = Integer.parseInt((String)params.get(0));
/* 22 */     long endTimeSec = Long.parseLong((String)params.get(1));
/* 23 */     if (newlevel <= 0)
/*    */     {
/* 25 */       int retcode = Retcode.SEVER_LEVEL_INVALID.value;
/* 26 */       rsp.retcode = retcode;
/* 27 */       Response response = IdipGmtUtil.getResponse(retcode, "new level <= 0");
/* 28 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */       
/* 30 */       GameServer.logger().error(String.format("[gmt]ResetServerLevelHandler.execute@newLevel <= 0|new_level=%d|end_time=%d", new Object[] { Integer.valueOf(newlevel), Long.valueOf(endTimeSec) }));
/*    */       
/*    */ 
/* 33 */       return;
/*    */     }
/*    */     
/* 36 */     long now = TimeUnit.MILLISECONDS.toSeconds(DateTimeUtils.getCurrTimeInMillis());
/* 37 */     if (endTimeSec <= now)
/*    */     {
/* 39 */       int retcode = Retcode.END_TIME_INVALID.value;
/* 40 */       rsp.retcode = retcode;
/* 41 */       Response response = IdipGmtUtil.getResponse(retcode, "end time <= now");
/* 42 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */       
/* 44 */       GameServer.logger().error(String.format("[gmt]ResetServerLevelHandler.execute@end_time <= now|new_level=%d|end_time=%d|now=%d", new Object[] { Integer.valueOf(newlevel), Long.valueOf(endTimeSec), Long.valueOf(now) }));
/*    */       
/*    */ 
/* 47 */       return;
/*    */     }
/*    */     
/*    */ 
/* 51 */     new PGM_ResetServeLevel(newlevel, endTimeSec).execute();
/*    */     
/* 53 */     rsp.retcode = Retcode.SUCCESS.value;
/* 54 */     Response response = new Response();
/* 55 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */     
/* 57 */     GameServer.logger().info(String.format("[gmt]ResetServerLevelHandler.execute@reset server level done|new_level=%d|end_time=%d", new Object[] { Integer.valueOf(newlevel), Long.valueOf(endTimeSec) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\generalcmd\ResetServerLevelHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
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
/*    */ import mzm.gsp.server.main.Pgm_SetLevel;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class SetServerLevelHandler implements IdipHandler
/*    */ {
/*    */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp) throws Exception
/*    */   {
/* 19 */     int newlevel = Integer.valueOf((String)params.get(0)).intValue();
/* 20 */     if (newlevel <= 0)
/*    */     {
/* 22 */       int retcode = Retcode.NEW_SERVER_LEVEL_LESS_THAN_ZERO.value;
/* 23 */       rsp.retcode = retcode;
/* 24 */       Response response = IdipGmtUtil.getResponse(retcode, "level <= 0");
/* 25 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */       
/* 27 */       GameServer.logger().error(String.format("[gmt]SetServerLevelHandler.execute@new_level <= 0|new_level=%d", new Object[] { Integer.valueOf(newlevel) }));
/* 28 */       return;
/*    */     }
/*    */     
/*    */ 
/* 32 */     new Pgm_SetLevel(newlevel, null).execute();
/*    */     
/* 34 */     rsp.retcode = Retcode.SUCCESS.value;
/* 35 */     String retMsg = String.format("newLevel=%d", new Object[] { Integer.valueOf(newlevel) });
/* 36 */     Response response = new Response();
/* 37 */     response.msg = retMsg;
/* 38 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */     
/* 40 */     GameServer.logger().info(String.format("[gmt]SetServerLevelHandler.execute@set level done|new_level=%d", new Object[] { Integer.valueOf(newlevel) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\generalcmd\SetServerLevelHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
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
/*    */ import mzm.gsp.gang.main.PGM_kickoutgang;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class GangKickOutHandler implements IdipHandler
/*    */ {
/*    */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp) throws Exception
/*    */   {
/* 19 */     long gangid = Long.parseLong((String)params.get(0));
/* 20 */     long roleid = IdipGmtUtil.getRoleid((String)params.get(1));
/*    */     
/* 22 */     if (!new PGM_kickoutgang(-1L, gangid, roleid).call())
/*    */     {
/* 24 */       int retcode = Retcode.KICK_OUT_GANG_FAILED.value;
/* 25 */       rsp.retcode = retcode;
/* 26 */       Response response = IdipGmtUtil.getResponse(retcode, "kick out gang failed");
/* 27 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */       
/* 29 */       GameServer.logger().error(String.format("[gmt]GangKickOutHandler.execute@kick out gang failed|gangid=%d|roleid=%d", new Object[] { Long.valueOf(gangid), Long.valueOf(roleid) }));
/*    */       
/* 31 */       return;
/*    */     }
/*    */     
/* 34 */     rsp.retcode = Retcode.SUCCESS.value;
/* 35 */     Response response = new Response();
/* 36 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */     
/* 38 */     GameServer.logger().info(String.format("[gmt]GangKickOutHandler.execute@kick out gang done|gangid=%d|roleid=%d", new Object[] { Long.valueOf(gangid), Long.valueOf(roleid) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\generalcmd\GangKickOutHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
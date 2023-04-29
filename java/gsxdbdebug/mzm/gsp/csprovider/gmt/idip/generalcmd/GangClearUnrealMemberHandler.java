/*    */ package mzm.gsp.csprovider.gmt.idip.generalcmd;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import csprovider.DataBetweenCspAndGame_Re;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.csprovider.gmt.GmtCmdManager;
/*    */ import mzm.gsp.csprovider.gmt.idip.IdipHandler;
/*    */ import mzm.gsp.csprovider.gmt.idip.Response;
/*    */ import mzm.gsp.csprovider.main.Retcode;
/*    */ import org.apache.log4j.Logger;
/*    */ import xdb.Executor;
/*    */ 
/*    */ public class GangClearUnrealMemberHandler implements IdipHandler
/*    */ {
/*    */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp) throws Exception
/*    */   {
/* 18 */     long gangid = Long.parseLong((String)params.get(0));
/* 19 */     Executor.getInstance().execute(new mzm.gsp.gang.main.RGM_clearunrealgangmember(-1L, gangid));
/*    */     
/* 21 */     rsp.retcode = Retcode.SUCCESS.value;
/* 22 */     Response response = new Response();
/* 23 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */     
/* 25 */     GameServer.logger().info(String.format("[gmt]GangClearUnrealMemberHandler.execute@clear gang unreal member done|gangid=%d", new Object[] { Long.valueOf(gangid) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\generalcmd\GangClearUnrealMemberHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
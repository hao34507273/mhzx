/*    */ package mzm.gsp.csprovider.gmt.idip.generalcmd;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import csprovider.DataBetweenCspAndGame_Re;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.csprovider.gmt.GmtCmdManager;
/*    */ import mzm.gsp.csprovider.gmt.idip.Response;
/*    */ import mzm.gsp.csprovider.main.Retcode;
/*    */ import mzm.gsp.gang.main.RGM_dealmorebangzhu;
/*    */ import org.apache.log4j.Logger;
/*    */ import xdb.Executor;
/*    */ 
/*    */ public class GangDealMoreBangZhuHandler implements mzm.gsp.csprovider.gmt.idip.IdipHandler
/*    */ {
/*    */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp) throws Exception
/*    */   {
/* 18 */     long gangid = Long.parseLong((String)params.get(0));
/* 19 */     Executor.getInstance().execute(new RGM_dealmorebangzhu(-1L, gangid));
/*    */     
/* 21 */     rsp.retcode = Retcode.SUCCESS.value;
/* 22 */     Response response = new Response();
/* 23 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */     
/* 25 */     GameServer.logger().info(String.format("[gmt]GangDealMoreBangZhuHandler.execute@deal gang more bangzhu done|gangid=%d", new Object[] { Long.valueOf(gangid) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\generalcmd\GangDealMoreBangZhuHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
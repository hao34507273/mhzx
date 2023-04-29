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
/*    */ import mzm.gsp.xiaohuikuaipao.main.XiaoHuiKuaiPaoInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class SetXHKPGlobalHandler implements IdipHandler
/*    */ {
/*    */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp) throws Exception
/*    */   {
/* 19 */     int activityCfgid = Integer.parseInt((String)params.get(0));
/* 20 */     int isAutoDraw = Integer.parseInt((String)params.get(1));
/*    */     
/* 22 */     if (!XiaoHuiKuaiPaoInterface.setXHKPGlobal(activityCfgid, isAutoDraw))
/*    */     {
/* 24 */       rsp.retcode = Retcode.SUCCESS.value;
/* 25 */       Response response = IdipGmtUtil.getResponse(Retcode.SUCCESS.value, "system error");
/* 26 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */       
/* 28 */       GameServer.logger().error(String.format("[gmt]SetXHKPGlobalHandler.execute@failed|activity_cfgid=%d|is_auto_draw=%d", new Object[] { Integer.valueOf(activityCfgid), Integer.valueOf(isAutoDraw) }));
/*    */       
/*    */ 
/* 31 */       return;
/*    */     }
/*    */     
/* 34 */     rsp.retcode = Retcode.SUCCESS.value;
/* 35 */     Response response = IdipGmtUtil.getResponse(Retcode.SUCCESS.value, String.format("is auto draw %b", new Object[] { Boolean.valueOf(isAutoDraw == 1 ? 1 : false) }));
/*    */     
/* 37 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */     
/* 39 */     GameServer.logger().info(String.format("[gmt]SetXHKPGlobalHandler.execute@success|activity_cfgid=%d|is_auto_draw=%d", new Object[] { Integer.valueOf(activityCfgid), Integer.valueOf(isAutoDraw) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\generalcmd\SetXHKPGlobalHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
/*    */ package mzm.gsp.csprovider.gmt.idip.generalcmd;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import csprovider.DataBetweenCspAndGame_Re;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.activitypointexchange.main.ActivityPointExchangeInterface;
/*    */ import mzm.gsp.csprovider.gmt.GmtCmdManager;
/*    */ import mzm.gsp.csprovider.gmt.idip.IdipGmtUtil;
/*    */ import mzm.gsp.csprovider.gmt.idip.IdipHandler;
/*    */ import mzm.gsp.csprovider.gmt.idip.Response;
/*    */ import mzm.gsp.csprovider.main.Retcode;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class PointExchangeSwitchHandler implements IdipHandler
/*    */ {
/*    */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp) throws Exception
/*    */   {
/* 19 */     int activityCfgid = Integer.parseInt((String)params.get(0));
/* 20 */     int mallCfgId = Integer.parseInt((String)params.get(1));
/* 21 */     int goodsCfgId = Integer.parseInt((String)params.get(2));
/* 22 */     boolean hide = Integer.parseInt((String)params.get(3)) == 0L;
/*    */     
/* 24 */     boolean result = false;
/* 25 */     if (hide)
/*    */     {
/* 27 */       result = ActivityPointExchangeInterface.xiaJia(activityCfgid, mallCfgId, goodsCfgId);
/*    */     }
/*    */     else
/*    */     {
/* 31 */       result = ActivityPointExchangeInterface.shangJia(activityCfgid, mallCfgId, goodsCfgId);
/*    */     }
/* 33 */     if (!result)
/*    */     {
/* 35 */       int retcode = Retcode.SUCCESS.value;
/* 36 */       rsp.retcode = retcode;
/* 37 */       Response response = IdipGmtUtil.getResponse(retcode, "operate fialed");
/* 38 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */       
/* 40 */       GameServer.logger().error(String.format("[gmt]PointExchangeSwitchHandler.execute@failed|activity_cfgid=%d|mall_cfgid=%d|goods_cfgid=%d|hide=%b", new Object[] { Integer.valueOf(activityCfgid), Integer.valueOf(mallCfgId), Integer.valueOf(goodsCfgId), Boolean.valueOf(hide) }));
/*    */       
/*    */ 
/*    */ 
/* 44 */       return;
/*    */     }
/*    */     
/*    */ 
/* 48 */     rsp.retcode = Retcode.SUCCESS.value;
/* 49 */     Response response = new Response();
/* 50 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */     
/* 52 */     GameServer.logger().info(String.format("[gmt]PointExchangeSwitchHandler.execute@success|activity_cfgid=%d|mall_cfgid=%d|goods_cfgid=%d|hide=%b", new Object[] { Integer.valueOf(activityCfgid), Integer.valueOf(mallCfgId), Integer.valueOf(goodsCfgId), Boolean.valueOf(hide) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\generalcmd\PointExchangeSwitchHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
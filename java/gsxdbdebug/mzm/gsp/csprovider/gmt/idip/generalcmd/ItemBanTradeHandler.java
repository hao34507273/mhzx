/*    */ package mzm.gsp.csprovider.gmt.idip.generalcmd;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import csprovider.DataBetweenCspAndGame_Re;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.csprovider.gmt.GmtCmdManager;
/*    */ import mzm.gsp.csprovider.gmt.idip.IdipGmtUtil;
/*    */ import mzm.gsp.csprovider.gmt.idip.IdipHandler;
/*    */ import mzm.gsp.csprovider.gmt.idip.Response;
/*    */ import mzm.gsp.csprovider.main.Retcode;
/*    */ import mzm.gsp.item.main.ItemBanTrade;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class ItemBanTradeHandler implements IdipHandler
/*    */ {
/*    */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp) throws Exception
/*    */   {
/* 20 */     int tradeType = Integer.parseInt((String)params.get(0));
/* 21 */     int cfgid = Integer.parseInt((String)params.get(1));
/*    */     
/* 23 */     Set<Integer> tradeTypes = mzm.gsp.item.main.ItemBanTrade.TradeTypeEnum.getTradeTypeSet();
/* 24 */     if (!tradeTypes.contains(Integer.valueOf(tradeType)))
/*    */     {
/* 26 */       int retcode = Retcode.TRADE_TYPE_INVALID.value;
/* 27 */       rsp.retcode = retcode;
/* 28 */       Response response = IdipGmtUtil.getResponse(retcode, "trade type not exist");
/* 29 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */       
/* 31 */       GameServer.logger().error(String.format("[gmt]ItemBanTradeHandler.execute@trade type not exist|trade_type=%d", new Object[] { Integer.valueOf(tradeType) }));
/*    */       
/* 33 */       return;
/*    */     }
/*    */     
/* 36 */     if (!ItemBanTrade.getInstance().banTrade(tradeType, cfgid))
/*    */     {
/* 38 */       int retcode = Retcode.BAN_TRADE_TYPE_FAILED.value;
/* 39 */       rsp.retcode = retcode;
/* 40 */       Response response = IdipGmtUtil.getResponse(retcode, "ban trade type failed");
/* 41 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */       
/* 43 */       GameServer.logger().error(String.format("[gmt]ItemBanTradeHandler.execute@ban trade failed|trade_type=%d|cfgid=%d", new Object[] { Integer.valueOf(tradeType), Integer.valueOf(cfgid) }));
/*    */       
/* 45 */       return;
/*    */     }
/*    */     
/* 48 */     rsp.retcode = Retcode.SUCCESS.value;
/* 49 */     Response response = new Response();
/* 50 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */     
/* 52 */     GameServer.logger().info(String.format("[gmt]ItemBanTradeHandler.execute@ban trade done|trade_type=%d|cfgid=%d", new Object[] { Integer.valueOf(tradeType), Integer.valueOf(cfgid) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\generalcmd\ItemBanTradeHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
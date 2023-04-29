/*    */ package mzm.gsp.csprovider.gmt.idip.generalcmd;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import csprovider.DataBetweenCspAndGame_Re;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.award.gift.GiftInterface;
/*    */ import mzm.gsp.award.gift.ResetGiftRes;
/*    */ import mzm.gsp.award.gift.ResetGiftRes.ResetRes;
/*    */ import mzm.gsp.csprovider.gmt.GmtCmdManager;
/*    */ import mzm.gsp.csprovider.gmt.idip.IdipHandler;
/*    */ import mzm.gsp.csprovider.gmt.idip.Response;
/*    */ import mzm.gsp.csprovider.main.Retcode;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class ResetGiftCountHandler implements IdipHandler
/*    */ {
/*    */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp) throws Exception
/*    */   {
/* 20 */     int useType = Integer.parseInt((String)params.get(0));
/* 21 */     ResetGiftRes result = GiftInterface.resetGiftCountForIdip(useType);
/* 22 */     if (!result.isbSucceed())
/*    */     {
/* 24 */       int retcode = Retcode.RESET_GIFT_COUNT_FAILED.value;
/* 25 */       rsp.retcode = retcode;
/* 26 */       Response response = mzm.gsp.csprovider.gmt.idip.IdipGmtUtil.getResponse(retcode, result.getRes().name());
/* 27 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */       
/* 29 */       GameServer.logger().info(String.format("[gmt]ResetGiftCountHandler.execute@reset gift count failed|use_type=%d|result=%s", new Object[] { Integer.valueOf(useType), result.getRes().name() }));
/*    */       
/*    */ 
/* 32 */       return;
/*    */     }
/*    */     
/* 35 */     rsp.retcode = Retcode.SUCCESS.value;
/* 36 */     Response response = new Response();
/* 37 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */     
/* 39 */     GameServer.logger().info(String.format("[gmt]ResetGiftCountHandler.execute@reset gift count done|use_type=%d", new Object[] { Integer.valueOf(useType) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\generalcmd\ResetGiftCountHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
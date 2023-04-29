/*    */ package mzm.gsp.csprovider.gmt.idip.generalcmd;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import csprovider.DataBetweenCspAndGame_Re;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.awardpool.main.AwardPoolInterface;
/*    */ import mzm.gsp.csprovider.gmt.GmtCmdManager;
/*    */ import mzm.gsp.csprovider.gmt.idip.IdipGmtUtil;
/*    */ import mzm.gsp.csprovider.gmt.idip.IdipHandler;
/*    */ import mzm.gsp.csprovider.gmt.idip.Response;
/*    */ import mzm.gsp.csprovider.main.Retcode;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class ClearServerDropHandler implements IdipHandler
/*    */ {
/*    */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp) throws Exception
/*    */   {
/* 19 */     int itemSubid = Integer.parseInt((String)params.get(0));
/* 20 */     int unhitCount = Integer.parseInt((String)params.get(1));
/* 21 */     if (itemSubid != 0)
/*    */     {
/* 23 */       if (!AwardPoolInterface.isPreciousDrop(itemSubid))
/*    */       {
/* 25 */         int retcode = Retcode.ITEM_SUBID_INVALID.value;
/* 26 */         rsp.retcode = retcode;
/* 27 */         Response response = IdipGmtUtil.getResponse(retcode, "item subid error");
/* 28 */         rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */         
/* 30 */         GameServer.logger().error(String.format("[gmt]ClearServerDropHandler.execute@item subid error|item_subid=%d|unhit_count=%d", new Object[] { Integer.valueOf(itemSubid), Integer.valueOf(unhitCount) }));
/*    */         
/*    */ 
/* 33 */         return;
/*    */       }
/*    */     }
/*    */     
/* 37 */     if (unhitCount < 0)
/*    */     {
/* 39 */       int retcode = Retcode.UNHIT_COUNT_INVALID.value;
/* 40 */       rsp.retcode = retcode;
/* 41 */       Response response = IdipGmtUtil.getResponse(retcode, "unhit count < 0");
/* 42 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */       
/* 44 */       GameServer.logger().error(String.format("[gmt]ClearServerDropHandler.execute@unhit count < 0|item_subid=%d|unhit_count=%d", new Object[] { Integer.valueOf(itemSubid), Integer.valueOf(unhitCount) }));
/*    */       
/*    */ 
/* 47 */       return;
/*    */     }
/*    */     
/*    */ 
/* 51 */     AwardPoolInterface.setServerDropUnhitCount(itemSubid, unhitCount);
/*    */     
/* 53 */     rsp.retcode = Retcode.SUCCESS.value;
/* 54 */     Response response = new Response();
/* 55 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */     
/* 57 */     GameServer.logger().info(String.format("[gmt]ClearServerDropHandler.execute@clear server drop done|item_subid=%d|unhit_count=%d", new Object[] { Integer.valueOf(itemSubid), Integer.valueOf(unhitCount) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\generalcmd\ClearServerDropHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
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
/*    */ import mzm.gsp.idip.main.ItemHideManager;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class ItemHideHandler
/*    */   implements IdipHandler
/*    */ {
/*    */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp) throws Exception
/*    */   {
/* 20 */     int itemType = Integer.parseInt((String)params.get(0));
/* 21 */     int cfgid = Integer.parseInt((String)params.get(1));
/* 22 */     boolean hide = Integer.parseInt((String)params.get(2)) == 0L;
/*    */     
/* 24 */     if ((itemType < 1) || (itemType > 6))
/*    */     {
/* 26 */       rsp.retcode = Retcode.SUCCESS.value;
/* 27 */       Response response = IdipGmtUtil.getResponse(Retcode.SUCCESS.value, "item type invalid");
/* 28 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */       
/* 30 */       GameServer.logger().error(String.format("[gmt]ItemHideHandler.execute@item type invalid|item_type=%d|cfgid=%d|hide=%b", new Object[] { Integer.valueOf(itemType), Integer.valueOf(cfgid), Boolean.valueOf(hide) }));
/*    */       
/*    */ 
/* 33 */       return;
/*    */     }
/*    */     
/* 36 */     boolean result = ItemHideManager.itemHide(itemType, cfgid, hide);
/* 37 */     if (!result)
/*    */     {
/* 39 */       rsp.retcode = Retcode.SUCCESS.value;
/* 40 */       Response response = IdipGmtUtil.getResponse(Retcode.SUCCESS.value, "system error");
/* 41 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */       
/* 43 */       GameServer.logger().error(String.format("[gmt]ItemHideHandler.execute@handle failed|item_type=%d|cfgid=%d|hide=%b", new Object[] { Integer.valueOf(itemType), Integer.valueOf(cfgid), Boolean.valueOf(hide) }));
/*    */       
/*    */ 
/* 46 */       return;
/*    */     }
/*    */     
/* 49 */     rsp.retcode = Retcode.SUCCESS.value;
/* 50 */     Response response = IdipGmtUtil.getResponse(Retcode.SUCCESS.value, String.format("%s item_type=%d, cfgid=%d", new Object[] { hide ? "hide" : "display", Integer.valueOf(itemType), Integer.valueOf(cfgid) }));
/*    */     
/* 52 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */     
/* 54 */     GameServer.logger().info(String.format("[gmt]ItemHideHandler.execute@handle done|item_type=%d|cfgid=%d|hide=%b", new Object[] { Integer.valueOf(itemType), Integer.valueOf(cfgid), Boolean.valueOf(hide) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\generalcmd\ItemHideHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
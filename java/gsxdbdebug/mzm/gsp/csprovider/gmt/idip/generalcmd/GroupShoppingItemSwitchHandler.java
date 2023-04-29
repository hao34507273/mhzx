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
/*    */ import mzm.gsp.groupshopping.main.GroupShoppingBanInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class GroupShoppingItemSwitchHandler implements IdipHandler
/*    */ {
/*    */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp) throws Exception
/*    */   {
/* 19 */     int activityCfgid = Integer.parseInt((String)params.get(0));
/* 20 */     int itemCfgid = Integer.parseInt((String)params.get(1));
/* 21 */     boolean ban = Integer.parseInt((String)params.get(2)) == 0L;
/*    */     
/* 23 */     boolean result = false;
/* 24 */     if (ban)
/*    */     {
/* 26 */       result = GroupShoppingBanInterface.ban(activityCfgid, itemCfgid);
/*    */     }
/*    */     else
/*    */     {
/* 30 */       result = GroupShoppingBanInterface.unban(activityCfgid, itemCfgid);
/*    */     }
/* 32 */     if (!result)
/*    */     {
/* 34 */       int retcode = Retcode.SUCCESS.value;
/* 35 */       rsp.retcode = retcode;
/* 36 */       Response response = IdipGmtUtil.getResponse(retcode, "operate fialed");
/* 37 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */       
/* 39 */       GameServer.logger().error(String.format("[gmt]GroupShoppingItemSwitchHandler.execute@failed|activity_cfgid=%d|item_cfgid=%d|ban=%b", new Object[] { Integer.valueOf(activityCfgid), Integer.valueOf(itemCfgid), Boolean.valueOf(ban) }));
/*    */       
/*    */ 
/* 42 */       return;
/*    */     }
/*    */     
/* 45 */     rsp.retcode = Retcode.SUCCESS.value;
/* 46 */     Response response = IdipGmtUtil.getResponse(Retcode.SUCCESS.value, String.format("%s success", new Object[] { ban ? "ban" : "unban" }));
/*    */     
/* 48 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */     
/* 50 */     GameServer.logger().info(String.format("[gmt]GroupShoppingItemSwitchHandler.execute@success|activity_cfgid=%d|item_cfgid=%d|ban=%b", new Object[] { Integer.valueOf(activityCfgid), Integer.valueOf(itemCfgid), Boolean.valueOf(ban) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\generalcmd\GroupShoppingItemSwitchHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
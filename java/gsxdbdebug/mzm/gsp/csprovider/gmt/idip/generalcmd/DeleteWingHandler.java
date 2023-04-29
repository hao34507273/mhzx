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
/*    */ import mzm.gsp.wing.main2.WingInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class DeleteWingHandler implements IdipHandler
/*    */ {
/*    */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp) throws Exception
/*    */   {
/* 19 */     long roleid = Long.parseLong((String)params.get(0));
/* 20 */     int wingCfgid = Integer.parseInt((String)params.get(1));
/*    */     
/* 22 */     int retcode = WingInterface.deleteWing(roleid, wingCfgid);
/* 23 */     if (retcode != 0)
/*    */     {
/* 25 */       rsp.retcode = Retcode.SUCCESS.value;
/* 26 */       Response response = IdipGmtUtil.getResponse(Retcode.SUCCESS.value, "system error " + retcode);
/* 27 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */       
/* 29 */       GameServer.logger().error(String.format("[gmt]DeleteWingHandler.execute@failed|roleid=%d|wing_cfgid=%d|retcode=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(wingCfgid), Integer.valueOf(retcode) }));
/*    */       
/*    */ 
/* 32 */       return;
/*    */     }
/*    */     
/* 35 */     rsp.retcode = Retcode.SUCCESS.value;
/* 36 */     Response response = new Response();
/* 37 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */     
/* 39 */     GameServer.logger().info(String.format("[gmt]DeleteWingHandler.execute@success|roleid=%d|wing_cfgid=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(wingCfgid) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\generalcmd\DeleteWingHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
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
/*    */ import mzm.gsp.ladder.main.LadderInterface;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class RemoveCrossLadderHandler implements IdipHandler
/*    */ {
/*    */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp) throws Exception
/*    */   {
/* 20 */     long roleid = IdipGmtUtil.getRoleid((String)params.get(0));
/* 21 */     String userid = RoleInterface.getUserId(roleid);
/* 22 */     if (userid == null)
/*    */     {
/* 24 */       int retcode = Retcode.ACCOUNT_NOT_EXIST.value;
/* 25 */       rsp.retcode = retcode;
/* 26 */       Response response = IdipGmtUtil.getResponse(retcode, "user not found");
/* 27 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */       
/* 29 */       GameServer.logger().error(String.format("[gmt]RemoveCrossLadderHandler.execute@user not found|roleid=%d", new Object[] { Long.valueOf(roleid) }));
/* 30 */       return;
/*    */     }
/*    */     
/* 33 */     if (!LadderInterface.removeCrossLadderForIDIP(userid))
/*    */     {
/* 35 */       int retcode = Retcode.REMOVE_CROSS_LADDER_STATUS_FAILED.value;
/* 36 */       rsp.retcode = retcode;
/* 37 */       Response response = IdipGmtUtil.getResponse(retcode, "remove cross ladder status failed");
/* 38 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */       
/* 40 */       GameServer.logger().error(String.format("[gmt]RemoveCrossLadderHandler.execute@remove cross ladder failed|roleid=%d|userid=%s", new Object[] { Long.valueOf(roleid), userid }));
/*    */       
/*    */ 
/* 43 */       return;
/*    */     }
/*    */     
/* 46 */     rsp.retcode = Retcode.SUCCESS.value;
/* 47 */     Response response = new Response();
/* 48 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */     
/* 50 */     GameServer.logger().info(String.format("[gmt]RemoveCrossLadderHandler.execute@remove cross ladder done|roleid=%d|userid=%s", new Object[] { Long.valueOf(roleid), userid }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\generalcmd\RemoveCrossLadderHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
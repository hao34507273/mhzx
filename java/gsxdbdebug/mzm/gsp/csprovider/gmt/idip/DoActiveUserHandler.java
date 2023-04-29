/*    */ package mzm.gsp.csprovider.gmt.idip;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import csprovider.DataBetweenCspAndGame_Re;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.csprovider.gmt.GmtCmdManager;
/*    */ import mzm.gsp.csprovider.main.Retcode;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class DoActiveUserHandler implements IdipHandler
/*    */ {
/*    */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp) throws Exception
/*    */   {
/* 15 */     String userid = (String)params.get(0);
/* 16 */     xbean.User xUser = xtable.User.get(userid);
/* 17 */     if (null == xUser)
/*    */     {
/* 19 */       int retcode = Retcode.ACCOUNT_NOT_EXIST.value;
/* 20 */       rsp.retcode = retcode;
/* 21 */       Response response = IdipGmtUtil.getResponse(retcode, "user not found");
/* 22 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */       
/* 24 */       GameServer.logger().error(String.format("[gmt]DoActiveUserHandler.execute@user not found|userid=%s", new Object[] { userid }));
/* 25 */       return;
/*    */     }
/*    */     
/* 28 */     xUser.setActivated(true);
/*    */     
/* 30 */     rsp.retcode = Retcode.SUCCESS.value;
/* 31 */     Response response = new Response();
/* 32 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */     
/* 34 */     GameServer.logger().info(String.format("[gmt]DoActiveUserHandler.execute@active user success|userid=%s", new Object[] { userid }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\DoActiveUserHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
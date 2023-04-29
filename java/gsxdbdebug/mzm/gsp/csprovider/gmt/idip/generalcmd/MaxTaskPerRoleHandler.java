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
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class MaxTaskPerRoleHandler implements IdipHandler
/*    */ {
/*    */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp) throws Exception
/*    */   {
/* 19 */     int number = Integer.valueOf((String)params.get(0)).intValue();
/* 20 */     if (number <= 0)
/*    */     {
/* 22 */       int retcode = Retcode.MAX_TASK_PERSON_LESS_THAN_ZERO.value;
/* 23 */       rsp.retcode = retcode;
/* 24 */       Response response = IdipGmtUtil.getResponse(retcode, "max_task_per_role num <= 0");
/* 25 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */       
/* 27 */       GameServer.logger().error(String.format("[gmt]MaxTaskPerRoleReq.execute@max_task_per_role num <= 0|max_task_per_role=%d", new Object[] { Integer.valueOf(number) }));
/*    */       
/* 29 */       return;
/*    */     }
/*    */     
/* 32 */     OnlineManager.getInstance().setMaxTaskPerRole(number);
/*    */     
/* 34 */     rsp.retcode = Retcode.SUCCESS.value;
/* 35 */     String retMsg = String.format("maxTaskPerRole=%d", new Object[] { Integer.valueOf(number) });
/* 36 */     Response response = new Response();
/* 37 */     response.msg = retMsg;
/* 38 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */     
/* 40 */     GameServer.logger().info(String.format("[gmt]MaxTaskPerRoleReq.execute@set max_task_per_role done|task_number=%d", new Object[] { Integer.valueOf(number) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\generalcmd\MaxTaskPerRoleHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
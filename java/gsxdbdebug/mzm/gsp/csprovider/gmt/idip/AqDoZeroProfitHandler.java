/*    */ package mzm.gsp.csprovider.gmt.idip;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import csprovider.DataBetweenCspAndGame_Re;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.csprovider.gmt.GmtCmdManager;
/*    */ import mzm.gsp.csprovider.main.Retcode;
/*    */ import mzm.gsp.idip.main.IdipInterface;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.tlog.TLogManager;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class AqDoZeroProfitHandler implements IdipHandler
/*    */ {
/*    */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp) throws Exception
/*    */   {
/* 18 */     String userid = (String)params.get(0);
/* 19 */     long roleid = IdipGmtUtil.getRoleid((String)params.get(1));
/* 20 */     int time = Integer.parseInt((String)params.get(2));
/* 21 */     String reason = (String)params.get(3);
/*    */     
/* 23 */     xbean.User xUser = xtable.User.get(userid);
/* 24 */     if (null == xUser)
/*    */     {
/* 26 */       int retcode = Retcode.ACCOUNT_NOT_EXIST.value;
/* 27 */       rsp.retcode = retcode;
/* 28 */       Response response = IdipGmtUtil.getResponse(retcode, "user not found");
/* 29 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */       
/* 31 */       GameServer.logger().error(String.format("[gmt]AqDoZeroProfitHandler.execute@user not found|userid=%s|roleid=%d|time=%d|reason=%s", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(time), reason }));
/*    */       
/*    */ 
/* 34 */       return;
/*    */     }
/*    */     
/* 37 */     if ((!RoleInterface.isRoleExist(roleid, true)) || (!xUser.getRoleids().contains(Long.valueOf(roleid))))
/*    */     {
/* 39 */       int retcode = Retcode.ROLE_NOT_EXIST.value;
/* 40 */       rsp.retcode = retcode;
/* 41 */       Response response = IdipGmtUtil.getResponse(retcode, "role not found");
/* 42 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */       
/* 44 */       GameServer.logger().error(String.format("[gmt]AqDoZeroProfitHandler.execute@role not found|userid=%s|user_role_list=%s|roleid=%d|time=%d|reason=%s", new Object[] { userid, xUser.getRoleids().toString(), Long.valueOf(roleid), Integer.valueOf(time), reason }));
/*    */       
/*    */ 
/*    */ 
/* 48 */       return;
/*    */     }
/*    */     
/* 51 */     if (time <= 0)
/*    */     {
/* 53 */       int retcode = Retcode.AQ_DO_ZERO_PROFIT_TIME_INVALID.value;
/* 54 */       rsp.retcode = retcode;
/* 55 */       Response response = IdipGmtUtil.getResponse(retcode, "time <= 0");
/* 56 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */       
/* 58 */       GameServer.logger().error(String.format("[gmt]AqDoZeroProfitHandler.execute@time <= 0|userid=%s|roleid=%d|time=%d|reason=%s", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(time), reason }));
/*    */       
/*    */ 
/* 61 */       return;
/*    */     }
/*    */     
/* 64 */     if (reason.isEmpty())
/*    */     {
/* 66 */       int retcode = Retcode.AQ_DO_ZERO_PROFIT_REASON_EMPTY.value;
/* 67 */       rsp.retcode = retcode;
/* 68 */       Response response = IdipGmtUtil.getResponse(retcode, "reason is empty");
/* 69 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */       
/* 71 */       GameServer.logger().error(String.format("[gmt]AqDoZeroProfitHandler.execute@reason is empty|userid=%s|roleid=%d|time=%d|reason=%s", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(time), reason }));
/*    */       
/*    */ 
/* 74 */       return;
/*    */     }
/* 76 */     if (reason.length() > 256)
/*    */     {
/* 78 */       int retcode = Retcode.AQ_DO_ZERO_PROFIT_REASON_TOO_LONG.value;
/* 79 */       rsp.retcode = retcode;
/* 80 */       Response response = IdipGmtUtil.getResponse(retcode, String.format("reason length > %d", new Object[] { Integer.valueOf(256) }));
/*    */       
/* 82 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */       
/* 84 */       GameServer.logger().error(String.format("[gmt]AqDoZeroProfitHandler.execute@reason length > MAX_ZERO_PROFIT_REASON_LEN|userid=%s|roleid=%d|time=%d|reason=%s", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(time), reason }));
/*    */       
/*    */ 
/*    */ 
/* 88 */       return;
/*    */     }
/*    */     
/* 91 */     IdipInterface.addZeroProfit(roleid, time, reason);
/*    */     
/* 93 */     rsp.retcode = Retcode.SUCCESS.value;
/* 94 */     Response response = new Response();
/* 95 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */     
/* 97 */     TLogManager.getInstance().addLog(userid, "GMTAqDoZeroProfit", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(time), reason });
/*    */     
/* 99 */     GameServer.logger().info(String.format("[gmt]AqDoZeroProfitHandler.execute@do zero profit done|userid=%s|roleid=%d|time=%d|reason=%s", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(time), reason }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\AqDoZeroProfitHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
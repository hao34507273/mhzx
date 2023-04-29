/*     */ package mzm.gsp.csprovider.gmt.idip;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import csprovider.DataBetweenCspAndGame_Re;
/*     */ import idip.DoUpdateCashRsp;
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.csprovider.gmt.GmtCmdManager;
/*     */ import mzm.gsp.csprovider.main.Retcode;
/*     */ import mzm.gsp.qingfu.main.CostResult;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.qingfu.main.PresentResult;
/*     */ import mzm.gsp.qingfu.main.PresentType;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class DoUpdateCashHandler
/*     */   implements IdipHandler
/*     */ {
/*     */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp) throws Exception
/*     */   {
/*  26 */     String userid = (String)params.get(0);
/*  27 */     long roleId = IdipGmtUtil.getRoleid((String)params.get(1));
/*  28 */     int value = Integer.valueOf((String)params.get(2)).intValue();
/*     */     
/*  30 */     xbean.User xUser = xtable.User.get(userid);
/*  31 */     if (null == xUser)
/*     */     {
/*  33 */       int retcode = Retcode.ACCOUNT_NOT_EXIST.value;
/*  34 */       rsp.retcode = retcode;
/*  35 */       Response response = IdipGmtUtil.getResponse(retcode, "user not found");
/*  36 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  38 */       GameServer.logger().error(String.format("[gmt]DoUpdateCashHandler.execute@user not found|userid=%s|roleid=%d|value=%d", new Object[] { userid, Long.valueOf(roleId), Integer.valueOf(value) }));
/*     */       
/*     */ 
/*  41 */       return;
/*     */     }
/*     */     
/*  44 */     if ((!RoleInterface.isRoleExist(roleId, true)) || (!xUser.getRoleids().contains(Long.valueOf(roleId))))
/*     */     {
/*  46 */       int retcode = Retcode.ROLE_NOT_EXIST.value;
/*  47 */       rsp.retcode = retcode;
/*  48 */       Response response = IdipGmtUtil.getResponse(retcode, "role not found");
/*  49 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  51 */       GameServer.logger().error(String.format("[gmt]DoUpdateCashHandler.execute@role not found|userid=%s|user_role_list=%s|roleid=%d|value=%d", new Object[] { userid, xUser.getRoleids().toString(), Long.valueOf(roleId), Integer.valueOf(value) }));
/*     */       
/*     */ 
/*     */ 
/*  55 */       return;
/*     */     }
/*     */     
/*  58 */     if (value == 0)
/*     */     {
/*  60 */       int retcode = Retcode.UPDATE_CASH_VALUE_EQUALS_ZERO.value;
/*  61 */       rsp.retcode = retcode;
/*  62 */       Response response = IdipGmtUtil.getResponse(retcode, "value == 0");
/*  63 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  65 */       GameServer.logger().error(String.format("[gmt]DoUpdateCashHandler.execute@value == 0|userid=%s|roleid=%d|value=%d", new Object[] { userid, Long.valueOf(roleId), Integer.valueOf(value) }));
/*     */       
/*     */ 
/*  68 */       return;
/*     */     }
/*     */     
/*  71 */     int beginValue = (int)QingfuInterface.getBalance(userid, true);
/*  72 */     TLogArg tLogArg = new TLogArg(LogReason.GMT_DO_UPDATE_CASH);
/*  73 */     if (value >= 0)
/*     */     {
/*  75 */       PresentResult result = QingfuInterface.presentYuanbao(userid, roleId, value, PresentType.PRESENT_BIND_GMT, tLogArg);
/*     */       
/*  77 */       if (result != PresentResult.Success)
/*     */       {
/*  79 */         int retcode = Retcode.UPDATE_CASH_FAILED.value;
/*  80 */         rsp.retcode = retcode;
/*  81 */         Response response = IdipGmtUtil.getResponse(retcode, result.desc);
/*  82 */         rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */         
/*  84 */         GameServer.logger().error(String.format("[gmt]DoUpdateCashHandler.execute@update yuan bao failed|ret=%d|ret_msg=%s|userid=%s|roleid=%d|value=%d", new Object[] { Integer.valueOf(result.code), result.desc, userid, Long.valueOf(roleId), Integer.valueOf(value) }));
/*     */         
/*     */ 
/*     */ 
/*  88 */         return;
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/*  93 */       CostResult result = QingfuInterface.costYuanbao(userid, roleId, -value, CostType.COST_BIND_FIRST_GMT, tLogArg);
/*  94 */       if (result != CostResult.Success)
/*     */       {
/*  96 */         int retcode = Retcode.UPDATE_CASH_FAILED.value;
/*  97 */         rsp.retcode = retcode;
/*  98 */         Response response = IdipGmtUtil.getResponse(retcode, result.desc);
/*  99 */         rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */         
/* 101 */         GameServer.logger().error(String.format("[gmt]DoUpdateCashHandler.execute@update yuan bao failed|ret=%d|ret_msg=%s|userid=%s|roleid=%d|value=%d", new Object[] { Integer.valueOf(result.code), result.desc, userid, Long.valueOf(roleId), Integer.valueOf(value) }));
/*     */         
/*     */ 
/*     */ 
/* 105 */         return;
/*     */       }
/*     */     }
/*     */     
/* 109 */     int endValue = (int)QingfuInterface.getBalance(userid, true);
/*     */     
/* 111 */     DoUpdateCashRsp updateCashRsp = new DoUpdateCashRsp();
/* 112 */     updateCashRsp.Result = Retcode.SUCCESS.value;
/* 113 */     updateCashRsp.RetMsg = "ok";
/* 114 */     updateCashRsp.BeginValue = beginValue;
/* 115 */     updateCashRsp.EndValue = endValue;
/*     */     
/* 117 */     rsp.retcode = Retcode.SUCCESS.value;
/* 118 */     Response response = new Response();
/* 119 */     response.data = updateCashRsp;
/* 120 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */     
/* 122 */     TLogManager.getInstance().addLog(userid, "GMTDoUpdateCash", new Object[] { userid, Long.valueOf(roleId), Integer.valueOf(value), Integer.valueOf(beginValue), Integer.valueOf(endValue) });
/*     */     
/* 124 */     GameServer.logger().info(String.format("[gmt]DoUpdateCashHandler.execute@update yuan bao success|userid=%s|roleid=%d|value=%d|begin_value=%d|end_value=%d", new Object[] { userid, Long.valueOf(roleId), Integer.valueOf(value), Integer.valueOf(beginValue), Integer.valueOf(endValue) }));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\DoUpdateCashHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
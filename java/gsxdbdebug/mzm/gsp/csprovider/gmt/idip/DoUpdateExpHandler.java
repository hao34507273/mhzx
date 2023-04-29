/*     */ package mzm.gsp.csprovider.gmt.idip;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import csprovider.DataBetweenCspAndGame_Re;
/*     */ import idip.DoUpdateExpRsp;
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.csprovider.gmt.GmtCmdManager;
/*     */ import mzm.gsp.csprovider.main.Retcode;
/*     */ import mzm.gsp.role.main.Role;
/*     */ import mzm.gsp.role.main.RoleExpUpdateRet;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class DoUpdateExpHandler
/*     */   implements IdipHandler
/*     */ {
/*     */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp)
/*     */     throws Exception
/*     */   {
/*  24 */     String userId = (String)params.get(0);
/*  25 */     long roleId = IdipGmtUtil.getRoleid((String)params.get(1));
/*  26 */     int value = Integer.valueOf((String)params.get(2)).intValue();
/*     */     
/*  28 */     xbean.User xUser = xtable.User.get(userId);
/*  29 */     if (null == xUser)
/*     */     {
/*  31 */       int retcode = Retcode.ACCOUNT_NOT_EXIST.value;
/*  32 */       rsp.retcode = retcode;
/*  33 */       Response response = IdipGmtUtil.getResponse(retcode, "user not found");
/*  34 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  36 */       GameServer.logger().error(String.format("[gmt]DoUpdateExpHandler.execute@user not found|userid=%s|roleid=%d|value=%d", new Object[] { userId, Long.valueOf(roleId), Integer.valueOf(value) }));
/*     */       
/*     */ 
/*  39 */       return;
/*     */     }
/*     */     
/*  42 */     if ((!RoleInterface.isRoleExist(roleId, true)) || (!xUser.getRoleids().contains(Long.valueOf(roleId))))
/*     */     {
/*  44 */       int retcode = Retcode.ROLE_NOT_EXIST.value;
/*  45 */       rsp.retcode = retcode;
/*  46 */       Response response = IdipGmtUtil.getResponse(retcode, "role not found");
/*  47 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  49 */       GameServer.logger().error(String.format("[gmt]DoUpdateExpHandler.execute@role not found|userid=%s|user_role_list=%s|roleid=%d|value=%d", new Object[] { userId, xUser.getRoleids().toString(), Long.valueOf(roleId), Integer.valueOf(value) }));
/*     */       
/*     */ 
/*     */ 
/*  53 */       return;
/*     */     }
/*     */     
/*  56 */     if (value == 0)
/*     */     {
/*  58 */       int retcode = Retcode.UPDATE_EXP_VALUE_EQUALS_ZERO.value;
/*  59 */       rsp.retcode = retcode;
/*  60 */       Response response = IdipGmtUtil.getResponse(retcode, "value == 0");
/*  61 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  63 */       GameServer.logger().error(String.format("[gmt]DoUpdateExpHandler.execute@value == 0|userid=%s|user_role_list=%s|roleid=%d|value=%d", new Object[] { userId, xUser.getRoleids().toString(), Long.valueOf(roleId), Integer.valueOf(value) }));
/*     */       
/*     */ 
/*  66 */       return;
/*     */     }
/*     */     
/*  69 */     Role role = RoleInterface.getRole(roleId, true);
/*  70 */     int beginValue = role.getExp();
/*  71 */     TLogArg tLogArg = new TLogArg(LogReason.GMT_DO_UPDATE_EXP);
/*  72 */     RoleExpUpdateRet result = null;
/*  73 */     if (value >= 0)
/*     */     {
/*  75 */       result = role.addExpForIdip(value, tLogArg);
/*     */     }
/*     */     else
/*     */     {
/*  79 */       result = role.cutExpForIdip(-value, tLogArg);
/*     */     }
/*     */     
/*  82 */     if (RoleExpUpdateRet.SUCCESS != result)
/*     */     {
/*  84 */       int retcode = Retcode.UPDATE_EXP_FAILED.value;
/*  85 */       rsp.retcode = retcode;
/*  86 */       Response response = IdipGmtUtil.getResponse(retcode, result.retMsg);
/*  87 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  89 */       GameServer.logger().error(String.format("[gmt]DoUpdateExpHandler.execute@update exp failed|ret=%d|ret_msg=%s|userid=%s|roleid=%d|value=%d", new Object[] { Integer.valueOf(result.ret), result.retMsg, userId, Long.valueOf(roleId), Integer.valueOf(value) }));
/*     */       
/*     */ 
/*     */ 
/*  93 */       return;
/*     */     }
/*     */     
/*  96 */     int endValue = role.getExp();
/*     */     
/*  98 */     DoUpdateExpRsp updateExpRsp = new DoUpdateExpRsp();
/*  99 */     updateExpRsp.BeginValue = beginValue;
/* 100 */     updateExpRsp.EndValue = endValue;
/* 101 */     updateExpRsp.RetMsg = "ok";
/* 102 */     updateExpRsp.Result = 0;
/*     */     
/* 104 */     rsp.retcode = Retcode.SUCCESS.value;
/* 105 */     Response response = new Response();
/* 106 */     response.data = updateExpRsp;
/* 107 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */     
/* 109 */     TLogManager.getInstance().addLog(userId, "GMTDoUpdateExp", new Object[] { userId, Long.valueOf(roleId), Integer.valueOf(value), Integer.valueOf(beginValue), Integer.valueOf(endValue) });
/*     */     
/* 111 */     GameServer.logger().info(String.format("[gmt]DoUpdateExpHandler.execute@update exp success|ret=%d|ret_msg=%s|userid=%s|roleid=%d|value=%d|begin_value=%d|end_value=%d", new Object[] { Integer.valueOf(result.ret), result.retMsg, userId, Long.valueOf(roleId), Integer.valueOf(value), Integer.valueOf(beginValue), Integer.valueOf(endValue) }));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\DoUpdateExpHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
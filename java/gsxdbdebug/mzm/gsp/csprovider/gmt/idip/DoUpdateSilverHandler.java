/*     */ package mzm.gsp.csprovider.gmt.idip;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import csprovider.DataBetweenCspAndGame_Re;
/*     */ import idip.DoUpdateSilverRsp;
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.csprovider.gmt.GmtCmdManager;
/*     */ import mzm.gsp.csprovider.main.Retcode;
/*     */ import mzm.gsp.role.main.MoneyOperResult;
/*     */ import mzm.gsp.role.main.Role;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class DoUpdateSilverHandler
/*     */   implements IdipHandler
/*     */ {
/*     */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp) throws Exception
/*     */   {
/*  23 */     String userId = (String)params.get(0);
/*  24 */     long roleId = IdipGmtUtil.getRoleid((String)params.get(1));
/*  25 */     int value = Integer.valueOf((String)params.get(2)).intValue();
/*     */     
/*  27 */     xbean.User xUser = xtable.User.get(userId);
/*  28 */     if (null == xUser)
/*     */     {
/*  30 */       int retcode = Retcode.ACCOUNT_NOT_EXIST.value;
/*  31 */       rsp.retcode = retcode;
/*  32 */       Response response = IdipGmtUtil.getResponse(retcode, "user not found");
/*  33 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  35 */       GameServer.logger().error(String.format("[gmt]DoUpdateSilverHandler.execute@user not found|userid=%s|roleid=%s|value=%d", new Object[] { userId, Long.valueOf(roleId), Integer.valueOf(value) }));
/*     */       
/*     */ 
/*  38 */       return;
/*     */     }
/*     */     
/*  41 */     if ((!RoleInterface.isRoleExist(roleId, true)) || (!xUser.getRoleids().contains(Long.valueOf(roleId))))
/*     */     {
/*  43 */       int retcode = Retcode.ROLE_NOT_EXIST.value;
/*  44 */       rsp.retcode = retcode;
/*  45 */       Response response = IdipGmtUtil.getResponse(retcode, "role not found");
/*  46 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  48 */       GameServer.logger().error(String.format("[gmt]DoUpdateSilverHandler.execute@role not found|userid=%s|user_role_list=%s|roleid=%d|value=%d", new Object[] { userId, xUser.getRoleids().toString(), Long.valueOf(roleId), Integer.valueOf(value) }));
/*     */       
/*     */ 
/*     */ 
/*  52 */       return;
/*     */     }
/*     */     
/*  55 */     if (value == 0)
/*     */     {
/*  57 */       int retcode = Retcode.UPDATE_SILVER_VALUE_EQUALS_ZERO.value;
/*  58 */       rsp.retcode = retcode;
/*  59 */       Response response = IdipGmtUtil.getResponse(retcode, "value == 0");
/*  60 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  62 */       GameServer.logger().error(String.format("[gmt]DoUpdateSilverHandler.execute@value == 0|userid=%s|roleid=%d|value=%d", new Object[] { userId, Long.valueOf(roleId), Integer.valueOf(value) }));
/*     */       
/*     */ 
/*  65 */       return;
/*     */     }
/*     */     
/*  68 */     Role role = RoleInterface.getRole(roleId, true);
/*  69 */     int beginValue = (int)role.getSilver();
/*  70 */     TLogArg tLogArg = new TLogArg(LogReason.GMT_DO_UPDATE_SILVER);
/*  71 */     MoneyOperResult result = null;
/*  72 */     if (value >= 0)
/*     */     {
/*  74 */       result = RoleInterface.addSilverByIDIP(roleId, value, tLogArg);
/*     */     }
/*     */     else
/*     */     {
/*  78 */       result = RoleInterface.cutSilverByIDIP(roleId, -value, tLogArg);
/*     */     }
/*     */     
/*  81 */     if (result != MoneyOperResult.SUCCESS)
/*     */     {
/*  83 */       int retcode = Retcode.UPDATE_SILVER_FAILED.value;
/*  84 */       rsp.retcode = retcode;
/*  85 */       Response response = IdipGmtUtil.getResponse(retcode, result.retMsg);
/*  86 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  88 */       GameServer.logger().error(String.format("[gmt]DoUpdateSilverHandler.execute@update silver failed|ret=%d|ret_msg=%s|userid=%s|roleid=%d|value=%d", new Object[] { Integer.valueOf(result.ret), result.retMsg, userId, Long.valueOf(roleId), Integer.valueOf(value) }));
/*     */       
/*     */ 
/*     */ 
/*  92 */       return;
/*     */     }
/*     */     
/*  95 */     int endValue = (int)role.getSilver();
/*     */     
/*  97 */     DoUpdateSilverRsp doUpdateSilverRsp = new DoUpdateSilverRsp();
/*  98 */     doUpdateSilverRsp.BeginValue = beginValue;
/*  99 */     doUpdateSilverRsp.EndValue = endValue;
/* 100 */     doUpdateSilverRsp.Result = 0;
/* 101 */     doUpdateSilverRsp.RetMsg = "ok";
/*     */     
/* 103 */     rsp.retcode = result.ret;
/* 104 */     Response response = new Response();
/* 105 */     response.data = doUpdateSilverRsp;
/* 106 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */     
/* 108 */     TLogManager.getInstance().addLog(userId, "GMTDoUpdateSilver", new Object[] { userId, Long.valueOf(roleId), Integer.valueOf(value), Integer.valueOf(beginValue), Integer.valueOf(endValue) });
/*     */     
/* 110 */     GameServer.logger().info(String.format("[gmt]DoUpdateSilverHandler.execute@update silver success|ret=%d|ret_msg=%s|userid=%s|roleid=%d|value=%d|begin_value=%d|end_value=%d", new Object[] { Integer.valueOf(result.ret), result.retMsg, userId, Long.valueOf(roleId), Integer.valueOf(value), Integer.valueOf(beginValue), Integer.valueOf(endValue) }));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\DoUpdateSilverHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
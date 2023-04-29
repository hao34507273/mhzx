/*     */ package mzm.gsp.csprovider.gmt.idip;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import csprovider.DataBetweenCspAndGame_Re;
/*     */ import idip.DoUpdateVitalityRsp;
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.csprovider.gmt.GmtCmdManager;
/*     */ import mzm.gsp.csprovider.main.Retcode;
/*     */ import mzm.gsp.role.main.Role;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.role.main.VigorOperResult;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class DoUpdateVitalityHandler
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
/*  35 */       GameServer.logger().error(String.format("[gmt]DoUpdateVitalityHandler.execute@user not found|userid=%s|roleid=%d|value=%d", new Object[] { userId, Long.valueOf(roleId), Integer.valueOf(value) }));
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
/*  48 */       GameServer.logger().error(String.format("[gmt]DoUpdateVitalityHandler@role not found|userid=%s|user_role_list=%s|roleid=%d|value=%d", new Object[] { userId, xUser.getRoleids().toString(), Long.valueOf(roleId), Integer.valueOf(value) }));
/*     */       
/*     */ 
/*  51 */       return;
/*     */     }
/*     */     
/*  54 */     if (value == 0)
/*     */     {
/*  56 */       int retcode = Retcode.UPDATE_VIGOR_VALUE_EQUALS_ZERO.value;
/*  57 */       rsp.retcode = retcode;
/*  58 */       Response response = IdipGmtUtil.getResponse(retcode, "value == 0");
/*  59 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  61 */       GameServer.logger().error(String.format("[gmt]DoUpdateVitalityHandler.execute@value == 0|userid=%s|roleid=%d|value=%d", new Object[] { userId, Long.valueOf(roleId), Integer.valueOf(value) }));
/*     */       
/*     */ 
/*  64 */       return;
/*     */     }
/*     */     
/*  67 */     Role role = RoleInterface.getRole(roleId, true);
/*  68 */     int beginValue = role.getVigor();
/*  69 */     TLogArg tLogArg = new TLogArg(LogReason.GMT_DO_UPDATE_VIGOR);
/*  70 */     VigorOperResult result = null;
/*  71 */     if (value >= 0)
/*     */     {
/*  73 */       result = RoleInterface.addVigorByIDIP(roleId, value, tLogArg);
/*     */     }
/*     */     else
/*     */     {
/*  77 */       result = RoleInterface.cutVigorByIDIP(roleId, -value, tLogArg);
/*     */     }
/*     */     
/*  80 */     if (result != VigorOperResult.SUCCESS)
/*     */     {
/*  82 */       int retcode = Retcode.UPDATE_VIGOR_FAILED.value;
/*  83 */       rsp.retcode = retcode;
/*  84 */       Response response = IdipGmtUtil.getResponse(retcode, result.retMsg);
/*  85 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  87 */       GameServer.logger().error(String.format("[gmt]DoUpdateVitalityHandler.execute@update vigor failed|ret=%d|ret_msg=%s|userid=%s|roleid=%d|value=%d", new Object[] { Integer.valueOf(result.ret), result.retMsg, userId, Long.valueOf(roleId), Integer.valueOf(value) }));
/*     */       
/*     */ 
/*     */ 
/*  91 */       return;
/*     */     }
/*     */     
/*  94 */     int endValue = role.getVigor();
/*     */     
/*  96 */     DoUpdateVitalityRsp updateVitalityRsp = new DoUpdateVitalityRsp();
/*  97 */     updateVitalityRsp.BeginValue = beginValue;
/*  98 */     updateVitalityRsp.EndValue = endValue;
/*  99 */     updateVitalityRsp.Result = 0;
/* 100 */     updateVitalityRsp.RetMsg = "ok";
/*     */     
/* 102 */     rsp.retcode = Retcode.SUCCESS.value;
/* 103 */     Response response = new Response();
/* 104 */     response.data = updateVitalityRsp;
/* 105 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */     
/* 107 */     TLogManager.getInstance().addLog(userId, "GMTDoUpdateVigor", new Object[] { userId, Long.valueOf(roleId), Integer.valueOf(value), Integer.valueOf(beginValue), Integer.valueOf(endValue) });
/*     */     
/* 109 */     GameServer.logger().info(String.format("[gmt]DoUpdateVitalityHandler.execute@update vigor success|ret=%d|ret_msg=%s|userid=%s|roleid=%d|value=%d|begin_value=%d|end_value=%d", new Object[] { Integer.valueOf(result.ret), result.retMsg, userId, Long.valueOf(roleId), Integer.valueOf(value), Integer.valueOf(beginValue), Integer.valueOf(endValue) }));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\DoUpdateVitalityHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
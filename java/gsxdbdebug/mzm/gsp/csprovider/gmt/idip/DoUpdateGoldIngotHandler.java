/*     */ package mzm.gsp.csprovider.gmt.idip;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import csprovider.DataBetweenCspAndGame_Re;
/*     */ import idip.DoUpdateGoldRsp;
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
/*     */ public class DoUpdateGoldIngotHandler
/*     */   implements IdipHandler
/*     */ {
/*     */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp) throws Exception
/*     */   {
/*  23 */     String userid = (String)params.get(0);
/*  24 */     long roleid = IdipGmtUtil.getRoleid((String)params.get(1));
/*  25 */     int value = Integer.parseInt((String)params.get(2));
/*     */     
/*  27 */     xbean.User xUser = xtable.User.get(userid);
/*  28 */     if (null == xUser)
/*     */     {
/*  30 */       int retcode = Retcode.ACCOUNT_NOT_EXIST.value;
/*  31 */       rsp.retcode = retcode;
/*  32 */       Response response = IdipGmtUtil.getResponse(retcode, "user not found");
/*  33 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  35 */       GameServer.logger().error(String.format("[gmt]DoUpdateGoldIngotHandler.execute@user not found|userid=%s|roleid=%d|value=%d", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(value) }));
/*     */       
/*     */ 
/*  38 */       return;
/*     */     }
/*     */     
/*  41 */     if ((!RoleInterface.isRoleExist(roleid, true)) || (!xUser.getRoleids().contains(Long.valueOf(roleid))))
/*     */     {
/*  43 */       int retcode = Retcode.ROLE_NOT_EXIST.value;
/*  44 */       rsp.retcode = retcode;
/*  45 */       Response response = IdipGmtUtil.getResponse(retcode, "role not found");
/*  46 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  48 */       GameServer.logger().error(String.format("[gmt]DoUpdateGoldIngotHandler.execute@role not found|userid=%s|user_role_list=%s|roleid=%d|value=%d", new Object[] { userid, xUser.getRoleids().toString(), Long.valueOf(roleid), Integer.valueOf(value) }));
/*     */       
/*     */ 
/*     */ 
/*  52 */       return;
/*     */     }
/*     */     
/*  55 */     if (value == 0)
/*     */     {
/*  57 */       int retcode = Retcode.UPDATE_GOLD_INGOT_VALUE_EQUALS_ZERO.value;
/*  58 */       rsp.retcode = retcode;
/*  59 */       Response response = IdipGmtUtil.getResponse(retcode, "value == 0");
/*  60 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  62 */       GameServer.logger().error(String.format("[gmt]DoUpdateGoldIngotHandler.execute@value == 0|userid=%s|user_role_list=%s|roleid=%d|value=%d", new Object[] { userid, xUser.getRoleids().toString(), Long.valueOf(roleid), Integer.valueOf(value) }));
/*     */       
/*     */ 
/*     */ 
/*  66 */       return;
/*     */     }
/*     */     
/*  69 */     Role role = RoleInterface.getRole(roleid, true);
/*  70 */     int beginValue = (int)role.getGoldIngot();
/*  71 */     TLogArg tLogArg = new TLogArg(LogReason.GMT_DO_UPDATE_GOLD_INGOT);
/*  72 */     MoneyOperResult result = null;
/*  73 */     if (value >= 0)
/*     */     {
/*  75 */       result = RoleInterface.addGoldIngotByIDIP(roleid, value, tLogArg);
/*     */     }
/*     */     else
/*     */     {
/*  79 */       result = RoleInterface.cutGoldIngotByIDIP(roleid, -value, tLogArg);
/*     */     }
/*     */     
/*  82 */     if (result != MoneyOperResult.SUCCESS)
/*     */     {
/*  84 */       int retcode = Retcode.UPDATE_GOLD_INGOT_FAILED.value;
/*  85 */       rsp.retcode = retcode;
/*  86 */       Response response = IdipGmtUtil.getResponse(retcode, result.retMsg);
/*  87 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  89 */       GameServer.logger().error(String.format("[gmt]DoUpdateGoldIngotHandler.execute@update gold ingot failed|ret=%d|ret_msg=%s|userid=%s|roleid=%d|value=%d", new Object[] { Integer.valueOf(result.ret), result.retMsg, userid, Long.valueOf(roleid), Integer.valueOf(value) }));
/*     */       
/*     */ 
/*     */ 
/*  93 */       return;
/*     */     }
/*     */     
/*  96 */     int endValue = (int)role.getGoldIngot();
/*     */     
/*  98 */     DoUpdateGoldRsp updateGoldRsp = new DoUpdateGoldRsp();
/*  99 */     updateGoldRsp.AgoNum = beginValue;
/* 100 */     updateGoldRsp.NowNum = endValue;
/* 101 */     updateGoldRsp.Result = 0;
/* 102 */     updateGoldRsp.RetMsg = "ok";
/*     */     
/* 104 */     rsp.retcode = Retcode.SUCCESS.value;
/* 105 */     Response response = new Response();
/* 106 */     response.data = updateGoldRsp;
/* 107 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */     
/* 109 */     TLogManager.getInstance().addLog(userid, "GMTDoUpdateGoldIngot", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(value), Integer.valueOf(beginValue), Integer.valueOf(endValue) });
/*     */     
/* 111 */     GameServer.logger().info(String.format("[gmt]DoUpdateGoldIngotHandler.execute@update gold ingot success|userid=%s|roleid=%d|value=%d|begin_value=%d|end_value=%d", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(value), Integer.valueOf(beginValue), Integer.valueOf(endValue) }));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\DoUpdateGoldIngotHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
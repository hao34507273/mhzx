/*     */ package mzm.gsp.csprovider.gmt.idip;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import csprovider.DataBetweenCspAndGame_Re;
/*     */ import idip.DoUpdateMoneyRsp;
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
/*     */ public class DoUpdateMoneyHandler
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
/*  35 */       GameServer.logger().error(String.format("[gmt]DoUpdateMoneyHandler.execute@user not found|userid=%s|roleid=%d|value=%d", new Object[] { userId, Long.valueOf(roleId), Integer.valueOf(value) }));
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
/*  48 */       GameServer.logger().error(String.format("[gmt]DoUpdateMoneyHandler.execute@role not found|userid=%s|user_role_list=%s|roleid=%d|value=%d", new Object[] { userId, xUser.getRoleids().toString(), Long.valueOf(roleId), Integer.valueOf(value) }));
/*     */       
/*     */ 
/*     */ 
/*  52 */       return;
/*     */     }
/*     */     
/*  55 */     if (value == 0)
/*     */     {
/*  57 */       int retcode = Retcode.UPDATE_GOLD_VALUE_EQUALS_ZERO.value;
/*  58 */       rsp.retcode = retcode;
/*  59 */       Response response = IdipGmtUtil.getResponse(retcode, "value == 0");
/*  60 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  62 */       GameServer.logger().error(String.format("[gmt]DoUpdateMoneyHandler.execute@value == 0|userid=%s|user_role_list=%s|roleid=%d|value=%d", new Object[] { userId, xUser.getRoleids().toString(), Long.valueOf(roleId), Integer.valueOf(value) }));
/*     */       
/*     */ 
/*     */ 
/*  66 */       return;
/*     */     }
/*     */     
/*  69 */     Role role = RoleInterface.getRole(roleId, true);
/*  70 */     int beginValue = (int)role.getGold();
/*  71 */     TLogArg tLogArg = new TLogArg(LogReason.GMT_DO_UPDATE_GOLD);
/*     */     
/*  73 */     MoneyOperResult result = null;
/*  74 */     if (value >= 0)
/*     */     {
/*  76 */       result = RoleInterface.addGoldByIDIP(roleId, value, tLogArg);
/*     */     }
/*     */     else
/*     */     {
/*  80 */       result = RoleInterface.cutGoldByIDIP(roleId, -value, tLogArg);
/*     */     }
/*     */     
/*  83 */     if (result != MoneyOperResult.SUCCESS)
/*     */     {
/*  85 */       int retcode = Retcode.UPDATE_GOLD_FAILED.value;
/*  86 */       rsp.retcode = retcode;
/*  87 */       Response response = IdipGmtUtil.getResponse(retcode, result.retMsg);
/*  88 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  90 */       GameServer.logger().error(String.format("[gmt]DoUpdateMoneyHandler.execute@update money failed|ret=%d|ret_msg=%s|userid=%s|role_id=%d|value=%d", new Object[] { Integer.valueOf(result.ret), result.retMsg, userId, Long.valueOf(roleId), Integer.valueOf(value) }));
/*     */       
/*     */ 
/*     */ 
/*  94 */       return;
/*     */     }
/*     */     
/*  97 */     int endValue = (int)role.getGold();
/*     */     
/*  99 */     DoUpdateMoneyRsp updateMoneyRsp = new DoUpdateMoneyRsp();
/* 100 */     updateMoneyRsp.BeginValue = beginValue;
/* 101 */     updateMoneyRsp.EndValue = endValue;
/* 102 */     updateMoneyRsp.Result = 0;
/* 103 */     updateMoneyRsp.RetMsg = "ok";
/*     */     
/* 105 */     rsp.retcode = Retcode.SUCCESS.value;
/* 106 */     Response response = new Response();
/* 107 */     response.data = updateMoneyRsp;
/* 108 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */     
/* 110 */     TLogManager.getInstance().addLog(userId, "GMTDoUpdateMoney", new Object[] { userId, Long.valueOf(roleId), Integer.valueOf(value), Integer.valueOf(beginValue), Integer.valueOf(endValue) });
/*     */     
/* 112 */     GameServer.logger().info(String.format("[gmt]DoUpdateMoneyHandler.execute@update money success|ret=%d|ret_msg=%s|userid=%s|roleid=%d|value=%d|begin_value=%d|end_value=%d", new Object[] { Integer.valueOf(result.ret), result.retMsg, userId, Long.valueOf(roleId), Integer.valueOf(value), Integer.valueOf(beginValue), Integer.valueOf(endValue) }));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\DoUpdateMoneyHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
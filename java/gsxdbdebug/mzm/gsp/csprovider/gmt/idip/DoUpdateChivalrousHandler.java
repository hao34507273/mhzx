/*     */ package mzm.gsp.csprovider.gmt.idip;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import csprovider.DataBetweenCspAndGame_Re;
/*     */ import idip.DoUpdateChivalrousRsp;
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.csprovider.gmt.GmtCmdManager;
/*     */ import mzm.gsp.csprovider.main.Retcode;
/*     */ import mzm.gsp.mall.main.JifenOperateEnum;
/*     */ import mzm.gsp.mall.main.MallInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class DoUpdateChivalrousHandler
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
/*  36 */       GameServer.logger().error(String.format("[gmt]DoUpdateChivalrousHandler.execute@user not found|userid=%s|roleid=%d|value=%d", new Object[] { userId, Long.valueOf(roleId), Integer.valueOf(value) }));
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
/*  49 */       GameServer.logger().error(String.format("[gmt]DoUpdateChivalrousHandler.execute@role not found|userid=%s|user_role_list=%s|roleid=%d|value=%d", new Object[] { userId, xUser.getRoleids().toString(), Long.valueOf(roleId), Integer.valueOf(value) }));
/*     */       
/*     */ 
/*     */ 
/*  53 */       return;
/*     */     }
/*     */     
/*  56 */     if (value == 0)
/*     */     {
/*  58 */       int retcode = Retcode.UPDATE_CHIVALROUS_VALUE_EQUALS_ZERO.value;
/*  59 */       rsp.retcode = retcode;
/*  60 */       Response response = IdipGmtUtil.getResponse(retcode, "value == 0");
/*  61 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  63 */       GameServer.logger().error(String.format("[gmt]DoUpdateChivalrousHandler.execute@value == 0|userid=%s|roleid=%d|value=%d", new Object[] { userId, Long.valueOf(roleId), Integer.valueOf(value) }));
/*     */       
/*     */ 
/*  66 */       return;
/*     */     }
/*     */     
/*  69 */     int beginValue = (int)MallInterface.getJifen(roleId, 1);
/*  70 */     TLogArg tLogArg = new TLogArg(LogReason.GMT_DO_UPDATE_CHIVALROUS);
/*  71 */     JifenOperateEnum result = null;
/*  72 */     if (value >= 0)
/*     */     {
/*  74 */       result = MallInterface.addJifenForIdip(roleId, value, 1, tLogArg);
/*     */     }
/*     */     else
/*     */     {
/*  78 */       result = MallInterface.cutJifenForIdip(roleId, -value, 1, tLogArg);
/*     */     }
/*     */     
/*  81 */     if (result != JifenOperateEnum.SUCCESS)
/*     */     {
/*  83 */       int retcode = Retcode.UPDATE_CHIVALROUS_FAILED.value;
/*  84 */       rsp.retcode = retcode;
/*  85 */       Response response = IdipGmtUtil.getResponse(retcode, result.retMsg);
/*  86 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  88 */       GameServer.logger().error(String.format("[gmt]DoUpdateChivalrousHandler.execute@update chivalrous failed|ret=%d|ret_msg=%s|userid=%s|roleid=%d|value=%d", new Object[] { Integer.valueOf(result.ret), result.retMsg, userId, Long.valueOf(roleId), Integer.valueOf(value) }));
/*     */       
/*     */ 
/*     */ 
/*  92 */       return;
/*     */     }
/*     */     
/*  95 */     int endValue = (int)MallInterface.getJifen(roleId, 1);
/*     */     
/*  97 */     DoUpdateChivalrousRsp updateChivalrousRsp = new DoUpdateChivalrousRsp();
/*  98 */     updateChivalrousRsp.BeginValue = beginValue;
/*  99 */     updateChivalrousRsp.EndValue = endValue;
/* 100 */     updateChivalrousRsp.Result = 0;
/* 101 */     updateChivalrousRsp.RetMsg = "ok";
/*     */     
/* 103 */     rsp.retcode = Retcode.SUCCESS.value;
/* 104 */     Response response = new Response();
/* 105 */     response.data = updateChivalrousRsp;
/* 106 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */     
/* 108 */     TLogManager.getInstance().addLog(userId, "GMTDoUpdateChivalrous", new Object[] { userId, Long.valueOf(roleId), Integer.valueOf(value), Integer.valueOf(beginValue), Integer.valueOf(endValue) });
/*     */     
/* 110 */     GameServer.logger().info(String.format("[gmt]DoUpdateChivalrousHandler.execute@update chivalrous success|ret=%d|ret_msg=%s|userid=%s|roleid=%d|value=%d|begin_value=%d|end_value=%d", new Object[] { Integer.valueOf(result.ret), result.retMsg, userId, Long.valueOf(roleId), Integer.valueOf(value), Integer.valueOf(beginValue), Integer.valueOf(endValue) }));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\DoUpdateChivalrousHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
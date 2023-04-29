/*     */ package mzm.gsp.csprovider.gmt.idip;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import csprovider.DataBetweenCspAndGame_Re;
/*     */ import idip.DoUpdateGangContributionRsp;
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.csprovider.gmt.GmtCmdManager;
/*     */ import mzm.gsp.csprovider.main.Retcode;
/*     */ import mzm.gsp.gang.main.BanggongOperateEnum;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class DoUpdateGangContributionHandler
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
/*  35 */       GameServer.logger().error(String.format("[gmt]DoUpdateGangContributionHandler.execute@user not found|userid=%s|roleid=%d|value=%d", new Object[] { userId, Long.valueOf(roleId), Integer.valueOf(value) }));
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
/*  48 */       GameServer.logger().error(String.format("[gmt]DoUpdateGangContributionHandler.execute@role not found|userid=%s|user_role_list=%s|roleid=%d|value=%d", new Object[] { userId, xUser.getRoleids().toString(), Long.valueOf(roleId), Integer.valueOf(value) }));
/*     */       
/*     */ 
/*     */ 
/*  52 */       return;
/*     */     }
/*     */     
/*  55 */     if (value == 0)
/*     */     {
/*  57 */       int retcode = Retcode.UPDATE_GANG_CONTRIBUTION_VALUE_EQUALS_ZERO.value;
/*  58 */       rsp.retcode = retcode;
/*  59 */       Response response = IdipGmtUtil.getResponse(retcode, "value == 0");
/*  60 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  62 */       GameServer.logger().error(String.format("[gmt]DoUpdateGangContributionHandler.execute@value == 0|userid=%s|user_role_list=%s|roleid=%d|value=%d", new Object[] { userId, xUser.getRoleids().toString(), Long.valueOf(roleId), Integer.valueOf(value) }));
/*     */       
/*     */ 
/*     */ 
/*  66 */       return;
/*     */     }
/*     */     
/*  69 */     int beginValue = (int)GangInterface.getBangGong(roleId);
/*  70 */     TLogArg tLogArg = new TLogArg(LogReason.GMT_DO_UPDATE_GANG_CONTRIBUTION);
/*  71 */     BanggongOperateEnum result = null;
/*  72 */     if (value >= 0)
/*     */     {
/*  74 */       result = GangInterface.addBangGongForIdip(roleId, value, tLogArg);
/*     */     }
/*     */     else
/*     */     {
/*  78 */       result = GangInterface.cutBangGongForIdip(roleId, -value, tLogArg);
/*     */     }
/*     */     
/*  81 */     if (result != BanggongOperateEnum.SUCCESS)
/*     */     {
/*  83 */       int retcode = Retcode.UPDATE_GANG_CONTRIBUTION_FAILED.value;
/*  84 */       rsp.retcode = retcode;
/*  85 */       Response response = IdipGmtUtil.getResponse(retcode, result.retMsg);
/*  86 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  88 */       GameServer.logger().error(String.format("[gmt]DoUpdateGangContributionHandler.execute@update gang contribution failed|ret=%d|ret_msg=%s|userid=%s|roleid=%d|value=%d", new Object[] { Integer.valueOf(result.ret), result.retMsg, userId, Long.valueOf(roleId), Integer.valueOf(value) }));
/*     */       
/*     */ 
/*     */ 
/*  92 */       return;
/*     */     }
/*  94 */     int endValue = (int)GangInterface.getBangGong(roleId);
/*     */     
/*  96 */     DoUpdateGangContributionRsp updateGangContributionRsp = new DoUpdateGangContributionRsp();
/*  97 */     updateGangContributionRsp.BeginValue = beginValue;
/*  98 */     updateGangContributionRsp.EndValue = endValue;
/*  99 */     updateGangContributionRsp.Result = 0;
/* 100 */     updateGangContributionRsp.RetMsg = "ok";
/*     */     
/* 102 */     rsp.retcode = Retcode.SUCCESS.value;
/* 103 */     Response response = new Response();
/* 104 */     response.data = updateGangContributionRsp;
/* 105 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */     
/* 107 */     TLogManager.getInstance().addLog(userId, "GMTDoUpdateGangContribution", new Object[] { userId, Long.valueOf(roleId), Integer.valueOf(value), Integer.valueOf(beginValue), Integer.valueOf(endValue) });
/*     */     
/* 109 */     GameServer.logger().info(String.format("[gmt]DoUpdateGangContributionHandler.execute@update gang contribution success|ret=%d|ret_msg=%s|userid=%s|roleid=%d|value=%d|begin_value=%d|end_value=%d", new Object[] { Integer.valueOf(result.ret), result.retMsg, userId, Long.valueOf(roleId), Integer.valueOf(value), Integer.valueOf(beginValue), Integer.valueOf(endValue) }));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\DoUpdateGangContributionHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
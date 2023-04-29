/*     */ package mzm.gsp.csprovider.gmt.idip;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import csprovider.DataBetweenCspAndGame_Re;
/*     */ import gnet.link.Onlines;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.csprovider.gmt.GmtCmdManager;
/*     */ import mzm.gsp.csprovider.main.Retcode;
/*     */ import mzm.gsp.idip.SIdipBanRole;
/*     */ import mzm.gsp.online.main.ForbidInfoManager;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class AqDoBanUsrHandler
/*     */   implements IdipHandler
/*     */ {
/*     */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp) throws Exception
/*     */   {
/*  24 */     String userid = (String)params.get(0);
/*  25 */     long targetRoleid = IdipGmtUtil.getRoleid((String)params.get(1));
/*  26 */     int time = Integer.parseInt((String)params.get(2));
/*  27 */     String reason = (String)params.get(3);
/*     */     
/*  29 */     xbean.User xUser = xtable.User.get(userid);
/*  30 */     if (null == xUser)
/*     */     {
/*  32 */       int retcode = Retcode.ACCOUNT_NOT_EXIST.value;
/*  33 */       rsp.retcode = retcode;
/*  34 */       Response response = IdipGmtUtil.getResponse(retcode, "user not found");
/*  35 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  37 */       GameServer.logger().error(String.format("[gmt]AqDoBanUsrHandler.execute@user not found|userid=%s|roleid=%d|time=%d|reason=%s", new Object[] { userid, Long.valueOf(targetRoleid), Integer.valueOf(time), reason }));
/*     */       
/*     */ 
/*  40 */       return;
/*     */     }
/*     */     
/*     */ 
/*  44 */     if (time <= 0)
/*     */     {
/*  46 */       int retcode = Retcode.BAN_USER_TIME_INVALID.value;
/*  47 */       rsp.retcode = retcode;
/*  48 */       Response response = IdipGmtUtil.getResponse(retcode, "time <= 0");
/*  49 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  51 */       GameServer.logger().error(String.format("[gmt]AqDoBanUsrHandler.execute@time <= 0|userid=%s|roleid=%d|time=%d|reason=%s", new Object[] { userid, Long.valueOf(targetRoleid), Integer.valueOf(time), reason }));
/*     */       
/*     */ 
/*  54 */       return;
/*     */     }
/*     */     
/*     */ 
/*  58 */     if (reason.isEmpty())
/*     */     {
/*  60 */       int retcode = Retcode.BAN_USER_REASON_IS_EMPTY.value;
/*  61 */       rsp.retcode = retcode;
/*  62 */       Response response = IdipGmtUtil.getResponse(retcode, "reason is empty");
/*  63 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  65 */       GameServer.logger().error(String.format("[gmt]AqDoBanUsrHandler.execute@reason is empty|userid=%s|roleid=%d|time=%d|reason=%s", new Object[] { userid, Long.valueOf(targetRoleid), Integer.valueOf(time), reason }));
/*     */       
/*     */ 
/*  68 */       return;
/*     */     }
/*     */     
/*  71 */     if (reason.length() > 300)
/*     */     {
/*  73 */       int retcode = Retcode.BAN_USER_REASON_TOO_LONG.value;
/*  74 */       rsp.retcode = retcode;
/*  75 */       Response response = IdipGmtUtil.getResponse(retcode, String.format("reason len > %d", new Object[] { Integer.valueOf(300) }));
/*     */       
/*  77 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  79 */       GameServer.logger().error(String.format("[gmt]AqDoBanUsrHandler.handle@reason length > MAX_BAN_ROLE_REMINDER_LEN|userid=%s|roleid=%d|time=%d|reason=%s", new Object[] { userid, Long.valueOf(targetRoleid), Integer.valueOf(time), reason }));
/*     */       
/*     */ 
/*     */ 
/*  83 */       return;
/*     */     }
/*     */     
/*     */ 
/*  87 */     if (targetRoleid > 0L)
/*     */     {
/*  89 */       if ((!RoleInterface.isRoleExist(targetRoleid, true)) || (!xUser.getRoleids().contains(Long.valueOf(targetRoleid))))
/*     */       {
/*  91 */         int retcode = Retcode.ROLE_NOT_EXIST.value;
/*  92 */         rsp.retcode = retcode;
/*  93 */         Response response = IdipGmtUtil.getResponse(retcode, "role not found");
/*  94 */         rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */         
/*  96 */         GameServer.logger().error(String.format("[gmt]AqDoBanUsrHandler.execute@role not found|userid=%s|user_role_list=%s|roleid=%d|time=%d|reason=%s", new Object[] { userid, xUser.getRoleids().toString(), Long.valueOf(targetRoleid), Integer.valueOf(time), reason }));
/*     */         
/*     */ 
/*     */ 
/* 100 */         return;
/*     */       }
/*     */       
/* 103 */       if (OnlineManager.getInstance().isOnline(targetRoleid))
/*     */       {
/*     */ 
/* 106 */         sendPromptMsg(targetRoleid, time, reason);
/*     */       }
/* 108 */       ForbidInfoManager.forbidRole(targetRoleid, time, reason);
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 113 */       Long roleid = Onlines.getInstance().getRoleid(userid);
/* 114 */       if (roleid != null)
/*     */       {
/*     */ 
/* 117 */         sendPromptMsg(roleid.longValue(), time, reason);
/*     */       }
/* 119 */       ForbidInfoManager.forbidUser(userid, time, reason);
/*     */     }
/*     */     
/* 122 */     rsp.retcode = Retcode.SUCCESS.value;
/* 123 */     Response response = new Response();
/* 124 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */     
/* 126 */     TLogManager.getInstance().addLog(userid, "GMTAqDoBanUsr", new Object[] { userid, Long.valueOf(targetRoleid), Integer.valueOf(time), reason });
/*     */     
/* 128 */     GameServer.logger().info(String.format("[gmt]AqDoBanUsrHandler.execute@ban done|userid=%s|roleid=%d|time=%d|reason=%s", new Object[] { userid, Long.valueOf(targetRoleid), Integer.valueOf(time), reason }));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void sendPromptMsg(long roleId, long time, String reason)
/*     */   {
/* 135 */     SIdipBanRole banRoleMsg = new SIdipBanRole();
/* 136 */     banRoleMsg.unbantime = (DateTimeUtils.getCurrTimeInMillis() / 1000L + time);
/*     */     try
/*     */     {
/* 139 */       banRoleMsg.reason.setString(reason, "UTF-8");
/*     */     }
/*     */     catch (UnsupportedEncodingException e) {}
/*     */     
/*     */ 
/*     */ 
/* 145 */     OnlineManager.getInstance().sendAtOnce(roleId, banRoleMsg);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\AqDoBanUsrHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
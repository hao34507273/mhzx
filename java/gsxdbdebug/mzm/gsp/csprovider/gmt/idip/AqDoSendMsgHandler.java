/*     */ package mzm.gsp.csprovider.gmt.idip;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import csprovider.DataBetweenCspAndGame_Re;
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.csprovider.gmt.GmtCmdManager;
/*     */ import mzm.gsp.csprovider.main.Retcode;
/*     */ import mzm.gsp.mail.main.MailInterface;
/*     */ import mzm.gsp.mail.main.SendMailRet;
/*     */ import mzm.gsp.mail.main.SendMailRet.RetEnum;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class AqDoSendMsgHandler implements IdipHandler
/*     */ {
/*     */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp) throws Exception
/*     */   {
/*  22 */     String userid = (String)params.get(0);
/*  23 */     long roleid = IdipGmtUtil.getRoleid((String)params.get(1));
/*  24 */     String content = (String)params.get(2);
/*     */     
/*  26 */     xbean.User xUser = xtable.User.get(userid);
/*  27 */     if (null == xUser)
/*     */     {
/*  29 */       int retcode = Retcode.ACCOUNT_NOT_EXIST.value;
/*  30 */       rsp.retcode = retcode;
/*  31 */       Response response = IdipGmtUtil.getResponse(retcode, "user not found");
/*  32 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  34 */       GameServer.logger().error(String.format("[gmt]AqDoSendMsgHandler.execute@user not found|userid=%s|roleid=%d|content=%s", new Object[] { userid, Long.valueOf(roleid), content }));
/*     */       
/*     */ 
/*  37 */       return;
/*     */     }
/*     */     
/*  40 */     if ((!RoleInterface.isRoleExist(roleid, true)) || (!xUser.getRoleids().contains(Long.valueOf(roleid))))
/*     */     {
/*  42 */       int retcode = Retcode.ROLE_NOT_EXIST.value;
/*  43 */       rsp.retcode = retcode;
/*  44 */       Response response = IdipGmtUtil.getResponse(retcode, "role not found");
/*  45 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  47 */       GameServer.logger().error(String.format("[gmt]AqDoSendMsgHandler.execute@role not found|userid=%s|user_role_list=%s|roleid=%d|content=%s", new Object[] { Long.valueOf(roleid), xUser.getRoleids().toString(), Long.valueOf(roleid), content }));
/*     */       
/*     */ 
/*     */ 
/*  51 */       return;
/*     */     }
/*     */     
/*     */ 
/*  55 */     if (content.isEmpty())
/*     */     {
/*  57 */       int retcode = Retcode.SEND_MSG_CONTENT_IS_EMPTY.value;
/*  58 */       rsp.retcode = retcode;
/*  59 */       Response response = IdipGmtUtil.getResponse(retcode, "content is empty");
/*  60 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  62 */       GameServer.logger().error(String.format("[gmt]AqDoSendMsgHandler.execute@content is empty|userid=%s|roleid=%d|content=%s", new Object[] { userid, Long.valueOf(roleid), content }));
/*     */       
/*     */ 
/*  65 */       return;
/*     */     }
/*  67 */     if (content.length() > 256)
/*     */     {
/*  69 */       int retcode = Retcode.SEND_MSG_CONTENT_TOO_LONG.value;
/*  70 */       rsp.retcode = retcode;
/*  71 */       Response response = IdipGmtUtil.getResponse(retcode, String.format("content len > %d", new Object[] { Integer.valueOf(256) }));
/*     */       
/*  73 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  75 */       GameServer.logger().error(String.format("[gmt]AqDoSendMsgHandler.execute@content length > MAX_MSG_CONTENT_LEN|userid=%s|roleid=%d|content=%s", new Object[] { userid, Long.valueOf(roleid), content }));
/*     */       
/*     */ 
/*     */ 
/*  79 */       return;
/*     */     }
/*     */     
/*  82 */     TLogArg tLogArg = new TLogArg(LogReason.GMT_AQ_DO_SEND_MSG);
/*  83 */     String title = "消息提示";
/*  84 */     SendMailRet sendMailRet = MailInterface.synBuildAndSendMail(roleid, 1, "消息提示", content, null, tLogArg);
/*     */     
/*     */ 
/*  87 */     if (!sendMailRet.isOK())
/*     */     {
/*  89 */       int retcode = Retcode.SEND_MSG_FAILED.value;
/*  90 */       rsp.retcode = retcode;
/*  91 */       Response response = IdipGmtUtil.getResponse(retcode, sendMailRet.getRetEnum().retMsg);
/*  92 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  94 */       GameServer.logger().error(String.format("[gmt]AqDoSendMsgHandler.execute@send msg by mail failed|ret=%d|ret_msg=%s|userid=%s|roleid=%d|content=%s", new Object[] { Integer.valueOf(sendMailRet.getRetEnum().ret), sendMailRet.getRetEnum().retMsg, userid, Long.valueOf(roleid), content }));
/*     */       
/*     */ 
/*     */ 
/*  98 */       return;
/*     */     }
/*     */     
/* 101 */     rsp.retcode = Retcode.SUCCESS.value;
/* 102 */     Response response = new Response();
/* 103 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */     
/* 105 */     TLogManager.getInstance().addLog(userid, "GMTAqDoSendMsg", new Object[] { userid, Long.valueOf(roleid), content });
/*     */     
/* 107 */     GameServer.logger().info(String.format("[gmt]AqDoSendMsgHandler.execute@send message done|userid=%s|roleid=%d|content=%s", new Object[] { userid, Long.valueOf(roleid), content }));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\AqDoSendMsgHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
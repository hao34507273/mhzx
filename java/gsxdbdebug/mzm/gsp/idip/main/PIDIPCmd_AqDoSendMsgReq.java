/*     */ package mzm.gsp.idip.main;
/*     */ 
/*     */ import idip.AqDoSendMsgReq;
/*     */ import idip.AqDoSendMsgRsp;
/*     */ import idip.IDIPCmd_AqDoSendMsgReq;
/*     */ import idip.IDIPPacket_AqDoSendMsgReq;
/*     */ import idip.IDIPPacket_AqDoSendMsgRsp;
/*     */ import idip.core.IdipHeader;
/*     */ import idip.core.Utils;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.mail.main.MailInterface;
/*     */ import mzm.gsp.mail.main.SendMailRet;
/*     */ import mzm.gsp.mail.main.SendMailRet.RetEnum;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class PIDIPCmd_AqDoSendMsgReq extends PIDIPCmd<IDIPCmd_AqDoSendMsgReq>
/*     */ {
/*     */   public PIDIPCmd_AqDoSendMsgReq(IDIPCmd_AqDoSendMsgReq cmd)
/*     */   {
/*  22 */     super(cmd);
/*     */   }
/*     */   
/*     */   protected boolean handle()
/*     */     throws Exception
/*     */   {
/*  28 */     String openId = ((AqDoSendMsgReq)((IDIPPacket_AqDoSendMsgReq)((IDIPCmd_AqDoSendMsgReq)this.cmd).req).body).OpenId;
/*  29 */     int areaId = ((AqDoSendMsgReq)((IDIPPacket_AqDoSendMsgReq)((IDIPCmd_AqDoSendMsgReq)this.cmd).req).body).AreaId;
/*  30 */     int partition = ((AqDoSendMsgReq)((IDIPPacket_AqDoSendMsgReq)((IDIPCmd_AqDoSendMsgReq)this.cmd).req).body).Partition;
/*     */     
/*  32 */     String userId = Utils.getUserId(openId, areaId, partition);
/*  33 */     xbean.User xUser = xtable.User.get(userId);
/*  34 */     if (null == xUser)
/*     */     {
/*  36 */       ((IDIPPacket_AqDoSendMsgRsp)((IDIPCmd_AqDoSendMsgReq)this.cmd).rsp).head.Result = 1;
/*  37 */       ((IDIPPacket_AqDoSendMsgRsp)((IDIPCmd_AqDoSendMsgReq)this.cmd).rsp).head.RetErrMsg = "query userid empty";
/*  38 */       ((IDIPCmd_AqDoSendMsgReq)this.cmd).sendResponse();
/*     */       
/*  40 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoSendMsgReq.handle@user not found|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|msg_content=%s|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoSendMsgRsp)((IDIPCmd_AqDoSendMsgReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoSendMsgRsp)((IDIPCmd_AqDoSendMsgReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((AqDoSendMsgReq)((IDIPPacket_AqDoSendMsgReq)((IDIPCmd_AqDoSendMsgReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoSendMsgReq)((IDIPPacket_AqDoSendMsgReq)((IDIPCmd_AqDoSendMsgReq)this.cmd).req).body).RoleId, ((AqDoSendMsgReq)((IDIPPacket_AqDoSendMsgReq)((IDIPCmd_AqDoSendMsgReq)this.cmd).req).body).MsgContent, Integer.valueOf(((AqDoSendMsgReq)((IDIPPacket_AqDoSendMsgReq)((IDIPCmd_AqDoSendMsgReq)this.cmd).req).body).Source), ((AqDoSendMsgReq)((IDIPPacket_AqDoSendMsgReq)((IDIPCmd_AqDoSendMsgReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  46 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  50 */     if (((AqDoSendMsgReq)((IDIPPacket_AqDoSendMsgReq)((IDIPCmd_AqDoSendMsgReq)this.cmd).req).body).RoleId.length() > 32)
/*     */     {
/*  52 */       ((IDIPPacket_AqDoSendMsgRsp)((IDIPCmd_AqDoSendMsgReq)this.cmd).rsp).head.Result = (((AqDoSendMsgRsp)((IDIPPacket_AqDoSendMsgRsp)((IDIPCmd_AqDoSendMsgReq)this.cmd).rsp).body).Result = 1);
/*  53 */       ((IDIPPacket_AqDoSendMsgRsp)((IDIPCmd_AqDoSendMsgReq)this.cmd).rsp).head.RetErrMsg = (((AqDoSendMsgRsp)((IDIPPacket_AqDoSendMsgRsp)((IDIPCmd_AqDoSendMsgReq)this.cmd).rsp).body).RetMsg = String.format("roleid length > %d", new Object[] { Integer.valueOf(32) }));
/*     */       
/*  55 */       ((IDIPCmd_AqDoSendMsgReq)this.cmd).sendResponse();
/*     */       
/*  57 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoSendMsgReq.handle@roleId length > MAX_ROLEID_LEN|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|msg_content=%s|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoSendMsgRsp)((IDIPCmd_AqDoSendMsgReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoSendMsgRsp)((IDIPCmd_AqDoSendMsgReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((AqDoSendMsgReq)((IDIPPacket_AqDoSendMsgReq)((IDIPCmd_AqDoSendMsgReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoSendMsgReq)((IDIPPacket_AqDoSendMsgReq)((IDIPCmd_AqDoSendMsgReq)this.cmd).req).body).RoleId, ((AqDoSendMsgReq)((IDIPPacket_AqDoSendMsgReq)((IDIPCmd_AqDoSendMsgReq)this.cmd).req).body).MsgContent, Integer.valueOf(((AqDoSendMsgReq)((IDIPPacket_AqDoSendMsgReq)((IDIPCmd_AqDoSendMsgReq)this.cmd).req).body).Source), ((AqDoSendMsgReq)((IDIPPacket_AqDoSendMsgReq)((IDIPCmd_AqDoSendMsgReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  63 */       return false;
/*     */     }
/*     */     
/*  66 */     long roleId = -1L;
/*     */     try
/*     */     {
/*  69 */       roleId = Long.parseLong(((AqDoSendMsgReq)((IDIPPacket_AqDoSendMsgReq)((IDIPCmd_AqDoSendMsgReq)this.cmd).req).body).RoleId);
/*     */     }
/*     */     catch (NumberFormatException e)
/*     */     {
/*  73 */       ((IDIPPacket_AqDoSendMsgRsp)((IDIPCmd_AqDoSendMsgReq)this.cmd).rsp).head.Result = (((AqDoSendMsgRsp)((IDIPPacket_AqDoSendMsgRsp)((IDIPCmd_AqDoSendMsgReq)this.cmd).rsp).body).Result = 1);
/*  74 */       ((IDIPPacket_AqDoSendMsgRsp)((IDIPCmd_AqDoSendMsgReq)this.cmd).rsp).head.RetErrMsg = (((AqDoSendMsgRsp)((IDIPPacket_AqDoSendMsgRsp)((IDIPCmd_AqDoSendMsgReq)this.cmd).rsp).body).RetMsg = "roleid format error");
/*  75 */       ((IDIPCmd_AqDoSendMsgReq)this.cmd).sendResponse();
/*     */       
/*  77 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoSendMsgReq.handle@role not found|ret=%d|ret_msg=%s|user_id=%s|user_role_list=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|msg_content=%s|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoSendMsgRsp)((IDIPCmd_AqDoSendMsgReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoSendMsgRsp)((IDIPCmd_AqDoSendMsgReq)this.cmd).rsp).head.RetErrMsg, userId, xUser.getRoleids().toString(), Integer.valueOf(areaId), Byte.valueOf(((AqDoSendMsgReq)((IDIPPacket_AqDoSendMsgReq)((IDIPCmd_AqDoSendMsgReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoSendMsgReq)((IDIPPacket_AqDoSendMsgReq)((IDIPCmd_AqDoSendMsgReq)this.cmd).req).body).RoleId, ((AqDoSendMsgReq)((IDIPPacket_AqDoSendMsgReq)((IDIPCmd_AqDoSendMsgReq)this.cmd).req).body).MsgContent, Integer.valueOf(((AqDoSendMsgReq)((IDIPPacket_AqDoSendMsgReq)((IDIPCmd_AqDoSendMsgReq)this.cmd).req).body).Source), ((AqDoSendMsgReq)((IDIPPacket_AqDoSendMsgReq)((IDIPCmd_AqDoSendMsgReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  83 */       return false;
/*     */     }
/*     */     
/*  86 */     if ((!mzm.gsp.role.main.RoleInterface.isRoleExist(roleId, true)) || (!xUser.getRoleids().contains(Long.valueOf(roleId))))
/*     */     {
/*  88 */       ((IDIPPacket_AqDoSendMsgRsp)((IDIPCmd_AqDoSendMsgReq)this.cmd).rsp).head.Result = 1;
/*  89 */       ((IDIPPacket_AqDoSendMsgRsp)((IDIPCmd_AqDoSendMsgReq)this.cmd).rsp).head.RetErrMsg = "query roleid empty";
/*  90 */       ((IDIPCmd_AqDoSendMsgReq)this.cmd).sendResponse();
/*     */       
/*  92 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoSendMsgReq.handle@role not found|ret=%d|ret_msg=%s|user_id=%s|user_role_list=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|msg_content=%s|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoSendMsgRsp)((IDIPCmd_AqDoSendMsgReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoSendMsgRsp)((IDIPCmd_AqDoSendMsgReq)this.cmd).rsp).head.RetErrMsg, userId, xUser.getRoleids().toString(), Integer.valueOf(areaId), Byte.valueOf(((AqDoSendMsgReq)((IDIPPacket_AqDoSendMsgReq)((IDIPCmd_AqDoSendMsgReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoSendMsgReq)((IDIPPacket_AqDoSendMsgReq)((IDIPCmd_AqDoSendMsgReq)this.cmd).req).body).RoleId, ((AqDoSendMsgReq)((IDIPPacket_AqDoSendMsgReq)((IDIPCmd_AqDoSendMsgReq)this.cmd).req).body).MsgContent, Integer.valueOf(((AqDoSendMsgReq)((IDIPPacket_AqDoSendMsgReq)((IDIPCmd_AqDoSendMsgReq)this.cmd).req).body).Source), ((AqDoSendMsgReq)((IDIPPacket_AqDoSendMsgReq)((IDIPCmd_AqDoSendMsgReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  98 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 102 */     String msgContent = Utils.urlDecode1738(((AqDoSendMsgReq)((IDIPPacket_AqDoSendMsgReq)((IDIPCmd_AqDoSendMsgReq)this.cmd).req).body).MsgContent);
/* 103 */     if (msgContent.isEmpty())
/*     */     {
/* 105 */       ((IDIPPacket_AqDoSendMsgRsp)((IDIPCmd_AqDoSendMsgReq)this.cmd).rsp).head.Result = 64366;
/* 106 */       ((IDIPPacket_AqDoSendMsgRsp)((IDIPCmd_AqDoSendMsgReq)this.cmd).rsp).head.RetErrMsg = "MsgContent is empty";
/* 107 */       ((IDIPCmd_AqDoSendMsgReq)this.cmd).sendResponse();
/*     */       
/* 109 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoSendMsgReq.handle@MsgContent is empty|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|msg_content=%s|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoSendMsgRsp)((IDIPCmd_AqDoSendMsgReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoSendMsgRsp)((IDIPCmd_AqDoSendMsgReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((AqDoSendMsgReq)((IDIPPacket_AqDoSendMsgReq)((IDIPCmd_AqDoSendMsgReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoSendMsgReq)((IDIPPacket_AqDoSendMsgReq)((IDIPCmd_AqDoSendMsgReq)this.cmd).req).body).RoleId, ((AqDoSendMsgReq)((IDIPPacket_AqDoSendMsgReq)((IDIPCmd_AqDoSendMsgReq)this.cmd).req).body).MsgContent, Integer.valueOf(((AqDoSendMsgReq)((IDIPPacket_AqDoSendMsgReq)((IDIPCmd_AqDoSendMsgReq)this.cmd).req).body).Source), ((AqDoSendMsgReq)((IDIPPacket_AqDoSendMsgReq)((IDIPCmd_AqDoSendMsgReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 115 */       return false;
/*     */     }
/* 117 */     if (msgContent.length() > 256)
/*     */     {
/* 119 */       ((IDIPPacket_AqDoSendMsgRsp)((IDIPCmd_AqDoSendMsgReq)this.cmd).rsp).head.Result = 64366;
/* 120 */       ((IDIPPacket_AqDoSendMsgRsp)((IDIPCmd_AqDoSendMsgReq)this.cmd).rsp).head.RetErrMsg = String.format("MsgContent len > %d", new Object[] { Integer.valueOf(256) });
/* 121 */       ((IDIPCmd_AqDoSendMsgReq)this.cmd).sendResponse();
/*     */       
/* 123 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoSendMsgReq.handle@MsgContent length > MAX_MSGCONTENT_LEN|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|msg_content=%s|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoSendMsgRsp)((IDIPCmd_AqDoSendMsgReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoSendMsgRsp)((IDIPCmd_AqDoSendMsgReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((AqDoSendMsgReq)((IDIPPacket_AqDoSendMsgReq)((IDIPCmd_AqDoSendMsgReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoSendMsgReq)((IDIPPacket_AqDoSendMsgReq)((IDIPCmd_AqDoSendMsgReq)this.cmd).req).body).RoleId, ((AqDoSendMsgReq)((IDIPPacket_AqDoSendMsgReq)((IDIPCmd_AqDoSendMsgReq)this.cmd).req).body).MsgContent, Integer.valueOf(((AqDoSendMsgReq)((IDIPPacket_AqDoSendMsgReq)((IDIPCmd_AqDoSendMsgReq)this.cmd).req).body).Source), ((AqDoSendMsgReq)((IDIPPacket_AqDoSendMsgReq)((IDIPCmd_AqDoSendMsgReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 129 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 139 */     mzm.gsp.mail.main.MailAttachment mailAttachment = MailInterface.createMailAttachment();
/* 140 */     TLogArg tLogArg = new TLogArg(mzm.gsp.tlog.LogReason.IDIP_ADD);
/* 141 */     String title = "消息提示";
/* 142 */     SendMailRet sendMailRet = MailInterface.synBuildAndSendMail(roleId, 1, "消息提示", msgContent, mailAttachment, tLogArg);
/*     */     
/*     */ 
/* 145 */     if (!sendMailRet.isOK())
/*     */     {
/* 147 */       ((IDIPPacket_AqDoSendMsgRsp)((IDIPCmd_AqDoSendMsgReq)this.cmd).rsp).head.Result = sendMailRet.getRetEnum().ret;
/* 148 */       ((IDIPPacket_AqDoSendMsgRsp)((IDIPCmd_AqDoSendMsgReq)this.cmd).rsp).head.RetErrMsg = sendMailRet.getRetEnum().retMsg;
/* 149 */       ((IDIPCmd_AqDoSendMsgReq)this.cmd).sendResponse();
/*     */       
/* 151 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoSendMsgReq.handle@send msg by mail failed|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|msg_content=%s|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoSendMsgRsp)((IDIPCmd_AqDoSendMsgReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoSendMsgRsp)((IDIPCmd_AqDoSendMsgReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((AqDoSendMsgReq)((IDIPPacket_AqDoSendMsgReq)((IDIPCmd_AqDoSendMsgReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoSendMsgReq)((IDIPPacket_AqDoSendMsgReq)((IDIPCmd_AqDoSendMsgReq)this.cmd).req).body).RoleId, ((AqDoSendMsgReq)((IDIPPacket_AqDoSendMsgReq)((IDIPCmd_AqDoSendMsgReq)this.cmd).req).body).MsgContent, Integer.valueOf(((AqDoSendMsgReq)((IDIPPacket_AqDoSendMsgReq)((IDIPCmd_AqDoSendMsgReq)this.cmd).req).body).Source), ((AqDoSendMsgReq)((IDIPPacket_AqDoSendMsgReq)((IDIPCmd_AqDoSendMsgReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 157 */       return false;
/*     */     }
/*     */     
/* 160 */     ((AqDoSendMsgRsp)((IDIPPacket_AqDoSendMsgRsp)((IDIPCmd_AqDoSendMsgReq)this.cmd).rsp).body).Result = 0;
/* 161 */     ((AqDoSendMsgRsp)((IDIPPacket_AqDoSendMsgRsp)((IDIPCmd_AqDoSendMsgReq)this.cmd).rsp).body).RetMsg = "ok";
/* 162 */     ((IDIPCmd_AqDoSendMsgReq)this.cmd).sendResponse();
/*     */     
/* 164 */     StringBuilder logStr = new StringBuilder();
/* 165 */     logStr.append(((IDIPPacket_AqDoSendMsgReq)((IDIPCmd_AqDoSendMsgReq)this.cmd).req).head.SendTime).append("|");
/* 166 */     logStr.append(((AqDoSendMsgReq)((IDIPPacket_AqDoSendMsgReq)((IDIPCmd_AqDoSendMsgReq)this.cmd).req).body).OpenId).append("|");
/* 167 */     logStr.append(((AqDoSendMsgReq)((IDIPPacket_AqDoSendMsgReq)((IDIPCmd_AqDoSendMsgReq)this.cmd).req).body).AreaId).append("|");
/* 168 */     logStr.append(((AqDoSendMsgReq)((IDIPPacket_AqDoSendMsgReq)((IDIPCmd_AqDoSendMsgReq)this.cmd).req).body).Partition).append("|");
/* 169 */     logStr.append(roleId).append("|");
/* 170 */     logStr.append(0).append("|");
/* 171 */     logStr.append(((AqDoSendMsgReq)((IDIPPacket_AqDoSendMsgReq)((IDIPCmd_AqDoSendMsgReq)this.cmd).req).body).MsgContent).append("|");
/* 172 */     logStr.append(((IDIPPacket_AqDoSendMsgReq)((IDIPCmd_AqDoSendMsgReq)this.cmd).req).head.Cmdid).append("|");
/* 173 */     logStr.append(((AqDoSendMsgReq)((IDIPPacket_AqDoSendMsgReq)((IDIPCmd_AqDoSendMsgReq)this.cmd).req).body).Serial).append("|");
/* 174 */     logStr.append(((AqDoSendMsgReq)((IDIPPacket_AqDoSendMsgReq)((IDIPCmd_AqDoSendMsgReq)this.cmd).req).body).Source).append("|");
/* 175 */     logStr.append(((AqDoSendMsgRsp)((IDIPPacket_AqDoSendMsgRsp)((IDIPCmd_AqDoSendMsgReq)this.cmd).rsp).body).Result).append("|");
/* 176 */     logStr.append(((AqDoSendMsgRsp)((IDIPPacket_AqDoSendMsgRsp)((IDIPCmd_AqDoSendMsgReq)this.cmd).rsp).body).RetMsg);
/*     */     
/* 178 */     TLogManager.getInstance().addLog(roleId, "AqIDIPDoSendMsg", logStr.toString());
/*     */     
/* 180 */     GameServer.logger().info(String.format("[idip]PIDIPCmd_AqDoSendMsgReq.handle@send message done|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|msg_content=%s|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoSendMsgRsp)((IDIPCmd_AqDoSendMsgReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoSendMsgRsp)((IDIPCmd_AqDoSendMsgReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((AqDoSendMsgReq)((IDIPPacket_AqDoSendMsgReq)((IDIPCmd_AqDoSendMsgReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoSendMsgReq)((IDIPPacket_AqDoSendMsgReq)((IDIPCmd_AqDoSendMsgReq)this.cmd).req).body).RoleId, ((AqDoSendMsgReq)((IDIPPacket_AqDoSendMsgReq)((IDIPCmd_AqDoSendMsgReq)this.cmd).req).body).MsgContent, Integer.valueOf(((AqDoSendMsgReq)((IDIPPacket_AqDoSendMsgReq)((IDIPCmd_AqDoSendMsgReq)this.cmd).req).body).Source), ((AqDoSendMsgReq)((IDIPPacket_AqDoSendMsgReq)((IDIPCmd_AqDoSendMsgReq)this.cmd).req).body).Serial }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 186 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   protected String getSerialNo()
/*     */   {
/* 192 */     return ((AqDoSendMsgReq)((IDIPPacket_AqDoSendMsgReq)((IDIPCmd_AqDoSendMsgReq)this.cmd).req).body).Serial;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PIDIPCmd_AqDoSendMsgReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
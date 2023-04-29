/*     */ package mzm.gsp.idip.main;
/*     */ 
/*     */ import gnet.link.Onlines;
/*     */ import idip.AqDoBanUsrReq;
/*     */ import idip.AqDoBanUsrRsp;
/*     */ import idip.IDIPCmd_AqDoBanUsrReq;
/*     */ import idip.IDIPPacket_AqDoBanUsrReq;
/*     */ import idip.IDIPPacket_AqDoBanUsrRsp;
/*     */ import idip.core.IdipHeader;
/*     */ import idip.core.Utils;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.idip.SIdipBanRole;
/*     */ import mzm.gsp.online.main.ForbidInfoManager;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class PIDIPCmd_AqDoBanUsrReq extends PIDIPCmd<IDIPCmd_AqDoBanUsrReq>
/*     */ {
/*     */   public PIDIPCmd_AqDoBanUsrReq(IDIPCmd_AqDoBanUsrReq cmd)
/*     */   {
/*  25 */     super(cmd);
/*     */   }
/*     */   
/*     */   protected boolean handle()
/*     */     throws Exception
/*     */   {
/*  31 */     String openId = ((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).OpenId;
/*  32 */     int areaId = ((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).AreaId;
/*  33 */     int partition = ((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).Partition;
/*     */     
/*  35 */     String userId = Utils.getUserId(openId, areaId, partition);
/*  36 */     xbean.User xUser = xtable.User.get(userId);
/*  37 */     if (null == xUser)
/*     */     {
/*  39 */       ((IDIPPacket_AqDoBanUsrRsp)((IDIPCmd_AqDoBanUsrReq)this.cmd).rsp).head.Result = (((AqDoBanUsrRsp)((IDIPPacket_AqDoBanUsrRsp)((IDIPCmd_AqDoBanUsrReq)this.cmd).rsp).body).Result = 1);
/*  40 */       ((IDIPPacket_AqDoBanUsrRsp)((IDIPCmd_AqDoBanUsrReq)this.cmd).rsp).head.RetErrMsg = (((AqDoBanUsrRsp)((IDIPPacket_AqDoBanUsrRsp)((IDIPCmd_AqDoBanUsrReq)this.cmd).rsp).body).RetMsg = "query userid empty");
/*  41 */       ((IDIPCmd_AqDoBanUsrReq)this.cmd).sendResponse();
/*     */       
/*  43 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoBanUsrReq.handle@user not found|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|time=%d|reason=%s|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoBanUsrRsp)((IDIPCmd_AqDoBanUsrReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoBanUsrRsp)((IDIPCmd_AqDoBanUsrReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).RoleId, Integer.valueOf(((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).Time), ((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).Reason, Integer.valueOf(((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).Source), ((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  49 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  53 */     int time = ((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).Time;
/*  54 */     if (time <= 0)
/*     */     {
/*  56 */       ((IDIPPacket_AqDoBanUsrRsp)((IDIPCmd_AqDoBanUsrReq)this.cmd).rsp).head.Result = (((AqDoBanUsrRsp)((IDIPPacket_AqDoBanUsrRsp)((IDIPCmd_AqDoBanUsrReq)this.cmd).rsp).body).Result = '﮳');
/*  57 */       ((IDIPPacket_AqDoBanUsrRsp)((IDIPCmd_AqDoBanUsrReq)this.cmd).rsp).head.RetErrMsg = (((AqDoBanUsrRsp)((IDIPPacket_AqDoBanUsrRsp)((IDIPCmd_AqDoBanUsrReq)this.cmd).rsp).body).RetMsg = "time must > 0");
/*  58 */       ((IDIPCmd_AqDoBanUsrReq)this.cmd).sendResponse();
/*     */       
/*  60 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoBanUsrReq.handle@time must > 0|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|time=%d|reason=%s|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoBanUsrRsp)((IDIPCmd_AqDoBanUsrReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoBanUsrRsp)((IDIPCmd_AqDoBanUsrReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).RoleId, Integer.valueOf(((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).Time), ((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).Reason, Integer.valueOf(((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).Source), ((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  67 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  71 */     String reason = Utils.urlDecode1738(((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).Reason);
/*  72 */     if (reason.isEmpty())
/*     */     {
/*  74 */       ((IDIPPacket_AqDoBanUsrRsp)((IDIPCmd_AqDoBanUsrReq)this.cmd).rsp).head.Result = (((AqDoBanUsrRsp)((IDIPPacket_AqDoBanUsrRsp)((IDIPCmd_AqDoBanUsrReq)this.cmd).rsp).body).Result = '﮴');
/*  75 */       ((IDIPPacket_AqDoBanUsrRsp)((IDIPCmd_AqDoBanUsrReq)this.cmd).rsp).head.RetErrMsg = (((AqDoBanUsrRsp)((IDIPPacket_AqDoBanUsrRsp)((IDIPCmd_AqDoBanUsrReq)this.cmd).rsp).body).RetMsg = "ban reason is empty");
/*  76 */       ((IDIPCmd_AqDoBanUsrReq)this.cmd).sendResponse();
/*     */       
/*  78 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoBanUsrReq.handle@reason is empty|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|time=%d|reason=%s|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoBanUsrRsp)((IDIPCmd_AqDoBanUsrReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoBanUsrRsp)((IDIPCmd_AqDoBanUsrReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).RoleId, Integer.valueOf(((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).Time), ((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).Reason, Integer.valueOf(((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).Source), ((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  84 */       return false;
/*     */     }
/*  86 */     if (reason.length() > 256)
/*     */     {
/*  88 */       ((IDIPPacket_AqDoBanUsrRsp)((IDIPCmd_AqDoBanUsrReq)this.cmd).rsp).head.Result = (((AqDoBanUsrRsp)((IDIPPacket_AqDoBanUsrRsp)((IDIPCmd_AqDoBanUsrReq)this.cmd).rsp).body).Result = '﮴');
/*  89 */       ((IDIPPacket_AqDoBanUsrRsp)((IDIPCmd_AqDoBanUsrReq)this.cmd).rsp).head.RetErrMsg = (((AqDoBanUsrRsp)((IDIPPacket_AqDoBanUsrRsp)((IDIPCmd_AqDoBanUsrReq)this.cmd).rsp).body).RetMsg = String.format("ban reason len > %d", new Object[] { Integer.valueOf(256) }));
/*     */       
/*  91 */       ((IDIPCmd_AqDoBanUsrReq)this.cmd).sendResponse();
/*     */       
/*  93 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoBanUsrReq.handle@reason length > MAX_REASON_LEN|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|time=%d|reason=%s|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoBanUsrRsp)((IDIPCmd_AqDoBanUsrReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoBanUsrRsp)((IDIPCmd_AqDoBanUsrReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).RoleId, Integer.valueOf(((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).Time), ((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).Reason, Integer.valueOf(((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).Source), ((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  99 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 103 */     if (!((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).RoleId.isEmpty())
/*     */     {
/* 105 */       return banRole(xUser, reason);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 110 */     return banUser(userId, reason);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private boolean banRole(xbean.User xUser, String reason)
/*     */   {
/* 117 */     if (((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).RoleId.length() > 32)
/*     */     {
/* 119 */       ((IDIPPacket_AqDoBanUsrRsp)((IDIPCmd_AqDoBanUsrReq)this.cmd).rsp).head.Result = (((AqDoBanUsrRsp)((IDIPPacket_AqDoBanUsrRsp)((IDIPCmd_AqDoBanUsrReq)this.cmd).rsp).body).Result = 1);
/* 120 */       ((IDIPPacket_AqDoBanUsrRsp)((IDIPCmd_AqDoBanUsrReq)this.cmd).rsp).head.RetErrMsg = (((AqDoBanUsrRsp)((IDIPPacket_AqDoBanUsrRsp)((IDIPCmd_AqDoBanUsrReq)this.cmd).rsp).body).RetMsg = String.format("roleid length > %d", new Object[] { Integer.valueOf(32) }));
/*     */       
/* 122 */       ((IDIPCmd_AqDoBanUsrReq)this.cmd).sendResponse();
/*     */       
/* 124 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoBanUsrReq.banRole@roleId length > MAX_ROLEID_LEN|ret=%d|ret_msg=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|time=%d|reason=%s|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoBanUsrRsp)((IDIPCmd_AqDoBanUsrReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoBanUsrRsp)((IDIPCmd_AqDoBanUsrReq)this.cmd).rsp).head.RetErrMsg, Integer.valueOf(((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).AreaId), Byte.valueOf(((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).PlatId), Integer.valueOf(((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).Partition), ((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).OpenId, ((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).RoleId, Integer.valueOf(((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).Time), ((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).Reason, Integer.valueOf(((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).Source), ((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 131 */       return false;
/*     */     }
/*     */     
/* 134 */     long roleId = -1L;
/*     */     try
/*     */     {
/* 137 */       roleId = Long.parseLong(((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).RoleId);
/*     */     }
/*     */     catch (NumberFormatException e)
/*     */     {
/* 141 */       ((IDIPPacket_AqDoBanUsrRsp)((IDIPCmd_AqDoBanUsrReq)this.cmd).rsp).head.Result = (((AqDoBanUsrRsp)((IDIPPacket_AqDoBanUsrRsp)((IDIPCmd_AqDoBanUsrReq)this.cmd).rsp).body).Result = 1);
/* 142 */       ((IDIPPacket_AqDoBanUsrRsp)((IDIPCmd_AqDoBanUsrReq)this.cmd).rsp).head.RetErrMsg = (((AqDoBanUsrRsp)((IDIPPacket_AqDoBanUsrRsp)((IDIPCmd_AqDoBanUsrReq)this.cmd).rsp).body).RetMsg = "roleid format error");
/* 143 */       ((IDIPCmd_AqDoBanUsrReq)this.cmd).sendResponse();
/*     */       
/* 145 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoBanUsrReq.banRole@role not found|ret=%d|ret_msg=%s|user_role_list=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|time=%d|reason=%s|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoBanUsrRsp)((IDIPCmd_AqDoBanUsrReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoBanUsrRsp)((IDIPCmd_AqDoBanUsrReq)this.cmd).rsp).head.RetErrMsg, xUser.getRoleids().toString(), Integer.valueOf(((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).AreaId), Byte.valueOf(((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).PlatId), Integer.valueOf(((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).Partition), ((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).OpenId, ((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).RoleId, Integer.valueOf(((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).Time), ((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).Reason, Integer.valueOf(((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).Source), ((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 152 */       return false;
/*     */     }
/*     */     
/* 155 */     if ((!mzm.gsp.role.main.RoleInterface.isRoleExist(roleId, true)) || (!xUser.getRoleids().contains(Long.valueOf(roleId))))
/*     */     {
/* 157 */       ((IDIPPacket_AqDoBanUsrRsp)((IDIPCmd_AqDoBanUsrReq)this.cmd).rsp).head.Result = (((AqDoBanUsrRsp)((IDIPPacket_AqDoBanUsrRsp)((IDIPCmd_AqDoBanUsrReq)this.cmd).rsp).body).Result = 1);
/* 158 */       ((IDIPPacket_AqDoBanUsrRsp)((IDIPCmd_AqDoBanUsrReq)this.cmd).rsp).head.RetErrMsg = (((AqDoBanUsrRsp)((IDIPPacket_AqDoBanUsrRsp)((IDIPCmd_AqDoBanUsrReq)this.cmd).rsp).body).RetMsg = "query roleid empty");
/* 159 */       ((IDIPCmd_AqDoBanUsrReq)this.cmd).sendResponse();
/* 160 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoBanUsrReq.banRole@role not found or not match|ret=%d|ret_msg=%s|user_role_list=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|time=%d|reason=%s|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoBanUsrRsp)((IDIPCmd_AqDoBanUsrReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoBanUsrRsp)((IDIPCmd_AqDoBanUsrReq)this.cmd).rsp).head.RetErrMsg, xUser.getRoleids().toString(), Integer.valueOf(((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).AreaId), Byte.valueOf(((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).PlatId), Integer.valueOf(((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).Partition), ((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).OpenId, ((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).RoleId, Integer.valueOf(((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).Time), ((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).Reason, Integer.valueOf(((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).Source), ((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 167 */       return false;
/*     */     }
/*     */     
/* 170 */     if (OnlineManager.getInstance().isOnline(roleId))
/*     */     {
/*     */ 
/* 173 */       sendPromptMsg(roleId, ((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).Time, reason);
/*     */     }
/* 175 */     ForbidInfoManager.forbidRole(roleId, ((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).Time, reason);
/*     */     
/* 177 */     ((IDIPPacket_AqDoBanUsrRsp)((IDIPCmd_AqDoBanUsrReq)this.cmd).rsp).head.Result = (((AqDoBanUsrRsp)((IDIPPacket_AqDoBanUsrRsp)((IDIPCmd_AqDoBanUsrReq)this.cmd).rsp).body).Result = 0);
/* 178 */     ((IDIPPacket_AqDoBanUsrRsp)((IDIPCmd_AqDoBanUsrReq)this.cmd).rsp).head.RetErrMsg = (((AqDoBanUsrRsp)((IDIPPacket_AqDoBanUsrRsp)((IDIPCmd_AqDoBanUsrReq)this.cmd).rsp).body).RetMsg = "ok");
/* 179 */     ((IDIPCmd_AqDoBanUsrReq)this.cmd).sendResponse();
/*     */     
/* 181 */     StringBuilder logStr = new StringBuilder();
/* 182 */     logStr.append(((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).head.SendTime).append("|");
/* 183 */     logStr.append(((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).OpenId).append("|");
/* 184 */     logStr.append(((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).AreaId).append("|");
/* 185 */     logStr.append(((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).Partition).append("|");
/* 186 */     logStr.append(roleId).append("|");
/* 187 */     logStr.append(0).append("|");
/* 188 */     logStr.append(((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).Time).append("|");
/* 189 */     logStr.append(reason).append("|");
/* 190 */     logStr.append(((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).head.Cmdid).append("|");
/* 191 */     logStr.append(((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).Serial).append("|");
/* 192 */     logStr.append(((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).Source).append("|");
/* 193 */     logStr.append(((AqDoBanUsrRsp)((IDIPPacket_AqDoBanUsrRsp)((IDIPCmd_AqDoBanUsrReq)this.cmd).rsp).body).Result).append("|");
/* 194 */     logStr.append(((AqDoBanUsrRsp)((IDIPPacket_AqDoBanUsrRsp)((IDIPCmd_AqDoBanUsrReq)this.cmd).rsp).body).RetMsg);
/*     */     
/* 196 */     TLogManager.getInstance().addLog(roleId, "AqIDIPDoBanUsr", logStr.toString());
/*     */     
/* 198 */     GameServer.logger().info(String.format("[idip]PIDIPCmd_AqDoBanUsrReq.banRole@ban role success|ret=%d|ret_msg=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|time=%d|reason=%s|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoBanUsrRsp)((IDIPCmd_AqDoBanUsrReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoBanUsrRsp)((IDIPCmd_AqDoBanUsrReq)this.cmd).rsp).head.RetErrMsg, Integer.valueOf(((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).AreaId), Byte.valueOf(((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).PlatId), Integer.valueOf(((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).Partition), ((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).OpenId, ((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).RoleId, Integer.valueOf(((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).Time), ((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).Reason, Integer.valueOf(((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).Source), ((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).Serial }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 205 */     return true;
/*     */   }
/*     */   
/*     */   private void sendPromptMsg(long roleId, long time, String reason)
/*     */   {
/* 210 */     SIdipBanRole banRoleMsg = new SIdipBanRole();
/* 211 */     banRoleMsg.unbantime = (DateTimeUtils.getCurrTimeInMillis() / 1000L + time);
/*     */     try
/*     */     {
/* 214 */       banRoleMsg.reason.setString(reason, "UTF-8");
/*     */     }
/*     */     catch (UnsupportedEncodingException e) {}
/*     */     
/*     */ 
/*     */ 
/* 220 */     OnlineManager.getInstance().sendAtOnce(roleId, banRoleMsg);
/*     */   }
/*     */   
/*     */   private boolean banUser(String userId, String reason)
/*     */   {
/* 225 */     Long roleId = Onlines.getInstance().getRoleid(userId);
/* 226 */     if (roleId != null)
/*     */     {
/*     */ 
/* 229 */       sendPromptMsg(roleId.longValue(), ((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).Time, reason);
/*     */     }
/* 231 */     ForbidInfoManager.forbidUser(userId, ((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).Time, reason);
/*     */     
/* 233 */     ((IDIPPacket_AqDoBanUsrRsp)((IDIPCmd_AqDoBanUsrReq)this.cmd).rsp).head.Result = (((AqDoBanUsrRsp)((IDIPPacket_AqDoBanUsrRsp)((IDIPCmd_AqDoBanUsrReq)this.cmd).rsp).body).Result = 0);
/* 234 */     ((IDIPPacket_AqDoBanUsrRsp)((IDIPCmd_AqDoBanUsrReq)this.cmd).rsp).head.RetErrMsg = (((AqDoBanUsrRsp)((IDIPPacket_AqDoBanUsrRsp)((IDIPCmd_AqDoBanUsrReq)this.cmd).rsp).body).RetMsg = "ok");
/* 235 */     ((IDIPCmd_AqDoBanUsrReq)this.cmd).sendResponse();
/*     */     
/* 237 */     StringBuilder logStr = new StringBuilder();
/* 238 */     logStr.append(((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).head.SendTime).append("|");
/* 239 */     logStr.append(((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).OpenId).append("|");
/* 240 */     logStr.append(((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).AreaId).append("|");
/* 241 */     logStr.append(((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).Partition).append("|");
/* 242 */     logStr.append(0).append("|");
/* 243 */     logStr.append(0).append("|");
/* 244 */     logStr.append(((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).Time).append("|");
/* 245 */     logStr.append(reason).append("|");
/* 246 */     logStr.append(((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).head.Cmdid).append("|");
/* 247 */     logStr.append(((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).Serial).append("|");
/* 248 */     logStr.append(((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).Source).append("|");
/* 249 */     logStr.append(((AqDoBanUsrRsp)((IDIPPacket_AqDoBanUsrRsp)((IDIPCmd_AqDoBanUsrReq)this.cmd).rsp).body).Result).append("|");
/* 250 */     logStr.append(((AqDoBanUsrRsp)((IDIPPacket_AqDoBanUsrRsp)((IDIPCmd_AqDoBanUsrReq)this.cmd).rsp).body).RetMsg);
/*     */     
/* 252 */     TLogManager.getInstance().addLog(QingfuInterface.getSuitableRoleId(userId), "AqIDIPDoBanUsr", logStr.toString());
/*     */     
/*     */ 
/* 255 */     GameServer.logger().info(String.format("[idip]PIDIPCmd_AqDoBanUsrReq.banUser@ban user success|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|time=%d|reason=%s|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoBanUsrRsp)((IDIPCmd_AqDoBanUsrReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoBanUsrRsp)((IDIPCmd_AqDoBanUsrReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).AreaId), Byte.valueOf(((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).PlatId), Integer.valueOf(((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).Partition), ((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).OpenId, ((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).RoleId, Integer.valueOf(((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).Time), ((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).Reason, Integer.valueOf(((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).Source), ((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).Serial }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 262 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   protected String getSerialNo()
/*     */   {
/* 268 */     return ((AqDoBanUsrReq)((IDIPPacket_AqDoBanUsrReq)((IDIPCmd_AqDoBanUsrReq)this.cmd).req).body).Serial;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PIDIPCmd_AqDoBanUsrReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
/*     */ package mzm.gsp.idip.main;
/*     */ 
/*     */ import idip.DoDelMailReq;
/*     */ import idip.DoDelMailRsp;
/*     */ import idip.IDIPCmd_DoDelMailReq;
/*     */ import idip.IDIPPacket_DoDelMailReq;
/*     */ import idip.IDIPPacket_DoDelMailRsp;
/*     */ import idip.core.IdipHeader;
/*     */ import mzm.gsp.GameServer;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class PIDIPCmd_DoDelMailReq extends PIDIPCmd<IDIPCmd_DoDelMailReq>
/*     */ {
/*     */   public PIDIPCmd_DoDelMailReq(IDIPCmd_DoDelMailReq cmd)
/*     */   {
/*  16 */     super(cmd);
/*     */   }
/*     */   
/*     */   protected boolean handle()
/*     */     throws Exception
/*     */   {
/*  22 */     String openId = ((DoDelMailReq)((IDIPPacket_DoDelMailReq)((IDIPCmd_DoDelMailReq)this.cmd).req).body).OpenId;
/*  23 */     int areaId = ((DoDelMailReq)((IDIPPacket_DoDelMailReq)((IDIPCmd_DoDelMailReq)this.cmd).req).body).AreaId;
/*  24 */     int partition = ((DoDelMailReq)((IDIPPacket_DoDelMailReq)((IDIPCmd_DoDelMailReq)this.cmd).req).body).Partition;
/*     */     
/*  26 */     String userId = idip.core.Utils.getUserId(openId, areaId, partition);
/*  27 */     xbean.User xUser = xtable.User.get(userId);
/*  28 */     if (null == xUser)
/*     */     {
/*  30 */       ((IDIPPacket_DoDelMailRsp)((IDIPCmd_DoDelMailReq)this.cmd).rsp).head.Result = (((DoDelMailRsp)((IDIPPacket_DoDelMailRsp)((IDIPCmd_DoDelMailReq)this.cmd).rsp).body).Result = 1);
/*  31 */       ((IDIPPacket_DoDelMailRsp)((IDIPCmd_DoDelMailReq)this.cmd).rsp).head.RetErrMsg = (((DoDelMailRsp)((IDIPPacket_DoDelMailRsp)((IDIPCmd_DoDelMailReq)this.cmd).rsp).body).RetMsg = "query userid empty");
/*  32 */       ((IDIPCmd_DoDelMailReq)this.cmd).sendResponse();
/*     */       
/*  34 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoDelMailReq.handle@user not found|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|tagid=%s|mailid=%d", new Object[] { Integer.valueOf(((IDIPPacket_DoDelMailRsp)((IDIPCmd_DoDelMailReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoDelMailRsp)((IDIPCmd_DoDelMailReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((DoDelMailReq)((IDIPPacket_DoDelMailReq)((IDIPCmd_DoDelMailReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((DoDelMailReq)((IDIPPacket_DoDelMailReq)((IDIPCmd_DoDelMailReq)this.cmd).req).body).RoleId, ((DoDelMailReq)((IDIPPacket_DoDelMailReq)((IDIPCmd_DoDelMailReq)this.cmd).req).body).TagId, Integer.valueOf(((DoDelMailReq)((IDIPPacket_DoDelMailReq)((IDIPCmd_DoDelMailReq)this.cmd).req).body).MailId) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  39 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  43 */     if (((DoDelMailReq)((IDIPPacket_DoDelMailReq)((IDIPCmd_DoDelMailReq)this.cmd).req).body).RoleId.length() > 32)
/*     */     {
/*  45 */       ((IDIPPacket_DoDelMailRsp)((IDIPCmd_DoDelMailReq)this.cmd).rsp).head.Result = (((DoDelMailRsp)((IDIPPacket_DoDelMailRsp)((IDIPCmd_DoDelMailReq)this.cmd).rsp).body).Result = 1);
/*  46 */       ((IDIPPacket_DoDelMailRsp)((IDIPCmd_DoDelMailReq)this.cmd).rsp).head.RetErrMsg = (((DoDelMailRsp)((IDIPPacket_DoDelMailRsp)((IDIPCmd_DoDelMailReq)this.cmd).rsp).body).RetMsg = String.format("roleid length > %d", new Object[] { Integer.valueOf(32) }));
/*     */       
/*  48 */       ((IDIPCmd_DoDelMailReq)this.cmd).sendResponse();
/*     */       
/*  50 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoDelMailReq.handle@roleId length > MAX_ROLEID_LEN|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|tagid=%s|mailid=%d", new Object[] { Integer.valueOf(((IDIPPacket_DoDelMailRsp)((IDIPCmd_DoDelMailReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoDelMailRsp)((IDIPCmd_DoDelMailReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((DoDelMailReq)((IDIPPacket_DoDelMailReq)((IDIPCmd_DoDelMailReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((DoDelMailReq)((IDIPPacket_DoDelMailReq)((IDIPCmd_DoDelMailReq)this.cmd).req).body).RoleId, ((DoDelMailReq)((IDIPPacket_DoDelMailReq)((IDIPCmd_DoDelMailReq)this.cmd).req).body).TagId, Integer.valueOf(((DoDelMailReq)((IDIPPacket_DoDelMailReq)((IDIPCmd_DoDelMailReq)this.cmd).req).body).MailId) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  55 */       return false;
/*     */     }
/*     */     
/*  58 */     long roleid = -1L;
/*     */     try
/*     */     {
/*  61 */       roleid = Long.parseLong(((DoDelMailReq)((IDIPPacket_DoDelMailReq)((IDIPCmd_DoDelMailReq)this.cmd).req).body).RoleId);
/*     */     }
/*     */     catch (NumberFormatException e)
/*     */     {
/*  65 */       ((IDIPPacket_DoDelMailRsp)((IDIPCmd_DoDelMailReq)this.cmd).rsp).head.Result = (((DoDelMailRsp)((IDIPPacket_DoDelMailRsp)((IDIPCmd_DoDelMailReq)this.cmd).rsp).body).Result = 1);
/*  66 */       ((IDIPPacket_DoDelMailRsp)((IDIPCmd_DoDelMailReq)this.cmd).rsp).head.RetErrMsg = (((DoDelMailRsp)((IDIPPacket_DoDelMailRsp)((IDIPCmd_DoDelMailReq)this.cmd).rsp).body).RetMsg = "roleid format error");
/*  67 */       ((IDIPCmd_DoDelMailReq)this.cmd).sendResponse();
/*     */       
/*  69 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoDelMailReq.handle@role not found|ret=%d|ret_msg=%s|user_id=%s|user_role_list=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|tagid=%s|mailid=%d", new Object[] { Integer.valueOf(((IDIPPacket_DoDelMailRsp)((IDIPCmd_DoDelMailReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoDelMailRsp)((IDIPCmd_DoDelMailReq)this.cmd).rsp).head.RetErrMsg, userId, xUser.getRoleids().toString(), Integer.valueOf(areaId), Byte.valueOf(((DoDelMailReq)((IDIPPacket_DoDelMailReq)((IDIPCmd_DoDelMailReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((DoDelMailReq)((IDIPPacket_DoDelMailReq)((IDIPCmd_DoDelMailReq)this.cmd).req).body).RoleId, ((DoDelMailReq)((IDIPPacket_DoDelMailReq)((IDIPCmd_DoDelMailReq)this.cmd).req).body).TagId, Integer.valueOf(((DoDelMailReq)((IDIPPacket_DoDelMailReq)((IDIPCmd_DoDelMailReq)this.cmd).req).body).MailId) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  75 */       return false;
/*     */     }
/*     */     
/*  78 */     if ((!mzm.gsp.role.main.RoleInterface.isRoleExist(roleid, true)) || (!xUser.getRoleids().contains(Long.valueOf(roleid))))
/*     */     {
/*  80 */       ((IDIPPacket_DoDelMailRsp)((IDIPCmd_DoDelMailReq)this.cmd).rsp).head.Result = (((DoDelMailRsp)((IDIPPacket_DoDelMailRsp)((IDIPCmd_DoDelMailReq)this.cmd).rsp).body).Result = 1);
/*  81 */       ((IDIPPacket_DoDelMailRsp)((IDIPCmd_DoDelMailReq)this.cmd).rsp).head.RetErrMsg = (((DoDelMailRsp)((IDIPPacket_DoDelMailRsp)((IDIPCmd_DoDelMailReq)this.cmd).rsp).body).RetMsg = "query roleid empty");
/*  82 */       ((IDIPCmd_DoDelMailReq)this.cmd).sendResponse();
/*     */       
/*  84 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoDelMailReq.handle@role not found|ret=%d|ret_msg=%s|user_id=%s|user_role_list=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|tagid=%s|mailid=%d", new Object[] { Integer.valueOf(((IDIPPacket_DoDelMailRsp)((IDIPCmd_DoDelMailReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoDelMailRsp)((IDIPCmd_DoDelMailReq)this.cmd).rsp).head.RetErrMsg, userId, xUser.getRoleids().toString(), Integer.valueOf(areaId), Byte.valueOf(((DoDelMailReq)((IDIPPacket_DoDelMailReq)((IDIPCmd_DoDelMailReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((DoDelMailReq)((IDIPPacket_DoDelMailReq)((IDIPCmd_DoDelMailReq)this.cmd).req).body).RoleId, ((DoDelMailReq)((IDIPPacket_DoDelMailReq)((IDIPCmd_DoDelMailReq)this.cmd).req).body).TagId, Integer.valueOf(((DoDelMailReq)((IDIPPacket_DoDelMailReq)((IDIPCmd_DoDelMailReq)this.cmd).req).body).MailId) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  90 */       return false;
/*     */     }
/*     */     
/*  93 */     String tagid = ((DoDelMailReq)((IDIPPacket_DoDelMailReq)((IDIPCmd_DoDelMailReq)this.cmd).req).body).TagId;
/*  94 */     int mailid = ((DoDelMailReq)((IDIPPacket_DoDelMailReq)((IDIPCmd_DoDelMailReq)this.cmd).req).body).MailId;
/*  95 */     if ((tagid.isEmpty()) && (mailid <= 0))
/*     */     {
/*  97 */       ((IDIPPacket_DoDelMailRsp)((IDIPCmd_DoDelMailReq)this.cmd).rsp).head.Result = (((DoDelMailRsp)((IDIPPacket_DoDelMailRsp)((IDIPCmd_DoDelMailReq)this.cmd).rsp).body).Result = '社');
/*  98 */       ((IDIPPacket_DoDelMailRsp)((IDIPCmd_DoDelMailReq)this.cmd).rsp).head.RetErrMsg = (((DoDelMailRsp)((IDIPPacket_DoDelMailRsp)((IDIPCmd_DoDelMailReq)this.cmd).rsp).body).RetMsg = "params invalid");
/*  99 */       ((IDIPCmd_DoDelMailReq)this.cmd).sendResponse();
/*     */       
/* 101 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoDelMailReq.handle@params invalid|ret=%d|ret_msg=%s|user_id=%s|user_role_list=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|tagid=%s|mailid=%d", new Object[] { Integer.valueOf(((IDIPPacket_DoDelMailRsp)((IDIPCmd_DoDelMailReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoDelMailRsp)((IDIPCmd_DoDelMailReq)this.cmd).rsp).head.RetErrMsg, userId, xUser.getRoleids().toString(), Integer.valueOf(areaId), Byte.valueOf(((DoDelMailReq)((IDIPPacket_DoDelMailReq)((IDIPCmd_DoDelMailReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((DoDelMailReq)((IDIPPacket_DoDelMailReq)((IDIPCmd_DoDelMailReq)this.cmd).req).body).RoleId, ((DoDelMailReq)((IDIPPacket_DoDelMailReq)((IDIPCmd_DoDelMailReq)this.cmd).req).body).TagId, Integer.valueOf(((DoDelMailReq)((IDIPPacket_DoDelMailReq)((IDIPCmd_DoDelMailReq)this.cmd).req).body).MailId) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 107 */       return false;
/*     */     }
/*     */     
/* 110 */     if (!mzm.gsp.mail.main.MailInterface.delMailForIdip(roleid, mailid, tagid))
/*     */     {
/* 112 */       ((IDIPPacket_DoDelMailRsp)((IDIPCmd_DoDelMailReq)this.cmd).rsp).head.Result = (((DoDelMailRsp)((IDIPPacket_DoDelMailRsp)((IDIPCmd_DoDelMailReq)this.cmd).rsp).body).Result = '碑');
/* 113 */       ((IDIPPacket_DoDelMailRsp)((IDIPCmd_DoDelMailReq)this.cmd).rsp).head.RetErrMsg = (((DoDelMailRsp)((IDIPPacket_DoDelMailRsp)((IDIPCmd_DoDelMailReq)this.cmd).rsp).body).RetMsg = "failed");
/* 114 */       ((IDIPCmd_DoDelMailReq)this.cmd).sendResponse();
/*     */       
/* 116 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoDelMailReq.handle@del failed|ret=%d|ret_msg=%s|user_id=%s|user_role_list=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|tagid=%s|mailid=%d", new Object[] { Integer.valueOf(((IDIPPacket_DoDelMailRsp)((IDIPCmd_DoDelMailReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoDelMailRsp)((IDIPCmd_DoDelMailReq)this.cmd).rsp).head.RetErrMsg, userId, xUser.getRoleids().toString(), Integer.valueOf(areaId), Byte.valueOf(((DoDelMailReq)((IDIPPacket_DoDelMailReq)((IDIPCmd_DoDelMailReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((DoDelMailReq)((IDIPPacket_DoDelMailReq)((IDIPCmd_DoDelMailReq)this.cmd).req).body).RoleId, tagid, Integer.valueOf(mailid) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 121 */       return false;
/*     */     }
/*     */     
/* 124 */     ((IDIPPacket_DoDelMailRsp)((IDIPCmd_DoDelMailReq)this.cmd).rsp).head.Result = (((DoDelMailRsp)((IDIPPacket_DoDelMailRsp)((IDIPCmd_DoDelMailReq)this.cmd).rsp).body).Result = 0);
/* 125 */     ((IDIPPacket_DoDelMailRsp)((IDIPCmd_DoDelMailReq)this.cmd).rsp).head.RetErrMsg = (((DoDelMailRsp)((IDIPPacket_DoDelMailRsp)((IDIPCmd_DoDelMailReq)this.cmd).rsp).body).RetMsg = "ok");
/* 126 */     ((IDIPCmd_DoDelMailReq)this.cmd).sendResponse();
/*     */     
/*     */ 
/* 129 */     StringBuilder logStr = new StringBuilder();
/* 130 */     logStr.append(((IDIPPacket_DoDelMailReq)((IDIPCmd_DoDelMailReq)this.cmd).req).head.SendTime).append("|");
/* 131 */     logStr.append(((DoDelMailReq)((IDIPPacket_DoDelMailReq)((IDIPCmd_DoDelMailReq)this.cmd).req).body).OpenId).append("|");
/* 132 */     logStr.append(((DoDelMailReq)((IDIPPacket_DoDelMailReq)((IDIPCmd_DoDelMailReq)this.cmd).req).body).AreaId).append("|");
/* 133 */     logStr.append(((DoDelMailReq)((IDIPPacket_DoDelMailReq)((IDIPCmd_DoDelMailReq)this.cmd).req).body).Partition).append("|");
/* 134 */     logStr.append(((IDIPPacket_DoDelMailReq)((IDIPCmd_DoDelMailReq)this.cmd).req).head.Cmdid).append("|");
/* 135 */     logStr.append(mailid).append("|");
/* 136 */     logStr.append(tagid).append("|");
/* 137 */     logStr.append(roleid);
/* 138 */     mzm.gsp.tlog.TLogManager.getInstance().addLog(roleid, "IDIPDoDelMailForServer", logStr.toString());
/*     */     
/* 140 */     GameServer.logger().info(String.format("[idip]PIDIPCmd_DoDelMailReq.handle@del mail done|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|tagid=%s|mailid=%d", new Object[] { Integer.valueOf(((IDIPPacket_DoDelMailRsp)((IDIPCmd_DoDelMailReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoDelMailRsp)((IDIPCmd_DoDelMailReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((DoDelMailReq)((IDIPPacket_DoDelMailReq)((IDIPCmd_DoDelMailReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((DoDelMailReq)((IDIPPacket_DoDelMailReq)((IDIPCmd_DoDelMailReq)this.cmd).req).body).RoleId, tagid, Integer.valueOf(mailid) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 146 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PIDIPCmd_DoDelMailReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
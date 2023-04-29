/*     */ package mzm.gsp.idip.main;
/*     */ 
/*     */ import idip.AqDoBanAddFriendReq;
/*     */ import idip.AqDoBanAddFriendRsp;
/*     */ import idip.IDIPCmd_AqDoBanAddFriendReq;
/*     */ import idip.IDIPPacket_AqDoBanAddFriendReq;
/*     */ import idip.IDIPPacket_AqDoBanAddFriendRsp;
/*     */ import idip.core.IdipHeader;
/*     */ import mzm.gsp.GameServer;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class PIDIPCmd_AqDoBanAddFriendReq extends PIDIPCmd<IDIPCmd_AqDoBanAddFriendReq>
/*     */ {
/*     */   public PIDIPCmd_AqDoBanAddFriendReq(IDIPCmd_AqDoBanAddFriendReq cmd)
/*     */   {
/*  16 */     super(cmd);
/*     */   }
/*     */   
/*     */   protected boolean handle()
/*     */     throws Exception
/*     */   {
/*  22 */     String openId = ((AqDoBanAddFriendReq)((IDIPPacket_AqDoBanAddFriendReq)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).req).body).OpenId;
/*  23 */     int areaId = ((AqDoBanAddFriendReq)((IDIPPacket_AqDoBanAddFriendReq)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).req).body).AreaId;
/*  24 */     int partition = ((AqDoBanAddFriendReq)((IDIPPacket_AqDoBanAddFriendReq)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).req).body).Partition;
/*     */     
/*  26 */     String userId = idip.core.Utils.getUserId(openId, areaId, partition);
/*  27 */     xbean.User xUser = xtable.User.get(userId);
/*  28 */     if (null == xUser)
/*     */     {
/*  30 */       ((IDIPPacket_AqDoBanAddFriendRsp)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).rsp).head.Result = (((AqDoBanAddFriendRsp)((IDIPPacket_AqDoBanAddFriendRsp)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).rsp).body).Result = 1);
/*  31 */       ((IDIPPacket_AqDoBanAddFriendRsp)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).rsp).head.RetErrMsg = (((AqDoBanAddFriendRsp)((IDIPPacket_AqDoBanAddFriendRsp)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).rsp).body).RetMsg = "query userid empty");
/*  32 */       ((IDIPCmd_AqDoBanAddFriendReq)this.cmd).sendResponse();
/*     */       
/*  34 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoBanAddFriendReq.handle@user not found|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|time=%d|reason=%s|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoBanAddFriendRsp)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoBanAddFriendRsp)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((AqDoBanAddFriendReq)((IDIPPacket_AqDoBanAddFriendReq)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoBanAddFriendReq)((IDIPPacket_AqDoBanAddFriendReq)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).req).body).RoleId, Integer.valueOf(((AqDoBanAddFriendReq)((IDIPPacket_AqDoBanAddFriendReq)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).req).body).Time), ((AqDoBanAddFriendReq)((IDIPPacket_AqDoBanAddFriendReq)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).req).body).Reason, Integer.valueOf(((AqDoBanAddFriendReq)((IDIPPacket_AqDoBanAddFriendReq)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).req).body).Source), ((AqDoBanAddFriendReq)((IDIPPacket_AqDoBanAddFriendReq)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  40 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  44 */     if (((AqDoBanAddFriendReq)((IDIPPacket_AqDoBanAddFriendReq)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).req).body).RoleId.length() > 32)
/*     */     {
/*  46 */       ((IDIPPacket_AqDoBanAddFriendRsp)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).rsp).head.Result = (((AqDoBanAddFriendRsp)((IDIPPacket_AqDoBanAddFriendRsp)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).rsp).body).Result = 1);
/*  47 */       ((IDIPPacket_AqDoBanAddFriendRsp)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).rsp).head.RetErrMsg = (((AqDoBanAddFriendRsp)((IDIPPacket_AqDoBanAddFriendRsp)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).rsp).body).RetMsg = String.format("roleid length > %d", new Object[] { Integer.valueOf(32) }));
/*     */       
/*  49 */       ((IDIPCmd_AqDoBanAddFriendReq)this.cmd).sendResponse();
/*     */       
/*  51 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoBanAddFriendReq.handle@roleId length > MAX_ROLEID_LEN|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|time=%d|reason=%s|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoBanAddFriendRsp)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoBanAddFriendRsp)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((AqDoBanAddFriendReq)((IDIPPacket_AqDoBanAddFriendReq)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoBanAddFriendReq)((IDIPPacket_AqDoBanAddFriendReq)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).req).body).RoleId, Integer.valueOf(((AqDoBanAddFriendReq)((IDIPPacket_AqDoBanAddFriendReq)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).req).body).Time), ((AqDoBanAddFriendReq)((IDIPPacket_AqDoBanAddFriendReq)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).req).body).Reason, Integer.valueOf(((AqDoBanAddFriendReq)((IDIPPacket_AqDoBanAddFriendReq)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).req).body).Source), ((AqDoBanAddFriendReq)((IDIPPacket_AqDoBanAddFriendReq)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  57 */       return false;
/*     */     }
/*     */     
/*  60 */     long roleId = -1L;
/*     */     try
/*     */     {
/*  63 */       roleId = Long.parseLong(((AqDoBanAddFriendReq)((IDIPPacket_AqDoBanAddFriendReq)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).req).body).RoleId);
/*     */     }
/*     */     catch (NumberFormatException e)
/*     */     {
/*  67 */       ((IDIPPacket_AqDoBanAddFriendRsp)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).rsp).head.Result = (((AqDoBanAddFriendRsp)((IDIPPacket_AqDoBanAddFriendRsp)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).rsp).body).Result = 1);
/*  68 */       ((IDIPPacket_AqDoBanAddFriendRsp)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).rsp).head.RetErrMsg = (((AqDoBanAddFriendRsp)((IDIPPacket_AqDoBanAddFriendRsp)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).rsp).body).RetMsg = "roleid format error");
/*  69 */       ((IDIPCmd_AqDoBanAddFriendReq)this.cmd).sendResponse();
/*     */       
/*  71 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoBanAddFriendReq.handle@role not found|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|time=%d|reason=%s|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoBanAddFriendRsp)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoBanAddFriendRsp)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((AqDoBanAddFriendReq)((IDIPPacket_AqDoBanAddFriendReq)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoBanAddFriendReq)((IDIPPacket_AqDoBanAddFriendReq)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).req).body).RoleId, Integer.valueOf(((AqDoBanAddFriendReq)((IDIPPacket_AqDoBanAddFriendReq)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).req).body).Time), ((AqDoBanAddFriendReq)((IDIPPacket_AqDoBanAddFriendReq)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).req).body).Reason, Integer.valueOf(((AqDoBanAddFriendReq)((IDIPPacket_AqDoBanAddFriendReq)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).req).body).Source), ((AqDoBanAddFriendReq)((IDIPPacket_AqDoBanAddFriendReq)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  77 */       return false;
/*     */     }
/*     */     
/*  80 */     if (roleId != 0L)
/*     */     {
/*  82 */       if ((!mzm.gsp.role.main.RoleInterface.isRoleExist(roleId, true)) || (!xUser.getRoleids().contains(Long.valueOf(roleId))))
/*     */       {
/*  84 */         ((IDIPPacket_AqDoBanAddFriendRsp)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).rsp).head.Result = (((AqDoBanAddFriendRsp)((IDIPPacket_AqDoBanAddFriendRsp)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).rsp).body).Result = 1);
/*  85 */         ((IDIPPacket_AqDoBanAddFriendRsp)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).rsp).head.RetErrMsg = (((AqDoBanAddFriendRsp)((IDIPPacket_AqDoBanAddFriendRsp)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).rsp).body).RetMsg = "query roleid empty");
/*  86 */         ((IDIPCmd_AqDoBanAddFriendReq)this.cmd).sendResponse();
/*     */         
/*  88 */         GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoBanAddFriendReq.handle@role not found|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|time=%d|reason=%s|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoBanAddFriendRsp)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoBanAddFriendRsp)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((AqDoBanAddFriendReq)((IDIPPacket_AqDoBanAddFriendReq)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoBanAddFriendReq)((IDIPPacket_AqDoBanAddFriendReq)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).req).body).RoleId, Integer.valueOf(((AqDoBanAddFriendReq)((IDIPPacket_AqDoBanAddFriendReq)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).req).body).Time), ((AqDoBanAddFriendReq)((IDIPPacket_AqDoBanAddFriendReq)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).req).body).Reason, Integer.valueOf(((AqDoBanAddFriendReq)((IDIPPacket_AqDoBanAddFriendReq)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).req).body).Source), ((AqDoBanAddFriendReq)((IDIPPacket_AqDoBanAddFriendReq)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).req).body).Serial }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  94 */         return false;
/*     */       }
/*     */     }
/*     */     
/*  98 */     int time = ((AqDoBanAddFriendReq)((IDIPPacket_AqDoBanAddFriendReq)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).req).body).Time;
/*  99 */     if (time <= 0)
/*     */     {
/* 101 */       ((IDIPPacket_AqDoBanAddFriendRsp)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).rsp).head.Result = (((AqDoBanAddFriendRsp)((IDIPPacket_AqDoBanAddFriendRsp)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).rsp).body).Result = 'ﬔ');
/* 102 */       ((IDIPPacket_AqDoBanAddFriendRsp)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).rsp).head.RetErrMsg = (((AqDoBanAddFriendRsp)((IDIPPacket_AqDoBanAddFriendRsp)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).rsp).body).RetMsg = "time <= 0");
/* 103 */       ((IDIPCmd_AqDoBanAddFriendReq)this.cmd).sendResponse();
/*     */       
/* 105 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoBanAddFriendReq.handle@time <= 0|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|time=%d|reason=%s|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoBanAddFriendRsp)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoBanAddFriendRsp)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((AqDoBanAddFriendReq)((IDIPPacket_AqDoBanAddFriendReq)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoBanAddFriendReq)((IDIPPacket_AqDoBanAddFriendReq)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).req).body).RoleId, Integer.valueOf(((AqDoBanAddFriendReq)((IDIPPacket_AqDoBanAddFriendReq)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).req).body).Time), ((AqDoBanAddFriendReq)((IDIPPacket_AqDoBanAddFriendReq)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).req).body).Reason, Integer.valueOf(((AqDoBanAddFriendReq)((IDIPPacket_AqDoBanAddFriendReq)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).req).body).Source), ((AqDoBanAddFriendReq)((IDIPPacket_AqDoBanAddFriendReq)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 111 */       return false;
/*     */     }
/*     */     
/* 114 */     String reason = idip.core.Utils.urlDecode1738(((AqDoBanAddFriendReq)((IDIPPacket_AqDoBanAddFriendReq)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).req).body).Reason);
/* 115 */     if (reason.isEmpty())
/*     */     {
/* 117 */       ((IDIPPacket_AqDoBanAddFriendRsp)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).rsp).head.Result = (((AqDoBanAddFriendRsp)((IDIPPacket_AqDoBanAddFriendRsp)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).rsp).body).Result = 'ﬓ');
/* 118 */       ((IDIPPacket_AqDoBanAddFriendRsp)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).rsp).head.RetErrMsg = (((AqDoBanAddFriendRsp)((IDIPPacket_AqDoBanAddFriendRsp)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).rsp).body).RetMsg = "reason is empty");
/* 119 */       ((IDIPCmd_AqDoBanAddFriendReq)this.cmd).sendResponse();
/*     */       
/* 121 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoBanAddFriendReq.handle@reason is empty|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|time=%d|reason=%s|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoBanAddFriendRsp)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoBanAddFriendRsp)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((AqDoBanAddFriendReq)((IDIPPacket_AqDoBanAddFriendReq)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoBanAddFriendReq)((IDIPPacket_AqDoBanAddFriendReq)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).req).body).RoleId, Integer.valueOf(((AqDoBanAddFriendReq)((IDIPPacket_AqDoBanAddFriendReq)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).req).body).Time), reason, Integer.valueOf(((AqDoBanAddFriendReq)((IDIPPacket_AqDoBanAddFriendReq)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).req).body).Source), ((AqDoBanAddFriendReq)((IDIPPacket_AqDoBanAddFriendReq)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 127 */       return false;
/*     */     }
/* 129 */     if (reason.length() > 256)
/*     */     {
/* 131 */       ((IDIPPacket_AqDoBanAddFriendRsp)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).rsp).head.Result = (((AqDoBanAddFriendRsp)((IDIPPacket_AqDoBanAddFriendRsp)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).rsp).body).Result = 'ﬓ');
/* 132 */       ((IDIPPacket_AqDoBanAddFriendRsp)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).rsp).head.RetErrMsg = (((AqDoBanAddFriendRsp)((IDIPPacket_AqDoBanAddFriendRsp)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).rsp).body).RetMsg = String.format("mask_reason length > %d", new Object[] { Integer.valueOf(256) }));
/*     */       
/* 134 */       ((IDIPCmd_AqDoBanAddFriendReq)this.cmd).sendResponse();
/*     */       
/* 136 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoBanAddFriendReq.handle@reason length > MAX_MASKREASON_LEN|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|time=%d|reason=%s|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoBanAddFriendRsp)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoBanAddFriendRsp)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((AqDoBanAddFriendReq)((IDIPPacket_AqDoBanAddFriendReq)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoBanAddFriendReq)((IDIPPacket_AqDoBanAddFriendReq)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).req).body).RoleId, Integer.valueOf(((AqDoBanAddFriendReq)((IDIPPacket_AqDoBanAddFriendReq)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).req).body).Time), reason, Integer.valueOf(((AqDoBanAddFriendReq)((IDIPPacket_AqDoBanAddFriendReq)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).req).body).Source), ((AqDoBanAddFriendReq)((IDIPPacket_AqDoBanAddFriendReq)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 142 */       return false;
/*     */     }
/*     */     
/* 145 */     if (roleId == 0L)
/*     */     {
/* 147 */       mzm.gsp.online.main.ForbidInfoManager.forbidUserFriend(userId, time, reason);
/*     */     }
/*     */     else
/*     */     {
/* 151 */       mzm.gsp.online.main.ForbidInfoManager.forbidFriend(roleId, time, reason);
/*     */     }
/*     */     
/* 154 */     ((IDIPPacket_AqDoBanAddFriendRsp)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).rsp).head.Result = (((AqDoBanAddFriendRsp)((IDIPPacket_AqDoBanAddFriendRsp)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).rsp).body).Result = 0);
/* 155 */     ((AqDoBanAddFriendRsp)((IDIPPacket_AqDoBanAddFriendRsp)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).rsp).body).RetMsg = (((AqDoBanAddFriendRsp)((IDIPPacket_AqDoBanAddFriendRsp)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).rsp).body).RetMsg = "ok");
/* 156 */     ((IDIPCmd_AqDoBanAddFriendReq)this.cmd).sendResponse();
/*     */     
/* 158 */     mzm.gsp.tlog.TLogManager.getInstance().addLog(userId, "AqIDIPDoBanAddFriend", new Object[] { Integer.valueOf(((IDIPPacket_AqDoBanAddFriendReq)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).req).head.SendTime), openId, Integer.valueOf(areaId), Integer.valueOf(partition), Long.valueOf(roleId), Integer.valueOf(0), Integer.valueOf(time), reason, Integer.valueOf(((IDIPPacket_AqDoBanAddFriendReq)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).req).head.Cmdid), ((AqDoBanAddFriendReq)((IDIPPacket_AqDoBanAddFriendReq)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).req).body).Serial, Integer.valueOf(((AqDoBanAddFriendReq)((IDIPPacket_AqDoBanAddFriendReq)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).req).body).Source), Integer.valueOf(((IDIPPacket_AqDoBanAddFriendRsp)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoBanAddFriendRsp)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).rsp).head.RetErrMsg });
/*     */     
/*     */ 
/*     */ 
/* 162 */     GameServer.logger().info(String.format("[idip]PIDIPCmd_AqDoBanAddFriendReq.handle@ban add friend success|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|time=%d|reason=%s|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoBanAddFriendRsp)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoBanAddFriendRsp)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((AqDoBanAddFriendReq)((IDIPPacket_AqDoBanAddFriendReq)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoBanAddFriendReq)((IDIPPacket_AqDoBanAddFriendReq)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).req).body).RoleId, Integer.valueOf(((AqDoBanAddFriendReq)((IDIPPacket_AqDoBanAddFriendReq)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).req).body).Time), reason, Integer.valueOf(((AqDoBanAddFriendReq)((IDIPPacket_AqDoBanAddFriendReq)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).req).body).Source), ((AqDoBanAddFriendReq)((IDIPPacket_AqDoBanAddFriendReq)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).req).body).Serial }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 168 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   protected String getSerialNo()
/*     */   {
/* 174 */     return ((AqDoBanAddFriendReq)((IDIPPacket_AqDoBanAddFriendReq)((IDIPCmd_AqDoBanAddFriendReq)this.cmd).req).body).Serial;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PIDIPCmd_AqDoBanAddFriendReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
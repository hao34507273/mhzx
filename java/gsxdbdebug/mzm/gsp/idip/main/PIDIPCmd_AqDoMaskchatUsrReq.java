/*     */ package mzm.gsp.idip.main;
/*     */ 
/*     */ import idip.AqDoMaskchatUsrReq;
/*     */ import idip.AqDoMaskchatUsrRsp;
/*     */ import idip.IDIPCmd_AqDoMaskchatUsrReq;
/*     */ import idip.IDIPPacket_AqDoMaskchatUsrReq;
/*     */ import idip.IDIPPacket_AqDoMaskchatUsrRsp;
/*     */ import idip.core.IdipHeader;
/*     */ import idip.core.Utils;
/*     */ import mzm.gsp.GameServer;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class PIDIPCmd_AqDoMaskchatUsrReq extends PIDIPCmd<IDIPCmd_AqDoMaskchatUsrReq>
/*     */ {
/*     */   public PIDIPCmd_AqDoMaskchatUsrReq(IDIPCmd_AqDoMaskchatUsrReq cmd)
/*     */   {
/*  17 */     super(cmd);
/*     */   }
/*     */   
/*     */   protected boolean handle()
/*     */     throws Exception
/*     */   {
/*  23 */     String openId = ((AqDoMaskchatUsrReq)((IDIPPacket_AqDoMaskchatUsrReq)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).req).body).OpenId;
/*  24 */     int areaId = ((AqDoMaskchatUsrReq)((IDIPPacket_AqDoMaskchatUsrReq)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).req).body).AreaId;
/*  25 */     int partition = ((AqDoMaskchatUsrReq)((IDIPPacket_AqDoMaskchatUsrReq)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).req).body).Partition;
/*     */     
/*  27 */     String userId = Utils.getUserId(openId, areaId, partition);
/*  28 */     xbean.User xUser = xtable.User.get(userId);
/*  29 */     if (null == xUser)
/*     */     {
/*  31 */       ((IDIPPacket_AqDoMaskchatUsrRsp)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).rsp).head.Result = (((AqDoMaskchatUsrRsp)((IDIPPacket_AqDoMaskchatUsrRsp)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).rsp).body).Result = 1);
/*  32 */       ((IDIPPacket_AqDoMaskchatUsrRsp)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).rsp).head.RetErrMsg = (((AqDoMaskchatUsrRsp)((IDIPPacket_AqDoMaskchatUsrRsp)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).rsp).body).RetMsg = "query userid empty");
/*  33 */       ((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).sendResponse();
/*     */       
/*  35 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoMaskchatUsrReq.handle@user not found|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|time=%d|is_clear=%d|mask_reason=%s|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoMaskchatUsrRsp)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoMaskchatUsrRsp)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((AqDoMaskchatUsrReq)((IDIPPacket_AqDoMaskchatUsrReq)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoMaskchatUsrReq)((IDIPPacket_AqDoMaskchatUsrReq)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).req).body).RoleId, Integer.valueOf(((AqDoMaskchatUsrReq)((IDIPPacket_AqDoMaskchatUsrReq)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).req).body).Time), Byte.valueOf(((AqDoMaskchatUsrReq)((IDIPPacket_AqDoMaskchatUsrReq)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).req).body).IsClear), ((AqDoMaskchatUsrReq)((IDIPPacket_AqDoMaskchatUsrReq)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).req).body).MaskReason, Integer.valueOf(((AqDoMaskchatUsrReq)((IDIPPacket_AqDoMaskchatUsrReq)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).req).body).Source), ((AqDoMaskchatUsrReq)((IDIPPacket_AqDoMaskchatUsrReq)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  41 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  45 */     if (((AqDoMaskchatUsrReq)((IDIPPacket_AqDoMaskchatUsrReq)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).req).body).RoleId.length() > 32)
/*     */     {
/*  47 */       ((IDIPPacket_AqDoMaskchatUsrRsp)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).rsp).head.Result = (((AqDoMaskchatUsrRsp)((IDIPPacket_AqDoMaskchatUsrRsp)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).rsp).body).Result = 1);
/*  48 */       ((IDIPPacket_AqDoMaskchatUsrRsp)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).rsp).head.RetErrMsg = (((AqDoMaskchatUsrRsp)((IDIPPacket_AqDoMaskchatUsrRsp)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).rsp).body).RetMsg = String.format("roleid length > %d", new Object[] { Integer.valueOf(32) }));
/*     */       
/*  50 */       ((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).sendResponse();
/*     */       
/*  52 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoMaskchatUsrReq.handle@roleId length > MAX_ROLEID_LEN|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|time=%d|is_clear=%d|mask_reason=%s|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoMaskchatUsrRsp)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoMaskchatUsrRsp)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((AqDoMaskchatUsrReq)((IDIPPacket_AqDoMaskchatUsrReq)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoMaskchatUsrReq)((IDIPPacket_AqDoMaskchatUsrReq)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).req).body).RoleId, Integer.valueOf(((AqDoMaskchatUsrReq)((IDIPPacket_AqDoMaskchatUsrReq)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).req).body).Time), Byte.valueOf(((AqDoMaskchatUsrReq)((IDIPPacket_AqDoMaskchatUsrReq)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).req).body).IsClear), ((AqDoMaskchatUsrReq)((IDIPPacket_AqDoMaskchatUsrReq)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).req).body).MaskReason, Integer.valueOf(((AqDoMaskchatUsrReq)((IDIPPacket_AqDoMaskchatUsrReq)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).req).body).Source), ((AqDoMaskchatUsrReq)((IDIPPacket_AqDoMaskchatUsrReq)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  58 */       return false;
/*     */     }
/*     */     
/*  61 */     long roleId = -1L;
/*     */     try
/*     */     {
/*  64 */       roleId = Long.parseLong(((AqDoMaskchatUsrReq)((IDIPPacket_AqDoMaskchatUsrReq)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).req).body).RoleId);
/*     */     }
/*     */     catch (NumberFormatException e)
/*     */     {
/*  68 */       ((IDIPPacket_AqDoMaskchatUsrRsp)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).rsp).head.Result = (((AqDoMaskchatUsrRsp)((IDIPPacket_AqDoMaskchatUsrRsp)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).rsp).body).Result = 1);
/*  69 */       ((IDIPPacket_AqDoMaskchatUsrRsp)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).rsp).head.RetErrMsg = (((AqDoMaskchatUsrRsp)((IDIPPacket_AqDoMaskchatUsrRsp)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).rsp).body).RetMsg = "roleid format error");
/*  70 */       ((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).sendResponse();
/*     */       
/*  72 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoMaskchatUsrReq.handle@role not found|ret=%d|ret_msg=%s|user_id=%s|user_role_list=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|time=%d|is_clear=%d|mask_reason=%s|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoMaskchatUsrRsp)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoMaskchatUsrRsp)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).rsp).head.RetErrMsg, userId, xUser.getRoleids().toString(), Integer.valueOf(areaId), Byte.valueOf(((AqDoMaskchatUsrReq)((IDIPPacket_AqDoMaskchatUsrReq)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoMaskchatUsrReq)((IDIPPacket_AqDoMaskchatUsrReq)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).req).body).RoleId, Integer.valueOf(((AqDoMaskchatUsrReq)((IDIPPacket_AqDoMaskchatUsrReq)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).req).body).Time), Byte.valueOf(((AqDoMaskchatUsrReq)((IDIPPacket_AqDoMaskchatUsrReq)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).req).body).IsClear), ((AqDoMaskchatUsrReq)((IDIPPacket_AqDoMaskchatUsrReq)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).req).body).MaskReason, Integer.valueOf(((AqDoMaskchatUsrReq)((IDIPPacket_AqDoMaskchatUsrReq)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).req).body).Source), ((AqDoMaskchatUsrReq)((IDIPPacket_AqDoMaskchatUsrReq)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  79 */       return false;
/*     */     }
/*     */     
/*  82 */     if ((!mzm.gsp.role.main.RoleInterface.isRoleExist(roleId, true)) || (!xUser.getRoleids().contains(Long.valueOf(roleId))))
/*     */     {
/*  84 */       ((IDIPPacket_AqDoMaskchatUsrRsp)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).rsp).head.Result = (((AqDoMaskchatUsrRsp)((IDIPPacket_AqDoMaskchatUsrRsp)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).rsp).body).Result = 1);
/*  85 */       ((IDIPPacket_AqDoMaskchatUsrRsp)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).rsp).head.RetErrMsg = (((AqDoMaskchatUsrRsp)((IDIPPacket_AqDoMaskchatUsrRsp)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).rsp).body).RetMsg = "query roleid empty");
/*  86 */       ((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).sendResponse();
/*     */       
/*  88 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoMaskchatUsrReq.handle@role not found|ret=%d|ret_msg=%s|user_id=%s|user_role_list=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|time=%d|is_clear=%d|mask_reason=%s|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoMaskchatUsrRsp)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoMaskchatUsrRsp)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).rsp).head.RetErrMsg, userId, xUser.getRoleids().toString(), Integer.valueOf(areaId), Byte.valueOf(((AqDoMaskchatUsrReq)((IDIPPacket_AqDoMaskchatUsrReq)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoMaskchatUsrReq)((IDIPPacket_AqDoMaskchatUsrReq)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).req).body).RoleId, Integer.valueOf(((AqDoMaskchatUsrReq)((IDIPPacket_AqDoMaskchatUsrReq)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).req).body).Time), Byte.valueOf(((AqDoMaskchatUsrReq)((IDIPPacket_AqDoMaskchatUsrReq)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).req).body).IsClear), ((AqDoMaskchatUsrReq)((IDIPPacket_AqDoMaskchatUsrReq)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).req).body).MaskReason, Integer.valueOf(((AqDoMaskchatUsrReq)((IDIPPacket_AqDoMaskchatUsrReq)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).req).body).Source), ((AqDoMaskchatUsrReq)((IDIPPacket_AqDoMaskchatUsrReq)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  95 */       return false;
/*     */     }
/*     */     
/*  98 */     int time = ((AqDoMaskchatUsrReq)((IDIPPacket_AqDoMaskchatUsrReq)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).req).body).Time;
/*  99 */     if (time <= 0)
/*     */     {
/* 101 */       ((IDIPPacket_AqDoMaskchatUsrRsp)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).rsp).head.Result = (((AqDoMaskchatUsrRsp)((IDIPPacket_AqDoMaskchatUsrRsp)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).rsp).body).Result = 'ﮂ');
/* 102 */       ((IDIPPacket_AqDoMaskchatUsrRsp)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).rsp).head.RetErrMsg = (((AqDoMaskchatUsrRsp)((IDIPPacket_AqDoMaskchatUsrRsp)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).rsp).body).RetMsg = "time must > 0");
/* 103 */       ((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).sendResponse();
/*     */       
/* 105 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoMaskchatUsrReq.handle@time <= 0|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|time=%d|is_clear=%d|mask_reason=%s|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoMaskchatUsrRsp)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoMaskchatUsrRsp)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((AqDoMaskchatUsrReq)((IDIPPacket_AqDoMaskchatUsrReq)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoMaskchatUsrReq)((IDIPPacket_AqDoMaskchatUsrReq)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).req).body).RoleId, Integer.valueOf(((AqDoMaskchatUsrReq)((IDIPPacket_AqDoMaskchatUsrReq)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).req).body).Time), Byte.valueOf(((AqDoMaskchatUsrReq)((IDIPPacket_AqDoMaskchatUsrReq)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).req).body).IsClear), ((AqDoMaskchatUsrReq)((IDIPPacket_AqDoMaskchatUsrReq)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).req).body).MaskReason, Integer.valueOf(((AqDoMaskchatUsrReq)((IDIPPacket_AqDoMaskchatUsrReq)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).req).body).Source), ((AqDoMaskchatUsrReq)((IDIPPacket_AqDoMaskchatUsrReq)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 111 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 115 */     String maskReason = Utils.urlDecode1738(((AqDoMaskchatUsrReq)((IDIPPacket_AqDoMaskchatUsrReq)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).req).body).MaskReason);
/* 116 */     if (maskReason.isEmpty())
/*     */     {
/* 118 */       ((IDIPPacket_AqDoMaskchatUsrRsp)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).rsp).head.Result = (((AqDoMaskchatUsrRsp)((IDIPPacket_AqDoMaskchatUsrRsp)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).rsp).body).Result = 'ﮁ');
/* 119 */       ((IDIPPacket_AqDoMaskchatUsrRsp)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).rsp).head.RetErrMsg = (((AqDoMaskchatUsrRsp)((IDIPPacket_AqDoMaskchatUsrRsp)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).rsp).body).RetMsg = "mask_reason is empty");
/* 120 */       ((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).sendResponse();
/*     */       
/* 122 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoMaskchatUsrReq.handle@maskreason is empty|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|time=%d|is_clear=%d|mask_reason=%s|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoMaskchatUsrRsp)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoMaskchatUsrRsp)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((AqDoMaskchatUsrReq)((IDIPPacket_AqDoMaskchatUsrReq)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoMaskchatUsrReq)((IDIPPacket_AqDoMaskchatUsrReq)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).req).body).RoleId, Integer.valueOf(((AqDoMaskchatUsrReq)((IDIPPacket_AqDoMaskchatUsrReq)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).req).body).Time), Byte.valueOf(((AqDoMaskchatUsrReq)((IDIPPacket_AqDoMaskchatUsrReq)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).req).body).IsClear), ((AqDoMaskchatUsrReq)((IDIPPacket_AqDoMaskchatUsrReq)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).req).body).MaskReason, Integer.valueOf(((AqDoMaskchatUsrReq)((IDIPPacket_AqDoMaskchatUsrReq)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).req).body).Source), ((AqDoMaskchatUsrReq)((IDIPPacket_AqDoMaskchatUsrReq)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 128 */       return false;
/*     */     }
/* 130 */     if (maskReason.length() > 256)
/*     */     {
/* 132 */       ((IDIPPacket_AqDoMaskchatUsrRsp)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).rsp).head.Result = (((AqDoMaskchatUsrRsp)((IDIPPacket_AqDoMaskchatUsrRsp)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).rsp).body).Result = 'ﮁ');
/* 133 */       ((IDIPPacket_AqDoMaskchatUsrRsp)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).rsp).head.RetErrMsg = (((AqDoMaskchatUsrRsp)((IDIPPacket_AqDoMaskchatUsrRsp)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).rsp).body).RetMsg = String.format("mask_reason length > %d", new Object[] { Integer.valueOf(256) }));
/*     */       
/* 135 */       ((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).sendResponse();
/*     */       
/* 137 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoMaskchatUsrReq.handle@mask_reason length > MAX_MASKREASON_LEN|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|time=%d|is_clear=%d|mask_reason=%s|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoMaskchatUsrRsp)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoMaskchatUsrRsp)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((AqDoMaskchatUsrReq)((IDIPPacket_AqDoMaskchatUsrReq)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoMaskchatUsrReq)((IDIPPacket_AqDoMaskchatUsrReq)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).req).body).RoleId, Integer.valueOf(((AqDoMaskchatUsrReq)((IDIPPacket_AqDoMaskchatUsrReq)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).req).body).Time), Byte.valueOf(((AqDoMaskchatUsrReq)((IDIPPacket_AqDoMaskchatUsrReq)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).req).body).IsClear), ((AqDoMaskchatUsrReq)((IDIPPacket_AqDoMaskchatUsrReq)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).req).body).MaskReason, Integer.valueOf(((AqDoMaskchatUsrReq)((IDIPPacket_AqDoMaskchatUsrReq)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).req).body).Source), ((AqDoMaskchatUsrReq)((IDIPPacket_AqDoMaskchatUsrReq)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 143 */       return false;
/*     */     }
/*     */     
/* 146 */     mzm.gsp.online.main.ForbidInfoManager.forbidTalk(roleId, time, maskReason);
/* 147 */     boolean clear = ((AqDoMaskchatUsrReq)((IDIPPacket_AqDoMaskchatUsrReq)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).req).body).IsClear == 1;
/* 148 */     if (clear)
/*     */     {
/*     */ 
/* 151 */       IdipManager.sendClearSayToAll(roleId);
/*     */     }
/*     */     
/* 154 */     ((AqDoMaskchatUsrRsp)((IDIPPacket_AqDoMaskchatUsrRsp)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).rsp).body).Result = 0;
/* 155 */     ((AqDoMaskchatUsrRsp)((IDIPPacket_AqDoMaskchatUsrRsp)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).rsp).body).RetMsg = "ok";
/* 156 */     ((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).sendResponse();
/*     */     
/* 158 */     StringBuilder logStr = new StringBuilder();
/* 159 */     logStr.append(((IDIPPacket_AqDoMaskchatUsrReq)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).req).head.SendTime).append("|");
/* 160 */     logStr.append(((AqDoMaskchatUsrReq)((IDIPPacket_AqDoMaskchatUsrReq)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).req).body).OpenId).append("|");
/* 161 */     logStr.append(((AqDoMaskchatUsrReq)((IDIPPacket_AqDoMaskchatUsrReq)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).req).body).AreaId).append("|");
/* 162 */     logStr.append(((AqDoMaskchatUsrReq)((IDIPPacket_AqDoMaskchatUsrReq)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).req).body).Partition).append("|");
/* 163 */     logStr.append(roleId).append("|");
/* 164 */     logStr.append(0).append("|");
/* 165 */     logStr.append(((AqDoMaskchatUsrReq)((IDIPPacket_AqDoMaskchatUsrReq)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).req).body).Time).append("|");
/* 166 */     logStr.append(((AqDoMaskchatUsrReq)((IDIPPacket_AqDoMaskchatUsrReq)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).req).body).IsClear).append("|");
/* 167 */     logStr.append(((AqDoMaskchatUsrReq)((IDIPPacket_AqDoMaskchatUsrReq)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).req).body).MaskReason).append("|");
/* 168 */     logStr.append(((IDIPPacket_AqDoMaskchatUsrReq)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).req).head.Cmdid).append("|");
/* 169 */     logStr.append(((AqDoMaskchatUsrReq)((IDIPPacket_AqDoMaskchatUsrReq)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).req).body).Serial).append("|");
/* 170 */     logStr.append(((AqDoMaskchatUsrReq)((IDIPPacket_AqDoMaskchatUsrReq)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).req).body).Source).append("|");
/* 171 */     logStr.append(((AqDoMaskchatUsrRsp)((IDIPPacket_AqDoMaskchatUsrRsp)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).rsp).body).Result).append("|");
/* 172 */     logStr.append(((AqDoMaskchatUsrRsp)((IDIPPacket_AqDoMaskchatUsrRsp)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).rsp).body).RetMsg);
/*     */     
/* 174 */     mzm.gsp.tlog.TLogManager.getInstance().addLog(roleId, "AqIDIPDoMaskchatUsr", logStr.toString());
/*     */     
/* 176 */     GameServer.logger().info(String.format("[idip]PIDIPCmd_AqDoMaskchatUsrReq.handle@mask chat usr success|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|time=%d|is_clear=%d|mask_reason=%s|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoMaskchatUsrRsp)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoMaskchatUsrRsp)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((AqDoMaskchatUsrReq)((IDIPPacket_AqDoMaskchatUsrReq)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoMaskchatUsrReq)((IDIPPacket_AqDoMaskchatUsrReq)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).req).body).RoleId, Integer.valueOf(((AqDoMaskchatUsrReq)((IDIPPacket_AqDoMaskchatUsrReq)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).req).body).Time), Byte.valueOf(((AqDoMaskchatUsrReq)((IDIPPacket_AqDoMaskchatUsrReq)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).req).body).IsClear), ((AqDoMaskchatUsrReq)((IDIPPacket_AqDoMaskchatUsrReq)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).req).body).MaskReason, Integer.valueOf(((AqDoMaskchatUsrReq)((IDIPPacket_AqDoMaskchatUsrReq)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).req).body).Source), ((AqDoMaskchatUsrReq)((IDIPPacket_AqDoMaskchatUsrReq)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).req).body).Serial }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 182 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   protected String getSerialNo()
/*     */   {
/* 188 */     return ((AqDoMaskchatUsrReq)((IDIPPacket_AqDoMaskchatUsrReq)((IDIPCmd_AqDoMaskchatUsrReq)this.cmd).req).body).Serial;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PIDIPCmd_AqDoMaskchatUsrReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
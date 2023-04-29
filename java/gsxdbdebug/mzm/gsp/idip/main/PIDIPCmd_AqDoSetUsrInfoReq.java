/*     */ package mzm.gsp.idip.main;
/*     */ 
/*     */ import idip.AqDoSetUsrInfoReq;
/*     */ import idip.AqDoSetUsrInfoRsp;
/*     */ import idip.IDIPCmd_AqDoSetUsrInfoReq;
/*     */ import idip.IDIPPacket_AqDoSetUsrInfoReq;
/*     */ import idip.IDIPPacket_AqDoSetUsrInfoRsp;
/*     */ import idip.core.IdipHeader;
/*     */ import mzm.gsp.GameServer;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class PIDIPCmd_AqDoSetUsrInfoReq extends PIDIPCmd<IDIPCmd_AqDoSetUsrInfoReq>
/*     */ {
/*     */   public PIDIPCmd_AqDoSetUsrInfoReq(IDIPCmd_AqDoSetUsrInfoReq cmd)
/*     */   {
/*  16 */     super(cmd);
/*     */   }
/*     */   
/*     */   protected boolean handle()
/*     */     throws Exception
/*     */   {
/*  22 */     String openId = ((AqDoSetUsrInfoReq)((IDIPPacket_AqDoSetUsrInfoReq)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).req).body).OpenId;
/*  23 */     int areaId = ((AqDoSetUsrInfoReq)((IDIPPacket_AqDoSetUsrInfoReq)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).req).body).AreaId;
/*  24 */     int partition = ((AqDoSetUsrInfoReq)((IDIPPacket_AqDoSetUsrInfoReq)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).req).body).Partition;
/*     */     
/*  26 */     String userId = idip.core.Utils.getUserId(openId, areaId, partition);
/*  27 */     xbean.User xUser = xtable.User.get(userId);
/*  28 */     if (null == xUser)
/*     */     {
/*  30 */       ((IDIPPacket_AqDoSetUsrInfoRsp)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).rsp).head.Result = 1;
/*  31 */       ((IDIPPacket_AqDoSetUsrInfoRsp)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).rsp).head.RetErrMsg = "query userid empty";
/*  32 */       ((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).sendResponse();
/*     */       
/*  34 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoSetUsrInfoReq.handle@user not found|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|type=%d|content=%s|time=%d|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoSetUsrInfoRsp)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoSetUsrInfoRsp)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((AqDoSetUsrInfoReq)((IDIPPacket_AqDoSetUsrInfoReq)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoSetUsrInfoReq)((IDIPPacket_AqDoSetUsrInfoReq)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).req).body).RoleId, Byte.valueOf(((AqDoSetUsrInfoReq)((IDIPPacket_AqDoSetUsrInfoReq)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).req).body).Type), ((AqDoSetUsrInfoReq)((IDIPPacket_AqDoSetUsrInfoReq)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).req).body).Content, Integer.valueOf(((AqDoSetUsrInfoReq)((IDIPPacket_AqDoSetUsrInfoReq)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).req).body).Time), Integer.valueOf(((AqDoSetUsrInfoReq)((IDIPPacket_AqDoSetUsrInfoReq)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).req).body).Source), ((AqDoSetUsrInfoReq)((IDIPPacket_AqDoSetUsrInfoReq)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  40 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  44 */     if (((AqDoSetUsrInfoReq)((IDIPPacket_AqDoSetUsrInfoReq)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).req).body).RoleId.length() > 32)
/*     */     {
/*  46 */       ((IDIPPacket_AqDoSetUsrInfoRsp)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).rsp).head.Result = (((AqDoSetUsrInfoRsp)((IDIPPacket_AqDoSetUsrInfoRsp)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).rsp).body).Result = 1);
/*  47 */       ((IDIPPacket_AqDoSetUsrInfoRsp)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).rsp).head.RetErrMsg = (((AqDoSetUsrInfoRsp)((IDIPPacket_AqDoSetUsrInfoRsp)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).rsp).body).RetMsg = String.format("roleid length > %d", new Object[] { Integer.valueOf(32) }));
/*     */       
/*  49 */       ((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).sendResponse();
/*     */       
/*  51 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoSetUsrInfoReq.handle@roleId length > MAX_ROLEID_LEN|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|type=%d|content=%s|time=%d|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoSetUsrInfoRsp)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoSetUsrInfoRsp)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((AqDoSetUsrInfoReq)((IDIPPacket_AqDoSetUsrInfoReq)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoSetUsrInfoReq)((IDIPPacket_AqDoSetUsrInfoReq)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).req).body).RoleId, Byte.valueOf(((AqDoSetUsrInfoReq)((IDIPPacket_AqDoSetUsrInfoReq)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).req).body).Type), ((AqDoSetUsrInfoReq)((IDIPPacket_AqDoSetUsrInfoReq)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).req).body).Content, Integer.valueOf(((AqDoSetUsrInfoReq)((IDIPPacket_AqDoSetUsrInfoReq)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).req).body).Time), Integer.valueOf(((AqDoSetUsrInfoReq)((IDIPPacket_AqDoSetUsrInfoReq)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).req).body).Source), ((AqDoSetUsrInfoReq)((IDIPPacket_AqDoSetUsrInfoReq)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).req).body).Serial }));
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
/*  63 */       roleId = Long.parseLong(((AqDoSetUsrInfoReq)((IDIPPacket_AqDoSetUsrInfoReq)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).req).body).RoleId);
/*     */     }
/*     */     catch (NumberFormatException e)
/*     */     {
/*  67 */       ((IDIPPacket_AqDoSetUsrInfoRsp)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).rsp).head.Result = (((AqDoSetUsrInfoRsp)((IDIPPacket_AqDoSetUsrInfoRsp)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).rsp).body).Result = 1);
/*  68 */       ((IDIPPacket_AqDoSetUsrInfoRsp)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).rsp).head.RetErrMsg = (((AqDoSetUsrInfoRsp)((IDIPPacket_AqDoSetUsrInfoRsp)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).rsp).body).RetMsg = "roleid format error");
/*  69 */       ((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).sendResponse();
/*     */       
/*  71 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoSetUsrInfoReq.handle@role not found|ret=%d|ret_msg=%s|user_id=%s|user_role_list=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|type=%d|content=%s|time=%d|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoSetUsrInfoRsp)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoSetUsrInfoRsp)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).rsp).head.RetErrMsg, userId, xUser.getRoleids().toString(), Integer.valueOf(areaId), Byte.valueOf(((AqDoSetUsrInfoReq)((IDIPPacket_AqDoSetUsrInfoReq)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoSetUsrInfoReq)((IDIPPacket_AqDoSetUsrInfoReq)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).req).body).RoleId, Byte.valueOf(((AqDoSetUsrInfoReq)((IDIPPacket_AqDoSetUsrInfoReq)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).req).body).Type), ((AqDoSetUsrInfoReq)((IDIPPacket_AqDoSetUsrInfoReq)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).req).body).Content, Integer.valueOf(((AqDoSetUsrInfoReq)((IDIPPacket_AqDoSetUsrInfoReq)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).req).body).Time), Integer.valueOf(((AqDoSetUsrInfoReq)((IDIPPacket_AqDoSetUsrInfoReq)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).req).body).Source), ((AqDoSetUsrInfoReq)((IDIPPacket_AqDoSetUsrInfoReq)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  78 */       return false;
/*     */     }
/*     */     
/*  81 */     if ((!mzm.gsp.role.main.RoleInterface.isRoleExist(roleId, true)) || (!xUser.getRoleids().contains(Long.valueOf(roleId))))
/*     */     {
/*  83 */       ((IDIPPacket_AqDoSetUsrInfoRsp)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).rsp).head.Result = 1;
/*  84 */       ((IDIPPacket_AqDoSetUsrInfoRsp)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).rsp).head.RetErrMsg = "query roleid empty";
/*  85 */       ((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).sendResponse();
/*     */       
/*  87 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoSetUsrInfoReq.handle@role not found|ret=%d|ret_msg=%s|user_id=%s|user_role_list=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|type=%d|content=%s|time=%d|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoSetUsrInfoRsp)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoSetUsrInfoRsp)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).rsp).head.RetErrMsg, userId, xUser.getRoleids().toString(), Integer.valueOf(areaId), Byte.valueOf(((AqDoSetUsrInfoReq)((IDIPPacket_AqDoSetUsrInfoReq)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoSetUsrInfoReq)((IDIPPacket_AqDoSetUsrInfoReq)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).req).body).RoleId, Byte.valueOf(((AqDoSetUsrInfoReq)((IDIPPacket_AqDoSetUsrInfoReq)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).req).body).Type), ((AqDoSetUsrInfoReq)((IDIPPacket_AqDoSetUsrInfoReq)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).req).body).Content, Integer.valueOf(((AqDoSetUsrInfoReq)((IDIPPacket_AqDoSetUsrInfoReq)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).req).body).Time), Integer.valueOf(((AqDoSetUsrInfoReq)((IDIPPacket_AqDoSetUsrInfoReq)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).req).body).Source), ((AqDoSetUsrInfoReq)((IDIPPacket_AqDoSetUsrInfoReq)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  94 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  98 */     int type = ((AqDoSetUsrInfoReq)((IDIPPacket_AqDoSetUsrInfoReq)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).req).body).Type;
/*  99 */     if (type != 1)
/*     */     {
/* 101 */       ((IDIPPacket_AqDoSetUsrInfoRsp)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).rsp).head.Result = (((AqDoSetUsrInfoRsp)((IDIPPacket_AqDoSetUsrInfoRsp)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).rsp).body).Result = 'צּ');
/* 102 */       ((IDIPPacket_AqDoSetUsrInfoRsp)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).rsp).head.RetErrMsg = (((AqDoSetUsrInfoRsp)((IDIPPacket_AqDoSetUsrInfoRsp)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).rsp).body).RetMsg = "type not exist");
/* 103 */       ((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).sendResponse();
/*     */       
/* 105 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoSetUsrInfoReq.handle@type not exist|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|type=%d|content=%s|time=%d|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoSetUsrInfoRsp)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoSetUsrInfoRsp)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((AqDoSetUsrInfoReq)((IDIPPacket_AqDoSetUsrInfoReq)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoSetUsrInfoReq)((IDIPPacket_AqDoSetUsrInfoReq)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).req).body).RoleId, Byte.valueOf(((AqDoSetUsrInfoReq)((IDIPPacket_AqDoSetUsrInfoReq)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).req).body).Type), ((AqDoSetUsrInfoReq)((IDIPPacket_AqDoSetUsrInfoReq)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).req).body).Content, Integer.valueOf(((AqDoSetUsrInfoReq)((IDIPPacket_AqDoSetUsrInfoReq)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).req).body).Time), Integer.valueOf(((AqDoSetUsrInfoReq)((IDIPPacket_AqDoSetUsrInfoReq)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).req).body).Source), ((AqDoSetUsrInfoReq)((IDIPPacket_AqDoSetUsrInfoReq)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 111 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 115 */     long lockInfoTime = ((AqDoSetUsrInfoReq)((IDIPPacket_AqDoSetUsrInfoReq)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).req).body).Time;
/* 116 */     if (lockInfoTime <= 0L)
/*     */     {
/* 118 */       ((IDIPPacket_AqDoSetUsrInfoRsp)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).rsp).head.Result = (((AqDoSetUsrInfoRsp)((IDIPPacket_AqDoSetUsrInfoRsp)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).rsp).body).Result = 'פּ');
/* 119 */       ((IDIPPacket_AqDoSetUsrInfoRsp)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).rsp).head.RetErrMsg = (((AqDoSetUsrInfoRsp)((IDIPPacket_AqDoSetUsrInfoRsp)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).rsp).body).RetMsg = "time must > 0");
/* 120 */       ((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).sendResponse();
/*     */       
/* 122 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoSetUsrInfoReq.handle@time <= 0|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|type=%d|content=%s|time=%d|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoSetUsrInfoRsp)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoSetUsrInfoRsp)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((AqDoSetUsrInfoReq)((IDIPPacket_AqDoSetUsrInfoReq)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoSetUsrInfoReq)((IDIPPacket_AqDoSetUsrInfoReq)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).req).body).RoleId, Byte.valueOf(((AqDoSetUsrInfoReq)((IDIPPacket_AqDoSetUsrInfoReq)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).req).body).Type), ((AqDoSetUsrInfoReq)((IDIPPacket_AqDoSetUsrInfoReq)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).req).body).Content, Integer.valueOf(((AqDoSetUsrInfoReq)((IDIPPacket_AqDoSetUsrInfoReq)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).req).body).Time), Integer.valueOf(((AqDoSetUsrInfoReq)((IDIPPacket_AqDoSetUsrInfoReq)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).req).body).Source), ((AqDoSetUsrInfoReq)((IDIPPacket_AqDoSetUsrInfoReq)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 128 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 132 */     String content = idip.core.Utils.urlDecode1738(((AqDoSetUsrInfoReq)((IDIPPacket_AqDoSetUsrInfoReq)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).req).body).Content);
/* 133 */     if (content.isEmpty())
/*     */     {
/* 135 */       ((IDIPPacket_AqDoSetUsrInfoRsp)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).rsp).head.Result = 64325;
/* 136 */       ((IDIPPacket_AqDoSetUsrInfoRsp)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).rsp).head.RetErrMsg = "content is empty";
/* 137 */       ((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).sendResponse();
/*     */       
/* 139 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoSetUsrInfoReq.handle@content is empty|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|type=%d|content=%s|time=%d|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoSetUsrInfoRsp)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoSetUsrInfoRsp)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((AqDoSetUsrInfoReq)((IDIPPacket_AqDoSetUsrInfoReq)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoSetUsrInfoReq)((IDIPPacket_AqDoSetUsrInfoReq)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).req).body).RoleId, Byte.valueOf(((AqDoSetUsrInfoReq)((IDIPPacket_AqDoSetUsrInfoReq)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).req).body).Type), ((AqDoSetUsrInfoReq)((IDIPPacket_AqDoSetUsrInfoReq)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).req).body).Content, Integer.valueOf(((AqDoSetUsrInfoReq)((IDIPPacket_AqDoSetUsrInfoReq)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).req).body).Time), Integer.valueOf(((AqDoSetUsrInfoReq)((IDIPPacket_AqDoSetUsrInfoReq)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).req).body).Source), ((AqDoSetUsrInfoReq)((IDIPPacket_AqDoSetUsrInfoReq)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 145 */       return false;
/*     */     }
/* 147 */     if (content.length() > 256)
/*     */     {
/* 149 */       ((IDIPPacket_AqDoSetUsrInfoRsp)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).rsp).head.Result = 64325;
/* 150 */       ((IDIPPacket_AqDoSetUsrInfoRsp)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).rsp).head.RetErrMsg = String.format("content length > %d", new Object[] { Integer.valueOf(256) });
/* 151 */       ((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).sendResponse();
/*     */       
/* 153 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoSetUsrInfoReq.handle@content length > MAX_CONTENT_LEN|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|type=%d|content=%s|time=%d|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoSetUsrInfoRsp)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoSetUsrInfoRsp)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((AqDoSetUsrInfoReq)((IDIPPacket_AqDoSetUsrInfoReq)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoSetUsrInfoReq)((IDIPPacket_AqDoSetUsrInfoReq)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).req).body).RoleId, Byte.valueOf(((AqDoSetUsrInfoReq)((IDIPPacket_AqDoSetUsrInfoReq)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).req).body).Type), ((AqDoSetUsrInfoReq)((IDIPPacket_AqDoSetUsrInfoReq)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).req).body).Content, Integer.valueOf(((AqDoSetUsrInfoReq)((IDIPPacket_AqDoSetUsrInfoReq)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).req).body).Time), Integer.valueOf(((AqDoSetUsrInfoReq)((IDIPPacket_AqDoSetUsrInfoReq)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).req).body).Source), ((AqDoSetUsrInfoReq)((IDIPPacket_AqDoSetUsrInfoReq)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 159 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 163 */     int result = mzm.gsp.role.main.RoleInterface.changeRoleName4Idip(roleId, content);
/* 164 */     if (result != 0)
/*     */     {
/*     */ 
/* 167 */       switch (result)
/*     */       {
/*     */       case -1: 
/* 170 */         ((IDIPPacket_AqDoSetUsrInfoRsp)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).rsp).head.Result = 64323;
/* 171 */         ((IDIPPacket_AqDoSetUsrInfoRsp)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).rsp).head.RetErrMsg = "content_name invalid";
/* 172 */         break;
/*     */       case -2: 
/* 174 */         ((IDIPPacket_AqDoSetUsrInfoRsp)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).rsp).head.Result = 64322;
/* 175 */         ((IDIPPacket_AqDoSetUsrInfoRsp)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).rsp).head.RetErrMsg = "content_name sensitive";
/* 176 */         break;
/*     */       case -3: 
/* 178 */         ((IDIPPacket_AqDoSetUsrInfoRsp)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).rsp).head.Result = 64321;
/* 179 */         ((IDIPPacket_AqDoSetUsrInfoRsp)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).rsp).head.RetErrMsg = "content_name repeat";
/* 180 */         break;
/*     */       default: 
/* 182 */         ((IDIPPacket_AqDoSetUsrInfoRsp)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).rsp).head.Result = 64320;
/* 183 */         ((IDIPPacket_AqDoSetUsrInfoRsp)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).rsp).head.RetErrMsg = "change role name failed";
/*     */       }
/*     */       
/* 186 */       ((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).sendResponse();
/* 187 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 191 */     IdipManager.addLockRoleInfo(roleId, type, lockInfoTime, content);
/*     */     
/* 193 */     ((AqDoSetUsrInfoRsp)((IDIPPacket_AqDoSetUsrInfoRsp)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).rsp).body).Result = 0;
/* 194 */     ((AqDoSetUsrInfoRsp)((IDIPPacket_AqDoSetUsrInfoRsp)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).rsp).body).RetMsg = "ok";
/* 195 */     ((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).sendResponse();
/*     */     
/* 197 */     StringBuilder logStr = new StringBuilder();
/* 198 */     logStr.append(((IDIPPacket_AqDoSetUsrInfoReq)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).req).head.SendTime).append("|");
/* 199 */     logStr.append(((AqDoSetUsrInfoReq)((IDIPPacket_AqDoSetUsrInfoReq)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).req).body).OpenId).append("|");
/* 200 */     logStr.append(((AqDoSetUsrInfoReq)((IDIPPacket_AqDoSetUsrInfoReq)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).req).body).AreaId).append("|");
/* 201 */     logStr.append(((AqDoSetUsrInfoReq)((IDIPPacket_AqDoSetUsrInfoReq)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).req).body).Partition).append("|");
/* 202 */     logStr.append(roleId).append("|");
/* 203 */     logStr.append(0).append("|");
/* 204 */     logStr.append(((AqDoSetUsrInfoReq)((IDIPPacket_AqDoSetUsrInfoReq)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).req).body).Type).append("|");
/* 205 */     logStr.append(((AqDoSetUsrInfoReq)((IDIPPacket_AqDoSetUsrInfoReq)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).req).body).Content).append("|");
/* 206 */     logStr.append(((AqDoSetUsrInfoReq)((IDIPPacket_AqDoSetUsrInfoReq)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).req).body).Time).append("|");
/* 207 */     logStr.append(((IDIPPacket_AqDoSetUsrInfoReq)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).req).head.Cmdid).append("|");
/* 208 */     logStr.append(((AqDoSetUsrInfoReq)((IDIPPacket_AqDoSetUsrInfoReq)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).req).body).Serial).append("|");
/* 209 */     logStr.append(((AqDoSetUsrInfoReq)((IDIPPacket_AqDoSetUsrInfoReq)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).req).body).Source).append("|");
/* 210 */     logStr.append(((AqDoSetUsrInfoRsp)((IDIPPacket_AqDoSetUsrInfoRsp)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).rsp).body).Result).append("|");
/* 211 */     logStr.append(((AqDoSetUsrInfoRsp)((IDIPPacket_AqDoSetUsrInfoRsp)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).rsp).body).RetMsg);
/*     */     
/* 213 */     mzm.gsp.tlog.TLogManager.getInstance().addLog(roleId, "AqIDIPDoSetUsrInfo", logStr.toString());
/*     */     
/* 215 */     GameServer.logger().info(String.format("[idip]PIDIPCmd_AqDoSetUsrInfoReq.handle@do lock role info done|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|type=%d|content=%s|time=%d|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoSetUsrInfoRsp)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoSetUsrInfoRsp)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((AqDoSetUsrInfoReq)((IDIPPacket_AqDoSetUsrInfoReq)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoSetUsrInfoReq)((IDIPPacket_AqDoSetUsrInfoReq)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).req).body).RoleId, Byte.valueOf(((AqDoSetUsrInfoReq)((IDIPPacket_AqDoSetUsrInfoReq)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).req).body).Type), ((AqDoSetUsrInfoReq)((IDIPPacket_AqDoSetUsrInfoReq)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).req).body).Content, Integer.valueOf(((AqDoSetUsrInfoReq)((IDIPPacket_AqDoSetUsrInfoReq)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).req).body).Time), Integer.valueOf(((AqDoSetUsrInfoReq)((IDIPPacket_AqDoSetUsrInfoReq)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).req).body).Source), ((AqDoSetUsrInfoReq)((IDIPPacket_AqDoSetUsrInfoReq)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).req).body).Serial }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 222 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   protected String getSerialNo()
/*     */   {
/* 228 */     return ((AqDoSetUsrInfoReq)((IDIPPacket_AqDoSetUsrInfoReq)((IDIPCmd_AqDoSetUsrInfoReq)this.cmd).req).body).Serial;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PIDIPCmd_AqDoSetUsrInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
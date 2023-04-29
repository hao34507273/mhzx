/*     */ package mzm.gsp.idip.main;
/*     */ 
/*     */ import idip.AqDoZeroprofitReq;
/*     */ import idip.AqDoZeroprofitRsp;
/*     */ import idip.IDIPCmd_AqDoZeroprofitReq;
/*     */ import idip.IDIPPacket_AqDoZeroprofitReq;
/*     */ import idip.IDIPPacket_AqDoZeroprofitRsp;
/*     */ import idip.core.IdipHeader;
/*     */ import mzm.gsp.GameServer;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class PIDIPCmd_AqDoZeroprofitReq extends PIDIPCmd<IDIPCmd_AqDoZeroprofitReq>
/*     */ {
/*     */   public PIDIPCmd_AqDoZeroprofitReq(IDIPCmd_AqDoZeroprofitReq cmd)
/*     */   {
/*  16 */     super(cmd);
/*     */   }
/*     */   
/*     */   protected boolean handle()
/*     */     throws Exception
/*     */   {
/*  22 */     String openId = ((AqDoZeroprofitReq)((IDIPPacket_AqDoZeroprofitReq)((IDIPCmd_AqDoZeroprofitReq)this.cmd).req).body).OpenId;
/*  23 */     int areaId = ((AqDoZeroprofitReq)((IDIPPacket_AqDoZeroprofitReq)((IDIPCmd_AqDoZeroprofitReq)this.cmd).req).body).AreaId;
/*  24 */     int partition = ((AqDoZeroprofitReq)((IDIPPacket_AqDoZeroprofitReq)((IDIPCmd_AqDoZeroprofitReq)this.cmd).req).body).Partition;
/*     */     
/*  26 */     String userId = idip.core.Utils.getUserId(openId, areaId, partition);
/*  27 */     xbean.User xUser = xtable.User.get(userId);
/*  28 */     if (null == xUser)
/*     */     {
/*  30 */       ((IDIPPacket_AqDoZeroprofitRsp)((IDIPCmd_AqDoZeroprofitReq)this.cmd).rsp).head.Result = 1;
/*  31 */       ((IDIPPacket_AqDoZeroprofitRsp)((IDIPCmd_AqDoZeroprofitReq)this.cmd).rsp).head.RetErrMsg = "query userid empty";
/*  32 */       ((IDIPCmd_AqDoZeroprofitReq)this.cmd).sendResponse();
/*     */       
/*  34 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoZeroprofitReq.handle@user not found|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|time=%d|reason=%s|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoZeroprofitRsp)((IDIPCmd_AqDoZeroprofitReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoZeroprofitRsp)((IDIPCmd_AqDoZeroprofitReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((AqDoZeroprofitReq)((IDIPPacket_AqDoZeroprofitReq)((IDIPCmd_AqDoZeroprofitReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoZeroprofitReq)((IDIPPacket_AqDoZeroprofitReq)((IDIPCmd_AqDoZeroprofitReq)this.cmd).req).body).RoleId, Integer.valueOf(((AqDoZeroprofitReq)((IDIPPacket_AqDoZeroprofitReq)((IDIPCmd_AqDoZeroprofitReq)this.cmd).req).body).Time), ((AqDoZeroprofitReq)((IDIPPacket_AqDoZeroprofitReq)((IDIPCmd_AqDoZeroprofitReq)this.cmd).req).body).Reason, Integer.valueOf(((AqDoZeroprofitReq)((IDIPPacket_AqDoZeroprofitReq)((IDIPCmd_AqDoZeroprofitReq)this.cmd).req).body).Source), ((AqDoZeroprofitReq)((IDIPPacket_AqDoZeroprofitReq)((IDIPCmd_AqDoZeroprofitReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  40 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  44 */     if (((AqDoZeroprofitReq)((IDIPPacket_AqDoZeroprofitReq)((IDIPCmd_AqDoZeroprofitReq)this.cmd).req).body).RoleId.length() > 32)
/*     */     {
/*  46 */       ((IDIPPacket_AqDoZeroprofitRsp)((IDIPCmd_AqDoZeroprofitReq)this.cmd).rsp).head.Result = (((AqDoZeroprofitRsp)((IDIPPacket_AqDoZeroprofitRsp)((IDIPCmd_AqDoZeroprofitReq)this.cmd).rsp).body).Result = 1);
/*  47 */       ((IDIPPacket_AqDoZeroprofitRsp)((IDIPCmd_AqDoZeroprofitReq)this.cmd).rsp).head.RetErrMsg = (((AqDoZeroprofitRsp)((IDIPPacket_AqDoZeroprofitRsp)((IDIPCmd_AqDoZeroprofitReq)this.cmd).rsp).body).RetMsg = String.format("roleid length > %d", new Object[] { Integer.valueOf(32) }));
/*     */       
/*  49 */       ((IDIPCmd_AqDoZeroprofitReq)this.cmd).sendResponse();
/*     */       
/*  51 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoZeroprofitReq.handle@roleId length > MAX_ROLEID_LEN|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|time=%d|reason=%s|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoZeroprofitRsp)((IDIPCmd_AqDoZeroprofitReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoZeroprofitRsp)((IDIPCmd_AqDoZeroprofitReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((AqDoZeroprofitReq)((IDIPPacket_AqDoZeroprofitReq)((IDIPCmd_AqDoZeroprofitReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoZeroprofitReq)((IDIPPacket_AqDoZeroprofitReq)((IDIPCmd_AqDoZeroprofitReq)this.cmd).req).body).RoleId, Integer.valueOf(((AqDoZeroprofitReq)((IDIPPacket_AqDoZeroprofitReq)((IDIPCmd_AqDoZeroprofitReq)this.cmd).req).body).Time), ((AqDoZeroprofitReq)((IDIPPacket_AqDoZeroprofitReq)((IDIPCmd_AqDoZeroprofitReq)this.cmd).req).body).Reason, Integer.valueOf(((AqDoZeroprofitReq)((IDIPPacket_AqDoZeroprofitReq)((IDIPCmd_AqDoZeroprofitReq)this.cmd).req).body).Source), ((AqDoZeroprofitReq)((IDIPPacket_AqDoZeroprofitReq)((IDIPCmd_AqDoZeroprofitReq)this.cmd).req).body).Serial }));
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
/*  63 */       roleId = Long.parseLong(((AqDoZeroprofitReq)((IDIPPacket_AqDoZeroprofitReq)((IDIPCmd_AqDoZeroprofitReq)this.cmd).req).body).RoleId);
/*     */     }
/*     */     catch (NumberFormatException e)
/*     */     {
/*  67 */       ((IDIPPacket_AqDoZeroprofitRsp)((IDIPCmd_AqDoZeroprofitReq)this.cmd).rsp).head.Result = (((AqDoZeroprofitRsp)((IDIPPacket_AqDoZeroprofitRsp)((IDIPCmd_AqDoZeroprofitReq)this.cmd).rsp).body).Result = 1);
/*  68 */       ((IDIPPacket_AqDoZeroprofitRsp)((IDIPCmd_AqDoZeroprofitReq)this.cmd).rsp).head.RetErrMsg = (((AqDoZeroprofitRsp)((IDIPPacket_AqDoZeroprofitRsp)((IDIPCmd_AqDoZeroprofitReq)this.cmd).rsp).body).RetMsg = "roleid format error");
/*  69 */       ((IDIPCmd_AqDoZeroprofitReq)this.cmd).sendResponse();
/*     */       
/*  71 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoZeroprofitReq.handle@role not found|ret=%d|ret_msg=%s|user_id=%s|user_role_list=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|time=%d|reason=%s|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoZeroprofitRsp)((IDIPCmd_AqDoZeroprofitReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoZeroprofitRsp)((IDIPCmd_AqDoZeroprofitReq)this.cmd).rsp).head.RetErrMsg, userId, xUser.getRoleids().toString(), Integer.valueOf(areaId), Byte.valueOf(((AqDoZeroprofitReq)((IDIPPacket_AqDoZeroprofitReq)((IDIPCmd_AqDoZeroprofitReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoZeroprofitReq)((IDIPPacket_AqDoZeroprofitReq)((IDIPCmd_AqDoZeroprofitReq)this.cmd).req).body).RoleId, Integer.valueOf(((AqDoZeroprofitReq)((IDIPPacket_AqDoZeroprofitReq)((IDIPCmd_AqDoZeroprofitReq)this.cmd).req).body).Time), ((AqDoZeroprofitReq)((IDIPPacket_AqDoZeroprofitReq)((IDIPCmd_AqDoZeroprofitReq)this.cmd).req).body).Reason, Integer.valueOf(((AqDoZeroprofitReq)((IDIPPacket_AqDoZeroprofitReq)((IDIPCmd_AqDoZeroprofitReq)this.cmd).req).body).Source), ((AqDoZeroprofitReq)((IDIPPacket_AqDoZeroprofitReq)((IDIPCmd_AqDoZeroprofitReq)this.cmd).req).body).Serial }));
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
/*  83 */       ((IDIPPacket_AqDoZeroprofitRsp)((IDIPCmd_AqDoZeroprofitReq)this.cmd).rsp).head.Result = 1;
/*  84 */       ((IDIPPacket_AqDoZeroprofitRsp)((IDIPCmd_AqDoZeroprofitReq)this.cmd).rsp).head.RetErrMsg = "query roleid empty";
/*  85 */       ((IDIPCmd_AqDoZeroprofitReq)this.cmd).sendResponse();
/*     */       
/*  87 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoZeroprofitReq.handle@role not found|ret=%d|ret_msg=%s|user_id=%s|user_role_list=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|time=%d|reason=%s|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoZeroprofitRsp)((IDIPCmd_AqDoZeroprofitReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoZeroprofitRsp)((IDIPCmd_AqDoZeroprofitReq)this.cmd).rsp).head.RetErrMsg, userId, xUser.getRoleids().toString(), Integer.valueOf(areaId), Byte.valueOf(((AqDoZeroprofitReq)((IDIPPacket_AqDoZeroprofitReq)((IDIPCmd_AqDoZeroprofitReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoZeroprofitReq)((IDIPPacket_AqDoZeroprofitReq)((IDIPCmd_AqDoZeroprofitReq)this.cmd).req).body).RoleId, Integer.valueOf(((AqDoZeroprofitReq)((IDIPPacket_AqDoZeroprofitReq)((IDIPCmd_AqDoZeroprofitReq)this.cmd).req).body).Time), ((AqDoZeroprofitReq)((IDIPPacket_AqDoZeroprofitReq)((IDIPCmd_AqDoZeroprofitReq)this.cmd).req).body).Reason, Integer.valueOf(((AqDoZeroprofitReq)((IDIPPacket_AqDoZeroprofitReq)((IDIPCmd_AqDoZeroprofitReq)this.cmd).req).body).Source), ((AqDoZeroprofitReq)((IDIPPacket_AqDoZeroprofitReq)((IDIPCmd_AqDoZeroprofitReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  94 */       return false;
/*     */     }
/*     */     
/*  97 */     int time = ((AqDoZeroprofitReq)((IDIPPacket_AqDoZeroprofitReq)((IDIPCmd_AqDoZeroprofitReq)this.cmd).req).body).Time;
/*  98 */     if (time <= 0)
/*     */     {
/* 100 */       ((IDIPPacket_AqDoZeroprofitRsp)((IDIPCmd_AqDoZeroprofitReq)this.cmd).rsp).head.Result = (((AqDoZeroprofitRsp)((IDIPPacket_AqDoZeroprofitRsp)((IDIPCmd_AqDoZeroprofitReq)this.cmd).rsp).body).Result = 'ﭷ');
/* 101 */       ((IDIPPacket_AqDoZeroprofitRsp)((IDIPCmd_AqDoZeroprofitReq)this.cmd).rsp).head.RetErrMsg = (((AqDoZeroprofitRsp)((IDIPPacket_AqDoZeroprofitRsp)((IDIPCmd_AqDoZeroprofitReq)this.cmd).rsp).body).RetMsg = "time must > 0");
/* 102 */       ((IDIPCmd_AqDoZeroprofitReq)this.cmd).sendResponse();
/*     */       
/* 104 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoZeroprofitReq.handle@time <= 0|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|time=%d|reason=%s|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoZeroprofitRsp)((IDIPCmd_AqDoZeroprofitReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoZeroprofitRsp)((IDIPCmd_AqDoZeroprofitReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((AqDoZeroprofitReq)((IDIPPacket_AqDoZeroprofitReq)((IDIPCmd_AqDoZeroprofitReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoZeroprofitReq)((IDIPPacket_AqDoZeroprofitReq)((IDIPCmd_AqDoZeroprofitReq)this.cmd).req).body).RoleId, Integer.valueOf(((AqDoZeroprofitReq)((IDIPPacket_AqDoZeroprofitReq)((IDIPCmd_AqDoZeroprofitReq)this.cmd).req).body).Time), ((AqDoZeroprofitReq)((IDIPPacket_AqDoZeroprofitReq)((IDIPCmd_AqDoZeroprofitReq)this.cmd).req).body).Reason, Integer.valueOf(((AqDoZeroprofitReq)((IDIPPacket_AqDoZeroprofitReq)((IDIPCmd_AqDoZeroprofitReq)this.cmd).req).body).Source), ((AqDoZeroprofitReq)((IDIPPacket_AqDoZeroprofitReq)((IDIPCmd_AqDoZeroprofitReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 110 */       return false;
/*     */     }
/*     */     
/* 113 */     String reason = idip.core.Utils.urlDecode1738(((AqDoZeroprofitReq)((IDIPPacket_AqDoZeroprofitReq)((IDIPCmd_AqDoZeroprofitReq)this.cmd).req).body).Reason);
/* 114 */     if (reason.isEmpty())
/*     */     {
/* 116 */       ((IDIPPacket_AqDoZeroprofitRsp)((IDIPCmd_AqDoZeroprofitReq)this.cmd).rsp).head.Result = (((AqDoZeroprofitRsp)((IDIPPacket_AqDoZeroprofitRsp)((IDIPCmd_AqDoZeroprofitReq)this.cmd).rsp).body).Result = 'ﭸ');
/* 117 */       ((IDIPPacket_AqDoZeroprofitRsp)((IDIPCmd_AqDoZeroprofitReq)this.cmd).rsp).head.RetErrMsg = (((AqDoZeroprofitRsp)((IDIPPacket_AqDoZeroprofitRsp)((IDIPCmd_AqDoZeroprofitReq)this.cmd).rsp).body).RetMsg = "reason is empty");
/* 118 */       ((IDIPCmd_AqDoZeroprofitReq)this.cmd).sendResponse();
/*     */       
/* 120 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoZeroprofitReq.handle@reason is empty|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|time=%d|reason=%s|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoZeroprofitRsp)((IDIPCmd_AqDoZeroprofitReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoZeroprofitRsp)((IDIPCmd_AqDoZeroprofitReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((AqDoZeroprofitReq)((IDIPPacket_AqDoZeroprofitReq)((IDIPCmd_AqDoZeroprofitReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoZeroprofitReq)((IDIPPacket_AqDoZeroprofitReq)((IDIPCmd_AqDoZeroprofitReq)this.cmd).req).body).RoleId, Integer.valueOf(((AqDoZeroprofitReq)((IDIPPacket_AqDoZeroprofitReq)((IDIPCmd_AqDoZeroprofitReq)this.cmd).req).body).Time), ((AqDoZeroprofitReq)((IDIPPacket_AqDoZeroprofitReq)((IDIPCmd_AqDoZeroprofitReq)this.cmd).req).body).Reason, Integer.valueOf(((AqDoZeroprofitReq)((IDIPPacket_AqDoZeroprofitReq)((IDIPCmd_AqDoZeroprofitReq)this.cmd).req).body).Source), ((AqDoZeroprofitReq)((IDIPPacket_AqDoZeroprofitReq)((IDIPCmd_AqDoZeroprofitReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 126 */       return false;
/*     */     }
/* 128 */     if (reason.length() > 256)
/*     */     {
/* 130 */       ((IDIPPacket_AqDoZeroprofitRsp)((IDIPCmd_AqDoZeroprofitReq)this.cmd).rsp).head.Result = (((AqDoZeroprofitRsp)((IDIPPacket_AqDoZeroprofitRsp)((IDIPCmd_AqDoZeroprofitReq)this.cmd).rsp).body).Result = 'ﭸ');
/* 131 */       ((IDIPPacket_AqDoZeroprofitRsp)((IDIPCmd_AqDoZeroprofitReq)this.cmd).rsp).head.RetErrMsg = (((AqDoZeroprofitRsp)((IDIPPacket_AqDoZeroprofitRsp)((IDIPCmd_AqDoZeroprofitReq)this.cmd).rsp).body).RetMsg = String.format("reason len > %d", new Object[] { Integer.valueOf(256) }));
/* 132 */       ((IDIPCmd_AqDoZeroprofitReq)this.cmd).sendResponse();
/*     */       
/* 134 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoZeroprofitReq.handle@reason length > MAX_REASON_LEN|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|time=%d|reason=%s|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoZeroprofitRsp)((IDIPCmd_AqDoZeroprofitReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoZeroprofitRsp)((IDIPCmd_AqDoZeroprofitReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((AqDoZeroprofitReq)((IDIPPacket_AqDoZeroprofitReq)((IDIPCmd_AqDoZeroprofitReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoZeroprofitReq)((IDIPPacket_AqDoZeroprofitReq)((IDIPCmd_AqDoZeroprofitReq)this.cmd).req).body).RoleId, Integer.valueOf(((AqDoZeroprofitReq)((IDIPPacket_AqDoZeroprofitReq)((IDIPCmd_AqDoZeroprofitReq)this.cmd).req).body).Time), ((AqDoZeroprofitReq)((IDIPPacket_AqDoZeroprofitReq)((IDIPCmd_AqDoZeroprofitReq)this.cmd).req).body).Reason, Integer.valueOf(((AqDoZeroprofitReq)((IDIPPacket_AqDoZeroprofitReq)((IDIPCmd_AqDoZeroprofitReq)this.cmd).req).body).Source), ((AqDoZeroprofitReq)((IDIPPacket_AqDoZeroprofitReq)((IDIPCmd_AqDoZeroprofitReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 140 */       return false;
/*     */     }
/*     */     
/* 143 */     IdipManager.addZeroProfit(roleId, time, reason);
/*     */     
/* 145 */     ((AqDoZeroprofitRsp)((IDIPPacket_AqDoZeroprofitRsp)((IDIPCmd_AqDoZeroprofitReq)this.cmd).rsp).body).Result = 0;
/* 146 */     ((AqDoZeroprofitRsp)((IDIPPacket_AqDoZeroprofitRsp)((IDIPCmd_AqDoZeroprofitReq)this.cmd).rsp).body).RetMsg = "ok";
/* 147 */     ((IDIPCmd_AqDoZeroprofitReq)this.cmd).sendResponse();
/*     */     
/* 149 */     StringBuilder logStr = new StringBuilder();
/* 150 */     logStr.append(((IDIPPacket_AqDoZeroprofitReq)((IDIPCmd_AqDoZeroprofitReq)this.cmd).req).head.SendTime).append("|");
/* 151 */     logStr.append(((AqDoZeroprofitReq)((IDIPPacket_AqDoZeroprofitReq)((IDIPCmd_AqDoZeroprofitReq)this.cmd).req).body).OpenId).append("|");
/* 152 */     logStr.append(((AqDoZeroprofitReq)((IDIPPacket_AqDoZeroprofitReq)((IDIPCmd_AqDoZeroprofitReq)this.cmd).req).body).AreaId).append("|");
/* 153 */     logStr.append(((AqDoZeroprofitReq)((IDIPPacket_AqDoZeroprofitReq)((IDIPCmd_AqDoZeroprofitReq)this.cmd).req).body).Partition).append("|");
/* 154 */     logStr.append(roleId).append("|");
/* 155 */     logStr.append(0).append("|");
/* 156 */     logStr.append(((AqDoZeroprofitReq)((IDIPPacket_AqDoZeroprofitReq)((IDIPCmd_AqDoZeroprofitReq)this.cmd).req).body).Time).append("|");
/* 157 */     logStr.append(reason).append("|");
/* 158 */     logStr.append(((IDIPPacket_AqDoZeroprofitReq)((IDIPCmd_AqDoZeroprofitReq)this.cmd).req).head.Cmdid).append("|");
/* 159 */     logStr.append(((AqDoZeroprofitReq)((IDIPPacket_AqDoZeroprofitReq)((IDIPCmd_AqDoZeroprofitReq)this.cmd).req).body).Serial).append("|");
/* 160 */     logStr.append(((AqDoZeroprofitReq)((IDIPPacket_AqDoZeroprofitReq)((IDIPCmd_AqDoZeroprofitReq)this.cmd).req).body).Source).append("|");
/* 161 */     logStr.append(((AqDoZeroprofitRsp)((IDIPPacket_AqDoZeroprofitRsp)((IDIPCmd_AqDoZeroprofitReq)this.cmd).rsp).body).Result).append("|");
/* 162 */     logStr.append(((AqDoZeroprofitRsp)((IDIPPacket_AqDoZeroprofitRsp)((IDIPCmd_AqDoZeroprofitReq)this.cmd).rsp).body).RetMsg);
/*     */     
/* 164 */     mzm.gsp.tlog.TLogManager.getInstance().addLog(roleId, "AqIDIPDoZeroProfit", logStr.toString());
/*     */     
/* 166 */     GameServer.logger().info(String.format("[idip]PIDIPCmd_AqDoZeroprofitReq.handle@do zero profit done|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|time=%d|reason=%s|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoZeroprofitRsp)((IDIPCmd_AqDoZeroprofitReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoZeroprofitRsp)((IDIPCmd_AqDoZeroprofitReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((AqDoZeroprofitReq)((IDIPPacket_AqDoZeroprofitReq)((IDIPCmd_AqDoZeroprofitReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoZeroprofitReq)((IDIPPacket_AqDoZeroprofitReq)((IDIPCmd_AqDoZeroprofitReq)this.cmd).req).body).RoleId, Integer.valueOf(((AqDoZeroprofitReq)((IDIPPacket_AqDoZeroprofitReq)((IDIPCmd_AqDoZeroprofitReq)this.cmd).req).body).Time), ((AqDoZeroprofitReq)((IDIPPacket_AqDoZeroprofitReq)((IDIPCmd_AqDoZeroprofitReq)this.cmd).req).body).Reason, Integer.valueOf(((AqDoZeroprofitReq)((IDIPPacket_AqDoZeroprofitReq)((IDIPCmd_AqDoZeroprofitReq)this.cmd).req).body).Source), ((AqDoZeroprofitReq)((IDIPPacket_AqDoZeroprofitReq)((IDIPCmd_AqDoZeroprofitReq)this.cmd).req).body).Serial }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 172 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   protected String getSerialNo()
/*     */   {
/* 178 */     return ((AqDoZeroprofitReq)((IDIPPacket_AqDoZeroprofitReq)((IDIPCmd_AqDoZeroprofitReq)this.cmd).req).body).Serial;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PIDIPCmd_AqDoZeroprofitReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
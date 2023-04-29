/*     */ package mzm.gsp.idip.main;
/*     */ 
/*     */ import idip.AqDoBanAssignPlayReq;
/*     */ import idip.AqDoBanAssignPlayRsp;
/*     */ import idip.IDIPCmd_AqDoBanAssignPlayReq;
/*     */ import idip.IDIPPacket_AqDoBanAssignPlayReq;
/*     */ import idip.IDIPPacket_AqDoBanAssignPlayRsp;
/*     */ import idip.core.IdipHeader;
/*     */ import idip.core.Utils;
/*     */ import mzm.gsp.GameServer;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class PIDIPCmd_AqDoBanAssignPlayReq extends PIDIPCmd<IDIPCmd_AqDoBanAssignPlayReq>
/*     */ {
/*     */   private static final int ALL_TYPE = Integer.MAX_VALUE;
/*     */   
/*     */   public PIDIPCmd_AqDoBanAssignPlayReq(IDIPCmd_AqDoBanAssignPlayReq cmd)
/*     */   {
/*  19 */     super(cmd);
/*     */   }
/*     */   
/*     */   protected boolean handle()
/*     */     throws Exception
/*     */   {
/*  25 */     String openId = ((AqDoBanAssignPlayReq)((IDIPPacket_AqDoBanAssignPlayReq)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).req).body).OpenId;
/*  26 */     int areaId = ((AqDoBanAssignPlayReq)((IDIPPacket_AqDoBanAssignPlayReq)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).req).body).AreaId;
/*  27 */     int partition = ((AqDoBanAssignPlayReq)((IDIPPacket_AqDoBanAssignPlayReq)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).req).body).Partition;
/*     */     
/*  29 */     String userId = Utils.getUserId(openId, areaId, partition);
/*  30 */     xbean.User xUser = xtable.User.get(userId);
/*  31 */     if (null == xUser)
/*     */     {
/*  33 */       ((IDIPPacket_AqDoBanAssignPlayRsp)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).rsp).head.Result = 1;
/*  34 */       ((IDIPPacket_AqDoBanAssignPlayRsp)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).rsp).head.RetErrMsg = "query userid empty";
/*  35 */       ((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).sendResponse();
/*     */       
/*  37 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoBanAssignPlayReq.handle@user not found|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|BanType=%d|BanPlayTime=%d|Reminder=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoBanAssignPlayRsp)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoBanAssignPlayRsp)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((AqDoBanAssignPlayReq)((IDIPPacket_AqDoBanAssignPlayReq)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoBanAssignPlayReq)((IDIPPacket_AqDoBanAssignPlayReq)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).req).body).RoleId, Integer.valueOf(((AqDoBanAssignPlayReq)((IDIPPacket_AqDoBanAssignPlayReq)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).req).body).BanType), Long.valueOf(((AqDoBanAssignPlayReq)((IDIPPacket_AqDoBanAssignPlayReq)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).req).body).BanPlayTime), ((AqDoBanAssignPlayReq)((IDIPPacket_AqDoBanAssignPlayReq)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).req).body).Reminder }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  43 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  47 */     if (((AqDoBanAssignPlayReq)((IDIPPacket_AqDoBanAssignPlayReq)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).req).body).RoleId.length() > 32)
/*     */     {
/*  49 */       ((IDIPPacket_AqDoBanAssignPlayRsp)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).rsp).head.Result = 1;
/*  50 */       ((IDIPPacket_AqDoBanAssignPlayRsp)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).rsp).head.RetErrMsg = String.format("roleid length > %d", new Object[] { Integer.valueOf(32) });
/*  51 */       ((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).sendResponse();
/*     */       
/*  53 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoBanAssignPlayReq.handle@roleId length > MAX_ROLEID_LEN|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|BanType=%d|BanPlayTime=%d|Reminder=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoBanAssignPlayRsp)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoBanAssignPlayRsp)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((AqDoBanAssignPlayReq)((IDIPPacket_AqDoBanAssignPlayReq)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoBanAssignPlayReq)((IDIPPacket_AqDoBanAssignPlayReq)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).req).body).RoleId, Integer.valueOf(((AqDoBanAssignPlayReq)((IDIPPacket_AqDoBanAssignPlayReq)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).req).body).BanType), Long.valueOf(((AqDoBanAssignPlayReq)((IDIPPacket_AqDoBanAssignPlayReq)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).req).body).BanPlayTime), ((AqDoBanAssignPlayReq)((IDIPPacket_AqDoBanAssignPlayReq)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).req).body).Reminder }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  59 */       return false;
/*     */     }
/*     */     
/*  62 */     long roleId = -1L;
/*     */     try
/*     */     {
/*  65 */       roleId = Long.parseLong(((AqDoBanAssignPlayReq)((IDIPPacket_AqDoBanAssignPlayReq)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).req).body).RoleId);
/*     */     }
/*     */     catch (NumberFormatException e)
/*     */     {
/*  69 */       ((IDIPPacket_AqDoBanAssignPlayRsp)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).rsp).head.Result = 1;
/*  70 */       ((IDIPPacket_AqDoBanAssignPlayRsp)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).rsp).head.RetErrMsg = "roleid format error";
/*  71 */       ((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).sendResponse();
/*     */       
/*  73 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoBanAssignPlayReq.handle@role not found|ret=%d|ret_msg=%s|user_id=%s|user_role_list=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|BanType=%d|BanPlayTime=%d|Reminder=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoBanAssignPlayRsp)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoBanAssignPlayRsp)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).rsp).head.RetErrMsg, userId, xUser.getRoleids().toString(), Integer.valueOf(areaId), Byte.valueOf(((AqDoBanAssignPlayReq)((IDIPPacket_AqDoBanAssignPlayReq)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoBanAssignPlayReq)((IDIPPacket_AqDoBanAssignPlayReq)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).req).body).RoleId, Integer.valueOf(((AqDoBanAssignPlayReq)((IDIPPacket_AqDoBanAssignPlayReq)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).req).body).BanType), Long.valueOf(((AqDoBanAssignPlayReq)((IDIPPacket_AqDoBanAssignPlayReq)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).req).body).BanPlayTime), ((AqDoBanAssignPlayReq)((IDIPPacket_AqDoBanAssignPlayReq)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).req).body).Reminder }));
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
/*  84 */       ((IDIPPacket_AqDoBanAssignPlayRsp)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).rsp).head.Result = 1;
/*  85 */       ((IDIPPacket_AqDoBanAssignPlayRsp)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).rsp).head.RetErrMsg = "query roleid empty";
/*  86 */       ((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).sendResponse();
/*     */       
/*  88 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoBanAssignPlayReq.handle@role not found|ret=%d|ret_msg=%s|user_id=%s|user_role_list=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|BanType=%d|BanPlayTime=%d|Reminder=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoBanAssignPlayRsp)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoBanAssignPlayRsp)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).rsp).head.RetErrMsg, userId, xUser.getRoleids().toString(), Integer.valueOf(areaId), Byte.valueOf(((AqDoBanAssignPlayReq)((IDIPPacket_AqDoBanAssignPlayReq)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoBanAssignPlayReq)((IDIPPacket_AqDoBanAssignPlayReq)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).req).body).RoleId, Integer.valueOf(((AqDoBanAssignPlayReq)((IDIPPacket_AqDoBanAssignPlayReq)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).req).body).BanType), Long.valueOf(((AqDoBanAssignPlayReq)((IDIPPacket_AqDoBanAssignPlayReq)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).req).body).BanPlayTime), ((AqDoBanAssignPlayReq)((IDIPPacket_AqDoBanAssignPlayReq)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).req).body).Reminder }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  94 */       return false;
/*     */     }
/*     */     
/*  97 */     long banPlayTime = ((AqDoBanAssignPlayReq)((IDIPPacket_AqDoBanAssignPlayReq)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).req).body).BanPlayTime;
/*  98 */     if (banPlayTime <= 0L)
/*     */     {
/* 100 */       ((IDIPPacket_AqDoBanAssignPlayRsp)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).rsp).head.Result = (((AqDoBanAssignPlayRsp)((IDIPPacket_AqDoBanAssignPlayRsp)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).rsp).body).Result = 'ﭣ');
/* 101 */       ((IDIPPacket_AqDoBanAssignPlayRsp)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).rsp).head.RetErrMsg = (((AqDoBanAssignPlayRsp)((IDIPPacket_AqDoBanAssignPlayRsp)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).rsp).body).RetMsg = "time must > 0");
/* 102 */       ((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).sendResponse();
/*     */       
/* 104 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoBanAssignPlayReq.handle@time <= 0|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|BanType=%d|BanPlayTime=%d|Reminder=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoBanAssignPlayRsp)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoBanAssignPlayRsp)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((AqDoBanAssignPlayReq)((IDIPPacket_AqDoBanAssignPlayReq)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoBanAssignPlayReq)((IDIPPacket_AqDoBanAssignPlayReq)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).req).body).RoleId, Integer.valueOf(((AqDoBanAssignPlayReq)((IDIPPacket_AqDoBanAssignPlayReq)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).req).body).BanType), Long.valueOf(((AqDoBanAssignPlayReq)((IDIPPacket_AqDoBanAssignPlayReq)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).req).body).BanPlayTime), ((AqDoBanAssignPlayReq)((IDIPPacket_AqDoBanAssignPlayReq)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).req).body).Reminder }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 110 */       return false;
/*     */     }
/*     */     
/* 113 */     String reminder = Utils.urlDecode1738(((AqDoBanAssignPlayReq)((IDIPPacket_AqDoBanAssignPlayReq)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).req).body).Reminder);
/* 114 */     if (reminder.isEmpty())
/*     */     {
/* 116 */       ((IDIPPacket_AqDoBanAssignPlayRsp)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).rsp).head.Result = (((AqDoBanAssignPlayRsp)((IDIPPacket_AqDoBanAssignPlayRsp)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).rsp).body).Result = 'ﭤ');
/* 117 */       ((IDIPPacket_AqDoBanAssignPlayRsp)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).rsp).head.RetErrMsg = (((AqDoBanAssignPlayRsp)((IDIPPacket_AqDoBanAssignPlayRsp)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).rsp).body).RetMsg = "reminder is empty");
/* 118 */       ((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).sendResponse();
/*     */       
/* 120 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoBanAssignPlayReq.handle@reminder is empty|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|BanType=%d|BanPlayTime=%d|Reminder=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoBanAssignPlayRsp)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoBanAssignPlayRsp)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((AqDoBanAssignPlayReq)((IDIPPacket_AqDoBanAssignPlayReq)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoBanAssignPlayReq)((IDIPPacket_AqDoBanAssignPlayReq)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).req).body).RoleId, Integer.valueOf(((AqDoBanAssignPlayReq)((IDIPPacket_AqDoBanAssignPlayReq)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).req).body).BanType), Long.valueOf(((AqDoBanAssignPlayReq)((IDIPPacket_AqDoBanAssignPlayReq)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).req).body).BanPlayTime), ((AqDoBanAssignPlayReq)((IDIPPacket_AqDoBanAssignPlayReq)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).req).body).Reminder }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 126 */       return false;
/*     */     }
/* 128 */     if (reminder.length() > 300)
/*     */     {
/* 130 */       ((IDIPPacket_AqDoBanAssignPlayRsp)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).rsp).head.Result = (((AqDoBanAssignPlayRsp)((IDIPPacket_AqDoBanAssignPlayRsp)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).rsp).body).Result = 'ﭤ');
/* 131 */       ((IDIPPacket_AqDoBanAssignPlayRsp)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).rsp).head.RetErrMsg = (((AqDoBanAssignPlayRsp)((IDIPPacket_AqDoBanAssignPlayRsp)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).rsp).body).RetMsg = String.format("reminder length > %d", new Object[] { Integer.valueOf(300) }));
/*     */       
/* 133 */       ((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).sendResponse();
/*     */       
/* 135 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoBanAssignPlayReq.handle@reminder length > MAX_REMINDER_LEN|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|BanType=%d|BanPlayTime=%d|Reminder=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoBanAssignPlayRsp)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoBanAssignPlayRsp)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((AqDoBanAssignPlayReq)((IDIPPacket_AqDoBanAssignPlayReq)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoBanAssignPlayReq)((IDIPPacket_AqDoBanAssignPlayReq)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).req).body).RoleId, Integer.valueOf(((AqDoBanAssignPlayReq)((IDIPPacket_AqDoBanAssignPlayReq)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).req).body).BanType), Long.valueOf(((AqDoBanAssignPlayReq)((IDIPPacket_AqDoBanAssignPlayReq)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).req).body).BanPlayTime), ((AqDoBanAssignPlayReq)((IDIPPacket_AqDoBanAssignPlayReq)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).req).body).Reminder }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 141 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 145 */     int banType = ((AqDoBanAssignPlayReq)((IDIPPacket_AqDoBanAssignPlayReq)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).req).body).BanType;
/* 146 */     if (((banType < 0) || (banType > 592)) && (banType != Integer.MAX_VALUE))
/*     */     {
/* 148 */       ((IDIPPacket_AqDoBanAssignPlayRsp)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).rsp).head.Result = (((AqDoBanAssignPlayRsp)((IDIPPacket_AqDoBanAssignPlayRsp)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).rsp).body).Result = 'ﭢ');
/* 149 */       ((IDIPPacket_AqDoBanAssignPlayRsp)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).rsp).head.RetErrMsg = (((AqDoBanAssignPlayRsp)((IDIPPacket_AqDoBanAssignPlayRsp)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).rsp).body).RetMsg = "ban_type not exist");
/* 150 */       ((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).sendResponse();
/*     */       
/* 152 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoBanAssignPlayReq.handle@ban_type not exist|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|BanType=%d|BanPlayTime=%d|Reminder=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoBanAssignPlayRsp)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoBanAssignPlayRsp)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((AqDoBanAssignPlayReq)((IDIPPacket_AqDoBanAssignPlayReq)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoBanAssignPlayReq)((IDIPPacket_AqDoBanAssignPlayReq)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).req).body).RoleId, Integer.valueOf(((AqDoBanAssignPlayReq)((IDIPPacket_AqDoBanAssignPlayReq)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).req).body).BanType), Long.valueOf(((AqDoBanAssignPlayReq)((IDIPPacket_AqDoBanAssignPlayReq)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).req).body).BanPlayTime), ((AqDoBanAssignPlayReq)((IDIPPacket_AqDoBanAssignPlayReq)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).req).body).Reminder }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 158 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 162 */     if (banType == Integer.MAX_VALUE)
/*     */     {
/* 164 */       IdipManager.banPlayAll(roleId, (int)banPlayTime, reminder);
/*     */     }
/*     */     else
/*     */     {
/* 168 */       IdipManager.addBanPlay(roleId, banType, (int)banPlayTime, reminder);
/*     */     }
/*     */     
/* 171 */     ((AqDoBanAssignPlayRsp)((IDIPPacket_AqDoBanAssignPlayRsp)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).rsp).body).Result = 0;
/* 172 */     ((AqDoBanAssignPlayRsp)((IDIPPacket_AqDoBanAssignPlayRsp)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).rsp).body).RetMsg = "ok";
/* 173 */     ((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).sendResponse();
/*     */     
/* 175 */     StringBuilder logStr = new StringBuilder();
/* 176 */     logStr.append(((IDIPPacket_AqDoBanAssignPlayReq)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).req).head.SendTime).append("|");
/* 177 */     logStr.append(((AqDoBanAssignPlayReq)((IDIPPacket_AqDoBanAssignPlayReq)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).req).body).OpenId).append("|");
/* 178 */     logStr.append(((AqDoBanAssignPlayReq)((IDIPPacket_AqDoBanAssignPlayReq)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).req).body).AreaId).append("|");
/* 179 */     logStr.append(((AqDoBanAssignPlayReq)((IDIPPacket_AqDoBanAssignPlayReq)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).req).body).Partition).append("|");
/* 180 */     logStr.append(roleId).append("|");
/* 181 */     logStr.append(0).append("|");
/* 182 */     logStr.append(((AqDoBanAssignPlayReq)((IDIPPacket_AqDoBanAssignPlayReq)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).req).body).BanType).append("|");
/* 183 */     logStr.append(((AqDoBanAssignPlayReq)((IDIPPacket_AqDoBanAssignPlayReq)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).req).body).BanPlayTime).append("|");
/* 184 */     logStr.append(((AqDoBanAssignPlayReq)((IDIPPacket_AqDoBanAssignPlayReq)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).req).body).Reminder).append("|");
/* 185 */     logStr.append(((IDIPPacket_AqDoBanAssignPlayReq)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).req).head.Cmdid).append("|");
/* 186 */     logStr.append(((AqDoBanAssignPlayRsp)((IDIPPacket_AqDoBanAssignPlayRsp)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).rsp).body).Result).append("|");
/* 187 */     logStr.append(((AqDoBanAssignPlayRsp)((IDIPPacket_AqDoBanAssignPlayRsp)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).rsp).body).RetMsg);
/*     */     
/* 189 */     mzm.gsp.tlog.TLogManager.getInstance().addLog(roleId, "AqIDIPDoBanAssignPlay", logStr.toString());
/*     */     
/* 191 */     GameServer.logger().info(String.format("[idip]PIDIPCmd_AqDoBanAssignPlayReq.handle@do ban play done|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|BanType=%d|BanPlayTime=%d|Reminder=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoBanAssignPlayRsp)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoBanAssignPlayRsp)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((AqDoBanAssignPlayReq)((IDIPPacket_AqDoBanAssignPlayReq)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoBanAssignPlayReq)((IDIPPacket_AqDoBanAssignPlayReq)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).req).body).RoleId, Integer.valueOf(((AqDoBanAssignPlayReq)((IDIPPacket_AqDoBanAssignPlayReq)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).req).body).BanType), Long.valueOf(((AqDoBanAssignPlayReq)((IDIPPacket_AqDoBanAssignPlayReq)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).req).body).BanPlayTime), ((AqDoBanAssignPlayReq)((IDIPPacket_AqDoBanAssignPlayReq)((IDIPCmd_AqDoBanAssignPlayReq)this.cmd).req).body).Reminder }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 198 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PIDIPCmd_AqDoBanAssignPlayReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
/*     */ package mzm.gsp.idip.main;
/*     */ 
/*     */ import idip.IDIPCmd_QueryOwnXianlvReq;
/*     */ import idip.IDIPPacket_QueryOwnXianlvReq;
/*     */ import idip.IDIPPacket_QueryOwnXianlvRsp;
/*     */ import idip.QueryOwnXianlvReq;
/*     */ import idip.QueryOwnXianlvRsp;
/*     */ import idip.core.IdipHeader;
/*     */ import mzm.gsp.GameServer;
/*     */ 
/*     */ public class PIDIPCmd_QueryOwnXianlvReq extends PIDIPCmd<IDIPCmd_QueryOwnXianlvReq>
/*     */ {
/*     */   public PIDIPCmd_QueryOwnXianlvReq(IDIPCmd_QueryOwnXianlvReq cmd)
/*     */   {
/*  15 */     super(cmd);
/*     */   }
/*     */   
/*     */   protected boolean handle()
/*     */     throws Exception
/*     */   {
/*  21 */     String openId = ((QueryOwnXianlvReq)((IDIPPacket_QueryOwnXianlvReq)((IDIPCmd_QueryOwnXianlvReq)this.cmd).req).body).OpenId;
/*  22 */     int areaId = ((QueryOwnXianlvReq)((IDIPPacket_QueryOwnXianlvReq)((IDIPCmd_QueryOwnXianlvReq)this.cmd).req).body).AreaId;
/*  23 */     int partition = ((QueryOwnXianlvReq)((IDIPPacket_QueryOwnXianlvReq)((IDIPCmd_QueryOwnXianlvReq)this.cmd).req).body).Partition;
/*     */     
/*  25 */     String userId = idip.core.Utils.getUserId(openId, areaId, partition);
/*  26 */     xbean.User xUser = xtable.User.get(userId);
/*  27 */     if (null == xUser)
/*     */     {
/*  29 */       ((IDIPPacket_QueryOwnXianlvRsp)((IDIPCmd_QueryOwnXianlvReq)this.cmd).rsp).head.Result = (((QueryOwnXianlvRsp)((IDIPPacket_QueryOwnXianlvRsp)((IDIPCmd_QueryOwnXianlvReq)this.cmd).rsp).body).Result = 1);
/*  30 */       ((IDIPPacket_QueryOwnXianlvRsp)((IDIPCmd_QueryOwnXianlvReq)this.cmd).rsp).head.RetErrMsg = (((QueryOwnXianlvRsp)((IDIPPacket_QueryOwnXianlvRsp)((IDIPCmd_QueryOwnXianlvReq)this.cmd).rsp).body).RetMsg = "query userid empty");
/*  31 */       ((IDIPCmd_QueryOwnXianlvReq)this.cmd).sendResponse();
/*     */       
/*  33 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_QueryOwnXianlvReq.handle@user not found|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|partition=%d|plat_id=%d|open_id=%s|role_id=%s|xian_lv_id=%s", new Object[] { Integer.valueOf(((IDIPPacket_QueryOwnXianlvRsp)((IDIPCmd_QueryOwnXianlvReq)this.cmd).rsp).head.Result), ((IDIPPacket_QueryOwnXianlvRsp)((IDIPCmd_QueryOwnXianlvReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Integer.valueOf(partition), Byte.valueOf(((QueryOwnXianlvReq)((IDIPPacket_QueryOwnXianlvReq)((IDIPCmd_QueryOwnXianlvReq)this.cmd).req).body).PlatId), openId, ((QueryOwnXianlvReq)((IDIPPacket_QueryOwnXianlvReq)((IDIPCmd_QueryOwnXianlvReq)this.cmd).req).body).RoleId, ((QueryOwnXianlvReq)((IDIPPacket_QueryOwnXianlvReq)((IDIPCmd_QueryOwnXianlvReq)this.cmd).req).body).XianLvId }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  38 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  42 */     if (((QueryOwnXianlvReq)((IDIPPacket_QueryOwnXianlvReq)((IDIPCmd_QueryOwnXianlvReq)this.cmd).req).body).RoleId.length() > 32)
/*     */     {
/*  44 */       ((IDIPPacket_QueryOwnXianlvRsp)((IDIPCmd_QueryOwnXianlvReq)this.cmd).rsp).head.Result = (((QueryOwnXianlvRsp)((IDIPPacket_QueryOwnXianlvRsp)((IDIPCmd_QueryOwnXianlvReq)this.cmd).rsp).body).Result = 1);
/*  45 */       ((IDIPPacket_QueryOwnXianlvRsp)((IDIPCmd_QueryOwnXianlvReq)this.cmd).rsp).head.RetErrMsg = (((QueryOwnXianlvRsp)((IDIPPacket_QueryOwnXianlvRsp)((IDIPCmd_QueryOwnXianlvReq)this.cmd).rsp).body).RetMsg = String.format("roleid length > %d", new Object[] { Integer.valueOf(32) }));
/*     */       
/*  47 */       ((IDIPCmd_QueryOwnXianlvReq)this.cmd).sendResponse();
/*     */       
/*  49 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_QueryOwnXianlvReq.handle@roleId length > MAX_ROLEID_LEN|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|partition=%d|plat_id=%d|open_id=%s|role_id=%s|xian_lv_id=%s", new Object[] { Integer.valueOf(((IDIPPacket_QueryOwnXianlvRsp)((IDIPCmd_QueryOwnXianlvReq)this.cmd).rsp).head.Result), ((IDIPPacket_QueryOwnXianlvRsp)((IDIPCmd_QueryOwnXianlvReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Integer.valueOf(partition), Byte.valueOf(((QueryOwnXianlvReq)((IDIPPacket_QueryOwnXianlvReq)((IDIPCmd_QueryOwnXianlvReq)this.cmd).req).body).PlatId), openId, ((QueryOwnXianlvReq)((IDIPPacket_QueryOwnXianlvReq)((IDIPCmd_QueryOwnXianlvReq)this.cmd).req).body).RoleId, ((QueryOwnXianlvReq)((IDIPPacket_QueryOwnXianlvReq)((IDIPCmd_QueryOwnXianlvReq)this.cmd).req).body).XianLvId }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  54 */       return false;
/*     */     }
/*     */     
/*  57 */     long roleId = -1L;
/*     */     try
/*     */     {
/*  60 */       roleId = Long.parseLong(((QueryOwnXianlvReq)((IDIPPacket_QueryOwnXianlvReq)((IDIPCmd_QueryOwnXianlvReq)this.cmd).req).body).RoleId);
/*     */     }
/*     */     catch (NumberFormatException e)
/*     */     {
/*  64 */       ((IDIPPacket_QueryOwnXianlvRsp)((IDIPCmd_QueryOwnXianlvReq)this.cmd).rsp).head.Result = (((QueryOwnXianlvRsp)((IDIPPacket_QueryOwnXianlvRsp)((IDIPCmd_QueryOwnXianlvReq)this.cmd).rsp).body).Result = 1);
/*  65 */       ((IDIPPacket_QueryOwnXianlvRsp)((IDIPCmd_QueryOwnXianlvReq)this.cmd).rsp).head.RetErrMsg = (((QueryOwnXianlvRsp)((IDIPPacket_QueryOwnXianlvRsp)((IDIPCmd_QueryOwnXianlvReq)this.cmd).rsp).body).RetMsg = "roleid format error");
/*  66 */       ((IDIPCmd_QueryOwnXianlvReq)this.cmd).sendResponse();
/*     */       
/*  68 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_QueryOwnXianlvReq.handle@role not found|ret=%d|ret_msg=%s|user_id=%s|user_role_list=%s|area_id=%d|partition=%d|plat_id=%d|open_id=%s|role_id=%s|xian_lv_id=%s", new Object[] { Integer.valueOf(((IDIPPacket_QueryOwnXianlvRsp)((IDIPCmd_QueryOwnXianlvReq)this.cmd).rsp).head.Result), ((IDIPPacket_QueryOwnXianlvRsp)((IDIPCmd_QueryOwnXianlvReq)this.cmd).rsp).head.RetErrMsg, userId, xUser.getRoleids().toString(), Integer.valueOf(areaId), Integer.valueOf(partition), Byte.valueOf(((QueryOwnXianlvReq)((IDIPPacket_QueryOwnXianlvReq)((IDIPCmd_QueryOwnXianlvReq)this.cmd).req).body).PlatId), openId, ((QueryOwnXianlvReq)((IDIPPacket_QueryOwnXianlvReq)((IDIPCmd_QueryOwnXianlvReq)this.cmd).req).body).RoleId, ((QueryOwnXianlvReq)((IDIPPacket_QueryOwnXianlvReq)((IDIPCmd_QueryOwnXianlvReq)this.cmd).req).body).XianLvId }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  74 */       return false;
/*     */     }
/*     */     
/*  77 */     if ((!mzm.gsp.role.main.RoleInterface.isRoleExist(roleId, true)) || (!xUser.getRoleids().contains(Long.valueOf(roleId))))
/*     */     {
/*  79 */       ((IDIPPacket_QueryOwnXianlvRsp)((IDIPCmd_QueryOwnXianlvReq)this.cmd).rsp).head.Result = (((QueryOwnXianlvRsp)((IDIPPacket_QueryOwnXianlvRsp)((IDIPCmd_QueryOwnXianlvReq)this.cmd).rsp).body).Result = 1);
/*  80 */       ((IDIPPacket_QueryOwnXianlvRsp)((IDIPCmd_QueryOwnXianlvReq)this.cmd).rsp).head.RetErrMsg = (((QueryOwnXianlvRsp)((IDIPPacket_QueryOwnXianlvRsp)((IDIPCmd_QueryOwnXianlvReq)this.cmd).rsp).body).RetMsg = "query roleid empty");
/*  81 */       ((IDIPCmd_QueryOwnXianlvReq)this.cmd).sendResponse();
/*     */       
/*  83 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_QueryOwnXianlvReq.handle@role not found|ret=%d|ret_msg=%s|user_id=%s|user_role_list=%s|area_id=%d|partition=%d|plat_id=%d|open_id=%s|role_id=%s|xian_lv_id=%s", new Object[] { Integer.valueOf(((IDIPPacket_QueryOwnXianlvRsp)((IDIPCmd_QueryOwnXianlvReq)this.cmd).rsp).head.Result), ((IDIPPacket_QueryOwnXianlvRsp)((IDIPCmd_QueryOwnXianlvReq)this.cmd).rsp).head.RetErrMsg, userId, xUser.getRoleids().toString(), Integer.valueOf(areaId), Integer.valueOf(partition), Byte.valueOf(((QueryOwnXianlvReq)((IDIPPacket_QueryOwnXianlvReq)((IDIPCmd_QueryOwnXianlvReq)this.cmd).req).body).PlatId), openId, ((QueryOwnXianlvReq)((IDIPPacket_QueryOwnXianlvReq)((IDIPCmd_QueryOwnXianlvReq)this.cmd).req).body).RoleId, ((QueryOwnXianlvReq)((IDIPPacket_QueryOwnXianlvReq)((IDIPCmd_QueryOwnXianlvReq)this.cmd).req).body).XianLvId }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  89 */       return false;
/*     */     }
/*     */     
/*  92 */     if ((((QueryOwnXianlvReq)((IDIPPacket_QueryOwnXianlvReq)((IDIPCmd_QueryOwnXianlvReq)this.cmd).req).body).XianLvId.length() > 64) || (((QueryOwnXianlvReq)((IDIPPacket_QueryOwnXianlvReq)((IDIPCmd_QueryOwnXianlvReq)this.cmd).req).body).XianLvId.isEmpty()))
/*     */     {
/*  94 */       ((IDIPPacket_QueryOwnXianlvRsp)((IDIPCmd_QueryOwnXianlvReq)this.cmd).rsp).head.Result = (((IDIPPacket_QueryOwnXianlvRsp)((IDIPCmd_QueryOwnXianlvReq)this.cmd).rsp).head.Result = 'ﬀ');
/*  95 */       ((IDIPPacket_QueryOwnXianlvRsp)((IDIPCmd_QueryOwnXianlvReq)this.cmd).rsp).head.RetErrMsg = (((QueryOwnXianlvRsp)((IDIPPacket_QueryOwnXianlvRsp)((IDIPCmd_QueryOwnXianlvReq)this.cmd).rsp).body).RetMsg = "xian_lv_id length invalid");
/*  96 */       ((IDIPCmd_QueryOwnXianlvReq)this.cmd).sendResponse();
/*     */       
/*  98 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_QueryOwnXianlvReq.handle@xian_lv_id length invalid|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|partition=%d|plat_id=%d|open_id=%s|role_id=%s|xian_lv_id=%s", new Object[] { Integer.valueOf(((IDIPPacket_QueryOwnXianlvRsp)((IDIPCmd_QueryOwnXianlvReq)this.cmd).rsp).head.Result), ((IDIPPacket_QueryOwnXianlvRsp)((IDIPCmd_QueryOwnXianlvReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Integer.valueOf(partition), Byte.valueOf(((QueryOwnXianlvReq)((IDIPPacket_QueryOwnXianlvReq)((IDIPCmd_QueryOwnXianlvReq)this.cmd).req).body).PlatId), openId, ((QueryOwnXianlvReq)((IDIPPacket_QueryOwnXianlvReq)((IDIPCmd_QueryOwnXianlvReq)this.cmd).req).body).RoleId, ((QueryOwnXianlvReq)((IDIPPacket_QueryOwnXianlvReq)((IDIPCmd_QueryOwnXianlvReq)this.cmd).req).body).XianLvId }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 103 */       return false;
/*     */     }
/*     */     
/* 106 */     int xianLvid = -1;
/*     */     try
/*     */     {
/* 109 */       xianLvid = Integer.parseInt(((QueryOwnXianlvReq)((IDIPPacket_QueryOwnXianlvReq)((IDIPCmd_QueryOwnXianlvReq)this.cmd).req).body).XianLvId);
/*     */     }
/*     */     catch (NumberFormatException e)
/*     */     {
/* 113 */       ((IDIPPacket_QueryOwnXianlvRsp)((IDIPCmd_QueryOwnXianlvReq)this.cmd).rsp).head.Result = (((QueryOwnXianlvRsp)((IDIPPacket_QueryOwnXianlvRsp)((IDIPCmd_QueryOwnXianlvReq)this.cmd).rsp).body).Result = '﫿');
/* 114 */       ((IDIPPacket_QueryOwnXianlvRsp)((IDIPCmd_QueryOwnXianlvReq)this.cmd).rsp).head.RetErrMsg = (((QueryOwnXianlvRsp)((IDIPPacket_QueryOwnXianlvRsp)((IDIPCmd_QueryOwnXianlvReq)this.cmd).rsp).body).RetMsg = "xian_lv_id format error");
/* 115 */       ((IDIPCmd_QueryOwnXianlvReq)this.cmd).sendResponse();
/*     */       
/* 117 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_QueryOwnXianlvReq.handle@xian_lv_id format error|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|partition=%d|plat_id=%d|open_id=%s|role_id=%s|xian_lv_id=%s", new Object[] { Integer.valueOf(((IDIPPacket_QueryOwnXianlvRsp)((IDIPCmd_QueryOwnXianlvReq)this.cmd).rsp).head.Result), ((IDIPPacket_QueryOwnXianlvRsp)((IDIPCmd_QueryOwnXianlvReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Integer.valueOf(partition), Byte.valueOf(((QueryOwnXianlvReq)((IDIPPacket_QueryOwnXianlvReq)((IDIPCmd_QueryOwnXianlvReq)this.cmd).req).body).PlatId), openId, ((QueryOwnXianlvReq)((IDIPPacket_QueryOwnXianlvReq)((IDIPCmd_QueryOwnXianlvReq)this.cmd).req).body).RoleId, ((QueryOwnXianlvReq)((IDIPPacket_QueryOwnXianlvReq)((IDIPCmd_QueryOwnXianlvReq)this.cmd).req).body).XianLvId }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 122 */       return false;
/*     */     }
/*     */     
/* 125 */     boolean own = mzm.gsp.partner.main.PartnerInterface.ownPartner(roleId, xianLvid);
/* 126 */     if (own)
/*     */     {
/* 128 */       ((IDIPPacket_QueryOwnXianlvRsp)((IDIPCmd_QueryOwnXianlvReq)this.cmd).rsp).head.Result = (((QueryOwnXianlvRsp)((IDIPPacket_QueryOwnXianlvRsp)((IDIPCmd_QueryOwnXianlvReq)this.cmd).rsp).body).Result = 0);
/* 129 */       ((IDIPPacket_QueryOwnXianlvRsp)((IDIPCmd_QueryOwnXianlvReq)this.cmd).rsp).head.RetErrMsg = (((QueryOwnXianlvRsp)((IDIPPacket_QueryOwnXianlvRsp)((IDIPCmd_QueryOwnXianlvReq)this.cmd).rsp).body).RetMsg = "ok");
/*     */     }
/*     */     else
/*     */     {
/* 133 */       ((IDIPPacket_QueryOwnXianlvRsp)((IDIPCmd_QueryOwnXianlvReq)this.cmd).rsp).head.Result = (((QueryOwnXianlvRsp)((IDIPPacket_QueryOwnXianlvRsp)((IDIPCmd_QueryOwnXianlvReq)this.cmd).rsp).body).Result = '﫾');
/* 134 */       ((IDIPPacket_QueryOwnXianlvRsp)((IDIPCmd_QueryOwnXianlvReq)this.cmd).rsp).head.RetErrMsg = (((QueryOwnXianlvRsp)((IDIPPacket_QueryOwnXianlvRsp)((IDIPCmd_QueryOwnXianlvReq)this.cmd).rsp).body).RetMsg = "no one");
/*     */     }
/*     */     
/* 137 */     ((IDIPCmd_QueryOwnXianlvReq)this.cmd).sendResponse();
/*     */     
/* 139 */     GameServer.logger().info(String.format("[idip]PIDIPCmd_QueryOwnXianlvReq.handle@query own xian_lv success|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|partition=%d|plat_id=%d|open_id=%s|role_id=%s|xian_lv_id=%s|own=%b", new Object[] { Integer.valueOf(((IDIPPacket_QueryOwnXianlvRsp)((IDIPCmd_QueryOwnXianlvReq)this.cmd).rsp).head.Result), ((IDIPPacket_QueryOwnXianlvRsp)((IDIPCmd_QueryOwnXianlvReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Integer.valueOf(partition), Byte.valueOf(((QueryOwnXianlvReq)((IDIPPacket_QueryOwnXianlvReq)((IDIPCmd_QueryOwnXianlvReq)this.cmd).req).body).PlatId), openId, ((QueryOwnXianlvReq)((IDIPPacket_QueryOwnXianlvReq)((IDIPCmd_QueryOwnXianlvReq)this.cmd).req).body).RoleId, ((QueryOwnXianlvReq)((IDIPPacket_QueryOwnXianlvReq)((IDIPCmd_QueryOwnXianlvReq)this.cmd).req).body).XianLvId, Boolean.valueOf(own) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 144 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PIDIPCmd_QueryOwnXianlvReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
/*     */ package mzm.gsp.idip.main;
/*     */ 
/*     */ import idip.DoBanUsrReq;
/*     */ import idip.DoBanUsrRsp;
/*     */ import idip.IDIPCmd_DoBanUsrReq;
/*     */ import idip.IDIPPacket_DoBanUsrReq;
/*     */ import idip.IDIPPacket_DoBanUsrRsp;
/*     */ import idip.core.IdipHeader;
/*     */ import idip.core.Utils;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.online.main.ForbidInfoManager;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class PIDIPCmd_DoBanUsrReq extends PIDIPCmd<IDIPCmd_DoBanUsrReq>
/*     */ {
/*     */   public PIDIPCmd_DoBanUsrReq(IDIPCmd_DoBanUsrReq cmd)
/*     */   {
/*  18 */     super(cmd);
/*     */   }
/*     */   
/*     */   protected boolean handle()
/*     */     throws Exception
/*     */   {
/*  24 */     String openId = ((DoBanUsrReq)((IDIPPacket_DoBanUsrReq)((IDIPCmd_DoBanUsrReq)this.cmd).req).body).OpenId;
/*  25 */     int areaId = ((DoBanUsrReq)((IDIPPacket_DoBanUsrReq)((IDIPCmd_DoBanUsrReq)this.cmd).req).body).AreaId;
/*  26 */     int partition = ((DoBanUsrReq)((IDIPPacket_DoBanUsrReq)((IDIPCmd_DoBanUsrReq)this.cmd).req).body).Partition;
/*     */     
/*  28 */     String userId = Utils.getUserId(openId, areaId, partition);
/*  29 */     xbean.User xUser = xtable.User.get(userId);
/*  30 */     if (null == xUser)
/*     */     {
/*  32 */       ((IDIPPacket_DoBanUsrRsp)((IDIPCmd_DoBanUsrReq)this.cmd).rsp).head.Result = 64482;
/*  33 */       ((IDIPPacket_DoBanUsrRsp)((IDIPCmd_DoBanUsrReq)this.cmd).rsp).head.RetErrMsg = "query userid empty";
/*  34 */       ((IDIPCmd_DoBanUsrReq)this.cmd).sendResponse();
/*     */       
/*  36 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoBanUsrReq.handle@user not found|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|role_id=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoBanUsrRsp)((IDIPCmd_DoBanUsrReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoBanUsrRsp)((IDIPCmd_DoBanUsrReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((DoBanUsrReq)((IDIPPacket_DoBanUsrReq)((IDIPCmd_DoBanUsrReq)this.cmd).req).body).PlatId), ((DoBanUsrReq)((IDIPPacket_DoBanUsrReq)((IDIPCmd_DoBanUsrReq)this.cmd).req).body).RoleId }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  41 */       return false;
/*     */     }
/*     */     
/*  44 */     boolean result = false;
/*     */     
/*  46 */     if (!((DoBanUsrReq)((IDIPPacket_DoBanUsrReq)((IDIPCmd_DoBanUsrReq)this.cmd).req).body).RoleId.isEmpty())
/*     */     {
/*  48 */       result = banRole(xUser);
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/*  53 */       result = banUser(userId);
/*     */     }
/*  55 */     return result;
/*     */   }
/*     */   
/*     */ 
/*     */   private boolean banRole(xbean.User xUser)
/*     */   {
/*  61 */     if (((DoBanUsrReq)((IDIPPacket_DoBanUsrReq)((IDIPCmd_DoBanUsrReq)this.cmd).req).body).RoleId.length() > 32)
/*     */     {
/*  63 */       ((IDIPPacket_DoBanUsrRsp)((IDIPCmd_DoBanUsrReq)this.cmd).rsp).head.Result = (((DoBanUsrRsp)((IDIPPacket_DoBanUsrRsp)((IDIPCmd_DoBanUsrReq)this.cmd).rsp).body).Result = 1);
/*  64 */       ((IDIPPacket_DoBanUsrRsp)((IDIPCmd_DoBanUsrReq)this.cmd).rsp).head.RetErrMsg = (((DoBanUsrRsp)((IDIPPacket_DoBanUsrRsp)((IDIPCmd_DoBanUsrReq)this.cmd).rsp).body).RetMsg = String.format("roleid length > %d", new Object[] { Integer.valueOf(32) }));
/*     */       
/*  66 */       ((IDIPCmd_DoBanUsrReq)this.cmd).sendResponse();
/*     */       
/*  68 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoBanUsrReq.banRole@roleId length > MAX_ROLEID_LEN|ret=%d|ret_msg=%s|open_id=%s|area_id=%d|partition=%d|plat_id=%d|user_role_list=%s|role_id=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoBanUsrRsp)((IDIPCmd_DoBanUsrReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoBanUsrRsp)((IDIPCmd_DoBanUsrReq)this.cmd).rsp).head.RetErrMsg, ((DoBanUsrReq)((IDIPPacket_DoBanUsrReq)((IDIPCmd_DoBanUsrReq)this.cmd).req).body).OpenId, Integer.valueOf(((DoBanUsrReq)((IDIPPacket_DoBanUsrReq)((IDIPCmd_DoBanUsrReq)this.cmd).req).body).AreaId), Integer.valueOf(((DoBanUsrReq)((IDIPPacket_DoBanUsrReq)((IDIPCmd_DoBanUsrReq)this.cmd).req).body).Partition), Byte.valueOf(((DoBanUsrReq)((IDIPPacket_DoBanUsrReq)((IDIPCmd_DoBanUsrReq)this.cmd).req).body).PlatId), xUser.getRoleids().toString(), ((DoBanUsrReq)((IDIPPacket_DoBanUsrReq)((IDIPCmd_DoBanUsrReq)this.cmd).req).body).RoleId }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  74 */       return false;
/*     */     }
/*     */     
/*  77 */     long roleId = -1L;
/*     */     try
/*     */     {
/*  80 */       roleId = Long.parseLong(((DoBanUsrReq)((IDIPPacket_DoBanUsrReq)((IDIPCmd_DoBanUsrReq)this.cmd).req).body).RoleId);
/*     */     }
/*     */     catch (NumberFormatException e)
/*     */     {
/*  84 */       ((IDIPPacket_DoBanUsrRsp)((IDIPCmd_DoBanUsrReq)this.cmd).rsp).head.Result = (((DoBanUsrRsp)((IDIPPacket_DoBanUsrRsp)((IDIPCmd_DoBanUsrReq)this.cmd).rsp).body).Result = 1);
/*  85 */       ((IDIPPacket_DoBanUsrRsp)((IDIPCmd_DoBanUsrReq)this.cmd).rsp).head.RetErrMsg = (((DoBanUsrRsp)((IDIPPacket_DoBanUsrRsp)((IDIPCmd_DoBanUsrReq)this.cmd).rsp).body).RetMsg = "roleid format error");
/*  86 */       ((IDIPCmd_DoBanUsrReq)this.cmd).sendResponse();
/*  87 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoBanUsrReq.banRole@role not found or not match|ret=%d|ret_msg=%s|open_id=%s|area_id=%d|partition=%d|plat_id=%d|user_role_list=%s|role_id=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoBanUsrRsp)((IDIPCmd_DoBanUsrReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoBanUsrRsp)((IDIPCmd_DoBanUsrReq)this.cmd).rsp).head.RetErrMsg, ((DoBanUsrReq)((IDIPPacket_DoBanUsrReq)((IDIPCmd_DoBanUsrReq)this.cmd).req).body).OpenId, Integer.valueOf(((DoBanUsrReq)((IDIPPacket_DoBanUsrReq)((IDIPCmd_DoBanUsrReq)this.cmd).req).body).AreaId), Integer.valueOf(((DoBanUsrReq)((IDIPPacket_DoBanUsrReq)((IDIPCmd_DoBanUsrReq)this.cmd).req).body).Partition), Byte.valueOf(((DoBanUsrReq)((IDIPPacket_DoBanUsrReq)((IDIPCmd_DoBanUsrReq)this.cmd).req).body).PlatId), xUser.getRoleids().toString(), ((DoBanUsrReq)((IDIPPacket_DoBanUsrReq)((IDIPCmd_DoBanUsrReq)this.cmd).req).body).RoleId }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  93 */       return false;
/*     */     }
/*     */     
/*  96 */     if ((!mzm.gsp.role.main.RoleInterface.isRoleExist(roleId, true)) || (!xUser.getRoleids().contains(Long.valueOf(roleId))))
/*     */     {
/*  98 */       ((IDIPPacket_DoBanUsrRsp)((IDIPCmd_DoBanUsrReq)this.cmd).rsp).head.Result = 1;
/*  99 */       ((IDIPPacket_DoBanUsrRsp)((IDIPCmd_DoBanUsrReq)this.cmd).rsp).head.RetErrMsg = "query roleid empty";
/* 100 */       ((IDIPCmd_DoBanUsrReq)this.cmd).sendResponse();
/* 101 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoBanUsrReq.banRole@role not found or not match|ret=%d|ret_msg=%s|open_id=%s|area_id=%d|partition=%d|plat_id=%d|user_role_list=%s|role_id=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoBanUsrRsp)((IDIPCmd_DoBanUsrReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoBanUsrRsp)((IDIPCmd_DoBanUsrReq)this.cmd).rsp).head.RetErrMsg, ((DoBanUsrReq)((IDIPPacket_DoBanUsrReq)((IDIPCmd_DoBanUsrReq)this.cmd).req).body).OpenId, Integer.valueOf(((DoBanUsrReq)((IDIPPacket_DoBanUsrReq)((IDIPCmd_DoBanUsrReq)this.cmd).req).body).AreaId), Integer.valueOf(((DoBanUsrReq)((IDIPPacket_DoBanUsrReq)((IDIPCmd_DoBanUsrReq)this.cmd).req).body).Partition), Byte.valueOf(((DoBanUsrReq)((IDIPPacket_DoBanUsrReq)((IDIPCmd_DoBanUsrReq)this.cmd).req).body).PlatId), xUser.getRoleids().toString(), ((DoBanUsrReq)((IDIPPacket_DoBanUsrReq)((IDIPCmd_DoBanUsrReq)this.cmd).req).body).RoleId }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 107 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 124 */     ForbidInfoManager.forbidRole(roleId, 2147483647L, "idip");
/*     */     
/* 126 */     GameServer.logger().info(String.format("[idip]PIDIPCmd_DoBanUsrReq.banRole@ban role success|ret=%d|ret_msg=%s|open_id=%s|area_id=%d|partition=%d|plat_id=%d|role_id=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoBanUsrRsp)((IDIPCmd_DoBanUsrReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoBanUsrRsp)((IDIPCmd_DoBanUsrReq)this.cmd).rsp).head.RetErrMsg, ((DoBanUsrReq)((IDIPPacket_DoBanUsrReq)((IDIPCmd_DoBanUsrReq)this.cmd).req).body).OpenId, Integer.valueOf(((DoBanUsrReq)((IDIPPacket_DoBanUsrReq)((IDIPCmd_DoBanUsrReq)this.cmd).req).body).AreaId), Integer.valueOf(((DoBanUsrReq)((IDIPPacket_DoBanUsrReq)((IDIPCmd_DoBanUsrReq)this.cmd).req).body).Partition), Byte.valueOf(((DoBanUsrReq)((IDIPPacket_DoBanUsrReq)((IDIPCmd_DoBanUsrReq)this.cmd).req).body).PlatId), ((DoBanUsrReq)((IDIPPacket_DoBanUsrReq)((IDIPCmd_DoBanUsrReq)this.cmd).req).body).RoleId }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 132 */     ((IDIPPacket_DoBanUsrRsp)((IDIPCmd_DoBanUsrReq)this.cmd).rsp).head.Result = 0;
/* 133 */     ((IDIPPacket_DoBanUsrRsp)((IDIPCmd_DoBanUsrReq)this.cmd).rsp).head.RetErrMsg = "ok";
/* 134 */     ((IDIPCmd_DoBanUsrReq)this.cmd).sendResponse();
/* 135 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean banUser(String userId)
/*     */   {
/* 160 */     ForbidInfoManager.forbidUser(userId, Integer.MAX_VALUE, "idip");
/*     */     
/* 162 */     ((IDIPPacket_DoBanUsrRsp)((IDIPCmd_DoBanUsrReq)this.cmd).rsp).head.Result = 0;
/* 163 */     ((IDIPPacket_DoBanUsrRsp)((IDIPCmd_DoBanUsrReq)this.cmd).rsp).head.RetErrMsg = "ok";
/* 164 */     ((IDIPCmd_DoBanUsrReq)this.cmd).sendResponse();
/* 165 */     GameServer.logger().info(String.format("[idip]PIDIPCmd_DoBanUsrReq.banUser@ban user success|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|role_id=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoBanUsrRsp)((IDIPCmd_DoBanUsrReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoBanUsrRsp)((IDIPCmd_DoBanUsrReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(((DoBanUsrReq)((IDIPPacket_DoBanUsrReq)((IDIPCmd_DoBanUsrReq)this.cmd).req).body).AreaId), Byte.valueOf(((DoBanUsrReq)((IDIPPacket_DoBanUsrReq)((IDIPCmd_DoBanUsrReq)this.cmd).req).body).PlatId), ((DoBanUsrReq)((IDIPPacket_DoBanUsrReq)((IDIPCmd_DoBanUsrReq)this.cmd).req).body).RoleId }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 170 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PIDIPCmd_DoBanUsrReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
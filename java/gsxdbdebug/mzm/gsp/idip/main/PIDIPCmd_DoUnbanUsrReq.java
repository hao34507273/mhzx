/*     */ package mzm.gsp.idip.main;
/*     */ 
/*     */ import idip.DoUnbanUsrReq;
/*     */ import idip.DoUnbanUsrRsp;
/*     */ import idip.IDIPCmd_DoUnbanUsrReq;
/*     */ import idip.IDIPPacket_DoUnbanUsrReq;
/*     */ import idip.IDIPPacket_DoUnbanUsrRsp;
/*     */ import idip.core.IdipHeader;
/*     */ import idip.core.Utils;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.online.main.ForbidInfoManager;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class PIDIPCmd_DoUnbanUsrReq extends PIDIPCmd<IDIPCmd_DoUnbanUsrReq>
/*     */ {
/*     */   public PIDIPCmd_DoUnbanUsrReq(IDIPCmd_DoUnbanUsrReq cmd)
/*     */   {
/*  18 */     super(cmd);
/*     */   }
/*     */   
/*     */   protected boolean handle()
/*     */     throws Exception
/*     */   {
/*  24 */     String openId = ((DoUnbanUsrReq)((IDIPPacket_DoUnbanUsrReq)((IDIPCmd_DoUnbanUsrReq)this.cmd).req).body).OpenId;
/*  25 */     int areaId = ((DoUnbanUsrReq)((IDIPPacket_DoUnbanUsrReq)((IDIPCmd_DoUnbanUsrReq)this.cmd).req).body).AreaId;
/*  26 */     int partition = ((DoUnbanUsrReq)((IDIPPacket_DoUnbanUsrReq)((IDIPCmd_DoUnbanUsrReq)this.cmd).req).body).Partition;
/*     */     
/*  28 */     String userId = Utils.getUserId(openId, areaId, partition);
/*  29 */     xbean.User xUser = xtable.User.get(userId);
/*  30 */     if (null == xUser)
/*     */     {
/*  32 */       ((IDIPPacket_DoUnbanUsrRsp)((IDIPCmd_DoUnbanUsrReq)this.cmd).rsp).head.Result = 1;
/*  33 */       ((IDIPPacket_DoUnbanUsrRsp)((IDIPCmd_DoUnbanUsrReq)this.cmd).rsp).head.RetErrMsg = "query userid empty";
/*  34 */       ((IDIPCmd_DoUnbanUsrReq)this.cmd).sendResponse();
/*     */       
/*  36 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoUnbanUsrReq.handle@user not found|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|role_id=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoUnbanUsrRsp)((IDIPCmd_DoUnbanUsrReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoUnbanUsrRsp)((IDIPCmd_DoUnbanUsrReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((DoUnbanUsrReq)((IDIPPacket_DoUnbanUsrReq)((IDIPCmd_DoUnbanUsrReq)this.cmd).req).body).PlatId), ((DoUnbanUsrReq)((IDIPPacket_DoUnbanUsrReq)((IDIPCmd_DoUnbanUsrReq)this.cmd).req).body).RoleId }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  41 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  45 */     if (!((DoUnbanUsrReq)((IDIPPacket_DoUnbanUsrReq)((IDIPCmd_DoUnbanUsrReq)this.cmd).req).body).RoleId.isEmpty())
/*     */     {
/*     */ 
/*  48 */       if (((DoUnbanUsrReq)((IDIPPacket_DoUnbanUsrReq)((IDIPCmd_DoUnbanUsrReq)this.cmd).req).body).RoleId.length() > 32)
/*     */       {
/*  50 */         ((IDIPPacket_DoUnbanUsrRsp)((IDIPCmd_DoUnbanUsrReq)this.cmd).rsp).head.Result = (((DoUnbanUsrRsp)((IDIPPacket_DoUnbanUsrRsp)((IDIPCmd_DoUnbanUsrReq)this.cmd).rsp).body).Result = 1);
/*  51 */         ((IDIPPacket_DoUnbanUsrRsp)((IDIPCmd_DoUnbanUsrReq)this.cmd).rsp).head.RetErrMsg = (((DoUnbanUsrRsp)((IDIPPacket_DoUnbanUsrRsp)((IDIPCmd_DoUnbanUsrReq)this.cmd).rsp).body).RetMsg = String.format("roleid length > %d", new Object[] { Integer.valueOf(32) }));
/*     */         
/*  53 */         ((IDIPCmd_DoUnbanUsrReq)this.cmd).sendResponse();
/*     */         
/*  55 */         GameServer.logger().error(String.format("[idip]PIDIPCmd_DoUnbanUsrReq.handle@roleId length > MAX_ROLEID_LEN|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|role_id=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoUnbanUsrRsp)((IDIPCmd_DoUnbanUsrReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoUnbanUsrRsp)((IDIPCmd_DoUnbanUsrReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((DoUnbanUsrReq)((IDIPPacket_DoUnbanUsrReq)((IDIPCmd_DoUnbanUsrReq)this.cmd).req).body).PlatId), ((DoUnbanUsrReq)((IDIPPacket_DoUnbanUsrReq)((IDIPCmd_DoUnbanUsrReq)this.cmd).req).body).RoleId }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  61 */         return false;
/*     */       }
/*     */       
/*  64 */       long roleId = -1L;
/*     */       try
/*     */       {
/*  67 */         roleId = Long.parseLong(((DoUnbanUsrReq)((IDIPPacket_DoUnbanUsrReq)((IDIPCmd_DoUnbanUsrReq)this.cmd).req).body).RoleId);
/*     */       }
/*     */       catch (NumberFormatException e)
/*     */       {
/*  71 */         ((IDIPPacket_DoUnbanUsrRsp)((IDIPCmd_DoUnbanUsrReq)this.cmd).rsp).head.Result = (((DoUnbanUsrRsp)((IDIPPacket_DoUnbanUsrRsp)((IDIPCmd_DoUnbanUsrReq)this.cmd).rsp).body).Result = 1);
/*  72 */         ((IDIPPacket_DoUnbanUsrRsp)((IDIPCmd_DoUnbanUsrReq)this.cmd).rsp).head.RetErrMsg = (((DoUnbanUsrRsp)((IDIPPacket_DoUnbanUsrRsp)((IDIPCmd_DoUnbanUsrReq)this.cmd).rsp).body).RetMsg = "roleid format error");
/*  73 */         ((IDIPCmd_DoUnbanUsrReq)this.cmd).sendResponse();
/*     */         
/*  75 */         GameServer.logger().error(String.format("[idip]PIDIPCmd_DoUnbanUsrReq.handle@role not found|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|role_id=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoUnbanUsrRsp)((IDIPCmd_DoUnbanUsrReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoUnbanUsrRsp)((IDIPCmd_DoUnbanUsrReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((DoUnbanUsrReq)((IDIPPacket_DoUnbanUsrReq)((IDIPCmd_DoUnbanUsrReq)this.cmd).req).body).PlatId), ((DoUnbanUsrReq)((IDIPPacket_DoUnbanUsrReq)((IDIPCmd_DoUnbanUsrReq)this.cmd).req).body).RoleId }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  81 */         return false;
/*     */       }
/*     */       
/*  84 */       if ((!mzm.gsp.role.main.RoleInterface.isRoleExist(roleId, true)) || (!xUser.getRoleids().contains(Long.valueOf(roleId))))
/*     */       {
/*  86 */         ((IDIPPacket_DoUnbanUsrRsp)((IDIPCmd_DoUnbanUsrReq)this.cmd).rsp).head.Result = 1;
/*  87 */         ((IDIPPacket_DoUnbanUsrRsp)((IDIPCmd_DoUnbanUsrReq)this.cmd).rsp).head.RetErrMsg = "query roleid empty";
/*  88 */         ((IDIPCmd_DoUnbanUsrReq)this.cmd).sendResponse();
/*     */         
/*  90 */         GameServer.logger().error(String.format("[idip]PIDIPCmd_DoUnbanUsrReq.handle@role not found|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|role_id=%d", new Object[] { Integer.valueOf(((IDIPPacket_DoUnbanUsrRsp)((IDIPCmd_DoUnbanUsrReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoUnbanUsrRsp)((IDIPCmd_DoUnbanUsrReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((DoUnbanUsrReq)((IDIPPacket_DoUnbanUsrReq)((IDIPCmd_DoUnbanUsrReq)this.cmd).req).body).PlatId), Long.valueOf(roleId) }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  96 */         return false;
/*     */       }
/*     */       
/*  99 */       ForbidInfoManager.unforbidRole(roleId);
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 104 */       ForbidInfoManager.unforbidUser(userId);
/*     */     }
/*     */     
/* 107 */     GameServer.logger().info(String.format("[idip]PIDIPCmd_DoUnbanUsrReq.handle@unbean user or role success|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|role_id=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoUnbanUsrRsp)((IDIPCmd_DoUnbanUsrReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoUnbanUsrRsp)((IDIPCmd_DoUnbanUsrReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((DoUnbanUsrReq)((IDIPPacket_DoUnbanUsrReq)((IDIPCmd_DoUnbanUsrReq)this.cmd).req).body).PlatId), ((DoUnbanUsrReq)((IDIPPacket_DoUnbanUsrReq)((IDIPCmd_DoUnbanUsrReq)this.cmd).req).body).RoleId }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 113 */     ((IDIPPacket_DoUnbanUsrRsp)((IDIPCmd_DoUnbanUsrReq)this.cmd).rsp).head.Result = 0;
/* 114 */     ((IDIPPacket_DoUnbanUsrRsp)((IDIPCmd_DoUnbanUsrReq)this.cmd).rsp).head.RetErrMsg = "ok";
/* 115 */     ((IDIPCmd_DoUnbanUsrReq)this.cmd).sendResponse();
/* 116 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PIDIPCmd_DoUnbanUsrReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
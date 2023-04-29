/*     */ package mzm.gsp.idip.main;
/*     */ 
/*     */ import idip.IDIPCmd_QueryRoleSocialReq;
/*     */ import idip.IDIPPacket_QueryRoleSocialReq;
/*     */ import idip.IDIPPacket_QueryRoleSocialRsp;
/*     */ import idip.QueryRoleSocialReq;
/*     */ import idip.QueryRoleSocialRsp;
/*     */ import idip.SSocial;
/*     */ import idip.core.IdipHeader;
/*     */ import java.util.ArrayList;
/*     */ import mzm.gsp.GameServer;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class PIDIPCmd_QueryRoleSocialReq extends PIDIPCmd<IDIPCmd_QueryRoleSocialReq>
/*     */ {
/*     */   public PIDIPCmd_QueryRoleSocialReq(IDIPCmd_QueryRoleSocialReq cmd)
/*     */   {
/*  18 */     super(cmd);
/*     */   }
/*     */   
/*     */   protected boolean handle()
/*     */     throws Exception
/*     */   {
/*  24 */     String openId = ((QueryRoleSocialReq)((IDIPPacket_QueryRoleSocialReq)((IDIPCmd_QueryRoleSocialReq)this.cmd).req).body).OpenId;
/*  25 */     int areaId = ((QueryRoleSocialReq)((IDIPPacket_QueryRoleSocialReq)((IDIPCmd_QueryRoleSocialReq)this.cmd).req).body).AreaId;
/*  26 */     int partition = ((QueryRoleSocialReq)((IDIPPacket_QueryRoleSocialReq)((IDIPCmd_QueryRoleSocialReq)this.cmd).req).body).Partition;
/*     */     
/*  28 */     String userId = idip.core.Utils.getUserId(openId, areaId, partition);
/*  29 */     xbean.User xUser = xtable.User.get(userId);
/*  30 */     if (null == xUser)
/*     */     {
/*  32 */       ((IDIPPacket_QueryRoleSocialRsp)((IDIPCmd_QueryRoleSocialReq)this.cmd).rsp).head.Result = 1;
/*  33 */       ((IDIPPacket_QueryRoleSocialRsp)((IDIPCmd_QueryRoleSocialReq)this.cmd).rsp).head.RetErrMsg = "query userid empty";
/*  34 */       ((IDIPCmd_QueryRoleSocialReq)this.cmd).sendResponse();
/*     */       
/*  36 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_QueryRoleSocialReq.handle@user not found|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|partition=%d|plat_id=%d|open_id=%s|role_id=%s", new Object[] { Integer.valueOf(((IDIPPacket_QueryRoleSocialRsp)((IDIPCmd_QueryRoleSocialReq)this.cmd).rsp).head.Result), ((IDIPPacket_QueryRoleSocialRsp)((IDIPCmd_QueryRoleSocialReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Integer.valueOf(partition), Byte.valueOf(((QueryRoleSocialReq)((IDIPPacket_QueryRoleSocialReq)((IDIPCmd_QueryRoleSocialReq)this.cmd).req).body).PlatId), openId, ((QueryRoleSocialReq)((IDIPPacket_QueryRoleSocialReq)((IDIPCmd_QueryRoleSocialReq)this.cmd).req).body).RoleId }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  41 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  45 */     if (((QueryRoleSocialReq)((IDIPPacket_QueryRoleSocialReq)((IDIPCmd_QueryRoleSocialReq)this.cmd).req).body).RoleId.length() > 32)
/*     */     {
/*  47 */       ((IDIPPacket_QueryRoleSocialRsp)((IDIPCmd_QueryRoleSocialReq)this.cmd).rsp).head.Result = 1;
/*  48 */       ((IDIPPacket_QueryRoleSocialRsp)((IDIPCmd_QueryRoleSocialReq)this.cmd).rsp).head.RetErrMsg = String.format("roleid length > %d", new Object[] { Integer.valueOf(32) });
/*  49 */       ((IDIPCmd_QueryRoleSocialReq)this.cmd).sendResponse();
/*     */       
/*  51 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_QueryRoleSocialReq.handle@roleId length > MAX_ROLEID_LEN|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|partition=%d|plat_id=%d|open_id=%s|role_id=%s", new Object[] { Integer.valueOf(((IDIPPacket_QueryRoleSocialRsp)((IDIPCmd_QueryRoleSocialReq)this.cmd).rsp).head.Result), ((IDIPPacket_QueryRoleSocialRsp)((IDIPCmd_QueryRoleSocialReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Integer.valueOf(partition), Byte.valueOf(((QueryRoleSocialReq)((IDIPPacket_QueryRoleSocialReq)((IDIPCmd_QueryRoleSocialReq)this.cmd).req).body).PlatId), openId, ((QueryRoleSocialReq)((IDIPPacket_QueryRoleSocialReq)((IDIPCmd_QueryRoleSocialReq)this.cmd).req).body).RoleId }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  56 */       return false;
/*     */     }
/*     */     
/*  59 */     long roleId = -1L;
/*     */     try
/*     */     {
/*  62 */       roleId = Long.parseLong(((QueryRoleSocialReq)((IDIPPacket_QueryRoleSocialReq)((IDIPCmd_QueryRoleSocialReq)this.cmd).req).body).RoleId);
/*     */     }
/*     */     catch (NumberFormatException e)
/*     */     {
/*  66 */       ((IDIPPacket_QueryRoleSocialRsp)((IDIPCmd_QueryRoleSocialReq)this.cmd).rsp).head.Result = 1;
/*  67 */       ((IDIPPacket_QueryRoleSocialRsp)((IDIPCmd_QueryRoleSocialReq)this.cmd).rsp).head.RetErrMsg = "roleid format error";
/*  68 */       ((IDIPCmd_QueryRoleSocialReq)this.cmd).sendResponse();
/*     */       
/*  70 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_QueryRoleSocialReq.handle@role not found|ret=%d|ret_msg=%s|user_id=%s|user_role_list=%s|area_id=%d|partition=%d|plat_id=%d|open_id=%s|role_id=%s", new Object[] { Integer.valueOf(((IDIPPacket_QueryRoleSocialRsp)((IDIPCmd_QueryRoleSocialReq)this.cmd).rsp).head.Result), ((IDIPPacket_QueryRoleSocialRsp)((IDIPCmd_QueryRoleSocialReq)this.cmd).rsp).head.RetErrMsg, userId, xUser.getRoleids().toString(), Integer.valueOf(areaId), Integer.valueOf(partition), Byte.valueOf(((QueryRoleSocialReq)((IDIPPacket_QueryRoleSocialReq)((IDIPCmd_QueryRoleSocialReq)this.cmd).req).body).PlatId), openId, ((QueryRoleSocialReq)((IDIPPacket_QueryRoleSocialReq)((IDIPCmd_QueryRoleSocialReq)this.cmd).req).body).RoleId }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  75 */       return false;
/*     */     }
/*     */     
/*  78 */     if ((!mzm.gsp.role.main.RoleInterface.isRoleExist(roleId, true)) || (!xUser.getRoleids().contains(Long.valueOf(roleId))))
/*     */     {
/*  80 */       ((IDIPPacket_QueryRoleSocialRsp)((IDIPCmd_QueryRoleSocialReq)this.cmd).rsp).head.Result = 1;
/*  81 */       ((IDIPPacket_QueryRoleSocialRsp)((IDIPCmd_QueryRoleSocialReq)this.cmd).rsp).head.RetErrMsg = "query roleid empty";
/*  82 */       ((IDIPCmd_QueryRoleSocialReq)this.cmd).sendResponse();
/*     */       
/*  84 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_QueryRoleSocialReq.handle@role not found|ret=%d|ret_msg=%s|user_id=%s|user_role_list=%s|area_id=%d|partition=%d|plat_id=%d|open_id=%s|role_id=%s", new Object[] { Integer.valueOf(((IDIPPacket_QueryRoleSocialRsp)((IDIPCmd_QueryRoleSocialReq)this.cmd).rsp).head.Result), ((IDIPPacket_QueryRoleSocialRsp)((IDIPCmd_QueryRoleSocialReq)this.cmd).rsp).head.RetErrMsg, userId, xUser.getRoleids().toString(), Integer.valueOf(areaId), Integer.valueOf(partition), Byte.valueOf(((QueryRoleSocialReq)((IDIPPacket_QueryRoleSocialReq)((IDIPCmd_QueryRoleSocialReq)this.cmd).req).body).PlatId), openId, ((QueryRoleSocialReq)((IDIPPacket_QueryRoleSocialReq)((IDIPCmd_QueryRoleSocialReq)this.cmd).req).body).RoleId }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  89 */       return false;
/*     */     }
/*     */     
/*  92 */     SSocial social = new SSocial();
/*     */     
/*  94 */     social.IsSworn = ((byte)(mzm.gsp.sworn.main.SwornInterface.isRoleSworn(roleId) ? 1 : 0));
/*     */     
/*  96 */     social.IsMarry = ((byte)(mzm.gsp.marriage.main.MarriageInterface.isMarried(roleId) ? 1 : 0));
/*     */     
/*  98 */     social.IsMaster = ((byte)(mzm.gsp.shitu.main.ShiTuInterface.isExistShiTuRelation(roleId, false) ? 1 : 0));
/*     */     
/* 100 */     ((IDIPPacket_QueryRoleSocialRsp)((IDIPCmd_QueryRoleSocialReq)this.cmd).rsp).head.Result = 0;
/* 101 */     ((IDIPPacket_QueryRoleSocialRsp)((IDIPCmd_QueryRoleSocialReq)this.cmd).rsp).head.RetErrMsg = "ok";
/*     */     
/* 103 */     ((QueryRoleSocialRsp)((IDIPPacket_QueryRoleSocialRsp)((IDIPCmd_QueryRoleSocialReq)this.cmd).rsp).body).Social_count = 1;
/* 104 */     ((QueryRoleSocialRsp)((IDIPPacket_QueryRoleSocialRsp)((IDIPCmd_QueryRoleSocialReq)this.cmd).rsp).body).Social.add(social);
/* 105 */     ((IDIPCmd_QueryRoleSocialReq)this.cmd).sendResponse();
/*     */     
/* 107 */     GameServer.logger().info(String.format("[idip]PIDIPCmd_QueryRoleSocialReq.handle@query role social success|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|partition=%d|plat_id=%d|open_id=%s|role_id=%s", new Object[] { Integer.valueOf(((IDIPPacket_QueryRoleSocialRsp)((IDIPCmd_QueryRoleSocialReq)this.cmd).rsp).head.Result), ((IDIPPacket_QueryRoleSocialRsp)((IDIPCmd_QueryRoleSocialReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Integer.valueOf(partition), Byte.valueOf(((QueryRoleSocialReq)((IDIPPacket_QueryRoleSocialReq)((IDIPCmd_QueryRoleSocialReq)this.cmd).req).body).PlatId), openId, ((QueryRoleSocialReq)((IDIPPacket_QueryRoleSocialReq)((IDIPCmd_QueryRoleSocialReq)this.cmd).req).body).RoleId }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 112 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PIDIPCmd_QueryRoleSocialReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
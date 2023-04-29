/*     */ package mzm.gsp.idip.main;
/*     */ 
/*     */ import idip.IDIPCmd_QuerySxianlvNumReq;
/*     */ import idip.IDIPPacket_QuerySxianlvNumReq;
/*     */ import idip.IDIPPacket_QuerySxianlvNumRsp;
/*     */ import idip.QuerySxianlvNumReq;
/*     */ import idip.QuerySxianlvNumRsp;
/*     */ import idip.core.IdipHeader;
/*     */ import idip.core.Utils;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class PIDIPCmd_QuerySxianLvNumReq extends PIDIPCmd<IDIPCmd_QuerySxianlvNumReq>
/*     */ {
/*     */   public PIDIPCmd_QuerySxianLvNumReq(IDIPCmd_QuerySxianlvNumReq cmd)
/*     */   {
/*  19 */     super(cmd);
/*     */   }
/*     */   
/*     */   protected boolean handle()
/*     */     throws Exception
/*     */   {
/*  25 */     String openId = ((QuerySxianlvNumReq)((IDIPPacket_QuerySxianlvNumReq)((IDIPCmd_QuerySxianlvNumReq)this.cmd).req).body).OpenId;
/*  26 */     int areaId = ((QuerySxianlvNumReq)((IDIPPacket_QuerySxianlvNumReq)((IDIPCmd_QuerySxianlvNumReq)this.cmd).req).body).AreaId;
/*  27 */     int partition = ((QuerySxianlvNumReq)((IDIPPacket_QuerySxianlvNumReq)((IDIPCmd_QuerySxianlvNumReq)this.cmd).req).body).Partition;
/*     */     
/*  29 */     String userId = Utils.getUserId(openId, areaId, partition);
/*  30 */     xbean.User xUser = xtable.User.get(userId);
/*  31 */     if (null == xUser)
/*     */     {
/*  33 */       ((IDIPPacket_QuerySxianlvNumRsp)((IDIPCmd_QuerySxianlvNumReq)this.cmd).rsp).head.Result = 1;
/*  34 */       ((IDIPPacket_QuerySxianlvNumRsp)((IDIPCmd_QuerySxianlvNumReq)this.cmd).rsp).head.RetErrMsg = "query userid empty";
/*  35 */       ((IDIPCmd_QuerySxianlvNumReq)this.cmd).sendResponse();
/*     */       
/*  37 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_QuerySxianLvNumReq.handle@user not found|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|partition=%d|plat_id=%d|open_id=%s|role_id=%s", new Object[] { Integer.valueOf(((IDIPPacket_QuerySxianlvNumRsp)((IDIPCmd_QuerySxianlvNumReq)this.cmd).rsp).head.Result), ((IDIPPacket_QuerySxianlvNumRsp)((IDIPCmd_QuerySxianlvNumReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Integer.valueOf(partition), Byte.valueOf(((QuerySxianlvNumReq)((IDIPPacket_QuerySxianlvNumReq)((IDIPCmd_QuerySxianlvNumReq)this.cmd).req).body).PlatId), openId, ((QuerySxianlvNumReq)((IDIPPacket_QuerySxianlvNumReq)((IDIPCmd_QuerySxianlvNumReq)this.cmd).req).body).RoleId }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  42 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  46 */     if (((QuerySxianlvNumReq)((IDIPPacket_QuerySxianlvNumReq)((IDIPCmd_QuerySxianlvNumReq)this.cmd).req).body).RoleId.length() > 32)
/*     */     {
/*  48 */       ((IDIPPacket_QuerySxianlvNumRsp)((IDIPCmd_QuerySxianlvNumReq)this.cmd).rsp).head.Result = 1;
/*  49 */       ((IDIPPacket_QuerySxianlvNumRsp)((IDIPCmd_QuerySxianlvNumReq)this.cmd).rsp).head.RetErrMsg = String.format("roleid length > %d", new Object[] { Integer.valueOf(32) });
/*  50 */       ((IDIPCmd_QuerySxianlvNumReq)this.cmd).sendResponse();
/*     */       
/*  52 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_QuerySxianLvNumReq.handle@roleId length > MAX_ROLEID_LEN|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|partition=%d|plat_id=%d|open_id=%s|role_id=%s", new Object[] { Integer.valueOf(((IDIPPacket_QuerySxianlvNumRsp)((IDIPCmd_QuerySxianlvNumReq)this.cmd).rsp).head.Result), ((IDIPPacket_QuerySxianlvNumRsp)((IDIPCmd_QuerySxianlvNumReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Integer.valueOf(partition), Byte.valueOf(((QuerySxianlvNumReq)((IDIPPacket_QuerySxianlvNumReq)((IDIPCmd_QuerySxianlvNumReq)this.cmd).req).body).PlatId), openId, ((QuerySxianlvNumReq)((IDIPPacket_QuerySxianlvNumReq)((IDIPCmd_QuerySxianlvNumReq)this.cmd).req).body).RoleId }));
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
/*  63 */       roleId = Long.parseLong(((QuerySxianlvNumReq)((IDIPPacket_QuerySxianlvNumReq)((IDIPCmd_QuerySxianlvNumReq)this.cmd).req).body).RoleId);
/*     */     }
/*     */     catch (NumberFormatException e)
/*     */     {
/*  67 */       ((IDIPPacket_QuerySxianlvNumRsp)((IDIPCmd_QuerySxianlvNumReq)this.cmd).rsp).head.Result = 1;
/*  68 */       ((IDIPPacket_QuerySxianlvNumRsp)((IDIPCmd_QuerySxianlvNumReq)this.cmd).rsp).head.RetErrMsg = "roleid format error";
/*  69 */       ((IDIPCmd_QuerySxianlvNumReq)this.cmd).sendResponse();
/*     */       
/*  71 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_QuerySxianLvNumReq.handle@role not found|ret=%d|ret_msg=%s|user_id=%s|user_role_list=%s|area_id=%d|partition=%d|plat_id=%d|open_id=%s|role_id=%s", new Object[] { Integer.valueOf(((IDIPPacket_QuerySxianlvNumRsp)((IDIPCmd_QuerySxianlvNumReq)this.cmd).rsp).head.Result), ((IDIPPacket_QuerySxianlvNumRsp)((IDIPCmd_QuerySxianlvNumReq)this.cmd).rsp).head.RetErrMsg, userId, xUser.getRoleids().toString(), Integer.valueOf(areaId), Integer.valueOf(partition), Byte.valueOf(((QuerySxianlvNumReq)((IDIPPacket_QuerySxianlvNumReq)((IDIPCmd_QuerySxianlvNumReq)this.cmd).req).body).PlatId), openId, ((QuerySxianlvNumReq)((IDIPPacket_QuerySxianlvNumReq)((IDIPCmd_QuerySxianlvNumReq)this.cmd).req).body).RoleId }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  76 */       return false;
/*     */     }
/*     */     
/*  79 */     if ((!RoleInterface.isRoleExist(roleId, true)) || (!xUser.getRoleids().contains(Long.valueOf(roleId))))
/*     */     {
/*  81 */       ((IDIPPacket_QuerySxianlvNumRsp)((IDIPCmd_QuerySxianlvNumReq)this.cmd).rsp).head.Result = 1;
/*  82 */       ((IDIPPacket_QuerySxianlvNumRsp)((IDIPCmd_QuerySxianlvNumReq)this.cmd).rsp).head.RetErrMsg = "query roleid empty";
/*  83 */       ((IDIPCmd_QuerySxianlvNumReq)this.cmd).sendResponse();
/*     */       
/*  85 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_QuerySxianLvNumReq.handle@role not found|ret=%d|ret_msg=%s|user_id=%s|user_role_list=%s|area_id=%d|partition=%d|plat_id=%d|open_id=%s|role_id=%s", new Object[] { Integer.valueOf(((IDIPPacket_QuerySxianlvNumRsp)((IDIPCmd_QuerySxianlvNumReq)this.cmd).rsp).head.Result), ((IDIPPacket_QuerySxianlvNumRsp)((IDIPCmd_QuerySxianlvNumReq)this.cmd).rsp).head.RetErrMsg, userId, xUser.getRoleids().toString(), Integer.valueOf(areaId), Integer.valueOf(partition), Byte.valueOf(((QuerySxianlvNumReq)((IDIPPacket_QuerySxianlvNumReq)((IDIPCmd_QuerySxianlvNumReq)this.cmd).req).body).PlatId), openId, ((QuerySxianlvNumReq)((IDIPPacket_QuerySxianlvNumReq)((IDIPCmd_QuerySxianlvNumReq)this.cmd).req).body).RoleId }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  90 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  94 */     Set<Integer> partners = mzm.gsp.partner.main.PartnerInterface.getRoleXRankPartners(roleId, 3);
/*  95 */     if (partners == null)
/*     */     {
/*  97 */       ((QuerySxianlvNumRsp)((IDIPPacket_QuerySxianlvNumRsp)((IDIPCmd_QuerySxianlvNumReq)this.cmd).rsp).body).XianLv = 0L;
/*     */     }
/*     */     else
/*     */     {
/* 101 */       ((QuerySxianlvNumRsp)((IDIPPacket_QuerySxianlvNumRsp)((IDIPCmd_QuerySxianlvNumReq)this.cmd).rsp).body).XianLv = partners.size();
/*     */     }
/*     */     
/* 104 */     ((IDIPPacket_QuerySxianlvNumRsp)((IDIPCmd_QuerySxianlvNumReq)this.cmd).rsp).head.Result = 0;
/* 105 */     ((IDIPPacket_QuerySxianlvNumRsp)((IDIPCmd_QuerySxianlvNumReq)this.cmd).rsp).head.RetErrMsg = "ok";
/* 106 */     ((IDIPCmd_QuerySxianlvNumReq)this.cmd).sendResponse();
/*     */     
/* 108 */     GameServer.logger().info(String.format("[idip]PIDIPCmd_QuerySxianLvNumReq.handle@query s_xian_lv num success|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|partition=%d|plat_id=%d|open_id=%s|role_id=%s|num=%d", new Object[] { Integer.valueOf(((IDIPPacket_QuerySxianlvNumRsp)((IDIPCmd_QuerySxianlvNumReq)this.cmd).rsp).head.Result), ((IDIPPacket_QuerySxianlvNumRsp)((IDIPCmd_QuerySxianlvNumReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Integer.valueOf(partition), Byte.valueOf(((QuerySxianlvNumReq)((IDIPPacket_QuerySxianlvNumReq)((IDIPCmd_QuerySxianlvNumReq)this.cmd).req).body).PlatId), openId, ((QuerySxianlvNumReq)((IDIPPacket_QuerySxianlvNumReq)((IDIPCmd_QuerySxianlvNumReq)this.cmd).req).body).RoleId, Long.valueOf(((QuerySxianlvNumRsp)((IDIPPacket_QuerySxianlvNumRsp)((IDIPCmd_QuerySxianlvNumReq)this.cmd).rsp).body).XianLv) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 114 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PIDIPCmd_QuerySxianLvNumReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
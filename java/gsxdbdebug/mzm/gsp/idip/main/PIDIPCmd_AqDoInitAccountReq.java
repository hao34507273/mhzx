/*     */ package mzm.gsp.idip.main;
/*     */ 
/*     */ import gnet.link.Onlines;
/*     */ import idip.AqDoInitAccountReq;
/*     */ import idip.AqDoInitAccountRsp;
/*     */ import idip.IDIPCmd_AqDoInitAccountReq;
/*     */ import idip.IDIPPacket_AqDoInitAccountReq;
/*     */ import idip.IDIPPacket_AqDoInitAccountRsp;
/*     */ import idip.core.IdipHeader;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class PIDIPCmd_AqDoInitAccountReq extends PIDIPCmd<IDIPCmd_AqDoInitAccountReq>
/*     */ {
/*     */   public PIDIPCmd_AqDoInitAccountReq(IDIPCmd_AqDoInitAccountReq cmd)
/*     */   {
/*  18 */     super(cmd);
/*     */   }
/*     */   
/*     */   protected boolean handle()
/*     */     throws Exception
/*     */   {
/*  24 */     String openId = ((AqDoInitAccountReq)((IDIPPacket_AqDoInitAccountReq)((IDIPCmd_AqDoInitAccountReq)this.cmd).req).body).OpenId;
/*  25 */     int areaId = ((AqDoInitAccountReq)((IDIPPacket_AqDoInitAccountReq)((IDIPCmd_AqDoInitAccountReq)this.cmd).req).body).AreaId;
/*  26 */     int partition = ((AqDoInitAccountReq)((IDIPPacket_AqDoInitAccountReq)((IDIPCmd_AqDoInitAccountReq)this.cmd).req).body).Partition;
/*     */     
/*  28 */     String userId = idip.core.Utils.getUserId(openId, areaId, partition);
/*  29 */     xbean.User xUser = xtable.User.get(userId);
/*  30 */     if (null == xUser)
/*     */     {
/*  32 */       ((IDIPPacket_AqDoInitAccountRsp)((IDIPCmd_AqDoInitAccountReq)this.cmd).rsp).head.Result = (((AqDoInitAccountRsp)((IDIPPacket_AqDoInitAccountRsp)((IDIPCmd_AqDoInitAccountReq)this.cmd).rsp).body).Result = 1);
/*  33 */       ((IDIPPacket_AqDoInitAccountRsp)((IDIPCmd_AqDoInitAccountReq)this.cmd).rsp).head.RetErrMsg = (((AqDoInitAccountRsp)((IDIPPacket_AqDoInitAccountRsp)((IDIPCmd_AqDoInitAccountReq)this.cmd).rsp).body).RetMsg = "query userid empty");
/*  34 */       ((IDIPCmd_AqDoInitAccountReq)this.cmd).sendResponse();
/*     */       
/*  36 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoInitAccountReq.handle@user not found|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoInitAccountRsp)((IDIPCmd_AqDoInitAccountReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoInitAccountRsp)((IDIPCmd_AqDoInitAccountReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((AqDoInitAccountReq)((IDIPPacket_AqDoInitAccountReq)((IDIPCmd_AqDoInitAccountReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoInitAccountReq)((IDIPPacket_AqDoInitAccountReq)((IDIPCmd_AqDoInitAccountReq)this.cmd).req).body).RoleId, Integer.valueOf(((AqDoInitAccountReq)((IDIPPacket_AqDoInitAccountReq)((IDIPCmd_AqDoInitAccountReq)this.cmd).req).body).Source), ((AqDoInitAccountReq)((IDIPPacket_AqDoInitAccountReq)((IDIPCmd_AqDoInitAccountReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  41 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  45 */     if (((AqDoInitAccountReq)((IDIPPacket_AqDoInitAccountReq)((IDIPCmd_AqDoInitAccountReq)this.cmd).req).body).RoleId.length() > 32)
/*     */     {
/*  47 */       ((IDIPPacket_AqDoInitAccountRsp)((IDIPCmd_AqDoInitAccountReq)this.cmd).rsp).head.Result = (((AqDoInitAccountRsp)((IDIPPacket_AqDoInitAccountRsp)((IDIPCmd_AqDoInitAccountReq)this.cmd).rsp).body).Result = 1);
/*  48 */       ((IDIPPacket_AqDoInitAccountRsp)((IDIPCmd_AqDoInitAccountReq)this.cmd).rsp).head.RetErrMsg = (((AqDoInitAccountRsp)((IDIPPacket_AqDoInitAccountRsp)((IDIPCmd_AqDoInitAccountReq)this.cmd).rsp).body).RetMsg = String.format("roleid length > %d", new Object[] { Integer.valueOf(32) }));
/*     */       
/*  50 */       ((IDIPCmd_AqDoInitAccountReq)this.cmd).sendResponse();
/*     */       
/*  52 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoInitAccountReq.handle@roleId length > MAX_ROLEID_LEN|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoInitAccountRsp)((IDIPCmd_AqDoInitAccountReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoInitAccountRsp)((IDIPCmd_AqDoInitAccountReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((AqDoInitAccountReq)((IDIPPacket_AqDoInitAccountReq)((IDIPCmd_AqDoInitAccountReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoInitAccountReq)((IDIPPacket_AqDoInitAccountReq)((IDIPCmd_AqDoInitAccountReq)this.cmd).req).body).RoleId, Integer.valueOf(((AqDoInitAccountReq)((IDIPPacket_AqDoInitAccountReq)((IDIPCmd_AqDoInitAccountReq)this.cmd).req).body).Source), ((AqDoInitAccountReq)((IDIPPacket_AqDoInitAccountReq)((IDIPCmd_AqDoInitAccountReq)this.cmd).req).body).Serial }));
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
/*  63 */       roleId = Long.parseLong(((AqDoInitAccountReq)((IDIPPacket_AqDoInitAccountReq)((IDIPCmd_AqDoInitAccountReq)this.cmd).req).body).RoleId);
/*     */     }
/*     */     catch (NumberFormatException e)
/*     */     {
/*  67 */       ((IDIPPacket_AqDoInitAccountRsp)((IDIPCmd_AqDoInitAccountReq)this.cmd).rsp).head.Result = (((AqDoInitAccountRsp)((IDIPPacket_AqDoInitAccountRsp)((IDIPCmd_AqDoInitAccountReq)this.cmd).rsp).body).Result = 1);
/*  68 */       ((IDIPPacket_AqDoInitAccountRsp)((IDIPCmd_AqDoInitAccountReq)this.cmd).rsp).head.RetErrMsg = (((AqDoInitAccountRsp)((IDIPPacket_AqDoInitAccountRsp)((IDIPCmd_AqDoInitAccountReq)this.cmd).rsp).body).RetMsg = "roleid format error");
/*  69 */       ((IDIPCmd_AqDoInitAccountReq)this.cmd).sendResponse();
/*     */       
/*  71 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoInitAccountReq.handle@role not found|ret=%d|ret_msg=%s|user_id=%s|user_role_list=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoInitAccountRsp)((IDIPCmd_AqDoInitAccountReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoInitAccountRsp)((IDIPCmd_AqDoInitAccountReq)this.cmd).rsp).head.RetErrMsg, userId, xUser.getRoleids().toString(), Integer.valueOf(areaId), Byte.valueOf(((AqDoInitAccountReq)((IDIPPacket_AqDoInitAccountReq)((IDIPCmd_AqDoInitAccountReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoInitAccountReq)((IDIPPacket_AqDoInitAccountReq)((IDIPCmd_AqDoInitAccountReq)this.cmd).req).body).RoleId, Integer.valueOf(((AqDoInitAccountReq)((IDIPPacket_AqDoInitAccountReq)((IDIPCmd_AqDoInitAccountReq)this.cmd).req).body).Source), ((AqDoInitAccountReq)((IDIPPacket_AqDoInitAccountReq)((IDIPCmd_AqDoInitAccountReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  77 */       return false;
/*     */     }
/*     */     
/*  80 */     if ((!RoleInterface.isRoleExist(roleId, true)) || (!xUser.getRoleids().contains(Long.valueOf(roleId))))
/*     */     {
/*  82 */       ((IDIPPacket_AqDoInitAccountRsp)((IDIPCmd_AqDoInitAccountReq)this.cmd).rsp).head.Result = (((AqDoInitAccountRsp)((IDIPPacket_AqDoInitAccountRsp)((IDIPCmd_AqDoInitAccountReq)this.cmd).rsp).body).Result = 1);
/*  83 */       ((IDIPPacket_AqDoInitAccountRsp)((IDIPCmd_AqDoInitAccountReq)this.cmd).rsp).head.RetErrMsg = (((AqDoInitAccountRsp)((IDIPPacket_AqDoInitAccountRsp)((IDIPCmd_AqDoInitAccountReq)this.cmd).rsp).body).RetMsg = "query roleid empty");
/*  84 */       ((IDIPCmd_AqDoInitAccountReq)this.cmd).sendResponse();
/*     */       
/*  86 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoInitAccountReq.handle@role not found|ret=%d|ret_msg=%s|user_id=%s|user_role_list=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoInitAccountRsp)((IDIPCmd_AqDoInitAccountReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoInitAccountRsp)((IDIPCmd_AqDoInitAccountReq)this.cmd).rsp).head.RetErrMsg, userId, xUser.getRoleids().toString(), Integer.valueOf(areaId), Byte.valueOf(((AqDoInitAccountReq)((IDIPPacket_AqDoInitAccountReq)((IDIPCmd_AqDoInitAccountReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoInitAccountReq)((IDIPPacket_AqDoInitAccountReq)((IDIPCmd_AqDoInitAccountReq)this.cmd).req).body).RoleId, Integer.valueOf(((AqDoInitAccountReq)((IDIPPacket_AqDoInitAccountReq)((IDIPCmd_AqDoInitAccountReq)this.cmd).req).body).Source), ((AqDoInitAccountReq)((IDIPPacket_AqDoInitAccountReq)((IDIPCmd_AqDoInitAccountReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  92 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  96 */     Onlines.getInstance().kick(Long.valueOf(roleId), 2049);
/*     */     
/*  98 */     RoleInterface.removeRoleForIDIP(roleId);
/*     */     
/* 100 */     ((AqDoInitAccountRsp)((IDIPPacket_AqDoInitAccountRsp)((IDIPCmd_AqDoInitAccountReq)this.cmd).rsp).body).Result = 0;
/* 101 */     ((AqDoInitAccountRsp)((IDIPPacket_AqDoInitAccountRsp)((IDIPCmd_AqDoInitAccountReq)this.cmd).rsp).body).RetMsg = "ok";
/* 102 */     ((IDIPCmd_AqDoInitAccountReq)this.cmd).sendResponse();
/*     */     
/* 104 */     StringBuilder logStr = new StringBuilder();
/* 105 */     logStr.append(((IDIPPacket_AqDoInitAccountReq)((IDIPCmd_AqDoInitAccountReq)this.cmd).req).head.SendTime).append("|");
/* 106 */     logStr.append(((AqDoInitAccountReq)((IDIPPacket_AqDoInitAccountReq)((IDIPCmd_AqDoInitAccountReq)this.cmd).req).body).OpenId).append("|");
/* 107 */     logStr.append(((AqDoInitAccountReq)((IDIPPacket_AqDoInitAccountReq)((IDIPCmd_AqDoInitAccountReq)this.cmd).req).body).AreaId).append("|");
/* 108 */     logStr.append(((AqDoInitAccountReq)((IDIPPacket_AqDoInitAccountReq)((IDIPCmd_AqDoInitAccountReq)this.cmd).req).body).Partition).append("|");
/* 109 */     logStr.append(roleId).append("|");
/* 110 */     logStr.append(0).append("|");
/* 111 */     logStr.append(((IDIPPacket_AqDoInitAccountReq)((IDIPCmd_AqDoInitAccountReq)this.cmd).req).head.Cmdid).append("|");
/* 112 */     logStr.append(((AqDoInitAccountReq)((IDIPPacket_AqDoInitAccountReq)((IDIPCmd_AqDoInitAccountReq)this.cmd).req).body).Serial).append("|");
/* 113 */     logStr.append(((AqDoInitAccountReq)((IDIPPacket_AqDoInitAccountReq)((IDIPCmd_AqDoInitAccountReq)this.cmd).req).body).Source).append("|");
/* 114 */     logStr.append(((AqDoInitAccountRsp)((IDIPPacket_AqDoInitAccountRsp)((IDIPCmd_AqDoInitAccountReq)this.cmd).rsp).body).Result).append("|");
/* 115 */     logStr.append(((AqDoInitAccountRsp)((IDIPPacket_AqDoInitAccountRsp)((IDIPCmd_AqDoInitAccountReq)this.cmd).rsp).body).RetMsg);
/*     */     
/* 117 */     mzm.gsp.tlog.TLogManager.getInstance().addLog(roleId, "AqIDIPDoInitAccount", logStr.toString());
/*     */     
/* 119 */     GameServer.logger().info(String.format("[idip]PIDIPCmd_AqDoInitAccountReq.handle@do init account done|ret=%d|ret_msg=%s|user_id=%s|user_role_list=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoInitAccountRsp)((IDIPCmd_AqDoInitAccountReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoInitAccountRsp)((IDIPCmd_AqDoInitAccountReq)this.cmd).rsp).head.RetErrMsg, userId, xUser.getRoleids().toString(), Integer.valueOf(areaId), Byte.valueOf(((AqDoInitAccountReq)((IDIPPacket_AqDoInitAccountReq)((IDIPCmd_AqDoInitAccountReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoInitAccountReq)((IDIPPacket_AqDoInitAccountReq)((IDIPCmd_AqDoInitAccountReq)this.cmd).req).body).RoleId, Integer.valueOf(((AqDoInitAccountReq)((IDIPPacket_AqDoInitAccountReq)((IDIPCmd_AqDoInitAccountReq)this.cmd).req).body).Source), ((AqDoInitAccountReq)((IDIPPacket_AqDoInitAccountReq)((IDIPCmd_AqDoInitAccountReq)this.cmd).req).body).Serial }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 125 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   protected String getSerialNo()
/*     */   {
/* 131 */     return ((AqDoInitAccountReq)((IDIPPacket_AqDoInitAccountReq)((IDIPCmd_AqDoInitAccountReq)this.cmd).req).body).Serial;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PIDIPCmd_AqDoInitAccountReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
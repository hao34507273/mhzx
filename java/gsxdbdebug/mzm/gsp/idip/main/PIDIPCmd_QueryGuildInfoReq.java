/*     */ package mzm.gsp.idip.main;
/*     */ 
/*     */ import idip.IDIPCmd_QueryGuildInfoReq;
/*     */ import idip.IDIPPacket_QueryGuildInfoReq;
/*     */ import idip.IDIPPacket_QueryGuildInfoRsp;
/*     */ import idip.QueryGuildInfoReq;
/*     */ import idip.QueryGuildInfoRsp;
/*     */ import idip.core.IdipHeader;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.gang.main.Gang;
/*     */ 
/*     */ public class PIDIPCmd_QueryGuildInfoReq extends PIDIPCmd<IDIPCmd_QueryGuildInfoReq>
/*     */ {
/*     */   public PIDIPCmd_QueryGuildInfoReq(IDIPCmd_QueryGuildInfoReq cmd)
/*     */   {
/*  16 */     super(cmd);
/*     */   }
/*     */   
/*     */   protected boolean handle()
/*     */     throws Exception
/*     */   {
/*  22 */     String openId = ((QueryGuildInfoReq)((IDIPPacket_QueryGuildInfoReq)((IDIPCmd_QueryGuildInfoReq)this.cmd).req).body).OpenId;
/*  23 */     int areaId = ((QueryGuildInfoReq)((IDIPPacket_QueryGuildInfoReq)((IDIPCmd_QueryGuildInfoReq)this.cmd).req).body).AreaId;
/*  24 */     int partition = ((QueryGuildInfoReq)((IDIPPacket_QueryGuildInfoReq)((IDIPCmd_QueryGuildInfoReq)this.cmd).req).body).Partition;
/*     */     
/*  26 */     String userId = idip.core.Utils.getUserId(openId, areaId, partition);
/*  27 */     xbean.User xUser = xtable.User.get(userId);
/*  28 */     if (null == xUser)
/*     */     {
/*  30 */       ((IDIPPacket_QueryGuildInfoRsp)((IDIPCmd_QueryGuildInfoReq)this.cmd).rsp).head.Result = 1;
/*  31 */       ((IDIPPacket_QueryGuildInfoRsp)((IDIPCmd_QueryGuildInfoReq)this.cmd).rsp).head.RetErrMsg = "query userid empty";
/*  32 */       ((IDIPCmd_QueryGuildInfoReq)this.cmd).sendResponse();
/*     */       
/*  34 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_QueryGuildInfoReq.handle@user not found|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|partition=%d|plat_id=%d|open_id=%s|role_id=%s", new Object[] { Integer.valueOf(((IDIPPacket_QueryGuildInfoRsp)((IDIPCmd_QueryGuildInfoReq)this.cmd).rsp).head.Result), ((IDIPPacket_QueryGuildInfoRsp)((IDIPCmd_QueryGuildInfoReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Integer.valueOf(partition), Byte.valueOf(((QueryGuildInfoReq)((IDIPPacket_QueryGuildInfoReq)((IDIPCmd_QueryGuildInfoReq)this.cmd).req).body).PlatId), openId, ((QueryGuildInfoReq)((IDIPPacket_QueryGuildInfoReq)((IDIPCmd_QueryGuildInfoReq)this.cmd).req).body).RoleId }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  39 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  43 */     if (((QueryGuildInfoReq)((IDIPPacket_QueryGuildInfoReq)((IDIPCmd_QueryGuildInfoReq)this.cmd).req).body).RoleId.length() > 32)
/*     */     {
/*  45 */       ((IDIPPacket_QueryGuildInfoRsp)((IDIPCmd_QueryGuildInfoReq)this.cmd).rsp).head.Result = 1;
/*  46 */       ((IDIPPacket_QueryGuildInfoRsp)((IDIPCmd_QueryGuildInfoReq)this.cmd).rsp).head.RetErrMsg = String.format("roleid length > %d", new Object[] { Integer.valueOf(32) });
/*  47 */       ((IDIPCmd_QueryGuildInfoReq)this.cmd).sendResponse();
/*     */       
/*  49 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_QueryGuildInfoReq.handle@roleId length > MAX_ROLEID_LEN|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|partition=%d|plat_id=%d|open_id=%s|role_id=%s", new Object[] { Integer.valueOf(((IDIPPacket_QueryGuildInfoRsp)((IDIPCmd_QueryGuildInfoReq)this.cmd).rsp).head.Result), ((IDIPPacket_QueryGuildInfoRsp)((IDIPCmd_QueryGuildInfoReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Integer.valueOf(partition), Byte.valueOf(((QueryGuildInfoReq)((IDIPPacket_QueryGuildInfoReq)((IDIPCmd_QueryGuildInfoReq)this.cmd).req).body).PlatId), openId, ((QueryGuildInfoReq)((IDIPPacket_QueryGuildInfoReq)((IDIPCmd_QueryGuildInfoReq)this.cmd).req).body).RoleId }));
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
/*  60 */       roleId = Long.parseLong(((QueryGuildInfoReq)((IDIPPacket_QueryGuildInfoReq)((IDIPCmd_QueryGuildInfoReq)this.cmd).req).body).RoleId);
/*     */     }
/*     */     catch (NumberFormatException e)
/*     */     {
/*  64 */       ((IDIPPacket_QueryGuildInfoRsp)((IDIPCmd_QueryGuildInfoReq)this.cmd).rsp).head.Result = 1;
/*  65 */       ((IDIPPacket_QueryGuildInfoRsp)((IDIPCmd_QueryGuildInfoReq)this.cmd).rsp).head.RetErrMsg = "roleid format error";
/*  66 */       ((IDIPCmd_QueryGuildInfoReq)this.cmd).sendResponse();
/*     */       
/*  68 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_QueryGuildInfoReq.handle@role not found|ret=%d|ret_msg=%s|user_id=%s|user_role_list=%s|area_id=%d|partition=%d|plat_id=%d|open_id=%s|role_id=%s", new Object[] { Integer.valueOf(((IDIPPacket_QueryGuildInfoRsp)((IDIPCmd_QueryGuildInfoReq)this.cmd).rsp).head.Result), ((IDIPPacket_QueryGuildInfoRsp)((IDIPCmd_QueryGuildInfoReq)this.cmd).rsp).head.RetErrMsg, userId, xUser.getRoleids().toString(), Integer.valueOf(areaId), Integer.valueOf(partition), Byte.valueOf(((QueryGuildInfoReq)((IDIPPacket_QueryGuildInfoReq)((IDIPCmd_QueryGuildInfoReq)this.cmd).req).body).PlatId), openId, ((QueryGuildInfoReq)((IDIPPacket_QueryGuildInfoReq)((IDIPCmd_QueryGuildInfoReq)this.cmd).req).body).RoleId }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  73 */       return false;
/*     */     }
/*     */     
/*  76 */     if ((!mzm.gsp.role.main.RoleInterface.isRoleExist(roleId, true)) || (!xUser.getRoleids().contains(Long.valueOf(roleId))))
/*     */     {
/*  78 */       ((IDIPPacket_QueryGuildInfoRsp)((IDIPCmd_QueryGuildInfoReq)this.cmd).rsp).head.Result = 1;
/*  79 */       ((IDIPPacket_QueryGuildInfoRsp)((IDIPCmd_QueryGuildInfoReq)this.cmd).rsp).head.RetErrMsg = "query roleid empty";
/*  80 */       ((IDIPCmd_QueryGuildInfoReq)this.cmd).sendResponse();
/*     */       
/*  82 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_QueryGuildInfoReq.handle@role not found|ret=%d|ret_msg=%s|user_id=%s|user_role_list=%s|area_id=%d|partition=%d|plat_id=%d|open_id=%s|role_id=%s", new Object[] { Integer.valueOf(((IDIPPacket_QueryGuildInfoRsp)((IDIPCmd_QueryGuildInfoReq)this.cmd).rsp).head.Result), ((IDIPPacket_QueryGuildInfoRsp)((IDIPCmd_QueryGuildInfoReq)this.cmd).rsp).head.RetErrMsg, userId, xUser.getRoleids().toString(), Integer.valueOf(areaId), Integer.valueOf(partition), Byte.valueOf(((QueryGuildInfoReq)((IDIPPacket_QueryGuildInfoReq)((IDIPCmd_QueryGuildInfoReq)this.cmd).req).body).PlatId), openId, ((QueryGuildInfoReq)((IDIPPacket_QueryGuildInfoReq)((IDIPCmd_QueryGuildInfoReq)this.cmd).req).body).RoleId }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  87 */       return false;
/*     */     }
/*     */     
/*  90 */     Gang gang = mzm.gsp.gang.main.GangInterface.getGangByRoleId(roleId, true);
/*  91 */     if (gang != null)
/*     */     {
/*  93 */       long gangid = gang.getGangId();
/*  94 */       ((QueryGuildInfoRsp)((IDIPPacket_QueryGuildInfoRsp)((IDIPCmd_QueryGuildInfoReq)this.cmd).rsp).body).GuildId = String.valueOf(gangid);
/*  95 */       ((QueryGuildInfoRsp)((IDIPPacket_QueryGuildInfoRsp)((IDIPCmd_QueryGuildInfoReq)this.cmd).rsp).body).GuildId32 = 0;
/*     */       
/*  97 */       ((QueryGuildInfoRsp)((IDIPPacket_QueryGuildInfoRsp)((IDIPCmd_QueryGuildInfoReq)this.cmd).rsp).body).GuildName = idip.core.Utils.urlEncode1738(gang.getName(), "UTF-8");
/*     */       
/*  99 */       long bangZhuRoleid = gang.getBangZhuId();
/* 100 */       ((QueryGuildInfoRsp)((IDIPPacket_QueryGuildInfoRsp)((IDIPCmd_QueryGuildInfoReq)this.cmd).rsp).body).LeaderName = idip.core.Utils.urlEncode1738(mzm.gsp.role.main.RoleInterface.getName(bangZhuRoleid), "UTF-8");
/* 101 */       ((QueryGuildInfoRsp)((IDIPPacket_QueryGuildInfoRsp)((IDIPCmd_QueryGuildInfoReq)this.cmd).rsp).body).LeaderRoleId = String.valueOf(bangZhuRoleid);
/*     */       
/* 103 */       ((QueryGuildInfoRsp)((IDIPPacket_QueryGuildInfoRsp)((IDIPCmd_QueryGuildInfoReq)this.cmd).rsp).body).Rank = 0;
/* 104 */       ((QueryGuildInfoRsp)((IDIPPacket_QueryGuildInfoRsp)((IDIPCmd_QueryGuildInfoReq)this.cmd).rsp).body).Level = gang.getLevel();
/* 105 */       ((QueryGuildInfoRsp)((IDIPPacket_QueryGuildInfoRsp)((IDIPCmd_QueryGuildInfoReq)this.cmd).rsp).body).EnableCnt = mzm.gsp.gang.main.GangInterface.getGangMaxNum(gangid);
/* 106 */       ((QueryGuildInfoRsp)((IDIPPacket_QueryGuildInfoRsp)((IDIPCmd_QueryGuildInfoReq)this.cmd).rsp).body).CurMemberCnt = gang.getMemberSize();
/* 107 */       String announcement = mzm.gsp.gang.main.GangInterface.getGangAnnouncement(gangid);
/* 108 */       if ((announcement != null) && (!announcement.isEmpty()))
/*     */       {
/* 110 */         ((QueryGuildInfoRsp)((IDIPPacket_QueryGuildInfoRsp)((IDIPCmd_QueryGuildInfoReq)this.cmd).rsp).body).Content = idip.core.Utils.urlEncode1738(announcement, "UTF-8");
/*     */       }
/* 112 */       String gangDecla = mzm.gsp.gang.main.GangInterface.getGangPurpose(gangid);
/* 113 */       if ((gangDecla != null) && (!gangDecla.isEmpty()))
/*     */       {
/* 115 */         ((QueryGuildInfoRsp)((IDIPPacket_QueryGuildInfoRsp)((IDIPCmd_QueryGuildInfoReq)this.cmd).rsp).body).GuildDecla = idip.core.Utils.urlEncode1738(gangDecla, "UTF-8");
/*     */       }
/* 117 */       ((QueryGuildInfoRsp)((IDIPPacket_QueryGuildInfoRsp)((IDIPCmd_QueryGuildInfoReq)this.cmd).rsp).body).Money = mzm.gsp.gang.main.GangInterface.getGangMoney(gangid);
/*     */     }
/*     */     else
/*     */     {
/* 121 */       ((QueryGuildInfoRsp)((IDIPPacket_QueryGuildInfoRsp)((IDIPCmd_QueryGuildInfoReq)this.cmd).rsp).body).GuildId = String.valueOf(0);
/*     */     }
/*     */     
/* 124 */     ((IDIPPacket_QueryGuildInfoRsp)((IDIPCmd_QueryGuildInfoReq)this.cmd).rsp).head.Result = 0;
/* 125 */     ((IDIPPacket_QueryGuildInfoRsp)((IDIPCmd_QueryGuildInfoReq)this.cmd).rsp).head.RetErrMsg = "ok";
/* 126 */     ((IDIPCmd_QueryGuildInfoReq)this.cmd).sendResponse();
/*     */     
/* 128 */     GameServer.logger().info(String.format("[idip]PIDIPCmd_QueryGuildInfoReq.handle@query guild info success|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|partition=%d|plat_id=%d|open_id=%s|role_id=%s", new Object[] { Integer.valueOf(((IDIPPacket_QueryGuildInfoRsp)((IDIPCmd_QueryGuildInfoReq)this.cmd).rsp).head.Result), ((IDIPPacket_QueryGuildInfoRsp)((IDIPCmd_QueryGuildInfoReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Integer.valueOf(partition), Byte.valueOf(((QueryGuildInfoReq)((IDIPPacket_QueryGuildInfoReq)((IDIPCmd_QueryGuildInfoReq)this.cmd).req).body).PlatId), openId, ((QueryGuildInfoReq)((IDIPPacket_QueryGuildInfoReq)((IDIPCmd_QueryGuildInfoReq)this.cmd).req).body).RoleId }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 133 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PIDIPCmd_QueryGuildInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
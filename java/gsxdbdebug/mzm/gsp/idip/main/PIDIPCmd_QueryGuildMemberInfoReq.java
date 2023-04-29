/*     */ package mzm.gsp.idip.main;
/*     */ 
/*     */ import idip.IDIPCmd_QueryGuildMemberInfoReq;
/*     */ import idip.IDIPPacket_QueryGuildMemberInfoReq;
/*     */ import idip.IDIPPacket_QueryGuildMemberInfoRsp;
/*     */ import idip.MemberInfo;
/*     */ import idip.QueryGuildMemberInfoReq;
/*     */ import idip.QueryGuildMemberInfoRsp;
/*     */ import idip.core.IdipHeader;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.gang.main.Gang;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.role.main.Role;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class PIDIPCmd_QueryGuildMemberInfoReq extends PIDIPCmd<IDIPCmd_QueryGuildMemberInfoReq>
/*     */ {
/*     */   public PIDIPCmd_QueryGuildMemberInfoReq(IDIPCmd_QueryGuildMemberInfoReq cmd)
/*     */   {
/*  23 */     super(cmd);
/*     */   }
/*     */   
/*     */   protected boolean handle()
/*     */     throws Exception
/*     */   {
/*  29 */     long roleId = -1L;
/*  30 */     if (!((QueryGuildMemberInfoReq)((IDIPPacket_QueryGuildMemberInfoReq)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).req).body).RoleId.isEmpty())
/*     */     {
/*     */ 
/*  33 */       if (((QueryGuildMemberInfoReq)((IDIPPacket_QueryGuildMemberInfoReq)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).req).body).RoleId.length() > 32)
/*     */       {
/*  35 */         ((IDIPPacket_QueryGuildMemberInfoRsp)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).rsp).head.Result = 1;
/*  36 */         ((IDIPPacket_QueryGuildMemberInfoRsp)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).rsp).head.RetErrMsg = String.format("roleid length > %d", new Object[] { Integer.valueOf(32) });
/*  37 */         ((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).sendResponse();
/*     */         
/*  39 */         GameServer.logger().error(String.format("[idip]PIDIPCmd_QueryGuildMemberInfoReq.handle@roleid length > MAX_ROLEID_LEN|ret=%d|ret_msg=%s|area_id=%d|partition=%d|plat_id=%d|open_id=%s|role_id=%s|guild_id=%s|page_no=%d", new Object[] { Integer.valueOf(((IDIPPacket_QueryGuildMemberInfoRsp)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).rsp).head.Result), ((IDIPPacket_QueryGuildMemberInfoRsp)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).rsp).head.RetErrMsg, Integer.valueOf(((QueryGuildMemberInfoReq)((IDIPPacket_QueryGuildMemberInfoReq)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).req).body).AreaId), Integer.valueOf(((QueryGuildMemberInfoReq)((IDIPPacket_QueryGuildMemberInfoReq)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).req).body).Partition), Byte.valueOf(((QueryGuildMemberInfoReq)((IDIPPacket_QueryGuildMemberInfoReq)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).req).body).PlatId), ((QueryGuildMemberInfoReq)((IDIPPacket_QueryGuildMemberInfoReq)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).req).body).OpenId, ((QueryGuildMemberInfoReq)((IDIPPacket_QueryGuildMemberInfoReq)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).req).body).RoleId, ((QueryGuildMemberInfoReq)((IDIPPacket_QueryGuildMemberInfoReq)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).req).body).GuildId, Integer.valueOf(((QueryGuildMemberInfoReq)((IDIPPacket_QueryGuildMemberInfoReq)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).req).body).PageNo) }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  45 */         return false;
/*     */       }
/*     */       try
/*     */       {
/*  49 */         roleId = Long.parseLong(((QueryGuildMemberInfoReq)((IDIPPacket_QueryGuildMemberInfoReq)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).req).body).RoleId);
/*     */       }
/*     */       catch (NumberFormatException e)
/*     */       {
/*  53 */         ((IDIPPacket_QueryGuildMemberInfoRsp)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).rsp).head.Result = 1;
/*  54 */         ((IDIPPacket_QueryGuildMemberInfoRsp)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).rsp).head.RetErrMsg = "roleid format error";
/*  55 */         ((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).sendResponse();
/*     */         
/*  57 */         GameServer.logger().error(String.format("[idip]PIDIPCmd_QueryGuildMemberInfoReq.handle@roleid format error|ret=%d|ret_msg=%s|area_id=%d|partition=%d|plat_id=%d|open_id=%s|role_id=%s|guild_id=%s|page_no=%d", new Object[] { Integer.valueOf(((IDIPPacket_QueryGuildMemberInfoRsp)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).rsp).head.Result), ((IDIPPacket_QueryGuildMemberInfoRsp)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).rsp).head.RetErrMsg, Integer.valueOf(((QueryGuildMemberInfoReq)((IDIPPacket_QueryGuildMemberInfoReq)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).req).body).AreaId), Integer.valueOf(((QueryGuildMemberInfoReq)((IDIPPacket_QueryGuildMemberInfoReq)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).req).body).Partition), Byte.valueOf(((QueryGuildMemberInfoReq)((IDIPPacket_QueryGuildMemberInfoReq)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).req).body).PlatId), ((QueryGuildMemberInfoReq)((IDIPPacket_QueryGuildMemberInfoReq)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).req).body).OpenId, ((QueryGuildMemberInfoReq)((IDIPPacket_QueryGuildMemberInfoReq)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).req).body).RoleId, ((QueryGuildMemberInfoReq)((IDIPPacket_QueryGuildMemberInfoReq)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).req).body).GuildId, Integer.valueOf(((QueryGuildMemberInfoReq)((IDIPPacket_QueryGuildMemberInfoReq)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).req).body).PageNo) }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  63 */         return false;
/*     */       }
/*     */     }
/*     */     
/*  67 */     Gang gang = null;
/*  68 */     if (roleId != -1L)
/*     */     {
/*  70 */       String openId = ((QueryGuildMemberInfoReq)((IDIPPacket_QueryGuildMemberInfoReq)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).req).body).OpenId;
/*  71 */       int areaId = ((QueryGuildMemberInfoReq)((IDIPPacket_QueryGuildMemberInfoReq)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).req).body).AreaId;
/*  72 */       int partition = ((QueryGuildMemberInfoReq)((IDIPPacket_QueryGuildMemberInfoReq)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).req).body).Partition;
/*  73 */       String userId = idip.core.Utils.getUserId(openId, areaId, partition);
/*  74 */       xbean.User xUser = xtable.User.get(userId);
/*  75 */       if (null == xUser)
/*     */       {
/*  77 */         ((IDIPPacket_QueryGuildMemberInfoRsp)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).rsp).head.Result = 1;
/*  78 */         ((IDIPPacket_QueryGuildMemberInfoRsp)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).rsp).head.RetErrMsg = "query userid empty";
/*  79 */         ((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).sendResponse();
/*     */         
/*  81 */         GameServer.logger().error(String.format("[idip]PIDIPCmd_QueryGuildMemberInfoReq.handle@user not found|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|partition=%d|plat_id=%d|open_id=%s|role_id=%s|guild_id=%s|page_no=%d", new Object[] { Integer.valueOf(((IDIPPacket_QueryGuildMemberInfoRsp)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).rsp).head.Result), ((IDIPPacket_QueryGuildMemberInfoRsp)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Integer.valueOf(partition), Byte.valueOf(((QueryGuildMemberInfoReq)((IDIPPacket_QueryGuildMemberInfoReq)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).req).body).PlatId), openId, ((QueryGuildMemberInfoReq)((IDIPPacket_QueryGuildMemberInfoReq)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).req).body).RoleId, ((QueryGuildMemberInfoReq)((IDIPPacket_QueryGuildMemberInfoReq)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).req).body).GuildId, Integer.valueOf(((QueryGuildMemberInfoReq)((IDIPPacket_QueryGuildMemberInfoReq)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).req).body).PageNo) }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  87 */         return false;
/*     */       }
/*  89 */       if ((!xUser.getRoleids().contains(Long.valueOf(roleId))) || (!mzm.gsp.role.main.RoleInterface.isRoleExist(roleId, false)))
/*     */       {
/*  91 */         ((IDIPPacket_QueryGuildMemberInfoRsp)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).rsp).head.Result = 1;
/*  92 */         ((IDIPPacket_QueryGuildMemberInfoRsp)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).rsp).head.RetErrMsg = "query roleid empty";
/*  93 */         ((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).sendResponse();
/*     */         
/*  95 */         GameServer.logger().error(String.format("[idip]PIDIPCmd_QueryGuildMemberInfoReq.handle@role not found|ret=%d|ret_msg=%s|user_id=%s|user_role_list=%s|area_id=%d|partition=%d|plat_id=%d|open_id=%s|role_id=%s|guild_id=%s|page_no=%d", new Object[] { Integer.valueOf(((IDIPPacket_QueryGuildMemberInfoRsp)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).rsp).head.Result), ((IDIPPacket_QueryGuildMemberInfoRsp)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).rsp).head.RetErrMsg, userId, xUser.getRoleids().toString(), Integer.valueOf(areaId), Integer.valueOf(partition), Byte.valueOf(((QueryGuildMemberInfoReq)((IDIPPacket_QueryGuildMemberInfoReq)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).req).body).PlatId), openId, ((QueryGuildMemberInfoReq)((IDIPPacket_QueryGuildMemberInfoReq)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).req).body).RoleId, ((QueryGuildMemberInfoReq)((IDIPPacket_QueryGuildMemberInfoReq)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).req).body).GuildId, Integer.valueOf(((QueryGuildMemberInfoReq)((IDIPPacket_QueryGuildMemberInfoReq)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).req).body).PageNo) }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 101 */         return false;
/*     */       }
/*     */       
/* 104 */       gang = GangInterface.getGangByRoleId(roleId, false);
/*     */     }
/*     */     
/* 107 */     if (gang == null)
/*     */     {
/* 109 */       if (!((QueryGuildMemberInfoReq)((IDIPPacket_QueryGuildMemberInfoReq)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).req).body).GuildId.isEmpty())
/*     */       {
/* 111 */         if (((QueryGuildMemberInfoReq)((IDIPPacket_QueryGuildMemberInfoReq)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).req).body).GuildId.length() > 64)
/*     */         {
/* 113 */           ((IDIPPacket_QueryGuildMemberInfoRsp)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).rsp).head.Result = 64266;
/* 114 */           ((IDIPPacket_QueryGuildMemberInfoRsp)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).rsp).head.RetErrMsg = String.format("guild_id length > %d", new Object[] { Integer.valueOf(64) });
/* 115 */           ((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).sendResponse();
/*     */           
/* 117 */           GameServer.logger().error(String.format("[idip]PIDIPCmd_QueryGuildMemberInfoReq.handle@guild_id length > MAX_GUILDID_LEN|ret=%d|ret_msg=%s|area_id=%d|partition=%d|plat_id=%d|open_id=%s|role_id=%s|guild_id=%s|page_no=%d", new Object[] { Integer.valueOf(((IDIPPacket_QueryGuildMemberInfoRsp)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).rsp).head.Result), ((IDIPPacket_QueryGuildMemberInfoRsp)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).rsp).head.RetErrMsg, Integer.valueOf(((QueryGuildMemberInfoReq)((IDIPPacket_QueryGuildMemberInfoReq)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).req).body).AreaId), Integer.valueOf(((QueryGuildMemberInfoReq)((IDIPPacket_QueryGuildMemberInfoReq)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).req).body).Partition), Byte.valueOf(((QueryGuildMemberInfoReq)((IDIPPacket_QueryGuildMemberInfoReq)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).req).body).PlatId), ((QueryGuildMemberInfoReq)((IDIPPacket_QueryGuildMemberInfoReq)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).req).body).OpenId, ((QueryGuildMemberInfoReq)((IDIPPacket_QueryGuildMemberInfoReq)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).req).body).RoleId, ((QueryGuildMemberInfoReq)((IDIPPacket_QueryGuildMemberInfoReq)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).req).body).GuildId, Integer.valueOf(((QueryGuildMemberInfoReq)((IDIPPacket_QueryGuildMemberInfoReq)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).req).body).PageNo) }));
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 123 */           return false;
/*     */         }
/*     */         
/* 126 */         long guildid = 0L;
/*     */         try
/*     */         {
/* 129 */           guildid = Long.parseLong(((QueryGuildMemberInfoReq)((IDIPPacket_QueryGuildMemberInfoReq)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).req).body).GuildId);
/*     */         }
/*     */         catch (NumberFormatException e)
/*     */         {
/* 133 */           ((IDIPPacket_QueryGuildMemberInfoRsp)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).rsp).head.Result = 64266;
/* 134 */           ((IDIPPacket_QueryGuildMemberInfoRsp)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).rsp).head.RetErrMsg = "guild_id format error";
/* 135 */           ((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).sendResponse();
/*     */           
/* 137 */           GameServer.logger().error(String.format("[idip]PIDIPCmd_QueryGuildMemberInfoReq.handle@guild_id format error|ret=%d|ret_msg=%s|area_id=%d|partition=%d|plat_id=%d|open_id=%s|role_id=%s|guild_id=%s|page_no=%d", new Object[] { Integer.valueOf(((IDIPPacket_QueryGuildMemberInfoRsp)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).rsp).head.Result), ((IDIPPacket_QueryGuildMemberInfoRsp)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).rsp).head.RetErrMsg, Integer.valueOf(((QueryGuildMemberInfoReq)((IDIPPacket_QueryGuildMemberInfoReq)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).req).body).AreaId), Integer.valueOf(((QueryGuildMemberInfoReq)((IDIPPacket_QueryGuildMemberInfoReq)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).req).body).Partition), Byte.valueOf(((QueryGuildMemberInfoReq)((IDIPPacket_QueryGuildMemberInfoReq)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).req).body).PlatId), ((QueryGuildMemberInfoReq)((IDIPPacket_QueryGuildMemberInfoReq)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).req).body).OpenId, ((QueryGuildMemberInfoReq)((IDIPPacket_QueryGuildMemberInfoReq)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).req).body).RoleId, ((QueryGuildMemberInfoReq)((IDIPPacket_QueryGuildMemberInfoReq)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).req).body).GuildId, Integer.valueOf(((QueryGuildMemberInfoReq)((IDIPPacket_QueryGuildMemberInfoReq)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).req).body).PageNo) }));
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 143 */           return false;
/*     */         }
/*     */         
/* 146 */         gang = GangInterface.getGang(guildid, false);
/*     */       }
/*     */     }
/*     */     
/* 150 */     if (gang == null)
/*     */     {
/* 152 */       ((IDIPPacket_QueryGuildMemberInfoRsp)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).rsp).head.Result = 64265;
/* 153 */       ((IDIPPacket_QueryGuildMemberInfoRsp)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).rsp).head.RetErrMsg = "gang not exist";
/* 154 */       ((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).sendResponse();
/*     */       
/* 156 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_QueryGuildMemberInfoReq.handle@gang not exist|ret=%d|ret_msg=%s|area_id=%d|partition=%d|plat_id=%d|open_id=%s|role_id=%s|guild_id=%s|page_no=%d", new Object[] { Integer.valueOf(((IDIPPacket_QueryGuildMemberInfoRsp)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).rsp).head.Result), ((IDIPPacket_QueryGuildMemberInfoRsp)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).rsp).head.RetErrMsg, Integer.valueOf(((QueryGuildMemberInfoReq)((IDIPPacket_QueryGuildMemberInfoReq)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).req).body).AreaId), Integer.valueOf(((QueryGuildMemberInfoReq)((IDIPPacket_QueryGuildMemberInfoReq)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).req).body).Partition), Byte.valueOf(((QueryGuildMemberInfoReq)((IDIPPacket_QueryGuildMemberInfoReq)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).req).body).PlatId), ((QueryGuildMemberInfoReq)((IDIPPacket_QueryGuildMemberInfoReq)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).req).body).OpenId, ((QueryGuildMemberInfoReq)((IDIPPacket_QueryGuildMemberInfoReq)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).req).body).RoleId, ((QueryGuildMemberInfoReq)((IDIPPacket_QueryGuildMemberInfoReq)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).req).body).GuildId, Integer.valueOf(((QueryGuildMemberInfoReq)((IDIPPacket_QueryGuildMemberInfoReq)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).req).body).PageNo) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 162 */       return false;
/*     */     }
/*     */     
/* 165 */     int pageNo = ((QueryGuildMemberInfoReq)((IDIPPacket_QueryGuildMemberInfoReq)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).req).body).PageNo;
/* 166 */     if (pageNo <= 0)
/*     */     {
/* 168 */       ((IDIPPacket_QueryGuildMemberInfoRsp)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).rsp).head.Result = 64264;
/* 169 */       ((IDIPPacket_QueryGuildMemberInfoRsp)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).rsp).head.RetErrMsg = "page_no invalid";
/* 170 */       ((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).sendResponse();
/*     */       
/* 172 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_QueryGuildMemberInfoReq.handle@page_no <= 0|ret=%d|ret_msg=%s|area_id=%d|partition=%d|plat_id=%d|open_id=%s|role_id=%s|guild_id=%s|page_no=%d", new Object[] { Integer.valueOf(((IDIPPacket_QueryGuildMemberInfoRsp)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).rsp).head.Result), ((IDIPPacket_QueryGuildMemberInfoRsp)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).rsp).head.RetErrMsg, Integer.valueOf(((QueryGuildMemberInfoReq)((IDIPPacket_QueryGuildMemberInfoReq)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).req).body).AreaId), Integer.valueOf(((QueryGuildMemberInfoReq)((IDIPPacket_QueryGuildMemberInfoReq)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).req).body).Partition), Byte.valueOf(((QueryGuildMemberInfoReq)((IDIPPacket_QueryGuildMemberInfoReq)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).req).body).PlatId), ((QueryGuildMemberInfoReq)((IDIPPacket_QueryGuildMemberInfoReq)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).req).body).OpenId, ((QueryGuildMemberInfoReq)((IDIPPacket_QueryGuildMemberInfoReq)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).req).body).RoleId, ((QueryGuildMemberInfoReq)((IDIPPacket_QueryGuildMemberInfoReq)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).req).body).GuildId, Integer.valueOf(((QueryGuildMemberInfoReq)((IDIPPacket_QueryGuildMemberInfoReq)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).req).body).PageNo) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 178 */       return false;
/*     */     }
/*     */     
/* 181 */     int size = gang.getMemberSize();
/* 182 */     int pageSize = 100;
/* 183 */     int totalPageNo = size / 100 + (size % 100 == 0 ? 0 : 1);
/* 184 */     int fromIndex = (pageNo - 1) * 100;
/*     */     
/* 186 */     ((QueryGuildMemberInfoRsp)((IDIPPacket_QueryGuildMemberInfoRsp)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).rsp).body).TotalPageNo = totalPageNo;
/* 187 */     if (fromIndex >= size)
/*     */     {
/* 189 */       ((IDIPPacket_QueryGuildMemberInfoRsp)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).rsp).head.Result = 0;
/* 190 */       ((IDIPPacket_QueryGuildMemberInfoRsp)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).rsp).head.RetErrMsg = "ok";
/* 191 */       ((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).sendResponse();
/*     */       
/* 193 */       GameServer.logger().info(String.format("[idip]PIDIPCmd_QueryGuildMemberInfoReq.handle@query guild memeber info success|ret=%d|ret_msg=%s|area_id=%d|partition=%d|plat_id=%d|open_id=%s|role_id=%s|guild_id=%s|page_no=%d", new Object[] { Integer.valueOf(((IDIPPacket_QueryGuildMemberInfoRsp)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).rsp).head.Result), ((IDIPPacket_QueryGuildMemberInfoRsp)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).rsp).head.RetErrMsg, Integer.valueOf(((QueryGuildMemberInfoReq)((IDIPPacket_QueryGuildMemberInfoReq)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).req).body).AreaId), Integer.valueOf(((QueryGuildMemberInfoReq)((IDIPPacket_QueryGuildMemberInfoReq)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).req).body).Partition), Byte.valueOf(((QueryGuildMemberInfoReq)((IDIPPacket_QueryGuildMemberInfoReq)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).req).body).PlatId), ((QueryGuildMemberInfoReq)((IDIPPacket_QueryGuildMemberInfoReq)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).req).body).OpenId, ((QueryGuildMemberInfoReq)((IDIPPacket_QueryGuildMemberInfoReq)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).req).body).RoleId, ((QueryGuildMemberInfoReq)((IDIPPacket_QueryGuildMemberInfoReq)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).req).body).GuildId, Integer.valueOf(((QueryGuildMemberInfoReq)((IDIPPacket_QueryGuildMemberInfoReq)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).req).body).PageNo) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 199 */       return true;
/*     */     }
/*     */     
/* 202 */     int toIndex = pageNo * 100;
/* 203 */     if (toIndex > size)
/*     */     {
/* 205 */       toIndex = size;
/*     */     }
/*     */     
/* 208 */     for (Iterator i$ = gang.getMemberList().subList(fromIndex, toIndex).iterator(); i$.hasNext();) { long memberRoleid = ((Long)i$.next()).longValue();
/*     */       
/* 210 */       ((QueryGuildMemberInfoRsp)((IDIPPacket_QueryGuildMemberInfoRsp)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).rsp).body).MemberInfo.add(fillMemberInfo(memberRoleid, gang));
/*     */     }
/* 212 */     ((QueryGuildMemberInfoRsp)((IDIPPacket_QueryGuildMemberInfoRsp)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).rsp).body).MemberInfo_count = ((QueryGuildMemberInfoRsp)((IDIPPacket_QueryGuildMemberInfoRsp)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).rsp).body).MemberInfo.size();
/*     */     
/* 214 */     ((IDIPPacket_QueryGuildMemberInfoRsp)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).rsp).head.Result = 0;
/* 215 */     ((IDIPPacket_QueryGuildMemberInfoRsp)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).rsp).head.RetErrMsg = "ok";
/* 216 */     ((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).sendResponse();
/*     */     
/* 218 */     GameServer.logger().info(String.format("[idip]PIDIPCmd_QueryGuildMemberInfoReq.handle@query guild memeber info success|ret=%d|ret_msg=%s|area_id=%d|partition=%d|plat_id=%d|open_id=%s|role_id=%s|guild_id=%s|page_no=%d", new Object[] { Integer.valueOf(((IDIPPacket_QueryGuildMemberInfoRsp)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).rsp).head.Result), ((IDIPPacket_QueryGuildMemberInfoRsp)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).rsp).head.RetErrMsg, Integer.valueOf(((QueryGuildMemberInfoReq)((IDIPPacket_QueryGuildMemberInfoReq)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).req).body).AreaId), Integer.valueOf(((QueryGuildMemberInfoReq)((IDIPPacket_QueryGuildMemberInfoReq)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).req).body).Partition), Byte.valueOf(((QueryGuildMemberInfoReq)((IDIPPacket_QueryGuildMemberInfoReq)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).req).body).PlatId), ((QueryGuildMemberInfoReq)((IDIPPacket_QueryGuildMemberInfoReq)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).req).body).OpenId, ((QueryGuildMemberInfoReq)((IDIPPacket_QueryGuildMemberInfoReq)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).req).body).RoleId, ((QueryGuildMemberInfoReq)((IDIPPacket_QueryGuildMemberInfoReq)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).req).body).GuildId, Integer.valueOf(((QueryGuildMemberInfoReq)((IDIPPacket_QueryGuildMemberInfoReq)((IDIPCmd_QueryGuildMemberInfoReq)this.cmd).req).body).PageNo) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 224 */     return true;
/*     */   }
/*     */   
/*     */   private MemberInfo fillMemberInfo(long roleid, Gang gang)
/*     */   {
/* 229 */     Role role = mzm.gsp.role.main.RoleInterface.getRole(roleid, false);
/* 230 */     MemberInfo memberInfo = new MemberInfo();
/* 231 */     memberInfo.RoleId = String.valueOf(roleid);
/*     */     try
/*     */     {
/* 234 */       memberInfo.RoleName = idip.core.Utils.urlEncode1738(role.getName(), "UTF-8");
/*     */     }
/*     */     catch (java.io.UnsupportedEncodingException e) {}
/*     */     
/*     */ 
/*     */ 
/* 240 */     memberInfo.Pos = gang.getGangDuty(roleid);
/* 241 */     memberInfo.Job = role.getOccupationId();
/* 242 */     memberInfo.Level = role.getLevel();
/* 243 */     memberInfo.Fight = role.getFightValue();
/* 244 */     memberInfo.Contribute = ((int)GangInterface.getBangGong(roleid));
/* 245 */     memberInfo.IsOnline = (mzm.gsp.online.main.OnlineManager.getInstance().isOnline(roleid) ? 1 : 0);
/* 246 */     String userId = role.getUserId();
/* 247 */     String OpenID = gnet.link.Onlines.getInstance().findOpenid(userId);
/* 248 */     memberInfo.OpenId = OpenID;
/* 249 */     return memberInfo;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PIDIPCmd_QueryGuildMemberInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
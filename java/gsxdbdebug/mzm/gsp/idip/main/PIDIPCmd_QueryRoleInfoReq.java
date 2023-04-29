/*     */ package mzm.gsp.idip.main;
/*     */ 
/*     */ import idip.IDIPCmd_QueryRoleInfoReq;
/*     */ import idip.IDIPPacket_QueryRoleInfoReq;
/*     */ import idip.IDIPPacket_QueryRoleInfoRsp;
/*     */ import idip.QueryRoleInfoReq;
/*     */ import idip.QueryRoleInfoRsp;
/*     */ import idip.core.IdipHeader;
/*     */ import idip.core.Utils;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.gang.main.Gang;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.mall.main.MallInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.Role;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.CommonUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class PIDIPCmd_QueryRoleInfoReq
/*     */   extends PIDIPCmd<IDIPCmd_QueryRoleInfoReq>
/*     */ {
/*     */   private static final int roleNoLen = 6;
/*     */   
/*     */   public PIDIPCmd_QueryRoleInfoReq(IDIPCmd_QueryRoleInfoReq cmd)
/*     */   {
/*  28 */     super(cmd);
/*     */   }
/*     */   
/*     */   protected boolean handle()
/*     */     throws Exception
/*     */   {
/*  34 */     long roleId = -1L;
/*  35 */     if (!((QueryRoleInfoReq)((IDIPPacket_QueryRoleInfoReq)((IDIPCmd_QueryRoleInfoReq)this.cmd).req).body).RoleId.isEmpty())
/*     */     {
/*     */ 
/*  38 */       if (((QueryRoleInfoReq)((IDIPPacket_QueryRoleInfoReq)((IDIPCmd_QueryRoleInfoReq)this.cmd).req).body).RoleId.length() > 32)
/*     */       {
/*  40 */         ((IDIPPacket_QueryRoleInfoRsp)((IDIPCmd_QueryRoleInfoReq)this.cmd).rsp).head.Result = 1;
/*  41 */         ((IDIPPacket_QueryRoleInfoRsp)((IDIPCmd_QueryRoleInfoReq)this.cmd).rsp).head.RetErrMsg = String.format("roleid length > %d", new Object[] { Integer.valueOf(32) });
/*  42 */         ((IDIPCmd_QueryRoleInfoReq)this.cmd).sendResponse();
/*     */         
/*  44 */         GameServer.logger().error(String.format("[idip]PIDIPCmd_QueryRoleInfoReq.handle@roleId length > MAX_ROLEID_LEN|ret=%d|ret_msg=%s|area_id=%d|partition=%d|plat_id=%d|RoleName=%s|RoleNo=%s|role_id=%s", new Object[] { Integer.valueOf(((IDIPPacket_QueryRoleInfoRsp)((IDIPCmd_QueryRoleInfoReq)this.cmd).rsp).head.Result), ((IDIPPacket_QueryRoleInfoRsp)((IDIPCmd_QueryRoleInfoReq)this.cmd).rsp).head.RetErrMsg, Integer.valueOf(((QueryRoleInfoReq)((IDIPPacket_QueryRoleInfoReq)((IDIPCmd_QueryRoleInfoReq)this.cmd).req).body).AreaId), Integer.valueOf(((QueryRoleInfoReq)((IDIPPacket_QueryRoleInfoReq)((IDIPCmd_QueryRoleInfoReq)this.cmd).req).body).Partition), Byte.valueOf(((QueryRoleInfoReq)((IDIPPacket_QueryRoleInfoReq)((IDIPCmd_QueryRoleInfoReq)this.cmd).req).body).PlatId), ((QueryRoleInfoReq)((IDIPPacket_QueryRoleInfoReq)((IDIPCmd_QueryRoleInfoReq)this.cmd).req).body).RoleName, ((QueryRoleInfoReq)((IDIPPacket_QueryRoleInfoReq)((IDIPCmd_QueryRoleInfoReq)this.cmd).req).body).RoleNo, ((QueryRoleInfoReq)((IDIPPacket_QueryRoleInfoReq)((IDIPCmd_QueryRoleInfoReq)this.cmd).req).body).RoleId }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  50 */         return false;
/*     */       }
/*     */       
/*     */       try
/*     */       {
/*  55 */         roleId = Long.parseLong(((QueryRoleInfoReq)((IDIPPacket_QueryRoleInfoReq)((IDIPCmd_QueryRoleInfoReq)this.cmd).req).body).RoleId);
/*     */       }
/*     */       catch (NumberFormatException e) {}
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  63 */     if (roleId == -1L)
/*     */     {
/*  65 */       if (!((QueryRoleInfoReq)((IDIPPacket_QueryRoleInfoReq)((IDIPCmd_QueryRoleInfoReq)this.cmd).req).body).RoleNo.isEmpty())
/*     */       {
/*  67 */         int len = ((QueryRoleInfoReq)((IDIPPacket_QueryRoleInfoReq)((IDIPCmd_QueryRoleInfoReq)this.cmd).req).body).RoleNo.length();
/*  68 */         if (len > 32)
/*     */         {
/*  70 */           ((IDIPPacket_QueryRoleInfoRsp)((IDIPCmd_QueryRoleInfoReq)this.cmd).rsp).head.Result = 1;
/*  71 */           ((IDIPPacket_QueryRoleInfoRsp)((IDIPCmd_QueryRoleInfoReq)this.cmd).rsp).head.RetErrMsg = String.format("roleNo length > %d", new Object[] { Integer.valueOf(32) });
/*  72 */           ((IDIPCmd_QueryRoleInfoReq)this.cmd).sendResponse();
/*     */           
/*  74 */           GameServer.logger().error(String.format("[idip]PIDIPCmd_QueryRoleInfoReq.handle@RoleNO length > MAX_ROLENO_LEN|ret=%d|ret_msg=%s|area_id=%d|partition=%d|plat_id=%d|RoleName=%s|RoleNo=%s|role_id=%s", new Object[] { Integer.valueOf(((IDIPPacket_QueryRoleInfoRsp)((IDIPCmd_QueryRoleInfoReq)this.cmd).rsp).head.Result), ((IDIPPacket_QueryRoleInfoRsp)((IDIPCmd_QueryRoleInfoReq)this.cmd).rsp).head.RetErrMsg, Integer.valueOf(((QueryRoleInfoReq)((IDIPPacket_QueryRoleInfoReq)((IDIPCmd_QueryRoleInfoReq)this.cmd).req).body).AreaId), Integer.valueOf(((QueryRoleInfoReq)((IDIPPacket_QueryRoleInfoReq)((IDIPCmd_QueryRoleInfoReq)this.cmd).req).body).Partition), Byte.valueOf(((QueryRoleInfoReq)((IDIPPacket_QueryRoleInfoReq)((IDIPCmd_QueryRoleInfoReq)this.cmd).req).body).PlatId), ((QueryRoleInfoReq)((IDIPPacket_QueryRoleInfoReq)((IDIPCmd_QueryRoleInfoReq)this.cmd).req).body).RoleName, ((QueryRoleInfoReq)((IDIPPacket_QueryRoleInfoReq)((IDIPCmd_QueryRoleInfoReq)this.cmd).req).body).RoleNo, ((QueryRoleInfoReq)((IDIPPacket_QueryRoleInfoReq)((IDIPCmd_QueryRoleInfoReq)this.cmd).req).body).RoleId }));
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  80 */           return false;
/*     */         }
/*  82 */         if (len >= 6)
/*     */         {
/*     */           try
/*     */           {
/*  86 */             roleId = CommonUtils.roleNoToID(((QueryRoleInfoReq)((IDIPPacket_QueryRoleInfoReq)((IDIPCmd_QueryRoleInfoReq)this.cmd).req).body).RoleNo);
/*     */           }
/*     */           catch (NumberFormatException e) {}
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  95 */     if (roleId == -1L)
/*     */     {
/*  97 */       String roleName = Utils.urlDecode1738(((QueryRoleInfoReq)((IDIPPacket_QueryRoleInfoReq)((IDIPCmd_QueryRoleInfoReq)this.cmd).req).body).RoleName);
/*  98 */       if ((roleName != null) && (!roleName.isEmpty()))
/*     */       {
/* 100 */         if (roleName.length() > 64)
/*     */         {
/* 102 */           ((IDIPPacket_QueryRoleInfoRsp)((IDIPCmd_QueryRoleInfoReq)this.cmd).rsp).head.Result = 1;
/* 103 */           ((IDIPPacket_QueryRoleInfoRsp)((IDIPCmd_QueryRoleInfoReq)this.cmd).rsp).head.RetErrMsg = String.format("roleName length > %d", new Object[] { Integer.valueOf(64) });
/* 104 */           ((IDIPCmd_QueryRoleInfoReq)this.cmd).sendResponse();
/*     */           
/* 106 */           GameServer.logger().error(String.format("[idip]PIDIPCmd_QueryRoleInfoReq.handle@roleName length > MAX_ROLENAME_LEN|ret=%d|ret_msg=%s|area_id=%d|partition=%d|plat_id=%d|RoleName=%s|RoleNo=%s|role_id=%s", new Object[] { Integer.valueOf(((IDIPPacket_QueryRoleInfoRsp)((IDIPCmd_QueryRoleInfoReq)this.cmd).rsp).head.Result), ((IDIPPacket_QueryRoleInfoRsp)((IDIPCmd_QueryRoleInfoReq)this.cmd).rsp).head.RetErrMsg, Integer.valueOf(((QueryRoleInfoReq)((IDIPPacket_QueryRoleInfoReq)((IDIPCmd_QueryRoleInfoReq)this.cmd).req).body).AreaId), Integer.valueOf(((QueryRoleInfoReq)((IDIPPacket_QueryRoleInfoReq)((IDIPCmd_QueryRoleInfoReq)this.cmd).req).body).Partition), Byte.valueOf(((QueryRoleInfoReq)((IDIPPacket_QueryRoleInfoReq)((IDIPCmd_QueryRoleInfoReq)this.cmd).req).body).PlatId), ((QueryRoleInfoReq)((IDIPPacket_QueryRoleInfoReq)((IDIPCmd_QueryRoleInfoReq)this.cmd).req).body).RoleName, ((QueryRoleInfoReq)((IDIPPacket_QueryRoleInfoReq)((IDIPCmd_QueryRoleInfoReq)this.cmd).req).body).RoleNo, ((QueryRoleInfoReq)((IDIPPacket_QueryRoleInfoReq)((IDIPCmd_QueryRoleInfoReq)this.cmd).req).body).RoleId }));
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 112 */           return false;
/*     */         }
/*     */         
/* 115 */         roleId = RoleInterface.getRoleIdByName(roleName);
/*     */       }
/*     */     }
/*     */     
/* 119 */     if ((roleId == -1L) || (!RoleInterface.isRoleExist(roleId, false)))
/*     */     {
/* 121 */       ((IDIPPacket_QueryRoleInfoRsp)((IDIPCmd_QueryRoleInfoReq)this.cmd).rsp).head.Result = 1;
/* 122 */       ((IDIPPacket_QueryRoleInfoRsp)((IDIPCmd_QueryRoleInfoReq)this.cmd).rsp).head.RetErrMsg = "query roleid empty";
/* 123 */       ((IDIPCmd_QueryRoleInfoReq)this.cmd).sendResponse();
/*     */       
/* 125 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_QueryRoleInfoReq.handle@role not found|ret=%d|ret_msg=%s|area_id=%d|partition=%d|plat_id=%d|RoleName=%s|RoleNo=%s|role_id=%s", new Object[] { Integer.valueOf(((IDIPPacket_QueryRoleInfoRsp)((IDIPCmd_QueryRoleInfoReq)this.cmd).rsp).head.Result), ((IDIPPacket_QueryRoleInfoRsp)((IDIPCmd_QueryRoleInfoReq)this.cmd).rsp).head.RetErrMsg, Integer.valueOf(((QueryRoleInfoReq)((IDIPPacket_QueryRoleInfoReq)((IDIPCmd_QueryRoleInfoReq)this.cmd).req).body).AreaId), Integer.valueOf(((QueryRoleInfoReq)((IDIPPacket_QueryRoleInfoReq)((IDIPCmd_QueryRoleInfoReq)this.cmd).req).body).Partition), Byte.valueOf(((QueryRoleInfoReq)((IDIPPacket_QueryRoleInfoReq)((IDIPCmd_QueryRoleInfoReq)this.cmd).req).body).PlatId), ((QueryRoleInfoReq)((IDIPPacket_QueryRoleInfoReq)((IDIPCmd_QueryRoleInfoReq)this.cmd).req).body).RoleName, ((QueryRoleInfoReq)((IDIPPacket_QueryRoleInfoReq)((IDIPCmd_QueryRoleInfoReq)this.cmd).req).body).RoleNo, ((QueryRoleInfoReq)((IDIPPacket_QueryRoleInfoReq)((IDIPCmd_QueryRoleInfoReq)this.cmd).req).body).RoleId }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 131 */       return false;
/*     */     }
/*     */     
/* 134 */     Role role = RoleInterface.getRole(roleId, false);
/* 135 */     String userId = role.getUserId();
/* 136 */     ((QueryRoleInfoRsp)((IDIPPacket_QueryRoleInfoRsp)((IDIPCmd_QueryRoleInfoReq)this.cmd).rsp).body).UserID = userId;
/* 137 */     ((QueryRoleInfoRsp)((IDIPPacket_QueryRoleInfoRsp)((IDIPCmd_QueryRoleInfoReq)this.cmd).rsp).body).RoleName = Utils.urlEncode1738(role.getName());
/* 138 */     ((QueryRoleInfoRsp)((IDIPPacket_QueryRoleInfoRsp)((IDIPCmd_QueryRoleInfoReq)this.cmd).rsp).body).CashNum = ((int)QingfuInterface.getBalance(userId, false));
/* 139 */     ((QueryRoleInfoRsp)((IDIPPacket_QueryRoleInfoRsp)((IDIPCmd_QueryRoleInfoReq)this.cmd).rsp).body).MoneyNum = ((int)role.getGold());
/* 140 */     ((QueryRoleInfoRsp)((IDIPPacket_QueryRoleInfoRsp)((IDIPCmd_QueryRoleInfoReq)this.cmd).rsp).body).SilverNum = ((int)role.getSilver());
/* 141 */     ((QueryRoleInfoRsp)((IDIPPacket_QueryRoleInfoRsp)((IDIPCmd_QueryRoleInfoReq)this.cmd).rsp).body).Exp = role.getExp();
/* 142 */     ((QueryRoleInfoRsp)((IDIPPacket_QueryRoleInfoRsp)((IDIPCmd_QueryRoleInfoReq)this.cmd).rsp).body).Level = role.getLevel();
/* 143 */     ((QueryRoleInfoRsp)((IDIPPacket_QueryRoleInfoRsp)((IDIPCmd_QueryRoleInfoReq)this.cmd).rsp).body).SchoolName = Utils.urlEncode1738(RoleInterface.getOccupationName(role.getOccupationId()));
/* 144 */     Gang gang = GangInterface.getGangByRoleId(roleId, false);
/* 145 */     ((QueryRoleInfoRsp)((IDIPPacket_QueryRoleInfoRsp)((IDIPCmd_QueryRoleInfoReq)this.cmd).rsp).body).GangName = (gang == null ? "" : Utils.urlEncode1738(gang.getName()));
/* 146 */     ((QueryRoleInfoRsp)((IDIPPacket_QueryRoleInfoRsp)((IDIPCmd_QueryRoleInfoReq)this.cmd).rsp).body).HisContribution = ((int)MallInterface.getJifen(roleId, 3));
/* 147 */     ((QueryRoleInfoRsp)((IDIPPacket_QueryRoleInfoRsp)((IDIPCmd_QueryRoleInfoReq)this.cmd).rsp).body).Chivalrous = ((int)MallInterface.getJifen(roleId, 1));
/* 148 */     ((QueryRoleInfoRsp)((IDIPPacket_QueryRoleInfoRsp)((IDIPCmd_QueryRoleInfoReq)this.cmd).rsp).body).Reputation = ((int)MallInterface.getJifen(roleId, 4));
/* 149 */     ((QueryRoleInfoRsp)((IDIPPacket_QueryRoleInfoRsp)((IDIPCmd_QueryRoleInfoReq)this.cmd).rsp).body).CompetitivePoint = ((int)MallInterface.getJifen(roleId, 2));
/* 150 */     ((QueryRoleInfoRsp)((IDIPPacket_QueryRoleInfoRsp)((IDIPCmd_QueryRoleInfoReq)this.cmd).rsp).body).GangContribution = ((int)GangInterface.getBangGong(roleId));
/* 151 */     ((QueryRoleInfoRsp)((IDIPPacket_QueryRoleInfoRsp)((IDIPCmd_QueryRoleInfoReq)this.cmd).rsp).body).Fight = role.getFightValue();
/* 152 */     ((QueryRoleInfoRsp)((IDIPPacket_QueryRoleInfoRsp)((IDIPCmd_QueryRoleInfoReq)this.cmd).rsp).body).RegisterTime = Utils.formatTimestamp(role.getCreateTime());
/* 153 */     ((QueryRoleInfoRsp)((IDIPPacket_QueryRoleInfoRsp)((IDIPCmd_QueryRoleInfoReq)this.cmd).rsp).body).TotalLoginTime = 0;
/* 154 */     ((QueryRoleInfoRsp)((IDIPPacket_QueryRoleInfoRsp)((IDIPCmd_QueryRoleInfoReq)this.cmd).rsp).body).LastLogoutTime = Utils.formatTimestamp(role.getLastLogoffTime());
/* 155 */     ((QueryRoleInfoRsp)((IDIPPacket_QueryRoleInfoRsp)((IDIPCmd_QueryRoleInfoReq)this.cmd).rsp).body).IsOnline = (OnlineManager.getInstance().isOnline(roleId) ? 1 : 0);
/* 156 */     ((QueryRoleInfoRsp)((IDIPPacket_QueryRoleInfoRsp)((IDIPCmd_QueryRoleInfoReq)this.cmd).rsp).body).RechargeCashNum = ((int)QingfuInterface.getYuanbao(userId, false));
/* 157 */     ((QueryRoleInfoRsp)((IDIPPacket_QueryRoleInfoRsp)((IDIPCmd_QueryRoleInfoReq)this.cmd).rsp).body).BoundCashNum = ((int)QingfuInterface.getBindYuanbao(userId, false));
/*     */     
/* 159 */     ((IDIPPacket_QueryRoleInfoRsp)((IDIPCmd_QueryRoleInfoReq)this.cmd).rsp).head.Result = 0;
/* 160 */     ((IDIPPacket_QueryRoleInfoRsp)((IDIPCmd_QueryRoleInfoReq)this.cmd).rsp).head.RetErrMsg = "ok";
/* 161 */     ((IDIPCmd_QueryRoleInfoReq)this.cmd).sendResponse();
/*     */     
/* 163 */     GameServer.logger().info(String.format("[idip]PIDIPCmd_QueryRoleInfoReq.handle@query role info success|ret=%d|ret_msg=%s|area_id=%d|partition=%d|plat_id=%d|RoleName=%s|RoleNo=%s|role_id=%s", new Object[] { Integer.valueOf(((IDIPPacket_QueryRoleInfoRsp)((IDIPCmd_QueryRoleInfoReq)this.cmd).rsp).head.Result), ((IDIPPacket_QueryRoleInfoRsp)((IDIPCmd_QueryRoleInfoReq)this.cmd).rsp).head.RetErrMsg, Integer.valueOf(((QueryRoleInfoReq)((IDIPPacket_QueryRoleInfoReq)((IDIPCmd_QueryRoleInfoReq)this.cmd).req).body).AreaId), Integer.valueOf(((QueryRoleInfoReq)((IDIPPacket_QueryRoleInfoReq)((IDIPCmd_QueryRoleInfoReq)this.cmd).req).body).Partition), Byte.valueOf(((QueryRoleInfoReq)((IDIPPacket_QueryRoleInfoReq)((IDIPCmd_QueryRoleInfoReq)this.cmd).req).body).PlatId), ((QueryRoleInfoReq)((IDIPPacket_QueryRoleInfoReq)((IDIPCmd_QueryRoleInfoReq)this.cmd).req).body).RoleName, ((QueryRoleInfoReq)((IDIPPacket_QueryRoleInfoReq)((IDIPCmd_QueryRoleInfoReq)this.cmd).req).body).RoleNo, ((QueryRoleInfoReq)((IDIPPacket_QueryRoleInfoReq)((IDIPCmd_QueryRoleInfoReq)this.cmd).req).body).RoleId }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 170 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PIDIPCmd_QueryRoleInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
/*     */ package mzm.gsp.idip.main;
/*     */ 
/*     */ import idip.IDIPCmd_QueryUsrInfoReq;
/*     */ import idip.IDIPPacket_QueryUsrInfoReq;
/*     */ import idip.IDIPPacket_QueryUsrInfoRsp;
/*     */ import idip.QueryUsrInfoReq;
/*     */ import idip.QueryUsrInfoRsp;
/*     */ import idip.SUsrInfo;
/*     */ import idip.core.IdipHeader;
/*     */ import idip.core.Utils;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.gang.main.Gang;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.mall.main.MallInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.Role;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class PIDIPCmd_QueryUsrInfoReq extends PIDIPCmd<IDIPCmd_QueryUsrInfoReq>
/*     */ {
/*     */   public PIDIPCmd_QueryUsrInfoReq(IDIPCmd_QueryUsrInfoReq cmd)
/*     */   {
/*  28 */     super(cmd);
/*     */   }
/*     */   
/*     */   protected boolean handle()
/*     */     throws Exception
/*     */   {
/*  34 */     String openId = ((QueryUsrInfoReq)((IDIPPacket_QueryUsrInfoReq)((IDIPCmd_QueryUsrInfoReq)this.cmd).req).body).OpenId;
/*  35 */     int areaId = ((QueryUsrInfoReq)((IDIPPacket_QueryUsrInfoReq)((IDIPCmd_QueryUsrInfoReq)this.cmd).req).body).AreaId;
/*  36 */     int partition = ((QueryUsrInfoReq)((IDIPPacket_QueryUsrInfoReq)((IDIPCmd_QueryUsrInfoReq)this.cmd).req).body).Partition;
/*     */     
/*  38 */     String userId = Utils.getUserId(openId, areaId, partition);
/*  39 */     xbean.User xUser = xtable.User.select(userId);
/*  40 */     if (null == xUser)
/*     */     {
/*  42 */       ((IDIPPacket_QueryUsrInfoRsp)((IDIPCmd_QueryUsrInfoReq)this.cmd).rsp).head.Result = 1;
/*  43 */       ((IDIPPacket_QueryUsrInfoRsp)((IDIPCmd_QueryUsrInfoReq)this.cmd).rsp).head.RetErrMsg = "query userid empty";
/*  44 */       ((IDIPCmd_QueryUsrInfoReq)this.cmd).sendResponse();
/*     */       
/*  46 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_QueryUsrInfoReq.handle@user not found|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|role_id=%s", new Object[] { Integer.valueOf(((IDIPPacket_QueryUsrInfoRsp)((IDIPCmd_QueryUsrInfoReq)this.cmd).rsp).head.Result), ((IDIPPacket_QueryUsrInfoRsp)((IDIPCmd_QueryUsrInfoReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((QueryUsrInfoReq)((IDIPPacket_QueryUsrInfoReq)((IDIPCmd_QueryUsrInfoReq)this.cmd).req).body).PlatId), ((QueryUsrInfoReq)((IDIPPacket_QueryUsrInfoReq)((IDIPCmd_QueryUsrInfoReq)this.cmd).req).body).RoleId }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  51 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  55 */     long targetRoleId = -1L;
/*  56 */     if (!((QueryUsrInfoReq)((IDIPPacket_QueryUsrInfoReq)((IDIPCmd_QueryUsrInfoReq)this.cmd).req).body).RoleId.isEmpty())
/*     */     {
/*     */ 
/*  59 */       if (((QueryUsrInfoReq)((IDIPPacket_QueryUsrInfoReq)((IDIPCmd_QueryUsrInfoReq)this.cmd).req).body).RoleId.length() > 32)
/*     */       {
/*  61 */         ((IDIPPacket_QueryUsrInfoRsp)((IDIPCmd_QueryUsrInfoReq)this.cmd).rsp).head.Result = 1;
/*  62 */         ((IDIPPacket_QueryUsrInfoRsp)((IDIPCmd_QueryUsrInfoReq)this.cmd).rsp).head.RetErrMsg = String.format("roleid length > %d", new Object[] { Integer.valueOf(32) });
/*  63 */         ((IDIPCmd_QueryUsrInfoReq)this.cmd).sendResponse();
/*     */         
/*  65 */         GameServer.logger().error(String.format("[idip]PIDIPCmd_QueryUsrInfoReq.handle@roleId length < MAX_ROLEID_LEN|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|role_id=%s", new Object[] { Integer.valueOf(((IDIPPacket_QueryUsrInfoRsp)((IDIPCmd_QueryUsrInfoReq)this.cmd).rsp).head.Result), ((IDIPPacket_QueryUsrInfoRsp)((IDIPCmd_QueryUsrInfoReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((QueryUsrInfoReq)((IDIPPacket_QueryUsrInfoReq)((IDIPCmd_QueryUsrInfoReq)this.cmd).req).body).PlatId), ((QueryUsrInfoReq)((IDIPPacket_QueryUsrInfoReq)((IDIPCmd_QueryUsrInfoReq)this.cmd).req).body).RoleId }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*  70 */         return false;
/*     */       }
/*     */       
/*     */       try
/*     */       {
/*  75 */         targetRoleId = Long.parseLong(((QueryUsrInfoReq)((IDIPPacket_QueryUsrInfoReq)((IDIPCmd_QueryUsrInfoReq)this.cmd).req).body).RoleId);
/*     */       }
/*     */       catch (NumberFormatException e)
/*     */       {
/*  79 */         ((IDIPPacket_QueryUsrInfoRsp)((IDIPCmd_QueryUsrInfoReq)this.cmd).rsp).head.Result = 1;
/*  80 */         ((IDIPPacket_QueryUsrInfoRsp)((IDIPCmd_QueryUsrInfoReq)this.cmd).rsp).head.RetErrMsg = "roleid format error";
/*  81 */         ((IDIPCmd_QueryUsrInfoReq)this.cmd).sendResponse();
/*     */         
/*  83 */         GameServer.logger().error(String.format("[idip]PIDIPCmd_QueryUsrInfoReq.handle@role id not found or not match|ret=%d|ret_msg=%s|user_id=%s|user_role_list=%s|area_id=%d|plat_id=%d|role_id=%s", new Object[] { Integer.valueOf(((IDIPPacket_QueryUsrInfoRsp)((IDIPCmd_QueryUsrInfoReq)this.cmd).rsp).head.Result), ((IDIPPacket_QueryUsrInfoRsp)((IDIPCmd_QueryUsrInfoReq)this.cmd).rsp).head.RetErrMsg, userId, xUser.getRoleids().toString(), Integer.valueOf(areaId), Byte.valueOf(((QueryUsrInfoReq)((IDIPPacket_QueryUsrInfoReq)((IDIPCmd_QueryUsrInfoReq)this.cmd).req).body).PlatId), ((QueryUsrInfoReq)((IDIPPacket_QueryUsrInfoReq)((IDIPCmd_QueryUsrInfoReq)this.cmd).req).body).RoleId }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  89 */         return false;
/*     */       }
/*     */     }
/*     */     
/*  93 */     List<Long> xRoleIdsList = xUser.getRoleids();
/*  94 */     if ((targetRoleId != -1L) && ((!xRoleIdsList.contains(Long.valueOf(targetRoleId))) || (!RoleInterface.isRoleExist(targetRoleId, false))))
/*     */     {
/*  96 */       ((IDIPPacket_QueryUsrInfoRsp)((IDIPCmd_QueryUsrInfoReq)this.cmd).rsp).head.Result = 1;
/*  97 */       ((IDIPPacket_QueryUsrInfoRsp)((IDIPCmd_QueryUsrInfoReq)this.cmd).rsp).head.RetErrMsg = "query roleid empty";
/*  98 */       ((IDIPCmd_QueryUsrInfoReq)this.cmd).sendResponse();
/*     */       
/* 100 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_QueryUsrInfoReq.handle@role id not found or not match|ret=%d|ret_msg=%s|user_id=%s|user_role_list=%s|area_id=%d|plat_id=%d|role_id=%s", new Object[] { Integer.valueOf(((IDIPPacket_QueryUsrInfoRsp)((IDIPCmd_QueryUsrInfoReq)this.cmd).rsp).head.Result), ((IDIPPacket_QueryUsrInfoRsp)((IDIPCmd_QueryUsrInfoReq)this.cmd).rsp).head.RetErrMsg, userId, xRoleIdsList.toString(), Integer.valueOf(areaId), Byte.valueOf(((QueryUsrInfoReq)((IDIPPacket_QueryUsrInfoReq)((IDIPCmd_QueryUsrInfoReq)this.cmd).req).body).PlatId), ((QueryUsrInfoReq)((IDIPPacket_QueryUsrInfoReq)((IDIPCmd_QueryUsrInfoReq)this.cmd).req).body).RoleId }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 106 */       return false;
/*     */     }
/*     */     
/* 109 */     if (targetRoleId == -1L)
/*     */     {
/* 111 */       for (Iterator i$ = xRoleIdsList.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */         
/* 113 */         if (RoleInterface.isRoleExist(roleId, false))
/*     */         {
/*     */ 
/*     */ 
/* 117 */           Role role = RoleInterface.getRole(roleId, false);
/* 118 */           SUsrInfo roleInfo = new SUsrInfo();
/* 119 */           fillRoleInfo(roleId, role, roleInfo);
/*     */           
/* 121 */           ((QueryUsrInfoRsp)((IDIPPacket_QueryUsrInfoRsp)((IDIPCmd_QueryUsrInfoReq)this.cmd).rsp).body).UsrInfoList.add(roleInfo);
/*     */         } }
/* 123 */       ((QueryUsrInfoRsp)((IDIPPacket_QueryUsrInfoRsp)((IDIPCmd_QueryUsrInfoReq)this.cmd).rsp).body).UsrInfoList_count = ((QueryUsrInfoRsp)((IDIPPacket_QueryUsrInfoRsp)((IDIPCmd_QueryUsrInfoReq)this.cmd).rsp).body).UsrInfoList.size();
/*     */     }
/*     */     else
/*     */     {
/* 127 */       Role role = RoleInterface.getRole(targetRoleId, false);
/* 128 */       SUsrInfo roleInfo = new SUsrInfo();
/* 129 */       fillRoleInfo(targetRoleId, role, roleInfo);
/*     */       
/* 131 */       ((QueryUsrInfoRsp)((IDIPPacket_QueryUsrInfoRsp)((IDIPCmd_QueryUsrInfoReq)this.cmd).rsp).body).UsrInfoList.add(roleInfo);
/* 132 */       ((QueryUsrInfoRsp)((IDIPPacket_QueryUsrInfoRsp)((IDIPCmd_QueryUsrInfoReq)this.cmd).rsp).body).UsrInfoList_count = 1;
/*     */     }
/*     */     
/* 135 */     ((IDIPPacket_QueryUsrInfoRsp)((IDIPCmd_QueryUsrInfoReq)this.cmd).rsp).head.Result = 0;
/* 136 */     ((IDIPPacket_QueryUsrInfoRsp)((IDIPCmd_QueryUsrInfoReq)this.cmd).rsp).head.RetErrMsg = "ok";
/* 137 */     ((IDIPCmd_QueryUsrInfoReq)this.cmd).sendResponse();
/*     */     
/* 139 */     GameServer.logger().info(String.format("[idip]PIDIPCmd_QueryUsrInfoReq.handle@query role info success|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|role_id=%s", new Object[] { Integer.valueOf(((IDIPPacket_QueryUsrInfoRsp)((IDIPCmd_QueryUsrInfoReq)this.cmd).rsp).head.Result), ((IDIPPacket_QueryUsrInfoRsp)((IDIPCmd_QueryUsrInfoReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((QueryUsrInfoReq)((IDIPPacket_QueryUsrInfoReq)((IDIPCmd_QueryUsrInfoReq)this.cmd).req).body).PlatId), ((QueryUsrInfoReq)((IDIPPacket_QueryUsrInfoReq)((IDIPCmd_QueryUsrInfoReq)this.cmd).req).body).RoleId }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 144 */     return true;
/*     */   }
/*     */   
/*     */   private void fillRoleInfo(long roleId, Role role, SUsrInfo roleInfo) throws Exception
/*     */   {
/* 149 */     String userId = role.getUserId();
/* 150 */     roleInfo.RoleId = String.valueOf(roleId);
/* 151 */     roleInfo.RoleName = Utils.urlEncode1738(role.getName());
/* 152 */     roleInfo.CashNum = ((int)QingfuInterface.getBalance(userId, false));
/* 153 */     roleInfo.MoneyNum = ((int)role.getGold());
/* 154 */     roleInfo.SilverNum = ((int)role.getSilver());
/* 155 */     roleInfo.Exp = role.getExp();
/* 156 */     roleInfo.Level = role.getLevel();
/* 157 */     roleInfo.SchoolName = Utils.urlEncode1738(RoleInterface.getOccupationName(role.getOccupationId()));
/* 158 */     Gang gang = GangInterface.getGangByRoleId(roleId, false);
/* 159 */     roleInfo.GangName = (gang == null ? "" : Utils.urlEncode1738(gang.getName()));
/* 160 */     roleInfo.HisContribution = ((int)MallInterface.getJifen(roleId, 3));
/* 161 */     roleInfo.Chivalrous = ((int)MallInterface.getJifen(roleId, 1));
/* 162 */     roleInfo.Reputation = ((int)MallInterface.getJifen(roleId, 4));
/* 163 */     roleInfo.CompetitivePoint = ((int)MallInterface.getJifen(roleId, 2));
/* 164 */     roleInfo.GangContribution = ((int)GangInterface.getBangGong(roleId));
/* 165 */     roleInfo.Fight = role.getFightValue();
/* 166 */     roleInfo.RegisterTime = Utils.formatTimestamp(role.getCreateTime());
/* 167 */     roleInfo.TotalLoginTime = 0;
/* 168 */     roleInfo.LastLogoutTime = Utils.formatTimestamp(role.getLastLogoffTime());
/* 169 */     roleInfo.IsOnline = (OnlineManager.getInstance().isOnline(roleId) ? 1 : 0);
/* 170 */     roleInfo.RechargeCashNum = ((int)QingfuInterface.getYuanbao(userId, false));
/* 171 */     roleInfo.BoundCashNum = ((int)QingfuInterface.getBindYuanbao(userId, false));
/* 172 */     roleInfo.UserID = userId;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PIDIPCmd_QueryUsrInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
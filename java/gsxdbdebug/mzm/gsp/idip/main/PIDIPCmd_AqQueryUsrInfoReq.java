/*     */ package mzm.gsp.idip.main;
/*     */ 
/*     */ import idip.AqQueryUsrInfoReq;
/*     */ import idip.AqQueryUsrInfoRsp;
/*     */ import idip.IDIPCmd_AqQueryUsrInfoReq;
/*     */ import idip.IDIPPacket_AqQueryUsrInfoReq;
/*     */ import idip.IDIPPacket_AqQueryUsrInfoRsp;
/*     */ import idip.QUERY_USR_INFO_LIST;
/*     */ import idip.core.IdipHeader;
/*     */ import idip.core.Utils;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.mall.main.MallInterface;
/*     */ import mzm.gsp.role.main.Role;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class PIDIPCmd_AqQueryUsrInfoReq extends PIDIPCmd<IDIPCmd_AqQueryUsrInfoReq>
/*     */ {
/*     */   public PIDIPCmd_AqQueryUsrInfoReq(IDIPCmd_AqQueryUsrInfoReq cmd)
/*     */   {
/*  25 */     super(cmd);
/*     */   }
/*     */   
/*     */   protected boolean handle()
/*     */     throws Exception
/*     */   {
/*  31 */     String openId = ((AqQueryUsrInfoReq)((IDIPPacket_AqQueryUsrInfoReq)((IDIPCmd_AqQueryUsrInfoReq)this.cmd).req).body).OpenId;
/*  32 */     int areaId = ((AqQueryUsrInfoReq)((IDIPPacket_AqQueryUsrInfoReq)((IDIPCmd_AqQueryUsrInfoReq)this.cmd).req).body).AreaId;
/*  33 */     int partition = ((AqQueryUsrInfoReq)((IDIPPacket_AqQueryUsrInfoReq)((IDIPCmd_AqQueryUsrInfoReq)this.cmd).req).body).Partition;
/*     */     
/*  35 */     String userId = Utils.getUserId(openId, areaId, partition);
/*  36 */     xbean.User xUser = xtable.User.get(userId);
/*  37 */     if (null == xUser)
/*     */     {
/*  39 */       ((IDIPPacket_AqQueryUsrInfoRsp)((IDIPCmd_AqQueryUsrInfoReq)this.cmd).rsp).head.Result = 1;
/*  40 */       ((IDIPPacket_AqQueryUsrInfoRsp)((IDIPCmd_AqQueryUsrInfoReq)this.cmd).rsp).head.RetErrMsg = "query userid empty";
/*  41 */       ((IDIPCmd_AqQueryUsrInfoReq)this.cmd).sendResponse();
/*     */       
/*  43 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqQueryUsrInfoReq.handle@user not found|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqQueryUsrInfoRsp)((IDIPCmd_AqQueryUsrInfoReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqQueryUsrInfoRsp)((IDIPCmd_AqQueryUsrInfoReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((AqQueryUsrInfoReq)((IDIPPacket_AqQueryUsrInfoReq)((IDIPCmd_AqQueryUsrInfoReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqQueryUsrInfoReq)((IDIPPacket_AqQueryUsrInfoReq)((IDIPCmd_AqQueryUsrInfoReq)this.cmd).req).body).RoleId }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  48 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  52 */     if (((AqQueryUsrInfoReq)((IDIPPacket_AqQueryUsrInfoReq)((IDIPCmd_AqQueryUsrInfoReq)this.cmd).req).body).RoleId.length() > 32)
/*     */     {
/*  54 */       ((IDIPPacket_AqQueryUsrInfoRsp)((IDIPCmd_AqQueryUsrInfoReq)this.cmd).rsp).head.Result = 1;
/*  55 */       ((IDIPPacket_AqQueryUsrInfoRsp)((IDIPCmd_AqQueryUsrInfoReq)this.cmd).rsp).head.RetErrMsg = String.format("roleid length > %d", new Object[] { Integer.valueOf(32) });
/*  56 */       ((IDIPCmd_AqQueryUsrInfoReq)this.cmd).sendResponse();
/*     */       
/*  58 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqQueryUsrInfoReq.handle@roleId length > MAX_ROLEID_LEN|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqQueryUsrInfoRsp)((IDIPCmd_AqQueryUsrInfoReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqQueryUsrInfoRsp)((IDIPCmd_AqQueryUsrInfoReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((AqQueryUsrInfoReq)((IDIPPacket_AqQueryUsrInfoReq)((IDIPCmd_AqQueryUsrInfoReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqQueryUsrInfoReq)((IDIPPacket_AqQueryUsrInfoReq)((IDIPCmd_AqQueryUsrInfoReq)this.cmd).req).body).RoleId }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  63 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  67 */     long targetRoleId = -1L;
/*  68 */     if (!((AqQueryUsrInfoReq)((IDIPPacket_AqQueryUsrInfoReq)((IDIPCmd_AqQueryUsrInfoReq)this.cmd).req).body).RoleId.isEmpty())
/*     */     {
/*     */       try
/*     */       {
/*  72 */         targetRoleId = Long.parseLong(((AqQueryUsrInfoReq)((IDIPPacket_AqQueryUsrInfoReq)((IDIPCmd_AqQueryUsrInfoReq)this.cmd).req).body).RoleId);
/*     */       }
/*     */       catch (NumberFormatException e)
/*     */       {
/*  76 */         ((IDIPPacket_AqQueryUsrInfoRsp)((IDIPCmd_AqQueryUsrInfoReq)this.cmd).rsp).head.Result = 1;
/*  77 */         ((IDIPPacket_AqQueryUsrInfoRsp)((IDIPCmd_AqQueryUsrInfoReq)this.cmd).rsp).head.RetErrMsg = "roleid format error";
/*  78 */         ((IDIPCmd_AqQueryUsrInfoReq)this.cmd).sendResponse();
/*     */         
/*  80 */         GameServer.logger().error(String.format("[idip]PIDIPCmd_AqQueryUsrInfoReq.handle@role not found|ret=%d|ret_msg=%s|user_id=%s|user_role_list=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqQueryUsrInfoRsp)((IDIPCmd_AqQueryUsrInfoReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqQueryUsrInfoRsp)((IDIPCmd_AqQueryUsrInfoReq)this.cmd).rsp).head.RetErrMsg, userId, xUser.getRoleids().toString(), Integer.valueOf(areaId), Byte.valueOf(((AqQueryUsrInfoReq)((IDIPPacket_AqQueryUsrInfoReq)((IDIPCmd_AqQueryUsrInfoReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqQueryUsrInfoReq)((IDIPPacket_AqQueryUsrInfoReq)((IDIPCmd_AqQueryUsrInfoReq)this.cmd).req).body).RoleId }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*  85 */         return false;
/*     */       }
/*     */     }
/*     */     
/*  89 */     List<Long> xRoleIdsList = xUser.getRoleids();
/*  90 */     if ((targetRoleId != -1L) && ((!xRoleIdsList.contains(Long.valueOf(targetRoleId))) || (!RoleInterface.isRoleExist(targetRoleId, false))))
/*     */     {
/*  92 */       ((IDIPPacket_AqQueryUsrInfoRsp)((IDIPCmd_AqQueryUsrInfoReq)this.cmd).rsp).head.Result = 1;
/*  93 */       ((IDIPPacket_AqQueryUsrInfoRsp)((IDIPCmd_AqQueryUsrInfoReq)this.cmd).rsp).head.RetErrMsg = "query roleid empty";
/*  94 */       ((IDIPCmd_AqQueryUsrInfoReq)this.cmd).sendResponse();
/*     */       
/*  96 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqQueryUsrInfoReq.handle@role not found|ret=%d|ret_msg=%s|user_id=%s|user_role_list=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqQueryUsrInfoRsp)((IDIPCmd_AqQueryUsrInfoReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqQueryUsrInfoRsp)((IDIPCmd_AqQueryUsrInfoReq)this.cmd).rsp).head.RetErrMsg, userId, xUser.getRoleids().toString(), Integer.valueOf(areaId), Byte.valueOf(((AqQueryUsrInfoReq)((IDIPPacket_AqQueryUsrInfoReq)((IDIPCmd_AqQueryUsrInfoReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqQueryUsrInfoReq)((IDIPPacket_AqQueryUsrInfoReq)((IDIPCmd_AqQueryUsrInfoReq)this.cmd).req).body).RoleId }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 101 */       return false;
/*     */     }
/*     */     
/* 104 */     if (targetRoleId == -1L)
/*     */     {
/* 106 */       for (Iterator i$ = xRoleIdsList.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */         
/* 108 */         if (RoleInterface.isRoleExist(roleId, false))
/*     */         {
/*     */ 
/*     */ 
/* 112 */           Role role = RoleInterface.getRole(roleId, false);
/* 113 */           QUERY_USR_INFO_LIST roleInfo = new QUERY_USR_INFO_LIST();
/* 114 */           fillRoleInfo(roleId, role, roleInfo);
/*     */           
/* 116 */           ((AqQueryUsrInfoRsp)((IDIPPacket_AqQueryUsrInfoRsp)((IDIPCmd_AqQueryUsrInfoReq)this.cmd).rsp).body).OpenidList.add(roleInfo);
/*     */         } }
/* 118 */       ((AqQueryUsrInfoRsp)((IDIPPacket_AqQueryUsrInfoRsp)((IDIPCmd_AqQueryUsrInfoReq)this.cmd).rsp).body).OpenidList_count = ((AqQueryUsrInfoRsp)((IDIPPacket_AqQueryUsrInfoRsp)((IDIPCmd_AqQueryUsrInfoReq)this.cmd).rsp).body).OpenidList.size();
/*     */     }
/*     */     else
/*     */     {
/* 122 */       Role role = RoleInterface.getRole(targetRoleId, false);
/* 123 */       QUERY_USR_INFO_LIST roleInfo = new QUERY_USR_INFO_LIST();
/* 124 */       fillRoleInfo(targetRoleId, role, roleInfo);
/*     */       
/* 126 */       ((AqQueryUsrInfoRsp)((IDIPPacket_AqQueryUsrInfoRsp)((IDIPCmd_AqQueryUsrInfoReq)this.cmd).rsp).body).OpenidList.add(roleInfo);
/* 127 */       ((AqQueryUsrInfoRsp)((IDIPPacket_AqQueryUsrInfoRsp)((IDIPCmd_AqQueryUsrInfoReq)this.cmd).rsp).body).OpenidList_count = 1;
/*     */     }
/*     */     
/* 130 */     ((IDIPPacket_AqQueryUsrInfoRsp)((IDIPCmd_AqQueryUsrInfoReq)this.cmd).rsp).head.Result = 0;
/* 131 */     ((IDIPPacket_AqQueryUsrInfoRsp)((IDIPCmd_AqQueryUsrInfoReq)this.cmd).rsp).head.RetErrMsg = "ok";
/* 132 */     ((IDIPCmd_AqQueryUsrInfoReq)this.cmd).sendResponse();
/*     */     
/* 134 */     GameServer.logger().info(String.format("[idip]PIDIPCmd_AqQueryUsrInfoReq.handle@query usr info success|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqQueryUsrInfoRsp)((IDIPCmd_AqQueryUsrInfoReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqQueryUsrInfoRsp)((IDIPCmd_AqQueryUsrInfoReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((AqQueryUsrInfoReq)((IDIPPacket_AqQueryUsrInfoReq)((IDIPCmd_AqQueryUsrInfoReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqQueryUsrInfoReq)((IDIPPacket_AqQueryUsrInfoReq)((IDIPCmd_AqQueryUsrInfoReq)this.cmd).req).body).RoleId }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 140 */     return true;
/*     */   }
/*     */   
/*     */   private void fillRoleInfo(long roleId, Role role, QUERY_USR_INFO_LIST roleInfo) throws Exception
/*     */   {
/* 145 */     roleInfo.RoleName = Utils.urlEncode1738(role.getName());
/* 146 */     roleInfo.Level = role.getLevel();
/* 147 */     roleInfo.GangId = ((int)GangInterface.getGangId(roleId));
/* 148 */     roleInfo.Exp = role.getExp();
/* 149 */     roleInfo.StoreExp = ((int)mzm.gsp.storageexp.main.StorageExpInterface.getCurCanUseStorageExp(roleId));
/*     */     
/* 151 */     roleInfo.Cash = ((int)mzm.gsp.qingfu.main.QingfuInterface.getBalance(role.getUserId(), false));
/* 152 */     roleInfo.Money = ((int)role.getGold());
/* 153 */     roleInfo.Silver = ((int)role.getSilver());
/*     */     
/* 155 */     roleInfo.Fight = role.getFightValue();
/*     */     
/* 157 */     roleInfo.CompetitivePoint = ((int)MallInterface.getJifen(roleId, 2));
/* 158 */     roleInfo.Chivalrous = ((int)MallInterface.getJifen(roleId, 1));
/* 159 */     roleInfo.Reputation = ((int)MallInterface.getJifen(roleId, 4));
/*     */     
/* 161 */     roleInfo.Vitality = RoleInterface.getVigor(roleId);
/*     */     
/* 163 */     roleInfo.GangContribute = ((int)GangInterface.getBangGong(roleId));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PIDIPCmd_AqQueryUsrInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
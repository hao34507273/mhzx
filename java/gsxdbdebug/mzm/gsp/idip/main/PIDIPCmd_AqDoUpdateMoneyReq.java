/*     */ package mzm.gsp.idip.main;
/*     */ 
/*     */ import idip.AqDoUpdateMoneyReq;
/*     */ import idip.AqDoUpdateMoneyRsp;
/*     */ import idip.IDIPCmd_AqDoUpdateMoneyReq;
/*     */ import idip.IDIPPacket_AqDoUpdateMoneyReq;
/*     */ import idip.IDIPPacket_AqDoUpdateMoneyRsp;
/*     */ import idip.core.IdipHeader;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.role.main.MoneyOperResult;
/*     */ import mzm.gsp.role.main.Role;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class PIDIPCmd_AqDoUpdateMoneyReq extends PIDIPCmd<IDIPCmd_AqDoUpdateMoneyReq>
/*     */ {
/*     */   private static final int GOLD = 0;
/*     */   private static final int SILVER = 1;
/*     */   private static final int GOLDINGOT = 2;
/*     */   
/*     */   public PIDIPCmd_AqDoUpdateMoneyReq(IDIPCmd_AqDoUpdateMoneyReq cmd)
/*     */   {
/*  23 */     super(cmd);
/*     */   }
/*     */   
/*     */   protected boolean handle()
/*     */     throws Exception
/*     */   {
/*  29 */     String openId = ((AqDoUpdateMoneyReq)((IDIPPacket_AqDoUpdateMoneyReq)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).req).body).OpenId;
/*  30 */     int areaId = ((AqDoUpdateMoneyReq)((IDIPPacket_AqDoUpdateMoneyReq)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).req).body).AreaId;
/*  31 */     int partition = ((AqDoUpdateMoneyReq)((IDIPPacket_AqDoUpdateMoneyReq)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).req).body).Partition;
/*     */     
/*  33 */     String userId = idip.core.Utils.getUserId(openId, areaId, partition);
/*  34 */     xbean.User xUser = xtable.User.get(userId);
/*  35 */     if (null == xUser)
/*     */     {
/*  37 */       ((IDIPPacket_AqDoUpdateMoneyRsp)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).rsp).head.Result = (((AqDoUpdateMoneyRsp)((IDIPPacket_AqDoUpdateMoneyRsp)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).rsp).body).Result = 1);
/*  38 */       ((IDIPPacket_AqDoUpdateMoneyRsp)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).rsp).head.RetErrMsg = (((AqDoUpdateMoneyRsp)((IDIPPacket_AqDoUpdateMoneyRsp)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).rsp).body).RetMsg = "query userid empty");
/*  39 */       ((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).sendResponse();
/*     */       
/*  41 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoUpdateMoneyReq.handle@user not found|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|type=%d|value=%d|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoUpdateMoneyRsp)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoUpdateMoneyRsp)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((AqDoUpdateMoneyReq)((IDIPPacket_AqDoUpdateMoneyReq)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoUpdateMoneyReq)((IDIPPacket_AqDoUpdateMoneyReq)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).req).body).RoleId, Byte.valueOf(((AqDoUpdateMoneyReq)((IDIPPacket_AqDoUpdateMoneyReq)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).req).body).Type), Integer.valueOf(((AqDoUpdateMoneyReq)((IDIPPacket_AqDoUpdateMoneyReq)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).req).body).Value), Integer.valueOf(((AqDoUpdateMoneyReq)((IDIPPacket_AqDoUpdateMoneyReq)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).req).body).Source), ((AqDoUpdateMoneyReq)((IDIPPacket_AqDoUpdateMoneyReq)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  47 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  51 */     if (((AqDoUpdateMoneyReq)((IDIPPacket_AqDoUpdateMoneyReq)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).req).body).RoleId.length() > 32)
/*     */     {
/*  53 */       ((IDIPPacket_AqDoUpdateMoneyRsp)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).rsp).head.Result = (((AqDoUpdateMoneyRsp)((IDIPPacket_AqDoUpdateMoneyRsp)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).rsp).body).Result = 1);
/*  54 */       ((IDIPPacket_AqDoUpdateMoneyRsp)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).rsp).head.RetErrMsg = (((AqDoUpdateMoneyRsp)((IDIPPacket_AqDoUpdateMoneyRsp)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).rsp).body).RetMsg = String.format("roleid length > %d", new Object[] { Integer.valueOf(32) }));
/*     */       
/*  56 */       ((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).sendResponse();
/*     */       
/*  58 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoUpdateMoneyReq.handle@roleId length > MAX_ROLEID_LEN|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|type=%d|value=%d|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoUpdateMoneyRsp)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoUpdateMoneyRsp)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((AqDoUpdateMoneyReq)((IDIPPacket_AqDoUpdateMoneyReq)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoUpdateMoneyReq)((IDIPPacket_AqDoUpdateMoneyReq)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).req).body).RoleId, Byte.valueOf(((AqDoUpdateMoneyReq)((IDIPPacket_AqDoUpdateMoneyReq)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).req).body).Type), Integer.valueOf(((AqDoUpdateMoneyReq)((IDIPPacket_AqDoUpdateMoneyReq)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).req).body).Value), Integer.valueOf(((AqDoUpdateMoneyReq)((IDIPPacket_AqDoUpdateMoneyReq)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).req).body).Source), ((AqDoUpdateMoneyReq)((IDIPPacket_AqDoUpdateMoneyReq)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  64 */       return false;
/*     */     }
/*     */     
/*  67 */     long roleId = -1L;
/*     */     try
/*     */     {
/*  70 */       roleId = Long.parseLong(((AqDoUpdateMoneyReq)((IDIPPacket_AqDoUpdateMoneyReq)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).req).body).RoleId);
/*     */     }
/*     */     catch (NumberFormatException e)
/*     */     {
/*  74 */       ((IDIPPacket_AqDoUpdateMoneyRsp)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).rsp).head.Result = (((AqDoUpdateMoneyRsp)((IDIPPacket_AqDoUpdateMoneyRsp)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).rsp).body).Result = 1);
/*  75 */       ((IDIPPacket_AqDoUpdateMoneyRsp)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).rsp).head.RetErrMsg = (((AqDoUpdateMoneyRsp)((IDIPPacket_AqDoUpdateMoneyRsp)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).rsp).body).RetMsg = "roleid format error");
/*  76 */       ((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).sendResponse();
/*     */       
/*  78 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoUpdateMoneyReq.handle@role not found|ret=%d|ret_msg=%s|user_id=%s|user_role_list=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|type=%d|value=%d|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoUpdateMoneyRsp)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoUpdateMoneyRsp)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).rsp).head.RetErrMsg, userId, xUser.getRoleids().toString(), Integer.valueOf(areaId), Byte.valueOf(((AqDoUpdateMoneyReq)((IDIPPacket_AqDoUpdateMoneyReq)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoUpdateMoneyReq)((IDIPPacket_AqDoUpdateMoneyReq)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).req).body).RoleId, Byte.valueOf(((AqDoUpdateMoneyReq)((IDIPPacket_AqDoUpdateMoneyReq)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).req).body).Type), Integer.valueOf(((AqDoUpdateMoneyReq)((IDIPPacket_AqDoUpdateMoneyReq)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).req).body).Value), Integer.valueOf(((AqDoUpdateMoneyReq)((IDIPPacket_AqDoUpdateMoneyReq)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).req).body).Source), ((AqDoUpdateMoneyReq)((IDIPPacket_AqDoUpdateMoneyReq)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  84 */       return false;
/*     */     }
/*     */     
/*  87 */     if ((!RoleInterface.isRoleExist(roleId, true)) || (!xUser.getRoleids().contains(Long.valueOf(roleId))))
/*     */     {
/*  89 */       ((IDIPPacket_AqDoUpdateMoneyRsp)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).rsp).head.Result = (((AqDoUpdateMoneyRsp)((IDIPPacket_AqDoUpdateMoneyRsp)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).rsp).body).Result = 1);
/*  90 */       ((IDIPPacket_AqDoUpdateMoneyRsp)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).rsp).head.RetErrMsg = (((AqDoUpdateMoneyRsp)((IDIPPacket_AqDoUpdateMoneyRsp)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).rsp).body).RetMsg = "query roleid empty");
/*  91 */       ((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).sendResponse();
/*     */       
/*  93 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoUpdateMoneyReq.handle@role not found|ret=%d|ret_msg=%s|user_id=%s|user_role_list=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|type=%d|value=%d|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoUpdateMoneyRsp)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoUpdateMoneyRsp)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).rsp).head.RetErrMsg, userId, xUser.getRoleids().toString(), Integer.valueOf(areaId), Byte.valueOf(((AqDoUpdateMoneyReq)((IDIPPacket_AqDoUpdateMoneyReq)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoUpdateMoneyReq)((IDIPPacket_AqDoUpdateMoneyReq)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).req).body).RoleId, Byte.valueOf(((AqDoUpdateMoneyReq)((IDIPPacket_AqDoUpdateMoneyReq)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).req).body).Type), Integer.valueOf(((AqDoUpdateMoneyReq)((IDIPPacket_AqDoUpdateMoneyReq)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).req).body).Value), Integer.valueOf(((AqDoUpdateMoneyReq)((IDIPPacket_AqDoUpdateMoneyReq)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).req).body).Source), ((AqDoUpdateMoneyReq)((IDIPPacket_AqDoUpdateMoneyReq)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  99 */       return false;
/*     */     }
/*     */     
/* 102 */     int type = ((AqDoUpdateMoneyReq)((IDIPPacket_AqDoUpdateMoneyReq)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).req).body).Type;
/* 103 */     if ((((AqDoUpdateMoneyReq)((IDIPPacket_AqDoUpdateMoneyReq)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).req).body).Type != 0) && (((AqDoUpdateMoneyReq)((IDIPPacket_AqDoUpdateMoneyReq)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).req).body).Type != 1) && (((AqDoUpdateMoneyReq)((IDIPPacket_AqDoUpdateMoneyReq)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).req).body).Type != 2))
/*     */     {
/* 105 */       ((IDIPPacket_AqDoUpdateMoneyRsp)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).rsp).head.Result = (((AqDoUpdateMoneyRsp)((IDIPPacket_AqDoUpdateMoneyRsp)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).rsp).body).Result = 'ﯿ');
/* 106 */       ((IDIPPacket_AqDoUpdateMoneyRsp)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).rsp).head.RetErrMsg = (((AqDoUpdateMoneyRsp)((IDIPPacket_AqDoUpdateMoneyRsp)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).rsp).body).RetMsg = "money type not exist");
/* 107 */       ((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).sendResponse();
/*     */       
/* 109 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoUpdateMoneyReq.handle@money type not exist|ret=%d|ret_msg=%s|user_id=%s|user_role_list=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|type=%d|value=%d|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoUpdateMoneyRsp)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoUpdateMoneyRsp)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).rsp).head.RetErrMsg, userId, xUser.getRoleids().toString(), Integer.valueOf(areaId), Byte.valueOf(((AqDoUpdateMoneyReq)((IDIPPacket_AqDoUpdateMoneyReq)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoUpdateMoneyReq)((IDIPPacket_AqDoUpdateMoneyReq)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).req).body).RoleId, Byte.valueOf(((AqDoUpdateMoneyReq)((IDIPPacket_AqDoUpdateMoneyReq)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).req).body).Type), Integer.valueOf(((AqDoUpdateMoneyReq)((IDIPPacket_AqDoUpdateMoneyReq)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).req).body).Value), Integer.valueOf(((AqDoUpdateMoneyReq)((IDIPPacket_AqDoUpdateMoneyReq)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).req).body).Source), ((AqDoUpdateMoneyReq)((IDIPPacket_AqDoUpdateMoneyReq)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 115 */       return false;
/*     */     }
/*     */     
/* 118 */     int value = ((AqDoUpdateMoneyReq)((IDIPPacket_AqDoUpdateMoneyReq)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).req).body).Value;
/* 119 */     if (value == 0)
/*     */     {
/* 121 */       ((IDIPPacket_AqDoUpdateMoneyRsp)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).rsp).head.Result = (((AqDoUpdateMoneyRsp)((IDIPPacket_AqDoUpdateMoneyRsp)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).rsp).body).Result = 'ﰄ');
/* 122 */       ((IDIPPacket_AqDoUpdateMoneyRsp)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).rsp).head.RetErrMsg = (((AqDoUpdateMoneyRsp)((IDIPPacket_AqDoUpdateMoneyRsp)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).rsp).body).RetMsg = "money not equal to 0");
/* 123 */       ((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).sendResponse();
/*     */       
/* 125 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoUpdateMoneyReq.handle@update money failed|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|type=%d|value=%d|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_AqDoUpdateMoneyRsp)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).rsp).head.Result), ((IDIPPacket_AqDoUpdateMoneyRsp)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((AqDoUpdateMoneyReq)((IDIPPacket_AqDoUpdateMoneyReq)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoUpdateMoneyReq)((IDIPPacket_AqDoUpdateMoneyReq)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).req).body).RoleId, Byte.valueOf(((AqDoUpdateMoneyReq)((IDIPPacket_AqDoUpdateMoneyReq)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).req).body).Type), Integer.valueOf(((AqDoUpdateMoneyReq)((IDIPPacket_AqDoUpdateMoneyReq)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).req).body).Value), Integer.valueOf(((AqDoUpdateMoneyReq)((IDIPPacket_AqDoUpdateMoneyReq)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).req).body).Source), ((AqDoUpdateMoneyReq)((IDIPPacket_AqDoUpdateMoneyReq)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 131 */       return false;
/*     */     }
/*     */     
/* 134 */     Role role = RoleInterface.getRole(roleId, true);
/* 135 */     int beginValue = 0;
/* 136 */     int endValue = 0;
/*     */     
/* 138 */     MoneyOperResult result = null;
/* 139 */     if (value >= 0)
/*     */     {
/* 141 */       mzm.gsp.tlog.TLogArg tLogArg = new mzm.gsp.tlog.TLogArg(mzm.gsp.tlog.LogReason.AQIDIP_ADD);
/* 142 */       switch (type)
/*     */       {
/*     */       case 0: 
/* 145 */         beginValue = (int)role.getGold();
/* 146 */         result = RoleInterface.addGoldByAqIDIP(roleId, value, tLogArg);
/* 147 */         endValue = (int)role.getGold();
/* 148 */         break;
/*     */       case 1: 
/* 150 */         beginValue = (int)role.getSilver();
/* 151 */         result = RoleInterface.addSilverByAqIDIP(roleId, value, tLogArg);
/* 152 */         endValue = (int)role.getSilver();
/* 153 */         break;
/*     */       case 2: 
/* 155 */         beginValue = (int)role.getGoldIngot();
/* 156 */         result = RoleInterface.addGoldIngotByAqIDIP(roleId, value, tLogArg);
/* 157 */         endValue = (int)role.getGoldIngot();
/* 158 */         break;
/*     */       
/*     */       }
/*     */       
/*     */     }
/*     */     else
/*     */     {
/* 165 */       mzm.gsp.tlog.TLogArg tLogArg = new mzm.gsp.tlog.TLogArg(mzm.gsp.tlog.LogReason.AQIDIP_REM);
/* 166 */       switch (type)
/*     */       {
/*     */       case 0: 
/* 169 */         beginValue = (int)role.getGold();
/* 170 */         result = RoleInterface.cutGoldByAqIDIP(roleId, -value, tLogArg);
/* 171 */         endValue = (int)role.getGold();
/* 172 */         break;
/*     */       case 1: 
/* 174 */         beginValue = (int)role.getSilver();
/* 175 */         result = RoleInterface.cutSilverByAqIDIP(roleId, -value, tLogArg);
/* 176 */         endValue = (int)role.getSilver();
/* 177 */         break;
/*     */       case 2: 
/* 179 */         beginValue = (int)role.getGoldIngot();
/* 180 */         result = RoleInterface.cutGoldIngotByAqIDIP(roleId, -value, tLogArg);
/* 181 */         endValue = (int)role.getGoldIngot();
/* 182 */         break;
/*     */       }
/*     */       
/*     */     }
/*     */     
/*     */ 
/* 188 */     if ((result != MoneyOperResult.SUCCESS) && (result != MoneyOperResult.MONEY_NUM_REACH_MAX_FOR_AQIDIP) && (result != MoneyOperResult.MONEY_NUM_CLEAR_FOR_AQIDIP))
/*     */     {
/*     */ 
/* 191 */       ((IDIPPacket_AqDoUpdateMoneyRsp)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).rsp).head.Result = (((AqDoUpdateMoneyRsp)((IDIPPacket_AqDoUpdateMoneyRsp)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).rsp).body).Result = result.ret);
/* 192 */       ((IDIPPacket_AqDoUpdateMoneyRsp)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).rsp).head.RetErrMsg = (((AqDoUpdateMoneyRsp)((IDIPPacket_AqDoUpdateMoneyRsp)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).rsp).body).RetMsg = result.retMsg);
/* 193 */       ((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).sendResponse();
/*     */       
/* 195 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_AqDoUpdateMoneyReq.handle@update money failed|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|type=%d|value=%d|source=%d|serial=%s", new Object[] { Integer.valueOf(result.ret), result.retMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((AqDoUpdateMoneyReq)((IDIPPacket_AqDoUpdateMoneyReq)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoUpdateMoneyReq)((IDIPPacket_AqDoUpdateMoneyReq)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).req).body).RoleId, Byte.valueOf(((AqDoUpdateMoneyReq)((IDIPPacket_AqDoUpdateMoneyReq)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).req).body).Type), Integer.valueOf(((AqDoUpdateMoneyReq)((IDIPPacket_AqDoUpdateMoneyReq)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).req).body).Value), Integer.valueOf(((AqDoUpdateMoneyReq)((IDIPPacket_AqDoUpdateMoneyReq)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).req).body).Source), ((AqDoUpdateMoneyReq)((IDIPPacket_AqDoUpdateMoneyReq)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 201 */       return false;
/*     */     }
/*     */     
/* 204 */     ((IDIPPacket_AqDoUpdateMoneyRsp)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).rsp).head.Result = (((AqDoUpdateMoneyRsp)((IDIPPacket_AqDoUpdateMoneyRsp)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).rsp).body).Result = 0);
/* 205 */     ((IDIPPacket_AqDoUpdateMoneyRsp)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).rsp).head.RetErrMsg = (((AqDoUpdateMoneyRsp)((IDIPPacket_AqDoUpdateMoneyRsp)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).rsp).body).RetMsg = result.retMsg);
/* 206 */     ((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).sendResponse();
/*     */     
/* 208 */     StringBuilder logStr = new StringBuilder();
/* 209 */     logStr.append(((IDIPPacket_AqDoUpdateMoneyReq)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).req).head.SendTime).append("|");
/* 210 */     logStr.append(((AqDoUpdateMoneyReq)((IDIPPacket_AqDoUpdateMoneyReq)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).req).body).OpenId).append("|");
/* 211 */     logStr.append(((AqDoUpdateMoneyReq)((IDIPPacket_AqDoUpdateMoneyReq)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).req).body).AreaId).append("|");
/* 212 */     logStr.append(((AqDoUpdateMoneyReq)((IDIPPacket_AqDoUpdateMoneyReq)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).req).body).Partition).append("|");
/* 213 */     logStr.append(0).append("|");
/* 214 */     logStr.append(((AqDoUpdateMoneyReq)((IDIPPacket_AqDoUpdateMoneyReq)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).req).body).Value).append("|");
/* 215 */     logStr.append(((IDIPPacket_AqDoUpdateMoneyReq)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).req).head.Cmdid).append("|");
/* 216 */     logStr.append(((AqDoUpdateMoneyReq)((IDIPPacket_AqDoUpdateMoneyReq)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).req).body).Serial).append("|");
/* 217 */     logStr.append(((AqDoUpdateMoneyReq)((IDIPPacket_AqDoUpdateMoneyReq)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).req).body).Source).append("|");
/* 218 */     logStr.append(beginValue).append("|");
/* 219 */     logStr.append(endValue).append("|");
/* 220 */     logStr.append(result.ret).append("|");
/* 221 */     logStr.append(result.retMsg).append("|");
/* 222 */     logStr.append(roleId);
/*     */     
/* 224 */     mzm.gsp.tlog.TLogManager.getInstance().addLog(roleId, "AqIDIPDoUpdateMoney", logStr.toString());
/*     */     
/* 226 */     GameServer.logger().info(String.format("[idip]PIDIPCmd_AqDoUpdateMoneyReq.handle@update money success|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|partition=%d|open_id=%s|role_id=%s|type=%d|value=%d|source=%d|serial=%s|begin_value=%d|end_value=%d", new Object[] { Integer.valueOf(result.ret), result.retMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((AqDoUpdateMoneyReq)((IDIPPacket_AqDoUpdateMoneyReq)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).req).body).PlatId), Integer.valueOf(partition), openId, ((AqDoUpdateMoneyReq)((IDIPPacket_AqDoUpdateMoneyReq)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).req).body).RoleId, Byte.valueOf(((AqDoUpdateMoneyReq)((IDIPPacket_AqDoUpdateMoneyReq)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).req).body).Type), Integer.valueOf(((AqDoUpdateMoneyReq)((IDIPPacket_AqDoUpdateMoneyReq)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).req).body).Value), Integer.valueOf(((AqDoUpdateMoneyReq)((IDIPPacket_AqDoUpdateMoneyReq)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).req).body).Source), ((AqDoUpdateMoneyReq)((IDIPPacket_AqDoUpdateMoneyReq)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).req).body).Serial, Integer.valueOf(beginValue), Integer.valueOf(endValue) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 232 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   protected String getSerialNo()
/*     */   {
/* 238 */     return ((AqDoUpdateMoneyReq)((IDIPPacket_AqDoUpdateMoneyReq)((IDIPCmd_AqDoUpdateMoneyReq)this.cmd).req).body).Serial;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PIDIPCmd_AqDoUpdateMoneyReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
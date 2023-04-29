/*     */ package mzm.gsp.idip.main;
/*     */ 
/*     */ import idip.DoUpdateMoneyReq;
/*     */ import idip.DoUpdateMoneyRsp;
/*     */ import idip.IDIPCmd_DoUpdateMoneyReq;
/*     */ import idip.IDIPPacket_DoUpdateMoneyReq;
/*     */ import idip.IDIPPacket_DoUpdateMoneyRsp;
/*     */ import idip.core.IdipHeader;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.role.main.MoneyOperResult;
/*     */ import mzm.gsp.role.main.Role;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class PIDIPCmd_DoUpdateMoneyReq extends PIDIPCmd<IDIPCmd_DoUpdateMoneyReq>
/*     */ {
/*     */   public PIDIPCmd_DoUpdateMoneyReq(IDIPCmd_DoUpdateMoneyReq cmd)
/*     */   {
/*  22 */     super(cmd);
/*     */   }
/*     */   
/*     */   protected boolean handle()
/*     */     throws Exception
/*     */   {
/*  28 */     String openId = ((DoUpdateMoneyReq)((IDIPPacket_DoUpdateMoneyReq)((IDIPCmd_DoUpdateMoneyReq)this.cmd).req).body).OpenId;
/*  29 */     int areaId = ((DoUpdateMoneyReq)((IDIPPacket_DoUpdateMoneyReq)((IDIPCmd_DoUpdateMoneyReq)this.cmd).req).body).AreaId;
/*  30 */     int partition = ((DoUpdateMoneyReq)((IDIPPacket_DoUpdateMoneyReq)((IDIPCmd_DoUpdateMoneyReq)this.cmd).req).body).Partition;
/*     */     
/*  32 */     String userId = idip.core.Utils.getUserId(openId, areaId, partition);
/*  33 */     xbean.User xUser = xtable.User.get(userId);
/*  34 */     if (null == xUser)
/*     */     {
/*  36 */       ((IDIPPacket_DoUpdateMoneyRsp)((IDIPCmd_DoUpdateMoneyReq)this.cmd).rsp).head.Result = 1;
/*  37 */       ((IDIPPacket_DoUpdateMoneyRsp)((IDIPCmd_DoUpdateMoneyReq)this.cmd).rsp).head.RetErrMsg = "query userid empty";
/*  38 */       ((IDIPCmd_DoUpdateMoneyReq)this.cmd).sendResponse();
/*     */       
/*  40 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoUpdateMoneyReq.handle@user not found|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|source=%d|role_id=%s|value=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoUpdateMoneyRsp)((IDIPCmd_DoUpdateMoneyReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoUpdateMoneyRsp)((IDIPCmd_DoUpdateMoneyReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((DoUpdateMoneyReq)((IDIPPacket_DoUpdateMoneyReq)((IDIPCmd_DoUpdateMoneyReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoUpdateMoneyReq)((IDIPPacket_DoUpdateMoneyReq)((IDIPCmd_DoUpdateMoneyReq)this.cmd).req).body).Source), ((DoUpdateMoneyReq)((IDIPPacket_DoUpdateMoneyReq)((IDIPCmd_DoUpdateMoneyReq)this.cmd).req).body).RoleId, Integer.valueOf(((DoUpdateMoneyReq)((IDIPPacket_DoUpdateMoneyReq)((IDIPCmd_DoUpdateMoneyReq)this.cmd).req).body).Value), ((DoUpdateMoneyReq)((IDIPPacket_DoUpdateMoneyReq)((IDIPCmd_DoUpdateMoneyReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  46 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  50 */     if (((DoUpdateMoneyReq)((IDIPPacket_DoUpdateMoneyReq)((IDIPCmd_DoUpdateMoneyReq)this.cmd).req).body).RoleId.length() > 32)
/*     */     {
/*  52 */       ((IDIPPacket_DoUpdateMoneyRsp)((IDIPCmd_DoUpdateMoneyReq)this.cmd).rsp).head.Result = (((DoUpdateMoneyRsp)((IDIPPacket_DoUpdateMoneyRsp)((IDIPCmd_DoUpdateMoneyReq)this.cmd).rsp).body).Result = 1);
/*  53 */       ((IDIPPacket_DoUpdateMoneyRsp)((IDIPCmd_DoUpdateMoneyReq)this.cmd).rsp).head.RetErrMsg = (((DoUpdateMoneyRsp)((IDIPPacket_DoUpdateMoneyRsp)((IDIPCmd_DoUpdateMoneyReq)this.cmd).rsp).body).RetMsg = String.format("roleid length > %d", new Object[] { Integer.valueOf(32) }));
/*     */       
/*  55 */       ((IDIPCmd_DoUpdateMoneyReq)this.cmd).sendResponse();
/*     */       
/*  57 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoUpdateMoneyReq.handle@roleId length > MAX_ROLEID_LEN|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|source=%d|role_id=%s|value=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoUpdateMoneyRsp)((IDIPCmd_DoUpdateMoneyReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoUpdateMoneyRsp)((IDIPCmd_DoUpdateMoneyReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((DoUpdateMoneyReq)((IDIPPacket_DoUpdateMoneyReq)((IDIPCmd_DoUpdateMoneyReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoUpdateMoneyReq)((IDIPPacket_DoUpdateMoneyReq)((IDIPCmd_DoUpdateMoneyReq)this.cmd).req).body).Source), ((DoUpdateMoneyReq)((IDIPPacket_DoUpdateMoneyReq)((IDIPCmd_DoUpdateMoneyReq)this.cmd).req).body).RoleId, Integer.valueOf(((DoUpdateMoneyReq)((IDIPPacket_DoUpdateMoneyReq)((IDIPCmd_DoUpdateMoneyReq)this.cmd).req).body).Value), ((DoUpdateMoneyReq)((IDIPPacket_DoUpdateMoneyReq)((IDIPCmd_DoUpdateMoneyReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  63 */       return false;
/*     */     }
/*     */     
/*  66 */     long roleId = -1L;
/*     */     try
/*     */     {
/*  69 */       roleId = Long.parseLong(((DoUpdateMoneyReq)((IDIPPacket_DoUpdateMoneyReq)((IDIPCmd_DoUpdateMoneyReq)this.cmd).req).body).RoleId);
/*     */     }
/*     */     catch (NumberFormatException e)
/*     */     {
/*  73 */       ((IDIPPacket_DoUpdateMoneyRsp)((IDIPCmd_DoUpdateMoneyReq)this.cmd).rsp).head.Result = (((DoUpdateMoneyRsp)((IDIPPacket_DoUpdateMoneyRsp)((IDIPCmd_DoUpdateMoneyReq)this.cmd).rsp).body).Result = 1);
/*  74 */       ((IDIPPacket_DoUpdateMoneyRsp)((IDIPCmd_DoUpdateMoneyReq)this.cmd).rsp).head.RetErrMsg = (((DoUpdateMoneyRsp)((IDIPPacket_DoUpdateMoneyRsp)((IDIPCmd_DoUpdateMoneyReq)this.cmd).rsp).body).RetMsg = "roleid format error");
/*  75 */       ((IDIPCmd_DoUpdateMoneyReq)this.cmd).sendResponse();
/*     */       
/*  77 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoUpdateMoneyReq.handle@role not found|ret=%d|ret_msg=%s|user_id=%s|user_role_list=%s|area_id=%d|plat_id=%d|source=%d|role_id=%s|value=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoUpdateMoneyRsp)((IDIPCmd_DoUpdateMoneyReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoUpdateMoneyRsp)((IDIPCmd_DoUpdateMoneyReq)this.cmd).rsp).head.RetErrMsg, userId, xUser.getRoleids().toString(), Integer.valueOf(areaId), Byte.valueOf(((DoUpdateMoneyReq)((IDIPPacket_DoUpdateMoneyReq)((IDIPCmd_DoUpdateMoneyReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoUpdateMoneyReq)((IDIPPacket_DoUpdateMoneyReq)((IDIPCmd_DoUpdateMoneyReq)this.cmd).req).body).Source), ((DoUpdateMoneyReq)((IDIPPacket_DoUpdateMoneyReq)((IDIPCmd_DoUpdateMoneyReq)this.cmd).req).body).RoleId, Integer.valueOf(((DoUpdateMoneyReq)((IDIPPacket_DoUpdateMoneyReq)((IDIPCmd_DoUpdateMoneyReq)this.cmd).req).body).Value), ((DoUpdateMoneyReq)((IDIPPacket_DoUpdateMoneyReq)((IDIPCmd_DoUpdateMoneyReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  83 */       return false;
/*     */     }
/*     */     
/*  86 */     if ((!RoleInterface.isRoleExist(roleId, true)) || (!xUser.getRoleids().contains(Long.valueOf(roleId))))
/*     */     {
/*  88 */       ((IDIPPacket_DoUpdateMoneyRsp)((IDIPCmd_DoUpdateMoneyReq)this.cmd).rsp).head.Result = 1;
/*  89 */       ((IDIPPacket_DoUpdateMoneyRsp)((IDIPCmd_DoUpdateMoneyReq)this.cmd).rsp).head.RetErrMsg = "query roleid empty";
/*  90 */       ((IDIPCmd_DoUpdateMoneyReq)this.cmd).sendResponse();
/*     */       
/*  92 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoUpdateMoneyReq.handle@role not found|ret=%d|ret_msg=%s|user_id=%s|user_role_list=%s|area_id=%d|plat_id=%d|source=%d|role_id=%d|value=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoUpdateMoneyRsp)((IDIPCmd_DoUpdateMoneyReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoUpdateMoneyRsp)((IDIPCmd_DoUpdateMoneyReq)this.cmd).rsp).head.RetErrMsg, userId, xUser.getRoleids().toString(), Integer.valueOf(areaId), Byte.valueOf(((DoUpdateMoneyReq)((IDIPPacket_DoUpdateMoneyReq)((IDIPCmd_DoUpdateMoneyReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoUpdateMoneyReq)((IDIPPacket_DoUpdateMoneyReq)((IDIPCmd_DoUpdateMoneyReq)this.cmd).req).body).Source), Long.valueOf(roleId), Integer.valueOf(((DoUpdateMoneyReq)((IDIPPacket_DoUpdateMoneyReq)((IDIPCmd_DoUpdateMoneyReq)this.cmd).req).body).Value), ((DoUpdateMoneyReq)((IDIPPacket_DoUpdateMoneyReq)((IDIPCmd_DoUpdateMoneyReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  98 */       return false;
/*     */     }
/* 100 */     Role role = RoleInterface.getRole(roleId, true);
/*     */     
/* 102 */     int beginValue = (int)role.getGold();
/* 103 */     int value = ((DoUpdateMoneyReq)((IDIPPacket_DoUpdateMoneyReq)((IDIPCmd_DoUpdateMoneyReq)this.cmd).req).body).Value;
/*     */     
/* 105 */     MoneyOperResult result = null;
/* 106 */     if (value >= 0)
/*     */     {
/* 108 */       TLogArg tLogArg = new TLogArg(LogReason.IDIP_ADD);
/* 109 */       result = RoleInterface.addGoldByIDIP(roleId, value, tLogArg);
/*     */     }
/*     */     else
/*     */     {
/* 113 */       TLogArg tLogArg = new TLogArg(LogReason.IDIP_REM);
/* 114 */       result = RoleInterface.cutGoldByIDIP(roleId, -value, tLogArg);
/*     */     }
/*     */     
/* 117 */     if (result != MoneyOperResult.SUCCESS)
/*     */     {
/* 119 */       ((IDIPPacket_DoUpdateMoneyRsp)((IDIPCmd_DoUpdateMoneyReq)this.cmd).rsp).head.Result = result.ret;
/* 120 */       ((IDIPPacket_DoUpdateMoneyRsp)((IDIPCmd_DoUpdateMoneyReq)this.cmd).rsp).head.RetErrMsg = result.retMsg;
/* 121 */       ((IDIPCmd_DoUpdateMoneyReq)this.cmd).sendResponse();
/*     */       
/* 123 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoUpdateMoneyReq.handle@update money failed|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|source=%d|role_id=%d|value=%d|serial=%s", new Object[] { Integer.valueOf(result.ret), result.retMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((DoUpdateMoneyReq)((IDIPPacket_DoUpdateMoneyReq)((IDIPCmd_DoUpdateMoneyReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoUpdateMoneyReq)((IDIPPacket_DoUpdateMoneyReq)((IDIPCmd_DoUpdateMoneyReq)this.cmd).req).body).Source), Long.valueOf(roleId), Integer.valueOf(((DoUpdateMoneyReq)((IDIPPacket_DoUpdateMoneyReq)((IDIPCmd_DoUpdateMoneyReq)this.cmd).req).body).Value), ((DoUpdateMoneyReq)((IDIPPacket_DoUpdateMoneyReq)((IDIPCmd_DoUpdateMoneyReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 128 */       return false;
/*     */     }
/*     */     
/* 131 */     ((DoUpdateMoneyRsp)((IDIPPacket_DoUpdateMoneyRsp)((IDIPCmd_DoUpdateMoneyReq)this.cmd).rsp).body).BeginValue = beginValue;
/* 132 */     ((DoUpdateMoneyRsp)((IDIPPacket_DoUpdateMoneyRsp)((IDIPCmd_DoUpdateMoneyReq)this.cmd).rsp).body).EndValue = ((int)role.getGold());
/* 133 */     ((IDIPPacket_DoUpdateMoneyRsp)((IDIPCmd_DoUpdateMoneyReq)this.cmd).rsp).head.Result = 0;
/* 134 */     ((IDIPPacket_DoUpdateMoneyRsp)((IDIPCmd_DoUpdateMoneyReq)this.cmd).rsp).head.RetErrMsg = "ok";
/* 135 */     ((IDIPCmd_DoUpdateMoneyReq)this.cmd).sendResponse();
/*     */     
/* 137 */     StringBuilder logStr = new StringBuilder();
/*     */     
/* 139 */     logStr.append(((IDIPPacket_DoUpdateMoneyReq)((IDIPCmd_DoUpdateMoneyReq)this.cmd).req).head.SendTime).append("|");
/* 140 */     logStr.append(((DoUpdateMoneyReq)((IDIPPacket_DoUpdateMoneyReq)((IDIPCmd_DoUpdateMoneyReq)this.cmd).req).body).OpenId).append("|");
/* 141 */     logStr.append(((DoUpdateMoneyReq)((IDIPPacket_DoUpdateMoneyReq)((IDIPCmd_DoUpdateMoneyReq)this.cmd).req).body).AreaId).append("|");
/* 142 */     logStr.append(((DoUpdateMoneyReq)((IDIPPacket_DoUpdateMoneyReq)((IDIPCmd_DoUpdateMoneyReq)this.cmd).req).body).Partition).append("|");
/* 143 */     logStr.append(0).append("|");
/* 144 */     logStr.append(((DoUpdateMoneyReq)((IDIPPacket_DoUpdateMoneyReq)((IDIPCmd_DoUpdateMoneyReq)this.cmd).req).body).Value).append("|");
/* 145 */     logStr.append(((IDIPPacket_DoUpdateMoneyReq)((IDIPCmd_DoUpdateMoneyReq)this.cmd).req).head.Cmdid).append("|");
/* 146 */     logStr.append(((DoUpdateMoneyReq)((IDIPPacket_DoUpdateMoneyReq)((IDIPCmd_DoUpdateMoneyReq)this.cmd).req).body).Serial).append("|");
/* 147 */     logStr.append(((DoUpdateMoneyReq)((IDIPPacket_DoUpdateMoneyReq)((IDIPCmd_DoUpdateMoneyReq)this.cmd).req).body).Source).append("|");
/* 148 */     logStr.append(((DoUpdateMoneyRsp)((IDIPPacket_DoUpdateMoneyRsp)((IDIPCmd_DoUpdateMoneyReq)this.cmd).rsp).body).BeginValue).append("|");
/* 149 */     logStr.append(((DoUpdateMoneyRsp)((IDIPPacket_DoUpdateMoneyRsp)((IDIPCmd_DoUpdateMoneyReq)this.cmd).rsp).body).EndValue).append("|");
/* 150 */     logStr.append(result.ret).append("|");
/* 151 */     logStr.append(result.retMsg).append("|");
/* 152 */     logStr.append(roleId);
/*     */     
/* 154 */     TLogManager.getInstance().addLog(roleId, "IDIPDoUpdateMoney", logStr.toString());
/*     */     
/* 156 */     GameServer.logger().info(String.format("[idip]PIDIPCmd_DoUpdateMoneyReq.handle@update money success|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|source=%d|role_id=%d|value=%d|serial=%s|begin_value=%d|end_value=%d", new Object[] { Integer.valueOf(((IDIPPacket_DoUpdateMoneyRsp)((IDIPCmd_DoUpdateMoneyReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoUpdateMoneyRsp)((IDIPCmd_DoUpdateMoneyReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((DoUpdateMoneyReq)((IDIPPacket_DoUpdateMoneyReq)((IDIPCmd_DoUpdateMoneyReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoUpdateMoneyReq)((IDIPPacket_DoUpdateMoneyReq)((IDIPCmd_DoUpdateMoneyReq)this.cmd).req).body).Source), Long.valueOf(roleId), Integer.valueOf(value), ((DoUpdateMoneyReq)((IDIPPacket_DoUpdateMoneyReq)((IDIPCmd_DoUpdateMoneyReq)this.cmd).req).body).Serial, Integer.valueOf(((DoUpdateMoneyRsp)((IDIPPacket_DoUpdateMoneyRsp)((IDIPCmd_DoUpdateMoneyReq)this.cmd).rsp).body).BeginValue), Integer.valueOf(((DoUpdateMoneyRsp)((IDIPPacket_DoUpdateMoneyRsp)((IDIPCmd_DoUpdateMoneyReq)this.cmd).rsp).body).EndValue) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 162 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   protected String getSerialNo()
/*     */   {
/* 168 */     return ((DoUpdateMoneyReq)((IDIPPacket_DoUpdateMoneyReq)((IDIPCmd_DoUpdateMoneyReq)this.cmd).req).body).Serial;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PIDIPCmd_DoUpdateMoneyReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
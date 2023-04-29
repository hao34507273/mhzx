/*     */ package mzm.gsp.idip.main;
/*     */ 
/*     */ import idip.DoUpdateGoldReq;
/*     */ import idip.DoUpdateGoldRsp;
/*     */ import idip.IDIPCmd_DoUpdateGoldReq;
/*     */ import idip.IDIPPacket_DoUpdateGoldReq;
/*     */ import idip.IDIPPacket_DoUpdateGoldRsp;
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
/*     */ public class PIDIPCmd_DoUpdateGoldIngotReq extends PIDIPCmd<IDIPCmd_DoUpdateGoldReq>
/*     */ {
/*     */   public PIDIPCmd_DoUpdateGoldIngotReq(IDIPCmd_DoUpdateGoldReq cmd)
/*     */   {
/*  22 */     super(cmd);
/*     */   }
/*     */   
/*     */   protected boolean handle()
/*     */     throws Exception
/*     */   {
/*  28 */     String openId = ((DoUpdateGoldReq)((IDIPPacket_DoUpdateGoldReq)((IDIPCmd_DoUpdateGoldReq)this.cmd).req).body).OpenId;
/*  29 */     int areaId = ((DoUpdateGoldReq)((IDIPPacket_DoUpdateGoldReq)((IDIPCmd_DoUpdateGoldReq)this.cmd).req).body).AreaId;
/*  30 */     int partition = ((DoUpdateGoldReq)((IDIPPacket_DoUpdateGoldReq)((IDIPCmd_DoUpdateGoldReq)this.cmd).req).body).Partition;
/*     */     
/*  32 */     String userId = idip.core.Utils.getUserId(openId, areaId, partition);
/*  33 */     xbean.User xUser = xtable.User.get(userId);
/*  34 */     if (null == xUser)
/*     */     {
/*  36 */       ((IDIPPacket_DoUpdateGoldRsp)((IDIPCmd_DoUpdateGoldReq)this.cmd).rsp).head.Result = 1;
/*  37 */       ((IDIPPacket_DoUpdateGoldRsp)((IDIPCmd_DoUpdateGoldReq)this.cmd).rsp).head.RetErrMsg = "query userid empty";
/*  38 */       ((IDIPCmd_DoUpdateGoldReq)this.cmd).sendResponse();
/*     */       
/*  40 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoUpdateGoldIngotReq.handle@user not found|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|source=%d|role_id=%s|value=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoUpdateGoldRsp)((IDIPCmd_DoUpdateGoldReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoUpdateGoldRsp)((IDIPCmd_DoUpdateGoldReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((DoUpdateGoldReq)((IDIPPacket_DoUpdateGoldReq)((IDIPCmd_DoUpdateGoldReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoUpdateGoldReq)((IDIPPacket_DoUpdateGoldReq)((IDIPCmd_DoUpdateGoldReq)this.cmd).req).body).Source), ((DoUpdateGoldReq)((IDIPPacket_DoUpdateGoldReq)((IDIPCmd_DoUpdateGoldReq)this.cmd).req).body).RoleId, Integer.valueOf(((DoUpdateGoldReq)((IDIPPacket_DoUpdateGoldReq)((IDIPCmd_DoUpdateGoldReq)this.cmd).req).body).Value), ((DoUpdateGoldReq)((IDIPPacket_DoUpdateGoldReq)((IDIPCmd_DoUpdateGoldReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  46 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  50 */     if (((DoUpdateGoldReq)((IDIPPacket_DoUpdateGoldReq)((IDIPCmd_DoUpdateGoldReq)this.cmd).req).body).RoleId.length() > 32)
/*     */     {
/*  52 */       ((IDIPPacket_DoUpdateGoldRsp)((IDIPCmd_DoUpdateGoldReq)this.cmd).rsp).head.Result = (((DoUpdateGoldRsp)((IDIPPacket_DoUpdateGoldRsp)((IDIPCmd_DoUpdateGoldReq)this.cmd).rsp).body).Result = 1);
/*  53 */       ((IDIPPacket_DoUpdateGoldRsp)((IDIPCmd_DoUpdateGoldReq)this.cmd).rsp).head.RetErrMsg = (((DoUpdateGoldRsp)((IDIPPacket_DoUpdateGoldRsp)((IDIPCmd_DoUpdateGoldReq)this.cmd).rsp).body).RetMsg = String.format("roleid length > %d", new Object[] { Integer.valueOf(32) }));
/*     */       
/*  55 */       ((IDIPCmd_DoUpdateGoldReq)this.cmd).sendResponse();
/*     */       
/*  57 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoUpdateGoldIngotReq.handle@roleId length > MAX_ROLEID_LEN|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|source=%d|role_id=%s|value=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoUpdateGoldRsp)((IDIPCmd_DoUpdateGoldReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoUpdateGoldRsp)((IDIPCmd_DoUpdateGoldReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((DoUpdateGoldReq)((IDIPPacket_DoUpdateGoldReq)((IDIPCmd_DoUpdateGoldReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoUpdateGoldReq)((IDIPPacket_DoUpdateGoldReq)((IDIPCmd_DoUpdateGoldReq)this.cmd).req).body).Source), ((DoUpdateGoldReq)((IDIPPacket_DoUpdateGoldReq)((IDIPCmd_DoUpdateGoldReq)this.cmd).req).body).RoleId, Integer.valueOf(((DoUpdateGoldReq)((IDIPPacket_DoUpdateGoldReq)((IDIPCmd_DoUpdateGoldReq)this.cmd).req).body).Value), ((DoUpdateGoldReq)((IDIPPacket_DoUpdateGoldReq)((IDIPCmd_DoUpdateGoldReq)this.cmd).req).body).Serial }));
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
/*  69 */       roleId = Long.parseLong(((DoUpdateGoldReq)((IDIPPacket_DoUpdateGoldReq)((IDIPCmd_DoUpdateGoldReq)this.cmd).req).body).RoleId);
/*     */     }
/*     */     catch (NumberFormatException e)
/*     */     {
/*  73 */       ((IDIPPacket_DoUpdateGoldRsp)((IDIPCmd_DoUpdateGoldReq)this.cmd).rsp).head.Result = (((DoUpdateGoldRsp)((IDIPPacket_DoUpdateGoldRsp)((IDIPCmd_DoUpdateGoldReq)this.cmd).rsp).body).Result = 1);
/*  74 */       ((IDIPPacket_DoUpdateGoldRsp)((IDIPCmd_DoUpdateGoldReq)this.cmd).rsp).head.RetErrMsg = (((DoUpdateGoldRsp)((IDIPPacket_DoUpdateGoldRsp)((IDIPCmd_DoUpdateGoldReq)this.cmd).rsp).body).RetMsg = "roleid format error");
/*  75 */       ((IDIPCmd_DoUpdateGoldReq)this.cmd).sendResponse();
/*     */       
/*  77 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoUpdateGoldIngotReq.handle@role not found|ret=%d|ret_msg=%s|user_id=%s|user_role_list=%s|area_id=%d|plat_id=%d|source=%d|role_id=%s|value=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoUpdateGoldRsp)((IDIPCmd_DoUpdateGoldReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoUpdateGoldRsp)((IDIPCmd_DoUpdateGoldReq)this.cmd).rsp).head.RetErrMsg, userId, xUser.getRoleids().toString(), Integer.valueOf(areaId), Byte.valueOf(((DoUpdateGoldReq)((IDIPPacket_DoUpdateGoldReq)((IDIPCmd_DoUpdateGoldReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoUpdateGoldReq)((IDIPPacket_DoUpdateGoldReq)((IDIPCmd_DoUpdateGoldReq)this.cmd).req).body).Source), ((DoUpdateGoldReq)((IDIPPacket_DoUpdateGoldReq)((IDIPCmd_DoUpdateGoldReq)this.cmd).req).body).RoleId, Integer.valueOf(((DoUpdateGoldReq)((IDIPPacket_DoUpdateGoldReq)((IDIPCmd_DoUpdateGoldReq)this.cmd).req).body).Value), ((DoUpdateGoldReq)((IDIPPacket_DoUpdateGoldReq)((IDIPCmd_DoUpdateGoldReq)this.cmd).req).body).Serial }));
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
/*  88 */       ((IDIPPacket_DoUpdateGoldRsp)((IDIPCmd_DoUpdateGoldReq)this.cmd).rsp).head.Result = 1;
/*  89 */       ((IDIPPacket_DoUpdateGoldRsp)((IDIPCmd_DoUpdateGoldReq)this.cmd).rsp).head.RetErrMsg = "query roleid empty";
/*  90 */       ((IDIPCmd_DoUpdateGoldReq)this.cmd).sendResponse();
/*     */       
/*  92 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoUpdateGoldIngotReq.handle@role not found|ret=%d|ret_msg=%s|user_id=%s|user_role_list=%s|area_id=%d|plat_id=%d|source=%d|role_id=%d|value=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoUpdateGoldRsp)((IDIPCmd_DoUpdateGoldReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoUpdateGoldRsp)((IDIPCmd_DoUpdateGoldReq)this.cmd).rsp).head.RetErrMsg, userId, xUser.getRoleids().toString(), Integer.valueOf(areaId), Byte.valueOf(((DoUpdateGoldReq)((IDIPPacket_DoUpdateGoldReq)((IDIPCmd_DoUpdateGoldReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoUpdateGoldReq)((IDIPPacket_DoUpdateGoldReq)((IDIPCmd_DoUpdateGoldReq)this.cmd).req).body).Source), Long.valueOf(roleId), Integer.valueOf(((DoUpdateGoldReq)((IDIPPacket_DoUpdateGoldReq)((IDIPCmd_DoUpdateGoldReq)this.cmd).req).body).Value), ((DoUpdateGoldReq)((IDIPPacket_DoUpdateGoldReq)((IDIPCmd_DoUpdateGoldReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  98 */       return false;
/*     */     }
/* 100 */     Role role = RoleInterface.getRole(roleId, true);
/*     */     
/* 102 */     int beginValue = (int)role.getGoldIngot();
/* 103 */     int value = ((DoUpdateGoldReq)((IDIPPacket_DoUpdateGoldReq)((IDIPCmd_DoUpdateGoldReq)this.cmd).req).body).Value;
/*     */     
/* 105 */     MoneyOperResult result = null;
/* 106 */     if (value >= 0)
/*     */     {
/* 108 */       TLogArg tLogArg = new TLogArg(LogReason.IDIP_ADD);
/* 109 */       result = RoleInterface.addGoldIngotByIDIP(roleId, value, tLogArg);
/*     */     }
/*     */     else
/*     */     {
/* 113 */       TLogArg tLogArg = new TLogArg(LogReason.IDIP_REM);
/* 114 */       result = RoleInterface.cutGoldIngotByIDIP(roleId, -value, tLogArg);
/*     */     }
/*     */     
/* 117 */     if (result != MoneyOperResult.SUCCESS)
/*     */     {
/* 119 */       ((IDIPPacket_DoUpdateGoldRsp)((IDIPCmd_DoUpdateGoldReq)this.cmd).rsp).head.Result = result.ret;
/* 120 */       ((IDIPPacket_DoUpdateGoldRsp)((IDIPCmd_DoUpdateGoldReq)this.cmd).rsp).head.RetErrMsg = result.retMsg;
/* 121 */       ((IDIPCmd_DoUpdateGoldReq)this.cmd).sendResponse();
/*     */       
/* 123 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoUpdateGoldIngotReq.handle@update gold ingot failed|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|source=%d|role_id=%d|value=%d|serial=%s", new Object[] { Integer.valueOf(result.ret), result.retMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((DoUpdateGoldReq)((IDIPPacket_DoUpdateGoldReq)((IDIPCmd_DoUpdateGoldReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoUpdateGoldReq)((IDIPPacket_DoUpdateGoldReq)((IDIPCmd_DoUpdateGoldReq)this.cmd).req).body).Source), Long.valueOf(roleId), Integer.valueOf(((DoUpdateGoldReq)((IDIPPacket_DoUpdateGoldReq)((IDIPCmd_DoUpdateGoldReq)this.cmd).req).body).Value), ((DoUpdateGoldReq)((IDIPPacket_DoUpdateGoldReq)((IDIPCmd_DoUpdateGoldReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 128 */       return false;
/*     */     }
/*     */     
/* 131 */     int endValue = (int)role.getGoldIngot();
/*     */     
/* 133 */     ((DoUpdateGoldRsp)((IDIPPacket_DoUpdateGoldRsp)((IDIPCmd_DoUpdateGoldReq)this.cmd).rsp).body).Result = 0;
/* 134 */     ((DoUpdateGoldRsp)((IDIPPacket_DoUpdateGoldRsp)((IDIPCmd_DoUpdateGoldReq)this.cmd).rsp).body).RetMsg = "ok";
/* 135 */     ((DoUpdateGoldRsp)((IDIPPacket_DoUpdateGoldRsp)((IDIPCmd_DoUpdateGoldReq)this.cmd).rsp).body).AgoNum = beginValue;
/* 136 */     ((DoUpdateGoldRsp)((IDIPPacket_DoUpdateGoldRsp)((IDIPCmd_DoUpdateGoldReq)this.cmd).rsp).body).NowNum = endValue;
/* 137 */     ((IDIPCmd_DoUpdateGoldReq)this.cmd).sendResponse();
/*     */     
/* 139 */     StringBuilder logStr = new StringBuilder();
/*     */     
/* 141 */     logStr.append(((IDIPPacket_DoUpdateGoldReq)((IDIPCmd_DoUpdateGoldReq)this.cmd).req).head.SendTime).append("|");
/* 142 */     logStr.append(((DoUpdateGoldReq)((IDIPPacket_DoUpdateGoldReq)((IDIPCmd_DoUpdateGoldReq)this.cmd).req).body).OpenId).append("|");
/* 143 */     logStr.append(((DoUpdateGoldReq)((IDIPPacket_DoUpdateGoldReq)((IDIPCmd_DoUpdateGoldReq)this.cmd).req).body).AreaId).append("|");
/* 144 */     logStr.append(((DoUpdateGoldReq)((IDIPPacket_DoUpdateGoldReq)((IDIPCmd_DoUpdateGoldReq)this.cmd).req).body).Partition).append("|");
/* 145 */     logStr.append(roleId).append("|");
/* 146 */     logStr.append(0).append("|");
/* 147 */     logStr.append(((DoUpdateGoldReq)((IDIPPacket_DoUpdateGoldReq)((IDIPCmd_DoUpdateGoldReq)this.cmd).req).body).Value).append("|");
/* 148 */     logStr.append(((IDIPPacket_DoUpdateGoldReq)((IDIPCmd_DoUpdateGoldReq)this.cmd).req).head.Cmdid).append("|");
/* 149 */     logStr.append(((DoUpdateGoldReq)((IDIPPacket_DoUpdateGoldReq)((IDIPCmd_DoUpdateGoldReq)this.cmd).req).body).Serial).append("|");
/* 150 */     logStr.append(((DoUpdateGoldReq)((IDIPPacket_DoUpdateGoldReq)((IDIPCmd_DoUpdateGoldReq)this.cmd).req).body).Source).append("|");
/* 151 */     logStr.append(beginValue).append("|");
/* 152 */     logStr.append(endValue).append("|");
/* 153 */     logStr.append(result.ret).append("|");
/* 154 */     logStr.append(result.retMsg);
/*     */     
/* 156 */     TLogManager.getInstance().addLog(roleId, "IDIPDoUpdateGoldIngot", logStr.toString());
/*     */     
/* 158 */     GameServer.logger().info(String.format("[idip]PIDIPCmd_DoUpdateMoneyReq.handle@update gold ingot success|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|source=%d|role_id=%d|value=%d|serial=%s|begin_value=%d|end_value=%d", new Object[] { Integer.valueOf(((IDIPPacket_DoUpdateGoldRsp)((IDIPCmd_DoUpdateGoldReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoUpdateGoldRsp)((IDIPCmd_DoUpdateGoldReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((DoUpdateGoldReq)((IDIPPacket_DoUpdateGoldReq)((IDIPCmd_DoUpdateGoldReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoUpdateGoldReq)((IDIPPacket_DoUpdateGoldReq)((IDIPCmd_DoUpdateGoldReq)this.cmd).req).body).Source), Long.valueOf(roleId), Integer.valueOf(value), ((DoUpdateGoldReq)((IDIPPacket_DoUpdateGoldReq)((IDIPCmd_DoUpdateGoldReq)this.cmd).req).body).Serial, Integer.valueOf(beginValue), Integer.valueOf(endValue) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 163 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   protected String getSerialNo()
/*     */   {
/* 169 */     return ((DoUpdateGoldReq)((IDIPPacket_DoUpdateGoldReq)((IDIPCmd_DoUpdateGoldReq)this.cmd).req).body).Serial;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PIDIPCmd_DoUpdateGoldIngotReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
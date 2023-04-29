/*     */ package mzm.gsp.idip.main;
/*     */ 
/*     */ import idip.DoUpdateVitalityReq;
/*     */ import idip.DoUpdateVitalityRsp;
/*     */ import idip.IDIPCmd_DoUpdateVitalityReq;
/*     */ import idip.IDIPPacket_DoUpdateVitalityReq;
/*     */ import idip.IDIPPacket_DoUpdateVitalityRsp;
/*     */ import idip.core.IdipHeader;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.role.main.Role;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.role.main.VigorOperResult;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class PIDIPCmd_DoUpdateVitalityReq extends PIDIPCmd<IDIPCmd_DoUpdateVitalityReq>
/*     */ {
/*     */   public PIDIPCmd_DoUpdateVitalityReq(IDIPCmd_DoUpdateVitalityReq cmd)
/*     */   {
/*  22 */     super(cmd);
/*     */   }
/*     */   
/*     */   protected boolean handle()
/*     */     throws Exception
/*     */   {
/*  28 */     String openId = ((DoUpdateVitalityReq)((IDIPPacket_DoUpdateVitalityReq)((IDIPCmd_DoUpdateVitalityReq)this.cmd).req).body).OpenId;
/*  29 */     int areaId = ((DoUpdateVitalityReq)((IDIPPacket_DoUpdateVitalityReq)((IDIPCmd_DoUpdateVitalityReq)this.cmd).req).body).AreaId;
/*  30 */     int partition = ((DoUpdateVitalityReq)((IDIPPacket_DoUpdateVitalityReq)((IDIPCmd_DoUpdateVitalityReq)this.cmd).req).body).Partition;
/*     */     
/*  32 */     String userId = idip.core.Utils.getUserId(openId, areaId, partition);
/*  33 */     xbean.User xUser = xtable.User.get(userId);
/*  34 */     if (null == xUser)
/*     */     {
/*  36 */       ((IDIPPacket_DoUpdateVitalityRsp)((IDIPCmd_DoUpdateVitalityReq)this.cmd).rsp).head.Result = 1;
/*  37 */       ((IDIPPacket_DoUpdateVitalityRsp)((IDIPCmd_DoUpdateVitalityReq)this.cmd).rsp).head.RetErrMsg = "query userid empty";
/*  38 */       ((IDIPCmd_DoUpdateVitalityReq)this.cmd).sendResponse();
/*     */       
/*  40 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoUpdateVitalityReq.handle@user not found|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|role_id=%s|value=%d|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoUpdateVitalityRsp)((IDIPCmd_DoUpdateVitalityReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoUpdateVitalityRsp)((IDIPCmd_DoUpdateVitalityReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), ((DoUpdateVitalityReq)((IDIPPacket_DoUpdateVitalityReq)((IDIPCmd_DoUpdateVitalityReq)this.cmd).req).body).RoleId, Integer.valueOf(((DoUpdateVitalityReq)((IDIPPacket_DoUpdateVitalityReq)((IDIPCmd_DoUpdateVitalityReq)this.cmd).req).body).Value), Integer.valueOf(((DoUpdateVitalityReq)((IDIPPacket_DoUpdateVitalityReq)((IDIPCmd_DoUpdateVitalityReq)this.cmd).req).body).Source), ((DoUpdateVitalityReq)((IDIPPacket_DoUpdateVitalityReq)((IDIPCmd_DoUpdateVitalityReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  45 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  49 */     if (((DoUpdateVitalityReq)((IDIPPacket_DoUpdateVitalityReq)((IDIPCmd_DoUpdateVitalityReq)this.cmd).req).body).RoleId.length() > 32)
/*     */     {
/*  51 */       ((IDIPPacket_DoUpdateVitalityRsp)((IDIPCmd_DoUpdateVitalityReq)this.cmd).rsp).head.Result = (((DoUpdateVitalityRsp)((IDIPPacket_DoUpdateVitalityRsp)((IDIPCmd_DoUpdateVitalityReq)this.cmd).rsp).body).Result = 1);
/*  52 */       ((IDIPPacket_DoUpdateVitalityRsp)((IDIPCmd_DoUpdateVitalityReq)this.cmd).rsp).head.RetErrMsg = (((DoUpdateVitalityRsp)((IDIPPacket_DoUpdateVitalityRsp)((IDIPCmd_DoUpdateVitalityReq)this.cmd).rsp).body).RetMsg = String.format("roleid length > %d", new Object[] { Integer.valueOf(32) }));
/*     */       
/*  54 */       ((IDIPCmd_DoUpdateVitalityReq)this.cmd).sendResponse();
/*     */       
/*  56 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoUpdateVitalityReq.handle@roleId length > MAX_ROLEID_LEN|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|role_id=%s|value=%d|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoUpdateVitalityRsp)((IDIPCmd_DoUpdateVitalityReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoUpdateVitalityRsp)((IDIPCmd_DoUpdateVitalityReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), ((DoUpdateVitalityReq)((IDIPPacket_DoUpdateVitalityReq)((IDIPCmd_DoUpdateVitalityReq)this.cmd).req).body).RoleId, Integer.valueOf(((DoUpdateVitalityReq)((IDIPPacket_DoUpdateVitalityReq)((IDIPCmd_DoUpdateVitalityReq)this.cmd).req).body).Value), Integer.valueOf(((DoUpdateVitalityReq)((IDIPPacket_DoUpdateVitalityReq)((IDIPCmd_DoUpdateVitalityReq)this.cmd).req).body).Source), ((DoUpdateVitalityReq)((IDIPPacket_DoUpdateVitalityReq)((IDIPCmd_DoUpdateVitalityReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  61 */       return false;
/*     */     }
/*     */     
/*  64 */     long roleId = -1L;
/*     */     try
/*     */     {
/*  67 */       roleId = Long.parseLong(((DoUpdateVitalityReq)((IDIPPacket_DoUpdateVitalityReq)((IDIPCmd_DoUpdateVitalityReq)this.cmd).req).body).RoleId);
/*     */     }
/*     */     catch (NumberFormatException e)
/*     */     {
/*  71 */       ((IDIPPacket_DoUpdateVitalityRsp)((IDIPCmd_DoUpdateVitalityReq)this.cmd).rsp).head.Result = (((DoUpdateVitalityRsp)((IDIPPacket_DoUpdateVitalityRsp)((IDIPCmd_DoUpdateVitalityReq)this.cmd).rsp).body).Result = 1);
/*  72 */       ((IDIPPacket_DoUpdateVitalityRsp)((IDIPCmd_DoUpdateVitalityReq)this.cmd).rsp).head.RetErrMsg = (((DoUpdateVitalityRsp)((IDIPPacket_DoUpdateVitalityRsp)((IDIPCmd_DoUpdateVitalityReq)this.cmd).rsp).body).RetMsg = "roleid format error");
/*  73 */       ((IDIPCmd_DoUpdateVitalityReq)this.cmd).sendResponse();
/*     */       
/*  75 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoUpdateVitalityReq.handle@role not found|ret=%d|ret_msg=%s|user_id=%s|user_role_list=%s|area_id=%d|role_id=%s|value=%d|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoUpdateVitalityRsp)((IDIPCmd_DoUpdateVitalityReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoUpdateVitalityRsp)((IDIPCmd_DoUpdateVitalityReq)this.cmd).rsp).head.RetErrMsg, userId, xUser.getRoleids().toString(), Integer.valueOf(areaId), ((DoUpdateVitalityReq)((IDIPPacket_DoUpdateVitalityReq)((IDIPCmd_DoUpdateVitalityReq)this.cmd).req).body).RoleId, Integer.valueOf(((DoUpdateVitalityReq)((IDIPPacket_DoUpdateVitalityReq)((IDIPCmd_DoUpdateVitalityReq)this.cmd).req).body).Value), Integer.valueOf(((DoUpdateVitalityReq)((IDIPPacket_DoUpdateVitalityReq)((IDIPCmd_DoUpdateVitalityReq)this.cmd).req).body).Source), ((DoUpdateVitalityReq)((IDIPPacket_DoUpdateVitalityReq)((IDIPCmd_DoUpdateVitalityReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  81 */       return false;
/*     */     }
/*     */     
/*  84 */     if ((!RoleInterface.isRoleExist(roleId, true)) || (!xUser.getRoleids().contains(Long.valueOf(roleId))))
/*     */     {
/*  86 */       ((IDIPPacket_DoUpdateVitalityRsp)((IDIPCmd_DoUpdateVitalityReq)this.cmd).rsp).head.Result = 1;
/*  87 */       ((IDIPPacket_DoUpdateVitalityRsp)((IDIPCmd_DoUpdateVitalityReq)this.cmd).rsp).head.RetErrMsg = "query roleid empty";
/*  88 */       ((IDIPCmd_DoUpdateVitalityReq)this.cmd).sendResponse();
/*     */       
/*  90 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoUpdateVitalityReq.handle@role not found|ret=%d|ret_msg=%s|user_id=%s|user_role_list=%s|area_id=%d|role_id=%d|value=%d|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoUpdateVitalityRsp)((IDIPCmd_DoUpdateVitalityReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoUpdateVitalityRsp)((IDIPCmd_DoUpdateVitalityReq)this.cmd).rsp).head.RetErrMsg, userId, xUser.getRoleids().toString(), Integer.valueOf(areaId), Long.valueOf(roleId), Integer.valueOf(((DoUpdateVitalityReq)((IDIPPacket_DoUpdateVitalityReq)((IDIPCmd_DoUpdateVitalityReq)this.cmd).req).body).Value), Integer.valueOf(((DoUpdateVitalityReq)((IDIPPacket_DoUpdateVitalityReq)((IDIPCmd_DoUpdateVitalityReq)this.cmd).req).body).Source), ((DoUpdateVitalityReq)((IDIPPacket_DoUpdateVitalityReq)((IDIPCmd_DoUpdateVitalityReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  95 */       return false;
/*     */     }
/*     */     
/*  98 */     int value = ((DoUpdateVitalityReq)((IDIPPacket_DoUpdateVitalityReq)((IDIPCmd_DoUpdateVitalityReq)this.cmd).req).body).Value;
/*  99 */     Role role = RoleInterface.getRole(roleId, true);
/* 100 */     int beginValue = role.getVigor();
/*     */     
/* 102 */     VigorOperResult result = null;
/* 103 */     if (value >= 0)
/*     */     {
/* 105 */       TLogArg tLogArg = new TLogArg(LogReason.IDIP_ADD);
/* 106 */       result = RoleInterface.addVigorByIDIP(roleId, value, tLogArg);
/*     */     }
/*     */     else
/*     */     {
/* 110 */       TLogArg tLogArg = new TLogArg(LogReason.IDIP_REM);
/* 111 */       result = RoleInterface.cutVigorByIDIP(roleId, -value, tLogArg);
/*     */     }
/*     */     
/* 114 */     if (result != VigorOperResult.SUCCESS)
/*     */     {
/* 116 */       ((IDIPPacket_DoUpdateVitalityRsp)((IDIPCmd_DoUpdateVitalityReq)this.cmd).rsp).head.Result = result.ret;
/* 117 */       ((IDIPPacket_DoUpdateVitalityRsp)((IDIPCmd_DoUpdateVitalityReq)this.cmd).rsp).head.RetErrMsg = result.retMsg;
/* 118 */       ((IDIPCmd_DoUpdateVitalityReq)this.cmd).sendResponse();
/*     */       
/* 120 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoUpdateVitalityReq.handle@update vigor failed|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|source=%d|role_id=%d|value=%d|serial=%s", new Object[] { Integer.valueOf(result.ret), result.retMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((DoUpdateVitalityReq)((IDIPPacket_DoUpdateVitalityReq)((IDIPCmd_DoUpdateVitalityReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoUpdateVitalityReq)((IDIPPacket_DoUpdateVitalityReq)((IDIPCmd_DoUpdateVitalityReq)this.cmd).req).body).Source), Long.valueOf(roleId), Integer.valueOf(((DoUpdateVitalityReq)((IDIPPacket_DoUpdateVitalityReq)((IDIPCmd_DoUpdateVitalityReq)this.cmd).req).body).Value), ((DoUpdateVitalityReq)((IDIPPacket_DoUpdateVitalityReq)((IDIPCmd_DoUpdateVitalityReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 125 */       return false;
/*     */     }
/*     */     
/* 128 */     ((DoUpdateVitalityRsp)((IDIPPacket_DoUpdateVitalityRsp)((IDIPCmd_DoUpdateVitalityReq)this.cmd).rsp).body).BeginValue = beginValue;
/* 129 */     ((DoUpdateVitalityRsp)((IDIPPacket_DoUpdateVitalityRsp)((IDIPCmd_DoUpdateVitalityReq)this.cmd).rsp).body).EndValue = role.getVigor();
/* 130 */     ((IDIPPacket_DoUpdateVitalityRsp)((IDIPCmd_DoUpdateVitalityReq)this.cmd).rsp).head.Result = 0;
/* 131 */     ((IDIPPacket_DoUpdateVitalityRsp)((IDIPCmd_DoUpdateVitalityReq)this.cmd).rsp).head.RetErrMsg = "ok";
/* 132 */     ((IDIPCmd_DoUpdateVitalityReq)this.cmd).sendResponse();
/*     */     
/* 134 */     StringBuilder logStr = new StringBuilder();
/*     */     
/* 136 */     logStr.append(((IDIPPacket_DoUpdateVitalityReq)((IDIPCmd_DoUpdateVitalityReq)this.cmd).req).head.SendTime).append("|");
/* 137 */     logStr.append(((DoUpdateVitalityReq)((IDIPPacket_DoUpdateVitalityReq)((IDIPCmd_DoUpdateVitalityReq)this.cmd).req).body).OpenId).append("|");
/* 138 */     logStr.append(((DoUpdateVitalityReq)((IDIPPacket_DoUpdateVitalityReq)((IDIPCmd_DoUpdateVitalityReq)this.cmd).req).body).AreaId).append("|");
/* 139 */     logStr.append(((DoUpdateVitalityReq)((IDIPPacket_DoUpdateVitalityReq)((IDIPCmd_DoUpdateVitalityReq)this.cmd).req).body).Partition).append("|");
/* 140 */     logStr.append(0).append("|");
/* 141 */     logStr.append(((DoUpdateVitalityReq)((IDIPPacket_DoUpdateVitalityReq)((IDIPCmd_DoUpdateVitalityReq)this.cmd).req).body).Value).append("|");
/* 142 */     logStr.append(((IDIPPacket_DoUpdateVitalityReq)((IDIPCmd_DoUpdateVitalityReq)this.cmd).req).head.Cmdid).append("|");
/* 143 */     logStr.append(((DoUpdateVitalityReq)((IDIPPacket_DoUpdateVitalityReq)((IDIPCmd_DoUpdateVitalityReq)this.cmd).req).body).Serial).append("|");
/* 144 */     logStr.append(((DoUpdateVitalityReq)((IDIPPacket_DoUpdateVitalityReq)((IDIPCmd_DoUpdateVitalityReq)this.cmd).req).body).Source).append("|");
/* 145 */     logStr.append(((DoUpdateVitalityRsp)((IDIPPacket_DoUpdateVitalityRsp)((IDIPCmd_DoUpdateVitalityReq)this.cmd).rsp).body).BeginValue).append("|");
/* 146 */     logStr.append(((DoUpdateVitalityRsp)((IDIPPacket_DoUpdateVitalityRsp)((IDIPCmd_DoUpdateVitalityReq)this.cmd).rsp).body).EndValue).append("|");
/* 147 */     logStr.append(result.ret).append("|");
/* 148 */     logStr.append(result.retMsg).append("|");
/* 149 */     logStr.append(roleId);
/*     */     
/* 151 */     TLogManager.getInstance().addLog(roleId, "IDIPDoUpdateVitality", logStr.toString());
/*     */     
/* 153 */     GameServer.logger().info(String.format("[idip]PIDIPCmd_DoUpdateVitalityReq.handle@update vigor success|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|source=%d|role_id=%d|value=%d|serial=%s|begin_value=%d|end_value=%d", new Object[] { Integer.valueOf(((IDIPPacket_DoUpdateVitalityRsp)((IDIPCmd_DoUpdateVitalityReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoUpdateVitalityRsp)((IDIPCmd_DoUpdateVitalityReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((DoUpdateVitalityReq)((IDIPPacket_DoUpdateVitalityReq)((IDIPCmd_DoUpdateVitalityReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoUpdateVitalityReq)((IDIPPacket_DoUpdateVitalityReq)((IDIPCmd_DoUpdateVitalityReq)this.cmd).req).body).Source), Long.valueOf(roleId), Integer.valueOf(value), ((DoUpdateVitalityReq)((IDIPPacket_DoUpdateVitalityReq)((IDIPCmd_DoUpdateVitalityReq)this.cmd).req).body).Serial, Integer.valueOf(((DoUpdateVitalityRsp)((IDIPPacket_DoUpdateVitalityRsp)((IDIPCmd_DoUpdateVitalityReq)this.cmd).rsp).body).BeginValue), Integer.valueOf(((DoUpdateVitalityRsp)((IDIPPacket_DoUpdateVitalityRsp)((IDIPCmd_DoUpdateVitalityReq)this.cmd).rsp).body).EndValue) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 159 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   protected String getSerialNo()
/*     */   {
/* 165 */     return ((DoUpdateVitalityReq)((IDIPPacket_DoUpdateVitalityReq)((IDIPCmd_DoUpdateVitalityReq)this.cmd).req).body).Serial;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PIDIPCmd_DoUpdateVitalityReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */